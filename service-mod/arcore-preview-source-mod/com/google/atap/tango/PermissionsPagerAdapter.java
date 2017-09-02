package com.google.atap.tango;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class PermissionsPagerAdapter
  extends PagerAdapter
{
  private ViewGroup mContainer;
  private Context mContext;
  private LayoutInflater mInflater;
  private List<PermissionsPagerContent> mTabs;
  
  public PermissionsPagerAdapter(Context paramContext, LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    this.mContext = paramContext;
    this.mInflater = paramLayoutInflater;
    this.mContainer = paramViewGroup;
    this.mTabs = new ArrayList();
    paramContext = PermissionHelper.getPermissionTypes();
    int j = paramContext.length;
    int i = 0;
    while (i < j)
    {
      paramLayoutInflater = paramContext[i];
      this.mTabs.add(new PermissionsPagerContent(this.mContext, paramLayoutInflater));
      i += 1;
    }
  }
  
  public int getCount()
  {
    return this.mTabs.size();
  }
  
  public CharSequence getPageTitle(int paramInt)
  {
    return PermissionHelper.getPermissionType(this.mContext, ((PermissionsPagerContent)this.mTabs.get(paramInt)).getPermissionType());
  }
  
  public PermissionsPagerContent getTab(int paramInt)
  {
    return (PermissionsPagerContent)this.mTabs.get(paramInt);
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = ((PermissionsPagerContent)this.mTabs.get(paramInt)).buildView(this.mInflater, this.mContainer);
    paramViewGroup.addView(localView);
    return localView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tango/PermissionsPagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */