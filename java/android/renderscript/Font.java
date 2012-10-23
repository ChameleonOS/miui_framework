// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.renderscript;

import android.content.res.Resources;
import android.os.Environment;
import android.util.DisplayMetrics;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package android.renderscript:
//            BaseObj, RenderScript, RSRuntimeException

public class Font extends BaseObj {
    public static final class Style extends Enum {

        public static Style valueOf(String s) {
            return (Style)Enum.valueOf(android/renderscript/Font$Style, s);
        }

        public static Style[] values() {
            return (Style[])$VALUES.clone();
        }

        private static final Style $VALUES[];
        public static final Style BOLD;
        public static final Style BOLD_ITALIC;
        public static final Style ITALIC;
        public static final Style NORMAL;

        static  {
            NORMAL = new Style("NORMAL", 0);
            BOLD = new Style("BOLD", 1);
            ITALIC = new Style("ITALIC", 2);
            BOLD_ITALIC = new Style("BOLD_ITALIC", 3);
            Style astyle[] = new Style[4];
            astyle[0] = NORMAL;
            astyle[1] = BOLD;
            astyle[2] = ITALIC;
            astyle[3] = BOLD_ITALIC;
            $VALUES = astyle;
        }

        private Style(String s, int i) {
            super(s, i);
        }
    }

    private static class FontFamily {

        String mBoldFileName;
        String mBoldItalicFileName;
        String mItalicFileName;
        String mNames[];
        String mNormalFileName;

        private FontFamily() {
        }

    }


    Font(int i, RenderScript renderscript) {
        super(i, renderscript);
    }

    private static void addFamilyToMap(FontFamily fontfamily) {
        for(int i = 0; i < fontfamily.mNames.length; i++)
            sFontFamilyMap.put(fontfamily.mNames[i], fontfamily);

    }

    public static Font create(RenderScript renderscript, Resources resources, String s, Style style, float f) {
        String s1 = getFontFileName(s, style);
        String s2 = Environment.getRootDirectory().getAbsolutePath();
        return createFromFile(renderscript, resources, (new StringBuilder()).append(s2).append("/fonts/").append(s1).toString(), f);
    }

    public static Font createFromAsset(RenderScript renderscript, Resources resources, String s, float f) {
        renderscript.validate();
        int i = renderscript.nFontCreateFromAsset(resources.getAssets(), s, f, resources.getDisplayMetrics().densityDpi);
        if(i == 0)
            throw new RSRuntimeException((new StringBuilder()).append("Unable to create font from asset ").append(s).toString());
        else
            return new Font(i, renderscript);
    }

    public static Font createFromFile(RenderScript renderscript, Resources resources, File file, float f) {
        return createFromFile(renderscript, resources, file.getAbsolutePath(), f);
    }

    public static Font createFromFile(RenderScript renderscript, Resources resources, String s, float f) {
        renderscript.validate();
        int i = renderscript.nFontCreateFromFile(s, f, resources.getDisplayMetrics().densityDpi);
        if(i == 0)
            throw new RSRuntimeException((new StringBuilder()).append("Unable to create font from file ").append(s).toString());
        else
            return new Font(i, renderscript);
    }

    public static Font createFromResource(RenderScript renderscript, Resources resources, int i, float f) {
        String s = (new StringBuilder()).append("R.").append(Integer.toString(i)).toString();
        renderscript.validate();
        java.io.InputStream inputstream;
        int j;
        try {
            inputstream = resources.openRawResource(i);
        }
        catch(Exception exception) {
            throw new RSRuntimeException((new StringBuilder()).append("Unable to open resource ").append(i).toString());
        }
        j = resources.getDisplayMetrics().densityDpi;
        if(inputstream instanceof android.content.res.AssetManager.AssetInputStream) {
            int k = renderscript.nFontCreateFromAssetStream(s, f, j, ((android.content.res.AssetManager.AssetInputStream)inputstream).getAssetInt());
            if(k == 0)
                throw new RSRuntimeException((new StringBuilder()).append("Unable to create font from resource ").append(i).toString());
            else
                return new Font(k, renderscript);
        } else {
            throw new RSRuntimeException("Unsupported asset stream created");
        }
    }

    static String getFontFileName(String s, Style style) {
        FontFamily fontfamily = (FontFamily)sFontFamilyMap.get(s);
        if(fontfamily == null) goto _L2; else goto _L1
_L1:
        class _cls1 {

            static final int $SwitchMap$android$renderscript$Font$Style[];

            static  {
                $SwitchMap$android$renderscript$Font$Style = new int[Style.values().length];
                NoSuchFieldError nosuchfielderror3;
                try {
                    $SwitchMap$android$renderscript$Font$Style[Style.NORMAL.ordinal()] = 1;
                }
                catch(NoSuchFieldError nosuchfielderror) { }
                try {
                    $SwitchMap$android$renderscript$Font$Style[Style.BOLD.ordinal()] = 2;
                }
                catch(NoSuchFieldError nosuchfielderror1) { }
                try {
                    $SwitchMap$android$renderscript$Font$Style[Style.ITALIC.ordinal()] = 3;
                }
                catch(NoSuchFieldError nosuchfielderror2) { }
                $SwitchMap$android$renderscript$Font$Style[Style.BOLD_ITALIC.ordinal()] = 4;
_L2:
                return;
                nosuchfielderror3;
                if(true) goto _L2; else goto _L1
_L1:
            }
        }

        _cls1..SwitchMap.android.renderscript.Font.Style[style.ordinal()];
        JVM INSTR tableswitch 1 4: default 56
    //                   1 61
    //                   2 69
    //                   3 77
    //                   4 85;
           goto _L2 _L3 _L4 _L5 _L6
_L2:
        String s1 = "DroidSans.ttf";
_L8:
        return s1;
_L3:
        s1 = fontfamily.mNormalFileName;
        continue; /* Loop/switch isn't completed */
_L4:
        s1 = fontfamily.mBoldFileName;
        continue; /* Loop/switch isn't completed */
_L5:
        s1 = fontfamily.mItalicFileName;
        continue; /* Loop/switch isn't completed */
_L6:
        s1 = fontfamily.mBoldItalicFileName;
        if(true) goto _L8; else goto _L7
_L7:
    }

    private static void initFontFamilyMap() {
        sFontFamilyMap = new HashMap();
        FontFamily fontfamily = new FontFamily(null);
        fontfamily.mNames = sSansNames;
        fontfamily.mNormalFileName = "Roboto-Regular.ttf";
        fontfamily.mBoldFileName = "Roboto-Bold.ttf";
        fontfamily.mItalicFileName = "Roboto-Italic.ttf";
        fontfamily.mBoldItalicFileName = "Roboto-BoldItalic.ttf";
        addFamilyToMap(fontfamily);
        FontFamily fontfamily1 = new FontFamily(null);
        fontfamily1.mNames = sSerifNames;
        fontfamily1.mNormalFileName = "DroidSerif-Regular.ttf";
        fontfamily1.mBoldFileName = "DroidSerif-Bold.ttf";
        fontfamily1.mItalicFileName = "DroidSerif-Italic.ttf";
        fontfamily1.mBoldItalicFileName = "DroidSerif-BoldItalic.ttf";
        addFamilyToMap(fontfamily1);
        FontFamily fontfamily2 = new FontFamily(null);
        fontfamily2.mNames = sMonoNames;
        fontfamily2.mNormalFileName = "DroidSansMono.ttf";
        fontfamily2.mBoldFileName = "DroidSansMono.ttf";
        fontfamily2.mItalicFileName = "DroidSansMono.ttf";
        fontfamily2.mBoldItalicFileName = "DroidSansMono.ttf";
        addFamilyToMap(fontfamily2);
    }

    private static Map sFontFamilyMap;
    private static final String sMonoNames[];
    private static final String sSansNames[];
    private static final String sSerifNames[];

    static  {
        String as[] = new String[5];
        as[0] = "sans-serif";
        as[1] = "arial";
        as[2] = "helvetica";
        as[3] = "tahoma";
        as[4] = "verdana";
        sSansNames = as;
        String as1[] = new String[10];
        as1[0] = "serif";
        as1[1] = "times";
        as1[2] = "times new roman";
        as1[3] = "palatino";
        as1[4] = "georgia";
        as1[5] = "baskerville";
        as1[6] = "goudy";
        as1[7] = "fantasy";
        as1[8] = "cursive";
        as1[9] = "ITC Stone Serif";
        sSerifNames = as1;
        String as2[] = new String[4];
        as2[0] = "monospace";
        as2[1] = "courier";
        as2[2] = "courier new";
        as2[3] = "monaco";
        sMonoNames = as2;
        initFontFamilyMap();
    }
}
