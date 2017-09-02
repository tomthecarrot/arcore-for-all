package com.google.instrumentation.stats;

public final class TagKey
{
  public static final int MAX_LENGTH = 255;
  private final String key;
  
  private TagKey(String paramString)
  {
    this.key = StringUtil.sanitize(paramString);
  }
  
  public static TagKey create(String paramString)
  {
    return new TagKey(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof TagKey)) && (this.key.equals(((TagKey)paramObject).key));
  }
  
  public int hashCode()
  {
    return this.key.hashCode();
  }
  
  public String toString()
  {
    return this.key;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/instrumentation/stats/TagKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */