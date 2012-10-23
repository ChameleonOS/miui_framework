// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.pm;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class ParceledListSlice
    implements Parcelable {

    public ParceledListSlice() {
        mParcel = Parcel.obtain();
    }

    private ParceledListSlice(Parcel parcel, int i, boolean flag) {
        mParcel = parcel;
        mNumItems = i;
        mIsLastSlice = flag;
    }


    public boolean append(Parcelable parcelable) {
        boolean flag = true;
        if(mParcel == null)
            throw new IllegalStateException("ParceledListSlice has already been recycled");
        parcelable.writeToParcel(mParcel, flag);
        mNumItems = 1 + mNumItems;
        if(mParcel.dataSize() <= 0x40000)
            flag = false;
        return flag;
    }

    public int describeContents() {
        return 0;
    }

    public boolean isLastSlice() {
        return mIsLastSlice;
    }

    public Parcelable populateList(List list, android.os.Parcelable.Creator creator) {
        mParcel.setDataPosition(0);
        Parcelable parcelable = null;
        for(int i = 0; i < mNumItems; i++) {
            parcelable = (Parcelable)creator.createFromParcel(mParcel);
            list.add(parcelable);
        }

        mParcel.recycle();
        mParcel = null;
        return parcelable;
    }

    public void setLastSlice(boolean flag) {
        mIsLastSlice = flag;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mNumItems);
        int j;
        if(mIsLastSlice)
            j = 1;
        else
            j = 0;
        parcel.writeInt(j);
        if(mNumItems > 0) {
            int k = mParcel.dataSize();
            parcel.writeInt(k);
            parcel.appendFrom(mParcel, 0, k);
        }
        mNumItems = 0;
        mParcel.recycle();
        mParcel = null;
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ParceledListSlice createFromParcel(Parcel parcel) {
            boolean flag = true;
            int i = parcel.readInt();
            ParceledListSlice parceledlistslice;
            if(parcel.readInt() != flag)
                flag = false;
            if(i > 0) {
                int j = parcel.readInt();
                int k = parcel.dataPosition();
                parcel.setDataPosition(k + j);
                Parcel parcel1 = Parcel.obtain();
                parcel1.setDataPosition(0);
                parcel1.appendFrom(parcel, k, j);
                parcel1.setDataPosition(0);
                parceledlistslice = new ParceledListSlice(parcel1, i, flag);
            } else {
                parceledlistslice = new ParceledListSlice();
                parceledlistslice.setLastSlice(flag);
            }
            return parceledlistslice;
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public ParceledListSlice[] newArray(int i) {
            return new ParceledListSlice[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private static final int MAX_IPC_SIZE = 0x40000;
    private boolean mIsLastSlice;
    private int mNumItems;
    private Parcel mParcel;

}
