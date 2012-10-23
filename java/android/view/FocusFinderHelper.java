// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.graphics.Rect;

// Referenced classes of package android.view:
//            FocusFinder

public class FocusFinderHelper {

    public FocusFinderHelper(FocusFinder focusfinder) {
        mFocusFinder = focusfinder;
    }

    public static int majorAxisDistance(int i, Rect rect, Rect rect1) {
        return FocusFinder.majorAxisDistance(i, rect, rect1);
    }

    public static int majorAxisDistanceToFarEdge(int i, Rect rect, Rect rect1) {
        return FocusFinder.majorAxisDistanceToFarEdge(i, rect, rect1);
    }

    public boolean beamBeats(int i, Rect rect, Rect rect1, Rect rect2) {
        return mFocusFinder.beamBeats(i, rect, rect1, rect2);
    }

    public boolean beamsOverlap(int i, Rect rect, Rect rect1) {
        return mFocusFinder.beamsOverlap(i, rect, rect1);
    }

    public boolean isBetterCandidate(int i, Rect rect, Rect rect1, Rect rect2) {
        return mFocusFinder.isBetterCandidate(i, rect, rect1, rect2);
    }

    public boolean isCandidate(Rect rect, Rect rect1, int i) {
        return mFocusFinder.isCandidate(rect, rect1, i);
    }

    private FocusFinder mFocusFinder;
}
