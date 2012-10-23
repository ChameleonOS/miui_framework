// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.database;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package android.database:
//            Observable, ContentObserver

public class ContentObservable extends Observable {

    public ContentObservable() {
    }

    public void dispatchChange(boolean flag) {
        dispatchChange(flag, null);
    }

    public void dispatchChange(boolean flag, Uri uri) {
        ArrayList arraylist = super.mObservers;
        arraylist;
        JVM INSTR monitorenter ;
        Iterator iterator = super.mObservers.iterator();
        do {
            if(!iterator.hasNext())
                break;
            ContentObserver contentobserver = (ContentObserver)iterator.next();
            if(!flag || contentobserver.deliverSelfNotifications())
                contentobserver.dispatchChange(flag, uri);
        } while(true);
        break MISSING_BLOCK_LABEL_67;
        Exception exception;
        exception;
        throw exception;
        arraylist;
        JVM INSTR monitorexit ;
    }

    public void notifyChange(boolean flag) {
        ArrayList arraylist = super.mObservers;
        arraylist;
        JVM INSTR monitorenter ;
        for(Iterator iterator = super.mObservers.iterator(); iterator.hasNext(); ((ContentObserver)iterator.next()).onChange(flag, null));
        break MISSING_BLOCK_LABEL_49;
        Exception exception;
        exception;
        throw exception;
        arraylist;
        JVM INSTR monitorexit ;
    }

    public void registerObserver(ContentObserver contentobserver) {
        super.registerObserver(contentobserver);
    }

    public volatile void registerObserver(Object obj) {
        registerObserver((ContentObserver)obj);
    }
}
