// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.database;

import android.database.sqlite.SQLiteDatabase;

public interface DatabaseErrorHandler {

    public abstract void onCorruption(SQLiteDatabase sqlitedatabase);
}
