// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.renderscript;

import android.util.Log;

// Referenced classes of package android.renderscript:
//            Allocation, RenderScript, RSInvalidStateException, RSIllegalArgumentException, 
//            Type, FieldPacker

public class AllocationAdapter extends Allocation {

    AllocationAdapter(int i, RenderScript renderscript, Allocation allocation) {
        super(i, renderscript, allocation.mType, allocation.mUsage);
        super.mAdaptedAllocation = allocation;
    }

    public static AllocationAdapter create1D(RenderScript renderscript, Allocation allocation) {
        renderscript.validate();
        AllocationAdapter allocationadapter = new AllocationAdapter(0, renderscript, allocation);
        allocationadapter.mConstrainedLOD = true;
        allocationadapter.mConstrainedFace = true;
        allocationadapter.mConstrainedY = true;
        allocationadapter.mConstrainedZ = true;
        allocationadapter.initLOD(0);
        return allocationadapter;
    }

    public static AllocationAdapter create2D(RenderScript renderscript, Allocation allocation) {
        Log.e("rs", (new StringBuilder()).append("create2d ").append(allocation).toString());
        renderscript.validate();
        AllocationAdapter allocationadapter = new AllocationAdapter(0, renderscript, allocation);
        allocationadapter.mConstrainedLOD = true;
        allocationadapter.mConstrainedFace = true;
        allocationadapter.mConstrainedY = false;
        allocationadapter.mConstrainedZ = true;
        allocationadapter.initLOD(0);
        return allocationadapter;
    }

    int getID(RenderScript renderscript) {
        throw new RSInvalidStateException("This operation is not supported with adapters at this time.");
    }

    void initLOD(int i) {
        if(i < 0)
            throw new RSIllegalArgumentException((new StringBuilder()).append("Attempting to set negative lod (").append(i).append(").").toString());
        int j = super.mAdaptedAllocation.mType.getX();
        int k = super.mAdaptedAllocation.mType.getY();
        int l = super.mAdaptedAllocation.mType.getZ();
        for(int i1 = 0; i1 < i; i1++) {
            if(j == 1 && k == 1 && l == 1)
                throw new RSIllegalArgumentException((new StringBuilder()).append("Attempting to set lod (").append(i).append(") out of range.").toString());
            if(j > 1)
                j >>= 1;
            if(k > 1)
                k >>= 1;
            if(l > 1)
                l >>= 1;
        }

        super.mCurrentDimX = j;
        super.mCurrentDimY = k;
        super.mCurrentDimZ = l;
        super.mCurrentCount = super.mCurrentDimX;
        if(super.mCurrentDimY > 1)
            super.mCurrentCount = super.mCurrentCount * super.mCurrentDimY;
        if(super.mCurrentDimZ > 1)
            super.mCurrentCount = super.mCurrentCount * super.mCurrentDimZ;
        super.mSelectedY = 0;
        super.mSelectedZ = 0;
    }

    public void readData(float af[]) {
        super.copyTo(af);
    }

    public void readData(int ai[]) {
        super.copyTo(ai);
    }

    /**
     * @deprecated Method resize is deprecated
     */

    public void resize(int i) {
        this;
        JVM INSTR monitorenter ;
        throw new RSInvalidStateException("Resize not allowed for Adapters.");
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setFace(Type.CubemapFace cubemapface) {
        if(!super.mAdaptedAllocation.getType().hasFaces())
            throw new RSInvalidStateException("Cannot set Face when the allocation type does not include faces.");
        if(!super.mConstrainedFace)
            throw new RSInvalidStateException("Cannot set LOD when the adapter includes mipmaps.");
        if(cubemapface == null) {
            throw new RSIllegalArgumentException("Cannot set null face.");
        } else {
            super.mSelectedFace = cubemapface;
            return;
        }
    }

    public void setLOD(int i) {
        if(!super.mAdaptedAllocation.getType().hasMipmaps())
            throw new RSInvalidStateException("Cannot set LOD when the allocation type does not include mipmaps.");
        if(!super.mConstrainedLOD) {
            throw new RSInvalidStateException("Cannot set LOD when the adapter includes mipmaps.");
        } else {
            initLOD(i);
            return;
        }
    }

    public void setY(int i) {
        if(super.mAdaptedAllocation.getType().getY() == 0)
            throw new RSInvalidStateException("Cannot set Y when the allocation type does not include Y dim.");
        if(super.mAdaptedAllocation.getType().getY() <= i)
            throw new RSInvalidStateException("Cannot set Y greater than dimension of allocation.");
        if(!super.mConstrainedY) {
            throw new RSInvalidStateException("Cannot set Y when the adapter includes Y.");
        } else {
            super.mSelectedY = i;
            return;
        }
    }

    public void setZ(int i) {
        if(super.mAdaptedAllocation.getType().getZ() == 0)
            throw new RSInvalidStateException("Cannot set Z when the allocation type does not include Z dim.");
        if(super.mAdaptedAllocation.getType().getZ() <= i)
            throw new RSInvalidStateException("Cannot set Z greater than dimension of allocation.");
        if(!super.mConstrainedZ) {
            throw new RSInvalidStateException("Cannot set Z when the adapter includes Z.");
        } else {
            super.mSelectedZ = i;
            return;
        }
    }

    public void subData(int i, FieldPacker fieldpacker) {
        super.setFromFieldPacker(i, fieldpacker);
    }

    public void subData1D(int i, int j, byte abyte0[]) {
        super.copy1DRangeFrom(i, j, abyte0);
    }

    public void subData1D(int i, int j, float af[]) {
        super.copy1DRangeFrom(i, j, af);
    }

    public void subData1D(int i, int j, int ai[]) {
        super.copy1DRangeFrom(i, j, ai);
    }

    public void subData1D(int i, int j, short aword0[]) {
        super.copy1DRangeFrom(i, j, aword0);
    }

    public void subData2D(int i, int j, int k, int l, float af[]) {
        super.copy2DRangeFrom(i, j, k, l, af);
    }

    public void subData2D(int i, int j, int k, int l, int ai[]) {
        super.copy2DRangeFrom(i, j, k, l, ai);
    }

    public void subElementData(int i, int j, FieldPacker fieldpacker) {
        super.setFromFieldPacker(i, j, fieldpacker);
    }
}
