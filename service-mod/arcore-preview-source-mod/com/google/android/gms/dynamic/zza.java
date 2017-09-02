package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.zzh;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class zza<T extends LifecycleDelegate>
{
  private LinkedList<zza> zzajA;
  private final zze<T> zzajB = new zze()
  {
    public void zza(T paramAnonymousT)
    {
      zza.zza(zza.this, paramAnonymousT);
      paramAnonymousT = zza.zza(zza.this).iterator();
      while (paramAnonymousT.hasNext()) {
        ((zza.zza)paramAnonymousT.next()).zzb(zza.zzb(zza.this));
      }
      zza.zza(zza.this).clear();
      zza.zza(zza.this, null);
    }
  };
  private T zzajy;
  private Bundle zzajz;
  
  private void zza(Bundle paramBundle, zza paramzza)
  {
    if (this.zzajy != null)
    {
      paramzza.zzb(this.zzajy);
      return;
    }
    if (this.zzajA == null) {
      this.zzajA = new LinkedList();
    }
    this.zzajA.add(paramzza);
    if (paramBundle != null)
    {
      if (this.zzajz != null) {
        break label76;
      }
      this.zzajz = ((Bundle)paramBundle.clone());
    }
    for (;;)
    {
      zza(this.zzajB);
      return;
      label76:
      this.zzajz.putAll(paramBundle);
    }
  }
  
  @VisibleForTesting
  static void zza(final FrameLayout paramFrameLayout, GoogleApiAvailability paramGoogleApiAvailability)
  {
    Context localContext = paramFrameLayout.getContext();
    int i = paramGoogleApiAvailability.isGooglePlayServicesAvailable(localContext);
    String str2 = zzh.zzi(localContext, i);
    String str1 = zzh.zzk(localContext, i);
    LinearLayout localLinearLayout = new LinearLayout(paramFrameLayout.getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    paramFrameLayout.addView(localLinearLayout);
    paramFrameLayout = new TextView(paramFrameLayout.getContext());
    paramFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    paramFrameLayout.setText(str2);
    localLinearLayout.addView(paramFrameLayout);
    paramFrameLayout = paramGoogleApiAvailability.getErrorResolutionIntent(localContext, i, null);
    if (paramFrameLayout != null)
    {
      paramGoogleApiAvailability = new Button(localContext);
      paramGoogleApiAvailability.setId(16908313);
      paramGoogleApiAvailability.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
      paramGoogleApiAvailability.setText(str1);
      localLinearLayout.addView(paramGoogleApiAvailability);
      paramGoogleApiAvailability.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          try
          {
            zza.this.startActivity(paramFrameLayout);
            return;
          }
          catch (ActivityNotFoundException paramAnonymousView)
          {
            Log.e("DeferredLifecycleHelper", "Failed to start resolution intent", paramAnonymousView);
          }
        }
      });
    }
  }
  
  public static void zzb(FrameLayout paramFrameLayout)
  {
    zza(paramFrameLayout, GoogleApiAvailability.getInstance());
  }
  
  private void zzbt(int paramInt)
  {
    while ((!this.zzajA.isEmpty()) && (((zza)this.zzajA.getLast()).getState() >= paramInt)) {
      this.zzajA.removeLast();
    }
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    zza(paramBundle, new zza()
    {
      public int getState()
      {
        return 1;
      }
      
      public void zzb(LifecycleDelegate paramAnonymousLifecycleDelegate)
      {
        zza.zzb(zza.this).onCreate(paramBundle);
      }
    });
  }
  
  public View onCreateView(final LayoutInflater paramLayoutInflater, final ViewGroup paramViewGroup, final Bundle paramBundle)
  {
    final FrameLayout localFrameLayout = new FrameLayout(paramLayoutInflater.getContext());
    zza(paramBundle, new zza()
    {
      public int getState()
      {
        return 2;
      }
      
      public void zzb(LifecycleDelegate paramAnonymousLifecycleDelegate)
      {
        localFrameLayout.removeAllViews();
        localFrameLayout.addView(zza.zzb(zza.this).onCreateView(paramLayoutInflater, paramViewGroup, paramBundle));
      }
    });
    if (this.zzajy == null) {
      zza(localFrameLayout);
    }
    return localFrameLayout;
  }
  
  public void onDestroy()
  {
    if (this.zzajy != null)
    {
      this.zzajy.onDestroy();
      return;
    }
    zzbt(1);
  }
  
  public void onDestroyView()
  {
    if (this.zzajy != null)
    {
      this.zzajy.onDestroyView();
      return;
    }
    zzbt(2);
  }
  
  public void onInflate(final Activity paramActivity, final Bundle paramBundle1, final Bundle paramBundle2)
  {
    zza(paramBundle2, new zza()
    {
      public int getState()
      {
        return 0;
      }
      
      public void zzb(LifecycleDelegate paramAnonymousLifecycleDelegate)
      {
        zza.zzb(zza.this).onInflate(paramActivity, paramBundle1, paramBundle2);
      }
    });
  }
  
  public void onLowMemory()
  {
    if (this.zzajy != null) {
      this.zzajy.onLowMemory();
    }
  }
  
  public void onPause()
  {
    if (this.zzajy != null)
    {
      this.zzajy.onPause();
      return;
    }
    zzbt(5);
  }
  
  public void onResume()
  {
    zza(null, new zza()
    {
      public int getState()
      {
        return 5;
      }
      
      public void zzb(LifecycleDelegate paramAnonymousLifecycleDelegate)
      {
        zza.zzb(zza.this).onResume();
      }
    });
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (this.zzajy != null) {
      this.zzajy.onSaveInstanceState(paramBundle);
    }
    while (this.zzajz == null) {
      return;
    }
    paramBundle.putAll(this.zzajz);
  }
  
  public void onStart()
  {
    zza(null, new zza()
    {
      public int getState()
      {
        return 4;
      }
      
      public void zzb(LifecycleDelegate paramAnonymousLifecycleDelegate)
      {
        zza.zzb(zza.this).onStart();
      }
    });
  }
  
  public void onStop()
  {
    if (this.zzajy != null)
    {
      this.zzajy.onStop();
      return;
    }
    zzbt(4);
  }
  
  public T zzEQ()
  {
    return this.zzajy;
  }
  
  protected void zza(FrameLayout paramFrameLayout)
  {
    zzb(paramFrameLayout);
  }
  
  protected abstract void zza(zze<T> paramzze);
  
  private static abstract interface zza
  {
    public abstract int getState();
    
    public abstract void zzb(LifecycleDelegate paramLifecycleDelegate);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/dynamic/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */