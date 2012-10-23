// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Rect
    implements Parcelable {

    public Rect() {
    }

    public Rect(int i, int j, int k, int l) {
        left = i;
        top = j;
        right = k;
        bottom = l;
    }

    public Rect(Rect rect) {
        left = rect.left;
        top = rect.top;
        right = rect.right;
        bottom = rect.bottom;
    }

    public static boolean intersects(Rect rect, Rect rect1) {
        boolean flag;
        if(rect.left < rect1.right && rect1.left < rect.right && rect.top < rect1.bottom && rect1.top < rect.bottom)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static Rect unflattenFromString(String s) {
        Matcher matcher = FLATTENED_PATTERN.matcher(s);
        Rect rect;
        if(!matcher.matches())
            rect = null;
        else
            rect = new Rect(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)));
        return rect;
    }

    public final int centerX() {
        return left + right >> 1;
    }

    public final int centerY() {
        return top + bottom >> 1;
    }

    public boolean contains(int i, int j) {
        boolean flag;
        if(left < right && top < bottom && i >= left && i < right && j >= top && j < bottom)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean contains(int i, int j, int k, int l) {
        boolean flag;
        if(left < right && top < bottom && left <= i && top <= j && right >= k && bottom >= l)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean contains(Rect rect) {
        boolean flag;
        if(left < right && top < bottom && left <= rect.left && top <= rect.top && right >= rect.right && bottom >= rect.bottom)
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
            Rect rect = (Rect)obj;
            if(left != rect.left || top != rect.top || right != rect.right || bottom != rect.bottom)
                flag = false;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public final float exactCenterX() {
        return 0.5F * (float)(left + right);
    }

    public final float exactCenterY() {
        return 0.5F * (float)(top + bottom);
    }

    public String flattenToString() {
        StringBuilder stringbuilder = new StringBuilder(32);
        stringbuilder.append(left);
        stringbuilder.append(' ');
        stringbuilder.append(top);
        stringbuilder.append(' ');
        stringbuilder.append(right);
        stringbuilder.append(' ');
        stringbuilder.append(bottom);
        return stringbuilder.toString();
    }

    public int hashCode() {
        return 31 * (31 * (31 * left + top) + right) + bottom;
    }

    public final int height() {
        return bottom - top;
    }

    public void inset(int i, int j) {
        left = i + left;
        top = j + top;
        right = right - i;
        bottom = bottom - j;
    }

    public boolean intersect(int i, int j, int k, int l) {
        boolean flag;
        if(left < k && i < right && top < l && j < bottom) {
            if(left < i)
                left = i;
            if(top < j)
                top = j;
            if(right > k)
                right = k;
            if(bottom > l)
                bottom = l;
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public boolean intersect(Rect rect) {
        return intersect(rect.left, rect.top, rect.right, rect.bottom);
    }

    public boolean intersects(int i, int j, int k, int l) {
        boolean flag;
        if(left < k && i < right && top < l && j < bottom)
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

    public void offset(int i, int j) {
        left = i + left;
        top = j + top;
        right = i + right;
        bottom = j + bottom;
    }

    public void offsetTo(int i, int j) {
        right = right + (i - left);
        bottom = bottom + (j - top);
        left = i;
        top = j;
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
        left = parcel.readInt();
        top = parcel.readInt();
        right = parcel.readInt();
        bottom = parcel.readInt();
    }

    public void scale(float f) {
        if(f != 1.0F) {
            left = (int)(0.5F + f * (float)left);
            top = (int)(0.5F + f * (float)top);
            right = (int)(0.5F + f * (float)right);
            bottom = (int)(0.5F + f * (float)bottom);
        }
    }

    public void set(int i, int j, int k, int l) {
        left = i;
        top = j;
        right = k;
        bottom = l;
    }

    public void set(Rect rect) {
        left = rect.left;
        top = rect.top;
        right = rect.right;
        bottom = rect.bottom;
    }

    public void setEmpty() {
        bottom = 0;
        top = 0;
        right = 0;
        left = 0;
    }

    public boolean setIntersect(Rect rect, Rect rect1) {
        boolean flag;
        if(rect.left < rect1.right && rect1.left < rect.right && rect.top < rect1.bottom && rect1.top < rect.bottom) {
            left = Math.max(rect.left, rect1.left);
            top = Math.max(rect.top, rect1.top);
            right = Math.min(rect.right, rect1.right);
            bottom = Math.min(rect.bottom, rect1.bottom);
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public void sort() {
        if(left > right) {
            int j = left;
            left = right;
            right = j;
        }
        if(top > bottom) {
            int i = top;
            top = bottom;
            bottom = i;
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
        StringBuilder stringbuilder = new StringBuilder(32);
        stringbuilder.append("Rect(");
        stringbuilder.append(left);
        stringbuilder.append(", ");
        stringbuilder.append(top);
        stringbuilder.append(" - ");
        stringbuilder.append(right);
        stringbuilder.append(", ");
        stringbuilder.append(bottom);
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void union(int i, int j) {
        if(i < left)
            left = i;
        else
        if(i > right)
            right = i;
        if(j < top)
            top = j;
        else
        if(j > bottom)
            bottom = j;
    }

    public void union(int i, int j, int k, int l) {
        if(i < k && j < l)
            if(left < right && top < bottom) {
                if(left > i)
                    left = i;
                if(top > j)
                    top = j;
                if(right < k)
                    right = k;
                if(bottom < l)
                    bottom = l;
            } else {
                left = i;
                top = j;
                right = k;
                bottom = l;
            }
    }

    public void union(Rect rect) {
        union(rect.left, rect.top, rect.right, rect.bottom);
    }

    public final int width() {
        return right - left;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(left);
        parcel.writeInt(top);
        parcel.writeInt(right);
        parcel.writeInt(bottom);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Rect createFromParcel(Parcel parcel) {
            Rect rect = new Rect();
            rect.readFromParcel(parcel);
            return rect;
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public Rect[] newArray(int i) {
            return new Rect[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    private static final Pattern FLATTENED_PATTERN = Pattern.compile("(-?\\d+) (-?\\d+) (-?\\d+) (-?\\d+)");
    public int bottom;
    public int left;
    public int right;
    public int top;

}
