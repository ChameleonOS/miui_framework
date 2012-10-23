// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;


// Referenced classes of package android.content:
//            ContextWrapper, Context

public class MutableContextWrapper extends ContextWrapper {

    public MutableContextWrapper(Context context) {
        super(context);
    }

    public void setBaseContext(Context context) {
        super.mBase = context;
    }
}
