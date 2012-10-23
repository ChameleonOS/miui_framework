// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.speech.tts;


public abstract class UtteranceProgressListener {

    public UtteranceProgressListener() {
    }

    static UtteranceProgressListener from(final TextToSpeech.OnUtteranceCompletedListener listener) {
        return new UtteranceProgressListener() {

            /**
             * @deprecated Method onDone is deprecated
             */

            public void onDone(String s) {
                this;
                JVM INSTR monitorenter ;
                listener.onUtteranceCompleted(s);
                this;
                JVM INSTR monitorexit ;
                return;
                Exception exception;
                exception;
                throw exception;
            }

            public void onError(String s) {
                listener.onUtteranceCompleted(s);
            }

            public void onStart(String s) {
            }

            final TextToSpeech.OnUtteranceCompletedListener val$listener;

             {
                listener = onutterancecompletedlistener;
                super();
            }
        };
    }

    public abstract void onDone(String s);

    public abstract void onError(String s);

    public abstract void onStart(String s);
}
