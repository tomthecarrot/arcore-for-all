package android.support.v4.print;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.CancellationSignal.OnCancelListener;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintAttributes.Builder;
import android.print.PrintAttributes.MediaSize;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentAdapter.LayoutResultCallback;
import android.print.PrintDocumentAdapter.WriteResultCallback;
import android.print.PrintDocumentInfo.Builder;
import android.print.PrintManager;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

class PrintHelperKitkat
{
  public static final int COLOR_MODE_COLOR = 2;
  public static final int COLOR_MODE_MONOCHROME = 1;
  private static final String LOG_TAG = "PrintHelperKitkat";
  private static final int MAX_PRINT_SIZE = 3500;
  public static final int ORIENTATION_LANDSCAPE = 1;
  public static final int ORIENTATION_PORTRAIT = 2;
  public static final int SCALE_MODE_FILL = 2;
  public static final int SCALE_MODE_FIT = 1;
  int mColorMode = 2;
  final Context mContext;
  BitmapFactory.Options mDecodeOptions = null;
  protected boolean mIsMinMarginsHandlingCorrect = true;
  private final Object mLock = new Object();
  int mOrientation;
  protected boolean mPrintActivityRespectsOrientation = true;
  int mScaleMode = 2;
  
  PrintHelperKitkat(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private Bitmap convertBitmapForColorMode(Bitmap paramBitmap, int paramInt)
  {
    if (paramInt != 1) {
      return paramBitmap;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    ColorMatrix localColorMatrix = new ColorMatrix();
    localColorMatrix.setSaturation(0.0F);
    localPaint.setColorFilter(new ColorMatrixColorFilter(localColorMatrix));
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
    localCanvas.setBitmap(null);
    return localBitmap;
  }
  
  private Matrix getMatrix(int paramInt1, int paramInt2, RectF paramRectF, int paramInt3)
  {
    Matrix localMatrix = new Matrix();
    float f = paramRectF.width() / paramInt1;
    if (paramInt3 == 2) {}
    for (f = Math.max(f, paramRectF.height() / paramInt2);; f = Math.min(f, paramRectF.height() / paramInt2))
    {
      localMatrix.postScale(f, f);
      localMatrix.postTranslate((paramRectF.width() - paramInt1 * f) / 2.0F, (paramRectF.height() - paramInt2 * f) / 2.0F);
      return localMatrix;
    }
  }
  
  private static boolean isPortrait(Bitmap paramBitmap)
  {
    return paramBitmap.getWidth() <= paramBitmap.getHeight();
  }
  
  private Bitmap loadBitmap(Uri paramUri, BitmapFactory.Options paramOptions)
    throws FileNotFoundException
  {
    if ((paramUri == null) || (this.mContext == null)) {
      throw new IllegalArgumentException("bad argument to loadBitmap");
    }
    localUri = null;
    try
    {
      paramUri = this.mContext.getContentResolver().openInputStream(paramUri);
      localUri = paramUri;
      paramOptions = BitmapFactory.decodeStream(paramUri, null, paramOptions);
      if (paramUri != null) {}
      try
      {
        paramUri.close();
        return paramOptions;
      }
      catch (IOException paramUri)
      {
        Log.w("PrintHelperKitkat", "close fail ", paramUri);
        return paramOptions;
      }
      try
      {
        localUri.close();
        throw paramUri;
      }
      catch (IOException paramOptions)
      {
        for (;;)
        {
          Log.w("PrintHelperKitkat", "close fail ", paramOptions);
        }
      }
    }
    finally
    {
      if (localUri == null) {}
    }
  }
  
  private Bitmap loadConstrainedBitmap(Uri arg1, int paramInt)
    throws FileNotFoundException
  {
    if ((paramInt <= 0) || (??? == null) || (this.mContext == null)) {
      throw new IllegalArgumentException("bad argument to getScaledBitmap");
    }
    ??? = new BitmapFactory.Options();
    ((BitmapFactory.Options)???).inJustDecodeBounds = true;
    loadBitmap(???, (BitmapFactory.Options)???);
    int k = ((BitmapFactory.Options)???).outWidth;
    int m = ((BitmapFactory.Options)???).outHeight;
    if ((k <= 0) || (m <= 0)) {}
    int i;
    do
    {
      return null;
      int j = Math.max(k, m);
      i = 1;
      while (j > paramInt)
      {
        j >>>= 1;
        i <<= 1;
      }
    } while ((i <= 0) || (Math.min(k, m) / i <= 0));
    BitmapFactory.Options localOptions;
    synchronized (this.mLock)
    {
      this.mDecodeOptions = new BitmapFactory.Options();
      this.mDecodeOptions.inMutable = true;
      this.mDecodeOptions.inSampleSize = i;
      localOptions = this.mDecodeOptions;
    }
    try
    {
      ??? = loadBitmap(???, localOptions);
      synchronized (this.mLock)
      {
        this.mDecodeOptions = null;
        return (Bitmap)???;
      }
      ??? = finally;
      throw ???;
    }
    finally {}
  }
  
  /* Error */
  private void writeBitmap(PrintAttributes paramPrintAttributes, int paramInt, Bitmap paramBitmap, ParcelFileDescriptor paramParcelFileDescriptor, PrintDocumentAdapter.WriteResultCallback paramWriteResultCallback)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 59	android/support/v4/print/PrintHelperKitkat:mIsMinMarginsHandlingCorrect	Z
    //   4: ifeq +168 -> 172
    //   7: aload_1
    //   8: astore 6
    //   10: new 237	android/print/pdf/PrintedPdfDocument
    //   13: dup
    //   14: aload_0
    //   15: getfield 61	android/support/v4/print/PrintHelperKitkat:mContext	Landroid/content/Context;
    //   18: aload 6
    //   20: invokespecial 240	android/print/pdf/PrintedPdfDocument:<init>	(Landroid/content/Context;Landroid/print/PrintAttributes;)V
    //   23: astore 7
    //   25: aload_0
    //   26: aload_3
    //   27: aload 6
    //   29: invokevirtual 245	android/print/PrintAttributes:getColorMode	()I
    //   32: invokespecial 247	android/support/v4/print/PrintHelperKitkat:convertBitmapForColorMode	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   35: astore 6
    //   37: aload 7
    //   39: iconst_1
    //   40: invokevirtual 251	android/print/pdf/PrintedPdfDocument:startPage	(I)Landroid/graphics/pdf/PdfDocument$Page;
    //   43: astore 8
    //   45: aload_0
    //   46: getfield 59	android/support/v4/print/PrintHelperKitkat:mIsMinMarginsHandlingCorrect	Z
    //   49: ifeq +150 -> 199
    //   52: new 143	android/graphics/RectF
    //   55: dup
    //   56: aload 8
    //   58: invokevirtual 257	android/graphics/pdf/PdfDocument$Page:getInfo	()Landroid/graphics/pdf/PdfDocument$PageInfo;
    //   61: invokevirtual 263	android/graphics/pdf/PdfDocument$PageInfo:getContentRect	()Landroid/graphics/Rect;
    //   64: invokespecial 266	android/graphics/RectF:<init>	(Landroid/graphics/Rect;)V
    //   67: astore_1
    //   68: aload_0
    //   69: aload 6
    //   71: invokevirtual 92	android/graphics/Bitmap:getWidth	()I
    //   74: aload 6
    //   76: invokevirtual 95	android/graphics/Bitmap:getHeight	()I
    //   79: aload_1
    //   80: iload_2
    //   81: invokespecial 268	android/support/v4/print/PrintHelperKitkat:getMatrix	(IILandroid/graphics/RectF;I)Landroid/graphics/Matrix;
    //   84: astore 9
    //   86: aload_0
    //   87: getfield 59	android/support/v4/print/PrintHelperKitkat:mIsMinMarginsHandlingCorrect	Z
    //   90: ifeq +191 -> 281
    //   93: aload 8
    //   95: invokevirtual 272	android/graphics/pdf/PdfDocument$Page:getCanvas	()Landroid/graphics/Canvas;
    //   98: aload 6
    //   100: aload 9
    //   102: aconst_null
    //   103: invokevirtual 275	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V
    //   106: aload 7
    //   108: aload 8
    //   110: invokevirtual 279	android/print/pdf/PrintedPdfDocument:finishPage	(Landroid/graphics/pdf/PdfDocument$Page;)V
    //   113: aload 7
    //   115: new 281	java/io/FileOutputStream
    //   118: dup
    //   119: aload 4
    //   121: invokevirtual 287	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   124: invokespecial 290	java/io/FileOutputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   127: invokevirtual 294	android/print/pdf/PrintedPdfDocument:writeTo	(Ljava/io/OutputStream;)V
    //   130: aload 5
    //   132: iconst_1
    //   133: anewarray 296	android/print/PageRange
    //   136: dup
    //   137: iconst_0
    //   138: getstatic 300	android/print/PageRange:ALL_PAGES	Landroid/print/PageRange;
    //   141: aastore
    //   142: invokevirtual 306	android/print/PrintDocumentAdapter$WriteResultCallback:onWriteFinished	([Landroid/print/PageRange;)V
    //   145: aload 7
    //   147: invokevirtual 307	android/print/pdf/PrintedPdfDocument:close	()V
    //   150: aload 4
    //   152: ifnull +8 -> 160
    //   155: aload 4
    //   157: invokevirtual 308	android/os/ParcelFileDescriptor:close	()V
    //   160: aload 6
    //   162: aload_3
    //   163: if_acmpeq +8 -> 171
    //   166: aload 6
    //   168: invokevirtual 311	android/graphics/Bitmap:recycle	()V
    //   171: return
    //   172: aload_0
    //   173: aload_1
    //   174: invokevirtual 315	android/support/v4/print/PrintHelperKitkat:copyAttributes	(Landroid/print/PrintAttributes;)Landroid/print/PrintAttributes$Builder;
    //   177: new 317	android/print/PrintAttributes$Margins
    //   180: dup
    //   181: iconst_0
    //   182: iconst_0
    //   183: iconst_0
    //   184: iconst_0
    //   185: invokespecial 320	android/print/PrintAttributes$Margins:<init>	(IIII)V
    //   188: invokevirtual 326	android/print/PrintAttributes$Builder:setMinMargins	(Landroid/print/PrintAttributes$Margins;)Landroid/print/PrintAttributes$Builder;
    //   191: invokevirtual 330	android/print/PrintAttributes$Builder:build	()Landroid/print/PrintAttributes;
    //   194: astore 6
    //   196: goto -186 -> 10
    //   199: new 237	android/print/pdf/PrintedPdfDocument
    //   202: dup
    //   203: aload_0
    //   204: getfield 61	android/support/v4/print/PrintHelperKitkat:mContext	Landroid/content/Context;
    //   207: aload_1
    //   208: invokespecial 240	android/print/pdf/PrintedPdfDocument:<init>	(Landroid/content/Context;Landroid/print/PrintAttributes;)V
    //   211: astore 9
    //   213: aload 9
    //   215: iconst_1
    //   216: invokevirtual 251	android/print/pdf/PrintedPdfDocument:startPage	(I)Landroid/graphics/pdf/PdfDocument$Page;
    //   219: astore 10
    //   221: new 143	android/graphics/RectF
    //   224: dup
    //   225: aload 10
    //   227: invokevirtual 257	android/graphics/pdf/PdfDocument$Page:getInfo	()Landroid/graphics/pdf/PdfDocument$PageInfo;
    //   230: invokevirtual 263	android/graphics/pdf/PdfDocument$PageInfo:getContentRect	()Landroid/graphics/Rect;
    //   233: invokespecial 266	android/graphics/RectF:<init>	(Landroid/graphics/Rect;)V
    //   236: astore_1
    //   237: aload 9
    //   239: aload 10
    //   241: invokevirtual 279	android/print/pdf/PrintedPdfDocument:finishPage	(Landroid/graphics/pdf/PdfDocument$Page;)V
    //   244: aload 9
    //   246: invokevirtual 307	android/print/pdf/PrintedPdfDocument:close	()V
    //   249: goto -181 -> 68
    //   252: astore_1
    //   253: aload 7
    //   255: invokevirtual 307	android/print/pdf/PrintedPdfDocument:close	()V
    //   258: aload 4
    //   260: ifnull +8 -> 268
    //   263: aload 4
    //   265: invokevirtual 308	android/os/ParcelFileDescriptor:close	()V
    //   268: aload 6
    //   270: aload_3
    //   271: if_acmpeq +8 -> 279
    //   274: aload 6
    //   276: invokevirtual 311	android/graphics/Bitmap:recycle	()V
    //   279: aload_1
    //   280: athrow
    //   281: aload 9
    //   283: aload_1
    //   284: getfield 334	android/graphics/RectF:left	F
    //   287: aload_1
    //   288: getfield 337	android/graphics/RectF:top	F
    //   291: invokevirtual 163	android/graphics/Matrix:postTranslate	(FF)Z
    //   294: pop
    //   295: aload 8
    //   297: invokevirtual 272	android/graphics/pdf/PdfDocument$Page:getCanvas	()Landroid/graphics/Canvas;
    //   300: aload_1
    //   301: invokevirtual 341	android/graphics/Canvas:clipRect	(Landroid/graphics/RectF;)Z
    //   304: pop
    //   305: goto -212 -> 93
    //   308: astore_1
    //   309: ldc 24
    //   311: ldc_w 343
    //   314: aload_1
    //   315: invokestatic 346	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   318: pop
    //   319: aload 5
    //   321: aconst_null
    //   322: invokevirtual 350	android/print/PrintDocumentAdapter$WriteResultCallback:onWriteFailed	(Ljava/lang/CharSequence;)V
    //   325: goto -180 -> 145
    //   328: astore_1
    //   329: goto -169 -> 160
    //   332: astore 4
    //   334: goto -66 -> 268
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	337	0	this	PrintHelperKitkat
    //   0	337	1	paramPrintAttributes	PrintAttributes
    //   0	337	2	paramInt	int
    //   0	337	3	paramBitmap	Bitmap
    //   0	337	4	paramParcelFileDescriptor	ParcelFileDescriptor
    //   0	337	5	paramWriteResultCallback	PrintDocumentAdapter.WriteResultCallback
    //   8	267	6	localObject1	Object
    //   23	231	7	localPrintedPdfDocument	android.print.pdf.PrintedPdfDocument
    //   43	253	8	localPage1	android.graphics.pdf.PdfDocument.Page
    //   84	198	9	localObject2	Object
    //   219	21	10	localPage2	android.graphics.pdf.PdfDocument.Page
    // Exception table:
    //   from	to	target	type
    //   37	68	252	finally
    //   68	93	252	finally
    //   93	113	252	finally
    //   113	145	252	finally
    //   199	249	252	finally
    //   281	305	252	finally
    //   309	325	252	finally
    //   113	145	308	java/io/IOException
    //   155	160	328	java/io/IOException
    //   263	268	332	java/io/IOException
  }
  
  protected PrintAttributes.Builder copyAttributes(PrintAttributes paramPrintAttributes)
  {
    PrintAttributes.Builder localBuilder = new PrintAttributes.Builder().setMediaSize(paramPrintAttributes.getMediaSize()).setResolution(paramPrintAttributes.getResolution()).setMinMargins(paramPrintAttributes.getMinMargins());
    if (paramPrintAttributes.getColorMode() != 0) {
      localBuilder.setColorMode(paramPrintAttributes.getColorMode());
    }
    return localBuilder;
  }
  
  public int getColorMode()
  {
    return this.mColorMode;
  }
  
  public int getOrientation()
  {
    if (this.mOrientation == 0) {
      return 1;
    }
    return this.mOrientation;
  }
  
  public int getScaleMode()
  {
    return this.mScaleMode;
  }
  
  public void printBitmap(final String paramString, final Bitmap paramBitmap, final OnPrintFinishCallback paramOnPrintFinishCallback)
  {
    if (paramBitmap == null) {
      return;
    }
    final int i = this.mScaleMode;
    PrintManager localPrintManager = (PrintManager)this.mContext.getSystemService("print");
    if (isPortrait(paramBitmap)) {}
    for (Object localObject = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;; localObject = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE)
    {
      localObject = new PrintAttributes.Builder().setMediaSize((PrintAttributes.MediaSize)localObject).setColorMode(this.mColorMode).build();
      localPrintManager.print(paramString, new PrintDocumentAdapter()
      {
        private PrintAttributes mAttributes;
        
        public void onFinish()
        {
          if (paramOnPrintFinishCallback != null) {
            paramOnPrintFinishCallback.onFinish();
          }
        }
        
        public void onLayout(PrintAttributes paramAnonymousPrintAttributes1, PrintAttributes paramAnonymousPrintAttributes2, CancellationSignal paramAnonymousCancellationSignal, PrintDocumentAdapter.LayoutResultCallback paramAnonymousLayoutResultCallback, Bundle paramAnonymousBundle)
        {
          boolean bool = true;
          this.mAttributes = paramAnonymousPrintAttributes2;
          paramAnonymousCancellationSignal = new PrintDocumentInfo.Builder(paramString).setContentType(1).setPageCount(1).build();
          if (!paramAnonymousPrintAttributes2.equals(paramAnonymousPrintAttributes1)) {}
          for (;;)
          {
            paramAnonymousLayoutResultCallback.onLayoutFinished(paramAnonymousCancellationSignal, bool);
            return;
            bool = false;
          }
        }
        
        public void onWrite(PageRange[] paramAnonymousArrayOfPageRange, ParcelFileDescriptor paramAnonymousParcelFileDescriptor, CancellationSignal paramAnonymousCancellationSignal, PrintDocumentAdapter.WriteResultCallback paramAnonymousWriteResultCallback)
        {
          PrintHelperKitkat.this.writeBitmap(this.mAttributes, i, paramBitmap, paramAnonymousParcelFileDescriptor, paramAnonymousWriteResultCallback);
        }
      }, (PrintAttributes)localObject);
      return;
    }
  }
  
  public void printBitmap(final String paramString, final Uri paramUri, final OnPrintFinishCallback paramOnPrintFinishCallback)
    throws FileNotFoundException
  {
    paramUri = new PrintDocumentAdapter()
    {
      private PrintAttributes mAttributes;
      Bitmap mBitmap = null;
      AsyncTask<Uri, Boolean, Bitmap> mLoadBitmap;
      
      private void cancelLoad()
      {
        synchronized (PrintHelperKitkat.this.mLock)
        {
          if (PrintHelperKitkat.this.mDecodeOptions != null)
          {
            PrintHelperKitkat.this.mDecodeOptions.requestCancelDecode();
            PrintHelperKitkat.this.mDecodeOptions = null;
          }
          return;
        }
      }
      
      public void onFinish()
      {
        super.onFinish();
        cancelLoad();
        if (this.mLoadBitmap != null) {
          this.mLoadBitmap.cancel(true);
        }
        if (paramOnPrintFinishCallback != null) {
          paramOnPrintFinishCallback.onFinish();
        }
        if (this.mBitmap != null)
        {
          this.mBitmap.recycle();
          this.mBitmap = null;
        }
      }
      
      public void onLayout(final PrintAttributes paramAnonymousPrintAttributes1, final PrintAttributes paramAnonymousPrintAttributes2, final CancellationSignal paramAnonymousCancellationSignal, final PrintDocumentAdapter.LayoutResultCallback paramAnonymousLayoutResultCallback, Bundle paramAnonymousBundle)
      {
        boolean bool = true;
        try
        {
          this.mAttributes = paramAnonymousPrintAttributes2;
          if (paramAnonymousCancellationSignal.isCanceled())
          {
            paramAnonymousLayoutResultCallback.onLayoutCancelled();
            return;
          }
        }
        finally {}
        if (this.mBitmap != null)
        {
          paramAnonymousCancellationSignal = new PrintDocumentInfo.Builder(paramString).setContentType(1).setPageCount(1).build();
          if (!paramAnonymousPrintAttributes2.equals(paramAnonymousPrintAttributes1)) {}
          for (;;)
          {
            paramAnonymousLayoutResultCallback.onLayoutFinished(paramAnonymousCancellationSignal, bool);
            return;
            bool = false;
          }
        }
        this.mLoadBitmap = new AsyncTask()
        {
          protected Bitmap doInBackground(Uri... paramAnonymous2VarArgs)
          {
            try
            {
              paramAnonymous2VarArgs = PrintHelperKitkat.this.loadConstrainedBitmap(PrintHelperKitkat.2.this.val$imageFile, 3500);
              return paramAnonymous2VarArgs;
            }
            catch (FileNotFoundException paramAnonymous2VarArgs) {}
            return null;
          }
          
          protected void onCancelled(Bitmap paramAnonymous2Bitmap)
          {
            paramAnonymousLayoutResultCallback.onLayoutCancelled();
            PrintHelperKitkat.2.this.mLoadBitmap = null;
          }
          
          protected void onPostExecute(Bitmap paramAnonymous2Bitmap)
          {
            super.onPostExecute(paramAnonymous2Bitmap);
            Object localObject = paramAnonymous2Bitmap;
            if (paramAnonymous2Bitmap != null) {
              if (PrintHelperKitkat.this.mPrintActivityRespectsOrientation)
              {
                localObject = paramAnonymous2Bitmap;
                if (PrintHelperKitkat.this.mOrientation != 0) {
                  break label108;
                }
              }
            }
            for (;;)
            {
              try
              {
                PrintAttributes.MediaSize localMediaSize = PrintHelperKitkat.2.this.mAttributes.getMediaSize();
                localObject = paramAnonymous2Bitmap;
                if (localMediaSize != null)
                {
                  localObject = paramAnonymous2Bitmap;
                  if (localMediaSize.isPortrait() != PrintHelperKitkat.isPortrait(paramAnonymous2Bitmap))
                  {
                    localObject = new Matrix();
                    ((Matrix)localObject).postRotate(90.0F);
                    localObject = Bitmap.createBitmap(paramAnonymous2Bitmap, 0, 0, paramAnonymous2Bitmap.getWidth(), paramAnonymous2Bitmap.getHeight(), (Matrix)localObject, true);
                  }
                }
                label108:
                PrintHelperKitkat.2.this.mBitmap = ((Bitmap)localObject);
                if (localObject == null) {
                  break label190;
                }
                paramAnonymous2Bitmap = new PrintDocumentInfo.Builder(PrintHelperKitkat.2.this.val$jobName).setContentType(1).setPageCount(1).build();
                if (!paramAnonymousPrintAttributes2.equals(paramAnonymousPrintAttributes1))
                {
                  bool = true;
                  paramAnonymousLayoutResultCallback.onLayoutFinished(paramAnonymous2Bitmap, bool);
                  PrintHelperKitkat.2.this.mLoadBitmap = null;
                  return;
                }
              }
              finally {}
              boolean bool = false;
              continue;
              label190:
              paramAnonymousLayoutResultCallback.onLayoutFailed(null);
            }
          }
          
          protected void onPreExecute()
          {
            paramAnonymousCancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener()
            {
              public void onCancel()
              {
                PrintHelperKitkat.2.this.cancelLoad();
                PrintHelperKitkat.2.1.this.cancel(false);
              }
            });
          }
        }.execute(new Uri[0]);
      }
      
      public void onWrite(PageRange[] paramAnonymousArrayOfPageRange, ParcelFileDescriptor paramAnonymousParcelFileDescriptor, CancellationSignal paramAnonymousCancellationSignal, PrintDocumentAdapter.WriteResultCallback paramAnonymousWriteResultCallback)
      {
        PrintHelperKitkat.this.writeBitmap(this.mAttributes, this.val$fittingMode, this.mBitmap, paramAnonymousParcelFileDescriptor, paramAnonymousWriteResultCallback);
      }
    };
    paramOnPrintFinishCallback = (PrintManager)this.mContext.getSystemService("print");
    PrintAttributes.Builder localBuilder = new PrintAttributes.Builder();
    localBuilder.setColorMode(this.mColorMode);
    if ((this.mOrientation == 1) || (this.mOrientation == 0)) {
      localBuilder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
    }
    for (;;)
    {
      paramOnPrintFinishCallback.print(paramString, paramUri, localBuilder.build());
      return;
      if (this.mOrientation == 2) {
        localBuilder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
      }
    }
  }
  
  public void setColorMode(int paramInt)
  {
    this.mColorMode = paramInt;
  }
  
  public void setOrientation(int paramInt)
  {
    this.mOrientation = paramInt;
  }
  
  public void setScaleMode(int paramInt)
  {
    this.mScaleMode = paramInt;
  }
  
  public static abstract interface OnPrintFinishCallback
  {
    public abstract void onFinish();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/print/PrintHelperKitkat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */