package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

@Beta
@GwtCompatible(emulated=true)
public abstract class TreeTraverser<T>
{
  public final FluentIterable<T> breadthFirstTraversal(final T paramT)
  {
    Preconditions.checkNotNull(paramT);
    new FluentIterable()
    {
      public UnmodifiableIterator<T> iterator()
      {
        return new TreeTraverser.BreadthFirstIterator(TreeTraverser.this, paramT);
      }
    };
  }
  
  public abstract Iterable<T> children(T paramT);
  
  UnmodifiableIterator<T> postOrderIterator(T paramT)
  {
    return new PostOrderIterator(paramT);
  }
  
  public final FluentIterable<T> postOrderTraversal(final T paramT)
  {
    Preconditions.checkNotNull(paramT);
    new FluentIterable()
    {
      public UnmodifiableIterator<T> iterator()
      {
        return TreeTraverser.this.postOrderIterator(paramT);
      }
    };
  }
  
  UnmodifiableIterator<T> preOrderIterator(T paramT)
  {
    return new PreOrderIterator(paramT);
  }
  
  public final FluentIterable<T> preOrderTraversal(final T paramT)
  {
    Preconditions.checkNotNull(paramT);
    new FluentIterable()
    {
      public UnmodifiableIterator<T> iterator()
      {
        return TreeTraverser.this.preOrderIterator(paramT);
      }
    };
  }
  
  private final class BreadthFirstIterator
    extends UnmodifiableIterator<T>
    implements PeekingIterator<T>
  {
    private final Queue<T> queue = new ArrayDeque();
    
    BreadthFirstIterator()
    {
      Object localObject;
      this.queue.add(localObject);
    }
    
    public boolean hasNext()
    {
      return !this.queue.isEmpty();
    }
    
    public T next()
    {
      Object localObject = this.queue.remove();
      Iterables.addAll(this.queue, TreeTraverser.this.children(localObject));
      return (T)localObject;
    }
    
    public T peek()
    {
      return (T)this.queue.element();
    }
  }
  
  private final class PostOrderIterator
    extends AbstractIterator<T>
  {
    private final ArrayDeque<TreeTraverser.PostOrderNode<T>> stack = new ArrayDeque();
    
    PostOrderIterator()
    {
      Object localObject;
      this.stack.addLast(expand(localObject));
    }
    
    private TreeTraverser.PostOrderNode<T> expand(T paramT)
    {
      return new TreeTraverser.PostOrderNode(paramT, TreeTraverser.this.children(paramT).iterator());
    }
    
    protected T computeNext()
    {
      while (!this.stack.isEmpty())
      {
        Object localObject = (TreeTraverser.PostOrderNode)this.stack.getLast();
        if (((TreeTraverser.PostOrderNode)localObject).childIterator.hasNext())
        {
          localObject = ((TreeTraverser.PostOrderNode)localObject).childIterator.next();
          this.stack.addLast(expand(localObject));
        }
        else
        {
          this.stack.removeLast();
          return (T)((TreeTraverser.PostOrderNode)localObject).root;
        }
      }
      return (T)endOfData();
    }
  }
  
  private static final class PostOrderNode<T>
  {
    final Iterator<T> childIterator;
    final T root;
    
    PostOrderNode(T paramT, Iterator<T> paramIterator)
    {
      this.root = Preconditions.checkNotNull(paramT);
      this.childIterator = ((Iterator)Preconditions.checkNotNull(paramIterator));
    }
  }
  
  private final class PreOrderIterator
    extends UnmodifiableIterator<T>
  {
    private final Deque<Iterator<T>> stack = new ArrayDeque();
    
    PreOrderIterator()
    {
      Object localObject;
      this.stack.addLast(Iterators.singletonIterator(Preconditions.checkNotNull(localObject)));
    }
    
    public boolean hasNext()
    {
      return !this.stack.isEmpty();
    }
    
    public T next()
    {
      Iterator localIterator = (Iterator)this.stack.getLast();
      Object localObject = Preconditions.checkNotNull(localIterator.next());
      if (!localIterator.hasNext()) {
        this.stack.removeLast();
      }
      localIterator = TreeTraverser.this.children(localObject).iterator();
      if (localIterator.hasNext()) {
        this.stack.addLast(localIterator);
      }
      return (T)localObject;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/TreeTraverser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */