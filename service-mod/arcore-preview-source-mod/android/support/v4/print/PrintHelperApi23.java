package android.support.v4.print;

import android.content.Context;
import android.print.PrintAttributes;
import android.print.PrintAttributes.Builder;

class PrintHelperApi23
  extends PrintHelperApi20
{
  PrintHelperApi23(Context paramContext)
  {
    super(paramContext);
    this.mIsMinMarginsHandlingCorrect = false;
  }
  
  protected PrintAttributes.Builder copyAttributes(PrintAttributes paramPrintAttributes)
  {
    PrintAttributes.Builder localBuilder = super.copyAttributes(paramPrintAttributes);
    if (paramPrintAttributes.getDuplexMode() != 0) {
      localBuilder.setDuplexMode(paramPrintAttributes.getDuplexMode());
    }
    return localBuilder;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/print/PrintHelperApi23.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */