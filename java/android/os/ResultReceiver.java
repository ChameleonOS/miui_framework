// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;

import com.android.internal.os.IResultReceiver;

// Referenced classes of package android.os:
//            Parcelable, Parcel, RemoteException, Handler, 
//            Bundle

public class ResultReceiver
    implements Parcelable {
    class MyResultReceiver extends com.android.internal.os.IResultReceiver.Stub {

        public void send(int i, Bundle bundle) {
            if(mHandler != null)
                mHandler.post(new MyRunnable(i, bundle));
            else
                onReceiveResult(i, bundle);
        }

        final ResultReceiver this$0;

        MyResultReceiver() {
            this$0 = ResultReceiver.this;
            super();
        }
    }

    class MyRunnable
        implements Runnable {

        public void run() {
            onReceiveResult(mResultCode, mResultData);
        }

        final int mResultCode;
        final Bundle mResultData;
        final ResultReceiver this$0;

        MyRunnable(int i, Bundle bundle) {
            this$0 = ResultReceiver.this;
            super();
            mResultCode = i;
            mResultData = bundle;
        }
    }


    public ResultReceiver(Handler handler) {
        mLocal = true;
        mHandler = handler;
    }

    ResultReceiver(Parcel parcel) {
        mLocal = false;
        mHandler = null;
        mReceiver = com.android.internal.os.IResultReceiver.Stub.asInterface(parcel.readStrongBinder());
    }

    public int describeContents() {
        return 0;
    }

    protected void onReceiveResult(int i, Bundle bundle) {
    }

    public void send(int i, Bundle bundle) {
        if(!mLocal) goto _L2; else goto _L1
_L1:
        if(mHandler != null)
            mHandler.post(new MyRunnable(i, bundle));
        else
            onReceiveResult(i, bundle);
_L4:
        return;
_L2:
        if(mReceiver != null)
            try {
                mReceiver.send(i, bundle);
            }
            catch(RemoteException remoteexception) { }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void writeToParcel(Parcel parcel, int i) {
        this;
        JVM INSTR monitorenter ;
        if(mReceiver == null)
            mReceiver = new MyResultReceiver();
        parcel.writeStrongBinder(mReceiver.asBinder());
        return;
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

        public ResultReceiver createFromParcel(Parcel parcel) {
            return new ResultReceiver(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public ResultReceiver[] newArray(int i) {
            return new ResultReceiver[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    final Handler mHandler;
    final boolean mLocal;
    IResultReceiver mReceiver;

}
