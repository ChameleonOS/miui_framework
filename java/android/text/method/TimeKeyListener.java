// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.method;


// Referenced classes of package android.text.method:
//            NumberKeyListener

public class TimeKeyListener extends NumberKeyListener {

    public TimeKeyListener() {
    }

    public static TimeKeyListener getInstance() {
        TimeKeyListener timekeylistener;
        if(sInstance != null) {
            timekeylistener = sInstance;
        } else {
            sInstance = new TimeKeyListener();
            timekeylistener = sInstance;
        }
        return timekeylistener;
    }

    protected char[] getAcceptedChars() {
        return CHARACTERS;
    }

    public int getInputType() {
        return 36;
    }

    public static final char CHARACTERS[];
    private static TimeKeyListener sInstance;

    static  {
        char ac[] = new char[14];
        ac[0] = '0';
        ac[1] = '1';
        ac[2] = '2';
        ac[3] = '3';
        ac[4] = '4';
        ac[5] = '5';
        ac[6] = '6';
        ac[7] = '7';
        ac[8] = '8';
        ac[9] = '9';
        ac[10] = 'a';
        ac[11] = 'm';
        ac[12] = 'p';
        ac[13] = ':';
        CHARACTERS = ac;
    }
}
