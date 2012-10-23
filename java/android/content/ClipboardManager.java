// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import java.util.ArrayList;

// Referenced classes of package android.content:
//            IClipboard, Context, ClipData, ClipDescription

public class ClipboardManager extends android.text.ClipboardManager {
    public static interface OnPrimaryClipChangedListener {

        public abstract void onPrimaryClipChanged();
    }


    public ClipboardManager(Context context, Handler handler) {
        mContext = context;
    }

    private static IClipboard getService() {
        Object obj = sStaticLock;
        obj;
        JVM INSTR monitorenter ;
        IClipboard iclipboard;
        if(sService != null) {
            iclipboard = sService;
        } else {
            sService = IClipboard.Stub.asInterface(ServiceManager.getService("clipboard"));
            iclipboard = sService;
        }
        return iclipboard;
    }

    public void addPrimaryClipChangedListener(OnPrimaryClipChangedListener onprimaryclipchangedlistener) {
        ArrayList arraylist = mPrimaryClipChangedListeners;
        arraylist;
        JVM INSTR monitorenter ;
        int i = mPrimaryClipChangedListeners.size();
        Exception exception;
        if(i == 0)
            try {
                getService().addPrimaryClipChangedListener(mPrimaryClipChangedServiceListener);
            }
            catch(RemoteException remoteexception) { }
            finally {
                arraylist;
            }
        mPrimaryClipChangedListeners.add(onprimaryclipchangedlistener);
        arraylist;
        JVM INSTR monitorexit ;
        return;
        throw exception;
    }

    public ClipData getPrimaryClip() {
        ClipData clipdata1 = getService().getPrimaryClip(mContext.getPackageName());
        ClipData clipdata = clipdata1;
_L2:
        return clipdata;
        RemoteException remoteexception;
        remoteexception;
        clipdata = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public ClipDescription getPrimaryClipDescription() {
        ClipDescription clipdescription1 = getService().getPrimaryClipDescription();
        ClipDescription clipdescription = clipdescription1;
_L2:
        return clipdescription;
        RemoteException remoteexception;
        remoteexception;
        clipdescription = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public CharSequence getText() {
        ClipData clipdata = getPrimaryClip();
        CharSequence charsequence;
        if(clipdata != null && clipdata.getItemCount() > 0)
            charsequence = clipdata.getItemAt(0).coerceToText(mContext);
        else
            charsequence = null;
        return charsequence;
    }

    public boolean hasPrimaryClip() {
        boolean flag1 = getService().hasPrimaryClip();
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean hasText() {
        boolean flag1 = getService().hasClipboardText();
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void removePrimaryClipChangedListener(OnPrimaryClipChangedListener onprimaryclipchangedlistener) {
        ArrayList arraylist = mPrimaryClipChangedListeners;
        arraylist;
        JVM INSTR monitorenter ;
        int i;
        mPrimaryClipChangedListeners.remove(onprimaryclipchangedlistener);
        i = mPrimaryClipChangedListeners.size();
        Exception exception;
        if(i == 0)
            try {
                getService().removePrimaryClipChangedListener(mPrimaryClipChangedServiceListener);
            }
            catch(RemoteException remoteexception) { }
            finally {
                arraylist;
            }
        arraylist;
        JVM INSTR monitorexit ;
        return;
        throw exception;
    }

    void reportPrimaryClipChanged() {
        Object aobj[];
        synchronized(mPrimaryClipChangedListeners) {
            if(mPrimaryClipChangedListeners.size() <= 0)
                break MISSING_BLOCK_LABEL_65;
            aobj = mPrimaryClipChangedListeners.toArray();
        }
        for(int i = 0; i < aobj.length; i++)
            ((OnPrimaryClipChangedListener)aobj[i]).onPrimaryClipChanged();

          goto _L1
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
_L1:
    }

    public void setPrimaryClip(ClipData clipdata) {
        getService().setPrimaryClip(clipdata);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void setText(CharSequence charsequence) {
        setPrimaryClip(ClipData.newPlainText(null, charsequence));
    }

    static final int MSG_REPORT_PRIMARY_CLIP_CHANGED = 1;
    private static IClipboard sService;
    private static final Object sStaticLock = new Object();
    private final Context mContext;
    private final Handler mHandler = new Handler() {

        public void handleMessage(Message message) {
            message.what;
            JVM INSTR tableswitch 1 1: default 24
        //                       1 25;
               goto _L1 _L2
_L1:
            return;
_L2:
            reportPrimaryClipChanged();
            if(true) goto _L1; else goto _L3
_L3:
        }

        final ClipboardManager this$0;

             {
                this$0 = ClipboardManager.this;
                super();
            }
    };
    private final ArrayList mPrimaryClipChangedListeners = new ArrayList();
    private final IOnPrimaryClipChangedListener.Stub mPrimaryClipChangedServiceListener = new IOnPrimaryClipChangedListener.Stub() {

        public void dispatchPrimaryClipChanged() {
            mHandler.sendEmptyMessage(1);
        }

        final ClipboardManager this$0;

             {
                this$0 = ClipboardManager.this;
                super();
            }
    };


}
