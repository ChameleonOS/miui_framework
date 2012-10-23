// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;

import android.util.Log;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.*;

// Referenced classes of package android.os:
//            Parcelable, Parcel, IBinder

public final class Bundle
    implements Parcelable, Cloneable {

    public Bundle() {
        mMap = null;
        mParcelledData = null;
        mHasFds = false;
        mFdsKnown = true;
        mAllowFds = true;
        mMap = new HashMap();
        mClassLoader = getClass().getClassLoader();
    }

    public Bundle(int i) {
        mMap = null;
        mParcelledData = null;
        mHasFds = false;
        mFdsKnown = true;
        mAllowFds = true;
        mMap = new HashMap(i);
        mClassLoader = getClass().getClassLoader();
    }

    public Bundle(Bundle bundle) {
        mMap = null;
        mParcelledData = null;
        mHasFds = false;
        mFdsKnown = true;
        mAllowFds = true;
        if(bundle.mParcelledData != null) {
            mParcelledData = Parcel.obtain();
            mParcelledData.appendFrom(bundle.mParcelledData, 0, bundle.mParcelledData.dataSize());
            mParcelledData.setDataPosition(0);
        } else {
            mParcelledData = null;
        }
        if(bundle.mMap != null)
            mMap = new HashMap(bundle.mMap);
        else
            mMap = null;
        mHasFds = bundle.mHasFds;
        mFdsKnown = bundle.mFdsKnown;
        mClassLoader = bundle.mClassLoader;
    }

    Bundle(Parcel parcel) {
        mMap = null;
        mParcelledData = null;
        mHasFds = false;
        mFdsKnown = true;
        mAllowFds = true;
        readFromParcel(parcel);
    }

    Bundle(Parcel parcel, int i) {
        mMap = null;
        mParcelledData = null;
        mHasFds = false;
        mFdsKnown = true;
        mAllowFds = true;
        readFromParcelInner(parcel, i);
    }

    public Bundle(ClassLoader classloader) {
        mMap = null;
        mParcelledData = null;
        mHasFds = false;
        mFdsKnown = true;
        mAllowFds = true;
        mMap = new HashMap();
        mClassLoader = classloader;
    }

    public static Bundle forPair(String s, String s1) {
        Bundle bundle = new Bundle(1);
        bundle.putString(s, s1);
        return bundle;
    }

    private void typeWarning(String s, Object obj, String s1, ClassCastException classcastexception) {
        typeWarning(s, obj, s1, "<null>", classcastexception);
    }

    private void typeWarning(String s, Object obj, String s1, Object obj1, ClassCastException classcastexception) {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("Key ");
        stringbuilder.append(s);
        stringbuilder.append(" expected ");
        stringbuilder.append(s1);
        stringbuilder.append(" but value was a ");
        stringbuilder.append(obj.getClass().getName());
        stringbuilder.append(".  The default value ");
        stringbuilder.append(obj1);
        stringbuilder.append(" was returned.");
        Log.w("Bundle", stringbuilder.toString());
        Log.w("Bundle", "Attempt to cast generated internal exception:", classcastexception);
    }

    public void clear() {
        unparcel();
        mMap.clear();
        mHasFds = false;
        mFdsKnown = true;
    }

    public Object clone() {
        return new Bundle(this);
    }

    public boolean containsKey(String s) {
        unparcel();
        return mMap.containsKey(s);
    }

    public int describeContents() {
        int i = 0;
        if(hasFileDescriptors())
            i = false | true;
        return i;
    }

    public Object get(String s) {
        unparcel();
        return mMap.get(s);
    }

    public boolean getBoolean(String s) {
        unparcel();
        return getBoolean(s, false);
    }

    public boolean getBoolean(String s, boolean flag) {
        Object obj;
        unparcel();
        obj = mMap.get(s);
        if(obj != null) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        boolean flag1 = ((Boolean)obj).booleanValue();
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        ClassCastException classcastexception;
        classcastexception;
        typeWarning(s, obj, "Boolean", Boolean.valueOf(flag), classcastexception);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public boolean[] getBooleanArray(String s) {
        unparcel();
        Object obj = mMap.get(s);
        boolean aflag[];
        if(obj == null)
            aflag = null;
        else
            try {
                aflag = (boolean[])(boolean[])obj;
            }
            catch(ClassCastException classcastexception) {
                typeWarning(s, obj, "byte[]", classcastexception);
                aflag = null;
            }
        return aflag;
    }

    public Bundle getBundle(String s) {
        unparcel();
        Object obj = mMap.get(s);
        Bundle bundle;
        if(obj == null)
            bundle = null;
        else
            try {
                bundle = (Bundle)obj;
            }
            catch(ClassCastException classcastexception) {
                typeWarning(s, obj, "Bundle", classcastexception);
                bundle = null;
            }
        return bundle;
    }

    public byte getByte(String s) {
        unparcel();
        return getByte(s, (byte)0).byteValue();
    }

    public Byte getByte(String s, byte byte0) {
        unparcel();
        Object obj = mMap.get(s);
        Byte byte1;
        if(obj == null)
            byte1 = Byte.valueOf(byte0);
        else
            try {
                byte1 = (Byte)obj;
            }
            catch(ClassCastException classcastexception) {
                typeWarning(s, obj, "Byte", Byte.valueOf(byte0), classcastexception);
                byte1 = Byte.valueOf(byte0);
            }
        return byte1;
    }

    public byte[] getByteArray(String s) {
        unparcel();
        Object obj = mMap.get(s);
        byte abyte0[];
        if(obj == null)
            abyte0 = null;
        else
            try {
                abyte0 = (byte[])(byte[])obj;
            }
            catch(ClassCastException classcastexception) {
                typeWarning(s, obj, "byte[]", classcastexception);
                abyte0 = null;
            }
        return abyte0;
    }

    public char getChar(String s) {
        unparcel();
        return getChar(s, '\0');
    }

    public char getChar(String s, char c) {
        Object obj;
        unparcel();
        obj = mMap.get(s);
        if(obj != null) goto _L2; else goto _L1
_L1:
        return c;
_L2:
        char c1 = ((Character)obj).charValue();
        c = c1;
        continue; /* Loop/switch isn't completed */
        ClassCastException classcastexception;
        classcastexception;
        typeWarning(s, obj, "Character", Character.valueOf(c), classcastexception);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public char[] getCharArray(String s) {
        unparcel();
        Object obj = mMap.get(s);
        char ac[];
        if(obj == null)
            ac = null;
        else
            try {
                ac = (char[])(char[])obj;
            }
            catch(ClassCastException classcastexception) {
                typeWarning(s, obj, "char[]", classcastexception);
                ac = null;
            }
        return ac;
    }

    public CharSequence getCharSequence(String s) {
        unparcel();
        Object obj = mMap.get(s);
        CharSequence charsequence;
        if(obj == null)
            charsequence = null;
        else
            try {
                charsequence = (CharSequence)obj;
            }
            catch(ClassCastException classcastexception) {
                typeWarning(s, obj, "CharSequence", classcastexception);
                charsequence = null;
            }
        return charsequence;
    }

    public CharSequence getCharSequence(String s, CharSequence charsequence) {
        Object obj;
        unparcel();
        obj = mMap.get(s);
        if(obj != null) goto _L2; else goto _L1
_L1:
        return charsequence;
_L2:
        CharSequence charsequence1 = (CharSequence)obj;
        charsequence = charsequence1;
        continue; /* Loop/switch isn't completed */
        ClassCastException classcastexception;
        classcastexception;
        typeWarning(s, obj, "CharSequence", classcastexception);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public CharSequence[] getCharSequenceArray(String s) {
        unparcel();
        Object obj = mMap.get(s);
        CharSequence acharsequence[];
        if(obj == null)
            acharsequence = null;
        else
            try {
                acharsequence = (CharSequence[])(CharSequence[])obj;
            }
            catch(ClassCastException classcastexception) {
                typeWarning(s, obj, "CharSequence[]", classcastexception);
                acharsequence = null;
            }
        return acharsequence;
    }

    public ArrayList getCharSequenceArrayList(String s) {
        unparcel();
        Object obj = mMap.get(s);
        ArrayList arraylist;
        if(obj == null)
            arraylist = null;
        else
            try {
                arraylist = (ArrayList)obj;
            }
            catch(ClassCastException classcastexception) {
                typeWarning(s, obj, "ArrayList<CharSequence>", classcastexception);
                arraylist = null;
            }
        return arraylist;
    }

    public ClassLoader getClassLoader() {
        return mClassLoader;
    }

    public double getDouble(String s) {
        unparcel();
        return getDouble(s, 0.0D);
    }

    public double getDouble(String s, double d) {
        Object obj;
        unparcel();
        obj = mMap.get(s);
        if(obj != null) goto _L2; else goto _L1
_L1:
        return d;
_L2:
        double d1 = ((Double)obj).doubleValue();
        d = d1;
        continue; /* Loop/switch isn't completed */
        ClassCastException classcastexception;
        classcastexception;
        typeWarning(s, obj, "Double", Double.valueOf(d), classcastexception);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public double[] getDoubleArray(String s) {
        unparcel();
        Object obj = mMap.get(s);
        double ad[];
        if(obj == null)
            ad = null;
        else
            try {
                ad = (double[])(double[])obj;
            }
            catch(ClassCastException classcastexception) {
                typeWarning(s, obj, "double[]", classcastexception);
                ad = null;
            }
        return ad;
    }

    public float getFloat(String s) {
        unparcel();
        return getFloat(s, 0.0F);
    }

    public float getFloat(String s, float f) {
        Object obj;
        unparcel();
        obj = mMap.get(s);
        if(obj != null) goto _L2; else goto _L1
_L1:
        return f;
_L2:
        float f1 = ((Float)obj).floatValue();
        f = f1;
        continue; /* Loop/switch isn't completed */
        ClassCastException classcastexception;
        classcastexception;
        typeWarning(s, obj, "Float", Float.valueOf(f), classcastexception);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public float[] getFloatArray(String s) {
        unparcel();
        Object obj = mMap.get(s);
        float af[];
        if(obj == null)
            af = null;
        else
            try {
                af = (float[])(float[])obj;
            }
            catch(ClassCastException classcastexception) {
                typeWarning(s, obj, "float[]", classcastexception);
                af = null;
            }
        return af;
    }

    public IBinder getIBinder(String s) {
        unparcel();
        Object obj = mMap.get(s);
        IBinder ibinder;
        if(obj == null)
            ibinder = null;
        else
            try {
                ibinder = (IBinder)obj;
            }
            catch(ClassCastException classcastexception) {
                typeWarning(s, obj, "IBinder", classcastexception);
                ibinder = null;
            }
        return ibinder;
    }

    public int getInt(String s) {
        unparcel();
        return getInt(s, 0);
    }

    public int getInt(String s, int i) {
        Object obj;
        unparcel();
        obj = mMap.get(s);
        if(obj != null) goto _L2; else goto _L1
_L1:
        return i;
_L2:
        int j = ((Integer)obj).intValue();
        i = j;
        continue; /* Loop/switch isn't completed */
        ClassCastException classcastexception;
        classcastexception;
        typeWarning(s, obj, "Integer", Integer.valueOf(i), classcastexception);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public int[] getIntArray(String s) {
        unparcel();
        Object obj = mMap.get(s);
        int ai[];
        if(obj == null)
            ai = null;
        else
            try {
                ai = (int[])(int[])obj;
            }
            catch(ClassCastException classcastexception) {
                typeWarning(s, obj, "int[]", classcastexception);
                ai = null;
            }
        return ai;
    }

    public ArrayList getIntegerArrayList(String s) {
        unparcel();
        Object obj = mMap.get(s);
        ArrayList arraylist;
        if(obj == null)
            arraylist = null;
        else
            try {
                arraylist = (ArrayList)obj;
            }
            catch(ClassCastException classcastexception) {
                typeWarning(s, obj, "ArrayList<Integer>", classcastexception);
                arraylist = null;
            }
        return arraylist;
    }

    public long getLong(String s) {
        unparcel();
        return getLong(s, 0L);
    }

    public long getLong(String s, long l) {
        Object obj;
        unparcel();
        obj = mMap.get(s);
        if(obj != null) goto _L2; else goto _L1
_L1:
        return l;
_L2:
        long l1 = ((Long)obj).longValue();
        l = l1;
        continue; /* Loop/switch isn't completed */
        ClassCastException classcastexception;
        classcastexception;
        typeWarning(s, obj, "Long", Long.valueOf(l), classcastexception);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public long[] getLongArray(String s) {
        unparcel();
        Object obj = mMap.get(s);
        long al[];
        if(obj == null)
            al = null;
        else
            try {
                al = (long[])(long[])obj;
            }
            catch(ClassCastException classcastexception) {
                typeWarning(s, obj, "long[]", classcastexception);
                al = null;
            }
        return al;
    }

    public String getPairValue() {
        unparcel();
        int i = mMap.size();
        if(i > 1)
            Log.w("Bundle", "getPairValue() used on Bundle with multiple pairs.");
        String s;
        if(i == 0) {
            s = null;
        } else {
            Object obj = mMap.values().iterator().next();
            try {
                s = (String)obj;
            }
            catch(ClassCastException classcastexception) {
                typeWarning("getPairValue()", obj, "String", classcastexception);
                s = null;
            }
        }
        return s;
    }

    public Parcelable getParcelable(String s) {
        unparcel();
        Object obj = mMap.get(s);
        Parcelable parcelable;
        if(obj == null)
            parcelable = null;
        else
            try {
                parcelable = (Parcelable)obj;
            }
            catch(ClassCastException classcastexception) {
                typeWarning(s, obj, "Parcelable", classcastexception);
                parcelable = null;
            }
        return parcelable;
    }

    public Parcelable[] getParcelableArray(String s) {
        unparcel();
        Object obj = mMap.get(s);
        Parcelable aparcelable[];
        if(obj == null)
            aparcelable = null;
        else
            try {
                aparcelable = (Parcelable[])(Parcelable[])obj;
            }
            catch(ClassCastException classcastexception) {
                typeWarning(s, obj, "Parcelable[]", classcastexception);
                aparcelable = null;
            }
        return aparcelable;
    }

    public ArrayList getParcelableArrayList(String s) {
        unparcel();
        Object obj = mMap.get(s);
        ArrayList arraylist;
        if(obj == null)
            arraylist = null;
        else
            try {
                arraylist = (ArrayList)obj;
            }
            catch(ClassCastException classcastexception) {
                typeWarning(s, obj, "ArrayList", classcastexception);
                arraylist = null;
            }
        return arraylist;
    }

    public Serializable getSerializable(String s) {
        unparcel();
        Object obj = mMap.get(s);
        Serializable serializable;
        if(obj == null)
            serializable = null;
        else
            try {
                serializable = (Serializable)obj;
            }
            catch(ClassCastException classcastexception) {
                typeWarning(s, obj, "Serializable", classcastexception);
                serializable = null;
            }
        return serializable;
    }

    public short getShort(String s) {
        unparcel();
        return getShort(s, (short)0);
    }

    public short getShort(String s, short word0) {
        Object obj;
        unparcel();
        obj = mMap.get(s);
        if(obj != null) goto _L2; else goto _L1
_L1:
        return word0;
_L2:
        short word1 = ((Short)obj).shortValue();
        word0 = word1;
        continue; /* Loop/switch isn't completed */
        ClassCastException classcastexception;
        classcastexception;
        typeWarning(s, obj, "Short", Short.valueOf(word0), classcastexception);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public short[] getShortArray(String s) {
        unparcel();
        Object obj = mMap.get(s);
        short aword0[];
        if(obj == null)
            aword0 = null;
        else
            try {
                aword0 = (short[])(short[])obj;
            }
            catch(ClassCastException classcastexception) {
                typeWarning(s, obj, "short[]", classcastexception);
                aword0 = null;
            }
        return aword0;
    }

    public SparseArray getSparseParcelableArray(String s) {
        unparcel();
        Object obj = mMap.get(s);
        SparseArray sparsearray;
        if(obj == null)
            sparsearray = null;
        else
            try {
                sparsearray = (SparseArray)obj;
            }
            catch(ClassCastException classcastexception) {
                typeWarning(s, obj, "SparseArray", classcastexception);
                sparsearray = null;
            }
        return sparsearray;
    }

    public String getString(String s) {
        unparcel();
        Object obj = mMap.get(s);
        String s1;
        if(obj == null)
            s1 = null;
        else
            try {
                s1 = (String)obj;
            }
            catch(ClassCastException classcastexception) {
                typeWarning(s, obj, "String", classcastexception);
                s1 = null;
            }
        return s1;
    }

    public String getString(String s, String s1) {
        Object obj;
        unparcel();
        obj = mMap.get(s);
        if(obj != null) goto _L2; else goto _L1
_L1:
        return s1;
_L2:
        String s2 = (String)obj;
        s1 = s2;
        continue; /* Loop/switch isn't completed */
        ClassCastException classcastexception;
        classcastexception;
        typeWarning(s, obj, "String", classcastexception);
        if(true) goto _L1; else goto _L3
_L3:
    }

    public String[] getStringArray(String s) {
        unparcel();
        Object obj = mMap.get(s);
        String as[];
        if(obj == null)
            as = null;
        else
            try {
                as = (String[])(String[])obj;
            }
            catch(ClassCastException classcastexception) {
                typeWarning(s, obj, "String[]", classcastexception);
                as = null;
            }
        return as;
    }

    public ArrayList getStringArrayList(String s) {
        unparcel();
        Object obj = mMap.get(s);
        ArrayList arraylist;
        if(obj == null)
            arraylist = null;
        else
            try {
                arraylist = (ArrayList)obj;
            }
            catch(ClassCastException classcastexception) {
                typeWarning(s, obj, "ArrayList<String>", classcastexception);
                arraylist = null;
            }
        return arraylist;
    }

    public boolean hasFileDescriptors() {
        if(mFdsKnown) goto _L2; else goto _L1
_L1:
        boolean flag = false;
        if(mParcelledData == null) goto _L4; else goto _L3
_L3:
        if(mParcelledData.hasFileDescriptors())
            flag = true;
_L6:
        mHasFds = flag;
        mFdsKnown = true;
_L2:
        return mHasFds;
_L4:
        Iterator iterator = mMap.entrySet().iterator();
_L8:
        if(flag || !iterator.hasNext()) goto _L6; else goto _L5
_L5:
        Object obj;
        obj = ((java.util.Map.Entry)iterator.next()).getValue();
        if(!(obj instanceof Parcelable))
            break MISSING_BLOCK_LABEL_112;
        if((1 & ((Parcelable)obj).describeContents()) == 0) goto _L8; else goto _L7
_L7:
        flag = true;
          goto _L6
        Parcelable aparcelable[];
        int k;
        if(!(obj instanceof Parcelable[]))
            break MISSING_BLOCK_LABEL_167;
        aparcelable = (Parcelable[])(Parcelable[])obj;
        k = -1 + aparcelable.length;
_L9:
        if(k >= 0) {
label0:
            {
                if((1 & aparcelable[k].describeContents()) == 0)
                    break label0;
                flag = true;
            }
        }
          goto _L8
        k--;
          goto _L9
        if(!(obj instanceof SparseArray)) goto _L11; else goto _L10
_L10:
        SparseArray sparsearray;
        int j;
        sparsearray = (SparseArray)obj;
        j = -1 + sparsearray.size();
_L12:
        if(j >= 0) {
label1:
            {
                if((1 & ((Parcelable)sparsearray.get(j)).describeContents()) == 0)
                    break label1;
                flag = true;
            }
        }
          goto _L8
        j--;
          goto _L12
_L11:
        if(!(obj instanceof ArrayList)) goto _L8; else goto _L13
_L13:
        ArrayList arraylist = (ArrayList)obj;
        if(arraylist.size() <= 0 || !(arraylist.get(0) instanceof Parcelable)) goto _L8; else goto _L14
_L14:
        int i = -1 + arraylist.size();
_L15:
        if(i >= 0) {
label2:
            {
                Parcelable parcelable = (Parcelable)arraylist.get(i);
                if(parcelable == null || (1 & parcelable.describeContents()) == 0)
                    break label2;
                flag = true;
            }
        }
          goto _L8
        i--;
          goto _L15
    }

    public boolean isEmpty() {
        unparcel();
        return mMap.isEmpty();
    }

    public boolean isParcelled() {
        boolean flag;
        if(mParcelledData != null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public Set keySet() {
        unparcel();
        return mMap.keySet();
    }

    public void putAll(Bundle bundle) {
        unparcel();
        bundle.unparcel();
        mMap.putAll(bundle.mMap);
        mHasFds = mHasFds | bundle.mHasFds;
        boolean flag;
        if(mFdsKnown && bundle.mFdsKnown)
            flag = true;
        else
            flag = false;
        mFdsKnown = flag;
    }

    public void putBoolean(String s, boolean flag) {
        unparcel();
        mMap.put(s, Boolean.valueOf(flag));
    }

    public void putBooleanArray(String s, boolean aflag[]) {
        unparcel();
        mMap.put(s, aflag);
    }

    public void putBundle(String s, Bundle bundle) {
        unparcel();
        mMap.put(s, bundle);
    }

    public void putByte(String s, byte byte0) {
        unparcel();
        mMap.put(s, Byte.valueOf(byte0));
    }

    public void putByteArray(String s, byte abyte0[]) {
        unparcel();
        mMap.put(s, abyte0);
    }

    public void putChar(String s, char c) {
        unparcel();
        mMap.put(s, Character.valueOf(c));
    }

    public void putCharArray(String s, char ac[]) {
        unparcel();
        mMap.put(s, ac);
    }

    public void putCharSequence(String s, CharSequence charsequence) {
        unparcel();
        mMap.put(s, charsequence);
    }

    public void putCharSequenceArray(String s, CharSequence acharsequence[]) {
        unparcel();
        mMap.put(s, acharsequence);
    }

    public void putCharSequenceArrayList(String s, ArrayList arraylist) {
        unparcel();
        mMap.put(s, arraylist);
    }

    public void putDouble(String s, double d) {
        unparcel();
        mMap.put(s, Double.valueOf(d));
    }

    public void putDoubleArray(String s, double ad[]) {
        unparcel();
        mMap.put(s, ad);
    }

    public void putFloat(String s, float f) {
        unparcel();
        mMap.put(s, Float.valueOf(f));
    }

    public void putFloatArray(String s, float af[]) {
        unparcel();
        mMap.put(s, af);
    }

    public void putIBinder(String s, IBinder ibinder) {
        unparcel();
        mMap.put(s, ibinder);
    }

    public void putInt(String s, int i) {
        unparcel();
        mMap.put(s, Integer.valueOf(i));
    }

    public void putIntArray(String s, int ai[]) {
        unparcel();
        mMap.put(s, ai);
    }

    public void putIntegerArrayList(String s, ArrayList arraylist) {
        unparcel();
        mMap.put(s, arraylist);
    }

    public void putLong(String s, long l) {
        unparcel();
        mMap.put(s, Long.valueOf(l));
    }

    public void putLongArray(String s, long al[]) {
        unparcel();
        mMap.put(s, al);
    }

    public void putParcelable(String s, Parcelable parcelable) {
        unparcel();
        mMap.put(s, parcelable);
        mFdsKnown = false;
    }

    public void putParcelableArray(String s, Parcelable aparcelable[]) {
        unparcel();
        mMap.put(s, aparcelable);
        mFdsKnown = false;
    }

    public void putParcelableArrayList(String s, ArrayList arraylist) {
        unparcel();
        mMap.put(s, arraylist);
        mFdsKnown = false;
    }

    public void putSerializable(String s, Serializable serializable) {
        unparcel();
        mMap.put(s, serializable);
    }

    public void putShort(String s, short word0) {
        unparcel();
        mMap.put(s, Short.valueOf(word0));
    }

    public void putShortArray(String s, short aword0[]) {
        unparcel();
        mMap.put(s, aword0);
    }

    public void putSparseParcelableArray(String s, SparseArray sparsearray) {
        unparcel();
        mMap.put(s, sparsearray);
        mFdsKnown = false;
    }

    public void putString(String s, String s1) {
        unparcel();
        mMap.put(s, s1);
    }

    public void putStringArray(String s, String as[]) {
        unparcel();
        mMap.put(s, as);
    }

    public void putStringArrayList(String s, ArrayList arraylist) {
        unparcel();
        mMap.put(s, arraylist);
    }

    public void readFromParcel(Parcel parcel) {
        int i = parcel.readInt();
        if(i < 0) {
            throw new RuntimeException((new StringBuilder()).append("Bad length in parcel: ").append(i).toString());
        } else {
            readFromParcelInner(parcel, i);
            return;
        }
    }

    void readFromParcelInner(Parcel parcel, int i) {
        if(parcel.readInt() != 0x4c444e42) {
            String s = Log.getStackTraceString(new RuntimeException());
            Log.e("Bundle", "readBundle: bad magic number");
            Log.e("Bundle", (new StringBuilder()).append("readBundle: trace = ").append(s).toString());
        }
        int j = parcel.dataPosition();
        parcel.setDataPosition(j + i);
        Parcel parcel1 = Parcel.obtain();
        parcel1.setDataPosition(0);
        parcel1.appendFrom(parcel, j, i);
        parcel1.setDataPosition(0);
        mParcelledData = parcel1;
        mHasFds = parcel1.hasFileDescriptors();
        mFdsKnown = true;
    }

    public void remove(String s) {
        unparcel();
        mMap.remove(s);
    }

    public boolean setAllowFds(boolean flag) {
        boolean flag1 = mAllowFds;
        mAllowFds = flag;
        return flag1;
    }

    public void setClassLoader(ClassLoader classloader) {
        mClassLoader = classloader;
    }

    public int size() {
        unparcel();
        return mMap.size();
    }

    /**
     * @deprecated Method toString is deprecated
     */

    public String toString() {
        this;
        JVM INSTR monitorenter ;
        if(mParcelledData == null) goto _L2; else goto _L1
_L1:
        String s2 = (new StringBuilder()).append("Bundle[mParcelledData.dataSize=").append(mParcelledData.dataSize()).append("]").toString();
        String s1 = s2;
_L4:
        this;
        JVM INSTR monitorexit ;
        return s1;
_L2:
        String s = (new StringBuilder()).append("Bundle[").append(mMap.toString()).append("]").toString();
        s1 = s;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method unparcel is deprecated
     */

    void unparcel() {
        this;
        JVM INSTR monitorenter ;
        Parcel parcel = mParcelledData;
        if(parcel != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        int i = mParcelledData.readInt();
        if(i >= 0) {
            if(mMap == null)
                mMap = new HashMap();
            mParcelledData.readMapInternal(mMap, i, mClassLoader);
            mParcelledData.recycle();
            mParcelledData = null;
        }
        if(true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void writeToParcel(Parcel parcel, int i) {
        boolean flag = parcel.pushAllowFds(mAllowFds);
        if(mParcelledData == null) goto _L2; else goto _L1
_L1:
        int l = mParcelledData.dataSize();
        parcel.writeInt(l);
        parcel.writeInt(0x4c444e42);
        parcel.appendFrom(mParcelledData, 0, l);
_L4:
        parcel.restoreAllowFds(flag);
        return;
_L2:
        parcel.writeInt(-1);
        parcel.writeInt(0x4c444e42);
        int j = parcel.dataPosition();
        parcel.writeMapInternal(mMap);
        int k = parcel.dataPosition();
        parcel.setDataPosition(j - 8);
        parcel.writeInt(k - j);
        parcel.setDataPosition(k);
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        parcel.restoreAllowFds(flag);
        throw exception;
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

        public Bundle createFromParcel(Parcel parcel) {
            return parcel.readBundle();
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public Bundle[] newArray(int i) {
            return new Bundle[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final Bundle EMPTY;
    private static final String LOG_TAG = "Bundle";
    private boolean mAllowFds;
    private ClassLoader mClassLoader;
    private boolean mFdsKnown;
    private boolean mHasFds;
    Map mMap;
    Parcel mParcelledData;

    static  {
        EMPTY = new Bundle();
        EMPTY.mMap = Collections.unmodifiableMap(new HashMap());
    }
}
