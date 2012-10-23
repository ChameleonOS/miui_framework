// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

// Referenced classes of package android.widget:
//            AbsSeekBar

public class SeekBar extends AbsSeekBar {
    public static interface OnSeekBarChangeListener {

        public abstract void onProgressChanged(SeekBar seekbar, int i, boolean flag);

        public abstract void onStartTrackingTouch(SeekBar seekbar);

        public abstract void onStopTrackingTouch(SeekBar seekbar);
    }


    public SeekBar(Context context) {
        this(context, null);
    }

    public SeekBar(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0x101007b);
    }

    public SeekBar(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/SeekBar.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/SeekBar.getName());
    }

    void onProgressRefresh(float f, boolean flag) {
        super.onProgressRefresh(f, flag);
        if(mOnSeekBarChangeListener != null)
            mOnSeekBarChangeListener.onProgressChanged(this, getProgress(), flag);
    }

    void onStartTrackingTouch() {
        super.onStartTrackingTouch();
        if(mOnSeekBarChangeListener != null)
            mOnSeekBarChangeListener.onStartTrackingTouch(this);
    }

    void onStopTrackingTouch() {
        super.onStopTrackingTouch();
        if(mOnSeekBarChangeListener != null)
            mOnSeekBarChangeListener.onStopTrackingTouch(this);
    }

    public void setOnSeekBarChangeListener(OnSeekBarChangeListener onseekbarchangelistener) {
        mOnSeekBarChangeListener = onseekbarchangelistener;
    }

    private OnSeekBarChangeListener mOnSeekBarChangeListener;
}
