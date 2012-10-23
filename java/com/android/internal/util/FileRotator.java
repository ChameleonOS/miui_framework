// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.util;

import android.os.FileUtils;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import libcore.io.IoUtils;
import libcore.io.Streams;

// Referenced classes of package com.android.internal.util:
//            Preconditions

public class FileRotator {
    private static class FileInfo {

        public String build() {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append(prefix).append('.').append(startMillis).append('-');
            if(endMillis != 0x7fffffffffffffffL)
                stringbuilder.append(endMillis);
            return stringbuilder.toString();
        }

        public boolean isActive() {
            boolean flag;
            if(endMillis == 0x7fffffffffffffffL)
                flag = true;
            else
                flag = false;
            return flag;
        }

        public boolean parse(String s) {
            boolean flag;
            int i;
            int j;
            flag = false;
            endMillis = -1L;
            startMillis = -1L;
            i = s.lastIndexOf('.');
            j = s.lastIndexOf('-');
            break MISSING_BLOCK_LABEL_31;
            while(true)  {
                do
                    return flag;
                while(i == -1 || j == -1 || !prefix.equals(s.substring(0, i)));
                int k = i + 1;
                try {
                    startMillis = Long.parseLong(s.substring(k, j));
                    if(s.length() - j == 1)
                        endMillis = 0x7fffffffffffffffL;
                    else
                        endMillis = Long.parseLong(s.substring(j + 1));
                }
                catch(NumberFormatException numberformatexception) {
                    continue;
                }
                flag = true;
            }
        }

        public long endMillis;
        public final String prefix;
        public long startMillis;

        public FileInfo(String s) {
            prefix = (String)Preconditions.checkNotNull(s);
        }
    }

    public static interface Rewriter
        extends Reader, Writer {

        public abstract void reset();

        public abstract boolean shouldWrite();
    }

    public static interface Writer {

        public abstract void write(OutputStream outputstream) throws IOException;
    }

    public static interface Reader {

        public abstract void read(InputStream inputstream) throws IOException;
    }


    public FileRotator(File file, String s, long l, long l1) {
        mBasePath = (File)Preconditions.checkNotNull(file);
        mPrefix = (String)Preconditions.checkNotNull(s);
        mRotateAgeMillis = l;
        mDeleteAgeMillis = l1;
        mBasePath.mkdirs();
        String as[] = mBasePath.list();
        int i = as.length;
        int j = 0;
        while(j < i)  {
            String s1 = as[j];
            if(s1.startsWith(mPrefix))
                if(s1.endsWith(".backup"))
                    (new File(mBasePath, s1)).renameTo(new File(mBasePath, s1.substring(0, s1.length() - ".backup".length())));
                else
                if(s1.endsWith(".no_backup")) {
                    File file1 = new File(mBasePath, s1);
                    File file2 = new File(mBasePath, s1.substring(0, s1.length() - ".no_backup".length()));
                    file1.delete();
                    file2.delete();
                }
            j++;
        }
    }

    private String getActiveName(long l) {
        String s = null;
        long l1 = 0x7fffffffffffffffL;
        FileInfo fileinfo = new FileInfo(mPrefix);
        String as[] = mBasePath.list();
        int i = as.length;
        int j = 0;
        do {
            if(j >= i)
                break;
            String s1 = as[j];
            if(fileinfo.parse(s1) && fileinfo.isActive() && fileinfo.startMillis < l && fileinfo.startMillis < l1) {
                s = s1;
                l1 = fileinfo.startMillis;
            }
            j++;
        } while(true);
        if(s == null) {
            fileinfo.startMillis = l;
            fileinfo.endMillis = 0x7fffffffffffffffL;
            s = fileinfo.build();
        }
        return s;
    }

    private static void readFile(File file, Reader reader) throws IOException {
        BufferedInputStream bufferedinputstream = new BufferedInputStream(new FileInputStream(file));
        reader.read(bufferedinputstream);
        IoUtils.closeQuietly(bufferedinputstream);
        return;
        Exception exception;
        exception;
        IoUtils.closeQuietly(bufferedinputstream);
        throw exception;
    }

    private static IOException rethrowAsIoException(Throwable throwable) throws IOException {
        if(throwable instanceof IOException)
            throw (IOException)throwable;
        else
            throw new IOException(throwable.getMessage(), throwable);
    }

    private void rewriteSingle(Rewriter rewriter, String s) throws IOException {
        File file;
        file = new File(mBasePath, s);
        rewriter.reset();
        if(!file.exists()) goto _L2; else goto _L1
_L1:
        readFile(file, rewriter);
        if(rewriter.shouldWrite()) {
            File file2 = new File(mBasePath, (new StringBuilder()).append(s).append(".backup").toString());
            file.renameTo(file2);
            try {
                writeFile(file, rewriter);
                file2.delete();
            }
            catch(Throwable throwable1) {
                file.delete();
                file2.renameTo(file);
                throw rethrowAsIoException(throwable1);
            }
        }
_L4:
        return;
_L2:
        File file1 = new File(mBasePath, (new StringBuilder()).append(s).append(".no_backup").toString());
        file1.createNewFile();
        try {
            writeFile(file, rewriter);
            file1.delete();
        }
        catch(Throwable throwable) {
            file.delete();
            file1.delete();
            throw rethrowAsIoException(throwable);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    private static void writeFile(File file, Writer writer) throws IOException {
        FileOutputStream fileoutputstream;
        BufferedOutputStream bufferedoutputstream;
        fileoutputstream = new FileOutputStream(file);
        bufferedoutputstream = new BufferedOutputStream(fileoutputstream);
        writer.write(bufferedoutputstream);
        bufferedoutputstream.flush();
        FileUtils.sync(fileoutputstream);
        IoUtils.closeQuietly(bufferedoutputstream);
        return;
        Exception exception;
        exception;
        FileUtils.sync(fileoutputstream);
        IoUtils.closeQuietly(bufferedoutputstream);
        throw exception;
    }

    public void combineActive(final Reader reader, final Writer writer, long l) throws IOException {
        rewriteActive(new Rewriter() {

            public void read(InputStream inputstream) throws IOException {
                reader.read(inputstream);
            }

            public void reset() {
            }

            public boolean shouldWrite() {
                return true;
            }

            public void write(OutputStream outputstream) throws IOException {
                writer.write(outputstream);
            }

            final FileRotator this$0;
            final Reader val$reader;
            final Writer val$writer;

             {
                this$0 = FileRotator.this;
                reader = reader1;
                writer = writer1;
                super();
            }
        }, l);
    }

    public void deleteAll() {
        FileInfo fileinfo = new FileInfo(mPrefix);
        String as[] = mBasePath.list();
        int i = as.length;
        for(int j = 0; j < i; j++) {
            String s = as[j];
            if(fileinfo.parse(s))
                (new File(mBasePath, s)).delete();
        }

    }

    public void dumpAll(OutputStream outputstream) throws IOException {
        ZipOutputStream zipoutputstream = new ZipOutputStream(outputstream);
        FileInfo fileinfo;
        String as[];
        int i;
        int j;
        fileinfo = new FileInfo(mPrefix);
        as = mBasePath.list();
        i = as.length;
        j = 0;
_L3:
        if(j >= i) goto _L2; else goto _L1
_L1:
        FileInputStream fileinputstream;
        String s = as[j];
        if(!fileinfo.parse(s))
            break MISSING_BLOCK_LABEL_139;
        zipoutputstream.putNextEntry(new ZipEntry(s));
        fileinputstream = new FileInputStream(new File(mBasePath, s));
        Streams.copy(fileinputstream, zipoutputstream);
        IoUtils.closeQuietly(fileinputstream);
        zipoutputstream.closeEntry();
        break MISSING_BLOCK_LABEL_139;
        Exception exception1;
        exception1;
        IoUtils.closeQuietly(fileinputstream);
        throw exception1;
        Exception exception;
        exception;
        IoUtils.closeQuietly(zipoutputstream);
        throw exception;
_L2:
        IoUtils.closeQuietly(zipoutputstream);
        return;
        j++;
          goto _L3
    }

    public void maybeRotate(long l) {
        long l1 = l - mRotateAgeMillis;
        long l2 = l - mDeleteAgeMillis;
        FileInfo fileinfo = new FileInfo(mPrefix);
        String as[] = mBasePath.list();
        int i = as.length;
        int j = 0;
        while(j < i)  {
            String s = as[j];
            if(fileinfo.parse(s))
                if(fileinfo.isActive()) {
                    if(fileinfo.startMillis <= l1) {
                        fileinfo.endMillis = l;
                        (new File(mBasePath, s)).renameTo(new File(mBasePath, fileinfo.build()));
                    }
                } else
                if(fileinfo.endMillis <= l2)
                    (new File(mBasePath, s)).delete();
            j++;
        }
    }

    public void readMatching(Reader reader, long l, long l1) throws IOException {
        FileInfo fileinfo = new FileInfo(mPrefix);
        String as[] = mBasePath.list();
        int i = as.length;
        int j = 0;
        do {
            if(j >= i)
                break;
            String s = as[j];
            if(fileinfo.parse(s) && fileinfo.startMillis <= l1 && l <= fileinfo.endMillis)
                readFile(new File(mBasePath, s), reader);
            j++;
        } while(true);
    }

    public void rewriteActive(Rewriter rewriter, long l) throws IOException {
        rewriteSingle(rewriter, getActiveName(l));
    }

    public void rewriteAll(Rewriter rewriter) throws IOException {
        FileInfo fileinfo = new FileInfo(mPrefix);
        String as[] = mBasePath.list();
        int i = as.length;
        int j = 0;
        while(j < i)  {
            String s = as[j];
            if(fileinfo.parse(s))
                rewriteSingle(rewriter, s);
            j++;
        }
    }

    private static final boolean LOGD = false;
    private static final String SUFFIX_BACKUP = ".backup";
    private static final String SUFFIX_NO_BACKUP = ".no_backup";
    private static final String TAG = "FileRotator";
    private final File mBasePath;
    private final long mDeleteAgeMillis;
    private final String mPrefix;
    private final long mRotateAgeMillis;
}
