// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.bluetooth;

import android.os.Parcel;
import android.os.Parcelable;

public final class BluetoothClass
    implements Parcelable {
    public static class Device {
        public static class Major {

            public static final int AUDIO_VIDEO = 1024;
            private static final int BITMASK = 7936;
            public static final int COMPUTER = 256;
            public static final int HEALTH = 2304;
            public static final int IMAGING = 1536;
            public static final int MISC = 0;
            public static final int NETWORKING = 768;
            public static final int PERIPHERAL = 1280;
            public static final int PHONE = 512;
            public static final int TOY = 2048;
            public static final int UNCATEGORIZED = 7936;
            public static final int WEARABLE = 1792;

            public Major() {
            }
        }


        public static final int AUDIO_VIDEO_CAMCORDER = 1076;
        public static final int AUDIO_VIDEO_CAR_AUDIO = 1056;
        public static final int AUDIO_VIDEO_HANDSFREE = 1032;
        public static final int AUDIO_VIDEO_HEADPHONES = 1048;
        public static final int AUDIO_VIDEO_HIFI_AUDIO = 1064;
        public static final int AUDIO_VIDEO_LOUDSPEAKER = 1044;
        public static final int AUDIO_VIDEO_MICROPHONE = 1040;
        public static final int AUDIO_VIDEO_PORTABLE_AUDIO = 1052;
        public static final int AUDIO_VIDEO_SET_TOP_BOX = 1060;
        public static final int AUDIO_VIDEO_UNCATEGORIZED = 1024;
        public static final int AUDIO_VIDEO_VCR = 1068;
        public static final int AUDIO_VIDEO_VIDEO_CAMERA = 1072;
        public static final int AUDIO_VIDEO_VIDEO_CONFERENCING = 1088;
        public static final int AUDIO_VIDEO_VIDEO_DISPLAY_AND_LOUDSPEAKER = 1084;
        public static final int AUDIO_VIDEO_VIDEO_GAMING_TOY = 1096;
        public static final int AUDIO_VIDEO_VIDEO_MONITOR = 1080;
        public static final int AUDIO_VIDEO_WEARABLE_HEADSET = 1028;
        private static final int BITMASK = 8188;
        public static final int COMPUTER_DESKTOP = 260;
        public static final int COMPUTER_HANDHELD_PC_PDA = 272;
        public static final int COMPUTER_LAPTOP = 268;
        public static final int COMPUTER_PALM_SIZE_PC_PDA = 276;
        public static final int COMPUTER_SERVER = 264;
        public static final int COMPUTER_UNCATEGORIZED = 256;
        public static final int COMPUTER_WEARABLE = 280;
        public static final int HEALTH_BLOOD_PRESSURE = 2308;
        public static final int HEALTH_DATA_DISPLAY = 2332;
        public static final int HEALTH_GLUCOSE = 2320;
        public static final int HEALTH_PULSE_OXIMETER = 2324;
        public static final int HEALTH_PULSE_RATE = 2328;
        public static final int HEALTH_THERMOMETER = 2312;
        public static final int HEALTH_UNCATEGORIZED = 2304;
        public static final int HEALTH_WEIGHING = 2316;
        public static final int PERIPHERAL_KEYBOARD = 1344;
        public static final int PERIPHERAL_KEYBOARD_POINTING = 1472;
        public static final int PERIPHERAL_NON_KEYBOARD_NON_POINTING = 1280;
        public static final int PERIPHERAL_POINTING = 1408;
        public static final int PHONE_CELLULAR = 516;
        public static final int PHONE_CORDLESS = 520;
        public static final int PHONE_ISDN = 532;
        public static final int PHONE_MODEM_OR_GATEWAY = 528;
        public static final int PHONE_SMART = 524;
        public static final int PHONE_UNCATEGORIZED = 512;
        public static final int TOY_CONTROLLER = 2064;
        public static final int TOY_DOLL_ACTION_FIGURE = 2060;
        public static final int TOY_GAME = 2068;
        public static final int TOY_ROBOT = 2052;
        public static final int TOY_UNCATEGORIZED = 2048;
        public static final int TOY_VEHICLE = 2056;
        public static final int WEARABLE_GLASSES = 1812;
        public static final int WEARABLE_HELMET = 1808;
        public static final int WEARABLE_JACKET = 1804;
        public static final int WEARABLE_PAGER = 1800;
        public static final int WEARABLE_UNCATEGORIZED = 1792;
        public static final int WEARABLE_WRIST_WATCH = 1796;

        public Device() {
        }
    }

    public static final class Service {

        public static final int AUDIO = 0x200000;
        private static final int BITMASK = 0xffe000;
        public static final int CAPTURE = 0x80000;
        public static final int INFORMATION = 0x800000;
        public static final int LIMITED_DISCOVERABILITY = 8192;
        public static final int NETWORKING = 0x20000;
        public static final int OBJECT_TRANSFER = 0x100000;
        public static final int POSITIONING = 0x10000;
        public static final int RENDER = 0x40000;
        public static final int TELEPHONY = 0x400000;

        public Service() {
        }
    }


    public BluetoothClass(int i) {
        mClass = i;
    }

    public int describeContents() {
        return 0;
    }

    public boolean doesClassMatch(int i) {
        boolean flag = true;
        if(i != flag) goto _L2; else goto _L1
_L1:
        if(!hasService(0x40000))
            switch(getDeviceClass()) {
            default:
                flag = false;
                break;

            case 1044: 
            case 1048: 
            case 1056: 
            case 1064: 
                break;
            }
_L4:
        return flag;
_L2:
        if(i == 0) {
            if(!hasService(0x40000))
                switch(getDeviceClass()) {
                default:
                    flag = false;
                    break;

                case 1028: 
                case 1032: 
                case 1056: 
                    break;
                }
        } else
        if(i == 2) {
            if(!hasService(0x100000))
                switch(getDeviceClass()) {
                default:
                    flag = false;
                    break;

                case 256: 
                case 260: 
                case 264: 
                case 268: 
                case 272: 
                case 276: 
                case 280: 
                case 512: 
                case 516: 
                case 520: 
                case 524: 
                case 528: 
                case 532: 
                    break;
                }
        } else
        if(i == 3) {
            if((0x500 & getDeviceClass()) != 1280)
                flag = false;
        } else
        if(i == 4 || i == 5) {
            if(!hasService(0x20000) && (0x300 & getDeviceClass()) != 768)
                flag = false;
        } else {
            flag = false;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean equals(Object obj) {
        boolean flag = false;
        if((obj instanceof BluetoothClass) && mClass == ((BluetoothClass)obj).mClass)
            flag = true;
        return flag;
    }

    public int getDeviceClass() {
        return 0x1ffc & mClass;
    }

    public int getMajorDeviceClass() {
        return 0x1f00 & mClass;
    }

    public boolean hasService(int i) {
        boolean flag;
        if((i & (0xffe000 & mClass)) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public int hashCode() {
        return mClass;
    }

    public String toString() {
        return Integer.toHexString(mClass);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mClass);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public BluetoothClass createFromParcel(Parcel parcel) {
            return new BluetoothClass(parcel.readInt());
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public BluetoothClass[] newArray(int i) {
            return new BluetoothClass[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int ERROR = 0xff000000;
    public static final int PROFILE_A2DP = 1;
    public static final int PROFILE_HEADSET = 0;
    public static final int PROFILE_HID = 3;
    public static final int PROFILE_NAP = 5;
    public static final int PROFILE_OPP = 2;
    public static final int PROFILE_PANU = 4;
    private final int mClass;

}
