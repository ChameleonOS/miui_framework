// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.app.*;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.net.wifi.WifiManager;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Log;
import java.util.*;
import libcore.icu.TimeZones;

// Referenced classes of package com.android.internal.telephony:
//            BaseCommands

public final class MccTable {
    static class MccEntry
        implements Comparable {

        public int compareTo(MccEntry mccentry) {
            return mcc - mccentry.mcc;
        }

        public volatile int compareTo(Object obj) {
            return compareTo((MccEntry)obj);
        }

        String iso;
        String language;
        int mcc;
        int smallestDigitsMnc;

        MccEntry(int i, String s, int j) {
            this(i, s, j, null);
        }

        MccEntry(int i, String s, int j, String s1) {
            mcc = i;
            iso = s;
            smallestDigitsMnc = j;
            language = s1;
        }
    }


    public MccTable() {
    }

    public static String countryCodeForMcc(int i) {
        MccEntry mccentry = entryForMcc(i);
        String s;
        if(mccentry == null)
            s = "";
        else
            s = mccentry.iso;
        return s;
    }

    public static String defaultLanguageForMcc(int i) {
        MccEntry mccentry = entryForMcc(i);
        String s;
        if(mccentry == null)
            s = null;
        else
            s = mccentry.language;
        return s;
    }

    public static String defaultTimeZoneForMcc(int i) {
        String s;
        MccEntry mccentry;
        s = null;
        mccentry = entryForMcc(i);
        if(mccentry != null && mccentry.iso != null) goto _L2; else goto _L1
_L1:
        return s;
_L2:
        Locale locale;
        String as[];
        if(mccentry.language == null)
            locale = new Locale(mccentry.iso);
        else
            locale = new Locale(mccentry.language, mccentry.iso);
        as = TimeZones.forLocale(locale);
        if(as.length != 0)
            s = as[0];
        if(true) goto _L1; else goto _L3
_L3:
    }

    private static MccEntry entryForMcc(int i) {
        MccEntry mccentry = null;
        MccEntry mccentry1 = new MccEntry(i, null, 0);
        int j = Collections.binarySearch(table, mccentry1);
        if(j >= 0)
            mccentry = (MccEntry)table.get(j);
        return mccentry;
    }

    private static void setLocaleFromMccIfNeeded(Context context, int i) {
        if(BaseCommands.getLteOnCdmaModeStatic() != 1) {
            String s = defaultLanguageForMcc(i);
            String s1 = countryCodeForMcc(i);
            Log.d("MccTable", (new StringBuilder()).append("locale set to ").append(s).append("_").append(s1).toString());
            setSystemLocale(context, s, s1);
        }
    }

    public static void setSystemLocale(Context context, String s, String s1) {
        String s2;
        String s3;
        s2 = SystemProperties.get("persist.sys.language");
        s3 = SystemProperties.get("persist.sys.country");
        if(s != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s4;
        String s5;
        s4 = s.toLowerCase();
        if(s1 == null)
            s1 = "";
        s5 = s1.toUpperCase();
        if(s2 != null && s2.length() != 0 || s3 != null && s3.length() != 0)
            continue; /* Loop/switch isn't completed */
        String as[];
        int i;
        String s6;
        int j;
        as = context.getAssets().getLocales();
        i = as.length;
        s6 = null;
        j = 0;
_L7:
        if(j >= i) goto _L4; else goto _L3
_L3:
        if(as[j] == null || as[j].length() < 5 || !as[j].substring(0, 2).equals(s4))
            break MISSING_BLOCK_LABEL_228;
        if(!as[j].substring(3, 5).equals(s5)) goto _L6; else goto _L5
_L5:
        s6 = as[j];
_L4:
        if(s6 != null) {
            IActivityManager iactivitymanager = ActivityManagerNative.getDefault();
            Configuration configuration = iactivitymanager.getConfiguration();
            configuration.locale = new Locale(s6.substring(0, 2), s6.substring(3, 5));
            configuration.userSetLocale = true;
            iactivitymanager.updateConfiguration(configuration);
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if(s6 == null)
            s6 = as[j];
        j++;
          goto _L7
        Exception exception;
        exception;
        if(true) goto _L1; else goto _L8
_L8:
    }

    private static void setTimezoneFromMccIfNeeded(Context context, int i) {
        String s = SystemProperties.get("persist.sys.timezone");
        if(s == null || s.length() == 0) {
            String s1 = defaultTimeZoneForMcc(i);
            if(s1 != null && s1.length() > 0) {
                ((AlarmManager)context.getSystemService("alarm")).setTimeZone(s1);
                Log.d("MccTable", (new StringBuilder()).append("timezone set to ").append(s1).toString());
            }
        }
    }

    private static void setWifiCountryCodeFromMcc(Context context, int i) {
        String s = countryCodeForMcc(i);
        if(!s.isEmpty()) {
            Log.d("MccTable", (new StringBuilder()).append("WIFI_COUNTRY_CODE set to ").append(s).toString());
            ((WifiManager)context.getSystemService("wifi")).setCountryCode(s, true);
        }
    }

    public static int smallestDigitsMccForMnc(int i) {
        MccEntry mccentry = entryForMcc(i);
        int j;
        if(mccentry == null)
            j = 2;
        else
            j = mccentry.smallestDigitsMnc;
        return j;
    }

    public static void updateMccMncConfiguration(Context context, String s) {
        if(TextUtils.isEmpty(s))
            break MISSING_BLOCK_LABEL_133;
        int i;
        int j;
        i = Integer.parseInt(s.substring(0, 3));
        j = Integer.parseInt(s.substring(3));
        Log.d("MccTable", (new StringBuilder()).append("updateMccMncConfiguration: mcc=").append(i).append(", mnc=").append(j).toString());
        if(i != 0) {
            setTimezoneFromMccIfNeeded(context, i);
            setLocaleFromMccIfNeeded(context, i);
            setWifiCountryCodeFromMcc(context, i);
        }
        Configuration configuration = ActivityManagerNative.getDefault().getConfiguration();
        if(i != 0)
            configuration.mcc = i;
        if(j != 0)
            configuration.mnc = j;
        ActivityManagerNative.getDefault().updateConfiguration(configuration);
_L1:
        return;
        NumberFormatException numberformatexception;
        numberformatexception;
        Log.e("MccTable", "Error parsing IMSI");
          goto _L1
        RemoteException remoteexception;
        remoteexception;
        Log.e("MccTable", "Can't update configuration", remoteexception);
          goto _L1
    }

    static final String LOG_TAG = "MccTable";
    static ArrayList table;

    static  {
        table = new ArrayList(240);
        table.add(new MccEntry(202, "gr", 2));
        table.add(new MccEntry(204, "nl", 2, "nl"));
        table.add(new MccEntry(206, "be", 2));
        table.add(new MccEntry(208, "fr", 2, "fr"));
        table.add(new MccEntry(212, "mc", 2));
        table.add(new MccEntry(213, "ad", 2));
        table.add(new MccEntry(214, "es", 2, "es"));
        table.add(new MccEntry(216, "hu", 2));
        table.add(new MccEntry(218, "ba", 2));
        table.add(new MccEntry(219, "hr", 2));
        table.add(new MccEntry(220, "rs", 2));
        table.add(new MccEntry(222, "it", 2, "it"));
        table.add(new MccEntry(225, "va", 2, "it"));
        table.add(new MccEntry(226, "ro", 2));
        table.add(new MccEntry(228, "ch", 2, "de"));
        table.add(new MccEntry(230, "cz", 2, "cs"));
        table.add(new MccEntry(231, "sk", 2));
        table.add(new MccEntry(232, "at", 2, "de"));
        table.add(new MccEntry(234, "gb", 2, "en"));
        table.add(new MccEntry(235, "gb", 2, "en"));
        table.add(new MccEntry(238, "dk", 2));
        table.add(new MccEntry(240, "se", 2));
        table.add(new MccEntry(242, "no", 2));
        table.add(new MccEntry(244, "fi", 2));
        table.add(new MccEntry(246, "lt", 2));
        table.add(new MccEntry(247, "lv", 2));
        table.add(new MccEntry(248, "ee", 2));
        table.add(new MccEntry(250, "ru", 2));
        table.add(new MccEntry(255, "ua", 2));
        table.add(new MccEntry(257, "by", 2));
        table.add(new MccEntry(259, "md", 2));
        table.add(new MccEntry(260, "pl", 2));
        table.add(new MccEntry(262, "de", 2, "de"));
        table.add(new MccEntry(266, "gi", 2));
        table.add(new MccEntry(268, "pt", 2));
        table.add(new MccEntry(270, "lu", 2));
        table.add(new MccEntry(272, "ie", 2, "en"));
        table.add(new MccEntry(274, "is", 2));
        table.add(new MccEntry(276, "al", 2));
        table.add(new MccEntry(278, "mt", 2));
        table.add(new MccEntry(280, "cy", 2));
        table.add(new MccEntry(282, "ge", 2));
        table.add(new MccEntry(283, "am", 2));
        table.add(new MccEntry(284, "bg", 2));
        table.add(new MccEntry(286, "tr", 2));
        table.add(new MccEntry(288, "fo", 2));
        table.add(new MccEntry(289, "ge", 2));
        table.add(new MccEntry(290, "gl", 2));
        table.add(new MccEntry(292, "sm", 2));
        table.add(new MccEntry(293, "si", 2));
        table.add(new MccEntry(294, "mk", 2));
        table.add(new MccEntry(295, "li", 2));
        table.add(new MccEntry(297, "me", 2));
        table.add(new MccEntry(302, "ca", 3, ""));
        table.add(new MccEntry(308, "pm", 2));
        table.add(new MccEntry(310, "us", 3, "en"));
        table.add(new MccEntry(311, "us", 3, "en"));
        table.add(new MccEntry(312, "us", 3, "en"));
        table.add(new MccEntry(313, "us", 3, "en"));
        table.add(new MccEntry(314, "us", 3, "en"));
        table.add(new MccEntry(315, "us", 3, "en"));
        table.add(new MccEntry(316, "us", 3, "en"));
        table.add(new MccEntry(330, "pr", 2));
        table.add(new MccEntry(332, "vi", 2));
        table.add(new MccEntry(334, "mx", 3));
        table.add(new MccEntry(338, "jm", 3));
        table.add(new MccEntry(340, "gp", 2));
        table.add(new MccEntry(342, "bb", 3));
        table.add(new MccEntry(344, "ag", 3));
        table.add(new MccEntry(346, "ky", 3));
        table.add(new MccEntry(348, "vg", 3));
        table.add(new MccEntry(350, "bm", 2));
        table.add(new MccEntry(352, "gd", 2));
        table.add(new MccEntry(354, "ms", 2));
        table.add(new MccEntry(356, "kn", 2));
        table.add(new MccEntry(358, "lc", 2));
        table.add(new MccEntry(360, "vc", 2));
        table.add(new MccEntry(362, "ai", 2));
        table.add(new MccEntry(363, "aw", 2));
        table.add(new MccEntry(364, "bs", 2));
        table.add(new MccEntry(365, "ai", 3));
        table.add(new MccEntry(366, "dm", 2));
        table.add(new MccEntry(368, "cu", 2));
        table.add(new MccEntry(370, "do", 2));
        table.add(new MccEntry(372, "ht", 2));
        table.add(new MccEntry(374, "tt", 2));
        table.add(new MccEntry(376, "tc", 2));
        table.add(new MccEntry(400, "az", 2));
        table.add(new MccEntry(401, "kz", 2));
        table.add(new MccEntry(402, "bt", 2));
        table.add(new MccEntry(404, "in", 2));
        table.add(new MccEntry(405, "in", 2));
        table.add(new MccEntry(410, "pk", 2));
        table.add(new MccEntry(412, "af", 2));
        table.add(new MccEntry(413, "lk", 2));
        table.add(new MccEntry(414, "mm", 2));
        table.add(new MccEntry(415, "lb", 2));
        table.add(new MccEntry(416, "jo", 2));
        table.add(new MccEntry(417, "sy", 2));
        table.add(new MccEntry(418, "iq", 2));
        table.add(new MccEntry(419, "kw", 2));
        table.add(new MccEntry(420, "sa", 2));
        table.add(new MccEntry(421, "ye", 2));
        table.add(new MccEntry(422, "om", 2));
        table.add(new MccEntry(423, "ps", 2));
        table.add(new MccEntry(424, "ae", 2));
        table.add(new MccEntry(425, "il", 2));
        table.add(new MccEntry(426, "bh", 2));
        table.add(new MccEntry(427, "qa", 2));
        table.add(new MccEntry(428, "mn", 2));
        table.add(new MccEntry(429, "np", 2));
        table.add(new MccEntry(430, "ae", 2));
        table.add(new MccEntry(431, "ae", 2));
        table.add(new MccEntry(432, "ir", 2));
        table.add(new MccEntry(434, "uz", 2));
        table.add(new MccEntry(436, "tj", 2));
        table.add(new MccEntry(437, "kg", 2));
        table.add(new MccEntry(438, "tm", 2));
        table.add(new MccEntry(440, "jp", 2, "ja"));
        table.add(new MccEntry(441, "jp", 2, "ja"));
        table.add(new MccEntry(450, "kr", 2, "ko"));
        table.add(new MccEntry(452, "vn", 2));
        table.add(new MccEntry(454, "hk", 2));
        table.add(new MccEntry(455, "mo", 2));
        table.add(new MccEntry(456, "kh", 2));
        table.add(new MccEntry(457, "la", 2));
        table.add(new MccEntry(460, "cn", 2, "zh"));
        table.add(new MccEntry(461, "cn", 2, "zh"));
        table.add(new MccEntry(466, "tw", 2));
        table.add(new MccEntry(467, "kp", 2));
        table.add(new MccEntry(470, "bd", 2));
        table.add(new MccEntry(472, "mv", 2));
        table.add(new MccEntry(502, "my", 2));
        table.add(new MccEntry(505, "au", 2, "en"));
        table.add(new MccEntry(510, "id", 2));
        table.add(new MccEntry(514, "tl", 2));
        table.add(new MccEntry(515, "ph", 2));
        table.add(new MccEntry(520, "th", 2));
        table.add(new MccEntry(525, "sg", 2, "en"));
        table.add(new MccEntry(528, "bn", 2));
        table.add(new MccEntry(530, "nz", 2, "en"));
        table.add(new MccEntry(534, "mp", 2));
        table.add(new MccEntry(535, "gu", 2));
        table.add(new MccEntry(536, "nr", 2));
        table.add(new MccEntry(537, "pg", 2));
        table.add(new MccEntry(539, "to", 2));
        table.add(new MccEntry(540, "sb", 2));
        table.add(new MccEntry(541, "vu", 2));
        table.add(new MccEntry(542, "fj", 2));
        table.add(new MccEntry(543, "wf", 2));
        table.add(new MccEntry(544, "as", 2));
        table.add(new MccEntry(545, "ki", 2));
        table.add(new MccEntry(546, "nc", 2));
        table.add(new MccEntry(547, "pf", 2));
        table.add(new MccEntry(548, "ck", 2));
        table.add(new MccEntry(549, "ws", 2));
        table.add(new MccEntry(550, "fm", 2));
        table.add(new MccEntry(551, "mh", 2));
        table.add(new MccEntry(552, "pw", 2));
        table.add(new MccEntry(602, "eg", 2));
        table.add(new MccEntry(603, "dz", 2));
        table.add(new MccEntry(604, "ma", 2));
        table.add(new MccEntry(605, "tn", 2));
        table.add(new MccEntry(606, "ly", 2));
        table.add(new MccEntry(607, "gm", 2));
        table.add(new MccEntry(608, "sn", 2));
        table.add(new MccEntry(609, "mr", 2));
        table.add(new MccEntry(610, "ml", 2));
        table.add(new MccEntry(611, "gn", 2));
        table.add(new MccEntry(612, "ci", 2));
        table.add(new MccEntry(613, "bf", 2));
        table.add(new MccEntry(614, "ne", 2));
        table.add(new MccEntry(615, "tg", 2));
        table.add(new MccEntry(616, "bj", 2));
        table.add(new MccEntry(617, "mu", 2));
        table.add(new MccEntry(618, "lr", 2));
        table.add(new MccEntry(619, "sl", 2));
        table.add(new MccEntry(620, "gh", 2));
        table.add(new MccEntry(621, "ng", 2));
        table.add(new MccEntry(622, "td", 2));
        table.add(new MccEntry(623, "cf", 2));
        table.add(new MccEntry(624, "cm", 2));
        table.add(new MccEntry(625, "cv", 2));
        table.add(new MccEntry(626, "st", 2));
        table.add(new MccEntry(627, "gq", 2));
        table.add(new MccEntry(628, "ga", 2));
        table.add(new MccEntry(629, "cg", 2));
        table.add(new MccEntry(630, "cg", 2));
        table.add(new MccEntry(631, "ao", 2));
        table.add(new MccEntry(632, "gw", 2));
        table.add(new MccEntry(633, "sc", 2));
        table.add(new MccEntry(634, "sd", 2));
        table.add(new MccEntry(635, "rw", 2));
        table.add(new MccEntry(636, "et", 2));
        table.add(new MccEntry(637, "so", 2));
        table.add(new MccEntry(638, "dj", 2));
        table.add(new MccEntry(639, "ke", 2));
        table.add(new MccEntry(640, "tz", 2));
        table.add(new MccEntry(641, "ug", 2));
        table.add(new MccEntry(642, "bi", 2));
        table.add(new MccEntry(643, "mz", 2));
        table.add(new MccEntry(645, "zm", 2));
        table.add(new MccEntry(646, "mg", 2));
        table.add(new MccEntry(647, "re", 2));
        table.add(new MccEntry(648, "zw", 2));
        table.add(new MccEntry(649, "na", 2));
        table.add(new MccEntry(650, "mw", 2));
        table.add(new MccEntry(651, "ls", 2));
        table.add(new MccEntry(652, "bw", 2));
        table.add(new MccEntry(653, "sz", 2));
        table.add(new MccEntry(654, "km", 2));
        table.add(new MccEntry(655, "za", 2, "en"));
        table.add(new MccEntry(657, "er", 2));
        table.add(new MccEntry(702, "bz", 2));
        table.add(new MccEntry(704, "gt", 2));
        table.add(new MccEntry(706, "sv", 2));
        table.add(new MccEntry(708, "hn", 3));
        table.add(new MccEntry(710, "ni", 2));
        table.add(new MccEntry(712, "cr", 2));
        table.add(new MccEntry(714, "pa", 2));
        table.add(new MccEntry(716, "pe", 2));
        table.add(new MccEntry(722, "ar", 3));
        table.add(new MccEntry(724, "br", 2));
        table.add(new MccEntry(730, "cl", 2));
        table.add(new MccEntry(732, "co", 3));
        table.add(new MccEntry(734, "ve", 2));
        table.add(new MccEntry(736, "bo", 2));
        table.add(new MccEntry(738, "gy", 2));
        table.add(new MccEntry(740, "ec", 2));
        table.add(new MccEntry(742, "gf", 2));
        table.add(new MccEntry(744, "py", 2));
        table.add(new MccEntry(746, "sr", 2));
        table.add(new MccEntry(748, "uy", 2));
        table.add(new MccEntry(750, "fk", 2));
        Collections.sort(table);
    }
}
