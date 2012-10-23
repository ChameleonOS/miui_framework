// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view.inputmethod;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class ExtractedText
    implements Parcelable {

    public ExtractedText() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        TextUtils.writeToParcel(text, parcel, i);
        parcel.writeInt(startOffset);
        parcel.writeInt(partialStartOffset);
        parcel.writeInt(partialEndOffset);
        parcel.writeInt(selectionStart);
        parcel.writeInt(selectionEnd);
        parcel.writeInt(flags);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ExtractedText createFromParcel(Parcel parcel) {
            ExtractedText extractedtext = new ExtractedText();
            extractedtext.text = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            extractedtext.startOffset = parcel.readInt();
            extractedtext.partialStartOffset = parcel.readInt();
            extractedtext.partialEndOffset = parcel.readInt();
            extractedtext.selectionStart = parcel.readInt();
            extractedtext.selectionEnd = parcel.readInt();
            extractedtext.flags = parcel.readInt();
            return extractedtext;
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public ExtractedText[] newArray(int i) {
            return new ExtractedText[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int FLAG_SELECTING = 2;
    public static final int FLAG_SINGLE_LINE = 1;
    public int flags;
    public int partialEndOffset;
    public int partialStartOffset;
    public int selectionEnd;
    public int selectionStart;
    public int startOffset;
    public CharSequence text;

}
