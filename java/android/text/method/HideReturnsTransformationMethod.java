// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text.method;


// Referenced classes of package android.text.method:
//            ReplacementTransformationMethod

public class HideReturnsTransformationMethod extends ReplacementTransformationMethod {

    public HideReturnsTransformationMethod() {
    }

    public static HideReturnsTransformationMethod getInstance() {
        HideReturnsTransformationMethod hidereturnstransformationmethod;
        if(sInstance != null) {
            hidereturnstransformationmethod = sInstance;
        } else {
            sInstance = new HideReturnsTransformationMethod();
            hidereturnstransformationmethod = sInstance;
        }
        return hidereturnstransformationmethod;
    }

    protected char[] getOriginal() {
        return ORIGINAL;
    }

    protected char[] getReplacement() {
        return REPLACEMENT;
    }

    private static char ORIGINAL[];
    private static char REPLACEMENT[];
    private static HideReturnsTransformationMethod sInstance;

    static  {
        char ac[] = new char[1];
        ac[0] = '\r';
        ORIGINAL = ac;
        char ac1[] = new char[1];
        ac1[0] = '\uFEFF';
        REPLACEMENT = ac1;
    }
}
