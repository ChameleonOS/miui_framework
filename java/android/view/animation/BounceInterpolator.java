// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view.animation;

import android.content.Context;
import android.util.AttributeSet;

// Referenced classes of package android.view.animation:
//            Interpolator

public class BounceInterpolator
    implements Interpolator {

    public BounceInterpolator() {
    }

    public BounceInterpolator(Context context, AttributeSet attributeset) {
    }

    private static float bounce(float f) {
        return 8F * (f * f);
    }

    public float getInterpolation(float f) {
        float f1 = f * 1.1226F;
        float f2;
        if(f1 < 0.3535F)
            f2 = bounce(f1);
        else
        if(f1 < 0.7408F)
            f2 = 0.7F + bounce(f1 - 0.54719F);
        else
        if(f1 < 0.9644F)
            f2 = 0.9F + bounce(f1 - 0.8526F);
        else
            f2 = 0.95F + bounce(f1 - 1.0435F);
        return f2;
    }
}
