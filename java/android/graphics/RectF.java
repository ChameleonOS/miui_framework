// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.FloatMath;
import com.android.internal.util.FastMath;
import java.io.PrintWriter;

// Referenced classes of package android.graphics:
//            Rect

public class RectF
    implements Parcelable {

    public RectF() {
    }

    public RectF(float f, float f1, float f2, float f3) {
        left = f;
        top = f1;
        right = f2;
        bottom = f3;
    }

    public RectF(Rect rect) {
        left = rect.left;
        top = rect.top;
        right = rect.right;
        bottom = rect.bottom;
    }

    public RectF(RectF rectf) {
        left = rectf.left;
        top = rectf.top;
        right = rectf.right;
        bottom = rectf.bottom;
    }

    public static boolean intersects(RectF rectf, RectF rectf1) {
        boolean flag;
        if(rectf.left < rectf1.right && rectf1.left < rectf.right && rectf.top < rectf1.bottom && rectf1.top < rectf.bottom)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public final float centerX() {
        return 0.5F * (left + right);
    }

    public final float centerY() {
        return 0.5F * (top + bottom);
    }

    public boolean contains(float f, float f1) {
        boolean flag;
        if(left < right && top < bottom && f >= left && f < right && f1 >= top && f1 < bottom)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean contains(float f, float f1, float f2, float f3) {
        boolean flag;
        if(left < right && top < bottom && left <= f && top <= f1 && right >= f2 && bottom >= f3)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean contains(RectF rectf) {
        boolean flag;
        if(left < right && top < bottom && left <= rectf.left && top <= rectf.top && right >= rectf.right && bottom >= rectf.bottom)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean flag = true;
        if(this != obj) goto _L2; else goto _L1
_L1:
        return flag;
_L2:
        if(obj == null || getClass() != obj.getClass()) {
            flag = false;
        } else {
            RectF rectf = (RectF)obj;
            if(left != rectf.left || top != rectf.top || right != rectf.right || bottom != rectf.bottom)
                flag = false;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public int hashCode() {
        int i = 0;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        if(left != 0.0F)
            j = Float.floatToIntBits(left);
        else
            j = 0;
        k = j * 31;
        if(top != 0.0F)
            l = Float.floatToIntBits(top);
        else
            l = 0;
        i1 = 31 * (k + l);
        if(right != 0.0F)
            j1 = Float.floatToIntBits(right);
        else
            j1 = 0;
        k1 = 31 * (i1 + j1);
        if(bottom != 0.0F)
            i = Float.floatToIntBits(bottom);
        return k1 + i;
    }

    public final float height() {
        return bottom - top;
    }

    public void inset(float f, float f1) {
        left = f + left;
        top = f1 + top;
        right = right - f;
        bottom = bottom - f1;
    }

    public boolean intersect(float f, float f1, float f2, float f3) {
        boolean flag;
        if(left < f2 && f < right && top < f3 && f1 < bottom) {
            if(left < f)
                left = f;
            if(top < f1)
                top = f1;
            if(right > f2)
                right = f2;
            if(bottom > f3)
                bottom = f3;
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public boolean intersect(RectF rectf) {
        return intersect(rectf.left, rectf.top, rectf.right, rectf.bottom);
    }

    public boolean intersects(float f, float f1, float f2, float f3) {
        boolean flag;
        if(left < f2 && f < right && top < f3 && f1 < bottom)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public final boolean isEmpty() {
        boolean flag;
        if(left >= right || top >= bottom)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void offset(float f, float f1) {
        left = f + left;
        top = f1 + top;
        right = f + right;
        bottom = f1 + bottom;
    }

    public void offsetTo(float f, float f1) {
        right = right + (f - left);
        bottom = bottom + (f1 - top);
        left = f;
        top = f1;
    }

    public void printShortString(PrintWriter printwriter) {
        printwriter.print('[');
        printwriter.print(left);
        printwriter.print(',');
        printwriter.print(top);
        printwriter.print("][");
        printwriter.print(right);
        printwriter.print(',');
        printwriter.print(bottom);
        printwriter.print(']');
    }

    public void readFromParcel(Parcel parcel) {
        left = parcel.readFloat();
        top = parcel.readFloat();
        right = parcel.readFloat();
        bottom = parcel.readFloat();
    }

    public void round(Rect rect) {
        rect.set(FastMath.round(left), FastMath.round(top), FastMath.round(right), FastMath.round(bottom));
    }

    public void roundOut(Rect rect) {
        rect.set((int)FloatMath.floor(left), (int)FloatMath.floor(top), (int)FloatMath.ceil(right), (int)FloatMath.ceil(bottom));
    }

    public void set(float f, float f1, float f2, float f3) {
        left = f;
        top = f1;
        right = f2;
        bottom = f3;
    }

    public void set(Rect rect) {
        left = rect.left;
        top = rect.top;
        right = rect.right;
        bottom = rect.bottom;
    }

    public void set(RectF rectf) {
        left = rectf.left;
        top = rectf.top;
        right = rectf.right;
        bottom = rectf.bottom;
    }

    public void setEmpty() {
        bottom = 0.0F;
        top = 0.0F;
        right = 0.0F;
        left = 0.0F;
    }

    public boolean setIntersect(RectF rectf, RectF rectf1) {
        boolean flag;
        if(rectf.left < rectf1.right && rectf1.left < rectf.right && rectf.top < rectf1.bottom && rectf1.top < rectf.bottom) {
            left = Math.max(rectf.left, rectf1.left);
            top = Math.max(rectf.top, rectf1.top);
            right = Math.min(rectf.right, rectf1.right);
            bottom = Math.min(rectf.bottom, rectf1.bottom);
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public void sort() {
        if(left > right) {
            float f1 = left;
            left = right;
            right = f1;
        }
        if(top > bottom) {
            float f = top;
            top = bottom;
            bottom = f;
        }
    }

    public String toShortString() {
        return toShortString(new StringBuilder(32));
    }

    public String toShortString(StringBuilder stringbuilder) {
        stringbuilder.setLength(0);
        stringbuilder.append('[');
        stringbuilder.append(left);
        stringbuilder.append(',');
        stringbuilder.append(top);
        stringbuilder.append("][");
        stringbuilder.append(right);
        stringbuilder.append(',');
        stringbuilder.append(bottom);
        stringbuilder.append(']');
        return stringbuilder.toString();
    }

    public String toString() {
        return (new StringBuilder()).append("RectF(").append(left).append(", ").append(top).append(", ").append(right).append(", ").append(bottom).append(")").toString();
    }

    public void union(float f, float f1) {
        if(f < left)
            left = f;
        else
        if(f > right)
            right = f;
        if(f1 < top)
            top = f1;
        else
        if(f1 > bottom)
            bottom = f1;
    }

    public void union(float f, float f1, float f2, float f3) {
        if(f < f2 && f1 < f3)
            if(left < right && top < bottom) {
                if(left > f)
                    left = f;
                if(top > f1)
                    top = f1;
                if(right < f2)
                    right = f2;
                if(bottom < f3)
                    bottom = f3;
            } else {
                left = f;
                top = f1;
                right = f2;
                bottom = f3;
            }
    }

    public void union(RectF rectf) {
        union(rectf.left, rectf.top, rectf.right, rectf.bottom);
    }

    public final float width() {
        return right - left;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(left);
        parcel.writeFloat(top);
        parcel.writeFloat(right);
        parcel.writeFloat(bottom);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public RectF createFromParcel(Parcel parcel) {
            RectF rectf = new RectF();
            rectf.readFromParcel(parcel);
            return rectf;
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public RectF[] newArray(int i) {
            return new RectF[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public float bottom;
    public float left;
    public float right;
    public float top;

}
