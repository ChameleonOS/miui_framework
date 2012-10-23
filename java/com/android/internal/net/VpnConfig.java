// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.net;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class VpnConfig
    implements Parcelable {

    public VpnConfig() {
        mtu = -1;
        startTime = -1L;
    }

    public static Intent getIntentForConfirmation() {
        Intent intent = new Intent();
        intent.setClassName("com.android.vpndialogs", "com.android.vpndialogs.ConfirmDialog");
        return intent;
    }

    public static PendingIntent getIntentForStatusPanel(Context context, VpnConfig vpnconfig) {
        Intent intent = new Intent();
        intent.setClassName("com.android.vpndialogs", "com.android.vpndialogs.ManageDialog");
        intent.putExtra("config", vpnconfig);
        intent.addFlags(0x50800000);
        int i;
        if(vpnconfig == null)
            i = 0x20000000;
        else
            i = 0x10000000;
        return PendingIntent.getActivity(context, 0, intent, i);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(user);
        parcel.writeString(interfaze);
        parcel.writeString(session);
        parcel.writeInt(mtu);
        parcel.writeString(addresses);
        parcel.writeString(routes);
        parcel.writeStringList(dnsServers);
        parcel.writeStringList(searchDomains);
        parcel.writeParcelable(configureIntent, i);
        parcel.writeLong(startTime);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public VpnConfig createFromParcel(Parcel parcel) {
            VpnConfig vpnconfig = new VpnConfig();
            vpnconfig.user = parcel.readString();
            vpnconfig.interfaze = parcel.readString();
            vpnconfig.session = parcel.readString();
            vpnconfig.mtu = parcel.readInt();
            vpnconfig.addresses = parcel.readString();
            vpnconfig.routes = parcel.readString();
            vpnconfig.dnsServers = parcel.createStringArrayList();
            vpnconfig.searchDomains = parcel.createStringArrayList();
            vpnconfig.configureIntent = (PendingIntent)parcel.readParcelable(null);
            vpnconfig.startTime = parcel.readLong();
            return vpnconfig;
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public VpnConfig[] newArray(int i) {
            return new VpnConfig[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final String DIALOGS_PACKAGE = "com.android.vpndialogs";
    public static final String LEGACY_VPN = "[Legacy VPN]";
    public static final String SERVICE_INTERFACE = "android.net.VpnService";
    public String addresses;
    public PendingIntent configureIntent;
    public List dnsServers;
    public String interfaze;
    public int mtu;
    public String routes;
    public List searchDomains;
    public String session;
    public long startTime;
    public String user;

}
