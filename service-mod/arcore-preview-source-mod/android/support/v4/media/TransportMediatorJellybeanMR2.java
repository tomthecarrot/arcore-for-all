package android.support.v4.media;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.RemoteControlClient;
import android.media.RemoteControlClient.OnGetPlaybackPositionListener;
import android.media.RemoteControlClient.OnPlaybackPositionUpdateListener;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnWindowAttachListener;
import android.view.ViewTreeObserver.OnWindowFocusChangeListener;

class TransportMediatorJellybeanMR2
{
  AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener()
  {
    public void onAudioFocusChange(int paramAnonymousInt)
    {
      TransportMediatorJellybeanMR2.this.mTransportCallback.handleAudioFocusChange(paramAnonymousInt);
    }
  };
  boolean mAudioFocused;
  final AudioManager mAudioManager;
  final Context mContext;
  boolean mFocused;
  final RemoteControlClient.OnGetPlaybackPositionListener mGetPlaybackPositionListener = new RemoteControlClient.OnGetPlaybackPositionListener()
  {
    public long onGetPlaybackPosition()
    {
      return TransportMediatorJellybeanMR2.this.mTransportCallback.getPlaybackPosition();
    }
  };
  final Intent mIntent;
  final BroadcastReceiver mMediaButtonReceiver = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      try
      {
        paramAnonymousContext = (KeyEvent)paramAnonymousIntent.getParcelableExtra("android.intent.extra.KEY_EVENT");
        TransportMediatorJellybeanMR2.this.mTransportCallback.handleKey(paramAnonymousContext);
        return;
      }
      catch (ClassCastException paramAnonymousContext)
      {
        Log.w("TransportController", paramAnonymousContext);
      }
    }
  };
  PendingIntent mPendingIntent;
  int mPlayState = 0;
  final RemoteControlClient.OnPlaybackPositionUpdateListener mPlaybackPositionUpdateListener = new RemoteControlClient.OnPlaybackPositionUpdateListener()
  {
    public void onPlaybackPositionUpdate(long paramAnonymousLong)
    {
      TransportMediatorJellybeanMR2.this.mTransportCallback.playbackPositionUpdate(paramAnonymousLong);
    }
  };
  final String mReceiverAction;
  final IntentFilter mReceiverFilter;
  RemoteControlClient mRemoteControl;
  final View mTargetView;
  final TransportMediatorCallback mTransportCallback;
  final ViewTreeObserver.OnWindowAttachListener mWindowAttachListener = new ViewTreeObserver.OnWindowAttachListener()
  {
    public void onWindowAttached()
    {
      TransportMediatorJellybeanMR2.this.windowAttached();
    }
    
    public void onWindowDetached()
    {
      TransportMediatorJellybeanMR2.this.windowDetached();
    }
  };
  final ViewTreeObserver.OnWindowFocusChangeListener mWindowFocusListener = new ViewTreeObserver.OnWindowFocusChangeListener()
  {
    public void onWindowFocusChanged(boolean paramAnonymousBoolean)
    {
      if (paramAnonymousBoolean)
      {
        TransportMediatorJellybeanMR2.this.gainFocus();
        return;
      }
      TransportMediatorJellybeanMR2.this.loseFocus();
    }
  };
  
  public TransportMediatorJellybeanMR2(Context paramContext, AudioManager paramAudioManager, View paramView, TransportMediatorCallback paramTransportMediatorCallback)
  {
    this.mContext = paramContext;
    this.mAudioManager = paramAudioManager;
    this.mTargetView = paramView;
    this.mTransportCallback = paramTransportMediatorCallback;
    this.mReceiverAction = (paramContext.getPackageName() + ":transport:" + System.identityHashCode(this));
    this.mIntent = new Intent(this.mReceiverAction);
    this.mIntent.setPackage(paramContext.getPackageName());
    this.mReceiverFilter = new IntentFilter();
    this.mReceiverFilter.addAction(this.mReceiverAction);
    this.mTargetView.getViewTreeObserver().addOnWindowAttachListener(this.mWindowAttachListener);
    this.mTargetView.getViewTreeObserver().addOnWindowFocusChangeListener(this.mWindowFocusListener);
  }
  
  public void destroy()
  {
    windowDetached();
    this.mTargetView.getViewTreeObserver().removeOnWindowAttachListener(this.mWindowAttachListener);
    this.mTargetView.getViewTreeObserver().removeOnWindowFocusChangeListener(this.mWindowFocusListener);
  }
  
  void dropAudioFocus()
  {
    if (this.mAudioFocused)
    {
      this.mAudioFocused = false;
      this.mAudioManager.abandonAudioFocus(this.mAudioFocusChangeListener);
    }
  }
  
  void gainFocus()
  {
    if (!this.mFocused)
    {
      this.mFocused = true;
      this.mAudioManager.registerMediaButtonEventReceiver(this.mPendingIntent);
      this.mAudioManager.registerRemoteControlClient(this.mRemoteControl);
      if (this.mPlayState == 3) {
        takeAudioFocus();
      }
    }
  }
  
  public Object getRemoteControlClient()
  {
    return this.mRemoteControl;
  }
  
  void loseFocus()
  {
    dropAudioFocus();
    if (this.mFocused)
    {
      this.mFocused = false;
      this.mAudioManager.unregisterRemoteControlClient(this.mRemoteControl);
      this.mAudioManager.unregisterMediaButtonEventReceiver(this.mPendingIntent);
    }
  }
  
  public void pausePlaying()
  {
    if (this.mPlayState == 3)
    {
      this.mPlayState = 2;
      this.mRemoteControl.setPlaybackState(2);
    }
    dropAudioFocus();
  }
  
  public void refreshState(boolean paramBoolean, long paramLong, int paramInt)
  {
    RemoteControlClient localRemoteControlClient;
    int i;
    if (this.mRemoteControl != null)
    {
      localRemoteControlClient = this.mRemoteControl;
      if (!paramBoolean) {
        break label47;
      }
      i = 3;
      if (!paramBoolean) {
        break label53;
      }
    }
    label47:
    label53:
    for (float f = 1.0F;; f = 0.0F)
    {
      localRemoteControlClient.setPlaybackState(i, paramLong, f);
      this.mRemoteControl.setTransportControlFlags(paramInt);
      return;
      i = 1;
      break;
    }
  }
  
  public void startPlaying()
  {
    if (this.mPlayState != 3)
    {
      this.mPlayState = 3;
      this.mRemoteControl.setPlaybackState(3);
    }
    if (this.mFocused) {
      takeAudioFocus();
    }
  }
  
  public void stopPlaying()
  {
    if (this.mPlayState != 1)
    {
      this.mPlayState = 1;
      this.mRemoteControl.setPlaybackState(1);
    }
    dropAudioFocus();
  }
  
  void takeAudioFocus()
  {
    if (!this.mAudioFocused)
    {
      this.mAudioFocused = true;
      this.mAudioManager.requestAudioFocus(this.mAudioFocusChangeListener, 3, 1);
    }
  }
  
  void windowAttached()
  {
    this.mContext.registerReceiver(this.mMediaButtonReceiver, this.mReceiverFilter);
    this.mPendingIntent = PendingIntent.getBroadcast(this.mContext, 0, this.mIntent, 268435456);
    this.mRemoteControl = new RemoteControlClient(this.mPendingIntent);
    this.mRemoteControl.setOnGetPlaybackPositionListener(this.mGetPlaybackPositionListener);
    this.mRemoteControl.setPlaybackPositionUpdateListener(this.mPlaybackPositionUpdateListener);
  }
  
  void windowDetached()
  {
    loseFocus();
    if (this.mPendingIntent != null)
    {
      this.mContext.unregisterReceiver(this.mMediaButtonReceiver);
      this.mPendingIntent.cancel();
      this.mPendingIntent = null;
      this.mRemoteControl = null;
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/media/TransportMediatorJellybeanMR2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */