package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzaj.zzi;
import com.google.android.gms.internal.zzak.zza;
import com.google.android.gms.internal.zzbph;
import com.google.android.gms.internal.zzbph.zza;
import com.google.android.gms.internal.zzbph.zzc;
import com.google.android.gms.internal.zzbph.zze;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zzcl
{
  private static final zzbt<zzak.zza> zzcvS = new zzbt(zzcw.zzYL(), true);
  private final DataLayer zzctf;
  private final zzbph.zzc zzcvT;
  private final zzae zzcvU;
  private final Map<String, FunctionCallImplementation> zzcvV;
  private final Map<String, FunctionCallImplementation> zzcvW;
  private final Map<String, FunctionCallImplementation> zzcvX;
  private final zzl<zzbph.zza, zzbt<zzak.zza>> zzcvY;
  private final zzl<String, zzb> zzcvZ;
  private final Set<zzbph.zze> zzcwa;
  private final Map<String, zzc> zzcwb;
  private volatile String zzcwc;
  private int zzcwd;
  
  public zzcl(Context paramContext, zzbph.zzc paramzzc, DataLayer paramDataLayer, zzr.zza paramzza1, zzr.zza paramzza2, zzae paramzzae)
  {
    if (paramzzc == null) {
      throw new NullPointerException("resource cannot be null");
    }
    this.zzcvT = paramzzc;
    this.zzcwa = new HashSet(paramzzc.zzZL());
    this.zzctf = paramDataLayer;
    this.zzcvU = paramzzae;
    paramzzc = new zzm.zza()
    {
      public int zza(zzbph.zza paramAnonymouszza, zzbt<zzak.zza> paramAnonymouszzbt)
      {
        return ((zzak.zza)paramAnonymouszzbt.getObject()).zzanm();
      }
    };
    this.zzcvY = new zzm().zza(1048576, paramzzc);
    paramzzc = new zzm.zza()
    {
      public int zza(String paramAnonymousString, zzcl.zzb paramAnonymouszzb)
      {
        return paramAnonymousString.length() + paramAnonymouszzb.getSize();
      }
    };
    this.zzcvZ = new zzm().zza(1048576, paramzzc);
    this.zzcvV = new HashMap();
    zzb(new zzj(paramContext));
    zzb(new zzr(paramzza2));
    zzb(new zzv(paramDataLayer));
    zzb(new UniversalAnalyticsTag(paramContext, paramDataLayer));
    this.zzcvW = new HashMap();
    zzc(new zzq());
    zzc(new zzac());
    zzc(new EqualsPredicate());
    zzc(new zzai());
    zzc(new zzaj());
    zzc(new zzbb());
    zzc(new zzbc());
    zzc(new zzcb());
    zzc(new zzct());
    this.zzcvX = new HashMap();
    zza(new zzb(paramContext));
    zza(new zzc(paramContext));
    zza(new zze(paramContext));
    zza(new zzf(paramContext));
    zza(new zzg(paramContext));
    zza(new zzh(paramContext));
    zza(new zzi(paramContext));
    zza(new zzn());
    zza(new zzp(this.zzcvT.getVersion()));
    zza(new zzr(paramzza1));
    zza(new zzt(paramDataLayer));
    zza(new zzx(paramContext));
    zza(new zzy());
    zza(new zzab());
    zza(new zzaf(this));
    zza(new zzak());
    zza(new zzal());
    zza(new zzax(paramContext));
    zza(new zzay());
    zza(new LanguageMacro());
    zza(new zzbf());
    zza(new zzbh(paramContext));
    zza(new zzbu());
    zza(new zzbw());
    zza(new zzby());
    zza(new zzca());
    zza(new zzcc(paramContext));
    zza(new zzcm());
    zza(new zzcn());
    zza(new zzcu());
    zza(new zzcx());
    this.zzcwb = new HashMap();
    paramContext = this.zzcwa.iterator();
    while (paramContext.hasNext())
    {
      paramzzc = (zzbph.zze)paramContext.next();
      int i = 0;
      while (i < paramzzc.zzaay().size())
      {
        paramDataLayer = (zzbph.zza)paramzzc.zzaay().get(i);
        paramzza1 = zzh(this.zzcwb, zza(paramDataLayer));
        paramzza1.zza(paramzzc);
        paramzza1.zza(paramzzc, paramDataLayer);
        paramzza1.zza(paramzzc, "Unknown");
        i += 1;
      }
      i = 0;
      while (i < paramzzc.zzaaz().size())
      {
        paramDataLayer = (zzbph.zza)paramzzc.zzaaz().get(i);
        paramzza1 = zzh(this.zzcwb, zza(paramDataLayer));
        paramzza1.zza(paramzzc);
        paramzza1.zzb(paramzzc, paramDataLayer);
        paramzza1.zzb(paramzzc, "Unknown");
        i += 1;
      }
    }
    paramContext = this.zzcvT.zzaav().entrySet().iterator();
    while (paramContext.hasNext())
    {
      paramzzc = (Map.Entry)paramContext.next();
      paramDataLayer = ((List)paramzzc.getValue()).iterator();
      while (paramDataLayer.hasNext())
      {
        paramzza1 = (zzbph.zza)paramDataLayer.next();
        if (!zzcw.zzi((zzak.zza)paramzza1.zzZN().get(com.google.android.gms.internal.zzai.zzim.toString())).booleanValue()) {
          zzh(this.zzcwb, (String)paramzzc.getKey()).zzb(paramzza1);
        }
      }
    }
  }
  
  private String zzYj()
  {
    if (this.zzcwd <= 1) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Integer.toString(this.zzcwd));
    int i = 2;
    while (i < this.zzcwd)
    {
      localStringBuilder.append(' ');
      i += 1;
    }
    localStringBuilder.append(": ");
    return localStringBuilder.toString();
  }
  
  private zzbt<zzak.zza> zza(zzak.zza paramzza, Set<String> paramSet, zzcy paramzzcy)
  {
    if (!paramzza.zzlC) {
      return new zzbt(paramzza, true);
    }
    zzbt localzzbt1;
    switch (paramzza.type)
    {
    case 5: 
    case 6: 
    default: 
      i = paramzza.type;
      Log.e(25 + "Unknown type: " + i);
      return zzcvS;
    case 2: 
      localzza = zzbph.zzm(paramzza);
      localzza.zzlt = new zzak.zza[paramzza.zzlt.length];
      i = 0;
      while (i < paramzza.zzlt.length)
      {
        localzzbt1 = zza(paramzza.zzlt[i], paramSet, paramzzcy.zzwo(i));
        if (localzzbt1 == zzcvS) {
          return zzcvS;
        }
        localzza.zzlt[i] = ((zzak.zza)localzzbt1.getObject());
        i += 1;
      }
      return new zzbt(localzza, false);
    case 3: 
      localzza = zzbph.zzm(paramzza);
      if (paramzza.zzlu.length != paramzza.zzlv.length)
      {
        paramzza = String.valueOf(paramzza.toString());
        if (paramzza.length() != 0) {}
        for (paramzza = "Invalid serving value: ".concat(paramzza);; paramzza = new String("Invalid serving value: "))
        {
          Log.e(paramzza);
          return zzcvS;
        }
      }
      localzza.zzlu = new zzak.zza[paramzza.zzlu.length];
      localzza.zzlv = new zzak.zza[paramzza.zzlu.length];
      i = 0;
      while (i < paramzza.zzlu.length)
      {
        localzzbt1 = zza(paramzza.zzlu[i], paramSet, paramzzcy.zzwp(i));
        zzbt localzzbt2 = zza(paramzza.zzlv[i], paramSet, paramzzcy.zzwq(i));
        if ((localzzbt1 == zzcvS) || (localzzbt2 == zzcvS)) {
          return zzcvS;
        }
        localzza.zzlu[i] = ((zzak.zza)localzzbt1.getObject());
        localzza.zzlv[i] = ((zzak.zza)localzzbt2.getObject());
        i += 1;
      }
      return new zzbt(localzza, false);
    case 4: 
      if (paramSet.contains(paramzza.zzlw))
      {
        paramzza = String.valueOf(paramzza.zzlw);
        paramSet = String.valueOf(paramSet.toString());
        Log.e(String.valueOf(paramzza).length() + 79 + String.valueOf(paramSet).length() + "Macro cycle detected.  Current macro reference: " + paramzza + ".  Previous macro references: " + paramSet + ".");
        return zzcvS;
      }
      paramSet.add(paramzza.zzlw);
      paramzzcy = zzcz.zza(zza(paramzza.zzlw, paramSet, paramzzcy.zzXS()), paramzza.zzlB);
      paramSet.remove(paramzza.zzlw);
      return paramzzcy;
    }
    zzak.zza localzza = zzbph.zzm(paramzza);
    localzza.zzlA = new zzak.zza[paramzza.zzlA.length];
    int i = 0;
    while (i < paramzza.zzlA.length)
    {
      localzzbt1 = zza(paramzza.zzlA[i], paramSet, paramzzcy.zzwr(i));
      if (localzzbt1 == zzcvS) {
        return zzcvS;
      }
      localzza.zzlA[i] = ((zzak.zza)localzzbt1.getObject());
      i += 1;
    }
    return new zzbt(localzza, false);
  }
  
  private zzbt<zzak.zza> zza(String paramString, Set<String> paramSet, zzbg paramzzbg)
  {
    this.zzcwd += 1;
    Object localObject = (zzb)this.zzcvZ.get(paramString);
    if (localObject != null)
    {
      zza(((zzb)localObject).zzYl(), paramSet);
      this.zzcwd -= 1;
      return ((zzb)localObject).zzYk();
    }
    localObject = (zzc)this.zzcwb.get(paramString);
    if (localObject == null)
    {
      paramSet = String.valueOf(zzYj());
      Log.e(String.valueOf(paramSet).length() + 15 + String.valueOf(paramString).length() + paramSet + "Invalid macro: " + paramString);
      this.zzcwd -= 1;
      return zzcvS;
    }
    zzbt localzzbt = zza(paramString, ((zzc)localObject).zzYm(), ((zzc)localObject).zzYn(), ((zzc)localObject).zzYo(), ((zzc)localObject).zzYq(), ((zzc)localObject).zzYp(), paramSet, paramzzbg.zzXu());
    if (((Set)localzzbt.getObject()).isEmpty()) {}
    for (localObject = ((zzc)localObject).zzYr(); localObject == null; localObject = (zzbph.zza)((Set)localzzbt.getObject()).iterator().next())
    {
      this.zzcwd -= 1;
      return zzcvS;
      if (((Set)localzzbt.getObject()).size() > 1)
      {
        localObject = String.valueOf(zzYj());
        Log.w(String.valueOf(localObject).length() + 37 + String.valueOf(paramString).length() + (String)localObject + "Multiple macros active for macroName " + paramString);
      }
    }
    paramzzbg = zza(this.zzcvX, (zzbph.zza)localObject, paramSet, paramzzbg.zzXK());
    boolean bool;
    if ((localzzbt.zzXT()) && (paramzzbg.zzXT()))
    {
      bool = true;
      if (paramzzbg != zzcvS) {
        break label429;
      }
    }
    label429:
    for (paramzzbg = zzcvS;; paramzzbg = new zzbt((zzak.zza)paramzzbg.getObject(), bool))
    {
      localObject = ((zzbph.zza)localObject).zzYl();
      if (paramzzbg.zzXT()) {
        this.zzcvZ.zzh(paramString, new zzb(paramzzbg, (zzak.zza)localObject));
      }
      zza((zzak.zza)localObject, paramSet);
      this.zzcwd -= 1;
      return paramzzbg;
      bool = false;
      break;
    }
  }
  
  private zzbt<zzak.zza> zza(Map<String, FunctionCallImplementation> paramMap, zzbph.zza paramzza, Set<String> paramSet, zzcd paramzzcd)
  {
    boolean bool = true;
    Object localObject1 = (zzak.zza)paramzza.zzZN().get(com.google.android.gms.internal.zzai.zzhv.toString());
    if (localObject1 == null)
    {
      Log.e("No function id in properties");
      paramMap = zzcvS;
    }
    String str;
    FunctionCallImplementation localFunctionCallImplementation;
    do
    {
      return paramMap;
      str = ((zzak.zza)localObject1).zzlx;
      localFunctionCallImplementation = (FunctionCallImplementation)paramMap.get(str);
      if (localFunctionCallImplementation == null)
      {
        Log.e(String.valueOf(str).concat(" has no backing implementation."));
        return zzcvS;
      }
      localObject1 = (zzbt)this.zzcvY.get(paramzza);
      paramMap = (Map<String, FunctionCallImplementation>)localObject1;
    } while (localObject1 != null);
    paramMap = new HashMap();
    localObject1 = paramzza.zzZN().entrySet().iterator();
    int i = 1;
    if (((Iterator)localObject1).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
      Object localObject2 = paramzzcd.zzjR((String)localEntry.getKey());
      localObject2 = zza((zzak.zza)localEntry.getValue(), paramSet, ((zzcf)localObject2).zzd((zzak.zza)localEntry.getValue()));
      if (localObject2 == zzcvS) {
        return zzcvS;
      }
      if (((zzbt)localObject2).zzXT()) {
        paramzza.zza((String)localEntry.getKey(), (zzak.zza)((zzbt)localObject2).getObject());
      }
      for (;;)
      {
        paramMap.put((String)localEntry.getKey(), (zzak.zza)((zzbt)localObject2).getObject());
        break;
        i = 0;
      }
    }
    if (!localFunctionCallImplementation.zzf(paramMap.keySet()))
    {
      paramzza = String.valueOf(localFunctionCallImplementation.getRequiredKeys());
      paramMap = String.valueOf(paramMap.keySet());
      Log.e(String.valueOf(str).length() + 43 + String.valueOf(paramzza).length() + String.valueOf(paramMap).length() + "Incorrect keys for function " + str + " required " + paramzza + " had " + paramMap);
      return zzcvS;
    }
    if ((i != 0) && (localFunctionCallImplementation.isCacheable())) {}
    for (;;)
    {
      paramSet = new zzbt(localFunctionCallImplementation.evaluate(paramMap), bool);
      paramMap = paramSet;
      if (!bool) {
        break;
      }
      this.zzcvY.zzh(paramzza, paramSet);
      return paramSet;
      bool = false;
    }
  }
  
  private zzbt<Set<zzbph.zza>> zza(Set<zzbph.zze> paramSet, Set<String> paramSet1, zza paramzza, zzck paramzzck)
  {
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    paramSet = paramSet.iterator();
    boolean bool = true;
    if (paramSet.hasNext())
    {
      zzbph.zze localzze = (zzbph.zze)paramSet.next();
      zzcg localzzcg = paramzzck.zzXR();
      zzbt localzzbt = zza(localzze, paramSet1, localzzcg);
      if (((Boolean)localzzbt.getObject()).booleanValue()) {
        paramzza.zza(localzze, localHashSet1, localHashSet2, localzzcg);
      }
      if ((bool) && (localzzbt.zzXT())) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    localHashSet1.removeAll(localHashSet2);
    return new zzbt(localHashSet1, bool);
  }
  
  private static String zza(zzbph.zza paramzza)
  {
    return zzcw.zze((zzak.zza)paramzza.zzZN().get(com.google.android.gms.internal.zzai.zzhH.toString()));
  }
  
  private void zza(zzak.zza paramzza, Set<String> paramSet)
  {
    if (paramzza == null) {}
    for (;;)
    {
      return;
      paramzza = zza(paramzza, paramSet, new zzbr());
      if (paramzza != zzcvS)
      {
        paramzza = zzcw.zzj((zzak.zza)paramzza.getObject());
        if ((paramzza instanceof Map))
        {
          paramzza = (Map)paramzza;
          this.zzctf.push(paramzza);
          return;
        }
        if (!(paramzza instanceof List)) {
          break;
        }
        paramzza = ((List)paramzza).iterator();
        while (paramzza.hasNext())
        {
          paramSet = paramzza.next();
          if ((paramSet instanceof Map))
          {
            paramSet = (Map)paramSet;
            this.zzctf.push(paramSet);
          }
          else
          {
            Log.w("pushAfterEvaluate: value not a Map");
          }
        }
      }
    }
    Log.w("pushAfterEvaluate: value not a Map or List");
  }
  
  private static void zza(Map<String, FunctionCallImplementation> paramMap, FunctionCallImplementation paramFunctionCallImplementation)
  {
    if (paramMap.containsKey(paramFunctionCallImplementation.getInstanceFunctionId()))
    {
      paramMap = String.valueOf(paramFunctionCallImplementation.getInstanceFunctionId());
      if (paramMap.length() != 0) {}
      for (paramMap = "Duplicate function type name: ".concat(paramMap);; paramMap = new String("Duplicate function type name: ")) {
        throw new IllegalArgumentException(paramMap);
      }
    }
    paramMap.put(paramFunctionCallImplementation.getInstanceFunctionId(), paramFunctionCallImplementation);
  }
  
  private static zzc zzh(Map<String, zzc> paramMap, String paramString)
  {
    zzc localzzc2 = (zzc)paramMap.get(paramString);
    zzc localzzc1 = localzzc2;
    if (localzzc2 == null)
    {
      localzzc1 = new zzc();
      paramMap.put(paramString, localzzc1);
    }
    return localzzc1;
  }
  
  String zzYi()
  {
    try
    {
      String str = this.zzcwc;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  zzbt<Boolean> zza(zzbph.zza paramzza, Set<String> paramSet, zzcd paramzzcd)
  {
    paramzza = zza(this.zzcvW, paramzza, paramSet, paramzzcd);
    paramSet = zzcw.zzi((zzak.zza)paramzza.getObject());
    zzcw.zzab(paramSet);
    return new zzbt(paramSet, paramzza.zzXT());
  }
  
  zzbt<Boolean> zza(zzbph.zze paramzze, Set<String> paramSet, zzcg paramzzcg)
  {
    Object localObject = paramzze.zzZQ().iterator();
    boolean bool = true;
    if (((Iterator)localObject).hasNext())
    {
      zzbt localzzbt = zza((zzbph.zza)((Iterator)localObject).next(), paramSet, paramzzcg.zzXL());
      if (((Boolean)localzzbt.getObject()).booleanValue())
      {
        zzcw.zzab(Boolean.valueOf(false));
        return new zzbt(Boolean.valueOf(false), localzzbt.zzXT());
      }
      if ((bool) && (localzzbt.zzXT())) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    paramzze = paramzze.zzZP().iterator();
    while (paramzze.hasNext())
    {
      localObject = zza((zzbph.zza)paramzze.next(), paramSet, paramzzcg.zzXM());
      if (!((Boolean)((zzbt)localObject).getObject()).booleanValue())
      {
        zzcw.zzab(Boolean.valueOf(false));
        return new zzbt(Boolean.valueOf(false), ((zzbt)localObject).zzXT());
      }
      if ((bool) && (((zzbt)localObject).zzXT())) {
        bool = true;
      } else {
        bool = false;
      }
    }
    zzcw.zzab(Boolean.valueOf(true));
    return new zzbt(Boolean.valueOf(true), bool);
  }
  
  zzbt<Set<zzbph.zza>> zza(String paramString, Set<zzbph.zze> paramSet, final Map<zzbph.zze, List<zzbph.zza>> paramMap1, final Map<zzbph.zze, List<String>> paramMap2, final Map<zzbph.zze, List<zzbph.zza>> paramMap3, final Map<zzbph.zze, List<String>> paramMap4, Set<String> paramSet1, zzck paramzzck)
  {
    zza(paramSet, paramSet1, new zza()
    {
      public void zza(zzbph.zze paramAnonymouszze, Set<zzbph.zza> paramAnonymousSet1, Set<zzbph.zza> paramAnonymousSet2, zzcg paramAnonymouszzcg)
      {
        List localList = (List)paramMap1.get(paramAnonymouszze);
        paramMap2.get(paramAnonymouszze);
        if (localList != null)
        {
          paramAnonymousSet1.addAll(localList);
          paramAnonymouszzcg.zzXN();
        }
        paramAnonymousSet1 = (List)paramMap3.get(paramAnonymouszze);
        paramMap4.get(paramAnonymouszze);
        if (paramAnonymousSet1 != null)
        {
          paramAnonymousSet2.addAll(paramAnonymousSet1);
          paramAnonymouszzcg.zzXO();
        }
      }
    }, paramzzck);
  }
  
  zzbt<Set<zzbph.zza>> zza(Set<zzbph.zze> paramSet, zzck paramzzck)
  {
    zza(paramSet, new HashSet(), new zza()
    {
      public void zza(zzbph.zze paramAnonymouszze, Set<zzbph.zza> paramAnonymousSet1, Set<zzbph.zza> paramAnonymousSet2, zzcg paramAnonymouszzcg)
      {
        paramAnonymousSet1.addAll(paramAnonymouszze.zzZR());
        paramAnonymousSet2.addAll(paramAnonymouszze.zzZS());
        paramAnonymouszzcg.zzXP();
        paramAnonymouszzcg.zzXQ();
      }
    }, paramzzck);
  }
  
  void zza(FunctionCallImplementation paramFunctionCallImplementation)
  {
    zza(this.zzcvX, paramFunctionCallImplementation);
  }
  
  public void zzai(List<zzaj.zzi> paramList)
  {
    for (;;)
    {
      try
      {
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break;
        }
        Object localObject = (zzaj.zzi)paramList.next();
        if ((((zzaj.zzi)localObject).name == null) || (!((zzaj.zzi)localObject).name.startsWith("gaExperiment:")))
        {
          localObject = String.valueOf(localObject);
          Log.v(String.valueOf(localObject).length() + 22 + "Ignored supplemental: " + (String)localObject);
        }
        else
        {
          zzag.zza(this.zzctf, (zzaj.zzi)localObject);
        }
      }
      finally {}
    }
  }
  
  void zzb(FunctionCallImplementation paramFunctionCallImplementation)
  {
    zza(this.zzcvV, paramFunctionCallImplementation);
  }
  
  void zzc(FunctionCallImplementation paramFunctionCallImplementation)
  {
    zza(this.zzcvW, paramFunctionCallImplementation);
  }
  
  public void zzjB(String paramString)
  {
    try
    {
      zzjW(paramString);
      paramString = this.zzcvU.zzjN(paramString).zzXF();
      Iterator localIterator = ((Set)zza(this.zzcwa, paramString.zzXu()).getObject()).iterator();
      while (localIterator.hasNext())
      {
        zzbph.zza localzza = (zzbph.zza)localIterator.next();
        zza(this.zzcvV, localzza, new HashSet(), paramString.zzXt());
      }
      zzjW(null);
    }
    finally {}
  }
  
  public zzbt<zzak.zza> zzjV(String paramString)
  {
    this.zzcwd = 0;
    zzad localzzad = this.zzcvU.zzjM(paramString);
    return zza(paramString, new HashSet(), localzzad.zzXE());
  }
  
  void zzjW(String paramString)
  {
    try
    {
      this.zzcwc = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  static abstract interface zza
  {
    public abstract void zza(zzbph.zze paramzze, Set<zzbph.zza> paramSet1, Set<zzbph.zza> paramSet2, zzcg paramzzcg);
  }
  
  private static class zzb
  {
    private zzbt<zzak.zza> zzcwi;
    private zzak.zza zzcwj;
    
    public zzb(zzbt<zzak.zza> paramzzbt, zzak.zza paramzza)
    {
      this.zzcwi = paramzzbt;
      this.zzcwj = paramzza;
    }
    
    public int getSize()
    {
      int j = ((zzak.zza)this.zzcwi.getObject()).zzanm();
      if (this.zzcwj == null) {}
      for (int i = 0;; i = this.zzcwj.zzanm()) {
        return i + j;
      }
    }
    
    public zzbt<zzak.zza> zzYk()
    {
      return this.zzcwi;
    }
    
    public zzak.zza zzYl()
    {
      return this.zzcwj;
    }
  }
  
  private static class zzc
  {
    private final Set<zzbph.zze> zzcwa = new HashSet();
    private final Map<zzbph.zze, List<zzbph.zza>> zzcwk = new HashMap();
    private final Map<zzbph.zze, List<zzbph.zza>> zzcwl = new HashMap();
    private final Map<zzbph.zze, List<String>> zzcwm = new HashMap();
    private final Map<zzbph.zze, List<String>> zzcwn = new HashMap();
    private zzbph.zza zzcwo;
    
    public Set<zzbph.zze> zzYm()
    {
      return this.zzcwa;
    }
    
    public Map<zzbph.zze, List<zzbph.zza>> zzYn()
    {
      return this.zzcwk;
    }
    
    public Map<zzbph.zze, List<String>> zzYo()
    {
      return this.zzcwm;
    }
    
    public Map<zzbph.zze, List<String>> zzYp()
    {
      return this.zzcwn;
    }
    
    public Map<zzbph.zze, List<zzbph.zza>> zzYq()
    {
      return this.zzcwl;
    }
    
    public zzbph.zza zzYr()
    {
      return this.zzcwo;
    }
    
    public void zza(zzbph.zze paramzze)
    {
      this.zzcwa.add(paramzze);
    }
    
    public void zza(zzbph.zze paramzze, zzbph.zza paramzza)
    {
      List localList = (List)this.zzcwk.get(paramzze);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.zzcwk.put(paramzze, localObject);
      }
      ((List)localObject).add(paramzza);
    }
    
    public void zza(zzbph.zze paramzze, String paramString)
    {
      List localList = (List)this.zzcwm.get(paramzze);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.zzcwm.put(paramzze, localObject);
      }
      ((List)localObject).add(paramString);
    }
    
    public void zzb(zzbph.zza paramzza)
    {
      this.zzcwo = paramzza;
    }
    
    public void zzb(zzbph.zze paramzze, zzbph.zza paramzza)
    {
      List localList = (List)this.zzcwl.get(paramzze);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.zzcwl.put(paramzze, localObject);
      }
      ((List)localObject).add(paramzza);
    }
    
    public void zzb(zzbph.zze paramzze, String paramString)
    {
      List localList = (List)this.zzcwn.get(paramzze);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.zzcwn.put(paramzze, localObject);
      }
      ((List)localObject).add(paramString);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/zzcl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */