// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.provider;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.*;
import android.location.Location;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import miui.os.ExtraFileUtils;
import miui.util.ImageUtils;

public class GalleryCloudUtils {
    public static class SaveToCloudDB {

        public long dateTaken;
        public String fileName;
        public int groupId;
        public int height;
        public int localFlag;
        public Location location;
        public String mimeType;
        public int orientation;
        public String path;
        public int serverType;
        public long size;
        public String title;
        public int width;

        public SaveToCloudDB(String s, long l, String s1, String s2, String s3, long l1, int i, int j, int k, Location location1, int i1, int j1, 
                int k1) {
            path = s;
            size = l;
            mimeType = s1;
            title = s2;
            fileName = s3;
            dateTaken = l1;
            width = i;
            height = j;
            orientation = k;
            location = location1;
            groupId = i1;
            serverType = j1;
            localFlag = k1;
        }
    }


    public GalleryCloudUtils() {
    }

    public static boolean existXiaomiAccount(Context context) {
        boolean flag;
        if(findXiaomiAccount(context) != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static Account findXiaomiAccount(Context context) {
        Account account;
        Account aaccount[];
        account = null;
        aaccount = AccountManager.get(context).getAccounts();
        if(aaccount != null) goto _L2; else goto _L1
_L1:
        return account;
_L2:
        int i = 0;
        do {
            if(i < aaccount.length) {
label0:
                {
                    if(!aaccount[i].type.equals("com.xiaomi"))
                        break label0;
                    account = aaccount[i];
                }
            }
            if(true)
                continue;
            i++;
        } while(true);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static String getMimeTypeByGroupID(int i) {
        String s;
        if(i == 1)
            s = "image/jpeg";
        else
        if(i == 2)
            s = "image/png";
        else
            s = "";
        return s;
    }

    public static boolean isGalleryCloudSyncable(Context context) {
        boolean flag;
        Account account;
        flag = false;
        account = findXiaomiAccount(context);
        if(account != null) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        context.getContentResolver();
        if(ContentResolver.getMasterSyncAutomatically() && ContentResolver.getSyncAutomatically(account, "com.miui.gallery.cloud.provider"))
            flag = true;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static void requestSync(Context context) {
        requestSync(context, isGalleryCloudSyncable(context));
    }

    private static void requestSync(Context context, boolean flag) {
        if(flag) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Account account = findXiaomiAccount(context);
        if(account != null)
            ContentResolver.requestSync(account, "com.miui.gallery.cloud.provider", new Bundle());
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static void saveToCloudDB(Context context, String s, int i, int j) {
        byte byte0 = 1;
        if(isGalleryCloudSyncable(context))
            byte0 = 4;
        saveToCloudDBWithoutSync(context, s, i, j, byte0);
        requestSync(context);
    }

    public static void saveToCloudDBWithoutSync(Context context, String s, int i, int j, int k) {
        File file = new File(s);
        if(!file.exists())
            Log.d("GalleryCloudUtils", (new StringBuilder()).append("file not exist:").append(s).toString());
        else
            saveToCloudDBWithoutSync(context, new SaveToCloudDB(s, file.length(), getMimeTypeByGroupID(i), ExtraFileUtils.getFileTitle(file), file.getName(), file.lastModified(), 0, 0, 0, null, i, j, k));
    }

    private static void saveToCloudDBWithoutSync(Context context, SaveToCloudDB savetoclouddb) {
        long l = System.currentTimeMillis();
        if(existXiaomiAccount(context)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        ExifInterface exifinterface;
        ContentValues contentvalues;
        String s;
        exifinterface = new ExifInterface(savetoclouddb.path);
        contentvalues = new ContentValues();
        contentvalues.put("groupId", Integer.valueOf(savetoclouddb.groupId));
        contentvalues.put("serverType", Integer.valueOf(savetoclouddb.serverType));
        contentvalues.put("localFlag", Integer.valueOf(savetoclouddb.localFlag));
        contentvalues.put("size", Long.valueOf(savetoclouddb.size));
        contentvalues.put("mimeType", savetoclouddb.mimeType);
        contentvalues.put("title", savetoclouddb.title);
        contentvalues.put("fileName", savetoclouddb.fileName);
        contentvalues.put("dateTaken", Long.valueOf(savetoclouddb.dateTaken));
        File file = new File(savetoclouddb.path);
        if(file.exists())
            contentvalues.put("dateModified", Long.valueOf(file.lastModified()));
        contentvalues.put("localFile", savetoclouddb.path);
        int i = exifinterface.getAttributeInt("ImageWidth", 0);
        int j = exifinterface.getAttributeInt("ImageLength", 0);
        if(i == 0 || j == 0) {
            android.graphics.BitmapFactory.Options options = ImageUtils.getBitmapSize(savetoclouddb.path);
            i = options.outWidth;
            j = options.outHeight;
        }
        contentvalues.put("exifImageWidth", Integer.valueOf(i));
        contentvalues.put("exifImageLength", Integer.valueOf(j));
        contentvalues.put("exifOrientation", Integer.valueOf(exifinterface.getAttributeInt("Orientation", savetoclouddb.orientation)));
        s = exifinterface.getAttribute("GPSLatitude");
        if(s != null) goto _L4; else goto _L3
_L3:
        if(savetoclouddb.location == null) goto _L6; else goto _L5
_L5:
        Double double2 = Double.valueOf(savetoclouddb.location.getLatitude());
_L11:
        s = String.valueOf(double2);
_L4:
        String s1;
        contentvalues.put("exifGPSLatitude", s);
        s1 = exifinterface.getAttribute("GPSLongitude");
        if(s1 != null) goto _L8; else goto _L7
_L7:
        if(savetoclouddb.location == null) goto _L10; else goto _L9
_L9:
        Double double1 = Double.valueOf(savetoclouddb.location.getLongitude());
_L12:
        s1 = String.valueOf(double1);
_L8:
        contentvalues.put("exifGPSLongitude", s1);
        contentvalues.put("exifMake", exifinterface.getAttribute("Make"));
        contentvalues.put("exifModel", exifinterface.getAttribute("Model"));
        contentvalues.put("exifFlash", Integer.valueOf(exifinterface.getAttributeInt("Flash", 0)));
        contentvalues.put("exifGPSLatitudeRef", exifinterface.getAttribute("GPSLatitudeRef"));
        contentvalues.put("exifGPSLongitudeRef", exifinterface.getAttribute("GPSLongitudeRef"));
        contentvalues.put("exifExposureTime", exifinterface.getAttribute("ExposureTime"));
        contentvalues.put("exifFNumber", exifinterface.getAttribute("FNumber"));
        contentvalues.put("exifISOSpeedRatings", exifinterface.getAttribute("ISOSpeedRatings"));
        contentvalues.put("exifGPSAltitude", exifinterface.getAttribute("GPSAltitude"));
        contentvalues.put("exifGPSAltitudeRef", Integer.valueOf(exifinterface.getAttributeInt("GPSAltitudeRef", 0)));
        contentvalues.put("exifGPSTimeStamp", exifinterface.getAttribute("GPSTimeStamp"));
        contentvalues.put("exifGPSDateStamp", exifinterface.getAttribute("GPSDateStamp"));
        contentvalues.put("exifWhiteBalance", Integer.valueOf(exifinterface.getAttributeInt("WhiteBalance", 0)));
        contentvalues.put("exifFocalLength", exifinterface.getAttribute("FocalLength"));
        contentvalues.put("exifGPSProcessingMethod", exifinterface.getAttribute("GPSProcessingMethod"));
        contentvalues.put("exifDateTime", exifinterface.getAttribute("DateTime"));
        if(context.getContentResolver().insert(CLOUD_URI, contentvalues) == null)
            Log.e("GalleryCloudUtils", (new StringBuilder()).append("saveToCloudDB, insert ").append(savetoclouddb.path).append(" into database error.").toString());
_L13:
        Log.d("GalleryCloudUtils", (new StringBuilder()).append("save to cloud db finished, time:").append(System.currentTimeMillis() - l).toString());
          goto _L1
_L6:
        double2 = null;
          goto _L11
_L10:
        double1 = null;
          goto _L12
        IOException ioexception;
        ioexception;
        Log.e("GalleryCloudUtils", (new StringBuilder()).append("saveToCloudDB, create ").append(savetoclouddb.path).append(" ExifInterface error.").toString());
          goto _L13
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        Log.e("GalleryCloudUtils", (new StringBuilder()).append("saveToCloudDB failed:").append(illegalargumentexception).toString());
          goto _L13
    }

    public static final String AUTHORITY = "com.miui.gallery.cloud.provider";
    public static final Uri BASE_URI;
    public static final Uri CLOUD_SETTING_URI;
    public static final Uri CLOUD_URI;
    public static final String EXTRA_FILE_PATH = "extra_file_path";
    public static final String SAVE_TO_CLOUD_ACTION = "com.miui.gallery.save_to_cloud_action";
    private static final String TAG = "GalleryCloudUtils";

    static  {
        BASE_URI = Uri.parse("content://com.miui.gallery.cloud.provider");
        CLOUD_URI = BASE_URI.buildUpon().appendPath("cloud").build();
        CLOUD_SETTING_URI = BASE_URI.buildUpon().appendPath("cloudSetting").build();
    }
}
