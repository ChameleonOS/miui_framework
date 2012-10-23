// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.emoji;

import android.graphics.Bitmap;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

public final class EmojiFactory {
    private class CustomLinkedHashMap extends LinkedHashMap {

        protected boolean removeEldestEntry(java.util.Map.Entry entry) {
            boolean flag;
            if(size() > sCacheSize)
                flag = true;
            else
                flag = false;
            return flag;
        }

        final EmojiFactory this$0;

        public CustomLinkedHashMap() {
            this$0 = EmojiFactory.this;
            super(16, 0.75F, true);
        }
    }


    private EmojiFactory(int i, String s) {
        sCacheSize = 100;
        mNativeEmojiFactory = i;
        mName = s;
        mCache = new CustomLinkedHashMap();
    }

    private native void nativeDestructor(int i);

    private native int nativeGetAndroidPuaFromVendorSpecificPua(int i, int j);

    private native int nativeGetAndroidPuaFromVendorSpecificSjis(int i, char c);

    private native Bitmap nativeGetBitmapFromAndroidPua(int i, int j);

    private native int nativeGetMaximumAndroidPua(int i);

    private native int nativeGetMaximumVendorSpecificPua(int i);

    private native int nativeGetMinimumAndroidPua(int i);

    private native int nativeGetMinimumVendorSpecificPua(int i);

    private native int nativeGetVendorSpecificPuaFromAndroidPua(int i, int j);

    private native int nativeGetVendorSpecificSjisFromAndroidPua(int i, int j);

    public static native EmojiFactory newAvailableInstance();

    public static native EmojiFactory newInstance(String s);

    protected void finalize() throws Throwable {
        nativeDestructor(mNativeEmojiFactory);
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public int getAndroidPuaFromVendorSpecificPua(int i) {
        return nativeGetAndroidPuaFromVendorSpecificPua(mNativeEmojiFactory, i);
    }

    public String getAndroidPuaFromVendorSpecificPua(String s) {
        if(s != null) goto _L2; else goto _L1
_L1:
        String s1 = null;
_L8:
        return s1;
_L2:
        int i;
        int j;
        int k;
        int ai[];
        int l;
        int i1;
        i = nativeGetMinimumVendorSpecificPua(mNativeEmojiFactory);
        j = nativeGetMaximumVendorSpecificPua(mNativeEmojiFactory);
        k = s.length();
        ai = new int[s.codePointCount(0, k)];
        l = 0;
        i1 = 0;
_L4:
        int j1;
        if(i1 >= k)
            break MISSING_BLOCK_LABEL_123;
        j1 = s.codePointAt(i1);
        if(i > j1 || j1 > j)
            break; /* Loop/switch isn't completed */
        int k1 = getAndroidPuaFromVendorSpecificPua(j1);
        if(k1 <= 0)
            break; /* Loop/switch isn't completed */
        ai[l] = k1;
_L5:
        i1 = s.offsetByCodePoints(i1, 1);
        l++;
        if(true) goto _L4; else goto _L3
_L3:
        ai[l] = j1;
          goto _L5
        if(true) goto _L4; else goto _L6
_L6:
        s1 = new String(ai, 0, l);
        if(true) goto _L8; else goto _L7
_L7:
    }

    public int getAndroidPuaFromVendorSpecificSjis(char c) {
        return nativeGetAndroidPuaFromVendorSpecificSjis(mNativeEmojiFactory, c);
    }

    /**
     * @deprecated Method getBitmapFromAndroidPua is deprecated
     */

    public Bitmap getBitmapFromAndroidPua(int i) {
        this;
        JVM INSTR monitorenter ;
        WeakReference weakreference = (WeakReference)mCache.get(Integer.valueOf(i));
        if(weakreference != null) goto _L2; else goto _L1
_L1:
        Bitmap bitmap1;
        bitmap1 = nativeGetBitmapFromAndroidPua(mNativeEmojiFactory, i);
        if(bitmap1 != null)
            mCache.put(Integer.valueOf(i), new WeakReference(bitmap1));
_L4:
        this;
        JVM INSTR monitorexit ;
        return bitmap1;
_L2:
        Bitmap bitmap;
        bitmap = (Bitmap)weakreference.get();
        if(bitmap == null) {
            bitmap1 = nativeGetBitmapFromAndroidPua(mNativeEmojiFactory, i);
            mCache.put(Integer.valueOf(i), new WeakReference(bitmap1));
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_123;
        Exception exception;
        exception;
        throw exception;
        bitmap1 = bitmap;
        if(true) goto _L4; else goto _L3
_L3:
    }

    /**
     * @deprecated Method getBitmapFromVendorSpecificPua is deprecated
     */

    public Bitmap getBitmapFromVendorSpecificPua(int i) {
        this;
        JVM INSTR monitorenter ;
        Bitmap bitmap = getBitmapFromAndroidPua(getAndroidPuaFromVendorSpecificPua(i));
        this;
        JVM INSTR monitorexit ;
        return bitmap;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getBitmapFromVendorSpecificSjis is deprecated
     */

    public Bitmap getBitmapFromVendorSpecificSjis(char c) {
        this;
        JVM INSTR monitorenter ;
        Bitmap bitmap = getBitmapFromAndroidPua(getAndroidPuaFromVendorSpecificSjis(c));
        this;
        JVM INSTR monitorexit ;
        return bitmap;
        Exception exception;
        exception;
        throw exception;
    }

    public int getMaximumAndroidPua() {
        return nativeGetMaximumAndroidPua(mNativeEmojiFactory);
    }

    public int getMinimumAndroidPua() {
        return nativeGetMinimumAndroidPua(mNativeEmojiFactory);
    }

    public int getVendorSpecificPuaFromAndroidPua(int i) {
        return nativeGetVendorSpecificPuaFromAndroidPua(mNativeEmojiFactory, i);
    }

    public String getVendorSpecificPuaFromAndroidPua(String s) {
        if(s != null) goto _L2; else goto _L1
_L1:
        String s1 = null;
_L8:
        return s1;
_L2:
        int i;
        int j;
        int k;
        int ai[];
        int l;
        int i1;
        i = nativeGetMinimumAndroidPua(mNativeEmojiFactory);
        j = nativeGetMaximumAndroidPua(mNativeEmojiFactory);
        k = s.length();
        ai = new int[s.codePointCount(0, k)];
        l = 0;
        i1 = 0;
_L4:
        int j1;
        if(i1 >= k)
            break MISSING_BLOCK_LABEL_123;
        j1 = s.codePointAt(i1);
        if(i > j1 || j1 > j)
            break; /* Loop/switch isn't completed */
        int k1 = getVendorSpecificPuaFromAndroidPua(j1);
        if(k1 <= 0)
            break; /* Loop/switch isn't completed */
        ai[l] = k1;
_L5:
        i1 = s.offsetByCodePoints(i1, 1);
        l++;
        if(true) goto _L4; else goto _L3
_L3:
        ai[l] = j1;
          goto _L5
        if(true) goto _L4; else goto _L6
_L6:
        s1 = new String(ai, 0, l);
        if(true) goto _L8; else goto _L7
_L7:
    }

    public int getVendorSpecificSjisFromAndroidPua(int i) {
        return nativeGetVendorSpecificSjisFromAndroidPua(mNativeEmojiFactory, i);
    }

    public String name() {
        return mName;
    }

    private Map mCache;
    private String mName;
    private int mNativeEmojiFactory;
    private int sCacheSize;

}
