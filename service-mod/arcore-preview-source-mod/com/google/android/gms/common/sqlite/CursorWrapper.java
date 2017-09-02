package com.google.android.gms.common.sqlite;

import android.database.AbstractWindowedCursor;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;

public class CursorWrapper
  extends android.database.CursorWrapper
  implements CrossProcessCursor
{
  private AbstractWindowedCursor zzaUb;
  
  public CursorWrapper(Cursor paramCursor)
  {
    super(paramCursor);
    this.zzaUb = zzb(paramCursor);
  }
  
  static AbstractWindowedCursor zzb(Cursor paramCursor)
  {
    int i = 0;
    while ((i < 10) && ((paramCursor instanceof android.database.CursorWrapper)))
    {
      paramCursor = ((android.database.CursorWrapper)paramCursor).getWrappedCursor();
      i += 1;
    }
    if (!(paramCursor instanceof AbstractWindowedCursor))
    {
      paramCursor = String.valueOf(paramCursor.getClass().getName());
      if (paramCursor.length() != 0) {}
      for (paramCursor = "Unknown type: ".concat(paramCursor);; paramCursor = new String("Unknown type: ")) {
        throw new IllegalArgumentException(paramCursor);
      }
    }
    return (AbstractWindowedCursor)paramCursor;
  }
  
  public void fillWindow(int paramInt, CursorWindow paramCursorWindow)
  {
    this.zzaUb.fillWindow(paramInt, paramCursorWindow);
  }
  
  public CursorWindow getWindow()
  {
    return this.zzaUb.getWindow();
  }
  
  public AbstractWindowedCursor getWrappedCursor()
  {
    return this.zzaUb;
  }
  
  public boolean onMove(int paramInt1, int paramInt2)
  {
    return this.zzaUb.onMove(paramInt1, paramInt2);
  }
  
  public void setWindow(CursorWindow paramCursorWindow)
  {
    this.zzaUb.setWindow(paramCursorWindow);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/sqlite/CursorWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */