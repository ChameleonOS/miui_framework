// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

public class ClipDescription
    implements Parcelable {

    public ClipDescription(ClipDescription clipdescription) {
        mLabel = clipdescription.mLabel;
        mMimeTypes = clipdescription.mMimeTypes;
    }

    ClipDescription(Parcel parcel) {
        mLabel = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        mMimeTypes = parcel.createStringArray();
    }

    public ClipDescription(CharSequence charsequence, String as[]) {
        if(as == null) {
            throw new NullPointerException("mimeTypes is null");
        } else {
            mLabel = charsequence;
            mMimeTypes = as;
            return;
        }
    }

    public static boolean compareMimeTypes(String s, String s1) {
        boolean flag;
        int i;
        flag = true;
        i = s1.length();
        if(i != 3 || !s1.equals("*/*")) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        int j = s1.indexOf('/');
        if(j <= 0 || (i != j + 2 || s1.charAt(j + 1) != '*' ? !s1.equals(s) : !s1.regionMatches(0, s, 0, j + 1)))
            flag = false;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public int describeContents() {
        return 0;
    }

    public String[] filterMimeTypes(String s) {
        ArrayList arraylist = null;
        for(int i = 0; i < mMimeTypes.length; i++) {
            if(!compareMimeTypes(mMimeTypes[i], s))
                continue;
            if(arraylist == null)
                arraylist = new ArrayList();
            arraylist.add(mMimeTypes[i]);
        }

        String as[];
        if(arraylist == null) {
            as = null;
        } else {
            as = new String[arraylist.size()];
            arraylist.toArray(as);
        }
        return as;
    }

    public CharSequence getLabel() {
        return mLabel;
    }

    public String getMimeType(int i) {
        return mMimeTypes[i];
    }

    public int getMimeTypeCount() {
        return mMimeTypes.length;
    }

    public boolean hasMimeType(String s) {
        int i = 0;
_L3:
        if(i >= mMimeTypes.length)
            break MISSING_BLOCK_LABEL_34;
        if(!compareMimeTypes(mMimeTypes[i], s)) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        i++;
          goto _L3
        flag = false;
          goto _L4
    }

    public boolean toShortString(StringBuilder stringbuilder) {
        boolean flag = true;
        for(int i = 0; i < mMimeTypes.length; i++) {
            if(!flag)
                stringbuilder.append(' ');
            flag = false;
            stringbuilder.append(mMimeTypes[i]);
        }

        if(mLabel != null) {
            if(!flag)
                stringbuilder.append(' ');
            flag = false;
            stringbuilder.append('"');
            stringbuilder.append(mLabel);
            stringbuilder.append('"');
        }
        boolean flag1;
        if(!flag)
            flag1 = true;
        else
            flag1 = false;
        return flag1;
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder(128);
        stringbuilder.append("ClipDescription { ");
        toShortString(stringbuilder);
        stringbuilder.append(" }");
        return stringbuilder.toString();
    }

    public void validate() {
        if(mMimeTypes == null)
            throw new NullPointerException("null mime types");
        if(mMimeTypes.length <= 0)
            throw new IllegalArgumentException("must have at least 1 mime type");
        for(int i = 0; i < mMimeTypes.length; i++)
            if(mMimeTypes[i] == null)
                throw new NullPointerException((new StringBuilder()).append("mime type at ").append(i).append(" is null").toString());

    }

    public void writeToParcel(Parcel parcel, int i) {
        TextUtils.writeToParcel(mLabel, parcel, i);
        parcel.writeStringArray(mMimeTypes);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ClipDescription createFromParcel(Parcel parcel) {
            return new ClipDescription(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public ClipDescription[] newArray(int i) {
            return new ClipDescription[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final String MIMETYPE_TEXT_HTML = "text/html";
    public static final String MIMETYPE_TEXT_INTENT = "text/vnd.android.intent";
    public static final String MIMETYPE_TEXT_PLAIN = "text/plain";
    public static final String MIMETYPE_TEXT_URILIST = "text/uri-list";
    final CharSequence mLabel;
    final String mMimeTypes[];

}
