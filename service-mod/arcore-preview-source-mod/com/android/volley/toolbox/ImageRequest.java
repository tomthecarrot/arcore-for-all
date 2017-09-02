package com.android.volley.toolbox;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Request.Priority;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyLog;

public class ImageRequest
  extends Request<Bitmap>
{
  private static final float IMAGE_BACKOFF_MULT = 2.0F;
  private static final int IMAGE_MAX_RETRIES = 2;
  private static final int IMAGE_TIMEOUT_MS = 1000;
  private static final Object sDecodeLock = new Object();
  private final Bitmap.Config mDecodeConfig;
  private final Response.Listener<Bitmap> mListener;
  private final int mMaxHeight;
  private final int mMaxWidth;
  
  public ImageRequest(String paramString, Response.Listener<Bitmap> paramListener, int paramInt1, int paramInt2, Bitmap.Config paramConfig, Response.ErrorListener paramErrorListener)
  {
    super(0, paramString, paramErrorListener);
    setRetryPolicy(new DefaultRetryPolicy(1000, 2, 2.0F));
    this.mListener = paramListener;
    this.mDecodeConfig = paramConfig;
    this.mMaxWidth = paramInt1;
    this.mMaxHeight = paramInt2;
  }
  
  private Response<Bitmap> doParse(NetworkResponse paramNetworkResponse)
  {
    Object localObject1 = paramNetworkResponse.data;
    Object localObject2 = new BitmapFactory.Options();
    if ((this.mMaxWidth == 0) && (this.mMaxHeight == 0))
    {
      ((BitmapFactory.Options)localObject2).inPreferredConfig = this.mDecodeConfig;
      localObject1 = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length, (BitmapFactory.Options)localObject2);
    }
    while (localObject1 == null)
    {
      return Response.error(new ParseError(paramNetworkResponse));
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length, (BitmapFactory.Options)localObject2);
      int i = ((BitmapFactory.Options)localObject2).outWidth;
      int j = ((BitmapFactory.Options)localObject2).outHeight;
      int k = getResizedDimension(this.mMaxWidth, this.mMaxHeight, i, j);
      int m = getResizedDimension(this.mMaxHeight, this.mMaxWidth, j, i);
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = false;
      ((BitmapFactory.Options)localObject2).inSampleSize = findBestSampleSize(i, j, k, m);
      localObject1 = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length, (BitmapFactory.Options)localObject2);
      if ((localObject1 != null) && ((((Bitmap)localObject1).getWidth() > k) || (((Bitmap)localObject1).getHeight() > m)))
      {
        localObject2 = Bitmap.createScaledBitmap((Bitmap)localObject1, k, m, true);
        ((Bitmap)localObject1).recycle();
        localObject1 = localObject2;
      }
    }
    return Response.success(localObject1, HttpHeaderParser.parseCacheHeaders(paramNetworkResponse));
  }
  
  static int findBestSampleSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    double d = Math.min(paramInt1 / paramInt3, paramInt2 / paramInt4);
    for (float f = 1.0F; 2.0F * f <= d; f *= 2.0F) {}
    return (int)f;
  }
  
  private static int getResizedDimension(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      return paramInt3;
    }
    if (paramInt1 == 0)
    {
      d = paramInt2 / paramInt4;
      return (int)(paramInt3 * d);
    }
    if (paramInt2 == 0) {
      return paramInt1;
    }
    double d = paramInt4 / paramInt3;
    paramInt3 = paramInt1;
    if (paramInt1 * d > paramInt2) {
      paramInt3 = (int)(paramInt2 / d);
    }
    return paramInt3;
  }
  
  protected void deliverResponse(Bitmap paramBitmap)
  {
    this.mListener.onResponse(paramBitmap);
  }
  
  public Request.Priority getPriority()
  {
    return Request.Priority.LOW;
  }
  
  protected Response<Bitmap> parseNetworkResponse(NetworkResponse paramNetworkResponse)
  {
    synchronized (sDecodeLock)
    {
      try
      {
        Response localResponse = doParse(paramNetworkResponse);
        return localResponse;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        VolleyLog.e("Caught OOM for %d byte image, url=%s", new Object[] { Integer.valueOf(paramNetworkResponse.data.length), getUrl() });
        paramNetworkResponse = Response.error(new ParseError(localOutOfMemoryError));
        return paramNetworkResponse;
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/android/volley/toolbox/ImageRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */