// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view.inputmethod;

import android.os.*;

// Referenced classes of package android.view.inputmethod:
//            InputConnection

public final class InputBinding
    implements Parcelable {

    InputBinding(Parcel parcel) {
        mConnection = null;
        mConnectionToken = parcel.readStrongBinder();
        mUid = parcel.readInt();
        mPid = parcel.readInt();
    }

    public InputBinding(InputConnection inputconnection, IBinder ibinder, int i, int j) {
        mConnection = inputconnection;
        mConnectionToken = ibinder;
        mUid = i;
        mPid = j;
    }

    public InputBinding(InputConnection inputconnection, InputBinding inputbinding) {
        mConnection = inputconnection;
        mConnectionToken = inputbinding.getConnectionToken();
        mUid = inputbinding.getUid();
        mPid = inputbinding.getPid();
    }

    public int describeContents() {
        return 0;
    }

    public InputConnection getConnection() {
        return mConnection;
    }

    public IBinder getConnectionToken() {
        return mConnectionToken;
    }

    public int getPid() {
        return mPid;
    }

    public int getUid() {
        return mUid;
    }

    public String toString() {
        return (new StringBuilder()).append("InputBinding{").append(mConnectionToken).append(" / uid ").append(mUid).append(" / pid ").append(mPid).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(mConnectionToken);
        parcel.writeInt(mUid);
        parcel.writeInt(mPid);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public InputBinding createFromParcel(Parcel parcel) {
            return new InputBinding(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public InputBinding[] newArray(int i) {
            return new InputBinding[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    static final String TAG = "InputBinding";
    final InputConnection mConnection;
    final IBinder mConnectionToken;
    final int mPid;
    final int mUid;

}
