// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.os;


// Referenced classes of package android.os:
//            Parcel

public interface Parcelable {
    public static interface ClassLoaderCreator
        extends Creator {

        public abstract Object createFromParcel(Parcel parcel, ClassLoader classloader);
    }

    public static interface Creator {

        public abstract Object createFromParcel(Parcel parcel);

        public abstract Object[] newArray(int i);
    }


    public abstract int describeContents();

    public abstract void writeToParcel(Parcel parcel, int i);

    public static final int CONTENTS_FILE_DESCRIPTOR = 1;
    public static final int PARCELABLE_WRITE_RETURN_VALUE = 1;
}
