package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zzp;
import com.google.android.gms.common.util.zzq;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzd
  extends FastSafeParcelableJsonResponse
{
  public static final Parcelable.Creator<zzd> CREATOR = new zze();
  private final String mClassName;
  private final int mVersionCode;
  private final Parcel zzaTX;
  private final int zzaTY;
  private int zzaTZ;
  private final FieldMappingDictionary zzaTv;
  private int zzaUa;
  
  zzd(int paramInt, Parcel paramParcel, FieldMappingDictionary paramFieldMappingDictionary)
  {
    this.mVersionCode = paramInt;
    this.zzaTX = ((Parcel)zzac.zzC(paramParcel));
    this.zzaTY = 2;
    this.zzaTv = paramFieldMappingDictionary;
    if (this.zzaTv == null) {}
    for (this.mClassName = null;; this.mClassName = this.zzaTv.getRootClassName())
    {
      this.zzaTZ = 2;
      return;
    }
  }
  
  public zzd(FieldMappingDictionary paramFieldMappingDictionary, String paramString)
  {
    this.mVersionCode = 1;
    this.zzaTX = Parcel.obtain();
    this.zzaTY = 0;
    this.zzaTv = ((FieldMappingDictionary)zzac.zzC(paramFieldMappingDictionary));
    this.mClassName = ((String)zzac.zzC(paramString));
    this.zzaTZ = 0;
  }
  
  private static SparseArray<Map.Entry<String, FastJsonResponse.Field<?, ?>>> zzZ(Map<String, FastJsonResponse.Field<?, ?>> paramMap)
  {
    SparseArray localSparseArray = new SparseArray();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localSparseArray.put(((FastJsonResponse.Field)localEntry.getValue()).getSafeParcelableFieldId(), localEntry);
    }
    return localSparseArray;
  }
  
  private void zza(StringBuilder paramStringBuilder, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException(26 + "Unknown type = " + paramInt);
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
      paramStringBuilder.append(paramObject);
      return;
    case 7: 
      paramStringBuilder.append("\"").append(zzp.zzdh(paramObject.toString())).append("\"");
      return;
    case 8: 
      paramStringBuilder.append("\"").append(com.google.android.gms.common.util.zzc.encode((byte[])paramObject)).append("\"");
      return;
    case 9: 
      paramStringBuilder.append("\"").append(com.google.android.gms.common.util.zzc.zzs((byte[])paramObject));
      paramStringBuilder.append("\"");
      return;
    case 10: 
      zzq.zza(paramStringBuilder, (HashMap)paramObject);
      return;
    }
    throw new IllegalArgumentException("Method does not accept concrete type.");
  }
  
  private void zza(StringBuilder paramStringBuilder, FastJsonResponse.Field<?, ?> paramField, Parcel paramParcel, int paramInt)
  {
    switch (paramField.getTypeOut())
    {
    default: 
      paramInt = paramField.getTypeOut();
      throw new IllegalArgumentException(36 + "Unknown field out type = " + paramInt);
    case 0: 
      zzb(paramStringBuilder, paramField, getOriginalValue(paramField, Integer.valueOf(com.google.android.gms.common.internal.safeparcel.zzb.zzg(paramParcel, paramInt))));
      return;
    case 1: 
      zzb(paramStringBuilder, paramField, getOriginalValue(paramField, com.google.android.gms.common.internal.safeparcel.zzb.zzk(paramParcel, paramInt)));
      return;
    case 2: 
      zzb(paramStringBuilder, paramField, getOriginalValue(paramField, Long.valueOf(com.google.android.gms.common.internal.safeparcel.zzb.zzi(paramParcel, paramInt))));
      return;
    case 3: 
      zzb(paramStringBuilder, paramField, getOriginalValue(paramField, Float.valueOf(com.google.android.gms.common.internal.safeparcel.zzb.zzl(paramParcel, paramInt))));
      return;
    case 4: 
      zzb(paramStringBuilder, paramField, getOriginalValue(paramField, Double.valueOf(com.google.android.gms.common.internal.safeparcel.zzb.zzn(paramParcel, paramInt))));
      return;
    case 5: 
      zzb(paramStringBuilder, paramField, getOriginalValue(paramField, com.google.android.gms.common.internal.safeparcel.zzb.zzp(paramParcel, paramInt)));
      return;
    case 6: 
      zzb(paramStringBuilder, paramField, getOriginalValue(paramField, Boolean.valueOf(com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, paramInt))));
      return;
    case 7: 
      zzb(paramStringBuilder, paramField, getOriginalValue(paramField, com.google.android.gms.common.internal.safeparcel.zzb.zzq(paramParcel, paramInt)));
      return;
    case 8: 
    case 9: 
      zzb(paramStringBuilder, paramField, getOriginalValue(paramField, com.google.android.gms.common.internal.safeparcel.zzb.zzt(paramParcel, paramInt)));
      return;
    case 10: 
      zzb(paramStringBuilder, paramField, getOriginalValue(paramField, zzx(com.google.android.gms.common.internal.safeparcel.zzb.zzs(paramParcel, paramInt))));
      return;
    }
    throw new IllegalArgumentException("Method does not accept concrete type.");
  }
  
  private void zza(StringBuilder paramStringBuilder, String paramString, FastJsonResponse.Field<?, ?> paramField, Parcel paramParcel, int paramInt)
  {
    paramStringBuilder.append("\"").append(paramString).append("\":");
    if (paramField.hasConverter())
    {
      zza(paramStringBuilder, paramField, paramParcel, paramInt);
      return;
    }
    zzb(paramStringBuilder, paramField, paramParcel, paramInt);
  }
  
  private void zza(StringBuilder paramStringBuilder, Map<String, FastJsonResponse.Field<?, ?>> paramMap, Parcel paramParcel)
  {
    paramMap = zzZ(paramMap);
    paramStringBuilder.append('{');
    int j = com.google.android.gms.common.internal.safeparcel.zzb.zzdA(paramParcel);
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zzb.zzdz(paramParcel);
      Map.Entry localEntry = (Map.Entry)paramMap.get(com.google.android.gms.common.internal.safeparcel.zzb.zzgg(k));
      if (localEntry != null)
      {
        if (i != 0) {
          paramStringBuilder.append(",");
        }
        zza(paramStringBuilder, (String)localEntry.getKey(), (FastJsonResponse.Field)localEntry.getValue(), paramParcel, k);
        i = 1;
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zzb.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    paramStringBuilder.append('}');
  }
  
  private void zzb(FastJsonResponse.Field<?, ?> paramField)
  {
    if (!paramField.isValidSafeParcelableFieldId()) {
      throw new IllegalStateException("Field does not have a valid safe parcelable field id.");
    }
    if (this.zzaTX == null) {
      throw new IllegalStateException("Internal Parcel object is null.");
    }
    switch (this.zzaTZ)
    {
    default: 
      throw new IllegalStateException("Unknown parse state in SafeParcelResponse.");
    case 0: 
      this.zzaUa = com.google.android.gms.common.internal.safeparcel.zzc.zzdB(this.zzaTX);
      this.zzaTZ = 1;
    case 1: 
      return;
    }
    throw new IllegalStateException("Attempted to parse JSON with a SafeParcelResponse object that is already filled with data.");
  }
  
  private void zzb(StringBuilder paramStringBuilder, FastJsonResponse.Field<?, ?> paramField, Parcel paramParcel, int paramInt)
  {
    if (paramField.isTypeOutArray())
    {
      paramStringBuilder.append("[");
      switch (paramField.getTypeOut())
      {
      default: 
        throw new IllegalStateException("Unknown field type out.");
      case 0: 
        com.google.android.gms.common.util.zzb.zza(paramStringBuilder, com.google.android.gms.common.internal.safeparcel.zzb.zzw(paramParcel, paramInt));
      }
      for (;;)
      {
        paramStringBuilder.append("]");
        return;
        com.google.android.gms.common.util.zzb.zza(paramStringBuilder, com.google.android.gms.common.internal.safeparcel.zzb.zzy(paramParcel, paramInt));
        continue;
        com.google.android.gms.common.util.zzb.zza(paramStringBuilder, com.google.android.gms.common.internal.safeparcel.zzb.zzx(paramParcel, paramInt));
        continue;
        com.google.android.gms.common.util.zzb.zza(paramStringBuilder, com.google.android.gms.common.internal.safeparcel.zzb.zzz(paramParcel, paramInt));
        continue;
        com.google.android.gms.common.util.zzb.zza(paramStringBuilder, com.google.android.gms.common.internal.safeparcel.zzb.zzA(paramParcel, paramInt));
        continue;
        com.google.android.gms.common.util.zzb.zza(paramStringBuilder, com.google.android.gms.common.internal.safeparcel.zzb.zzB(paramParcel, paramInt));
        continue;
        com.google.android.gms.common.util.zzb.zza(paramStringBuilder, com.google.android.gms.common.internal.safeparcel.zzb.zzv(paramParcel, paramInt));
        continue;
        com.google.android.gms.common.util.zzb.zza(paramStringBuilder, com.google.android.gms.common.internal.safeparcel.zzb.zzC(paramParcel, paramInt));
        continue;
        throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
        paramParcel = com.google.android.gms.common.internal.safeparcel.zzb.zzH(paramParcel, paramInt);
        int i = paramParcel.length;
        paramInt = 0;
        while (paramInt < i)
        {
          if (paramInt > 0) {
            paramStringBuilder.append(",");
          }
          paramParcel[paramInt].setDataPosition(0);
          zza(paramStringBuilder, paramField.getConcreteTypeFieldMappingFromDictionary(), paramParcel[paramInt]);
          paramInt += 1;
        }
      }
    }
    switch (paramField.getTypeOut())
    {
    default: 
      throw new IllegalStateException("Unknown field type out");
    case 0: 
      paramStringBuilder.append(com.google.android.gms.common.internal.safeparcel.zzb.zzg(paramParcel, paramInt));
      return;
    case 1: 
      paramStringBuilder.append(com.google.android.gms.common.internal.safeparcel.zzb.zzk(paramParcel, paramInt));
      return;
    case 2: 
      paramStringBuilder.append(com.google.android.gms.common.internal.safeparcel.zzb.zzi(paramParcel, paramInt));
      return;
    case 3: 
      paramStringBuilder.append(com.google.android.gms.common.internal.safeparcel.zzb.zzl(paramParcel, paramInt));
      return;
    case 4: 
      paramStringBuilder.append(com.google.android.gms.common.internal.safeparcel.zzb.zzn(paramParcel, paramInt));
      return;
    case 5: 
      paramStringBuilder.append(com.google.android.gms.common.internal.safeparcel.zzb.zzp(paramParcel, paramInt));
      return;
    case 6: 
      paramStringBuilder.append(com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, paramInt));
      return;
    case 7: 
      paramField = com.google.android.gms.common.internal.safeparcel.zzb.zzq(paramParcel, paramInt);
      paramStringBuilder.append("\"").append(zzp.zzdh(paramField)).append("\"");
      return;
    case 8: 
      paramField = com.google.android.gms.common.internal.safeparcel.zzb.zzt(paramParcel, paramInt);
      paramStringBuilder.append("\"").append(com.google.android.gms.common.util.zzc.encode(paramField)).append("\"");
      return;
    case 9: 
      paramField = com.google.android.gms.common.internal.safeparcel.zzb.zzt(paramParcel, paramInt);
      paramStringBuilder.append("\"").append(com.google.android.gms.common.util.zzc.zzs(paramField));
      paramStringBuilder.append("\"");
      return;
    case 10: 
      paramField = com.google.android.gms.common.internal.safeparcel.zzb.zzs(paramParcel, paramInt);
      paramParcel = paramField.keySet();
      paramParcel.size();
      paramStringBuilder.append("{");
      paramParcel = paramParcel.iterator();
      for (paramInt = 1; paramParcel.hasNext(); paramInt = 0)
      {
        String str = (String)paramParcel.next();
        if (paramInt == 0) {
          paramStringBuilder.append(",");
        }
        paramStringBuilder.append("\"").append(str).append("\"");
        paramStringBuilder.append(":");
        paramStringBuilder.append("\"").append(zzp.zzdh(paramField.getString(str))).append("\"");
      }
      paramStringBuilder.append("}");
      return;
    }
    paramParcel = com.google.android.gms.common.internal.safeparcel.zzb.zzG(paramParcel, paramInt);
    paramParcel.setDataPosition(0);
    zza(paramStringBuilder, paramField.getConcreteTypeFieldMappingFromDictionary(), paramParcel);
  }
  
  private void zzb(StringBuilder paramStringBuilder, FastJsonResponse.Field<?, ?> paramField, Object paramObject)
  {
    if (paramField.isTypeInArray())
    {
      zzb(paramStringBuilder, paramField, (ArrayList)paramObject);
      return;
    }
    zza(paramStringBuilder, paramField.getTypeIn(), paramObject);
  }
  
  private void zzb(StringBuilder paramStringBuilder, FastJsonResponse.Field<?, ?> paramField, ArrayList<?> paramArrayList)
  {
    paramStringBuilder.append("[");
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(",");
      }
      zza(paramStringBuilder, paramField.getTypeIn(), paramArrayList.get(i));
      i += 1;
    }
    paramStringBuilder.append("]");
  }
  
  public static HashMap<String, String> zzx(Bundle paramBundle)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, paramBundle.getString(str));
    }
    return localHashMap;
  }
  
  public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<T> paramArrayList)
  {
    zzb(paramField);
    paramString = new ArrayList();
    paramArrayList.size();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      paramString.add(((zzd)paramArrayList.next()).zzAs());
    }
    com.google.android.gms.common.internal.safeparcel.zzc.zzd(this.zzaTX, paramField.getSafeParcelableFieldId(), paramString, true);
  }
  
  public <T extends FastJsonResponse> void addConcreteTypeInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, T paramT)
  {
    zzb(paramField);
    paramString = ((zzd)paramT).zzAs();
    com.google.android.gms.common.internal.safeparcel.zzc.zza(this.zzaTX, paramField.getSafeParcelableFieldId(), paramString, true);
  }
  
  public Map<String, FastJsonResponse.Field<?, ?>> getFieldMappings()
  {
    if (this.zzaTv == null) {
      return null;
    }
    return this.zzaTv.getFieldMapping(this.mClassName);
  }
  
  public Object getValueObject(String paramString)
  {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public boolean isPrimitiveFieldSet(String paramString)
  {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }
  
  protected void setBigDecimalInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, BigDecimal paramBigDecimal)
  {
    zzb(paramField);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(this.zzaTX, paramField.getSafeParcelableFieldId(), paramBigDecimal, true);
  }
  
  protected void setBigDecimalsInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<BigDecimal> paramArrayList)
  {
    zzb(paramField);
    int j = paramArrayList.size();
    paramString = new BigDecimal[j];
    int i = 0;
    while (i < j)
    {
      paramString[i] = ((BigDecimal)paramArrayList.get(i));
      i += 1;
    }
    com.google.android.gms.common.internal.safeparcel.zzc.zza(this.zzaTX, paramField.getSafeParcelableFieldId(), paramString, true);
  }
  
  protected void setBigIntegerInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, BigInteger paramBigInteger)
  {
    zzb(paramField);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(this.zzaTX, paramField.getSafeParcelableFieldId(), paramBigInteger, true);
  }
  
  protected void setBigIntegersInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<BigInteger> paramArrayList)
  {
    zzb(paramField);
    int j = paramArrayList.size();
    paramString = new BigInteger[j];
    int i = 0;
    while (i < j)
    {
      paramString[i] = ((BigInteger)paramArrayList.get(i));
      i += 1;
    }
    com.google.android.gms.common.internal.safeparcel.zzc.zza(this.zzaTX, paramField.getSafeParcelableFieldId(), paramString, true);
  }
  
  protected void setBooleanInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, boolean paramBoolean)
  {
    zzb(paramField);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(this.zzaTX, paramField.getSafeParcelableFieldId(), paramBoolean);
  }
  
  protected void setBooleansInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<Boolean> paramArrayList)
  {
    zzb(paramField);
    int j = paramArrayList.size();
    paramString = new boolean[j];
    int i = 0;
    while (i < j)
    {
      paramString[i] = ((Boolean)paramArrayList.get(i)).booleanValue();
      i += 1;
    }
    com.google.android.gms.common.internal.safeparcel.zzc.zza(this.zzaTX, paramField.getSafeParcelableFieldId(), paramString, true);
  }
  
  protected void setDecodedBytesInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, byte[] paramArrayOfByte)
  {
    zzb(paramField);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(this.zzaTX, paramField.getSafeParcelableFieldId(), paramArrayOfByte, true);
  }
  
  protected void setDoubleInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, double paramDouble)
  {
    zzb(paramField);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(this.zzaTX, paramField.getSafeParcelableFieldId(), paramDouble);
  }
  
  protected void setDoublesInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<Double> paramArrayList)
  {
    zzb(paramField);
    int j = paramArrayList.size();
    paramString = new double[j];
    int i = 0;
    while (i < j)
    {
      paramString[i] = ((Double)paramArrayList.get(i)).doubleValue();
      i += 1;
    }
    com.google.android.gms.common.internal.safeparcel.zzc.zza(this.zzaTX, paramField.getSafeParcelableFieldId(), paramString, true);
  }
  
  protected void setFloatInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, float paramFloat)
  {
    zzb(paramField);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(this.zzaTX, paramField.getSafeParcelableFieldId(), paramFloat);
  }
  
  protected void setFloatsInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<Float> paramArrayList)
  {
    zzb(paramField);
    int j = paramArrayList.size();
    paramString = new float[j];
    int i = 0;
    while (i < j)
    {
      paramString[i] = ((Float)paramArrayList.get(i)).floatValue();
      i += 1;
    }
    com.google.android.gms.common.internal.safeparcel.zzc.zza(this.zzaTX, paramField.getSafeParcelableFieldId(), paramString, true);
  }
  
  protected void setIntegerInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, int paramInt)
  {
    zzb(paramField);
    com.google.android.gms.common.internal.safeparcel.zzc.zzc(this.zzaTX, paramField.getSafeParcelableFieldId(), paramInt);
  }
  
  protected void setIntegersInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<Integer> paramArrayList)
  {
    zzb(paramField);
    int j = paramArrayList.size();
    paramString = new int[j];
    int i = 0;
    while (i < j)
    {
      paramString[i] = ((Integer)paramArrayList.get(i)).intValue();
      i += 1;
    }
    com.google.android.gms.common.internal.safeparcel.zzc.zza(this.zzaTX, paramField.getSafeParcelableFieldId(), paramString, true);
  }
  
  protected void setLongInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, long paramLong)
  {
    zzb(paramField);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(this.zzaTX, paramField.getSafeParcelableFieldId(), paramLong);
  }
  
  protected void setLongsInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<Long> paramArrayList)
  {
    zzb(paramField);
    int j = paramArrayList.size();
    paramString = new long[j];
    int i = 0;
    while (i < j)
    {
      paramString[i] = ((Long)paramArrayList.get(i)).longValue();
      i += 1;
    }
    com.google.android.gms.common.internal.safeparcel.zzc.zza(this.zzaTX, paramField.getSafeParcelableFieldId(), paramString, true);
  }
  
  protected void setStringInternal(FastJsonResponse.Field<?, ?> paramField, String paramString1, String paramString2)
  {
    zzb(paramField);
    com.google.android.gms.common.internal.safeparcel.zzc.zza(this.zzaTX, paramField.getSafeParcelableFieldId(), paramString2, true);
  }
  
  protected void setStringMapInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, Map<String, String> paramMap)
  {
    zzb(paramField);
    paramString = new Bundle();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramString.putString(str, (String)paramMap.get(str));
    }
    com.google.android.gms.common.internal.safeparcel.zzc.zza(this.zzaTX, paramField.getSafeParcelableFieldId(), paramString, true);
  }
  
  protected void setStringsInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<String> paramArrayList)
  {
    zzb(paramField);
    int j = paramArrayList.size();
    paramString = new String[j];
    int i = 0;
    while (i < j)
    {
      paramString[i] = ((String)paramArrayList.get(i));
      i += 1;
    }
    com.google.android.gms.common.internal.safeparcel.zzc.zza(this.zzaTX, paramField.getSafeParcelableFieldId(), paramString, true);
  }
  
  public String toString()
  {
    zzac.zzb(this.zzaTv, "Cannot convert to JSON on client side.");
    Parcel localParcel = zzAs();
    localParcel.setDataPosition(0);
    StringBuilder localStringBuilder = new StringBuilder(100);
    zza(localStringBuilder, this.zzaTv.getFieldMapping(this.mClassName), localParcel);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }
  
  public Parcel zzAs()
  {
    switch (this.zzaTZ)
    {
    }
    for (;;)
    {
      return this.zzaTX;
      this.zzaUa = com.google.android.gms.common.internal.safeparcel.zzc.zzdB(this.zzaTX);
      com.google.android.gms.common.internal.safeparcel.zzc.zzK(this.zzaTX, this.zzaUa);
      this.zzaTZ = 2;
      continue;
      com.google.android.gms.common.internal.safeparcel.zzc.zzK(this.zzaTX, this.zzaUa);
      this.zzaTZ = 2;
    }
  }
  
  FieldMappingDictionary zzAt()
  {
    switch (this.zzaTY)
    {
    default: 
      int i = this.zzaTY;
      throw new IllegalStateException(34 + "Invalid creation type: " + i);
    case 0: 
      return null;
    case 1: 
      return this.zzaTv;
    }
    return this.zzaTv;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/server/response/zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */