// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.MathUtils;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.IndentingPrintWriter;
import java.io.*;
import java.net.ProtocolException;
import java.util.Arrays;
import java.util.Random;

// Referenced classes of package android.net:
//            NetworkStats

public class NetworkStatsHistory
    implements Parcelable {
    public static class ParcelUtils {

        public static long[] readLongArray(Parcel parcel) {
            int i = parcel.readInt();
            long al[];
            if(i == -1) {
                al = null;
            } else {
                al = new long[i];
                int j = 0;
                while(j < al.length)  {
                    al[j] = parcel.readLong();
                    j++;
                }
            }
            return al;
        }

        public static void writeLongArray(Parcel parcel, long al[], int i) {
            if(al == null) {
                parcel.writeInt(-1);
            } else {
                if(i > al.length)
                    throw new IllegalArgumentException("size larger than length");
                parcel.writeInt(i);
                int j = 0;
                while(j < i)  {
                    parcel.writeLong(al[j]);
                    j++;
                }
            }
        }

        public ParcelUtils() {
        }
    }

    public static class DataStreamUtils {

        public static long[] readFullLongArray(DataInputStream datainputstream) throws IOException {
            long al[] = new long[datainputstream.readInt()];
            for(int i = 0; i < al.length; i++)
                al[i] = datainputstream.readLong();

            return al;
        }

        public static long readVarLong(DataInputStream datainputstream) throws IOException {
            int i = 0;
            long l = 0L;
            for(; i < 64; i += 7) {
                byte byte0 = datainputstream.readByte();
                l |= (long)(byte0 & 0x7f) << i;
                if((byte0 & 0x80) == 0)
                    return l;
            }

            throw new ProtocolException("malformed long");
        }

        public static long[] readVarLongArray(DataInputStream datainputstream) throws IOException {
            int i = datainputstream.readInt();
            long al[];
            if(i == -1) {
                al = null;
            } else {
                al = new long[i];
                int j = 0;
                while(j < al.length)  {
                    al[j] = readVarLong(datainputstream);
                    j++;
                }
            }
            return al;
        }

        public static void writeVarLong(DataOutputStream dataoutputstream, long l) throws IOException {
            do {
                if((-128L & l) == 0L) {
                    dataoutputstream.writeByte((int)l);
                    return;
                }
                dataoutputstream.writeByte(0x80 | 0x7f & (int)l);
                l >>>= 7;
            } while(true);
        }

        public static void writeVarLongArray(DataOutputStream dataoutputstream, long al[], int i) throws IOException {
            if(al == null) {
                dataoutputstream.writeInt(-1);
            } else {
                if(i > al.length)
                    throw new IllegalArgumentException("size larger than length");
                dataoutputstream.writeInt(i);
                int j = 0;
                while(j < i)  {
                    writeVarLong(dataoutputstream, al[j]);
                    j++;
                }
            }
        }

        public DataStreamUtils() {
        }
    }

    public static class Entry {

        public static final long UNKNOWN = -1L;
        public long activeTime;
        public long bucketDuration;
        public long bucketStart;
        public long operations;
        public long rxBytes;
        public long rxPackets;
        public long txBytes;
        public long txPackets;

        public Entry() {
        }
    }


    public NetworkStatsHistory(long l) {
        this(l, 10, -1);
    }

    public NetworkStatsHistory(long l, int i) {
        this(l, i, -1);
    }

    public NetworkStatsHistory(long l, int i, int j) {
        bucketDuration = l;
        bucketStart = new long[i];
        if((j & 1) != 0)
            activeTime = new long[i];
        if((j & 2) != 0)
            rxBytes = new long[i];
        if((j & 4) != 0)
            rxPackets = new long[i];
        if((j & 8) != 0)
            txBytes = new long[i];
        if((j & 0x10) != 0)
            txPackets = new long[i];
        if((j & 0x20) != 0)
            operations = new long[i];
        bucketCount = 0;
        totalBytes = 0L;
    }

    public NetworkStatsHistory(NetworkStatsHistory networkstatshistory, long l) {
        this(l, networkstatshistory.estimateResizeBuckets(l));
        recordEntireHistory(networkstatshistory);
    }

    public NetworkStatsHistory(Parcel parcel) {
        bucketDuration = parcel.readLong();
        bucketStart = ParcelUtils.readLongArray(parcel);
        activeTime = ParcelUtils.readLongArray(parcel);
        rxBytes = ParcelUtils.readLongArray(parcel);
        rxPackets = ParcelUtils.readLongArray(parcel);
        txBytes = ParcelUtils.readLongArray(parcel);
        txPackets = ParcelUtils.readLongArray(parcel);
        operations = ParcelUtils.readLongArray(parcel);
        bucketCount = bucketStart.length;
        totalBytes = parcel.readLong();
    }

    public NetworkStatsHistory(DataInputStream datainputstream) throws IOException {
        int i;
        i = datainputstream.readInt();
        i;
        JVM INSTR tableswitch 1 3: default 36
    //                   1 63
    //                   2 157
    //                   3 157;
           goto _L1 _L2 _L3 _L3
_L1:
        throw new ProtocolException((new StringBuilder()).append("unexpected version: ").append(i).toString());
_L2:
        bucketDuration = datainputstream.readLong();
        bucketStart = DataStreamUtils.readFullLongArray(datainputstream);
        rxBytes = DataStreamUtils.readFullLongArray(datainputstream);
        rxPackets = new long[bucketStart.length];
        txBytes = DataStreamUtils.readFullLongArray(datainputstream);
        txPackets = new long[bucketStart.length];
        operations = new long[bucketStart.length];
        bucketCount = bucketStart.length;
        totalBytes = ArrayUtils.total(rxBytes) + ArrayUtils.total(txBytes);
_L5:
        return;
_L3:
        bucketDuration = datainputstream.readLong();
        bucketStart = DataStreamUtils.readVarLongArray(datainputstream);
        long al[];
        if(i >= 3)
            al = DataStreamUtils.readVarLongArray(datainputstream);
        else
            al = new long[bucketStart.length];
        activeTime = al;
        rxBytes = DataStreamUtils.readVarLongArray(datainputstream);
        rxPackets = DataStreamUtils.readVarLongArray(datainputstream);
        txBytes = DataStreamUtils.readVarLongArray(datainputstream);
        txPackets = DataStreamUtils.readVarLongArray(datainputstream);
        operations = DataStreamUtils.readVarLongArray(datainputstream);
        bucketCount = bucketStart.length;
        totalBytes = ArrayUtils.total(rxBytes) + ArrayUtils.total(txBytes);
        if(true) goto _L5; else goto _L4
_L4:
    }

    private static void addLong(long al[], int i, long l) {
        if(al != null)
            al[i] = l + al[i];
    }

    private void ensureBuckets(long l, long l1) {
        long l2 = l - l % bucketDuration;
        long l3 = l1 + (bucketDuration - l1 % bucketDuration) % bucketDuration;
        for(long l4 = l2; l4 < l3; l4 += bucketDuration) {
            int i = Arrays.binarySearch(bucketStart, 0, bucketCount, l4);
            if(i < 0)
                insertBucket(~i, l4);
        }

    }

    private static long getLong(long al[], int i, long l) {
        if(al != null)
            l = al[i];
        return l;
    }

    private void insertBucket(int i, long l) {
        if(bucketCount >= bucketStart.length) {
            int i1 = (3 * Math.max(bucketStart.length, 10)) / 2;
            bucketStart = Arrays.copyOf(bucketStart, i1);
            if(activeTime != null)
                activeTime = Arrays.copyOf(activeTime, i1);
            if(rxBytes != null)
                rxBytes = Arrays.copyOf(rxBytes, i1);
            if(rxPackets != null)
                rxPackets = Arrays.copyOf(rxPackets, i1);
            if(txBytes != null)
                txBytes = Arrays.copyOf(txBytes, i1);
            if(txPackets != null)
                txPackets = Arrays.copyOf(txPackets, i1);
            if(operations != null)
                operations = Arrays.copyOf(operations, i1);
        }
        if(i < bucketCount) {
            int j = i + 1;
            int k = bucketCount - i;
            System.arraycopy(bucketStart, i, bucketStart, j, k);
            if(activeTime != null)
                System.arraycopy(activeTime, i, activeTime, j, k);
            if(rxBytes != null)
                System.arraycopy(rxBytes, i, rxBytes, j, k);
            if(rxPackets != null)
                System.arraycopy(rxPackets, i, rxPackets, j, k);
            if(txBytes != null)
                System.arraycopy(txBytes, i, txBytes, j, k);
            if(txPackets != null)
                System.arraycopy(txPackets, i, txPackets, j, k);
            if(operations != null)
                System.arraycopy(operations, i, operations, j, k);
        }
        bucketStart[i] = l;
        setLong(activeTime, i, 0L);
        setLong(rxBytes, i, 0L);
        setLong(rxPackets, i, 0L);
        setLong(txBytes, i, 0L);
        setLong(txPackets, i, 0L);
        setLong(operations, i, 0L);
        bucketCount = 1 + bucketCount;
    }

    public static long randomLong(Random random, long l, long l1) {
        return (long)((float)l + random.nextFloat() * (float)(l1 - l));
    }

    private static void setLong(long al[], int i, long l) {
        if(al != null)
            al[i] = l;
    }

    public int describeContents() {
        return 0;
    }

    public void dump(IndentingPrintWriter indentingprintwriter, boolean flag) {
        int i = 0;
        indentingprintwriter.print("NetworkStatsHistory: bucketDuration=");
        indentingprintwriter.println(bucketDuration);
        indentingprintwriter.increaseIndent();
        if(!flag)
            i = Math.max(0, -32 + bucketCount);
        if(i > 0) {
            indentingprintwriter.print("(omitting ");
            indentingprintwriter.print(i);
            indentingprintwriter.println(" buckets)");
        }
        for(int j = i; j < bucketCount; j++) {
            indentingprintwriter.print("bucketStart=");
            indentingprintwriter.print(bucketStart[j]);
            if(activeTime != null) {
                indentingprintwriter.print(" activeTime=");
                indentingprintwriter.print(activeTime[j]);
            }
            if(rxBytes != null) {
                indentingprintwriter.print(" rxBytes=");
                indentingprintwriter.print(rxBytes[j]);
            }
            if(rxPackets != null) {
                indentingprintwriter.print(" rxPackets=");
                indentingprintwriter.print(rxPackets[j]);
            }
            if(txBytes != null) {
                indentingprintwriter.print(" txBytes=");
                indentingprintwriter.print(txBytes[j]);
            }
            if(txPackets != null) {
                indentingprintwriter.print(" txPackets=");
                indentingprintwriter.print(txPackets[j]);
            }
            if(operations != null) {
                indentingprintwriter.print(" operations=");
                indentingprintwriter.print(operations[j]);
            }
            indentingprintwriter.println();
        }

        indentingprintwriter.decreaseIndent();
    }

    public int estimateResizeBuckets(long l) {
        return (int)(((long)size() * getBucketDuration()) / l);
    }

    public void generateRandom(long l, long l1, long l2) {
        Random random = new Random();
        float f = random.nextFloat();
        long l3 = (long)(f * (float)l2);
        long l4 = (long)((float)l2 * (1.0F - f));
        generateRandom(l, l1, l3, l3 / 1024L, l4, l4 / 1024L, l3 / 2048L, random);
    }

    public void generateRandom(long l, long l1, long l2, long l3, long l4, long l5, long l6, 
            Random random) {
        ensureBuckets(l, l1);
        NetworkStats.Entry entry = new NetworkStats.Entry(NetworkStats.IFACE_ALL, -1, 0, 0, 0L, 0L, 0L, 0L, 0L);
        while(l2 > 1024L || l3 > 128L || l4 > 1024L || l5 > 128L || l6 > 32L)  {
            long l7 = randomLong(random, l, l1);
            long l8 = l7 + randomLong(random, 0L, (l1 - l7) / 2L);
            entry.rxBytes = randomLong(random, 0L, l2);
            entry.rxPackets = randomLong(random, 0L, l3);
            entry.txBytes = randomLong(random, 0L, l4);
            entry.txPackets = randomLong(random, 0L, l5);
            entry.operations = randomLong(random, 0L, l6);
            l2 -= entry.rxBytes;
            l3 -= entry.rxPackets;
            l4 -= entry.txBytes;
            l5 -= entry.txPackets;
            l6 -= entry.operations;
            recordData(l7, l8, entry);
        }
    }

    public long getBucketDuration() {
        return bucketDuration;
    }

    public long getEnd() {
        long l;
        if(bucketCount > 0)
            l = bucketStart[-1 + bucketCount] + bucketDuration;
        else
            l = 0x8000000000000000L;
        return l;
    }

    public int getIndexAfter(long l) {
        int i = Arrays.binarySearch(bucketStart, 0, bucketCount, l);
        int j;
        if(i < 0)
            j = ~i;
        else
            j = i + 1;
        return MathUtils.constrain(j, 0, -1 + bucketCount);
    }

    public int getIndexBefore(long l) {
        int i = Arrays.binarySearch(bucketStart, 0, bucketCount, l);
        int j;
        if(i < 0)
            j = -1 + ~i;
        else
            j = i - 1;
        return MathUtils.constrain(j, 0, -1 + bucketCount);
    }

    public long getStart() {
        long l;
        if(bucketCount > 0)
            l = bucketStart[0];
        else
            l = 0x7fffffffffffffffL;
        return l;
    }

    public long getTotalBytes() {
        return totalBytes;
    }

    public Entry getValues(int i, Entry entry) {
        Entry entry1;
        if(entry != null)
            entry1 = entry;
        else
            entry1 = new Entry();
        entry1.bucketStart = bucketStart[i];
        entry1.bucketDuration = bucketDuration;
        entry1.activeTime = getLong(activeTime, i, -1L);
        entry1.rxBytes = getLong(rxBytes, i, -1L);
        entry1.rxPackets = getLong(rxPackets, i, -1L);
        entry1.txBytes = getLong(txBytes, i, -1L);
        entry1.txPackets = getLong(txPackets, i, -1L);
        entry1.operations = getLong(operations, i, -1L);
        return entry1;
    }

    public Entry getValues(long l, long l1, long l2, Entry entry) {
        Entry entry1;
        int i;
        long l9;
        long l10;
        long l3;
        long l4;
        long l5;
        long l6;
        long l7;
        long l8;
        if(entry != null)
            entry1 = entry;
        else
            entry1 = new Entry();
        entry1.bucketDuration = l1 - l;
        entry1.bucketStart = l;
        if(activeTime != null)
            l3 = 0L;
        else
            l3 = -1L;
        entry1.activeTime = l3;
        if(rxBytes != null)
            l4 = 0L;
        else
            l4 = -1L;
        entry1.rxBytes = l4;
        if(rxPackets != null)
            l5 = 0L;
        else
            l5 = -1L;
        entry1.rxPackets = l5;
        if(txBytes != null)
            l6 = 0L;
        else
            l6 = -1L;
        entry1.txBytes = l6;
        if(txPackets != null)
            l7 = 0L;
        else
            l7 = -1L;
        entry1.txPackets = l7;
        if(operations != null)
            l8 = 0L;
        else
            l8 = -1L;
        entry1.operations = l8;
        i = getIndexAfter(l1);
_L2:
label0:
        {
            if(i >= 0) {
                l9 = bucketStart[i];
                l10 = l9 + bucketDuration;
                if(l10 > l)
                    break label0;
            }
            return entry1;
        }
        if(l9 < l1)
            break; /* Loop/switch isn't completed */
_L3:
        i--;
        if(true) goto _L2; else goto _L1
_L1:
        boolean flag;
        long l13;
        if(l9 < l2 && l10 > l2)
            flag = true;
        else
            flag = false;
        if(flag) {
            l13 = bucketDuration;
        } else {
            long l11;
            long l12;
            if(l10 < l1)
                l11 = l10;
            else
                l11 = l1;
            if(l9 > l)
                l12 = l9;
            else
                l12 = l;
            l13 = l11 - l12;
        }
        if(l13 > 0L) {
            if(activeTime != null)
                entry1.activeTime = entry1.activeTime + (l13 * activeTime[i]) / bucketDuration;
            if(rxBytes != null)
                entry1.rxBytes = entry1.rxBytes + (l13 * rxBytes[i]) / bucketDuration;
            if(rxPackets != null)
                entry1.rxPackets = entry1.rxPackets + (l13 * rxPackets[i]) / bucketDuration;
            if(txBytes != null)
                entry1.txBytes = entry1.txBytes + (l13 * txBytes[i]) / bucketDuration;
            if(txPackets != null)
                entry1.txPackets = entry1.txPackets + (l13 * txPackets[i]) / bucketDuration;
            if(operations != null)
                entry1.operations = entry1.operations + (l13 * operations[i]) / bucketDuration;
        }
          goto _L3
        if(true) goto _L2; else goto _L4
_L4:
    }

    public Entry getValues(long l, long l1, Entry entry) {
        return getValues(l, l1, 0x7fffffffffffffffL, entry);
    }

    public void recordData(long l, long l1, long l2, long l3) {
        recordData(l, l1, new NetworkStats.Entry(NetworkStats.IFACE_ALL, -1, 0, 0, l2, 0L, l3, 0L, 0L));
    }

    public void recordData(long l, long l1, NetworkStats.Entry entry) {
        long l2;
        long l3;
        long l4;
        long l5;
        long l6;
        l2 = entry.rxBytes;
        l3 = entry.rxPackets;
        l4 = entry.txBytes;
        l5 = entry.txPackets;
        l6 = entry.operations;
        if(entry.isNegative())
            throw new IllegalArgumentException("tried recording negative data");
        if(!entry.isEmpty()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        ensureBuckets(l, l1);
        long l7 = l1 - l;
        int i = getIndexAfter(l1);
        do {
            long l8;
            long l9;
label0:
            {
                if(i >= 0) {
                    l8 = bucketStart[i];
                    l9 = l8 + bucketDuration;
                    if(l9 >= l)
                        break label0;
                }
                totalBytes = totalBytes + (entry.rxBytes + entry.txBytes);
            }
            if(true)
                continue;
            if(l8 <= l1) {
                long l10 = Math.min(l9, l1) - Math.max(l8, l);
                if(l10 > 0L) {
                    long l11 = (l2 * l10) / l7;
                    long l12 = (l3 * l10) / l7;
                    long l13 = (l4 * l10) / l7;
                    long l14 = (l5 * l10) / l7;
                    long l15 = (l6 * l10) / l7;
                    addLong(activeTime, i, l10);
                    addLong(rxBytes, i, l11);
                    l2 -= l11;
                    addLong(rxPackets, i, l12);
                    l3 -= l12;
                    addLong(txBytes, i, l13);
                    l4 -= l13;
                    addLong(txPackets, i, l14);
                    l5 -= l14;
                    addLong(operations, i, l15);
                    l6 -= l15;
                    l7 -= l10;
                }
            }
            i--;
        } while(true);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void recordEntireHistory(NetworkStatsHistory networkstatshistory) {
        recordHistory(networkstatshistory, 0x8000000000000000L, 0x7fffffffffffffffL);
    }

    public void recordHistory(NetworkStatsHistory networkstatshistory, long l, long l1) {
        NetworkStats.Entry entry = new NetworkStats.Entry(NetworkStats.IFACE_ALL, -1, 0, 0, 0L, 0L, 0L, 0L, 0L);
        int i = 0;
        do {
            int j = networkstatshistory.bucketCount;
            if(i < j) {
                long l2 = networkstatshistory.bucketStart[i];
                long l3 = l2 + networkstatshistory.bucketDuration;
                if(l2 >= l && l3 <= l1) {
                    entry.rxBytes = getLong(networkstatshistory.rxBytes, i, 0L);
                    entry.rxPackets = getLong(networkstatshistory.rxPackets, i, 0L);
                    entry.txBytes = getLong(networkstatshistory.txBytes, i, 0L);
                    entry.txPackets = getLong(networkstatshistory.txPackets, i, 0L);
                    entry.operations = getLong(networkstatshistory.operations, i, 0L);
                    recordData(l2, l3, entry);
                }
                i++;
            } else {
                return;
            }
        } while(true);
    }

    public void removeBucketsBefore(long l) {
        int i = 0;
        do {
            if(i >= bucketCount || bucketStart[i] + bucketDuration > l) {
                if(i > 0) {
                    int j = bucketStart.length;
                    bucketStart = Arrays.copyOfRange(bucketStart, i, j);
                    if(activeTime != null)
                        activeTime = Arrays.copyOfRange(activeTime, i, j);
                    if(rxBytes != null)
                        rxBytes = Arrays.copyOfRange(rxBytes, i, j);
                    if(rxPackets != null)
                        rxPackets = Arrays.copyOfRange(rxPackets, i, j);
                    if(txBytes != null)
                        txBytes = Arrays.copyOfRange(txBytes, i, j);
                    if(txPackets != null)
                        txPackets = Arrays.copyOfRange(txPackets, i, j);
                    if(operations != null)
                        operations = Arrays.copyOfRange(operations, i, j);
                    bucketCount = bucketCount - i;
                }
                return;
            }
            i++;
        } while(true);
    }

    public int size() {
        return bucketCount;
    }

    public String toString() {
        CharArrayWriter chararraywriter = new CharArrayWriter();
        dump(new IndentingPrintWriter(chararraywriter, "  "), false);
        return chararraywriter.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(bucketDuration);
        ParcelUtils.writeLongArray(parcel, bucketStart, bucketCount);
        ParcelUtils.writeLongArray(parcel, activeTime, bucketCount);
        ParcelUtils.writeLongArray(parcel, rxBytes, bucketCount);
        ParcelUtils.writeLongArray(parcel, rxPackets, bucketCount);
        ParcelUtils.writeLongArray(parcel, txBytes, bucketCount);
        ParcelUtils.writeLongArray(parcel, txPackets, bucketCount);
        ParcelUtils.writeLongArray(parcel, operations, bucketCount);
        parcel.writeLong(totalBytes);
    }

    public void writeToStream(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeInt(3);
        dataoutputstream.writeLong(bucketDuration);
        DataStreamUtils.writeVarLongArray(dataoutputstream, bucketStart, bucketCount);
        DataStreamUtils.writeVarLongArray(dataoutputstream, activeTime, bucketCount);
        DataStreamUtils.writeVarLongArray(dataoutputstream, rxBytes, bucketCount);
        DataStreamUtils.writeVarLongArray(dataoutputstream, rxPackets, bucketCount);
        DataStreamUtils.writeVarLongArray(dataoutputstream, txBytes, bucketCount);
        DataStreamUtils.writeVarLongArray(dataoutputstream, txPackets, bucketCount);
        DataStreamUtils.writeVarLongArray(dataoutputstream, operations, bucketCount);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public NetworkStatsHistory createFromParcel(Parcel parcel) {
            return new NetworkStatsHistory(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public NetworkStatsHistory[] newArray(int i) {
            return new NetworkStatsHistory[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int FIELD_ACTIVE_TIME = 1;
    public static final int FIELD_ALL = -1;
    public static final int FIELD_OPERATIONS = 32;
    public static final int FIELD_RX_BYTES = 2;
    public static final int FIELD_RX_PACKETS = 4;
    public static final int FIELD_TX_BYTES = 8;
    public static final int FIELD_TX_PACKETS = 16;
    private static final int VERSION_ADD_ACTIVE = 3;
    private static final int VERSION_ADD_PACKETS = 2;
    private static final int VERSION_INIT = 1;
    private long activeTime[];
    private int bucketCount;
    private long bucketDuration;
    private long bucketStart[];
    private long operations[];
    private long rxBytes[];
    private long rxPackets[];
    private long totalBytes;
    private long txBytes[];
    private long txPackets[];

}
