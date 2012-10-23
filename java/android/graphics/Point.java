// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;

import android.os.Parcel;
import android.os.Parcelable;

public class Point
    implements Parcelable {

    public Point() {
    }

    public Point(int i, int j) {
        x = i;
        y = j;
    }

    public Point(Point point) {
        x = point.x;
        y = point.y;
    }

    public int describeContents() {
        return 0;
    }

    public final boolean equals(int i, int j) {
        boolean flag;
        if(x == i && y == j)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean equals(Object obj) {
        boolean flag = false;
        if(obj instanceof Point) {
            Point point = (Point)obj;
            if(x == point.x && y == point.y)
                flag = true;
        }
        return flag;
    }

    public int hashCode() {
        return 32713 * x + y;
    }

    public final void negate() {
        x = -x;
        y = -y;
    }

    public final void offset(int i, int j) {
        x = i + x;
        y = j + y;
    }

    public void readFromParcel(Parcel parcel) {
        x = parcel.readInt();
        y = parcel.readInt();
    }

    public void set(int i, int j) {
        x = i;
        y = j;
    }

    public String toString() {
        return (new StringBuilder()).append("Point(").append(x).append(", ").append(y).append(")").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(x);
        parcel.writeInt(y);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Point createFromParcel(Parcel parcel) {
            Point point = new Point();
            point.readFromParcel(parcel);
            return point;
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public Point[] newArray(int i) {
            return new Point[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public int x;
    public int y;

}
