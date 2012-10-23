// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view.inputmethod;

import android.os.*;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Printer;

public class EditorInfo
    implements InputType, Parcelable {

    public EditorInfo() {
        inputType = 0;
        imeOptions = 0;
        privateImeOptions = null;
        actionLabel = null;
        actionId = 0;
        initialSelStart = -1;
        initialSelEnd = -1;
        initialCapsMode = 0;
    }

    public int describeContents() {
        return 0;
    }

    public void dump(Printer printer, String s) {
        printer.println((new StringBuilder()).append(s).append("inputType=0x").append(Integer.toHexString(inputType)).append(" imeOptions=0x").append(Integer.toHexString(imeOptions)).append(" privateImeOptions=").append(privateImeOptions).toString());
        printer.println((new StringBuilder()).append(s).append("actionLabel=").append(actionLabel).append(" actionId=").append(actionId).toString());
        printer.println((new StringBuilder()).append(s).append("initialSelStart=").append(initialSelStart).append(" initialSelEnd=").append(initialSelEnd).append(" initialCapsMode=0x").append(Integer.toHexString(initialCapsMode)).toString());
        printer.println((new StringBuilder()).append(s).append("hintText=").append(hintText).append(" label=").append(label).toString());
        printer.println((new StringBuilder()).append(s).append("packageName=").append(packageName).append(" fieldId=").append(fieldId).append(" fieldName=").append(fieldName).toString());
        printer.println((new StringBuilder()).append(s).append("extras=").append(extras).toString());
    }

    public final void makeCompatible(int i) {
        if(i >= 11) goto _L2; else goto _L1
_L1:
        0xfff & inputType;
        JVM INSTR lookupswitch 4: default 56
    //                   2: 92
    //                   18: 92
    //                   209: 57
    //                   225: 74;
           goto _L2 _L3 _L3 _L4 _L5
_L2:
        return;
_L4:
        inputType = 0x21 | 0xfff000 & inputType;
        continue; /* Loop/switch isn't completed */
_L5:
        inputType = 0x81 | 0xfff000 & inputType;
        continue; /* Loop/switch isn't completed */
_L3:
        inputType = 2 | 0xfff000 & inputType;
        if(true) goto _L2; else goto _L6
_L6:
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(inputType);
        parcel.writeInt(imeOptions);
        parcel.writeString(privateImeOptions);
        TextUtils.writeToParcel(actionLabel, parcel, i);
        parcel.writeInt(actionId);
        parcel.writeInt(initialSelStart);
        parcel.writeInt(initialSelEnd);
        parcel.writeInt(initialCapsMode);
        TextUtils.writeToParcel(hintText, parcel, i);
        TextUtils.writeToParcel(label, parcel, i);
        parcel.writeString(packageName);
        parcel.writeInt(fieldId);
        parcel.writeString(fieldName);
        parcel.writeBundle(extras);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public EditorInfo createFromParcel(Parcel parcel) {
            EditorInfo editorinfo = new EditorInfo();
            editorinfo.inputType = parcel.readInt();
            editorinfo.imeOptions = parcel.readInt();
            editorinfo.privateImeOptions = parcel.readString();
            editorinfo.actionLabel = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            editorinfo.actionId = parcel.readInt();
            editorinfo.initialSelStart = parcel.readInt();
            editorinfo.initialSelEnd = parcel.readInt();
            editorinfo.initialCapsMode = parcel.readInt();
            editorinfo.hintText = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            editorinfo.label = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            editorinfo.packageName = parcel.readString();
            editorinfo.fieldId = parcel.readInt();
            editorinfo.fieldName = parcel.readString();
            editorinfo.extras = parcel.readBundle();
            return editorinfo;
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public EditorInfo[] newArray(int i) {
            return new EditorInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int IME_ACTION_DONE = 6;
    public static final int IME_ACTION_GO = 2;
    public static final int IME_ACTION_NEXT = 5;
    public static final int IME_ACTION_NONE = 1;
    public static final int IME_ACTION_PREVIOUS = 7;
    public static final int IME_ACTION_SEARCH = 3;
    public static final int IME_ACTION_SEND = 4;
    public static final int IME_ACTION_UNSPECIFIED = 0;
    public static final int IME_FLAG_FORCE_ASCII = 0x80000000;
    public static final int IME_FLAG_NAVIGATE_NEXT = 0x8000000;
    public static final int IME_FLAG_NAVIGATE_PREVIOUS = 0x4000000;
    public static final int IME_FLAG_NO_ACCESSORY_ACTION = 0x20000000;
    public static final int IME_FLAG_NO_ENTER_ACTION = 0x40000000;
    public static final int IME_FLAG_NO_EXTRACT_UI = 0x10000000;
    public static final int IME_FLAG_NO_FULLSCREEN = 0x2000000;
    public static final int IME_MASK_ACTION = 255;
    public static final int IME_NULL;
    public int actionId;
    public CharSequence actionLabel;
    public Bundle extras;
    public int fieldId;
    public String fieldName;
    public CharSequence hintText;
    public int imeOptions;
    public int initialCapsMode;
    public int initialSelEnd;
    public int initialSelStart;
    public int inputType;
    public CharSequence label;
    public String packageName;
    public String privateImeOptions;

}
