// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageItemInfo;
import android.telephony.SignalStrength;
import android.util.*;
import java.io.PrintWriter;
import java.util.*;

// Referenced classes of package android.os:
//            Parcelable, SystemClock, Parcel

public abstract class BatteryStats
    implements Parcelable {
    public static class HistoryPrinter {

        public void printNextItem(PrintWriter printwriter, HistoryItem historyitem, long l) {
            printwriter.print("  ");
            TimeUtils.formatDuration(historyitem.time - l, printwriter, 19);
            printwriter.print(" ");
            if(historyitem.cmd == 2) {
                printwriter.println(" START");
            } else {
label0:
                {
                    if(historyitem.cmd != 3)
                        break label0;
                    printwriter.println(" *OVERFLOW*");
                }
            }
_L24:
            oldState = historyitem.states;
            return;
            if(historyitem.batteryLevel < 10)
                printwriter.print("00");
            else
            if(historyitem.batteryLevel < 100)
                printwriter.print("0");
            printwriter.print(historyitem.batteryLevel);
            printwriter.print(" ");
            if(historyitem.states < 16)
                printwriter.print("0000000");
            else
            if(historyitem.states < 256)
                printwriter.print("000000");
            else
            if(historyitem.states < 4096)
                printwriter.print("00000");
            else
            if(historyitem.states < 0x10000)
                printwriter.print("0000");
            else
            if(historyitem.states < 0x100000)
                printwriter.print("000");
            else
            if(historyitem.states < 0x1000000)
                printwriter.print("00");
            else
            if(historyitem.states < 0x10000000)
                printwriter.print("0");
            printwriter.print(Integer.toHexString(historyitem.states));
            if(oldStatus == historyitem.batteryStatus) goto _L2; else goto _L1
_L1:
            oldStatus = historyitem.batteryStatus;
            printwriter.print(" status=");
            oldStatus;
            JVM INSTR tableswitch 1 5: default 184
        //                       1 548
        //                       2 557
        //                       3 566
        //                       4 575
        //                       5 584;
               goto _L3 _L4 _L5 _L6 _L7 _L8
_L3:
            printwriter.print(oldStatus);
_L2:
            if(oldHealth == historyitem.batteryHealth) goto _L10; else goto _L9
_L9:
            oldHealth = historyitem.batteryHealth;
            printwriter.print(" health=");
            oldHealth;
            JVM INSTR tableswitch 1 6: default 260
        //                       1 593
        //                       2 602
        //                       3 611
        //                       4 620
        //                       5 629
        //                       6 638;
               goto _L11 _L12 _L13 _L14 _L15 _L16 _L17
_L11:
            printwriter.print(oldHealth);
_L10:
            if(oldPlug == historyitem.batteryPlugType) goto _L19; else goto _L18
_L18:
            oldPlug = historyitem.batteryPlugType;
            printwriter.print(" plug=");
            oldPlug;
            JVM INSTR tableswitch 0 2: default 324
        //                       0 647
        //                       1 656
        //                       2 665;
               goto _L20 _L21 _L22 _L23
_L23:
            break MISSING_BLOCK_LABEL_665;
_L20:
            printwriter.print(oldPlug);
_L19:
            if(oldTemp != historyitem.batteryTemperature) {
                oldTemp = historyitem.batteryTemperature;
                printwriter.print(" temp=");
                printwriter.print(oldTemp);
            }
            if(oldVolt != historyitem.batteryVoltage) {
                oldVolt = historyitem.batteryVoltage;
                printwriter.print(" volt=");
                printwriter.print(oldVolt);
            }
            BatteryStats.printBitDescriptions(printwriter, oldState, historyitem.states, BatteryStats.HISTORY_STATE_DESCRIPTIONS);
            printwriter.println();
              goto _L24
_L4:
            printwriter.print("unknown");
              goto _L2
_L5:
            printwriter.print("charging");
              goto _L2
_L6:
            printwriter.print("discharging");
              goto _L2
_L7:
            printwriter.print("not-charging");
              goto _L2
_L8:
            printwriter.print("full");
              goto _L2
_L12:
            printwriter.print("unknown");
              goto _L10
_L13:
            printwriter.print("good");
              goto _L10
_L14:
            printwriter.print("overheat");
              goto _L10
_L15:
            printwriter.print("dead");
              goto _L10
_L16:
            printwriter.print("over-voltage");
              goto _L10
_L17:
            printwriter.print("failure");
              goto _L10
_L21:
            printwriter.print("none");
              goto _L19
_L22:
            printwriter.print("ac");
              goto _L19
            printwriter.print("usb");
              goto _L19
        }

        int oldHealth;
        int oldPlug;
        int oldState;
        int oldStatus;
        int oldTemp;
        int oldVolt;

        public HistoryPrinter() {
            oldState = 0;
            oldStatus = -1;
            oldHealth = -1;
            oldPlug = -1;
            oldTemp = -1;
            oldVolt = -1;
        }
    }

    public static final class BitDescription {

        public final int mask;
        public final String name;
        public final int shift;
        public final String values[];

        public BitDescription(int i, int j, String s, String as[]) {
            mask = i;
            shift = j;
            name = s;
            values = as;
        }

        public BitDescription(int i, String s) {
            mask = i;
            shift = -1;
            name = s;
            values = null;
        }
    }

    public static final class HistoryItem
        implements Parcelable {

        private int buildBatteryLevelInt() {
            return 0xff000000 & batteryLevel << 24 | 0xffc000 & batteryTemperature << 14 | 0x3fff & batteryVoltage;
        }

        private int buildStateInt() {
            return 0xf0000000 & batteryStatus << 28 | 0xf000000 & batteryHealth << 24 | 0xc00000 & batteryPlugType << 22 | 0x3fffff & states;
        }

        private void readFromParcel(Parcel parcel) {
            int i = parcel.readInt();
            cmd = (byte)(i & 0xff);
            batteryLevel = (byte)(0xff & i >> 8);
            batteryStatus = (byte)(0xf & i >> 16);
            batteryHealth = (byte)(0xf & i >> 20);
            batteryPlugType = (byte)(0xf & i >> 24);
            int j = parcel.readInt();
            batteryTemperature = (char)(j & 0xffff);
            batteryVoltage = (char)(0xffff & j >> 16);
            states = parcel.readInt();
        }

        public void clear() {
            time = 0L;
            cmd = 0;
            batteryLevel = 0;
            batteryStatus = 0;
            batteryHealth = 0;
            batteryPlugType = 0;
            batteryTemperature = '\0';
            batteryVoltage = '\0';
            states = 0;
        }

        public int describeContents() {
            return 0;
        }

        public void readDelta(Parcel parcel) {
            int i;
            int j;
            i = parcel.readInt();
            j = i & 0x3ffff;
            cmd = (byte)(3 & i >> 18);
            if(j >= 0x3fffd) goto _L2; else goto _L1
_L1:
            time = time + (long)j;
_L5:
            if((0x100000 & i) != 0) {
                int l = parcel.readInt();
                batteryLevel = (byte)(0xff & l >> 24);
                batteryTemperature = (char)(0x3ff & l >> 14);
                batteryVoltage = (char)(l & 0x3fff);
            }
            int i1;
            if((0x200000 & i) != 0) {
                int k = parcel.readInt();
                states = i & 0xffc00000 | k & 0x3fffff;
                batteryStatus = (byte)(0xf & k >> 28);
                batteryHealth = (byte)(0xf & k >> 24);
                batteryPlugType = (byte)(3 & k >> 22);
            } else {
                states = i & 0xffc00000 | 0x3fffff & states;
            }
_L4:
            return;
_L2:
            if(j != 0x3fffd)
                break; /* Loop/switch isn't completed */
            time = parcel.readLong();
            readFromParcel(parcel);
            if(true) goto _L4; else goto _L3
_L3:
            if(j == 0x3fffe) {
                i1 = parcel.readInt();
                time = time + (long)i1;
            } else {
                time = parcel.readLong() + time;
            }
              goto _L5
        }

        public boolean same(HistoryItem historyitem) {
            boolean flag;
            if(batteryLevel == historyitem.batteryLevel && batteryStatus == historyitem.batteryStatus && batteryHealth == historyitem.batteryHealth && batteryPlugType == historyitem.batteryPlugType && batteryTemperature == historyitem.batteryTemperature && batteryVoltage == historyitem.batteryVoltage && states == historyitem.states)
                flag = true;
            else
                flag = false;
            return flag;
        }

        public void setTo(long l, byte byte0, HistoryItem historyitem) {
            time = l;
            cmd = byte0;
            batteryLevel = historyitem.batteryLevel;
            batteryStatus = historyitem.batteryStatus;
            batteryHealth = historyitem.batteryHealth;
            batteryPlugType = historyitem.batteryPlugType;
            batteryTemperature = historyitem.batteryTemperature;
            batteryVoltage = historyitem.batteryVoltage;
            states = historyitem.states;
        }

        public void setTo(HistoryItem historyitem) {
            time = historyitem.time;
            cmd = historyitem.cmd;
            batteryLevel = historyitem.batteryLevel;
            batteryStatus = historyitem.batteryStatus;
            batteryHealth = historyitem.batteryHealth;
            batteryPlugType = historyitem.batteryPlugType;
            batteryTemperature = historyitem.batteryTemperature;
            batteryVoltage = historyitem.batteryVoltage;
            states = historyitem.states;
        }

        public void writeDelta(Parcel parcel, HistoryItem historyitem) {
            if(historyitem != null && historyitem.cmd == 1) goto _L2; else goto _L1
_L1:
            parcel.writeInt(0x3fffd);
            writeToParcel(parcel, 0);
_L4:
            return;
_L2:
            long l = time - historyitem.time;
            int i = historyitem.buildBatteryLevelInt();
            int j = historyitem.buildStateInt();
            int k;
            int i1;
            int j1;
            boolean flag;
            int k1;
            boolean flag1;
            if(l < 0L || l > 0x7fffffffL)
                k = 0x3ffff;
            else
            if(l >= 0x3fffdL)
                k = 0x3fffe;
            else
                k = (int)l;
            i1 = k | cmd << 18 | 0xffc00000 & states;
            j1 = buildBatteryLevelInt();
            if(j1 != i)
                flag = true;
            else
                flag = false;
            if(flag)
                i1 |= 0x100000;
            k1 = buildStateInt();
            if(k1 != j)
                flag1 = true;
            else
                flag1 = false;
            if(flag1)
                i1 |= 0x200000;
            parcel.writeInt(i1);
            if(k >= 0x3fffe)
                if(k == 0x3fffe)
                    parcel.writeInt((int)l);
                else
                    parcel.writeLong(l);
            if(flag)
                parcel.writeInt(j1);
            if(flag1)
                parcel.writeInt(k1);
            if(true) goto _L4; else goto _L3
_L3:
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(time);
            parcel.writeInt(0xff & cmd | 0xff00 & batteryLevel << 8 | 0xf0000 & batteryStatus << 16 | 0xf00000 & batteryHealth << 20 | 0xf000000 & batteryPlugType << 24);
            parcel.writeInt(0xffff & batteryTemperature | 0xffff0000 & batteryVoltage << 16);
            parcel.writeInt(states);
        }

        public static final byte CMD_NULL = 0;
        public static final byte CMD_OVERFLOW = 3;
        public static final byte CMD_START = 2;
        public static final byte CMD_UPDATE = 1;
        static final boolean DEBUG = false;
        static final int DELTA_BATTERY_LEVEL_FLAG = 0x100000;
        static final int DELTA_CMD_MASK = 3;
        static final int DELTA_CMD_SHIFT = 18;
        static final int DELTA_STATE_FLAG = 0x200000;
        static final int DELTA_STATE_MASK = 0xffc00000;
        static final int DELTA_TIME_ABS = 0x3fffd;
        static final int DELTA_TIME_INT = 0x3fffe;
        static final int DELTA_TIME_LONG = 0x3ffff;
        static final int DELTA_TIME_MASK = 0x3ffff;
        public static final int MOST_INTERESTING_STATES = 0x101c0000;
        public static final int STATE_AUDIO_ON_FLAG = 0x400000;
        public static final int STATE_BATTERY_PLUGGED_FLAG = 0x80000;
        public static final int STATE_BLUETOOTH_ON_FLAG = 0x10000;
        public static final int STATE_BRIGHTNESS_MASK = 15;
        public static final int STATE_BRIGHTNESS_SHIFT = 0;
        public static final int STATE_DATA_CONNECTION_MASK = 61440;
        public static final int STATE_DATA_CONNECTION_SHIFT = 12;
        public static final int STATE_GPS_ON_FLAG = 0x10000000;
        public static final int STATE_PHONE_IN_CALL_FLAG = 0x40000;
        public static final int STATE_PHONE_SCANNING_FLAG = 0x8000000;
        public static final int STATE_PHONE_STATE_MASK = 3840;
        public static final int STATE_PHONE_STATE_SHIFT = 8;
        public static final int STATE_SCREEN_ON_FLAG = 0x100000;
        public static final int STATE_SENSOR_ON_FLAG = 0x20000000;
        public static final int STATE_SIGNAL_STRENGTH_MASK = 240;
        public static final int STATE_SIGNAL_STRENGTH_SHIFT = 4;
        public static final int STATE_VIDEO_ON_FLAG = 0x200000;
        public static final int STATE_WAKE_LOCK_FLAG = 0x40000000;
        public static final int STATE_WIFI_FULL_LOCK_FLAG = 0x2000000;
        public static final int STATE_WIFI_MULTICAST_ON_FLAG = 0x800000;
        public static final int STATE_WIFI_ON_FLAG = 0x20000;
        public static final int STATE_WIFI_RUNNING_FLAG = 0x4000000;
        public static final int STATE_WIFI_SCAN_LOCK_FLAG = 0x1000000;
        static final String TAG = "HistoryItem";
        public byte batteryHealth;
        public byte batteryLevel;
        public byte batteryPlugType;
        public byte batteryStatus;
        public char batteryTemperature;
        public char batteryVoltage;
        public byte cmd;
        public HistoryItem next;
        public int states;
        public long time;

        public HistoryItem() {
            cmd = 0;
        }

        public HistoryItem(long l, Parcel parcel) {
            cmd = 0;
            time = l;
            readFromParcel(parcel);
        }
    }

    public static abstract class Uid {
        public static abstract class Pkg {
            public abstract class Serv {

                public abstract int getLaunches(int i);

                public abstract long getStartTime(long l, int i);

                public abstract int getStarts(int i);

                final Pkg this$0;

                public Serv() {
                    this$0 = Pkg.this;
                    super();
                }
            }


            public abstract Map getServiceStats();

            public abstract int getWakeups(int i);

            public Pkg() {
            }
        }

        public static abstract class Proc {
            public static class ExcessivePower {

                public static final int TYPE_CPU = 2;
                public static final int TYPE_WAKE = 1;
                public long overTime;
                public int type;
                public long usedTime;

                public ExcessivePower() {
                }
            }


            public abstract int countExcessivePowers();

            public abstract ExcessivePower getExcessivePower(int i);

            public abstract long getForegroundTime(int i);

            public abstract int getStarts(int i);

            public abstract long getSystemTime(int i);

            public abstract long getTimeAtCpuSpeedStep(int i, int j);

            public abstract long getUserTime(int i);

            public Proc() {
            }
        }

        public class Pid {

            public long mWakeStart;
            public long mWakeSum;
            final Uid this$0;

            public Pid() {
                this$0 = Uid.this;
                super();
            }
        }

        public static abstract class Sensor {

            public abstract int getHandle();

            public abstract Timer getSensorTime();

            public static final int GPS = -10000;

            public Sensor() {
            }
        }

        public static abstract class Wakelock {

            public abstract Timer getWakeTime(int i);

            public Wakelock() {
            }
        }


        public abstract long getAudioTurnedOnTime(long l, int i);

        public abstract long getFullWifiLockTime(long l, int i);

        public abstract Map getPackageStats();

        public abstract SparseArray getPidStats();

        public abstract Map getProcessStats();

        public abstract long getScanWifiLockTime(long l, int i);

        public abstract Map getSensorStats();

        public abstract long getTcpBytesReceived(int i);

        public abstract long getTcpBytesSent(int i);

        public abstract int getUid();

        public abstract int getUserActivityCount(int i, int j);

        public abstract long getVideoTurnedOnTime(long l, int i);

        public abstract Map getWakelockStats();

        public abstract long getWifiMulticastTime(long l, int i);

        public abstract long getWifiRunningTime(long l, int i);

        public abstract boolean hasUserActivity();

        public abstract void noteAudioTurnedOffLocked();

        public abstract void noteAudioTurnedOnLocked();

        public abstract void noteFullWifiLockAcquiredLocked();

        public abstract void noteFullWifiLockReleasedLocked();

        public abstract void noteScanWifiLockAcquiredLocked();

        public abstract void noteScanWifiLockReleasedLocked();

        public abstract void noteUserActivityLocked(int i);

        public abstract void noteVideoTurnedOffLocked();

        public abstract void noteVideoTurnedOnLocked();

        public abstract void noteWifiMulticastDisabledLocked();

        public abstract void noteWifiMulticastEnabledLocked();

        public abstract void noteWifiRunningLocked();

        public abstract void noteWifiStoppedLocked();

        public static final int NUM_USER_ACTIVITY_TYPES = 7;
        static final String USER_ACTIVITY_TYPES[];

        static  {
            String as[] = new String[7];
            as[0] = "other";
            as[1] = "cheek";
            as[2] = "touch";
            as[3] = "long_touch";
            as[4] = "touch_up";
            as[5] = "button";
            as[6] = "unknown";
            USER_ACTIVITY_TYPES = as;
        }

        public Uid() {
        }
    }

    public static abstract class Timer {

        public abstract int getCountLocked(int i);

        public abstract long getTotalTimeLocked(long l, int i);

        public abstract void logState(Printer printer, String s);

        public Timer() {
        }
    }

    public static abstract class Counter {

        public abstract int getCountLocked(int i);

        public abstract void logState(Printer printer, String s);

        public Counter() {
        }
    }


    public BatteryStats() {
        mFormatter = new Formatter(mFormatBuilder);
    }

    private static long computeWakeLock(Timer timer, long l, int i) {
        long l1;
        if(timer != null)
            l1 = (500L + timer.getTotalTimeLocked(l, i)) / 1000L;
        else
            l1 = 0L;
        return l1;
    }

    private static final transient void dumpLine(PrintWriter printwriter, int i, String s, String s1, Object aobj[]) {
        printwriter.print(5);
        printwriter.print(',');
        printwriter.print(i);
        printwriter.print(',');
        printwriter.print(s);
        printwriter.print(',');
        printwriter.print(s1);
        int j = aobj.length;
        for(int k = 0; k < j; k++) {
            Object obj = aobj[k];
            printwriter.print(',');
            printwriter.print(obj);
        }

        printwriter.print('\n');
    }

    private final String formatBytesLocked(long l) {
        mFormatBuilder.setLength(0);
        String s;
        if(l < 1024L)
            s = (new StringBuilder()).append(l).append("B").toString();
        else
        if(l < 0x100000L) {
            Formatter formatter2 = mFormatter;
            Object aobj2[] = new Object[1];
            aobj2[0] = Double.valueOf((double)l / 1024D);
            formatter2.format("%.2fKB", aobj2);
            s = mFormatBuilder.toString();
        } else
        if(l < 0x40000000L) {
            Formatter formatter1 = mFormatter;
            Object aobj1[] = new Object[1];
            aobj1[0] = Double.valueOf((double)l / 1048576D);
            formatter1.format("%.2fMB", aobj1);
            s = mFormatBuilder.toString();
        } else {
            Formatter formatter = mFormatter;
            Object aobj[] = new Object[1];
            aobj[0] = Double.valueOf((double)l / 1073741824D);
            formatter.format("%.2fGB", aobj);
            s = mFormatBuilder.toString();
        }
        return s;
    }

    private final String formatRatioLocked(long l, long l1) {
        String s;
        if(l1 == 0L) {
            s = "---%";
        } else {
            float f = 100F * ((float)l / (float)l1);
            mFormatBuilder.setLength(0);
            Formatter formatter = mFormatter;
            Object aobj[] = new Object[1];
            aobj[0] = Float.valueOf(f);
            formatter.format("%.1f%%", aobj);
            s = mFormatBuilder.toString();
        }
        return s;
    }

    private static final void formatTime(StringBuilder stringbuilder, long l) {
        long l1 = l / 100L;
        formatTimeRaw(stringbuilder, l1);
        stringbuilder.append(10L * (l - 100L * l1));
        stringbuilder.append("ms ");
    }

    private static final void formatTimeMs(StringBuilder stringbuilder, long l) {
        long l1 = l / 1000L;
        formatTimeRaw(stringbuilder, l1);
        stringbuilder.append(l - 1000L * l1);
        stringbuilder.append("ms ");
    }

    private static final void formatTimeRaw(StringBuilder stringbuilder, long l) {
        long l1 = l / 0x15180L;
        if(l1 != 0L) {
            stringbuilder.append(l1);
            stringbuilder.append("d ");
        }
        long l2 = 24L * (60L * (60L * l1));
        long l3 = (l - l2) / 3600L;
        if(l3 != 0L || l2 != 0L) {
            stringbuilder.append(l3);
            stringbuilder.append("h ");
        }
        long l4 = l2 + 60L * (60L * l3);
        long l5 = (l - l4) / 60L;
        if(l5 != 0L || l4 != 0L) {
            stringbuilder.append(l5);
            stringbuilder.append("m ");
        }
        long l6 = l4 + 60L * l5;
        if(l != 0L || l6 != 0L) {
            stringbuilder.append(l - l6);
            stringbuilder.append("s ");
        }
    }

    static void printBitDescriptions(PrintWriter printwriter, int i, int j, BitDescription abitdescription[]) {
        int k = i ^ j;
        if(k != 0) {
            int l = 0;
            while(l < abitdescription.length)  {
                BitDescription bitdescription = abitdescription[l];
                if((k & bitdescription.mask) != 0)
                    if(bitdescription.shift < 0) {
                        String s;
                        if((j & bitdescription.mask) != 0)
                            s = " +";
                        else
                            s = " -";
                        printwriter.print(s);
                        printwriter.print(bitdescription.name);
                    } else {
                        printwriter.print(" ");
                        printwriter.print(bitdescription.name);
                        printwriter.print("=");
                        int i1 = (j & bitdescription.mask) >> bitdescription.shift;
                        if(bitdescription.values != null && i1 >= 0 && i1 < bitdescription.values.length)
                            printwriter.print(bitdescription.values[i1]);
                        else
                            printwriter.print(i1);
                    }
                l++;
            }
        }
    }

    private static final String printWakeLock(StringBuilder stringbuilder, Timer timer, long l, String s, int i, String s1) {
        if(timer != null) {
            long l1 = computeWakeLock(timer, l, i);
            int j = timer.getCountLocked(i);
            if(l1 != 0L) {
                stringbuilder.append(s1);
                formatTimeMs(stringbuilder, l1);
                if(s != null)
                    stringbuilder.append(s);
                stringbuilder.append(' ');
                stringbuilder.append('(');
                stringbuilder.append(j);
                stringbuilder.append(" times)");
                s1 = ", ";
            }
        }
        return s1;
    }

    private static final String printWakeLockCheckin(StringBuilder stringbuilder, Timer timer, long l, String s, int i, String s1) {
        long l1 = 0L;
        int j = 0;
        if(timer != null) {
            l1 = timer.getTotalTimeLocked(l, i);
            j = timer.getCountLocked(i);
        }
        stringbuilder.append(s1);
        stringbuilder.append((500L + l1) / 1000L);
        stringbuilder.append(',');
        String s2;
        if(s != null)
            s2 = (new StringBuilder()).append(s).append(",").toString();
        else
            s2 = "";
        stringbuilder.append(s2);
        stringbuilder.append(j);
        return ",";
    }

    public abstract long computeBatteryRealtime(long l, int i);

    public abstract long computeBatteryUptime(long l, int i);

    public abstract long computeRealtime(long l, int i);

    public abstract long computeUptime(long l, int i);

    public final void dumpCheckinLocked(PrintWriter printwriter, int i, int j) {
        long l = 1000L * SystemClock.uptimeMillis();
        long l1 = 1000L * SystemClock.elapsedRealtime();
        long l2 = getBatteryUptime(l);
        long l3 = getBatteryRealtime(l1);
        long l4 = computeBatteryUptime(l, i);
        long l5 = computeBatteryRealtime(l1, i);
        long l6 = computeRealtime(l1, i);
        long l7 = computeUptime(l, i);
        long l8 = getScreenOnTime(l3, i);
        long l9 = getPhoneOnTime(l3, i);
        long l10 = getWifiOnTime(l3, i);
        long l11 = getGlobalWifiRunningTime(l3, i);
        long l12 = getBluetoothOnTime(l3, i);
        StringBuilder stringbuilder = new StringBuilder(128);
        SparseArray sparsearray = getUidStats();
        int k = sparsearray.size();
        String s = STAT_NAMES[i];
        Object aobj[] = new Object[5];
        Object obj;
        long l13;
        long l14;
        long l15;
        long l16;
        if(i == 0)
            obj = Integer.valueOf(getStartCount());
        else
            obj = "N/A";
        aobj[0] = obj;
        aobj[1] = Long.valueOf(l5 / 1000L);
        aobj[2] = Long.valueOf(l4 / 1000L);
        aobj[3] = Long.valueOf(l6 / 1000L);
        aobj[4] = Long.valueOf(l7 / 1000L);
        dumpLine(printwriter, 0, s, "bt", aobj);
        l13 = 0L;
        l14 = 0L;
        l15 = 0L;
        l16 = 0L;
label0:
        for(int i1 = 0; i1 < k; i1++) {
            Uid uid1 = (Uid)sparsearray.valueAt(i1);
            l13 += uid1.getTcpBytesReceived(i);
            l14 += uid1.getTcpBytesSent(i);
            Map map5 = uid1.getWakelockStats();
            if(map5.size() <= 0)
                continue;
            Iterator iterator6 = map5.entrySet().iterator();
            do {
                Timer timer2;
                do {
                    if(!iterator6.hasNext())
                        continue label0;
                    Uid.Wakelock wakelock1 = (Uid.Wakelock)((java.util.Map.Entry)iterator6.next()).getValue();
                    Timer timer1 = wakelock1.getWakeTime(1);
                    if(timer1 != null)
                        l15 += timer1.getTotalTimeLocked(l3, i);
                    timer2 = wakelock1.getWakeTime(0);
                } while(timer2 == null);
                l16 += timer2.getTotalTimeLocked(l3, i);
            } while(true);
        }

        Object aobj1[] = new Object[10];
        aobj1[0] = Long.valueOf(l8 / 1000L);
        aobj1[1] = Long.valueOf(l9 / 1000L);
        aobj1[2] = Long.valueOf(l10 / 1000L);
        aobj1[3] = Long.valueOf(l11 / 1000L);
        aobj1[4] = Long.valueOf(l12 / 1000L);
        aobj1[5] = Long.valueOf(l13);
        aobj1[6] = Long.valueOf(l14);
        aobj1[7] = Long.valueOf(l15);
        aobj1[8] = Long.valueOf(l16);
        aobj1[9] = Integer.valueOf(getInputEventCount(i));
        dumpLine(printwriter, 0, s, "m", aobj1);
        Object aobj2[] = new Object[5];
        for(int j1 = 0; j1 < 5; j1++)
            aobj2[j1] = Long.valueOf(getScreenBrightnessTime(j1, l3, i) / 1000L);

        dumpLine(printwriter, 0, s, "br", aobj2);
        Object aobj3[] = new Object[5];
        for(int k1 = 0; k1 < 5; k1++)
            aobj3[k1] = Long.valueOf(getPhoneSignalStrengthTime(k1, l3, i) / 1000L);

        dumpLine(printwriter, 0, s, "sgt", aobj3);
        Object aobj4[] = new Object[1];
        aobj4[0] = Long.valueOf(getPhoneSignalScanningTime(l3, i) / 1000L);
        dumpLine(printwriter, 0, s, "sst", aobj4);
        for(int i2 = 0; i2 < 5; i2++)
            aobj3[i2] = Integer.valueOf(getPhoneSignalStrengthCount(i2, i));

        dumpLine(printwriter, 0, s, "sgc", aobj3);
        Object aobj5[] = new Object[16];
        for(int j2 = 0; j2 < 16; j2++)
            aobj5[j2] = Long.valueOf(getPhoneDataConnectionTime(j2, l3, i) / 1000L);

        dumpLine(printwriter, 0, s, "dct", aobj5);
        for(int k2 = 0; k2 < 16; k2++)
            aobj5[k2] = Integer.valueOf(getPhoneDataConnectionCount(k2, i));

        dumpLine(printwriter, 0, s, "dcc", aobj5);
        if(i == 3) {
            Object aobj16[] = new Object[2];
            aobj16[0] = Integer.valueOf(getDischargeStartLevel());
            aobj16[1] = Integer.valueOf(getDischargeCurrentLevel());
            dumpLine(printwriter, 0, s, "lv", aobj16);
        }
        if(i == 3) {
            Object aobj15[] = new Object[4];
            aobj15[0] = Integer.valueOf(getDischargeStartLevel() - getDischargeCurrentLevel());
            aobj15[1] = Integer.valueOf(getDischargeStartLevel() - getDischargeCurrentLevel());
            aobj15[2] = Integer.valueOf(getDischargeAmountScreenOn());
            aobj15[3] = Integer.valueOf(getDischargeAmountScreenOff());
            dumpLine(printwriter, 0, s, "dc", aobj15);
        } else {
            Object aobj6[] = new Object[4];
            aobj6[0] = Integer.valueOf(getLowDischargeAmountSinceCharge());
            aobj6[1] = Integer.valueOf(getHighDischargeAmountSinceCharge());
            aobj6[2] = Integer.valueOf(getDischargeAmountScreenOn());
            aobj6[3] = Integer.valueOf(getDischargeAmountScreenOff());
            dumpLine(printwriter, 0, s, "dc", aobj6);
        }
        if(j < 0) {
            Map map4 = getKernelWakelockStats();
            if(map4.size() > 0) {
                Object aobj14[];
                for(Iterator iterator5 = map4.entrySet().iterator(); iterator5.hasNext(); dumpLine(printwriter, 0, s, "kwl", aobj14)) {
                    java.util.Map.Entry entry5 = (java.util.Map.Entry)iterator5.next();
                    stringbuilder.setLength(0);
                    printWakeLockCheckin(stringbuilder, (Timer)entry5.getValue(), l3, null, i, "");
                    aobj14 = new Object[2];
                    aobj14[0] = entry5.getKey();
                    aobj14[1] = stringbuilder.toString();
                }

            }
        }
        int i3 = 0;
        while(i3 < k)  {
            int j3 = sparsearray.keyAt(i3);
            if(j < 0 || j3 == j) {
                Uid uid = (Uid)sparsearray.valueAt(i3);
                long l17 = uid.getTcpBytesReceived(i);
                long l18 = uid.getTcpBytesSent(i);
                long l19 = uid.getFullWifiLockTime(l3, i);
                long l20 = uid.getScanWifiLockTime(l3, i);
                long l21 = uid.getWifiRunningTime(l3, i);
                if(l17 > 0L || l18 > 0L) {
                    Object aobj7[] = new Object[2];
                    aobj7[0] = Long.valueOf(l17);
                    aobj7[1] = Long.valueOf(l18);
                    dumpLine(printwriter, j3, s, "nt", aobj7);
                }
                if(l19 != 0L || l20 != 0L || l21 != 0L) {
                    Object aobj8[] = new Object[3];
                    aobj8[0] = Long.valueOf(l19);
                    aobj8[1] = Long.valueOf(l20);
                    aobj8[2] = Long.valueOf(l21);
                    dumpLine(printwriter, j3, s, "wfl", aobj8);
                }
                if(uid.hasUserActivity()) {
                    Object aobj13[] = new Object[7];
                    boolean flag = false;
                    for(int k5 = 0; k5 < 7; k5++) {
                        int i6 = uid.getUserActivityCount(k5, i);
                        aobj13[k5] = Integer.valueOf(i6);
                        if(i6 != 0)
                            flag = true;
                    }

                    if(flag)
                        dumpLine(printwriter, 0, s, "ua", aobj13);
                }
                Map map = uid.getWakelockStats();
                if(map.size() > 0) {
                    Iterator iterator4 = map.entrySet().iterator();
                    do {
                        if(!iterator4.hasNext())
                            break;
                        java.util.Map.Entry entry4 = (java.util.Map.Entry)iterator4.next();
                        Uid.Wakelock wakelock = (Uid.Wakelock)entry4.getValue();
                        stringbuilder.setLength(0);
                        String s1 = printWakeLockCheckin(stringbuilder, wakelock.getWakeTime(1), l3, "f", i, "");
                        String s2 = printWakeLockCheckin(stringbuilder, wakelock.getWakeTime(0), l3, "p", i, s1);
                        printWakeLockCheckin(stringbuilder, wakelock.getWakeTime(2), l3, "w", i, s2);
                        if(stringbuilder.length() > 0) {
                            Object aobj12[] = new Object[2];
                            aobj12[0] = entry4.getKey();
                            aobj12[1] = stringbuilder.toString();
                            dumpLine(printwriter, j3, s, "wl", aobj12);
                        }
                    } while(true);
                }
                Map map1 = uid.getSensorStats();
                if(map1.size() > 0) {
                    Iterator iterator3 = map1.entrySet().iterator();
                    do {
                        if(!iterator3.hasNext())
                            break;
                        java.util.Map.Entry entry3 = (java.util.Map.Entry)iterator3.next();
                        Uid.Sensor sensor = (Uid.Sensor)entry3.getValue();
                        int i5 = ((Integer)entry3.getKey()).intValue();
                        Timer timer = sensor.getSensorTime();
                        if(timer != null) {
                            long l25 = (500L + timer.getTotalTimeLocked(l3, i)) / 1000L;
                            int j5 = timer.getCountLocked(i);
                            if(l25 != 0L) {
                                Object aobj11[] = new Object[3];
                                aobj11[0] = Integer.valueOf(i5);
                                aobj11[1] = Long.valueOf(l25);
                                aobj11[2] = Integer.valueOf(j5);
                                dumpLine(printwriter, j3, s, "sr", aobj11);
                            }
                        }
                    } while(true);
                }
                Map map2 = uid.getProcessStats();
                if(map2.size() > 0) {
                    Iterator iterator2 = map2.entrySet().iterator();
                    do {
                        if(!iterator2.hasNext())
                            break;
                        java.util.Map.Entry entry2 = (java.util.Map.Entry)iterator2.next();
                        Uid.Proc proc = (Uid.Proc)entry2.getValue();
                        long l23 = proc.getUserTime(i);
                        long l24 = proc.getSystemTime(i);
                        int k4 = proc.getStarts(i);
                        if(l23 != 0L || l24 != 0L || k4 != 0) {
                            Object aobj10[] = new Object[4];
                            aobj10[0] = entry2.getKey();
                            aobj10[1] = Long.valueOf(10L * l23);
                            aobj10[2] = Long.valueOf(10L * l24);
                            aobj10[3] = Integer.valueOf(k4);
                            dumpLine(printwriter, j3, s, "pr", aobj10);
                        }
                    } while(true);
                }
                Map map3 = uid.getPackageStats();
                if(map3.size() > 0) {
                    Iterator iterator = map3.entrySet().iterator();
                    while(iterator.hasNext())  {
                        java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                        Uid.Pkg pkg = (Uid.Pkg)entry.getValue();
                        int k3 = pkg.getWakeups(i);
                        Iterator iterator1 = pkg.getServiceStats().entrySet().iterator();
                        while(iterator1.hasNext())  {
                            java.util.Map.Entry entry1 = (java.util.Map.Entry)iterator1.next();
                            Uid.Pkg.Serv serv = (Uid.Pkg.Serv)entry1.getValue();
                            long l22 = serv.getStartTime(l2, i);
                            int i4 = serv.getStarts(i);
                            int j4 = serv.getLaunches(i);
                            if(l22 != 0L || i4 != 0 || j4 != 0) {
                                Object aobj9[] = new Object[6];
                                aobj9[0] = Integer.valueOf(k3);
                                aobj9[1] = entry.getKey();
                                aobj9[2] = entry1.getKey();
                                aobj9[3] = Long.valueOf(l22 / 1000L);
                                aobj9[4] = Integer.valueOf(i4);
                                aobj9[5] = Integer.valueOf(j4);
                                dumpLine(printwriter, j3, s, "apk", aobj9);
                            }
                        }
                    }
                }
            }
            i3++;
        }
    }

    public void dumpCheckinLocked(PrintWriter printwriter, String as[], List list) {
        prepareForDumpLocked();
        boolean flag = false;
        int i = as.length;
        for(int j = 0; j < i; j++)
            if("-u".equals(as[j]))
                flag = true;

        if(list != null) {
            SparseArray sparsearray = new SparseArray();
            for(int k = 0; k < list.size(); k++) {
                ApplicationInfo applicationinfo = (ApplicationInfo)list.get(k);
                ArrayList arraylist1 = (ArrayList)sparsearray.get(applicationinfo.uid);
                if(arraylist1 == null) {
                    arraylist1 = new ArrayList();
                    sparsearray.put(applicationinfo.uid, arraylist1);
                }
                arraylist1.add(((PackageItemInfo) (applicationinfo)).packageName);
            }

            SparseArray sparsearray1 = getUidStats();
            int l = sparsearray1.size();
            String as1[] = new String[2];
            for(int i1 = 0; i1 < l; i1++) {
                int j1 = sparsearray1.keyAt(i1);
                ArrayList arraylist = (ArrayList)sparsearray.get(j1);
                if(arraylist == null)
                    continue;
                for(int k1 = 0; k1 < arraylist.size(); k1++) {
                    as1[0] = Integer.toString(j1);
                    as1[1] = (String)arraylist.get(k1);
                    dumpLine(printwriter, 0, "i", "uid", (Object[])as1);
                }

            }

        }
        if(flag) {
            dumpCheckinLocked(printwriter, 3, -1);
        } else {
            dumpCheckinLocked(printwriter, 0, -1);
            dumpCheckinLocked(printwriter, 3, -1);
        }
    }

    public void dumpLocked(PrintWriter printwriter) {
        prepareForDumpLocked();
        long l = getHistoryBaseTime() + SystemClock.elapsedRealtime();
        HistoryItem historyitem = new HistoryItem();
        if(startIteratingHistoryLocked()) {
            printwriter.println("Battery History:");
            HistoryPrinter historyprinter1 = new HistoryPrinter();
            for(; getNextHistoryLocked(historyitem); historyprinter1.printNextItem(printwriter, historyitem, l));
            finishIteratingHistoryLocked();
            printwriter.println("");
        }
        if(startIteratingOldHistoryLocked()) {
            printwriter.println("Old battery History:");
            HistoryPrinter historyprinter = new HistoryPrinter();
            for(; getNextOldHistoryLocked(historyitem); historyprinter.printNextItem(printwriter, historyitem, l));
            finishIteratingOldHistoryLocked();
            printwriter.println("");
        }
        SparseArray sparsearray = getUidStats();
        int i = sparsearray.size();
        boolean flag = false;
        long l1 = SystemClock.elapsedRealtime();
label0:
        for(int j = 0; j < i; j++) {
            SparseArray sparsearray1 = ((Uid)sparsearray.valueAt(j)).getPidStats();
            if(sparsearray1 == null)
                continue;
            int k = 0;
            do {
                if(k >= sparsearray1.size())
                    continue label0;
                Uid.Pid pid = (Uid.Pid)sparsearray1.valueAt(k);
                if(!flag) {
                    printwriter.println("Per-PID Stats:");
                    flag = true;
                }
                long l2 = pid.mWakeSum;
                long l3;
                long l4;
                if(pid.mWakeStart != 0L)
                    l3 = l1 - pid.mWakeStart;
                else
                    l3 = 0L;
                l4 = l2 + l3;
                printwriter.print("  PID ");
                printwriter.print(sparsearray1.keyAt(k));
                printwriter.print(" wake time: ");
                TimeUtils.formatDuration(l4, printwriter);
                printwriter.println("");
                k++;
            } while(true);
        }

        if(flag)
            printwriter.println("");
        printwriter.println("Statistics since last charge:");
        printwriter.println((new StringBuilder()).append("  System starts: ").append(getStartCount()).append(", currently on battery: ").append(getIsOnBattery()).toString());
        dumpLocked(printwriter, "", 0, -1);
        printwriter.println("");
        printwriter.println("Statistics since last unplugged:");
        dumpLocked(printwriter, "", 3, -1);
    }

    public final void dumpLocked(PrintWriter printwriter, String s, int i, int j) {
        long l = 1000L * SystemClock.uptimeMillis();
        long l1 = 1000L * SystemClock.elapsedRealtime();
        long l2 = getBatteryUptime(l);
        long l3 = getBatteryRealtime(l1);
        long l4 = computeBatteryUptime(l, i);
        long l5 = computeBatteryRealtime(l1, i);
        long l6 = computeRealtime(l1, i);
        long l7 = computeUptime(l, i);
        StringBuilder stringbuilder = new StringBuilder(128);
        SparseArray sparsearray = getUidStats();
        int k = sparsearray.size();
        stringbuilder.setLength(0);
        stringbuilder.append(s);
        stringbuilder.append("  Time on battery: ");
        formatTimeMs(stringbuilder, l5 / 1000L);
        stringbuilder.append("(");
        stringbuilder.append(formatRatioLocked(l5, l6));
        stringbuilder.append(") realtime, ");
        formatTimeMs(stringbuilder, l4 / 1000L);
        stringbuilder.append("(");
        stringbuilder.append(formatRatioLocked(l4, l6));
        stringbuilder.append(") uptime");
        printwriter.println(stringbuilder.toString());
        stringbuilder.setLength(0);
        stringbuilder.append(s);
        stringbuilder.append("  Total run time: ");
        formatTimeMs(stringbuilder, l6 / 1000L);
        stringbuilder.append("realtime, ");
        formatTimeMs(stringbuilder, l7 / 1000L);
        stringbuilder.append("uptime, ");
        printwriter.println(stringbuilder.toString());
        long l8 = getScreenOnTime(l3, i);
        long l9 = getPhoneOnTime(l3, i);
        long l10 = getGlobalWifiRunningTime(l3, i);
        long l11 = getWifiOnTime(l3, i);
        long l12 = getBluetoothOnTime(l3, i);
        stringbuilder.setLength(0);
        stringbuilder.append(s);
        stringbuilder.append("  Screen on: ");
        formatTimeMs(stringbuilder, l8 / 1000L);
        stringbuilder.append("(");
        stringbuilder.append(formatRatioLocked(l8, l5));
        stringbuilder.append("), Input events: ");
        stringbuilder.append(getInputEventCount(i));
        stringbuilder.append(", Active phone call: ");
        formatTimeMs(stringbuilder, l9 / 1000L);
        stringbuilder.append("(");
        stringbuilder.append(formatRatioLocked(l9, l5));
        stringbuilder.append(")");
        printwriter.println(stringbuilder.toString());
        stringbuilder.setLength(0);
        stringbuilder.append(s);
        stringbuilder.append("  Screen brightnesses: ");
        boolean flag = false;
        int i1 = 0;
        while(i1 < 5)  {
            long l31 = getScreenBrightnessTime(i1, l3, i);
            if(l31 != 0L) {
                if(flag)
                    stringbuilder.append(", ");
                flag = true;
                stringbuilder.append(SCREEN_BRIGHTNESS_NAMES[i1]);
                stringbuilder.append(" ");
                formatTimeMs(stringbuilder, l31 / 1000L);
                stringbuilder.append("(");
                stringbuilder.append(formatRatioLocked(l31, l8));
                stringbuilder.append(")");
            }
            i1++;
        }
        if(!flag)
            stringbuilder.append("No activity");
        printwriter.println(stringbuilder.toString());
        long l13 = 0L;
        long l14 = 0L;
        long l15 = 0L;
        long l16 = 0L;
        if(j < 0) {
            Map map6 = getKernelWakelockStats();
            if(map6.size() > 0) {
                Iterator iterator6 = map6.entrySet().iterator();
                do {
                    if(!iterator6.hasNext())
                        break;
                    java.util.Map.Entry entry5 = (java.util.Map.Entry)iterator6.next();
                    stringbuilder.setLength(0);
                    stringbuilder.append(s);
                    stringbuilder.append("  Kernel Wake lock ");
                    stringbuilder.append((String)entry5.getKey());
                    if(!printWakeLock(stringbuilder, (Timer)entry5.getValue(), l3, null, i, ": ").equals(": ")) {
                        stringbuilder.append(" realtime");
                        printwriter.println(stringbuilder.toString());
                    }
                } while(true);
            }
        }
label0:
        for(int j1 = 0; j1 < k; j1++) {
            Uid uid1 = (Uid)sparsearray.valueAt(j1);
            l13 += uid1.getTcpBytesReceived(i);
            l14 += uid1.getTcpBytesSent(i);
            Map map5 = uid1.getWakelockStats();
            if(map5.size() <= 0)
                continue;
            Iterator iterator5 = map5.entrySet().iterator();
            do {
                Timer timer2;
                do {
                    if(!iterator5.hasNext())
                        continue label0;
                    Uid.Wakelock wakelock1 = (Uid.Wakelock)((java.util.Map.Entry)iterator5.next()).getValue();
                    Timer timer1 = wakelock1.getWakeTime(1);
                    if(timer1 != null)
                        l15 += timer1.getTotalTimeLocked(l3, i);
                    timer2 = wakelock1.getWakeTime(0);
                } while(timer2 == null);
                l16 += timer2.getTotalTimeLocked(l3, i);
            } while(true);
        }

        printwriter.print(s);
        printwriter.print("  Total received: ");
        printwriter.print(formatBytesLocked(l13));
        printwriter.print(", Total sent: ");
        printwriter.println(formatBytesLocked(l14));
        stringbuilder.setLength(0);
        stringbuilder.append(s);
        stringbuilder.append("  Total full wakelock time: ");
        formatTimeMs(stringbuilder, (500L + l15) / 1000L);
        stringbuilder.append(", Total partial waklock time: ");
        formatTimeMs(stringbuilder, (500L + l16) / 1000L);
        printwriter.println(stringbuilder.toString());
        stringbuilder.setLength(0);
        stringbuilder.append(s);
        stringbuilder.append("  Signal levels: ");
        boolean flag1 = false;
        int k1 = 0;
        while(k1 < 5)  {
            long l30 = getPhoneSignalStrengthTime(k1, l3, i);
            if(l30 != 0L) {
                if(flag1)
                    stringbuilder.append(", ");
                flag1 = true;
                stringbuilder.append(SignalStrength.SIGNAL_STRENGTH_NAMES[k1]);
                stringbuilder.append(" ");
                formatTimeMs(stringbuilder, l30 / 1000L);
                stringbuilder.append("(");
                stringbuilder.append(formatRatioLocked(l30, l5));
                stringbuilder.append(") ");
                stringbuilder.append(getPhoneSignalStrengthCount(k1, i));
                stringbuilder.append("x");
            }
            k1++;
        }
        if(!flag1)
            stringbuilder.append("No activity");
        printwriter.println(stringbuilder.toString());
        stringbuilder.setLength(0);
        stringbuilder.append(s);
        stringbuilder.append("  Signal scanning time: ");
        formatTimeMs(stringbuilder, getPhoneSignalScanningTime(l3, i) / 1000L);
        printwriter.println(stringbuilder.toString());
        stringbuilder.setLength(0);
        stringbuilder.append(s);
        stringbuilder.append("  Radio types: ");
        boolean flag2 = false;
        int i2 = 0;
        while(i2 < 16)  {
            long l29 = getPhoneDataConnectionTime(i2, l3, i);
            if(l29 != 0L) {
                if(flag2)
                    stringbuilder.append(", ");
                flag2 = true;
                stringbuilder.append(DATA_CONNECTION_NAMES[i2]);
                stringbuilder.append(" ");
                formatTimeMs(stringbuilder, l29 / 1000L);
                stringbuilder.append("(");
                stringbuilder.append(formatRatioLocked(l29, l5));
                stringbuilder.append(") ");
                stringbuilder.append(getPhoneDataConnectionCount(i2, i));
                stringbuilder.append("x");
            }
            i2++;
        }
        if(!flag2)
            stringbuilder.append("No activity");
        printwriter.println(stringbuilder.toString());
        stringbuilder.setLength(0);
        stringbuilder.append(s);
        stringbuilder.append("  Radio data uptime when unplugged: ");
        stringbuilder.append(getRadioDataUptime() / 1000L);
        stringbuilder.append(" ms");
        printwriter.println(stringbuilder.toString());
        stringbuilder.setLength(0);
        stringbuilder.append(s);
        stringbuilder.append("  Wifi on: ");
        formatTimeMs(stringbuilder, l11 / 1000L);
        stringbuilder.append("(");
        stringbuilder.append(formatRatioLocked(l11, l5));
        stringbuilder.append("), Wifi running: ");
        formatTimeMs(stringbuilder, l10 / 1000L);
        stringbuilder.append("(");
        stringbuilder.append(formatRatioLocked(l10, l5));
        stringbuilder.append("), Bluetooth on: ");
        formatTimeMs(stringbuilder, l12 / 1000L);
        stringbuilder.append("(");
        stringbuilder.append(formatRatioLocked(l12, l5));
        stringbuilder.append(")");
        printwriter.println(stringbuilder.toString());
        printwriter.println(" ");
        int j2;
        if(i == 3) {
            if(getIsOnBattery()) {
                printwriter.print(s);
                printwriter.println("  Device is currently unplugged");
                printwriter.print(s);
                printwriter.print("    Discharge cycle start level: ");
                printwriter.println(getDischargeStartLevel());
                printwriter.print(s);
                printwriter.print("    Discharge cycle current level: ");
                printwriter.println(getDischargeCurrentLevel());
            } else {
                printwriter.print(s);
                printwriter.println("  Device is currently plugged into power");
                printwriter.print(s);
                printwriter.print("    Last discharge cycle start level: ");
                printwriter.println(getDischargeStartLevel());
                printwriter.print(s);
                printwriter.print("    Last discharge cycle end level: ");
                printwriter.println(getDischargeCurrentLevel());
            }
            printwriter.print(s);
            printwriter.print("    Amount discharged while screen on: ");
            printwriter.println(getDischargeAmountScreenOn());
            printwriter.print(s);
            printwriter.print("    Amount discharged while screen off: ");
            printwriter.println(getDischargeAmountScreenOff());
            printwriter.println(" ");
        } else {
            printwriter.print(s);
            printwriter.println("  Device battery use since last full charge");
            printwriter.print(s);
            printwriter.print("    Amount discharged (lower bound): ");
            printwriter.println(getLowDischargeAmountSinceCharge());
            printwriter.print(s);
            printwriter.print("    Amount discharged (upper bound): ");
            printwriter.println(getHighDischargeAmountSinceCharge());
            printwriter.print(s);
            printwriter.print("    Amount discharged while screen on: ");
            printwriter.println(getDischargeAmountScreenOnSinceCharge());
            printwriter.print(s);
            printwriter.print("    Amount discharged while screen off: ");
            printwriter.println(getDischargeAmountScreenOffSinceCharge());
            printwriter.println(" ");
        }
        j2 = 0;
        while(j2 < k)  {
            int k2 = sparsearray.keyAt(j2);
            if(j < 0 || k2 == j || k2 == 1000) {
                Uid uid = (Uid)sparsearray.valueAt(j2);
                printwriter.println((new StringBuilder()).append(s).append("  #").append(k2).append(":").toString());
                boolean flag3 = false;
                long l17 = uid.getTcpBytesReceived(i);
                long l18 = uid.getTcpBytesSent(i);
                long l19 = uid.getFullWifiLockTime(l3, i);
                long l20 = uid.getScanWifiLockTime(l3, i);
                long l21 = uid.getWifiRunningTime(l3, i);
                if(l17 != 0L || l18 != 0L) {
                    printwriter.print(s);
                    printwriter.print("    Network: ");
                    printwriter.print(formatBytesLocked(l17));
                    printwriter.print(" received, ");
                    printwriter.print(formatBytesLocked(l18));
                    printwriter.println(" sent");
                }
                if(uid.hasUserActivity()) {
                    boolean flag6 = false;
                    int i6 = 0;
                    while(i6 < 5)  {
                        int j6 = uid.getUserActivityCount(i6, i);
                        if(j6 != 0) {
                            if(!flag6) {
                                stringbuilder.setLength(0);
                                stringbuilder.append("    User activity: ");
                                flag6 = true;
                            } else {
                                stringbuilder.append(", ");
                            }
                            stringbuilder.append(j6);
                            stringbuilder.append(" ");
                            stringbuilder.append(Uid.USER_ACTIVITY_TYPES[i6]);
                        }
                        i6++;
                    }
                    if(flag6)
                        printwriter.println(stringbuilder.toString());
                }
                if(l19 != 0L || l20 != 0L || l21 != 0L) {
                    stringbuilder.setLength(0);
                    stringbuilder.append(s);
                    stringbuilder.append("    Wifi Running: ");
                    formatTimeMs(stringbuilder, l21 / 1000L);
                    stringbuilder.append("(");
                    stringbuilder.append(formatRatioLocked(l21, l5));
                    stringbuilder.append(")\n");
                    stringbuilder.append(s);
                    stringbuilder.append("    Full Wifi Lock: ");
                    formatTimeMs(stringbuilder, l19 / 1000L);
                    stringbuilder.append("(");
                    stringbuilder.append(formatRatioLocked(l19, l5));
                    stringbuilder.append(")\n");
                    stringbuilder.append(s);
                    stringbuilder.append("    Scan Wifi Lock: ");
                    formatTimeMs(stringbuilder, l20 / 1000L);
                    stringbuilder.append("(");
                    stringbuilder.append(formatRatioLocked(l20, l5));
                    stringbuilder.append(")");
                    printwriter.println(stringbuilder.toString());
                }
                Map map = uid.getWakelockStats();
                if(map.size() > 0) {
                    long l26 = 0L;
                    long l27 = 0L;
                    long l28 = 0L;
                    int k5 = 0;
                    for(Iterator iterator4 = map.entrySet().iterator(); iterator4.hasNext();) {
                        java.util.Map.Entry entry4 = (java.util.Map.Entry)iterator4.next();
                        Uid.Wakelock wakelock = (Uid.Wakelock)entry4.getValue();
                        stringbuilder.setLength(0);
                        stringbuilder.append(s);
                        stringbuilder.append("    Wake lock ");
                        stringbuilder.append((String)entry4.getKey());
                        String s1 = printWakeLock(stringbuilder, wakelock.getWakeTime(1), l3, "full", i, ": ");
                        String s2 = printWakeLock(stringbuilder, wakelock.getWakeTime(0), l3, "partial", i, s1);
                        if(!printWakeLock(stringbuilder, wakelock.getWakeTime(2), l3, "window", i, s2).equals(": ")) {
                            stringbuilder.append(" realtime");
                            printwriter.println(stringbuilder.toString());
                            flag3 = true;
                            k5++;
                        }
                        l26 += computeWakeLock(wakelock.getWakeTime(1), l3, i);
                        l27 += computeWakeLock(wakelock.getWakeTime(0), l3, i);
                        l28 += computeWakeLock(wakelock.getWakeTime(2), l3, i);
                    }

                    if(k5 > 1 && (l26 != 0L || l27 != 0L || l28 != 0L)) {
                        stringbuilder.setLength(0);
                        stringbuilder.append(s);
                        stringbuilder.append("    TOTAL wake: ");
                        boolean flag5 = false;
                        if(l26 != 0L) {
                            flag5 = true;
                            formatTimeMs(stringbuilder, l26);
                            stringbuilder.append("full");
                        }
                        if(l27 != 0L) {
                            if(flag5)
                                stringbuilder.append(", ");
                            flag5 = true;
                            formatTimeMs(stringbuilder, l27);
                            stringbuilder.append("partial");
                        }
                        if(l28 != 0L) {
                            if(flag5)
                                stringbuilder.append(", ");
                            formatTimeMs(stringbuilder, l28);
                            stringbuilder.append("window");
                        }
                        stringbuilder.append(" realtime");
                        printwriter.println(stringbuilder.toString());
                    }
                }
                Map map1 = uid.getSensorStats();
                if(map1.size() > 0) {
                    Iterator iterator3 = map1.entrySet().iterator();
                    while(iterator3.hasNext())  {
                        java.util.Map.Entry entry3 = (java.util.Map.Entry)iterator3.next();
                        Uid.Sensor sensor = (Uid.Sensor)entry3.getValue();
                        ((Integer)entry3.getKey()).intValue();
                        stringbuilder.setLength(0);
                        stringbuilder.append(s);
                        stringbuilder.append("    Sensor ");
                        int i5 = sensor.getHandle();
                        Timer timer;
                        if(i5 == -10000)
                            stringbuilder.append("GPS");
                        else
                            stringbuilder.append(i5);
                        stringbuilder.append(": ");
                        timer = sensor.getSensorTime();
                        if(timer != null) {
                            long l25 = (500L + timer.getTotalTimeLocked(l3, i)) / 1000L;
                            int j5 = timer.getCountLocked(i);
                            if(l25 != 0L) {
                                formatTimeMs(stringbuilder, l25);
                                stringbuilder.append("realtime (");
                                stringbuilder.append(j5);
                                stringbuilder.append(" times)");
                            } else {
                                stringbuilder.append("(not used)");
                            }
                        } else {
                            stringbuilder.append("(not used)");
                        }
                        printwriter.println(stringbuilder.toString());
                        flag3 = true;
                    }
                }
                Map map2 = uid.getProcessStats();
                if(map2.size() > 0) {
                    Iterator iterator2 = map2.entrySet().iterator();
                    do {
                        if(!iterator2.hasNext())
                            break;
                        java.util.Map.Entry entry2 = (java.util.Map.Entry)iterator2.next();
                        Uid.Proc proc = (Uid.Proc)entry2.getValue();
                        long l23 = proc.getUserTime(i);
                        long l24 = proc.getSystemTime(i);
                        int i4 = proc.getStarts(i);
                        int j4;
                        if(i == 0)
                            j4 = proc.countExcessivePowers();
                        else
                            j4 = 0;
                        if(l23 != 0L || l24 != 0L || i4 != 0 || j4 != 0) {
                            stringbuilder.setLength(0);
                            stringbuilder.append(s);
                            stringbuilder.append("    Proc ");
                            stringbuilder.append((String)entry2.getKey());
                            stringbuilder.append(":\n");
                            stringbuilder.append(s);
                            stringbuilder.append("      CPU: ");
                            formatTime(stringbuilder, l23);
                            stringbuilder.append("usr + ");
                            formatTime(stringbuilder, l24);
                            stringbuilder.append("krn");
                            if(i4 != 0) {
                                stringbuilder.append("\n");
                                stringbuilder.append(s);
                                stringbuilder.append("      ");
                                stringbuilder.append(i4);
                                stringbuilder.append(" proc starts");
                            }
                            printwriter.println(stringbuilder.toString());
                            int k4 = 0;
                            while(k4 < j4)  {
                                Uid.Proc.ExcessivePower excessivepower = proc.getExcessivePower(k4);
                                if(excessivepower != null) {
                                    printwriter.print(s);
                                    printwriter.print("      * Killed for ");
                                    if(excessivepower.type == 1)
                                        printwriter.print("wake lock");
                                    else
                                    if(excessivepower.type == 2)
                                        printwriter.print("cpu");
                                    else
                                        printwriter.print("unknown");
                                    printwriter.print(" use: ");
                                    TimeUtils.formatDuration(excessivepower.usedTime, printwriter);
                                    printwriter.print(" over ");
                                    TimeUtils.formatDuration(excessivepower.overTime, printwriter);
                                    printwriter.print(" (");
                                    printwriter.print((100L * excessivepower.usedTime) / excessivepower.overTime);
                                    printwriter.println("%)");
                                }
                                k4++;
                            }
                            flag3 = true;
                        }
                    } while(true);
                }
                Map map3 = uid.getPackageStats();
                if(map3.size() > 0) {
                    for(Iterator iterator = map3.entrySet().iterator(); iterator.hasNext();) {
                        java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                        printwriter.print(s);
                        printwriter.print("    Apk ");
                        printwriter.print((String)entry.getKey());
                        printwriter.println(":");
                        boolean flag4 = false;
                        Uid.Pkg pkg = (Uid.Pkg)entry.getValue();
                        int i3 = pkg.getWakeups(i);
                        if(i3 != 0) {
                            printwriter.print(s);
                            printwriter.print("      ");
                            printwriter.print(i3);
                            printwriter.println(" wakeup alarms");
                            flag4 = true;
                        }
                        Map map4 = pkg.getServiceStats();
                        if(map4.size() > 0) {
                            Iterator iterator1 = map4.entrySet().iterator();
                            do {
                                if(!iterator1.hasNext())
                                    break;
                                java.util.Map.Entry entry1 = (java.util.Map.Entry)iterator1.next();
                                Uid.Pkg.Serv serv = (Uid.Pkg.Serv)entry1.getValue();
                                long l22 = serv.getStartTime(l2, i);
                                int j3 = serv.getStarts(i);
                                int k3 = serv.getLaunches(i);
                                if(l22 != 0L || j3 != 0 || k3 != 0) {
                                    stringbuilder.setLength(0);
                                    stringbuilder.append(s);
                                    stringbuilder.append("      Service ");
                                    stringbuilder.append((String)entry1.getKey());
                                    stringbuilder.append(":\n");
                                    stringbuilder.append(s);
                                    stringbuilder.append("        Created for: ");
                                    formatTimeMs(stringbuilder, l22 / 1000L);
                                    stringbuilder.append(" uptime\n");
                                    stringbuilder.append(s);
                                    stringbuilder.append("        Starts: ");
                                    stringbuilder.append(j3);
                                    stringbuilder.append(", launches: ");
                                    stringbuilder.append(k3);
                                    printwriter.println(stringbuilder.toString());
                                    flag4 = true;
                                }
                            } while(true);
                        }
                        if(!flag4) {
                            printwriter.print(s);
                            printwriter.println("      (nothing executed)");
                        }
                        flag3 = true;
                    }

                }
                if(!flag3) {
                    printwriter.print(s);
                    printwriter.println("    (nothing executed)");
                }
            }
            j2++;
        }
    }

    public abstract void finishIteratingHistoryLocked();

    public abstract void finishIteratingOldHistoryLocked();

    public abstract long getBatteryRealtime(long l);

    public abstract long getBatteryUptime(long l);

    public abstract long getBluetoothOnTime(long l, int i);

    public abstract int getCpuSpeedSteps();

    public abstract int getDischargeAmountScreenOff();

    public abstract int getDischargeAmountScreenOffSinceCharge();

    public abstract int getDischargeAmountScreenOn();

    public abstract int getDischargeAmountScreenOnSinceCharge();

    public abstract int getDischargeCurrentLevel();

    public abstract int getDischargeStartLevel();

    public abstract long getGlobalWifiRunningTime(long l, int i);

    public abstract int getHighDischargeAmountSinceCharge();

    public abstract long getHistoryBaseTime();

    public abstract int getInputEventCount(int i);

    public abstract boolean getIsOnBattery();

    public abstract Map getKernelWakelockStats();

    public abstract int getLowDischargeAmountSinceCharge();

    public abstract boolean getNextHistoryLocked(HistoryItem historyitem);

    public abstract boolean getNextOldHistoryLocked(HistoryItem historyitem);

    public abstract int getPhoneDataConnectionCount(int i, int j);

    public abstract long getPhoneDataConnectionTime(int i, long l, int j);

    public abstract long getPhoneOnTime(long l, int i);

    public abstract long getPhoneSignalScanningTime(long l, int i);

    public abstract int getPhoneSignalStrengthCount(int i, int j);

    public abstract long getPhoneSignalStrengthTime(int i, long l, int j);

    public abstract long getRadioDataUptime();

    public long getRadioDataUptimeMs() {
        return getRadioDataUptime() / 1000L;
    }

    public abstract long getScreenBrightnessTime(int i, long l, int j);

    public abstract long getScreenOnTime(long l, int i);

    public abstract int getStartCount();

    public abstract SparseArray getUidStats();

    public abstract long getWifiOnTime(long l, int i);

    public void prepareForDumpLocked() {
    }

    public abstract boolean startIteratingHistoryLocked();

    public abstract boolean startIteratingOldHistoryLocked();

    private static final String APK_DATA = "apk";
    public static final int AUDIO_TURNED_ON = 7;
    private static final String BATTERY_DATA = "bt";
    private static final String BATTERY_DISCHARGE_DATA = "dc";
    private static final String BATTERY_LEVEL_DATA = "lv";
    private static final int BATTERY_STATS_CHECKIN_VERSION = 5;
    private static final long BYTES_PER_GB = 0x40000000L;
    private static final long BYTES_PER_KB = 1024L;
    private static final long BYTES_PER_MB = 0x100000L;
    public static final int DATA_CONNECTION_1xRTT = 7;
    public static final int DATA_CONNECTION_CDMA = 4;
    private static final String DATA_CONNECTION_COUNT_DATA = "dcc";
    public static final int DATA_CONNECTION_EDGE = 2;
    public static final int DATA_CONNECTION_EHRPD = 14;
    public static final int DATA_CONNECTION_EVDO_0 = 5;
    public static final int DATA_CONNECTION_EVDO_A = 6;
    public static final int DATA_CONNECTION_EVDO_B = 12;
    public static final int DATA_CONNECTION_GPRS = 1;
    public static final int DATA_CONNECTION_HSDPA = 8;
    public static final int DATA_CONNECTION_HSPA = 10;
    public static final int DATA_CONNECTION_HSUPA = 9;
    public static final int DATA_CONNECTION_IDEN = 11;
    public static final int DATA_CONNECTION_LTE = 13;
    static final String DATA_CONNECTION_NAMES[];
    public static final int DATA_CONNECTION_NONE = 0;
    public static final int DATA_CONNECTION_OTHER = 15;
    private static final String DATA_CONNECTION_TIME_DATA = "dct";
    public static final int DATA_CONNECTION_UMTS = 3;
    public static final int FULL_WIFI_LOCK = 5;
    public static final BitDescription HISTORY_STATE_DESCRIPTIONS[];
    private static final String KERNEL_WAKELOCK_DATA = "kwl";
    private static final boolean LOCAL_LOGV = false;
    private static final String MISC_DATA = "m";
    private static final String NETWORK_DATA = "nt";
    public static final int NUM_DATA_CONNECTION_TYPES = 16;
    public static final int NUM_SCREEN_BRIGHTNESS_BINS = 5;
    private static final String PROCESS_DATA = "pr";
    public static final int SCAN_WIFI_LOCK = 6;
    public static final int SCREEN_BRIGHTNESS_BRIGHT = 4;
    public static final int SCREEN_BRIGHTNESS_DARK = 0;
    private static final String SCREEN_BRIGHTNESS_DATA = "br";
    public static final int SCREEN_BRIGHTNESS_DIM = 1;
    public static final int SCREEN_BRIGHTNESS_LIGHT = 3;
    public static final int SCREEN_BRIGHTNESS_MEDIUM = 2;
    static final String SCREEN_BRIGHTNESS_NAMES[];
    public static final int SENSOR = 3;
    private static final String SENSOR_DATA = "sr";
    private static final String SIGNAL_SCANNING_TIME_DATA = "sst";
    private static final String SIGNAL_STRENGTH_COUNT_DATA = "sgc";
    private static final String SIGNAL_STRENGTH_TIME_DATA = "sgt";
    public static final int STATS_CURRENT = 2;
    public static final int STATS_LAST = 1;
    public static final int STATS_SINCE_CHARGED = 0;
    public static final int STATS_SINCE_UNPLUGGED = 3;
    private static final String STAT_NAMES[];
    private static final String UID_DATA = "uid";
    private static final String USER_ACTIVITY_DATA = "ua";
    public static final int VIDEO_TURNED_ON = 8;
    private static final String WAKELOCK_DATA = "wl";
    public static final int WAKE_TYPE_FULL = 1;
    public static final int WAKE_TYPE_PARTIAL = 0;
    public static final int WAKE_TYPE_WINDOW = 2;
    private static final String WIFI_LOCK_DATA = "wfl";
    public static final int WIFI_MULTICAST_ENABLED = 7;
    public static final int WIFI_RUNNING = 4;
    private final StringBuilder mFormatBuilder = new StringBuilder(32);
    private final Formatter mFormatter;

    static  {
        String as[] = new String[4];
        as[0] = "t";
        as[1] = "l";
        as[2] = "c";
        as[3] = "u";
        STAT_NAMES = as;
        String as1[] = new String[5];
        as1[0] = "dark";
        as1[1] = "dim";
        as1[2] = "medium";
        as1[3] = "light";
        as1[4] = "bright";
        SCREEN_BRIGHTNESS_NAMES = as1;
        String as2[] = new String[16];
        as2[0] = "none";
        as2[1] = "gprs";
        as2[2] = "edge";
        as2[3] = "umts";
        as2[4] = "cdma";
        as2[5] = "evdo_0";
        as2[6] = "evdo_A";
        as2[7] = "1xrtt";
        as2[8] = "hsdpa";
        as2[9] = "hsupa";
        as2[10] = "hspa";
        as2[11] = "iden";
        as2[12] = "evdo_b";
        as2[13] = "lte";
        as2[14] = "ehrpd";
        as2[15] = "other";
        DATA_CONNECTION_NAMES = as2;
        BitDescription abitdescription[] = new BitDescription[19];
        abitdescription[0] = new BitDescription(0x80000, "plugged");
        abitdescription[1] = new BitDescription(0x100000, "screen");
        abitdescription[2] = new BitDescription(0x10000000, "gps");
        abitdescription[3] = new BitDescription(0x40000, "phone_in_call");
        abitdescription[4] = new BitDescription(0x8000000, "phone_scanning");
        abitdescription[5] = new BitDescription(0x20000, "wifi");
        abitdescription[6] = new BitDescription(0x4000000, "wifi_running");
        abitdescription[7] = new BitDescription(0x2000000, "wifi_full_lock");
        abitdescription[8] = new BitDescription(0x1000000, "wifi_scan_lock");
        abitdescription[9] = new BitDescription(0x800000, "wifi_multicast");
        abitdescription[10] = new BitDescription(0x10000, "bluetooth");
        abitdescription[11] = new BitDescription(0x400000, "audio");
        abitdescription[12] = new BitDescription(0x200000, "video");
        abitdescription[13] = new BitDescription(0x40000000, "wake_lock");
        abitdescription[14] = new BitDescription(0x20000000, "sensor");
        abitdescription[15] = new BitDescription(15, 0, "brightness", SCREEN_BRIGHTNESS_NAMES);
        abitdescription[16] = new BitDescription(240, 4, "signal_strength", SignalStrength.SIGNAL_STRENGTH_NAMES);
        String as3[] = new String[4];
        as3[0] = "in";
        as3[1] = "out";
        as3[2] = "emergency";
        as3[3] = "off";
        abitdescription[17] = new BitDescription(3840, 8, "phone_state", as3);
        abitdescription[18] = new BitDescription(61440, 12, "data_conn", DATA_CONNECTION_NAMES);
        HISTORY_STATE_DESCRIPTIONS = abitdescription;
    }
}
