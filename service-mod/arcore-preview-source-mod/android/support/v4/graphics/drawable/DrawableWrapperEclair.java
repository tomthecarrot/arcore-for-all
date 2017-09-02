package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.annotation.Nullable;

class DrawableWrapperEclair
  extends DrawableWrapperDonut
{
  DrawableWrapperEclair(Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  DrawableWrapperEclair(DrawableWrapperDonut.DrawableWrapperState paramDrawableWrapperState, Resources paramResources)
  {
    super(paramDrawableWrapperState, paramResources);
  }
  
  DrawableWrapperDonut.DrawableWrapperState mutateConstantState()
  {
    return new DrawableWrapperStateEclair(this.mState, null);
  }
  
  protected Drawable newDrawableFromState(Drawable.ConstantState paramConstantState, Resources paramResources)
  {
    return paramConstantState.newDrawable(paramResources);
  }
  
  private static class DrawableWrapperStateEclair
    extends DrawableWrapperDonut.DrawableWrapperState
  {
    DrawableWrapperStateEclair(@Nullable DrawableWrapperDonut.DrawableWrapperState paramDrawableWrapperState, @Nullable Resources paramResources)
    {
      super(paramResources);
    }
    
    public Drawable newDrawable(@Nullable Resources paramResources)
    {
      return new DrawableWrapperEclair(this, paramResources);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/graphics/drawable/DrawableWrapperEclair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */