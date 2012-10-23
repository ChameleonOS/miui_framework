// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.os;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.*;
import java.util.Formatter;
import java.util.Locale;

abstract class LoggingPrintStream extends PrintStream {

    protected LoggingPrintStream() {
        super(new OutputStream() {

            public void write(int i) throws IOException {
                throw new AssertionError();
            }

        });
        formatter = new Formatter(builder, null);
    }

    private void flush(boolean flag) {
        int i = builder.length();
        int j = 0;
        do {
            if(j >= i)
                break;
            int k = builder.indexOf("\n", j);
            if(k == -1)
                break;
            log(builder.substring(j, k));
            j = k + 1;
        } while(true);
        if(flag) {
            if(j < i)
                log(builder.substring(j));
            builder.setLength(0);
        } else {
            builder.delete(0, j);
        }
    }

    /**
     * @deprecated Method append is deprecated
     */

    public PrintStream append(char c) {
        this;
        JVM INSTR monitorenter ;
        print(c);
        this;
        JVM INSTR monitorexit ;
        return this;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method append is deprecated
     */

    public PrintStream append(CharSequence charsequence) {
        this;
        JVM INSTR monitorenter ;
        builder.append(charsequence);
        flush(false);
        this;
        JVM INSTR monitorexit ;
        return this;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method append is deprecated
     */

    public PrintStream append(CharSequence charsequence, int i, int j) {
        this;
        JVM INSTR monitorenter ;
        builder.append(charsequence, i, j);
        flush(false);
        this;
        JVM INSTR monitorexit ;
        return this;
        Exception exception;
        exception;
        throw exception;
    }

    public volatile Appendable append(char c) throws IOException {
        return append(c);
    }

    public volatile Appendable append(CharSequence charsequence) throws IOException {
        return append(charsequence);
    }

    public volatile Appendable append(CharSequence charsequence, int i, int j) throws IOException {
        return append(charsequence, i, j);
    }

    public boolean checkError() {
        return false;
    }

    public void close() {
    }

    /**
     * @deprecated Method flush is deprecated
     */

    public void flush() {
        this;
        JVM INSTR monitorenter ;
        flush(true);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public transient PrintStream format(String s, Object aobj[]) {
        return format(Locale.getDefault(), s, aobj);
    }

    /**
     * @deprecated Method format is deprecated
     */

    public transient PrintStream format(Locale locale, String s, Object aobj[]) {
        this;
        JVM INSTR monitorenter ;
        if(s != null)
            break MISSING_BLOCK_LABEL_23;
        throw new NullPointerException("format");
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        formatter.format(locale, s, aobj);
        flush(false);
        this;
        JVM INSTR monitorexit ;
        return this;
    }

    protected abstract void log(String s);

    /**
     * @deprecated Method print is deprecated
     */

    public void print(char c) {
        this;
        JVM INSTR monitorenter ;
        builder.append(c);
        if(c == '\n')
            flush(false);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method print is deprecated
     */

    public void print(double d) {
        this;
        JVM INSTR monitorenter ;
        builder.append(d);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method print is deprecated
     */

    public void print(float f) {
        this;
        JVM INSTR monitorenter ;
        builder.append(f);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method print is deprecated
     */

    public void print(int i) {
        this;
        JVM INSTR monitorenter ;
        builder.append(i);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method print is deprecated
     */

    public void print(long l) {
        this;
        JVM INSTR monitorenter ;
        builder.append(l);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method print is deprecated
     */

    public void print(Object obj) {
        this;
        JVM INSTR monitorenter ;
        builder.append(obj);
        flush(false);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method print is deprecated
     */

    public void print(String s) {
        this;
        JVM INSTR monitorenter ;
        builder.append(s);
        flush(false);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method print is deprecated
     */

    public void print(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        builder.append(flag);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method print is deprecated
     */

    public void print(char ac[]) {
        this;
        JVM INSTR monitorenter ;
        builder.append(ac);
        flush(false);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public transient PrintStream printf(String s, Object aobj[]) {
        return format(s, aobj);
    }

    public transient PrintStream printf(Locale locale, String s, Object aobj[]) {
        return format(locale, s, aobj);
    }

    /**
     * @deprecated Method println is deprecated
     */

    public void println() {
        this;
        JVM INSTR monitorenter ;
        flush(true);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method println is deprecated
     */

    public void println(char c) {
        this;
        JVM INSTR monitorenter ;
        builder.append(c);
        flush(true);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method println is deprecated
     */

    public void println(double d) {
        this;
        JVM INSTR monitorenter ;
        builder.append(d);
        flush(true);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method println is deprecated
     */

    public void println(float f) {
        this;
        JVM INSTR monitorenter ;
        builder.append(f);
        flush(true);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method println is deprecated
     */

    public void println(int i) {
        this;
        JVM INSTR monitorenter ;
        builder.append(i);
        flush(true);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method println is deprecated
     */

    public void println(long l) {
        this;
        JVM INSTR monitorenter ;
        builder.append(l);
        flush(true);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method println is deprecated
     */

    public void println(Object obj) {
        this;
        JVM INSTR monitorenter ;
        builder.append(obj);
        flush(true);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method println is deprecated
     */

    public void println(String s) {
        this;
        JVM INSTR monitorenter ;
        if(builder.length() != 0) goto _L2; else goto _L1
_L1:
        int i = s.length();
        int j = 0;
        do {
            if(j >= i)
                break;
            int k = s.indexOf('\n', j);
            if(k == -1)
                break;
            log(s.substring(j, k));
            j = k + 1;
        } while(true);
        if(j < i)
            log(s.substring(j));
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        builder.append(s);
        flush(true);
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method println is deprecated
     */

    public void println(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        builder.append(flag);
        flush(true);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method println is deprecated
     */

    public void println(char ac[]) {
        this;
        JVM INSTR monitorenter ;
        builder.append(ac);
        flush(true);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void setError() {
    }

    public void write(int i) {
        byte abyte0[] = new byte[1];
        abyte0[0] = (byte)i;
        write(abyte0, 0, 1);
    }

    public void write(byte abyte0[]) {
        write(abyte0, 0, abyte0.length);
    }

    /**
     * @deprecated Method write is deprecated
     */

    public void write(byte abyte0[], int i, int j) {
        this;
        JVM INSTR monitorenter ;
        if(decoder == null) {
            encodedBytes = ByteBuffer.allocate(80);
            decodedChars = CharBuffer.allocate(80);
            decoder = Charset.defaultCharset().newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
        }
        break MISSING_BLOCK_LABEL_179;
_L2:
        int k;
        while(i < k)  {
            int l = Math.min(encodedBytes.remaining(), k - i);
            encodedBytes.put(abyte0, i, l);
            i += l;
            encodedBytes.flip();
            CoderResult coderresult;
            do {
                coderresult = decoder.decode(encodedBytes, decodedChars, false);
                decodedChars.flip();
                builder.append(decodedChars);
                decodedChars.clear();
            } while(coderresult.isOverflow());
            encodedBytes.compact();
        }
          goto _L1
        Exception exception;
        exception;
        throw exception;
_L1:
        flush(false);
        this;
        JVM INSTR monitorexit ;
        return;
        k = i + j;
          goto _L2
    }

    private final StringBuilder builder = new StringBuilder();
    private CharBuffer decodedChars;
    private CharsetDecoder decoder;
    private ByteBuffer encodedBytes;
    private final Formatter formatter;
}
