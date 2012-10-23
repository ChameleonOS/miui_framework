// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.res;

import android.os.*;
import java.io.*;

public class AssetFileDescriptor
    implements Parcelable {
    public static class AutoCloseOutputStream extends android.os.ParcelFileDescriptor.AutoCloseOutputStream {

        public void write(int i) throws IOException {
            if(mRemaining >= 0L) {
                if(mRemaining != 0L) {
                    super.write(i);
                    mRemaining = mRemaining - 1L;
                }
            } else {
                super.write(i);
            }
        }

        public void write(byte abyte0[]) throws IOException {
            if(mRemaining >= 0L) {
                if(mRemaining != 0L) {
                    int i = abyte0.length;
                    if((long)i > mRemaining)
                        i = (int)mRemaining;
                    super.write(abyte0);
                    mRemaining = mRemaining - (long)i;
                }
            } else {
                super.write(abyte0);
            }
        }

        public void write(byte abyte0[], int i, int j) throws IOException {
            if(mRemaining >= 0L) {
                if(mRemaining != 0L) {
                    if((long)j > mRemaining)
                        j = (int)mRemaining;
                    super.write(abyte0, i, j);
                    mRemaining = mRemaining - (long)j;
                }
            } else {
                super.write(abyte0, i, j);
            }
        }

        private long mRemaining;

        public AutoCloseOutputStream(AssetFileDescriptor assetfiledescriptor) throws IOException {
            super(assetfiledescriptor.getParcelFileDescriptor());
            if(assetfiledescriptor.getParcelFileDescriptor().seekTo(assetfiledescriptor.getStartOffset()) < 0L) {
                throw new IOException("Unable to seek");
            } else {
                mRemaining = (int)assetfiledescriptor.getLength();
                return;
            }
        }
    }

    public static class AutoCloseInputStream extends android.os.ParcelFileDescriptor.AutoCloseInputStream {

        public int available() throws IOException {
            int i;
            if(mRemaining >= 0L) {
                if(mRemaining < 0x7fffffffL)
                    i = (int)mRemaining;
                else
                    i = 0x7fffffff;
            } else {
                i = super.available();
            }
            return i;
        }

        public void mark(int i) {
            if(mRemaining < 0L)
                super.mark(i);
        }

        public boolean markSupported() {
            boolean flag;
            if(mRemaining >= 0L)
                flag = false;
            else
                flag = super.markSupported();
            return flag;
        }

        public int read() throws IOException {
            int i = -1;
            byte abyte0[] = new byte[1];
            if(read(abyte0, 0, 1) != i)
                i = 0xff & abyte0[0];
            return i;
        }

        public int read(byte abyte0[]) throws IOException {
            return read(abyte0, 0, abyte0.length);
        }

        public int read(byte abyte0[], int i, int j) throws IOException {
            if(mRemaining < 0L) goto _L2; else goto _L1
_L1:
            if(mRemaining != 0L) goto _L4; else goto _L3
_L3:
            int k = -1;
_L6:
            return k;
_L4:
            if((long)j > mRemaining)
                j = (int)mRemaining;
            k = super.read(abyte0, i, j);
            if(k >= 0)
                mRemaining = mRemaining - (long)k;
            continue; /* Loop/switch isn't completed */
_L2:
            k = super.read(abyte0, i, j);
            if(true) goto _L6; else goto _L5
_L5:
        }

        /**
         * @deprecated Method reset is deprecated
         */

        public void reset() throws IOException {
            this;
            JVM INSTR monitorenter ;
            long l = mRemaining;
            if(l < 0L) goto _L2; else goto _L1
_L1:
            this;
            JVM INSTR monitorexit ;
            return;
_L2:
            super.reset();
            if(true) goto _L1; else goto _L3
_L3:
            Exception exception;
            exception;
            throw exception;
        }

        public long skip(long l) throws IOException {
            if(mRemaining < 0L) goto _L2; else goto _L1
_L1:
            if(mRemaining != 0L) goto _L4; else goto _L3
_L3:
            long l1 = -1L;
_L6:
            return l1;
_L4:
            if(l > mRemaining)
                l = mRemaining;
            l1 = super.skip(l);
            if(l1 >= 0L)
                mRemaining = mRemaining - l1;
            continue; /* Loop/switch isn't completed */
_L2:
            l1 = super.skip(l);
            if(true) goto _L6; else goto _L5
_L5:
        }

        private long mRemaining;

        public AutoCloseInputStream(AssetFileDescriptor assetfiledescriptor) throws IOException {
            super(assetfiledescriptor.getParcelFileDescriptor());
            super.skip(assetfiledescriptor.getStartOffset());
            mRemaining = (int)assetfiledescriptor.getLength();
        }
    }


    AssetFileDescriptor(Parcel parcel) {
        mFd = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
        mStartOffset = parcel.readLong();
        mLength = parcel.readLong();
    }

    public AssetFileDescriptor(ParcelFileDescriptor parcelfiledescriptor, long l, long l1) {
        if(parcelfiledescriptor == null)
            throw new IllegalArgumentException("fd must not be null");
        if(l1 < 0L && l != 0L) {
            throw new IllegalArgumentException("startOffset must be 0 when using UNKNOWN_LENGTH");
        } else {
            mFd = parcelfiledescriptor;
            mStartOffset = l;
            mLength = l1;
            return;
        }
    }

    public void close() throws IOException {
        mFd.close();
    }

    public FileInputStream createInputStream() throws IOException {
        Object obj;
        if(mLength < 0L)
            obj = new android.os.ParcelFileDescriptor.AutoCloseInputStream(mFd);
        else
            obj = new AutoCloseInputStream(this);
        return ((FileInputStream) (obj));
    }

    public FileOutputStream createOutputStream() throws IOException {
        Object obj;
        if(mLength < 0L)
            obj = new android.os.ParcelFileDescriptor.AutoCloseOutputStream(mFd);
        else
            obj = new AutoCloseOutputStream(this);
        return ((FileOutputStream) (obj));
    }

    public int describeContents() {
        return mFd.describeContents();
    }

    public long getDeclaredLength() {
        return mLength;
    }

    public FileDescriptor getFileDescriptor() {
        return mFd.getFileDescriptor();
    }

    public long getLength() {
        if(mLength < 0L) goto _L2; else goto _L1
_L1:
        long l = mLength;
_L4:
        return l;
_L2:
        l = mFd.getStatSize();
        if(l < 0L)
            l = -1L;
        if(true) goto _L4; else goto _L3
_L3:
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        return mFd;
    }

    public long getStartOffset() {
        return mStartOffset;
    }

    public String toString() {
        return (new StringBuilder()).append("{AssetFileDescriptor: ").append(mFd).append(" start=").append(mStartOffset).append(" len=").append(mLength).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        mFd.writeToParcel(parcel, i);
        parcel.writeLong(mStartOffset);
        parcel.writeLong(mLength);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public AssetFileDescriptor createFromParcel(Parcel parcel) {
            return new AssetFileDescriptor(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public AssetFileDescriptor[] newArray(int i) {
            return new AssetFileDescriptor[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final long UNKNOWN_LENGTH = -1L;
    private final ParcelFileDescriptor mFd;
    private final long mLength;
    private final long mStartOffset;

}
