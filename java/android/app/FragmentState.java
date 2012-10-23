// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.os.*;
import android.util.Log;

// Referenced classes of package android.app:
//            Fragment, Activity, FragmentManagerImpl

final class FragmentState
    implements Parcelable {

    public FragmentState(Fragment fragment) {
        mClassName = fragment.getClass().getName();
        mIndex = fragment.mIndex;
        mFromLayout = fragment.mFromLayout;
        mFragmentId = fragment.mFragmentId;
        mContainerId = fragment.mContainerId;
        mTag = fragment.mTag;
        mRetainInstance = fragment.mRetainInstance;
        mDetached = fragment.mDetached;
        mArguments = fragment.mArguments;
    }

    public FragmentState(Parcel parcel) {
        boolean flag = true;
        super();
        mClassName = parcel.readString();
        mIndex = parcel.readInt();
        boolean flag1;
        boolean flag2;
        if(parcel.readInt() != 0)
            flag1 = flag;
        else
            flag1 = false;
        mFromLayout = flag1;
        mFragmentId = parcel.readInt();
        mContainerId = parcel.readInt();
        mTag = parcel.readString();
        if(parcel.readInt() != 0)
            flag2 = flag;
        else
            flag2 = false;
        mRetainInstance = flag2;
        if(parcel.readInt() == 0)
            flag = false;
        mDetached = flag;
        mArguments = parcel.readBundle();
        mSavedFragmentState = parcel.readBundle();
    }

    public int describeContents() {
        return 0;
    }

    public Fragment instantiate(Activity activity) {
        Fragment fragment;
        if(mInstance != null) {
            fragment = mInstance;
        } else {
            if(mArguments != null)
                mArguments.setClassLoader(activity.getClassLoader());
            mInstance = Fragment.instantiate(activity, mClassName, mArguments);
            if(mSavedFragmentState != null) {
                mSavedFragmentState.setClassLoader(activity.getClassLoader());
                mInstance.mSavedFragmentState = mSavedFragmentState;
            }
            mInstance.setIndex(mIndex);
            mInstance.mFromLayout = mFromLayout;
            mInstance.mRestored = true;
            mInstance.mFragmentId = mFragmentId;
            mInstance.mContainerId = mContainerId;
            mInstance.mTag = mTag;
            mInstance.mRetainInstance = mRetainInstance;
            mInstance.mDetached = mDetached;
            mInstance.mFragmentManager = activity.mFragments;
            if(FragmentManagerImpl.DEBUG)
                Log.v("FragmentManager", (new StringBuilder()).append("Instantiated fragment ").append(mInstance).toString());
            fragment = mInstance;
        }
        return fragment;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int j = 1;
        parcel.writeString(mClassName);
        parcel.writeInt(mIndex);
        int k;
        int l;
        if(mFromLayout)
            k = j;
        else
            k = 0;
        parcel.writeInt(k);
        parcel.writeInt(mFragmentId);
        parcel.writeInt(mContainerId);
        parcel.writeString(mTag);
        if(mRetainInstance)
            l = j;
        else
            l = 0;
        parcel.writeInt(l);
        if(!mDetached)
            j = 0;
        parcel.writeInt(j);
        parcel.writeBundle(mArguments);
        parcel.writeBundle(mSavedFragmentState);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public FragmentState[] newArray(int i) {
            return new FragmentState[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    final Bundle mArguments;
    final String mClassName;
    final int mContainerId;
    final boolean mDetached;
    final int mFragmentId;
    final boolean mFromLayout;
    final int mIndex;
    Fragment mInstance;
    final boolean mRetainInstance;
    Bundle mSavedFragmentState;
    final String mTag;

}
