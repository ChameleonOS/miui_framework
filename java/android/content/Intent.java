// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.content.pm.ActivityInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.net.Uri;
import android.os.*;
import android.util.AttributeSet;
import android.util.Log;
import com.android.internal.util.XmlUtils;
import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.*;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package android.content:
//            ComponentName, ClipData, ContentResolver, Context

public class Intent
    implements Parcelable, Cloneable {
    public static final class FilterComparison {

        public boolean equals(Object obj) {
            boolean flag;
            if(obj instanceof FilterComparison) {
                Intent intent = ((FilterComparison)obj).mIntent;
                flag = mIntent.filterEquals(intent);
            } else {
                flag = false;
            }
            return flag;
        }

        public Intent getIntent() {
            return mIntent;
        }

        public int hashCode() {
            return mHashCode;
        }

        private final int mHashCode;
        private final Intent mIntent;

        public FilterComparison(Intent intent) {
            mIntent = intent;
            mHashCode = intent.filterHashCode();
        }
    }

    public static class ShortcutIconResource
        implements Parcelable {

        public static ShortcutIconResource fromContext(Context context, int i) {
            ShortcutIconResource shortcuticonresource = new ShortcutIconResource();
            shortcuticonresource.packageName = context.getPackageName();
            shortcuticonresource.resourceName = context.getResources().getResourceName(i);
            return shortcuticonresource;
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return resourceName;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(packageName);
            parcel.writeString(resourceName);
        }

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public ShortcutIconResource createFromParcel(Parcel parcel) {
                ShortcutIconResource shortcuticonresource = new ShortcutIconResource();
                shortcuticonresource.packageName = parcel.readString();
                shortcuticonresource.resourceName = parcel.readString();
                return shortcuticonresource;
            }

            public volatile Object createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            public ShortcutIconResource[] newArray(int i) {
                return new ShortcutIconResource[i];
            }

            public volatile Object[] newArray(int i) {
                return newArray(i);
            }

        };
        public String packageName;
        public String resourceName;


        public ShortcutIconResource() {
        }
    }


    public Intent() {
    }

    public Intent(Context context, Class class1) {
        mComponent = new ComponentName(context, class1);
    }

    public Intent(Intent intent) {
        mAction = intent.mAction;
        mData = intent.mData;
        mType = intent.mType;
        mPackage = intent.mPackage;
        mComponent = intent.mComponent;
        mFlags = intent.mFlags;
        if(intent.mCategories != null)
            mCategories = new HashSet(intent.mCategories);
        if(intent.mExtras != null)
            mExtras = new Bundle(intent.mExtras);
        if(intent.mSourceBounds != null)
            mSourceBounds = new Rect(intent.mSourceBounds);
        if(intent.mSelector != null)
            mSelector = new Intent(intent.mSelector);
        if(intent.mClipData != null)
            mClipData = new ClipData(intent.mClipData);
    }

    private Intent(Intent intent, boolean flag) {
        mAction = intent.mAction;
        mData = intent.mData;
        mType = intent.mType;
        mPackage = intent.mPackage;
        mComponent = intent.mComponent;
        if(intent.mCategories != null)
            mCategories = new HashSet(intent.mCategories);
    }

    protected Intent(Parcel parcel) {
        readFromParcel(parcel);
    }

    public Intent(String s) {
        setAction(s);
    }

    public Intent(String s, Uri uri) {
        setAction(s);
        mData = uri;
    }

    public Intent(String s, Uri uri, Context context, Class class1) {
        setAction(s);
        mData = uri;
        mComponent = new ComponentName(context, class1);
    }

    public static Intent createChooser(Intent intent, CharSequence charsequence) {
        Intent intent1 = new Intent("android.intent.action.CHOOSER");
        intent1.putExtra("android.intent.extra.INTENT", intent);
        if(charsequence != null)
            intent1.putExtra("android.intent.extra.TITLE", charsequence);
        int i = 3 & intent.getFlags();
        if(i != 0) {
            ClipData clipdata = intent.getClipData();
            if(clipdata == null && intent.getData() != null) {
                ClipData.Item item = new ClipData.Item(intent.getData());
                String as[];
                if(intent.getType() != null) {
                    as = new String[1];
                    as[0] = intent.getType();
                } else {
                    as = new String[0];
                }
                clipdata = new ClipData(null, as, item);
            }
            if(clipdata != null) {
                intent1.setClipData(clipdata);
                intent1.addFlags(i);
            }
        }
        return intent1;
    }

    public static Intent getIntent(String s) throws URISyntaxException {
        return parseUri(s, 0);
    }

    public static Intent getIntentOld(String s) throws URISyntaxException {
        int i;
        Intent intent;
        boolean flag;
        int j;
        i = s.lastIndexOf('#');
        if(i < 0)
            break MISSING_BLOCK_LABEL_980;
        String s1 = null;
        flag = false;
        j = i + 1;
        if(s.regionMatches(j, "action(", 0, 7)) {
            flag = true;
            int k4 = j + 7;
            int l4 = s.indexOf(')', k4);
            s1 = s.substring(k4, l4);
            j = l4 + 1;
        }
        intent = new Intent(s1);
        if(s.regionMatches(j, "categories(", 0, 11)) {
            flag = true;
            int l3 = j + 11;
            int i4;
            int j4;
            for(i4 = s.indexOf(')', l3); l3 < i4; l3 = j4 + 1) {
                j4 = s.indexOf('!', l3);
                if(j4 < 0)
                    j4 = i4;
                if(l3 < j4)
                    intent.addCategory(s.substring(l3, j4));
            }

            j = i4 + 1;
        }
        if(s.regionMatches(j, "type(", 0, 5)) {
            flag = true;
            int j3 = j + 5;
            int k3 = s.indexOf(')', j3);
            intent.mType = s.substring(j3, k3);
            j = k3 + 1;
        }
        if(s.regionMatches(j, "launchFlags(", 0, 12)) {
            flag = true;
            int l2 = j + 12;
            int i3 = s.indexOf(')', l2);
            intent.mFlags = Integer.decode(s.substring(l2, i3)).intValue();
            j = i3 + 1;
        }
        if(s.regionMatches(j, "component(", 0, 10)) {
            flag = true;
            int i2 = j + 10;
            int j2 = s.indexOf(')', i2);
            int k2 = s.indexOf('!', i2);
            if(k2 >= 0 && k2 < j2) {
                String s4 = s.substring(i2, k2);
                String s5 = s.substring(k2 + 1, j2);
                ComponentName componentname = new ComponentName(s4, s5);
                intent.mComponent = componentname;
            }
            j = j2 + 1;
        }
        if(!s.regionMatches(j, "extras(", 0, 7)) goto _L2; else goto _L1
_L1:
        int k;
        int l;
        flag = true;
        k = j + 7;
        l = s.indexOf(')', k);
        if(l == -1) {
            URISyntaxException urisyntaxexception = new URISyntaxException(s, "EXTRA missing trailing ')'", k);
            throw urisyntaxexception;
        }
          goto _L3
_L17:
        int l1;
        k = l1 + 1;
_L3:
        if(k >= l) goto _L2; else goto _L4
_L4:
        char c;
        String s2;
        String s3;
        int i1 = s.indexOf('=', k);
        if(i1 <= k + 1 || k >= l) {
            URISyntaxException urisyntaxexception1 = new URISyntaxException(s, "EXTRA missing '='", k);
            throw urisyntaxexception1;
        }
        c = s.charAt(k);
        s2 = s.substring(k + 1, i1);
        int j1 = i1 + 1;
        int k1 = s.indexOf('!', j1);
        if(k1 == -1 || k1 >= l)
            k1 = l;
        if(j1 >= k1) {
            URISyntaxException urisyntaxexception2 = new URISyntaxException(s, "EXTRA missing '!'", j1);
            throw urisyntaxexception2;
        }
        s3 = s.substring(j1, k1);
        l1 = k1;
        if(intent.mExtras == null)
            intent.mExtras = new Bundle();
        c;
        JVM INSTR lookupswitch 9: default 704
    //                   66: 804
    //                   83: 742
    //                   98: 821
    //                   99: 838
    //                   100: 859
    //                   102: 876
    //                   105: 893
    //                   108: 910
    //                   115: 927;
           goto _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14
_L5:
        try {
            URISyntaxException urisyntaxexception5 = new URISyntaxException(s, "EXTRA has unknown type", l1);
            throw urisyntaxexception5;
        }
        catch(NumberFormatException numberformatexception) {
            URISyntaxException urisyntaxexception4 = new URISyntaxException(s, "EXTRA value can't be parsed", l1);
            throw urisyntaxexception4;
        }
_L7:
        intent.mExtras.putString(s2, Uri.decode(s3));
_L15:
        char c1;
        c1 = s.charAt(l1);
        if(c1 != ')')
            continue; /* Loop/switch isn't completed */
_L2:
        URISyntaxException urisyntaxexception3;
        if(flag)
            intent.mData = Uri.parse(s.substring(0, i));
        else
            intent.mData = Uri.parse(s);
        if(intent.mAction == null)
            intent.mAction = "android.intent.action.VIEW";
_L18:
        return intent;
_L6:
        intent.mExtras.putBoolean(s2, Boolean.parseBoolean(s3));
          goto _L15
_L8:
        intent.mExtras.putByte(s2, Byte.parseByte(s3));
          goto _L15
_L9:
        intent.mExtras.putChar(s2, Uri.decode(s3).charAt(0));
          goto _L15
_L10:
        intent.mExtras.putDouble(s2, Double.parseDouble(s3));
          goto _L15
_L11:
        intent.mExtras.putFloat(s2, Float.parseFloat(s3));
          goto _L15
_L12:
        intent.mExtras.putInt(s2, Integer.parseInt(s3));
          goto _L15
_L13:
        intent.mExtras.putLong(s2, Long.parseLong(s3));
          goto _L15
_L14:
        intent.mExtras.putShort(s2, Short.parseShort(s3));
          goto _L15
        if(c1 == '!') goto _L17; else goto _L16
_L16:
        urisyntaxexception3 = new URISyntaxException(s, "EXTRA missing '!'", l1);
        throw urisyntaxexception3;
        intent = new Intent("android.intent.action.VIEW", Uri.parse(s));
          goto _L18
    }

    private static ClipData.Item makeClipItem(ArrayList arraylist, ArrayList arraylist1, ArrayList arraylist2, int i) {
        Uri uri;
        CharSequence charsequence;
        String s;
        if(arraylist != null)
            uri = (Uri)arraylist.get(i);
        else
            uri = null;
        if(arraylist1 != null)
            charsequence = (CharSequence)arraylist1.get(i);
        else
            charsequence = null;
        if(arraylist2 != null)
            s = (String)arraylist2.get(i);
        else
            s = null;
        return new ClipData.Item(charsequence, s, null, uri);
    }

    public static Intent makeMainActivity(ComponentName componentname) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setComponent(componentname);
        intent.addCategory("android.intent.category.LAUNCHER");
        return intent;
    }

    public static Intent makeMainSelectorActivity(String s, String s1) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        Intent intent1 = new Intent();
        intent1.setAction(s);
        intent1.addCategory(s1);
        intent.setSelector(intent1);
        return intent;
    }

    public static Intent makeRestartActivityTask(ComponentName componentname) {
        Intent intent = makeMainActivity(componentname);
        intent.addFlags(0x10008000);
        return intent;
    }

    public static String normalizeMimeType(String s) {
        if(s != null) goto _L2; else goto _L1
_L1:
        String s1 = null;
_L4:
        return s1;
_L2:
        s1 = s.trim().toLowerCase(Locale.US);
        int i = s1.indexOf(';');
        if(i != -1)
            s1 = s1.substring(0, i);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static Intent parseIntent(Resources resources, XmlPullParser xmlpullparser, AttributeSet attributeset) throws XmlPullParserException, IOException {
        Intent intent = new Intent();
        TypedArray typedarray = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.Intent);
        intent.setAction(typedarray.getString(2));
        String s = typedarray.getString(3);
        String s1 = typedarray.getString(1);
        Uri uri;
        String s2;
        String s3;
        int i;
        if(s != null)
            uri = Uri.parse(s);
        else
            uri = null;
        intent.setDataAndType(uri, s1);
        s2 = typedarray.getString(0);
        s3 = typedarray.getString(4);
        if(s2 != null && s3 != null)
            intent.setComponent(new ComponentName(s2, s3));
        typedarray.recycle();
        i = xmlpullparser.getDepth();
        do {
            int j = xmlpullparser.next();
            if(j == 1 || j == 3 && xmlpullparser.getDepth() <= i)
                break;
            if(j != 3 && j != 4) {
                String s4 = xmlpullparser.getName();
                if(s4.equals("category")) {
                    TypedArray typedarray1 = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.IntentCategory);
                    String s5 = typedarray1.getString(0);
                    typedarray1.recycle();
                    if(s5 != null)
                        intent.addCategory(s5);
                    XmlUtils.skipCurrentTag(xmlpullparser);
                } else
                if(s4.equals("extra")) {
                    if(intent.mExtras == null)
                        intent.mExtras = new Bundle();
                    resources.parseBundleExtra("extra", attributeset, intent.mExtras);
                    XmlUtils.skipCurrentTag(xmlpullparser);
                } else {
                    XmlUtils.skipCurrentTag(xmlpullparser);
                }
            }
        } while(true);
        return intent;
    }

    public static Intent parseUri(String s, int i) throws URISyntaxException {
        int j = 0;
        if((i & 1) == 0) goto _L2; else goto _L1
_L1:
        if(s.startsWith("intent:")) goto _L2; else goto _L3
_L3:
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            intent.setData(Uri.parse(s));
        }
        catch(IllegalArgumentException illegalargumentexception1) {
            try {
                throw new URISyntaxException(s, illegalargumentexception1.getMessage());
            }
            catch(IndexOutOfBoundsException indexoutofboundsexception) {
                throw new URISyntaxException(s, "illegal Intent URI format", j);
            }
        }
