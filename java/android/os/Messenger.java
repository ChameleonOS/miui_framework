// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;


// Referenced classes of package android.os:
//            Parcelable, Handler, Parcel, IMessenger, 
//            RemoteException, IBinder, Message

public final class Messenger
    implements Parcelable {

    public Messenger(Handler handler) {
        mTarget = handler.getIMessenger();
    }

    public Messenger(IBinder ibinder) {
        mTarget = IMessenger.Stub.asInterface(ibinder);
    }

    public static Messenger readMessengerOrNullFromParcel(Parcel parcel) {
        IBinder ibinder = parcel.readStrongBinder();
        Messenger messenger;
        if(ibinder != null)
            messenger = new Messenger(ibinder);
        else
            messenger = null;
        return messenger;
    }

    public static void writeMessengerOrNullToParcel(Messenger messenger, Parcel parcel) {
        IBinder ibinder;
        if(messenger != null)
            ibinder = messenger.mTarget.asBinder();
        else
            ibinder = null;
        parcel.writeStrongBinder(ibinder);
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
        boolean flag1 = mTarget.asBinder().equals(((Messenger)obj).mTarget.asBinder());
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        ClassCastException classcastexception;
        classcastexception;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public IBinder getBinder() {
        return mTarget.asBinder();
    }

    public int hashCode() {
        return mTarget.asBinder().hashCode();
    }

    public void send(Message message) throws RemoteException {
        mTarget.send(message);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(mTarget.asBinder());
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

        public Messenger createFromParcel(Parcel parcel) {
            IBinder ibinder = parcel.readStrongBinder();
            Messenger messenger;
            if(ibinder != null)
                messenger = new Messenger(ibinder);
            else
                messenger = null;
            return messenger;
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public Messenger[] newArray(int i) {
            return new Messenger[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private final IMessenger mTarget;

}
