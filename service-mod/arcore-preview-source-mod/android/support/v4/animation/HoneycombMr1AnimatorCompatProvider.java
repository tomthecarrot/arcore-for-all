package android.support.v4.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewPropertyAnimator;

class HoneycombMr1AnimatorCompatProvider
  implements AnimatorProvider
{
  private TimeInterpolator mDefaultInterpolator;
  
  public void clearInterpolator(View paramView)
  {
    if (this.mDefaultInterpolator == null) {
      this.mDefaultInterpolator = new ValueAnimator().getInterpolator();
    }
    paramView.animate().setInterpolator(this.mDefaultInterpolator);
  }
  
  public ValueAnimatorCompat emptyValueAnimator()
  {
    return new HoneycombValueAnimatorCompat(ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }));
  }
  
  static class AnimatorListenerCompatWrapper
    implements Animator.AnimatorListener
  {
    final ValueAnimatorCompat mValueAnimatorCompat;
    final AnimatorListenerCompat mWrapped;
    
    public AnimatorListenerCompatWrapper(AnimatorListenerCompat paramAnimatorListenerCompat, ValueAnimatorCompat paramValueAnimatorCompat)
    {
      this.mWrapped = paramAnimatorListenerCompat;
      this.mValueAnimatorCompat = paramValueAnimatorCompat;
    }
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      this.mWrapped.onAnimationCancel(this.mValueAnimatorCompat);
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      this.mWrapped.onAnimationEnd(this.mValueAnimatorCompat);
    }
    
    public void onAnimationRepeat(Animator paramAnimator)
    {
      this.mWrapped.onAnimationRepeat(this.mValueAnimatorCompat);
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      this.mWrapped.onAnimationStart(this.mValueAnimatorCompat);
    }
  }
  
  static class HoneycombValueAnimatorCompat
    implements ValueAnimatorCompat
  {
    final Animator mWrapped;
    
    public HoneycombValueAnimatorCompat(Animator paramAnimator)
    {
      this.mWrapped = paramAnimator;
    }
    
    public void addListener(AnimatorListenerCompat paramAnimatorListenerCompat)
    {
      this.mWrapped.addListener(new HoneycombMr1AnimatorCompatProvider.AnimatorListenerCompatWrapper(paramAnimatorListenerCompat, this));
    }
    
    public void addUpdateListener(final AnimatorUpdateListenerCompat paramAnimatorUpdateListenerCompat)
    {
      if ((this.mWrapped instanceof ValueAnimator)) {
        ((ValueAnimator)this.mWrapped).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            paramAnimatorUpdateListenerCompat.onAnimationUpdate(HoneycombMr1AnimatorCompatProvider.HoneycombValueAnimatorCompat.this);
          }
        });
      }
    }
    
    public void cancel()
    {
      this.mWrapped.cancel();
    }
    
    public float getAnimatedFraction()
    {
      return ((ValueAnimator)this.mWrapped).getAnimatedFraction();
    }
    
    public void setDuration(long paramLong)
    {
      this.mWrapped.setDuration(paramLong);
    }
    
    public void setTarget(View paramView)
    {
      this.mWrapped.setTarget(paramView);
    }
    
    public void start()
    {
      this.mWrapped.start();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/animation/HoneycombMr1AnimatorCompatProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */