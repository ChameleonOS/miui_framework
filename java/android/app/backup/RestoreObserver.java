// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app.backup;


// Referenced classes of package android.app.backup:
//            RestoreSet

public abstract class RestoreObserver {

    public RestoreObserver() {
    }

    public void onUpdate(int i, String s) {
    }

    public void restoreFinished(int i) {
    }

    public void restoreSetsAvailable(RestoreSet arestoreset[]) {
    }

    public void restoreStarting(int i) {
    }
}
