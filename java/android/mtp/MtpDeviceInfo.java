// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.mtp;


public class MtpDeviceInfo {

    private MtpDeviceInfo() {
    }

    public final String getManufacturer() {
        return mManufacturer;
    }

    public final String getModel() {
        return mModel;
    }

    public final String getSerialNumber() {
        return mSerialNumber;
    }

    public final String getVersion() {
        return mVersion;
    }

    private String mManufacturer;
    private String mModel;
    private String mSerialNumber;
    private String mVersion;
}
