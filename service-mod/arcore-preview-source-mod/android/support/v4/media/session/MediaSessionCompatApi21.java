package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes.Builder;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.VolumeProvider;
import android.media.session.MediaSession;
import android.media.session.MediaSession.Callback;
import android.media.session.MediaSession.QueueItem;
import android.media.session.MediaSession.Token;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.ResultReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MediaSessionCompatApi21
{
  public static Object createCallback(Callback paramCallback)
  {
    return new CallbackProxy(paramCallback);
  }
  
  public static Object createSession(Context paramContext, String paramString)
  {
    return new MediaSession(paramContext, paramString);
  }
  
  public static Parcelable getSessionToken(Object paramObject)
  {
    return ((MediaSession)paramObject).getSessionToken();
  }
  
  public static boolean isActive(Object paramObject)
  {
    return ((MediaSession)paramObject).isActive();
  }
  
  public static void release(Object paramObject)
  {
    ((MediaSession)paramObject).release();
  }
  
  public static void sendSessionEvent(Object paramObject, String paramString, Bundle paramBundle)
  {
    ((MediaSession)paramObject).sendSessionEvent(paramString, paramBundle);
  }
  
  public static void setActive(Object paramObject, boolean paramBoolean)
  {
    ((MediaSession)paramObject).setActive(paramBoolean);
  }
  
  public static void setCallback(Object paramObject1, Object paramObject2, Handler paramHandler)
  {
    ((MediaSession)paramObject1).setCallback((MediaSession.Callback)paramObject2, paramHandler);
  }
  
  public static void setExtras(Object paramObject, Bundle paramBundle)
  {
    ((MediaSession)paramObject).setExtras(paramBundle);
  }
  
  public static void setFlags(Object paramObject, int paramInt)
  {
    ((MediaSession)paramObject).setFlags(paramInt);
  }
  
  public static void setMediaButtonReceiver(Object paramObject, PendingIntent paramPendingIntent)
  {
    ((MediaSession)paramObject).setMediaButtonReceiver(paramPendingIntent);
  }
  
  public static void setMetadata(Object paramObject1, Object paramObject2)
  {
    ((MediaSession)paramObject1).setMetadata((MediaMetadata)paramObject2);
  }
  
  public static void setPlaybackState(Object paramObject1, Object paramObject2)
  {
    ((MediaSession)paramObject1).setPlaybackState((PlaybackState)paramObject2);
  }
  
  public static void setPlaybackToLocal(Object paramObject, int paramInt)
  {
    AudioAttributes.Builder localBuilder = new AudioAttributes.Builder();
    localBuilder.setLegacyStreamType(paramInt);
    ((MediaSession)paramObject).setPlaybackToLocal(localBuilder.build());
  }
  
  public static void setPlaybackToRemote(Object paramObject1, Object paramObject2)
  {
    ((MediaSession)paramObject1).setPlaybackToRemote((VolumeProvider)paramObject2);
  }
  
  public static void setQueue(Object paramObject, List<Object> paramList)
  {
    if (paramList == null)
    {
      ((MediaSession)paramObject).setQueue(null);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add((MediaSession.QueueItem)paramList.next());
    }
    ((MediaSession)paramObject).setQueue(localArrayList);
  }
  
  public static void setQueueTitle(Object paramObject, CharSequence paramCharSequence)
  {
    ((MediaSession)paramObject).setQueueTitle(paramCharSequence);
  }
  
  public static void setSessionActivity(Object paramObject, PendingIntent paramPendingIntent)
  {
    ((MediaSession)paramObject).setSessionActivity(paramPendingIntent);
  }
  
  public static Object verifySession(Object paramObject)
  {
    if ((paramObject instanceof MediaSession)) {
      return paramObject;
    }
    throw new IllegalArgumentException("mediaSession is not a valid MediaSession object");
  }
  
  public static Object verifyToken(Object paramObject)
  {
    if ((paramObject instanceof MediaSession.Token)) {
      return paramObject;
    }
    throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
  }
  
  static abstract interface Callback
    extends MediaSessionCompatApi19.Callback
  {
    public abstract void onCommand(String paramString, Bundle paramBundle, ResultReceiver paramResultReceiver);
    
    public abstract void onCustomAction(String paramString, Bundle paramBundle);
    
    public abstract void onFastForward();
    
    public abstract boolean onMediaButtonEvent(Intent paramIntent);
    
    public abstract void onPause();
    
    public abstract void onPlay();
    
    public abstract void onPlayFromMediaId(String paramString, Bundle paramBundle);
    
    public abstract void onPlayFromSearch(String paramString, Bundle paramBundle);
    
    public abstract void onRewind();
    
    public abstract void onSkipToNext();
    
    public abstract void onSkipToPrevious();
    
    public abstract void onSkipToQueueItem(long paramLong);
    
    public abstract void onStop();
  }
  
  static class CallbackProxy<T extends MediaSessionCompatApi21.Callback>
    extends MediaSession.Callback
  {
    protected final T mCallback;
    
    public CallbackProxy(T paramT)
    {
      this.mCallback = paramT;
    }
    
    public void onCommand(String paramString, Bundle paramBundle, ResultReceiver paramResultReceiver)
    {
      this.mCallback.onCommand(paramString, paramBundle, paramResultReceiver);
    }
    
    public void onCustomAction(String paramString, Bundle paramBundle)
    {
      this.mCallback.onCustomAction(paramString, paramBundle);
    }
    
    public void onFastForward()
    {
      this.mCallback.onFastForward();
    }
    
    public boolean onMediaButtonEvent(Intent paramIntent)
    {
      return (this.mCallback.onMediaButtonEvent(paramIntent)) || (super.onMediaButtonEvent(paramIntent));
    }
    
    public void onPause()
    {
      this.mCallback.onPause();
    }
    
    public void onPlay()
    {
      this.mCallback.onPlay();
    }
    
    public void onPlayFromMediaId(String paramString, Bundle paramBundle)
    {
      this.mCallback.onPlayFromMediaId(paramString, paramBundle);
    }
    
    public void onPlayFromSearch(String paramString, Bundle paramBundle)
    {
      this.mCallback.onPlayFromSearch(paramString, paramBundle);
    }
    
    public void onRewind()
    {
      this.mCallback.onRewind();
    }
    
    public void onSeekTo(long paramLong)
    {
      this.mCallback.onSeekTo(paramLong);
    }
    
    public void onSetRating(Rating paramRating)
    {
      this.mCallback.onSetRating(paramRating);
    }
    
    public void onSkipToNext()
    {
      this.mCallback.onSkipToNext();
    }
    
    public void onSkipToPrevious()
    {
      this.mCallback.onSkipToPrevious();
    }
    
    public void onSkipToQueueItem(long paramLong)
    {
      this.mCallback.onSkipToQueueItem(paramLong);
    }
    
    public void onStop()
    {
      this.mCallback.onStop();
    }
  }
  
  static class QueueItem
  {
    public static Object createItem(Object paramObject, long paramLong)
    {
      return new MediaSession.QueueItem((MediaDescription)paramObject, paramLong);
    }
    
    public static Object getDescription(Object paramObject)
    {
      return ((MediaSession.QueueItem)paramObject).getDescription();
    }
    
    public static long getQueueId(Object paramObject)
    {
      return ((MediaSession.QueueItem)paramObject).getQueueId();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/media/session/MediaSessionCompatApi21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */