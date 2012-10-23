// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.service.wallpaper;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class WallpaperSettingsActivity extends PreferenceActivity {

    public WallpaperSettingsActivity() {
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public static final String EXTRA_PREVIEW_MODE = "android.service.wallpaper.PREVIEW_MODE";
}
