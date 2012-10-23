// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.os.*;
import android.util.SparseBooleanArray;
import com.android.internal.util.Objects;
import java.io.CharArrayWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;

public class NetworkStats
    implements Parcelable {
    public static interface NonMonotonicObserver {

        public abstract void foundNonMonotonic(NetworkStats networkstats, int i, NetworkStats networkstats1, int j, Object obj);
    }

    public static class Entry {

        public void add(Entry entry) {
            rxBytes = rxBytes + entry.rxBytes;
            rxPackets = rxPackets + entry.rxPackets;
            txBytes = txBytes + entry.txBytes;
            txPackets = txPackets + entry.txPackets;
            operations = operations + entry.operations;
        }

        public boolean isEmpty() {
            boolean flag;
            if(rxBytes == 0L && rxPackets == 0L && txBytes == 0L && txPackets == 0L && operations == 0L)
                flag = true;
            else
                flag = false;
            return flag;
        }

        public boolean isNegative() {
            boolean flag;
            if(rxBytes < 0L || rxPackets < 0L || txBytes < 0L || txPackets < 0L || operations < 0L)
                flag = true;
            else
                flag = false;
            return flag;
        }

        public String toString() {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("iface=").append(iface);
            stringbuilder.append(" uid=").append(uid);
            stringbuilder.append(" set=").append(NetworkStats.setToString(set));
            stringbuilder.append(" tag=").append(NetworkStats.tagToString(tag));
            stringbuilder.append(" rxBytes=").append(rxBytes);
            stringbuilder.append(" rxPackets=").append(rxPackets);
            stringbuilder.append(" txBytes=").append(txBytes);
            stringbuilder.append(" txPackets=").append(txPackets);
            stringbuilder.append(" operations=").append(operations);
            return stringbuilder.toString();
        }

        public String iface;
        public long operations;
        public long rxBytes;
        public long rxPackets;
        public int set;
        public int tag;
        public long txBytes;
        public long txPackets;
        public int uid;

        public Entry() {
            this(NetworkStats.IFACE_ALL, -1, 0, 0, 0L, 0L, 0L, 0L, 0L);
        }

        public Entry(long l, long l1, long l2, long l3, long l4) {
            this(NetworkStats.IFACE_ALL, -1, 0, 0, l, l1, l2, l3, l4);
        }

        public Entry(String s, int i, int j, int k, long l, long l1, long l2, long l3, long l4) {
            iface = s;
            uid = i;
            set = j;
            tag = k;
            rxBytes = l;
            rxPackets = l1;
            txBytes = l2;
            txPackets = l3;
            operations = l4;
        }
    }


    public NetworkStats(long l, int i) {
        elapsedRealtime = l;
        size = 0;
        iface = new String[i];
        uid = new int[i];
        set = new int[i];
        tag = new int[i];
        rxBytes = new long[i];
        rxPackets = new long[i];
        txBytes = new long[i];
        txPackets = new long[i];
        operations = new long[i];
    }

    public NetworkStats(Parcel parcel) {
        elapsedRealtime = parcel.readLong();
        size = parcel.readInt();
        iface = parcel.createStringArray();
        uid = parcel.createIntArray();
        set = parcel.createIntArray();
        tag = parcel.createIntArray();
        rxBytes = parcel.createLongArray();
        rxPackets = parcel.createLongArray();
        txBytes = parcel.createLongArray();
        txPackets = parcel.createLongArray();
        operations = parcel.createLongArray();
    }

    private Entry getTotal(Entry entry, HashSet hashset, int i, boolean flag) {
        Entry entry1;
        int j;
        if(entry != null)
            entry1 = entry;
        else
            entry1 = new Entry();
        entry1.iface = IFACE_ALL;
        entry1.uid = i;
        entry1.set = -1;
        entry1.tag = 0;
        entry1.rxBytes = 0L;
        entry1.rxPackets = 0L;
        entry1.txBytes = 0L;
        entry1.txPackets = 0L;
        entry1.operations = 0L;
        j = 0;
        while(j < size)  {
            boolean flag1;
            boolean flag2;
            if(i == -1 || i == uid[j])
                flag1 = true;
            else
                flag1 = false;
            if(hashset == null || hashset.contains(iface[j]))
                flag2 = true;
            else
                flag2 = false;
            if(flag1 && flag2 && (tag[j] == 0 || flag)) {
                entry1.rxBytes = entry1.rxBytes + rxBytes[j];
                entry1.rxPackets = entry1.rxPackets + rxPackets[j];
                entry1.txBytes = entry1.txBytes + txBytes[j];
                entry1.txPackets = entry1.txPackets + txPackets[j];
                entry1.operations = entry1.operations + operations[j];
            }
            j++;
        }
        return entry1;
    }

    public static String setToString(int i) {
        i;
        JVM INSTR tableswitch -1 1: default 28
    //                   -1 33
    //                   0 39
    //                   1 45;
           goto _L1 _L2 _L3 _L4
_L1:
        String s = "UNKNOWN";
_L6:
        return s;
_L2:
        s = "ALL";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "DEFAULT";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "FOREGROUND";
        if(true) goto _L6; else goto _L5
_L5:
    }

    public static NetworkStats subtract(NetworkStats networkstats, NetworkStats networkstats1, NonMonotonicObserver nonmonotonicobserver, Object obj) {
        long l = networkstats.elapsedRealtime - networkstats1.elapsedRealtime;
        if(l < 0L) {
            if(nonmonotonicobserver != null)
                nonmonotonicobserver.foundNonMonotonic(networkstats, -1, networkstats1, -1, obj);
            l = 0L;
        }
        Entry entry = new Entry();
        NetworkStats networkstats2 = new NetworkStats(l, networkstats.size);
        int i = 0;
        while(i < networkstats.size)  {
            entry.iface = networkstats.iface[i];
            entry.uid = networkstats.uid[i];
            entry.set = networkstats.set[i];
            entry.tag = networkstats.tag[i];
            int j = networkstats1.findIndexHinted(entry.iface, entry.uid, entry.set, entry.tag, i);
            if(j == -1) {
                entry.rxBytes = networkstats.rxBytes[i];
                entry.rxPackets = networkstats.rxPackets[i];
                entry.txBytes = networkstats.txBytes[i];
                entry.txPackets = networkstats.txPackets[i];
                entry.operations = networkstats.operations[i];
            } else {
                entry.rxBytes = networkstats.rxBytes[i] - networkstats1.rxBytes[j];
                entry.rxPackets = networkstats.rxPackets[i] - networkstats1.rxPackets[j];
                entry.txBytes = networkstats.txBytes[i] - networkstats1.txBytes[j];
                entry.txPackets = networkstats.txPackets[i] - networkstats1.txPackets[j];
                entry.operations = networkstats.operations[i] - networkstats1.operations[j];
                if(entry.rxBytes < 0L || entry.rxPackets < 0L || entry.txBytes < 0L || entry.txPackets < 0L || entry.operations < 0L) {
                    if(nonmonotonicobserver != null)
                        nonmonotonicobserver.foundNonMonotonic(networkstats, i, networkstats1, j, obj);
                    entry.rxBytes = Math.max(entry.rxBytes, 0L);
                    entry.rxPackets = Math.max(entry.rxPackets, 0L);
                    entry.txBytes = Math.max(entry.txBytes, 0L);
                    entry.txPackets = Math.max(entry.txPackets, 0L);
                    entry.operations = Math.max(entry.operations, 0L);
                }
            }
            networkstats2.addValues(entry);
            i++;
        }
        return networkstats2;
    }

    public static String tagToString(int i) {
        return (new StringBuilder()).append("0x").append(Integer.toHexString(i)).toString();
    }

    public NetworkStats addIfaceValues(String s, long l, long l1, long l2, 
            long l3) {
        return addValues(s, -1, 0, 0, l, l1, l2, l3, 0L);
    }

    public NetworkStats addValues(Entry entry) {
        if(size >= iface.length) {
            int i = (3 * Math.max(iface.length, 10)) / 2;
            iface = (String[])Arrays.copyOf(iface, i);
            uid = Arrays.copyOf(uid, i);
            set = Arrays.copyOf(set, i);
            tag = Arrays.copyOf(tag, i);
            rxBytes = Arrays.copyOf(rxBytes, i);
            rxPackets = Arrays.copyOf(rxPackets, i);
            txBytes = Arrays.copyOf(txBytes, i);
            txPackets = Arrays.copyOf(txPackets, i);
            operations = Arrays.copyOf(operations, i);
        }
        iface[size] = entry.iface;
        uid[size] = entry.uid;
        set[size] = entry.set;
        tag[size] = entry.tag;
        rxBytes[size] = entry.rxBytes;
        rxPackets[size] = entry.rxPackets;
        txBytes[size] = entry.txBytes;
        txPackets[size] = entry.txPackets;
        operations[size] = entry.operations;
        size = 1 + size;
        return this;
    }

    public NetworkStats addValues(String s, int i, int j, int k, long l, long l1, long l2, long l3, long l4) {
        return addValues(new Entry(s, i, j, k, l, l1, l2, l3, l4));
    }

    public NetworkStats clone() {
        NetworkStats networkstats = new NetworkStats(elapsedRealtime, size);
        Entry entry = null;
        for(int i = 0; i < size; i++) {
            entry = getValues(i, entry);
            networkstats.addValues(entry);
        }

        return networkstats;
    }

    public volatile Object clone() throws CloneNotSupportedException {
        return clone();
    }

    public void combineAllValues(NetworkStats networkstats) {
        Entry entry = null;
        for(int i = 0; i < networkstats.size; i++) {
            entry = networkstats.getValues(i, entry);
            combineValues(entry);
        }

    }

    public NetworkStats combineValues(Entry entry) {
        int i = findIndex(entry.iface, entry.uid, entry.set, entry.tag);
        if(i == -1) {
            addValues(entry);
        } else {
            long al[] = rxBytes;
            al[i] = al[i] + entry.rxBytes;
            long al1[] = rxPackets;
            al1[i] = al1[i] + entry.rxPackets;
            long al2[] = txBytes;
            al2[i] = al2[i] + entry.txBytes;
            long al3[] = txPackets;
            al3[i] = al3[i] + entry.txPackets;
            long al4[] = operations;
            al4[i] = al4[i] + entry.operations;
        }
        return this;
    }

    public NetworkStats combineValues(String s, int i, int j, int k, long l, long l1, long l2, long l3, long l4) {
        return combineValues(new Entry(s, i, j, k, l, l1, l2, l3, l4));
    }

    public NetworkStats combineValues(String s, int i, int j, long l, long l1, 
            long l2, long l3, long l4) {
        return combineValues(s, i, 0, j, l, l1, l2, l3, l4);
    }

    public int describeContents() {
        return 0;
    }

    public void dump(String s, PrintWriter printwriter) {
        printwriter.print(s);
        printwriter.print("NetworkStats: elapsedRealtime=");
        printwriter.println(elapsedRealtime);
        for(int i = 0; i < size; i++) {
            printwriter.print(s);
            printwriter.print("  [");
            printwriter.print(i);
            printwriter.print("]");
            printwriter.print(" iface=");
            printwriter.print(iface[i]);
            printwriter.print(" uid=");
            printwriter.print(uid[i]);
            printwriter.print(" set=");
            printwriter.print(setToString(set[i]));
            printwriter.print(" tag=");
            printwriter.print(tagToString(tag[i]));
            printwriter.print(" rxBytes=");
            printwriter.print(rxBytes[i]);
            printwriter.print(" rxPackets=");
            printwriter.print(rxPackets[i]);
            printwriter.print(" txBytes=");
            printwriter.print(txBytes[i]);
            printwriter.print(" txPackets=");
            printwriter.print(txPackets[i]);
            printwriter.print(" operations=");
            printwriter.println(operations[i]);
        }

    }

    public int findIndex(String s, int i, int j, int k) {
        int l = 0;
_L3:
        if(l >= size)
            break MISSING_BLOCK_LABEL_69;
        if(i != uid[l] || j != set[l] || k != tag[l] || !Objects.equal(s, iface[l])) goto _L2; else goto _L1
_L1:
        return l;
_L2:
        l++;
          goto _L3
        l = -1;
          goto _L1
    }

    public int findIndexHinted(String s, int i, int j, int k, int l) {
        int i1 = 0;
_L3:
        int j1;
        if(i1 >= size)
            break MISSING_BLOCK_LABEL_117;
        int k1 = i1 / 2;
        if(i1 % 2 == 0)
            j1 = (l + k1) % size;
        else
            j1 = (-1 + ((l + size) - k1)) % size;
        if(i != uid[j1] || j != set[j1] || k != tag[j1] || !Objects.equal(s, iface[j1])) goto _L2; else goto _L1
_L1:
        return j1;
_L2:
        i1++;
          goto _L3
        j1 = -1;
          goto _L1
    }

    public long getElapsedRealtime() {
        return elapsedRealtime;
    }

    public long getElapsedRealtimeAge() {
        return SystemClock.elapsedRealtime() - elapsedRealtime;
    }

    public Entry getTotal(Entry entry) {
        return getTotal(entry, null, -1, false);
    }

    public Entry getTotal(Entry entry, int i) {
        return getTotal(entry, null, i, false);
    }

    public Entry getTotal(Entry entry, HashSet hashset) {
        return getTotal(entry, hashset, -1, false);
    }

    public long getTotalBytes() {
        Entry entry = getTotal(null);
        return entry.rxBytes + entry.txBytes;
    }

    public Entry getTotalIncludingTags(Entry entry) {
        return getTotal(entry, null, -1, true);
    }

    public String[] getUniqueIfaces() {
        HashSet hashset = new HashSet();
        String as[] = iface;
        int i = as.length;
        for(int j = 0; j < i; j++) {
            String s = as[j];
            if(s != IFACE_ALL)
                hashset.add(s);
        }

        return (String[])hashset.toArray(new String[hashset.size()]);
    }

    public int[] getUniqueUids() {
        SparseBooleanArray sparsebooleanarray = new SparseBooleanArray();
        int ai[] = uid;
        int i = ai.length;
        for(int j = 0; j < i; j++)
            sparsebooleanarray.put(ai[j], true);

        int k = sparsebooleanarray.size();
        int ai1[] = new int[k];
        for(int l = 0; l < k; l++)
            ai1[l] = sparsebooleanarray.keyAt(l);

        return ai1;
    }

    public Entry getValues(int i, Entry entry) {
        Entry entry1;
        if(entry != null)
            entry1 = entry;
        else
            entry1 = new Entry();
        entry1.iface = iface[i];
        entry1.uid = uid[i];
        entry1.set = set[i];
        entry1.tag = tag[i];
        entry1.rxBytes = rxBytes[i];
        entry1.rxPackets = rxPackets[i];
        entry1.txBytes = txBytes[i];
        entry1.txPackets = txPackets[i];
        entry1.operations = operations[i];
        return entry1;
    }

    public NetworkStats groupedByIface() {
        NetworkStats networkstats = new NetworkStats(elapsedRealtime, 10);
        Entry entry = new Entry();
        entry.uid = -1;
        entry.set = -1;
        entry.tag = 0;
        entry.operations = 0L;
        int i = 0;
        while(i < size)  {
            if(tag[i] == 0) {
                entry.iface = iface[i];
                entry.rxBytes = rxBytes[i];
                entry.rxPackets = rxPackets[i];
                entry.txBytes = txBytes[i];
                entry.txPackets = txPackets[i];
                networkstats.combineValues(entry);
            }
            i++;
        }
        return networkstats;
    }

    public NetworkStats groupedByUid() {
        NetworkStats networkstats = new NetworkStats(elapsedRealtime, 10);
        Entry entry = new Entry();
        entry.iface = IFACE_ALL;
        entry.set = -1;
        entry.tag = 0;
        int i = 0;
        while(i < size)  {
            if(tag[i] == 0) {
                entry.uid = uid[i];
                entry.rxBytes = rxBytes[i];
                entry.rxPackets = rxPackets[i];
                entry.txBytes = txBytes[i];
                entry.txPackets = txPackets[i];
                entry.operations = operations[i];
                networkstats.combineValues(entry);
            }
            i++;
        }
        return networkstats;
    }

    public int internalSize() {
        return iface.length;
    }

    public int size() {
        return size;
    }

    public void spliceOperationsFrom(NetworkStats networkstats) {
        int i = 0;
        while(i < size)  {
            int j = networkstats.findIndex(iface[i], uid[i], set[i], tag[i]);
            if(j == -1)
                operations[i] = 0L;
            else
                operations[i] = networkstats.operations[j];
            i++;
        }
    }

    public NetworkStats subtract(NetworkStats networkstats) {
        return subtract(this, networkstats, null, null);
    }

    public String toString() {
        CharArrayWriter chararraywriter = new CharArrayWriter();
        dump("", new PrintWriter(chararraywriter));
        return chararraywriter.toString();
    }

    public NetworkStats withoutUid(int i) {
        NetworkStats networkstats = new NetworkStats(elapsedRealtime, 10);
        Entry entry = new Entry();
        for(int j = 0; j < size; j++) {
            entry = getValues(j, entry);
            if(entry.uid != i)
                networkstats.addValues(entry);
        }

        return networkstats;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(elapsedRealtime);
        parcel.writeInt(size);
        parcel.writeStringArray(iface);
        parcel.writeIntArray(uid);
        parcel.writeIntArray(set);
        parcel.writeIntArray(tag);
        parcel.writeLongArray(rxBytes);
        parcel.writeLongArray(rxPackets);
        parcel.writeLongArray(txBytes);
        parcel.writeLongArray(txPackets);
        parcel.writeLongArray(operations);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public NetworkStats createFromParcel(Parcel parcel) {
            return new NetworkStats(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public NetworkStats[] newArray(int i) {
            return new NetworkStats[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final String IFACE_ALL = null;
    public static final int SET_ALL = -1;
    public static final int SET_DEFAULT = 0;
    public static final int SET_FOREGROUND = 1;
    public static final int TAG_NONE = 0;
    public static final int UID_ALL = -1;
    private final long elapsedRealtime;
    private String iface[];
    private long operations[];
    private long rxBytes[];
    private long rxPackets[];
    private int set[];
    private int size;
    private int tag[];
    private long txBytes[];
    private long txPackets[];
    private int uid[];

}
