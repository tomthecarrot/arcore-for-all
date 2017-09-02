package com.google.android.gms.analytics.internal;

public abstract class zzd
  extends zzc
{
  private boolean zzady;
  
  protected zzd(zzf paramzzf)
  {
    super(paramzzf);
  }
  
  public void initialize()
  {
    onInitialize();
    this.zzady = true;
  }
  
  public boolean isInitialized()
  {
    return this.zzady;
  }
  
  protected abstract void onInitialize();
  
  protected void zznA()
  {
    if (!isInitialized()) {
      throw new IllegalStateException("Not initialized");
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/internal/zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */