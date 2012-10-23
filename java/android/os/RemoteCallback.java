// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;


// Referenced classes of package android.os:
//            Parcelable, IRemoteCallback, RemoteException, Parcel, 
//            Handler, Bundle

public abstract class RemoteCallback
    implements Parcelable {
    static class RemoteCallbackProxy extends RemoteCallback {

        protected void onResult(Bundle bundle) {
        }

        RemoteCallbackProxy(IRemoteCallback iremotecallback) {
            super(iremotecallback);
        }
    }

    class LocalCallback extends IRemoteCallback.Stub {

        public void sendResult(Bundle bundle) {
            mHandler.post(new DeliverResult(bundle));
        }

        final RemoteCallback this$0;

        LocalCallback() {
            this$0 = RemoteCallback.this;
            super();
        }
    }

    class DeliverResult
        implements Runnable {

        public void run() {
            onResult(mResult);
        }

        final Bundle mResult;
        final RemoteCallback this$0;

        DeliverResult(Bundle bundle) {
            this$0 = RemoteCallback.this;
            super();
            mResult = bundle;
        }
    }


    public RemoteCallback(Handler handler) {
        mHandler = handler;
        mTarget = new LocalCallback();
    }

    RemoteCallback(IRemoteCallback iremotecallback) {
        mHandler = null;
        mTarget = iremotecallback;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean flag = false;
        if(obj != null) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        boolean flag1 = mTarget.asBinder().equals(((RemoteCallback)obj).mTarget.asBinder());
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        ClassCastException classcastexception;
        classcastexception;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public int hashCode() {
        return mTarget.asBinder().hashCode();
    }

    protected abstract void onResult(Bundle bundle);

    public void sendResult(Bundle bundle) throws RemoteException {
        mTarget.sendResult(bundle);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(mTarget.asBinder());
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

        public RemoteCallback createFromParcel(Parcel parcel) {
            IBinder ibinder = parcel.readStrongBinder();
            RemoteCallbackProxy remotecallbackproxy;
            if(ibinder != null)
                remotecallbackproxy = new RemoteCallbackProxy(IRemoteCallback.Stub.asInterface(ibinder));
            else
                remotecallbackproxy = null;
            return remotecallbackproxy;
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public RemoteCallback[] newArray(int i) {
            return new RemoteCallback[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    final Handler mHandler;
    final IRemoteCallback mTarget;

}
