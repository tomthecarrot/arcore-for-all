package com.google.atap.tango;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class RequestImportExportDialog
  extends DialogFragment
{
  private static final String KEY_APP_NAME = "app_name";
  private static final String KEY_REQUEST_TYPE = "request_type";
  private RequestImportExportListener mCallback;
  
  private Spanned getColoredSpannedString(String paramString1, String paramString2)
  {
    return Html.fromHtml(String.format(paramString1, new Object[] { "<font color=#212121>" + paramString2 + "</font>" }));
  }
  
  public static DialogFragment newInstance(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("request_type", paramString1);
    localBundle.putString("app_name", paramString2);
    paramString1 = new RequestImportExportDialog();
    paramString1.setArguments(localBundle);
    return paramString1;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    try
    {
      this.mCallback = ((RequestImportExportListener)paramActivity);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new ClassCastException(paramActivity.toString() + " must implement " + RequestImportExportListener.class.getSimpleName());
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    super.onCancel(paramDialogInterface);
    this.mCallback.onImportExportDenied();
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = super.onCreateDialog(paramBundle);
    paramBundle.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    return paramBundle;
  }
  
  public View onCreateView(final LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = getArguments().getString("request_type");
    paramViewGroup = getArguments().getString("app_name");
    paramBundle = getActivity().getLayoutInflater().inflate(2130903045, null);
    TextView localTextView = (TextView)paramBundle.findViewById(2131492884);
    if (paramLayoutInflater.equals(getString(2131099688))) {
      localTextView.setText(getColoredSpannedString(getString(2131099677), paramViewGroup));
    }
    for (;;)
    {
      ((Button)paramBundle.findViewById(2131492886)).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (paramLayoutInflater.equals(RequestImportExportDialog.this.getString(2131099688))) {
            RequestImportExportDialog.this.mCallback.onImportAccepted();
          }
          for (;;)
          {
            RequestImportExportDialog.this.dismiss();
            return;
            if (paramLayoutInflater.equals(RequestImportExportDialog.this.getString(2131099687))) {
              RequestImportExportDialog.this.mCallback.onExportAccepted();
            }
          }
        }
      });
      ((Button)paramBundle.findViewById(2131492885)).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          RequestImportExportDialog.this.mCallback.onImportExportDenied();
          RequestImportExportDialog.this.dismiss();
        }
      });
      return paramBundle;
      if (paramLayoutInflater.equals(getString(2131099687))) {
        localTextView.setText(getColoredSpannedString(getString(2131099674), paramViewGroup));
      }
    }
  }
  
  public static abstract interface RequestImportExportListener
  {
    public abstract void onExportAccepted();
    
    public abstract void onImportAccepted();
    
    public abstract void onImportExportDenied();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tango/RequestImportExportDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */