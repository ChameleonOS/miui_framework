// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.location;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Referenced classes of package android.location:
//            GpsSatellite

public final class GpsStatus {
    public static interface NmeaListener {

        public abstract void onNmeaReceived(long l, String s);
    }

    public static interface Listener {

        public abstract void onGpsStatusChanged(int i);
    }

    private final class SatelliteIterator
        implements Iterator {

        public boolean hasNext() {
            int i = mIndex;
_L3:
            if(i >= mSatellites.length)
                break MISSING_BLOCK_LABEL_36;
            if(!mSatellites[i].mValid) goto _L2; else goto _L1
_L1:
            boolean flag = true;
_L4:
            return flag;
_L2:
            i++;
              goto _L3
            flag = false;
              goto _L4
        }

        public GpsSatellite next() {
            while(mIndex < mSatellites.length)  {
                GpsSatellite agpssatellite[] = mSatellites;
                int i = mIndex;
                mIndex = i + 1;
                GpsSatellite gpssatellite = agpssatellite[i];
                if(gpssatellite.mValid)
                    return gpssatellite;
            }
            throw new NoSuchElementException();
        }

        public volatile Object next() {
            return next();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        int mIndex;
        private GpsSatellite mSatellites[];
        final GpsStatus this$0;

        SatelliteIterator(GpsSatellite agpssatellite[]) {
            this$0 = GpsStatus.this;
            super();
            mIndex = 0;
            mSatellites = agpssatellite;
        }
    }


    GpsStatus() {
        mSatellites = new GpsSatellite[255];
        mSatelliteList = new Iterable() {

            public Iterator iterator() {
                return new SatelliteIterator(mSatellites);
            }

            final GpsStatus this$0;

             {
                this$0 = GpsStatus.this;
                super();
            }
        };
        for(int i = 0; i < mSatellites.length; i++)
            mSatellites[i] = new GpsSatellite(i + 1);

    }

    public int getMaxSatellites() {
        return 255;
    }

    public Iterable getSatellites() {
        return mSatelliteList;
    }

    public int getTimeToFirstFix() {
        return mTimeToFirstFix;
    }

    /**
     * @deprecated Method setStatus is deprecated
     */

    void setStatus(int i, int ai[], float af[], float af1[], float af2[], int j, int k, 
            int l) {
        this;
        JVM INSTR monitorenter ;
        int i1 = 0;
        while(i1 < mSatellites.length)  {
            mSatellites[i1].mValid = false;
            i1++;
        }
        break MISSING_BLOCK_LABEL_200;
_L11:
        int j1;
        if(j1 >= i) goto _L2; else goto _L1
_L1:
        int k1;
        int l1;
        k1 = -1 + ai[j1];
        l1 = 1 << k1;
        if(k1 < 0 || k1 >= mSatellites.length) goto _L4; else goto _L3
_L3:
        GpsSatellite gpssatellite;
        gpssatellite = mSatellites[k1];
        gpssatellite.mValid = true;
        gpssatellite.mSnr = af[j1];
        gpssatellite.mElevation = af1[j1];
        gpssatellite.mAzimuth = af2[j1];
        if((j & l1) == 0) goto _L6; else goto _L5
_L5:
        boolean flag = true;
_L12:
        gpssatellite.mHasEphemeris = flag;
        if((k & l1) == 0) goto _L8; else goto _L7
_L7:
        boolean flag1 = true;
_L13:
        gpssatellite.mHasAlmanac = flag1;
        if((l & l1) == 0) goto _L10; else goto _L9
_L9:
        boolean flag2 = true;
_L14:
        gpssatellite.mUsedInFix = flag2;
_L4:
        j1++;
          goto _L11
_L6:
        flag = false;
          goto _L12
_L8:
        flag1 = false;
          goto _L13
_L10:
        flag2 = false;
          goto _L14
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
        j1 = 0;
          goto _L11
    }

    void setStatus(GpsStatus gpsstatus) {
        mTimeToFirstFix = gpsstatus.getTimeToFirstFix();
        for(int i = 0; i < mSatellites.length; i++)
            mSatellites[i].setStatus(gpsstatus.mSatellites[i]);

    }

    void setTimeToFirstFix(int i) {
        mTimeToFirstFix = i;
    }

    public static final int GPS_EVENT_FIRST_FIX = 3;
    public static final int GPS_EVENT_SATELLITE_STATUS = 4;
    public static final int GPS_EVENT_STARTED = 1;
    public static final int GPS_EVENT_STOPPED = 2;
    private static final int NUM_SATELLITES = 255;
    private Iterable mSatelliteList;
    private GpsSatellite mSatellites[];
    private int mTimeToFirstFix;

}
