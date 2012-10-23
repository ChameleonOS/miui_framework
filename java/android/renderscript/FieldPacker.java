// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.renderscript;

import android.util.Log;

// Referenced classes of package android.renderscript:
//            Float2, Float3, Float4, Double2, 
//            Double3, Double4, Short2, Short3, 
//            Short4, Int2, Int3, Int4, 
//            Long2, Long3, Long4, Byte2, 
//            Byte3, Byte4, Matrix2f, Matrix3f, 
//            Matrix4f, BaseObj, RSIllegalArgumentException

public class FieldPacker {

    public FieldPacker(int i) {
        mPos = 0;
        mLen = i;
        mData = new byte[i];
    }

    public void addBoolean(boolean flag) {
        int i;
        if(flag)
            i = 1;
        else
            i = 0;
        addI8((byte)i);
    }

    public void addF32(float f) {
        addI32(Float.floatToRawIntBits(f));
    }

    public void addF32(Float2 float2) {
        addF32(float2.x);
        addF32(float2.y);
    }

    public void addF32(Float3 float3) {
        addF32(float3.x);
        addF32(float3.y);
        addF32(float3.z);
    }

    public void addF32(Float4 float4) {
        addF32(float4.x);
        addF32(float4.y);
        addF32(float4.z);
        addF32(float4.w);
    }

    public void addF64(double d) {
        addI64(Double.doubleToRawLongBits(d));
    }

    public void addF64(Double2 double2) {
        addF64(double2.x);
        addF64(double2.y);
    }

    public void addF64(Double3 double3) {
        addF64(double3.x);
        addF64(double3.y);
        addF64(double3.z);
    }

    public void addF64(Double4 double4) {
        addF64(double4.x);
        addF64(double4.y);
        addF64(double4.z);
        addF64(double4.w);
    }

    public void addI16(Short2 short2) {
        addI16(short2.x);
        addI16(short2.y);
    }

    public void addI16(Short3 short3) {
        addI16(short3.x);
        addI16(short3.y);
        addI16(short3.z);
    }

    public void addI16(Short4 short4) {
        addI16(short4.x);
        addI16(short4.y);
        addI16(short4.z);
        addI16(short4.w);
    }

    public void addI16(short word0) {
        align(2);
        byte abyte0[] = mData;
        int i = mPos;
        mPos = i + 1;
        abyte0[i] = (byte)(word0 & 0xff);
        byte abyte1[] = mData;
        int j = mPos;
        mPos = j + 1;
        abyte1[j] = (byte)(word0 >> 8);
    }

    public void addI32(int i) {
        align(4);
        byte abyte0[] = mData;
        int j = mPos;
        mPos = j + 1;
        abyte0[j] = (byte)(i & 0xff);
        byte abyte1[] = mData;
        int k = mPos;
        mPos = k + 1;
        abyte1[k] = (byte)(0xff & i >> 8);
        byte abyte2[] = mData;
        int l = mPos;
        mPos = l + 1;
        abyte2[l] = (byte)(0xff & i >> 16);
        byte abyte3[] = mData;
        int i1 = mPos;
        mPos = i1 + 1;
        abyte3[i1] = (byte)(0xff & i >> 24);
    }

    public void addI32(Int2 int2) {
        addI32(int2.x);
        addI32(int2.y);
    }

    public void addI32(Int3 int3) {
        addI32(int3.x);
        addI32(int3.y);
        addI32(int3.z);
    }

    public void addI32(Int4 int4) {
        addI32(int4.x);
        addI32(int4.y);
        addI32(int4.z);
        addI32(int4.w);
    }

    public void addI64(long l) {
        align(8);
        byte abyte0[] = mData;
        int i = mPos;
        mPos = i + 1;
        abyte0[i] = (byte)(int)(l & 255L);
        byte abyte1[] = mData;
        int j = mPos;
        mPos = j + 1;
        abyte1[j] = (byte)(int)(255L & l >> 8);
        byte abyte2[] = mData;
        int k = mPos;
        mPos = k + 1;
        abyte2[k] = (byte)(int)(255L & l >> 16);
        byte abyte3[] = mData;
        int i1 = mPos;
        mPos = i1 + 1;
        abyte3[i1] = (byte)(int)(255L & l >> 24);
        byte abyte4[] = mData;
        int j1 = mPos;
        mPos = j1 + 1;
        abyte4[j1] = (byte)(int)(255L & l >> 32);
        byte abyte5[] = mData;
        int k1 = mPos;
        mPos = k1 + 1;
        abyte5[k1] = (byte)(int)(255L & l >> 40);
        byte abyte6[] = mData;
        int l1 = mPos;
        mPos = l1 + 1;
        abyte6[l1] = (byte)(int)(255L & l >> 48);
        byte abyte7[] = mData;
        int i2 = mPos;
        mPos = i2 + 1;
        abyte7[i2] = (byte)(int)(255L & l >> 56);
    }

    public void addI64(Long2 long2) {
        addI64(long2.x);
        addI64(long2.y);
    }

    public void addI64(Long3 long3) {
        addI64(long3.x);
        addI64(long3.y);
        addI64(long3.z);
    }

    public void addI64(Long4 long4) {
        addI64(long4.x);
        addI64(long4.y);
        addI64(long4.z);
        addI64(long4.w);
    }

    public void addI8(byte byte0) {
        byte abyte0[] = mData;
        int i = mPos;
        mPos = i + 1;
        abyte0[i] = byte0;
    }

    public void addI8(Byte2 byte2) {
        addI8(byte2.x);
        addI8(byte2.y);
    }

    public void addI8(Byte3 byte3) {
        addI8(byte3.x);
        addI8(byte3.y);
        addI8(byte3.z);
    }

    public void addI8(Byte4 byte4) {
        addI8(byte4.x);
        addI8(byte4.y);
        addI8(byte4.z);
        addI8(byte4.w);
    }

    public void addMatrix(Matrix2f matrix2f) {
        for(int i = 0; i < matrix2f.mMat.length; i++)
            addF32(matrix2f.mMat[i]);

    }

    public void addMatrix(Matrix3f matrix3f) {
        for(int i = 0; i < matrix3f.mMat.length; i++)
            addF32(matrix3f.mMat[i]);

    }

    public void addMatrix(Matrix4f matrix4f) {
        for(int i = 0; i < matrix4f.mMat.length; i++)
            addF32(matrix4f.mMat[i]);

    }

    public void addObj(BaseObj baseobj) {
        if(baseobj != null)
            addI32(baseobj.getID(null));
        else
            addI32(0);
    }

    public void addU16(int i) {
        if(i < 0 || i > 65535) {
            Log.e("rs", (new StringBuilder()).append("FieldPacker.addU16( ").append(i).append(" )").toString());
            throw new IllegalArgumentException("Saving value out of range for type");
        } else {
            align(2);
            byte abyte0[] = mData;
            int j = mPos;
            mPos = j + 1;
            abyte0[j] = (byte)(i & 0xff);
            byte abyte1[] = mData;
            int k = mPos;
            mPos = k + 1;
            abyte1[k] = (byte)(i >> 8);
            return;
        }
    }

    public void addU16(Int2 int2) {
        addU16(int2.x);
        addU16(int2.y);
    }

    public void addU16(Int3 int3) {
        addU16(int3.x);
        addU16(int3.y);
        addU16(int3.z);
    }

    public void addU16(Int4 int4) {
        addU16(int4.x);
        addU16(int4.y);
        addU16(int4.z);
        addU16(int4.w);
    }

    public void addU32(long l) {
        if(l < 0L || l > 0xffffffffL) {
            Log.e("rs", (new StringBuilder()).append("FieldPacker.addU32( ").append(l).append(" )").toString());
            throw new IllegalArgumentException("Saving value out of range for type");
        } else {
            align(4);
            byte abyte0[] = mData;
            int i = mPos;
            mPos = i + 1;
            abyte0[i] = (byte)(int)(l & 255L);
            byte abyte1[] = mData;
            int j = mPos;
            mPos = j + 1;
            abyte1[j] = (byte)(int)(255L & l >> 8);
            byte abyte2[] = mData;
            int k = mPos;
            mPos = k + 1;
            abyte2[k] = (byte)(int)(255L & l >> 16);
            byte abyte3[] = mData;
            int i1 = mPos;
            mPos = i1 + 1;
            abyte3[i1] = (byte)(int)(255L & l >> 24);
            return;
        }
    }

