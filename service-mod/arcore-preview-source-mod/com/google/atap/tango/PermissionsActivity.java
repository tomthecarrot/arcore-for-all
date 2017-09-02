package com.google.atap.tango;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.MenuItem;

public class PermissionsActivity
  extends Activity
{
  private int mCurrentPosition = 0;
  private ViewPager mPager;
  private PermissionsPagerAdapter mPagerAdapter;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903041);
    getActionBar().setTitle(getString(2131099702));
    getActionBar().setHomeButtonEnabled(true);
    ((PagerTabStrip)findViewById(2131492874)).setTabIndicatorColorResource(17170459);
    this.mPager = ((ViewPager)findViewById(2131492873));
    this.mPagerAdapter = new PermissionsPagerAdapter(this, getLayoutInflater(), this.mPager);
    this.mPager.setAdapter(this.mPagerAdapter);
    this.mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public void onPageScrollStateChanged(int paramAnonymousInt)
      {
        if (paramAnonymousInt == 0) {
          PermissionsActivity.this.mPager.setCurrentItem(PermissionsActivity.this.mCurrentPosition);
        }
      }
      
      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
      
      public void onPageSelected(int paramAnonymousInt)
      {
        PermissionsActivity.access$002(PermissionsActivity.this, paramAnonymousInt);
      }
    });
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      onBackPressed();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  protected void onResume()
  {
    super.onResume();
    this.mPagerAdapter.getTab(this.mPager.getCurrentItem()).buildView(getLayoutInflater(), this.mPager);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tango/PermissionsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */