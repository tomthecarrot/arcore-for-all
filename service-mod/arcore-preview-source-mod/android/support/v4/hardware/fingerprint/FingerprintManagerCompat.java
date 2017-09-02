package android.support.v4.hardware.fingerprint;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.os.CancellationSignal;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

public final class FingerprintManagerCompat
{
  static final FingerprintManagerCompatImpl IMPL = new LegacyFingerprintManagerCompatImpl();
  private Context mContext;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      IMPL = new Api23FingerprintManagerCompatImpl();
      return;
    }
  }
  
  private FingerprintManagerCompat(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static FingerprintManagerCompat from(Context paramContext)
  {
    return new FingerprintManagerCompat(paramContext);
  }
  
  public void authenticate(@Nullable CryptoObject paramCryptoObject, int paramInt, @Nullable CancellationSignal paramCancellationSignal, @NonNull AuthenticationCallback paramAuthenticationCallback, @Nullable Handler paramHandler)
  {
    IMPL.authenticate(this.mContext, paramCryptoObject, paramInt, paramCancellationSignal, paramAuthenticationCallback, paramHandler);
  }
  
  public boolean hasEnrolledFingerprints()
  {
    return IMPL.hasEnrolledFingerprints(this.mContext);
  }
  
  public boolean isHardwareDetected()
  {
    return IMPL.isHardwareDetected(this.mContext);
  }
  
  private static class Api23FingerprintManagerCompatImpl
    implements FingerprintManagerCompat.FingerprintManagerCompatImpl
  {
    private static FingerprintManagerCompat.CryptoObject unwrapCryptoObject(FingerprintManagerCompatApi23.CryptoObject paramCryptoObject)
    {
      if (paramCryptoObject == null) {}
      do
      {
        return null;
        if (paramCryptoObject.getCipher() != null) {
          return new FingerprintManagerCompat.CryptoObject(paramCryptoObject.getCipher());
        }
        if (paramCryptoObject.getSignature() != null) {
          return new FingerprintManagerCompat.CryptoObject(paramCryptoObject.getSignature());
        }
      } while (paramCryptoObject.getMac() == null);
      return new FingerprintManagerCompat.CryptoObject(paramCryptoObject.getMac());
    }
    
    private static FingerprintManagerCompatApi23.AuthenticationCallback wrapCallback(FingerprintManagerCompat.AuthenticationCallback paramAuthenticationCallback)
    {
      new FingerprintManagerCompatApi23.AuthenticationCallback()
      {
        public void onAuthenticationError(int paramAnonymousInt, CharSequence paramAnonymousCharSequence)
        {
          this.val$callback.onAuthenticationError(paramAnonymousInt, paramAnonymousCharSequence);
        }
        
        public void onAuthenticationFailed()
        {
          this.val$callback.onAuthenticationFailed();
        }
        
        public void onAuthenticationHelp(int paramAnonymousInt, CharSequence paramAnonymousCharSequence)
        {
          this.val$callback.onAuthenticationHelp(paramAnonymousInt, paramAnonymousCharSequence);
        }
        
        public void onAuthenticationSucceeded(FingerprintManagerCompatApi23.AuthenticationResultInternal paramAnonymousAuthenticationResultInternal)
        {
          this.val$callback.onAuthenticationSucceeded(new FingerprintManagerCompat.AuthenticationResult(FingerprintManagerCompat.Api23FingerprintManagerCompatImpl.unwrapCryptoObject(paramAnonymousAuthenticationResultInternal.getCryptoObject())));
        }
      };
    }
    
    private static FingerprintManagerCompatApi23.CryptoObject wrapCryptoObject(FingerprintManagerCompat.CryptoObject paramCryptoObject)
    {
      if (paramCryptoObject == null) {}
      do
      {
        return null;
        if (paramCryptoObject.getCipher() != null) {
          return new FingerprintManagerCompatApi23.CryptoObject(paramCryptoObject.getCipher());
        }
        if (paramCryptoObject.getSignature() != null) {
          return new FingerprintManagerCompatApi23.CryptoObject(paramCryptoObject.getSignature());
        }
      } while (paramCryptoObject.getMac() == null);
      return new FingerprintManagerCompatApi23.CryptoObject(paramCryptoObject.getMac());
    }
    
    public void authenticate(Context paramContext, FingerprintManagerCompat.CryptoObject paramCryptoObject, int paramInt, CancellationSignal paramCancellationSignal, FingerprintManagerCompat.AuthenticationCallback paramAuthenticationCallback, Handler paramHandler)
    {
      FingerprintManagerCompatApi23.CryptoObject localCryptoObject = wrapCryptoObject(paramCryptoObject);
      if (paramCancellationSignal != null) {}
      for (paramCryptoObject = paramCancellationSignal.getCancellationSignalObject();; paramCryptoObject = null)
      {
        FingerprintManagerCompatApi23.authenticate(paramContext, localCryptoObject, paramInt, paramCryptoObject, wrapCallback(paramAuthenticationCallback), paramHandler);
        return;
      }
    }
    
    public boolean hasEnrolledFingerprints(Context paramContext)
    {
      return FingerprintManagerCompatApi23.hasEnrolledFingerprints(paramContext);
    }
    
    public boolean isHardwareDetected(Context paramContext)
    {
      return FingerprintManagerCompatApi23.isHardwareDetected(paramContext);
    }
  }
  
  public static abstract class AuthenticationCallback
  {
    public void onAuthenticationError(int paramInt, CharSequence paramCharSequence) {}
    
    public void onAuthenticationFailed() {}
    
    public void onAuthenticationHelp(int paramInt, CharSequence paramCharSequence) {}
    
    public void onAuthenticationSucceeded(FingerprintManagerCompat.AuthenticationResult paramAuthenticationResult) {}
  }
  
  public static final class AuthenticationResult
  {
    private FingerprintManagerCompat.CryptoObject mCryptoObject;
    
    public AuthenticationResult(FingerprintManagerCompat.CryptoObject paramCryptoObject)
    {
      this.mCryptoObject = paramCryptoObject;
    }
    
    public FingerprintManagerCompat.CryptoObject getCryptoObject()
    {
      return this.mCryptoObject;
    }
  }
  
  public static class CryptoObject
  {
    private final Cipher mCipher;
    private final Mac mMac;
    private final Signature mSignature;
    
    public CryptoObject(Signature paramSignature)
    {
      this.mSignature = paramSignature;
      this.mCipher = null;
      this.mMac = null;
    }
    
    public CryptoObject(Cipher paramCipher)
    {
      this.mCipher = paramCipher;
      this.mSignature = null;
      this.mMac = null;
    }
    
    public CryptoObject(Mac paramMac)
    {
      this.mMac = paramMac;
      this.mCipher = null;
      this.mSignature = null;
    }
    
    public Cipher getCipher()
    {
      return this.mCipher;
    }
    
    public Mac getMac()
    {
      return this.mMac;
    }
    
    public Signature getSignature()
    {
      return this.mSignature;
    }
  }
  
  private static abstract interface FingerprintManagerCompatImpl
  {
    public abstract void authenticate(Context paramContext, FingerprintManagerCompat.CryptoObject paramCryptoObject, int paramInt, CancellationSignal paramCancellationSignal, FingerprintManagerCompat.AuthenticationCallback paramAuthenticationCallback, Handler paramHandler);
    
    public abstract boolean hasEnrolledFingerprints(Context paramContext);
    
    public abstract boolean isHardwareDetected(Context paramContext);
  }
  
  private static class LegacyFingerprintManagerCompatImpl
    implements FingerprintManagerCompat.FingerprintManagerCompatImpl
  {
    public void authenticate(Context paramContext, FingerprintManagerCompat.CryptoObject paramCryptoObject, int paramInt, CancellationSignal paramCancellationSignal, FingerprintManagerCompat.AuthenticationCallback paramAuthenticationCallback, Handler paramHandler) {}
    
    public boolean hasEnrolledFingerprints(Context paramContext)
    {
      return false;
    }
    
    public boolean isHardwareDetected(Context paramContext)
    {
      return false;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/hardware/fingerprint/FingerprintManagerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */