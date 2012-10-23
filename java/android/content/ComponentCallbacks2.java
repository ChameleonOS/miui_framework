// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;


// Referenced classes of package android.content:
//            ComponentCallbacks

public interface ComponentCallbacks2
    extends ComponentCallbacks {

    public abstract void onTrimMemory(int i);

    public static final int TRIM_MEMORY_BACKGROUND = 40;
    public static final int TRIM_MEMORY_COMPLETE = 80;
    public static final int TRIM_MEMORY_MODERATE = 60;
    public static final int TRIM_MEMORY_RUNNING_CRITICAL = 15;
    public static final int TRIM_MEMORY_RUNNING_LOW = 10;
    public static final int TRIM_MEMORY_RUNNING_MODERATE = 5;
    public static final int TRIM_MEMORY_UI_HIDDEN = 20;
}
