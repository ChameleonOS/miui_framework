// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.widget;

import android.os.Bundle;
import android.text.Editable;
import android.text.Spanned;
import android.text.method.KeyListener;
import android.text.style.SuggestionSpan;
import android.view.inputmethod.*;
import android.widget.TextView;

public class EditableInputConnection extends BaseInputConnection {

    public EditableInputConnection(TextView textview) {
        super(textview, true);
        mTextView = textview;
    }

    public boolean beginBatchEdit() {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        if(mBatchEditNesting >= 0) {
            mTextView.beginBatchEdit();
            mBatchEditNesting = 1 + mBatchEditNesting;
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public boolean clearMetaKeyStates(int i) {
        Editable editable = getEditable();
        boolean flag;
        if(editable == null) {
            flag = false;
        } else {
            KeyListener keylistener = mTextView.getKeyListener();
            if(keylistener != null)
                try {
                    keylistener.clearMetaKeyState(mTextView, editable, i);
                }
                catch(AbstractMethodError abstractmethoderror) { }
            flag = true;
        }
        return flag;
    }

    public boolean commitCompletion(CompletionInfo completioninfo) {
        mTextView.beginBatchEdit();
        mTextView.onCommitCompletion(completioninfo);
        mTextView.endBatchEdit();
        return true;
    }

    public boolean commitCorrection(CorrectionInfo correctioninfo) {
        mTextView.beginBatchEdit();
        mTextView.onCommitCorrection(correctioninfo);
        mTextView.endBatchEdit();
        return true;
    }

    public boolean commitText(CharSequence charsequence, int i) {
        boolean flag;
        if(mTextView == null) {
            flag = super.commitText(charsequence, i);
        } else {
            if(charsequence instanceof Spanned) {
                SuggestionSpan asuggestionspan[] = (SuggestionSpan[])((Spanned)charsequence).getSpans(0, charsequence.length(), android/text/style/SuggestionSpan);
                super.mIMM.registerSuggestionSpansForNotification(asuggestionspan);
            }
            mTextView.resetErrorChangedFlag();
            flag = super.commitText(charsequence, i);
            mTextView.hideErrorIfUnchanged();
        }
        return flag;
    }

    public boolean endBatchEdit() {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        if(mBatchEditNesting > 0) {
            mTextView.endBatchEdit();
            mBatchEditNesting = -1 + mBatchEditNesting;
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public Editable getEditable() {
        TextView textview = mTextView;
        Editable editable;
        if(textview != null)
            editable = textview.getEditableText();
        else
            editable = null;
        return editable;
    }

    public ExtractedText getExtractedText(ExtractedTextRequest extractedtextrequest, int i) {
        if(mTextView == null) goto _L2; else goto _L1
_L1:
        ExtractedText extractedtext = new ExtractedText();
        if(!mTextView.extractText(extractedtextrequest, extractedtext)) goto _L2; else goto _L3
_L3:
        if((i & 1) != 0)
            mTextView.setExtracting(extractedtextrequest);
_L5:
        return extractedtext;
_L2:
        extractedtext = null;
        if(true) goto _L5; else goto _L4
_L4:
    }

    public boolean performContextMenuAction(int i) {
        mTextView.beginBatchEdit();
        mTextView.onTextContextMenuItem(i);
        mTextView.endBatchEdit();
        return true;
    }

    public boolean performEditorAction(int i) {
        mTextView.onEditorAction(i);
        return true;
    }

    public boolean performPrivateCommand(String s, Bundle bundle) {
        mTextView.onPrivateIMECommand(s, bundle);
        return true;
    }

    protected void reportFinish() {
        super.reportFinish();
        this;
        JVM INSTR monitorenter ;
        while(mBatchEditNesting > 0) 
            endBatchEdit();
        break MISSING_BLOCK_LABEL_26;
        Exception exception;
        exception;
        throw exception;
        mBatchEditNesting = -1;
        this;
        JVM INSTR monitorexit ;
    }

    private static final boolean DEBUG = false;
    private static final String TAG = "EditableInputConnection";
    private int mBatchEditNesting;
    private final TextView mTextView;
}
