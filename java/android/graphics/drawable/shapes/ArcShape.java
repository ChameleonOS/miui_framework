// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics.drawable.shapes;

import android.graphics.Canvas;
import android.graphics.Paint;

// Referenced classes of package android.graphics.drawable.shapes:
//            RectShape

public class ArcShape extends RectShape {

    public ArcShape(float f, float f1) {
        mStart = f;
        mSweep = f1;
    }

    public void draw(Canvas canvas, Paint paint) {
        canvas.drawArc(rect(), mStart, mSweep, true, paint);
    }

    private float mStart;
    private float mSweep;
}
