// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.mtp;


// Referenced classes of package android.mtp:
//            MtpStorage, MtpDatabase

public class MtpServer
    implements Runnable {

    public MtpServer(MtpDatabase mtpdatabase, boolean flag) {
        native_setup(mtpdatabase, flag);
    }

    private final native void native_add_storage(MtpStorage mtpstorage);

    private final native void native_cleanup();

    private final native void native_remove_storage(int i);

    private final native void native_run();

    private final native void native_send_object_added(int i);

    private final native void native_send_object_removed(int i);

    private final native void native_setup(MtpDatabase mtpdatabase, boolean flag);

    public void addStorage(MtpStorage mtpstorage) {
        native_add_storage(mtpstorage);
    }

    public void removeStorage(MtpStorage mtpstorage) {
        native_remove_storage(mtpstorage.getStorageId());
    }

    public void run() {
        native_run();
        native_cleanup();
    }

    public void sendObjectAdded(int i) {
        native_send_object_added(i);
    }

    public void sendObjectRemoved(int i) {
        native_send_object_removed(i);
    }

    public void start() {
        (new Thread(this, "MtpServer")).start();
    }

    private int mNativeContext;

    static  {
        System.loadLibrary("media_jni");
    }
}
