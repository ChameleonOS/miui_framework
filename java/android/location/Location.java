// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.location;

import android.os.*;
import android.util.Printer;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class Location
    implements Parcelable {

    public Location(Location location) {
        mTime = 0L;
        mLatitude = 0.0D;
        mLongitude = 0.0D;
        mHasAltitude = false;
        mAltitude = 0.0D;
        mHasSpeed = false;
        mSpeed = 0.0F;
        mHasBearing = false;
        mBearing = 0.0F;
        mHasAccuracy = false;
        mAccuracy = 0.0F;
        mExtras = null;
        mLat1 = 0.0D;
        mLon1 = 0.0D;
        mLat2 = 0.0D;
        mLon2 = 0.0D;
        mDistance = 0.0F;
        mInitialBearing = 0.0F;
        mResults = new float[2];
        set(location);
    }

    public Location(String s) {
        mTime = 0L;
        mLatitude = 0.0D;
        mLongitude = 0.0D;
        mHasAltitude = false;
        mAltitude = 0.0D;
        mHasSpeed = false;
        mSpeed = 0.0F;
        mHasBearing = false;
        mBearing = 0.0F;
        mHasAccuracy = false;
        mAccuracy = 0.0F;
        mExtras = null;
        mLat1 = 0.0D;
        mLon1 = 0.0D;
        mLat2 = 0.0D;
        mLon2 = 0.0D;
        mDistance = 0.0F;
        mInitialBearing = 0.0F;
        mResults = new float[2];
        mProvider = s;
    }

    private static void computeDistanceAndBearing(double d, double d1, double d2, double d3, 
            float af[]) {
        double d4 = d * 0.017453292519943295D;
        double d5 = d2 * 0.017453292519943295D;
        double d6 = d1 * 0.017453292519943295D;
        double d7 = d3 * 0.017453292519943295D;
        double d8 = (6378137D - 6356752.3141999999D) / 6378137D;
        double d9 = (6378137D * 6378137D - 6356752.3141999999D * 6356752.3141999999D) / (6356752.3141999999D * 6356752.3141999999D);
        double d10 = d7 - d6;
        double d11 = 0.0D;
        double d12 = Math.atan((1.0D - d8) * Math.tan(d4));
        double d13 = Math.atan((1.0D - d8) * Math.tan(d5));
        double d14 = Math.cos(d12);
        double d15 = Math.cos(d13);
        double d16 = Math.sin(d12);
        double d17 = Math.sin(d13);
        double d18 = d14 * d15;
        double d19 = d16 * d17;
        double d20 = 0.0D;
        double d21 = 0.0D;
        double d22 = 0.0D;
        double d23 = 0.0D;
        double d24 = d10;
        int i = 0;
        do {
label0:
            {
                if(i < 20) {
                    double d25 = d24;
                    d22 = Math.cos(d24);
                    d23 = Math.sin(d24);
                    double d26 = d15 * d23;
                    double d27 = d14 * d17 - d22 * (d16 * d15);
                    double d28 = Math.sqrt(d26 * d26 + d27 * d27);
                    double d29 = d19 + d18 * d22;
                    d20 = Math.atan2(d28, d29);
                    double d30;
                    double d31;
                    double d32;
                    double d33;
                    double d34;
                    double d35;
                    double d36;
                    if(d28 == 0.0D)
                        d30 = 0.0D;
                    else
                        d30 = (d18 * d23) / d28;
                    d31 = 1.0D - d30 * d30;
                    if(d31 == 0.0D)
                        d32 = 0.0D;
                    else
                        d32 = d29 - (2D * d19) / d31;
                    d33 = d31 * d9;
                    d11 = 1.0D + (d33 / 16384D) * (4096D + d33 * (-768D + d33 * (320D - 175D * d33)));
                    d34 = (d33 / 1024D) * (256D + d33 * (-128D + d33 * (74D - 47D * d33)));
                    d35 = d31 * (d8 / 16D) * (4D + d8 * (4D - 3D * d31));
                    d36 = d32 * d32;
                    d21 = d34 * d28 * (d32 + (d34 / 4D) * (d29 * (-1D + 2D * d36) - d32 * (d34 / 6D) * (-3D + d28 * (4D * d28)) * (-3D + 4D * d36)));
                    d24 = d10 + d30 * (d8 * (1.0D - d35)) * (d20 + d35 * d28 * (d32 + d35 * d29 * (-1D + d32 * (2D * d32))));
                    if(Math.abs((d24 - d25) / d24) >= 9.9999999999999998E-13D)
                        break label0;
                }
                af[0] = (float)(6356752.3141999999D * d11 * (d20 - d21));
                if(af.length > 1) {
                    af[1] = (float)(57.295779513082323D * (double)(float)Math.atan2(d15 * d23, d14 * d17 - d22 * (d16 * d15)));
                    if(af.length > 2)
                        af[2] = (float)(57.295779513082323D * (double)(float)Math.atan2(d14 * d23, d15 * -d16 + d22 * (d14 * d17)));
                }
                return;
            }
            i++;
        } while(true);
    }

    public static double convert(String s) {
        boolean flag;
        StringTokenizer stringtokenizer;
        int i;
        if(s == null)
            throw new NullPointerException("coordinate");
        flag = false;
        if(s.charAt(0) == '-') {
            s = s.substring(1);
            flag = true;
        }
        stringtokenizer = new StringTokenizer(s, ":");
        i = stringtokenizer.countTokens();
        if(i < 1)
            throw new IllegalArgumentException((new StringBuilder()).append("coordinate=").append(s).toString());
        String s1 = stringtokenizer.nextToken();
        if(i != 1) goto _L2; else goto _L1
_L1:
        double d4 = Double.parseDouble(s1);
        if(!flag) goto _L4; else goto _L3
_L3:
        double d3 = -d4;
          goto _L5
_L2:
        String s2;
        int j;
        double d;
        s2 = stringtokenizer.nextToken();
        j = Integer.parseInt(s1);
        d = 0.0D;
        if(!stringtokenizer.hasMoreTokens()) goto _L7; else goto _L6
_L6:
        double d1;
        d1 = Integer.parseInt(s2);
        d = Double.parseDouble(stringtokenizer.nextToken());
          goto _L8
_L9:
        throw new IllegalArgumentException((new StringBuilder()).append("coordinate=").append(s).toString());
        NumberFormatException numberformatexception;
        numberformatexception;
        throw new IllegalArgumentException((new StringBuilder()).append("coordinate=").append(s).toString());
_L7:
        d1 = Double.parseDouble(s2);
          goto _L8
_L11:
        throw new IllegalArgumentException((new StringBuilder()).append("coordinate=").append(s).toString());
_L13:
        throw new IllegalArgumentException((new StringBuilder()).append("coordinate=").append(s).toString());
_L14:
        double d2 = (d + (3600D * (double)j + 60D * d1)) / 3600D;
        if(flag)
            d3 = -d2;
        else
            d3 = d2;
_L5:
        return d3;
_L4:
        d3 = d4;
        if(true) goto _L5; else goto _L8
_L8:
        boolean flag1;
        if(flag && j == 180 && d1 == 0.0D && d == 0.0D)
            flag1 = true;
        else
            flag1 = false;
        if((double)j >= 0.0D && (j <= 179 || flag1)) goto _L10; else goto _L9
_L10:
        if(d1 >= 0.0D && d1 <= 59D) goto _L12; else goto _L11
_L12:
        if(d >= 0.0D && d <= 59D) goto _L14; else goto _L13
    }

    public static String convert(double d, int i) {
        if(d < -180D || d > 180D || Double.isNaN(d))
            throw new IllegalArgumentException((new StringBuilder()).append("coordinate=").append(d).toString());
        if(i != 0 && i != 1 && i != 2)
            throw new IllegalArgumentException((new StringBuilder()).append("outputType=").append(i).toString());
        StringBuilder stringbuilder = new StringBuilder();
        if(d < 0.0D) {
            stringbuilder.append('-');
            d = -d;
        }
        DecimalFormat decimalformat = new DecimalFormat("###.#####");
        if(i == 1 || i == 2) {
            int j = (int)Math.floor(d);
            stringbuilder.append(j);
            stringbuilder.append(':');
            d = 60D * (d - (double)j);
            if(i == 2) {
                int k = (int)Math.floor(d);
                stringbuilder.append(k);
                stringbuilder.append(':');
                d = 60D * (d - (double)k);
            }
        }
        stringbuilder.append(decimalformat.format(d));
        return stringbuilder.toString();
    }

    public static void distanceBetween(double d, double d1, double d2, double d3, 
            float af[]) {
        if(af == null || af.length < 1) {
            throw new IllegalArgumentException("results is null or has length < 1");
        } else {
            computeDistanceAndBearing(d, d1, d2, d3, af);
            return;
        }
    }

    public float bearingTo(Location location) {
        float af[] = mResults;
        af;
        JVM INSTR monitorenter ;
        if(mLatitude != mLat1 || mLongitude != mLon1 || location.mLatitude != mLat2 || location.mLongitude != mLon2) {
            computeDistanceAndBearing(mLatitude, mLongitude, location.mLatitude, location.mLongitude, mResults);
            mLat1 = mLatitude;
            mLon1 = mLongitude;
            mLat2 = location.mLatitude;
            mLon2 = location.mLongitude;
            mDistance = mResults[0];
            mInitialBearing = mResults[1];
        }
        float f = mInitialBearing;
        return f;
    }

    public int describeContents() {
        return 0;
    }

    public float distanceTo(Location location) {
        float af[] = mResults;
        af;
        JVM INSTR monitorenter ;
        if(mLatitude != mLat1 || mLongitude != mLon1 || location.mLatitude != mLat2 || location.mLongitude != mLon2) {
            computeDistanceAndBearing(mLatitude, mLongitude, location.mLatitude, location.mLongitude, mResults);
            mLat1 = mLatitude;
            mLon1 = mLongitude;
            mLat2 = location.mLatitude;
            mLon2 = location.mLongitude;
            mDistance = mResults[0];
            mInitialBearing = mResults[1];
        }
        float f = mDistance;
        return f;
    }

    public void dump(Printer printer, String s) {
        printer.println((new StringBuilder()).append(s).append("mProvider=").append(mProvider).append(" mTime=").append(mTime).toString());
        printer.println((new StringBuilder()).append(s).append("mLatitude=").append(mLatitude).append(" mLongitude=").append(mLongitude).toString());
        printer.println((new StringBuilder()).append(s).append("mHasAltitude=").append(mHasAltitude).append(" mAltitude=").append(mAltitude).toString());
        printer.println((new StringBuilder()).append(s).append("mHasSpeed=").append(mHasSpeed).append(" mSpeed=").append(mSpeed).toString());
        printer.println((new StringBuilder()).append(s).append("mHasBearing=").append(mHasBearing).append(" mBearing=").append(mBearing).toString());
        printer.println((new StringBuilder()).append(s).append("mHasAccuracy=").append(mHasAccuracy).append(" mAccuracy=").append(mAccuracy).toString());
        printer.println((new StringBuilder()).append(s).append("mExtras=").append(mExtras).toString());
    }

    public float getAccuracy() {
        return mAccuracy;
    }

    public double getAltitude() {
        return mAltitude;
    }

    public float getBearing() {
        return mBearing;
    }

    public Bundle getExtras() {
        return mExtras;
    }

    public double getLatitude() {
        return mLatitude;
    }

    public double getLongitude() {
        return mLongitude;
    }

    public String getProvider() {
        return mProvider;
    }

    public float getSpeed() {
        return mSpeed;
    }

    public long getTime() {
        return mTime;
    }

    public boolean hasAccuracy() {
        return mHasAccuracy;
    }

    public boolean hasAltitude() {
        return mHasAltitude;
    }

    public boolean hasBearing() {
        return mHasBearing;
    }

    public boolean hasSpeed() {
        return mHasSpeed;
    }

    public void removeAccuracy() {
        mAccuracy = 0.0F;
        mHasAccuracy = false;
    }

    public void removeAltitude() {
        mAltitude = 0.0D;
        mHasAltitude = false;
    }

    public void removeBearing() {
        mBearing = 0.0F;
        mHasBearing = false;
    }

    public void removeSpeed() {
        mSpeed = 0.0F;
        mHasSpeed = false;
    }

    public void reset() {
        mProvider = null;
        mTime = 0L;
        mLatitude = 0.0D;
        mLongitude = 0.0D;
        mHasAltitude = false;
        mAltitude = 0.0D;
        mHasSpeed = false;
        mSpeed = 0.0F;
        mHasBearing = false;
        mBearing = 0.0F;
        mHasAccuracy = false;
        mAccuracy = 0.0F;
        mExtras = null;
    }

    public void set(Location location) {
        mProvider = location.mProvider;
        mTime = location.mTime;
        mLatitude = location.mLatitude;
        mLongitude = location.mLongitude;
        mHasAltitude = location.mHasAltitude;
        mAltitude = location.mAltitude;
        mHasSpeed = location.mHasSpeed;
        mSpeed = location.mSpeed;
        mHasBearing = location.mHasBearing;
        mBearing = location.mBearing;
        mHasAccuracy = location.mHasAccuracy;
        mAccuracy = location.mAccuracy;
        Bundle bundle;
        if(location.mExtras == null)
            bundle = null;
        else
            bundle = new Bundle(location.mExtras);
        mExtras = bundle;
    }

    public void setAccuracy(float f) {
        mAccuracy = f;
        mHasAccuracy = true;
    }

    public void setAltitude(double d) {
        mAltitude = d;
        mHasAltitude = true;
    }

    public void setBearing(float f) {
        for(; f < 0.0F; f += 360F);
        for(; f >= 360F; f -= 360F);
        mBearing = f;
        mHasBearing = true;
    }

    public void setExtras(Bundle bundle) {
        Bundle bundle1;
        if(bundle == null)
            bundle1 = null;
        else
            bundle1 = new Bundle(bundle);
        mExtras = bundle1;
    }

    public void setLatitude(double d) {
        mLatitude = d;
    }

    public void setLongitude(double d) {
        mLongitude = d;
    }

    public void setProvider(String s) {
        mProvider = s;
    }

    public void setSpeed(float f) {
        mSpeed = f;
        mHasSpeed = true;
    }

    public void setTime(long l) {
        mTime = l;
    }

    public String toString() {
        return (new StringBuilder()).append("Location[mProvider=").append(mProvider).append(",mTime=").append(mTime).append(",mLatitude=").append(mLatitude).append(",mLongitude=").append(mLongitude).append(",mHasAltitude=").append(mHasAltitude).append(",mAltitude=").append(mAltitude).append(",mHasSpeed=").append(mHasSpeed).append(",mSpeed=").append(mSpeed).append(",mHasBearing=").append(mHasBearing).append(",mBearing=").append(mBearing).append(",mHasAccuracy=").append(mHasAccuracy).append(",mAccuracy=").append(mAccuracy).append(",mExtras=").append(mExtras).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int j = 1;
        parcel.writeString(mProvider);
        parcel.writeLong(mTime);
        parcel.writeDouble(mLatitude);
        parcel.writeDouble(mLongitude);
        int k;
        int l;
        int i1;
        if(mHasAltitude)
            k = j;
        else
            k = 0;
        parcel.writeInt(k);
        parcel.writeDouble(mAltitude);
        if(mHasSpeed)
            l = j;
        else
            l = 0;
        parcel.writeInt(l);
        parcel.writeFloat(mSpeed);
        if(mHasBearing)
            i1 = j;
        else
            i1 = 0;
        parcel.writeInt(i1);
        parcel.writeFloat(mBearing);
        if(!mHasAccuracy)
            j = 0;
        parcel.writeInt(j);
        parcel.writeFloat(mAccuracy);
        parcel.writeBundle(mExtras);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Location createFromParcel(Parcel parcel) {
            boolean flag = true;
            Location location = new Location(parcel.readString());
            location.mTime = parcel.readLong();
            location.mLatitude = parcel.readDouble();
            location.mLongitude = parcel.readDouble();
            boolean flag1;
            boolean flag2;
            boolean flag3;
            if(parcel.readInt() != 0)
                flag1 = flag;
            else
                flag1 = false;
            location.mHasAltitude = flag1;
            location.mAltitude = parcel.readDouble();
            if(parcel.readInt() != 0)
                flag2 = flag;
            else
                flag2 = false;
            location.mHasSpeed = flag2;
            location.mSpeed = parcel.readFloat();
            if(parcel.readInt() != 0)
                flag3 = flag;
            else
                flag3 = false;
            location.mHasBearing = flag3;
            location.mBearing = parcel.readFloat();
            if(parcel.readInt() == 0)
                flag = false;
            location.mHasAccuracy = flag;
            location.mAccuracy = parcel.readFloat();
            location.mExtras = parcel.readBundle();
            return location;
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public Location[] newArray(int i) {
            return new Location[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int FORMAT_DEGREES = 0;
    public static final int FORMAT_MINUTES = 1;
    public static final int FORMAT_SECONDS = 2;
    private float mAccuracy;
    private double mAltitude;
    private float mBearing;
    private float mDistance;
    private Bundle mExtras;
    private boolean mHasAccuracy;
    private boolean mHasAltitude;
    private boolean mHasBearing;
    private boolean mHasSpeed;
    private float mInitialBearing;
    private double mLat1;
    private double mLat2;
    private double mLatitude;
    private double mLon1;
    private double mLon2;
    private double mLongitude;
    private String mProvider;
    private float mResults[];
    private float mSpeed;
    private long mTime;



/*
    static long access$002(Location location, long l) {
        location.mTime = l;
        return l;
    }

*/


/*
    static float access$1002(Location location, float f) {
        location.mAccuracy = f;
        return f;
    }

*/


/*
    static double access$102(Location location, double d) {
        location.mLatitude = d;
        return d;
    }

*/


/*
    static Bundle access$1102(Location location, Bundle bundle) {
        location.mExtras = bundle;
        return bundle;
    }

*/


/*
    static double access$202(Location location, double d) {
        location.mLongitude = d;
        return d;
    }

*/


/*
    static boolean access$302(Location location, boolean flag) {
        location.mHasAltitude = flag;
        return flag;
    }

*/


/*
    static double access$402(Location location, double d) {
        location.mAltitude = d;
        return d;
    }

*/


/*
    static boolean access$502(Location location, boolean flag) {
        location.mHasSpeed = flag;
        return flag;
    }

*/


/*
    static float access$602(Location location, float f) {
        location.mSpeed = f;
        return f;
    }

*/


/*
    static boolean access$702(Location location, boolean flag) {
        location.mHasBearing = flag;
        return flag;
    }

*/


/*
    static float access$802(Location location, float f) {
        location.mBearing = f;
        return f;
    }

*/


/*
    static boolean access$902(Location location, boolean flag) {
        location.mHasAccuracy = flag;
        return flag;
    }

*/
}
