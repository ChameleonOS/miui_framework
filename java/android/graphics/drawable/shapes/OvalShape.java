// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics.drawable.shapes;

import android.graphics.Canvas;
import android.graphics.Paint;

// Referenced classes of package android.graphics.drawable.shapes:
//            RectShape

public class OvalShape extends RectShape {

    public OvalShape() {
    }

    public void draw(Canvas canvas, Paint paint) {
        canvas.drawOval(rect(), paint);
    }
}
