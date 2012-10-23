// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.*;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.*;

// Referenced classes of package android.widget:
//            TextView

public class Chronometer extends TextView {
    public static interface OnChronometerTickListener {

        public abstract void onChronometerTick(Chronometer chronometer);
    }


    public Chronometer(Context context) {
        this(context, null, 0);
    }

    public Chronometer(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0);
    }

    public Chronometer(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
        mFormatterArgs = new Object[1];
        mRecycle = new StringBuilder(8);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.android.internal.R.styleable.Chronometer, i, 0);
        setFormat(typedarray.getString(0));
        typedarray.recycle();
        init();
    }

    private void init() {
        mBase = SystemClock.elapsedRealtime();
        updateText(mBase);
    }

    private void updateRunning() {
        boolean flag;
        if(mVisible && mStarted)
            flag = true;
        else
            flag = false;
        if(flag != mRunning) {
            if(flag) {
                updateText(SystemClock.elapsedRealtime());
                dispatchChronometerTick();
                mHandler.sendMessageDelayed(Message.obtain(mHandler, 2), 1000L);
            } else {
                mHandler.removeMessages(2);
            }
            mRunning = flag;
        }
    }

    /**
     * @deprecated Method updateText is deprecated
     */

    private void updateText(long l) {
        this;
        JVM INSTR monitorenter ;
        String s;
        long l1 = (l - mBase) / 1000L;
        s = DateUtils.formatElapsedTime(mRecycle, l1);
        if(mFormat == null)
            break MISSING_BLOCK_LABEL_124;
        Locale locale = Locale.getDefault();
        if(mFormatter == null || !locale.equals(mFormatterLocale)) {
            mFormatterLocale = locale;
            mFormatter = new Formatter(mFormatBuilder, locale);
        }
        mFormatBuilder.setLength(0);
        mFormatterArgs[0] = s;
        String s1;
        mFormatter.format(mFormat, mFormatterArgs);
        s1 = mFormatBuilder.toString();
        s = s1;
_L2:
        setText(s);
        this;
        JVM INSTR monitorexit ;
        return;
        IllegalFormatException illegalformatexception;
        illegalformatexception;
        if(!mLogged) {
            Log.w("Chronometer", (new StringBuilder()).append("Illegal format string: ").append(mFormat).toString());
            mLogged = true;
        }
        if(true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    void dispatchChronometerTick() {
        if(mOnChronometerTickListener != null)
            mOnChronometerTickListener.onChronometerTick(this);
    }

    public long getBase() {
        return mBase;
    }

    public String getFormat() {
        return mFormat;
    }

    public OnChronometerTickListener getOnChronometerTickListener() {
        return mOnChronometerTickListener;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mVisible = false;
        updateRunning();
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/Chronometer.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/Chronometer.getName());
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        boolean flag;
        if(i == 0)
            flag = true;
        else
            flag = false;
        mVisible = flag;
        updateRunning();
    }

    public void setBase(long l) {
        mBase = l;
        dispatchChronometerTick();
        updateText(SystemClock.elapsedRealtime());
    }

    public void setFormat(String s) {
        mFormat = s;
        if(s != null && mFormatBuilder == null)
            mFormatBuilder = new StringBuilder(2 * s.length());
    }

    public void setOnChronometerTickListener(OnChronometerTickListener onchronometerticklistener) {
        mOnChronometerTickListener = onchronometerticklistener;
    }

    public void setStarted(boolean flag) {
        mStarted = flag;
        updateRunning();
    }

    public void start() {
        mStarted = true;
        updateRunning();
    }

    public void stop() {
        mStarted = false;
        updateRunning();
    }

    private static final String TAG = "Chronometer";
    private static final int TICK_WHAT = 2;
    private long mBase;
    private String mFormat;
    private StringBuilder mFormatBuilder;
    private Formatter mFormatter;
    private Object mFormatterArgs[];
    private Locale mFormatterLocale;
    private Handler mHandler = new Handler() {

        public void handleMessage(Message message) {
            if(mRunning) {
                updateText(SystemClock.elapsedRealtime());
                dispatchChronometerTick();
                sendMessageDelayed(Message.obtain(this, 2), 1000L);
            }
        }

        final Chronometer this$0;

             {
                this$0 = Chronometer.this;
                super();
            }
    };
    private boolean mLogged;
    private OnChronometerTickListener mOnChronometerTickListener;
    private StringBuilder mRecycle;
    private boolean mRunning;
    private boolean mStarted;
    private boolean mVisible;


}
