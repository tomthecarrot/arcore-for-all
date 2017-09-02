package okio;

final class Segment
{
  static final int SIZE = 2048;
  final byte[] data;
  int limit;
  Segment next;
  boolean owner;
  int pos;
  Segment prev;
  boolean shared;
  
  Segment()
  {
    this.data = new byte['ࠀ'];
    this.owner = true;
    this.shared = false;
  }
  
  Segment(Segment paramSegment)
  {
    this(paramSegment.data, paramSegment.pos, paramSegment.limit);
    paramSegment.shared = true;
  }
  
  Segment(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.data = paramArrayOfByte;
    this.pos = paramInt1;
    this.limit = paramInt2;
    this.owner = false;
    this.shared = true;
  }
  
  public void compact()
  {
    if (this.prev == this) {
      throw new IllegalStateException();
    }
    if (!this.prev.owner) {}
    for (;;)
    {
      return;
      int j = this.limit - this.pos;
      int k = this.prev.limit;
      if (this.prev.shared) {}
      for (int i = 0; j <= 2048 - k + i; i = this.prev.pos)
      {
        writeTo(this.prev, j);
        pop();
        SegmentPool.recycle(this);
        return;
      }
    }
  }
  
  public Segment pop()
  {
    if (this.next != this) {}
    for (Segment localSegment = this.next;; localSegment = null)
    {
      this.prev.next = this.next;
      this.next.prev = this.prev;
      this.next = null;
      this.prev = null;
      return localSegment;
    }
  }
  
  public Segment push(Segment paramSegment)
  {
    paramSegment.prev = this;
    paramSegment.next = this.next;
    this.next.prev = paramSegment;
    this.next = paramSegment;
    return paramSegment;
  }
  
  public Segment split(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt > this.limit - this.pos)) {
      throw new IllegalArgumentException();
    }
    Segment localSegment = new Segment(this);
    localSegment.limit = (localSegment.pos + paramInt);
    this.pos += paramInt;
    this.prev.push(localSegment);
    return localSegment;
  }
  
  public void writeTo(Segment paramSegment, int paramInt)
  {
    if (!paramSegment.owner) {
      throw new IllegalArgumentException();
    }
    if (paramSegment.limit + paramInt > 2048)
    {
      if (paramSegment.shared) {
        throw new IllegalArgumentException();
      }
      if (paramSegment.limit + paramInt - paramSegment.pos > 2048) {
        throw new IllegalArgumentException();
      }
      System.arraycopy(paramSegment.data, paramSegment.pos, paramSegment.data, 0, paramSegment.limit - paramSegment.pos);
      paramSegment.limit -= paramSegment.pos;
      paramSegment.pos = 0;
    }
    System.arraycopy(this.data, this.pos, paramSegment.data, paramSegment.limit, paramInt);
    paramSegment.limit += paramInt;
    this.pos += paramInt;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/okio/Segment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */