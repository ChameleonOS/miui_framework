// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import android.content.ContentValues;
import android.content.IContentProvider;
import android.net.Uri;
import android.os.RemoteException;
import java.util.*;

public class MediaInserter {

    public MediaInserter(IContentProvider icontentprovider, int i) {
        mProvider = icontentprovider;
        mBufferSizePerUri = i;
    }

    private void flush(Uri uri, List list) throws RemoteException {
        if(!list.isEmpty()) {
            ContentValues acontentvalues[] = (ContentValues[])list.toArray(new ContentValues[list.size()]);
            mProvider.bulkInsert(uri, acontentvalues);
            list.clear();
        }
    }

    private void flushAllPriority() throws RemoteException {
        Uri uri;
        for(Iterator iterator = mPriorityRowMap.keySet().iterator(); iterator.hasNext(); flush(uri, (List)mPriorityRowMap.get(uri)))
            uri = (Uri)iterator.next();

        mPriorityRowMap.clear();
    }

    private void insert(Uri uri, ContentValues contentvalues, boolean flag) throws RemoteException {
        HashMap hashmap;
        Object obj;
        if(flag)
            hashmap = mPriorityRowMap;
        else
            hashmap = mRowMap;
        obj = (List)hashmap.get(uri);
        if(obj == null) {
            obj = new ArrayList();
            hashmap.put(uri, obj);
        }
        ((List) (obj)).add(new ContentValues(contentvalues));
        if(((List) (obj)).size() >= mBufferSizePerUri) {
            flushAllPriority();
            flush(uri, ((List) (obj)));
        }
    }

    public void flushAll() throws RemoteException {
        flushAllPriority();
        Uri uri;
        for(Iterator iterator = mRowMap.keySet().iterator(); iterator.hasNext(); flush(uri, (List)mRowMap.get(uri)))
            uri = (Uri)iterator.next();

        mRowMap.clear();
    }

    public void insert(Uri uri, ContentValues contentvalues) throws RemoteException {
        insert(uri, contentvalues, false);
    }

    public void insertwithPriority(Uri uri, ContentValues contentvalues) throws RemoteException {
        insert(uri, contentvalues, true);
    }

    private int mBufferSizePerUri;
    private final HashMap mPriorityRowMap = new HashMap();
    private IContentProvider mProvider;
    private final HashMap mRowMap = new HashMap();
}
