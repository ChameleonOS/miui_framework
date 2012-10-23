// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.nfc.tech;

import android.nfc.Tag;
import java.io.Closeable;
import java.io.IOException;

public interface TagTechnology
    extends Closeable {

    public abstract void close() throws IOException;

    public abstract void connect() throws IOException;

    public abstract Tag getTag();

    public abstract boolean isConnected();

    public abstract void reconnect() throws IOException;

    public static final int ISO_DEP = 3;
    public static final int MIFARE_CLASSIC = 8;
    public static final int MIFARE_ULTRALIGHT = 9;
    public static final int NDEF = 6;
    public static final int NDEF_FORMATABLE = 7;
    public static final int NFC_A = 1;
    public static final int NFC_B = 2;
    public static final int NFC_F = 4;
    public static final int NFC_V = 5;
}
