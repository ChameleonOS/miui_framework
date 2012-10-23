// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.res;

import android.content.pm.ApplicationInfo;
import android.graphics.*;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.MotionEvent;

// Referenced classes of package android.content.res:
//            Configuration

public class CompatibilityInfo
    implements Parcelable {
    public class Translator {

        public Rect getTranslatedContentInsets(Rect rect) {
            if(mContentInsetsBuffer == null)
                mContentInsetsBuffer = new Rect();
            mContentInsetsBuffer.set(rect);
            translateRectInAppWindowToScreen(mContentInsetsBuffer);
            return mContentInsetsBuffer;
        }

        public Region getTranslatedTouchableArea(Region region) {
            if(mTouchableAreaBuffer == null)
                mTouchableAreaBuffer = new Region();
            mTouchableAreaBuffer.set(region);
            mTouchableAreaBuffer.scale(applicationScale);
            return mTouchableAreaBuffer;
        }

        public Rect getTranslatedVisibleInsets(Rect rect) {
            if(mVisibleInsetsBuffer == null)
                mVisibleInsetsBuffer = new Rect();
            mVisibleInsetsBuffer.set(rect);
            translateRectInAppWindowToScreen(mVisibleInsetsBuffer);
            return mVisibleInsetsBuffer;
        }

        public void translateCanvas(Canvas canvas) {
            if(applicationScale == 1.5F)
                canvas.translate(0.002614379F, 0.002614379F);
            canvas.scale(applicationScale, applicationScale);
        }

        public void translateEventInScreenToAppWindow(MotionEvent motionevent) {
            motionevent.scale(applicationInvertedScale);
        }

        public void translateLayoutParamsInAppWindowToScreen(android.view.WindowManager.LayoutParams layoutparams) {
            layoutparams.scale(applicationScale);
        }

        public void translatePointInScreenToAppWindow(PointF pointf) {
            float f = applicationInvertedScale;
            if(f != 1.0F) {
                pointf.x = f * pointf.x;
                pointf.y = f * pointf.y;
            }
        }

        public void translateRectInAppWindowToScreen(Rect rect) {
            rect.scale(applicationScale);
        }

        public void translateRectInScreenToAppWinFrame(Rect rect) {
            rect.scale(applicationInvertedScale);
        }

        public void translateRectInScreenToAppWindow(Rect rect) {
            rect.scale(applicationInvertedScale);
        }

        public void translateRegionInWindowToScreen(Region region) {
            region.scale(applicationScale);
        }

        public void translateWindowLayout(android.view.WindowManager.LayoutParams layoutparams) {
            layoutparams.scale(applicationScale);
        }

        public final float applicationInvertedScale;
        public final float applicationScale;
        private Rect mContentInsetsBuffer;
        private Region mTouchableAreaBuffer;
        private Rect mVisibleInsetsBuffer;
        final CompatibilityInfo this$0;

        Translator() {
            this(CompatibilityInfo.this.applicationScale, CompatibilityInfo.this.applicationInvertedScale);
        }

        Translator(float f, float f1) {
            this$0 = CompatibilityInfo.this;
            super();
            mContentInsetsBuffer = null;
            mVisibleInsetsBuffer = null;
            mTouchableAreaBuffer = null;
            applicationScale = f;
            applicationInvertedScale = f1;
        }
    }


    private CompatibilityInfo() {
        this(4, DisplayMetrics.DENSITY_DEVICE, 1.0F, 1.0F);
    }

    private CompatibilityInfo(int i, int j, float f, float f1) {
        mCompatibilityFlags = i;
        applicationDensity = j;
        applicationScale = f;
        applicationInvertedScale = f1;
    }

    public CompatibilityInfo(ApplicationInfo applicationinfo, int i, int j, boolean flag) {
        int k;
        k = 0;
        if(applicationinfo.requiresSmallestWidthDp == 0 && applicationinfo.compatibleWidthLimitDp == 0 && applicationinfo.largestWidthLimitDp == 0) goto _L2; else goto _L1
_L1:
        int l;
        int i1;
        int j1;
        if(applicationinfo.requiresSmallestWidthDp != 0)
            l = applicationinfo.requiresSmallestWidthDp;
        else
            l = applicationinfo.compatibleWidthLimitDp;
        if(l == 0)
            l = applicationinfo.largestWidthLimitDp;
        if(applicationinfo.compatibleWidthLimitDp != 0)
            i1 = applicationinfo.compatibleWidthLimitDp;
        else
            i1 = l;
        if(i1 < l)
            i1 = l;
        j1 = applicationinfo.largestWidthLimitDp;
        if(l > 320)
            k = 0 | 4;
        else
        if(j1 != 0 && j > j1)
            k = 0 | 0xa;
        else
        if(i1 >= j)
            k = 0 | 4;
        else
        if(flag)
            k = 0 | 8;
        applicationDensity = DisplayMetrics.DENSITY_DEVICE;
        applicationScale = 1.0F;
        applicationInvertedScale = 1.0F;
_L6:
        mCompatibilityFlags = k;
        return;
_L2:
        int k1;
        boolean flag1;
        k1 = 0;
        flag1 = false;
        if((0x800 & applicationinfo.flags) != 0) {
            k1 = 0 | 8;
            flag1 = true;
            if(!flag)
                k1 |= 0x22;
        }
        if((0x80000 & applicationinfo.flags) != 0) {
            flag1 = true;
            if(!flag)
                k1 |= 0x22;
        }
        if((0x1000 & applicationinfo.flags) != 0) {
            flag1 = true;
            k1 |= 2;
        }
        if(flag)
            k1 &= -3;
        k = 0 | 8;
        i & 0xf;
        JVM INSTR tableswitch 3 4: default 312
    //                   3 398
    //                   4 364;
           goto _L3 _L4 _L5
_L3:
        if((0x10000000 & i) != 0) {
            if((k1 & 2) != 0)
                k &= -9;
            else
            if(!flag1)
                k |= 2;
        } else {
            k = 4 | k & -9;
        }
        if((0x2000 & applicationinfo.flags) != 0) {
            applicationDensity = DisplayMetrics.DENSITY_DEVICE;
            applicationScale = 1.0F;
            applicationInvertedScale = 1.0F;
        } else {
            applicationDensity = 160;
            applicationScale = (float)DisplayMetrics.DENSITY_DEVICE / 160F;
            applicationInvertedScale = 1.0F / applicationScale;
            k |= 1;
        }
        if(true) goto _L6; else goto _L5
_L5:
        if((k1 & 0x20) != 0)
            k &= -9;
        if((0x80000 & applicationinfo.flags) != 0)
            k |= 4;
          goto _L3
_L4:
        if((k1 & 8) != 0)
            k &= -9;
        if((0x800 & applicationinfo.flags) != 0)
            k |= 4;
          goto _L3
    }


    private CompatibilityInfo(Parcel parcel) {
        mCompatibilityFlags = parcel.readInt();
        applicationDensity = parcel.readInt();
        applicationScale = parcel.readFloat();
        applicationInvertedScale = parcel.readFloat();
    }


    public static float computeCompatibleScaling(DisplayMetrics displaymetrics, DisplayMetrics displaymetrics1) {
        int i = displaymetrics.noncompatWidthPixels;
        int j = displaymetrics.noncompatHeightPixels;
        int k;
        int l;
        int i1;
        float f;
        int j1;
        int k1;
        int l1;
        float f1;
        float f2;
        float f3;
        if(i < j) {
            k = i;
            l = j;
        } else {
            k = j;
            l = i;
        }
        i1 = (int)(0.5F + 320F * displaymetrics.density);
        f = (float)l / (float)k;
        if(f > 1.779167F)
            f = 1.779167F;
        j1 = (int)(0.5F + f * (float)i1);
        if(i < j) {
            k1 = i1;
            l1 = j1;
        } else {
            k1 = j1;
            l1 = i1;
        }
        f1 = (float)i / (float)k1;
        f2 = (float)j / (float)l1;
        if(f1 < f2)
            f3 = f1;
        else
            f3 = f2;
        if(f3 < 1.0F)
            f3 = 1.0F;
        if(displaymetrics1 != null) {
            displaymetrics1.widthPixels = k1;
            displaymetrics1.heightPixels = l1;
        }
        return f3;
    }

    public boolean alwaysSupportsScreen() {
        boolean flag;
        if((4 & mCompatibilityFlags) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void applyToConfiguration(Configuration configuration) {
        if(!supportsScreen()) {
            configuration.screenLayout = 2 | 0xfffffff0 & configuration.screenLayout;
            configuration.screenWidthDp = configuration.compatScreenWidthDp;
            configuration.screenHeightDp = configuration.compatScreenHeightDp;
            configuration.smallestScreenWidthDp = configuration.compatSmallestScreenWidthDp;
        }
    }

    public void applyToDisplayMetrics(DisplayMetrics displaymetrics) {
        if(!supportsScreen()) {
            computeCompatibleScaling(displaymetrics, displaymetrics);
        } else {
            displaymetrics.widthPixels = displaymetrics.noncompatWidthPixels;
            displaymetrics.heightPixels = displaymetrics.noncompatHeightPixels;
        }
        if(isScalingRequired()) {
            float f = applicationInvertedScale;
            displaymetrics.density = f * displaymetrics.noncompatDensity;
            displaymetrics.densityDpi = (int)(0.5F + 160F * displaymetrics.density);
            displaymetrics.scaledDensity = f * displaymetrics.noncompatScaledDensity;
            displaymetrics.xdpi = f * displaymetrics.noncompatXdpi;
            displaymetrics.ydpi = f * displaymetrics.noncompatYdpi;
            displaymetrics.widthPixels = (int)(0.5F + f * (float)displaymetrics.widthPixels);
            displaymetrics.heightPixels = (int)(0.5F + f * (float)displaymetrics.heightPixels);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean flag = false;
        float f;
        float f1;
        CompatibilityInfo compatibilityinfo = (CompatibilityInfo)obj;
        if(mCompatibilityFlags != compatibilityinfo.mCompatibilityFlags || applicationDensity != compatibilityinfo.applicationDensity || applicationScale != compatibilityinfo.applicationScale)
            break MISSING_BLOCK_LABEL_75;
        f = applicationInvertedScale;
        f1 = compatibilityinfo.applicationInvertedScale;
        if(f == f1)
            flag = true;
        break MISSING_BLOCK_LABEL_75;
        ClassCastException classcastexception;
        classcastexception;
        return flag;
    }

    public Translator getTranslator() {
        Translator translator;
        if(isScalingRequired())
            translator = new Translator();
        else
            translator = null;
        return translator;
    }

    public int hashCode() {
        return 31 * (31 * (31 * (527 + mCompatibilityFlags) + applicationDensity) + Float.floatToIntBits(applicationScale)) + Float.floatToIntBits(applicationInvertedScale);
    }

    public boolean isScalingRequired() {
        boolean flag;
        if((1 & mCompatibilityFlags) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean neverSupportsScreen() {
        boolean flag;
        if((2 & mCompatibilityFlags) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean supportsScreen() {
        boolean flag;
        if((8 & mCompatibilityFlags) == 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder(128);
        stringbuilder.append("{");
        stringbuilder.append(applicationDensity);
        stringbuilder.append("dpi");
        if(isScalingRequired()) {
            stringbuilder.append(" ");
            stringbuilder.append(applicationScale);
            stringbuilder.append("x");
        }
        if(!supportsScreen())
            stringbuilder.append(" resizing");
        if(neverSupportsScreen())
            stringbuilder.append(" never-compat");
        if(alwaysSupportsScreen())
            stringbuilder.append(" always-compat");
        stringbuilder.append("}");
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mCompatibilityFlags);
        parcel.writeInt(applicationDensity);
        parcel.writeFloat(applicationScale);
        parcel.writeFloat(applicationInvertedScale);
    }

    private static final int ALWAYS_NEEDS_COMPAT = 2;
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public CompatibilityInfo createFromParcel(Parcel parcel) {
            return new CompatibilityInfo(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        public CompatibilityInfo[] newArray(int i) {
            return new CompatibilityInfo[i];
        }

        public volatile Object[] newArray(int i) {
            return newArray(i);
        }

    };
    public static final CompatibilityInfo DEFAULT_COMPATIBILITY_INFO = new CompatibilityInfo() {

    };
    public static final int DEFAULT_NORMAL_SHORT_DIMENSION = 320;
    public static final float MAXIMUM_ASPECT_RATIO = 1.779167F;
    private static final int NEEDS_SCREEN_COMPAT = 8;
    private static final int NEVER_NEEDS_COMPAT = 4;
    private static final int SCALING_REQUIRED = 1;
    public final int applicationDensity;
    public final float applicationInvertedScale;
    public final float applicationScale;
    private final int mCompatibilityFlags;

}
