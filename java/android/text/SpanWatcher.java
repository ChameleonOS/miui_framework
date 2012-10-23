// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text;


// Referenced classes of package android.text:
//            NoCopySpan, Spannable

public interface SpanWatcher
    extends NoCopySpan {

    public abstract void onSpanAdded(Spannable spannable, Object obj, int i, int j);

    public abstract void onSpanChanged(Spannable spannable, Object obj, int i, int j, int k, int l);

    public abstract void onSpanRemoved(Spannable spannable, Object obj, int i, int j);
}
