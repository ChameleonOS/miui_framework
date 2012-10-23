// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.ddm;

import android.os.Debug;
import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.apache.harmony.dalvik.ddmc.*;

public class DdmHandleHeap extends ChunkHandler {

    private DdmHandleHeap() {
    }

    private Chunk handleHPDS(Chunk chunk) {
        wrapChunk(chunk);
        String s = null;
        Chunk chunk1;
        try {
            Debug.dumpHprofDataDdms();
        }
        catch(UnsupportedOperationException unsupportedoperationexception) {
            s = "hprof dumps not supported in this VM";
        }
        catch(RuntimeException runtimeexception) {
            s = (new StringBuilder()).append("Exception: ").append(runtimeexception.getMessage()).toString();
        }
        if(s != null) {
            Log.w("ddm-heap", s);
            chunk1 = createFailChunk(1, s);
        } else {
            chunk1 = null;
        }
        return chunk1;
    }

    private Chunk handleHPDU(Chunk chunk) {
        String s;
        ByteBuffer bytebuffer = wrapChunk(chunk);
        s = getString(bytebuffer, bytebuffer.getInt());
        Debug.dumpHprofData(s);
        byte byte0 = 0;
_L2:
        byte abyte0[] = new byte[1];
        abyte0[0] = byte0;
        return new Chunk(CHUNK_HPDU, abyte0, 0, abyte0.length);
        UnsupportedOperationException unsupportedoperationexception;
        unsupportedoperationexception;
        Log.w("ddm-heap", "hprof dumps not supported in this VM");
        byte0 = -1;
        continue; /* Loop/switch isn't completed */
        IOException ioexception;
        ioexception;
        byte0 = -1;
        continue; /* Loop/switch isn't completed */
        RuntimeException runtimeexception;
        runtimeexception;
        byte0 = -1;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private Chunk handleHPGC(Chunk chunk) {
        System.gc();
        return null;
    }

    private Chunk handleHPIF(Chunk chunk) {
        Chunk chunk1;
        if(!DdmVmInternal.heapInfoNotify(wrapChunk(chunk).get()))
            chunk1 = createFailChunk(1, "Unsupported HPIF what");
        else
            chunk1 = null;
        return chunk1;
    }

    private Chunk handleHPSGNHSG(Chunk chunk, boolean flag) {
        ByteBuffer bytebuffer = wrapChunk(chunk);
        Chunk chunk1;
        if(!DdmVmInternal.heapSegmentNotify(bytebuffer.get(), bytebuffer.get(), flag))
            chunk1 = createFailChunk(1, "Unsupported HPSG what/when");
        else
            chunk1 = null;
        return chunk1;
    }

    private Chunk handleREAE(Chunk chunk) {
        boolean flag;
        if(wrapChunk(chunk).get() != 0)
            flag = true;
        else
            flag = false;
        DdmVmInternal.enableRecentAllocations(flag);
        return null;
    }

    private Chunk handleREAL(Chunk chunk) {
        byte abyte0[] = DdmVmInternal.getRecentAllocations();
        return new Chunk(CHUNK_REAL, abyte0, 0, abyte0.length);
    }

    private Chunk handleREAQ(Chunk chunk) {
        int i = 1;
        byte abyte0[] = new byte[i];
        if(!DdmVmInternal.getRecentAllocationStatus())
            i = 0;
        abyte0[0] = i;
        return new Chunk(CHUNK_REAQ, abyte0, 0, abyte0.length);
    }

    public static void register() {
        DdmServer.registerHandler(CHUNK_HPIF, mInstance);
        DdmServer.registerHandler(CHUNK_HPSG, mInstance);
        DdmServer.registerHandler(CHUNK_HPDU, mInstance);
        DdmServer.registerHandler(CHUNK_HPDS, mInstance);
        DdmServer.registerHandler(CHUNK_NHSG, mInstance);
        DdmServer.registerHandler(CHUNK_HPGC, mInstance);
        DdmServer.registerHandler(CHUNK_REAE, mInstance);
        DdmServer.registerHandler(CHUNK_REAQ, mInstance);
        DdmServer.registerHandler(CHUNK_REAL, mInstance);
    }

    public void connected() {
    }

    public void disconnected() {
    }

    public Chunk handleChunk(Chunk chunk) {
        int i = chunk.type;
        Chunk chunk1;
        if(i == CHUNK_HPIF)
            chunk1 = handleHPIF(chunk);
        else
        if(i == CHUNK_HPSG)
            chunk1 = handleHPSGNHSG(chunk, false);
        else
        if(i == CHUNK_HPDU)
            chunk1 = handleHPDU(chunk);
        else
        if(i == CHUNK_HPDS)
            chunk1 = handleHPDS(chunk);
        else
        if(i == CHUNK_NHSG)
            chunk1 = handleHPSGNHSG(chunk, true);
        else
        if(i == CHUNK_HPGC)
            chunk1 = handleHPGC(chunk);
        else
        if(i == CHUNK_REAE)
            chunk1 = handleREAE(chunk);
        else
        if(i == CHUNK_REAQ)
            chunk1 = handleREAQ(chunk);
        else
        if(i == CHUNK_REAL)
            chunk1 = handleREAL(chunk);
        else
            throw new RuntimeException((new StringBuilder()).append("Unknown packet ").append(ChunkHandler.name(i)).toString());
        return chunk1;
    }

    public static final int CHUNK_HPDS = type("HPDS");
    public static final int CHUNK_HPDU = type("HPDU");
    public static final int CHUNK_HPGC = type("HPGC");
    public static final int CHUNK_HPIF = type("HPIF");
    public static final int CHUNK_HPSG = type("HPSG");
    public static final int CHUNK_NHSG = type("NHSG");
    public static final int CHUNK_REAE = type("REAE");
    public static final int CHUNK_REAL = type("REAL");
    public static final int CHUNK_REAQ = type("REAQ");
    private static DdmHandleHeap mInstance = new DdmHandleHeap();

}
