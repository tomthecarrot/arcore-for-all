package com.google.android.gms.internal;

import java.io.IOException;
import java.net.URI;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;

public class zzx
  implements zzz
{
  protected final HttpClient zzaC;
  
  public zzx(HttpClient paramHttpClient)
  {
    this.zzaC = paramHttpClient;
  }
  
  private static void zza(HttpEntityEnclosingRequestBase paramHttpEntityEnclosingRequestBase, zzl<?> paramzzl)
    throws zza
  {
    paramzzl = paramzzl.zzm();
    if (paramzzl != null) {
      paramHttpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(paramzzl));
    }
  }
  
  private static void zza(HttpUriRequest paramHttpUriRequest, Map<String, String> paramMap)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramHttpUriRequest.setHeader(str, (String)paramMap.get(str));
    }
  }
  
  static HttpUriRequest zzb(zzl<?> paramzzl, Map<String, String> paramMap)
    throws zza
  {
    switch (paramzzl.getMethod())
    {
    default: 
      throw new IllegalStateException("Unknown request method.");
    case -1: 
      paramMap = paramzzl.zzj();
      if (paramMap != null)
      {
        HttpPost localHttpPost = new HttpPost(paramzzl.getUrl());
        localHttpPost.addHeader("Content-Type", paramzzl.zzi());
        localHttpPost.setEntity(new ByteArrayEntity(paramMap));
        return localHttpPost;
      }
      return new HttpGet(paramzzl.getUrl());
    case 0: 
      return new HttpGet(paramzzl.getUrl());
    case 3: 
      return new HttpDelete(paramzzl.getUrl());
    case 1: 
      paramMap = new HttpPost(paramzzl.getUrl());
      paramMap.addHeader("Content-Type", paramzzl.zzl());
      zza(paramMap, paramzzl);
      return paramMap;
    case 2: 
      paramMap = new HttpPut(paramzzl.getUrl());
      paramMap.addHeader("Content-Type", paramzzl.zzl());
      zza(paramMap, paramzzl);
      return paramMap;
    case 4: 
      return new HttpHead(paramzzl.getUrl());
    case 5: 
      return new HttpOptions(paramzzl.getUrl());
    case 6: 
      return new HttpTrace(paramzzl.getUrl());
    }
    paramMap = new zza(paramzzl.getUrl());
    paramMap.addHeader("Content-Type", paramzzl.zzl());
    zza(paramMap, paramzzl);
    return paramMap;
  }
  
  public HttpResponse zza(zzl<?> paramzzl, Map<String, String> paramMap)
    throws IOException, zza
  {
    HttpUriRequest localHttpUriRequest = zzb(paramzzl, paramMap);
    zza(localHttpUriRequest, paramMap);
    zza(localHttpUriRequest, paramzzl.getHeaders());
    paramMap = localHttpUriRequest.getParams();
    int i = paramzzl.zzp();
    HttpConnectionParams.setConnectionTimeout(paramMap, 5000);
    HttpConnectionParams.setSoTimeout(paramMap, i);
    return this.zzaC.execute(localHttpUriRequest);
  }
  
  public static final class zza
    extends HttpEntityEnclosingRequestBase
  {
    public zza() {}
    
    public zza(String paramString)
    {
      setURI(URI.create(paramString));
    }
    
    public String getMethod()
    {
      return "PATCH";
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/internal/zzx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */