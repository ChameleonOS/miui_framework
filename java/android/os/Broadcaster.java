// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;

import java.io.PrintStream;

// Referenced classes of package android.os:
//            Message, Handler

public class Broadcaster {
    private class Registration {

        Registration next;
        Registration prev;
        int senderWhat;
        int targetWhats[];
        Handler targets[];
        final Broadcaster this$0;

        private Registration() {
            this$0 = Broadcaster.this;
            super();
        }

    }


    public Broadcaster() {
    }

    public void broadcast(Message message) {
        this;
        JVM INSTR monitorenter ;
        if(mReg != null) goto _L2; else goto _L1
_L2:
        int i;
        Registration registration;
        Registration registration1;
        i = message.what;
        registration = mReg;
        registration1 = registration;
_L5:
        if(registration1.senderWhat < i) goto _L4; else goto _L3
_L3:
        if(registration1.senderWhat == i) {
            Handler ahandler[] = registration1.targets;
            int ai[] = registration1.targetWhats;
            int j = ahandler.length;
            for(int k = 0; k < j; k++) {
                Handler handler = ahandler[k];
                Message message1 = Message.obtain();
                message1.copyFrom(message);
                message1.what = ai[k];
                handler.sendMessage(message1);
            }

        }
          goto _L1
_L4:
        registration1 = registration1.next;
        if(registration1 != registration) goto _L5; else goto _L3
_L1:
    }

    public void cancelRequest(int i, Handler handler, int j) {
        this;
        JVM INSTR monitorenter ;
        Registration registration;
        Registration registration1;
        registration = mReg;
        registration1 = registration;
        if(registration1 == null)
            break MISSING_BLOCK_LABEL_229;
_L8:
        if(registration1.senderWhat < i) goto _L2; else goto _L1
_L1:
        if(registration1.senderWhat != i) goto _L4; else goto _L3
_L3:
        Handler ahandler[];
        int ai[];
        int k;
        int l;
        ahandler = registration1.targets;
        ai = registration1.targetWhats;
        k = ahandler.length;
        l = 0;
_L9:
        if(l >= k) goto _L4; else goto _L5
_L5:
        if(ahandler[l] != handler || ai[l] != j) goto _L7; else goto _L6
_L6:
        registration1.targets = new Handler[k - 1];
        registration1.targetWhats = new int[k - 1];
        if(l > 0) {
            System.arraycopy(ahandler, 0, registration1.targets, 0, l);
            System.arraycopy(ai, 0, registration1.targetWhats, 0, l);
        }
        int i1 = -1 + (k - l);
        if(i1 != 0) {
            System.arraycopy(ahandler, l + 1, registration1.targets, l, i1);
            System.arraycopy(ai, l + 1, registration1.targetWhats, l, i1);
        }
_L4:
        this;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_229;
        Exception exception;
        exception;
        throw exception;
_L2:
        registration1 = registration1.next;
        if(registration1 != registration) goto _L8; else goto _L1
_L7:
        l++;
          goto _L9
    }

    public void dumpRegistrations() {
        this;
        JVM INSTR monitorenter ;
        Registration registration = mReg;
        System.out.println((new StringBuilder()).append("Broadcaster ").append(this).append(" {").toString());
        if(registration != null) {
            Registration registration1 = registration;
            do {
                System.out.println((new StringBuilder()).append("    senderWhat=").append(registration1.senderWhat).toString());
                int i = registration1.targets.length;
                for(int j = 0; j < i; j++)
                    System.out.println((new StringBuilder()).append("        [").append(registration1.targetWhats[j]).append("] ").append(registration1.targets[j]).toString());

                registration1 = registration1.next;
            } while(registration1 != registration);
        }
        System.out.println("}");
        return;
    }

    public void request(int i, Handler handler, int j) {
        this;
        JVM INSTR monitorenter ;
        if(mReg != null) goto _L2; else goto _L1
_L1:
        Registration registration = new Registration();
        registration.senderWhat = i;
        registration.targets = new Handler[1];
        registration.targetWhats = new int[1];
        registration.targets[0] = handler;
        registration.targetWhats[0] = j;
        mReg = registration;
        registration.next = registration;
        registration.prev = registration;
_L9:
        this;
        JVM INSTR monitorexit ;
          goto _L3
_L2:
        Registration registration1;
        Registration registration2;
        registration1 = mReg;
        registration2 = registration1;
_L10:
        if(registration2.senderWhat < i) goto _L5; else goto _L4
_L4:
        if(registration2.senderWhat == i) goto _L7; else goto _L6
_L6:
        Registration registration3;
        registration3 = new Registration();
        registration3.senderWhat = i;
        registration3.targets = new Handler[1];
        registration3.targetWhats = new int[1];
        registration3.next = registration2;
        registration3.prev = registration2.prev;
        registration2.prev.next = registration3;
        registration2.prev = registration3;
        if(registration2 == mReg && registration2.senderWhat > registration3.senderWhat)
            mReg = registration3;
          goto _L8
_L13:
        int k;
        registration2.targets[k] = handler;
        registration2.targetWhats[k] = j;
          goto _L9
_L14:
        this;
        JVM INSTR monitorexit ;
        Exception exception;
        throw exception;
_L5:
        registration2 = registration2.next;
        if(registration2 != registration1) goto _L10; else goto _L4
_L7:
        Handler ahandler[];
        int ai[];
        int l;
        k = registration2.targets.length;
        ahandler = registration2.targets;
        ai = registration2.targetWhats;
        l = 0;
_L15:
        if(l >= k) goto _L12; else goto _L11
_L11:
        if(ahandler[l] != handler || ai[l] != j)
            break MISSING_BLOCK_LABEL_384;
        this;
        JVM INSTR monitorexit ;
          goto _L3
_L12:
        registration2.targets = new Handler[k + 1];
        System.arraycopy(ahandler, 0, registration2.targets, 0, k);
        registration2.targetWhats = new int[k + 1];
        System.arraycopy(ai, 0, registration2.targetWhats, 0, k);
          goto _L13
        exception;
          goto _L14
_L3:
        return;
_L8:
        registration2 = registration3;
        k = 0;
          goto _L13
        exception;
          goto _L14
        l++;
          goto _L15
    }

    private Registration mReg;
}
