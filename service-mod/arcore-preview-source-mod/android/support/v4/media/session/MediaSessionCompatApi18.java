package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.media.AudioManager;
import android.media.RemoteControlClient;
import android.media.RemoteControlClient.OnPlaybackPositionUpdateListener;
import android.os.SystemClock;
import android.util.Log;

class MediaSessionCompatApi18
{
  private static final long ACTION_SEEK_TO = 256L;
  private static final String TAG = "MediaSessionCompatApi18";
  private static boolean sIsMbrPendingIntentSupported = true;
  
  public static Object createPlaybackPositionUpdateListener(Callback paramCallback)
  {
    return new OnPlaybackPositionUpdateListener(paramCallback);
  }
  
  static int getRccTransportControlFlagsFromActions(long paramLong)
  {
    int j = MediaSessionCompatApi14.getRccTransportControlFlagsFromActions(paramLong);
    int i = j;
    if ((0x100 & paramLong) != 0L) {
      i = j | 0x100;
    }
    return i;
  }
  
  public static void registerMediaButtonEventReceiver(Context paramContext, PendingIntent paramPendingIntent, ComponentName paramComponentName)
  {
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    if (sIsMbrPendingIntentSupported) {}
    try
    {
      paramContext.registerMediaButtonEventReceiver(paramPendingIntent);
      if (!sIsMbrPendingIntentSupported) {
        paramContext.registerMediaButtonEventReceiver(paramComponentName);
      }
      return;
    }
    catch (NullPointerException paramPendingIntent)
    {
      for (;;)
      {
        Log.w("MediaSessionCompatApi18", "Unable to register media button event receiver with PendingIntent, falling back to ComponentName.");
        sIsMbrPendingIntentSupported = false;
      }
    }
  }
  
  public static void setOnPlaybackPositionUpdateListener(Object paramObject1, Object paramObject2)
  {
    ((RemoteControlClient)paramObject1).setPlaybackPositionUpdateListener((RemoteControlClient.OnPlaybackPositionUpdateListener)paramObject2);
  }
  
  public static void setState(Object paramObject, int paramInt, long paramLong1, float paramFloat, long paramLong2)
  {
    long l2 = SystemClock.elapsedRealtime();
    long l1 = paramLong1;
    if (paramInt == 3)
    {
      l1 = paramLong1;
      if (paramLong1 > 0L)
      {
        l1 = 0L;
        if (paramLong2 > 0L)
        {
          paramLong2 = l2 - paramLong2;
          l1 = paramLong2;
          if (paramFloat > 0.0F)
          {
            l1 = paramLong2;
            if (paramFloat != 1.0F) {
              l1 = ((float)paramLong2 * paramFloat);
            }
          }
        }
        l1 = paramLong1 + l1;
      }
    }
    paramInt = MediaSessionCompatApi14.getRccStateFromState(paramInt);
    ((RemoteControlClient)paramObject).setPlaybackState(paramInt, l1, paramFloat);
  }
  
  public static void setTransportControlFlags(Object paramObject, long paramLong)
  {
    ((RemoteControlClient)paramObject).setTransportControlFlags(getRccTransportControlFlagsFromActions(paramLong));
  }
  
  public static void unregisterMediaButtonEventReceiver(Context paramContext, PendingIntent paramPendingIntent, ComponentName paramComponentName)
  {
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    if (sIsMbrPendingIntentSupported)
    {
      paramContext.unregisterMediaButtonEventReceiver(paramPendingIntent);
      return;
    }
    paramContext.unregisterMediaButtonEventReceiver(paramComponentName);
  }
  
  static abstract interface Callback
  {
    public abstract void onSeekTo(long paramLong);
  }
  
  static class OnPlaybackPositionUpdateListener<T extends MediaSessionCompatApi18.Callback>
    implements RemoteControlClient.OnPlaybackPositionUpdateListener
  {
    protected final T mCallback;
    
    public OnPlaybackPositionUpdateListener(T paramT)
    {
      this.mCallback = paramT;
    }
    
    public void onPlaybackPositionUpdate(long paramLong)
    {
      this.mCallback.onSeekTo(paramLong);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/media/session/MediaSessionCompatApi18.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */