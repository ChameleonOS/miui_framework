// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.internal.util.Objects;
import com.android.internal.util.Preconditions;

// Referenced classes of package android.net:
//            NetworkTemplate

public class NetworkPolicy
    implements Parcelable, Comparable {

    public NetworkPolicy(NetworkTemplate networktemplate, int i, String s, long l, long l1, 
            long l2, long l3, boolean flag, boolean flag1) {
        template = (NetworkTemplate)Preconditions.checkNotNull(networktemplate, "missing NetworkTemplate");
        cycleDay = i;
        cycleTimezone = (String)Preconditions.checkNotNull(s, "missing cycleTimezone");
        warningBytes = l;
        limitBytes = l1;
        lastWarningSnooze = l2;
        lastLimitSnooze = l3;
        metered = flag;
        inferred = flag1;
    }

    public NetworkPolicy(NetworkTemplate networktemplate, int i, String s, long l, long l1, 
            boolean flag) {
        this(networktemplate, i, s, l, l1, -1L, -1L, flag, false);
    }

    public NetworkPolicy(Parcel parcel) {
        boolean flag = true;
        super();
        template = (NetworkTemplate)parcel.readParcelable(null);
        cycleDay = parcel.readInt();
        cycleTimezone = parcel.readString();
        warningBytes = parcel.readLong();
        limitBytes = parcel.readLong();
        lastWarningSnooze = parcel.readLong();
        lastLimitSnooze = parcel.readLong();
        boolean flag1;
        if(parcel.readInt() != 0)
            flag1 = flag;
        else
            flag1 = false;
        metered = flag1;
        if(parcel.readInt() == 0)
            flag = false;
        inferred = flag;
    }

    public void clearSnooze() {
        lastWarningSnooze = -1L;
        lastLimitSnooze = -1L;
    }

    public int compareTo(NetworkPolicy networkpolicy) {
        byte byte0;
        if(networkpolicy == null || networkpolicy.limitBytes == -1L)
            byte0 = -1;
        else
        if(limitBytes == -1L || networkpolicy.limitBytes < limitBytes)
            byte0 = 1;
        else
            byte0 = 0;
        return byte0;
    }

    public volatile int compareTo(Object obj) {
        return compareTo((NetworkPolicy)obj);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean flag = false;
        if(obj instanceof NetworkPolicy) {
            NetworkPolicy networkpolicy = (NetworkPolicy)obj;
            if(cycleDay == networkpolicy.cycleDay && warningBytes == networkpolicy.warningBytes && limitBytes == networkpolicy.limitBytes && lastWarningSnooze == networkpolicy.lastWarningSnooze && lastLimitSnooze == networkpolicy.lastLimitSnooze && metered == networkpolicy.metered && inferred == networkpolicy.inferred && Objects.equal(cycleTimezone, networkpolicy.cycleTimezone) && Objects.equal(template, networkpolicy.template))
                flag = true;
        }
        return flag;
    }

    public boolean hasCycle() {
        boolean flag;
        if(cycleDay != -1)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public int hashCode() {
        Object aobj[] = new Object[9];
        aobj[0] = template;
        aobj[1] = Integer.valueOf(cycleDay);
        aobj[2] = cycleTimezone;
        aobj[3] = Long.valueOf(warningBytes);
        aobj[4] = Long.valueOf(limitBytes);
        aobj[5] = Long.valueOf(lastWarningSnooze);
        aobj[6] = Long.valueOf(lastLimitSnooze);
        aobj[7] = Boolean.valueOf(metered);
        aobj[8] = Boolean.valueOf(inferred);
        return Objects.hashCode(aobj);
    }

    public boolean isOverLimit(long l) {
        long l1 = l + 3000L;
        boolean flag;
        if(limitBytes != -1L && l1 >= limitBytes)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isOverWarning(long l) {
        boolean flag;
        if(warningBytes != -1L && l >= warningBytes)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder("NetworkPolicy");
        stringbuilder.append("[").append(template).append("]:");
        stringbuilder.append(" cycleDay=").append(cycleDay);
        stringbuilder.append(", cycleTimezone=").append(cycleTimezone);
        stringbuilder.append(", warningBytes=").append(warningBytes);
        stringbuilder.append(", limitBytes=").append(limitBytes);
        stringbuilder.append(", lastWarningSnooze=").append(lastWarningSnooze);
        stringbuilder.append(", lastLimitSnooze=").append(lastLimitSnooze);
        stringbuilder.append(", metered=").append(metered);
        stringbuilder.append(", inferred=").append(inferred);
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int j = 1;
        parcel.writeParcelable(template, i);
        parcel.writeInt(cycleDay);
        parcel.writeString(cycleTimezone);
        parcel.writeLong(warningBytes);
        parcel.writeLong(limitBytes);
        parcel.writeLong(lastWarningSnooze);
        parcel.writeLong(lastLimitSnooze);
        int k;
        if(metered)
            k = j;
        else
            k = 0;
        parcel.writeInt(k);
        if(!inferred)
            j = 0;
        parcel.writeInt(j);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public NetworkPolicy createFromParcel(Parcel parcel) {
            return new NetworkPolicy(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public NetworkPolicy[] newArray(int i) {
            return new NetworkPolicy[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int CYCLE_NONE = -1;
    private static final long DEFAULT_MTU = 1500L;
    public static final long LIMIT_DISABLED = -1L;
    public static final long SNOOZE_NEVER = -1L;
    public static final long WARNING_DISABLED = -1L;
    public int cycleDay;
    public String cycleTimezone;
    public boolean inferred;
    public long lastLimitSnooze;
    public long lastWarningSnooze;
    public long limitBytes;
    public boolean metered;
    public final NetworkTemplate template;
    public long warningBytes;

}
