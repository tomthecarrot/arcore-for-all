package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzaav;

public final class G
{
  public static Value<Integer> batchRetryIntervalK;
  public static Value<String> batchingPath;
  public static Value<String> batchingStrategyK;
  public static Value<Long> campaignsTimeLimitMillis;
  public static Value<String> compressionStrategyK;
  public static Value<Boolean> disableBroadcastReceiver;
  public static Value<Long> dispatchAlarmMillis;
  public static Value<String> fallbackResponsesK;
  public static Value<String> firstPartyExperimentId;
  public static Value<Integer> firstPartyExperimentVariant;
  public static Value<Integer> httpConnectionConnectTimeoutMillis;
  public static Value<Integer> httpConnectionReadTimeoutMillis;
  public static Value<Long> initialLocalDispatchMillis;
  public static Value<Long> initializationWarningThreshold = Value.zzb("analytics.initialization_warning_threshold", 5000L);
  public static Value<String> insecureHost;
  public static Value<Long> localDispatchIntervalMillis;
  public static Value<String> loggingTag;
  public static Value<Integer> maxBatchPostLength;
  public static Value<Long> maxDispatchAlarmMillis;
  public static Value<Integer> maxGetLength;
  public static Value<Integer> maxHitLengthK;
  public static Value<Integer> maxHitsPerBatch;
  public static Value<Integer> maxHitsPerDispatch;
  public static Value<Integer> maxHitsPerRequestK;
  public static Value<Long> maxLocalDispatchMillis;
  public static Value<Integer> maxPostLengthK;
  public static Value<Integer> maxStoredHits;
  public static Value<Integer> maxStoredHitsPerApp;
  public static Value<Integer> maxStoredPropertiesPerApp;
  public static Value<Long> maxTokens;
  public static Value<Long> minLocalDispatchMillis;
  public static Value<Long> monitoringSamplePeriodMillis;
  public static Value<String> secureHost;
  public static Value<Boolean> serviceClientEnabled;
  public static Value<Long> serviceConnectTimeoutMillis;
  public static Value<Boolean> serviceEnabled = Value.zzf("analytics.service_enabled", false);
  public static Value<Long> serviceIdleDisconnectMillis;
  public static Value<Long> serviceMonitorInterval;
  public static Value<Long> serviceReconnectThrottleMillis;
  public static Value<Long> serviceSecondConnectDelayMillis;
  public static Value<Long> serviceUnexpectedReconnectMillis;
  public static Value<String> simplePath;
  public static Value<Float> tokensPerSec;
  
  static
  {
    serviceClientEnabled = Value.zzf("analytics.service_client_enabled", true);
    loggingTag = Value.zzd("analytics.log_tag", "GAv4", "GAv4-SVC");
    maxTokens = Value.zzb("analytics.max_tokens", 60L);
    tokensPerSec = Value.zza("analytics.tokens_per_sec", 0.5F);
    maxStoredHits = Value.zza("analytics.max_stored_hits", 2000, 20000);
    maxStoredHitsPerApp = Value.zze("analytics.max_stored_hits_per_app", 2000);
    maxStoredPropertiesPerApp = Value.zze("analytics.max_stored_properties_per_app", 100);
    localDispatchIntervalMillis = Value.zza("analytics.local_dispatch_millis", 1800000L, 120000L);
    initialLocalDispatchMillis = Value.zza("analytics.initial_local_dispatch_millis", 5000L, 5000L);
    minLocalDispatchMillis = Value.zzb("analytics.min_local_dispatch_millis", 120000L);
    maxLocalDispatchMillis = Value.zzb("analytics.max_local_dispatch_millis", 7200000L);
    dispatchAlarmMillis = Value.zzb("analytics.dispatch_alarm_millis", 7200000L);
    maxDispatchAlarmMillis = Value.zzb("analytics.max_dispatch_alarm_millis", 32400000L);
    maxHitsPerDispatch = Value.zze("analytics.max_hits_per_dispatch", 20);
    maxHitsPerBatch = Value.zze("analytics.max_hits_per_batch", 20);
    insecureHost = Value.zzr("analytics.insecure_host", "http://www.google-analytics.com");
    secureHost = Value.zzr("analytics.secure_host", "https://ssl.google-analytics.com");
    simplePath = Value.zzr("analytics.simple_endpoint", "/collect");
    batchingPath = Value.zzr("analytics.batching_endpoint", "/batch");
    maxGetLength = Value.zze("analytics.max_get_length", 2036);
    batchingStrategyK = Value.zzd("analytics.batching_strategy.k", zzm.zzaey.name(), zzm.zzaey.name());
    compressionStrategyK = Value.zzr("analytics.compression_strategy.k", zzp.zzaeF.name());
    maxHitsPerRequestK = Value.zze("analytics.max_hits_per_request.k", 20);
    maxHitLengthK = Value.zze("analytics.max_hit_length.k", 8192);
    maxPostLengthK = Value.zze("analytics.max_post_length.k", 8192);
    maxBatchPostLength = Value.zze("analytics.max_batch_post_length", 8192);
    fallbackResponsesK = Value.zzr("analytics.fallback_responses.k", "404,502");
    batchRetryIntervalK = Value.zze("analytics.batch_retry_interval.seconds.k", 3600);
    serviceMonitorInterval = Value.zzb("analytics.service_monitor_interval", 86400000L);
    httpConnectionConnectTimeoutMillis = Value.zze("analytics.http_connection.connect_timeout_millis", 60000);
    httpConnectionReadTimeoutMillis = Value.zze("analytics.http_connection.read_timeout_millis", 61000);
    campaignsTimeLimitMillis = Value.zzb("analytics.campaigns.time_limit", 86400000L);
    firstPartyExperimentId = Value.zzr("analytics.first_party_experiment_id", "");
    firstPartyExperimentVariant = Value.zze("analytics.first_party_experiment_variant", 0);
    disableBroadcastReceiver = Value.zzf("analytics.test.disable_receiver", false);
    serviceIdleDisconnectMillis = Value.zza("analytics.service_client.idle_disconnect_millis", 10000L, 10000L);
    serviceConnectTimeoutMillis = Value.zzb("analytics.service_client.connect_timeout_millis", 5000L);
    serviceSecondConnectDelayMillis = Value.zzb("analytics.service_client.second_connect_delay_millis", 5000L);
    serviceUnexpectedReconnectMillis = Value.zzb("analytics.service_client.unexpected_reconnect_millis", 60000L);
    serviceReconnectThrottleMillis = Value.zzb("analytics.service_client.reconnect_throttle_millis", 1800000L);
    monitoringSamplePeriodMillis = Value.zzb("analytics.monitoring.sample_period_millis", 86400000L);
  }
  
  public static final class Value<V>
  {
    private final V zzaeS;
    private final zzaav<V> zzaeT;
    private V zzaeU;
    
    private Value(zzaav<V> paramzzaav, V paramV)
    {
      zzac.zzC(paramzzaav);
      this.zzaeT = paramzzaav;
      this.zzaeS = paramV;
    }
    
    static Value<Float> zza(String paramString, float paramFloat)
    {
      return zza(paramString, paramFloat, paramFloat);
    }
    
    static Value<Float> zza(String paramString, float paramFloat1, float paramFloat2)
    {
      return new Value(zzaav.zza(paramString, Float.valueOf(paramFloat2)), Float.valueOf(paramFloat1));
    }
    
    static Value<Integer> zza(String paramString, int paramInt1, int paramInt2)
    {
      return new Value(zzaav.zza(paramString, Integer.valueOf(paramInt2)), Integer.valueOf(paramInt1));
    }
    
    static Value<Long> zza(String paramString, long paramLong1, long paramLong2)
    {
      return new Value(zzaav.zza(paramString, Long.valueOf(paramLong2)), Long.valueOf(paramLong1));
    }
    
    static Value<Boolean> zza(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      return new Value(zzaav.zzk(paramString, paramBoolean2), Boolean.valueOf(paramBoolean1));
    }
    
    static Value<Long> zzb(String paramString, long paramLong)
    {
      return zza(paramString, paramLong, paramLong);
    }
    
    static Value<String> zzd(String paramString1, String paramString2, String paramString3)
    {
      return new Value(zzaav.zzI(paramString1, paramString3), paramString2);
    }
    
    static Value<Integer> zze(String paramString, int paramInt)
    {
      return zza(paramString, paramInt, paramInt);
    }
    
    static Value<Boolean> zzf(String paramString, boolean paramBoolean)
    {
      return zza(paramString, paramBoolean, paramBoolean);
    }
    
    static Value<String> zzr(String paramString1, String paramString2)
    {
      return zzd(paramString1, paramString2, paramString2);
    }
    
    public V get()
    {
      if (this.zzaeU != null) {
        return (V)this.zzaeU;
      }
      return (V)this.zzaeS;
    }
    
    public void override(V paramV)
    {
      this.zzaeT.override(paramV);
      this.zzaeU = paramV;
    }
    
    public void resetOverride()
    {
      this.zzaeU = null;
      this.zzaeT.resetOverride();
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/analytics/internal/G.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */