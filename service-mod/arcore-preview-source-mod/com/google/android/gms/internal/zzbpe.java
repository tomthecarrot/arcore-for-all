package com.google.android.gms.internal;

import com.google.android.gms.tagmanager.Log;
import org.json.JSONException;

public final class zzbpe
{
  public static zzbpd zzcBz = new zzbpd()
  {
    public Object zzac(byte[] paramAnonymousArrayOfByte)
      throws zzbph.zzg
    {
      if (paramAnonymousArrayOfByte == null) {
        throw new zzbph.zzg("Cannot parse a null byte[]");
      }
      if (paramAnonymousArrayOfByte.length == 0) {
        throw new zzbph.zzg("Cannot parse a 0 length byte[]");
      }
      try
      {
        paramAnonymousArrayOfByte = zzbpb.zzjQ(new String(paramAnonymousArrayOfByte));
        if (paramAnonymousArrayOfByte != null) {
          Log.v("The container was successfully parsed from the resource");
        }
        return paramAnonymousArrayOfByte;
      }
      catch (JSONException paramAnonymousArrayOfByte)
      {
        throw new zzbph.zzg("The resource data is corrupted. The container cannot be extracted from the binary data");
      }
      catch (zzbph.zzg paramAnonymousArrayOfByte)
      {
        throw new zzbph.zzg("The resource data is invalid. The container cannot be extracted from the binary data");
      }
    }
  };
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzbpe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */