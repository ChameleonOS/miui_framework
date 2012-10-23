// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.graphics;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.FloatMath;

// Referenced classes of package android.graphics:
//            Point

public class PointF
    implements Parcelable {

    public PointF() {
    }

    public PointF(float f, float f1) {
        x = f;
        y = f1;
    }

    public PointF(Point point) {
        x = point.x;
        y = point.y;
    }

    public static float length(float f, float f1) {
        return FloatMath.sqrt(f * f + f1 * f1);
    }

    public int describeContents() {
        return 0;
    }

    public final boolean equals(float f, float f1) {
        boolean flag;
        if(x == f && y == f1)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public final float length() {
        return length(x, y);
    }

    public final void negate() {
        x = -x;
        y = -y;
    }

    public final void offset(float f, float f1) {
        x = f + x;
        y = f1 + y;
    }

    public void readFromParcel(Parcel parcel) {
        x = parcel.readFloat();
        y = parcel.readFloat();
    }

    public final void set(float f, float f1) {
        x = f;
        y = f1;
    }

    public final void set(PointF pointf) {
        x = pointf.x;
        y = pointf.y;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(x);
        parcel.writeFloat(y);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public PointF createFromParcel(Parcel parcel) {
            PointF pointf = new PointF();
            pointf.readFromParcel(parcel);
            return pointf;
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public PointF[] newArray(int i) {
            return new PointF[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public float x;
    public float y;

}
