// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.res;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.LocaleUtil;
import java.util.Locale;
import miui.content.res.ExtraConfiguration;

public final class Configuration
    implements Parcelable, Comparable {

    public Configuration() {
        extraConfig = new ExtraConfiguration();
        setToDefaults();
    }

    public Configuration(Configuration configuration) {
        extraConfig = new ExtraConfiguration();
        setTo(configuration);
    }

    private Configuration(Parcel parcel) {
        extraConfig = new ExtraConfiguration();
        readFromParcel(parcel);
    }


    public static boolean needNewResources(int i, int j) {
        boolean flag;
        if((i & (0x40000000 | j)) != 0 || ExtraConfiguration.needNewResources(i))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public int compareTo(Configuration configuration) {
        float f;
        float f1;
        f = fontScale;
        f1 = configuration.fontScale;
        if(f >= f1) goto _L2; else goto _L1
_L1:
        int i = -1;
_L4:
        return i;
_L2:
        if(f > f1) {
            i = 1;
            continue; /* Loop/switch isn't completed */
        }
        i = mcc - configuration.mcc;
        if(i != 0)
            continue; /* Loop/switch isn't completed */
        i = mnc - configuration.mnc;
        if(i != 0)
            continue; /* Loop/switch isn't completed */
        if(locale == null) {
            if(configuration.locale != null) {
                i = 1;
                continue; /* Loop/switch isn't completed */
            }
        } else {
            if(configuration.locale == null) {
                i = -1;
                continue; /* Loop/switch isn't completed */
            }
            i = locale.getLanguage().compareTo(configuration.locale.getLanguage());
            if(i != 0)
                continue; /* Loop/switch isn't completed */
            i = locale.getCountry().compareTo(configuration.locale.getCountry());
            if(i != 0)
                continue; /* Loop/switch isn't completed */
            i = locale.getVariant().compareTo(configuration.locale.getVariant());
            if(i != 0)
                continue; /* Loop/switch isn't completed */
        }
        i = touchscreen - configuration.touchscreen;
        if(i == 0) {
            i = keyboard - configuration.keyboard;
            if(i == 0) {
                i = keyboardHidden - configuration.keyboardHidden;
                if(i == 0) {
                    i = hardKeyboardHidden - configuration.hardKeyboardHidden;
                    if(i == 0) {
                        i = navigation - configuration.navigation;
                        if(i == 0) {
                            i = navigationHidden - configuration.navigationHidden;
                            if(i == 0) {
                                i = orientation - configuration.orientation;
                                if(i == 0) {
                                    i = screenLayout - configuration.screenLayout;
                                    if(i == 0) {
                                        i = uiMode - configuration.uiMode;
                                        if(i == 0) {
                                            i = screenWidthDp - configuration.screenWidthDp;
                                            if(i == 0) {
                                                i = screenHeightDp - configuration.screenHeightDp;
                                                if(i == 0) {
                                                    smallestScreenWidthDp - configuration.smallestScreenWidthDp;
                                                    i = extraConfig.compareTo(configuration.extraConfig);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public volatile int compareTo(Object obj) {
        return compareTo((Configuration)obj);
    }

    public int describeContents() {
        return 0;
    }

    public int diff(Configuration configuration) {
        int i = 0;
        if(configuration.fontScale > 0.0F && fontScale != configuration.fontScale)
            i = 0 | 0x40000000;
        if(configuration.mcc != 0 && mcc != configuration.mcc)
            i |= 1;
        if(configuration.mnc != 0 && mnc != configuration.mnc)
            i |= 2;
        if(configuration.locale != null && (locale == null || !locale.equals(configuration.locale)))
            i |= 4;
        if(configuration.touchscreen != 0 && touchscreen != configuration.touchscreen)
            i |= 8;
        if(configuration.keyboard != 0 && keyboard != configuration.keyboard)
            i |= 0x10;
        if(configuration.keyboardHidden != 0 && keyboardHidden != configuration.keyboardHidden)
            i |= 0x20;
        if(configuration.hardKeyboardHidden != 0 && hardKeyboardHidden != configuration.hardKeyboardHidden)
            i |= 0x20;
        if(configuration.navigation != 0 && navigation != configuration.navigation)
            i |= 0x40;
        if(configuration.navigationHidden != 0 && navigationHidden != configuration.navigationHidden)
            i |= 0x20;
        if(configuration.orientation != 0 && orientation != configuration.orientation)
            i |= 0x80;
        if(configuration.screenLayout != 0 && screenLayout != configuration.screenLayout)
            i |= 0x100;
        if(configuration.uiMode != 0 && uiMode != configuration.uiMode)
            i |= 0x200;
        if(configuration.screenWidthDp != 0 && screenWidthDp != configuration.screenWidthDp)
            i |= 0x400;
        if(configuration.screenHeightDp != 0 && screenHeightDp != configuration.screenHeightDp)
            i |= 0x400;
        if(configuration.smallestScreenWidthDp != 0 && smallestScreenWidthDp != configuration.smallestScreenWidthDp)
            i |= 0x800;
        return i | extraConfig.diff(configuration.extraConfig);
    }

    public boolean equals(Configuration configuration) {
        boolean flag = true;
        if(configuration != null) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        return flag;
_L2:
        if(configuration != this && compareTo(configuration) != 0)
            flag = false;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public boolean equals(Object obj) {
        boolean flag1 = equals((Configuration)obj);
        boolean flag = flag1;
_L2:
        return flag;
        ClassCastException classcastexception;
        classcastexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int hashCode() {
        int i = 31 * (31 * (31 * (527 + Float.floatToIntBits(fontScale)) + mcc) + mnc);
        int j;
        if(locale != null)
            j = locale.hashCode();
        else
            j = 0;
        return 31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (i + j) + touchscreen) + keyboard) + keyboardHidden) + hardKeyboardHidden) + navigation) + navigationHidden) + orientation) + screenLayout) + uiMode) + screenWidthDp) + screenHeightDp) + smallestScreenWidthDp + extraConfig.hashCode();
    }

    public boolean isLayoutSizeAtLeast(int i) {
        boolean flag;
        int j;
        flag = false;
        j = 0xf & screenLayout;
        break MISSING_BLOCK_LABEL_10;
        if(j != 0 && j >= i)
            flag = true;
        return flag;
    }

    public boolean isOtherSeqNewer(Configuration configuration) {
        boolean flag = true;
        if(configuration != null) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        return flag;
_L2:
        if(configuration.seq != 0 && seq != 0) {
            int i = configuration.seq - seq;
            if(i > 0x10000)
                flag = false;
            else
            if(i <= 0)
                flag = false;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public void makeDefault() {
        setToDefaults();
    }

    public void readFromParcel(Parcel parcel) {
        boolean flag = true;
        fontScale = parcel.readFloat();
        mcc = parcel.readInt();
        mnc = parcel.readInt();
        if(parcel.readInt() != 0)
            locale = new Locale(parcel.readString(), parcel.readString(), parcel.readString());
        if(parcel.readInt() != flag)
            flag = false;
        userSetLocale = flag;
        touchscreen = parcel.readInt();
        keyboard = parcel.readInt();
        keyboardHidden = parcel.readInt();
        hardKeyboardHidden = parcel.readInt();
        navigation = parcel.readInt();
        navigationHidden = parcel.readInt();
        orientation = parcel.readInt();
        screenLayout = parcel.readInt();
        uiMode = parcel.readInt();
        screenWidthDp = parcel.readInt();
        screenHeightDp = parcel.readInt();
        smallestScreenWidthDp = parcel.readInt();
        compatScreenWidthDp = parcel.readInt();
        compatScreenHeightDp = parcel.readInt();
        compatSmallestScreenWidthDp = parcel.readInt();
        layoutDirection = parcel.readInt();
        seq = parcel.readInt();
        extraConfig.readFromParcel(parcel);
    }

    public void setTo(Configuration configuration) {
        fontScale = configuration.fontScale;
        mcc = configuration.mcc;
        mnc = configuration.mnc;
        if(configuration.locale != null) {
            locale = (Locale)configuration.locale.clone();
            layoutDirection = configuration.layoutDirection;
        }
        userSetLocale = configuration.userSetLocale;
        touchscreen = configuration.touchscreen;
        keyboard = configuration.keyboard;
        keyboardHidden = configuration.keyboardHidden;
        hardKeyboardHidden = configuration.hardKeyboardHidden;
        navigation = configuration.navigation;
        navigationHidden = configuration.navigationHidden;
        orientation = configuration.orientation;
        screenLayout = configuration.screenLayout;
        uiMode = configuration.uiMode;
        screenWidthDp = configuration.screenWidthDp;
        screenHeightDp = configuration.screenHeightDp;
        smallestScreenWidthDp = configuration.smallestScreenWidthDp;
        compatScreenWidthDp = configuration.compatScreenWidthDp;
        compatScreenHeightDp = configuration.compatScreenHeightDp;
        compatSmallestScreenWidthDp = configuration.compatSmallestScreenWidthDp;
        seq = configuration.seq;
        extraConfig.setTo(configuration.extraConfig);
    }

    public void setToDefaults() {
        fontScale = 1.0F;
        mnc = 0;
        mcc = 0;
        locale = null;
        userSetLocale = false;
        touchscreen = 0;
        keyboard = 0;
        keyboardHidden = 0;
        hardKeyboardHidden = 0;
        navigation = 0;
        navigationHidden = 0;
        orientation = 0;
        screenLayout = 0;
        uiMode = 0;
        compatScreenWidthDp = 0;
        screenWidthDp = 0;
        compatScreenHeightDp = 0;
        screenHeightDp = 0;
        compatSmallestScreenWidthDp = 0;
        smallestScreenWidthDp = 0;
        layoutDirection = 0;
        seq = 0;
        extraConfig.setToDefaults();
    }

    public String toString() {
        StringBuilder stringbuilder;
        stringbuilder = new StringBuilder(128);
        stringbuilder.append("{");
        stringbuilder.append(fontScale);
        stringbuilder.append(" ");
        stringbuilder.append(mcc);
        stringbuilder.append("mcc");
        stringbuilder.append(mnc);
        stringbuilder.append("mnc");
        if(locale != null) {
            stringbuilder.append(" ");
            stringbuilder.append(locale);
        } else {
            stringbuilder.append(" (no locale)");
        }
        layoutDirection;
        JVM INSTR tableswitch 0 1: default 120
    //                   0 137
    //                   1 900;
           goto _L1 _L2 _L3
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        stringbuilder.append(" layoutDir=");
        stringbuilder.append(layoutDirection);
_L58:
        if(smallestScreenWidthDp != 0) {
            stringbuilder.append(" sw");
            stringbuilder.append(smallestScreenWidthDp);
            stringbuilder.append("dp");
        } else {
            stringbuilder.append(" ?swdp");
        }
        if(screenWidthDp != 0) {
            stringbuilder.append(" w");
            stringbuilder.append(screenWidthDp);
            stringbuilder.append("dp");
        } else {
            stringbuilder.append(" ?wdp");
        }
        if(screenHeightDp != 0) {
            stringbuilder.append(" h");
            stringbuilder.append(screenHeightDp);
            stringbuilder.append("dp");
        } else {
            stringbuilder.append(" ?hdp");
        }
        0xf & screenLayout;
        JVM INSTR tableswitch 0 4: default 276
    //                   0 944
    //                   1 955
    //                   2 966
    //                   3 977
    //                   4 988;
           goto _L4 _L5 _L6 _L7 _L8 _L9
_L4:
        stringbuilder.append(" layoutSize=");
        stringbuilder.append(0xf & screenLayout);
_L59:
        0x30 & screenLayout;
        JVM INSTR lookupswitch 3: default 336
    //                   0: 999
    //                   16: 356
    //                   32: 1010;
           goto _L10 _L11 _L12 _L13
_L10:
        stringbuilder.append(" layoutLong=");
        stringbuilder.append(0x30 & screenLayout);
_L12:
        orientation;
        JVM INSTR tableswitch 0 2: default 388
    //                   0 1021
    //                   1 1043
    //                   2 1032;
           goto _L14 _L15 _L16 _L17
_L14:
        stringbuilder.append(" orien=");
        stringbuilder.append(orientation);
_L60:
        0xf & uiMode;
        JVM INSTR tableswitch 0 5: default 452
    //                   0 1054
    //                   1 472
    //                   2 1065
    //                   3 1076
    //                   4 1087
    //                   5 1098;
           goto _L18 _L19 _L20 _L21 _L22 _L23 _L24
_L18:
        stringbuilder.append(" uimode=");
        stringbuilder.append(0xf & uiMode);
_L20:
        0x30 & uiMode;
        JVM INSTR lookupswitch 3: default 512
    //                   0: 1109
    //                   16: 532
    //                   32: 1120;
           goto _L25 _L26 _L27 _L28
_L25:
        stringbuilder.append(" night=");
        stringbuilder.append(0x30 & uiMode);
_L27:
        touchscreen;
        JVM INSTR tableswitch 0 3: default 568
    //                   0 1131
    //                   1 1142
    //                   2 1153
    //                   3 1164;
           goto _L29 _L30 _L31 _L32 _L33
_L29:
        stringbuilder.append(" touch=");
        stringbuilder.append(touchscreen);
_L61:
        keyboard;
        JVM INSTR tableswitch 0 3: default 620
    //                   0 1175
    //                   1 1186
    //                   2 1197
    //                   3 1208;
           goto _L34 _L35 _L36 _L37 _L38
_L34:
        stringbuilder.append(" keys=");
        stringbuilder.append(keyboard);
_L62:
        keyboardHidden;
        JVM INSTR tableswitch 0 3: default 672
    //                   0 1219
    //                   1 1230
    //                   2 1241
    //                   3 1252;
           goto _L39 _L40 _L41 _L42 _L43
_L39:
        stringbuilder.append("/");
        stringbuilder.append(keyboardHidden);
_L63:
        hardKeyboardHidden;
        JVM INSTR tableswitch 0 2: default 720
    //                   0 1263
    //                   1 1274
    //                   2 1285;
           goto _L44 _L45 _L46 _L47
_L44:
        stringbuilder.append("/");
        stringbuilder.append(hardKeyboardHidden);
_L64:
        navigation;
        JVM INSTR tableswitch 0 4: default 776
    //                   0 1296
    //                   1 1307
    //                   2 1318
    //                   3 1329
    //                   4 1340;
           goto _L48 _L49 _L50 _L51 _L52 _L53
_L48:
        stringbuilder.append(" nav=");
        stringbuilder.append(navigation);
_L65:
        navigationHidden;
        JVM INSTR tableswitch 0 2: default 824
    //                   0 1351
    //                   1 1362
    //                   2 1373;
           goto _L54 _L55 _L56 _L57
_L54:
        stringbuilder.append("/");
        stringbuilder.append(navigationHidden);
_L66:
        if(seq != 0) {
            stringbuilder.append(" s.");
            stringbuilder.append(seq);
        }
        stringbuilder.append(extraConfig.toString());
        stringbuilder.append('}');
        return stringbuilder.toString();
_L3:
        stringbuilder.append(" rtl");
          goto _L58
_L5:
        stringbuilder.append(" ?lsize");
          goto _L59
_L6:
        stringbuilder.append(" smll");
          goto _L59
_L7:
        stringbuilder.append(" nrml");
          goto _L59
_L8:
        stringbuilder.append(" lrg");
          goto _L59
_L9:
        stringbuilder.append(" xlrg");
          goto _L59
_L11:
        stringbuilder.append(" ?long");
          goto _L12
_L13:
        stringbuilder.append(" long");
          goto _L12
_L15:
        stringbuilder.append(" ?orien");
          goto _L60
_L17:
        stringbuilder.append(" land");
          goto _L60
_L16:
        stringbuilder.append(" port");
          goto _L60
_L19:
        stringbuilder.append(" ?uimode");
          goto _L20
_L21:
        stringbuilder.append(" desk");
          goto _L20
_L22:
        stringbuilder.append(" car");
          goto _L20
_L23:
        stringbuilder.append(" television");
          goto _L20
_L24:
        stringbuilder.append(" appliance");
          goto _L20
_L26:
        stringbuilder.append(" ?night");
          goto _L27
_L28:
        stringbuilder.append(" night");
          goto _L27
_L30:
        stringbuilder.append(" ?touch");
          goto _L61
_L31:
        stringbuilder.append(" -touch");
          goto _L61
_L32:
        stringbuilder.append(" stylus");
          goto _L61
_L33:
        stringbuilder.append(" finger");
          goto _L61
_L35:
        stringbuilder.append(" ?keyb");
          goto _L62
_L36:
        stringbuilder.append(" -keyb");
          goto _L62
_L37:
        stringbuilder.append(" qwerty");
          goto _L62
_L38:
        stringbuilder.append(" 12key");
          goto _L62
_L40:
        stringbuilder.append("/?");
          goto _L63
_L41:
        stringbuilder.append("/v");
          goto _L63
_L42:
        stringbuilder.append("/h");
          goto _L63
_L43:
        stringbuilder.append("/s");
          goto _L63
_L45:
        stringbuilder.append("/?");
          goto _L64
_L46:
        stringbuilder.append("/v");
          goto _L64
_L47:
        stringbuilder.append("/h");
          goto _L64
_L49:
        stringbuilder.append(" ?nav");
          goto _L65
_L50:
        stringbuilder.append(" -nav");
          goto _L65
_L51:
        stringbuilder.append(" dpad");
          goto _L65
_L52:
        stringbuilder.append(" tball");
          goto _L65
_L53:
        stringbuilder.append(" wheel");
          goto _L65
_L55:
        stringbuilder.append("/?");
          goto _L66
_L56:
        stringbuilder.append("/v");
          goto _L66
_L57:
        stringbuilder.append("/h");
          goto _L66
    }

    public int updateFrom(Configuration configuration) {
        int i = 0;
        if(configuration.fontScale > 0.0F && fontScale != configuration.fontScale) {
            i = 0 | 0x40000000;
            fontScale = configuration.fontScale;
        }
        if(configuration.mcc != 0 && mcc != configuration.mcc) {
            i |= 1;
            mcc = configuration.mcc;
        }
        if(configuration.mnc != 0 && mnc != configuration.mnc) {
            i |= 2;
            mnc = configuration.mnc;
        }
        if(configuration.locale != null && (locale == null || !locale.equals(configuration.locale))) {
            i |= 4;
            Locale locale1;
            if(configuration.locale != null)
                locale1 = (Locale)configuration.locale.clone();
            else
                locale1 = null;
            locale = locale1;
            layoutDirection = LocaleUtil.getLayoutDirectionFromLocale(locale);
        }
        if(configuration.userSetLocale && (!userSetLocale || (i & 4) != 0)) {
            userSetLocale = true;
            i |= 4;
        }
        if(configuration.touchscreen != 0 && touchscreen != configuration.touchscreen) {
            i |= 8;
            touchscreen = configuration.touchscreen;
        }
        if(configuration.keyboard != 0 && keyboard != configuration.keyboard) {
            i |= 0x10;
            keyboard = configuration.keyboard;
        }
        if(configuration.keyboardHidden != 0 && keyboardHidden != configuration.keyboardHidden) {
            i |= 0x20;
            keyboardHidden = configuration.keyboardHidden;
        }
        if(configuration.hardKeyboardHidden != 0 && hardKeyboardHidden != configuration.hardKeyboardHidden) {
            i |= 0x20;
            hardKeyboardHidden = configuration.hardKeyboardHidden;
        }
        if(configuration.navigation != 0 && navigation != configuration.navigation) {
            i |= 0x40;
            navigation = configuration.navigation;
        }
        if(configuration.navigationHidden != 0 && navigationHidden != configuration.navigationHidden) {
            i |= 0x20;
            navigationHidden = configuration.navigationHidden;
        }
        if(configuration.orientation != 0 && orientation != configuration.orientation) {
            i |= 0x80;
            orientation = configuration.orientation;
        }
        if(configuration.screenLayout != 0 && screenLayout != configuration.screenLayout) {
            i |= 0x100;
            screenLayout = configuration.screenLayout;
        }
        if(configuration.uiMode != 0 && uiMode != configuration.uiMode) {
            i |= 0x200;
            if((0xf & configuration.uiMode) != 0)
                uiMode = 0xfffffff0 & uiMode | 0xf & configuration.uiMode;
            if((0x30 & configuration.uiMode) != 0)
                uiMode = 0xffffffcf & uiMode | 0x30 & configuration.uiMode;
        }
        if(configuration.screenWidthDp != 0 && screenWidthDp != configuration.screenWidthDp) {
            i |= 0x400;
            screenWidthDp = configuration.screenWidthDp;
        }
        if(configuration.screenHeightDp != 0 && screenHeightDp != configuration.screenHeightDp) {
            i |= 0x400;
            screenHeightDp = configuration.screenHeightDp;
        }
        if(configuration.smallestScreenWidthDp != 0)
            smallestScreenWidthDp = configuration.smallestScreenWidthDp;
        if(configuration.compatScreenWidthDp != 0)
            compatScreenWidthDp = configuration.compatScreenWidthDp;
        if(configuration.compatScreenHeightDp != 0)
            compatScreenHeightDp = configuration.compatScreenHeightDp;
        if(configuration.compatSmallestScreenWidthDp != 0)
            compatSmallestScreenWidthDp = configuration.compatSmallestScreenWidthDp;
        if(configuration.seq != 0)
            seq = configuration.seq;
        return i | extraConfig.updateFrom(configuration.extraConfig);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(fontScale);
        parcel.writeInt(mcc);
        parcel.writeInt(mnc);
        if(locale == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(locale.getLanguage());
            parcel.writeString(locale.getCountry());
            parcel.writeString(locale.getVariant());
        }
        if(userSetLocale)
            parcel.writeInt(1);
        else
            parcel.writeInt(0);
        parcel.writeInt(touchscreen);
        parcel.writeInt(keyboard);
        parcel.writeInt(keyboardHidden);
        parcel.writeInt(hardKeyboardHidden);
        parcel.writeInt(navigation);
        parcel.writeInt(navigationHidden);
        parcel.writeInt(orientation);
        parcel.writeInt(screenLayout);
        parcel.writeInt(uiMode);
        parcel.writeInt(screenWidthDp);
        parcel.writeInt(screenHeightDp);
        parcel.writeInt(smallestScreenWidthDp);
        parcel.writeInt(compatScreenWidthDp);
        parcel.writeInt(compatScreenHeightDp);
        parcel.writeInt(compatSmallestScreenWidthDp);
        parcel.writeInt(layoutDirection);
        parcel.writeInt(seq);
        extraConfig.writeToParcel(parcel, i);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Configuration createFromParcel(Parcel parcel) {
            return new Configuration(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public Configuration[] newArray(int i) {
            return new Configuration[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int HARDKEYBOARDHIDDEN_NO = 1;
    public static final int HARDKEYBOARDHIDDEN_UNDEFINED = 0;
    public static final int HARDKEYBOARDHIDDEN_YES = 2;
    public static final int KEYBOARDHIDDEN_NO = 1;
    public static final int KEYBOARDHIDDEN_SOFT = 3;
    public static final int KEYBOARDHIDDEN_UNDEFINED = 0;
    public static final int KEYBOARDHIDDEN_YES = 2;
    public static final int KEYBOARD_12KEY = 3;
    public static final int KEYBOARD_NOKEYS = 1;
    public static final int KEYBOARD_QWERTY = 2;
    public static final int KEYBOARD_UNDEFINED = 0;
    public static final int NAVIGATIONHIDDEN_NO = 1;
    public static final int NAVIGATIONHIDDEN_UNDEFINED = 0;
    public static final int NAVIGATIONHIDDEN_YES = 2;
    public static final int NAVIGATION_DPAD = 2;
    public static final int NAVIGATION_NONAV = 1;
    public static final int NAVIGATION_TRACKBALL = 3;
    public static final int NAVIGATION_UNDEFINED = 0;
    public static final int NAVIGATION_WHEEL = 4;
    public static final int ORIENTATION_LANDSCAPE = 2;
    public static final int ORIENTATION_PORTRAIT = 1;
    public static final int ORIENTATION_SQUARE = 3;
    public static final int ORIENTATION_UNDEFINED = 0;
    public static final int SCREENLAYOUT_COMPAT_NEEDED = 0x10000000;
    public static final int SCREENLAYOUT_LONG_MASK = 48;
    public static final int SCREENLAYOUT_LONG_NO = 16;
    public static final int SCREENLAYOUT_LONG_UNDEFINED = 0;
    public static final int SCREENLAYOUT_LONG_YES = 32;
    public static final int SCREENLAYOUT_SIZE_LARGE = 3;
    public static final int SCREENLAYOUT_SIZE_MASK = 15;
    public static final int SCREENLAYOUT_SIZE_NORMAL = 2;
    public static final int SCREENLAYOUT_SIZE_SMALL = 1;
    public static final int SCREENLAYOUT_SIZE_UNDEFINED = 0;
    public static final int SCREENLAYOUT_SIZE_XLARGE = 4;
    public static final int SCREEN_HEIGHT_DP_UNDEFINED = 0;
    public static final int SCREEN_WIDTH_DP_UNDEFINED = 0;
    public static final int SMALLEST_SCREEN_WIDTH_DP_UNDEFINED = 0;
    public static final int TOUCHSCREEN_FINGER = 3;
    public static final int TOUCHSCREEN_NOTOUCH = 1;
    public static final int TOUCHSCREEN_STYLUS = 2;
    public static final int TOUCHSCREEN_UNDEFINED = 0;
    public static final int UI_MODE_NIGHT_MASK = 48;
    public static final int UI_MODE_NIGHT_NO = 16;
    public static final int UI_MODE_NIGHT_UNDEFINED = 0;
    public static final int UI_MODE_NIGHT_YES = 32;
    public static final int UI_MODE_TYPE_APPLIANCE = 5;
    public static final int UI_MODE_TYPE_CAR = 3;
    public static final int UI_MODE_TYPE_DESK = 2;
    public static final int UI_MODE_TYPE_MASK = 15;
    public static final int UI_MODE_TYPE_NORMAL = 1;
    public static final int UI_MODE_TYPE_SCALE_HUGE = 15;
    public static final int UI_MODE_TYPE_SCALE_LARGE = 14;
    public static final int UI_MODE_TYPE_SCALE_MEDIUM = 13;
    public static final int UI_MODE_TYPE_SCALE_SMALL = 12;
    public static final int UI_MODE_TYPE_TELEVISION = 4;
    public static final int UI_MODE_TYPE_UNDEFINED;
    public int compatScreenHeightDp;
    public int compatScreenWidthDp;
    public int compatSmallestScreenWidthDp;
    public ExtraConfiguration extraConfig;
    public float fontScale;
    public int hardKeyboardHidden;
    public int keyboard;
    public int keyboardHidden;
    public int layoutDirection;
    public Locale locale;
    public int mcc;
    public int mnc;
    public int navigation;
    public int navigationHidden;
    public int orientation;
    public int screenHeightDp;
    public int screenLayout;
    public int screenWidthDp;
    public int seq;
    public int smallestScreenWidthDp;
    public int touchscreen;
    public int uiMode;
    public boolean userSetLocale;

}
