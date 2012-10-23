// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view.inputmethod;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;

// Referenced classes of package android.view.inputmethod:
//            CompletionInfo, ExtractedText

public interface InputMethodSession {
    public static interface EventCallback {

        public abstract void finishedEvent(int i, boolean flag);
    }


    public abstract void appPrivateCommand(String s, Bundle bundle);

    public abstract void dispatchKeyEvent(int i, KeyEvent keyevent, EventCallback eventcallback);

    public abstract void dispatchTrackballEvent(int i, MotionEvent motionevent, EventCallback eventcallback);

    public abstract void displayCompletions(CompletionInfo acompletioninfo[]);

    public abstract void finishInput();

    public abstract void toggleSoftInput(int i, int j);

    public abstract void updateCursor(Rect rect);

    public abstract void updateExtractedText(int i, ExtractedText extractedtext);

    public abstract void updateSelection(int i, int j, int k, int l, int i1, int j1);

    public abstract void viewClicked(boolean flag);
}
