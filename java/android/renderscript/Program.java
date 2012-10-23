// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.renderscript;

import android.content.res.Resources;
import android.util.Log;
import java.io.*;

// Referenced classes of package android.renderscript:
//            BaseObj, Allocation, Type, RenderScript, 
//            Sampler, Element, RSIllegalArgumentException

public class Program extends BaseObj {
    public static class BaseProgramBuilder {

        public BaseProgramBuilder addConstant(Type type) throws IllegalStateException {
            if(mConstantCount >= 8)
                throw new RSIllegalArgumentException("Max input count exceeded.");
            if(type.getElement().isComplex()) {
                throw new RSIllegalArgumentException("Complex elements not allowed.");
            } else {
                mConstants[mConstantCount] = type;
                mConstantCount = 1 + mConstantCount;
                return this;
            }
        }

        public BaseProgramBuilder addTexture(TextureType texturetype) throws IllegalArgumentException {
            addTexture(texturetype, (new StringBuilder()).append("Tex").append(mTextureCount).toString());
            return this;
        }

        public BaseProgramBuilder addTexture(TextureType texturetype, String s) throws IllegalArgumentException {
            if(mTextureCount >= 8) {
                throw new IllegalArgumentException("Max texture count exceeded.");
            } else {
                mTextureTypes[mTextureCount] = texturetype;
                mTextureNames[mTextureCount] = s;
                mTextureCount = 1 + mTextureCount;
                return this;
            }
        }

        public int getCurrentConstantIndex() {
            return -1 + mConstantCount;
        }

        public int getCurrentTextureIndex() {
            return -1 + mTextureCount;
        }

        protected void initProgram(Program program) {
            program.mInputs = new Element[mInputCount];
            System.arraycopy(mInputs, 0, program.mInputs, 0, mInputCount);
            program.mOutputs = new Element[mOutputCount];
            System.arraycopy(mOutputs, 0, program.mOutputs, 0, mOutputCount);
            program.mConstants = new Type[mConstantCount];
            System.arraycopy(mConstants, 0, program.mConstants, 0, mConstantCount);
            program.mTextureCount = mTextureCount;
            program.mTextures = new TextureType[mTextureCount];
            System.arraycopy(mTextureTypes, 0, program.mTextures, 0, mTextureCount);
            program.mTextureNames = new String[mTextureCount];
            System.arraycopy(mTextureNames, 0, program.mTextureNames, 0, mTextureCount);
        }

        public BaseProgramBuilder setShader(Resources resources, int i) {
            InputStream inputstream = resources.openRawResource(i);
            byte abyte0[];
            int j;
            abyte0 = new byte[1024];
            j = 0;
_L1:
            int l;
            int k = abyte0.length - j;
            if(k == 0) {
                byte abyte1[] = new byte[2 * abyte0.length];
                System.arraycopy(abyte0, 0, abyte1, 0, abyte0.length);
                abyte0 = abyte1;
                k = abyte0.length - j;
            }
            l = inputstream.read(abyte0, j, k);
            if(l <= 0) {
                Exception exception;
                try {
                    inputstream.close();
                }
                catch(IOException ioexception) {
                    throw new android.content.res.Resources.NotFoundException();
                }
                try {
                    mShader = new String(abyte0, 0, j, "UTF-8");
                }
                catch(UnsupportedEncodingException unsupportedencodingexception) {
                    Log.e("Renderscript shader creation", "Could not decode shader string");
                }
                return this;
            }
            j += l;
              goto _L1
            exception;
            inputstream.close();
            throw exception;
        }

        public BaseProgramBuilder setShader(String s) {
            mShader = s;
            return this;
        }

        int mConstantCount;
        Type mConstants[];
        int mInputCount;
        Element mInputs[];
        int mOutputCount;
        Element mOutputs[];
        RenderScript mRS;
        String mShader;
        int mTextureCount;
        String mTextureNames[];
        TextureType mTextureTypes[];
        Type mTextures[];

        protected BaseProgramBuilder(RenderScript renderscript) {
            mRS = renderscript;
            mInputs = new Element[8];
            mOutputs = new Element[8];
            mConstants = new Type[8];
            mInputCount = 0;
            mOutputCount = 0;
            mConstantCount = 0;
            mTextureCount = 0;
            mTextureTypes = new TextureType[8];
            mTextureNames = new String[8];
        }
    }

    static final class ProgramParam extends Enum {

        public static ProgramParam valueOf(String s) {
            return (ProgramParam)Enum.valueOf(android/renderscript/Program$ProgramParam, s);
        }

        public static ProgramParam[] values() {
            return (ProgramParam[])$VALUES.clone();
        }

        private static final ProgramParam $VALUES[];
        public static final ProgramParam CONSTANT;
        public static final ProgramParam INPUT;
        public static final ProgramParam OUTPUT;
        public static final ProgramParam TEXTURE_TYPE;
        int mID;

        static  {
            INPUT = new ProgramParam("INPUT", 0, 0);
            OUTPUT = new ProgramParam("OUTPUT", 1, 1);
            CONSTANT = new ProgramParam("CONSTANT", 2, 2);
            TEXTURE_TYPE = new ProgramParam("TEXTURE_TYPE", 3, 3);
            ProgramParam aprogramparam[] = new ProgramParam[4];
            aprogramparam[0] = INPUT;
            aprogramparam[1] = OUTPUT;
            aprogramparam[2] = CONSTANT;
            aprogramparam[3] = TEXTURE_TYPE;
            $VALUES = aprogramparam;
        }

        private ProgramParam(String s, int i, int j) {
            super(s, i);
            mID = j;
        }
    }

    public static final class TextureType extends Enum {

        public static TextureType valueOf(String s) {
            return (TextureType)Enum.valueOf(android/renderscript/Program$TextureType, s);
        }

        public static TextureType[] values() {
            return (TextureType[])$VALUES.clone();
        }

        private static final TextureType $VALUES[];
        public static final TextureType TEXTURE_2D;
        public static final TextureType TEXTURE_CUBE;
        int mID;

        static  {
            TEXTURE_2D = new TextureType("TEXTURE_2D", 0, 0);
            TEXTURE_CUBE = new TextureType("TEXTURE_CUBE", 1, 1);
            TextureType atexturetype[] = new TextureType[2];
            atexturetype[0] = TEXTURE_2D;
            atexturetype[1] = TEXTURE_CUBE;
            $VALUES = atexturetype;
        }

        private TextureType(String s, int i, int j) {
            super(s, i);
            mID = j;
        }
    }


    Program(int i, RenderScript renderscript) {
        super(i, renderscript);
    }

    public void bindConstants(Allocation allocation, int i) {
        if(i < 0 || i >= mConstants.length)
            throw new IllegalArgumentException("Slot ID out of range.");
        if(allocation != null && allocation.getType().getID(super.mRS) != mConstants[i].getID(super.mRS))
            throw new IllegalArgumentException("Allocation type does not match slot type.");
        int j;
        if(allocation != null)
            j = allocation.getID(super.mRS);
        else
            j = 0;
        super.mRS.nProgramBindConstants(getID(super.mRS), i, j);
    }

    public void bindSampler(Sampler sampler, int i) throws IllegalArgumentException {
        super.mRS.validate();
        if(i < 0 || i >= mTextureCount)
            throw new IllegalArgumentException("Slot ID out of range.");
        int j;
        if(sampler != null)
            j = sampler.getID(super.mRS);
        else
            j = 0;
        super.mRS.nProgramBindSampler(getID(super.mRS), i, j);
    }

    public void bindTexture(Allocation allocation, int i) throws IllegalArgumentException {
        super.mRS.validate();
        if(i < 0 || i >= mTextureCount)
            throw new IllegalArgumentException("Slot ID out of range.");
        if(allocation != null && allocation.getType().hasFaces() && mTextures[i] != TextureType.TEXTURE_CUBE)
            throw new IllegalArgumentException("Cannot bind cubemap to 2d texture slot");
        int j;
        if(allocation != null)
            j = allocation.getID(super.mRS);
        else
            j = 0;
        super.mRS.nProgramBindTexture(getID(super.mRS), i, j);
    }

    public Type getConstant(int i) {
        if(i < 0 || i >= mConstants.length)
            throw new IllegalArgumentException("Slot ID out of range.");
        else
            return mConstants[i];
    }

    public int getConstantCount() {
        int i;
        if(mConstants != null)
            i = mConstants.length;
        else
            i = 0;
        return i;
    }

    public int getTextureCount() {
        return mTextureCount;
    }

    public String getTextureName(int i) {
        if(i < 0 || i >= mTextureCount)
            throw new IllegalArgumentException("Slot ID out of range.");
        else
            return mTextureNames[i];
    }

    public TextureType getTextureType(int i) {
        if(i < 0 || i >= mTextureCount)
            throw new IllegalArgumentException("Slot ID out of range.");
        else
            return mTextures[i];
    }

    static final int MAX_CONSTANT = 8;
    static final int MAX_INPUT = 8;
    static final int MAX_OUTPUT = 8;
    static final int MAX_TEXTURE = 8;
    Type mConstants[];
    Element mInputs[];
    Element mOutputs[];
    String mShader;
    int mTextureCount;
    String mTextureNames[];
    TextureType mTextures[];
}
