// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text;

import com.android.internal.util.ArrayUtils;
import java.lang.reflect.Array;

// Referenced classes of package android.text:
//            Spanned, SpanWatcher, Spannable

abstract class SpannableStringInternal {

    SpannableStringInternal(CharSequence charsequence, int i, int j) {
        int k;
        if(i == 0 && j == charsequence.length())
            mText = charsequence.toString();
        else
            mText = charsequence.toString().substring(i, j);
        k = ArrayUtils.idealIntArraySize(0);
        mSpans = new Object[k];
        mSpanData = new int[k * 3];
        if(charsequence instanceof Spanned) {
            Spanned spanned = (Spanned)charsequence;
            Object aobj[] = spanned.getSpans(i, j, java/lang/Object);
            for(int l = 0; l < aobj.length; l++) {
                int i1 = spanned.getSpanStart(aobj[l]);
                int j1 = spanned.getSpanEnd(aobj[l]);
                int k1 = spanned.getSpanFlags(aobj[l]);
                if(i1 < i)
                    i1 = i;
                if(j1 > j)
                    j1 = j;
                setSpan(aobj[l], i1 - i, j1 - i, k1);
            }

        }
    }

    private void checkRange(String s, int i, int j) {
        if(j < i)
            throw new IndexOutOfBoundsException((new StringBuilder()).append(s).append(" ").append(region(i, j)).append(" has end before start").toString());
        int k = length();
        if(i > k || j > k)
            throw new IndexOutOfBoundsException((new StringBuilder()).append(s).append(" ").append(region(i, j)).append(" ends beyond length ").append(k).toString());
        if(i < 0 || j < 0)
            throw new IndexOutOfBoundsException((new StringBuilder()).append(s).append(" ").append(region(i, j)).append(" starts before 0").toString());
        else
            return;
    }

    private static String region(int i, int j) {
        return (new StringBuilder()).append("(").append(i).append(" ... ").append(j).append(")").toString();
    }

    private void sendSpanAdded(Object obj, int i, int j) {
        SpanWatcher aspanwatcher[] = (SpanWatcher[])getSpans(i, j, android/text/SpanWatcher);
        int k = aspanwatcher.length;
        for(int l = 0; l < k; l++)
            aspanwatcher[l].onSpanAdded((Spannable)this, obj, i, j);

    }

    private void sendSpanChanged(Object obj, int i, int j, int k, int l) {
        SpanWatcher aspanwatcher[] = (SpanWatcher[])getSpans(Math.min(i, k), Math.max(j, l), android/text/SpanWatcher);
        int i1 = aspanwatcher.length;
        for(int j1 = 0; j1 < i1; j1++)
            aspanwatcher[j1].onSpanChanged((Spannable)this, obj, i, j, k, l);

    }

    private void sendSpanRemoved(Object obj, int i, int j) {
        SpanWatcher aspanwatcher[] = (SpanWatcher[])getSpans(i, j, android/text/SpanWatcher);
        int k = aspanwatcher.length;
        for(int l = 0; l < k; l++)
            aspanwatcher[l].onSpanRemoved((Spannable)this, obj, i, j);

    }

    public final char charAt(int i) {
        return mText.charAt(i);
    }

    public final void getChars(int i, int j, char ac[], int k) {
        mText.getChars(i, j, ac, k);
    }

    public int getSpanEnd(Object obj) {
        Object aobj[];
        int ai[];
        int j;
        int i = mSpanCount;
        aobj = mSpans;
        ai = mSpanData;
        j = i - 1;
_L3:
        if(j < 0)
            break MISSING_BLOCK_LABEL_54;
        if(aobj[j] != obj) goto _L2; else goto _L1
_L1:
        int k = ai[1 + j * 3];
_L4:
        return k;
_L2:
        j--;
          goto _L3
        k = -1;
          goto _L4
    }

    public int getSpanFlags(Object obj) {
        Object aobj[];
        int ai[];
        int j;
        int i = mSpanCount;
        aobj = mSpans;
        ai = mSpanData;
        j = i - 1;
_L3:
        if(j < 0)
            break MISSING_BLOCK_LABEL_54;
        if(aobj[j] != obj) goto _L2; else goto _L1
_L1:
        int k = ai[2 + j * 3];
_L4:
        return k;
_L2:
        j--;
          goto _L3
        k = 0;
          goto _L4
    }

    public int getSpanStart(Object obj) {
        Object aobj[];
        int ai[];
        int j;
        int i = mSpanCount;
        aobj = mSpans;
        ai = mSpanData;
        j = i - 1;
_L3:
        if(j < 0)
            break MISSING_BLOCK_LABEL_54;
        if(aobj[j] != obj) goto _L2; else goto _L1
_L1:
        int k = ai[0 + j * 3];
_L4:
        return k;
_L2:
        j--;
          goto _L3
        k = -1;
          goto _L4
    }

    public Object[] getSpans(int i, int j, Class class1) {
        int k;
        Object aobj[];
        int ai[];
        Object aobj1[];
        Object obj;
        int l;
        int i1;
        k = mSpanCount;
        aobj = mSpans;
        ai = mSpanData;
        aobj1 = null;
        obj = null;
        l = 0;
        i1 = 0;
_L2:
        int i2;
        if(l >= k)
            break MISSING_BLOCK_LABEL_313;
        if(class1 == null || class1.isInstance(aobj[l]))
            break; /* Loop/switch isn't completed */
        i2 = i1;
_L3:
        l++;
        i1 = i2;
        if(true) goto _L2; else goto _L1
_L1:
        int j1 = ai[0 + l * 3];
        int k1 = ai[1 + l * 3];
        if(j1 > j)
            i2 = i1;
        else
        if(k1 < i) {
            i2 = i1;
        } else {
label0:
            {
                if(j1 == k1 || i == j)
                    break label0;
                if(j1 == j) {
                    i2 = i1;
                } else {
                    if(k1 != i)
                        break label0;
                    i2 = i1;
                }
            }
        }
          goto _L3
        if(i1 == 0) {
            obj = aobj[l];
            i2 = i1 + 1;
        } else {
label1:
            {
                if(i1 == 1) {
                    aobj1 = (Object[])(Object[])Array.newInstance(class1, 1 + (k - l));
                    aobj1[0] = obj;
                }
                int l1 = 0xff0000 & ai[2 + l * 3];
                if(l1 == 0)
                    break MISSING_BLOCK_LABEL_294;
                for(int j2 = 0; j2 < i1 && l1 <= (0xff0000 & getSpanFlags(aobj1[j2])); j2++)
                    break label1;

                System.arraycopy(((Object) (aobj1)), j2, ((Object) (aobj1)), j2 + 1, i1 - j2);
                aobj1[j2] = aobj[l];
                i2 = i1 + 1;
            }
        }
          goto _L3
        i2 = i1 + 1;
        aobj1[i1] = aobj[l];
          goto _L3
        Object aobj3[];
        if(i1 == 0)
            aobj3 = (Object[])ArrayUtils.emptyArray(class1);
        else
        if(i1 == 1) {
            Object aobj4[] = (Object[])(Object[])Array.newInstance(class1, 1);
            aobj4[0] = obj;
            aobj3 = (Object[])aobj4;
        } else
        if(i1 == aobj1.length) {
            aobj3 = (Object[])aobj1;
        } else {
            Object aobj2[] = (Object[])(Object[])Array.newInstance(class1, i1);
            System.arraycopy(((Object) (aobj1)), 0, ((Object) (aobj2)), 0, i1);
            aobj3 = (Object[])aobj2;
        }
        return aobj3;
    }

    public final int length() {
        return mText.length();
    }

    public int nextSpanTransition(int i, int j, Class class1) {
        int k = mSpanCount;
        Object aobj[] = mSpans;
        int ai[] = mSpanData;
        if(class1 == null)
            class1 = java/lang/Object;
        for(int l = 0; l < k; l++) {
            int i1 = ai[0 + l * 3];
            int j1 = ai[1 + l * 3];
            if(i1 > i && i1 < j && class1.isInstance(aobj[l]))
                j = i1;
            if(j1 > i && j1 < j && class1.isInstance(aobj[l]))
                j = j1;
        }

        return j;
    }

    void removeSpan(Object obj) {
        int i = mSpanCount;
        Object aobj[] = mSpans;
        int ai[] = mSpanData;
        int j = i - 1;
        do {
label0:
            {
                if(j >= 0) {
                    if(aobj[j] != obj)
                        break label0;
                    int k = ai[0 + j * 3];
                    int l = ai[1 + j * 3];
                    int i1 = i - (j + 1);
                    System.arraycopy(((Object) (aobj)), j + 1, ((Object) (aobj)), j, i1);
                    System.arraycopy(ai, 3 * (j + 1), ai, j * 3, i1 * 3);
                    mSpanCount = -1 + mSpanCount;
                    sendSpanRemoved(obj, k, l);
                }
                return;
            }
            j--;
        } while(true);
    }

    void setSpan(Object obj, int i, int j, int k) {
        int l;
        Object aobj[];
        int ai[];
        int i1;
        checkRange("setSpan", i, j);
        if((k & 0x33) == 51) {
            if(i != 0 && i != length()) {
                char c1 = charAt(i - 1);
                if(c1 != '\n')
                    throw new RuntimeException((new StringBuilder()).append("PARAGRAPH span must start at paragraph boundary (").append(i).append(" follows ").append(c1).append(")").toString());
            }
            if(j != 0 && j != length()) {
                char c = charAt(j - 1);
                if(c != '\n')
                    throw new RuntimeException((new StringBuilder()).append("PARAGRAPH span must end at paragraph boundary (").append(j).append(" follows ").append(c).append(")").toString());
            }
        }
        l = mSpanCount;
        aobj = mSpans;
        ai = mSpanData;
        i1 = 0;
_L3:
        if(i1 >= l)
            break MISSING_BLOCK_LABEL_266;
        if(aobj[i1] != obj) goto _L2; else goto _L1
_L1:
        int k1 = ai[0 + i1 * 3];
        int l1 = ai[1 + i1 * 3];
        ai[0 + i1 * 3] = i;
        ai[1 + i1 * 3] = j;
        ai[2 + i1 * 3] = k;
        sendSpanChanged(obj, k1, l1, i, j);
_L4:
        return;
_L2:
        i1++;
          goto _L3
        if(1 + mSpanCount >= mSpans.length) {
            int j1 = ArrayUtils.idealIntArraySize(1 + mSpanCount);
            Object aobj1[] = new Object[j1];
            int ai1[] = new int[j1 * 3];
            System.arraycopy(((Object) (mSpans)), 0, ((Object) (aobj1)), 0, mSpanCount);
            System.arraycopy(mSpanData, 0, ai1, 0, 3 * mSpanCount);
            mSpans = aobj1;
            mSpanData = ai1;
        }
        mSpans[mSpanCount] = obj;
        mSpanData[0 + 3 * mSpanCount] = i;
        mSpanData[1 + 3 * mSpanCount] = j;
        mSpanData[2 + 3 * mSpanCount] = k;
        mSpanCount = 1 + mSpanCount;
        if(this instanceof Spannable)
            sendSpanAdded(obj, i, j);
          goto _L4
    }

    public final String toString() {
        return mText;
    }

    private static final int COLUMNS = 3;
    static final Object EMPTY[] = new Object[0];
    private static final int END = 1;
    private static final int FLAGS = 2;
    private static final int START;
    private int mSpanCount;
    private int mSpanData[];
    private Object mSpans[];
    private String mText;

}
