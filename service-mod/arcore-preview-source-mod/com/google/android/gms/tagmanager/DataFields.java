package com.google.android.gms.tagmanager;

public class DataFields
{
  public static final String CAMPAIGN_CONTENT = "gtm.campaign_content";
  public static final String CAMPAIGN_ID = "gtm.campaign_id";
  public static final String CAMPAIGN_KEYWORD = "gtm.campaign_keyword";
  public static final String CAMPAIGN_MEDIUM = "gtm.campaign_medium";
  public static final String CAMPAIGN_NAME = "gtm.campaign_name";
  public static final String CAMPAIGN_SOURCE = "gtm.campaign_source";
  public static final String DCLID = "gtm.dclid";
  public static final String EVENT_ACTION = "gtm.event_action";
  public static final String EVENT_CATEGORY = "gtm.event_category";
  public static final String EVENT_LABEL = "gtm.event_label";
  public static final String EVENT_TYPE = "gtm.event";
  public static final String EVENT_VALUE = "gtm.event_value";
  public static final String EXCEPTION_TYPE = "gtm.exception";
  public static final String EX_DESCRIPTION = "gtm.exception_description";
  public static final String EX_FATAL = "gtm.exception_fatal";
  public static final String GCLID = "gtm.gclid";
  public static final String GMOB_T = "gtm.gmob_t";
  public static final String GTM_EVENT_KEY = "event";
  public static final String IMPRESSION_LIST_NAME_SUFFIX = "nm";
  public static final String NON_INTERACTION = "gtm.non_interaction";
  public static final String PROMOTION_ACTION = "gtm.promotion_action";
  public static final String SCREEN_NAME = "gtm.activity_screen_name";
  public static final String SCREEN_VIEW_TYPE = "gtm.screen_view";
  public static final String SESSION_CONTROL = "gtm.session_control";
  public static final String SOCIAL_ACTION = "gtm.social_action";
  public static final String SOCIAL_NETWORK = "gtm.social_network";
  public static final String SOCIAL_TARGET = "gtm.social_target";
  public static final String SOCIAL_TYPE = "gtm.social";
  public static final String TIMING_CATEGORY = "gtm.timing_category";
  public static final String TIMING_LABEL = "gtm.timing_label";
  public static final String TIMING_TYPE = "gtm.timing";
  public static final String TIMING_VALUE = "gtm.timing_value";
  public static final String TIMING_VAR = "gtm.timing_variable";
  
  public static String impressionListPrefix(int paramInt)
  {
    return zzc("&il", paramInt);
  }
  
  public static String impressionPrefix(int paramInt)
  {
    return zzc("pi", paramInt);
  }
  
  public static String productPrefix(int paramInt)
  {
    return zzc("&pr", paramInt);
  }
  
  public static String promotionPrefix(int paramInt)
  {
    return zzc("&promo", paramInt);
  }
  
  private static String zzc(String paramString, int paramInt)
  {
    if (paramInt < 1)
    {
      Log.e(String.valueOf(paramString).length() + 37 + "index out of range for " + paramString + " (" + paramInt + ")");
      return "";
    }
    return String.valueOf(paramString).length() + 11 + paramString + paramInt;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/tagmanager/DataFields.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */