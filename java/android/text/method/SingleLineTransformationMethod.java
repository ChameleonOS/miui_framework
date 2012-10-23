// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.method;


// Referenced classes of package android.text.method:
//            ReplacementTransformationMethod

public class SingleLineTransformationMethod extends ReplacementTransformationMethod {

    public SingleLineTransformationMethod() {
    }

    public static SingleLineTransformationMethod getInstance() {
        SingleLineTransformationMethod singlelinetransformationmethod;
        if(sInstance != null) {
            singlelinetransformationmethod = sInstance;
        } else {
            sInstance = new SingleLineTransformationMethod();
            singlelinetransformationmethod = sInstance;
        }
        return singlelinetransformationmethod;
    }

    protected char[] getOriginal() {
        return ORIGINAL;
    }

    protected char[] getReplacement() {
        return REPLACEMENT;
    }

    private static char ORIGINAL[];
    private static char REPLACEMENT[];
    private static SingleLineTransformationMethod sInstance;

    static  {
        char ac[] = new char[2];
        ac[0] = '\n';
        ac[1] = '\r';
        ORIGINAL = ac;
        char ac1[] = new char[2];
        ac1[0] = ' ';
        ac1[1] = '\uFEFF';
        REPLACEMENT = ac1;
    }
}
