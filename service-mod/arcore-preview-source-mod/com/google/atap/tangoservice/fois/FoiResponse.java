package com.google.atap.tangoservice.fois;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public abstract class FoiResponse
  implements Parcelable
{
  public static final Parcelable.Creator<FoiResponse> CREATOR = new Parcelable.Creator()
  {
    public FoiResponse createFromParcel(Parcel paramAnonymousParcel)
    {
      FoiRequest.Type localType = FoiRequest.Type.fromInt(paramAnonymousParcel.readInt());
      if (localType == null) {
        return null;
      }
      String str = paramAnonymousParcel.readString();
      if (str == null) {
        return null;
      }
      Object localObject;
      switch (FoiResponse.2.$SwitchMap$com$google$atap$tangoservice$fois$FoiRequest$Type[localType.ordinal()])
      {
      default: 
        return null;
      case 1: 
        localObject = new FoiResponse.Create();
      }
      for (;;)
      {
        ((FoiResponse)localObject).mType = localType;
        ((FoiResponse)localObject).mId = str;
        ((FoiResponse)localObject).parcelRead(paramAnonymousParcel);
        return (FoiResponse)localObject;
        localObject = new FoiResponse.Load();
        continue;
        localObject = new FoiResponse.Delete();
      }
    }
    
    public FoiResponse[] newArray(int paramAnonymousInt)
    {
      return new FoiResponse[paramAnonymousInt];
    }
  };
  public String mId = "";
  public FoiRequest.Type mType = FoiRequest.Type.INVALID;
  
  private FoiResponse(FoiRequest.Type paramType)
  {
    this.mType = paramType;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  protected abstract void parcelRead(Parcel paramParcel);
  
  protected abstract void parcelWrite(Parcel paramParcel);
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mType.ordinal());
    paramParcel.writeString(this.mId);
    parcelWrite(paramParcel);
  }
  
  public static class Create
    extends FoiResponse
  {
    public String mFrameId = null;
    public int mStatus = 0;
    
    public Create()
    {
      super(null);
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject == null) || (paramObject.getClass() != Create.class)) {}
      label52:
      do
      {
        do
        {
          do
          {
            return false;
            paramObject = (Create)paramObject;
          } while (this.mType != ((Create)paramObject).mType);
          if (this.mId == null) {
            break;
          }
        } while (!this.mId.equals(((Create)paramObject).mId));
        if (this.mStatus != ((Create)paramObject).mStatus) {
          break label94;
        }
        if (this.mFrameId == null) {
          break label96;
        }
      } while (!this.mFrameId.equals(((Create)paramObject).mFrameId));
      for (;;)
      {
        return true;
        if (((Create)paramObject).mId != null) {
          break;
        }
        break label52;
        label94:
        break;
        label96:
        if (((Create)paramObject).mFrameId != null) {
          break;
        }
      }
    }
    
    protected void parcelRead(Parcel paramParcel)
    {
      this.mStatus = paramParcel.readInt();
      this.mFrameId = paramParcel.readString();
    }
    
    protected void parcelWrite(Parcel paramParcel)
    {
      paramParcel.writeInt(this.mStatus);
      paramParcel.writeString(this.mFrameId);
    }
  }
  
  public static class Delete
    extends FoiResponse
  {
    public String[] mFrameIds = null;
    public int[] mStatuses = null;
    
    public Delete()
    {
      super(null);
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject == null) || (paramObject.getClass() != Delete.class)) {}
      label90:
      for (;;)
      {
        return false;
        paramObject = (Delete)paramObject;
        if (this.mType == ((Delete)paramObject).mType) {
          if (this.mId != null)
          {
            if (!this.mId.equals(((Delete)paramObject).mId)) {}
          }
          else {
            for (;;)
            {
              if ((!Arrays.equals(this.mStatuses, ((Delete)paramObject).mStatuses)) || (!Arrays.equals(this.mFrameIds, ((Delete)paramObject).mFrameIds))) {
                break label90;
              }
              return true;
              if (((Delete)paramObject).mId != null) {
                break;
              }
            }
          }
        }
      }
    }
    
    protected void parcelRead(Parcel paramParcel)
    {
      this.mStatuses = paramParcel.createIntArray();
      this.mFrameIds = paramParcel.createStringArray();
    }
    
    protected void parcelWrite(Parcel paramParcel)
    {
      paramParcel.writeIntArray(this.mStatuses);
      paramParcel.writeStringArray(this.mFrameIds);
    }
  }
  
  public static class Load
    extends FoiResponse
  {
    public String[] mFrameIds = null;
    public int[] mStatuses = null;
    
    public Load()
    {
      super(null);
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject == null) || (paramObject.getClass() != Load.class)) {}
      label90:
      for (;;)
      {
        return false;
        paramObject = (Load)paramObject;
        if (this.mType == ((Load)paramObject).mType) {
          if (this.mId != null)
          {
            if (!this.mId.equals(((Load)paramObject).mId)) {}
          }
          else {
            for (;;)
            {
              if ((!Arrays.equals(this.mStatuses, ((Load)paramObject).mStatuses)) || (!Arrays.equals(this.mFrameIds, ((Load)paramObject).mFrameIds))) {
                break label90;
              }
              return true;
              if (((Load)paramObject).mId != null) {
                break;
              }
            }
          }
        }
      }
    }
    
    protected void parcelRead(Parcel paramParcel)
    {
      this.mStatuses = paramParcel.createIntArray();
      this.mFrameIds = paramParcel.createStringArray();
    }
    
    protected void parcelWrite(Parcel paramParcel)
    {
      paramParcel.writeIntArray(this.mStatuses);
      paramParcel.writeStringArray(this.mFrameIds);
    }
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/com/google/atap/tangoservice/fois/FoiResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */