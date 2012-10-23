// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.renderscript;


// Referenced classes of package android.renderscript:
//            ProgramFragment, RenderScript, Element, Program, 
//            Allocation, FieldPacker, Float4, Type

public class ProgramFragmentFixedFunction extends ProgramFragment {
    public static class Builder {
        private class Slot {

            EnvMode env;
            Format format;
            final Builder this$0;

            Slot(EnvMode envmode, Format format1) {
                this$0 = Builder.this;
                super();
                env = envmode;
                format = format1;
            }
        }

        public static final class Format extends Enum {

            public static Format valueOf(String s) {
                return (Format)Enum.valueOf(android/renderscript/ProgramFragmentFixedFunction$Builder$Format, s);
            }

            public static Format[] values() {
                return (Format[])$VALUES.clone();
            }

            private static final Format $VALUES[];
            public static final Format ALPHA;
            public static final Format LUMINANCE_ALPHA;
            public static final Format RGB;
            public static final Format RGBA;
            int mID;

            static  {
                ALPHA = new Format("ALPHA", 0, 1);
                LUMINANCE_ALPHA = new Format("LUMINANCE_ALPHA", 1, 2);
                RGB = new Format("RGB", 2, 3);
                RGBA = new Format("RGBA", 3, 4);
                Format aformat[] = new Format[4];
                aformat[0] = ALPHA;
                aformat[1] = LUMINANCE_ALPHA;
                aformat[2] = RGB;
                aformat[3] = RGBA;
                $VALUES = aformat;
            }

            private Format(String s, int i, int j) {
                super(s, i);
                mID = j;
            }
        }

        public static final class EnvMode extends Enum {

            public static EnvMode valueOf(String s) {
                return (EnvMode)Enum.valueOf(android/renderscript/ProgramFragmentFixedFunction$Builder$EnvMode, s);
            }

            public static EnvMode[] values() {
                return (EnvMode[])$VALUES.clone();
            }

            private static final EnvMode $VALUES[];
            public static final EnvMode DECAL;
            public static final EnvMode MODULATE;
            public static final EnvMode REPLACE;
            int mID;

            static  {
                REPLACE = new EnvMode("REPLACE", 0, 1);
                MODULATE = new EnvMode("MODULATE", 1, 2);
                DECAL = new EnvMode("DECAL", 2, 3);
                EnvMode aenvmode[] = new EnvMode[3];
                aenvmode[0] = REPLACE;
                aenvmode[1] = MODULATE;
                aenvmode[2] = DECAL;
                $VALUES = aenvmode;
            }

            private EnvMode(String s, int i, int j) {
                super(s, i);
                mID = j;
            }
        }


        private void buildShaderString() {
            int i;
            mShader = "//rs_shader_internal\n";
            mShader = (new StringBuilder()).append(mShader).append("varying lowp vec4 varColor;\n").toString();
            mShader = (new StringBuilder()).append(mShader).append("varying vec2 varTex0;\n").toString();
            mShader = (new StringBuilder()).append(mShader).append("void main() {\n").toString();
            if(mVaryingColorEnable)
                mShader = (new StringBuilder()).append(mShader).append("  lowp vec4 col = varColor;\n").toString();
            else
                mShader = (new StringBuilder()).append(mShader).append("  lowp vec4 col = UNI_Color;\n").toString();
            if(mNumTextures != 0)
                if(mPointSpriteEnable)
                    mShader = (new StringBuilder()).append(mShader).append("  vec2 t0 = gl_PointCoord;\n").toString();
                else
                    mShader = (new StringBuilder()).append(mShader).append("  vec2 t0 = varTex0.xy;\n").toString();
            i = 0;
            if(i < mNumTextures) {
                class _cls1 {

                    static final int $SwitchMap$android$renderscript$ProgramFragmentFixedFunction$Builder$EnvMode[];
                    static final int $SwitchMap$android$renderscript$ProgramFragmentFixedFunction$Builder$Format[];

                    static  {
                        $SwitchMap$android$renderscript$ProgramFragmentFixedFunction$Builder$EnvMode = new int[Builder.EnvMode.values().length];
                        NoSuchFieldError nosuchfielderror6;
                        try {
                            $SwitchMap$android$renderscript$ProgramFragmentFixedFunction$Builder$EnvMode[Builder.EnvMode.REPLACE.ordinal()] = 1;
                        }
                        catch(NoSuchFieldError nosuchfielderror) { }
                        try {
                            $SwitchMap$android$renderscript$ProgramFragmentFixedFunction$Builder$EnvMode[Builder.EnvMode.MODULATE.ordinal()] = 2;
                        }
                        catch(NoSuchFieldError nosuchfielderror1) { }
                        try {
                            $SwitchMap$android$renderscript$ProgramFragmentFixedFunction$Builder$EnvMode[Builder.EnvMode.DECAL.ordinal()] = 3;
                        }
                        catch(NoSuchFieldError nosuchfielderror2) { }
                        $SwitchMap$android$renderscript$ProgramFragmentFixedFunction$Builder$Format = new int[Builder.Format.values().length];
                        try {
                            $SwitchMap$android$renderscript$ProgramFragmentFixedFunction$Builder$Format[Builder.Format.ALPHA.ordinal()] = 1;
                        }
                        catch(NoSuchFieldError nosuchfielderror3) { }
                        try {
                            $SwitchMap$android$renderscript$ProgramFragmentFixedFunction$Builder$Format[Builder.Format.LUMINANCE_ALPHA.ordinal()] = 2;
                        }
                        catch(NoSuchFieldError nosuchfielderror4) { }
                        try {
                            $SwitchMap$android$renderscript$ProgramFragmentFixedFunction$Builder$Format[Builder.Format.RGB.ordinal()] = 3;
                        }
                        catch(NoSuchFieldError nosuchfielderror5) { }
                        $SwitchMap$android$renderscript$ProgramFragmentFixedFunction$Builder$Format[Builder.Format.RGBA.ordinal()] = 4;
_L2:
                        return;
                        nosuchfielderror6;
                        if(true) goto _L2; else goto _L1
_L1:
                    }
                }

                switch(_cls1..SwitchMap.android.renderscript.ProgramFragmentFixedFunction.Builder.EnvMode[mSlots[i].env.ordinal()]) {
                case 1: // '\001'
                    switch(_cls1..SwitchMap.android.renderscript.ProgramFragmentFixedFunction.Builder.Format[mSlots[i].format.ordinal()]) {
                    case 1: // '\001'
                        mShader = (new StringBuilder()).append(mShader).append("  col.a = texture2D(UNI_Tex0, t0).a;\n").toString();
                        break;

                    case 2: // '\002'
                        mShader = (new StringBuilder()).append(mShader).append("  col.rgba = texture2D(UNI_Tex0, t0).rgba;\n").toString();
                        break;

                    case 3: // '\003'
                        mShader = (new StringBuilder()).append(mShader).append("  col.rgb = texture2D(UNI_Tex0, t0).rgb;\n").toString();
                        break;

                    case 4: // '\004'
                        mShader = (new StringBuilder()).append(mShader).append("  col.rgba = texture2D(UNI_Tex0, t0).rgba;\n").toString();
                        break;
                    }
                    // fall through

                default:
                    if(false)
                        ;
                    break;

                case 2: // '\002'
                    switch(_cls1..SwitchMap.android.renderscript.ProgramFragmentFixedFunction.Builder.Format[mSlots[i].format.ordinal()]) {
                    case 1: // '\001'
                        mShader = (new StringBuilder()).append(mShader).append("  col.a *= texture2D(UNI_Tex0, t0).a;\n").toString();
                        break;

                    case 2: // '\002'
                        mShader = (new StringBuilder()).append(mShader).append("  col.rgba *= texture2D(UNI_Tex0, t0).rgba;\n").toString();
                        break;

                    case 3: // '\003'
                        mShader = (new StringBuilder()).append(mShader).append("  col.rgb *= texture2D(UNI_Tex0, t0).rgb;\n").toString();
                        break;

                    case 4: // '\004'
                        mShader = (new StringBuilder()).append(mShader).append("  col.rgba *= texture2D(UNI_Tex0, t0).rgba;\n").toString();
                        break;
                    }
                    if(false)
                        ;
                    break;

                case 3: // '\003'
                    mShader = (new StringBuilder()).append(mShader).append("  col = texture2D(UNI_Tex0, t0);\n").toString();
                    break;
                }
                while(true)  {
                    i++;
                    break MISSING_BLOCK_LABEL_159;
                }
            }
            mShader = (new StringBuilder()).append(mShader).append("  gl_FragColor = col;\n").toString();
            mShader = (new StringBuilder()).append(mShader).append("}\n").toString();
            return;
        }

        public ProgramFragmentFixedFunction create() {
            InternalBuilder internalbuilder = new InternalBuilder(mRS);
            mNumTextures = 0;
            for(int i = 0; i < 2; i++)
                if(mSlots[i] != null)
                    mNumTextures = 1 + mNumTextures;

            buildShaderString();
            internalbuilder.setShader(mShader);
            Type type = null;
            if(!mVaryingColorEnable) {
                Element.Builder builder = new Element.Builder(mRS);
                builder.add(Element.F32_4(mRS), "Color");
                Type.Builder builder1 = new Type.Builder(mRS, builder.create());
                builder1.setX(1);
                type = builder1.create();
                internalbuilder.addConstant(type);
            }
            for(int j = 0; j < mNumTextures; j++)
                internalbuilder.addTexture(Program.TextureType.TEXTURE_2D);

            ProgramFragmentFixedFunction programfragmentfixedfunction = internalbuilder.create();
            programfragmentfixedfunction.mTextureCount = 2;
            if(!mVaryingColorEnable) {
                Allocation allocation = Allocation.createTyped(mRS, type);
                FieldPacker fieldpacker = new FieldPacker(16);
                fieldpacker.addF32(new Float4(1.0F, 1.0F, 1.0F, 1.0F));
                allocation.setFromFieldPacker(0, fieldpacker);
                programfragmentfixedfunction.bindConstants(allocation, 0);
            }
            return programfragmentfixedfunction;
        }

        public Builder setPointSpriteTexCoordinateReplacement(boolean flag) {
            mPointSpriteEnable = flag;
            return this;
        }

        public Builder setTexture(EnvMode envmode, Format format, int i) throws IllegalArgumentException {
            if(i < 0 || i >= 2) {
                throw new IllegalArgumentException("MAX_TEXTURE exceeded.");
            } else {
                mSlots[i] = new Slot(envmode, format);
                return this;
            }
        }

        public Builder setVaryingColor(boolean flag) {
            mVaryingColorEnable = flag;
            return this;
        }

        public static final int MAX_TEXTURE = 2;
        int mNumTextures;
        boolean mPointSpriteEnable;
        RenderScript mRS;
        String mShader;
        Slot mSlots[];
        boolean mVaryingColorEnable;

        public Builder(RenderScript renderscript) {
            mRS = renderscript;
            mSlots = new Slot[2];
            mPointSpriteEnable = false;
        }
    }

    static class InternalBuilder extends Program.BaseProgramBuilder {

        public ProgramFragmentFixedFunction create() {
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

            ProgramFragmentFixedFunction programfragmentfixedfunction = new ProgramFragmentFixedFunction(super.mRS.nProgramFragmentCreate(super.mShader, as, ai), super.mRS);
            initProgram(programfragmentfixedfunction);
            return programfragmentfixedfunction;
        }

        public InternalBuilder(RenderScript renderscript) {
            super(renderscript);
        }
    }


    ProgramFragmentFixedFunction(int i, RenderScript renderscript) {
        super(i, renderscript);
    }
}
