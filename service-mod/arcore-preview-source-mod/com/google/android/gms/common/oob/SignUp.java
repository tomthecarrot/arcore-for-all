package com.google.android.gms.common.oob;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzf;
import java.io.IOException;

public class SignUp
{
  public static final String ACTION_OOB_SIGN_UP = "com.google.android.gms.common.oob.OOB_SIGN_UP";
  public static final String EXTRAS_CALLING_APP_DESCRIPTION = "com.google.android.gms.common.oob.EXTRAS_APP_DESCRIPTION";
  public static final String EXTRAS_CLIENT_CALLING_APP_PACKAGE = "com.google.android.gms.common.oob.EXTRAS_CLIENT_CALLING_APP_PACKAGE";
  public static final String EXTRAS_PROMO_APP_PACKAGE = "com.google.android.gms.common.oob.EXTRAS_PROMO_APP_PACKAGE";
  public static final String EXTRAS_PROMO_APP_TEXT = "com.google.android.gms.common.oob.EXTRAS_PROMO_APP_TEXT";
  public static final String EXTRA_ACCOUNT_NAME = "com.google.android.gms.common.oob.EXTRA_ACCOUNT_NAME";
  public static final String EXTRA_BACK_BUTTON_NAME = "com.google.android.gms.common.oob.EXTRA_BACK_BUTTON_NAME";
  public static final String EXTRA_GPSRC = "com.google.android.gms.plus.GPSRC";
  public static final String EXTRA_OVERRIDE_THEME = "com.google.android.gms.plus.OVERRIDE_THEME";
  public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = zzf.GOOGLE_PLUS_REQUIRED_FEATURES;
  public static final int THEME_DEFAULT = 0;
  public static final int THEME_FULL = 1;
  public static final int THEME_SETUP_WIZARD = 2;
  
  public static AccountManagerFuture<Boolean> checkSignUpState(Context paramContext, String paramString, String[] paramArrayOfString, AccountManagerCallback<Boolean> paramAccountManagerCallback, Handler paramHandler)
  {
    int i = 0;
    if (!TextUtils.isEmpty(paramString))
    {
      bool = true;
      zzac.zzb(bool, "The accountName is required");
      if (paramArrayOfString == null) {
        break label95;
      }
    }
    int j;
    label95:
    for (boolean bool = true;; bool = false)
    {
      zzac.zzb(bool, "The requiredFeatures parameter is required");
      paramContext = AccountManager.get(paramContext);
      Account[] arrayOfAccount = paramContext.getAccountsByType("com.google");
      int k = arrayOfAccount.length;
      j = 0;
      while (i < k)
      {
        if (paramString.equals(arrayOfAccount[i].name)) {
          j = 1;
        }
        i += 1;
      }
      bool = false;
      break;
    }
    if (j == 0) {
      throw new IllegalStateException("Given account does not exist on the device");
    }
    return paramContext.hasFeatures(new Account(paramString, "com.google"), paramArrayOfString, paramAccountManagerCallback, paramHandler);
  }
  
  public static boolean isSignedUpBlocking(Context paramContext, String paramString, String[] paramArrayOfString)
    throws AuthenticatorException, OperationCanceledException, IOException
  {
    return ((Boolean)checkSignUpState(paramContext, paramString, paramArrayOfString, null, null).getResult()).booleanValue();
  }
  
  public static Intent newSignUpIntent(String paramString)
  {
    return newSignUpIntent(paramString, null);
  }
  
  public static Intent newSignUpIntent(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.setPackage("com.google.android.gms");
    localIntent.setAction("com.google.android.gms.common.oob.OOB_SIGN_UP");
    localIntent.putExtra("com.google.android.gms.common.oob.EXTRA_ACCOUNT_NAME", paramString1);
    localIntent.putExtra("com.google.android.gms.common.oob.EXTRA_BACK_BUTTON_NAME", paramString2);
    return localIntent;
  }
  
  public static Intent newSignUpIntent(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Intent localIntent = new Intent();
    localIntent.setPackage("com.google.android.gms");
    localIntent.setAction("com.google.android.gms.common.oob.OOB_SIGN_UP");
    localIntent.putExtra("com.google.android.gms.common.oob.EXTRA_ACCOUNT_NAME", paramString1);
    localIntent.putExtra("com.google.android.gms.common.oob.EXTRA_BACK_BUTTON_NAME", paramString2);
    localIntent.putExtra("com.google.android.gms.common.oob.EXTRAS_PROMO_APP_PACKAGE", paramString3);
    localIntent.putExtra("com.google.android.gms.common.oob.EXTRAS_PROMO_APP_TEXT", paramString4);
    return localIntent;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/oob/SignUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */