// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.media;

import java.util.UUID;

// Referenced classes of package android.media:
//            MediaCryptoException

public final class MediaCrypto {

    public MediaCrypto(UUID uuid, byte abyte0[]) throws MediaCryptoException {
        native_setup(getByteArrayFromUUID(uuid), abyte0);
    }

    private static final byte[] getByteArrayFromUUID(UUID uuid) {
        long l = uuid.getMostSignificantBits();
        long l1 = uuid.getLeastSignificantBits();
        byte abyte0[] = new byte[16];
        for(int i = 0; i < 8; i++) {
            abyte0[i] = (byte)(int)(l >>> 8 * (7 - i));
            abyte0[i + 8] = (byte)(int)(l1 >>> 8 * (7 - i));
        }

        return abyte0;
    }

    public static final boolean isCryptoSchemeSupported(UUID uuid) {
        return isCryptoSchemeSupportedNative(getByteArrayFromUUID(uuid));
    }

    private static final native boolean isCryptoSchemeSupportedNative(byte abyte0[]);

    private final native void native_finalize();

    private static final native void native_init();

    private final native void native_setup(byte abyte0[], byte abyte1[]) throws MediaCryptoException;

    protected void finalize() {
        native_finalize();
    }

    public final native void release();

    public final native boolean requiresSecureDecoderComponent(String s);

    private int mNativeContext;

    static  {
        System.loadLibrary("media_jni");
        native_init();
    }
}
