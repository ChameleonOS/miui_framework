// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.*;

// Referenced classes of package android.media:
//            MediaFormat

public final class MediaExtractor {

    public MediaExtractor() {
        native_setup();
    }

    private native Map getTrackFormatNative(int i);

    private final native void native_finalize();

    private static final native void native_init();

    private final native void native_setup();

    private final native void setDataSource(String s, String as[], String as1[]);

    public native boolean advance();

    protected void finalize() {
        native_finalize();
    }

    public native long getCachedDuration();

    public native boolean getSampleCryptoInfo(MediaCodec.CryptoInfo cryptoinfo);

    public native int getSampleFlags();

    public native long getSampleTime();

    public native int getSampleTrackIndex();

    public final native int getTrackCount();

    public MediaFormat getTrackFormat(int i) {
        return new MediaFormat(getTrackFormatNative(i));
    }

    public native boolean hasCacheReachedEndOfStream();

    public native int readSampleData(ByteBuffer bytebuffer, int i);

    public final native void release();

    public native void seekTo(long l, int i);

    public native void selectTrack(int i);

    public final void setDataSource(Context context, Uri uri, Map map) throws IOException {
        String s = uri.getScheme();
        if(s != null && !s.equals("file")) goto _L2; else goto _L1
_L1:
        setDataSource(uri.getPath());
_L6:
        return;
_L2:
        AssetFileDescriptor assetfiledescriptor = null;
        AssetFileDescriptor assetfiledescriptor1 = context.getContentResolver().openAssetFileDescriptor(uri, "r");
        assetfiledescriptor = assetfiledescriptor1;
        if(assetfiledescriptor != null) goto _L4; else goto _L3
_L3:
        if(assetfiledescriptor == null) goto _L6; else goto _L5
_L5:
        assetfiledescriptor.close();
        break; /* Loop/switch isn't completed */
_L4:
        if(assetfiledescriptor.getDeclaredLength() < 0L)
            setDataSource(assetfiledescriptor.getFileDescriptor());
        else
            setDataSource(assetfiledescriptor.getFileDescriptor(), assetfiledescriptor.getStartOffset(), assetfiledescriptor.getDeclaredLength());
        continue; /* Loop/switch isn't completed */
        SecurityException securityexception;
        securityexception;
        if(assetfiledescriptor == null) goto _L8; else goto _L7
_L7:
        assetfiledescriptor.close();
_L8:
        setDataSource(uri.toString(), map);
        break; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        if(assetfiledescriptor != null)
            assetfiledescriptor.close();
        throw exception;
        IOException ioexception;
        ioexception;
        if(assetfiledescriptor == null) goto _L8; else goto _L7
        if(assetfiledescriptor == null) goto _L6; else goto _L5
    }

    public final void setDataSource(FileDescriptor filedescriptor) {
        setDataSource(filedescriptor, 0L, 0x7ffffffffffffffL);
    }

    public final native void setDataSource(FileDescriptor filedescriptor, long l, long l1);

    public final void setDataSource(String s) {
        setDataSource(s, ((String []) (null)), ((String []) (null)));
    }

    public final void setDataSource(String s, Map map) {
        String as[] = null;
        String as1[] = null;
        if(map != null) {
            as = new String[map.size()];
            as1 = new String[map.size()];
            int i = 0;
            for(Iterator iterator = map.entrySet().iterator(); iterator.hasNext();) {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                as[i] = (String)entry.getKey();
                as1[i] = (String)entry.getValue();
                i++;
            }

        }
        setDataSource(s, as, as1);
    }

    public native void unselectTrack(int i);

    public static final int SAMPLE_FLAG_ENCRYPTED = 2;
    public static final int SAMPLE_FLAG_SYNC = 1;
    public static final int SEEK_TO_CLOSEST_SYNC = 2;
    public static final int SEEK_TO_NEXT_SYNC = 1;
    public static final int SEEK_TO_PREVIOUS_SYNC;
    private int mNativeContext;

    static  {
        System.loadLibrary("media_jni");
        native_init();
    }
}
