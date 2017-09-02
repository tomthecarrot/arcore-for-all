package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.internal.zzg;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.ArrayList;

public class zzb
  implements Parcelable.Creator<GoogleSignInOptions>
{
  static void zza(GoogleSignInOptions paramGoogleSignInOptions, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzdB(paramParcel);
    zzc.zzc(paramParcel, 1, paramGoogleSignInOptions.versionCode);
    zzc.zzc(paramParcel, 2, paramGoogleSignInOptions.zzqH(), false);
    zzc.zza(paramParcel, 3, paramGoogleSignInOptions.getAccount(), paramInt, false);
    zzc.zza(paramParcel, 4, paramGoogleSignInOptions.isIdTokenRequested());
    zzc.zza(paramParcel, 5, paramGoogleSignInOptions.zzqI());
    zzc.zza(paramParcel, 6, paramGoogleSignInOptions.zzqJ());
    zzc.zza(paramParcel, 7, paramGoogleSignInOptions.getServerClientId(), false);
    zzc.zza(paramParcel, 8, paramGoogleSignInOptions.zzqK(), false);
    zzc.zzc(paramParcel, 9, paramGoogleSignInOptions.zzqL(), false);
    zzc.zzK(paramParcel, i);
  }
  
  public GoogleSignInOptions zzaK(Parcel paramParcel)
  {
    boolean bool1 = false;
    ArrayList localArrayList1 = null;
    int j = com.google.android.gms.common.internal.safeparcel.zzb.zzdA(paramParcel);
    String str1 = null;
    String str2 = null;
    boolean bool2 = false;
    boolean bool3 = false;
    Account localAccount = null;
    ArrayList localArrayList2 = null;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zzb.zzdz(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zzb.zzgg(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(paramParcel, k);
        break;
      case 1: 
        i = com.google.android.gms.common.internal.safeparcel.zzb.zzg(paramParcel, k);
        break;
      case 2: 
        localArrayList2 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, k, Scope.CREATOR);
        break;
      case 3: 
        localAccount = (Account)com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, k, Account.CREATOR);
        break;
      case 4: 
        bool3 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, k);
        break;
      case 5: 
        bool2 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, k);
        break;
      case 6: 
        bool1 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, k);
        break;
      case 7: 
        str2 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(paramParcel, k);
        break;
      case 8: 
        str1 = com.google.android.gms.common.internal.safeparcel.zzb.zzq(paramParcel, k);
        break;
      case 9: 
        localArrayList1 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, k, zzg.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new GoogleSignInOptions(i, localArrayList2, localAccount, bool3, bool2, bool1, str2, str1, localArrayList1);
  }
  
  public GoogleSignInOptions[] zzca(int paramInt)
  {
    return new GoogleSignInOptions[paramInt];
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/auth/api/signin/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */