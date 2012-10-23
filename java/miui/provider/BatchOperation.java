// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.provider;

import android.content.*;
import android.net.Uri;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class BatchOperation {

    public BatchOperation(ContentResolver contentresolver, String s) {
        mResolver = contentresolver;
        mAuthority = s;
    }

    public void add(ContentProviderOperation contentprovideroperation) {
        mOperations.add(contentprovideroperation);
    }

    public Uri execute() {
        Uri uri = null;
        Uri uri1;
        if(mOperations.size() == 0) {
            uri1 = null;
        } else {
            try {
                ContentProviderResult acontentproviderresult[] = mResolver.applyBatch(mAuthority, mOperations);
                if(acontentproviderresult != null && acontentproviderresult.length > 0)
                    uri = acontentproviderresult[0].uri;
            }
            catch(OperationApplicationException operationapplicationexception) {
                Log.e("BatchOperation", "storing contact data failed", operationapplicationexception);
            }
            catch(RemoteException remoteexception) {
                Log.e("BatchOperation", "storing contact data failed", remoteexception);
            }
            mOperations.clear();
            uri1 = uri;
        }
        return uri1;
    }

    public ContentResolver getContentResolver() {
        return mResolver;
    }

    public int size() {
        return mOperations.size();
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder();
        ContentProviderOperation contentprovideroperation;
        for(Iterator iterator = mOperations.iterator(); iterator.hasNext(); stringbuilder.append((new StringBuilder()).append(contentprovideroperation.toString()).append("\n").toString()))
            contentprovideroperation = (ContentProviderOperation)iterator.next();

        return stringbuilder.toString();
    }

    public static final int BATCH_EXECUTE_SIZE = 100;
    private final String mAuthority;
    private final ArrayList mOperations = new ArrayList();
    private final ContentResolver mResolver;
}
