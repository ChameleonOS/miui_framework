// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view.inputmethod;

import android.os.Parcel;
import android.os.Parcelable;

public class ExtractedTextRequest
    implements Parcelable {

    public ExtractedTextRequest() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(token);
        parcel.writeInt(flags);
        parcel.writeInt(hintMaxLines);
        parcel.writeInt(hintMaxChars);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ExtractedTextRequest createFromParcel(Parcel parcel) {
            ExtractedTextRequest extractedtextrequest = new ExtractedTextRequest();
            extractedtextrequest.token = parcel.readInt();
            extractedtextrequest.flags = parcel.readInt();
            extractedtextrequest.hintMaxLines = parcel.readInt();
            extractedtextrequest.hintMaxChars = parcel.readInt();
            return extractedtextrequest;
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public ExtractedTextRequest[] newArray(int i) {
            return new ExtractedTextRequest[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public int flags;
    public int hintMaxChars;
    public int hintMaxLines;
    public int token;

}
