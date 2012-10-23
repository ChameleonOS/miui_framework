// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.graphics.PointF;

class QuadF {

    public QuadF() {
        p1 = new PointF();
        p2 = new PointF();
        p3 = new PointF();
        p4 = new PointF();
    }

    private static boolean isPointInTriangle(float f, float f1, PointF pointf, PointF pointf1, PointF pointf2) {
        float f2 = pointf.x - pointf2.x;
        float f3 = pointf.y - pointf2.y;
        float f4 = pointf1.x - pointf2.x;
        float f5 = pointf1.y - pointf2.y;
        float f6 = f - pointf2.x;
        float f7 = f1 - pointf2.y;
        float f8 = f5 * f2 - f4 * f3;
        float f9 = (f5 * f6 - f4 * f7) / f8;
        float f10 = (f2 * f7 - f3 * f6) / f8;
        float f11 = 1.0F - f9 - f10;
        boolean flag;
        if(f9 >= 0.0F && f10 >= 0.0F && f11 >= 0.0F)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean containsPoint(float f, float f1) {
        boolean flag;
        if(isPointInTriangle(f, f1, p1, p2, p3) || isPointInTriangle(f, f1, p1, p3, p4))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void offset(float f, float f1) {
        p1.offset(f, f1);
        p2.offset(f, f1);
        p3.offset(f, f1);
        p4.offset(f, f1);
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder("QuadF(");
        stringbuilder.append(p1.x).append(",").append(p1.y);
        stringbuilder.append(" - ");
        stringbuilder.append(p2.x).append(",").append(p2.y);
        stringbuilder.append(" - ");
        stringbuilder.append(p3.x).append(",").append(p3.y);
        stringbuilder.append(" - ");
        stringbuilder.append(p4.x).append(",").append(p4.y);
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public PointF p1;
    public PointF p2;
    public PointF p3;
    public PointF p4;
}
