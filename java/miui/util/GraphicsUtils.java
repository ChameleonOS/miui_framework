// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.util;

import android.graphics.*;
import android.text.TextUtils;
import android.util.MathUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GraphicsUtils {

    public GraphicsUtils() {
    }

    public static Bitmap createNameBitmap(Bitmap bitmap, String s, int i, int j, int k) {
        if(i > 0) goto _L2; else goto _L1
_L1:
        Bitmap bitmap1 = null;
_L8:
        return bitmap1;
_L2:
        Canvas canvas;
        Paint paint;
        String as[];
        String s3;
        String s4;
        int l;
        if(j <= 0) {
            bitmap1 = null;
            continue; /* Loop/switch isn't completed */
        }
        if(TextUtils.isEmpty(s)) {
            bitmap1 = null;
            continue; /* Loop/switch isn't completed */
        }
        String s1 = getWordFromName(s.trim());
        if(s1 == null) {
            bitmap1 = null;
            continue; /* Loop/switch isn't completed */
        }
        String s2 = s1.trim();
        if(TextUtils.isEmpty(s2)) {
            bitmap1 = null;
            continue; /* Loop/switch isn't completed */
        }
        bitmap1 = Bitmap.createScaledBitmap(bitmap, i, j, false);
        canvas = new Canvas(bitmap1);
        bitmap.recycle();
        paint = new Paint();
        paint.setColor(k);
        if(isChinese(s)) {
            paint.setTextSize(0.9F * MathUtils.min(i, j));
            canvas.drawText(s2, (int)(0.050000000000000003D * (double)i), (int)(0.80000000000000004D * (double)j), paint);
            continue; /* Loop/switch isn't completed */
        }
        as = s2.split(" |\\.|-|,|\\(|\\)|\uFF08|\uFF09|\u2014");
        if(as == null) {
            bitmap1.recycle();
            bitmap1 = null;
            continue; /* Loop/switch isn't completed */
        }
        s3 = null;
        s4 = null;
        l = 0;
_L4:
        if(l >= as.length)
            break MISSING_BLOCK_LABEL_257;
        if(!TextUtils.isEmpty(as[l].trim())) {
            if(s3 != null)
                break; /* Loop/switch isn't completed */
            s3 = as[l].trim();
        }
_L5:
        l++;
        if(true) goto _L4; else goto _L3
_L3:
        if(s4 != null)
            break MISSING_BLOCK_LABEL_257;
        s4 = as[l].trim();
          goto _L5
        if(true) goto _L4; else goto _L6
_L6:
        if(s3 == null) {
            bitmap1.recycle();
            bitmap1 = null;
        } else
        if(s4 == null) {
            paint.setTextSize(0.9F * MathUtils.min(i, j));
            canvas.drawText(s3, (int)(0.050000000000000003D * (double)i), (int)(0.80000000000000004D * (double)j), paint);
        } else {
            paint.setTextSize(0.4F * MathUtils.min(i, j));
            canvas.drawText(s3, (int)(0.050000000000000003D * (double)i), (int)(0.45000000000000001D * (double)j), paint);
            canvas.drawText(s4, (int)(0.29999999999999999D * (double)i), (int)(0.90000000000000002D * (double)j), paint);
        }
        if(true) goto _L8; else goto _L7
_L7:
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

    public static Bitmap makeRoundImage(Bitmap bitmap, int i, int j) {
        Bitmap bitmap1;
        if(bitmap == null) {
            bitmap1 = null;
        } else {
            int k = bitmap.getWidth();
            int l = bitmap.getHeight();
            bitmap1 = Bitmap.createBitmap(k, l, android.graphics.Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap1);
            Paint paint = new Paint(1);
            int i1 = Math.min(k, l) / 3;
            int j1 = Math.min(i, i1);
            int k1 = Math.min(j, i1);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(0xff424242);
            canvas.drawRoundRect(new RectF(0.0F, 0.0F, k, l), j1, k1, paint);
            paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, 0.0F, 0.0F, paint);
        }
        return bitmap1;
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
            break MISSING_BLOCK_LABEL_211;
        if(flag && !TextUtils.isEmpty(s1)) goto _L2; else goto _L3
_L3:
        if(s1 != null)
            s1 = s1.trim();
        s2 = s1;
          goto _L4
        i++;
          goto _L5
    }

    private static Pattern sAsiaLangPattern = Pattern.compile("[\u4E00-\u9FA5]");
    private static String suffix[];

    static  {
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
