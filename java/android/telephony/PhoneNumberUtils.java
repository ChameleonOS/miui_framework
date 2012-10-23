// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.telephony;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.location.Country;
import android.location.CountryDetector;
import android.net.Uri;
import android.os.SystemProperties;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseIntArray;
import com.android.i18n.phonenumbers.NumberParseException;
import com.android.i18n.phonenumbers.PhoneNumberUtil;
import com.android.i18n.phonenumbers.ShortNumberUtil;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package android.telephony:
//            JapanesePhoneNumberFormatter, TelephonyManager

public class PhoneNumberUtils {
    private static class CountryCallingCodeAndNewIndex {

        public final int countryCallingCode;
        public final int newIndex;

        public CountryCallingCodeAndNewIndex(int i, int j) {
            countryCallingCode = i;
            newIndex = j;
        }
    }


    public PhoneNumberUtils() {
    }

    private static String appendPwCharBackToOrigDialStr(int i, String s, String s1) {
        String s2;
        if(i == 1)
            s2 = (new StringBuilder(s)).append(s1.charAt(0)).toString();
        else
            s2 = s.concat(s1.substring(0, i));
        return s2;
    }

    private static char bcdToChar(byte byte0) {
        if(byte0 >= 10) goto _L2; else goto _L1
_L1:
        char c = (char)(byte0 + 48);
_L4:
        return c;
_L2:
        switch(byte0) {
        default:
            c = '\0';
            break;

        case 10: // '\n'
            c = '*';
            break;

        case 11: // '\013'
            c = '#';
            break;

        case 12: // '\f'
            c = ',';
            break;

        case 13: // '\r'
            c = 'N';
            break;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static String calledPartyBCDFragmentToString(byte abyte0[], int i, int j) {
        StringBuilder stringbuilder = new StringBuilder(j * 2);
        internalCalledPartyBCDFragmentToString(stringbuilder, abyte0, i, j);
        return stringbuilder.toString();
    }

    public static String calledPartyBCDToString(byte abyte0[], int i, int j) {
        boolean flag;
        StringBuilder stringbuilder;
        flag = false;
        stringbuilder = new StringBuilder(1 + j * 2);
        if(j >= 2) goto _L2; else goto _L1
_L1:
        String s = "";
_L4:
        return s;
_L2:
        String s1;
        if((0xf0 & abyte0[i]) == 144)
            flag = true;
        internalCalledPartyBCDFragmentToString(stringbuilder, abyte0, i + 1, j - 1);
        if(flag && stringbuilder.length() == 0) {
            s = "";
            continue; /* Loop/switch isn't completed */
        }
        if(flag) {
            s1 = stringbuilder.toString();
            Matcher matcher = Pattern.compile("(^[#*])(.*)([#*])(.*)(#)$").matcher(s1);
            if(!matcher.matches())
                break; /* Loop/switch isn't completed */
            if("".equals(matcher.group(2))) {
                stringbuilder = new StringBuilder();
                stringbuilder.append(matcher.group(1));
                stringbuilder.append(matcher.group(3));
                stringbuilder.append(matcher.group(4));
                stringbuilder.append(matcher.group(5));
                stringbuilder.append("+");
            } else {
                stringbuilder = new StringBuilder();
                stringbuilder.append(matcher.group(1));
                stringbuilder.append(matcher.group(2));
                stringbuilder.append(matcher.group(3));
                stringbuilder.append("+");
                stringbuilder.append(matcher.group(4));
                stringbuilder.append(matcher.group(5));
            }
        }
_L5:
        s = stringbuilder.toString();
        if(true) goto _L4; else goto _L3
_L3:
        Matcher matcher1 = Pattern.compile("(^[#*])(.*)([#*])(.*)").matcher(s1);
        if(matcher1.matches()) {
            stringbuilder = new StringBuilder();
            stringbuilder.append(matcher1.group(1));
            stringbuilder.append(matcher1.group(2));
            stringbuilder.append(matcher1.group(3));
            stringbuilder.append("+");
            stringbuilder.append(matcher1.group(4));
        } else {
            stringbuilder = new StringBuilder();
            stringbuilder.append('+');
            stringbuilder.append(s1);
        }
          goto _L5
        if(true) goto _L4; else goto _L6
_L6:
    }

    public static String cdmaCheckAndProcessPlusCode(String s) {
        if(!TextUtils.isEmpty(s) && isReallyDialable(s.charAt(0)) && isNonSeparator(s)) {
            String s1 = SystemProperties.get("gsm.operator.iso-country", "");
            String s2 = SystemProperties.get("gsm.sim.operator.iso-country", "");
            if(!TextUtils.isEmpty(s1) && !TextUtils.isEmpty(s2))
                s = cdmaCheckAndProcessPlusCodeByNumberFormat(s, getFormatTypeFromCountryCode(s1), getFormatTypeFromCountryCode(s2));
        }
        return s;
    }

    public static String cdmaCheckAndProcessPlusCodeByNumberFormat(String s, int i, int j) {
        String s1 = s;
        if(s == null || s.lastIndexOf("+") == -1) goto _L2; else goto _L1
_L1:
        String s2;
        if(i != j || i != 1)
            break MISSING_BLOCK_LABEL_166;
        s2 = s;
        s1 = null;
_L9:
        String s3 = processPlusCodeWithinNanp(extractNetworkPortion(s2));
        if(TextUtils.isEmpty(s3)) goto _L4; else goto _L3
_L3:
        String s4;
        int k;
        if(s1 == null)
            s1 = s3;
        else
            s1 = s1.concat(s3);
        s4 = extractPostDialPortion(s2);
        if(TextUtils.isEmpty(s4)) goto _L6; else goto _L5
_L5:
        k = findDialableIndexFromPostDialStr(s4);
        if(k < 1) goto _L8; else goto _L7
_L7:
        s1 = appendPwCharBackToOrigDialStr(k, s1, s4);
        s2 = s4.substring(k);
_L6:
        if(!TextUtils.isEmpty(s4) && !TextUtils.isEmpty(s2)) goto _L9; else goto _L2
_L2:
        s = s1;
_L10:
        return s;
_L4:
        Log.e("checkAndProcessPlusCode: null newDialStr", s3);
        if(true) goto _L10; else goto _L8
_L8:
        if(k < 0)
            s4 = "";
        Log.e("wrong postDialStr=", s4);
          goto _L6
        Log.e("checkAndProcessPlusCode:non-NANP not supported", s);
          goto _L2
    }

    private static int charToBCD(char c) {
        int i;
        if(c >= '0' && c <= '9')
            i = c + -48;
        else
        if(c == '*')
            i = 10;
        else
        if(c == '#')
            i = 11;
        else
        if(c == ',')
            i = 12;
        else
        if(c == 'N')
            i = 13;
        else
            throw new RuntimeException((new StringBuilder()).append("invalid char for BCD ").append(c).toString());
        return i;
    }

    private static boolean checkPrefixIsIgnorable(String s, int i, int j) {
        boolean flag;
        boolean flag1;
        flag = false;
        flag1 = false;
_L7:
        if(j < i) goto _L2; else goto _L1
_L1:
        if(tryGetISODigit(s.charAt(j)) < 0) goto _L4; else goto _L3
_L3:
        if(!flag1) goto _L6; else goto _L5
_L5:
        return flag;
_L6:
        flag1 = true;
_L8:
        j--;
          goto _L7
_L4:
        if(!isDialable(s.charAt(j))) goto _L8; else goto _L5
_L2:
        flag = true;
          goto _L5
    }

    public static boolean compare(Context context, String s, String s1) {
        return compare(s, s1, context.getResources().getBoolean(0x111001c));
    }

    public static boolean compare(String s, String s1) {
        return compare(s, s1, false);
    }

    public static boolean compare(String s, String s1, boolean flag) {
        boolean flag1;
        if(flag)
            flag1 = compareStrictly(s, s1);
        else
            flag1 = compareLoosely(s, s1);
        return flag1;
    }

    public static boolean compareLoosely(String s, String s1) {
        int i;
        int j;
        i = 0;
        j = 0;
        if(s != null && s1 != null) goto _L2; else goto _L1
_L1:
        boolean flag;
        if(s == s1)
            flag = true;
        else
            flag = false;
_L7:
        return flag;
_L2:
        if(s.length() != 0 && s1.length() != 0) goto _L4; else goto _L3
_L3:
        flag = false;
          goto _L5
_L4:
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        k = indexOfLastNetworkChar(s);
        l = k + 1;
        i1 = indexOfLastNetworkChar(s1);
        j1 = i1 + 1;
        k1 = 0;
_L8:
label0:
        {
label1:
            {
                boolean flag1;
                char c;
                char c1;
                do {
                    if(k < 0 || i1 < 0)
                        break label1;
                    flag1 = false;
                    c = s.charAt(k);
                    if(!isDialable(c)) {
                        k--;
                        flag1 = true;
                        i++;
                    }
                    c1 = s1.charAt(i1);
                    if(!isDialable(c1)) {
                        i1--;
                        flag1 = true;
                        j++;
                    }
                } while(flag1);
                if(c1 == c || c == 'N' || c1 == 'N')
                    break label0;
            }
            if(k1 < 7) {
                int l1 = l - i;
                if(l1 == j1 - j && l1 == k1)
                    flag = true;
                else
                    flag = false;
            } else
            if(k1 >= 7 && (k < 0 || i1 < 0))
                flag = true;
            else
            if(matchIntlPrefix(s, k + 1) && matchIntlPrefix(s1, i1 + 1))
                flag = true;
            else
            if(matchTrunkPrefix(s, k + 1) && matchIntlPrefixAndCC(s1, i1 + 1))
                flag = true;
            else
            if(matchTrunkPrefix(s1, i1 + 1) && matchIntlPrefixAndCC(s, k + 1))
                flag = true;
            else
                flag = false;
        }
_L5:
        if(true) goto _L7; else goto _L6
_L6:
        k--;
        i1--;
        k1++;
          goto _L8
    }

    public static boolean compareStrictly(String s, String s1) {
        return compareStrictly(s, s1, true);
    }

    public static boolean compareStrictly(String s, String s1, boolean flag) {
        if(s != null && s1 != null) goto _L2; else goto _L1
_L1:
        boolean flag1;
        if(s == s1)
            flag1 = true;
        else
            flag1 = false;
_L4:
        return flag1;
_L2:
label0:
        {
            int j;
            int j1;
            boolean flag6;
label1:
            {
                if(s.length() == 0 && s1.length() == 0) {
                    flag1 = false;
                    continue; /* Loop/switch isn't completed */
                }
                int i = 0;
                j = 0;
                CountryCallingCodeAndNewIndex countrycallingcodeandnewindex = tryGetCountryCallingCodeAndNewIndex(s, flag);
                CountryCallingCodeAndNewIndex countrycallingcodeandnewindex1 = tryGetCountryCallingCodeAndNewIndex(s1, flag);
                boolean flag2 = false;
                boolean flag3 = true;
                boolean flag4 = false;
                boolean flag5 = false;
                int i1;
                if(countrycallingcodeandnewindex != null && countrycallingcodeandnewindex1 != null) {
                    if(countrycallingcodeandnewindex.countryCallingCode != countrycallingcodeandnewindex1.countryCallingCode) {
                        flag1 = false;
                        continue; /* Loop/switch isn't completed */
                    }
                    flag3 = false;
                    flag2 = true;
                    i = countrycallingcodeandnewindex.newIndex;
                    j = countrycallingcodeandnewindex1.newIndex;
                } else
                if(countrycallingcodeandnewindex == null && countrycallingcodeandnewindex1 == null) {
                    flag3 = false;
                } else {
                    if(countrycallingcodeandnewindex != null) {
                        i = countrycallingcodeandnewindex.newIndex;
                    } else {
                        int k = tryGetTrunkPrefixOmittedIndex(s1, 0);
                        if(k >= 0) {
                            i = k;
                            flag4 = true;
                        }
                    }
                    if(countrycallingcodeandnewindex1 != null) {
                        j = countrycallingcodeandnewindex1.newIndex;
                    } else {
                        int l = tryGetTrunkPrefixOmittedIndex(s1, 0);
                        if(l >= 0) {
                            j = l;
                            flag5 = true;
                        }
                    }
                }
                i1 = -1 + s.length();
                for(j1 = -1 + s1.length(); i1 >= i && j1 >= j;) {
                    boolean flag7 = false;
                    char c2 = s.charAt(i1);
                    char c3 = s1.charAt(j1);
                    if(isSeparator(c2)) {
                        i1--;
                        flag7 = true;
                    }
                    if(isSeparator(c3)) {
                        j1--;
                        flag7 = true;
                    }
                    if(!flag7) {
                        if(c2 != c3) {
                            flag1 = false;
                            continue; /* Loop/switch isn't completed */
                        }
                        i1--;
                        j1--;
                    }
                }

                if(flag3) {
                    if(flag4 && i <= i1 || !checkPrefixIsIgnorable(s, i, i1)) {
                        if(flag)
                            flag1 = compare(s, s1, false);
                        else
                            flag1 = false;
                        continue; /* Loop/switch isn't completed */
                    }
                    if(flag5 && j <= j1 || !checkPrefixIsIgnorable(s1, i, j1)) {
                        if(flag)
                            flag1 = compare(s, s1, false);
                        else
                            flag1 = false;
                        continue; /* Loop/switch isn't completed */
                    }
                    break label0;
                }
                if(!flag2)
                    flag6 = true;
                else
                    flag6 = false;
                do {
                    if(i1 < i)
                        break label1;
                    char c1 = s.charAt(i1);
                    if(isDialable(c1)) {
                        if(!flag6 || tryGetISODigit(c1) != 1)
                            break;
                        flag6 = false;
                    }
                    i1--;
                } while(true);
                flag1 = false;
                continue; /* Loop/switch isn't completed */
            }
            do {
                if(j1 < j)
                    break label0;
                char c = s1.charAt(j1);
                if(isDialable(c)) {
                    if(!flag6 || tryGetISODigit(c) != 1)
                        break;
                    flag6 = false;
                }
                j1--;
            } while(true);
            flag1 = false;
            continue; /* Loop/switch isn't completed */
        }
        flag1 = true;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static String convertAndStrip(String s) {
        return stripSeparators(convertKeypadLettersToDigits(s));
    }

    public static String convertKeypadLettersToDigits(String s) {
        if(s != null) goto _L2; else goto _L1
_L1:
        return s;
_L2:
        int i = s.length();
        if(i != 0) {
            char ac[] = s.toCharArray();
            for(int j = 0; j < i; j++) {
                char c = ac[j];
                ac[j] = (char)KEYPAD_MAP.get(c, c);
            }

            s = new String(ac);
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static String convertPreDial(String s) {
        if(s != null) goto _L2; else goto _L1
_L1:
        String s1 = null;
_L4:
        return s1;
_L2:
        int i = s.length();
        StringBuilder stringbuilder = new StringBuilder(i);
        int j = 0;
        while(j < i)  {
            char c = s.charAt(j);
            if(isPause(c))
                c = ',';
            else
            if(isToneWait(c))
                c = ';';
            stringbuilder.append(c);
            j++;
        }
        s1 = stringbuilder.toString();
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static String extractNetworkPortion(String s) {
        if(s != null) goto _L2; else goto _L1
_L1:
        String s1 = null;
_L8:
        return s1;
_L2:
        int i;
        StringBuilder stringbuilder;
        int j;
        i = s.length();
        stringbuilder = new StringBuilder(i);
        j = 0;
_L5:
        if(j >= i) goto _L4; else goto _L3
_L3:
        char c;
        c = s.charAt(j);
        int k = Character.digit(c, 10);
        if(k != -1)
            stringbuilder.append(k);
        else
        if(c == '+') {
            String s2 = stringbuilder.toString();
            if(s2.length() == 0 || s2.equals("*31#") || s2.equals("#31#"))
                stringbuilder.append(c);
        } else {
            if(!isDialable(c))
                continue; /* Loop/switch isn't completed */
            stringbuilder.append(c);
        }
_L6:
        j++;
          goto _L5
        if(!isStartsPostDial(c)) goto _L6; else goto _L4
_L4:
        s1 = stringbuilder.toString();
        if(true) goto _L8; else goto _L7
_L7:
    }

    public static String extractNetworkPortionAlt(String s) {
        if(s != null) goto _L2; else goto _L1
_L1:
        String s1 = null;
_L11:
        return s1;
_L2:
        int i;
        StringBuilder stringbuilder;
        boolean flag;
        int j;
        i = s.length();
        stringbuilder = new StringBuilder(i);
        flag = false;
        j = 0;
_L9:
        if(j >= i) goto _L4; else goto _L3
_L3:
        char c = s.charAt(j);
        if(c != '+') goto _L6; else goto _L5
_L5:
        if(!flag) goto _L8; else goto _L7
_L7:
        j++;
          goto _L9
_L8:
        flag = true;
_L6:
        if(!isDialable(c))
            continue; /* Loop/switch isn't completed */
        stringbuilder.append(c);
          goto _L7
        if(!isStartsPostDial(c)) goto _L7; else goto _L4
_L4:
        s1 = stringbuilder.toString();
        if(true) goto _L11; else goto _L10
_L10:
    }

    public static String extractPostDialPortion(String s) {
        String s1;
        if(s == null) {
            s1 = null;
        } else {
            StringBuilder stringbuilder = new StringBuilder();
            int i = 1 + indexOfLastNetworkChar(s);
            for(int j = s.length(); i < j; i++) {
                char c = s.charAt(i);
                if(isNonSeparator(c))
                    stringbuilder.append(c);
            }

            s1 = stringbuilder.toString();
        }
        return s1;
    }

    private static int findDialableIndexFromPostDialStr(String s) {
        int i = 0;
_L3:
        if(i >= s.length())
            break MISSING_BLOCK_LABEL_29;
        if(!isReallyDialable(s.charAt(i))) goto _L2; else goto _L1
_L1:
        return i;
_L2:
        i++;
          goto _L3
        i = -1;
          goto _L1
    }

    public static void formatJapaneseNumber(Editable editable) {
        JapanesePhoneNumberFormatter.format(editable);
    }

    public static void formatNanpNumber(Editable editable) {
        int i;
        i = editable.length();
        break MISSING_BLOCK_LABEL_7;
_L11:
        CharSequence charsequence;
        int j;
        int ai[];
        int k;
        int l;
        int i1;
        int j1;
        do
            return;
        while(i > "+1-nnn-nnn-nnnn".length() || i <= 5);
        charsequence = editable.subSequence(0, i);
        removeDashes(editable);
        j = editable.length();
        ai = new int[3];
        k = 1;
        l = 0;
        i1 = 0;
        j1 = 0;
_L7:
        if(i1 >= j)
            break MISSING_BLOCK_LABEL_296;
        editable.charAt(i1);
        JVM INSTR tableswitch 43 57: default 148
    //                   43 281
    //                   44 148
    //                   45 271
    //                   46 148
    //                   47 148
    //                   48 189
    //                   49 161
    //                   50 189
    //                   51 189
    //                   52 189
    //                   53 189
    //                   54 189
    //                   55 189
    //                   56 189
    //                   57 189;
           goto _L1 _L2 _L1 _L3 _L1 _L1 _L4 _L5 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L4
_L1:
        editable.replace(0, j, charsequence);
        continue; /* Loop/switch isn't completed */
_L5:
        if(l != 0 && k != 2) goto _L4; else goto _L6
_L6:
        int k2;
        k = 3;
        k2 = j1;
_L8:
        i1++;
        j1 = k2;
          goto _L7
_L4:
        if(k == 2) {
            editable.replace(0, j, charsequence);
            continue; /* Loop/switch isn't completed */
        }
        int k1;
        int l1;
        int i2;
        int j2;
        if(k == 3) {
            k2 = j1 + 1;
            ai[j1] = i1;
        } else
        if(k != 4 && (l == 3 || l == 6)) {
            k2 = j1 + 1;
            ai[j1] = i1;
        } else {
            k2 = j1;
        }
        k = 1;
        l++;
          goto _L8
_L3:
        k = 4;
        k2 = j1;
          goto _L8
_L2:
        if(i1 != 0) goto _L1; else goto _L9
_L9:
        k = 2;
        k2 = j1;
          goto _L8
        if(l == 7)
            k1 = j1 - 1;
        else
            k1 = j1;
        for(l1 = 0; l1 < k1; l1++) {
            j2 = ai[l1];
            editable.replace(j2 + l1, j2 + l1, "-");
        }

        i2 = editable.length();
        while(i2 > 0 && editable.charAt(i2 - 1) == '-')  {
            editable.delete(i2 - 1, i2);
            i2--;
        }
        if(true) goto _L11; else goto _L10
_L10:
    }

    public static String formatNumber(String s) {
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder(s);
        formatNumber(((Editable) (spannablestringbuilder)), getFormatTypeForLocale(Locale.getDefault()));
        return spannablestringbuilder.toString();
    }

    public static String formatNumber(String s, int i) {
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder(s);
        formatNumber(((Editable) (spannablestringbuilder)), i);
        return spannablestringbuilder.toString();
    }

    public static String formatNumber(String s, String s1) {
        if(!s.startsWith("#") && !s.startsWith("*")) goto _L2; else goto _L1
_L1:
        String s2 = s;
_L4:
        return s2;
_L2:
        PhoneNumberUtil phonenumberutil;
        phonenumberutil = PhoneNumberUtil.getInstance();
        s2 = null;
        String s3 = phonenumberutil.formatInOriginalFormat(phonenumberutil.parseAndKeepRawInput(s, s1), s1);
        s2 = s3;
        continue; /* Loop/switch isn't completed */
        NumberParseException numberparseexception;
        numberparseexception;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static String formatNumber(String s, String s1, String s2) {
        String s3;
        int i;
        int j;
        s3 = miui.telephony.PhoneNumberUtils.removeDashesAndBlanks(s);
        i = s3.length();
        j = 0;
_L5:
        if(j >= i) goto _L2; else goto _L1
_L1:
        if(isDialable(s3.charAt(j))) goto _L4; else goto _L3
_L3:
        return s3;
_L4:
        j++;
          goto _L5
_L2:
        PhoneNumberUtil phonenumberutil;
        phonenumberutil = PhoneNumberUtil.getInstance();
        if(s1 == null || s1.length() < 2 || s1.charAt(0) != '+')
            break MISSING_BLOCK_LABEL_114;
        String s5;
        int k;
        s5 = phonenumberutil.getRegionCodeForNumber(phonenumberutil.parse(s1, "ZZ"));
        if(TextUtils.isEmpty(s5))
            break MISSING_BLOCK_LABEL_114;
        k = normalizeNumber(s3).indexOf(s1.substring(1));
        if(k <= 0)
            s2 = s5;
_L6:
        String s4 = formatNumber(s3, s2);
        if(s4 == null)
            s4 = s3;
        s3 = s4;
          goto _L3
        NumberParseException numberparseexception;
        numberparseexception;
          goto _L6
    }

    public static void formatNumber(Editable editable, int i) {
        int j = i;
        if(editable.length() > 2 && editable.charAt(0) == '+')
            if(editable.charAt(1) == '1')
                j = 1;
            else
            if(editable.length() >= 3 && editable.charAt(1) == '8' && editable.charAt(2) == '1')
                j = 2;
            else
                j = 0;
        j;
        JVM INSTR tableswitch 0 2: default 64
    //                   0 123
    //                   1 109
    //                   2 116;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L3:
        formatNanpNumber(editable);
        continue; /* Loop/switch isn't completed */
_L4:
        formatJapaneseNumber(editable);
        continue; /* Loop/switch isn't completed */
_L2:
        removeDashes(editable);
        if(true) goto _L1; else goto _L5
_L5:
    }

    public static String formatNumberToE164(String s, String s1) {
        PhoneNumberUtil phonenumberutil;
        String s2;
        phonenumberutil = PhoneNumberUtil.getInstance();
        s2 = null;
        String s3;
        com.android.i18n.phonenumbers.Phonenumber.PhoneNumber phonenumber = phonenumberutil.parse(s, s1);
        if(!phonenumberutil.isValidNumber(phonenumber))
            break MISSING_BLOCK_LABEL_37;
        s3 = phonenumberutil.format(phonenumber, com.android.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat.E164);
        s2 = s3;
_L2:
        return s2;
        NumberParseException numberparseexception;
        numberparseexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private static String getDefaultIdp() {
        String s = null;
        SystemProperties.get("ro.cdma.idpstring", null);
        if(TextUtils.isEmpty(null))
            s = "011";
        return s;
    }

    public static int getFormatTypeForLocale(Locale locale) {
        return getFormatTypeFromCountryCode(locale.getCountry());
    }

    private static int getFormatTypeFromCountryCode(String s) {
        int i;
        int j;
        i = NANP_COUNTRIES.length;
        j = 0;
_L3:
        if(j >= i)
            break MISSING_BLOCK_LABEL_34;
        if(NANP_COUNTRIES[j].compareToIgnoreCase(s) != 0) goto _L2; else goto _L1
_L1:
        int k = 1;
_L4:
        return k;
_L2:
        j++;
          goto _L3
        if("jp".compareToIgnoreCase(s) == 0)
            k = 2;
        else
            k = 0;
          goto _L4
    }

    public static String getNumberFromIntent(Intent intent, Context context) {
        String s;
        String s1;
        Uri uri;
        String s2;
        s = null;
        s1 = null;
        uri = intent.getData();
        s2 = uri.getScheme();
        if(!s2.equals("tel") && !s2.equals("sip")) goto _L2; else goto _L1
_L1:
        s = uri.getSchemeSpecificPart();
_L8:
        return s;
_L2:
        String s3;
        String s4;
        if(s2.equals("voicemail")) {
            s = TelephonyManager.getDefault().getCompleteVoiceMailNumber();
            continue; /* Loop/switch isn't completed */
        }
        if(context == null)
            continue; /* Loop/switch isn't completed */
        intent.resolveType(context);
        s3 = null;
        s4 = uri.getAuthority();
        if(!"contacts".equals(s4)) goto _L4; else goto _L3
_L3:
        s3 = "number";
_L6:
        Cursor cursor;
        ContentResolver contentresolver = context.getContentResolver();
        String as[] = new String[1];
        as[0] = s3;
        cursor = contentresolver.query(uri, as, null, null, null);
        if(cursor == null)
            break MISSING_BLOCK_LABEL_179;
        String s5;
        if(!cursor.moveToFirst())
            break MISSING_BLOCK_LABEL_172;
        s5 = cursor.getString(cursor.getColumnIndex(s3));
        s1 = s5;
        cursor.close();
        s = s1;
        continue; /* Loop/switch isn't completed */
_L4:
        if("com.android.contacts".equals(s4))
            s3 = "data1";
        if(true) goto _L6; else goto _L5
_L5:
        Exception exception;
        exception;
        cursor.close();
        throw exception;
        if(true) goto _L8; else goto _L7
_L7:
    }

    public static String getStrippedReversed(String s) {
        String s1 = extractNetworkPortionAlt(s);
        String s2;
        if(s1 == null)
            s2 = null;
        else
            s2 = internalGetStrippedReversed(s1, s1.length());
        return s2;
    }

    public static String getUsernameFromUriNumber(String s) {
        int i = s.indexOf('@');
        if(i < 0)
            i = s.indexOf("%40");
        if(i < 0) {
            Log.w("PhoneNumberUtils", (new StringBuilder()).append("getUsernameFromUriNumber: no delimiter found in SIP addr '").append(s).append("'").toString());
            i = s.length();
        }
        return s.substring(0, i);
    }

    private static int indexOfLastNetworkChar(String s) {
        int i = s.length();
        int j = minPositive(s.indexOf(','), s.indexOf(';'));
        int k;
        if(j < 0)
            k = i - 1;
        else
            k = j - 1;
        return k;
    }

    private static void internalCalledPartyBCDFragmentToString(StringBuilder stringbuilder, byte abyte0[], int i, int j) {
        int k = i;
_L7:
        if(k >= j + i) goto _L2; else goto _L1
_L1:
        char c = bcdToChar((byte)(0xf & abyte0[k]));
        if(c != 0) goto _L3; else goto _L2
_L2:
        return;
_L3:
        byte byte0;
        stringbuilder.append(c);
        byte0 = (byte)(0xf & abyte0[k] >> 4);
        if(byte0 == 15 && k + 1 == j + i) goto _L2; else goto _L4
_L4:
        char c1 = bcdToChar(byte0);
        if(c1 == 0) goto _L2; else goto _L5
_L5:
        stringbuilder.append(c1);
        k++;
        if(true) goto _L7; else goto _L6
_L6:
    }

    private static String internalGetStrippedReversed(String s, int i) {
        String s1;
        if(s == null) {
            s1 = null;
        } else {
            StringBuilder stringbuilder = new StringBuilder(i);
            int j = s.length();
            for(int k = j - 1; k >= 0 && j - k <= i; k--)
                stringbuilder.append(s.charAt(k));

            s1 = stringbuilder.toString();
        }
        return s1;
    }

    public static final boolean is12Key(char c) {
        boolean flag;
        if(c >= '0' && c <= '9' || c == '*' || c == '#')
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static boolean isCountryCallingCode(int i) {
        boolean flag;
        if(i > 0 && i < CCC_LENGTH && COUNTRY_CALLING_CALL[i])
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static final boolean isDialable(char c) {
        boolean flag;
        if(c >= '0' && c <= '9' || c == '*' || c == '#' || c == '+' || c == 'N')
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static boolean isDialable(String s) {
        int i;
        int j;
        i = 0;
        j = s.length();
_L3:
        if(i >= j)
            break MISSING_BLOCK_LABEL_33;
        if(isDialable(s.charAt(i))) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        i++;
          goto _L3
        flag = true;
          goto _L4
    }

    public static boolean isEmergencyNumber(String s) {
        return isEmergencyNumberInternal(s, true);
    }

    public static boolean isEmergencyNumber(String s, String s1) {
        return isEmergencyNumberInternal(s, s1, true);
    }

    private static boolean isEmergencyNumberInternal(String s, String s1, boolean flag) {
        boolean flag1;
        flag1 = false;
        break MISSING_BLOCK_LABEL_2;
label0:
        while(true)  {
            do
                return flag1;
            while(s == null || isUriNumber(s));
            String s2 = miui.telephony.PhoneNumberUtils.parseNumber(extractNetworkPortionAlt(s));
            if(miui.telephony.PhoneNumberUtils.isMiuiEmergencyNumber(s2, flag)) {
                flag1 = true;
                continue;
            }
            String s3 = SystemProperties.get("ril.ecclist");
            if(TextUtils.isEmpty(s3))
                s3 = SystemProperties.get("ro.ril.ecclist");
            if(!TextUtils.isEmpty(s3)) {
                String as[] = s3.split(",");
                int i = as.length;
                int j = 0;
                do {
                    if(j >= i)
                        continue label0;
                    String s4 = as[j];
                    if(flag || "BR".equalsIgnoreCase(s1)) {
                        if(s2.equals(s4)) {
                            flag1 = true;
                            continue label0;
                        }
                    } else
                    if(s2.startsWith(s4)) {
                        flag1 = true;
                        continue label0;
                    }
                    j++;
                } while(true);
            }
            Log.d("PhoneNumberUtils", "System property doesn't provide any emergency numbers. Use embedded logic for determining ones.");
            if(s1 != null) {
                ShortNumberUtil shortnumberutil = new ShortNumberUtil();
                if(flag)
                    flag1 = shortnumberutil.isEmergencyNumber(s2, s1);
                else
                    flag1 = shortnumberutil.connectsToEmergencyNumber(s2, s1);
            } else
            if(flag) {
                if(s2.equals("112") || s2.equals("911"))
                    flag1 = true;
            } else
            if(s2.startsWith("112") || s2.startsWith("911"))
                flag1 = true;
        }
    }

    private static boolean isEmergencyNumberInternal(String s, boolean flag) {
        return isEmergencyNumberInternal(s, null, flag);
    }

    public static boolean isGlobalPhoneNumber(String s) {
        boolean flag;
        if(TextUtils.isEmpty(s))
            flag = false;
        else
            flag = GLOBAL_PHONE_NUMBER_PATTERN.matcher(s).matches();
        return flag;
    }

    public static boolean isISODigit(char c) {
        boolean flag;
        if(c >= '0' && c <= '9')
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isLocalEmergencyNumber(String s, Context context) {
        return isLocalEmergencyNumberInternal(s, context, true);
    }

    private static boolean isLocalEmergencyNumberInternal(String s, Context context, boolean flag) {
        CountryDetector countrydetector = (CountryDetector)context.getSystemService("country_detector");
        String s1;
        if(countrydetector != null) {
            s1 = countrydetector.detectCountry().getCountryIso();
        } else {
            s1 = context.getResources().getConfiguration().locale.getCountry();
            Log.w("PhoneNumberUtils", (new StringBuilder()).append("No CountryDetector; falling back to countryIso based on locale: ").append(s1).toString());
        }
        return isEmergencyNumberInternal(s, s1, flag);
    }

    private static boolean isNanp(String s) {
        boolean flag;
        flag = false;
        if(s == null)
            break MISSING_BLOCK_LABEL_68;
        if(s.length() != 10 || !isTwoToNine(s.charAt(0)) || !isTwoToNine(s.charAt(3))) goto _L2; else goto _L1
_L1:
        int i;
        flag = true;
        i = 1;
_L6:
        if(i >= 10) goto _L2; else goto _L3
_L3:
        if(isISODigit(s.charAt(i))) goto _L5; else goto _L4
_L4:
        flag = false;
_L2:
        return flag;
_L5:
        i++;
          goto _L6
        Log.e("isNanp: null dialStr passed in", s);
          goto _L2
    }

    public static final boolean isNonSeparator(char c) {
        boolean flag;
        if(c >= '0' && c <= '9' || c == '*' || c == '#' || c == '+' || c == 'N' || c == ';' || c == ',')
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static boolean isNonSeparator(String s) {
        int i;
        int j;
        i = 0;
        j = s.length();
_L3:
        if(i >= j)
            break MISSING_BLOCK_LABEL_33;
        if(isNonSeparator(s.charAt(i))) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        i++;
          goto _L3
        flag = true;
          goto _L4
    }

    private static boolean isOneNanp(String s) {
        boolean flag = false;
        if(s != null) {
            String s1 = s.substring(1);
            if(s.charAt(0) == '1' && isNanp(s1))
                flag = true;
        } else {
            Log.e("isOneNanp: null dialStr passed in", s);
        }
        return flag;
    }

    private static boolean isPause(char c) {
        boolean flag;
        if(c == 'p' || c == 'P')
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isPotentialEmergencyNumber(String s) {
        return isEmergencyNumberInternal(s, false);
    }

    public static boolean isPotentialEmergencyNumber(String s, String s1) {
        return isEmergencyNumberInternal(s, s1, false);
    }

    public static boolean isPotentialLocalEmergencyNumber(String s, Context context) {
        return isLocalEmergencyNumberInternal(s, context, false);
    }

    public static final boolean isReallyDialable(char c) {
        boolean flag;
        if(c >= '0' && c <= '9' || c == '*' || c == '#' || c == '+')
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static boolean isSeparator(char c) {
        boolean flag;
        if(!isDialable(c) && ('a' > c || c > 'z') && ('A' > c || c > 'Z'))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static final boolean isStartsPostDial(char c) {
        boolean flag;
        if(c == ',' || c == ';')
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static boolean isToneWait(char c) {
        boolean flag;
        if(c == 'w' || c == 'W')
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static boolean isTwoToNine(char c) {
        boolean flag;
        if(c >= '2' && c <= '9')
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isUriNumber(String s) {
        boolean flag;
        if(s != null && (s.contains("@") || s.contains("%40")))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isVoiceMailNumber(String s) {
        boolean flag = false;
        String s1 = TelephonyManager.getDefault().getVoiceMailNumber();
        String s2 = extractNetworkPortionAlt(s);
        if(!TextUtils.isEmpty(s2) && compare(s2, s1))
            flag = true;
_L2:
        return flag;
        SecurityException securityexception;
        securityexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static boolean isWellFormedSmsAddress(String s) {
        String s1 = extractNetworkPortion(s);
        boolean flag;
        if(!s1.equals("+") && !TextUtils.isEmpty(s1) && isDialable(s1))
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static void log(String s) {
        Log.d("PhoneNumberUtils", s);
    }

    private static boolean matchIntlPrefix(String s, int i) {
        boolean flag;
        int j;
        int k;
        flag = false;
        j = 0;
        k = 0;
_L9:
        if(k >= i) goto _L2; else goto _L1
_L1:
        char c = s.charAt(k);
        j;
        JVM INSTR tableswitch 0 4: default 56
    //                   0 66
    //                   1 56
    //                   2 104
    //                   3 56
    //                   4 139;
           goto _L3 _L4 _L3 _L5 _L3 _L6
_L3:
        if(!isNonSeparator(c))
            break; /* Loop/switch isn't completed */
_L13:
        return flag;
_L4:
        if(c != '+') goto _L8; else goto _L7
_L7:
        j = 1;
_L12:
        k++;
          goto _L9
_L8:
        if(c != '0') goto _L11; else goto _L10
_L10:
        j = 2;
          goto _L12
_L11:
        if(!isNonSeparator(c)) goto _L12; else goto _L13
_L5:
label0:
        {
            if(c != '0')
                break label0;
            j = 3;
        }
          goto _L12
        if(c != '1') goto _L15; else goto _L14
_L14:
        j = 4;
          goto _L12
_L15:
        if(!isNonSeparator(c)) goto _L12; else goto _L13
_L6:
        if(c != '1') goto _L17; else goto _L16
_L16:
        j = 5;
          goto _L12
_L17:
        if(!isNonSeparator(c)) goto _L12; else goto _L13
_L2:
        if(j == 1 || j == 3 || j == 5)
            flag = true;
          goto _L13
    }

    private static boolean matchIntlPrefixAndCC(String s, int i) {
        boolean flag;
        int j;
        int k;
        flag = false;
        j = 0;
        k = 0;
_L11:
        if(k >= i) goto _L2; else goto _L1
_L1:
        char c = s.charAt(k);
        j;
        JVM INSTR tableswitch 0 7: default 68
    //                   0 78
    //                   1 174
    //                   2 116
    //                   3 174
    //                   4 151
    //                   5 174
    //                   6 199
    //                   7 199;
           goto _L3 _L4 _L5 _L6 _L5 _L7 _L5 _L8 _L8
_L3:
        if(!isNonSeparator(c))
            break; /* Loop/switch isn't completed */
_L15:
        return flag;
_L4:
        if(c != '+') goto _L10; else goto _L9
_L9:
        j = 1;
_L14:
        k++;
          goto _L11
_L10:
        if(c != '0') goto _L13; else goto _L12
_L12:
        j = 2;
          goto _L14
_L13:
        if(!isNonSeparator(c)) goto _L14; else goto _L15
_L6:
label0:
        {
            if(c != '0')
                break label0;
            j = 3;
        }
          goto _L14
        if(c != '1') goto _L17; else goto _L16
_L16:
        j = 4;
          goto _L14
_L17:
        if(!isNonSeparator(c)) goto _L14; else goto _L15
_L7:
        if(c != '1') goto _L19; else goto _L18
_L18:
        j = 5;
          goto _L14
_L19:
        if(!isNonSeparator(c)) goto _L14; else goto _L15
_L5:
        if(!isISODigit(c)) goto _L21; else goto _L20
_L20:
        j = 6;
          goto _L14
_L21:
        if(!isNonSeparator(c)) goto _L14; else goto _L15
_L8:
        if(!isISODigit(c)) goto _L23; else goto _L22
_L22:
        j++;
          goto _L14
_L23:
        if(!isNonSeparator(c)) goto _L14; else goto _L15
_L2:
        if(j == 6 || j == 7 || j == 8)
            flag = true;
          goto _L15
    }

    private static boolean matchTrunkPrefix(String s, int i) {
        boolean flag;
        int j;
        flag = false;
        j = 0;
_L2:
        char c;
        if(j >= i)
            break MISSING_BLOCK_LABEL_45;
        c = s.charAt(j);
        if(c != '0' || flag)
            break; /* Loop/switch isn't completed */
        flag = true;
_L4:
        j++;
        if(true) goto _L2; else goto _L1
_L1:
        if(!isNonSeparator(c)) goto _L4; else goto _L3
_L3:
        flag = false;
        return flag;
    }

    private static int minPositive(int i, int j) {
        if(i < 0 || j < 0) goto _L2; else goto _L1
_L1:
        if(i >= j)
            i = j;
_L4:
        return i;
_L2:
        if(i < 0)
            if(j >= 0)
                i = j;
            else
                i = -1;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static byte[] networkPortionToCalledPartyBCD(String s) {
        return numberToCalledPartyBCDHelper(extractNetworkPortion(s), false);
    }

    public static byte[] networkPortionToCalledPartyBCDWithLength(String s) {
        return numberToCalledPartyBCDHelper(extractNetworkPortion(s), true);
    }

    public static String normalizeNumber(String s) {
        StringBuilder stringbuilder;
        int i;
        int j;
        stringbuilder = new StringBuilder();
        i = s.length();
        j = 0;
_L3:
        if(j >= i) goto _L2; else goto _L1
_L1:
        char c;
        c = s.charAt(j);
        int k = Character.digit(c, 10);
        if(k != -1) {
            stringbuilder.append(k);
        } else {
            if((j != 0 || c != '+') && !isNonSeparator(c))
                continue; /* Loop/switch isn't completed */
            stringbuilder.append(c);
        }
_L5:
        j++;
          goto _L3
        if((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) goto _L5; else goto _L4
_L4:
        String s1 = normalizeNumber(convertKeypadLettersToDigits(s));
_L7:
        return s1;
_L2:
        s1 = stringbuilder.toString();
        if(true) goto _L7; else goto _L6
_L6:
    }

    public static byte[] numberToCalledPartyBCD(String s) {
        return numberToCalledPartyBCDHelper(s, false);
    }

    private static byte[] numberToCalledPartyBCDHelper(String s, boolean flag) {
        int i = s.length();
        int j = i;
        boolean flag1;
        byte abyte0[];
        if(s.indexOf('+') != -1)
            flag1 = true;
        else
            flag1 = false;
        if(flag1)
            j--;
        if(j == 0) {
            abyte0 = null;
        } else {
            int k = (j + 1) / 2;
            int l = 1;
            if(flag)
                l++;
            int i1 = k + l;
            abyte0 = new byte[i1];
            int j1 = 0;
            int k1 = 0;
            while(k1 < i)  {
                char c1 = s.charAt(k1);
                if(c1 != '+') {
                    byte byte0;
                    int k2;
                    if((j1 & 1) == 1)
                        byte0 = 4;
                    else
                        byte0 = 0;
                    k2 = l + (j1 >> 1);
                    abyte0[k2] = abyte0[k2] | (byte)((0xf & charToBCD(c1)) << byte0);
                    j1++;
                }
                k1++;
            }
            if((j1 & 1) == 1) {
                int j2 = l + (j1 >> 1);
                abyte0[j2] = (byte)(0xf0 | abyte0[j2]);
            }
            int l1 = 0;
            if(flag) {
                int i2 = 0 + 1;
                abyte0[l1] = (byte)(i1 - 1);
                l1 = i2;
            }
            char c;
            if(flag1)
                c = '\221';
            else
                c = '\201';
            abyte0[l1] = (byte)c;
        }
        return abyte0;
    }

    private static String processPlusCodeWithinNanp(String s) {
        String s1 = s;
        if(s != null && s.charAt(0) == '+' && s.length() > 1) {
            String s2 = s.substring(1);
            if(isOneNanp(s2))
                s1 = s2;
            else
                s1 = s.replaceFirst("[+]", getDefaultIdp());
        }
        return s1;
    }

    private static void removeDashes(Editable editable) {
        for(int i = 0; i < editable.length();)
            if(editable.charAt(i) == '-')
                editable.delete(i, i + 1);
            else
                i++;

    }

    public static String replaceUnicodeDigits(String s) {
        StringBuilder stringbuilder = new StringBuilder(s.length());
        char ac[] = s.toCharArray();
        int i = ac.length;
        int j = 0;
        while(j < i)  {
            char c = ac[j];
            int k = Character.digit(c, 10);
            if(k != -1)
                stringbuilder.append(k);
            else
                stringbuilder.append(c);
            j++;
        }
        return stringbuilder.toString();
    }

    public static String stringFromStringAndTOA(String s, int i) {
        if(s != null) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        return s;
_L2:
        if(i == 145 && s.length() > 0 && s.charAt(0) != '+')
            s = (new StringBuilder()).append("+").append(s).toString();
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static String stripSeparators(String s) {
        if(s != null) goto _L2; else goto _L1
_L1:
        String s1 = null;
_L4:
        return s1;
_L2:
        int i = s.length();
        StringBuilder stringbuilder = new StringBuilder(i);
        int j = 0;
        while(j < i)  {
            char c = s.charAt(j);
            int k = Character.digit(c, 10);
            if(k != -1)
                stringbuilder.append(k);
            else
            if(isNonSeparator(c))
                stringbuilder.append(c);
            j++;
        }
        s1 = stringbuilder.toString();
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static String toCallerIDMinMatch(String s) {
        return internalGetStrippedReversed(extractNetworkPortionAlt(s), 7);
    }

    public static int toaFromString(String s) {
        char c;
        if(s != null && s.length() > 0 && s.charAt(0) == '+')
            c = '\221';
        else
            c = '\201';
        return c;
    }

    private static CountryCallingCodeAndNewIndex tryGetCountryCallingCodeAndNewIndex(String s, boolean flag) {
        CountryCallingCodeAndNewIndex countrycallingcodeandnewindex;
        int i;
        int j;
        int k;
        int l;
        countrycallingcodeandnewindex = null;
        i = 0;
        j = 0;
        k = s.length();
        l = 0;
_L9:
        if(l >= k) goto _L2; else goto _L1
_L1:
        char c = s.charAt(l);
        i;
        JVM INSTR tableswitch 0 9: default 88
    //                   0 90
    //                   1 203
    //                   2 145
    //                   3 203
    //                   4 180
    //                   5 203
    //                   6 203
    //                   7 203
    //                   8 295
    //                   9 319;
           goto _L2 _L3 _L4 _L5 _L4 _L6 _L4 _L4 _L4 _L7 _L8
_L2:
        return countrycallingcodeandnewindex;
_L3:
        if(c == '+') {
            i = 1;
        } else {
label0:
            {
                if(c != '0')
                    break label0;
                i = 2;
            }
        }
_L13:
        l++;
          goto _L9
        if(c != '1') goto _L11; else goto _L10
_L10:
        if(!flag) goto _L2; else goto _L12
_L12:
        i = 8;
          goto _L13
_L11:
        if(!isDialable(c)) goto _L13; else goto _L2
_L5:
label1:
        {
            if(c != '0')
                break label1;
            i = 3;
        }
          goto _L13
        if(c != '1') goto _L15; else goto _L14
_L14:
        i = 4;
          goto _L13
_L15:
        if(!isDialable(c)) goto _L13; else goto _L2
_L6:
        if(c != '1') goto _L17; else goto _L16
_L16:
        i = 5;
          goto _L13
_L17:
        if(!isDialable(c)) goto _L13; else goto _L2
_L4:
        int i1 = tryGetISODigit(c);
        if(i1 <= 0) goto _L19; else goto _L18
_L18:
label2:
        {
            j = i1 + j * 10;
            if(j < 100 && !isCountryCallingCode(j))
                break label2;
            countrycallingcodeandnewindex = new CountryCallingCodeAndNewIndex(j, l + 1);
        }
          goto _L2
        if(i == 1 || i == 3 || i == 5)
            i = 6;
        else
            i++;
          goto _L13
_L19:
        if(!isDialable(c)) goto _L13; else goto _L2
_L7:
        if(c != '6') goto _L21; else goto _L20
_L20:
        i = 9;
          goto _L13
_L21:
        if(!isDialable(c)) goto _L13; else goto _L2
_L8:
        if(c == '6')
            countrycallingcodeandnewindex = new CountryCallingCodeAndNewIndex(66, l + 1);
          goto _L2
    }

    private static int tryGetISODigit(char c) {
        int i;
        if('0' <= c && c <= '9')
            i = c + -48;
        else
            i = -1;
        return i;
    }

    private static int tryGetTrunkPrefixOmittedIndex(String s, int i) {
        int j;
        int k;
        int l;
        j = -1;
        k = s.length();
        l = i;
_L7:
        if(l >= k) goto _L2; else goto _L1
_L1:
        char c = s.charAt(l);
        if(tryGetISODigit(c) < 0) goto _L4; else goto _L3
_L3:
        j = l + 1;
_L2:
        return j;
_L4:
        if(isDialable(c)) goto _L2; else goto _L5
_L5:
        l++;
        if(true) goto _L7; else goto _L6
_L6:
    }

    private static final int CCC_LENGTH = 0;
    private static final String CLIR_OFF = "#31#";
    private static final String CLIR_ON = "*31#";
    private static final boolean COUNTRY_CALLING_CALL[];
    private static final boolean DBG = false;
    public static final int FORMAT_JAPAN = 2;
    public static final int FORMAT_NANP = 1;
    public static final int FORMAT_UNKNOWN = 0;
    private static final Pattern GLOBAL_PHONE_NUMBER_PATTERN = Pattern.compile("[\\+]?[0-9.-]+");
    private static final SparseIntArray KEYPAD_MAP;
    static final String LOG_TAG = "PhoneNumberUtils";
    static final int MIN_MATCH = 7;
    private static final String NANP_COUNTRIES[];
    private static final String NANP_IDP_STRING = "011";
    private static final int NANP_LENGTH = 10;
    private static final int NANP_STATE_DASH = 4;
    private static final int NANP_STATE_DIGIT = 1;
    private static final int NANP_STATE_ONE = 3;
    private static final int NANP_STATE_PLUS = 2;
    public static final char PAUSE = 44;
    private static final char PLUS_SIGN_CHAR = 43;
    private static final String PLUS_SIGN_STRING = "+";
    public static final int TOA_International = 145;
    public static final int TOA_Unknown = 129;
    public static final char WAIT = 59;
    public static final char WILD = 78;

    static  {
        String as[] = new String[24];
        as[0] = "US";
        as[1] = "CA";
        as[2] = "AS";
        as[3] = "AI";
        as[4] = "AG";
        as[5] = "BS";
        as[6] = "BB";
        as[7] = "BM";
        as[8] = "VG";
        as[9] = "KY";
        as[10] = "DM";
        as[11] = "DO";
        as[12] = "GD";
        as[13] = "GU";
        as[14] = "JM";
        as[15] = "PR";
        as[16] = "MS";
        as[17] = "MP";
        as[18] = "KN";
        as[19] = "LC";
        as[20] = "VC";
        as[21] = "TT";
        as[22] = "TC";
        as[23] = "VI";
        NANP_COUNTRIES = as;
        KEYPAD_MAP = new SparseIntArray();
        KEYPAD_MAP.put(97, 50);
        KEYPAD_MAP.put(98, 50);
        KEYPAD_MAP.put(99, 50);
        KEYPAD_MAP.put(65, 50);
        KEYPAD_MAP.put(66, 50);
        KEYPAD_MAP.put(67, 50);
        KEYPAD_MAP.put(100, 51);
        KEYPAD_MAP.put(101, 51);
        KEYPAD_MAP.put(102, 51);
        KEYPAD_MAP.put(68, 51);
        KEYPAD_MAP.put(69, 51);
        KEYPAD_MAP.put(70, 51);
        KEYPAD_MAP.put(103, 52);
        KEYPAD_MAP.put(104, 52);
        KEYPAD_MAP.put(105, 52);
        KEYPAD_MAP.put(71, 52);
        KEYPAD_MAP.put(72, 52);
        KEYPAD_MAP.put(73, 52);
        KEYPAD_MAP.put(106, 53);
        KEYPAD_MAP.put(107, 53);
        KEYPAD_MAP.put(108, 53);
        KEYPAD_MAP.put(74, 53);
        KEYPAD_MAP.put(75, 53);
        KEYPAD_MAP.put(76, 53);
        KEYPAD_MAP.put(109, 54);
        KEYPAD_MAP.put(110, 54);
        KEYPAD_MAP.put(111, 54);
        KEYPAD_MAP.put(77, 54);
        KEYPAD_MAP.put(78, 54);
        KEYPAD_MAP.put(79, 54);
        KEYPAD_MAP.put(112, 55);
        KEYPAD_MAP.put(113, 55);
        KEYPAD_MAP.put(114, 55);
        KEYPAD_MAP.put(115, 55);
        KEYPAD_MAP.put(80, 55);
        KEYPAD_MAP.put(81, 55);
        KEYPAD_MAP.put(82, 55);
        KEYPAD_MAP.put(83, 55);
        KEYPAD_MAP.put(116, 56);
        KEYPAD_MAP.put(117, 56);
        KEYPAD_MAP.put(118, 56);
        KEYPAD_MAP.put(84, 56);
        KEYPAD_MAP.put(85, 56);
        KEYPAD_MAP.put(86, 56);
        KEYPAD_MAP.put(119, 57);
        KEYPAD_MAP.put(120, 57);
        KEYPAD_MAP.put(121, 57);
        KEYPAD_MAP.put(122, 57);
        KEYPAD_MAP.put(87, 57);
        KEYPAD_MAP.put(88, 57);
        KEYPAD_MAP.put(89, 57);
        KEYPAD_MAP.put(90, 57);
        boolean aflag[] = new boolean[100];
        aflag[0] = true;
        aflag[1] = true;
        aflag[2] = false;
        aflag[3] = false;
        aflag[4] = false;
        aflag[5] = false;
        aflag[6] = false;
        aflag[7] = true;
        aflag[8] = false;
        aflag[9] = false;
        aflag[10] = false;
        aflag[11] = false;
        aflag[12] = false;
        aflag[13] = false;
        aflag[14] = false;
        aflag[15] = false;
        aflag[16] = false;
        aflag[17] = false;
        aflag[18] = false;
        aflag[19] = false;
        aflag[20] = true;
        aflag[21] = false;
        aflag[22] = false;
        aflag[23] = false;
        aflag[24] = false;
        aflag[25] = false;
        aflag[26] = false;
        aflag[27] = true;
        aflag[28] = true;
        aflag[29] = false;
        aflag[30] = true;
        aflag[31] = true;
        aflag[32] = true;
        aflag[33] = true;
        aflag[34] = true;
        aflag[35] = false;
        aflag[36] = true;
        aflag[37] = false;
        aflag[38] = false;
        aflag[39] = true;
        aflag[40] = true;
        aflag[41] = false;
        aflag[42] = false;
        aflag[43] = true;
        aflag[44] = true;
        aflag[45] = true;
        aflag[46] = true;
        aflag[47] = true;
        aflag[48] = true;
        aflag[49] = true;
        aflag[50] = false;
        aflag[51] = true;
        aflag[52] = true;
        aflag[53] = true;
        aflag[54] = true;
        aflag[55] = true;
        aflag[56] = true;
        aflag[57] = true;
        aflag[58] = true;
        aflag[59] = false;
        aflag[60] = true;
        aflag[61] = true;
        aflag[62] = true;
        aflag[63] = true;
        aflag[64] = true;
        aflag[65] = true;
        aflag[66] = true;
        aflag[67] = false;
        aflag[68] = false;
        aflag[69] = false;
        aflag[70] = false;
        aflag[71] = false;
        aflag[72] = false;
        aflag[73] = false;
        aflag[74] = false;
        aflag[75] = false;
        aflag[76] = false;
        aflag[77] = false;
        aflag[78] = false;
        aflag[79] = false;
        aflag[80] = false;
        aflag[81] = true;
        aflag[82] = true;
        aflag[83] = true;
        aflag[84] = true;
        aflag[85] = false;
        aflag[86] = true;
        aflag[87] = false;
        aflag[88] = false;
        aflag[89] = true;
        aflag[90] = true;
        aflag[91] = true;
        aflag[92] = true;
        aflag[93] = true;
        aflag[94] = true;
        aflag[95] = true;
        aflag[96] = false;
        aflag[97] = false;
        aflag[98] = true;
        aflag[99] = false;
        COUNTRY_CALLING_CALL = aflag;
        CCC_LENGTH = COUNTRY_CALLING_CALL.length;
    }
}
