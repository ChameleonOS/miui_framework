// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.app;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.*;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.Log;
import miui.content.res.*;

// Referenced classes of package android.app:
//            ApplicationPackageManager

public class MiuiThemeHelper {

    private MiuiThemeHelper() {
    }

    public static void addExtraAssetPaths(AssetManager assetmanager) {
        assetmanager.addAssetPath("/system/framework/framework-miui-res.apk");
    }

    public static void copyExtraConfigurations(Configuration configuration, Configuration configuration1) {
        configuration1.extraConfig.themeChanged = configuration.extraConfig.themeChanged;
    }

    public static Drawable getDrawable(PackageManager packagemanager, String s, int i, ApplicationInfo applicationinfo, PackageItemInfo packageiteminfo, boolean flag) {
        Drawable drawable;
        if(!flag || packageiteminfo == null)
            drawable = packagemanager.getDrawable(s, i, applicationinfo);
        else
            drawable = getDrawable(packagemanager, s, i, applicationinfo, packageiteminfo.name);
        return drawable;
    }

    public static Drawable getDrawable(PackageManager packagemanager, String s, int i, ApplicationInfo applicationinfo, String s1) {
        String s2;
        ApplicationPackageManager.ResourceName resourcename;
        Drawable drawable;
        s2 = IconCustomizer.getFileName(s, s1);
        resourcename = new ApplicationPackageManager.ResourceName(s2, i);
        drawable = ApplicationPackageManager.getCachedIcon(resourcename);
        if(drawable == null) goto _L2; else goto _L1
_L1:
        Drawable drawable1 = drawable;
_L4:
        return drawable1;
_L2:
        Object obj;
        if(!IconCustomizer.isExclude(s) || !ThemeResources.getSystem().hasIcon("icon_mask.png"))
            break; /* Loop/switch isn't completed */
        obj = packagemanager.getDrawable(s, i, applicationinfo);
_L5:
        if(obj != null)
            ApplicationPackageManager.putCachedIcon(resourcename, ((Drawable) (obj)));
        drawable1 = ((Drawable) (obj));
        if(true) goto _L4; else goto _L3
_L3:
        obj = IconCustomizer.getCustomizedIconDrawable(s, s1);
        if(obj == null) {
            obj = packagemanager.getDrawable(s, i, applicationinfo);
            if(obj != null) {
                Log.d("IconHelper", (new StringBuilder()).append("Generate customized icon for ").append(s2).toString());
                obj = IconCustomizer.generateIconDrawable(((Drawable) (obj)));
                IconCustomizer.saveCustomizedIconBitmap(s2, ((BitmapDrawable)obj).getBitmap());
            }
        }
          goto _L5
        if(true) goto _L4; else goto _L6
_L6:
    }

    public static void handleExtraConfigurationChanges(int i) {
        if((0x80000000 & i) != 0) {
            Canvas.freeCaches();
            IconCustomizer.clearCache();
        }
    }

    public static void handleExtraConfigurationChanges(int i, Configuration configuration, Context context, Handler handler) {
        if((0x80000000 & i) != 0) {
            ExtraConfiguration.addNeedRestartActivity(configuration.extraConfig.themeChangedFlags);
            handleExtraConfigurationChanges(i);
        }
    }

    public static boolean isCompatibilityMode(int i) {
        boolean flag;
        if((0x8000000 & i) != 0)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static boolean isCustomizedIcon(IntentFilter intentfilter) {
        int i;
        if(intentfilter == null)
            break MISSING_BLOCK_LABEL_39;
        i = -1 + intentfilter.countCategories();
_L3:
        if(i < 0)
            break MISSING_BLOCK_LABEL_39;
        if(!"android.intent.category.LAUNCHER".equals(intentfilter.getCategory(i))) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        i--;
          goto _L3
        flag = false;
          goto _L4
    }

    public static boolean needRestartActivity(String s, int i, Configuration configuration) {
        boolean flag;
        if(i == 0x80000000 && !ExtraConfiguration.removeNeedRestartActivity(s) && !ExtraConfiguration.needRestartActivity(s, configuration.extraConfig.themeChangedFlags))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static Integer parseDimension(String s) {
        int i;
        int j;
        int k;
        int l;
        int i1;
        i = -4;
        j = -3;
        k = -2;
        l = -1;
        i1 = 0;
_L5:
        if(i1 >= s.length()) goto _L2; else goto _L1
_L1:
        char c;
        c = s.charAt(i1);
        if(i == -4 && c >= '0' && c <= '9')
            i = i1;
        if(j == -3 && c == '.')
            j = i1;
        if(j != -3 && c >= '0' && c <= '9')
            k = i1;
        if(l != -1 || c < 'a' || c > 'z') goto _L4; else goto _L3
_L3:
        l = i1;
_L2:
        Integer integer;
        int j1 = 0;
        int k1 = 0;
        if(l == -1 || j >= k || k >= l)
            break MISSING_BLOCK_LABEL_443;
        float f;
        float f1;
        String s1;
        byte byte0;
        try {
            f = Float.parseFloat(s.substring(0, l));
        }
        catch(NumberFormatException numberformatexception) {
            integer = null;
            break MISSING_BLOCK_LABEL_262;
        }
        f1 = f;
        if(j != -3 && k != -2) {
            int l1;
            try {
                l1 = Integer.parseInt(s.substring(k, l));
            }
            catch(NumberFormatException numberformatexception1) {
                integer = null;
                break MISSING_BLOCK_LABEL_262;
            }
            j1 = l1;
        }
        if(j1 < 256)
            f1 *= 256F;
        else
        if(j1 < 32768) {
            f1 *= 32768F;
            k1 = 1;
        } else
        if(j1 < 0x40000000) {
            f1 *= 1.073742E+09F;
            k1 = 2;
        } else
        if(j1 < 0x200000) {
            f1 *= 2097152F;
            k1 = 3;
        }
        s1 = s.substring(l);
        if(s1.equals("px"))
            byte0 = 0;
        else
        if(s1.equals("dp") || s1.equals("dip"))
            byte0 = 1;
        else
        if(s1.equals("sp"))
            byte0 = 2;
        else
        if(s1.equals("pt"))
            byte0 = 3;
        else
        if(s1.equals("in")) {
            byte0 = 4;
        } else {
label0:
            {
                if(!s1.equals("mm"))
                    break label0;
                byte0 = 5;
            }
        }
        integer = Integer.valueOf(byte0 | Integer.valueOf(Integer.valueOf(0xffffff00 & Integer.valueOf((int)f1).intValue()).intValue() | k1 << 4).intValue());
_L6:
        return integer;
_L4:
        i1++;
          goto _L5
        integer = null;
          goto _L6
        integer = null;
          goto _L6
    }

    public static final String MIUI_RES_PATH = "/system/framework/framework-miui-res.apk";
    private static final String TAG = "IconHelper";
}
