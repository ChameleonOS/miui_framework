// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.server;

import android.util.Log;
import java.util.*;

// Referenced classes of package android.server:
//            BluetoothService

class BluetoothDeviceProperties {

    BluetoothDeviceProperties(BluetoothService bluetoothservice) {
        mService = bluetoothservice;
    }

    Map addProperties(String s, String as[]) {
        HashMap hashmap = mPropertiesMap;
        hashmap;
        JVM INSTR monitorenter ;
          goto _L1
_L11:
        int i;
        if(i >= as.length) goto _L3; else goto _L2
_L2:
        s1 = as[i];
        s2 = null;
        if(s1 != null) goto _L5; else goto _L4
_L4:
        Log.e("BluetoothDeviceProperties", (new StringBuilder()).append("Error: Remote Device Property at index ").append(i).append(" is null").toString());
          goto _L6
_L5:
        if(!s1.equals("UUIDs") && !s1.equals("Nodes")) goto _L8; else goto _L7
_L7:
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
_L9:
        ((Map) (obj)).put(s1, s2);
        break; /* Loop/switch isn't completed */
        exception;
        throw exception;
_L8:
        i++;
        s2 = as[i];
        if(true) goto _L9; else goto _L6
_L3:
        mPropertiesMap.put(s, obj);
        hashmap;
        JVM INSTR monitorexit ;
        mService.updateDeviceServiceChannelCache(s);
        return ((Map) (obj));
_L1:
        Object obj = (Map)mPropertiesMap.get(s);
        Exception exception;
        String s1;
        String s2;
        if(obj == null)
            obj = new HashMap();
        i = 0;
        continue; /* Loop/switch isn't completed */
_L6:
        i++;
        if(true) goto _L11; else goto _L10
_L10:
    }

    String getProperty(String s, String s1) {
        HashMap hashmap = mPropertiesMap;
        hashmap;
        JVM INSTR monitorenter ;
        String s2;
        Map map = (Map)mPropertiesMap.get(s);
        if(map != null) {
            s2 = (String)map.get(s1);
            break MISSING_BLOCK_LABEL_119;
        }
        Map map1 = updateCache(s);
        if(map1 != null) {
            s2 = (String)map1.get(s1);
            break MISSING_BLOCK_LABEL_119;
        }
        break MISSING_BLOCK_LABEL_80;
        Exception exception;
        exception;
        throw exception;
        hashmap;
        JVM INSTR monitorexit ;
        Log.e("BluetoothDeviceProperties", (new StringBuilder()).append("getRemoteDeviceProperty: ").append(s1).append(" not present: ").append(s).toString());
        s2 = null;
        return s2;
    }

    boolean isEmpty() {
        HashMap hashmap = mPropertiesMap;
        hashmap;
        JVM INSTR monitorenter ;
        boolean flag = mPropertiesMap.isEmpty();
        return flag;
    }

    boolean isInCache(String s) {
        HashMap hashmap = mPropertiesMap;
        hashmap;
        JVM INSTR monitorenter ;
        boolean flag;
        if(mPropertiesMap.get(s) != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    Set keySet() {
        HashMap hashmap = mPropertiesMap;
        hashmap;
        JVM INSTR monitorenter ;
        Set set = mPropertiesMap.keySet();
        return set;
    }

    void setProperty(String s, String s1, String s2) {
        HashMap hashmap = mPropertiesMap;
        hashmap;
        JVM INSTR monitorenter ;
        Map map = (Map)mPropertiesMap.get(s);
        if(map != null) {
            map.put(s1, s2);
            mPropertiesMap.put(s, map);
        } else {
            Log.e("BluetoothDeviceProperties", (new StringBuilder()).append("setRemoteDeviceProperty for a device not in cache:").append(s).toString());
        }
        return;
    }

    Map updateCache(String s) {
        String as[] = mService.getRemoteDeviceProperties(s);
        Map map;
        if(as != null)
            map = addProperties(s, as);
        else
            map = null;
        return map;
    }

    private static final String TAG = "BluetoothDeviceProperties";
    private final HashMap mPropertiesMap = new HashMap();
    private final BluetoothService mService;
}
