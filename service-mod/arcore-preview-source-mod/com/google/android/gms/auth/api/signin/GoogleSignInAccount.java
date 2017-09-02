package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.zzh;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInAccount
  extends com.google.android.gms.common.internal.safeparcel.zza
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new zza();
  public static Clock zzamr = zzh.zzAM();
  private static Comparator<Scope> zzamx = new Comparator()
  {
    public int zza(Scope paramAnonymousScope1, Scope paramAnonymousScope2)
    {
      return paramAnonymousScope1.zzxg().compareTo(paramAnonymousScope2.zzxg());
    }
  };
  final int versionCode;
  private String zzGK;
  private String zzaiV;
  private String zzalA;
  private String zzalB;
  private String zzalQ;
  List<Scope> zzala;
  private String zzams;
  private Uri zzamt;
  private String zzamu;
  private long zzamv;
  private String zzamw;
  
  GoogleSignInAccount(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Uri paramUri, String paramString5, long paramLong, String paramString6, List<Scope> paramList, String paramString7, String paramString8)
  {
    this.versionCode = paramInt;
    this.zzGK = paramString1;
    this.zzalQ = paramString2;
    this.zzams = paramString3;
    this.zzaiV = paramString4;
    this.zzamt = paramUri;
    this.zzamu = paramString5;
    this.zzamv = paramLong;
    this.zzamw = paramString6;
    this.zzala = paramList;
    this.zzalA = paramString7;
    this.zzalB = paramString8;
  }
  
  public static GoogleSignInAccount zza(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4, @Nullable String paramString5, @Nullable String paramString6, @Nullable Uri paramUri, @Nullable Long paramLong, @NonNull String paramString7, @NonNull Set<Scope> paramSet)
  {
    Long localLong = paramLong;
    if (paramLong == null) {
      localLong = Long.valueOf(zzamr.currentTimeMillis() / 1000L);
    }
    return new GoogleSignInAccount(3, paramString1, paramString2, paramString3, paramString4, paramUri, null, localLong.longValue(), zzac.zzdc(paramString7), new ArrayList((Collection)zzac.zzC(paramSet)), paramString5, paramString6);
  }
  
  @Nullable
  public static GoogleSignInAccount zzbX(@Nullable String paramString)
    throws JSONException
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject(paramString);
    paramString = localJSONObject.optString("photoUrl", null);
    if (!TextUtils.isEmpty(paramString)) {}
    for (paramString = Uri.parse(paramString);; paramString = null)
    {
      long l = Long.parseLong(localJSONObject.getString("expirationTime"));
      HashSet localHashSet = new HashSet();
      JSONArray localJSONArray = localJSONObject.getJSONArray("grantedScopes");
      int j = localJSONArray.length();
      int i = 0;
      while (i < j)
      {
        localHashSet.add(new Scope(localJSONArray.getString(i)));
        i += 1;
      }
      return zza(localJSONObject.optString("id"), localJSONObject.optString("tokenId", null), localJSONObject.optString("email", null), localJSONObject.optString("displayName", null), localJSONObject.optString("givenName", null), localJSONObject.optString("familyName", null), paramString, Long.valueOf(l), localJSONObject.getString("obfuscatedIdentifier"), localHashSet).zzbY(localJSONObject.optString("serverAuthCode", null));
    }
  }
  
  private JSONObject zzqG()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (getId() != null) {
        localJSONObject.put("id", getId());
      }
      if (getIdToken() != null) {
        localJSONObject.put("tokenId", getIdToken());
      }
      if (getEmail() != null) {
        localJSONObject.put("email", getEmail());
      }
      if (getDisplayName() != null) {
        localJSONObject.put("displayName", getDisplayName());
      }
      if (getGivenName() != null) {
        localJSONObject.put("givenName", getGivenName());
      }
      if (getFamilyName() != null) {
        localJSONObject.put("familyName", getFamilyName());
      }
      if (getPhotoUrl() != null) {
        localJSONObject.put("photoUrl", getPhotoUrl().toString());
      }
      if (getServerAuthCode() != null) {
        localJSONObject.put("serverAuthCode", getServerAuthCode());
      }
      localJSONObject.put("expirationTime", this.zzamv);
      localJSONObject.put("obfuscatedIdentifier", zzqD());
      JSONArray localJSONArray = new JSONArray();
      Collections.sort(this.zzala, zzamx);
      Iterator localIterator = this.zzala.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((Scope)localIterator.next()).zzxg());
      }
      localJSONException.put("grantedScopes", localJSONArray);
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
    return localJSONException;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof GoogleSignInAccount)) {
      return false;
    }
    return ((GoogleSignInAccount)paramObject).zzqE().equals(zzqE());
  }
  
  @Nullable
  public Account getAccount()
  {
    if (this.zzams == null) {
      return null;
    }
    return new Account(this.zzams, "com.google");
  }
  
  @Nullable
  public String getDisplayName()
  {
    return this.zzaiV;
  }
  
  @Nullable
  public String getEmail()
  {
    return this.zzams;
  }
  
  @Nullable
  public String getFamilyName()
  {
    return this.zzalB;
  }
  
  @Nullable
  public String getGivenName()
  {
    return this.zzalA;
  }
  
  @NonNull
  public Set<Scope> getGrantedScopes()
  {
    return new HashSet(this.zzala);
  }
  
  @Nullable
  public String getId()
  {
    return this.zzGK;
  }
  
  @Nullable
  public String getIdToken()
  {
    return this.zzalQ;
  }
  
  @Nullable
  public Uri getPhotoUrl()
  {
    return this.zzamt;
  }
  
  @Nullable
  public String getServerAuthCode()
  {
    return this.zzamu;
  }
  
  public int hashCode()
  {
    return zzqE().hashCode();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public boolean zza()
  {
    return zzamr.currentTimeMillis() / 1000L >= this.zzamv - 300L;
  }
  
  public GoogleSignInAccount zzbY(String paramString)
  {
    this.zzamu = paramString;
    return this;
  }
  
  public long zzqC()
  {
    return this.zzamv;
  }
  
  @NonNull
  public String zzqD()
  {
    return this.zzamw;
  }
  
  public String zzqE()
  {
    return zzqG().toString();
  }
  
  public String zzqF()
  {
    JSONObject localJSONObject = zzqG();
    localJSONObject.remove("serverAuthCode");
    return localJSONObject.toString();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/auth/api/signin/GoogleSignInAccount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */