// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.icu.text;


public class ArabicShaping {
    private static class ArabicShapingException extends RuntimeException {

        ArabicShapingException(String s) {
            super(s);
        }
    }


    public ArabicShaping(int i) {
        boolean flag = true;
        super();
        options = i;
        if((i & 0xe0) > 128)
            throw new IllegalArgumentException("bad DIGITS options");
        boolean flag1;
        if((i & 4) == 0)
            flag1 = flag;
        else
            flag1 = false;
        isLogical = flag1;
        if((i & 0x4000000) != 0x4000000)
            flag = false;
        spacesRelativeToTextBeginEnd = flag;
        if((i & 0x8000000) == 0x8000000)
            tailChar = '\uFE73';
        else
            tailChar = '\u200B';
    }

    private int calculateSize(char ac[], int i, int j) {
        int k = j;
        0x18 & options;
        JVM INSTR lookupswitch 3: default 44
    //                   8: 47
    //                   16: 171
    //                   24: 47;
           goto _L1 _L2 _L3 _L2
_L1:
        return k;
_L2:
        if(!isLogical)
            break; /* Loop/switch isn't completed */
        int l1 = i;
        int i2 = -1 + (i + j);
        while(l1 < i2)  {
            if(ac[l1] == '\u0644' && isAlefChar(ac[l1 + 1]) || isTashkeelCharFE(ac[l1]))
                k--;
            l1++;
        }
        if(true) goto _L1; else goto _L4
_L4:
        int j1 = i + 1;
        int k1 = i + j;
        while(j1 < k1)  {
            if(ac[j1] == '\u0644' && isAlefChar(ac[j1 - 1]) || isTashkeelCharFE(ac[j1]))
                k--;
            j1++;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        int l = i;
        int i1 = i + j;
        while(l < i1)  {
            if(isLamAlefChar(ac[l]))
                k++;
            l++;
        }
        if(true) goto _L1; else goto _L5
_L5:
    }

    private static char changeLamAlef(char c) {
        c;
        JVM INSTR tableswitch 1570 1575: default 40
    //                   1570 44
    //                   1571 51
    //                   1572 40
    //                   1573 58
    //                   1574 40
    //                   1575 65;
           goto _L1 _L2 _L3 _L1 _L4 _L1 _L5
_L1:
        char c1 = '\0';
_L7:
        return c1;
_L2:
        c1 = '\u065C';
        continue; /* Loop/switch isn't completed */
_L3:
        c1 = '\u065D';
        continue; /* Loop/switch isn't completed */
_L4:
        c1 = '\u065E';
        continue; /* Loop/switch isn't completed */
_L5:
        c1 = '\u065F';
        if(true) goto _L7; else goto _L6
_L6:
    }

    public static int countSpaceSub(char ac[], int i, char c) {
        int j = 0;
        int k = 0;
        for(; j < i; j++)
            if(ac[j] == c)
                k++;

        return k;
    }

    private static int countSpacesLeft(char ac[], int i, int j) {
        int k = i;
        int l = i + j;
        do {
label0:
            {
                if(k < l) {
                    if(ac[k] == ' ')
                        break label0;
                    j = k - i;
                }
                return j;
            }
            k++;
        } while(true);
    }

    private static int countSpacesRight(char ac[], int i, int j) {
        int k = i + j;
        do {
            if(--k < i)
                break;
            if(ac[k] == ' ')
                continue;
            j = (-1 + (i + j)) - k;
            break;
        } while(true);
        return j;
    }

    private int deShapeUnicode(char ac[], int i, int j, int k) throws ArabicShapingException {
        int l = deshapeNormalize(ac, i, j);
        int i1;
        if(l != 0)
            i1 = expandCompositChar(ac, i, j, l, 1);
        else
            i1 = j;
        return i1;
    }

    private int deshapeNormalize(char ac[], int i, int j) {
        int k = 0;
        boolean flag;
        boolean flag1;
        int l;
        int i1;
        if((0x3800000 & options) == 0x1000000)
            flag = true;
        else
            flag = false;
        if((0x700000 & options) == 0x200000)
            flag1 = true;
        else
            flag1 = false;
        l = i;
        i1 = l + j;
        while(l < i1)  {
            char c = ac[l];
            if(flag && (c == '\u0621' || c == '\uFE80') && l < j - 1 && isAlefMaksouraChar(ac[l + 1])) {
                ac[l] = ' ';
                ac[l + 1] = '\u0626';
            } else
            if(flag1 && isTailChar(c) && l < j - 1 && isSeenTailFamilyChar(ac[l + 1]) == 1)
                ac[l] = ' ';
            else
            if(c >= '\uFE70' && c <= '\uFEFC') {
                if(isLamAlefChar(c))
                    k++;
                ac[l] = (char)convertFEto06[c - 65136];
            }
            l++;
        }
        return k;
    }

    private int expandCompositChar(char ac[], int i, int j, int k, int l) throws ArabicShapingException {
        int i1;
        int j1;
        int k1;
        i1 = 0x10003 & options;
        j1 = 0x700000 & options;
        k1 = 0x3800000 & options;
        if(isLogical || spacesRelativeToTextBeginEnd) goto _L2; else goto _L1
_L1:
        i1;
        JVM INSTR tableswitch 2 3: default 64
    //                   2 149
    //                   3 143;
           goto _L3 _L4 _L5
_L3:
        break; /* Loop/switch isn't completed */
_L4:
        break MISSING_BLOCK_LABEL_149;
_L2:
        if(l == 1) {
            if(i1 == 0x10000) {
                if(isLogical) {
                    boolean flag1 = expandCompositCharAtEnd(ac, i, j, k);
                    if(flag1)
                        flag1 = expandCompositCharAtBegin(ac, i, j, k);
                    if(flag1)
                        flag1 = expandCompositCharAtNear(ac, i, j, 0, 0, 1);
                    if(flag1)
                        throw new ArabicShapingException("No spacefor lamalef");
                } else {
                    boolean flag = expandCompositCharAtBegin(ac, i, j, k);
                    if(flag)
                        flag = expandCompositCharAtEnd(ac, i, j, k);
                    if(flag)
                        flag = expandCompositCharAtNear(ac, i, j, 0, 0, 1);
                    if(flag)
                        throw new ArabicShapingException("No spacefor lamalef");
                }
            } else
            if(i1 == 2) {
                if(expandCompositCharAtEnd(ac, i, j, k))
                    throw new ArabicShapingException("No spacefor lamalef");
            } else
            if(i1 == 3) {
                if(expandCompositCharAtBegin(ac, i, j, k))
                    throw new ArabicShapingException("No spacefor lamalef");
            } else
            if(i1 == 1) {
                if(expandCompositCharAtNear(ac, i, j, 0, 0, 1))
                    throw new ArabicShapingException("No spacefor lamalef");
            } else
            if(i1 == 0) {
                int l1 = i + j;
                int i2 = l1 + k;
                while(--l1 >= i)  {
                    char c = ac[l1];
                    if(isNormalizedLamAlefChar(c)) {
                        int j2 = i2 - 1;
                        ac[j2] = '\u0644';
                        i2 = j2 - 1;
                        ac[i2] = convertNormalizedLamAlef[c + -1628];
                    } else {
                        i2--;
                        ac[i2] = c;
                    }
                }
                j += k;
            }
        } else {
            if(j1 == 0x200000 && expandCompositCharAtNear(ac, i, j, 0, 1, 0))
                throw new ArabicShapingException("No space for Seen tail expansion");
            if(k1 == 0x1000000 && expandCompositCharAtNear(ac, i, j, 1, 0, 0))
                throw new ArabicShapingException("No space for YehHamza expansion");
        }
        break MISSING_BLOCK_LABEL_392;
_L5:
        i1 = 2;
          goto _L2
        i1 = 3;
          goto _L2
        return j;
    }

    private boolean expandCompositCharAtBegin(char ac[], int i, int j, int k) {
        boolean flag;
        if(k > countSpacesRight(ac, i, j)) {
            flag = true;
        } else {
            int l = (i + j) - k;
            int i1 = i + j;
            while(--l >= i)  {
                char c = ac[l];
                if(isNormalizedLamAlefChar(c)) {
                    int j1 = i1 - 1;
                    ac[j1] = '\u0644';
                    i1 = j1 - 1;
                    ac[i1] = convertNormalizedLamAlef[c + -1628];
                } else {
                    i1--;
                    ac[i1] = c;
                }
            }
            flag = false;
        }
        return flag;
    }

    private boolean expandCompositCharAtEnd(char ac[], int i, int j, int k) {
        boolean flag;
        if(k > countSpacesLeft(ac, i, j)) {
            flag = true;
        } else {
            int l = i + k;
            int i1 = i + j;
            int j1 = i;
            while(l < i1)  {
                char c = ac[l];
                int k1;
                if(isNormalizedLamAlefChar(c)) {
                    int l1 = j1 + 1;
                    ac[j1] = convertNormalizedLamAlef[c + -1628];
                    int i2 = l1 + 1;
                    ac[l1] = '\u0644';
                    k1 = i2;
                } else {
                    k1 = j1 + 1;
                    ac[j1] = c;
                }
                l++;
                j1 = k1;
            }
            flag = false;
        }
        return flag;
    }

    private boolean expandCompositCharAtNear(char ac[], int i, int j, int k, int l, int i1) {
        if(!isNormalizedLamAlefChar(ac[i])) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        int j1 = i + j;
        do {
            if(--j1 < i)
                break;
            char c = ac[j1];
            if(i1 == 1 && isNormalizedLamAlefChar(c)) {
                if(j1 > i && ac[j1 - 1] == ' ') {
                    ac[j1] = '\u0644';
                    j1--;
                    ac[j1] = convertNormalizedLamAlef[c + -1628];
                } else {
                    flag = true;
                    continue; /* Loop/switch isn't completed */
                }
            } else
            if(l == 1 && isSeenTailFamilyChar(c) == 1) {
                if(j1 > i && ac[j1 - 1] == ' ') {
                    ac[j1 - 1] = tailChar;
                } else {
                    flag = true;
                    continue; /* Loop/switch isn't completed */
                }
            } else
            if(k == 1 && isYehHamzaChar(c))
                if(j1 > i && ac[j1 - 1] == ' ') {
                    ac[j1] = yehHamzaToYeh[c - 65161];
                    ac[j1 - 1] = '\uFE80';
                } else {
                    flag = true;
                    continue; /* Loop/switch isn't completed */
                }
        } while(true);
        flag = false;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static int flipArray(char ac[], int i, int j, int k) {
        if(k <= i) goto _L2; else goto _L1
_L1:
        int i1 = k;
        int l;
        int j1;
        int k1;
        for(j1 = i; i1 < j; j1 = k1) {
            k1 = j1 + 1;
            int l1 = i1 + 1;
            ac[j1] = ac[i1];
            i1 = l1;
        }

        l = j1;
          goto _L3
_L2:
        l = j;
_L5:
        return l;
_L3:
        if(true) goto _L5; else goto _L4
_L4:
    }

    private static int getLink(char c) {
        int i;
        if(c >= '\u0622' && c <= '\u06D3')
            i = araLink[c + -1570];
        else
        if(c == '\u200D')
            i = 3;
        else
        if(c >= '\u206D' && c <= '\u206F')
            i = 4;
        else
        if(c >= '\uFE70' && c <= '\uFEFC')
            i = presLink[c - 65136];
        else
            i = 0;
        return i;
    }

    private int handleGeneratedSpaces(char ac[], int i, int j) {
        int k;
        int l;
        boolean flag;
        boolean flag1;
        k = 0x10003 & options;
        l = 0xe0000 & options;
        flag = false;
        flag1 = false;
        boolean flag2;
        boolean flag3;
        int l2;
        int i3;
        if(!isLogical)
            flag2 = true;
        else
            flag2 = false;
        if(!spacesRelativeToTextBeginEnd)
            flag3 = true;
        else
            flag3 = false;
        if(!(flag2 & flag3)) goto _L2; else goto _L1
_L1:
        k;
        JVM INSTR tableswitch 2 3: default 76
    //                   2 165
    //                   3 159;
           goto _L3 _L4 _L5
_L3:
        l;
        JVM INSTR lookupswitch 2: default 104
    //                   262144: 171
    //                   393216: 178;
           goto _L6 _L7 _L8
_L6:
        break; /* Loop/switch isn't completed */
_L5:
        k = 2;
        continue; /* Loop/switch isn't completed */
_L4:
        k = 3;
        continue; /* Loop/switch isn't completed */
_L7:
        l = 0x60000;
          goto _L2
_L8:
        l = 0x40000;
_L2:
        if(k == 1) {
            l2 = i;
            for(i3 = l2 + j; l2 < i3; l2++)
                if(ac[l2] == '\uFFFF')
                    ac[l2] = '\uFEFF';

        } else {
            int i1 = i + j;
            int j1 = countSpaceSub(ac, j, '\uFFFF');
            int k1 = countSpaceSub(ac, j, '\uFFFE');
            if(k == 2)
                flag = true;
            if(l == 0x60000)
                flag1 = true;
            if(flag && k == 2) {
                shiftArray(ac, i, i1, '\uFFFF');
                while(j1 > i)  {
                    j1--;
                    ac[j1] = ' ';
                }
            }
            if(flag1 && l == 0x60000) {
                shiftArray(ac, i, i1, '\uFFFE');
                while(k1 > i)  {
                    k1--;
                    ac[k1] = ' ';
                }
            }
            boolean flag4 = false;
            boolean flag5 = false;
            if(k == 0)
                flag4 = true;
            if(l == 0x80000)
                flag5 = true;
            if(flag4 && k == 0) {
                shiftArray(ac, i, i1, '\uFFFF');
                j1 = flipArray(ac, i, i1, j1);
                j = j1 - i;
            }
            if(flag5 && l == 0x80000) {
                shiftArray(ac, i, i1, '\uFFFE');
                k1 = flipArray(ac, i, i1, k1);
                j = k1 - i;
            }
            boolean flag6 = false;
            boolean flag7 = false;
            if(k == 3 || k == 0x10000)
                flag6 = true;
            if(l == 0x40000)
                flag7 = true;
            if(flag6 && (k == 3 || k == 0x10000)) {
                shiftArray(ac, i, i1, '\uFFFF');
                int j2;
                int k2;
                for(j2 = flipArray(ac, i, i1, j1); j2 < i1; j2 = k2) {
                    k2 = j2 + 1;
                    ac[j2] = ' ';
                }

                j2;
            }
            if(flag7 && l == 0x40000) {
                shiftArray(ac, i, i1, '\uFFFE');
                int i2;
                for(int l1 = flipArray(ac, i, i1, k1); l1 < i1; l1 = i2) {
                    i2 = l1 + 1;
                    ac[l1] = ' ';
                }

            }
        }
        return j;
        if(true) goto _L3; else goto _L9
_L9:
    }

    private static int handleTashkeelWithTatweel(char ac[], int i) {
        int j = 0;
        while(j < i)  {
            if(isTashkeelOnTatweelChar(ac[j]) == 1)
                ac[j] = '\u0640';
            else
            if(isTashkeelOnTatweelChar(ac[j]) == 2)
                ac[j] = '\uFE7D';
            else
            if(isIsolatedTashkeelChar(ac[j]) == 1 && ac[j] != '\uFE7C')
                ac[j] = ' ';
            j++;
        }
        return i;
    }

    private int internalShape(char ac[], int i, int j, char ac1[], int k, int l) throws ArabicShapingException {
        if(j == 0) {
            j = 0;
        } else {
label0:
            {
                if(l != 0)
                    break label0;
                if((0x18 & options) != 0 && (0x10003 & options) == 0)
                    j = calculateSize(ac, i, j);
            }
        }
_L15:
        return j;
        char ac2[];
        int i1;
        ac2 = new char[j * 2];
        System.arraycopy(ac, i, ac2, 0, j);
        if(isLogical)
            invertBuffer(ac2, 0, j);
        i1 = j;
        0x18 & options;
        JVM INSTR lookupswitch 3: default 120
    //                   8: 154
    //                   16: 228
    //                   24: 138;
           goto _L1 _L2 _L3 _L4
_L1:
        if(i1 > l)
            throw new ArabicShapingException("not enough room for result data");
        break; /* Loop/switch isn't completed */
_L4:
        i1 = shapeUnicode(ac2, 0, j, l, 1);
        continue; /* Loop/switch isn't completed */
_L2:
        if((0xe0000 & options) > 0 && (0xe0000 & options) != 0xc0000) {
            i1 = shapeUnicode(ac2, 0, j, l, 2);
        } else {
            i1 = shapeUnicode(ac2, 0, j, l, 0);
            if((0xe0000 & options) == 0xc0000)
                i1 = handleTashkeelWithTatweel(ac2, j);
        }
        continue; /* Loop/switch isn't completed */
_L3:
        i1 = deShapeUnicode(ac2, 0, j, l);
        if(true) goto _L1; else goto _L5
_L5:
        if((0xe0 & options) == 0) goto _L7; else goto _L6
_L6:
        char c = '0';
        0x100 & options;
        JVM INSTR lookupswitch 2: default 292
    //                   0: 377
    //                   256: 385;
           goto _L8 _L9 _L10
_L8:
        0xe0 & options;
        JVM INSTR lookupswitch 4: default 344
    //                   32: 393
    //                   64: 450
    //                   96: 514
    //                   128: 529;
           goto _L7 _L11 _L12 _L13 _L14
_L7:
        if(isLogical)
            invertBuffer(ac2, 0, i1);
        System.arraycopy(ac2, 0, ac1, k, i1);
        j = i1;
          goto _L15
_L9:
        c = '\u0660';
          goto _L8
_L10:
        c = '\u06F0';
          goto _L8
_L11:
        int i2 = c + -48;
        int j2 = 0;
        while(j2 < i1)  {
            char c2 = ac2[j2];
            if(c2 <= '9' && c2 >= '0')
                ac2[j2] = i2 + ac2[j2];
            j2++;
        }
          goto _L7
_L12:
        int j1 = c + 9;
        int k1 = 48 - c;
        int l1 = 0;
        while(l1 < i1)  {
            char c1 = ac2[l1];
            if(c1 <= j1 && c1 >= c)
                ac2[l1] = k1 + ac2[l1];
            l1++;
        }
          goto _L7
_L13:
        shapeToArabicDigitsWithContext(ac2, 0, i1, c, false);
          goto _L7
_L14:
        shapeToArabicDigitsWithContext(ac2, 0, i1, c, true);
          goto _L7
    }

    private static void invertBuffer(char ac[], int i, int j) {
        int k = i;
        for(int l = -1 + (i + j); k < l; l--) {
            char c = ac[k];
            ac[k] = ac[l];
            ac[l] = c;
            k++;
        }

    }

    private static boolean isAlefChar(char c) {
        boolean flag;
        if(c == '\u0622' || c == '\u0623' || c == '\u0625' || c == '\u0627')
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static boolean isAlefMaksouraChar(char c) {
        boolean flag;
        if(c == '\uFEEF' || c == '\uFEF0' || c == '\u0649')
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static int isIsolatedTashkeelChar(char c) {
        int i;
        if(c >= '\uFE70' && c <= '\uFE7F' && c != '\uFE73' && c != '\uFE75')
            i = 1 - tashkeelMedial[c - 65136];
        else
        if(c >= '\uFC5E' && c <= '\uFC63')
            i = 1;
        else
            i = 0;
        return i;
    }

    private static boolean isLamAlefChar(char c) {
        boolean flag;
        if(c >= '\uFEF5' && c <= '\uFEFC')
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static boolean isNormalizedLamAlefChar(char c) {
        boolean flag;
        if(c >= '\u065C' && c <= '\u065F')
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static int isSeenFamilyChar(char c) {
        int i;
        if(c >= '\u0633' && c <= '\u0636')
            i = 1;
        else
            i = 0;
        return i;
    }

    private static int isSeenTailFamilyChar(char c) {
        int i;
        if(c >= '\uFEB1' && c < '\uFEBF')
            i = tailFamilyIsolatedFinal[c - 65201];
        else
            i = 0;
        return i;
    }

    private static boolean isTailChar(char c) {
        boolean flag;
        if(c == '\u200B' || c == '\uFE73')
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static boolean isTashkeelChar(char c) {
        boolean flag;
        if(c >= '\u064B' && c <= '\u0652')
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static boolean isTashkeelCharFE(char c) {
        boolean flag;
        if(c != '\uFE75' && c >= '\uFE70' && c <= '\uFE7F')
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static int isTashkeelOnTatweelChar(char c) {
        int i;
        if(c >= '\uFE70' && c <= '\uFE7F' && c != '\uFE73' && c != '\uFE75' && c != '\uFE7D')
            i = tashkeelMedial[c - 65136];
        else
        if(c >= '\uFCF2' && c <= '\uFCF4' || c == '\uFE7D')
            i = 2;
        else
            i = 0;
        return i;
    }

    private static boolean isYehHamzaChar(char c) {
        boolean flag;
        if(c == '\uFE89' || c == '\uFE8A')
            flag = true;
        else
            flag = false;
        return flag;
    }

    private int normalize(char ac[], int i, int j) {
        int k = 0;
        int l = i;
        for(int i1 = l + j; l < i1; l++) {
            char c = ac[l];
            if(c < '\uFE70' || c > '\uFEFC')
                continue;
            if(isLamAlefChar(c))
                k++;
            ac[l] = (char)convertFEto06[c - 65136];
        }

        return k;
    }

    private void shapeToArabicDigitsWithContext(char ac[], int i, int j, char c, boolean flag) {
        int k = c + -48;
        int l = i + j;
        do {
            if(--l < i)
                break;
            char c1 = ac[l];
            switch(Character.getDirectionality(c1)) {
            case 0: // '\0'
            case 1: // '\001'
                flag = false;
                break;

            case 2: // '\002'
                flag = true;
                break;

            case 3: // '\003'
                if(flag && c1 <= '9')
                    ac[l] = c1 + k;
                break;
            }
        } while(true);
    }

    private int shapeUnicode(char ac[], int i, int j, int k, int l) throws ArabicShapingException {
        int i1 = normalize(ac, i, j);
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        int j1 = -1 + (i + j);
        int k1 = getLink(ac[j1]);
        int l1 = 0;
        int i2 = 0;
        int j2 = 0;
        int k2 = j1;
        int l2 = -2;
        do {
            if(j1 < 0)
                break;
            if((0xff00 & k1) > 0 || isTashkeelChar(ac[j1])) {
                int j3 = j1 - 1;
                for(l2 = -2; l2 < 0;)
                    if(j3 == -1) {
                        l1 = 0;
                        l2 = 0x7fffffff;
                    } else {
                        l1 = getLink(ac[j3]);
                        if((l1 & 4) == 0)
                            l2 = j3;
                        else
                            j3--;
                    }

                if((k1 & 0x20) > 0 && (j2 & 0x10) > 0) {
                    flag = true;
                    char c = changeLamAlef(ac[j1]);
                    if(c != 0) {
                        ac[j1] = '\uFFFF';
                        ac[k2] = c;
                        j1 = k2;
                    }
                    j2 = i2;
                    k1 = getLink(c);
                }
                int k3;
                int l3;
                if(j1 > 0 && ac[j1 - 1] == ' ') {
                    if(isSeenFamilyChar(ac[j1]) == 1)
                        flag1 = true;
                    else
                    if(ac[j1] == '\u0626')
                        flag2 = true;
                } else
                if(j1 == 0)
                    if(isSeenFamilyChar(ac[j1]) == 1)
                        flag1 = true;
                    else
                    if(ac[j1] == '\u0626')
                        flag2 = true;
                k3 = specialChar(ac[j1]);
                l3 = shapeTable[l1 & 3][j2 & 3][k1 & 3];
                if(k3 == 1)
                    l3 &= 1;
                else
                if(k3 == 2)
                    if(l == 0 && (j2 & 2) != 0 && (l1 & 1) != 0 && ac[j1] != '\u064C' && ac[j1] != '\u064D' && ((l1 & 0x20) != 32 || (j2 & 0x10) != 16))
                        l3 = 1;
                    else
                        l3 = 0;
                if(k3 == 2) {
                    if(l == 2) {
                        ac[j1] = '\uFFFE';
                        flag3 = true;
                    } else {
                        ac[j1] = (char)(l3 + (65136 + irrelevantPos[-1611 + ac[j1]]));
                    }
                } else {
                    ac[j1] = (char)(l3 + (65136 + (k1 >> 8)));
                }
            }
            if((k1 & 4) == 0) {
                i2 = j2;
                j2 = k1;
                k2 = j1;
            }
            if(--j1 == l2) {
                k1 = l1;
                l2 = -2;
            } else
            if(j1 != -1)
                k1 = getLink(ac[j1]);
        } while(true);
        int i3 = j;
        if(flag || flag3)
            i3 = handleGeneratedSpaces(ac, i, j);
        if(flag1 || flag2)
            i3 = expandCompositChar(ac, i, i3, i1, 0);
        return i3;
    }

    public static void shiftArray(char ac[], int i, int j, char c) {
        int k = j;
        int l = j;
        do {
            if(--l < i)
                break;
            char c1 = ac[l];
            if(c1 != c && --k != l)
                ac[k] = c1;
        } while(true);
    }

    private static int specialChar(char c) {
        int i;
        if(c > '\u0621' && c < '\u0626' || c == '\u0627' || c > '\u062E' && c < '\u0633' || c > '\u0647' && c < '\u064A' || c == '\u0629')
            i = 1;
        else
        if(c >= '\u064B' && c <= '\u0652')
            i = 2;
        else
        if(c >= '\u0653' && c <= '\u0655' || c == '\u0670' || c >= '\uFE70' && c <= '\uFE7F')
            i = 3;
        else
            i = 0;
        return i;
    }

    public boolean equals(Object obj) {
        boolean flag;
        if(obj != null && obj.getClass() == android/icu/text/ArabicShaping && options == ((ArabicShaping)obj).options)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public int hashCode() {
        return options;
    }

    public int shape(char ac[], int i, int j, char ac1[], int k, int l) throws ArabicShapingException {
        if(ac == null)
            throw new IllegalArgumentException("source can not be null");
        if(i < 0 || j < 0 || i + j > ac.length)
            throw new IllegalArgumentException((new StringBuilder()).append("bad source start (").append(i).append(") or length (").append(j).append(") for buffer of length ").append(ac.length).toString());
        if(ac1 == null && l != 0)
            throw new IllegalArgumentException("null dest requires destSize == 0");
        if(l != 0 && (k < 0 || l < 0 || k + l > ac1.length))
            throw new IllegalArgumentException((new StringBuilder()).append("bad dest start (").append(k).append(") or size (").append(l).append(") for buffer of length ").append(ac1.length).toString());
        if((0xe0000 & options) > 0 && (0xe0000 & options) != 0x40000 && (0xe0000 & options) != 0x60000 && (0xe0000 & options) != 0x80000 && (0xe0000 & options) != 0xc0000)
            throw new IllegalArgumentException("Wrong Tashkeel argument");
        if((0x10003 & options) > 0 && (0x10003 & options) != 3 && (0x10003 & options) != 2 && (0x10003 & options) != 0 && (0x10003 & options) != 0x10000 && (0x10003 & options) != 1)
            throw new IllegalArgumentException("Wrong Lam Alef argument");
        if((0xe0000 & options) > 0 && (0x18 & options) == 16)
            throw new IllegalArgumentException("Tashkeel replacement should not be enabled in deshaping mode ");
        else
            return internalShape(ac, i, j, ac1, k, l);
    }

    public String shape(String s) throws ArabicShapingException {
        char ac[] = s.toCharArray();
        char ac1[] = ac;
        if((0x10003 & options) == 0 && (0x18 & options) == 16)
            ac1 = new char[2 * ac.length];
        return new String(ac1, 0, shape(ac, 0, ac.length, ac1, 0, ac1.length));
    }

    public void shape(char ac[], int i, int j) throws ArabicShapingException {
        if((0x10003 & options) == 0) {
            throw new ArabicShapingException("Cannot shape in place with length option resize.");
        } else {
            shape(ac, i, j, ac, i, j);
            return;
        }
    }

    public String toString() {
        StringBuffer stringbuffer;
        stringbuffer = new StringBuffer(super.toString());
        stringbuffer.append('[');
        0x10003 & options;
        JVM INSTR lookupswitch 5: default 76
    //                   0: 361
    //                   1: 372
    //                   2: 394
    //                   3: 383
    //                   65536: 405;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        4 & options;
        JVM INSTR lookupswitch 2: default 108
    //                   0: 416
    //                   4: 427;
           goto _L7 _L8 _L9
_L7:
        0x18 & options;
        JVM INSTR lookupswitch 4: default 156
    //                   0: 438
    //                   8: 449
    //                   16: 471
    //                   24: 460;
           goto _L10 _L11 _L12 _L13 _L14
_L10:
        0x700000 & options;
        JVM INSTR tableswitch 2097152 2097152: default 180
    //                   2097152 482;
           goto _L15 _L16
_L15:
        0x3800000 & options;
        JVM INSTR tableswitch 16777216 16777216: default 204
    //                   16777216 493;
           goto _L17 _L18
_L17:
        0xe0000 & options;
        JVM INSTR lookupswitch 4: default 252
    //                   262144: 504
    //                   393216: 515
    //                   524288: 537
    //                   786432: 526;
           goto _L19 _L20 _L21 _L22 _L23
_L19:
        0xe0 & options;
        JVM INSTR lookupswitch 5: default 312
    //                   0: 548
    //                   32: 559
    //                   64: 570
    //                   96: 581
    //                   128: 592;
           goto _L24 _L25 _L26 _L27 _L28 _L29
_L24:
        0x100 & options;
        JVM INSTR lookupswitch 2: default 348
    //                   0: 603
    //                   256: 614;
           goto _L30 _L31 _L32
_L30:
        stringbuffer.append("]");
        return stringbuffer.toString();
_L2:
        stringbuffer.append("LamAlef resize");
          goto _L1
_L3:
        stringbuffer.append("LamAlef spaces at near");
          goto _L1
_L5:
        stringbuffer.append("LamAlef spaces at begin");
          goto _L1
_L4:
        stringbuffer.append("LamAlef spaces at end");
          goto _L1
_L6:
        stringbuffer.append("lamAlef auto");
          goto _L1
_L8:
        stringbuffer.append(", logical");
          goto _L7
_L9:
        stringbuffer.append(", visual");
          goto _L7
_L11:
        stringbuffer.append(", no letter shaping");
          goto _L10
_L12:
        stringbuffer.append(", shape letters");
          goto _L10
_L14:
        stringbuffer.append(", shape letters tashkeel isolated");
          goto _L10
_L13:
        stringbuffer.append(", unshape letters");
          goto _L10
_L16:
        stringbuffer.append(", Seen at near");
          goto _L15
_L18:
        stringbuffer.append(", Yeh Hamza at near");
          goto _L17
_L20:
        stringbuffer.append(", Tashkeel at begin");
          goto _L19
_L21:
        stringbuffer.append(", Tashkeel at end");
          goto _L19
_L23:
        stringbuffer.append(", Tashkeel replace with tatweel");
          goto _L19
_L22:
        stringbuffer.append(", Tashkeel resize");
          goto _L19
_L25:
        stringbuffer.append(", no digit shaping");
          goto _L24
_L26:
        stringbuffer.append(", shape digits to AN");
          goto _L24
_L27:
        stringbuffer.append(", shape digits to EN");
          goto _L24
_L28:
        stringbuffer.append(", shape digits to AN contextually: default EN");
          goto _L24
_L29:
        stringbuffer.append(", shape digits to AN contextually: default AL");
          goto _L24
_L31:
        stringbuffer.append(", standard Arabic-Indic digits");
          goto _L30
_L32:
        stringbuffer.append(", extended Arabic-Indic digits");
          goto _L30
    }

    private static final int ALEFTYPE = 32;
    private static final int DESHAPE_MODE = 1;
    public static final int DIGITS_AN2EN = 64;
    public static final int DIGITS_EN2AN = 32;
    public static final int DIGITS_EN2AN_INIT_AL = 128;
    public static final int DIGITS_EN2AN_INIT_LR = 96;
    public static final int DIGITS_MASK = 224;
    public static final int DIGITS_NOOP = 0;
    public static final int DIGIT_TYPE_AN = 0;
    public static final int DIGIT_TYPE_AN_EXTENDED = 256;
    public static final int DIGIT_TYPE_MASK = 256;
    private static final char HAMZA06_CHAR = 1569;
    private static final char HAMZAFE_CHAR = 65152;
    private static final int IRRELEVANT = 4;
    public static final int LAMALEF_AUTO = 0x10000;
    public static final int LAMALEF_BEGIN = 3;
    public static final int LAMALEF_END = 2;
    public static final int LAMALEF_MASK = 0x10003;
    public static final int LAMALEF_NEAR = 1;
    public static final int LAMALEF_RESIZE = 0;
    private static final char LAMALEF_SPACE_SUB = 65535;
    private static final int LAMTYPE = 16;
    private static final char LAM_CHAR = 1604;
    public static final int LENGTH_FIXED_SPACES_AT_BEGINNING = 3;
    public static final int LENGTH_FIXED_SPACES_AT_END = 2;
    public static final int LENGTH_FIXED_SPACES_NEAR = 1;
    public static final int LENGTH_GROW_SHRINK = 0;
    public static final int LENGTH_MASK = 0x10003;
    public static final int LETTERS_MASK = 24;
    public static final int LETTERS_NOOP = 0;
    public static final int LETTERS_SHAPE = 8;
    public static final int LETTERS_SHAPE_TASHKEEL_ISOLATED = 24;
    public static final int LETTERS_UNSHAPE = 16;
    private static final int LINKL = 2;
    private static final int LINKR = 1;
    private static final int LINK_MASK = 3;
    private static final char NEW_TAIL_CHAR = 65139;
    private static final char OLD_TAIL_CHAR = 8203;
    public static final int SEEN_MASK = 0x700000;
    public static final int SEEN_TWOCELL_NEAR = 0x200000;
    private static final char SHADDA_CHAR = 65148;
    private static final char SHADDA_TATWEEL_CHAR = 65149;
    public static final ArabicShaping SHAPER = new ArabicShaping(9);
    private static final int SHAPE_MODE = 0;
    public static final int SHAPE_TAIL_NEW_UNICODE = 0x8000000;
    public static final int SHAPE_TAIL_TYPE_MASK = 0x8000000;
    public static final int SPACES_RELATIVE_TO_TEXT_BEGIN_END = 0x4000000;
    public static final int SPACES_RELATIVE_TO_TEXT_MASK = 0x4000000;
    private static final char SPACE_CHAR = 32;
    private static final char SPACE_CHAR_FOR_LAMALEF = 65279;
    public static final int TASHKEEL_BEGIN = 0x40000;
    public static final int TASHKEEL_END = 0x60000;
    public static final int TASHKEEL_MASK = 0xe0000;
    public static final int TASHKEEL_REPLACE_BY_TATWEEL = 0xc0000;
    public static final int TASHKEEL_RESIZE = 0x80000;
    private static final char TASHKEEL_SPACE_SUB = 65534;
    private static final char TATWEEL_CHAR = 1600;
    public static final int TEXT_DIRECTION_LOGICAL = 0;
    public static final int TEXT_DIRECTION_MASK = 4;
    public static final int TEXT_DIRECTION_VISUAL_LTR = 4;
    public static final int TEXT_DIRECTION_VISUAL_RTL = 0;
    public static final int YEHHAMZA_MASK = 0x3800000;
    public static final int YEHHAMZA_TWOCELL_NEAR = 0x1000000;
    private static final char YEH_HAMZAFE_CHAR = 65161;
    private static final char YEH_HAMZA_CHAR = 1574;
    private static final int araLink[];
    private static int convertFEto06[];
    private static final char convertNormalizedLamAlef[];
    private static final int irrelevantPos[];
    private static final int presLink[];
    private static final int shapeTable[][][];
    private static final int tailFamilyIsolatedFinal[];
    private static final int tashkeelMedial[];
    private static final char yehHamzaToYeh[];
    private boolean isLogical;
    private final int options;
    private boolean spacesRelativeToTextBeginEnd;
    private char tailChar;

    static  {
        int ai[] = new int[8];
        ai[0] = 0;
        ai[1] = 2;
        ai[2] = 4;
        ai[3] = 6;
        ai[4] = 8;
        ai[5] = 10;
        ai[6] = 12;
        ai[7] = 14;
        irrelevantPos = ai;
        int ai1[] = new int[14];
        ai1[0] = 1;
        ai1[1] = 1;
        ai1[2] = 0;
        ai1[3] = 0;
        ai1[4] = 1;
        ai1[5] = 1;
        ai1[6] = 0;
        ai1[7] = 0;
        ai1[8] = 1;
        ai1[9] = 1;
        ai1[10] = 0;
        ai1[11] = 0;
        ai1[12] = 1;
        ai1[13] = 1;
        tailFamilyIsolatedFinal = ai1;
        int ai2[] = new int[16];
        ai2[0] = 0;
        ai2[1] = 1;
        ai2[2] = 0;
        ai2[3] = 0;
        ai2[4] = 0;
        ai2[5] = 0;
        ai2[6] = 0;
        ai2[7] = 1;
        ai2[8] = 0;
        ai2[9] = 1;
        ai2[10] = 0;
        ai2[11] = 1;
        ai2[12] = 0;
        ai2[13] = 1;
        ai2[14] = 0;
        ai2[15] = 1;
        tashkeelMedial = ai2;
        char ac[] = new char[2];
        ac[0] = '\uFEEF';
        ac[1] = '\uFEF0';
        yehHamzaToYeh = ac;
        char ac1[] = new char[4];
        ac1[0] = '\u0622';
        ac1[1] = '\u0623';
        ac1[2] = '\u0625';
        ac1[3] = '\u0627';
        convertNormalizedLamAlef = ac1;
        int ai3[] = new int[178];
        ai3[0] = 4385;
        ai3[1] = 4897;
        ai3[2] = 5377;
        ai3[3] = 5921;
        ai3[4] = 6403;
        ai3[5] = 7457;
        ai3[6] = 7939;
        ai3[7] = 8961;
        ai3[8] = 9475;
        ai3[9] = 10499;
        ai3[10] = 11523;
        ai3[11] = 12547;
        ai3[12] = 13571;
        ai3[13] = 14593;
        ai3[14] = 15105;
        ai3[15] = 15617;
        ai3[16] = 16129;
        ai3[17] = 16643;
        ai3[18] = 17667;
        ai3[19] = 18691;
        ai3[20] = 19715;
        ai3[21] = 20739;
        ai3[22] = 21763;
        ai3[23] = 22787;
        ai3[24] = 23811;
        ai3[25] = 0;
        ai3[26] = 0;
        ai3[27] = 0;
        ai3[28] = 0;
        ai3[29] = 0;
        ai3[30] = 3;
        ai3[31] = 24835;
        ai3[32] = 25859;
        ai3[33] = 26883;
        ai3[34] = 27923;
        ai3[35] = 28931;
        ai3[36] = 29955;
        ai3[37] = 30979;
        ai3[38] = 32001;
        ai3[39] = 32513;
        ai3[40] = 33027;
        ai3[41] = 4;
        ai3[42] = 4;
        ai3[43] = 4;
        ai3[44] = 4;
        ai3[45] = 4;
        ai3[46] = 4;
        ai3[47] = 4;
        ai3[48] = 4;
        ai3[49] = 4;
        ai3[50] = 4;
        ai3[51] = 4;
        ai3[52] = 0;
        ai3[53] = 0;
        ai3[54] = 0;
        ai3[55] = 0;
        ai3[56] = 0;
        ai3[57] = 0;
        ai3[58] = 34049;
        ai3[59] = 34561;
        ai3[60] = 35073;
        ai3[61] = 35585;
        ai3[62] = 0;
        ai3[63] = 0;
        ai3[64] = 0;
        ai3[65] = 0;
        ai3[66] = 0;
        ai3[67] = 0;
        ai3[68] = 0;
        ai3[69] = 0;
        ai3[70] = 0;
        ai3[71] = 0;
        ai3[72] = 0;
        ai3[73] = 0;
        ai3[74] = 0;
        ai3[75] = 0;
        ai3[76] = 0;
        ai3[77] = 0;
        ai3[78] = 4;
        ai3[79] = 0;
        ai3[80] = 33;
        ai3[81] = 33;
        ai3[82] = 0;
        ai3[83] = 33;
        ai3[84] = 1;
        ai3[85] = 1;
        ai3[86] = 3;
        ai3[87] = 3;
        ai3[88] = 3;
        ai3[89] = 3;
        ai3[90] = 3;
        ai3[91] = 3;
        ai3[92] = 3;
        ai3[93] = 3;
        ai3[94] = 3;
        ai3[95] = 3;
        ai3[96] = 3;
        ai3[97] = 3;
        ai3[98] = 3;
        ai3[99] = 3;
        ai3[100] = 3;
        ai3[101] = 3;
        ai3[102] = 1;
        ai3[103] = 1;
        ai3[104] = 1;
        ai3[105] = 1;
        ai3[106] = 1;
        ai3[107] = 1;
        ai3[108] = 1;
        ai3[109] = 1;
        ai3[110] = 1;
        ai3[111] = 1;
        ai3[112] = 1;
        ai3[113] = 1;
        ai3[114] = 1;
        ai3[115] = 1;
        ai3[116] = 1;
        ai3[117] = 1;
        ai3[118] = 1;
        ai3[119] = 1;
        ai3[120] = 3;
        ai3[121] = 3;
        ai3[122] = 3;
        ai3[123] = 3;
        ai3[124] = 3;
        ai3[125] = 3;
        ai3[126] = 3;
        ai3[127] = 3;
        ai3[128] = 3;
        ai3[129] = 3;
        ai3[130] = 3;
        ai3[131] = 3;
        ai3[132] = 3;
        ai3[133] = 3;
        ai3[134] = 3;
        ai3[135] = 3;
        ai3[136] = 3;
        ai3[137] = 3;
        ai3[138] = 3;
        ai3[139] = 3;
        ai3[140] = 3;
        ai3[141] = 3;
        ai3[142] = 3;
        ai3[143] = 3;
        ai3[144] = 3;
        ai3[145] = 3;
        ai3[146] = 3;
        ai3[147] = 3;
        ai3[148] = 3;
        ai3[149] = 3;
        ai3[150] = 3;
        ai3[151] = 3;
        ai3[152] = 3;
        ai3[153] = 3;
        ai3[154] = 3;
        ai3[155] = 3;
        ai3[156] = 3;
        ai3[157] = 3;
        ai3[158] = 1;
        ai3[159] = 3;
        ai3[160] = 1;
        ai3[161] = 1;
        ai3[162] = 1;
        ai3[163] = 1;
        ai3[164] = 1;
        ai3[165] = 1;
        ai3[166] = 1;
        ai3[167] = 1;
        ai3[168] = 1;
        ai3[169] = 1;
        ai3[170] = 3;
        ai3[171] = 1;
        ai3[172] = 3;
        ai3[173] = 3;
        ai3[174] = 3;
        ai3[175] = 3;
        ai3[176] = 1;
        ai3[177] = 1;
        araLink = ai3;
        int ai4[] = new int[141];
        ai4[0] = 3;
        ai4[1] = 3;
        ai4[2] = 3;
        ai4[3] = 0;
        ai4[4] = 3;
        ai4[5] = 0;
        ai4[6] = 3;
        ai4[7] = 3;
        ai4[8] = 3;
        ai4[9] = 3;
        ai4[10] = 3;
        ai4[11] = 3;
        ai4[12] = 3;
        ai4[13] = 3;
        ai4[14] = 3;
        ai4[15] = 3;
        ai4[16] = 0;
        ai4[17] = 32;
        ai4[18] = 33;
        ai4[19] = 32;
        ai4[20] = 33;
        ai4[21] = 0;
        ai4[22] = 1;
        ai4[23] = 32;
        ai4[24] = 33;
        ai4[25] = 0;
        ai4[26] = 2;
        ai4[27] = 3;
        ai4[28] = 1;
        ai4[29] = 32;
        ai4[30] = 33;
        ai4[31] = 0;
        ai4[32] = 2;
        ai4[33] = 3;
        ai4[34] = 1;
        ai4[35] = 0;
        ai4[36] = 1;
        ai4[37] = 0;
        ai4[38] = 2;
        ai4[39] = 3;
        ai4[40] = 1;
        ai4[41] = 0;
        ai4[42] = 2;
        ai4[43] = 3;
        ai4[44] = 1;
        ai4[45] = 0;
        ai4[46] = 2;
        ai4[47] = 3;
        ai4[48] = 1;
        ai4[49] = 0;
        ai4[50] = 2;
        ai4[51] = 3;
        ai4[52] = 1;
        ai4[53] = 0;
        ai4[54] = 2;
        ai4[55] = 3;
        ai4[56] = 1;
        ai4[57] = 0;
        ai4[58] = 1;
        ai4[59] = 0;
        ai4[60] = 1;
        ai4[61] = 0;
        ai4[62] = 1;
        ai4[63] = 0;
        ai4[64] = 1;
        ai4[65] = 0;
        ai4[66] = 2;
        ai4[67] = 3;
        ai4[68] = 1;
        ai4[69] = 0;
        ai4[70] = 2;
        ai4[71] = 3;
        ai4[72] = 1;
        ai4[73] = 0;
        ai4[74] = 2;
        ai4[75] = 3;
        ai4[76] = 1;
        ai4[77] = 0;
        ai4[78] = 2;
        ai4[79] = 3;
        ai4[80] = 1;
        ai4[81] = 0;
        ai4[82] = 2;
        ai4[83] = 3;
        ai4[84] = 1;
        ai4[85] = 0;
        ai4[86] = 2;
        ai4[87] = 3;
        ai4[88] = 1;
        ai4[89] = 0;
        ai4[90] = 2;
        ai4[91] = 3;
        ai4[92] = 1;
        ai4[93] = 0;
        ai4[94] = 2;
        ai4[95] = 3;
        ai4[96] = 1;
        ai4[97] = 0;
        ai4[98] = 2;
        ai4[99] = 3;
        ai4[100] = 1;
        ai4[101] = 0;
        ai4[102] = 2;
        ai4[103] = 3;
        ai4[104] = 1;
        ai4[105] = 0;
        ai4[106] = 2;
        ai4[107] = 3;
        ai4[108] = 1;
        ai4[109] = 16;
        ai4[110] = 18;
        ai4[111] = 19;
        ai4[112] = 17;
        ai4[113] = 0;
        ai4[114] = 2;
        ai4[115] = 3;
        ai4[116] = 1;
        ai4[117] = 0;
        ai4[118] = 2;
        ai4[119] = 3;
        ai4[120] = 1;
        ai4[121] = 0;
        ai4[122] = 2;
        ai4[123] = 3;
        ai4[124] = 1;
        ai4[125] = 0;
        ai4[126] = 1;
        ai4[127] = 0;
        ai4[128] = 1;
        ai4[129] = 0;
        ai4[130] = 2;
        ai4[131] = 3;
        ai4[132] = 1;
        ai4[133] = 0;
        ai4[134] = 1;
        ai4[135] = 0;
        ai4[136] = 1;
        ai4[137] = 0;
        ai4[138] = 1;
        ai4[139] = 0;
        ai4[140] = 1;
        presLink = ai4;
        int ai5[] = new int[141];
        ai5[0] = 1611;
        ai5[1] = 1611;
        ai5[2] = 1612;
        ai5[3] = 1612;
        ai5[4] = 1613;
        ai5[5] = 1613;
        ai5[6] = 1614;
        ai5[7] = 1614;
        ai5[8] = 1615;
        ai5[9] = 1615;
        ai5[10] = 1616;
        ai5[11] = 1616;
        ai5[12] = 1617;
        ai5[13] = 1617;
        ai5[14] = 1618;
        ai5[15] = 1618;
        ai5[16] = 1569;
        ai5[17] = 1570;
        ai5[18] = 1570;
        ai5[19] = 1571;
        ai5[20] = 1571;
        ai5[21] = 1572;
        ai5[22] = 1572;
        ai5[23] = 1573;
        ai5[24] = 1573;
        ai5[25] = 1574;
        ai5[26] = 1574;
        ai5[27] = 1574;
        ai5[28] = 1574;
        ai5[29] = 1575;
        ai5[30] = 1575;
        ai5[31] = 1576;
        ai5[32] = 1576;
        ai5[33] = 1576;
        ai5[34] = 1576;
        ai5[35] = 1577;
        ai5[36] = 1577;
        ai5[37] = 1578;
        ai5[38] = 1578;
        ai5[39] = 1578;
        ai5[40] = 1578;
        ai5[41] = 1579;
        ai5[42] = 1579;
        ai5[43] = 1579;
        ai5[44] = 1579;
        ai5[45] = 1580;
        ai5[46] = 1580;
        ai5[47] = 1580;
        ai5[48] = 1580;
        ai5[49] = 1581;
        ai5[50] = 1581;
        ai5[51] = 1581;
        ai5[52] = 1581;
        ai5[53] = 1582;
        ai5[54] = 1582;
        ai5[55] = 1582;
        ai5[56] = 1582;
        ai5[57] = 1583;
        ai5[58] = 1583;
        ai5[59] = 1584;
        ai5[60] = 1584;
        ai5[61] = 1585;
        ai5[62] = 1585;
        ai5[63] = 1586;
        ai5[64] = 1586;
        ai5[65] = 1587;
        ai5[66] = 1587;
        ai5[67] = 1587;
        ai5[68] = 1587;
        ai5[69] = 1588;
        ai5[70] = 1588;
        ai5[71] = 1588;
        ai5[72] = 1588;
        ai5[73] = 1589;
        ai5[74] = 1589;
        ai5[75] = 1589;
        ai5[76] = 1589;
        ai5[77] = 1590;
        ai5[78] = 1590;
        ai5[79] = 1590;
        ai5[80] = 1590;
        ai5[81] = 1591;
        ai5[82] = 1591;
        ai5[83] = 1591;
        ai5[84] = 1591;
        ai5[85] = 1592;
        ai5[86] = 1592;
        ai5[87] = 1592;
        ai5[88] = 1592;
        ai5[89] = 1593;
        ai5[90] = 1593;
        ai5[91] = 1593;
        ai5[92] = 1593;
        ai5[93] = 1594;
        ai5[94] = 1594;
        ai5[95] = 1594;
        ai5[96] = 1594;
        ai5[97] = 1601;
        ai5[98] = 1601;
        ai5[99] = 1601;
        ai5[100] = 1601;
        ai5[101] = 1602;
        ai5[102] = 1602;
        ai5[103] = 1602;
        ai5[104] = 1602;
        ai5[105] = 1603;
        ai5[106] = 1603;
        ai5[107] = 1603;
        ai5[108] = 1603;
        ai5[109] = 1604;
        ai5[110] = 1604;
        ai5[111] = 1604;
        ai5[112] = 1604;
        ai5[113] = 1605;
        ai5[114] = 1605;
        ai5[115] = 1605;
        ai5[116] = 1605;
        ai5[117] = 1606;
        ai5[118] = 1606;
        ai5[119] = 1606;
        ai5[120] = 1606;
        ai5[121] = 1607;
        ai5[122] = 1607;
        ai5[123] = 1607;
        ai5[124] = 1607;
        ai5[125] = 1608;
        ai5[126] = 1608;
        ai5[127] = 1609;
        ai5[128] = 1609;
        ai5[129] = 1610;
        ai5[130] = 1610;
        ai5[131] = 1610;
        ai5[132] = 1610;
        ai5[133] = 1628;
        ai5[134] = 1628;
        ai5[135] = 1629;
        ai5[136] = 1629;
        ai5[137] = 1630;
        ai5[138] = 1630;
        ai5[139] = 1631;
        ai5[140] = 1631;
        convertFEto06 = ai5;
        int ai6[][][] = new int[4][][];
        int ai7[][] = new int[4][];
        int ai8[] = new int[4];
        ai8[0] = 0;
        ai8[1] = 0;
        ai8[2] = 0;
        ai8[3] = 0;
        ai7[0] = ai8;
        int ai9[] = new int[4];
        ai9[0] = 0;
        ai9[1] = 0;
        ai9[2] = 0;
        ai9[3] = 0;
        ai7[1] = ai9;
        int ai10[] = new int[4];
        ai10[0] = 0;
        ai10[1] = 1;
        ai10[2] = 0;
        ai10[3] = 3;
        ai7[2] = ai10;
        int ai11[] = new int[4];
        ai11[0] = 0;
        ai11[1] = 1;
        ai11[2] = 0;
        ai11[3] = 1;
        ai7[3] = ai11;
        ai6[0] = ai7;
        int ai12[][] = new int[4][];
        int ai13[] = new int[4];
        ai13[0] = 0;
        ai13[1] = 0;
        ai13[2] = 2;
        ai13[3] = 2;
        ai12[0] = ai13;
        int ai14[] = new int[4];
        ai14[0] = 0;
        ai14[1] = 0;
        ai14[2] = 1;
        ai14[3] = 2;
        ai12[1] = ai14;
        int ai15[] = new int[4];
        ai15[0] = 0;
        ai15[1] = 1;
        ai15[2] = 1;
        ai15[3] = 2;
        ai12[2] = ai15;
        int ai16[] = new int[4];
        ai16[0] = 0;
        ai16[1] = 1;
        ai16[2] = 1;
        ai16[3] = 3;
        ai12[3] = ai16;
        ai6[1] = ai12;
        int ai17[][] = new int[4][];
        int ai18[] = new int[4];
        ai18[0] = 0;
        ai18[1] = 0;
        ai18[2] = 0;
        ai18[3] = 0;
        ai17[0] = ai18;
        int ai19[] = new int[4];
        ai19[0] = 0;
        ai19[1] = 0;
        ai19[2] = 0;
        ai19[3] = 0;
        ai17[1] = ai19;
        int ai20[] = new int[4];
        ai20[0] = 0;
        ai20[1] = 1;
        ai20[2] = 0;
        ai20[3] = 3;
        ai17[2] = ai20;
        int ai21[] = new int[4];
        ai21[0] = 0;
        ai21[1] = 1;
        ai21[2] = 0;
        ai21[3] = 3;
        ai17[3] = ai21;
        ai6[2] = ai17;
        int ai22[][] = new int[4][];
        int ai23[] = new int[4];
        ai23[0] = 0;
        ai23[1] = 0;
        ai23[2] = 1;
        ai23[3] = 2;
        ai22[0] = ai23;
        int ai24[] = new int[4];
        ai24[0] = 0;
        ai24[1] = 0;
        ai24[2] = 1;
        ai24[3] = 2;
        ai22[1] = ai24;
        int ai25[] = new int[4];
        ai25[0] = 0;
        ai25[1] = 1;
        ai25[2] = 1;
        ai25[3] = 2;
        ai22[2] = ai25;
        int ai26[] = new int[4];
        ai26[0] = 0;
        ai26[1] = 1;
        ai26[2] = 1;
        ai26[3] = 3;
        ai22[3] = ai26;
        ai6[3] = ai22;
        shapeTable = ai6;
    }
}
