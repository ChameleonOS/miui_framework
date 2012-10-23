// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.inputmethodservice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

// Referenced classes of package android.inputmethodservice:
//            InputMethodService

public class ExtractEditText extends EditText {

    public ExtractEditText(Context context) {
        super(context, null);
    }

    public ExtractEditText(Context context, AttributeSet attributeset) {
        super(context, attributeset, 0x101006e);
    }

    public ExtractEditText(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
    }

    protected void deleteText_internal(int i, int j) {
        mIME.onExtractedDeleteText(i, j);
    }

    public void finishInternalChanges() {
        mSettingExtractedText = -1 + mSettingExtractedText;
    }

    public boolean hasFocus() {
        return isEnabled();
    }

    public boolean hasVerticalScrollBar() {
        boolean flag;
        if(computeVerticalScrollRange() > computeVerticalScrollExtent())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean hasWindowFocus() {
        return isEnabled();
    }

    public boolean isFocused() {
        return isEnabled();
    }

    public boolean isInputMethodTarget() {
        return true;
    }

    protected void onSelectionChanged(int i, int j) {
        if(mSettingExtractedText == 0 && mIME != null && i >= 0 && j >= 0)
            mIME.onExtractedSelectionChanged(i, j);
    }

    public boolean onTextContextMenuItem(int i) {
        boolean flag;
        if(mIME != null && mIME.onExtractTextContextMenuItem(i)) {
            if(i == 0x1020021)
                stopSelectionActionMode();
            flag = true;
        } else {
            flag = super.onTextContextMenuItem(i);
        }
        return flag;
    }

    public boolean performClick() {
        boolean flag;
        if(!super.performClick() && mIME != null) {
            mIME.onExtractedTextClicked();
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    protected void replaceText_internal(int i, int j, CharSequence charsequence) {
        mIME.onExtractedReplaceText(i, j, charsequence);
    }

    protected void setCursorPosition_internal(int i, int j) {
        mIME.onExtractedSelectionChanged(i, j);
    }

    public void setExtractedText(ExtractedText extractedtext) {
        mSettingExtractedText = 1 + mSettingExtractedText;
        super.setExtractedText(extractedtext);
        mSettingExtractedText = -1 + mSettingExtractedText;
        return;
        Exception exception;
        exception;
        mSettingExtractedText = -1 + mSettingExtractedText;
        throw exception;
    }

    void setIME(InputMethodService inputmethodservice) {
        mIME = inputmethodservice;
    }

    protected void setSpan_internal(Object obj, int i, int j, int k) {
        mIME.onExtractedSetSpan(obj, i, j, k);
    }

    public void startInternalChanges() {
        mSettingExtractedText = 1 + mSettingExtractedText;
    }

    protected void viewClicked(InputMethodManager inputmethodmanager) {
        if(mIME != null)
            mIME.onViewClicked(false);
    }

    private InputMethodService mIME;
    private int mSettingExtractedText;
}
