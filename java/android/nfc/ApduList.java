// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.nfc;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.*;

public class ApduList
    implements Parcelable {

    public ApduList() {
        commands = new ArrayList();
    }

    private ApduList(Parcel parcel) {
        commands = new ArrayList();
        int i = parcel.readInt();
        for(int j = 0; j < i; j++) {
            byte abyte0[] = new byte[parcel.readInt()];
            parcel.readByteArray(abyte0);
            commands.add(abyte0);
        }

    }


    public void add(byte abyte0[]) {
        commands.add(abyte0);
    }

    public int describeContents() {
        return 0;
    }

    public List get() {
        return commands;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(commands.size());
        byte abyte0[];
        for(Iterator iterator = commands.iterator(); iterator.hasNext(); parcel.writeByteArray(abyte0)) {
            abyte0 = (byte[])iterator.next();
            parcel.writeInt(abyte0.length);
        }

    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ApduList createFromParcel(Parcel parcel) {
            return new ApduList(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public ApduList[] newArray(int i) {
            return new ApduList[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private ArrayList commands;

}
