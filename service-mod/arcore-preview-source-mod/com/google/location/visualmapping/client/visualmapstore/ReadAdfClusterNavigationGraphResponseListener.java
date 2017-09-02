package com.google.location.visualmapping.client.visualmapstore;

import java.util.Map;
import java.util.Set;

public abstract interface ReadAdfClusterNavigationGraphResponseListener
{
  public abstract void onResponse(Set<Long> paramSet, Map<String, byte[]> paramMap);
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/location/visualmapping/client/visualmapstore/ReadAdfClusterNavigationGraphResponseListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */