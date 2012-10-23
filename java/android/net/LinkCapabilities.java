// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.util.*;

public class LinkCapabilities
    implements Parcelable {
    public static final class Role {

        public static final String BULK_DOWNLOAD = "bulk.download";
        public static final String BULK_UPLOAD = "bulk.upload";
        public static final String DEFAULT = "default";
        public static final String VIDEO_CHAT_360P = "video.chat.360p";
        public static final String VIDEO_CHAT_480P = "video.chat.480i";
        public static final String VIDEO_STREAMING_480P = "video.streaming.480p";
        public static final String VIDEO_STREAMING_720I = "video.streaming.720i";
        public static final String VOIP_24KBPS = "voip.24k";
        public static final String VOIP_32KBPS = "voip.32k";

        private Role() {
        }
    }

    public static final class Key {

        public static final int RO_AVAILABLE_FWD_BW = 4;
        public static final int RO_AVAILABLE_REV_BW = 7;
        public static final int RO_BOUND_INTERFACE = 9;
        public static final int RO_NETWORK_TYPE = 1;
        public static final int RO_PHYSICAL_INTERFACE = 10;
        public static final int RW_DESIRED_FWD_BW = 2;
        public static final int RW_DESIRED_REV_BW = 5;
        public static final int RW_MAX_ALLOWED_LATENCY = 8;
        public static final int RW_REQUIRED_FWD_BW = 3;
        public static final int RW_REQUIRED_REV_BW = 6;

        private Key() {
        }
    }


    public LinkCapabilities() {
        mCapabilities = new HashMap();
    }

    public LinkCapabilities(LinkCapabilities linkcapabilities) {
        if(linkcapabilities != null)
            mCapabilities = new HashMap(linkcapabilities.mCapabilities);
        else
            mCapabilities = new HashMap();
    }

    public static LinkCapabilities createNeedsMap(String s) {
        return new LinkCapabilities();
    }

    protected static void log(String s) {
        Log.d("LinkCapabilities", s);
    }

    public void clear() {
        mCapabilities.clear();
    }

    public boolean containsKey(int i) {
        return mCapabilities.containsKey(Integer.valueOf(i));
    }

    public boolean containsValue(String s) {
        return mCapabilities.containsValue(s);
    }

    public int describeContents() {
        return 0;
    }

    public Set entrySet() {
        return mCapabilities.entrySet();
    }

    public String get(int i) {
        return (String)mCapabilities.get(Integer.valueOf(i));
    }

    public boolean isEmpty() {
        return mCapabilities.isEmpty();
    }

    public Set keySet() {
        return mCapabilities.keySet();
    }

    public void put(int i, String s) {
        mCapabilities.put(Integer.valueOf(i), s);
    }

    public int size() {
        return mCapabilities.size();
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("{");
        Iterator iterator = mCapabilities.entrySet().iterator();
        String s;
        if(iterator.hasNext()) {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if(false)
                stringbuilder.append(",");
            stringbuilder.append(entry.getKey());
            stringbuilder.append(":\"");
            stringbuilder.append((String)entry.getValue());
            stringbuilder.append("\"");
            s = mCapabilities.toString();
        } else {
            s = stringbuilder.toString();
        }
        return s;
    }

    public Collection values() {
        return mCapabilities.values();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mCapabilities.size());
        java.util.Map.Entry entry;
        for(Iterator iterator = mCapabilities.entrySet().iterator(); iterator.hasNext(); parcel.writeString((String)entry.getValue())) {
            entry = (java.util.Map.Entry)iterator.next();
            parcel.writeInt(((Integer)entry.getKey()).intValue());
        }

    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public LinkCapabilities createFromParcel(Parcel parcel) {
            LinkCapabilities linkcapabilities = new LinkCapabilities();
            int i = parcel.readInt();
            do {
                int j = i - 1;
                if(i != 0) {
                    int k = parcel.readInt();
                    String s = parcel.readString();
                    linkcapabilities.mCapabilities.put(Integer.valueOf(k), s);
                    i = j;
                } else {
                    return linkcapabilities;
                }
            } while(true);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public LinkCapabilities[] newArray(int i) {
            return new LinkCapabilities[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private static final boolean DBG = false;
    private static final String TAG = "LinkCapabilities";
    private HashMap mCapabilities;


}
