package com.google.atap.tangocloudstorage;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

class UploadSessionUrlRequest
  extends Request<URL>
{
  private static final String LOCATION_HEADER_FIELD_NAME = "Location";
  private static final String TAG = "UploadSessionUrlRequest";
  private final Response.Listener<URL> listener;
  
  public UploadSessionUrlRequest(URL paramURL, Response.Listener<URL> paramListener, Response.ErrorListener paramErrorListener)
  {
    super(1, paramURL.toString(), paramErrorListener);
    this.listener = paramListener;
  }
  
  protected void deliverResponse(URL paramURL)
  {
    this.listener.onResponse(paramURL);
  }
  
  public byte[] getBody()
  {
    return new byte[0];
  }
  
  public String getBodyContentType()
  {
    return "application/octet-stream";
  }
  
  public Map<String, String> getHeaders()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("x-goog-resumable", "start");
    return localHashMap;
  }
  
  protected Response<URL> parseNetworkResponse(NetworkResponse paramNetworkResponse)
  {
    if (!paramNetworkResponse.headers.containsKey("Location")) {
      return Response.error(new ParseError(paramNetworkResponse));
    }
    try
    {
      Response localResponse = Response.success(new URL((String)paramNetworkResponse.headers.get("Location")), HttpHeaderParser.parseCacheHeaders(paramNetworkResponse));
      return localResponse;
    }
    catch (MalformedURLException localMalformedURLException) {}
    return Response.error(new ParseError(paramNetworkResponse));
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangocloudstorage/UploadSessionUrlRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */