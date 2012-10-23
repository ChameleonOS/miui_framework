// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.database;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import java.io.Closeable;

// Referenced classes of package android.database:
//            CharArrayBuffer, ContentObserver, DataSetObserver

public interface Cursor
    extends Closeable {

    public abstract void close();

    public abstract void copyStringToBuffer(int i, CharArrayBuffer chararraybuffer);

    public abstract void deactivate();

    public abstract byte[] getBlob(int i);

    public abstract int getColumnCount();

    public abstract int getColumnIndex(String s);

    public abstract int getColumnIndexOrThrow(String s) throws IllegalArgumentException;

    public abstract String getColumnName(int i);

    public abstract String[] getColumnNames();

    public abstract int getCount();

    public abstract double getDouble(int i);

    public abstract Bundle getExtras();

    public abstract float getFloat(int i);

    public abstract int getInt(int i);

    public abstract long getLong(int i);

    public abstract int getPosition();

    public abstract short getShort(int i);

    public abstract String getString(int i);

    public abstract int getType(int i);

    public abstract boolean getWantsAllOnMoveCalls();

    public abstract boolean isAfterLast();

    public abstract boolean isBeforeFirst();

    public abstract boolean isClosed();

    public abstract boolean isFirst();

    public abstract boolean isLast();

    public abstract boolean isNull(int i);

    public abstract boolean move(int i);

    public abstract boolean moveToFirst();

    public abstract boolean moveToLast();

    public abstract boolean moveToNext();

    public abstract boolean moveToPosition(int i);

    public abstract boolean moveToPrevious();

    public abstract void registerContentObserver(ContentObserver contentobserver);

    public abstract void registerDataSetObserver(DataSetObserver datasetobserver);

    public abstract boolean requery();

    public abstract Bundle respond(Bundle bundle);

    public abstract void setNotificationUri(ContentResolver contentresolver, Uri uri);

    public abstract void unregisterContentObserver(ContentObserver contentobserver);

    public abstract void unregisterDataSetObserver(DataSetObserver datasetobserver);

    public static final int FIELD_TYPE_BLOB = 4;
    public static final int FIELD_TYPE_FLOAT = 2;
    public static final int FIELD_TYPE_INTEGER = 1;
    public static final int FIELD_TYPE_NULL = 0;
    public static final int FIELD_TYPE_STRING = 3;
}
