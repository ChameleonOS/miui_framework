// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;


// Referenced classes of package android.os:
//            Message

public class AsyncResult {

    public AsyncResult(Object obj, Object obj1, Throwable throwable) {
        userObj = obj;
        result = obj1;
        exception = throwable;
    }

    public static AsyncResult forMessage(Message message) {
        AsyncResult asyncresult = new AsyncResult(message.obj, null, null);
        message.obj = asyncresult;
        return asyncresult;
    }

    public static AsyncResult forMessage(Message message, Object obj, Throwable throwable) {
        AsyncResult asyncresult = new AsyncResult(message.obj, obj, throwable);
        message.obj = asyncresult;
        return asyncresult;
    }

    public Throwable exception;
    public Object result;
    public Object userObj;
}
