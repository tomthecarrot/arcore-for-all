package io.grpc;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Context
{
  private static final Key<Deadline> DEADLINE_KEY;
  private static final Object[][] EMPTY_ENTRIES;
  public static final Context ROOT;
  private static final Logger log = Logger.getLogger(Context.class.getName());
  private static final Storage storage;
  private static final Exception storageInitError;
  private final boolean canBeCancelled;
  private final boolean cascadesCancellation;
  private final Object[][] keyValueEntries;
  private ArrayList<ExecutableListener> listeners;
  private final Context parent;
  private CancellationListener parentListener = new ParentListener(null);
  
  static
  {
    EMPTY_ENTRIES = (Object[][])Array.newInstance(Object.class, new int[] { 0, 2 });
    DEADLINE_KEY = new Key("deadline");
    ROOT = new Context(null);
    Object localObject = null;
    Exception localException1 = null;
    try
    {
      Storage localStorage = (Storage)Class.forName("io.grpc.override.ContextStorageOverride").getConstructor(new Class[0]).newInstance(new Object[0]);
      localObject = localStorage;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        if (log.isLoggable(Level.FINE))
        {
          System.err.println("io.grpc.Context: Storage override doesn't exist. Using default.");
          localClassNotFoundException.printStackTrace();
        }
        ThreadLocalContextStorage localThreadLocalContextStorage = new ThreadLocalContextStorage();
      }
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
    storage = (Storage)localObject;
    storageInitError = localException1;
  }
  
  private Context(Context paramContext)
  {
    this.parent = paramContext;
    this.keyValueEntries = new Object[][] { { DEADLINE_KEY, null } };
    this.cascadesCancellation = false;
    this.canBeCancelled = false;
  }
  
  private Context(Context paramContext, Object[][] paramArrayOfObject)
  {
    this.parent = paramContext;
    this.keyValueEntries = paramArrayOfObject;
    this.cascadesCancellation = true;
    if ((this.parent != null) && (this.parent.canBeCancelled)) {}
    for (;;)
    {
      this.canBeCancelled = bool;
      return;
      bool = false;
    }
  }
  
  private Context(Context paramContext, Object[][] paramArrayOfObject, boolean paramBoolean)
  {
    this.parent = paramContext;
    this.keyValueEntries = paramArrayOfObject;
    this.cascadesCancellation = true;
    this.canBeCancelled = paramBoolean;
  }
  
  private static <T> T checkNotNull(T paramT, Object paramObject)
  {
    if (paramT == null) {
      throw new NullPointerException(String.valueOf(paramObject));
    }
    return paramT;
  }
  
  public static Context current()
  {
    Context localContext2 = storage().current();
    Context localContext1 = localContext2;
    if (localContext2 == null) {
      localContext1 = ROOT;
    }
    return localContext1;
  }
  
  public static Executor currentContextExecutor(Executor paramExecutor)
  {
    new Executor()
    {
      public void execute(Runnable paramAnonymousRunnable)
      {
        this.val$e.execute(Context.current().wrap(paramAnonymousRunnable));
      }
    };
  }
  
  public static <T> Key<T> key(String paramString)
  {
    return new Key(paramString);
  }
  
  public static <T> Key<T> keyWithDefault(String paramString, T paramT)
  {
    return new Key(paramString, paramT);
  }
  
  private Object lookup(Key<?> paramKey)
  {
    int i = 0;
    while (i < this.keyValueEntries.length)
    {
      if (paramKey.equals(this.keyValueEntries[i][0])) {
        return this.keyValueEntries[i][1];
      }
      i += 1;
    }
    if (this.parent == null) {
      return null;
    }
    return this.parent.lookup(paramKey);
  }
  
  static Storage storage()
  {
    if (storage == null) {
      throw new RuntimeException("Storage override had failed to initialize", storageInitError);
    }
    return storage;
  }
  
  public void addListener(CancellationListener paramCancellationListener, Executor paramExecutor)
  {
    checkNotNull(paramCancellationListener, "cancellationListener");
    checkNotNull(paramExecutor, "executor");
    if (this.canBeCancelled)
    {
      paramCancellationListener = new ExecutableListener(paramExecutor, paramCancellationListener, null);
      for (;;)
      {
        try
        {
          if (isCancelled())
          {
            paramCancellationListener.deliver();
            return;
          }
          if (this.listeners == null)
          {
            this.listeners = new ArrayList();
            this.listeners.add(paramCancellationListener);
            this.parent.addListener(this.parentListener, DirectExecutor.INSTANCE);
          }
          else
          {
            this.listeners.add(paramCancellationListener);
          }
        }
        finally {}
      }
    }
  }
  
  public Context attach()
  {
    Context localContext = current();
    storage().attach(this);
    return localContext;
  }
  
  public <V> V call(Callable<V> paramCallable)
    throws Exception
  {
    Context localContext = attach();
    try
    {
      paramCallable = paramCallable.call();
      return paramCallable;
    }
    finally
    {
      detach(localContext);
    }
  }
  
  boolean canBeCancelled()
  {
    return this.canBeCancelled;
  }
  
  public Throwable cancellationCause()
  {
    if ((this.parent == null) || (!this.cascadesCancellation)) {
      return null;
    }
    return this.parent.cancellationCause();
  }
  
  public void detach(Context paramContext)
  {
    checkNotNull(paramContext, "toAttach");
    storage().detach(this, paramContext);
  }
  
  public Executor fixedContextExecutor(final Executor paramExecutor)
  {
    new Executor()
    {
      public void execute(Runnable paramAnonymousRunnable)
      {
        paramExecutor.execute(this.this$0.wrap(paramAnonymousRunnable));
      }
    };
  }
  
  public Context fork()
  {
    return new Context(this);
  }
  
  public Deadline getDeadline()
  {
    return (Deadline)DEADLINE_KEY.get(this);
  }
  
  public boolean isCancelled()
  {
    if ((this.parent == null) || (!this.cascadesCancellation)) {
      return false;
    }
    return this.parent.isCancelled();
  }
  
  boolean isCurrent()
  {
    return current() == this;
  }
  
  /* Error */
  int listenerCount()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 256	io/grpc/Context:listeners	Ljava/util/ArrayList;
    //   6: ifnonnull +9 -> 15
    //   9: iconst_0
    //   10: istore_1
    //   11: aload_0
    //   12: monitorexit
    //   13: iload_1
    //   14: ireturn
    //   15: aload_0
    //   16: getfield 256	io/grpc/Context:listeners	Ljava/util/ArrayList;
    //   19: invokevirtual 314	java/util/ArrayList:size	()I
    //   22: istore_1
    //   23: goto -12 -> 11
    //   26: astore_2
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_2
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	Context
    //   10	13	1	i	int
    //   26	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	9	26	finally
    //   11	13	26	finally
    //   15	23	26	finally
    //   27	29	26	finally
  }
  
  void notifyAndClearListeners()
  {
    if (!this.canBeCancelled) {
      return;
    }
    try
    {
      if (this.listeners == null) {
        return;
      }
    }
    finally {}
    ArrayList localArrayList = this.listeners;
    this.listeners = null;
    int i = 0;
    while (i < localArrayList.size())
    {
      if (!(((ExecutableListener)localArrayList.get(i)).listener instanceof ParentListener)) {
        ((ExecutableListener)localArrayList.get(i)).deliver();
      }
      i += 1;
    }
    i = 0;
    while (i < localArrayList.size())
    {
      if ((((ExecutableListener)localArrayList.get(i)).listener instanceof ParentListener)) {
        ((ExecutableListener)localArrayList.get(i)).deliver();
      }
      i += 1;
    }
    this.parent.removeListener(this.parentListener);
  }
  
  public void removeListener(CancellationListener paramCancellationListener)
  {
    if (!this.canBeCancelled) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        if (this.listeners != null)
        {
          i = this.listeners.size() - 1;
          if (i >= 0)
          {
            if (((ExecutableListener)this.listeners.get(i)).listener != paramCancellationListener) {
              break label92;
            }
            this.listeners.remove(i);
          }
          if (this.listeners.isEmpty())
          {
            this.parent.removeListener(this.parentListener);
            this.listeners = null;
          }
        }
        return;
      }
      finally {}
      label92:
      i -= 1;
    }
  }
  
  public void run(Runnable paramRunnable)
  {
    Context localContext = attach();
    try
    {
      paramRunnable.run();
      return;
    }
    finally
    {
      detach(localContext);
    }
  }
  
  public CancellableContext withCancellation()
  {
    return new CancellableContext(this, null);
  }
  
  public CancellableContext withDeadline(Deadline paramDeadline, ScheduledExecutorService paramScheduledExecutorService)
  {
    checkNotNull(paramDeadline, "deadline");
    checkNotNull(paramScheduledExecutorService, "scheduler");
    return new CancellableContext(this, paramDeadline, paramScheduledExecutorService, null);
  }
  
  public CancellableContext withDeadlineAfter(long paramLong, TimeUnit paramTimeUnit, ScheduledExecutorService paramScheduledExecutorService)
  {
    return withDeadline(Deadline.after(paramLong, paramTimeUnit), paramScheduledExecutorService);
  }
  
  public <V> Context withValue(Key<V> paramKey, V paramV)
  {
    return new Context(this, new Object[][] { { paramKey, paramV } });
  }
  
  public <V1, V2> Context withValues(Key<V1> paramKey, V1 paramV1, Key<V2> paramKey1, V2 paramV2)
  {
    return new Context(this, new Object[][] { { paramKey, paramV1 }, { paramKey1, paramV2 } });
  }
  
  public <V1, V2, V3> Context withValues(Key<V1> paramKey, V1 paramV1, Key<V2> paramKey1, V2 paramV2, Key<V3> paramKey2, V3 paramV3)
  {
    return new Context(this, new Object[][] { { paramKey, paramV1 }, { paramKey1, paramV2 }, { paramKey2, paramV3 } });
  }
  
  public <V1, V2, V3, V4> Context withValues(Key<V1> paramKey, V1 paramV1, Key<V2> paramKey1, V2 paramV2, Key<V3> paramKey2, V3 paramV3, Key<V4> paramKey3, V4 paramV4)
  {
    paramKey = new Object[] { paramKey, paramV1 };
    paramV1 = new Object[] { paramKey2, paramV3 };
    paramKey2 = new Object[] { paramKey3, paramV4 };
    return new Context(this, new Object[][] { paramKey, { paramKey1, paramV2 }, paramV1, paramKey2 });
  }
  
  public Runnable wrap(final Runnable paramRunnable)
  {
    new Runnable()
    {
      public void run()
      {
        Context localContext = Context.this.attach();
        try
        {
          paramRunnable.run();
          return;
        }
        finally
        {
          Context.this.detach(localContext);
        }
      }
    };
  }
  
  public <C> Callable<C> wrap(final Callable<C> paramCallable)
  {
    new Callable()
    {
      public C call()
        throws Exception
      {
        Context localContext = Context.this.attach();
        try
        {
          Object localObject1 = paramCallable.call();
          return (C)localObject1;
        }
        finally
        {
          Context.this.detach(localContext);
        }
      }
    };
  }
  
  public static final class CancellableContext
    extends Context
  {
    private Throwable cancellationCause;
    private boolean cancelled;
    private ScheduledFuture<?> pendingDeadline;
    private final Context uncancellableSurrogate;
    
    private CancellableContext(Context paramContext)
    {
      super(Context.EMPTY_ENTRIES, true, null);
      this.uncancellableSurrogate = new Context(this, Context.EMPTY_ENTRIES, null);
    }
    
    private CancellableContext(final Context paramContext, Deadline paramDeadline, ScheduledExecutorService paramScheduledExecutorService)
    {
      super(deriveDeadline(paramContext, paramDeadline), true, null);
      if (Context.DEADLINE_KEY.get(this) == paramDeadline)
      {
        paramContext = new TimeoutException("context timed out");
        if (paramDeadline.isExpired()) {
          break label75;
        }
        this.pendingDeadline = paramDeadline.runOnExpiration(new Runnable()
        {
          public void run()
          {
            try
            {
              Context.CancellableContext.this.cancel(paramContext);
              return;
            }
            catch (Throwable localThrowable)
            {
              Context.log.log(Level.SEVERE, "Cancel threw an exception, which should not happen", localThrowable);
            }
          }
        }, paramScheduledExecutorService);
      }
      for (;;)
      {
        this.uncancellableSurrogate = new Context(this, Context.EMPTY_ENTRIES, null);
        return;
        label75:
        cancel(paramContext);
      }
    }
    
    private static Object[][] deriveDeadline(Context paramContext, Deadline paramDeadline)
    {
      paramContext = (Deadline)Context.DEADLINE_KEY.get(paramContext);
      if ((paramContext == null) || (paramDeadline.isBefore(paramContext))) {
        return new Object[][] { { Context.DEADLINE_KEY, paramDeadline } };
      }
      return Context.EMPTY_ENTRIES;
    }
    
    public Context attach()
    {
      return this.uncancellableSurrogate.attach();
    }
    
    public boolean cancel(Throwable paramThrowable)
    {
      boolean bool = false;
      try
      {
        if (!this.cancelled)
        {
          this.cancelled = true;
          if (this.pendingDeadline != null)
          {
            this.pendingDeadline.cancel(false);
            this.pendingDeadline = null;
          }
          this.cancellationCause = paramThrowable;
          bool = true;
        }
        if (bool) {
          notifyAndClearListeners();
        }
        return bool;
      }
      finally {}
    }
    
    public Throwable cancellationCause()
    {
      if (isCancelled()) {
        return this.cancellationCause;
      }
      return null;
    }
    
    public void detach(Context paramContext)
    {
      this.uncancellableSurrogate.detach(paramContext);
    }
    
    public void detachAndCancel(Context paramContext, Throwable paramThrowable)
    {
      try
      {
        detach(paramContext);
        return;
      }
      finally
      {
        cancel(paramThrowable);
      }
    }
    
    public boolean isCancelled()
    {
      try
      {
        if (this.cancelled) {
          return true;
        }
        if (super.isCancelled())
        {
          cancel(super.cancellationCause());
          return true;
        }
      }
      finally {}
      return false;
    }
    
    public boolean isCurrent()
    {
      return this.uncancellableSurrogate.isCurrent();
    }
  }
  
  public static abstract interface CancellationListener
  {
    public abstract void cancelled(Context paramContext);
  }
  
  private static enum DirectExecutor
    implements Executor
  {
    INSTANCE;
    
    private DirectExecutor() {}
    
    public void execute(Runnable paramRunnable)
    {
      paramRunnable.run();
    }
    
    public String toString()
    {
      return "Context.DirectExecutor";
    }
  }
  
  private class ExecutableListener
    implements Runnable
  {
    private final Executor executor;
    private final Context.CancellationListener listener;
    
    private ExecutableListener(Executor paramExecutor, Context.CancellationListener paramCancellationListener)
    {
      this.executor = paramExecutor;
      this.listener = paramCancellationListener;
    }
    
    private void deliver()
    {
      try
      {
        this.executor.execute(this);
        return;
      }
      catch (Throwable localThrowable)
      {
        Context.log.log(Level.INFO, "Exception notifying context listener", localThrowable);
      }
    }
    
    public void run()
    {
      this.listener.cancelled(Context.this);
    }
  }
  
  public static class Key<T>
  {
    private final T defaultValue;
    private final String name;
    
    Key(String paramString)
    {
      this(paramString, null);
    }
    
    Key(String paramString, T paramT)
    {
      this.name = ((String)Context.checkNotNull(paramString, "name"));
      this.defaultValue = paramT;
    }
    
    public T get()
    {
      return (T)get(Context.current());
    }
    
    public T get(Context paramContext)
    {
      Object localObject = paramContext.lookup(this);
      paramContext = (Context)localObject;
      if (localObject == null) {
        paramContext = this.defaultValue;
      }
      return paramContext;
    }
    
    public String toString()
    {
      return this.name;
    }
  }
  
  private class ParentListener
    implements Context.CancellationListener
  {
    private ParentListener() {}
    
    public void cancelled(Context paramContext)
    {
      if ((Context.this instanceof Context.CancellableContext))
      {
        ((Context.CancellableContext)Context.this).cancel(paramContext.cancellationCause());
        return;
      }
      Context.this.notifyAndClearListeners();
    }
  }
  
  public static abstract class Storage
  {
    public abstract void attach(Context paramContext);
    
    public abstract Context current();
    
    public abstract void detach(Context paramContext1, Context paramContext2);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/io/grpc/Context.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */