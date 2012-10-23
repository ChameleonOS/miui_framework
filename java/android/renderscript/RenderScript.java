// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.renderscript;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import java.io.File;

// Referenced classes of package android.renderscript:
//            RSRuntimeException, RSDriverException, BaseObj, RSInvalidStateException, 
//            Element, ProgramRaster, ProgramStore, Sampler

public class RenderScript {
    static class MessageThread extends Thread {

        public void run() {
            int ai[] = new int[16];
            mRS.nContextInitToClient(mRS.mContext);
            do {
                if(!mRun)
                    break;
                ai[0] = 0;
                int i = mRS.nContextPeekMessage(mRS.mContext, mAuxData);
                int j = mAuxData[1];
                int k = mAuxData[0];
                if(i == 4) {
                    if(j >> 2 >= ai.length)
                        ai = new int[j + 3 >> 2];
                    if(mRS.nContextGetUserMessage(mRS.mContext, ai) != 4)
                        throw new RSDriverException("Error processing message from Renderscript.");
                    if(mRS.mMessageCallback != null) {
                        mRS.mMessageCallback.mData = ai;
                        mRS.mMessageCallback.mID = k;
                        mRS.mMessageCallback.mLength = j;
                        mRS.mMessageCallback.run();
                    } else {
                        throw new RSInvalidStateException("Received a message from the script with no message handler installed.");
                    }
                } else
                if(i == 3) {
                    String s = mRS.nContextGetErrorMessage(mRS.mContext);
                    if(k >= 4096)
                        throw new RSRuntimeException((new StringBuilder()).append("Fatal error ").append(k).append(", details: ").append(s).toString());
                    if(mRS.mErrorCallback != null) {
                        mRS.mErrorCallback.mErrorMessage = s;
                        mRS.mErrorCallback.mErrorNum = k;
                        mRS.mErrorCallback.run();
                    }
                } else {
                    try {
                        sleep(1L, 0);
                    }
                    catch(InterruptedException interruptedexception) { }
                }
            } while(true);
            Log.d("RenderScript_jni", "MessageThread exiting.");
        }

        static final int RS_ERROR_FATAL_UNKNOWN = 4096;
        static final int RS_MESSAGE_TO_CLIENT_ERROR = 3;
        static final int RS_MESSAGE_TO_CLIENT_EXCEPTION = 1;
        static final int RS_MESSAGE_TO_CLIENT_NONE = 0;
        static final int RS_MESSAGE_TO_CLIENT_RESIZE = 2;
        static final int RS_MESSAGE_TO_CLIENT_USER = 4;
        int mAuxData[];
        RenderScript mRS;
        boolean mRun;

        MessageThread(RenderScript renderscript) {
            super("RSMessageThread");
            mRun = true;
            mAuxData = new int[2];
            mRS = renderscript;
        }
    }

    public static final class Priority extends Enum {

        public static Priority valueOf(String s) {
            return (Priority)Enum.valueOf(android/renderscript/RenderScript$Priority, s);
        }

        public static Priority[] values() {
            return (Priority[])$VALUES.clone();
        }

        private static final Priority $VALUES[];
        public static final Priority LOW;
        public static final Priority NORMAL;
        int mID;

        static  {
            LOW = new Priority("LOW", 0, 15);
            NORMAL = new Priority("NORMAL", 1, -4);
            Priority apriority[] = new Priority[2];
            apriority[0] = LOW;
            apriority[1] = NORMAL;
            $VALUES = apriority;
        }

        private Priority(String s, int i, int j) {
            super(s, i);
            mID = j;
        }
    }

    public static class RSErrorHandler
        implements Runnable {

        public void run() {
        }

        protected String mErrorMessage;
        protected int mErrorNum;

        public RSErrorHandler() {
        }
    }

    public static class RSMessageHandler
        implements Runnable {

        public void run() {
        }

        protected int mData[];
        protected int mID;
        protected int mLength;

        public RSMessageHandler() {
        }
    }


    RenderScript(Context context) {
        mMessageCallback = null;
        mErrorCallback = null;
        if(context != null)
            mApplicationContext = context.getApplicationContext();
    }

    static native void _nInit();

    public static RenderScript create(Context context) {
        return create(context, context.getApplicationInfo().targetSdkVersion);
    }

    public static RenderScript create(Context context, int i) {
        RenderScript renderscript = new RenderScript(context);
        renderscript.mDev = renderscript.nDeviceCreate();
        renderscript.mContext = renderscript.nContextCreate(renderscript.mDev, 0, i);
        if(renderscript.mContext == 0) {
            throw new RSDriverException("Failed to create RS context.");
        } else {
            renderscript.mMessageThread = new MessageThread(renderscript);
            renderscript.mMessageThread.start();
            return renderscript;
        }
    }

