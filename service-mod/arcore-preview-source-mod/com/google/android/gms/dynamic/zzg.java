package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

public final class zzg
  extends zzc.zza
{
  private Fragment zzbip;
  
  private zzg(Fragment paramFragment)
  {
    this.zzbip = paramFragment;
  }
  
  public static zzg zza(Fragment paramFragment)
  {
    if (paramFragment != null) {
      return new zzg(paramFragment);
    }
    return null;
  }
  
  public Bundle getArguments()
  {
    return this.zzbip.getArguments();
  }
  
  public int getId()
  {
    return this.zzbip.getId();
  }
  
  public boolean getRetainInstance()
  {
    return this.zzbip.getRetainInstance();
  }
  
  public String getTag()
  {
    return this.zzbip.getTag();
  }
  
  public int getTargetRequestCode()
  {
    return this.zzbip.getTargetRequestCode();
  }
  
  public boolean getUserVisibleHint()
  {
    return this.zzbip.getUserVisibleHint();
  }
  
  public IObjectWrapper getView()
  {
    return zzd.zzJ(this.zzbip.getView());
  }
  
  public boolean isAdded()
  {
    return this.zzbip.isAdded();
  }
  
  public boolean isDetached()
  {
    return this.zzbip.isDetached();
  }
  
  public boolean isHidden()
  {
    return this.zzbip.isHidden();
  }
  
  public boolean isInLayout()
  {
    return this.zzbip.isInLayout();
  }
  
  public boolean isRemoving()
  {
    return this.zzbip.isRemoving();
  }
  
  public boolean isResumed()
  {
    return this.zzbip.isResumed();
  }
  
  public boolean isVisible()
  {
    return this.zzbip.isVisible();
  }
  
  public void setHasOptionsMenu(boolean paramBoolean)
  {
    this.zzbip.setHasOptionsMenu(paramBoolean);
  }
  
  public void setMenuVisibility(boolean paramBoolean)
  {
    this.zzbip.setMenuVisibility(paramBoolean);
  }
  
  public void setRetainInstance(boolean paramBoolean)
  {
    this.zzbip.setRetainInstance(paramBoolean);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    this.zzbip.setUserVisibleHint(paramBoolean);
  }
  
  public void startActivity(Intent paramIntent)
  {
    this.zzbip.startActivity(paramIntent);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    this.zzbip.startActivityForResult(paramIntent, paramInt);
  }
  
  public IObjectWrapper zzER()
  {
    return zzd.zzJ(this.zzbip.getActivity());
  }
  
  public zzc zzES()
  {
    return zza(this.zzbip.getParentFragment());
  }
  
  public IObjectWrapper zzET()
  {
    return zzd.zzJ(this.zzbip.getResources());
  }
  
  public zzc zzEU()
  {
    return zza(this.zzbip.getTargetFragment());
  }
  
  public void zzG(IObjectWrapper paramIObjectWrapper)
  {
    paramIObjectWrapper = (View)zzd.zzI(paramIObjectWrapper);
    this.zzbip.registerForContextMenu(paramIObjectWrapper);
  }
  
  public void zzH(IObjectWrapper paramIObjectWrapper)
  {
    paramIObjectWrapper = (View)zzd.zzI(paramIObjectWrapper);
    this.zzbip.unregisterForContextMenu(paramIObjectWrapper);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/dynamic/zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */