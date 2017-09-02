package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.media.MediaDescription.Builder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;

class MediaDescriptionCompatApi21
{
  public static Object fromParcel(Parcel paramParcel)
  {
    return MediaDescription.CREATOR.createFromParcel(paramParcel);
  }
  
  public static CharSequence getDescription(Object paramObject)
  {
    return ((MediaDescription)paramObject).getDescription();
  }
  
  public static Bundle getExtras(Object paramObject)
  {
    return ((MediaDescription)paramObject).getExtras();
  }
  
  public static Bitmap getIconBitmap(Object paramObject)
  {
    return ((MediaDescription)paramObject).getIconBitmap();
  }
  
  public static Uri getIconUri(Object paramObject)
  {
    return ((MediaDescription)paramObject).getIconUri();
  }
  
  public static String getMediaId(Object paramObject)
  {
    return ((MediaDescription)paramObject).getMediaId();
  }
  
  public static CharSequence getSubtitle(Object paramObject)
  {
    return ((MediaDescription)paramObject).getSubtitle();
  }
  
  public static CharSequence getTitle(Object paramObject)
  {
    return ((MediaDescription)paramObject).getTitle();
  }
  
  public static void writeToParcel(Object paramObject, Parcel paramParcel, int paramInt)
  {
    ((MediaDescription)paramObject).writeToParcel(paramParcel, paramInt);
  }
  
  static class Builder
  {
    public static Object build(Object paramObject)
    {
      return ((MediaDescription.Builder)paramObject).build();
    }
    
    public static Object newInstance()
    {
      return new MediaDescription.Builder();
    }
    
    public static void setDescription(Object paramObject, CharSequence paramCharSequence)
    {
      ((MediaDescription.Builder)paramObject).setDescription(paramCharSequence);
    }
    
    public static void setExtras(Object paramObject, Bundle paramBundle)
    {
      ((MediaDescription.Builder)paramObject).setExtras(paramBundle);
    }
    
    public static void setIconBitmap(Object paramObject, Bitmap paramBitmap)
    {
      ((MediaDescription.Builder)paramObject).setIconBitmap(paramBitmap);
    }
    
    public static void setIconUri(Object paramObject, Uri paramUri)
    {
      ((MediaDescription.Builder)paramObject).setIconUri(paramUri);
    }
    
    public static void setMediaId(Object paramObject, String paramString)
    {
      ((MediaDescription.Builder)paramObject).setMediaId(paramString);
    }
    
    public static void setSubtitle(Object paramObject, CharSequence paramCharSequence)
    {
      ((MediaDescription.Builder)paramObject).setSubtitle(paramCharSequence);
    }
    
    public static void setTitle(Object paramObject, CharSequence paramCharSequence)
    {
      ((MediaDescription.Builder)paramObject).setTitle(paramCharSequence);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/media/MediaDescriptionCompatApi21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */