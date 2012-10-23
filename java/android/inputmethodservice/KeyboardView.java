// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.inputmethodservice;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.*;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.*;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.util.*;

// Referenced classes of package android.inputmethodservice:
//            Keyboard

public class KeyboardView extends View
    implements android.view.View.OnClickListener {
    private static class SwipeTracker {

        private void addPoint(float f, float f1, long l) {
            int i = -1;
            long al[] = mPastTime;
            int j = 0;
            do {
                if(j >= 4 || al[j] == 0L) {
                    if(j == 4 && i < 0)
                        i = 0;
                    if(i == j)
                        i--;
                    float af[] = mPastX;
                    float af1[] = mPastY;
                    if(i >= 0) {
                        int i1 = i + 1;
                        int j1 = -1 + (4 - i);
                        System.arraycopy(af, i1, af, 0, j1);
                        System.arraycopy(af1, i1, af1, 0, j1);
                        System.arraycopy(al, i1, al, 0, j1);
                        j -= i + 1;
                    }
                    af[j] = f;
                    af1[j] = f1;
                    al[j] = l;
                    int k = j + 1;
                    if(k < 4)
                        al[k] = 0L;
                    return;
                }
                if(al[j] < l - 200L)
                    i = j;
                j++;
            } while(true);
        }

        public void addMovement(MotionEvent motionevent) {
            long l = motionevent.getEventTime();
            int i = motionevent.getHistorySize();
            for(int j = 0; j < i; j++)
                addPoint(motionevent.getHistoricalX(j), motionevent.getHistoricalY(j), motionevent.getHistoricalEventTime(j));

            addPoint(motionevent.getX(), motionevent.getY(), l);
        }

        public void clear() {
            mPastTime[0] = 0L;
        }

        public void computeCurrentVelocity(int i) {
            computeCurrentVelocity(i, 3.402823E+38F);
        }

        public void computeCurrentVelocity(int i, float f) {
            float af[] = mPastX;
            float af1[] = mPastY;
            long al[] = mPastTime;
            float f1 = af[0];
            float f2 = af1[0];
            long l = al[0];
            float f3 = 0.0F;
            float f4 = 0.0F;
            int j = 0;
            do {
                if(j >= 4 || al[j] == 0L) {
                    int k = 1;
                    while(k < j)  {
                        int i1 = (int)(al[k] - l);
                        if(i1 != 0) {
                            float f7 = ((af[k] - f1) / (float)i1) * (float)i;
                            float f8;
                            if(f3 == 0.0F)
                                f3 = f7;
                            else
                                f3 = 0.5F * (f3 + f7);
                            f8 = ((af1[k] - f2) / (float)i1) * (float)i;
                            if(f4 == 0.0F)
                                f4 = f8;
                            else
                                f4 = 0.5F * (f4 + f8);
                        }
                        k++;
                    }
                    break;
                }
                j++;
            } while(true);
            float f5;
            float f6;
            if(f3 < 0.0F)
                f5 = Math.max(f3, -f);
            else
                f5 = Math.min(f3, f);
            mXVelocity = f5;
            if(f4 < 0.0F)
                f6 = Math.max(f4, -f);
            else
                f6 = Math.min(f4, f);
            mYVelocity = f6;
        }

        public float getXVelocity() {
            return mXVelocity;
        }

        public float getYVelocity() {
            return mYVelocity;
        }

        static final int LONGEST_PAST_TIME = 200;
        static final int NUM_PAST = 4;
        final long mPastTime[];
        final float mPastX[];
        final float mPastY[];
        float mXVelocity;
        float mYVelocity;

        private SwipeTracker() {
            mPastX = new float[4];
            mPastY = new float[4];
            mPastTime = new long[4];
        }

    }

    public static interface OnKeyboardActionListener {

        public abstract void onKey(int i, int ai[]);

        public abstract void onPress(int i);

        public abstract void onRelease(int i);

        public abstract void onText(CharSequence charsequence);

        public abstract void swipeDown();

        public abstract void swipeLeft();

        public abstract void swipeRight();

        public abstract void swipeUp();
    }


    public KeyboardView(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0x1010412);
    }

    public KeyboardView(Context context, AttributeSet attributeset, int i) {
        TypedArray typedarray;
        LayoutInflater layoutinflater;
        int j;
        int k;
        int l;
        super(context, attributeset, i);
        mCurrentKeyIndex = -1;
        mCoordinates = new int[2];
        mPreviewCentered = false;
        mShowPreview = true;
        mShowTouchPoints = true;
        mCurrentKey = -1;
        mDownKey = -1;
        mKeyIndices = new int[12];
        mRepeatKeyIndex = -1;
        mClipRegion = new Rect(0, 0, 0, 0);
        mSwipeTracker = new SwipeTracker();
        mOldPointerCount = 1;
        mDistances = new int[MAX_NEARBY_KEYS];
        mPreviewLabel = new StringBuilder(1);
        mDirtyRect = new Rect();
        mHandler = new Handler() {

            public void handleMessage(Message message) {
                message.what;
                JVM INSTR tableswitch 1 4: default 36
            //                           1 37
            //                           2 51
            //                           3 65
            //                           4 91;
                   goto _L1 _L2 _L3 _L4 _L5
_L1:
                return;
_L2:
                showKey(message.arg1);
                continue; /* Loop/switch isn't completed */
_L3:
                mPreviewText.setVisibility(4);
                continue; /* Loop/switch isn't completed */
_L4:
                if(repeatKey())
                    sendMessageDelayed(Message.obtain(this, 3), 50L);
                continue; /* Loop/switch isn't completed */
_L5:
                openPopupIfRequired((MotionEvent)message.obj);
                if(true) goto _L1; else goto _L6
_L6:
            }

            final KeyboardView this$0;

             {
                this$0 = KeyboardView.this;
                super();
            }
        };
        typedarray = context.obtainStyledAttributes(attributeset, android.R.styleable.KeyboardView, i, 0);
        layoutinflater = (LayoutInflater)context.getSystemService("layout_inflater");
        j = 0;
        k = typedarray.getIndexCount();
        l = 0;
_L14:
        int i1;
        if(l >= k)
            break MISSING_BLOCK_LABEL_421;
        i1 = typedarray.getIndex(l);
        i1;
        JVM INSTR tableswitch 0 10: default 248
    //                   0 391
    //                   1 406
    //                   2 254
    //                   3 327
    //                   4 360
    //                   5 343
    //                   6 283
    //                   7 296
    //                   8 311
    //                   9 268
    //                   10 376;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L3:
        break MISSING_BLOCK_LABEL_406;
_L1:
        break; /* Loop/switch isn't completed */
_L4:
        break; /* Loop/switch isn't completed */
_L15:
        l++;
        if(true) goto _L14; else goto _L13
_L13:
        mKeyBackground = typedarray.getDrawable(i1);
          goto _L15
_L11:
        mVerticalCorrection = typedarray.getDimensionPixelOffset(i1, 0);
          goto _L15
_L8:
        j = typedarray.getResourceId(i1, 0);
          goto _L15
_L9:
        mPreviewOffset = typedarray.getDimensionPixelOffset(i1, 0);
          goto _L15
_L10:
        mPreviewHeight = typedarray.getDimensionPixelSize(i1, 80);
          goto _L15
_L5:
        mKeyTextSize = typedarray.getDimensionPixelSize(i1, 18);
          goto _L15
_L7:
        mKeyTextColor = typedarray.getColor(i1, 0xff000000);
          goto _L15
_L6:
        mLabelTextSize = typedarray.getDimensionPixelSize(i1, 14);
          goto _L15
_L12:
        mPopupLayout = typedarray.getResourceId(i1, 0);
          goto _L15
_L2:
        mShadowColor = typedarray.getColor(i1, 0);
          goto _L15
        mShadowRadius = typedarray.getFloat(i1, 0.0F);
          goto _L15
        mBackgroundDimAmount = super.mContext.obtainStyledAttributes(com.android.internal.R.styleable.Theme).getFloat(2, 0.5F);
        mPreviewPopup = new PopupWindow(context);
        if(j != 0) {
            mPreviewText = (TextView)layoutinflater.inflate(j, null);
            mPreviewTextSizeLarge = (int)mPreviewText.getTextSize();
            mPreviewPopup.setContentView(mPreviewText);
            mPreviewPopup.setBackgroundDrawable(null);
        } else {
            mShowPreview = false;
        }
        mPreviewPopup.setTouchable(false);
        mPopupKeyboard = new PopupWindow(context);
        mPopupKeyboard.setBackgroundDrawable(null);
        mPopupParent = this;
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(0);
        mPaint.setTextAlign(android.graphics.Paint.Align.CENTER);
        mPaint.setAlpha(255);
        mPadding = new Rect(0, 0, 0, 0);
        mMiniKeyboardCache = new HashMap();
        mKeyBackground.getPadding(mPadding);
        mSwipeThreshold = (int)(500F * getResources().getDisplayMetrics().density);
        mDisambiguateSwipe = getResources().getBoolean(0x1110023);
        mAccessibilityManager = AccessibilityManager.getInstance(context);
        mAudioManager = (AudioManager)context.getSystemService("audio");
        resetMultiTap();
        initGestureDetector();
        return;
    }

    private CharSequence adjustCase(CharSequence charsequence) {
        if(mKeyboard.isShifted() && charsequence != null && charsequence.length() < 3 && Character.isLowerCase(charsequence.charAt(0)))
            charsequence = charsequence.toString().toUpperCase();
        return charsequence;
    }

    private void checkMultiTap(long l, int i) {
        if(i != -1) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Keyboard.Key key = mKeys[i];
        if(key.codes.length > 1) {
            mInMultiTap = true;
            if(l < 800L + mLastTapTime && i == mLastSentIndex)
                mTapCount = (1 + mTapCount) % key.codes.length;
            else
                mTapCount = -1;
        } else
        if(l > 800L + mLastTapTime || i != mLastSentIndex)
            resetMultiTap();
        if(true) goto _L1; else goto _L3
_L3:
    }

    private void computeProximityThreshold(Keyboard keyboard) {
        if(keyboard != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Keyboard.Key akey[] = mKeys;
        if(akey != null) {
            int i = akey.length;
            int j = 0;
            for(int k = 0; k < i; k++) {
                Keyboard.Key key = akey[k];
                j += Math.min(key.width, key.height) + key.gap;
            }

            if(j >= 0 && i != 0) {
                mProximityThreshold = (int)((1.4F * (float)j) / (float)i);
                mProximityThreshold = mProximityThreshold * mProximityThreshold;
            }
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    private void detectAndSendKey(int i, int j, int k, long l) {
        if(i != -1 && i < mKeys.length) {
            Keyboard.Key key = mKeys[i];
            if(key.text != null) {
                mKeyboardActionListener.onText(key.text);
                mKeyboardActionListener.onRelease(-1);
            } else {
                int i1 = key.codes[0];
                int ai[] = new int[MAX_NEARBY_KEYS];
                Arrays.fill(ai, -1);
                getKeyIndices(j, k, ai);
                if(mInMultiTap) {
                    if(mTapCount != -1)
                        mKeyboardActionListener.onKey(-5, KEY_DELETE);
                    else
                        mTapCount = 0;
                    i1 = key.codes[mTapCount];
                }
                mKeyboardActionListener.onKey(i1, ai);
                mKeyboardActionListener.onRelease(i1);
            }
            mLastSentIndex = i;
            mLastTapTime = l;
        }
    }

    private void dismissPopupKeyboard() {
        if(mPopupKeyboard.isShowing()) {
            mPopupKeyboard.dismiss();
            mMiniKeyboardOnScreen = false;
            invalidateAllKeys();
        }
    }

    private int getKeyIndices(int i, int j, int ai[]) {
        Keyboard.Key akey[];
        int k;
        int l;
        int i1;
        int ai1[];
        int j1;
        int k1;
        akey = mKeys;
        k = -1;
        l = -1;
        i1 = 1 + mProximityThreshold;
        Arrays.fill(mDistances, 0x7fffffff);
        ai1 = mKeyboard.getNearestKeys(i, j);
        j1 = ai1.length;
        k1 = 0;
_L2:
        Keyboard.Key key;
        int l1;
        int i2;
label0:
        {
label1:
            {
                if(k1 >= j1)
                    break MISSING_BLOCK_LABEL_293;
                key = akey[ai1[k1]];
                l1 = 0;
                boolean flag = key.isInside(i, j);
                if(flag)
                    k = ai1[k1];
                if(mProximityCorrectOn) {
                    l1 = key.squaredDistanceFrom(i, j);
                    if(l1 < mProximityThreshold)
                        break label1;
                }
                if(!flag)
                    break label0;
            }
            if(key.codes[0] > 32) {
                i2 = key.codes.length;
                if(l1 < i1) {
                    i1 = l1;
                    l = ai1[k1];
                }
                if(ai != null)
                    break; /* Loop/switch isn't completed */
            }
        }
_L3:
        k1++;
        if(true) goto _L2; else goto _L1
_L1:
        int j2 = 0;
_L4:
        if(j2 < mDistances.length) {
label2:
            {
                if(mDistances[j2] <= l1)
                    break label2;
                System.arraycopy(mDistances, j2, mDistances, j2 + i2, mDistances.length - j2 - i2);
                System.arraycopy(ai, j2, ai, j2 + i2, ai.length - j2 - i2);
                int k2 = 0;
                while(k2 < i2)  {
                    ai[j2 + k2] = key.codes[k2];
                    mDistances[j2 + k2] = l1;
                    k2++;
                }
            }
        }
          goto _L3
        j2++;
          goto _L4
        if(k == -1)
            k = l;
        return k;
          goto _L3
    }

    private CharSequence getPreviewText(Keyboard.Key key) {
        int i = 0;
        CharSequence charsequence;
        if(mInMultiTap) {
            mPreviewLabel.setLength(0);
            StringBuilder stringbuilder = mPreviewLabel;
            int ai[] = key.codes;
            if(mTapCount >= 0)
                i = mTapCount;
            stringbuilder.append((char)ai[i]);
            charsequence = adjustCase(mPreviewLabel);
        } else {
            charsequence = adjustCase(key.label);
        }
        return charsequence;
    }

    private void initGestureDetector() {
        mGestureDetector = new GestureDetector(getContext(), new android.view.GestureDetector.SimpleOnGestureListener() {

            public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1) {
                if(!mPossiblePoly) goto _L2; else goto _L1
_L1:
                boolean flag1 = false;
_L10:
                return flag1;
_L2:
                float f2;
                float f3;
                float f4;
                float f5;
                int i;
                int j;
                float f6;
                float f7;
                boolean flag;
                f2 = Math.abs(f);
                f3 = Math.abs(f1);
                f4 = motionevent1.getX() - motionevent.getX();
                f5 = motionevent1.getY() - motionevent.getY();
                i = getWidth() / 2;
                j = getHeight() / 2;
                mSwipeTracker.computeCurrentVelocity(1000);
                f6 = mSwipeTracker.getXVelocity();
                f7 = mSwipeTracker.getYVelocity();
                flag = false;
                if(f <= (float)mSwipeThreshold || f3 >= f2 || f4 <= (float)i) goto _L4; else goto _L3
_L3:
                if(!mDisambiguateSwipe || f6 >= f / 4F) goto _L6; else goto _L5
_L5:
                flag = true;
_L8:
                if(flag)
                    detectAndSendKey(mDownKey, mStartX, mStartY, motionevent.getEventTime());
                flag1 = false;
                continue; /* Loop/switch isn't completed */
_L6:
                swipeRight();
                flag1 = true;
                continue; /* Loop/switch isn't completed */
_L4:
                if(f < (float)(-mSwipeThreshold) && f3 < f2 && f4 < (float)(-i)) {
                    if(mDisambiguateSwipe && f6 > f / 4F) {
                        flag = true;
                        continue; /* Loop/switch isn't completed */
                    }
                    swipeLeft();
                    flag1 = true;
                    continue; /* Loop/switch isn't completed */
                }
                if(f1 < (float)(-mSwipeThreshold) && f2 < f3 && f5 < (float)(-j)) {
                    if(mDisambiguateSwipe && f7 > f1 / 4F) {
                        flag = true;
                        continue; /* Loop/switch isn't completed */
                    }
                    swipeUp();
                    flag1 = true;
                    continue; /* Loop/switch isn't completed */
                }
                if(f1 <= (float)mSwipeThreshold || f2 >= f3 / 2.0F || f5 <= (float)j)
                    continue; /* Loop/switch isn't completed */
                if(!mDisambiguateSwipe || f7 >= f1 / 4F)
                    break; /* Loop/switch isn't completed */
                flag = true;
                if(true) goto _L8; else goto _L7
_L7:
                swipeDown();
                flag1 = true;
                if(true) goto _L10; else goto _L9
_L9:
            }

            final KeyboardView this$0;

             {
                this$0 = KeyboardView.this;
                super();
            }
        });
        mGestureDetector.setIsLongpressEnabled(false);
    }

    private void onBufferDraw() {
        Canvas canvas;
        if(mBuffer == null || mKeyboardChanged) {
            if(mBuffer == null || mKeyboardChanged && (mBuffer.getWidth() != getWidth() || mBuffer.getHeight() != getHeight())) {
                mBuffer = Bitmap.createBitmap(Math.max(1, getWidth()), Math.max(1, getHeight()), android.graphics.Bitmap.Config.ARGB_8888);
                mCanvas = new Canvas(mBuffer);
            }
            invalidateAllKeys();
            mKeyboardChanged = false;
        }
        canvas = mCanvas;
        canvas.clipRect(mDirtyRect, android.graphics.Region.Op.REPLACE);
        if(mKeyboard != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Paint paint = mPaint;
        Drawable drawable = mKeyBackground;
        Rect rect = mClipRegion;
        Rect rect1 = mPadding;
        int i = super.mPaddingLeft;
        int j = super.mPaddingTop;
        Keyboard.Key akey[] = mKeys;
        Keyboard.Key key = mInvalidatedKey;
        paint.setColor(mKeyTextColor);
        boolean flag = false;
        if(key != null && canvas.getClipBounds(rect) && -1 + (i + key.x) <= rect.left && -1 + (j + key.y) <= rect.top && 1 + (i + (key.x + key.width)) >= rect.right && 1 + (j + (key.y + key.height)) >= rect.bottom)
            flag = true;
        canvas.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
        int k = akey.length;
        int l = 0;
        while(l < k)  {
            Keyboard.Key key1 = akey[l];
            if(!flag || key == key1) {
                drawable.setState(key1.getCurrentDrawableState());
                String s;
                Rect rect2;
                if(key1.label == null)
                    s = null;
                else
                    s = adjustCase(key1.label).toString();
                rect2 = drawable.getBounds();
                if(key1.width != rect2.right || key1.height != rect2.bottom)
                    drawable.setBounds(0, 0, key1.width, key1.height);
                canvas.translate(i + key1.x, j + key1.y);
                drawable.draw(canvas);
                if(s != null) {
                    float f;
                    float f1;
                    if(s.length() > 1 && key1.codes.length < 2) {
                        paint.setTextSize(mLabelTextSize);
                        paint.setTypeface(Typeface.DEFAULT_BOLD);
                    } else {
                        paint.setTextSize(mKeyTextSize);
                        paint.setTypeface(Typeface.DEFAULT);
                    }
                    paint.setShadowLayer(mShadowRadius, 0.0F, 0.0F, mShadowColor);
                    f = (key1.width - rect1.left - rect1.right) / 2 + rect1.left;
                    f1 = (float)((key1.height - rect1.top - rect1.bottom) / 2) + (paint.getTextSize() - paint.descent()) / 2.0F + (float)rect1.top;
                    canvas.drawText(s, f, f1, paint);
                    paint.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
                } else
                if(key1.icon != null) {
                    int i1 = (key1.width - rect1.left - rect1.right - key1.icon.getIntrinsicWidth()) / 2 + rect1.left;
                    int j1 = (key1.height - rect1.top - rect1.bottom - key1.icon.getIntrinsicHeight()) / 2 + rect1.top;
                    canvas.translate(i1, j1);
                    key1.icon.setBounds(0, 0, key1.icon.getIntrinsicWidth(), key1.icon.getIntrinsicHeight());
                    key1.icon.draw(canvas);
                    canvas.translate(-i1, -j1);
                }
                canvas.translate(-key1.x - i, -key1.y - j);
            }
            l++;
        }
        mInvalidatedKey = null;
        if(mMiniKeyboardOnScreen) {
            paint.setColor((int)(255F * mBackgroundDimAmount) << 24);
            canvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), paint);
        }
        mDrawPending = false;
        mDirtyRect.setEmpty();
        if(true) goto _L1; else goto _L3
_L3:
    }

    private boolean onModifiedTouchEvent(MotionEvent motionevent, boolean flag) {
        int i;
        int j;
        int k;
        long l;
        int i1;
        i = (int)motionevent.getX() - super.mPaddingLeft;
        j = (int)motionevent.getY() - super.mPaddingTop;
        if(j >= -mVerticalCorrection)
            j += mVerticalCorrection;
        k = motionevent.getAction();
        l = motionevent.getEventTime();
        i1 = getKeyIndices(i, j, null);
        mPossiblePoly = flag;
        if(k == 0)
            mSwipeTracker.clear();
        mSwipeTracker.addMovement(motionevent);
        if(!mAbortKey || k == 0 || k == 3) goto _L2; else goto _L1
_L1:
        boolean flag1 = true;
_L9:
        return flag1;
_L2:
        if(mGestureDetector.onTouchEvent(motionevent)) {
            showPreview(-1);
            mHandler.removeMessages(3);
            mHandler.removeMessages(4);
            flag1 = true;
            continue; /* Loop/switch isn't completed */
        }
        if(mMiniKeyboardOnScreen && k != 3) {
            flag1 = true;
            continue; /* Loop/switch isn't completed */
        }
        k;
        JVM INSTR tableswitch 0 3: default 204
    //                   0 221
    //                   1 655
    //                   2 459
    //                   3 843;
           goto _L3 _L4 _L5 _L6 _L7
_L7:
        break MISSING_BLOCK_LABEL_843;
_L3:
        break; /* Loop/switch isn't completed */
_L4:
        break; /* Loop/switch isn't completed */
_L10:
        mLastX = i;
        mLastY = j;
        flag1 = true;
        if(true) goto _L9; else goto _L8
_L8:
label0:
        {
            mAbortKey = false;
            mStartX = i;
            mStartY = j;
            mLastCodeX = i;
            mLastCodeY = j;
            mLastKeyTime = 0L;
            mCurrentKeyTime = 0L;
            mLastKey = -1;
            mCurrentKey = i1;
            mDownKey = i1;
            mDownTime = motionevent.getEventTime();
            mLastMoveTime = mDownTime;
            checkMultiTap(l, i1);
            OnKeyboardActionListener onkeyboardactionlistener = mKeyboardActionListener;
            int j1;
            Message message2;
            if(i1 != -1)
                j1 = mKeys[i1].codes[0];
            else
                j1 = 0;
            onkeyboardactionlistener.onPress(j1);
            if(mCurrentKey < 0 || !mKeys[mCurrentKey].repeatable)
                break label0;
            mRepeatKeyIndex = mCurrentKey;
            message2 = mHandler.obtainMessage(3);
            mHandler.sendMessageDelayed(message2, 400L);
            repeatKey();
            if(!mAbortKey)
                break label0;
            mRepeatKeyIndex = -1;
        }
          goto _L10
        if(mCurrentKey != -1) {
            Message message1 = mHandler.obtainMessage(4, motionevent);
            mHandler.sendMessageDelayed(message1, LONGPRESS_TIMEOUT);
        }
        showPreview(i1);
          goto _L10
_L6:
        boolean flag2 = false;
        if(i1 != -1)
            if(mCurrentKey == -1) {
                mCurrentKey = i1;
                mCurrentKeyTime = l - mDownTime;
            } else
            if(i1 == mCurrentKey) {
                mCurrentKeyTime = mCurrentKeyTime + (l - mLastMoveTime);
                flag2 = true;
            } else
            if(mRepeatKeyIndex == -1) {
                resetMultiTap();
                mLastKey = mCurrentKey;
                mLastCodeX = mLastX;
                mLastCodeY = mLastY;
                mLastKeyTime = (l + mCurrentKeyTime) - mLastMoveTime;
                mCurrentKey = i1;
                mCurrentKeyTime = 0L;
            }
        if(!flag2) {
            mHandler.removeMessages(4);
            if(i1 != -1) {
                Message message = mHandler.obtainMessage(4, motionevent);
                mHandler.sendMessageDelayed(message, LONGPRESS_TIMEOUT);
            }
        }
        showPreview(mCurrentKey);
        mLastMoveTime = l;
          goto _L10
_L5:
        removeMessages();
        if(i1 == mCurrentKey) {
            mCurrentKeyTime = mCurrentKeyTime + (l - mLastMoveTime);
        } else {
            resetMultiTap();
            mLastKey = mCurrentKey;
            mLastKeyTime = (l + mCurrentKeyTime) - mLastMoveTime;
            mCurrentKey = i1;
            mCurrentKeyTime = 0L;
        }
        if(mCurrentKeyTime < mLastKeyTime && mCurrentKeyTime < 70L && mLastKey != -1) {
            mCurrentKey = mLastKey;
            i = mLastCodeX;
            j = mLastCodeY;
        }
        showPreview(-1);
        Arrays.fill(mKeyIndices, -1);
        if(mRepeatKeyIndex == -1 && !mMiniKeyboardOnScreen && !mAbortKey)
            detectAndSendKey(mCurrentKey, i, j, l);
        invalidateKey(i1);
        mRepeatKeyIndex = -1;
          goto _L10
        removeMessages();
        dismissPopupKeyboard();
        mAbortKey = true;
        showPreview(-1);
        invalidateKey(mCurrentKey);
          goto _L10
    }

    private boolean openPopupIfRequired(MotionEvent motionevent) {
        boolean flag;
        flag = false;
        break MISSING_BLOCK_LABEL_2;
        while(true)  {
            do
                return flag;
            while(mPopupLayout == 0 || mCurrentKey < 0 || mCurrentKey >= mKeys.length);
            flag = onLongPress(mKeys[mCurrentKey]);
            if(flag) {
                mAbortKey = true;
                showPreview(-1);
            }
        }
    }

    private void removeMessages() {
        mHandler.removeMessages(3);
        mHandler.removeMessages(4);
        mHandler.removeMessages(1);
    }

    private boolean repeatKey() {
        Keyboard.Key key = mKeys[mRepeatKeyIndex];
        detectAndSendKey(mCurrentKey, key.x, key.y, mLastTapTime);
        return true;
    }

    private void resetMultiTap() {
        mLastSentIndex = -1;
        mTapCount = 0;
        mLastTapTime = -1L;
        mInMultiTap = false;
    }

    private void sendAccessibilityEventForUnicodeCharacter(int i, int j) {
        boolean flag = false;
        if(!mAccessibilityManager.isEnabled()) goto _L2; else goto _L1
_L1:
        AccessibilityEvent accessibilityevent;
        accessibilityevent = AccessibilityEvent.obtain(i);
        onInitializeAccessibilityEvent(accessibilityevent);
        if(android.provider.Settings.Secure.getInt(super.mContext.getContentResolver(), "speak_password", 0) != 0)
            flag = true;
        if(!flag && !mAudioManager.isBluetoothA2dpOn() && !mAudioManager.isWiredHeadsetOn()) goto _L4; else goto _L3
_L3:
        j;
        JVM INSTR lookupswitch 7: default 136
    //                   -6: 166
    //                   -5: 196
    //                   -4: 211
    //                   -3: 181
    //                   -2: 226
    //                   -1: 241
    //                   10: 256;
           goto _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L5:
        String s = String.valueOf((char)j);
_L14:
        accessibilityevent.getText().add(s);
        mAccessibilityManager.sendAccessibilityEvent(accessibilityevent);
_L2:
        return;
_L6:
        s = super.mContext.getString(0x10404b9);
        continue; /* Loop/switch isn't completed */
_L9:
        s = super.mContext.getString(0x10404ba);
        continue; /* Loop/switch isn't completed */
_L7:
        s = super.mContext.getString(0x10404bb);
        continue; /* Loop/switch isn't completed */
_L8:
        s = super.mContext.getString(0x10404bc);
        continue; /* Loop/switch isn't completed */
_L10:
        s = super.mContext.getString(0x10404bd);
        continue; /* Loop/switch isn't completed */
_L11:
        s = super.mContext.getString(0x10404be);
        continue; /* Loop/switch isn't completed */
_L12:
        s = super.mContext.getString(0x10404bf);
        continue; /* Loop/switch isn't completed */
_L4:
        if(!mHeadsetRequiredToHearPasswordsAnnounced) {
            if(i == 256)
                mHeadsetRequiredToHearPasswordsAnnounced = true;
            s = super.mContext.getString(0x10404ce);
        } else {
            s = super.mContext.getString(0x10404cf);
        }
        if(true) goto _L14; else goto _L13
_L13:
    }

    private void showKey(int i) {
        PopupWindow popupwindow;
        Keyboard.Key akey[];
        popupwindow = mPreviewPopup;
        akey = mKeys;
        if(i >= 0 && i < mKeys.length) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Keyboard.Key key = akey[i];
        if(key.icon == null) goto _L4; else goto _L3
_L3:
        int j;
        int k;
        int ai2[];
        TextView textview = mPreviewText;
        android.view.ViewGroup.LayoutParams layoutparams;
        int ai[];
        int ai1[];
        Drawable drawable;
        Drawable drawable1;
        if(key.iconPreview != null)
            drawable1 = key.iconPreview;
        else
            drawable1 = key.icon;
        textview.setCompoundDrawables(null, null, null, drawable1);
        mPreviewText.setText(null);
_L5:
        mPreviewText.measure(android.view.View.MeasureSpec.makeMeasureSpec(0, 0), android.view.View.MeasureSpec.makeMeasureSpec(0, 0));
        j = Math.max(mPreviewText.getMeasuredWidth(), key.width + mPreviewText.getPaddingLeft() + mPreviewText.getPaddingRight());
        k = mPreviewHeight;
        layoutparams = mPreviewText.getLayoutParams();
        if(layoutparams != null) {
            layoutparams.width = j;
            layoutparams.height = k;
        }
        if(!mPreviewCentered) {
            mPopupPreviewX = (key.x - mPreviewText.getPaddingLeft()) + super.mPaddingLeft;
            mPopupPreviewY = (key.y - k) + mPreviewOffset;
        } else {
            mPopupPreviewX = 160 - mPreviewText.getMeasuredWidth() / 2;
            mPopupPreviewY = -mPreviewText.getMeasuredHeight();
        }
        mHandler.removeMessages(2);
        getLocationInWindow(mCoordinates);
        ai = mCoordinates;
        ai[0] = ai[0] + mMiniKeyboardOffsetX;
        ai1 = mCoordinates;
        ai1[1] = ai1[1] + mMiniKeyboardOffsetY;
        drawable = mPreviewText.getBackground();
        if(key.popupResId != 0)
            ai2 = LONG_PRESSABLE_STATE_SET;
        else
            ai2 = EMPTY_STATE_SET;
        drawable.setState(ai2);
        mPopupPreviewX = mPopupPreviewX + mCoordinates[0];
        mPopupPreviewY = mPopupPreviewY + mCoordinates[1];
        getLocationOnScreen(mCoordinates);
        if(mPopupPreviewY + mCoordinates[1] < 0) {
            if(key.x + key.width <= getWidth() / 2)
                mPopupPreviewX = mPopupPreviewX + (int)(2.5D * (double)key.width);
            else
                mPopupPreviewX = mPopupPreviewX - (int)(2.5D * (double)key.width);
            mPopupPreviewY = k + mPopupPreviewY;
        }
        if(popupwindow.isShowing()) {
            popupwindow.update(mPopupPreviewX, mPopupPreviewY, j, k);
        } else {
            popupwindow.setWidth(j);
            popupwindow.setHeight(k);
            popupwindow.showAtLocation(mPopupParent, 0, mPopupPreviewX, mPopupPreviewY);
        }
        mPreviewText.setVisibility(0);
        if(true) goto _L1; else goto _L4
_L4:
        mPreviewText.setCompoundDrawables(null, null, null, null);
        mPreviewText.setText(getPreviewText(key));
        if(key.label.length() > 1 && key.codes.length < 2) {
            mPreviewText.setTextSize(0, mKeyTextSize);
            mPreviewText.setTypeface(Typeface.DEFAULT_BOLD);
        } else {
            mPreviewText.setTextSize(0, mPreviewTextSizeLarge);
            mPreviewText.setTypeface(Typeface.DEFAULT);
        }
          goto _L5
    }

    private void showPreview(int i) {
        int j = mCurrentKeyIndex;
        PopupWindow popupwindow = mPreviewPopup;
        mCurrentKeyIndex = i;
        Keyboard.Key akey[] = mKeys;
        if(j != mCurrentKeyIndex) {
            if(j != -1 && akey.length > j) {
                Keyboard.Key key1 = akey[j];
                Keyboard.Key key;
                int k;
                boolean flag;
                int l;
                if(mCurrentKeyIndex == -1)
                    flag = true;
                else
                    flag = false;
                key1.onReleased(flag);
                invalidateKey(j);
                l = key1.codes[0];
                sendAccessibilityEventForUnicodeCharacter(256, l);
                sendAccessibilityEventForUnicodeCharacter(0x10000, l);
            }
            if(mCurrentKeyIndex != -1 && akey.length > mCurrentKeyIndex) {
                key = akey[mCurrentKeyIndex];
                key.onPressed();
                invalidateKey(mCurrentKeyIndex);
                k = key.codes[0];
                sendAccessibilityEventForUnicodeCharacter(128, k);
                sendAccessibilityEventForUnicodeCharacter(32768, k);
            }
        }
        if(j != mCurrentKeyIndex && mShowPreview) {
            mHandler.removeMessages(1);
            if(popupwindow.isShowing() && i == -1)
                mHandler.sendMessageDelayed(mHandler.obtainMessage(2), 70L);
            if(i != -1)
                if(popupwindow.isShowing() && mPreviewText.getVisibility() == 0)
                    showKey(i);
                else
                    mHandler.sendMessageDelayed(mHandler.obtainMessage(1, i, 0), 0L);
        }
    }

    public void closing() {
        if(mPreviewPopup.isShowing())
            mPreviewPopup.dismiss();
        removeMessages();
        dismissPopupKeyboard();
        mBuffer = null;
        mCanvas = null;
        mMiniKeyboardCache.clear();
    }

    public Keyboard getKeyboard() {
        return mKeyboard;
    }

    protected OnKeyboardActionListener getOnKeyboardActionListener() {
        return mKeyboardActionListener;
    }

    public boolean handleBack() {
        boolean flag;
        if(mPopupKeyboard.isShowing()) {
            dismissPopupKeyboard();
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public void invalidateAllKeys() {
        mDirtyRect.union(0, 0, getWidth(), getHeight());
        mDrawPending = true;
        invalidate();
    }

    public void invalidateKey(int i) {
        if(mKeys != null && i >= 0 && i < mKeys.length) {
            Keyboard.Key key = mKeys[i];
            mInvalidatedKey = key;
            mDirtyRect.union(key.x + super.mPaddingLeft, key.y + super.mPaddingTop, key.x + key.width + super.mPaddingLeft, key.y + key.height + super.mPaddingTop);
            onBufferDraw();
            invalidate(key.x + super.mPaddingLeft, key.y + super.mPaddingTop, key.x + key.width + super.mPaddingLeft, key.y + key.height + super.mPaddingTop);
        }
    }

    public boolean isPreviewEnabled() {
        return mShowPreview;
    }

    public boolean isProximityCorrectionEnabled() {
        return mProximityCorrectOn;
    }

    public boolean isShifted() {
        boolean flag;
        if(mKeyboard != null)
            flag = mKeyboard.isShifted();
        else
            flag = false;
        return flag;
    }

    public void onClick(View view) {
        dismissPopupKeyboard();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        closing();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(mDrawPending || mBuffer == null || mKeyboardChanged)
            onBufferDraw();
        canvas.drawBitmap(mBuffer, 0.0F, 0.0F, null);
    }

    public boolean onHoverEvent(MotionEvent motionevent) {
        boolean flag = true;
        if(!mAccessibilityManager.isTouchExplorationEnabled() || motionevent.getPointerCount() != flag) goto _L2; else goto _L1
_L1:
        motionevent.getAction();
        JVM INSTR tableswitch 7 10: default 56
    //                   7 72
    //                   8 56
    //                   9 64
    //                   10 80;
           goto _L3 _L4 _L3 _L5 _L6
_L3:
        flag = onTouchEvent(motionevent);
_L2:
        return flag;
_L5:
        motionevent.setAction(0);
        continue; /* Loop/switch isn't completed */
_L4:
        motionevent.setAction(2);
        continue; /* Loop/switch isn't completed */
_L6:
        motionevent.setAction(flag);
        if(true) goto _L3; else goto _L7
_L7:
    }

    protected boolean onLongPress(Keyboard.Key key) {
        boolean flag = false;
        int i = key.popupResId;
        if(i != 0) {
            mMiniKeyboardContainer = (View)mMiniKeyboardCache.get(key);
            int j;
            int l;
            if(mMiniKeyboardContainer == null) {
                mMiniKeyboardContainer = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(mPopupLayout, null);
                mMiniKeyboard = (KeyboardView)mMiniKeyboardContainer.findViewById(0x1020026);
                View view = mMiniKeyboardContainer.findViewById(0x1020027);
                if(view != null)
                    view.setOnClickListener(this);
                mMiniKeyboard.setOnKeyboardActionListener(new OnKeyboardActionListener() {

                    public void onKey(int i1, int ai[]) {
                        mKeyboardActionListener.onKey(i1, ai);
                        dismissPopupKeyboard();
                    }

                    public void onPress(int i1) {
                        mKeyboardActionListener.onPress(i1);
                    }

                    public void onRelease(int i1) {
                        mKeyboardActionListener.onRelease(i1);
                    }

                    public void onText(CharSequence charsequence) {
                        mKeyboardActionListener.onText(charsequence);
                        dismissPopupKeyboard();
                    }

                    public void swipeDown() {
                    }

                    public void swipeLeft() {
                    }

                    public void swipeRight() {
                    }

                    public void swipeUp() {
                    }

                    final KeyboardView this$0;

             {
                this$0 = KeyboardView.this;
                super();
            }
                });
                int k;
                KeyboardView keyboardview;
                Keyboard keyboard;
                if(key.popupCharacters != null)
                    keyboard = new Keyboard(getContext(), i, key.popupCharacters, -1, getPaddingLeft() + getPaddingRight());
                else
                    keyboard = new Keyboard(getContext(), i);
                mMiniKeyboard.setKeyboard(keyboard);
                mMiniKeyboard.setPopupParent(this);
                mMiniKeyboardContainer.measure(android.view.View.MeasureSpec.makeMeasureSpec(getWidth(), 0x80000000), android.view.View.MeasureSpec.makeMeasureSpec(getHeight(), 0x80000000));
                mMiniKeyboardCache.put(key, mMiniKeyboardContainer);
            } else {
                mMiniKeyboard = (KeyboardView)mMiniKeyboardContainer.findViewById(0x1020026);
            }
            getLocationInWindow(mCoordinates);
            mPopupX = key.x + super.mPaddingLeft;
            mPopupY = key.y + super.mPaddingTop;
            mPopupX = (mPopupX + key.width) - mMiniKeyboardContainer.getMeasuredWidth();
            mPopupY = mPopupY - mMiniKeyboardContainer.getMeasuredHeight();
            j = mPopupX + mMiniKeyboardContainer.getPaddingRight() + mCoordinates[0];
            k = mPopupY + mMiniKeyboardContainer.getPaddingBottom() + mCoordinates[1];
            keyboardview = mMiniKeyboard;
            if(j < 0)
                l = 0;
            else
                l = j;
            keyboardview.setPopupOffset(l, k);
            mMiniKeyboard.setShifted(isShifted());
            mPopupKeyboard.setContentView(mMiniKeyboardContainer);
            mPopupKeyboard.setWidth(mMiniKeyboardContainer.getMeasuredWidth());
            mPopupKeyboard.setHeight(mMiniKeyboardContainer.getMeasuredHeight());
            mPopupKeyboard.showAtLocation(this, 0, j, k);
            mMiniKeyboardOnScreen = true;
            invalidateAllKeys();
            flag = true;
        }
        return flag;
    }

    public void onMeasure(int i, int j) {
        if(mKeyboard == null) {
            setMeasuredDimension(super.mPaddingLeft + super.mPaddingRight, super.mPaddingTop + super.mPaddingBottom);
        } else {
            int k = mKeyboard.getMinWidth() + super.mPaddingLeft + super.mPaddingRight;
            if(android.view.View.MeasureSpec.getSize(i) < k + 10)
                k = android.view.View.MeasureSpec.getSize(i);
            setMeasuredDimension(k, mKeyboard.getHeight() + super.mPaddingTop + super.mPaddingBottom);
        }
    }

    public void onSizeChanged(int i, int j, int k, int l) {
        super.onSizeChanged(i, j, k, l);
        if(mKeyboard != null)
            mKeyboard.resize(i, j);
        mBuffer = null;
    }

    public boolean onTouchEvent(MotionEvent motionevent) {
        int i = motionevent.getPointerCount();
        int j = motionevent.getAction();
        long l = motionevent.getEventTime();
        boolean flag;
        if(i != mOldPointerCount) {
            if(i == 1) {
                MotionEvent motionevent2 = MotionEvent.obtain(l, l, 0, motionevent.getX(), motionevent.getY(), motionevent.getMetaState());
                flag = onModifiedTouchEvent(motionevent2, false);
                motionevent2.recycle();
                if(j == 1)
                    flag = onModifiedTouchEvent(motionevent, true);
            } else {
                MotionEvent motionevent1 = MotionEvent.obtain(l, l, 1, mOldPointerX, mOldPointerY, motionevent.getMetaState());
                flag = onModifiedTouchEvent(motionevent1, true);
                motionevent1.recycle();
            }
        } else
        if(i == 1) {
            flag = onModifiedTouchEvent(motionevent, false);
            mOldPointerX = motionevent.getX();
            mOldPointerY = motionevent.getY();
        } else {
            flag = true;
        }
        mOldPointerCount = i;
        return flag;
    }

    public void setKeyboard(Keyboard keyboard) {
        if(mKeyboard != null)
            showPreview(-1);
        removeMessages();
        mKeyboard = keyboard;
        List list = mKeyboard.getKeys();
        mKeys = (Keyboard.Key[])list.toArray(new Keyboard.Key[list.size()]);
        requestLayout();
        mKeyboardChanged = true;
        invalidateAllKeys();
        computeProximityThreshold(keyboard);
        mMiniKeyboardCache.clear();
        mAbortKey = true;
    }

    public void setOnKeyboardActionListener(OnKeyboardActionListener onkeyboardactionlistener) {
        mKeyboardActionListener = onkeyboardactionlistener;
    }

    public void setPopupOffset(int i, int j) {
        mMiniKeyboardOffsetX = i;
        mMiniKeyboardOffsetY = j;
        if(mPreviewPopup.isShowing())
            mPreviewPopup.dismiss();
    }

    public void setPopupParent(View view) {
        mPopupParent = view;
    }

    public void setPreviewEnabled(boolean flag) {
        mShowPreview = flag;
    }

    public void setProximityCorrectionEnabled(boolean flag) {
        mProximityCorrectOn = flag;
    }

    public boolean setShifted(boolean flag) {
        boolean flag1;
        if(mKeyboard != null && mKeyboard.setShifted(flag)) {
            invalidateAllKeys();
            flag1 = true;
        } else {
            flag1 = false;
        }
        return flag1;
    }

    public void setVerticalCorrection(int i) {
    }

    protected void swipeDown() {
        mKeyboardActionListener.swipeDown();
    }

    protected void swipeLeft() {
        mKeyboardActionListener.swipeLeft();
    }

    protected void swipeRight() {
        mKeyboardActionListener.swipeRight();
    }

    protected void swipeUp() {
        mKeyboardActionListener.swipeUp();
    }

    private static final int DEBOUNCE_TIME = 70;
    private static final boolean DEBUG = false;
    private static final int DELAY_AFTER_PREVIEW = 70;
    private static final int DELAY_BEFORE_PREVIEW = 0;
    private static final int KEY_DELETE[];
    private static final int LONGPRESS_TIMEOUT = 0;
    private static final int LONG_PRESSABLE_STATE_SET[];
    private static int MAX_NEARBY_KEYS = 0;
    private static final int MSG_LONGPRESS = 4;
    private static final int MSG_REMOVE_PREVIEW = 2;
    private static final int MSG_REPEAT = 3;
    private static final int MSG_SHOW_PREVIEW = 1;
    private static final int MULTITAP_INTERVAL = 800;
    private static final int NOT_A_KEY = -1;
    private static final int REPEAT_INTERVAL = 50;
    private static final int REPEAT_START_DELAY = 400;
    private boolean mAbortKey;
    private AccessibilityManager mAccessibilityManager;
    private AudioManager mAudioManager;
    private float mBackgroundDimAmount;
    private Bitmap mBuffer;
    private Canvas mCanvas;
    private Rect mClipRegion;
    private final int mCoordinates[];
    private int mCurrentKey;
    private int mCurrentKeyIndex;
    private long mCurrentKeyTime;
    private Rect mDirtyRect;
    private boolean mDisambiguateSwipe;
    private int mDistances[];
    private int mDownKey;
    private long mDownTime;
    private boolean mDrawPending;
    private GestureDetector mGestureDetector;
    Handler mHandler;
    private boolean mHeadsetRequiredToHearPasswordsAnnounced;
    private boolean mInMultiTap;
    private Keyboard.Key mInvalidatedKey;
    private Drawable mKeyBackground;
    private int mKeyIndices[];
    private int mKeyTextColor;
    private int mKeyTextSize;
    private Keyboard mKeyboard;
    private OnKeyboardActionListener mKeyboardActionListener;
    private boolean mKeyboardChanged;
    private Keyboard.Key mKeys[];
    private int mLabelTextSize;
    private int mLastCodeX;
    private int mLastCodeY;
    private int mLastKey;
    private long mLastKeyTime;
    private long mLastMoveTime;
    private int mLastSentIndex;
    private long mLastTapTime;
    private int mLastX;
    private int mLastY;
    private KeyboardView mMiniKeyboard;
    private Map mMiniKeyboardCache;
    private View mMiniKeyboardContainer;
    private int mMiniKeyboardOffsetX;
    private int mMiniKeyboardOffsetY;
    private boolean mMiniKeyboardOnScreen;
    private int mOldPointerCount;
    private float mOldPointerX;
    private float mOldPointerY;
    private Rect mPadding;
    private Paint mPaint;
    private PopupWindow mPopupKeyboard;
    private int mPopupLayout;
    private View mPopupParent;
    private int mPopupPreviewX;
    private int mPopupPreviewY;
    private int mPopupX;
    private int mPopupY;
    private boolean mPossiblePoly;
    private boolean mPreviewCentered;
    private int mPreviewHeight;
    private StringBuilder mPreviewLabel;
    private int mPreviewOffset;
    private PopupWindow mPreviewPopup;
    private TextView mPreviewText;
    private int mPreviewTextSizeLarge;
    private boolean mProximityCorrectOn;
    private int mProximityThreshold;
    private int mRepeatKeyIndex;
    private int mShadowColor;
    private float mShadowRadius;
    private boolean mShowPreview;
    private boolean mShowTouchPoints;
    private int mStartX;
    private int mStartY;
    private int mSwipeThreshold;
    private SwipeTracker mSwipeTracker;
    private int mTapCount;
    private int mVerticalCorrection;

    static  {
        int ai[] = new int[1];
        ai[0] = -5;
        KEY_DELETE = ai;
        int ai1[] = new int[1];
        ai1[0] = 0x101023c;
        LONG_PRESSABLE_STATE_SET = ai1;
        LONGPRESS_TIMEOUT = ViewConfiguration.getLongPressTimeout();
        MAX_NEARBY_KEYS = 12;
    }














}
