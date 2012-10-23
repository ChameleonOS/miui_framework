// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view.textservice;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Slog;
import java.util.*;

// Referenced classes of package android.view.textservice:
//            SpellCheckerInfo

public final class SpellCheckerSubtype
    implements Parcelable {

    public SpellCheckerSubtype(int i, String s, String s1) {
        mSubtypeNameResId = i;
        if(s == null)
            s = "";
        mSubtypeLocale = s;
        if(s1 == null)
            s1 = "";
        mSubtypeExtraValue = s1;
        mSubtypeHashCode = hashCodeInternal(mSubtypeLocale, mSubtypeExtraValue);
    }

    SpellCheckerSubtype(Parcel parcel) {
        mSubtypeNameResId = parcel.readInt();
        String s = parcel.readString();
        String s1;
        if(s == null)
            s = "";
        mSubtypeLocale = s;
        s1 = parcel.readString();
        if(s1 == null)
            s1 = "";
        mSubtypeExtraValue = s1;
        mSubtypeHashCode = hashCodeInternal(mSubtypeLocale, mSubtypeExtraValue);
    }

    public static Locale constructLocaleFromString(String s) {
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
        if(mExtraValueHashMapCache == null) {
            mExtraValueHashMapCache = new HashMap();
            String as[] = mSubtypeExtraValue.split(",");
            int i = as.length;
            int j = 0;
            while(j < i)  {
                String as1[] = as[j].split("=");
                if(as1.length == 1)
                    mExtraValueHashMapCache.put(as1[0], null);
                else
                if(as1.length > 1) {
                    if(as1.length > 2)
                        Slog.w(TAG, "ExtraValue has two or more '='s");
                    mExtraValueHashMapCache.put(as1[0], as1[1]);
                }
                j++;
            }
        }
        return mExtraValueHashMapCache;
    }

    private static int hashCodeInternal(String s, String s1) {
        Object aobj[] = new Object[2];
        aobj[0] = s;
        aobj[1] = s1;
        return Arrays.hashCode(aobj);
    }

    public static List sort(Context context, int i, SpellCheckerInfo spellcheckerinfo, List list) {
        if(spellcheckerinfo != null) {
            HashSet hashset = new HashSet(list);
            ArrayList arraylist = new ArrayList();
            int j = spellcheckerinfo.getSubtypeCount();
            for(int k = 0; k < j; k++) {
                SpellCheckerSubtype spellcheckersubtype = spellcheckerinfo.getSubtypeAt(k);
                if(hashset.contains(spellcheckersubtype)) {
                    arraylist.add(spellcheckersubtype);
                    hashset.remove(spellcheckersubtype);
                }
            }

            for(Iterator iterator = hashset.iterator(); iterator.hasNext(); arraylist.add((SpellCheckerSubtype)iterator.next()));
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
        if(obj instanceof SpellCheckerSubtype) {
            SpellCheckerSubtype spellcheckersubtype = (SpellCheckerSubtype)obj;
            if(spellcheckersubtype.hashCode() == hashCode() && spellcheckersubtype.getNameResId() == getNameResId() && spellcheckersubtype.getLocale().equals(getLocale()) && spellcheckersubtype.getExtraValue().equals(getExtraValue()))
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
            String s2 = charsequence.toString();
            Object aobj[] = new Object[1];
            aobj[0] = s1;
            s1 = String.format(s2, aobj);
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

    public String getLocale() {
        return mSubtypeLocale;
    }

    public int getNameResId() {
        return mSubtypeNameResId;
    }

    public int hashCode() {
        return mSubtypeHashCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mSubtypeNameResId);
        parcel.writeString(mSubtypeLocale);
        parcel.writeString(mSubtypeExtraValue);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public SpellCheckerSubtype createFromParcel(Parcel parcel) {
            return new SpellCheckerSubtype(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public SpellCheckerSubtype[] newArray(int i) {
            return new SpellCheckerSubtype[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private static final String EXTRA_VALUE_KEY_VALUE_SEPARATOR = "=";
    private static final String EXTRA_VALUE_PAIR_SEPARATOR = ",";
    private static final String TAG = android/view/textservice/SpellCheckerSubtype.getSimpleName();
    private HashMap mExtraValueHashMapCache;
    private final String mSubtypeExtraValue;
    private final int mSubtypeHashCode;
    private final String mSubtypeLocale;
    private final int mSubtypeNameResId;

}
