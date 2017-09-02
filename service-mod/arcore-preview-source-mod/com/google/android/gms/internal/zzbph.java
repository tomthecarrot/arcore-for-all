package com.google.android.gms.internal;

import com.google.android.gms.tagmanager.Log;
import com.google.android.gms.tagmanager.zzcw;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class zzbph
{
  private static zzak.zza zza(int paramInt, zzaj.zzf paramzzf, zzak.zza[] paramArrayOfzza, Set<Integer> paramSet)
    throws zzbph.zzg
  {
    int k = 0;
    int m = 0;
    int j = 0;
    if (paramSet.contains(Integer.valueOf(paramInt)))
    {
      localObject = String.valueOf(paramSet);
      zzkw(String.valueOf(localObject).length() + 90 + "Value cycle detected.  Current value reference: " + paramInt + ".  Previous value references: " + (String)localObject + ".");
    }
    zzak.zza localzza1 = (zzak.zza)zza(paramzzf.zzkE, paramInt, "values");
    if (paramArrayOfzza[paramInt] != null) {
      return paramArrayOfzza[paramInt];
    }
    Object localObject = null;
    paramSet.add(Integer.valueOf(paramInt));
    switch (localzza1.type)
    {
    }
    for (;;)
    {
      if (localObject == null)
      {
        paramzzf = String.valueOf(localzza1);
        zzkw(String.valueOf(paramzzf).length() + 15 + "Invalid value: " + paramzzf);
      }
      paramArrayOfzza[paramInt] = localObject;
      paramSet.remove(Integer.valueOf(paramInt));
      return (zzak.zza)localObject;
      localObject = zzn(localzza1);
      zzak.zza localzza2 = zzm(localzza1);
      localzza2.zzlt = new zzak.zza[((zzaj.zzh)localObject).zzlf.length];
      int[] arrayOfInt = ((zzaj.zzh)localObject).zzlf;
      k = arrayOfInt.length;
      int i = 0;
      for (;;)
      {
        localObject = localzza2;
        if (j >= k) {
          break;
        }
        m = arrayOfInt[j];
        localzza2.zzlt[i] = zza(m, paramzzf, paramArrayOfzza, paramSet);
        j += 1;
        i += 1;
      }
      localzza2 = zzm(localzza1);
      localObject = zzn(localzza1);
      if (((zzaj.zzh)localObject).zzlg.length != ((zzaj.zzh)localObject).zzlh.length)
      {
        i = ((zzaj.zzh)localObject).zzlg.length;
        j = ((zzaj.zzh)localObject).zzlh.length;
        zzkw(58 + "Uneven map keys (" + i + ") and map values (" + j + ")");
      }
      localzza2.zzlu = new zzak.zza[((zzaj.zzh)localObject).zzlg.length];
      localzza2.zzlv = new zzak.zza[((zzaj.zzh)localObject).zzlg.length];
      arrayOfInt = ((zzaj.zzh)localObject).zzlg;
      m = arrayOfInt.length;
      j = 0;
      i = 0;
      while (j < m)
      {
        int n = arrayOfInt[j];
        localzza2.zzlu[i] = zza(n, paramzzf, paramArrayOfzza, paramSet);
        j += 1;
        i += 1;
      }
      arrayOfInt = ((zzaj.zzh)localObject).zzlh;
      m = arrayOfInt.length;
      i = 0;
      j = k;
      for (;;)
      {
        localObject = localzza2;
        if (j >= m) {
          break;
        }
        k = arrayOfInt[j];
        localzza2.zzlv[i] = zza(k, paramzzf, paramArrayOfzza, paramSet);
        j += 1;
        i += 1;
      }
      localObject = zzm(localzza1);
      ((zzak.zza)localObject).zzlw = zzcw.zze(zza(zzn(localzza1).zzlk, paramzzf, paramArrayOfzza, paramSet));
      continue;
      localzza2 = zzm(localzza1);
      localObject = zzn(localzza1);
      localzza2.zzlA = new zzak.zza[((zzaj.zzh)localObject).zzlj.length];
      arrayOfInt = ((zzaj.zzh)localObject).zzlj;
      k = arrayOfInt.length;
      i = 0;
      j = m;
      for (;;)
      {
        localObject = localzza2;
        if (j >= k) {
          break;
        }
        m = arrayOfInt[j];
        localzza2.zzlA[i] = zza(m, paramzzf, paramArrayOfzza, paramSet);
        j += 1;
        i += 1;
      }
      localObject = localzza1;
    }
  }
  
  private static zza zza(zzaj.zzb paramzzb, zzaj.zzf paramzzf, zzak.zza[] paramArrayOfzza, int paramInt)
    throws zzbph.zzg
  {
    zzb localzzb = zza.zzaas();
    paramzzb = paramzzb.zzkp;
    int i = paramzzb.length;
    paramInt = 0;
    if (paramInt < i)
    {
      int j = paramzzb[paramInt];
      Object localObject = (zzaj.zze)zza(paramzzf.zzkF, Integer.valueOf(j).intValue(), "properties");
      String str = (String)zza(paramzzf.zzkD, ((zzaj.zze)localObject).key, "keys");
      localObject = (zzak.zza)zza(paramArrayOfzza, ((zzaj.zze)localObject).value, "values");
      if (zzai.zziO.toString().equals(str)) {
        localzzb.zzo((zzak.zza)localObject);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        localzzb.zzb(str, (zzak.zza)localObject);
      }
    }
    return localzzb.zzaat();
  }
  
  private static zze zza(zzaj.zzg paramzzg, List<zza> paramList1, List<zza> paramList2, List<zza> paramList3, zzaj.zzf paramzzf)
  {
    zzf localzzf = zze.zzaax();
    int[] arrayOfInt = paramzzg.zzkT;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      localzzf.zzd((zza)paramList3.get(Integer.valueOf(arrayOfInt[i]).intValue()));
      i += 1;
    }
    arrayOfInt = paramzzg.zzkU;
    j = arrayOfInt.length;
    i = 0;
    while (i < j)
    {
      localzzf.zze((zza)paramList3.get(Integer.valueOf(arrayOfInt[i]).intValue()));
      i += 1;
    }
    paramList3 = paramzzg.zzkV;
    j = paramList3.length;
    i = 0;
    while (i < j)
    {
      localzzf.zzf((zza)paramList1.get(Integer.valueOf(paramList3[i]).intValue()));
      i += 1;
    }
    paramList3 = paramzzg.zzkX;
    j = paramList3.length;
    i = 0;
    int k;
    while (i < j)
    {
      k = paramList3[i];
      localzzf.zzkL(paramzzf.zzkE[Integer.valueOf(k).intValue()].string);
      i += 1;
    }
    paramList3 = paramzzg.zzkW;
    j = paramList3.length;
    i = 0;
    while (i < j)
    {
      localzzf.zzg((zza)paramList1.get(Integer.valueOf(paramList3[i]).intValue()));
      i += 1;
    }
    paramList1 = paramzzg.zzkY;
    j = paramList1.length;
    i = 0;
    while (i < j)
    {
      k = paramList1[i];
      localzzf.zzkM(paramzzf.zzkE[Integer.valueOf(k).intValue()].string);
      i += 1;
    }
    paramList1 = paramzzg.zzkZ;
    j = paramList1.length;
    i = 0;
    while (i < j)
    {
      localzzf.zzh((zza)paramList2.get(Integer.valueOf(paramList1[i]).intValue()));
      i += 1;
    }
    paramList1 = paramzzg.zzlb;
    j = paramList1.length;
    i = 0;
    while (i < j)
    {
      k = paramList1[i];
      localzzf.zzkN(paramzzf.zzkE[Integer.valueOf(k).intValue()].string);
      i += 1;
    }
    paramList1 = paramzzg.zzla;
    j = paramList1.length;
    i = 0;
    while (i < j)
    {
      localzzf.zzi((zza)paramList2.get(Integer.valueOf(paramList1[i]).intValue()));
      i += 1;
    }
    paramzzg = paramzzg.zzlc;
    j = paramzzg.length;
    i = 0;
    while (i < j)
    {
      k = paramzzg[i];
      localzzf.zzkO(paramzzf.zzkE[Integer.valueOf(k).intValue()].string);
      i += 1;
    }
    return localzzf.zzaaA();
  }
  
  private static <T> T zza(T[] paramArrayOfT, int paramInt, String paramString)
    throws zzbph.zzg
  {
    if ((paramInt < 0) || (paramInt >= paramArrayOfT.length)) {
      zzkw(String.valueOf(paramString).length() + 45 + "Index out of bounds detected: " + paramInt + " in " + paramString);
    }
    return paramArrayOfT[paramInt];
  }
  
  public static zzc zzb(zzaj.zzf paramzzf)
    throws zzbph.zzg
  {
    int j = 0;
    Object localObject = new zzak.zza[paramzzf.zzkE.length];
    int i = 0;
    while (i < paramzzf.zzkE.length)
    {
      zza(i, paramzzf, (zzak.zza[])localObject, new HashSet(0));
      i += 1;
    }
    zzd localzzd = zzc.zzaau();
    ArrayList localArrayList1 = new ArrayList();
    i = 0;
    while (i < paramzzf.zzkH.length)
    {
      localArrayList1.add(zza(paramzzf.zzkH[i], paramzzf, (zzak.zza[])localObject, i));
      i += 1;
    }
    ArrayList localArrayList2 = new ArrayList();
    i = 0;
    while (i < paramzzf.zzkI.length)
    {
      localArrayList2.add(zza(paramzzf.zzkI[i], paramzzf, (zzak.zza[])localObject, i));
      i += 1;
    }
    ArrayList localArrayList3 = new ArrayList();
    i = 0;
    while (i < paramzzf.zzkG.length)
    {
      zza localzza = zza(paramzzf.zzkG[i], paramzzf, (zzak.zza[])localObject, i);
      localzzd.zzc(localzza);
      localArrayList3.add(localzza);
      i += 1;
    }
    localObject = paramzzf.zzkJ;
    int k = localObject.length;
    i = j;
    while (i < k)
    {
      localzzd.zzb(zza(localObject[i], localArrayList1, localArrayList3, localArrayList2, paramzzf));
      i += 1;
    }
    localzzd.zzkK(paramzzf.version);
    localzzd.zzwA(paramzzf.zzkR);
    return localzzd.zzaaw();
  }
  
  public static void zzb(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte['Ѐ'];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        return;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  private static void zzkw(String paramString)
    throws zzbph.zzg
  {
    Log.e(paramString);
    throw new zzg(paramString);
  }
  
  public static zzak.zza zzm(zzak.zza paramzza)
  {
    zzak.zza localzza = new zzak.zza();
    localzza.type = paramzza.type;
    localzza.zzlB = ((int[])paramzza.zzlB.clone());
    if (paramzza.zzlC) {
      localzza.zzlC = paramzza.zzlC;
    }
    return localzza;
  }
  
  private static zzaj.zzh zzn(zzak.zza paramzza)
    throws zzbph.zzg
  {
    if ((zzaj.zzh)paramzza.zza(zzaj.zzh.zzld) == null)
    {
      String str = String.valueOf(paramzza);
      zzkw(String.valueOf(str).length() + 54 + "Expected a ServingValue and didn't get one. Value is: " + str);
    }
    return (zzaj.zzh)paramzza.zza(zzaj.zzh.zzld);
  }
  
  public static class zza
  {
    private final Map<String, zzak.zza> zzcAL;
    private final zzak.zza zzcwj;
    
    private zza(Map<String, zzak.zza> paramMap, zzak.zza paramzza)
    {
      this.zzcAL = paramMap;
      this.zzcwj = paramzza;
    }
    
    public static zzbph.zzb zzaas()
    {
      return new zzbph.zzb(null);
    }
    
    public String toString()
    {
      String str1 = String.valueOf(zzZN());
      String str2 = String.valueOf(this.zzcwj);
      return String.valueOf(str1).length() + 32 + String.valueOf(str2).length() + "Properties: " + str1 + " pushAfterEvaluate: " + str2;
    }
    
    public zzak.zza zzYl()
    {
      return this.zzcwj;
    }
    
    public Map<String, zzak.zza> zzZN()
    {
      return Collections.unmodifiableMap(this.zzcAL);
    }
    
    public void zza(String paramString, zzak.zza paramzza)
    {
      this.zzcAL.put(paramString, paramzza);
    }
  }
  
  public static class zzb
  {
    private final Map<String, zzak.zza> zzcAL = new HashMap();
    private zzak.zza zzcwj;
    
    public zzbph.zza zzaat()
    {
      return new zzbph.zza(this.zzcAL, this.zzcwj, null);
    }
    
    public zzb zzb(String paramString, zzak.zza paramzza)
    {
      this.zzcAL.put(paramString, paramzza);
      return this;
    }
    
    public zzb zzo(zzak.zza paramzza)
    {
      this.zzcwj = paramzza;
      return this;
    }
  }
  
  public static class zzc
  {
    private final String zzafX;
    private final List<zzbph.zze> zzcAI;
    private final Map<String, List<zzbph.zza>> zzcAJ;
    private final int zzcAK;
    
    private zzc(List<zzbph.zze> paramList, Map<String, List<zzbph.zza>> paramMap, String paramString, int paramInt)
    {
      this.zzcAI = Collections.unmodifiableList(paramList);
      this.zzcAJ = Collections.unmodifiableMap(paramMap);
      this.zzafX = paramString;
      this.zzcAK = paramInt;
    }
    
    public static zzbph.zzd zzaau()
    {
      return new zzbph.zzd(null);
    }
    
    public String getVersion()
    {
      return this.zzafX;
    }
    
    public String toString()
    {
      String str1 = String.valueOf(zzZL());
      String str2 = String.valueOf(this.zzcAJ);
      return String.valueOf(str1).length() + 17 + String.valueOf(str2).length() + "Rules: " + str1 + "  Macros: " + str2;
    }
    
    public List<zzbph.zze> zzZL()
    {
      return this.zzcAI;
    }
    
    public Map<String, List<zzbph.zza>> zzaav()
    {
      return this.zzcAJ;
    }
  }
  
  public static class zzd
  {
    private String zzafX = "";
    private final List<zzbph.zze> zzcAI = new ArrayList();
    private final Map<String, List<zzbph.zza>> zzcAJ = new HashMap();
    private int zzcAK = 0;
    
    public zzbph.zzc zzaaw()
    {
      return new zzbph.zzc(this.zzcAI, this.zzcAJ, this.zzafX, this.zzcAK, null);
    }
    
    public zzd zzb(zzbph.zze paramzze)
    {
      this.zzcAI.add(paramzze);
      return this;
    }
    
    public zzd zzc(zzbph.zza paramzza)
    {
      String str = zzcw.zze((zzak.zza)paramzza.zzZN().get(zzai.zzhH.toString()));
      List localList = (List)this.zzcAJ.get(str);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.zzcAJ.put(str, localObject);
      }
      ((List)localObject).add(paramzza);
      return this;
    }
    
    public zzd zzkK(String paramString)
    {
      this.zzafX = paramString;
      return this;
    }
    
    public zzd zzwA(int paramInt)
    {
      this.zzcAK = paramInt;
      return this;
    }
  }
  
  public static class zze
  {
    private final List<zzbph.zza> zzcAN;
    private final List<zzbph.zza> zzcAO;
    private final List<zzbph.zza> zzcAP;
    private final List<zzbph.zza> zzcAQ;
    private final List<zzbph.zza> zzcBJ;
    private final List<zzbph.zza> zzcBK;
    private final List<String> zzcBL;
    private final List<String> zzcBM;
    private final List<String> zzcBN;
    private final List<String> zzcBO;
    
    private zze(List<zzbph.zza> paramList1, List<zzbph.zza> paramList2, List<zzbph.zza> paramList3, List<zzbph.zza> paramList4, List<zzbph.zza> paramList5, List<zzbph.zza> paramList6, List<String> paramList7, List<String> paramList8, List<String> paramList9, List<String> paramList10)
    {
      this.zzcAN = Collections.unmodifiableList(paramList1);
      this.zzcAO = Collections.unmodifiableList(paramList2);
      this.zzcAP = Collections.unmodifiableList(paramList3);
      this.zzcAQ = Collections.unmodifiableList(paramList4);
      this.zzcBJ = Collections.unmodifiableList(paramList5);
      this.zzcBK = Collections.unmodifiableList(paramList6);
      this.zzcBL = Collections.unmodifiableList(paramList7);
      this.zzcBM = Collections.unmodifiableList(paramList8);
      this.zzcBN = Collections.unmodifiableList(paramList9);
      this.zzcBO = Collections.unmodifiableList(paramList10);
    }
    
    public static zzbph.zzf zzaax()
    {
      return new zzbph.zzf(null);
    }
    
    public String toString()
    {
      String str1 = String.valueOf(zzZP());
      String str2 = String.valueOf(zzZQ());
      String str3 = String.valueOf(zzZR());
      String str4 = String.valueOf(zzZS());
      String str5 = String.valueOf(zzaay());
      String str6 = String.valueOf(zzaaz());
      return String.valueOf(str1).length() + 102 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + String.valueOf(str6).length() + "Positive predicates: " + str1 + "  Negative predicates: " + str2 + "  Add tags: " + str3 + "  Remove tags: " + str4 + "  Add macros: " + str5 + "  Remove macros: " + str6;
    }
    
    public List<zzbph.zza> zzZP()
    {
      return this.zzcAN;
    }
    
    public List<zzbph.zza> zzZQ()
    {
      return this.zzcAO;
    }
    
    public List<zzbph.zza> zzZR()
    {
      return this.zzcAP;
    }
    
    public List<zzbph.zza> zzZS()
    {
      return this.zzcAQ;
    }
    
    public List<zzbph.zza> zzaay()
    {
      return this.zzcBJ;
    }
    
    public List<zzbph.zza> zzaaz()
    {
      return this.zzcBK;
    }
  }
  
  public static class zzf
  {
    private final List<zzbph.zza> zzcAN = new ArrayList();
    private final List<zzbph.zza> zzcAO = new ArrayList();
    private final List<zzbph.zza> zzcAP = new ArrayList();
    private final List<zzbph.zza> zzcAQ = new ArrayList();
    private final List<zzbph.zza> zzcBJ = new ArrayList();
    private final List<zzbph.zza> zzcBK = new ArrayList();
    private final List<String> zzcBL = new ArrayList();
    private final List<String> zzcBM = new ArrayList();
    private final List<String> zzcBN = new ArrayList();
    private final List<String> zzcBO = new ArrayList();
    
    public zzbph.zze zzaaA()
    {
      return new zzbph.zze(this.zzcAN, this.zzcAO, this.zzcAP, this.zzcAQ, this.zzcBJ, this.zzcBK, this.zzcBL, this.zzcBM, this.zzcBN, this.zzcBO, null);
    }
    
    public zzf zzd(zzbph.zza paramzza)
    {
      this.zzcAN.add(paramzza);
      return this;
    }
    
    public zzf zze(zzbph.zza paramzza)
    {
      this.zzcAO.add(paramzza);
      return this;
    }
    
    public zzf zzf(zzbph.zza paramzza)
    {
      this.zzcAP.add(paramzza);
      return this;
    }
    
    public zzf zzg(zzbph.zza paramzza)
    {
      this.zzcAQ.add(paramzza);
      return this;
    }
    
    public zzf zzh(zzbph.zza paramzza)
    {
      this.zzcBJ.add(paramzza);
      return this;
    }
    
    public zzf zzi(zzbph.zza paramzza)
    {
      this.zzcBK.add(paramzza);
      return this;
    }
    
    public zzf zzkL(String paramString)
    {
      this.zzcBN.add(paramString);
      return this;
    }
    
    public zzf zzkM(String paramString)
    {
      this.zzcBO.add(paramString);
      return this;
    }
    
    public zzf zzkN(String paramString)
    {
      this.zzcBL.add(paramString);
      return this;
    }
    
    public zzf zzkO(String paramString)
    {
      this.zzcBM.add(paramString);
      return this;
    }
  }
  
  public static class zzg
    extends Exception
  {
    public zzg(String paramString)
    {
      super();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzbph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */