// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class AudioRoutesInfo
    implements Parcelable {

    public AudioRoutesInfo() {
        mMainType = 0;
    }

    public AudioRoutesInfo(AudioRoutesInfo audioroutesinfo) {
        mMainType = 0;
        mBluetoothName = audioroutesinfo.mBluetoothName;
        mMainType = audioroutesinfo.mMainType;
    }

    AudioRoutesInfo(Parcel parcel) {
        mMainType = 0;
        mBluetoothName = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        mMainType = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        TextUtils.writeToParcel(mBluetoothName, parcel, i);
        parcel.writeInt(mMainType);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public AudioRoutesInfo createFromParcel(Parcel parcel) {
            return new AudioRoutesInfo(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public AudioRoutesInfo[] newArray(int i) {
            return new AudioRoutesInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    static final int MAIN_DOCK_SPEAKERS = 4;
    static final int MAIN_HDMI = 8;
    static final int MAIN_HEADPHONES = 2;
    static final int MAIN_HEADSET = 1;
    static final int MAIN_SPEAKER;
    CharSequence mBluetoothName;
    int mMainType;

}
