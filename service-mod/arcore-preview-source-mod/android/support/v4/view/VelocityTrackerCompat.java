package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

public final class VelocityTrackerCompat
{
  static final VelocityTrackerVersionImpl IMPL = new BaseVelocityTrackerVersionImpl();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      IMPL = new HoneycombVelocityTrackerVersionImpl();
      return;
    }
  }
  
  public static float getXVelocity(VelocityTracker paramVelocityTracker, int paramInt)
  {
    return IMPL.getXVelocity(paramVelocityTracker, paramInt);
  }
  
  public static float getYVelocity(VelocityTracker paramVelocityTracker, int paramInt)
  {
    return IMPL.getYVelocity(paramVelocityTracker, paramInt);
  }
  
  static class BaseVelocityTrackerVersionImpl
    implements VelocityTrackerCompat.VelocityTrackerVersionImpl
  {
    public float getXVelocity(VelocityTracker paramVelocityTracker, int paramInt)
    {
      return paramVelocityTracker.getXVelocity();
    }
    
    public float getYVelocity(VelocityTracker paramVelocityTracker, int paramInt)
    {
      return paramVelocityTracker.getYVelocity();
    }
  }
  
  static class HoneycombVelocityTrackerVersionImpl
    implements VelocityTrackerCompat.VelocityTrackerVersionImpl
  {
    public float getXVelocity(VelocityTracker paramVelocityTracker, int paramInt)
    {
      return VelocityTrackerCompatHoneycomb.getXVelocity(paramVelocityTracker, paramInt);
    }
    
    public float getYVelocity(VelocityTracker paramVelocityTracker, int paramInt)
    {
      return VelocityTrackerCompatHoneycomb.getYVelocity(paramVelocityTracker, paramInt);
    }
  }
  
  static abstract interface VelocityTrackerVersionImpl
  {
    public abstract float getXVelocity(VelocityTracker paramVelocityTracker, int paramInt);
    
    public abstract float getYVelocity(VelocityTracker paramVelocityTracker, int paramInt);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/view/VelocityTrackerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */