// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.res;

import android.content.pm.ActivityInfo;
import android.graphics.Movie;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.*;
import com.android.internal.util.XmlUtils;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Locale;
import libcore.icu.NativePluralRules;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package android.content.res:
//            Configuration, XmlBlock, AssetManager, CompatibilityInfo, 
//            ColorStateList, TypedArray, MiuiTypedArray, MiuiResources, 
//            XmlResourceParser, AssetFileDescriptor

public class Resources {
    public class Theme {

        public void applyStyle(int i, boolean flag) {
            AssetManager.applyThemeStyle(mTheme, i, flag);
        }

        public void dump(int i, String s, String s1) {
            AssetManager.dumpTheme(mTheme, i, s, s1);
        }

        protected void finalize() throws Throwable {
            super.finalize();
            mAssets.releaseTheme(mTheme);
        }

        public TypedArray obtainStyledAttributes(int i, int ai[]) throws NotFoundException {
            int j = ai.length;
            TypedArray typedarray = getCachedStyledAttributes(j);
            typedarray.mRsrcs = ai;
            AssetManager.applyStyle(mTheme, 0, i, 0, ai, typedarray.mData, typedarray.mIndices);
            return typedarray;
        }

        public TypedArray obtainStyledAttributes(AttributeSet attributeset, int ai[], int i, int j) {
            int k = ai.length;
            TypedArray typedarray = getCachedStyledAttributes(k);
            XmlBlock.Parser parser = (XmlBlock.Parser)attributeset;
            int l = mTheme;
            int i1;
            if(parser != null)
                i1 = parser.mParseState;
            else
                i1 = 0;
            AssetManager.applyStyle(l, i, j, i1, ai, typedarray.mData, typedarray.mIndices);
            typedarray.mRsrcs = ai;
            typedarray.mXml = parser;
            return typedarray;
        }

        public TypedArray obtainStyledAttributes(int ai[]) {
            int i = ai.length;
            TypedArray typedarray = getCachedStyledAttributes(i);
            typedarray.mRsrcs = ai;
            AssetManager.applyStyle(mTheme, 0, 0, 0, ai, typedarray.mData, typedarray.mIndices);
            return typedarray;
        }

        public boolean resolveAttribute(int i, TypedValue typedvalue, boolean flag) {
            return mAssets.getThemeValue(mTheme, i, typedvalue, flag);
        }

        public void setTo(Theme theme) {
            AssetManager.copyTheme(mTheme, theme.mTheme);
        }

        private final AssetManager mAssets;
        private final int mTheme;
        final Resources this$0;

        Theme() {
            this$0 = Resources.this;
            super();
            mAssets = Resources.this.mAssets;
            mTheme = mAssets.createTheme();
        }
    }

    public static class NotFoundException extends RuntimeException {

        public NotFoundException() {
        }

        public NotFoundException(String s) {
            super(s);
        }
    }

    static class Injector {

        static Drawable createFromResourceStream(Resources resources, TypedValue typedvalue, InputStream inputstream, String s, android.graphics.BitmapFactory.Options options) {
            Drawable drawable = resources.loadOverlayDrawable(typedvalue, mId);
            if(drawable == null)
                drawable = Drawable.createFromResourceStream(resources, typedvalue, inputstream, s, options);
            return drawable;
        }

        static void setDrawableId(int i) {
            mId = i;
        }

        private static int mId;

        Injector() {
        }
    }


    Resources() {
        mTmpValue = new TypedValue();
        mTmpConfig = new Configuration();
        mDrawableCache = new LongSparseArray();
        mColorStateListCache = new LongSparseArray();
        mColorDrawableCache = new LongSparseArray();
        mCachedStyledAttributes = null;
        mLastRetrievedAttrs = null;
        mLastCachedXmlBlockIndex = -1;
        int ai[] = new int[4];
        ai[0] = 0;
        ai[1] = 0;
        ai[2] = 0;
        ai[3] = 0;
        mCachedXmlBlockIds = ai;
        mCachedXmlBlocks = new XmlBlock[4];
        mConfiguration = new Configuration();
        mMetrics = new DisplayMetrics();
        mAssets = AssetManager.getSystem();
        mConfiguration.setToDefaults();
        mMetrics.setToDefaults();
        updateConfiguration(null, null);
        mAssets.ensureStringBlocks();
        mCompatibilityInfo = CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO;
    }

    public Resources(AssetManager assetmanager, DisplayMetrics displaymetrics, Configuration configuration) {
        this(assetmanager, displaymetrics, configuration, null);
    }

    public Resources(AssetManager assetmanager, DisplayMetrics displaymetrics, Configuration configuration, CompatibilityInfo compatibilityinfo) {
        mTmpValue = new TypedValue();
        mTmpConfig = new Configuration();
        mDrawableCache = new LongSparseArray();
        mColorStateListCache = new LongSparseArray();
        mColorDrawableCache = new LongSparseArray();
        mCachedStyledAttributes = null;
        mLastRetrievedAttrs = null;
        mLastCachedXmlBlockIndex = -1;
        int ai[] = new int[4];
        ai[0] = 0;
        ai[1] = 0;
        ai[2] = 0;
        ai[3] = 0;
        mCachedXmlBlockIds = ai;
        mCachedXmlBlocks = new XmlBlock[4];
        mConfiguration = new Configuration();
        mMetrics = new DisplayMetrics();
        mAssets = assetmanager;
        mMetrics.setToDefaults();
        mCompatibilityInfo = compatibilityinfo;
        updateConfiguration(configuration, displaymetrics);
        assetmanager.ensureStringBlocks();
    }

    private static int attrForQuantityCode(int i) {
        i;
        JVM INSTR tableswitch 0 4: default 36
    //                   0 41
    //                   1 47
    //                   2 53
    //                   3 59
    //                   4 65;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        int j = 0x1000004;
_L8:
        return j;
_L2:
        j = 0x1000005;
        continue; /* Loop/switch isn't completed */
_L3:
        j = 0x1000006;
        continue; /* Loop/switch isn't completed */
_L4:
        j = 0x1000007;
        continue; /* Loop/switch isn't completed */
_L5:
        j = 0x1000008;
        continue; /* Loop/switch isn't completed */
_L6:
        j = 0x1000009;
        if(true) goto _L8; else goto _L7
_L7:
    }

    private void clearDrawableCache(LongSparseArray longsparsearray, int i) {
        int j = longsparsearray.size();
        for(int k = 0; k < j; k++) {
            WeakReference weakreference = (WeakReference)longsparsearray.valueAt(k);
            if(weakreference == null)
                continue;
            android.graphics.drawable.Drawable.ConstantState constantstate = (android.graphics.drawable.Drawable.ConstantState)weakreference.get();
            if(constantstate != null && Configuration.needNewResources(i, constantstate.getChangingConfigurations()))
                longsparsearray.setValueAt(k, null);
        }

    }

    static void clearPreloadedCache() {
        sPreloadedDrawables.clear();
        sPreloadedColorStateLists.clear();
        sPreloadedColorDrawables.clear();
    }

    private ColorStateList getCachedColorStateList(long l) {
        TypedValue typedvalue = mTmpValue;
        typedvalue;
        JVM INSTR monitorenter ;
        ColorStateList colorstatelist;
label0:
        {
            WeakReference weakreference = (WeakReference)mColorStateListCache.get(l);
            if(weakreference != null) {
                colorstatelist = (ColorStateList)weakreference.get();
                if(colorstatelist != null)
                    break label0;
                mColorStateListCache.delete(l);
            }
            colorstatelist = null;
        }
        return colorstatelist;
    }

    private Drawable getCachedDrawable(LongSparseArray longsparsearray, long l) {
        TypedValue typedvalue = mTmpValue;
        typedvalue;
        JVM INSTR monitorenter ;
        Drawable drawable;
label0:
        {
            WeakReference weakreference = (WeakReference)longsparsearray.get(l);
            if(weakreference != null) {
                android.graphics.drawable.Drawable.ConstantState constantstate = (android.graphics.drawable.Drawable.ConstantState)weakreference.get();
                if(constantstate != null) {
                    drawable = constantstate.newDrawable(this);
                    break label0;
                }
                longsparsearray.delete(l);
            }
            drawable = null;
        }
        return drawable;
    }

    private TypedArray getCachedStyledAttributes(int i) {
        TypedValue typedvalue = mTmpValue;
        typedvalue;
        JVM INSTR monitorenter ;
        Object obj = mCachedStyledAttributes;
        if(obj == null) goto _L2; else goto _L1
_L1:
        mCachedStyledAttributes = null;
        obj.mLength = i;
        int j = i * 6;
        if(((TypedArray) (obj)).mData.length < j) {
            obj.mData = new int[j];
            obj.mIndices = new int[i + 1];
        }
          goto _L3
        Exception exception;
        exception;
        throw exception;
_L2:
        obj = new MiuiTypedArray(this, new int[i * 6], new int[i + 1], i);
        typedvalue;
        JVM INSTR monitorexit ;
_L3:
        return ((TypedArray) (obj));
    }

    private NativePluralRules getPluralRule() {
        Object obj = mSync;
        obj;
        JVM INSTR monitorenter ;
        if(mPluralRule == null)
            mPluralRule = NativePluralRules.forLocale(mConfiguration.locale);
        NativePluralRules nativepluralrules = mPluralRule;
        return nativepluralrules;
    }

    public static Resources getSystem() {
        Object obj = mSync;
        obj;
        JVM INSTR monitorenter ;
        Object obj1 = mSystem;
        if(obj1 == null) {
            obj1 = new MiuiResources();
            mSystem = ((Resources) (obj1));
        }
        return ((Resources) (obj1));
    }

    public static int selectDefaultTheme(int i, int j) {
        return selectSystemTheme(i, j, 0x1030005, 0x103006b, 0x1030128);
    }

    public static int selectSystemTheme(int i, int j, int k, int l, int i1) {
        if(i == 0)
            if(j < 11)
                i = k;
            else
            if(j < 14)
                i = l;
            else
                i = i1;
        return i;
    }

    private static String stringForQuantityCode(int i) {
        i;
        JVM INSTR tableswitch 0 4: default 36
    //                   0 42
    //                   1 49
    //                   2 56
    //                   3 63
    //                   4 70;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        String s = "other";
_L8:
        return s;
_L2:
        s = "zero";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "one";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "two";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "few";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "many";
        if(true) goto _L8; else goto _L7
_L7:
    }

    public static void updateSystemConfiguration(Configuration configuration, DisplayMetrics displaymetrics) {
        updateSystemConfiguration(configuration, displaymetrics, null);
    }

    public static void updateSystemConfiguration(Configuration configuration, DisplayMetrics displaymetrics, CompatibilityInfo compatibilityinfo) {
        if(mSystem != null)
            mSystem.updateConfiguration(configuration, displaymetrics, compatibilityinfo);
    }

    public final void finishPreloading() {
        if(mPreloading) {
            mPreloading = false;
            flushLayoutCache();
        }
    }

    public final void flushLayoutCache() {
        int ai[] = mCachedXmlBlockIds;
        ai;
        JVM INSTR monitorenter ;
        int i = mCachedXmlBlockIds.length;
        for(int j = 0; j < i; j++) {
            mCachedXmlBlockIds[j] = 0;
            XmlBlock xmlblock = mCachedXmlBlocks[j];
            if(xmlblock != null)
                xmlblock.close();
            mCachedXmlBlocks[j] = null;
        }

        return;
    }

    public XmlResourceParser getAnimation(int i) throws NotFoundException {
        return loadXmlResourceParser(i, "anim");
    }

    public final AssetManager getAssets() {
        return mAssets;
    }

    public boolean getBoolean(int i) throws NotFoundException {
        boolean flag = true;
        TypedValue typedvalue = mTmpValue;
        typedvalue;
        JVM INSTR monitorenter ;
        TypedValue typedvalue1 = mTmpValue;
        getValue(i, typedvalue1, true);
        if(typedvalue1.type >= 16 && typedvalue1.type <= 31) {
            if(typedvalue1.data == 0)
                flag = false;
            return flag;
        } else {
            throw new NotFoundException((new StringBuilder()).append("Resource ID #0x").append(Integer.toHexString(i)).append(" type #0x").append(Integer.toHexString(typedvalue1.type)).append(" is not valid").toString());
        }
    }

    public int getColor(int i) throws NotFoundException {
        TypedValue typedvalue = mTmpValue;
        typedvalue;
        JVM INSTR monitorenter ;
        TypedValue typedvalue1;
        int j;
        typedvalue1 = mTmpValue;
        getValue(i, typedvalue1, true);
        if(typedvalue1.type >= 16 && typedvalue1.type <= 31) {
            j = typedvalue1.data;
            break MISSING_BLOCK_LABEL_140;
        }
        if(typedvalue1.type == 3) {
            j = loadColorStateList(mTmpValue, i).getDefaultColor();
            break MISSING_BLOCK_LABEL_140;
        }
        break MISSING_BLOCK_LABEL_86;
        Exception exception;
        exception;
        throw exception;
        throw new NotFoundException((new StringBuilder()).append("Resource ID #0x").append(Integer.toHexString(i)).append(" type #0x").append(Integer.toHexString(typedvalue1.type)).append(" is not valid").toString());
        return j;
    }

    public ColorStateList getColorStateList(int i) throws NotFoundException {
        TypedValue typedvalue = mTmpValue;
        typedvalue;
        JVM INSTR monitorenter ;
        TypedValue typedvalue1 = mTmpValue;
        getValue(i, typedvalue1, true);
        ColorStateList colorstatelist = loadColorStateList(typedvalue1, i);
        return colorstatelist;
    }

    public CompatibilityInfo getCompatibilityInfo() {
        CompatibilityInfo compatibilityinfo;
        if(mCompatibilityInfo != null)
            compatibilityinfo = mCompatibilityInfo;
        else
            compatibilityinfo = CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO;
        return compatibilityinfo;
    }

    public Configuration getConfiguration() {
        return mConfiguration;
    }

    public float getDimension(int i) throws NotFoundException {
        TypedValue typedvalue = mTmpValue;
        typedvalue;
        JVM INSTR monitorenter ;
        TypedValue typedvalue1 = mTmpValue;
        getValue(i, typedvalue1, true);
        if(typedvalue1.type == 5) {
            float f = TypedValue.complexToDimension(typedvalue1.data, mMetrics);
            return f;
        } else {
            throw new NotFoundException((new StringBuilder()).append("Resource ID #0x").append(Integer.toHexString(i)).append(" type #0x").append(Integer.toHexString(typedvalue1.type)).append(" is not valid").toString());
        }
    }

    public int getDimensionPixelOffset(int i) throws NotFoundException {
        TypedValue typedvalue = mTmpValue;
        typedvalue;
        JVM INSTR monitorenter ;
        TypedValue typedvalue1 = mTmpValue;
        getValue(i, typedvalue1, true);
        if(typedvalue1.type == 5) {
            int j = TypedValue.complexToDimensionPixelOffset(typedvalue1.data, mMetrics);
            return j;
        } else {
            throw new NotFoundException((new StringBuilder()).append("Resource ID #0x").append(Integer.toHexString(i)).append(" type #0x").append(Integer.toHexString(typedvalue1.type)).append(" is not valid").toString());
        }
    }

    public int getDimensionPixelSize(int i) throws NotFoundException {
        TypedValue typedvalue = mTmpValue;
        typedvalue;
        JVM INSTR monitorenter ;
        TypedValue typedvalue1 = mTmpValue;
        getValue(i, typedvalue1, true);
        if(typedvalue1.type == 5) {
            int j = TypedValue.complexToDimensionPixelSize(typedvalue1.data, mMetrics);
            return j;
        } else {
            throw new NotFoundException((new StringBuilder()).append("Resource ID #0x").append(Integer.toHexString(i)).append(" type #0x").append(Integer.toHexString(typedvalue1.type)).append(" is not valid").toString());
        }
    }

    public DisplayMetrics getDisplayMetrics() {
        return mMetrics;
    }

    public Drawable getDrawable(int i) throws NotFoundException {
        TypedValue typedvalue = mTmpValue;
        typedvalue;
        JVM INSTR monitorenter ;
        TypedValue typedvalue1 = mTmpValue;
        getValue(i, typedvalue1, true);
        Drawable drawable = loadDrawable(typedvalue1, i);
        return drawable;
    }

    public Drawable getDrawableForDensity(int i, int j) throws NotFoundException {
        TypedValue typedvalue = mTmpValue;
        typedvalue;
        JVM INSTR monitorenter ;
        TypedValue typedvalue1 = mTmpValue;
        getValueForDensity(i, j, typedvalue1, true);
        Drawable drawable;
        if(typedvalue1.density > 0 && typedvalue1.density != 65535)
            if(typedvalue1.density == j)
                typedvalue1.density = DisplayMetrics.DENSITY_DEVICE;
            else
                typedvalue1.density = (typedvalue1.density * DisplayMetrics.DENSITY_DEVICE) / j;
        drawable = loadDrawable(typedvalue1, i);
        return drawable;
    }

    public float getFraction(int i, int j, int k) {
        TypedValue typedvalue = mTmpValue;
        typedvalue;
        JVM INSTR monitorenter ;
        TypedValue typedvalue1 = mTmpValue;
        getValue(i, typedvalue1, true);
        if(typedvalue1.type == 6) {
            float f = TypedValue.complexToFraction(typedvalue1.data, j, k);
            return f;
        } else {
            throw new NotFoundException((new StringBuilder()).append("Resource ID #0x").append(Integer.toHexString(i)).append(" type #0x").append(Integer.toHexString(typedvalue1.type)).append(" is not valid").toString());
        }
    }

    public int getIdentifier(String s, String s1, String s2) {
        int j = Integer.parseInt(s);
        int i = j;
_L2:
        return i;
        Exception exception;
        exception;
        i = mAssets.getResourceIdentifier(s, s1, s2);
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int[] getIntArray(int i) throws NotFoundException {
        int ai[] = mAssets.getArrayIntResource(i);
        if(ai != null)
            return ai;
        else
            throw new NotFoundException((new StringBuilder()).append("Int array resource ID #0x").append(Integer.toHexString(i)).toString());
    }

    public int getInteger(int i) throws NotFoundException {
        TypedValue typedvalue = mTmpValue;
        typedvalue;
        JVM INSTR monitorenter ;
        TypedValue typedvalue1 = mTmpValue;
        getValue(i, typedvalue1, true);
        if(typedvalue1.type >= 16 && typedvalue1.type <= 31) {
            int j = typedvalue1.data;
            return j;
        } else {
            throw new NotFoundException((new StringBuilder()).append("Resource ID #0x").append(Integer.toHexString(i)).append(" type #0x").append(Integer.toHexString(typedvalue1.type)).append(" is not valid").toString());
        }
    }

    public XmlResourceParser getLayout(int i) throws NotFoundException {
        return loadXmlResourceParser(i, "layout");
    }

    public Movie getMovie(int i) throws NotFoundException {
        InputStream inputstream = openRawResource(i);
        Movie movie = Movie.decodeStream(inputstream);
        try {
            inputstream.close();
        }
        catch(IOException ioexception) { }
        return movie;
    }

    public String getQuantityString(int i, int j) throws NotFoundException {
        return getQuantityText(i, j).toString();
    }

    public transient String getQuantityString(int i, int j, Object aobj[]) throws NotFoundException {
        String s = getQuantityText(i, j).toString();
        return String.format(mConfiguration.locale, s, aobj);
    }

    public CharSequence getQuantityText(int i, int j) throws NotFoundException {
        NativePluralRules nativepluralrules = getPluralRule();
        CharSequence charsequence = mAssets.getResourceBagText(i, attrForQuantityCode(nativepluralrules.quantityForInt(j)));
        CharSequence charsequence2;
        if(charsequence != null) {
            charsequence2 = charsequence;
        } else {
            CharSequence charsequence1 = mAssets.getResourceBagText(i, 0x1000004);
            if(charsequence1 != null)
                charsequence2 = charsequence1;
            else
                throw new NotFoundException((new StringBuilder()).append("Plural resource ID #0x").append(Integer.toHexString(i)).append(" quantity=").append(j).append(" item=").append(stringForQuantityCode(nativepluralrules.quantityForInt(j))).toString());
        }
        return charsequence2;
    }

    public String getResourceEntryName(int i) throws NotFoundException {
        String s = mAssets.getResourceEntryName(i);
        if(s != null)
            return s;
        else
            throw new NotFoundException((new StringBuilder()).append("Unable to find resource ID #0x").append(Integer.toHexString(i)).toString());
    }

    public String getResourceName(int i) throws NotFoundException {
        String s = mAssets.getResourceName(i);
        if(s != null)
            return s;
        else
            throw new NotFoundException((new StringBuilder()).append("Unable to find resource ID #0x").append(Integer.toHexString(i)).toString());
    }

    public String getResourcePackageName(int i) throws NotFoundException {
        String s = mAssets.getResourcePackageName(i);
        if(s != null)
            return s;
        else
            throw new NotFoundException((new StringBuilder()).append("Unable to find resource ID #0x").append(Integer.toHexString(i)).toString());
    }

    public String getResourceTypeName(int i) throws NotFoundException {
        String s = mAssets.getResourceTypeName(i);
        if(s != null)
            return s;
        else
            throw new NotFoundException((new StringBuilder()).append("Unable to find resource ID #0x").append(Integer.toHexString(i)).toString());
    }

    public String getString(int i) throws NotFoundException {
        CharSequence charsequence = getText(i);
        if(charsequence != null)
            return charsequence.toString();
        else
            throw new NotFoundException((new StringBuilder()).append("String resource ID #0x").append(Integer.toHexString(i)).toString());
    }

    public transient String getString(int i, Object aobj[]) throws NotFoundException {
        String s = getString(i);
        return String.format(mConfiguration.locale, s, aobj);
    }

    public String[] getStringArray(int i) throws NotFoundException {
        String as[] = mAssets.getResourceStringArray(i);
        if(as != null)
            return as;
        else
            throw new NotFoundException((new StringBuilder()).append("String array resource ID #0x").append(Integer.toHexString(i)).toString());
    }

    public CharSequence getText(int i) throws NotFoundException {
        CharSequence charsequence = mAssets.getResourceText(i);
        if(charsequence != null)
            return charsequence;
        else
            throw new NotFoundException((new StringBuilder()).append("String resource ID #0x").append(Integer.toHexString(i)).toString());
    }

    public CharSequence getText(int i, CharSequence charsequence) {
        CharSequence charsequence1;
        if(i != 0)
            charsequence1 = mAssets.getResourceText(i);
        else
            charsequence1 = null;
        if(charsequence1 == null)
            charsequence1 = charsequence;
        return charsequence1;
    }

    public CharSequence[] getTextArray(int i) throws NotFoundException {
        CharSequence acharsequence[] = mAssets.getResourceTextArray(i);
        if(acharsequence != null)
            return acharsequence;
        else
            throw new NotFoundException((new StringBuilder()).append("Text array resource ID #0x").append(Integer.toHexString(i)).toString());
    }

    public void getValue(int i, TypedValue typedvalue, boolean flag) throws NotFoundException {
        if(mAssets.getResourceValue(i, 0, typedvalue, flag))
            return;
        else
            throw new NotFoundException((new StringBuilder()).append("Resource ID #0x").append(Integer.toHexString(i)).toString());
    }

    public void getValue(String s, TypedValue typedvalue, boolean flag) throws NotFoundException {
        int i = getIdentifier(s, "string", null);
        if(i != 0) {
            getValue(i, typedvalue, flag);
            return;
        } else {
            throw new NotFoundException((new StringBuilder()).append("String resource name ").append(s).toString());
        }
    }

    public void getValueForDensity(int i, int j, TypedValue typedvalue, boolean flag) throws NotFoundException {
        if(mAssets.getResourceValue(i, j, typedvalue, flag))
            return;
        else
            throw new NotFoundException((new StringBuilder()).append("Resource ID #0x").append(Integer.toHexString(i)).toString());
    }

    public XmlResourceParser getXml(int i) throws NotFoundException {
        return loadXmlResourceParser(i, "xml");
    }

    ColorStateList loadColorStateList(TypedValue typedvalue, int i) throws NotFoundException {
        long l;
        ColorStateList colorstatelist3;
        l = (long)typedvalue.assetCookie << 32 | (long)typedvalue.data;
        if(typedvalue.type >= 28 && typedvalue.type <= 31) {
            ColorStateList colorstatelist4 = (ColorStateList)sPreloadedColorStateLists.get(l);
            if(colorstatelist4 != null) {
                colorstatelist3 = colorstatelist4;
            } else {
                ColorStateList colorstatelist5 = ColorStateList.valueOf(typedvalue.data);
                if(mPreloading)
                    sPreloadedColorStateLists.put(l, colorstatelist5);
                colorstatelist3 = colorstatelist5;
            }
        } else {
            ColorStateList colorstatelist = getCachedColorStateList(l);
            if(colorstatelist != null) {
                colorstatelist3 = colorstatelist;
            } else {
label0:
                {
                    ColorStateList colorstatelist1 = (ColorStateList)sPreloadedColorStateLists.get(l);
                    if(colorstatelist1 == null)
                        break label0;
                    colorstatelist3 = colorstatelist1;
                }
            }
        }
_L7:
        return colorstatelist3;
        String s;
        if(typedvalue.string == null)
            throw new NotFoundException((new StringBuilder()).append("Resource is not a ColorStateList (color or path): ").append(typedvalue).toString());
        s = typedvalue.string.toString();
        if(!s.endsWith(".xml")) goto _L2; else goto _L1
_L1:
        ColorStateList colorstatelist2;
        try {
            XmlResourceParser xmlresourceparser = loadXmlResourceParser(s, i, typedvalue.assetCookie, "colorstatelist");
            colorstatelist2 = ColorStateList.createFromXml(this, xmlresourceparser);
            xmlresourceparser.close();
        }
        catch(Exception exception) {
            NotFoundException notfoundexception = new NotFoundException((new StringBuilder()).append("File ").append(s).append(" from color state list resource ID #0x").append(Integer.toHexString(i)).toString());
            notfoundexception.initCause(exception);
            throw notfoundexception;
        }
        if(colorstatelist2 == null) goto _L4; else goto _L3
_L3:
        if(!mPreloading) goto _L6; else goto _L5
_L5:
        sPreloadedColorStateLists.put(l, colorstatelist2);
_L4:
        colorstatelist3 = colorstatelist2;
          goto _L7
_L2:
        throw new NotFoundException((new StringBuilder()).append("File ").append(s).append(" from drawable resource ID #0x").append(Integer.toHexString(i)).append(": .xml extension required").toString());
_L6:
        TypedValue typedvalue1 = mTmpValue;
        typedvalue1;
        JVM INSTR monitorenter ;
        mColorStateListCache.put(l, new WeakReference(colorstatelist2));
          goto _L4
    }

    Drawable loadDrawable(TypedValue typedvalue, int i) throws NotFoundException {
        long l;
        boolean flag;
        Object obj;
        Object obj1;
        l = (long)typedvalue.assetCookie << 32 | (long)typedvalue.data;
        flag = false;
        if(typedvalue.type >= 28 && typedvalue.type <= 31)
            flag = true;
        LongSparseArray longsparsearray;
        if(flag)
            longsparsearray = mColorDrawableCache;
        else
            longsparsearray = mDrawableCache;
        obj = getCachedDrawable(longsparsearray, l);
        if(obj == null) goto _L2; else goto _L1
_L1:
        obj1 = obj;
_L4:
        return ((Drawable) (obj1));
_L2:
        android.graphics.drawable.Drawable.ConstantState constantstate1;
        android.graphics.drawable.Drawable.ConstantState constantstate;
        if(flag)
            constantstate = (android.graphics.drawable.Drawable.ConstantState)sPreloadedColorDrawables.get(l);
        else
            constantstate = (android.graphics.drawable.Drawable.ConstantState)sPreloadedDrawables.get(l);
        if(constantstate != null) {
            obj = constantstate.newDrawable(this);
        } else {
            if(flag)
                obj = new ColorDrawable(typedvalue.data);
            if(obj == null) {
                if(typedvalue.string == null)
                    throw new NotFoundException((new StringBuilder()).append("Resource is not a Drawable (color or path): ").append(typedvalue).toString());
                String s = typedvalue.string.toString();
                if(s.endsWith(".xml"))
                    try {
                        XmlResourceParser xmlresourceparser = loadXmlResourceParser(s, i, typedvalue.assetCookie, "drawable");
                        obj = Drawable.createFromXml(this, xmlresourceparser);
                        xmlresourceparser.close();
                    }
                    catch(Exception exception2) {
                        NotFoundException notfoundexception1 = new NotFoundException((new StringBuilder()).append("File ").append(s).append(" from drawable resource ID #0x").append(Integer.toHexString(i)).toString());
                        notfoundexception1.initCause(exception2);
                        throw notfoundexception1;
                    }
                else
                    try {
                        InputStream inputstream = mAssets.openNonAsset(typedvalue.assetCookie, s, 2);
                        Injector.setDrawableId(i);
                        obj = Injector.createFromResourceStream(this, typedvalue, inputstream, s, null);
                        inputstream.close();
                    }
                    catch(Exception exception) {
                        NotFoundException notfoundexception = new NotFoundException((new StringBuilder()).append("File ").append(s).append(" from drawable resource ID #0x").append(Integer.toHexString(i)).toString());
                        notfoundexception.initCause(exception);
                        throw notfoundexception;
                    }
            }
        }
        if(obj != null) {
            ((Drawable) (obj)).setChangingConfigurations(typedvalue.changingConfigurations);
            constantstate1 = ((Drawable) (obj)).getConstantState();
            if(constantstate1 != null) {
                if(!mPreloading)
                    break; /* Loop/switch isn't completed */
                if(flag)
                    sPreloadedColorDrawables.put(l, constantstate1);
                else
                    sPreloadedDrawables.put(l, constantstate1);
            }
        }
_L5:
        obj1 = obj;
        if(true) goto _L4; else goto _L3
_L3:
        TypedValue typedvalue1 = mTmpValue;
        typedvalue1;
        JVM INSTR monitorenter ;
        if(!flag)
            break MISSING_BLOCK_LABEL_500;
        mColorDrawableCache.put(l, new WeakReference(constantstate1));
_L6:
        typedvalue1;
        JVM INSTR monitorexit ;
          goto _L5
        Exception exception1;
        exception1;
        throw exception1;
        mDrawableCache.put(l, new WeakReference(constantstate1));
          goto _L6
    }

    Drawable loadOverlayDrawable(TypedValue typedvalue, int i) {
        return null;
    }

    XmlResourceParser loadXmlResourceParser(int i, String s) throws NotFoundException {
        TypedValue typedvalue = mTmpValue;
        typedvalue;
        JVM INSTR monitorenter ;
        TypedValue typedvalue1 = mTmpValue;
        getValue(i, typedvalue1, true);
        if(typedvalue1.type == 3) {
            XmlResourceParser xmlresourceparser = loadXmlResourceParser(typedvalue1.string.toString(), i, typedvalue1.assetCookie, s);
            return xmlresourceparser;
        } else {
            throw new NotFoundException((new StringBuilder()).append("Resource ID #0x").append(Integer.toHexString(i)).append(" type #0x").append(Integer.toHexString(typedvalue1.type)).append(" is not valid").toString());
        }
    }

    XmlResourceParser loadXmlResourceParser(String s, int i, int j, String s1) throws NotFoundException {
        if(i == 0) goto _L2; else goto _L1
_L1:
        int ai[] = mCachedXmlBlockIds;
        ai;
        JVM INSTR monitorenter ;
        int k;
        int l;
        k = mCachedXmlBlockIds.length;
        l = 0;
_L11:
        if(l >= k) goto _L4; else goto _L3
_L3:
        if(mCachedXmlBlockIds[l] != i) goto _L6; else goto _L5
_L5:
        XmlResourceParser xmlresourceparser = mCachedXmlBlocks[l].newParser();
          goto _L7
_L4:
        XmlBlock xmlblock = mAssets.openXmlBlockAsset(j, s);
        if(xmlblock == null) goto _L9; else goto _L8
_L8:
        int i1 = 1 + mLastCachedXmlBlockIndex;
        if(i1 >= k)
            i1 = 0;
        mLastCachedXmlBlockIndex = i1;
        XmlBlock xmlblock1 = mCachedXmlBlocks[i1];
        if(xmlblock1 != null)
            xmlblock1.close();
        mCachedXmlBlockIds[i1] = i;
        mCachedXmlBlocks[i1] = xmlblock;
        xmlresourceparser = xmlblock.newParser();
          goto _L7
        Exception exception1;
        exception1;
        try {
            throw exception1;
        }
        catch(Exception exception) {
            NotFoundException notfoundexception = new NotFoundException((new StringBuilder()).append("File ").append(s).append(" from xml type ").append(s1).append(" resource ID #0x").append(Integer.toHexString(i)).toString());
            notfoundexception.initCause(exception);
            throw notfoundexception;
        }
_L9:
        ai;
        JVM INSTR monitorexit ;
_L2:
        throw new NotFoundException((new StringBuilder()).append("File ").append(s).append(" from xml type ").append(s1).append(" resource ID #0x").append(Integer.toHexString(i)).toString());
_L7:
        return xmlresourceparser;
_L6:
        l++;
        if(true) goto _L11; else goto _L10
_L10:
    }

    public Theme newTheme() {
        return new Theme();
    }

    public TypedArray obtainAttributes(AttributeSet attributeset, int ai[]) {
        TypedArray typedarray = getCachedStyledAttributes(ai.length);
        XmlBlock.Parser parser = (XmlBlock.Parser)attributeset;
        mAssets.retrieveAttributes(parser.mParseState, ai, typedarray.mData, typedarray.mIndices);
        typedarray.mRsrcs = ai;
        typedarray.mXml = parser;
        return typedarray;
    }

    public TypedArray obtainTypedArray(int i) throws NotFoundException {
        int j = mAssets.getArraySize(i);
        if(j < 0) {
            throw new NotFoundException((new StringBuilder()).append("Array resource ID #0x").append(Integer.toHexString(i)).toString());
        } else {
            TypedArray typedarray = getCachedStyledAttributes(j);
            typedarray.mLength = mAssets.retrieveArray(i, typedarray.mData);
            typedarray.mIndices[0] = 0;
            return typedarray;
        }
    }

    public InputStream openRawResource(int i) throws NotFoundException {
        TypedValue typedvalue = mTmpValue;
        typedvalue;
        JVM INSTR monitorenter ;
        InputStream inputstream = openRawResource(i, mTmpValue);
        return inputstream;
    }

    public InputStream openRawResource(int i, TypedValue typedvalue) throws NotFoundException {
        getValue(i, typedvalue, true);
        InputStream inputstream;
        try {
            inputstream = mAssets.openNonAsset(typedvalue.assetCookie, typedvalue.string.toString(), 2);
        }
        catch(Exception exception) {
            NotFoundException notfoundexception = new NotFoundException((new StringBuilder()).append("File ").append(typedvalue.string.toString()).append(" from drawable resource ID #0x").append(Integer.toHexString(i)).toString());
            notfoundexception.initCause(exception);
            throw notfoundexception;
        }
        return inputstream;
    }

    public AssetFileDescriptor openRawResourceFd(int i) throws NotFoundException {
        TypedValue typedvalue = mTmpValue;
        typedvalue;
        JVM INSTR monitorenter ;
        TypedValue typedvalue1;
        typedvalue1 = mTmpValue;
        getValue(i, typedvalue1, true);
        AssetFileDescriptor assetfiledescriptor;
        try {
            assetfiledescriptor = mAssets.openNonAssetFd(typedvalue1.assetCookie, typedvalue1.string.toString());
        }
        catch(Exception exception1) {
            NotFoundException notfoundexception = new NotFoundException((new StringBuilder()).append("File ").append(typedvalue1.string.toString()).append(" from drawable resource ID #0x").append(Integer.toHexString(i)).toString());
            notfoundexception.initCause(exception1);
            throw notfoundexception;
        }
        typedvalue;
        JVM INSTR monitorexit ;
        return assetfiledescriptor;
        Exception exception;
        exception;
        throw exception;
    }

    public void parseBundleExtra(String s, AttributeSet attributeset, Bundle bundle) throws XmlPullParserException {
        boolean flag = true;
        TypedArray typedarray = obtainAttributes(attributeset, com.android.internal.R.styleable.Extra);
        String s1 = typedarray.getString(0);
        if(s1 == null) {
            typedarray.recycle();
            throw new XmlPullParserException((new StringBuilder()).append("<").append(s).append("> requires an android:name attribute at ").append(attributeset.getPositionDescription()).toString());
        }
        TypedValue typedvalue = typedarray.peekValue(flag);
        if(typedvalue != null) {
            if(typedvalue.type == 3)
                bundle.putCharSequence(s1, typedvalue.coerceToString());
            else
            if(typedvalue.type == 18) {
                if(typedvalue.data == 0)
                    flag = false;
                bundle.putBoolean(s1, flag);
            } else
            if(typedvalue.type >= 16 && typedvalue.type <= 31)
                bundle.putInt(s1, typedvalue.data);
            else
            if(typedvalue.type == 4) {
                bundle.putFloat(s1, typedvalue.getFloat());
            } else {
                typedarray.recycle();
                throw new XmlPullParserException((new StringBuilder()).append("<").append(s).append("> only supports string, integer, float, color, and boolean at ").append(attributeset.getPositionDescription()).toString());
            }
            typedarray.recycle();
            return;
        } else {
            typedarray.recycle();
            throw new XmlPullParserException((new StringBuilder()).append("<").append(s).append("> requires an android:value or android:resource attribute at ").append(attributeset.getPositionDescription()).toString());
        }
    }

    public void parseBundleExtras(XmlResourceParser xmlresourceparser, Bundle bundle) throws XmlPullParserException, IOException {
        int i = xmlresourceparser.getDepth();
        do {
            int j = xmlresourceparser.next();
            if(j == 1 || j == 3 && xmlresourceparser.getDepth() <= i)
                break;
            if(j != 3 && j != 4)
                if(xmlresourceparser.getName().equals("extra")) {
                    parseBundleExtra("extra", xmlresourceparser, bundle);
                    XmlUtils.skipCurrentTag(xmlresourceparser);
                } else {
                    XmlUtils.skipCurrentTag(xmlresourceparser);
                }
        } while(true);
    }

    public void setCompatibilityInfo(CompatibilityInfo compatibilityinfo) {
        mCompatibilityInfo = compatibilityinfo;
        updateConfiguration(mConfiguration, mMetrics);
    }

    public final void startPreloading() {
        Object obj = mSync;
        obj;
        JVM INSTR monitorenter ;
        if(mPreloaded)
            throw new IllegalStateException("Resources already preloaded");
        break MISSING_BLOCK_LABEL_28;
        Exception exception;
        exception;
        throw exception;
        mPreloaded = true;
        mPreloading = true;
        obj;
        JVM INSTR monitorexit ;
    }

    public void updateConfiguration(Configuration configuration, DisplayMetrics displaymetrics) {
        updateConfiguration(configuration, displaymetrics, null);
    }

    public void updateConfiguration(Configuration configuration, DisplayMetrics displaymetrics, CompatibilityInfo compatibilityinfo) {
        TypedValue typedvalue = mTmpValue;
        typedvalue;
        JVM INSTR monitorenter ;
        if(compatibilityinfo == null)
            break MISSING_BLOCK_LABEL_18;
        mCompatibilityInfo = compatibilityinfo;
        int i;
        String s;
        int j;
        int k;
        if(displaymetrics != null)
            mMetrics.setTo(displaymetrics);
        if(mCompatibilityInfo != null)
            mCompatibilityInfo.applyToDisplayMetrics(mMetrics);
        i = 0xfffffff;
        if(configuration != null) {
            mTmpConfig.setTo(configuration);
            if(mCompatibilityInfo != null)
                mCompatibilityInfo.applyToConfiguration(mTmpConfig);
            if(mTmpConfig.locale == null)
                mTmpConfig.locale = Locale.getDefault();
            int i1 = mConfiguration.updateFrom(mTmpConfig);
            i = ActivityInfo.activityInfoConfigToNative(i1) | 0x80000000 & i1;
        }
        if(mConfiguration.locale == null)
            mConfiguration.locale = Locale.getDefault();
        mMetrics.scaledDensity = mMetrics.density * mConfiguration.fontScale;
        s = null;
        if(mConfiguration.locale != null) {
            s = mConfiguration.locale.getLanguage();
            if(mConfiguration.locale.getCountry() != null)
                s = (new StringBuilder()).append(s).append("-").append(mConfiguration.locale.getCountry()).toString();
        }
        if(mMetrics.widthPixels < mMetrics.heightPixels)
            break MISSING_BLOCK_LABEL_481;
        j = mMetrics.widthPixels;
        k = mMetrics.heightPixels;
_L1:
        int l = mConfiguration.keyboardHidden;
        if(l == 1 && mConfiguration.hardKeyboardHidden == 2)
            l = 3;
        mAssets.setConfiguration(mConfiguration.mcc, mConfiguration.mnc, s, mConfiguration.orientation, mConfiguration.touchscreen, (int)(160F * mMetrics.density), mConfiguration.keyboard, l, mConfiguration.navigation, j, k, mConfiguration.smallestScreenWidthDp, mConfiguration.screenWidthDp, mConfiguration.screenHeightDp, mConfiguration.screenLayout, mConfiguration.uiMode, android.os.Build.VERSION.RESOURCES_SDK_INT);
        clearDrawableCache(mDrawableCache, i);
        clearDrawableCache(mColorDrawableCache, i);
        mColorStateListCache.clear();
        flushLayoutCache();
        typedvalue;
        JVM INSTR monitorexit ;
        synchronized(mSync) {
            if(mPluralRule != null)
                mPluralRule = NativePluralRules.forLocale(configuration.locale);
        }
        return;
        j = mMetrics.heightPixels;
        k = mMetrics.widthPixels;
          goto _L1
        Exception exception;
        exception;
        throw exception;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    private static final boolean DEBUG_ATTRIBUTES_CACHE = false;
    private static final boolean DEBUG_CONFIG = false;
    private static final boolean DEBUG_LOAD = false;
    private static final int ID_OTHER = 0x1000004;
    static final String TAG = "Resources";
    private static final boolean TRACE_FOR_MISS_PRELOAD;
    private static final boolean TRACE_FOR_PRELOAD;
    private static boolean mPreloaded;
    private static final Object mSync = new Object();
    static Resources mSystem = null;
    private static final LongSparseArray sPreloadedColorDrawables = new LongSparseArray();
    private static final LongSparseArray sPreloadedColorStateLists = new LongSparseArray();
    private static final LongSparseArray sPreloadedDrawables = new LongSparseArray();
    final AssetManager mAssets;
    TypedArray mCachedStyledAttributes;
    private final int mCachedXmlBlockIds[];
    private final XmlBlock mCachedXmlBlocks[];
    private final LongSparseArray mColorDrawableCache;
    private final LongSparseArray mColorStateListCache;
    private CompatibilityInfo mCompatibilityInfo;
    private final Configuration mConfiguration;
    private final LongSparseArray mDrawableCache;
    private int mLastCachedXmlBlockIndex;
    RuntimeException mLastRetrievedAttrs;
    final DisplayMetrics mMetrics;
    private NativePluralRules mPluralRule;
    private boolean mPreloading;
    final Configuration mTmpConfig;
    final TypedValue mTmpValue;


}
