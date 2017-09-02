package com.google.atap.tangocloudstorage;

import android.util.Log;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

class MultipartUploadRequest
  extends Request<Object>
{
  private static final int HTTP_RESUME_INCOMPLETE = 308;
  private static final String TAG = "MultipartUploadRequest";
  private byte[] body;
  private HashMap<String, String> headers;
  private boolean isLastBlock;
  private Response.Listener<Object> listener;
  
  public MultipartUploadRequest(URL paramURL, File paramFile, long paramLong, int paramInt, Response.Listener<Object> paramListener, Response.ErrorListener paramErrorListener)
    throws FileIOException
  {
    super(2, paramURL.toString(), paramErrorListener);
    Log.i("MultipartUploadRequest", "MultipartUploadRequest constructor: = " + paramLong + "/" + paramInt);
    if (paramInt + paramLong > paramFile.length()) {
      throw new IllegalArgumentException("Out of range");
    }
    boolean bool;
    long l;
    if (paramInt + paramLong == paramFile.length())
    {
      bool = true;
      this.isLastBlock = bool;
      this.headers = new HashMap();
      this.headers.put("Content-Length", Integer.toString(paramInt));
      if (paramFile.length() > 0L)
      {
        l = paramInt;
        if (!this.isLastBlock) {
          break label239;
        }
      }
    }
    label239:
    for (paramURL = Long.valueOf(paramFile.length());; paramURL = "*")
    {
      paramURL = String.format("bytes %s-%s/%s", new Object[] { Long.valueOf(paramLong), Long.valueOf(l + paramLong - 1L), paramURL });
      this.headers.put("Content-Range", paramURL);
      this.body = new byte[paramInt];
      try
      {
        paramURL = new RandomAccessFile(paramFile, "r");
        paramURL.seek(paramLong);
        paramURL.readFully(this.body);
        paramURL.close();
        this.listener = paramListener;
        return;
      }
      catch (IOException paramURL)
      {
        throw new FileIOException(paramURL);
      }
      bool = false;
      break;
    }
  }
  
  protected void deliverResponse(Object paramObject)
  {
    this.listener.onResponse(paramObject);
  }
  
  public byte[] getBody()
  {
    return this.body;
  }
  
  public String getBodyContentType()
  {
    return "application/octet-stream";
  }
  
  public Map<String, String> getHeaders()
  {
    return this.headers;
  }
  
  protected Response<Object> parseNetworkResponse(NetworkResponse paramNetworkResponse)
  {
    if (((this.isLastBlock) && (paramNetworkResponse.statusCode == 200)) || ((!this.isLastBlock) && (paramNetworkResponse.statusCode == 308))) {
      return Response.success(new Object(), HttpHeaderParser.parseCacheHeaders(paramNetworkResponse));
    }
    return Response.error(new VolleyError(new ServerException("Invalid status code: " + paramNetworkResponse.statusCode)));
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangocloudstorage/MultipartUploadRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */