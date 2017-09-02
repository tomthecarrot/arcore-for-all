package com.google.atap.tangocloudstorage;

import android.content.Context;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.location.visualmapping.client.visualmapstore.VisualMapStoreClient;
import com.google.tango.cloudlib.GServicesSettings;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CloudStorage
{
  private static final String TAG = "CloudStorage";
  private final ExecutorService executor;
  private final RequestQueue requestQueue;
  private final UploadListener uploadListener;
  private final VisualMapStoreClient visualMapStoreClient;
  
  public CloudStorage(Context paramContext, int paramInt, String paramString, UploadListener paramUploadListener)
  {
    this.executor = Executors.newFixedThreadPool(paramInt);
    this.requestQueue = Volley.newRequestQueue(paramContext);
    this.uploadListener = paramUploadListener;
    this.visualMapStoreClient = new VisualMapStoreClient(paramContext, paramString, GServicesSettings.getVisualMapStoreGrpcChannelMaxMessageSize(paramContext.getContentResolver()), GServicesSettings.getVisualMapStoreEndpoint(paramContext.getContentResolver()));
  }
  
  public void queueFileUploadRequest(FileUploadRequest paramFileUploadRequest)
  {
    paramFileUploadRequest = new FileUploadTask(paramFileUploadRequest, this.requestQueue, this.visualMapStoreClient, this.uploadListener);
    this.executor.execute(paramFileUploadRequest);
  }
  
  public static abstract interface UploadListener
  {
    public abstract void onFailure(FileUploadRequest paramFileUploadRequest, CloudStorageException paramCloudStorageException);
    
    public abstract void onProgressChanged(FileUploadRequest paramFileUploadRequest, long paramLong1, long paramLong2);
    
    public abstract void onSuccess(FileUploadRequest paramFileUploadRequest);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangocloudstorage/CloudStorage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */