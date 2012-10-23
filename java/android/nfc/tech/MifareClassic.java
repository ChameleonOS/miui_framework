// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.nfc.tech;

import android.nfc.*;
import android.os.RemoteException;
import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

// Referenced classes of package android.nfc.tech:
//            BasicTagTechnology, NfcA

public final class MifareClassic extends BasicTagTechnology {

    public MifareClassic(Tag tag) throws RemoteException {
        NfcA nfca;
        super(tag, 8);
        nfca = NfcA.get(tag);
        mIsEmulated = false;
        nfca.getSak();
        JVM INSTR lookupswitch 11: default 120
    //                   1: 150
    //                   8: 150
    //                   9: 163
    //                   16: 178
    //                   17: 193
    //                   24: 208
    //                   40: 223
    //                   56: 243
    //                   136: 263
    //                   152: 278
    //                   184: 278;
           goto _L1 _L2 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L10
_L1:
        throw new RuntimeException((new StringBuilder()).append("Tag incorrectly enumerated as MIFARE Classic, SAK = ").append(nfca.getSak()).toString());
_L2:
        mType = 0;
        mSize = 1024;
_L12:
        return;
_L3:
        mType = 0;
        mSize = 320;
        continue; /* Loop/switch isn't completed */
_L4:
        mType = 1;
        mSize = 2048;
        continue; /* Loop/switch isn't completed */
_L5:
        mType = 1;
        mSize = 4096;
        continue; /* Loop/switch isn't completed */
_L6:
        mType = 0;
        mSize = 4096;
        continue; /* Loop/switch isn't completed */
_L7:
        mType = 0;
        mSize = 1024;
        mIsEmulated = true;
        continue; /* Loop/switch isn't completed */
_L8:
        mType = 0;
        mSize = 4096;
        mIsEmulated = true;
        continue; /* Loop/switch isn't completed */
_L9:
        mType = 0;
        mSize = 1024;
        continue; /* Loop/switch isn't completed */
_L10:
        mType = 2;
        mSize = 4096;
        if(true) goto _L12; else goto _L11
_L11:
    }

    private boolean authenticate(int i, byte abyte0[], boolean flag) throws IOException {
        boolean flag1;
        flag1 = true;
        validateSector(i);
        checkConnected();
        byte abyte1[] = new byte[12];
        byte abyte2[];
        byte abyte3[];
        if(flag)
            abyte1[0] = 96;
        else
            abyte1[0] = 97;
        abyte1[flag1] = (byte)sectorToBlock(i);
        abyte2 = getTag().getId();
        System.arraycopy(abyte2, -4 + abyte2.length, abyte1, 2, 4);
        System.arraycopy(abyte0, 0, abyte1, 6, 6);
        abyte3 = transceive(abyte1, false);
        if(abyte3 == null) goto _L2; else goto _L1
_L1:
        return flag1;
        TagLostException taglostexception;
        taglostexception;
        throw taglostexception;
        IOException ioexception;
        ioexception;
_L2:
        flag1 = false;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public static MifareClassic get(Tag tag) {
        MifareClassic mifareclassic = null;
        if(tag.hasTech(8)) goto _L2; else goto _L1
_L1:
        return mifareclassic;
_L2:
        MifareClassic mifareclassic1 = new MifareClassic(tag);
        mifareclassic = mifareclassic1;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L1; else goto _L3
_L3:
    }

    private static void validateBlock(int i) {
        if(i < 0 || i >= 256)
            throw new IndexOutOfBoundsException((new StringBuilder()).append("block out of bounds: ").append(i).toString());
        else
            return;
    }

    private static void validateSector(int i) {
        if(i < 0 || i >= 40)
            throw new IndexOutOfBoundsException((new StringBuilder()).append("sector out of bounds: ").append(i).toString());
        else
            return;
    }

    private static void validateValueOperand(int i) {
        if(i < 0)
            throw new IllegalArgumentException("value operand negative");
        else
            return;
    }

    public boolean authenticateSectorWithKeyA(int i, byte abyte0[]) throws IOException {
        return authenticate(i, abyte0, true);
    }

    public boolean authenticateSectorWithKeyB(int i, byte abyte0[]) throws IOException {
        return authenticate(i, abyte0, false);
    }

    public int blockToSector(int i) {
        validateBlock(i);
        int j;
        if(i < 128)
            j = i / 4;
        else
            j = 32 + (i - 128) / 16;
        return j;
    }

    public volatile void close() throws IOException {
        super.close();
    }

    public volatile void connect() throws IOException {
        super.connect();
    }

    public void decrement(int i, int j) throws IOException {
        validateBlock(i);
        validateValueOperand(j);
        checkConnected();
        ByteBuffer bytebuffer = ByteBuffer.allocate(6);
        bytebuffer.order(ByteOrder.LITTLE_ENDIAN);
        bytebuffer.put((byte)-64);
        bytebuffer.put((byte)i);
        bytebuffer.putInt(j);
        transceive(bytebuffer.array(), false);
    }

    public int getBlockCount() {
        return mSize / 16;
    }

    public int getBlockCountInSector(int i) {
        validateSector(i);
        byte byte0;
        if(i < 32)
            byte0 = 4;
        else
            byte0 = 16;
        return byte0;
    }

    public int getMaxTransceiveLength() {
        return getMaxTransceiveLengthInternal();
    }

    public int getSectorCount() {
        mSize;
        JVM INSTR lookupswitch 4: default 48
    //                   320: 70
    //                   1024: 52
    //                   2048: 58
    //                   4096: 64;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        int i = 0;
_L7:
        return i;
_L3:
        i = 16;
        continue; /* Loop/switch isn't completed */
_L4:
        i = 32;
        continue; /* Loop/switch isn't completed */
_L5:
        i = 40;
        continue; /* Loop/switch isn't completed */
_L2:
        i = 5;
        if(true) goto _L7; else goto _L6
_L6:
    }

    public int getSize() {
        return mSize;
    }

    public volatile Tag getTag() {
        return super.getTag();
    }

    public int getTimeout() {
        int j = super.mTag.getTagService().getTimeout(8);
        int i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        Log.e("NFC", "NFC service dead", remoteexception);
        i = 0;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public int getType() {
        return mType;
    }

    public void increment(int i, int j) throws IOException {
        validateBlock(i);
        validateValueOperand(j);
        checkConnected();
        ByteBuffer bytebuffer = ByteBuffer.allocate(6);
        bytebuffer.order(ByteOrder.LITTLE_ENDIAN);
        bytebuffer.put((byte)-63);
        bytebuffer.put((byte)i);
        bytebuffer.putInt(j);
        transceive(bytebuffer.array(), false);
    }

    public volatile boolean isConnected() {
        return super.isConnected();
    }

    public boolean isEmulated() {
        return mIsEmulated;
    }

    public byte[] readBlock(int i) throws IOException {
        validateBlock(i);
        checkConnected();
        byte abyte0[] = new byte[2];
        abyte0[0] = 48;
        abyte0[1] = (byte)i;
        return transceive(abyte0, false);
    }

    public volatile void reconnect() throws IOException {
        super.reconnect();
    }

    public void restore(int i) throws IOException {
        validateBlock(i);
        checkConnected();
        byte abyte0[] = new byte[2];
        abyte0[0] = -62;
        abyte0[1] = (byte)i;
        transceive(abyte0, false);
    }

    public int sectorToBlock(int i) {
        int j;
        if(i < 32)
            j = i * 4;
        else
            j = 128 + 16 * (i - 32);
        return j;
    }

    public void setTimeout(int i) {
        try {
            if(super.mTag.getTagService().setTimeout(8, i) != 0)
                throw new IllegalArgumentException("The supplied timeout is not valid");
        }
        catch(RemoteException remoteexception) {
            Log.e("NFC", "NFC service dead", remoteexception);
        }
    }

    public byte[] transceive(byte abyte0[]) throws IOException {
        return transceive(abyte0, true);
    }

    public void transfer(int i) throws IOException {
        validateBlock(i);
        checkConnected();
        byte abyte0[] = new byte[2];
        abyte0[0] = -80;
        abyte0[1] = (byte)i;
        transceive(abyte0, false);
    }

    public void writeBlock(int i, byte abyte0[]) throws IOException {
        validateBlock(i);
        checkConnected();
        if(abyte0.length != 16) {
            throw new IllegalArgumentException("must write 16-bytes");
        } else {
            byte abyte1[] = new byte[2 + abyte0.length];
            abyte1[0] = -96;
            abyte1[1] = (byte)i;
            System.arraycopy(abyte0, 0, abyte1, 2, abyte0.length);
            transceive(abyte1, false);
            return;
        }
    }

    public static final int BLOCK_SIZE = 16;
    public static final byte KEY_DEFAULT[];
    public static final byte KEY_MIFARE_APPLICATION_DIRECTORY[];
    public static final byte KEY_NFC_FORUM[];
    private static final int MAX_BLOCK_COUNT = 256;
    private static final int MAX_SECTOR_COUNT = 40;
    public static final int SIZE_1K = 1024;
    public static final int SIZE_2K = 2048;
    public static final int SIZE_4K = 4096;
    public static final int SIZE_MINI = 320;
    private static final String TAG = "NFC";
    public static final int TYPE_CLASSIC = 0;
    public static final int TYPE_PLUS = 1;
    public static final int TYPE_PRO = 2;
    public static final int TYPE_UNKNOWN = -1;
    private boolean mIsEmulated;
    private int mSize;
    private int mType;

    static  {
        byte abyte0[] = new byte[6];
        abyte0[0] = -1;
        abyte0[1] = -1;
        abyte0[2] = -1;
        abyte0[3] = -1;
        abyte0[4] = -1;
        abyte0[5] = -1;
        KEY_DEFAULT = abyte0;
        byte abyte1[] = new byte[6];
        abyte1[0] = -96;
        abyte1[1] = -95;
        abyte1[2] = -94;
        abyte1[3] = -93;
        abyte1[4] = -92;
        abyte1[5] = -91;
        KEY_MIFARE_APPLICATION_DIRECTORY = abyte1;
        byte abyte2[] = new byte[6];
        abyte2[0] = -45;
        abyte2[1] = -9;
        abyte2[2] = -45;
        abyte2[3] = -9;
        abyte2[4] = -45;
        abyte2[5] = -9;
        KEY_NFC_FORUM = abyte2;
    }
}
