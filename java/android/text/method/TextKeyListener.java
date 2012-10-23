// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.method;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.text.*;
import android.view.*;
import java.lang.ref.WeakReference;

// Referenced classes of package android.text.method:
//            BaseKeyListener, QwertyKeyListener, MultiTapKeyListener, KeyListener

public class TextKeyListener extends BaseKeyListener
    implements SpanWatcher {
    private class SettingsObserver extends ContentObserver {

        public void onChange(boolean flag) {
            if(mResolver != null) {
                ContentResolver contentresolver = (ContentResolver)mResolver.get();
                if(contentresolver == null)
                    mPrefsInited = false;
                else
                    updatePrefs(contentresolver);
            } else {
                mPrefsInited = false;
            }
        }

        final TextKeyListener this$0;

        public SettingsObserver() {
            this$0 = TextKeyListener.this;
            super(new Handler());
        }
    }

    private static class NullKeyListener
        implements KeyListener {

        public static NullKeyListener getInstance() {
            NullKeyListener nullkeylistener;
            if(sInstance != null) {
                nullkeylistener = sInstance;
            } else {
                sInstance = new NullKeyListener();
                nullkeylistener = sInstance;
            }
            return nullkeylistener;
        }

        public void clearMetaKeyState(View view, Editable editable, int i) {
        }

        public int getInputType() {
            return 0;
        }

        public boolean onKeyDown(View view, Editable editable, int i, KeyEvent keyevent) {
            return false;
        }

        public boolean onKeyOther(View view, Editable editable, KeyEvent keyevent) {
            return false;
        }

        public boolean onKeyUp(View view, Editable editable, int i, KeyEvent keyevent) {
            return false;
        }

        private static NullKeyListener sInstance;

        private NullKeyListener() {
        }
    }

    public static final class Capitalize extends Enum {

        public static Capitalize valueOf(String s) {
            return (Capitalize)Enum.valueOf(android/text/method/TextKeyListener$Capitalize, s);
        }

        public static Capitalize[] values() {
            return (Capitalize[])$VALUES.clone();
        }

        private static final Capitalize $VALUES[];
        public static final Capitalize CHARACTERS;
        public static final Capitalize NONE;
        public static final Capitalize SENTENCES;
        public static final Capitalize WORDS;

        static  {
            NONE = new Capitalize("NONE", 0);
            SENTENCES = new Capitalize("SENTENCES", 1);
            WORDS = new Capitalize("WORDS", 2);
            CHARACTERS = new Capitalize("CHARACTERS", 3);
            Capitalize acapitalize[] = new Capitalize[4];
            acapitalize[0] = NONE;
            acapitalize[1] = SENTENCES;
            acapitalize[2] = WORDS;
            acapitalize[3] = CHARACTERS;
            $VALUES = acapitalize;
        }

        private Capitalize(String s, int i) {
            super(s, i);
        }
    }


    public TextKeyListener(Capitalize capitalize, boolean flag) {
        mAutoCap = capitalize;
        mAutoText = flag;
    }

    public static void clear(Editable editable) {
        editable.clear();
        editable.removeSpan(ACTIVE);
        editable.removeSpan(CAPPED);
        editable.removeSpan(INHIBIT_REPLACEMENT);
        editable.removeSpan(LAST_TYPED);
        QwertyKeyListener.Replaced areplaced[] = (QwertyKeyListener.Replaced[])editable.getSpans(0, editable.length(), android/text/method/QwertyKeyListener$Replaced);
        int i = areplaced.length;
        for(int j = 0; j < i; j++)
            editable.removeSpan(areplaced[j]);

    }

    public static TextKeyListener getInstance() {
        return getInstance(false, Capitalize.NONE);
    }

    public static TextKeyListener getInstance(boolean flag, Capitalize capitalize) {
        int i = 2 * capitalize.ordinal();
        int j;
        int k;
        if(flag)
            j = 1;
        else
            j = 0;
        k = i + j;
        if(sInstance[k] == null)
            sInstance[k] = new TextKeyListener(capitalize, flag);
        return sInstance[k];
    }

    private KeyListener getKeyListener(KeyEvent keyevent) {
        int i = keyevent.getKeyCharacterMap().getKeyboardType();
        Object obj;
        if(i == 3)
            obj = QwertyKeyListener.getInstance(mAutoText, mAutoCap);
        else
        if(i == 1)
            obj = MultiTapKeyListener.getInstance(mAutoText, mAutoCap);
        else
        if(i == 4 || i == 5)
            obj = QwertyKeyListener.getInstanceForFullKeyboard();
        else
            obj = NullKeyListener.getInstance();
        return ((KeyListener) (obj));
    }

    private void initPrefs(Context context) {
        ContentResolver contentresolver = context.getContentResolver();
        mResolver = new WeakReference(contentresolver);
        if(mObserver == null) {
            mObserver = new SettingsObserver();
            contentresolver.registerContentObserver(android.provider.Settings.System.CONTENT_URI, true, mObserver);
        }
        updatePrefs(contentresolver);
        mPrefsInited = true;
    }

    public static boolean shouldCap(Capitalize capitalize, CharSequence charsequence, int i) {
        boolean flag = false;
        if(capitalize != Capitalize.NONE)
            if(capitalize == Capitalize.CHARACTERS) {
                flag = true;
            } else {
                char c;
                boolean flag1;
                if(capitalize == Capitalize.WORDS)
                    c = '\u2000';
                else
                    c = '\u4000';
                if(TextUtils.getCapsMode(charsequence, i, c) != 0)
                    flag1 = true;
                else
                    flag1 = false;
                flag = flag1;
            }
        return flag;
    }

    private void updatePrefs(ContentResolver contentresolver) {
        byte byte0 = 0;
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        byte byte1;
        int i;
        byte byte2;
        int j;
        if(android.provider.Settings.System.getInt(contentresolver, "auto_caps", 1) > 0)
            flag = true;
        else
            flag = false;
        if(android.provider.Settings.System.getInt(contentresolver, "auto_replace", 1) > 0)
            flag1 = true;
        else
            flag1 = false;
        if(android.provider.Settings.System.getInt(contentresolver, "auto_punctuate", 1) > 0)
            flag2 = true;
        else
            flag2 = false;
        if(android.provider.Settings.System.getInt(contentresolver, "show_password", 1) > 0)
            flag3 = true;
        else
            flag3 = false;
        if(flag)
            flag4 = true;
        else
            flag4 = false;
        if(flag1)
            byte1 = 2;
        else
            byte1 = 0;
        i = flag4 | byte1;
        if(flag2)
            byte2 = 4;
        else
            byte2 = 0;
        j = byte2 | i;
        if(flag3)
            byte0 = 8;
        mPrefs = j | byte0;
    }

    public int getInputType() {
        return makeTextContentType(mAutoCap, mAutoText);
    }

    int getPrefs(Context context) {
        this;
        JVM INSTR monitorenter ;
        if(!mPrefsInited || mResolver.get() == null)
            initPrefs(context);
        this;
        JVM INSTR monitorexit ;
        return mPrefs;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean onKeyDown(View view, Editable editable, int i, KeyEvent keyevent) {
        return getKeyListener(keyevent).onKeyDown(view, editable, i, keyevent);
    }

    public boolean onKeyOther(View view, Editable editable, KeyEvent keyevent) {
        return getKeyListener(keyevent).onKeyOther(view, editable, keyevent);
    }

    public boolean onKeyUp(View view, Editable editable, int i, KeyEvent keyevent) {
        return getKeyListener(keyevent).onKeyUp(view, editable, i, keyevent);
    }

    public void onSpanAdded(Spannable spannable, Object obj, int i, int j) {
    }

    public void onSpanChanged(Spannable spannable, Object obj, int i, int j, int k, int l) {
        if(obj == Selection.SELECTION_END)
            spannable.removeSpan(ACTIVE);
    }

    public void onSpanRemoved(Spannable spannable, Object obj, int i, int j) {
    }

    public void release() {
        if(mResolver != null) {
            ContentResolver contentresolver = (ContentResolver)mResolver.get();
            if(contentresolver != null) {
                contentresolver.unregisterContentObserver(mObserver);
                mResolver.clear();
            }
            mObserver = null;
            mResolver = null;
            mPrefsInited = false;
        }
    }

    static final Object ACTIVE = new android.text.NoCopySpan.Concrete();
    static final int AUTO_CAP = 1;
    static final int AUTO_PERIOD = 4;
    static final int AUTO_TEXT = 2;
    static final Object CAPPED = new android.text.NoCopySpan.Concrete();
    static final Object INHIBIT_REPLACEMENT = new android.text.NoCopySpan.Concrete();
    static final Object LAST_TYPED = new android.text.NoCopySpan.Concrete();
    static final int SHOW_PASSWORD = 8;
    private static TextKeyListener sInstance[] = new TextKeyListener[2 * Capitalize.values().length];
    private Capitalize mAutoCap;
    private boolean mAutoText;
    private SettingsObserver mObserver;
    private int mPrefs;
    private boolean mPrefsInited;
    private WeakReference mResolver;




/*
    static boolean access$102(TextKeyListener textkeylistener, boolean flag) {
        textkeylistener.mPrefsInited = flag;
        return flag;
    }

*/

}
