// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;

import android.util.TimeUtils;

// Referenced classes of package android.os:
//            Parcelable, Bundle, Parcel, Messenger, 
//            Handler, SystemClock

public final class Message
    implements Parcelable {

    public Message() {
    }

    public static Message obtain() {
        Message message;
        synchronized(sPoolSync) {
            if(sPool != null) {
                message = sPool;
                sPool = message.next;
                message.next = null;
                sPoolSize = -1 + sPoolSize;
                break MISSING_BLOCK_LABEL_60;
            }
        }
        message = new Message();
          goto _L1
        exception;
        obj1;
        JVM INSTR monitorexit ;
        throw exception;
_L1:
        return message;
    }

    public static Message obtain(Handler handler) {
        Message message = obtain();
        message.target = handler;
        return message;
    }

    public static Message obtain(Handler handler, int i) {
        Message message = obtain();
        message.target = handler;
        message.what = i;
        return message;
    }

    public static Message obtain(Handler handler, int i, int j, int k) {
        Message message = obtain();
        message.target = handler;
        message.what = i;
        message.arg1 = j;
        message.arg2 = k;
        return message;
    }

    public static Message obtain(Handler handler, int i, int j, int k, Object obj1) {
        Message message = obtain();
        message.target = handler;
        message.what = i;
        message.arg1 = j;
        message.arg2 = k;
        message.obj = obj1;
        return message;
    }

    public static Message obtain(Handler handler, int i, Object obj1) {
        Message message = obtain();
        message.target = handler;
        message.what = i;
        message.obj = obj1;
        return message;
    }

    public static Message obtain(Handler handler, Runnable runnable) {
        Message message = obtain();
        message.target = handler;
        message.callback = runnable;
        return message;
    }

    public static Message obtain(Message message) {
        Message message1 = obtain();
        message1.what = message.what;
        message1.arg1 = message.arg1;
        message1.arg2 = message.arg2;
        message1.obj = message.obj;
        message1.replyTo = message.replyTo;
        if(message.data != null)
            message1.data = new Bundle(message.data);
        message1.target = message.target;
        message1.callback = message.callback;
        return message1;
    }

    private void readFromParcel(Parcel parcel) {
        what = parcel.readInt();
        arg1 = parcel.readInt();
        arg2 = parcel.readInt();
        if(parcel.readInt() != 0)
            obj = parcel.readParcelable(getClass().getClassLoader());
        when = parcel.readLong();
        data = parcel.readBundle();
        replyTo = Messenger.readMessengerOrNullFromParcel(parcel);
    }

    void clearForRecycle() {
        flags = 0;
        what = 0;
        arg1 = 0;
        arg2 = 0;
        obj = null;
        replyTo = null;
        when = 0L;
        target = null;
        callback = null;
        data = null;
    }

    public void copyFrom(Message message) {
        flags = -2 & message.flags;
        what = message.what;
        arg1 = message.arg1;
        arg2 = message.arg2;
        obj = message.obj;
        replyTo = message.replyTo;
        if(message.data != null)
            data = (Bundle)message.data.clone();
        else
            data = null;
    }

    public int describeContents() {
        return 0;
    }

    public Runnable getCallback() {
        return callback;
    }

    public Bundle getData() {
        if(data == null)
            data = new Bundle();
        return data;
    }

    public Handler getTarget() {
        return target;
    }

    public long getWhen() {
        return when;
    }

    public boolean isAsynchronous() {
        boolean flag;
        if((2 & flags) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    boolean isInUse() {
        boolean flag = true;
        if((1 & flags) != flag)
            flag = false;
        return flag;
    }

    void markInUse() {
        flags = 1 | flags;
    }

    public Bundle peekData() {
        return data;
    }

    public void recycle() {
        clearForRecycle();
        Object obj1 = sPoolSync;
        obj1;
        JVM INSTR monitorenter ;
        if(sPoolSize < 50) {
            next = sPool;
            sPool = this;
            sPoolSize = 1 + sPoolSize;
        }
        return;
    }

    public void sendToTarget() {
        target.sendMessage(this);
    }

    public void setAsynchronous(boolean flag) {
        if(flag)
            flags = 2 | flags;
        else
            flags = -3 & flags;
    }

    public void setData(Bundle bundle) {
        data = bundle;
    }

    public void setTarget(Handler handler) {
        target = handler;
    }

    public String toString() {
        return toString(SystemClock.uptimeMillis());
    }

    String toString(long l) {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("{ what=");
        stringbuilder.append(what);
        stringbuilder.append(" when=");
        TimeUtils.formatDuration(when - l, stringbuilder);
        if(arg1 != 0) {
            stringbuilder.append(" arg1=");
            stringbuilder.append(arg1);
        }
        if(arg2 != 0) {
            stringbuilder.append(" arg2=");
            stringbuilder.append(arg2);
        }
        if(obj != null) {
            stringbuilder.append(" obj=");
            stringbuilder.append(obj);
        }
        stringbuilder.append(" }");
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        if(callback != null)
            throw new RuntimeException("Can't marshal callbacks across processes.");
        parcel.writeInt(what);
        parcel.writeInt(arg1);
        parcel.writeInt(arg2);
        if(obj != null)
            try {
                Parcelable parcelable = (Parcelable)obj;
                parcel.writeInt(1);
                parcel.writeParcelable(parcelable, i);
            }
            catch(ClassCastException classcastexception) {
                throw new RuntimeException("Can't marshal non-Parcelable objects across processes.");
            }
        else
            parcel.writeInt(0);
        parcel.writeLong(when);
        parcel.writeBundle(data);
        Messenger.writeMessengerOrNullToParcel(replyTo, parcel);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

        public Message createFromParcel(Parcel parcel) {
            Message message = Message.obtain();
            message.readFromParcel(parcel);
            return message;
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public Message[] newArray(int i) {
            return new Message[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    static final int FLAGS_TO_CLEAR_ON_COPY_FROM = 1;
    static final int FLAG_ASYNCHRONOUS = 2;
    static final int FLAG_IN_USE = 1;
    private static final int MAX_POOL_SIZE = 50;
    private static Message sPool;
    private static int sPoolSize = 0;
    private static final Object sPoolSync = new Object();
    public int arg1;
    public int arg2;
    Runnable callback;
    Bundle data;
    int flags;
    Message next;
    public Object obj;
    public Messenger replyTo;
    Handler target;
    public int what;
    long when;


}
