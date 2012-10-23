// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.ddm;

import java.nio.ByteBuffer;
import org.apache.harmony.dalvik.ddmc.*;

public class DdmHandleAppName extends ChunkHandler {

    private DdmHandleAppName() {
    }

    public static String getAppName() {
        return mAppName;
    }

    public static void register() {
    }

    private static void sendAPNM(String s) {
        ByteBuffer bytebuffer = ByteBuffer.allocate(4 + 2 * s.length());
        bytebuffer.order(ChunkHandler.CHUNK_ORDER);
        bytebuffer.putInt(s.length());
        putString(bytebuffer, s);
        DdmServer.sendChunk(new Chunk(CHUNK_APNM, bytebuffer));
    }

    public static void setAppName(String s) {
        if(s != null && s.length() != 0) {
            mAppName = s;
            sendAPNM(s);
        }
    }

    public void connected() {
    }

    public void disconnected() {
    }

    public Chunk handleChunk(Chunk chunk) {
        return null;
    }

    public static final int CHUNK_APNM = type("APNM");
    private static volatile String mAppName = "";
    private static DdmHandleAppName mInstance = new DdmHandleAppName();

}
