// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.util;

import java.lang.reflect.Array;

public class SimplePool {
    public static class PoolInstance {

        public Object acquire() {
            Object obj = null;
            this;
            JVM INSTR monitorenter ;
            if(mIndex >= 0) {
                obj = mElements[mIndex];
                Object aobj[] = mElements;
                int i = mIndex;
                mIndex = i - 1;
                aobj[i] = null;
            }
            this;
            JVM INSTR monitorexit ;
            if(obj == null)
                obj = mManager.createInstance();
            mManager.onAcquire(obj);
            return obj;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void release(Object obj) {
            mManager.onRelease(obj);
            this;
            JVM INSTR monitorenter ;
            if(1 + mIndex < mElements.length) {
                Object aobj[] = mElements;
                int i = 1 + mIndex;
                mIndex = i;
                aobj[i] = obj;
            }
            return;
        }

        private Object mElements[];
        private int mIndex;
        private Manager mManager;

        public PoolInstance(Manager manager, int i) {
            mManager = manager;
            mElements = (Object[])(Object[])Array.newInstance(java/lang/Object, i);
            mIndex = -1;
        }
    }

    public static abstract class Manager {

        public abstract Object createInstance();

        public void onAcquire(Object obj) {
        }

        public void onRelease(Object obj) {
        }

        public Manager() {
        }
    }


    public SimplePool() {
    }

    public static PoolInstance newInsance(Manager manager, int i) {
        return new PoolInstance(manager, i);
    }
}
