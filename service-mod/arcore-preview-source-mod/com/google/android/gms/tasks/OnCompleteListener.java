package com.google.android.gms.tasks;

import android.support.annotation.NonNull;

public abstract interface OnCompleteListener<TResult>
{
  public abstract void onComplete(@NonNull Task<TResult> paramTask);
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tasks/OnCompleteListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */