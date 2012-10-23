// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.content.*;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.text.TextUtils;
import android.util.Log;
import java.util.List;

// Referenced classes of package com.android.internal.telephony:
//            IIccPhoneBook, AdnRecord

public class IccProvider extends ContentProvider {

    public IccProvider() {
    }

    private boolean addIccRecordToEf(int i, String s, String s1, String as[], String s2) {
        boolean flag = false;
        boolean flag1;
        IIccPhoneBook iiccphonebook = IIccPhoneBook.Stub.asInterface(ServiceManager.getService("simphonebook"));
        if(iiccphonebook == null)
            break MISSING_BLOCK_LABEL_40;
        flag1 = iiccphonebook.updateAdnRecordsInEfBySearch(i, "", "", s, s1, s2);
        flag = flag1;
_L2:
        return flag;
        SecurityException securityexception;
        securityexception;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private boolean deleteIccRecordFromEf(int i, String s, String s1, String as[], String s2) {
        boolean flag = false;
        boolean flag1;
        IIccPhoneBook iiccphonebook = IIccPhoneBook.Stub.asInterface(ServiceManager.getService("simphonebook"));
        if(iiccphonebook == null)
            break MISSING_BLOCK_LABEL_40;
        flag1 = iiccphonebook.updateAdnRecordsInEfBySearch(i, s, s1, "", "", s2);
        flag = flag1;
_L2:
        return flag;
        SecurityException securityexception;
        securityexception;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private MatrixCursor loadFromEf(int i) {
        List list = null;
        List list1;
        IIccPhoneBook iiccphonebook = IIccPhoneBook.Stub.asInterface(ServiceManager.getService("simphonebook"));
        if(iiccphonebook == null)
            break MISSING_BLOCK_LABEL_30;
        list1 = iiccphonebook.getAdnRecordsInEf(i);
        list = list1;
_L2:
        MatrixCursor matrixcursor;
        if(list != null) {
            int j = list.size();
            matrixcursor = new MatrixCursor(ADDRESS_BOOK_COLUMN_NAMES, j);
            for(int k = 0; k < j; k++)
                loadRecord((AdnRecord)list.get(k), matrixcursor, k);

        } else {
            Log.w("IccProvider", "Cannot load ADN records");
            matrixcursor = new MatrixCursor(ADDRESS_BOOK_COLUMN_NAMES);
        }
        return matrixcursor;
        SecurityException securityexception;
        securityexception;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private void loadRecord(AdnRecord adnrecord, MatrixCursor matrixcursor, int i) {
        if(!adnrecord.isEmpty()) {
            Object aobj[] = new Object[4];
            String s = adnrecord.getAlphaTag();
            String s1 = adnrecord.getNumber();
            aobj[0] = s;
            aobj[1] = s1;
            String as[] = adnrecord.getEmails();
            if(as != null) {
                StringBuilder stringbuilder = new StringBuilder();
                int j = as.length;
                for(int k = 0; k < j; k++) {
                    stringbuilder.append(as[k]);
                    stringbuilder.append(",");
                }

                aobj[2] = stringbuilder.toString();
            }
            aobj[3] = Integer.valueOf(i);
            matrixcursor.addRow(aobj);
        }
    }

    private String normalizeValue(String s) {
        int i = s.length();
        String s1 = s;
        String s2;
        if(i <= 1) {
            s2 = s1;
        } else {
            if(s.charAt(0) == '\'' && s.charAt(i - 1) == '\'')
                s1 = s.substring(1, i - 1);
            s2 = s1;
        }
        return s2;
    }

    private boolean updateIccRecordInEf(int i, String s, String s1, String s2, String s3, String s4) {
        boolean flag = false;
        boolean flag1;
        IIccPhoneBook iiccphonebook = IIccPhoneBook.Stub.asInterface(ServiceManager.getService("simphonebook"));
        if(iiccphonebook == null)
            break MISSING_BLOCK_LABEL_40;
        flag1 = iiccphonebook.updateAdnRecordsInEfBySearch(i, s, s1, s2, s3, s4);
        flag = flag1;
_L2:
        return flag;
        SecurityException securityexception;
        securityexception;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int delete(Uri uri, String s, String as[]) {
        URL_MATCHER.match(uri);
        JVM INSTR tableswitch 1 2: default 28
    //                   1 55
    //                   2 142;
           goto _L1 _L2 _L3
_L1:
        throw new UnsupportedOperationException((new StringBuilder()).append("Cannot insert into URL: ").append(uri).toString());
_L2:
        char c = '\u6F3A';
_L7:
        String s1;
        String s2;
        String s3;
        String as1[];
        int i;
        s1 = null;
        s2 = null;
        s3 = null;
        as1 = s.split("AND");
        i = as1.length;
_L5:
        if(--i < 0)
            break; /* Loop/switch isn't completed */
        String s4 = as1[i];
        String as2[] = s4.split("=");
        if(as2.length != 2) {
            Log.e("IccProvider", (new StringBuilder()).append("resolve: bad whereClause parameter: ").append(s4).toString());
        } else {
            String s5 = as2[0].trim();
            String s6 = as2[1].trim();
            if("tag".equals(s5))
                s1 = normalizeValue(s6);
            else
            if("number".equals(s5))
                s2 = normalizeValue(s6);
            else
            if(!"emails".equals(s5) && "pin2".equals(s5))
                s3 = normalizeValue(s6);
        }
        continue; /* Loop/switch isn't completed */
_L3:
        c = '\u6F3B';
        continue; /* Loop/switch isn't completed */
        if(true) goto _L5; else goto _L4
_L4:
        int j;
        if(TextUtils.isEmpty(s2))
            j = 0;
        else
        if(c == '\u6F3B' && TextUtils.isEmpty(s3))
            j = 0;
        else
        if(!deleteIccRecordFromEf(c, s1, s2, null, s3))
            j = 0;
        else
            j = 1;
        return j;
        if(true) goto _L7; else goto _L6
_L6:
    }

    public String getType(Uri uri) {
        switch(URL_MATCHER.match(uri)) {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown URL ").append(uri).toString());

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            return "vnd.android.cursor.dir/sim-contact";
        }
    }

    public Uri insert(Uri uri, ContentValues contentvalues) {
        Uri uri1;
        String s;
        int i;
        uri1 = null;
        s = null;
        i = URL_MATCHER.match(uri);
        i;
        JVM INSTR tableswitch 1 2: default 40
    //                   1 67
    //                   2 98;
           goto _L1 _L2 _L3
_L1:
        throw new UnsupportedOperationException((new StringBuilder()).append("Cannot insert into URL: ").append(uri).toString());
_L2:
        char c = '\u6F3A';
_L6:
        if(addIccRecordToEf(c, contentvalues.getAsString("tag"), contentvalues.getAsString("number"), null, s)) goto _L5; else goto _L4
_L4:
        return uri1;
_L3:
        c = '\u6F3B';
        s = contentvalues.getAsString("pin2");
          goto _L6
_L5:
        StringBuilder stringbuilder = new StringBuilder("content://icc/");
        i;
        JVM INSTR tableswitch 1 2: default 148
    //                   1 167
    //                   2 179;
           goto _L7 _L8 _L9
_L7:
        stringbuilder.append(0);
        uri1 = Uri.parse(stringbuilder.toString());
          goto _L4
_L8:
        stringbuilder.append("adn/");
          goto _L7
_L9:
        stringbuilder.append("fdn/");
          goto _L7
    }

    void log(String s) {
        Log.d("IccProvider", (new StringBuilder()).append("[IccProvider] ").append(s).toString());
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String as[], String s, String as1[], String s1) {
        URL_MATCHER.match(uri);
        JVM INSTR tableswitch 1 3: default 32
    //                   1 59
    //                   2 71
    //                   3 83;
           goto _L1 _L2 _L3 _L4
_L1:
        throw new IllegalArgumentException((new StringBuilder()).append("Unknown URL ").append(uri).toString());
_L2:
        MatrixCursor matrixcursor = loadFromEf(28474);
_L6:
        return matrixcursor;
_L3:
        matrixcursor = loadFromEf(28475);
        continue; /* Loop/switch isn't completed */
_L4:
        matrixcursor = loadFromEf(28489);
        if(true) goto _L6; else goto _L5
_L5:
    }

    public int update(Uri uri, ContentValues contentvalues, String s, String as[]) {
        String s1;
        char c;
        s1 = null;
        switch(URL_MATCHER.match(uri)) {
        default:
            throw new UnsupportedOperationException((new StringBuilder()).append("Cannot insert into URL: ").append(uri).toString());

        case 2: // '\002'
            break MISSING_BLOCK_LABEL_107;

        case 1: // '\001'
            c = '\u6F3A';
            break;
        }
_L1:
        int i;
        if(!updateIccRecordInEf(c, contentvalues.getAsString("tag"), contentvalues.getAsString("number"), contentvalues.getAsString("newTag"), contentvalues.getAsString("newNumber"), s1))
            i = 0;
        else
            i = 1;
        return i;
        c = '\u6F3B';
        s1 = contentvalues.getAsString("pin2");
          goto _L1
    }

    private static final String ADDRESS_BOOK_COLUMN_NAMES[];
    private static final int ADN = 1;
    static final boolean DBG = false;
    private static final int FDN = 2;
    private static final int SDN = 3;
    private static final String STR_EMAILS = "emails";
    private static final String STR_NUMBER = "number";
    private static final String STR_PIN2 = "pin2";
    private static final String STR_TAG = "tag";
    private static final String TAG = "IccProvider";
    static final UriMatcher URL_MATCHER;

    static  {
        String as[] = new String[4];
        as[0] = "name";
        as[1] = "number";
        as[2] = "emails";
        as[3] = "_id";
        ADDRESS_BOOK_COLUMN_NAMES = as;
        URL_MATCHER = new UriMatcher(-1);
        URL_MATCHER.addURI("icc", "adn", 1);
        URL_MATCHER.addURI("icc", "fdn", 2);
        URL_MATCHER.addURI("icc", "sdn", 3);
    }
}
