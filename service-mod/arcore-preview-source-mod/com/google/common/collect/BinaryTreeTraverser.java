package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.BitSet;
import java.util.Deque;
import java.util.Iterator;

@Beta
@GwtCompatible(emulated=true)
public abstract class BinaryTreeTraverser<T>
  extends TreeTraverser<T>
{
  private static <T> void pushIfPresent(Deque<T> paramDeque, Optional<T> paramOptional)
  {
    if (paramOptional.isPresent()) {
      paramDeque.addLast(paramOptional.get());
    }
  }
  
  public final Iterable<T> children(final T paramT)
  {
    Preconditions.checkNotNull(paramT);
    new FluentIterable()
    {
      public Iterator<T> iterator()
      {
        new AbstractIterator()
        {
          boolean doneLeft;
          boolean doneRight;
          
          protected T computeNext()
          {
            Optional localOptional;
            if (!this.doneLeft)
            {
              this.doneLeft = true;
              localOptional = BinaryTreeTraverser.this.leftChild(BinaryTreeTraverser.1.this.val$root);
              if (localOptional.isPresent()) {
                return (T)localOptional.get();
              }
            }
            if (!this.doneRight)
            {
              this.doneRight = true;
              localOptional = BinaryTreeTraverser.this.rightChild(BinaryTreeTraverser.1.this.val$root);
              if (localOptional.isPresent()) {
                return (T)localOptional.get();
              }
            }
            return (T)endOfData();
          }
        };
      }
    };
  }
  
  public final FluentIterable<T> inOrderTraversal(final T paramT)
  {
    Preconditions.checkNotNull(paramT);
    new FluentIterable()
    {
      public UnmodifiableIterator<T> iterator()
      {
        return new BinaryTreeTraverser.InOrderIterator(BinaryTreeTraverser.this, paramT);
      }
    };
  }
  
  public abstract Optional<T> leftChild(T paramT);
  
  UnmodifiableIterator<T> postOrderIterator(T paramT)
  {
    return new PostOrderIterator(paramT);
  }
  
  UnmodifiableIterator<T> preOrderIterator(T paramT)
  {
    return new PreOrderIterator(paramT);
  }
  
  public abstract Optional<T> rightChild(T paramT);
  
  private final class InOrderIterator
    extends AbstractIterator<T>
  {
    private final BitSet hasExpandedLeft = new BitSet();
    private final Deque<T> stack = new ArrayDeque();
    
    InOrderIterator()
    {
      Object localObject;
      this.stack.addLast(localObject);
    }
    
    protected T computeNext()
    {
      while (!this.stack.isEmpty())
      {
        Object localObject = this.stack.getLast();
        if (this.hasExpandedLeft.get(this.stack.size() - 1))
        {
          this.stack.removeLast();
          this.hasExpandedLeft.clear(this.stack.size());
          BinaryTreeTraverser.pushIfPresent(this.stack, BinaryTreeTraverser.this.rightChild(localObject));
          return (T)localObject;
        }
        this.hasExpandedLeft.set(this.stack.size() - 1);
        BinaryTreeTraverser.pushIfPresent(this.stack, BinaryTreeTraverser.this.leftChild(localObject));
      }
      return (T)endOfData();
    }
  }
  
  private final class PostOrderIterator
    extends UnmodifiableIterator<T>
  {
    private final BitSet hasExpanded;
    private final Deque<T> stack = new ArrayDeque();
    
    PostOrderIterator()
    {
      Object localObject;
      this.stack.addLast(localObject);
      this.hasExpanded = new BitSet();
    }
    
    public boolean hasNext()
    {
      return !this.stack.isEmpty();
    }
    
    public T next()
    {
      for (;;)
      {
        Object localObject = this.stack.getLast();
        if (this.hasExpanded.get(this.stack.size() - 1))
        {
          this.stack.removeLast();
          this.hasExpanded.clear(this.stack.size());
          return (T)localObject;
        }
        this.hasExpanded.set(this.stack.size() - 1);
        BinaryTreeTraverser.pushIfPresent(this.stack, BinaryTreeTraverser.this.rightChild(localObject));
        BinaryTreeTraverser.pushIfPresent(this.stack, BinaryTreeTraverser.this.leftChild(localObject));
      }
    }
  }
  
  private final class PreOrderIterator
    extends UnmodifiableIterator<T>
    implements PeekingIterator<T>
  {
    private final Deque<T> stack = new ArrayDeque();
    
    PreOrderIterator()
    {
      Object localObject;
      this.stack.addLast(localObject);
    }
    
    public boolean hasNext()
    {
      return !this.stack.isEmpty();
    }
    
    public T next()
    {
      Object localObject = this.stack.removeLast();
      BinaryTreeTraverser.pushIfPresent(this.stack, BinaryTreeTraverser.this.rightChild(localObject));
      BinaryTreeTraverser.pushIfPresent(this.stack, BinaryTreeTraverser.this.leftChild(localObject));
      return (T)localObject;
    }
    
    public T peek()
    {
      return (T)this.stack.getLast();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/common/collect/BinaryTreeTraverser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */