// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.method;


// Referenced classes of package android.text.method:
//            NumberKeyListener

public class DateKeyListener extends NumberKeyListener {

    public DateKeyListener() {
    }

    public static DateKeyListener getInstance() {
        DateKeyListener datekeylistener;
        if(sInstance != null) {
            datekeylistener = sInstance;
        } else {
            sInstance = new DateKeyListener();
            datekeylistener = sInstance;
        }
        return datekeylistener;
    }

    protected char[] getAcceptedChars() {
        return CHARACTERS;
    }

    public int getInputType() {
        return 20;
    }

    public static final char CHARACTERS[];
    private static DateKeyListener sInstance;

    static  {
        char ac[] = new char[13];
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
        ac[10] = '/';
        ac[11] = '-';
        ac[12] = '.';
        CHARACTERS = ac;
    }
}