    public void addU32(Long2 long2) {
        addU32(long2.x);
        addU32(long2.y);
    }

    public void addU32(Long3 long3) {
        addU32(long3.x);
        addU32(long3.y);
        addU32(long3.z);
    }

    public void addU32(Long4 long4) {
        addU32(long4.x);
        addU32(long4.y);
        addU32(long4.z);
        addU32(long4.w);
    }

    public void addU64(long l) {
        if(l < 0L) {
            Log.e("rs", (new StringBuilder()).append("FieldPacker.addU64( ").append(l).append(" )").toString());
            throw new IllegalArgumentException("Saving value out of range for type");
        } else {
            align(8);
            byte abyte0[] = mData;
            int i = mPos;
            mPos = i + 1;
            abyte0[i] = (byte)(int)(l & 255L);
            byte abyte1[] = mData;
            int j = mPos;
            mPos = j + 1;
            abyte1[j] = (byte)(int)(255L & l >> 8);
            byte abyte2[] = mData;
            int k = mPos;
            mPos = k + 1;
            abyte2[k] = (byte)(int)(255L & l >> 16);
            byte abyte3[] = mData;
            int i1 = mPos;
            mPos = i1 + 1;
            abyte3[i1] = (byte)(int)(255L & l >> 24);
            byte abyte4[] = mData;
            int j1 = mPos;
            mPos = j1 + 1;
            abyte4[j1] = (byte)(int)(255L & l >> 32);
            byte abyte5[] = mData;
            int k1 = mPos;
            mPos = k1 + 1;
            abyte5[k1] = (byte)(int)(255L & l >> 40);
            byte abyte6[] = mData;
            int l1 = mPos;
            mPos = l1 + 1;
            abyte6[l1] = (byte)(int)(255L & l >> 48);
            byte abyte7[] = mData;
            int i2 = mPos;
            mPos = i2 + 1;
            abyte7[i2] = (byte)(int)(255L & l >> 56);
            return;
        }
    }

    public void addU64(Long2 long2) {
        addU64(long2.x);
        addU64(long2.y);
    }

    public void addU64(Long3 long3) {
        addU64(long3.x);
        addU64(long3.y);
        addU64(long3.z);
    }

    public void addU64(Long4 long4) {
        addU64(long4.x);
        addU64(long4.y);
        addU64(long4.z);
        addU64(long4.w);
    }

    public void addU8(Short2 short2) {
        addU8(short2.x);
        addU8(short2.y);
    }

    public void addU8(Short3 short3) {
        addU8(short3.x);
        addU8(short3.y);
        addU8(short3.z);
    }

    public void addU8(Short4 short4) {
        addU8(short4.x);
        addU8(short4.y);
        addU8(short4.z);
        addU8(short4.w);
    }

    public void addU8(short word0) {
        if(word0 < 0 || word0 > 255) {
            Log.e("rs", (new StringBuilder()).append("FieldPacker.addU8( ").append(word0).append(" )").toString());
            throw new IllegalArgumentException("Saving value out of range for type");
        } else {
            byte abyte0[] = mData;
            int i = mPos;
            mPos = i + 1;
            abyte0[i] = (byte)word0;
            return;
        }
    }

    public void align(int i) {
        if(i <= 0 || (i & i - 1) != 0)
            throw new RSIllegalArgumentException((new StringBuilder()).append("argument must be a non-negative non-zero power of 2: ").append(i).toString());
        while((mPos & i - 1) != 0)  {
            byte abyte0[] = mData;
            int j = mPos;
            mPos = j + 1;
            abyte0[j] = 0;
        }
    }

    public final byte[] getData() {
        return mData;
    }

    public void reset() {
        mPos = 0;
    }

    public void reset(int i) {
        if(i < 0 || i >= mLen) {
            throw new RSIllegalArgumentException((new StringBuilder()).append("out of range argument: ").append(i).toString());
        } else {
            mPos = i;
            return;
        }
    }

    public void skip(int i) {
        int j = i + mPos;
        if(j < 0 || j > mLen) {
            throw new RSIllegalArgumentException((new StringBuilder()).append("out of range argument: ").append(i).toString());
        } else {
            mPos = j;
            return;
        }
    }

    private final byte mData[];
    private int mLen;
    private int mPos;
}
