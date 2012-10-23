// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;

import java.io.UnsupportedEncodingException;

public class Base64 {
    static class Encoder extends Coder {

        public int maxOutputSize(int i) {
            return 10 + (i * 8) / 5;
        }

        public boolean process(byte abyte0[], int i, int j, boolean flag) {
            byte abyte1[];
            byte abyte2[];
            int k;
            int l;
            int i1;
            int j1;
            int k1;
            abyte1 = alphabet;
            abyte2 = super.output;
            k = 0;
            l = count;
            i1 = i;
            j1 = j + i;
            k1 = -1;
            tailLen;
            JVM INSTR tableswitch 0 2: default 64
        //                       0 64
        //                       1 390
        //                       2 463;
               goto _L1 _L1 _L2 _L3
_L1:
            int k2;
            if(k1 == -1)
                break MISSING_BLOCK_LABEL_1281;
            int j9 = 0 + 1;
            abyte2[k] = abyte1[0x3f & k1 >> 18];
            int k9 = j9 + 1;
            abyte2[j9] = abyte1[0x3f & k1 >> 12];
            int l9 = k9 + 1;
            abyte2[k9] = abyte1[0x3f & k1 >> 6];
            k = l9 + 1;
            abyte2[l9] = abyte1[k1 & 0x3f];
            if(--l != 0)
                break MISSING_BLOCK_LABEL_1281;
            if(do_cr) {
                int i10 = k + 1;
                abyte2[k] = 13;
                k = i10;
            }
            k2 = k + 1;
            abyte2[k] = 10;
            l = 19;
_L13:
            int j2;
            for(j2 = i1; j2 + 3 <= j1; j2 = i1) {
                int l8 = (0xff & abyte0[j2]) << 16 | (0xff & abyte0[j2 + 1]) << 8 | 0xff & abyte0[j2 + 2];
                abyte2[k2] = abyte1[0x3f & l8 >> 18];
                abyte2[k2 + 1] = abyte1[0x3f & l8 >> 12];
                abyte2[k2 + 2] = abyte1[0x3f & l8 >> 6];
                abyte2[k2 + 3] = abyte1[l8 & 0x3f];
                i1 = j2 + 3;
                k = k2 + 4;
                if(--l != 0)
                    break MISSING_BLOCK_LABEL_1281;
                if(do_cr) {
                    int i9 = k + 1;
                    abyte2[k] = 13;
                    k = i9;
                }
                k2 = k + 1;
                abyte2[k] = 10;
                l = 19;
            }

              goto _L4
_L2:
            if(i1 + 2 <= j1) {
                int j10 = (0xff & tail[0]) << 16;
                int k10 = i1 + 1;
                int l10 = j10 | (0xff & abyte0[i1]) << 8;
                i1 = k10 + 1;
                k1 = l10 | 0xff & abyte0[k10];
                tailLen = 0;
            }
              goto _L1
_L3:
            if(i1 + 1 <= j1) {
                int l1 = (0xff & tail[0]) << 16 | (0xff & tail[1]) << 8;
                int i2 = i1 + 1;
                k1 = l1 | 0xff & abyte0[i1];
                tailLen = 0;
                i1 = i2;
            }
              goto _L1
_L4:
            if(!flag) goto _L6; else goto _L5
_L5:
            if(j2 - tailLen != j1 - 1) goto _L8; else goto _L7
_L7:
            int l2;
            int l3;
            int l5;
            int i7 = 0;
            byte byte2;
            int j7;
            int k7;
            int l7;
            int i8;
            if(tailLen > 0) {
                byte abyte8[] = tail;
                int k8 = 0 + 1;
                byte2 = abyte8[0];
                i7 = k8;
                l3 = j2;
            } else {
                l3 = j2 + 1;
                byte2 = abyte0[j2];
            }
            j7 = (byte2 & 0xff) << 4;
            tailLen = tailLen - i7;
            k7 = k2 + 1;
            abyte2[k2] = abyte1[0x3f & j7 >> 6];
            l7 = k7 + 1;
            abyte2[k7] = abyte1[j7 & 0x3f];
            if(do_padding) {
                int j8 = l7 + 1;
                abyte2[l7] = 61;
                l7 = j8 + 1;
                abyte2[j8] = 61;
            }
            l2 = l7;
            if(!do_newline) goto _L10; else goto _L9
_L9:
            if(do_cr) {
                i8 = l2 + 1;
                abyte2[l2] = 13;
                l2 = i8;
            }
            l5 = l2 + 1;
            abyte2[l2] = 10;
_L12:
            l2 = l5;
_L10:
            if(!$assertionsDisabled && tailLen != 0)
                throw new AssertionError();
              goto _L11
_L8:
            if(j2 - tailLen == j1 - 2) {
                int j4 = 0;
                byte byte0;
                int k4;
                byte byte1;
                int i5;
                int j5;
                int k5;
                if(tailLen > 1) {
                    byte abyte7[] = tail;
                    int l6 = 0 + 1;
                    byte0 = abyte7[0];
                    j4 = l6;
                    l3 = j2;
                } else {
                    l3 = j2 + 1;
                    byte0 = abyte0[j2];
                }
                k4 = (byte0 & 0xff) << 10;
                if(tailLen > 0) {
                    byte abyte6[] = tail;
                    int k6 = j4 + 1;
                    byte1 = abyte6[j4];
                    j4 = k6;
                } else {
                    int l4 = l3 + 1;
                    byte1 = abyte0[l3];
                    l3 = l4;
                }
                i5 = k4 | (byte1 & 0xff) << 2;
                tailLen = tailLen - j4;
                j5 = k2 + 1;
                abyte2[k2] = abyte1[0x3f & i5 >> 12];
                k5 = j5 + 1;
                abyte2[j5] = abyte1[0x3f & i5 >> 6];
                l2 = k5 + 1;
                abyte2[k5] = abyte1[i5 & 0x3f];
                if(do_padding) {
                    int j6 = l2 + 1;
                    abyte2[l2] = 61;
                    l2 = j6;
                }
                if(do_newline) {
                    if(do_cr) {
                        int i6 = l2 + 1;
                        abyte2[l2] = 13;
                        l2 = i6;
                    }
                    l5 = l2 + 1;
                    abyte2[l2] = 10;
                    continue; /* Loop/switch isn't completed */
                }
            } else {
                if(do_newline && k2 > 0 && l != 19) {
                    byte abyte3[];
                    int i3;
                    byte abyte4[];
                    int j3;
                    byte abyte5[];
                    int k3;
                    int i4;
                    if(do_cr) {
                        i4 = k2 + 1;
                        abyte2[k2] = 13;
                    } else {
                        i4 = k2;
                    }
                    k2 = i4 + 1;
                    abyte2[i4] = 10;
                }
                l3 = j2;
                l2 = k2;
            }
            if(true) goto _L10; else goto _L11
_L11:
            if(!$assertionsDisabled && l3 != j1)
                throw new AssertionError();
            break MISSING_BLOCK_LABEL_1181;
            if(true) goto _L12; else goto _L6
_L6:
            if(j2 == j1 - 1) {
                abyte5 = tail;
                k3 = tailLen;
                tailLen = k3 + 1;
                abyte5[k3] = abyte0[j2];
                j2;
                l2 = k2;
            } else {
                if(j2 == j1 - 2) {
                    abyte3 = tail;
                    i3 = tailLen;
                    tailLen = i3 + 1;
                    abyte3[i3] = abyte0[j2];
                    abyte4 = tail;
                    j3 = tailLen;
                    tailLen = j3 + 1;
                    abyte4[j3] = abyte0[j2 + 1];
                }
                j2;
                l2 = k2;
            }
            super.op = l2;
            count = l;
            return true;
            j2 = i1;
            k2 = k;
              goto _L13
        }

