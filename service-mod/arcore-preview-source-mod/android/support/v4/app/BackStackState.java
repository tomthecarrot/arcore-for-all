package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

final class BackStackState
  implements Parcelable
{
  public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator()
  {
    public BackStackState createFromParcel(Parcel paramAnonymousParcel)
    {
      return new BackStackState(paramAnonymousParcel);
    }
    
    public BackStackState[] newArray(int paramAnonymousInt)
    {
      return new BackStackState[paramAnonymousInt];
    }
  };
  final int mBreadCrumbShortTitleRes;
  final CharSequence mBreadCrumbShortTitleText;
  final int mBreadCrumbTitleRes;
  final CharSequence mBreadCrumbTitleText;
  final int mIndex;
  final String mName;
  final int[] mOps;
  final ArrayList<String> mSharedElementSourceNames;
  final ArrayList<String> mSharedElementTargetNames;
  final int mTransition;
  final int mTransitionStyle;
  
  public BackStackState(Parcel paramParcel)
  {
    this.mOps = paramParcel.createIntArray();
    this.mTransition = paramParcel.readInt();
    this.mTransitionStyle = paramParcel.readInt();
    this.mName = paramParcel.readString();
    this.mIndex = paramParcel.readInt();
    this.mBreadCrumbTitleRes = paramParcel.readInt();
    this.mBreadCrumbTitleText = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.mBreadCrumbShortTitleRes = paramParcel.readInt();
    this.mBreadCrumbShortTitleText = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.mSharedElementSourceNames = paramParcel.createStringArrayList();
    this.mSharedElementTargetNames = paramParcel.createStringArrayList();
  }
  
  public BackStackState(BackStackRecord paramBackStackRecord)
  {
    int i = 0;
    BackStackRecord.Op localOp = paramBackStackRecord.mHead;
    int j;
    while (localOp != null)
    {
      j = i;
      if (localOp.removed != null) {
        j = i + localOp.removed.size();
      }
      localOp = localOp.next;
      i = j;
    }
    this.mOps = new int[paramBackStackRecord.mNumOp * 7 + i];
    if (!paramBackStackRecord.mAddToBackStack) {
      throw new IllegalStateException("Not on back stack");
    }
    localOp = paramBackStackRecord.mHead;
    i = 0;
    if (localOp != null)
    {
      int[] arrayOfInt = this.mOps;
      j = i + 1;
      arrayOfInt[i] = localOp.cmd;
      arrayOfInt = this.mOps;
      int k = j + 1;
      if (localOp.fragment != null) {}
      int m;
      for (i = localOp.fragment.mIndex;; i = -1)
      {
        arrayOfInt[j] = i;
        arrayOfInt = this.mOps;
        i = k + 1;
        arrayOfInt[k] = localOp.enterAnim;
        arrayOfInt = this.mOps;
        j = i + 1;
        arrayOfInt[i] = localOp.exitAnim;
        arrayOfInt = this.mOps;
        i = j + 1;
        arrayOfInt[j] = localOp.popEnterAnim;
        arrayOfInt = this.mOps;
        m = i + 1;
        arrayOfInt[i] = localOp.popExitAnim;
        if (localOp.removed == null) {
          break label313;
        }
        k = localOp.removed.size();
        this.mOps[m] = k;
        j = 0;
        i = m + 1;
        while (j < k)
        {
          this.mOps[i] = ((Fragment)localOp.removed.get(j)).mIndex;
          j += 1;
          i += 1;
        }
      }
      for (;;)
      {
        localOp = localOp.next;
        break;
        label313:
        arrayOfInt = this.mOps;
        i = m + 1;
        arrayOfInt[m] = 0;
      }
    }
    this.mTransition = paramBackStackRecord.mTransition;
    this.mTransitionStyle = paramBackStackRecord.mTransitionStyle;
    this.mName = paramBackStackRecord.mName;
    this.mIndex = paramBackStackRecord.mIndex;
    this.mBreadCrumbTitleRes = paramBackStackRecord.mBreadCrumbTitleRes;
    this.mBreadCrumbTitleText = paramBackStackRecord.mBreadCrumbTitleText;
    this.mBreadCrumbShortTitleRes = paramBackStackRecord.mBreadCrumbShortTitleRes;
    this.mBreadCrumbShortTitleText = paramBackStackRecord.mBreadCrumbShortTitleText;
    this.mSharedElementSourceNames = paramBackStackRecord.mSharedElementSourceNames;
    this.mSharedElementTargetNames = paramBackStackRecord.mSharedElementTargetNames;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public BackStackRecord instantiate(FragmentManagerImpl paramFragmentManagerImpl)
  {
    BackStackRecord localBackStackRecord = new BackStackRecord(paramFragmentManagerImpl);
    int i = 0;
    int k = 0;
    while (i < this.mOps.length)
    {
      BackStackRecord.Op localOp = new BackStackRecord.Op();
      Object localObject = this.mOps;
      int j = i + 1;
      localOp.cmd = localObject[i];
      if (FragmentManagerImpl.DEBUG) {
        Log.v("FragmentManager", "Instantiate " + localBackStackRecord + " op #" + k + " base fragment #" + this.mOps[j]);
      }
      localObject = this.mOps;
      i = j + 1;
      j = localObject[j];
      if (j >= 0) {}
      for (localOp.fragment = ((Fragment)paramFragmentManagerImpl.mActive.get(j));; localOp.fragment = null)
      {
        localObject = this.mOps;
        j = i + 1;
        localOp.enterAnim = localObject[i];
        localObject = this.mOps;
        i = j + 1;
        localOp.exitAnim = localObject[j];
        localObject = this.mOps;
        j = i + 1;
        localOp.popEnterAnim = localObject[i];
        localObject = this.mOps;
        int m = j + 1;
        localOp.popExitAnim = localObject[j];
        localObject = this.mOps;
        i = m + 1;
        int n = localObject[m];
        j = i;
        if (n <= 0) {
          break;
        }
        localOp.removed = new ArrayList(n);
        m = 0;
        for (;;)
        {
          j = i;
          if (m >= n) {
            break;
          }
          if (FragmentManagerImpl.DEBUG) {
            Log.v("FragmentManager", "Instantiate " + localBackStackRecord + " set remove fragment #" + this.mOps[i]);
          }
          localObject = (Fragment)paramFragmentManagerImpl.mActive.get(this.mOps[i]);
          localOp.removed.add(localObject);
          m += 1;
          i += 1;
        }
      }
      i = j;
      localBackStackRecord.mEnterAnim = localOp.enterAnim;
      localBackStackRecord.mExitAnim = localOp.exitAnim;
      localBackStackRecord.mPopEnterAnim = localOp.popEnterAnim;
      localBackStackRecord.mPopExitAnim = localOp.popExitAnim;
      localBackStackRecord.addOp(localOp);
      k += 1;
    }
    localBackStackRecord.mTransition = this.mTransition;
    localBackStackRecord.mTransitionStyle = this.mTransitionStyle;
    localBackStackRecord.mName = this.mName;
    localBackStackRecord.mIndex = this.mIndex;
    localBackStackRecord.mAddToBackStack = true;
    localBackStackRecord.mBreadCrumbTitleRes = this.mBreadCrumbTitleRes;
    localBackStackRecord.mBreadCrumbTitleText = this.mBreadCrumbTitleText;
    localBackStackRecord.mBreadCrumbShortTitleRes = this.mBreadCrumbShortTitleRes;
    localBackStackRecord.mBreadCrumbShortTitleText = this.mBreadCrumbShortTitleText;
    localBackStackRecord.mSharedElementSourceNames = this.mSharedElementSourceNames;
    localBackStackRecord.mSharedElementTargetNames = this.mSharedElementTargetNames;
    localBackStackRecord.bumpBackStackNesting(1);
    return localBackStackRecord;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeIntArray(this.mOps);
    paramParcel.writeInt(this.mTransition);
    paramParcel.writeInt(this.mTransitionStyle);
    paramParcel.writeString(this.mName);
    paramParcel.writeInt(this.mIndex);
    paramParcel.writeInt(this.mBreadCrumbTitleRes);
    TextUtils.writeToParcel(this.mBreadCrumbTitleText, paramParcel, 0);
    paramParcel.writeInt(this.mBreadCrumbShortTitleRes);
    TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, paramParcel, 0);
    paramParcel.writeStringList(this.mSharedElementSourceNames);
    paramParcel.writeStringList(this.mSharedElementTargetNames);
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/app/BackStackState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */