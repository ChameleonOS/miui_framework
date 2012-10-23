// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.util.*;

public final class ContentValues
    implements Parcelable {

    public ContentValues() {
        mValues = new HashMap(8);
    }

    public ContentValues(int i) {
        mValues = new HashMap(i, 1.0F);
    }

    public ContentValues(ContentValues contentvalues) {
        mValues = new HashMap(contentvalues.mValues);
    }

    private ContentValues(HashMap hashmap) {
        mValues = hashmap;
    }


    public void clear() {
        mValues.clear();
    }

    public boolean containsKey(String s) {
        return mValues.containsKey(s);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean flag;
        if(!(obj instanceof ContentValues))
            flag = false;
        else
            flag = mValues.equals(((ContentValues)obj).mValues);
        return flag;
    }

    public Object get(String s) {
        return mValues.get(s);
    }

    public Boolean getAsBoolean(String s) {
        Object obj = mValues.get(s);
        Boolean boolean1;
        try {
            boolean1 = (Boolean)obj;
        }
        catch(ClassCastException classcastexception) {
            if(obj instanceof CharSequence)
                boolean1 = Boolean.valueOf(obj.toString());
            else
            if(obj instanceof Number) {
                boolean flag;
                if(((Number)obj).intValue() != 0)
                    flag = true;
                else
                    flag = false;
                boolean1 = Boolean.valueOf(flag);
            } else {
                Log.e("ContentValues", (new StringBuilder()).append("Cannot cast value for ").append(s).append(" to a Boolean: ").append(obj).toString(), classcastexception);
                boolean1 = null;
            }
        }
        return boolean1;
    }

    public Byte getAsByte(String s) {
        Byte byte1;
        Object obj;
        byte1 = null;
        obj = mValues.get(s);
        if(obj == null) goto _L2; else goto _L1
_L1:
        Byte byte4 = Byte.valueOf(((Number)obj).byteValue());
        Byte byte2 = byte4;
_L3:
        byte1 = byte2;
_L4:
        return byte1;
_L2:
        byte2 = null;
          goto _L3
        ClassCastException classcastexception;
        classcastexception;
        if(!(obj instanceof CharSequence))
            break MISSING_BLOCK_LABEL_105;
        Byte byte3 = Byte.valueOf(obj.toString());
        byte1 = byte3;
          goto _L4
        NumberFormatException numberformatexception;
        numberformatexception;
        Log.e("ContentValues", (new StringBuilder()).append("Cannot parse Byte value for ").append(obj).append(" at key ").append(s).toString());
          goto _L4
        Log.e("ContentValues", (new StringBuilder()).append("Cannot cast value for ").append(s).append(" to a Byte: ").append(obj).toString(), classcastexception);
          goto _L4
    }

    public byte[] getAsByteArray(String s) {
        Object obj = mValues.get(s);
        byte abyte0[];
        if(obj instanceof byte[])
            abyte0 = (byte[])(byte[])obj;
        else
            abyte0 = null;
        return abyte0;
    }

    public Double getAsDouble(String s) {
        Double double1;
        Object obj;
        double1 = null;
        obj = mValues.get(s);
        if(obj == null) goto _L2; else goto _L1
_L1:
        Double double4 = Double.valueOf(((Number)obj).doubleValue());
        Double double2 = double4;
_L3:
        double1 = double2;
_L4:
        return double1;
_L2:
        double2 = null;
          goto _L3
        ClassCastException classcastexception;
        classcastexception;
        if(!(obj instanceof CharSequence))
            break MISSING_BLOCK_LABEL_105;
        Double double3 = Double.valueOf(obj.toString());
        double1 = double3;
          goto _L4
        NumberFormatException numberformatexception;
        numberformatexception;
        Log.e("ContentValues", (new StringBuilder()).append("Cannot parse Double value for ").append(obj).append(" at key ").append(s).toString());
          goto _L4
        Log.e("ContentValues", (new StringBuilder()).append("Cannot cast value for ").append(s).append(" to a Double: ").append(obj).toString(), classcastexception);
          goto _L4
    }

    public Float getAsFloat(String s) {
        Float float1;
        Object obj;
        float1 = null;
        obj = mValues.get(s);
        if(obj == null) goto _L2; else goto _L1
_L1:
        Float float4 = Float.valueOf(((Number)obj).floatValue());
        Float float2 = float4;
_L3:
        float1 = float2;
_L4:
        return float1;
_L2:
        float2 = null;
          goto _L3
        ClassCastException classcastexception;
        classcastexception;
        if(!(obj instanceof CharSequence))
            break MISSING_BLOCK_LABEL_105;
        Float float3 = Float.valueOf(obj.toString());
        float1 = float3;
          goto _L4
        NumberFormatException numberformatexception;
        numberformatexception;
        Log.e("ContentValues", (new StringBuilder()).append("Cannot parse Float value for ").append(obj).append(" at key ").append(s).toString());
          goto _L4
        Log.e("ContentValues", (new StringBuilder()).append("Cannot cast value for ").append(s).append(" to a Float: ").append(obj).toString(), classcastexception);
          goto _L4
    }

    public Integer getAsInteger(String s) {
        Integer integer;
        Object obj;
        integer = null;
        obj = mValues.get(s);
        if(obj == null) goto _L2; else goto _L1
_L1:
        Integer integer3 = Integer.valueOf(((Number)obj).intValue());
        Integer integer1 = integer3;
_L3:
        integer = integer1;
_L4:
        return integer;
_L2:
        integer1 = null;
          goto _L3
        ClassCastException classcastexception;
        classcastexception;
        if(!(obj instanceof CharSequence))
            break MISSING_BLOCK_LABEL_105;
        Integer integer2 = Integer.valueOf(obj.toString());
        integer = integer2;
          goto _L4
        NumberFormatException numberformatexception;
        numberformatexception;
        Log.e("ContentValues", (new StringBuilder()).append("Cannot parse Integer value for ").append(obj).append(" at key ").append(s).toString());
          goto _L4
        Log.e("ContentValues", (new StringBuilder()).append("Cannot cast value for ").append(s).append(" to a Integer: ").append(obj).toString(), classcastexception);
          goto _L4
    }

    public Long getAsLong(String s) {
        Long long1;
        Object obj;
        long1 = null;
        obj = mValues.get(s);
        if(obj == null) goto _L2; else goto _L1
_L1:
        Long long4 = Long.valueOf(((Number)obj).longValue());
        Long long2 = long4;
_L3:
        long1 = long2;
_L4:
        return long1;
_L2:
        long2 = null;
          goto _L3
        ClassCastException classcastexception;
        classcastexception;
        if(!(obj instanceof CharSequence))
            break MISSING_BLOCK_LABEL_105;
        Long long3 = Long.valueOf(obj.toString());
        long1 = long3;
          goto _L4
        NumberFormatException numberformatexception;
        numberformatexception;
        Log.e("ContentValues", (new StringBuilder()).append("Cannot parse Long value for ").append(obj).append(" at key ").append(s).toString());
          goto _L4
        Log.e("ContentValues", (new StringBuilder()).append("Cannot cast value for ").append(s).append(" to a Long: ").append(obj).toString(), classcastexception);
          goto _L4
    }

    public Short getAsShort(String s) {
        Short short1;
        Object obj;
        short1 = null;
        obj = mValues.get(s);
        if(obj == null) goto _L2; else goto _L1
_L1:
        Short short4 = Short.valueOf(((Number)obj).shortValue());
        Short short2 = short4;
_L3:
        short1 = short2;
_L4:
        return short1;
_L2:
        short2 = null;
          goto _L3
        ClassCastException classcastexception;
        classcastexception;
        if(!(obj instanceof CharSequence))
            break MISSING_BLOCK_LABEL_105;
        Short short3 = Short.valueOf(obj.toString());
        short1 = short3;
          goto _L4
        NumberFormatException numberformatexception;
        numberformatexception;
        Log.e("ContentValues", (new StringBuilder()).append("Cannot parse Short value for ").append(obj).append(" at key ").append(s).toString());
          goto _L4
        Log.e("ContentValues", (new StringBuilder()).append("Cannot cast value for ").append(s).append(" to a Short: ").append(obj).toString(), classcastexception);
          goto _L4
    }

    public String getAsString(String s) {
        Object obj = mValues.get(s);
        String s1;
        if(obj != null)
            s1 = obj.toString();
        else
            s1 = null;
        return s1;
    }

    public ArrayList getStringArrayList(String s) {
        return (ArrayList)mValues.get(s);
    }

    public int hashCode() {
        return mValues.hashCode();
    }

    public Set keySet() {
        return mValues.keySet();
    }

    public void put(String s, Boolean boolean1) {
        mValues.put(s, boolean1);
    }

    public void put(String s, Byte byte1) {
        mValues.put(s, byte1);
    }

    public void put(String s, Double double1) {
        mValues.put(s, double1);
    }

    public void put(String s, Float float1) {
        mValues.put(s, float1);
    }

    public void put(String s, Integer integer) {
        mValues.put(s, integer);
    }

    public void put(String s, Long long1) {
        mValues.put(s, long1);
    }

    public void put(String s, Short short1) {
        mValues.put(s, short1);
    }

    public void put(String s, String s1) {
        mValues.put(s, s1);
    }

    public void put(String s, byte abyte0[]) {
        mValues.put(s, abyte0);
    }

    public void putAll(ContentValues contentvalues) {
        mValues.putAll(contentvalues.mValues);
    }

    public void putNull(String s) {
        mValues.put(s, null);
    }

    public void putStringArrayList(String s, ArrayList arraylist) {
        mValues.put(s, arraylist);
    }

    public void remove(String s) {
        mValues.remove(s);
    }

    public int size() {
        return mValues.size();
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder();
        String s;
        String s1;
        for(Iterator iterator = mValues.keySet().iterator(); iterator.hasNext(); stringbuilder.append((new StringBuilder()).append(s).append("=").append(s1).toString())) {
            s = (String)iterator.next();
            s1 = getAsString(s);
            if(stringbuilder.length() > 0)
                stringbuilder.append(" ");
        }

        return stringbuilder.toString();
    }

    public Set valueSet() {
        return mValues.entrySet();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(mValues);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ContentValues createFromParcel(Parcel parcel) {
            return new ContentValues(parcel.readHashMap(null));
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public ContentValues[] newArray(int i) {
            return new ContentValues[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final String TAG = "ContentValues";
    private HashMap mValues;

}
