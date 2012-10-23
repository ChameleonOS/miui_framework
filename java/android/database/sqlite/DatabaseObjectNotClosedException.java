// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.database.sqlite;


public class DatabaseObjectNotClosedException extends RuntimeException {

    public DatabaseObjectNotClosedException() {
        super("Application did not close the cursor or database object that was opened here");
    }

    private static final String s = "Application did not close the cursor or database object that was opened here";
}
