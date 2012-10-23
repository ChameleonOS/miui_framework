// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.util;

import java.io.PrintWriter;
import java.io.Writer;

public class IndentingPrintWriter extends PrintWriter {

    public IndentingPrintWriter(Writer writer, String s) {
        super(writer);
        mBuilder = new StringBuilder();
        mCurrent = new String();
        mEmptyLine = true;
        mIndent = s;
    }

    public void decreaseIndent() {
        mBuilder.delete(0, mIndent.length());
        mCurrent = mBuilder.toString();
    }

    public void increaseIndent() {
        mBuilder.append(mIndent);
        mCurrent = mBuilder.toString();
    }

    public void printPair(String s, Object obj) {
        print((new StringBuilder()).append(s).append("=").append(String.valueOf(obj)).append(" ").toString());
    }

    public void println() {
        super.println();
        mEmptyLine = true;
    }

    public void write(char ac[], int i, int j) {
        if(mEmptyLine) {
            mEmptyLine = false;
            super.print(mCurrent);
        }
        super.write(ac, i, j);
    }

    private StringBuilder mBuilder;
    private String mCurrent;
    private boolean mEmptyLine;
    private final String mIndent;
}
