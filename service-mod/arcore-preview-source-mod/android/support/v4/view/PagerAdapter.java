package android.support.v4.view;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

public abstract class PagerAdapter
{
  public static final int POSITION_NONE = -2;
  public static final int POSITION_UNCHANGED = -1;
  private final DataSetObservable mObservable = new DataSetObservable();
  private DataSetObserver mViewPagerObserver;
  
  @Deprecated
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    throw new UnsupportedOperationException("Required method destroyItem was not overridden");
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    destroyItem(paramViewGroup, paramInt, paramObject);
  }
  
  @Deprecated
  public void finishUpdate(View paramView) {}
  
  public void finishUpdate(ViewGroup paramViewGroup)
  {
    finishUpdate(paramViewGroup);
  }
  
  public abstract int getCount();
  
  public int getItemPosition(Object paramObject)
  {
    return -1;
  }
  
  public CharSequence getPageTitle(int paramInt)
  {
    return null;
  }
  
  public float getPageWidth(int paramInt)
  {
    return 1.0F;
  }
  
  @Deprecated
  public Object instantiateItem(View paramView, int paramInt)
  {
    throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    return instantiateItem(paramViewGroup, paramInt);
  }
  
  public abstract boolean isViewFromObject(View paramView, Object paramObject);
  
  public void notifyDataSetChanged()
  {
    try
    {
      if (this.mViewPagerObserver != null) {
        this.mViewPagerObserver.onChanged();
      }
      this.mObservable.notifyChanged();
      return;
    }
    finally {}
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.mObservable.registerObserver(paramDataSetObserver);
  }
  
  public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader) {}
  
  public Parcelable saveState()
  {
    return null;
  }
  
  @Deprecated
  public void setPrimaryItem(View paramView, int paramInt, Object paramObject) {}
  
  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    setPrimaryItem(paramViewGroup, paramInt, paramObject);
  }
  
  void setViewPagerObserver(DataSetObserver paramDataSetObserver)
  {
    try
    {
      this.mViewPagerObserver = paramDataSetObserver;
      return;
    }
    finally {}
  }
  
  @Deprecated
  public void startUpdate(View paramView) {}
  
  public void startUpdate(ViewGroup paramViewGroup)
  {
    startUpdate(paramViewGroup);
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.mObservable.unregisterObserver(paramDataSetObserver);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/view/PagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */