// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package com.android.internal.widget.multiwaveview;

import android.graphics.*;
import android.graphics.drawable.Drawable;
import android.util.FloatMath;
import android.util.Log;
import java.util.ArrayList;

public class PointCloud {
    class Point {

        float radius;
        final PointCloud this$0;
        float x;
        float y;

        public Point(float f, float f1, float f2) {
            this$0 = PointCloud.this;
            super();
            x = f;
            y = f1;
            radius = f2;
        }
    }

    public class GlowManager {

        public float getAlpha() {
            return alpha;
        }

        public float getRadius() {
            return radius;
        }

        public float getX() {
            return x;
        }

        public float getY() {
            return y;
        }

        public void setAlpha(float f) {
            alpha = f;
        }

        public void setRadius(float f) {
            radius = f;
        }

        public void setX(float f) {
            x = f;
        }

        public void setY(float f) {
            y = f;
        }

        private float alpha;
        private float radius;
        final PointCloud this$0;
        private float x;
        private float y;





        public GlowManager() {
            this$0 = PointCloud.this;
            super();
            radius = 0.0F;
            alpha = 0.0F;
        }
    }

    public class WaveManager {

        public float getAlpha() {
            return alpha;
        }

        public float getRadius() {
            return radius;
        }

        public void setAlpha(float f) {
            alpha = f;
        }

        public void setRadius(float f) {
            radius = f;
        }

        private float alpha;
        private float radius;
        final PointCloud this$0;
        private float width;




        public WaveManager() {
            this$0 = PointCloud.this;
            super();
            radius = 50F;
            width = 200F;
            alpha = 0.0F;
        }
    }


    public PointCloud(Drawable drawable) {
        mPointCloud = new ArrayList();
        mScale = 1.0F;
        waveManager = new WaveManager();
        glowManager = new GlowManager();
        mPaint = new Paint();
        mPaint.setFilterBitmap(true);
        mPaint.setColor(Color.rgb(255, 255, 255));
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mDrawable = drawable;
        if(mDrawable != null)
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    }

    private static float hypot(float f, float f1) {
        return FloatMath.sqrt(f * f + f1 * f1);
    }

    private float interp(float f, float f1, float f2) {
        return f + f2 * (f1 - f);
    }

    private static float max(float f, float f1) {
        if(f <= f1)
            f = f1;
        return f;
    }

    public void draw(Canvas canvas) {
        ArrayList arraylist = mPointCloud;
        canvas.save(1);
        canvas.scale(mScale, mScale, mCenterX, mCenterY);
        int i = 0;
        while(i < arraylist.size())  {
            Point point = (Point)arraylist.get(i);
            float f = interp(4F, 2.0F, point.radius / mOuterRadius);
            float f1 = point.x + mCenterX;
            float f2 = point.y + mCenterY;
            int j = getAlphaForPoint(point);
            if(j != 0)
                if(mDrawable != null) {
                    canvas.save(1);
                    float f3 = 0.5F * (float)mDrawable.getIntrinsicWidth();
                    float f4 = 0.5F * (float)mDrawable.getIntrinsicHeight();
                    float f5 = f / 4F;
                    canvas.scale(f5, f5, f1, f2);
                    canvas.translate(f1 - f3, f2 - f4);
                    mDrawable.setAlpha(j);
                    mDrawable.draw(canvas);
                    canvas.restore();
                } else {
                    mPaint.setAlpha(j);
                    canvas.drawCircle(f1, f2, f, mPaint);
                }
            i++;
        }
        canvas.restore();
    }

    public int getAlphaForPoint(Point point) {
        float f = hypot(glowManager.x - point.x, glowManager.y - point.y);
        float f1 = 0.0F;
        if(f < glowManager.radius) {
            float f5 = FloatMath.cos((0.7853982F * f) / glowManager.radius);
            f1 = glowManager.alpha * max(0.0F, (float)Math.pow(f5, 10D));
        }
        float f2 = hypot(point.x, point.y) - waveManager.radius;
        float f3 = 0.0F;
        if(f2 < 0.5F * waveManager.width && f2 < 0.0F) {
            float f4 = FloatMath.cos((0.7853982F * f2) / waveManager.width);
            f3 = waveManager.alpha * max(0.0F, (float)Math.pow(f4, 20D));
        }
        return (int)(255F * max(f1, f3));
    }

    public float getScale() {
        return mScale;
    }

    public void makePointCloud(float f, float f1) {
        if(f == 0.0F) {
            Log.w("PointCloud", "Must specify an inner radius");
        } else {
            mOuterRadius = f1;
            mPointCloud.clear();
            float f2 = f1 - f;
            float f3 = (6.283185F * f) / 8F;
            int i = Math.round(f2 / f3);
            float f4 = f2 / (float)i;
            float f5 = f;
            int j = 0;
            while(j <= i)  {
                int k = (int)((6.283185F * f5) / f3);
                float f6 = 1.570796F;
                float f7 = 6.283185F / (float)k;
                for(int l = 0; l < k; l++) {
                    float f8 = f5 * FloatMath.cos(f6);
                    float f9 = f5 * FloatMath.sin(f6);
                    f6 += f7;
                    ArrayList arraylist = mPointCloud;
                    Point point = new Point(f8, f9, f5);
                    arraylist.add(point);
                }

                j++;
                f5 += f4;
            }
        }
    }

    public void setCenter(float f, float f1) {
        mCenterX = f;
        mCenterY = f1;
    }

    public void setScale(float f) {
        mScale = f;
    }

    private static final int INNER_POINTS = 8;
    private static final float MAX_POINT_SIZE = 4F;
    private static final float MIN_POINT_SIZE = 2F;
    private static final float PI = 3.141593F;
    private static final String TAG = "PointCloud";
    GlowManager glowManager;
    private float mCenterX;
    private float mCenterY;
    private Drawable mDrawable;
    private float mOuterRadius;
    private Paint mPaint;
    private ArrayList mPointCloud;
    private float mScale;
    WaveManager waveManager;
}
