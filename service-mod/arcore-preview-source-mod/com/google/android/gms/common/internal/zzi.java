package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import com.google.android.gms.internal.zzzt;

public abstract class zzi
  implements DialogInterface.OnClickListener
{
  public static zzi zza(final Activity paramActivity, Intent paramIntent, final int paramInt)
  {
    new zzi()
    {
      public void zzzN()
      {
        if (zzi.this != null) {
          paramActivity.startActivityForResult(zzi.this, paramInt);
        }
      }
    };
  }
  
  public static zzi zza(@NonNull final Fragment paramFragment, Intent paramIntent, final int paramInt)
  {
    new zzi()
    {
      public void zzzN()
      {
        if (zzi.this != null) {
          paramFragment.startActivityForResult(zzi.this, paramInt);
        }
      }
    };
  }
  
  public static zzi zza(@NonNull final zzzt paramzzzt, Intent paramIntent, final int paramInt)
  {
    new zzi()
    {
      public void zzzN()
      {
        if (zzi.this != null) {
          paramzzzt.startActivityForResult(zzi.this, paramInt);
        }
      }
    };
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      zzzN();
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      Log.e("DialogRedirect", "Failed to start resolution intent", localActivityNotFoundException);
      return;
    }
    finally
    {
      paramDialogInterface.dismiss();
    }
  }
  
  protected abstract void zzzN();
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/internal/zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */