// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;

import android.content.res.AssetManager;
import android.util.SparseArray;
import java.io.File;

public class Typeface {

    private Typeface(int i) {
        mStyle = 0;
        if(i == 0) {
            throw new RuntimeException("native typeface cannot be made");
        } else {
            native_instance = i;
            mStyle = nativeGetStyle(i);
            return;
        }
    }

    public static Typeface create(Typeface typeface, int i) {
        int j = 0;
        if(typeface == null) goto _L2; else goto _L1
_L1:
        if(typeface.mStyle != i) goto _L4; else goto _L3
_L3:
        Typeface typeface1 = typeface;
_L6:
        return typeface1;
_L4:
        j = typeface.native_instance;
_L2:
        SparseArray sparsearray = (SparseArray)sTypefaceCache.get(j);
        if(sparsearray != null) {
            typeface1 = (Typeface)sparsearray.get(i);
            if(typeface1 != null)
                continue; /* Loop/switch isn't completed */
        }
        typeface1 = new Typeface(nativeCreateFromTypeface(j, i));
        if(sparsearray == null) {
            sparsearray = new SparseArray(4);
            sTypefaceCache.put(j, sparsearray);
        }
        sparsearray.put(i, typeface1);
        if(true) goto _L6; else goto _L5
_L5:
    }

    public static Typeface create(String s, int i) {
        return new Typeface(nativeCreate(s, i));
    }

    public static Typeface createFromAsset(AssetManager assetmanager, String s) {
        return new Typeface(nativeCreateFromAsset(assetmanager, s));
    }

    public static Typeface createFromFile(File file) {
        return new Typeface(nativeCreateFromFile(file.getAbsolutePath()));
    }

    public static Typeface createFromFile(String s) {
        return new Typeface(nativeCreateFromFile(s));
    }

    public static Typeface defaultFromStyle(int i) {
        return sDefaults[i];
    }

    private static native int nativeCreate(String s, int i);

    private static native int nativeCreateFromAsset(AssetManager assetmanager, String s);

    private static native int nativeCreateFromFile(String s);

    private static native int nativeCreateFromTypeface(int i, int j);

    private static native int nativeGetStyle(int i);

    private static native void nativeUnref(int i);

    public static native void setGammaForText(float f, float f1);

    public boolean equals(Object obj) {
        boolean flag = true;
        if(this != obj) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if(obj == null || getClass() != obj.getClass()) {
            flag = false;
        } else {
            Typeface typeface = (Typeface)obj;
            if(mStyle != typeface.mStyle || native_instance != typeface.native_instance)
                flag = false;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    protected void finalize() throws Throwable {
        nativeUnref(native_instance);
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public int getStyle() {
        return mStyle;
    }

    public int hashCode() {
        return 31 * native_instance + mStyle;
    }

    public final boolean isBold() {
        boolean flag;
        if((1 & mStyle) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public final boolean isItalic() {
        boolean flag;
        if((2 & mStyle) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static final int BOLD = 1;
    public static final int BOLD_ITALIC = 3;
    public static final Typeface DEFAULT;
    public static final Typeface DEFAULT_BOLD;
    public static final int ITALIC = 2;
    public static final Typeface MONOSPACE = create("monospace", 0);
    public static final int NORMAL;
    public static final Typeface SANS_SERIF = create("sans-serif", 0);
    public static final Typeface SERIF = create("serif", 0);
    static Typeface sDefaults[];
    private static final SparseArray sTypefaceCache = new SparseArray(3);
    private int mStyle;
    int native_instance;

    static  {
        DEFAULT = create((String)null, 0);
        DEFAULT_BOLD = create((String)null, 1);
        Typeface atypeface[] = new Typeface[4];
        atypeface[0] = DEFAULT;
        atypeface[1] = DEFAULT_BOLD;
        atypeface[2] = create((String)null, 2);
        atypeface[3] = create((String)null, 3);
        sDefaults = atypeface;
    }
}
