// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.content.res;

import android.util.DisplayMetrics;

// Referenced classes of package android.content.res:
//            MiuiResources, MiuiTypedArray, Resources, AssetManager, 
//            Configuration, CompatibilityInfo, TypedArray

public class MiuiClassFactory {

    private MiuiClassFactory() {
    }

    static Resources newResources() {
        return new MiuiResources();
    }

    public static Resources newResources(AssetManager assetmanager, DisplayMetrics displaymetrics, Configuration configuration) {
        return new MiuiResources(assetmanager, displaymetrics, configuration);
    }

    public static Resources newResources(AssetManager assetmanager, DisplayMetrics displaymetrics, Configuration configuration, CompatibilityInfo compatibilityinfo) {
        return new MiuiResources(assetmanager, displaymetrics, configuration, compatibilityinfo);
    }

    static TypedArray newTypedArray(Resources resources, int ai[], int ai1[], int i) {
        return new MiuiTypedArray(resources, ai, ai1, i);
    }
}
