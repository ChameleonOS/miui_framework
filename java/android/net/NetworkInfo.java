// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.EnumMap;

// Referenced classes of package android.net:
//            ConnectivityManager

public class NetworkInfo
    implements Parcelable {
    public static final class DetailedState extends Enum {

        public static DetailedState valueOf(String s) {
            return (DetailedState)Enum.valueOf(android/net/NetworkInfo$DetailedState, s);
        }

        public static DetailedState[] values() {
            return (DetailedState[])$VALUES.clone();
        }

        private static final DetailedState $VALUES[];
        public static final DetailedState AUTHENTICATING;
        public static final DetailedState BLOCKED;
        public static final DetailedState CONNECTED;
        public static final DetailedState CONNECTING;
        public static final DetailedState DISCONNECTED;
        public static final DetailedState DISCONNECTING;
        public static final DetailedState FAILED;
        public static final DetailedState IDLE;
        public static final DetailedState OBTAINING_IPADDR;
        public static final DetailedState SCANNING;
        public static final DetailedState SUSPENDED;
        public static final DetailedState VERIFYING_POOR_LINK;

        static  {
            IDLE = new DetailedState("IDLE", 0);
            SCANNING = new DetailedState("SCANNING", 1);
            CONNECTING = new DetailedState("CONNECTING", 2);
            AUTHENTICATING = new DetailedState("AUTHENTICATING", 3);
            OBTAINING_IPADDR = new DetailedState("OBTAINING_IPADDR", 4);
            CONNECTED = new DetailedState("CONNECTED", 5);
            SUSPENDED = new DetailedState("SUSPENDED", 6);
            DISCONNECTING = new DetailedState("DISCONNECTING", 7);
            DISCONNECTED = new DetailedState("DISCONNECTED", 8);
            FAILED = new DetailedState("FAILED", 9);
            BLOCKED = new DetailedState("BLOCKED", 10);
            VERIFYING_POOR_LINK = new DetailedState("VERIFYING_POOR_LINK", 11);
            DetailedState adetailedstate[] = new DetailedState[12];
            adetailedstate[0] = IDLE;
            adetailedstate[1] = SCANNING;
            adetailedstate[2] = CONNECTING;
            adetailedstate[3] = AUTHENTICATING;
            adetailedstate[4] = OBTAINING_IPADDR;
            adetailedstate[5] = CONNECTED;
            adetailedstate[6] = SUSPENDED;
            adetailedstate[7] = DISCONNECTING;
            adetailedstate[8] = DISCONNECTED;
            adetailedstate[9] = FAILED;
            adetailedstate[10] = BLOCKED;
            adetailedstate[11] = VERIFYING_POOR_LINK;
            $VALUES = adetailedstate;
        }

        private DetailedState(String s, int i) {
            super(s, i);
        }
    }

    public static final class State extends Enum {

        public static State valueOf(String s) {
            return (State)Enum.valueOf(android/net/NetworkInfo$State, s);
        }

        public static State[] values() {
            return (State[])$VALUES.clone();
        }

        private static final State $VALUES[];
        public static final State CONNECTED;
        public static final State CONNECTING;
        public static final State DISCONNECTED;
        public static final State DISCONNECTING;
        public static final State SUSPENDED;
        public static final State UNKNOWN;

        static  {
            CONNECTING = new State("CONNECTING", 0);
            CONNECTED = new State("CONNECTED", 1);
            SUSPENDED = new State("SUSPENDED", 2);
            DISCONNECTING = new State("DISCONNECTING", 3);
            DISCONNECTED = new State("DISCONNECTED", 4);
            UNKNOWN = new State("UNKNOWN", 5);
            State astate[] = new State[6];
            astate[0] = CONNECTING;
            astate[1] = CONNECTED;
            astate[2] = SUSPENDED;
            astate[3] = DISCONNECTING;
            astate[4] = DISCONNECTED;
            astate[5] = UNKNOWN;
            $VALUES = astate;
        }

        private State(String s, int i) {
            super(s, i);
        }
    }


    public NetworkInfo(int i) {
    }

    public NetworkInfo(int i, int j, String s, String s1) {
        if(!ConnectivityManager.isNetworkTypeValid(i)) {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid network type: ").append(i).toString());
        } else {
            mNetworkType = i;
            mSubtype = j;
            mTypeName = s;
            mSubtypeName = s1;
            setDetailedState(DetailedState.IDLE, null, null);
            mState = State.UNKNOWN;
            mIsAvailable = false;
            mIsRoaming = false;
            return;
        }
    }

    public NetworkInfo(NetworkInfo networkinfo) {
        if(networkinfo != null) {
            mNetworkType = networkinfo.mNetworkType;
            mSubtype = networkinfo.mSubtype;
            mTypeName = networkinfo.mTypeName;
            mSubtypeName = networkinfo.mSubtypeName;
            mState = networkinfo.mState;
            mDetailedState = networkinfo.mDetailedState;
            mReason = networkinfo.mReason;
            mExtraInfo = networkinfo.mExtraInfo;
            mIsFailover = networkinfo.mIsFailover;
            mIsRoaming = networkinfo.mIsRoaming;
            mIsAvailable = networkinfo.mIsAvailable;
        }
    }

    public int describeContents() {
        return 0;
    }

    public DetailedState getDetailedState() {
        this;
        JVM INSTR monitorenter ;
        DetailedState detailedstate = mDetailedState;
        return detailedstate;
    }

    public String getExtraInfo() {
        this;
        JVM INSTR monitorenter ;
        String s = mExtraInfo;
        return s;
    }

    public String getReason() {
        this;
        JVM INSTR monitorenter ;
        String s = mReason;
        return s;
    }

    public State getState() {
        this;
        JVM INSTR monitorenter ;
        State state = mState;
        return state;
    }

    public int getSubtype() {
        this;
        JVM INSTR monitorenter ;
        int i = mSubtype;
        return i;
    }

    public String getSubtypeName() {
        this;
        JVM INSTR monitorenter ;
        String s = mSubtypeName;
        return s;
    }

    public int getType() {
        this;
        JVM INSTR monitorenter ;
        int i = mNetworkType;
        return i;
    }

    public String getTypeName() {
        this;
        JVM INSTR monitorenter ;
        String s = mTypeName;
        return s;
    }

    public boolean isAvailable() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mIsAvailable;
        return flag;
    }

    public boolean isConnected() {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        if(mState == State.CONNECTED)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isConnectedOrConnecting() {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        if(mState == State.CONNECTED || mState == State.CONNECTING)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isFailover() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mIsFailover;
        return flag;
    }

    public boolean isRoaming() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mIsRoaming;
        return flag;
    }

    public void setDetailedState(DetailedState detailedstate, String s, String s1) {
        this;
        JVM INSTR monitorenter ;
        mDetailedState = detailedstate;
        mState = (State)stateMap.get(detailedstate);
        mReason = s;
        mExtraInfo = s1;
        return;
    }

    public void setExtraInfo(String s) {
        this;
        JVM INSTR monitorenter ;
        mExtraInfo = s;
        return;
    }

    public void setFailover(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        mIsFailover = flag;
        return;
    }

    public void setIsAvailable(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        mIsAvailable = flag;
        return;
    }

    void setRoaming(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        mIsRoaming = flag;
        return;
    }

    void setSubtype(int i, String s) {
        this;
        JVM INSTR monitorenter ;
        mSubtype = i;
        mSubtypeName = s;
        return;
    }

    public String toString() {
        this;
        JVM INSTR monitorenter ;
        StringBuilder stringbuilder = new StringBuilder("NetworkInfo: ");
        StringBuilder stringbuilder1 = stringbuilder.append("type: ").append(getTypeName()).append("[").append(getSubtypeName()).append("], state: ").append(mState).append("/").append(mDetailedState).append(", reason: ");
        String s;
        StringBuilder stringbuilder2;
        String s1;
        String s2;
        if(mReason == null)
            s = "(unspecified)";
        else
            s = mReason;
        stringbuilder2 = stringbuilder1.append(s).append(", extra: ");
        if(mExtraInfo == null)
            s1 = "(none)";
        else
            s1 = mExtraInfo;
        stringbuilder2.append(s1).append(", roaming: ").append(mIsRoaming).append(", failover: ").append(mIsFailover).append(", isAvailable: ").append(mIsAvailable);
        s2 = stringbuilder.toString();
        return s2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int j = 1;
        this;
        JVM INSTR monitorenter ;
        parcel.writeInt(mNetworkType);
        parcel.writeInt(mSubtype);
        parcel.writeString(mTypeName);
        parcel.writeString(mSubtypeName);
        parcel.writeString(mState.name());
        parcel.writeString(mDetailedState.name());
        int k;
        int l;
        if(mIsFailover)
            k = j;
        else
            k = 0;
        parcel.writeInt(k);
        if(mIsAvailable)
            l = j;
        else
            l = 0;
        parcel.writeInt(l);
        if(!mIsRoaming)
            j = 0;
        parcel.writeInt(j);
        parcel.writeString(mReason);
        parcel.writeString(mExtraInfo);
        return;
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public NetworkInfo createFromParcel(Parcel parcel) {
            boolean flag = true;
            NetworkInfo networkinfo = new NetworkInfo(parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString());
            networkinfo.mState = State.valueOf(parcel.readString());
            networkinfo.mDetailedState = DetailedState.valueOf(parcel.readString());
            boolean flag1;
            boolean flag2;
            if(parcel.readInt() != 0)
                flag1 = flag;
            else
                flag1 = false;
            networkinfo.mIsFailover = flag1;
            if(parcel.readInt() != 0)
                flag2 = flag;
            else
                flag2 = false;
            networkinfo.mIsAvailable = flag2;
            if(parcel.readInt() == 0)
                flag = false;
            networkinfo.mIsRoaming = flag;
            networkinfo.mReason = parcel.readString();
            networkinfo.mExtraInfo = parcel.readString();
            return networkinfo;
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public NetworkInfo[] newArray(int i) {
            return new NetworkInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private static final EnumMap stateMap;
    private DetailedState mDetailedState;
    private String mExtraInfo;
    private boolean mIsAvailable;
    private boolean mIsFailover;
    private boolean mIsRoaming;
    private int mNetworkType;
    private String mReason;
    private State mState;
    private int mSubtype;
    private String mSubtypeName;
    private String mTypeName;

    static  {
        stateMap = new EnumMap(android/net/NetworkInfo$DetailedState);
        stateMap.put(DetailedState.IDLE, State.DISCONNECTED);
        stateMap.put(DetailedState.SCANNING, State.DISCONNECTED);
        stateMap.put(DetailedState.CONNECTING, State.CONNECTING);
        stateMap.put(DetailedState.AUTHENTICATING, State.CONNECTING);
        stateMap.put(DetailedState.OBTAINING_IPADDR, State.CONNECTING);
        stateMap.put(DetailedState.VERIFYING_POOR_LINK, State.CONNECTING);
        stateMap.put(DetailedState.CONNECTED, State.CONNECTED);
        stateMap.put(DetailedState.SUSPENDED, State.SUSPENDED);
        stateMap.put(DetailedState.DISCONNECTING, State.DISCONNECTING);
        stateMap.put(DetailedState.DISCONNECTED, State.DISCONNECTED);
        stateMap.put(DetailedState.FAILED, State.DISCONNECTED);
        stateMap.put(DetailedState.BLOCKED, State.DISCONNECTED);
    }


/*
    static State access$002(NetworkInfo networkinfo, State state) {
        networkinfo.mState = state;
        return state;
    }

*/


/*
    static DetailedState access$102(NetworkInfo networkinfo, DetailedState detailedstate) {
        networkinfo.mDetailedState = detailedstate;
        return detailedstate;
    }

*/


/*
    static boolean access$202(NetworkInfo networkinfo, boolean flag) {
        networkinfo.mIsFailover = flag;
        return flag;
    }

*/


/*
    static boolean access$302(NetworkInfo networkinfo, boolean flag) {
        networkinfo.mIsAvailable = flag;
        return flag;
    }

*/


/*
    static boolean access$402(NetworkInfo networkinfo, boolean flag) {
        networkinfo.mIsRoaming = flag;
        return flag;
    }

*/


/*
    static String access$502(NetworkInfo networkinfo, String s) {
        networkinfo.mReason = s;
        return s;
    }

*/


/*
    static String access$602(NetworkInfo networkinfo, String s) {
        networkinfo.mExtraInfo = s;
        return s;
    }

*/
}
