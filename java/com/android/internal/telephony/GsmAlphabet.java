// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.telephony;

import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseIntArray;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.*;

// Referenced classes of package com.android.internal.telephony:
//            EncodeException

public class GsmAlphabet {
    private static class LanguagePairCount {

        final int languageCode;
        final int septetCounts[];
        final int unencodableCounts[];

        LanguagePairCount(int i) {
            int j;
            languageCode = i;
            j = GsmAlphabet.sHighestEnabledSingleShiftCode;
            septetCounts = new int[j + 1];
            unencodableCounts = new int[j + 1];
            int k = 1;
            int l = 0;
            while(k <= j)  {
                if(GsmAlphabet.sEnabledSingleShiftTables[l] == k)
                    l++;
                else
                    septetCounts[k] = -1;
                k++;
            }
            if(i != 1 || j < 1) goto _L2; else goto _L1
_L1:
            septetCounts[1] = -1;
_L4:
            return;
_L2:
            if(i == 3 && j >= 2)
                septetCounts[2] = -1;
            if(true) goto _L4; else goto _L3
_L3:
        }
    }


    private GsmAlphabet() {
    }

    public static int charToGsm(char c) {
        int j = charToGsm(c, false);
        int i = j;
_L2:
        return i;
        EncodeException encodeexception;
        encodeexception;
        i = sCharsToGsmTables[0].get(32, 32);
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static int charToGsm(char c, boolean flag) throws EncodeException {
        int i = sCharsToGsmTables[0].get(c, -1);
        int j;
        if(i == -1) {
            if(sCharsToShiftTables[0].get(c, -1) == -1) {
                if(flag)
                    throw new EncodeException(c);
                j = sCharsToGsmTables[0].get(32, 32);
            } else {
                j = 27;
            }
        } else {
            j = i;
        }
        return j;
    }

    public static int charToGsmExtended(char c) {
        int i = sCharsToShiftTables[0].get(c, -1);
        if(i == -1)
            i = sCharsToGsmTables[0].get(32, 32);
        return i;
    }

    public static int countGsmSeptets(char c) {
        int i = 0;
        int j = countGsmSeptets(c, false);
        i = j;
_L2:
        return i;
        EncodeException encodeexception;
        encodeexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static int countGsmSeptets(char c, boolean flag) throws EncodeException {
        int i = 1;
        if(sCharsToGsmTables[0].get(c, -1) == -1) goto _L2; else goto _L1
_L1:
        return i;
_L2:
        if(sCharsToShiftTables[0].get(c, -1) == -1)
            break; /* Loop/switch isn't completed */
        i = 2;
        if(true) goto _L1; else goto _L3
_L3:
        if(!flag) goto _L1; else goto _L4
_L4:
        throw new EncodeException(c);
    }

    public static SmsMessageBase.TextEncodingDetails countGsmSeptets(CharSequence charsequence, boolean flag) {
        if(sEnabledSingleShiftTables.length + sEnabledLockingShiftTables.length != 0) goto _L2; else goto _L1
_L1:
        SmsMessageBase.TextEncodingDetails textencodingdetails;
        textencodingdetails = new SmsMessageBase.TextEncodingDetails();
        int i = countGsmSeptetsUsingTables(charsequence, flag, 0, 0);
        if(i == -1) {
            textencodingdetails = null;
        } else {
            textencodingdetails.codeUnitSize = 1;
            textencodingdetails.codeUnitCount = i;
            if(i > 160) {
                int k = (i + 152) / 153;
                textencodingdetails.msgCount = k;
                int l = 153 * textencodingdetails.msgCount - i;
                textencodingdetails.codeUnitsRemaining = l;
            } else {
                textencodingdetails.msgCount = 1;
                int j = 160 - i;
                textencodingdetails.codeUnitsRemaining = j;
            }
            textencodingdetails.codeUnitSize = 1;
        }
_L13:
        return textencodingdetails;
_L2:
        int i1;
        int j2;
        Iterator iterator;
        i1 = sHighestEnabledSingleShiftCode;
        ArrayList arraylist = new ArrayList(1 + sEnabledLockingShiftTables.length);
        arraylist.add(new LanguagePairCount(0));
        int ai[] = sEnabledLockingShiftTables;
        int j1 = ai.length;
        for(int k1 = 0; k1 < j1; k1++) {
            int k5 = ai[k1];
            if(k5 != 0 && !sLanguageTables[k5].isEmpty()) {
                LanguagePairCount languagepaircount2 = new LanguagePairCount(k5);
                arraylist.add(languagepaircount2);
            }
        }

        int l1 = charsequence.length();
        int i2 = 0;
        while(i2 < l1 && !arraylist.isEmpty())  {
            char c = charsequence.charAt(i2);
            if(c == '\033') {
                Log.w("GSM", "countGsmSeptets() string contains Escape character, ignoring!");
            } else {
                Iterator iterator1 = arraylist.iterator();
                while(iterator1.hasNext())  {
                    LanguagePairCount languagepaircount1 = (LanguagePairCount)iterator1.next();
                    if(sCharsToGsmTables[languagepaircount1.languageCode].get(c, -1) == -1) {
                        int j5 = 0;
                        while(j5 <= i1)  {
                            if(languagepaircount1.septetCounts[j5] != -1)
                                if(sCharsToShiftTables[j5].get(c, -1) == -1) {
                                    if(flag) {
                                        int ai3[] = languagepaircount1.septetCounts;
                                        ai3[j5] = 1 + ai3[j5];
                                        int ai4[] = languagepaircount1.unencodableCounts;
                                        ai4[j5] = 1 + ai4[j5];
                                    } else {
                                        languagepaircount1.septetCounts[j5] = -1;
                                    }
                                } else {
                                    int ai2[] = languagepaircount1.septetCounts;
                                    ai2[j5] = 2 + ai2[j5];
                                }
                            j5++;
                        }
                    } else {
                        int i5 = 0;
                        while(i5 <= i1)  {
                            if(languagepaircount1.septetCounts[i5] != -1) {
                                int ai1[] = languagepaircount1.septetCounts;
                                ai1[i5] = 1 + ai1[i5];
                            }
                            i5++;
                        }
                    }
                }
            }
            i2++;
        }
        textencodingdetails = new SmsMessageBase.TextEncodingDetails();
        textencodingdetails.msgCount = 0x7fffffff;
        textencodingdetails.codeUnitSize = 1;
        j2 = 0x7fffffff;
        iterator = arraylist.iterator();
_L4:
        LanguagePairCount languagepaircount;
        int k2;
        if(!iterator.hasNext())
            break MISSING_BLOCK_LABEL_825;
        languagepaircount = (LanguagePairCount)iterator.next();
        k2 = 0;
_L7:
        if(k2 > i1) goto _L4; else goto _L3
_L3:
        int l2 = languagepaircount.septetCounts[k2];
        if(l2 != -1) goto _L6; else goto _L5
_L5:
        k2++;
          goto _L7
_L6:
        byte byte0;
        int i3;
        int j3;
        int k3;
        int l3;
        int i4;
        int j4;
        int k4;
        if(languagepaircount.languageCode != 0 && k2 != 0)
            byte0 = 8;
        else
        if(languagepaircount.languageCode != 0 || k2 != 0)
            byte0 = 5;
        else
            byte0 = 0;
        if(l2 + byte0 > 160) {
            if(byte0 == 0)
                byte0 = 1;
            int l4 = 160 - (byte0 + 6);
            i3 = (-1 + (l2 + l4)) / l4;
            j3 = i3 * l4 - l2;
        } else {
            i3 = 1;
            j3 = 160 - byte0 - l2;
        }
        k3 = languagepaircount.unencodableCounts[k2];
        if(flag && k3 > j2) goto _L5; else goto _L8
_L8:
        if(flag && k3 < j2 || i3 < textencodingdetails.msgCount) goto _L10; else goto _L9
_L9:
        if(i3 != textencodingdetails.msgCount) goto _L5; else goto _L11
_L11:
        k4 = textencodingdetails.codeUnitsRemaining;
        if(j3 <= k4) goto _L5; else goto _L10
_L10:
        j2 = k3;
        textencodingdetails.msgCount = i3;
        textencodingdetails.codeUnitCount = l2;
        l3 = j3;
        textencodingdetails.codeUnitsRemaining = l3;
        i4 = languagepaircount.languageCode;
        textencodingdetails.languageTable = i4;
        j4 = k2;
        textencodingdetails.languageShiftTable = j4;
          goto _L5
        if(textencodingdetails.msgCount == 0x7fffffff)
            textencodingdetails = null;
        if(true) goto _L13; else goto _L12
_L12:
    }

    public static int countGsmSeptetsUsingTables(CharSequence charsequence, boolean flag, int i, int j) {
        int k;
        int l;
        SparseIntArray sparseintarray;
        SparseIntArray sparseintarray1;
        int i1;
        k = 0;
        l = charsequence.length();
        sparseintarray = sCharsToGsmTables[i];
        sparseintarray1 = sCharsToShiftTables[j];
        i1 = 0;
_L2:
        char c;
        if(i1 >= l)
            break MISSING_BLOCK_LABEL_121;
        c = charsequence.charAt(i1);
        if(c != '\033')
            break; /* Loop/switch isn't completed */
        Log.w("GSM", "countGsmSeptets() string contains Escape character, skipping.");
_L3:
        i1++;
        if(true) goto _L2; else goto _L1
_L1:
        if(sparseintarray.get(c, -1) != -1)
            k++;
        else
        if(sparseintarray1.get(c, -1) != -1) {
            k += 2;
        } else {
label0:
            {
                if(!flag)
                    break label0;
                k++;
            }
        }
          goto _L3
        if(true) goto _L2; else goto _L4
_L4:
        k = -1;
        return k;
    }

    public static int findGsmSeptetLimitIndex(String s, int i, int j, int k, int l) {
        int i1;
        int j1;
        SparseIntArray sparseintarray;
        SparseIntArray sparseintarray1;
        int k1;
        i1 = 0;
        j1 = s.length();
        sparseintarray = sCharsToGsmTables[k];
        sparseintarray1 = sCharsToShiftTables[l];
        k1 = i;
_L3:
        if(k1 >= j1)
            break MISSING_BLOCK_LABEL_100;
        if(sparseintarray.get(s.charAt(k1), -1) == -1) {
            if(sparseintarray1.get(s.charAt(k1), -1) == -1)
                i1++;
            else
                i1 += 2;
        } else {
            i1++;
        }
        if(i1 <= j) goto _L2; else goto _L1
_L1:
        return k1;
_L2:
        k1++;
          goto _L3
        k1 = j1;
          goto _L1
    }

    /**
     * @deprecated Method getEnabledLockingShiftTables is deprecated
     */

    static int[] getEnabledLockingShiftTables() {
        com/android/internal/telephony/GsmAlphabet;
        JVM INSTR monitorenter ;
        int ai[] = sEnabledLockingShiftTables;
        com/android/internal/telephony/GsmAlphabet;
        JVM INSTR monitorexit ;
        return ai;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getEnabledSingleShiftTables is deprecated
     */

    static int[] getEnabledSingleShiftTables() {
        com/android/internal/telephony/GsmAlphabet;
        JVM INSTR monitorenter ;
        int ai[] = sEnabledSingleShiftTables;
        com/android/internal/telephony/GsmAlphabet;
        JVM INSTR monitorexit ;
        return ai;
        Exception exception;
        exception;
        throw exception;
    }

    public static String gsm7BitPackedToString(byte abyte0[], int i, int j) {
        return gsm7BitPackedToString(abyte0, i, j, 0, 0, 0);
    }

    public static String gsm7BitPackedToString(byte abyte0[], int i, int j, int k, int l, int i1) {
        StringBuilder stringbuilder;
        boolean flag;
label0:
        {
            stringbuilder = new StringBuilder(j);
            if(l >= 0) {
                int l2 = sLanguageTables.length;
                if(l <= l2)
                    break label0;
            }
            Log.w("GSM", (new StringBuilder()).append("unknown language table ").append(l).append(", using default").toString());
            l = 0;
        }
label1:
        {
            if(i1 >= 0) {
                int k2 = sLanguageShiftTables.length;
                if(i1 <= k2)
                    break label1;
            }
            Log.w("GSM", (new StringBuilder()).append("unknown single shift table ").append(i1).append(", using default").toString());
            i1 = 0;
        }
        flag = false;
        String s1;
        String s2;
        s1 = sLanguageTables[l];
        s2 = sLanguageShiftTables[i1];
        if(s1.isEmpty()) {
            Log.w("GSM", (new StringBuilder()).append("no language table for code ").append(l).append(", using default").toString());
            s1 = sLanguageTables[0];
        }
        if(s2.isEmpty()) {
            Log.w("GSM", (new StringBuilder()).append("no single shift table for code ").append(i1).append(", using default").toString());
            s2 = sLanguageShiftTables[0];
        }
          goto _L1
_L13:
        int j1;
        if(j1 >= j) goto _L3; else goto _L2
_L2:
        int j2;
        int k1 = k + j1 * 7;
        int l1 = k1 / 8;
        int i2 = k1 % 8;
        j2 = 0x7f & abyte0[i + l1] >> i2;
        if(i2 > 1)
            j2 = j2 & 127 >> i2 - 1 | 0x7f & abyte0[1 + (i + l1)] << 8 - i2;
        if(!flag) goto _L5; else goto _L4
_L4:
        if(j2 != 27) goto _L7; else goto _L6
_L6:
        stringbuilder.append(' ');
          goto _L8
_L7:
        char c = s2.charAt(j2);
        if(c != ' ') goto _L10; else goto _L9
_L9:
        stringbuilder.append(s1.charAt(j2));
          goto _L8
        RuntimeException runtimeexception;
        runtimeexception;
        String s;
        Log.e("GSM", "Error GSM 7 bit packed: ", runtimeexception);
        s = null;
_L12:
        return s;
_L10:
        stringbuilder.append(c);
          goto _L8
_L15:
        stringbuilder.append(s1.charAt(j2));
          goto _L11
_L3:
        s = stringbuilder.toString();
          goto _L12
_L1:
        j1 = 0;
          goto _L13
_L8:
        flag = false;
_L11:
        j1++;
          goto _L13
_L5:
        if(j2 != 27) goto _L15; else goto _L14
_L14:
        flag = true;
          goto _L11
    }

    public static String gsm8BitUnpackedToString(byte abyte0[], int i, int j) {
        return gsm8BitUnpackedToString(abyte0, i, j, "");
    }

    public static String gsm8BitUnpackedToString(byte abyte0[], int i, int j, String s) {
        boolean flag;
        Charset charset;
        ByteBuffer bytebuffer;
        String s1;
        String s2;
        StringBuilder stringbuilder;
        boolean flag1;
        int k;
        flag = false;
        charset = null;
        bytebuffer = null;
        if(!TextUtils.isEmpty(s) && !s.equalsIgnoreCase("us-ascii") && Charset.isSupported(s)) {
            flag = true;
            charset = Charset.forName(s);
            bytebuffer = ByteBuffer.allocate(2);
        }
        s1 = sLanguageTables[0];
        s2 = sLanguageShiftTables[0];
        stringbuilder = new StringBuilder(j);
        flag1 = false;
        k = i;
_L2:
        int l;
        int i1;
label0:
        {
            if(k < i + j) {
                l = 0xff & abyte0[k];
                if(l != 255)
                    break label0;
            }
            return stringbuilder.toString();
        }
        if(l != 27)
            break; /* Loop/switch isn't completed */
        if(flag1) {
            stringbuilder.append(' ');
            flag1 = false;
            i1 = k;
        } else {
            flag1 = true;
            i1 = k;
        }
_L3:
        k = i1 + 1;
        if(true) goto _L2; else goto _L1
_L1:
        if(flag1) {
            char c = s2.charAt(l);
            if(c == ' ')
                stringbuilder.append(s1.charAt(l));
            else
                stringbuilder.append(c);
            i1 = k;
        } else
        if(!flag || l < 128 || k + 1 >= i + j) {
            stringbuilder.append(s1.charAt(l));
            i1 = k;
        } else {
            bytebuffer.clear();
            i1 = k + 1;
            bytebuffer.put(abyte0, k, 2);
            bytebuffer.flip();
            stringbuilder.append(charset.decode(bytebuffer).toString());
        }
        flag1 = false;
          goto _L3
        if(true) goto _L2; else goto _L4
_L4:
    }

    public static char gsmExtendedToChar(int i) {
        if(i != 27) goto _L2; else goto _L1
_L1:
        char c = ' ';
_L4:
        return c;
_L2:
        if(i >= 0 && i < 128) {
            c = sLanguageShiftTables[0].charAt(i);
            if(c == ' ')
                c = sLanguageTables[0].charAt(i);
        } else {
            c = ' ';
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static char gsmToChar(int i) {
        char c;
        if(i >= 0 && i < 128)
            c = sLanguageTables[0].charAt(i);
        else
            c = ' ';
        return c;
    }

    private static void packSmsChar(byte abyte0[], int i, int j) {
        int k = i / 8;
        int l = i % 8;
        int i1 = k + 1;
        abyte0[i1] = (byte)(abyte0[i1] | j << l);
        if(l > 1)
            abyte0[i1 + 1] = (byte)(j >> 8 - l);
    }

    /**
     * @deprecated Method setEnabledLockingShiftTables is deprecated
     */

    static void setEnabledLockingShiftTables(int ai[]) {
        com/android/internal/telephony/GsmAlphabet;
        JVM INSTR monitorenter ;
        sEnabledLockingShiftTables = ai;
        com/android/internal/telephony/GsmAlphabet;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setEnabledSingleShiftTables is deprecated
     */

    static void setEnabledSingleShiftTables(int ai[]) {
        com/android/internal/telephony/GsmAlphabet;
        JVM INSTR monitorenter ;
        sEnabledSingleShiftTables = ai;
        if(ai.length <= 0) goto _L2; else goto _L1
_L1:
        sHighestEnabledSingleShiftCode = ai[-1 + ai.length];
_L4:
        com/android/internal/telephony/GsmAlphabet;
        JVM INSTR monitorexit ;
        return;
_L2:
        sHighestEnabledSingleShiftCode = 0;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public static byte[] stringToGsm7BitPacked(String s) throws EncodeException {
        return stringToGsm7BitPacked(s, 0, true, 0, 0);
    }

    public static byte[] stringToGsm7BitPacked(String s, int i, int j) throws EncodeException {
        return stringToGsm7BitPacked(s, 0, true, i, j);
    }

    public static byte[] stringToGsm7BitPacked(String s, int i, boolean flag, int j, int k) throws EncodeException {
        int l = s.length();
        boolean flag1;
        int i1;
        if(!flag)
            flag1 = true;
        else
            flag1 = false;
        i1 = countGsmSeptetsUsingTables(s, flag1, j, k);
        if(i1 == -1)
            throw new EncodeException("countGsmSeptetsUsingTables(): unencodable char");
        int j1 = i1 + i;
        if(j1 > 255)
            throw new EncodeException("Payload cannot exceed 255 septets");
        byte abyte0[] = new byte[1 + (7 + j1 * 7) / 8];
        SparseIntArray sparseintarray = sCharsToGsmTables[j];
        SparseIntArray sparseintarray1 = sCharsToShiftTables[k];
        int k1 = 0;
        int l1 = i;
        int i2 = i * 7;
        while(k1 < l && l1 < j1)  {
            char c = s.charAt(k1);
            int j2 = sparseintarray.get(c, -1);
            if(j2 == -1) {
                j2 = sparseintarray1.get(c, -1);
                if(j2 == -1) {
                    if(flag)
                        throw new EncodeException("stringToGsm7BitPacked(): unencodable char");
                    j2 = sparseintarray.get(32, 32);
                } else {
                    packSmsChar(abyte0, i2, 27);
                    i2 += 7;
                    l1++;
                }
            }
            packSmsChar(abyte0, i2, j2);
            l1++;
            k1++;
            i2 += 7;
        }
        abyte0[0] = (byte)j1;
        return abyte0;
    }

    public static byte[] stringToGsm7BitPackedWithHeader(String s, byte abyte0[]) throws EncodeException {
        return stringToGsm7BitPackedWithHeader(s, abyte0, 0, 0);
    }

    public static byte[] stringToGsm7BitPackedWithHeader(String s, byte abyte0[], int i, int j) throws EncodeException {
        byte abyte1[];
        if(abyte0 == null || abyte0.length == 0) {
            abyte1 = stringToGsm7BitPacked(s, i, j);
        } else {
            abyte1 = stringToGsm7BitPacked(s, (6 + 8 * (1 + abyte0.length)) / 7, true, i, j);
            abyte1[1] = (byte)abyte0.length;
            System.arraycopy(abyte0, 0, abyte1, 2, abyte0.length);
        }
        return abyte1;
    }

    public static byte[] stringToGsm8BitPacked(String s) {
        byte abyte0[] = new byte[countGsmSeptetsUsingTables(s, true, 0, 0)];
        stringToGsm8BitUnpackedField(s, abyte0, 0, abyte0.length);
        return abyte0;
    }

    public static void stringToGsm8BitUnpackedField(String s, byte abyte0[], int i, int j) {
        SparseIntArray sparseintarray;
        SparseIntArray sparseintarray1;
        int k;
        int l;
        int i1;
        sparseintarray = sCharsToGsmTables[0];
        sparseintarray1 = sCharsToShiftTables[0];
        k = 0;
        l = s.length();
        i1 = i;
_L5:
        if(k >= l || i1 - i >= j) goto _L2; else goto _L1
_L1:
        int k1;
        char c = s.charAt(k);
        k1 = sparseintarray.get(c, -1);
        if(k1 != -1)
            break MISSING_BLOCK_LABEL_172;
        k1 = sparseintarray1.get(c, -1);
        if(k1 != -1) goto _L4; else goto _L3
_L3:
        int l1;
        k1 = sparseintarray.get(32, 32);
        l1 = i1;
_L7:
        i1 = l1 + 1;
        abyte0[l1] = (byte)k1;
        k++;
          goto _L5
_L4:
        if((i1 + 1) - i < j) goto _L6; else goto _L2
_L6:
        l1 = i1 + 1;
        abyte0[i1] = 27;
          goto _L7
_L2:
        int j1;
        for(; i1 - i < j; i1 = j1) {
            j1 = i1 + 1;
            abyte0[i1] = -1;
        }

        return;
        l1 = i1;
          goto _L7
    }

    public static final byte GSM_EXTENDED_ESCAPE = 27;
    private static final String TAG = "GSM";
    public static final int UDH_SEPTET_COST_CONCATENATED_MESSAGE = 6;
    public static final int UDH_SEPTET_COST_LENGTH = 1;
    public static final int UDH_SEPTET_COST_ONE_SHIFT_TABLE = 4;
    public static final int UDH_SEPTET_COST_TWO_SHIFT_TABLES = 7;
    private static final SparseIntArray sCharsToGsmTables[];
    private static final SparseIntArray sCharsToShiftTables[];
    private static int sEnabledLockingShiftTables[];
    private static int sEnabledSingleShiftTables[];
    private static int sHighestEnabledSingleShiftCode;
    private static final String sLanguageShiftTables[];
    private static final String sLanguageTables[];

    static  {
        String as[] = new String[14];
        as[0] = "@\243$\245\350\351\371\354\362\307\n\330\370\r\305\345\u0394_\u03A6\u0393\u039B\u03A9\u03A0\u03A8\u03A3\u0398\u039E\uFFFF\306\346\337\311 !\"#\244%&'()*+,-./0123456789:;<=>?\241ABCDEFGHIJKLMNOPQRSTUVWXYZ\304\326\321\334\247\277abcdefghijklmnopqrstuvwxyz\344\366\361\374\340";
        as[1] = "@\243$\245\u20AC\351\371\u0131\362\307\n\u011E\u011F\r\305\345\u0394_\u03A6\u0393\u039B\u03A9\u03A0\u03A8\u03A3\u0398\u039E\uFFFF\u015E\u015F\337\311 !\"#\244%&'()*+,-./0123456789:;<=>?\u0130ABCDEFGHIJKLMNOPQRSTUVWXYZ\304\326\321\334\247\347abcdefghijklmnopqrstuvwxyz\344\366\361\374\340";
        as[2] = "";
        as[3] = "@\243$\245\352\351\372\355\363\347\n\324\364\r\301\341\u0394_\252\307\300\u221E^\\\u20AC\323|\uFFFF\302\342\312\311 !\"#\272%&'()*+,-./0123456789:;<=>?\315ABCDEFGHIJKLMNOPQRSTUVWXYZ\303\325\332\334\247~abcdefghijklmnopqrstuvwxyz\343\365`\374\340";
        as[4] = "\u0981\u0982\u0983\u0985\u0986\u0987\u0988\u0989\u098A\u098B\n\u098C \r \u098F\u0990  \u0993\u0994\u0995\u0996\u0997\u0998\u0999\u099A\uFFFF\u099B\u099C\u099D\u099E !\u099F\u09A0\u09A1\u09A2\u09A3\u09A4)(\u09A5\u09A6,\u09A7.\u09A80123456789:; \u09AA\u09AB?\u09AC\u09AD\u09AE\u09AF\u09B0 \u09B2   \u09B6\u09B7\u09B8\u09B9\u09BC\u09BD\u09BE\u09BF\u09C0\u09C1\u09C2\u09C3\u09C4  \u09C7\u09C8  \u09CB\u09CC\u09CD\u09CEabcdefghijklmnopqrstuvwxyz\u09D7\u09DC\u09DD\u09F0\u09F1";
        as[5] = "\u0A81\u0A82\u0A83\u0A85\u0A86\u0A87\u0A88\u0A89\u0A8A\u0A8B\n\u0A8C\u0A8D\r \u0A8F\u0A90\u0A91 \u0A93\u0A94\u0A95\u0A96\u0A97\u0A98\u0A99\u0A9A\uFFFF\u0A9B\u0A9C\u0A9D\u0A9E !\u0A9F\u0AA0\u0AA1\u0AA2\u0AA3\u0AA4)(\u0AA5\u0AA6,\u0AA7.\u0AA80123456789:; \u0AAA\u0AAB?\u0AAC\u0AAD\u0AAE\u0AAF\u0AB0 \u0AB2\u0AB3 \u0AB5\u0AB6\u0AB7\u0AB8\u0AB9\u0ABC\u0ABD\u0ABE\u0ABF\u0AC0\u0AC1\u0AC2\u0AC3\u0AC4\u0AC5 \u0AC7\u0AC8\u0AC9 \u0ACB\u0ACC\u0ACD\u0AD0abcdefghijklmnopqrstuvwxyz\u0AE0\u0AE1\u0AE2\u0AE3\u0AF1";
        as[6] = "\u0901\u0902\u0903\u0905\u0906\u0907\u0908\u0909\u090A\u090B\n\u090C\u090D\r\u090E\u090F\u0910\u0911\u0912\u0913\u0914\u0915\u0916\u0917\u0918\u0919\u091A\uFFFF\u091B\u091C\u091D\u091E !\u091F\u0920\u0921\u0922\u0923\u0924)(\u0925\u0926,\u0927.\u09280123456789:;\u0929\u092A\u092B?\u092C\u092D\u092E\u092F\u0930\u0931\u0932\u0933\u0934\u0935\u0936\u0937\u0938\u0939\u093C\u093D\u093E\u093F\u0940\u0941\u0942\u0943\u0944\u0945\u0946\u0947\u0948\u0949\u094A\u094B\u094C\u094D\u0950abcdefghijklmnopqrstuvwxyz\u0972\u097B\u097C\u097E\u097F";
        as[7] = " \u0C82\u0C83\u0C85\u0C86\u0C87\u0C88\u0C89\u0C8A\u0C8B\n\u0C8C \r\u0C8E\u0C8F\u0C90 \u0C92\u0C93\u0C94\u0C95\u0C96\u0C97\u0C98\u0C99\u0C9A\uFFFF\u0C9B\u0C9C\u0C9D\u0C9E !\u0C9F\u0CA0\u0CA1\u0CA2\u0CA3\u0CA4)(\u0CA5\u0CA6,\u0CA7.\u0CA80123456789:; \u0CAA\u0CAB?\u0CAC\u0CAD\u0CAE\u0CAF\u0CB0\u0CB1\u0CB2\u0CB3 \u0CB5\u0CB6\u0CB7\u0CB8\u0CB9\u0CBC\u0CBD\u0CBE\u0CBF\u0CC0\u0CC1\u0CC2\u0CC3\u0CC4 \u0CC6\u0CC7\u0CC8 \u0CCA\u0CCB\u0CCC\u0CCD\u0CD5abcdefghijklmnopqrstuvwxyz\u0CD6\u0CE0\u0CE1\u0CE2\u0CE3";
        as[8] = " \u0D02\u0D03\u0D05\u0D06\u0D07\u0D08\u0D09\u0D0A\u0D0B\n\u0D0C \r\u0D0E\u0D0F\u0D10 \u0D12\u0D13\u0D14\u0D15\u0D16\u0D17\u0D18\u0D19\u0D1A\uFFFF\u0D1B\u0D1C\u0D1D\u0D1E !\u0D1F\u0D20\u0D21\u0D22\u0D23\u0D24)(\u0D25\u0D26,\u0D27.\u0D280123456789:; \u0D2A\u0D2B?\u0D2C\u0D2D\u0D2E\u0D2F\u0D30\u0D31\u0D32\u0D33\u0D34\u0D35\u0D36\u0D37\u0D38\u0D39 \u0D3D\u0D3E\u0D3F\u0D40\u0D41\u0D42\u0D43\u0D44 \u0D46\u0D47\u0D48 \u0D4A\u0D4B\u0D4C\u0D4D\u0D57abcdefghijklmnopqrstuvwxyz\u0D60\u0D61\u0D62\u0D63\u0D79";
        as[9] = "\u0B01\u0B02\u0B03\u0B05\u0B06\u0B07\u0B08\u0B09\u0B0A\u0B0B\n\u0B0C \r \u0B0F\u0B10  \u0B13\u0B14\u0B15\u0B16\u0B17\u0B18\u0B19\u0B1A\uFFFF\u0B1B\u0B1C\u0B1D\u0B1E !\u0B1F\u0B20\u0B21\u0B22\u0B23\u0B24)(\u0B25\u0B26,\u0B27.\u0B280123456789:; \u0B2A\u0B2B?\u0B2C\u0B2D\u0B2E\u0B2F\u0B30 \u0B32\u0B33 \u0B35\u0B36\u0B37\u0B38\u0B39\u0B3C\u0B3D\u0B3E\u0B3F\u0B40\u0B41\u0B42\u0B43\u0B44  \u0B47\u0B48  \u0B4B\u0B4C\u0B4D\u0B56abcdefghijklmnopqrstuvwxyz\u0B57\u0B60\u0B61\u0B62\u0B63";
        as[10] = "\u0A01\u0A02\u0A03\u0A05\u0A06\u0A07\u0A08\u0A09\u0A0A \n  \r \u0A0F\u0A10  \u0A13\u0A14\u0A15\u0A16\u0A17\u0A18\u0A19\u0A1A\uFFFF\u0A1B\u0A1C\u0A1D\u0A1E !\u0A1F\u0A20\u0A21\u0A22\u0A23\u0A24)(\u0A25\u0A26,\u0A27.\u0A280123456789:; \u0A2A\u0A2B?\u0A2C\u0A2D\u0A2E\u0A2F\u0A30 \u0A32\u0A33 \u0A35\u0A36 \u0A38\u0A39\u0A3C \u0A3E\u0A3F\u0A40\u0A41\u0A42    \u0A47\u0A48  \u0A4B\u0A4C\u0A4D\u0A51abcdefghijklmnopqrstuvwxyz\u0A70\u0A71\u0A72\u0A73\u0A74";
        as[11] = " \u0B82\u0B83\u0B85\u0B86\u0B87\u0B88\u0B89\u0B8A \n  \r\u0B8E\u0B8F\u0B90 \u0B92\u0B93\u0B94\u0B95   \u0B99\u0B9A\uFFFF \u0B9C \u0B9E !\u0B9F   \u0BA3\u0BA4)(  , .\u0BA80123456789:;\u0BA9\u0BAA ?  \u0BAE\u0BAF\u0BB0\u0BB1\u0BB2\u0BB3\u0BB4\u0BB5\u0BB6\u0BB7\u0BB8\u0BB9  \u0BBE\u0BBF\u0BC0\u0BC1\u0BC2   \u0BC6\u0BC7\u0BC8 \u0BCA\u0BCB\u0BCC\u0BCD\u0BD0abcdefghijklmnopqrstuvwxyz\u0BD7\u0BF0\u0BF1\u0BF2\u0BF9";
        as[12] = "\u0C01\u0C02\u0C03\u0C05\u0C06\u0C07\u0C08\u0C09\u0C0A\u0C0B\n\u0C0C \r\u0C0E\u0C0F\u0C10 \u0C12\u0C13\u0C14\u0C15\u0C16\u0C17\u0C18\u0C19\u0C1A\uFFFF\u0C1B\u0C1C\u0C1D\u0C1E !\u0C1F\u0C20\u0C21\u0C22\u0C23\u0C24)(\u0C25\u0C26,\u0C27.\u0C280123456789:; \u0C2A\u0C2B?\u0C2C\u0C2D\u0C2E\u0C2F\u0C30\u0C31\u0C32\u0C33 \u0C35\u0C36\u0C37\u0C38\u0C39 \u0C3D\u0C3E\u0C3F\u0C40\u0C41\u0C42\u0C43\u0C44 \u0C46\u0C47\u0C48 \u0C4A\u0C4B\u0C4C\u0C4D\u0C55abcdefghijklmnopqrstuvwxyz\u0C56\u0C60\u0C61\u0C62\u0C63";
        as[13] = "\u0627\u0622\u0628\u067B\u0680\u067E\u06A6\u062A\u06C2\u067F\n\u0679\u067D\r\u067A\u067C\u062B\u062C\u0681\u0684\u0683\u0685\u0686\u0687\u062D\u062E\u062F\uFFFF\u068C\u0688\u0689\u068A !\u068F\u068D\u0630\u0631\u0691\u0693)(\u0699\u0632,\u0696.\u06980123456789:;\u069A\u0633\u0634?\u0635\u0636\u0637\u0638\u0639\u0641\u0642\u06A9\u06AA\u06AB\u06AF\u06B3\u06B1\u0644\u0645\u0646\u06BA\u06BB\u06BC\u0648\u06C4\u06D5\u06C1\u06BE\u0621\u06CC\u06D0\u06D2\u064D\u0650\u064F\u0657\u0654abcdefghijklmnopqrstuvwxyz\u0655\u0651\u0653\u0656\u0670";
        sLanguageTables = as;
        String as1[] = new String[14];
        as1[0] = "          \f         ^                   {}     \\            [~] |                                    \u20AC                          ";
        as1[1] = "          \f         ^                   {}     \\            [~] |      \u011E \u0130         \u015E               \347 \u20AC \u011F \u0131         \u015F            ";
        as1[2] = "         \347\f         ^                   {}     \\            [~] |\301       \315     \323     \332           \341   \u20AC   \355     \363     \372          ";
        as1[3] = "     \352   \347\f\324\364 \301\341  \u03A6\u0393^\u03A9\u03A0\u03A8\u03A3\u0398     \312        {}     \\            [~] |\300       \315     \323     \332     \303\325    \302   \u20AC   \355     \363     \372     \343\365  \342";
        as1[4] = "@\243$\245\277\"\244%&'\f*+ -/<=>\241^\241_#*\u09E6\u09E7 \u09E8\u09E9\u09EA\u09EB\u09EC\u09ED\u09EE\u09EF\u09DF\u09E0\u09E1\u09E2{}\u09E3\u09F2\u09F3\u09F4\u09F5\\\u09F6\u09F7\u09F8\u09F9\u09FA       [~] |ABCDEFGHIJKLMNOPQRSTUVWXYZ          \u20AC                          ";
        as1[5] = "@\243$\245\277\"\244%&'\f*+ -/<=>\241^\241_#*\u0964\u0965 \u0AE6\u0AE7\u0AE8\u0AE9\u0AEA\u0AEB\u0AEC\u0AED\u0AEE\u0AEF  {}     \\            [~] |ABCDEFGHIJKLMNOPQRSTUVWXYZ          \u20AC                          ";
        as1[6] = "@\243$\245\277\"\244%&'\f*+ -/<=>\241^\241_#*\u0964\u0965 \u0966\u0967\u0968\u0969\u096A\u096B\u096C\u096D\u096E\u096F\u0951\u0952{}\u0953\u0954\u0958\u0959\u095A\\\u095B\u095C\u095D\u095E\u095F\u0960\u0961\u0962\u0963\u0970\u0971 [~] |ABCDEFGHIJKLMNOPQRSTUVWXYZ          \u20AC                          ";
        as1[7] = "@\243$\245\277\"\244%&'\f*+ -/<=>\241^\241_#*\u0964\u0965 \u0CE6\u0CE7\u0CE8\u0CE9\u0CEA\u0CEB\u0CEC\u0CED\u0CEE\u0CEF\u0CDE\u0CF1{}\u0CF2    \\            [~] |ABCDEFGHIJKLMNOPQRSTUVWXYZ          \u20AC                          ";
        as1[8] = "@\243$\245\277\"\244%&'\f*+ -/<=>\241^\241_#*\u0964\u0965 \u0D66\u0D67\u0D68\u0D69\u0D6A\u0D6B\u0D6C\u0D6D\u0D6E\u0D6F\u0D70\u0D71{}\u0D72\u0D73\u0D74\u0D75\u0D7A\\\u0D7B\u0D7C\u0D7D\u0D7E\u0D7F       [~] |ABCDEFGHIJKLMNOPQRSTUVWXYZ          \u20AC                          ";
        as1[9] = "@\243$\245\277\"\244%&'\f*+ -/<=>\241^\241_#*\u0964\u0965 \u0B66\u0B67\u0B68\u0B69\u0B6A\u0B6B\u0B6C\u0B6D\u0B6E\u0B6F\u0B5C\u0B5D{}\u0B5F\u0B70\u0B71  \\            [~] |ABCDEFGHIJKLMNOPQRSTUVWXYZ          \u20AC                          ";
        as1[10] = "@\243$\245\277\"\244%&'\f*+ -/<=>\241^\241_#*\u0964\u0965 \u0A66\u0A67\u0A68\u0A69\u0A6A\u0A6B\u0A6C\u0A6D\u0A6E\u0A6F\u0A59\u0A5A{}\u0A5B\u0A5C\u0A5E\u0A75 \\            [~] |ABCDEFGHIJKLMNOPQRSTUVWXYZ          \u20AC                          ";
        as1[11] = "@\243$\245\277\"\244%&'\f*+ -/<=>\241^\241_#*\u0964\u0965 \u0BE6\u0BE7\u0BE8\u0BE9\u0BEA\u0BEB\u0BEC\u0BED\u0BEE\u0BEF\u0BF3\u0BF4{}\u0BF5\u0BF6\u0BF7\u0BF8\u0BFA\\            [~] |ABCDEFGHIJKLMNOPQRSTUVWXYZ          \u20AC                          ";
        as1[12] = "@\243$\245\277\"\244%&'\f*+ -/<=>\241^\241_#*   \u0C66\u0C67\u0C68\u0C69\u0C6A\u0C6B\u0C6C\u0C6D\u0C6E\u0C6F\u0C58\u0C59{}\u0C78\u0C79\u0C7A\u0C7B\u0C7C\\\u0C7D\u0C7E\u0C7F         [~] |ABCDEFGHIJKLMNOPQRSTUVWXYZ          \u20AC                          ";
        as1[13] = "@\243$\245\277\"\244%&'\f*+ -/<=>\241^\241_#*\u0600\u0601 \u06F0\u06F1\u06F2\u06F3\u06F4\u06F5\u06F6\u06F7\u06F8\u06F9\u060C\u060D{}\u060E\u060F\u0610\u0611\u0612\\\u0613\u0614\u061B\u061F\u0640\u0652\u0658\u066B\u066C\u0672\u0673\u06CD[~]\u06D4|ABCDEFGHIJKLMNOPQRSTUVWXYZ          \u20AC                          ";
        sLanguageShiftTables = as1;
        Resources resources = Resources.getSystem();
        sEnabledSingleShiftTables = resources.getIntArray(0x107002c);
        sEnabledLockingShiftTables = resources.getIntArray(0x107002d);
        int i = sLanguageTables.length;
        int j = sLanguageShiftTables.length;
        if(i != j)
            Log.e("GSM", (new StringBuilder()).append("Error: language tables array length ").append(i).append(" != shift tables array length ").append(j).toString());
        if(sEnabledSingleShiftTables.length > 0)
            sHighestEnabledSingleShiftCode = sEnabledSingleShiftTables[-1 + sEnabledSingleShiftTables.length];
        else
            sHighestEnabledSingleShiftCode = 0;
        sCharsToGsmTables = new SparseIntArray[i];
        for(int k = 0; k < i; k++) {
            String s1 = sLanguageTables[k];
            int k1 = s1.length();
            if(k1 != 0 && k1 != 128)
                Log.e("GSM", (new StringBuilder()).append("Error: language tables index ").append(k).append(" length ").append(k1).append(" (expected 128 or 0)").toString());
            SparseIntArray sparseintarray1 = new SparseIntArray(k1);
            sCharsToGsmTables[k] = sparseintarray1;
            for(int l1 = 0; l1 < k1; l1++)
                sparseintarray1.put(s1.charAt(l1), l1);

        }

        sCharsToShiftTables = new SparseIntArray[i];
        for(int l = 0; l < j; l++) {
            String s = sLanguageShiftTables[l];
            int i1 = s.length();
            if(i1 != 0 && i1 != 128)
                Log.e("GSM", (new StringBuilder()).append("Error: language shift tables index ").append(l).append(" length ").append(i1).append(" (expected 128 or 0)").toString());
            SparseIntArray sparseintarray = new SparseIntArray(i1);
            sCharsToShiftTables[l] = sparseintarray;
            for(int j1 = 0; j1 < i1; j1++) {
                char c = s.charAt(j1);
                if(c != ' ')
                    sparseintarray.put(c, j1);
            }

        }

    }


}
