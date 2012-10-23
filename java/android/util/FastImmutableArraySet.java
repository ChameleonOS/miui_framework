// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;

import java.util.AbstractSet;
import java.util.Iterator;

public final class FastImmutableArraySet extends AbstractSet {
    private static final class FastIterator
        implements Iterator {

        public boolean hasNext() {
            boolean flag;
            if(mIndex != mContents.length)
                flag = true;
            else
                flag = false;
            return flag;
        }

        public Object next() {
            Object aobj[] = mContents;
            int i = mIndex;
            mIndex = i + 1;
            return aobj[i];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        private final Object mContents[];
        int mIndex;

        public FastIterator(Object aobj[]) {
            mContents = aobj;
        }
    }


    public FastImmutableArraySet(Object aobj[]) {
        mContents = aobj;
    }

    public Iterator iterator() {
        FastIterator fastiterator = mIterator;
        if(fastiterator == null) {
            fastiterator = new FastIterator(mContents);
            mIterator = fastiterator;
        } else {
            fastiterator.mIndex = 0;
        }
        return fastiterator;
    }

    public int size() {
        return mContents.length;
    }

    Object mContents[];
    FastIterator mIterator;
}
