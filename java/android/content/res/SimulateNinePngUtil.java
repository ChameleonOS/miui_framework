// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.res;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.zip.CRC32;

class SimulateNinePngUtil {
    private static class NinePathInputStream extends InputStream {

        public void close() throws IOException {
            if(mInputStream != null)
                mInputStream.close();
        }

        public int read() throws IOException {
            int i;
            if(mCount < mExtraHeaderData.length) {
                byte abyte0[] = mExtraHeaderData;
                int j = mCount;
                mCount = j + 1;
                i = abyte0[j];
            } else {
                i = mInputStream.read();
            }
            return i;
        }

        public int read(byte abyte0[], int i, int j) throws IOException {
            Arrays.checkOffsetAndCount(abyte0.length, i, j);
            int k;
            int l;
            for(k = 0; mCount < mExtraHeaderData.length && k < j; k = l) {
                l = k + 1;
                int i1 = i + k;
                byte abyte1[] = mExtraHeaderData;
                int j1 = mCount;
                mCount = j1 + 1;
                abyte0[i1] = abyte1[j1];
            }

            if(k < j)
                k += mInputStream.read(abyte0, i + k, j - k);
            return k;
        }

        private int mCount;
        private byte mExtraHeaderData[];
        private InputStream mInputStream;

        public NinePathInputStream(InputStream inputstream, byte abyte0[]) {
            mCount = 0;
            mInputStream = inputstream;
            mExtraHeaderData = abyte0;
            mCount = 0;
        }
    }


    SimulateNinePngUtil() {
    }

    private static int computePatchColor(byte abyte0[]) {
        return 1;
    }

    private static int convertByteToIntByBigEndian(byte abyte0[], int i) {
        return 0 + ((0xff & abyte0[i + 0]) << 24) + ((0xff & abyte0[i + 1]) << 16) + ((0xff & abyte0[i + 2]) << 8) + (0xff & abyte0[i + 3]);
    }

    private static void convertBytesFromIntByBigEndian(byte abyte0[], int i, int j) {
        abyte0[i + 0] = (byte)(0xff & j >>> 24);
        abyte0[i + 1] = (byte)(0xff & j >> 16);
        abyte0[i + 2] = (byte)(0xff & j >> 8);
        abyte0[i + 3] = (byte)(j & 0xff);
    }

    public static byte[] convertIntoNinePngData(byte abyte0[]) {
        if(abyte0 != null && abyte0.length >= 41 && isPngFormat(abyte0)) goto _L2; else goto _L1
_L1:
        abyte0 = null;
_L4:
        return abyte0;
_L2:
        if(!isNinePngFormat(abyte0)) {
            byte abyte1[] = getNinePatchChunk(abyte0);
            byte abyte2[] = new byte[12 + abyte0.length + abyte1.length];
            for(int i = 0; i < 33; i++)
                abyte2[i] = abyte0[i];

            convertBytesFromIntByBigEndian(abyte2, 33, abyte1.length);
            fillNinePngFormatMark(abyte2);
            for(int j = 0; j < abyte1.length; j++)
                abyte2[j + 41] = abyte1[j];

            int k = 41 + abyte1.length;
            CRC32 crc32 = new CRC32();
            crc32.update(abyte2, 37, 4 + abyte1.length);
            convertBytesFromIntByBigEndian(abyte2, k, (int)crc32.getValue());
            for(int l = 0; l < -33 + abyte0.length; l++)
                abyte2[l + (k + 4)] = abyte0[l + 33];

            abyte0 = abyte2;
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public static InputStream convertIntoNinePngStream(InputStream inputstream) {
        NinePathInputStream ninepathinputstream = null;
        byte abyte0[];
        int i;
        abyte0 = new byte[41];
        i = inputstream.read(abyte0);
        if(i > 0) goto _L2; else goto _L1
_L1:
        abyte0 = null;
_L4:
        byte abyte2[] = convertIntoNinePngData(abyte0);
        if(abyte2 != null)
            ninepathinputstream = new NinePathInputStream(inputstream, abyte2);
        break MISSING_BLOCK_LABEL_72;
_L2:
        if(i >= abyte0.length) goto _L4; else goto _L3
_L3:
        byte abyte1[] = Arrays.copyOf(abyte0, i);
        abyte0 = abyte1;
          goto _L4
        Exception exception;
        exception;
        exception.printStackTrace();
        return ninepathinputstream;
    }

    private static void fillNinePngFormatMark(byte abyte0[]) {
        abyte0[37] = 110;
        abyte0[38] = 112;
        abyte0[39] = 84;
        abyte0[40] = 99;
    }

    private static byte[] getNinePatchChunk(byte abyte0[]) {
        int i = convertByteToIntByBigEndian(abyte0, 16);
        int j = convertByteToIntByBigEndian(abyte0, 20);
        byte abyte1[] = new byte[52];
        abyte1[0] = 1;
        abyte1[1] = 2;
        abyte1[2] = 2;
        abyte1[3] = 1;
        convertBytesFromIntByBigEndian(abyte1, 36, i);
        convertBytesFromIntByBigEndian(abyte1, 44, j);
        convertBytesFromIntByBigEndian(abyte1, 48, computePatchColor(abyte0));
        return abyte1;
    }

    private static boolean isNinePngFormat(byte abyte0[]) {
        boolean flag;
        if(abyte0 != null && abyte0.length > 40 && abyte0[37] == 110 && abyte0[38] == 112 && abyte0[39] == 84 && abyte0[40] == 99)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static boolean isPngFormat(byte abyte0[]) {
        int i = 0;
_L3:
        if(i >= PNG_HEAD_FORMAT.length)
            break MISSING_BLOCK_LABEL_31;
        if(abyte0[i] == PNG_HEAD_FORMAT[i]) goto _L2; else goto _L1
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

    private static byte PNG_HEAD_FORMAT[];

    static  {
        byte abyte0[] = new byte[8];
        abyte0[0] = -119;
        abyte0[1] = 80;
        abyte0[2] = 78;
        abyte0[3] = 71;
        abyte0[4] = 13;
        abyte0[5] = 10;
        abyte0[6] = 26;
        abyte0[7] = 10;
        PNG_HEAD_FORMAT = abyte0;
    }
}
