// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.util;

import android.graphics.*;
import java.io.FileOutputStream;
import libcore.io.Streams;

// Referenced classes of package miui.util:
//            InputStreamLoader

public class ImageUtils {

    public ImageUtils() {
    }

    public static int computeSampleSize(InputStreamLoader inputstreamloader, int i) {
        int j = 1;
        if(i > 0) {
            android.graphics.BitmapFactory.Options options = getBitmapSize(inputstreamloader);
            for(double d = Math.sqrt(((double)options.outWidth * (double)options.outHeight) / (double)i); (double)(j * 2) <= d; j <<= 1);
        }
        return j;
    }

    public static boolean cropBitmapToAnother(Bitmap bitmap, Bitmap bitmap1, boolean flag) {
        boolean flag1 = true;
        if(bitmap != null && bitmap1 != null) {
            int i = bitmap.getWidth();
            int j = bitmap.getHeight();
            int k = bitmap1.getWidth();
            int l = bitmap1.getHeight();
            float f = Math.max((1.0F * (float)k) / (float)i, (1.0F * (float)l) / (float)j);
            Paint paint = new Paint();
            paint.setFilterBitmap(flag1);
            paint.setAntiAlias(flag1);
            paint.setDither(flag1);
            Canvas canvas = new Canvas(bitmap1);
            canvas.translate(((float)k - f * (float)i) / 2.0F, ((float)l - f * (float)j) / 2.0F);
            canvas.scale(f, f);
            canvas.drawBitmap(bitmap, 0.0F, 0.0F, paint);
            if(flag)
                bitmap.recycle();
        } else {
            flag1 = false;
        }
        return flag1;
    }

    public static final Bitmap getBitmap(InputStreamLoader inputstreamloader, int i) {
        android.graphics.BitmapFactory.Options options;
        Bitmap bitmap;
        int j;
        options = getDefaultOptions();
        options.inSampleSize = computeSampleSize(inputstreamloader, i);
        bitmap = null;
        j = 0;
_L6:
        int k = j + 1;
        if(j >= 3) goto _L2; else goto _L1
_L1:
        Bitmap bitmap1 = BitmapFactory.decodeStream(inputstreamloader.get(), null, options);
        bitmap = bitmap1;
_L4:
        inputstreamloader.close();
_L2:
        return bitmap;
        OutOfMemoryError outofmemoryerror;
        outofmemoryerror;
        System.gc();
        options.inSampleSize = 2 * options.inSampleSize;
        inputstreamloader.close();
        j = k;
        continue; /* Loop/switch isn't completed */
        Exception exception1;
        exception1;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        inputstreamloader.close();
        throw exception;
        if(true) goto _L6; else goto _L5
_L5:
    }

    public static Bitmap getBitmap(InputStreamLoader inputstreamloader, int i, int j) {
        int k = 2 * (i * j);
        if(i <= 0 || j <= 0)
            k = -1;
        Bitmap bitmap = getBitmap(inputstreamloader, k);
        if(k > 0)
            bitmap = scaleBitmapToDesire(bitmap, i, j, true);
        return bitmap;
    }

    public static Bitmap getBitmap(InputStreamLoader inputstreamloader, int i, int j, Bitmap bitmap) {
        Bitmap bitmap1 = null;
        if(bitmap == null || bitmap.isRecycled()) goto _L2; else goto _L1
_L1:
        android.graphics.BitmapFactory.Options options = getBitmapSize(inputstreamloader);
        if(options.outWidth != bitmap.getWidth() || options.outHeight != bitmap.getHeight()) goto _L4; else goto _L3
_L3:
        Bitmap bitmap3;
        android.graphics.BitmapFactory.Options options1 = getDefaultOptions();
        options1.inBitmap = bitmap;
        options1.inSampleSize = 1;
        bitmap3 = BitmapFactory.decodeStream(inputstreamloader.get(), null, options1);
        bitmap1 = bitmap3;
_L6:
        inputstreamloader.close();
_L4:
        if(bitmap1 == null)
            bitmap.recycle();
_L2:
        Bitmap bitmap2 = bitmap1;
        Exception exception1;
        if(bitmap2 != null) {
            if(i > 0 && j > 0)
                bitmap2 = scaleBitmapToDesire(bitmap2, i, j, true);
        } else {
            bitmap2 = getBitmap(inputstreamloader, i, j);
        }
        return bitmap2;
        exception1;
        inputstreamloader.close();
        throw exception1;
        Exception exception;
        exception;
        if(true) goto _L6; else goto _L5
_L5:
    }

    public static final android.graphics.BitmapFactory.Options getBitmapSize(String s) {
        return getBitmapSize(new InputStreamLoader(s));
    }

    public static final android.graphics.BitmapFactory.Options getBitmapSize(InputStreamLoader inputstreamloader) {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        Exception exception1;
        try {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(inputstreamloader.get(), null, options);
        }
        catch(Exception exception) { }
        finally {
            inputstreamloader.close();
        }
        inputstreamloader.close();
        return options;
        throw exception1;
    }

    public static android.graphics.BitmapFactory.Options getDefaultOptions() {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inDither = false;
        options.inJustDecodeBounds = false;
        options.inSampleSize = 1;
        options.inScaled = false;
        return options;
    }

    public static boolean saveBitmapToLocal(InputStreamLoader inputstreamloader, String s, int i, int j) {
        if(inputstreamloader != null && s != null && i >= 1 && j >= 1) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = false;
        android.graphics.BitmapFactory.Options options = getBitmapSize(inputstreamloader);
        if(options.outWidth > 0 && options.outHeight > 0)
            if(options.outWidth == i && options.outHeight == j) {
                flag = saveToFile(inputstreamloader, s);
            } else {
                Bitmap bitmap = getBitmap(inputstreamloader, i, j);
                if(bitmap != null) {
                    flag = saveToFile(bitmap, s);
                    bitmap.recycle();
                }
            }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static boolean saveToFile(Bitmap bitmap, String s) {
        if(bitmap == null) goto _L2; else goto _L1
_L1:
        FileOutputStream fileoutputstream = new FileOutputStream(s);
        bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, fileoutputstream);
        fileoutputstream.close();
        boolean flag = true;
_L4:
        return flag;
        Exception exception;
        exception;
_L2:
        flag = false;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static boolean saveToFile(InputStreamLoader inputstreamloader, String s) {
        boolean flag = false;
        FileOutputStream fileoutputstream = new FileOutputStream(s);
        Streams.copy(inputstreamloader.get(), fileoutputstream);
        fileoutputstream.close();
        inputstreamloader.close();
        flag = true;
_L2:
        return flag;
        Exception exception;
        exception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static Bitmap scaleBitmapToDesire(Bitmap bitmap, int i, int j, boolean flag) {
        Bitmap bitmap1 = null;
        try {
            int k = bitmap.getWidth();
            int l = bitmap.getHeight();
            if(k == i && l == j) {
                bitmap1 = bitmap;
            } else {
                android.graphics.Bitmap.Config config = android.graphics.Bitmap.Config.ARGB_8888;
                if(bitmap.getConfig() != null)
                    config = bitmap.getConfig();
                bitmap1 = Bitmap.createBitmap(i, j, config);
                cropBitmapToAnother(bitmap, bitmap1, flag);
            }
        }
        catch(Exception exception) { }
        catch(OutOfMemoryError outofmemoryerror) { }
        return bitmap1;
    }
}
