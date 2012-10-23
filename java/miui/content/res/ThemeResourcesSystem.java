// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.content.res;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.*;

// Referenced classes of package miui.content.res:
//            ThemeResources

public final class ThemeResourcesSystem extends ThemeResources {

    protected ThemeResourcesSystem(ThemeResourcesSystem themeresourcessystem, Resources resources, ThemeResources.MetaData metadata) {
        super(themeresourcessystem, resources, "framework-res", metadata);
        mThemePath = metadata.themePath;
    }

    private ThemeZipFile.ThemeFileInfo getThemeFileStreamMIUI(String s, String s1) {
        ThemeZipFile.ThemeFileInfo themefileinfo = null;
        if(s1.startsWith("lock_screen_")) {
            themefileinfo = sLockscreen.getThemeFileStream(s);
            if(themefileinfo == null)
                themefileinfo = sLockscreen.getThemeFileStream(s1);
        }
        if(themefileinfo == null)
            themefileinfo = sMiui.getThemeFileStream(s);
        return themefileinfo;
    }

    private ThemeZipFile.ThemeFileInfo getThemeFileStreamSystem(String s, String s1) {
        ThemeZipFile.ThemeFileInfo themefileinfo = null;
        if(!s1.equals("sym_def_app_icon.png")) goto _L2; else goto _L1
_L1:
        themefileinfo = getIconStream(s);
_L6:
        ThemeZipFile.ThemeFileInfo themefileinfo1;
        if(themefileinfo == null)
            themefileinfo = getThemeFileStreamInner(s);
        themefileinfo1 = themefileinfo;
_L4:
        return themefileinfo1;
_L2:
        if(!s1.equals("default_wallpaper.jpg"))
            continue; /* Loop/switch isn't completed */
        themefileinfo1 = null;
        if(true) goto _L4; else goto _L3
_L3:
        if(true) goto _L6; else goto _L5
_L5:
    }

    public static ThemeResourcesSystem getTopLevelThemeResources(Resources resources) {
        sIcons = ThemeResources.getTopLevelThemeResources(resources, "icons");
        sLockscreen = ThemeResources.getTopLevelThemeResources(resources, "lockscreen");
        sMiui = ThemeResources.getTopLevelThemeResources(resources, "framework-miui-res");
        ThemeResourcesSystem themeresourcessystem = null;
        for(int i = 0; i < THEME_PATHS.length;) {
            ThemeResourcesSystem themeresourcessystem1 = new ThemeResourcesSystem(themeresourcessystem, resources, THEME_PATHS[i]);
            i++;
            themeresourcessystem = themeresourcessystem1;
        }

        return themeresourcessystem;
    }

    public boolean checkUpdate() {
        sIcons.checkUpdate();
        sLockscreen.checkUpdate();
        sMiui.checkUpdate();
        return super.checkUpdate();
    }

    public boolean containsAwesomeLockscreenEntry(String s) {
        return sLockscreen.containsEntry((new StringBuilder()).append("advance/").append(s).toString());
    }

    public ThemeZipFile.ThemeFileInfo getAwesomeLockscreenFileStream(String s) {
        return sLockscreen.getThemeFileStream((new StringBuilder()).append("advance/").append(s).toString());
    }

    public Bitmap getIcon(Resources resources, String s) {
        Bitmap bitmap;
        ThemeZipFile.ThemeFileInfo themefileinfo;
        android.graphics.BitmapFactory.Options options;
        bitmap = null;
        themefileinfo = getIconStream(s);
        if(themefileinfo == null)
            break MISSING_BLOCK_LABEL_72;
        options = null;
        android.graphics.BitmapFactory.Options options1;
        if(themefileinfo.mDensity <= 0)
            break MISSING_BLOCK_LABEL_48;
        options1 = new android.graphics.BitmapFactory.Options();
        options1.inDensity = themefileinfo.mDensity;
        options = options1;
        Bitmap bitmap1 = BitmapFactory.decodeStream(themefileinfo.mInput, null, options);
        Exception exception;
        bitmap = bitmap1;
        OutOfMemoryError outofmemoryerror;
        try {
            themefileinfo.mInput.close();
        }
        catch(IOException ioexception) { }
        return bitmap;
        exception;
_L1:
        try {
            themefileinfo.mInput.close();
        }
        catch(IOException ioexception1) { }
        throw exception;
        outofmemoryerror;
_L2:
        themefileinfo.mInput.close();
        break MISSING_BLOCK_LABEL_72;
        exception;
          goto _L1
        OutOfMemoryError outofmemoryerror1;
        outofmemoryerror1;
          goto _L2
    }

    public ThemeZipFile.ThemeFileInfo getIconStream(String s) {
        return sIcons.getThemeFileStream(s);
    }

    public ThemeZipFile.ThemeFileInfo getLockscreenStream(String s) {
        return sLockscreen.getThemeFileStream(s);
    }

    public File getLockscreenWallpaper() {
        File file = new File((new StringBuilder()).append(mThemePath).append("lock_wallpaper").toString());
        if((file == null || !file.exists()) && super.mWrapped != null)
            file = ((ThemeResourcesSystem)super.mWrapped).getLockscreenWallpaper();
        return file;
    }

    public CharSequence getThemeCharSequence(int i) {
        CharSequence charsequence = sLockscreen.getThemeCharSequence(i);
        if(charsequence == null)
            charsequence = sMiui.getThemeCharSequence(i);
        if(charsequence == null)
            charsequence = getThemeCharSequenceInner(i);
        return charsequence;
    }

    public ThemeZipFile.ThemeFileInfo getThemeFileStream(int i, String s) {
        String s1 = s.substring(1 + s.lastIndexOf('/'));
        ThemeZipFile.ThemeFileInfo themefileinfo;
        if(2 == i)
            themefileinfo = getThemeFileStreamMIUI(s, s1);
        else
            themefileinfo = getThemeFileStreamSystem(s, s1);
        return themefileinfo;
    }

    public Integer getThemeInt(int i) {
        Integer integer = sLockscreen.getThemeInt(i);
        if(integer == null)
            integer = sMiui.getThemeInt(i);
        if(integer == null)
            integer = getThemeIntInner(i);
        return integer;
    }

    public boolean hasAwesomeLockscreen() {
        return sLockscreen.containsEntry("advance/manifest.xml");
    }

    public boolean hasIcon(String s) {
        return sIcons.containsEntry(s);
    }

    public boolean hasValues() {
        boolean flag;
        if(super.hasValues() || sLockscreen.hasValues() || sMiui.hasValues())
            flag = true;
        else
            flag = false;
        return flag;
    }

    public void resetIcons() {
        sIcons.checkUpdate();
    }

    private static ThemeResources sIcons;
    private static ThemeResources sLockscreen;
    private static ThemeResources sMiui;
    protected String mThemePath;
}
