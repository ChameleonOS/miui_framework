// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.renderscript;


// Referenced classes of package android.renderscript:
//            BaseObj, RenderScript, RSIllegalArgumentException

public class Element extends BaseObj {
    public static class Builder {

        public Builder add(Element element, String s) {
            return add(element, s, 1);
        }

        public Builder add(Element element, String s, int i) {
            if(i < 1)
                throw new RSIllegalArgumentException("Array size cannot be less than 1.");
            if(mSkipPadding != 0 && s.startsWith("#padding_")) {
                mSkipPadding = 0;
            } else {
                if(element.mVectorSize == 3)
                    mSkipPadding = 1;
                else
                    mSkipPadding = 0;
                if(mCount == mElements.length) {
                    Element aelement[] = new Element[8 + mCount];
                    String as[] = new String[8 + mCount];
                    int ai[] = new int[8 + mCount];
                    System.arraycopy(mElements, 0, aelement, 0, mCount);
                    System.arraycopy(mElementNames, 0, as, 0, mCount);
                    System.arraycopy(mArraySizes, 0, ai, 0, mCount);
                    mElements = aelement;
                    mElementNames = as;
                    mArraySizes = ai;
                }
                mElements[mCount] = element;
                mElementNames[mCount] = s;
                mArraySizes[mCount] = i;
                mCount = 1 + mCount;
            }
            return this;
        }

        public Element create() {
            mRS.validate();
            Element aelement[] = new Element[mCount];
            String as[] = new String[mCount];
            int ai[] = new int[mCount];
            System.arraycopy(mElements, 0, aelement, 0, mCount);
            System.arraycopy(mElementNames, 0, as, 0, mCount);
            System.arraycopy(mArraySizes, 0, ai, 0, mCount);
            int ai1[] = new int[aelement.length];
            for(int i = 0; i < aelement.length; i++)
                ai1[i] = aelement[i].getID(mRS);

            return new Element(mRS.nElementCreate2(ai1, as, ai), mRS, aelement, as, ai);
        }

        int mArraySizes[];
        int mCount;
        String mElementNames[];
        Element mElements[];
        RenderScript mRS;
        int mSkipPadding;

        public Builder(RenderScript renderscript) {
            mRS = renderscript;
            mCount = 0;
            mElements = new Element[8];
            mElementNames = new String[8];
            mArraySizes = new int[8];
        }
    }

    public static final class DataKind extends Enum {

        public static DataKind valueOf(String s) {
            return (DataKind)Enum.valueOf(android/renderscript/Element$DataKind, s);
        }

        public static DataKind[] values() {
            return (DataKind[])$VALUES.clone();
        }

        private static final DataKind $VALUES[];
        public static final DataKind PIXEL_A;
        public static final DataKind PIXEL_DEPTH;
        public static final DataKind PIXEL_L;
        public static final DataKind PIXEL_LA;
        public static final DataKind PIXEL_RGB;
        public static final DataKind PIXEL_RGBA;
        public static final DataKind USER;
        int mID;

        static  {
            USER = new DataKind("USER", 0, 0);
            PIXEL_L = new DataKind("PIXEL_L", 1, 7);
            PIXEL_A = new DataKind("PIXEL_A", 2, 8);
            PIXEL_LA = new DataKind("PIXEL_LA", 3, 9);
            PIXEL_RGB = new DataKind("PIXEL_RGB", 4, 10);
            PIXEL_RGBA = new DataKind("PIXEL_RGBA", 5, 11);
            PIXEL_DEPTH = new DataKind("PIXEL_DEPTH", 6, 12);
            DataKind adatakind[] = new DataKind[7];
            adatakind[0] = USER;
            adatakind[1] = PIXEL_L;
            adatakind[2] = PIXEL_A;
            adatakind[3] = PIXEL_LA;
            adatakind[4] = PIXEL_RGB;
            adatakind[5] = PIXEL_RGBA;
            adatakind[6] = PIXEL_DEPTH;
            $VALUES = adatakind;
        }

        private DataKind(String s, int i, int j) {
            super(s, i);
            mID = j;
        }
    }

    public static final class DataType extends Enum {

        public static DataType valueOf(String s) {
            return (DataType)Enum.valueOf(android/renderscript/Element$DataType, s);
        }

        public static DataType[] values() {
            return (DataType[])$VALUES.clone();
        }

        private static final DataType $VALUES[];
        public static final DataType BOOLEAN;
        public static final DataType FLOAT_32;
        public static final DataType FLOAT_64;
        public static final DataType MATRIX_2X2;
        public static final DataType MATRIX_3X3;
        public static final DataType MATRIX_4X4;
        public static final DataType NONE;
        public static final DataType RS_ALLOCATION;
        public static final DataType RS_ELEMENT;
        public static final DataType RS_FONT;
        public static final DataType RS_MESH;
        public static final DataType RS_PROGRAM_FRAGMENT;
        public static final DataType RS_PROGRAM_RASTER;
        public static final DataType RS_PROGRAM_STORE;
        public static final DataType RS_PROGRAM_VERTEX;
        public static final DataType RS_SAMPLER;
        public static final DataType RS_SCRIPT;
        public static final DataType RS_TYPE;
        public static final DataType SIGNED_16;
        public static final DataType SIGNED_32;
        public static final DataType SIGNED_64;
        public static final DataType SIGNED_8;
        public static final DataType UNSIGNED_16;
        public static final DataType UNSIGNED_32;
        public static final DataType UNSIGNED_4_4_4_4;
        public static final DataType UNSIGNED_5_5_5_1;
        public static final DataType UNSIGNED_5_6_5;
        public static final DataType UNSIGNED_64;
        public static final DataType UNSIGNED_8;
        int mID;
        int mSize;

        static  {
            NONE = new DataType("NONE", 0, 0, 0);
            FLOAT_32 = new DataType("FLOAT_32", 1, 2, 4);
            FLOAT_64 = new DataType("FLOAT_64", 2, 3, 8);
            SIGNED_8 = new DataType("SIGNED_8", 3, 4, 1);
            SIGNED_16 = new DataType("SIGNED_16", 4, 5, 2);
            SIGNED_32 = new DataType("SIGNED_32", 5, 6, 4);
            SIGNED_64 = new DataType("SIGNED_64", 6, 7, 8);
            UNSIGNED_8 = new DataType("UNSIGNED_8", 7, 8, 1);
            UNSIGNED_16 = new DataType("UNSIGNED_16", 8, 9, 2);
            UNSIGNED_32 = new DataType("UNSIGNED_32", 9, 10, 4);
            UNSIGNED_64 = new DataType("UNSIGNED_64", 10, 11, 8);
            BOOLEAN = new DataType("BOOLEAN", 11, 12, 1);
            UNSIGNED_5_6_5 = new DataType("UNSIGNED_5_6_5", 12, 13, 2);
            UNSIGNED_5_5_5_1 = new DataType("UNSIGNED_5_5_5_1", 13, 14, 2);
            UNSIGNED_4_4_4_4 = new DataType("UNSIGNED_4_4_4_4", 14, 15, 2);
            MATRIX_4X4 = new DataType("MATRIX_4X4", 15, 16, 64);
            MATRIX_3X3 = new DataType("MATRIX_3X3", 16, 17, 36);
            MATRIX_2X2 = new DataType("MATRIX_2X2", 17, 18, 16);
            RS_ELEMENT = new DataType("RS_ELEMENT", 18, 1000, 4);
            RS_TYPE = new DataType("RS_TYPE", 19, 1001, 4);
            RS_ALLOCATION = new DataType("RS_ALLOCATION", 20, 1002, 4);
            RS_SAMPLER = new DataType("RS_SAMPLER", 21, 1003, 4);
            RS_SCRIPT = new DataType("RS_SCRIPT", 22, 1004, 4);
            RS_MESH = new DataType("RS_MESH", 23, 1005, 4);
            RS_PROGRAM_FRAGMENT = new DataType("RS_PROGRAM_FRAGMENT", 24, 1006, 4);
            RS_PROGRAM_VERTEX = new DataType("RS_PROGRAM_VERTEX", 25, 1007, 4);
            RS_PROGRAM_RASTER = new DataType("RS_PROGRAM_RASTER", 26, 1008, 4);
            RS_PROGRAM_STORE = new DataType("RS_PROGRAM_STORE", 27, 1009, 4);
            RS_FONT = new DataType("RS_FONT", 28, 1010, 4);
            DataType adatatype[] = new DataType[29];
            adatatype[0] = NONE;
            adatatype[1] = FLOAT_32;
            adatatype[2] = FLOAT_64;
            adatatype[3] = SIGNED_8;
            adatatype[4] = SIGNED_16;
            adatatype[5] = SIGNED_32;
            adatatype[6] = SIGNED_64;
            adatatype[7] = UNSIGNED_8;
            adatatype[8] = UNSIGNED_16;
            adatatype[9] = UNSIGNED_32;
            adatatype[10] = UNSIGNED_64;
            adatatype[11] = BOOLEAN;
            adatatype[12] = UNSIGNED_5_6_5;
            adatatype[13] = UNSIGNED_5_5_5_1;
            adatatype[14] = UNSIGNED_4_4_4_4;
            adatatype[15] = MATRIX_4X4;
            adatatype[16] = MATRIX_3X3;
            adatatype[17] = MATRIX_2X2;
            adatatype[18] = RS_ELEMENT;
            adatatype[19] = RS_TYPE;
            adatatype[20] = RS_ALLOCATION;
            adatatype[21] = RS_SAMPLER;
            adatatype[22] = RS_SCRIPT;
            adatatype[23] = RS_MESH;
            adatatype[24] = RS_PROGRAM_FRAGMENT;
            adatatype[25] = RS_PROGRAM_VERTEX;
            adatatype[26] = RS_PROGRAM_RASTER;
            adatatype[27] = RS_PROGRAM_STORE;
            adatatype[28] = RS_FONT;
            $VALUES = adatatype;
        }

        private DataType(String s, int i, int j, int k) {
            super(s, i);
            mID = j;
            mSize = k;
        }
    }


    Element(int i, RenderScript renderscript) {
        super(i, renderscript);
    }

    Element(int i, RenderScript renderscript, DataType datatype, DataKind datakind, boolean flag, int j) {
        super(i, renderscript);
        if(datatype != DataType.UNSIGNED_5_6_5 && datatype != DataType.UNSIGNED_4_4_4_4 && datatype != DataType.UNSIGNED_5_5_5_1) {
            if(j == 3)
                mSize = 4 * datatype.mSize;
            else
                mSize = j * datatype.mSize;
        } else {
            mSize = datatype.mSize;
        }
        mType = datatype;
        mKind = datakind;
        mNormalized = flag;
        mVectorSize = j;
    }

    Element(int i, RenderScript renderscript, Element aelement[], String as[], int ai[]) {
        super(i, renderscript);
        mSize = 0;
        mVectorSize = 1;
        mElements = aelement;
        mElementNames = as;
        mArraySizes = ai;
        mType = DataType.NONE;
        mKind = DataKind.USER;
        mOffsetInBytes = new int[mElements.length];
        for(int j = 0; j < mElements.length; j++) {
            mOffsetInBytes[j] = mSize;
            mSize = mSize + mElements[j].mSize * mArraySizes[j];
        }

        updateVisibleSubElements();
    }

    public static Element ALLOCATION(RenderScript renderscript) {
        if(renderscript.mElement_ALLOCATION == null)
            renderscript.mElement_ALLOCATION = createUser(renderscript, DataType.RS_ALLOCATION);
        return renderscript.mElement_ALLOCATION;
    }

    public static Element A_8(RenderScript renderscript) {
        if(renderscript.mElement_A_8 == null)
            renderscript.mElement_A_8 = createPixel(renderscript, DataType.UNSIGNED_8, DataKind.PIXEL_A);
        return renderscript.mElement_A_8;
    }

    public static Element BOOLEAN(RenderScript renderscript) {
        if(renderscript.mElement_BOOLEAN == null)
            renderscript.mElement_BOOLEAN = createUser(renderscript, DataType.BOOLEAN);
        return renderscript.mElement_BOOLEAN;
    }

    public static Element ELEMENT(RenderScript renderscript) {
        if(renderscript.mElement_ELEMENT == null)
            renderscript.mElement_ELEMENT = createUser(renderscript, DataType.RS_ELEMENT);
        return renderscript.mElement_ELEMENT;
    }

    public static Element F32(RenderScript renderscript) {
        if(renderscript.mElement_F32 == null)
            renderscript.mElement_F32 = createUser(renderscript, DataType.FLOAT_32);
        return renderscript.mElement_F32;
    }

    public static Element F32_2(RenderScript renderscript) {
        if(renderscript.mElement_FLOAT_2 == null)
            renderscript.mElement_FLOAT_2 = createVector(renderscript, DataType.FLOAT_32, 2);
        return renderscript.mElement_FLOAT_2;
    }

    public static Element F32_3(RenderScript renderscript) {
        if(renderscript.mElement_FLOAT_3 == null)
            renderscript.mElement_FLOAT_3 = createVector(renderscript, DataType.FLOAT_32, 3);
        return renderscript.mElement_FLOAT_3;
    }

    public static Element F32_4(RenderScript renderscript) {
        if(renderscript.mElement_FLOAT_4 == null)
            renderscript.mElement_FLOAT_4 = createVector(renderscript, DataType.FLOAT_32, 4);
        return renderscript.mElement_FLOAT_4;
    }

    public static Element F64(RenderScript renderscript) {
        if(renderscript.mElement_F64 == null)
            renderscript.mElement_F64 = createUser(renderscript, DataType.FLOAT_64);
        return renderscript.mElement_F64;
    }

    public static Element F64_2(RenderScript renderscript) {
        if(renderscript.mElement_DOUBLE_2 == null)
            renderscript.mElement_DOUBLE_2 = createVector(renderscript, DataType.FLOAT_64, 2);
        return renderscript.mElement_DOUBLE_2;
    }

    public static Element F64_3(RenderScript renderscript) {
        if(renderscript.mElement_DOUBLE_3 == null)
            renderscript.mElement_DOUBLE_3 = createVector(renderscript, DataType.FLOAT_64, 3);
        return renderscript.mElement_DOUBLE_3;
    }

    public static Element F64_4(RenderScript renderscript) {
        if(renderscript.mElement_DOUBLE_4 == null)
            renderscript.mElement_DOUBLE_4 = createVector(renderscript, DataType.FLOAT_64, 4);
        return renderscript.mElement_DOUBLE_4;
    }

    public static Element FONT(RenderScript renderscript) {
        if(renderscript.mElement_FONT == null)
            renderscript.mElement_FONT = createUser(renderscript, DataType.RS_FONT);
        return renderscript.mElement_FONT;
    }

    public static Element I16(RenderScript renderscript) {
        if(renderscript.mElement_I16 == null)
            renderscript.mElement_I16 = createUser(renderscript, DataType.SIGNED_16);
        return renderscript.mElement_I16;
    }

    public static Element I16_2(RenderScript renderscript) {
        if(renderscript.mElement_SHORT_2 == null)
            renderscript.mElement_SHORT_2 = createVector(renderscript, DataType.SIGNED_16, 2);
        return renderscript.mElement_SHORT_2;
    }

    public static Element I16_3(RenderScript renderscript) {
        if(renderscript.mElement_SHORT_3 == null)
            renderscript.mElement_SHORT_3 = createVector(renderscript, DataType.SIGNED_16, 3);
        return renderscript.mElement_SHORT_3;
    }

    public static Element I16_4(RenderScript renderscript) {
        if(renderscript.mElement_SHORT_4 == null)
            renderscript.mElement_SHORT_4 = createVector(renderscript, DataType.SIGNED_16, 4);
        return renderscript.mElement_SHORT_4;
    }

    public static Element I32(RenderScript renderscript) {
        if(renderscript.mElement_I32 == null)
            renderscript.mElement_I32 = createUser(renderscript, DataType.SIGNED_32);
        return renderscript.mElement_I32;
    }

    public static Element I32_2(RenderScript renderscript) {
        if(renderscript.mElement_INT_2 == null)
            renderscript.mElement_INT_2 = createVector(renderscript, DataType.SIGNED_32, 2);
        return renderscript.mElement_INT_2;
    }

    public static Element I32_3(RenderScript renderscript) {
        if(renderscript.mElement_INT_3 == null)
            renderscript.mElement_INT_3 = createVector(renderscript, DataType.SIGNED_32, 3);
        return renderscript.mElement_INT_3;
    }

    public static Element I32_4(RenderScript renderscript) {
        if(renderscript.mElement_INT_4 == null)
            renderscript.mElement_INT_4 = createVector(renderscript, DataType.SIGNED_32, 4);
        return renderscript.mElement_INT_4;
    }

    public static Element I64(RenderScript renderscript) {
        if(renderscript.mElement_I64 == null)
            renderscript.mElement_I64 = createUser(renderscript, DataType.SIGNED_64);
        return renderscript.mElement_I64;
    }

    public static Element I64_2(RenderScript renderscript) {
        if(renderscript.mElement_LONG_2 == null)
            renderscript.mElement_LONG_2 = createVector(renderscript, DataType.SIGNED_64, 2);
        return renderscript.mElement_LONG_2;
    }

    public static Element I64_3(RenderScript renderscript) {
        if(renderscript.mElement_LONG_3 == null)
            renderscript.mElement_LONG_3 = createVector(renderscript, DataType.SIGNED_64, 3);
        return renderscript.mElement_LONG_3;
    }

    public static Element I64_4(RenderScript renderscript) {
        if(renderscript.mElement_LONG_4 == null)
            renderscript.mElement_LONG_4 = createVector(renderscript, DataType.SIGNED_64, 4);
        return renderscript.mElement_LONG_4;
    }

    public static Element I8(RenderScript renderscript) {
        if(renderscript.mElement_I8 == null)
            renderscript.mElement_I8 = createUser(renderscript, DataType.SIGNED_8);
        return renderscript.mElement_I8;
    }

    public static Element I8_2(RenderScript renderscript) {
        if(renderscript.mElement_CHAR_2 == null)
            renderscript.mElement_CHAR_2 = createVector(renderscript, DataType.SIGNED_8, 2);
        return renderscript.mElement_CHAR_2;
    }

    public static Element I8_3(RenderScript renderscript) {
        if(renderscript.mElement_CHAR_3 == null)
            renderscript.mElement_CHAR_3 = createVector(renderscript, DataType.SIGNED_8, 3);
        return renderscript.mElement_CHAR_3;
    }

    public static Element I8_4(RenderScript renderscript) {
        if(renderscript.mElement_CHAR_4 == null)
            renderscript.mElement_CHAR_4 = createVector(renderscript, DataType.SIGNED_8, 4);
        return renderscript.mElement_CHAR_4;
    }

    public static Element MATRIX4X4(RenderScript renderscript) {
        return MATRIX_4X4(renderscript);
    }

    public static Element MATRIX_2X2(RenderScript renderscript) {
        if(renderscript.mElement_MATRIX_2X2 == null)
            renderscript.mElement_MATRIX_2X2 = createUser(renderscript, DataType.MATRIX_2X2);
        return renderscript.mElement_MATRIX_2X2;
    }

    public static Element MATRIX_3X3(RenderScript renderscript) {
        if(renderscript.mElement_MATRIX_3X3 == null)
            renderscript.mElement_MATRIX_3X3 = createUser(renderscript, DataType.MATRIX_3X3);
        return renderscript.mElement_MATRIX_3X3;
    }

    public static Element MATRIX_4X4(RenderScript renderscript) {
        if(renderscript.mElement_MATRIX_4X4 == null)
            renderscript.mElement_MATRIX_4X4 = createUser(renderscript, DataType.MATRIX_4X4);
        return renderscript.mElement_MATRIX_4X4;
    }

    public static Element MESH(RenderScript renderscript) {
        if(renderscript.mElement_MESH == null)
            renderscript.mElement_MESH = createUser(renderscript, DataType.RS_MESH);
        return renderscript.mElement_MESH;
    }

    public static Element PROGRAM_FRAGMENT(RenderScript renderscript) {
        if(renderscript.mElement_PROGRAM_FRAGMENT == null)
            renderscript.mElement_PROGRAM_FRAGMENT = createUser(renderscript, DataType.RS_PROGRAM_FRAGMENT);
        return renderscript.mElement_PROGRAM_FRAGMENT;
    }

    public static Element PROGRAM_RASTER(RenderScript renderscript) {
        if(renderscript.mElement_PROGRAM_RASTER == null)
            renderscript.mElement_PROGRAM_RASTER = createUser(renderscript, DataType.RS_PROGRAM_RASTER);
        return renderscript.mElement_PROGRAM_RASTER;
    }

    public static Element PROGRAM_STORE(RenderScript renderscript) {
        if(renderscript.mElement_PROGRAM_STORE == null)
            renderscript.mElement_PROGRAM_STORE = createUser(renderscript, DataType.RS_PROGRAM_STORE);
        return renderscript.mElement_PROGRAM_STORE;
    }

    public static Element PROGRAM_VERTEX(RenderScript renderscript) {
        if(renderscript.mElement_PROGRAM_VERTEX == null)
            renderscript.mElement_PROGRAM_VERTEX = createUser(renderscript, DataType.RS_PROGRAM_VERTEX);
        return renderscript.mElement_PROGRAM_VERTEX;
    }

    public static Element RGBA_4444(RenderScript renderscript) {
        if(renderscript.mElement_RGBA_4444 == null)
            renderscript.mElement_RGBA_4444 = createPixel(renderscript, DataType.UNSIGNED_4_4_4_4, DataKind.PIXEL_RGBA);
        return renderscript.mElement_RGBA_4444;
    }

    public static Element RGBA_5551(RenderScript renderscript) {
        if(renderscript.mElement_RGBA_5551 == null)
            renderscript.mElement_RGBA_5551 = createPixel(renderscript, DataType.UNSIGNED_5_5_5_1, DataKind.PIXEL_RGBA);
        return renderscript.mElement_RGBA_5551;
    }

    public static Element RGBA_8888(RenderScript renderscript) {
        if(renderscript.mElement_RGBA_8888 == null)
            renderscript.mElement_RGBA_8888 = createPixel(renderscript, DataType.UNSIGNED_8, DataKind.PIXEL_RGBA);
        return renderscript.mElement_RGBA_8888;
    }

    public static Element RGB_565(RenderScript renderscript) {
        if(renderscript.mElement_RGB_565 == null)
            renderscript.mElement_RGB_565 = createPixel(renderscript, DataType.UNSIGNED_5_6_5, DataKind.PIXEL_RGB);
        return renderscript.mElement_RGB_565;
    }

    public static Element RGB_888(RenderScript renderscript) {
        if(renderscript.mElement_RGB_888 == null)
            renderscript.mElement_RGB_888 = createPixel(renderscript, DataType.UNSIGNED_8, DataKind.PIXEL_RGB);
        return renderscript.mElement_RGB_888;
    }

    public static Element SAMPLER(RenderScript renderscript) {
        if(renderscript.mElement_SAMPLER == null)
            renderscript.mElement_SAMPLER = createUser(renderscript, DataType.RS_SAMPLER);
        return renderscript.mElement_SAMPLER;
    }

    public static Element SCRIPT(RenderScript renderscript) {
        if(renderscript.mElement_SCRIPT == null)
            renderscript.mElement_SCRIPT = createUser(renderscript, DataType.RS_SCRIPT);
        return renderscript.mElement_SCRIPT;
    }

    public static Element TYPE(RenderScript renderscript) {
        if(renderscript.mElement_TYPE == null)
            renderscript.mElement_TYPE = createUser(renderscript, DataType.RS_TYPE);
        return renderscript.mElement_TYPE;
    }

    public static Element U16(RenderScript renderscript) {
        if(renderscript.mElement_U16 == null)
            renderscript.mElement_U16 = createUser(renderscript, DataType.UNSIGNED_16);
        return renderscript.mElement_U16;
    }

    public static Element U16_2(RenderScript renderscript) {
        if(renderscript.mElement_USHORT_2 == null)
            renderscript.mElement_USHORT_2 = createVector(renderscript, DataType.UNSIGNED_16, 2);
        return renderscript.mElement_USHORT_2;
    }

    public static Element U16_3(RenderScript renderscript) {
        if(renderscript.mElement_USHORT_3 == null)
            renderscript.mElement_USHORT_3 = createVector(renderscript, DataType.UNSIGNED_16, 3);
        return renderscript.mElement_USHORT_3;
    }

    public static Element U16_4(RenderScript renderscript) {
        if(renderscript.mElement_USHORT_4 == null)
            renderscript.mElement_USHORT_4 = createVector(renderscript, DataType.UNSIGNED_16, 4);
        return renderscript.mElement_USHORT_4;
    }

    public static Element U32(RenderScript renderscript) {
        if(renderscript.mElement_U32 == null)
            renderscript.mElement_U32 = createUser(renderscript, DataType.UNSIGNED_32);
        return renderscript.mElement_U32;
    }

    public static Element U32_2(RenderScript renderscript) {
        if(renderscript.mElement_UINT_2 == null)
            renderscript.mElement_UINT_2 = createVector(renderscript, DataType.UNSIGNED_32, 2);
        return renderscript.mElement_UINT_2;
    }

    public static Element U32_3(RenderScript renderscript) {
        if(renderscript.mElement_UINT_3 == null)
            renderscript.mElement_UINT_3 = createVector(renderscript, DataType.UNSIGNED_32, 3);
        return renderscript.mElement_UINT_3;
    }

    public static Element U32_4(RenderScript renderscript) {
        if(renderscript.mElement_UINT_4 == null)
            renderscript.mElement_UINT_4 = createVector(renderscript, DataType.UNSIGNED_32, 4);
        return renderscript.mElement_UINT_4;
    }

    public static Element U64(RenderScript renderscript) {
        if(renderscript.mElement_U64 == null)
            renderscript.mElement_U64 = createUser(renderscript, DataType.UNSIGNED_64);
        return renderscript.mElement_U64;
    }

    public static Element U64_2(RenderScript renderscript) {
        if(renderscript.mElement_ULONG_2 == null)
            renderscript.mElement_ULONG_2 = createVector(renderscript, DataType.UNSIGNED_64, 2);
        return renderscript.mElement_ULONG_2;
    }

    public static Element U64_3(RenderScript renderscript) {
        if(renderscript.mElement_ULONG_3 == null)
            renderscript.mElement_ULONG_3 = createVector(renderscript, DataType.UNSIGNED_64, 3);
        return renderscript.mElement_ULONG_3;
    }

    public static Element U64_4(RenderScript renderscript) {
        if(renderscript.mElement_ULONG_4 == null)
            renderscript.mElement_ULONG_4 = createVector(renderscript, DataType.UNSIGNED_64, 4);
        return renderscript.mElement_ULONG_4;
    }

    public static Element U8(RenderScript renderscript) {
        if(renderscript.mElement_U8 == null)
            renderscript.mElement_U8 = createUser(renderscript, DataType.UNSIGNED_8);
        return renderscript.mElement_U8;
    }

    public static Element U8_2(RenderScript renderscript) {
        if(renderscript.mElement_UCHAR_2 == null)
            renderscript.mElement_UCHAR_2 = createVector(renderscript, DataType.UNSIGNED_8, 2);
        return renderscript.mElement_UCHAR_2;
    }

    public static Element U8_3(RenderScript renderscript) {
        if(renderscript.mElement_UCHAR_3 == null)
            renderscript.mElement_UCHAR_3 = createVector(renderscript, DataType.UNSIGNED_8, 3);
        return renderscript.mElement_UCHAR_3;
    }

    public static Element U8_4(RenderScript renderscript) {
        if(renderscript.mElement_UCHAR_4 == null)
            renderscript.mElement_UCHAR_4 = createVector(renderscript, DataType.UNSIGNED_8, 4);
        return renderscript.mElement_UCHAR_4;
    }

    public static Element createPixel(RenderScript renderscript, DataType datatype, DataKind datakind) {
        int i;
        if(datakind != DataKind.PIXEL_L && datakind != DataKind.PIXEL_A && datakind != DataKind.PIXEL_LA && datakind != DataKind.PIXEL_RGB && datakind != DataKind.PIXEL_RGBA && datakind != DataKind.PIXEL_DEPTH)
            throw new RSIllegalArgumentException("Unsupported DataKind");
        if(datatype != DataType.UNSIGNED_8 && datatype != DataType.UNSIGNED_16 && datatype != DataType.UNSIGNED_5_6_5 && datatype != DataType.UNSIGNED_4_4_4_4 && datatype != DataType.UNSIGNED_5_5_5_1)
            throw new RSIllegalArgumentException("Unsupported DataType");
        if(datatype == DataType.UNSIGNED_5_6_5 && datakind != DataKind.PIXEL_RGB)
            throw new RSIllegalArgumentException("Bad kind and type combo");
        if(datatype == DataType.UNSIGNED_5_5_5_1 && datakind != DataKind.PIXEL_RGBA)
            throw new RSIllegalArgumentException("Bad kind and type combo");
        if(datatype == DataType.UNSIGNED_4_4_4_4 && datakind != DataKind.PIXEL_RGBA)
            throw new RSIllegalArgumentException("Bad kind and type combo");
        if(datatype == DataType.UNSIGNED_16 && datakind != DataKind.PIXEL_DEPTH)
            throw new RSIllegalArgumentException("Bad kind and type combo");
        i = 1;
        class _cls1 {

            static final int $SwitchMap$android$renderscript$Element$DataKind[];
            static final int $SwitchMap$android$renderscript$Element$DataType[];

            static  {
                $SwitchMap$android$renderscript$Element$DataKind = new int[DataKind.values().length];
                NoSuchFieldError nosuchfielderror14;
                try {
                    $SwitchMap$android$renderscript$Element$DataKind[DataKind.PIXEL_LA.ordinal()] = 1;
                }
                catch(NoSuchFieldError nosuchfielderror) { }
                try {
                    $SwitchMap$android$renderscript$Element$DataKind[DataKind.PIXEL_RGB.ordinal()] = 2;
                }
                catch(NoSuchFieldError nosuchfielderror1) { }
                try {
                    $SwitchMap$android$renderscript$Element$DataKind[DataKind.PIXEL_RGBA.ordinal()] = 3;
                }
                catch(NoSuchFieldError nosuchfielderror2) { }
                try {
                    $SwitchMap$android$renderscript$Element$DataKind[DataKind.PIXEL_DEPTH.ordinal()] = 4;
                }
                catch(NoSuchFieldError nosuchfielderror3) { }
                $SwitchMap$android$renderscript$Element$DataType = new int[DataType.values().length];
                try {
                    $SwitchMap$android$renderscript$Element$DataType[DataType.FLOAT_32.ordinal()] = 1;
                }
                catch(NoSuchFieldError nosuchfielderror4) { }
                try {
                    $SwitchMap$android$renderscript$Element$DataType[DataType.FLOAT_64.ordinal()] = 2;
                }
                catch(NoSuchFieldError nosuchfielderror5) { }
                try {
                    $SwitchMap$android$renderscript$Element$DataType[DataType.SIGNED_8.ordinal()] = 3;
                }
                catch(NoSuchFieldError nosuchfielderror6) { }
                try {
                    $SwitchMap$android$renderscript$Element$DataType[DataType.SIGNED_16.ordinal()] = 4;
                }
                catch(NoSuchFieldError nosuchfielderror7) { }
                try {
                    $SwitchMap$android$renderscript$Element$DataType[DataType.SIGNED_32.ordinal()] = 5;
                }
                catch(NoSuchFieldError nosuchfielderror8) { }
                try {
                    $SwitchMap$android$renderscript$Element$DataType[DataType.SIGNED_64.ordinal()] = 6;
                }
                catch(NoSuchFieldError nosuchfielderror9) { }
                try {
                    $SwitchMap$android$renderscript$Element$DataType[DataType.UNSIGNED_8.ordinal()] = 7;
                }
                catch(NoSuchFieldError nosuchfielderror10) { }
                try {
                    $SwitchMap$android$renderscript$Element$DataType[DataType.UNSIGNED_16.ordinal()] = 8;
                }
                catch(NoSuchFieldError nosuchfielderror11) { }
                try {
                    $SwitchMap$android$renderscript$Element$DataType[DataType.UNSIGNED_32.ordinal()] = 9;
                }
                catch(NoSuchFieldError nosuchfielderror12) { }
                try {
                    $SwitchMap$android$renderscript$Element$DataType[DataType.UNSIGNED_64.ordinal()] = 10;
                }
                catch(NoSuchFieldError nosuchfielderror13) { }
                $SwitchMap$android$renderscript$Element$DataType[DataType.BOOLEAN.ordinal()] = 11;
_L2:
                return;
                nosuchfielderror14;
                if(true) goto _L2; else goto _L1
_L1:
            }
        }

        _cls1..SwitchMap.android.renderscript.Element.DataKind[datakind.ordinal()];
        JVM INSTR tableswitch 1 4: default 240
    //                   1 267
    //                   2 272
    //                   3 277
    //                   4 282;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return new Element(renderscript.nElementCreate(datatype.mID, datakind.mID, true, i), renderscript, datatype, datakind, true, i);
_L2:
        i = 2;
        continue; /* Loop/switch isn't completed */
_L3:
        i = 3;
        continue; /* Loop/switch isn't completed */
_L4:
        i = 4;
        continue; /* Loop/switch isn't completed */
_L5:
        i = 2;
        if(true) goto _L1; else goto _L6
_L6:
    }

    static Element createUser(RenderScript renderscript, DataType datatype) {
        DataKind datakind = DataKind.USER;
        return new Element(renderscript.nElementCreate(datatype.mID, datakind.mID, false, 1), renderscript, datatype, datakind, false, 1);
    }

    public static Element createVector(RenderScript renderscript, DataType datatype, int i) {
        if(i < 2 || i > 4)
            throw new RSIllegalArgumentException("Vector size out of range 2-4.");
        DataKind datakind;
        switch(_cls1..SwitchMap.android.renderscript.Element.DataType[datatype.ordinal()]) {
        default:
            throw new RSIllegalArgumentException("Cannot create vector of non-primitive type.");

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
        case 11: // '\013'
            datakind = DataKind.USER;
            break;
        }
        return new Element(renderscript.nElementCreate(datatype.mID, datakind.mID, false, i), renderscript, datatype, datakind, false, i);
    }

    private void updateVisibleSubElements() {
        if(mElements != null) {
            int i = 0;
            int j = mElementNames.length;
            for(int k = 0; k < j; k++)
                if(mElementNames[k].charAt(0) != '#')
                    i++;

            mVisibleElementMap = new int[i];
            int l = 0;
            int i1 = 0;
            while(l < j)  {
                int j1;
                if(mElementNames[l].charAt(0) != '#') {
                    int ai[] = mVisibleElementMap;
                    j1 = i1 + 1;
                    ai[i1] = l;
                } else {
                    j1 = i1;
                }
                l++;
                i1 = j1;
            }
        }
    }

    public int getBytesSize() {
        return mSize;
    }

    public DataKind getDataKind() {
        return mKind;
    }

    public DataType getDataType() {
        return mType;
    }

    public Element getSubElement(int i) {
        if(mVisibleElementMap == null)
            throw new RSIllegalArgumentException("Element contains no sub-elements");
        if(i < 0 || i >= mVisibleElementMap.length)
            throw new RSIllegalArgumentException("Illegal sub-element index");
        else
            return mElements[mVisibleElementMap[i]];
    }

    public int getSubElementArraySize(int i) {
        if(mVisibleElementMap == null)
            throw new RSIllegalArgumentException("Element contains no sub-elements");
        if(i < 0 || i >= mVisibleElementMap.length)
            throw new RSIllegalArgumentException("Illegal sub-element index");
        else
            return mArraySizes[mVisibleElementMap[i]];
    }

    public int getSubElementCount() {
        int i;
        if(mVisibleElementMap == null)
            i = 0;
        else
            i = mVisibleElementMap.length;
        return i;
    }

    public String getSubElementName(int i) {
        if(mVisibleElementMap == null)
            throw new RSIllegalArgumentException("Element contains no sub-elements");
        if(i < 0 || i >= mVisibleElementMap.length)
            throw new RSIllegalArgumentException("Illegal sub-element index");
        else
            return mElementNames[mVisibleElementMap[i]];
    }

    public int getSubElementOffsetBytes(int i) {
        if(mVisibleElementMap == null)
            throw new RSIllegalArgumentException("Element contains no sub-elements");
        if(i < 0 || i >= mVisibleElementMap.length)
            throw new RSIllegalArgumentException("Illegal sub-element index");
        else
            return mOffsetInBytes[mVisibleElementMap[i]];
    }

    public int getVectorSize() {
        return mVectorSize;
    }

    public boolean isCompatible(Element element) {
        boolean flag;
        flag = true;
        break MISSING_BLOCK_LABEL_2;
        if(!equals(element) && (mSize != element.mSize || mType == DataType.NONE || mType != element.mType || mVectorSize != element.mVectorSize))
            flag = false;
        return flag;
    }

    public boolean isComplex() {
        boolean flag = false;
        if(mElements != null) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        int i = 0;
        do {
            if(i < mElements.length) {
label0:
                {
                    if(mElements[i].mElements == null)
                        break label0;
                    flag = true;
                }
            }
            if(true)
                continue;
            i++;
        } while(true);
        if(true) goto _L1; else goto _L3
_L3:
    }

    void updateFromNative() {
        super.updateFromNative();
        int ai[] = new int[5];
        super.mRS.nElementGetNativeData(getID(super.mRS), ai);
        boolean flag;
        DataType adatatype[];
        int i;
        if(ai[2] == 1)
            flag = true;
        else
            flag = false;
        mNormalized = flag;
        mVectorSize = ai[3];
        mSize = 0;
        adatatype = DataType.values();
        i = adatatype.length;
        for(int j = 0; j < i; j++) {
            DataType datatype = adatatype[j];
            if(datatype.mID == ai[0]) {
                mType = datatype;
                mSize = mType.mSize * mVectorSize;
            }
        }

        DataKind adatakind[] = DataKind.values();
        int k = adatakind.length;
        for(int l = 0; l < k; l++) {
            DataKind datakind = adatakind[l];
            if(datakind.mID == ai[1])
                mKind = datakind;
        }

        int i1 = ai[4];
        if(i1 > 0) {
            mElements = new Element[i1];
            mElementNames = new String[i1];
            mArraySizes = new int[i1];
            mOffsetInBytes = new int[i1];
            int ai1[] = new int[i1];
            super.mRS.nElementGetSubElements(getID(super.mRS), ai1, mElementNames, mArraySizes);
            for(int j1 = 0; j1 < i1; j1++) {
                mElements[j1] = new Element(ai1[j1], super.mRS);
                mElements[j1].updateFromNative();
                mOffsetInBytes[j1] = mSize;
                mSize = mSize + mElements[j1].mSize * mArraySizes[j1];
            }

        }
        updateVisibleSubElements();
    }

    int mArraySizes[];
    String mElementNames[];
    Element mElements[];
    DataKind mKind;
    boolean mNormalized;
    int mOffsetInBytes[];
    int mSize;
    DataType mType;
    int mVectorSize;
    int mVisibleElementMap[];
}
