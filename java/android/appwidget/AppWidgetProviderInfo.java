// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.appwidget;

import android.content.ComponentName;
import android.os.Parcel;
import android.os.Parcelable;

public class AppWidgetProviderInfo
    implements Parcelable {

    public AppWidgetProviderInfo() {
    }

    public AppWidgetProviderInfo(Parcel parcel) {
        if(parcel.readInt() != 0)
            provider = new ComponentName(parcel);
        minWidth = parcel.readInt();
        minHeight = parcel.readInt();
        minResizeWidth = parcel.readInt();
        minResizeHeight = parcel.readInt();
        updatePeriodMillis = parcel.readInt();
        initialLayout = parcel.readInt();
        if(parcel.readInt() != 0)
            configure = new ComponentName(parcel);
        label = parcel.readString();
        icon = parcel.readInt();
        previewImage = parcel.readInt();
        autoAdvanceViewId = parcel.readInt();
        resizeMode = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return (new StringBuilder()).append("AppWidgetProviderInfo(provider=").append(provider).append(")").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        if(provider != null) {
            parcel.writeInt(1);
            provider.writeToParcel(parcel, i);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(minWidth);
        parcel.writeInt(minHeight);
        parcel.writeInt(minResizeWidth);
        parcel.writeInt(minResizeHeight);
        parcel.writeInt(updatePeriodMillis);
        parcel.writeInt(initialLayout);
        if(configure != null) {
            parcel.writeInt(1);
            configure.writeToParcel(parcel, i);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(label);
        parcel.writeInt(icon);
        parcel.writeInt(previewImage);
        parcel.writeInt(autoAdvanceViewId);
        parcel.writeInt(resizeMode);
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public AppWidgetProviderInfo createFromParcel(Parcel parcel) {
            return new AppWidgetProviderInfo(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public AppWidgetProviderInfo[] newArray(int i) {
            return new AppWidgetProviderInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int RESIZE_BOTH = 3;
    public static final int RESIZE_HORIZONTAL = 1;
    public static final int RESIZE_NONE = 0;
    public static final int RESIZE_VERTICAL = 2;
    public int autoAdvanceViewId;
    public ComponentName configure;
    public int icon;
    public int initialLayout;
    public String label;
    public int minHeight;
    public int minResizeHeight;
    public int minResizeWidth;
    public int minWidth;
    public int previewImage;
    public ComponentName provider;
    public int resizeMode;
    public int updatePeriodMillis;

}
