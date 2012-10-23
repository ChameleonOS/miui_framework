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

    private InputStream getThemeFileStreamMIUI(String s, String s1, int ai[]) {
        InputStream inputstream = null;
        if(s1.startsWith("lock_screen_")) {
            inputstream = sLockscreen.getThemeFileStream(s, null);
            if(inputstream == null)
                inputstream = sLockscreen.getThemeFileStream(s1, null);
        }
        if(inputstream == null)
            inputstream = sMiui.getThemeFileStream(s, null);
        return inputstream;
    }

    private InputStream getThemeFileStreamSystem(String s, String s1, int ai[]) {
        InputStream inputstream = null;
        if(!s1.equals("sym_def_app_icon.png")) goto _L2; else goto _L1
_L1:
        inputstream = sIcons.getThemeFileStream(s1, ai);
_L6:
        InputStream inputstream1;
        if(inputstream == null)
            inputstream = getThemeFileStreamInner(s, ai);
        inputstream1 = inputstream;
_L4:
        return inputstream1;
_L2:
        if(!s1.equals("default_wallpaper.jpg"))
            continue; /* Loop/switch isn't completed */
        inputstream1 = null;
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

    public InputStream getAwesomeLockscreenFileStream(String s, int ai[]) {
        return sLockscreen.getThemeFileStream((new StringBuilder()).append("advance/").append(s).toString(), ai);
    }

    public Bitmap getIcon(Resources resources, String s) {
        InputStream inputstream = getIconStream(s, null);
        Bitmap bitmap = BitmapFactory.decodeStream(inputstream);
        if(inputstream != null)
            try {
                inputstream.close();
            }
            catch(IOException ioexception) { }
        return bitmap;
    }

    public InputStream getIconStream(String s, int ai[]) {
        return sIcons.getThemeFileStream(s, ai);
    }

    public InputStream getLockscreenStream(String s, int ai[]) {
        return sLockscreen.getThemeFileStream(s, ai);
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

    public InputStream getThemeFileStream(int i, String s) {
        String s1 = s.substring(1 + s.lastIndexOf('/'));
        InputStream inputstream;
        if(2 == i)
            inputstream = getThemeFileStreamMIUI(s, s1, null);
        else
            inputstream = getThemeFileStreamSystem(s, s1, null);
        return inputstream;
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
