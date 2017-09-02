package io.grpc;

import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.base.Preconditions;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public final class CallOptions
{
  public static final CallOptions DEFAULT = new CallOptions();
  private Attributes affinity = Attributes.EMPTY;
  @Nullable
  private String authority;
  @Nullable
  private String compressorName;
  @Nullable
  private CallCredentials credentials;
  private Object[][] customOptions = (Object[][])Array.newInstance(Object.class, new int[] { 0, 2 });
  private Deadline deadline;
  private Executor executor;
  @Nullable
  private Integer maxInboundMessageSize;
  @Nullable
  private Integer maxOutboundMessageSize;
  private boolean waitForReady;
  
  private CallOptions() {}
  
  private CallOptions(CallOptions paramCallOptions)
  {
    this.deadline = paramCallOptions.deadline;
    this.authority = paramCallOptions.authority;
    this.credentials = paramCallOptions.credentials;
    this.affinity = paramCallOptions.affinity;
    this.executor = paramCallOptions.executor;
    this.compressorName = paramCallOptions.compressorName;
    this.customOptions = paramCallOptions.customOptions;
    this.waitForReady = paramCallOptions.waitForReady;
    this.maxInboundMessageSize = paramCallOptions.maxInboundMessageSize;
    this.maxOutboundMessageSize = paramCallOptions.maxOutboundMessageSize;
  }
  
  public Attributes getAffinity()
  {
    return this.affinity;
  }
  
  @Nullable
  public String getAuthority()
  {
    return this.authority;
  }
  
  @Nullable
  public String getCompressor()
  {
    return this.compressorName;
  }
  
  @Nullable
  public CallCredentials getCredentials()
  {
    return this.credentials;
  }
  
  @Nullable
  public Deadline getDeadline()
  {
    return this.deadline;
  }
  
  @Nullable
  public Executor getExecutor()
  {
    return this.executor;
  }
  
  @Nullable
  public Integer getMaxInboundMessageSize()
  {
    return this.maxInboundMessageSize;
  }
  
  @Nullable
  public Integer getMaxOutboundMessageSize()
  {
    return this.maxOutboundMessageSize;
  }
  
  public <T> T getOption(Key<T> paramKey)
  {
    Preconditions.checkNotNull(paramKey, "key");
    int i = 0;
    while (i < this.customOptions.length)
    {
      if (paramKey.equals(this.customOptions[i][0])) {
        return (T)this.customOptions[i][1];
      }
      i += 1;
    }
    return (T)paramKey.defaultValue;
  }
  
  public boolean isWaitForReady()
  {
    return this.waitForReady;
  }
  
  public String toString()
  {
    MoreObjects.ToStringHelper localToStringHelper = MoreObjects.toStringHelper(this).add("deadline", this.deadline).add("authority", this.authority).add("callCredentials", this.credentials).add("affinity", this.affinity);
    if (this.executor != null) {}
    for (Class localClass = this.executor.getClass();; localClass = null) {
      return localToStringHelper.add("executor", localClass).add("compressorName", this.compressorName).add("customOptions", Arrays.deepToString(this.customOptions)).add("waitForReady", isWaitForReady()).add("maxInboundMessageSize", this.maxInboundMessageSize).add("maxOutboundMessageSize", this.maxOutboundMessageSize).toString();
    }
  }
  
  public CallOptions withAffinity(Attributes paramAttributes)
  {
    CallOptions localCallOptions = new CallOptions(this);
    localCallOptions.affinity = ((Attributes)Preconditions.checkNotNull(paramAttributes, "affinity"));
    return localCallOptions;
  }
  
  public CallOptions withAuthority(@Nullable String paramString)
  {
    CallOptions localCallOptions = new CallOptions(this);
    localCallOptions.authority = paramString;
    return localCallOptions;
  }
  
  public CallOptions withCallCredentials(@Nullable CallCredentials paramCallCredentials)
  {
    CallOptions localCallOptions = new CallOptions(this);
    localCallOptions.credentials = paramCallCredentials;
    return localCallOptions;
  }
  
  public CallOptions withCompression(@Nullable String paramString)
  {
    CallOptions localCallOptions = new CallOptions(this);
    localCallOptions.compressorName = paramString;
    return localCallOptions;
  }
  
  public CallOptions withDeadline(@Nullable Deadline paramDeadline)
  {
    CallOptions localCallOptions = new CallOptions(this);
    localCallOptions.deadline = paramDeadline;
    return localCallOptions;
  }
  
  public CallOptions withDeadlineAfter(long paramLong, TimeUnit paramTimeUnit)
  {
    return withDeadline(Deadline.after(paramLong, paramTimeUnit));
  }
  
  public CallOptions withExecutor(Executor paramExecutor)
  {
    CallOptions localCallOptions = new CallOptions(this);
    localCallOptions.executor = paramExecutor;
    return localCallOptions;
  }
  
  public CallOptions withMaxInboundMessageSize(int paramInt)
  {
    if (paramInt >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "invalid maxsize %s", new Object[] { Integer.valueOf(paramInt) });
      CallOptions localCallOptions = new CallOptions(this);
      localCallOptions.maxInboundMessageSize = Integer.valueOf(paramInt);
      return localCallOptions;
    }
  }
  
  public CallOptions withMaxOutboundMessageSize(int paramInt)
  {
    if (paramInt >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "invalid maxsize %s", new Object[] { Integer.valueOf(paramInt) });
      CallOptions localCallOptions = new CallOptions(this);
      localCallOptions.maxOutboundMessageSize = Integer.valueOf(paramInt);
      return localCallOptions;
    }
  }
  
  public <T> CallOptions withOption(Key<T> paramKey, T paramT)
  {
    Preconditions.checkNotNull(paramKey, "key");
    Preconditions.checkNotNull(paramT, "value");
    CallOptions localCallOptions = new CallOptions(this);
    int k = -1;
    int i = 0;
    int j = k;
    if (i < this.customOptions.length)
    {
      if (paramKey.equals(this.customOptions[i][0])) {
        j = i;
      }
    }
    else
    {
      k = this.customOptions.length;
      if (j != -1) {
        break label160;
      }
    }
    label160:
    for (i = 1;; i = 0)
    {
      localCallOptions.customOptions = ((Object[][])Array.newInstance(Object.class, new int[] { i + k, 2 }));
      System.arraycopy(this.customOptions, 0, localCallOptions.customOptions, 0, this.customOptions.length);
      if (j != -1) {
        break label165;
      }
      localCallOptions.customOptions[this.customOptions.length] = { paramKey, paramT };
      return localCallOptions;
      i += 1;
      break;
    }
    label165:
    localCallOptions.customOptions[j][1] = paramT;
    return localCallOptions;
  }
  
  public CallOptions withWaitForReady()
  {
    CallOptions localCallOptions = new CallOptions(this);
    localCallOptions.waitForReady = true;
    return localCallOptions;
  }
  
  public CallOptions withoutWaitForReady()
  {
    CallOptions localCallOptions = new CallOptions(this);
    localCallOptions.waitForReady = false;
    return localCallOptions;
  }
  
  public static final class Key<T>
  {
    private final T defaultValue;
    private final String name;
    
    private Key(String paramString, T paramT)
    {
      this.name = paramString;
      this.defaultValue = paramT;
    }
    
    public static <T> Key<T> of(String paramString, T paramT)
    {
      Preconditions.checkNotNull(paramString, "name");
      return new Key(paramString, paramT);
    }
    
    public T getDefault()
    {
      return (T)this.defaultValue;
    }
    
    public String toString()
    {
      return this.name;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/CallOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */