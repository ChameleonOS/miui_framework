// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.nfc;

import java.io.IOException;

public class TagLostException extends IOException {

    public TagLostException() {
    }

    public TagLostException(String s) {
        super(s);
    }
}
