// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.res;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.*;
import java.io.InputStream;
import miui.content.res.*;

// Referenced classes of package android.content.res:
//            Resources, AssetManager, TypedArray, Configuration, 
//            CompatibilityInfo

public final class MiuiResources extends Resources {
    public final class MIUITheme extends Resources.Theme {

        public TypedArray obtainStyledAttributes(int i, int ai[]) throws Resources.NotFoundException {
            return replaceTypedArray(obtainStyledAttributes(i, ai));
        }

        public TypedArray obtainStyledAttributes(AttributeSet attributeset, int ai[], int i, int j) {
            return replaceTypedArray(obtainStyledAttributes(attributeset, ai, i, j));
        }

        public TypedArray obtainStyledAttributes(int ai[]) {
            return replaceTypedArray(obtainStyledAttributes(ai));
        }

        final MiuiResources this$0;

        public MIUITheme() {
            this$0 = MiuiResources.this;
            super(MiuiResources.this);
        }
    }


    MiuiResources() {
        mIntegers = new SparseArray();
        mCharSequences = new SparseArray();
        mSkipFiles = new SparseArray();
        mCookieType = new SparseIntArray();
        init(null);
    }

    public MiuiResources(AssetManager assetmanager, DisplayMetrics displaymetrics, Configuration configuration) {
        super(assetmanager, displaymetrics, configuration);
        mIntegers = new SparseArray();
        mCharSequences = new SparseArray();
        mSkipFiles = new SparseArray();
        mCookieType = new SparseIntArray();
        init(null);
    }

    public MiuiResources(AssetManager assetmanager, DisplayMetrics displaymetrics, Configuration configuration, CompatibilityInfo compatibilityinfo) {
        super(assetmanager, displaymetrics, configuration, compatibilityinfo);
        mIntegers = new SparseArray();
        mCharSequences = new SparseArray();
        mSkipFiles = new SparseArray();
        mCookieType = new SparseIntArray();
        init(null);
    }

    private int getCookieType(int i) {
        int j = mCookieType.get(i);
        if(j == 0) {
            String s = super.mAssets.getCookieName(i);
            if("/system/framework/framework-res.apk".equals(s))
                j = 1;
            else
            if("/system/framework/framework-miui-res.apk".equals(s))
                j = 2;
            else
                j = 3;
            mCookieType.put(i, j);
        }
        return j;
    }

    private TypedArray replaceTypedArray(TypedArray typedarray) {
        if(mThemeResources == null || mHasValues) {
            int ai[] = typedarray.mData;
            int i = 0;
            while(i < ai.length)  {
                int j = ai[i + 0];
                int k = ai[i + 3];
                if(j >= 16 && j <= 31 || j == 5) {
                    Integer integer = getThemeInt(k);
                    if(integer != null)
                        ai[i + 1] = integer.intValue();
                }
                i += 6;
            }
        }
        return typedarray;
    }

    public CharSequence getText(int i) throws Resources.NotFoundException {
        CharSequence charsequence = getThemeCharSequence(i);
        if(charsequence == null)
            charsequence = super.getText(i);
        return charsequence;
    }

    public CharSequence getText(int i, CharSequence charsequence) {
        CharSequence charsequence1 = getThemeCharSequence(i);
        if(charsequence1 == null)
            charsequence1 = super.getText(i, charsequence);
        return charsequence1;
    }

    CharSequence getThemeCharSequence(int i) {
        CharSequence charsequence;
        if(!mHasValues) {
            charsequence = null;
        } else {
            int j = mCharSequences.indexOfKey(i);
            if(j >= 0) {
                charsequence = (CharSequence)mCharSequences.valueAt(j);
            } else {
                charsequence = mThemeResources.getThemeCharSequence(i);
                mCharSequences.put(i, charsequence);
            }
        }
        return charsequence;
    }

    Integer getThemeInt(int i) {
        Integer integer;
        if(!mHasValues) {
            integer = null;
        } else {
            int j = mIntegers.indexOfKey(i);
            if(j >= 0) {
                integer = (Integer)mIntegers.valueAt(j);
            } else {
                integer = mThemeResources.getThemeInt(i);
                mIntegers.put(i, integer);
            }
        }
        return integer;
    }

