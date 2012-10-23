// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.renderscript;


// Referenced classes of package android.renderscript:
//            Program, RenderScript, Element, Type

public class ProgramFragment extends Program {
    public static class Builder extends Program.BaseProgramBuilder {

        public ProgramFragment create() {
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

            ProgramFragment programfragment = new ProgramFragment(super.mRS.nProgramFragmentCreate(super.mShader, as, ai), super.mRS);
            initProgram(programfragment);
            return programfragment;
        }

        public Builder(RenderScript renderscript) {
            super(renderscript);
        }
    }


    ProgramFragment(int i, RenderScript renderscript) {
        super(i, renderscript);
    }
}
