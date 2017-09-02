package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true, serializable=true)
public class LinkedListMultimap<K, V>
  extends AbstractMultimap<K, V>
  implements ListMultimap<K, V>, Serializable
{
  @GwtIncompatible("java serialization not supported")
  private static final long serialVersionUID = 0L;
  private transient Node<K, V> head;
  private transient Map<K, KeyList<K, V>> keyToKeyList;
  private transient int modCount;
  private transient int size;
  private transient Node<K, V> tail;
  
  LinkedListMultimap()
  {
    this.keyToKeyList = Maps.newHashMap();
  }
  
  private LinkedListMultimap(int paramInt)
  {
    this.keyToKeyList = new HashMap(paramInt);
  }
  
  private LinkedListMultimap(Multimap<? extends K, ? extends V> paramMultimap)
  {
    this(paramMultimap.keySet().size());
    putAll(paramMultimap);
  }
  
  private Node<K, V> addNode(@Nullable K paramK, @Nullable V paramV, @Nullable Node<K, V> paramNode)
  {
    paramV = new Node(paramK, paramV);
    if (this.head == null)
    {
      this.tail = paramV;
      this.head = paramV;
      this.keyToKeyList.put(paramK, new KeyList(paramV));
      this.modCount += 1;
    }
    for (;;)
    {
      this.size += 1;
      return paramV;
      if (paramNode != null) {
        break;
      }
      this.tail.next = paramV;
      paramV.previous = this.tail;
      this.tail = paramV;
      paramNode = (KeyList)this.keyToKeyList.get(paramK);
      if (paramNode == null)
      {
        this.keyToKeyList.put(paramK, new KeyList(paramV));
        this.modCount += 1;
      }
      else
      {
        paramNode.count += 1;
        paramK = paramNode.tail;
        paramK.nextSibling = paramV;
        paramV.previousSibling = paramK;
        paramNode.tail = paramV;
      }
    }
    KeyList localKeyList = (KeyList)this.keyToKeyList.get(paramK);
    localKeyList.count += 1;
    paramV.previous = paramNode.previous;
    paramV.previousSibling = paramNode.previousSibling;
    paramV.next = paramNode;
    paramV.nextSibling = paramNode;
    if (paramNode.previousSibling == null)
    {
      ((KeyList)this.keyToKeyList.get(paramK)).head = paramV;
      label253:
      if (paramNode.previous != null) {
        break label289;
      }
      this.head = paramV;
    }
    for (;;)
    {
      paramNode.previous = paramV;
      paramNode.previousSibling = paramV;
      break;
      paramNode.previousSibling.nextSibling = paramV;
      break label253;
      label289:
      paramNode.previous.next = paramV;
    }
  }
  
  private static void checkElement(@Nullable Object paramObject)
  {
    if (paramObject == null) {
      throw new NoSuchElementException();
    }
  }
  
  public static <K, V> LinkedListMultimap<K, V> create()
  {
    return new LinkedListMultimap();
  }
  
  public static <K, V> LinkedListMultimap<K, V> create(int paramInt)
  {
    return new LinkedListMultimap(paramInt);
  }
  
  public static <K, V> LinkedListMultimap<K, V> create(Multimap<? extends K, ? extends V> paramMultimap)
  {
    return new LinkedListMultimap(paramMultimap);
  }
  
  private List<V> getCopy(@Nullable Object paramObject)
  {
    return Collections.unmodifiableList(Lists.newArrayList(new ValueForKeyIterator(paramObject)));
  }
  
  @GwtIncompatible("java.io.ObjectInputStream")
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    this.keyToKeyList = Maps.newLinkedHashMap();
    int j = paramObjectInputStream.readInt();
    int i = 0;
    while (i < j)
    {
      put(paramObjectInputStream.readObject(), paramObjectInputStream.readObject());
      i += 1;
    }
  }
  
  private void removeAllNodes(@Nullable Object paramObject)
  {
    Iterators.clear(new ValueForKeyIterator(paramObject));
  }
  
  private void removeNode(Node<K, V> paramNode)
  {
    if (paramNode.previous != null)
    {
      paramNode.previous.next = paramNode.next;
      if (paramNode.next == null) {
        break label102;
      }
      paramNode.next.previous = paramNode.previous;
      label36:
      if ((paramNode.previousSibling != null) || (paramNode.nextSibling != null)) {
        break label113;
      }
      ((KeyList)this.keyToKeyList.remove(paramNode.key)).count = 0;
      this.modCount += 1;
    }
    for (;;)
    {
      this.size -= 1;
      return;
      this.head = paramNode.next;
      break;
      label102:
      this.tail = paramNode.previous;
      break label36;
      label113:
      KeyList localKeyList = (KeyList)this.keyToKeyList.get(paramNode.key);
      localKeyList.count -= 1;
      if (paramNode.previousSibling == null) {
        localKeyList.head = paramNode.nextSibling;
      }
      for (;;)
      {
        if (paramNode.nextSibling != null) {
          break label187;
        }
        localKeyList.tail = paramNode.previousSibling;
        break;
        paramNode.previousSibling.nextSibling = paramNode.nextSibling;
      }
      label187:
      paramNode.nextSibling.previousSibling = paramNode.previousSibling;
    }
  }
  
  @GwtIncompatible("java.io.ObjectOutputStream")
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeInt(size());
    Iterator localIterator = entries().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramObjectOutputStream.writeObject(localEntry.getKey());
      paramObjectOutputStream.writeObject(localEntry.getValue());
    }
  }
  
  public void clear()
  {
    this.head = null;
    this.tail = null;
    this.keyToKeyList.clear();
    this.size = 0;
    this.modCount += 1;
  }
  
  public boolean containsKey(@Nullable Object paramObject)
  {
    return this.keyToKeyList.containsKey(paramObject);
  }
  
  public boolean containsValue(@Nullable Object paramObject)
  {
    return values().contains(paramObject);
  }
  
  Map<K, Collection<V>> createAsMap()
  {
    return new Multimaps.AsMap(this);
  }
  
  List<Map.Entry<K, V>> createEntries()
  {
    new AbstractSequentialList()
    {
      public ListIterator<Map.Entry<K, V>> listIterator(int paramAnonymousInt)
      {
        return new LinkedListMultimap.NodeIterator(LinkedListMultimap.this, paramAnonymousInt);
      }
      
      public int size()
      {
        return LinkedListMultimap.this.size;
      }
    };
  }
  
  Set<K> createKeySet()
  {
    new Sets.ImprovedAbstractSet()
    {
      public boolean contains(Object paramAnonymousObject)
      {
        return LinkedListMultimap.this.containsKey(paramAnonymousObject);
      }
      
      public Iterator<K> iterator()
      {
        return new LinkedListMultimap.DistinctKeyIterator(LinkedListMultimap.this, null);
      }
      
      public boolean remove(Object paramAnonymousObject)
      {
        return !LinkedListMultimap.this.removeAll(paramAnonymousObject).isEmpty();
      }
      
      public int size()
      {
        return LinkedListMultimap.this.keyToKeyList.size();
      }
    };
  }
  
  List<V> createValues()
  {
    new AbstractSequentialList()
    {
      public ListIterator<V> listIterator(int paramAnonymousInt)
      {
        final LinkedListMultimap.NodeIterator localNodeIterator = new LinkedListMultimap.NodeIterator(LinkedListMultimap.this, paramAnonymousInt);
        new TransformedListIterator(localNodeIterator)
        {
          public void set(V paramAnonymous2V)
          {
            localNodeIterator.setValue(paramAnonymous2V);
          }
          
          V transform(Map.Entry<K, V> paramAnonymous2Entry)
          {
            return (V)paramAnonymous2Entry.getValue();
          }
        };
      }
      
      public int size()
      {
        return LinkedListMultimap.this.size;
      }
    };
  }
  
  public List<Map.Entry<K, V>> entries()
  {
    return (List)super.entries();
  }
  
  Iterator<Map.Entry<K, V>> entryIterator()
  {
    throw new AssertionError("should never be called");
  }
  
  public List<V> get(@Nullable final K paramK)
  {
    new AbstractSequentialList()
    {
      public ListIterator<V> listIterator(int paramAnonymousInt)
      {
        return new LinkedListMultimap.ValueForKeyIterator(LinkedListMultimap.this, paramK, paramAnonymousInt);
      }
      
      public int size()
      {
        LinkedListMultimap.KeyList localKeyList = (LinkedListMultimap.KeyList)LinkedListMultimap.this.keyToKeyList.get(paramK);
        if (localKeyList == null) {
          return 0;
        }
        return localKeyList.count;
      }
    };
  }
  
  public boolean isEmpty()
  {
    return this.head == null;
  }
  
  public boolean put(@Nullable K paramK, @Nullable V paramV)
  {
    addNode(paramK, paramV, null);
    return true;
  }
  
  public List<V> removeAll(@Nullable Object paramObject)
  {
    List localList = getCopy(paramObject);
    removeAllNodes(paramObject);
    return localList;
  }
  
  public List<V> replaceValues(@Nullable K paramK, Iterable<? extends V> paramIterable)
  {
    List localList = getCopy(paramK);
    paramK = new ValueForKeyIterator(paramK);
    paramIterable = paramIterable.iterator();
    while ((paramK.hasNext()) && (paramIterable.hasNext()))
    {
      paramK.next();
      paramK.set(paramIterable.next());
    }
    while (paramK.hasNext())
    {
      paramK.next();
      paramK.remove();
    }
    while (paramIterable.hasNext()) {
      paramK.add(paramIterable.next());
    }
    return localList;
  }
  
  public int size()
  {
    return this.size;
  }
  
  public List<V> values()
  {
    return (List)super.values();
  }
  
  private class DistinctKeyIterator
    implements Iterator<K>
  {
    LinkedListMultimap.Node<K, V> current;
    int expectedModCount = LinkedListMultimap.this.modCount;
    LinkedListMultimap.Node<K, V> next = LinkedListMultimap.this.head;
    final Set<K> seenKeys = Sets.newHashSetWithExpectedSize(LinkedListMultimap.this.keySet().size());
    
    private DistinctKeyIterator() {}
    
    private void checkForConcurrentModification()
    {
      if (LinkedListMultimap.this.modCount != this.expectedModCount) {
        throw new ConcurrentModificationException();
      }
    }
    
    public boolean hasNext()
    {
      checkForConcurrentModification();
      return this.next != null;
    }
    
    public K next()
    {
      checkForConcurrentModification();
      LinkedListMultimap.checkElement(this.next);
      this.current = this.next;
      this.seenKeys.add(this.current.key);
      do
      {
        this.next = this.next.next;
      } while ((this.next != null) && (!this.seenKeys.add(this.next.key)));
      return (K)this.current.key;
    }
    
    public void remove()
    {
      checkForConcurrentModification();
      if (this.current != null) {}
      for (boolean bool = true;; bool = false)
      {
        CollectPreconditions.checkRemove(bool);
        LinkedListMultimap.this.removeAllNodes(this.current.key);
        this.current = null;
        this.expectedModCount = LinkedListMultimap.this.modCount;
        return;
      }
    }
  }
  
  private static class KeyList<K, V>
  {
    int count;
    LinkedListMultimap.Node<K, V> head;
    LinkedListMultimap.Node<K, V> tail;
    
    KeyList(LinkedListMultimap.Node<K, V> paramNode)
    {
      this.head = paramNode;
      this.tail = paramNode;
      paramNode.previousSibling = null;
      paramNode.nextSibling = null;
      this.count = 1;
    }
  }
  
  private static final class Node<K, V>
    extends AbstractMapEntry<K, V>
  {
    final K key;
    Node<K, V> next;
    Node<K, V> nextSibling;
    Node<K, V> previous;
    Node<K, V> previousSibling;
    V value;
    
    Node(@Nullable K paramK, @Nullable V paramV)
    {
      this.key = paramK;
      this.value = paramV;
    }
    
    public K getKey()
    {
      return (K)this.key;
    }
    
    public V getValue()
    {
      return (V)this.value;
    }
    
    public V setValue(@Nullable V paramV)
    {
      Object localObject = this.value;
      this.value = paramV;
      return (V)localObject;
    }
  }
  
  private class NodeIterator
    implements ListIterator<Map.Entry<K, V>>
  {
    LinkedListMultimap.Node<K, V> current;
    int expectedModCount = LinkedListMultimap.this.modCount;
    LinkedListMultimap.Node<K, V> next;
    int nextIndex;
    LinkedListMultimap.Node<K, V> previous;
    
    NodeIterator(int paramInt)
    {
      int i = LinkedListMultimap.this.size();
      Preconditions.checkPositionIndex(paramInt, i);
      if (paramInt >= i / 2)
      {
        this.previous = LinkedListMultimap.this.tail;
        this.nextIndex = i;
        while (paramInt < i)
        {
          previous();
          paramInt += 1;
        }
      }
      this.next = LinkedListMultimap.this.head;
      while (paramInt > 0)
      {
        next();
        paramInt -= 1;
      }
      this.current = null;
    }
    
    private void checkForConcurrentModification()
    {
      if (LinkedListMultimap.this.modCount != this.expectedModCount) {
        throw new ConcurrentModificationException();
      }
    }
    
    public void add(Map.Entry<K, V> paramEntry)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean hasNext()
    {
      checkForConcurrentModification();
      return this.next != null;
    }
    
    public boolean hasPrevious()
    {
      checkForConcurrentModification();
      return this.previous != null;
    }
    
    public LinkedListMultimap.Node<K, V> next()
    {
      checkForConcurrentModification();
      LinkedListMultimap.checkElement(this.next);
      LinkedListMultimap.Node localNode = this.next;
      this.current = localNode;
      this.previous = localNode;
      this.next = this.next.next;
      this.nextIndex += 1;
      return this.current;
    }
    
    public int nextIndex()
    {
      return this.nextIndex;
    }
    
    public LinkedListMultimap.Node<K, V> previous()
    {
      checkForConcurrentModification();
      LinkedListMultimap.checkElement(this.previous);
      LinkedListMultimap.Node localNode = this.previous;
      this.current = localNode;
      this.next = localNode;
      this.previous = this.previous.previous;
      this.nextIndex -= 1;
      return this.current;
    }
    
    public int previousIndex()
    {
      return this.nextIndex - 1;
    }
    
    public void remove()
    {
      checkForConcurrentModification();
      boolean bool;
      if (this.current != null)
      {
        bool = true;
        CollectPreconditions.checkRemove(bool);
        if (this.current == this.next) {
          break label82;
        }
        this.previous = this.current.previous;
        this.nextIndex -= 1;
      }
      for (;;)
      {
        LinkedListMultimap.this.removeNode(this.current);
        this.current = null;
        this.expectedModCount = LinkedListMultimap.this.modCount;
        return;
        bool = false;
        break;
        label82:
        this.next = this.current.next;
      }
    }
    
    public void set(Map.Entry<K, V> paramEntry)
    {
      throw new UnsupportedOperationException();
    }
    
    void setValue(V paramV)
    {
      if (this.current != null) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkState(bool);
        this.current.value = paramV;
        return;
      }
    }
  }
  
  private class ValueForKeyIterator
    implements ListIterator<V>
  {
    LinkedListMultimap.Node<K, V> current;
    final Object key;
    LinkedListMultimap.Node<K, V> next;
    int nextIndex;
    LinkedListMultimap.Node<K, V> previous;
    
    ValueForKeyIterator(Object paramObject)
    {
      this.key = paramObject;
      this$1 = (LinkedListMultimap.KeyList)LinkedListMultimap.this.keyToKeyList.get(paramObject);
      if (LinkedListMultimap.this == null) {}
      for (this$1 = null;; this$1 = LinkedListMultimap.this.head)
      {
        this.next = LinkedListMultimap.this;
        return;
      }
    }
    
    public ValueForKeyIterator(Object paramObject, int paramInt)
    {
      this$1 = (LinkedListMultimap.KeyList)LinkedListMultimap.this.keyToKeyList.get(paramObject);
      int i;
      if (LinkedListMultimap.this == null)
      {
        i = 0;
        Preconditions.checkPositionIndex(paramInt, i);
        if (paramInt < i / 2) {
          break label97;
        }
        if (LinkedListMultimap.this != null) {
          break label89;
        }
      }
      label89:
      for (this$1 = null;; this$1 = LinkedListMultimap.this.tail)
      {
        this.previous = LinkedListMultimap.this;
        this.nextIndex = i;
        while (paramInt < i)
        {
          previous();
          paramInt += 1;
        }
        i = LinkedListMultimap.this.count;
        break;
      }
      label97:
      if (LinkedListMultimap.this == null) {}
      for (this$1 = null;; this$1 = LinkedListMultimap.this.head)
      {
        this.next = LinkedListMultimap.this;
        while (paramInt > 0)
        {
          next();
          paramInt -= 1;
        }
      }
      this.key = paramObject;
      this.current = null;
    }
    
    public void add(V paramV)
    {
      this.previous = LinkedListMultimap.this.addNode(this.key, paramV, this.next);
      this.nextIndex += 1;
      this.current = null;
    }
    
    public boolean hasNext()
    {
      return this.next != null;
    }
    
    public boolean hasPrevious()
    {
      return this.previous != null;
    }
    
    public V next()
    {
      LinkedListMultimap.checkElement(this.next);
      LinkedListMultimap.Node localNode = this.next;
      this.current = localNode;
      this.previous = localNode;
      this.next = this.next.nextSibling;
      this.nextIndex += 1;
      return (V)this.current.value;
    }
    
    public int nextIndex()
    {
      return this.nextIndex;
    }
    
    public V previous()
    {
      LinkedListMultimap.checkElement(this.previous);
      LinkedListMultimap.Node localNode = this.previous;
      this.current = localNode;
      this.next = localNode;
      this.previous = this.previous.previousSibling;
      this.nextIndex -= 1;
      return (V)this.current.value;
    }
    
    public int previousIndex()
    {
      return this.nextIndex - 1;
    }
    
    public void remove()
    {
      boolean bool;
      if (this.current != null)
      {
        bool = true;
        CollectPreconditions.checkRemove(bool);
        if (this.current == this.next) {
          break label67;
        }
        this.previous = this.current.previousSibling;
        this.nextIndex -= 1;
      }
      for (;;)
      {
        LinkedListMultimap.this.removeNode(this.current);
        this.current = null;
        return;
        bool = false;
        break;
        label67:
        this.next = this.current.nextSibling;
      }
    }
    
    public void set(V paramV)
    {
      if (this.current != null) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkState(bool);
        this.current.value = paramV;
        return;
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/LinkedListMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */