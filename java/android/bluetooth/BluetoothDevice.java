// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.bluetooth;

import android.os.*;
import android.util.Log;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

// Referenced classes of package android.bluetooth:
//            BluetoothAdapter, IBluetooth, BluetoothSocket, BluetoothClass

public final class BluetoothDevice
    implements Parcelable {

    BluetoothDevice(String s) {
        getService();
        if(!BluetoothAdapter.checkBluetoothAddress(s)) {
            throw new IllegalArgumentException((new StringBuilder()).append(s).append(" is not a valid Bluetooth address").toString());
        } else {
            mAddress = s;
            return;
        }
    }

    public static byte[] convertPinToBytes(String s) {
        if(s != null) goto _L2; else goto _L1
_L1:
        byte abyte0[] = null;
_L4:
        return abyte0;
_L2:
        byte abyte1[] = s.getBytes("UTF-8");
        abyte0 = abyte1;
        if(abyte0.length <= 0 || abyte0.length > 16)
            abyte0 = null;
        continue; /* Loop/switch isn't completed */
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        Log.e("BluetoothDevice", "UTF-8 not supported?!?");
        abyte0 = null;
        if(true) goto _L4; else goto _L3
_L3:
    }

    static IBluetooth getService() {
        android/bluetooth/BluetoothDevice;
        JVM INSTR monitorenter ;
        android.os.IBinder ibinder;
        if(sService != null)
            break MISSING_BLOCK_LABEL_42;
        ibinder = ServiceManager.getService("bluetooth");
        if(ibinder == null)
            throw new RuntimeException("Bluetooth service not available");
        break MISSING_BLOCK_LABEL_35;
        Exception exception;
        exception;
        throw exception;
        sService = IBluetooth.Stub.asInterface(ibinder);
        android/bluetooth/BluetoothDevice;
        JVM INSTR monitorexit ;
        return sService;
    }

    public boolean cancelBondProcess() {
        boolean flag1 = sService.cancelBondProcess(mAddress);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothDevice", "", remoteexception);
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean cancelPairingUserInput() {
        boolean flag1 = sService.cancelPairingUserInput(mAddress);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothDevice", "", remoteexception);
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean createBond() {
        boolean flag1 = sService.createBond(mAddress);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothDevice", "", remoteexception);
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean createBondOutOfBand(byte abyte0[], byte abyte1[]) {
        boolean flag1 = sService.createBondOutOfBand(mAddress, abyte0, abyte1);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothDevice", "", remoteexception);
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public BluetoothSocket createInsecureRfcommSocket(int i) throws IOException {
        return new BluetoothSocket(1, -1, false, false, this, i, null);
    }

    public BluetoothSocket createInsecureRfcommSocketToServiceRecord(UUID uuid) throws IOException {
        return new BluetoothSocket(1, -1, false, false, this, -1, new ParcelUuid(uuid));
    }

    public BluetoothSocket createRfcommSocket(int i) throws IOException {
        return new BluetoothSocket(1, -1, true, true, this, i, null);
    }

    public BluetoothSocket createRfcommSocketToServiceRecord(UUID uuid) throws IOException {
        return new BluetoothSocket(1, -1, true, true, this, -1, new ParcelUuid(uuid));
    }

    public BluetoothSocket createScoSocket() throws IOException {
        return new BluetoothSocket(2, -1, true, true, this, -1, null);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean flag;
        if(obj instanceof BluetoothDevice)
            flag = mAddress.equals(((BluetoothDevice)obj).getAddress());
        else
            flag = false;
        return flag;
    }

    public boolean fetchUuidsWithSdp() {
        boolean flag1 = sService.fetchRemoteUuids(mAddress, null, null);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothDevice", "", remoteexception);
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public String getAddress() {
        return mAddress;
    }

    public String getAlias() {
        String s1 = sService.getRemoteAlias(mAddress);
        String s = s1;
_L2:
        return s;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothDevice", "", remoteexception);
        s = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public String getAliasName() {
        String s = getAlias();
        if(s == null)
            s = getName();
        return s;
    }

    public BluetoothClass getBluetoothClass() {
        BluetoothClass bluetoothclass = null;
        BluetoothClass bluetoothclass1;
        int i = sService.getRemoteClass(mAddress);
        if(i == 0xff000000)
            break MISSING_BLOCK_LABEL_54;
        bluetoothclass1 = new BluetoothClass(i);
        bluetoothclass = bluetoothclass1;
        break MISSING_BLOCK_LABEL_54;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothDevice", "", remoteexception);
        return bluetoothclass;
    }

    public int getBondState() {
        int j = sService.getBondState(mAddress);
        int i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothDevice", "", remoteexception);
        i = 10;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public String getName() {
        String s1 = sService.getRemoteName(mAddress);
        String s = s1;
_L2:
        return s;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothDevice", "", remoteexception);
        s = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int getServiceChannel(ParcelUuid parceluuid) {
        int j = sService.getRemoteServiceChannel(mAddress, parceluuid);
        int i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothDevice", "", remoteexception);
        i = 0x80000000;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean getTrustState() {
        boolean flag1 = sService.getTrustState(mAddress);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothDevice", "", remoteexception);
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public ParcelUuid[] getUuids() {
        ParcelUuid aparceluuid1[] = sService.getRemoteUuids(mAddress);
        ParcelUuid aparceluuid[] = aparceluuid1;
_L2:
        return aparceluuid;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothDevice", "", remoteexception);
        aparceluuid = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int hashCode() {
        return mAddress.hashCode();
    }

    public boolean isBluetoothDock() {
        boolean flag1 = sService.isBluetoothDock(mAddress);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothDevice", "", remoteexception);
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean removeBond() {
        boolean flag1 = sService.removeBond(mAddress);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothDevice", "", remoteexception);
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean setAlias(String s) {
        boolean flag1 = sService.setRemoteAlias(mAddress, s);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothDevice", "", remoteexception);
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean setDeviceOutOfBandData(byte abyte0[], byte abyte1[]) {
        boolean flag1 = sService.setDeviceOutOfBandData(mAddress, abyte0, abyte1);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothDevice", "", remoteexception);
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean setPairingConfirmation(boolean flag) {
        boolean flag2 = sService.setPairingConfirmation(mAddress, flag);
        boolean flag1 = flag2;
_L2:
        return flag1;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothDevice", "", remoteexception);
        flag1 = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean setPasskey(int i) {
        boolean flag1 = sService.setPasskey(mAddress, i);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothDevice", "", remoteexception);
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean setPin(byte abyte0[]) {
        boolean flag1 = sService.setPin(mAddress, abyte0);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothDevice", "", remoteexception);
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean setRemoteOutOfBandData() {
        boolean flag1 = sService.setRemoteOutOfBandData(mAddress);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothDevice", "", remoteexception);
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean setTrust(boolean flag) {
        boolean flag2 = sService.setTrust(mAddress, flag);
        boolean flag1 = flag2;
_L2:
        return flag1;
        RemoteException remoteexception;
        remoteexception;
        Log.e("BluetoothDevice", "", remoteexception);
        flag1 = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public String toString() {
        return mAddress;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mAddress);
    }

    public static final String ACTION_ACL_CONNECTED = "android.bluetooth.device.action.ACL_CONNECTED";
    public static final String ACTION_ACL_DISCONNECTED = "android.bluetooth.device.action.ACL_DISCONNECTED";
    public static final String ACTION_ACL_DISCONNECT_REQUESTED = "android.bluetooth.device.action.ACL_DISCONNECT_REQUESTED";
    public static final String ACTION_ALIAS_CHANGED = "android.bluetooth.device.action.ALIAS_CHANGED";
    public static final String ACTION_BOND_STATE_CHANGED = "android.bluetooth.device.action.BOND_STATE_CHANGED";
    public static final String ACTION_CLASS_CHANGED = "android.bluetooth.device.action.CLASS_CHANGED";
    public static final String ACTION_CONNECTION_ACCESS_CANCEL = "android.bluetooth.device.action.CONNECTION_ACCESS_CANCEL";
    public static final String ACTION_CONNECTION_ACCESS_REPLY = "android.bluetooth.device.action.CONNECTION_ACCESS_REPLY";
    public static final String ACTION_CONNECTION_ACCESS_REQUEST = "android.bluetooth.device.action.CONNECTION_ACCESS_REQUEST";
    public static final String ACTION_DISAPPEARED = "android.bluetooth.device.action.DISAPPEARED";
    public static final String ACTION_FOUND = "android.bluetooth.device.action.FOUND";
    public static final String ACTION_NAME_CHANGED = "android.bluetooth.device.action.NAME_CHANGED";
    public static final String ACTION_NAME_FAILED = "android.bluetooth.device.action.NAME_FAILED";
    public static final String ACTION_PAIRING_CANCEL = "android.bluetooth.device.action.PAIRING_CANCEL";
    public static final String ACTION_PAIRING_REQUEST = "android.bluetooth.device.action.PAIRING_REQUEST";
    public static final String ACTION_UUID = "android.bluetooth.device.action.UUID";
    public static final int BOND_BONDED = 12;
    public static final int BOND_BONDING = 11;
    public static final int BOND_NONE = 10;
    public static final int BOND_SUCCESS = 0;
    public static final int CONNECTION_ACCESS_NO = 2;
    public static final int CONNECTION_ACCESS_YES = 1;
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public BluetoothDevice createFromParcel(Parcel parcel) {
            return new BluetoothDevice(parcel.readString());
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public BluetoothDevice[] newArray(int i) {
            return new BluetoothDevice[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int ERROR = 0x80000000;
    public static final String EXTRA_ACCESS_REQUEST_TYPE = "android.bluetooth.device.extra.ACCESS_REQUEST_TYPE";
    public static final String EXTRA_ALWAYS_ALLOWED = "android.bluetooth.device.extra.ALWAYS_ALLOWED";
    public static final String EXTRA_BOND_STATE = "android.bluetooth.device.extra.BOND_STATE";
    public static final String EXTRA_CLASS = "android.bluetooth.device.extra.CLASS";
    public static final String EXTRA_CLASS_NAME = "android.bluetooth.device.extra.CLASS_NAME";
    public static final String EXTRA_CONNECTION_ACCESS_RESULT = "android.bluetooth.device.extra.CONNECTION_ACCESS_RESULT";
    public static final String EXTRA_DEVICE = "android.bluetooth.device.extra.DEVICE";
    public static final String EXTRA_NAME = "android.bluetooth.device.extra.NAME";
    public static final String EXTRA_PACKAGE_NAME = "android.bluetooth.device.extra.PACKAGE_NAME";
    public static final String EXTRA_PAIRING_KEY = "android.bluetooth.device.extra.PAIRING_KEY";
    public static final String EXTRA_PAIRING_VARIANT = "android.bluetooth.device.extra.PAIRING_VARIANT";
    public static final String EXTRA_PREVIOUS_BOND_STATE = "android.bluetooth.device.extra.PREVIOUS_BOND_STATE";
    public static final String EXTRA_REASON = "android.bluetooth.device.extra.REASON";
    public static final String EXTRA_RSSI = "android.bluetooth.device.extra.RSSI";
    public static final String EXTRA_UUID = "android.bluetooth.device.extra.UUID";
    public static final int PAIRING_VARIANT_CONSENT = 3;
    public static final int PAIRING_VARIANT_DISPLAY_PASSKEY = 4;
    public static final int PAIRING_VARIANT_DISPLAY_PIN = 5;
    public static final int PAIRING_VARIANT_OOB_CONSENT = 6;
    public static final int PAIRING_VARIANT_PASSKEY = 1;
    public static final int PAIRING_VARIANT_PASSKEY_CONFIRMATION = 2;
    public static final int PAIRING_VARIANT_PIN = 0;
    public static final int REQUEST_TYPE_PHONEBOOK_ACCESS = 2;
    public static final int REQUEST_TYPE_PROFILE_CONNECTION = 1;
    private static final String TAG = "BluetoothDevice";
    public static final int UNBOND_REASON_AUTH_CANCELED = 3;
    public static final int UNBOND_REASON_AUTH_FAILED = 1;
    public static final int UNBOND_REASON_AUTH_REJECTED = 2;
    public static final int UNBOND_REASON_AUTH_TIMEOUT = 6;
    public static final int UNBOND_REASON_DISCOVERY_IN_PROGRESS = 5;
    public static final int UNBOND_REASON_REMOTE_AUTH_CANCELED = 8;
    public static final int UNBOND_REASON_REMOTE_DEVICE_DOWN = 4;
    public static final int UNBOND_REASON_REMOVED = 9;
    public static final int UNBOND_REASON_REPEATED_ATTEMPTS = 7;
    private static IBluetooth sService;
    private final String mAddress;

}
