// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text;


public abstract class ClipboardManager {

    public ClipboardManager() {
    }

    public abstract CharSequence getText();

    public abstract boolean hasText();

    public abstract void setText(CharSequence charsequence);
}
