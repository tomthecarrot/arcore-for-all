package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.CheckReturnValue;

@GwtCompatible(emulated=true)
public final class Splitter
{
  private final int limit;
  private final boolean omitEmptyStrings;
  private final Strategy strategy;
  private final CharMatcher trimmer;
  
  private Splitter(Strategy paramStrategy)
  {
    this(paramStrategy, false, CharMatcher.NONE, Integer.MAX_VALUE);
  }
  
  private Splitter(Strategy paramStrategy, boolean paramBoolean, CharMatcher paramCharMatcher, int paramInt)
  {
    this.strategy = paramStrategy;
    this.omitEmptyStrings = paramBoolean;
    this.trimmer = paramCharMatcher;
    this.limit = paramInt;
  }
  
  @CheckReturnValue
  public static Splitter fixedLength(int paramInt)
  {
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "The length may not be less than 1");
      new Splitter(new Strategy()
      {
        public Splitter.SplittingIterator iterator(Splitter paramAnonymousSplitter, CharSequence paramAnonymousCharSequence)
        {
          new Splitter.SplittingIterator(paramAnonymousSplitter, paramAnonymousCharSequence)
          {
            public int separatorEnd(int paramAnonymous2Int)
            {
              return paramAnonymous2Int;
            }
            
            public int separatorStart(int paramAnonymous2Int)
            {
              paramAnonymous2Int += Splitter.4.this.val$length;
              if (paramAnonymous2Int < this.toSplit.length()) {
                return paramAnonymous2Int;
              }
              return -1;
            }
          };
        }
      });
    }
  }
  
  @CheckReturnValue
  public static Splitter on(char paramChar)
  {
    return on(CharMatcher.is(paramChar));
  }
  
  @CheckReturnValue
  public static Splitter on(CharMatcher paramCharMatcher)
  {
    Preconditions.checkNotNull(paramCharMatcher);
    new Splitter(new Strategy()
    {
      public Splitter.SplittingIterator iterator(Splitter paramAnonymousSplitter, CharSequence paramAnonymousCharSequence)
      {
        new Splitter.SplittingIterator(paramAnonymousSplitter, paramAnonymousCharSequence)
        {
          int separatorEnd(int paramAnonymous2Int)
          {
            return paramAnonymous2Int + 1;
          }
          
          int separatorStart(int paramAnonymous2Int)
          {
            return Splitter.1.this.val$separatorMatcher.indexIn(this.toSplit, paramAnonymous2Int);
          }
        };
      }
    });
  }
  
  @CheckReturnValue
  public static Splitter on(String paramString)
  {
    if (paramString.length() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "The separator may not be the empty string.");
      if (paramString.length() != 1) {
        break;
      }
      return on(paramString.charAt(0));
    }
    new Splitter(new Strategy()
    {
      public Splitter.SplittingIterator iterator(Splitter paramAnonymousSplitter, CharSequence paramAnonymousCharSequence)
      {
        new Splitter.SplittingIterator(paramAnonymousSplitter, paramAnonymousCharSequence)
        {
          public int separatorEnd(int paramAnonymous2Int)
          {
            return Splitter.2.this.val$separator.length() + paramAnonymous2Int;
          }
          
          public int separatorStart(int paramAnonymous2Int)
          {
            int k = Splitter.2.this.val$separator.length();
            int m = this.toSplit.length();
            if (paramAnonymous2Int <= m - k)
            {
              int i = 0;
              for (;;)
              {
                j = paramAnonymous2Int;
                if (i >= k) {
                  return j;
                }
                if (this.toSplit.charAt(i + paramAnonymous2Int) != Splitter.2.this.val$separator.charAt(i))
                {
                  paramAnonymous2Int += 1;
                  break;
                }
                i += 1;
              }
            }
            int j = -1;
            return j;
          }
        };
      }
    });
  }
  
  @CheckReturnValue
  @GwtIncompatible("java.util.regex")
  public static Splitter on(Pattern paramPattern)
  {
    Preconditions.checkNotNull(paramPattern);
    if (!paramPattern.matcher("").matches()) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "The pattern may not match the empty string: %s", new Object[] { paramPattern });
      new Splitter(new Strategy()
      {
        public Splitter.SplittingIterator iterator(Splitter paramAnonymousSplitter, CharSequence paramAnonymousCharSequence)
        {
          new Splitter.SplittingIterator(paramAnonymousSplitter, paramAnonymousCharSequence)
          {
            public int separatorEnd(int paramAnonymous2Int)
            {
              return this.val$matcher.end();
            }
            
            public int separatorStart(int paramAnonymous2Int)
            {
              if (this.val$matcher.find(paramAnonymous2Int)) {
                return this.val$matcher.start();
              }
              return -1;
            }
          };
        }
      });
    }
  }
  
  @CheckReturnValue
  @GwtIncompatible("java.util.regex")
  public static Splitter onPattern(String paramString)
  {
    return on(Pattern.compile(paramString));
  }
  
  private Iterator<String> splittingIterator(CharSequence paramCharSequence)
  {
    return this.strategy.iterator(this, paramCharSequence);
  }
  
  @CheckReturnValue
  public Splitter limit(int paramInt)
  {
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "must be greater than zero: %s", new Object[] { Integer.valueOf(paramInt) });
      return new Splitter(this.strategy, this.omitEmptyStrings, this.trimmer, paramInt);
    }
  }
  
  @CheckReturnValue
  public Splitter omitEmptyStrings()
  {
    return new Splitter(this.strategy, true, this.trimmer, this.limit);
  }
  
  @CheckReturnValue
  public Iterable<String> split(final CharSequence paramCharSequence)
  {
    Preconditions.checkNotNull(paramCharSequence);
    new Iterable()
    {
      public Iterator<String> iterator()
      {
        return Splitter.this.splittingIterator(paramCharSequence);
      }
      
      public String toString()
      {
        return ']';
      }
    };
  }
  
  @CheckReturnValue
  @Beta
  public List<String> splitToList(CharSequence paramCharSequence)
  {
    Preconditions.checkNotNull(paramCharSequence);
    paramCharSequence = splittingIterator(paramCharSequence);
    ArrayList localArrayList = new ArrayList();
    while (paramCharSequence.hasNext()) {
      localArrayList.add(paramCharSequence.next());
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  @CheckReturnValue
  public Splitter trimResults()
  {
    return trimResults(CharMatcher.WHITESPACE);
  }
  
  @CheckReturnValue
  public Splitter trimResults(CharMatcher paramCharMatcher)
  {
    Preconditions.checkNotNull(paramCharMatcher);
    return new Splitter(this.strategy, this.omitEmptyStrings, paramCharMatcher, this.limit);
  }
  
  @CheckReturnValue
  @Beta
  public MapSplitter withKeyValueSeparator(char paramChar)
  {
    return withKeyValueSeparator(on(paramChar));
  }
  
  @CheckReturnValue
  @Beta
  public MapSplitter withKeyValueSeparator(Splitter paramSplitter)
  {
    return new MapSplitter(this, paramSplitter, null);
  }
  
  @CheckReturnValue
  @Beta
  public MapSplitter withKeyValueSeparator(String paramString)
  {
    return withKeyValueSeparator(on(paramString));
  }
  
  @Beta
  public static final class MapSplitter
  {
    private static final String INVALID_ENTRY_MESSAGE = "Chunk [%s] is not a valid entry";
    private final Splitter entrySplitter;
    private final Splitter outerSplitter;
    
    private MapSplitter(Splitter paramSplitter1, Splitter paramSplitter2)
    {
      this.outerSplitter = paramSplitter1;
      this.entrySplitter = ((Splitter)Preconditions.checkNotNull(paramSplitter2));
    }
    
    @CheckReturnValue
    public Map<String, String> split(CharSequence paramCharSequence)
    {
      LinkedHashMap localLinkedHashMap = new LinkedHashMap();
      paramCharSequence = this.outerSplitter.split(paramCharSequence).iterator();
      if (paramCharSequence.hasNext())
      {
        String str1 = (String)paramCharSequence.next();
        Iterator localIterator = this.entrySplitter.splittingIterator(str1);
        Preconditions.checkArgument(localIterator.hasNext(), "Chunk [%s] is not a valid entry", new Object[] { str1 });
        String str2 = (String)localIterator.next();
        if (!localLinkedHashMap.containsKey(str2))
        {
          bool = true;
          label99:
          Preconditions.checkArgument(bool, "Duplicate key [%s] found.", new Object[] { str2 });
          Preconditions.checkArgument(localIterator.hasNext(), "Chunk [%s] is not a valid entry", new Object[] { str1 });
          localLinkedHashMap.put(str2, (String)localIterator.next());
          if (localIterator.hasNext()) {
            break label189;
          }
        }
        label189:
        for (boolean bool = true;; bool = false)
        {
          Preconditions.checkArgument(bool, "Chunk [%s] is not a valid entry", new Object[] { str1 });
          break;
          bool = false;
          break label99;
        }
      }
      return Collections.unmodifiableMap(localLinkedHashMap);
    }
  }
  
  private static abstract class SplittingIterator
    extends AbstractIterator<String>
  {
    int limit;
    int offset = 0;
    final boolean omitEmptyStrings;
    final CharSequence toSplit;
    final CharMatcher trimmer;
    
    protected SplittingIterator(Splitter paramSplitter, CharSequence paramCharSequence)
    {
      this.trimmer = paramSplitter.trimmer;
      this.omitEmptyStrings = paramSplitter.omitEmptyStrings;
      this.limit = paramSplitter.limit;
      this.toSplit = paramCharSequence;
    }
    
    protected String computeNext()
    {
      int i = this.offset;
      while (this.offset != -1)
      {
        int k = i;
        int m = separatorStart(this.offset);
        int j;
        if (m == -1) {
          j = this.toSplit.length();
        }
        for (this.offset = -1;; this.offset = separatorEnd(m))
        {
          if (this.offset != i) {
            break label104;
          }
          this.offset += 1;
          if (this.offset < this.toSplit.length()) {
            break;
          }
          this.offset = -1;
          break;
          j = m;
        }
        for (;;)
        {
          label104:
          i = j;
          if (k >= j) {
            break;
          }
          i = j;
          if (!this.trimmer.matches(this.toSplit.charAt(k))) {
            break;
          }
          k += 1;
        }
        while ((i > k) && (this.trimmer.matches(this.toSplit.charAt(i - 1)))) {
          i -= 1;
        }
        if ((this.omitEmptyStrings) && (k == i))
        {
          i = this.offset;
        }
        else
        {
          if (this.limit == 1)
          {
            i = this.toSplit.length();
            this.offset = -1;
            for (;;)
            {
              j = i;
              if (i <= k) {
                break;
              }
              j = i;
              if (!this.trimmer.matches(this.toSplit.charAt(i - 1))) {
                break;
              }
              i -= 1;
            }
          }
          this.limit -= 1;
          j = i;
          return this.toSplit.subSequence(k, j).toString();
        }
      }
      return (String)endOfData();
    }
    
    abstract int separatorEnd(int paramInt);
    
    abstract int separatorStart(int paramInt);
  }
  
  private static abstract interface Strategy
  {
    public abstract Iterator<String> iterator(Splitter paramSplitter, CharSequence paramCharSequence);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/base/Splitter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */