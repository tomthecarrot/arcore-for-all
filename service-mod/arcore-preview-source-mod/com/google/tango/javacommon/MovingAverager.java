package com.google.tango.javacommon;

public class MovingAverager
{
  private int index = 0;
  private boolean isFull = false;
  private double runningSum;
  private final double[] values;
  private final int windowSize;
  
  public MovingAverager(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Invalid windowSize = " + paramInt);
    }
    this.windowSize = paramInt;
    this.values = new double[paramInt];
  }
  
  public double addValue(double paramDouble)
  {
    if (this.isFull) {
      this.runningSum -= this.values[this.index];
    }
    this.runningSum += paramDouble;
    this.values[this.index] = paramDouble;
    this.index += 1;
    if (this.index >= this.windowSize)
    {
      this.index = 0;
      this.isFull = true;
    }
    return getCurrentAverage();
  }
  
  public double getCurrentAverage()
  {
    double d = this.runningSum;
    if (this.isFull) {}
    for (int i = this.windowSize;; i = this.index) {
      return d / i;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/tango/javacommon/MovingAverager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */