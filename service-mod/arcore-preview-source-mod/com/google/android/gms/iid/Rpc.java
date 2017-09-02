package com.google.android.gms.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import java.io.IOException;
import java.security.KeyPair;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Rpc
{
  public static final String PARAM_APP_VER = "app_ver";
  public static final String PARAM_APP_VER_NAME = "app_ver_name";
  public static final String PARAM_CLIENT_VER = "cliv";
  public static final String PARAM_GMS_VER = "gmsv";
  public static final String PARAM_INSTANCE_ID = "appid";
  public static final String PARAM_OS_VER = "osv";
  public static final String PARAM_PUBLIC_KEY = "pub2";
  public static final String PARAM_SIGNATURE = "sig";
  static String zzbAS = null;
  static int zzbAT = 0;
  static int zzbAU = 0;
  static int zzbAV = 0;
  Map<String, Object> zzbAW = new HashMap();
  Messenger zzbAX;
  MessengerCompat zzbAY;
  long zzbAZ;
  long zzbBa;
  int zzbBb;
  int zzbBc;
  long zzbBd;
  PendingIntent zzbxv;
  Messenger zzbxz;
  Context zzqm;
  
  public Rpc(Context paramContext)
  {
    this.zzqm = paramContext;
  }
  
  public static String findAppIDPackage(Context paramContext)
  {
    if (zzbAS != null) {
      return zzbAS;
    }
    zzbAT = Process.myUid();
    paramContext = paramContext.getPackageManager();
    Object localObject1 = paramContext.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0).iterator();
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ResolveInfo)((Iterator)localObject1).next();
        if (paramContext.checkPermission("com.google.android.c2dm.permission.RECEIVE", ((ResolveInfo)localObject2).serviceInfo.packageName) != 0) {}
      }
      try
      {
        localObject3 = paramContext.getApplicationInfo(((ResolveInfo)localObject2).serviceInfo.packageName, 0);
        int i = ((ApplicationInfo)localObject3).uid;
        Log.w("InstanceID/Rpc", 17 + "Found " + i);
        zzbAU = ((ApplicationInfo)localObject3).uid;
        zzbAS = ((ResolveInfo)localObject2).serviceInfo.packageName;
        localObject2 = zzbAS;
        return (String)localObject2;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException2) {}
      Object localObject2 = String.valueOf(((ResolveInfo)localObject2).serviceInfo.packageName);
      Object localObject3 = String.valueOf("com.google.android.c2dm.intent.REGISTER");
      Log.w("InstanceID/Rpc", String.valueOf(localObject2).length() + 56 + String.valueOf(localObject3).length() + "Possible malicious package " + (String)localObject2 + " declares " + (String)localObject3 + " without permission");
      continue;
      Log.w("InstanceID/Rpc", "Failed to resolve REGISTER intent, falling back");
      try
      {
        localObject1 = paramContext.getApplicationInfo("com.google.android.gms", 0);
        zzbAS = ((ApplicationInfo)localObject1).packageName;
        zzbAU = ((ApplicationInfo)localObject1).uid;
        localObject1 = zzbAS;
        return (String)localObject1;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException1)
      {
        try
        {
          paramContext = paramContext.getApplicationInfo("com.google.android.gsf", 0);
          zzbAS = paramContext.packageName;
          zzbAU = paramContext.uid;
          paramContext = zzbAS;
          return paramContext;
        }
        catch (PackageManager.NameNotFoundException paramContext)
        {
          Log.w("InstanceID/Rpc", "Both Google Play Services and legacy GSF package are missing");
          return null;
        }
      }
    }
  }
  
  public static String nextId()
  {
    try
    {
      int i = zzbAV;
      zzbAV = i + 1;
      String str = Integer.toString(i);
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void zzP(Object paramObject)
  {
    synchronized (getClass())
    {
      Iterator localIterator = this.zzbAW.keySet().iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = this.zzbAW.get(str);
        this.zzbAW.put(str, paramObject);
        zzg(localObject, paramObject);
      }
    }
  }
  
  /* Error */
  static String zza(KeyPair paramKeyPair, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc -19
    //   2: aload_1
    //   3: invokestatic 243	android/text/TextUtils:join	(Ljava/lang/CharSequence;[Ljava/lang/Object;)Ljava/lang/String;
    //   6: ldc -11
    //   8: invokevirtual 249	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   11: astore_1
    //   12: aload_0
    //   13: invokevirtual 255	java/security/KeyPair:getPrivate	()Ljava/security/PrivateKey;
    //   16: astore_2
    //   17: aload_2
    //   18: instanceof 257
    //   21: ifeq +45 -> 66
    //   24: ldc_w 259
    //   27: astore_0
    //   28: aload_0
    //   29: invokestatic 265	java/security/Signature:getInstance	(Ljava/lang/String;)Ljava/security/Signature;
    //   32: astore_0
    //   33: aload_0
    //   34: aload_2
    //   35: invokevirtual 269	java/security/Signature:initSign	(Ljava/security/PrivateKey;)V
    //   38: aload_0
    //   39: aload_1
    //   40: invokevirtual 273	java/security/Signature:update	([B)V
    //   43: aload_0
    //   44: invokevirtual 277	java/security/Signature:sign	()[B
    //   47: invokestatic 283	com/google/android/gms/iid/InstanceID:zzB	([B)Ljava/lang/String;
    //   50: astore_0
    //   51: aload_0
    //   52: areturn
    //   53: astore_0
    //   54: ldc -107
    //   56: ldc_w 285
    //   59: aload_0
    //   60: invokestatic 289	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   63: pop
    //   64: aconst_null
    //   65: areturn
    //   66: ldc_w 291
    //   69: astore_0
    //   70: goto -42 -> 28
    //   73: astore_0
    //   74: ldc -107
    //   76: ldc_w 293
    //   79: aload_0
    //   80: invokestatic 289	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   83: pop
    //   84: aconst_null
    //   85: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	paramKeyPair	KeyPair
    //   0	86	1	paramVarArgs	String[]
    //   16	19	2	localPrivateKey	java.security.PrivateKey
    // Exception table:
    //   from	to	target	type
    //   0	12	53	java/io/UnsupportedEncodingException
    //   12	24	73	java/security/GeneralSecurityException
    //   28	51	73	java/security/GeneralSecurityException
  }
  
  private Intent zzb(Bundle arg1, KeyPair paramKeyPair)
    throws IOException
  {
    ConditionVariable localConditionVariable = new ConditionVariable();
    String str = nextId();
    synchronized (getClass())
    {
      this.zzbAW.put(str, localConditionVariable);
      zza(???, paramKeyPair, str);
      localConditionVariable.block(30000L);
    }
    synchronized (getClass())
    {
      paramKeyPair = this.zzbAW.remove(str);
      if ((paramKeyPair instanceof Intent))
      {
        paramKeyPair = (Intent)paramKeyPair;
        return paramKeyPair;
        ??? = finally;
        throw ???;
      }
      if ((paramKeyPair instanceof String)) {
        throw new IOException((String)paramKeyPair);
      }
    }
    paramKeyPair = String.valueOf(paramKeyPair);
    Log.w("InstanceID/Rpc", String.valueOf(paramKeyPair).length() + 12 + "No response " + paramKeyPair);
    throw new IOException("TIMEOUT");
  }
  
  private static int zzbG(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      int i = localPackageManager.getPackageInfo(findAppIDPackage(paramContext), 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return -1;
  }
  
  private void zzeF(String paramString)
  {
    if (!"com.google.android.gsf".equals(zzbAS)) {}
    do
    {
      return;
      this.zzbBb += 1;
    } while (this.zzbBb < 3);
    if (this.zzbBb == 3) {
      this.zzbBc = (new Random().nextInt(1000) + 1000);
    }
    this.zzbBc *= 2;
    this.zzbBd = (SystemClock.elapsedRealtime() + this.zzbBc);
    int i = this.zzbBc;
    Log.w("InstanceID/Rpc", String.valueOf(paramString).length() + 31 + "Backoff due to " + paramString + " for " + i);
  }
  
  private void zzg(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 instanceof ConditionVariable)) {
      ((ConditionVariable)paramObject1).open();
    }
    Message localMessage;
    if ((paramObject1 instanceof Messenger))
    {
      paramObject1 = (Messenger)paramObject1;
      localMessage = Message.obtain();
      localMessage.obj = paramObject2;
    }
    try
    {
      ((Messenger)paramObject1).send(localMessage);
      return;
    }
    catch (RemoteException paramObject1)
    {
      paramObject1 = String.valueOf(paramObject1);
      Log.w("InstanceID/Rpc", String.valueOf(paramObject1).length() + 24 + "Failed to send response " + (String)paramObject1);
    }
  }
  
  private void zzl(String paramString, Object paramObject)
  {
    synchronized (getClass())
    {
      Object localObject = this.zzbAW.get(paramString);
      this.zzbAW.put(paramString, paramObject);
      zzg(localObject, paramObject);
      return;
    }
  }
  
  public void handleIncomingMessenger(Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    if ((paramMessage.obj instanceof Intent))
    {
      Object localObject = (Intent)paramMessage.obj;
      ((Intent)localObject).setExtrasClassLoader(MessengerCompat.class.getClassLoader());
      if (((Intent)localObject).hasExtra("google.messenger"))
      {
        localObject = ((Intent)localObject).getParcelableExtra("google.messenger");
        if ((localObject instanceof MessengerCompat)) {
          this.zzbAY = ((MessengerCompat)localObject);
        }
        if ((localObject instanceof Messenger)) {
          this.zzbAX = ((Messenger)localObject);
        }
      }
      zzE((Intent)paramMessage.obj);
      return;
    }
    Log.w("InstanceID/Rpc", "Dropping invalid message");
  }
  
  protected void sendRequest(Intent paramIntent, String paramString)
  {
    this.zzbAZ = SystemClock.elapsedRealtime();
    paramIntent.putExtra("kid", String.valueOf(paramString).length() + 5 + "|ID|" + paramString + "|");
    paramIntent.putExtra("X-kid", String.valueOf(paramString).length() + 5 + "|ID|" + paramString + "|");
    boolean bool = "com.google.android.gsf".equals(zzbAS);
    paramString = paramIntent.getStringExtra("useGsf");
    if (paramString != null) {
      bool = "1".equals(paramString);
    }
    if (Log.isLoggable("InstanceID/Rpc", 3))
    {
      paramString = String.valueOf(paramIntent.getExtras());
      Log.d("InstanceID/Rpc", String.valueOf(paramString).length() + 8 + "Sending " + paramString);
    }
    if (this.zzbAX != null)
    {
      paramIntent.putExtra("google.messenger", this.zzbxz);
      paramString = Message.obtain();
      paramString.obj = paramIntent;
      try
      {
        this.zzbAX.send(paramString);
        return;
      }
      catch (RemoteException paramString)
      {
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
          Log.d("InstanceID/Rpc", "Messenger failed, fallback to startService");
        }
      }
    }
    if (bool)
    {
      paramString = new Intent("com.google.android.gms.iid.InstanceID");
      paramString.setPackage(this.zzqm.getPackageName());
      paramString.putExtra("GSF", paramIntent);
      this.zzqm.startService(paramString);
      return;
    }
    paramIntent.putExtra("google.messenger", this.zzbxz);
    paramIntent.putExtra("messenger2", "1");
    if (this.zzbAY != null)
    {
      paramString = Message.obtain();
      paramString.obj = paramIntent;
      try
      {
        this.zzbAY.send(paramString);
        return;
      }
      catch (RemoteException paramString)
      {
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
          Log.d("InstanceID/Rpc", "Messenger failed, fallback to startService");
        }
      }
    }
    this.zzqm.startService(paramIntent);
  }
  
  void zzB(Intent paramIntent)
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
  
  String zzC(Intent paramIntent)
    throws IOException
  {
    if (paramIntent == null) {
      throw new IOException("SERVICE_NOT_AVAILABLE");
    }
    String str2 = paramIntent.getStringExtra("registration_id");
    String str1 = str2;
    if (str2 == null) {
      str1 = paramIntent.getStringExtra("unregistered");
    }
    paramIntent.getLongExtra("Retry-After", 0L);
    if (str1 == null)
    {
      str1 = paramIntent.getStringExtra("error");
      if (str1 != null) {
        throw new IOException(str1);
      }
      paramIntent = String.valueOf(paramIntent.getExtras());
      Log.w("InstanceID/Rpc", String.valueOf(paramIntent).length() + 29 + "Unexpected response from GCM " + paramIntent, new Throwable());
      throw new IOException("SERVICE_NOT_AVAILABLE");
    }
    return str1;
  }
  
  void zzD(Intent paramIntent)
  {
    Object localObject2 = paramIntent.getStringExtra("error");
    if (localObject2 == null)
    {
      paramIntent = String.valueOf(paramIntent.getExtras());
      Log.w("InstanceID/Rpc", String.valueOf(paramIntent).length() + 49 + "Unexpected response, no error or registration id " + paramIntent);
      return;
    }
    Object localObject1;
    label160:
    Object localObject3;
    if (Log.isLoggable("InstanceID/Rpc", 3))
    {
      localObject1 = String.valueOf(localObject2);
      if (((String)localObject1).length() != 0)
      {
        localObject1 = "Received InstanceID error ".concat((String)localObject1);
        Log.d("InstanceID/Rpc", (String)localObject1);
      }
    }
    else
    {
      if (!((String)localObject2).startsWith("|")) {
        break label399;
      }
      Object localObject4 = ((String)localObject2).split("\\|");
      if (!"ID".equals(localObject4[1]))
      {
        localObject1 = String.valueOf(localObject2);
        if (((String)localObject1).length() == 0) {
          break label333;
        }
        localObject1 = "Unexpected structured response ".concat((String)localObject1);
        Log.w("InstanceID/Rpc", (String)localObject1);
      }
      if (localObject4.length <= 2) {
        break label348;
      }
      localObject3 = localObject4[2];
      localObject4 = localObject4[3];
      localObject2 = localObject3;
      localObject1 = localObject4;
      if (((String)localObject4).startsWith(":"))
      {
        localObject1 = ((String)localObject4).substring(1);
        localObject2 = localObject3;
      }
      label218:
      paramIntent.putExtra("error", (String)localObject1);
    }
    for (;;)
    {
      if (localObject2 == null) {
        zzP(localObject1);
      }
      for (;;)
      {
        long l = paramIntent.getLongExtra("Retry-After", 0L);
        if (l <= 0L) {
          break label370;
        }
        this.zzbBa = SystemClock.elapsedRealtime();
        this.zzbBc = ((int)l * 1000);
        this.zzbBd = (SystemClock.elapsedRealtime() + this.zzbBc);
        int i = this.zzbBc;
        Log.w("InstanceID/Rpc", 52 + "Explicit request from server to backoff: " + i);
        return;
        localObject1 = new String("Received InstanceID error ");
        break;
        label333:
        localObject1 = new String("Unexpected structured response ");
        break label160;
        label348:
        localObject1 = "UNKNOWN";
        localObject2 = null;
        break label218;
        zzl((String)localObject2, localObject1);
      }
      label370:
      if ((!"SERVICE_NOT_AVAILABLE".equals(localObject1)) && (!"AUTHENTICATION_FAILED".equals(localObject1))) {
        break;
      }
      zzeF((String)localObject1);
      return;
      label399:
      localObject3 = null;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
  
  public void zzE(Intent paramIntent)
  {
    if (paramIntent == null) {
      if (Log.isLoggable("InstanceID/Rpc", 3)) {
        Log.d("InstanceID/Rpc", "Unexpected response: null");
      }
    }
    do
    {
      return;
      localObject1 = paramIntent.getAction();
      if (("com.google.android.c2dm.intent.REGISTRATION".equals(localObject1)) || ("com.google.android.gms.iid.InstanceID".equals(localObject1))) {
        break;
      }
    } while (!Log.isLoggable("InstanceID/Rpc", 3));
    paramIntent = String.valueOf(paramIntent.getAction());
    if (paramIntent.length() != 0) {}
    for (paramIntent = "Unexpected response ".concat(paramIntent);; paramIntent = new String("Unexpected response "))
    {
      Log.d("InstanceID/Rpc", paramIntent);
      return;
    }
    Object localObject1 = paramIntent.getStringExtra("registration_id");
    if (localObject1 == null) {
      localObject1 = paramIntent.getStringExtra("unregistered");
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        zzD(paramIntent);
        return;
      }
      this.zzbAZ = SystemClock.elapsedRealtime();
      this.zzbBd = 0L;
      this.zzbBb = 0;
      this.zzbBc = 0;
      String str = null;
      Object localObject2;
      if (((String)localObject1).startsWith("|"))
      {
        localObject2 = ((String)localObject1).split("\\|");
        if (!"ID".equals(localObject2[1]))
        {
          localObject1 = String.valueOf(localObject1);
          if (((String)localObject1).length() == 0) {
            break label297;
          }
          localObject1 = "Unexpected structured response ".concat((String)localObject1);
          Log.w("InstanceID/Rpc", (String)localObject1);
        }
        str = localObject2[2];
        if (localObject2.length > 4)
        {
          if (!"SYNC".equals(localObject2[3])) {
            break label311;
          }
          InstanceIDListenerService.zzbF(this.zzqm);
        }
      }
      label297:
      label311:
      while (!"RST".equals(localObject2[3]))
      {
        localObject2 = localObject2[(localObject2.length - 1)];
        localObject1 = localObject2;
        if (((String)localObject2).startsWith(":")) {
          localObject1 = ((String)localObject2).substring(1);
        }
        paramIntent.putExtra("registration_id", (String)localObject1);
        if (str != null) {
          break label355;
        }
        zzP(paramIntent);
        return;
        localObject1 = new String("Unexpected structured response ");
        break;
      }
      InstanceIDListenerService.zza(this.zzqm, InstanceID.getInstance(this.zzqm).zzJQ());
      paramIntent.removeExtra("registration_id");
      zzl(str, paramIntent);
      return;
      label355:
      zzl(str, paramIntent);
      return;
    }
  }
  
  void zzJT()
  {
    if (this.zzbxz != null) {
      return;
    }
    findAppIDPackage(this.zzqm);
    this.zzbxz = new Messenger(new Handler(Looper.getMainLooper())
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        Rpc.this.handleIncomingMessenger(paramAnonymousMessage);
      }
    });
  }
  
  Intent zza(Bundle paramBundle, KeyPair paramKeyPair)
    throws IOException
  {
    Intent localIntent2 = zzb(paramBundle, paramKeyPair);
    Intent localIntent1 = localIntent2;
    if (localIntent2 != null)
    {
      localIntent1 = localIntent2;
      if (localIntent2.hasExtra("google.messenger")) {
        localIntent1 = zzb(paramBundle, paramKeyPair);
      }
    }
    return localIntent1;
  }
  
  void zza(Bundle paramBundle, KeyPair paramKeyPair, String paramString)
    throws IOException
  {
    long l1 = SystemClock.elapsedRealtime();
    if ((this.zzbBd != 0L) && (l1 <= this.zzbBd))
    {
      long l2 = this.zzbBd;
      int i = this.zzbBc;
      Log.w("InstanceID/Rpc", 78 + "Backoff mode, next request attempt: " + (l2 - l1) + " interval: " + i);
      throw new IOException("RETRY_LATER");
    }
    zzJT();
    if (zzbAS == null) {
      throw new IOException("MISSING_INSTANCEID_SERVICE");
    }
    this.zzbAZ = SystemClock.elapsedRealtime();
    Intent localIntent = new Intent("com.google.android.c2dm.intent.REGISTER");
    localIntent.setPackage(zzbAS);
    paramBundle.putString("gmsv", Integer.toString(zzbG(this.zzqm)));
    paramBundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
    paramBundle.putString("app_ver", Integer.toString(InstanceID.zzbD(this.zzqm)));
    paramBundle.putString("app_ver_name", InstanceID.zzbE(this.zzqm));
    paramBundle.putString("cliv", "iid-10298000");
    paramBundle.putString("appid", InstanceID.zza(paramKeyPair));
    String str = InstanceID.zzB(paramKeyPair.getPublic().getEncoded());
    paramBundle.putString("pub2", str);
    paramBundle.putString("sig", zza(paramKeyPair, new String[] { this.zzqm.getPackageName(), str }));
    localIntent.putExtras(paramBundle);
    zzB(localIntent);
    sendRequest(localIntent, paramString);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/iid/Rpc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */