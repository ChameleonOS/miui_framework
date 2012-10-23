// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;

// Referenced classes of package android.os:
//            StrictMode

public class FileUtils {
    public static final class FileStatus {

        public long atime;
        public int blksize;
        public long blocks;
        public long ctime;
        public int dev;
        public int gid;
        public int ino;
        public int mode;
        public long mtime;
        public int nlink;
        public int rdev;
        public long size;
        public int uid;

        public FileStatus() {
        }
    }


    public FileUtils() {
    }

    public static long checksumCrc32(File file) throws FileNotFoundException, IOException {
        CRC32 crc32;
        CheckedInputStream checkedinputstream;
        crc32 = new CRC32();
        checkedinputstream = null;
        CheckedInputStream checkedinputstream1 = new CheckedInputStream(new FileInputStream(file), crc32);
        long l;
        for(byte abyte0[] = new byte[128]; checkedinputstream1.read(abyte0) >= 0;);
        l = crc32.getValue();
        Exception exception;
        if(checkedinputstream1 != null)
            try {
                checkedinputstream1.close();
            }
            catch(IOException ioexception1) { }
        return l;
        exception;
_L2:
        if(checkedinputstream != null)
            try {
                checkedinputstream.close();
            }
            catch(IOException ioexception) { }
        throw exception;
        exception;
        checkedinputstream = checkedinputstream1;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static boolean copyFile(File file, File file1) {
        FileInputStream fileinputstream = new FileInputStream(file);
        boolean flag1 = copyToFile(fileinputstream, file1);
        boolean flag = flag1;
        fileinputstream.close();
        break MISSING_BLOCK_LABEL_39;
        Exception exception;
        exception;
        fileinputstream.close();
        throw exception;
        IOException ioexception;
        ioexception;
        flag = false;
        return flag;
    }

    public static boolean copyToFile(InputStream inputstream, File file) {
        boolean flag = false;
        FileOutputStream fileoutputstream;
        if(file.exists())
            file.delete();
        fileoutputstream = new FileOutputStream(file);
        byte abyte0[] = new byte[4096];
        do {
            int i = inputstream.read(abyte0);
            if(i < 0)
                break;
            fileoutputstream.write(abyte0, 0, i);
        } while(true);
        break MISSING_BLOCK_LABEL_80;
        Exception exception;
        exception;
        fileoutputstream.flush();
        try {
            fileoutputstream.getFD().sync();
        }
        catch(IOException ioexception1) { }
        fileoutputstream.close();
        throw exception;
        fileoutputstream.flush();
        try {
            fileoutputstream.getFD().sync();
        }
        catch(IOException ioexception2) { }
        fileoutputstream.close();
        flag = true;
        break MISSING_BLOCK_LABEL_114;
        IOException ioexception;
        ioexception;
        return flag;
    }

    public static native int getFatVolumeId(String s);

    public static boolean getFileStatus(String s, FileStatus filestatus) {
        StrictMode.noteDiskRead();
        return getFileStatusNative(s, filestatus);
    }

    private static native boolean getFileStatusNative(String s, FileStatus filestatus);

    public static native int getPermissions(String s, int ai[]);

    public static boolean isFilenameSafe(File file) {
        return SAFE_FILENAME_PATTERN.matcher(file.getPath()).matches();
    }

    public static String readTextFile(File file, int i, String s) throws IOException {
        FileInputStream fileinputstream = new FileInputStream(file);
        long l = file.length();
        if(i <= 0 && (l <= 0L || i != 0)) goto _L2; else goto _L1
_L12:
        byte abyte0[];
        int j;
        abyte0 = new byte[i + 1];
        j = fileinputstream.read(abyte0);
        if(j > 0) goto _L4; else goto _L3
_L3:
        String s2 = "";
        fileinputstream.close();
_L5:
        return s2;
_L4:
        if(j > i)
            break MISSING_BLOCK_LABEL_91;
        s2 = new String(abyte0, 0, j);
        fileinputstream.close();
          goto _L5
        if(s != null)
            break MISSING_BLOCK_LABEL_115;
        s2 = new String(abyte0, 0, i);
        fileinputstream.close();
          goto _L5
        String s1 = (new StringBuilder()).append(new String(abyte0, 0, i)).append(s).toString();
        s2 = s1;
        fileinputstream.close();
          goto _L5
_L2:
        if(i >= 0) goto _L7; else goto _L6
_L6:
        boolean flag;
        byte abyte2[];
        byte abyte3[];
        flag = false;
        abyte2 = null;
        abyte3 = null;
_L9:
        int j1;
        if(abyte2 != null)
            flag = true;
        byte abyte4[] = abyte2;
        abyte2 = abyte3;
        abyte3 = abyte4;
        if(abyte3 != null)
            break MISSING_BLOCK_LABEL_204;
        j1 = -i;
        abyte3 = new byte[j1];
        int i1 = fileinputstream.read(abyte3);
        if(i1 == abyte3.length) goto _L9; else goto _L8
_L8:
        if(abyte2 != null || i1 > 0)
            break MISSING_BLOCK_LABEL_241;
        s2 = "";
        fileinputstream.close();
          goto _L5
        if(abyte2 != null)
            break MISSING_BLOCK_LABEL_267;
        s2 = new String(abyte3, 0, i1);
        fileinputstream.close();
          goto _L5
        if(i1 <= 0) goto _L11; else goto _L10
_L10:
        flag = true;
        System.arraycopy(abyte2, i1, abyte2, 0, abyte2.length - i1);
        System.arraycopy(abyte3, 0, abyte2, abyte2.length - i1, i1);
          goto _L11
_L13:
        s2 = new String(abyte2);
        fileinputstream.close();
          goto _L5
_L14:
        String s4 = (new StringBuilder()).append(s).append(new String(abyte2)).toString();
        s2 = s4;
        fileinputstream.close();
          goto _L5
_L7:
        String s3;
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        byte abyte1[] = new byte[1024];
        int k;
        do {
            k = fileinputstream.read(abyte1);
            if(k > 0)
                bytearrayoutputstream.write(abyte1, 0, k);
        } while(k == abyte1.length);
        s3 = bytearrayoutputstream.toString();
        s2 = s3;
        fileinputstream.close();
          goto _L5
        Exception exception;
        exception;
        fileinputstream.close();
        throw exception;
_L1:
        if(l > 0L && (i == 0 || l < (long)i))
            i = (int)l;
          goto _L12
_L11:
        if(s != null && flag) goto _L14; else goto _L13
    }

    public static native int setPermissions(String s, int i, int j, int k);

    public static native int setUMask(int i);

    public static void stringToFile(String s, String s1) throws IOException {
        FileWriter filewriter = new FileWriter(s);
        filewriter.write(s1);
        filewriter.close();
        return;
        Exception exception;
        exception;
        filewriter.close();
        throw exception;
    }

    public static boolean sync(FileOutputStream fileoutputstream) {
        if(fileoutputstream == null)
            break MISSING_BLOCK_LABEL_11;
        fileoutputstream.getFD().sync();
        boolean flag = true;
_L2:
        return flag;
        IOException ioexception;
        ioexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    private static final Pattern SAFE_FILENAME_PATTERN = Pattern.compile("[\\w%+,./=_-]+");
    public static final int S_IRGRP = 32;
    public static final int S_IROTH = 4;
    public static final int S_IRUSR = 256;
    public static final int S_IRWXG = 56;
    public static final int S_IRWXO = 7;
    public static final int S_IRWXU = 448;
    public static final int S_IWGRP = 16;
    public static final int S_IWOTH = 2;
    public static final int S_IWUSR = 128;
    public static final int S_IXGRP = 8;
    public static final int S_IXOTH = 1;
    public static final int S_IXUSR = 64;

}
