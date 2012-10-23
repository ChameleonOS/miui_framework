// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.content.res;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import java.io.File;
import miui.util.ImageUtils;
import miui.util.InputStreamLoader;

// Referenced classes of package miui.content.res:
//            ThemeZipFile, ThemeResourcesSystem

public class ThemeResources {
    protected static final class MetaData {

        public boolean supportCharSequence;
        public boolean supportFile;
        public boolean supportInt;
        public String themePath;

        public MetaData(String s, boolean flag, boolean flag1, boolean flag2) {
            themePath = s;
            supportInt = flag;
            supportCharSequence = flag1;
            supportFile = flag2;
        }
    }


    protected ThemeResources(ThemeResources themeresources, Resources resources, String s, MetaData metadata) {
        mWrapped = themeresources;
        mResources = resources;
        mPackageZipFile = ThemeZipFile.getThemeZipFile(metadata, s);
        boolean flag;
        if(!"icons".equals(s))
            flag = true;
        else
            flag = false;
        mSupportWrapper = flag;
        checkUpdate();
    }

    public static final void clearLockWallpaperCache() {
        sLockWallpaperModifiedTime = 0L;
        sLockWallpaperCache = null;
    }

    public static final Drawable getLockWallpaperCache(Context context) {
        Drawable drawable = null;
        File file = sSystem.getLockscreenWallpaper();
        if(file != null && file.exists())
            if(sLockWallpaperModifiedTime == file.lastModified()) {
                drawable = sLockWallpaperCache;
            } else {
                sLockWallpaperModifiedTime = file.lastModified();
                sLockWallpaperCache = null;
                try {
                    DisplayMetrics displaymetrics = Resources.getSystem().getDisplayMetrics();
                    android.graphics.Bitmap bitmap = ImageUtils.getBitmap(new InputStreamLoader(file.getAbsolutePath()), displaymetrics.widthPixels, displaymetrics.heightPixels);
                    sLockWallpaperCache = new BitmapDrawable(context.getResources(), bitmap);
                }
                catch(Exception exception) { }
                catch(OutOfMemoryError outofmemoryerror) { }
                drawable = sLockWallpaperCache;
            }
        return drawable;
    }

    public static ThemeResources getSystem(Resources resources) {
        if(sSystem == null)
            sSystem = ThemeResourcesSystem.getTopLevelThemeResources(resources);
        return sSystem;
    }

    public static ThemeResourcesSystem getSystem() {
        return sSystem;
    }

    public static ThemeResources getTopLevelThemeResources(Resources resources, String s) {
        ThemeResources themeresources = null;
        for(int i = 0; i < THEME_PATHS.length;) {
            ThemeResources themeresources1 = new ThemeResources(themeresources, resources, s, THEME_PATHS[i]);
            i++;
            themeresources = themeresources1;
        }

        return themeresources;
    }

    public boolean checkUpdate() {
        boolean flag = mPackageZipFile.checkUpdate(mResources);
        boolean flag1;
        if(mWrapped != null && (mSupportWrapper || !mPackageZipFile.exists()))
            flag1 = true;
        else
            flag1 = false;
        mHasWrapped = flag1;
        if(mHasWrapped)
            if(mWrapped.checkUpdate() || flag)
                flag = true;
            else
                flag = false;
        mHasValue = hasValuesInner();
        return flag;
    }

    public boolean containsEntry(String s) {
        boolean flag = mPackageZipFile.containsEntry(s);
        if(!flag && !mPackageZipFile.exists() && mWrapped != null)
            flag = mWrapped.containsEntry(s);
        return flag;
    }

    public CharSequence getThemeCharSequence(int i) {
        return getThemeCharSequenceInner(i);
    }

    protected CharSequence getThemeCharSequenceInner(int i) {
        CharSequence charsequence = mPackageZipFile.getThemeCharSequence(i);
        if(charsequence == null && mHasWrapped)
            charsequence = mWrapped.getThemeCharSequenceInner(i);
        return charsequence;
    }

    public ThemeZipFile.ThemeFileInfo getThemeFileStream(int i, String s) {
        return getThemeFileStream(s);
    }

    public ThemeZipFile.ThemeFileInfo getThemeFileStream(String s) {
        return getThemeFileStreamInner(s);
    }

    protected ThemeZipFile.ThemeFileInfo getThemeFileStreamInner(String s) {
        ThemeZipFile.ThemeFileInfo themefileinfo = mPackageZipFile.getInputStream(s);
        if(themefileinfo == null && mHasWrapped)
            themefileinfo = mWrapped.getThemeFileStreamInner(s);
        return themefileinfo;
    }

    public Integer getThemeInt(int i) {
        return getThemeIntInner(i);
    }

    protected Integer getThemeIntInner(int i) {
        Integer integer = mPackageZipFile.getThemeInt(i);
        if(integer == null && mHasWrapped)
            integer = mWrapped.getThemeIntInner(i);
        return integer;
    }

    public boolean hasValues() {
        return mHasValue;
    }

    protected boolean hasValuesInner() {
        boolean flag;
        if(mPackageZipFile.hasValues() || mHasWrapped && mWrapped.hasValuesInner())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static final String ADVANCE_LOCKSCREEN_NAME = "advance";
    static boolean DBG = false;
    public static final String FRAMEWORK_NAME = "framework-res";
    public static final String FRAMEWORK_PACKAGE = "android";
    public static final String ICONS_NAME = "icons";
    public static final String LANGUAGE_THEME_PATH = "/data/system/language/";
    public static final String LOCKSCREEN_NAME = "lockscreen";
    public static final String LOCKSCREEN_WALLPAPER_NAME = "lock_wallpaper";
    public static final String MIUI_NAME = "framework-miui-res";
    public static final String MIUI_PACKAGE = "miui";
    public static final String SYSTEM_LANGUAGE_THEME_PATH = "/system/language/";
    public static final String SYSTEM_THEME_PATH = "/system/media/theme/default/";
    public static final String THEME_PATH = "/data/system/theme/";
    public static final MetaData THEME_PATHS[];
    public static final String WALLPAPER_NAME = "wallpaper";
    public static final String sAppliedLockstyleConfigPath;
    private static Drawable sLockWallpaperCache;
    private static long sLockWallpaperModifiedTime;
    private static ThemeResourcesSystem sSystem;
    protected boolean mHasValue;
    protected boolean mHasWrapped;
    protected ThemeZipFile mPackageZipFile;
    protected Resources mResources;
    protected boolean mSupportWrapper;
    protected ThemeResources mWrapped;

    static  {
        DBG = false;
        MetaData ametadata[] = new MetaData[2];
        ametadata[0] = new MetaData("/system/media/theme/default/", true, true, true);
        ametadata[1] = new MetaData("/data/system/theme/", true, true, true);
        THEME_PATHS = ametadata;
        sAppliedLockstyleConfigPath = (new StringBuilder()).append("/data/system/theme/").append(File.separator).append("config.config").toString();
    }
}
