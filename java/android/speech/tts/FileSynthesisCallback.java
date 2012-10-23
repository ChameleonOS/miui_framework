// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.speech.tts;

import android.os.FileUtils;
import android.util.Log;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

// Referenced classes of package android.speech.tts:
//            AbstractSynthesisCallback

class FileSynthesisCallback extends AbstractSynthesisCallback {

    FileSynthesisCallback(File file) {
        mStopped = false;
        mDone = false;
        mFileName = file;
    }

    private void cleanUp() {
        closeFileAndWidenPermissions();
        if(mFile != null)
            mFileName.delete();
    }

    private void closeFileAndWidenPermissions() {
        try {
            if(mFile != null) {
                mFile.close();
                mFile = null;
            }
        }
        catch(IOException ioexception) {
            Log.e("FileSynthesisRequest", (new StringBuilder()).append("Failed to close ").append(mFileName).append(": ").append(ioexception).toString());
        }
        FileUtils.setPermissions(mFileName.getAbsolutePath(), 438, -1, -1);
_L1:
        return;
        SecurityException securityexception;
        securityexception;
        Log.e("FileSynthesisRequest", (new StringBuilder()).append("Security exception setting rw permissions on : ").append(mFileName).toString());
          goto _L1
    }

    private byte[] makeWavHeader(int i, int j, int k, int l) {
        int i1;
        int j1;
        short word0;
        short word1;
        byte abyte0[];
        ByteBuffer bytebuffer;
        byte abyte1[];
        byte abyte2[];
        byte abyte3[];
        byte abyte4[];
        if(j == 3)
            i1 = 1;
        else
            i1 = 2;
        j1 = k * (i * i1);
        word0 = (short)(i1 * k);
        word1 = (short)(i1 * 8);
        abyte0 = new byte[44];
        bytebuffer = ByteBuffer.wrap(abyte0);
        bytebuffer.order(ByteOrder.LITTLE_ENDIAN);
        abyte1 = new byte[4];
        abyte1[0] = 82;
        abyte1[1] = 73;
        abyte1[2] = 70;
        abyte1[3] = 70;
        bytebuffer.put(abyte1);
        bytebuffer.putInt(-8 + (l + 44));
        abyte2 = new byte[4];
        abyte2[0] = 87;
        abyte2[1] = 65;
        abyte2[2] = 86;
        abyte2[3] = 69;
        bytebuffer.put(abyte2);
        abyte3 = new byte[4];
        abyte3[0] = 102;
        abyte3[1] = 109;
        abyte3[2] = 116;
        abyte3[3] = 32;
        bytebuffer.put(abyte3);
        bytebuffer.putInt(16);
        bytebuffer.putShort((short)1);
        bytebuffer.putShort((short)k);
        bytebuffer.putInt(i);
        bytebuffer.putInt(j1);
        bytebuffer.putShort(word0);
        bytebuffer.putShort(word1);
        abyte4 = new byte[4];
        abyte4[0] = 100;
        abyte4[1] = 97;
        abyte4[2] = 116;
        abyte4[3] = 97;
        bytebuffer.put(abyte4);
        bytebuffer.putInt(l);
        return abyte0;
    }

    public int audioAvailable(byte abyte0[], int i, int j) {
        byte byte0 = -1;
        Object obj = mStateLock;
        obj;
        JVM INSTR monitorenter ;
        if(!mStopped) goto _L2; else goto _L1
_L2:
        if(mFile != null) goto _L4; else goto _L3
_L3:
        Log.e("FileSynthesisRequest", "File not open");
          goto _L1
        Exception exception;
        exception;
        throw exception;
_L4:
        mFile.write(abyte0, i, j);
        byte0 = 0;
        obj;
        JVM INSTR monitorexit ;
          goto _L1
        IOException ioexception;
        ioexception;
        Log.e("FileSynthesisRequest", (new StringBuilder()).append("Failed to write to ").append(mFileName).append(": ").append(ioexception).toString());
        cleanUp();
        obj;
        JVM INSTR monitorexit ;
_L1:
        return byte0;
    }

    public int done() {
        byte byte0 = -1;
        Object obj = mStateLock;
        obj;
        JVM INSTR monitorenter ;
        if(!mStopped) goto _L2; else goto _L1
_L2:
        if(mFile != null) goto _L4; else goto _L3
_L3:
        Log.e("FileSynthesisRequest", "File not open");
          goto _L1
        Exception exception;
        exception;
        throw exception;
_L4:
        mFile.seek(0L);
        int i = (int)(mFile.length() - 44L);
        mFile.write(makeWavHeader(mSampleRateInHz, mAudioFormat, mChannelCount, i));
        closeFileAndWidenPermissions();
        mDone = true;
        byte0 = 0;
        obj;
        JVM INSTR monitorexit ;
          goto _L1
        IOException ioexception;
        ioexception;
        Log.e("FileSynthesisRequest", (new StringBuilder()).append("Failed to write to ").append(mFileName).append(": ").append(ioexception).toString());
        cleanUp();
        obj;
        JVM INSTR monitorexit ;
_L1:
        return byte0;
    }

    public void error() {
        Object obj = mStateLock;
        obj;
        JVM INSTR monitorenter ;
        cleanUp();
        return;
    }

    public int getMaxBufferSize() {
        return 8192;
    }

    boolean isDone() {
        return mDone;
    }

    public int start(int i, int j, int k) {
        byte byte0 = -1;
        Object obj = mStateLock;
        obj;
        JVM INSTR monitorenter ;
        if(!mStopped) {
            if(mFile != null) {
                cleanUp();
                throw new IllegalArgumentException("FileSynthesisRequest.start() called twice");
            }
            break MISSING_BLOCK_LABEL_55;
        }
          goto _L1
        Exception exception;
        exception;
        throw exception;
        mSampleRateInHz = i;
        mAudioFormat = j;
        mChannelCount = k;
        mFile = new RandomAccessFile(mFileName, "rw");
        mFile.write(new byte[44]);
        byte0 = 0;
        obj;
        JVM INSTR monitorexit ;
          goto _L1
        IOException ioexception;
        ioexception;
        Log.e("FileSynthesisRequest", (new StringBuilder()).append("Failed to open ").append(mFileName).append(": ").append(ioexception).toString());
        cleanUp();
        obj;
        JVM INSTR monitorexit ;
_L1:
        return byte0;
    }

    void stop() {
        Object obj = mStateLock;
        obj;
        JVM INSTR monitorenter ;
        mStopped = true;
        cleanUp();
        return;
    }

    private static final boolean DBG = false;
    private static final int MAX_AUDIO_BUFFER_SIZE = 8192;
    private static final String TAG = "FileSynthesisRequest";
    private static final short WAV_FORMAT_PCM = 1;
    private static final int WAV_HEADER_LENGTH = 44;
    private int mAudioFormat;
    private int mChannelCount;
    private boolean mDone;
    private RandomAccessFile mFile;
    private final File mFileName;
    private int mSampleRateInHz;
    private final Object mStateLock = new Object();
    private boolean mStopped;
}
