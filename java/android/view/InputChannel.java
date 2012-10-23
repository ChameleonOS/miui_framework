// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.os.Parcel;
import android.os.Parcelable;

public final class InputChannel
    implements Parcelable {

    public InputChannel() {
    }

    private native void nativeDispose(boolean flag);

    private native String nativeGetName();

    private static native InputChannel[] nativeOpenInputChannelPair(String s);

    private native void nativeReadFromParcel(Parcel parcel);

    private native void nativeTransferTo(InputChannel inputchannel);

    private native void nativeWriteToParcel(Parcel parcel);

    public static InputChannel[] openInputChannelPair(String s) {
        if(s == null)
            throw new IllegalArgumentException("name must not be null");
        else
            return nativeOpenInputChannelPair(s);
    }

    public int describeContents() {
        return 1;
    }

    public void dispose() {
        nativeDispose(false);
    }

    protected void finalize() throws Throwable {
        nativeDispose(true);
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public String getName() {
        String s = nativeGetName();
        if(s == null)
            s = "uninitialized";
        return s;
    }

    public void readFromParcel(Parcel parcel) {
        if(parcel == null) {
            throw new IllegalArgumentException("in must not be null");
        } else {
            nativeReadFromParcel(parcel);
            return;
        }
    }

    public String toString() {
        return getName();
    }

    public void transferTo(InputChannel inputchannel) {
        if(inputchannel == null) {
            throw new IllegalArgumentException("outParameter must not be null");
        } else {
            nativeTransferTo(inputchannel);
            return;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        if(parcel == null)
            throw new IllegalArgumentException("out must not be null");
        nativeWriteToParcel(parcel);
        if((i & 1) != 0)
            dispose();
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public InputChannel createFromParcel(Parcel parcel) {
            InputChannel inputchannel = new InputChannel();
            inputchannel.readFromParcel(parcel);
            return inputchannel;
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public InputChannel[] newArray(int i) {
            return new InputChannel[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private static final boolean DEBUG = false;
    private static final String TAG = "InputChannel";
    private int mPtr;

}
