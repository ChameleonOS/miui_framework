// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.content.res;

import android.content.Context;
import android.content.Intent;
import android.content.pm.*;
import android.content.res.Resources;
import android.graphics.*;
import android.graphics.drawable.*;
import android.os.FileUtils;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.io.*;
import java.lang.ref.SoftReference;
import java.util.*;
import miui.util.CommandLineUtils;
import miui.util.DisplayUtils;

// Referenced classes of package miui.content.res:
//            ThemeResources, ThemeResourcesSystem

public class IconCustomizer {
    public static interface CustomizedIconsListener {

        public abstract void beforePrepareIcon(int i);

        public abstract void finishAllIcons();

        public abstract void finishPrepareIcon(int i);
    }


    public IconCustomizer() {
    }

    private static int RGBToColor(int ai[]) {
        return ((ai[0] << 8) + ai[1] << 8) + ai[2];
    }

    public static void clearCache() {
        synchronized(sExcludeAll) {
            sExcludes = null;
        }
        sCache.clear();
        return;
        exception;
        boolean1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void clearCustomizedIcons(String s) {
        if(TextUtils.isEmpty(s)) {
            CommandLineUtils.rm("/data/system/customized_icons/*", "root");
            sCache.clear();
        } else {
            CommandLineUtils.rm((new StringBuilder()).append("/data/system/customized_icons/").append(s).append("*").toString(), "root");
        }
    }

    private static int[] colorToRGB(int i) {
        int ai[] = new int[3];
        ai[0] = (0xff0000 & i) >> 16;
        ai[1] = (0xff00 & i) >> 8;
        ai[2] = i & 0xff;
        return ai;
    }

    private static Bitmap composeIcon(Bitmap bitmap) {
        int i = bitmap.getWidth();
        int j = bitmap.getHeight();
        int ai[] = new int[i * j];
        bitmap.getPixels(ai, 0, i, 0, 0, i, j);
        bitmap.recycle();
        cutEdge(i, j, ai);
        Bitmap bitmap1 = Bitmap.createBitmap(sCustomizedIconWidth, sCustomizedIconHeight, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap1);
        Bitmap bitmap2 = getCachedThemeIcon("icon_background.png");
        if(bitmap2 != null)
            drawBackground(canvas, bitmap2, i, j, ai);
        Bitmap bitmap3 = getCachedThemeIcon("icon_pattern.png");
        if(bitmap3 != null)
            canvas.drawBitmap(bitmap3, 0.0F, 0.0F, null);
        canvas.drawBitmap(ai, 0, i, (sCustomizedIconWidth - i) / 2, (sCustomizedIconHeight - j) / 2, i, j, true, null);
        Bitmap bitmap4 = getCachedThemeIcon("icon_border.png");
        if(bitmap4 != null)
            canvas.drawBitmap(bitmap4, 0.0F, 0.0F, null);
        return bitmap1;
    }

    private static Bitmap composeShortcutIcon(Bitmap bitmap) {
        int i = bitmap.getWidth();
        int j = bitmap.getHeight();
        int ai[] = new int[i * j];
        bitmap.getPixels(ai, 0, i, 0, 0, i, j);
        bitmap.recycle();
        cutEdge(i, j, ai);
        Bitmap bitmap1 = Bitmap.createBitmap(sCustomizedIconWidth, sCustomizedIconHeight, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap1);
        Bitmap bitmap2 = getCachedThemeIcon("icon_shortcut.png");
        if(bitmap2 != null)
            canvas.drawBitmap(bitmap2, 0.0F, 0.0F, null);
        canvas.drawBitmap(ai, 0, i, (sCustomizedIconWidth - i) / 2, (sCustomizedIconHeight - j) / 2, i, j, true, null);
        Bitmap bitmap3 = getCachedThemeIcon("icon_shortcut_arrow.png");
        if(bitmap3 != null)
            canvas.drawBitmap(bitmap3, 0.0F, 0.0F, null);
        return bitmap1;
    }

    private static void cutEdge(int i, int j, int ai[]) {
        Bitmap bitmap = getCachedThemeIcon("icon_mask.png");
        if(bitmap != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int k = bitmap.getWidth();
        int l = bitmap.getHeight();
        if(k >= i && l >= j) {
            int ai1[] = new int[k * l];
            bitmap.getPixels(ai1, 0, i, (k - i) / 2, (l - j) / 2, i, j);
            int i1 = -1 + i * j;
            while(i1 >= 0)  {
                ai[i1] = ai[i1] & 0xffffff + (((ai[i1] >>> 24) * (ai1[i1] >>> 24)) / 255 << 24);
                i1--;
            }
        }
        if(true) goto _L1; else goto _L3
_L3:
    }

    private static void drawBackground(Canvas canvas, Bitmap bitmap, int i, int j, int ai[]) {
        int i1;
        int k = 0;
        int ai1[] = new int[3];
        ai1[0] = 0;
        ai1[1] = 0;
        ai1[2] = 0;
        for(int l = -1 + i * j; l >= 0; l--) {
            int k3 = 0xffffff & ai[l];
            if(k3 > 0) {
                int ai7[] = colorToRGB(k3);
                ai1[0] = ai1[0] + ai7[0];
                ai1[1] = ai1[1] + ai7[1];
                ai1[2] = ai1[2] + ai7[2];
                k++;
            }
        }

        if(k > 0) {
            ai1[0] = ai1[0] / k;
            ai1[1] = ai1[1] / k;
            ai1[2] = ai1[2] / k;
        }
        i1 = RGBToColor(ai1);
        if((double)getSaturation(i1) >= 0.02D) goto _L2; else goto _L1
_L1:
        int i2 = 0;
_L4:
        int j2;
        int k2;
        int ai6[];
        int ai5[] = colorToRGB(i2);
        j2 = bitmap.getWidth();
        k2 = bitmap.getHeight();
        ai6 = new int[j2 * k2];
        bitmap.getPixels(ai6, 0, j2, 0, 0, j2, k2);
        for(int l2 = -1 + j2 * k2; l2 >= 0; l2--) {
            int i3 = ai6[l2];
            ai6[l2] = 0xff000000 & i3 | 0xff0000 & (0xff0000 & i3) * ai5[0] >>> 8 | 0xff00 & (0xff00 & i3) * ai5[1] >>> 8 | 0xff & (i3 & 0xff) * ai5[2] >>> 8;
        }

        break; /* Loop/switch isn't completed */
_L2:
        float f;
label0:
        {
            int ai2[][] = new int[2][];
            int ai3[] = new int[2];
            ai3[0] = 100;
            ai3[1] = 110;
            ai2[0] = ai3;
            int ai4[] = new int[2];
            ai4[0] = 190;
            ai4[1] = 275;
            ai2[1] = ai4;
            int j1 = 0;
            for(int k1 = 0; k1 < ai2.length; k1++)
                j1 += ai2[k1][1] - ai2[k1][0];

            f = (getHue(i1) * (float)j1) / 360F;
            int l1 = 0;
            do {
                if(l1 >= ai2.length)
                    break label0;
                int j3 = ai2[l1][1] - ai2[l1][0];
                if(f <= (float)j3)
                    break;
                f -= j3;
                l1++;
            } while(true);
            f += ai2[l1][0];
        }
        i2 = setSaturation(setValue(setHue(i1, f), 0.6F), 0.4F);
        if(true) goto _L4; else goto _L3
_L3:
        canvas.drawBitmap(ai6, 0, j2, 0, 0, j2, k2, true, null);
        return;
    }

    private static Bitmap drawableToBitmap(Drawable drawable) {
        Canvas canvas = sCanvas;
        canvas;
        JVM INSTR monitorenter ;
        int i = sIconWidth;
        int j = sIconHeight;
        int k = i;
        int l = j;
        int i1;
        int j1;
        if(drawable instanceof PaintDrawable) {
            PaintDrawable paintdrawable = (PaintDrawable)drawable;
            paintdrawable.setIntrinsicWidth(i);
            paintdrawable.setIntrinsicHeight(j);
        } else
        if(drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapdrawable = (BitmapDrawable)drawable;
            if(bitmapdrawable.getBitmap().getDensity() == 0)
                bitmapdrawable.setTargetDensity(sSystemResource.getDisplayMetrics());
        }
        i1 = drawable.getIntrinsicWidth();
        j1 = drawable.getIntrinsicHeight();
        if(i1 > 0 && i1 > 0)
            if(k < i1 || l < j1) {
                float f = (float)i1 / (float)j1;
                Bitmap bitmap;
                Canvas canvas1;
                int k1;
                int l1;
                if(i1 > j1)
                    l = (int)((float)k / f);
                else
                if(j1 > i1)
                    k = (int)(f * (float)l);
            } else
            if(i1 < k && j1 < l) {
                k = i1;
                l = j1;
            }
        bitmap = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
        canvas1 = sCanvas;
        canvas1.setBitmap(bitmap);
        k1 = (i - k) / 2;
        l1 = (j - l) / 2;
        sOldBounds.set(drawable.getBounds());
        drawable.setBounds(k1, l1, k1 + k, l1 + l);
        drawable.draw(canvas1);
        drawable.setBounds(sOldBounds);
        return bitmap;
    }

    public static BitmapDrawable generateIconDrawable(Drawable drawable) {
        return scaleDrawable(composeIcon(drawableToBitmap(drawable)));
    }

    public static BitmapDrawable generateShortcutIconDrawable(Drawable drawable) {
        return scaleDrawable(composeShortcutIcon(drawableToBitmap(drawable)));
    }

    public static Bitmap getCachedThemeIcon(String s) {
        return getCachedThemeIcon(s, sCustomizedIconWidth, sCustomizedIconHeight);
    }

    public static Bitmap getCachedThemeIcon(String s, int i, int j) {
        Bitmap bitmap = null;
        SoftReference softreference = (SoftReference)sCache.get(s);
        if(softreference != null)
            bitmap = (Bitmap)softreference.get();
        if(bitmap == null) {
            bitmap = getThemeIcon(s);
            sCache.put(s, new SoftReference(bitmap));
        }
        return scaleBitmap(bitmap, i, j);
    }

    public static BitmapDrawable getCustomizedIconDrawable(String s, String s1) {
        String s2 = getFileName(s, s1);
        Bitmap bitmap = getThemeIcon(s2);
        if(bitmap == null && s1 != null && !s1.startsWith(s)) {
            Object aobj[] = new Object[1];
            aobj[0] = s1;
            bitmap = getThemeIcon(String.format("%s.png", aobj));
        }
        if(bitmap == null) {
            String s4 = (String)sIconMapping.get(s2);
            if(s4 != null)
                bitmap = getThemeIcon(s4);
        }
        if(bitmap == null) {
            String s3 = (new StringBuilder()).append("/data/system/customized_icons/").append(s2).toString();
            File file = new File(s3);
            if(file.exists()) {
                bitmap = BitmapFactory.decodeFile(s3);
                if(bitmap == null)
                    file.delete();
            }
        }
        return scaleDrawable(bitmap);
    }

    public static String getFileName(String s, String s1) {
        String s2;
        if(s1 == null) {
            Object aobj2[] = new Object[1];
            aobj2[0] = s;
            s2 = String.format("%s.png", aobj2);
        } else
        if(s1.startsWith(s)) {
            Object aobj1[] = new Object[1];
            aobj1[0] = s1;
            s2 = String.format("%s.png", aobj1);
        } else {
            Object aobj[] = new Object[2];
            aobj[0] = s;
            aobj[1] = s1;
            s2 = String.format("%s#%s.png", aobj);
        }
        return s2;
    }

    private static float getHue(int i) {
        int ai[] = colorToRGB(i);
        int j = Math.min(ai[0], Math.min(ai[1], ai[2]));
        int k = Math.max(ai[0], Math.max(ai[1], ai[2]));
        int l = k - j;
        float f;
        if(l == 0) {
            f = 0.0F;
        } else {
            int i1;
            for(i1 = 0; i1 < 2 && j != ai[i1]; i1++);
            f = (float)(120 * ((i1 + 1) % 3)) + (60F * (float)(ai[(i1 + 2) % 3] - j)) / (float)l + (60F * (float)(k - ai[(i1 + 1) % 3])) / (float)l;
        }
        return f;
    }

    private static float getSaturation(int i) {
        int ai[] = colorToRGB(i);
        int j = Math.min(ai[0], Math.min(ai[1], ai[2]));
        int k = Math.max(ai[0], Math.max(ai[1], ai[2]));
        float f;
        if(k == 0 || k == j)
            f = i;
        else
            f = (1.0F * (float)(k - j)) / (float)k;
        return f;
    }

    private static Bitmap getThemeIcon(String s) {
        Bitmap bitmap = null;
        int i = 0;
        do {
label0:
            {
                if(i < sDensities.length) {
                    String s1 = (new StringBuilder()).append(DisplayUtils.getDrawbleDensityFolder(sDensities[i])).append(s).toString();
                    bitmap = ThemeResources.getSystem().getIcon(sSystemResource, s1);
                    if(bitmap == null)
                        break label0;
                    bitmap.setDensity(sDensities[i]);
                }
                if(bitmap == null) {
                    bitmap = ThemeResources.getSystem().getIcon(sSystemResource, s);
                    if(bitmap != null)
                        bitmap.setDensity(240);
                }
                return bitmap;
            }
            i++;
        } while(true);
    }

    private static float getValue(int i) {
        int ai[] = colorToRGB(i);
        return (1.0F * (float)Math.max(ai[0], Math.max(ai[1], ai[2]))) / 255F;
    }

    public static boolean isExclude(String s) {
        Boolean boolean1 = sExcludeAll;
        boolean1;
        JVM INSTR monitorenter ;
        if(sExcludes == null) {
            sExcludes = new HashSet();
            if(ThemeResources.getSystem().hasIcon("exclude_list.txt")) {
                sExcludes.add("com.android.browser");
                sExcludes.add("com.android.calendar");
                sExcludes.add("com.android.camera");
                sExcludes.add("com.android.contacts");
                sExcludes.add("com.android.deskclock");
                sExcludes.add("com.android.email");
                sExcludes.add("com.android.fileexplorer");
                sExcludes.add("com.android.gallery");
                sExcludes.add("com.android.launcher");
                sExcludes.add("com.android.mms");
                sExcludes.add("com.android.monitor");
                sExcludes.add("com.android.music");
                sExcludes.add("com.android.phone");
                sExcludes.add("com.android.providers.contacts");
                sExcludes.add("com.android.providers.downloads.ui");
                sExcludes.add("com.android.providers.telephony");
                sExcludes.add("com.android.quicksearchbox");
                sExcludes.add("com.android.settings");
                sExcludes.add("com.android.soundrecorder");
                sExcludes.add("com.android.spare_parts");
                sExcludes.add("com.android.stk");
                sExcludes.add("com.android.thememanager");
                sExcludes.add("com.android.updater");
                sExcludes.add("com.miui.antispam");
                sExcludes.add("com.miui.backup");
                sExcludes.add("com.miui.bugreport");
                sExcludes.add("com.miui.camera");
                sExcludes.add("com.miui.cit");
                sExcludes.add("com.miui.compass");
                sExcludes.add("com.miui.fmradio");
                sExcludes.add("com.miui.lockv4");
                sExcludes.add("com.miui.notes");
                sExcludes.add("com.miui.player");
                sExcludes.add("com.xiaomi.market");
                sExcludes.add("com.miui.uac");
                sExcludes.add("com.miui.userbook");
                sExcludes.add("com.miui.weather2");
            }
        }
        boolean flag;
        if(sExcludeAll.booleanValue() || sExcludes.contains(s))
            flag = true;
        else
            flag = false;
        return flag;
    }

    public static void prepareCustomizedIcons(Context context) {
        prepareCustomizedIcons(context, null);
    }

    public static void prepareCustomizedIcons(Context context, CustomizedIconsListener customizediconslistener) {
        Intent intent = new Intent("android.intent.action.MAIN", null);
        intent.addCategory("android.intent.category.LAUNCHER");
        PackageManager packagemanager = context.getPackageManager();
        List list = packagemanager.queryIntentActivities(intent, 0);
        if(customizediconslistener != null)
            customizediconslistener.beforePrepareIcon(list.size());
        int i = 0;
        Iterator iterator = list.iterator();
        do {
            if(!iterator.hasNext())
                break;
            ((ResolveInfo)iterator.next()).activityInfo.loadIcon(packagemanager);
            if(customizediconslistener != null) {
                int j = i + 1;
                customizediconslistener.finishPrepareIcon(i);
                i = j;
            }
        } while(true);
        if(customizediconslistener != null)
            customizediconslistener.finishAllIcons();
    }

    public static void saveCustomizedIconBitmap(String s, Bitmap bitmap) {
        String s1;
        File file;
        s1 = (new StringBuilder()).append("/data/system/customized_icons/").append(s).toString();
        file = new File(s1);
        FileOutputStream fileoutputstream = null;
        IOException ioexception;
        FileNotFoundException filenotfoundexception;
        FileOutputStream fileoutputstream1;
        try {
            fileoutputstream1 = new FileOutputStream(file);
        }
        catch(FileNotFoundException filenotfoundexception2) {
            continue; /* Loop/switch isn't completed */
        }
        FileUtils.setPermissions(s1, 436, -1, -1);
        fileoutputstream = fileoutputstream1;
_L3:
        if(fileoutputstream != null)
            break MISSING_BLOCK_LABEL_121;
        File file1 = file.getParentFile();
        file1.mkdirs();
        FileUtils.setPermissions(file1.getPath(), 1023, -1, -1);
        fileoutputstream = new FileOutputStream(file);
        FileUtils.setPermissions(s1, 436, -1, -1);
        bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, fileoutputstream);
        fileoutputstream.flush();
        fileoutputstream.close();
_L1:
        return;
        filenotfoundexception;
        filenotfoundexception.printStackTrace();
          goto _L1
        ioexception;
        ioexception.printStackTrace();
          goto _L1
        FileNotFoundException filenotfoundexception1;
        filenotfoundexception1;
        fileoutputstream = fileoutputstream1;
        if(true) goto _L3; else goto _L2
_L2:
    }

    private static Bitmap scaleBitmap(Bitmap bitmap) {
        return scaleBitmap(bitmap, sCustomizedIconWidth, sCustomizedIconHeight);
    }

    private static Bitmap scaleBitmap(Bitmap bitmap, int i, int j) {
        Bitmap bitmap1 = null;
        if(bitmap == null) goto _L2; else goto _L1
_L1:
        if(bitmap.getWidth() != i || bitmap.getHeight() != j) goto _L4; else goto _L3
_L3:
        return bitmap;
_L4:
        bitmap1 = Bitmap.createScaledBitmap(bitmap, i, j, true);
        bitmap1.setDensity(sDensity);
_L2:
        bitmap = bitmap1;
        if(true) goto _L3; else goto _L5
_L5:
    }

    private static BitmapDrawable scaleDrawable(Bitmap bitmap) {
        BitmapDrawable bitmapdrawable = null;
        if(bitmap != null) {
            Bitmap bitmap1 = scaleBitmap(bitmap);
            bitmapdrawable = new BitmapDrawable(sSystemResource, bitmap1);
        }
        return bitmapdrawable;
    }

    private static int scalePixel(int i) {
        int j = sDensity;
        if(sDensity == 320)
            j = 360;
        return (i * j) / 240;
    }

    private static int setHue(int i, float f) {
        int ai[] = colorToRGB(i);
        int j = Math.min(ai[0], Math.min(ai[1], ai[2]));
        int k = Math.max(ai[0], Math.max(ai[1], ai[2]));
        int l = k - j;
        if(l != 0) {
            for(; f < 0.0F; f += 360F);
            for(; f > 360F; f -= 360F);
            int i1 = (int)Math.floor(f / 120F);
            float f1 = f - (float)(i1 * 120);
            int j1 = (i1 + 2) % 3;
            ai[j1] = j;
            ai[(j1 + 2) % 3] = (int)((float)j + ((float)l * Math.min(f1, 60F)) / 60F);
            ai[(j1 + 1) % 3] = (int)((float)k - ((float)l * Math.max(0.0F, f1 - 60F)) / 60F);
            i = RGBToColor(ai);
        }
        return i;
    }

    private static int setSaturation(int i, float f) {
        int ai[] = colorToRGB(i);
        int j = Math.min(ai[0], Math.min(ai[1], ai[2]));
        int k = Math.max(ai[0], Math.max(ai[1], ai[2]));
        if(k != 0 && k != j) {
            float f1 = (1.0F * (float)(k - j)) / (float)k;
            ai[0] = (int)((float)k - (f * (float)(k - ai[0])) / f1);
            ai[1] = (int)((float)k - (f * (float)(k - ai[1])) / f1);
            ai[2] = (int)((float)k - (f * (float)(k - ai[2])) / f1);
            i = RGBToColor(ai);
        }
        return i;
    }

    private static int setValue(int i, float f) {
        int ai[] = colorToRGB(i);
        int j = Math.max(ai[0], Math.max(ai[1], ai[2]));
        if(j != 0) {
            float f1 = (1.0F * (float)j) / 255F;
            ai[0] = (int)((f * (float)ai[0]) / f1);
            ai[1] = (int)((f * (float)ai[1]) / f1);
            ai[2] = (int)((f * (float)ai[2]) / f1);
            i = RGBToColor(ai);
        }
        return i;
    }

    private static final int sAlphaShift = 24;
    private static HashMap sCache = new HashMap();
    private static final Canvas sCanvas;
    private static final int sColorShift = 8;
    public static final int sCustomizedIconHeight = 0;
    public static final int sCustomizedIconWidth = 0;
    private static final int sDensities[] = DisplayUtils.getBestDensityOrder(sDensity);
    private static final int sDensity = 0;
    private static Boolean sExcludeAll;
    private static Set sExcludes;
    private static final int sIconHeight = 0;
    private static Map sIconMapping;
    private static final int sIconWidth = 0;
    private static final Rect sOldBounds = new Rect();
    private static final String sPathPrefix = "/data/system/customized_icons/";
    private static final int sRGBMask = 0xffffff;
    private static final Resources sSystemResource;

    static  {
        boolean flag = true;
        sSystemResource = Resources.getSystem();
        sDensity = sSystemResource.getDisplayMetrics().densityDpi;
        sIconWidth = scalePixel(72);
        sIconHeight = scalePixel(72);
        sCustomizedIconWidth = scalePixel(90);
        sCustomizedIconHeight = scalePixel(90);
        sCanvas = new Canvas();
        sCanvas.setDrawFilter(new PaintFlagsDrawFilter(4, 2));
        if(SystemProperties.getInt("sys.ui.app-icon-background", flag) == flag)
            flag = false;
        sExcludeAll = Boolean.valueOf(flag);
        sIconMapping = new HashMap();
        sIconMapping.put("com.android.contacts.activities.TwelveKeyDialer.png", "com.android.contacts.TwelveKeyDialer.png");
        sIconMapping.put("com.miui.weather2.png", "com.miui.weather.png");
        sIconMapping.put("com.miui.gallery.png", "com.android.gallery.png");
        sIconMapping.put("com.android.gallery3d.png", "com.cooliris.media.png");
        sIconMapping.put("com.xiaomi.market.png", "com.miui.supermarket.png");
        sIconMapping.put("com.wali.miui.networkassistant.png", "com.android.monitor.png");
        sIconMapping.put("com.android.camera.CameraEntry.png", "com.miui.camera.png");
        sIconMapping.put("com.htc.album.png", "com.miui.gallery.png");
        sIconMapping.put("com.htc.fm.activity.FMRadioMain.png", "com.miui.fmradio.png");
        sIconMapping.put("com.htc.fm.FMRadio.png", "com.miui.fmradio.png");
        sIconMapping.put("com.sec.android.app.camera.Camera.png", "com.miui.camera.png");
        sIconMapping.put("com.sec.android.app.fm.png", "com.miui.fmradio.png");
        sIconMapping.put("com.android.hwcamera.png", "com.miui.camera.png");
        sIconMapping.put("com.huawei.android.FMRadio.png", "com.miui.fmradio.png");
        sIconMapping.put("com.sonyericsson.android.camera.png", "com.miui.camera.png");
        sIconMapping.put("com.sonyericsson.fmradio.png", "com.miui.fmradio.png");
        sIconMapping.put("com.motorola.Camera.Camera.png", "com.miui.camera.png");
        sIconMapping.put("com.lge.camera.png", "com.miui.camera.png");
    }
}
