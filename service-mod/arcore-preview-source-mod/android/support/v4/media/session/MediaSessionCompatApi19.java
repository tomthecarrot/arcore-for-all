package android.support.v4.media.session;

import android.media.Rating;
import android.media.RemoteControlClient;
import android.media.RemoteControlClient.MetadataEditor;
import android.media.RemoteControlClient.OnMetadataUpdateListener;
import android.os.Bundle;

class MediaSessionCompatApi19
{
  private static final long ACTION_SET_RATING = 128L;
  private static final String METADATA_KEY_RATING = "android.media.metadata.RATING";
  private static final String METADATA_KEY_USER_RATING = "android.media.metadata.USER_RATING";
  private static final String METADATA_KEY_YEAR = "android.media.metadata.YEAR";
  
  static void addNewMetadata(Bundle paramBundle, RemoteControlClient.MetadataEditor paramMetadataEditor)
  {
    if (paramBundle == null) {}
    do
    {
      return;
      if (paramBundle.containsKey("android.media.metadata.YEAR")) {
        paramMetadataEditor.putLong(8, paramBundle.getLong("android.media.metadata.YEAR"));
      }
      if (paramBundle.containsKey("android.media.metadata.RATING")) {
        paramMetadataEditor.putObject(101, paramBundle.getParcelable("android.media.metadata.RATING"));
      }
    } while (!paramBundle.containsKey("android.media.metadata.USER_RATING"));
    paramMetadataEditor.putObject(268435457, paramBundle.getParcelable("android.media.metadata.USER_RATING"));
  }
  
  public static Object createMetadataUpdateListener(Callback paramCallback)
  {
    return new OnMetadataUpdateListener(paramCallback);
  }
  
  static int getRccTransportControlFlagsFromActions(long paramLong)
  {
    int j = MediaSessionCompatApi18.getRccTransportControlFlagsFromActions(paramLong);
    int i = j;
    if ((0x80 & paramLong) != 0L) {
      i = j | 0x200;
    }
    return i;
  }
  
  public static void setMetadata(Object paramObject, Bundle paramBundle, long paramLong)
  {
    paramObject = ((RemoteControlClient)paramObject).editMetadata(true);
    MediaSessionCompatApi14.buildOldMetadata(paramBundle, (RemoteControlClient.MetadataEditor)paramObject);
    addNewMetadata(paramBundle, (RemoteControlClient.MetadataEditor)paramObject);
    if ((0x80 & paramLong) != 0L) {
      ((RemoteControlClient.MetadataEditor)paramObject).addEditableKey(268435457);
    }
    ((RemoteControlClient.MetadataEditor)paramObject).apply();
  }
  
  public static void setOnMetadataUpdateListener(Object paramObject1, Object paramObject2)
  {
    ((RemoteControlClient)paramObject1).setMetadataUpdateListener((RemoteControlClient.OnMetadataUpdateListener)paramObject2);
  }
  
  public static void setTransportControlFlags(Object paramObject, long paramLong)
  {
    ((RemoteControlClient)paramObject).setTransportControlFlags(getRccTransportControlFlagsFromActions(paramLong));
  }
  
  static abstract interface Callback
    extends MediaSessionCompatApi18.Callback
  {
    public abstract void onSetRating(Object paramObject);
  }
  
  static class OnMetadataUpdateListener<T extends MediaSessionCompatApi19.Callback>
    implements RemoteControlClient.OnMetadataUpdateListener
  {
    protected final T mCallback;
    
    public OnMetadataUpdateListener(T paramT)
    {
      this.mCallback = paramT;
    }
    
    public void onMetadataUpdate(int paramInt, Object paramObject)
    {
      if ((paramInt == 268435457) && ((paramObject instanceof Rating))) {
        this.mCallback.onSetRating(paramObject);
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/media/session/MediaSessionCompatApi19.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */