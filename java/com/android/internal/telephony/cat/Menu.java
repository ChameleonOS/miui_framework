// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony.cat;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.android.internal.telephony.cat:
//            PresentationType, Item

public class Menu
    implements Parcelable {

    public Menu() {
        items = new ArrayList();
        title = null;
        titleAttrs = null;
        defaultItem = 0;
        softKeyPreferred = false;
        helpAvailable = false;
        titleIconSelfExplanatory = false;
        itemsIconSelfExplanatory = false;
        titleIcon = null;
        presentationType = PresentationType.NAVIGATION_OPTIONS;
    }

    private Menu(Parcel parcel) {
        boolean flag = true;
        super();
        title = parcel.readString();
        titleIcon = (Bitmap)parcel.readParcelable(null);
        items = new ArrayList();
        int i = parcel.readInt();
        for(int j = 0; j < i; j++) {
            Item item = (Item)parcel.readParcelable(null);
            items.add(item);
        }

        defaultItem = parcel.readInt();
        boolean flag1;
        boolean flag2;
        boolean flag3;
        if(parcel.readInt() == flag)
            flag1 = flag;
        else
            flag1 = false;
        softKeyPreferred = flag1;
        if(parcel.readInt() == flag)
            flag2 = flag;
        else
            flag2 = false;
        helpAvailable = flag2;
        if(parcel.readInt() == flag)
            flag3 = flag;
        else
            flag3 = false;
        titleIconSelfExplanatory = flag3;
        if(parcel.readInt() != flag)
            flag = false;
        itemsIconSelfExplanatory = flag;
        presentationType = PresentationType.values()[parcel.readInt()];
    }


    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int j = 1;
        parcel.writeString(title);
        parcel.writeParcelable(titleIcon, i);
        int k = items.size();
        parcel.writeInt(k);
        for(int l = 0; l < k; l++)
            parcel.writeParcelable((Parcelable)items.get(l), i);

        parcel.writeInt(defaultItem);
        int i1;
        int j1;
        int k1;
        if(softKeyPreferred)
            i1 = j;
        else
            i1 = 0;
        parcel.writeInt(i1);
        if(helpAvailable)
            j1 = j;
        else
            j1 = 0;
        parcel.writeInt(j1);
        if(titleIconSelfExplanatory)
            k1 = j;
        else
            k1 = 0;
        parcel.writeInt(k1);
        if(!itemsIconSelfExplanatory)
            j = 0;
        parcel.writeInt(j);
        parcel.writeInt(presentationType.ordinal());
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Menu createFromParcel(Parcel parcel) {
            return new Menu(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public Menu[] newArray(int i) {
            return new Menu[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public int defaultItem;
    public boolean helpAvailable;
    public List items;
    public boolean itemsIconSelfExplanatory;
    public PresentationType presentationType;
    public boolean softKeyPreferred;
    public String title;
    public List titleAttrs;
    public Bitmap titleIcon;
    public boolean titleIconSelfExplanatory;

}
