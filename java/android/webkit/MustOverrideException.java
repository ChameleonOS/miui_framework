// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;


class MustOverrideException extends RuntimeException {

    MustOverrideException() {
        super("abstract function called: must be overriden!");
    }
}
