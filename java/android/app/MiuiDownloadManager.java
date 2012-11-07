// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.*;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.lang.reflect.Array;
import java.util.List;

// Referenced classes of package android.app:
//            DownloadManager

public class MiuiDownloadManager extends DownloadManager {
    public static class Query extends DownloadManager.Query {

        void addExtraSelectionParts(List list) {
            super.addExtraSelectionParts(list);
            if(!TextUtils.isEmpty(mColumnAppData)) {
                Object aobj1[] = new Object[2];
                aobj1[0] = "entity";
                aobj1[1] = mColumnAppData;
                list.add(String.format("%s='%s'", aobj1));
            }
            if(!TextUtils.isEmpty(mColumnNotificationPackage)) {
                Object aobj[] = new Object[2];
                aobj[0] = "notificationpackage";
                aobj[1] = mColumnNotificationPackage;
                list.add(String.format("%s='%s'", aobj));
            }
            if(!TextUtils.isEmpty(mAppendedClause))
                list.add(mAppendedClause);
        }

        public volatile DownloadManager.Query orderBy(String s, int i) {
            return orderBy(s, i);
        }

        public Query orderBy(String s, int i) {
            if(i != 1 && i != 2)
                throw new IllegalArgumentException((new StringBuilder()).append("Invalid direction: ").append(i).toString());
            if(s.equals("_id")) {
                setOrderByColumn("_id");
                setOrderDirection(i);
            } else {
                super.orderBy(s, i);
            }
            return this;
        }

        public Query setFilterByAppData(String s) {
            mColumnAppData = s;
            return this;
        }

        public Query setFilterByAppendedClause(String s) {
            mAppendedClause = s;
            return this;
        }

        public Query setFilterByNotificationPackage(String s) {
            mColumnNotificationPackage = s;
            return this;
        }

        private String mAppendedClause;
        private String mColumnAppData;
        private String mColumnNotificationPackage;

        public Query() {
        }
    }

    public static class Request extends DownloadManager.Request {

        private void putIfNonNull(ContentValues contentvalues, String s, Object obj) {
            if(obj != null)
                contentvalues.put(s, obj.toString());
        }

        public Request setAppData(String s) {
            mColumnAppData = s;
            return this;
        }

        public Request setAppointName(String s) {
            mAppointName = s;
            return this;
        }

        public void setBypassRecommendedSizeLimit(boolean flag) {
            mBypassRecommendedSizeLimit = flag;
        }

        public Request setNotificationClass(String s) {
            mNotificationClass = s;
            return this;
        }

        public void setUserAgent(String s) {
            mUserAgent = s;
        }

        protected ContentValues toContentValues(String s) {
            ContentValues contentvalues = super.toContentValues(s);
            putIfNonNull(contentvalues, "entity", mColumnAppData);
            putIfNonNull(contentvalues, "appointname", mAppointName);
            putIfNonNull(contentvalues, "notificationclass", mNotificationClass);
            putIfNonNull(contentvalues, "useragent", mUserAgent);
            contentvalues.put("bypass_recommended_size_limit", Boolean.valueOf(mBypassRecommendedSizeLimit));
            return contentvalues;
        }

        private String mAppointName;
        private boolean mBypassRecommendedSizeLimit;
        private String mColumnAppData;
        private String mNotificationClass;
        private String mUserAgent;

        public Request(Uri uri) {
            super(uri);
        }
    }


    public MiuiDownloadManager(ContentResolver contentresolver, String s) {
        super(contentresolver, s);
        mResolver = contentresolver;
    }

    public static void addRunningStatusAndControlRun(ContentValues contentvalues) {
        if(contentvalues != null) {
            contentvalues.put("status", Integer.valueOf(192));
            contentvalues.put("control", Integer.valueOf(0));
        }
    }

    private static Object[] concatArrays(Object aobj[], Object aobj1[], Class class1) {
        Object aobj2[] = (Object[])(Object[])Array.newInstance(class1, aobj.length + aobj1.length);
        System.arraycopy(((Object) (aobj)), 0, ((Object) (aobj2)), 0, aobj.length);
        System.arraycopy(((Object) (aobj1)), 0, ((Object) (aobj2)), aobj.length, aobj1.length);
        return aobj2;
    }

    public static Integer getMobileFileSizePromptEnabled(Context context) {
        Integer integer1 = Integer.valueOf(android.provider.Settings.Secure.getInt(context.getContentResolver(), miui.provider.ExtraSettings.Secure.MOBILE_DOWNLOAD_FILE_SIZE_PROMPT_POPUP_ENABLED));
        Integer integer = integer1;
_L2:
        return integer;
        android.provider.Settings.SettingNotFoundException settingnotfoundexception;
        settingnotfoundexception;
        integer = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private static String[] getWhereArgsForStatuses(int ai[]) {
        String as[] = new String[ai.length];
        for(int i = 0; i < ai.length; i++)
            as[i] = Integer.toString(ai[i]);

        return as;
    }

    private static String getWhereClauseForStatuses(String as[], String as1[]) {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("(");
        for(int i = 0; i < as.length; i++) {
            if(i > 0)
                stringbuilder.append((new StringBuilder()).append(as1[i - 1]).append(" ").toString());
            stringbuilder.append("status");
            stringbuilder.append((new StringBuilder()).append(" ").append(as[i]).append(" ? ").toString());
        }

        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public static boolean isDownloadSuccess(Cursor cursor) {
        DownloadManager.CursorTranslator cursortranslator = (DownloadManager.CursorTranslator)cursor;
        boolean flag;
        if(cursortranslator.getInt(cursortranslator.getColumnIndex("status")) == 8)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isDownloading(Cursor cursor) {
        boolean flag;
        DownloadManager.CursorTranslator cursortranslator;
        flag = false;
        cursortranslator = (DownloadManager.CursorTranslator)cursor;
        cursortranslator.getInt(cursortranslator.getColumnIndex("status"));
        JVM INSTR tableswitch 1 2: default 40
    //                   1 42
    //                   2 42;
           goto _L1 _L2 _L2
_L1:
        return flag;
_L2:
        flag = true;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static void operateDownloadsNeedToUpdateProgress(Context context, long al[], long al1[]) {
        Intent intent = new Intent("android.intent.action.OPERATE_DOWNLOADSET_UPDATE_PROGRESS");
        intent.setComponent(DOWNLOAD_UPDATE_RECEIVER_COMPONENT);
        intent.putExtra("intent_extra_register_downloads_update_progress", al);
        intent.putExtra("intent_extra_unregister_downloads_update_progress", al1);
        context.sendBroadcast(intent);
    }

    public static boolean setMobileFileSizePromptEnabled(Context context, boolean flag) {
        ContentResolver contentresolver = context.getContentResolver();
        String s = miui.provider.ExtraSettings.Secure.MOBILE_DOWNLOAD_FILE_SIZE_PROMPT_POPUP_ENABLED;
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        return android.provider.Settings.Secure.putInt(contentresolver, s, i);
    }

    public static boolean setRecommendedMaxBytesOverMobile(Context context, long l) {
        return android.provider.Settings.Secure.putLong(context.getContentResolver(), "download_manager_recommended_max_bytes_over_mobile", l);
    }

    public static int translateStatus(int i) {
        return DownloadManager.CursorTranslator.translateStatus(i);
    }

    public transient void pauseDownload(long al[]) {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("status", Integer.valueOf(193));
        contentvalues.put("control", Integer.valueOf(1));
        StringBuilder stringbuilder = (new StringBuilder()).append("( ").append(getWhereClauseForIds(al)).append(" AND ");
        String as[] = new String[2];
        as[0] = "!=";
        as[1] = "!=";
        String as1[] = new String[1];
        as1[0] = "AND";
        String s = stringbuilder.append(getWhereClauseForStatuses(as, as1)).append(")").toString();
        String as2[] = getWhereArgsForIds(al);
        int ai[] = new int[2];
        ai[0] = 1;
        ai[1] = 2;
        String as3[] = (String[])concatArrays(as2, getWhereArgsForStatuses(ai), java/lang/String);
        mResolver.update(getBaseUri(), contentvalues, s, as3);
    }

    public Cursor query(DownloadManager.Query query1) {
        Cursor cursor = query1.runQuery(mResolver, MIUI_UNDERLYING_COLUMNS, getBaseUri());
        Object obj;
        if(cursor == null)
            obj = null;
        else
            obj = new DownloadManager.CursorTranslator(cursor, getBaseUri());
        return ((Cursor) (obj));
    }

    public transient int removeRecordOnly(long al[]) {
        if(al == null || al.length == 0)
            throw new IllegalArgumentException("input param 'ids' can't be null");
        else
            return mResolver.delete(getBaseUri(), getWhereClauseForIds(al), getWhereArgsForIds(al));
    }

    public transient void resumeDownload(long al[]) {
        ContentValues contentvalues = new ContentValues();
        addRunningStatusAndControlRun(contentvalues);
        StringBuilder stringbuilder = (new StringBuilder()).append("( ").append(getWhereClauseForIds(al)).append(" AND ");
        String as[] = new String[1];
        as[0] = "!=";
        String s = stringbuilder.append(getWhereClauseForStatuses(as, null)).append(")").toString();
        String as1[] = getWhereArgsForIds(al);
        int ai[] = new int[1];
        ai[0] = 4;
        String as2[] = (String[])concatArrays(as1, getWhereArgsForStatuses(ai), java/lang/String);
        mResolver.update(getBaseUri(), contentvalues, s, as2);
    }

    public static final String ACTION_DOWNLOAD_DELETED = "android.intent.action.DOWNLOAD_DELETED";
    public static final String ACTION_DOWNLOAD_UPDATED = "android.intent.action.DOWNLOAD_UPDATED";
    public static final String ACTION_OPERATE_DOWNLOADSET_UPDATE_PROGRESS = "android.intent.action.OPERATE_DOWNLOADSET_UPDATE_PROGRESS";
    private static final ComponentName DOWNLOAD_UPDATE_RECEIVER_COMPONENT = new ComponentName("com.android.providers.downloads", "com.android.providers.downloads.DownloadUpdateReceiver");
    public static final String EXTRA_DOWNLOAD_CURRENT_BYTES = "extra_download_current_bytes";
    public static final String EXTRA_DOWNLOAD_STATUS = "extra_download_status";
    public static final String EXTRA_DOWNLOAD_TOTAL_BYTES = "extra_download_total_bytes";
    public static final String INTENT_EXTRA_APPLICATION_PACKAGENAME = "intent_extra_application_packagename";
    public static final String INTENT_EXTRA_REGISTER_DOWNLOADS_UPDATE_PROGRESS = "intent_extra_register_downloads_update_progress";
    public static final String INTENT_EXTRA_UNREGISTER_DOWNLOADS_UPDATE_PROGRESS = "intent_extra_unregister_downloads_update_progress";
    public static final String MIUI_UNDERLYING_COLUMNS[];
    public static final int PAUSED_BY_APP = 5;
    private ContentResolver mResolver;

    static  {
        String as[] = UNDERLYING_COLUMNS;
        String as1[] = new String[2];
        as1[0] = "bypass_recommended_size_limit";
        as1[1] = "allowed_network_types";
        MIUI_UNDERLYING_COLUMNS = (String[])concatArrays(as, as1, java/lang/String);
    }
}
