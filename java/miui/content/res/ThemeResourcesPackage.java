// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.content.res;

import android.content.res.Resources;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package miui.content.res:
//            ThemeResources, ThemeResourcesSystem

public final class ThemeResourcesPackage extends ThemeResources {

    protected ThemeResourcesPackage(ThemeResourcesPackage themeresourcespackage, Resources resources, String s, ThemeResources.MetaData metadata) {
        super(themeresourcespackage, resources, s, metadata);
    }

    public static ThemeResourcesPackage getThemeResources(Resources resources, String s) {
        ThemeResourcesPackage themeresourcespackage;
        themeresourcespackage = null;
        if(sPackageResources.containsKey(s))
            themeresourcespackage = (ThemeResourcesPackage)((WeakReference)sPackageResources.get(s)).get();
        if(themeresourcespackage != null)
            break MISSING_BLOCK_LABEL_114;
        Map map = sPackageResources;
        map;
        JVM INSTR monitorenter ;
        if(sPackageResources.containsKey(s))
            themeresourcespackage = (ThemeResourcesPackage)((WeakReference)sPackageResources.get(s)).get();
        if(themeresourcespackage == null) {
            themeresourcespackage = getTopLevelThemeResources(resources, s);
            sPackageResources.put(s, new WeakReference(themeresourcespackage));
        }
        return themeresourcespackage;
    }

    public static ThemeResourcesPackage getTopLevelThemeResources(Resources resources, String s) {
        ThemeResourcesPackage themeresourcespackage = null;
        for(int i = 0; i < THEME_PATHS.length;) {
            ThemeResourcesPackage themeresourcespackage1 = new ThemeResourcesPackage(themeresourcespackage, resources, s, THEME_PATHS[i]);
            i++;
            themeresourcespackage = themeresourcespackage1;
        }

        return themeresourcespackage;
    }

    public CharSequence getThemeCharSequence(int i) {
        CharSequence charsequence = super.getThemeCharSequence(i);
        if(charsequence == null)
            charsequence = getSystem().getThemeCharSequence(i);
        return charsequence;
    }

    public InputStream getThemeFileStream(int i, String s) {
        if(1 != i) goto _L2; else goto _L1
_L1:
        InputStream inputstream;
        inputstream = getThemeFileStream((new StringBuilder()).append("framework-res/").append(s).toString(), null);
        if(inputstream == null)
            inputstream = getSystem().getThemeFileStream(i, s);
_L4:
        return inputstream;
_L2:
        if(2 == i) {
            inputstream = getThemeFileStream((new StringBuilder()).append("framework-miui-res/").append(s).toString(), null);
            if(inputstream == null)
                inputstream = getSystem().getThemeFileStream(i, s);
        } else {
            inputstream = getThemeFileStream(s, null);
        }
        if(true) goto _L4; else goto _L3
_L3:
    }

    public Integer getThemeInt(int i) {
        Integer integer = super.getThemeInt(i);
        if(integer == null)
            integer = getSystem().getThemeInt(i);
        return integer;
    }

    public boolean hasValues() {
        boolean flag;
        if(super.hasValues() || getSystem().hasValues())
            flag = true;
        else
            flag = false;
        return flag;
    }

    private static final Map sPackageResources = new HashMap();

}
