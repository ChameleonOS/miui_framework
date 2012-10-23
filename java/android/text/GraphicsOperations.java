// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.text;

import android.graphics.Canvas;
import android.graphics.Paint;

public interface GraphicsOperations
    extends CharSequence {

    public abstract void drawText(Canvas canvas, int i, int j, float f, float f1, Paint paint);

    public abstract void drawTextRun(Canvas canvas, int i, int j, int k, int l, float f, float f1, 
            int i1, Paint paint);

    public abstract float getTextRunAdvances(int i, int j, int k, int l, int i1, float af[], int j1, 
            Paint paint);

    public abstract float getTextRunAdvances(int i, int j, int k, int l, int i1, float af[], int j1, 
            Paint paint, int k1);

    public abstract int getTextRunCursor(int i, int j, int k, int l, int i1, Paint paint);

    public abstract int getTextWidths(int i, int j, float af[], Paint paint);

    public abstract float measureText(int i, int j, Paint paint);
}
