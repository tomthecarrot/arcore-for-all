package com.google.android.gms.people;

public class PeopleConstants
{
  public static int booleanToTriState(Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return 0;
    }
    if (paramBoolean.booleanValue()) {
      return 2;
    }
    return 1;
  }
  
  public static Boolean triStateToBoolean(int paramInt)
  {
    boolean bool = true;
    if (paramInt == 0) {
      return null;
    }
    if (paramInt == 1) {
      bool = false;
    }
    return Boolean.valueOf(bool);
  }
  
  public static abstract interface AcItemType
  {
    public static final int EMAIL = 1;
    public static final int GAIA_ID = 3;
    public static final int PERSON = 0;
    public static final int PHONE = 2;
  }
  
  public static abstract interface AutocompleteDataSource
  {
    public static final int ANDROID_CONTACTS = 2;
    public static final int GOOGLE_CONTACT = 0;
    public static final int GOOGLE_PROFILE = 1;
  }
  
  public static abstract interface AutocompleteTypes
  {
    public static final int EMAIL = 0;
    public static final int EMAIL_EXACT = 1;
  }
  
  public static abstract interface Avatar
  {
    public static final String ACTION_SET_AVATAR = "com.google.android.gms.people.profile.ACTION_SET_AVATAR";
    public static final String EXTRA_ACCOUNT = "com.google.android.gms.people.profile.EXTRA_ACCOUNT";
    public static final String EXTRA_AVATAR_URL = "com.google.android.gms.people.profile.EXTRA_AVATAR_URL";
    public static final String EXTRA_PAGE_ID = "com.google.android.gms.people.profile.EXTRA_PAGE_ID";
    public static final String EXTRA_SOCIAL_CLIENT_APP_ID = "com.google.android.gms.people.profile.EXTRA_APP_ID";
    public static final String EXTRA_URI = "com.google.android.gms.people.profile.EXTRA_URI";
    public static final int RESULT_INTERNAL_ERROR = 1;
  }
  
  public static abstract interface AvatarOptions
  {
    public static final int NONE = 0;
    public static final int NO_DEFAULT_AVATAR = 1;
  }
  
  public static abstract interface AvatarSizes
  {
    public static final int CONTACTS_THUMBNAIL = 4;
    public static final int LARGE = 3;
    public static final int MEDIUM = 2;
    public static final int SMALL = 1;
    public static final int TINY = 0;
  }
  
  public static abstract interface CircleTypes
  {
    public static final int ALL = -999;
    public static final int DASHER_DOMAIN = 2;
    public static final int EXTENDED_CIRCLES = 4;
    public static final int OTHER_SYSTEM_GROUP = -2;
    public static final int PERSONAL = -1;
    public static final int PUBLIC = 1;
    public static final int SYSTEM_GROUPS = -998;
    public static final int YOUR_CIRCLES = 3;
  }
  
  public static abstract interface CircleVisibility
  {
    public static final int LIMITED = 2;
    public static final int PRIVATE = 3;
    public static final int PUBLIC = 1;
    public static final int UNKNOWN = 0;
  }
  
  public static abstract interface ContactGroupPreferredFields
  {
    public static final String EMAIL = "email";
    public static final String NAME = "name";
  }
  
  public static abstract interface ContactsSyncTargets
  {
    public static final String EVERGREEN = "$$everrgreen$$";
    public static final String ME = "$$me$$";
    public static final String MY_CIRCLES = "$$mycircles$$";
  }
  
  public static abstract interface ContainerType
  {
    public static final int CIRCLE = 2;
    public static final int CONTACT = 1;
    public static final int PROFILE = 0;
    public static final int UNKNOWN = -1;
  }
  
  public static abstract interface DataChangedScopes
  {
    public static final int AGGREGATED_PEOPLE = 12;
    public static final int AUTOCOMPLETE = 256;
    public static final int CIRCLES = 2;
    public static final int CONTACTS_PROVIDER = 8;
    public static final int OWNERS = 1;
    public static final int PEOPLE = 4;
    public static final int SYNC_CANCELLED = 128;
    public static final int SYNC_FINISHED = 32;
    public static final int SYNC_FINISHED_UNSUCCESSFUL = 64;
    public static final int SYNC_STARTED = 16;
  }
  
  public static abstract interface DirectoryAccountTypes
  {
    public static final String GOOGLE = "com.google";
  }
  
  public static abstract interface EmailTypes
  {
    public static final int HOME = 1;
    public static final int OTHER = -1;
    public static final int WORK = 2;
  }
  
  public static abstract interface Endpoints
  {
    public static final String ENDPOINT_GET = "get";
    public static final String ENDPOINT_LIST = "list";
    public static final String ENDPOINT_LIST_BY_EMAIL = "list_by_email";
    public static final String ENDPOINT_LIST_BY_FOCUS_ID = "list_by_focus_id";
    public static final String ENDPOINT_LIST_BY_PHONE = "list_by_phone";
    public static final String ENDPOINT_LIST_WITH_EMAIL_AND_PHONE = "list_by_email_and_phone";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_FOCUS_ID = "contact";
    public static final String KEY_ON_BEHALF_OF = "on_behalf_of";
    public static final String KEY_PHONE = "phone";
    public static final String KEY_TARGET_GAIA_ID = "gaia_id";
    public static final String KEY_TARGET_QUALIFIED_ID = "qualified_id";
  }
  
  public static abstract interface FocusContactRelationship
  {
    public static final int IN_VISIBLE_CONTACTS = 1;
    public static final int NOT_IN_CONTACTS = 0;
  }
  
  public static abstract interface GaiaEdgeType
  {
    public static final int ALL = 7;
    public static final int EMAIL = 1;
    public static final int EMAIL_PHONE = 3;
    public static final int PHONE = 2;
    public static final int PROFILE_URL = 4;
  }
  
  public static abstract interface InteractionTypes
  {
    public static final int CALL = 2;
    public static final int LONG_TEXT = 1;
    public static final int SHORT_TEXT = 0;
  }
  
  public static abstract interface LastSyncStatus
  {
    public static final int FAILURE = 3;
    public static final int IN_PROGRESS = 1;
    public static final int NOT_SYNCED = 0;
    public static final int SUCCESS = 2;
    public static final int UPGRADED_SYNC_NEEDED = 4;
  }
  
  public static abstract interface LoadOwnersSortOrder
  {
    public static final int ACCOUNT_CREATION_ORDER = 1;
    public static final int ACCOUNT_NAME = 0;
  }
  
  public static abstract interface OwnerEmail
  {
    public static final String CUSTOM_LABEL = "custom_label";
    public static final String EMAIL_ADDRESS = "email";
    public static final String TYPE = "type";
    public static final String _ID = "_id";
  }
  
  public static abstract interface OwnerPhone
  {
    public static final String CUSTOM_LABEL = "custom_label";
    public static final String PHONE_NUMBER = "phone";
    public static final String TYPE = "type";
    public static final String _ID = "_id";
  }
  
  public static abstract interface OwnerPostalAddress
  {
    public static final String CUSTOM_LABEL = "custom_label";
    public static final String POSTAL_ADDRESS = "postal_address";
    public static final String TYPE = "type";
    public static final String _ID = "_id";
  }
  
  public static abstract interface PeopleColumnBitmask
  {
    public static final int AFFINITY_1 = 32768;
    public static final int AFFINITY_2 = 65536;
    public static final int AFFINITY_3 = 131072;
    public static final int AFFINITY_4 = 262144;
    public static final int AFFINITY_5 = 524288;
    public static final int ALL = 2097151;
    public static final int AVATAR_URL = 32;
    public static final int BELONGING_CIRCLES = 128;
    public static final int DISPLAY_NAME = 4;
    public static final int FAMILY_NAME = 8192;
    public static final int GAIA_ID = 2;
    public static final int GIVEN_NAME = 4096;
    public static final int INTERACTION_RANK_SORT_KEY = 16;
    public static final int IN_VIEWER_DOMAIN = 1024;
    public static final int IS_BLOCKED = 256;
    public static final int LAST_MODIFIED_TIME = 512;
    public static final int NAME_VERIFIED = 2048;
    public static final int PEOPLE_IN_COMMON = 1048576;
    public static final int PROFILE_TYPE = 64;
    public static final int QUALIFIED_ID = 1;
    public static final int SORT_KEY = 8;
    public static final int _ID = 16384;
  }
  
  public static abstract interface PeopleEmail
  {
    public static final String AFFINITY_1 = "affinity1";
    public static final String AFFINITY_2 = "affinity2";
    public static final String AFFINITY_3 = "affinity3";
    public static final String AFFINITY_4 = "affinity4";
    public static final String AFFINITY_5 = "affinity5";
    public static final String CUSTOM_LABEL = "custom_label";
    public static final String EMAIL_ADDRESS = "email";
    public static final String LOGGING_ID_1 = "logging_id";
    public static final String LOGGING_ID_2 = "logging_id2";
    public static final String LOGGING_ID_3 = "logging_id3";
    public static final String LOGGING_ID_4 = "logging_id4";
    public static final String LOGGING_ID_5 = "logging_id5";
    public static final String QUALIFIED_ID = "qualified_id";
    public static final String TYPE = "type";
    public static final String _ID = "_id";
  }
  
  public static abstract interface PeopleEndpointDataFormat
  {
    public static final int MERGED_PERSON_JSON = 2;
    public static final int MERGED_PERSON_LIST_JSON = 4;
    public static final int MERGED_PERSON_LIST_PROTO = 3;
    public static final int MERGED_PERSON_PROTO = 1;
    public static final int UNKNOWN = 0;
  }
  
  public static abstract interface PeopleExtraColumnBitmask
  {
    public static final int ALL = 7;
    public static final int EMAILS = 1;
    public static final int EMAIL_AFFINITIES = 4;
    public static final int PHONES = 2;
  }
  
  public static abstract interface PeoplePhone
  {
    public static final String CUSTOM_LABEL = "custom_label";
    public static final String PHONE_NUMBER = "phone";
    public static final String QUALIFIED_ID = "qualified_id";
    public static final String TYPE = "type";
    public static final String _ID = "_id";
  }
  
  public static abstract interface PeoplePostalAddress
  {
    public static final String CUSTOM_LABEL = "custom_label";
    public static final String POSTAL_ADDRESS = "postal_address";
    public static final String QUALIFIED_ID = "qualified_id";
    public static final String TYPE = "type";
    public static final String _ID = "_id";
  }
  
  public static abstract interface PeopleSearchFields
  {
    public static final int ALL = 7;
    public static final int EMAIL = 2;
    public static final int NAME = 1;
    public static final int PHONE = 4;
  }
  
  public static abstract interface PhoneTypes
  {
    public static final int ASSISTANT = 9;
    @Deprecated
    public static final int ASSISTENT = 9;
    public static final int CALLBACK = 13;
    public static final int CAR = 10;
    public static final int COMPANY_MAIN = 8;
    public static final int GOOGLE_VOICE = 19;
    public static final int HOME = 1;
    public static final int HOME_FAX = 4;
    public static final int ISDN = 12;
    public static final int MAIN = 18;
    public static final int MOBILE = 3;
    public static final int OTHER = -1;
    public static final int OTHER_FAX = 6;
    public static final int PAGER = 7;
    public static final int RADIO = 11;
    public static final int TELEX = 14;
    public static final int TTY = 15;
    public static final int WORK = 2;
    public static final int WORK_FAX = 5;
    public static final int WORK_MOBILE = 16;
    public static final int WORK_PAGER = 17;
  }
  
  public static abstract interface PostalAddressTypes
  {
    public static final int HOME = 1;
    public static final int OTHER = -1;
    public static final int WORK = 2;
  }
  
  public static abstract interface ProfileTypes
  {
    public static final int PAGE = 2;
    public static final int PERSON = 1;
    public static final int UNKNOWN = -1;
  }
  
  public static abstract interface ServiceNames
  {
    public static final String PACKAGE_PREFIX = "com.google.android.gms.people.";
    public static final String PHENOTYPE_COMMIT_SVC = "com.google.android.gms.people.phenotype.CommitPhenotypeOperation";
    public static final String PHENOTYPE_REGISTER_SVC = "com.google.android.gms.people.phenotype.RegisterPhenotypeOperation";
  }
  
  public static abstract interface TriState
  {
    public static final int FALSE = 1;
    public static final int TRUE = 2;
    public static final int UNKNOWN = 0;
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/android/gms/people/PeopleConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */