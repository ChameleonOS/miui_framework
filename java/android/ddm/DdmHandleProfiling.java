// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.ddm;

import android.os.Debug;
import android.util.Log;
import java.nio.ByteBuffer;
import org.apache.harmony.dalvik.ddmc.*;

public class DdmHandleProfiling extends ChunkHandler {

    private DdmHandleProfiling() {
    }

    private Chunk handleMPRE(Chunk chunk) {
        Debug.stopMethodTracing();
        byte byte0 = 0;
_L2:
        byte abyte0[] = new byte[1];
        abyte0[0] = byte0;
        return new Chunk(CHUNK_MPRE, abyte0, 0, abyte0.length);
        RuntimeException runtimeexception;
        runtimeexception;
        Log.w("ddm-heap", (new StringBuilder()).append("Method profiling end failed: ").append(runtimeexception.getMessage()).toString());
        byte0 = 1;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private Chunk handleMPRQ(Chunk chunk) {
        int i;
        byte abyte0[];
        if(Debug.isMethodTracingActive())
            i = 1;
        else
            i = 0;
        abyte0 = new byte[1];
        abyte0[0] = (byte)i;
        return new Chunk(CHUNK_MPRQ, abyte0, 0, abyte0.length);
    }

    private Chunk handleMPRS(Chunk chunk) {
        int i;
        int j;
        String s;
        ByteBuffer bytebuffer = wrapChunk(chunk);
        i = bytebuffer.getInt();
        j = bytebuffer.getInt();
        s = getString(bytebuffer, bytebuffer.getInt());
        Debug.startMethodTracing(s, i, j);
        Chunk chunk1 = null;
_L2:
        return chunk1;
        RuntimeException runtimeexception;
        runtimeexception;
        chunk1 = createFailChunk(1, runtimeexception.getMessage());
        if(true) goto _L2; else goto _L1
_L1:
    }

    private Chunk handleMPSE(Chunk chunk) {
        Debug.stopMethodTracing();
        Chunk chunk1 = null;
_L2:
        return chunk1;
        RuntimeException runtimeexception;
        runtimeexception;
        Log.w("ddm-heap", (new StringBuilder()).append("Method prof stream end failed: ").append(runtimeexception.getMessage()).toString());
        chunk1 = createFailChunk(1, runtimeexception.getMessage());
        if(true) goto _L2; else goto _L1
_L1:
    }

    private Chunk handleMPSS(Chunk chunk) {
        int i;
        int j;
        ByteBuffer bytebuffer = wrapChunk(chunk);
        i = bytebuffer.getInt();
        j = bytebuffer.getInt();
        Debug.startMethodTracingDdms(i, j);
        Chunk chunk1 = null;
_L2:
        return chunk1;
        RuntimeException runtimeexception;
        runtimeexception;
        chunk1 = createFailChunk(1, runtimeexception.getMessage());
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static void register() {
        DdmServer.registerHandler(CHUNK_MPRS, mInstance);
        DdmServer.registerHandler(CHUNK_MPRE, mInstance);
        DdmServer.registerHandler(CHUNK_MPSS, mInstance);
        DdmServer.registerHandler(CHUNK_MPSE, mInstance);
        DdmServer.registerHandler(CHUNK_MPRQ, mInstance);
    }

    public void connected() {
    }

    public void disconnected() {
    }

    public Chunk handleChunk(Chunk chunk) {
        int i = chunk.type;
        Chunk chunk1;
        if(i == CHUNK_MPRS)
            chunk1 = handleMPRS(chunk);
        else
        if(i == CHUNK_MPRE)
            chunk1 = handleMPRE(chunk);
        else
        if(i == CHUNK_MPSS)
            chunk1 = handleMPSS(chunk);
        else
        if(i == CHUNK_MPSE)
            chunk1 = handleMPSE(chunk);
        else
        if(i == CHUNK_MPRQ)
            chunk1 = handleMPRQ(chunk);
        else
            throw new RuntimeException((new StringBuilder()).append("Unknown packet ").append(ChunkHandler.name(i)).toString());
        return chunk1;
    }

    public static final int CHUNK_MPRE = type("MPRE");
    public static final int CHUNK_MPRQ = type("MPRQ");
    public static final int CHUNK_MPRS = type("MPRS");
    public static final int CHUNK_MPSE = type("MPSE");
    public static final int CHUNK_MPSS = type("MPSS");
    private static DdmHandleProfiling mInstance = new DdmHandleProfiling();

}