    public void getValue(int i, TypedValue typedvalue, boolean flag) throws Resources.NotFoundException {
        super.getValue(i, typedvalue, flag);
        if(typedvalue.type >= 16 && typedvalue.type <= 31 || typedvalue.type == 5) {
            Integer integer = getThemeInt(i);
            if(integer != null)
                typedvalue.data = integer.intValue();
        }
    }

    public void init(String s) {
        if(TextUtils.isEmpty(s) || "android".equals(s) || "miui".equals(s))
            mThemeResources = ThemeResources.getSystem(this);
        else
            mThemeResources = ThemeResourcesPackage.getThemeResources(this, s);
        mHasValues = mThemeResources.hasValues();
    }

    Drawable loadOverlayDrawable(TypedValue typedvalue, int i) {
        if(mSkipFiles.get(i) == null) goto _L2; else goto _L1
_L1:
        Drawable drawable = null;
_L5:
        return drawable;
_L2:
        String s;
        miui.content.res.ThemeZipFile.ThemeFileInfo themefileinfo;
        drawable = null;
        s = typedvalue.string.toString();
        themefileinfo = mThemeResources.getThemeFileStream(getCookieType(typedvalue.assetCookie), s);
        if(themefileinfo == null) goto _L4; else goto _L3
_L3:
        android.graphics.BitmapFactory.Options options = null;
        android.graphics.BitmapFactory.Options options1;
        if(themefileinfo.mDensity <= 0)
            break MISSING_BLOCK_LABEL_84;
        options1 = new android.graphics.BitmapFactory.Options();
        options1.inDensity = themefileinfo.mDensity;
        options = options1;
        Drawable drawable1 = Drawable.createFromResourceStream(this, typedvalue, themefileinfo.mInput, s, options);
        drawable = drawable1;
_L6:
        try {
            themefileinfo.mInput.close();
        }
        catch(Exception exception) { }
          goto _L5
_L4:
        mSkipFiles.put(i, Boolean.valueOf(true));
          goto _L5
        OutOfMemoryError outofmemoryerror;
        outofmemoryerror;
          goto _L6
        OutOfMemoryError outofmemoryerror1;
        outofmemoryerror1;
          goto _L6
    }

    public final Resources.Theme newTheme() {
        return new MIUITheme();
    }

    public TypedArray obtainAttributes(AttributeSet attributeset, int ai[]) {
        return replaceTypedArray(super.obtainAttributes(attributeset, ai));
    }

    public TypedArray obtainTypedArray(int i) throws Resources.NotFoundException {
        return replaceTypedArray(super.obtainTypedArray(i));
    }

    public InputStream openRawResource(int i, TypedValue typedvalue) throws Resources.NotFoundException {
        if(mSkipFiles.get(i) != null) goto _L2; else goto _L1
_L1:
        miui.content.res.ThemeZipFile.ThemeFileInfo themefileinfo;
        getValue(i, typedvalue, true);
        String s = typedvalue.string.toString();
        themefileinfo = mThemeResources.getThemeFileStream(getCookieType(typedvalue.assetCookie), s);
        if(themefileinfo == null) goto _L4; else goto _L3
_L3:
        InputStream inputstream = themefileinfo.mInput;
_L6:
        return inputstream;
_L4:
        mSkipFiles.put(i, Boolean.valueOf(true));
_L2:
        inputstream = super.openRawResource(i, typedvalue);
        if(true) goto _L6; else goto _L5
_L5:
    }

    public void updateConfiguration(Configuration configuration, DisplayMetrics displaymetrics, CompatibilityInfo compatibilityinfo) {
        Configuration configuration1 = getConfiguration();
        int i;
        if(configuration1 != null && configuration != null)
            i = configuration1.diff(configuration);
        else
            i = 0;
        super.updateConfiguration(configuration, displaymetrics, compatibilityinfo);
        if(mThemeResources != null && ExtraConfiguration.needNewResources(i)) {
            if(ThemeResources.getSystem().checkUpdate())
                Resources.clearPreloadedCache();
            mIntegers.clear();
            mCharSequences.clear();
            mSkipFiles.clear();
            mThemeResources.checkUpdate();
            mHasValues = mThemeResources.hasValues();
        }
    }

    public static final int sCookieTypeFramework = 1;
    public static final int sCookieTypeMiui = 2;
    public static final int sCookieTypeOther = 3;
    private SparseArray mCharSequences;
    private SparseIntArray mCookieType;
    private boolean mHasValues;
    private SparseArray mIntegers;
    private SparseArray mSkipFiles;
    private ThemeResources mThemeResources;

}
