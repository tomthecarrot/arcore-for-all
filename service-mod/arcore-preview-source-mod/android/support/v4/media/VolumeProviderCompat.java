package android.support.v4.media;

import android.os.Build.VERSION;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class VolumeProviderCompat
{
  public static final int VOLUME_CONTROL_ABSOLUTE = 2;
  public static final int VOLUME_CONTROL_FIXED = 0;
  public static final int VOLUME_CONTROL_RELATIVE = 1;
  private Callback mCallback;
  private final int mControlType;
  private int mCurrentVolume;
  private final int mMaxVolume;
  private Object mVolumeProviderObj;
  
  public VolumeProviderCompat(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mControlType = paramInt1;
    this.mMaxVolume = paramInt2;
    this.mCurrentVolume = paramInt3;
  }
  
  public final int getCurrentVolume()
  {
    return this.mCurrentVolume;
  }
  
  public final int getMaxVolume()
  {
    return this.mMaxVolume;
  }
  
  public final int getVolumeControl()
  {
    return this.mControlType;
  }
  
  public Object getVolumeProvider()
  {
    if ((this.mVolumeProviderObj != null) || (Build.VERSION.SDK_INT < 21)) {
      return this.mVolumeProviderObj;
    }
    this.mVolumeProviderObj = VolumeProviderCompatApi21.createVolumeProvider(this.mControlType, this.mMaxVolume, this.mCurrentVolume, new VolumeProviderCompatApi21.Delegate()
    {
      public void onAdjustVolume(int paramAnonymousInt)
      {
        VolumeProviderCompat.this.onAdjustVolume(paramAnonymousInt);
      }
      
      public void onSetVolumeTo(int paramAnonymousInt)
      {
        VolumeProviderCompat.this.onSetVolumeTo(paramAnonymousInt);
      }
    });
    return this.mVolumeProviderObj;
  }
  
  public void onAdjustVolume(int paramInt) {}
  
  public void onSetVolumeTo(int paramInt) {}
  
  public void setCallback(Callback paramCallback)
  {
    this.mCallback = paramCallback;
  }
  
  public final void setCurrentVolume(int paramInt)
  {
    this.mCurrentVolume = paramInt;
    Object localObject = getVolumeProvider();
    if (localObject != null) {
      VolumeProviderCompatApi21.setCurrentVolume(localObject, paramInt);
    }
    if (this.mCallback != null) {
      this.mCallback.onVolumeChanged(this);
    }
  }
  
  public static abstract class Callback
  {
    public abstract void onVolumeChanged(VolumeProviderCompat paramVolumeProviderCompat);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ControlType {}
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/media/VolumeProviderCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */