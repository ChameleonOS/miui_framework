// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import java.io.IOException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

public class ExifInterface {

    public ExifInterface(String s) throws IOException {
        mFilename = s;
        loadAttributes();
    }

    private native boolean appendThumbnailNative(String s, String s1);

    private native void commitChangesNative(String s);

    private static float convertRationalLatLonToFloat(String s, String s1) {
        double d3;
        String as[] = s.split(",");
        String as1[] = as[0].split("/");
        double d = Double.parseDouble(as1[0].trim()) / Double.parseDouble(as1[1].trim());
        String as2[] = as[1].split("/");
        double d1 = Double.parseDouble(as2[0].trim()) / Double.parseDouble(as2[1].trim());
        String as3[] = as[2].split("/");
        double d2 = Double.parseDouble(as3[0].trim()) / Double.parseDouble(as3[1].trim());
        d3 = d + d1 / 60D + d2 / 3600D;
        if(s1.equals("S")) goto _L2; else goto _L1
_L1:
        boolean flag = s1.equals("W");
        if(!flag) goto _L3; else goto _L2
_L2:
        float f = (float)(-d3);
_L5:
        return f;
_L3:
        f = (float)d3;
        if(true) goto _L5; else goto _L4
_L4:
        NumberFormatException numberformatexception;
        numberformatexception;
        throw new IllegalArgumentException();
        ArrayIndexOutOfBoundsException arrayindexoutofboundsexception;
        arrayindexoutofboundsexception;
        throw new IllegalArgumentException();
    }

    private native String getAttributesNative(String s);

    private native byte[] getThumbnailNative(String s);

    private void loadAttributes() throws IOException {
        mAttributes = new HashMap();
        String s;
        synchronized(sLock) {
            s = getAttributesNative(mFilename);
        }
        int i = s.indexOf(' ');
        int j = Integer.parseInt(s.substring(0, i));
        int k = i + 1;
        int l = 0;
        while(l < j)  {
            int i1 = s.indexOf('=', k);
            String s1 = s.substring(k, i1);
            int j1 = i1 + 1;
            int k1 = s.indexOf(' ', j1);
            int l1 = Integer.parseInt(s.substring(j1, k1));
            int i2 = k1 + 1;
            String s2 = s.substring(i2, i2 + l1);
            k = i2 + l1;
            if(s1.equals("hasThumbnail"))
                mHasThumbnail = s2.equalsIgnoreCase("true");
            else
                mAttributes.put(s1, s2);
            l++;
        }
        break MISSING_BLOCK_LABEL_186;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private native void saveAttributesNative(String s, String s1);

    public double getAltitude(double d) {
        int i = -1;
        double d1 = getAttributeDouble("GPSAltitude", -1D);
        int j = getAttributeInt("GPSAltitudeRef", i);
        if(d1 >= 0.0D && j >= 0) {
            if(j != 1)
                i = 1;
            d = d1 * (double)i;
        }
        return d;
    }

    public String getAttribute(String s) {
        return (String)mAttributes.get(s);
    }

    public double getAttributeDouble(String s, double d) {
        String s1 = (String)mAttributes.get(s);
        if(s1 != null) goto _L2; else goto _L1
_L1:
        return d;
_L2:
        double d1;
        double d2;
        int i = s1.indexOf("/");
        if(i == -1)
            continue; /* Loop/switch isn't completed */
        d1 = Double.parseDouble(s1.substring(i + 1));
        if(d1 == 0.0D)
            continue; /* Loop/switch isn't completed */
        d2 = Double.parseDouble(s1.substring(0, i));
        d = d2 / d1;
        continue; /* Loop/switch isn't completed */
        NumberFormatException numberformatexception;
        numberformatexception;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public int getAttributeInt(String s, int i) {
        String s1 = (String)mAttributes.get(s);
        if(s1 != null) goto _L2; else goto _L1
_L1:
        return i;
_L2:
        int j = Integer.valueOf(s1).intValue();
        i = j;
        continue; /* Loop/switch isn't completed */
        NumberFormatException numberformatexception;
        numberformatexception;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public long getDateTime() {
        long l;
        String s;
        l = -1L;
        s = (String)mAttributes.get("DateTime");
        if(s != null) goto _L2; else goto _L1
_L1:
        return l;
_L2:
        ParsePosition parseposition = new ParsePosition(0);
        long l1;
        Date date = sFormatter.parse(s, parseposition);
        if(date == null)
            continue; /* Loop/switch isn't completed */
        l1 = date.getTime();
        l = l1;
        continue; /* Loop/switch isn't completed */
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public long getGpsDateTime() {
        long l;
        String s;
        String s1;
        l = -1L;
        s = (String)mAttributes.get("GPSDateStamp");
        s1 = (String)mAttributes.get("GPSTimeStamp");
        if(s != null && s1 != null) goto _L2; else goto _L1
_L1:
        return l;
_L2:
        String s2;
        ParsePosition parseposition;
        s2 = (new StringBuilder()).append(s).append(' ').append(s1).toString();
        if(s2 == null)
            continue; /* Loop/switch isn't completed */
        parseposition = new ParsePosition(0);
        long l1;
        Date date = sFormatter.parse(s2, parseposition);
        if(date == null)
            continue; /* Loop/switch isn't completed */
        l1 = date.getTime();
        l = l1;
        continue; /* Loop/switch isn't completed */
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean getLatLong(float af[]) {
        boolean flag;
        String s;
        String s1;
        String s2;
        String s3;
        flag = true;
        s = (String)mAttributes.get("GPSLatitude");
        s1 = (String)mAttributes.get("GPSLatitudeRef");
        s2 = (String)mAttributes.get("GPSLongitude");
        s3 = (String)mAttributes.get("GPSLongitudeRef");
        if(s == null || s1 == null || s2 == null || s3 == null) goto _L2; else goto _L1
_L1:
        af[0] = convertRationalLatLonToFloat(s, s1);
        af[1] = convertRationalLatLonToFloat(s2, s3);
_L4:
        return flag;
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
_L2:
        flag = false;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public byte[] getThumbnail() {
        Object obj = sLock;
        obj;
        JVM INSTR monitorenter ;
        byte abyte0[] = getThumbnailNative(mFilename);
        return abyte0;
    }

    public boolean hasThumbnail() {
        return mHasThumbnail;
    }

    public void saveAttributes() throws IOException {
        String s;
        StringBuilder stringbuilder = new StringBuilder();
        int i = mAttributes.size();
        if(mAttributes.containsKey("hasThumbnail"))
            i--;
        stringbuilder.append((new StringBuilder()).append(i).append(" ").toString());
        Iterator iterator = mAttributes.entrySet().iterator();
        do {
            if(!iterator.hasNext())
                break;
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            String s1 = (String)entry.getKey();
            if(!s1.equals("hasThumbnail")) {
                String s2 = (String)entry.getValue();
                stringbuilder.append((new StringBuilder()).append(s1).append("=").toString());
                stringbuilder.append((new StringBuilder()).append(s2.length()).append(" ").toString());
                stringbuilder.append(s2);
            }
        } while(true);
        s = stringbuilder.toString();
        Object obj = sLock;
        obj;
        JVM INSTR monitorenter ;
        saveAttributesNative(mFilename, s);
        commitChangesNative(mFilename);
        return;
    }

    public void setAttribute(String s, String s1) {
        mAttributes.put(s, s1);
    }

    public static final int ORIENTATION_FLIP_HORIZONTAL = 2;
    public static final int ORIENTATION_FLIP_VERTICAL = 4;
    public static final int ORIENTATION_NORMAL = 1;
    public static final int ORIENTATION_ROTATE_180 = 3;
    public static final int ORIENTATION_ROTATE_270 = 8;
    public static final int ORIENTATION_ROTATE_90 = 6;
    public static final int ORIENTATION_TRANSPOSE = 5;
    public static final int ORIENTATION_TRANSVERSE = 7;
    public static final int ORIENTATION_UNDEFINED = 0;
    public static final String TAG_APERTURE = "FNumber";
    public static final String TAG_DATETIME = "DateTime";
    public static final String TAG_EXPOSURE_TIME = "ExposureTime";
    public static final String TAG_FLASH = "Flash";
    public static final String TAG_FOCAL_LENGTH = "FocalLength";
    public static final String TAG_GPS_ALTITUDE = "GPSAltitude";
    public static final String TAG_GPS_ALTITUDE_REF = "GPSAltitudeRef";
    public static final String TAG_GPS_DATESTAMP = "GPSDateStamp";
    public static final String TAG_GPS_LATITUDE = "GPSLatitude";
    public static final String TAG_GPS_LATITUDE_REF = "GPSLatitudeRef";
    public static final String TAG_GPS_LONGITUDE = "GPSLongitude";
    public static final String TAG_GPS_LONGITUDE_REF = "GPSLongitudeRef";
    public static final String TAG_GPS_PROCESSING_METHOD = "GPSProcessingMethod";
    public static final String TAG_GPS_TIMESTAMP = "GPSTimeStamp";
    public static final String TAG_IMAGE_LENGTH = "ImageLength";
    public static final String TAG_IMAGE_WIDTH = "ImageWidth";
    public static final String TAG_ISO = "ISOSpeedRatings";
    public static final String TAG_MAKE = "Make";
    public static final String TAG_MODEL = "Model";
    public static final String TAG_ORIENTATION = "Orientation";
    public static final String TAG_WHITE_BALANCE = "WhiteBalance";
    public static final int WHITEBALANCE_AUTO = 0;
    public static final int WHITEBALANCE_MANUAL = 1;
    private static SimpleDateFormat sFormatter;
    private static final Object sLock = new Object();
    private HashMap mAttributes;
    private String mFilename;
    private boolean mHasThumbnail;

    static  {
        System.loadLibrary("exif_jni");
        sFormatter = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        sFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
    }
}
