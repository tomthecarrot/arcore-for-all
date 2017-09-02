package com.google.android.gms.dynamic;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

@SuppressLint({"NewApi"})
public final class zzb
  extends zzc.zza
{
  private Fragment zzbim;
  
  private zzb(Fragment paramFragment)
  {
    this.zzbim = paramFragment;
  }
  
  public static zzb zza(Fragment paramFragment)
  {
    if (paramFragment != null) {
      return new zzb(paramFragment);
    }
    return null;
  }
  
  public Bundle getArguments()
  {
    return this.zzbim.getArguments();
  }
  
  public int getId()
  {
    return this.zzbim.getId();
  }
  
  public boolean getRetainInstance()
  {
    return this.zzbim.getRetainInstance();
  }
  
  public String getTag()
  {
    return this.zzbim.getTag();
  }
  
  public int getTargetRequestCode()
  {
    return this.zzbim.getTargetRequestCode();
  }
  
  public boolean getUserVisibleHint()
  {
    return this.zzbim.getUserVisibleHint();
  }
  
  public IObjectWrapper getView()
  {
    return zzd.zzJ(this.zzbim.getView());
  }
  
  public boolean isAdded()
  {
    return this.zzbim.isAdded();
  }
  
  public boolean isDetached()
  {
    return this.zzbim.isDetached();
  }
  
  public boolean isHidden()
  {
    return this.zzbim.isHidden();
  }
  
  public boolean isInLayout()
  {
    return this.zzbim.isInLayout();
  }
  
  public boolean isRemoving()
  {
    return this.zzbim.isRemoving();
  }
  
  public boolean isResumed()
  {
    return this.zzbim.isResumed();
  }
  
  public boolean isVisible()
  {
    return this.zzbim.isVisible();
  }
  
  public void setHasOptionsMenu(boolean paramBoolean)
  {
    this.zzbim.setHasOptionsMenu(paramBoolean);
  }
  
  public void setMenuVisibility(boolean paramBoolean)
  {
    this.zzbim.setMenuVisibility(paramBoolean);
  }
  
  public void setRetainInstance(boolean paramBoolean)
  {
    this.zzbim.setRetainInstance(paramBoolean);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    this.zzbim.setUserVisibleHint(paramBoolean);
  }
  
  public void startActivity(Intent paramIntent)
  {
    this.zzbim.startActivity(paramIntent);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    this.zzbim.startActivityForResult(paramIntent, paramInt);
  }
  
  public IObjectWrapper zzER()
  {
    return zzd.zzJ(this.zzbim.getActivity());
  }
  
  public zzc zzES()
  {
    return zza(this.zzbim.getParentFragment());
  }
  
  public IObjectWrapper zzET()
  {
    return zzd.zzJ(this.zzbim.getResources());
  }
  
  public zzc zzEU()
  {
    return zza(this.zzbim.getTargetFragment());
  }
  
  public void zzG(IObjectWrapper paramIObjectWrapper)
  {
    paramIObjectWrapper = (View)zzd.zzI(paramIObjectWrapper);
    this.zzbim.registerForContextMenu(paramIObjectWrapper);
  }
  
  public void zzH(IObjectWrapper paramIObjectWrapper)
  {
    paramIObjectWrapper = (View)zzd.zzI(paramIObjectWrapper);
    this.zzbim.unregisterForContextMenu(paramIObjectWrapper);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/dynamic/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */