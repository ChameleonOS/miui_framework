// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;

import com.android.internal.os.IDropBoxManagerService;
import java.io.*;
import java.util.zip.GZIPInputStream;

// Referenced classes of package android.os:
//            RemoteException, Parcelable, ParcelFileDescriptor, Parcel

public class DropBoxManager {
    public static class Entry
        implements Parcelable, Closeable {

        public void close() {
            if(mFileDescriptor != null)
                mFileDescriptor.close();
_L2:
            return;
            IOException ioexception;
            ioexception;
            if(true) goto _L2; else goto _L1
_L1:
        }

        public int describeContents() {
            int i;
            if(mFileDescriptor != null)
                i = 1;
            else
                i = 0;
            return i;
        }

        public int getFlags() {
            return -5 & mFlags;
        }

        public InputStream getInputStream() throws IOException {
            Object obj;
            if(mData != null) {
                obj = new ByteArrayInputStream(mData);
            } else {
label0:
                {
                    if(mFileDescriptor == null)
                        break label0;
                    obj = new ParcelFileDescriptor.AutoCloseInputStream(mFileDescriptor);
                }
            }
            if((4 & mFlags) != 0)
                obj = new GZIPInputStream(((InputStream) (obj)));
_L2:
            return ((InputStream) (obj));
            obj = null;
            if(true) goto _L2; else goto _L1
_L1:
        }

        public String getTag() {
            return mTag;
        }

        public String getText(int i) {
            String s = null;
            if((2 & mFlags) != 0) goto _L2; else goto _L1
_L1:
            return s;
_L2:
            InputStream inputstream;
            if(mData != null) {
                s = new String(mData, 0, Math.min(i, mData.length));
                continue; /* Loop/switch isn't completed */
            }
            inputstream = null;
            InputStream inputstream1 = getInputStream();
            inputstream = inputstream1;
            if(inputstream == null) {
                if(inputstream != null)
                    try {
                        inputstream.close();
                    }
                    catch(IOException ioexception4) { }
                continue; /* Loop/switch isn't completed */
            }
            String s1;
            byte abyte0[] = new byte[i];
            int j = 0;
            int k = 0;
            do {
                if(k < 0)
                    break;
                j += k;
                if(j >= i)
                    break;
                k = inputstream.read(abyte0, j, i - j);
            } while(true);
            s1 = new String(abyte0, 0, j);
            Exception exception;
            IOException ioexception1;
            IOException ioexception2;
            if(inputstream != null)
                try {
                    inputstream.close();
                }
                catch(IOException ioexception3) { }
            s = s1;
            continue; /* Loop/switch isn't completed */
            ioexception1;
            if(inputstream != null)
                try {
                    inputstream.close();
                }
                // Misplaced declaration of an exception variable
                catch(IOException ioexception2) { }
            if(true) goto _L1; else goto _L3
_L3:
            exception;
            if(inputstream != null)
                try {
                    inputstream.close();
                }
                catch(IOException ioexception) { }
            throw exception;
        }

        public long getTimeMillis() {
            return mTimeMillis;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(mTag);
            parcel.writeLong(mTimeMillis);
            if(mFileDescriptor != null) {
                parcel.writeInt(-9 & mFlags);
                mFileDescriptor.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(8 | mFlags);
                parcel.writeByteArray(mData);
            }
        }

        public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

            public Entry createFromParcel(Parcel parcel) {
                String s = parcel.readString();
                long l = parcel.readLong();
                int i = parcel.readInt();
                Entry entry;
                if((i & 8) != 0)
                    entry = new Entry(s, l, parcel.createByteArray(), i & -9);
                else
                    entry = new Entry(s, l, parcel.readFileDescriptor(), i);
                return entry;
            }

            public volatile Object createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            public Entry[] newArray(int i) {
                return new Entry[i];
            }

            public volatile Object[] newArray(int i) {
                return newArray(i);
            }

        };
        private final byte mData[];
        private final ParcelFileDescriptor mFileDescriptor;
        private final int mFlags;
        private final String mTag;
        private final long mTimeMillis;


        public Entry(String s, long l) {
            if(s == null) {
                throw new NullPointerException("tag == null");
            } else {
                mTag = s;
                mTimeMillis = l;
                mData = null;
                mFileDescriptor = null;
                mFlags = 1;
                return;
            }
        }

        public Entry(String s, long l, ParcelFileDescriptor parcelfiledescriptor, int i) {
            boolean flag = true;
            super();
            if(s == null)
                throw new NullPointerException("tag == null");
            boolean flag1;
            if((i & 1) != 0)
                flag1 = flag;
            else
                flag1 = false;
            if(parcelfiledescriptor != null)
                flag = false;
            if(flag1 != flag) {
                throw new IllegalArgumentException((new StringBuilder()).append("Bad flags: ").append(i).toString());
            } else {
                mTag = s;
                mTimeMillis = l;
                mData = null;
                mFileDescriptor = parcelfiledescriptor;
                mFlags = i;
                return;
            }
        }

        public Entry(String s, long l, File file, int i) throws IOException {
            if(s == null)
                throw new NullPointerException("tag == null");
            if((i & 1) != 0) {
                throw new IllegalArgumentException((new StringBuilder()).append("Bad flags: ").append(i).toString());
            } else {
                mTag = s;
                mTimeMillis = l;
                mData = null;
                mFileDescriptor = ParcelFileDescriptor.open(file, 0x10000000);
                mFlags = i;
                return;
            }
        }

        public Entry(String s, long l, String s1) {
            if(s == null)
                throw new NullPointerException("tag == null");
            if(s1 == null) {
                throw new NullPointerException("text == null");
            } else {
                mTag = s;
                mTimeMillis = l;
                mData = s1.getBytes();
                mFileDescriptor = null;
                mFlags = 2;
                return;
            }
        }

        public Entry(String s, long l, byte abyte0[], int i) {
            boolean flag = true;
            super();
            if(s == null)
                throw new NullPointerException("tag == null");
            boolean flag1;
            if((i & 1) != 0)
                flag1 = flag;
            else
                flag1 = false;
            if(abyte0 != null)
                flag = false;
            if(flag1 != flag) {
                throw new IllegalArgumentException((new StringBuilder()).append("Bad flags: ").append(i).toString());
            } else {
                mTag = s;
                mTimeMillis = l;
                mData = abyte0;
                mFileDescriptor = null;
                mFlags = i;
                return;
            }
        }
    }


    protected DropBoxManager() {
        mService = null;
    }

    public DropBoxManager(IDropBoxManagerService idropboxmanagerservice) {
        mService = idropboxmanagerservice;
    }

    public void addData(String s, byte abyte0[], int i) {
        if(abyte0 == null)
            throw new NullPointerException("data == null");
        mService.add(new Entry(s, 0L, abyte0, i));
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void addFile(String s, File file, int i) throws IOException {
        Entry entry;
        if(file == null)
            throw new NullPointerException("file == null");
        entry = new Entry(s, 0L, file, i);
        mService.add(entry);
        entry.close();
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        entry.close();
        if(true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        entry.close();
        throw exception;
    }

    public void addText(String s, String s1) {
        mService.add(new Entry(s, 0L, s1));
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public Entry getNextEntry(String s, long l) {
        Entry entry1 = mService.getNextEntry(s, l);
        Entry entry = entry1;
_L2:
        return entry;
        RemoteException remoteexception;
        remoteexception;
        entry = null;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public boolean isTagEnabled(String s) {
        boolean flag1 = mService.isTagEnabled(s);
        boolean flag = flag1;
_L2:
        return flag;
        RemoteException remoteexception;
        remoteexception;
        flag = false;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public static final String ACTION_DROPBOX_ENTRY_ADDED = "android.intent.action.DROPBOX_ENTRY_ADDED";
    public static final String EXTRA_TAG = "tag";
    public static final String EXTRA_TIME = "time";
    private static final int HAS_BYTE_ARRAY = 8;
    public static final int IS_EMPTY = 1;
    public static final int IS_GZIPPED = 4;
    public static final int IS_TEXT = 2;
    private static final String TAG = "DropBoxManager";
    private final IDropBoxManagerService mService;
}
