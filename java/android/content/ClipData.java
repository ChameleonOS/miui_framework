// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.*;
import android.text.style.URLSpan;
import android.util.Log;
import java.io.*;
import java.util.ArrayList;

// Referenced classes of package android.content:
//            ClipDescription, Intent, ContentResolver, Context

public class ClipData
    implements Parcelable {
    public static class Item {

        private CharSequence coerceToHtmlOrStyledText(Context context, boolean flag) {
            boolean flag1;
            boolean flag2;
            if(mUri == null)
                break MISSING_BLOCK_LABEL_461;
            String as[] = context.getContentResolver().getStreamTypes(mUri, "text/*");
            flag1 = false;
            flag2 = false;
            if(as != null) {
                int j = as.length;
                int k = 0;
                while(k < j)  {
                    String s5 = as[k];
                    if("text/html".equals(s5))
                        flag1 = true;
                    else
                    if(s5.startsWith("text/"))
                        flag2 = true;
                    k++;
                }
            }
            if(!flag1 && !flag2) goto _L2; else goto _L1
_L1:
            FileInputStream fileinputstream = null;
            ContentResolver contentresolver;
            Uri uri;
            contentresolver = context.getContentResolver();
            uri = mUri;
            if(!flag1) goto _L4; else goto _L3
_L3:
            String s1 = "text/html";
_L6:
            StringBuilder stringbuilder;
            fileinputstream = contentresolver.openTypedAssetFileDescriptor(uri, s1, null).createInputStream();
            InputStreamReader inputstreamreader = new InputStreamReader(fileinputstream, "UTF-8");
            stringbuilder = new StringBuilder(128);
            char ac[] = new char[8192];
            do {
                int i = inputstreamreader.read(ac);
                if(i <= 0)
                    break;
                stringbuilder.append(ac, 0, i);
            } while(true);
              goto _L5
            FileNotFoundException filenotfoundexception;
            filenotfoundexception;
            Object obj;
            String s2;
            Spanned spanned;
            if(fileinputstream != null)
                try {
                    fileinputstream.close();
                }
                catch(IOException ioexception3) { }
_L2:
            if(flag)
                obj = uriToStyledText(mUri.toString());
            else
                obj = uriToHtml(mUri.toString());
_L7:
            return ((CharSequence) (obj));
_L4:
            s1 = "text/plain";
              goto _L6
_L5:
            s2 = stringbuilder.toString();
            obj = s2;
            if(!flag1)
                break MISSING_BLOCK_LABEL_339;
            if(!flag)
                break MISSING_BLOCK_LABEL_312;
            spanned = Html.fromHtml(((String) (obj)));
            Object obj1 = spanned;
            if(obj1 == null)
                obj1 = obj;
            Exception exception;
            IOException ioexception1;
            String s;
            IOException ioexception2;
            String s3;
            IOException ioexception4;
            IOException ioexception5;
            String s4;
            IOException ioexception6;
            RuntimeException runtimeexception;
            IOException ioexception7;
            if(fileinputstream != null)
                try {
                    fileinputstream.close();
                }
                catch(IOException ioexception8) { }
            obj = obj1;
            break MISSING_BLOCK_LABEL_227;
            runtimeexception;
            if(fileinputstream != null)
                try {
                    fileinputstream.close();
                }
                // Misplaced declaration of an exception variable
                catch(IOException ioexception7) { }
            break MISSING_BLOCK_LABEL_227;
            s4 = ((String) (obj)).toString();
            obj = s4;
            if(fileinputstream != null)
                try {
                    fileinputstream.close();
                }
                // Misplaced declaration of an exception variable
                catch(IOException ioexception6) { }
            break MISSING_BLOCK_LABEL_227;
label0:
            {
                if(!flag)
                    break label0;
                if(fileinputstream != null)
                    try {
                        fileinputstream.close();
                    }
                    // Misplaced declaration of an exception variable
                    catch(IOException ioexception5) { }
            }
            break MISSING_BLOCK_LABEL_227;
            s3 = Html.escapeHtml(((CharSequence) (obj)));
            obj = s3;
            if(fileinputstream != null)
                try {
                    fileinputstream.close();
                }
                // Misplaced declaration of an exception variable
                catch(IOException ioexception4) { }
            break MISSING_BLOCK_LABEL_227;
            ioexception1;
            Log.w("ClippedData", "Failure loading text", ioexception1);
            s = Html.escapeHtml(ioexception1.toString());
            obj = s;
            if(fileinputstream != null)
                try {
                    fileinputstream.close();
                }
                // Misplaced declaration of an exception variable
                catch(IOException ioexception2) { }
            break MISSING_BLOCK_LABEL_227;
            exception;
            if(fileinputstream != null)
                try {
                    fileinputstream.close();
                }
                catch(IOException ioexception) { }
            throw exception;
            if(mIntent != null) {
                if(flag)
                    obj = uriToStyledText(mIntent.toUri(1));
                else
                    obj = uriToHtml(mIntent.toUri(1));
            } else {
                obj = "";
            }
              goto _L7
        }

        private String uriToHtml(String s) {
            StringBuilder stringbuilder = new StringBuilder(256);
            stringbuilder.append("<a href=\"");
            stringbuilder.append(s);
            stringbuilder.append("\">");
            stringbuilder.append(Html.escapeHtml(s));
            stringbuilder.append("</a>");
            return stringbuilder.toString();
        }

        private CharSequence uriToStyledText(String s) {
            SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
            spannablestringbuilder.append(s);
            spannablestringbuilder.setSpan(new URLSpan(s), 0, spannablestringbuilder.length(), 33);
            return spannablestringbuilder;
        }

        public String coerceToHtmlText(Context context) {
            String s = getHtmlText();
            if(s == null) {
                CharSequence charsequence = getText();
                if(charsequence != null) {
                    if(charsequence instanceof Spanned)
                        s = Html.toHtml((Spanned)charsequence);
                    else
                        s = Html.escapeHtml(charsequence);
                } else {
                    CharSequence charsequence1 = coerceToHtmlOrStyledText(context, false);
                    String s1;
                    if(charsequence1 != null)
                        s1 = charsequence1.toString();
                    else
                        s1 = null;
                    s = s1;
                }
            }
            return s;
        }

        public CharSequence coerceToStyledText(Context context) {
            Object obj = getText();
            if(!(obj instanceof Spanned)) goto _L2; else goto _L1
_L1:
            return ((CharSequence) (obj));
_L2:
            String s;
            s = getHtmlText();
            if(s == null)
                break MISSING_BLOCK_LABEL_42;
            Spanned spanned = Html.fromHtml(s);
            if(spanned != null) {
                obj = spanned;
                continue; /* Loop/switch isn't completed */
            }
            break MISSING_BLOCK_LABEL_42;
            RuntimeException runtimeexception;
            runtimeexception;
            if(obj == null)
                obj = coerceToHtmlOrStyledText(context, true);
            if(true) goto _L1; else goto _L3
_L3:
        }

        public CharSequence coerceToText(Context context) {
            Object obj = getText();
            if(obj == null) goto _L2; else goto _L1
_L1:
            return ((CharSequence) (obj));
_L2:
            Uri uri;
            FileInputStream fileinputstream;
            uri = getUri();
            if(uri == null)
                break MISSING_BLOCK_LABEL_202;
            fileinputstream = null;
            StringBuilder stringbuilder;
            fileinputstream = context.getContentResolver().openTypedAssetFileDescriptor(uri, "text/*", null).createInputStream();
            InputStreamReader inputstreamreader = new InputStreamReader(fileinputstream, "UTF-8");
            stringbuilder = new StringBuilder(128);
            char ac[] = new char[8192];
            do {
                int i = inputstreamreader.read(ac);
                if(i <= 0)
                    break;
                stringbuilder.append(ac, 0, i);
            } while(true);
            break MISSING_BLOCK_LABEL_119;
            FileNotFoundException filenotfoundexception;
            filenotfoundexception;
            Intent intent;
            Exception exception;
            IOException ioexception1;
            String s;
            IOException ioexception2;
            String s1;
            IOException ioexception4;
            if(fileinputstream != null)
                try {
                    fileinputstream.close();
                }
                catch(IOException ioexception3) { }
            obj = uri.toString();
            continue; /* Loop/switch isn't completed */
            s1 = stringbuilder.toString();
            obj = s1;
            if(fileinputstream != null)
                try {
                    fileinputstream.close();
                }
                // Misplaced declaration of an exception variable
                catch(IOException ioexception4) { }
            continue; /* Loop/switch isn't completed */
            ioexception1;
            Log.w("ClippedData", "Failure loading text", ioexception1);
            s = ioexception1.toString();
            obj = s;
            if(fileinputstream != null)
                try {
                    fileinputstream.close();
                }
                // Misplaced declaration of an exception variable
                catch(IOException ioexception2) { }
            continue; /* Loop/switch isn't completed */
            exception;
            if(fileinputstream != null)
                try {
                    fileinputstream.close();
                }
                catch(IOException ioexception) { }
            throw exception;
            intent = getIntent();
            if(intent != null)
                obj = intent.toUri(1);
            else
                obj = "";
            if(true) goto _L1; else goto _L3
_L3:
        }

        public String getHtmlText() {
            return mHtmlText;
        }

        public Intent getIntent() {
            return mIntent;
        }

        public CharSequence getText() {
            return mText;
        }

        public Uri getUri() {
            return mUri;
        }

        public void toShortString(StringBuilder stringbuilder) {
            if(mHtmlText != null) {
                stringbuilder.append("H:");
                stringbuilder.append(mHtmlText);
            } else
            if(mText != null) {
                stringbuilder.append("T:");
                stringbuilder.append(mText);
            } else
            if(mUri != null) {
                stringbuilder.append("U:");
                stringbuilder.append(mUri);
            } else
            if(mIntent != null) {
                stringbuilder.append("I:");
                mIntent.toShortString(stringbuilder, true, true, true, true);
            } else {
                stringbuilder.append("NULL");
            }
        }

        public String toString() {
            StringBuilder stringbuilder = new StringBuilder(128);
            stringbuilder.append("ClipData.Item { ");
            toShortString(stringbuilder);
            stringbuilder.append(" }");
            return stringbuilder.toString();
        }

        final String mHtmlText;
        final Intent mIntent;
        final CharSequence mText;
        final Uri mUri;

        public Item(Intent intent) {
            mText = null;
            mHtmlText = null;
            mIntent = intent;
            mUri = null;
        }

        public Item(Uri uri) {
            mText = null;
            mHtmlText = null;
            mIntent = null;
            mUri = uri;
        }

        public Item(CharSequence charsequence) {
            mText = charsequence;
            mHtmlText = null;
            mIntent = null;
            mUri = null;
        }

        public Item(CharSequence charsequence, Intent intent, Uri uri) {
            mText = charsequence;
            mHtmlText = null;
            mIntent = intent;
            mUri = uri;
        }

        public Item(CharSequence charsequence, String s) {
            mText = charsequence;
            mHtmlText = s;
            mIntent = null;
            mUri = null;
        }

        public Item(CharSequence charsequence, String s, Intent intent, Uri uri) {
            if(s != null && charsequence == null) {
                throw new IllegalArgumentException("Plain text must be supplied if HTML text is supplied");
            } else {
                mText = charsequence;
                mHtmlText = s;
                mIntent = intent;
                mUri = uri;
                return;
            }
        }
    }


    public ClipData(ClipData clipdata) {
        mClipDescription = clipdata.mClipDescription;
        mIcon = clipdata.mIcon;
        mItems = new ArrayList(clipdata.mItems);
    }

    public ClipData(ClipDescription clipdescription, Item item) {
        mClipDescription = clipdescription;
        if(item == null) {
            throw new NullPointerException("item is null");
        } else {
            mIcon = null;
            mItems = new ArrayList();
            mItems.add(item);
            return;
        }
    }

    ClipData(Parcel parcel) {
        mClipDescription = new ClipDescription(parcel);
        int i;
        int j;
        if(parcel.readInt() != 0)
            mIcon = (Bitmap)Bitmap.CREATOR.createFromParcel(parcel);
        else
            mIcon = null;
        mItems = new ArrayList();
        i = parcel.readInt();
        j = 0;
        while(j < i)  {
            CharSequence charsequence = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            String s = parcel.readString();
            Intent intent;
            Uri uri;
            if(parcel.readInt() != 0)
                intent = (Intent)Intent.CREATOR.createFromParcel(parcel);
            else
                intent = null;
            if(parcel.readInt() != 0)
                uri = (Uri)Uri.CREATOR.createFromParcel(parcel);
            else
                uri = null;
            mItems.add(new Item(charsequence, s, intent, uri));
            j++;
        }
    }

    public ClipData(CharSequence charsequence, String as[], Item item) {
        mClipDescription = new ClipDescription(charsequence, as);
        if(item == null) {
            throw new NullPointerException("item is null");
        } else {
            mIcon = null;
            mItems = new ArrayList();
            mItems.add(item);
            return;
        }
    }

    public static ClipData newHtmlText(CharSequence charsequence, CharSequence charsequence1, String s) {
        Item item = new Item(charsequence1, s);
        return new ClipData(charsequence, MIMETYPES_TEXT_HTML, item);
    }

    public static ClipData newIntent(CharSequence charsequence, Intent intent) {
        Item item = new Item(intent);
        return new ClipData(charsequence, MIMETYPES_TEXT_INTENT, item);
    }

    public static ClipData newPlainText(CharSequence charsequence, CharSequence charsequence1) {
        Item item = new Item(charsequence1);
        return new ClipData(charsequence, MIMETYPES_TEXT_PLAIN, item);
    }

    public static ClipData newRawUri(CharSequence charsequence, Uri uri) {
        Item item = new Item(uri);
        return new ClipData(charsequence, MIMETYPES_TEXT_URILIST, item);
    }

    public static ClipData newUri(ContentResolver contentresolver, CharSequence charsequence, Uri uri) {
        byte byte0 = 2;
        Item item = new Item(uri);
        String as[] = null;
        if("content".equals(uri.getScheme())) {
            String s = contentresolver.getType(uri);
            as = contentresolver.getStreamTypes(uri, "*/*");
            if(as == null) {
                if(s != null) {
                    as = new String[byte0];
                    as[0] = s;
                    as[1] = "text/uri-list";
                }
            } else {
                int i = as.length;
                String as1[];
                int j;
                if(s == null)
                    byte0 = 1;
                as1 = new String[byte0 + i];
                j = 0;
                if(s != null) {
                    as1[0] = s;
                    j = 0 + 1;
                }
                System.arraycopy(as, 0, as1, j, as.length);
                as1[j + as.length] = "text/uri-list";
                as = as1;
            }
        }
        if(as == null)
            as = MIMETYPES_TEXT_URILIST;
        return new ClipData(charsequence, as, item);
    }

    public void addItem(Item item) {
        if(item == null) {
            throw new NullPointerException("item is null");
        } else {
            mItems.add(item);
            return;
        }
    }

    public int describeContents() {
        return 0;
    }

    public ClipDescription getDescription() {
        return mClipDescription;
    }

    public Bitmap getIcon() {
        return mIcon;
    }

    public Item getItemAt(int i) {
        return (Item)mItems.get(i);
    }

    public int getItemCount() {
        return mItems.size();
    }

    public void toShortString(StringBuilder stringbuilder) {
        boolean flag;
        if(mClipDescription != null) {
            if(!mClipDescription.toShortString(stringbuilder))
                flag = true;
            else
                flag = false;
        } else {
            flag = true;
        }
        if(mIcon != null) {
            if(!flag)
                stringbuilder.append(' ');
            flag = false;
            stringbuilder.append("I:");
            stringbuilder.append(mIcon.getWidth());
            stringbuilder.append('x');
            stringbuilder.append(mIcon.getHeight());
        }
        for(int i = 0; i < mItems.size(); i++) {
            if(!flag)
                stringbuilder.append(' ');
            flag = false;
            stringbuilder.append('{');
            ((Item)mItems.get(i)).toShortString(stringbuilder);
            stringbuilder.append('}');
        }

    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder(128);
        stringbuilder.append("ClipData { ");
        toShortString(stringbuilder);
        stringbuilder.append(" }");
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        mClipDescription.writeToParcel(parcel, i);
        int j;
        int k;
        if(mIcon != null) {
            parcel.writeInt(1);
            mIcon.writeToParcel(parcel, i);
        } else {
            parcel.writeInt(0);
        }
        j = mItems.size();
        parcel.writeInt(j);
        k = 0;
        while(k < j)  {
            Item item = (Item)mItems.get(k);
            TextUtils.writeToParcel(item.mText, parcel, i);
            parcel.writeString(item.mHtmlText);
            if(item.mIntent != null) {
                parcel.writeInt(1);
                item.mIntent.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
            if(item.mUri != null) {
                parcel.writeInt(1);
                item.mUri.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
            k++;
        }
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ClipData createFromParcel(Parcel parcel) {
            return new ClipData(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public ClipData[] newArray(int i) {
            return new ClipData[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    static final String MIMETYPES_TEXT_HTML[];
    static final String MIMETYPES_TEXT_INTENT[];
    static final String MIMETYPES_TEXT_PLAIN[];
    static final String MIMETYPES_TEXT_URILIST[];
    final ClipDescription mClipDescription;
    final Bitmap mIcon;
    final ArrayList mItems;

    static  {
        String as[] = new String[1];
        as[0] = "text/plain";
        MIMETYPES_TEXT_PLAIN = as;
        String as1[] = new String[1];
        as1[0] = "text/html";
        MIMETYPES_TEXT_HTML = as1;
        String as2[] = new String[1];
        as2[0] = "text/uri-list";
        MIMETYPES_TEXT_URILIST = as2;
        String as3[] = new String[1];
        as3[0] = "text/vnd.android.intent";
        MIMETYPES_TEXT_INTENT = as3;
    }
}
