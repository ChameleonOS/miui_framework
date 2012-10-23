// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;

import android.text.TextUtils;
import android.util.*;
import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

// Referenced classes of package android.os:
//            IBinder, Bundle, BadParcelableException, StrictMode, 
//            ParcelFileDescriptor, Parcelable, IInterface

public final class Parcel {

    private Parcel(int i) {
        init(i);
    }

    static native void clearFileDescriptor(FileDescriptor filedescriptor);

    static native void closeFileDescriptor(FileDescriptor filedescriptor) throws IOException;

    private void destroy() {
        if(mNativePtr != 0) {
            if(mOwnsNativeParcelObject)
                nativeDestroy(mNativePtr);
            mNativePtr = 0;
        }
    }

    static native FileDescriptor dupFileDescriptor(FileDescriptor filedescriptor) throws IOException;

    private void freeBuffer() {
        if(mOwnsNativeParcelObject)
            nativeFreeBuffer(mNativePtr);
    }

    private void init(int i) {
        if(i != 0) {
            mNativePtr = i;
            mOwnsNativeParcelObject = false;
        } else {
            mNativePtr = nativeCreate();
            mOwnsNativeParcelObject = true;
        }
    }

    private static native void nativeAppendFrom(int i, int j, int k, int l);

    private static native int nativeCreate();

    private static native byte[] nativeCreateByteArray(int i);

    private static native int nativeDataAvail(int i);

    private static native int nativeDataCapacity(int i);

    private static native int nativeDataPosition(int i);

    private static native int nativeDataSize(int i);

    private static native void nativeDestroy(int i);

    private static native void nativeEnforceInterface(int i, String s);

    private static native void nativeFreeBuffer(int i);

    private static native boolean nativeHasFileDescriptors(int i);

    private static native byte[] nativeMarshall(int i);

    private static native boolean nativePushAllowFds(int i, boolean flag);

    private static native double nativeReadDouble(int i);

    private static native FileDescriptor nativeReadFileDescriptor(int i);

    private static native float nativeReadFloat(int i);

    private static native int nativeReadInt(int i);

    private static native long nativeReadLong(int i);

    private static native String nativeReadString(int i);

    private static native IBinder nativeReadStrongBinder(int i);

    private static native void nativeRestoreAllowFds(int i, boolean flag);

    private static native void nativeSetDataCapacity(int i, int j);

    private static native void nativeSetDataPosition(int i, int j);

    private static native void nativeSetDataSize(int i, int j);

    private static native void nativeUnmarshall(int i, byte abyte0[], int j, int k);

    private static native void nativeWriteByteArray(int i, byte abyte0[], int j, int k);

    private static native void nativeWriteDouble(int i, double d);

    private static native void nativeWriteFileDescriptor(int i, FileDescriptor filedescriptor);

    private static native void nativeWriteFloat(int i, float f);

    private static native void nativeWriteInt(int i, int j);

    private static native void nativeWriteInterfaceToken(int i, String s);

    private static native void nativeWriteLong(int i, long l);

    private static native void nativeWriteString(int i, String s);

    private static native void nativeWriteStrongBinder(int i, IBinder ibinder);

    public static Parcel obtain() {
        Parcel aparcel[] = sOwnedPool;
        aparcel;
        JVM INSTR monitorenter ;
        int i = 0;
_L2:
        if(i >= 6)
            break MISSING_BLOCK_LABEL_32;
        Parcel parcel;
        parcel = aparcel[i];
        if(parcel == null)
            break MISSING_BLOCK_LABEL_52;
        aparcel[i] = null;
        aparcel;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_50;
        parcel = new Parcel(0);
        break MISSING_BLOCK_LABEL_50;
        Exception exception;
        exception;
        aparcel;
        JVM INSTR monitorexit ;
        throw exception;
        return parcel;
        i++;
        if(true) goto _L2; else goto _L1
_L1:
    }

    protected static final Parcel obtain(int i) {
        Parcel aparcel[] = sHolderPool;
        aparcel;
        JVM INSTR monitorenter ;
        int j = 0;
_L2:
        if(j >= 6)
            break MISSING_BLOCK_LABEL_40;
        Parcel parcel;
        parcel = aparcel[j];
        if(parcel == null)
            break MISSING_BLOCK_LABEL_62;
        aparcel[j] = null;
        parcel.init(i);
        aparcel;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_59;
        parcel = new Parcel(i);
        break MISSING_BLOCK_LABEL_59;
        Exception exception;
        exception;
        aparcel;
        JVM INSTR monitorexit ;
        throw exception;
        return parcel;
        j++;
        if(true) goto _L2; else goto _L1
_L1:
    }

    static native FileDescriptor openFileDescriptor(String s, int i) throws FileNotFoundException;

    private void readArrayInternal(Object aobj[], int i, ClassLoader classloader) {
        for(int j = 0; j < i; j++)
            aobj[j] = readValue(classloader);

    }

    private void readListInternal(List list, int i, ClassLoader classloader) {
        for(; i > 0; i--)
            list.add(readValue(classloader));

    }

    private void readSparseArrayInternal(SparseArray sparsearray, int i, ClassLoader classloader) {
        for(; i > 0; i--)
            sparsearray.append(readInt(), readValue(classloader));

    }

    private void readSparseBooleanArrayInternal(SparseBooleanArray sparsebooleanarray, int i) {
        while(i > 0)  {
            int j = readInt();
            boolean flag;
            if(readByte() == 1)
                flag = true;
            else
                flag = false;
            sparsebooleanarray.append(j, flag);
            i--;
        }
    }

    public final void appendFrom(Parcel parcel, int i, int j) {
        nativeAppendFrom(mNativePtr, parcel.mNativePtr, i, j);
    }

    public final IBinder[] createBinderArray() {
        int i = readInt();
        IBinder aibinder[];
        if(i >= 0) {
            aibinder = new IBinder[i];
            for(int j = 0; j < i; j++)
                aibinder[j] = readStrongBinder();

        } else {
            aibinder = null;
        }
        return aibinder;
    }

    public final ArrayList createBinderArrayList() {
        int i = readInt();
        ArrayList arraylist;
        if(i < 0) {
            arraylist = null;
        } else {
            arraylist = new ArrayList(i);
            while(i > 0)  {
                arraylist.add(readStrongBinder());
                i--;
            }
        }
        return arraylist;
    }

    public final boolean[] createBooleanArray() {
        int i = readInt();
        boolean aflag[];
        if(i >= 0 && i <= dataAvail() >> 2) {
            aflag = new boolean[i];
            int j = 0;
            while(j < i)  {
                boolean flag;
                if(readInt() != 0)
                    flag = true;
                else
                    flag = false;
                aflag[j] = flag;
                j++;
            }
        } else {
            aflag = null;
        }
        return aflag;
    }

    public final byte[] createByteArray() {
        return nativeCreateByteArray(mNativePtr);
    }

    public final char[] createCharArray() {
        int i = readInt();
        char ac[];
        if(i >= 0 && i <= dataAvail() >> 2) {
            ac = new char[i];
            for(int j = 0; j < i; j++)
                ac[j] = (char)readInt();

        } else {
            ac = null;
        }
        return ac;
    }

    public final double[] createDoubleArray() {
        int i = readInt();
        double ad[];
        if(i >= 0 && i <= dataAvail() >> 3) {
            ad = new double[i];
            for(int j = 0; j < i; j++)
                ad[j] = readDouble();

        } else {
            ad = null;
        }
        return ad;
    }

    public final float[] createFloatArray() {
        int i = readInt();
        float af[];
        if(i >= 0 && i <= dataAvail() >> 2) {
            af = new float[i];
            for(int j = 0; j < i; j++)
                af[j] = readFloat();

        } else {
            af = null;
        }
        return af;
    }

    public final int[] createIntArray() {
        int i = readInt();
        int ai[];
        if(i >= 0 && i <= dataAvail() >> 2) {
            ai = new int[i];
            for(int j = 0; j < i; j++)
                ai[j] = readInt();

        } else {
            ai = null;
        }
        return ai;
    }

    public final long[] createLongArray() {
        int i = readInt();
        long al[];
        if(i >= 0 && i <= dataAvail() >> 3) {
            al = new long[i];
            for(int j = 0; j < i; j++)
                al[j] = readLong();

        } else {
            al = null;
        }
        return al;
    }

    public final String[] createStringArray() {
        int i = readInt();
        String as[];
        if(i >= 0) {
            as = new String[i];
            for(int j = 0; j < i; j++)
                as[j] = readString();

        } else {
            as = null;
        }
        return as;
    }

    public final ArrayList createStringArrayList() {
        int i = readInt();
        ArrayList arraylist;
        if(i < 0) {
            arraylist = null;
        } else {
            arraylist = new ArrayList(i);
            while(i > 0)  {
                arraylist.add(readString());
                i--;
            }
        }
        return arraylist;
    }

    public final Object[] createTypedArray(Parcelable.Creator creator) {
        int i = readInt();
        Object aobj[];
        if(i < 0) {
            aobj = null;
        } else {
            aobj = creator.newArray(i);
            int j = 0;
            while(j < i)  {
                if(readInt() != 0)
                    aobj[j] = creator.createFromParcel(this);
                j++;
            }
        }
        return aobj;
    }

    public final ArrayList createTypedArrayList(Parcelable.Creator creator) {
        int i = readInt();
        ArrayList arraylist;
        if(i < 0) {
            arraylist = null;
        } else {
            arraylist = new ArrayList(i);
            while(i > 0)  {
                if(readInt() != 0)
                    arraylist.add(creator.createFromParcel(this));
                else
                    arraylist.add(null);
                i--;
            }
        }
        return arraylist;
    }

    public final int dataAvail() {
        return nativeDataAvail(mNativePtr);
    }

    public final int dataCapacity() {
        return nativeDataCapacity(mNativePtr);
    }

    public final int dataPosition() {
        return nativeDataPosition(mNativePtr);
    }

    public final int dataSize() {
        return nativeDataSize(mNativePtr);
    }

    public final void enforceInterface(String s) {
        nativeEnforceInterface(mNativePtr, s);
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public final boolean hasFileDescriptors() {
        return nativeHasFileDescriptors(mNativePtr);
    }

    public final byte[] marshall() {
        return nativeMarshall(mNativePtr);
    }

    public final boolean pushAllowFds(boolean flag) {
        return nativePushAllowFds(mNativePtr, flag);
    }

    public final Object[] readArray(ClassLoader classloader) {
        int i = readInt();
        Object aobj[];
        if(i < 0) {
            aobj = null;
        } else {
            aobj = new Object[i];
            readArrayInternal(aobj, i, classloader);
        }
        return aobj;
    }

    public final ArrayList readArrayList(ClassLoader classloader) {
        int i = readInt();
        ArrayList arraylist;
        if(i < 0) {
            arraylist = null;
        } else {
            arraylist = new ArrayList(i);
            readListInternal(arraylist, i, classloader);
        }
        return arraylist;
    }

    public final void readBinderArray(IBinder aibinder[]) {
        int i = readInt();
        if(i == aibinder.length) {
            for(int j = 0; j < i; j++)
                aibinder[j] = readStrongBinder();

        } else {
            throw new RuntimeException("bad array lengths");
        }
    }

    public final void readBinderList(List list) {
        int i = list.size();
        int j = readInt();
        int k;
        for(k = 0; k < i && k < j; k++)
            list.set(k, readStrongBinder());

        for(; k < j; k++)
            list.add(readStrongBinder());

        for(; k < i; k++)
            list.remove(j);

    }

    public final void readBooleanArray(boolean aflag[]) {
        int i = readInt();
        if(i == aflag.length) {
            int j = 0;
            while(j < i)  {
                boolean flag;
                if(readInt() != 0)
                    flag = true;
                else
                    flag = false;
                aflag[j] = flag;
                j++;
            }
        } else {
            throw new RuntimeException("bad array lengths");
        }
    }

    public final Bundle readBundle() {
        return readBundle(null);
    }

    public final Bundle readBundle(ClassLoader classloader) {
        int i = readInt();
        if(i >= 0) goto _L2; else goto _L1
_L1:
        Bundle bundle = null;
_L4:
        return bundle;
_L2:
        bundle = new Bundle(this, i);
        if(classloader != null)
            bundle.setClassLoader(classloader);
        if(true) goto _L4; else goto _L3
_L3:
    }

    public final byte readByte() {
        return (byte)(0xff & readInt());
    }

    public final void readByteArray(byte abyte0[]) {
        byte abyte1[] = createByteArray();
        if(abyte1.length == abyte0.length) {
            System.arraycopy(abyte1, 0, abyte0, 0, abyte1.length);
            return;
        } else {
            throw new RuntimeException("bad array lengths");
        }
    }

    public final void readCharArray(char ac[]) {
        int i = readInt();
        if(i == ac.length) {
            for(int j = 0; j < i; j++)
                ac[j] = (char)readInt();

        } else {
            throw new RuntimeException("bad array lengths");
        }
    }

    public final CharSequence readCharSequence() {
        return (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this);
    }

    public final CharSequence[] readCharSequenceArray() {
        CharSequence acharsequence[] = null;
        int i = readInt();
        if(i >= 0) {
            acharsequence = new CharSequence[i];
            for(int j = 0; j < i; j++)
                acharsequence[j] = readCharSequence();

        }
        return acharsequence;
    }

    public final double readDouble() {
        return nativeReadDouble(mNativePtr);
    }

    public final void readDoubleArray(double ad[]) {
        int i = readInt();
        if(i == ad.length) {
            for(int j = 0; j < i; j++)
                ad[j] = readDouble();

        } else {
            throw new RuntimeException("bad array lengths");
        }
    }

    public final void readException() {
        int i = readExceptionCode();
        if(i != 0)
            readException(i, readString());
    }

    public final void readException(int i, String s) {
        switch(i) {
        default:
            throw new RuntimeException((new StringBuilder()).append("Unknown exception code: ").append(i).append(" msg ").append(s).toString());

        case -1: 
            throw new SecurityException(s);

        case -2: 
            throw new BadParcelableException(s);

        case -3: 
            throw new IllegalArgumentException(s);

        case -4: 
            throw new NullPointerException(s);

        case -5: 
            throw new IllegalStateException(s);
        }
    }

    public final int readExceptionCode() {
        int i = readInt();
        if(i == -128) {
            if(readInt() == 0)
                Log.e("Parcel", "Unexpected zero-sized Parcel reply header.");
            else
                StrictMode.readAndHandleBinderCallViolations(this);
            i = 0;
        }
        return i;
    }

    public final ParcelFileDescriptor readFileDescriptor() {
        FileDescriptor filedescriptor = nativeReadFileDescriptor(mNativePtr);
        ParcelFileDescriptor parcelfiledescriptor;
        if(filedescriptor != null)
            parcelfiledescriptor = new ParcelFileDescriptor(filedescriptor);
        else
            parcelfiledescriptor = null;
        return parcelfiledescriptor;
    }

    public final float readFloat() {
        return nativeReadFloat(mNativePtr);
    }

    public final void readFloatArray(float af[]) {
        int i = readInt();
        if(i == af.length) {
            for(int j = 0; j < i; j++)
                af[j] = readFloat();

        } else {
            throw new RuntimeException("bad array lengths");
        }
    }

    public final HashMap readHashMap(ClassLoader classloader) {
        int i = readInt();
        HashMap hashmap;
        if(i < 0) {
            hashmap = null;
        } else {
            hashmap = new HashMap(i);
            readMapInternal(hashmap, i, classloader);
        }
        return hashmap;
    }

    public final int readInt() {
        return nativeReadInt(mNativePtr);
    }

    public final void readIntArray(int ai[]) {
        int i = readInt();
        if(i == ai.length) {
            for(int j = 0; j < i; j++)
                ai[j] = readInt();

        } else {
            throw new RuntimeException("bad array lengths");
        }
    }

    public final void readList(List list, ClassLoader classloader) {
        readListInternal(list, readInt(), classloader);
    }

    public final long readLong() {
        return nativeReadLong(mNativePtr);
    }

    public final void readLongArray(long al[]) {
        int i = readInt();
        if(i == al.length) {
            for(int j = 0; j < i; j++)
                al[j] = readLong();

        } else {
            throw new RuntimeException("bad array lengths");
        }
    }

    public final void readMap(Map map, ClassLoader classloader) {
        readMapInternal(map, readInt(), classloader);
    }

    void readMapInternal(Map map, int i, ClassLoader classloader) {
        for(; i > 0; i--)
            map.put(readValue(classloader), readValue(classloader));

    }

    public final Parcelable readParcelable(ClassLoader classloader) {
        Parcelable parcelable;
        String s;
        parcelable = null;
        s = readString();
        if(s != null) goto _L2; else goto _L1
_L1:
        return parcelable;
_L2:
        HashMap hashmap = mCreators;
        hashmap;
        JVM INSTR monitorenter ;
        HashMap hashmap1;
        Parcelable.Creator creator;
        hashmap1 = (HashMap)mCreators.get(classloader);
        if(hashmap1 == null) {
            hashmap1 = new HashMap();
            mCreators.put(classloader, hashmap1);
        }
        creator = (Parcelable.Creator)hashmap1.get(s);
        if(creator != null)
            break MISSING_BLOCK_LABEL_359;
        if(classloader != null) goto _L4; else goto _L3
_L3:
        Class class2 = Class.forName(s);
_L5:
        creator = (Parcelable.Creator)class2.getField("CREATOR").get(null);
        if(creator == null)
            throw new BadParcelableException((new StringBuilder()).append("Parcelable protocol requires a Parcelable.Creator object called  CREATOR on class ").append(s).toString());
        break MISSING_BLOCK_LABEL_350;
        Exception exception;
        exception;
        throw exception;
_L4:
        Class class1 = Class.forName(s, true, classloader);
        class2 = class1;
          goto _L5
        IllegalAccessException illegalaccessexception;
        illegalaccessexception;
        Log.e("Parcel", (new StringBuilder()).append("Class not found when unmarshalling: ").append(s).append(", e: ").append(illegalaccessexception).toString());
        throw new BadParcelableException((new StringBuilder()).append("IllegalAccessException when unmarshalling: ").append(s).toString());
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        Log.e("Parcel", (new StringBuilder()).append("Class not found when unmarshalling: ").append(s).append(", e: ").append(classnotfoundexception).toString());
        throw new BadParcelableException((new StringBuilder()).append("ClassNotFoundException when unmarshalling: ").append(s).toString());
        ClassCastException classcastexception;
        classcastexception;
        throw new BadParcelableException((new StringBuilder()).append("Parcelable protocol requires a Parcelable.Creator object called  CREATOR on class ").append(s).toString());
        NoSuchFieldException nosuchfieldexception;
        nosuchfieldexception;
        throw new BadParcelableException((new StringBuilder()).append("Parcelable protocol requires a Parcelable.Creator object called  CREATOR on class ").append(s).toString());
        hashmap1.put(s, creator);
        hashmap;
        JVM INSTR monitorexit ;
        if(creator instanceof Parcelable.ClassLoaderCreator)
            parcelable = (Parcelable)((Parcelable.ClassLoaderCreator)creator).createFromParcel(this, classloader);
        else
            parcelable = (Parcelable)creator.createFromParcel(this);
        if(true) goto _L1; else goto _L6
_L6:
    }

    public final Parcelable[] readParcelableArray(ClassLoader classloader) {
        int i = readInt();
        Parcelable aparcelable[];
        if(i < 0) {
            aparcelable = null;
        } else {
            aparcelable = new Parcelable[i];
            int j = 0;
            while(j < i)  {
                aparcelable[j] = readParcelable(classloader);
                j++;
            }
        }
        return aparcelable;
    }

    public final Serializable readSerializable() {
        String s = readString();
        Serializable serializable;
        if(s == null) {
            serializable = null;
        } else {
            ByteArrayInputStream bytearrayinputstream = new ByteArrayInputStream(createByteArray());
            try {
                serializable = (Serializable)(new ObjectInputStream(bytearrayinputstream)).readObject();
            }
            catch(IOException ioexception) {
                throw new RuntimeException((new StringBuilder()).append("Parcelable encountered IOException reading a Serializable object (name = ").append(s).append(")").toString(), ioexception);
            }
            catch(ClassNotFoundException classnotfoundexception) {
                throw new RuntimeException((new StringBuilder()).append("Parcelable encounteredClassNotFoundException reading a Serializable object (name = ").append(s).append(")").toString(), classnotfoundexception);
            }
        }
        return serializable;
    }

    public final SparseArray readSparseArray(ClassLoader classloader) {
        int i = readInt();
        SparseArray sparsearray;
        if(i < 0) {
            sparsearray = null;
        } else {
            sparsearray = new SparseArray(i);
            readSparseArrayInternal(sparsearray, i, classloader);
        }
        return sparsearray;
    }

    public final SparseBooleanArray readSparseBooleanArray() {
        int i = readInt();
        SparseBooleanArray sparsebooleanarray;
        if(i < 0) {
            sparsebooleanarray = null;
        } else {
            sparsebooleanarray = new SparseBooleanArray(i);
            readSparseBooleanArrayInternal(sparsebooleanarray, i);
        }
        return sparsebooleanarray;
    }

    public final String readString() {
        return nativeReadString(mNativePtr);
    }

    public final void readStringArray(String as[]) {
        int i = readInt();
        if(i == as.length) {
            for(int j = 0; j < i; j++)
                as[j] = readString();

        } else {
            throw new RuntimeException("bad array lengths");
        }
    }

    public final String[] readStringArray() {
        String as[] = null;
        int i = readInt();
        if(i >= 0) {
            as = new String[i];
            for(int j = 0; j < i; j++)
                as[j] = readString();

        }
        return as;
    }

    public final void readStringList(List list) {
        int i = list.size();
        int j = readInt();
        int k;
        for(k = 0; k < i && k < j; k++)
            list.set(k, readString());

        for(; k < j; k++)
            list.add(readString());

        for(; k < i; k++)
            list.remove(j);

    }

    public final IBinder readStrongBinder() {
        return nativeReadStrongBinder(mNativePtr);
    }

    public final void readTypedArray(Object aobj[], Parcelable.Creator creator) {
        int i = readInt();
        if(i == aobj.length) {
            int j = 0;
            while(j < i)  {
                if(readInt() != 0)
                    aobj[j] = creator.createFromParcel(this);
                else
                    aobj[j] = null;
                j++;
            }
        } else {
            throw new RuntimeException("bad array lengths");
        }
    }

    public final Object[] readTypedArray(Parcelable.Creator creator) {
        return createTypedArray(creator);
    }

    public final void readTypedList(List list, Parcelable.Creator creator) {
        int i = list.size();
        int j = readInt();
        int k = 0;
        while(k < i && k < j)  {
            if(readInt() != 0)
                list.set(k, creator.createFromParcel(this));
            else
                list.set(k, null);
            k++;
        }
        while(k < j)  {
            if(readInt() != 0)
                list.add(creator.createFromParcel(this));
            else
                list.add(null);
            k++;
        }
        for(; k < i; k++)
            list.remove(j);

    }

    public final Object readValue(ClassLoader classloader) {
        boolean flag;
        int i;
        flag = true;
        i = readInt();
        i;
        JVM INSTR tableswitch -1 24: default 128
    //                   -1 186
    //                   0 192
    //                   1 201
    //                   2 213
    //                   3 446
    //                   4 223
    //                   5 233
    //                   6 246
    //                   7 258
    //                   8 270
    //                   9 282
    //                   10 304
    //                   11 313
    //                   12 427
    //                   13 332
    //                   14 341
    //                   15 359
    //                   16 417
    //                   17 368
    //                   18 378
    //                   19 387
    //                   20 396
    //                   21 408
    //                   22 437
    //                   23 323
    //                   24 350;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27
_L1:
        int j = -4 + dataPosition();
        throw new RuntimeException((new StringBuilder()).append("Parcel ").append(this).append(": Unmarshalling unknown type code ").append(i).append(" at offset ").append(j).toString());
_L2:
        Object obj = null;
_L29:
        return obj;
_L3:
        obj = readString();
        continue; /* Loop/switch isn't completed */
_L4:
        obj = Integer.valueOf(readInt());
        continue; /* Loop/switch isn't completed */
_L5:
        obj = readHashMap(classloader);
        continue; /* Loop/switch isn't completed */
_L7:
        obj = readParcelable(classloader);
        continue; /* Loop/switch isn't completed */
_L8:
        obj = Short.valueOf((short)readInt());
        continue; /* Loop/switch isn't completed */
_L9:
        obj = Long.valueOf(readLong());
        continue; /* Loop/switch isn't completed */
_L10:
        obj = Float.valueOf(readFloat());
        continue; /* Loop/switch isn't completed */
_L11:
        obj = Double.valueOf(readDouble());
        continue; /* Loop/switch isn't completed */
_L12:
        if(readInt() != flag)
            flag = false;
        obj = Boolean.valueOf(flag);
        continue; /* Loop/switch isn't completed */
_L13:
        obj = readCharSequence();
        continue; /* Loop/switch isn't completed */
_L14:
        obj = readArrayList(classloader);
        continue; /* Loop/switch isn't completed */
_L26:
        obj = createBooleanArray();
        continue; /* Loop/switch isn't completed */
_L16:
        obj = createByteArray();
        continue; /* Loop/switch isn't completed */
_L17:
        obj = readStringArray();
        continue; /* Loop/switch isn't completed */
_L27:
        obj = readCharSequenceArray();
        continue; /* Loop/switch isn't completed */
_L18:
        obj = readStrongBinder();
        continue; /* Loop/switch isn't completed */
_L20:
        obj = ((Object) (readArray(classloader)));
        continue; /* Loop/switch isn't completed */
_L21:
        obj = createIntArray();
        continue; /* Loop/switch isn't completed */
_L22:
        obj = createLongArray();
        continue; /* Loop/switch isn't completed */
_L23:
        obj = Byte.valueOf(readByte());
        continue; /* Loop/switch isn't completed */
_L24:
        obj = readSerializable();
        continue; /* Loop/switch isn't completed */
_L19:
        obj = readParcelableArray(classloader);
        continue; /* Loop/switch isn't completed */
_L15:
        obj = readSparseArray(classloader);
        continue; /* Loop/switch isn't completed */
_L25:
        obj = readSparseBooleanArray();
        continue; /* Loop/switch isn't completed */
_L6:
        obj = readBundle(classloader);
        if(true) goto _L29; else goto _L28
_L28:
    }

    public final void recycle() {
        freeBuffer();
        if(!mOwnsNativeParcelObject) goto _L2; else goto _L1
_L1:
        Parcel aparcel[] = sOwnedPool;
_L10:
        aparcel;
        JVM INSTR monitorenter ;
        int i = 0;
_L8:
        if(i >= 6) goto _L4; else goto _L3
_L3:
        if(aparcel[i] != null) goto _L6; else goto _L5
_L5:
        aparcel[i] = this;
        aparcel;
        JVM INSTR monitorexit ;
_L4:
        return;
_L2:
        mNativePtr = 0;
        aparcel = sHolderPool;
        continue; /* Loop/switch isn't completed */
_L6:
        i++;
        if(true) goto _L8; else goto _L7
_L7:
        Exception exception;
        exception;
        throw exception;
        if(true) goto _L10; else goto _L9
_L9:
    }

    public final void restoreAllowFds(boolean flag) {
        nativeRestoreAllowFds(mNativePtr, flag);
    }

    public final void setDataCapacity(int i) {
        nativeSetDataCapacity(mNativePtr, i);
    }

    public final void setDataPosition(int i) {
        nativeSetDataPosition(mNativePtr, i);
    }

    public final void setDataSize(int i) {
        nativeSetDataSize(mNativePtr, i);
    }

    public final void unmarshall(byte abyte0[], int i, int j) {
        nativeUnmarshall(mNativePtr, abyte0, i, j);
    }

    public final void writeArray(Object aobj[]) {
        if(aobj == null) {
            writeInt(-1);
        } else {
            int i = aobj.length;
            int j = 0;
            writeInt(i);
            while(j < i)  {
                writeValue(aobj[j]);
                j++;
            }
        }
    }

    public final void writeBinderArray(IBinder aibinder[]) {
        if(aibinder != null) {
            int i = aibinder.length;
            writeInt(i);
            for(int j = 0; j < i; j++)
                writeStrongBinder(aibinder[j]);

        } else {
            writeInt(-1);
        }
    }

    public final void writeBinderList(List list) {
        if(list == null) {
            writeInt(-1);
        } else {
            int i = list.size();
            int j = 0;
            writeInt(i);
            while(j < i)  {
                writeStrongBinder((IBinder)list.get(j));
                j++;
            }
        }
    }

    public final void writeBooleanArray(boolean aflag[]) {
        if(aflag != null) {
            int i = aflag.length;
            writeInt(i);
            int j = 0;
            while(j < i)  {
                int k;
                if(aflag[j])
                    k = 1;
                else
                    k = 0;
                writeInt(k);
                j++;
            }
        } else {
            writeInt(-1);
        }
    }

    public final void writeBundle(Bundle bundle) {
        if(bundle == null)
            writeInt(-1);
        else
            bundle.writeToParcel(this, 0);
    }

    public final void writeByte(byte byte0) {
        writeInt(byte0);
    }

    public final void writeByteArray(byte abyte0[]) {
        int i;
        if(abyte0 != null)
            i = abyte0.length;
        else
            i = 0;
        writeByteArray(abyte0, 0, i);
    }

    public final void writeByteArray(byte abyte0[], int i, int j) {
        if(abyte0 == null) {
            writeInt(-1);
        } else {
            Arrays.checkOffsetAndCount(abyte0.length, i, j);
            nativeWriteByteArray(mNativePtr, abyte0, i, j);
        }
    }

    public final void writeCharArray(char ac[]) {
        if(ac != null) {
            int i = ac.length;
            writeInt(i);
            for(int j = 0; j < i; j++)
                writeInt(ac[j]);

        } else {
            writeInt(-1);
        }
    }

    public final void writeCharSequence(CharSequence charsequence) {
        TextUtils.writeToParcel(charsequence, this, 0);
    }

    public final void writeCharSequenceArray(CharSequence acharsequence[]) {
        if(acharsequence != null) {
            int i = acharsequence.length;
            writeInt(i);
            for(int j = 0; j < i; j++)
                writeCharSequence(acharsequence[j]);

        } else {
            writeInt(-1);
        }
    }

    public final void writeDouble(double d) {
        nativeWriteDouble(mNativePtr, d);
    }

    public final void writeDoubleArray(double ad[]) {
        if(ad != null) {
            int i = ad.length;
            writeInt(i);
            for(int j = 0; j < i; j++)
                writeDouble(ad[j]);

        } else {
            writeInt(-1);
        }
    }

    public final void writeException(Exception exception) {
        byte byte0 = 0;
        if(exception instanceof SecurityException)
            byte0 = -1;
        else
        if(exception instanceof BadParcelableException)
            byte0 = -2;
        else
        if(exception instanceof IllegalArgumentException)
            byte0 = -3;
        else
        if(exception instanceof NullPointerException)
            byte0 = -4;
        else
        if(exception instanceof IllegalStateException)
            byte0 = -5;
        writeInt(byte0);
        StrictMode.clearGatheredViolations();
        if(byte0 == 0) {
            if(exception instanceof RuntimeException)
                throw (RuntimeException)exception;
            else
                throw new RuntimeException(exception);
        } else {
            writeString(exception.getMessage());
            return;
        }
    }

    public final void writeFileDescriptor(FileDescriptor filedescriptor) {
        nativeWriteFileDescriptor(mNativePtr, filedescriptor);
    }

    public final void writeFloat(float f) {
        nativeWriteFloat(mNativePtr, f);
    }

    public final void writeFloatArray(float af[]) {
        if(af != null) {
            int i = af.length;
            writeInt(i);
            for(int j = 0; j < i; j++)
                writeFloat(af[j]);

        } else {
            writeInt(-1);
        }
    }

    public final void writeInt(int i) {
        nativeWriteInt(mNativePtr, i);
    }

    public final void writeIntArray(int ai[]) {
        if(ai != null) {
            int i = ai.length;
            writeInt(i);
            for(int j = 0; j < i; j++)
                writeInt(ai[j]);

        } else {
            writeInt(-1);
        }
    }

    public final void writeInterfaceToken(String s) {
        nativeWriteInterfaceToken(mNativePtr, s);
    }

    public final void writeList(List list) {
        if(list == null) {
            writeInt(-1);
        } else {
            int i = list.size();
            int j = 0;
            writeInt(i);
            while(j < i)  {
                writeValue(list.get(j));
                j++;
            }
        }
    }

    public final void writeLong(long l) {
        nativeWriteLong(mNativePtr, l);
    }

    public final void writeLongArray(long al[]) {
        if(al != null) {
            int i = al.length;
            writeInt(i);
            for(int j = 0; j < i; j++)
                writeLong(al[j]);

        } else {
            writeInt(-1);
        }
    }

    public final void writeMap(Map map) {
        writeMapInternal(map);
    }

    void writeMapInternal(Map map) {
        if(map == null) {
            writeInt(-1);
        } else {
            Set set = map.entrySet();
            writeInt(set.size());
            Iterator iterator = set.iterator();
            while(iterator.hasNext())  {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                writeValue(entry.getKey());
                writeValue(entry.getValue());
            }
        }
    }

    public final void writeNoException() {
        if(StrictMode.hasGatheredViolations()) {
            writeInt(-128);
            int i = dataPosition();
            writeInt(0);
            StrictMode.writeGatheredViolationsToParcel(this);
            int j = dataPosition();
            setDataPosition(i);
            writeInt(j - i);
            setDataPosition(j);
        } else {
            writeInt(0);
        }
    }

    public final void writeParcelable(Parcelable parcelable, int i) {
        if(parcelable == null) {
            writeString(null);
        } else {
            writeString(parcelable.getClass().getName());
            parcelable.writeToParcel(this, i);
        }
    }

    public final void writeParcelableArray(Parcelable aparcelable[], int i) {
        if(aparcelable != null) {
            int j = aparcelable.length;
            writeInt(j);
            for(int k = 0; k < j; k++)
                writeParcelable(aparcelable[k], i);

        } else {
            writeInt(-1);
        }
    }

    public final void writeSerializable(Serializable serializable) {
        if(serializable == null) {
            writeString(null);
        } else {
            String s = serializable.getClass().getName();
            writeString(s);
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            try {
                ObjectOutputStream objectoutputstream = new ObjectOutputStream(bytearrayoutputstream);
                objectoutputstream.writeObject(serializable);
                objectoutputstream.close();
                writeByteArray(bytearrayoutputstream.toByteArray());
            }
            catch(IOException ioexception) {
                throw new RuntimeException((new StringBuilder()).append("Parcelable encountered IOException writing serializable object (name = ").append(s).append(")").toString(), ioexception);
            }
        }
    }

    public final void writeSparseArray(SparseArray sparsearray) {
        if(sparsearray == null) {
            writeInt(-1);
        } else {
            int i = sparsearray.size();
            writeInt(i);
            int j = 0;
            while(j < i)  {
                writeInt(sparsearray.keyAt(j));
                writeValue(sparsearray.valueAt(j));
                j++;
            }
        }
    }

    public final void writeSparseBooleanArray(SparseBooleanArray sparsebooleanarray) {
        if(sparsebooleanarray == null) {
            writeInt(-1);
        } else {
            int i = sparsebooleanarray.size();
            writeInt(i);
            int j = 0;
            while(j < i)  {
                writeInt(sparsebooleanarray.keyAt(j));
                int k;
                if(sparsebooleanarray.valueAt(j))
                    k = 1;
                else
                    k = 0;
                writeByte((byte)k);
                j++;
            }
        }
    }

    public final void writeString(String s) {
        nativeWriteString(mNativePtr, s);
    }

    public final void writeStringArray(String as[]) {
        if(as != null) {
            int i = as.length;
            writeInt(i);
            for(int j = 0; j < i; j++)
                writeString(as[j]);

        } else {
            writeInt(-1);
        }
    }

    public final void writeStringList(List list) {
        if(list == null) {
            writeInt(-1);
        } else {
            int i = list.size();
            int j = 0;
            writeInt(i);
            while(j < i)  {
                writeString((String)list.get(j));
                j++;
            }
        }
    }

    public final void writeStrongBinder(IBinder ibinder) {
        nativeWriteStrongBinder(mNativePtr, ibinder);
    }

    public final void writeStrongInterface(IInterface iinterface) {
        IBinder ibinder;
        if(iinterface == null)
            ibinder = null;
        else
            ibinder = iinterface.asBinder();
        writeStrongBinder(ibinder);
    }

    public final void writeTypedArray(Parcelable aparcelable[], int i) {
        if(aparcelable != null) {
            int j = aparcelable.length;
            writeInt(j);
            int k = 0;
            while(k < j)  {
                Parcelable parcelable = aparcelable[k];
                if(parcelable != null) {
                    writeInt(1);
                    parcelable.writeToParcel(this, i);
                } else {
                    writeInt(0);
                }
                k++;
            }
        } else {
            writeInt(-1);
        }
    }

    public final void writeTypedList(List list) {
        if(list == null) {
            writeInt(-1);
        } else {
            int i = list.size();
            int j = 0;
            writeInt(i);
            while(j < i)  {
                Parcelable parcelable = (Parcelable)list.get(j);
                if(parcelable != null) {
                    writeInt(1);
                    parcelable.writeToParcel(this, 0);
                } else {
                    writeInt(0);
                }
                j++;
            }
        }
    }

    public final void writeValue(Object obj) {
        int i = 1;
        if(obj == null)
            writeInt(-1);
        else
        if(obj instanceof String) {
            writeInt(0);
            writeString((String)obj);
        } else
        if(obj instanceof Integer) {
            writeInt(i);
            writeInt(((Integer)obj).intValue());
        } else
        if(obj instanceof Map) {
            writeInt(2);
            writeMap((Map)obj);
        } else
        if(obj instanceof Bundle) {
            writeInt(3);
            writeBundle((Bundle)obj);
        } else
        if(obj instanceof Parcelable) {
            writeInt(4);
            writeParcelable((Parcelable)obj, 0);
        } else
        if(obj instanceof Short) {
            writeInt(5);
            writeInt(((Short)obj).intValue());
        } else
        if(obj instanceof Long) {
            writeInt(6);
            writeLong(((Long)obj).longValue());
        } else
        if(obj instanceof Float) {
            writeInt(7);
            writeFloat(((Float)obj).floatValue());
        } else
        if(obj instanceof Double) {
            writeInt(8);
            writeDouble(((Double)obj).doubleValue());
        } else
        if(obj instanceof Boolean) {
            writeInt(9);
            if(!((Boolean)obj).booleanValue())
                i = 0;
            writeInt(i);
        } else
        if(obj instanceof CharSequence) {
            writeInt(10);
            writeCharSequence((CharSequence)obj);
        } else
        if(obj instanceof List) {
            writeInt(11);
            writeList((List)obj);
        } else
        if(obj instanceof SparseArray) {
            writeInt(12);
            writeSparseArray((SparseArray)obj);
        } else
        if(obj instanceof boolean[]) {
            writeInt(23);
            writeBooleanArray((boolean[])(boolean[])obj);
        } else
        if(obj instanceof byte[]) {
            writeInt(13);
            writeByteArray((byte[])(byte[])obj);
        } else
        if(obj instanceof String[]) {
            writeInt(14);
            writeStringArray((String[])(String[])obj);
        } else
        if(obj instanceof CharSequence[]) {
            writeInt(24);
            writeCharSequenceArray((CharSequence[])(CharSequence[])obj);
        } else
        if(obj instanceof IBinder) {
            writeInt(15);
            writeStrongBinder((IBinder)obj);
        } else
        if(obj instanceof Parcelable[]) {
            writeInt(16);
            writeParcelableArray((Parcelable[])(Parcelable[])obj, 0);
        } else
        if(obj instanceof Object[]) {
            writeInt(17);
            writeArray((Object[])(Object[])obj);
        } else
        if(obj instanceof int[]) {
            writeInt(18);
            writeIntArray((int[])(int[])obj);
        } else
        if(obj instanceof long[]) {
            writeInt(19);
            writeLongArray((long[])(long[])obj);
        } else
        if(obj instanceof Byte) {
            writeInt(20);
            writeInt(((Byte)obj).byteValue());
        } else
        if(obj instanceof Serializable) {
            writeInt(21);
            writeSerializable((Serializable)obj);
        } else {
            throw new RuntimeException((new StringBuilder()).append("Parcel: unable to marshal value ").append(obj).toString());
        }
    }

    private static final boolean DEBUG_RECYCLE = false;
    private static final int EX_BAD_PARCELABLE = -2;
    private static final int EX_HAS_REPLY_HEADER = -128;
    private static final int EX_ILLEGAL_ARGUMENT = -3;
    private static final int EX_ILLEGAL_STATE = -5;
    private static final int EX_NULL_POINTER = -4;
    private static final int EX_SECURITY = -1;
    private static final int POOL_SIZE = 6;
    public static final Parcelable.Creator STRING_CREATOR = new Parcelable.Creator() {

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public String createFromParcel(Parcel parcel) {
            return parcel.readString();
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

        public String[] newArray(int i) {
            return new String[i];
        }

    };
    private static final String TAG = "Parcel";
    private static final int VAL_BOOLEAN = 9;
    private static final int VAL_BOOLEANARRAY = 23;
    private static final int VAL_BUNDLE = 3;
    private static final int VAL_BYTE = 20;
    private static final int VAL_BYTEARRAY = 13;
    private static final int VAL_CHARSEQUENCE = 10;
    private static final int VAL_CHARSEQUENCEARRAY = 24;
    private static final int VAL_DOUBLE = 8;
    private static final int VAL_FLOAT = 7;
    private static final int VAL_IBINDER = 15;
    private static final int VAL_INTARRAY = 18;
    private static final int VAL_INTEGER = 1;
    private static final int VAL_LIST = 11;
    private static final int VAL_LONG = 6;
    private static final int VAL_LONGARRAY = 19;
    private static final int VAL_MAP = 2;
    private static final int VAL_NULL = -1;
    private static final int VAL_OBJECTARRAY = 17;
    private static final int VAL_PARCELABLE = 4;
    private static final int VAL_PARCELABLEARRAY = 16;
    private static final int VAL_SERIALIZABLE = 21;
    private static final int VAL_SHORT = 5;
    private static final int VAL_SPARSEARRAY = 12;
    private static final int VAL_SPARSEBOOLEANARRAY = 22;
    private static final int VAL_STRING = 0;
    private static final int VAL_STRINGARRAY = 14;
    private static final HashMap mCreators = new HashMap();
    private static final Parcel sHolderPool[] = new Parcel[6];
    private static final Parcel sOwnedPool[] = new Parcel[6];
    private int mNativePtr;
    private boolean mOwnsNativeParcelObject;
    private RuntimeException mStack;

}
