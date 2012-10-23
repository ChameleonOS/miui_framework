// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;

import android.util.Log;
import java.io.PrintWriter;
import java.util.*;

// Referenced classes of package android.os:
//            IBinder, Handler, RemoteException

public abstract class TokenWatcher {
    private class Death
        implements IBinder.DeathRecipient {

        public void binderDied() {
            cleanup(token, false);
        }

        protected void finalize() throws Throwable {
            if(token != null) {
                Log.w(mTag, (new StringBuilder()).append("cleaning up leaked reference: ").append(tag).toString());
                release(token);
            }
            super.finalize();
            return;
            Exception exception;
            exception;
            super.finalize();
            throw exception;
        }

        String tag;
        final TokenWatcher this$0;
        IBinder token;

        Death(IBinder ibinder, String s) {
            this$0 = TokenWatcher.this;
            super();
            token = ibinder;
            tag = s;
        }
    }


    public TokenWatcher(Handler handler, String s) {
        mNotificationTask = new Runnable() {

            public void run() {
                int i;
                synchronized(mTokens) {
                    i = mNotificationQueue;
                    mNotificationQueue = -1;
                }
                if(i != 1) goto _L2; else goto _L1
_L1:
                acquired();
_L4:
                return;
                exception;
                weakhashmap;
                JVM INSTR monitorexit ;
                throw exception;
_L2:
                if(i == 0)
                    released();
                if(true) goto _L4; else goto _L3
_L3:
            }

            final TokenWatcher this$0;

             {
                this$0 = TokenWatcher.this;
                super();
            }
        };
        mTokens = new WeakHashMap();
        mNotificationQueue = -1;
        mAcquired = false;
        mHandler = handler;
        if(s == null)
            s = "TokenWatcher";
        mTag = s;
    }

    private ArrayList dumpInternal() {
        ArrayList arraylist = new ArrayList();
        WeakHashMap weakhashmap = mTokens;
        weakhashmap;
        JVM INSTR monitorenter ;
        Set set = mTokens.keySet();
        arraylist.add((new StringBuilder()).append("Token count: ").append(mTokens.size()).toString());
        int i = 0;
        for(Iterator iterator = set.iterator(); iterator.hasNext();) {
            IBinder ibinder = (IBinder)iterator.next();
            arraylist.add((new StringBuilder()).append("[").append(i).append("] ").append(((Death)mTokens.get(ibinder)).tag).append(" - ").append(ibinder).toString());
            i++;
        }

        return arraylist;
    }

    private void sendNotificationLocked(boolean flag) {
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        if(mNotificationQueue != -1) goto _L2; else goto _L1
_L1:
        mNotificationQueue = i;
        mHandler.post(mNotificationTask);
_L4:
        return;
_L2:
        if(mNotificationQueue != i) {
            mNotificationQueue = -1;
            mHandler.removeCallbacks(mNotificationTask);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void acquire(IBinder ibinder, String s) {
        WeakHashMap weakhashmap = mTokens;
        weakhashmap;
        JVM INSTR monitorenter ;
        int i;
        Death death;
        i = mTokens.size();
        death = new Death(ibinder, s);
        try {
            ibinder.linkToDeath(death, 0);
        }
        catch(RemoteException remoteexception) {
            break MISSING_BLOCK_LABEL_89;
        }
        mTokens.put(ibinder, death);
        if(i == 0 && !mAcquired) {
            sendNotificationLocked(true);
            mAcquired = true;
        }
        weakhashmap;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_89;
        Exception exception;
        exception;
        throw exception;
    }

    public abstract void acquired();

    public void cleanup(IBinder ibinder, boolean flag) {
        WeakHashMap weakhashmap = mTokens;
        weakhashmap;
        JVM INSTR monitorenter ;
        Death death = (Death)mTokens.remove(ibinder);
        if(flag && death != null) {
            death.token.unlinkToDeath(death, 0);
            death.token = null;
        }
        if(mTokens.size() == 0 && mAcquired) {
            sendNotificationLocked(false);
            mAcquired = false;
        }
        return;
    }

    public void dump() {
        String s;
        for(Iterator iterator = dumpInternal().iterator(); iterator.hasNext(); Log.i(mTag, s))
            s = (String)iterator.next();

    }

    public void dump(PrintWriter printwriter) {
        for(Iterator iterator = dumpInternal().iterator(); iterator.hasNext(); printwriter.println((String)iterator.next()));
    }

    public boolean isAcquired() {
        WeakHashMap weakhashmap = mTokens;
        weakhashmap;
        JVM INSTR monitorenter ;
        boolean flag = mAcquired;
        return flag;
    }

    public void release(IBinder ibinder) {
        cleanup(ibinder, true);
    }

    public abstract void released();

    private volatile boolean mAcquired;
    private Handler mHandler;
    private int mNotificationQueue;
    private Runnable mNotificationTask;
    private String mTag;
    private WeakHashMap mTokens;




/*
    static int access$102(TokenWatcher tokenwatcher, int i) {
        tokenwatcher.mNotificationQueue = i;
        return i;
    }

*/

}
