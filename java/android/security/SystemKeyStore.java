// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.security;

import android.os.Environment;
import android.os.FileUtils;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import libcore.io.IoUtils;

public class SystemKeyStore {

    private SystemKeyStore() {
    }

    public static SystemKeyStore getInstance() {
        return mInstance;
    }

    private File getKeyFile(String s) {
        return new File(new File(Environment.getDataDirectory(), "misc/systemkeys"), (new StringBuilder()).append(s).append(".sks").toString());
    }

    public static String toHexString(byte abyte0[]) {
        String s;
        if(abyte0 == null) {
            s = null;
        } else {
            int _tmp = abyte0.length;
            StringBuilder stringbuilder = new StringBuilder(2 * abyte0.length);
            for(int i = 0; i < abyte0.length; i++) {
                String s1 = Integer.toString(0xff & abyte0[i], 16);
                if(s1.length() == 1)
                    s1 = (new StringBuilder()).append("0").append(s1).toString();
                stringbuilder.append(s1);
            }

            s = stringbuilder.toString();
        }
        return s;
    }

    public void deleteKey(String s) {
        File file = getKeyFile(s);
        if(!file.exists()) {
            throw new IllegalArgumentException();
        } else {
            file.delete();
            return;
        }
    }

    public byte[] generateNewKey(int i, String s, String s1) throws NoSuchAlgorithmException {
        File file = getKeyFile(s1);
        if(file.exists())
            throw new IllegalArgumentException();
        KeyGenerator keygenerator = KeyGenerator.getInstance(s);
        keygenerator.init(i, SecureRandom.getInstance("SHA1PRNG"));
        byte abyte0[] = keygenerator.generateKey().getEncoded();
        try {
            if(!file.createNewFile())
                throw new IllegalArgumentException();
            FileOutputStream fileoutputstream = new FileOutputStream(file);
            fileoutputstream.write(abyte0);
            fileoutputstream.flush();
            FileUtils.sync(fileoutputstream);
            fileoutputstream.close();
            FileUtils.setPermissions(file.getName(), 384, -1, -1);
        }
        catch(IOException ioexception) {
            abyte0 = null;
        }
        return abyte0;
    }

    public String generateNewKeyHexString(int i, String s, String s1) throws NoSuchAlgorithmException {
        return toHexString(generateNewKey(i, s, s1));
    }

    public byte[] retrieveKey(String s) throws IOException {
        File file = getKeyFile(s);
        byte abyte0[];
        if(!file.exists())
            abyte0 = null;
        else
            abyte0 = IoUtils.readFileAsByteArray(file.toString());
        return abyte0;
    }

    public String retrieveKeyHexString(String s) throws IOException {
        return toHexString(retrieveKey(s));
    }

    private static final String KEY_FILE_EXTENSION = ".sks";
    private static final String SYSTEM_KEYSTORE_DIRECTORY = "misc/systemkeys";
    private static SystemKeyStore mInstance = new SystemKeyStore();

}
