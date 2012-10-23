// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app.backup;

import java.io.FileDescriptor;
import java.io.IOException;

public class BackupDataOutput {

    public BackupDataOutput(FileDescriptor filedescriptor) {
        if(filedescriptor == null)
            throw new NullPointerException();
        mBackupWriter = ctor(filedescriptor);
        if(mBackupWriter == 0)
            throw new RuntimeException((new StringBuilder()).append("Native initialization failed with fd=").append(filedescriptor).toString());
        else
            return;
    }

    private static native int ctor(FileDescriptor filedescriptor);

    private static native void dtor(int i);

    private static native void setKeyPrefix_native(int i, String s);

    private static native int writeEntityData_native(int i, byte abyte0[], int j);

    private static native int writeEntityHeader_native(int i, String s, int j);

    protected void finalize() throws Throwable {
        dtor(mBackupWriter);
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public void setKeyPrefix(String s) {
        setKeyPrefix_native(mBackupWriter, s);
    }

    public int writeEntityData(byte abyte0[], int i) throws IOException {
        int j = writeEntityData_native(mBackupWriter, abyte0, i);
        if(j >= 0)
            return j;
        else
            throw new IOException((new StringBuilder()).append("result=0x").append(Integer.toHexString(j)).toString());
    }

    public int writeEntityHeader(String s, int i) throws IOException {
        int j = writeEntityHeader_native(mBackupWriter, s, i);
        if(j >= 0)
            return j;
        else
            throw new IOException((new StringBuilder()).append("result=0x").append(Integer.toHexString(j)).toString());
    }

    int mBackupWriter;
}
