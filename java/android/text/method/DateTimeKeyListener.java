// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.method;


// Referenced classes of package android.text.method:
//            NumberKeyListener

public class DateTimeKeyListener extends NumberKeyListener {

    public DateTimeKeyListener() {
    }

    public static DateTimeKeyListener getInstance() {
        DateTimeKeyListener datetimekeylistener;
        if(sInstance != null) {
            datetimekeylistener = sInstance;
        } else {
            sInstance = new DateTimeKeyListener();
            datetimekeylistener = sInstance;
        }
        return datetimekeylistener;
    }

    protected char[] getAcceptedChars() {
        return CHARACTERS;
    }

    public int getInputType() {
        return 4;
    }

    public static final char CHARACTERS[];
    private static DateTimeKeyListener sInstance;

    static  {
        char ac[] = new char[17];
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
        ac[14] = '/';
        ac[15] = '-';
        ac[16] = ' ';
        CHARACTERS = ac;
    }
}