        static final boolean $assertionsDisabled = false;
        private static final byte ENCODE[];
        private static final byte ENCODE_WEBSAFE[];
        public static final int LINE_GROUPS = 19;
        private final byte alphabet[];
        private int count;
        public final boolean do_cr;
        public final boolean do_newline;
        public final boolean do_padding;
        private final byte tail[] = new byte[2];
        int tailLen;

        static  {
            boolean flag;
            byte abyte0[];
            byte abyte1[];
            if(!android/util/Base64.desiredAssertionStatus())
                flag = true;
            else
                flag = false;
            $assertionsDisabled = flag;
            abyte0 = new byte[64];
            abyte0[0] = 65;
            abyte0[1] = 66;
            abyte0[2] = 67;
            abyte0[3] = 68;
            abyte0[4] = 69;
            abyte0[5] = 70;
            abyte0[6] = 71;
            abyte0[7] = 72;
            abyte0[8] = 73;
            abyte0[9] = 74;
            abyte0[10] = 75;
            abyte0[11] = 76;
            abyte0[12] = 77;
            abyte0[13] = 78;
            abyte0[14] = 79;
            abyte0[15] = 80;
            abyte0[16] = 81;
            abyte0[17] = 82;
            abyte0[18] = 83;
            abyte0[19] = 84;
            abyte0[20] = 85;
            abyte0[21] = 86;
            abyte0[22] = 87;
            abyte0[23] = 88;
            abyte0[24] = 89;
            abyte0[25] = 90;
            abyte0[26] = 97;
            abyte0[27] = 98;
            abyte0[28] = 99;
            abyte0[29] = 100;
            abyte0[30] = 101;
            abyte0[31] = 102;
            abyte0[32] = 103;
            abyte0[33] = 104;
            abyte0[34] = 105;
            abyte0[35] = 106;
            abyte0[36] = 107;
            abyte0[37] = 108;
            abyte0[38] = 109;
            abyte0[39] = 110;
            abyte0[40] = 111;
            abyte0[41] = 112;
            abyte0[42] = 113;
            abyte0[43] = 114;
            abyte0[44] = 115;
            abyte0[45] = 116;
            abyte0[46] = 117;
            abyte0[47] = 118;
            abyte0[48] = 119;
            abyte0[49] = 120;
            abyte0[50] = 121;
            abyte0[51] = 122;
            abyte0[52] = 48;
            abyte0[53] = 49;
            abyte0[54] = 50;
            abyte0[55] = 51;
            abyte0[56] = 52;
            abyte0[57] = 53;
            abyte0[58] = 54;
            abyte0[59] = 55;
            abyte0[60] = 56;
            abyte0[61] = 57;
            abyte0[62] = 43;
            abyte0[63] = 47;
            ENCODE = abyte0;
            abyte1 = new byte[64];
            abyte1[0] = 65;
            abyte1[1] = 66;
            abyte1[2] = 67;
            abyte1[3] = 68;
            abyte1[4] = 69;
            abyte1[5] = 70;
            abyte1[6] = 71;
            abyte1[7] = 72;
            abyte1[8] = 73;
            abyte1[9] = 74;
            abyte1[10] = 75;
            abyte1[11] = 76;
            abyte1[12] = 77;
            abyte1[13] = 78;
            abyte1[14] = 79;
            abyte1[15] = 80;
            abyte1[16] = 81;
            abyte1[17] = 82;
            abyte1[18] = 83;
            abyte1[19] = 84;
            abyte1[20] = 85;
            abyte1[21] = 86;
            abyte1[22] = 87;
            abyte1[23] = 88;
            abyte1[24] = 89;
            abyte1[25] = 90;
            abyte1[26] = 97;
            abyte1[27] = 98;
            abyte1[28] = 99;
            abyte1[29] = 100;
            abyte1[30] = 101;
            abyte1[31] = 102;
            abyte1[32] = 103;
            abyte1[33] = 104;
            abyte1[34] = 105;
            abyte1[35] = 106;
            abyte1[36] = 107;
            abyte1[37] = 108;
            abyte1[38] = 109;
            abyte1[39] = 110;
            abyte1[40] = 111;
            abyte1[41] = 112;
            abyte1[42] = 113;
            abyte1[43] = 114;
            abyte1[44] = 115;
            abyte1[45] = 116;
            abyte1[46] = 117;
            abyte1[47] = 118;
            abyte1[48] = 119;
            abyte1[49] = 120;
            abyte1[50] = 121;
            abyte1[51] = 122;
            abyte1[52] = 48;
            abyte1[53] = 49;
            abyte1[54] = 50;
            abyte1[55] = 51;
            abyte1[56] = 52;
            abyte1[57] = 53;
            abyte1[58] = 54;
            abyte1[59] = 55;
            abyte1[60] = 56;
            abyte1[61] = 57;
            abyte1[62] = 45;
            abyte1[63] = 95;
            ENCODE_WEBSAFE = abyte1;
        }

