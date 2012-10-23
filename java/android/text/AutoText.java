// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text;

import android.content.Context;
import android.content.res.*;
import android.view.View;
import com.android.internal.util.XmlUtils;
import java.io.IOException;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;

public class AutoText {

    private AutoText(Resources resources) {
        mLocale = resources.getConfiguration().locale;
        init(resources);
    }

    private void add(String s, char c) {
        int i;
        int j;
        int k;
        i = s.length();
        j = 0;
        mSize = 1 + mSize;
        k = 0;
_L13:
        if(k >= i) goto _L2; else goto _L1
_L1:
        char c1;
        boolean flag;
        c1 = s.charAt(k);
        flag = false;
_L11:
        if(mTrie[j] == '\uFFFF') goto _L4; else goto _L3
_L3:
        if(c1 != mTrie[0 + mTrie[j]]) goto _L6; else goto _L5
_L5:
        if(k != i - 1) goto _L8; else goto _L7
_L7:
        mTrie[1 + mTrie[j]] = c;
_L2:
        return;
_L8:
        j = 2 + mTrie[j];
        flag = true;
_L4:
        if(flag)
            break MISSING_BLOCK_LABEL_242;
        char c2 = newTrieNode();
        mTrie[j] = c2;
        mTrie[0 + mTrie[j]] = c1;
        mTrie[1 + mTrie[j]] = '\uFFFF';
        mTrie[3 + mTrie[j]] = '\uFFFF';
        mTrie[2 + mTrie[j]] = '\uFFFF';
        if(k != i - 1)
            break; /* Loop/switch isn't completed */
        mTrie[1 + mTrie[j]] = c;
        if(true) goto _L2; else goto _L9
_L9:
        break; /* Loop/switch isn't completed */
_L6:
        j = 3 + mTrie[j];
        if(true) goto _L11; else goto _L10
_L10:
        j = 2 + mTrie[j];
        k++;
        if(true) goto _L13; else goto _L12
_L12:
    }

    public static String get(CharSequence charsequence, int i, int j, View view) {
        return getInstance(view).lookup(charsequence, i, j);
    }

    private static AutoText getInstance(View view) {
        Resources resources;
        Locale locale;
        resources = view.getContext().getResources();
        locale = resources.getConfiguration().locale;
        Object obj = sLock;
        obj;
        JVM INSTR monitorenter ;
        AutoText autotext = sInstance;
        if(!locale.equals(autotext.mLocale)) {
            autotext = new AutoText(resources);
            sInstance = autotext;
        }
        return autotext;
    }

    private int getSize() {
        return mSize;
    }

    public static int getSize(View view) {
        return getInstance(view).getSize();
    }

    private void init(Resources resources) {
        XmlResourceParser xmlresourceparser;
        StringBuilder stringbuilder;
        xmlresourceparser = resources.getXml(0x10f0001);
        stringbuilder = new StringBuilder(9300);
        mTrie = new char[14337];
        mTrie[0] = '\uFFFF';
        mTrieUsed = '\001';
        XmlUtils.beginDocument(xmlresourceparser, "words");
_L4:
        String s;
        XmlUtils.nextElement(xmlresourceparser);
        s = xmlresourceparser.getName();
        if(s != null && s.equals("word")) goto _L2; else goto _L1
_L1:
        resources.flushLayoutCache();
        xmlresourceparser.close();
        mText = stringbuilder.toString();
        return;
_L2:
        String s1 = xmlresourceparser.getAttributeValue(null, "src");
        if(xmlresourceparser.next() != 4) goto _L4; else goto _L3
_L3:
        String s2;
        char c;
        s2 = xmlresourceparser.getText();
        if(!s2.equals(""))
            break MISSING_BLOCK_LABEL_168;
        c = '\0';
_L5:
        add(s1, c);
          goto _L4
        XmlPullParserException xmlpullparserexception;
        xmlpullparserexception;
        throw new RuntimeException(xmlpullparserexception);
        Exception exception;
        exception;
        xmlresourceparser.close();
        throw exception;
        c = (char)stringbuilder.length();
        stringbuilder.append((char)s2.length());
        stringbuilder.append(s2);
          goto _L5
        IOException ioexception;
        ioexception;
        throw new RuntimeException(ioexception);
    }

    private String lookup(CharSequence charsequence, int i, int j) {
        String s;
        char c;
        int k;
        s = null;
        c = mTrie[0];
        k = i;
_L8:
        if(k >= j) goto _L2; else goto _L1
_L1:
        char c1 = charsequence.charAt(k);
_L9:
        if(c == '\uFFFF') goto _L4; else goto _L3
_L3:
        if(c1 != mTrie[c + 0])
            break MISSING_BLOCK_LABEL_142;
        if(k != j - 1 || mTrie[c + 1] == '\uFFFF') goto _L6; else goto _L5
_L5:
        char c2 = mTrie[c + 1];
        char c3 = mText.charAt(c2);
        s = mText.substring(c2 + 1, c3 + (c2 + 1));
_L2:
        return s;
_L6:
        c = mTrie[c + 2];
_L4:
        if(c == '\uFFFF') goto _L2; else goto _L7
_L7:
        k++;
          goto _L8
        c = mTrie[c + 3];
          goto _L9
    }

    private char newTrieNode() {
        if(4 + mTrieUsed > mTrie.length) {
            char ac[] = new char[1024 + mTrie.length];
            System.arraycopy(mTrie, 0, ac, 0, mTrie.length);
            mTrie = ac;
        }
        char c = mTrieUsed;
        mTrieUsed = 4 + mTrieUsed;
        return c;
    }

    private static final int DEFAULT = 14337;
    private static final int INCREMENT = 1024;
    private static final int RIGHT = 9300;
    private static final int TRIE_C = 0;
    private static final int TRIE_CHILD = 2;
    private static final int TRIE_NEXT = 3;
    private static final char TRIE_NULL = 65535;
    private static final int TRIE_OFF = 1;
    private static final int TRIE_ROOT = 0;
    private static final int TRIE_SIZEOF = 4;
    private static AutoText sInstance = new AutoText(Resources.getSystem());
    private static Object sLock = new Object();
    private Locale mLocale;
    private int mSize;
    private String mText;
    private char mTrie[];
    private char mTrieUsed;

}
