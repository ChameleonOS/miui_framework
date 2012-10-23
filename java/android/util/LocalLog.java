// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.util;

import android.text.format.Time;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;

public final class LocalLog {

    public LocalLog(int i) {
        mLog = new LinkedList();
        mMaxLines = i;
        mNow = new Time();
    }

    /**
     * @deprecated Method dump is deprecated
     */

    public void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]) {
        this;
        JVM INSTR monitorenter ;
        for(java.util.ListIterator listiterator = mLog.listIterator(0); listiterator.hasNext(); printwriter.println((String)listiterator.next()));
        break MISSING_BLOCK_LABEL_46;
        Exception exception;
        exception;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    /**
     * @deprecated Method log is deprecated
     */

    public void log(String s) {
        this;
        JVM INSTR monitorenter ;
        if(mMaxLines > 0) {
            mNow.setToNow();
            mLog.add((new StringBuilder()).append(mNow.format("%H:%M:%S")).append(" - ").append(s).toString());
            for(; mLog.size() > mMaxLines; mLog.remove());
        }
        break MISSING_BLOCK_LABEL_85;
        Exception exception;
        exception;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    private LinkedList mLog;
    private int mMaxLines;
    private Time mNow;
}
