package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
@GwtCompatible
public final class Booleans
{
  public static List<Boolean> asList(boolean... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return Collections.emptyList();
    }
    return new BooleanArrayAsList(paramVarArgs);
  }
  
  public static int compare(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1 == paramBoolean2) {
      return 0;
    }
    if (paramBoolean1) {
      return 1;
    }
    return -1;
  }
  
  public static boolean[] concat(boolean[]... paramVarArgs)
  {
    int j = 0;
    int k = paramVarArgs.length;
    int i = 0;
    while (i < k)
    {
      j += paramVarArgs[i].length;
      i += 1;
    }
    boolean[] arrayOfBoolean1 = new boolean[j];
    j = 0;
    k = paramVarArgs.length;
    i = 0;
    while (i < k)
    {
      boolean[] arrayOfBoolean2 = paramVarArgs[i];
      System.arraycopy(arrayOfBoolean2, 0, arrayOfBoolean1, j, arrayOfBoolean2.length);
      j += arrayOfBoolean2.length;
      i += 1;
    }
    return arrayOfBoolean1;
  }
  
  public static boolean contains(boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    int j = paramArrayOfBoolean.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfBoolean[i] == paramBoolean) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private static boolean[] copyOf(boolean[] paramArrayOfBoolean, int paramInt)
  {
    boolean[] arrayOfBoolean = new boolean[paramInt];
    System.arraycopy(paramArrayOfBoolean, 0, arrayOfBoolean, 0, Math.min(paramArrayOfBoolean.length, paramInt));
    return arrayOfBoolean;
  }
  
  @Beta
  public static int countTrue(boolean... paramVarArgs)
  {
    int j = 0;
    int m = paramVarArgs.length;
    int i = 0;
    while (i < m)
    {
      int k = j;
      if (paramVarArgs[i] != 0) {
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  public static boolean[] ensureCapacity(boolean[] paramArrayOfBoolean, int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      bool = true;
      Preconditions.checkArgument(bool, "Invalid minLength: %s", new Object[] { Integer.valueOf(paramInt1) });
      if (paramInt2 < 0) {
        break label72;
      }
    }
    label72:
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Invalid padding: %s", new Object[] { Integer.valueOf(paramInt2) });
      boolean[] arrayOfBoolean = paramArrayOfBoolean;
      if (paramArrayOfBoolean.length < paramInt1) {
        arrayOfBoolean = copyOf(paramArrayOfBoolean, paramInt1 + paramInt2);
      }
      return arrayOfBoolean;
      bool = false;
      break;
    }
  }
  
  public static int hashCode(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 1231;
    }
    return 1237;
  }
  
  public static int indexOf(boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    return indexOf(paramArrayOfBoolean, paramBoolean, 0, paramArrayOfBoolean.length);
  }
  
  private static int indexOf(boolean[] paramArrayOfBoolean, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      if (paramArrayOfBoolean[paramInt1] == paramBoolean) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return -1;
  }
  
  public static int indexOf(boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2)
  {
    Preconditions.checkNotNull(paramArrayOfBoolean1, "array");
    Preconditions.checkNotNull(paramArrayOfBoolean2, "target");
    int j;
    if (paramArrayOfBoolean2.length == 0)
    {
      j = 0;
      return j;
    }
    int i = 0;
    label25:
    if (i < paramArrayOfBoolean1.length - paramArrayOfBoolean2.length + 1)
    {
      int k = 0;
      for (;;)
      {
        j = i;
        if (k >= paramArrayOfBoolean2.length) {
          break;
        }
        if (paramArrayOfBoolean1[(i + k)] != paramArrayOfBoolean2[k])
        {
          i += 1;
          break label25;
        }
        k += 1;
      }
    }
    return -1;
  }
  
  public static String join(String paramString, boolean... paramVarArgs)
  {
    Preconditions.checkNotNull(paramString);
    if (paramVarArgs.length == 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(paramVarArgs.length * 7);
    localStringBuilder.append(paramVarArgs[0]);
    int i = 1;
    while (i < paramVarArgs.length)
    {
      localStringBuilder.append(paramString).append(paramVarArgs[i]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static int lastIndexOf(boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    return lastIndexOf(paramArrayOfBoolean, paramBoolean, 0, paramArrayOfBoolean.length);
  }
  
  private static int lastIndexOf(boolean[] paramArrayOfBoolean, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    paramInt2 -= 1;
    while (paramInt2 >= paramInt1)
    {
      if (paramArrayOfBoolean[paramInt2] == paramBoolean) {
        return paramInt2;
      }
      paramInt2 -= 1;
    }
    return -1;
  }
  
  public static Comparator<boolean[]> lexicographicalComparator()
  {
    return LexicographicalComparator.INSTANCE;
  }
  
  public static boolean[] toArray(Collection<Boolean> paramCollection)
  {
    if ((paramCollection instanceof BooleanArrayAsList))
    {
      paramCollection = ((BooleanArrayAsList)paramCollection).toBooleanArray();
      return paramCollection;
    }
    Object[] arrayOfObject = paramCollection.toArray();
    int j = arrayOfObject.length;
    boolean[] arrayOfBoolean = new boolean[j];
    int i = 0;
    for (;;)
    {
      paramCollection = arrayOfBoolean;
      if (i >= j) {
        break;
      }
      arrayOfBoolean[i] = ((Boolean)Preconditions.checkNotNull(arrayOfObject[i])).booleanValue();
      i += 1;
    }
  }
  
  @GwtCompatible
  private static class BooleanArrayAsList
    extends AbstractList<Boolean>
    implements RandomAccess, Serializable
  {
    private static final long serialVersionUID = 0L;
    final boolean[] array;
    final int end;
    final int start;
    
    BooleanArrayAsList(boolean[] paramArrayOfBoolean)
    {
      this(paramArrayOfBoolean, 0, paramArrayOfBoolean.length);
    }
    
    BooleanArrayAsList(boolean[] paramArrayOfBoolean, int paramInt1, int paramInt2)
    {
      this.array = paramArrayOfBoolean;
      this.start = paramInt1;
      this.end = paramInt2;
    }
    
    public boolean contains(Object paramObject)
    {
      return ((paramObject instanceof Boolean)) && (Booleans.indexOf(this.array, ((Boolean)paramObject).booleanValue(), this.start, this.end) != -1);
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      if (paramObject == this) {}
      for (;;)
      {
        return true;
        if (!(paramObject instanceof BooleanArrayAsList)) {
          break;
        }
        paramObject = (BooleanArrayAsList)paramObject;
        int j = size();
        if (((BooleanArrayAsList)paramObject).size() != j) {
          return false;
        }
        int i = 0;
        while (i < j)
        {
          if (this.array[(this.start + i)] != paramObject.array[(paramObject.start + i)]) {
            return false;
          }
          i += 1;
        }
      }
      return super.equals(paramObject);
    }
    
    public Boolean get(int paramInt)
    {
      Preconditions.checkElementIndex(paramInt, size());
      return Boolean.valueOf(this.array[(this.start + paramInt)]);
    }
    
    public int hashCode()
    {
      int j = 1;
      int i = this.start;
      while (i < this.end)
      {
        j = j * 31 + Booleans.hashCode(this.array[i]);
        i += 1;
      }
      return j;
    }
    
    public int indexOf(Object paramObject)
    {
      if ((paramObject instanceof Boolean))
      {
        int i = Booleans.indexOf(this.array, ((Boolean)paramObject).booleanValue(), this.start, this.end);
        if (i >= 0) {
          return i - this.start;
        }
      }
      return -1;
    }
    
    public boolean isEmpty()
    {
      return false;
    }
    
    public int lastIndexOf(Object paramObject)
    {
      if ((paramObject instanceof Boolean))
      {
        int i = Booleans.lastIndexOf(this.array, ((Boolean)paramObject).booleanValue(), this.start, this.end);
        if (i >= 0) {
          return i - this.start;
        }
      }
      return -1;
    }
    
    public Boolean set(int paramInt, Boolean paramBoolean)
    {
      Preconditions.checkElementIndex(paramInt, size());
      int i = this.array[(this.start + paramInt)];
      this.array[(this.start + paramInt)] = ((Boolean)Preconditions.checkNotNull(paramBoolean)).booleanValue();
      return Boolean.valueOf(i);
    }
    
    public int size()
    {
      return this.end - this.start;
    }
    
    public List<Boolean> subList(int paramInt1, int paramInt2)
    {
      Preconditions.checkPositionIndexes(paramInt1, paramInt2, size());
      if (paramInt1 == paramInt2) {
        return Collections.emptyList();
      }
      return new BooleanArrayAsList(this.array, this.start + paramInt1, this.start + paramInt2);
    }
    
    boolean[] toBooleanArray()
    {
      int i = size();
      boolean[] arrayOfBoolean = new boolean[i];
      System.arraycopy(this.array, this.start, arrayOfBoolean, 0, i);
      return arrayOfBoolean;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(size() * 7);
      int i;
      if (this.array[this.start] != 0)
      {
        str = "[true";
        localStringBuilder.append(str);
        i = this.start + 1;
        label43:
        if (i >= this.end) {
          break label88;
        }
        if (this.array[i] == 0) {
          break label82;
        }
      }
      label82:
      for (String str = ", true";; str = ", false")
      {
        localStringBuilder.append(str);
        i += 1;
        break label43;
        str = "[false";
        break;
      }
      label88:
      return ']';
    }
  }
  
  private static enum LexicographicalComparator
    implements Comparator<boolean[]>
  {
    INSTANCE;
    
    private LexicographicalComparator() {}
    
    public int compare(boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2)
    {
      int j = Math.min(paramArrayOfBoolean1.length, paramArrayOfBoolean2.length);
      int i = 0;
      while (i < j)
      {
        int k = Booleans.compare(paramArrayOfBoolean1[i], paramArrayOfBoolean2[i]);
        if (k != 0) {
          return k;
        }
        i += 1;
      }
      return paramArrayOfBoolean1.length - paramArrayOfBoolean2.length;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/primitives/Booleans.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */