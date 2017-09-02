package okio;

final class SegmentPool
{
  static final long MAX_SIZE = 65536L;
  static long byteCount;
  static Segment next;
  
  static void recycle(Segment paramSegment)
  {
    if ((paramSegment.next != null) || (paramSegment.prev != null)) {
      throw new IllegalArgumentException();
    }
    if (paramSegment.shared) {
      return;
    }
    try
    {
      if (byteCount + 2048L > 65536L) {
        return;
      }
    }
    finally {}
    byteCount += 2048L;
    paramSegment.next = next;
    paramSegment.limit = 0;
    paramSegment.pos = 0;
    next = paramSegment;
  }
  
  static Segment take()
  {
    try
    {
      if (next != null)
      {
        Segment localSegment = next;
        next = localSegment.next;
        localSegment.next = null;
        byteCount -= 2048L;
        return localSegment;
      }
      return new Segment();
    }
    finally {}
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/okio/SegmentPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */