// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.util;

import java.util.ArrayList;
import java.util.Collection;

// Referenced classes of package android.text.util:
//            Rfc822Token

public class Rfc822Tokenizer
    implements android.widget.MultiAutoCompleteTextView.Tokenizer {

    public Rfc822Tokenizer() {
    }

    private static void crunch(StringBuilder stringbuilder) {
        int i = 0;
        int j;
        for(j = stringbuilder.length(); i < j;)
            if(stringbuilder.charAt(i) == 0) {
                if(i == 0 || i == j - 1 || stringbuilder.charAt(i - 1) == ' ' || stringbuilder.charAt(i - 1) == 0 || stringbuilder.charAt(i + 1) == ' ' || stringbuilder.charAt(i + 1) == 0) {
                    stringbuilder.deleteCharAt(i);
                    j--;
                } else {
                    i++;
                }
            } else {
                i++;
            }

        for(int k = 0; k < j; k++)
            if(stringbuilder.charAt(k) == 0)
                stringbuilder.setCharAt(k, ' ');

    }

    public static void tokenize(CharSequence charsequence, Collection collection) {
        StringBuilder stringbuilder;
        StringBuilder stringbuilder1;
        StringBuilder stringbuilder2;
        int i;
        int j;
        stringbuilder = new StringBuilder();
        stringbuilder1 = new StringBuilder();
        stringbuilder2 = new StringBuilder();
        i = 0;
        j = charsequence.length();
_L7:
        char c;
        if(i >= j)
            break; /* Loop/switch isn't completed */
        c = charsequence.charAt(i);
        if(c != ',' && c != ';') goto _L2; else goto _L1
_L1:
        for(i++; i < j && charsequence.charAt(i) == ' '; i++);
        crunch(stringbuilder);
        if(stringbuilder1.length() <= 0) goto _L4; else goto _L3
_L3:
        collection.add(new Rfc822Token(stringbuilder.toString(), stringbuilder1.toString(), stringbuilder2.toString()));
_L5:
        stringbuilder.setLength(0);
        stringbuilder1.setLength(0);
        stringbuilder2.setLength(0);
        continue; /* Loop/switch isn't completed */
_L4:
        if(stringbuilder.length() > 0)
            collection.add(new Rfc822Token(null, stringbuilder.toString(), stringbuilder2.toString()));
        if(true) goto _L5; else goto _L2
_L2:
        if(c == '"') {
            i++;
            do {
                if(i >= j)
                    continue; /* Loop/switch isn't completed */
                char c3 = charsequence.charAt(i);
                if(c3 == '"') {
                    i++;
                    continue; /* Loop/switch isn't completed */
                }
                if(c3 == '\\') {
                    if(i + 1 < j)
                        stringbuilder.append(charsequence.charAt(i + 1));
                    i += 2;
                } else {
                    stringbuilder.append(c3);
                    i++;
                }
            } while(true);
        }
        if(c == '(') {
            int k = 1;
            i++;
            while(i < j && k > 0)  {
                char c2 = charsequence.charAt(i);
                if(c2 == ')') {
                    if(k > 1)
                        stringbuilder2.append(c2);
                    k--;
                    i++;
                } else
                if(c2 == '(') {
                    stringbuilder2.append(c2);
                    k++;
                    i++;
                } else
                if(c2 == '\\') {
                    if(i + 1 < j)
                        stringbuilder2.append(charsequence.charAt(i + 1));
                    i += 2;
                } else {
                    stringbuilder2.append(c2);
                    i++;
                }
            }
            continue; /* Loop/switch isn't completed */
        }
        if(c == '<') {
            i++;
            do {
                if(i >= j)
                    continue; /* Loop/switch isn't completed */
                char c1 = charsequence.charAt(i);
                if(c1 == '>') {
                    i++;
                    continue; /* Loop/switch isn't completed */
                }
                stringbuilder1.append(c1);
                i++;
            } while(true);
        }
        if(c == ' ') {
            stringbuilder.append('\0');
            i++;
        } else {
            stringbuilder.append(c);
            i++;
        }
        if(true) goto _L7; else goto _L6
_L6:
        crunch(stringbuilder);
        if(stringbuilder1.length() <= 0) goto _L9; else goto _L8
_L8:
        collection.add(new Rfc822Token(stringbuilder.toString(), stringbuilder1.toString(), stringbuilder2.toString()));
_L11:
        return;
_L9:
        if(stringbuilder.length() > 0)
            collection.add(new Rfc822Token(null, stringbuilder.toString(), stringbuilder2.toString()));
        if(true) goto _L11; else goto _L10
_L10:
    }

    public static Rfc822Token[] tokenize(CharSequence charsequence) {
        ArrayList arraylist = new ArrayList();
        tokenize(charsequence, ((Collection) (arraylist)));
        return (Rfc822Token[])arraylist.toArray(new Rfc822Token[arraylist.size()]);
    }

    public int findTokenEnd(CharSequence charsequence, int i) {
        int j = charsequence.length();
        int k = i;
label0:
        do {
            char c;
label1:
            {
                if(k < j) {
                    c = charsequence.charAt(k);
                    if(c != ',' && c != ';')
                        break label1;
                }
                return k;
            }
            if(c == '"') {
                k++;
                do {
                    if(k >= j)
                        continue label0;
                    char c2 = charsequence.charAt(k);
                    if(c2 == '"') {
                        k++;
                        continue label0;
                    }
                    if(c2 == '\\' && k + 1 < j)
                        k += 2;
                    else
                        k++;
                } while(true);
            }
            if(c == '(') {
                int l = 1;
                k++;
                while(k < j && l > 0)  {
                    char c1 = charsequence.charAt(k);
                    if(c1 == ')') {
                        l--;
                        k++;
                    } else
                    if(c1 == '(') {
                        l++;
                        k++;
                    } else
                    if(c1 == '\\' && k + 1 < j)
                        k += 2;
                    else
                        k++;
                }
                continue;
            }
            if(c == '<') {
                k++;
                do {
                    if(k >= j)
                        continue label0;
                    if(charsequence.charAt(k) == '>') {
                        k++;
                        continue label0;
                    }
                    k++;
                } while(true);
            }
            k++;
        } while(true);
    }

    public int findTokenStart(CharSequence charsequence, int i) {
        int j = 0;
        int k = 0;
        do {
            if(k >= i)
                break;
            k = findTokenEnd(charsequence, k);
            if(k < i) {
                for(k++; k < i && charsequence.charAt(k) == ' '; k++);
                if(k < i)
                    j = k;
            }
        } while(true);
        return j;
    }

    public CharSequence terminateToken(CharSequence charsequence) {
        return (new StringBuilder()).append(charsequence).append(", ").toString();
    }
}
