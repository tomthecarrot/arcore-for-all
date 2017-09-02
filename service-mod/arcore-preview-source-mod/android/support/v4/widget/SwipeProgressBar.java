package android.support.v4.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

final class SwipeProgressBar
{
  private static final int ANIMATION_DURATION_MS = 2000;
  private static final int COLOR1 = -1291845632;
  private static final int COLOR2 = Integer.MIN_VALUE;
  private static final int COLOR3 = 1291845632;
  private static final int COLOR4 = 436207616;
  private static final int FINISH_ANIMATION_DURATION_MS = 1000;
  private static final Interpolator INTERPOLATOR = new FastOutSlowInInterpolator();
  private Rect mBounds = new Rect();
  private final RectF mClipRect = new RectF();
  private int mColor1;
  private int mColor2;
  private int mColor3;
  private int mColor4;
  private long mFinishTime;
  private final Paint mPaint = new Paint();
  private View mParent;
  private boolean mRunning;
  private long mStartTime;
  private float mTriggerPercentage;
  
  public SwipeProgressBar(View paramView)
  {
    this.mParent = paramView;
    this.mColor1 = -1291845632;
    this.mColor2 = Integer.MIN_VALUE;
    this.mColor3 = 1291845632;
    this.mColor4 = 436207616;
  }
  
  private void drawCircle(Canvas paramCanvas, float paramFloat1, float paramFloat2, int paramInt, float paramFloat3)
  {
    this.mPaint.setColor(paramInt);
    paramCanvas.save();
    paramCanvas.translate(paramFloat1, paramFloat2);
    paramFloat2 = INTERPOLATOR.getInterpolation(paramFloat3);
    paramCanvas.scale(paramFloat2, paramFloat2);
    paramCanvas.drawCircle(0.0F, 0.0F, paramFloat1, this.mPaint);
    paramCanvas.restore();
  }
  
  private void drawTrigger(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    this.mPaint.setColor(this.mColor1);
    paramCanvas.drawCircle(paramInt1, paramInt2, paramInt1 * this.mTriggerPercentage, this.mPaint);
  }
  
  void draw(Canvas paramCanvas)
  {
    int i = this.mBounds.width();
    int i1 = this.mBounds.height();
    int m = i / 2;
    int n = i1 / 2;
    int k = 0;
    int j = paramCanvas.save();
    paramCanvas.clipRect(this.mBounds);
    float f1;
    if ((this.mRunning) || (this.mFinishTime > 0L))
    {
      long l1 = AnimationUtils.currentAnimationTimeMillis();
      long l2 = this.mStartTime;
      long l3 = (l1 - this.mStartTime) / 2000L;
      f1 = (float)((l1 - l2) % 2000L) / 20.0F;
      float f2;
      if (!this.mRunning)
      {
        if (l1 - this.mFinishTime >= 1000L)
        {
          this.mFinishTime = 0L;
          return;
        }
        f2 = (float)((l1 - this.mFinishTime) % 1000L) / 10.0F / 100.0F;
        f2 = i / 2 * INTERPOLATOR.getInterpolation(f2);
        this.mClipRect.set(m - f2, 0.0F, m + f2, i1);
        paramCanvas.saveLayerAlpha(this.mClipRect, 0, 0);
        k = 1;
      }
      if (l3 == 0L)
      {
        paramCanvas.drawColor(this.mColor1);
        if ((f1 >= 0.0F) && (f1 <= 25.0F))
        {
          f2 = (25.0F + f1) * 2.0F / 100.0F;
          drawCircle(paramCanvas, m, n, this.mColor1, f2);
        }
        if ((f1 >= 0.0F) && (f1 <= 50.0F))
        {
          f2 = 2.0F * f1 / 100.0F;
          drawCircle(paramCanvas, m, n, this.mColor2, f2);
        }
        if ((f1 >= 25.0F) && (f1 <= 75.0F))
        {
          f2 = (f1 - 25.0F) * 2.0F / 100.0F;
          drawCircle(paramCanvas, m, n, this.mColor3, f2);
        }
        if ((f1 >= 50.0F) && (f1 <= 100.0F))
        {
          f2 = (f1 - 50.0F) * 2.0F / 100.0F;
          drawCircle(paramCanvas, m, n, this.mColor4, f2);
        }
        if ((f1 >= 75.0F) && (f1 <= 100.0F))
        {
          f1 = (f1 - 75.0F) * 2.0F / 100.0F;
          drawCircle(paramCanvas, m, n, this.mColor1, f1);
        }
        i = j;
        if (this.mTriggerPercentage > 0.0F)
        {
          i = j;
          if (k != 0)
          {
            paramCanvas.restoreToCount(j);
            i = paramCanvas.save();
            paramCanvas.clipRect(this.mBounds);
            drawTrigger(paramCanvas, m, n);
          }
        }
        ViewCompat.postInvalidateOnAnimation(this.mParent, this.mBounds.left, this.mBounds.top, this.mBounds.right, this.mBounds.bottom);
      }
    }
    for (;;)
    {
      paramCanvas.restoreToCount(i);
      return;
      if ((f1 >= 0.0F) && (f1 < 25.0F))
      {
        paramCanvas.drawColor(this.mColor4);
        break;
      }
      if ((f1 >= 25.0F) && (f1 < 50.0F))
      {
        paramCanvas.drawColor(this.mColor1);
        break;
      }
      if ((f1 >= 50.0F) && (f1 < 75.0F))
      {
        paramCanvas.drawColor(this.mColor2);
        break;
      }
      paramCanvas.drawColor(this.mColor3);
      break;
      i = j;
      if (this.mTriggerPercentage > 0.0F)
      {
        i = j;
        if (this.mTriggerPercentage <= 1.0D)
        {
          drawTrigger(paramCanvas, m, n);
          i = j;
        }
      }
    }
  }
  
  boolean isRunning()
  {
    return (this.mRunning) || (this.mFinishTime > 0L);
  }
  
  void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mBounds.left = paramInt1;
    this.mBounds.top = paramInt2;
    this.mBounds.right = paramInt3;
    this.mBounds.bottom = paramInt4;
  }
  
  void setColorScheme(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mColor1 = paramInt1;
    this.mColor2 = paramInt2;
    this.mColor3 = paramInt3;
    this.mColor4 = paramInt4;
  }
  
  void setTriggerPercentage(float paramFloat)
  {
    this.mTriggerPercentage = paramFloat;
    this.mStartTime = 0L;
    ViewCompat.postInvalidateOnAnimation(this.mParent, this.mBounds.left, this.mBounds.top, this.mBounds.right, this.mBounds.bottom);
  }
  
  void start()
  {
    if (!this.mRunning)
    {
      this.mTriggerPercentage = 0.0F;
      this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
      this.mRunning = true;
      this.mParent.postInvalidate();
    }
  }
  
  void stop()
  {
    if (this.mRunning)
    {
      this.mTriggerPercentage = 0.0F;
      this.mFinishTime = AnimationUtils.currentAnimationTimeMillis();
      this.mRunning = false;
      this.mParent.postInvalidate();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/widget/SwipeProgressBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */