// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.renderscript;

import java.util.Vector;

// Referenced classes of package android.renderscript:
//            BaseObj, RenderScript, Allocation, Element, 
//            Type

public class Mesh extends BaseObj {
    public static class TriangleMeshBuilder {

        private void latch() {
            if((1 & mFlags) != 0) {
                makeSpace(4);
                float af6[] = mVtxData;
                int k1 = mVtxCount;
                mVtxCount = k1 + 1;
                af6[k1] = mR;
                float af7[] = mVtxData;
                int l1 = mVtxCount;
                mVtxCount = l1 + 1;
                af7[l1] = mG;
                float af8[] = mVtxData;
                int i2 = mVtxCount;
                mVtxCount = i2 + 1;
                af8[i2] = mB;
                float af9[] = mVtxData;
                int j2 = mVtxCount;
                mVtxCount = j2 + 1;
                af9[j2] = mA;
            }
            if((0x100 & mFlags) != 0) {
                makeSpace(2);
                float af4[] = mVtxData;
                int i1 = mVtxCount;
                mVtxCount = i1 + 1;
                af4[i1] = mS0;
                float af5[] = mVtxData;
                int j1 = mVtxCount;
                mVtxCount = j1 + 1;
                af5[j1] = mT0;
            }
            if((2 & mFlags) != 0) {
                makeSpace(4);
                float af[] = mVtxData;
                int i = mVtxCount;
                mVtxCount = i + 1;
                af[i] = mNX;
                float af1[] = mVtxData;
                int j = mVtxCount;
                mVtxCount = j + 1;
                af1[j] = mNY;
                float af2[] = mVtxData;
                int k = mVtxCount;
                mVtxCount = k + 1;
                af2[k] = mNZ;
                float af3[] = mVtxData;
                int l = mVtxCount;
                mVtxCount = l + 1;
                af3[l] = 0.0F;
            }
            mMaxIndex = 1 + mMaxIndex;
        }

        private void makeSpace(int i) {
            if(i + mVtxCount >= mVtxData.length) {
                float af[] = new float[2 * mVtxData.length];
                System.arraycopy(mVtxData, 0, af, 0, mVtxData.length);
                mVtxData = af;
            }
        }

        public TriangleMeshBuilder addTriangle(int i, int j, int k) {
            if(i >= mMaxIndex || i < 0 || j >= mMaxIndex || j < 0 || k >= mMaxIndex || k < 0)
                throw new IllegalStateException("Index provided greater than vertex count.");
            if(3 + mIndexCount >= mIndexData.length) {
                short aword3[] = new short[2 * mIndexData.length];
                System.arraycopy(mIndexData, 0, aword3, 0, mIndexData.length);
                mIndexData = aword3;
            }
            short aword0[] = mIndexData;
            int l = mIndexCount;
            mIndexCount = l + 1;
            aword0[l] = (short)i;
            short aword1[] = mIndexData;
            int i1 = mIndexCount;
            mIndexCount = i1 + 1;
            aword1[i1] = (short)j;
            short aword2[] = mIndexData;
            int j1 = mIndexCount;
            mIndexCount = j1 + 1;
            aword2[j1] = (short)k;
            return this;
        }

        public TriangleMeshBuilder addVertex(float f, float f1) {
            if(mVtxSize != 2) {
                throw new IllegalStateException("add mistmatch with declared components.");
            } else {
                makeSpace(2);
                float af[] = mVtxData;
                int i = mVtxCount;
                mVtxCount = i + 1;
                af[i] = f;
                float af1[] = mVtxData;
                int j = mVtxCount;
                mVtxCount = j + 1;
                af1[j] = f1;
                latch();
                return this;
            }
        }

        public TriangleMeshBuilder addVertex(float f, float f1, float f2) {
            if(mVtxSize != 3) {
                throw new IllegalStateException("add mistmatch with declared components.");
            } else {
                makeSpace(4);
                float af[] = mVtxData;
                int i = mVtxCount;
                mVtxCount = i + 1;
                af[i] = f;
                float af1[] = mVtxData;
                int j = mVtxCount;
                mVtxCount = j + 1;
                af1[j] = f1;
                float af2[] = mVtxData;
                int k = mVtxCount;
                mVtxCount = k + 1;
                af2[k] = f2;
                float af3[] = mVtxData;
                int l = mVtxCount;
                mVtxCount = l + 1;
                af3[l] = 1.0F;
                latch();
                return this;
            }
        }

        public Mesh create(boolean flag) {
            Element.Builder builder = new Element.Builder(mRS);
            builder.add(Element.createVector(mRS, Element.DataType.FLOAT_32, mVtxSize), "position");
            if((1 & mFlags) != 0)
                builder.add(Element.F32_4(mRS), "color");
            if((0x100 & mFlags) != 0)
                builder.add(Element.F32_2(mRS), "texture0");
            if((2 & mFlags) != 0)
                builder.add(Element.F32_3(mRS), "normal");
            mElement = builder.create();
            int i = 1;
            if(flag)
                i |= 4;
            Builder builder1 = new Builder(mRS, i);
            builder1.addVertexType(mElement, mMaxIndex);
            builder1.addIndexSetType(Element.U16(mRS), mIndexCount, Primitive.TRIANGLE);
            Mesh mesh = builder1.create();
            mesh.getVertexAllocation(0).copy1DRangeFromUnchecked(0, mMaxIndex, mVtxData);
            if(flag && flag)
                mesh.getVertexAllocation(0).syncAll(1);
            mesh.getIndexSetAllocation(0).copy1DRangeFromUnchecked(0, mIndexCount, mIndexData);
            if(flag)
                mesh.getIndexSetAllocation(0).syncAll(1);
            return mesh;
        }

        public TriangleMeshBuilder setColor(float f, float f1, float f2, float f3) {
            if((1 & mFlags) == 0) {
                throw new IllegalStateException("add mistmatch with declared components.");
            } else {
                mR = f;
                mG = f1;
                mB = f2;
                mA = f3;
                return this;
            }
        }

        public TriangleMeshBuilder setNormal(float f, float f1, float f2) {
            if((2 & mFlags) == 0) {
                throw new IllegalStateException("add mistmatch with declared components.");
            } else {
                mNX = f;
                mNY = f1;
                mNZ = f2;
                return this;
            }
        }

        public TriangleMeshBuilder setTexture(float f, float f1) {
            if((0x100 & mFlags) == 0) {
                throw new IllegalStateException("add mistmatch with declared components.");
            } else {
                mS0 = f;
                mT0 = f1;
                return this;
            }
        }

        public static final int COLOR = 1;
        public static final int NORMAL = 2;
        public static final int TEXTURE_0 = 256;
        float mA;
        float mB;
        Element mElement;
        int mFlags;
        float mG;
        int mIndexCount;
        short mIndexData[];
        int mMaxIndex;
        float mNX;
        float mNY;
        float mNZ;
        float mR;
        RenderScript mRS;
        float mS0;
        float mT0;
        int mVtxCount;
        float mVtxData[];
        int mVtxSize;

        public TriangleMeshBuilder(RenderScript renderscript, int i, int j) {
            mNX = 0.0F;
            mNY = 0.0F;
            mNZ = -1F;
            mS0 = 0.0F;
            mT0 = 0.0F;
            mR = 1.0F;
            mG = 1.0F;
            mB = 1.0F;
            mA = 1.0F;
            mRS = renderscript;
            mVtxCount = 0;
            mMaxIndex = 0;
            mIndexCount = 0;
            mVtxData = new float[128];
            mIndexData = new short[128];
            mVtxSize = i;
            mFlags = j;
            if(i < 2 || i > 3)
                throw new IllegalArgumentException("Vertex size out of range.");
            else
                return;
        }
    }

    public static class AllocationBuilder {
        class Entry {

            Allocation a;
            Primitive prim;
            final AllocationBuilder this$0;

            Entry() {
                this$0 = AllocationBuilder.this;
                super();
            }
        }


        public AllocationBuilder addIndexSetAllocation(Allocation allocation, Primitive primitive) {
            Entry entry = new Entry();
            entry.a = allocation;
            entry.prim = primitive;
            mIndexTypes.addElement(entry);
            return this;
        }

        public AllocationBuilder addIndexSetType(Primitive primitive) {
            Entry entry = new Entry();
            entry.a = null;
            entry.prim = primitive;
            mIndexTypes.addElement(entry);
            return this;
        }

        public AllocationBuilder addVertexAllocation(Allocation allocation) throws IllegalStateException {
            if(mVertexTypeCount >= mVertexTypes.length) {
                throw new IllegalStateException("Max vertex types exceeded.");
            } else {
                mVertexTypes[mVertexTypeCount] = new Entry();
                mVertexTypes[mVertexTypeCount].a = allocation;
                mVertexTypeCount = 1 + mVertexTypeCount;
                return this;
            }
        }

        public Mesh create() {
            mRS.validate();
            int ai[] = new int[mVertexTypeCount];
            int ai1[] = new int[mIndexTypes.size()];
            int ai2[] = new int[mIndexTypes.size()];
            Allocation aallocation[] = new Allocation[mIndexTypes.size()];
            Primitive aprimitive[] = new Primitive[mIndexTypes.size()];
            Allocation aallocation1[] = new Allocation[mVertexTypeCount];
            for(int i = 0; i < mVertexTypeCount; i++) {
                Entry entry1 = mVertexTypes[i];
                aallocation1[i] = entry1.a;
                ai[i] = entry1.a.getID(mRS);
            }

            int j = 0;
            while(j < mIndexTypes.size())  {
                Entry entry = (Entry)mIndexTypes.elementAt(j);
                int k;
                if(entry.a == null)
                    k = 0;
                else
                    k = entry.a.getID(mRS);
                aallocation[j] = entry.a;
                aprimitive[j] = entry.prim;
                ai1[j] = k;
                ai2[j] = entry.prim.mID;
                j++;
            }
            Mesh mesh = new Mesh(mRS.nMeshCreate(ai, ai1, ai2), mRS);
            mesh.mVertexBuffers = aallocation1;
            mesh.mIndexBuffers = aallocation;
            mesh.mPrimitives = aprimitive;
            return mesh;
        }

        public int getCurrentIndexSetIndex() {
            return -1 + mIndexTypes.size();
        }

        public int getCurrentVertexTypeIndex() {
            return -1 + mVertexTypeCount;
        }

        Vector mIndexTypes;
        RenderScript mRS;
        int mVertexTypeCount;
        Entry mVertexTypes[];

        public AllocationBuilder(RenderScript renderscript) {
            mRS = renderscript;
            mVertexTypeCount = 0;
            mVertexTypes = new Entry[16];
            mIndexTypes = new Vector();
        }
    }

    public static class Builder {
        class Entry {

            Element e;
            Primitive prim;
            int size;
            Type t;
            final Builder this$0;
            int usage;

            Entry() {
                this$0 = Builder.this;
                super();
            }
        }


        public Builder addIndexSetType(Element element, int i, Primitive primitive) {
            Entry entry = new Entry();
            entry.t = null;
            entry.e = element;
            entry.size = i;
            entry.prim = primitive;
            mIndexTypes.addElement(entry);
            return this;
        }

        public Builder addIndexSetType(Primitive primitive) {
            Entry entry = new Entry();
            entry.t = null;
            entry.e = null;
            entry.size = 0;
            entry.prim = primitive;
            mIndexTypes.addElement(entry);
            return this;
        }

        public Builder addIndexSetType(Type type, Primitive primitive) {
            Entry entry = new Entry();
            entry.t = type;
            entry.e = null;
            entry.size = 0;
            entry.prim = primitive;
            mIndexTypes.addElement(entry);
            return this;
        }

        public Builder addVertexType(Element element, int i) throws IllegalStateException {
            if(mVertexTypeCount >= mVertexTypes.length) {
                throw new IllegalStateException("Max vertex types exceeded.");
            } else {
                mVertexTypes[mVertexTypeCount] = new Entry();
                mVertexTypes[mVertexTypeCount].t = null;
                mVertexTypes[mVertexTypeCount].e = element;
                mVertexTypes[mVertexTypeCount].size = i;
                mVertexTypeCount = 1 + mVertexTypeCount;
                return this;
            }
        }

        public Builder addVertexType(Type type) throws IllegalStateException {
            if(mVertexTypeCount >= mVertexTypes.length) {
                throw new IllegalStateException("Max vertex types exceeded.");
            } else {
                mVertexTypes[mVertexTypeCount] = new Entry();
                mVertexTypes[mVertexTypeCount].t = type;
                mVertexTypes[mVertexTypeCount].e = null;
                mVertexTypeCount = 1 + mVertexTypeCount;
                return this;
            }
        }

        public Mesh create() {
            mRS.validate();
            int ai[] = new int[mVertexTypeCount];
            int ai1[] = new int[mIndexTypes.size()];
            int ai2[] = new int[mIndexTypes.size()];
            Allocation aallocation[] = new Allocation[mVertexTypeCount];
            Allocation aallocation1[] = new Allocation[mIndexTypes.size()];
            Primitive aprimitive[] = new Primitive[mIndexTypes.size()];
            int i = 0;
            while(i < mVertexTypeCount)  {
                Allocation allocation1 = null;
                Entry entry1 = mVertexTypes[i];
                if(entry1.t != null)
                    allocation1 = Allocation.createTyped(mRS, entry1.t, mUsage);
                else
                if(entry1.e != null)
                    allocation1 = Allocation.createSized(mRS, entry1.e, entry1.size, mUsage);
                aallocation[i] = allocation1;
                ai[i] = allocation1.getID(mRS);
                i++;
            }
            int j = 0;
            while(j < mIndexTypes.size())  {
                Allocation allocation = null;
                Entry entry = (Entry)mIndexTypes.elementAt(j);
                int k;
                if(entry.t != null)
                    allocation = Allocation.createTyped(mRS, entry.t, mUsage);
                else
                if(entry.e != null)
                    allocation = Allocation.createSized(mRS, entry.e, entry.size, mUsage);
                if(allocation == null)
                    k = 0;
                else
                    k = allocation.getID(mRS);
                aallocation1[j] = allocation;
                aprimitive[j] = entry.prim;
                ai1[j] = k;
                ai2[j] = entry.prim.mID;
                j++;
            }
            Mesh mesh = new Mesh(mRS.nMeshCreate(ai, ai1, ai2), mRS);
            mesh.mVertexBuffers = aallocation;
            mesh.mIndexBuffers = aallocation1;
            mesh.mPrimitives = aprimitive;
            return mesh;
        }

        public int getCurrentIndexSetIndex() {
            return -1 + mIndexTypes.size();
        }

        public int getCurrentVertexTypeIndex() {
            return -1 + mVertexTypeCount;
        }

        Type newType(Element element, int i) {
            Type.Builder builder = new Type.Builder(mRS, element);
            builder.setX(i);
            return builder.create();
        }

        Vector mIndexTypes;
        RenderScript mRS;
        int mUsage;
        int mVertexTypeCount;
        Entry mVertexTypes[];

        public Builder(RenderScript renderscript, int i) {
            mRS = renderscript;
            mUsage = i;
            mVertexTypeCount = 0;
            mVertexTypes = new Entry[16];
            mIndexTypes = new Vector();
        }
    }

    public static final class Primitive extends Enum {

        public static Primitive valueOf(String s) {
            return (Primitive)Enum.valueOf(android/renderscript/Mesh$Primitive, s);
        }

        public static Primitive[] values() {
            return (Primitive[])$VALUES.clone();
        }

        private static final Primitive $VALUES[];
        public static final Primitive LINE;
        public static final Primitive LINE_STRIP;
        public static final Primitive POINT;
        public static final Primitive TRIANGLE;
        public static final Primitive TRIANGLE_FAN;
        public static final Primitive TRIANGLE_STRIP;
        int mID;

        static  {
            POINT = new Primitive("POINT", 0, 0);
            LINE = new Primitive("LINE", 1, 1);
            LINE_STRIP = new Primitive("LINE_STRIP", 2, 2);
            TRIANGLE = new Primitive("TRIANGLE", 3, 3);
            TRIANGLE_STRIP = new Primitive("TRIANGLE_STRIP", 4, 4);
            TRIANGLE_FAN = new Primitive("TRIANGLE_FAN", 5, 5);
            Primitive aprimitive[] = new Primitive[6];
            aprimitive[0] = POINT;
            aprimitive[1] = LINE;
            aprimitive[2] = LINE_STRIP;
            aprimitive[3] = TRIANGLE;
            aprimitive[4] = TRIANGLE_STRIP;
            aprimitive[5] = TRIANGLE_FAN;
            $VALUES = aprimitive;
        }

        private Primitive(String s, int i, int j) {
            super(s, i);
            mID = j;
        }
    }


    Mesh(int i, RenderScript renderscript) {
        super(i, renderscript);
    }

    public Allocation getIndexSetAllocation(int i) {
        return mIndexBuffers[i];
    }

    public Primitive getPrimitive(int i) {
        return mPrimitives[i];
    }

    public int getPrimitiveCount() {
        int i;
        if(mIndexBuffers == null)
            i = 0;
        else
            i = mIndexBuffers.length;
        return i;
    }

    public Allocation getVertexAllocation(int i) {
        return mVertexBuffers[i];
    }

    public int getVertexAllocationCount() {
        int i;
        if(mVertexBuffers == null)
            i = 0;
        else
            i = mVertexBuffers.length;
        return i;
    }

    void updateFromNative() {
        super.updateFromNative();
        int i = super.mRS.nMeshGetVertexBufferCount(getID(super.mRS));
        int j = super.mRS.nMeshGetIndexCount(getID(super.mRS));
        int ai[] = new int[i];
        int ai1[] = new int[j];
        int ai2[] = new int[j];
        super.mRS.nMeshGetVertices(getID(super.mRS), ai, i);
        super.mRS.nMeshGetIndices(getID(super.mRS), ai1, ai2, j);
        mVertexBuffers = new Allocation[i];
        mIndexBuffers = new Allocation[j];
        mPrimitives = new Primitive[j];
        for(int k = 0; k < i; k++)
            if(ai[k] != 0) {
                mVertexBuffers[k] = new Allocation(ai[k], super.mRS, null, 1);
                mVertexBuffers[k].updateFromNative();
            }

        for(int l = 0; l < j; l++) {
            if(ai1[l] != 0) {
                mIndexBuffers[l] = new Allocation(ai1[l], super.mRS, null, 1);
                mIndexBuffers[l].updateFromNative();
            }
            mPrimitives[l] = Primitive.values()[ai2[l]];
        }

    }

    Allocation mIndexBuffers[];
    Primitive mPrimitives[];
    Allocation mVertexBuffers[];
}
