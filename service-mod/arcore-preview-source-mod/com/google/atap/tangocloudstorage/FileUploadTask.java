package com.google.atap.tangocloudstorage;

import android.util.Log;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.ParseError;
import com.android.volley.RequestQueue;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.google.location.visualmapping.client.visualmapstore.VisualMapStoreClient;
import io.grpc.StatusRuntimeException;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

class FileUploadTask
  implements Runnable
{
  private static final int BLOCK_SIZE = 1048576;
  private static final String TAG = "FileUploadTask";
  private final FileUploadRequest request;
  private final RequestQueue requestQueue;
  private final CloudStorage.UploadListener uploadListener;
  private final VisualMapStoreClient visualMapStoreClient;
  
  public FileUploadTask(FileUploadRequest paramFileUploadRequest, RequestQueue paramRequestQueue, VisualMapStoreClient paramVisualMapStoreClient, CloudStorage.UploadListener paramUploadListener)
  {
    this.request = paramFileUploadRequest;
    this.requestQueue = paramRequestQueue;
    this.uploadListener = paramUploadListener;
    this.visualMapStoreClient = paramVisualMapStoreClient;
  }
  
  private URL requestSignedUploadRequestUrl()
    throws CloudStorageException, InterruptedException
  {
    this.request.throwIfCancellationRequested();
    try
    {
      URL localURL = new URL(this.visualMapStoreClient.writeFile(this.request.destBucket, this.request.destFileName, this.request.idToken));
      return localURL;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new ServerException(localMalformedURLException);
    }
    catch (StatusRuntimeException localStatusRuntimeException)
    {
      switch (localStatusRuntimeException.getStatus().getCode())
      {
      default: 
        throw new RuntimeException("Unhandled exception", localStatusRuntimeException);
      }
    }
    throw new AuthenticationException(localStatusRuntimeException);
    throw new UnauthorizedAccessException(localStatusRuntimeException);
    throw new ServerException(localStatusRuntimeException);
    throw new TimeoutException(localStatusRuntimeException);
    throw new NetworkException(localStatusRuntimeException);
  }
  
  private URL requestUploadSessionUrl(URL paramURL)
    throws CloudStorageException, InterruptedException
  {
    this.request.throwIfCancellationRequested();
    RequestFuture localRequestFuture = RequestFuture.newFuture();
    paramURL = new UploadSessionUrlRequest(paramURL, localRequestFuture, localRequestFuture);
    this.requestQueue.add(paramURL);
    try
    {
      paramURL = (URL)localRequestFuture.get();
      return paramURL;
    }
    catch (ExecutionException paramURL)
    {
      throw translateExecutionException(paramURL);
    }
  }
  
  private CloudStorageException translateExecutionException(ExecutionException paramExecutionException)
  {
    if ((paramExecutionException.getCause() instanceof VolleyError))
    {
      VolleyError localVolleyError = (VolleyError)paramExecutionException.getCause();
      if ((localVolleyError instanceof AuthFailureError)) {
        return new ServerException(paramExecutionException);
      }
      if ((localVolleyError instanceof NetworkError)) {
        return new NetworkException(paramExecutionException);
      }
      if ((localVolleyError instanceof ParseError)) {
        return new ServerException(paramExecutionException);
      }
      if ((localVolleyError instanceof ServerError)) {
        return new ServerException(paramExecutionException);
      }
      if ((localVolleyError instanceof TimeoutError)) {
        return new TimeoutException(paramExecutionException);
      }
      if ((localVolleyError.getCause() instanceof CloudStorageException)) {
        return (CloudStorageException)localVolleyError.getCause();
      }
    }
    throw new RuntimeException("Unhandled exception", paramExecutionException);
  }
  
  private void uploadFileBlock(URL paramURL, File paramFile, long paramLong, int paramInt)
    throws CloudStorageException, InterruptedException
  {
    this.request.throwIfCancellationRequested();
    RequestFuture localRequestFuture = RequestFuture.newFuture();
    paramURL = new MultipartUploadRequest(paramURL, paramFile, paramLong, paramInt, localRequestFuture, localRequestFuture);
    this.requestQueue.add(paramURL);
    try
    {
      localRequestFuture.get();
      return;
    }
    catch (ExecutionException paramURL)
    {
      throw translateExecutionException(paramURL);
    }
  }
  
  public void run()
  {
    try
    {
      this.request.throwIfCancellationRequested();
      Log.i("FileUploadTask", "Start uploading to " + this.request.destBucket + "/" + this.request.destFileName);
      File localFile = new File(this.request.sourceFileName);
      if (!localFile.exists()) {
        throw new FileIOException("File not found: " + this.request.sourceFileName);
      }
    }
    catch (CloudStorageException localCloudStorageException)
    {
      this.uploadListener.onFailure(this.request, localCloudStorageException);
      return;
      if (!localCloudStorageException.isFile()) {
        throw new FileIOException("Not a normal file: " + this.request.sourceFileName);
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      Log.i("FileUploadTask", "File upload task canceled: " + this.request.destBucket + "/" + this.request.destFileName);
      return;
    }
    URL localURL = requestUploadSessionUrl(requestSignedUploadRequestUrl());
    long l1 = 0L;
    this.uploadListener.onProgressChanged(this.request, 0L, localInterruptedException.length());
    long l2;
    do
    {
      int i = (int)Math.min(localInterruptedException.length() - l1, 1048576L);
      uploadFileBlock(localURL, localInterruptedException, l1, i);
      l2 = l1 + i;
      this.uploadListener.onProgressChanged(this.request, l2, localInterruptedException.length());
      l1 = l2;
    } while (l2 < localInterruptedException.length());
    this.uploadListener.onSuccess(this.request);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangocloudstorage/FileUploadTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */