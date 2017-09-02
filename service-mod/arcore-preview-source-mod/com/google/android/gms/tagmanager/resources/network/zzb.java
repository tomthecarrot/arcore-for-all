package com.google.android.gms.tagmanager.resources.network;

import com.google.android.gms.tagmanager.Log;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class zzb
  implements zzc
{
  private HttpURLConnection zzcAD;
  private InputStream zzcAE = null;
  
  private InputStream zze(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    int i = paramHttpURLConnection.getResponseCode();
    if (i == 200) {
      return paramHttpURLConnection.getInputStream();
    }
    paramHttpURLConnection = 25 + "Bad response: " + i;
    if (i == 404) {
      throw new FileNotFoundException(paramHttpURLConnection);
    }
    if (i == 503) {
      throw new ServerUnavailableException(paramHttpURLConnection);
    }
    throw new IOException(paramHttpURLConnection);
  }
  
  private void zzf(HttpURLConnection paramHttpURLConnection)
  {
    try
    {
      if (this.zzcAE != null) {
        this.zzcAE.close();
      }
      if (paramHttpURLConnection != null) {
        paramHttpURLConnection.disconnect();
      }
      return;
    }
    catch (IOException localIOException)
    {
      str = String.valueOf(localIOException.getMessage());
      if (str.length() == 0) {}
    }
    for (String str = "HttpUrlConnectionNetworkClient: Error when closing http input stream: ".concat(str);; str = new String("HttpUrlConnectionNetworkClient: Error when closing http input stream: "))
    {
      Log.e(str, localIOException);
      break;
    }
  }
  
  public void close()
  {
    zzf(this.zzcAD);
  }
  
  public InputStream zzkB(String paramString)
    throws IOException
  {
    this.zzcAD = zzkC(paramString);
    this.zzcAE = zze(this.zzcAD);
    return this.zzcAE;
  }
  
  HttpURLConnection zzkC(String paramString)
    throws IOException
  {
    paramString = (HttpURLConnection)new URL(paramString).openConnection();
    paramString.setReadTimeout(20000);
    paramString.setConnectTimeout(20000);
    return paramString;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/resources/network/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */