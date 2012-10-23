// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text;

import java.lang.reflect.Array;

// Referenced classes of package android.text:
//            Spanned

public class SpanSet {

    SpanSet(Class class1) {
        classType = class1;
        numberOfSpans = 0;
    }

    int getNextTransition(int i, int j) {
        for(int k = 0; k < numberOfSpans; k++) {
            int l = spanStarts[k];
            int i1 = spanEnds[k];
            if(l > i && l < j)
                j = l;
            if(i1 > i && i1 < j)
                j = i1;
        }

        return j;
    }

    public boolean hasSpansIntersecting(int i, int j) {
        flag = true;
_L2:
        return flag;
        boolean flag;
        for(int k = 0; k < numberOfSpans; k++)
            if(spanStarts[k] < j && spanEnds[k] > i)
                break MISSING_BLOCK_LABEL_36;

        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void init(Spanned spanned, int i, int j) {
        Object aobj[] = spanned.getSpans(i, j, classType);
        int k = aobj.length;
        if(k > 0 && (spans == null || spans.length < k)) {
            spans = (Object[])(Object[])Array.newInstance(classType, k);
            spanStarts = new int[k];
            spanEnds = new int[k];
            spanFlags = new int[k];
        }
        numberOfSpans = 0;
        int l = 0;
        while(l < k)  {
            Object obj = aobj[l];
            int i1 = spanned.getSpanStart(obj);
            int j1 = spanned.getSpanEnd(obj);
            if(i1 != j1) {
                int k1 = spanned.getSpanFlags(obj);
                spans[numberOfSpans] = obj;
                spanStarts[numberOfSpans] = i1;
                spanEnds[numberOfSpans] = j1;
                spanFlags[numberOfSpans] = k1;
                numberOfSpans = 1 + numberOfSpans;
            }
            l++;
        }
    }

    public void recycle() {
        for(int i = 0; i < numberOfSpans; i++)
            spans[i] = null;

    }

    private final Class classType;
    int numberOfSpans;
    int spanEnds[];
    int spanFlags[];
    int spanStarts[];
    Object spans[];
}
