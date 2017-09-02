package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.support.annotation.RequiresPermission;
import android.util.Log;
import com.google.android.gms.iid.InstanceID;
import com.google.android.gms.iid.Rpc;
import com.google.android.gms.iid.zzc;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class GoogleCloudMessaging
{
  public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
  public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
  public static final String INSTANCE_ID_SCOPE = "GCM";
  @Deprecated
  public static final String MESSAGE_TYPE_DELETED = "deleted_messages";
  @Deprecated
  public static final String MESSAGE_TYPE_MESSAGE = "gcm";
  @Deprecated
  public static final String MESSAGE_TYPE_SEND_ERROR = "send_error";
  @Deprecated
  public static final String MESSAGE_TYPE_SEND_EVENT = "send_event";
  public static final String REGISTRATION_ID = "registration_id";
  public static int zzbxr = 5000000;
  public static int zzbxs = 6500000;
  public static int zzbxt = 7000000;
  static GoogleCloudMessaging zzbxu;
  private static final AtomicInteger zzbxx = new AtomicInteger(1);
  private PendingIntent zzbxv;
  private Map<String, Handler> zzbxw = Collections.synchronizedMap(new HashMap());
  private final BlockingQueue<Intent> zzbxy = new LinkedBlockingQueue();
  final Messenger zzbxz = new Messenger(new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if ((paramAnonymousMessage == null) || (!(paramAnonymousMessage.obj instanceof Intent))) {
        Log.w("GCM", "Dropping invalid message");
      }
      paramAnonymousMessage = (Intent)paramAnonymousMessage.obj;
      if ("com.google.android.c2dm.intent.REGISTRATION".equals(paramAnonymousMessage.getAction())) {
        GoogleCloudMessaging.zza(GoogleCloudMessaging.this).add(paramAnonymousMessage);
      }
      while (GoogleCloudMessaging.zza(GoogleCloudMessaging.this, paramAnonymousMessage)) {
        return;
      }
      paramAnonymousMessage.setPackage(GoogleCloudMessaging.zzb(GoogleCloudMessaging.this).getPackageName());
      GoogleCloudMessaging.zzb(GoogleCloudMessaging.this).sendBroadcast(paramAnonymousMessage);
    }
  });
  private Context zzqm;
  
  public static String getGcmPackage(Context paramContext)
  {
    return Rpc.findAppIDPackage(paramContext);
  }
  
  public static int getGcmVersion(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    paramContext = getGcmPackage(paramContext);
    if (paramContext != null) {
      try
      {
        paramContext = localPackageManager.getPackageInfo(paramContext, 0);
        if (paramContext != null)
        {
          int i = paramContext.versionCode;
          return i;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext) {}
    }
    return -1;
  }
  
  public static GoogleCloudMessaging getInstance(Context paramContext)
  {
    try
    {
      if (zzbxu == null)
      {
        zzbxu = new GoogleCloudMessaging();
        zzbxu.zzqm = paramContext.getApplicationContext();
      }
      paramContext = zzbxu;
      return paramContext;
    }
    finally {}
  }
  
  private String zzJo()
  {
    String str1 = String.valueOf("google.rpc");
    String str2 = String.valueOf(String.valueOf(zzbxx.getAndIncrement()));
    if (str2.length() != 0) {
      return str1.concat(str2);
    }
    return new String(str1);
  }
  
  static String zza(Intent paramIntent, String paramString)
    throws IOException
  {
    if (paramIntent == null) {
      throw new IOException("SERVICE_NOT_AVAILABLE");
    }
    paramString = paramIntent.getStringExtra(paramString);
    if (paramString != null) {
      return paramString;
    }
    paramIntent = paramIntent.getStringExtra("error");
    if (paramIntent != null) {
      throw new IOException(paramIntent);
    }
    throw new IOException("SERVICE_NOT_AVAILABLE");
  }
  
  private void zza(String paramString1, String paramString2, long paramLong, int paramInt, Bundle paramBundle)
    throws IOException
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("Missing 'to'");
    }
    String str = getGcmPackage(this.zzqm);
    if (str == null) {
      throw new IOException("SERVICE_NOT_AVAILABLE");
    }
    Object localObject1 = new Intent("com.google.android.gcm.intent.SEND");
    if (paramBundle != null) {
      ((Intent)localObject1).putExtras(paramBundle);
    }
    zzu((Intent)localObject1);
    ((Intent)localObject1).setPackage(str);
    ((Intent)localObject1).putExtra("google.to", paramString1);
    ((Intent)localObject1).putExtra("google.message_id", paramString2);
    ((Intent)localObject1).putExtra("google.ttl", Long.toString(paramLong));
    ((Intent)localObject1).putExtra("google.delay", Integer.toString(paramInt));
    ((Intent)localObject1).putExtra("google.from", zzez(paramString1));
    if (str.contains(".gsf"))
    {
      localObject1 = new Bundle();
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        Object localObject2 = paramBundle.get(str);
        if ((localObject2 instanceof String))
        {
          str = String.valueOf(str);
          if (str.length() != 0) {}
          for (str = "gcm.".concat(str);; str = new String("gcm."))
          {
            ((Bundle)localObject1).putString(str, (String)localObject2);
            break;
          }
        }
      }
      ((Bundle)localObject1).putString("google.to", paramString1);
      ((Bundle)localObject1).putString("google.message_id", paramString2);
      InstanceID.getInstance(this.zzqm).zzb("GCM", "upstream", (Bundle)localObject1);
      return;
    }
    this.zzqm.sendOrderedBroadcast((Intent)localObject1, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
  }
  
  private String zzez(String paramString)
  {
    int i = paramString.indexOf('@');
    String str = paramString;
    if (i > 0) {
      str = paramString.substring(0, i);
    }
    return InstanceID.getInstance(this.zzqm).zzJQ().zzg("", str, "GCM");
  }
  
  private boolean zzt(Intent paramIntent)
  {
    Object localObject2 = paramIntent.getStringExtra("In-Reply-To");
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (paramIntent.hasExtra("error")) {
        localObject1 = paramIntent.getStringExtra("google.message_id");
      }
    }
    if (localObject1 != null)
    {
      localObject1 = (Handler)this.zzbxw.remove(localObject1);
      if (localObject1 != null)
      {
        localObject2 = Message.obtain();
        ((Message)localObject2).obj = paramIntent;
        return ((Handler)localObject1).sendMessage((Message)localObject2);
      }
    }
    return false;
  }
  
  public void close()
  {
    zzbxu = null;
    zza.zzbxg = null;
    zzJp();
  }
  
  public String getMessageType(Intent paramIntent)
  {
    if (!"com.google.android.c2dm.intent.RECEIVE".equals(paramIntent.getAction())) {
      paramIntent = null;
    }
    String str;
    do
    {
      return paramIntent;
      str = paramIntent.getStringExtra("message_type");
      paramIntent = str;
    } while (str != null);
    return "gcm";
  }
  
  @Deprecated
  @RequiresPermission("com.google.android.c2dm.permission.RECEIVE")
  public String register(String... paramVarArgs)
    throws IOException
  {
    String str;
    try
    {
      str = getGcmPackage(this.zzqm);
      if (str == null) {
        throw new IOException("SERVICE_NOT_AVAILABLE");
      }
    }
    finally {}
    paramVarArgs = zzg(paramVarArgs);
    Bundle localBundle = new Bundle();
    if (str.contains(".gsf")) {
      localBundle.putString("legacy.sender", paramVarArgs);
    }
    for (paramVarArgs = InstanceID.getInstance(this.zzqm).getToken(paramVarArgs, "GCM", localBundle);; paramVarArgs = zza(zzR(localBundle), "registration_id"))
    {
      return paramVarArgs;
      localBundle.putString("sender", paramVarArgs);
    }
  }
  
  public Intent rpc(String paramString, Bundle paramBundle, long paramLong)
    throws IOException
  {
    if (Looper.getMainLooper() == Looper.myLooper()) {
      throw new IOException("MAIN_THREAD");
    }
    String str = zzJo();
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    final Intent[] arrayOfIntent = new Intent[1];
    this.zzbxw.put(str, new Handler(Looper.getMainLooper(), new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        if ((paramAnonymousMessage == null) || (!(paramAnonymousMessage.obj instanceof Intent))) {
          return false;
        }
        arrayOfIntent[0] = ((Intent)paramAnonymousMessage.obj);
        localCountDownLatch.countDown();
        return true;
      }
    }));
    if (paramBundle == null) {
      paramBundle = new Bundle();
    }
    for (;;)
    {
      paramBundle.putParcelable("google.messenger", this.zzbxz);
      zzbxu.send(paramString, str, 0L, paramBundle);
      try
      {
        localCountDownLatch.await(paramLong, TimeUnit.MILLISECONDS);
        zzeA(str);
        return arrayOfIntent[0];
      }
      catch (InterruptedException paramString)
      {
        for (;;) {}
      }
    }
  }
  
  @RequiresPermission("com.google.android.c2dm.permission.RECEIVE")
  public void send(String paramString1, String paramString2, long paramLong, Bundle paramBundle)
    throws IOException
  {
    zza(paramString1, paramString2, paramLong, -1, paramBundle);
  }
  
  @RequiresPermission("com.google.android.c2dm.permission.RECEIVE")
  public void send(String paramString1, String paramString2, Bundle paramBundle)
    throws IOException
  {
    send(paramString1, paramString2, -1L, paramBundle);
  }
  
  @RequiresPermission("com.google.android.c2dm.permission.RECEIVE")
  public void sendBatched(String paramString1, String paramString2, int paramInt, Bundle paramBundle)
    throws IOException
  {
    zza(paramString1, paramString2, -1L, paramInt, paramBundle);
  }
  
  public void sendHeartbeat()
  {
    Intent localIntent = new Intent("com.google.android.intent.action.MCS_HEARTBEAT");
    this.zzqm.sendBroadcast(localIntent);
  }
  
  @Deprecated
  @RequiresPermission("com.google.android.c2dm.permission.RECEIVE")
  public void unregister()
    throws IOException
  {
    try
    {
      if (Looper.getMainLooper() == Looper.myLooper()) {
        throw new IOException("MAIN_THREAD");
      }
    }
    finally {}
    InstanceID.getInstance(this.zzqm).deleteInstanceID();
  }
  
  void zzJp()
  {
    try
    {
      if (this.zzbxv != null)
      {
        this.zzbxv.cancel();
        this.zzbxv = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  @Deprecated
  Intent zzR(Bundle paramBundle)
    throws IOException
  {
    if (Looper.getMainLooper() == Looper.myLooper()) {
      throw new IOException("MAIN_THREAD");
    }
    if (getGcmVersion(this.zzqm) < 0) {
      throw new IOException("Google Play Services missing");
    }
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = new Intent("com.google.android.c2dm.intent.REGISTER");
    paramBundle.setPackage(getGcmPackage(this.zzqm));
    zzu(paramBundle);
    paramBundle.putExtra("google.message_id", zzJo());
    paramBundle.putExtras(localBundle);
    paramBundle.putExtra("google.messenger", this.zzbxz);
    this.zzqm.startService(paramBundle);
    try
    {
      paramBundle = (Intent)this.zzbxy.poll(30000L, TimeUnit.MILLISECONDS);
      return paramBundle;
    }
    catch (InterruptedException paramBundle)
    {
      throw new IOException(paramBundle.getMessage());
    }
  }
  
  public void zzeA(String paramString)
  {
    this.zzbxw.remove(paramString);
  }
  
  String zzg(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      throw new IllegalArgumentException("No senderIds");
    }
    StringBuilder localStringBuilder = new StringBuilder(paramVarArgs[0]);
    int i = 1;
    while (i < paramVarArgs.length)
    {
      localStringBuilder.append(',').append(paramVarArgs[i]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  void zzu(Intent paramIntent)
  {
    try
    {
      if (this.zzbxv == null)
      {
        Intent localIntent = new Intent();
        localIntent.setPackage("com.google.example.invalidpackage");
        this.zzbxv = PendingIntent.getBroadcast(this.zzqm, 0, localIntent, 0);
      }
      paramIntent.putExtra("app", this.zzbxv);
      return;
    }
    finally {}
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/gcm/GoogleCloudMessaging.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */