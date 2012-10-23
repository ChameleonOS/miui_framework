// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.view;

import android.content.Context;
import android.content.res.*;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.android.internal.util.XmlUtils;

public final class PointerIcon
    implements Parcelable {

    private PointerIcon(int i) {
        mStyle = i;
    }


    public static PointerIcon createCustomIcon(Bitmap bitmap, float f, float f1) {
        if(bitmap == null) {
            throw new IllegalArgumentException("bitmap must not be null");
        } else {
            validateHotSpot(bitmap, f, f1);
            PointerIcon pointericon = new PointerIcon(-1);
            pointericon.mBitmap = bitmap;
            pointericon.mHotSpotX = f;
            pointericon.mHotSpotY = f1;
            return pointericon;
        }
    }

    public static PointerIcon getDefaultIcon(Context context) {
        return getSystemIcon(context, 1000);
    }

    public static PointerIcon getNullIcon() {
        return gNullIcon;
    }

    public static PointerIcon getSystemIcon(Context context, int i) {
        if(context == null)
            throw new IllegalArgumentException("context must not be null");
        PointerIcon pointericon1;
        if(i == 0) {
            pointericon1 = gNullIcon;
        } else {
            int j = getSystemIconStyleIndex(i);
            if(j == 0)
                j = getSystemIconStyleIndex(1000);
            TypedArray typedarray = context.obtainStyledAttributes(null, com.android.internal.R.styleable.Pointer, 0x10103db, 0);
            int k = typedarray.getResourceId(j, -1);
            typedarray.recycle();
            if(k == -1) {
                Log.w("PointerIcon", (new StringBuilder()).append("Missing theme resources for pointer icon style ").append(i).toString());
                if(i == 1000)
                    pointericon1 = gNullIcon;
                else
                    pointericon1 = getSystemIcon(context, 1000);
            } else {
                PointerIcon pointericon = new PointerIcon(i);
                if((0xff000000 & k) == 0x1000000)
                    pointericon.mSystemIconResourceId = k;
                else
                    pointericon.loadResource(context.getResources(), k);
                pointericon1 = pointericon;
            }
        }
        return pointericon1;
    }

    private static int getSystemIconStyleIndex(int i) {
        int j = 0;
        i;
        JVM INSTR lookupswitch 4: default 44
    //                   1000: 44
    //                   2000: 46
    //                   2001: 51
    //                   2002: 56;
           goto _L1 _L1 _L2 _L3 _L4
_L1:
        return j;
_L2:
        j = 1;
        continue; /* Loop/switch isn't completed */
_L3:
        j = 2;
        continue; /* Loop/switch isn't completed */
_L4:
        j = 3;
        if(true) goto _L1; else goto _L5
_L5:
    }

    public static PointerIcon loadCustomIcon(Resources resources, int i) {
        if(resources == null) {
            throw new IllegalArgumentException("resources must not be null");
        } else {
            PointerIcon pointericon = new PointerIcon(-1);
            pointericon.loadResource(resources, i);
            return pointericon;
        }
    }

    private void loadResource(Resources resources, int i) {
        XmlResourceParser xmlresourceparser = resources.getXml(i);
        int j;
        float f;
        float f1;
        XmlUtils.beginDocument(xmlresourceparser, "pointer-icon");
        TypedArray typedarray = resources.obtainAttributes(xmlresourceparser, com.android.internal.R.styleable.PointerIcon);
        j = typedarray.getResourceId(0, 0);
        f = typedarray.getFloat(1, 0.0F);
        f1 = typedarray.getFloat(2, 0.0F);
        typedarray.recycle();
        xmlresourceparser.close();
        if(j == 0)
            throw new IllegalArgumentException("<pointer-icon> is missing bitmap attribute.");
        break MISSING_BLOCK_LABEL_100;
        Exception exception1;
        exception1;
        throw new IllegalArgumentException("Exception parsing pointer icon resource.", exception1);
        Exception exception;
        exception;
        xmlresourceparser.close();
        throw exception;
        android.graphics.drawable.Drawable drawable = resources.getDrawable(j);
        if(!(drawable instanceof BitmapDrawable)) {
            throw new IllegalArgumentException("<pointer-icon> bitmap attribute must refer to a bitmap drawable.");
        } else {
            mBitmap = ((BitmapDrawable)drawable).getBitmap();
            mHotSpotX = f;
            mHotSpotY = f1;
            return;
        }
    }

    private void throwIfIconIsNotLoaded() {
        if(!isLoaded())
            throw new IllegalStateException("The icon is not loaded.");
        else
            return;
    }

    private static void validateHotSpot(Bitmap bitmap, float f, float f1) {
        if(f < 0.0F || f >= (float)bitmap.getWidth())
            throw new IllegalArgumentException("x hotspot lies outside of the bitmap area");
        if(f1 < 0.0F || f1 >= (float)bitmap.getHeight())
            throw new IllegalArgumentException("y hotspot lies outside of the bitmap area");
        else
            return;
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
        if(obj == null || !(obj instanceof PointerIcon)) {
            flag = false;
        } else {
            PointerIcon pointericon = (PointerIcon)obj;
            if(mStyle != pointericon.mStyle || mSystemIconResourceId != pointericon.mSystemIconResourceId)
                flag = false;
            else
            if(mSystemIconResourceId == 0 && (mBitmap != pointericon.mBitmap || mHotSpotX != pointericon.mHotSpotX || mHotSpotY != pointericon.mHotSpotY))
                flag = false;
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    public Bitmap getBitmap() {
        throwIfIconIsNotLoaded();
        return mBitmap;
    }

    public float getHotSpotX() {
        throwIfIconIsNotLoaded();
        return mHotSpotX;
    }

    public float getHotSpotY() {
        throwIfIconIsNotLoaded();
        return mHotSpotY;
    }

    public int getStyle() {
        return mStyle;
    }

    public boolean isLoaded() {
        boolean flag;
        if(mBitmap != null || mStyle == 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean isNullIcon() {
        boolean flag;
        if(mStyle == 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public PointerIcon load(Context context) {
        if(context == null)
            throw new IllegalArgumentException("context must not be null");
        PointerIcon pointericon;
        if(mSystemIconResourceId == 0 || mBitmap != null) {
            pointericon = this;
        } else {
            pointericon = new PointerIcon(mStyle);
            pointericon.mSystemIconResourceId = mSystemIconResourceId;
            pointericon.loadResource(context.getResources(), mSystemIconResourceId);
        }
        return pointericon;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mStyle);
        if(mStyle != 0) {
            parcel.writeInt(mSystemIconResourceId);
            if(mSystemIconResourceId == 0) {
                mBitmap.writeToParcel(parcel, i);
                parcel.writeFloat(mHotSpotX);
                parcel.writeFloat(mHotSpotY);
            }
        }
    }

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public PointerIcon createFromParcel(Parcel parcel) {
            int i = parcel.readInt();
            PointerIcon pointericon;
            if(i == 0) {
                pointericon = PointerIcon.getNullIcon();
            } else {
                int j = parcel.readInt();
                if(j != 0) {
                    pointericon = new PointerIcon(i);
                    pointericon.mSystemIconResourceId = j;
                } else {
                    pointericon = PointerIcon.createCustomIcon((Bitmap)Bitmap.CREATOR.createFromParcel(parcel), parcel.readFloat(), parcel.readFloat());
                }
            }
            return pointericon;
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public PointerIcon[] newArray(int i) {
            return new PointerIcon[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final int STYLE_ARROW = 1000;
    public static final int STYLE_CUSTOM = -1;
    private static final int STYLE_DEFAULT = 1000;
    public static final int STYLE_NULL = 0;
    private static final int STYLE_OEM_FIRST = 10000;
    public static final int STYLE_SPOT_ANCHOR = 2002;
    public static final int STYLE_SPOT_HOVER = 2000;
    public static final int STYLE_SPOT_TOUCH = 2001;
    private static final String TAG = "PointerIcon";
    private static final PointerIcon gNullIcon = new PointerIcon(0);
    private Bitmap mBitmap;
    private float mHotSpotX;
    private float mHotSpotY;
    private final int mStyle;
    private int mSystemIconResourceId;



/*
    static int access$102(PointerIcon pointericon, int i) {
        pointericon.mSystemIconResourceId = i;
        return i;
    }

*/
}
