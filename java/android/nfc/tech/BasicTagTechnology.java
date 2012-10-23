// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.nfc.tech;

import android.nfc.*;
import android.os.RemoteException;
import android.util.Log;
import java.io.IOException;

// Referenced classes of package android.nfc.tech:
//            TagTechnology

abstract class BasicTagTechnology
    implements TagTechnology {

    BasicTagTechnology(Tag tag, int i) throws RemoteException {
        mTag = tag;
        mSelectedTechnology = i;
    }

    void checkConnected() {
        if(mTag.getConnectedTechnology() != mSelectedTechnology || mTag.getConnectedTechnology() == -1)
            throw new IllegalStateException("Call connect() first!");
        else
            return;
    }

    public void close() throws IOException {
        mTag.getTagService().resetTimeouts();
        mTag.getTagService().reconnect(mTag.getServiceHandle());
        mIsConnected = false;
        mTag.setTechnologyDisconnected();
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.e("NFC", "NFC service dead", remoteexception);
        mIsConnected = false;
        mTag.setTechnologyDisconnected();
        if(true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        mIsConnected = false;
        mTag.setTechnologyDisconnected();
        throw exception;
    }

    public void connect() throws IOException {
        try {
            int i = mTag.getTagService().connect(mTag.getServiceHandle(), mSelectedTechnology);
            if(i == 0) {
                mTag.setConnectedTechnology(mSelectedTechnology);
                mIsConnected = true;
                return;
            }
            if(i == -21)
                throw new UnsupportedOperationException("Connecting to this technology is not supported by the NFC adapter.");
        }
        catch(RemoteException remoteexception) {
            Log.e("NFC", "NFC service dead", remoteexception);
            throw new IOException("NFC service died");
        }
        throw new IOException();
    }

    int getMaxTransceiveLengthInternal() {
        int j = mTag.getTagService().getMaxTransceiveLength(mSelectedTechnology);
        int i = j;
_L2:
        return i;
        RemoteException remoteexception;
        remoteexception;
        Log.e("NFC", "NFC service dead", remoteexception);
        i = 0;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public Tag getTag() {
        return mTag;
    }

    public boolean isConnected() {
        boolean flag = false;
        if(mIsConnected) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        boolean flag1 = mTag.getTagService().isPresent(mTag.getServiceHandle());
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        RemoteException remoteexception;
        remoteexception;
        Log.e("NFC", "NFC service dead", remoteexception);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public void reconnect() throws IOException {
        if(!mIsConnected)
            throw new IllegalStateException("Technology not connected yet");
        try {
            if(mTag.getTagService().reconnect(mTag.getServiceHandle()) != 0) {
                mIsConnected = false;
                mTag.setTechnologyDisconnected();
                throw new IOException();
            }
        }
        catch(RemoteException remoteexception) {
            mIsConnected = false;
            mTag.setTechnologyDisconnected();
            Log.e("NFC", "NFC service dead", remoteexception);
            throw new IOException("NFC service died");
        }
    }

    byte[] transceive(byte abyte0[], boolean flag) throws IOException {
        TransceiveResult transceiveresult;
        checkConnected();
        try {
            transceiveresult = mTag.getTagService().transceive(mTag.getServiceHandle(), abyte0, flag);
            if(transceiveresult == null)
                throw new IOException("transceive failed");
        }
        catch(RemoteException remoteexception) {
            Log.e("NFC", "NFC service dead", remoteexception);
            throw new IOException("NFC service died");
        }
        byte abyte1[] = transceiveresult.getResponseOrThrow();
        return abyte1;
    }

    private static final String TAG = "NFC";
    boolean mIsConnected;
    int mSelectedTechnology;
    final Tag mTag;
}
