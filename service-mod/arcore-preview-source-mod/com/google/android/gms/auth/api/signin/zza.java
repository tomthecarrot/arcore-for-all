package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.ArrayList;

public class zza
  implements Parcelable.Creator<GoogleSignInAccount>
{
  static void zza(GoogleSignInAccount paramGoogleSignInAccount, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzdB(paramParcel);
    zzc.zzc(paramParcel, 1, paramGoogleSignInAccount.versionCode);
    zzc.zza(paramParcel, 2, paramGoogleSignInAccount.getId(), false);
    zzc.zza(paramParcel, 3, paramGoogleSignInAccount.getIdToken(), false);
    zzc.zza(paramParcel, 4, paramGoogleSignInAccount.getEmail(), false);
    zzc.zza(paramParcel, 5, paramGoogleSignInAccount.getDisplayName(), false);
    zzc.zza(paramParcel, 6, paramGoogleSignInAccount.getPhotoUrl(), paramInt, false);
    zzc.zza(paramParcel, 7, paramGoogleSignInAccount.getServerAuthCode(), false);
    zzc.zza(paramParcel, 8, paramGoogleSignInAccount.zzqC());
    zzc.zza(paramParcel, 9, paramGoogleSignInAccount.zzqD(), false);
    zzc.zzc(paramParcel, 10, paramGoogleSignInAccount.zzala, false);
    zzc.zza(paramParcel, 11, paramGoogleSignInAccount.getGivenName(), false);
    zzc.zza(paramParcel, 12, paramGoogleSignInAccount.getFamilyName(), false);
    zzc.zzK(paramParcel, i);
  }
  
  public GoogleSignInAccount zzaJ(Parcel paramParcel)
  {
    int j = zzb.zzdA(paramParcel);
    int i = 0;
    String str8 = null;
    String str7 = null;
    String str6 = null;
    String str5 = null;
    Uri localUri = null;
    String str4 = null;
    long l = 0L;
    String str3 = null;
    ArrayList localArrayList = null;
    String str2 = null;
    String str1 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zzb.zzdz(paramParcel);
      switch (zzb.zzgg(k))
      {
      default: 
        zzb.zzb(paramParcel, k);
        break;
      case 1: 
        i = zzb.zzg(paramParcel, k);
        break;
      case 2: 
        str8 = zzb.zzq(paramParcel, k);
        break;
      case 3: 
        str7 = zzb.zzq(paramParcel, k);
        break;
      case 4: 
        str6 = zzb.zzq(paramParcel, k);
        break;
      case 5: 
        str5 = zzb.zzq(paramParcel, k);
        break;
      case 6: 
        localUri = (Uri)zzb.zza(paramParcel, k, Uri.CREATOR);
        break;
      case 7: 
        str4 = zzb.zzq(paramParcel, k);
        break;
      case 8: 
        l = zzb.zzi(paramParcel, k);
        break;
      case 9: 
        str3 = zzb.zzq(paramParcel, k);
        break;
      case 10: 
        localArrayList = zzb.zzc(paramParcel, k, Scope.CREATOR);
        break;
      case 11: 
        str2 = zzb.zzq(paramParcel, k);
        break;
      case 12: 
        str1 = zzb.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new GoogleSignInAccount(i, str8, str7, str6, str5, localUri, str4, l, str3, localArrayList, str2, str1);
  }
  
  public GoogleSignInAccount[] zzbZ(int paramInt)
  {
    return new GoogleSignInAccount[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/auth/api/signin/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */