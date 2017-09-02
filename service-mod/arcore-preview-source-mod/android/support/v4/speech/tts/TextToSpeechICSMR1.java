package android.support.v4.speech.tts;

import android.os.Build.VERSION;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnUtteranceCompletedListener;
import android.speech.tts.UtteranceProgressListener;
import java.util.Locale;
import java.util.Set;

class TextToSpeechICSMR1
{
  public static final String KEY_FEATURE_EMBEDDED_SYNTHESIS = "embeddedTts";
  public static final String KEY_FEATURE_NETWORK_SYNTHESIS = "networkTts";
  
  static Set<String> getFeatures(TextToSpeech paramTextToSpeech, Locale paramLocale)
  {
    if (Build.VERSION.SDK_INT >= 15) {
      return paramTextToSpeech.getFeatures(paramLocale);
    }
    return null;
  }
  
  static void setUtteranceProgressListener(TextToSpeech paramTextToSpeech, UtteranceProgressListenerICSMR1 paramUtteranceProgressListenerICSMR1)
  {
    if (Build.VERSION.SDK_INT >= 15)
    {
      paramTextToSpeech.setOnUtteranceProgressListener(new UtteranceProgressListener()
      {
        public void onDone(String paramAnonymousString)
        {
          this.val$listener.onDone(paramAnonymousString);
        }
        
        public void onError(String paramAnonymousString)
        {
          this.val$listener.onError(paramAnonymousString);
        }
        
        public void onStart(String paramAnonymousString)
        {
          this.val$listener.onStart(paramAnonymousString);
        }
      });
      return;
    }
    paramTextToSpeech.setOnUtteranceCompletedListener(new TextToSpeech.OnUtteranceCompletedListener()
    {
      public void onUtteranceCompleted(String paramAnonymousString)
      {
        this.val$listener.onStart(paramAnonymousString);
        this.val$listener.onDone(paramAnonymousString);
      }
    });
  }
  
  static abstract interface UtteranceProgressListenerICSMR1
  {
    public abstract void onDone(String paramString);
    
    public abstract void onError(String paramString);
    
    public abstract void onStart(String paramString);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/speech/tts/TextToSpeechICSMR1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */