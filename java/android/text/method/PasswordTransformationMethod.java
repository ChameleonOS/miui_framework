// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.method;

import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import android.text.*;
import android.text.style.UpdateLayout;
import android.view.View;
import java.lang.ref.WeakReference;

// Referenced classes of package android.text.method:
//            TransformationMethod, TextKeyListener

public class PasswordTransformationMethod
    implements TransformationMethod, TextWatcher {
    private static class ViewReference extends WeakReference
        implements NoCopySpan {

        public ViewReference(View view) {
            super(view);
        }
    }

    private static class Visible extends Handler
        implements UpdateLayout, Runnable {

        public void run() {
            mText.removeSpan(this);
        }

        private Spannable mText;
        private PasswordTransformationMethod mTransformer;


        public Visible(Spannable spannable, PasswordTransformationMethod passwordtransformationmethod) {
            mText = spannable;
            mTransformer = passwordtransformationmethod;
            postAtTime(this, 1500L + SystemClock.uptimeMillis());
        }
    }

    private static class PasswordCharSequence
        implements CharSequence, GetChars {

        public char charAt(int i) {
            if(!(mSource instanceof Spanned)) goto _L2; else goto _L1
_L1:
            Spanned spanned;
            int j;
            int k;
            spanned = (Spanned)mSource;
            j = spanned.getSpanStart(TextKeyListener.ACTIVE);
            k = spanned.getSpanEnd(TextKeyListener.ACTIVE);
            if(i < j || i >= k) goto _L4; else goto _L3
_L3:
            char c = mSource.charAt(i);
_L6:
            return c;
_L4:
            Visible avisible[] = (Visible[])spanned.getSpans(0, spanned.length(), android/text/method/PasswordTransformationMethod$Visible);
            for(int l = 0; l < avisible.length; l++) {
                if(spanned.getSpanStart(avisible[l].mTransformer) < 0)
                    continue;
                int i1 = spanned.getSpanStart(avisible[l]);
                int j1 = spanned.getSpanEnd(avisible[l]);
                if(i < i1 || i >= j1)
                    continue;
                c = mSource.charAt(i);
                continue; /* Loop/switch isn't completed */
            }

_L2:
            c = PasswordTransformationMethod.DOT;
            if(true) goto _L6; else goto _L5
_L5:
        }

        public void getChars(int i, int j, char ac[], int k) {
            int l;
            int i1;
            int j1;
            int ai[];
            int ai1[];
            int k1;
            TextUtils.getChars(mSource, i, j, ac, k);
            l = -1;
            i1 = -1;
            j1 = 0;
            ai = null;
            ai1 = null;
            if(mSource instanceof Spanned) {
                Spanned spanned = (Spanned)mSource;
                l = spanned.getSpanStart(TextKeyListener.ACTIVE);
                i1 = spanned.getSpanEnd(TextKeyListener.ACTIVE);
                Visible avisible[] = (Visible[])spanned.getSpans(0, spanned.length(), android/text/method/PasswordTransformationMethod$Visible);
                j1 = avisible.length;
                ai = new int[j1];
                ai1 = new int[j1];
                for(int i2 = 0; i2 < j1; i2++)
                    if(spanned.getSpanStart(avisible[i2].mTransformer) >= 0) {
                        ai[i2] = spanned.getSpanStart(avisible[i2]);
                        ai1[i2] = spanned.getSpanEnd(avisible[i2]);
                    }

            }
            k1 = i;
_L11:
            if(k1 >= j) goto _L2; else goto _L1
_L1:
            if(k1 >= l && k1 < i1) goto _L4; else goto _L3
_L3:
            boolean flag;
            int l1;
            flag = false;
            l1 = 0;
_L9:
            if(l1 >= j1) goto _L6; else goto _L5
_L5:
            if(k1 < ai[l1] || k1 >= ai1[l1]) goto _L8; else goto _L7
_L7:
            flag = true;
_L6:
            if(!flag)
                ac[k + (k1 - i)] = PasswordTransformationMethod.DOT;
_L4:
            k1++;
            continue; /* Loop/switch isn't completed */
_L8:
            l1++;
            if(true) goto _L9; else goto _L2
_L2:
            return;
            if(true) goto _L11; else goto _L10
_L10:
        }

        public int length() {
            return mSource.length();
        }

        public CharSequence subSequence(int i, int j) {
            char ac[] = new char[j - i];
            getChars(i, j, ac, 0);
            return new String(ac);
        }

        public String toString() {
            return subSequence(0, length()).toString();
        }

        private CharSequence mSource;

        public PasswordCharSequence(CharSequence charsequence) {
            mSource = charsequence;
        }
    }


    public PasswordTransformationMethod() {
    }

    public static PasswordTransformationMethod getInstance() {
        PasswordTransformationMethod passwordtransformationmethod;
        if(sInstance != null) {
            passwordtransformationmethod = sInstance;
        } else {
            sInstance = new PasswordTransformationMethod();
            passwordtransformationmethod = sInstance;
        }
        return passwordtransformationmethod;
    }

    private static void removeVisibleSpans(Spannable spannable) {
        Visible avisible[] = (Visible[])spannable.getSpans(0, spannable.length(), android/text/method/PasswordTransformationMethod$Visible);
        for(int i = 0; i < avisible.length; i++)
            spannable.removeSpan(avisible[i]);

    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k) {
    }

    public CharSequence getTransformation(CharSequence charsequence, View view) {
        if(charsequence instanceof Spannable) {
            Spannable spannable = (Spannable)charsequence;
            ViewReference aviewreference[] = (ViewReference[])spannable.getSpans(0, spannable.length(), android/text/method/PasswordTransformationMethod$ViewReference);
            for(int i = 0; i < aviewreference.length; i++)
                spannable.removeSpan(aviewreference[i]);

            removeVisibleSpans(spannable);
            spannable.setSpan(new ViewReference(view), 0, 0, 34);
        }
        return new PasswordCharSequence(charsequence);
    }

    public void onFocusChanged(View view, CharSequence charsequence, boolean flag, int i, Rect rect) {
        if(!flag && (charsequence instanceof Spannable))
            removeVisibleSpans((Spannable)charsequence);
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k) {
        if(!(charsequence instanceof Spannable)) goto _L2; else goto _L1
_L1:
        Spannable spannable;
        ViewReference aviewreference[];
        spannable = (Spannable)charsequence;
        aviewreference = (ViewReference[])spannable.getSpans(0, charsequence.length(), android/text/method/PasswordTransformationMethod$ViewReference);
        if(aviewreference.length != 0) goto _L3; else goto _L2
_L2:
        return;
_L3:
        View view = null;
        for(int l = 0; view == null && l < aviewreference.length; l++)
            view = (View)aviewreference[l].get();

        if(view != null && (8 & TextKeyListener.getInstance().getPrefs(view.getContext())) != 0 && k > 0) {
            removeVisibleSpans(spannable);
            if(k == 1)
                spannable.setSpan(new Visible(spannable, this), i, i + k, 33);
        }
        if(true) goto _L2; else goto _L4
_L4:
    }

    private static char DOT = '\u2022';
    private static PasswordTransformationMethod sInstance;


}
