package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.SystemClock;

public final class zzabb
  extends Drawable
  implements Drawable.Callback
{
  private int mFrom;
  private boolean zzaQE = true;
  private int zzaQJ = 0;
  private int zzaQK;
  private int zzaQL = 255;
  private int zzaQM;
  private int zzaQN = 0;
  private boolean zzaQO;
  private zzb zzaQP;
  private Drawable zzaQQ;
  private Drawable zzaQR;
  private boolean zzaQS;
  private boolean zzaQT;
  private boolean zzaQU;
  private int zzaQV;
  private long zzaeN;
  
  public zzabb(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    this(null);
    Object localObject = paramDrawable1;
    if (paramDrawable1 == null) {
      localObject = zza.zzzm();
    }
    this.zzaQQ = ((Drawable)localObject);
    ((Drawable)localObject).setCallback(this);
    paramDrawable1 = this.zzaQP;
    paramDrawable1.zzaQY |= ((Drawable)localObject).getChangingConfigurations();
    paramDrawable1 = paramDrawable2;
    if (paramDrawable2 == null) {
      paramDrawable1 = zza.zzzm();
    }
    this.zzaQR = paramDrawable1;
    paramDrawable1.setCallback(this);
    paramDrawable2 = this.zzaQP;
    paramDrawable2.zzaQY |= paramDrawable1.getChangingConfigurations();
  }
  
  zzabb(zzb paramzzb)
  {
    this.zzaQP = new zzb(paramzzb);
  }
  
  public boolean canConstantState()
  {
    if (!this.zzaQS) {
      if ((this.zzaQQ.getConstantState() == null) || (this.zzaQR.getConstantState() == null)) {
        break label44;
      }
    }
    label44:
    for (boolean bool = true;; bool = false)
    {
      this.zzaQT = bool;
      this.zzaQS = true;
      return this.zzaQT;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    int j = 1;
    int i = 1;
    int k = 0;
    switch (this.zzaQJ)
    {
    }
    boolean bool;
    Drawable localDrawable1;
    Drawable localDrawable2;
    do
    {
      for (;;)
      {
        j = this.zzaQN;
        bool = this.zzaQE;
        localDrawable1 = this.zzaQQ;
        localDrawable2 = this.zzaQR;
        if (i == 0) {
          break;
        }
        if ((!bool) || (j == 0)) {
          localDrawable1.draw(paramCanvas);
        }
        if (j == this.zzaQL)
        {
          localDrawable2.setAlpha(this.zzaQL);
          localDrawable2.draw(paramCanvas);
        }
        return;
        this.zzaeN = SystemClock.uptimeMillis();
        this.zzaQJ = 2;
        i = k;
      }
    } while (this.zzaeN < 0L);
    float f = (float)(SystemClock.uptimeMillis() - this.zzaeN) / this.zzaQM;
    if (f >= 1.0F) {}
    for (i = j;; i = 0)
    {
      if (i != 0) {
        this.zzaQJ = 0;
      }
      this.zzaQN = ((int)(Math.min(f, 1.0F) * (this.zzaQK + 0) + 0.0F));
      break;
    }
    if (bool) {
      localDrawable1.setAlpha(this.zzaQL - j);
    }
    localDrawable1.draw(paramCanvas);
    if (bool) {
      localDrawable1.setAlpha(this.zzaQL);
    }
    if (j > 0)
    {
      localDrawable2.setAlpha(j);
      localDrawable2.draw(paramCanvas);
      localDrawable2.setAlpha(this.zzaQL);
    }
    invalidateSelf();
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.zzaQP.mChangingConfigurations | this.zzaQP.zzaQY;
  }
  
  public Drawable.ConstantState getConstantState()
  {
    if (canConstantState())
    {
      this.zzaQP.mChangingConfigurations = getChangingConfigurations();
      return this.zzaQP;
    }
    return null;
  }
  
  public int getIntrinsicHeight()
  {
    return Math.max(this.zzaQQ.getIntrinsicHeight(), this.zzaQR.getIntrinsicHeight());
  }
  
  public int getIntrinsicWidth()
  {
    return Math.max(this.zzaQQ.getIntrinsicWidth(), this.zzaQR.getIntrinsicWidth());
  }
  
  public int getOpacity()
  {
    if (!this.zzaQU)
    {
      this.zzaQV = Drawable.resolveOpacity(this.zzaQQ.getOpacity(), this.zzaQR.getOpacity());
      this.zzaQU = true;
    }
    return this.zzaQV;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.invalidateDrawable(this);
    }
  }
  
  public Drawable mutate()
  {
    if ((!this.zzaQO) && (super.mutate() == this))
    {
      if (!canConstantState()) {
        throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
      }
      this.zzaQQ.mutate();
      this.zzaQR.mutate();
      this.zzaQO = true;
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.zzaQQ.setBounds(paramRect);
    this.zzaQR.setBounds(paramRect);
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.scheduleDrawable(this, paramRunnable, paramLong);
    }
  }
  
  public void setAlpha(int paramInt)
  {
    if (this.zzaQN == this.zzaQL) {
      this.zzaQN = paramInt;
    }
    this.zzaQL = paramInt;
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.zzaQQ.setColorFilter(paramColorFilter);
    this.zzaQR.setColorFilter(paramColorFilter);
  }
  
  public void startTransition(int paramInt)
  {
    this.mFrom = 0;
    this.zzaQK = this.zzaQL;
    this.zzaQN = 0;
    this.zzaQM = paramInt;
    this.zzaQJ = 1;
    invalidateSelf();
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    paramDrawable = getCallback();
    if (paramDrawable != null) {
      paramDrawable.unscheduleDrawable(this, paramRunnable);
    }
  }
  
  public Drawable zzzl()
  {
    return this.zzaQR;
  }
  
  private static final class zza
    extends Drawable
  {
    private static final zza zzaQW = new zza();
    private static final zza zzaQX = new zza(null);
    
    public void draw(Canvas paramCanvas) {}
    
    public Drawable.ConstantState getConstantState()
    {
      return zzaQX;
    }
    
    public int getOpacity()
    {
      return -2;
    }
    
    public void setAlpha(int paramInt) {}
    
    public void setColorFilter(ColorFilter paramColorFilter) {}
    
    private static final class zza
      extends Drawable.ConstantState
    {
      public int getChangingConfigurations()
      {
        return 0;
      }
      
      public Drawable newDrawable()
      {
        return zzabb.zza.zzzm();
      }
    }
  }
  
  static final class zzb
    extends Drawable.ConstantState
  {
    int mChangingConfigurations;
    int zzaQY;
    
    zzb(zzb paramzzb)
    {
      if (paramzzb != null)
      {
        this.mChangingConfigurations = paramzzb.mChangingConfigurations;
        this.zzaQY = paramzzb.zzaQY;
      }
    }
    
    public int getChangingConfigurations()
    {
      return this.mChangingConfigurations;
    }
    
    public Drawable newDrawable()
    {
      return new zzabb(this);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzabb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */