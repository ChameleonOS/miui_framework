// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import android.content.ContentResolver;
import android.graphics.*;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.FileInputStream;
import java.io.IOException;

// Referenced classes of package android.media:
//            MediaFile, ExifInterface, MediaMetadataRetriever

public class ThumbnailUtils {
    private static class SizedThumbnailBitmap {

        public Bitmap mBitmap;
        public byte mThumbnailData[];
        public int mThumbnailHeight;
        public int mThumbnailWidth;

        private SizedThumbnailBitmap() {
        }

    }


    public ThumbnailUtils() {
    }

    private static void closeSilently(ParcelFileDescriptor parcelfiledescriptor) {
        if(parcelfiledescriptor != null)
            try {
                parcelfiledescriptor.close();
            }
            catch(Throwable throwable) { }
    }

    private static int computeInitialSampleSize(android.graphics.BitmapFactory.Options options, int i, int j) {
        int k;
        int l;
        double d = options.outWidth;
        double d1 = options.outHeight;
        if(j == -1)
            k = 1;
        else
            k = (int)Math.ceil(Math.sqrt((d * d1) / (double)j));
        if(i == -1)
            l = 128;
        else
            l = (int)Math.min(Math.floor(d / (double)i), Math.floor(d1 / (double)i));
        if(l >= k) goto _L2; else goto _L1
_L1:
        return k;
_L2:
        if(j == -1 && i == -1)
            k = 1;
        else
        if(i != -1)
            k = l;
        if(true) goto _L1; else goto _L3
_L3:
    }

    private static int computeSampleSize(android.graphics.BitmapFactory.Options options, int i, int j) {
        int k = computeInitialSampleSize(options, i, j);
        int l;
        if(k <= 8)
            for(l = 1; l < k; l <<= 1);
        else
            l = 8 * ((k + 7) / 8);
        return l;
    }

    public static Bitmap createImageThumbnail(String s, int i) {
        char c;
        int j;
        Bitmap bitmap;
        FileInputStream fileinputstream;
        FileInputStream fileinputstream1;
        java.io.FileDescriptor filedescriptor;
        android.graphics.BitmapFactory.Options options;
        boolean flag;
        SizedThumbnailBitmap sizedthumbnailbitmap;
        MediaFile.MediaFileType mediafiletype;
        int k;
        if(i == 1)
            flag = true;
        else
            flag = false;
        if(flag)
            c = '\u0140';
        else
            c = '`';
        if(flag)
            j = 0x30000;
        else
            j = 16384;
        sizedthumbnailbitmap = new SizedThumbnailBitmap();
        bitmap = null;
        mediafiletype = MediaFile.getFileType(s);
        if(mediafiletype != null && mediafiletype.fileType == 31) {
            createThumbnailFromEXIF(s, c, j, sizedthumbnailbitmap);
            bitmap = sizedthumbnailbitmap.mBitmap;
        }
        if(bitmap != null)
            break MISSING_BLOCK_LABEL_252;
        fileinputstream = null;
        fileinputstream1 = new FileInputStream(s);
        filedescriptor = fileinputstream1.getFD();
        options = new android.graphics.BitmapFactory.Options();
        options.inSampleSize = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(filedescriptor, null, options);
        if(options.mCancel || options.outWidth == -1)
            break MISSING_BLOCK_LABEL_160;
        k = options.outHeight;
        if(k != -1)
            break MISSING_BLOCK_LABEL_195;
        IOException ioexception;
        Exception exception;
        IOException ioexception2;
        String s1;
        String s2;
        OutOfMemoryError outofmemoryerror;
        Bitmap bitmap1 = null;
        IOException ioexception1;
        Bitmap bitmap2;
        if(fileinputstream1 != null)
            try {
                fileinputstream1.close();
            }
            catch(IOException ioexception3) {
                Log.e("ThumbnailUtils", "", ioexception3);
            }
        return bitmap1;
        options.inSampleSize = computeSampleSize(options, c, j);
        options.inJustDecodeBounds = false;
        options.inDither = false;
        options.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
        bitmap2 = BitmapFactory.decodeFileDescriptor(filedescriptor, null, options);
        bitmap = bitmap2;
        if(fileinputstream1 == null)
            break MISSING_BLOCK_LABEL_252;
        fileinputstream1.close();
_L2:
        if(i == 3)
            bitmap = extractThumbnail(bitmap, 96, 96, 2);
        bitmap1 = bitmap;
        if(true)
            break MISSING_BLOCK_LABEL_173;
        ioexception;
_L7:
        Log.e("ThumbnailUtils", "", ioexception);
        if(fileinputstream == null) goto _L2; else goto _L1
_L1:
        fileinputstream.close();
          goto _L2
        ioexception2;
        s1 = "ThumbnailUtils";
        s2 = "";
_L4:
        Log.e(s1, s2, ioexception2);
          goto _L2
        outofmemoryerror;
_L6:
        Log.e("ThumbnailUtils", (new StringBuilder()).append("Unable to decode file ").append(s).append(". OutOfMemoryError.").toString(), outofmemoryerror);
        if(fileinputstream == null) goto _L2; else goto _L3
_L3:
        fileinputstream.close();
          goto _L2
        ioexception2;
        s1 = "ThumbnailUtils";
        s2 = "";
          goto _L4
        exception;
_L5:
        if(fileinputstream != null)
            try {
                fileinputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch(IOException ioexception1) {
                Log.e("ThumbnailUtils", "", ioexception1);
            }
        throw exception;
        ioexception2;
        s1 = "ThumbnailUtils";
        s2 = "";
          goto _L4
        exception;
        fileinputstream = fileinputstream1;
          goto _L5
        outofmemoryerror;
        fileinputstream = fileinputstream1;
          goto _L6
        ioexception;
        fileinputstream = fileinputstream1;
          goto _L7
    }

    private static void createThumbnailFromEXIF(String s, int i, int j, SizedThumbnailBitmap sizedthumbnailbitmap) {
        if(s != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        byte abyte0[] = null;
        ExifInterface exifinterface = new ExifInterface(s);
        byte abyte1[] = exifinterface.getThumbnail();
        abyte0 = abyte1;
_L4:
        IOException ioexception;
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        android.graphics.BitmapFactory.Options options1 = new android.graphics.BitmapFactory.Options();
        int k = 0;
        if(abyte0 != null) {
            options1.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(abyte0, 0, abyte0.length, options1);
            options1.inSampleSize = computeSampleSize(options1, i, j);
            k = options1.outWidth / options1.inSampleSize;
        }
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(s, options);
        options.inSampleSize = computeSampleSize(options, i, j);
        int l = options.outWidth / options.inSampleSize;
        if(abyte0 != null && k >= l) {
            int i1 = options1.outWidth;
            int j1 = options1.outHeight;
            options1.inJustDecodeBounds = false;
            sizedthumbnailbitmap.mBitmap = BitmapFactory.decodeByteArray(abyte0, 0, abyte0.length, options1);
            if(sizedthumbnailbitmap.mBitmap != null) {
                sizedthumbnailbitmap.mThumbnailData = abyte0;
                sizedthumbnailbitmap.mThumbnailWidth = i1;
                sizedthumbnailbitmap.mThumbnailHeight = j1;
            }
        } else {
            options.inJustDecodeBounds = false;
            sizedthumbnailbitmap.mBitmap = BitmapFactory.decodeFile(s, options);
        }
        if(true) goto _L1; else goto _L3
_L3:
        ioexception;
_L5:
        Log.w("ThumbnailUtils", ioexception);
          goto _L4
        ioexception;
          goto _L5
    }

    public static Bitmap createVideoThumbnail(String s, int i) {
        Bitmap bitmap;
        MediaMetadataRetriever mediametadataretriever;
        bitmap = null;
        mediametadataretriever = new MediaMetadataRetriever();
        Bitmap bitmap2;
        mediametadataretriever.setDataSource(s);
        bitmap2 = mediametadataretriever.getFrameAtTime(-1L);
        bitmap = bitmap2;
        RuntimeException runtimeexception;
        Bitmap bitmap1;
        int j;
        int k;
        int l;
        float f;
        IllegalArgumentException illegalargumentexception;
        Exception exception;
        RuntimeException runtimeexception2;
        try {
            mediametadataretriever.release();
        }
        catch(RuntimeException runtimeexception1) { }
        if(bitmap != null) goto _L2; else goto _L1
_L1:
        bitmap1 = null;
_L4:
        return bitmap1;
        exception;
        try {
            mediametadataretriever.release();
        }
        // Misplaced declaration of an exception variable
        catch(RuntimeException runtimeexception2) { }
        throw exception;
_L2:
        if(i != 1)
            break; /* Loop/switch isn't completed */
        j = bitmap.getWidth();
        k = bitmap.getHeight();
        l = Math.max(j, k);
        if(l > 512) {
            f = 512F / (float)l;
            bitmap = Bitmap.createScaledBitmap(bitmap, Math.round(f * (float)j), Math.round(f * (float)k), true);
        }
_L6:
        bitmap1 = bitmap;
        if(true) goto _L4; else goto _L3
_L3:
        if(i != 3) goto _L6; else goto _L5
_L5:
        bitmap = extractThumbnail(bitmap, 96, 96, 2);
          goto _L6
        illegalargumentexception;
        mediametadataretriever.release();
        break MISSING_BLOCK_LABEL_31;
        runtimeexception;
        mediametadataretriever.release();
        break MISSING_BLOCK_LABEL_31;
    }

    public static Bitmap extractThumbnail(Bitmap bitmap, int i, int j) {
        return extractThumbnail(bitmap, i, j, 0);
    }

    public static Bitmap extractThumbnail(Bitmap bitmap, int i, int j, int k) {
        Bitmap bitmap1;
        if(bitmap == null) {
            bitmap1 = null;
        } else {
            float f;
            Matrix matrix;
            if(bitmap.getWidth() < bitmap.getHeight())
                f = (float)i / (float)bitmap.getWidth();
            else
                f = (float)j / (float)bitmap.getHeight();
            matrix = new Matrix();
            matrix.setScale(f, f);
            bitmap1 = transform(matrix, bitmap, i, j, k | 1);
        }
        return bitmap1;
    }

    private static Bitmap makeBitmap(int i, int j, Uri uri, ContentResolver contentresolver, ParcelFileDescriptor parcelfiledescriptor, android.graphics.BitmapFactory.Options options) {
        Bitmap bitmap;
        bitmap = null;
        if(parcelfiledescriptor != null)
            break MISSING_BLOCK_LABEL_19;
        ParcelFileDescriptor parcelfiledescriptor1 = makeInputStream(uri, contentresolver);
        parcelfiledescriptor = parcelfiledescriptor1;
        if(parcelfiledescriptor != null) goto _L2; else goto _L1
_L1:
        closeSilently(parcelfiledescriptor);
_L4:
        return bitmap;
_L2:
        if(options != null)
            break MISSING_BLOCK_LABEL_46;
        options = new android.graphics.BitmapFactory.Options();
        java.io.FileDescriptor filedescriptor;
        filedescriptor = parcelfiledescriptor.getFileDescriptor();
        options.inSampleSize = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(filedescriptor, null, options);
        if(options.mCancel || options.outWidth == -1 || options.outHeight == -1) goto _L1; else goto _L3
_L3:
        Bitmap bitmap1;
        options.inSampleSize = computeSampleSize(options, i, j);
        options.inJustDecodeBounds = false;
        options.inDither = false;
        options.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
        bitmap1 = BitmapFactory.decodeFileDescriptor(filedescriptor, null, options);
        closeSilently(parcelfiledescriptor);
        bitmap = bitmap1;
          goto _L4
        OutOfMemoryError outofmemoryerror;
        outofmemoryerror;
        Log.e("ThumbnailUtils", "Got oom exception ", outofmemoryerror);
          goto _L1
        Exception exception;
        exception;
        closeSilently(parcelfiledescriptor);
        throw exception;
    }

    private static ParcelFileDescriptor makeInputStream(Uri uri, ContentResolver contentresolver) {
        ParcelFileDescriptor parcelfiledescriptor1 = contentresolver.openFileDescriptor(uri, "r");
        ParcelFileDescriptor parcelfiledescriptor = parcelfiledescriptor1;
_L2:
        return parcelfiledescriptor;
        IOException ioexception;
        ioexception;
        parcelfiledescriptor = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private static Bitmap transform(Matrix matrix, Bitmap bitmap, int i, int j, int k) {
        boolean flag1;
        Bitmap bitmap2;
        boolean flag;
        int l;
        int i1;
        Canvas canvas;
        int l1;
        int i2;
        Rect rect;
        int j2;
        int k2;
        Rect rect1;
        if((k & 1) != 0)
            flag = true;
        else
            flag = false;
        if((k & 2) != 0)
            flag1 = true;
        else
            flag1 = false;
        l = bitmap.getWidth() - i;
        i1 = bitmap.getHeight() - j;
        if(flag || l >= 0 && i1 >= 0) goto _L2; else goto _L1
_L1:
        bitmap2 = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap2);
        l1 = Math.max(0, l / 2);
        i2 = Math.max(0, i1 / 2);
        rect = new Rect(l1, i2, l1 + Math.min(i, bitmap.getWidth()), i2 + Math.min(j, bitmap.getHeight()));
        j2 = (i - rect.width()) / 2;
        k2 = (j - rect.height()) / 2;
        rect1 = new Rect(j2, k2, i - j2, j - k2);
        canvas.drawBitmap(bitmap, rect, rect1, null);
        if(flag1)
            bitmap.recycle();
        canvas.setBitmap(null);
_L4:
        return bitmap2;
_L2:
        float f = bitmap.getWidth();
        float f1 = bitmap.getHeight();
        Bitmap bitmap1;
        if(f / f1 > (float)i / (float)j) {
            float f3 = (float)j / f1;
            int j1;
            int k1;
            if(f3 < 0.9F || f3 > 1.0F)
                matrix.setScale(f3, f3);
            else
                matrix = null;
        } else {
            float f2 = (float)i / f;
            if(f2 < 0.9F || f2 > 1.0F)
                matrix.setScale(f2, f2);
            else
                matrix = null;
        }
        if(matrix != null)
            bitmap1 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        else
            bitmap1 = bitmap;
        if(flag1 && bitmap1 != bitmap)
            bitmap.recycle();
        j1 = Math.max(0, bitmap1.getWidth() - i);
        k1 = Math.max(0, bitmap1.getHeight() - j);
        bitmap2 = Bitmap.createBitmap(bitmap1, j1 / 2, k1 / 2, i, j);
        if(bitmap2 != bitmap1 && (flag1 || bitmap1 != bitmap))
            bitmap1.recycle();
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static final int MAX_NUM_PIXELS_MICRO_THUMBNAIL = 16384;
    private static final int MAX_NUM_PIXELS_THUMBNAIL = 0x30000;
    private static final int OPTIONS_NONE = 0;
    public static final int OPTIONS_RECYCLE_INPUT = 2;
    private static final int OPTIONS_SCALE_UP = 1;
    private static final String TAG = "ThumbnailUtils";
    public static final int TARGET_SIZE_MICRO_THUMBNAIL = 96;
    public static final int TARGET_SIZE_MINI_THUMBNAIL = 320;
    private static final int UNCONSTRAINED = -1;
}