_L4:
        return intent;
_L2:
label0:
        {
            j = s.lastIndexOf("#");
            if(j == -1) {
                intent = new Intent("android.intent.action.VIEW", Uri.parse(s));
            } else {
                if(s.startsWith("#Intent;", j))
                    break label0;
                intent = getIntentOld(s);
            }
        }
          goto _L4
        Intent intent1;
        intent = new Intent("android.intent.action.VIEW");
        intent1 = intent;
        if(j < 0) goto _L6; else goto _L5
_L5:
        String s1 = s.substring(0, j);
_L13:
        String s2;
        s2 = null;
        j += "#Intent;".length();
_L12:
        if(s.startsWith("end", j)) goto _L8; else goto _L7
_L7:
        int l;
        int i1;
        String s3;
        l = s.indexOf('=', j);
        if(l < 0)
            l = j - 1;
        i1 = s.indexOf(';', j);
        if(l >= i1)
            break MISSING_BLOCK_LABEL_829;
        s3 = Uri.decode(s.substring(l + 1, i1));
_L14:
        if(s.startsWith("action=", j))
            intent.setAction(s3);
        else
        if(s.startsWith("category=", j))
            intent.addCategory(s3);
        else
        if(s.startsWith("type=", j))
            intent.mType = s3;
        else
        if(s.startsWith("launchFlags=", j))
            intent.mFlags = Integer.decode(s3).intValue();
        else
        if(s.startsWith("package=", j))
            intent.mPackage = s3;
        else
        if(s.startsWith("component=", j))
            intent.mComponent = ComponentName.unflattenFromString(s3);
        else
        if(s.startsWith("scheme=", j))
            s2 = s3;
        else
        if(s.startsWith("sourceBounds=", j))
            intent.mSourceBounds = Rect.unflattenFromString(s3);
        else
        if(i1 == j + 3 && s.startsWith("SEL", j)) {
            intent = new Intent();
        } else {
            String s4 = Uri.decode(s.substring(j + 2, l));
            if(intent.mExtras == null)
                intent.mExtras = new Bundle();
            Bundle bundle = intent.mExtras;
            if(s.startsWith("S.", j))
                bundle.putString(s4, s3);
            else
            if(s.startsWith("B.", j))
                bundle.putBoolean(s4, Boolean.parseBoolean(s3));
            else
            if(s.startsWith("b.", j))
                bundle.putByte(s4, Byte.parseByte(s3));
            else
            if(s.startsWith("c.", j))
                bundle.putChar(s4, s3.charAt(0));
            else
            if(s.startsWith("d.", j))
                bundle.putDouble(s4, Double.parseDouble(s3));
            else
            if(s.startsWith("f.", j))
                bundle.putFloat(s4, Float.parseFloat(s3));
            else
            if(s.startsWith("i.", j))
                bundle.putInt(s4, Integer.parseInt(s3));
            else
            if(s.startsWith("l.", j))
                bundle.putLong(s4, Long.parseLong(s3));
            else
            if(s.startsWith("s.", j))
                bundle.putShort(s4, Short.parseShort(s3));
            else
                throw new URISyntaxException(s, "unknown EXTRA type", j);
        }
          goto _L9
_L8:
        if(intent != intent1) {
            intent1.setSelector(intent);
            intent = intent1;
        }
        if(s1 == null) goto _L4; else goto _L10
_L10:
        int k;
        if(s1.startsWith("intent:")) {
            s1 = s1.substring(7);
            if(s2 != null)
                s1 = (new StringBuilder()).append(s2).append(':').append(s1).toString();
        }
        k = s1.length();
        if(k <= 0) goto _L4; else goto _L11
_L11:
        intent.mData = Uri.parse(s1);
          goto _L4
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        throw new URISyntaxException(s, illegalargumentexception.getMessage());
_L9:
        j = i1 + 1;
          goto _L12
