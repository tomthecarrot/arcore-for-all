package com.google.atap.tango;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

public class ClearAdfDialogFragment
  extends DialogFragment
{
  private ClearAdfDialogListener mCallback;
  
  public static ClearAdfDialogFragment newInstance()
  {
    return new ClearAdfDialogFragment();
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    try
    {
      this.mCallback = ((ClearAdfDialogListener)paramActivity);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new ClassCastException(paramActivity.toString() + " must implement " + ClearAdfDialogListener.class.getSimpleName());
    }
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    new AlertDialog.Builder(getActivity()).setTitle(2131099669).setMessage(2131099668).setPositiveButton(getString(2131099667), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        ClearAdfDialogFragment.this.mCallback.onClearAdfRequested();
        ClearAdfDialogFragment.this.dismiss();
      }
    }).setNegativeButton(17039360, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        ClearAdfDialogFragment.this.dismiss();
      }
    }).create();
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    if (getActivity() != null) {
      getActivity().finish();
    }
  }
  
  public static abstract interface ClearAdfDialogListener
  {
    public abstract void onClearAdfRequested();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tango/ClearAdfDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */