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
import android.widget.ImageView;
import android.widget.TextView;

public class RequestPermissionDialog
  extends DialogFragment
{
  private static final String KEY_APP_NAME = "app_name";
  private static final String KEY_CALLING_PACKAGE = "calling_package";
  private static final String KEY_REQUEST_TYPE = "request_type";
  private RequestPermissionListener mCallback;
  
  private Spanned getColoredSpannedString(String paramString1, String paramString2, String paramString3)
  {
    return Html.fromHtml(String.format(paramString1, new Object[] { "<font color=#212121>" + paramString2 + "</font>", "<font color=#212121>" + paramString3 + "</font>" }));
  }
  
  public static DialogFragment newInstance(String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("calling_package", paramString1);
    localBundle.putString("request_type", paramString3);
    localBundle.putString("app_name", paramString2);
    paramString1 = new RequestPermissionDialog();
    paramString1.setArguments(localBundle);
    return paramString1;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    try
    {
      this.mCallback = ((RequestPermissionListener)paramActivity);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new ClassCastException(paramActivity.toString() + " must implement " + RequestPermissionListener.class.getSimpleName());
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    super.onCancel(paramDialogInterface);
    this.mCallback.onPermissionDenied();
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
    paramLayoutInflater = getArguments().getString("calling_package");
    paramViewGroup = getArguments().getString("request_type");
    paramBundle = getArguments().getString("app_name");
    View localView = getActivity().getLayoutInflater().inflate(2130903046, null);
    ImageView localImageView = (ImageView)localView.findViewById(2131492883);
    TextView localTextView = (TextView)localView.findViewById(2131492884);
    if (paramViewGroup.equals(getString(2131099689))) {
      localTextView.setText(getString(2131099693));
    }
    for (;;)
    {
      ((Button)localView.findViewById(2131492886)).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          RequestPermissionDialog.this.mCallback.onPermissionAccepted(paramLayoutInflater);
          RequestPermissionDialog.this.dismiss();
        }
      });
      ((Button)localView.findViewById(2131492885)).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          RequestPermissionDialog.this.mCallback.onPermissionDenied();
          RequestPermissionDialog.this.dismiss();
        }
      });
      return localView;
      if (paramViewGroup.equals(getString(2131099685)))
      {
        localTextView.setText(getColoredSpannedString(getString(2131099690), paramBundle, getString(2131099685)));
        localImageView.setImageResource(2130837533);
      }
      else if (paramViewGroup.equals(getString(2131099686)))
      {
        localTextView.setText(getColoredSpannedString(getString(2131099691), paramBundle, getString(2131099709)));
        localImageView.setImageResource(2130837534);
      }
    }
  }
  
  public static abstract interface RequestPermissionListener
  {
    public abstract void onPermissionAccepted(String paramString);
    
    public abstract void onPermissionDenied();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tango/RequestPermissionDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */