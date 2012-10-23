// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.renderscript;

import android.content.res.Resources;
import android.graphics.*;
import android.view.Surface;

// Referenced classes of package android.renderscript:
//            BaseObj, RSIllegalArgumentException, RenderScript, Type, 
//            RSRuntimeException, AllocationAdapter, Element, RSInvalidStateException, 
//            FieldPacker

public class Allocation extends BaseObj {
    public static final class MipmapControl extends Enum {

        public static MipmapControl valueOf(String s) {
            return (MipmapControl)Enum.valueOf(android/renderscript/Allocation$MipmapControl, s);
        }

        public static MipmapControl[] values() {
            return (MipmapControl[])$VALUES.clone();
        }

        private static final MipmapControl $VALUES[];
        public static final MipmapControl MIPMAP_FULL;
        public static final MipmapControl MIPMAP_NONE;
        public static final MipmapControl MIPMAP_ON_SYNC_TO_TEXTURE;
        int mID;

        static  {
            MIPMAP_NONE = new MipmapControl("MIPMAP_NONE", 0, 0);
            MIPMAP_FULL = new MipmapControl("MIPMAP_FULL", 1, 1);
            MIPMAP_ON_SYNC_TO_TEXTURE = new MipmapControl("MIPMAP_ON_SYNC_TO_TEXTURE", 2, 2);
            MipmapControl amipmapcontrol[] = new MipmapControl[3];
            amipmapcontrol[0] = MIPMAP_NONE;
            amipmapcontrol[1] = MIPMAP_FULL;
            amipmapcontrol[2] = MIPMAP_ON_SYNC_TO_TEXTURE;
            $VALUES = amipmapcontrol;
        }

        private MipmapControl(String s, int i, int j) {
            super(s, i);
            mID = j;
        }
    }


    Allocation(int i, RenderScript renderscript, Type type, int j) {
        super(i, renderscript);
        mReadAllowed = true;
        mWriteAllowed = true;
        mSelectedFace = Type.CubemapFace.POSITIVE_X;
        if((j & 0xffffff80) != 0)
            throw new RSIllegalArgumentException("Unknown usage specified.");
        if((j & 0x20) != 0) {
            mWriteAllowed = false;
            if((j & 0xffffffdc) != 0)
                throw new RSIllegalArgumentException("Invalid usage combination.");
        }
        mType = type;
        mUsage = j;
        if(type != null)
            updateCacheInfo(type);
    }

    public static Allocation createCubemapFromBitmap(RenderScript renderscript, Bitmap bitmap) {
        return createCubemapFromBitmap(renderscript, bitmap, MipmapControl.MIPMAP_NONE, 2);
    }

    public static Allocation createCubemapFromBitmap(RenderScript renderscript, Bitmap bitmap, MipmapControl mipmapcontrol, int i) {
        boolean flag = true;
        renderscript.validate();
        int j = bitmap.getHeight();
        int k = bitmap.getWidth();
        if(k % 6 != 0)
            throw new RSIllegalArgumentException("Cubemap height must be multiple of 6");
        if(k / 6 != j)
            throw new RSIllegalArgumentException("Only square cube map faces supported");
        boolean flag1;
        if((j & j - 1) == 0)
            flag1 = flag;
        else
            flag1 = false;
        if(!flag1)
            throw new RSIllegalArgumentException("Only power of 2 cube faces supported");
        Element element = elementFromBitmap(renderscript, bitmap);
        Type.Builder builder = new Type.Builder(renderscript, element);
        builder.setX(j);
        builder.setY(j);
        builder.setFaces(flag);
        Type type;
        int l;
        if(mipmapcontrol != MipmapControl.MIPMAP_FULL)
            flag = false;
        builder.setMipmaps(flag);
        type = builder.create();
        l = renderscript.nAllocationCubeCreateFromBitmap(type.getID(renderscript), mipmapcontrol.mID, bitmap, i);
        if(l == 0)
            throw new RSRuntimeException((new StringBuilder()).append("Load failed for bitmap ").append(bitmap).append(" element ").append(element).toString());
        else
            return new Allocation(l, renderscript, type, i);
    }

    public static Allocation createCubemapFromCubeFaces(RenderScript renderscript, Bitmap bitmap, Bitmap bitmap1, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5) {
        return createCubemapFromCubeFaces(renderscript, bitmap, bitmap1, bitmap2, bitmap3, bitmap4, bitmap5, MipmapControl.MIPMAP_NONE, 2);
    }

    public static Allocation createCubemapFromCubeFaces(RenderScript renderscript, Bitmap bitmap, Bitmap bitmap1, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, MipmapControl mipmapcontrol, 
            int i) {
        int j = bitmap.getHeight();
        if(bitmap.getWidth() != j || bitmap1.getWidth() != j || bitmap1.getHeight() != j || bitmap2.getWidth() != j || bitmap2.getHeight() != j || bitmap3.getWidth() != j || bitmap3.getHeight() != j || bitmap4.getWidth() != j || bitmap4.getHeight() != j || bitmap5.getWidth() != j || bitmap5.getHeight() != j)
            throw new RSIllegalArgumentException("Only square cube map faces supported");
        boolean flag;
        if((j & j - 1) == 0)
            flag = true;
        else
            flag = false;
        if(!flag)
            throw new RSIllegalArgumentException("Only power of 2 cube faces supported");
        Type.Builder builder = new Type.Builder(renderscript, elementFromBitmap(renderscript, bitmap));
        builder.setX(j);
        builder.setY(j);
        builder.setFaces(true);
        boolean flag1;
        Allocation allocation;
        AllocationAdapter allocationadapter;
        if(mipmapcontrol == MipmapControl.MIPMAP_FULL)
            flag1 = true;
        else
            flag1 = false;
        builder.setMipmaps(flag1);
        allocation = createTyped(renderscript, builder.create(), mipmapcontrol, i);
        allocationadapter = AllocationAdapter.create2D(renderscript, allocation);
        allocationadapter.setFace(Type.CubemapFace.POSITIVE_X);
        allocationadapter.copyFrom(bitmap);
        allocationadapter.setFace(Type.CubemapFace.NEGATIVE_X);
        allocationadapter.copyFrom(bitmap1);
        allocationadapter.setFace(Type.CubemapFace.POSITIVE_Y);
        allocationadapter.copyFrom(bitmap2);
        allocationadapter.setFace(Type.CubemapFace.NEGATIVE_Y);
        allocationadapter.copyFrom(bitmap3);
        allocationadapter.setFace(Type.CubemapFace.POSITIVE_Z);
        allocationadapter.copyFrom(bitmap4);
        allocationadapter.setFace(Type.CubemapFace.NEGATIVE_Z);
        allocationadapter.copyFrom(bitmap5);
        return allocation;
    }

    public static Allocation createFromBitmap(RenderScript renderscript, Bitmap bitmap) {
        return createFromBitmap(renderscript, bitmap, MipmapControl.MIPMAP_NONE, 2);
    }

    public static Allocation createFromBitmap(RenderScript renderscript, Bitmap bitmap, MipmapControl mipmapcontrol, int i) {
        renderscript.validate();
        Type type = typeFromBitmap(renderscript, bitmap, mipmapcontrol);
        int j = renderscript.nAllocationCreateFromBitmap(type.getID(renderscript), mipmapcontrol.mID, bitmap, i);
        if(j == 0)
            throw new RSRuntimeException("Load failed.");
        else
            return new Allocation(j, renderscript, type, i);
    }

    public static Allocation createFromBitmapResource(RenderScript renderscript, Resources resources, int i) {
        return createFromBitmapResource(renderscript, resources, i, MipmapControl.MIPMAP_NONE, 2);
    }

    public static Allocation createFromBitmapResource(RenderScript renderscript, Resources resources, int i, MipmapControl mipmapcontrol, int j) {
        renderscript.validate();
        Bitmap bitmap = BitmapFactory.decodeResource(resources, i);
        Allocation allocation = createFromBitmap(renderscript, bitmap, mipmapcontrol, j);
        bitmap.recycle();
        return allocation;
    }

    public static Allocation createFromString(RenderScript renderscript, String s, int i) {
        renderscript.validate();
        Allocation allocation;
        try {
            byte abyte0[] = s.getBytes("UTF-8");
            allocation = createSized(renderscript, Element.U8(renderscript), abyte0.length, i);
            allocation.copyFrom(abyte0);
        }
        catch(Exception exception) {
            throw new RSRuntimeException("Could not convert string to utf-8.");
        }
        return allocation;
    }

    public static Allocation createSized(RenderScript renderscript, Element element, int i) {
        return createSized(renderscript, element, i, 1);
    }

    public static Allocation createSized(RenderScript renderscript, Element element, int i, int j) {
        renderscript.validate();
        Type.Builder builder = new Type.Builder(renderscript, element);
        builder.setX(i);
        Type type = builder.create();
        int k = renderscript.nAllocationCreateTyped(type.getID(renderscript), MipmapControl.MIPMAP_NONE.mID, j, 0);
        if(k == 0)
            throw new RSRuntimeException("Allocation creation failed.");
        else
            return new Allocation(k, renderscript, type, j);
    }

    public static Allocation createTyped(RenderScript renderscript, Type type) {
        return createTyped(renderscript, type, MipmapControl.MIPMAP_NONE, 1);
    }

    public static Allocation createTyped(RenderScript renderscript, Type type, int i) {
        return createTyped(renderscript, type, MipmapControl.MIPMAP_NONE, i);
    }

    public static Allocation createTyped(RenderScript renderscript, Type type, MipmapControl mipmapcontrol, int i) {
        renderscript.validate();
        if(type.getID(renderscript) == 0)
            throw new RSInvalidStateException("Bad Type");
        int j = renderscript.nAllocationCreateTyped(type.getID(renderscript), mipmapcontrol.mID, i, 0);
        if(j == 0)
            throw new RSRuntimeException("Allocation creation failed.");
        else
            return new Allocation(j, renderscript, type, i);
    }

    private void data1DChecks(int i, int j, int k, int l) {
        super.mRS.validate();
        if(i < 0)
            throw new RSIllegalArgumentException("Offset must be >= 0.");
        if(j < 1)
            throw new RSIllegalArgumentException("Count must be >= 1.");
        if(i + j > mCurrentCount)
            throw new RSIllegalArgumentException((new StringBuilder()).append("Overflow, Available count ").append(mCurrentCount).append(", got ").append(j).append(" at offset ").append(i).append(".").toString());
        if(k < l)
            throw new RSIllegalArgumentException("Array too small for allocation type.");
        else
            return;
    }

    static Element elementFromBitmap(RenderScript renderscript, Bitmap bitmap) {
        android.graphics.Bitmap.Config config = bitmap.getConfig();
        Element element;
        if(config == android.graphics.Bitmap.Config.ALPHA_8)
            element = Element.A_8(renderscript);
        else
        if(config == android.graphics.Bitmap.Config.ARGB_4444)
            element = Element.RGBA_4444(renderscript);
        else
        if(config == android.graphics.Bitmap.Config.ARGB_8888)
            element = Element.RGBA_8888(renderscript);
        else
        if(config == android.graphics.Bitmap.Config.RGB_565)
            element = Element.RGB_565(renderscript);
        else
            throw new RSInvalidStateException((new StringBuilder()).append("Bad bitmap type: ").append(config).toString());
        return element;
    }

    private int getIDSafe() {
        int i;
        if(mAdaptedAllocation != null)
            i = mAdaptedAllocation.getID(super.mRS);
        else
            i = getID(super.mRS);
        return i;
    }

    static Type typeFromBitmap(RenderScript renderscript, Bitmap bitmap, MipmapControl mipmapcontrol) {
        Type.Builder builder = new Type.Builder(renderscript, elementFromBitmap(renderscript, bitmap));
        builder.setX(bitmap.getWidth());
        builder.setY(bitmap.getHeight());
        boolean flag;
        if(mipmapcontrol == MipmapControl.MIPMAP_FULL)
            flag = true;
        else
            flag = false;
        builder.setMipmaps(flag);
        return builder.create();
    }

    private void updateCacheInfo(Type type) {
        mCurrentDimX = type.getX();
        mCurrentDimY = type.getY();
        mCurrentDimZ = type.getZ();
        mCurrentCount = mCurrentDimX;
        if(mCurrentDimY > 1)
            mCurrentCount = mCurrentCount * mCurrentDimY;
        if(mCurrentDimZ > 1)
            mCurrentCount = mCurrentCount * mCurrentDimZ;
    }

    private void validate2DRange(int i, int j, int k, int l) {
        if(mAdaptedAllocation == null) {
            if(i < 0 || j < 0)
                throw new RSIllegalArgumentException("Offset cannot be negative.");
            if(l < 0 || k < 0)
                throw new RSIllegalArgumentException("Height or width cannot be negative.");
            if(i + k > mCurrentDimX || j + l > mCurrentDimY)
                throw new RSIllegalArgumentException("Updated region larger than allocation.");
        }
    }

    private void validateBitmapFormat(Bitmap bitmap) {
        android.graphics.Bitmap.Config config = bitmap.getConfig();
        class _cls1 {

            static final int $SwitchMap$android$graphics$Bitmap$Config[];

            static  {
                $SwitchMap$android$graphics$Bitmap$Config = new int[android.graphics.Bitmap.Config.values().length];
                NoSuchFieldError nosuchfielderror3;
                try {
                    $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Bitmap.Config.ALPHA_8.ordinal()] = 1;
                }
                catch(NoSuchFieldError nosuchfielderror) { }
                try {
                    $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Bitmap.Config.ARGB_8888.ordinal()] = 2;
                }
                catch(NoSuchFieldError nosuchfielderror1) { }
                try {
                    $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Bitmap.Config.RGB_565.ordinal()] = 3;
                }
                catch(NoSuchFieldError nosuchfielderror2) { }
                $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Bitmap.Config.ARGB_4444.ordinal()] = 4;
_L2:
                return;
                nosuchfielderror3;
                if(true) goto _L2; else goto _L1
_L1:
            }
        }

        _cls1..SwitchMap.android.graphics.Bitmap.Config[config.ordinal()];
        JVM INSTR tableswitch 1 4: default 44
    //                   1 45
    //                   2 146
    //                   3 261
    //                   4 376;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return;
_L2:
        if(mType.getElement().mKind != Element.DataKind.PIXEL_A)
            throw new RSIllegalArgumentException((new StringBuilder()).append("Allocation kind is ").append(mType.getElement().mKind).append(", type ").append(mType.getElement().mType).append(" of ").append(mType.getElement().getBytesSize()).append(" bytes, passed bitmap was ").append(config).toString());
        continue; /* Loop/switch isn't completed */
_L3:
        if(mType.getElement().mKind != Element.DataKind.PIXEL_RGBA || mType.getElement().getBytesSize() != 4)
            throw new RSIllegalArgumentException((new StringBuilder()).append("Allocation kind is ").append(mType.getElement().mKind).append(", type ").append(mType.getElement().mType).append(" of ").append(mType.getElement().getBytesSize()).append(" bytes, passed bitmap was ").append(config).toString());
        continue; /* Loop/switch isn't completed */
_L4:
        if(mType.getElement().mKind != Element.DataKind.PIXEL_RGB || mType.getElement().getBytesSize() != 2)
            throw new RSIllegalArgumentException((new StringBuilder()).append("Allocation kind is ").append(mType.getElement().mKind).append(", type ").append(mType.getElement().mType).append(" of ").append(mType.getElement().getBytesSize()).append(" bytes, passed bitmap was ").append(config).toString());
        continue; /* Loop/switch isn't completed */
_L5:
        if(mType.getElement().mKind != Element.DataKind.PIXEL_RGBA || mType.getElement().getBytesSize() != 2)
            throw new RSIllegalArgumentException((new StringBuilder()).append("Allocation kind is ").append(mType.getElement().mKind).append(", type ").append(mType.getElement().mType).append(" of ").append(mType.getElement().getBytesSize()).append(" bytes, passed bitmap was ").append(config).toString());
        if(true) goto _L1; else goto _L6
_L6:
    }

    private void validateBitmapSize(Bitmap bitmap) {
        if(mCurrentDimX != bitmap.getWidth() || mCurrentDimY != bitmap.getHeight())
            throw new RSIllegalArgumentException("Cannot update allocation from bitmap, sizes mismatch");
        else
            return;
    }

    private void validateIsFloat32() {
        if(mType.mElement.mType == Element.DataType.FLOAT_32)
            return;
        else
            throw new RSIllegalArgumentException((new StringBuilder()).append("32 bit float source does not match allocation type ").append(mType.mElement.mType).toString());
    }

    private void validateIsInt16() {
        if(mType.mElement.mType == Element.DataType.SIGNED_16 || mType.mElement.mType == Element.DataType.UNSIGNED_16)
            return;
        else
            throw new RSIllegalArgumentException((new StringBuilder()).append("16 bit integer source does not match allocation type ").append(mType.mElement.mType).toString());
    }

    private void validateIsInt32() {
        if(mType.mElement.mType == Element.DataType.SIGNED_32 || mType.mElement.mType == Element.DataType.UNSIGNED_32)
            return;
        else
            throw new RSIllegalArgumentException((new StringBuilder()).append("32 bit integer source does not match allocation type ").append(mType.mElement.mType).toString());
    }

    private void validateIsInt8() {
        if(mType.mElement.mType == Element.DataType.SIGNED_8 || mType.mElement.mType == Element.DataType.UNSIGNED_8)
            return;
        else
            throw new RSIllegalArgumentException((new StringBuilder()).append("8 bit integer source does not match allocation type ").append(mType.mElement.mType).toString());
    }

    private void validateIsObject() {
        if(mType.mElement.mType == Element.DataType.RS_ELEMENT || mType.mElement.mType == Element.DataType.RS_TYPE || mType.mElement.mType == Element.DataType.RS_ALLOCATION || mType.mElement.mType == Element.DataType.RS_SAMPLER || mType.mElement.mType == Element.DataType.RS_SCRIPT || mType.mElement.mType == Element.DataType.RS_MESH || mType.mElement.mType == Element.DataType.RS_PROGRAM_FRAGMENT || mType.mElement.mType == Element.DataType.RS_PROGRAM_VERTEX || mType.mElement.mType == Element.DataType.RS_PROGRAM_RASTER || mType.mElement.mType == Element.DataType.RS_PROGRAM_STORE)
            return;
        else
            throw new RSIllegalArgumentException((new StringBuilder()).append("Object source does not match allocation type ").append(mType.mElement.mType).toString());
    }

    public void copy1DRangeFrom(int i, int j, Allocation allocation, int k) {
        super.mRS.nAllocationData2D(getIDSafe(), i, 0, mSelectedLOD, mSelectedFace.mID, j, 1, allocation.getID(super.mRS), k, 0, allocation.mSelectedLOD, allocation.mSelectedFace.mID);
    }

    public void copy1DRangeFrom(int i, int j, byte abyte0[]) {
        validateIsInt8();
        copy1DRangeFromUnchecked(i, j, abyte0);
    }

    public void copy1DRangeFrom(int i, int j, float af[]) {
        validateIsFloat32();
        copy1DRangeFromUnchecked(i, j, af);
    }

    public void copy1DRangeFrom(int i, int j, int ai[]) {
        validateIsInt32();
        copy1DRangeFromUnchecked(i, j, ai);
    }

    public void copy1DRangeFrom(int i, int j, short aword0[]) {
        validateIsInt16();
        copy1DRangeFromUnchecked(i, j, aword0);
    }

    public void copy1DRangeFromUnchecked(int i, int j, byte abyte0[]) {
        int k = j * mType.mElement.getBytesSize();
        data1DChecks(i, j, abyte0.length, k);
        super.mRS.nAllocationData1D(getIDSafe(), i, mSelectedLOD, j, abyte0, k);
    }

    public void copy1DRangeFromUnchecked(int i, int j, float af[]) {
        int k = j * mType.mElement.getBytesSize();
        data1DChecks(i, j, 4 * af.length, k);
        super.mRS.nAllocationData1D(getIDSafe(), i, mSelectedLOD, j, af, k);
    }

    public void copy1DRangeFromUnchecked(int i, int j, int ai[]) {
        int k = j * mType.mElement.getBytesSize();
        data1DChecks(i, j, 4 * ai.length, k);
        super.mRS.nAllocationData1D(getIDSafe(), i, mSelectedLOD, j, ai, k);
    }

    public void copy1DRangeFromUnchecked(int i, int j, short aword0[]) {
        int k = j * mType.mElement.getBytesSize();
        data1DChecks(i, j, 2 * aword0.length, k);
        super.mRS.nAllocationData1D(getIDSafe(), i, mSelectedLOD, j, aword0, k);
    }

    public void copy2DRangeFrom(int i, int j, int k, int l, Allocation allocation, int i1, int j1) {
        super.mRS.validate();
        validate2DRange(i, j, k, l);
        super.mRS.nAllocationData2D(getIDSafe(), i, j, mSelectedLOD, mSelectedFace.mID, k, l, allocation.getID(super.mRS), i1, j1, allocation.mSelectedLOD, allocation.mSelectedFace.mID);
    }

    public void copy2DRangeFrom(int i, int j, int k, int l, byte abyte0[]) {
        super.mRS.validate();
        validate2DRange(i, j, k, l);
        super.mRS.nAllocationData2D(getIDSafe(), i, j, mSelectedLOD, mSelectedFace.mID, k, l, abyte0, abyte0.length);
    }

    public void copy2DRangeFrom(int i, int j, int k, int l, float af[]) {
        super.mRS.validate();
        validate2DRange(i, j, k, l);
        super.mRS.nAllocationData2D(getIDSafe(), i, j, mSelectedLOD, mSelectedFace.mID, k, l, af, 4 * af.length);
    }

    public void copy2DRangeFrom(int i, int j, int k, int l, int ai[]) {
        super.mRS.validate();
        validate2DRange(i, j, k, l);
        super.mRS.nAllocationData2D(getIDSafe(), i, j, mSelectedLOD, mSelectedFace.mID, k, l, ai, 4 * ai.length);
    }

    public void copy2DRangeFrom(int i, int j, int k, int l, short aword0[]) {
        super.mRS.validate();
        validate2DRange(i, j, k, l);
        super.mRS.nAllocationData2D(getIDSafe(), i, j, mSelectedLOD, mSelectedFace.mID, k, l, aword0, 2 * aword0.length);
    }

    public void copy2DRangeFrom(int i, int j, Bitmap bitmap) {
        super.mRS.validate();
        validateBitmapFormat(bitmap);
        validate2DRange(i, j, bitmap.getWidth(), bitmap.getHeight());
        super.mRS.nAllocationData2D(getIDSafe(), i, j, mSelectedLOD, mSelectedFace.mID, bitmap);
    }

    public void copyFrom(Bitmap bitmap) {
        super.mRS.validate();
        validateBitmapSize(bitmap);
        validateBitmapFormat(bitmap);
        super.mRS.nAllocationCopyFromBitmap(getID(super.mRS), bitmap);
    }

    public void copyFrom(byte abyte0[]) {
        super.mRS.validate();
        copy1DRangeFrom(0, mCurrentCount, abyte0);
    }

    public void copyFrom(float af[]) {
        super.mRS.validate();
        copy1DRangeFrom(0, mCurrentCount, af);
    }

    public void copyFrom(int ai[]) {
        super.mRS.validate();
        copy1DRangeFrom(0, mCurrentCount, ai);
    }

    public void copyFrom(BaseObj abaseobj[]) {
        super.mRS.validate();
        validateIsObject();
        if(abaseobj.length != mCurrentCount)
            throw new RSIllegalArgumentException((new StringBuilder()).append("Array size mismatch, allocation sizeX = ").append(mCurrentCount).append(", array length = ").append(abaseobj.length).toString());
        int ai[] = new int[abaseobj.length];
        for(int i = 0; i < abaseobj.length; i++)
            ai[i] = abaseobj[i].getID(super.mRS);

        copy1DRangeFromUnchecked(0, mCurrentCount, ai);
    }

    public void copyFrom(short aword0[]) {
        super.mRS.validate();
        copy1DRangeFrom(0, mCurrentCount, aword0);
    }

    public void copyFromUnchecked(byte abyte0[]) {
        super.mRS.validate();
        copy1DRangeFromUnchecked(0, mCurrentCount, abyte0);
    }

    public void copyFromUnchecked(float af[]) {
        super.mRS.validate();
        copy1DRangeFromUnchecked(0, mCurrentCount, af);
    }

    public void copyFromUnchecked(int ai[]) {
        super.mRS.validate();
        copy1DRangeFromUnchecked(0, mCurrentCount, ai);
    }

    public void copyFromUnchecked(short aword0[]) {
        super.mRS.validate();
        copy1DRangeFromUnchecked(0, mCurrentCount, aword0);
    }

    public void copyTo(Bitmap bitmap) {
        super.mRS.validate();
        validateBitmapFormat(bitmap);
        validateBitmapSize(bitmap);
        super.mRS.nAllocationCopyToBitmap(getID(super.mRS), bitmap);
    }

    public void copyTo(byte abyte0[]) {
        validateIsInt8();
        super.mRS.validate();
        super.mRS.nAllocationRead(getID(super.mRS), abyte0);
    }

    public void copyTo(float af[]) {
        validateIsFloat32();
        super.mRS.validate();
        super.mRS.nAllocationRead(getID(super.mRS), af);
    }

    public void copyTo(int ai[]) {
        validateIsInt32();
        super.mRS.validate();
        super.mRS.nAllocationRead(getID(super.mRS), ai);
    }

    public void copyTo(short aword0[]) {
        validateIsInt16();
        super.mRS.validate();
        super.mRS.nAllocationRead(getID(super.mRS), aword0);
    }

    public void generateMipmaps() {
        super.mRS.nAllocationGenerateMipmaps(getID(super.mRS));
    }

    public int getBytesSize() {
        return mType.getCount() * mType.getElement().getBytesSize();
    }

    public Element getElement() {
        return mType.getElement();
    }

    public Surface getSurface() {
        return new Surface(getSurfaceTexture());
    }

    public SurfaceTexture getSurfaceTexture() {
        if((0x20 & mUsage) == 0) {
            throw new RSInvalidStateException("Allocation is not a surface texture.");
        } else {
            SurfaceTexture surfacetexture = new SurfaceTexture(super.mRS.nAllocationGetSurfaceTextureID(getID(super.mRS)));
            super.mRS.nAllocationGetSurfaceTextureID2(getID(super.mRS), surfacetexture);
            return surfacetexture;
        }
    }

    public Type getType() {
        return mType;
    }

    public int getUsage() {
        return mUsage;
    }

    public void ioReceive() {
        if((0x20 & mUsage) == 0) {
            throw new RSIllegalArgumentException("Can only receive if IO_INPUT usage specified.");
        } else {
            super.mRS.validate();
            super.mRS.nAllocationIoReceive(getID(super.mRS));
            return;
        }
    }

    public void ioSend() {
        if((0x40 & mUsage) == 0) {
            throw new RSIllegalArgumentException("Can only send buffer if IO_OUTPUT usage specified.");
        } else {
            super.mRS.validate();
            super.mRS.nAllocationIoSend(getID(super.mRS));
            return;
        }
    }

    public void ioSendOutput() {
        ioSend();
    }

    /**
     * @deprecated Method resize is deprecated
     */

    public void resize(int i) {
        this;
        JVM INSTR monitorenter ;
        if(mType.getY() > 0 || mType.getZ() > 0 || mType.hasFaces() || mType.hasMipmaps())
            throw new RSInvalidStateException("Resize only support for 1D allocations at this time.");
        break MISSING_BLOCK_LABEL_58;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        super.mRS.nAllocationResize1D(getID(super.mRS), i);
        super.mRS.finish();
        mType = new Type(super.mRS.nAllocationGetType(getID(super.mRS)), super.mRS);
        mType.updateFromNative();
        updateCacheInfo(mType);
        this;
        JVM INSTR monitorexit ;
    }

    public void resize(int i, int j) {
        if(mType.getZ() > 0 || mType.hasFaces() || mType.hasMipmaps())
            throw new RSInvalidStateException("Resize only support for 2D allocations at this time.");
        if(mType.getY() == 0) {
            throw new RSInvalidStateException("Resize only support for 2D allocations at this time.");
        } else {
            super.mRS.nAllocationResize2D(getID(super.mRS), i, j);
            super.mRS.finish();
            mType = new Type(super.mRS.nAllocationGetType(getID(super.mRS)), super.mRS);
            mType.updateFromNative();
            updateCacheInfo(mType);
            return;
        }
    }

    public void setFromFieldPacker(int i, int j, FieldPacker fieldpacker) {
        super.mRS.validate();
        if(j >= mType.mElement.mElements.length)
            throw new RSIllegalArgumentException((new StringBuilder()).append("Component_number ").append(j).append(" out of range.").toString());
        if(i < 0)
            throw new RSIllegalArgumentException("Offset must be >= 0.");
        byte abyte0[] = fieldpacker.getData();
        int k = mType.mElement.mElements[j].getBytesSize() * mType.mElement.mArraySizes[j];
        if(abyte0.length != k) {
            throw new RSIllegalArgumentException((new StringBuilder()).append("Field packer sizelength ").append(abyte0.length).append(" does not match component size ").append(k).append(".").toString());
        } else {
            super.mRS.nAllocationElementData1D(getIDSafe(), i, mSelectedLOD, j, abyte0, abyte0.length);
            return;
        }
    }

    public void setFromFieldPacker(int i, FieldPacker fieldpacker) {
        super.mRS.validate();
        int j = mType.mElement.getBytesSize();
        byte abyte0[] = fieldpacker.getData();
        int k = abyte0.length / j;
        if(j * k != abyte0.length) {
            throw new RSIllegalArgumentException((new StringBuilder()).append("Field packer length ").append(abyte0.length).append(" not divisible by element size ").append(j).append(".").toString());
        } else {
            copy1DRangeFromUnchecked(i, k, abyte0);
            return;
        }
    }

    public void setSurface(Surface surface) {
        super.mRS.validate();
        if((0x40 & mUsage) == 0) {
            throw new RSInvalidStateException("Allocation is not USAGE_IO_OUTPUT.");
        } else {
            super.mRS.nAllocationSetSurface(getID(super.mRS), surface);
            return;
        }
    }

    public void setSurfaceTexture(SurfaceTexture surfacetexture) {
        super.mRS.validate();
        if((0x40 & mUsage) == 0) {
            throw new RSInvalidStateException("Allocation is not USAGE_IO_OUTPUT.");
        } else {
            Surface surface = new Surface(surfacetexture);
            super.mRS.nAllocationSetSurface(getID(super.mRS), surface);
            return;
        }
    }

    public void syncAll(int i) {
        switch(i) {
        case 3: // '\003'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        default:
            throw new RSIllegalArgumentException("Source must be exactly one usage type.");

        case 1: // '\001'
        case 2: // '\002'
        case 4: // '\004'
        case 8: // '\b'
            super.mRS.validate();
            break;
        }
        super.mRS.nAllocationSyncAll(getIDSafe(), i);
    }

    void updateFromNative() {
        super.updateFromNative();
        int i = super.mRS.nAllocationGetType(getID(super.mRS));
        if(i != 0) {
            mType = new Type(i, super.mRS);
            mType.updateFromNative();
            updateCacheInfo(mType);
        }
    }

    public static final int USAGE_GRAPHICS_CONSTANTS = 8;
    public static final int USAGE_GRAPHICS_RENDER_TARGET = 16;
    public static final int USAGE_GRAPHICS_TEXTURE = 2;
    public static final int USAGE_GRAPHICS_VERTEX = 4;
    public static final int USAGE_IO_INPUT = 32;
    public static final int USAGE_IO_OUTPUT = 64;
    public static final int USAGE_SCRIPT = 1;
    static android.graphics.BitmapFactory.Options mBitmapOptions;
    Allocation mAdaptedAllocation;
    Bitmap mBitmap;
    boolean mConstrainedFace;
    boolean mConstrainedLOD;
    boolean mConstrainedY;
    boolean mConstrainedZ;
    int mCurrentCount;
    int mCurrentDimX;
    int mCurrentDimY;
    int mCurrentDimZ;
    boolean mReadAllowed;
    Type.CubemapFace mSelectedFace;
    int mSelectedLOD;
    int mSelectedY;
    int mSelectedZ;
    Type mType;
    int mUsage;
    boolean mWriteAllowed;

    static  {
        mBitmapOptions = new android.graphics.BitmapFactory.Options();
        mBitmapOptions.inScaled = false;
    }
}
