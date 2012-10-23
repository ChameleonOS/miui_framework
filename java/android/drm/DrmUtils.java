// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.drm;

import java.io.*;
import java.util.*;

public class DrmUtils {
    public static class ExtendedMetadataParser {

        private int readByte(byte abyte0[], int i) {
            return abyte0[i];
        }

        private String readMultipleBytes(byte abyte0[], int i, int j) {
            byte abyte1[] = new byte[i];
            int k = j;
            for(int l = 0; k < j + i; l++) {
                abyte1[l] = abyte0[k];
                k++;
            }

            return new String(abyte1);
        }

        public String get(String s) {
            return (String)mMap.get(s);
        }

        public Iterator iterator() {
            return mMap.values().iterator();
        }

        public Iterator keyIterator() {
            return mMap.keySet().iterator();
        }

        HashMap mMap;

        private ExtendedMetadataParser(byte abyte0[]) {
            mMap = new HashMap();
            for(int i = 0; i < abyte0.length;) {
                int j = readByte(abyte0, i);
                int k = i + 1;
                int l = readByte(abyte0, k);
                int i1 = k + 1;
                String s = readMultipleBytes(abyte0, j, i1);
                int j1 = i1 + j;
                String s1 = readMultipleBytes(abyte0, l, j1);
                if(s1.equals(" "))
                    s1 = "";
                i = j1 + l;
                mMap.put(s, s1);
            }

        }

    }


    public DrmUtils() {
    }

    public static ExtendedMetadataParser getExtendedMetadataParser(byte abyte0[]) {
        return new ExtendedMetadataParser(abyte0);
    }

    private static void quietlyDispose(InputStream inputstream) {
        if(inputstream == null)
            break MISSING_BLOCK_LABEL_8;
        inputstream.close();
_L2:
        return;
        IOException ioexception;
        ioexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private static void quietlyDispose(OutputStream outputstream) {
        if(outputstream == null)
            break MISSING_BLOCK_LABEL_8;
        outputstream.close();
_L2:
        return;
        IOException ioexception;
        ioexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    static byte[] readBytes(File file) throws IOException {
        FileInputStream fileinputstream;
        BufferedInputStream bufferedinputstream;
        byte abyte0[];
        fileinputstream = new FileInputStream(file);
        bufferedinputstream = new BufferedInputStream(fileinputstream);
        abyte0 = null;
        int i = bufferedinputstream.available();
        if(i > 0) {
            abyte0 = new byte[i];
            bufferedinputstream.read(abyte0);
        }
        quietlyDispose(bufferedinputstream);
        quietlyDispose(fileinputstream);
        return abyte0;
        Exception exception;
        exception;
        quietlyDispose(bufferedinputstream);
        quietlyDispose(fileinputstream);
        throw exception;
    }

    static byte[] readBytes(String s) throws IOException {
        return readBytes(new File(s));
    }

    static void removeFile(String s) throws IOException {
        (new File(s)).delete();
    }

    static void writeToFile(String s, byte abyte0[]) throws IOException {
        Object obj;
        obj = null;
        if(s == null || abyte0 == null)
            break MISSING_BLOCK_LABEL_28;
        FileOutputStream fileoutputstream = new FileOutputStream(s);
        fileoutputstream.write(abyte0);
        quietlyDispose(fileoutputstream);
        return;
        Exception exception;
        exception;
_L2:
        quietlyDispose(((OutputStream) (obj)));
        throw exception;
        exception;
        obj = fileoutputstream;
        if(true) goto _L2; else goto _L1
_L1:
    }
}
