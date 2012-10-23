// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app.backup;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package android.app.backup:
//            BackupDataInput

public class BackupDataInputStream extends InputStream {

    BackupDataInputStream(BackupDataInput backupdatainput) {
        mData = backupdatainput;
    }

    public String getKey() {
        return key;
    }

    public int read() throws IOException {
        byte abyte0[] = mOneByte;
        if(mOneByte == null) {
            abyte0 = new byte[1];
            mOneByte = abyte0;
        }
        mData.readEntityData(abyte0, 0, 1);
        return abyte0[0];
    }

    public int read(byte abyte0[]) throws IOException {
        return mData.readEntityData(abyte0, 0, abyte0.length);
    }

    public int read(byte abyte0[], int i, int j) throws IOException {
        return mData.readEntityData(abyte0, i, j);
    }

    public int size() {
        return dataSize;
    }

    int dataSize;
    String key;
    BackupDataInput mData;
    byte mOneByte[];
}
