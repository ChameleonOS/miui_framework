// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.Drawable;
import android.inputmethodservice.ExtractEditText;
import android.os.*;
import android.text.*;
import android.text.method.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.accessibility.*;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.*;
import android.view.textservice.SpellCheckerSubtype;
import android.view.textservice.TextServicesManager;
import com.android.internal.util.FastMath;
import com.android.internal.widget.EditableInputConnection;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.*;
import miui.text.util.Linkify;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package android.widget:
//            Editor, Scroller, MiuiCursorController, SpellChecker

public class TextView extends View
    implements android.view.ViewTreeObserver.OnPreDrawListener {
    private static final class Marquee extends Handler {

        private void resetScroll() {
            mScroll = 0.0F;
            TextView textview = (TextView)mView.get();
            if(textview != null)
                textview.invalidate();
        }

        float getGhostOffset() {
            return mGhostOffset;
        }

        public void handleMessage(Message message) {
            message.what;
            JVM INSTR tableswitch 1 3: default 32
        //                       1 33
        //                       2 45
        //                       3 52;
               goto _L1 _L2 _L3 _L4
_L1:
            return;
_L2:
            mStatus = 2;
            tick();
            continue; /* Loop/switch isn't completed */
_L3:
            tick();
            continue; /* Loop/switch isn't completed */
_L4:
            if(mStatus == 2) {
                if(mRepeatLimit >= 0)
                    mRepeatLimit = -1 + mRepeatLimit;
                start(mRepeatLimit);
            }
            if(true) goto _L1; else goto _L5
_L5:
        }

        boolean isRunning() {
            boolean flag;
            if(mStatus == 2)
                flag = true;
            else
                flag = false;
            return flag;
        }

        boolean isStopped() {
            boolean flag;
            if(mStatus == 0)
                flag = true;
            else
                flag = false;
            return flag;
        }

        boolean shouldDrawGhost() {
            boolean flag;
            if(mStatus == 2 && mScroll > mGhostStart)
                flag = true;
            else
                flag = false;
            return flag;
        }

        boolean shouldDrawLeftFade() {
            boolean flag;
            if(mScroll <= mFadeStop)
                flag = true;
            else
                flag = false;
            return flag;
        }

        void start(int i) {
            if(i != 0) goto _L2; else goto _L1
_L1:
            stop();
_L4:
            return;
_L2:
            mRepeatLimit = i;
            TextView textview = (TextView)mView.get();
            if(textview != null && textview.mLayout != null) {
                mStatus = 1;
                mScroll = 0.0F;
                int j = textview.getWidth() - textview.getCompoundPaddingLeft() - textview.getCompoundPaddingRight();
                float f = textview.mLayout.getLineWidth(0);
                float f1 = (float)j / 3F;
                mGhostStart = f1 + (f - (float)j);
                mMaxScroll = mGhostStart + (float)j;
                mGhostOffset = f + f1;
                mFadeStop = f + (float)j / 6F;
                mMaxFadeScroll = f + (f + mGhostStart);
                textview.invalidate();
                sendEmptyMessageDelayed(1, 1200L);
            }
            if(true) goto _L4; else goto _L3
_L3:
        }

        void stop() {
            mStatus = 0;
            removeMessages(1);
            removeMessages(3);
            removeMessages(2);
            resetScroll();
        }

        void tick() {
            if(mStatus == 2) goto _L2; else goto _L1
_L1:
            return;
_L2:
            removeMessages(2);
            TextView textview = (TextView)mView.get();
            if(textview != null && (textview.isFocused() || textview.isSelected())) {
                mScroll = mScroll + mScrollUnit;
                if(mScroll > mMaxScroll) {
                    mScroll = mMaxScroll;
                    sendEmptyMessageDelayed(3, 1200L);
                } else {
                    sendEmptyMessageDelayed(2, 33L);
                }
                textview.invalidate();
            }
            if(true) goto _L1; else goto _L3
_L3:
        }

        private static final int MARQUEE_DELAY = 1200;
        private static final float MARQUEE_DELTA_MAX = 0.07F;
        private static final int MARQUEE_PIXELS_PER_SECOND = 30;
        private static final int MARQUEE_RESOLUTION = 33;
        private static final int MARQUEE_RESTART_DELAY = 1200;
        private static final byte MARQUEE_RUNNING = 2;
        private static final byte MARQUEE_STARTING = 1;
        private static final byte MARQUEE_STOPPED = 0;
        private static final int MESSAGE_RESTART = 3;
        private static final int MESSAGE_START = 1;
        private static final int MESSAGE_TICK = 2;
        private float mFadeStop;
        private float mGhostOffset;
        private float mGhostStart;
        float mMaxFadeScroll;
        private float mMaxScroll;
        private int mRepeatLimit;
        float mScroll;
        private final float mScrollUnit;
        private byte mStatus;
        private final WeakReference mView;

        Marquee(TextView textview) {
            mStatus = 0;
            mScrollUnit = (30F * textview.getContext().getResources().getDisplayMetrics().density) / 33F;
            mView = new WeakReference(textview);
        }
    }

    private static class CharWrapper
        implements CharSequence, GetChars, GraphicsOperations {

        public char charAt(int i) {
            return mChars[i + mStart];
        }

        public void drawText(Canvas canvas, int i, int j, float f, float f1, Paint paint) {
            canvas.drawText(mChars, i + mStart, j - i, f, f1, paint);
        }

        public void drawTextRun(Canvas canvas, int i, int j, int k, int l, float f, float f1, 
                int i1, Paint paint) {
            int j1 = j - i;
            int k1 = l - k;
            canvas.drawTextRun(mChars, i + mStart, j1, k + mStart, k1, f, f1, i1, paint);
        }

        public void getChars(int i, int j, char ac[], int k) {
            if(i < 0 || j < 0 || i > mLength || j > mLength) {
                throw new IndexOutOfBoundsException((new StringBuilder()).append(i).append(", ").append(j).toString());
            } else {
                System.arraycopy(mChars, i + mStart, ac, k, j - i);
                return;
            }
        }

        public float getTextRunAdvances(int i, int j, int k, int l, int i1, float af[], int j1, 
                Paint paint) {
            int k1 = j - i;
            int l1 = l - k;
            return paint.getTextRunAdvances(mChars, i + mStart, k1, k + mStart, l1, i1, af, j1);
        }

        public float getTextRunAdvances(int i, int j, int k, int l, int i1, float af[], int j1, 
                Paint paint, int k1) {
            int l1 = j - i;
            int i2 = l - k;
            return paint.getTextRunAdvances(mChars, i + mStart, l1, k + mStart, i2, i1, af, j1, k1);
        }

        public int getTextRunCursor(int i, int j, int k, int l, int i1, Paint paint) {
            int j1 = j - i;
            return paint.getTextRunCursor(mChars, i + mStart, j1, k, l + mStart, i1);
        }

        public int getTextWidths(int i, int j, float af[], Paint paint) {
            return paint.getTextWidths(mChars, i + mStart, j - i, af);
        }

        public int length() {
            return mLength;
        }

        public float measureText(int i, int j, Paint paint) {
            return paint.measureText(mChars, i + mStart, j - i);
        }

        void set(char ac[], int i, int j) {
            mChars = ac;
            mStart = i;
            mLength = j;
        }

        public CharSequence subSequence(int i, int j) {
            if(i < 0 || j < 0 || i > mLength || j > mLength)
                throw new IndexOutOfBoundsException((new StringBuilder()).append(i).append(", ").append(j).toString());
            else
                return new String(mChars, i + mStart, j - i);
        }

        public String toString() {
            return new String(mChars, mStart, mLength);
        }

        private char mChars[];
        private int mLength;
        private int mStart;


/*
        static char[] access$002(CharWrapper charwrapper, char ac[]) {
            charwrapper.mChars = ac;
            return ac;
        }

*/

        public CharWrapper(char ac[], int i, int j) {
            mChars = ac;
            mStart = i;
            mLength = j;
        }
    }

    public static class SavedState extends android.view.View.BaseSavedState {

        public String toString() {
            String s = (new StringBuilder()).append("TextView.SavedState{").append(Integer.toHexString(System.identityHashCode(this))).append(" start=").append(selStart).append(" end=").append(selEnd).toString();
            if(text != null)
                s = (new StringBuilder()).append(s).append(" text=").append(text).toString();
            return (new StringBuilder()).append(s).append("}").toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            writeToParcel(parcel, i);
            parcel.writeInt(selStart);
            parcel.writeInt(selEnd);
            int j;
            if(frozenWithFocus)
                j = 1;
            else
                j = 0;
            parcel.writeInt(j);
            TextUtils.writeToParcel(text, parcel, i);
            if(error == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                TextUtils.writeToParcel(error, parcel, i);
            }
        }

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            public volatile Object[] newArray(int i) {
                return newArray(i);
            }

        };
        CharSequence error;
        boolean frozenWithFocus;
        int selEnd;
        int selStart;
        CharSequence text;


        private SavedState(Parcel parcel) {
            super(parcel);
            selStart = parcel.readInt();
            selEnd = parcel.readInt();
            boolean flag;
            if(parcel.readInt() != 0)
                flag = true;
            else
                flag = false;
            frozenWithFocus = flag;
            text = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            if(parcel.readInt() != 0)
                error = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }


        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static final class BufferType extends Enum {

        public static BufferType valueOf(String s) {
            return (BufferType)Enum.valueOf(android/widget/TextView$BufferType, s);
        }

        public static BufferType[] values() {
            return (BufferType[])$VALUES.clone();
        }

        private static final BufferType $VALUES[];
        public static final BufferType EDITABLE;
        public static final BufferType NORMAL;
        public static final BufferType SPANNABLE;

        static  {
            NORMAL = new BufferType("NORMAL", 0);
            SPANNABLE = new BufferType("SPANNABLE", 1);
            EDITABLE = new BufferType("EDITABLE", 2);
            BufferType abuffertype[] = new BufferType[3];
            abuffertype[0] = NORMAL;
            abuffertype[1] = SPANNABLE;
            abuffertype[2] = EDITABLE;
            $VALUES = abuffertype;
        }

        private BufferType(String s, int i) {
            super(s, i);
        }
    }

    public static interface OnEditorActionListener {

        public abstract boolean onEditorAction(TextView textview, int i, KeyEvent keyevent);
    }

    static class Drawables {

        final Rect mCompoundRect = new Rect();
        Drawable mDrawableBottom;
        Drawable mDrawableEnd;
        int mDrawableHeightEnd;
        int mDrawableHeightLeft;
        int mDrawableHeightRight;
        int mDrawableHeightStart;
        Drawable mDrawableLeft;
        int mDrawablePadding;
        Drawable mDrawableRight;
        int mDrawableSizeBottom;
        int mDrawableSizeEnd;
        int mDrawableSizeLeft;
        int mDrawableSizeRight;
        int mDrawableSizeStart;
        int mDrawableSizeTop;
        Drawable mDrawableStart;
        Drawable mDrawableTop;
        int mDrawableWidthBottom;
        int mDrawableWidthTop;

        Drawables() {
        }
    }


    public TextView(Context context) {
        TextView(context, null);
    }

    public TextView(Context context, AttributeSet attributeset) {
        TextView(context, attributeset, 0x1010084);
    }

    public TextView(Context context, AttributeSet attributeset, int i) {
        int j;
        ColorStateList colorstatelist;
        ColorStateList colorstatelist1;
        ColorStateList colorstatelist2;
        int k;
        String s;
        int l;
        int i1;
        boolean flag;
        android.content.res.Resources.Theme theme;
        TypedArray typedarray1;
        int k6;
        int l6;
        View(context, attributeset, i);
        mEditableFactory = android.text.Editable.Factory.getInstance();
        mSpannableFactory = android.text.Spannable.Factory.getInstance();
        mMarqueeRepeatLimit = 3;
        mMarqueeFadeMode = 0;
        mBufferType = BufferType.NORMAL;
        mGravity = 0x800033;
        mLinksClickable = true;
        mSpacingMult = 1.0F;
        mSpacingAdd = 0.0F;
        mMaximum = 0x7fffffff;
        mMaxMode = 1;
        mMinimum = 0;
        mMinMode = 1;
        mOldMaximum = mMaximum;
        mOldMaxMode = mMaxMode;
        mMaxWidth = 0x7fffffff;
        mMaxWidthMode = 2;
        mMinWidth = 0;
        mMinWidthMode = 2;
        mDesiredHeightAtMeasure = -1;
        mIncludePad = true;
        mFilters = NO_FILTERS;
        mHighlightColor = 0x6633b5e5;
        mHighlightPathBogus = true;
        mText = "";
        Resources resources = getResources();
        CompatibilityInfo compatibilityinfo = resources.getCompatibilityInfo();
        mTextPaint = new TextPaint(1);
        mTextPaint.density = resources.getDisplayMetrics().density;
        mTextPaint.setCompatibilityScaling(compatibilityinfo.applicationScale);
        mHighlightPaint = new Paint(1);
        mHighlightPaint.setCompatibilityScaling(compatibilityinfo.applicationScale);
        mMovement = getDefaultMovementMethod();
        mTransformation = null;
        j = 0;
        colorstatelist = null;
        colorstatelist1 = null;
        colorstatelist2 = null;
        k = 15;
        s = null;
        l = -1;
        i1 = -1;
        flag = false;
        theme = context.getTheme();
        TypedArray typedarray = theme.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.TextViewAppearance, i, 0);
        typedarray1 = null;
        int j1 = typedarray.getResourceId(0, -1);
        typedarray.recycle();
        if(j1 != -1)
            typedarray1 = theme.obtainStyledAttributes(j1, com.android.internal.R.styleable.TextAppearance);
        if(typedarray1 == null)
            break MISSING_BLOCK_LABEL_544;
        k6 = typedarray1.getIndexCount();
        l6 = 0;
_L12:
        int i7;
        if(l6 >= k6)
            break MISSING_BLOCK_LABEL_539;
        i7 = typedarray1.getIndex(l6);
        i7;
        JVM INSTR tableswitch 0 8: default 416
    //                   0 472
    //                   1 486
    //                   2 512
    //                   3 436
    //                   4 422
    //                   5 448
    //                   6 460
    //                   7 526
    //                   8 500;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L9:
        break MISSING_BLOCK_LABEL_526;
_L1:
        break; /* Loop/switch isn't completed */
_L6:
        break; /* Loop/switch isn't completed */
_L13:
        l6++;
        if(true) goto _L12; else goto _L11
_L11:
        j = typedarray1.getColor(i7, j);
          goto _L13
_L5:
        colorstatelist = typedarray1.getColorStateList(i7);
          goto _L13
_L7:
        colorstatelist1 = typedarray1.getColorStateList(i7);
          goto _L13
_L8:
        colorstatelist2 = typedarray1.getColorStateList(i7);
          goto _L13
_L2:
        k = typedarray1.getDimensionPixelSize(i7, k);
          goto _L13
_L3:
        l = typedarray1.getInt(i7, -1);
          goto _L13
_L10:
        s = typedarray1.getString(i7);
          goto _L13
_L4:
        i1 = typedarray1.getInt(i7, -1);
          goto _L13
        flag = typedarray1.getBoolean(i7, false);
          goto _L13
        typedarray1.recycle();
        boolean flag1;
        CharSequence charsequence;
        int k1;
        CharSequence charsequence1;
        boolean flag2;
        boolean flag3;
        int l1;
        int i2;
        boolean flag4;
        Drawable drawable;
        Drawable drawable1;
        Drawable drawable2;
        Drawable drawable3;
        Drawable drawable4;
        Drawable drawable5;
        int j2;
        int k2;
        boolean flag5;
        int l2;
        Object obj;
        CharSequence charsequence2;
        int i3;
        float f;
        float f1;
        float f2;
        boolean flag6;
        int j3;
        TypedArray typedarray2;
        int k3;
        int l3;
        flag1 = getDefaultEditable();
        charsequence = null;
        k1 = 0;
        charsequence1 = null;
        flag2 = false;
        flag3 = false;
        l1 = -1;
        i2 = 0;
        flag4 = false;
        drawable = null;
        drawable1 = null;
        drawable2 = null;
        drawable3 = null;
        drawable4 = null;
        drawable5 = null;
        j2 = 0;
        k2 = -1;
        flag5 = false;
        l2 = -1;
        obj = "";
        charsequence2 = null;
        i3 = 0;
        f = 0.0F;
        f1 = 0.0F;
        f2 = 0.0F;
        flag6 = false;
        j3 = 0;
        typedarray2 = theme.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.TextView, i, 0);
        k3 = typedarray2.getIndexCount();
        l3 = 0;
_L87:
        int j6;
        if(l3 >= k3)
            break MISSING_BLOCK_LABEL_2131;
        j6 = typedarray2.getIndex(l3);
        j6;
        JVM INSTR tableswitch 0 75: default 992
    //                   0 1667
    //                   1 992
    //                   2 1735
    //                   3 1749
    //                   4 1763
    //                   5 1699
    //                   6 1685
    //                   7 1711
    //                   8 1723
    //                   9 1501
    //                   10 1428
    //                   11 1120
    //                   12 1135
    //                   13 1348
    //                   14 1252
    //                   15 1412
    //                   16 1316
    //                   17 1092
    //                   18 1456
    //                   19 1444
    //                   20 1585
    //                   21 1552
    //                   22 1236
    //                   23 1268
    //                   24 1284
    //                   25 1300
    //                   26 1332
    //                   27 1364
    //                   28 1380
    //                   29 1396
    //                   30 1468
    //                   31 1789
    //                   32 1487
    //                   33 1106
    //                   34 1533
    //                   35 1571
    //                   36 1615
    //                   37 1628
    //                   38 1641
    //                   39 1654
    //                   40 1024
    //                   41 1038
    //                   42 1050
    //                   43 1012
    //                   44 1078
    //                   45 1064
    //                   46 998
    //                   47 1600
    //                   48 1162
    //                   49 1186
    //                   50 1150
    //                   51 1174
    //                   52 1222
    //                   53 1803
    //                   54 1823
    //                   55 1515
    //                   56 1841
    //                   57 1967
    //                   58 1981
    //                   59 1854
    //                   60 1895
    //                   61 1926
    //                   62 2043
    //                   63 2058
    //                   64 2073
    //                   65 992
    //                   66 992
    //                   67 2103
    //                   68 992
    //                   69 992
    //                   70 2028
    //                   71 2088
    //                   72 2118
    //                   73 1198
    //                   74 1210
    //                   75 1777;
           goto _L14 _L15 _L14 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34 _L35 _L36 _L37 _L38 _L39 _L40 _L41 _L42 _L43 _L44 _L45 _L46 _L47 _L48 _L49 _L50 _L51 _L52 _L53 _L54 _L55 _L56 _L57 _L58 _L59 _L60 _L61 _L62 _L63 _L64 _L65 _L66 _L67 _L68 _L69 _L70 _L71 _L72 _L73 _L74 _L75 _L76 _L77 _L78 _L14 _L14 _L79 _L14 _L14 _L80 _L81 _L82 _L83 _L84 _L85
_L82:
        break MISSING_BLOCK_LABEL_2118;
_L14:
        break; /* Loop/switch isn't completed */
_L60:
        break; /* Loop/switch isn't completed */
_L88:
        l3++;
        if(true) goto _L87; else goto _L86
_L86:
        flag1 = typedarray2.getBoolean(j6, flag1);
          goto _L88
_L57:
        charsequence = typedarray2.getText(j6);
          goto _L88
_L54:
        k1 = typedarray2.getInt(j6, k1);
          goto _L88
_L55:
        charsequence1 = typedarray2.getText(j6);
          goto _L88
_L56:
        flag2 = typedarray2.getBoolean(j6, flag2);
          goto _L88
_L59:
        flag3 = typedarray2.getBoolean(j6, flag3);
          goto _L88
_L58:
        l1 = typedarray2.getInt(j6, l1);
          goto _L88
_L31:
        i2 = typedarray2.getInt(j6, i2);
          goto _L88
_L47:
        flag4 = typedarray2.getBoolean(j6, flag4);
          goto _L88
_L25:
        mAutoLinkMask = typedarray2.getInt(j6, 0);
          goto _L88
_L26:
        mLinksClickable = typedarray2.getBoolean(j6, true);
          goto _L88
_L64:
        drawable = typedarray2.getDrawable(j6);
          goto _L88
_L62:
        drawable1 = typedarray2.getDrawable(j6);
          goto _L88
_L65:
        drawable2 = typedarray2.getDrawable(j6);
          goto _L88
_L63:
        drawable3 = typedarray2.getDrawable(j6);
          goto _L88
_L83:
        drawable4 = typedarray2.getDrawable(j6);
          goto _L88
_L84:
        drawable5 = typedarray2.getDrawable(j6);
          goto _L88
_L66:
        j2 = typedarray2.getDimensionPixelSize(j6, j2);
          goto _L88
_L36:
        setMaxLines(typedarray2.getInt(j6, -1));
          goto _L88
_L28:
        setMaxHeight(typedarray2.getDimensionPixelSize(j6, -1));
          goto _L88
_L37:
        setLines(typedarray2.getInt(j6, -1));
          goto _L88
_L38:
        setHeight(typedarray2.getDimensionPixelSize(j6, -1));
          goto _L88
_L39:
        setMinLines(typedarray2.getInt(j6, -1));
          goto _L88
_L30:
        setMinHeight(typedarray2.getDimensionPixelSize(j6, -1));
          goto _L88
_L40:
        setMaxEms(typedarray2.getInt(j6, -1));
          goto _L88
_L27:
        setMaxWidth(typedarray2.getDimensionPixelSize(j6, -1));
          goto _L88
_L41:
        setEms(typedarray2.getInt(j6, -1));
          goto _L88
_L42:
        setWidth(typedarray2.getDimensionPixelSize(j6, -1));
          goto _L88
_L43:
        setMinEms(typedarray2.getInt(j6, -1));
          goto _L88
_L29:
        setMinWidth(typedarray2.getDimensionPixelSize(j6, -1));
          goto _L88
_L24:
        setGravity(typedarray2.getInt(j6, -1));
          goto _L88
_L33:
        charsequence2 = typedarray2.getText(j6);
          goto _L88
_L32:
        obj = typedarray2.getText(j6);
          goto _L88
_L44:
        if(typedarray2.getBoolean(j6, false))
            setHorizontallyScrolling(true);
          goto _L88
_L46:
        flag5 = typedarray2.getBoolean(j6, flag5);
          goto _L88
_L23:
        k2 = typedarray2.getInt(j6, k2);
          goto _L88
_L69:
        setMarqueeRepeatLimit(typedarray2.getInt(j6, mMarqueeRepeatLimit));
          goto _L88
_L48:
        if(!typedarray2.getBoolean(j6, true))
            setIncludeFontPadding(false);
          goto _L88
_L35:
        if(!typedarray2.getBoolean(j6, true))
            setCursorVisible(false);
          goto _L88
_L49:
        l2 = typedarray2.getInt(j6, -1);
          goto _L88
_L34:
        setTextScaleX(typedarray2.getFloat(j6, 1.0F));
          goto _L88
_L61:
        mFreezesText = typedarray2.getBoolean(j6, false);
          goto _L88
_L50:
        i3 = typedarray2.getInt(j6, 0);
          goto _L88
_L51:
        f = typedarray2.getFloat(j6, 0.0F);
          goto _L88
_L52:
        f1 = typedarray2.getFloat(j6, 0.0F);
          goto _L88
_L53:
        f2 = typedarray2.getFloat(j6, 0.0F);
          goto _L88
_L15:
        setEnabled(typedarray2.getBoolean(j6, isEnabled()));
          goto _L88
_L20:
        j = typedarray2.getColor(j6, j);
          goto _L88
_L19:
        colorstatelist = typedarray2.getColorStateList(j6);
          goto _L88
_L21:
        colorstatelist1 = typedarray2.getColorStateList(j6);
          goto _L88
_L22:
        colorstatelist2 = typedarray2.getColorStateList(j6);
          goto _L88
_L16:
        k = typedarray2.getDimensionPixelSize(j6, k);
          goto _L88
_L17:
        l = typedarray2.getInt(j6, l);
          goto _L88
_L18:
        i1 = typedarray2.getInt(j6, i1);
          goto _L88
_L85:
        s = typedarray2.getString(j6);
          goto _L88
_L45:
        flag6 = typedarray2.getBoolean(j6, flag6);
          goto _L88
_L67:
        mSpacingAdd = typedarray2.getDimensionPixelSize(j6, (int)mSpacingAdd);
          goto _L88
_L68:
        mSpacingMult = typedarray2.getFloat(j6, mSpacingMult);
          goto _L88
_L70:
        j3 = typedarray2.getInt(j6, 0);
          goto _L88
_L73:
        createEditorIfNeeded();
        mEditor.createInputContentTypeIfNeeded();
        mEditor.mInputContentType.imeOptions = typedarray2.getInt(j6, mEditor.mInputContentType.imeOptions);
          goto _L88
_L74:
        createEditorIfNeeded();
        mEditor.createInputContentTypeIfNeeded();
        mEditor.mInputContentType.imeActionLabel = typedarray2.getText(j6);
          goto _L88
_L75:
        createEditorIfNeeded();
        mEditor.createInputContentTypeIfNeeded();
        mEditor.mInputContentType.imeActionId = typedarray2.getInt(j6, mEditor.mInputContentType.imeActionId);
          goto _L88
_L71:
        setPrivateImeOptions(typedarray2.getString(j6));
          goto _L88
_L72:
        try {
            setInputExtras(typedarray2.getResourceId(j6, 0));
        }
        catch(XmlPullParserException xmlpullparserexception) {
            Log.w("TextView", "Failure reading input extras", xmlpullparserexception);
        }
        catch(IOException ioexception) {
            Log.w("TextView", "Failure reading input extras", ioexception);
        }
          goto _L88
_L80:
        mCursorDrawableRes = typedarray2.getResourceId(j6, 0);
          goto _L88
_L76:
        mTextSelectHandleLeftRes = typedarray2.getResourceId(j6, 0);
          goto _L88
_L77:
        mTextSelectHandleRightRes = typedarray2.getResourceId(j6, 0);
          goto _L88
_L78:
        mTextSelectHandleRes = typedarray2.getResourceId(j6, 0);
          goto _L88
_L81:
        mTextEditSuggestionItemLayout = typedarray2.getResourceId(j6, 0);
          goto _L88
_L79:
        setTextIsSelectable(typedarray2.getBoolean(j6, false));
          goto _L88
        flag = typedarray2.getBoolean(j6, false);
          goto _L88
        BufferType buffertype;
        TypedArray typedarray3;
        boolean flag10;
        boolean flag11;
        boolean flag12;
        int i5;
        int i6;
        typedarray2.recycle();
        buffertype = BufferType.EDITABLE;
        int i4 = 0xfff & j3;
        boolean flag7;
        boolean flag8;
        boolean flag9;
        int k4;
        int l4;
        InputFilter ainputfilter[];
        android.text.InputFilter.LengthFilter lengthfilter;
        Class class1;
        Editor editor2;
        if(i4 == 129)
            flag7 = true;
        else
            flag7 = false;
        if(i4 == 225)
            flag8 = true;
        else
            flag8 = false;
        if(i4 == 18)
            flag9 = true;
        else
            flag9 = false;
        if(charsequence == null) goto _L90; else goto _L89
_L89:
        try {
            class1 = Class.forName(charsequence.toString());
        }
        catch(ClassNotFoundException classnotfoundexception) {
            RuntimeException runtimeexception = new RuntimeException(classnotfoundexception);
            throw runtimeexception;
        }
        try {
            createEditorIfNeeded();
            mEditor.mKeyListener = (KeyListener)class1.newInstance();
        }
        catch(InstantiationException instantiationexception) {
            RuntimeException runtimeexception2 = new RuntimeException(instantiationexception);
            throw runtimeexception2;
        }
        catch(IllegalAccessException illegalaccessexception) {
            RuntimeException runtimeexception1 = new RuntimeException(illegalaccessexception);
            throw runtimeexception1;
        }
        editor2 = mEditor;
        if(j3 == 0) goto _L92; else goto _L91
_L91:
        i6 = j3;
_L113:
        editor2.mInputType = i6;
_L105:
        if(mEditor != null)
            mEditor.adjustInputType(flag6, flag7, flag8, flag9);
        if(flag4) {
            createEditorIfNeeded();
            mEditor.mSelectAllOnFocus = true;
            if(buffertype == BufferType.NORMAL)
                buffertype = BufferType.SPANNABLE;
        }
        setCompoundDrawablesWithIntrinsicBounds(drawable, drawable1, drawable2, drawable3);
        setRelativeDrawablesIfNeeded(drawable4, drawable5);
        setCompoundDrawablePadding(j2);
        setInputTypeSingleLine(flag5);
        applySingleLine(flag5, flag5, flag5);
        if(flag5 && getKeyListener() == null && k2 < 0)
            k2 = 3;
        k2;
        JVM INSTR tableswitch 1 4: default 2384
    //                   1 3255
    //                   2 3265
    //                   3 3275
    //                   4 3285;
           goto _L93 _L94 _L95 _L96 _L97
_L93:
        int j4;
        android.text.method.TextKeyListener.Capitalize capitalize;
        Editor editor;
        boolean flag13;
        boolean flag14;
        int j5;
        Editor editor1;
        int k5;
        IncompatibleClassChangeError incompatibleclasschangeerror;
        int l5;
        if(colorstatelist == null)
            colorstatelist = ColorStateList.valueOf(0xff000000);
        setTextColor(colorstatelist);
        setHintTextColor(colorstatelist1);
        setLinkTextColor(colorstatelist2);
        if(j != 0)
            setHighlightColor(j);
        setRawTextSize(k);
        if(flag)
            setTransformationMethod(new AllCapsTransformationMethod(getContext()));
        if(flag6 || flag7 || flag8 || flag9) {
            setTransformationMethod(PasswordTransformationMethod.getInstance());
            l = 3;
        } else
        if(mEditor != null && (0xfff & mEditor.mInputType) == 129)
            l = 3;
        setTypefaceFromAttrs(s, l, i1);
        if(i3 != 0)
            setShadowLayer(f2, f, f1, i3);
        if(l2 >= 0) {
            ainputfilter = new InputFilter[1];
            lengthfilter = new LengthFilter(l2);
            ainputfilter[0] = lengthfilter;
            setFilters(ainputfilter);
        } else {
            setFilters(NO_FILTERS);
        }
        setText(((CharSequence) (obj)), buffertype);
        if(charsequence2 != null)
            setHint(charsequence2);
        typedarray3 = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.View, i, 0);
        if(mMovement != null || getKeyListener() != null)
            flag10 = true;
        else
            flag10 = false;
        flag11 = flag10;
        flag12 = flag10;
        k4 = typedarray3.getIndexCount();
        l4 = 0;
_L104:
        if(l4 >= k4) goto _L99; else goto _L98
_L98:
        i5 = typedarray3.getIndex(l4);
        i5;
        JVM INSTR lookupswitch 3: default 2656
    //                   18: 3385
    //                   29: 3399
    //                   30: 3413;
           goto _L100 _L101 _L102 _L103
_L100:
        l4++;
          goto _L104
_L92:
        l5 = mEditor.mKeyListener.getInputType();
        i6 = l5;
        continue; /* Loop/switch isn't completed */
        incompatibleclasschangeerror;
        mEditor.mInputType = 1;
          goto _L105
_L90:
        if(charsequence1 != null) {
            createEditorIfNeeded();
            mEditor.mKeyListener = DigitsKeyListener.getInstance(charsequence1.toString());
            editor1 = mEditor;
            if(j3 != 0)
                k5 = j3;
            else
                k5 = 1;
            editor1.mInputType = k5;
        } else
        if(j3 != 0) {
            setInputType(j3, true);
            if(!isMultilineInputType(j3))
                flag5 = true;
            else
                flag5 = false;
        } else
        if(flag2) {
            createEditorIfNeeded();
            mEditor.mKeyListener = DialerKeyListener.getInstance();
            mEditor.mInputType = 3;
        } else {
label0:
            {
                if(k1 == 0)
                    break label0;
                createEditorIfNeeded();
                editor = mEditor;
                if((k1 & 2) != 0)
                    flag13 = true;
                else
                    flag13 = false;
                if((k1 & 4) != 0)
                    flag14 = true;
                else
                    flag14 = false;
                editor.mKeyListener = DigitsKeyListener.getInstance(flag13, flag14);
                j5 = 2;
                if((k1 & 2) != 0)
                    j5 = 0x1000 | j5;
                if((k1 & 4) != 0)
                    j5 = 0x2000 | j5;
                mEditor.mInputType = j5;
            }
        }
          goto _L105
        if(!flag3 && l1 == -1)
            break MISSING_BLOCK_LABEL_3111;
        j4 = 1;
        l1;
        JVM INSTR tableswitch 1 3: default 3028
    //                   1 3063
    //                   2 3079
    //                   3 3095;
           goto _L106 _L107 _L108 _L109
_L109:
        break MISSING_BLOCK_LABEL_3095;
_L106:
        capitalize = android.text.method.TextKeyListener.Capitalize.NONE;
_L110:
        createEditorIfNeeded();
        mEditor.mKeyListener = TextKeyListener.getInstance(flag3, capitalize);
        mEditor.mInputType = j4;
          goto _L105
_L107:
        capitalize = android.text.method.TextKeyListener.Capitalize.SENTENCES;
        j4 = 0x4000 | j4;
          goto _L110
_L108:
        capitalize = android.text.method.TextKeyListener.Capitalize.WORDS;
        j4 = 0x2000 | j4;
          goto _L110
        capitalize = android.text.method.TextKeyListener.Capitalize.CHARACTERS;
        j4 = 0x1000 | j4;
          goto _L110
        if(isTextSelectable()) {
            if(mEditor != null) {
                mEditor.mKeyListener = null;
                mEditor.mInputType = 0;
            }
            buffertype = BufferType.SPANNABLE;
            setMovementMethod(ArrowKeyMovementMethod.getInstance());
        } else {
label1:
            {
                if(!flag1)
                    break label1;
                createEditorIfNeeded();
                mEditor.mKeyListener = TextKeyListener.getInstance();
                mEditor.mInputType = 1;
            }
        }
          goto _L105
        if(mEditor != null)
            mEditor.mKeyListener = null;
        switch(i2) {
        case 0: // '\0'
            buffertype = BufferType.NORMAL;
            break;

        case 1: // '\001'
            buffertype = BufferType.SPANNABLE;
            break;

        case 2: // '\002'
            buffertype = BufferType.EDITABLE;
            break;
        }
        continue; /* Loop/switch isn't completed */
_L94:
        setEllipsize(android.text.TextUtils.TruncateAt.START);
          goto _L93
_L95:
        setEllipsize(android.text.TextUtils.TruncateAt.MIDDLE);
          goto _L93
_L96:
        setEllipsize(android.text.TextUtils.TruncateAt.END);
          goto _L93
_L97:
        if(ViewConfiguration.get(context).isFadingMarqueeEnabled()) {
            setHorizontalFadingEdgeEnabled(true);
            mMarqueeFadeMode = 0;
        } else {
            setHorizontalFadingEdgeEnabled(false);
            mMarqueeFadeMode = 1;
        }
        setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
          goto _L93
_L101:
        flag10 = typedarray3.getBoolean(i5, flag10);
          goto _L100
_L102:
        flag11 = typedarray3.getBoolean(i5, flag11);
          goto _L100
_L103:
        flag12 = typedarray3.getBoolean(i5, flag12);
          goto _L100
        if(true) goto _L105; else goto _L111
_L111:
_L99:
        typedarray3.recycle();
        setFocusable(flag10);
        setClickable(flag11);
        setLongClickable(flag12);
        if(mEditor != null)
            mEditor.prepareCursorControllers();
        if(getImportantForAccessibility() == 0)
            setImportantForAccessibility(1);
        return;
        if(true) goto _L113; else goto _L112
_L112:
    }

    private void applySingleLine(boolean flag, boolean flag1, boolean flag2) {
        mSingleLine = flag;
        if(!flag) goto _L2; else goto _L1
_L1:
        setLines(1);
        setHorizontallyScrolling(true);
        if(flag1)
            setTransformationMethod(SingleLineTransformationMethod.getInstance());
_L4:
        return;
_L2:
        if(flag2)
            setMaxLines(0x7fffffff);
        setHorizontallyScrolling(false);
        if(flag1)
            setTransformationMethod(null);
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void assumeLayout() {
        int i = super.mRight - super.mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight();
        if(i < 1)
            i = 0;
        int j = i;
        if(mHorizontallyScrolling)
            i = 0x100000;
        makeNewLayout(i, j, UNKNOWN_BORING, UNKNOWN_BORING, j, false);
    }

    private boolean bringTextIntoView() {
        boolean flag = true;
        Layout layout;
        int i;
        android.text.Layout.Alignment alignment;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        if(isShowingHint())
            layout = mHintLayout;
        else
            layout = mLayout;
        i = 0;
        if((0x70 & mGravity) == 80)
            i = -1 + layout.getLineCount();
        alignment = layout.getParagraphAlignment(i);
        j = layout.getParagraphDirection(i);
        k = super.mRight - super.mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight();
        l = super.mBottom - super.mTop - getExtendedPaddingTop() - getExtendedPaddingBottom();
        i1 = layout.getHeight();
        if(alignment == android.text.Layout.Alignment.ALIGN_NORMAL) {
            if(j == flag)
                alignment = android.text.Layout.Alignment.ALIGN_LEFT;
            else
                alignment = android.text.Layout.Alignment.ALIGN_RIGHT;
        } else
        if(alignment == android.text.Layout.Alignment.ALIGN_OPPOSITE)
            if(j == flag)
                alignment = android.text.Layout.Alignment.ALIGN_RIGHT;
            else
                alignment = android.text.Layout.Alignment.ALIGN_LEFT;
        if(alignment == android.text.Layout.Alignment.ALIGN_CENTER) {
            int l1 = (int)FloatMath.floor(layout.getLineLeft(i));
            int i2 = (int)FloatMath.ceil(layout.getLineRight(i));
            if(i2 - l1 < k)
                j1 = (i2 + l1) / 2 - k / 2;
            else
            if(j < 0)
                j1 = i2 - k;
            else
                j1 = l1;
        } else
        if(alignment == android.text.Layout.Alignment.ALIGN_RIGHT)
            j1 = (int)FloatMath.ceil(layout.getLineRight(i)) - k;
        else
            j1 = (int)FloatMath.floor(layout.getLineLeft(i));
        if(i1 < l)
            k1 = 0;
        else
        if((0x70 & mGravity) == 80)
            k1 = i1 - l;
        else
            k1 = 0;
        if(j1 != super.mScrollX || k1 != super.mScrollY)
            scrollTo(j1, k1);
        else
            flag = false;
        return flag;
    }

    private boolean canMarquee() {
        boolean flag = false;
        int i = super.mRight - super.mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight();
        if(i > 0 && (mLayout.getLineWidth(0) > (float)i || mMarqueeFadeMode != 0 && mSavedMarqueeModeLayout != null && mSavedMarqueeModeLayout.getLineWidth(0) > (float)i))
            flag = true;
        return flag;
    }

    private boolean canSelectText() {
        boolean flag;
        if(mText.length() != 0 && mEditor != null && mEditor.hasSelectionController())
            flag = true;
        else
            flag = false;
        return flag;
    }

    private void checkForRelayout() {
        if(super.mLayoutParams.width == -2 && (mMaxWidthMode != mMinWidthMode || mMaxWidth != mMinWidth) || mHint != null && mHintLayout == null || super.mRight - super.mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight() <= 0) goto _L2; else goto _L1
_L1:
        int i;
        i = mLayout.getHeight();
        int j = mLayout.getWidth();
        int k;
        if(mHintLayout == null)
            k = 0;
        else
            k = mHintLayout.getWidth();
        makeNewLayout(j, k, UNKNOWN_BORING, UNKNOWN_BORING, super.mRight - super.mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight(), false);
        if(mEllipsize == android.text.TextUtils.TruncateAt.MARQUEE) goto _L4; else goto _L3
_L3:
        if(super.mLayoutParams.height == -2 || super.mLayoutParams.height == -1) goto _L6; else goto _L5
_L5:
        invalidate();
_L8:
        return;
_L6:
        if(mLayout.getHeight() == i && (mHintLayout == null || mHintLayout.getHeight() == i)) {
            invalidate();
            continue; /* Loop/switch isn't completed */
        }
_L4:
        requestLayout();
        invalidate();
        continue; /* Loop/switch isn't completed */
_L2:
        nullLayouts();
        requestLayout();
        invalidate();
        if(true) goto _L8; else goto _L7
_L7:
    }

    private void checkForResize() {
        boolean flag = false;
        if(mLayout == null) goto _L2; else goto _L1
_L1:
        if(super.mLayoutParams.width == -2) {
            flag = true;
            invalidate();
        }
        if(super.mLayoutParams.height != -2) goto _L4; else goto _L3
_L3:
        if(getDesiredHeight() != getHeight())
            flag = true;
_L2:
        if(flag)
            requestLayout();
        return;
_L4:
        if(super.mLayoutParams.height == -1 && mDesiredHeightAtMeasure >= 0 && getDesiredHeight() != mDesiredHeightAtMeasure)
            flag = true;
        if(true) goto _L2; else goto _L5
_L5:
    }

    private boolean compressText(float f) {
        boolean flag;
        flag = false;
        break MISSING_BLOCK_LABEL_2;
        while(true)  {
            do
                return flag;
            while(isHardwareAccelerated() || f <= 0.0F || mLayout == null || getLineCount() != 1 || mUserSetTextScaleX || mTextPaint.getTextScaleX() != 1.0F);
            float f1 = ((1.0F + mLayout.getLineWidth(0)) - f) / f;
            if(f1 > 0.0F && f1 <= 0.07F) {
                mTextPaint.setTextScaleX(1.0F - f1 - 0.005F);
                post(new Runnable() {

                    public void run() {
                        requestLayout();
                    }

                    final TextView this$0;

             {
                this$0 = TextView.this;
                super();
            }
                });
                flag = true;
            }
        }
    }

    private void convertFromViewportToContentCoordinates(Rect rect) {
        int i = viewportToContentHorizontalOffset();
        rect.left = i + rect.left;
        rect.right = i + rect.right;
        int j = viewportToContentVerticalOffset();
        rect.top = j + rect.top;
        rect.bottom = j + rect.bottom;
    }

    private void createEditorIfNeeded() {
        if(mEditor == null)
            mEditor = new Editor(this);
    }

    private static int desired(Layout layout) {
        int i;
        CharSequence charsequence;
        float f;
        int j;
        i = layout.getLineCount();
        charsequence = layout.getText();
        f = 0.0F;
        j = 0;
_L3:
        if(j >= i - 1)
            break MISSING_BLOCK_LABEL_56;
        if(charsequence.charAt(-1 + layout.getLineEnd(j)) == '\n') goto _L2; else goto _L1
_L1:
        int l = -1;
_L4:
        return l;
_L2:
        j++;
          goto _L3
        for(int k = 0; k < i; k++)
            f = Math.max(f, layout.getLineWidth(k));

        l = (int)FloatMath.ceil(f);
          goto _L4
    }

    private int doKeyDown(int i, KeyEvent keyevent, KeyEvent keyevent1) {
        if(isEnabled()) goto _L2; else goto _L1
_L1:
        int j = 0;
_L21:
        return j;
_L2:
        i;
        JVM INSTR lookupswitch 4: default 56
    //                   4: 295
    //                   23: 247
    //                   61: 267
    //                   66: 134;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        if(mEditor == null || mEditor.mKeyListener == null) goto _L9; else goto _L8
_L8:
        boolean flag2;
        resetErrorChangedFlag();
        flag2 = true;
        if(keyevent1 == null) goto _L11; else goto _L10
_L10:
        boolean flag4;
        beginBatchEdit();
        flag4 = mEditor.mKeyListener.onKeyOther(this, (Editable)mText, keyevent1);
        hideErrorIfUnchanged();
        flag2 = false;
        if(flag4) {
            endBatchEdit();
            j = -1;
            continue; /* Loop/switch isn't completed */
        }
          goto _L12
_L7:
        if(!keyevent.hasNoModifiers()) goto _L3; else goto _L13
_L13:
        if(mEditor == null || mEditor.mInputContentType == null || mEditor.mInputContentType.onEditorActionListener == null || !mEditor.mInputContentType.onEditorActionListener.onEditorAction(this, 0, keyevent))
            continue; /* Loop/switch isn't completed */
        mEditor.mInputContentType.enterDown = true;
        j = -1;
        continue; /* Loop/switch isn't completed */
        if((0x10 & keyevent.getFlags()) == 0 && !shouldAdvanceFocusOnEnter()) goto _L3; else goto _L14
_L14:
        if(hasOnClickListeners())
            j = 0;
        else
            j = -1;
        continue; /* Loop/switch isn't completed */
_L5:
        if(!keyevent.hasNoModifiers() || !shouldAdvanceFocusOnEnter()) goto _L3; else goto _L15
_L15:
        j = 0;
        continue; /* Loop/switch isn't completed */
_L6:
        if(!keyevent.hasNoModifiers() && !keyevent.hasModifiers(1) || !shouldAdvanceFocusOnTab()) goto _L3; else goto _L16
_L16:
        j = 0;
        continue; /* Loop/switch isn't completed */
_L4:
        if(mEditor == null || mEditor.mSelectionActionMode == null) goto _L3; else goto _L17
_L17:
        stopSelectionActionMode();
        j = -1;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        endBatchEdit();
        throw exception;
        AbstractMethodError abstractmethoderror1;
        abstractmethoderror1;
_L12:
        endBatchEdit();
_L11:
        if(flag2) {
            beginBatchEdit();
            boolean flag3 = mEditor.mKeyListener.onKeyDown(this, (Editable)mText, i, keyevent);
            endBatchEdit();
            hideErrorIfUnchanged();
            if(flag3) {
                j = 1;
                continue; /* Loop/switch isn't completed */
            }
        }
_L9:
        if(mMovement == null || mLayout == null) goto _L19; else goto _L18
_L18:
        boolean flag;
        flag = true;
        if(keyevent1 == null)
            break MISSING_BLOCK_LABEL_448;
        boolean flag1 = mMovement.onKeyOther(this, (Spannable)mText, keyevent1);
        flag = false;
        if(flag1) {
            j = -1;
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_448;
        AbstractMethodError abstractmethoderror;
        abstractmethoderror;
        if(flag && mMovement.onKeyDown(this, (Spannable)mText, i, keyevent)) {
            j = 2;
            continue; /* Loop/switch isn't completed */
        }
_L19:
        j = 0;
        if(true) goto _L21; else goto _L20
_L20:
    }

    private void fixFocusableAndClickableSettings() {
        if(mMovement != null || mEditor != null && mEditor.mKeyListener != null) {
            setFocusable(true);
            setClickable(true);
            setLongClickable(true);
        } else {
            setFocusable(false);
            setClickable(false);
            setLongClickable(false);
        }
    }

    private int getBottomVerticalOffset(boolean flag) {
        int i = 0;
        int j = 0x70 & mGravity;
        Layout layout = mLayout;
        if(!flag && mText.length() == 0 && mHintLayout != null)
            layout = mHintLayout;
        if(j != 80) {
            int k;
            int l;
            if(layout == mHintLayout)
                k = getMeasuredHeight() - getCompoundPaddingTop() - getCompoundPaddingBottom();
            else
                k = getMeasuredHeight() - getExtendedPaddingTop() - getExtendedPaddingBottom();
            l = layout.getHeight();
            if(l < k)
                if(j == 48)
                    i = k - l;
                else
                    i = k - l >> 1;
        }
        return i;
    }

    private int getDesiredHeight() {
        boolean flag = true;
        int i = getDesiredHeight(mLayout, flag);
        Layout layout = mHintLayout;
        if(mEllipsize == null)
            flag = false;
        return Math.max(i, getDesiredHeight(layout, flag));
    }

    private int getDesiredHeight(Layout layout, boolean flag) {
        int i1;
        if(layout == null) {
            i1 = 0;
        } else {
            int i = layout.getLineCount();
            int j = getCompoundPaddingTop() + getCompoundPaddingBottom();
            int k = layout.getLineTop(i);
            Drawables drawables = mDrawables;
            if(drawables != null)
                k = Math.max(Math.max(k, drawables.mDrawableHeightLeft), drawables.mDrawableHeightRight);
            int l = k + j;
            if(mMaxMode == 1) {
                if(flag && i > mMaximum) {
                    int j1 = layout.getLineTop(mMaximum);
                    if(drawables != null)
                        j1 = Math.max(Math.max(j1, drawables.mDrawableHeightLeft), drawables.mDrawableHeightRight);
                    l = j1 + j;
                    i = mMaximum;
                }
            } else {
                l = Math.min(l, mMaximum);
            }
            if(mMinMode == 1) {
                if(i < mMinimum)
                    l += getLineHeight() * (mMinimum - i);
            } else {
                l = Math.max(l, mMinimum);
            }
            i1 = Math.max(l, getSuggestedMinimumHeight());
        }
        return i1;
    }

    private void getInterestingRect(Rect rect, int i) {
        convertFromViewportToContentCoordinates(rect);
        if(i == 0)
            rect.top = rect.top - getExtendedPaddingTop();
        if(i == -1 + mLayout.getLineCount())
            rect.bottom = rect.bottom + getExtendedPaddingBottom();
    }

    private android.text.Layout.Alignment getLayoutAlignment() {
        if(mLayoutAlignment != null) goto _L2; else goto _L1
_L1:
        getResolvedTextAlignment();
        JVM INSTR tableswitch 1 6: default 48
    //                   1 60
    //                   2 180
    //                   3 190
    //                   4 200
    //                   5 210
    //                   6 237;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L3:
        mLayoutAlignment = android.text.Layout.Alignment.ALIGN_NORMAL;
_L2:
        return mLayoutAlignment;
_L4:
        switch(0x800007 & mGravity) {
        default:
            mLayoutAlignment = android.text.Layout.Alignment.ALIGN_NORMAL;
            break;

        case 8388611: 
            mLayoutAlignment = android.text.Layout.Alignment.ALIGN_NORMAL;
            break;

        case 8388613: 
            mLayoutAlignment = android.text.Layout.Alignment.ALIGN_OPPOSITE;
            break;

        case 3: // '\003'
            mLayoutAlignment = android.text.Layout.Alignment.ALIGN_LEFT;
            break;

        case 5: // '\005'
            mLayoutAlignment = android.text.Layout.Alignment.ALIGN_RIGHT;
            break;

        case 1: // '\001'
            mLayoutAlignment = android.text.Layout.Alignment.ALIGN_CENTER;
            break;
        }
        if(false)
            ;
        continue; /* Loop/switch isn't completed */
_L5:
        mLayoutAlignment = android.text.Layout.Alignment.ALIGN_NORMAL;
        continue; /* Loop/switch isn't completed */
_L6:
        mLayoutAlignment = android.text.Layout.Alignment.ALIGN_OPPOSITE;
        continue; /* Loop/switch isn't completed */
_L7:
        mLayoutAlignment = android.text.Layout.Alignment.ALIGN_CENTER;
        continue; /* Loop/switch isn't completed */
_L8:
        android.text.Layout.Alignment alignment1;
        if(getResolvedLayoutDirection() == 1)
            alignment1 = android.text.Layout.Alignment.ALIGN_RIGHT;
        else
            alignment1 = android.text.Layout.Alignment.ALIGN_LEFT;
        mLayoutAlignment = alignment1;
        continue; /* Loop/switch isn't completed */
_L9:
        android.text.Layout.Alignment alignment;
        if(getResolvedLayoutDirection() == 1)
            alignment = android.text.Layout.Alignment.ALIGN_LEFT;
        else
            alignment = android.text.Layout.Alignment.ALIGN_RIGHT;
        mLayoutAlignment = alignment;
        if(true) goto _L2; else goto _L10
_L10:
    }

    private int getOffsetAtCoordinate(int i, float f) {
        float f1 = convertToLocalHorizontalCoordinate(f);
        return getLayout().getOffsetForHorizontal(i, f1);
    }

    public static int getTextColor(Context context, TypedArray typedarray, int i) {
        ColorStateList colorstatelist = getTextColors(context, typedarray);
        if(colorstatelist != null)
            i = colorstatelist.getDefaultColor();
        return i;
    }

    public static ColorStateList getTextColors(Context context, TypedArray typedarray) {
        ColorStateList colorstatelist = typedarray.getColorStateList(5);
        if(colorstatelist == null) {
            int i = typedarray.getResourceId(1, -1);
            if(i != -1) {
                TypedArray typedarray1 = context.obtainStyledAttributes(i, com.android.internal.R.styleable.TextAppearance);
                colorstatelist = typedarray1.getColorStateList(3);
                typedarray1.recycle();
            }
        }
        return colorstatelist;
    }

    private Path getUpdatedHighlightPath() {
        Path path = null;
        Paint paint = mHighlightPaint;
        int i = getSelectionStart();
        int j = getSelectionEnd();
        if(mMovement != null && (isFocused() || isPressed()) && i >= 0)
            if(i == j) {
                if(mEditor != null && mEditor.isCursorVisible() && (SystemClock.uptimeMillis() - mEditor.mShowCursor) % 1000L < 500L) {
                    if(mHighlightPathBogus) {
                        if(mHighlightPath == null)
                            mHighlightPath = new Path();
                        mHighlightPath.reset();
                        mLayout.getCursorPath(i, mHighlightPath, mText);
                        mEditor.updateCursorsPositions();
                        mHighlightPathBogus = false;
                    }
                    paint.setColor(mCurTextColor);
                    paint.setStyle(android.graphics.Paint.Style.STROKE);
                    path = mHighlightPath;
                }
            } else {
                if(mHighlightPathBogus) {
                    if(mHighlightPath == null)
                        mHighlightPath = new Path();
                    mHighlightPath.reset();
                    mLayout.getSelectionPath(i, j, mHighlightPath);
                    mHighlightPathBogus = false;
                }
                paint.setColor(mHighlightColor);
                paint.setStyle(android.graphics.Paint.Style.FILL);
                path = mHighlightPath;
            }
        return path;
    }

    private boolean hasPasswordTransformationMethod() {
        return mTransformation instanceof PasswordTransformationMethod;
    }

    private void invalidateCursor(int i, int j, int k) {
        if(i >= 0 || j >= 0 || k >= 0)
            invalidateRegion(Math.min(Math.min(i, j), k), Math.max(Math.max(i, j), k), true);
    }

    private static boolean isMultilineInputType(int i) {
        boolean flag;
        if((0x2000f & i) == 0x20001)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static boolean isPasswordInputType(int i) {
        int j = i & 0xfff;
        boolean flag;
        if(j == 129 || j == 225 || j == 18)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private boolean isShowingHint() {
        boolean flag;
        if(TextUtils.isEmpty(mText) && !TextUtils.isEmpty(mHint))
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static boolean isVisiblePasswordInputType(int i) {
        boolean flag;
        if((i & 0xfff) == 145)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private Layout makeSingleLayout(int i, android.text.BoringLayout.Metrics metrics, int j, android.text.Layout.Alignment alignment, boolean flag, android.text.TextUtils.TruncateAt truncateat, boolean flag1) {
        if(!(mText instanceof Spannable)) goto _L2; else goto _L1
_L1:
        Object obj;
        CharSequence charsequence6 = mText;
        CharSequence charsequence7 = mTransformed;
        TextPaint textpaint6 = mTextPaint;
        TextDirectionHeuristic textdirectionheuristic2 = mTextDir;
        float f12 = mSpacingMult;
        float f13 = mSpacingAdd;
        boolean flag8 = mIncludePad;
        android.text.TextUtils.TruncateAt truncateat1;
        if(getKeyListener() == null)
            truncateat1 = truncateat;
        else
            truncateat1 = null;
        obj = new DynamicLayout(charsequence6, charsequence7, textpaint6, i, alignment, textdirectionheuristic2, f12, f13, flag8, truncateat1, j);
_L4:
        return ((Layout) (obj));
_L2:
        android.text.BoringLayout.Metrics metrics1 = UNKNOWN_BORING;
        if(metrics == metrics1) {
            metrics = BoringLayout.isBoring(mTransformed, mTextPaint, mTextDir, mBoring);
            if(metrics != null)
                mBoring = metrics;
        }
        if(metrics != null) {
            if(metrics.width <= i && (truncateat == null || metrics.width <= j)) {
                if(flag1 && mSavedLayout != null) {
                    BoringLayout boringlayout1 = mSavedLayout;
                    CharSequence charsequence5 = mTransformed;
                    TextPaint textpaint5 = mTextPaint;
                    float f10 = mSpacingMult;
                    float f11 = mSpacingAdd;
                    boolean flag7 = mIncludePad;
                    obj = boringlayout1.replaceOrMake(charsequence5, textpaint5, i, alignment, f10, f11, metrics, flag7);
                } else {
                    CharSequence charsequence4 = mTransformed;
                    TextPaint textpaint4 = mTextPaint;
                    float f8 = mSpacingMult;
                    float f9 = mSpacingAdd;
                    boolean flag6 = mIncludePad;
                    obj = BoringLayout.make(charsequence4, textpaint4, i, alignment, f8, f9, metrics, flag6);
                }
                if(flag1)
                    mSavedLayout = (BoringLayout)obj;
            } else
            if(flag && metrics.width <= i) {
                if(flag1 && mSavedLayout != null) {
                    BoringLayout boringlayout = mSavedLayout;
                    CharSequence charsequence3 = mTransformed;
                    TextPaint textpaint3 = mTextPaint;
                    float f6 = mSpacingMult;
                    float f7 = mSpacingAdd;
                    boolean flag5 = mIncludePad;
                    obj = boringlayout.replaceOrMake(charsequence3, textpaint3, i, alignment, f6, f7, metrics, flag5, truncateat, j);
                } else {
                    CharSequence charsequence2 = mTransformed;
                    TextPaint textpaint2 = mTextPaint;
                    float f4 = mSpacingMult;
                    float f5 = mSpacingAdd;
                    boolean flag4 = mIncludePad;
                    obj = BoringLayout.make(charsequence2, textpaint2, i, alignment, f4, f5, metrics, flag4, truncateat, j);
                }
            } else
            if(flag) {
                CharSequence charsequence1 = mTransformed;
                int i1 = mTransformed.length();
                TextPaint textpaint1 = mTextPaint;
                TextDirectionHeuristic textdirectionheuristic1 = mTextDir;
                float f2 = mSpacingMult;
                float f3 = mSpacingAdd;
                boolean flag3 = mIncludePad;
                int j1;
                if(mMaxMode == 1)
                    j1 = mMaximum;
                else
                    j1 = 0x7fffffff;
                obj = new StaticLayout(charsequence1, 0, i1, textpaint1, i, alignment, textdirectionheuristic1, f2, f3, flag3, truncateat, j, j1);
            } else {
                obj = new StaticLayout(mTransformed, mTextPaint, i, alignment, mTextDir, mSpacingMult, mSpacingAdd, mIncludePad);
            }
        } else
        if(flag) {
            CharSequence charsequence = mTransformed;
            int k = mTransformed.length();
            TextPaint textpaint = mTextPaint;
            TextDirectionHeuristic textdirectionheuristic = mTextDir;
            float f = mSpacingMult;
            float f1 = mSpacingAdd;
            boolean flag2 = mIncludePad;
            int l;
            if(mMaxMode == 1)
                l = mMaximum;
            else
                l = 0x7fffffff;
            obj = new StaticLayout(charsequence, 0, k, textpaint, i, alignment, textdirectionheuristic, f, f1, flag2, truncateat, j, l);
        } else {
            obj = new StaticLayout(mTransformed, mTextPaint, i, alignment, mTextDir, mSpacingMult, mSpacingAdd, mIncludePad);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private void nullLayouts() {
        if((mLayout instanceof BoringLayout) && mSavedLayout == null)
            mSavedLayout = (BoringLayout)mLayout;
        if((mHintLayout instanceof BoringLayout) && mSavedHintLayout == null)
            mSavedHintLayout = (BoringLayout)mHintLayout;
        mHintLayout = null;
        mLayout = null;
        mSavedMarqueeModeLayout = null;
        mHintBoring = null;
        mBoring = null;
        if(mEditor != null)
            mEditor.prepareCursorControllers();
    }

    private void paste(int i, int j) {
        ClipData clipdata = ((ClipboardManager)getContext().getSystemService("clipboard")).getPrimaryClip();
        if(clipdata != null) {
            boolean flag = false;
            int k = 0;
            while(k < clipdata.getItemCount())  {
                CharSequence charsequence = clipdata.getItemAt(k).coerceToStyledText(getContext());
                if(charsequence != null)
                    if(!flag) {
                        long l = prepareSpacesAroundPaste(i, j, charsequence);
                        i = TextUtils.unpackRangeStartFromLong(l);
                        j = TextUtils.unpackRangeEndFromLong(l);
                        Selection.setSelection((Spannable)mText, j);
                        ((Editable)mText).replace(i, j, charsequence);
                        flag = true;
                    } else {
                        ((Editable)mText).insert(getSelectionEnd(), "\n");
                        ((Editable)mText).insert(getSelectionEnd(), charsequence);
                    }
                k++;
            }
            stopSelectionActionMode();
            LAST_CUT_OR_COPY_TIME = 0L;
        }
    }

    private void registerForPreDraw() {
        if(!mPreDrawRegistered) {
            getViewTreeObserver().addOnPreDrawListener(this);
            mPreDrawRegistered = true;
        }
    }

    private void removeIntersectingSpans(int i, int j, Class class1) {
        if(mText instanceof Editable) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Editable editable;
        Object aobj[];
        int k;
        int l;
        editable = (Editable)mText;
        aobj = editable.getSpans(i, j, class1);
        k = aobj.length;
        l = 0;
_L5:
        if(l >= k) goto _L1; else goto _L3
_L3:
        int i1 = editable.getSpanStart(aobj[l]);
        if(editable.getSpanEnd(aobj[l]) == i || i1 == j) goto _L1; else goto _L4
_L4:
        editable.removeSpan(aobj[l]);
        l++;
          goto _L5
    }

    static void removeParcelableSpans(Spannable spannable, int i, int j) {
        Object aobj[] = spannable.getSpans(i, j, android/text/ParcelableSpan);
        for(int k = aobj.length; k > 0;) {
            k--;
            spannable.removeSpan(aobj[k]);
        }

    }

    private void restartMarqueeIfNeeded() {
        if(mRestartMarquee && mEllipsize == android.text.TextUtils.TruncateAt.MARQUEE) {
            mRestartMarquee = false;
            startMarquee();
        }
    }

    private void sendBeforeTextChanged(CharSequence charsequence, int i, int j, int k) {
        if(mListeners != null) {
            ArrayList arraylist = mListeners;
            int l = arraylist.size();
            for(int i1 = 0; i1 < l; i1++)
                ((TextWatcher)arraylist.get(i1)).beforeTextChanged(charsequence, i, j, k);

        }
        removeIntersectingSpans(i, i + j, android/text/style/SpellCheckSpan);
        removeIntersectingSpans(i, i + j, android/text/style/SuggestionSpan);
    }

    private void setFilters(Editable editable, InputFilter ainputfilter[]) {
        if(mEditor != null && (mEditor.mKeyListener instanceof InputFilter)) {
            InputFilter ainputfilter1[] = new InputFilter[1 + ainputfilter.length];
            System.arraycopy(ainputfilter, 0, ainputfilter1, 0, ainputfilter.length);
            ainputfilter1[ainputfilter.length] = (InputFilter)mEditor.mKeyListener;
            editable.setFilters(ainputfilter1);
        } else {
            editable.setFilters(ainputfilter);
        }
    }

    private void setInputType(int i, boolean flag) {
        int j;
        Object obj;
        boolean flag1 = true;
        j = i & 0xf;
        if(j == flag1) {
            boolean flag3;
            android.text.method.TextKeyListener.Capitalize capitalize;
            if((0x8000 & i) != 0)
                flag3 = flag1;
            else
                flag3 = false;
            if((i & 0x1000) != 0)
                capitalize = android.text.method.TextKeyListener.Capitalize.CHARACTERS;
            else
            if((i & 0x2000) != 0)
                capitalize = android.text.method.TextKeyListener.Capitalize.WORDS;
            else
            if((i & 0x4000) != 0)
                capitalize = android.text.method.TextKeyListener.Capitalize.SENTENCES;
            else
                capitalize = android.text.method.TextKeyListener.Capitalize.NONE;
            obj = TextKeyListener.getInstance(flag3, capitalize);
        } else {
label0:
            {
                if(j != 2)
                    break label0;
                boolean flag2;
                if((i & 0x1000) != 0)
                    flag2 = flag1;
                else
                    flag2 = false;
                if((i & 0x2000) == 0)
                    flag1 = false;
                obj = DigitsKeyListener.getInstance(flag2, flag1);
            }
        }
_L2:
        setRawInputType(i);
        if(flag) {
            createEditorIfNeeded();
            mEditor.mKeyListener = ((KeyListener) (obj));
        } else {
            setKeyListenerOnly(((KeyListener) (obj)));
        }
        return;
        if(j == 4)
            switch(i & 0xff0) {
            default:
                obj = DateTimeKeyListener.getInstance();
                break;

            case 16: // '\020'
                obj = DateKeyListener.getInstance();
                break;

            case 32: // ' '
                obj = TimeKeyListener.getInstance();
                break;
            }
        else
        if(j == 3)
            obj = DialerKeyListener.getInstance();
        else
            obj = TextKeyListener.getInstance();
        if(true) goto _L2; else goto _L1
_L1:
    }

    private void setInputTypeSingleLine(boolean flag) {
        if(mEditor != null && (0xf & mEditor.mInputType) == 1)
            if(flag) {
                Editor editor1 = mEditor;
                editor1.mInputType = 0xfffdffff & editor1.mInputType;
            } else {
                Editor editor = mEditor;
                editor.mInputType = 0x20000 | editor.mInputType;
            }
    }

    private void setKeyListenerOnly(KeyListener keylistener) {
        if(mEditor != null || keylistener != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        createEditorIfNeeded();
        if(mEditor.mKeyListener != keylistener) {
            mEditor.mKeyListener = keylistener;
            if(keylistener != null && !(mText instanceof Editable))
                setText(mText);
            setFilters((Editable)mText, mFilters);
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    private void setPrimaryClip(ClipData clipdata) {
        ((ClipboardManager)getContext().getSystemService("clipboard")).setPrimaryClip(clipdata);
        LAST_CUT_OR_COPY_TIME = SystemClock.uptimeMillis();
    }

    private void setRawTextSize(float f) {
        if(f != mTextPaint.getTextSize()) {
            mTextPaint.setTextSize(f);
            if(mLayout != null) {
                nullLayouts();
                requestLayout();
                invalidate();
            }
        }
    }

    private void setRelativeDrawablesIfNeeded(Drawable drawable, Drawable drawable1) {
        boolean flag;
        if(drawable != null || drawable1 != null)
            flag = true;
        else
            flag = false;
        if(flag) {
            Drawables drawables = mDrawables;
            if(drawables == null) {
                drawables = new Drawables();
                mDrawables = drawables;
            }
            Rect rect = drawables.mCompoundRect;
            int ai[] = getDrawableState();
            if(drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                drawable.setState(ai);
                drawable.copyBounds(rect);
                drawable.setCallback(this);
                drawables.mDrawableStart = drawable;
                drawables.mDrawableSizeStart = rect.width();
                drawables.mDrawableHeightStart = rect.height();
            } else {
                drawables.mDrawableHeightStart = 0;
                drawables.mDrawableSizeStart = 0;
            }
            if(drawable1 != null) {
                drawable1.setBounds(0, 0, drawable1.getIntrinsicWidth(), drawable1.getIntrinsicHeight());
                drawable1.setState(ai);
                drawable1.copyBounds(rect);
                drawable1.setCallback(this);
                drawables.mDrawableEnd = drawable1;
                drawables.mDrawableSizeEnd = rect.width();
                drawables.mDrawableHeightEnd = rect.height();
            } else {
                drawables.mDrawableHeightEnd = 0;
                drawables.mDrawableSizeEnd = 0;
            }
        }
    }

    private void setText(CharSequence charsequence, BufferType buffertype, boolean flag, int i) {
        if(charsequence == null)
            charsequence = "";
        if(!isSuggestionsEnabled())
            charsequence = removeSuggestionSpans(charsequence);
        CharSequence charsequence1 = mText;
        boolean flag1;
        if(!charsequence.equals(charsequence1))
            flag1 = true;
        else
            flag1 = false;
        if(!mUserSetTextScaleX)
            mTextPaint.setTextScaleX(1.0F);
        if((charsequence instanceof Spanned) && ((Spanned)charsequence).getSpanStart(android.text.TextUtils.TruncateAt.MARQUEE) >= 0) {
            int j;
            int k;
            InputFilter inputfilter;
            int i2;
            Spanned spanned;
            CharSequence charsequence3;
            if(ViewConfiguration.get(super.mContext).isFadingMarqueeEnabled()) {
                setHorizontalFadingEdgeEnabled(true);
                mMarqueeFadeMode = 0;
            } else {
                setHorizontalFadingEdgeEnabled(false);
                mMarqueeFadeMode = 1;
            }
            setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        }
        j = mFilters.length;
        for(k = 0; k < j; k++) {
            inputfilter = mFilters[k];
            i2 = charsequence.length();
            spanned = EMPTY_SPANNED;
            charsequence3 = inputfilter.filter(charsequence, 0, i2, spanned, 0, 0);
            if(charsequence3 != null)
                charsequence = charsequence3;
        }

        boolean flag2;
        BufferType buffertype1;
        int l;
        if(flag)
            if(mText != null) {
                i = mText.length();
                CharSequence charsequence2 = mText;
                int l1 = charsequence.length();
                sendBeforeTextChanged(charsequence2, 0, i, l1);
            } else {
                sendBeforeTextChanged("", 0, 0, charsequence.length());
            }
        flag2 = false;
        if(mListeners != null && mListeners.size() != 0)
            flag2 = true;
        buffertype1 = BufferType.EDITABLE;
        if(buffertype == buffertype1 || getKeyListener() != null || flag2) {
            createEditorIfNeeded();
            Editable editable = mEditableFactory.newEditable(charsequence);
            charsequence = editable;
            setFilters(editable, mFilters);
            InputMethodManager inputmethodmanager = InputMethodManager.peekInstance();
            if(inputmethodmanager != null)
                inputmethodmanager.restartInput(this);
        } else {
            BufferType buffertype4 = BufferType.SPANNABLE;
            if(buffertype == buffertype4 || mMovement != null)
                charsequence = mSpannableFactory.newSpannable(charsequence);
            else
            if(!(charsequence instanceof CharWrapper))
                charsequence = TextUtils.stringOrSpannedString(charsequence);
        }
        if(mAutoLinkMask != 0) {
            BufferType buffertype2 = BufferType.EDITABLE;
            Spannable spannable1;
            int k1;
            if(buffertype == buffertype2 || (charsequence instanceof Spannable))
                spannable1 = (Spannable)charsequence;
            else
                spannable1 = mSpannableFactory.newSpannable(charsequence);
            k1 = mAutoLinkMask;
            if(Linkify.addLinks(spannable1, k1)) {
                charsequence = spannable1;
                BufferType buffertype3 = BufferType.EDITABLE;
                ChangeWatcher achangewatcher[];
                int i1;
                int j1;
                if(buffertype == buffertype3)
                    buffertype = BufferType.EDITABLE;
                else
                    buffertype = BufferType.SPANNABLE;
                mText = charsequence;
                if(mLinksClickable && !textCanBeSelected())
                    setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        mBufferType = buffertype;
        mText = charsequence;
        if(mTransformation == null)
            mTransformed = charsequence;
        else
            mTransformed = mTransformation.getTransformation(charsequence, this);
        l = charsequence.length();
        if((charsequence instanceof Spannable) && !mAllowTransformationLengthChange) {
            Spannable spannable = (Spannable)charsequence;
            achangewatcher = (ChangeWatcher[])spannable.getSpans(0, spannable.length(), android/widget/TextView$ChangeWatcher);
            i1 = achangewatcher.length;
            for(j1 = 0; j1 < i1; j1++)
                spannable.removeSpan(achangewatcher[j1]);

            if(mChangeWatcher == null)
                mChangeWatcher = new ChangeWatcher();
            spannable.setSpan(mChangeWatcher, 0, l, 0x640012);
            if(mEditor != null)
                mEditor.addSpanWatchers(spannable);
            if(mTransformation != null)
                spannable.setSpan(mTransformation, 0, l, 18);
            if(mMovement != null) {
                mMovement.initialize(this, (Spannable)charsequence);
                if(mEditor != null)
                    mEditor.mSelectionMoved = false;
            }
        }
        if(mLayout != null)
            checkForRelayout();
        if(flag1)
            sendOnTextChanged(charsequence, 0, i, l);
        onTextChanged(charsequence, 0, i, l);
        if(flag2)
            sendAfterTextChanged((Editable)charsequence);
        if(mEditor != null)
            mEditor.prepareCursorControllers();
    }

    private void setTypefaceFromAttrs(String s, int i, int j) {
        Typeface typeface = null;
        if(s == null) goto _L2; else goto _L1
_L1:
        typeface = Typeface.create(s, j);
        if(typeface == null) goto _L2; else goto _L3
_L3:
        setTypeface(typeface);
_L9:
        return;
_L2:
        i;
        JVM INSTR tableswitch 1 3: default 52
    //                   1 62
    //                   2 70
    //                   3 78;
           goto _L4 _L5 _L6 _L7
_L7:
        break MISSING_BLOCK_LABEL_78;
_L4:
        break; /* Loop/switch isn't completed */
_L5:
        break; /* Loop/switch isn't completed */
_L10:
        setTypeface(typeface, j);
        if(true) goto _L9; else goto _L8
_L8:
        typeface = Typeface.SANS_SERIF;
          goto _L10
_L6:
        typeface = Typeface.SERIF;
          goto _L10
        typeface = Typeface.MONOSPACE;
          goto _L10
    }

    private boolean shouldAdvanceFocusOnEnter() {
        boolean flag = false;
        if(getKeyListener() != null) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if(mSingleLine)
            flag = true;
        else
        if(mEditor != null && (0xf & mEditor.mInputType) == 1) {
            int i = 0xff0 & mEditor.mInputType;
            if(i == 32 || i == 48)
                flag = true;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    private boolean shouldAdvanceFocusOnTab() {
        boolean flag = true;
        if(getKeyListener() != null && !mSingleLine && mEditor != null && (0xf & mEditor.mInputType) == flag) {
            int i = 0xff0 & mEditor.mInputType;
            if(i == 0x40000 || i == 0x20000)
                flag = false;
        }
        return flag;
    }

    private boolean shouldSpeakPasswordsForAccessibility() {
        boolean flag = true;
        if(android.provider.Settings.Secure.getInt(super.mContext.getContentResolver(), "speak_password", 0) != flag)
            flag = false;
        return flag;
    }

    private void startMarquee() {
        if(getKeyListener() == null && !compressText(getWidth() - getCompoundPaddingLeft() - getCompoundPaddingRight()) && (mMarquee == null || mMarquee.isStopped()) && (isFocused() || isSelected()) && getLineCount() == 1 && canMarquee()) {
            if(mMarqueeFadeMode == 1) {
                mMarqueeFadeMode = 2;
                Layout layout = mLayout;
                mLayout = mSavedMarqueeModeLayout;
                mSavedMarqueeModeLayout = layout;
                setHorizontalFadingEdgeEnabled(true);
                requestLayout();
                invalidate();
            }
            if(mMarquee == null)
                mMarquee = new Marquee(this);
            mMarquee.start(mMarqueeRepeatLimit);
        }
    }

    private void startStopMarquee(boolean flag) {
        if(mEllipsize == android.text.TextUtils.TruncateAt.MARQUEE)
            if(flag)
                startMarquee();
            else
                stopMarquee();
    }

    private void stopMarquee() {
        if(mMarquee != null && !mMarquee.isStopped())
            mMarquee.stop();
        if(mMarqueeFadeMode == 2) {
            mMarqueeFadeMode = 1;
            Layout layout = mSavedMarqueeModeLayout;
            mSavedMarqueeModeLayout = mLayout;
            mLayout = layout;
            setHorizontalFadingEdgeEnabled(false);
            requestLayout();
            invalidate();
        }
    }

    private void updateTextColors() {
        boolean flag = false;
        int i = mTextColor.getColorForState(getDrawableState(), 0);
        if(i != mCurTextColor) {
            mCurTextColor = i;
            flag = true;
        }
        if(mLinkTextColor != null) {
            int k = mLinkTextColor.getColorForState(getDrawableState(), 0);
            if(k != mTextPaint.linkColor) {
                mTextPaint.linkColor = k;
                flag = true;
            }
        }
        if(mHintTextColor != null) {
            int j = mHintTextColor.getColorForState(getDrawableState(), 0);
            if(j != mCurHintTextColor && mText.length() == 0) {
                mCurHintTextColor = j;
                flag = true;
            }
        }
        if(flag) {
            if(mEditor != null)
                mEditor.invalidateTextDisplayList();
            invalidate();
        }
    }

    public void addTextChangedListener(TextWatcher textwatcher) {
        if(mListeners == null)
            mListeners = new ArrayList();
        mListeners.add(textwatcher);
    }

    public final void append(CharSequence charsequence) {
        append(charsequence, 0, charsequence.length());
    }

    public void append(CharSequence charsequence, int i, int j) {
        if(!(mText instanceof Editable))
            setText(mText, BufferType.EDITABLE);
        ((Editable)mText).append(charsequence, i, j);
    }

    public void beginBatchEdit() {
        if(mEditor != null)
            mEditor.beginBatchEdit();
    }

    public boolean bringPointIntoView(int i) {
        boolean flag;
        Layout layout;
        boolean flag1;
        flag = false;
        if(isShowingHint())
            layout = mHintLayout;
        else
            layout = mLayout;
        if(layout != null) goto _L2; else goto _L1
_L1:
        flag1 = false;
_L8:
        return flag1;
_L2:
        int j;
        int k;
        int l;
        int j1;
        int k1;
        int l1;
        int i2;
        j = layout.getLineForOffset(i);
        k = (int)layout.getPrimaryHorizontal(i);
        l = layout.getLineTop(j);
        int i1 = j + 1;
        j1 = layout.getLineTop(i1);
        k1 = (int)FloatMath.floor(layout.getLineLeft(j));
        l1 = (int)FloatMath.ceil(layout.getLineRight(j));
        i2 = layout.getHeight();
        class _cls3 {

            static final int $SwitchMap$android$text$Layout$Alignment[];

            static  {
                $SwitchMap$android$text$Layout$Alignment = new int[android.text.Layout.Alignment.values().length];
                NoSuchFieldError nosuchfielderror4;
                try {
                    $SwitchMap$android$text$Layout$Alignment[android.text.Layout.Alignment.ALIGN_LEFT.ordinal()] = 1;
                }
                catch(NoSuchFieldError nosuchfielderror) { }
                try {
                    $SwitchMap$android$text$Layout$Alignment[android.text.Layout.Alignment.ALIGN_RIGHT.ordinal()] = 2;
                }
                catch(NoSuchFieldError nosuchfielderror1) { }
                try {
                    $SwitchMap$android$text$Layout$Alignment[android.text.Layout.Alignment.ALIGN_NORMAL.ordinal()] = 3;
                }
                catch(NoSuchFieldError nosuchfielderror2) { }
                try {
                    $SwitchMap$android$text$Layout$Alignment[android.text.Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 4;
                }
                catch(NoSuchFieldError nosuchfielderror3) { }
                $SwitchMap$android$text$Layout$Alignment[android.text.Layout.Alignment.ALIGN_CENTER.ordinal()] = 5;
_L2:
                return;
                nosuchfielderror4;
                if(true) goto _L2; else goto _L1
_L1:
            }
        }

        _cls3..SwitchMap.android.text.Layout.Alignment[layout.getParagraphAlignment(j).ordinal()];
        JVM INSTR tableswitch 1 4: default 144
    //                   1 521
    //                   2 527
    //                   3 534
    //                   4 545;
           goto _L3 _L4 _L5 _L6 _L7
_L7:
        break MISSING_BLOCK_LABEL_545;
_L3:
        int j2 = 0;
_L9:
label0:
        {
            int k2 = super.mRight - super.mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight();
            int l2 = super.mBottom - super.mTop - getExtendedPaddingTop() - getExtendedPaddingBottom();
            int i3 = (j1 - l) / 2;
            int j3 = i3;
            int k3 = l2 / 4;
            if(j3 > k3)
                j3 = l2 / 4;
            if(i3 > k2 / 4)
                i3 = k2 / 4;
            int l3 = super.mScrollX;
            int i4 = super.mScrollY;
            if(l - i4 < j3)
                i4 = l - j3;
            if(j1 - i4 > l2 - j3)
                i4 = j1 - (l2 - j3);
            if(i2 - i4 < l2)
                i4 = i2 - l2;
            if(0 - i4 > 0)
                i4 = 0;
            if(j2 != 0) {
                if(k - l3 < i3)
                    l3 = k - i3;
                if(k - l3 > k2 - i3)
                    l3 = k - (k2 - i3);
            }
            if(j2 < 0) {
                if(k1 - l3 > 0)
                    l3 = k1;
                if(l1 - l3 < k2)
                    l3 = l1 - k2;
            } else
            if(j2 > 0) {
                if(l1 - l3 < k2)
                    l3 = l1 - k2;
                if(k1 - l3 > 0)
                    l3 = k1;
            } else
            if(l1 - k1 <= k2)
                l3 = k1 - (k2 - (l1 - k1)) / 2;
            else
            if(k > l1 - i3)
                l3 = l1 - k2;
            else
            if(k < k1 + i3)
                l3 = k1;
            else
            if(k1 > l3)
                l3 = k1;
            else
            if(l1 < l3 + k2) {
                l3 = l1 - k2;
            } else {
                if(k - l3 < i3)
                    l3 = k - i3;
                if(k - l3 > k2 - i3)
                    l3 = k - (k2 - i3);
            }
            if(l3 == super.mScrollX) {
                int i5 = super.mScrollY;
                if(i4 == i5)
                    break label0;
            }
            if(mScroller == null) {
                scrollTo(l3, i4);
            } else {
                long l4 = AnimationUtils.currentAnimationTimeMillis() - mLastScroll;
                int j4 = l3 - super.mScrollX;
                int k4 = i4 - super.mScrollY;
                if(l4 > 250L) {
                    mScroller.startScroll(super.mScrollX, super.mScrollY, j4, k4);
                    awakenScrollBars(mScroller.getDuration());
                    invalidate();
                } else {
                    if(!mScroller.isFinished())
                        mScroller.abortAnimation();
                    scrollBy(j4, k4);
                }
                mLastScroll = AnimationUtils.currentAnimationTimeMillis();
            }
            flag = true;
        }
        if(isFocused()) {
            if(mTempRect == null)
                mTempRect = new Rect();
            mTempRect.set(k - 2, l, k + 2, j1);
            getInterestingRect(mTempRect, j);
            mTempRect.offset(super.mScrollX, super.mScrollY);
            if(requestRectangleOnScreen(mTempRect))
                flag = true;
        }
        flag1 = flag;
        if(true) goto _L8; else goto _L4
_L4:
        j2 = 1;
          goto _L9
_L5:
        j2 = -1;
          goto _L9
_L6:
        j2 = layout.getParagraphDirection(j);
          goto _L9
        j2 = -layout.getParagraphDirection(j);
          goto _L9
    }

    boolean canCopy() {
        boolean flag;
        flag = false;
        break MISSING_BLOCK_LABEL_2;
        if(!hasPasswordTransformationMethod() && mText.length() > 0 && hasSelection())
            flag = true;
        return flag;
    }

    boolean canCut() {
        boolean flag;
        flag = false;
        break MISSING_BLOCK_LABEL_2;
        if(!hasPasswordTransformationMethod() && mText.length() > 0 && hasSelection() && (mText instanceof Editable) && mEditor != null && mEditor.mKeyListener != null)
            flag = true;
        return flag;
    }

    boolean canPaste() {
        boolean flag;
        if((mText instanceof Editable) && mEditor != null && mEditor.mKeyListener != null && getSelectionStart() >= 0 && getSelectionEnd() >= 0 && ((ClipboardManager)getContext().getSystemService("clipboard")).hasPrimaryClip())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void cancelLongPress() {
        cancelLongPress();
        if(mEditor != null)
            mEditor.mIgnoreActionUpEvent = true;
    }

    public void clearComposingText() {
        if(mText instanceof Spannable)
            BaseInputConnection.removeComposingSpans((Spannable)mText);
    }

    protected int computeHorizontalScrollRange() {
        int i;
        if(mLayout != null) {
            if(mSingleLine && (7 & mGravity) == 3)
                i = (int)mLayout.getLineWidth(0);
            else
                i = mLayout.getWidth();
        } else {
            i = computeHorizontalScrollRange();
        }
        return i;
    }

    public void computeScroll() {
        if(mScroller != null && mScroller.computeScrollOffset()) {
            super.mScrollX = mScroller.getCurrX();
            super.mScrollY = mScroller.getCurrY();
            invalidateParentCaches();
            postInvalidate();
        }
    }

    protected int computeVerticalScrollExtent() {
        return getHeight() - getCompoundPaddingTop() - getCompoundPaddingBottom();
    }

    protected int computeVerticalScrollRange() {
        int i;
        if(mLayout != null)
            i = mLayout.getHeight();
        else
            i = computeVerticalScrollRange();
        return i;
    }

    float convertToLocalHorizontalCoordinate(float f) {
        float f1 = Math.max(0.0F, f - (float)getTotalPaddingLeft());
        return Math.min(-1 + (getWidth() - getTotalPaddingRight()), f1) + (float)getScrollX();
    }

    public void debug(int i) {
        debug(i);
        String s = debugIndent(i);
        String s1 = (new StringBuilder()).append(s).append("frame={").append(super.mLeft).append(", ").append(super.mTop).append(", ").append(super.mRight).append(", ").append(super.mBottom).append("} scroll={").append(super.mScrollX).append(", ").append(super.mScrollY).append("} ").toString();
        String s2;
        if(mText != null) {
            s2 = (new StringBuilder()).append(s1).append("mText=\"").append(mText).append("\" ").toString();
            if(mLayout != null)
                s2 = (new StringBuilder()).append(s2).append("mLayout width=").append(mLayout.getWidth()).append(" height=").append(mLayout.getHeight()).toString();
        } else {
            s2 = (new StringBuilder()).append(s1).append("mText=NULL").toString();
        }
        Log.d("View", s2);
    }

    protected void deleteText_internal(int i, int j) {
        ((Editable)mText).delete(i, j);
    }

    public boolean didTouchFocusSelect() {
        boolean flag;
        if(mEditor != null && mEditor.mTouchFocusSelected)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void dispatchFinishTemporaryDetach() {
        mDispatchTemporaryDetach = true;
        dispatchFinishTemporaryDetach();
        mDispatchTemporaryDetach = false;
    }

    protected void drawableStateChanged() {
        drawableStateChanged();
        if(mTextColor != null && mTextColor.isStateful() || mHintTextColor != null && mHintTextColor.isStateful() || mLinkTextColor != null && mLinkTextColor.isStateful())
            updateTextColors();
        Drawables drawables = mDrawables;
        if(drawables != null) {
            int ai[] = getDrawableState();
            if(drawables.mDrawableTop != null && drawables.mDrawableTop.isStateful())
                drawables.mDrawableTop.setState(ai);
            if(drawables.mDrawableBottom != null && drawables.mDrawableBottom.isStateful())
                drawables.mDrawableBottom.setState(ai);
            if(drawables.mDrawableLeft != null && drawables.mDrawableLeft.isStateful())
                drawables.mDrawableLeft.setState(ai);
            if(drawables.mDrawableRight != null && drawables.mDrawableRight.isStateful())
                drawables.mDrawableRight.setState(ai);
            if(drawables.mDrawableStart != null && drawables.mDrawableStart.isStateful())
                drawables.mDrawableStart.setState(ai);
            if(drawables.mDrawableEnd != null && drawables.mDrawableEnd.isStateful())
                drawables.mDrawableEnd.setState(ai);
        }
    }

    public void endBatchEdit() {
        if(mEditor != null)
            mEditor.endBatchEdit();
    }

    public boolean extractText(ExtractedTextRequest extractedtextrequest, ExtractedText extractedtext) {
        createEditorIfNeeded();
        return mEditor.extractText(extractedtextrequest, extractedtext);
    }

    public void findViewsWithText(ArrayList arraylist, CharSequence charsequence, int i) {
        findViewsWithText(arraylist, charsequence, i);
        if(!arraylist.contains(this) && (i & 1) != 0 && !TextUtils.isEmpty(charsequence) && !TextUtils.isEmpty(mText)) {
            String s = charsequence.toString().toLowerCase();
            if(mText.toString().toLowerCase().contains(s))
                arraylist.add(this);
        }
    }

    public int getAccessibilityCursorPosition() {
        if(!TextUtils.isEmpty(getContentDescription())) goto _L2; else goto _L1
_L1:
        int i = getSelectionEnd();
        if(i < 0) goto _L2; else goto _L3
_L3:
        return i;
_L2:
        i = getAccessibilityCursorPosition();
        if(true) goto _L3; else goto _L4
_L4:
    }

    public final int getAutoLinkMask() {
        return mAutoLinkMask;
    }

    public int getBaseline() {
        int j;
        if(mLayout == null) {
            j = getBaseline();
        } else {
            int i = 0;
            if((0x70 & mGravity) != 48)
                i = getVerticalOffset(true);
            j = i + getExtendedPaddingTop() + mLayout.getLineBaseline(0);
        }
        return j;
    }

    protected int getBottomPaddingOffset() {
        return (int)Math.max(0.0F, mShadowDy + mShadowRadius);
    }

    public int getCompoundDrawablePadding() {
        Drawables drawables = mDrawables;
        int i;
        if(drawables != null)
            i = drawables.mDrawablePadding;
        else
            i = 0;
        return i;
    }

    public Drawable[] getCompoundDrawables() {
        Drawables drawables = mDrawables;
        Drawable adrawable[];
        if(drawables != null) {
            adrawable = new Drawable[4];
            adrawable[0] = drawables.mDrawableLeft;
            adrawable[1] = drawables.mDrawableTop;
            adrawable[2] = drawables.mDrawableRight;
            adrawable[3] = drawables.mDrawableBottom;
        } else {
            adrawable = new Drawable[4];
            adrawable[0] = null;
            adrawable[1] = null;
            adrawable[2] = null;
            adrawable[3] = null;
        }
        return adrawable;
    }

    public Drawable[] getCompoundDrawablesRelative() {
        Drawables drawables = mDrawables;
        Drawable adrawable[];
        if(drawables != null) {
            adrawable = new Drawable[4];
            adrawable[0] = drawables.mDrawableStart;
            adrawable[1] = drawables.mDrawableTop;
            adrawable[2] = drawables.mDrawableEnd;
            adrawable[3] = drawables.mDrawableBottom;
        } else {
            adrawable = new Drawable[4];
            adrawable[0] = null;
            adrawable[1] = null;
            adrawable[2] = null;
            adrawable[3] = null;
        }
        return adrawable;
    }

    public int getCompoundPaddingBottom() {
        Drawables drawables = mDrawables;
        int i;
        if(drawables == null || drawables.mDrawableBottom == null)
            i = super.mPaddingBottom;
        else
            i = super.mPaddingBottom + drawables.mDrawablePadding + drawables.mDrawableSizeBottom;
        return i;
    }

    public int getCompoundPaddingEnd() {
        resolveDrawables();
        getResolvedLayoutDirection();
        JVM INSTR tableswitch 1 1: default 28
    //                   1 35;
           goto _L1 _L2
_L1:
        int i = getCompoundPaddingRight();
_L4:
        return i;
_L2:
        i = getCompoundPaddingLeft();
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int getCompoundPaddingLeft() {
        Drawables drawables = mDrawables;
        int i;
        if(drawables == null || drawables.mDrawableLeft == null)
            i = super.mPaddingLeft;
        else
            i = super.mPaddingLeft + drawables.mDrawablePadding + drawables.mDrawableSizeLeft;
        return i;
    }

    public int getCompoundPaddingRight() {
        Drawables drawables = mDrawables;
        int i;
        if(drawables == null || drawables.mDrawableRight == null)
            i = super.mPaddingRight;
        else
            i = super.mPaddingRight + drawables.mDrawablePadding + drawables.mDrawableSizeRight;
        return i;
    }

    public int getCompoundPaddingStart() {
        resolveDrawables();
        getResolvedLayoutDirection();
        JVM INSTR tableswitch 1 1: default 28
    //                   1 35;
           goto _L1 _L2
_L1:
        int i = getCompoundPaddingLeft();
_L4:
        return i;
_L2:
        i = getCompoundPaddingRight();
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int getCompoundPaddingTop() {
        Drawables drawables = mDrawables;
        int i;
        if(drawables == null || drawables.mDrawableTop == null)
            i = super.mPaddingTop;
        else
            i = super.mPaddingTop + drawables.mDrawablePadding + drawables.mDrawableSizeTop;
        return i;
    }

    public final int getCurrentHintTextColor() {
        int i;
        if(mHintTextColor != null)
            i = mCurHintTextColor;
        else
            i = mCurTextColor;
        return i;
    }

    public final int getCurrentTextColor() {
        return mCurTextColor;
    }

    public android.view.ActionMode.Callback getCustomSelectionActionModeCallback() {
        android.view.ActionMode.Callback callback;
        if(mEditor == null)
            callback = null;
        else
            callback = mEditor.mCustomSelectionActionModeCallback;
        return callback;
    }

    protected boolean getDefaultEditable() {
        return false;
    }

    protected MovementMethod getDefaultMovementMethod() {
        return null;
    }

    public Editable getEditableText() {
        Editable editable;
        if(mText instanceof Editable)
            editable = (Editable)mText;
        else
            editable = null;
        return editable;
    }

    public android.text.TextUtils.TruncateAt getEllipsize() {
        return mEllipsize;
    }

    public CharSequence getError() {
        CharSequence charsequence;
        if(mEditor == null)
            charsequence = null;
        else
            charsequence = mEditor.mError;
        return charsequence;
    }

    public int getExtendedPaddingBottom() {
        if(mMaxMode == 1) goto _L2; else goto _L1
_L1:
        int j = getCompoundPaddingBottom();
_L4:
        return j;
_L2:
        if(mLayout.getLineCount() <= mMaximum) {
            j = getCompoundPaddingBottom();
        } else {
            int i = getCompoundPaddingTop();
            j = getCompoundPaddingBottom();
            int k = getHeight() - i - j;
            int l = mLayout.getLineTop(mMaximum);
            if(l < k) {
                int i1 = 0x70 & mGravity;
                if(i1 == 48)
                    j = (j + k) - l;
                else
                if(i1 != 80)
                    j += (k - l) / 2;
            }
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public int getExtendedPaddingTop() {
        if(mMaxMode == 1) goto _L2; else goto _L1
_L1:
        int i = getCompoundPaddingTop();
_L4:
        return i;
_L2:
        if(mLayout.getLineCount() <= mMaximum) {
            i = getCompoundPaddingTop();
        } else {
            i = getCompoundPaddingTop();
            int j = getCompoundPaddingBottom();
            int k = getHeight() - i - j;
            int l = mLayout.getLineTop(mMaximum);
            if(l < k) {
                int i1 = 0x70 & mGravity;
                if(i1 != 48)
                    if(i1 == 80)
                        i = (i + k) - l;
                    else
                        i += (k - l) / 2;
            }
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    protected int getFadeHeight(boolean flag) {
        int i;
        if(mLayout != null)
            i = mLayout.getHeight();
        else
            i = 0;
        return i;
    }

    protected int getFadeTop(boolean flag) {
        int j;
        if(mLayout == null) {
            j = 0;
        } else {
            int i = 0;
            if((0x70 & mGravity) != 48)
                i = getVerticalOffset(true);
            if(flag)
                i += getTopPaddingOffset();
            j = i + getExtendedPaddingTop();
        }
        return j;
    }

    public InputFilter[] getFilters() {
        return mFilters;
    }

    public void getFocusedRect(Rect rect) {
        if(mLayout != null) goto _L2; else goto _L1
_L1:
        getFocusedRect(rect);
_L4:
        return;
_L2:
        int i;
        int j;
        i = getSelectionEnd();
        if(i < 0) {
            getFocusedRect(rect);
            continue; /* Loop/switch isn't completed */
        }
        j = getSelectionStart();
        if(j >= 0 && j < i)
            break; /* Loop/switch isn't completed */
        int k = mLayout.getLineForOffset(i);
        rect.top = mLayout.getLineTop(k);
        rect.bottom = mLayout.getLineBottom(k);
        rect.left = -2 + (int)mLayout.getPrimaryHorizontal(i);
        rect.right = 4 + rect.left;
_L5:
        int l = getCompoundPaddingLeft();
        int i1 = getExtendedPaddingTop();
        if((0x70 & mGravity) != 48)
            i1 += getVerticalOffset(false);
        rect.offset(l, i1);
        rect.bottom = getExtendedPaddingBottom() + rect.bottom;
        if(true) goto _L4; else goto _L3
_L3:
label0:
        {
            int j1 = mLayout.getLineForOffset(j);
            int k1 = mLayout.getLineForOffset(i);
            rect.top = mLayout.getLineTop(j1);
            rect.bottom = mLayout.getLineBottom(k1);
            if(j1 != k1)
                break label0;
            rect.left = (int)mLayout.getPrimaryHorizontal(j);
            rect.right = (int)mLayout.getPrimaryHorizontal(i);
        }
          goto _L5
        if(mHighlightPathBogus) {
            if(mHighlightPath == null)
                mHighlightPath = new Path();
            mHighlightPath.reset();
            mLayout.getSelectionPath(j, i, mHighlightPath);
            mHighlightPathBogus = false;
        }
        RectF rectf = TEMP_RECTF;
        rectf;
        JVM INSTR monitorenter ;
        mHighlightPath.computeBounds(TEMP_RECTF, true);
        rect.left = -1 + (int)TEMP_RECTF.left;
        rect.right = 1 + (int)TEMP_RECTF.right;
          goto _L5
    }

    public boolean getFreezesText() {
        return mFreezesText;
    }

    public int getGravity() {
        return mGravity;
    }

    public int getHighlightColor() {
        return mHighlightColor;
    }

    public CharSequence getHint() {
        return mHint;
    }

    final Layout getHintLayout() {
        return mHintLayout;
    }

    public final ColorStateList getHintTextColors() {
        return mHintTextColor;
    }

    public boolean getHorizontallyScrolling() {
        return mHorizontallyScrolling;
    }

    public int getImeActionId() {
        int i;
        if(mEditor != null && mEditor.mInputContentType != null)
            i = mEditor.mInputContentType.imeActionId;
        else
            i = 0;
        return i;
    }

    public CharSequence getImeActionLabel() {
        CharSequence charsequence;
        if(mEditor != null && mEditor.mInputContentType != null)
            charsequence = mEditor.mInputContentType.imeActionLabel;
        else
            charsequence = null;
        return charsequence;
    }

    public int getImeOptions() {
        int i;
        if(mEditor != null && mEditor.mInputContentType != null)
            i = mEditor.mInputContentType.imeOptions;
        else
            i = 0;
        return i;
    }

    public boolean getIncludeFontPadding() {
        return mIncludePad;
    }

    public Bundle getInputExtras(boolean flag) {
        Bundle bundle = null;
        if(mEditor != null || flag) goto _L2; else goto _L1
_L1:
        return bundle;
_L2:
        createEditorIfNeeded();
        if(mEditor.mInputContentType == null) {
            if(!flag)
                continue; /* Loop/switch isn't completed */
            mEditor.createInputContentTypeIfNeeded();
        }
        if(mEditor.mInputContentType.extras == null) {
            if(!flag)
                continue; /* Loop/switch isn't completed */
            mEditor.mInputContentType.extras = new Bundle();
        }
        bundle = mEditor.mInputContentType.extras;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public int getInputType() {
        int i;
        if(mEditor == null)
            i = 0;
        else
            i = mEditor.mInputType;
        return i;
    }

    public CharSequence getIterableTextForAccessibility() {
        CharSequence charsequence;
        if(getContentDescription() == null) {
            if(!(mText instanceof Spannable))
                setText(mText, BufferType.SPANNABLE);
            charsequence = mText;
        } else {
            charsequence = getIterableTextForAccessibility();
        }
        return charsequence;
    }

    public android.view.AccessibilityIterators.TextSegmentIterator getIteratorForGranularity(int i) {
        i;
        JVM INSTR lookupswitch 2: default 28
    //                   4: 36
    //                   16: 74;
           goto _L1 _L2 _L3
_L1:
        Object obj = getIteratorForGranularity(i);
_L5:
        Spannable spannable;
        return ((android.view.AccessibilityIterators.TextSegmentIterator) (obj));
_L2:
        if(TextUtils.isEmpty(spannable = (Spannable)getIterableTextForAccessibility()) || getLayout() == null) goto _L1; else goto _L4
_L4:
        obj = AccessibilityIterators.LineTextSegmentIterator.getInstance();
        ((AccessibilityIterators.LineTextSegmentIterator) (obj)).initialize(spannable, getLayout());
          goto _L5
_L3:
        if(TextUtils.isEmpty((Spannable)getIterableTextForAccessibility()) || getLayout() == null) goto _L1; else goto _L6
_L6:
        obj = AccessibilityIterators.PageTextSegmentIterator.getInstance();
        ((AccessibilityIterators.PageTextSegmentIterator) (obj)).initialize(this);
          goto _L5
    }

    public final KeyListener getKeyListener() {
        KeyListener keylistener;
        if(mEditor == null)
            keylistener = null;
        else
            keylistener = mEditor.mKeyListener;
        return keylistener;
    }

    public final Layout getLayout() {
        return mLayout;
    }

    protected float getLeftFadingEdgeStrength() {
        float f = 0.0F;
        if(mEllipsize != android.text.TextUtils.TruncateAt.MARQUEE || mMarqueeFadeMode == 1) goto _L2; else goto _L1
_L1:
        if(mMarquee == null || mMarquee.isStopped()) goto _L4; else goto _L3
_L3:
        Marquee marquee = mMarquee;
        if(marquee.shouldDrawLeftFade())
            f = marquee.mScroll / (float)getHorizontalFadingEdgeLength();
_L9:
        return f;
_L4:
        if(getLineCount() != 1) goto _L2; else goto _L5
_L5:
        int i = getResolvedLayoutDirection();
        7 & Gravity.getAbsoluteGravity(mGravity, i);
        JVM INSTR tableswitch 1 5: default 120
    //                   1 60
    //                   2 120
    //                   3 60
    //                   4 120
    //                   5 128;
           goto _L2 _L6 _L2 _L6 _L2 _L7
_L6:
        continue; /* Loop/switch isn't completed */
_L2:
        f = getLeftFadingEdgeStrength();
        continue; /* Loop/switch isn't completed */
_L7:
        f = (mLayout.getLineRight(0) - (float)(super.mRight - super.mLeft) - (float)getCompoundPaddingLeft() - (float)getCompoundPaddingRight() - mLayout.getLineLeft(0)) / (float)getHorizontalFadingEdgeLength();
        if(true) goto _L9; else goto _L8
_L8:
    }

    protected int getLeftPaddingOffset() {
        return (getCompoundPaddingLeft() - super.mPaddingLeft) + (int)Math.min(0.0F, mShadowDx - mShadowRadius);
    }

    int getLineAtCoordinate(float f) {
        float f1 = Math.max(0.0F, f - (float)getTotalPaddingTop());
        float f2 = Math.min(-1 + (getHeight() - getTotalPaddingBottom()), f1) + (float)getScrollY();
        return getLayout().getLineForVertical((int)f2);
    }

    public int getLineBounds(int i, Rect rect) {
        int j = 0;
        if(mLayout == null) {
            if(rect != null)
                rect.set(0, 0, 0, 0);
        } else {
            int k = mLayout.getLineBounds(i, rect);
            int l = getExtendedPaddingTop();
            if((0x70 & mGravity) != 48)
                l += getVerticalOffset(true);
            if(rect != null)
                rect.offset(getCompoundPaddingLeft(), l);
            j = k + l;
        }
        return j;
    }

    public int getLineCount() {
        int i;
        if(mLayout != null)
            i = mLayout.getLineCount();
        else
            i = 0;
        return i;
    }

    public int getLineHeight() {
        return FastMath.round((float)mTextPaint.getFontMetricsInt(null) * mSpacingMult + mSpacingAdd);
    }

    public float getLineSpacingExtra() {
        return mSpacingAdd;
    }

    public float getLineSpacingMultiplier() {
        return mSpacingMult;
    }

    public final ColorStateList getLinkTextColors() {
        return mLinkTextColor;
    }

    public final boolean getLinksClickable() {
        return mLinksClickable;
    }

    public int getMarqueeRepeatLimit() {
        return mMarqueeRepeatLimit;
    }

    public int getMaxEms() {
        int i;
        if(mMaxWidthMode == 1)
            i = mMaxWidth;
        else
            i = -1;
        return i;
    }

    public int getMaxHeight() {
        int i;
        if(mMaxMode == 2)
            i = mMaximum;
        else
            i = -1;
        return i;
    }

    public int getMaxLines() {
        int i;
        if(mMaxMode == 1)
            i = mMaximum;
        else
            i = -1;
        return i;
    }

    public int getMaxWidth() {
        int i;
        if(mMaxWidthMode == 2)
            i = mMaxWidth;
        else
            i = -1;
        return i;
    }

    public int getMinEms() {
        int i;
        if(mMinWidthMode == 1)
            i = mMinWidth;
        else
            i = -1;
        return i;
    }

    public int getMinHeight() {
        int i;
        if(mMinMode == 2)
            i = mMinimum;
        else
            i = -1;
        return i;
    }

    public int getMinLines() {
        int i;
        if(mMinMode == 1)
            i = mMinimum;
        else
            i = -1;
        return i;
    }

    public int getMinWidth() {
        int i;
        if(mMinWidthMode == 2)
            i = mMinWidth;
        else
            i = -1;
        return i;
    }

    public final MovementMethod getMovementMethod() {
        return mMovement;
    }

    public int getOffsetForPosition(float f, float f1) {
        int i;
        if(getLayout() == null)
            i = -1;
        else
            i = getOffsetAtCoordinate(getLineAtCoordinate(f1), f);
        return i;
    }

    public TextPaint getPaint() {
        return mTextPaint;
    }

    public int getPaintFlags() {
        return mTextPaint.getFlags();
    }

    public String getPrivateImeOptions() {
        String s;
        if(mEditor != null && mEditor.mInputContentType != null)
            s = mEditor.mInputContentType.privateImeOptions;
        else
            s = null;
        return s;
    }

    public int getResolvedLayoutDirection(Drawable drawable) {
        if(drawable != null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L4:
        return i;
_L2:
        if(mDrawables != null) {
            Drawables drawables = mDrawables;
            if(drawable == drawables.mDrawableLeft || drawable == drawables.mDrawableRight || drawable == drawables.mDrawableTop || drawable == drawables.mDrawableBottom || drawable == drawables.mDrawableStart || drawable == drawables.mDrawableEnd) {
                i = getResolvedLayoutDirection();
                continue; /* Loop/switch isn't completed */
            }
        }
        i = getResolvedLayoutDirection(drawable);
        if(true) goto _L4; else goto _L3
_L3:
    }

    protected float getRightFadingEdgeStrength() {
        if(mEllipsize != android.text.TextUtils.TruncateAt.MARQUEE || mMarqueeFadeMode == 1) goto _L2; else goto _L1
_L1:
        if(mMarquee == null || mMarquee.isStopped()) goto _L4; else goto _L3
_L3:
        float f;
        Marquee marquee = mMarquee;
        f = (marquee.mMaxFadeScroll - marquee.mScroll) / (float)getHorizontalFadingEdgeLength();
_L10:
        return f;
_L4:
        if(getLineCount() != 1) goto _L2; else goto _L5
_L5:
        int i = getResolvedLayoutDirection();
        7 & Gravity.getAbsoluteGravity(mGravity, i);
        JVM INSTR tableswitch 1 7: default 128
    //                   1 182
    //                   2 128
    //                   3 136
    //                   4 128
    //                   5 177
    //                   6 128
    //                   7 182;
           goto _L2 _L6 _L2 _L7 _L2 _L8 _L2 _L6
_L2:
        f = getRightFadingEdgeStrength();
        continue; /* Loop/switch isn't completed */
_L7:
        int j = super.mRight - super.mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight();
        f = (mLayout.getLineWidth(0) - (float)j) / (float)getHorizontalFadingEdgeLength();
        continue; /* Loop/switch isn't completed */
_L8:
        f = 0.0F;
        continue; /* Loop/switch isn't completed */
_L6:
        f = (mLayout.getLineWidth(0) - (float)(super.mRight - super.mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight())) / (float)getHorizontalFadingEdgeLength();
        if(true) goto _L10; else goto _L9
_L9:
    }

    protected int getRightPaddingOffset() {
        return -(getCompoundPaddingRight() - super.mPaddingRight) + (int)Math.max(0.0F, mShadowDx + mShadowRadius);
    }

    public int getSelectionEnd() {
        return Selection.getSelectionEnd(getText());
    }

    public int getSelectionStart() {
        return Selection.getSelectionStart(getText());
    }

    public int getShadowColor() {
        return ((Paint) (mTextPaint)).shadowColor;
    }

    public float getShadowDx() {
        return mShadowDx;
    }

    public float getShadowDy() {
        return mShadowDy;
    }

    public float getShadowRadius() {
        return mShadowRadius;
    }

    public final boolean getShowSoftInputOnFocus() {
        boolean flag;
        if(mEditor == null || mEditor.mShowSoftInputOnFocus)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public CharSequence getText() {
        return mText;
    }

    public final ColorStateList getTextColors() {
        return mTextColor;
    }

    public CharSequence getTextForAccessibility() {
        CharSequence charsequence = getText();
        if(TextUtils.isEmpty(charsequence))
            charsequence = getHint();
        return charsequence;
    }

    public float getTextScaleX() {
        return mTextPaint.getTextScaleX();
    }

    public Locale getTextServicesLocale() {
        Locale locale = Locale.getDefault();
        SpellCheckerSubtype spellcheckersubtype = ((TextServicesManager)super.mContext.getSystemService("textservices")).getCurrentSpellCheckerSubtype(true);
        if(spellcheckersubtype != null)
            locale = SpellCheckerSubtype.constructLocaleFromString(spellcheckersubtype.getLocale());
        return locale;
    }

    public float getTextSize() {
        return mTextPaint.getTextSize();
    }

    protected int getTopPaddingOffset() {
        return (int)Math.min(0.0F, mShadowDy - mShadowRadius);
    }

    public int getTotalPaddingBottom() {
        return getExtendedPaddingBottom() + getBottomVerticalOffset(true);
    }

    public int getTotalPaddingEnd() {
        return getCompoundPaddingEnd();
    }

    public int getTotalPaddingLeft() {
        return getCompoundPaddingLeft();
    }

    public int getTotalPaddingRight() {
        return getCompoundPaddingRight();
    }

    public int getTotalPaddingStart() {
        return getCompoundPaddingStart();
    }

    public int getTotalPaddingTop() {
        return getExtendedPaddingTop() + getVerticalOffset(true);
    }

    public final TransformationMethod getTransformationMethod() {
        return mTransformation;
    }

    CharSequence getTransformedText(int i, int j) {
        return removeSuggestionSpans(mTransformed.subSequence(i, j));
    }

    public Typeface getTypeface() {
        return mTextPaint.getTypeface();
    }

    public URLSpan[] getUrls() {
        URLSpan aurlspan[];
        if(mText instanceof Spanned)
            aurlspan = (URLSpan[])((Spanned)mText).getSpans(0, mText.length(), android/text/style/URLSpan);
        else
            aurlspan = new URLSpan[0];
        return aurlspan;
    }

    int getVerticalOffset(boolean flag) {
        int i = 0;
        int j = 0x70 & mGravity;
        Layout layout = mLayout;
        if(!flag && mText.length() == 0 && mHintLayout != null)
            layout = mHintLayout;
        if(j != 48) {
            int k;
            int l;
            if(layout == mHintLayout)
                k = getMeasuredHeight() - getCompoundPaddingTop() - getCompoundPaddingBottom();
            else
                k = getMeasuredHeight() - getExtendedPaddingTop() - getExtendedPaddingBottom();
            l = layout.getHeight();
            if(l < k)
                if(j == 80)
                    i = k - l;
                else
                    i = k - l >> 1;
        }
        return i;
    }

    public WordIterator getWordIterator() {
        WordIterator worditerator;
        if(mEditor != null)
            worditerator = mEditor.getWordIterator();
        else
            worditerator = null;
        return worditerator;
    }

    void handleTextChanged(CharSequence charsequence, int i, int j, int k) {
        Editor.InputMethodState inputmethodstate;
        if(mEditor == null)
            inputmethodstate = null;
        else
            inputmethodstate = mEditor.mInputMethodState;
        if(inputmethodstate == null || inputmethodstate.mBatchEditNesting == 0)
            updateAfterEdit();
        if(inputmethodstate != null) {
            inputmethodstate.mContentChanged = true;
            if(inputmethodstate.mChangedStart < 0) {
                inputmethodstate.mChangedStart = i;
                inputmethodstate.mChangedEnd = i + j;
            } else {
                inputmethodstate.mChangedStart = Math.min(inputmethodstate.mChangedStart, i);
                inputmethodstate.mChangedEnd = Math.max(inputmethodstate.mChangedEnd, (i + j) - inputmethodstate.mChangedDelta);
            }
            inputmethodstate.mChangedDelta = inputmethodstate.mChangedDelta + (k - j);
        }
        sendOnTextChanged(charsequence, i, j, k);
        onTextChanged(charsequence, i, j, k);
    }

    public boolean hasOverlappingRendering() {
        boolean flag;
        if(getBackground() != null || (mText instanceof Spannable) || hasSelection())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean hasSelection() {
        int i = getSelectionStart();
        int j = getSelectionEnd();
        boolean flag;
        if(i >= 0 && i != j)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void hideErrorIfUnchanged() {
        if(mEditor != null && mEditor.mError != null && !mEditor.mErrorWasChanged)
            setError(null, null);
    }

    void invalidateCursor() {
        int i = getSelectionEnd();
        invalidateCursor(i, i, i);
    }

    void invalidateCursorPath() {
        if(!mHighlightPathBogus) goto _L2; else goto _L1
_L1:
        invalidateCursor();
_L4:
        return;
_L2:
        int i;
        int j;
        i = getCompoundPaddingLeft();
        j = getExtendedPaddingTop() + getVerticalOffset(true);
        if(mEditor.mCursorCount != 0)
            break; /* Loop/switch isn't completed */
        RectF rectf = TEMP_RECTF;
        rectf;
        JVM INSTR monitorenter ;
        float f = FloatMath.ceil(mTextPaint.getStrokeWidth());
        if(f < 1.0F)
            f = 1.0F;
        float f1 = f / 2.0F;
        mHighlightPath.computeBounds(TEMP_RECTF, false);
        invalidate((int)FloatMath.floor(((float)i + TEMP_RECTF.left) - f1), (int)FloatMath.floor(((float)j + TEMP_RECTF.top) - f1), (int)FloatMath.ceil(f1 + ((float)i + TEMP_RECTF.right)), (int)FloatMath.ceil(f1 + ((float)j + TEMP_RECTF.bottom)));
        if(true) goto _L4; else goto _L3
_L3:
        int k = 0;
        while(k < mEditor.mCursorCount)  {
            Rect rect = mEditor.mCursorDrawable[k].getBounds();
            invalidate(i + rect.left, j + rect.top, i + rect.right, j + rect.bottom);
            k++;
        }
        if(true) goto _L4; else goto _L5
_L5:
    }

    public void invalidateDrawable(Drawable drawable) {
        if(!verifyDrawable(drawable)) goto _L2; else goto _L1
_L1:
        Rect rect;
        int i;
        int j;
        Drawables drawables;
        rect = drawable.getBounds();
        i = super.mScrollX;
        j = super.mScrollY;
        drawables = mDrawables;
        if(drawables == null) goto _L4; else goto _L3
_L3:
        if(drawable != drawables.mDrawableLeft) goto _L6; else goto _L5
_L5:
        int j2 = getCompoundPaddingTop();
        int k2 = getCompoundPaddingBottom();
        int l2 = super.mBottom - super.mTop - k2 - j2;
        i += super.mPaddingLeft;
        j += j2 + (l2 - drawables.mDrawableHeightLeft) / 2;
_L4:
        invalidate(i + rect.left, j + rect.top, i + rect.right, j + rect.bottom);
_L2:
        return;
_L6:
        if(drawable == drawables.mDrawableRight) {
            int k1 = getCompoundPaddingTop();
            int l1 = getCompoundPaddingBottom();
            int i2 = super.mBottom - super.mTop - l1 - k1;
            i += super.mRight - super.mLeft - super.mPaddingRight - drawables.mDrawableSizeRight;
            j += k1 + (i2 - drawables.mDrawableHeightRight) / 2;
        } else
        if(drawable == drawables.mDrawableTop) {
            int i1 = getCompoundPaddingLeft();
            int j1 = getCompoundPaddingRight();
            i += i1 + (super.mRight - super.mLeft - j1 - i1 - drawables.mDrawableWidthTop) / 2;
            j += super.mPaddingTop;
        } else
        if(drawable == drawables.mDrawableBottom) {
            int k = getCompoundPaddingLeft();
            int l = getCompoundPaddingRight();
            i += k + (super.mRight - super.mLeft - l - k - drawables.mDrawableWidthBottom) / 2;
            j += super.mBottom - super.mTop - super.mPaddingBottom - drawables.mDrawableSizeBottom;
        }
        if(true) goto _L4; else goto _L7
_L7:
    }

    void invalidateRegion(int i, int j, boolean flag) {
        if(mLayout == null) {
            invalidate();
        } else {
            int k = mLayout.getLineForOffset(i);
            int l = mLayout.getLineTop(k);
            if(k > 0)
                l -= mLayout.getLineDescent(k - 1);
            int i1;
            int j1;
            if(i == j)
                i1 = k;
            else
                i1 = mLayout.getLineForOffset(j);
            j1 = mLayout.getLineBottom(i1);
            if(flag && mEditor != null) {
                for(int i3 = 0; i3 < mEditor.mCursorCount; i3++) {
                    Rect rect = mEditor.mCursorDrawable[i3].getBounds();
                    l = Math.min(l, rect.top);
                    j1 = Math.max(j1, rect.bottom);
                }

            }
            int k1 = getCompoundPaddingLeft();
            int l1 = getExtendedPaddingTop() + getVerticalOffset(true);
            int i2;
            int j2;
            if(k == i1 && !flag) {
                int k2 = (int)mLayout.getPrimaryHorizontal(i);
                int l2 = (int)(1.0D + (double)mLayout.getPrimaryHorizontal(j));
                i2 = k2 + k1;
                j2 = l2 + k1;
            } else {
                i2 = k1;
                j2 = getWidth() - getCompoundPaddingRight();
            }
            invalidate(i2 + super.mScrollX, l1 + l, j2 + super.mScrollX, l1 + j1);
        }
    }

    public boolean isCursorVisible() {
        boolean flag;
        if(mEditor == null)
            flag = true;
        else
            flag = mEditor.mCursorVisible;
        return flag;
    }

    boolean isInBatchEditMode() {
        boolean flag = false;
        if(mEditor != null) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        Editor.InputMethodState inputmethodstate = mEditor.mInputMethodState;
        if(inputmethodstate != null) {
            if(inputmethodstate.mBatchEditNesting > 0)
                flag = true;
        } else {
            flag = mEditor.mInBatchEditControllers;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean isInputMethodTarget() {
        InputMethodManager inputmethodmanager = InputMethodManager.peekInstance();
        boolean flag;
        if(inputmethodmanager != null && inputmethodmanager.isActive(this))
            flag = true;
        else
            flag = false;
        return flag;
    }

    protected boolean isPaddingOffsetRequired() {
        boolean flag;
        if(mShadowRadius != 0.0F || mDrawables != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    boolean isSingleLine() {
        return mSingleLine;
    }

    public boolean isSuggestionsEnabled() {
        boolean flag;
        flag = false;
        break MISSING_BLOCK_LABEL_2;
        while(true)  {
            do
                return flag;
            while(mEditor == null || (0xf & mEditor.mInputType) != 1 || (0x80000 & mEditor.mInputType) > 0);
            int i = 0xff0 & mEditor.mInputType;
            if(i == 0 || i == 48 || i == 80 || i == 64 || i == 160)
                flag = true;
        }
    }

    boolean isTextEditable() {
        boolean flag;
        if((mText instanceof Editable) && onCheckIsTextEditor() && isEnabled())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isTextSelectable() {
        boolean flag;
        if(mEditor == null)
            flag = false;
        else
            flag = mEditor.mTextIsSelectable;
        return flag;
    }

    public void jumpDrawablesToCurrentState() {
        jumpDrawablesToCurrentState();
        if(mDrawables != null) {
            if(mDrawables.mDrawableLeft != null)
                mDrawables.mDrawableLeft.jumpToCurrentState();
            if(mDrawables.mDrawableTop != null)
                mDrawables.mDrawableTop.jumpToCurrentState();
            if(mDrawables.mDrawableRight != null)
                mDrawables.mDrawableRight.jumpToCurrentState();
            if(mDrawables.mDrawableBottom != null)
                mDrawables.mDrawableBottom.jumpToCurrentState();
            if(mDrawables.mDrawableStart != null)
                mDrawables.mDrawableStart.jumpToCurrentState();
            if(mDrawables.mDrawableEnd != null)
                mDrawables.mDrawableEnd.jumpToCurrentState();
        }
    }

    public int length() {
        return mText.length();
    }

    protected void makeNewLayout(int i, int j, android.text.BoringLayout.Metrics metrics, android.text.BoringLayout.Metrics metrics1, int k, boolean flag) {
        stopMarquee();
        mOldMaximum = mMaximum;
        mOldMaxMode = mMaxMode;
        mHighlightPathBogus = true;
        if(i < 0)
            i = 0;
        if(j < 0)
            j = 0;
        android.text.Layout.Alignment alignment = getLayoutAlignment();
        boolean flag1;
        boolean flag2;
        android.text.TextUtils.TruncateAt truncateat;
        boolean flag3;
        boolean flag4;
        if(mEllipsize != null && getKeyListener() == null)
            flag1 = true;
        else
            flag1 = false;
        if(mEllipsize == android.text.TextUtils.TruncateAt.MARQUEE && mMarqueeFadeMode != 0)
            flag2 = true;
        else
            flag2 = false;
        truncateat = mEllipsize;
        if(mEllipsize == android.text.TextUtils.TruncateAt.MARQUEE && mMarqueeFadeMode == 1)
            truncateat = android.text.TextUtils.TruncateAt.END_SMALL;
        if(mTextDir == null)
            resolveTextDirection();
        if(truncateat == mEllipsize)
            flag3 = true;
        else
            flag3 = false;
        mLayout = makeSingleLayout(i, metrics, k, alignment, flag1, truncateat, flag3);
        if(flag2) {
            int l;
            android.text.BoringLayout.Metrics metrics2;
            BoringLayout boringlayout1;
            CharSequence charsequence7;
            TextPaint textpaint7;
            float f14;
            float f15;
            boolean flag12;
            android.text.TextUtils.TruncateAt truncateat5;
            boolean flag13;
            if(truncateat == android.text.TextUtils.TruncateAt.MARQUEE)
                truncateat5 = android.text.TextUtils.TruncateAt.END;
            else
                truncateat5 = android.text.TextUtils.TruncateAt.MARQUEE;
            if(truncateat != mEllipsize)
                flag13 = true;
            else
                flag13 = false;
            mSavedMarqueeModeLayout = makeSingleLayout(i, metrics, k, alignment, flag1, truncateat5, flag13);
        }
        if(mEllipsize != null)
            flag4 = true;
        else
            flag4 = false;
        mHintLayout = null;
        if(mHint != null) {
            if(flag4)
                j = i;
            metrics2 = UNKNOWN_BORING;
            if(metrics1 == metrics2) {
                metrics1 = BoringLayout.isBoring(mHint, mTextPaint, mTextDir, mHintBoring);
                if(metrics1 != null)
                    mHintBoring = metrics1;
            }
            if(metrics1 != null) {
                if(metrics1.width <= j && (!flag4 || metrics1.width <= k)) {
                    if(mSavedHintLayout != null) {
                        boringlayout1 = mSavedHintLayout;
                        charsequence7 = mHint;
                        textpaint7 = mTextPaint;
                        f14 = mSpacingMult;
                        f15 = mSpacingAdd;
                        flag12 = mIncludePad;
                        mHintLayout = boringlayout1.replaceOrMake(charsequence7, textpaint7, j, alignment, f14, f15, metrics1, flag12);
                    } else {
                        CharSequence charsequence6 = mHint;
                        TextPaint textpaint6 = mTextPaint;
                        float f12 = mSpacingMult;
                        float f13 = mSpacingAdd;
                        boolean flag11 = mIncludePad;
                        mHintLayout = BoringLayout.make(charsequence6, textpaint6, j, alignment, f12, f13, metrics1, flag11);
                    }
                    mSavedHintLayout = (BoringLayout)mHintLayout;
                } else
                if(flag4 && metrics1.width <= j) {
                    if(mSavedHintLayout != null) {
                        BoringLayout boringlayout = mSavedHintLayout;
                        CharSequence charsequence5 = mHint;
                        TextPaint textpaint5 = mTextPaint;
                        float f10 = mSpacingMult;
                        float f11 = mSpacingAdd;
                        boolean flag10 = mIncludePad;
                        android.text.TextUtils.TruncateAt truncateat4 = mEllipsize;
                        mHintLayout = boringlayout.replaceOrMake(charsequence5, textpaint5, j, alignment, f10, f11, metrics1, flag10, truncateat4, k);
                    } else {
                        CharSequence charsequence4 = mHint;
                        TextPaint textpaint4 = mTextPaint;
                        float f8 = mSpacingMult;
                        float f9 = mSpacingAdd;
                        boolean flag9 = mIncludePad;
                        android.text.TextUtils.TruncateAt truncateat3 = mEllipsize;
                        mHintLayout = BoringLayout.make(charsequence4, textpaint4, j, alignment, f8, f9, metrics1, flag9, truncateat3, k);
                    }
                } else
                if(flag4) {
                    CharSequence charsequence3 = mHint;
                    int k1 = mHint.length();
                    TextPaint textpaint3 = mTextPaint;
                    TextDirectionHeuristic textdirectionheuristic3 = mTextDir;
                    float f6 = mSpacingMult;
                    float f7 = mSpacingAdd;
                    boolean flag8 = mIncludePad;
                    android.text.TextUtils.TruncateAt truncateat2 = mEllipsize;
                    int l1;
                    if(mMaxMode == 1)
                        l1 = mMaximum;
                    else
                        l1 = 0x7fffffff;
                    mHintLayout = new StaticLayout(charsequence3, 0, k1, textpaint3, j, alignment, textdirectionheuristic3, f6, f7, flag8, truncateat2, k, l1);
                } else {
                    CharSequence charsequence2 = mHint;
                    TextPaint textpaint2 = mTextPaint;
                    TextDirectionHeuristic textdirectionheuristic2 = mTextDir;
                    float f4 = mSpacingMult;
                    float f5 = mSpacingAdd;
                    boolean flag7 = mIncludePad;
                    mHintLayout = new StaticLayout(charsequence2, textpaint2, j, alignment, textdirectionheuristic2, f4, f5, flag7);
                }
            } else
            if(flag4) {
                CharSequence charsequence1 = mHint;
                int i1 = mHint.length();
                TextPaint textpaint1 = mTextPaint;
                TextDirectionHeuristic textdirectionheuristic1 = mTextDir;
                float f2 = mSpacingMult;
                float f3 = mSpacingAdd;
                boolean flag6 = mIncludePad;
                android.text.TextUtils.TruncateAt truncateat1 = mEllipsize;
                int j1;
                if(mMaxMode == 1)
                    j1 = mMaximum;
                else
                    j1 = 0x7fffffff;
                mHintLayout = new StaticLayout(charsequence1, 0, i1, textpaint1, j, alignment, textdirectionheuristic1, f2, f3, flag6, truncateat1, k, j1);
            } else {
                CharSequence charsequence = mHint;
                TextPaint textpaint = mTextPaint;
                TextDirectionHeuristic textdirectionheuristic = mTextDir;
                float f = mSpacingMult;
                float f1 = mSpacingAdd;
                boolean flag5 = mIncludePad;
                mHintLayout = new StaticLayout(charsequence, textpaint, j, alignment, textdirectionheuristic, f, f1, flag5);
            }
        }
        if(flag)
            registerForPreDraw();
        if(mEllipsize == android.text.TextUtils.TruncateAt.MARQUEE && !compressText(k)) {
            l = super.mLayoutParams.height;
            if(l != -2 && l != -1)
                startMarquee();
            else
                mRestartMarquee = true;
        }
        if(mEditor != null)
            mEditor.prepareCursorControllers();
    }

    public boolean moveCursorToVisibleOffset() {
        if(mText instanceof Spannable) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L8:
        return flag;
_L2:
        int i = getSelectionStart();
        if(i == getSelectionEnd()) goto _L4; else goto _L3
_L3:
        flag = false;
          goto _L5
_L4:
        int i3;
        int j3;
        int j = mLayout.getLineForOffset(i);
        int k = mLayout.getLineTop(j);
        int l = mLayout.getLineTop(j + 1);
        int i1 = super.mBottom - super.mTop - getExtendedPaddingTop() - getExtendedPaddingBottom();
        int j1 = (l - k) / 2;
        if(j1 > i1 / 4)
            j1 = i1 / 4;
        int k1 = super.mScrollY;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        if(k < k1 + j1)
            j = mLayout.getLineForVertical(k1 + j1 + (l - k));
        else
        if(l > (i1 + k1) - j1)
            j = mLayout.getLineForVertical((i1 + k1) - j1 - (l - k));
        l1 = super.mRight - super.mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight();
        i2 = super.mScrollX;
        j2 = mLayout.getOffsetForHorizontal(j, i2);
        k2 = mLayout.getOffsetForHorizontal(j, l1 + i2);
        if(j2 < k2)
            l2 = j2;
        else
            l2 = k2;
        if(j2 > k2)
            i3 = j2;
        else
            i3 = k2;
        j3 = i;
        if(j3 >= l2) goto _L7; else goto _L6
_L6:
        j3 = l2;
_L9:
        if(j3 != i) {
            Selection.setSelection((Spannable)mText, j3);
            flag = true;
        } else {
            flag = false;
        }
_L5:
        if(true) goto _L8; else goto _L7
_L7:
        if(j3 > i3)
            j3 = i3;
          goto _L9
    }

    protected void onAttachedToWindow() {
        onAttachedToWindow();
        mTemporaryDetach = false;
        resolveDrawables();
        if(mEditor != null)
            mEditor.onAttachedToWindow();
    }

    public void onBeginBatchEdit() {
    }

    public boolean onCheckIsTextEditor() {
        boolean flag;
        if(mEditor != null && mEditor.mInputType != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void onCommitCompletion(CompletionInfo completioninfo) {
    }

    public void onCommitCorrection(CorrectionInfo correctioninfo) {
        if(mEditor != null)
            mEditor.onCommitCorrection(correctioninfo);
    }

    protected int[] onCreateDrawableState(int i) {
        int ai[];
        int ai1[];
        int k;
        int j;
        if(mSingleLine) {
            ai = onCreateDrawableState(i);
        } else {
            ai = onCreateDrawableState(i + 1);
            mergeDrawableStates(ai, MULTILINE_STATE_SET);
        }
        if(!isTextSelectable())
            break MISSING_BLOCK_LABEL_110;
        j = ai.length;
        k = 0;
_L3:
        if(k >= j)
            break MISSING_BLOCK_LABEL_110;
        if(ai[k] != 0x10100a7) goto _L2; else goto _L1
_L1:
        ai1 = new int[j - 1];
        System.arraycopy(ai, 0, ai1, 0, k);
        System.arraycopy(ai, k + 1, ai1, k, -1 + (j - k));
_L4:
        return ai1;
_L2:
        k++;
          goto _L3
        ai1 = ai;
          goto _L4
    }

    public InputConnection onCreateInputConnection(EditorInfo editorinfo) {
        if(!onCheckIsTextEditor() || !isEnabled()) goto _L2; else goto _L1
_L1:
        EditableInputConnection editableinputconnection;
        mEditor.createInputMethodStateIfNeeded();
        editorinfo.inputType = getInputType();
        if(mEditor.mInputContentType != null) {
            editorinfo.imeOptions = mEditor.mInputContentType.imeOptions;
            editorinfo.privateImeOptions = mEditor.mInputContentType.privateImeOptions;
            editorinfo.actionLabel = mEditor.mInputContentType.imeActionLabel;
            editorinfo.actionId = mEditor.mInputContentType.imeActionId;
            editorinfo.extras = mEditor.mInputContentType.extras;
        } else {
            editorinfo.imeOptions = 0;
        }
        if(focusSearch(130) != null)
            editorinfo.imeOptions = 0x8000000 | editorinfo.imeOptions;
        if(focusSearch(33) != null)
            editorinfo.imeOptions = 0x4000000 | editorinfo.imeOptions;
        if((0xff & editorinfo.imeOptions) == 0) {
            if((0x8000000 & editorinfo.imeOptions) != 0)
                editorinfo.imeOptions = 5 | editorinfo.imeOptions;
            else
                editorinfo.imeOptions = 6 | editorinfo.imeOptions;
            if(!shouldAdvanceFocusOnEnter())
                editorinfo.imeOptions = 0x40000000 | editorinfo.imeOptions;
        }
        if(isMultilineInputType(editorinfo.inputType))
            editorinfo.imeOptions = 0x40000000 | editorinfo.imeOptions;
        editorinfo.hintText = mHint;
        if(!(mText instanceof Editable)) goto _L2; else goto _L3
_L3:
        editableinputconnection = new EditableInputConnection(this);
        editorinfo.initialSelStart = getSelectionStart();
        editorinfo.initialSelEnd = getSelectionEnd();
        editorinfo.initialCapsMode = editableinputconnection.getCursorCapsMode(getInputType());
_L5:
        return editableinputconnection;
_L2:
        editableinputconnection = null;
        if(true) goto _L5; else goto _L4
_L4:
    }

    protected void onDetachedFromWindow() {
        onDetachedFromWindow();
        if(mPreDrawRegistered) {
            getViewTreeObserver().removeOnPreDrawListener(this);
            mPreDrawRegistered = false;
        }
        resetResolvedDrawables();
        if(mEditor != null)
            mEditor.onDetachedFromWindow();
    }

    public boolean onDragEvent(DragEvent dragevent) {
        boolean flag = true;
        dragevent.getAction();
        JVM INSTR tableswitch 1 5: default 40
    //                   1 42
    //                   2 82
    //                   3 109
    //                   4 40
    //                   5 74;
           goto _L1 _L2 _L3 _L4 _L1 _L5
_L1:
        return flag;
_L2:
        boolean flag1;
        if(mEditor != null && mEditor.hasInsertionController())
            flag1 = flag;
        else
            flag1 = false;
        flag = flag1;
        continue; /* Loop/switch isn't completed */
_L5:
        requestFocus();
        continue; /* Loop/switch isn't completed */
_L3:
        int i = getOffsetForPosition(dragevent.getX(), dragevent.getY());
        Selection.setSelection((Spannable)mText, i);
        continue; /* Loop/switch isn't completed */
_L4:
        if(mEditor != null)
            mEditor.onDrop(dragevent);
        if(true) goto _L1; else goto _L6
_L6:
    }

    protected void onDraw(Canvas canvas) {
        restartMarqueeIfNeeded();
        onDraw(canvas);
        int i = getCompoundPaddingLeft();
        int j = getCompoundPaddingTop();
        int k = getCompoundPaddingRight();
        int l = getCompoundPaddingBottom();
        int i1 = super.mScrollX;
        int j1 = super.mScrollY;
        int k1 = super.mRight;
        int l1 = super.mLeft;
        int i2 = super.mBottom;
        int j2 = super.mTop;
        Drawables drawables = mDrawables;
        if(drawables != null) {
            int j5 = i2 - j2 - l - j;
            int k5 = k1 - l1 - k - i;
            if(drawables.mDrawableLeft != null) {
                canvas.save();
                canvas.translate(i1 + super.mPaddingLeft, j1 + j + (j5 - drawables.mDrawableHeightLeft) / 2);
                drawables.mDrawableLeft.draw(canvas);
                canvas.restore();
            }
            if(drawables.mDrawableRight != null) {
                canvas.save();
                canvas.translate((i1 + k1) - l1 - super.mPaddingRight - drawables.mDrawableSizeRight, j1 + j + (j5 - drawables.mDrawableHeightRight) / 2);
                drawables.mDrawableRight.draw(canvas);
                canvas.restore();
            }
            if(drawables.mDrawableTop != null) {
                canvas.save();
                canvas.translate(i1 + i + (k5 - drawables.mDrawableWidthTop) / 2, j1 + super.mPaddingTop);
                drawables.mDrawableTop.draw(canvas);
                canvas.restore();
            }
            if(drawables.mDrawableBottom != null) {
                canvas.save();
                canvas.translate(i1 + i + (k5 - drawables.mDrawableWidthBottom) / 2, (j1 + i2) - j2 - super.mPaddingBottom - drawables.mDrawableSizeBottom);
                drawables.mDrawableBottom.draw(canvas);
                canvas.restore();
            }
        }
        int k2 = mCurTextColor;
        if(mLayout == null)
            assumeLayout();
        Layout layout = mLayout;
        if(mHint != null && mText.length() == 0) {
            if(mHintTextColor != null)
                k2 = mCurHintTextColor;
            layout = mHintLayout;
        }
        mTextPaint.setColor(k2);
        mTextPaint.drawableState = getDrawableState();
        canvas.save();
        int l2 = getExtendedPaddingTop();
        int i3 = getExtendedPaddingBottom();
        int j3 = super.mBottom - super.mTop - l - j;
        int k3 = mLayout.getHeight() - j3;
        float f = i + i1;
        float f1;
        float f2;
        int l3;
        float f3;
        int i4;
        int j4;
        int k4;
        int l4;
        int i5;
        Path path;
        if(j1 == 0)
            f1 = 0.0F;
        else
            f1 = l2 + j1;
        f2 = i1 + (k1 - l1 - k);
        l3 = j1 + (i2 - j2);
        if(j1 == k3)
            i3 = 0;
        f3 = l3 - i3;
        if(mShadowRadius != 0.0F) {
            f += Math.min(0.0F, mShadowDx - mShadowRadius);
            f2 += Math.max(0.0F, mShadowDx + mShadowRadius);
            f1 += Math.min(0.0F, mShadowDy - mShadowRadius);
            f3 += Math.max(0.0F, mShadowDy + mShadowRadius);
        }
        canvas.clipRect(f, f1, f2, f3);
        i4 = 0;
        j4 = 0;
        if((0x70 & mGravity) != 48) {
            i4 = getVerticalOffset(false);
            j4 = getVerticalOffset(true);
        }
        canvas.translate(i, l2 + i4);
        k4 = getResolvedLayoutDirection();
        l4 = Gravity.getAbsoluteGravity(mGravity, k4);
        if(mEllipsize == android.text.TextUtils.TruncateAt.MARQUEE && mMarqueeFadeMode != 1) {
            if(!mSingleLine && getLineCount() == 1 && canMarquee() && (l4 & 7) != 3)
                canvas.translate(mLayout.getLineRight(0) - (float)(super.mRight - super.mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight()), 0.0F);
            if(mMarquee != null && mMarquee.isRunning())
                canvas.translate(-mMarquee.mScroll, 0.0F);
        }
        i5 = j4 - i4;
        path = getUpdatedHighlightPath();
        if(mEditor != null)
            mEditor.onDraw(canvas, layout, path, mHighlightPaint, i5);
        else
            layout.draw(canvas, path, mHighlightPaint, i5);
        if(mMarquee != null && mMarquee.shouldDrawGhost()) {
            canvas.translate((int)mMarquee.getGhostOffset(), 0.0F);
            layout.draw(canvas, path, mHighlightPaint, i5);
        }
        canvas.restore();
    }

    public void onEditorAction(int i) {
        Editor.InputContentType inputcontenttype;
        if(mEditor == null)
            inputcontenttype = null;
        else
            inputcontenttype = mEditor.mInputContentType;
        if(inputcontenttype == null) goto _L2; else goto _L1
_L1:
        if(inputcontenttype.onEditorActionListener == null || !inputcontenttype.onEditorActionListener.onEditorAction(this, i, null)) goto _L4; else goto _L3
_L3:
        return;
_L4:
        if(i == 5) {
            View view1 = focusSearch(2);
            if(view1 != null && !view1.requestFocus(2))
                throw new IllegalStateException("focus search returned a view that wasn't able to take focus!");
            continue; /* Loop/switch isn't completed */
        }
        if(i == 7) {
            View view = focusSearch(1);
            if(view != null && !view.requestFocus(1))
                throw new IllegalStateException("focus search returned a view that wasn't able to take focus!");
            continue; /* Loop/switch isn't completed */
        }
        if(i == 6) {
            InputMethodManager inputmethodmanager = InputMethodManager.peekInstance();
            if(inputmethodmanager != null && inputmethodmanager.isActive(this))
                inputmethodmanager.hideSoftInputFromWindow(getWindowToken(), 0);
            continue; /* Loop/switch isn't completed */
        }
_L2:
        ViewRootImpl viewrootimpl = getViewRootImpl();
        if(viewrootimpl != null) {
            long l = SystemClock.uptimeMillis();
            viewrootimpl.dispatchKeyFromIme(new KeyEvent(l, l, 0, 66, 0, 0, -1, 0, 22));
            viewrootimpl.dispatchKeyFromIme(new KeyEvent(SystemClock.uptimeMillis(), l, 1, 66, 0, 0, -1, 0, 22));
        }
        if(true) goto _L3; else goto _L5
_L5:
    }

    public void onEndBatchEdit() {
    }

    public void onFinishTemporaryDetach() {
        onFinishTemporaryDetach();
        if(!mDispatchTemporaryDetach)
            mTemporaryDetach = false;
        if(mEditor != null)
            mEditor.mTemporaryDetach = false;
    }

    protected void onFocusChanged(boolean flag, int i, Rect rect) {
        if(mTemporaryDetach) {
            onFocusChanged(flag, i, rect);
        } else {
            if(mEditor != null)
                mEditor.onFocusChanged(flag, i);
            if(flag && (mText instanceof Spannable))
                MetaKeyKeyListener.resetMetaState((Spannable)mText);
            startStopMarquee(flag);
            if(mTransformation != null)
                mTransformation.onFocusChanged(this, mText, flag, i, rect);
            onFocusChanged(flag, i, rect);
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionevent) {
        if(mMovement == null || !(mText instanceof Spannable) || mLayout == null) goto _L2; else goto _L1
_L1:
        boolean flag1 = mMovement.onGenericMotionEvent(this, (Spannable)mText, motionevent);
        if(!flag1) goto _L2; else goto _L3
_L3:
        boolean flag = true;
_L5:
        return flag;
        AbstractMethodError abstractmethoderror;
        abstractmethoderror;
_L2:
        flag = onGenericMotionEvent(motionevent);
        if(true) goto _L5; else goto _L4
_L4:
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/TextView.getName());
        accessibilityevent.setPassword(hasPasswordTransformationMethod());
        if(accessibilityevent.getEventType() == 8192) {
            accessibilityevent.setFromIndex(Selection.getSelectionStart(mText));
            accessibilityevent.setToIndex(Selection.getSelectionEnd(mText));
            accessibilityevent.setItemCount(mText.length());
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/TextView.getName());
        boolean flag = hasPasswordTransformationMethod();
        accessibilitynodeinfo.setPassword(flag);
        if(!flag)
            accessibilitynodeinfo.setText(getTextForAccessibility());
        if(TextUtils.isEmpty(getContentDescription()) && !TextUtils.isEmpty(mText)) {
            accessibilitynodeinfo.addAction(256);
            accessibilitynodeinfo.addAction(512);
            accessibilitynodeinfo.setMovementGranularities(31);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyevent) {
        boolean flag;
        if(doKeyDown(i, keyevent, null) == 0)
            flag = onKeyDown(i, keyevent);
        else
            flag = true;
        return flag;
    }

    public boolean onKeyMultiple(int i, int j, KeyEvent keyevent) {
        KeyEvent keyevent1;
        int k;
        keyevent1 = KeyEvent.changeAction(keyevent, 0);
        k = doKeyDown(i, keyevent1, keyevent);
        if(k != 0) goto _L2; else goto _L1
_L1:
        boolean flag = onKeyMultiple(i, j, keyevent);
_L4:
        return flag;
_L2:
        int l;
        KeyEvent keyevent2;
        if(k == -1) {
            flag = true;
            continue; /* Loop/switch isn't completed */
        }
        l = j - 1;
        keyevent2 = KeyEvent.changeAction(keyevent, 1);
        if(k != 1)
            break; /* Loop/switch isn't completed */
        mEditor.mKeyListener.onKeyUp(this, (Editable)mText, i, keyevent2);
        while(--l > 0)  {
            mEditor.mKeyListener.onKeyDown(this, (Editable)mText, i, keyevent1);
            mEditor.mKeyListener.onKeyUp(this, (Editable)mText, i, keyevent2);
        }
        hideErrorIfUnchanged();
_L6:
        flag = true;
        if(true) goto _L4; else goto _L3
_L3:
        if(k != 2) goto _L6; else goto _L5
_L5:
        mMovement.onKeyUp(this, (Spannable)mText, i, keyevent2);
        while(--l > 0)  {
            mMovement.onKeyDown(this, (Spannable)mText, i, keyevent1);
            mMovement.onKeyUp(this, (Spannable)mText, i, keyevent2);
        }
          goto _L6
    }

    public boolean onKeyPreIme(int i, KeyEvent keyevent) {
        boolean flag = true;
        if(i != 4) goto _L2; else goto _L1
_L1:
        int j;
        if(mEditor != null && mEditor.mSelectionActionMode != null)
            j = ((flag) ? 1 : 0);
        else
            j = 0;
        if(j == 0) goto _L2; else goto _L3
_L3:
        if(keyevent.getAction() != 0 || keyevent.getRepeatCount() != 0) goto _L5; else goto _L4
_L4:
        android.view.KeyEvent.DispatcherState dispatcherstate1 = getKeyDispatcherState();
        if(dispatcherstate1 != null)
            dispatcherstate1.startTracking(keyevent, this);
_L7:
        return flag;
_L5:
        if(keyevent.getAction() == flag) {
            android.view.KeyEvent.DispatcherState dispatcherstate = getKeyDispatcherState();
            if(dispatcherstate != null)
                dispatcherstate.handleUpEvent(keyevent);
            if(keyevent.isTracking() && !keyevent.isCanceled()) {
                stopSelectionActionMode();
                continue; /* Loop/switch isn't completed */
            }
        }
_L2:
        flag = onKeyPreIme(i, keyevent);
        if(true) goto _L7; else goto _L6
_L6:
    }

    public boolean onKeyShortcut(int i, KeyEvent keyevent) {
        if(!KeyEvent.metaStateHasNoModifiers(0xffff8fff & keyevent.getMetaState())) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR lookupswitch 4: default 56
    //                   29: 65
    //                   31: 99
    //                   50: 116
    //                   52: 82;
           goto _L2 _L3 _L4 _L5 _L6
_L2:
        boolean flag = onKeyShortcut(i, keyevent);
_L8:
        return flag;
_L3:
        if(!canSelectText()) goto _L2; else goto _L7
_L7:
        flag = onTextContextMenuItem(0x102001f);
          goto _L8
_L6:
        if(!canCut()) goto _L2; else goto _L9
_L9:
        flag = onTextContextMenuItem(0x1020020);
          goto _L8
_L4:
        if(!canCopy()) goto _L2; else goto _L10
_L10:
        flag = onTextContextMenuItem(0x1020021);
          goto _L8
_L5:
        if(!canPaste()) goto _L2; else goto _L11
_L11:
        flag = onTextContextMenuItem(0x1020022);
          goto _L8
    }

    public boolean onKeyUp(int i, KeyEvent keyevent) {
        if(isEnabled()) goto _L2; else goto _L1
_L1:
        boolean flag = onKeyUp(i, keyevent);
_L8:
        return flag;
_L2:
        i;
        JVM INSTR lookupswitch 2: default 44
    //                   23: 91
    //                   66: 177;
           goto _L3 _L4 _L5
_L3:
        View view;
        InputMethodManager inputmethodmanager;
        InputMethodManager inputmethodmanager1;
        if(mEditor != null && mEditor.mKeyListener != null && mEditor.mKeyListener.onKeyUp(this, (Editable)mText, i, keyevent))
            flag = true;
        else
        if(mMovement != null && mLayout != null && mMovement.onKeyUp(this, (Spannable)mText, i, keyevent))
            flag = true;
        else
            flag = onKeyUp(i, keyevent);
        continue; /* Loop/switch isn't completed */
_L4:
        if(keyevent.hasNoModifiers() && !hasOnClickListeners() && mMovement != null && (mText instanceof Editable) && mLayout != null && onCheckIsTextEditor()) {
            inputmethodmanager1 = InputMethodManager.peekInstance();
            viewClicked(inputmethodmanager1);
            if(inputmethodmanager1 != null && getShowSoftInputOnFocus())
                inputmethodmanager1.showSoftInput(this, 0);
        }
        flag = onKeyUp(i, keyevent);
        continue; /* Loop/switch isn't completed */
_L5:
        if(!keyevent.hasNoModifiers()) goto _L3; else goto _L6
_L6:
        if(mEditor != null && mEditor.mInputContentType != null && mEditor.mInputContentType.onEditorActionListener != null && mEditor.mInputContentType.enterDown) {
            mEditor.mInputContentType.enterDown = false;
            if(mEditor.mInputContentType.onEditorActionListener.onEditorAction(this, 0, keyevent)) {
                flag = true;
                continue; /* Loop/switch isn't completed */
            }
        }
        if(((0x10 & keyevent.getFlags()) != 0 || shouldAdvanceFocusOnEnter()) && !hasOnClickListeners()) {
            view = focusSearch(130);
            if(view != null) {
                if(!view.requestFocus(130))
                    throw new IllegalStateException("focus search returned a view that wasn't able to take focus!");
                onKeyUp(i, keyevent);
                flag = true;
                continue; /* Loop/switch isn't completed */
            }
            if((0x10 & keyevent.getFlags()) != 0) {
                inputmethodmanager = InputMethodManager.peekInstance();
                if(inputmethodmanager != null && inputmethodmanager.isActive(this))
                    inputmethodmanager.hideSoftInputFromWindow(getWindowToken(), 0);
            }
        }
        flag = onKeyUp(i, keyevent);
        if(true) goto _L8; else goto _L7
_L7:
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l) {
        onLayout(flag, i, j, k, l);
        if(flag && mEditor != null)
            mEditor.invalidateTextDisplayList();
    }

    void onLocaleChanged() {
        mEditor.mWordIterator = null;
    }

    protected void onMeasure(int i, int j) {
        int k = android.view.View.MeasureSpec.getMode(i);
        int l = android.view.View.MeasureSpec.getMode(j);
        int i1 = android.view.View.MeasureSpec.getSize(i);
        int j1 = android.view.View.MeasureSpec.getSize(j);
        android.text.BoringLayout.Metrics metrics = UNKNOWN_BORING;
        android.text.BoringLayout.Metrics metrics1 = UNKNOWN_BORING;
        if(mTextDir == null)
            resolveTextDirection();
        int k1 = -1;
        boolean flag = false;
        int j3;
        int k3;
        int l3;
        int i4;
        int j4;
        int l4;
        int i5;
        if(k == 0x40000000) {
            j3 = i1;
        } else {
            if(mLayout != null && mEllipsize == null)
                k1 = desired(mLayout);
            int l1;
            Drawables drawables;
            int i2;
            int j2;
            int l2;
            if(k1 < 0) {
                metrics = BoringLayout.isBoring(mTransformed, mTextPaint, mTextDir, mBoring);
                if(metrics != null)
                    mBoring = metrics;
            } else {
                flag = true;
            }
            if(metrics == null || metrics == UNKNOWN_BORING) {
                if(k1 < 0)
                    k1 = (int)FloatMath.ceil(Layout.getDesiredWidth(mTransformed, mTextPaint));
                l1 = k1;
            } else {
                l1 = metrics.width;
            }
            drawables = mDrawables;
            if(drawables != null) {
                int j6 = drawables.mDrawableWidthTop;
                l1 = Math.max(Math.max(l1, j6), drawables.mDrawableWidthBottom);
            }
            if(mHint != null) {
                int l5 = -1;
                if(mHintLayout != null && mEllipsize == null)
                    l5 = desired(mHintLayout);
                if(l5 < 0) {
                    metrics1 = BoringLayout.isBoring(mHint, mTextPaint, mTextDir, mHintBoring);
                    if(metrics1 != null)
                        mHintBoring = metrics1;
                }
                int i3;
                int k5;
                int i6;
                if(metrics1 == null || metrics1 == UNKNOWN_BORING) {
                    if(l5 < 0)
                        l5 = (int)FloatMath.ceil(Layout.getDesiredWidth(mHint, mTextPaint));
                    i6 = l5;
                } else {
                    i6 = metrics1.width;
                }
                if(i6 > l1)
                    l1 = i6;
            }
            i2 = l1 + (getCompoundPaddingLeft() + getCompoundPaddingRight());
            if(mMaxWidthMode == 1)
                j2 = Math.min(i2, mMaxWidth * getLineHeight());
            else
                j2 = Math.min(i2, mMaxWidth);
            if(mMinWidthMode == 1) {
                k5 = mMinWidth * getLineHeight();
                l2 = Math.max(j2, k5);
            } else {
                int k2 = mMinWidth;
                l2 = Math.max(j2, k2);
            }
            i3 = getSuggestedMinimumWidth();
            j3 = Math.max(l2, i3);
            if(k == 0x80000000)
                j3 = Math.min(i1, j3);
        }
        k3 = j3 - getCompoundPaddingLeft() - getCompoundPaddingRight();
        l3 = k3;
        if(mHorizontallyScrolling)
            k3 = 0x100000;
        i4 = k3;
        if(mHintLayout == null)
            j4 = i4;
        else
            j4 = mHintLayout.getWidth();
        if(mLayout == null) {
            makeNewLayout(k3, i4, metrics, metrics1, j3 - getCompoundPaddingLeft() - getCompoundPaddingRight(), false);
        } else {
            boolean flag1;
            boolean flag2;
            boolean flag3;
            if(mLayout.getWidth() != k3 || j4 != i4 || mLayout.getEllipsizedWidth() != j3 - getCompoundPaddingLeft() - getCompoundPaddingRight())
                flag1 = true;
            else
                flag1 = false;
            if(mHint == null && mEllipsize == null && k3 > mLayout.getWidth() && ((mLayout instanceof BoringLayout) || flag && k1 >= 0 && k1 <= k3))
                flag2 = true;
            else
                flag2 = false;
            if(mMaxMode != mOldMaxMode || mMaximum != mOldMaximum)
                flag3 = true;
            else
                flag3 = false;
            if(flag1 || flag3)
                if(!flag3 && flag2)
                    mLayout.increaseWidthTo(k3);
                else
                    makeNewLayout(k3, i4, metrics, metrics1, j3 - getCompoundPaddingLeft() - getCompoundPaddingRight(), false);
        }
        if(l == 0x40000000) {
            l4 = j1;
            mDesiredHeightAtMeasure = -1;
        } else {
            int k4 = getDesiredHeight();
            l4 = k4;
            mDesiredHeightAtMeasure = k4;
            if(l == 0x80000000)
                l4 = Math.min(k4, j1);
        }
        i5 = l4 - getCompoundPaddingTop() - getCompoundPaddingBottom();
        if(mMaxMode == 1 && mLayout.getLineCount() > mMaximum) {
            int j5 = mLayout.getLineTop(mMaximum);
            i5 = Math.min(i5, j5);
        }
        if(mMovement != null || mLayout.getWidth() > l3 || mLayout.getHeight() > i5)
            registerForPreDraw();
        else
            scrollTo(0, 0);
        setMeasuredDimension(j3, l4);
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        onPopulateAccessibilityEvent(accessibilityevent);
        if(!hasPasswordTransformationMethod() || shouldSpeakPasswordsForAccessibility()) {
            CharSequence charsequence = getTextForAccessibility();
            if(!TextUtils.isEmpty(charsequence))
                accessibilityevent.getText().add(charsequence);
        }
    }

    public boolean onPreDraw() {
        boolean flag = false;
        if(mLayout == null)
            assumeLayout();
        boolean flag1 = false;
        if(mMovement != null) {
            int i = getSelectionEnd();
            if(mEditor != null && mEditor.mSelectionModifierCursorController != null && mEditor.mSelectionModifierCursorController.isSelectionStartDragged())
                i = getSelectionStart();
            if(i < 0 && (0x70 & mGravity) == 80)
                i = mText.length();
            if(i >= 0)
                flag1 = bringPointIntoView(i);
        } else {
            flag1 = bringTextIntoView();
        }
        if(mEditor != null && mEditor.mCreatedWithASelection) {
            mEditor.startSelectionActionMode();
            mEditor.mCreatedWithASelection = false;
        }
        if((this instanceof ExtractEditText) && hasSelection() && mEditor != null)
            mEditor.startSelectionActionMode();
        getViewTreeObserver().removeOnPreDrawListener(this);
        mPreDrawRegistered = false;
        if(!flag1)
            flag = true;
        return flag;
    }

    public boolean onPrivateIMECommand(String s, Bundle bundle) {
        return false;
    }

    public void onResolvedLayoutDirectionReset() {
        if(mLayoutAlignment != null) {
            int i = getResolvedTextAlignment();
            if(i == 5 || i == 6)
                mLayoutAlignment = null;
        }
    }

    public void onResolvedTextDirectionChanged() {
        int i = 1;
        if(!hasPasswordTransformationMethod()) goto _L2; else goto _L1
_L1:
        mTextDir = TextDirectionHeuristics.LOCALE;
_L4:
        return;
_L2:
        if(getResolvedLayoutDirection() != i)
            i = 0;
        switch(getResolvedTextDirection()) {
        default:
            TextDirectionHeuristic textdirectionheuristic;
            if(i != 0)
                textdirectionheuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
            else
                textdirectionheuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            mTextDir = textdirectionheuristic;
            break;

        case 2: // '\002'
            mTextDir = TextDirectionHeuristics.ANYRTL_LTR;
            break;

        case 3: // '\003'
            mTextDir = TextDirectionHeuristics.LTR;
            break;

        case 4: // '\004'
            mTextDir = TextDirectionHeuristics.RTL;
            break;

        case 5: // '\005'
            mTextDir = TextDirectionHeuristics.LOCALE;
            break;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if(parcelable instanceof SavedState) goto _L2; else goto _L1
_L1:
        onRestoreInstanceState(parcelable);
_L4:
        return;
_L2:
        SavedState savedstate;
        savedstate = (SavedState)parcelable;
        onRestoreInstanceState(savedstate.getSuperState());
        if(savedstate.text != null)
            setText(savedstate.text);
        if(savedstate.selStart >= 0 && savedstate.selEnd >= 0 && (mText instanceof Spannable)) {
            int i = mText.length();
            if(savedstate.selStart <= i && savedstate.selEnd <= i)
                break; /* Loop/switch isn't completed */
            String s = "";
            if(savedstate.text != null)
                s = "(restored) ";
            Log.e("TextView", (new StringBuilder()).append("Saved cursor position ").append(savedstate.selStart).append("/").append(savedstate.selEnd).append(" out of range for ").append(s).append("text ").append(mText).toString());
        }
_L5:
        if(savedstate.error != null)
            post(new Runnable() {

                public void run() {
                    setError(error);
                }

                final TextView this$0;
                final CharSequence val$error;

             {
                this$0 = TextView.this;
                error = charsequence;
                super();
            }
            });
        if(true) goto _L4; else goto _L3
_L3:
        Selection.setSelection((Spannable)mText, savedstate.selStart, savedstate.selEnd);
        if(savedstate.frozenWithFocus) {
            createEditorIfNeeded();
            mEditor.mFrozenWithFocus = true;
        }
          goto _L5
        if(true) goto _L4; else goto _L6
_L6:
    }

    public Parcelable onSaveInstanceState() {
        Parcelable parcelable = onSaveInstanceState();
        boolean flag = mFreezesText;
        int i = 0;
        int j = 0;
        if(mText != null) {
            i = getSelectionStart();
            j = getSelectionEnd();
            if(i >= 0 || j >= 0)
                flag = true;
        }
        Object obj;
        if(flag) {
            obj = new SavedState(parcelable);
            obj.selStart = i;
            obj.selEnd = j;
            if(mText instanceof Spanned) {
                SpannableString spannablestring = new SpannableString(mText);
                ChangeWatcher achangewatcher[] = (ChangeWatcher[])spannablestring.getSpans(0, spannablestring.length(), android/widget/TextView$ChangeWatcher);
                int k = achangewatcher.length;
                for(int l = 0; l < k; l++)
                    spannablestring.removeSpan(achangewatcher[l]);

                if(mEditor != null) {
                    removeMisspelledSpans(spannablestring);
                    spannablestring.removeSpan(mEditor.mSuggestionRangeSpan);
                }
                obj.text = spannablestring;
            } else {
                obj.text = mText.toString();
            }
            if(isFocused() && i >= 0 && j >= 0)
                obj.frozenWithFocus = true;
            obj.error = getError();
        } else {
            obj = parcelable;
        }
        return ((Parcelable) (obj));
    }

    public void onScreenStateChanged(int i) {
        onScreenStateChanged(i);
        if(mEditor != null)
            mEditor.onScreenStateChanged(i);
    }

    protected void onScrollChanged(int i, int j, int k, int l) {
        onScrollChanged(i, j, k, l);
        if(mEditor != null)
            mEditor.onScrollChanged();
    }

    protected void onSelectionChanged(int i, int j) {
        sendAccessibilityEvent(8192);
    }

    public void onStartTemporaryDetach() {
        onStartTemporaryDetach();
        if(!mDispatchTemporaryDetach)
            mTemporaryDetach = true;
        if(mEditor != null)
            mEditor.mTemporaryDetach = true;
    }

    protected void onTextChanged(CharSequence charsequence, int i, int j, int k) {
    }

    public boolean onTextContextMenuItem(int i) {
        boolean flag;
        int j;
        int k;
        flag = true;
        j = 0;
        k = mText.length();
        if(isFocused()) {
            int l = getSelectionStart();
            int i1 = getSelectionEnd();
            j = Math.max(0, Math.min(l, i1));
            k = Math.max(0, Math.max(l, i1));
        }
        i;
        JVM INSTR tableswitch 16908319 16908322: default 92
    //                   16908319 96
    //                   16908320 114
    //                   16908321 143
    //                   16908322 104;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        flag = false;
_L7:
        return flag;
_L2:
        selectAllText();
        continue; /* Loop/switch isn't completed */
_L5:
        paste(j, k);
        continue; /* Loop/switch isn't completed */
_L3:
        setPrimaryClip(ClipData.newPlainText(null, getTransformedText(j, k)));
        deleteText_internal(j, k);
        stopSelectionActionMode();
        continue; /* Loop/switch isn't completed */
_L4:
        setPrimaryClip(ClipData.newPlainText(null, getTransformedText(j, k)));
        stopSelectionActionMode();
        if(true) goto _L7; else goto _L6
_L6:
    }

    public boolean onTouchEvent(MotionEvent motionevent) {
        int i;
        boolean flag;
        int j;
        i = 0;
        flag = true;
        j = motionevent.getActionMasked();
        if(mEditor == null || !mEditor.onTouchEvent(motionevent)) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        boolean flag1 = onTouchEvent(motionevent);
        if(mEditor != null && mEditor.mDiscardNextActionUp && j == flag) {
            mEditor.mDiscardNextActionUp = false;
            flag = flag1;
            continue; /* Loop/switch isn't completed */
        }
        int k;
        if(j == flag && (mEditor == null || !mEditor.mIgnoreActionUpEvent) && isFocused())
            k = ((flag) ? 1 : 0);
        else
            k = 0;
        if((mMovement != null || onCheckIsTextEditor()) && isEnabled() && (mText instanceof Spannable) && mLayout != null) {
            boolean flag2 = false;
            if(mMovement != null)
                flag2 = false | mMovement.onTouchEvent(this, (Spannable)mText, motionevent);
            boolean flag3 = isTextSelectable();
            if(k != 0 && mLinksClickable && mAutoLinkMask != 0 && flag3) {
                ClickableSpan aclickablespan[] = (ClickableSpan[])((Spannable)mText).getSpans(getSelectionStart(), getSelectionEnd(), android/text/style/ClickableSpan);
                if(aclickablespan.length > 0) {
                    aclickablespan[0].onClick(this);
                    flag2 = true;
                }
            }
            if(k != 0 && (isTextEditable() || flag3)) {
                InputMethodManager inputmethodmanager = InputMethodManager.peekInstance();
                viewClicked(inputmethodmanager);
                if(!flag3 && mEditor.mShowSoftInputOnFocus) {
                    if(inputmethodmanager != null && inputmethodmanager.showSoftInput(this, 0))
                        i = ((flag) ? 1 : 0);
                    flag2 | i;
                }
                mEditor.onTouchUpEvent(motionevent);
                flag2 = true;
            }
            if(flag2)
                continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean onTrackballEvent(MotionEvent motionevent) {
        boolean flag;
        if(mMovement != null && (mText instanceof Spannable) && mLayout != null && mMovement.onTrackballEvent(this, (Spannable)mText, motionevent))
            flag = true;
        else
            flag = onTrackballEvent(motionevent);
        return flag;
    }

    protected void onVisibilityChanged(View view, int i) {
        onVisibilityChanged(view, i);
        if(mEditor != null && i != 0)
            mEditor.hideControllers();
    }

    public void onWindowFocusChanged(boolean flag) {
        onWindowFocusChanged(flag);
        if(mEditor != null)
            mEditor.onWindowFocusChanged(flag);
        startStopMarquee(flag);
    }

    public boolean performLongClick() {
        boolean flag = false;
        if(performLongClick()) {
            if(mEditor != null)
                mEditor.mDiscardNextActionUp = true;
            performHapticFeedback(0);
            flag = true;
        }
        if(!flag && mEditor != null)
            flag |= mEditor.performLongClick(flag);
        return flag;
    }

    long prepareSpacesAroundPaste(int i, int j, CharSequence charsequence) {
        if(charsequence.length() > 0) {
            if(i > 0) {
                char c2 = mTransformed.charAt(i - 1);
                char c3 = charsequence.charAt(0);
                if(Character.isSpaceChar(c2) && Character.isSpaceChar(c3)) {
                    int i1 = mText.length();
                    deleteText_internal(i - 1, i);
                    int j1 = mText.length() - i1;
                    i += j1;
                    j += j1;
                } else
                if(!Character.isSpaceChar(c2) && c2 != '\n' && !Character.isSpaceChar(c3) && c3 != '\n') {
                    int k = mText.length();
                    replaceText_internal(i, i, " ");
                    int l = mText.length() - k;
                    i += l;
                    j += l;
                }
            }
            if(j < mText.length()) {
                char c = charsequence.charAt(-1 + charsequence.length());
                char c1 = mTransformed.charAt(j);
                if(Character.isSpaceChar(c) && Character.isSpaceChar(c1))
                    deleteText_internal(j, j + 1);
                else
                if(!Character.isSpaceChar(c) && c != '\n' && !Character.isSpaceChar(c1) && c1 != '\n')
                    replaceText_internal(j, j, " ");
            }
        }
        return TextUtils.packRangeInLong(i, j);
    }

    void removeMisspelledSpans(Spannable spannable) {
        SuggestionSpan asuggestionspan[] = (SuggestionSpan[])spannable.getSpans(0, spannable.length(), android/text/style/SuggestionSpan);
        for(int i = 0; i < asuggestionspan.length; i++) {
            int j = asuggestionspan[i].getFlags();
            if((j & 1) != 0 && (j & 2) != 0)
                spannable.removeSpan(asuggestionspan[i]);
        }

    }

    CharSequence removeSuggestionSpans(CharSequence charsequence) {
        if(charsequence instanceof Spanned) {
            Object obj;
            SuggestionSpan asuggestionspan[];
            if(charsequence instanceof Spannable) {
                obj = (Spannable)charsequence;
            } else {
                obj = new SpannableString(charsequence);
                charsequence = ((CharSequence) (obj));
            }
            asuggestionspan = (SuggestionSpan[])((Spannable) (obj)).getSpans(0, charsequence.length(), android/text/style/SuggestionSpan);
            for(int i = 0; i < asuggestionspan.length; i++)
                ((Spannable) (obj)).removeSpan(asuggestionspan[i]);

        }
        return charsequence;
    }

    public void removeTextChangedListener(TextWatcher textwatcher) {
        if(mListeners != null) {
            int i = mListeners.indexOf(textwatcher);
            if(i >= 0)
                mListeners.remove(i);
        }
    }

    protected void replaceText_internal(int i, int j, CharSequence charsequence) {
        ((Editable)mText).replace(i, j, charsequence);
    }

    public void resetErrorChangedFlag() {
        if(mEditor != null)
            mEditor.mErrorWasChanged = false;
    }

    protected void resetResolvedDrawables() {
        mResolvedDrawables = false;
    }

    protected void resolveDrawables() {
_L2:
        return;
        if(mResolvedDrawables || mDrawables == null) goto _L2; else goto _L1
_L1:
        Drawables drawables;
        if(mDrawables.mDrawableStart == null && mDrawables.mDrawableEnd == null) {
            mResolvedDrawables = true;
            continue; /* Loop/switch isn't completed */
        }
        drawables = mDrawables;
        switch(getResolvedLayoutDirection()) {
        default:
            if(drawables.mDrawableStart != null) {
                drawables.mDrawableLeft = drawables.mDrawableStart;
                drawables.mDrawableSizeLeft = drawables.mDrawableSizeStart;
                drawables.mDrawableHeightLeft = drawables.mDrawableHeightStart;
            }
            if(drawables.mDrawableEnd != null) {
                drawables.mDrawableRight = drawables.mDrawableEnd;
                drawables.mDrawableSizeRight = drawables.mDrawableSizeEnd;
                drawables.mDrawableHeightRight = drawables.mDrawableHeightEnd;
            }
            break;

        case 1: // '\001'
            break; /* Loop/switch isn't completed */
        }
_L4:
        mResolvedDrawables = true;
        if(true) goto _L2; else goto _L3
_L3:
        if(drawables.mDrawableStart != null) {
            drawables.mDrawableRight = drawables.mDrawableStart;
            drawables.mDrawableSizeRight = drawables.mDrawableSizeStart;
            drawables.mDrawableHeightRight = drawables.mDrawableHeightStart;
        }
        if(drawables.mDrawableEnd != null) {
            drawables.mDrawableLeft = drawables.mDrawableEnd;
            drawables.mDrawableSizeLeft = drawables.mDrawableSizeEnd;
            drawables.mDrawableHeightLeft = drawables.mDrawableHeightEnd;
        }
          goto _L4
        if(true) goto _L2; else goto _L5
_L5:
    }

    boolean selectAllText() {
        int i = mText.length();
        Selection.setSelection((Spannable)mText, 0, i);
        boolean flag;
        if(i > 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void sendAccessibilityEvent(int i) {
        if(i != 4096)
            sendAccessibilityEvent(i);
    }

    void sendAccessibilityEventTypeViewTextChanged(CharSequence charsequence, int i, int j, int k) {
        AccessibilityEvent accessibilityevent = AccessibilityEvent.obtain(16);
        accessibilityevent.setFromIndex(i);
        accessibilityevent.setRemovedCount(j);
        accessibilityevent.setAddedCount(k);
        accessibilityevent.setBeforeText(charsequence);
        sendAccessibilityEventUnchecked(accessibilityevent);
    }

    void sendAfterTextChanged(Editable editable) {
        if(mListeners != null) {
            ArrayList arraylist = mListeners;
            int i = arraylist.size();
            for(int j = 0; j < i; j++)
                ((TextWatcher)arraylist.get(j)).afterTextChanged(editable);

        }
    }

    void sendOnTextChanged(CharSequence charsequence, int i, int j, int k) {
        if(mListeners != null) {
            ArrayList arraylist = mListeners;
            int l = arraylist.size();
            for(int i1 = 0; i1 < l; i1++)
                ((TextWatcher)arraylist.get(i1)).onTextChanged(charsequence, i, j, k);

        }
        if(mEditor != null)
            mEditor.sendOnTextChanged(i, k);
    }

    public void setAccessibilityCursorPosition(int i) {
        if(getAccessibilityCursorPosition() != i)
            if(TextUtils.isEmpty(getContentDescription())) {
                if(i >= 0 && i <= mText.length())
                    Selection.setSelection((Spannable)mText, i);
                else
                    Selection.removeSelection((Spannable)mText);
            } else {
                setAccessibilityCursorPosition(i);
            }
    }

    public void setAllCaps(boolean flag) {
        if(flag)
            setTransformationMethod(new AllCapsTransformationMethod(getContext()));
        else
            setTransformationMethod(null);
    }

    public final void setAutoLinkMask(int i) {
        mAutoLinkMask = i;
    }

    public void setCompoundDrawablePadding(int i) {
        Drawables drawables = mDrawables;
        if(i == 0) {
            if(drawables != null)
                drawables.mDrawablePadding = i;
        } else {
            if(drawables == null) {
                drawables = new Drawables();
                mDrawables = drawables;
            }
            drawables.mDrawablePadding = i;
        }
        invalidate();
        requestLayout();
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable1, Drawable drawable2, Drawable drawable3) {
        Drawables drawables = mDrawables;
        boolean flag;
        if(drawable != null || drawable1 != null || drawable2 != null || drawable3 != null)
            flag = true;
        else
            flag = false;
        if(!flag) {
            if(drawables != null)
                if(drawables.mDrawablePadding == 0) {
                    mDrawables = null;
                } else {
                    if(drawables.mDrawableLeft != null)
                        drawables.mDrawableLeft.setCallback(null);
                    drawables.mDrawableLeft = null;
                    if(drawables.mDrawableTop != null)
                        drawables.mDrawableTop.setCallback(null);
                    drawables.mDrawableTop = null;
                    if(drawables.mDrawableRight != null)
                        drawables.mDrawableRight.setCallback(null);
                    drawables.mDrawableRight = null;
                    if(drawables.mDrawableBottom != null)
                        drawables.mDrawableBottom.setCallback(null);
                    drawables.mDrawableBottom = null;
                    drawables.mDrawableHeightLeft = 0;
                    drawables.mDrawableSizeLeft = 0;
                    drawables.mDrawableHeightRight = 0;
                    drawables.mDrawableSizeRight = 0;
                    drawables.mDrawableWidthTop = 0;
                    drawables.mDrawableSizeTop = 0;
                    drawables.mDrawableWidthBottom = 0;
                    drawables.mDrawableSizeBottom = 0;
                }
        } else {
            if(drawables == null) {
                drawables = new Drawables();
                mDrawables = drawables;
            }
            if(drawables.mDrawableLeft != drawable && drawables.mDrawableLeft != null)
                drawables.mDrawableLeft.setCallback(null);
            drawables.mDrawableLeft = drawable;
            if(drawables.mDrawableTop != drawable1 && drawables.mDrawableTop != null)
                drawables.mDrawableTop.setCallback(null);
            drawables.mDrawableTop = drawable1;
            if(drawables.mDrawableRight != drawable2 && drawables.mDrawableRight != null)
                drawables.mDrawableRight.setCallback(null);
            drawables.mDrawableRight = drawable2;
            if(drawables.mDrawableBottom != drawable3 && drawables.mDrawableBottom != null)
                drawables.mDrawableBottom.setCallback(null);
            drawables.mDrawableBottom = drawable3;
            Rect rect = drawables.mCompoundRect;
            int ai[] = getDrawableState();
            if(drawable != null) {
                drawable.setState(ai);
                drawable.copyBounds(rect);
                drawable.setCallback(this);
                drawables.mDrawableSizeLeft = rect.width();
                drawables.mDrawableHeightLeft = rect.height();
            } else {
                drawables.mDrawableHeightLeft = 0;
                drawables.mDrawableSizeLeft = 0;
            }
            if(drawable2 != null) {
                drawable2.setState(ai);
                drawable2.copyBounds(rect);
                drawable2.setCallback(this);
                drawables.mDrawableSizeRight = rect.width();
                drawables.mDrawableHeightRight = rect.height();
            } else {
                drawables.mDrawableHeightRight = 0;
                drawables.mDrawableSizeRight = 0;
            }
            if(drawable1 != null) {
                drawable1.setState(ai);
                drawable1.copyBounds(rect);
                drawable1.setCallback(this);
                drawables.mDrawableSizeTop = rect.height();
                drawables.mDrawableWidthTop = rect.width();
            } else {
                drawables.mDrawableWidthTop = 0;
                drawables.mDrawableSizeTop = 0;
            }
            if(drawable3 != null) {
                drawable3.setState(ai);
                drawable3.copyBounds(rect);
                drawable3.setCallback(this);
                drawables.mDrawableSizeBottom = rect.height();
                drawables.mDrawableWidthBottom = rect.width();
            } else {
                drawables.mDrawableWidthBottom = 0;
                drawables.mDrawableSizeBottom = 0;
            }
        }
        invalidate();
        requestLayout();
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable1, Drawable drawable2, Drawable drawable3) {
        Drawables drawables = mDrawables;
        boolean flag;
        if(drawable != null || drawable1 != null || drawable2 != null || drawable3 != null)
            flag = true;
        else
            flag = false;
        if(!flag) {
            if(drawables != null)
                if(drawables.mDrawablePadding == 0) {
                    mDrawables = null;
                } else {
                    if(drawables.mDrawableStart != null)
                        drawables.mDrawableStart.setCallback(null);
                    drawables.mDrawableStart = null;
                    if(drawables.mDrawableTop != null)
                        drawables.mDrawableTop.setCallback(null);
                    drawables.mDrawableTop = null;
                    if(drawables.mDrawableEnd != null)
                        drawables.mDrawableEnd.setCallback(null);
                    drawables.mDrawableEnd = null;
                    if(drawables.mDrawableBottom != null)
                        drawables.mDrawableBottom.setCallback(null);
                    drawables.mDrawableBottom = null;
                    drawables.mDrawableHeightStart = 0;
                    drawables.mDrawableSizeStart = 0;
                    drawables.mDrawableHeightEnd = 0;
                    drawables.mDrawableSizeEnd = 0;
                    drawables.mDrawableWidthTop = 0;
                    drawables.mDrawableSizeTop = 0;
                    drawables.mDrawableWidthBottom = 0;
                    drawables.mDrawableSizeBottom = 0;
                }
        } else {
            if(drawables == null) {
                drawables = new Drawables();
                mDrawables = drawables;
            }
            if(drawables.mDrawableStart != drawable && drawables.mDrawableStart != null)
                drawables.mDrawableStart.setCallback(null);
            drawables.mDrawableStart = drawable;
            if(drawables.mDrawableTop != drawable1 && drawables.mDrawableTop != null)
                drawables.mDrawableTop.setCallback(null);
            drawables.mDrawableTop = drawable1;
            if(drawables.mDrawableEnd != drawable2 && drawables.mDrawableEnd != null)
                drawables.mDrawableEnd.setCallback(null);
            drawables.mDrawableEnd = drawable2;
            if(drawables.mDrawableBottom != drawable3 && drawables.mDrawableBottom != null)
                drawables.mDrawableBottom.setCallback(null);
            drawables.mDrawableBottom = drawable3;
            Rect rect = drawables.mCompoundRect;
            int ai[] = getDrawableState();
            if(drawable != null) {
                drawable.setState(ai);
                drawable.copyBounds(rect);
                drawable.setCallback(this);
                drawables.mDrawableSizeStart = rect.width();
                drawables.mDrawableHeightStart = rect.height();
            } else {
                drawables.mDrawableHeightStart = 0;
                drawables.mDrawableSizeStart = 0;
            }
            if(drawable2 != null) {
                drawable2.setState(ai);
                drawable2.copyBounds(rect);
                drawable2.setCallback(this);
                drawables.mDrawableSizeEnd = rect.width();
                drawables.mDrawableHeightEnd = rect.height();
            } else {
                drawables.mDrawableHeightEnd = 0;
                drawables.mDrawableSizeEnd = 0;
            }
            if(drawable1 != null) {
                drawable1.setState(ai);
                drawable1.copyBounds(rect);
                drawable1.setCallback(this);
                drawables.mDrawableSizeTop = rect.height();
                drawables.mDrawableWidthTop = rect.width();
            } else {
                drawables.mDrawableWidthTop = 0;
                drawables.mDrawableSizeTop = 0;
            }
            if(drawable3 != null) {
                drawable3.setState(ai);
                drawable3.copyBounds(rect);
                drawable3.setCallback(this);
                drawables.mDrawableSizeBottom = rect.height();
                drawables.mDrawableWidthBottom = rect.width();
            } else {
                drawables.mDrawableWidthBottom = 0;
                drawables.mDrawableSizeBottom = 0;
            }
        }
        resolveDrawables();
        invalidate();
        requestLayout();
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int j, int k, int l) {
        Drawable drawable = null;
        resetResolvedDrawables();
        Resources resources = getContext().getResources();
        Drawable drawable1;
        Drawable drawable2;
        Drawable drawable3;
        if(i != 0)
            drawable1 = resources.getDrawable(i);
        else
            drawable1 = null;
        if(j != 0)
            drawable2 = resources.getDrawable(j);
        else
            drawable2 = null;
        if(k != 0)
            drawable3 = resources.getDrawable(k);
        else
            drawable3 = null;
        if(l != 0)
            drawable = resources.getDrawable(l);
        setCompoundDrawablesRelativeWithIntrinsicBounds(drawable1, drawable2, drawable3, drawable);
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable1, Drawable drawable2, Drawable drawable3) {
        resetResolvedDrawables();
        if(drawable != null)
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        if(drawable2 != null)
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
        if(drawable1 != null)
            drawable1.setBounds(0, 0, drawable1.getIntrinsicWidth(), drawable1.getIntrinsicHeight());
        if(drawable3 != null)
            drawable3.setBounds(0, 0, drawable3.getIntrinsicWidth(), drawable3.getIntrinsicHeight());
        setCompoundDrawablesRelative(drawable, drawable1, drawable2, drawable3);
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int i, int j, int k, int l) {
        Drawable drawable = null;
        Resources resources = getContext().getResources();
        Drawable drawable1;
        Drawable drawable2;
        Drawable drawable3;
        if(i != 0)
            drawable1 = resources.getDrawable(i);
        else
            drawable1 = null;
        if(j != 0)
            drawable2 = resources.getDrawable(j);
        else
            drawable2 = null;
        if(k != 0)
            drawable3 = resources.getDrawable(k);
        else
            drawable3 = null;
        if(l != 0)
            drawable = resources.getDrawable(l);
        setCompoundDrawablesWithIntrinsicBounds(drawable1, drawable2, drawable3, drawable);
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable1, Drawable drawable2, Drawable drawable3) {
        if(drawable != null)
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        if(drawable2 != null)
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
        if(drawable1 != null)
            drawable1.setBounds(0, 0, drawable1.getIntrinsicWidth(), drawable1.getIntrinsicHeight());
        if(drawable3 != null)
            drawable3.setBounds(0, 0, drawable3.getIntrinsicWidth(), drawable3.getIntrinsicHeight());
        setCompoundDrawables(drawable, drawable1, drawable2, drawable3);
    }

    public void setCursorDrawableRes(int i) {
        mCursorDrawableRes = i;
        for(int j = 0; j < mEditor.mCursorCount; j++)
            mEditor.mCursorDrawable[j] = null;

        mEditor.mCursorCount = 0;
    }

    protected void setCursorPosition_internal(int i, int j) {
        Selection.setSelection((Editable)mText, i, j);
    }

    public void setCursorVisible(boolean flag) {
        if(!flag || mEditor != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        createEditorIfNeeded();
        if(mEditor.mCursorVisible != flag) {
            mEditor.mCursorVisible = flag;
            invalidate();
            mEditor.makeBlink();
            mEditor.prepareCursorControllers();
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void setCustomSelectionActionModeCallback(android.view.ActionMode.Callback callback) {
        createEditorIfNeeded();
        mEditor.mCustomSelectionActionModeCallback = callback;
    }

    public final void setEditableFactory(android.text.Editable.Factory factory) {
        mEditableFactory = factory;
        setText(mText);
    }

    public void setEllipsize(android.text.TextUtils.TruncateAt truncateat) {
        if(mEllipsize != truncateat) {
            mEllipsize = truncateat;
            if(mLayout != null) {
                nullLayouts();
                requestLayout();
                invalidate();
            }
        }
    }

    public void setEms(int i) {
        mMinWidth = i;
        mMaxWidth = i;
        mMinWidthMode = 1;
        mMaxWidthMode = 1;
        requestLayout();
        invalidate();
    }

    public void setEnabled(boolean flag) {
        if(flag != isEnabled()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if(!flag) {
            InputMethodManager inputmethodmanager1 = InputMethodManager.peekInstance();
            if(inputmethodmanager1 != null && inputmethodmanager1.isActive(this))
                inputmethodmanager1.hideSoftInputFromWindow(getWindowToken(), 0);
        }
        setEnabled(flag);
        if(flag) {
            InputMethodManager inputmethodmanager = InputMethodManager.peekInstance();
            if(inputmethodmanager != null)
                inputmethodmanager.restartInput(this);
        }
        if(mEditor != null) {
            mEditor.invalidateTextDisplayList();
            mEditor.prepareCursorControllers();
            mEditor.makeBlink();
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void setError(CharSequence charsequence) {
        if(charsequence == null) {
            setError(null, null);
        } else {
            Drawable drawable = getContext().getResources().getDrawable(0x1080374);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            setError(charsequence, drawable);
        }
    }

    public void setError(CharSequence charsequence, Drawable drawable) {
        createEditorIfNeeded();
        mEditor.setError(charsequence, drawable);
    }

    public void setExtractedText(ExtractedText extractedtext) {
        Editable editable = getEditableText();
        Spannable spannable;
        int i;
        int j;
        int k;
        if(extractedtext.text != null)
            if(editable == null)
                setText(extractedtext.text, BufferType.EDITABLE);
            else
            if(extractedtext.partialStartOffset < 0) {
                removeParcelableSpans(editable, 0, editable.length());
                editable.replace(0, editable.length(), extractedtext.text);
            } else {
                int l = editable.length();
                int i1 = extractedtext.partialStartOffset;
                if(i1 > l)
                    i1 = l;
                int j1 = extractedtext.partialEndOffset;
                if(j1 > l)
                    j1 = l;
                removeParcelableSpans(editable, i1, j1);
                editable.replace(i1, j1, extractedtext.text);
            }
        spannable = (Spannable)getText();
        i = spannable.length();
        j = extractedtext.selectionStart;
        if(j < 0)
            j = 0;
        else
        if(j > i)
            j = i;
        k = extractedtext.selectionEnd;
        if(k < 0)
            k = 0;
        else
        if(k > i)
            k = i;
        Selection.setSelection(spannable, j, k);
        if((2 & extractedtext.flags) != 0)
            MetaKeyKeyListener.startSelecting(this, spannable);
        else
            MetaKeyKeyListener.stopSelecting(this, spannable);
    }

    public void setExtracting(ExtractedTextRequest extractedtextrequest) {
        if(mEditor.mInputMethodState != null)
            mEditor.mInputMethodState.mExtractedTextRequest = extractedtextrequest;
        mEditor.hideControllers();
    }

    public void setFilters(InputFilter ainputfilter[]) {
        if(ainputfilter == null)
            throw new IllegalArgumentException();
        mFilters = ainputfilter;
        if(mText instanceof Editable)
            setFilters((Editable)mText, ainputfilter);
    }

    protected boolean setFrame(int i, int j, int k, int l) {
        boolean flag = setFrame(i, j, k, l);
        if(mEditor != null)
            mEditor.setFrame();
        restartMarqueeIfNeeded();
        return flag;
    }

    public void setFreezesText(boolean flag) {
        mFreezesText = flag;
    }

    public void setGravity(int i) {
        if((i & 0x800007) == 0)
            i |= 0x800003;
        if((i & 0x70) == 0)
            i |= 0x30;
        boolean flag = false;
        if((i & 0x800007) != (0x800007 & mGravity))
            flag = true;
        if(i != mGravity) {
            invalidate();
            mLayoutAlignment = null;
        }
        mGravity = i;
        if(mLayout != null && flag) {
            int j = mLayout.getWidth();
            int k;
            if(mHintLayout == null)
                k = 0;
            else
                k = mHintLayout.getWidth();
            makeNewLayout(j, k, UNKNOWN_BORING, UNKNOWN_BORING, super.mRight - super.mLeft - getCompoundPaddingLeft() - getCompoundPaddingRight(), true);
        }
    }

    public void setHeight(int i) {
        mMinimum = i;
        mMaximum = i;
        mMinMode = 2;
        mMaxMode = 2;
        requestLayout();
        invalidate();
    }

    public void setHighlightColor(int i) {
        if(mHighlightColor != i) {
            mHighlightColor = i;
            invalidate();
        }
    }

    public final void setHint(int i) {
        setHint(getContext().getResources().getText(i));
    }

    public final void setHint(CharSequence charsequence) {
        mHint = TextUtils.stringOrSpannedString(charsequence);
        if(mLayout != null)
            checkForRelayout();
        if(mText.length() == 0)
            invalidate();
        if(mEditor != null && mText.length() == 0 && mHint != null)
            mEditor.invalidateTextDisplayList();
    }

    public final void setHintTextColor(int i) {
        mHintTextColor = ColorStateList.valueOf(i);
        updateTextColors();
    }

    public final void setHintTextColor(ColorStateList colorstatelist) {
        mHintTextColor = colorstatelist;
        updateTextColors();
    }

    public void setHorizontallyScrolling(boolean flag) {
        if(mHorizontallyScrolling != flag) {
            mHorizontallyScrolling = flag;
            if(mLayout != null) {
                nullLayouts();
                requestLayout();
                invalidate();
            }
        }
    }

    public void setImeActionLabel(CharSequence charsequence, int i) {
        createEditorIfNeeded();
        mEditor.createInputContentTypeIfNeeded();
        mEditor.mInputContentType.imeActionLabel = charsequence;
        mEditor.mInputContentType.imeActionId = i;
    }

    public void setImeOptions(int i) {
        createEditorIfNeeded();
        mEditor.createInputContentTypeIfNeeded();
        mEditor.mInputContentType.imeOptions = i;
    }

    public void setIncludeFontPadding(boolean flag) {
        if(mIncludePad != flag) {
            mIncludePad = flag;
            if(mLayout != null) {
                nullLayouts();
                requestLayout();
                invalidate();
            }
        }
    }

    public void setInputExtras(int i) throws XmlPullParserException, IOException {
        createEditorIfNeeded();
        android.content.res.XmlResourceParser xmlresourceparser = getResources().getXml(i);
        mEditor.createInputContentTypeIfNeeded();
        mEditor.mInputContentType.extras = new Bundle();
        getResources().parseBundleExtras(xmlresourceparser, mEditor.mInputContentType.extras);
    }

    public void setInputType(int i) {
        boolean flag = false;
        boolean flag1 = isPasswordInputType(getInputType());
        boolean flag2 = isVisiblePasswordInputType(getInputType());
        setInputType(i, false);
        boolean flag3 = isPasswordInputType(i);
        boolean flag4 = isVisiblePasswordInputType(i);
        boolean flag5 = false;
        boolean flag6;
        InputMethodManager inputmethodmanager;
        if(flag3) {
            setTransformationMethod(PasswordTransformationMethod.getInstance());
            setTypefaceFromAttrs(null, 3, 0);
        } else
        if(flag4) {
            if(mTransformation == PasswordTransformationMethod.getInstance())
                flag5 = true;
            setTypefaceFromAttrs(null, 3, 0);
        } else
        if(flag1 || flag2) {
            setTypefaceFromAttrs(null, -1, -1);
            if(mTransformation == PasswordTransformationMethod.getInstance())
                flag5 = true;
        }
        if(!isMultilineInputType(i))
            flag6 = true;
        else
            flag6 = false;
        if(mSingleLine != flag6 || flag5) {
            if(!flag3)
                flag = true;
            applySingleLine(flag6, flag, true);
        }
        if(!isSuggestionsEnabled())
            mText = removeSuggestionSpans(mText);
        inputmethodmanager = InputMethodManager.peekInstance();
        if(inputmethodmanager != null)
            inputmethodmanager.restartInput(this);
    }

    public void setKeyListener(KeyListener keylistener) {
        setKeyListenerOnly(keylistener);
        fixFocusableAndClickableSettings();
        if(keylistener == null) goto _L2; else goto _L1
_L1:
        createEditorIfNeeded();
        InputMethodManager inputmethodmanager;
        try {
            mEditor.mInputType = mEditor.mKeyListener.getInputType();
        }
        catch(IncompatibleClassChangeError incompatibleclasschangeerror) {
            mEditor.mInputType = 1;
        }
        setInputTypeSingleLine(mSingleLine);
_L4:
        inputmethodmanager = InputMethodManager.peekInstance();
        if(inputmethodmanager != null)
            inputmethodmanager.restartInput(this);
        return;
_L2:
        if(mEditor != null)
            mEditor.mInputType = 0;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void setLineSpacing(float f, float f1) {
        if(mSpacingAdd != f || mSpacingMult != f1) {
            mSpacingAdd = f;
            mSpacingMult = f1;
            if(mLayout != null) {
                nullLayouts();
                requestLayout();
                invalidate();
            }
        }
    }

    public void setLines(int i) {
        mMinimum = i;
        mMaximum = i;
        mMinMode = 1;
        mMaxMode = 1;
        requestLayout();
        invalidate();
    }

    public final void setLinkTextColor(int i) {
        mLinkTextColor = ColorStateList.valueOf(i);
        updateTextColors();
    }

    public final void setLinkTextColor(ColorStateList colorstatelist) {
        mLinkTextColor = colorstatelist;
        updateTextColors();
    }

    public final void setLinksClickable(boolean flag) {
        mLinksClickable = flag;
    }

    public void setMarqueeRepeatLimit(int i) {
        mMarqueeRepeatLimit = i;
    }

    public void setMaxEms(int i) {
        mMaxWidth = i;
        mMaxWidthMode = 1;
        requestLayout();
        invalidate();
    }

    public void setMaxHeight(int i) {
        mMaximum = i;
        mMaxMode = 2;
        requestLayout();
        invalidate();
    }

    public void setMaxLines(int i) {
        mMaximum = i;
        mMaxMode = 1;
        requestLayout();
        invalidate();
    }

    public void setMaxWidth(int i) {
        mMaxWidth = i;
        mMaxWidthMode = 2;
        requestLayout();
        invalidate();
    }

    public void setMinEms(int i) {
        mMinWidth = i;
        mMinWidthMode = 1;
        requestLayout();
        invalidate();
    }

    public void setMinHeight(int i) {
        mMinimum = i;
        mMinMode = 2;
        requestLayout();
        invalidate();
    }

    public void setMinLines(int i) {
        mMinimum = i;
        mMinMode = 1;
        requestLayout();
        invalidate();
    }

    public void setMinWidth(int i) {
        mMinWidth = i;
        mMinWidthMode = 2;
        requestLayout();
        invalidate();
    }

    public final void setMovementMethod(MovementMethod movementmethod) {
        if(mMovement != movementmethod) {
            mMovement = movementmethod;
            if(movementmethod != null && !(mText instanceof Spannable))
                setText(mText);
            fixFocusableAndClickableSettings();
            if(mEditor != null)
                mEditor.prepareCursorControllers();
        }
    }

    public void setOnEditorActionListener(OnEditorActionListener oneditoractionlistener) {
        createEditorIfNeeded();
        mEditor.createInputContentTypeIfNeeded();
        mEditor.mInputContentType.onEditorActionListener = oneditoractionlistener;
    }

    public void setPadding(int i, int j, int k, int l) {
        if(i != super.mPaddingLeft || k != super.mPaddingRight || j != super.mPaddingTop || l != super.mPaddingBottom)
            nullLayouts();
        setPadding(i, j, k, l);
        invalidate();
    }

    public void setPaddingRelative(int i, int j, int k, int l) {
        if(i != getPaddingStart() || k != getPaddingEnd() || j != super.mPaddingTop || l != super.mPaddingBottom)
            nullLayouts();
        setPaddingRelative(i, j, k, l);
        invalidate();
    }

    public void setPaintFlags(int i) {
        if(mTextPaint.getFlags() != i) {
            mTextPaint.setFlags(i);
            if(mLayout != null) {
                nullLayouts();
                requestLayout();
                invalidate();
            }
        }
    }

    public void setPrivateImeOptions(String s) {
        createEditorIfNeeded();
        mEditor.createInputContentTypeIfNeeded();
        mEditor.mInputContentType.privateImeOptions = s;
    }

    public void setRawInputType(int i) {
        if(i != 0 || mEditor != null) {
            createEditorIfNeeded();
            mEditor.mInputType = i;
        }
    }

    public void setScroller(Scroller scroller) {
        mScroller = scroller;
    }

    public void setSelectAllOnFocus(boolean flag) {
        createEditorIfNeeded();
        mEditor.mSelectAllOnFocus = flag;
        if(flag && !(mText instanceof Spannable))
            setText(mText, BufferType.SPANNABLE);
    }

    public void setSelected(boolean flag) {
        boolean flag1 = isSelected();
        setSelected(flag);
        if(flag != flag1 && mEllipsize == android.text.TextUtils.TruncateAt.MARQUEE)
            if(flag)
                startMarquee();
            else
                stopMarquee();
    }

    public void setShadowLayer(float f, float f1, float f2, int i) {
        mTextPaint.setShadowLayer(f, f1, f2, i);
        mShadowRadius = f;
        mShadowDx = f1;
        mShadowDy = f2;
        if(mEditor != null)
            mEditor.invalidateTextDisplayList();
        invalidate();
    }

    public final void setShowSoftInputOnFocus(boolean flag) {
        createEditorIfNeeded();
        mEditor.mShowSoftInputOnFocus = flag;
    }

    public void setSingleLine() {
        setSingleLine(true);
    }

    public void setSingleLine(boolean flag) {
        setInputTypeSingleLine(flag);
        applySingleLine(flag, true, true);
    }

    public final void setSoftInputShownOnFocus(boolean flag) {
        setShowSoftInputOnFocus(flag);
    }

    protected void setSpan_internal(Object obj, int i, int j, int k) {
        ((Editable)mText).setSpan(obj, i, j, k);
    }

    public final void setSpannableFactory(android.text.Spannable.Factory factory) {
        mSpannableFactory = factory;
        setText(mText);
    }

    public final void setText(int i) {
        setText(getContext().getResources().getText(i));
    }

    public final void setText(int i, BufferType buffertype) {
        setText(getContext().getResources().getText(i), buffertype);
    }

    public final void setText(CharSequence charsequence) {
        setText(charsequence, mBufferType);
    }

    public void setText(CharSequence charsequence, BufferType buffertype) {
        setText(charsequence, buffertype, true, 0);
        if(mCharWrapper != null)
            mCharWrapper.mChars = null;
    }

    public final void setText(char ac[], int i, int j) {
        int k = 0;
        if(i < 0 || j < 0 || i + j > ac.length)
            throw new IndexOutOfBoundsException((new StringBuilder()).append(i).append(", ").append(j).toString());
        if(mText != null) {
            k = mText.length();
            sendBeforeTextChanged(mText, 0, k, j);
        } else {
            sendBeforeTextChanged("", 0, 0, j);
        }
        if(mCharWrapper == null)
            mCharWrapper = new CharWrapper(ac, i, j);
        else
            mCharWrapper.set(ac, i, j);
        setText(((CharSequence) (mCharWrapper)), mBufferType, false, k);
    }

    public void setTextAppearance(Context context, int i) {
        TypedArray typedarray = context.obtainStyledAttributes(i, com.android.internal.R.styleable.TextAppearance);
        int j = typedarray.getColor(4, 0);
        if(j != 0)
            setHighlightColor(j);
        ColorStateList colorstatelist = typedarray.getColorStateList(3);
        if(colorstatelist != null)
            setTextColor(colorstatelist);
        int k = typedarray.getDimensionPixelSize(0, 0);
        if(k != 0)
            setRawTextSize(k);
        ColorStateList colorstatelist1 = typedarray.getColorStateList(5);
        if(colorstatelist1 != null)
            setHintTextColor(colorstatelist1);
        ColorStateList colorstatelist2 = typedarray.getColorStateList(6);
        if(colorstatelist2 != null)
            setLinkTextColor(colorstatelist2);
        setTypefaceFromAttrs(typedarray.getString(8), typedarray.getInt(1, -1), typedarray.getInt(2, -1));
        if(typedarray.getBoolean(7, false))
            setTransformationMethod(new AllCapsTransformationMethod(getContext()));
        typedarray.recycle();
    }

    public void setTextColor(int i) {
        mTextColor = ColorStateList.valueOf(i);
        updateTextColors();
    }

    public void setTextColor(ColorStateList colorstatelist) {
        if(colorstatelist == null) {
            throw new NullPointerException();
        } else {
            mTextColor = colorstatelist;
            updateTextColors();
            return;
        }
    }

    public void setTextIsSelectable(boolean flag) {
        if(flag || mEditor != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        createEditorIfNeeded();
        if(mEditor.mTextIsSelectable != flag) {
            mEditor.mTextIsSelectable = flag;
            setFocusableInTouchMode(flag);
            setFocusable(flag);
            setClickable(flag);
            setLongClickable(flag);
            MovementMethod movementmethod;
            CharSequence charsequence;
            BufferType buffertype;
            if(flag)
                movementmethod = ArrowKeyMovementMethod.getInstance();
            else
                movementmethod = null;
            setMovementMethod(movementmethod);
            charsequence = mText;
            if(flag)
                buffertype = BufferType.SPANNABLE;
            else
                buffertype = BufferType.NORMAL;
            setText(charsequence, buffertype);
            mEditor.prepareCursorControllers();
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public final void setTextKeepState(CharSequence charsequence) {
        setTextKeepState(charsequence, mBufferType);
    }

    public final void setTextKeepState(CharSequence charsequence, BufferType buffertype) {
        int i = getSelectionStart();
        int j = getSelectionEnd();
        int k = charsequence.length();
        setText(charsequence, buffertype);
        if((i >= 0 || j >= 0) && (mText instanceof Spannable))
            Selection.setSelection((Spannable)mText, Math.max(0, Math.min(i, k)), Math.max(0, Math.min(j, k)));
    }

    public void setTextScaleX(float f) {
        if(f != mTextPaint.getTextScaleX()) {
            mUserSetTextScaleX = true;
            mTextPaint.setTextScaleX(f);
            if(mLayout != null) {
                nullLayouts();
                requestLayout();
                invalidate();
            }
        }
    }

    public void setTextSize(float f) {
        setTextSize(2, f);
    }

    public void setTextSize(int i, float f) {
        Context context = getContext();
        Resources resources;
        if(context == null)
            resources = Resources.getSystem();
        else
            resources = context.getResources();
        setRawTextSize(TypedValue.applyDimension(i, f, resources.getDisplayMetrics()));
    }

    public final void setTransformationMethod(TransformationMethod transformationmethod) {
        if(transformationmethod != mTransformation) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if(mTransformation != null && (mText instanceof Spannable))
            ((Spannable)mText).removeSpan(mTransformation);
        mTransformation = transformationmethod;
        if(transformationmethod instanceof TransformationMethod2) {
            TransformationMethod2 transformationmethod2 = (TransformationMethod2)transformationmethod;
            boolean flag;
            if(!isTextSelectable() && !(mText instanceof Editable))
                flag = true;
            else
                flag = false;
            mAllowTransformationLengthChange = flag;
            transformationmethod2.setLengthChangesAllowed(mAllowTransformationLengthChange);
        } else {
            mAllowTransformationLengthChange = false;
        }
        setText(mText);
        if(hasPasswordTransformationMethod())
            notifyAccessibilityStateChanged();
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void setTypeface(Typeface typeface) {
        if(mTextPaint.getTypeface() != typeface) {
            mTextPaint.setTypeface(typeface);
            if(mLayout != null) {
                nullLayouts();
                requestLayout();
                invalidate();
            }
        }
    }

    public void setTypeface(Typeface typeface, int i) {
        boolean flag = false;
        if(i > 0) {
            Typeface typeface1;
            int j;
            int k;
            TextPaint textpaint;
            TextPaint textpaint1;
            float f;
            if(typeface == null)
                typeface1 = Typeface.defaultFromStyle(i);
            else
                typeface1 = Typeface.create(typeface, i);
            setTypeface(typeface1);
            if(typeface1 != null)
                j = typeface1.getStyle();
            else
                j = 0;
            k = i & ~j;
            textpaint = mTextPaint;
            if((k & 1) != 0)
                flag = true;
            textpaint.setFakeBoldText(flag);
            textpaint1 = mTextPaint;
            if((k & 2) != 0)
                f = -0.25F;
            else
                f = 0.0F;
            textpaint1.setTextSkewX(f);
        } else {
            mTextPaint.setFakeBoldText(false);
            mTextPaint.setTextSkewX(0.0F);
            setTypeface(typeface);
        }
    }

    public void setWidth(int i) {
        mMinWidth = i;
        mMaxWidth = i;
        mMinWidthMode = 2;
        mMaxWidthMode = 2;
        requestLayout();
        invalidate();
    }

    void spanChange(Spanned spanned, Object obj, int i, int j, int k, int l) {
        boolean flag = false;
        int i1 = -1;
        int j1 = -1;
        Editor.InputMethodState inputmethodstate;
        if(mEditor == null)
            inputmethodstate = null;
        else
            inputmethodstate = mEditor.mInputMethodState;
        if(obj == Selection.SELECTION_END) {
            flag = true;
            j1 = j;
            if(i >= 0 || j >= 0) {
                invalidateCursor(Selection.getSelectionStart(spanned), i, j);
                registerForPreDraw();
                if(mEditor != null)
                    mEditor.makeBlink();
            }
        }
        if(obj == Selection.SELECTION_START) {
            flag = true;
            i1 = j;
            if(i >= 0 || j >= 0)
                invalidateCursor(Selection.getSelectionEnd(spanned), i, j);
        }
        if(flag) {
            mHighlightPathBogus = true;
            if(mEditor != null && !isFocused())
                mEditor.mSelectionMoved = true;
            if((0x200 & spanned.getSpanFlags(obj)) == 0) {
                if(i1 < 0)
                    i1 = Selection.getSelectionStart(spanned);
                if(j1 < 0)
                    j1 = Selection.getSelectionEnd(spanned);
                onSelectionChanged(i1, j1);
            }
        }
        if((obj instanceof UpdateAppearance) || (obj instanceof ParagraphStyle) || (obj instanceof CharacterStyle)) {
            if(inputmethodstate == null || inputmethodstate.mBatchEditNesting == 0) {
                invalidate();
                mHighlightPathBogus = true;
                checkForResize();
            } else {
                inputmethodstate.mContentChanged = true;
            }
            if(mEditor != null) {
                if(i >= 0)
                    mEditor.invalidateTextDisplayList(mLayout, i, k);
                if(j >= 0)
                    mEditor.invalidateTextDisplayList(mLayout, j, l);
            }
        }
        if(MetaKeyKeyListener.isMetaTracker(spanned, obj)) {
            mHighlightPathBogus = true;
            if(inputmethodstate != null && MetaKeyKeyListener.isSelectingMetaTracker(spanned, obj))
                inputmethodstate.mSelectionModeChanged = true;
            if(Selection.getSelectionStart(spanned) >= 0)
                if(inputmethodstate == null || inputmethodstate.mBatchEditNesting == 0)
                    invalidateCursor();
                else
                    inputmethodstate.mCursorChanged = true;
        }
        if((obj instanceof ParcelableSpan) && inputmethodstate != null && inputmethodstate.mExtractedTextRequest != null)
            if(inputmethodstate.mBatchEditNesting != 0) {
                if(i >= 0) {
                    if(inputmethodstate.mChangedStart > i)
                        inputmethodstate.mChangedStart = i;
                    if(inputmethodstate.mChangedStart > k)
                        inputmethodstate.mChangedStart = k;
                }
                if(j >= 0) {
                    if(inputmethodstate.mChangedStart > j)
                        inputmethodstate.mChangedStart = j;
                    if(inputmethodstate.mChangedStart > l)
                        inputmethodstate.mChangedStart = l;
                }
            } else {
                inputmethodstate.mContentChanged = true;
            }
        if(mEditor != null && mEditor.mSpellChecker != null && j < 0 && (obj instanceof SpellCheckSpan))
            mEditor.mSpellChecker.onSpellCheckSpanRemoved((SpellCheckSpan)obj);
    }

    protected void stopSelectionActionMode() {
        mEditor.stopSelectionActionMode();
    }

    boolean textCanBeSelected() {
        boolean flag;
        flag = false;
        break MISSING_BLOCK_LABEL_2;
        if(mMovement != null && mMovement.canSelectArbitrarily() && (isTextEditable() || isTextSelectable() && (mText instanceof Spannable) && isEnabled()))
            flag = true;
        return flag;
    }

    void updateAfterEdit() {
        invalidate();
        int i = getSelectionStart();
        if(i >= 0 || (0x70 & mGravity) == 80)
            registerForPreDraw();
        if(i >= 0) {
            mHighlightPathBogus = true;
            if(mEditor != null)
                mEditor.makeBlink();
            bringPointIntoView(i);
        }
        checkForResize();
    }

    protected boolean verifyDrawable(Drawable drawable) {
        boolean flag = verifyDrawable(drawable);
        boolean flag1;
        if(!flag && mDrawables != null) {
            if(drawable == mDrawables.mDrawableLeft || drawable == mDrawables.mDrawableTop || drawable == mDrawables.mDrawableRight || drawable == mDrawables.mDrawableBottom || drawable == mDrawables.mDrawableStart || drawable == mDrawables.mDrawableEnd)
                flag1 = true;
            else
                flag1 = false;
        } else {
            flag1 = flag;
        }
        return flag1;
    }

    protected void viewClicked(InputMethodManager inputmethodmanager) {
        if(inputmethodmanager != null)
            inputmethodmanager.viewClicked(this);
    }

    int viewportToContentHorizontalOffset() {
        return getCompoundPaddingLeft() - super.mScrollX;
    }

    int viewportToContentVerticalOffset() {
        int i = getExtendedPaddingTop() - super.mScrollY;
        if((0x70 & mGravity) != 48)
            i += getVerticalOffset(false);
        return i;
    }

    private static final int ANIMATED_SCROLL_GAP = 250;
    private static final int CHANGE_WATCHER_PRIORITY = 100;
    static final boolean DEBUG_EXTRACT = false;
    private static final int DECIMAL = 4;
    private static final Spanned EMPTY_SPANNED = new SpannedString("");
    private static final int EMS = 1;
    static final int ID_COPY = 0x1020021;
    static final int ID_CUT = 0x1020020;
    static final int ID_PASTE = 0x1020022;
    static final int ID_SELECT_ALL = 0x102001f;
    static long LAST_CUT_OR_COPY_TIME = 0L;
    private static final int LINES = 1;
    static final String LOG_TAG = "TextView";
    private static final int MARQUEE_FADE_NORMAL = 0;
    private static final int MARQUEE_FADE_SWITCH_SHOW_ELLIPSIS = 1;
    private static final int MARQUEE_FADE_SWITCH_SHOW_FADE = 2;
    private static final int MONOSPACE = 3;
    private static final int MULTILINE_STATE_SET[];
    private static final InputFilter NO_FILTERS[] = new InputFilter[0];
    private static final int PIXELS = 2;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private static final int SIGNED = 2;
    private static final RectF TEMP_RECTF = new RectF();
    private static final android.text.BoringLayout.Metrics UNKNOWN_BORING = new Metrics();
    private static final int VERY_WIDE = 0x100000;
    private boolean mAllowTransformationLengthChange;
    private int mAutoLinkMask;
    private android.text.BoringLayout.Metrics mBoring;
    private BufferType mBufferType;
    private ChangeWatcher mChangeWatcher;
    private CharWrapper mCharWrapper;
    private int mCurHintTextColor;
    private int mCurTextColor;
    int mCursorDrawableRes;
    private int mDesiredHeightAtMeasure;
    private boolean mDispatchTemporaryDetach;
    Drawables mDrawables;
    private android.text.Editable.Factory mEditableFactory;
    private Editor mEditor;
    private android.text.TextUtils.TruncateAt mEllipsize;
    private InputFilter mFilters[];
    private boolean mFreezesText;
    private int mGravity;
    int mHighlightColor;
    private final Paint mHighlightPaint;
    private Path mHighlightPath;
    private boolean mHighlightPathBogus;
    private CharSequence mHint;
    private android.text.BoringLayout.Metrics mHintBoring;
    private Layout mHintLayout;
    private ColorStateList mHintTextColor;
    private boolean mHorizontallyScrolling;
    private boolean mIncludePad;
    private long mLastScroll;
    private Layout mLayout;
    private android.text.Layout.Alignment mLayoutAlignment;
    private ColorStateList mLinkTextColor;
    private boolean mLinksClickable;
    private ArrayList mListeners;
    private Marquee mMarquee;
    private int mMarqueeFadeMode;
    private int mMarqueeRepeatLimit;
    private int mMaxMode;
    private int mMaxWidth;
    private int mMaxWidthMode;
    private int mMaximum;
    private int mMinMode;
    private int mMinWidth;
    private int mMinWidthMode;
    private int mMinimum;
    private MovementMethod mMovement;
    private int mOldMaxMode;
    private int mOldMaximum;
    private boolean mPreDrawRegistered;
    private boolean mResolvedDrawables;
    private boolean mRestartMarquee;
    private BoringLayout mSavedHintLayout;
    private BoringLayout mSavedLayout;
    private Layout mSavedMarqueeModeLayout;
    private Scroller mScroller;
    private float mShadowDx;
    private float mShadowDy;
    private float mShadowRadius;
    private boolean mSingleLine;
    private float mSpacingAdd;
    private float mSpacingMult;
    private android.text.Spannable.Factory mSpannableFactory;
    private Rect mTempRect;
    private boolean mTemporaryDetach;
    private CharSequence mText;
    private ColorStateList mTextColor;
    private TextDirectionHeuristic mTextDir;
    int mTextEditSuggestionItemLayout;
    private final TextPaint mTextPaint;
    int mTextSelectHandleLeftRes;
    int mTextSelectHandleRes;
    int mTextSelectHandleRightRes;
    private TransformationMethod mTransformation;
    private CharSequence mTransformed;
    private boolean mUserSetTextScaleX;

    static  {
        int ai[] = new int[1];
        ai[0] = 0x101034d;
        MULTILINE_STATE_SET = ai;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.measureText("H");
    }






}
