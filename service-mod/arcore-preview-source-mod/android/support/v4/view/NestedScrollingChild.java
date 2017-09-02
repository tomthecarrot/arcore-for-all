package android.support.v4.view;

public abstract interface NestedScrollingChild
{
  public abstract boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean);
  
  public abstract boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2);
  
  public abstract boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  public abstract boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt);
  
  public abstract boolean hasNestedScrollingParent();
  
  public abstract boolean isNestedScrollingEnabled();
  
  public abstract void setNestedScrollingEnabled(boolean paramBoolean);
  
  public abstract boolean startNestedScroll(int paramInt);
  
  public abstract void stopNestedScroll();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/view/NestedScrollingChild.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */