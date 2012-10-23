// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.content;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.ArrayList;

public class SelectionBuilder {

    public SelectionBuilder() {
        mSelection = new StringBuilder();
        mSelectionArgs = new ArrayList();
    }

    public transient SelectionBuilder append(String s, Object aobj[]) {
        if(TextUtils.isEmpty(s)) {
            if(aobj != null && aobj.length > 0)
                throw new IllegalArgumentException("Valid selection required when including arguments");
        } else {
            if(mSelection.length() > 0)
                mSelection.append(" AND ");
            mSelection.append("(").append(s).append(")");
            if(aobj != null) {
                int i = aobj.length;
                for(int j = 0; j < i; j++) {
                    Object obj = aobj[j];
                    mSelectionArgs.add(String.valueOf(obj));
                }

            }
        }
        return this;
    }

    public int delete(SQLiteDatabase sqlitedatabase, String s) {
        return sqlitedatabase.delete(s, getSelection(), getSelectionArgs());
    }

    public String getSelection() {
        return mSelection.toString();
    }

    public String[] getSelectionArgs() {
        return (String[])mSelectionArgs.toArray(new String[mSelectionArgs.size()]);
    }

    public Cursor query(SQLiteDatabase sqlitedatabase, String s, String as[], String s1) {
        return query(sqlitedatabase, s, as, null, null, s1, null);
    }

    public Cursor query(SQLiteDatabase sqlitedatabase, String s, String as[], String s1, String s2, String s3, String s4) {
        return sqlitedatabase.query(s, as, getSelection(), getSelectionArgs(), s1, s2, s3, s4);
    }

    public SelectionBuilder reset() {
        mSelection.setLength(0);
        mSelectionArgs.clear();
        return this;
    }

    public int update(SQLiteDatabase sqlitedatabase, String s, ContentValues contentvalues) {
        return sqlitedatabase.update(s, contentvalues, getSelection(), getSelectionArgs());
    }

    private StringBuilder mSelection;
    private ArrayList mSelectionArgs;
}
