// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.nfc;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.IOException;

// Referenced classes of package android.nfc:
//            TagLostException

public final class TransceiveResult
    implements Parcelable {

    public TransceiveResult(int i, byte abyte0[]) {
        mResult = i;
        mResponseData = abyte0;
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getResponseOrThrow() throws IOException {
        switch(mResult) {
        case 1: // '\001'
        default:
            throw new IOException("Transceive failed");

        case 0: // '\0'
            return mResponseData;

        case 2: // '\002'
            throw new TagLostException("Tag was lost.");

        case 3: // '\003'
            throw new IOException("Transceive length exceeds supported maximum");
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mResult);
        if(mResult == 0) {
            parcel.writeInt(mResponseData.length);
            parcel.writeByteArray(mResponseData);
        }
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TransceiveResult createFromParcel(Parcel parcel) {
            int i = parcel.readInt();
            byte abyte0[];
            if(i == 0) {
                abyte0 = new byte[parcel.readInt()];
                parcel.readByteArray(abyte0);
            } else {
                abyte0 = null;
            }
            return new TransceiveResult(i, abyte0);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public TransceiveResult[] newArray(int i) {
            return new TransceiveResult[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int RESULT_EXCEEDED_LENGTH = 3;
    public static final int RESULT_FAILURE = 1;
    public static final int RESULT_SUCCESS = 0;
    public static final int RESULT_TAGLOST = 2;
    final byte mResponseData[];
    final int mResult;

}
