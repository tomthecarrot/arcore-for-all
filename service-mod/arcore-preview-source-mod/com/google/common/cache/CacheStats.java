package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

@GwtCompatible
public final class CacheStats
{
  private final long evictionCount;
  private final long hitCount;
  private final long loadExceptionCount;
  private final long loadSuccessCount;
  private final long missCount;
  private final long totalLoadTime;
  
  public CacheStats(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6)
  {
    if (paramLong1 >= 0L)
    {
      bool = true;
      Preconditions.checkArgument(bool);
      if (paramLong2 < 0L) {
        break label133;
      }
      bool = true;
      label27:
      Preconditions.checkArgument(bool);
      if (paramLong3 < 0L) {
        break label139;
      }
      bool = true;
      label42:
      Preconditions.checkArgument(bool);
      if (paramLong4 < 0L) {
        break label145;
      }
      bool = true;
      label57:
      Preconditions.checkArgument(bool);
      if (paramLong5 < 0L) {
        break label151;
      }
      bool = true;
      label72:
      Preconditions.checkArgument(bool);
      if (paramLong6 < 0L) {
        break label157;
      }
    }
    label133:
    label139:
    label145:
    label151:
    label157:
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      this.hitCount = paramLong1;
      this.missCount = paramLong2;
      this.loadSuccessCount = paramLong3;
      this.loadExceptionCount = paramLong4;
      this.totalLoadTime = paramLong5;
      this.evictionCount = paramLong6;
      return;
      bool = false;
      break;
      bool = false;
      break label27;
      bool = false;
      break label42;
      bool = false;
      break label57;
      bool = false;
      break label72;
    }
  }
  
  public double averageLoadPenalty()
  {
    long l = this.loadSuccessCount + this.loadExceptionCount;
    if (l == 0L) {
      return 0.0D;
    }
    return this.totalLoadTime / l;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof CacheStats))
    {
      paramObject = (CacheStats)paramObject;
      bool1 = bool2;
      if (this.hitCount == ((CacheStats)paramObject).hitCount)
      {
        bool1 = bool2;
        if (this.missCount == ((CacheStats)paramObject).missCount)
        {
          bool1 = bool2;
          if (this.loadSuccessCount == ((CacheStats)paramObject).loadSuccessCount)
          {
            bool1 = bool2;
            if (this.loadExceptionCount == ((CacheStats)paramObject).loadExceptionCount)
            {
              bool1 = bool2;
              if (this.totalLoadTime == ((CacheStats)paramObject).totalLoadTime)
              {
                bool1 = bool2;
                if (this.evictionCount == ((CacheStats)paramObject).evictionCount) {
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public long evictionCount()
  {
    return this.evictionCount;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { Long.valueOf(this.hitCount), Long.valueOf(this.missCount), Long.valueOf(this.loadSuccessCount), Long.valueOf(this.loadExceptionCount), Long.valueOf(this.totalLoadTime), Long.valueOf(this.evictionCount) });
  }
  
  public long hitCount()
  {
    return this.hitCount;
  }
  
  public double hitRate()
  {
    long l = requestCount();
    if (l == 0L) {
      return 1.0D;
    }
    return this.hitCount / l;
  }
  
  public long loadCount()
  {
    return this.loadSuccessCount + this.loadExceptionCount;
  }
  
  public long loadExceptionCount()
  {
    return this.loadExceptionCount;
  }
  
  public double loadExceptionRate()
  {
    long l = this.loadSuccessCount + this.loadExceptionCount;
    if (l == 0L) {
      return 0.0D;
    }
    return this.loadExceptionCount / l;
  }
  
  public long loadSuccessCount()
  {
    return this.loadSuccessCount;
  }
  
  public CacheStats minus(CacheStats paramCacheStats)
  {
    return new CacheStats(Math.max(0L, this.hitCount - paramCacheStats.hitCount), Math.max(0L, this.missCount - paramCacheStats.missCount), Math.max(0L, this.loadSuccessCount - paramCacheStats.loadSuccessCount), Math.max(0L, this.loadExceptionCount - paramCacheStats.loadExceptionCount), Math.max(0L, this.totalLoadTime - paramCacheStats.totalLoadTime), Math.max(0L, this.evictionCount - paramCacheStats.evictionCount));
  }
  
  public long missCount()
  {
    return this.missCount;
  }
  
  public double missRate()
  {
    long l = requestCount();
    if (l == 0L) {
      return 0.0D;
    }
    return this.missCount / l;
  }
  
  public CacheStats plus(CacheStats paramCacheStats)
  {
    return new CacheStats(this.hitCount + paramCacheStats.hitCount, this.missCount + paramCacheStats.missCount, this.loadSuccessCount + paramCacheStats.loadSuccessCount, this.loadExceptionCount + paramCacheStats.loadExceptionCount, this.totalLoadTime + paramCacheStats.totalLoadTime, this.evictionCount + paramCacheStats.evictionCount);
  }
  
  public long requestCount()
  {
    return this.hitCount + this.missCount;
  }
  
  public String toString()
  {
    return MoreObjects.toStringHelper(this).add("hitCount", this.hitCount).add("missCount", this.missCount).add("loadSuccessCount", this.loadSuccessCount).add("loadExceptionCount", this.loadExceptionCount).add("totalLoadTime", this.totalLoadTime).add("evictionCount", this.evictionCount).toString();
  }
  
  public long totalLoadTime()
  {
    return this.totalLoadTime;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/cache/CacheStats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */