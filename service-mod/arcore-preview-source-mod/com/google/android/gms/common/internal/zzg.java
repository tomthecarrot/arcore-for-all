package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzbgd;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zzg
{
  private final Set<Scope> zzaKI;
  private final int zzaKK;
  private final View zzaKL;
  private final String zzaKM;
  private final Set<Scope> zzaRD;
  private final Map<Api<?>, zza> zzaRE;
  private final zzbgd zzaRF;
  private Integer zzaRG;
  private final Account zzagc;
  private final String zzaiS;
  
  public zzg(Account paramAccount, Set<Scope> paramSet, Map<Api<?>, zza> paramMap, int paramInt, View paramView, String paramString1, String paramString2, zzbgd paramzzbgd)
  {
    this.zzagc = paramAccount;
    if (paramSet == null) {}
    for (paramAccount = Collections.EMPTY_SET;; paramAccount = Collections.unmodifiableSet(paramSet))
    {
      this.zzaKI = paramAccount;
      paramAccount = paramMap;
      if (paramMap == null) {
        paramAccount = Collections.EMPTY_MAP;
      }
      this.zzaRE = paramAccount;
      this.zzaKL = paramView;
      this.zzaKK = paramInt;
      this.zzaiS = paramString1;
      this.zzaKM = paramString2;
      this.zzaRF = paramzzbgd;
      paramAccount = new HashSet(this.zzaKI);
      paramSet = this.zzaRE.values().iterator();
      while (paramSet.hasNext()) {
        paramAccount.addAll(((zza)paramSet.next()).zzamH);
      }
    }
    this.zzaRD = Collections.unmodifiableSet(paramAccount);
  }
  
  public static zzg zzaZ(Context paramContext)
  {
    return new GoogleApiClient.Builder(paramContext).zzxc();
  }
  
  public Account getAccount()
  {
    return this.zzagc;
  }
  
  @Deprecated
  public String getAccountName()
  {
    if (this.zzagc != null) {
      return this.zzagc.name;
    }
    return null;
  }
  
  public Set<Scope> zzc(Api<?> paramApi)
  {
    paramApi = (zza)this.zzaRE.get(paramApi);
    if ((paramApi == null) || (paramApi.zzamH.isEmpty())) {
      return this.zzaKI;
    }
    HashSet localHashSet = new HashSet(this.zzaKI);
    localHashSet.addAll(paramApi.zzamH);
    return localHashSet;
  }
  
  public void zzd(Integer paramInteger)
  {
    this.zzaRG = paramInteger;
  }
  
  public int zzzE()
  {
    return this.zzaKK;
  }
  
  public Set<Scope> zzzF()
  {
    return this.zzaKI;
  }
  
  public Set<Scope> zzzG()
  {
    return this.zzaRD;
  }
  
  public Map<Api<?>, zza> zzzH()
  {
    return this.zzaRE;
  }
  
  public String zzzI()
  {
    return this.zzaiS;
  }
  
  public String zzzJ()
  {
    return this.zzaKM;
  }
  
  public View zzzK()
  {
    return this.zzaKL;
  }
  
  public zzbgd zzzL()
  {
    return this.zzaRF;
  }
  
  public Integer zzzM()
  {
    return this.zzaRG;
  }
  
  public Account zzzu()
  {
    if (this.zzagc != null) {
      return this.zzagc;
    }
    return new Account("<<default account>>", "com.google");
  }
  
  public static final class zza
  {
    public final Set<Scope> zzamH;
    
    public zza(Set<Scope> paramSet)
    {
      zzac.zzC(paramSet);
      this.zzamH = Collections.unmodifiableSet(paramSet);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/internal/zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */