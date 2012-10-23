// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.*;
import android.os.*;
import android.util.AndroidException;

// Referenced classes of package android.app:
//            ActivityManagerNative, IActivityManager

public final class PendingIntent
    implements Parcelable {
    private static class FinishedDispatcher extends android.content.IIntentReceiver.Stub
        implements Runnable {

        public void performReceive(Intent intent, int i, String s, Bundle bundle, boolean flag, boolean flag1) {
            mIntent = intent;
            mResultCode = i;
            mResultData = s;
            mResultExtras = bundle;
            if(mHandler == null)
                run();
            else
                mHandler.post(this);
        }

        public void run() {
            mWho.onSendFinished(mPendingIntent, mIntent, mResultCode, mResultData, mResultExtras);
        }

        private final Handler mHandler;
        private Intent mIntent;
        private final PendingIntent mPendingIntent;
        private int mResultCode;
        private String mResultData;
        private Bundle mResultExtras;
        private final OnFinished mWho;

        FinishedDispatcher(PendingIntent pendingintent, OnFinished onfinished, Handler handler) {
            mPendingIntent = pendingintent;
            mWho = onfinished;
            mHandler = handler;
        }
    }

    public static interface OnFinished {

        public abstract void onSendFinished(PendingIntent pendingintent, Intent intent, int i, String s, Bundle bundle);
    }

    public static class CanceledException extends AndroidException {

        public CanceledException() {
        }

        public CanceledException(Exception exception) {
            super(exception);
        }

        public CanceledException(String s) {
            super(s);
        }
    }


    PendingIntent(IIntentSender iintentsender) {
        mTarget = iintentsender;
    }

    PendingIntent(IBinder ibinder) {
        mTarget = android.content.IIntentSender.Stub.asInterface(ibinder);
    }

    public static PendingIntent getActivities(Context context, int i, Intent aintent[], int j) {
        return getActivities(context, i, aintent, j, null);
    }

    public static PendingIntent getActivities(Context context, int i, Intent aintent[], int j, Bundle bundle) {
        String s;
        String as[];
        s = context.getPackageName();
        as = new String[aintent.length];
        for(int k = 0; k < aintent.length; k++) {
            aintent[k].setAllowFds(false);
            as[k] = aintent[k].resolveTypeIfNeeded(context.getContentResolver());
        }

        IIntentSender iintentsender = ActivityManagerNative.getDefault().getIntentSender(2, s, null, null, i, aintent, as, j, bundle);
        if(iintentsender == null) goto _L2; else goto _L1
_L1:
        PendingIntent pendingintent = new PendingIntent(iintentsender);
_L4:
        return pendingintent;
_L2:
        pendingintent = null;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        pendingintent = null;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static PendingIntent getActivity(Context context, int i, Intent intent, int j) {
        return getActivity(context, i, intent, j, null);
    }

    public static PendingIntent getActivity(Context context, int i, Intent intent, int j, Bundle bundle) {
        PendingIntent pendingintent;
        String as[];
        String s = context.getPackageName();
        String s1;
        IActivityManager iactivitymanager;
        Intent aintent[];
        IIntentSender iintentsender;
        if(intent != null)
            s1 = intent.resolveTypeIfNeeded(context.getContentResolver());
        else
            s1 = null;
        intent.setAllowFds(false);
        iactivitymanager = ActivityManagerNative.getDefault();
        aintent = new Intent[1];
        aintent[0] = intent;
        if(s1 == null) goto _L2; else goto _L1
_L1:
        as = new String[1];
        as[0] = s1;
_L5:
        iintentsender = iactivitymanager.getIntentSender(2, s, null, null, i, aintent, as, j, bundle);
        if(iintentsender == null) goto _L4; else goto _L3
_L3:
        pendingintent = new PendingIntent(iintentsender);
_L6:
        return pendingintent;
_L2:
        as = null;
          goto _L5
_L4:
        pendingintent = null;
          goto _L6
        RemoteException remoteexception;
        remoteexception;
        pendingintent = null;
          goto _L6
    }

    public static PendingIntent getBroadcast(Context context, int i, Intent intent, int j) {
        PendingIntent pendingintent;
        String as[];
        String s = context.getPackageName();
        String s1;
        IActivityManager iactivitymanager;
        Intent aintent[];
        IIntentSender iintentsender;
        if(intent != null)
            s1 = intent.resolveTypeIfNeeded(context.getContentResolver());
        else
            s1 = null;
        intent.setAllowFds(false);
        iactivitymanager = ActivityManagerNative.getDefault();
        aintent = new Intent[1];
        aintent[0] = intent;
        if(s1 == null) goto _L2; else goto _L1
_L1:
        as = new String[1];
        as[0] = s1;
_L5:
        iintentsender = iactivitymanager.getIntentSender(1, s, null, null, i, aintent, as, j, null);
        if(iintentsender == null) goto _L4; else goto _L3
_L3:
        pendingintent = new PendingIntent(iintentsender);
_L6:
        return pendingintent;
_L2:
        as = null;
          goto _L5
_L4:
        pendingintent = null;
          goto _L6
        RemoteException remoteexception;
        remoteexception;
        pendingintent = null;
          goto _L6
    }

    public static PendingIntent getService(Context context, int i, Intent intent, int j) {
        PendingIntent pendingintent;
        String as[];
        String s = context.getPackageName();
        String s1;
        IActivityManager iactivitymanager;
        Intent aintent[];
        IIntentSender iintentsender;
        if(intent != null)
            s1 = intent.resolveTypeIfNeeded(context.getContentResolver());
        else
            s1 = null;
        intent.setAllowFds(false);
        iactivitymanager = ActivityManagerNative.getDefault();
        aintent = new Intent[1];
        aintent[0] = intent;
        if(s1 == null) goto _L2; else goto _L1
_L1:
        as = new String[1];
        as[0] = s1;
_L5:
        iintentsender = iactivitymanager.getIntentSender(4, s, null, null, i, aintent, as, j, null);
        if(iintentsender == null) goto _L4; else goto _L3
_L3:
        pendingintent = new PendingIntent(iintentsender);
_L6:
        return pendingintent;
_L2:
        as = null;
          goto _L5
_L4:
        pendingintent = null;
          goto _L6
        RemoteException remoteexception;
        remoteexception;
        pendingintent = null;
          goto _L6
    }

    public static PendingIntent readPendingIntentOrNullFromParcel(Parcel parcel) {
        IBinder ibinder = parcel.readStrongBinder();
        PendingIntent pendingintent;
        if(ibinder != null)
            pendingintent = new PendingIntent(ibinder);
        else
            pendingintent = null;
        return pendingintent;
    }

    public static void writePendingIntentOrNullToParcel(PendingIntent pendingintent, Parcel parcel) {
        IBinder ibinder;
        if(pendingintent != null)
            ibinder = pendingintent.mTarget.asBinder();
        else
            ibinder = null;
        parcel.writeStrongBinder(ibinder);
    }

    public void cancel() {
        ActivityManagerNative.getDefault().cancelIntentSender(mTarget);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean flag;
        if(obj instanceof PendingIntent)
            flag = mTarget.asBinder().equals(((PendingIntent)obj).mTarget.asBinder());
        else
            flag = false;
        return flag;
    }

    public IntentSender getIntentSender() {
        return new IntentSender(mTarget);
    }

    public IIntentSender getTarget() {
        return mTarget;
    }

    public String getTargetPackage() {
        String s1 = ActivityManagerNative.getDefault().getPackageForIntentSender(mTarget);
        String s = s1;
_L2:
        return s;
        RemoteException remoteexception;
        remoteexception;
        s = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int hashCode() {
        return mTarget.asBinder().hashCode();
    }

    public boolean isActivity() {
        boolean flag1 = ActivityManagerNative.getDefault().isIntentSenderAnActivity(mTarget);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean isTargetedToPackage() {
        boolean flag1 = ActivityManagerNative.getDefault().isIntentSenderTargetedToPackage(mTarget);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void send() throws CanceledException {
        send(null, 0, null, null, null, null);
    }

    public void send(int i) throws CanceledException {
        send(null, i, null, null, null, null);
    }

    public void send(int i, OnFinished onfinished, Handler handler) throws CanceledException {
        send(null, i, null, onfinished, handler, null);
    }

    public void send(Context context, int i, Intent intent) throws CanceledException {
        send(context, i, intent, null, null, null);
    }

    public void send(Context context, int i, Intent intent, OnFinished onfinished, Handler handler) throws CanceledException {
        send(context, i, intent, onfinished, handler, null);
    }

    public void send(Context context, int i, Intent intent, OnFinished onfinished, Handler handler, String s) throws CanceledException {
        FinishedDispatcher finisheddispatcher;
        finisheddispatcher = null;
        if(intent == null)
            break MISSING_BLOCK_LABEL_80;
        String s1 = intent.resolveTypeIfNeeded(context.getContentResolver());
_L1:
        IIntentSender iintentsender = mTarget;
        if(onfinished != null)
            finisheddispatcher = new FinishedDispatcher(this, onfinished, handler);
        if(iintentsender.send(i, intent, s1, finisheddispatcher, s) < 0)
            throw new CanceledException();
        break MISSING_BLOCK_LABEL_86;
        RemoteException remoteexception;
        remoteexception;
        throw new CanceledException(remoteexception);
        s1 = null;
          goto _L1
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder(128);
        stringbuilder.append("PendingIntent{");
        stringbuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringbuilder.append(": ");
        IBinder ibinder;
        if(mTarget != null)
            ibinder = mTarget.asBinder();
        else
            ibinder = null;
        stringbuilder.append(ibinder);
        stringbuilder.append('}');
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(mTarget.asBinder());
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public PendingIntent createFromParcel(Parcel parcel) {
            IBinder ibinder = parcel.readStrongBinder();
            PendingIntent pendingintent;
            if(ibinder != null)
                pendingintent = new PendingIntent(ibinder);
            else
                pendingintent = null;
            return pendingintent;
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public PendingIntent[] newArray(int i) {
            return new PendingIntent[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int FLAG_CANCEL_CURRENT = 0x10000000;
    public static final int FLAG_NO_CREATE = 0x20000000;
    public static final int FLAG_ONE_SHOT = 0x40000000;
    public static final int FLAG_UPDATE_CURRENT = 0x8000000;
    private final IIntentSender mTarget;

}
