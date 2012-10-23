// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;

import java.lang.ref.WeakReference;

// Referenced classes of package android.os:
//            Handler, Message, AsyncResult

public class Registrant {

    public Registrant(Handler handler, int i, Object obj) {
        refH = new WeakReference(handler);
        what = i;
        userObj = obj;
    }

    public void clear() {
        refH = null;
        userObj = null;
    }

    public Handler getHandler() {
        Handler handler;
        if(refH == null)
            handler = null;
        else
            handler = (Handler)refH.get();
        return handler;
    }

    void internalNotifyRegistrant(Object obj, Throwable throwable) {
        Handler handler = getHandler();
        if(handler == null) {
            clear();
        } else {
            Message message = Message.obtain();
            message.what = what;
            message.obj = new AsyncResult(userObj, obj, throwable);
            handler.sendMessage(message);
        }
    }

    public Message messageForRegistrant() {
        Handler handler = getHandler();
        Message message;
        if(handler == null) {
            clear();
            message = null;
        } else {
            message = handler.obtainMessage();
            message.what = what;
            message.obj = userObj;
        }
        return message;
    }

    public void notifyException(Throwable throwable) {
        internalNotifyRegistrant(null, throwable);
    }

    public void notifyRegistrant() {
        internalNotifyRegistrant(null, null);
    }

    public void notifyRegistrant(AsyncResult asyncresult) {
        internalNotifyRegistrant(asyncresult.result, asyncresult.exception);
    }

    public void notifyResult(Object obj) {
        internalNotifyRegistrant(obj, null);
    }

    WeakReference refH;
    Object userObj;
    int what;
}
