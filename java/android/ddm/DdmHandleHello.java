// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.ddm;

import android.os.Debug;
import android.os.Process;
import java.nio.ByteBuffer;
import org.apache.harmony.dalvik.ddmc.*;

// Referenced classes of package android.ddm:
//            DdmHandleAppName

public class DdmHandleHello extends ChunkHandler {

    private DdmHandleHello() {
    }

    private Chunk handleFEAT(Chunk chunk) {
        String as[] = Debug.getVmFeatureList();
        int i = 4 + 4 * as.length;
        for(int j = -1 + as.length; j >= 0; j--)
            i += 2 * as[j].length();

        ByteBuffer bytebuffer = ByteBuffer.allocate(i);
        bytebuffer.order(ChunkHandler.CHUNK_ORDER);
        bytebuffer.putInt(as.length);
        for(int k = -1 + as.length; k >= 0; k--) {
            bytebuffer.putInt(as[k].length());
            putString(bytebuffer, as[k]);
        }

        return new Chunk(CHUNK_FEAT, bytebuffer);
    }

    private Chunk handleHELO(Chunk chunk) {
        wrapChunk(chunk).getInt();
        String s = System.getProperty("java.vm.name", "?");
        String s1 = System.getProperty("java.vm.version", "?");
        String s2 = (new StringBuilder()).append(s).append(" v").append(s1).toString();
        String s3 = DdmHandleAppName.getAppName();
        ByteBuffer bytebuffer = ByteBuffer.allocate(16 + 2 * s2.length() + 2 * s3.length());
        bytebuffer.order(ChunkHandler.CHUNK_ORDER);
        bytebuffer.putInt(1);
        bytebuffer.putInt(Process.myPid());
        bytebuffer.putInt(s2.length());
        bytebuffer.putInt(s3.length());
        putString(bytebuffer, s2);
        putString(bytebuffer, s3);
        Chunk chunk1 = new Chunk(CHUNK_HELO, bytebuffer);
        if(Debug.waitingForDebugger())
            sendWAIT(0);
        return chunk1;
    }

    public static void register() {
        DdmServer.registerHandler(CHUNK_HELO, mInstance);
        DdmServer.registerHandler(CHUNK_FEAT, mInstance);
    }

    public static void sendWAIT(int i) {
        byte abyte0[] = new byte[1];
        abyte0[0] = (byte)i;
        DdmServer.sendChunk(new Chunk(CHUNK_WAIT, abyte0, 0, 1));
    }

    public void connected() {
    }

    public void disconnected() {
    }

    public Chunk handleChunk(Chunk chunk) {
        int i = chunk.type;
        Chunk chunk1;
        if(i == CHUNK_HELO)
            chunk1 = handleHELO(chunk);
        else
        if(i == CHUNK_FEAT)
            chunk1 = handleFEAT(chunk);
        else
            throw new RuntimeException((new StringBuilder()).append("Unknown packet ").append(ChunkHandler.name(i)).toString());
        return chunk1;
    }

    public static final int CHUNK_FEAT = type("FEAT");
    public static final int CHUNK_HELO = type("HELO");
    public static final int CHUNK_WAIT = type("WAIT");
    private static DdmHandleHello mInstance = new DdmHandleHello();

}
