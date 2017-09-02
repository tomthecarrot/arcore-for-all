package com.google.atap.tango;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class PermissionsListAdapter
  extends BaseAdapter
{
  private Context mContext;
  private List<AppInfo> mItems;
  private IPermissionManager mPermissionManager;
  
  public PermissionsListAdapter(Context paramContext, IPermissionManager paramIPermissionManager, List<AppInfo> paramList)
  {
    this.mContext = paramContext;
    this.mPermissionManager = paramIPermissionManager;
    this.mItems = paramList;
  }
  
  public int getCount()
  {
    return this.mItems.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.mItems.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(2130903049, paramViewGroup, false);
      paramViewGroup = new PermissionListViewHolder();
      paramViewGroup.appIcon = ((ImageView)paramView.findViewById(2131492889));
      paramViewGroup.appName = ((TextView)paramView.findViewById(2131492890));
      paramViewGroup.revokePermissionButton = paramView.findViewById(2131492891);
      paramViewGroup.revokePermissionConfirmationButtonGroup = paramView.findViewById(2131492892);
      paramViewGroup.revokePermissionNegativeButton = paramView.findViewById(2131492893);
      paramViewGroup.revokePermissionPositiveButton = paramView.findViewById(2131492894);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      final AppInfo localAppInfo = (AppInfo)this.mItems.get(paramInt);
      if (localAppInfo.icon != null) {
        paramViewGroup.appIcon.setImageDrawable(localAppInfo.icon);
      }
      paramViewGroup.appName.setText(localAppInfo.name);
      paramViewGroup.revokePermissionButton.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (paramViewGroup.revokePermissionConfirmationButtonGroup.getVisibility() == 8)
          {
            paramViewGroup.revokePermissionConfirmationButtonGroup.setVisibility(0);
            return;
          }
          paramViewGroup.revokePermissionConfirmationButtonGroup.setVisibility(8);
        }
      });
      paramViewGroup.revokePermissionNegativeButton.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramViewGroup.revokePermissionConfirmationButtonGroup.setVisibility(8);
        }
      });
      paramViewGroup.revokePermissionPositiveButton.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramViewGroup.revokePermissionConfirmationButtonGroup.setVisibility(8);
          PermissionsListAdapter.this.mPermissionManager.permissionRevoked(localAppInfo.packageName);
        }
      });
      return paramView;
      paramViewGroup = (PermissionListViewHolder)paramView.getTag();
    }
  }
  
  public static class AppInfo
  {
    public Drawable icon;
    public String name;
    public String packageName;
  }
  
  public static abstract interface IPermissionManager
  {
    public abstract void permissionRevoked(String paramString);
  }
  
  public static class PermissionListViewHolder
  {
    public ImageView appIcon;
    public TextView appName;
    public View revokePermissionButton;
    public View revokePermissionConfirmationButtonGroup;
    public View revokePermissionNegativeButton;
    public View revokePermissionPositiveButton;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tango/PermissionsListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */