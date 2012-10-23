// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.text.util;

import android.content.res.Resources;
import android.graphics.*;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import java.lang.reflect.Field;

public class EmojiSmileys {
    private static class LazySmileyDrawable extends Drawable {

        public void draw(Canvas canvas) {
            canvas.drawBitmap(getBitmap(), null, getBounds(), mPaint);
        }

        public Bitmap getBitmap() {
            Bitmap bitmap;
            if(mBitmap != null) {
                bitmap = mBitmap;
            } else {
                Drawable drawable = Resources.getSystem().getDrawable(mResId);
                if(drawable instanceof BitmapDrawable) {
                    mBitmap = ((BitmapDrawable)drawable).getBitmap();
                    bitmap = mBitmap;
                } else {
                    bitmap = null;
                }
            }
            return bitmap;
        }

        public int getIntrinsicHeight() {
            return 48;
        }

        public int getIntrinsicWidth() {
            return 48;
        }

        public int getOpacity() {
            byte byte0;
            if(getBitmap() == null || getBitmap().hasAlpha() || mPaint.getAlpha() < 255)
                byte0 = -3;
            else
                byte0 = -1;
            return byte0;
        }

        public void setAlpha(int i) {
            mPaint.setAlpha(i);
        }

        public void setColorFilter(ColorFilter colorfilter) {
            mPaint.setColorFilter(colorfilter);
        }

        private Bitmap mBitmap;
        private final Paint mPaint = new Paint();
        private final int mResId;

        public LazySmileyDrawable(int i) {
            mResId = i;
            setBounds(0, 0, 48, 48);
        }
    }


    public EmojiSmileys() {
    }

    private static LazySmileyDrawable getDrawableByResName(String s) {
        LazySmileyDrawable lazysmileydrawable = null;
        int i = com/miui/internal/R$drawable.getField(s).getInt(null);
        lazysmileydrawable = new LazySmileyDrawable(i);
_L2:
        return lazysmileydrawable;
        SecurityException securityexception;
        securityexception;
        continue; /* Loop/switch isn't completed */
        NoSuchFieldException nosuchfieldexception;
        nosuchfieldexception;
        continue; /* Loop/switch isn't completed */
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        continue; /* Loop/switch isn't completed */
        IllegalAccessException illegalaccessexception;
        illegalaccessexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static Bitmap getEmojiBitmap(int i) {
        LazySmileyDrawable lazysmileydrawable = (LazySmileyDrawable)getEmojiDrawable(i);
        Bitmap bitmap;
        if(lazysmileydrawable == null)
            bitmap = null;
        else
            bitmap = lazysmileydrawable.getBitmap();
        return bitmap;
    }

    public static Drawable getEmojiDrawable(int i) {
        LazySmileyDrawable lazysmileydrawable;
        if(i >= 57345 && i <= 58679) {
            int j = i - 57345;
            if(!mInitialized[j]) {
                mInitialized[j] = true;
                Object aobj[] = new Object[1];
                aobj[0] = Integer.valueOf(i);
                String s = String.format("emoji_%x", aobj);
                mSmileyBitmaps[j] = getDrawableByResName(s);
            }
            lazysmileydrawable = mSmileyBitmaps[j];
        } else {
            lazysmileydrawable = null;
        }
        return lazysmileydrawable;
    }

    public static boolean isEmoji(int i) {
        boolean flag;
        if(getEmojiDrawable(i) != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static final int EMOJI_CODE_FIRST = 57345;
    private static final int EMOJI_CODE_LAST = 58679;
    private static final int EMOJI_SIZE_PX = 48;
    private static final boolean mInitialized[] = new boolean[1335];
    private static final LazySmileyDrawable mSmileyBitmaps[] = new LazySmileyDrawable[1335];

}
