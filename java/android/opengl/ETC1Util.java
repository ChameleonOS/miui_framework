// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.opengl;

import java.io.*;
import java.nio.*;

// Referenced classes of package android.opengl:
//            ETC1, GLES10

public class ETC1Util {
    public static class ETC1Texture {

        public ByteBuffer getData() {
            return mData;
        }

        public int getHeight() {
            return mHeight;
        }

        public int getWidth() {
            return mWidth;
        }

        private ByteBuffer mData;
        private int mHeight;
        private int mWidth;

        public ETC1Texture(int i, int j, ByteBuffer bytebuffer) {
            mWidth = i;
            mHeight = j;
            mData = bytebuffer;
        }
    }


    public ETC1Util() {
    }

    public static ETC1Texture compressTexture(Buffer buffer, int i, int j, int k, int l) {
        ByteBuffer bytebuffer = ByteBuffer.allocateDirect(ETC1.getEncodedDataSize(i, j)).order(ByteOrder.nativeOrder());
        ETC1.encodeImage(buffer, i, j, k, l, bytebuffer);
        return new ETC1Texture(i, j, bytebuffer);
    }

    public static ETC1Texture createTexture(InputStream inputstream) throws IOException {
        byte abyte0[] = new byte[4096];
        if(inputstream.read(abyte0, 0, 16) != 16)
            throw new IOException("Unable to read PKM file header.");
        ByteBuffer bytebuffer = ByteBuffer.allocateDirect(16).order(ByteOrder.nativeOrder());
        bytebuffer.put(abyte0, 0, 16).position(0);
        if(!ETC1.isValid(bytebuffer))
            throw new IOException("Not a PKM file.");
        int i = ETC1.getWidth(bytebuffer);
        int j = ETC1.getHeight(bytebuffer);
        int k = ETC1.getEncodedDataSize(i, j);
        ByteBuffer bytebuffer1 = ByteBuffer.allocateDirect(k).order(ByteOrder.nativeOrder());
        int i1;
        for(int l = 0; l < k; l += i1) {
            i1 = Math.min(abyte0.length, k - l);
            if(inputstream.read(abyte0, 0, i1) != i1)
                throw new IOException("Unable to read PKM file data.");
            bytebuffer1.put(abyte0, 0, i1);
        }

        bytebuffer1.position(0);
        return new ETC1Texture(i, j, bytebuffer1);
    }

    public static boolean isETC1Supported() {
        boolean flag = false;
        int ai[] = new int[20];
        GLES10.glGetIntegerv(34466, ai, 0);
        int i = ai[0];
        if(i > ai.length)
            ai = new int[i];
        GLES10.glGetIntegerv(34467, ai, 0);
        int j = 0;
        do {
label0:
            {
                if(j < i) {
                    if(ai[j] != 36196)
                        break label0;
                    flag = true;
                }
                return flag;
            }
            j++;
        } while(true);
    }

    public static void loadTexture(int i, int j, int k, int l, int i1, ETC1Texture etc1texture) {
        if(l != 6407)
            throw new IllegalArgumentException("fallbackFormat must be GL_RGB");
        if(i1 != 33635 && i1 != 5121)
            throw new IllegalArgumentException("Unsupported fallbackType");
        int j1 = etc1texture.getWidth();
        int k1 = etc1texture.getHeight();
        ByteBuffer bytebuffer = etc1texture.getData();
        if(isETC1Supported()) {
            GLES10.glCompressedTexImage2D(i, j, 36196, j1, k1, k, bytebuffer.remaining(), bytebuffer);
        } else {
            boolean flag;
            byte byte0;
            int l1;
            ByteBuffer bytebuffer1;
            if(i1 != 5121)
                flag = true;
            else
                flag = false;
            if(flag)
                byte0 = 2;
            else
                byte0 = 3;
            l1 = byte0 * j1;
            bytebuffer1 = ByteBuffer.allocateDirect(l1 * k1).order(ByteOrder.nativeOrder());
            ETC1.decodeImage(bytebuffer, bytebuffer1, j1, k1, byte0, l1);
            GLES10.glTexImage2D(i, j, l, j1, k1, k, l, i1, bytebuffer1);
        }
    }

    public static void loadTexture(int i, int j, int k, int l, int i1, InputStream inputstream) throws IOException {
        loadTexture(i, j, k, l, i1, createTexture(inputstream));
    }

    public static void writeTexture(ETC1Texture etc1texture, OutputStream outputstream) throws IOException {
        ByteBuffer bytebuffer;
        int i;
        bytebuffer = etc1texture.getData();
        i = bytebuffer.position();
        byte abyte0[];
        int l;
        int i1;
        int j = etc1texture.getWidth();
        int k = etc1texture.getHeight();
        ByteBuffer bytebuffer1 = ByteBuffer.allocateDirect(16).order(ByteOrder.nativeOrder());
        ETC1.formatHeader(bytebuffer1, j, k);
        abyte0 = new byte[4096];
        bytebuffer1.get(abyte0, 0, 16);
        outputstream.write(abyte0, 0, 16);
        l = ETC1.getEncodedDataSize(j, k);
        i1 = 0;
_L1:
        int j1;
        if(i1 >= l)
            break MISSING_BLOCK_LABEL_143;
        j1 = Math.min(abyte0.length, l - i1);
        bytebuffer.get(abyte0, 0, j1);
        outputstream.write(abyte0, 0, j1);
        i1 += j1;
          goto _L1
        Exception exception;
        exception;
        bytebuffer.position(i);
        throw exception;
        bytebuffer.position(i);
        return;
    }
}
