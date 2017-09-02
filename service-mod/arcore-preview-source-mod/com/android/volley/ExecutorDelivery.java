package com.android.volley;

import android.os.Handler;
import java.util.concurrent.Executor;

public class ExecutorDelivery
  implements ResponseDelivery
{
  private final Executor mResponsePoster;
  
  public ExecutorDelivery(final Handler paramHandler)
  {
    this.mResponsePoster = new Executor()
    {
      public void execute(Runnable paramAnonymousRunnable)
      {
        paramHandler.post(paramAnonymousRunnable);
      }
    };
  }
  
  public ExecutorDelivery(Executor paramExecutor)
  {
    this.mResponsePoster = paramExecutor;
  }
  
  public void postError(Request<?> paramRequest, VolleyError paramVolleyError)
  {
    paramRequest.addMarker("post-error");
    paramVolleyError = Response.error(paramVolleyError);
    this.mResponsePoster.execute(new ResponseDeliveryRunnable(paramRequest, paramVolleyError, null));
  }
  
  public void postResponse(Request<?> paramRequest, Response<?> paramResponse)
  {
    postResponse(paramRequest, paramResponse, null);
  }
  
  public void postResponse(Request<?> paramRequest, Response<?> paramResponse, Runnable paramRunnable)
  {
    paramRequest.markDelivered();
    paramRequest.addMarker("post-response");
    this.mResponsePoster.execute(new ResponseDeliveryRunnable(paramRequest, paramResponse, paramRunnable));
  }
  
  private class ResponseDeliveryRunnable
    implements Runnable
  {
    private final Request mRequest;
    private final Response mResponse;
    private final Runnable mRunnable;
    
    public ResponseDeliveryRunnable(Request paramRequest, Response paramResponse, Runnable paramRunnable)
    {
      this.mRequest = paramRequest;
      this.mResponse = paramResponse;
      this.mRunnable = paramRunnable;
    }
    
    public void run()
    {
      if (this.mRequest.isCanceled()) {
        this.mRequest.finish("canceled-at-delivery");
      }
      label97:
      label107:
      for (;;)
      {
        return;
        if (this.mResponse.isSuccess())
        {
          this.mRequest.deliverResponse(this.mResponse.result);
          if (!this.mResponse.intermediate) {
            break label97;
          }
          this.mRequest.addMarker("intermediate-response");
        }
        for (;;)
        {
          if (this.mRunnable == null) {
            break label107;
          }
          this.mRunnable.run();
          return;
          this.mRequest.deliverError(this.mResponse.error);
          break;
          this.mRequest.finish("done");
        }
      }
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/android/volley/ExecutorDelivery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */