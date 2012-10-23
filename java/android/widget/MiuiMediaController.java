// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.widget;

import android.view.View;

public interface MiuiMediaController {
    public static interface OnControllerChangedListener {

        public abstract void onHidden();

        public abstract void onPlayPause();

        public abstract void onReplay();

        public abstract void onSeekEnd(int i);

        public abstract void onSeekMove(int i);

        public abstract void onSeekStart();

        public abstract void onShown();
    }


    public abstract View getView();

    public abstract void hide();

    public abstract boolean isShowing();

    public abstract void resetTime();

    public abstract void setCanReplay(boolean flag);

    public abstract void setControlListener(OnControllerChangedListener oncontrollerchangedlistener);

    public abstract void setTimes(int i, int j);

    public abstract void show();

    public abstract void showEnded();

    public abstract void showErrorMessage(String s);

    public abstract void showLoading();

    public abstract void showPaused();

    public abstract void showPlaying();
}
