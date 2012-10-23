// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.*;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.MathUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactPhotoUtils {

    public ContactPhotoUtils() {
    }

    public static Bitmap createNameBitmap(Context context, String s, int i, int j) {
        if(!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        Bitmap bitmap = null;
_L8:
        return bitmap;
_L2:
        Canvas canvas;
        Paint paint;
        String as[];
        String s3;
        String s4;
        int k;
        String s1;
        if(s.length() > 1)
            s1 = getWordFromName(s.trim());
        else
            s1 = s;
        if(s1 == null) {
            bitmap = null;
            continue; /* Loop/switch isn't completed */
        }
        String s2 = s1.trim();
        if(TextUtils.isEmpty(s2)) {
            bitmap = null;
            continue; /* Loop/switch isn't completed */
        }
        bitmap = Bitmap.createBitmap(96, 96, android.graphics.Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        Drawable drawable = context.getResources().getDrawable(i);
        drawable.setBounds(sRect);
        drawable.draw(canvas);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(j);
        if(isChinese(s)) {
            paint.setTextSize(86.39999F);
            canvas.drawText(s2, 4F, 76F, paint);
            continue; /* Loop/switch isn't completed */
        }
        as = s2.split(" |\\.|-|,|\\(|\\)|\uFF08|\uFF09|\u2014");
        if(as == null) {
            bitmap.recycle();
            bitmap = null;
            continue; /* Loop/switch isn't completed */
        }
        s3 = null;
        s4 = null;
        k = 0;
_L4:
        if(k >= as.length)
            break MISSING_BLOCK_LABEL_262;
        if(!TextUtils.isEmpty(as[k].trim())) {
            if(s3 != null)
                break; /* Loop/switch isn't completed */
            s3 = as[k].trim();
        }
_L5:
        k++;
        if(true) goto _L4; else goto _L3
_L3:
        if(s4 != null)
            break MISSING_BLOCK_LABEL_262;
        s4 = as[k].trim();
          goto _L5
        if(true) goto _L4; else goto _L6
_L6:
        if(s3 == null) {
            bitmap.recycle();
            bitmap = null;
        } else
        if(s4 == null) {
            paint.setTextSize(0.9F * MathUtils.min(96, 96));
            canvas.drawText(s3, 4F, 76F, paint);
        } else {
            paint.setTextSize(0.4F * MathUtils.min(96, 96));
            canvas.drawText(s3, 4F, 43F, paint);
            canvas.drawText(s4, 28F, 86F, paint);
        }
        if(true) goto _L8; else goto _L7
_L7:
    }

    public static Bitmap createNameBitmap(Context context, String s, int i, int j, int k, int l, int i1) {
        Bitmap bitmap = createNameBitmap(context, s, i, j);
        return createPhoto(context.getResources(), bitmap, k, l, i1);
    }

    /**
     * @deprecated Method createPhoto is deprecated
     */

    public static Bitmap createPhoto(Resources resources, Bitmap bitmap, int i, int j, int k) {
        Bitmap bitmap1 = null;
        miui/util/ContactPhotoUtils;
        JVM INSTR monitorenter ;
        if(bitmap != null) goto _L2; else goto _L1
_L1:
        miui/util/ContactPhotoUtils;
        JVM INSTR monitorexit ;
        return bitmap1;
_L2:
        bitmap1 = Bitmap.createBitmap(96, 96, android.graphics.Bitmap.Config.ARGB_8888);
        Drawable drawable = resources.getDrawable(i);
        drawable.setBounds(sRect);
        Drawable drawable1 = resources.getDrawable(k);
        drawable1.setBounds(sRect);
        Canvas canvas = new Canvas(bitmap1);
        drawable.draw(canvas);
        cutBitmap(resources, bitmap, j);
        canvas.drawBitmap(sBitmap, sRect, sRect, null);
        drawable1.draw(canvas);
        bitmap.recycle();
        if(true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private static void cutBitmap(Resources resources, Bitmap bitmap, int i) {
        int j;
        int k;
        int l;
        int i1;
        sCanvas.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
        Drawable drawable = resources.getDrawable(i);
        drawable.setBounds(sRect);
        drawable.draw(sCanvas);
        j = bitmap.getWidth();
        k = bitmap.getHeight();
        l = 0;
        i1 = 0;
        if(j <= k) goto _L2; else goto _L1
_L1:
        l = (j - k) / 2;
        j = k;
_L4:
        sCanvas.drawBitmap(bitmap, new Rect(l, i1, l + j, i1 + k), sRect, sPt);
        return;
_L2:
        if(j < k) {
            i1 = (k - j) / 2;
            k = j;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static String getWordFromName(String s) {
        if(isChinese(s)) {
            String s1 = removeSuffix(s);
            if(TextUtils.isEmpty(s1)) {
                s = null;
            } else {
                int i = s1.length();
                s = s1.substring(i - 1, i);
            }
        }
        return s;
    }

    private static boolean isChinese(String s) {
        return sAsiaLangPattern.matcher(s).find();
    }

    private static String removeSuffix(String s) {
        String s1 = s;
        if(!TextUtils.isEmpty(s1)) goto _L2; else goto _L1
_L1:
        String s2 = null;
_L4:
        return s2;
_L2:
        boolean flag;
        int i;
        flag = false;
        i = 0;
_L5:
        if(i >= suffix.length)
            continue; /* Loop/switch isn't completed */
        if(s1.endsWith(suffix[i])) {
            flag = true;
            s1 = s1.substring(0, s1.length() - suffix[i].length());
        } else {
            char c = s1.charAt(-1 + s1.length());
            if(c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z' || c == ',' || c == '.' || c == '-' || c == '(' || c == ')' || c == '\uFF08' || c == '\uFF09' || c == '\u2014') {
                flag = true;
                s1 = s1.substring(0, -1 + s1.length());
            }
        }
        if(!TextUtils.isEmpty(s1))
            break MISSING_BLOCK_LABEL_230;
        if(flag && !TextUtils.isEmpty(s1)) goto _L2; else goto _L3
_L3:
        if(s1 != null)
            s1 = s1.trim();
        if(TextUtils.isEmpty(s1))
            s1 = s.substring(-1 + s.length());
        s2 = s1;
          goto _L4
        i++;
          goto _L5
    }

    public static void setUseWordPhoto(Context context, boolean flag) {
        android.content.ContentResolver contentresolver = context.getContentResolver();
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        android.provider.Settings.System.putInt(contentresolver, "word_photo", i);
    }

    public static boolean useWordPhoto(Context context) {
        boolean flag = true;
        if(android.provider.Settings.System.getInt(context.getContentResolver(), "word_photo", 0) != flag)
            flag = false;
        return flag;
    }

    private static final String WORD_PHOTO = "word_photo";
    private static Pattern sAsiaLangPattern = Pattern.compile("[\u4E00-\u9FA5]");
    private static Bitmap sBitmap;
    private static Canvas sCanvas = null;
    private static final int sPhotoSize = 96;
    private static Paint sPt;
    private static Rect sRect = new Rect(0, 0, 96, 96);
    private static String suffix[];

    static  {
        sPt = null;
        sBitmap = null;
        sBitmap = Bitmap.createBitmap(96, 96, android.graphics.Bitmap.Config.ARGB_8888);
        sCanvas = new Canvas(sBitmap);
        sPt = new Paint();
        sPt.setFilterBitmap(true);
        sPt.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
        String as[] = new String[40];
        as[0] = "\u8001\u5E08";
        as[1] = "\u5148\u751F";
        as[2] = "\u8001\u677F";
        as[3] = "\u4ED4";
        as[4] = "\u624B\u673A";
        as[5] = "\u53D4";
        as[6] = "\u963F\u59E8";
        as[7] = "\u5B85";
        as[8] = "\u4F2F";
        as[9] = "\u4F2F\u6BCD";
        as[10] = "\u4F2F\u7236";
        as[11] = "\u54E5";
        as[12] = "\u59D0";
        as[13] = "\u5F1F";
        as[14] = "\u59B9";
        as[15] = "\u8205";
        as[16] = "\u59D1";
        as[17] = "\u7236";
        as[18] = "\u4E3B\u4EFB";
        as[19] = "\u7ECF\u7406";
        as[20] = "\u5DE5\u4F5C";
        as[21] = "\u540C\u4E8B";
        as[22] = "\u5F8B\u5E08";
        as[23] = "\u53F8\u673A";
        as[24] = "\u5E08\u5085";
        as[25] = "\u5E08\u7236";
        as[26] = "\u7237";
        as[27] = "\u5976";
        as[28] = "\u4E2D\u4ECB";
        as[29] = "\u8463";
        as[30] = "\u603B";
        as[31] = "\u592A\u592A";
        as[32] = "\u4FDD\u59C6";
        as[33] = "\u67D0";
        as[34] = "\u79D8\u4E66";
        as[35] = "\u5904\u957F";
        as[36] = "\u5C40\u957F";
        as[37] = "\u73ED\u957F";
        as[38] = "\u5144";
        as[39] = "\u52A9\u7406";
        suffix = as;
    }
}
