package com.google.instrumentation.stats;

public final class Tag
{
  private final TagKey key;
  private final TagValue value;
  
  private Tag(TagKey paramTagKey, TagValue paramTagValue)
  {
    this.key = paramTagKey;
    this.value = paramTagValue;
  }
  
  public static Tag create(TagKey paramTagKey, TagValue paramTagValue)
  {
    return new Tag(paramTagKey, paramTagValue);
  }
  
  public TagKey getKey()
  {
    return this.key;
  }
  
  public TagValue getValue()
  {
    return this.value;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/instrumentation/stats/Tag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */