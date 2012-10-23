// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.os.Handler;

class DoubleDigitManager {
    static interface CallBack {

        public abstract void singleDigitFinal(int i);

        public abstract boolean singleDigitIntermediate(int i);

        public abstract boolean twoDigitsFinal(int i, int j);
    }


    public DoubleDigitManager(long l, CallBack callback) {
        timeoutInMillis = l;
        mCallBack = callback;
    }

    public void reportDigit(int i) {
        if(intermediateDigit != null) goto _L2; else goto _L1
_L1:
        intermediateDigit = Integer.valueOf(i);
        (new Handler()).postDelayed(new Runnable() {

            public void run() {
                if(intermediateDigit != null) {
                    mCallBack.singleDigitFinal(intermediateDigit.intValue());
                    intermediateDigit = null;
                }
            }

            final DoubleDigitManager this$0;

             {
                this$0 = DoubleDigitManager.this;
                super();
            }
        }, timeoutInMillis);
        if(!mCallBack.singleDigitIntermediate(i)) {
            intermediateDigit = null;
            mCallBack.singleDigitFinal(i);
        }
_L4:
        return;
_L2:
        if(mCallBack.twoDigitsFinal(intermediateDigit.intValue(), i))
            intermediateDigit = null;
        if(true) goto _L4; else goto _L3
_L3:
    }

    private Integer intermediateDigit;
    private final CallBack mCallBack;
    private final long timeoutInMillis;



/*
    static Integer access$002(DoubleDigitManager doubledigitmanager, Integer integer) {
        doubledigitmanager.intermediateDigit = integer;
        return integer;
    }

*/

}