_L6:
        s1 = null;
          goto _L13
        s3 = "";
          goto _L14
    }

    private void toUriInner(StringBuilder stringbuilder, String s, int i) {
        if(s != null)
            stringbuilder.append("scheme=").append(s).append(';');
        if(mAction != null)
            stringbuilder.append("action=").append(Uri.encode(mAction)).append(';');
        if(mCategories != null) {
            String s2;
            for(Iterator iterator1 = mCategories.iterator(); iterator1.hasNext(); stringbuilder.append("category=").append(Uri.encode(s2)).append(';'))
                s2 = (String)iterator1.next();

        }
        if(mType != null)
            stringbuilder.append("type=").append(Uri.encode(mType, "/")).append(';');
        if(mFlags != 0)
            stringbuilder.append("launchFlags=0x").append(Integer.toHexString(mFlags)).append(';');
        if(mPackage != null)
            stringbuilder.append("package=").append(Uri.encode(mPackage)).append(';');
        if(mComponent != null)
            stringbuilder.append("component=").append(Uri.encode(mComponent.flattenToShortString(), "/")).append(';');
        if(mSourceBounds != null)
            stringbuilder.append("sourceBounds=").append(Uri.encode(mSourceBounds.flattenToString())).append(';');
        if(mExtras == null) goto _L2; else goto _L1
_L1:
        Iterator iterator = mExtras.keySet().iterator();
_L4:
        if(iterator.hasNext()) {
            String s1 = (String)iterator.next();
            Object obj = mExtras.get(s1);
            char c;
            if(obj instanceof String)
                c = 'S';
            else
            if(obj instanceof Boolean)
                c = 'B';
            else
            if(obj instanceof Byte)
                c = 'b';
            else
            if(obj instanceof Character)
                c = 'c';
            else
            if(obj instanceof Double)
                c = 'd';
            else
            if(obj instanceof Float)
                c = 'f';
            else
            if(obj instanceof Integer)
                c = 'i';
            else
            if(obj instanceof Long)
                c = 'l';
            else
            if(obj instanceof Short)
                c = 's';
            else
                c = '\0';
            if(c != 0) {
                stringbuilder.append(c);
                stringbuilder.append('.');
                stringbuilder.append(Uri.encode(s1));
                stringbuilder.append('=');
                stringbuilder.append(Uri.encode(obj.toString()));
                stringbuilder.append(';');
            }
            continue; /* Loop/switch isn't completed */
        }
_L2:
        return;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public Intent addCategory(String s) {
        if(mCategories == null)
            mCategories = new HashSet();
        mCategories.add(s.intern());
        return this;
    }

    public Intent addFlags(int i) {
        mFlags = i | mFlags;
        return this;
    }

    public Object clone() {
        return new Intent(this);
    }

    public Intent cloneFilter() {
        return new Intent(this, false);
    }

    public int describeContents() {
        int i;
        if(mExtras != null)
            i = mExtras.describeContents();
        else
            i = 0;
        return i;
    }

    public int fillIn(Intent intent, int i) {
        int j;
        j = 0;
        if(intent.mAction != null && (mAction == null || (i & 1) != 0)) {
            mAction = intent.mAction;
            j = false | true;
        }
        if((intent.mData != null || intent.mType != null) && (mData == null && mType == null || (i & 2) != 0)) {
            mData = intent.mData;
            mType = intent.mType;
            j |= 2;
        }
        if(intent.mCategories != null && (mCategories == null || (i & 4) != 0)) {
            if(intent.mCategories != null)
                mCategories = new HashSet(intent.mCategories);
            j |= 4;
        }
        if(intent.mPackage != null && (mPackage == null || (i & 0x10) != 0) && mSelector == null) {
            mPackage = intent.mPackage;
            j |= 0x10;
        }
        if(intent.mSelector != null && (i & 0x40) != 0 && mPackage == null) {
            mSelector = new Intent(intent.mSelector);
            mPackage = null;
            j |= 0x40;
        }
        if(intent.mClipData != null && (mClipData == null || (i & 0x80) != 0)) {
            mClipData = intent.mClipData;
            j |= 0x80;
        }
        if(intent.mComponent != null && (i & 8) != 0) {
            mComponent = intent.mComponent;
            j |= 8;
        }
        mFlags = mFlags | intent.mFlags;
        if(intent.mSourceBounds != null && (mSourceBounds == null || (i & 0x20) != 0)) {
            mSourceBounds = new Rect(intent.mSourceBounds);
            j |= 0x20;
        }
        if(mExtras != null) goto _L2; else goto _L1
_L1:
        if(intent.mExtras != null)
            mExtras = new Bundle(intent.mExtras);
_L4:
        return j;
_L2:
        if(intent.mExtras != null)
            try {
                Bundle bundle = new Bundle(intent.mExtras);
                bundle.putAll(mExtras);
                mExtras = bundle;
            }
            catch(RuntimeException runtimeexception) {
                Log.w("Intent", "Failure filling in extras", runtimeexception);
            }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean filterEquals(Intent intent) {
        boolean flag;
        flag = false;
        break MISSING_BLOCK_LABEL_2;
        if(intent != null && (mAction == intent.mAction || (mAction == null ? intent.mAction.equals(mAction) : mAction.equals(intent.mAction))) && (mData == intent.mData || (mData == null ? intent.mData.equals(mData) : mData.equals(intent.mData))) && (mType == intent.mType || (mType == null ? intent.mType.equals(mType) : mType.equals(intent.mType))) && (mPackage == intent.mPackage || (mPackage == null ? intent.mPackage.equals(mPackage) : mPackage.equals(intent.mPackage))) && (mComponent == intent.mComponent || (mComponent == null ? intent.mComponent.equals(mComponent) : mComponent.equals(intent.mComponent))) && (mCategories == intent.mCategories || (mCategories == null ? intent.mCategories.equals(mCategories) : mCategories.equals(intent.mCategories))))
            flag = true;
        return flag;
    }

    public int filterHashCode() {
        int i = 0;
        if(mAction != null)
            i = 0 + mAction.hashCode();
        if(mData != null)
            i += mData.hashCode();
        if(mType != null)
            i += mType.hashCode();
        if(mPackage != null)
            i += mPackage.hashCode();
        if(mComponent != null)
            i += mComponent.hashCode();
        if(mCategories != null)
            i += mCategories.hashCode();
        return i;
    }

    public String getAction() {
        return mAction;
    }

    public boolean[] getBooleanArrayExtra(String s) {
        boolean aflag[];
        if(mExtras == null)
            aflag = null;
        else
            aflag = mExtras.getBooleanArray(s);
        return aflag;
    }

    public boolean getBooleanExtra(String s, boolean flag) {
        if(mExtras != null)
            flag = mExtras.getBoolean(s, flag);
        return flag;
    }

    public Bundle getBundleExtra(String s) {
        Bundle bundle;
        if(mExtras == null)
            bundle = null;
        else
            bundle = mExtras.getBundle(s);
        return bundle;
    }

    public byte[] getByteArrayExtra(String s) {
        byte abyte0[];
        if(mExtras == null)
            abyte0 = null;
        else
            abyte0 = mExtras.getByteArray(s);
        return abyte0;
    }

    public byte getByteExtra(String s, byte byte0) {
        if(mExtras != null)
            byte0 = mExtras.getByte(s, byte0).byteValue();
        return byte0;
    }

    public Set getCategories() {
        return mCategories;
    }

    public char[] getCharArrayExtra(String s) {
        char ac[];
        if(mExtras == null)
            ac = null;
        else
            ac = mExtras.getCharArray(s);
        return ac;
    }

    public char getCharExtra(String s, char c) {
        if(mExtras != null)
            c = mExtras.getChar(s, c);
        return c;
    }

    public CharSequence[] getCharSequenceArrayExtra(String s) {
        CharSequence acharsequence[];
        if(mExtras == null)
            acharsequence = null;
        else
            acharsequence = mExtras.getCharSequenceArray(s);
        return acharsequence;
    }

    public ArrayList getCharSequenceArrayListExtra(String s) {
        ArrayList arraylist;
        if(mExtras == null)
            arraylist = null;
        else
            arraylist = mExtras.getCharSequenceArrayList(s);
        return arraylist;
    }

    public CharSequence getCharSequenceExtra(String s) {
        CharSequence charsequence;
        if(mExtras == null)
            charsequence = null;
        else
            charsequence = mExtras.getCharSequence(s);
        return charsequence;
    }

    public ClipData getClipData() {
        return mClipData;
    }

    public ComponentName getComponent() {
        return mComponent;
    }

    public Uri getData() {
        return mData;
    }

    public String getDataString() {
        String s;
        if(mData != null)
            s = mData.toString();
        else
            s = null;
        return s;
    }

    public double[] getDoubleArrayExtra(String s) {
        double ad[];
        if(mExtras == null)
            ad = null;
        else
            ad = mExtras.getDoubleArray(s);
        return ad;
    }

    public double getDoubleExtra(String s, double d) {
        if(mExtras != null)
            d = mExtras.getDouble(s, d);
        return d;
    }

    public Object getExtra(String s) {
        return getExtra(s, null);
    }

    public Object getExtra(String s, Object obj) {
        Object obj1 = obj;
        if(mExtras != null) {
            Object obj2 = mExtras.get(s);
            if(obj2 != null)
                obj1 = obj2;
        }
        return obj1;
    }

    public Bundle getExtras() {
        Bundle bundle;
        if(mExtras != null)
            bundle = new Bundle(mExtras);
        else
            bundle = null;
        return bundle;
    }

    public int getFlags() {
        return mFlags;
    }

    public float[] getFloatArrayExtra(String s) {
        float af[];
        if(mExtras == null)
            af = null;
        else
            af = mExtras.getFloatArray(s);
        return af;
    }

    public float getFloatExtra(String s, float f) {
        if(mExtras != null)
            f = mExtras.getFloat(s, f);
        return f;
    }

    public IBinder getIBinderExtra(String s) {
        IBinder ibinder;
        if(mExtras == null)
            ibinder = null;
        else
            ibinder = mExtras.getIBinder(s);
        return ibinder;
    }

    public int[] getIntArrayExtra(String s) {
        int ai[];
        if(mExtras == null)
            ai = null;
        else
            ai = mExtras.getIntArray(s);
        return ai;
    }

    public int getIntExtra(String s, int i) {
        if(mExtras != null)
            i = mExtras.getInt(s, i);
        return i;
    }

    public ArrayList getIntegerArrayListExtra(String s) {
        ArrayList arraylist;
        if(mExtras == null)
            arraylist = null;
        else
            arraylist = mExtras.getIntegerArrayList(s);
        return arraylist;
    }

    public long[] getLongArrayExtra(String s) {
        long al[];
        if(mExtras == null)
            al = null;
        else
            al = mExtras.getLongArray(s);
        return al;
    }

    public long getLongExtra(String s, long l) {
        if(mExtras != null)
            l = mExtras.getLong(s, l);
        return l;
    }

    public String getPackage() {
        return mPackage;
    }

    public Parcelable[] getParcelableArrayExtra(String s) {
        Parcelable aparcelable[];
        if(mExtras == null)
            aparcelable = null;
        else
            aparcelable = mExtras.getParcelableArray(s);
        return aparcelable;
    }

    public ArrayList getParcelableArrayListExtra(String s) {
        ArrayList arraylist;
        if(mExtras == null)
            arraylist = null;
        else
            arraylist = mExtras.getParcelableArrayList(s);
        return arraylist;
    }

    public Parcelable getParcelableExtra(String s) {
        Parcelable parcelable;
        if(mExtras == null)
            parcelable = null;
        else
            parcelable = mExtras.getParcelable(s);
        return parcelable;
    }

    public String getScheme() {
        String s;
        if(mData != null)
            s = mData.getScheme();
        else
            s = null;
        return s;
    }

    public Intent getSelector() {
        return mSelector;
    }

    public Serializable getSerializableExtra(String s) {
        Serializable serializable;
        if(mExtras == null)
            serializable = null;
        else
            serializable = mExtras.getSerializable(s);
        return serializable;
    }

    public short[] getShortArrayExtra(String s) {
        short aword0[];
        if(mExtras == null)
            aword0 = null;
        else
            aword0 = mExtras.getShortArray(s);
        return aword0;
    }

    public short getShortExtra(String s, short word0) {
        if(mExtras != null)
            word0 = mExtras.getShort(s, word0);
        return word0;
    }

    public Rect getSourceBounds() {
        return mSourceBounds;
    }

    public String[] getStringArrayExtra(String s) {
        String as[];
        if(mExtras == null)
            as = null;
        else
            as = mExtras.getStringArray(s);
        return as;
    }

    public ArrayList getStringArrayListExtra(String s) {
        ArrayList arraylist;
        if(mExtras == null)
            arraylist = null;
        else
            arraylist = mExtras.getStringArrayList(s);
        return arraylist;
    }

    public String getStringExtra(String s) {
        String s1;
        if(mExtras == null)
            s1 = null;
        else
            s1 = mExtras.getString(s);
        return s1;
    }

    public String getType() {
        return mType;
    }

    public boolean hasCategory(String s) {
        boolean flag;
        if(mCategories != null && mCategories.contains(s))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean hasExtra(String s) {
        boolean flag;
        if(mExtras != null && mExtras.containsKey(s))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean hasFileDescriptors() {
        boolean flag;
        if(mExtras != null && mExtras.hasFileDescriptors())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isExcludingStopped() {
        boolean flag;
        if((0x30 & mFlags) == 16)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean migrateExtraStreamToClipData() {
        if(mExtras == null || !mExtras.isParcelled()) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        String s;
        if(getClipData() != null) {
            flag = false;
            continue; /* Loop/switch isn't completed */
        }
        s = getAction();
        if(!"android.intent.action.CHOOSER".equals(s))
            break MISSING_BLOCK_LABEL_103;
        Intent intent = (Intent)getParcelableExtra("android.intent.extra.INTENT");
        if(intent == null || !intent.migrateExtraStreamToClipData())
            break MISSING_BLOCK_LABEL_98;
        setClipData(intent.getClipData());
        addFlags(3 & intent.getFlags());
        flag = true;
        continue; /* Loop/switch isn't completed */
        flag = false;
        continue; /* Loop/switch isn't completed */
        if(!"android.intent.action.SEND".equals(s))
            break MISSING_BLOCK_LABEL_211;
        Uri uri = (Uri)getParcelableExtra("android.intent.extra.STREAM");
        CharSequence charsequence = getCharSequenceExtra("android.intent.extra.TEXT");
        String s1 = getStringExtra("android.intent.extra.HTML_TEXT");
        if(uri == null && charsequence == null && s1 == null)
            break MISSING_BLOCK_LABEL_419;
        String as1[] = new String[1];
        as1[0] = getType();
        setClipData(new ClipData(null, as1, new ClipData.Item(charsequence, s1, null, uri)));
        addFlags(1);
        flag = true;
        continue; /* Loop/switch isn't completed */
        if(!"android.intent.action.SEND_MULTIPLE".equals(s))
            break MISSING_BLOCK_LABEL_419;
        ArrayList arraylist = getParcelableArrayListExtra("android.intent.extra.STREAM");
        ArrayList arraylist1 = getCharSequenceArrayListExtra("android.intent.extra.TEXT");
        ArrayList arraylist2 = getStringArrayListExtra("android.intent.extra.HTML_TEXT");
        int i = -1;
        if(arraylist != null)
            i = arraylist.size();
        if(arraylist1 != null) {
            if(i >= 0 && i != arraylist1.size()) {
                flag = false;
                continue; /* Loop/switch isn't completed */
            }
            i = arraylist1.size();
        }
        if(arraylist2 != null) {
            if(i >= 0 && i != arraylist2.size()) {
                flag = false;
                continue; /* Loop/switch isn't completed */
            }
            i = arraylist2.size();
        }
        if(i <= 0)
            break MISSING_BLOCK_LABEL_419;
        String as[] = new String[1];
        as[0] = getType();
        ClipData clipdata = new ClipData(null, as, makeClipItem(arraylist, arraylist1, arraylist2, 0));
        for(int j = 1; j < i; j++)
            clipdata.addItem(makeClipItem(arraylist, arraylist1, arraylist2, j));

        setClipData(clipdata);
        addFlags(1);
        flag = true;
        continue; /* Loop/switch isn't completed */
        ClassCastException classcastexception;
        classcastexception;
_L5:
        flag = false;
        if(true) goto _L4; else goto _L3
_L3:
        ClassCastException classcastexception1;
        classcastexception1;
          goto _L5
        ClassCastException classcastexception2;
        classcastexception2;
          goto _L5
    }

    public Intent putCharSequenceArrayListExtra(String s, ArrayList arraylist) {
        if(mExtras == null)
            mExtras = new Bundle();
        mExtras.putCharSequenceArrayList(s, arraylist);
        return this;
    }

    public Intent putExtra(String s, byte byte0) {
        if(mExtras == null)
            mExtras = new Bundle();
        mExtras.putByte(s, byte0);
        return this;
    }

    public Intent putExtra(String s, char c) {
        if(mExtras == null)
            mExtras = new Bundle();
        mExtras.putChar(s, c);
        return this;
    }

    public Intent putExtra(String s, double d) {
        if(mExtras == null)
            mExtras = new Bundle();
        mExtras.putDouble(s, d);
        return this;
    }

    public Intent putExtra(String s, float f) {
        if(mExtras == null)
            mExtras = new Bundle();
        mExtras.putFloat(s, f);
        return this;
    }

    public Intent putExtra(String s, int i) {
        if(mExtras == null)
            mExtras = new Bundle();
        mExtras.putInt(s, i);
        return this;
    }

    public Intent putExtra(String s, long l) {
        if(mExtras == null)
            mExtras = new Bundle();
        mExtras.putLong(s, l);
        return this;
    }

    public Intent putExtra(String s, Bundle bundle) {
        if(mExtras == null)
            mExtras = new Bundle();
        mExtras.putBundle(s, bundle);
        return this;
    }

    public Intent putExtra(String s, IBinder ibinder) {
        if(mExtras == null)
            mExtras = new Bundle();
        mExtras.putIBinder(s, ibinder);
        return this;
    }

    public Intent putExtra(String s, Parcelable parcelable) {
        if(mExtras == null)
            mExtras = new Bundle();
        mExtras.putParcelable(s, parcelable);
        return this;
    }

    public Intent putExtra(String s, Serializable serializable) {
        if(mExtras == null)
            mExtras = new Bundle();
        mExtras.putSerializable(s, serializable);
        return this;
    }

    public Intent putExtra(String s, CharSequence charsequence) {
        if(mExtras == null)
            mExtras = new Bundle();
        mExtras.putCharSequence(s, charsequence);
        return this;
    }

    public Intent putExtra(String s, String s1) {
        if(mExtras == null)
            mExtras = new Bundle();
        mExtras.putString(s, s1);
        return this;
    }

    public Intent putExtra(String s, short word0) {
        if(mExtras == null)
            mExtras = new Bundle();
        mExtras.putShort(s, word0);
        return this;
    }

    public Intent putExtra(String s, boolean flag) {
        if(mExtras == null)
            mExtras = new Bundle();
        mExtras.putBoolean(s, flag);
        return this;
    }

    public Intent putExtra(String s, byte abyte0[]) {
        if(mExtras == null)
            mExtras = new Bundle();
        mExtras.putByteArray(s, abyte0);
        return this;
    }

    public Intent putExtra(String s, char ac[]) {
        if(mExtras == null)
            mExtras = new Bundle();
        mExtras.putCharArray(s, ac);
        return this;
    }

    public Intent putExtra(String s, double ad[]) {
        if(mExtras == null)
            mExtras = new Bundle();
        mExtras.putDoubleArray(s, ad);
        return this;
    }

    public Intent putExtra(String s, float af[]) {
        if(mExtras == null)
            mExtras = new Bundle();
        mExtras.putFloatArray(s, af);
        return this;
    }

    public Intent putExtra(String s, int ai[]) {
        if(mExtras == null)
            mExtras = new Bundle();
        mExtras.putIntArray(s, ai);
        return this;
    }

    public Intent putExtra(String s, long al[]) {
        if(mExtras == null)
            mExtras = new Bundle();
        mExtras.putLongArray(s, al);
        return this;
    }

    public Intent putExtra(String s, Parcelable aparcelable[]) {
        if(mExtras == null)
            mExtras = new Bundle();
        mExtras.putParcelableArray(s, aparcelable);
        return this;
    }

    public Intent putExtra(String s, CharSequence acharsequence[]) {
        if(mExtras == null)
            mExtras = new Bundle();
        mExtras.putCharSequenceArray(s, acharsequence);
        return this;
    }

    public Intent putExtra(String s, String as[]) {
        if(mExtras == null)
            mExtras = new Bundle();
        mExtras.putStringArray(s, as);
        return this;
    }

    public Intent putExtra(String s, short aword0[]) {
        if(mExtras == null)
            mExtras = new Bundle();
        mExtras.putShortArray(s, aword0);
        return this;
    }

    public Intent putExtra(String s, boolean aflag[]) {
        if(mExtras == null)
            mExtras = new Bundle();
        mExtras.putBooleanArray(s, aflag);
        return this;
    }

    public Intent putExtras(Intent intent) {
        if(intent.mExtras != null)
            if(mExtras == null)
                mExtras = new Bundle(intent.mExtras);
            else
                mExtras.putAll(intent.mExtras);
        return this;
    }

    public Intent putExtras(Bundle bundle) {
        if(mExtras == null)
            mExtras = new Bundle();
        mExtras.putAll(bundle);
        return this;
    }

    public Intent putIntegerArrayListExtra(String s, ArrayList arraylist) {
        if(mExtras == null)
            mExtras = new Bundle();
        mExtras.putIntegerArrayList(s, arraylist);
        return this;
    }

    public Intent putParcelableArrayListExtra(String s, ArrayList arraylist) {
        if(mExtras == null)
            mExtras = new Bundle();
        mExtras.putParcelableArrayList(s, arraylist);
        return this;
    }

    public Intent putStringArrayListExtra(String s, ArrayList arraylist) {
        if(mExtras == null)
            mExtras = new Bundle();
        mExtras.putStringArrayList(s, arraylist);
        return this;
    }

    public void readFromParcel(Parcel parcel) {
        setAction(parcel.readString());
        mData = (Uri)Uri.CREATOR.createFromParcel(parcel);
        mType = parcel.readString();
        mFlags = parcel.readInt();
        mPackage = parcel.readString();
        mComponent = ComponentName.readFromParcel(parcel);
        if(parcel.readInt() != 0)
            mSourceBounds = (Rect)Rect.CREATOR.createFromParcel(parcel);
        int i = parcel.readInt();
        if(i > 0) {
            mCategories = new HashSet();
            for(int j = 0; j < i; j++)
                mCategories.add(parcel.readString().intern());

        } else {
            mCategories = null;
        }
        if(parcel.readInt() != 0)
            mSelector = new Intent(parcel);
        if(parcel.readInt() != 0)
            mClipData = new ClipData(parcel);
        mExtras = parcel.readBundle();
    }

    public void removeCategory(String s) {
        if(mCategories != null) {
            mCategories.remove(s);
            if(mCategories.size() == 0)
                mCategories = null;
        }
    }

    public void removeExtra(String s) {
        if(mExtras != null) {
            mExtras.remove(s);
            if(mExtras.size() == 0)
                mExtras = null;
        }
    }

    public Intent replaceExtras(Intent intent) {
        Bundle bundle;
        if(intent.mExtras != null)
            bundle = new Bundle(intent.mExtras);
        else
            bundle = null;
        mExtras = bundle;
        return this;
    }

    public Intent replaceExtras(Bundle bundle) {
        Bundle bundle1;
        if(bundle != null)
            bundle1 = new Bundle(bundle);
        else
            bundle1 = null;
        mExtras = bundle1;
        return this;
    }

    public ComponentName resolveActivity(PackageManager packagemanager) {
        ComponentName componentname;
        if(mComponent != null) {
            componentname = mComponent;
        } else {
            ResolveInfo resolveinfo = packagemanager.resolveActivity(this, 0x10000);
            if(resolveinfo != null)
                componentname = new ComponentName(((PackageItemInfo) (((ComponentInfo) (resolveinfo.activityInfo)).applicationInfo)).packageName, ((PackageItemInfo) (resolveinfo.activityInfo)).name);
            else
                componentname = null;
        }
        return componentname;
    }

    public ActivityInfo resolveActivityInfo(PackageManager packagemanager, int i) {
        ActivityInfo activityinfo = null;
        if(mComponent == null) goto _L2; else goto _L1
_L1:
        ActivityInfo activityinfo1 = packagemanager.getActivityInfo(mComponent, i);
        activityinfo = activityinfo1;
_L4:
        return activityinfo;
_L2:
        ResolveInfo resolveinfo = packagemanager.resolveActivity(this, 0x10000 | i);
        if(resolveinfo != null)
            activityinfo = resolveinfo.activityInfo;
        continue; /* Loop/switch isn't completed */
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public String resolveType(ContentResolver contentresolver) {
        String s;
        if(mType != null)
            s = mType;
        else
        if(mData != null && "content".equals(mData.getScheme()))
            s = contentresolver.getType(mData);
        else
            s = null;
        return s;
    }

    public String resolveType(Context context) {
        return resolveType(context.getContentResolver());
    }

    public String resolveTypeIfNeeded(ContentResolver contentresolver) {
        String s;
        if(mComponent != null)
            s = mType;
        else
            s = resolveType(contentresolver);
        return s;
    }

    public Intent setAction(String s) {
        String s1;
        if(s != null)
            s1 = s.intern();
        else
            s1 = null;
        mAction = s1;
        return this;
    }

    public void setAllowFds(boolean flag) {
        if(mExtras != null)
            mExtras.setAllowFds(flag);
    }

    public Intent setClass(Context context, Class class1) {
        mComponent = new ComponentName(context, class1);
        return this;
    }

    public Intent setClassName(Context context, String s) {
        mComponent = new ComponentName(context, s);
        return this;
    }

    public Intent setClassName(String s, String s1) {
        mComponent = new ComponentName(s, s1);
        return this;
    }

    public void setClipData(ClipData clipdata) {
        mClipData = clipdata;
    }

    public Intent setComponent(ComponentName componentname) {
        mComponent = componentname;
        return this;
    }

    public Intent setData(Uri uri) {
        mData = uri;
        mType = null;
        return this;
    }

    public Intent setDataAndNormalize(Uri uri) {
        return setData(uri.normalizeScheme());
    }

    public Intent setDataAndType(Uri uri, String s) {
        mData = uri;
        mType = s;
        return this;
    }

    public Intent setDataAndTypeAndNormalize(Uri uri, String s) {
        return setDataAndType(uri.normalizeScheme(), normalizeMimeType(s));
    }

    public void setExtrasClassLoader(ClassLoader classloader) {
        if(mExtras != null)
            mExtras.setClassLoader(classloader);
    }

    public Intent setFlags(int i) {
        mFlags = i;
        return this;
    }

    public Intent setPackage(String s) {
        if(s != null && mSelector != null) {
            throw new IllegalArgumentException("Can't set package name when selector is already set");
        } else {
            mPackage = s;
            return this;
        }
    }

    public void setSelector(Intent intent) {
        if(intent == this)
            throw new IllegalArgumentException("Intent being set as a selector of itself");
        if(intent != null && mPackage != null) {
            throw new IllegalArgumentException("Can't set selector when package name is already set");
        } else {
            mSelector = intent;
            return;
        }
    }

    public void setSourceBounds(Rect rect) {
        if(rect != null)
            mSourceBounds = new Rect(rect);
        else
            mSourceBounds = null;
    }

    public Intent setType(String s) {
        mData = null;
        mType = s;
        return this;
    }

    public Intent setTypeAndNormalize(String s) {
        return setType(normalizeMimeType(s));
    }

    public String toInsecureString() {
        StringBuilder stringbuilder = new StringBuilder(128);
        stringbuilder.append("Intent { ");
        toShortString(stringbuilder, false, true, true, false);
        stringbuilder.append(" }");
        return stringbuilder.toString();
    }

    public String toInsecureStringWithClip() {
        StringBuilder stringbuilder = new StringBuilder(128);
        stringbuilder.append("Intent { ");
        toShortString(stringbuilder, false, true, true, true);
        stringbuilder.append(" }");
        return stringbuilder.toString();
    }

    public String toShortString(boolean flag, boolean flag1, boolean flag2, boolean flag3) {
        StringBuilder stringbuilder = new StringBuilder(128);
        toShortString(stringbuilder, flag, flag1, flag2, flag3);
        return stringbuilder.toString();
    }

    public void toShortString(StringBuilder stringbuilder, boolean flag, boolean flag1, boolean flag2, boolean flag3) {
        boolean flag4 = true;
        if(mAction != null) {
            stringbuilder.append("act=").append(mAction);
            flag4 = false;
        }
        if(mCategories != null) {
            if(!flag4)
                stringbuilder.append(' ');
            flag4 = false;
            stringbuilder.append("cat=[");
            Iterator iterator = mCategories.iterator();
            boolean flag5 = false;
            for(; iterator.hasNext(); stringbuilder.append((String)iterator.next())) {
                if(flag5)
                    stringbuilder.append(",");
                flag5 = true;
            }

            stringbuilder.append("]");
        }
        if(mData != null) {
            if(!flag4)
                stringbuilder.append(' ');
            flag4 = false;
            stringbuilder.append("dat=");
            if(flag)
                stringbuilder.append(mData.toSafeString());
            else
                stringbuilder.append(mData);
        }
        if(mType != null) {
            if(!flag4)
                stringbuilder.append(' ');
            flag4 = false;
            stringbuilder.append("typ=").append(mType);
        }
        if(mFlags != 0) {
            if(!flag4)
                stringbuilder.append(' ');
            flag4 = false;
            stringbuilder.append("flg=0x").append(Integer.toHexString(mFlags));
        }
        if(mPackage != null) {
            if(!flag4)
                stringbuilder.append(' ');
            flag4 = false;
            stringbuilder.append("pkg=").append(mPackage);
        }
        if(flag1 && mComponent != null) {
            if(!flag4)
                stringbuilder.append(' ');
            flag4 = false;
            stringbuilder.append("cmp=").append(mComponent.flattenToShortString());
        }
        if(mSourceBounds != null) {
            if(!flag4)
                stringbuilder.append(' ');
            flag4 = false;
            stringbuilder.append("bnds=").append(mSourceBounds.toShortString());
        }
        if(mClipData != null) {
            if(!flag4)
                stringbuilder.append(' ');
            flag4 = false;
            if(flag3) {
                stringbuilder.append("clip={");
                mClipData.toShortString(stringbuilder);
                stringbuilder.append('}');
            } else {
                stringbuilder.append("(has clip)");
            }
        }
        if(flag2 && mExtras != null) {
            if(!flag4)
                stringbuilder.append(' ');
            stringbuilder.append("(has extras)");
        }
        if(mSelector != null) {
            stringbuilder.append(" sel={");
            mSelector.toShortString(stringbuilder, flag, flag1, flag2, flag3);
            stringbuilder.append("}");
        }
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder(128);
        stringbuilder.append("Intent { ");
        toShortString(stringbuilder, true, true, true, false);
        stringbuilder.append(" }");
        return stringbuilder.toString();
    }

    public String toURI() {
        return toUri(0);
    }

    public String toUri(int i) {
        StringBuilder stringbuilder;
        String s;
        stringbuilder = new StringBuilder(128);
        s = null;
        if(mData == null) goto _L2; else goto _L1
_L1:
        String s1;
label0:
        {
            s1 = mData.toString();
            if((i & 1) == 0)
                break label0;
            int j = s1.length();
            int k = 0;
            char c;
            do {
                if(k >= j)
                    break label0;
                c = s1.charAt(k);
                if((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && c != '.' && c != '-')
                    break;
                k++;
            } while(true);
            if(c == ':' && k > 0) {
                s = s1.substring(0, k);
                stringbuilder.append("intent:");
                s1 = s1.substring(k + 1);
            }
        }
        stringbuilder.append(s1);
_L4:
        stringbuilder.append("#Intent;");
        toUriInner(stringbuilder, s, i);
        if(mSelector != null) {
            stringbuilder.append("SEL;");
            mSelector.toUriInner(stringbuilder, null, i);
        }
        stringbuilder.append("end");
        return stringbuilder.toString();
_L2:
        if((i & 1) != 0)
            stringbuilder.append("intent:");
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mAction);
        Uri.writeToParcel(parcel, mData);
        parcel.writeString(mType);
        parcel.writeInt(mFlags);
        parcel.writeString(mPackage);
        ComponentName.writeToParcel(mComponent, parcel);
        if(mSourceBounds != null) {
            parcel.writeInt(1);
            mSourceBounds.writeToParcel(parcel, i);
        } else {
            parcel.writeInt(0);
        }
        if(mCategories != null) {
            parcel.writeInt(mCategories.size());
            for(Iterator iterator = mCategories.iterator(); iterator.hasNext(); parcel.writeString((String)iterator.next()));
        } else {
            parcel.writeInt(0);
        }
        if(mSelector != null) {
            parcel.writeInt(1);
            mSelector.writeToParcel(parcel, i);
        } else {
            parcel.writeInt(0);
        }
        if(mClipData != null) {
            parcel.writeInt(1);
            mClipData.writeToParcel(parcel, i);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeBundle(mExtras);
    }

    public static final String ACTION_ADVANCED_SETTINGS_CHANGED = "android.intent.action.ADVANCED_SETTINGS";
    public static final String ACTION_AIRPLANE_MODE_CHANGED = "android.intent.action.AIRPLANE_MODE";
    public static final String ACTION_ALARM_CHANGED = "android.intent.action.ALARM_CHANGED";
    public static final String ACTION_ALL_APPS = "android.intent.action.ALL_APPS";
    public static final String ACTION_ANALOG_AUDIO_DOCK_PLUG = "android.intent.action.ANALOG_AUDIO_DOCK_PLUG";
    public static final String ACTION_ANSWER = "android.intent.action.ANSWER";
    public static final String ACTION_APP_ERROR = "android.intent.action.APP_ERROR";
    public static final String ACTION_ASSIST = "android.intent.action.ASSIST";
    public static final String ACTION_ATTACH_DATA = "android.intent.action.ATTACH_DATA";
    public static final String ACTION_BATTERY_CHANGED = "android.intent.action.BATTERY_CHANGED";
    public static final String ACTION_BATTERY_LOW = "android.intent.action.BATTERY_LOW";
    public static final String ACTION_BATTERY_OKAY = "android.intent.action.BATTERY_OKAY";
    public static final String ACTION_BOOT_COMPLETED = "android.intent.action.BOOT_COMPLETED";
    public static final String ACTION_BUG_REPORT = "android.intent.action.BUG_REPORT";
    public static final String ACTION_CALL = "android.intent.action.CALL";
    public static final String ACTION_CALL_BUTTON = "android.intent.action.CALL_BUTTON";
    public static final String ACTION_CALL_EMERGENCY = "android.intent.action.CALL_EMERGENCY";
    public static final String ACTION_CALL_PRIVILEGED = "android.intent.action.CALL_PRIVILEGED";
    public static final String ACTION_CAMERA_BUTTON = "android.intent.action.CAMERA_BUTTON";
    public static final String ACTION_CHOOSER = "android.intent.action.CHOOSER";
    public static final String ACTION_CLEAR_DNS_CACHE = "android.intent.action.CLEAR_DNS_CACHE";
    public static final String ACTION_CLOSE_SYSTEM_DIALOGS = "android.intent.action.CLOSE_SYSTEM_DIALOGS";
    public static final String ACTION_CONFIGURATION_CHANGED = "android.intent.action.CONFIGURATION_CHANGED";
    public static final String ACTION_CREATE_SHORTCUT = "android.intent.action.CREATE_SHORTCUT";
    public static final String ACTION_DATE_CHANGED = "android.intent.action.DATE_CHANGED";
    public static final String ACTION_DEFAULT = "android.intent.action.VIEW";
    public static final String ACTION_DELETE = "android.intent.action.DELETE";
    public static final String ACTION_DEVICE_STORAGE_FULL = "android.intent.action.DEVICE_STORAGE_FULL";
    public static final String ACTION_DEVICE_STORAGE_LOW = "android.intent.action.DEVICE_STORAGE_LOW";
    public static final String ACTION_DEVICE_STORAGE_NOT_FULL = "android.intent.action.DEVICE_STORAGE_NOT_FULL";
    public static final String ACTION_DEVICE_STORAGE_OK = "android.intent.action.DEVICE_STORAGE_OK";
    public static final String ACTION_DIAL = "android.intent.action.DIAL";
    public static final String ACTION_DIGITAL_AUDIO_DOCK_PLUG = "android.intent.action.DIGITAL_AUDIO_DOCK_PLUG";
    public static final String ACTION_DOCK_EVENT = "android.intent.action.DOCK_EVENT";
    public static final String ACTION_EDIT = "android.intent.action.EDIT";
    public static final String ACTION_EXTERNAL_APPLICATIONS_AVAILABLE = "android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE";
    public static final String ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE = "android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE";
    public static final String ACTION_FACTORY_TEST = "android.intent.action.FACTORY_TEST";
    public static final String ACTION_GET_CONTENT = "android.intent.action.GET_CONTENT";
    public static final String ACTION_GTALK_SERVICE_CONNECTED = "android.intent.action.GTALK_CONNECTED";
    public static final String ACTION_GTALK_SERVICE_DISCONNECTED = "android.intent.action.GTALK_DISCONNECTED";
    public static final String ACTION_HDMI_AUDIO_PLUG = "android.intent.action.HDMI_AUDIO_PLUG";
    public static final String ACTION_HEADSET_PLUG = "android.intent.action.HEADSET_PLUG";
    public static final String ACTION_INPUT_METHOD_CHANGED = "android.intent.action.INPUT_METHOD_CHANGED";
    public static final String ACTION_INSERT = "android.intent.action.INSERT";
    public static final String ACTION_INSERT_OR_EDIT = "android.intent.action.INSERT_OR_EDIT";
    public static final String ACTION_INSTALL_PACKAGE = "android.intent.action.INSTALL_PACKAGE";
    public static final String ACTION_LOCALE_CHANGED = "android.intent.action.LOCALE_CHANGED";
    public static final String ACTION_MAIN = "android.intent.action.MAIN";
    public static final String ACTION_MANAGE_NETWORK_USAGE = "android.intent.action.MANAGE_NETWORK_USAGE";
    public static final String ACTION_MANAGE_PACKAGE_STORAGE = "android.intent.action.MANAGE_PACKAGE_STORAGE";
    public static final String ACTION_MEDIA_BAD_REMOVAL = "android.intent.action.MEDIA_BAD_REMOVAL";
    public static final String ACTION_MEDIA_BUTTON = "android.intent.action.MEDIA_BUTTON";
    public static final String ACTION_MEDIA_CHECKING = "android.intent.action.MEDIA_CHECKING";
    public static final String ACTION_MEDIA_EJECT = "android.intent.action.MEDIA_EJECT";
    public static final String ACTION_MEDIA_MOUNTED = "android.intent.action.MEDIA_MOUNTED";
    public static final String ACTION_MEDIA_NOFS = "android.intent.action.MEDIA_NOFS";
    public static final String ACTION_MEDIA_REMOVED = "android.intent.action.MEDIA_REMOVED";
    public static final String ACTION_MEDIA_SCANNER_FINISHED = "android.intent.action.MEDIA_SCANNER_FINISHED";
    public static final String ACTION_MEDIA_SCANNER_SCAN_FILE = "android.intent.action.MEDIA_SCANNER_SCAN_FILE";
    public static final String ACTION_MEDIA_SCANNER_STARTED = "android.intent.action.MEDIA_SCANNER_STARTED";
    public static final String ACTION_MEDIA_SHARED = "android.intent.action.MEDIA_SHARED";
    public static final String ACTION_MEDIA_UNMOUNTABLE = "android.intent.action.MEDIA_UNMOUNTABLE";
    public static final String ACTION_MEDIA_UNMOUNTED = "android.intent.action.MEDIA_UNMOUNTED";
    public static final String ACTION_MEDIA_UNSHARED = "android.intent.action.MEDIA_UNSHARED";
    public static final String ACTION_MY_PACKAGE_REPLACED = "android.intent.action.MY_PACKAGE_REPLACED";
    public static final String ACTION_NEW_OUTGOING_CALL = "android.intent.action.NEW_OUTGOING_CALL";
    public static final String ACTION_PACKAGE_ADDED = "android.intent.action.PACKAGE_ADDED";
    public static final String ACTION_PACKAGE_CHANGED = "android.intent.action.PACKAGE_CHANGED";
    public static final String ACTION_PACKAGE_DATA_CLEARED = "android.intent.action.PACKAGE_DATA_CLEARED";
    public static final String ACTION_PACKAGE_FIRST_LAUNCH = "android.intent.action.PACKAGE_FIRST_LAUNCH";
    public static final String ACTION_PACKAGE_FULLY_REMOVED = "android.intent.action.PACKAGE_FULLY_REMOVED";
    public static final String ACTION_PACKAGE_INSTALL = "android.intent.action.PACKAGE_INSTALL";
    public static final String ACTION_PACKAGE_NEEDS_VERIFICATION = "android.intent.action.PACKAGE_NEEDS_VERIFICATION";
    public static final String ACTION_PACKAGE_REMOVED = "android.intent.action.PACKAGE_REMOVED";
    public static final String ACTION_PACKAGE_REPLACED = "android.intent.action.PACKAGE_REPLACED";
    public static final String ACTION_PACKAGE_RESTARTED = "android.intent.action.PACKAGE_RESTARTED";
    public static final String ACTION_PASTE = "android.intent.action.PASTE";
    public static final String ACTION_PICK = "android.intent.action.PICK";
    public static final String ACTION_PICK_ACTIVITY = "android.intent.action.PICK_ACTIVITY";
    public static final String ACTION_POWER_CONNECTED = "android.intent.action.ACTION_POWER_CONNECTED";
    public static final String ACTION_POWER_DISCONNECTED = "android.intent.action.ACTION_POWER_DISCONNECTED";
    public static final String ACTION_POWER_USAGE_SUMMARY = "android.intent.action.POWER_USAGE_SUMMARY";
    public static final String ACTION_PRE_BOOT_COMPLETED = "android.intent.action.PRE_BOOT_COMPLETED";
    public static final String ACTION_PROVIDER_CHANGED = "android.intent.action.PROVIDER_CHANGED";
    public static final String ACTION_QUERY_PACKAGE_RESTART = "android.intent.action.QUERY_PACKAGE_RESTART";
    public static final String ACTION_REBOOT = "android.intent.action.REBOOT";
    public static final String ACTION_REMOTE_INTENT = "com.google.android.c2dm.intent.RECEIVE";
    public static final String ACTION_REQUEST_SHUTDOWN = "android.intent.action.ACTION_REQUEST_SHUTDOWN";
    public static final String ACTION_RUN = "android.intent.action.RUN";
    public static final String ACTION_SCREEN_OFF = "android.intent.action.SCREEN_OFF";
    public static final String ACTION_SCREEN_ON = "android.intent.action.SCREEN_ON";
    public static final String ACTION_SEARCH = "android.intent.action.SEARCH";
    public static final String ACTION_SEARCH_LONG_PRESS = "android.intent.action.SEARCH_LONG_PRESS";
    public static final String ACTION_SEND = "android.intent.action.SEND";
    public static final String ACTION_SENDTO = "android.intent.action.SENDTO";
    public static final String ACTION_SEND_MULTIPLE = "android.intent.action.SEND_MULTIPLE";
    public static final String ACTION_SET_WALLPAPER = "android.intent.action.SET_WALLPAPER";
    public static final String ACTION_SHUTDOWN = "android.intent.action.ACTION_SHUTDOWN";
    public static final String ACTION_SYNC = "android.intent.action.SYNC";
    public static final String ACTION_SYNC_STATE_CHANGED = "android.intent.action.SYNC_STATE_CHANGED";
    public static final String ACTION_SYSTEM_TUTORIAL = "android.intent.action.SYSTEM_TUTORIAL";
    public static final String ACTION_TIMEZONE_CHANGED = "android.intent.action.TIMEZONE_CHANGED";
    public static final String ACTION_TIME_CHANGED = "android.intent.action.TIME_SET";
    public static final String ACTION_TIME_TICK = "android.intent.action.TIME_TICK";
    public static final String ACTION_UID_REMOVED = "android.intent.action.UID_REMOVED";
    public static final String ACTION_UMS_CONNECTED = "android.intent.action.UMS_CONNECTED";
    public static final String ACTION_UMS_DISCONNECTED = "android.intent.action.UMS_DISCONNECTED";
    public static final String ACTION_UNINSTALL_PACKAGE = "android.intent.action.UNINSTALL_PACKAGE";
    public static final String ACTION_UPGRADE_SETUP = "android.intent.action.UPGRADE_SETUP";
    public static final String ACTION_USB_AUDIO_ACCESSORY_PLUG = "android.intent.action.USB_AUDIO_ACCESSORY_PLUG";
    public static final String ACTION_USB_AUDIO_DEVICE_PLUG = "android.intent.action.USB_AUDIO_DEVICE_PLUG";
    public static final String ACTION_USER_ADDED = "android.intent.action.USER_ADDED";
    public static final String ACTION_USER_PRESENT = "android.intent.action.USER_PRESENT";
    public static final String ACTION_USER_REMOVED = "android.intent.action.USER_REMOVED";
    public static final String ACTION_USER_SWITCHED = "android.intent.action.USER_SWITCHED";
    public static final String ACTION_VIEW = "android.intent.action.VIEW";
    public static final String ACTION_VOICE_COMMAND = "android.intent.action.VOICE_COMMAND";
    public static final String ACTION_WALLPAPER_CHANGED = "android.intent.action.WALLPAPER_CHANGED";
    public static final String ACTION_WEB_SEARCH = "android.intent.action.WEB_SEARCH";
    public static final String CATEGORY_ALTERNATIVE = "android.intent.category.ALTERNATIVE";
    public static final String CATEGORY_APP_BROWSER = "android.intent.category.APP_BROWSER";
    public static final String CATEGORY_APP_CALCULATOR = "android.intent.category.APP_CALCULATOR";
    public static final String CATEGORY_APP_CALENDAR = "android.intent.category.APP_CALENDAR";
    public static final String CATEGORY_APP_CONTACTS = "android.intent.category.APP_CONTACTS";
    public static final String CATEGORY_APP_EMAIL = "android.intent.category.APP_EMAIL";
    public static final String CATEGORY_APP_GALLERY = "android.intent.category.APP_GALLERY";
    public static final String CATEGORY_APP_MAPS = "android.intent.category.APP_MAPS";
    public static final String CATEGORY_APP_MARKET = "android.intent.category.APP_MARKET";
    public static final String CATEGORY_APP_MESSAGING = "android.intent.category.APP_MESSAGING";
    public static final String CATEGORY_APP_MUSIC = "android.intent.category.APP_MUSIC";
    public static final String CATEGORY_BROWSABLE = "android.intent.category.BROWSABLE";
    public static final String CATEGORY_CAR_DOCK = "android.intent.category.CAR_DOCK";
    public static final String CATEGORY_CAR_MODE = "android.intent.category.CAR_MODE";
    public static final String CATEGORY_DEFAULT = "android.intent.category.DEFAULT";
    public static final String CATEGORY_DESK_DOCK = "android.intent.category.DESK_DOCK";
    public static final String CATEGORY_DEVELOPMENT_PREFERENCE = "android.intent.category.DEVELOPMENT_PREFERENCE";
    public static final String CATEGORY_EMBED = "android.intent.category.EMBED";
    public static final String CATEGORY_FRAMEWORK_INSTRUMENTATION_TEST = "android.intent.category.FRAMEWORK_INSTRUMENTATION_TEST";
    public static final String CATEGORY_HE_DESK_DOCK = "android.intent.category.HE_DESK_DOCK";
    public static final String CATEGORY_HOME = "android.intent.category.HOME";
    public static final String CATEGORY_INFO = "android.intent.category.INFO";
    public static final String CATEGORY_LAUNCHER = "android.intent.category.LAUNCHER";
    public static final String CATEGORY_LE_DESK_DOCK = "android.intent.category.LE_DESK_DOCK";
    public static final String CATEGORY_MONKEY = "android.intent.category.MONKEY";
    public static final String CATEGORY_OPENABLE = "android.intent.category.OPENABLE";
    public static final String CATEGORY_PREFERENCE = "android.intent.category.PREFERENCE";
    public static final String CATEGORY_SAMPLE_CODE = "android.intent.category.SAMPLE_CODE";
    public static final String CATEGORY_SELECTED_ALTERNATIVE = "android.intent.category.SELECTED_ALTERNATIVE";
    public static final String CATEGORY_TAB = "android.intent.category.TAB";
    public static final String CATEGORY_TEST = "android.intent.category.TEST";
    public static final String CATEGORY_UNIT_TEST = "android.intent.category.UNIT_TEST";
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Intent createFromParcel(Parcel parcel) {
            return new Intent(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public Intent[] newArray(int i) {
            return new Intent[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final String EXTRA_ALARM_COUNT = "android.intent.extra.ALARM_COUNT";
    public static final String EXTRA_ALLOW_REPLACE = "android.intent.extra.ALLOW_REPLACE";
    public static final String EXTRA_BCC = "android.intent.extra.BCC";
    public static final String EXTRA_BUG_REPORT = "android.intent.extra.BUG_REPORT";
    public static final String EXTRA_CC = "android.intent.extra.CC";
    public static final String EXTRA_CHANGED_COMPONENT_NAME = "android.intent.extra.changed_component_name";
    public static final String EXTRA_CHANGED_COMPONENT_NAME_LIST = "android.intent.extra.changed_component_name_list";
    public static final String EXTRA_CHANGED_PACKAGE_LIST = "android.intent.extra.changed_package_list";
    public static final String EXTRA_CHANGED_UID_LIST = "android.intent.extra.changed_uid_list";
    public static final String EXTRA_CLIENT_INTENT = "android.intent.extra.client_intent";
    public static final String EXTRA_CLIENT_LABEL = "android.intent.extra.client_label";
    public static final String EXTRA_DATA_REMOVED = "android.intent.extra.DATA_REMOVED";
    public static final String EXTRA_DOCK_STATE = "android.intent.extra.DOCK_STATE";
    public static final int EXTRA_DOCK_STATE_CAR = 2;
    public static final int EXTRA_DOCK_STATE_DESK = 1;
    public static final int EXTRA_DOCK_STATE_HE_DESK = 4;
    public static final int EXTRA_DOCK_STATE_LE_DESK = 3;
    public static final int EXTRA_DOCK_STATE_UNDOCKED = 0;
    public static final String EXTRA_DONT_KILL_APP = "android.intent.extra.DONT_KILL_APP";
    public static final String EXTRA_EMAIL = "android.intent.extra.EMAIL";
    public static final String EXTRA_HTML_TEXT = "android.intent.extra.HTML_TEXT";
    public static final String EXTRA_INITIAL_INTENTS = "android.intent.extra.INITIAL_INTENTS";
    public static final String EXTRA_INSTALLER_PACKAGE_NAME = "android.intent.extra.INSTALLER_PACKAGE_NAME";
    public static final String EXTRA_INSTALL_RESULT = "android.intent.extra.INSTALL_RESULT";
    public static final String EXTRA_INTENT = "android.intent.extra.INTENT";
    public static final String EXTRA_KEY_CONFIRM = "android.intent.extra.KEY_CONFIRM";
    public static final String EXTRA_KEY_EVENT = "android.intent.extra.KEY_EVENT";
    public static final String EXTRA_LOCAL_ONLY = "android.intent.extra.LOCAL_ONLY";
    public static final String EXTRA_NOT_UNKNOWN_SOURCE = "android.intent.extra.NOT_UNKNOWN_SOURCE";
    public static final String EXTRA_PACKAGES = "android.intent.extra.PACKAGES";
    public static final String EXTRA_PHONE_NUMBER = "android.intent.extra.PHONE_NUMBER";
    public static final String EXTRA_REMOTE_INTENT_TOKEN = "android.intent.extra.remote_intent_token";
    public static final String EXTRA_REPLACING = "android.intent.extra.REPLACING";
    public static final String EXTRA_RETURN_RESULT = "android.intent.extra.RETURN_RESULT";
    public static final String EXTRA_SHORTCUT_ICON = "android.intent.extra.shortcut.ICON";
    public static final String EXTRA_SHORTCUT_ICON_RESOURCE = "android.intent.extra.shortcut.ICON_RESOURCE";
    public static final String EXTRA_SHORTCUT_INTENT = "android.intent.extra.shortcut.INTENT";
    public static final String EXTRA_SHORTCUT_NAME = "android.intent.extra.shortcut.NAME";
    public static final String EXTRA_STREAM = "android.intent.extra.STREAM";
    public static final String EXTRA_SUBJECT = "android.intent.extra.SUBJECT";
    public static final String EXTRA_TEMPLATE = "android.intent.extra.TEMPLATE";
    public static final String EXTRA_TEXT = "android.intent.extra.TEXT";
    public static final String EXTRA_TITLE = "android.intent.extra.TITLE";
    public static final String EXTRA_UID = "android.intent.extra.UID";
    public static final String EXTRA_USERID = "android.intent.extra.user_id";
    public static final int FILL_IN_ACTION = 1;
    public static final int FILL_IN_CATEGORIES = 4;
    public static final int FILL_IN_CLIP_DATA = 128;
    public static final int FILL_IN_COMPONENT = 8;
    public static final int FILL_IN_DATA = 2;
    public static final int FILL_IN_PACKAGE = 16;
    public static final int FILL_IN_SELECTOR = 64;
    public static final int FILL_IN_SOURCE_BOUNDS = 32;
    public static final int FLAG_ACTIVITY_BROUGHT_TO_FRONT = 0x400000;
    public static final int FLAG_ACTIVITY_CLEAR_TASK = 32768;
    public static final int FLAG_ACTIVITY_CLEAR_TOP = 0x4000000;
    public static final int FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET = 0x80000;
    public static final int FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS = 0x800000;
    public static final int FLAG_ACTIVITY_FORWARD_RESULT = 0x2000000;
    public static final int FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY = 0x100000;
    public static final int FLAG_ACTIVITY_MULTIPLE_TASK = 0x8000000;
    public static final int FLAG_ACTIVITY_NEW_TASK = 0x10000000;
    public static final int FLAG_ACTIVITY_NO_ANIMATION = 0x10000;
    public static final int FLAG_ACTIVITY_NO_HISTORY = 0x40000000;
    public static final int FLAG_ACTIVITY_NO_USER_ACTION = 0x40000;
    public static final int FLAG_ACTIVITY_PREVIOUS_IS_TOP = 0x1000000;
    public static final int FLAG_ACTIVITY_REORDER_TO_FRONT = 0x20000;
    public static final int FLAG_ACTIVITY_RESET_TASK_IF_NEEDED = 0x200000;
    public static final int FLAG_ACTIVITY_SINGLE_TOP = 0x20000000;
    public static final int FLAG_ACTIVITY_TASK_ON_HOME = 16384;
    public static final int FLAG_DEBUG_LOG_RESOLUTION = 8;
    public static final int FLAG_EXCLUDE_STOPPED_PACKAGES = 16;
    public static final int FLAG_FROM_BACKGROUND = 4;
    public static final int FLAG_GRANT_READ_URI_PERMISSION = 1;
    public static final int FLAG_GRANT_WRITE_URI_PERMISSION = 2;
    public static final int FLAG_INCLUDE_STOPPED_PACKAGES = 32;
    public static final int FLAG_RECEIVER_BOOT_UPGRADE = 0x4000000;
    public static final int FLAG_RECEIVER_FOREGROUND = 0x10000000;
    public static final int FLAG_RECEIVER_REGISTERED_ONLY = 0x40000000;
    public static final int FLAG_RECEIVER_REGISTERED_ONLY_BEFORE_BOOT = 0x8000000;
    public static final int FLAG_RECEIVER_REPLACE_PENDING = 0x20000000;
    public static final int IMMUTABLE_FLAGS = 3;
    public static final String METADATA_DOCK_HOME = "android.dock_home";
    public static final String METADATA_SETUP_VERSION = "android.SETUP_VERSION";
    public static final int URI_INTENT_SCHEME = 1;
    private String mAction;
    private HashSet mCategories;
    private ClipData mClipData;
    private ComponentName mComponent;
    private Uri mData;
    private Bundle mExtras;
    private int mFlags;
    private String mPackage;
    private Intent mSelector;
    private Rect mSourceBounds;
    private String mType;

}
