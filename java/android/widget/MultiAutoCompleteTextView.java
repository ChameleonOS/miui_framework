// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.content.Context;
import android.text.*;
import android.text.method.QwertyKeyListener;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

// Referenced classes of package android.widget:
//            AutoCompleteTextView, Filter

public class MultiAutoCompleteTextView extends AutoCompleteTextView {
    public static class CommaTokenizer
        implements Tokenizer {

        public int findTokenEnd(CharSequence charsequence, int i) {
            int j;
            int k;
            j = i;
            k = charsequence.length();
_L3:
            if(j >= k)
                break MISSING_BLOCK_LABEL_36;
            if(charsequence.charAt(j) != ',') goto _L2; else goto _L1
_L1:
            return j;
_L2:
            j++;
              goto _L3
            j = k;
              goto _L1
        }

        public int findTokenStart(CharSequence charsequence, int i) {
            int j;
            for(j = i; j > 0 && charsequence.charAt(j - 1) != ','; j--);
            for(; j < i && charsequence.charAt(j) == ' '; j++);
            return j;
        }

        public CharSequence terminateToken(CharSequence charsequence) {
            int i;
            for(i = charsequence.length(); i > 0 && charsequence.charAt(i - 1) == ' '; i--);
            if(i <= 0 || charsequence.charAt(i - 1) != ',')
                if(charsequence instanceof Spanned) {
                    SpannableString spannablestring = new SpannableString((new StringBuilder()).append(charsequence).append(", ").toString());
                    TextUtils.copySpansFrom((Spanned)charsequence, 0, charsequence.length(), java/lang/Object, spannablestring, 0);
                    charsequence = spannablestring;
                } else {
                    charsequence = (new StringBuilder()).append(charsequence).append(", ").toString();
                }
            return charsequence;
        }

        public CommaTokenizer() {
        }
    }

    public static interface Tokenizer {

        public abstract int findTokenEnd(CharSequence charsequence, int i);

        public abstract int findTokenStart(CharSequence charsequence, int i);

        public abstract CharSequence terminateToken(CharSequence charsequence);
    }


    public MultiAutoCompleteTextView(Context context) {
        this(context, null);
    }

    public MultiAutoCompleteTextView(Context context, AttributeSet attributeset) {
        this(context, attributeset, 0x101006b);
    }

    public MultiAutoCompleteTextView(Context context, AttributeSet attributeset, int i) {
        super(context, attributeset, i);
    }

    public boolean enoughToFilter() {
        boolean flag;
        Editable editable;
        int i;
        flag = false;
        editable = getText();
        i = getSelectionEnd();
        break MISSING_BLOCK_LABEL_12;
        if(i >= 0 && mTokenizer != null && i - mTokenizer.findTokenStart(editable, i) >= getThreshold())
            flag = true;
        return flag;
    }

    void finishInit() {
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent) {
        super.onInitializeAccessibilityEvent(accessibilityevent);
        accessibilityevent.setClassName(android/widget/MultiAutoCompleteTextView.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilitynodeinfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilitynodeinfo);
        accessibilitynodeinfo.setClassName(android/widget/MultiAutoCompleteTextView.getName());
    }

    protected void performFiltering(CharSequence charsequence, int i) {
        if(!enoughToFilter()) goto _L2; else goto _L1
_L1:
        int j = getSelectionEnd();
        performFiltering(charsequence, mTokenizer.findTokenStart(charsequence, j), j, i);
_L4:
        return;
_L2:
        dismissDropDown();
        Filter filter = getFilter();
        if(filter != null)
            filter.filter(null);
        if(true) goto _L4; else goto _L3
_L3:
    }

    protected void performFiltering(CharSequence charsequence, int i, int j, int k) {
        getFilter().filter(charsequence.subSequence(i, j), this);
    }

    public void performValidation() {
        AutoCompleteTextView.Validator validator = getValidator();
        if(validator != null && mTokenizer != null) {
            Editable editable = getText();
            int i = getText().length();
            while(i > 0)  {
                int j = mTokenizer.findTokenStart(editable, i);
                CharSequence charsequence = editable.subSequence(j, mTokenizer.findTokenEnd(editable, j));
                if(TextUtils.isEmpty(charsequence))
                    editable.replace(j, i, "");
                else
                if(!validator.isValid(charsequence))
                    editable.replace(j, i, mTokenizer.terminateToken(validator.fixText(charsequence)));
                i = j;
            }
        }
    }

    protected void replaceText(CharSequence charsequence) {
        clearComposingText();
        int i = getSelectionEnd();
        int j = mTokenizer.findTokenStart(getText(), i);
        Editable editable = getText();
        QwertyKeyListener.markAsReplaced(editable, j, i, TextUtils.substring(editable, j, i));
        editable.replace(j, i, mTokenizer.terminateToken(charsequence));
    }

    public void setTokenizer(Tokenizer tokenizer) {
        mTokenizer = tokenizer;
    }

    private Tokenizer mTokenizer;
}