    public static void setupDiskCache(File file) {
        File file1 = new File(file, "com.android.renderscript.cache");
        mCachePath = file1.getAbsolutePath();
        file1.mkdirs();
    }

    public void contextDump() {
        validate();
        nContextDump(0);
    }

    public void destroy() {
        validate();
        nContextDeinitToClient(mContext);
        mMessageThread.mRun = false;
        try {
            mMessageThread.join();
        }
        catch(InterruptedException interruptedexception) { }
        nContextDestroy();
        mContext = 0;
        nDeviceDestroy(mDev);
        mDev = 0;
    }

    public void finish() {
        nContextFinish();
    }

    public final Context getApplicationContext() {
        return mApplicationContext;
    }

    public RSErrorHandler getErrorHandler() {
        return mErrorCallback;
    }

    public RSMessageHandler getMessageHandler() {
        return mMessageCallback;
    }

    boolean isAlive() {
        boolean flag;
        if(mContext != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    /**
     * @deprecated Method nAllocationCopyFromBitmap is deprecated
     */

    void nAllocationCopyFromBitmap(int i, Bitmap bitmap) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnAllocationCopyFromBitmap(mContext, i, bitmap);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nAllocationCopyToBitmap is deprecated
     */

    void nAllocationCopyToBitmap(int i, Bitmap bitmap) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnAllocationCopyToBitmap(mContext, i, bitmap);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nAllocationCreateBitmapRef is deprecated
     */

    int nAllocationCreateBitmapRef(int i, Bitmap bitmap) {
        this;
        JVM INSTR monitorenter ;
        int j;
        validate();
        j = rsnAllocationCreateBitmapRef(mContext, i, bitmap);
        this;
        JVM INSTR monitorexit ;
        return j;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nAllocationCreateFromAssetStream is deprecated
     */

    int nAllocationCreateFromAssetStream(int i, int j, int k) {
        this;
        JVM INSTR monitorenter ;
        int l;
        validate();
        l = rsnAllocationCreateFromAssetStream(mContext, i, j, k);
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nAllocationCreateFromBitmap is deprecated
     */

    int nAllocationCreateFromBitmap(int i, int j, Bitmap bitmap, int k) {
        this;
        JVM INSTR monitorenter ;
        int l;
        validate();
        l = rsnAllocationCreateFromBitmap(mContext, i, j, bitmap, k);
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nAllocationCreateTyped is deprecated
     */

    int nAllocationCreateTyped(int i, int j, int k, int l) {
        this;
        JVM INSTR monitorenter ;
        int i1;
        validate();
        i1 = rsnAllocationCreateTyped(mContext, i, j, k, l);
        this;
        JVM INSTR monitorexit ;
        return i1;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nAllocationCubeCreateFromBitmap is deprecated
     */

    int nAllocationCubeCreateFromBitmap(int i, int j, Bitmap bitmap, int k) {
        this;
        JVM INSTR monitorenter ;
        int l;
        validate();
        l = rsnAllocationCubeCreateFromBitmap(mContext, i, j, bitmap, k);
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nAllocationData1D is deprecated
     */

    void nAllocationData1D(int i, int j, int k, int l, byte abyte0[], int i1) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnAllocationData1D(mContext, i, j, k, l, abyte0, i1);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nAllocationData1D is deprecated
     */

    void nAllocationData1D(int i, int j, int k, int l, float af[], int i1) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnAllocationData1D(mContext, i, j, k, l, af, i1);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nAllocationData1D is deprecated
     */

    void nAllocationData1D(int i, int j, int k, int l, int ai[], int i1) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnAllocationData1D(mContext, i, j, k, l, ai, i1);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nAllocationData1D is deprecated
     */

    void nAllocationData1D(int i, int j, int k, int l, short aword0[], int i1) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnAllocationData1D(mContext, i, j, k, l, aword0, i1);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nAllocationData2D is deprecated
     */

    void nAllocationData2D(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, int i2, int j2, int k2, int l2) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnAllocationData2D(mContext, i, j, k, l, i1, j1, k1, l1, i2, j2, k2, l2);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nAllocationData2D is deprecated
     */

    void nAllocationData2D(int i, int j, int k, int l, int i1, int j1, int k1, 
            byte abyte0[], int l1) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnAllocationData2D(mContext, i, j, k, l, i1, j1, k1, abyte0, l1);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nAllocationData2D is deprecated
     */

    void nAllocationData2D(int i, int j, int k, int l, int i1, int j1, int k1, 
            float af[], int l1) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnAllocationData2D(mContext, i, j, k, l, i1, j1, k1, af, l1);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nAllocationData2D is deprecated
     */

    void nAllocationData2D(int i, int j, int k, int l, int i1, int j1, int k1, 
            int ai[], int l1) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnAllocationData2D(mContext, i, j, k, l, i1, j1, k1, ai, l1);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nAllocationData2D is deprecated
     */

    void nAllocationData2D(int i, int j, int k, int l, int i1, int j1, int k1, 
            short aword0[], int l1) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnAllocationData2D(mContext, i, j, k, l, i1, j1, k1, aword0, l1);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nAllocationData2D is deprecated
     */

    void nAllocationData2D(int i, int j, int k, int l, int i1, Bitmap bitmap) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnAllocationData2D(mContext, i, j, k, l, i1, bitmap);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nAllocationElementData1D is deprecated
     */

    void nAllocationElementData1D(int i, int j, int k, int l, byte abyte0[], int i1) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnAllocationElementData1D(mContext, i, j, k, l, abyte0, i1);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nAllocationGenerateMipmaps is deprecated
     */

    void nAllocationGenerateMipmaps(int i) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnAllocationGenerateMipmaps(mContext, i);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nAllocationGetSurfaceTextureID is deprecated
     */

    int nAllocationGetSurfaceTextureID(int i) {
        this;
        JVM INSTR monitorenter ;
        int j;
        validate();
        j = rsnAllocationGetSurfaceTextureID(mContext, i);
        this;
        JVM INSTR monitorexit ;
        return j;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nAllocationGetSurfaceTextureID2 is deprecated
     */

    void nAllocationGetSurfaceTextureID2(int i, SurfaceTexture surfacetexture) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnAllocationGetSurfaceTextureID2(mContext, i, surfacetexture);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nAllocationGetType is deprecated
     */

    int nAllocationGetType(int i) {
        this;
        JVM INSTR monitorenter ;
        int j;
        validate();
        j = rsnAllocationGetType(mContext, i);
        this;
        JVM INSTR monitorexit ;
        return j;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nAllocationIoReceive is deprecated
     */

    void nAllocationIoReceive(int i) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnAllocationIoReceive(mContext, i);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nAllocationIoSend is deprecated
     */

    void nAllocationIoSend(int i) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnAllocationIoSend(mContext, i);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nAllocationRead is deprecated
     */

    void nAllocationRead(int i, byte abyte0[]) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnAllocationRead(mContext, i, abyte0);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nAllocationRead is deprecated
     */

    void nAllocationRead(int i, float af[]) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnAllocationRead(mContext, i, af);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nAllocationRead is deprecated
     */

    void nAllocationRead(int i, int ai[]) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnAllocationRead(mContext, i, ai);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nAllocationRead is deprecated
     */

    void nAllocationRead(int i, short aword0[]) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnAllocationRead(mContext, i, aword0);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nAllocationResize1D is deprecated
     */

    void nAllocationResize1D(int i, int j) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnAllocationResize1D(mContext, i, j);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nAllocationResize2D is deprecated
     */

    void nAllocationResize2D(int i, int j, int k) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnAllocationResize2D(mContext, i, j, k);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nAllocationSetSurface is deprecated
     */

    void nAllocationSetSurface(int i, Surface surface) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnAllocationSetSurface(mContext, i, surface);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nAllocationSyncAll is deprecated
     */

    void nAllocationSyncAll(int i, int j) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnAllocationSyncAll(mContext, i, j);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nAssignName is deprecated
     */

    void nAssignName(int i, byte abyte0[]) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnAssignName(mContext, i, abyte0);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nContextBindProgramFragment is deprecated
     */

    void nContextBindProgramFragment(int i) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnContextBindProgramFragment(mContext, i);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nContextBindProgramRaster is deprecated
     */

    void nContextBindProgramRaster(int i) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnContextBindProgramRaster(mContext, i);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nContextBindProgramStore is deprecated
     */

    void nContextBindProgramStore(int i) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnContextBindProgramStore(mContext, i);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nContextBindProgramVertex is deprecated
     */

    void nContextBindProgramVertex(int i) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnContextBindProgramVertex(mContext, i);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nContextBindRootScript is deprecated
     */

    void nContextBindRootScript(int i) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnContextBindRootScript(mContext, i);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nContextBindSampler is deprecated
     */

    void nContextBindSampler(int i, int j) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnContextBindSampler(mContext, i, j);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nContextCreate is deprecated
     */

    int nContextCreate(int i, int j, int k) {
        this;
        JVM INSTR monitorenter ;
        int l = rsnContextCreate(i, j, k);
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nContextCreateGL is deprecated
     */

    int nContextCreateGL(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, int i2, int j2, int k2, int l2, int i3, float f, 
            int j3) {
        this;
        JVM INSTR monitorenter ;
        int k3 = rsnContextCreateGL(i, j, k, l, i1, j1, k1, l1, i2, j2, k2, l2, i3, f, j3);
        this;
        JVM INSTR monitorexit ;
        return k3;
        Exception exception;
        exception;
        throw exception;
    }

    native void nContextDeinitToClient(int i);

    /**
     * @deprecated Method nContextDestroy is deprecated
     */

    void nContextDestroy() {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnContextDestroy(mContext);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nContextDump is deprecated
     */

    void nContextDump(int i) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnContextDump(mContext, i);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nContextFinish is deprecated
     */

    void nContextFinish() {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnContextFinish(mContext);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    native String nContextGetErrorMessage(int i);

    native int nContextGetUserMessage(int i, int ai[]);

    native void nContextInitToClient(int i);

    /**
     * @deprecated Method nContextPause is deprecated
     */

    void nContextPause() {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnContextPause(mContext);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    native int nContextPeekMessage(int i, int ai[]);

    /**
     * @deprecated Method nContextResume is deprecated
     */

    void nContextResume() {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnContextResume(mContext);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nContextSetPriority is deprecated
     */

    void nContextSetPriority(int i) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnContextSetPriority(mContext, i);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nContextSetSurface is deprecated
     */

    void nContextSetSurface(int i, int j, Surface surface) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnContextSetSurface(mContext, i, j, surface);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nContextSetSurfaceTexture is deprecated
     */

    void nContextSetSurfaceTexture(int i, int j, SurfaceTexture surfacetexture) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnContextSetSurfaceTexture(mContext, i, j, surfacetexture);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    native int nDeviceCreate();

    native void nDeviceDestroy(int i);

    native void nDeviceSetConfig(int i, int j, int k);

    /**
     * @deprecated Method nElementCreate is deprecated
     */

    int nElementCreate(int i, int j, boolean flag, int k) {
        this;
        JVM INSTR monitorenter ;
        int l;
        validate();
        l = rsnElementCreate(mContext, i, j, flag, k);
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nElementCreate2 is deprecated
     */

    int nElementCreate2(int ai[], String as[], int ai1[]) {
        this;
        JVM INSTR monitorenter ;
        int i;
        validate();
        i = rsnElementCreate2(mContext, ai, as, ai1);
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nElementGetNativeData is deprecated
     */

    void nElementGetNativeData(int i, int ai[]) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnElementGetNativeData(mContext, i, ai);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nElementGetSubElements is deprecated
     */

    void nElementGetSubElements(int i, int ai[], String as[], int ai1[]) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnElementGetSubElements(mContext, i, ai, as, ai1);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nFileA3DCreateFromAsset is deprecated
     */

    int nFileA3DCreateFromAsset(AssetManager assetmanager, String s) {
        this;
        JVM INSTR monitorenter ;
        int i;
        validate();
        i = rsnFileA3DCreateFromAsset(mContext, assetmanager, s);
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nFileA3DCreateFromAssetStream is deprecated
     */

    int nFileA3DCreateFromAssetStream(int i) {
        this;
        JVM INSTR monitorenter ;
        int j;
        validate();
        j = rsnFileA3DCreateFromAssetStream(mContext, i);
        this;
        JVM INSTR monitorexit ;
        return j;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nFileA3DCreateFromFile is deprecated
     */

    int nFileA3DCreateFromFile(String s) {
        this;
        JVM INSTR monitorenter ;
        int i;
        validate();
        i = rsnFileA3DCreateFromFile(mContext, s);
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nFileA3DGetEntryByIndex is deprecated
     */

    int nFileA3DGetEntryByIndex(int i, int j) {
        this;
        JVM INSTR monitorenter ;
        int k;
        validate();
        k = rsnFileA3DGetEntryByIndex(mContext, i, j);
        this;
        JVM INSTR monitorexit ;
        return k;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nFileA3DGetIndexEntries is deprecated
     */

    void nFileA3DGetIndexEntries(int i, int j, int ai[], String as[]) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnFileA3DGetIndexEntries(mContext, i, j, ai, as);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nFileA3DGetNumIndexEntries is deprecated
     */

    int nFileA3DGetNumIndexEntries(int i) {
        this;
        JVM INSTR monitorenter ;
        int j;
        validate();
        j = rsnFileA3DGetNumIndexEntries(mContext, i);
        this;
        JVM INSTR monitorexit ;
        return j;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nFontCreateFromAsset is deprecated
     */

    int nFontCreateFromAsset(AssetManager assetmanager, String s, float f, int i) {
        this;
        JVM INSTR monitorenter ;
        int j;
        validate();
        j = rsnFontCreateFromAsset(mContext, assetmanager, s, f, i);
        this;
        JVM INSTR monitorexit ;
        return j;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nFontCreateFromAssetStream is deprecated
     */

    int nFontCreateFromAssetStream(String s, float f, int i, int j) {
        this;
        JVM INSTR monitorenter ;
        int k;
        validate();
        k = rsnFontCreateFromAssetStream(mContext, s, f, i, j);
        this;
        JVM INSTR monitorexit ;
        return k;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nFontCreateFromFile is deprecated
     */

    int nFontCreateFromFile(String s, float f, int i) {
        this;
        JVM INSTR monitorenter ;
        int j;
        validate();
        j = rsnFontCreateFromFile(mContext, s, f, i);
        this;
        JVM INSTR monitorexit ;
        return j;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nGetName is deprecated
     */

    String nGetName(int i) {
        this;
        JVM INSTR monitorenter ;
        String s;
        validate();
        s = rsnGetName(mContext, i);
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nMeshCreate is deprecated
     */

    int nMeshCreate(int ai[], int ai1[], int ai2[]) {
        this;
        JVM INSTR monitorenter ;
        int i;
        validate();
        i = rsnMeshCreate(mContext, ai, ai1, ai2);
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nMeshGetIndexCount is deprecated
     */

    int nMeshGetIndexCount(int i) {
        this;
        JVM INSTR monitorenter ;
        int j;
        validate();
        j = rsnMeshGetIndexCount(mContext, i);
        this;
        JVM INSTR monitorexit ;
        return j;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nMeshGetIndices is deprecated
     */

    void nMeshGetIndices(int i, int ai[], int ai1[], int j) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnMeshGetIndices(mContext, i, ai, ai1, j);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nMeshGetVertexBufferCount is deprecated
     */

    int nMeshGetVertexBufferCount(int i) {
        this;
        JVM INSTR monitorenter ;
        int j;
        validate();
        j = rsnMeshGetVertexBufferCount(mContext, i);
        this;
        JVM INSTR monitorexit ;
        return j;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nMeshGetVertices is deprecated
     */

    void nMeshGetVertices(int i, int ai[], int j) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnMeshGetVertices(mContext, i, ai, j);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nObjDestroy is deprecated
     */

    void nObjDestroy(int i) {
        this;
        JVM INSTR monitorenter ;
        if(mContext != 0)
            rsnObjDestroy(mContext, i);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nPathCreate is deprecated
     */

    int nPathCreate(int i, boolean flag, int j, int k, float f) {
        this;
        JVM INSTR monitorenter ;
        int l;
        validate();
        l = rsnPathCreate(mContext, i, flag, j, k, f);
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nProgramBindConstants is deprecated
     */

    void nProgramBindConstants(int i, int j, int k) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnProgramBindConstants(mContext, i, j, k);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nProgramBindSampler is deprecated
     */

    void nProgramBindSampler(int i, int j, int k) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnProgramBindSampler(mContext, i, j, k);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nProgramBindTexture is deprecated
     */

    void nProgramBindTexture(int i, int j, int k) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnProgramBindTexture(mContext, i, j, k);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nProgramFragmentCreate is deprecated
     */

    int nProgramFragmentCreate(String s, String as[], int ai[]) {
        this;
        JVM INSTR monitorenter ;
        int i;
        validate();
        i = rsnProgramFragmentCreate(mContext, s, as, ai);
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nProgramRasterCreate is deprecated
     */

    int nProgramRasterCreate(boolean flag, int i) {
        this;
        JVM INSTR monitorenter ;
        int j;
        validate();
        j = rsnProgramRasterCreate(mContext, flag, i);
        this;
        JVM INSTR monitorexit ;
        return j;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nProgramStoreCreate is deprecated
     */

    int nProgramStoreCreate(boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4, boolean flag5, int i, 
            int j, int k) {
        this;
        JVM INSTR monitorenter ;
        int l;
        validate();
        l = rsnProgramStoreCreate(mContext, flag, flag1, flag2, flag3, flag4, flag5, i, j, k);
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nProgramVertexCreate is deprecated
     */

    int nProgramVertexCreate(String s, String as[], int ai[]) {
        this;
        JVM INSTR monitorenter ;
        int i;
        validate();
        i = rsnProgramVertexCreate(mContext, s, as, ai);
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nSamplerCreate is deprecated
     */

    int nSamplerCreate(int i, int j, int k, int l, int i1, float f) {
        this;
        JVM INSTR monitorenter ;
        int j1;
        validate();
        j1 = rsnSamplerCreate(mContext, i, j, k, l, i1, f);
        this;
        JVM INSTR monitorexit ;
        return j1;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nScriptBindAllocation is deprecated
     */

    void nScriptBindAllocation(int i, int j, int k) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnScriptBindAllocation(mContext, i, j, k);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nScriptCCreate is deprecated
     */

    int nScriptCCreate(String s, String s1, byte abyte0[], int i) {
        this;
        JVM INSTR monitorenter ;
        int j;
        validate();
        j = rsnScriptCCreate(mContext, s, s1, abyte0, i);
        this;
        JVM INSTR monitorexit ;
        return j;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nScriptForEach is deprecated
     */

    void nScriptForEach(int i, int j, int k, int l, byte abyte0[]) {
        this;
        JVM INSTR monitorenter ;
        validate();
        if(abyte0 != null) goto _L2; else goto _L1
_L1:
        rsnScriptForEach(mContext, i, j, k, l);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        rsnScriptForEach(mContext, i, j, k, l, abyte0);
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nScriptInvoke is deprecated
     */

    void nScriptInvoke(int i, int j) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnScriptInvoke(mContext, i, j);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nScriptInvokeV is deprecated
     */

    void nScriptInvokeV(int i, int j, byte abyte0[]) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnScriptInvokeV(mContext, i, j, abyte0);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nScriptSetTimeZone is deprecated
     */

    void nScriptSetTimeZone(int i, byte abyte0[]) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnScriptSetTimeZone(mContext, i, abyte0);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nScriptSetVarD is deprecated
     */

    void nScriptSetVarD(int i, int j, double d) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnScriptSetVarD(mContext, i, j, d);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nScriptSetVarF is deprecated
     */

    void nScriptSetVarF(int i, int j, float f) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnScriptSetVarF(mContext, i, j, f);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nScriptSetVarI is deprecated
     */

    void nScriptSetVarI(int i, int j, int k) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnScriptSetVarI(mContext, i, j, k);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nScriptSetVarJ is deprecated
     */

    void nScriptSetVarJ(int i, int j, long l) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnScriptSetVarJ(mContext, i, j, l);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nScriptSetVarObj is deprecated
     */

    void nScriptSetVarObj(int i, int j, int k) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnScriptSetVarObj(mContext, i, j, k);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nScriptSetVarV is deprecated
     */

    void nScriptSetVarV(int i, int j, byte abyte0[]) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnScriptSetVarV(mContext, i, j, abyte0);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nScriptSetVarVE is deprecated
     */

    void nScriptSetVarVE(int i, int j, byte abyte0[], int k, int ai[]) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnScriptSetVarVE(mContext, i, j, abyte0, k, ai);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nTypeCreate is deprecated
     */

    int nTypeCreate(int i, int j, int k, int l, boolean flag, boolean flag1) {
        this;
        JVM INSTR monitorenter ;
        int i1;
        validate();
        i1 = rsnTypeCreate(mContext, i, j, k, l, flag, flag1);
        this;
        JVM INSTR monitorexit ;
        return i1;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method nTypeGetNativeData is deprecated
     */

    void nTypeGetNativeData(int i, int ai[]) {
        this;
        JVM INSTR monitorenter ;
        validate();
        rsnTypeGetNativeData(mContext, i, ai);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    native void rsnAllocationCopyFromBitmap(int i, int j, Bitmap bitmap);

    native void rsnAllocationCopyToBitmap(int i, int j, Bitmap bitmap);

    native int rsnAllocationCreateBitmapRef(int i, int j, Bitmap bitmap);

    native int rsnAllocationCreateFromAssetStream(int i, int j, int k, int l);

    native int rsnAllocationCreateFromBitmap(int i, int j, int k, Bitmap bitmap, int l);

    native int rsnAllocationCreateTyped(int i, int j, int k, int l, int i1);

    native int rsnAllocationCubeCreateFromBitmap(int i, int j, int k, Bitmap bitmap, int l);

    native void rsnAllocationData1D(int i, int j, int k, int l, int i1, byte abyte0[], int j1);

    native void rsnAllocationData1D(int i, int j, int k, int l, int i1, float af[], int j1);

    native void rsnAllocationData1D(int i, int j, int k, int l, int i1, int ai[], int j1);

    native void rsnAllocationData1D(int i, int j, int k, int l, int i1, short aword0[], int j1);

    native void rsnAllocationData2D(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, int i2, int j2, int k2, int l2, int i3);

    native void rsnAllocationData2D(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, byte abyte0[], int i2);

    native void rsnAllocationData2D(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, float af[], int i2);

    native void rsnAllocationData2D(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, int ai[], int i2);

    native void rsnAllocationData2D(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, short aword0[], int i2);

    native void rsnAllocationData2D(int i, int j, int k, int l, int i1, int j1, Bitmap bitmap);

    native void rsnAllocationElementData1D(int i, int j, int k, int l, int i1, byte abyte0[], int j1);

    native void rsnAllocationGenerateMipmaps(int i, int j);

    native int rsnAllocationGetSurfaceTextureID(int i, int j);

    native void rsnAllocationGetSurfaceTextureID2(int i, int j, SurfaceTexture surfacetexture);

    native int rsnAllocationGetType(int i, int j);

    native void rsnAllocationIoReceive(int i, int j);

    native void rsnAllocationIoSend(int i, int j);

    native void rsnAllocationRead(int i, int j, byte abyte0[]);

    native void rsnAllocationRead(int i, int j, float af[]);

    native void rsnAllocationRead(int i, int j, int ai[]);

    native void rsnAllocationRead(int i, int j, short aword0[]);

    native void rsnAllocationResize1D(int i, int j, int k);

    native void rsnAllocationResize2D(int i, int j, int k, int l);

    native void rsnAllocationSetSurface(int i, int j, Surface surface);

    native void rsnAllocationSyncAll(int i, int j, int k);

    native void rsnAssignName(int i, int j, byte abyte0[]);

    native void rsnContextBindProgramFragment(int i, int j);

    native void rsnContextBindProgramRaster(int i, int j);

    native void rsnContextBindProgramStore(int i, int j);

    native void rsnContextBindProgramVertex(int i, int j);

    native void rsnContextBindRootScript(int i, int j);

    native void rsnContextBindSampler(int i, int j, int k);

    native int rsnContextCreate(int i, int j, int k);

    native int rsnContextCreateGL(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, int i2, int j2, int k2, int l2, int i3, float f, 
            int j3);

    native void rsnContextDestroy(int i);

    native void rsnContextDump(int i, int j);

    native void rsnContextFinish(int i);

    native void rsnContextPause(int i);

    native void rsnContextResume(int i);

    native void rsnContextSetPriority(int i, int j);

    native void rsnContextSetSurface(int i, int j, int k, Surface surface);

    native void rsnContextSetSurfaceTexture(int i, int j, int k, SurfaceTexture surfacetexture);

    native int rsnElementCreate(int i, int j, int k, boolean flag, int l);

    native int rsnElementCreate2(int i, int ai[], String as[], int ai1[]);

    native void rsnElementGetNativeData(int i, int j, int ai[]);

    native void rsnElementGetSubElements(int i, int j, int ai[], String as[], int ai1[]);

    native int rsnFileA3DCreateFromAsset(int i, AssetManager assetmanager, String s);

    native int rsnFileA3DCreateFromAssetStream(int i, int j);

    native int rsnFileA3DCreateFromFile(int i, String s);

    native int rsnFileA3DGetEntryByIndex(int i, int j, int k);

    native void rsnFileA3DGetIndexEntries(int i, int j, int k, int ai[], String as[]);

    native int rsnFileA3DGetNumIndexEntries(int i, int j);

    native int rsnFontCreateFromAsset(int i, AssetManager assetmanager, String s, float f, int j);

    native int rsnFontCreateFromAssetStream(int i, String s, float f, int j, int k);

    native int rsnFontCreateFromFile(int i, String s, float f, int j);

    native String rsnGetName(int i, int j);

    native int rsnMeshCreate(int i, int ai[], int ai1[], int ai2[]);

    native int rsnMeshGetIndexCount(int i, int j);

    native void rsnMeshGetIndices(int i, int j, int ai[], int ai1[], int k);

    native int rsnMeshGetVertexBufferCount(int i, int j);

    native void rsnMeshGetVertices(int i, int j, int ai[], int k);

    native void rsnObjDestroy(int i, int j);

    native int rsnPathCreate(int i, int j, boolean flag, int k, int l, float f);

    native void rsnProgramBindConstants(int i, int j, int k, int l);

    native void rsnProgramBindSampler(int i, int j, int k, int l);

    native void rsnProgramBindTexture(int i, int j, int k, int l);

    native int rsnProgramFragmentCreate(int i, String s, String as[], int ai[]);

    native int rsnProgramRasterCreate(int i, boolean flag, int j);

    native int rsnProgramStoreCreate(int i, boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4, boolean flag5, 
            int j, int k, int l);

    native int rsnProgramVertexCreate(int i, String s, String as[], int ai[]);

    native int rsnSamplerCreate(int i, int j, int k, int l, int i1, int j1, float f);

    native void rsnScriptBindAllocation(int i, int j, int k, int l);

    native int rsnScriptCCreate(int i, String s, String s1, byte abyte0[], int j);

    native void rsnScriptForEach(int i, int j, int k, int l, int i1);

    native void rsnScriptForEach(int i, int j, int k, int l, int i1, byte abyte0[]);

    native void rsnScriptInvoke(int i, int j, int k);

    native void rsnScriptInvokeV(int i, int j, int k, byte abyte0[]);

    native void rsnScriptSetTimeZone(int i, int j, byte abyte0[]);

    native void rsnScriptSetVarD(int i, int j, int k, double d);

    native void rsnScriptSetVarF(int i, int j, int k, float f);

    native void rsnScriptSetVarI(int i, int j, int k, int l);

    native void rsnScriptSetVarJ(int i, int j, int k, long l);

    native void rsnScriptSetVarObj(int i, int j, int k, int l);

    native void rsnScriptSetVarV(int i, int j, int k, byte abyte0[]);

    native void rsnScriptSetVarVE(int i, int j, int k, byte abyte0[], int l, int ai[]);

    native int rsnTypeCreate(int i, int j, int k, int l, int i1, boolean flag, boolean flag1);

    native void rsnTypeGetNativeData(int i, int j, int ai[]);

    int safeID(BaseObj baseobj) {
        int i;
        if(baseobj != null)
            i = baseobj.getID(this);
        else
            i = 0;
        return i;
    }

    public void setErrorHandler(RSErrorHandler rserrorhandler) {
        mErrorCallback = rserrorhandler;
    }

    public void setMessageHandler(RSMessageHandler rsmessagehandler) {
        mMessageCallback = rsmessagehandler;
    }

    public void setPriority(Priority priority) {
        validate();
        nContextSetPriority(priority.mID);
    }

    void validate() {
        if(mContext == 0)
            throw new RSInvalidStateException("Calling RS with no Context active.");
        else
            return;
    }

    private static final String CACHE_PATH = "com.android.renderscript.cache";
    static final boolean DEBUG = false;
    static final boolean LOG_ENABLED = false;
    static final String LOG_TAG = "RenderScript_jni";
    static String mCachePath;
    static boolean sInitialized = false;
    private Context mApplicationContext;
    int mContext;
    int mDev;
    Element mElement_ALLOCATION;
    Element mElement_A_8;
    Element mElement_BOOLEAN;
    Element mElement_CHAR_2;
    Element mElement_CHAR_3;
    Element mElement_CHAR_4;
    Element mElement_DOUBLE_2;
    Element mElement_DOUBLE_3;
    Element mElement_DOUBLE_4;
    Element mElement_ELEMENT;
    Element mElement_F32;
    Element mElement_F64;
    Element mElement_FLOAT_2;
    Element mElement_FLOAT_3;
    Element mElement_FLOAT_4;
    Element mElement_FONT;
    Element mElement_I16;
    Element mElement_I32;
    Element mElement_I64;
    Element mElement_I8;
    Element mElement_INT_2;
    Element mElement_INT_3;
    Element mElement_INT_4;
    Element mElement_LONG_2;
    Element mElement_LONG_3;
    Element mElement_LONG_4;
    Element mElement_MATRIX_2X2;
    Element mElement_MATRIX_3X3;
    Element mElement_MATRIX_4X4;
    Element mElement_MESH;
    Element mElement_PROGRAM_FRAGMENT;
    Element mElement_PROGRAM_RASTER;
    Element mElement_PROGRAM_STORE;
    Element mElement_PROGRAM_VERTEX;
    Element mElement_RGBA_4444;
    Element mElement_RGBA_5551;
    Element mElement_RGBA_8888;
    Element mElement_RGB_565;
    Element mElement_RGB_888;
    Element mElement_SAMPLER;
    Element mElement_SCRIPT;
    Element mElement_SHORT_2;
    Element mElement_SHORT_3;
    Element mElement_SHORT_4;
    Element mElement_TYPE;
    Element mElement_U16;
    Element mElement_U32;
    Element mElement_U64;
    Element mElement_U8;
    Element mElement_UCHAR_2;
    Element mElement_UCHAR_3;
    Element mElement_UCHAR_4;
    Element mElement_UINT_2;
    Element mElement_UINT_3;
    Element mElement_UINT_4;
    Element mElement_ULONG_2;
    Element mElement_ULONG_3;
    Element mElement_ULONG_4;
    Element mElement_USHORT_2;
    Element mElement_USHORT_3;
    Element mElement_USHORT_4;
    RSErrorHandler mErrorCallback;
    RSMessageHandler mMessageCallback;
    MessageThread mMessageThread;
    ProgramRaster mProgramRaster_CULL_BACK;
    ProgramRaster mProgramRaster_CULL_FRONT;
    ProgramRaster mProgramRaster_CULL_NONE;
    ProgramStore mProgramStore_BLEND_ALPHA_DEPTH_NO_DEPTH;
    ProgramStore mProgramStore_BLEND_ALPHA_DEPTH_TEST;
    ProgramStore mProgramStore_BLEND_NONE_DEPTH_NO_DEPTH;
    ProgramStore mProgramStore_BLEND_NONE_DEPTH_TEST;
    Sampler mSampler_CLAMP_LINEAR;
    Sampler mSampler_CLAMP_LINEAR_MIP_LINEAR;
    Sampler mSampler_CLAMP_NEAREST;
    Sampler mSampler_WRAP_LINEAR;
    Sampler mSampler_WRAP_LINEAR_MIP_LINEAR;
    Sampler mSampler_WRAP_NEAREST;

    static  {
        try {
            System.loadLibrary("rs_jni");
            _nInit();
            sInitialized = true;
        }
        catch(UnsatisfiedLinkError unsatisfiedlinkerror) {
            Log.e("RenderScript_jni", (new StringBuilder()).append("Error loading RS jni library: ").append(unsatisfiedlinkerror).toString());
            throw new RSRuntimeException((new StringBuilder()).append("Error loading RS jni library: ").append(unsatisfiedlinkerror).toString());
        }
    }
}
