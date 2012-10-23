// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.wifi.p2p;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package android.net.wifi.p2p:
//            WifiP2pDevice

public class WifiP2pGroup
    implements Parcelable {

    public WifiP2pGroup() {
        mClients = new ArrayList();
    }

    public WifiP2pGroup(WifiP2pGroup wifip2pgroup) {
        mClients = new ArrayList();
        if(wifip2pgroup != null) {
            mNetworkName = wifip2pgroup.getNetworkName();
            mOwner = new WifiP2pDevice(wifip2pgroup.getOwner());
            mIsGroupOwner = wifip2pgroup.mIsGroupOwner;
            WifiP2pDevice wifip2pdevice;
            for(Iterator iterator = wifip2pgroup.getClientList().iterator(); iterator.hasNext(); mClients.add(wifip2pdevice))
                wifip2pdevice = (WifiP2pDevice)iterator.next();

            mPassphrase = wifip2pgroup.getPassphrase();
            mInterface = wifip2pgroup.getInterface();
        }
    }

    public WifiP2pGroup(String s) throws IllegalArgumentException {
        String as[];
        mClients = new ArrayList();
        as = s.split(" ");
        if(as.length < 3)
            throw new IllegalArgumentException("Malformed supplicant event");
        if(!as[0].startsWith("P2P-GROUP")) goto _L2; else goto _L1
_L1:
        mInterface = as[1];
        mIsGroupOwner = as[2].equals("GO");
        Matcher matcher = groupStartedPattern.matcher(s);
        if(matcher.find()) {
            mNetworkName = matcher.group(1);
            mPassphrase = matcher.group(4);
            mOwner = new WifiP2pDevice(matcher.group(5));
        }
_L4:
        return;
_L2:
label0:
        {
            if(!as[0].equals("P2P-INVITATION-RECEIVED"))
                break label0;
            int i = as.length;
            int j = 0;
            do {
                if(j >= i)
                    continue; /* Loop/switch isn't completed */
                String as1[] = as[j].split("=");
                if(as1.length == 2 && as1[0].equals("go_dev_addr"))
                    mOwner = new WifiP2pDevice(as1[1]);
                j++;
            } while(true);
        }
        continue; /* Loop/switch isn't completed */
        throw new IllegalArgumentException("Malformed supplicant event");
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void addClient(WifiP2pDevice wifip2pdevice) {
        Iterator iterator = mClients.iterator();
_L4:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        if(!((WifiP2pDevice)iterator.next()).equals(wifip2pdevice)) goto _L4; else goto _L3
_L3:
        return;
_L2:
        mClients.add(wifip2pdevice);
        if(true) goto _L3; else goto _L5
_L5:
    }

    public void addClient(String s) {
        addClient(new WifiP2pDevice(s));
    }

    public boolean contains(WifiP2pDevice wifip2pdevice) {
        boolean flag;
        if(mOwner.equals(wifip2pdevice) || mClients.contains(wifip2pdevice))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public int describeContents() {
        return 0;
    }

    public Collection getClientList() {
        return Collections.unmodifiableCollection(mClients);
    }

    public String getInterface() {
        return mInterface;
    }

    public String getNetworkName() {
        return mNetworkName;
    }

    public WifiP2pDevice getOwner() {
        return mOwner;
    }

    public String getPassphrase() {
        return mPassphrase;
    }

    public boolean isClientListEmpty() {
        boolean flag;
        if(mClients.size() == 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isGroupOwner() {
        return mIsGroupOwner;
    }

    public boolean removeClient(WifiP2pDevice wifip2pdevice) {
        return mClients.remove(wifip2pdevice);
    }

    public boolean removeClient(String s) {
        return mClients.remove(new WifiP2pDevice(s));
    }

    public void setInterface(String s) {
        mInterface = s;
    }

    public void setIsGroupOwner(boolean flag) {
        mIsGroupOwner = flag;
    }

    public void setNetworkName(String s) {
        mNetworkName = s;
    }

    public void setOwner(WifiP2pDevice wifip2pdevice) {
        mOwner = wifip2pdevice;
    }

    public void setPassphrase(String s) {
        mPassphrase = s;
    }

    public String toString() {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("network: ").append(mNetworkName);
        stringbuffer.append("\n isGO: ").append(mIsGroupOwner);
        stringbuffer.append("\n GO: ").append(mOwner);
        WifiP2pDevice wifip2pdevice;
        for(Iterator iterator = mClients.iterator(); iterator.hasNext(); stringbuffer.append("\n Client: ").append(wifip2pdevice))
            wifip2pdevice = (WifiP2pDevice)iterator.next();

        stringbuffer.append("\n interface: ").append(mInterface);
        return stringbuffer.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mNetworkName);
        parcel.writeParcelable(mOwner, i);
        byte byte0;
        if(mIsGroupOwner)
            byte0 = 1;
        else
            byte0 = 0;
        parcel.writeByte(byte0);
        parcel.writeInt(mClients.size());
        for(Iterator iterator = mClients.iterator(); iterator.hasNext(); parcel.writeParcelable((WifiP2pDevice)iterator.next(), i));
        parcel.writeString(mPassphrase);
        parcel.writeString(mInterface);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public WifiP2pGroup createFromParcel(Parcel parcel) {
            WifiP2pGroup wifip2pgroup = new WifiP2pGroup();
            wifip2pgroup.setNetworkName(parcel.readString());
            wifip2pgroup.setOwner((WifiP2pDevice)parcel.readParcelable(null));
            boolean flag;
            int i;
            if(parcel.readByte() == 1)
                flag = true;
            else
                flag = false;
            wifip2pgroup.setIsGroupOwner(flag);
            i = parcel.readInt();
            for(int j = 0; j < i; j++)
                wifip2pgroup.addClient((WifiP2pDevice)parcel.readParcelable(null));

            wifip2pgroup.setPassphrase(parcel.readString());
            wifip2pgroup.setInterface(parcel.readString());
            return wifip2pgroup;
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public WifiP2pGroup[] newArray(int i) {
            return new WifiP2pGroup[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private static final Pattern groupStartedPattern = Pattern.compile("ssid=\"(.+)\" freq=(\\d+) (?:psk=)?([0-9a-fA-F]{64})?(?:passphrase=)?(?:\"(.{8,63})\")? go_dev_addr=((?:[0-9a-f]{2}:){5}[0-9a-f]{2})");
    private List mClients;
    private String mInterface;
    private boolean mIsGroupOwner;
    private String mNetworkName;
    private WifiP2pDevice mOwner;
    private String mPassphrase;

}
