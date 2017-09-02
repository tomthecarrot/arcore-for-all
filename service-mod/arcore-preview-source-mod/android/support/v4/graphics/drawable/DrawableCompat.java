package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class DrawableCompat
{
  static final DrawableImpl IMPL = new BaseDrawableImpl();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 23)
    {
      IMPL = new MDrawableImpl();
      return;
    }
    if (i >= 21)
    {
      IMPL = new LollipopDrawableImpl();
      return;
    }
    if (i >= 19)
    {
      IMPL = new KitKatDrawableImpl();
      return;
    }
    if (i >= 17)
    {
      IMPL = new JellybeanMr1DrawableImpl();
      return;
    }
    if (i >= 11)
    {
      IMPL = new HoneycombDrawableImpl();
      return;
    }
    if (i >= 5)
    {
      IMPL = new EclairDrawableImpl();
      return;
    }
  }
  
  public static void applyTheme(Drawable paramDrawable, Resources.Theme paramTheme)
  {
    IMPL.applyTheme(paramDrawable, paramTheme);
  }
  
  public static boolean canApplyTheme(Drawable paramDrawable)
  {
    return IMPL.canApplyTheme(paramDrawable);
  }
  
  public static int getAlpha(@NonNull Drawable paramDrawable)
  {
    return IMPL.getAlpha(paramDrawable);
  }
  
  public static ColorFilter getColorFilter(Drawable paramDrawable)
  {
    return IMPL.getColorFilter(paramDrawable);
  }
  
  public static int getLayoutDirection(@NonNull Drawable paramDrawable)
  {
    return IMPL.getLayoutDirection(paramDrawable);
  }
  
  public static void inflate(Drawable paramDrawable, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    IMPL.inflate(paramDrawable, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
  }
  
  public static boolean isAutoMirrored(@NonNull Drawable paramDrawable)
  {
    return IMPL.isAutoMirrored(paramDrawable);
  }
  
  public static void jumpToCurrentState(@NonNull Drawable paramDrawable)
  {
    IMPL.jumpToCurrentState(paramDrawable);
  }
  
  public static void setAutoMirrored(@NonNull Drawable paramDrawable, boolean paramBoolean)
  {
    IMPL.setAutoMirrored(paramDrawable, paramBoolean);
  }
  
  public static void setHotspot(@NonNull Drawable paramDrawable, float paramFloat1, float paramFloat2)
  {
    IMPL.setHotspot(paramDrawable, paramFloat1, paramFloat2);
  }
  
  public static void setHotspotBounds(@NonNull Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    IMPL.setHotspotBounds(paramDrawable, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static boolean setLayoutDirection(@NonNull Drawable paramDrawable, int paramInt)
  {
    return IMPL.setLayoutDirection(paramDrawable, paramInt);
  }
  
  public static void setTint(@NonNull Drawable paramDrawable, @ColorInt int paramInt)
  {
    IMPL.setTint(paramDrawable, paramInt);
  }
  
  public static void setTintList(@NonNull Drawable paramDrawable, @Nullable ColorStateList paramColorStateList)
  {
    IMPL.setTintList(paramDrawable, paramColorStateList);
  }
  
  public static void setTintMode(@NonNull Drawable paramDrawable, @Nullable PorterDuff.Mode paramMode)
  {
    IMPL.setTintMode(paramDrawable, paramMode);
  }
  
  public static <T extends Drawable> T unwrap(@NonNull Drawable paramDrawable)
  {
    Drawable localDrawable = paramDrawable;
    if ((paramDrawable instanceof DrawableWrapper)) {
      localDrawable = ((DrawableWrapper)paramDrawable).getWrappedDrawable();
    }
    return localDrawable;
  }
  
  public static Drawable wrap(@NonNull Drawable paramDrawable)
  {
    return IMPL.wrap(paramDrawable);
  }
  
  static class BaseDrawableImpl
    implements DrawableCompat.DrawableImpl
  {
    public void applyTheme(Drawable paramDrawable, Resources.Theme paramTheme) {}
    
    public boolean canApplyTheme(Drawable paramDrawable)
    {
      return false;
    }
    
    public int getAlpha(Drawable paramDrawable)
    {
      return 0;
    }
    
    public ColorFilter getColorFilter(Drawable paramDrawable)
    {
      return null;
    }
    
    public int getLayoutDirection(Drawable paramDrawable)
    {
      return 0;
    }
    
    public void inflate(Drawable paramDrawable, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
      throws IOException, XmlPullParserException
    {
      DrawableCompatBase.inflate(paramDrawable, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    }
    
    public boolean isAutoMirrored(Drawable paramDrawable)
    {
      return false;
    }
    
    public void jumpToCurrentState(Drawable paramDrawable) {}
    
    public void setAutoMirrored(Drawable paramDrawable, boolean paramBoolean) {}
    
    public void setHotspot(Drawable paramDrawable, float paramFloat1, float paramFloat2) {}
    
    public void setHotspotBounds(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
    
    public boolean setLayoutDirection(Drawable paramDrawable, int paramInt)
    {
      return false;
    }
    
    public void setTint(Drawable paramDrawable, int paramInt)
    {
      DrawableCompatBase.setTint(paramDrawable, paramInt);
    }
    
    public void setTintList(Drawable paramDrawable, ColorStateList paramColorStateList)
    {
      DrawableCompatBase.setTintList(paramDrawable, paramColorStateList);
    }
    
    public void setTintMode(Drawable paramDrawable, PorterDuff.Mode paramMode)
    {
      DrawableCompatBase.setTintMode(paramDrawable, paramMode);
    }
    
    public Drawable wrap(Drawable paramDrawable)
    {
      return DrawableCompatBase.wrapForTinting(paramDrawable);
    }
  }
  
  static abstract interface DrawableImpl
  {
    public abstract void applyTheme(Drawable paramDrawable, Resources.Theme paramTheme);
    
    public abstract boolean canApplyTheme(Drawable paramDrawable);
    
    public abstract int getAlpha(Drawable paramDrawable);
    
    public abstract ColorFilter getColorFilter(Drawable paramDrawable);
    
    public abstract int getLayoutDirection(Drawable paramDrawable);
    
    public abstract void inflate(Drawable paramDrawable, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
      throws IOException, XmlPullParserException;
    
    public abstract boolean isAutoMirrored(Drawable paramDrawable);
    
    public abstract void jumpToCurrentState(Drawable paramDrawable);
    
    public abstract void setAutoMirrored(Drawable paramDrawable, boolean paramBoolean);
    
    public abstract void setHotspot(Drawable paramDrawable, float paramFloat1, float paramFloat2);
    
    public abstract void setHotspotBounds(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract boolean setLayoutDirection(Drawable paramDrawable, int paramInt);
    
    public abstract void setTint(Drawable paramDrawable, int paramInt);
    
    public abstract void setTintList(Drawable paramDrawable, ColorStateList paramColorStateList);
    
    public abstract void setTintMode(Drawable paramDrawable, PorterDuff.Mode paramMode);
    
    public abstract Drawable wrap(Drawable paramDrawable);
  }
  
  static class EclairDrawableImpl
    extends DrawableCompat.BaseDrawableImpl
  {
    public Drawable wrap(Drawable paramDrawable)
    {
      return DrawableCompatEclair.wrapForTinting(paramDrawable);
    }
  }
  
  static class HoneycombDrawableImpl
    extends DrawableCompat.EclairDrawableImpl
  {
    public void jumpToCurrentState(Drawable paramDrawable)
    {
      DrawableCompatHoneycomb.jumpToCurrentState(paramDrawable);
    }
    
    public Drawable wrap(Drawable paramDrawable)
    {
      return DrawableCompatHoneycomb.wrapForTinting(paramDrawable);
    }
  }
  
  static class JellybeanMr1DrawableImpl
    extends DrawableCompat.HoneycombDrawableImpl
  {
    public int getLayoutDirection(Drawable paramDrawable)
    {
      int i = DrawableCompatJellybeanMr1.getLayoutDirection(paramDrawable);
      if (i >= 0) {
        return i;
      }
      return 0;
    }
    
    public boolean setLayoutDirection(Drawable paramDrawable, int paramInt)
    {
      return DrawableCompatJellybeanMr1.setLayoutDirection(paramDrawable, paramInt);
    }
  }
  
  static class KitKatDrawableImpl
    extends DrawableCompat.JellybeanMr1DrawableImpl
  {
    public int getAlpha(Drawable paramDrawable)
    {
      return DrawableCompatKitKat.getAlpha(paramDrawable);
    }
    
    public boolean isAutoMirrored(Drawable paramDrawable)
    {
      return DrawableCompatKitKat.isAutoMirrored(paramDrawable);
    }
    
    public void setAutoMirrored(Drawable paramDrawable, boolean paramBoolean)
    {
      DrawableCompatKitKat.setAutoMirrored(paramDrawable, paramBoolean);
    }
    
    public Drawable wrap(Drawable paramDrawable)
    {
      return DrawableCompatKitKat.wrapForTinting(paramDrawable);
    }
  }
  
  static class LollipopDrawableImpl
    extends DrawableCompat.KitKatDrawableImpl
  {
    public void applyTheme(Drawable paramDrawable, Resources.Theme paramTheme)
    {
      DrawableCompatLollipop.applyTheme(paramDrawable, paramTheme);
    }
    
    public boolean canApplyTheme(Drawable paramDrawable)
    {
      return DrawableCompatLollipop.canApplyTheme(paramDrawable);
    }
    
    public ColorFilter getColorFilter(Drawable paramDrawable)
    {
      return DrawableCompatLollipop.getColorFilter(paramDrawable);
    }
    
    public void inflate(Drawable paramDrawable, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
      throws IOException, XmlPullParserException
    {
      DrawableCompatLollipop.inflate(paramDrawable, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    }
    
    public void setHotspot(Drawable paramDrawable, float paramFloat1, float paramFloat2)
    {
      DrawableCompatLollipop.setHotspot(paramDrawable, paramFloat1, paramFloat2);
    }
    
    public void setHotspotBounds(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      DrawableCompatLollipop.setHotspotBounds(paramDrawable, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public void setTint(Drawable paramDrawable, int paramInt)
    {
      DrawableCompatLollipop.setTint(paramDrawable, paramInt);
    }
    
    public void setTintList(Drawable paramDrawable, ColorStateList paramColorStateList)
    {
      DrawableCompatLollipop.setTintList(paramDrawable, paramColorStateList);
    }
    
    public void setTintMode(Drawable paramDrawable, PorterDuff.Mode paramMode)
    {
      DrawableCompatLollipop.setTintMode(paramDrawable, paramMode);
    }
    
    public Drawable wrap(Drawable paramDrawable)
    {
      return DrawableCompatLollipop.wrapForTinting(paramDrawable);
    }
  }
  
  static class MDrawableImpl
    extends DrawableCompat.LollipopDrawableImpl
  {
    public int getLayoutDirection(Drawable paramDrawable)
    {
      return DrawableCompatApi23.getLayoutDirection(paramDrawable);
    }
    
    public boolean setLayoutDirection(Drawable paramDrawable, int paramInt)
    {
      return DrawableCompatApi23.setLayoutDirection(paramDrawable, paramInt);
    }
    
    public Drawable wrap(Drawable paramDrawable)
    {
      return paramDrawable;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/graphics/drawable/DrawableCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */