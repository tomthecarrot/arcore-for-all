package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.clearcut.internal.PlayLoggerContext;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzcgl.zzd;
import java.util.Arrays;

public class LogEventParcelable
  extends com.google.android.gms.common.internal.safeparcel.zza
{
  public static final Parcelable.Creator<LogEventParcelable> CREATOR = new zza();
  public boolean addPhenotypeExperimentTokens;
  public final ClearcutLogger.MessageProducer clientVisualElementsProducer;
  public int[] experimentIds;
  public byte[][] experimentTokens;
  public final ClearcutLogger.MessageProducer extensionProducer;
  public final zzcgl.zzd logEvent;
  public byte[] logEventBytes;
  public String[] mendelPackages;
  public PlayLoggerContext playLoggerContext;
  public int[] testCodes;
  
  public LogEventParcelable(PlayLoggerContext paramPlayLoggerContext, zzcgl.zzd paramzzd, ClearcutLogger.MessageProducer paramMessageProducer)
  {
    this(paramPlayLoggerContext, paramzzd, paramMessageProducer, null);
  }
  
  public LogEventParcelable(PlayLoggerContext paramPlayLoggerContext, zzcgl.zzd paramzzd, ClearcutLogger.MessageProducer paramMessageProducer1, ClearcutLogger.MessageProducer paramMessageProducer2)
  {
    this(paramPlayLoggerContext, paramzzd, paramMessageProducer1, paramMessageProducer2, null, null, null, null, true);
  }
  
  public LogEventParcelable(PlayLoggerContext paramPlayLoggerContext, zzcgl.zzd paramzzd, ClearcutLogger.MessageProducer paramMessageProducer1, ClearcutLogger.MessageProducer paramMessageProducer2, int[] paramArrayOfInt1, String[] paramArrayOfString, int[] paramArrayOfInt2, byte[][] paramArrayOfByte, boolean paramBoolean)
  {
    this.playLoggerContext = paramPlayLoggerContext;
    this.logEvent = paramzzd;
    this.extensionProducer = paramMessageProducer1;
    this.clientVisualElementsProducer = paramMessageProducer2;
    this.testCodes = paramArrayOfInt1;
    this.mendelPackages = paramArrayOfString;
    this.experimentIds = paramArrayOfInt2;
    this.experimentTokens = paramArrayOfByte;
    this.addPhenotypeExperimentTokens = paramBoolean;
  }
  
  LogEventParcelable(PlayLoggerContext paramPlayLoggerContext, byte[] paramArrayOfByte, int[] paramArrayOfInt1, String[] paramArrayOfString, int[] paramArrayOfInt2, byte[][] paramArrayOfByte1, boolean paramBoolean)
  {
    this.playLoggerContext = paramPlayLoggerContext;
    this.logEventBytes = paramArrayOfByte;
    this.testCodes = paramArrayOfInt1;
    this.mendelPackages = paramArrayOfString;
    this.logEvent = null;
    this.extensionProducer = null;
    this.clientVisualElementsProducer = null;
    this.experimentIds = paramArrayOfInt2;
    this.experimentTokens = paramArrayOfByte1;
    this.addPhenotypeExperimentTokens = paramBoolean;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof LogEventParcelable)) {
        break;
      }
      paramObject = (LogEventParcelable)paramObject;
    } while ((zzaa.equal(this.playLoggerContext, ((LogEventParcelable)paramObject).playLoggerContext)) && (Arrays.equals(this.logEventBytes, ((LogEventParcelable)paramObject).logEventBytes)) && (Arrays.equals(this.testCodes, ((LogEventParcelable)paramObject).testCodes)) && (Arrays.equals(this.mendelPackages, ((LogEventParcelable)paramObject).mendelPackages)) && (zzaa.equal(this.logEvent, ((LogEventParcelable)paramObject).logEvent)) && (zzaa.equal(this.extensionProducer, ((LogEventParcelable)paramObject).extensionProducer)) && (zzaa.equal(this.clientVisualElementsProducer, ((LogEventParcelable)paramObject).clientVisualElementsProducer)) && (Arrays.equals(this.experimentIds, ((LogEventParcelable)paramObject).experimentIds)) && (Arrays.deepEquals(this.experimentTokens, ((LogEventParcelable)paramObject).experimentTokens)) && (this.addPhenotypeExperimentTokens == ((LogEventParcelable)paramObject).addPhenotypeExperimentTokens));
    return false;
    return false;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { this.playLoggerContext, this.logEventBytes, this.testCodes, this.mendelPackages, this.logEvent, this.extensionProducer, this.clientVisualElementsProducer, this.experimentIds, this.experimentTokens, Boolean.valueOf(this.addPhenotypeExperimentTokens) });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("LogEventParcelable[").append(this.playLoggerContext).append(", ").append("LogEventBytes: ");
    if (this.logEventBytes == null) {}
    for (String str = null;; str = new String(this.logEventBytes)) {
      return str + ", " + "TestCodes: " + Arrays.toString(this.testCodes) + ", " + "MendelPackages: " + Arrays.toString(this.mendelPackages) + ", " + "LogEvent: " + this.logEvent + ", " + "ExtensionProducer: " + this.extensionProducer + ", " + "VeProducer: " + this.clientVisualElementsProducer + ", " + "ExperimentIDs: " + Arrays.toString(this.experimentIds) + ", " + "ExperimentTokens: " + Arrays.toString(this.experimentTokens) + ", " + "AddPhenotypeExperimentTokens: " + this.addPhenotypeExperimentTokens + "]";
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/clearcut/LogEventParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */