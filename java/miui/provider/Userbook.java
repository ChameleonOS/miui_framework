// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import java.util.ArrayList;
import java.util.List;

public class Userbook {
    public static interface Columns {

        public static final String ACHIEVED = "achieved";
        public static final String DATA1 = "data1";
        public static final String DATA2 = "data2";
        public static final String DATA3 = "data3";
        public static final String FEATURE = "feature";
        public static final String ID = "_id";
        public static final String PACKAGE = "package";
        public static final String READ = "read";
        public static final String VERSION = "version";
    }


    public Userbook() {
    }

    public static int delete(ContentResolver contentresolver, String s, String s1) {
        Uri uri = CONTENT_URI;
        String as[] = new String[2];
        as[0] = s;
        as[1] = s1;
        return contentresolver.delete(uri, "package=? AND feature=?", as);
    }

    public static boolean getAchieved(ContentResolver contentresolver, String s, String s1, boolean flag) {
        return getState(contentresolver, s, s1, flag, "achieved");
    }

    public static List getPackageAchievedFeatures(ContentResolver contentresolver, String s, boolean flag) {
        int i = 1;
        StringBuilder stringbuilder = (new StringBuilder()).append("achieved=");
        if(flag != i)
            i = 0;
        return getPackageFeatures(contentresolver, s, stringbuilder.append(i).toString());
    }

    private static List getPackageFeatures(ContentResolver contentresolver, String s, String s1) {
        String s2 = (new StringBuilder()).append(s1).append(" AND package='").append(s).append("'").toString();
        Uri uri = CONTENT_URI;
        String as[] = new String[1];
        as[0] = "feature";
        Cursor cursor = contentresolver.query(uri, as, s2, null, null);
        ArrayList arraylist = new ArrayList();
        if(cursor != null) {
            if(cursor.moveToFirst())
                do
                    arraylist.add(cursor.getString(0));
                while(cursor.moveToNext());
            cursor.close();
        }
        return arraylist;
    }

    public static List getPackageReadFeatures(ContentResolver contentresolver, String s, boolean flag) {
        int i = 1;
        StringBuilder stringbuilder = (new StringBuilder()).append("read=");
        if(flag != i)
            i = 0;
        return getPackageFeatures(contentresolver, s, stringbuilder.append(i).toString());
    }

    public static boolean getRead(ContentResolver contentresolver, String s, String s1, boolean flag) {
        return getState(contentresolver, s, s1, flag, "read");
    }

    private static boolean getState(ContentResolver contentresolver, String s, String s1, boolean flag, String s2) {
        boolean flag1 = flag;
        Uri uri = CONTENT_URI;
        String as[] = new String[1];
        as[0] = s2;
        String as1[] = new String[2];
        as1[0] = s;
        as1[1] = s1;
        Cursor cursor = contentresolver.query(uri, as, "package=? AND feature=?", as1, null);
        if(cursor != null) {
            if(cursor.moveToFirst())
                if(cursor.getInt(0) > 0)
                    flag1 = true;
                else
                    flag1 = false;
            cursor.close();
        }
        return flag1;
    }

    private static void insertOrUpdate(ContentResolver contentresolver, String s, String s1, boolean flag, String s2) {
        Uri uri = CONTENT_URI;
        String as[] = new String[1];
        as[0] = s2;
        String as1[] = new String[2];
        as1[0] = s;
        as1[1] = s1;
        Cursor cursor = contentresolver.query(uri, as, "package=? AND feature=?", as1, null);
        boolean flag1 = false;
        if(cursor != null) {
            flag1 = cursor.moveToFirst();
            cursor.close();
        }
        ContentValues contentvalues = new ContentValues();
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        contentvalues.put(s2, Integer.valueOf(i));
        if(flag1) {
            Uri uri1 = CONTENT_URI;
            String as2[] = new String[2];
            as2[0] = s;
            as2[1] = s1;
            contentresolver.update(uri1, contentvalues, "package=? AND feature=?", as2);
        } else {
            contentvalues.put("package", s);
            contentvalues.put("feature", s1);
            contentresolver.insert(CONTENT_URI, contentvalues);
        }
    }

    public static void setAchieved(ContentResolver contentresolver, String s, String s1, boolean flag) {
        insertOrUpdate(contentresolver, s, s1, flag, "achieved");
    }

    public static void setRead(ContentResolver contentresolver, String s, String s1, boolean flag) {
        insertOrUpdate(contentresolver, s, s1, flag, "read");
    }

    public static final String AUTHORITY = "userbook";
    public static final Uri CONTENT_URI = Uri.parse("content://userbook/feature");
    private static final String SELECTION = "package=? AND feature=?";

}
