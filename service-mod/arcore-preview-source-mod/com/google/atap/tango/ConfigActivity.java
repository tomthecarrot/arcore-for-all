package com.google.atap.tango;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ConfigActivity
  extends Activity
{
  private static final String GFLAG_ANTIBANDING_50HZ = "config_antibanding_50hz";
  private static final int STATE_APP = 0;
  private static final int STATE_FALSE = 2;
  private static final int STATE_TRUE = 1;
  private static final String TAG = "Tango Configuration";
  private HashMap<String, String> mActiveFlags;
  private TangoInternal mTangoInternal;
  
  private File getConfigFileHandle()
  {
    return new File(getApplicationContext().getFilesDir().toString(), "TANGO_DEBUG_CONFIG_v2");
  }
  
  public void loadActiveFlags()
  {
    this.mActiveFlags = new HashMap();
    Object localObject = getConfigFileHandle();
    if (((File)localObject).exists()) {}
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
      Log.e("Tango Configuration", "File not found: " + localFileNotFoundException.toString());
      return;
    }
    catch (IOException localIOException)
    {
      Log.e("Tango Configuration", "Cannot read file: " + localIOException.toString());
    }
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903043);
    loadActiveFlags();
    paramBundle = getApplicationContext();
    final Spinner localSpinner = (Spinner)findViewById(2131492876);
    if (!this.mActiveFlags.containsKey("config_antibanding_50hz")) {
      localSpinner.setSelection(0);
    }
    for (;;)
    {
      localSpinner.setEnabled(false);
      localSpinner.post(new Runnable()
      {
        public void run()
        {
          localSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
          {
            public void onItemSelected(AdapterView<?> paramAnonymous2AdapterView, View paramAnonymous2View, int paramAnonymous2Int, long paramAnonymous2Long)
            {
              ConfigActivity.this.updateFlags("config_antibanding_50hz", paramAnonymous2Int);
              new Thread(new Runnable()
              {
                public void run()
                {
                  try
                  {
                    ConfigActivity.this.mTangoInternal.forceSystemServiceReset();
                    return;
                  }
                  catch (Exception localException)
                  {
                    localException.printStackTrace();
                  }
                }
              }).start();
              Toast.makeText(ConfigActivity.1.this.val$context, "Changing antibanding mode. Please wait.", 1).show();
            }
            
            public void onNothingSelected(AdapterView<?> paramAnonymous2AdapterView) {}
          });
        }
      });
      final Button localButton = (Button)findViewById(2131492877);
      localButton.setEnabled(false);
      localButton.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          ConfigActivity.this.getConfigFileHandle().delete();
          new Thread(new Runnable()
          {
            public void run()
            {
              try
              {
                ConfigActivity.this.mTangoInternal.forceSystemServiceReset();
                return;
              }
              catch (Exception localException)
              {
                localException.printStackTrace();
              }
            }
          }).start();
          Toast.makeText(paramBundle, "Changing antibanding mode. Please wait.", 1).show();
          ConfigActivity.this.finish();
        }
      });
      this.mTangoInternal = new TangoInternal(this, new Runnable()
      {
        public void run()
        {
          ConfigActivity.this.runOnUiThread(new Runnable()
          {
            public void run()
            {
              ConfigActivity.3.this.val$antibanding50hzSpinner.setEnabled(true);
              ConfigActivity.3.this.val$resetButton.setEnabled(true);
            }
          });
        }
      });
      return;
      if (((String)this.mActiveFlags.get("config_antibanding_50hz")).equalsIgnoreCase("true")) {
        localSpinner.setSelection(1);
      } else {
        localSpinner.setSelection(2);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mTangoInternal.disconnect();
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
      Log.i("Tango Configuration", "Writing debug settings file: " + ((File)localObject).getPath());
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


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tango/ConfigActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */