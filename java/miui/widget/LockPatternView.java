// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.*;
import android.os.*;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.android.internal.widget.LockPatternUtils;
import java.lang.reflect.Array;
import java.util.*;

public class LockPatternView extends View {
    private static class SavedState extends android.view.View.BaseSavedState {

        public int getDisplayMode() {
            return mDisplayMode;
        }

        public String getSerializedPattern() {
            return mSerializedPattern;
        }

        public boolean isInStealthMode() {
            return mInStealthMode;
        }

        public boolean isInputEnabled() {
            return mInputEnabled;
        }

        public boolean isTactileFeedbackEnabled() {
            return mTactileFeedbackEnabled;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(mSerializedPattern);
            parcel.writeInt(mDisplayMode);
            parcel.writeValue(Boolean.valueOf(mInputEnabled));
            parcel.writeValue(Boolean.valueOf(mInStealthMode));
            parcel.writeValue(Boolean.valueOf(mTactileFeedbackEnabled));
        }

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public volatile Object createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public volatile Object[] newArray(int i) {
                return newArray(i);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

        };
        private final int mDisplayMode;
        private final boolean mInStealthMode;
        private final boolean mInputEnabled;
        private final String mSerializedPattern;
        private final boolean mTactileFeedbackEnabled;


        private SavedState(Parcel parcel) {
            super(parcel);
            mSerializedPattern = parcel.readString();
            mDisplayMode = parcel.readInt();
            mInputEnabled = ((Boolean)parcel.readValue(null)).booleanValue();
            mInStealthMode = ((Boolean)parcel.readValue(null)).booleanValue();
            mTactileFeedbackEnabled = ((Boolean)parcel.readValue(null)).booleanValue();
        }


        private SavedState(Parcelable parcelable, String s, int i, boolean flag, boolean flag1, boolean flag2) {
            super(parcelable);
            mSerializedPattern = s;
            mDisplayMode = i;
            mInputEnabled = flag;
            mInStealthMode = flag1;
            mTactileFeedbackEnabled = flag2;
        }

    }

    public static interface OnPatternListener {

        public abstract void onPatternCellAdded(List list);

        public abstract void onPatternCleared();

        public abstract void onPatternDetected(List list);

        public abstract void onPatternStart();
    }

    public static final class DisplayMode extends Enum {

        public static DisplayMode valueOf(String s) {
            return (DisplayMode)Enum.valueOf(miui/widget/LockPatternView$DisplayMode, s);
        }

        public static DisplayMode[] values() {
            return (DisplayMode[])$VALUES.clone();
        }

        private static final DisplayMode $VALUES[];
        public static final DisplayMode Animate;
        public static final DisplayMode Correct;
        public static final DisplayMode Wrong;

        static  {
            Correct = new DisplayMode("Correct", 0);
            Animate = new DisplayMode("Animate", 1);
            Wrong = new DisplayMode("Wrong", 2);
            DisplayMode adisplaymode[] = new DisplayMode[3];
            adisplaymode[0] = Correct;
            adisplaymode[1] = Animate;
            adisplaymode[2] = Wrong;
            $VALUES = adisplaymode;
        }

        private DisplayMode(String s, int i) {
            super(s, i);
        }
    }


    public LockPatternView(Context context) {
        this(context, null);
    }

    public LockPatternView(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        mDrawingProfilingStarted = false;
        mPaint = new Paint();
        mPathPaint = new Paint();
        mPattern = new ArrayList(9);
        int ai[] = new int[2];
        ai[0] = 3;
        ai[1] = 3;
        mPatternDrawLookup = (boolean[][])Array.newInstance(Boolean.TYPE, ai);
        mInProgressX = -1F;
        mInProgressY = -1F;
        mPatternDisplayMode = DisplayMode.Correct;
        mInputEnabled = true;
        mInStealthMode = false;
        mEnableHapticFeedback = true;
        mPatternInProgress = false;
        mDiameterFactor = 0.1F;
        mStrokeAlpha = 64;
        mHitFactor = 0.6F;
        mCurrentPath = new Path();
        mInvalidate = new Rect();
        mArrowMatrix = new Matrix();
        mCircleMatrix = new Matrix();
        loadAttrs(context, attributeset);
        setClickable(true);
        mPathPaint.setAntiAlias(true);
        mPathPaint.setDither(true);
        mPathPaint.setAlpha(mStrokeAlpha);
        mPathPaint.setStyle(android.graphics.Paint.Style.STROKE);
        mPathPaint.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        mPathPaint.setStrokeCap(android.graphics.Paint.Cap.ROUND);
    }

    private void addCellToPattern(com.android.internal.widget.Cell cell) {
        mPatternDrawLookup[cell.getRow()][cell.getColumn()] = true;
        mPattern.add(cell);
        notifyCellAdded();
    }

    private com.android.internal.widget.Cell checkForNewHit(float f, float f1) {
        com.android.internal.widget.Cell cell;
        int i;
        cell = null;
        i = getRowHit(f1);
        if(i >= 0) goto _L2; else goto _L1
_L1:
        return cell;
_L2:
        int j = getColumnHit(f);
        if(j >= 0 && !mPatternDrawLookup[i][j])
            cell = com.android.internal.widget.Cell.of(i, j);
        if(true) goto _L1; else goto _L3
_L3:
    }

    private void clearPatternDrawLookup() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++)
                mPatternDrawLookup[i][j] = false;

        }

    }

    private com.android.internal.widget.Cell detectAndAddHit(float f, float f1) {
        byte byte0 = -1;
        com.android.internal.widget.Cell cell = checkForNewHit(f, f1);
        if(cell != null) {
            com.android.internal.widget.Cell cell1 = null;
            ArrayList arraylist = mPattern;
            if(!arraylist.isEmpty()) {
                com.android.internal.widget.Cell cell2 = (com.android.internal.widget.Cell)arraylist.get(-1 + arraylist.size());
                int i = cell.getRow() - cell2.getRow();
                int j = cell.getColumn() - cell2.getColumn();
                int k = cell2.getRow();
                int l = cell2.getColumn();
                if(Math.abs(i) == 2 && Math.abs(j) != 1) {
                    int j1 = cell2.getRow();
                    int i1;
                    int k1;
                    if(i > 0)
                        k1 = 1;
                    else
                        k1 = byte0;
                    k = j1 + k1;
                }
                if(Math.abs(j) == 2 && Math.abs(i) != 1) {
                    i1 = cell2.getColumn();
                    if(j > 0)
                        byte0 = 1;
                    l = i1 + byte0;
                }
                cell1 = com.android.internal.widget.Cell.of(k, l);
            }
            if(cell1 != null && !mPatternDrawLookup[cell1.getRow()][cell1.getColumn()])
                addCellToPattern(cell1);
            addCellToPattern(cell);
            if(mEnableHapticFeedback)
                performHapticFeedback(1, 3);
        } else {
            cell = null;
        }
        return cell;
    }

    private void drawArrow(Canvas canvas, float f, float f1, com.android.internal.widget.Cell cell, com.android.internal.widget.Cell cell1) {
        boolean flag;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        Bitmap bitmap;
        int k1;
        int l1;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        if(mPatternDisplayMode != DisplayMode.Wrong)
            flag = true;
        else
            flag = false;
        i = cell1.getRow();
        j = cell.getRow();
        k = cell1.getColumn();
        l = cell.getColumn();
        i1 = ((int)mSquareWidth - mBitmapWidth) / 2;
        j1 = ((int)mSquareHeight - mBitmapHeight) / 2;
        if(flag)
            bitmap = mBitmapArrowGreenUp;
        else
            bitmap = mBitmapArrowRedUp;
        k1 = mBitmapWidth;
        l1 = mBitmapHeight;
        f2 = 90F + (float)Math.toDegrees((float)Math.atan2(i - j, k - l));
        f3 = i - j;
        f4 = k - l;
        f5 = (float)(((double)mSquareHeight * Math.sqrt(f4 * f4 + f3 * f3) - (double)mBitmapHeight) + (double)bitmap.getHeight()) / 2.0F;
        f6 = Math.min(mSquareWidth / (float)mBitmapWidth, 1.0F);
        f7 = Math.min(mSquareHeight / (float)mBitmapHeight, 1.0F);
        mArrowMatrix.setTranslate(f + (float)i1, f1 + (float)j1);
        mArrowMatrix.preTranslate(mBitmapWidth / 2, mBitmapHeight / 2);
        mArrowMatrix.preScale(f6, f7);
        mArrowMatrix.preTranslate(-mBitmapWidth / 2, -mBitmapHeight / 2);
        mArrowMatrix.preRotate(f2, (float)k1 / 2.0F, (float)l1 / 2.0F);
        mArrowMatrix.preTranslate((float)(k1 - bitmap.getWidth()) / 2.0F, -f5);
        canvas.drawBitmap(bitmap, mArrowMatrix, mPaint);
    }

    private void drawCircle(Canvas canvas, int i, int j, boolean flag) {
        Bitmap bitmap;
        Bitmap bitmap1;
        int k;
        int l;
        float f;
        float f1;
        int i1;
        int j1;
        float f2;
        float f3;
        if(!flag || mInStealthMode && mPatternDisplayMode != DisplayMode.Wrong) {
            bitmap = mBitmapCircleDefault;
            bitmap1 = mBitmapBtnDefaultWithBackground;
        } else
        if(mPatternInProgress) {
            bitmap = mBitmapCircleGreen;
            bitmap1 = mBitmapBtnTouched;
        } else
        if(mPatternDisplayMode == DisplayMode.Wrong) {
            bitmap = mBitmapCircleRed;
            bitmap1 = mBitmapBtnDefault;
        } else
        if(mPatternDisplayMode == DisplayMode.Correct || mPatternDisplayMode == DisplayMode.Animate) {
            bitmap = mBitmapCircleGreen;
            bitmap1 = mBitmapBtnDefault;
        } else {
            throw new IllegalStateException((new StringBuilder()).append("unknown display mode ").append(mPatternDisplayMode).toString());
        }
        k = mBitmapWidth;
        l = mBitmapHeight;
        f = mSquareWidth;
        f1 = mSquareHeight;
        i1 = (int)((f - (float)k) / 2.0F);
        j1 = (int)((f1 - (float)l) / 2.0F);
        f2 = Math.min(mSquareWidth / (float)mBitmapWidth, 1.0F);
        f3 = Math.min(mSquareHeight / (float)mBitmapHeight, 1.0F);
        mCircleMatrix.setTranslate(i + i1, j + j1);
        mCircleMatrix.preTranslate(mBitmapWidth / 2, mBitmapHeight / 2);
        mCircleMatrix.preScale(f2, f3);
        mCircleMatrix.preTranslate(-mBitmapWidth / 2, -mBitmapHeight / 2);
        canvas.drawBitmap(bitmap, mCircleMatrix, mPaint);
        canvas.drawBitmap(bitmap1, mCircleMatrix, mPaint);
    }

    private Bitmap getBitmapFor(int i) {
        return BitmapFactory.decodeResource(getContext().getResources(), i);
    }

    private float getCenterXForColumn(int i) {
        return (float)super.mPaddingLeft + (float)i * mSquareWidth + mSquareWidth / 2.0F;
    }

    private float getCenterYForRow(int i) {
        return (float)super.mPaddingTop + (float)i * mSquareHeight + mSquareHeight / 2.0F;
    }

    private int getColumnHit(float f) {
        float f1;
        float f2;
        float f3;
        int i;
        f1 = mSquareWidth;
        f2 = f1 * mHitFactor;
        f3 = (float)super.mPaddingLeft + (f1 - f2) / 2.0F;
        i = 0;
_L3:
        float f4;
        if(i >= 3)
            break MISSING_BLOCK_LABEL_69;
        f4 = f3 + f1 * (float)i;
        if(f < f4 || f > f4 + f2) goto _L2; else goto _L1
_L1:
        return i;
_L2:
        i++;
          goto _L3
        i = -1;
          goto _L1
    }

    private int getRowHit(float f) {
        float f1;
        float f2;
        float f3;
        int i;
        f1 = mSquareHeight;
        f2 = f1 * mHitFactor;
        f3 = (float)super.mPaddingTop + (f1 - f2) / 2.0F;
        i = 0;
_L3:
        float f4;
        if(i >= 3)
            break MISSING_BLOCK_LABEL_69;
        f4 = f3 + f1 * (float)i;
        if(f < f4 || f > f4 + f2) goto _L2; else goto _L1
_L1:
        return i;
_L2:
        i++;
          goto _L3
        i = -1;
          goto _L1
    }

    private void handleActionDown(MotionEvent motionevent) {
        resetPattern();
        float f = motionevent.getX();
        float f1 = motionevent.getY();
        com.android.internal.widget.Cell cell = detectAndAddHit(f, f1);
        if(cell != null) {
            mPatternInProgress = true;
            mPatternDisplayMode = DisplayMode.Correct;
            notifyPatternStarted();
        } else {
            mPatternInProgress = false;
            notifyPatternCleared();
        }
        if(cell != null) {
            float f2 = getCenterXForColumn(cell.getColumn());
            float f3 = getCenterYForRow(cell.getRow());
            float f4 = mSquareWidth / 2.0F;
            float f5 = mSquareHeight / 2.0F;
            invalidate((int)(f2 - f4), (int)(f3 - f5), (int)(f2 + f4), (int)(f3 + f5));
        }
        mInProgressX = f;
        mInProgressY = f1;
    }

    private void handleActionMove(MotionEvent motionevent) {
        int i = motionevent.getHistorySize();
        int j = 0;
        while(j < i + 1)  {
            float f;
            float f1;
            int k;
            com.android.internal.widget.Cell cell;
            int l;
            if(j < i)
                f = motionevent.getHistoricalX(j);
            else
                f = motionevent.getX();
            if(j < i)
                f1 = motionevent.getHistoricalY(j);
            else
                f1 = motionevent.getY();
            k = mPattern.size();
            cell = detectAndAddHit(f, f1);
            l = mPattern.size();
            if(cell != null && l == 1) {
                mPatternInProgress = true;
                notifyPatternStarted();
            }
            if(Math.abs(f - mInProgressX) + Math.abs(f1 - mInProgressY) > 0.01F * mSquareWidth) {
                float f2 = mInProgressX;
                float f3 = mInProgressY;
                mInProgressX = f;
                mInProgressY = f1;
                if(mPatternInProgress && l > 0) {
                    ArrayList arraylist = mPattern;
                    float f4 = 0.5F * (mSquareWidth * mDiameterFactor);
                    com.android.internal.widget.Cell cell1 = (com.android.internal.widget.Cell)arraylist.get(l - 1);
                    float f5 = getCenterXForColumn(cell1.getColumn());
                    float f6 = getCenterYForRow(cell1.getRow());
                    Rect rect = mInvalidate;
                    float f7;
                    float f8;
                    float f9;
                    float f10;
                    float f11;
                    float f12;
                    float f13;
                    float f14;
                    if(f5 < f) {
                        f7 = f5;
                        f8 = f;
                    } else {
                        f7 = f;
                        f8 = f5;
                    }
                    if(f6 < f1) {
                        f9 = f6;
                        f10 = f1;
                    } else {
                        f9 = f1;
                        f10 = f6;
                    }
                    rect.set((int)(f7 - f4), (int)(f9 - f4), (int)(f8 + f4), (int)(f10 + f4));
                    if(f5 < f2) {
                        f11 = f5;
                        f12 = f2;
                    } else {
                        f11 = f2;
                        f12 = f5;
                    }
                    if(f6 < f3) {
                        f13 = f6;
                        f14 = f3;
                    } else {
                        f13 = f3;
                        f14 = f6;
                    }
                    rect.union((int)(f11 - f4), (int)(f13 - f4), (int)(f12 + f4), (int)(f14 + f4));
                    if(cell != null) {
                        float f15 = getCenterXForColumn(cell.getColumn());
                        float f16 = getCenterYForRow(cell.getRow());
                        float f17;
                        float f18;
                        float f19;
                        float f20;
                        if(l >= 2) {
                            com.android.internal.widget.Cell cell2 = (com.android.internal.widget.Cell)arraylist.get(l - 1 - (l - k));
                            float f23 = getCenterXForColumn(cell2.getColumn());
                            float f24 = getCenterYForRow(cell2.getRow());
                            float f21;
                            float f22;
                            if(f15 < f23) {
                                f18 = f15;
                                f17 = f23;
                            } else {
                                f18 = f23;
                                f17 = f15;
                            }
                            if(f16 < f24) {
                                f20 = f16;
                                f19 = f24;
                            } else {
                                f20 = f24;
                                f19 = f16;
                            }
                        } else {
                            f17 = f15;
                            f18 = f15;
                            f19 = f16;
                            f20 = f16;
                        }
                        f21 = mSquareWidth / 2.0F;
                        f22 = mSquareHeight / 2.0F;
                        rect.set((int)(f18 - f21), (int)(f20 - f22), (int)(f17 + f21), (int)(f19 + f22));
                    }
                    invalidate(rect);
                } else {
                    invalidate();
                }
            }
            j++;
        }
    }

    private void handleActionUp(MotionEvent motionevent) {
        if(!mPattern.isEmpty()) {
            mPatternInProgress = false;
            notifyPatternDetected();
            invalidate();
        }
    }

    private void loadAttrs(Context context, AttributeSet attributeset) {
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, miui.R.styleable.LockPatternView);
        String s = typedarray.getString(0);
        Bitmap abitmap[];
        int i;
        if("square".equals(s))
            mAspect = 0;
        else
        if("lock_width".equals(s))
            mAspect = 1;
        else
        if("lock_height".equals(s))
            mAspect = 2;
        else
            mAspect = 0;
        mPathPaint.setColor(typedarray.getColor(1, -1));
        mDiameterFactor = typedarray.getFloat(2, 0.1F);
        mStrokeAlpha = typedarray.getInteger(11, 128);
        mBitmapBtnDefaultWithBackground = getBitmapFor(typedarray.getResourceId(4, 0x6020033));
        mBitmapBtnDefault = getBitmapFor(typedarray.getResourceId(3, 0x6020055));
        mBitmapBtnTouched = getBitmapFor(typedarray.getResourceId(5, 0x6020056));
        mBitmapCircleDefault = getBitmapFor(typedarray.getResourceId(6, 0x6020057));
        mBitmapCircleGreen = getBitmapFor(typedarray.getResourceId(7, 0x6020058));
        mBitmapCircleRed = getBitmapFor(typedarray.getResourceId(8, 0x6020038));
        mBitmapArrowGreenUp = getBitmapFor(typedarray.getResourceId(9, 0x6020039));
        mBitmapArrowRedUp = getBitmapFor(typedarray.getResourceId(10, 0x6020032));
        abitmap = new Bitmap[5];
        abitmap[0] = mBitmapBtnDefault;
        abitmap[1] = mBitmapBtnTouched;
        abitmap[2] = mBitmapCircleDefault;
        abitmap[3] = mBitmapCircleGreen;
        abitmap[4] = mBitmapCircleRed;
        i = abitmap.length;
        for(int j = 0; j < i; j++) {
            Bitmap bitmap = abitmap[j];
            mBitmapWidth = Math.max(mBitmapWidth, bitmap.getWidth());
            mBitmapHeight = Math.max(mBitmapHeight, bitmap.getHeight());
        }

    }

    private void notifyCellAdded() {
        if(mOnPatternListener != null)
            mOnPatternListener.onPatternCellAdded(mPattern);
        sendAccessEvent(0x60c01b3);
    }

    private void notifyPatternCleared() {
        if(mOnPatternListener != null)
            mOnPatternListener.onPatternCleared();
        sendAccessEvent(0x60c01b2);
    }

    private void notifyPatternDetected() {
        if(mOnPatternListener != null)
            mOnPatternListener.onPatternDetected(mPattern);
        sendAccessEvent(0x60c01b4);
    }

    private void notifyPatternStarted() {
        if(mOnPatternListener != null)
            mOnPatternListener.onPatternStart();
        sendAccessEvent(0x60c01b1);
    }

    private void resetPattern() {
        mPattern.clear();
        clearPatternDrawLookup();
        mPatternDisplayMode = DisplayMode.Correct;
        invalidate();
    }

    private int resolveMeasured(int i, int j) {
        int k = android.view.View.MeasureSpec.getSize(i);
        android.view.View.MeasureSpec.getMode(i);
        JVM INSTR lookupswitch 2: default 36
    //                   -2147483648: 48
    //                   0: 42;
           goto _L1 _L2 _L3
_L1:
        int l = k;
_L5:
        return l;
_L3:
        l = j;
        continue; /* Loop/switch isn't completed */
_L2:
        l = Math.max(k, j);
        if(true) goto _L5; else goto _L4
_L4:
    }

    private void sendAccessEvent(int i) {
        setContentDescription(super.mContext.getString(i));
        sendAccessibilityEvent(4);
        setContentDescription(null);
    }

    public void clearPattern() {
        resetPattern();
    }

    public void disableInput() {
        mInputEnabled = false;
    }

    public void enableInput() {
        mInputEnabled = true;
    }

    protected int getSuggestedMinimumHeight() {
        return 3 * mBitmapWidth;
    }

    protected int getSuggestedMinimumWidth() {
        return 3 * mBitmapWidth;
    }

    public boolean isInStealthMode() {
        return mInStealthMode;
    }

    public boolean isTactileFeedbackEnabled() {
        return mEnableHapticFeedback;
    }

    protected void onDraw(Canvas canvas) {
        float f;
        float f1;
        Path path;
        int j;
        int k;
        boolean flag2;
        int i1;
        com.android.internal.widget.Cell cell;
        int j1;
        com.android.internal.widget.Cell cell1;
        com.android.internal.widget.Cell cell2;
        ArrayList arraylist = mPattern;
        int i = arraylist.size();
        boolean aflag[][] = mPatternDrawLookup;
        if(mPatternDisplayMode == DisplayMode.Animate) {
            int i2 = 700 * (i + 1);
            int j2 = (int)(SystemClock.elapsedRealtime() - mAnimatingPeriodStart) % i2;
            int k2 = j2 / 700;
            clearPatternDrawLookup();
            for(int l2 = 0; l2 < k2; l2++) {
                com.android.internal.widget.Cell cell5 = (com.android.internal.widget.Cell)arraylist.get(l2);
                aflag[cell5.getRow()][cell5.getColumn()] = true;
            }

            float f2;
            float f5;
            int l1;
            boolean flag3;
            if(k2 > 0 && k2 < i)
                flag3 = true;
            else
                flag3 = false;
            if(flag3) {
                float f6 = (float)(j2 % 700) / 700F;
                com.android.internal.widget.Cell cell3 = (com.android.internal.widget.Cell)arraylist.get(k2 - 1);
                float f7 = getCenterXForColumn(cell3.getColumn());
                float f8 = getCenterYForRow(cell3.getRow());
                com.android.internal.widget.Cell cell4 = (com.android.internal.widget.Cell)arraylist.get(k2);
                float f9 = f6 * (getCenterXForColumn(cell4.getColumn()) - f7);
                float f10 = f6 * (getCenterYForRow(cell4.getRow()) - f8);
                mInProgressX = f7 + f9;
                mInProgressY = f8 + f10;
            }
            invalidate();
        }
        f = mSquareWidth;
        f1 = mSquareHeight;
        f2 = 0.5F * (f * mDiameterFactor);
        mPathPaint.setStrokeWidth(f2);
        path = mCurrentPath;
        path.rewind();
        j = super.mPaddingTop;
        k = super.mPaddingLeft;
        for(int l = 0; l < 3; l++) {
            f5 = (float)j + f1 * (float)l;
            for(l1 = 0; l1 < 3; l1++)
                drawCircle(canvas, (int)((float)k + f * (float)l1), (int)f5, aflag[l][l1]);

        }

        boolean flag;
        boolean flag1;
        int k1;
        if(!mInStealthMode || mPatternDisplayMode == DisplayMode.Wrong)
            flag = true;
        else
            flag = false;
        if((2 & mPaint.getFlags()) != 0)
            flag1 = true;
        else
            flag1 = false;
        mPaint.setFilterBitmap(true);
        if(!flag) goto _L2; else goto _L1
_L1:
        j1 = 0;
_L7:
        k1 = i - 1;
        if(j1 >= k1) goto _L2; else goto _L3
_L3:
        cell1 = (com.android.internal.widget.Cell)arraylist.get(j1);
        cell2 = (com.android.internal.widget.Cell)arraylist.get(j1 + 1);
        if(aflag[cell2.getRow()][cell2.getColumn()]) goto _L4; else goto _L2
_L2:
        if(!flag) goto _L6; else goto _L5
_L5:
        flag2 = false;
        i1 = 0;
_L8:
        if(i1 < i) {
            cell = (com.android.internal.widget.Cell)arraylist.get(i1);
            if(aflag[cell.getRow()][cell.getColumn()])
                break MISSING_BLOCK_LABEL_626;
        }
        if((mPatternInProgress || mPatternDisplayMode == DisplayMode.Animate) && flag2)
            path.lineTo(mInProgressX, mInProgressY);
        canvas.drawPath(path, mPathPaint);
_L6:
        mPaint.setFilterBitmap(flag1);
        return;
_L4:
        drawArrow(canvas, (float)k + f * (float)cell1.getColumn(), (float)j + f1 * (float)cell1.getRow(), cell1, cell2);
        j1++;
          goto _L7
        flag2 = true;
        float f3 = getCenterXForColumn(cell.getColumn());
        float f4 = getCenterYForRow(cell.getRow());
        if(i1 == 0)
            path.moveTo(f3, f4);
        else
            path.lineTo(f3, f4);
        i1++;
          goto _L8
    }

    public boolean onHoverEvent(MotionEvent motionevent) {
        if(!AccessibilityManager.getInstance(super.mContext).isTouchExplorationEnabled()) goto _L2; else goto _L1
_L1:
        int i = motionevent.getAction();
        i;
        JVM INSTR tableswitch 7 10: default 48
    //                   7 73
    //                   8 48
    //                   9 65
    //                   10 81;
           goto _L3 _L4 _L3 _L5 _L6
_L3:
        onTouchEvent(motionevent);
        motionevent.setAction(i);
_L2:
        return super.onHoverEvent(motionevent);
_L5:
        motionevent.setAction(0);
        continue; /* Loop/switch isn't completed */
_L4:
        motionevent.setAction(2);
        continue; /* Loop/switch isn't completed */
_L6:
        motionevent.setAction(1);
        if(true) goto _L3; else goto _L7
_L7:
    }

    protected void onMeasure(int i, int j) {
        int i1;
        int j1;
        int k = getSuggestedMinimumWidth();
        int l = getSuggestedMinimumHeight();
        i1 = resolveMeasured(i, k);
        j1 = resolveMeasured(j, l);
        mAspect;
        JVM INSTR tableswitch 0 2: default 60
    //                   0 69
    //                   1 85
    //                   2 97;
           goto _L1 _L2 _L3 _L4
_L1:
        setMeasuredDimension(i1, j1);
        return;
_L2:
        j1 = Math.min(i1, j1);
        i1 = j1;
        continue; /* Loop/switch isn't completed */
_L3:
        j1 = Math.min(i1, j1);
        continue; /* Loop/switch isn't completed */
_L4:
        i1 = Math.min(i1, j1);
        if(true) goto _L1; else goto _L5
_L5:
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedstate = (SavedState)parcelable;
        super.onRestoreInstanceState(savedstate.getSuperState());
        setPattern(DisplayMode.Correct, LockPatternUtils.stringToPattern(savedstate.getSerializedPattern()));
        mPatternDisplayMode = DisplayMode.values()[savedstate.getDisplayMode()];
        mInputEnabled = savedstate.isInputEnabled();
        mInStealthMode = savedstate.isInStealthMode();
        mEnableHapticFeedback = savedstate.isTactileFeedbackEnabled();
    }

    protected Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), LockPatternUtils.patternToString(mPattern), mPatternDisplayMode.ordinal(), mInputEnabled, mInStealthMode, mEnableHapticFeedback);
    }

    protected void onSizeChanged(int i, int j, int k, int l) {
        mSquareWidth = (float)(i - super.mPaddingLeft - super.mPaddingRight) / 3F;
        mSquareHeight = (float)(j - super.mPaddingTop - super.mPaddingBottom) / 3F;
    }

    public boolean onTouchEvent(MotionEvent motionevent) {
        boolean flag = true;
        if(mInputEnabled && isEnabled()) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        return flag;
_L2:
        switch(motionevent.getAction()) {
        default:
            flag = false;
            break;

        case 0: // '\0'
            handleActionDown(motionevent);
            break;

        case 1: // '\001'
            handleActionUp(motionevent);
            break;

        case 2: // '\002'
            handleActionMove(motionevent);
            break;

        case 3: // '\003'
            resetPattern();
            mPatternInProgress = false;
            notifyPatternCleared();
            break;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void setDisplayMode(DisplayMode displaymode) {
        mPatternDisplayMode = displaymode;
        if(displaymode == DisplayMode.Animate) {
            if(mPattern.size() == 0)
                throw new IllegalStateException("you must have a pattern to animate if you want to set the display mode to animate");
            mAnimatingPeriodStart = SystemClock.elapsedRealtime();
            com.android.internal.widget.Cell cell = (com.android.internal.widget.Cell)mPattern.get(0);
            mInProgressX = getCenterXForColumn(cell.getColumn());
            mInProgressY = getCenterYForRow(cell.getRow());
            clearPatternDrawLookup();
        }
        invalidate();
    }

    public void setInStealthMode(boolean flag) {
        mInStealthMode = flag;
    }

    public void setOnPatternListener(OnPatternListener onpatternlistener) {
        mOnPatternListener = onpatternlistener;
    }

    public void setPattern(DisplayMode displaymode, List list) {
        mPattern.clear();
        mPattern.addAll(list);
        clearPatternDrawLookup();
        for(Iterator iterator = list.iterator(); iterator.hasNext();) {
            com.android.internal.widget.Cell cell = (com.android.internal.widget.Cell)iterator.next();
            mPatternDrawLookup[cell.getRow()][cell.getColumn()] = true;
        }

        setDisplayMode(displaymode);
    }

    public void setTactileFeedbackEnabled(boolean flag) {
        mEnableHapticFeedback = flag;
    }

    private static final int ASPECT_LOCK_HEIGHT = 2;
    private static final int ASPECT_LOCK_WIDTH = 1;
    private static final int ASPECT_SQUARE = 0;
    private static final int MILLIS_PER_CIRCLE_ANIMATING = 700;
    private static final boolean PROFILE_DRAWING = false;
    static final int STATUS_BAR_HEIGHT = 25;
    private static final String TAG = "LockPatternView";
    private long mAnimatingPeriodStart;
    private final Matrix mArrowMatrix;
    private int mAspect;
    private Bitmap mBitmapArrowGreenUp;
    private Bitmap mBitmapArrowRedUp;
    private Bitmap mBitmapBtnDefault;
    private Bitmap mBitmapBtnDefaultWithBackground;
    private Bitmap mBitmapBtnTouched;
    private Bitmap mBitmapCircleDefault;
    private Bitmap mBitmapCircleGreen;
    private Bitmap mBitmapCircleRed;
    private int mBitmapHeight;
    private int mBitmapWidth;
    private final Matrix mCircleMatrix;
    private final Path mCurrentPath;
    private float mDiameterFactor;
    private boolean mDrawingProfilingStarted;
    private boolean mEnableHapticFeedback;
    private float mHitFactor;
    private float mInProgressX;
    private float mInProgressY;
    private boolean mInStealthMode;
    private boolean mInputEnabled;
    private final Rect mInvalidate;
    private OnPatternListener mOnPatternListener;
    private Paint mPaint;
    private Paint mPathPaint;
    private ArrayList mPattern;
    private DisplayMode mPatternDisplayMode;
    private boolean mPatternDrawLookup[][];
    private boolean mPatternInProgress;
    private float mSquareHeight;
    private float mSquareWidth;
    private int mStrokeAlpha;
}
