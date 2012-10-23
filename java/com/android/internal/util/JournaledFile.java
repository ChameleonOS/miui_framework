// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.util;

import java.io.File;
import java.io.IOException;

public class JournaledFile {

    public JournaledFile(File file, File file1) {
        mReal = file;
        mTemp = file1;
    }

    public File chooseForRead() {
        File file;
        if(mReal.exists()) {
            file = mReal;
            if(mTemp.exists())
                mTemp.delete();
        } else
        if(mTemp.exists()) {
            file = mTemp;
            mTemp.renameTo(mReal);
        } else {
            file = mReal;
        }
        return file;
    }

    public File chooseForWrite() {
        if(mWriting)
            throw new IllegalStateException("uncommitted write already in progress");
        if(!mReal.exists())
            try {
                mReal.createNewFile();
            }
            catch(IOException ioexception) { }
        if(mTemp.exists())
            mTemp.delete();
        mWriting = true;
        return mTemp;
    }

    public void commit() {
        if(!mWriting) {
            throw new IllegalStateException("no file to commit");
        } else {
            mWriting = false;
            mTemp.renameTo(mReal);
            return;
        }
    }

    public void rollback() {
        if(!mWriting) {
            throw new IllegalStateException("no file to roll back");
        } else {
            mWriting = false;
            mTemp.delete();
            return;
        }
    }

    File mReal;
    File mTemp;
    boolean mWriting;
}
