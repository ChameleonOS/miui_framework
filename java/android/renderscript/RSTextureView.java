// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.renderscript;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;

// Referenced classes of package android.renderscript:
//            RenderScriptGL

public class RSTextureView extends TextureView
    implements android.view.TextureView.SurfaceTextureListener {

    public RSTextureView(Context context) {
        super(context);
        init();
    }

    public RSTextureView(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        init();
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public RenderScriptGL createRenderScriptGL(RenderScriptGL.SurfaceConfig surfaceconfig) {
        RenderScriptGL renderscriptgl = new RenderScriptGL(getContext(), surfaceconfig);
        setRenderScriptGL(renderscriptgl);
        if(mSurfaceTexture != null)
            mRS.setSurfaceTexture(mSurfaceTexture, getWidth(), getHeight());
        return renderscriptgl;
    }

    public void destroyRenderScriptGL() {
        mRS.destroy();
        mRS = null;
    }

    public RenderScriptGL getRenderScriptGL() {
        return mRS;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfacetexture, int i, int j) {
        mSurfaceTexture = surfacetexture;
        if(mRS != null)
            mRS.setSurfaceTexture(mSurfaceTexture, i, j);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfacetexture) {
        mSurfaceTexture = surfacetexture;
        if(mRS != null)
            mRS.setSurfaceTexture(null, 0, 0);
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfacetexture, int i, int j) {
        mSurfaceTexture = surfacetexture;
        if(mRS != null)
            mRS.setSurfaceTexture(mSurfaceTexture, i, j);
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfacetexture) {
        mSurfaceTexture = surfacetexture;
    }

    public void pause() {
        if(mRS != null)
            mRS.pause();
    }

    public void resume() {
        if(mRS != null)
            mRS.resume();
    }

    public void setRenderScriptGL(RenderScriptGL renderscriptgl) {
        mRS = renderscriptgl;
        if(mSurfaceTexture != null)
            mRS.setSurfaceTexture(mSurfaceTexture, getWidth(), getHeight());
    }

    private RenderScriptGL mRS;
    private SurfaceTexture mSurfaceTexture;
}
