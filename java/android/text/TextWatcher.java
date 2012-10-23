// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text;


// Referenced classes of package android.text:
//            NoCopySpan, Editable

public interface TextWatcher
    extends NoCopySpan {

    public abstract void afterTextChanged(Editable editable);

    public abstract void beforeTextChanged(CharSequence charsequence, int i, int j, int k);

    public abstract void onTextChanged(CharSequence charsequence, int i, int j, int k);
}
