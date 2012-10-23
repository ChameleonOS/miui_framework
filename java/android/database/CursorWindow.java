// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.database;

import android.content.res.Resources;
import android.database.sqlite.SQLiteClosable;
import android.os.*;
import android.util.Log;
import android.util.SparseIntArray;
import dalvik.system.CloseGuard;

// Referenced classes of package android.database:
//            CursorWindowAllocationException, CharArrayBuffer

public class CursorWindow extends SQLiteClosable
    implements Parcelable {

    private CursorWindow(Parcel parcel) {
        mCloseGuard = CloseGuard.get();
        mStartPos = parcel.readInt();
        mWindowPtr = nativeCreateFromParcel(parcel);
        if(mWindowPtr == 0) {
            throw new CursorWindowAllocationException("Cursor window could not be created from binder.");
        } else {
            mName = nativeGetName(mWindowPtr);
            mCloseGuard.open("close");
            return;
        }
    }


    public CursorWindow(String s) {
        mCloseGuard = CloseGuard.get();
        mStartPos = 0;
        if(s == null || s.length() == 0)
            s = "<unnamed>";
        mName = s;
        mWindowPtr = nativeCreate(mName, sCursorWindowSize);
        if(mWindowPtr == 0) {
            throw new CursorWindowAllocationException((new StringBuilder()).append("Cursor window allocation of ").append(sCursorWindowSize / 1024).append(" kb failed. ").append(printStats()).toString());
        } else {
            mCloseGuard.open("close");
            recordNewWindow(Binder.getCallingPid(), mWindowPtr);
            return;
        }
    }

    public CursorWindow(boolean flag) {
        this((String)null);
    }

    private void dispose() {
        if(mCloseGuard != null)
            mCloseGuard.close();
        if(mWindowPtr != 0) {
            recordClosingOfWindow(mWindowPtr);
            nativeDispose(mWindowPtr);
            mWindowPtr = 0;
        }
    }

    private static native boolean nativeAllocRow(int i);

    private static native void nativeClear(int i);

    private static native void nativeCopyStringToBuffer(int i, int j, int k, CharArrayBuffer chararraybuffer);

    private static native int nativeCreate(String s, int i);

    private static native int nativeCreateFromParcel(Parcel parcel);

    private static native void nativeDispose(int i);

    private static native void nativeFreeLastRow(int i);

    private static native byte[] nativeGetBlob(int i, int j, int k);

    private static native double nativeGetDouble(int i, int j, int k);

    private static native long nativeGetLong(int i, int j, int k);

    private static native String nativeGetName(int i);

    private static native int nativeGetNumRows(int i);

    private static native String nativeGetString(int i, int j, int k);

    private static native int nativeGetType(int i, int j, int k);

    private static native boolean nativePutBlob(int i, byte abyte0[], int j, int k);

    private static native boolean nativePutDouble(int i, double d, int j, int k);

    private static native boolean nativePutLong(int i, long l, int j, int k);

    private static native boolean nativePutNull(int i, int j, int k);

    private static native boolean nativePutString(int i, String s, int j, int k);

    private static native boolean nativeSetNumColumns(int i, int j);

    private static native void nativeWriteToParcel(int i, Parcel parcel);

    public static CursorWindow newFromParcel(Parcel parcel) {
        return (CursorWindow)CREATOR.createFromParcel(parcel);
    }

    private String printStats() {
        StringBuilder stringbuilder;
        int i;
        int j;
        SparseIntArray sparseintarray;
        stringbuilder = new StringBuilder();
        i = Process.myPid();
        j = 0;
        sparseintarray = new SparseIntArray();
        SparseIntArray sparseintarray1 = sWindowToPidMap;
        sparseintarray1;
        JVM INSTR monitorenter ;
        int k;
        String s1;
        k = sWindowToPidMap.size();
        if(k != 0)
            break MISSING_BLOCK_LABEL_289;
        s1 = "";
          goto _L1
_L2:
        int l;
        for(; l < k; l++) {
            int i2 = sWindowToPidMap.valueAt(l);
            sparseintarray.put(i2, 1 + sparseintarray.get(i2));
        }

        int i1 = sparseintarray.size();
        int j1 = 0;
        while(j1 < i1)  {
            stringbuilder.append(" (# cursors opened by ");
            int k1 = sparseintarray.keyAt(j1);
            Exception exception;
            int l1;
            if(k1 == i)
                stringbuilder.append("this proc=");
            else
                stringbuilder.append((new StringBuilder()).append("pid ").append(k1).append("=").toString());
            l1 = sparseintarray.get(k1);
            stringbuilder.append((new StringBuilder()).append(l1).append(")").toString());
            j += l1;
            j1++;
        }
        break MISSING_BLOCK_LABEL_228;
        exception;
        sparseintarray1;
        JVM INSTR monitorexit ;
        throw exception;
        String s;
        if(stringbuilder.length() > 980)
            s = stringbuilder.substring(0, 980);
        else
            s = stringbuilder.toString();
        s1 = (new StringBuilder()).append("# Open Cursors=").append(j).append(s).toString();
_L1:
        return s1;
        l = 0;
          goto _L2
    }

    private void recordClosingOfWindow(int i) {
        SparseIntArray sparseintarray = sWindowToPidMap;
        sparseintarray;
        JVM INSTR monitorenter ;
        if(sWindowToPidMap.size() != 0)
            sWindowToPidMap.delete(i);
        return;
    }

    private void recordNewWindow(int i, int j) {
        SparseIntArray sparseintarray = sWindowToPidMap;
        sparseintarray;
        JVM INSTR monitorenter ;
        sWindowToPidMap.put(j, i);
        if(Log.isLoggable("CursorWindowStats", 2))
            Log.i("CursorWindowStats", (new StringBuilder()).append("Created a new Cursor. ").append(printStats()).toString());
        return;
    }

    public boolean allocRow() {
        acquireReference();
        boolean flag = nativeAllocRow(mWindowPtr);
        releaseReference();
        return flag;
        Exception exception;
        exception;
        releaseReference();
        throw exception;
    }

    public void clear() {
        acquireReference();
        mStartPos = 0;
        nativeClear(mWindowPtr);
        releaseReference();
        return;
        Exception exception;
        exception;
        releaseReference();
        throw exception;
    }

    public void copyStringToBuffer(int i, int j, CharArrayBuffer chararraybuffer) {
        if(chararraybuffer == null)
            throw new IllegalArgumentException("CharArrayBuffer should not be null");
        acquireReference();
        nativeCopyStringToBuffer(mWindowPtr, i - mStartPos, j, chararraybuffer);
        releaseReference();
        return;
        Exception exception;
        exception;
        releaseReference();
        throw exception;
    }

    public int describeContents() {
        return 0;
    }

    protected void finalize() throws Throwable {
        if(mCloseGuard != null)
            mCloseGuard.warnIfOpen();
        dispose();
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public void freeLastRow() {
        acquireReference();
        nativeFreeLastRow(mWindowPtr);
        releaseReference();
        return;
        Exception exception;
        exception;
        releaseReference();
        throw exception;
    }

    public byte[] getBlob(int i, int j) {
        acquireReference();
        byte abyte0[] = nativeGetBlob(mWindowPtr, i - mStartPos, j);
        releaseReference();
        return abyte0;
        Exception exception;
        exception;
        releaseReference();
        throw exception;
    }

    public double getDouble(int i, int j) {
        acquireReference();
        double d = nativeGetDouble(mWindowPtr, i - mStartPos, j);
        releaseReference();
        return d;
        Exception exception;
        exception;
        releaseReference();
        throw exception;
    }

    public float getFloat(int i, int j) {
        return (float)getDouble(i, j);
    }

    public int getInt(int i, int j) {
        return (int)getLong(i, j);
    }

    public long getLong(int i, int j) {
        acquireReference();
        long l = nativeGetLong(mWindowPtr, i - mStartPos, j);
        releaseReference();
        return l;
        Exception exception;
        exception;
        releaseReference();
        throw exception;
    }

    public String getName() {
        return mName;
    }

    public int getNumRows() {
        acquireReference();
        int i = nativeGetNumRows(mWindowPtr);
        releaseReference();
        return i;
        Exception exception;
        exception;
        releaseReference();
        throw exception;
    }

    public short getShort(int i, int j) {
        return (short)(int)getLong(i, j);
    }

    public int getStartPosition() {
        return mStartPos;
    }

    public String getString(int i, int j) {
        acquireReference();
        String s = nativeGetString(mWindowPtr, i - mStartPos, j);
        releaseReference();
        return s;
        Exception exception;
        exception;
        releaseReference();
        throw exception;
    }

    public int getType(int i, int j) {
        acquireReference();
        int k = nativeGetType(mWindowPtr, i - mStartPos, j);
        releaseReference();
        return k;
        Exception exception;
        exception;
        releaseReference();
        throw exception;
    }

    public boolean isBlob(int i, int j) {
        int k = getType(i, j);
        boolean flag;
        if(k == 4 || k == 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isFloat(int i, int j) {
        boolean flag;
        if(getType(i, j) == 2)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isLong(int i, int j) {
        boolean flag = true;
        if(getType(i, j) != flag)
            flag = false;
        return flag;
    }

    public boolean isNull(int i, int j) {
        boolean flag;
        if(getType(i, j) == 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isString(int i, int j) {
        int k = getType(i, j);
        boolean flag;
        if(k == 3 || k == 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    protected void onAllReferencesReleased() {
        dispose();
    }

    public boolean putBlob(byte abyte0[], int i, int j) {
        acquireReference();
        boolean flag = nativePutBlob(mWindowPtr, abyte0, i - mStartPos, j);
        releaseReference();
        return flag;
        Exception exception;
        exception;
        releaseReference();
        throw exception;
    }

    public boolean putDouble(double d, int i, int j) {
        acquireReference();
        boolean flag = nativePutDouble(mWindowPtr, d, i - mStartPos, j);
        releaseReference();
        return flag;
        Exception exception;
        exception;
        releaseReference();
        throw exception;
    }

    public boolean putLong(long l, int i, int j) {
        acquireReference();
        boolean flag = nativePutLong(mWindowPtr, l, i - mStartPos, j);
        releaseReference();
        return flag;
        Exception exception;
        exception;
        releaseReference();
        throw exception;
    }

    public boolean putNull(int i, int j) {
        acquireReference();
        boolean flag = nativePutNull(mWindowPtr, i - mStartPos, j);
        releaseReference();
        return flag;
        Exception exception;
        exception;
        releaseReference();
        throw exception;
    }

    public boolean putString(String s, int i, int j) {
        acquireReference();
        boolean flag = nativePutString(mWindowPtr, s, i - mStartPos, j);
        releaseReference();
        return flag;
        Exception exception;
        exception;
        releaseReference();
        throw exception;
    }

    public boolean setNumColumns(int i) {
        acquireReference();
        boolean flag = nativeSetNumColumns(mWindowPtr, i);
        releaseReference();
        return flag;
        Exception exception;
        exception;
        releaseReference();
        throw exception;
    }

    public void setStartPosition(int i) {
        mStartPos = i;
    }

    public String toString() {
        return (new StringBuilder()).append(getName()).append(" {").append(Integer.toHexString(mWindowPtr)).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        acquireReference();
        parcel.writeInt(mStartPos);
        nativeWriteToParcel(mWindowPtr, parcel);
        releaseReference();
        if((i & 1) != 0)
            releaseReference();
        return;
        Exception exception;
        exception;
        releaseReference();
        throw exception;
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public CursorWindow createFromParcel(Parcel parcel) {
            return new CursorWindow(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public CursorWindow[] newArray(int i) {
            return new CursorWindow[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private static final String STATS_TAG = "CursorWindowStats";
    private static final int sCursorWindowSize = 1024 * Resources.getSystem().getInteger(0x10e002f);
    private static final SparseIntArray sWindowToPidMap = new SparseIntArray();
    private final CloseGuard mCloseGuard;
    private final String mName;
    private int mStartPos;
    public int mWindowPtr;

}
