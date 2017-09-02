package com.google.atap.tango;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TangoSettingsActivity
  extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903042);
    PermissionHelper.createPermissionFilesIfMissing(this);
    getFragmentManager().beginTransaction().add(2131492875, new SettingsFragment()).commit();
  }
  
  public static class SettingsFragment
    extends PreferenceFragment
  {
    private TangoInternal mTangoInternal;
    
    private void initializeCheckboxes()
    {
      getActivity().runOnUiThread(new Runnable()
      {
        public void run()
        {
          Preference localPreference = TangoSettingsActivity.SettingsFragment.this.getPreferenceScreen().findPreference(TangoSettingsActivity.SettingsFragment.this.getString(2131099678));
          if (localPreference != null) {
            localPreference.setEnabled(ClearAdfActivity.hasAdfFiles(TangoSettingsActivity.SettingsFragment.this.getActivity(), TangoSettingsActivity.SettingsFragment.this.mTangoInternal));
          }
          localPreference = TangoSettingsActivity.SettingsFragment.this.getPreferenceScreen().findPreference(TangoSettingsActivity.SettingsFragment.this.getString(2131099715));
          if (localPreference != null) {
            localPreference.setEnabled(UploadUserSegmentsActivity.hasUserSegments());
          }
        }
      });
    }
    
    private String readLicensesFile()
    {
      StringBuilder localStringBuilder;
      try
      {
        BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(getActivity().getAssets().open("licenses.txt"), "UTF-8"));
        localStringBuilder = new StringBuilder();
        for (;;)
        {
          String str2 = localBufferedReader.readLine();
          if (str2 == null) {
            break;
          }
          localStringBuilder.append(str2);
          localStringBuilder.append("\n");
        }
        localIOException.close();
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        return "";
      }
      String str1 = localStringBuilder.toString();
      return str1;
    }
    
    private void showLicenses()
    {
      new AlertDialog.Builder(getActivity()).setMessage(readLicensesFile()).setCancelable(true).setPositiveButton(getString(2131099683), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousDialogInterface.cancel();
        }
      }).show();
    }
    
    public void onCreate(Bundle paramBundle)
    {
      super.onCreate(paramBundle);
      addPreferencesFromResource(2130968579);
      addPreferencesFromResource(2130968576);
      if ((Build.TYPE.contains("userdebug")) || (Build.TYPE.contains("eng")))
      {
        addPreferencesFromResource(2130968582);
        addPreferencesFromResource(2130968577);
        addPreferencesFromResource(2130968581);
      }
      if (BootReceiver.isTangoDevKitDevice()) {
        addPreferencesFromResource(2130968580);
      }
      addPreferencesFromResource(2130968578);
      findPreference(getString(2131099679)).setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
      {
        public boolean onPreferenceClick(Preference paramAnonymousPreference)
        {
          TangoSettingsActivity.SettingsFragment.this.showLicenses();
          return true;
        }
      });
    }
    
    public void onPause()
    {
      super.onPause();
      this.mTangoInternal.disconnect();
    }
    
    public void onResume()
    {
      super.onResume();
      this.mTangoInternal = new TangoInternal(getActivity(), new Runnable()
      {
        public void run()
        {
          TangoSettingsActivity.SettingsFragment.this.initializeCheckboxes();
        }
      });
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tango/TangoSettingsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */