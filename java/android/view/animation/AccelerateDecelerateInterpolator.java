// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view.animation;

import android.content.Context;
import android.util.AttributeSet;

// Referenced classes of package android.view.animation:
//            Interpolator

public class AccelerateDecelerateInterpolator
    implements Interpolator {

    public AccelerateDecelerateInterpolator() {
    }

    public AccelerateDecelerateInterpolator(Context context, AttributeSet attributeset) {
    }

    public float getInterpolation(float f) {
        return 0.5F + (float)(Math.cos(3.1415926535897931D * (double)(1.0F + f)) / 2D);
    }
}
