// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view.inputmethod;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Slog;
import java.util.*;

// Referenced classes of package android.view.inputmethod:
//            InputMethodInfo

public final class InputMethodSubtype
    implements Parcelable {

    public InputMethodSubtype(int i, int j, String s, String s1, String s2, boolean flag) {
        this(i, j, s, s1, s2, flag, false);
    }

    public InputMethodSubtype(int i, int j, String s, String s1, String s2, boolean flag, boolean flag1) {
        mSubtypeNameResId = i;
        mSubtypeIconResId = j;
        if(s == null)
            s = "";
        mSubtypeLocale = s;
        if(s1 == null)
            s1 = "";
        mSubtypeMode = s1;
        if(s2 == null)
            s2 = "";
        mSubtypeExtraValue = s2;
        mIsAuxiliary = flag;
        mOverridesImplicitlyEnabledSubtype = flag1;
        mSubtypeHashCode = hashCodeInternal(mSubtypeLocale, mSubtypeMode, mSubtypeExtraValue, mIsAuxiliary, mOverridesImplicitlyEnabledSubtype);
    }

    InputMethodSubtype(Parcel parcel) {
        boolean flag = true;
        super();
        mSubtypeNameResId = parcel.readInt();
        mSubtypeIconResId = parcel.readInt();
        String s = parcel.readString();
        String s1;
        String s2;
        boolean flag1;
        if(s == null)
            s = "";
        mSubtypeLocale = s;
        s1 = parcel.readString();
        if(s1 == null)
            s1 = "";
        mSubtypeMode = s1;
        s2 = parcel.readString();
        if(s2 == null)
            s2 = "";
        mSubtypeExtraValue = s2;
        if(parcel.readInt() == flag)
            flag1 = flag;
        else
            flag1 = false;
        mIsAuxiliary = flag1;
        if(parcel.readInt() != flag)
            flag = false;
        mOverridesImplicitlyEnabledSubtype = flag;
        mSubtypeHashCode = hashCodeInternal(mSubtypeLocale, mSubtypeMode, mSubtypeExtraValue, mIsAuxiliary, mOverridesImplicitlyEnabledSubtype);
    }

    private static Locale constructLocaleFromString(String s) {
        Locale locale = null;
        if(!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        return locale;
_L2:
        String as[] = s.split("_", 3);
        if(as.length == 1)
            locale = new Locale(as[0]);
        else
        if(as.length == 2)
            locale = new Locale(as[0], as[1]);
        else
        if(as.length == 3)
            locale = new Locale(as[0], as[1], as[2]);
        if(true) goto _L1; else goto _L3
_L3:
    }

    private HashMap getExtraValueHashMap() {
        if(mExtraValueHashMapCache != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if(mExtraValueHashMapCache != null) goto _L4; else goto _L3
_L3:
        String as[];
        int i;
        int j;
        mExtraValueHashMapCache = new HashMap();
        as = mSubtypeExtraValue.split(",");
        i = as.length;
        j = 0;
_L6:
        if(j < i) {
            String as1[] = as[j].split("=");
            Exception exception;
            if(as1.length == 1)
                mExtraValueHashMapCache.put(as1[0], null);
            else
            if(as1.length > 1) {
                if(as1.length > 2)
                    Slog.w(TAG, "ExtraValue has two or more '='s");
                mExtraValueHashMapCache.put(as1[0], as1[1]);
            }
            j++;
            continue; /* Loop/switch isn't completed */
        }
          goto _L4
        exception;
        throw exception;
_L4:
        this;
        JVM INSTR monitorexit ;
_L2:
        return mExtraValueHashMapCache;
        if(true) goto _L6; else goto _L5
_L5:
    }

    private static int hashCodeInternal(String s, String s1, String s2, boolean flag, boolean flag1) {
        Object aobj[] = new Object[5];
        aobj[0] = s;
        aobj[1] = s1;
        aobj[2] = s2;
        aobj[3] = Boolean.valueOf(flag);
        aobj[4] = Boolean.valueOf(flag1);
        return Arrays.hashCode(aobj);
    }

    public static List sort(Context context, int i, InputMethodInfo inputmethodinfo, List list) {
        if(inputmethodinfo != null) {
            HashSet hashset = new HashSet(list);
            ArrayList arraylist = new ArrayList();
            int j = inputmethodinfo.getSubtypeCount();
            for(int k = 0; k < j; k++) {
                InputMethodSubtype inputmethodsubtype = inputmethodinfo.getSubtypeAt(k);
                if(hashset.contains(inputmethodsubtype)) {
                    arraylist.add(inputmethodsubtype);
                    hashset.remove(inputmethodsubtype);
                }
            }

            for(Iterator iterator = hashset.iterator(); iterator.hasNext(); arraylist.add((InputMethodSubtype)iterator.next()));
            list = arraylist;
        }
        return list;
    }

    public boolean containsExtraValueKey(String s) {
        return getExtraValueHashMap().containsKey(s);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean flag = false;
        if(obj instanceof InputMethodSubtype) {
            InputMethodSubtype inputmethodsubtype = (InputMethodSubtype)obj;
            if(inputmethodsubtype.hashCode() == hashCode() && inputmethodsubtype.getNameResId() == getNameResId() && inputmethodsubtype.getMode().equals(getMode()) && inputmethodsubtype.getIconResId() == getIconResId() && inputmethodsubtype.getLocale().equals(getLocale()) && inputmethodsubtype.getExtraValue().equals(getExtraValue()) && inputmethodsubtype.isAuxiliary() == isAuxiliary())
                flag = true;
        }
        return flag;
    }

    public CharSequence getDisplayName(Context context, String s, ApplicationInfo applicationinfo) {
        String s1;
        Locale locale = constructLocaleFromString(mSubtypeLocale);
        if(locale != null)
            s1 = locale.getDisplayName();
        else
            s1 = mSubtypeLocale;
        if(mSubtypeNameResId != 0) goto _L2; else goto _L1
_L1:
        return s1;
_L2:
        CharSequence charsequence = context.getPackageManager().getText(s, mSubtypeNameResId, applicationinfo);
        if(!TextUtils.isEmpty(charsequence)) {
            String s2;
            if(containsExtraValueKey("UntranslatableReplacementStringInSubtypeName"))
                s2 = getExtraValueOf("UntranslatableReplacementStringInSubtypeName");
            else
                s2 = s1;
            try {
                String s3 = charsequence.toString();
                Object aobj[] = new Object[1];
                if(s2 == null)
                    s2 = "";
                aobj[0] = s2;
                s1 = String.format(s3, aobj);
            }
            catch(IllegalFormatException illegalformatexception) {
                Slog.w(TAG, (new StringBuilder()).append("Found illegal format in subtype name(").append(charsequence).append("): ").append(illegalformatexception).toString());
                s1 = "";
            }
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public String getExtraValue() {
        return mSubtypeExtraValue;
    }

    public String getExtraValueOf(String s) {
        return (String)getExtraValueHashMap().get(s);
    }

    public int getIconResId() {
        return mSubtypeIconResId;
    }

    public String getLocale() {
        return mSubtypeLocale;
    }

    public String getMode() {
        return mSubtypeMode;
    }

    public int getNameResId() {
        return mSubtypeNameResId;
    }

    public int hashCode() {
        return mSubtypeHashCode;
    }

    public boolean isAuxiliary() {
        return mIsAuxiliary;
    }

    public boolean overridesImplicitlyEnabledSubtype() {
        return mOverridesImplicitlyEnabledSubtype;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int j = 1;
        parcel.writeInt(mSubtypeNameResId);
        parcel.writeInt(mSubtypeIconResId);
        parcel.writeString(mSubtypeLocale);
        parcel.writeString(mSubtypeMode);
        parcel.writeString(mSubtypeExtraValue);
        int k;
        if(mIsAuxiliary)
            k = j;
        else
            k = 0;
        parcel.writeInt(k);
        if(!mOverridesImplicitlyEnabledSubtype)
            j = 0;
        parcel.writeInt(j);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public InputMethodSubtype createFromParcel(Parcel parcel) {
            return new InputMethodSubtype(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public InputMethodSubtype[] newArray(int i) {
            return new InputMethodSubtype[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private static final String EXTRA_KEY_UNTRANSLATABLE_STRING_IN_SUBTYPE_NAME = "UntranslatableReplacementStringInSubtypeName";
    private static final String EXTRA_VALUE_KEY_VALUE_SEPARATOR = "=";
    private static final String EXTRA_VALUE_PAIR_SEPARATOR = ",";
    private static final String TAG = android/view/inputmethod/InputMethodSubtype.getSimpleName();
    private volatile HashMap mExtraValueHashMapCache;
    private final boolean mIsAuxiliary;
    private final boolean mOverridesImplicitlyEnabledSubtype;
    private final String mSubtypeExtraValue;
    private final int mSubtypeHashCode;
    private final int mSubtypeIconResId;
    private final String mSubtypeLocale;
    private final String mSubtypeMode;
    private final int mSubtypeNameResId;

}
