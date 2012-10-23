// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.database;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;

// Referenced classes of package android.database:
//            Cursor, CharArrayBuffer, ContentObserver, DataSetObserver

public class CursorWrapper
    implements Cursor {

    public CursorWrapper(Cursor cursor) {
        mCursor = cursor;
    }

    public void close() {
        mCursor.close();
    }

    public void copyStringToBuffer(int i, CharArrayBuffer chararraybuffer) {
        mCursor.copyStringToBuffer(i, chararraybuffer);
    }

    public void deactivate() {
        mCursor.deactivate();
    }

    public byte[] getBlob(int i) {
        return mCursor.getBlob(i);
    }

    public int getColumnCount() {
        return mCursor.getColumnCount();
    }

    public int getColumnIndex(String s) {
        return mCursor.getColumnIndex(s);
    }

    public int getColumnIndexOrThrow(String s) throws IllegalArgumentException {
        return mCursor.getColumnIndexOrThrow(s);
    }

    public String getColumnName(int i) {
        return mCursor.getColumnName(i);
    }

    public String[] getColumnNames() {
        return mCursor.getColumnNames();
    }

    public int getCount() {
        return mCursor.getCount();
    }

    public double getDouble(int i) {
        return mCursor.getDouble(i);
    }

    public Bundle getExtras() {
        return mCursor.getExtras();
    }

    public float getFloat(int i) {
        return mCursor.getFloat(i);
    }

    public int getInt(int i) {
        return mCursor.getInt(i);
    }

    public long getLong(int i) {
        return mCursor.getLong(i);
    }

    public int getPosition() {
        return mCursor.getPosition();
    }

    public short getShort(int i) {
        return mCursor.getShort(i);
    }

    public String getString(int i) {
        return mCursor.getString(i);
    }

    public int getType(int i) {
        return mCursor.getType(i);
    }

    public boolean getWantsAllOnMoveCalls() {
        return mCursor.getWantsAllOnMoveCalls();
    }

    public Cursor getWrappedCursor() {
        return mCursor;
    }

    public boolean isAfterLast() {
        return mCursor.isAfterLast();
    }

    public boolean isBeforeFirst() {
        return mCursor.isBeforeFirst();
    }

    public boolean isClosed() {
        return mCursor.isClosed();
    }

    public boolean isFirst() {
        return mCursor.isFirst();
    }

    public boolean isLast() {
        return mCursor.isLast();
    }

    public boolean isNull(int i) {
        return mCursor.isNull(i);
    }

    public boolean move(int i) {
        return mCursor.move(i);
    }

    public boolean moveToFirst() {
        return mCursor.moveToFirst();
    }

    public boolean moveToLast() {
        return mCursor.moveToLast();
    }

    public boolean moveToNext() {
        return mCursor.moveToNext();
    }

    public boolean moveToPosition(int i) {
        return mCursor.moveToPosition(i);
    }

    public boolean moveToPrevious() {
        return mCursor.moveToPrevious();
    }

    public void registerContentObserver(ContentObserver contentobserver) {
        mCursor.registerContentObserver(contentobserver);
    }

    public void registerDataSetObserver(DataSetObserver datasetobserver) {
        mCursor.registerDataSetObserver(datasetobserver);
    }

    public boolean requery() {
        return mCursor.requery();
    }

    public Bundle respond(Bundle bundle) {
        return mCursor.respond(bundle);
    }

    public void setNotificationUri(ContentResolver contentresolver, Uri uri) {
        mCursor.setNotificationUri(contentresolver, uri);
    }

    public void unregisterContentObserver(ContentObserver contentobserver) {
        mCursor.unregisterContentObserver(contentobserver);
    }

    public void unregisterDataSetObserver(DataSetObserver datasetobserver) {
        mCursor.unregisterDataSetObserver(datasetobserver);
    }

    protected final Cursor mCursor;
}
