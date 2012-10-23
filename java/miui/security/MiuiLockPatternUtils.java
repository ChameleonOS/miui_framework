// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.security;

import android.content.Context;
import android.os.Environment;
import android.os.FileObserver;
import android.util.Log;
import com.android.internal.widget.LockPatternUtils;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class MiuiLockPatternUtils extends LockPatternUtils {
    private static class PasswordFileObserver extends FileObserver {

        public void onEvent(int i, String s) {
            if("access_control.key".equals(s)) {
                Log.d("MiuiLockPatternUtils", "access control password file changed");
                AtomicBoolean atomicboolean = MiuiLockPatternUtils.sHaveNonZeroACFile;
                boolean flag;
                if((new File(MiuiLockPatternUtils.sLockACFilename)).length() > 0L)
                    flag = true;
                else
                    flag = false;
                atomicboolean.set(flag);
            }
        }

        public PasswordFileObserver(String s, int i) {
            super(s, i);
        }
    }


    public MiuiLockPatternUtils(Context context) {
        super(context);
        if(sLockACFilename == null) {
            String s = (new StringBuilder()).append(Environment.getDataDirectory().getAbsolutePath()).append("/system/").toString();
            sLockACFilename = (new StringBuilder()).append(s).append("access_control.key").toString();
            AtomicBoolean atomicboolean = sHaveNonZeroACFile;
            boolean flag;
            if((new File(sLockACFilename)).length() > 0L)
                flag = true;
            else
                flag = false;
            atomicboolean.set(flag);
            sPasswordObserver = new PasswordFileObserver(s, 904);
            sPasswordObserver.startWatching();
        }
    }

    public boolean checkAccessControl(List list) {
        boolean flag = true;
        boolean flag1;
        RandomAccessFile randomaccessfile = new RandomAccessFile(sLockACFilename, "r");
        byte abyte0[] = new byte[(int)randomaccessfile.length()];
        int i = randomaccessfile.read(abyte0, 0, abyte0.length);
        randomaccessfile.close();
        if(i <= 0)
            break MISSING_BLOCK_LABEL_72;
        flag1 = Arrays.equals(abyte0, LockPatternUtils.patternToHash(list));
        flag = flag1;
        break MISSING_BLOCK_LABEL_72;
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        break MISSING_BLOCK_LABEL_72;
        IOException ioexception;
        ioexception;
        return flag;
    }

    public void saveACLockPattern(List list) {
        byte abyte0[] = LockPatternUtils.patternToHash(list);
        try {
            RandomAccessFile randomaccessfile = new RandomAccessFile(sLockACFilename, "rw");
            if(list == null)
                randomaccessfile.setLength(0L);
            else
                randomaccessfile.write(abyte0, 0, abyte0.length);
            randomaccessfile.close();
        }
        catch(FileNotFoundException filenotfoundexception) {
            Log.e("MiuiLockPatternUtils", (new StringBuilder()).append("Unable to save lock pattern to ").append(sLockACFilename).toString());
        }
        catch(IOException ioexception) {
            Log.e("MiuiLockPatternUtils", (new StringBuilder()).append("Unable to save lock pattern to ").append(sLockACFilename).toString());
        }
    }

    public boolean savedAccessControlExists() {
        return sHaveNonZeroACFile.get();
    }

    private static final String LOCK_AC_FILE = "access_control.key";
    private static final String SYSTEM_DIRECTORY = "/system/";
    private static final String TAG = "MiuiLockPatternUtils";
    private static final AtomicBoolean sHaveNonZeroACFile = new AtomicBoolean(false);
    private static String sLockACFilename;
    private static FileObserver sPasswordObserver;



}
