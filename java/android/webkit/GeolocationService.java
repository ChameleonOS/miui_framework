// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.content.Context;
import android.location.*;
import android.os.Bundle;
import android.util.Log;

final class GeolocationService
    implements LocationListener {

    public GeolocationService(Context context, long l) {
        mNativeObject = l;
        mLocationManager = (LocationManager)context.getSystemService("location");
        if(mLocationManager == null)
            Log.e("geolocationService", "Could not get location manager.");
    }

    private void maybeReportError(String s) {
        if(mIsRunning && !mIsNetworkProviderAvailable && !mIsGpsProviderAvailable)
            nativeNewErrorAvailable(mNativeObject, s);
    }

    private static native void nativeNewErrorAvailable(long l, String s);

    private static native void nativeNewLocationAvailable(long l, Location location);

    private void registerForLocationUpdates() {
        SecurityException securityexception;
        boolean flag;
        IllegalArgumentException illegalargumentexception1;
        try {
            mLocationManager.requestLocationUpdates("network", 0L, 0.0F, this);
            mIsNetworkProviderAvailable = true;
        }
        catch(IllegalArgumentException illegalargumentexception) { }
        flag = mIsGpsEnabled;
        if(!flag)
            break MISSING_BLOCK_LABEL_45;
        mLocationManager.requestLocationUpdates("gps", 0L, 0.0F, this);
        mIsGpsProviderAvailable = true;
_L2:
        return;
        securityexception;
        Log.e("geolocationService", "Caught security exception registering for location updates from system. This should only happen in DumpRenderTree.");
        continue; /* Loop/switch isn't completed */
        illegalargumentexception1;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private void unregisterFromLocationUpdates() {
        mLocationManager.removeUpdates(this);
        mIsNetworkProviderAvailable = false;
        mIsGpsProviderAvailable = false;
    }

    public void onLocationChanged(Location location) {
        if(mIsRunning)
            nativeNewLocationAvailable(mNativeObject, location);
    }

    public void onProviderDisabled(String s) {
        if(!"network".equals(s)) goto _L2; else goto _L1
_L1:
        mIsNetworkProviderAvailable = false;
_L4:
        maybeReportError("The last location provider was disabled");
        return;
_L2:
        if("gps".equals(s))
            mIsGpsProviderAvailable = false;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void onProviderEnabled(String s) {
        if(!"network".equals(s)) goto _L2; else goto _L1
_L1:
        mIsNetworkProviderAvailable = true;
_L4:
        return;
_L2:
        if("gps".equals(s))
            mIsGpsProviderAvailable = true;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void onStatusChanged(String s, int i, Bundle bundle) {
        boolean flag;
        if(i == 2)
            flag = true;
        else
            flag = false;
        if(!"network".equals(s)) goto _L2; else goto _L1
_L1:
        mIsNetworkProviderAvailable = flag;
_L4:
        maybeReportError("The last location provider is no longer available");
        return;
_L2:
        if("gps".equals(s))
            mIsGpsProviderAvailable = flag;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void setEnableGps(boolean flag) {
        if(mIsGpsEnabled != flag) {
            mIsGpsEnabled = flag;
            if(mIsRunning) {
                unregisterFromLocationUpdates();
                registerForLocationUpdates();
                maybeReportError("The last location provider is no longer available");
            }
        }
    }

    public boolean start() {
        boolean flag = true;
        registerForLocationUpdates();
        mIsRunning = flag;
        if(!mIsNetworkProviderAvailable && !mIsGpsProviderAvailable)
            flag = false;
        return flag;
    }

    public void stop() {
        unregisterFromLocationUpdates();
        mIsRunning = false;
    }

    private static final String TAG = "geolocationService";
    private boolean mIsGpsEnabled;
    private boolean mIsGpsProviderAvailable;
    private boolean mIsNetworkProviderAvailable;
    private boolean mIsRunning;
    private LocationManager mLocationManager;
    private long mNativeObject;
}
