// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.ddm;

import java.nio.ByteBuffer;
import org.apache.harmony.dalvik.ddmc.*;

public class DdmHandleThread extends ChunkHandler {

    private DdmHandleThread() {
    }

    private Chunk createStackChunk(StackTraceElement astacktraceelement[], int i) {
        int j = 4 + (4 + (0 + 4));
        int k = astacktraceelement.length;
        for(int l = 0; l < k; l++) {
            StackTraceElement stacktraceelement1 = astacktraceelement[l];
            int k1 = 4 + (j + (4 + 2 * stacktraceelement1.getClassName().length()) + (4 + 2 * stacktraceelement1.getMethodName().length()));
            if(stacktraceelement1.getFileName() != null)
                k1 += 2 * stacktraceelement1.getFileName().length();
            j = k1 + 4;
        }

        ByteBuffer bytebuffer = ByteBuffer.allocate(j);
        bytebuffer.putInt(0);
        bytebuffer.putInt(i);
        bytebuffer.putInt(astacktraceelement.length);
        int i1 = astacktraceelement.length;
        int j1 = 0;
        while(j1 < i1)  {
            StackTraceElement stacktraceelement = astacktraceelement[j1];
            bytebuffer.putInt(stacktraceelement.getClassName().length());
            putString(bytebuffer, stacktraceelement.getClassName());
            bytebuffer.putInt(stacktraceelement.getMethodName().length());
            putString(bytebuffer, stacktraceelement.getMethodName());
            if(stacktraceelement.getFileName() != null) {
                bytebuffer.putInt(stacktraceelement.getFileName().length());
                putString(bytebuffer, stacktraceelement.getFileName());
            } else {
                bytebuffer.putInt(0);
            }
            bytebuffer.putInt(stacktraceelement.getLineNumber());
            j1++;
        }
        return new Chunk(CHUNK_STKL, bytebuffer);
    }

    private Chunk handleSTKL(Chunk chunk) {
        int i = wrapChunk(chunk).getInt();
        StackTraceElement astacktraceelement[] = DdmVmInternal.getStackTraceById(i);
        Chunk chunk1;
        if(astacktraceelement == null)
            chunk1 = createFailChunk(1, "Stack trace unavailable");
        else
            chunk1 = createStackChunk(astacktraceelement, i);
        return chunk1;
    }

    private Chunk handleTHEN(Chunk chunk) {
        boolean flag;
        if(wrapChunk(chunk).get() != 0)
            flag = true;
        else
            flag = false;
        DdmVmInternal.threadNotify(flag);
        return null;
    }

    private Chunk handleTHST(Chunk chunk) {
        wrapChunk(chunk);
        byte abyte0[] = DdmVmInternal.getThreadStats();
        Chunk chunk1;
        if(abyte0 != null)
            chunk1 = new Chunk(CHUNK_THST, abyte0, 0, abyte0.length);
        else
            chunk1 = createFailChunk(1, "Can't build THST chunk");
        return chunk1;
    }

    public static void register() {
        DdmServer.registerHandler(CHUNK_THEN, mInstance);
        DdmServer.registerHandler(CHUNK_THST, mInstance);
        DdmServer.registerHandler(CHUNK_STKL, mInstance);
    }

    public void connected() {
    }

    public void disconnected() {
    }

    public Chunk handleChunk(Chunk chunk) {
        int i = chunk.type;
        Chunk chunk1;
        if(i == CHUNK_THEN)
            chunk1 = handleTHEN(chunk);
        else
        if(i == CHUNK_THST)
            chunk1 = handleTHST(chunk);
        else
        if(i == CHUNK_STKL)
            chunk1 = handleSTKL(chunk);
        else
            throw new RuntimeException((new StringBuilder()).append("Unknown packet ").append(ChunkHandler.name(i)).toString());
        return chunk1;
    }

    public static final int CHUNK_STKL = type("STKL");
    public static final int CHUNK_THCR = type("THCR");
    public static final int CHUNK_THDE = type("THDE");
    public static final int CHUNK_THEN = type("THEN");
    public static final int CHUNK_THST = type("THST");
    private static DdmHandleThread mInstance = new DdmHandleThread();

}
