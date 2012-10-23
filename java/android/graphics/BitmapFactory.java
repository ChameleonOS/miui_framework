// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.*;

// Referenced classes of package android.graphics:
//            Bitmap, NinePatch, Rect

public class BitmapFactory {
    public static class Options {

        private native void requestCancel();

        public void requestCancelDecode() {
            mCancel = true;
            requestCancel();
        }

        public Bitmap inBitmap;
        public int inDensity;
        public boolean inDither;
        public boolean inInputShareable;
        public boolean inJustDecodeBounds;
        public boolean inMutable;
        public boolean inPreferQualityOverSpeed;
        public Bitmap.Config inPreferredConfig;
        public boolean inPurgeable;
        public int inSampleSize;
        public boolean inScaled;
        public int inScreenDensity;
        public int inTargetDensity;
        public byte inTempStorage[];
        public boolean mCancel;
        public int outHeight;
        public String outMimeType;
        public int outWidth;

        public Options() {
            inPreferredConfig = Bitmap.Config.ARGB_8888;
            inDither = false;
            inScaled = true;
        }
    }


    public BitmapFactory() {
    }

    public static Bitmap decodeByteArray(byte abyte0[], int i, int j) {
        return decodeByteArray(abyte0, i, j, null);
    }

    public static Bitmap decodeByteArray(byte abyte0[], int i, int j, Options options) {
        if((i | j) < 0 || abyte0.length < i + j)
            throw new ArrayIndexOutOfBoundsException();
        Bitmap bitmap = nativeDecodeByteArray(abyte0, i, j, options);
        if(bitmap == null && options != null && options.inBitmap != null)
            throw new IllegalArgumentException("Problem decoding into existing bitmap");
        else
            return bitmap;
    }

    public static Bitmap decodeFile(String s) {
        return decodeFile(s, null);
    }

    public static Bitmap decodeFile(String s, Options options) {
        Bitmap bitmap;
        FileInputStream fileinputstream;
        bitmap = null;
        fileinputstream = null;
        FileInputStream fileinputstream1 = new FileInputStream(s);
        Bitmap bitmap1 = decodeStream(fileinputstream1, null, options);
        bitmap = bitmap1;
        if(fileinputstream1 != null)
            try {
                fileinputstream1.close();
            }
            catch(IOException ioexception2) { }
_L2:
        return bitmap;
        Exception exception2;
        exception2;
_L5:
        if(fileinputstream != null)
            try {
                fileinputstream.close();
            }
            catch(IOException ioexception) { }
        if(true) goto _L2; else goto _L1
_L1:
        Exception exception1;
        exception1;
_L4:
        if(fileinputstream != null)
            try {
                fileinputstream.close();
            }
            catch(IOException ioexception1) { }
        throw exception1;
        exception1;
        fileinputstream = fileinputstream1;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        fileinputstream = fileinputstream1;
          goto _L5
    }

    public static Bitmap decodeFileDescriptor(FileDescriptor filedescriptor) {
        return decodeFileDescriptor(filedescriptor, null, null);
    }

    public static Bitmap decodeFileDescriptor(FileDescriptor filedescriptor, Rect rect, Options options) {
        if(!nativeIsSeekable(filedescriptor)) goto _L2; else goto _L1
_L1:
        Bitmap bitmap1;
        Bitmap bitmap2 = nativeDecodeFileDescriptor(filedescriptor, rect, options);
        if(bitmap2 == null && options != null && options.inBitmap != null)
            throw new IllegalArgumentException("Problem decoding into existing bitmap");
        bitmap1 = finishDecode(bitmap2, rect, options);
_L4:
        return bitmap1;
_L2:
        FileInputStream fileinputstream = new FileInputStream(filedescriptor);
        Bitmap bitmap = decodeStream(fileinputstream, rect, options);
        bitmap1 = bitmap;
        try {
            fileinputstream.close();
        }
        catch(Throwable throwable1) { }
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        try {
            fileinputstream.close();
        }
        catch(Throwable throwable) { }
        throw exception;
    }

    public static Bitmap decodeResource(Resources resources, int i) {
        return decodeResource(resources, i, null);
    }

    public static Bitmap decodeResource(Resources resources, int i, Options options) {
        Bitmap bitmap;
label0:
        {
            bitmap = null;
            InputStream inputstream = null;
            Bitmap bitmap1;
            try {
                TypedValue typedvalue = new TypedValue();
                inputstream = resources.openRawResource(i, typedvalue);
                bitmap1 = decodeResourceStream(resources, typedvalue, inputstream, null, options);
            }
            catch(Exception exception1) {
                if(inputstream != null)
                    try {
                        inputstream.close();
                    }
                    catch(IOException ioexception1) { }
                break label0;
            }
            finally {
                IOException ioexception2;
                if(inputstream != null)
                    try {
                        inputstream.close();
                    }
                    catch(IOException ioexception) { }
                throw exception;
            }
            bitmap = bitmap1;
            if(inputstream != null)
                try {
                    inputstream.close();
                }
                // Misplaced declaration of an exception variable
                catch(IOException ioexception2) { }
        }
        if(bitmap == null && options != null && options.inBitmap != null)
            throw new IllegalArgumentException("Problem decoding into existing bitmap");
        else
            return bitmap;
    }

    public static Bitmap decodeResourceStream(Resources resources, TypedValue typedvalue, InputStream inputstream, Rect rect, Options options) {
        if(options == null)
            options = new Options();
        if(options.inDensity != 0 || typedvalue == null) goto _L2; else goto _L1
_L1:
        int i = typedvalue.density;
        if(i != 0) goto _L4; else goto _L3
_L3:
        options.inDensity = 160;
_L2:
        if(options.inTargetDensity == 0 && resources != null)
            options.inTargetDensity = resources.getDisplayMetrics().densityDpi;
        return decodeStream(inputstream, rect, options);
_L4:
        if(i != 65535)
            options.inDensity = i;
        if(true) goto _L2; else goto _L5
_L5:
    }

    public static Bitmap decodeStream(InputStream inputstream) {
        return decodeStream(inputstream, null, null);
    }

    public static Bitmap decodeStream(InputStream inputstream, Rect rect, Options options) {
        if(inputstream != null) goto _L2; else goto _L1
_L1:
        Bitmap bitmap = null;
_L4:
        return bitmap;
_L2:
        if(!inputstream.markSupported())
            inputstream = new BufferedInputStream(inputstream, 16384);
        inputstream.mark(1024);
        boolean flag = true;
        if(inputstream instanceof android.content.res.AssetManager.AssetInputStream) {
            int k = ((android.content.res.AssetManager.AssetInputStream)inputstream).getAssetInt();
            if(options == null || options.inScaled && options.inBitmap == null) {
                float f1 = 1.0F;
                int l = 0;
                if(options != null) {
                    int i1 = options.inDensity;
                    l = options.inTargetDensity;
                    if(i1 != 0 && l != 0)
                        f1 = (float)l / (float)i1;
                }
                bitmap = nativeDecodeAsset(k, rect, options, true, f1);
                if(bitmap != null && l != 0)
                    bitmap.setDensity(l);
                flag = false;
            } else {
                bitmap = nativeDecodeAsset(k, rect, options);
            }
        } else {
            byte abyte0[] = null;
            if(options != null)
                abyte0 = options.inTempStorage;
            if(abyte0 == null)
                abyte0 = new byte[16384];
            if(options == null || options.inScaled && options.inBitmap == null) {
                float f = 1.0F;
                int i = 0;
                if(options != null) {
                    int j = options.inDensity;
                    i = options.inTargetDensity;
                    if(j != 0 && i != 0)
                        f = (float)i / (float)j;
                }
                bitmap = nativeDecodeStream(inputstream, abyte0, rect, options, true, f);
                if(bitmap != null && i != 0)
                    bitmap.setDensity(i);
                flag = false;
            } else {
                bitmap = nativeDecodeStream(inputstream, abyte0, rect, options);
            }
        }
        if(bitmap == null && options != null && options.inBitmap != null)
            throw new IllegalArgumentException("Problem decoding into existing bitmap");
        if(flag)
            bitmap = finishDecode(bitmap, rect, options);
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static Bitmap finishDecode(Bitmap bitmap, Rect rect, Options options) {
        if(bitmap != null && options != null) goto _L2; else goto _L1
_L1:
        return bitmap;
_L2:
        int i = options.inDensity;
        if(i != 0) {
            bitmap.setDensity(i);
            int j = options.inTargetDensity;
            if(j != 0 && i != j && i != options.inScreenDensity) {
                byte abyte0[] = bitmap.getNinePatchChunk();
                int ai[] = bitmap.getLayoutBounds();
                boolean flag;
                if(abyte0 != null && NinePatch.isNinePatchChunk(abyte0))
                    flag = true;
                else
                    flag = false;
                if(options.inScaled || flag) {
                    float f = (float)j / (float)i;
                    if(f != 1.0F) {
                        Bitmap bitmap1 = bitmap;
                        bitmap = Bitmap.createScaledBitmap(bitmap1, (int)(0.5F + f * (float)bitmap.getWidth()), (int)(0.5F + f * (float)bitmap.getHeight()), true);
                        if(bitmap != bitmap1)
                            bitmap1.recycle();
                        if(flag)
                            bitmap.setNinePatchChunk(nativeScaleNinePatch(abyte0, f, rect));
                        if(ai != null) {
                            int ai1[] = new int[ai.length];
                            for(int k = 0; k < ai.length; k++)
                                ai1[k] = (int)(0.5F + f * (float)ai[k]);

                            bitmap.setLayoutBounds(ai1);
                        }
                    }
                    bitmap.setDensity(j);
                }
            }
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    private static native Bitmap nativeDecodeAsset(int i, Rect rect, Options options);

    private static native Bitmap nativeDecodeAsset(int i, Rect rect, Options options, boolean flag, float f);

    private static native Bitmap nativeDecodeByteArray(byte abyte0[], int i, int j, Options options);

    private static native Bitmap nativeDecodeFileDescriptor(FileDescriptor filedescriptor, Rect rect, Options options);

    private static native Bitmap nativeDecodeStream(InputStream inputstream, byte abyte0[], Rect rect, Options options);

    private static native Bitmap nativeDecodeStream(InputStream inputstream, byte abyte0[], Rect rect, Options options, boolean flag, float f);

    private static native boolean nativeIsSeekable(FileDescriptor filedescriptor);

    private static native byte[] nativeScaleNinePatch(byte abyte0[], float f, Rect rect);

    private static final int DECODE_BUFFER_SIZE = 16384;
}
