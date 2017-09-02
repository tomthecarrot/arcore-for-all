package com.google.instrumentation.stats;

public final class TagValue
{
  public static final int MAX_LENGTH = 255;
  private final String value;
  
  private TagValue(String paramString)
  {
    this.value = StringUtil.sanitize(paramString);
  }
  
  public static TagValue create(String paramString)
  {
    return new TagValue(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof TagValue)) && (this.value.equals(((TagValue)paramObject).value));
  }
  
  public int hashCode()
  {
    return this.value.hashCode();
  }
  
  public String toString()
  {
    return this.value;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/instrumentation/stats/TagValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */