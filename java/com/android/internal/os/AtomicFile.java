// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.os;

import android.os.FileUtils;
import android.util.Log;
import java.io.*;

public class AtomicFile {

    public AtomicFile(File file) {
        mBaseName = file;
        mBackupName = new File((new StringBuilder()).append(file.getPath()).append(".bak").toString());
    }

    public void failWrite(FileOutputStream fileoutputstream) {
        if(fileoutputstream == null)
            break MISSING_BLOCK_LABEL_33;
        FileUtils.sync(fileoutputstream);
        fileoutputstream.close();
        mBaseName.delete();
        mBackupName.renameTo(mBaseName);
_L1:
        return;
        IOException ioexception;
        ioexception;
        Log.w("AtomicFile", "failWrite: Got exception:", ioexception);
          goto _L1
    }

    public void finishWrite(FileOutputStream fileoutputstream) {
        if(fileoutputstream == null)
            break MISSING_BLOCK_LABEL_21;
        FileUtils.sync(fileoutputstream);
        fileoutputstream.close();
        mBackupName.delete();
_L1:
        return;
        IOException ioexception;
        ioexception;
        Log.w("AtomicFile", "finishWrite: Got exception:", ioexception);
          goto _L1
    }

    public File getBaseFile() {
        return mBaseName;
    }

    public FileOutputStream openAppend() throws IOException {
        FileOutputStream fileoutputstream;
        try {
            fileoutputstream = new FileOutputStream(mBaseName, true);
        }
        catch(FileNotFoundException filenotfoundexception) {
            throw new IOException((new StringBuilder()).append("Couldn't append ").append(mBaseName).toString());
        }
        return fileoutputstream;
    }

    public FileInputStream openRead() throws FileNotFoundException {
        if(mBackupName.exists()) {
            mBaseName.delete();
            mBackupName.renameTo(mBaseName);
        }
        return new FileInputStream(mBaseName);
    }

    public byte[] readFully() throws IOException {
        FileInputStream fileinputstream;
        int i;
        fileinputstream = openRead();
        i = 0;
        byte abyte0[] = new byte[fileinputstream.available()];
_L2:
        int j = fileinputstream.read(abyte0, i, abyte0.length - i);
        if(j <= 0) {
            fileinputstream.close();
            return abyte0;
        }
        i += j;
        int k = fileinputstream.available();
        if(k <= abyte0.length - i) goto _L2; else goto _L1
_L1:
        byte abyte1[];
        abyte1 = new byte[i + k];
        System.arraycopy(abyte0, 0, abyte1, 0, i);
        abyte0 = abyte1;
          goto _L2
        Exception exception;
        exception;
        fileinputstream.close();
        throw exception;
    }

    public FileOutputStream startWrite() throws IOException {
        FileOutputStream fileoutputstream;
        if(mBaseName.exists())
            if(!mBackupName.exists()) {
                if(!mBaseName.renameTo(mBackupName))
                    Log.w("AtomicFile", (new StringBuilder()).append("Couldn't rename file ").append(mBaseName).append(" to backup file ").append(mBackupName).toString());
            } else {
                mBaseName.delete();
            }
        try {
            fileoutputstream = new FileOutputStream(mBaseName);
        }
        catch(FileNotFoundException filenotfoundexception) {
            File file = mBaseName.getParentFile();
            if(!file.mkdir())
                throw new IOException((new StringBuilder()).append("Couldn't create directory ").append(mBaseName).toString());
            FileUtils.setPermissions(file.getPath(), 505, -1, -1);
            try {
                fileoutputstream = new FileOutputStream(mBaseName);
            }
            catch(FileNotFoundException filenotfoundexception1) {
                throw new IOException((new StringBuilder()).append("Couldn't create ").append(mBaseName).toString());
            }
        }
        return fileoutputstream;
    }

    public void truncate() throws IOException {
        FileOutputStream fileoutputstream = new FileOutputStream(mBaseName);
        FileUtils.sync(fileoutputstream);
        fileoutputstream.close();
_L2:
        return;
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        throw new IOException((new StringBuilder()).append("Couldn't append ").append(mBaseName).toString());
        IOException ioexception;
        ioexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private final File mBackupName;
    private final File mBaseName;
}
