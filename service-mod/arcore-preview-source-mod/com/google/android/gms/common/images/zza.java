package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzc;
import com.google.android.gms.internal.zzabb;
import com.google.android.gms.internal.zzabc;
import com.google.android.gms.internal.zzabd;
import java.lang.ref.WeakReference;

public abstract class zza
{
  final zza zzaQA;
  protected int zzaQB = 0;
  protected int zzaQC = 0;
  protected boolean zzaQD = false;
  private boolean zzaQE = true;
  private boolean zzaQF = false;
  private boolean zzaQG = true;
  
  public zza(Uri paramUri, int paramInt)
  {
    this.zzaQA = new zza(paramUri);
    this.zzaQC = paramInt;
  }
  
  private Drawable zza(Context paramContext, zzabd paramzzabd, int paramInt)
  {
    return paramContext.getResources().getDrawable(paramInt);
  }
  
  protected zzabb zza(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    if (paramDrawable1 != null)
    {
      localDrawable = paramDrawable1;
      if (!(paramDrawable1 instanceof zzabb)) {}
    }
    for (Drawable localDrawable = ((zzabb)paramDrawable1).zzzl();; localDrawable = null) {
      return new zzabb(localDrawable, paramDrawable2);
    }
  }
  
  void zza(Context paramContext, Bitmap paramBitmap, boolean paramBoolean)
  {
    zzc.zzz(paramBitmap);
    zza(new BitmapDrawable(paramContext.getResources(), paramBitmap), paramBoolean, false, true);
  }
  
  void zza(Context paramContext, zzabd paramzzabd)
  {
    if (this.zzaQG) {
      zza(null, false, true, false);
    }
  }
  
  void zza(Context paramContext, zzabd paramzzabd, boolean paramBoolean)
  {
    Drawable localDrawable = null;
    if (this.zzaQC != 0) {
      localDrawable = zza(paramContext, paramzzabd, this.zzaQC);
    }
    zza(localDrawable, paramBoolean, false, false);
  }
  
  protected abstract void zza(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  protected boolean zze(boolean paramBoolean1, boolean paramBoolean2)
  {
    return (this.zzaQE) && (!paramBoolean2) && (!paramBoolean1);
  }
  
  public void zzfS(int paramInt)
  {
    this.zzaQC = paramInt;
  }
  
  static final class zza
  {
    public final Uri uri;
    
    public zza(Uri paramUri)
    {
      this.uri = paramUri;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof zza)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      return zzaa.equal(((zza)paramObject).uri, this.uri);
    }
    
    public int hashCode()
    {
      return zzaa.hashCode(new Object[] { this.uri });
    }
  }
  
  public static final class zzb
    extends zza
  {
    private WeakReference<ImageView> zzaQH;
    
    public zzb(ImageView paramImageView, int paramInt)
    {
      super(paramInt);
      zzc.zzz(paramImageView);
      this.zzaQH = new WeakReference(paramImageView);
    }
    
    public zzb(ImageView paramImageView, Uri paramUri)
    {
      super(0);
      zzc.zzz(paramImageView);
      this.zzaQH = new WeakReference(paramImageView);
    }
    
    private void zza(ImageView paramImageView, Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      if ((!paramBoolean2) && (!paramBoolean3)) {}
      for (int i = 1; (i != 0) && ((paramImageView instanceof zzabc)); i = 0)
      {
        int j = ((zzabc)paramImageView).zzzn();
        if ((this.zzaQC == 0) || (j != this.zzaQC)) {
          break;
        }
        return;
      }
      paramBoolean1 = zze(paramBoolean1, paramBoolean2);
      if (paramBoolean1) {
        paramDrawable = zza(paramImageView.getDrawable(), paramDrawable);
      }
      for (;;)
      {
        paramImageView.setImageDrawable(paramDrawable);
        zzabc localzzabc;
        if ((paramImageView instanceof zzabc))
        {
          localzzabc = (zzabc)paramImageView;
          if (!paramBoolean3) {
            break label149;
          }
          paramImageView = this.zzaQA.uri;
          label110:
          localzzabc.zzu(paramImageView);
          if (i == 0) {
            break label154;
          }
        }
        label149:
        label154:
        for (i = this.zzaQC;; i = 0)
        {
          localzzabc.zzfU(i);
          if (!paramBoolean1) {
            break;
          }
          ((zzabb)paramDrawable).startTransition(250);
          return;
          paramImageView = null;
          break label110;
        }
      }
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof zzb)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      Object localObject = (zzb)paramObject;
      paramObject = (ImageView)this.zzaQH.get();
      localObject = (ImageView)((zzb)localObject).zzaQH.get();
      if ((localObject != null) && (paramObject != null) && (zzaa.equal(localObject, paramObject))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public int hashCode()
    {
      return 0;
    }
    
    protected void zza(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      ImageView localImageView = (ImageView)this.zzaQH.get();
      if (localImageView != null) {
        zza(localImageView, paramDrawable, paramBoolean1, paramBoolean2, paramBoolean3);
      }
    }
  }
  
  public static final class zzc
    extends zza
  {
    private WeakReference<ImageManager.OnImageLoadedListener> zzaQI;
    
    public zzc(ImageManager.OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri)
    {
      super(0);
      zzc.zzz(paramOnImageLoadedListener);
      this.zzaQI = new WeakReference(paramOnImageLoadedListener);
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof zzc)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      paramObject = (zzc)paramObject;
      ImageManager.OnImageLoadedListener localOnImageLoadedListener1 = (ImageManager.OnImageLoadedListener)this.zzaQI.get();
      ImageManager.OnImageLoadedListener localOnImageLoadedListener2 = (ImageManager.OnImageLoadedListener)((zzc)paramObject).zzaQI.get();
      if ((localOnImageLoadedListener2 != null) && (localOnImageLoadedListener1 != null) && (zzaa.equal(localOnImageLoadedListener2, localOnImageLoadedListener1)) && (zzaa.equal(((zzc)paramObject).zzaQA, this.zzaQA))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public int hashCode()
    {
      return zzaa.hashCode(new Object[] { this.zzaQA });
    }
    
    protected void zza(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      if (!paramBoolean2)
      {
        ImageManager.OnImageLoadedListener localOnImageLoadedListener = (ImageManager.OnImageLoadedListener)this.zzaQI.get();
        if (localOnImageLoadedListener != null) {
          localOnImageLoadedListener.onImageLoaded(this.zzaQA.uri, paramDrawable, paramBoolean3);
        }
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/common/images/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */