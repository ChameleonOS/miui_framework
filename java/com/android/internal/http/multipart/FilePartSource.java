// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.http.multipart;

import java.io.*;

// Referenced classes of package com.android.internal.http.multipart:
//            PartSource

public class FilePartSource
    implements PartSource {

    public FilePartSource(File file1) throws FileNotFoundException {
        file = null;
        fileName = null;
        file = file1;
        if(file1 != null) {
            if(!file1.isFile())
                throw new FileNotFoundException("File is not a normal file.");
            if(!file1.canRead())
                throw new FileNotFoundException("File is not readable.");
            fileName = file1.getName();
        }
    }

    public FilePartSource(String s, File file1) throws FileNotFoundException {
        this(file1);
        if(s != null)
            fileName = s;
    }

    public InputStream createInputStream() throws IOException {
        Object obj;
        if(file != null)
            obj = new FileInputStream(file);
        else
            obj = new ByteArrayInputStream(new byte[0]);
        return ((InputStream) (obj));
    }

    public String getFileName() {
        String s;
        if(fileName == null)
            s = "noname";
        else
            s = fileName;
        return s;
    }

    public long getLength() {
        long l;
        if(file != null)
            l = file.length();
        else
            l = 0L;
        return l;
    }

    private File file;
    private String fileName;
}
