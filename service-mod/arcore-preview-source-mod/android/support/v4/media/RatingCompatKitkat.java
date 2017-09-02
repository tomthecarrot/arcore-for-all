package android.support.v4.media;

import android.media.Rating;

class RatingCompatKitkat
{
  public static float getPercentRating(Object paramObject)
  {
    return ((Rating)paramObject).getPercentRating();
  }
  
  public static int getRatingStyle(Object paramObject)
  {
    return ((Rating)paramObject).getRatingStyle();
  }
  
  public static float getStarRating(Object paramObject)
  {
    return ((Rating)paramObject).getStarRating();
  }
  
  public static boolean hasHeart(Object paramObject)
  {
    return ((Rating)paramObject).hasHeart();
  }
  
  public static boolean isRated(Object paramObject)
  {
    return ((Rating)paramObject).isRated();
  }
  
  public static boolean isThumbUp(Object paramObject)
  {
    return ((Rating)paramObject).isThumbUp();
  }
  
  public static Object newHeartRating(boolean paramBoolean)
  {
    return Rating.newHeartRating(paramBoolean);
  }
  
  public static Object newPercentageRating(float paramFloat)
  {
    return Rating.newPercentageRating(paramFloat);
  }
  
  public static Object newStarRating(int paramInt, float paramFloat)
  {
    return Rating.newStarRating(paramInt, paramFloat);
  }
  
  public static Object newThumbRating(boolean paramBoolean)
  {
    return Rating.newThumbRating(paramBoolean);
  }
  
  public static Object newUnratedRating(int paramInt)
  {
    return Rating.newUnratedRating(paramInt);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/media/RatingCompatKitkat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */