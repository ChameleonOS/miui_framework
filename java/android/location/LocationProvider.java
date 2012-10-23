// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.location;

import android.os.RemoteException;
import android.util.Log;

// Referenced classes of package android.location:
//            ILocationManager, Criteria

public abstract class LocationProvider {

    public LocationProvider(String s, ILocationManager ilocationmanager) {
        if(s.matches("[^a-zA-Z0-9]")) {
            throw new IllegalArgumentException((new StringBuilder()).append("name ").append(s).append(" contains an illegal character").toString());
        } else {
            mName = s;
            mService = ilocationmanager;
            return;
        }
    }

    public abstract int getAccuracy();

    public String getName() {
        return mName;
    }

    public abstract int getPowerRequirement();

    public abstract boolean hasMonetaryCost();

    public boolean meetsCriteria(Criteria criteria) {
        boolean flag1 = mService.providerMeetsCriteria(mName, criteria);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("LocationProvider", "meetsCriteria: RemoteException", remoteexception);
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public abstract boolean requiresCell();

    public abstract boolean requiresNetwork();

    public abstract boolean requiresSatellite();

    public abstract boolean supportsAltitude();

    public abstract boolean supportsBearing();

    public abstract boolean supportsSpeed();

    public static final int AVAILABLE = 2;
    static final String BAD_CHARS_REGEX = "[^a-zA-Z0-9]";
    public static final int OUT_OF_SERVICE = 0;
    private static final String TAG = "LocationProvider";
    public static final int TEMPORARILY_UNAVAILABLE = 1;
    private final String mName;
    private final ILocationManager mService;
}
