package com.google.common.cache;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public final class CacheBuilderSpec
{
  private static final Splitter KEYS_SPLITTER = Splitter.on(',').trimResults();
  private static final Splitter KEY_VALUE_SPLITTER = Splitter.on('=').trimResults();
  private static final ImmutableMap<String, ValueParser> VALUE_PARSERS = ImmutableMap.builder().put("initialCapacity", new InitialCapacityParser()).put("maximumSize", new MaximumSizeParser()).put("maximumWeight", new MaximumWeightParser()).put("concurrencyLevel", new ConcurrencyLevelParser()).put("weakKeys", new KeyStrengthParser(LocalCache.Strength.WEAK)).put("softValues", new ValueStrengthParser(LocalCache.Strength.SOFT)).put("weakValues", new ValueStrengthParser(LocalCache.Strength.WEAK)).put("recordStats", new RecordStatsParser()).put("expireAfterAccess", new AccessDurationParser()).put("expireAfterWrite", new WriteDurationParser()).put("refreshAfterWrite", new RefreshDurationParser()).put("refreshInterval", new RefreshDurationParser()).build();
  @VisibleForTesting
  long accessExpirationDuration;
  @VisibleForTesting
  TimeUnit accessExpirationTimeUnit;
  @VisibleForTesting
  Integer concurrencyLevel;
  @VisibleForTesting
  Integer initialCapacity;
  @VisibleForTesting
  LocalCache.Strength keyStrength;
  @VisibleForTesting
  Long maximumSize;
  @VisibleForTesting
  Long maximumWeight;
  @VisibleForTesting
  Boolean recordStats;
  @VisibleForTesting
  long refreshDuration;
  @VisibleForTesting
  TimeUnit refreshTimeUnit;
  private final String specification;
  @VisibleForTesting
  LocalCache.Strength valueStrength;
  @VisibleForTesting
  long writeExpirationDuration;
  @VisibleForTesting
  TimeUnit writeExpirationTimeUnit;
  
  private CacheBuilderSpec(String paramString)
  {
    this.specification = paramString;
  }
  
  public static CacheBuilderSpec disableCaching()
  {
    return parse("maximumSize=0");
  }
  
  @Nullable
  private static Long durationInNanos(long paramLong, @Nullable TimeUnit paramTimeUnit)
  {
    if (paramTimeUnit == null) {
      return null;
    }
    return Long.valueOf(paramTimeUnit.toNanos(paramLong));
  }
  
  private static String format(String paramString, Object... paramVarArgs)
  {
    return String.format(Locale.ROOT, paramString, paramVarArgs);
  }
  
  public static CacheBuilderSpec parse(String paramString)
  {
    CacheBuilderSpec localCacheBuilderSpec = new CacheBuilderSpec(paramString);
    if (!paramString.isEmpty())
    {
      Iterator localIterator = KEYS_SPLITTER.split(paramString).iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramString = ImmutableList.copyOf(KEY_VALUE_SPLITTER.split(str));
        boolean bool;
        label72:
        label90:
        ValueParser localValueParser;
        if (!paramString.isEmpty())
        {
          bool = true;
          Preconditions.checkArgument(bool, "blank key-value pair");
          if (paramString.size() > 2) {
            break label184;
          }
          bool = true;
          Preconditions.checkArgument(bool, "key-value pair %s with more than one equals sign", new Object[] { str });
          str = (String)paramString.get(0);
          localValueParser = (ValueParser)VALUE_PARSERS.get(str);
          if (localValueParser == null) {
            break label189;
          }
          bool = true;
          label137:
          Preconditions.checkArgument(bool, "unknown key %s", new Object[] { str });
          if (paramString.size() != 1) {
            break label194;
          }
        }
        label184:
        label189:
        label194:
        for (paramString = null;; paramString = (String)paramString.get(1))
        {
          localValueParser.parse(localCacheBuilderSpec, str, paramString);
          break;
          bool = false;
          break label72;
          bool = false;
          break label90;
          bool = false;
          break label137;
        }
      }
    }
    return localCacheBuilderSpec;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof CacheBuilderSpec)) {
        return false;
      }
      paramObject = (CacheBuilderSpec)paramObject;
    } while ((Objects.equal(this.initialCapacity, ((CacheBuilderSpec)paramObject).initialCapacity)) && (Objects.equal(this.maximumSize, ((CacheBuilderSpec)paramObject).maximumSize)) && (Objects.equal(this.maximumWeight, ((CacheBuilderSpec)paramObject).maximumWeight)) && (Objects.equal(this.concurrencyLevel, ((CacheBuilderSpec)paramObject).concurrencyLevel)) && (Objects.equal(this.keyStrength, ((CacheBuilderSpec)paramObject).keyStrength)) && (Objects.equal(this.valueStrength, ((CacheBuilderSpec)paramObject).valueStrength)) && (Objects.equal(this.recordStats, ((CacheBuilderSpec)paramObject).recordStats)) && (Objects.equal(durationInNanos(this.writeExpirationDuration, this.writeExpirationTimeUnit), durationInNanos(((CacheBuilderSpec)paramObject).writeExpirationDuration, ((CacheBuilderSpec)paramObject).writeExpirationTimeUnit))) && (Objects.equal(durationInNanos(this.accessExpirationDuration, this.accessExpirationTimeUnit), durationInNanos(((CacheBuilderSpec)paramObject).accessExpirationDuration, ((CacheBuilderSpec)paramObject).accessExpirationTimeUnit))) && (Objects.equal(durationInNanos(this.refreshDuration, this.refreshTimeUnit), durationInNanos(((CacheBuilderSpec)paramObject).refreshDuration, ((CacheBuilderSpec)paramObject).refreshTimeUnit))));
    return false;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { this.initialCapacity, this.maximumSize, this.maximumWeight, this.concurrencyLevel, this.keyStrength, this.valueStrength, this.recordStats, durationInNanos(this.writeExpirationDuration, this.writeExpirationTimeUnit), durationInNanos(this.accessExpirationDuration, this.accessExpirationTimeUnit), durationInNanos(this.refreshDuration, this.refreshTimeUnit) });
  }
  
  CacheBuilder<Object, Object> toCacheBuilder()
  {
    CacheBuilder localCacheBuilder = CacheBuilder.newBuilder();
    if (this.initialCapacity != null) {
      localCacheBuilder.initialCapacity(this.initialCapacity.intValue());
    }
    if (this.maximumSize != null) {
      localCacheBuilder.maximumSize(this.maximumSize.longValue());
    }
    if (this.maximumWeight != null) {
      localCacheBuilder.maximumWeight(this.maximumWeight.longValue());
    }
    if (this.concurrencyLevel != null) {
      localCacheBuilder.concurrencyLevel(this.concurrencyLevel.intValue());
    }
    if (this.keyStrength != null)
    {
      switch (this.keyStrength)
      {
      default: 
        throw new AssertionError();
      }
      localCacheBuilder.weakKeys();
    }
    if (this.valueStrength != null) {
      switch (this.valueStrength)
      {
      default: 
        throw new AssertionError();
      case ???: 
        localCacheBuilder.softValues();
      }
    }
    for (;;)
    {
      if ((this.recordStats != null) && (this.recordStats.booleanValue())) {
        localCacheBuilder.recordStats();
      }
      if (this.writeExpirationTimeUnit != null) {
        localCacheBuilder.expireAfterWrite(this.writeExpirationDuration, this.writeExpirationTimeUnit);
      }
      if (this.accessExpirationTimeUnit != null) {
        localCacheBuilder.expireAfterAccess(this.accessExpirationDuration, this.accessExpirationTimeUnit);
      }
      if (this.refreshTimeUnit != null) {
        localCacheBuilder.refreshAfterWrite(this.refreshDuration, this.refreshTimeUnit);
      }
      return localCacheBuilder;
      localCacheBuilder.weakValues();
    }
  }
  
  public String toParsableString()
  {
    return this.specification;
  }
  
  public String toString()
  {
    return MoreObjects.toStringHelper(this).addValue(toParsableString()).toString();
  }
  
  static class AccessDurationParser
    extends CacheBuilderSpec.DurationParser
  {
    protected void parseDuration(CacheBuilderSpec paramCacheBuilderSpec, long paramLong, TimeUnit paramTimeUnit)
    {
      if (paramCacheBuilderSpec.accessExpirationTimeUnit == null) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "expireAfterAccess already set");
        paramCacheBuilderSpec.accessExpirationDuration = paramLong;
        paramCacheBuilderSpec.accessExpirationTimeUnit = paramTimeUnit;
        return;
      }
    }
  }
  
  static class ConcurrencyLevelParser
    extends CacheBuilderSpec.IntegerParser
  {
    protected void parseInteger(CacheBuilderSpec paramCacheBuilderSpec, int paramInt)
    {
      if (paramCacheBuilderSpec.concurrencyLevel == null) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "concurrency level was already set to ", new Object[] { paramCacheBuilderSpec.concurrencyLevel });
        paramCacheBuilderSpec.concurrencyLevel = Integer.valueOf(paramInt);
        return;
      }
    }
  }
  
  static abstract class DurationParser
    implements CacheBuilderSpec.ValueParser
  {
    public void parse(CacheBuilderSpec paramCacheBuilderSpec, String paramString1, String paramString2)
    {
      boolean bool;
      if ((paramString2 != null) && (!paramString2.isEmpty()))
      {
        bool = true;
        Preconditions.checkArgument(bool, "value of key %s omitted", new Object[] { paramString1 });
      }
      for (;;)
      {
        try
        {
          switch (paramString2.charAt(paramString2.length() - 1))
          {
          case 'd': 
            throw new IllegalArgumentException(CacheBuilderSpec.format("key %s invalid format.  was %s, must end with one of [dDhHmMsS]", new Object[] { paramString1, paramString2 }));
          }
        }
        catch (NumberFormatException paramCacheBuilderSpec)
        {
          throw new IllegalArgumentException(CacheBuilderSpec.format("key %s value set to %s, must be integer", new Object[] { paramString1, paramString2 }));
        }
        bool = false;
        break;
        TimeUnit localTimeUnit = TimeUnit.DAYS;
        for (;;)
        {
          parseDuration(paramCacheBuilderSpec, Long.parseLong(paramString2.substring(0, paramString2.length() - 1)), localTimeUnit);
          return;
          localTimeUnit = TimeUnit.HOURS;
          continue;
          localTimeUnit = TimeUnit.MINUTES;
          continue;
          localTimeUnit = TimeUnit.SECONDS;
        }
      }
    }
    
    protected abstract void parseDuration(CacheBuilderSpec paramCacheBuilderSpec, long paramLong, TimeUnit paramTimeUnit);
  }
  
  static class InitialCapacityParser
    extends CacheBuilderSpec.IntegerParser
  {
    protected void parseInteger(CacheBuilderSpec paramCacheBuilderSpec, int paramInt)
    {
      if (paramCacheBuilderSpec.initialCapacity == null) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "initial capacity was already set to ", new Object[] { paramCacheBuilderSpec.initialCapacity });
        paramCacheBuilderSpec.initialCapacity = Integer.valueOf(paramInt);
        return;
      }
    }
  }
  
  static abstract class IntegerParser
    implements CacheBuilderSpec.ValueParser
  {
    public void parse(CacheBuilderSpec paramCacheBuilderSpec, String paramString1, String paramString2)
    {
      if ((paramString2 != null) && (!paramString2.isEmpty())) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "value of key %s omitted", new Object[] { paramString1 });
        try
        {
          parseInteger(paramCacheBuilderSpec, Integer.parseInt(paramString2));
          return;
        }
        catch (NumberFormatException paramCacheBuilderSpec)
        {
          throw new IllegalArgumentException(CacheBuilderSpec.format("key %s value set to %s, must be integer", new Object[] { paramString1, paramString2 }), paramCacheBuilderSpec);
        }
      }
    }
    
    protected abstract void parseInteger(CacheBuilderSpec paramCacheBuilderSpec, int paramInt);
  }
  
  static class KeyStrengthParser
    implements CacheBuilderSpec.ValueParser
  {
    private final LocalCache.Strength strength;
    
    public KeyStrengthParser(LocalCache.Strength paramStrength)
    {
      this.strength = paramStrength;
    }
    
    public void parse(CacheBuilderSpec paramCacheBuilderSpec, String paramString1, @Nullable String paramString2)
    {
      if (paramString2 == null)
      {
        bool = true;
        Preconditions.checkArgument(bool, "key %s does not take values", new Object[] { paramString1 });
        if (paramCacheBuilderSpec.keyStrength != null) {
          break label69;
        }
      }
      label69:
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "%s was already set to %s", new Object[] { paramString1, paramCacheBuilderSpec.keyStrength });
        paramCacheBuilderSpec.keyStrength = this.strength;
        return;
        bool = false;
        break;
      }
    }
  }
  
  static abstract class LongParser
    implements CacheBuilderSpec.ValueParser
  {
    public void parse(CacheBuilderSpec paramCacheBuilderSpec, String paramString1, String paramString2)
    {
      if ((paramString2 != null) && (!paramString2.isEmpty())) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "value of key %s omitted", new Object[] { paramString1 });
        try
        {
          parseLong(paramCacheBuilderSpec, Long.parseLong(paramString2));
          return;
        }
        catch (NumberFormatException paramCacheBuilderSpec)
        {
          throw new IllegalArgumentException(CacheBuilderSpec.format("key %s value set to %s, must be integer", new Object[] { paramString1, paramString2 }), paramCacheBuilderSpec);
        }
      }
    }
    
    protected abstract void parseLong(CacheBuilderSpec paramCacheBuilderSpec, long paramLong);
  }
  
  static class MaximumSizeParser
    extends CacheBuilderSpec.LongParser
  {
    protected void parseLong(CacheBuilderSpec paramCacheBuilderSpec, long paramLong)
    {
      if (paramCacheBuilderSpec.maximumSize == null)
      {
        bool = true;
        Preconditions.checkArgument(bool, "maximum size was already set to ", new Object[] { paramCacheBuilderSpec.maximumSize });
        if (paramCacheBuilderSpec.maximumWeight != null) {
          break label71;
        }
      }
      label71:
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "maximum weight was already set to ", new Object[] { paramCacheBuilderSpec.maximumWeight });
        paramCacheBuilderSpec.maximumSize = Long.valueOf(paramLong);
        return;
        bool = false;
        break;
      }
    }
  }
  
  static class MaximumWeightParser
    extends CacheBuilderSpec.LongParser
  {
    protected void parseLong(CacheBuilderSpec paramCacheBuilderSpec, long paramLong)
    {
      if (paramCacheBuilderSpec.maximumWeight == null)
      {
        bool = true;
        Preconditions.checkArgument(bool, "maximum weight was already set to ", new Object[] { paramCacheBuilderSpec.maximumWeight });
        if (paramCacheBuilderSpec.maximumSize != null) {
          break label71;
        }
      }
      label71:
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "maximum size was already set to ", new Object[] { paramCacheBuilderSpec.maximumSize });
        paramCacheBuilderSpec.maximumWeight = Long.valueOf(paramLong);
        return;
        bool = false;
        break;
      }
    }
  }
  
  static class RecordStatsParser
    implements CacheBuilderSpec.ValueParser
  {
    public void parse(CacheBuilderSpec paramCacheBuilderSpec, String paramString1, @Nullable String paramString2)
    {
      boolean bool2 = false;
      if (paramString2 == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        Preconditions.checkArgument(bool1, "recordStats does not take values");
        bool1 = bool2;
        if (paramCacheBuilderSpec.recordStats == null) {
          bool1 = true;
        }
        Preconditions.checkArgument(bool1, "recordStats already set");
        paramCacheBuilderSpec.recordStats = Boolean.valueOf(true);
        return;
      }
    }
  }
  
  static class RefreshDurationParser
    extends CacheBuilderSpec.DurationParser
  {
    protected void parseDuration(CacheBuilderSpec paramCacheBuilderSpec, long paramLong, TimeUnit paramTimeUnit)
    {
      if (paramCacheBuilderSpec.refreshTimeUnit == null) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "refreshAfterWrite already set");
        paramCacheBuilderSpec.refreshDuration = paramLong;
        paramCacheBuilderSpec.refreshTimeUnit = paramTimeUnit;
        return;
      }
    }
  }
  
  private static abstract interface ValueParser
  {
    public abstract void parse(CacheBuilderSpec paramCacheBuilderSpec, String paramString1, @Nullable String paramString2);
  }
  
  static class ValueStrengthParser
    implements CacheBuilderSpec.ValueParser
  {
    private final LocalCache.Strength strength;
    
    public ValueStrengthParser(LocalCache.Strength paramStrength)
    {
      this.strength = paramStrength;
    }
    
    public void parse(CacheBuilderSpec paramCacheBuilderSpec, String paramString1, @Nullable String paramString2)
    {
      if (paramString2 == null)
      {
        bool = true;
        Preconditions.checkArgument(bool, "key %s does not take values", new Object[] { paramString1 });
        if (paramCacheBuilderSpec.valueStrength != null) {
          break label69;
        }
      }
      label69:
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "%s was already set to %s", new Object[] { paramString1, paramCacheBuilderSpec.valueStrength });
        paramCacheBuilderSpec.valueStrength = this.strength;
        return;
        bool = false;
        break;
      }
    }
  }
  
  static class WriteDurationParser
    extends CacheBuilderSpec.DurationParser
  {
    protected void parseDuration(CacheBuilderSpec paramCacheBuilderSpec, long paramLong, TimeUnit paramTimeUnit)
    {
      if (paramCacheBuilderSpec.writeExpirationTimeUnit == null) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "expireAfterWrite already set");
        paramCacheBuilderSpec.writeExpirationDuration = paramLong;
        paramCacheBuilderSpec.writeExpirationTimeUnit = paramTimeUnit;
        return;
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/cache/CacheBuilderSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */