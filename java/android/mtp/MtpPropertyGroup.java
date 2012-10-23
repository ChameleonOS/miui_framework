// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.mtp;

import android.content.IContentProvider;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayList;

// Referenced classes of package android.mtp:
//            MtpPropertyList, MtpDatabase

class MtpPropertyGroup {
    private class Property {

        int code;
        int column;
        final MtpPropertyGroup this$0;
        int type;

        Property(int i, int j, int k) {
            this$0 = MtpPropertyGroup.this;
            super();
            code = i;
            type = j;
            column = k;
        }
    }


    public MtpPropertyGroup(MtpDatabase mtpdatabase, IContentProvider icontentprovider, String s, int ai[]) {
        mDatabase = mtpdatabase;
        mProvider = icontentprovider;
        mVolumeName = s;
        mUri = android.provider.MediaStore.Files.getMtpObjectsUri(s);
        int i = ai.length;
        ArrayList arraylist = new ArrayList(i);
        arraylist.add("_id");
        mProperties = new Property[i];
        for(int j = 0; j < i; j++)
            mProperties[j] = createProperty(ai[j], arraylist);

        int k = arraylist.size();
        mColumns = new String[k];
        for(int l = 0; l < k; l++)
            mColumns[l] = (String)arraylist.get(l);

    }

    private Property createProperty(int i, ArrayList arraylist) {
        String s = null;
        i;
        JVM INSTR lookupswitch 20: default 172
    //                   56321: 233
    //                   56322: 243
    //                   56323: 252
    //                   56324: 258
    //                   56327: 268
    //                   56329: 288
    //                   56331: 318
    //                   56385: 328
    //                   56388: 278
    //                   56390: 367
    //                   56392: 408
    //                   56398: 298
    //                   56457: 338
    //                   56459: 348
    //                   56460: 391
    //                   56470: 398
    //                   56473: 308
    //                   56474: 374
    //                   56475: 381
    //                   56544: 357;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21
_L12:
        break MISSING_BLOCK_LABEL_408;
_L1:
        int j;
        j = 0;
        Log.e("MtpPropertyGroup", (new StringBuilder()).append("unsupported property ").append(i).toString());
_L22:
        Property property;
        if(s != null) {
            arraylist.add(s);
            property = new Property(i, j, -1 + arraylist.size());
        } else {
            property = new Property(i, j, -1);
        }
        return property;
_L2:
        s = "storage_id";
        j = 6;
          goto _L22
_L3:
        s = "format";
        j = 4;
          goto _L22
_L4:
        j = 4;
          goto _L22
_L5:
        s = "_size";
        j = 8;
          goto _L22
_L6:
        s = "_data";
        j = 65535;
          goto _L22
_L10:
        s = "title";
        j = 65535;
          goto _L22
_L7:
        s = "date_modified";
        j = 65535;
          goto _L22
_L13:
        s = "date_added";
        j = 65535;
          goto _L22
_L18:
        s = "year";
        j = 65535;
          goto _L22
_L8:
        s = "parent";
        j = 6;
          goto _L22
_L9:
        s = "storage_id";
        j = 10;
          goto _L22
_L14:
        s = "duration";
        j = 6;
          goto _L22
_L15:
        s = "track";
        j = 4;
          goto _L22
_L21:
        s = "_display_name";
        j = 65535;
          goto _L22
_L11:
        j = 65535;
          goto _L22
_L19:
        j = 65535;
          goto _L22
_L20:
        s = "album_artist";
        j = 65535;
          goto _L22
_L16:
        j = 65535;
          goto _L22
_L17:
        s = "composer";
        j = 65535;
          goto _L22
        s = "description";
        j = 65535;
          goto _L22
    }

    private native String format_date_time(long l);

    private static String nameFromPath(String s) {
        int i = 0;
        int j = s.lastIndexOf('/');
        if(j >= 0)
            i = j + 1;
        int k = s.length();
        if(k - i > 255)
            k = i + 255;
        return s.substring(i, k);
    }

    private String queryAudio(int i, String s) {
        Cursor cursor = null;
        IContentProvider icontentprovider = mProvider;
        Uri uri = android.provider.MediaStore.Audio.Media.getContentUri(mVolumeName);
        String as[] = new String[2];
        as[0] = "_id";
        as[1] = s;
        String as1[] = new String[1];
        as1[0] = Integer.toString(i);
        cursor = icontentprovider.query(uri, as, "_id=?", as1, null, null);
        if(cursor == null || !cursor.moveToNext()) goto _L2; else goto _L1
_L1:
        String s2 = cursor.getString(1);
        String s1 = s2;
        if(cursor == null) goto _L4; else goto _L3
_L3:
        cursor.close();
_L4:
        return s1;
_L2:
        s1 = "";
        if(cursor == null) goto _L4; else goto _L3
        Exception exception1;
        exception1;
        if(cursor != null)
            cursor.close();
        s1 = null;
          goto _L4
        Exception exception;
        exception;
        if(cursor != null)
            cursor.close();
        throw exception;
    }

    private String queryGenre(int i) {
        Cursor cursor = null;
        Uri uri = android.provider.MediaStore.Audio.Genres.getContentUriForAudioId(mVolumeName, i);
        IContentProvider icontentprovider = mProvider;
        String as[] = new String[2];
        as[0] = "_id";
        as[1] = "name";
        cursor = icontentprovider.query(uri, as, null, null, null, null);
        if(cursor == null || !cursor.moveToNext()) goto _L2; else goto _L1
_L1:
        String s1 = cursor.getString(1);
        String s = s1;
        if(cursor == null) goto _L4; else goto _L3
_L3:
        cursor.close();
_L4:
        return s;
_L2:
        s = "";
        if(cursor == null) goto _L4; else goto _L3
        Exception exception1;
        exception1;
        Log.e("MtpPropertyGroup", "queryGenre exception", exception1);
        if(cursor != null)
            cursor.close();
        s = null;
          goto _L4
        Exception exception;
        exception;
        if(cursor != null)
            cursor.close();
        throw exception;
    }

    private Long queryLong(int i, String s) {
        Cursor cursor = null;
        IContentProvider icontentprovider = mProvider;
        Uri uri = mUri;
        String as[] = new String[2];
        as[0] = "_id";
        as[1] = s;
        String as1[] = new String[1];
        as1[0] = Integer.toString(i);
        cursor = icontentprovider.query(uri, as, "_id=?", as1, null, null);
        if(cursor == null || !cursor.moveToNext()) goto _L2; else goto _L1
_L1:
        Long long1 = new Long(cursor.getLong(1));
        if(cursor != null)
            cursor.close();
_L5:
        return long1;
        Exception exception1;
        exception1;
        if(cursor != null)
            cursor.close();
        throw exception1;
        Exception exception;
        exception;
        if(cursor == null) goto _L4; else goto _L3
_L3:
        cursor.close();
_L4:
        long1 = null;
          goto _L5
_L2:
        if(cursor == null) goto _L4; else goto _L3
    }

    private String queryString(int i, String s) {
        Cursor cursor = null;
        IContentProvider icontentprovider = mProvider;
        Uri uri = mUri;
        String as[] = new String[2];
        as[0] = "_id";
        as[1] = s;
        String as1[] = new String[1];
        as1[0] = Integer.toString(i);
        cursor = icontentprovider.query(uri, as, "_id=?", as1, null, null);
        if(cursor == null || !cursor.moveToNext()) goto _L2; else goto _L1
_L1:
        String s2 = cursor.getString(1);
        String s1 = s2;
        if(cursor == null) goto _L4; else goto _L3
_L3:
        cursor.close();
_L4:
        return s1;
_L2:
        s1 = "";
        if(cursor == null) goto _L4; else goto _L3
        Exception exception1;
        exception1;
        if(cursor != null)
            cursor.close();
        s1 = null;
          goto _L4
        Exception exception;
        exception;
        if(cursor != null)
            cursor.close();
        throw exception;
    }

    MtpPropertyList getPropertyList(int i, int j, int k) {
        if(k <= 1) goto _L2; else goto _L1
_L1:
        MtpPropertyList mtppropertylist = new MtpPropertyList(0, 43016);
_L27:
        return mtppropertylist;
_L2:
        Cursor cursor;
        String as[];
        String s;
        if(j == 0) {
            if(i == -1) {
                s = null;
                as = null;
            } else {
                as = new String[1];
                as[0] = Integer.toString(i);
                if(k == 1)
                    s = "parent=?";
                else
                    s = "_id=?";
            }
        } else
        if(i == -1) {
            s = "format=?";
            as = new String[1];
            as[0] = Integer.toString(j);
        } else {
            as = new String[2];
            as[0] = Integer.toString(i);
            as[1] = Integer.toString(j);
            if(k == 1)
                s = "parent=? AND format=?";
            else
                s = "_id=? AND format=?";
        }
        cursor = null;
        if(k > 0 || i == -1)
            break MISSING_BLOCK_LABEL_58;
        if(mColumns.length <= 1)
            break; /* Loop/switch isn't completed */
        cursor = mProvider.query(mUri, mColumns, s, as, null, null);
        if(cursor != null)
            break; /* Loop/switch isn't completed */
        mtppropertylist = new MtpPropertyList(0, 8201);
        if(cursor == null)
            continue; /* Loop/switch isn't completed */
_L23:
        cursor.close();
        if(true) goto _L4; else goto _L3
_L4:
        break; /* Loop/switch isn't completed */
_L3:
        if(cursor != null) goto _L6; else goto _L5
_L5:
        int l = 1;
_L22:
        int i1;
        mtppropertylist = new MtpPropertyList(l * mProperties.length, 8193);
        i1 = 0;
_L26:
        if(i1 >= l)
            continue; /* Loop/switch isn't completed */
        if(cursor != null) {
            cursor.moveToNext();
            i = (int)cursor.getLong(0);
        }
          goto _L7
_L28:
        int k1 = mProperties.length;
        int j1;
        if(j1 >= k1) goto _L9; else goto _L8
_L8:
        Property property;
        int l1;
        int i2;
        property = mProperties[j1];
        l1 = property.code;
        i2 = property.column;
        l1;
        JVM INSTR lookupswitch 11: default 420
    //                   56323: 466
    //                   56327: 502
    //                   56329: 646
    //                   56385: 725
    //                   56388: 566
    //                   56390: 787
    //                   56398: 646
    //                   56459: 757
    //                   56460: 833
    //                   56473: 675
    //                   56474: 810;
           goto _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L13 _L17 _L18 _L19 _L20
_L10:
        if(property.type == 65535) {
            String s9 = cursor.getString(i2);
            mtppropertylist.append(i, l1, s9);
            break MISSING_BLOCK_LABEL_951;
        }
          goto _L21
_L6:
        l = cursor.getCount();
          goto _L22
_L11:
        mtppropertylist.append(i, l1, 4, 0L);
        break MISSING_BLOCK_LABEL_951;
        RemoteException remoteexception;
        remoteexception;
        mtppropertylist = new MtpPropertyList(0, 8194);
        if(cursor == null) goto _L24; else goto _L23
_L24:
        break; /* Loop/switch isn't completed */
_L12:
        String s7 = cursor.getString(i2);
        if(s7 != null) {
            String s8 = nameFromPath(s7);
            mtppropertylist.append(i, l1, s8);
            break MISSING_BLOCK_LABEL_951;
        }
          goto _L25
        Exception exception;
        exception;
        if(cursor != null)
            cursor.close();
        throw exception;
_L25:
        mtppropertylist.setResult(8201);
        break MISSING_BLOCK_LABEL_951;
_L15:
        String s6 = cursor.getString(i2);
        if(s6 == null)
            s6 = queryString(i, "name");
        if(s6 == null) {
            s6 = queryString(i, "_data");
            if(s6 != null)
                s6 = nameFromPath(s6);
        }
        if(s6 != null)
            mtppropertylist.append(i, l1, s6);
        else
            mtppropertylist.setResult(8201);
        break MISSING_BLOCK_LABEL_951;
_L13:
        String s5 = format_date_time(cursor.getInt(i2));
        mtppropertylist.append(i, l1, s5);
        break MISSING_BLOCK_LABEL_951;
_L19:
        int j2 = cursor.getInt(i2);
        String s4 = (new StringBuilder()).append(Integer.toString(j2)).append("0101T000000").toString();
        mtppropertylist.append(i, l1, s4);
        break MISSING_BLOCK_LABEL_951;
_L14:
        long l3 = (cursor.getLong(i2) << 32) + (long)i;
        mtppropertylist.append(i, l1, 10, l3);
        break MISSING_BLOCK_LABEL_951;
_L17:
        long l2 = cursor.getInt(i2) % 1000;
        mtppropertylist.append(i, l1, 4, l2);
        break MISSING_BLOCK_LABEL_951;
_L16:
        String s3 = queryAudio(i, "artist");
        mtppropertylist.append(i, l1, s3);
        break MISSING_BLOCK_LABEL_951;
_L20:
        String s2 = queryAudio(i, "album");
        mtppropertylist.append(i, l1, s2);
        break MISSING_BLOCK_LABEL_951;
_L18:
        String s1 = queryGenre(i);
        if(s1 != null)
            mtppropertylist.append(i, l1, s1);
        else
            mtppropertylist.setResult(8201);
        break MISSING_BLOCK_LABEL_951;
_L21:
        if(property.type == 0) {
            int i3 = property.type;
            mtppropertylist.append(i, l1, i3, 0L);
        } else {
            int k2 = property.type;
            long l4 = cursor.getLong(i2);
            mtppropertylist.append(i, l1, k2, l4);
        }
        break MISSING_BLOCK_LABEL_951;
_L9:
        i1++;
          goto _L26
        if(cursor == null) goto _L27; else goto _L23
_L7:
        j1 = 0;
          goto _L28
        j1++;
          goto _L28
    }

    private static final String FORMAT_WHERE = "format=?";
    private static final String ID_FORMAT_WHERE = "_id=? AND format=?";
    private static final String ID_WHERE = "_id=?";
    private static final String PARENT_FORMAT_WHERE = "parent=? AND format=?";
    private static final String PARENT_WHERE = "parent=?";
    private static final String TAG = "MtpPropertyGroup";
    private String mColumns[];
    private final MtpDatabase mDatabase;
    private final Property mProperties[];
    private final IContentProvider mProvider;
    private final Uri mUri;
    private final String mVolumeName;
}
