package com.google.atap.tango;

import android.app.Service;
import android.content.Intent;
import android.media.Image;
import android.media.Image.Plane;
import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.Surface;
import com.google.atap.tangoservice.ITangoVhs.Stub;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TangoVirtualHalService
  extends Service
{
  private static final int MAX_METADATA_ENTRIES = 10;
  private static Handler mCameraHandler;
  private static HandlerThread mCameraHandlerThread;
  private static ImageReader.OnImageAvailableListener mImageAvailListener;
  private static ImageReader mImageReader;
  private static boolean mIsDatasetPlayback = false;
  private Map<Long, ImageMetaData> mImageMetaData = Collections.synchronizedMap(new LinkedHashMap()
  {
    protected boolean removeEldestEntry(Map.Entry paramAnonymousEntry)
    {
      return size() > 10;
    }
  });
  private ITangoVhs.Stub mVhsBinder = new ITangoVhs.Stub()
  {
    public Surface getTrackingSurface()
      throws RemoteException
    {
      TangoVirtualHalService.access$000();
      TangoVirtualHalService.access$102(new HandlerThread("mCameraHandlerThread"));
      TangoVirtualHalService.mCameraHandlerThread.start();
      TangoVirtualHalService.access$202(new Handler(TangoVirtualHalService.mCameraHandlerThread.getLooper()));
      TangoVirtualHalService.access$302(ImageReader.newInstance(640, 480, 35, 16));
      TangoVirtualHalService.access$402(new ImageReader.OnImageAvailableListener()
      {
        long lastTimestampNs = 0L;
        final long timestampThresholdPeriodNs = 90000000L;
        
        public void onImageAvailable(ImageReader paramAnonymous2ImageReader)
        {
          paramAnonymous2ImageReader = paramAnonymous2ImageReader.acquireLatestImage();
          if (paramAnonymous2ImageReader != null)
          {
            long l = paramAnonymous2ImageReader.getTimestamp();
            Object localObject = paramAnonymous2ImageReader.getPlanes();
            int i = paramAnonymous2ImageReader.getWidth();
            int j = paramAnonymous2ImageReader.getHeight();
            localObject = localObject[0].getBuffer();
            if (TangoVirtualHalService.mIsDatasetPlayback)
            {
              paramAnonymous2ImageReader.setTimestamp(((ByteBuffer)localObject).getLong(0));
              l = ((ByteBuffer)localObject).getLong(0);
            }
            if (!TangoVirtualHalService.onImageAvailable(paramAnonymous2ImageReader, l, i, j, (ByteBuffer)localObject)) {
              paramAnonymous2ImageReader.close();
            }
            return;
          }
          Log.e("TangoVhsService", "OnImageAvailable() acquireLatestImage failed!");
        }
      });
      TangoVirtualHalService.mImageReader.setOnImageAvailableListener(TangoVirtualHalService.mImageAvailListener, TangoVirtualHalService.mCameraHandler);
      return TangoVirtualHalService.mImageReader.getSurface();
    }
    
    public void onMetadata(long paramAnonymousLong1, long paramAnonymousLong2, long paramAnonymousLong3, long paramAnonymousLong4)
    {
      TangoVirtualHalService.onMetadata(paramAnonymousLong1, paramAnonymousLong2, paramAnonymousLong3, paramAnonymousLong4);
    }
    
    public int setDatasetPathAndUUID(String paramAnonymousString1, String paramAnonymousString2)
    {
      Log.d("TangoVhsService", "Datset path set to " + paramAnonymousString1 + ", UUID set to " + paramAnonymousString2);
      TangoVirtualHalService.access$502(true);
      return TangoVirtualHalService.setDatasetPathAndUUID(paramAnonymousString1, paramAnonymousString2);
    }
  };
  
  static
  {
    System.loadLibrary("tango_hal");
  }
  
  private static native void initialize();
  
  private static native boolean onImageAvailable(Image paramImage, long paramLong, int paramInt1, int paramInt2, ByteBuffer paramByteBuffer);
  
  private static native void onMetadata(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
  
  private static native int setDatasetPathAndUUID(String paramString1, String paramString2);
  
  public IBinder onBind(Intent paramIntent)
  {
    mIsDatasetPlayback = false;
    return this.mVhsBinder;
  }
  
  class ImageMetaData
  {
    public long mExposureTimeNs = 0L;
    public long mFrameCount = 0L;
    public long mShutterSkewNs = 0L;
    
    public ImageMetaData(long paramLong1, long paramLong2, long paramLong3)
    {
      this.mExposureTimeNs = paramLong1;
      this.mShutterSkewNs = paramLong2;
      this.mFrameCount = paramLong3;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tango/TangoVirtualHalService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */