package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.zzg;
import com.google.android.gms.auth.api.signin.internal.zzh;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInOptions
  extends zza
  implements Api.ApiOptions.Optional, ReflectedParcelable
{
  public static final Parcelable.Creator<GoogleSignInOptions> CREATOR = new zzb();
  public static final GoogleSignInOptions DEFAULT_GAMES_SIGN_IN;
  public static final GoogleSignInOptions DEFAULT_SIGN_IN;
  public static final Scope SCOPE_GAMES;
  public static final Scope zzamA;
  private static Comparator<Scope> zzamx = new Comparator()
  {
    public int zza(Scope paramAnonymousScope1, Scope paramAnonymousScope2)
    {
      return paramAnonymousScope1.zzxg().compareTo(paramAnonymousScope2.zzxg());
    }
  };
  public static final Scope zzamy = new Scope("profile");
  public static final Scope zzamz = new Scope("email");
  final int versionCode;
  private Account zzagc;
  private boolean zzalK;
  private String zzalL;
  private final ArrayList<Scope> zzamB;
  private final boolean zzamC;
  private final boolean zzamD;
  private String zzamE;
  private ArrayList<zzg> zzamF;
  private Map<Integer, zzg> zzamG;
  
  static
  {
    zzamA = new Scope("openid");
    SCOPE_GAMES = new Scope("https://www.googleapis.com/auth/games");
    DEFAULT_SIGN_IN = new Builder().requestId().requestProfile().build();
    DEFAULT_GAMES_SIGN_IN = new Builder().requestScopes(SCOPE_GAMES, new Scope[0]).build();
  }
  
  GoogleSignInOptions(int paramInt, ArrayList<Scope> paramArrayList, Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString1, String paramString2, ArrayList<zzg> paramArrayList1)
  {
    this(paramInt, paramArrayList, paramAccount, paramBoolean1, paramBoolean2, paramBoolean3, paramString1, paramString2, zzB(paramArrayList1));
  }
  
  private GoogleSignInOptions(int paramInt, ArrayList<Scope> paramArrayList, Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString1, String paramString2, Map<Integer, zzg> paramMap)
  {
    this.versionCode = paramInt;
    this.zzamB = paramArrayList;
    this.zzagc = paramAccount;
    this.zzalK = paramBoolean1;
    this.zzamC = paramBoolean2;
    this.zzamD = paramBoolean3;
    this.zzalL = paramString1;
    this.zzamE = paramString2;
    this.zzamF = new ArrayList(paramMap.values());
    this.zzamG = paramMap;
  }
  
  private static Map<Integer, zzg> zzB(@Nullable List<zzg> paramList)
  {
    HashMap localHashMap = new HashMap();
    if (paramList == null) {
      return localHashMap;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      zzg localzzg = (zzg)paramList.next();
      localHashMap.put(Integer.valueOf(localzzg.getType()), localzzg);
    }
    return localHashMap;
  }
  
  @Nullable
  public static GoogleSignInOptions zzbZ(@Nullable String paramString)
    throws JSONException
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject(paramString);
    HashSet localHashSet = new HashSet();
    paramString = localJSONObject.getJSONArray("scopes");
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      localHashSet.add(new Scope(paramString.getString(i)));
      i += 1;
    }
    paramString = localJSONObject.optString("accountName", null);
    if (!TextUtils.isEmpty(paramString)) {}
    for (paramString = new Account(paramString, "com.google");; paramString = null) {
      return new GoogleSignInOptions(3, new ArrayList(localHashSet), paramString, localJSONObject.getBoolean("idTokenRequested"), localJSONObject.getBoolean("serverAuthRequested"), localJSONObject.getBoolean("forceCodeForRefreshToken"), localJSONObject.optString("serverClientId", null), localJSONObject.optString("hostedDomain", null), new HashMap());
    }
  }
  
  private JSONObject zzqG()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      JSONArray localJSONArray = new JSONArray();
      Collections.sort(this.zzamB, zzamx);
      Iterator localIterator = this.zzamB.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((Scope)localIterator.next()).zzxg());
      }
      localJSONException.put("scopes", localJSONArray);
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
    if (this.zzagc != null) {
      localJSONException.put("accountName", this.zzagc.name);
    }
    localJSONException.put("idTokenRequested", this.zzalK);
    localJSONException.put("forceCodeForRefreshToken", this.zzamD);
    localJSONException.put("serverAuthRequested", this.zzamC);
    if (!TextUtils.isEmpty(this.zzalL)) {
      localJSONException.put("serverClientId", this.zzalL);
    }
    if (!TextUtils.isEmpty(this.zzamE)) {
      localJSONException.put("hostedDomain", this.zzamE);
    }
    return localJSONException;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramObject = (GoogleSignInOptions)paramObject;
        if ((this.zzamF.size() > 0) || (((GoogleSignInOptions)paramObject).zzamF.size() > 0) || (this.zzamB.size() != ((GoogleSignInOptions)paramObject).zzqH().size()) || (!this.zzamB.containsAll(((GoogleSignInOptions)paramObject).zzqH()))) {
          continue;
        }
        if (this.zzagc == null)
        {
          if (((GoogleSignInOptions)paramObject).getAccount() != null) {
            continue;
          }
          label76:
          if (!TextUtils.isEmpty(this.zzalL)) {
            break label148;
          }
          if (!TextUtils.isEmpty(((GoogleSignInOptions)paramObject).getServerClientId())) {
            continue;
          }
        }
        while ((this.zzamD == ((GoogleSignInOptions)paramObject).zzqJ()) && (this.zzalK == ((GoogleSignInOptions)paramObject).isIdTokenRequested()) && (this.zzamC == ((GoogleSignInOptions)paramObject).zzqI()))
        {
          return true;
          if (!this.zzagc.equals(((GoogleSignInOptions)paramObject).getAccount())) {
            break;
          }
          break label76;
          label148:
          boolean bool = this.zzalL.equals(((GoogleSignInOptions)paramObject).getServerClientId());
          if (!bool) {
            break;
          }
        }
        return false;
      }
      catch (ClassCastException paramObject) {}
    }
  }
  
  public Account getAccount()
  {
    return this.zzagc;
  }
  
  public Scope[] getScopeArray()
  {
    return (Scope[])this.zzamB.toArray(new Scope[this.zzamB.size()]);
  }
  
  public String getServerClientId()
  {
    return this.zzalL;
  }
  
  public int hashCode()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zzamB.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Scope)localIterator.next()).zzxg());
    }
    Collections.sort(localArrayList);
    return new zzh().zzt(localArrayList).zzt(this.zzagc).zzt(this.zzalL).zzV(this.zzamD).zzV(this.zzalK).zzV(this.zzamC).zzqS();
  }
  
  public boolean isIdTokenRequested()
  {
    return this.zzalK;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public String zzqE()
  {
    return zzqG().toString();
  }
  
  public ArrayList<Scope> zzqH()
  {
    return new ArrayList(this.zzamB);
  }
  
  public boolean zzqI()
  {
    return this.zzamC;
  }
  
  public boolean zzqJ()
  {
    return this.zzamD;
  }
  
  public String zzqK()
  {
    return this.zzamE;
  }
  
  public ArrayList<zzg> zzqL()
  {
    return this.zzamF;
  }
  
  public static final class Builder
  {
    private Account zzagc;
    private boolean zzalK;
    private String zzalL;
    private boolean zzamC;
    private boolean zzamD;
    private String zzamE;
    private Set<Scope> zzamH = new HashSet();
    private Map<Integer, zzg> zzamI = new HashMap();
    
    public Builder() {}
    
    public Builder(@NonNull GoogleSignInOptions paramGoogleSignInOptions)
    {
      zzac.zzC(paramGoogleSignInOptions);
      this.zzamH = new HashSet(GoogleSignInOptions.zzb(paramGoogleSignInOptions));
      this.zzamC = GoogleSignInOptions.zzc(paramGoogleSignInOptions);
      this.zzamD = GoogleSignInOptions.zzd(paramGoogleSignInOptions);
      this.zzalK = GoogleSignInOptions.zze(paramGoogleSignInOptions);
      this.zzalL = GoogleSignInOptions.zzf(paramGoogleSignInOptions);
      this.zzagc = GoogleSignInOptions.zzg(paramGoogleSignInOptions);
      this.zzamE = GoogleSignInOptions.zzh(paramGoogleSignInOptions);
      this.zzamI = GoogleSignInOptions.zzC(GoogleSignInOptions.zzi(paramGoogleSignInOptions));
    }
    
    private String zzca(String paramString)
    {
      zzac.zzdc(paramString);
      if ((this.zzalL == null) || (this.zzalL.equals(paramString))) {}
      for (boolean bool = true;; bool = false)
      {
        zzac.zzb(bool, "two different server client ids provided");
        return paramString;
      }
    }
    
    public Builder addExtension(GoogleSignInOptionsExtension paramGoogleSignInOptionsExtension)
    {
      if (this.zzamI.containsKey(Integer.valueOf(1))) {
        throw new IllegalStateException("Only one extension per type may be added");
      }
      this.zzamI.put(Integer.valueOf(1), new zzg(paramGoogleSignInOptionsExtension));
      return this;
    }
    
    public GoogleSignInOptions build()
    {
      if ((this.zzalK) && ((this.zzagc == null) || (!this.zzamH.isEmpty()))) {
        requestId();
      }
      return new GoogleSignInOptions(3, new ArrayList(this.zzamH), this.zzagc, this.zzalK, this.zzamC, this.zzamD, this.zzalL, this.zzamE, this.zzamI, null);
    }
    
    public Builder requestEmail()
    {
      this.zzamH.add(GoogleSignInOptions.zzamz);
      return this;
    }
    
    public Builder requestId()
    {
      this.zzamH.add(GoogleSignInOptions.zzamA);
      return this;
    }
    
    public Builder requestIdToken(String paramString)
    {
      this.zzalK = true;
      this.zzalL = zzca(paramString);
      return this;
    }
    
    public Builder requestProfile()
    {
      this.zzamH.add(GoogleSignInOptions.zzamy);
      return this;
    }
    
    public Builder requestScopes(Scope paramScope, Scope... paramVarArgs)
    {
      this.zzamH.add(paramScope);
      this.zzamH.addAll(Arrays.asList(paramVarArgs));
      return this;
    }
    
    public Builder requestServerAuthCode(String paramString)
    {
      return requestServerAuthCode(paramString, false);
    }
    
    public Builder requestServerAuthCode(String paramString, boolean paramBoolean)
    {
      this.zzamC = true;
      this.zzalL = zzca(paramString);
      this.zzamD = paramBoolean;
      return this;
    }
    
    public Builder setAccount(Account paramAccount)
    {
      this.zzagc = ((Account)zzac.zzC(paramAccount));
      return this;
    }
    
    public Builder setAccountName(String paramString)
    {
      this.zzagc = new Account(zzac.zzdc(paramString), "com.google");
      return this;
    }
    
    public Builder setHostedDomain(String paramString)
    {
      this.zzamE = zzac.zzdc(paramString);
      return this;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/auth/api/signin/GoogleSignInOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */