// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.opengl.GLES20;
import android.view.Surface;

// Referenced classes of package android.webkit:
//            HTML5VideoView, HTML5VideoViewProxy

public class HTML5VideoInline extends HTML5VideoView {

    HTML5VideoInline(int i, int j) {
        init(i, j, false);
    }

    public static void cleanupSurfaceTexture() {
        mSurfaceTexture = null;
        mVideoLayerUsingSurfaceTexture = -1;
    }

    public static SurfaceTexture getSurfaceTexture(int i) {
        if(i != mVideoLayerUsingSurfaceTexture || mSurfaceTexture == null || mTextureNames == null) {
            mTextureNames = new int[1];
            GLES20.glGenTextures(1, mTextureNames, 0);
            mSurfaceTexture = new SurfaceTexture(mTextureNames[0]);
        }
        mVideoLayerUsingSurfaceTexture = i;
        return mSurfaceTexture;
    }

    private void setFrameAvailableListener(android.graphics.SurfaceTexture.OnFrameAvailableListener onframeavailablelistener) {
        mSurfaceTexture.setOnFrameAvailableListener(onframeavailablelistener);
    }

    public void decideDisplayMode() {
        Surface surface = new Surface(getSurfaceTexture(getVideoLayerId()));
        mPlayer.setSurface(surface);
        surface.release();
    }

    public void deleteSurfaceTexture() {
        cleanupSurfaceTexture();
    }

    public int getTextureName() {
        int i = 0;
        if(mTextureNames != null)
            i = mTextureNames[0];
        return i;
    }

    public void pauseAndDispatch(HTML5VideoViewProxy html5videoviewproxy) {
        super.pauseAndDispatch(html5videoviewproxy);
    }

    public void prepareDataAndDisplayMode(HTML5VideoViewProxy html5videoviewproxy) {
        super.prepareDataAndDisplayMode(html5videoviewproxy);
        setFrameAvailableListener(html5videoviewproxy);
        if(super.mProxy.getContext().checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0)
            mPlayer.setWakeMode(html5videoviewproxy.getContext(), 26);
    }

    public void start() {
        if(!getPauseDuringPreparing())
            super.start();
    }

    public boolean surfaceTextureDeleted() {
        boolean flag;
        if(mSurfaceTexture == null)
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static SurfaceTexture mSurfaceTexture = null;
    private static int mTextureNames[] = null;
    private static int mVideoLayerUsingSurfaceTexture = -1;

}
