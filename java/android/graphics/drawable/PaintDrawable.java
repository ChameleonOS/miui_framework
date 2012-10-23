// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics.drawable;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

// Referenced classes of package android.graphics.drawable:
//            ShapeDrawable

public class PaintDrawable extends ShapeDrawable {

    public PaintDrawable() {
    }

    public PaintDrawable(int i) {
        getPaint().setColor(i);
    }

    protected boolean inflateTag(String s, Resources resources, XmlPullParser xmlpullparser, AttributeSet attributeset) {
        boolean flag;
        if(s.equals("corners")) {
            TypedArray typedarray = resources.obtainAttributes(attributeset, com.android.internal.R.styleable.DrawableCorners);
            int i = typedarray.getDimensionPixelSize(0, 0);
            setCornerRadius(i);
            int j = typedarray.getDimensionPixelSize(1, i);
            int k = typedarray.getDimensionPixelSize(2, i);
            int l = typedarray.getDimensionPixelSize(3, i);
            int i1 = typedarray.getDimensionPixelSize(4, i);
            if(j != i || k != i || l != i || i1 != i) {
                float af[] = new float[8];
                af[0] = j;
                af[1] = j;
                af[2] = k;
                af[3] = k;
                af[4] = l;
                af[5] = l;
                af[6] = i1;
                af[7] = i1;
                setCornerRadii(af);
            }
            typedarray.recycle();
            flag = true;
        } else {
            flag = super.inflateTag(s, resources, xmlpullparser, attributeset);
        }
        return flag;
    }

    public void setCornerRadii(float af[]) {
        if(af == null) {
            if(getShape() != null)
                setShape(null);
        } else {
            setShape(new RoundRectShape(af, null, null));
        }
        invalidateSelf();
    }

    public void setCornerRadius(float f) {
        float af[] = null;
        if(f > 0.0F) {
            af = new float[8];
            for(int i = 0; i < 8; i++)
                af[i] = f;

        }
        setCornerRadii(af);
    }
}
