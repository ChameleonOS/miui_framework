// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text;


// Referenced classes of package android.text:
//            Layout

class AndroidBidi {

    AndroidBidi() {
    }

    public static int bidi(int i, char ac[], byte abyte0[], int j, boolean flag) {
        if(ac == null || abyte0 == null)
            throw new NullPointerException();
        if(j < 0 || ac.length < j || abyte0.length < j)
            throw new IndexOutOfBoundsException();
        i;
        JVM INSTR tableswitch -2 2: default 76
    //                   -2 119
    //                   -1 106
    //                   0 76
    //                   1 100
    //                   2 112;
           goto _L1 _L2 _L3 _L1 _L4 _L5
_L2:
        break MISSING_BLOCK_LABEL_119;
_L1:
        int k = 0;
_L6:
        int l;
        if((1 & runBidi(k, ac, abyte0, j, flag)) == 0)
            l = 1;
        else
            l = -1;
        return l;
_L4:
        k = 0;
          goto _L6
_L3:
        k = 1;
          goto _L6
_L5:
        k = -2;
          goto _L6
        k = -1;
          goto _L6
    }

    public static Layout.Directions directions(int i, byte abyte0[], int j, char ac[], int k, int l) {
        int i1;
        byte byte0;
        int j1;
        int k1;
        int j2;
        int l1;
        if(i == 1)
            i1 = 0;
        else
            i1 = 1;
        byte0 = abyte0[j];
        j1 = byte0;
        k1 = 1;
        l1 = j + 1;
        for(int i2 = j + l; l1 < i2; l1++) {
            byte byte2 = abyte0[l1];
            if(byte2 != byte0) {
                byte0 = byte2;
                k1++;
            }
        }

        j2 = l;
        if((byte0 & 1) == (i1 & 1)) goto _L2; else goto _L1
_L1:
        if(--j2 < 0) goto _L4; else goto _L3
_L3:
        char c = ac[k + j2];
        if(c != '\n') goto _L6; else goto _L5
_L5:
        j2--;
_L4:
        if(++j2 != l)
            k1++;
_L2:
        Layout.Directions directions1;
        if(k1 == 1 && j1 == i1) {
            if((j1 & 1) != 0)
                directions1 = Layout.DIRS_ALL_RIGHT_TO_LEFT;
            else
                directions1 = Layout.DIRS_ALL_LEFT_TO_RIGHT;
        } else {
            int ai[] = new int[k1 * 2];
            int k2 = j1;
            int l2 = j1 << 26;
            int i3 = j;
            int j3 = j1;
            int k3 = j;
            int l3 = j + j2;
            int i4 = 1;
            while(k3 < l3)  {
                byte byte1 = abyte0[k3];
                boolean flag;
                int j4;
                int k4;
                int l4;
                int i5;
                int j5;
                int k5;
                int l5;
                int i6;
                int j6;
                if(byte1 != j3) {
                    j3 = byte1;
                    int k6;
                    int l6;
                    if(byte1 > k2)
                        k2 = byte1;
                    else
                    if(byte1 < j1)
                        j1 = byte1;
                    k6 = i4 + 1;
                    ai[i4] = l2 | k3 - i3;
                    l6 = k6 + 1;
                    ai[k6] = k3 - j;
                    l2 = j3 << 26;
                    i3 = k3;
                    j6 = l6;
                } else {
                    j6 = i4;
                }
                k3++;
                i4 = j6;
            }
            ai[i4] = l2 | (j + j2) - i3;
            if(j2 < l) {
                i6 = i4 + 1;
                ai[i6] = j2;
                ai[i6 + 1] = l - j2 | i1 << 26;
            } else {
                i4;
            }
            if((j1 & 1) == i1) {
                j1++;
                if(k2 > j1)
                    flag = true;
                else
                    flag = false;
            } else
            if(k1 > 1)
                flag = true;
            else
                flag = false;
            if(flag)
                for(j4 = k2 - 1; j4 >= j1; j4--)
                    for(k4 = 0; k4 < ai.length; k4 += 2) {
                        if(abyte0[ai[k4]] < j4)
                            continue;
                        for(l4 = k4 + 2; l4 < ai.length && abyte0[ai[l4]] >= j4; l4 += 2);
                        i5 = k4;
                        for(j5 = l4 - 2; i5 < j5; j5 -= 2) {
                            k5 = ai[i5];
                            ai[i5] = ai[j5];
                            ai[j5] = k5;
                            l5 = ai[i5 + 1];
                            ai[i5 + 1] = ai[j5 + 1];
                            ai[j5 + 1] = l5;
                            i5 += 2;
                        }

                        k4 = l4 + 2;
                    }


            directions1 = new Layout.Directions(ai);
        }
        return directions1;
_L6:
        if(c == ' ' || c == '\t') goto _L1; else goto _L4
    }

    private static native int runBidi(int i, char ac[], byte abyte0[], int j, boolean flag);
}
