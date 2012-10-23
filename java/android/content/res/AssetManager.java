// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.res;

import android.app.MiuiThemeHelper;
import android.os.ParcelFileDescriptor;
import android.util.TypedValue;
import java.io.*;
import java.util.HashMap;

// Referenced classes of package android.content.res:
//            StringBlock, AssetFileDescriptor, XmlBlock, XmlResourceParser

public final class AssetManager {
    public final class AssetInputStream extends InputStream {

        public final int available() throws IOException {
            long l = getAssetRemainingLength(mAsset);
            int i;
            if(l > 0x7fffffffL)
                i = 0x7fffffff;
            else
                i = (int)l;
            return i;
        }

        public final void close() throws IOException {
            AssetManager assetmanager = AssetManager.this;
            assetmanager;
            JVM INSTR monitorenter ;
            if(mAsset != 0) {
                destroyAsset(mAsset);
                mAsset = 0;
                decRefsLocked(hashCode());
            }
            return;
        }

        protected void finalize() throws Throwable {
            close();
        }

        public final int getAssetInt() {
            return mAsset;
        }

        public final void mark(int i) {
            mMarkPos = seekAsset(mAsset, 0L, 0);
        }

        public final boolean markSupported() {
            return true;
        }

        public final int read() throws IOException {
            return readAssetChar(mAsset);
        }

        public final int read(byte abyte0[]) throws IOException {
            return readAsset(mAsset, abyte0, 0, abyte0.length);
        }

        public final int read(byte abyte0[], int i, int j) throws IOException {
            return readAsset(mAsset, abyte0, i, j);
        }

        public final void reset() throws IOException {
            seekAsset(mAsset, mMarkPos, -1);
        }

        public final long skip(long l) throws IOException {
            long l1 = seekAsset(mAsset, 0L, 0);
            if(l1 + l > mLength)
                l = mLength - l1;
            if(l > 0L)
                seekAsset(mAsset, l, 0);
            return l;
        }

        private int mAsset;
        private long mLength;
        private long mMarkPos;
        final AssetManager this$0;

        private AssetInputStream(int i) {
            this$0 = AssetManager.this;
            super();
            mAsset = i;
            mLength = getAssetLength(i);
        }

    }


    public AssetManager() {
        mValue = new TypedValue();
        mOffsets = new long[2];
        mStringBlocks = null;
        mNumRefs = 1;
        mOpen = true;
        this;
        JVM INSTR monitorenter ;
        init();
        ensureSystemAssets();
        MiuiThemeHelper.addExtraAssetPaths(this);
        return;
    }

    private AssetManager(boolean flag) {
        mValue = new TypedValue();
        mOffsets = new long[2];
        mStringBlocks = null;
        mNumRefs = 1;
        mOpen = true;
        init();
        MiuiThemeHelper.addExtraAssetPaths(this);
    }

    static final native boolean applyStyle(int i, int j, int k, int l, int ai[], int ai1[], int ai2[]);

    static final native void applyThemeStyle(int i, int j, boolean flag);

    static final native void copyTheme(int i, int j);

    private final void decRefsLocked(int i) {
        mNumRefs = -1 + mNumRefs;
        if(mNumRefs == 0)
            destroy();
    }

    private final native void deleteTheme(int i);

    private final native void destroy();

    private final native void destroyAsset(int i);

    static final native void dumpTheme(int i, int j, String s, String s1);

    private static void ensureSystemAssets() {
        Object obj = sSync;
        obj;
        JVM INSTR monitorenter ;
        if(sSystem == null) {
            AssetManager assetmanager = new AssetManager(true);
            assetmanager.makeStringBlocks(false);
            sSystem = assetmanager;
        }
        return;
    }

    private final native int[] getArrayStringInfo(int i);

    private final native String[] getArrayStringResource(int i);

    public static final native String getAssetAllocations();

    private final native long getAssetLength(int i);

    private final native long getAssetRemainingLength(int i);

    public static final native int getGlobalAssetCount();

    public static final native int getGlobalAssetManagerCount();

    private final native int getNativeStringBlock(int i);

    private final native int getStringBlockCount();

    public static AssetManager getSystem() {
        ensureSystemAssets();
        return sSystem;
    }

    private final void incRefsLocked(int i) {
        mNumRefs = 1 + mNumRefs;
    }

    private final native void init();

    private final native int loadResourceBagValue(int i, int j, TypedValue typedvalue, boolean flag);

    private final native int loadResourceValue(int i, short word0, TypedValue typedvalue, boolean flag);

    static final native int loadThemeAttributeValue(int i, int j, TypedValue typedvalue, boolean flag);

    private final native int newTheme();

    private final native int openAsset(String s, int i);

    private final native ParcelFileDescriptor openAssetFd(String s, long al[]) throws IOException;

    private native ParcelFileDescriptor openNonAssetFdNative(int i, String s, long al[]) throws IOException;

    private final native int openNonAssetNative(int i, String s, int j);

    private final native int openXmlAssetNative(int i, String s);

    private final native int readAsset(int i, byte abyte0[], int j, int k);

    private final native int readAssetChar(int i);

    private final native long seekAsset(int i, long l, int j);

    public final native int addAssetPath(String s);

    public final int[] addAssetPaths(String as[]) {
        int ai[];
        if(as == null) {
            ai = null;
        } else {
            ai = new int[as.length];
            int i = 0;
            while(i < as.length)  {
                ai[i] = addAssetPath(as[i]);
                i++;
            }
        }
        return ai;
    }

    public void close() {
        this;
        JVM INSTR monitorenter ;
        if(mOpen) {
            mOpen = false;
            decRefsLocked(hashCode());
        }
        return;
    }

    final int createTheme() {
        this;
        JVM INSTR monitorenter ;
        if(!mOpen)
            throw new RuntimeException("Assetmanager has been closed");
        break MISSING_BLOCK_LABEL_24;
        Exception exception;
        exception;
        throw exception;
        int i;
        i = newTheme();
        incRefsLocked(i);
        this;
        JVM INSTR monitorexit ;
        return i;
    }

    final void ensureStringBlocks() {
        if(mStringBlocks != null)
            break MISSING_BLOCK_LABEL_31;
        this;
        JVM INSTR monitorenter ;
        if(mStringBlocks == null)
            makeStringBlocks(true);
    }

    protected void finalize() throws Throwable {
        destroy();
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    final native int[] getArrayIntResource(int i);

    final native int getArraySize(int i);

    public final native String getCookieName(int i);

    public final native String[] getLocales();

    final CharSequence getPooledString(int i, int j) {
        return mStringBlocks[i - 1].get(j);
    }

    final CharSequence getResourceBagText(int i, int j) {
        this;
        JVM INSTR monitorenter ;
        CharSequence charsequence;
        TypedValue typedvalue = mValue;
        int k = loadResourceBagValue(i, j, typedvalue, true);
        if(k >= 0) {
            if(typedvalue.type == 3)
                charsequence = mStringBlocks[k].get(typedvalue.data);
            else
                charsequence = typedvalue.coerceToString();
            break MISSING_BLOCK_LABEL_77;
        }
        break MISSING_BLOCK_LABEL_72;
        Exception exception;
        exception;
        throw exception;
        this;
        JVM INSTR monitorexit ;
        charsequence = null;
        return charsequence;
    }

    final native String getResourceEntryName(int i);

    final native int getResourceIdentifier(String s, String s1, String s2);

    final native String getResourceName(int i);

    final native String getResourcePackageName(int i);

    final String[] getResourceStringArray(int i) {
        return getArrayStringResource(i);
    }

    final CharSequence getResourceText(int i) {
        this;
        JVM INSTR monitorenter ;
        CharSequence charsequence;
        TypedValue typedvalue = mValue;
        int j = loadResourceValue(i, (short)0, typedvalue, true);
        if(j >= 0) {
            if(typedvalue.type == 3)
                charsequence = mStringBlocks[j].get(typedvalue.data);
            else
                charsequence = typedvalue.coerceToString();
            break MISSING_BLOCK_LABEL_72;
        }
        break MISSING_BLOCK_LABEL_67;
        Exception exception;
        exception;
        throw exception;
        this;
        JVM INSTR monitorexit ;
        charsequence = null;
        return charsequence;
    }

    final CharSequence[] getResourceTextArray(int i) {
        int ai[] = getArrayStringInfo(i);
        int j = ai.length;
        CharSequence acharsequence[] = new CharSequence[j / 2];
        int k = 0;
        int l = 0;
        while(k < j)  {
            int i1 = ai[k];
            int j1 = ai[k + 1];
            CharSequence charsequence;
            if(j1 >= 0)
                charsequence = mStringBlocks[i1].get(j1);
            else
                charsequence = null;
            acharsequence[l] = charsequence;
            k += 2;
            l++;
        }
        return acharsequence;
    }

    final native String getResourceTypeName(int i);

    final boolean getResourceValue(int i, int j, TypedValue typedvalue, boolean flag) {
        boolean flag1 = true;
        int k = loadResourceValue(i, (short)j, typedvalue, flag);
        if(k >= 0) {
            if(typedvalue.type == 3)
                typedvalue.string = mStringBlocks[k].get(typedvalue.data);
        } else {
            flag1 = false;
        }
        return flag1;
    }

    final boolean getThemeValue(int i, int j, TypedValue typedvalue, boolean flag) {
        boolean flag1 = true;
        int k = loadThemeAttributeValue(i, j, typedvalue, flag);
        if(k >= 0) {
            if(typedvalue.type == 3) {
                StringBlock astringblock[] = mStringBlocks;
                if(astringblock == null) {
                    ensureStringBlocks();
                    astringblock = mStringBlocks;
                }
                typedvalue.string = astringblock[k].get(typedvalue.data);
            }
        } else {
            flag1 = false;
        }
        return flag1;
    }

    public final native boolean isUpToDate();

    public final native String[] list(String s) throws IOException;

    final void makeStringBlocks(boolean flag) {
        int i;
        int j;
        int k;
        if(flag)
            i = sSystem.mStringBlocks.length;
        else
            i = 0;
        j = getStringBlockCount();
        mStringBlocks = new StringBlock[j];
        k = 0;
        while(k < j)  {
            if(k < i)
                mStringBlocks[k] = sSystem.mStringBlocks[k];
            else
                mStringBlocks[k] = new StringBlock(getNativeStringBlock(k), true);
            k++;
        }
    }

    public final InputStream open(String s) throws IOException {
        return open(s, 2);
    }

    public final InputStream open(String s, int i) throws IOException {
        this;
        JVM INSTR monitorenter ;
        if(!mOpen)
            throw new RuntimeException("Assetmanager has been closed");
        break MISSING_BLOCK_LABEL_24;
        Exception exception;
        exception;
        throw exception;
        int j = openAsset(s, i);
        if(j != 0) {
            AssetInputStream assetinputstream = new AssetInputStream(j);
            incRefsLocked(assetinputstream.hashCode());
            return assetinputstream;
        }
        this;
        JVM INSTR monitorexit ;
        throw new FileNotFoundException((new StringBuilder()).append("Asset file: ").append(s).toString());
    }

    public final AssetFileDescriptor openFd(String s) throws IOException {
        this;
        JVM INSTR monitorenter ;
        if(!mOpen)
            throw new RuntimeException("Assetmanager has been closed");
        break MISSING_BLOCK_LABEL_24;
        Exception exception;
        exception;
        throw exception;
        ParcelFileDescriptor parcelfiledescriptor = openAssetFd(s, mOffsets);
        if(parcelfiledescriptor != null) {
            AssetFileDescriptor assetfiledescriptor = new AssetFileDescriptor(parcelfiledescriptor, mOffsets[0], mOffsets[1]);
            return assetfiledescriptor;
        }
        this;
        JVM INSTR monitorexit ;
        throw new FileNotFoundException((new StringBuilder()).append("Asset file: ").append(s).toString());
    }

    public final InputStream openNonAsset(int i, String s) throws IOException {
        return openNonAsset(i, s, 2);
    }

    public final InputStream openNonAsset(int i, String s, int j) throws IOException {
        this;
        JVM INSTR monitorenter ;
        if(!mOpen)
            throw new RuntimeException("Assetmanager has been closed");
        break MISSING_BLOCK_LABEL_26;
        Exception exception;
        exception;
        throw exception;
        int k = openNonAssetNative(i, s, j);
        if(k != 0) {
            AssetInputStream assetinputstream = new AssetInputStream(k);
            incRefsLocked(assetinputstream.hashCode());
            return assetinputstream;
        }
        this;
        JVM INSTR monitorexit ;
        throw new FileNotFoundException((new StringBuilder()).append("Asset absolute file: ").append(s).toString());
    }

    public final InputStream openNonAsset(String s) throws IOException {
        return openNonAsset(0, s, 2);
    }

    public final InputStream openNonAsset(String s, int i) throws IOException {
        return openNonAsset(0, s, i);
    }

    public final AssetFileDescriptor openNonAssetFd(int i, String s) throws IOException {
        this;
        JVM INSTR monitorenter ;
        if(!mOpen)
            throw new RuntimeException("Assetmanager has been closed");
        break MISSING_BLOCK_LABEL_24;
        Exception exception;
        exception;
        throw exception;
        ParcelFileDescriptor parcelfiledescriptor = openNonAssetFdNative(i, s, mOffsets);
        if(parcelfiledescriptor != null) {
            AssetFileDescriptor assetfiledescriptor = new AssetFileDescriptor(parcelfiledescriptor, mOffsets[0], mOffsets[1]);
            return assetfiledescriptor;
        }
        this;
        JVM INSTR monitorexit ;
        throw new FileNotFoundException((new StringBuilder()).append("Asset absolute file: ").append(s).toString());
    }

    public final AssetFileDescriptor openNonAssetFd(String s) throws IOException {
        return openNonAssetFd(0, s);
    }

    final XmlBlock openXmlBlockAsset(int i, String s) throws IOException {
        this;
        JVM INSTR monitorenter ;
        if(!mOpen)
            throw new RuntimeException("Assetmanager has been closed");
        break MISSING_BLOCK_LABEL_24;
        Exception exception;
        exception;
        throw exception;
        int j = openXmlAssetNative(i, s);
        if(j != 0) {
            XmlBlock xmlblock = new XmlBlock(this, j);
            incRefsLocked(xmlblock.hashCode());
            return xmlblock;
        }
        this;
        JVM INSTR monitorexit ;
        throw new FileNotFoundException((new StringBuilder()).append("Asset XML file: ").append(s).toString());
    }

    final XmlBlock openXmlBlockAsset(String s) throws IOException {
        return openXmlBlockAsset(0, s);
    }

    public final XmlResourceParser openXmlResourceParser(int i, String s) throws IOException {
        XmlBlock xmlblock = openXmlBlockAsset(i, s);
        XmlResourceParser xmlresourceparser = xmlblock.newParser();
        xmlblock.close();
        return xmlresourceparser;
    }

    public final XmlResourceParser openXmlResourceParser(String s) throws IOException {
        return openXmlResourceParser(0, s);
    }

    final void releaseTheme(int i) {
        this;
        JVM INSTR monitorenter ;
        deleteTheme(i);
        decRefsLocked(i);
        return;
    }

    final native int retrieveArray(int i, int ai[]);

    final native boolean retrieveAttributes(int i, int ai[], int ai1[], int ai2[]);

    public final native void setConfiguration(int i, int j, String s, int k, int l, int i1, int j1, 
            int k1, int l1, int i2, int j2, int k2, int l2, int i3, 
            int j3, int k3, int l3);

    public final native void setLocale(String s);

    void xmlBlockGone(int i) {
        this;
        JVM INSTR monitorenter ;
        decRefsLocked(i);
        return;
    }

    public static final int ACCESS_BUFFER = 3;
    public static final int ACCESS_RANDOM = 1;
    public static final int ACCESS_STREAMING = 2;
    public static final int ACCESS_UNKNOWN = 0;
    private static final boolean DEBUG_REFS = false;
    static final int STYLE_ASSET_COOKIE = 2;
    static final int STYLE_CHANGING_CONFIGURATIONS = 4;
    static final int STYLE_DATA = 1;
    static final int STYLE_DENSITY = 5;
    static final int STYLE_NUM_ENTRIES = 6;
    static final int STYLE_RESOURCE_ID = 3;
    static final int STYLE_TYPE = 0;
    private static final String TAG = "AssetManager";
    private static final boolean localLOGV;
    private static final Object sSync = new Object();
    static AssetManager sSystem = null;
    private int mNObject;
    private int mNumRefs;
    private int mObject;
    private final long mOffsets[];
    private boolean mOpen;
    private HashMap mRefStacks;
    private StringBlock mStringBlocks[];
    private final TypedValue mValue;








}
