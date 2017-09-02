package android.support.v4.animation;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

class DonutAnimatorCompatProvider
  implements AnimatorProvider
{
  public void clearInterpolator(View paramView) {}
  
  public ValueAnimatorCompat emptyValueAnimator()
  {
    return new DonutFloatValueAnimator();
  }
  
  private static class DonutFloatValueAnimator
    implements ValueAnimatorCompat
  {
    private long mDuration = 200L;
    private boolean mEnded = false;
    private float mFraction = 0.0F;
    List<AnimatorListenerCompat> mListeners = new ArrayList();
    private Runnable mLoopRunnable = new Runnable()
    {
      public void run()
      {
        float f = (float)(DonutAnimatorCompatProvider.DonutFloatValueAnimator.this.getTime() - DonutAnimatorCompatProvider.DonutFloatValueAnimator.this.mStartTime) * 1.0F / (float)DonutAnimatorCompatProvider.DonutFloatValueAnimator.this.mDuration;
        if ((f > 1.0F) || (DonutAnimatorCompatProvider.DonutFloatValueAnimator.this.mTarget.getParent() == null)) {
          f = 1.0F;
        }
        DonutAnimatorCompatProvider.DonutFloatValueAnimator.access$302(DonutAnimatorCompatProvider.DonutFloatValueAnimator.this, f);
        DonutAnimatorCompatProvider.DonutFloatValueAnimator.this.notifyUpdateListeners();
        if (DonutAnimatorCompatProvider.DonutFloatValueAnimator.this.mFraction >= 1.0F)
        {
          DonutAnimatorCompatProvider.DonutFloatValueAnimator.this.dispatchEnd();
          return;
        }
        DonutAnimatorCompatProvider.DonutFloatValueAnimator.this.mTarget.postDelayed(DonutAnimatorCompatProvider.DonutFloatValueAnimator.this.mLoopRunnable, 16L);
      }
    };
    private long mStartTime;
    private boolean mStarted = false;
    View mTarget;
    List<AnimatorUpdateListenerCompat> mUpdateListeners = new ArrayList();
    
    private void dispatchCancel()
    {
      int i = this.mListeners.size() - 1;
      while (i >= 0)
      {
        ((AnimatorListenerCompat)this.mListeners.get(i)).onAnimationCancel(this);
        i -= 1;
      }
    }
    
    private void dispatchEnd()
    {
      int i = this.mListeners.size() - 1;
      while (i >= 0)
      {
        ((AnimatorListenerCompat)this.mListeners.get(i)).onAnimationEnd(this);
        i -= 1;
      }
    }
    
    private void dispatchStart()
    {
      int i = this.mListeners.size() - 1;
      while (i >= 0)
      {
        ((AnimatorListenerCompat)this.mListeners.get(i)).onAnimationStart(this);
        i -= 1;
      }
    }
    
    private long getTime()
    {
      return this.mTarget.getDrawingTime();
    }
    
    private void notifyUpdateListeners()
    {
      int i = this.mUpdateListeners.size() - 1;
      while (i >= 0)
      {
        ((AnimatorUpdateListenerCompat)this.mUpdateListeners.get(i)).onAnimationUpdate(this);
        i -= 1;
      }
    }
    
    public void addListener(AnimatorListenerCompat paramAnimatorListenerCompat)
    {
      this.mListeners.add(paramAnimatorListenerCompat);
    }
    
    public void addUpdateListener(AnimatorUpdateListenerCompat paramAnimatorUpdateListenerCompat)
    {
      this.mUpdateListeners.add(paramAnimatorUpdateListenerCompat);
    }
    
    public void cancel()
    {
      if (this.mEnded) {
        return;
      }
      this.mEnded = true;
      if (this.mStarted) {
        dispatchCancel();
      }
      dispatchEnd();
    }
    
    public float getAnimatedFraction()
    {
      return this.mFraction;
    }
    
    public void setDuration(long paramLong)
    {
      if (!this.mStarted) {
        this.mDuration = paramLong;
      }
    }
    
    public void setTarget(View paramView)
    {
      this.mTarget = paramView;
    }
    
    public void start()
    {
      if (this.mStarted) {
        return;
      }
      this.mStarted = true;
      dispatchStart();
      this.mFraction = 0.0F;
      this.mStartTime = getTime();
      this.mTarget.postDelayed(this.mLoopRunnable, 16L);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/animation/DonutAnimatorCompatProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */