package com.google.atap.tango;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class PermissionsPagerContent
  implements PermissionsListAdapter.IPermissionManager
{
  private static final String TAG = PermissionsPagerContent.class.getSimpleName();
  private List<PermissionsListAdapter.AppInfo> mAppList = new ArrayList();
  private Context mContext;
  private View mNoAppsAvailableLabel;
  private PermissionsListAdapter mPermissionListAdapter;
  private String mPermissionType;
  private View mRootView;
  
  public PermissionsPagerContent(Context paramContext, String paramString)
  {
    this.mContext = paramContext;
    this.mPermissionType = paramString;
  }
  
  private void refreshApplicationsList()
  {
    int j = 0;
    this.mAppList.clear();
    String[] arrayOfString = PermissionHelper.getAppsWithPermission(this.mContext, this.mPermissionType);
    int k = arrayOfString.length;
    int i = 0;
    if (i < k)
    {
      String str2 = arrayOfString[i];
      if (TextUtils.equals(str2, this.mContext.getPackageName())) {}
      for (;;)
      {
        i += 1;
        break;
        String str1 = str2;
        Object localObject = this.mContext.getPackageManager();
        try
        {
          ApplicationInfo localApplicationInfo = ((PackageManager)localObject).getApplicationInfo(str2, 0);
          Drawable localDrawable = ((PackageManager)localObject).getApplicationIcon(localApplicationInfo);
          localObject = ((PackageManager)localObject).getApplicationLabel(localApplicationInfo);
          if (localObject != null) {
            str1 = ((CharSequence)localObject).toString();
          }
          localObject = new PermissionsListAdapter.AppInfo();
          ((PermissionsListAdapter.AppInfo)localObject).packageName = str2;
          ((PermissionsListAdapter.AppInfo)localObject).icon = localDrawable;
          ((PermissionsListAdapter.AppInfo)localObject).name = str1;
          this.mAppList.add(localObject);
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          Log.e(TAG, "Application not found: " + str2);
          localNameNotFoundException.printStackTrace();
        }
      }
    }
    View localView = this.mNoAppsAvailableLabel;
    i = j;
    if (this.mAppList.size() > 0) {
      i = 8;
    }
    localView.setVisibility(i);
    this.mPermissionListAdapter.notifyDataSetChanged();
  }
  
  public View buildView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    if (this.mRootView == null)
    {
      this.mRootView = paramLayoutInflater.inflate(2130903048, paramViewGroup, false);
      this.mPermissionListAdapter = new PermissionsListAdapter(this.mContext, this, this.mAppList);
      ((ListView)this.mRootView.findViewById(2131492887)).setAdapter(this.mPermissionListAdapter);
      this.mNoAppsAvailableLabel = this.mRootView.findViewById(2131492888);
    }
    refreshApplicationsList();
    return this.mRootView;
  }
  
  public String getPermissionType()
  {
    return this.mPermissionType;
  }
  
  public void permissionRevoked(String paramString)
  {
    if ((TextUtils.isEmpty(this.mPermissionType)) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    PermissionHelper.revokePermissionFromApp(this.mContext, this.mPermissionType, paramString);
    refreshApplicationsList();
    Log.i(TAG, "Permission revoked.");
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tango/PermissionsPagerContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */