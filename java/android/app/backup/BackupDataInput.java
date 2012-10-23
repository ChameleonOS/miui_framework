// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app.backup;

import java.io.FileDescriptor;
import java.io.IOException;

public class BackupDataInput {
    private static class EntityHeader {

        int dataSize;
        String key;

        private EntityHeader() {
        }

    }


    public BackupDataInput(FileDescriptor filedescriptor) {
        mHeader = new EntityHeader();
        if(filedescriptor == null)
            throw new NullPointerException();
        mBackupReader = ctor(filedescriptor);
        if(mBackupReader == 0)
            throw new RuntimeException((new StringBuilder()).append("Native initialization failed with fd=").append(filedescriptor).toString());
        else
            return;
    }

    private static native int ctor(FileDescriptor filedescriptor);

    private static native void dtor(int i);

    private native int readEntityData_native(int i, byte abyte0[], int j, int k);

    private native int readNextHeader_native(int i, EntityHeader entityheader);

    private native int skipEntityData_native(int i);

    protected void finalize() throws Throwable {
        dtor(mBackupReader);
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public int getDataSize() {
        if(mHeaderReady)
            return mHeader.dataSize;
        else
            throw new IllegalStateException("Entity header not read");
    }

    public String getKey() {
        if(mHeaderReady)
            return mHeader.key;
        else
            throw new IllegalStateException("Entity header not read");
    }

    public int readEntityData(byte abyte0[], int i, int j) throws IOException {
        if(mHeaderReady) {
            int k = readEntityData_native(mBackupReader, abyte0, i, j);
            if(k >= 0)
                return k;
            else
                throw new IOException((new StringBuilder()).append("result=0x").append(Integer.toHexString(k)).toString());
        } else {
            throw new IllegalStateException("Entity header not read");
        }
    }

    public boolean readNextHeader() throws IOException {
        boolean flag = true;
        int i = readNextHeader_native(mBackupReader, mHeader);
        if(i == 0)
            mHeaderReady = flag;
        else
        if(i > 0) {
            mHeaderReady = false;
            flag = false;
        } else {
            mHeaderReady = false;
            throw new IOException((new StringBuilder()).append("failed: 0x").append(Integer.toHexString(i)).toString());
        }
        return flag;
    }

    public void skipEntityData() throws IOException {
        if(mHeaderReady) {
            skipEntityData_native(mBackupReader);
            return;
        } else {
            throw new IllegalStateException("Entity header not read");
        }
    }

    int mBackupReader;
    private EntityHeader mHeader;
    private boolean mHeaderReady;
}
