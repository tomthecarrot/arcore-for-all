package com.google.tango.cloudlib;

import android.content.Context;
import android.location.Location;
import android.util.Log;
import com.google.common.geometry.S2LatLng;
import com.google.location.visualmapping.client.GrpcErrorListener;
import com.google.location.visualmapping.client.visualmapstore.ReadAdfClusterNavigationGraphResponseListener;
import com.google.location.visualmapping.client.visualmapstore.VisualMapStoreClient;
import com.google.tango.javacommon.SimpleTimer;
import io.grpc.StatusRuntimeException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class NavigationGraphDownloader
{
  private static final String TAG = NavigationGraphDownloader.class.getSimpleName();
  private static final long UNINITIALIZED_S2_CELL_ID = 0L;
  private final Object mCallbackLock = new Object();
  private final Callbacks mCallbacks;
  private final Context mContext;
  private final GrpcErrorListener mErrorListener = new GrpcErrorListener()
  {
    final SimpleTimer downloadTimer = SimpleTimer.startNew();
    
    public void onError(StatusRuntimeException paramAnonymousStatusRuntimeException)
    {
      Log.i(NavigationGraphDownloader.TAG, String.format("navigationGraph download attempt failed, but took %.1f seconds. Download failed with status:\n %s.", new Object[] { Double.valueOf(this.downloadTimer.elapsedSeconds()), paramAnonymousStatusRuntimeException.getStatus() }));
    }
  };
  private boolean mIsCallbacksDisconnected = false;
  private long mLastProcessedCenterS2Cell = 0L;
  private HashSet<String> mLoadedGraphs = new HashSet();
  private final NavigationGraphCache mNavigationGraphCache;
  private ProcessingThread mProcessingThread;
  private final ReadAdfClusterNavigationGraphResponseListener mResponseListener = new ReadAdfClusterNavigationGraphResponseListener()
  {
    final SimpleTimer downloadTimer = SimpleTimer.startNew();
    
    public void onResponse(Set<Long> paramAnonymousSet, Map<String, byte[]> paramAnonymousMap)
    {
      Log.i(NavigationGraphDownloader.TAG, String.format("navigationGraph download took %.1f seconds, with status code %d.", new Object[] { Double.valueOf(this.downloadTimer.elapsedSeconds()), Integer.valueOf(0) }));
      Set localSet = NavigationGraphDownloader.this.mNavigationGraphCache.setCachedNavGraphs(paramAnonymousSet, paramAnonymousMap);
      if (localSet == null) {
        Log.e(NavigationGraphDownloader.TAG, "Failed to write navigation graphs to disk.");
      }
      for (;;)
      {
        return;
        if (paramAnonymousMap.isEmpty()) {
          Log.d(NavigationGraphDownloader.TAG, "No navigation graphs were found for cells: " + Utils.asTokens(paramAnonymousSet).toString());
        }
        paramAnonymousSet = localSet.iterator();
        while (paramAnonymousSet.hasNext())
        {
          paramAnonymousMap = (String)paramAnonymousSet.next();
          NavigationGraphDownloader.this.maybeMakeNavigationGraphAvailable(paramAnonymousMap);
        }
      }
    }
  };
  private HashSet<Long> mSearchedTiles = new HashSet();
  private final VisualMapStoreClient mVisualMapStoreClient;
  
  NavigationGraphDownloader(Context paramContext, NavigationGraphCache paramNavigationGraphCache, String paramString, Callbacks paramCallbacks)
  {
    this.mContext = paramContext;
    this.mNavigationGraphCache = paramNavigationGraphCache;
    this.mCallbacks = paramCallbacks;
    this.mProcessingThread = new ProcessingThread(TAG);
    this.mProcessingThread.start();
    this.mVisualMapStoreClient = new VisualMapStoreClient(paramContext, paramString, GServicesSettings.getVisualMapStoreGrpcChannelMaxMessageSize(paramContext.getContentResolver()), GServicesSettings.getVisualMapStoreEndpoint(paramContext.getContentResolver()));
  }
  
  private void maybeMakeNavigationGraphAvailable(String paramString)
  {
    synchronized (this.mLoadedGraphs)
    {
      synchronized (this.mCallbackLock)
      {
        if (!this.mIsCallbacksDisconnected)
        {
          if (this.mLoadedGraphs.contains(paramString)) {
            Log.d(TAG, "Requested navigation graph is already loaded: " + paramString);
          }
        }
        else {
          return;
        }
        Log.d(TAG, "Loading new navigation graph: " + paramString);
        this.mLoadedGraphs.add(paramString);
        this.mCallbacks.onNavigationGraphAvailable(paramString);
      }
    }
  }
  
  private void processLocation(Location paramLocation)
  {
    long l = TileUtils.getAdfTileId(S2LatLng.fromDegrees(paramLocation.getLatitude(), paramLocation.getLongitude()));
    if (l == this.mLastProcessedCenterS2Cell)
    {
      Log.d(TAG, "Skipping update since current S2 cell " + Utils.asToken(Long.valueOf(l)) + " is the same as last time.");
      return;
    }
    Log.d(TAG, "Processing update for new S2 cell " + Utils.asToken(Long.valueOf(l)) + " (previous cell " + Utils.asToken(Long.valueOf(this.mLastProcessedCenterS2Cell)) + ").");
    this.mLastProcessedCenterS2Cell = l;
    paramLocation = new HashSet(TileUtils.getGridOfAdfTileIds(paramLocation));
    paramLocation.removeAll(this.mSearchedTiles);
    this.mSearchedTiles.addAll(paramLocation);
    Log.d(TAG, "Cells already searched: " + Utils.asTokens(this.mSearchedTiles).toString());
    Log.d(TAG, "Cells not yet searched: " + Utils.asTokens(paramLocation).toString());
    requestNavigationGraphs(new ArrayList(paramLocation));
  }
  
  void requestNavigationGraphs(List<Long> paramList)
  {
    Log.d(TAG, "Called requestNavigationGraphs() with: " + Utils.asTokens(paramList).toString());
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Long localLong = (Long)paramList.next();
      Set localSet = this.mNavigationGraphCache.getCachedNavGraphs(localLong.longValue());
      if (localSet != null) {
        localHashSet2.addAll(localSet);
      } else {
        localHashSet1.add(localLong);
      }
    }
    Log.d(TAG, "Retrieved " + localHashSet2 + " from cache.");
    paramList = localHashSet2.iterator();
    while (paramList.hasNext()) {
      maybeMakeNavigationGraphAvailable((String)paramList.next());
    }
    if (localHashSet1.size() > 0)
    {
      Log.d(TAG, "Trying to download navigation graph async: " + Utils.asTokens(localHashSet1).toString());
      this.mVisualMapStoreClient.readAdfClusterNavigationGraphAsync(localHashSet1, Collections.emptyList(), this.mResponseListener, this.mErrorListener);
    }
  }
  
  void stop()
  {
    synchronized (this.mCallbackLock)
    {
      this.mProcessingThread.clearTasks();
      this.mIsCallbacksDisconnected = true;
      this.mProcessingThread.quitSafely();
      this.mVisualMapStoreClient.shutdown();
      return;
    }
  }
  
  void updateLocation(final Location paramLocation)
  {
    synchronized (this.mCallbackLock)
    {
      if (this.mIsCallbacksDisconnected) {
        return;
      }
      this.mProcessingThread.clearTasks();
      paramLocation = new Location(paramLocation);
      this.mProcessingThread.post(new Runnable()
      {
        public void run()
        {
          NavigationGraphDownloader.this.processLocation(paramLocation);
        }
      });
      return;
    }
  }
  
  static abstract interface Callbacks
  {
    public abstract void onNavigationGraphAvailable(String paramString);
    
    public abstract void onNetworkFailure();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/tango/cloudlib/NavigationGraphDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */