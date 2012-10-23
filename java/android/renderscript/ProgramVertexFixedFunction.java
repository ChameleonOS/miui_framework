// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.renderscript;


// Referenced classes of package android.renderscript:
//            ProgramVertex, BaseObj, RenderScript, Allocation, 
//            FieldPacker, Type, Element, Matrix4f, 
//            RSIllegalArgumentException

public class ProgramVertexFixedFunction extends ProgramVertex {
    public static class Constants {

        private void addToBuffer(int i, Matrix4f matrix4f) {
            mIOBuffer.reset(i);
            for(int j = 0; j < 16; j++)
                mIOBuffer.addF32(matrix4f.mMat[j]);

            mAlloc.setFromFieldPacker(0, mIOBuffer);
        }

        public void destroy() {
            mAlloc.destroy();
            mAlloc = null;
        }

        Allocation getAllocation() {
            return mAlloc;
        }

        public void setModelview(Matrix4f matrix4f) {
            mModel.load(matrix4f);
            addToBuffer(0, matrix4f);
        }

        public void setProjection(Matrix4f matrix4f) {
            mProjection.load(matrix4f);
            addToBuffer(64, matrix4f);
        }

        public void setTexture(Matrix4f matrix4f) {
            mTexture.load(matrix4f);
            addToBuffer(128, matrix4f);
        }

        static final int MODELVIEW_OFFSET = 0;
        static final int PROJECTION_OFFSET = 16;
        static final int TEXTURE_OFFSET = 32;
        Allocation mAlloc;
        private FieldPacker mIOBuffer;
        Matrix4f mModel;
        Matrix4f mProjection;
        Matrix4f mTexture;

        public Constants(RenderScript renderscript) {
            Type type = Builder.getConstantInputType(renderscript);
            mAlloc = Allocation.createTyped(renderscript, type);
            mIOBuffer = new FieldPacker(type.getElement().getBytesSize() * type.getCount());
            mModel = new Matrix4f();
            mProjection = new Matrix4f();
            mTexture = new Matrix4f();
            setModelview(new Matrix4f());
            setProjection(new Matrix4f());
            setTexture(new Matrix4f());
        }
    }

    public static class Builder {

        private void buildShaderString() {
            mShader = "//rs_shader_internal\n";
            mShader = (new StringBuilder()).append(mShader).append("varying vec4 varColor;\n").toString();
            mShader = (new StringBuilder()).append(mShader).append("varying vec2 varTex0;\n").toString();
            mShader = (new StringBuilder()).append(mShader).append("void main() {\n").toString();
            mShader = (new StringBuilder()).append(mShader).append("  gl_Position = UNI_MVP * ATTRIB_position;\n").toString();
            mShader = (new StringBuilder()).append(mShader).append("  gl_PointSize = 1.0;\n").toString();
            mShader = (new StringBuilder()).append(mShader).append("  varColor = ATTRIB_color;\n").toString();
            if(mTextureMatrixEnable)
                mShader = (new StringBuilder()).append(mShader).append("  varTex0 = (UNI_TexMatrix * vec4(ATTRIB_texture0, 0.0, 1.0)).xy;\n").toString();
            else
                mShader = (new StringBuilder()).append(mShader).append("  varTex0 = ATTRIB_texture0;\n").toString();
            mShader = (new StringBuilder()).append(mShader).append("}\n").toString();
        }

        static Type getConstantInputType(RenderScript renderscript) {
            Element.Builder builder = new Element.Builder(renderscript);
            builder.add(Element.MATRIX4X4(renderscript), "MV");
            builder.add(Element.MATRIX4X4(renderscript), "P");
            builder.add(Element.MATRIX4X4(renderscript), "TexMatrix");
            builder.add(Element.MATRIX4X4(renderscript), "MVP");
            Type.Builder builder1 = new Type.Builder(renderscript, builder.create());
            builder1.setX(1);
            return builder1.create();
        }

        public ProgramVertexFixedFunction create() {
            buildShaderString();
            InternalBuilder internalbuilder = new InternalBuilder(mRS);
            internalbuilder.setShader(mShader);
            internalbuilder.addConstant(getConstantInputType(mRS));
            Element.Builder builder = new Element.Builder(mRS);
            builder.add(Element.F32_4(mRS), "position");
            builder.add(Element.F32_4(mRS), "color");
            builder.add(Element.F32_3(mRS), "normal");
            builder.add(Element.F32_2(mRS), "texture0");
            internalbuilder.addInput(builder.create());
            return internalbuilder.create();
        }

        public Builder setTextureMatrixEnable(boolean flag) {
            mTextureMatrixEnable = flag;
            return this;
        }

        RenderScript mRS;
        String mShader;
        boolean mTextureMatrixEnable;

        public Builder(RenderScript renderscript) {
            mRS = renderscript;
        }
    }

    static class InternalBuilder extends Program.BaseProgramBuilder {

        public InternalBuilder addInput(Element element) throws IllegalStateException {
            if(super.mInputCount >= 8)
                throw new RSIllegalArgumentException("Max input count exceeded.");
            if(element.isComplex()) {
                throw new RSIllegalArgumentException("Complex elements not allowed.");
            } else {
                Element aelement[] = super.mInputs;
                int i = super.mInputCount;
                super.mInputCount = i + 1;
                aelement[i] = element;
                return this;
            }
        }

        public ProgramVertexFixedFunction create() {
            super.mRS.validate();
            int ai[] = new int[2 * (super.mInputCount + super.mOutputCount + super.mConstantCount + super.mTextureCount)];
            String as[] = new String[super.mTextureCount];
            int i = 0;
            for(int j = 0; j < super.mInputCount; j++) {
                int i2 = i + 1;
                ai[i] = Program.ProgramParam.INPUT.mID;
                i = i2 + 1;
                ai[i2] = super.mInputs[j].getID(super.mRS);
            }

            for(int k = 0; k < super.mOutputCount; k++) {
                int l1 = i + 1;
                ai[i] = Program.ProgramParam.OUTPUT.mID;
                i = l1 + 1;
                ai[l1] = super.mOutputs[k].getID(super.mRS);
            }

            for(int l = 0; l < super.mConstantCount; l++) {
                int k1 = i + 1;
                ai[i] = Program.ProgramParam.CONSTANT.mID;
                i = k1 + 1;
                ai[k1] = super.mConstants[l].getID(super.mRS);
            }

            for(int i1 = 0; i1 < super.mTextureCount; i1++) {
                int j1 = i + 1;
                ai[i] = Program.ProgramParam.TEXTURE_TYPE.mID;
                i = j1 + 1;
                ai[j1] = super.mTextureTypes[i1].mID;
                as[i1] = super.mTextureNames[i1];
            }

            ProgramVertexFixedFunction programvertexfixedfunction = new ProgramVertexFixedFunction(super.mRS.nProgramVertexCreate(super.mShader, as, ai), super.mRS);
            initProgram(programvertexfixedfunction);
            return programvertexfixedfunction;
        }

        public InternalBuilder(RenderScript renderscript) {
            super(renderscript);
        }
    }


    ProgramVertexFixedFunction(int i, RenderScript renderscript) {
        super(i, renderscript);
    }

    public void bindConstants(Constants constants) {
        super.mRS.validate();
        bindConstants(constants.getAllocation(), 0);
    }
}
