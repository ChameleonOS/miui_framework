// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.app.ActivityManagerNative;
import android.app.IActivityManager;
import android.os.*;
import android.util.AndroidException;

// Referenced classes of package android.content:
//            IIntentSender, Context, Intent

public class IntentSender
    implements Parcelable {
    private static class FinishedDispatcher extends IIntentReceiver.Stub
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
            mWho.onSendFinished(mIntentSender, mIntent, mResultCode, mResultData, mResultExtras);
        }

        private final Handler mHandler;
        private Intent mIntent;
        private final IntentSender mIntentSender;
        private int mResultCode;
        private String mResultData;
        private Bundle mResultExtras;
        private final OnFinished mWho;

        FinishedDispatcher(IntentSender intentsender, OnFinished onfinished, Handler handler) {
            mIntentSender = intentsender;
            mWho = onfinished;
            mHandler = handler;
        }
    }

    public static interface OnFinished {

        public abstract void onSendFinished(IntentSender intentsender, Intent intent, int i, String s, Bundle bundle);
    }

    public static class SendIntentException extends AndroidException {

        public SendIntentException() {
        }

        public SendIntentException(Exception exception) {
            super(exception);
        }

        public SendIntentException(String s) {
            super(s);
        }
    }


    public IntentSender(IIntentSender iintentsender) {
        mTarget = iintentsender;
    }

    public IntentSender(IBinder ibinder) {
        mTarget = IIntentSender.Stub.asInterface(ibinder);
    }

    public static IntentSender readIntentSenderOrNullFromParcel(Parcel parcel) {
        IBinder ibinder = parcel.readStrongBinder();
        IntentSender intentsender;
        if(ibinder != null)
            intentsender = new IntentSender(ibinder);
        else
            intentsender = null;
        return intentsender;
    }

    public static void writeIntentSenderOrNullToParcel(IntentSender intentsender, Parcel parcel) {
        IBinder ibinder;
        if(intentsender != null)
            ibinder = intentsender.mTarget.asBinder();
        else
            ibinder = null;
        parcel.writeStrongBinder(ibinder);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean flag;
        if(obj instanceof IntentSender)
            flag = mTarget.asBinder().equals(((IntentSender)obj).mTarget.asBinder());
        else
            flag = false;
        return flag;
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

    public void sendIntent(Context context, int i, Intent intent, OnFinished onfinished, Handler handler) throws SendIntentException {
        sendIntent(context, i, intent, onfinished, handler, null);
    }

    public void sendIntent(Context context, int i, Intent intent, OnFinished onfinished, Handler handler, String s) throws SendIntentException {
        FinishedDispatcher finisheddispatcher;
        finisheddispatcher = null;
        if(intent == null)
            break MISSING_BLOCK_LABEL_78;
        String s1 = intent.resolveTypeIfNeeded(context.getContentResolver());
_L1:
        IIntentSender iintentsender = mTarget;
        if(onfinished != null)
            finisheddispatcher = new FinishedDispatcher(this, onfinished, handler);
        if(iintentsender.send(i, intent, s1, finisheddispatcher, s) < 0)
            throw new SendIntentException();
        break MISSING_BLOCK_LABEL_84;
        RemoteException remoteexception;
        remoteexception;
        throw new SendIntentException();
        s1 = null;
          goto _L1
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder(128);
        stringbuilder.append("IntentSender{");
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

        public IntentSender createFromParcel(Parcel parcel) {
            IBinder ibinder = parcel.readStrongBinder();
            IntentSender intentsender;
            if(ibinder != null)
                intentsender = new IntentSender(ibinder);
            else
                intentsender = null;
            return intentsender;
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public IntentSender[] newArray(int i) {
            return new IntentSender[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private final IIntentSender mTarget;

}
