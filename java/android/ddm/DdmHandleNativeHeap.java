// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.ddm;

import android.util.Log;
import org.apache.harmony.dalvik.ddmc.*;

public class DdmHandleNativeHeap extends ChunkHandler {

    private DdmHandleNativeHeap() {
    }

    private native byte[] getLeakInfo();

    private Chunk handleNHGT(Chunk chunk) {
        byte abyte0[] = getLeakInfo();
        Chunk chunk1;
        if(abyte0 != null) {
            Log.i("ddm-nativeheap", (new StringBuilder()).append("Sending ").append(abyte0.length).append(" bytes").toString());
            chunk1 = new Chunk(ChunkHandler.type("NHGT"), abyte0, 0, abyte0.length);
        } else {
            chunk1 = createFailChunk(1, "Something went wrong");
        }
        return chunk1;
    }

    public static void register() {
        DdmServer.registerHandler(CHUNK_NHGT, mInstance);
    }

    public void connected() {
    }

    public void disconnected() {
    }

    public Chunk handleChunk(Chunk chunk) {
        Log.i("ddm-nativeheap", (new StringBuilder()).append("Handling ").append(name(chunk.type)).append(" chunk").toString());
        int i = chunk.type;
        if(i == CHUNK_NHGT)
            return handleNHGT(chunk);
        else
            throw new RuntimeException((new StringBuilder()).append("Unknown packet ").append(ChunkHandler.name(i)).toString());
    }

    public static final int CHUNK_NHGT = type("NHGT");
    private static DdmHandleNativeHeap mInstance = new DdmHandleNativeHeap();

}
