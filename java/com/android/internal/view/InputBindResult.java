// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.view;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.android.internal.view:
//            IInputMethodSession

public final class InputBindResult
    implements Parcelable {

    InputBindResult(Parcel parcel) {
        method = IInputMethodSession.Stub.asInterface(parcel.readStrongBinder());
        id = parcel.readString();
        sequence = parcel.readInt();
    }

    public InputBindResult(IInputMethodSession iinputmethodsession, String s, int i) {
        method = iinputmethodsession;
        id = s;
        sequence = i;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return (new StringBuilder()).append("InputBindResult{").append(method).append(" ").append(id).append(" #").append(sequence).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongInterface(method);
        parcel.writeString(id);
        parcel.writeInt(sequence);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public InputBindResult createFromParcel(Parcel parcel) {
            return new InputBindResult(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public InputBindResult[] newArray(int i) {
            return new InputBindResult[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    static final String TAG = "InputBindResult";
    public final String id;
    public final IInputMethodSession method;
    public final int sequence;

}
