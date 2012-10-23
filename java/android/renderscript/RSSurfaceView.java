// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.renderscript;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

// Referenced classes of package android.renderscript:
//            RenderScriptGL

public class RSSurfaceView extends SurfaceView
    implements android.view.SurfaceHolder.Callback {

    public RSSurfaceView(Context context) {
        super(context);
        init();
    }

    public RSSurfaceView(Context context, AttributeSet attributeset) {
        super(context, attributeset);
        init();
    }

    private void init() {
        getHolder().addCallback(this);
    }

    public RenderScriptGL createRenderScriptGL(RenderScriptGL.SurfaceConfig surfaceconfig) {
        RenderScriptGL renderscriptgl = new RenderScriptGL(getContext(), surfaceconfig);
        setRenderScriptGL(renderscriptgl);
        return renderscriptgl;
    }

    public void destroyRenderScriptGL() {
        this;
        JVM INSTR monitorenter ;
        mRS.destroy();
        mRS = null;
        return;
    }

    public RenderScriptGL getRenderScriptGL() {
        return mRS;
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
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k) {
        this;
        JVM INSTR monitorenter ;
        if(mRS != null)
            mRS.setSurface(surfaceholder, j, k);
        return;
    }

    public void surfaceCreated(SurfaceHolder surfaceholder) {
        mSurfaceHolder = surfaceholder;
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder) {
        this;
        JVM INSTR monitorenter ;
        if(mRS != null)
            mRS.setSurface(null, 0, 0);
        return;
    }

    private RenderScriptGL mRS;
    private SurfaceHolder mSurfaceHolder;
}
