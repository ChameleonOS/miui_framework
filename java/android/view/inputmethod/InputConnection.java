// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view.inputmethod;

import android.os.Bundle;
import android.view.KeyEvent;

// Referenced classes of package android.view.inputmethod:
//            CompletionInfo, CorrectionInfo, ExtractedTextRequest, ExtractedText

public interface InputConnection {

    public abstract boolean beginBatchEdit();

    public abstract boolean clearMetaKeyStates(int i);

    public abstract boolean commitCompletion(CompletionInfo completioninfo);

    public abstract boolean commitCorrection(CorrectionInfo correctioninfo);

    public abstract boolean commitText(CharSequence charsequence, int i);

    public abstract boolean deleteSurroundingText(int i, int j);

    public abstract boolean endBatchEdit();

    public abstract boolean finishComposingText();

    public abstract int getCursorCapsMode(int i);

    public abstract ExtractedText getExtractedText(ExtractedTextRequest extractedtextrequest, int i);

    public abstract CharSequence getSelectedText(int i);

    public abstract CharSequence getTextAfterCursor(int i, int j);

    public abstract CharSequence getTextBeforeCursor(int i, int j);

    public abstract boolean performContextMenuAction(int i);

    public abstract boolean performEditorAction(int i);

    public abstract boolean performPrivateCommand(String s, Bundle bundle);

    public abstract boolean reportFullscreenMode(boolean flag);

    public abstract boolean sendKeyEvent(KeyEvent keyevent);

    public abstract boolean setComposingRegion(int i, int j);

    public abstract boolean setComposingText(CharSequence charsequence, int i);

    public abstract boolean setSelection(int i, int j);

    public static final int GET_EXTRACTED_TEXT_MONITOR = 1;
    public static final int GET_TEXT_WITH_STYLES = 1;
}
