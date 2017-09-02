package android.support.v4.net;

import android.os.Build.VERSION;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;

public final class TrafficStatsCompat
{
  private static final TrafficStatsCompatImpl IMPL = new BaseTrafficStatsCompatImpl();
  
  static
  {
    if ("N".equals(Build.VERSION.CODENAME))
    {
      IMPL = new Api24TrafficStatsCompatImpl();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      IMPL = new IcsTrafficStatsCompatImpl();
      return;
    }
  }
  
  public static void clearThreadStatsTag()
  {
    IMPL.clearThreadStatsTag();
  }
  
  public static int getThreadStatsTag()
  {
    return IMPL.getThreadStatsTag();
  }
  
  public static void incrementOperationCount(int paramInt)
  {
    IMPL.incrementOperationCount(paramInt);
  }
  
  public static void incrementOperationCount(int paramInt1, int paramInt2)
  {
    IMPL.incrementOperationCount(paramInt1, paramInt2);
  }
  
  public static void setThreadStatsTag(int paramInt)
  {
    IMPL.setThreadStatsTag(paramInt);
  }
  
  public static void tagDatagramSocket(DatagramSocket paramDatagramSocket)
    throws SocketException
  {
    IMPL.tagDatagramSocket(paramDatagramSocket);
  }
  
  public static void tagSocket(Socket paramSocket)
    throws SocketException
  {
    IMPL.tagSocket(paramSocket);
  }
  
  public static void untagDatagramSocket(DatagramSocket paramDatagramSocket)
    throws SocketException
  {
    IMPL.untagDatagramSocket(paramDatagramSocket);
  }
  
  public static void untagSocket(Socket paramSocket)
    throws SocketException
  {
    IMPL.untagSocket(paramSocket);
  }
  
  static class Api24TrafficStatsCompatImpl
    extends TrafficStatsCompat.IcsTrafficStatsCompatImpl
  {
    public void tagDatagramSocket(DatagramSocket paramDatagramSocket)
      throws SocketException
    {
      TrafficStatsCompatApi24.tagDatagramSocket(paramDatagramSocket);
    }
    
    public void untagDatagramSocket(DatagramSocket paramDatagramSocket)
      throws SocketException
    {
      TrafficStatsCompatApi24.untagDatagramSocket(paramDatagramSocket);
    }
  }
  
  static class BaseTrafficStatsCompatImpl
    implements TrafficStatsCompat.TrafficStatsCompatImpl
  {
    private ThreadLocal<SocketTags> mThreadSocketTags = new ThreadLocal()
    {
      protected TrafficStatsCompat.BaseTrafficStatsCompatImpl.SocketTags initialValue()
      {
        return new TrafficStatsCompat.BaseTrafficStatsCompatImpl.SocketTags(null);
      }
    };
    
    public void clearThreadStatsTag()
    {
      ((SocketTags)this.mThreadSocketTags.get()).statsTag = -1;
    }
    
    public int getThreadStatsTag()
    {
      return ((SocketTags)this.mThreadSocketTags.get()).statsTag;
    }
    
    public void incrementOperationCount(int paramInt) {}
    
    public void incrementOperationCount(int paramInt1, int paramInt2) {}
    
    public void setThreadStatsTag(int paramInt)
    {
      ((SocketTags)this.mThreadSocketTags.get()).statsTag = paramInt;
    }
    
    public void tagDatagramSocket(DatagramSocket paramDatagramSocket) {}
    
    public void tagSocket(Socket paramSocket) {}
    
    public void untagDatagramSocket(DatagramSocket paramDatagramSocket) {}
    
    public void untagSocket(Socket paramSocket) {}
    
    private static class SocketTags
    {
      public int statsTag = -1;
    }
  }
  
  static class IcsTrafficStatsCompatImpl
    implements TrafficStatsCompat.TrafficStatsCompatImpl
  {
    public void clearThreadStatsTag() {}
    
    public int getThreadStatsTag()
    {
      return TrafficStatsCompatIcs.getThreadStatsTag();
    }
    
    public void incrementOperationCount(int paramInt)
    {
      TrafficStatsCompatIcs.incrementOperationCount(paramInt);
    }
    
    public void incrementOperationCount(int paramInt1, int paramInt2)
    {
      TrafficStatsCompatIcs.incrementOperationCount(paramInt1, paramInt2);
    }
    
    public void setThreadStatsTag(int paramInt)
    {
      TrafficStatsCompatIcs.setThreadStatsTag(paramInt);
    }
    
    public void tagDatagramSocket(DatagramSocket paramDatagramSocket)
      throws SocketException
    {
      TrafficStatsCompatIcs.tagDatagramSocket(paramDatagramSocket);
    }
    
    public void tagSocket(Socket paramSocket)
      throws SocketException
    {
      TrafficStatsCompatIcs.tagSocket(paramSocket);
    }
    
    public void untagDatagramSocket(DatagramSocket paramDatagramSocket)
      throws SocketException
    {
      TrafficStatsCompatIcs.untagDatagramSocket(paramDatagramSocket);
    }
    
    public void untagSocket(Socket paramSocket)
      throws SocketException
    {
      TrafficStatsCompatIcs.untagSocket(paramSocket);
    }
  }
  
  static abstract interface TrafficStatsCompatImpl
  {
    public abstract void clearThreadStatsTag();
    
    public abstract int getThreadStatsTag();
    
    public abstract void incrementOperationCount(int paramInt);
    
    public abstract void incrementOperationCount(int paramInt1, int paramInt2);
    
    public abstract void setThreadStatsTag(int paramInt);
    
    public abstract void tagDatagramSocket(DatagramSocket paramDatagramSocket)
      throws SocketException;
    
    public abstract void tagSocket(Socket paramSocket)
      throws SocketException;
    
    public abstract void untagDatagramSocket(DatagramSocket paramDatagramSocket)
      throws SocketException;
    
    public abstract void untagSocket(Socket paramSocket)
      throws SocketException;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/net/TrafficStatsCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */