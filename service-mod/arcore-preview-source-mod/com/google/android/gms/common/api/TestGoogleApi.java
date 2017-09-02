package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.internal.zzym;

public class TestGoogleApi<O extends Api.ApiOptions>
  extends zzd<O>
{
  public TestGoogleApi(@NonNull Context paramContext, Api<O> paramApi, O paramO, Looper paramLooper)
  {
    super(paramContext, paramApi, paramO, paramLooper, new zzym());
  }
  
  public TestGoogleApi(@NonNull FragmentActivity paramFragmentActivity, Api<O> paramApi, O paramO)
  {
    super(paramFragmentActivity, paramApi, paramO, new zzym());
  }
  
  public TestGoogleApi(@NonNull FragmentActivity paramFragmentActivity, Api<O> paramApi, O paramO, Looper paramLooper)
  {
    super(paramFragmentActivity, paramApi, paramO, paramLooper, new zzym());
  }
  
  public GoogleApiClient asGoogleApiClient()
  {
    return super.asGoogleApiClient();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/api/TestGoogleApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */