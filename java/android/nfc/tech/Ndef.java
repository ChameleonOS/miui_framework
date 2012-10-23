// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.nfc.tech;

import android.nfc.*;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import java.io.IOException;

// Referenced classes of package android.nfc.tech:
//            BasicTagTechnology

public final class Ndef extends BasicTagTechnology {

    public Ndef(Tag tag) throws RemoteException {
        super(tag, 6);
        Bundle bundle = tag.getTechExtras(6);
        if(bundle != null) {
            mMaxNdefSize = bundle.getInt("ndefmaxlength");
            mCardState = bundle.getInt("ndefcardstate");
            mNdefMsg = (NdefMessage)bundle.getParcelable("ndefmsg");
            mNdefType = bundle.getInt("ndeftype");
            return;
        } else {
            throw new NullPointerException("NDEF tech extras are null.");
        }
    }

    public static Ndef get(Tag tag) {
        Ndef ndef = null;
        if(tag.hasTech(6)) goto _L2; else goto _L1
_L1:
        return ndef;
_L2:
        Ndef ndef1 = new Ndef(tag);
        ndef = ndef1;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean canMakeReadOnly() {
        boolean flag;
        INfcTag infctag;
        flag = false;
        infctag = super.mTag.getTagService();
        if(infctag != null) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        boolean flag1 = infctag.canMakeReadOnly(mNdefType);
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        Log.e("NFC", "NFC service dead", remoteexception);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public volatile void close() throws IOException {
        super.close();
    }

    public volatile void connect() throws IOException {
        super.connect();
    }

    public NdefMessage getCachedNdefMessage() {
        return mNdefMsg;
    }

    public int getMaxSize() {
        return mMaxNdefSize;
    }

    public NdefMessage getNdefMessage() throws IOException, FormatException {
        checkConnected();
        INfcTag infctag;
        infctag = super.mTag.getTagService();
        if(infctag == null)
            throw new IOException("Mock tags don't support this operation.");
          goto _L1
        RemoteException remoteexception;
        remoteexception;
        NdefMessage ndefmessage;
        Log.e("NFC", "NFC service dead", remoteexception);
        ndefmessage = null;
_L3:
        return ndefmessage;
_L1:
        int i = super.mTag.getServiceHandle();
        if(infctag.isNdef(i)) {
            ndefmessage = infctag.ndefRead(i);
            if(ndefmessage == null && !infctag.isPresent(i))
                throw new TagLostException();
            continue; /* Loop/switch isn't completed */
        }
        ndefmessage = null;
        if(true) goto _L3; else goto _L2
_L2:
    }

    public volatile Tag getTag() {
        return super.getTag();
    }

    public String getType() {
        mNdefType;
        JVM INSTR lookupswitch 6: default 64
    //                   1: 69
    //                   2: 75
    //                   3: 81
    //                   4: 87
    //                   101: 93
    //                   102: 99;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        String s = "android.ndef.unknown";
_L9:
        return s;
_L2:
        s = "org.nfcforum.ndef.type1";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "org.nfcforum.ndef.type2";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "org.nfcforum.ndef.type3";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "org.nfcforum.ndef.type4";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "com.nxp.ndef.mifareclassic";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "com.nxp.ndef.icodesli";
        if(true) goto _L9; else goto _L8
_L8:
    }

    public volatile boolean isConnected() {
        return super.isConnected();
    }

    public boolean isWritable() {
        boolean flag;
        if(mCardState == 2)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean makeReadOnly() throws IOException {
        boolean flag;
        flag = false;
        checkConnected();
        INfcTag infctag;
        infctag = super.mTag.getTagService();
        if(infctag == null)
            break MISSING_BLOCK_LABEL_132;
        if(!infctag.isNdef(super.mTag.getServiceHandle())) goto _L2; else goto _L1
_L1:
        infctag.ndefMakeReadOnly(super.mTag.getServiceHandle());
        JVM INSTR lookupswitch 3: default 88
    //                   -8: 132
    //                   -1: 114
    //                   0: 109;
           goto _L3 _L4 _L5 _L6
_L4:
        break MISSING_BLOCK_LABEL_132;
_L3:
        throw new IOException();
        RemoteException remoteexception;
        remoteexception;
        Log.e("NFC", "NFC service dead", remoteexception);
        break MISSING_BLOCK_LABEL_132;
_L6:
        flag = true;
        break MISSING_BLOCK_LABEL_132;
_L5:
        throw new IOException();
_L2:
        throw new IOException("Tag is not ndef");
        return flag;
    }

    public volatile void reconnect() throws IOException {
        super.reconnect();
    }

    public void writeNdefMessage(NdefMessage ndefmessage) throws IOException, FormatException {
        checkConnected();
        INfcTag infctag;
        infctag = super.mTag.getTagService();
        if(infctag == null)
            throw new IOException("Mock tags don't support this operation.");
          goto _L1
        RemoteException remoteexception;
        remoteexception;
        Log.e("NFC", "NFC service dead", remoteexception);
_L7:
        return;
_L1:
        int i = super.mTag.getServiceHandle();
        if(!infctag.isNdef(i)) goto _L3; else goto _L2
_L2:
        infctag.ndefWrite(i, ndefmessage);
        JVM INSTR lookupswitch 3: default 104
    //                   -8: 120
    //                   -1: 112
    //                   0: 38;
           goto _L4 _L5 _L6 _L7
_L4:
        throw new IOException();
_L6:
        throw new IOException();
_L5:
        throw new FormatException();
_L3:
        throw new IOException("Tag is not ndef");
    }

    public static final String EXTRA_NDEF_CARDSTATE = "ndefcardstate";
    public static final String EXTRA_NDEF_MAXLENGTH = "ndefmaxlength";
    public static final String EXTRA_NDEF_MSG = "ndefmsg";
    public static final String EXTRA_NDEF_TYPE = "ndeftype";
    public static final String ICODE_SLI = "com.nxp.ndef.icodesli";
    public static final String MIFARE_CLASSIC = "com.nxp.ndef.mifareclassic";
    public static final int NDEF_MODE_READ_ONLY = 1;
    public static final int NDEF_MODE_READ_WRITE = 2;
    public static final int NDEF_MODE_UNKNOWN = 3;
    public static final String NFC_FORUM_TYPE_1 = "org.nfcforum.ndef.type1";
    public static final String NFC_FORUM_TYPE_2 = "org.nfcforum.ndef.type2";
    public static final String NFC_FORUM_TYPE_3 = "org.nfcforum.ndef.type3";
    public static final String NFC_FORUM_TYPE_4 = "org.nfcforum.ndef.type4";
    private static final String TAG = "NFC";
    public static final int TYPE_1 = 1;
    public static final int TYPE_2 = 2;
    public static final int TYPE_3 = 3;
    public static final int TYPE_4 = 4;
    public static final int TYPE_ICODE_SLI = 102;
    public static final int TYPE_MIFARE_CLASSIC = 101;
    public static final int TYPE_OTHER = -1;
    public static final String UNKNOWN = "android.ndef.unknown";
    private final int mCardState;
    private final int mMaxNdefSize;
    private final NdefMessage mNdefMsg;
    private final int mNdefType;
}