        public Encoder(int i, byte abyte0[]) {
            boolean flag = true;
            super();
            super.output = abyte0;
            boolean flag1;
            boolean flag2;
            byte abyte1[];
            int j;
            if((i & 1) == 0)
                flag1 = flag;
            else
                flag1 = false;
            do_padding = flag1;
            if((i & 2) == 0)
                flag2 = flag;
            else
                flag2 = false;
            do_newline = flag2;
            if((i & 4) == 0)
                flag = false;
            do_cr = flag;
            if((i & 8) == 0)
                abyte1 = ENCODE;
            else
                abyte1 = ENCODE_WEBSAFE;
            alphabet = abyte1;
            tailLen = 0;
            if(do_newline)
                j = 19;
            else
                j = -1;
            count = j;
        }
    }

    static class Decoder extends Coder {

        public int maxOutputSize(int i) {
            return 10 + (i * 3) / 4;
        }

        public boolean process(byte abyte0[], int i, int j, boolean flag) {
            if(state != 6) goto _L2; else goto _L1
_L1:
            boolean flag1 = false;
_L8:
            return flag1;
_L2:
            int k;
            int l;
            int i1;
            int j1;
            int k1;
            byte abyte1[];
            int ai[];
            k = i;
            l = j + i;
            i1 = state;
            j1 = value;
            k1 = 0;
            abyte1 = super.output;
            ai = alphabet;
_L16:
            if(k >= l)
                break MISSING_BLOCK_LABEL_752;
            if(i1 != 0) goto _L4; else goto _L3
_L3:
            do {
                if(k + 4 > l)
                    break;
                j1 = ai[0xff & abyte0[k]] << 18 | ai[0xff & abyte0[k + 1]] << 12 | ai[0xff & abyte0[k + 2]] << 6 | ai[0xff & abyte0[k + 3]];
                if(j1 < 0)
                    break;
                abyte1[k1 + 2] = (byte)j1;
                abyte1[k1 + 1] = (byte)(j1 >> 8);
                abyte1[k1] = (byte)(j1 >> 16);
                k1 += 3;
                k += 4;
            } while(true);
            if(k < l) goto _L4; else goto _L5
_L5:
            int l1 = k1;
_L38:
            if(flag) goto _L7; else goto _L6
_L6:
            state = i1;
            value = j1;
            super.op = l1;
            flag1 = true;
              goto _L8
_L4:
            int l2;
            int i3;
            l2 = k + 1;
            i3 = ai[0xff & abyte0[k]];
            i1;
            JVM INSTR tableswitch 0 5: default 284
        //                       0 291
        //                       1 325
        //                       2 365
        //                       3 438
        //                       4 554
        //                       5 586;
               goto _L9 _L10 _L11 _L12 _L13 _L14 _L15
_L9:
            k = l2;
              goto _L16
_L10:
            if(i3 < 0) goto _L18; else goto _L17
_L17:
            j1 = i3;
            i1++;
              goto _L9
_L18:
            if(i3 == -1) goto _L9; else goto _L19
_L19:
            state = 6;
            flag1 = false;
              goto _L8
_L11:
            if(i3 < 0) goto _L21; else goto _L20
_L20:
            j1 = i3 | j1 << 6;
            i1++;
              goto _L9
_L21:
            if(i3 == -1) goto _L9; else goto _L22
_L22:
            state = 6;
            flag1 = false;
              goto _L8
_L12:
label0:
            {
                if(i3 < 0)
                    break label0;
                j1 = i3 | j1 << 6;
                i1++;
            }
              goto _L9
            if(i3 != -2) goto _L24; else goto _L23
_L23:
            int j3 = k1 + 1;
            abyte1[k1] = (byte)(j1 >> 4);
            i1 = 4;
            k1 = j3;
              goto _L9
_L24:
            if(i3 == -1) goto _L9; else goto _L25
_L25:
            state = 6;
            flag1 = false;
              goto _L8
_L13:
label1:
            {
                if(i3 < 0)
                    break label1;
                j1 = i3 | j1 << 6;
                abyte1[k1 + 2] = (byte)j1;
                abyte1[k1 + 1] = (byte)(j1 >> 8);
                abyte1[k1] = (byte)(j1 >> 16);
                k1 += 3;
                i1 = 0;
            }
              goto _L9
            if(i3 != -2) goto _L27; else goto _L26
_L26:
            abyte1[k1 + 1] = (byte)(j1 >> 2);
            abyte1[k1] = (byte)(j1 >> 10);
            k1 += 2;
            i1 = 5;
              goto _L9
_L27:
            if(i3 == -1) goto _L9; else goto _L28
_L28:
            state = 6;
            flag1 = false;
              goto _L8
_L14:
            if(i3 != -2)
                continue; /* Loop/switch isn't completed */
            i1++;
              goto _L9
            if(i3 == -1) goto _L9; else goto _L29
_L29:
            state = 6;
            flag1 = false;
              goto _L8
_L15:
            if(i3 == -1) goto _L9; else goto _L30
_L30:
            state = 6;
            flag1 = false;
              goto _L8
_L7:
            i1;
            JVM INSTR tableswitch 0 4: default 640
        //                       0 662
        //                       1 669
        //                       2 681
        //                       3 700
        //                       4 740;
               goto _L31 _L32 _L33 _L34 _L35 _L36
_L35:
            break MISSING_BLOCK_LABEL_700;
_L36:
            break MISSING_BLOCK_LABEL_740;
_L31:
            int k2 = l1;
_L37:
            state = i1;
            super.op = k2;
            flag1 = true;
              goto _L8
_L32:
            k2 = l1;
              goto _L37
_L33:
            state = 6;
            flag1 = false;
              goto _L8
_L34:
            k2 = l1 + 1;
            abyte1[l1] = (byte)(j1 >> 4);
              goto _L37
            int i2 = l1 + 1;
            abyte1[l1] = (byte)(j1 >> 10);
            int j2 = i2 + 1;
            abyte1[i2] = (byte)(j1 >> 2);
            k2 = j2;
              goto _L37
            state = 6;
            flag1 = false;
              goto _L8
            l1 = k1;
              goto _L38
        }

        private static final int DECODE[];
        private static final int DECODE_WEBSAFE[];
        private static final int EQUALS = -2;
        private static final int SKIP = -1;
        private final int alphabet[];
        private int state;
        private int value;

        static  {
            int ai[] = new int[256];
            ai[0] = -1;
            ai[1] = -1;
            ai[2] = -1;
            ai[3] = -1;
            ai[4] = -1;
            ai[5] = -1;
            ai[6] = -1;
            ai[7] = -1;
            ai[8] = -1;
            ai[9] = -1;
            ai[10] = -1;
            ai[11] = -1;
            ai[12] = -1;
            ai[13] = -1;
            ai[14] = -1;
            ai[15] = -1;
            ai[16] = -1;
            ai[17] = -1;
            ai[18] = -1;
            ai[19] = -1;
            ai[20] = -1;
            ai[21] = -1;
            ai[22] = -1;
            ai[23] = -1;
            ai[24] = -1;
            ai[25] = -1;
            ai[26] = -1;
            ai[27] = -1;
            ai[28] = -1;
            ai[29] = -1;
            ai[30] = -1;
            ai[31] = -1;
            ai[32] = -1;
            ai[33] = -1;
            ai[34] = -1;
            ai[35] = -1;
            ai[36] = -1;
            ai[37] = -1;
            ai[38] = -1;
            ai[39] = -1;
            ai[40] = -1;
            ai[41] = -1;
            ai[42] = -1;
            ai[43] = 62;
            ai[44] = -1;
            ai[45] = -1;
            ai[46] = -1;
            ai[47] = 63;
            ai[48] = 52;
            ai[49] = 53;
            ai[50] = 54;
            ai[51] = 55;
            ai[52] = 56;
            ai[53] = 57;
            ai[54] = 58;
            ai[55] = 59;
            ai[56] = 60;
            ai[57] = 61;
            ai[58] = -1;
            ai[59] = -1;
            ai[60] = -1;
            ai[61] = -2;
            ai[62] = -1;
            ai[63] = -1;
            ai[64] = -1;
            ai[65] = 0;
            ai[66] = 1;
            ai[67] = 2;
            ai[68] = 3;
            ai[69] = 4;
            ai[70] = 5;
            ai[71] = 6;
            ai[72] = 7;
            ai[73] = 8;
            ai[74] = 9;
            ai[75] = 10;
            ai[76] = 11;
            ai[77] = 12;
            ai[78] = 13;
            ai[79] = 14;
            ai[80] = 15;
            ai[81] = 16;
            ai[82] = 17;
            ai[83] = 18;
            ai[84] = 19;
            ai[85] = 20;
            ai[86] = 21;
            ai[87] = 22;
            ai[88] = 23;
            ai[89] = 24;
            ai[90] = 25;
            ai[91] = -1;
            ai[92] = -1;
            ai[93] = -1;
            ai[94] = -1;
            ai[95] = -1;
            ai[96] = -1;
            ai[97] = 26;
            ai[98] = 27;
            ai[99] = 28;
            ai[100] = 29;
            ai[101] = 30;
            ai[102] = 31;
            ai[103] = 32;
            ai[104] = 33;
            ai[105] = 34;
            ai[106] = 35;
            ai[107] = 36;
            ai[108] = 37;
            ai[109] = 38;
            ai[110] = 39;
            ai[111] = 40;
            ai[112] = 41;
            ai[113] = 42;
            ai[114] = 43;
            ai[115] = 44;
            ai[116] = 45;
            ai[117] = 46;
            ai[118] = 47;
            ai[119] = 48;
            ai[120] = 49;
            ai[121] = 50;
            ai[122] = 51;
            ai[123] = -1;
            ai[124] = -1;
            ai[125] = -1;
            ai[126] = -1;
            ai[127] = -1;
            ai[128] = -1;
            ai[129] = -1;
            ai[130] = -1;
            ai[131] = -1;
            ai[132] = -1;
            ai[133] = -1;
            ai[134] = -1;
            ai[135] = -1;
            ai[136] = -1;
            ai[137] = -1;
            ai[138] = -1;
            ai[139] = -1;
            ai[140] = -1;
            ai[141] = -1;
            ai[142] = -1;
            ai[143] = -1;
            ai[144] = -1;
            ai[145] = -1;
            ai[146] = -1;
            ai[147] = -1;
            ai[148] = -1;
            ai[149] = -1;
            ai[150] = -1;
            ai[151] = -1;
            ai[152] = -1;
            ai[153] = -1;
            ai[154] = -1;
            ai[155] = -1;
            ai[156] = -1;
            ai[157] = -1;
            ai[158] = -1;
            ai[159] = -1;
            ai[160] = -1;
            ai[161] = -1;
            ai[162] = -1;
            ai[163] = -1;
            ai[164] = -1;
            ai[165] = -1;
            ai[166] = -1;
            ai[167] = -1;
            ai[168] = -1;
            ai[169] = -1;
            ai[170] = -1;
            ai[171] = -1;
            ai[172] = -1;
            ai[173] = -1;
            ai[174] = -1;
            ai[175] = -1;
            ai[176] = -1;
            ai[177] = -1;
            ai[178] = -1;
            ai[179] = -1;
            ai[180] = -1;
            ai[181] = -1;
            ai[182] = -1;
            ai[183] = -1;
            ai[184] = -1;
            ai[185] = -1;
            ai[186] = -1;
            ai[187] = -1;
            ai[188] = -1;
            ai[189] = -1;
            ai[190] = -1;
            ai[191] = -1;
            ai[192] = -1;
            ai[193] = -1;
            ai[194] = -1;
            ai[195] = -1;
            ai[196] = -1;
            ai[197] = -1;
            ai[198] = -1;
            ai[199] = -1;
            ai[200] = -1;
            ai[201] = -1;
            ai[202] = -1;
            ai[203] = -1;
            ai[204] = -1;
            ai[205] = -1;
            ai[206] = -1;
            ai[207] = -1;
            ai[208] = -1;
            ai[209] = -1;
            ai[210] = -1;
            ai[211] = -1;
            ai[212] = -1;
            ai[213] = -1;
            ai[214] = -1;
            ai[215] = -1;
            ai[216] = -1;
            ai[217] = -1;
            ai[218] = -1;
            ai[219] = -1;
            ai[220] = -1;
            ai[221] = -1;
            ai[222] = -1;
            ai[223] = -1;
            ai[224] = -1;
            ai[225] = -1;
            ai[226] = -1;
            ai[227] = -1;
            ai[228] = -1;
            ai[229] = -1;
            ai[230] = -1;
            ai[231] = -1;
            ai[232] = -1;
            ai[233] = -1;
            ai[234] = -1;
            ai[235] = -1;
            ai[236] = -1;
            ai[237] = -1;
            ai[238] = -1;
            ai[239] = -1;
            ai[240] = -1;
            ai[241] = -1;
            ai[242] = -1;
            ai[243] = -1;
            ai[244] = -1;
            ai[245] = -1;
            ai[246] = -1;
            ai[247] = -1;
            ai[248] = -1;
            ai[249] = -1;
            ai[250] = -1;
            ai[251] = -1;
            ai[252] = -1;
            ai[253] = -1;
            ai[254] = -1;
            ai[255] = -1;
            DECODE = ai;
            int ai1[] = new int[256];
            ai1[0] = -1;
            ai1[1] = -1;
            ai1[2] = -1;
            ai1[3] = -1;
            ai1[4] = -1;
            ai1[5] = -1;
            ai1[6] = -1;
            ai1[7] = -1;
            ai1[8] = -1;
            ai1[9] = -1;
            ai1[10] = -1;
            ai1[11] = -1;
            ai1[12] = -1;
            ai1[13] = -1;
            ai1[14] = -1;
            ai1[15] = -1;
            ai1[16] = -1;
            ai1[17] = -1;
            ai1[18] = -1;
            ai1[19] = -1;
            ai1[20] = -1;
            ai1[21] = -1;
            ai1[22] = -1;
            ai1[23] = -1;
            ai1[24] = -1;
            ai1[25] = -1;
            ai1[26] = -1;
            ai1[27] = -1;
            ai1[28] = -1;
            ai1[29] = -1;
            ai1[30] = -1;
            ai1[31] = -1;
            ai1[32] = -1;
            ai1[33] = -1;
            ai1[34] = -1;
            ai1[35] = -1;
            ai1[36] = -1;
            ai1[37] = -1;
            ai1[38] = -1;
            ai1[39] = -1;
            ai1[40] = -1;
            ai1[41] = -1;
            ai1[42] = -1;
            ai1[43] = -1;
            ai1[44] = -1;
            ai1[45] = 62;
            ai1[46] = -1;
            ai1[47] = -1;
            ai1[48] = 52;
            ai1[49] = 53;
            ai1[50] = 54;
            ai1[51] = 55;
            ai1[52] = 56;
            ai1[53] = 57;
            ai1[54] = 58;
            ai1[55] = 59;
            ai1[56] = 60;
            ai1[57] = 61;
            ai1[58] = -1;
            ai1[59] = -1;
            ai1[60] = -1;
            ai1[61] = -2;
            ai1[62] = -1;
            ai1[63] = -1;
            ai1[64] = -1;
            ai1[65] = 0;
            ai1[66] = 1;
            ai1[67] = 2;
            ai1[68] = 3;
            ai1[69] = 4;
            ai1[70] = 5;
            ai1[71] = 6;
            ai1[72] = 7;
            ai1[73] = 8;
            ai1[74] = 9;
            ai1[75] = 10;
            ai1[76] = 11;
            ai1[77] = 12;
            ai1[78] = 13;
            ai1[79] = 14;
            ai1[80] = 15;
            ai1[81] = 16;
            ai1[82] = 17;
            ai1[83] = 18;
            ai1[84] = 19;
            ai1[85] = 20;
            ai1[86] = 21;
            ai1[87] = 22;
            ai1[88] = 23;
            ai1[89] = 24;
            ai1[90] = 25;
            ai1[91] = -1;
            ai1[92] = -1;
            ai1[93] = -1;
            ai1[94] = -1;
            ai1[95] = 63;
            ai1[96] = -1;
            ai1[97] = 26;
            ai1[98] = 27;
            ai1[99] = 28;
            ai1[100] = 29;
            ai1[101] = 30;
            ai1[102] = 31;
            ai1[103] = 32;
            ai1[104] = 33;
            ai1[105] = 34;
            ai1[106] = 35;
            ai1[107] = 36;
            ai1[108] = 37;
            ai1[109] = 38;
            ai1[110] = 39;
            ai1[111] = 40;
            ai1[112] = 41;
            ai1[113] = 42;
            ai1[114] = 43;
            ai1[115] = 44;
            ai1[116] = 45;
            ai1[117] = 46;
            ai1[118] = 47;
            ai1[119] = 48;
            ai1[120] = 49;
            ai1[121] = 50;
            ai1[122] = 51;
            ai1[123] = -1;
            ai1[124] = -1;
            ai1[125] = -1;
            ai1[126] = -1;
            ai1[127] = -1;
            ai1[128] = -1;
            ai1[129] = -1;
            ai1[130] = -1;
            ai1[131] = -1;
            ai1[132] = -1;
            ai1[133] = -1;
            ai1[134] = -1;
            ai1[135] = -1;
            ai1[136] = -1;
            ai1[137] = -1;
            ai1[138] = -1;
            ai1[139] = -1;
            ai1[140] = -1;
            ai1[141] = -1;
            ai1[142] = -1;
            ai1[143] = -1;
            ai1[144] = -1;
            ai1[145] = -1;
            ai1[146] = -1;
            ai1[147] = -1;
            ai1[148] = -1;
            ai1[149] = -1;
            ai1[150] = -1;
            ai1[151] = -1;
            ai1[152] = -1;
            ai1[153] = -1;
            ai1[154] = -1;
            ai1[155] = -1;
            ai1[156] = -1;
            ai1[157] = -1;
            ai1[158] = -1;
            ai1[159] = -1;
            ai1[160] = -1;
            ai1[161] = -1;
            ai1[162] = -1;
            ai1[163] = -1;
            ai1[164] = -1;
            ai1[165] = -1;
            ai1[166] = -1;
            ai1[167] = -1;
            ai1[168] = -1;
            ai1[169] = -1;
            ai1[170] = -1;
            ai1[171] = -1;
            ai1[172] = -1;
            ai1[173] = -1;
            ai1[174] = -1;
            ai1[175] = -1;
            ai1[176] = -1;
            ai1[177] = -1;
            ai1[178] = -1;
            ai1[179] = -1;
            ai1[180] = -1;
            ai1[181] = -1;
            ai1[182] = -1;
            ai1[183] = -1;
            ai1[184] = -1;
            ai1[185] = -1;
            ai1[186] = -1;
            ai1[187] = -1;
            ai1[188] = -1;
            ai1[189] = -1;
            ai1[190] = -1;
            ai1[191] = -1;
            ai1[192] = -1;
            ai1[193] = -1;
            ai1[194] = -1;
            ai1[195] = -1;
            ai1[196] = -1;
            ai1[197] = -1;
            ai1[198] = -1;
            ai1[199] = -1;
            ai1[200] = -1;
            ai1[201] = -1;
            ai1[202] = -1;
            ai1[203] = -1;
            ai1[204] = -1;
            ai1[205] = -1;
            ai1[206] = -1;
            ai1[207] = -1;
            ai1[208] = -1;
            ai1[209] = -1;
            ai1[210] = -1;
            ai1[211] = -1;
            ai1[212] = -1;
            ai1[213] = -1;
            ai1[214] = -1;
            ai1[215] = -1;
            ai1[216] = -1;
            ai1[217] = -1;
            ai1[218] = -1;
            ai1[219] = -1;
            ai1[220] = -1;
            ai1[221] = -1;
            ai1[222] = -1;
            ai1[223] = -1;
            ai1[224] = -1;
            ai1[225] = -1;
            ai1[226] = -1;
            ai1[227] = -1;
            ai1[228] = -1;
            ai1[229] = -1;
            ai1[230] = -1;
            ai1[231] = -1;
            ai1[232] = -1;
            ai1[233] = -1;
            ai1[234] = -1;
            ai1[235] = -1;
            ai1[236] = -1;
            ai1[237] = -1;
            ai1[238] = -1;
            ai1[239] = -1;
            ai1[240] = -1;
            ai1[241] = -1;
            ai1[242] = -1;
            ai1[243] = -1;
            ai1[244] = -1;
            ai1[245] = -1;
            ai1[246] = -1;
            ai1[247] = -1;
            ai1[248] = -1;
            ai1[249] = -1;
            ai1[250] = -1;
            ai1[251] = -1;
            ai1[252] = -1;
            ai1[253] = -1;
            ai1[254] = -1;
            ai1[255] = -1;
            DECODE_WEBSAFE = ai1;
        }

        public Decoder(int i, byte abyte0[]) {
            super.output = abyte0;
            int ai[];
            if((i & 8) == 0)
                ai = DECODE;
            else
                ai = DECODE_WEBSAFE;
            alphabet = ai;
            state = 0;
            value = 0;
        }
    }

    static abstract class Coder {

        public abstract int maxOutputSize(int i);

        public abstract boolean process(byte abyte0[], int i, int j, boolean flag);

        public int op;
        public byte output[];

        Coder() {
        }
    }


    private Base64() {
    }

    public static byte[] decode(String s, int i) {
        return decode(s.getBytes(), i);
    }

    public static byte[] decode(byte abyte0[], int i) {
        return decode(abyte0, 0, abyte0.length, i);
    }

    public static byte[] decode(byte abyte0[], int i, int j, int k) {
        Decoder decoder = new Decoder(k, new byte[(j * 3) / 4]);
        if(!decoder.process(abyte0, i, j, true))
            throw new IllegalArgumentException("bad base-64");
        byte abyte1[];
        if(((Coder) (decoder)).op == ((Coder) (decoder)).output.length) {
            abyte1 = ((Coder) (decoder)).output;
        } else {
            abyte1 = new byte[((Coder) (decoder)).op];
            System.arraycopy(((Coder) (decoder)).output, 0, abyte1, 0, ((Coder) (decoder)).op);
        }
        return abyte1;
    }

    public static byte[] encode(byte abyte0[], int i) {
        return encode(abyte0, 0, abyte0.length, i);
    }

    public static byte[] encode(byte abyte0[], int i, int j, int k) {
        Encoder encoder;
        int l;
        encoder = new Encoder(k, null);
        l = 4 * (j / 3);
        if(!encoder.do_padding) goto _L2; else goto _L1
_L1:
        if(j % 3 > 0)
            l += 4;
_L4:
        if(encoder.do_newline && j > 0) {
            int i1 = 1 + (j - 1) / 57;
            byte byte0;
            if(encoder.do_cr)
                byte0 = 2;
            else
                byte0 = 1;
            l += byte0 * i1;
        }
        encoder.output = new byte[l];
        encoder.process(abyte0, i, j, true);
        if(!$assertionsDisabled && ((Coder) (encoder)).op != l)
            throw new AssertionError();
        else
            return ((Coder) (encoder)).output;
_L2:
        switch(j % 3) {
        case 1: // '\001'
            l += 2;
            break;

        case 2: // '\002'
            l += 3;
            break;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static String encodeToString(byte abyte0[], int i) {
        String s;
        try {
            s = new String(encode(abyte0, i), "US-ASCII");
        }
        catch(UnsupportedEncodingException unsupportedencodingexception) {
            throw new AssertionError(unsupportedencodingexception);
        }
        return s;
    }

    public static String encodeToString(byte abyte0[], int i, int j, int k) {
        String s;
        try {
            s = new String(encode(abyte0, i, j, k), "US-ASCII");
        }
        catch(UnsupportedEncodingException unsupportedencodingexception) {
            throw new AssertionError(unsupportedencodingexception);
        }
        return s;
    }

    static final boolean $assertionsDisabled = false;
    public static final int CRLF = 4;
    public static final int DEFAULT = 0;
    public static final int NO_CLOSE = 16;
    public static final int NO_PADDING = 1;
    public static final int NO_WRAP = 2;
    public static final int URL_SAFE = 8;

    static  {
        boolean flag;
        if(!android/util/Base64.desiredAssertionStatus())
            flag = true;
        else
            flag = false;
        $assertionsDisabled = flag;
    }
}
