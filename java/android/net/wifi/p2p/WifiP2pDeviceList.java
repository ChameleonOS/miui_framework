// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.wifi.p2p;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.*;

// Referenced classes of package android.net.wifi.p2p:
//            WifiP2pDevice

public class WifiP2pDeviceList
    implements Parcelable {

    public WifiP2pDeviceList() {
        mDevices = new HashMap();
    }

    public WifiP2pDeviceList(WifiP2pDeviceList wifip2pdevicelist) {
        if(wifip2pdevicelist != null) {
            WifiP2pDevice wifip2pdevice;
            for(Iterator iterator = wifip2pdevicelist.getDeviceList().iterator(); iterator.hasNext(); mDevices.put(wifip2pdevice.deviceAddress, wifip2pdevice))
                wifip2pdevice = (WifiP2pDevice)iterator.next();

        }
    }

    public WifiP2pDeviceList(ArrayList arraylist) {
        mDevices = new HashMap();
        Iterator iterator = arraylist.iterator();
        do {
            if(!iterator.hasNext())
                break;
            WifiP2pDevice wifip2pdevice = (WifiP2pDevice)iterator.next();
            if(wifip2pdevice.deviceAddress != null)
                mDevices.put(wifip2pdevice.deviceAddress, wifip2pdevice);
        } while(true);
    }

    public boolean clear() {
        boolean flag;
        if(mDevices.isEmpty()) {
            flag = false;
        } else {
            mDevices.clear();
            flag = true;
        }
        return flag;
    }

    public int describeContents() {
        return 0;
    }

    public WifiP2pDevice get(String s) {
        WifiP2pDevice wifip2pdevice;
        if(s == null)
            wifip2pdevice = null;
        else
            wifip2pdevice = (WifiP2pDevice)mDevices.get(s);
        return wifip2pdevice;
    }

    public Collection getDeviceList() {
        return Collections.unmodifiableCollection(mDevices.values());
    }

    public boolean isGroupOwner(String s) {
        if(s == null) goto _L2; else goto _L1
_L1:
        WifiP2pDevice wifip2pdevice = (WifiP2pDevice)mDevices.get(s);
        if(wifip2pdevice == null) goto _L2; else goto _L3
_L3:
        boolean flag = wifip2pdevice.isGroupOwner();
_L5:
        return flag;
_L2:
        flag = false;
        if(true) goto _L5; else goto _L4
_L4:
    }

    public boolean remove(WifiP2pDevice wifip2pdevice) {
        boolean flag;
        flag = false;
        break MISSING_BLOCK_LABEL_2;
        if(wifip2pdevice != null && wifip2pdevice.deviceAddress != null && mDevices.remove(wifip2pdevice.deviceAddress) != null)
            flag = true;
        return flag;
    }

    public String toString() {
        StringBuffer stringbuffer = new StringBuffer();
        WifiP2pDevice wifip2pdevice;
        for(Iterator iterator = mDevices.values().iterator(); iterator.hasNext(); stringbuffer.append("\n").append(wifip2pdevice))
            wifip2pdevice = (WifiP2pDevice)iterator.next();

        return stringbuffer.toString();
    }

    public void update(WifiP2pDevice wifip2pdevice) {
        if(wifip2pdevice != null && wifip2pdevice.deviceAddress != null) {
            WifiP2pDevice wifip2pdevice1 = (WifiP2pDevice)mDevices.get(wifip2pdevice.deviceAddress);
            if(wifip2pdevice1 != null) {
                wifip2pdevice1.deviceName = wifip2pdevice.deviceName;
                wifip2pdevice1.primaryDeviceType = wifip2pdevice.primaryDeviceType;
                wifip2pdevice1.secondaryDeviceType = wifip2pdevice.secondaryDeviceType;
                wifip2pdevice1.wpsConfigMethodsSupported = wifip2pdevice.wpsConfigMethodsSupported;
                wifip2pdevice1.deviceCapability = wifip2pdevice.deviceCapability;
                wifip2pdevice1.groupCapability = wifip2pdevice.groupCapability;
            } else {
                mDevices.put(wifip2pdevice.deviceAddress, wifip2pdevice);
            }
        }
    }

    public void updateGroupCapability(String s, int i) {
        if(!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        WifiP2pDevice wifip2pdevice = (WifiP2pDevice)mDevices.get(s);
        if(wifip2pdevice != null)
            wifip2pdevice.groupCapability = i;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void updateStatus(String s, int i) {
        if(!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        WifiP2pDevice wifip2pdevice = (WifiP2pDevice)mDevices.get(s);
        if(wifip2pdevice != null)
            wifip2pdevice.status = i;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mDevices.size());
        for(Iterator iterator = mDevices.values().iterator(); iterator.hasNext(); parcel.writeParcelable((WifiP2pDevice)iterator.next(), i));
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public WifiP2pDeviceList createFromParcel(Parcel parcel) {
            WifiP2pDeviceList wifip2pdevicelist = new WifiP2pDeviceList();
            int i = parcel.readInt();
            for(int j = 0; j < i; j++)
                wifip2pdevicelist.update((WifiP2pDevice)parcel.readParcelable(null));

            return wifip2pdevicelist;
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public WifiP2pDeviceList[] newArray(int i) {
            return new WifiP2pDeviceList[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private HashMap mDevices;

}
