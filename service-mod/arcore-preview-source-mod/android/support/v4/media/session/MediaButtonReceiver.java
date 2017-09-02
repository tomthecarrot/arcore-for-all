package android.support.v4.media.session;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.view.KeyEvent;
import java.util.List;

public class MediaButtonReceiver
  extends BroadcastReceiver
{
  public static KeyEvent handleIntent(MediaSessionCompat paramMediaSessionCompat, Intent paramIntent)
  {
    if ((paramMediaSessionCompat == null) || (paramIntent == null) || (!"android.intent.action.MEDIA_BUTTON".equals(paramIntent.getAction())) || (!paramIntent.hasExtra("android.intent.extra.KEY_EVENT"))) {
      return null;
    }
    paramIntent = (KeyEvent)paramIntent.getParcelableExtra("android.intent.extra.KEY_EVENT");
    paramMediaSessionCompat.getController().dispatchMediaButtonEvent(paramIntent);
    return paramIntent;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Intent localIntent = new Intent("android.intent.action.MEDIA_BUTTON");
    localIntent.setPackage(paramContext.getPackageName());
    PackageManager localPackageManager = paramContext.getPackageManager();
    List localList = localPackageManager.queryIntentServices(localIntent, 0);
    Object localObject = localList;
    if (localList.isEmpty())
    {
      localIntent.setAction("android.media.browse.MediaBrowserService");
      localObject = localPackageManager.queryIntentServices(localIntent, 0);
    }
    if (((List)localObject).isEmpty()) {
      throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or a media browser service implementation");
    }
    if (((List)localObject).size() != 1) {
      throw new IllegalStateException("Expected 1 Service that handles " + localIntent.getAction() + ", found " + ((List)localObject).size());
    }
    localObject = (ResolveInfo)((List)localObject).get(0);
    paramIntent.setComponent(new ComponentName(((ResolveInfo)localObject).serviceInfo.packageName, ((ResolveInfo)localObject).serviceInfo.name));
    paramContext.startService(paramIntent);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/media/session/MediaButtonReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */