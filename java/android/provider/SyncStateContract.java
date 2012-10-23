// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.provider;

import android.accounts.Account;
import android.content.*;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.util.Pair;

// Referenced classes of package android.provider:
//            BaseColumns

public class SyncStateContract {
    public static final class Helpers {

        public static byte[] get(ContentProviderClient contentproviderclient, Uri uri, Account account) throws RemoteException {
            byte abyte0[];
            Cursor cursor;
            abyte0 = null;
            String as[] = DATA_PROJECTION;
            String as1[] = new String[2];
            as1[0] = account.name;
            as1[1] = account.type;
            cursor = contentproviderclient.query(uri, as, "account_name=? AND account_type=?", as1, null);
            if(cursor == null)
                throw new RemoteException();
            if(!cursor.moveToNext()) goto _L2; else goto _L1
_L1:
            byte abyte1[] = cursor.getBlob(cursor.getColumnIndexOrThrow("data"));
            abyte0 = abyte1;
            cursor.close();
_L4:
            return abyte0;
_L2:
            cursor.close();
            if(true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            cursor.close();
            throw exception;
        }

        public static Pair getWithUri(ContentProviderClient contentproviderclient, Uri uri, Account account) throws RemoteException {
            Pair pair;
            Cursor cursor;
            pair = null;
            String as[] = DATA_PROJECTION;
            String as1[] = new String[2];
            as1[0] = account.name;
            as1[1] = account.type;
            cursor = contentproviderclient.query(uri, as, "account_name=? AND account_type=?", as1, null);
            if(cursor == null)
                throw new RemoteException();
            if(!cursor.moveToNext()) goto _L2; else goto _L1
_L1:
            Pair pair1;
            long l = cursor.getLong(1);
            byte abyte0[] = cursor.getBlob(cursor.getColumnIndexOrThrow("data"));
            pair1 = Pair.create(ContentUris.withAppendedId(uri, l), abyte0);
            pair = pair1;
            cursor.close();
_L4:
            return pair;
_L2:
            cursor.close();
            if(true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            cursor.close();
            throw exception;
        }

        public static Uri insert(ContentProviderClient contentproviderclient, Uri uri, Account account, byte abyte0[]) throws RemoteException {
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("data", abyte0);
            contentvalues.put("account_name", account.name);
            contentvalues.put("account_type", account.type);
            return contentproviderclient.insert(uri, contentvalues);
        }

        public static ContentProviderOperation newSetOperation(Uri uri, Account account, byte abyte0[]) {
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("data", abyte0);
            return ContentProviderOperation.newInsert(uri).withValue("account_name", account.name).withValue("account_type", account.type).withValues(contentvalues).build();
        }

        public static ContentProviderOperation newUpdateOperation(Uri uri, byte abyte0[]) {
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("data", abyte0);
            return ContentProviderOperation.newUpdate(uri).withValues(contentvalues).build();
        }

        public static void set(ContentProviderClient contentproviderclient, Uri uri, Account account, byte abyte0[]) throws RemoteException {
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("data", abyte0);
            contentvalues.put("account_name", account.name);
            contentvalues.put("account_type", account.type);
            contentproviderclient.insert(uri, contentvalues);
        }

        public static void update(ContentProviderClient contentproviderclient, Uri uri, byte abyte0[]) throws RemoteException {
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("data", abyte0);
            contentproviderclient.update(uri, contentvalues, null, null);
        }

        private static final String DATA_PROJECTION[];
        private static final String SELECT_BY_ACCOUNT = "account_name=? AND account_type=?";

        static  {
            String as[] = new String[2];
            as[0] = "data";
            as[1] = "_id";
            DATA_PROJECTION = as;
        }

        public Helpers() {
        }
    }

    public static class Constants
        implements Columns {

        public static final String CONTENT_DIRECTORY = "syncstate";

        public Constants() {
        }
    }

    public static interface Columns
        extends BaseColumns {

        public static final String ACCOUNT_NAME = "account_name";
        public static final String ACCOUNT_TYPE = "account_type";
        public static final String DATA = "data";
    }


    public SyncStateContract() {
    }
}
