// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;


public interface MmiCode {
    public static final class State extends Enum {

        public static State valueOf(String s) {
            return (State)Enum.valueOf(com/android/internal/telephony/MmiCode$State, s);
        }

        public static State[] values() {
            return (State[])$VALUES.clone();
        }

        private static final State $VALUES[];
        public static final State CANCELLED;
        public static final State COMPLETE;
        public static final State FAILED;
        public static final State PENDING;

        static  {
            PENDING = new State("PENDING", 0);
            CANCELLED = new State("CANCELLED", 1);
            COMPLETE = new State("COMPLETE", 2);
            FAILED = new State("FAILED", 3);
            State astate[] = new State[4];
            astate[0] = PENDING;
            astate[1] = CANCELLED;
            astate[2] = COMPLETE;
            astate[3] = FAILED;
            $VALUES = astate;
        }

        private State(String s, int i) {
            super(s, i);
        }
    }


    public abstract void cancel();

    public abstract CharSequence getMessage();

    public abstract State getState();

    public abstract boolean isCancelable();

    public abstract boolean isUssdRequest();
}
