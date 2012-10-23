// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.net.Uri;
import java.io.*;
import java.util.*;

public class MediaMetadataRetriever {

    public MediaMetadataRetriever() {
        native_setup();
    }

    private native Bitmap _getFrameAtTime(long l, int i);

    private native void _setDataSource(String s, String as[], String as1[]) throws IllegalArgumentException;

    private native byte[] getEmbeddedPicture(int i);

    private final native void native_finalize();

    private static native void native_init();

    private native void native_setup();

    public native String extractMetadata(int i);

    protected void finalize() throws Throwable {
        native_finalize();
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public byte[] getEmbeddedPicture() {
        return getEmbeddedPicture(65535);
    }

    public Bitmap getFrameAtTime() {
        return getFrameAtTime(-1L, 2);
    }

    public Bitmap getFrameAtTime(long l) {
        return getFrameAtTime(l, 2);
    }

    public Bitmap getFrameAtTime(long l, int i) {
        if(i < 0 || i > 3)
            throw new IllegalArgumentException((new StringBuilder()).append("Unsupported option: ").append(i).toString());
        else
            return _getFrameAtTime(l, i);
    }

    public native void release();

    public void setDataSource(Context context, Uri uri) throws IllegalArgumentException, SecurityException {
        String s;
        if(uri == null)
            throw new IllegalArgumentException();
        s = uri.getScheme();
        if(s != null && !s.equals("file")) goto _L2; else goto _L1
_L1:
        setDataSource(uri.getPath());
_L4:
        return;
_L2:
        AssetFileDescriptor assetfiledescriptor = null;
        ContentResolver contentresolver = context.getContentResolver();
        AssetFileDescriptor assetfiledescriptor1 = contentresolver.openAssetFileDescriptor(uri, "r");
        assetfiledescriptor = assetfiledescriptor1;
        if(assetfiledescriptor == null) {
            Exception exception;
            FileNotFoundException filenotfoundexception;
            try {
                throw new IllegalArgumentException();
            }
            catch(SecurityException securityexception) { }
            finally {
                if(assetfiledescriptor == null) goto _L0; else goto _L0
            }
            FileDescriptor filedescriptor;
            IOException ioexception2;
            if(assetfiledescriptor != null)
                try {
                    assetfiledescriptor.close();
                }
                catch(IOException ioexception1) { }
            setDataSource(uri.toString());
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_123;
        filenotfoundexception;
        throw new IllegalArgumentException();
        try {
            assetfiledescriptor.close();
        }
        catch(IOException ioexception) { }
        throw exception;
        filedescriptor = assetfiledescriptor.getFileDescriptor();
        if(!filedescriptor.valid())
            throw new IllegalArgumentException();
        if(assetfiledescriptor.getDeclaredLength() >= 0L)
            break; /* Loop/switch isn't completed */
        setDataSource(filedescriptor);
_L5:
        if(assetfiledescriptor != null)
            try {
                assetfiledescriptor.close();
            }
            // Misplaced declaration of an exception variable
            catch(IOException ioexception2) { }
        if(true) goto _L4; else goto _L3
_L3:
        setDataSource(filedescriptor, assetfiledescriptor.getStartOffset(), assetfiledescriptor.getDeclaredLength());
          goto _L5
    }

    public void setDataSource(FileDescriptor filedescriptor) throws IllegalArgumentException {
        setDataSource(filedescriptor, 0L, 0x7ffffffffffffffL);
    }

    public native void setDataSource(FileDescriptor filedescriptor, long l, long l1) throws IllegalArgumentException;

    public void setDataSource(String s) throws IllegalArgumentException {
        FileInputStream fileinputstream = new FileInputStream(s);
        setDataSource(fileinputstream.getFD(), 0L, 0x7ffffffffffffffL);
        if(fileinputstream == null)
            break MISSING_BLOCK_LABEL_29;
        fileinputstream.close();
_L1:
        return;
        FileNotFoundException filenotfoundexception1;
        filenotfoundexception1;
_L3:
        throw new IllegalArgumentException();
        IOException ioexception1;
        ioexception1;
_L2:
        throw new IllegalArgumentException();
        Exception exception;
        exception;
          goto _L1
        IOException ioexception;
        ioexception;
          goto _L2
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
          goto _L3
    }

    public void setDataSource(String s, Map map) throws IllegalArgumentException {
        int i = 0;
        String as[] = new String[map.size()];
        String as1[] = new String[map.size()];
        for(Iterator iterator = map.entrySet().iterator(); iterator.hasNext();) {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            as[i] = (String)entry.getKey();
            as1[i] = (String)entry.getValue();
            i++;
        }

        _setDataSource(s, as, as1);
    }

    private static final int EMBEDDED_PICTURE_TYPE_ANY = 65535;
    public static final int METADATA_KEY_ALBUM = 1;
    public static final int METADATA_KEY_ALBUMARTIST = 13;
    public static final int METADATA_KEY_ARTIST = 2;
    public static final int METADATA_KEY_AUTHOR = 3;
    public static final int METADATA_KEY_BITRATE = 20;
    public static final int METADATA_KEY_CD_TRACK_NUMBER = 0;
    public static final int METADATA_KEY_COMPILATION = 15;
    public static final int METADATA_KEY_COMPOSER = 4;
    public static final int METADATA_KEY_DATE = 5;
    public static final int METADATA_KEY_DISC_NUMBER = 14;
    public static final int METADATA_KEY_DURATION = 9;
    public static final int METADATA_KEY_GENRE = 6;
    public static final int METADATA_KEY_HAS_AUDIO = 16;
    public static final int METADATA_KEY_HAS_VIDEO = 17;
    public static final int METADATA_KEY_IS_DRM = 22;
    public static final int METADATA_KEY_LOCATION = 23;
    public static final int METADATA_KEY_MIMETYPE = 12;
    public static final int METADATA_KEY_NUM_TRACKS = 10;
    public static final int METADATA_KEY_TIMED_TEXT_LANGUAGES = 21;
    public static final int METADATA_KEY_TITLE = 7;
    public static final int METADATA_KEY_VIDEO_HEIGHT = 19;
    public static final int METADATA_KEY_VIDEO_WIDTH = 18;
    public static final int METADATA_KEY_WRITER = 11;
    public static final int METADATA_KEY_YEAR = 8;
    public static final int OPTION_CLOSEST = 3;
    public static final int OPTION_CLOSEST_SYNC = 2;
    public static final int OPTION_NEXT_SYNC = 1;
    public static final int OPTION_PREVIOUS_SYNC;
    private int mNativeContext;

    static  {
        System.loadLibrary("media_jni");
        native_init();
    }
}
