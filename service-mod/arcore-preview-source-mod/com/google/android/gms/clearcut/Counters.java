package com.google.android.gms.clearcut;

import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.zzh;
import com.google.android.gms.internal.zzcgg;
import com.google.android.gms.internal.zzcgm.zza;
import com.google.android.gms.internal.zzcgm.zzb;
import com.google.android.gms.internal.zzcgm.zzc;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class Counters
{
  public static final Alias IDENTITY = new BucketAlias(1);
  private static final Charset UTF_8 = Charset.forName("UTF-8");
  private static final ResultCallback<Status> zzaJn = new ResultCallback() {};
  private static final Comparator zzaJo = new Comparator()
  {
    public boolean equals(Object paramAnonymousObject)
    {
      throw new UnsupportedOperationException("what are you doing?");
    }
    
    public int zza(byte[] paramAnonymousArrayOfByte1, byte[] paramAnonymousArrayOfByte2)
    {
      int i = 0;
      if ((paramAnonymousArrayOfByte1 == null) && (paramAnonymousArrayOfByte2 == null)) {
        return 0;
      }
      if (paramAnonymousArrayOfByte1 == null) {
        return -1;
      }
      if (paramAnonymousArrayOfByte2 == null) {
        return 1;
      }
      int j = Math.min(paramAnonymousArrayOfByte1.length, paramAnonymousArrayOfByte2.length);
      while (i < j) {
        if (paramAnonymousArrayOfByte1[i] == paramAnonymousArrayOfByte2[i]) {
          i += 1;
        } else {
          return paramAnonymousArrayOfByte1[i] - paramAnonymousArrayOfByte2[i];
        }
      }
      return paramAnonymousArrayOfByte1.length - paramAnonymousArrayOfByte2.length;
    }
  };
  private final String zzaIK;
  private final int zzaJd;
  private boolean zzaJe = false;
  private long zzaJf;
  private final ClearcutLogger zzaJg;
  private final ReentrantReadWriteLock zzaJh = new ReentrantReadWriteLock();
  private Map<String, AbstractCounter> zzaJi = new TreeMap();
  private byte[] zzaJj = null;
  private Integer zzaJk = null;
  TreeMap<byte[], Integer> zzaJl = new TreeMap(zzaJo);
  private LogCallback zzaJm = null;
  private final Clock zzvi;
  
  public Counters(ClearcutLogger paramClearcutLogger, String paramString, int paramInt)
  {
    this(paramClearcutLogger, paramString, paramInt, zzh.zzAM());
  }
  
  public Counters(ClearcutLogger paramClearcutLogger, String paramString, int paramInt, Clock paramClock)
  {
    zzac.zzC(paramClearcutLogger);
    zzac.zzC(paramString);
    if (paramInt > 1) {}
    for (;;)
    {
      zzac.zzaw(bool);
      zzac.zzC(paramClock);
      this.zzaJg = paramClearcutLogger;
      this.zzaIK = paramString;
      this.zzaJd = paramInt;
      this.zzvi = paramClock;
      this.zzaJf = this.zzvi.elapsedRealtime();
      return;
      bool = false;
    }
  }
  
  private Counters(Counters paramCounters, boolean paramBoolean)
  {
    this(paramCounters.zzaJg, paramCounters.zzaIK, paramCounters.zzaJd, paramCounters.zzvi);
    Object localObject1;
    if (paramBoolean) {
      localObject1 = paramCounters.zzaJh.writeLock();
    }
    Map.Entry localEntry;
    for (;;)
    {
      ((Lock)localObject1).lock();
      try
      {
        this.zzaJj = paramCounters.zzaJj;
        this.zzaJk = paramCounters.zzaJk;
        this.zzaJf = paramCounters.zzaJf;
        this.zzaJi = new TreeMap();
        if (!paramBoolean) {
          break label218;
        }
        localObject2 = paramCounters.zzaJi.entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localEntry = (Map.Entry)((Iterator)localObject2).next();
          this.zzaJi.put((String)localEntry.getKey(), zza((AbstractCounter)localEntry.getValue(), paramBoolean));
        }
        localObject1 = paramCounters.zzaJh.readLock();
      }
      finally
      {
        ((Lock)localObject1).unlock();
      }
    }
    Object localObject2 = this.zzaJl;
    this.zzaJl = paramCounters.zzaJl;
    paramCounters.zzaJl = ((TreeMap)localObject2);
    paramCounters.zzaJk = null;
    paramCounters.zzaJf = this.zzvi.elapsedRealtime();
    for (;;)
    {
      ((Lock)localObject1).unlock();
      return;
      label218:
      localObject2 = paramCounters.zzaJi.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localEntry = (Map.Entry)((Iterator)localObject2).next();
        this.zzaJi.put((String)localEntry.getKey(), zza((AbstractCounter)localEntry.getValue(), paramBoolean));
      }
      this.zzaJl.putAll(paramCounters.zzaJl);
    }
  }
  
  private PendingResult<Status> zzg(GoogleApiClient paramGoogleApiClient)
  {
    Iterator localIterator = this.zzaJl.keySet().iterator();
    ClearcutLogger.MessageProducer localMessageProducer;
    for (PendingResult localPendingResult = null; localIterator.hasNext(); localPendingResult = this.zzaJg.newEvent(localMessageProducer.toProtoBytes()).setLogSourceName(this.zzaIK).log(paramGoogleApiClient))
    {
      localMessageProducer = makeProducer((byte[])localIterator.next());
      if (localPendingResult != null) {
        localPendingResult.setResultCallback(zzaJn);
      }
    }
    return localPendingResult;
  }
  
  private Counters zzwE()
  {
    Object localObject1 = this.zzaJm;
    this.zzaJh.writeLock().lock();
    if (localObject1 != null) {}
    try
    {
      ((LogCallback)localObject1).onLogged(this);
      localObject1 = snapshotAndReset();
      return (Counters)localObject1;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        Log.i("Counters", "problem executing callback: ", localRuntimeException);
      }
    }
    finally
    {
      this.zzaJh.writeLock().unlock();
    }
  }
  
  private PendingResult<Status> zzwF()
  {
    Iterator localIterator = this.zzaJl.keySet().iterator();
    Object localObject;
    for (PendingResult localPendingResult = null; localIterator.hasNext(); localPendingResult = ((ClearcutLogger.LogEventBuilder)localObject).logAsync())
    {
      localObject = makeProducer((byte[])localIterator.next());
      localObject = this.zzaJg.newEvent((ClearcutLogger.MessageProducer)localObject).setLogSourceName(this.zzaIK);
      if (localPendingResult != null) {
        localPendingResult.setResultCallback(zzaJn);
      }
    }
    return localPendingResult;
  }
  
  public BooleanHistogram getBooleanHistogram(String paramString)
  {
    this.zzaJh.writeLock().lock();
    for (;;)
    {
      try
      {
        Object localObject = (AbstractCounter)this.zzaJi.get(paramString);
        if (localObject == null)
        {
          paramString = newBooleanHistogram(paramString);
          return paramString;
        }
        try
        {
          localObject = (BooleanHistogram)localObject;
          return (BooleanHistogram)localObject;
        }
        catch (ClassCastException localClassCastException)
        {
          paramString = String.valueOf(paramString);
          if (paramString.length() == 0) {
            break label106;
          }
        }
        paramString = "another type of counter exists with name: ".concat(paramString);
        throw new IllegalArgumentException(paramString);
      }
      finally
      {
        this.zzaJh.writeLock().unlock();
      }
      label106:
      paramString = new String("another type of counter exists with name: ");
    }
  }
  
  public Counter getCounter(String paramString)
  {
    this.zzaJh.writeLock().lock();
    for (;;)
    {
      try
      {
        Object localObject = (AbstractCounter)this.zzaJi.get(paramString);
        if (localObject == null)
        {
          paramString = newCounter(paramString);
          return paramString;
        }
        try
        {
          localObject = (Counter)localObject;
          return (Counter)localObject;
        }
        catch (ClassCastException localClassCastException)
        {
          paramString = String.valueOf(paramString);
          if (paramString.length() == 0) {
            break label106;
          }
        }
        paramString = "another type of counter exists with name: ".concat(paramString);
        throw new IllegalArgumentException(paramString);
      }
      finally
      {
        this.zzaJh.writeLock().unlock();
      }
      label106:
      paramString = new String("another type of counter exists with name: ");
    }
  }
  
  public Collection<byte[]> getDimensionsInstances()
  {
    this.zzaJh.readLock().lock();
    try
    {
      ArrayList localArrayList = new ArrayList(this.zzaJl.keySet());
      return localArrayList;
    }
    finally
    {
      this.zzaJh.readLock().unlock();
    }
  }
  
  public IntegerHistogram getIntegerHistogram(String paramString)
  {
    this.zzaJh.writeLock().lock();
    for (;;)
    {
      try
      {
        Object localObject = (AbstractCounter)this.zzaJi.get(paramString);
        if (localObject == null)
        {
          paramString = newIntegerHistogram(paramString);
          return paramString;
        }
        try
        {
          localObject = (IntegerHistogram)localObject;
          return (IntegerHistogram)localObject;
        }
        catch (ClassCastException localClassCastException)
        {
          paramString = String.valueOf(paramString);
          if (paramString.length() == 0) {
            break label106;
          }
        }
        paramString = "another type of counter exists with name: ".concat(paramString);
        throw new IllegalArgumentException(paramString);
      }
      finally
      {
        this.zzaJh.writeLock().unlock();
      }
      label106:
      paramString = new String("another type of counter exists with name: ");
    }
  }
  
  public LongHistogram getLongHistogram(String paramString)
  {
    return getLongHistogram(paramString, IDENTITY);
  }
  
  public LongHistogram getLongHistogram(String paramString, Alias paramAlias)
  {
    this.zzaJh.writeLock().lock();
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = (AbstractCounter)this.zzaJi.get(paramString);
        if (localObject == null)
        {
          paramString = newLongHistogram(paramString, paramAlias);
          return paramString;
        }
        try
        {
          localObject = (LongHistogram)localObject;
          if (paramAlias.equals(((LongHistogram)localObject).zzaJt)) {
            break label149;
          }
          paramAlias = String.valueOf(paramString);
          if (paramAlias.length() == 0) {
            break label135;
          }
          paramAlias = "alias mismatch: ".concat(paramAlias);
          throw new IllegalArgumentException(paramAlias);
        }
        catch (ClassCastException paramAlias)
        {
          paramString = String.valueOf(paramString);
          if (paramString.length() == 0) {
            break label161;
          }
        }
        paramString = "another type of counter exists with name: ".concat(paramString);
        throw new IllegalArgumentException(paramString);
      }
      finally
      {
        this.zzaJh.writeLock().unlock();
      }
      label135:
      paramAlias = new String("alias mismatch: ");
      continue;
      label149:
      this.zzaJh.writeLock().unlock();
      return (LongHistogram)localObject;
      label161:
      paramString = new String("another type of counter exists with name: ");
    }
  }
  
  public TimerHistogram getTimerHistogram(String paramString)
  {
    return getTimerHistogram(paramString, IDENTITY);
  }
  
  public TimerHistogram getTimerHistogram(String paramString, Alias paramAlias)
  {
    this.zzaJh.writeLock().lock();
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = (AbstractCounter)this.zzaJi.get(paramString);
        if (localObject == null)
        {
          paramString = newTimerHistogram(paramString, paramAlias);
          return paramString;
        }
        try
        {
          localObject = (TimerHistogram)localObject;
          if (paramAlias.equals(((TimerHistogram)localObject).zzaJt)) {
            break label149;
          }
          paramAlias = String.valueOf(paramString);
          if (paramAlias.length() == 0) {
            break label135;
          }
          paramAlias = "alias mismatch: ".concat(paramAlias);
          throw new IllegalArgumentException(paramAlias);
        }
        catch (ClassCastException paramAlias)
        {
          paramString = String.valueOf(paramString);
          if (paramString.length() == 0) {
            break label161;
          }
        }
        paramString = "another type of counter exists with name: ".concat(paramString);
        throw new IllegalArgumentException(paramString);
      }
      finally
      {
        this.zzaJh.writeLock().unlock();
      }
      label135:
      paramAlias = new String("alias mismatch: ");
      continue;
      label149:
      this.zzaJh.writeLock().unlock();
      return (TimerHistogram)localObject;
      label161:
      paramString = new String("another type of counter exists with name: ");
    }
  }
  
  public PendingResult<Status> logAll()
  {
    return zzwE().zzg(null);
  }
  
  @Deprecated
  public PendingResult<Status> logAll(GoogleApiClient paramGoogleApiClient)
  {
    return logAll();
  }
  
  public PendingResult<Status> logAllAsync(GoogleApiClient paramGoogleApiClient)
  {
    return zzwE().zzwF();
  }
  
  public void logAllAsync()
  {
    logAllAsync(null);
  }
  
  public ClearcutLogger.MessageProducer makeProducer(byte[] paramArrayOfByte)
  {
    return zzo(paramArrayOfByte);
  }
  
  public BooleanHistogram newBooleanHistogram(String paramString)
  {
    this.zzaJh.writeLock().lock();
    try
    {
      paramString = new BooleanHistogram(paramString, null);
      return paramString;
    }
    finally
    {
      this.zzaJh.writeLock().unlock();
    }
  }
  
  public Counter newCounter(String paramString)
  {
    this.zzaJh.writeLock().lock();
    try
    {
      paramString = new Counter(paramString, null);
      return paramString;
    }
    finally
    {
      this.zzaJh.writeLock().unlock();
    }
  }
  
  public IntegerHistogram newIntegerHistogram(String paramString)
  {
    this.zzaJh.writeLock().lock();
    try
    {
      paramString = new IntegerHistogram(paramString, null);
      return paramString;
    }
    finally
    {
      this.zzaJh.writeLock().unlock();
    }
  }
  
  public LongHistogram newLongHistogram(String paramString)
  {
    return newLongHistogram(paramString, IDENTITY);
  }
  
  public LongHistogram newLongHistogram(String paramString, Alias paramAlias)
  {
    this.zzaJh.writeLock().lock();
    try
    {
      paramString = new LongHistogram(paramString, paramAlias, null);
      return paramString;
    }
    finally
    {
      this.zzaJh.writeLock().unlock();
    }
  }
  
  public Timer newTimer()
  {
    return new Timer();
  }
  
  public TimerHistogram newTimerHistogram(String paramString)
  {
    return new TimerHistogram(paramString, IDENTITY, null);
  }
  
  public TimerHistogram newTimerHistogram(String paramString, Alias paramAlias)
  {
    this.zzaJh.writeLock().lock();
    try
    {
      paramString = new TimerHistogram(paramString, paramAlias, null);
      return paramString;
    }
    finally
    {
      this.zzaJh.writeLock().unlock();
    }
  }
  
  public void setAutoLogAsync()
  {
    setAutoLogAsync(null);
  }
  
  public void setAutoLogAsync(GoogleApiClient paramGoogleApiClient)
  {
    this.zzaJh.writeLock().lock();
    try
    {
      this.zzaJe = true;
      return;
    }
    finally
    {
      this.zzaJh.writeLock().unlock();
    }
  }
  
  public void setDimensionsInstance(byte[] paramArrayOfByte)
  {
    this.zzaJh.writeLock().lock();
    try
    {
      this.zzaJj = paramArrayOfByte;
      this.zzaJk = ((Integer)this.zzaJl.get(this.zzaJj));
      return;
    }
    finally
    {
      this.zzaJh.writeLock().unlock();
    }
  }
  
  public void setLogCallback(LogCallback paramLogCallback)
  {
    this.zzaJm = paramLogCallback;
  }
  
  public Counters snapshot()
  {
    return new Counters(this, false);
  }
  
  public Counters snapshotAndReset()
  {
    return new Counters(this, true);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    this.zzaJh.readLock().lock();
    for (;;)
    {
      try
      {
        localStringBuilder.append("{");
        Iterator localIterator = this.zzaJl.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        Object localObject1 = (Map.Entry)localIterator.next();
        if (((Map.Entry)localObject1).getKey() == null)
        {
          localObject1 = "null";
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(", ");
        }
        else
        {
          localObject3 = new String((byte[])((Map.Entry)localObject2).getKey());
        }
      }
      finally
      {
        this.zzaJh.readLock().unlock();
      }
    }
    localStringBuilder.append("}\n");
    Object localObject3 = this.zzaJi.values().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localStringBuilder.append(((AbstractCounter)((Iterator)localObject3).next()).toString());
      localStringBuilder.append("\n");
    }
    this.zzaJh.readLock().unlock();
    return localStringBuilder.toString();
  }
  
  AbstractCounter zza(AbstractCounter paramAbstractCounter, boolean paramBoolean)
  {
    if ((paramAbstractCounter instanceof Counter)) {
      return new Counter((Counter)paramAbstractCounter, paramBoolean, null);
    }
    if ((paramAbstractCounter instanceof TimerHistogram)) {
      return new TimerHistogram((TimerHistogram)paramAbstractCounter, paramBoolean, null);
    }
    if ((paramAbstractCounter instanceof IntegerHistogram)) {
      return new IntegerHistogram((IntegerHistogram)paramAbstractCounter, paramBoolean, null);
    }
    if ((paramAbstractCounter instanceof LongHistogram)) {
      return new LongHistogram((LongHistogram)paramAbstractCounter, paramBoolean, null);
    }
    if ((paramAbstractCounter instanceof BooleanHistogram)) {
      return new BooleanHistogram((BooleanHistogram)paramAbstractCounter, paramBoolean, null);
    }
    paramAbstractCounter = String.valueOf(paramAbstractCounter);
    throw new IllegalArgumentException(String.valueOf(paramAbstractCounter).length() + 21 + "Unkown counter type: " + paramAbstractCounter);
  }
  
  Integer zzn(byte[] paramArrayOfByte)
  {
    Integer localInteger2 = (Integer)this.zzaJl.get(paramArrayOfByte);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null)
    {
      localInteger1 = Integer.valueOf(this.zzaJl.size());
      this.zzaJl.put(paramArrayOfByte, localInteger1);
    }
    return localInteger1;
  }
  
  zzb zzo(byte[] paramArrayOfByte)
  {
    return new zzb(paramArrayOfByte);
  }
  
  public abstract class AbstractCounter
  {
    private final String mName;
    private int zzaJp;
    private int zzaJq = Counters.zza(Counters.this);
    Map<Integer, Map<Long, long[]>> zzaJr = new HashMap();
    private Object zzrU = new Object();
    
    protected AbstractCounter(AbstractCounter paramAbstractCounter, boolean paramBoolean)
    {
      this(paramAbstractCounter.mName);
      this$1 = paramAbstractCounter.zzrU;
      for (;;)
      {
        try
        {
          this.zzaJp = paramAbstractCounter.zzaJp;
          if (paramBoolean)
          {
            localObject = this.zzaJr;
            this.zzaJr = paramAbstractCounter.zzaJr;
            paramAbstractCounter.zzaJr = ((Map)localObject);
            paramAbstractCounter.zzaJp = 0;
            return;
          }
          this.zzaJr = new HashMap(paramAbstractCounter.zzaJr.size());
          paramAbstractCounter = paramAbstractCounter.zzaJr.entrySet().iterator();
          if (!paramAbstractCounter.hasNext()) {
            break;
          }
          Object localObject = (Map.Entry)paramAbstractCounter.next();
          HashMap localHashMap = new HashMap(((Map)((Map.Entry)localObject).getValue()).size());
          Iterator localIterator = ((Map)((Map.Entry)localObject).getValue()).entrySet().iterator();
          if (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            localHashMap.put((Long)localEntry.getKey(), new long[] { ((long[])localEntry.getValue())[0] });
          }
          else
          {
            this.zzaJr.put((Integer)((Map.Entry)localObject).getKey(), localHashMap);
          }
        }
        finally {}
      }
    }
    
    protected AbstractCounter(String paramString)
    {
      if (Counters.zzb(Counters.this).containsKey(paramString))
      {
        this$1 = String.valueOf(paramString);
        if (Counters.this.length() != 0) {}
        for (this$1 = "counter/histogram already exists: ".concat(Counters.this);; this$1 = new String("counter/histogram already exists: ")) {
          throw new IllegalStateException(Counters.this);
        }
      }
      Counters.zzb(Counters.this).put(paramString, this);
      this.mName = paramString;
    }
    
    private boolean zzc(long paramLong1, long paramLong2)
    {
      Object localObject2 = Counters.zzc(Counters.this).writeLock();
      ((Lock)localObject2).lock();
      Object localObject1 = localObject2;
      try
      {
        Counters.zza(Counters.this, Counters.this.zzn(Counters.zze(Counters.this)));
        localObject1 = localObject2;
        Counters.zzc(Counters.this).readLock().lock();
        localObject1 = localObject2;
        ((Lock)localObject2).unlock();
        localObject1 = localObject2;
        localObject2 = Counters.zzc(Counters.this).readLock();
        localObject1 = localObject2;
        boolean bool = zzd(paramLong1, paramLong2);
        return bool;
      }
      finally
      {
        ((Lock)localObject1).unlock();
      }
    }
    
    private boolean zzd(long paramLong1, long paramLong2)
    {
      label267:
      for (;;)
      {
        synchronized (this.zzrU)
        {
          Object localObject1 = (Map)this.zzaJr.get(Counters.zzd(Counters.this));
          if (localObject1 != null) {
            break label267;
          }
          localObject1 = new HashMap();
          this.zzaJr.put(Counters.zzd(Counters.this), localObject1);
          if ((this.zzaJp >= Counters.zza(Counters.this)) && (!Counters.zzf(Counters.this)))
          {
            if (this.zzaJp == Counters.zza(Counters.this))
            {
              localObject1 = String.valueOf(this.mName);
              if (((String)localObject1).length() != 0)
              {
                localObject1 = "exceeded sample count in ".concat((String)localObject1);
                Log.i("Counters", (String)localObject1);
              }
            }
            else
            {
              return false;
            }
            localObject1 = new String("exceeded sample count in ");
          }
        }
        this.zzaJp += 1;
        long[] arrayOfLong2 = (long[])((Map)localObject2).get(Long.valueOf(paramLong1));
        long[] arrayOfLong1 = arrayOfLong2;
        if (arrayOfLong2 == null)
        {
          arrayOfLong1 = new long[1];
          arrayOfLong1[0] = 0L;
          ((Map)localObject2).put(Long.valueOf(paramLong1), arrayOfLong1);
        }
        arrayOfLong1[0] += paramLong2;
        if ((Counters.zzf(Counters.this)) && (this.zzaJp >= this.zzaJq)) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
      }
    }
    
    /* Error */
    protected long getCountBase(long paramLong)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 84	com/google/android/gms/clearcut/Counters$AbstractCounter:zzaJs	Lcom/google/android/gms/clearcut/Counters;
      //   4: invokestatic 129	com/google/android/gms/clearcut/Counters:zzc	(Lcom/google/android/gms/clearcut/Counters;)Ljava/util/concurrent/locks/ReentrantReadWriteLock;
      //   7: invokevirtual 155	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
      //   10: invokevirtual 158	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
      //   13: aload_0
      //   14: getfield 28	com/google/android/gms/clearcut/Counters$AbstractCounter:zzrU	Ljava/lang/Object;
      //   17: astore_3
      //   18: aload_3
      //   19: monitorenter
      //   20: aload_0
      //   21: getfield 84	com/google/android/gms/clearcut/Counters$AbstractCounter:zzaJs	Lcom/google/android/gms/clearcut/Counters;
      //   24: invokestatic 167	com/google/android/gms/clearcut/Counters:zzd	(Lcom/google/android/gms/clearcut/Counters;)Ljava/lang/Integer;
      //   27: ifnonnull +20 -> 47
      //   30: aload_3
      //   31: monitorexit
      //   32: aload_0
      //   33: getfield 84	com/google/android/gms/clearcut/Counters$AbstractCounter:zzaJs	Lcom/google/android/gms/clearcut/Counters;
      //   36: invokestatic 129	com/google/android/gms/clearcut/Counters:zzc	(Lcom/google/android/gms/clearcut/Counters;)Ljava/util/concurrent/locks/ReentrantReadWriteLock;
      //   39: invokevirtual 155	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
      //   42: invokevirtual 191	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
      //   45: lconst_0
      //   46: lreturn
      //   47: aload_0
      //   48: getfield 32	com/google/android/gms/clearcut/Counters$AbstractCounter:zzaJr	Ljava/util/Map;
      //   51: aload_0
      //   52: getfield 84	com/google/android/gms/clearcut/Counters$AbstractCounter:zzaJs	Lcom/google/android/gms/clearcut/Counters;
      //   55: invokestatic 167	com/google/android/gms/clearcut/Counters:zzd	(Lcom/google/android/gms/clearcut/Counters;)Ljava/lang/Integer;
      //   58: invokeinterface 171 2 0
      //   63: checkcast 36	java/util/Map
      //   66: astore 4
      //   68: aload 4
      //   70: ifnonnull +20 -> 90
      //   73: aload_3
      //   74: monitorexit
      //   75: aload_0
      //   76: getfield 84	com/google/android/gms/clearcut/Counters$AbstractCounter:zzaJs	Lcom/google/android/gms/clearcut/Counters;
      //   79: invokestatic 129	com/google/android/gms/clearcut/Counters:zzc	(Lcom/google/android/gms/clearcut/Counters;)Ljava/util/concurrent/locks/ReentrantReadWriteLock;
      //   82: invokevirtual 155	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
      //   85: invokevirtual 191	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
      //   88: lconst_0
      //   89: lreturn
      //   90: aload 4
      //   92: lload_1
      //   93: invokestatic 188	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   96: invokeinterface 171 2 0
      //   101: checkcast 75	[J
      //   104: astore 4
      //   106: aload 4
      //   108: ifnonnull +20 -> 128
      //   111: aload_3
      //   112: monitorexit
      //   113: aload_0
      //   114: getfield 84	com/google/android/gms/clearcut/Counters$AbstractCounter:zzaJs	Lcom/google/android/gms/clearcut/Counters;
      //   117: invokestatic 129	com/google/android/gms/clearcut/Counters:zzc	(Lcom/google/android/gms/clearcut/Counters;)Ljava/util/concurrent/locks/ReentrantReadWriteLock;
      //   120: invokevirtual 155	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
      //   123: invokevirtual 191	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
      //   126: lconst_0
      //   127: lreturn
      //   128: aload 4
      //   130: iconst_0
      //   131: laload
      //   132: lstore_1
      //   133: aload_3
      //   134: monitorexit
      //   135: aload_0
      //   136: getfield 84	com/google/android/gms/clearcut/Counters$AbstractCounter:zzaJs	Lcom/google/android/gms/clearcut/Counters;
      //   139: invokestatic 129	com/google/android/gms/clearcut/Counters:zzc	(Lcom/google/android/gms/clearcut/Counters;)Ljava/util/concurrent/locks/ReentrantReadWriteLock;
      //   142: invokevirtual 155	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
      //   145: invokevirtual 191	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
      //   148: lload_1
      //   149: lreturn
      //   150: astore 4
      //   152: aload_3
      //   153: monitorexit
      //   154: aload 4
      //   156: athrow
      //   157: astore_3
      //   158: aload_0
      //   159: getfield 84	com/google/android/gms/clearcut/Counters$AbstractCounter:zzaJs	Lcom/google/android/gms/clearcut/Counters;
      //   162: invokestatic 129	com/google/android/gms/clearcut/Counters:zzc	(Lcom/google/android/gms/clearcut/Counters;)Ljava/util/concurrent/locks/ReentrantReadWriteLock;
      //   165: invokevirtual 155	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
      //   168: invokevirtual 191	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
      //   171: aload_3
      //   172: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	173	0	this	AbstractCounter
      //   0	173	1	paramLong	long
      //   157	15	3	localObject2	Object
      //   66	63	4	localObject3	Object
      //   150	5	4	localObject4	Object
      // Exception table:
      //   from	to	target	type
      //   20	32	150	finally
      //   47	68	150	finally
      //   73	75	150	finally
      //   90	106	150	finally
      //   111	113	150	finally
      //   133	135	150	finally
      //   152	154	150	finally
      //   13	20	157	finally
      //   154	157	157	finally
    }
    
    public String getName()
    {
      return this.mName;
    }
    
    protected void incrementBase(long paramLong)
    {
      incrementBase(paramLong, 1L);
    }
    
    /* Error */
    protected final void incrementBase(long paramLong1, long paramLong2)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore 6
      //   3: aload_0
      //   4: getfield 84	com/google/android/gms/clearcut/Counters$AbstractCounter:zzaJs	Lcom/google/android/gms/clearcut/Counters;
      //   7: invokestatic 129	com/google/android/gms/clearcut/Counters:zzc	(Lcom/google/android/gms/clearcut/Counters;)Ljava/util/concurrent/locks/ReentrantReadWriteLock;
      //   10: invokevirtual 155	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
      //   13: invokevirtual 158	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
      //   16: aload_0
      //   17: getfield 84	com/google/android/gms/clearcut/Counters$AbstractCounter:zzaJs	Lcom/google/android/gms/clearcut/Counters;
      //   20: invokestatic 167	com/google/android/gms/clearcut/Counters:zzd	(Lcom/google/android/gms/clearcut/Counters;)Ljava/lang/Integer;
      //   23: astore 7
      //   25: aload 7
      //   27: ifnonnull +61 -> 88
      //   30: iconst_1
      //   31: istore 5
      //   33: aload_0
      //   34: getfield 84	com/google/android/gms/clearcut/Counters$AbstractCounter:zzaJs	Lcom/google/android/gms/clearcut/Counters;
      //   37: invokestatic 129	com/google/android/gms/clearcut/Counters:zzc	(Lcom/google/android/gms/clearcut/Counters;)Ljava/util/concurrent/locks/ReentrantReadWriteLock;
      //   40: invokevirtual 155	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
      //   43: invokevirtual 191	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
      //   46: iload 5
      //   48: ifeq +11 -> 59
      //   51: aload_0
      //   52: lload_1
      //   53: lload_3
      //   54: invokespecial 200	com/google/android/gms/clearcut/Counters$AbstractCounter:zzc	(JJ)Z
      //   57: istore 6
      //   59: iload 6
      //   61: ifeq +26 -> 87
      //   64: aload_0
      //   65: getfield 84	com/google/android/gms/clearcut/Counters$AbstractCounter:zzaJs	Lcom/google/android/gms/clearcut/Counters;
      //   68: aconst_null
      //   69: invokevirtual 204	com/google/android/gms/clearcut/Counters:logAllAsync	(Lcom/google/android/gms/common/api/GoogleApiClient;)Lcom/google/android/gms/common/api/PendingResult;
      //   72: astore 7
      //   74: aload 7
      //   76: ifnull +11 -> 87
      //   79: aload 7
      //   81: invokestatic 208	com/google/android/gms/clearcut/Counters:zzwG	()Lcom/google/android/gms/common/api/ResultCallback;
      //   84: invokevirtual 214	com/google/android/gms/common/api/PendingResult:setResultCallback	(Lcom/google/android/gms/common/api/ResultCallback;)V
      //   87: return
      //   88: aload_0
      //   89: lload_1
      //   90: lload_3
      //   91: invokespecial 164	com/google/android/gms/clearcut/Counters$AbstractCounter:zzd	(JJ)Z
      //   94: istore 6
      //   96: iconst_0
      //   97: istore 5
      //   99: goto -66 -> 33
      //   102: astore 7
      //   104: aload_0
      //   105: getfield 84	com/google/android/gms/clearcut/Counters$AbstractCounter:zzaJs	Lcom/google/android/gms/clearcut/Counters;
      //   108: invokestatic 129	com/google/android/gms/clearcut/Counters:zzc	(Lcom/google/android/gms/clearcut/Counters;)Ljava/util/concurrent/locks/ReentrantReadWriteLock;
      //   111: invokevirtual 155	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
      //   114: invokevirtual 191	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
      //   117: aload 7
      //   119: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	120	0	this	AbstractCounter
      //   0	120	1	paramLong1	long
      //   0	120	3	paramLong2	long
      //   31	67	5	i	int
      //   1	94	6	bool	boolean
      //   23	57	7	localObject1	Object
      //   102	16	7	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   16	25	102	finally
      //   88	96	102	finally
    }
    
    public void setAutoLogAsyncThreshold(int paramInt)
    {
      boolean bool2 = true;
      if (paramInt > 0)
      {
        bool1 = true;
        zzac.zzaw(bool1);
        if (paramInt > Counters.zza(Counters.this)) {
          break label40;
        }
      }
      label40:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        zzac.zzaw(bool1);
        this.zzaJq = paramInt;
        return;
        bool1 = false;
        break;
      }
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AbstractCounter");
      localStringBuilder.append("(");
      localStringBuilder.append(this.mName);
      localStringBuilder.append(")[");
      for (;;)
      {
        synchronized (this.zzrU)
        {
          Iterator localIterator = this.zzaJr.entrySet().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          Object localObject3 = (Map.Entry)localIterator.next();
          localStringBuilder.append(((Map.Entry)localObject3).getKey());
          localStringBuilder.append(" -> [");
          localObject3 = ((Map)((Map.Entry)localObject3).getValue()).entrySet().iterator();
          if (((Iterator)localObject3).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
            localStringBuilder.append(localEntry.getKey());
            localStringBuilder.append(" = ");
            localStringBuilder.append(((long[])localEntry.getValue())[0]);
            localStringBuilder.append(", ");
          }
        }
        ((StringBuilder)localObject2).append("], ");
      }
      ((StringBuilder)localObject2).append("]");
      return ((StringBuilder)localObject2).toString();
    }
  }
  
  public static abstract interface Alias
  {
    public abstract long alias(long paramLong);
  }
  
  public class BooleanHistogram
    extends Counters.AbstractCounter
  {
    private BooleanHistogram(BooleanHistogram paramBooleanHistogram, boolean paramBoolean)
    {
      super(paramBooleanHistogram, paramBoolean);
    }
    
    private BooleanHistogram(String paramString)
    {
      super(paramString);
    }
    
    public long getCount(boolean paramBoolean)
    {
      if (paramBoolean) {}
      for (long l = 1L;; l = 0L) {
        return getCountBase(l);
      }
    }
    
    public void increment(boolean paramBoolean)
    {
      if (paramBoolean) {}
      for (long l = 1L;; l = 0L)
      {
        incrementBase(l);
        return;
      }
    }
  }
  
  public static class BucketAlias
    implements Counters.Alias
  {
    protected final int mAlias;
    
    public BucketAlias(int paramInt)
    {
      if (paramInt < 1) {
        throw new IllegalArgumentException(22 + "bad alias: " + paramInt);
      }
      this.mAlias = paramInt;
    }
    
    public long alias(long paramLong)
    {
      return this.mAlias * (paramLong / this.mAlias);
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof BucketAlias)) {
          return false;
        }
        paramObject = (BucketAlias)paramObject;
      } while (this.mAlias == ((BucketAlias)paramObject).mAlias);
      return false;
    }
  }
  
  public static class ClippedBucketAlias
    extends Counters.BucketAlias
  {
    private final long zzaJu;
    private final long zzaJv;
    
    public ClippedBucketAlias(int paramInt1, int paramInt2, int paramInt3)
    {
      super();
      this.zzaJu = paramInt2;
      this.zzaJv = paramInt3;
    }
    
    public long alias(long paramLong)
    {
      return super.alias(Math.max(Math.min(paramLong, this.zzaJv), this.zzaJu));
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof ClippedBucketAlias)) {
          return false;
        }
        paramObject = (ClippedBucketAlias)paramObject;
      } while (this.mAlias == ((ClippedBucketAlias)paramObject).mAlias);
      return false;
    }
  }
  
  public class Counter
    extends Counters.AbstractCounter
  {
    private Counter(Counter paramCounter, boolean paramBoolean)
    {
      super(paramCounter, paramBoolean);
    }
    
    private Counter(String paramString)
    {
      super(paramString);
    }
    
    public long getCount()
    {
      return getCountBase(0L);
    }
    
    public void increment()
    {
      incrementBy(1L);
    }
    
    public void incrementBy(long paramLong)
    {
      incrementBase(0L, paramLong);
    }
  }
  
  public class IntegerHistogram
    extends Counters.AbstractCounter
  {
    private IntegerHistogram(IntegerHistogram paramIntegerHistogram, boolean paramBoolean)
    {
      super(paramIntegerHistogram, paramBoolean);
    }
    
    private IntegerHistogram(String paramString)
    {
      super(paramString);
    }
    
    public long getCount(int paramInt)
    {
      return getCountBase(paramInt);
    }
    
    public void increment(int paramInt)
    {
      incrementBase(paramInt);
    }
  }
  
  public static abstract interface LogCallback
  {
    public abstract void onLogged(Counters paramCounters);
  }
  
  public class LongHistogram
    extends Counters.zza
  {
    private LongHistogram(LongHistogram paramLongHistogram, boolean paramBoolean)
    {
      super(paramLongHistogram, paramBoolean);
    }
    
    private LongHistogram(String paramString, Counters.Alias paramAlias)
    {
      super(paramString, paramAlias);
    }
    
    public long getCount(long paramLong)
    {
      return super.getCount(paramLong);
    }
    
    public void increment(long paramLong)
    {
      super.increment(paramLong);
    }
    
    public void incrementBy(long paramLong1, long paramLong2)
    {
      super.incrementBy(paramLong1, paramLong2);
    }
  }
  
  public final class Timer
  {
    private long zzaeN = Counters.zzh(Counters.this).elapsedRealtime();
    
    public Timer() {}
    
    public long getMilliseconds()
    {
      return Counters.zzh(Counters.this).elapsedRealtime() - this.zzaeN;
    }
    
    public void incrementTo(Counters.TimerHistogram paramTimerHistogram)
    {
      paramTimerHistogram.increment(getMilliseconds());
    }
    
    public long reset()
    {
      long l = this.zzaeN;
      this.zzaeN = Counters.zzh(Counters.this).elapsedRealtime();
      return l;
    }
  }
  
  public class TimerHistogram
    extends Counters.zza
  {
    private TimerHistogram(TimerHistogram paramTimerHistogram, boolean paramBoolean)
    {
      super(paramTimerHistogram, paramBoolean);
    }
    
    private TimerHistogram(String paramString, Counters.Alias paramAlias)
    {
      super(paramString, paramAlias);
    }
    
    public long getCount(long paramLong)
    {
      return super.getCount(paramLong);
    }
    
    public BoundTimer newTimer()
    {
      return new BoundTimer(this, null);
    }
    
    public class BoundTimer
    {
      private final Counters.TimerHistogram zzaJy;
      private long zzaeN;
      
      private BoundTimer(Counters.TimerHistogram paramTimerHistogram)
      {
        this.zzaJy = paramTimerHistogram;
        reset();
      }
      
      public long getMilliseconds()
      {
        return Counters.zzh(Counters.this).elapsedRealtime() - this.zzaeN;
      }
      
      public void incrementTo()
      {
        this.zzaJy.increment(getMilliseconds());
      }
      
      public void reset()
      {
        this.zzaeN = Counters.zzh(Counters.this).elapsedRealtime();
      }
    }
  }
  
  protected class zza
    extends Counters.AbstractCounter
  {
    final Counters.Alias zzaJt;
    
    protected zza(zza paramzza, boolean paramBoolean)
    {
      super(paramzza, paramBoolean);
      this.zzaJt = paramzza.zzaJt;
    }
    
    protected zza(String paramString, Counters.Alias paramAlias)
    {
      super(paramString);
      this.zzaJt = paramAlias;
    }
    
    private final long alias(long paramLong)
    {
      return this.zzaJt.alias(paramLong);
    }
    
    protected long getCount(long paramLong)
    {
      return getCountBase(alias(paramLong));
    }
    
    protected void increment(long paramLong)
    {
      incrementBase(alias(paramLong), 1L);
    }
    
    protected void incrementBy(long paramLong1, long paramLong2)
    {
      incrementBase(alias(paramLong1), paramLong2);
    }
  }
  
  class zzb
    implements ClearcutLogger.MessageProducer
  {
    private final byte[] zzaJj;
    private final Integer zzaJw;
    private final ArrayList<Counters.AbstractCounter> zzaJx;
    
    zzb(byte[] paramArrayOfByte)
    {
      this.zzaJj = paramArrayOfByte;
      this.zzaJw = ((Integer)Counters.this.zzaJl.get(this.zzaJj));
      this.zzaJx = zzc(this.zzaJw);
    }
    
    private ArrayList<Counters.AbstractCounter> zzc(Integer paramInteger)
    {
      ArrayList localArrayList = new ArrayList(Counters.zzb(Counters.this).size());
      Iterator localIterator = Counters.zzb(Counters.this).values().iterator();
      while (localIterator.hasNext())
      {
        Counters.AbstractCounter localAbstractCounter = (Counters.AbstractCounter)localIterator.next();
        if (localAbstractCounter.zzaJr.containsKey(paramInteger)) {
          localArrayList.add(localAbstractCounter);
        }
      }
      return localArrayList;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof zzb)) {
        return false;
      }
      paramObject = (zzb)paramObject;
      return zzwI().equals(((zzb)paramObject).zzwI());
    }
    
    public int hashCode()
    {
      return 1;
    }
    
    public byte[] toProtoBytes()
    {
      return zzcgg.zzf(zzwI());
    }
    
    public String toString()
    {
      return zzwI().toString();
    }
    
    public zzcgm.zzb zzb(Counters.AbstractCounter paramAbstractCounter)
    {
      Object localObject = (Map)paramAbstractCounter.zzaJr.get(this.zzaJw);
      zzcgm.zzb localzzb = new zzcgm.zzb();
      localzzb.Hh = zzcF(Counters.AbstractCounter.zza(paramAbstractCounter));
      localzzb.Hi = new zzcgm.zza[((Map)localObject).size()];
      paramAbstractCounter = ((Map)localObject).entrySet().iterator();
      int i = 0;
      while (paramAbstractCounter.hasNext())
      {
        localObject = (Map.Entry)paramAbstractCounter.next();
        zzcgm.zza localzza = new zzcgm.zza();
        localzza.He = ((Long)((Map.Entry)localObject).getKey()).longValue();
        localzza.Hf = ((long[])localObject.getValue())[0];
        localzzb.Hi[i] = localzza;
        i += 1;
      }
      return localzzb;
    }
    
    public long zzcF(String paramString)
    {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        localMessageDigest.update(paramString.getBytes(Counters.zzwH()));
        long l = ByteBuffer.wrap(localMessageDigest.digest()).getLong();
        return l;
      }
      catch (NoSuchAlgorithmException paramString)
      {
        throw new RuntimeException(paramString);
      }
    }
    
    public zzcgm.zzc zzwI()
    {
      zzcgm.zzc localzzc = new zzcgm.zzc();
      localzzc.Hj = Counters.zzg(Counters.this);
      if (this.zzaJj != null) {
        localzzc.Hl = this.zzaJj;
      }
      localzzc.Hk = new zzcgm.zzb[this.zzaJx.size()];
      Iterator localIterator = this.zzaJx.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        Counters.AbstractCounter localAbstractCounter = (Counters.AbstractCounter)localIterator.next();
        localzzc.Hk[i] = zzb(localAbstractCounter);
        i += 1;
      }
      return localzzc;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/clearcut/Counters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */