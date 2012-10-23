// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;


// Referenced classes of package android.webkit:
//            MustOverrideException

public abstract class WebSettings {
    public static final class PluginState extends Enum {

        public static PluginState valueOf(String s) {
            return (PluginState)Enum.valueOf(android/webkit/WebSettings$PluginState, s);
        }

        public static PluginState[] values() {
            return (PluginState[])$VALUES.clone();
        }

        private static final PluginState $VALUES[];
        public static final PluginState OFF;
        public static final PluginState ON;
        public static final PluginState ON_DEMAND;

        static  {
            ON = new PluginState("ON", 0);
            ON_DEMAND = new PluginState("ON_DEMAND", 1);
            OFF = new PluginState("OFF", 2);
            PluginState apluginstate[] = new PluginState[3];
            apluginstate[0] = ON;
            apluginstate[1] = ON_DEMAND;
            apluginstate[2] = OFF;
            $VALUES = apluginstate;
        }

        private PluginState(String s, int i) {
            super(s, i);
        }
    }

    public static final class RenderPriority extends Enum {

        public static RenderPriority valueOf(String s) {
            return (RenderPriority)Enum.valueOf(android/webkit/WebSettings$RenderPriority, s);
        }

        public static RenderPriority[] values() {
            return (RenderPriority[])$VALUES.clone();
        }

        private static final RenderPriority $VALUES[];
        public static final RenderPriority HIGH;
        public static final RenderPriority LOW;
        public static final RenderPriority NORMAL;

        static  {
            NORMAL = new RenderPriority("NORMAL", 0);
            HIGH = new RenderPriority("HIGH", 1);
            LOW = new RenderPriority("LOW", 2);
            RenderPriority arenderpriority[] = new RenderPriority[3];
            arenderpriority[0] = NORMAL;
            arenderpriority[1] = HIGH;
            arenderpriority[2] = LOW;
            $VALUES = arenderpriority;
        }

        private RenderPriority(String s, int i) {
            super(s, i);
        }
    }

    public static final class ZoomDensity extends Enum {

        public static ZoomDensity valueOf(String s) {
            return (ZoomDensity)Enum.valueOf(android/webkit/WebSettings$ZoomDensity, s);
        }

        public static ZoomDensity[] values() {
            return (ZoomDensity[])$VALUES.clone();
        }

        private static final ZoomDensity $VALUES[];
        public static final ZoomDensity CLOSE;
        public static final ZoomDensity FAR;
        public static final ZoomDensity MEDIUM;
        int value;

        static  {
            FAR = new ZoomDensity("FAR", 0, 150);
            MEDIUM = new ZoomDensity("MEDIUM", 1, 100);
            CLOSE = new ZoomDensity("CLOSE", 2, 75);
            ZoomDensity azoomdensity[] = new ZoomDensity[3];
            azoomdensity[0] = FAR;
            azoomdensity[1] = MEDIUM;
            azoomdensity[2] = CLOSE;
            $VALUES = azoomdensity;
        }

        private ZoomDensity(String s, int i, int j) {
            super(s, i);
            value = j;
        }
    }

    public static final class TextSize extends Enum {

        public static TextSize valueOf(String s) {
            return (TextSize)Enum.valueOf(android/webkit/WebSettings$TextSize, s);
        }

        public static TextSize[] values() {
            return (TextSize[])$VALUES.clone();
        }

        private static final TextSize $VALUES[];
        public static final TextSize LARGER;
        public static final TextSize LARGEST;
        public static final TextSize NORMAL;
        public static final TextSize SMALLER;
        public static final TextSize SMALLEST;
        int value;

        static  {
            SMALLEST = new TextSize("SMALLEST", 0, 50);
            SMALLER = new TextSize("SMALLER", 1, 75);
            NORMAL = new TextSize("NORMAL", 2, 100);
            LARGER = new TextSize("LARGER", 3, 150);
            LARGEST = new TextSize("LARGEST", 4, 200);
            TextSize atextsize[] = new TextSize[5];
            atextsize[0] = SMALLEST;
            atextsize[1] = SMALLER;
            atextsize[2] = NORMAL;
            atextsize[3] = LARGER;
            atextsize[4] = LARGEST;
            $VALUES = atextsize;
        }

        private TextSize(String s, int i, int j) {
            super(s, i);
            value = j;
        }
    }

    public static final class LayoutAlgorithm extends Enum {

        public static LayoutAlgorithm valueOf(String s) {
            return (LayoutAlgorithm)Enum.valueOf(android/webkit/WebSettings$LayoutAlgorithm, s);
        }

        public static LayoutAlgorithm[] values() {
            return (LayoutAlgorithm[])$VALUES.clone();
        }

        private static final LayoutAlgorithm $VALUES[];
        public static final LayoutAlgorithm NARROW_COLUMNS;
        public static final LayoutAlgorithm NORMAL;
        public static final LayoutAlgorithm SINGLE_COLUMN;

        static  {
            NORMAL = new LayoutAlgorithm("NORMAL", 0);
            SINGLE_COLUMN = new LayoutAlgorithm("SINGLE_COLUMN", 1);
            NARROW_COLUMNS = new LayoutAlgorithm("NARROW_COLUMNS", 2);
            LayoutAlgorithm alayoutalgorithm[] = new LayoutAlgorithm[3];
            alayoutalgorithm[0] = NORMAL;
            alayoutalgorithm[1] = SINGLE_COLUMN;
            alayoutalgorithm[2] = NARROW_COLUMNS;
            $VALUES = alayoutalgorithm;
        }

        private LayoutAlgorithm(String s, int i) {
            super(s, i);
        }
    }


    protected WebSettings() {
    }

    public boolean enableSmoothTransition() {
        throw new MustOverrideException();
    }

    public boolean getAllowContentAccess() {
        throw new MustOverrideException();
    }

    public boolean getAllowFileAccess() {
        throw new MustOverrideException();
    }

    public abstract boolean getAllowFileAccessFromFileURLs();

    public abstract boolean getAllowUniversalAccessFromFileURLs();

    /**
     * @deprecated Method getBlockNetworkImage is deprecated
     */

    public boolean getBlockNetworkImage() {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method getBlockNetworkLoads is deprecated
     */

    public boolean getBlockNetworkLoads() {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean getBuiltInZoomControls() {
        throw new MustOverrideException();
    }

    public int getCacheMode() {
        throw new MustOverrideException();
    }

    /**
     * @deprecated Method getCursiveFontFamily is deprecated
     */

    public String getCursiveFontFamily() {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method getDatabaseEnabled is deprecated
     */

    public boolean getDatabaseEnabled() {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method getDatabasePath is deprecated
     */

    public String getDatabasePath() {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method getDefaultFixedFontSize is deprecated
     */

    public int getDefaultFixedFontSize() {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method getDefaultFontSize is deprecated
     */

    public int getDefaultFontSize() {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method getDefaultTextEncodingName is deprecated
     */

    public String getDefaultTextEncodingName() {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public ZoomDensity getDefaultZoom() {
        throw new MustOverrideException();
    }

    public boolean getDisplayZoomControls() {
        throw new MustOverrideException();
    }

    /**
     * @deprecated Method getDomStorageEnabled is deprecated
     */

    public boolean getDomStorageEnabled() {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method getFantasyFontFamily is deprecated
     */

    public String getFantasyFontFamily() {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method getFixedFontFamily is deprecated
     */

    public String getFixedFontFamily() {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method getJavaScriptCanOpenWindowsAutomatically is deprecated
     */

    public boolean getJavaScriptCanOpenWindowsAutomatically() {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method getJavaScriptEnabled is deprecated
     */

    public boolean getJavaScriptEnabled() {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method getLayoutAlgorithm is deprecated
     */

    public LayoutAlgorithm getLayoutAlgorithm() {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean getLightTouchEnabled() {
        throw new MustOverrideException();
    }

    public boolean getLoadWithOverviewMode() {
        throw new MustOverrideException();
    }

    /**
     * @deprecated Method getLoadsImagesAutomatically is deprecated
     */

    public boolean getLoadsImagesAutomatically() {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method getMinimumFontSize is deprecated
     */

    public int getMinimumFontSize() {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method getMinimumLogicalFontSize is deprecated
     */

    public int getMinimumLogicalFontSize() {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean getNavDump() {
        throw new MustOverrideException();
    }

    /**
     * @deprecated Method getPluginState is deprecated
     */

    public PluginState getPluginState() {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method getPluginsEnabled is deprecated
     */

    public boolean getPluginsEnabled() {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method getPluginsPath is deprecated
     */

    public String getPluginsPath() {
        this;
        JVM INSTR monitorenter ;
        return "";
    }

    /**
     * @deprecated Method getSansSerifFontFamily is deprecated
     */

    public String getSansSerifFontFamily() {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean getSaveFormData() {
        throw new MustOverrideException();
    }

    public boolean getSavePassword() {
        throw new MustOverrideException();
    }

    /**
     * @deprecated Method getSerifFontFamily is deprecated
     */

    public String getSerifFontFamily() {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method getStandardFontFamily is deprecated
     */

    public String getStandardFontFamily() {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method getTextSize is deprecated
     */

    public TextSize getTextSize() {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method getTextZoom is deprecated
     */

    public int getTextZoom() {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method getUseDoubleTree is deprecated
     */

    public boolean getUseDoubleTree() {
        this;
        JVM INSTR monitorenter ;
        return false;
    }

    public boolean getUseWebViewBackgroundForOverscrollBackground() {
        throw new MustOverrideException();
    }

    /**
     * @deprecated Method getUseWideViewPort is deprecated
     */

    public boolean getUseWideViewPort() {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method getUserAgent is deprecated
     */

    public int getUserAgent() {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method getUserAgentString is deprecated
     */

    public String getUserAgentString() {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setAllowContentAccess(boolean flag) {
        throw new MustOverrideException();
    }

    public void setAllowFileAccess(boolean flag) {
        throw new MustOverrideException();
    }

    public abstract void setAllowFileAccessFromFileURLs(boolean flag);

    public abstract void setAllowUniversalAccessFromFileURLs(boolean flag);

    /**
     * @deprecated Method setAppCacheEnabled is deprecated
     */

    public void setAppCacheEnabled(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method setAppCacheMaxSize is deprecated
     */

    public void setAppCacheMaxSize(long l) {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method setAppCachePath is deprecated
     */

    public void setAppCachePath(String s) {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method setBlockNetworkImage is deprecated
     */

    public void setBlockNetworkImage(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method setBlockNetworkLoads is deprecated
     */

    public void setBlockNetworkLoads(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setBuiltInZoomControls(boolean flag) {
        throw new MustOverrideException();
    }

    public void setCacheMode(int i) {
        throw new MustOverrideException();
    }

    /**
     * @deprecated Method setCursiveFontFamily is deprecated
     */

    public void setCursiveFontFamily(String s) {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method setDatabaseEnabled is deprecated
     */

    public void setDatabaseEnabled(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method setDatabasePath is deprecated
     */

    public void setDatabasePath(String s) {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method setDefaultFixedFontSize is deprecated
     */

    public void setDefaultFixedFontSize(int i) {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method setDefaultFontSize is deprecated
     */

    public void setDefaultFontSize(int i) {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method setDefaultTextEncodingName is deprecated
     */

    public void setDefaultTextEncodingName(String s) {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setDefaultZoom(ZoomDensity zoomdensity) {
        throw new MustOverrideException();
    }

    public void setDisplayZoomControls(boolean flag) {
        throw new MustOverrideException();
    }

    /**
     * @deprecated Method setDomStorageEnabled is deprecated
     */

    public void setDomStorageEnabled(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setEnableSmoothTransition(boolean flag) {
        throw new MustOverrideException();
    }

    /**
     * @deprecated Method setFantasyFontFamily is deprecated
     */

    public void setFantasyFontFamily(String s) {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method setFixedFontFamily is deprecated
     */

    public void setFixedFontFamily(String s) {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method setGeolocationDatabasePath is deprecated
     */

    public void setGeolocationDatabasePath(String s) {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method setGeolocationEnabled is deprecated
     */

    public void setGeolocationEnabled(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method setJavaScriptCanOpenWindowsAutomatically is deprecated
     */

    public void setJavaScriptCanOpenWindowsAutomatically(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method setJavaScriptEnabled is deprecated
     */

    public void setJavaScriptEnabled(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method setLayoutAlgorithm is deprecated
     */

    public void setLayoutAlgorithm(LayoutAlgorithm layoutalgorithm) {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setLightTouchEnabled(boolean flag) {
        throw new MustOverrideException();
    }

    public void setLoadWithOverviewMode(boolean flag) {
        throw new MustOverrideException();
    }

    /**
     * @deprecated Method setLoadsImagesAutomatically is deprecated
     */

    public void setLoadsImagesAutomatically(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method setMinimumFontSize is deprecated
     */

    public void setMinimumFontSize(int i) {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method setMinimumLogicalFontSize is deprecated
     */

    public void setMinimumLogicalFontSize(int i) {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setNavDump(boolean flag) {
        throw new MustOverrideException();
    }

    public void setNeedInitialFocus(boolean flag) {
        throw new MustOverrideException();
    }

    /**
     * @deprecated Method setPluginState is deprecated
     */

    public void setPluginState(PluginState pluginstate) {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method setPluginsEnabled is deprecated
     */

    public void setPluginsEnabled(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method setPluginsPath is deprecated
     */

    public void setPluginsPath(String s) {
        this;
        JVM INSTR monitorenter ;
    }

    /**
     * @deprecated Method setRenderPriority is deprecated
     */

    public void setRenderPriority(RenderPriority renderpriority) {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method setSansSerifFontFamily is deprecated
     */

    public void setSansSerifFontFamily(String s) {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setSaveFormData(boolean flag) {
        throw new MustOverrideException();
    }

    public void setSavePassword(boolean flag) {
        throw new MustOverrideException();
    }

    /**
     * @deprecated Method setSerifFontFamily is deprecated
     */

    public void setSerifFontFamily(String s) {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method setStandardFontFamily is deprecated
     */

    public void setStandardFontFamily(String s) {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method setSupportMultipleWindows is deprecated
     */

    public void setSupportMultipleWindows(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setSupportZoom(boolean flag) {
        throw new MustOverrideException();
    }

    /**
     * @deprecated Method setTextSize is deprecated
     */

    public void setTextSize(TextSize textsize) {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method setTextZoom is deprecated
     */

    public void setTextZoom(int i) {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method setUseDoubleTree is deprecated
     */

    public void setUseDoubleTree(boolean flag) {
        this;
        JVM INSTR monitorenter ;
    }

    public void setUseWebViewBackgroundForOverscrollBackground(boolean flag) {
        throw new MustOverrideException();
    }

    /**
     * @deprecated Method setUseWideViewPort is deprecated
     */

    public void setUseWideViewPort(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method setUserAgent is deprecated
     */

    public void setUserAgent(int i) {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method setUserAgentString is deprecated
     */

    public void setUserAgentString(String s) {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method supportMultipleWindows is deprecated
     */

    public boolean supportMultipleWindows() {
        this;
        JVM INSTR monitorenter ;
        throw new MustOverrideException();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean supportZoom() {
        throw new MustOverrideException();
    }

    public static final int LOAD_CACHE_ELSE_NETWORK = 1;
    public static final int LOAD_CACHE_ONLY = 3;
    public static final int LOAD_DEFAULT = -1;
    public static final int LOAD_NORMAL = 0;
    public static final int LOAD_NO_CACHE = 2;
}
