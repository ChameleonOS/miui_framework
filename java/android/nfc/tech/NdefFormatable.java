// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.nfc.tech;

import android.nfc.*;
import android.os.RemoteException;
import android.util.Log;
import java.io.IOException;

// Referenced classes of package android.nfc.tech:
//            BasicTagTechnology, MifareClassic

public final class NdefFormatable extends BasicTagTechnology {

    public NdefFormatable(Tag tag) throws RemoteException {
        super(tag, 7);
    }

    public static NdefFormatable get(Tag tag) {
        NdefFormatable ndefformatable = null;
        if(tag.hasTech(7)) goto _L2; else goto _L1
_L1:
        return ndefformatable;
_L2:
        NdefFormatable ndefformatable1 = new NdefFormatable(tag);
        ndefformatable = ndefformatable1;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public volatile void close() throws IOException {
        super.close();
    }

    public volatile void connect() throws IOException {
        super.connect();
    }

    public void format(NdefMessage ndefmessage) throws IOException, FormatException {
        format(ndefmessage, false);
    }

    void format(NdefMessage ndefmessage, boolean flag) throws IOException, FormatException {
        checkConnected();
        int i;
        INfcTag infctag;
        i = super.mTag.getServiceHandle();
        infctag = super.mTag.getTagService();
        infctag.formatNdef(i, MifareClassic.KEY_DEFAULT);
        JVM INSTR lookupswitch 3: default 68
    //                   -8: 95
    //                   -1: 87
    //                   0: 103;
           goto _L1 _L2 _L3 _L4
_L1:
        throw new IOException();
        RemoteException remoteexception;
        remoteexception;
        Log.e("NFC", "NFC service dead", remoteexception);
_L6:
        return;
_L3:
        throw new IOException();
_L2:
        throw new FormatException();
_L4:
        if(!infctag.isNdef(i))
            throw new IOException();
        if(ndefmessage != null)
            switch(infctag.ndefWrite(i, ndefmessage)) {
            default:
                throw new IOException();

            case -1: 
                throw new IOException();

            case -8: 
                throw new FormatException();

            case 0: // '\0'
                break;
            }
        if(!flag) goto _L6; else goto _L5
_L5:
        infctag.ndefMakeReadOnly(i);
        JVM INSTR lookupswitch 3: default 244
    //                   -8: 260
    //                   -1: 252
    //                   0: 86;
           goto _L7 _L8 _L9 _L10
_L10:
        if(true) goto _L6; else goto _L11
_L11:
_L7:
        throw new IOException();
_L9:
        throw new IOException();
_L8:
        throw new IOException();
    }

    public void formatReadOnly(NdefMessage ndefmessage) throws IOException, FormatException {
        format(ndefmessage, true);
    }

    public volatile Tag getTag() {
        return super.getTag();
    }

    public volatile boolean isConnected() {
        return super.isConnected();
    }

    public volatile void reconnect() throws IOException {
        super.reconnect();
    }

    private static final String TAG = "NFC";
}
