// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.statusbar;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.PrintWriter;

// Referenced classes of package com.android.internal.statusbar:
//            StatusBarIcon

public class StatusBarIconList
    implements Parcelable {

    public StatusBarIconList() {
    }

    public StatusBarIconList(Parcel parcel) {
        readFromParcel(parcel);
    }

    public void copyFrom(StatusBarIconList statusbariconlist) {
        if(statusbariconlist.mSlots == null) {
            mSlots = null;
            mIcons = null;
        } else {
            int i = statusbariconlist.mSlots.length;
            mSlots = new String[i];
            mIcons = new StatusBarIcon[i];
            int j = 0;
            while(j < i)  {
                mSlots[j] = statusbariconlist.mSlots[j];
                StatusBarIcon astatusbaricon[] = mIcons;
                StatusBarIcon statusbaricon;
                if(statusbariconlist.mIcons[j] != null)
                    statusbaricon = statusbariconlist.mIcons[j].clone();
                else
                    statusbaricon = null;
                astatusbaricon[j] = statusbaricon;
                j++;
            }
        }
    }

    public void defineSlots(String as[]) {
        int i = as.length;
        String as1[] = new String[i];
        mSlots = as1;
        for(int j = 0; j < i; j++)
            as1[j] = as[j];

        mIcons = new StatusBarIcon[i];
    }

    public int describeContents() {
        return 0;
    }

    public void dump(PrintWriter printwriter) {
        int i = mSlots.length;
        printwriter.println("Icon list:");
        for(int j = 0; j < i; j++) {
            Object aobj[] = new Object[3];
            aobj[0] = Integer.valueOf(j);
            aobj[1] = mSlots[j];
            aobj[2] = mIcons[j];
            printwriter.printf("  %2d: (%s) %s\n", aobj);
        }

    }

    public StatusBarIcon getIcon(int i) {
        return mIcons[i];
    }

    public String getSlot(int i) {
        return mSlots[i];
    }

    public int getSlotIndex(String s) {
        int i;
        int j;
        i = mSlots.length;
        j = 0;
_L3:
        if(j >= i)
            break MISSING_BLOCK_LABEL_34;
        if(!s.equals(mSlots[j])) goto _L2; else goto _L1
_L1:
        return j;
_L2:
        j++;
          goto _L3
        j = -1;
          goto _L1
    }

    public int getViewIndex(int i) {
        int j = 0;
        for(int k = 0; k < i; k++)
            if(mIcons[k] != null)
                j++;

        return j;
    }

    public void readFromParcel(Parcel parcel) {
        mSlots = parcel.readStringArray();
        int i = parcel.readInt();
        if(i < 0) {
            mIcons = null;
        } else {
            mIcons = new StatusBarIcon[i];
            int j = 0;
            while(j < i)  {
                if(parcel.readInt() != 0)
                    mIcons[j] = new StatusBarIcon(parcel);
                j++;
            }
        }
    }

    public void removeIcon(int i) {
        mIcons[i] = null;
    }

    public void setIcon(int i, StatusBarIcon statusbaricon) {
        mIcons[i] = statusbaricon.clone();
    }

    public int size() {
        return mSlots.length;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringArray(mSlots);
        if(mIcons == null) {
            parcel.writeInt(-1);
        } else {
            int j = mIcons.length;
            parcel.writeInt(j);
            int k = 0;
            while(k < j)  {
                StatusBarIcon statusbaricon = mIcons[k];
                if(statusbaricon == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    statusbaricon.writeToParcel(parcel, i);
                }
                k++;
            }
        }
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public StatusBarIconList createFromParcel(Parcel parcel) {
            return new StatusBarIconList(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public StatusBarIconList[] newArray(int i) {
            return new StatusBarIconList[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private StatusBarIcon mIcons[];
    private String mSlots[];

}
