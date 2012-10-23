// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.util;

import android.content.Context;
import android.graphics.*;
import android.net.Uri;

// Referenced classes of package miui.util:
//            InputStreamLoader, ImageUtils

public class AlbumUtils {

    public AlbumUtils() {
    }

    public static Bitmap clipRoundCornerBitmap(Bitmap bitmap, float f, int i) {
        Bitmap bitmap1;
        if(bitmap == null) {
            bitmap1 = null;
        } else {
            bitmap1 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap1);
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            RectF rectf = new RectF(rect);
            paint.setColor(i);
            paint.setFlags(7);
            canvas.drawARGB(0, 0, 0, 0);
            canvas.drawRoundRect(rectf, f, f, paint);
            paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect, paint);
        }
        return bitmap1;
    }

    public static Bitmap loadAlbum(Context context, Uri uri, String s, int i, int j) {
        Bitmap bitmap = null;
        if(uri != null)
            bitmap = ImageUtils.getBitmap(new InputStreamLoader(context, uri), i, j);
        if(bitmap == null && s != null)
            bitmap = ImageUtils.getBitmap(new InputStreamLoader(s), i, j);
        return bitmap;
    }
}
