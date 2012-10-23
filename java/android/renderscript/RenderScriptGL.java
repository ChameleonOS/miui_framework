// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.renderscript;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;

// Referenced classes of package android.renderscript:
//            RenderScript, RSDriverException, ProgramFragment, ProgramRaster, 
//            ProgramStore, ProgramVertex, Script, RSIllegalArgumentException

public class RenderScriptGL extends RenderScript {
    public static class SurfaceConfig {

        private void validateRange(int i, int j, int k, int l) {
            if(i < k || i > l)
                throw new RSIllegalArgumentException("Minimum value provided out of range.");
            if(j < i)
                throw new RSIllegalArgumentException("preferred must be >= Minimum.");
            else
                return;
        }

        public void setAlpha(int i, int j) {
            validateRange(i, j, 0, 8);
            mAlphaMin = i;
            mAlphaPref = j;
        }

        public void setColor(int i, int j) {
            validateRange(i, j, 5, 8);
            mColorMin = i;
            mColorPref = j;
        }

        public void setDepth(int i, int j) {
            validateRange(i, j, 0, 24);
            mDepthMin = i;
            mDepthPref = j;
        }

        public void setSamples(int i, int j, float f) {
            validateRange(i, j, 1, 32);
            if(f < 0.0F || f > 1.0F) {
                throw new RSIllegalArgumentException("Quality out of 0-1 range.");
            } else {
                mSamplesMin = i;
                mSamplesPref = j;
                mSamplesQ = f;
                return;
            }
        }

        int mAlphaMin;
        int mAlphaPref;
        int mColorMin;
        int mColorPref;
        int mDepthMin;
        int mDepthPref;
        int mSamplesMin;
        int mSamplesPref;
        float mSamplesQ;
        int mStencilMin;
        int mStencilPref;

        public SurfaceConfig() {
            mDepthMin = 0;
            mDepthPref = 0;
            mStencilMin = 0;
            mStencilPref = 0;
            mColorMin = 8;
            mColorPref = 8;
            mAlphaMin = 0;
            mAlphaPref = 0;
            mSamplesMin = 1;
            mSamplesPref = 1;
            mSamplesQ = 1.0F;
        }

        public SurfaceConfig(SurfaceConfig surfaceconfig) {
            mDepthMin = 0;
            mDepthPref = 0;
            mStencilMin = 0;
            mStencilPref = 0;
            mColorMin = 8;
            mColorPref = 8;
            mAlphaMin = 0;
            mAlphaPref = 0;
            mSamplesMin = 1;
            mSamplesPref = 1;
            mSamplesQ = 1.0F;
            mDepthMin = surfaceconfig.mDepthMin;
            mDepthPref = surfaceconfig.mDepthPref;
            mStencilMin = surfaceconfig.mStencilMin;
            mStencilPref = surfaceconfig.mStencilPref;
            mColorMin = surfaceconfig.mColorMin;
            mColorPref = surfaceconfig.mColorPref;
            mAlphaMin = surfaceconfig.mAlphaMin;
            mAlphaPref = surfaceconfig.mAlphaPref;
            mSamplesMin = surfaceconfig.mSamplesMin;
            mSamplesPref = surfaceconfig.mSamplesPref;
            mSamplesQ = surfaceconfig.mSamplesQ;
        }
    }


    public RenderScriptGL(Context context, SurfaceConfig surfaceconfig) {
        super(context);
        mSurfaceConfig = new SurfaceConfig(surfaceconfig);
        int i = context.getApplicationInfo().targetSdkVersion;
        mWidth = 0;
        mHeight = 0;
        super.mDev = nDeviceCreate();
        int j = context.getResources().getDisplayMetrics().densityDpi;
        super.mContext = nContextCreateGL(super.mDev, 0, i, mSurfaceConfig.mColorMin, mSurfaceConfig.mColorPref, mSurfaceConfig.mAlphaMin, mSurfaceConfig.mAlphaPref, mSurfaceConfig.mDepthMin, mSurfaceConfig.mDepthPref, mSurfaceConfig.mStencilMin, mSurfaceConfig.mStencilPref, mSurfaceConfig.mSamplesMin, mSurfaceConfig.mSamplesPref, mSurfaceConfig.mSamplesQ, j);
        if(super.mContext == 0) {
            throw new RSDriverException("Failed to create RS context.");
        } else {
            super.mMessageThread = new RenderScript.MessageThread(this);
            super.mMessageThread.start();
            return;
        }
    }

    public void bindProgramFragment(ProgramFragment programfragment) {
        validate();
        nContextBindProgramFragment(safeID(programfragment));
    }

    public void bindProgramRaster(ProgramRaster programraster) {
        validate();
        nContextBindProgramRaster(safeID(programraster));
    }

    public void bindProgramStore(ProgramStore programstore) {
        validate();
        nContextBindProgramStore(safeID(programstore));
    }

    public void bindProgramVertex(ProgramVertex programvertex) {
        validate();
        nContextBindProgramVertex(safeID(programvertex));
    }

    public void bindRootScript(Script script) {
        validate();
        nContextBindRootScript(safeID(script));
    }

    public int getHeight() {
        return mHeight;
    }

    public int getWidth() {
        return mWidth;
    }

    public void pause() {
        validate();
        nContextPause();
    }

    public void resume() {
        validate();
        nContextResume();
    }

    public void setSurface(SurfaceHolder surfaceholder, int i, int j) {
        validate();
        android.view.Surface surface = null;
        if(surfaceholder != null)
            surface = surfaceholder.getSurface();
        mWidth = i;
        mHeight = j;
        nContextSetSurface(i, j, surface);
    }

    public void setSurfaceTexture(SurfaceTexture surfacetexture, int i, int j) {
        validate();
        mWidth = i;
        mHeight = j;
        nContextSetSurfaceTexture(i, j, surfacetexture);
    }

    int mHeight;
    SurfaceConfig mSurfaceConfig;
    int mWidth;
}
