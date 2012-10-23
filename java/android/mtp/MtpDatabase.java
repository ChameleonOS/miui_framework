// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.mtp;

import android.content.*;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaScanner;
import android.net.Uri;
import android.os.RemoteException;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.io.File;
import java.util.*;

// Referenced classes of package android.mtp:
//            MtpPropertyList, MtpPropertyGroup, MtpStorage

public class MtpDatabase {

    public MtpDatabase(Context context, String s, String s1, String as[]) {
        native_setup();
        mContext = context;
        mMediaProvider = context.getContentResolver().acquireProvider("media");
        mVolumeName = s;
        mMediaStoragePath = s1;
        mObjectsUri = android.provider.MediaStore.Files.getMtpObjectsUri(s);
        mMediaScanner = new MediaScanner(context);
        mSubDirectories = as;
        if(as != null) {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("(");
            int i = as.length;
            for(int j = 0; j < i; j++) {
                stringbuilder.append("_data=? OR _data LIKE ?");
                if(j != i - 1)
                    stringbuilder.append(" OR ");
            }

            stringbuilder.append(")");
            mSubDirectoriesWhere = stringbuilder.toString();
            mSubDirectoriesWhereArgs = new String[i * 2];
            int k = 0;
            int l = 0;
            for(; k < i; k++) {
                String s4 = as[k];
                String as1[] = mSubDirectoriesWhereArgs;
                int i1 = l + 1;
                as1[l] = s4;
                String as2[] = mSubDirectoriesWhereArgs;
                l = i1 + 1;
                as2[i1] = (new StringBuilder()).append(s4).append("/%").toString();
            }

        }
        Locale locale = context.getResources().getConfiguration().locale;
        if(locale != null) {
            String s2 = locale.getLanguage();
            String s3 = locale.getCountry();
            if(s2 != null)
                if(s3 != null)
                    mMediaScanner.setLocale((new StringBuilder()).append(s2).append("_").append(s3).toString());
                else
                    mMediaScanner.setLocale(s2);
        }
        initDeviceProperties(context);
    }

    private int beginSendObject(String s, int i, int j, int k, long l, long l1) {
        if(inStorageSubDirectory(s)) goto _L2; else goto _L1
_L1:
        int i1 = -1;
_L7:
        return i1;
_L2:
        if(s == null) goto _L4; else goto _L3
_L3:
        Cursor cursor = null;
        IContentProvider icontentprovider = mMediaProvider;
        Uri uri1 = mObjectsUri;
        String as[] = ID_PROJECTION;
        String as1[] = new String[1];
        as1[0] = s;
        cursor = icontentprovider.query(uri1, as, "_data=?", as1, null, null);
        if(cursor == null || cursor.getCount() <= 0) goto _L6; else goto _L5
_L5:
        Log.w("MtpDatabase", (new StringBuilder()).append("file already exists in beginSendObject: ").append(s).toString());
        i1 = -1;
        if(cursor != null)
            cursor.close();
          goto _L7
        RemoteException remoteexception1;
        remoteexception1;
        Log.e("MtpDatabase", "RemoteException in beginSendObject", remoteexception1);
        if(cursor == null) goto _L4; else goto _L8
_L8:
        cursor.close();
_L4:
        ContentValues contentvalues;
        mDatabaseModified = true;
        contentvalues = new ContentValues();
        contentvalues.put("_data", s);
        contentvalues.put("format", Integer.valueOf(i));
        contentvalues.put("parent", Integer.valueOf(j));
        contentvalues.put("storage_id", Integer.valueOf(k));
        contentvalues.put("_size", Long.valueOf(l));
        contentvalues.put("date_modified", Long.valueOf(l1));
        int j1;
        Uri uri = mMediaProvider.insert(mObjectsUri, contentvalues);
        if(uri == null)
            break MISSING_BLOCK_LABEL_299;
        j1 = Integer.parseInt((String)uri.getPathSegments().get(2));
        i1 = j1;
          goto _L7
        Exception exception;
        exception;
        if(cursor != null)
            cursor.close();
        throw exception;
        i1 = -1;
          goto _L7
        RemoteException remoteexception;
        remoteexception;
        Log.e("MtpDatabase", "RemoteException in beginSendObject", remoteexception);
        i1 = -1;
          goto _L7
_L6:
        if(cursor == null) goto _L4; else goto _L8
    }

    private Cursor createObjectQuery(int i, int j, int k) throws RemoteException {
        String s;
        String as[];
        if(i == -1) {
            if(j == 0) {
                if(k == 0) {
                    s = null;
                    as = null;
                } else {
                    if(k == -1)
                        k = 0;
                    s = "format=?";
                    as = new String[1];
                    as[0] = Integer.toString(k);
                }
            } else
            if(k == 0) {
                s = "parent=?";
                as = new String[1];
                as[0] = Integer.toString(j);
            } else {
                if(k == -1)
                    k = 0;
                s = "parent=? AND parent=?";
                as = new String[2];
                as[0] = Integer.toString(j);
                as[1] = Integer.toString(k);
            }
        } else
        if(j == 0) {
            if(k == 0) {
                s = "storage_id=?";
                as = new String[1];
                as[0] = Integer.toString(i);
            } else {
                if(k == -1)
                    k = 0;
                s = "storage_id=? AND parent=?";
                as = new String[2];
                as[0] = Integer.toString(i);
                as[1] = Integer.toString(k);
            }
        } else
        if(k == 0) {
            s = "storage_id=? AND format=?";
            as = new String[2];
            as[0] = Integer.toString(i);
            as[1] = Integer.toString(j);
        } else {
            if(k == -1)
                k = 0;
            s = "storage_id=? AND format=? AND parent=?";
            as = new String[3];
            as[0] = Integer.toString(i);
            as[1] = Integer.toString(j);
            as[2] = Integer.toString(k);
        }
        if(mSubDirectoriesWhere != null)
            if(s == null) {
                s = mSubDirectoriesWhere;
                as = mSubDirectoriesWhereArgs;
            } else {
                s = (new StringBuilder()).append(s).append(" AND ").append(mSubDirectoriesWhere).toString();
                String as1[] = new String[as.length + mSubDirectoriesWhereArgs.length];
                int l;
                for(l = 0; l < as.length; l++)
                    as1[l] = as[l];

                for(int i1 = 0; i1 < mSubDirectoriesWhereArgs.length; i1++) {
                    as1[l] = mSubDirectoriesWhereArgs[i1];
                    l++;
                }

                as = as1;
            }
        return mMediaProvider.query(mObjectsUri, ID_PROJECTION, s, as, null, null);
    }

    private int deleteFile(int i) {
        Cursor cursor;
        mDatabaseModified = true;
        cursor = null;
        IContentProvider icontentprovider = mMediaProvider;
        Uri uri = mObjectsUri;
        String as[] = PATH_SIZE_FORMAT_PROJECTION;
        String as1[] = new String[1];
        as1[0] = Integer.toString(i);
        cursor = icontentprovider.query(uri, as, "_id=?", as1, null, null);
        if(cursor == null || !cursor.moveToNext()) goto _L2; else goto _L1
_L1:
        String s;
        int j;
        s = cursor.getString(1);
        j = cursor.getInt(3);
        if(s != null && j != 0) goto _L4; else goto _L3
_L3:
        char c;
        if(cursor != null)
            cursor.close();
        c = '\u2002';
_L6:
        return c;
_L2:
        c = '\u2009';
        if(cursor == null) goto _L6; else goto _L5
_L5:
        cursor.close();
        break; /* Loop/switch isn't completed */
_L4:
        if(!isStorageSubDirectory(s))
            break MISSING_BLOCK_LABEL_154;
        c = '\u200D';
        if(cursor == null) goto _L7; else goto _L5
_L7:
        break; /* Loop/switch isn't completed */
        boolean flag;
        if(j == 12289) {
            Uri uri2 = android.provider.MediaStore.Files.getMtpObjectsUri(mVolumeName);
            IContentProvider icontentprovider1 = mMediaProvider;
            String as2[] = new String[3];
            as2[0] = (new StringBuilder()).append(s).append("/%").toString();
            as2[1] = Integer.toString(1 + s.length());
            as2[2] = (new StringBuilder()).append(s).append("/").toString();
            icontentprovider1.delete(uri2, "_data LIKE ?1 AND lower(substr(_data,1,?2))=lower(?3)", as2);
        }
        Uri uri1 = android.provider.MediaStore.Files.getMtpObjectsUri(mVolumeName, i);
        if(mMediaProvider.delete(uri1, null, null) <= 0)
            break MISSING_BLOCK_LABEL_424;
        if(j == 12289)
            break MISSING_BLOCK_LABEL_349;
        flag = s.toLowerCase(Locale.US).endsWith("/.nomedia");
        if(!flag)
            break MISSING_BLOCK_LABEL_349;
        String s1 = s.substring(0, s.lastIndexOf("/"));
        mMediaProvider.call("unhide", s1, null);
_L9:
        c = '\u2001';
        if(cursor == null) goto _L8; else goto _L5
_L8:
        break; /* Loop/switch isn't completed */
        RemoteException remoteexception1;
        remoteexception1;
        Log.e("MtpDatabase", (new StringBuilder()).append("failed to unhide/rescan for ").append(s).toString());
          goto _L9
        RemoteException remoteexception;
        remoteexception;
        Log.e("MtpDatabase", "RemoteException in deleteFile", remoteexception);
        if(cursor != null)
            cursor.close();
        c = '\u2002';
        break; /* Loop/switch isn't completed */
        c = '\u2009';
        if(cursor == null) goto _L6; else goto _L5
        Exception exception;
        exception;
        if(cursor != null)
            cursor.close();
        throw exception;
    }

    private void endSendObject(String s, int i, int j, boolean flag) {
        if(!flag)
            break MISSING_BLOCK_LABEL_184;
        if(j != 47621) goto _L2; else goto _L1
_L1:
        ContentValues contentvalues;
        String s1 = s;
        int k = s1.lastIndexOf('/');
        if(k >= 0)
            s1 = s1.substring(k + 1);
        if(s1.endsWith(".pla"))
            s1 = s1.substring(0, -4 + s1.length());
        contentvalues = new ContentValues(1);
        contentvalues.put("_data", s);
        contentvalues.put("name", s1);
        contentvalues.put("format", Integer.valueOf(j));
        contentvalues.put("date_modified", Long.valueOf(System.currentTimeMillis() / 1000L));
        contentvalues.put("media_scanner_new_object_id", Integer.valueOf(i));
        mMediaProvider.insert(android.provider.MediaStore.Audio.Playlists.EXTERNAL_CONTENT_URI, contentvalues);
_L3:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("MtpDatabase", "RemoteException in endSendObject", remoteexception);
          goto _L3
_L2:
        mMediaScanner.scanMtpFile(s, mVolumeName, i, j);
          goto _L3
        deleteFile(i);
          goto _L3
    }

    private int getDeviceProperty(int i, long al[], char ac[]) {
        i;
        JVM INSTR lookupswitch 3: default 36
    //                   20483: 105
    //                   54273: 44
    //                   54274: 44;
           goto _L1 _L2 _L3 _L3
_L1:
        char c = '\u200A';
_L5:
        return c;
_L3:
        String s1 = mDeviceProperties.getString(Integer.toString(i), "");
        int l = s1.length();
        if(l > 255)
            l = 255;
        s1.getChars(0, l, ac, 0);
        ac[l] = '\0';
        c = '\u2001';
        continue; /* Loop/switch isn't completed */
_L2:
        Display display = ((WindowManager)mContext.getSystemService("window")).getDefaultDisplay();
        int j = display.getMaximumSizeDimension();
        int k = display.getMaximumSizeDimension();
        String s = (new StringBuilder()).append(Integer.toString(j)).append("x").append(Integer.toString(k)).toString();
        s.getChars(0, s.length(), ac, 0);
        ac[s.length()] = '\0';
        c = '\u2001';
        if(true) goto _L5; else goto _L4
_L4:
    }

    private int getNumObjects(int i, int j, int k) {
        Cursor cursor = null;
        cursor = createObjectQuery(i, j, k);
        if(cursor == null) goto _L2; else goto _L1
_L1:
        int i1 = cursor.getCount();
        int l;
        l = i1;
        if(cursor != null)
            cursor.close();
_L5:
        return l;
        RemoteException remoteexception;
        remoteexception;
        Log.e("MtpDatabase", "RemoteException in getNumObjects", remoteexception);
        if(cursor == null) goto _L4; else goto _L3
_L3:
        cursor.close();
_L4:
        l = -1;
          goto _L5
        Exception exception;
        exception;
        if(cursor != null)
            cursor.close();
        throw exception;
_L2:
        if(cursor == null) goto _L4; else goto _L3
    }

    private int getObjectFilePath(int i, char ac[], long al[]) {
        if(i != 0) goto _L2; else goto _L1
_L1:
        char c;
        mMediaStoragePath.getChars(0, mMediaStoragePath.length(), ac, 0);
        ac[mMediaStoragePath.length()] = '\0';
        al[0] = 0L;
        al[1] = 12289L;
        c = '\u2001';
_L6:
        return c;
_L2:
        Cursor cursor = null;
        IContentProvider icontentprovider = mMediaProvider;
        Uri uri = mObjectsUri;
        String as[] = PATH_SIZE_FORMAT_PROJECTION;
        String as1[] = new String[1];
        as1[0] = Integer.toString(i);
        cursor = icontentprovider.query(uri, as, "_id=?", as1, null, null);
        if(cursor == null || !cursor.moveToNext())
            break MISSING_BLOCK_LABEL_190;
        String s = cursor.getString(1);
        s.getChars(0, s.length(), ac, 0);
        ac[s.length()] = '\0';
        al[0] = cursor.getLong(2);
        al[1] = cursor.getLong(3);
        if(cursor != null)
            cursor.close();
        c = '\u2001';
        continue; /* Loop/switch isn't completed */
        c = '\u2009';
        if(cursor == null)
            continue; /* Loop/switch isn't completed */
_L5:
        cursor.close();
        if(true) goto _L4; else goto _L3
_L3:
        RemoteException remoteexception;
        break MISSING_BLOCK_LABEL_209;
_L4:
        break; /* Loop/switch isn't completed */
        remoteexception;
        Log.e("MtpDatabase", "RemoteException in getObjectFilePath", remoteexception);
        c = '\u2002';
        if(cursor == null) goto _L6; else goto _L5
        Exception exception;
        exception;
        if(cursor != null)
            cursor.close();
        throw exception;
    }

    private boolean getObjectInfo(int i, int ai[], char ac[], long al[]) {
        Cursor cursor = null;
        IContentProvider icontentprovider = mMediaProvider;
        Uri uri = mObjectsUri;
        String as[] = OBJECT_INFO_PROJECTION;
        String as1[] = new String[1];
        as1[0] = Integer.toString(i);
        cursor = icontentprovider.query(uri, as, "_id=?", as1, null, null);
        if(cursor == null || !cursor.moveToNext()) goto _L2; else goto _L1
_L1:
        String s;
        int j;
        ai[0] = cursor.getInt(1);
        ai[1] = cursor.getInt(2);
        ai[2] = cursor.getInt(3);
        s = cursor.getString(4);
        j = s.lastIndexOf('/');
        if(j < 0) goto _L4; else goto _L3
_L3:
        int k = j + 1;
_L5:
        int l = s.length();
        if(l - k > 255)
            l = k + 255;
        s.getChars(k, l, ac, 0);
        ac[l - k] = '\0';
        al[0] = cursor.getLong(5);
        al[1] = cursor.getLong(6);
        boolean flag;
        flag = true;
        if(cursor != null)
            cursor.close();
_L8:
        return flag;
_L4:
        k = 0;
          goto _L5
        RemoteException remoteexception;
        remoteexception;
        Log.e("MtpDatabase", "RemoteException in getObjectInfo", remoteexception);
        if(cursor == null) goto _L7; else goto _L6
_L6:
        cursor.close();
_L7:
        flag = false;
          goto _L8
        Exception exception;
        exception;
        if(cursor != null)
            cursor.close();
        throw exception;
_L2:
        if(cursor == null) goto _L7; else goto _L6
    }

    private int[] getObjectList(int i, int j, int k) {
        Cursor cursor = null;
        Cursor cursor1 = createObjectQuery(i, j, k);
        cursor = cursor1;
        if(cursor != null) goto _L2; else goto _L1
_L1:
        int ai[];
        if(cursor != null)
            cursor.close();
        ai = null;
_L10:
        return ai;
_L2:
        int l = cursor.getCount();
        if(l <= 0) goto _L4; else goto _L3
_L3:
        int i1;
        ai = new int[l];
        i1 = 0;
_L7:
        if(i1 >= l) goto _L6; else goto _L5
_L5:
        cursor.moveToNext();
        ai[i1] = cursor.getInt(0);
        i1++;
          goto _L7
        RemoteException remoteexception;
        remoteexception;
        Log.e("MtpDatabase", "RemoteException in getObjectList", remoteexception);
        if(cursor == null) goto _L9; else goto _L8
_L8:
        cursor.close();
_L9:
        ai = null;
          goto _L10
        Exception exception;
        exception;
        if(cursor != null)
            cursor.close();
        throw exception;
_L6:
        if(cursor != null)
            cursor.close();
          goto _L10
_L4:
        if(cursor == null) goto _L9; else goto _L8
    }

    private MtpPropertyList getObjectPropertyList(long l, int i, long l1, int j, int k) {
        if(j == 0) goto _L2; else goto _L1
_L1:
        MtpPropertyList mtppropertylist = new MtpPropertyList(0, 43015);
_L4:
        return mtppropertylist;
_L2:
        MtpPropertyGroup mtppropertygroup;
        if(l1 != 0xffffffffL)
            break; /* Loop/switch isn't completed */
        mtppropertygroup = (MtpPropertyGroup)mPropertyGroupsByFormat.get(Integer.valueOf(i));
        if(mtppropertygroup == null) {
            int ai1[] = getSupportedObjectProperties(i);
            mtppropertygroup = new MtpPropertyGroup(this, mMediaProvider, mVolumeName, ai1);
            mPropertyGroupsByFormat.put(new Integer(i), mtppropertygroup);
        }
_L5:
        mtppropertylist = mtppropertygroup.getPropertyList((int)l, i, k);
        if(true) goto _L4; else goto _L3
_L3:
        mtppropertygroup = (MtpPropertyGroup)mPropertyGroupsByProperty.get(Long.valueOf(l1));
        if(mtppropertygroup == null) {
            int ai[] = new int[1];
            ai[0] = (int)l1;
            mtppropertygroup = new MtpPropertyGroup(this, mMediaProvider, mVolumeName, ai);
            mPropertyGroupsByProperty.put(new Integer((int)l1), mtppropertygroup);
        }
          goto _L5
        if(true) goto _L4; else goto _L6
_L6:
    }

    private int[] getObjectReferences(int i) {
        Uri uri;
        Cursor cursor;
        uri = android.provider.MediaStore.Files.getMtpReferencesUri(mVolumeName, i);
        cursor = null;
        Cursor cursor1 = mMediaProvider.query(uri, ID_PROJECTION, null, null, null, null);
        cursor = cursor1;
        if(cursor != null) goto _L2; else goto _L1
_L1:
        int ai[];
        if(cursor != null)
            cursor.close();
        ai = null;
_L10:
        return ai;
_L2:
        int j = cursor.getCount();
        if(j <= 0) goto _L4; else goto _L3
_L3:
        int k;
        ai = new int[j];
        k = 0;
_L7:
        if(k >= j) goto _L6; else goto _L5
_L5:
        cursor.moveToNext();
        ai[k] = cursor.getInt(0);
        k++;
          goto _L7
        RemoteException remoteexception;
        remoteexception;
        Log.e("MtpDatabase", "RemoteException in getObjectList", remoteexception);
        if(cursor == null) goto _L9; else goto _L8
_L8:
        cursor.close();
_L9:
        ai = null;
          goto _L10
        Exception exception;
        exception;
        if(cursor != null)
            cursor.close();
        throw exception;
_L6:
        if(cursor != null)
            cursor.close();
          goto _L10
_L4:
        if(cursor == null) goto _L9; else goto _L8
    }

    private int[] getSupportedCaptureFormats() {
        return null;
    }

    private int[] getSupportedDeviceProperties() {
        int ai[] = new int[3];
        ai[0] = 54273;
        ai[1] = 54274;
        ai[2] = 20483;
        return ai;
    }

    private int[] getSupportedObjectProperties(int i) {
        i;
        JVM INSTR lookupswitch 13: default 116
    //                   0: 143
    //                   12296: 122
    //                   12297: 122
    //                   12299: 129
    //                   14337: 136
    //                   14340: 136
    //                   14343: 136
    //                   14347: 136
    //                   47361: 122
    //                   47362: 122
    //                   47363: 122
    //                   47489: 129
    //                   47492: 129;
           goto _L1 _L2 _L3 _L3 _L4 _L5 _L5 _L5 _L5 _L3 _L3 _L3 _L4 _L4
_L1:
        int ai[] = FILE_PROPERTIES;
_L7:
        return ai;
_L3:
        ai = AUDIO_PROPERTIES;
        continue; /* Loop/switch isn't completed */
_L4:
        ai = VIDEO_PROPERTIES;
        continue; /* Loop/switch isn't completed */
_L5:
        ai = IMAGE_PROPERTIES;
        continue; /* Loop/switch isn't completed */
_L2:
        ai = ALL_PROPERTIES;
        if(true) goto _L7; else goto _L6
_L6:
    }

    private int[] getSupportedPlaybackFormats() {
        int ai[] = new int[25];
        ai[0] = 12288;
        ai[1] = 12289;
        ai[2] = 12292;
        ai[3] = 12293;
        ai[4] = 12296;
        ai[5] = 12297;
        ai[6] = 12299;
        ai[7] = 14337;
        ai[8] = 14338;
        ai[9] = 14343;
        ai[10] = 14344;
        ai[11] = 14347;
        ai[12] = 14349;
        ai[13] = 47361;
        ai[14] = 47362;
        ai[15] = 47363;
        ai[16] = 47490;
        ai[17] = 47491;
        ai[18] = 47492;
        ai[19] = 47621;
        ai[20] = 47632;
        ai[21] = 47633;
        ai[22] = 47636;
        ai[23] = 47746;
        ai[24] = 47366;
        return ai;
    }

    private boolean inStorageSubDirectory(String s) {
        if(mSubDirectories != null) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        if(s != null)
            break; /* Loop/switch isn't completed */
        flag = false;
        if(true) goto _L4; else goto _L3
_L3:
        flag = false;
        int i = s.length();
        int j = 0;
        while(j < mSubDirectories.length && !flag)  {
            String s1 = mSubDirectories[j];
            int k = s1.length();
            if(k < i && s.charAt(k) == '/' && s.startsWith(s1))
                flag = true;
            j++;
        }
        if(true) goto _L4; else goto _L5
_L5:
    }

    private void initDeviceProperties(Context context) {
        File file;
        mDeviceProperties = context.getSharedPreferences("device-properties", 0);
        file = context.getDatabasePath("device-properties");
        if(!file.exists()) goto _L2; else goto _L1
_L1:
        SQLiteDatabase sqlitedatabase;
        Cursor cursor;
        sqlitedatabase = null;
        cursor = null;
        sqlitedatabase = context.openOrCreateDatabase("device-properties", 0, null);
        if(sqlitedatabase == null) goto _L4; else goto _L3
_L3:
        String as[] = new String[3];
        as[0] = "_id";
        as[1] = "code";
        as[2] = "value";
        cursor = sqlitedatabase.query("properties", as, null, null, null, null, null);
        if(cursor == null) goto _L4; else goto _L5
_L5:
        android.content.SharedPreferences.Editor editor;
        editor = mDeviceProperties.edit();
        for(; cursor.moveToNext(); editor.putString(cursor.getString(1), cursor.getString(2)));
          goto _L6
        Exception exception1;
        exception1;
        Log.e("MtpDatabase", "failed to migrate device properties", exception1);
        if(cursor != null)
            cursor.close();
        if(sqlitedatabase == null) goto _L8; else goto _L7
_L7:
        sqlitedatabase.close();
_L8:
        file.delete();
_L2:
        return;
_L6:
        editor.commit();
_L4:
        if(cursor != null)
            cursor.close();
        if(sqlitedatabase == null) goto _L8; else goto _L7
        Exception exception;
        exception;
        if(cursor != null)
            cursor.close();
        if(sqlitedatabase != null)
            sqlitedatabase.close();
        throw exception;
    }

    private boolean isStorageSubDirectory(String s) {
        boolean flag = false;
        if(mSubDirectories != null) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        int i = 0;
        do {
            if(i < mSubDirectories.length) {
label0:
                {
                    if(!s.equals(mSubDirectories[i]))
                        break label0;
                    flag = true;
                }
            }
            if(true)
                continue;
            i++;
        } while(true);
        if(true) goto _L1; else goto _L3
_L3:
    }

    private final native void native_finalize();

    private final native void native_setup();

    private int renameFile(int i, String s) {
        Cursor cursor;
        String s1;
        String as[];
        cursor = null;
        s1 = null;
        as = new String[1];
        as[0] = Integer.toString(i);
        String s3;
        cursor = mMediaProvider.query(mObjectsUri, PATH_PROJECTION, "_id=?", as, null, null);
        if(cursor == null || !cursor.moveToNext())
            break MISSING_BLOCK_LABEL_68;
        s3 = cursor.getString(1);
        s1 = s3;
        if(cursor != null)
            cursor.close();
        if(s1 != null) goto _L2; else goto _L1
_L1:
        char c = '\u2009';
_L6:
        return c;
        RemoteException remoteexception;
        remoteexception;
        Log.e("MtpDatabase", "RemoteException in getObjectFilePath", remoteexception);
        c = '\u2002';
        if(cursor != null)
            cursor.close();
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        if(cursor != null)
            cursor.close();
        throw exception;
_L2:
        File file;
        String s2;
        File file1;
        ContentValues contentvalues;
        int k;
        if(isStorageSubDirectory(s1)) {
            c = '\u200D';
            continue; /* Loop/switch isn't completed */
        }
        file = new File(s1);
        int j = s1.lastIndexOf('/');
        if(j <= 1) {
            c = '\u2002';
            continue; /* Loop/switch isn't completed */
        }
        s2 = (new StringBuilder()).append(s1.substring(0, j + 1)).append(s).toString();
        file1 = new File(s2);
        if(!file.renameTo(file1)) {
            Log.w("MtpDatabase", (new StringBuilder()).append("renaming ").append(s1).append(" to ").append(s2).append(" failed").toString());
            c = '\u2002';
            continue; /* Loop/switch isn't completed */
        }
        contentvalues = new ContentValues();
        contentvalues.put("_data", s2);
        k = 0;
        int l = mMediaProvider.update(mObjectsUri, contentvalues, "_id=?", as);
        k = l;
_L4:
        if(k != 0)
            break; /* Loop/switch isn't completed */
        Log.e("MtpDatabase", (new StringBuilder()).append("Unable to update path for ").append(s1).append(" to ").append(s2).toString());
        file1.renameTo(file);
        c = '\u2002';
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception1;
        remoteexception1;
        Log.e("MtpDatabase", "RemoteException in mMediaProvider.update", remoteexception1);
        if(true) goto _L4; else goto _L3
_L3:
        if(!file1.isDirectory())
            break; /* Loop/switch isn't completed */
        if(file.getName().startsWith(".") && !s2.startsWith("."))
            try {
                mMediaProvider.call("unhide", s2, null);
            }
            catch(RemoteException remoteexception3) {
                Log.e("MtpDatabase", (new StringBuilder()).append("failed to unhide/rescan for ").append(s2).toString());
            }
_L8:
        c = '\u2001';
        if(true) goto _L6; else goto _L5
_L5:
        if(!file.getName().toLowerCase(Locale.US).equals(".nomedia") || s2.toLowerCase(Locale.US).equals(".nomedia")) goto _L8; else goto _L7
_L7:
        try {
            mMediaProvider.call("unhide", file.getParent(), null);
        }
        catch(RemoteException remoteexception2) {
            Log.e("MtpDatabase", (new StringBuilder()).append("failed to unhide/rescan for ").append(s2).toString());
        }
          goto _L8
    }

    private void sessionEnded() {
        if(mDatabaseModified) {
            mContext.sendBroadcast(new Intent("android.provider.action.MTP_SESSION_END"));
            mDatabaseModified = false;
        }
    }

    private void sessionStarted() {
        mDatabaseModified = false;
    }

    private int setDeviceProperty(int i, long l, String s) {
        i;
        JVM INSTR tableswitch 54273 54274: default 24
    //                   54273 32
    //                   54274 32;
           goto _L1 _L2 _L2
_L1:
        char c = '\u200A';
_L4:
        return c;
_L2:
        android.content.SharedPreferences.Editor editor = mDeviceProperties.edit();
        editor.putString(Integer.toString(i), s);
        if(editor.commit())
            c = '\u2001';
        else
            c = '\u2002';
        if(true) goto _L4; else goto _L3
_L3:
    }

    private int setObjectProperty(int i, int j, long l, String s) {
        j;
        JVM INSTR tableswitch 56327 56327: default 20
    //                   56327 28;
           goto _L1 _L2
_L1:
        int k = 43018;
_L4:
        return k;
_L2:
        k = renameFile(i, s);
        if(true) goto _L4; else goto _L3
_L3:
    }

    private int setObjectReferences(int i, int ai[]) {
        Uri uri;
        ContentValues acontentvalues[];
        mDatabaseModified = true;
        uri = android.provider.MediaStore.Files.getMtpReferencesUri(mVolumeName, i);
        int j = ai.length;
        acontentvalues = new ContentValues[j];
        for(int k = 0; k < j; k++) {
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("_id", Integer.valueOf(ai[k]));
            acontentvalues[k] = contentvalues;
        }

        int l = mMediaProvider.bulkInsert(uri, acontentvalues);
        if(l <= 0) goto _L2; else goto _L1
_L1:
        char c = '\u2001';
_L4:
        return c;
        RemoteException remoteexception;
        remoteexception;
        Log.e("MtpDatabase", "RemoteException in setObjectReferences", remoteexception);
_L2:
        c = '\u2002';
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void addStorage(MtpStorage mtpstorage) {
        mStorageMap.put(mtpstorage.getPath(), mtpstorage);
    }

    protected void finalize() throws Throwable {
        native_finalize();
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public void removeStorage(MtpStorage mtpstorage) {
        mStorageMap.remove(mtpstorage.getPath());
    }

    static final int ALL_PROPERTIES[];
    static final int AUDIO_PROPERTIES[];
    private static final int DEVICE_PROPERTIES_DATABASE_VERSION = 1;
    static final int FILE_PROPERTIES[];
    private static final String FORMAT_PARENT_WHERE = "parent=? AND parent=?";
    private static final String FORMAT_WHERE = "parent=?";
    private static final String ID_PROJECTION[];
    private static final String ID_WHERE = "_id=?";
    static final int IMAGE_PROPERTIES[];
    private static final String OBJECT_INFO_PROJECTION[];
    private static final String PARENT_WHERE = "format=?";
    private static final String PATH_PROJECTION[];
    private static final String PATH_SIZE_FORMAT_PROJECTION[];
    private static final String PATH_WHERE = "_data=?";
    private static final String STORAGE_FORMAT_PARENT_WHERE = "storage_id=? AND format=? AND parent=?";
    private static final String STORAGE_FORMAT_WHERE = "storage_id=? AND format=?";
    private static final String STORAGE_PARENT_WHERE = "storage_id=? AND parent=?";
    private static final String STORAGE_WHERE = "storage_id=?";
    private static final String TAG = "MtpDatabase";
    static final int VIDEO_PROPERTIES[];
    private final Context mContext;
    private boolean mDatabaseModified;
    private SharedPreferences mDeviceProperties;
    private final IContentProvider mMediaProvider;
    private final MediaScanner mMediaScanner;
    private final String mMediaStoragePath;
    private int mNativeContext;
    private final Uri mObjectsUri;
    private final HashMap mPropertyGroupsByFormat = new HashMap();
    private final HashMap mPropertyGroupsByProperty = new HashMap();
    private final HashMap mStorageMap = new HashMap();
    private final String mSubDirectories[];
    private String mSubDirectoriesWhere;
    private String mSubDirectoriesWhereArgs[];
    private final String mVolumeName;

    static  {
        String as[] = new String[1];
        as[0] = "_id";
        ID_PROJECTION = as;
        String as1[] = new String[2];
        as1[0] = "_id";
        as1[1] = "_data";
        PATH_PROJECTION = as1;
        String as2[] = new String[4];
        as2[0] = "_id";
        as2[1] = "_data";
        as2[2] = "_size";
        as2[3] = "format";
        PATH_SIZE_FORMAT_PROJECTION = as2;
        String as3[] = new String[7];
        as3[0] = "_id";
        as3[1] = "storage_id";
        as3[2] = "format";
        as3[3] = "parent";
        as3[4] = "_data";
        as3[5] = "_size";
        as3[6] = "date_modified";
        OBJECT_INFO_PROJECTION = as3;
        System.loadLibrary("media_jni");
        int ai[] = new int[10];
        ai[0] = 56321;
        ai[1] = 56322;
        ai[2] = 56323;
        ai[3] = 56324;
        ai[4] = 56327;
        ai[5] = 56329;
        ai[6] = 56331;
        ai[7] = 56385;
        ai[8] = 56388;
        ai[9] = 56398;
        FILE_PROPERTIES = ai;
        int ai1[] = new int[19];
        ai1[0] = 56321;
        ai1[1] = 56322;
        ai1[2] = 56323;
        ai1[3] = 56324;
        ai1[4] = 56327;
        ai1[5] = 56329;
        ai1[6] = 56331;
        ai1[7] = 56385;
        ai1[8] = 56388;
        ai1[9] = 56544;
        ai1[10] = 56398;
        ai1[11] = 56390;
        ai1[12] = 56474;
        ai1[13] = 56475;
        ai1[14] = 56459;
        ai1[15] = 56473;
        ai1[16] = 56457;
        ai1[17] = 56460;
        ai1[18] = 56470;
        AUDIO_PROPERTIES = ai1;
        int ai2[] = new int[15];
        ai2[0] = 56321;
        ai2[1] = 56322;
        ai2[2] = 56323;
        ai2[3] = 56324;
        ai2[4] = 56327;
        ai2[5] = 56329;
        ai2[6] = 56331;
        ai2[7] = 56385;
        ai2[8] = 56388;
        ai2[9] = 56544;
        ai2[10] = 56398;
        ai2[11] = 56390;
        ai2[12] = 56474;
        ai2[13] = 56457;
        ai2[14] = 56392;
        VIDEO_PROPERTIES = ai2;
        int ai3[] = new int[12];
        ai3[0] = 56321;
        ai3[1] = 56322;
        ai3[2] = 56323;
        ai3[3] = 56324;
        ai3[4] = 56327;
        ai3[5] = 56329;
        ai3[6] = 56331;
        ai3[7] = 56385;
        ai3[8] = 56388;
        ai3[9] = 56544;
        ai3[10] = 56398;
        ai3[11] = 56392;
        IMAGE_PROPERTIES = ai3;
        int ai4[] = new int[25];
        ai4[0] = 56321;
        ai4[1] = 56322;
        ai4[2] = 56323;
        ai4[3] = 56324;
        ai4[4] = 56327;
        ai4[5] = 56329;
        ai4[6] = 56331;
        ai4[7] = 56385;
        ai4[8] = 56388;
        ai4[9] = 56544;
        ai4[10] = 56398;
        ai4[11] = 56392;
        ai4[12] = 56390;
        ai4[13] = 56474;
        ai4[14] = 56475;
        ai4[15] = 56459;
        ai4[16] = 56473;
        ai4[17] = 56457;
        ai4[18] = 56460;
        ai4[19] = 56470;
        ai4[20] = 56390;
        ai4[21] = 56474;
        ai4[22] = 56457;
        ai4[23] = 56392;
        ai4[24] = 56392;
        ALL_PROPERTIES = ai4;
    }
}
