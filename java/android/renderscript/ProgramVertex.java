// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.renderscript;


// Referenced classes of package android.renderscript:
//            Program, RenderScript, Element, RSIllegalArgumentException, 
//            Type

public class ProgramVertex extends Program {
    public static class Builder extends Program.BaseProgramBuilder {

        public Builder addInput(Element element) throws IllegalStateException {
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

        public ProgramVertex create() {
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

            ProgramVertex programvertex = new ProgramVertex(super.mRS.nProgramVertexCreate(super.mShader, as, ai), super.mRS);
            initProgram(programvertex);
            return programvertex;
        }

        public Builder(RenderScript renderscript) {
            super(renderscript);
        }
    }


    ProgramVertex(int i, RenderScript renderscript) {
        super(i, renderscript);
    }

    public Element getInput(int i) {
        if(i < 0 || i >= super.mInputs.length)
            throw new IllegalArgumentException("Slot ID out of range.");
        else
            return super.mInputs[i];
    }

    public int getInputCount() {
        int i;
        if(super.mInputs != null)
            i = super.mInputs.length;
        else
            i = 0;
        return i;
    }
}
