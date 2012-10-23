// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import android.app.Activity;
import android.content.*;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import com.android.internal.database.SortCursor;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.media:
//            Ringtone

public class RingtoneManager {

    public RingtoneManager(Activity activity) {
        mType = 1;
        mFilterColumns = new ArrayList();
        mStopPreviousRingtone = true;
        mActivity = activity;
        mContext = activity;
        setType(mType);
    }

    public RingtoneManager(Context context) {
        mType = 1;
        mFilterColumns = new ArrayList();
        mStopPreviousRingtone = true;
        mContext = context;
        setType(mType);
    }

    private static String constructBooleanTrueWhereClause(List list, boolean flag) {
        String s;
        if(list == null) {
            s = null;
        } else {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("(");
            for(int i = -1 + list.size(); i >= 0; i--)
                stringbuilder.append((String)list.get(i)).append("=1 or ");

            if(list.size() > 0)
                stringbuilder.setLength(-4 + stringbuilder.length());
            stringbuilder.append(")");
            if(!flag) {
                stringbuilder.append(" and ");
                stringbuilder.append("is_drm");
                stringbuilder.append("=0");
            }
            s = stringbuilder.toString();
        }
        return s;
    }

    public static Uri getActualDefaultRingtoneUri(Context context, int i) {
        Uri uri;
        String s;
        uri = null;
        s = getSettingForType(i);
        if(s != null) goto _L2; else goto _L1
_L1:
        return uri;
_L2:
        String s1 = android.provider.Settings.System.getString(context.getContentResolver(), s);
        if(s1 != null)
            uri = Uri.parse(s1);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static int getDefaultType(Uri uri) {
        byte byte0 = -1;
        if(uri != null) goto _L2; else goto _L1
_L1:
        return byte0;
_L2:
        if(uri.equals(android.provider.Settings.System.DEFAULT_RINGTONE_URI))
            byte0 = 1;
        else
        if(uri.equals(android.provider.Settings.System.DEFAULT_NOTIFICATION_URI))
            byte0 = 2;
        else
        if(uri.equals(android.provider.Settings.System.DEFAULT_ALARM_ALERT_URI))
            byte0 = 4;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static Uri getDefaultUri(int i) {
        Uri uri;
        if((i & 1) != 0)
            uri = android.provider.Settings.System.DEFAULT_RINGTONE_URI;
        else
        if((i & 2) != 0)
            uri = android.provider.Settings.System.DEFAULT_NOTIFICATION_URI;
        else
        if((i & 4) != 0)
            uri = android.provider.Settings.System.DEFAULT_ALARM_ALERT_URI;
        else
            uri = null;
        return uri;
    }

    private Cursor getDrmRingtones() {
        return query(android.provider.DrmStore.Audio.CONTENT_URI, DRM_COLUMNS, null, null, "title");
    }

    private Cursor getInternalRingtones() {
        return query(android.provider.MediaStore.Audio.Media.INTERNAL_CONTENT_URI, INTERNAL_COLUMNS, constructBooleanTrueWhereClause(mFilterColumns, mIncludeDrm), null, "title_key");
    }

    private Cursor getMediaRingtones() {
        Cursor cursor = null;
        String s = Environment.getExternalStorageState();
        if(s.equals("mounted") || s.equals("mounted_ro"))
            cursor = query(android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, MEDIA_COLUMNS, constructBooleanTrueWhereClause(mFilterColumns, mIncludeDrm), null, "title_key");
        return cursor;
    }

    public static Ringtone getRingtone(Context context, Uri uri) {
        return getRingtone(context, uri, -1);
    }

    private static Ringtone getRingtone(Context context, Uri uri, int i) {
        Ringtone ringtone;
        try {
            ringtone = new Ringtone(context, true);
            if(i >= 0)
                ringtone.setStreamType(i);
            ringtone.setUri(uri);
        }
        catch(Exception exception) {
            Log.e("RingtoneManager", (new StringBuilder()).append("Failed to open ringtone ").append(uri).append(": ").append(exception).toString());
            ringtone = null;
        }
        return ringtone;
    }

    private static String getSettingForType(int i) {
        String s;
        if((i & 1) != 0)
            s = "ringtone";
        else
        if((i & 2) != 0)
            s = "notification_sound";
        else
        if((i & 4) != 0)
            s = "alarm_alert";
        else
            s = null;
        return s;
    }

    private static Uri getUriFromCursor(Cursor cursor) {
        return ContentUris.withAppendedId(Uri.parse(cursor.getString(2)), cursor.getLong(0));
    }

    public static Uri getValidRingtoneUri(Context context) {
        RingtoneManager ringtonemanager = new RingtoneManager(context);
        Uri uri = getValidRingtoneUriFromCursorAndClose(context, ringtonemanager.getInternalRingtones());
        if(uri == null)
            uri = getValidRingtoneUriFromCursorAndClose(context, ringtonemanager.getMediaRingtones());
        if(uri == null)
            uri = getValidRingtoneUriFromCursorAndClose(context, ringtonemanager.getDrmRingtones());
        return uri;
    }

    private static Uri getValidRingtoneUriFromCursorAndClose(Context context, Cursor cursor) {
        Uri uri;
        if(cursor != null) {
            uri = null;
            if(cursor.moveToFirst())
                uri = getUriFromCursor(cursor);
            cursor.close();
        } else {
            uri = null;
        }
        return uri;
    }

    public static boolean isDefault(Uri uri) {
        boolean flag;
        if(getDefaultType(uri) != -1)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private Cursor query(Uri uri, String as[], String s, String as1[], String s1) {
        Cursor cursor;
        if(mActivity != null)
            cursor = mActivity.managedQuery(uri, as, s, as1, s1);
        else
            cursor = mContext.getContentResolver().query(uri, as, s, as1, s1);
        return cursor;
    }

    public static void setActualDefaultRingtoneUri(Context context, int i, Uri uri) {
        String s = getSettingForType(i);
        if(s != null) {
            ContentResolver contentresolver = context.getContentResolver();
            String s1;
            if(uri != null)
                s1 = uri.toString();
            else
                s1 = null;
            android.provider.Settings.System.putString(contentresolver, s, s1);
        }
    }

    private void setFilterColumnsList(int i) {
        List list = mFilterColumns;
        list.clear();
        if((i & 1) != 0)
            list.add("is_ringtone");
        if((i & 2) != 0)
            list.add("is_notification");
        if((i & 4) != 0)
            list.add("is_alarm");
    }

    public Cursor getCursor() {
        Object obj;
        if(mCursor != null && mCursor.requery()) {
            obj = mCursor;
        } else {
            Cursor cursor = getInternalRingtones();
            Cursor cursor1;
            Cursor cursor2;
            Cursor acursor[];
            if(mIncludeDrm)
                cursor1 = getDrmRingtones();
            else
                cursor1 = null;
            cursor2 = getMediaRingtones();
            acursor = new Cursor[3];
            acursor[0] = cursor;
            acursor[1] = cursor1;
            acursor[2] = cursor2;
            obj = new SortCursor(acursor, "title_key");
            mCursor = ((Cursor) (obj));
        }
        return ((Cursor) (obj));
    }

    public boolean getIncludeDrm() {
        return mIncludeDrm;
    }

    public Ringtone getRingtone(int i) {
        if(mStopPreviousRingtone && mPreviousRingtone != null)
            mPreviousRingtone.stop();
        mPreviousRingtone = getRingtone(mContext, getRingtoneUri(i), inferStreamType());
        return mPreviousRingtone;
    }

    public int getRingtonePosition(Uri uri) {
        if(uri != null) goto _L2; else goto _L1
_L1:
        int j = -1;
_L4:
        return j;
_L2:
        Cursor cursor = getCursor();
        int i = cursor.getCount();
        if(!cursor.moveToFirst()) {
            j = -1;
            continue; /* Loop/switch isn't completed */
        }
        Uri uri1 = null;
        String s = null;
        for(j = 0; j < i; j++) {
            String s1 = cursor.getString(2);
            if(uri1 == null || !s1.equals(s))
                uri1 = Uri.parse(s1);
            if(uri.equals(ContentUris.withAppendedId(uri1, cursor.getLong(0))))
                continue; /* Loop/switch isn't completed */
            cursor.move(1);
            s = s1;
        }

        j = -1;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public Uri getRingtoneUri(int i) {
        Uri uri;
        if(mCursor == null || !mCursor.moveToPosition(i))
            uri = null;
        else
            uri = getUriFromCursor(mCursor);
        return uri;
    }

    public boolean getStopPreviousRingtone() {
        return mStopPreviousRingtone;
    }

    public int inferStreamType() {
        mType;
        JVM INSTR tableswitch 2 4: default 32
    //                   2 41
    //                   3 32
    //                   4 36;
           goto _L1 _L2 _L1 _L3
_L1:
        byte byte0 = 2;
_L5:
        return byte0;
_L3:
        byte0 = 4;
        continue; /* Loop/switch isn't completed */
_L2:
        byte0 = 5;
        if(true) goto _L5; else goto _L4
_L4:
    }

    public void setIncludeDrm(boolean flag) {
        mIncludeDrm = flag;
    }

    public void setStopPreviousRingtone(boolean flag) {
        mStopPreviousRingtone = flag;
    }

    public void setType(int i) {
        if(mCursor != null) {
            throw new IllegalStateException("Setting filter columns should be done before querying for ringtones.");
        } else {
            mType = i;
            setFilterColumnsList(i);
            return;
        }
    }

    public void stopPreviousRingtone() {
        if(mPreviousRingtone != null)
            mPreviousRingtone.stop();
    }

    public static final String ACTION_RINGTONE_PICKER = "android.intent.action.RINGTONE_PICKER";
    private static final String DRM_COLUMNS[];
    public static final String EXTRA_RINGTONE_DEFAULT_URI = "android.intent.extra.ringtone.DEFAULT_URI";
    public static final String EXTRA_RINGTONE_EXISTING_URI = "android.intent.extra.ringtone.EXISTING_URI";
    public static final String EXTRA_RINGTONE_INCLUDE_DRM = "android.intent.extra.ringtone.INCLUDE_DRM";
    public static final String EXTRA_RINGTONE_PICKED_URI = "android.intent.extra.ringtone.PICKED_URI";
    public static final String EXTRA_RINGTONE_SHOW_DEFAULT = "android.intent.extra.ringtone.SHOW_DEFAULT";
    public static final String EXTRA_RINGTONE_SHOW_SILENT = "android.intent.extra.ringtone.SHOW_SILENT";
    public static final String EXTRA_RINGTONE_TITLE = "android.intent.extra.ringtone.TITLE";
    public static final String EXTRA_RINGTONE_TYPE = "android.intent.extra.ringtone.TYPE";
    public static final int ID_COLUMN_INDEX = 0;
    private static final String INTERNAL_COLUMNS[];
    private static final String MEDIA_COLUMNS[];
    private static final String TAG = "RingtoneManager";
    public static final int TITLE_COLUMN_INDEX = 1;
    public static final int TYPE_ALARM = 4;
    public static final int TYPE_ALL = 7;
    public static final int TYPE_NOTIFICATION = 2;
    public static final int TYPE_RINGTONE = 1;
    public static final int URI_COLUMN_INDEX = 2;
    private Activity mActivity;
    private Context mContext;
    private Cursor mCursor;
    private final List mFilterColumns;
    private boolean mIncludeDrm;
    private Ringtone mPreviousRingtone;
    private boolean mStopPreviousRingtone;
    private int mType;

    static  {
        String as[] = new String[4];
        as[0] = "_id";
        as[1] = "title";
        as[2] = (new StringBuilder()).append("\"").append(android.provider.MediaStore.Audio.Media.INTERNAL_CONTENT_URI).append("\"").toString();
        as[3] = "title_key";
        INTERNAL_COLUMNS = as;
        String as1[] = new String[4];
        as1[0] = "_id";
        as1[1] = "title";
        as1[2] = (new StringBuilder()).append("\"").append(android.provider.DrmStore.Audio.CONTENT_URI).append("\"").toString();
        as1[3] = "title AS title_key";
        DRM_COLUMNS = as1;
        String as2[] = new String[4];
        as2[0] = "_id";
        as2[1] = "title";
        as2[2] = (new StringBuilder()).append("\"").append(android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI).append("\"").toString();
        as2[3] = "title_key";
        MEDIA_COLUMNS = as2;
    }
}
