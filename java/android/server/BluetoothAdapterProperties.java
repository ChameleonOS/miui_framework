// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.server;

import android.content.Context;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package android.server:
//            BluetoothService

class BluetoothAdapterProperties {

    BluetoothAdapterProperties(Context context, BluetoothService bluetoothservice) {
        mContext = context;
        mService = bluetoothservice;
    }

    /**
     * @deprecated Method clear is deprecated
     */

    void clear() {
        this;
        JVM INSTR monitorenter ;
        mPropertiesMap.clear();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getAllProperties is deprecated
     */

    void getAllProperties() {
        this;
        JVM INSTR monitorenter ;
        String as[];
        mContext.enforceCallingOrSelfPermission("android.permission.BLUETOOTH", "Need BLUETOOTH permission");
        mPropertiesMap.clear();
        as = (String[])(String[])mService.getAdapterPropertiesNative();
        if(as != null) goto _L2; else goto _L1
_L1:
        Log.e("BluetoothAdapterProperties", "*Error*: GetAdapterProperties returned NULL");
_L6:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        int i = 0;
_L7:
        String s1;
        String s2;
        if(i >= as.length)
            break MISSING_BLOCK_LABEL_229;
        s1 = as[i];
        s2 = null;
        if(s1 == null) {
            Log.e("BluetoothAdapterProperties", (new StringBuilder()).append("Error:Adapter Property at index ").append(i).append(" is null").toString());
            break MISSING_BLOCK_LABEL_278;
        }
        if(!s1.equals("Devices") && !s1.equals("UUIDs")) goto _L4; else goto _L3
_L3:
        StringBuilder stringbuilder = new StringBuilder();
        i++;
        int j = Integer.valueOf(as[i]).intValue();
        for(int k = 0; k < j; k++) {
            i++;
            stringbuilder.append(as[i]);
            stringbuilder.append(",");
        }

        if(j > 0)
            s2 = stringbuilder.toString();
_L5:
        mPropertiesMap.put(s1, s2);
        break MISSING_BLOCK_LABEL_278;
        Exception exception;
        exception;
        throw exception;
_L4:
        i++;
        s2 = as[i];
          goto _L5
        String s = mService.getAdapterPathNative();
        if(s != null)
            mPropertiesMap.put("ObjectPath", (new StringBuilder()).append(s).append("/dev_").toString());
          goto _L6
        i++;
          goto _L7
    }

    String getObjectPath() {
        return getProperty("ObjectPath");
    }

    /**
     * @deprecated Method getProperty is deprecated
     */

    String getProperty(String s) {
        this;
        JVM INSTR monitorenter ;
        String s1;
        if(mPropertiesMap.isEmpty())
            getAllProperties();
        s1 = (String)mPropertiesMap.get(s);
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method isEmpty is deprecated
     */

    boolean isEmpty() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mPropertiesMap.isEmpty();
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setProperty is deprecated
     */

    void setProperty(String s, String s1) {
        this;
        JVM INSTR monitorenter ;
        mPropertiesMap.put(s, s1);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private static final String TAG = "BluetoothAdapterProperties";
    private final Context mContext;
    private final Map mPropertiesMap = new HashMap();
    private final BluetoothService mService;
}
