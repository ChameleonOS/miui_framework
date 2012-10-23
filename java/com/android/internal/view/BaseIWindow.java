// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.view;

import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.*;
import android.view.DragEvent;
import android.view.IWindowSession;

public class BaseIWindow extends android.view.IWindow.Stub {

    public BaseIWindow() {
    }

    public void closeSystemDialogs(String s) {
    }

    public void dispatchAppVisibility(boolean flag) {
    }

    public void dispatchDragEvent(DragEvent dragevent) {
    }

    public void dispatchGetNewSurface() {
    }

    public void dispatchScreenState(boolean flag) {
    }

    public void dispatchSystemUiVisibilityChanged(int i, int j, int k, int l) {
        mSeq = i;
    }

    public void dispatchWallpaperCommand(String s, int i, int j, int k, Bundle bundle, boolean flag) {
        if(!flag)
            break MISSING_BLOCK_LABEL_19;
        mSession.wallpaperCommandComplete(asBinder(), null);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void dispatchWallpaperOffsets(float f, float f1, float f2, float f3, boolean flag) {
        if(!flag)
            break MISSING_BLOCK_LABEL_18;
        mSession.wallpaperOffsetsComplete(asBinder());
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void doneAnimating() {
    }

    public void executeCommand(String s, String s1, ParcelFileDescriptor parcelfiledescriptor) {
    }

    public void resized(int i, int j, Rect rect, Rect rect1, boolean flag, Configuration configuration) {
        if(!flag)
            break MISSING_BLOCK_LABEL_15;
        mSession.finishDrawing(this);
_L2:
        return;
        RemoteException remoteexception;
        remoteexception;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void setSession(IWindowSession iwindowsession) {
        mSession = iwindowsession;
    }

    public void windowFocusChanged(boolean flag, boolean flag1) {
    }

    public int mSeq;
    private IWindowSession mSession;
}
