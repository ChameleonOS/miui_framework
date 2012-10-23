// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.net.wifi;

import android.os.Parcel;
import android.os.Parcelable;

public class WpsResult
    implements Parcelable {
    public static final class Status extends Enum {

        public static Status valueOf(String s) {
            return (Status)Enum.valueOf(android/net/wifi/WpsResult$Status, s);
        }

        public static Status[] values() {
            return (Status[])$VALUES.clone();
        }

        private static final Status $VALUES[];
        public static final Status FAILURE;
        public static final Status IN_PROGRESS;
        public static final Status SUCCESS;

        static  {
            SUCCESS = new Status("SUCCESS", 0);
            FAILURE = new Status("FAILURE", 1);
            IN_PROGRESS = new Status("IN_PROGRESS", 2);
            Status astatus[] = new Status[3];
            astatus[0] = SUCCESS;
            astatus[1] = FAILURE;
            astatus[2] = IN_PROGRESS;
            $VALUES = astatus;
        }

        private Status(String s, int i) {
            super(s, i);
        }
    }


    public WpsResult() {
        status = Status.FAILURE;
        pin = null;
    }

    public WpsResult(Status status1) {
        status = status1;
        pin = null;
    }

    public WpsResult(WpsResult wpsresult) {
        if(wpsresult != null) {
            status = wpsresult.status;
            pin = wpsresult.pin;
        }
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append(" status: ").append(status.toString());
        stringbuffer.append('\n');
        stringbuffer.append(" pin: ").append(pin);
        stringbuffer.append("\n");
        return stringbuffer.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(status.name());
        parcel.writeString(pin);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public WpsResult createFromParcel(Parcel parcel) {
            WpsResult wpsresult = new WpsResult();
            wpsresult.status = Status.valueOf(parcel.readString());
            wpsresult.pin = parcel.readString();
            return wpsresult;
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public WpsResult[] newArray(int i) {
            return new WpsResult[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public String pin;
    public Status status;

}
