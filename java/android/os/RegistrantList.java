// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;

import java.util.ArrayList;

// Referenced classes of package android.os:
//            Registrant, AsyncResult, Handler

public class RegistrantList {

    public RegistrantList() {
        registrants = new ArrayList();
    }

    /**
     * @deprecated Method internalNotifyRegistrants is deprecated
     */

    private void internalNotifyRegistrants(Object obj, Throwable throwable) {
        this;
        JVM INSTR monitorenter ;
        int i = 0;
        int j = registrants.size();
_L1:
        if(i >= j)
            break MISSING_BLOCK_LABEL_41;
        ((Registrant)registrants.get(i)).internalNotifyRegistrant(obj, throwable);
        i++;
          goto _L1
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method add is deprecated
     */

    public void add(Handler handler, int i, Object obj) {
        this;
        JVM INSTR monitorenter ;
        add(new Registrant(handler, i, obj));
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method add is deprecated
     */

    public void add(Registrant registrant) {
        this;
        JVM INSTR monitorenter ;
        removeCleared();
        registrants.add(registrant);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method addUnique is deprecated
     */

    public void addUnique(Handler handler, int i, Object obj) {
        this;
        JVM INSTR monitorenter ;
        remove(handler);
        add(new Registrant(handler, i, obj));
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method get is deprecated
     */

    public Object get(int i) {
        this;
        JVM INSTR monitorenter ;
        Object obj = registrants.get(i);
        this;
        JVM INSTR monitorexit ;
        return obj;
        Exception exception;
        exception;
        throw exception;
    }

    public void notifyException(Throwable throwable) {
        internalNotifyRegistrants(null, throwable);
    }

    public void notifyRegistrants() {
        internalNotifyRegistrants(null, null);
    }

    public void notifyRegistrants(AsyncResult asyncresult) {
        internalNotifyRegistrants(asyncresult.result, asyncresult.exception);
    }

    public void notifyResult(Object obj) {
        internalNotifyRegistrants(obj, null);
    }

    /**
     * @deprecated Method remove is deprecated
     */

    public void remove(Handler handler) {
        this;
        JVM INSTR monitorenter ;
        int i = 0;
        Exception exception;
        for(int j = registrants.size(); i < j; i++) {
            Registrant registrant = (Registrant)registrants.get(i);
            Handler handler1 = registrant.getHandler();
            if(handler1 == null || handler1 == handler)
                registrant.clear();
            break MISSING_BLOCK_LABEL_70;
        }

        removeCleared();
        this;
        JVM INSTR monitorexit ;
        return;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method removeCleared is deprecated
     */

    public void removeCleared() {
        this;
        JVM INSTR monitorenter ;
        int i = -1 + registrants.size();
_L1:
        if(i < 0)
            break MISSING_BLOCK_LABEL_49;
        if(((Registrant)registrants.get(i)).refH == null)
            registrants.remove(i);
        i--;
          goto _L1
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method size is deprecated
     */

    public int size() {
        this;
        JVM INSTR monitorenter ;
        int i = registrants.size();
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    ArrayList registrants;
}
