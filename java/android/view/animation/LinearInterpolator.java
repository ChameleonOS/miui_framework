// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view.animation;

import android.content.Context;
import android.util.AttributeSet;

// Referenced classes of package android.view.animation:
//            Interpolator

public class LinearInterpolator
    implements Interpolator {

    public LinearInterpolator() {
    }

    public LinearInterpolator(Context context, AttributeSet attributeset) {
    }

    public float getInterpolation(float f) {
        return f;
    }
}
