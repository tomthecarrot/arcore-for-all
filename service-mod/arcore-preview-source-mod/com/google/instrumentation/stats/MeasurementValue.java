package com.google.instrumentation.stats;

public class MeasurementValue
{
  private final MeasurementDescriptor name;
  private final double value;
  
  private MeasurementValue(MeasurementDescriptor paramMeasurementDescriptor, double paramDouble)
  {
    this.name = paramMeasurementDescriptor;
    this.value = paramDouble;
  }
  
  public static MeasurementValue create(MeasurementDescriptor paramMeasurementDescriptor, double paramDouble)
  {
    return new MeasurementValue(paramMeasurementDescriptor, paramDouble);
  }
  
  public MeasurementDescriptor getMeasurement()
  {
    return this.name;
  }
  
  public double getValue()
  {
    return this.value;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/instrumentation/stats/MeasurementValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */