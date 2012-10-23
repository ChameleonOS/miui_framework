// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.method;

import android.text.*;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;

// Referenced classes of package android.text.method:
//            BaseKeyListener, CharacterPickerDialog, TextKeyListener

public class QwertyKeyListener extends BaseKeyListener {
    static class Replaced
        implements NoCopySpan {

        private char mText[];


        public Replaced(char ac[]) {
            mText = ac;
        }
    }


    public QwertyKeyListener(TextKeyListener.Capitalize capitalize, boolean flag) {
        this(capitalize, flag, false);
    }

    private QwertyKeyListener(TextKeyListener.Capitalize capitalize, boolean flag, boolean flag1) {
        mAutoCap = capitalize;
        mAutoText = flag;
        mFullKeyboard = flag1;
    }

    public static QwertyKeyListener getInstance(boolean flag, TextKeyListener.Capitalize capitalize) {
        int i = 2 * capitalize.ordinal();
        int j;
        int k;
        if(flag)
            j = 1;
        else
            j = 0;
        k = i + j;
        if(sInstance[k] == null)
            sInstance[k] = new QwertyKeyListener(capitalize, flag);
        return sInstance[k];
    }

    public static QwertyKeyListener getInstanceForFullKeyboard() {
        if(sFullKeyboardInstance == null)
            sFullKeyboardInstance = new QwertyKeyListener(TextKeyListener.Capitalize.NONE, false, true);
        return sFullKeyboardInstance;
    }

    private String getReplacement(CharSequence charsequence, int i, int j, View view) {
        int k;
        boolean flag;
        String s;
        k = j - i;
        flag = false;
        s = AutoText.get(charsequence, i, j, view);
        if(s != null) goto _L2; else goto _L1
_L1:
        s = AutoText.get(TextUtils.substring(charsequence, i, j).toLowerCase(), 0, j - i, view);
        flag = true;
        if(s != null) goto _L2; else goto _L3
_L3:
        String s1 = null;
_L5:
        return s1;
_L2:
        int l = 0;
        if(flag) {
            for(int i1 = i; i1 < j; i1++)
                if(Character.isUpperCase(charsequence.charAt(i1)))
                    l++;

        }
        if(l == 0)
            s1 = s;
        else
        if(l == 1)
            s1 = toTitleCase(s);
        else
        if(l == k)
            s1 = s.toUpperCase();
        else
            s1 = toTitleCase(s);
        if(s1.length() == k && TextUtils.regionMatches(charsequence, i, s1, 0, k))
            s1 = null;
        if(true) goto _L5; else goto _L4
_L4:
    }

    public static void markAsReplaced(Spannable spannable, int i, int j, String s) {
        Replaced areplaced[] = (Replaced[])spannable.getSpans(0, spannable.length(), android/text/method/QwertyKeyListener$Replaced);
        for(int k = 0; k < areplaced.length; k++)
            spannable.removeSpan(areplaced[k]);

        int l = s.length();
        char ac[] = new char[l];
        s.getChars(0, l, ac, 0);
        spannable.setSpan(new Replaced(ac), i, j, 33);
    }

    private boolean showCharacterPicker(View view, Editable editable, char c, boolean flag, int i) {
        String s = (String)PICKER_SETS.get(c);
        boolean flag1;
        if(s == null) {
            flag1 = false;
        } else {
            if(i == 1)
                (new CharacterPickerDialog(view.getContext(), view, editable, s, flag)).show();
            flag1 = true;
        }
        return flag1;
    }

    private static String toTitleCase(String s) {
        return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }

    public int getInputType() {
        return makeTextContentType(mAutoCap, mAutoText);
    }

    public boolean onKeyDown(View view, Editable editable, int i, KeyEvent keyevent) {
        int j;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        j = 0;
        if(view != null)
            j = TextKeyListener.getInstance().getPrefs(view.getContext());
        int k = Selection.getSelectionStart(editable);
        int l = Selection.getSelectionEnd(editable);
        i1 = Math.min(k, l);
        j1 = Math.max(k, l);
        if(i1 < 0 || j1 < 0) {
            j1 = 0;
            i1 = 0;
            Selection.setSelection(editable, 0, 0);
        }
        k1 = editable.getSpanStart(TextKeyListener.ACTIVE);
        l1 = editable.getSpanEnd(TextKeyListener.ACTIVE);
        i2 = keyevent.getUnicodeChar(keyevent.getMetaState() | getMetaState(editable));
        if(mFullKeyboard) goto _L2; else goto _L1
_L1:
        int i7 = keyevent.getRepeatCount();
        if(i7 <= 0 || i1 != j1 || i1 <= 0) goto _L2; else goto _L3
_L3:
        char c2 = editable.charAt(i1 - 1);
        if(c2 != i2 && (c2 != Character.toUpperCase(i2) || view == null) || !showCharacterPicker(view, editable, c2, false, i7)) goto _L2; else goto _L4
_L4:
        boolean flag;
        resetMetaState(editable);
        flag = true;
_L5:
        return flag;
_L2:
label0:
        {
            if(i2 != 61185)
                break label0;
            if(view != null)
                showCharacterPicker(view, editable, '\uEF01', true, 1);
            resetMetaState(editable);
            flag = true;
        }
          goto _L5
        if(i2 != 61184) goto _L7; else goto _L6
_L6:
        int j6;
        int k6;
        if(i1 == j1)
            for(j6 = j1; j6 > 0 && j1 - j6 < 4 && Character.digit(editable.charAt(j6 - 1), 16) >= 0; j6--);
        else
            j6 = i1;
        k6 = -1;
        int l6 = Integer.parseInt(TextUtils.substring(editable, j6, j1), 16);
        k6 = l6;
_L8:
        if(k6 >= 0) {
            i1 = j6;
            Selection.setSelection(editable, i1, j1);
            i2 = k6;
        } else {
            i2 = 0;
        }
_L7:
label1:
        {
label2:
            {
                if(i2 == 0)
                    break label1;
                boolean flag1 = false;
                if((0x80000000 & i2) != 0) {
                    flag1 = true;
                    i2 &= 0x7fffffff;
                }
                if(k1 == i1 && l1 == j1) {
                    boolean flag2 = false;
                    if(-1 + (j1 - i1) == 0) {
                        int i6 = KeyEvent.getDeadChar(editable.charAt(i1), i2);
                        if(i6 != 0) {
                            i2 = i6;
                            flag2 = true;
                        }
                    }
                    if(!flag2) {
                        Selection.setSelection(editable, j1);
                        editable.removeSpan(TextKeyListener.ACTIVE);
                        i1 = j1;
                    }
                }
                int i3;
                int i4;
                String s2;
                if((j & 1) != 0 && Character.isLowerCase(i2) && TextKeyListener.shouldCap(mAutoCap, editable, i1)) {
                    int l4 = editable.getSpanEnd(TextKeyListener.CAPPED);
                    int i5 = editable.getSpanFlags(TextKeyListener.CAPPED);
                    String s1;
                    int j3;
                    Replaced areplaced1[];
                    int j4;
                    int k4;
                    char c1;
                    if(l4 == i1 && (0xffff & i5 >> 16) == i2) {
                        editable.removeSpan(TextKeyListener.CAPPED);
                    } else {
                        int j5 = i2 << 16;
                        i2 = Character.toUpperCase(i2);
                        if(i1 == 0) {
                            editable.setSpan(TextKeyListener.CAPPED, 0, 0, j5 | 0x11);
                        } else {
                            Object obj = TextKeyListener.CAPPED;
                            int k5 = i1 - 1;
                            int l5 = j5 | 0x21;
                            editable.setSpan(obj, k5, i1, l5);
                        }
                    }
                }
                if(i1 != j1)
                    Selection.setSelection(editable, j1);
                editable.setSpan(OLD_SEL_START, i1, i1, 17);
                s1 = String.valueOf((char)i2);
                editable.replace(i1, j1, s1);
                i3 = editable.getSpanStart(OLD_SEL_START);
                j3 = Selection.getSelectionEnd(editable);
                if(i3 < j3) {
                    editable.setSpan(TextKeyListener.LAST_TYPED, i3, j3, 33);
                    if(flag1) {
                        Selection.setSelection(editable, i3, j3);
                        editable.setSpan(TextKeyListener.ACTIVE, i3, j3, 33);
                    }
                }
                adjustMetaAfterKeypress(editable);
                if((j & 2) == 0 || !mAutoText || i2 != 32 && i2 != 9 && i2 != 10 && i2 != 44 && i2 != 46 && i2 != 33 && i2 != 63 && i2 != 34 && Character.getType(i2) != 22 || editable.getSpanEnd(TextKeyListener.INHIBIT_REPLACEMENT) == i3)
                    break label2;
                i4 = i3;
label3:
                do {
label4:
                    {
                        if(i4 > 0) {
                            c1 = editable.charAt(i4 - 1);
                            if(c1 == '\'' || Character.isLetter(c1))
                                break label4;
                        }
                        s2 = getReplacement(editable, i4, i3, view);
                        if(s2 == null)
                            break label2;
                        areplaced1 = (Replaced[])editable.getSpans(0, editable.length(), android/text/method/QwertyKeyListener$Replaced);
                        j4 = 0;
                        do {
                            k4 = areplaced1.length;
                            if(j4 >= k4)
                                break;
                            editable.removeSpan(areplaced1[j4]);
                            j4++;
                        } while(true);
                        break label3;
                    }
                    i4--;
                } while(true);
                char ac[] = new char[i3 - i4];
                TextUtils.getChars(editable, i4, i3, ac, 0);
                editable.setSpan(new Replaced(ac), i4, i3, 33);
                editable.replace(i4, i3, s2);
            }
            if((j & 4) != 0 && mAutoText) {
                int k3 = Selection.getSelectionEnd(editable);
                if(k3 - 3 >= 0 && editable.charAt(k3 - 1) == ' ' && editable.charAt(k3 - 2) == ' ') {
                    char c = editable.charAt(k3 - 3);
                    for(int l3 = k3 - 3; l3 > 0 && (c == '"' || Character.getType(c) == 22); l3--)
                        c = editable.charAt(l3 - 1);

                    if(Character.isLetter(c) || Character.isDigit(c))
                        editable.replace(k3 - 2, k3 - 1, ".");
                }
            }
            flag = true;
        }
          goto _L5
label5:
        {
            if(i != 67 || !keyevent.hasNoModifiers() && !keyevent.hasModifiers(2) || i1 != j1)
                break label5;
            byte byte0 = 1;
            if(editable.getSpanEnd(TextKeyListener.LAST_TYPED) == i1 && editable.charAt(i1 - 1) != '\n')
                byte0 = 2;
            Replaced areplaced[] = (Replaced[])editable.getSpans(i1 - byte0, i1, android/text/method/QwertyKeyListener$Replaced);
            if(areplaced.length <= 0)
                break label5;
            int j2 = editable.getSpanStart(areplaced[0]);
            int k2 = editable.getSpanEnd(areplaced[0]);
            String s = new String(areplaced[0].mText);
            editable.removeSpan(areplaced[0]);
            if(i1 >= k2) {
                editable.setSpan(TextKeyListener.INHIBIT_REPLACEMENT, k2, k2, 34);
                editable.replace(j2, k2, s);
                int l2 = editable.getSpanStart(TextKeyListener.INHIBIT_REPLACEMENT);
                if(l2 - 1 >= 0)
                    editable.setSpan(TextKeyListener.INHIBIT_REPLACEMENT, l2 - 1, l2, 33);
                else
                    editable.removeSpan(TextKeyListener.INHIBIT_REPLACEMENT);
                adjustMetaAfterKeypress(editable);
                flag = true;
            } else {
                adjustMetaAfterKeypress(editable);
                flag = super.onKeyDown(view, editable, i, keyevent);
            }
        }
          goto _L5
        flag = super.onKeyDown(view, editable, i, keyevent);
          goto _L5
        NumberFormatException numberformatexception;
        numberformatexception;
          goto _L8
    }

    private static SparseArray PICKER_SETS;
    private static QwertyKeyListener sFullKeyboardInstance;
    private static QwertyKeyListener sInstance[] = new QwertyKeyListener[2 * TextKeyListener.Capitalize.values().length];
    private TextKeyListener.Capitalize mAutoCap;
    private boolean mAutoText;
    private boolean mFullKeyboard;

    static  {
        PICKER_SETS = new SparseArray();
        PICKER_SETS.put(65, "\300\301\302\304\306\303\305\u0104\u0100");
        PICKER_SETS.put(67, "\307\u0106\u010C");
        PICKER_SETS.put(68, "\u010E");
        PICKER_SETS.put(69, "\310\311\312\313\u0118\u011A\u0112");
        PICKER_SETS.put(71, "\u011E");
        PICKER_SETS.put(76, "\u0141");
        PICKER_SETS.put(73, "\314\315\316\317\u012A\u0130");
        PICKER_SETS.put(78, "\321\u0143\u0147");
        PICKER_SETS.put(79, "\330\u0152\325\322\323\324\326\u014C");
        PICKER_SETS.put(82, "\u0158");
        PICKER_SETS.put(83, "\u015A\u0160\u015E");
        PICKER_SETS.put(84, "\u0164");
        PICKER_SETS.put(85, "\331\332\333\334\u016E\u016A");
        PICKER_SETS.put(89, "\335\u0178");
        PICKER_SETS.put(90, "\u0179\u017B\u017D");
        PICKER_SETS.put(97, "\340\341\342\344\346\343\345\u0105\u0101");
        PICKER_SETS.put(99, "\347\u0107\u010D");
        PICKER_SETS.put(100, "\u010F");
        PICKER_SETS.put(101, "\350\351\352\353\u0119\u011B\u0113");
        PICKER_SETS.put(103, "\u011F");
        PICKER_SETS.put(105, "\354\355\356\357\u012B\u0131");
        PICKER_SETS.put(108, "\u0142");
        PICKER_SETS.put(110, "\361\u0144\u0148");
        PICKER_SETS.put(111, "\370\u0153\365\362\363\364\366\u014D");
        PICKER_SETS.put(114, "\u0159");
        PICKER_SETS.put(115, "\247\337\u015B\u0161\u015F");
        PICKER_SETS.put(116, "\u0165");
        PICKER_SETS.put(117, "\371\372\373\374\u016F\u016B");
        PICKER_SETS.put(121, "\375\377");
        PICKER_SETS.put(122, "\u017A\u017C\u017E");
        PICKER_SETS.put(61185, "\u2026\245\u2022\256\251\261[]{}\\|");
        PICKER_SETS.put(47, "\\");
        PICKER_SETS.put(49, "\271\275\u2153\274\u215B");
        PICKER_SETS.put(50, "\262\u2154");
        PICKER_SETS.put(51, "\263\276\u215C");
        PICKER_SETS.put(52, "\u2074");
        PICKER_SETS.put(53, "\u215D");
        PICKER_SETS.put(55, "\u215E");
        PICKER_SETS.put(48, "\u207F\u2205");
        PICKER_SETS.put(36, "\242\243\u20AC\245\u20A3\u20A4\u20B1");
        PICKER_SETS.put(37, "\u2030");
        PICKER_SETS.put(42, "\u2020\u2021");
        PICKER_SETS.put(45, "\u2013\u2014");
        PICKER_SETS.put(43, "\261");
        PICKER_SETS.put(40, "[{<");
        PICKER_SETS.put(41, "]}>");
        PICKER_SETS.put(33, "\241");
        PICKER_SETS.put(34, "\u201C\u201D\253\273\u02DD");
        PICKER_SETS.put(63, "\277");
        PICKER_SETS.put(44, "\u201A\u201E");
        PICKER_SETS.put(61, "\u2260\u2248\u221E");
        PICKER_SETS.put(60, "\u2264\253\u2039");
        PICKER_SETS.put(62, "\u2265\273\u203A");
    }
}
