package com.google.atap.tango;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class DebugActivity
  extends Activity
{
  static final String CONFIG_FILE = "TANGO_DEBUG_CONFIG_v2";
  private static final String GFLAG_CONFIG_USE_PGS_INSTEAD_OF_VIWLS = "config_use_pgs_instead_of_viwls";
  private static final String GFLAG_HIGH_RATE_POSE = "config_high_rate_pose";
  private static final String GFLAG_SMOOTH_POSE = "config_smooth_pose";
  private static final String GFLAG_USE_3DOF_FALLBACK = "config_experimental_3dof_fallback";
  private static final int STATE_APP = 0;
  private static final int STATE_FALSE = 2;
  private static final int STATE_TRUE = 1;
  private static final String TAG = "Tango Debugger";
  private HashMap<String, String> mActiveFlags;
  
  private File getConfigFileHandle()
  {
    return new File(getApplicationContext().getFilesDir().toString(), "TANGO_DEBUG_CONFIG_v2");
  }
  
  public void loadActiveFlags()
  {
    this.mActiveFlags = new HashMap();
    Object localObject = getConfigFileHandle();
    if (((File)localObject).exists()) {
      Log.i("Tango Debugger", "Reading debug settings file: " + ((File)localObject).getPath());
    }
    try
    {
      FileReader localFileReader = new FileReader((File)localObject);
      BufferedReader localBufferedReader = new BufferedReader(localFileReader);
      for (localObject = localBufferedReader.readLine(); localObject != null; localObject = localBufferedReader.readLine())
      {
        int i = ((String)localObject).indexOf(" ");
        int j = ((String)localObject).indexOf("=");
        if ((i >= 0) && (j >= 0))
        {
          String str = ((String)localObject).substring(i + 1, j);
          localObject = ((String)localObject).substring(j + 1);
          this.mActiveFlags.put(str, localObject);
        }
      }
      localFileReader.close();
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      Log.e("Tango Debugger", "File not found: " + localFileNotFoundException.toString());
      return;
    }
    catch (IOException localIOException)
    {
      Log.e("Tango Debugger", "Cannot read file: " + localIOException.toString());
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903044);
    loadActiveFlags();
    paramBundle = (Spinner)findViewById(2131492878);
    if (!this.mActiveFlags.containsKey("config_high_rate_pose"))
    {
      paramBundle.setSelection(0);
      paramBundle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
      {
        public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          DebugActivity.this.updateFlags("config_high_rate_pose", paramAnonymousInt);
        }
        
        public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
      });
      paramBundle = (Spinner)findViewById(2131492879);
      if (this.mActiveFlags.containsKey("config_smooth_pose")) {
        break label249;
      }
      paramBundle.setSelection(0);
      label81:
      paramBundle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
      {
        public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          DebugActivity.this.updateFlags("config_smooth_pose", paramAnonymousInt);
        }
        
        public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
      });
      paramBundle = (Spinner)findViewById(2131492880);
      if (this.mActiveFlags.containsKey("config_experimental_3dof_fallback")) {
        break label285;
      }
      paramBundle.setSelection(0);
      label120:
      paramBundle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
      {
        public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          DebugActivity.this.updateFlags("config_experimental_3dof_fallback", paramAnonymousInt);
        }
        
        public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
      });
      paramBundle = (Spinner)findViewById(2131492881);
      if (this.mActiveFlags.containsKey("config_use_pgs_instead_of_viwls")) {
        break label321;
      }
      paramBundle.setSelection(0);
    }
    for (;;)
    {
      paramBundle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
      {
        public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          DebugActivity.this.updateFlags("config_use_pgs_instead_of_viwls", paramAnonymousInt);
        }
        
        public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
      });
      ((Button)findViewById(2131492877)).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramAnonymousView = DebugActivity.this.getConfigFileHandle();
          Log.i("Tango Debugger", "Deleting debug settings file: " + paramAnonymousView.getPath());
          paramAnonymousView.delete();
          DebugActivity.this.finish();
        }
      });
      ((Button)findViewById(2131492882)).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Object localObject = "\n\n" + Build.DISPLAY + "\n" + Build.SERIAL;
          paramAnonymousView = new Intent("android.intent.action.SEND_MULTIPLE");
          paramAnonymousView.setType("text/plain");
          paramAnonymousView.putExtra("android.intent.extra.EMAIL", new String[] { "tangobugreport@gmail.com" });
          paramAnonymousView.putExtra("android.intent.extra.SUBJECT", "Tango Debug Log");
          paramAnonymousView.putExtra("android.intent.extra.TEXT", "[Please describe the problem you experienced.]" + (String)localObject);
          localObject = new ArrayList();
          File localFile1 = Environment.getExternalStorageDirectory();
          File localFile2 = new File(localFile1, "tango_debug_log.txt");
          if ((!localFile2.exists()) || (!localFile2.canRead()))
          {
            Toast.makeText(jdField_this, "Error: " + DebugActivity.this.getApplicationContext().getFilesDir().toString() + "/tango_debug_log.txt not found.\nDid you enable debugging and then run an app to log?", 1).show();
            DebugActivity.this.finish();
            return;
          }
          ((ArrayList)localObject).add(Uri.fromFile(localFile2));
          localFile1 = new File(localFile1, "calibration.xml");
          if ((localFile1.exists()) && (localFile1.canRead())) {
            ((ArrayList)localObject).add(Uri.fromFile(localFile1));
          }
          paramAnonymousView.putParcelableArrayListExtra("android.intent.extra.STREAM", (ArrayList)localObject);
          DebugActivity.this.startActivity(paramAnonymousView);
          DebugActivity.this.finish();
        }
      });
      return;
      if (((String)this.mActiveFlags.get("config_high_rate_pose")).equalsIgnoreCase("true"))
      {
        paramBundle.setSelection(1);
        break;
      }
      paramBundle.setSelection(2);
      break;
      label249:
      if (((String)this.mActiveFlags.get("config_smooth_pose")).equalsIgnoreCase("true"))
      {
        paramBundle.setSelection(1);
        break label81;
      }
      paramBundle.setSelection(2);
      break label81;
      label285:
      if (((String)this.mActiveFlags.get("config_experimental_3dof_fallback")).equalsIgnoreCase("true"))
      {
        paramBundle.setSelection(1);
        break label120;
      }
      paramBundle.setSelection(2);
      break label120;
      label321:
      if (((String)this.mActiveFlags.get("config_use_pgs_instead_of_viwls")).equalsIgnoreCase("true")) {
        paramBundle.setSelection(1);
      } else {
        paramBundle.setSelection(2);
      }
    }
  }
  
  public void updateFlags(String paramString, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.mActiveFlags.remove(paramString);
    }
    for (;;)
    {
      writeConfigFile();
      return;
      this.mActiveFlags.put(paramString, "true");
      continue;
      this.mActiveFlags.put(paramString, "false");
    }
  }
  
  public void writeConfigFile()
  {
    Object localObject = getConfigFileHandle();
    try
    {
      FileWriter localFileWriter = new FileWriter((File)localObject);
      Log.i("Tango Debugger", "Writing debug settings file: " + ((File)localObject).getPath());
      localObject = this.mActiveFlags.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        localFileWriter.write("bool " + str + "=" + (String)this.mActiveFlags.get(str) + "\n");
      }
      localIOException.flush();
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return;
    }
    localIOException.close();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tango/DebugActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */