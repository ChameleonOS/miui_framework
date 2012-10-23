// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.bluetooth;

import android.os.ParcelUuid;
import java.util.*;

public final class BluetoothUuid {

    public BluetoothUuid() {
    }

    public static boolean containsAllUuids(ParcelUuid aparceluuid[], ParcelUuid aparceluuid1[]) {
        boolean flag = true;
        if(aparceluuid != null || aparceluuid1 != null) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        HashSet hashset;
        int i;
        int j;
        if(aparceluuid == null) {
            if(aparceluuid1.length != 0)
                flag = false;
            continue; /* Loop/switch isn't completed */
        }
        if(aparceluuid1 == null)
            continue; /* Loop/switch isn't completed */
        hashset = new HashSet(Arrays.asList(aparceluuid));
        i = aparceluuid1.length;
        j = 0;
_L4:
        if(j < i) {
label0:
            {
                if(hashset.contains(aparceluuid1[j]))
                    break label0;
                flag = false;
            }
        }
        if(true) goto _L1; else goto _L3
_L3:
        j++;
          goto _L4
        if(true) goto _L1; else goto _L5
_L5:
    }

    public static boolean containsAnyUuid(ParcelUuid aparceluuid[], ParcelUuid aparceluuid1[]) {
        boolean flag = true;
        if(aparceluuid != null || aparceluuid1 != null) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if(aparceluuid == null) {
            if(aparceluuid1.length != 0)
                flag = false;
            continue; /* Loop/switch isn't completed */
        }
        if(aparceluuid1 == null) {
            if(aparceluuid.length != 0)
                flag = false;
            continue; /* Loop/switch isn't completed */
        }
        HashSet hashset = new HashSet(Arrays.asList(aparceluuid));
        int i = aparceluuid1.length;
        for(int j = 0; j < i; j++)
            if(hashset.contains(aparceluuid1[j]))
                continue; /* Loop/switch isn't completed */

        flag = false;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static int getServiceIdentifierFromParcelUuid(ParcelUuid parceluuid) {
        return (int)((0xffff00000000L & parceluuid.getUuid().getMostSignificantBits()) >>> 32);
    }

    public static boolean isAdvAudioDist(ParcelUuid parceluuid) {
        return parceluuid.equals(AdvAudioDist);
    }

    public static boolean isAudioSink(ParcelUuid parceluuid) {
        return parceluuid.equals(AudioSink);
    }

    public static boolean isAudioSource(ParcelUuid parceluuid) {
        return parceluuid.equals(AudioSource);
    }

    public static boolean isAvrcpController(ParcelUuid parceluuid) {
        return parceluuid.equals(AvrcpController);
    }

    public static boolean isAvrcpTarget(ParcelUuid parceluuid) {
        return parceluuid.equals(AvrcpTarget);
    }

    public static boolean isBnep(ParcelUuid parceluuid) {
        return parceluuid.equals(BNEP);
    }

    public static boolean isHandsfree(ParcelUuid parceluuid) {
        return parceluuid.equals(Handsfree);
    }

    public static boolean isHeadset(ParcelUuid parceluuid) {
        return parceluuid.equals(HSP);
    }

    public static boolean isInputDevice(ParcelUuid parceluuid) {
        return parceluuid.equals(Hid);
    }

    public static boolean isNap(ParcelUuid parceluuid) {
        return parceluuid.equals(NAP);
    }

    public static boolean isPanu(ParcelUuid parceluuid) {
        return parceluuid.equals(PANU);
    }

    public static boolean isUuidPresent(ParcelUuid aparceluuid[], ParcelUuid parceluuid) {
        boolean flag = false;
        if(aparceluuid != null && aparceluuid.length != 0 || parceluuid != null) goto _L2; else goto _L1
_L1:
        flag = true;
_L4:
        return flag;
_L2:
        int i;
        int j;
        if(aparceluuid == null)
            continue; /* Loop/switch isn't completed */
        i = aparceluuid.length;
        j = 0;
_L5:
        if(j < i) {
label0:
            {
                if(!aparceluuid[j].equals(parceluuid))
                    break label0;
                flag = true;
            }
        }
        if(true) goto _L4; else goto _L3
_L3:
        j++;
          goto _L5
        if(true) goto _L4; else goto _L6
_L6:
    }

    public static final ParcelUuid AdvAudioDist;
    public static final ParcelUuid AudioSink;
    public static final ParcelUuid AudioSource;
    public static final ParcelUuid AvrcpController;
    public static final ParcelUuid AvrcpTarget;
    public static final ParcelUuid BNEP = ParcelUuid.fromString("0000000f-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid HSP;
    public static final ParcelUuid HSP_AG = ParcelUuid.fromString("00001112-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid Handsfree;
    public static final ParcelUuid Handsfree_AG = ParcelUuid.fromString("0000111F-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid Hid = ParcelUuid.fromString("00001124-0000-1000-8000-00805f9b34fb");
    public static final ParcelUuid NAP;
    public static final ParcelUuid ObexObjectPush;
    public static final ParcelUuid PANU;
    public static final ParcelUuid PBAP_PSE = ParcelUuid.fromString("0000112f-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid RESERVED_UUIDS[];

    static  {
        AudioSink = ParcelUuid.fromString("0000110B-0000-1000-8000-00805F9B34FB");
        AudioSource = ParcelUuid.fromString("0000110A-0000-1000-8000-00805F9B34FB");
        AdvAudioDist = ParcelUuid.fromString("0000110D-0000-1000-8000-00805F9B34FB");
        HSP = ParcelUuid.fromString("00001108-0000-1000-8000-00805F9B34FB");
        Handsfree = ParcelUuid.fromString("0000111E-0000-1000-8000-00805F9B34FB");
        AvrcpController = ParcelUuid.fromString("0000110E-0000-1000-8000-00805F9B34FB");
        AvrcpTarget = ParcelUuid.fromString("0000110C-0000-1000-8000-00805F9B34FB");
        ObexObjectPush = ParcelUuid.fromString("00001105-0000-1000-8000-00805f9b34fb");
        PANU = ParcelUuid.fromString("00001115-0000-1000-8000-00805F9B34FB");
        NAP = ParcelUuid.fromString("00001116-0000-1000-8000-00805F9B34FB");
        ParcelUuid aparceluuid[] = new ParcelUuid[10];
        aparceluuid[0] = AudioSink;
        aparceluuid[1] = AudioSource;
        aparceluuid[2] = AdvAudioDist;
        aparceluuid[3] = HSP;
        aparceluuid[4] = Handsfree;
        aparceluuid[5] = AvrcpController;
        aparceluuid[6] = AvrcpTarget;
        aparceluuid[7] = ObexObjectPush;
        aparceluuid[8] = PANU;
        aparceluuid[9] = NAP;
        RESERVED_UUIDS = aparceluuid;
    }
}
