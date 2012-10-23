// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.security;

import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import java.io.*;
import java.nio.charset.Charsets;
import java.nio.charset.ModifiedUtf8;
import java.util.ArrayList;

public class KeyStore {
    public static final class State extends Enum {

        public static State valueOf(String s) {
            return (State)Enum.valueOf(android/security/KeyStore$State, s);
        }

        public static State[] values() {
            return (State[])$VALUES.clone();
        }

        private static final State $VALUES[];
        public static final State LOCKED;
        public static final State UNINITIALIZED;
        public static final State UNLOCKED;

        static  {
            UNLOCKED = new State("UNLOCKED", 0);
            LOCKED = new State("LOCKED", 1);
            UNINITIALIZED = new State("UNINITIALIZED", 2);
            State astate[] = new State[3];
            astate[0] = UNLOCKED;
            astate[1] = LOCKED;
            astate[2] = UNINITIALIZED;
            $VALUES = astate;
        }

        private State(String s, int i) {
            super(s, i);
        }
    }


    private KeyStore() {
        mError = 1;
    }

    private boolean contains(byte abyte0[]) {
        boolean flag = true;
        byte abyte1[][] = new byte[flag][];
        abyte1[0] = abyte0;
        execute(101, abyte1);
        if(mError != flag)
            flag = false;
        return flag;
    }

    private boolean delKey(byte abyte0[]) {
        boolean flag = true;
        byte abyte1[][] = new byte[flag][];
        abyte1[0] = abyte0;
        execute(107, abyte1);
        if(mError != flag)
            flag = false;
        return flag;
    }

    private boolean delete(byte abyte0[]) {
        boolean flag = true;
        byte abyte1[][] = new byte[flag][];
        abyte1[0] = abyte0;
        execute(100, abyte1);
        if(mError != flag)
            flag = false;
        return flag;
    }

    private transient ArrayList execute(int i, byte abyte0[][]) {
        int j;
        int k;
        mError = 5;
        j = abyte0.length;
        k = 0;
_L12:
        if(k >= j) goto _L2; else goto _L1
_L1:
        byte abyte3[] = abyte0[k];
        if(abyte3 != null && abyte3.length <= 65535) goto _L4; else goto _L3
_L3:
        ArrayList arraylist = null;
_L10:
        return arraylist;
_L4:
        k++;
        continue; /* Loop/switch isn't completed */
_L2:
        LocalSocket localsocket = new LocalSocket();
        InputStream inputstream;
        localsocket.connect(sAddress);
        OutputStream outputstream = localsocket.getOutputStream();
        outputstream.write(i);
        int l = abyte0.length;
        for(int i1 = 0; i1 < l; i1++) {
            byte abyte2[] = abyte0[i1];
            outputstream.write(abyte2.length >> 8);
            outputstream.write(abyte2.length);
            outputstream.write(abyte2);
        }

        outputstream.flush();
        localsocket.shutdownOutput();
        inputstream = localsocket.getInputStream();
        int j1 = inputstream.read();
        if(j1 == 1)
            break MISSING_BLOCK_LABEL_189;
        if(j1 != -1)
            mError = j1;
        arraylist = null;
        try {
            localsocket.close();
        }
        catch(IOException ioexception3) { }
        continue; /* Loop/switch isn't completed */
        arraylist = new ArrayList();
_L8:
        int k1 = inputstream.read();
        if(k1 != -1) goto _L6; else goto _L5
_L5:
        mError = 1;
        localsocket.close();
        continue; /* Loop/switch isn't completed */
_L6:
        int l1 = inputstream.read();
        if(l1 != -1)
            break MISSING_BLOCK_LABEL_250;
        arraylist = null;
        localsocket.close();
        continue; /* Loop/switch isn't completed */
        int i2 = l1 | k1 << 8;
        byte abyte1[];
        int j2;
        abyte1 = new byte[i2];
        j2 = 0;
_L7:
        int k2;
        if(j2 >= abyte1.length)
            break MISSING_BLOCK_LABEL_322;
        k2 = inputstream.read(abyte1, j2, abyte1.length - j2);
        if(k2 != -1)
            break MISSING_BLOCK_LABEL_312;
        arraylist = null;
        localsocket.close();
        continue; /* Loop/switch isn't completed */
        j2 += k2;
          goto _L7
        arraylist.add(abyte1);
          goto _L8
        IOException ioexception1;
        ioexception1;
        Exception exception;
        try {
            localsocket.close();
        }
        catch(IOException ioexception2) { }
        arraylist = null;
        if(true) goto _L10; else goto _L9
_L9:
        exception;
        try {
            localsocket.close();
        }
        catch(IOException ioexception) { }
        throw exception;
        if(true) goto _L12; else goto _L11
_L11:
    }

    private boolean generate(byte abyte0[]) {
        boolean flag = true;
        byte abyte1[][] = new byte[flag][];
        abyte1[0] = abyte0;
        execute(97, abyte1);
        if(mError != flag)
            flag = false;
        return flag;
    }

    private byte[] get(byte abyte0[]) {
        byte abyte1[][] = new byte[1][];
        abyte1[0] = abyte0;
        ArrayList arraylist = execute(103, abyte1);
        byte abyte2[];
        if(arraylist == null || arraylist.isEmpty())
            abyte2 = null;
        else
            abyte2 = (byte[])arraylist.get(0);
        return abyte2;
    }

    public static KeyStore getInstance() {
        return new KeyStore();
    }

    private static byte[] getKeyBytes(String s) {
        byte abyte0[];
        try {
            abyte0 = new byte[(int)ModifiedUtf8.countBytes(s, false)];
            ModifiedUtf8.encode(abyte0, 0, s);
        }
        catch(UTFDataFormatException utfdataformatexception) {
            throw new RuntimeException(utfdataformatexception);
        }
        return abyte0;
    }

    private static byte[] getPasswordBytes(String s) {
        return s.getBytes(Charsets.UTF_8);
    }

    private byte[] getPubkey(byte abyte0[]) {
        byte abyte1[][] = new byte[1][];
        abyte1[0] = abyte0;
        ArrayList arraylist = execute(98, abyte1);
        byte abyte2[];
        if(arraylist == null || arraylist.isEmpty())
            abyte2 = null;
        else
            abyte2 = (byte[])arraylist.get(0);
        return abyte2;
    }

    private static byte[] getUidBytes(int i) {
        return Integer.toString(i).getBytes(Charsets.UTF_8);
    }

    private boolean grant(byte abyte0[], byte abyte1[]) {
        boolean flag = true;
        byte abyte2[][] = new byte[2][];
        abyte2[0] = abyte0;
        abyte2[flag] = abyte1;
        execute(120, abyte2);
        if(mError != flag)
            flag = false;
        return flag;
    }

    private boolean importKey(byte abyte0[], byte abyte1[]) {
        boolean flag = true;
        byte abyte2[][] = new byte[2][];
        abyte2[0] = abyte0;
        abyte2[flag] = abyte1;
        execute(109, abyte2);
        if(mError != flag)
            flag = false;
        return flag;
    }

    private boolean password(byte abyte0[]) {
        boolean flag = true;
        byte abyte1[][] = new byte[flag][];
        abyte1[0] = abyte0;
        execute(112, abyte1);
        if(mError != flag)
            flag = false;
        return flag;
    }

    private boolean put(byte abyte0[], byte abyte1[]) {
        boolean flag = true;
        byte abyte2[][] = new byte[2][];
        abyte2[0] = abyte0;
        abyte2[flag] = abyte1;
        execute(105, abyte2);
        if(mError != flag)
            flag = false;
        return flag;
    }

    private byte[] sign(byte abyte0[], byte abyte1[]) {
        byte abyte2[][] = new byte[2][];
        abyte2[0] = abyte0;
        abyte2[1] = abyte1;
        ArrayList arraylist = execute(110, abyte2);
        byte abyte3[];
        if(arraylist == null || arraylist.isEmpty())
            abyte3 = null;
        else
            abyte3 = (byte[])arraylist.get(0);
        return abyte3;
    }

    private static String toKeyString(byte abyte0[]) {
        String s;
        try {
            s = ModifiedUtf8.decode(abyte0, new char[abyte0.length], 0, abyte0.length);
        }
        catch(UTFDataFormatException utfdataformatexception) {
            throw new RuntimeException(utfdataformatexception);
        }
        return s;
    }

    private boolean ungrant(byte abyte0[], byte abyte1[]) {
        boolean flag = true;
        byte abyte2[][] = new byte[2][];
        abyte2[0] = abyte0;
        abyte2[flag] = abyte1;
        execute(121, abyte2);
        if(mError != flag)
            flag = false;
        return flag;
    }

    private boolean unlock(byte abyte0[]) {
        boolean flag = true;
        byte abyte1[][] = new byte[flag][];
        abyte1[0] = abyte0;
        execute(117, abyte1);
        if(mError != flag)
            flag = false;
        return flag;
    }

    private boolean verify(byte abyte0[], byte abyte1[], byte abyte2[]) {
        boolean flag = true;
        byte abyte3[][] = new byte[3][];
        abyte3[0] = abyte0;
        abyte3[flag] = abyte1;
        abyte3[2] = abyte2;
        execute(118, abyte3);
        if(mError != flag)
            flag = false;
        return flag;
    }

    public boolean contains(String s) {
        return contains(getKeyBytes(s));
    }

    public boolean delKey(String s) {
        return delKey(getKeyBytes(s));
    }

    public boolean delete(String s) {
        return delete(getKeyBytes(s));
    }

    public boolean generate(String s) {
        return generate(getKeyBytes(s));
    }

    public byte[] get(String s) {
        return get(getKeyBytes(s));
    }

    public int getLastError() {
        return mError;
    }

    public byte[] getPubkey(String s) {
        return getPubkey(getKeyBytes(s));
    }

    public boolean grant(String s, int i) {
        return grant(getKeyBytes(s), getUidBytes(i));
    }

    public boolean importKey(String s, byte abyte0[]) {
        return importKey(getKeyBytes(s), abyte0);
    }

    public boolean isEmpty() {
        boolean flag = false;
        execute(122, new byte[0][]);
        if(mError == 7)
            flag = true;
        return flag;
    }

    public boolean lock() {
        boolean flag = true;
        execute(108, new byte[0][]);
        if(mError != flag)
            flag = false;
        return flag;
    }

    public boolean password(String s) {
        return password(getPasswordBytes(s));
    }

    public boolean put(String s, byte abyte0[]) {
        return put(getKeyBytes(s), abyte0);
    }

    public boolean reset() {
        boolean flag = true;
        execute(114, new byte[0][]);
        if(mError != flag)
            flag = false;
        return flag;
    }

    public String[] saw(String s) {
        byte abyte0[][] = saw(getKeyBytes(s));
        String as[];
        if(abyte0 == null) {
            as = null;
        } else {
            as = new String[abyte0.length];
            int i = 0;
            while(i < abyte0.length)  {
                as[i] = toKeyString(abyte0[i]);
                i++;
            }
        }
        return as;
    }

    public byte[][] saw(byte abyte0[]) {
        byte abyte1[][] = new byte[1][];
        abyte1[0] = abyte0;
        ArrayList arraylist = execute(115, abyte1);
        byte abyte2[][];
        if(arraylist == null)
            abyte2 = (byte[][])null;
        else
            abyte2 = (byte[][])arraylist.toArray(new byte[arraylist.size()][]);
        return abyte2;
    }

    public byte[] sign(String s, byte abyte0[]) {
        return sign(getKeyBytes(s), abyte0);
    }

    public State state() {
        execute(116, new byte[0][]);
        mError;
        JVM INSTR tableswitch 1 3: default 40
    //                   1 52
    //                   2 58
    //                   3 65;
           goto _L1 _L2 _L3 _L4
_L1:
        throw new AssertionError(mError);
_L2:
        State state1 = State.UNLOCKED;
_L6:
        return state1;
_L3:
        state1 = State.LOCKED;
        continue; /* Loop/switch isn't completed */
_L4:
        state1 = State.UNINITIALIZED;
        if(true) goto _L6; else goto _L5
_L5:
    }

    public boolean ungrant(String s, int i) {
        return ungrant(getKeyBytes(s), getUidBytes(i));
    }

    public boolean unlock(String s) {
        return unlock(getPasswordBytes(s));
    }

    public boolean verify(String s, byte abyte0[], byte abyte1[]) {
        return verify(getKeyBytes(s), abyte0, abyte1);
    }

    public static final int KEY_NOT_FOUND = 7;
    public static final int LOCKED = 2;
    public static final int NO_ERROR = 1;
    public static final int PERMISSION_DENIED = 6;
    public static final int PROTOCOL_ERROR = 5;
    public static final int SYSTEM_ERROR = 4;
    public static final int UNDEFINED_ACTION = 9;
    public static final int UNINITIALIZED = 3;
    public static final int VALUE_CORRUPTED = 8;
    public static final int WRONG_PASSWORD = 10;
    private static final LocalSocketAddress sAddress;
    private int mError;

    static  {
        sAddress = new LocalSocketAddress("keystore", android.net.LocalSocketAddress.Namespace.RESERVED);
    }
}
