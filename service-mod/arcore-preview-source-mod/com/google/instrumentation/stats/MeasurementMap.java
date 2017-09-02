package com.google.instrumentation.stats;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class MeasurementMap
  implements Iterable<MeasurementValue>
{
  private final ArrayList<MeasurementValue> measurements;
  
  private MeasurementMap(ArrayList<MeasurementValue> paramArrayList)
  {
    this.measurements = paramArrayList;
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public static MeasurementMap of(MeasurementDescriptor paramMeasurementDescriptor, double paramDouble)
  {
    return builder().put(paramMeasurementDescriptor, paramDouble).build();
  }
  
  public static MeasurementMap of(MeasurementDescriptor paramMeasurementDescriptor1, double paramDouble1, MeasurementDescriptor paramMeasurementDescriptor2, double paramDouble2)
  {
    return builder().put(paramMeasurementDescriptor1, paramDouble1).put(paramMeasurementDescriptor2, paramDouble2).build();
  }
  
  public static MeasurementMap of(MeasurementDescriptor paramMeasurementDescriptor1, double paramDouble1, MeasurementDescriptor paramMeasurementDescriptor2, double paramDouble2, MeasurementDescriptor paramMeasurementDescriptor3, double paramDouble3)
  {
    return builder().put(paramMeasurementDescriptor1, paramDouble1).put(paramMeasurementDescriptor2, paramDouble2).put(paramMeasurementDescriptor3, paramDouble3).build();
  }
  
  public Iterator<MeasurementValue> iterator()
  {
    return new MeasurementMapIterator(null);
  }
  
  public int size()
  {
    return this.measurements.size();
  }
  
  public static class Builder
  {
    private final ArrayList<MeasurementValue> measurements = new ArrayList();
    
    public MeasurementMap build()
    {
      int j = 0;
      while (j < this.measurements.size())
      {
        String str = ((MeasurementValue)this.measurements.get(j)).getMeasurement().getName();
        int k;
        for (int i = j + 1; i < this.measurements.size(); i = k + 1)
        {
          k = i;
          if (str.equals(((MeasurementValue)this.measurements.get(i)).getMeasurement().getName()))
          {
            this.measurements.remove(i);
            k = i - 1;
          }
        }
        j += 1;
      }
      return new MeasurementMap(this.measurements, null);
    }
    
    public Builder put(MeasurementDescriptor paramMeasurementDescriptor, double paramDouble)
    {
      this.measurements.add(MeasurementValue.create(paramMeasurementDescriptor, paramDouble));
      return this;
    }
  }
  
  private final class MeasurementMapIterator
    implements Iterator<MeasurementValue>
  {
    private final int length = MeasurementMap.this.measurements.size();
    private int position = 0;
    
    private MeasurementMapIterator() {}
    
    public boolean hasNext()
    {
      return this.position < this.length;
    }
    
    public MeasurementValue next()
    {
      if (this.position >= MeasurementMap.this.measurements.size()) {
        throw new NoSuchElementException();
      }
      ArrayList localArrayList = MeasurementMap.this.measurements;
      int i = this.position;
      this.position = (i + 1);
      return (MeasurementValue)localArrayList.get(i);
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/instrumentation/stats/MeasurementMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */