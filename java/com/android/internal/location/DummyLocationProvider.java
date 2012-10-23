// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.location;

import android.location.ILocationManager;
import android.location.LocationProvider;

public class DummyLocationProvider extends LocationProvider {

    public DummyLocationProvider(String s, ILocationManager ilocationmanager) {
        super(s, ilocationmanager);
    }

    public int getAccuracy() {
        return mAccuracy;
    }

    public int getPowerRequirement() {
        return mPowerRequirement;
    }

    public boolean hasMonetaryCost() {
        return mHasMonetaryCost;
    }

    public boolean requiresCell() {
        return mRequiresCell;
    }

    public boolean requiresNetwork() {
        return mRequiresNetwork;
    }

    public boolean requiresSatellite() {
        return mRequiresSatellite;
    }

    public void setAccuracy(int i) {
        mAccuracy = i;
    }

    public void setHasMonetaryCost(boolean flag) {
        mHasMonetaryCost = flag;
    }

    public void setPowerRequirement(int i) {
        mPowerRequirement = i;
    }

    public void setRequiresCell(boolean flag) {
        mRequiresCell = flag;
    }

    public void setRequiresNetwork(boolean flag) {
        mRequiresNetwork = flag;
    }

    public void setRequiresSatellite(boolean flag) {
        mRequiresSatellite = flag;
    }

    public void setSupportsAltitude(boolean flag) {
        mSupportsAltitude = flag;
    }

    public void setSupportsBearing(boolean flag) {
        mSupportsBearing = flag;
    }

    public void setSupportsSpeed(boolean flag) {
        mSupportsSpeed = flag;
    }

    public boolean supportsAltitude() {
        return mSupportsAltitude;
    }

    public boolean supportsBearing() {
        return mSupportsBearing;
    }

    public boolean supportsSpeed() {
        return mSupportsSpeed;
    }

    private static final String TAG = "DummyLocationProvider";
    int mAccuracy;
    boolean mHasMonetaryCost;
    String mName;
    int mPowerRequirement;
    boolean mRequiresCell;
    boolean mRequiresNetwork;
    boolean mRequiresSatellite;
    boolean mSupportsAltitude;
    boolean mSupportsBearing;
    boolean mSupportsSpeed;
}
