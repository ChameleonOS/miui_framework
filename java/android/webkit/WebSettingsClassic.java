// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.webkit;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.os.*;
import android.util.EventLog;
import java.util.Locale;

// Referenced classes of package android.webkit:
//            WebSettings, WebViewClassic, BrowserFrame

public class WebSettingsClassic extends WebSettings {
    private class EventHandler {

        /**
         * @deprecated Method createHandler is deprecated
         */

        private void createHandler() {
            this;
            JVM INSTR monitorenter ;
            setRenderPriority();
            mHandler = new Handler() {

                public void handleMessage(Message message) {
                    message.what;
                    JVM INSTR tableswitch 0 2: default 32
                //                               0 33
                //                               1 110
                //                               2 120;
                       goto _L1 _L2 _L3 _L4
_L1:
                    return;
_L2:
                    WebSettingsClassic websettingsclassic = _fld0;
                    websettingsclassic;
                    JVM INSTR monitorenter ;
                    if(mBrowserFrame.mNativeFrame != 0)
                        nativeSync(mBrowserFrame.mNativeFrame);
                    mSyncPending = false;
                    continue; /* Loop/switch isn't completed */
_L3:
                    setRenderPriority();
                    continue; /* Loop/switch isn't completed */
_L4:
                    android.content.SharedPreferences.Editor editor = mContext.getSharedPreferences("WebViewSettings", 0).edit();
                    editor.putInt("double_tap_toast_count", WebSettingsClassic.mDoubleTapToastCount);
                    editor.commit();
                    if(true) goto _L1; else goto _L5
_L5:
                }

                final EventHandler this$1;

                 {
                    this$1 = EventHandler.this;
                    super();
                }
            };
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        /**
         * @deprecated Method sendMessage is deprecated
         */

        private boolean sendMessage(Message message) {
            this;
            JVM INSTR monitorenter ;
            if(mHandler == null) goto _L2; else goto _L1
_L1:
            mHandler.sendMessage(message);
            boolean flag = true;
_L4:
            this;
            JVM INSTR monitorexit ;
            return flag;
_L2:
            flag = false;
            if(true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            throw exception;
        }

        private void setRenderPriority() {
            WebSettingsClassic websettingsclassic = WebSettingsClassic.this;
            websettingsclassic;
            JVM INSTR monitorenter ;
            if(mRenderPriority != WebSettings.RenderPriority.NORMAL) goto _L2; else goto _L1
_L1:
            Process.setThreadPriority(0);
_L5:
            websettingsclassic;
            JVM INSTR monitorexit ;
            return;
_L2:
            if(mRenderPriority != WebSettings.RenderPriority.HIGH) goto _L4; else goto _L3
_L3:
            Process.setThreadPriority(-1);
              goto _L5
            Exception exception;
            exception;
            throw exception;
_L4:
            if(mRenderPriority != WebSettings.RenderPriority.LOW) goto _L5; else goto _L6
_L6:
            Process.setThreadPriority(10);
              goto _L5
        }

        static final int PRIORITY = 1;
        static final int SET_DOUBLE_TAP_TOAST_COUNT = 2;
        static final int SYNC;
        private Handler mHandler;
        final WebSettingsClassic this$0;




        private EventHandler() {
            this$0 = WebSettingsClassic.this;
            super();
        }

    }

    public static class AutoFillProfile {

        public String getAddressLine1() {
            return mAddressLine1;
        }

        public String getAddressLine2() {
            return mAddressLine2;
        }

        public String getCity() {
            return mCity;
        }

        public String getCompanyName() {
            return mCompanyName;
        }

        public String getCountry() {
            return mCountry;
        }

        public String getEmailAddress() {
            return mEmailAddress;
        }

        public String getFullName() {
            return mFullName;
        }

        public String getPhoneNumber() {
            return mPhoneNumber;
        }

        public String getState() {
            return mState;
        }

        public int getUniqueId() {
            return mUniqueId;
        }

        public String getZipCode() {
            return mZipCode;
        }

        private String mAddressLine1;
        private String mAddressLine2;
        private String mCity;
        private String mCompanyName;
        private String mCountry;
        private String mEmailAddress;
        private String mFullName;
        private String mPhoneNumber;
        private String mState;
        private int mUniqueId;
        private String mZipCode;

        public AutoFillProfile(int i, String s, String s1, String s2, String s3, String s4, String s5, 
                String s6, String s7, String s8, String s9) {
            mUniqueId = i;
            mFullName = s;
            mEmailAddress = s1;
            mCompanyName = s2;
            mAddressLine1 = s3;
            mAddressLine2 = s4;
            mCity = s5;
            mState = s6;
            mZipCode = s7;
            mCountry = s8;
            mPhoneNumber = s9;
        }
    }


    WebSettingsClassic(Context context, WebViewClassic webviewclassic) {
        boolean flag = false;
        super();
        mSyncPending = false;
        mLayoutAlgorithm = WebSettings.LayoutAlgorithm.NARROW_COLUMNS;
        mTextSize = 100;
        mNightReadMode = false;
        mStandardFontFamily = "sans-serif";
        mFixedFontFamily = "monospace";
        mSansSerifFontFamily = "sans-serif";
        mSerifFontFamily = "serif";
        mCursiveFontFamily = "cursive";
        mFantasyFontFamily = "fantasy";
        mMinimumFontSize = 8;
        mMinimumLogicalFontSize = 8;
        mDefaultFontSize = 16;
        mDefaultFixedFontSize = 13;
        mPageCacheCapacity = 0;
        mLoadsImagesAutomatically = true;
        mBlockNetworkImage = false;
        mJavaScriptEnabled = false;
        mAllowUniversalAccessFromFileURLs = false;
        mAllowFileAccessFromFileURLs = false;
        mHardwareAccelSkia = false;
        mShowVisualIndicator = false;
        mPluginState = WebSettings.PluginState.OFF;
        mJavaScriptCanOpenWindowsAutomatically = false;
        mUseDoubleTree = false;
        mUseWideViewport = false;
        mSupportMultipleWindows = false;
        mShrinksStandaloneImagesToFit = false;
        mMaximumDecodedImageSize = 0L;
        mPrivateBrowsingEnabled = false;
        mSyntheticLinksEnabled = true;
        mAppCacheEnabled = false;
        mDatabaseEnabled = false;
        mDomStorageEnabled = false;
        mWorkersEnabled = false;
        mGeolocationEnabled = true;
        mXSSAuditorEnabled = false;
        mLinkPrefetchEnabled = false;
        mAppCacheMaxSize = 0x7fffffffffffffffL;
        mAppCachePath = null;
        mDatabasePath = "";
        mDatabasePathHasBeenSet = false;
        mGeolocationDatabasePath = "";
        mDefaultZoom = WebSettings.ZoomDensity.MEDIUM;
        mRenderPriority = WebSettings.RenderPriority.NORMAL;
        mOverrideCacheMode = -1;
        mDoubleTapZoom = 100;
        mSaveFormData = true;
        mAutoFillEnabled = false;
        mSavePassword = true;
        mLightTouchEnabled = false;
        mNeedInitialFocus = true;
        mNavDump = false;
        mSupportZoom = true;
        mBuiltInZoomControls = false;
        mDisplayZoomControls = true;
        mAllowFileAccess = true;
        mAllowContentAccess = true;
        mLoadWithOverviewMode = false;
        mEnableSmoothTransition = false;
        mForceUserScalable = false;
        mPasswordEchoEnabled = true;
        mUseWebViewBackgroundForOverscroll = true;
        mEventHandler = new EventHandler();
        mContext = context;
        mWebView = webviewclassic;
        mDefaultTextEncoding = context.getString(0x10400ba);
        if(sLockForLocaleSettings == null) {
            sLockForLocaleSettings = new Object();
            sLocale = Locale.getDefault();
        }
        mAcceptLanguage = getCurrentAcceptLanguage();
        mUserAgent = getCurrentUserAgent();
        mUseDefaultUserAgent = true;
        boolean flag1;
        if(mContext.checkPermission("android.permission.INTERNET", Process.myPid(), Process.myUid()) != 0)
            flag1 = true;
        else
            flag1 = false;
        mBlockNetworkLoads = flag1;
        if(mContext.getApplicationInfo().targetSdkVersion < 16) {
            mAllowUniversalAccessFromFileURLs = true;
            mAllowFileAccessFromFileURLs = true;
        }
        if(android.provider.Settings.System.getInt(context.getContentResolver(), "show_password") != 0)
            flag = true;
        mPasswordEchoEnabled = flag;
_L1:
        return;
        android.provider.Settings.SettingNotFoundException settingnotfoundexception;
        settingnotfoundexception;
        mPasswordEchoEnabled = true;
          goto _L1
    }

    private static void addLocaleToHttpAcceptLanguage(StringBuilder stringbuilder, Locale locale) {
        String s = convertObsoleteLanguageCodeToNew(locale.getLanguage());
        if(s != null) {
            stringbuilder.append(s);
            String s1 = locale.getCountry();
            if(s1 != null) {
                stringbuilder.append("-");
                stringbuilder.append(s1);
            }
        }
    }

    private static String convertObsoleteLanguageCodeToNew(String s) {
        if(s != null) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        return s;
_L2:
        if("iw".equals(s))
            s = "he";
        else
        if("in".equals(s))
            s = "id";
        else
        if("ji".equals(s))
            s = "yi";
        if(true) goto _L4; else goto _L3
_L3:
    }

    private String getCurrentAcceptLanguage() {
        Locale locale;
        synchronized(sLockForLocaleSettings) {
            locale = sLocale;
        }
        StringBuilder stringbuilder = new StringBuilder();
        addLocaleToHttpAcceptLanguage(stringbuilder, locale);
        if(!Locale.US.equals(locale)) {
            if(stringbuilder.length() > 0)
                stringbuilder.append(", ");
            stringbuilder.append("en-US");
        }
        return stringbuilder.toString();
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    /**
     * @deprecated Method getCurrentUserAgent is deprecated
     */

    private String getCurrentUserAgent() {
        this;
        JVM INSTR monitorenter ;
        Locale locale;
        synchronized(sLockForLocaleSettings) {
            locale = sLocale;
        }
        StringBuffer stringbuffer;
        String s;
        stringbuffer = new StringBuffer();
        s = android.os.Build.VERSION.RELEASE;
        if(s.length() <= 0) goto _L2; else goto _L1
_L1:
        if(!Character.isDigit(s.charAt(0))) goto _L4; else goto _L3
_L3:
        stringbuffer.append(s);
_L5:
        stringbuffer.append("; ");
        String s1 = locale.getLanguage();
        if(s1 == null)
            break MISSING_BLOCK_LABEL_303;
        stringbuffer.append(convertObsoleteLanguageCodeToNew(s1));
        String s7 = locale.getCountry();
        if(s7 != null) {
            stringbuffer.append("-");
            stringbuffer.append(s7.toLowerCase());
        }
_L6:
        String s5;
        stringbuffer.append(";");
        if("REL".equals(android.os.Build.VERSION.CODENAME)) {
            String s6 = Build.MODEL;
            if(s6.length() > 0) {
                stringbuffer.append(" ");
                stringbuffer.append(s6);
            }
        }
        String s2 = Build.ID;
        if(s2.length() > 0) {
            stringbuffer.append(" Build/");
            stringbuffer.append(s2);
        }
        String s3 = mContext.getResources().getText(0x104033c).toString();
        String s4 = mContext.getResources().getText(0x104033b).toString();
        Object aobj[] = new Object[2];
        aobj[0] = stringbuffer;
        aobj[1] = s3;
        s5 = String.format(s4, aobj);
        this;
        JVM INSTR monitorexit ;
        return s5;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
_L4:
        stringbuffer.append("4.0.4");
          goto _L5
_L2:
        stringbuffer.append("1.0");
          goto _L5
        stringbuffer.append("en");
          goto _L6
    }

    private native void nativeSync(int i);

    private int pin(int i) {
        if(i >= 1) goto _L2; else goto _L1
_L1:
        i = 1;
_L4:
        return i;
_L2:
        if(i > 72)
            i = 72;
        if(true) goto _L4; else goto _L3
_L3:
    }

    /**
     * @deprecated Method postSync is deprecated
     */

    private void postSync() {
        this;
        JVM INSTR monitorenter ;
        if(!mSyncPending)
            mSyncPending = mEventHandler.sendMessage(Message.obtain(null, 0));
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void verifyNetworkAccess() {
        if(!mBlockNetworkLoads && mContext.checkPermission("android.permission.INTERNET", Process.myPid(), Process.myUid()) != 0)
            throw new SecurityException("Permission denied - application missing INTERNET permission");
        else
            return;
    }

    public boolean enableSmoothTransition() {
        return mEnableSmoothTransition;
    }

    public boolean forceUserScalable() {
        return mForceUserScalable;
    }

    /**
     * @deprecated Method getAcceptLanguage is deprecated
     */

    String getAcceptLanguage() {
        this;
        JVM INSTR monitorenter ;
        synchronized(sLockForLocaleSettings) {
            Locale locale = Locale.getDefault();
            if(!sLocale.equals(locale)) {
                sLocale = locale;
                mAcceptLanguage = getCurrentAcceptLanguage();
            }
        }
        String s = mAcceptLanguage;
        this;
        JVM INSTR monitorexit ;
        return s;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean getAllowContentAccess() {
        return mAllowContentAccess;
    }

    public boolean getAllowFileAccess() {
        return mAllowFileAccess;
    }

    /**
     * @deprecated Method getAllowFileAccessFromFileURLs is deprecated
     */

    public boolean getAllowFileAccessFromFileURLs() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mAllowFileAccessFromFileURLs;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getAllowUniversalAccessFromFileURLs is deprecated
     */

    public boolean getAllowUniversalAccessFromFileURLs() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mAllowUniversalAccessFromFileURLs;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getAutoFillEnabled is deprecated
     */

    public boolean getAutoFillEnabled() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mAutoFillEnabled;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getAutoFillProfile is deprecated
     */

    public AutoFillProfile getAutoFillProfile() {
        this;
        JVM INSTR monitorenter ;
        AutoFillProfile autofillprofile = mAutoFillProfile;
        this;
        JVM INSTR monitorexit ;
        return autofillprofile;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getBlockNetworkImage is deprecated
     */

    public boolean getBlockNetworkImage() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mBlockNetworkImage;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getBlockNetworkLoads is deprecated
     */

    public boolean getBlockNetworkLoads() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mBlockNetworkLoads;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean getBuiltInZoomControls() {
        return mBuiltInZoomControls;
    }

    public int getCacheMode() {
        return mOverrideCacheMode;
    }

    /**
     * @deprecated Method getCursiveFontFamily is deprecated
     */

    public String getCursiveFontFamily() {
        this;
        JVM INSTR monitorenter ;
        String s = mCursiveFontFamily;
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getDatabaseEnabled is deprecated
     */

    public boolean getDatabaseEnabled() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mDatabaseEnabled;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getDatabasePath is deprecated
     */

    public String getDatabasePath() {
        this;
        JVM INSTR monitorenter ;
        String s = mDatabasePath;
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getDefaultFixedFontSize is deprecated
     */

    public int getDefaultFixedFontSize() {
        this;
        JVM INSTR monitorenter ;
        int i = mDefaultFixedFontSize;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getDefaultFontSize is deprecated
     */

    public int getDefaultFontSize() {
        this;
        JVM INSTR monitorenter ;
        int i = mDefaultFontSize;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getDefaultTextEncodingName is deprecated
     */

    public String getDefaultTextEncodingName() {
        this;
        JVM INSTR monitorenter ;
        String s = mDefaultTextEncoding;
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public WebSettings.ZoomDensity getDefaultZoom() {
        return mDefaultZoom;
    }

    public boolean getDisplayZoomControls() {
        return mDisplayZoomControls;
    }

    /**
     * @deprecated Method getDomStorageEnabled is deprecated
     */

    public boolean getDomStorageEnabled() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mDomStorageEnabled;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    int getDoubleTapToastCount() {
        return mDoubleTapToastCount;
    }

    public int getDoubleTapZoom() {
        return mDoubleTapZoom;
    }

    /**
     * @deprecated Method getFantasyFontFamily is deprecated
     */

    public String getFantasyFontFamily() {
        this;
        JVM INSTR monitorenter ;
        String s = mFantasyFontFamily;
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getFixedFontFamily is deprecated
     */

    public String getFixedFontFamily() {
        this;
        JVM INSTR monitorenter ;
        String s = mFixedFontFamily;
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getHardwareAccelSkiaEnabled is deprecated
     */

    public boolean getHardwareAccelSkiaEnabled() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mHardwareAccelSkia;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getJavaScriptCanOpenWindowsAutomatically is deprecated
     */

    public boolean getJavaScriptCanOpenWindowsAutomatically() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mJavaScriptCanOpenWindowsAutomatically;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getJavaScriptEnabled is deprecated
     */

    public boolean getJavaScriptEnabled() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mJavaScriptEnabled;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getLayoutAlgorithm is deprecated
     */

    public WebSettings.LayoutAlgorithm getLayoutAlgorithm() {
        this;
        JVM INSTR monitorenter ;
        WebSettings.LayoutAlgorithm layoutalgorithm = mLayoutAlgorithm;
        this;
        JVM INSTR monitorexit ;
        return layoutalgorithm;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean getLightTouchEnabled() {
        return mLightTouchEnabled;
    }

    public boolean getLoadWithOverviewMode() {
        return mLoadWithOverviewMode;
    }

    /**
     * @deprecated Method getLoadsImagesAutomatically is deprecated
     */

    public boolean getLoadsImagesAutomatically() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mLoadsImagesAutomatically;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getMinimumFontSize is deprecated
     */

    public int getMinimumFontSize() {
        this;
        JVM INSTR monitorenter ;
        int i = mMinimumFontSize;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getMinimumLogicalFontSize is deprecated
     */

    public int getMinimumLogicalFontSize() {
        this;
        JVM INSTR monitorenter ;
        int i = mMinimumLogicalFontSize;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean getNavDump() {
        return mNavDump;
    }

    boolean getNeedInitialFocus() {
        return mNeedInitialFocus;
    }

    /**
     * @deprecated Method getNightReadModeEnabled is deprecated
     */

    public boolean getNightReadModeEnabled() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mNightReadMode;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getPluginState is deprecated
     */

    public WebSettings.PluginState getPluginState() {
        this;
        JVM INSTR monitorenter ;
        WebSettings.PluginState pluginstate = mPluginState;
        this;
        JVM INSTR monitorexit ;
        return pluginstate;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getPluginsEnabled is deprecated
     */

    public boolean getPluginsEnabled() {
        this;
        JVM INSTR monitorenter ;
        WebSettings.PluginState pluginstate;
        WebSettings.PluginState pluginstate1;
        pluginstate = mPluginState;
        pluginstate1 = WebSettings.PluginState.ON;
        boolean flag;
        if(pluginstate == pluginstate1)
            flag = true;
        else
            flag = false;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
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

    public String getProperty(String s) {
        return mWebView.nativeGetProperty(s);
    }

    /**
     * @deprecated Method getSansSerifFontFamily is deprecated
     */

    public String getSansSerifFontFamily() {
        this;
        JVM INSTR monitorenter ;
        String s = mSansSerifFontFamily;
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean getSaveFormData() {
        boolean flag;
        if(mSaveFormData && !mPrivateBrowsingEnabled)
            flag = true;
        else
            flag = false;
        return flag;
    }

    public boolean getSavePassword() {
        return mSavePassword;
    }

    /**
     * @deprecated Method getSerifFontFamily is deprecated
     */

    public String getSerifFontFamily() {
        this;
        JVM INSTR monitorenter ;
        String s = mSerifFontFamily;
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getShowVisualIndicator is deprecated
     */

    public boolean getShowVisualIndicator() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mShowVisualIndicator;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getStandardFontFamily is deprecated
     */

    public String getStandardFontFamily() {
        this;
        JVM INSTR monitorenter ;
        String s = mStandardFontFamily;
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getTextSize is deprecated
     */

    public WebSettings.TextSize getTextSize() {
        this;
        JVM INSTR monitorenter ;
        WebSettings.TextSize textsize;
        int i;
        textsize = null;
        i = 0x7fffffff;
        WebSettings.TextSize atextsize[];
        int j;
        int k;
        atextsize = WebSettings.TextSize.values();
        j = atextsize.length;
        k = 0;
_L5:
        if(k >= j) goto _L2; else goto _L1
_L1:
        WebSettings.TextSize textsize1;
        int l;
        textsize1 = atextsize[k];
        l = Math.abs(mTextSize - textsize1.value);
        if(l != 0) goto _L4; else goto _L3
_L3:
        this;
        JVM INSTR monitorexit ;
        return textsize1;
_L4:
        if(l < i) {
            i = l;
            textsize = textsize1;
        }
        k++;
          goto _L5
_L2:
        if(textsize == null)
            break MISSING_BLOCK_LABEL_88;
_L6:
        textsize1 = textsize;
          goto _L3
        textsize = WebSettings.TextSize.NORMAL;
          goto _L6
        Exception exception;
        exception;
        throw exception;
          goto _L5
    }

    /**
     * @deprecated Method getTextZoom is deprecated
     */

    public int getTextZoom() {
        this;
        JVM INSTR monitorenter ;
        int i = mTextSize;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
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

    boolean getUseFixedViewport() {
        return getUseWideViewPort();
    }

    public boolean getUseWebViewBackgroundForOverscrollBackground() {
        return mUseWebViewBackgroundForOverscroll;
    }

    /**
     * @deprecated Method getUseWideViewPort is deprecated
     */

    public boolean getUseWideViewPort() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mUseWideViewport;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getUserAgent is deprecated
     */

    public int getUserAgent() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/534.24 (KHTML, like Gecko) Chrome/11.0.696.34 Safari/534.24".equals(mUserAgent);
        if(!flag) goto _L2; else goto _L1
_L1:
        int i = 1;
_L4:
        this;
        JVM INSTR monitorexit ;
        return i;
_L2:
        boolean flag1;
        if("Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_0 like Mac OS X; en-us) AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0 Mobile/7A341 Safari/528.16".equals(mUserAgent)) {
            i = 2;
            continue; /* Loop/switch isn't completed */
        }
        flag1 = mUseDefaultUserAgent;
        if(flag1)
            i = 0;
        else
            i = -1;
        if(true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method getUserAgentString is deprecated
     */

    public String getUserAgentString() {
        this;
        JVM INSTR monitorenter ;
        if(!"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/534.24 (KHTML, like Gecko) Chrome/11.0.696.34 Safari/534.24".equals(mUserAgent) && !"Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_0 like Mac OS X; en-us) AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0 Mobile/7A341 Safari/528.16".equals(mUserAgent) && mUseDefaultUserAgent) goto _L2; else goto _L1
_L1:
        String s = mUserAgent;
_L4:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        boolean flag = false;
        synchronized(sLockForLocaleSettings) {
            Locale locale = Locale.getDefault();
            if(!sLocale.equals(locale)) {
                sLocale = locale;
                mUserAgent = getCurrentUserAgent();
                mAcceptLanguage = getCurrentAcceptLanguage();
                flag = true;
            }
        }
        if(!flag)
            break MISSING_BLOCK_LABEL_102;
        postSync();
        s = mUserAgent;
        if(true) goto _L4; else goto _L3
_L3:
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    boolean isNarrowColumnLayout() {
        boolean flag;
        if(getLayoutAlgorithm() == WebSettings.LayoutAlgorithm.NARROW_COLUMNS)
            flag = true;
        else
            flag = false;
        return flag;
    }

    boolean isPrivateBrowsingEnabled() {
        return mPrivateBrowsingEnabled;
    }

    /**
     * @deprecated Method onDestroyed is deprecated
     */

    void onDestroyed() {
        this;
        JVM INSTR monitorenter ;
    }

    public void setAllowContentAccess(boolean flag) {
        mAllowContentAccess = flag;
    }

    public void setAllowFileAccess(boolean flag) {
        mAllowFileAccess = flag;
    }

    /**
     * @deprecated Method setAllowFileAccessFromFileURLs is deprecated
     */

    public void setAllowFileAccessFromFileURLs(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        if(mAllowFileAccessFromFileURLs != flag) {
            mAllowFileAccessFromFileURLs = flag;
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setAllowUniversalAccessFromFileURLs is deprecated
     */

    public void setAllowUniversalAccessFromFileURLs(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        if(mAllowUniversalAccessFromFileURLs != flag) {
            mAllowUniversalAccessFromFileURLs = flag;
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setAppCacheEnabled is deprecated
     */

    public void setAppCacheEnabled(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        if(mAppCacheEnabled != flag) {
            mAppCacheEnabled = flag;
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setAppCacheMaxSize is deprecated
     */

    public void setAppCacheMaxSize(long l) {
        this;
        JVM INSTR monitorenter ;
        if(l != mAppCacheMaxSize) {
            mAppCacheMaxSize = l;
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setAppCachePath is deprecated
     */

    public void setAppCachePath(String s) {
        this;
        JVM INSTR monitorenter ;
        if(mAppCachePath == null && s != null && !s.isEmpty()) {
            mAppCachePath = s;
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setAutoFillEnabled is deprecated
     */

    public void setAutoFillEnabled(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        if(!flag)
            break MISSING_BLOCK_LABEL_35;
        boolean flag1;
        if(mPrivateBrowsingEnabled)
            break MISSING_BLOCK_LABEL_35;
        flag1 = true;
_L1:
        if(mAutoFillEnabled != flag1) {
            mAutoFillEnabled = flag1;
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        flag1 = false;
          goto _L1
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setAutoFillProfile is deprecated
     */

    public void setAutoFillProfile(AutoFillProfile autofillprofile) {
        this;
        JVM INSTR monitorenter ;
        if(mAutoFillProfile != autofillprofile) {
            mAutoFillProfile = autofillprofile;
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setBlockNetworkImage is deprecated
     */

    public void setBlockNetworkImage(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        if(mBlockNetworkImage != flag) {
            mBlockNetworkImage = flag;
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setBlockNetworkLoads is deprecated
     */

    public void setBlockNetworkLoads(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        if(mBlockNetworkLoads != flag) {
            mBlockNetworkLoads = flag;
            verifyNetworkAccess();
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setBuiltInZoomControls(boolean flag) {
        mBuiltInZoomControls = flag;
        mWebView.updateMultiTouchSupport(mContext);
    }

    public void setCacheMode(int i) {
        if(i != mOverrideCacheMode) {
            mOverrideCacheMode = i;
            postSync();
        }
    }

    /**
     * @deprecated Method setCursiveFontFamily is deprecated
     */

    public void setCursiveFontFamily(String s) {
        this;
        JVM INSTR monitorenter ;
        if(s == null)
            break MISSING_BLOCK_LABEL_26;
        if(!s.equals(mCursiveFontFamily)) {
            mCursiveFontFamily = s;
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setDatabaseEnabled is deprecated
     */

    public void setDatabaseEnabled(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        if(mDatabaseEnabled != flag) {
            mDatabaseEnabled = flag;
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setDatabasePath is deprecated
     */

    public void setDatabasePath(String s) {
        this;
        JVM INSTR monitorenter ;
        if(s == null)
            break MISSING_BLOCK_LABEL_27;
        if(!mDatabasePathHasBeenSet) {
            mDatabasePath = s;
            mDatabasePathHasBeenSet = true;
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setDefaultFixedFontSize is deprecated
     */

    public void setDefaultFixedFontSize(int i) {
        this;
        JVM INSTR monitorenter ;
        int j = pin(i);
        if(mDefaultFixedFontSize != j) {
            mDefaultFixedFontSize = j;
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setDefaultFontSize is deprecated
     */

    public void setDefaultFontSize(int i) {
        this;
        JVM INSTR monitorenter ;
        int j = pin(i);
        if(mDefaultFontSize != j) {
            mDefaultFontSize = j;
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setDefaultTextEncodingName is deprecated
     */

    public void setDefaultTextEncodingName(String s) {
        this;
        JVM INSTR monitorenter ;
        if(s == null)
            break MISSING_BLOCK_LABEL_26;
        if(!s.equals(mDefaultTextEncoding)) {
            mDefaultTextEncoding = s;
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setDefaultZoom(WebSettings.ZoomDensity zoomdensity) {
        if(mDefaultZoom != zoomdensity) {
            mDefaultZoom = zoomdensity;
            mWebView.adjustDefaultZoomDensity(zoomdensity.value);
        }
    }

    public void setDisplayZoomControls(boolean flag) {
        mDisplayZoomControls = flag;
        mWebView.updateMultiTouchSupport(mContext);
    }

    /**
     * @deprecated Method setDomStorageEnabled is deprecated
     */

    public void setDomStorageEnabled(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        if(mDomStorageEnabled != flag) {
            mDomStorageEnabled = flag;
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    void setDoubleTapToastCount(int i) {
        if(mDoubleTapToastCount != i) {
            mDoubleTapToastCount = i;
            mEventHandler.sendMessage(Message.obtain(null, 2));
        }
    }

    public void setDoubleTapZoom(int i) {
        if(mDoubleTapZoom != i) {
            mDoubleTapZoom = i;
            mWebView.updateDoubleTapZoom(i);
        }
    }

    public void setEnableSmoothTransition(boolean flag) {
        mEnableSmoothTransition = flag;
    }

    /**
     * @deprecated Method setFantasyFontFamily is deprecated
     */

    public void setFantasyFontFamily(String s) {
        this;
        JVM INSTR monitorenter ;
        if(s == null)
            break MISSING_BLOCK_LABEL_26;
        if(!s.equals(mFantasyFontFamily)) {
            mFantasyFontFamily = s;
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setFixedFontFamily is deprecated
     */

    public void setFixedFontFamily(String s) {
        this;
        JVM INSTR monitorenter ;
        if(s == null)
            break MISSING_BLOCK_LABEL_26;
        if(!s.equals(mFixedFontFamily)) {
            mFixedFontFamily = s;
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setForceUserScalable is deprecated
     */

    public void setForceUserScalable(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        mForceUserScalable = flag;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setGeolocationDatabasePath is deprecated
     */

    public void setGeolocationDatabasePath(String s) {
        this;
        JVM INSTR monitorenter ;
        if(s == null)
            break MISSING_BLOCK_LABEL_26;
        if(!s.equals(mGeolocationDatabasePath)) {
            mGeolocationDatabasePath = s;
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setGeolocationEnabled is deprecated
     */

    public void setGeolocationEnabled(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        if(mGeolocationEnabled != flag) {
            mGeolocationEnabled = flag;
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setHardwareAccelSkiaEnabled is deprecated
     */

    public void setHardwareAccelSkiaEnabled(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        if(mHardwareAccelSkia != flag) {
            mHardwareAccelSkia = flag;
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setJavaScriptCanOpenWindowsAutomatically is deprecated
     */

    public void setJavaScriptCanOpenWindowsAutomatically(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        if(mJavaScriptCanOpenWindowsAutomatically != flag) {
            mJavaScriptCanOpenWindowsAutomatically = flag;
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setJavaScriptEnabled is deprecated
     */

    public void setJavaScriptEnabled(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        if(mJavaScriptEnabled != flag) {
            mJavaScriptEnabled = flag;
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setLayoutAlgorithm is deprecated
     */

    public void setLayoutAlgorithm(WebSettings.LayoutAlgorithm layoutalgorithm) {
        this;
        JVM INSTR monitorenter ;
        if(mLayoutAlgorithm != layoutalgorithm) {
            mLayoutAlgorithm = layoutalgorithm;
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setLightTouchEnabled(boolean flag) {
        mLightTouchEnabled = flag;
    }

    /**
     * @deprecated Method setLinkPrefetchEnabled is deprecated
     */

    public void setLinkPrefetchEnabled(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        if(mLinkPrefetchEnabled != flag) {
            mLinkPrefetchEnabled = flag;
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setLoadWithOverviewMode(boolean flag) {
        mLoadWithOverviewMode = flag;
    }

    /**
     * @deprecated Method setLoadsImagesAutomatically is deprecated
     */

    public void setLoadsImagesAutomatically(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        if(mLoadsImagesAutomatically != flag) {
            mLoadsImagesAutomatically = flag;
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setMaximumDecodedImageSize(long l) {
        if(mMaximumDecodedImageSize != l) {
            mMaximumDecodedImageSize = l;
            postSync();
        }
    }

    /**
     * @deprecated Method setMinimumFontSize is deprecated
     */

    public void setMinimumFontSize(int i) {
        this;
        JVM INSTR monitorenter ;
        int j = pin(i);
        if(mMinimumFontSize != j) {
            mMinimumFontSize = j;
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setMinimumLogicalFontSize is deprecated
     */

    public void setMinimumLogicalFontSize(int i) {
        this;
        JVM INSTR monitorenter ;
        int j = pin(i);
        if(mMinimumLogicalFontSize != j) {
            mMinimumLogicalFontSize = j;
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setNavDump(boolean flag) {
        mNavDump = flag;
    }

    public void setNeedInitialFocus(boolean flag) {
        if(mNeedInitialFocus != flag)
            mNeedInitialFocus = flag;
    }

    /**
     * @deprecated Method setNightReadModeEnabled is deprecated
     */

    public void setNightReadModeEnabled(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        mNightReadMode = flag;
        postSync();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setPageCacheCapacity is deprecated
     */

    public void setPageCacheCapacity(int i) {
        this;
        JVM INSTR monitorenter ;
        if(i < 0)
            i = 0;
        if(i > 20)
            i = 20;
        if(mPageCacheCapacity != i) {
            mPageCacheCapacity = i;
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setPluginState is deprecated
     */

    public void setPluginState(WebSettings.PluginState pluginstate) {
        this;
        JVM INSTR monitorenter ;
        if(mPluginState != pluginstate) {
            mPluginState = pluginstate;
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setPluginsEnabled is deprecated
     */

    public void setPluginsEnabled(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        if(!flag)
            break MISSING_BLOCK_LABEL_18;
        WebSettings.PluginState pluginstate = WebSettings.PluginState.ON;
_L1:
        setPluginState(pluginstate);
        this;
        JVM INSTR monitorexit ;
        return;
        pluginstate = WebSettings.PluginState.OFF;
          goto _L1
        Exception exception;
        exception;
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
     * @deprecated Method setPrivateBrowsingEnabled is deprecated
     */

    void setPrivateBrowsingEnabled(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        if(mPrivateBrowsingEnabled != flag) {
            mPrivateBrowsingEnabled = flag;
            setAutoFillEnabled(mAutoFillEnabled);
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setProperty(String s, String s1) {
        if(mWebView.nativeSetProperty(s, s1))
            mWebView.invalidate();
    }

    /**
     * @deprecated Method setRenderPriority is deprecated
     */

    public void setRenderPriority(WebSettings.RenderPriority renderpriority) {
        this;
        JVM INSTR monitorenter ;
        if(mRenderPriority != renderpriority) {
            mRenderPriority = renderpriority;
            mEventHandler.sendMessage(Message.obtain(null, 1));
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setSansSerifFontFamily is deprecated
     */

    public void setSansSerifFontFamily(String s) {
        this;
        JVM INSTR monitorenter ;
        if(s == null)
            break MISSING_BLOCK_LABEL_26;
        if(!s.equals(mSansSerifFontFamily)) {
            mSansSerifFontFamily = s;
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setSaveFormData(boolean flag) {
        mSaveFormData = flag;
    }

    public void setSavePassword(boolean flag) {
        mSavePassword = flag;
    }

    /**
     * @deprecated Method setSerifFontFamily is deprecated
     */

    public void setSerifFontFamily(String s) {
        this;
        JVM INSTR monitorenter ;
        if(s == null)
            break MISSING_BLOCK_LABEL_26;
        if(!s.equals(mSerifFontFamily)) {
            mSerifFontFamily = s;
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setShowVisualIndicator is deprecated
     */

    public void setShowVisualIndicator(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        if(mShowVisualIndicator != flag) {
            mShowVisualIndicator = flag;
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setShrinksStandaloneImagesToFit(boolean flag) {
        if(mShrinksStandaloneImagesToFit != flag) {
            mShrinksStandaloneImagesToFit = flag;
            postSync();
        }
    }

    /**
     * @deprecated Method setStandardFontFamily is deprecated
     */

    public void setStandardFontFamily(String s) {
        this;
        JVM INSTR monitorenter ;
        if(s == null)
            break MISSING_BLOCK_LABEL_26;
        if(!s.equals(mStandardFontFamily)) {
            mStandardFontFamily = s;
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setSupportMultipleWindows is deprecated
     */

    public void setSupportMultipleWindows(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        if(mSupportMultipleWindows != flag) {
            mSupportMultipleWindows = flag;
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setSupportZoom(boolean flag) {
        mSupportZoom = flag;
        mWebView.updateMultiTouchSupport(mContext);
    }

    /**
     * @deprecated Method setSyntheticLinksEnabled is deprecated
     */

    void setSyntheticLinksEnabled(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        if(mSyntheticLinksEnabled != flag) {
            mSyntheticLinksEnabled = flag;
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setTextSize is deprecated
     */

    public void setTextSize(WebSettings.TextSize textsize) {
        this;
        JVM INSTR monitorenter ;
        setTextZoom(textsize.value);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setTextZoom is deprecated
     */

    public void setTextZoom(int i) {
        this;
        JVM INSTR monitorenter ;
        if(mTextSize != i) {
            if(WebViewClassic.mLogEvent) {
                Object aobj[] = new Object[2];
                aobj[0] = Integer.valueOf(mTextSize);
                aobj[1] = Integer.valueOf(i);
                EventLog.writeEvent(0x11207, aobj);
            }
            mTextSize = i;
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
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
        mUseWebViewBackgroundForOverscroll = flag;
    }

    /**
     * @deprecated Method setUseWideViewPort is deprecated
     */

    public void setUseWideViewPort(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        if(mUseWideViewport != flag) {
            mUseWideViewport = flag;
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setUserAgent is deprecated
     */

    public void setUserAgent(int i) {
        this;
        JVM INSTR monitorenter ;
        String s = null;
        if(i != 1) goto _L2; else goto _L1
_L1:
        boolean flag = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/534.24 (KHTML, like Gecko) Chrome/11.0.696.34 Safari/534.24".equals(mUserAgent);
        if(!flag)
            break MISSING_BLOCK_LABEL_28;
        this;
        JVM INSTR monitorexit ;
        return;
        s = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/534.24 (KHTML, like Gecko) Chrome/11.0.696.34 Safari/534.24";
_L4:
        setUserAgentString(s);
        break; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        throw exception;
_L2:
        if(i != 2)
            continue; /* Loop/switch isn't completed */
        if("Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_0 like Mac OS X; en-us) AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0 Mobile/7A341 Safari/528.16".equals(mUserAgent))
            break; /* Loop/switch isn't completed */
        s = "Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_0 like Mac OS X; en-us) AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0 Mobile/7A341 Safari/528.16";
        if(false && i != 0)
            break; /* Loop/switch isn't completed */
        if(true) goto _L4; else goto _L3
_L3:
    }

    /**
     * @deprecated Method setUserAgentString is deprecated
     */

    public void setUserAgentString(String s) {
        this;
        JVM INSTR monitorenter ;
        if(s == null)
            break MISSING_BLOCK_LABEL_13;
        if(s.length() != 0)
            break MISSING_BLOCK_LABEL_95;
        synchronized(sLockForLocaleSettings) {
            Locale locale = Locale.getDefault();
            if(!sLocale.equals(locale)) {
                sLocale = locale;
                mAcceptLanguage = getCurrentAcceptLanguage();
            }
        }
        s = getCurrentUserAgent();
        mUseDefaultUserAgent = true;
_L1:
        if(!s.equals(mUserAgent)) {
            mUserAgent = s;
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        mUseDefaultUserAgent = false;
          goto _L1
    }

    /**
     * @deprecated Method setWorkersEnabled is deprecated
     */

    public void setWorkersEnabled(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        if(mWorkersEnabled != flag) {
            mWorkersEnabled = flag;
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method setXSSAuditorEnabled is deprecated
     */

    public void setXSSAuditorEnabled(boolean flag) {
        this;
        JVM INSTR monitorenter ;
        if(mXSSAuditorEnabled != flag) {
            mXSSAuditorEnabled = flag;
            postSync();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    /**
     * @deprecated Method supportMultipleWindows is deprecated
     */

    public boolean supportMultipleWindows() {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mSupportMultipleWindows;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean supportZoom() {
        return mSupportZoom;
    }

    /**
     * @deprecated Method syncSettingsAndCreateHandler is deprecated
     */

    void syncSettingsAndCreateHandler(BrowserFrame browserframe) {
        this;
        JVM INSTR monitorenter ;
        mBrowserFrame = browserframe;
        SharedPreferences sharedpreferences = mContext.getSharedPreferences("WebViewSettings", 0);
        if(mDoubleTapToastCount > 0)
            mDoubleTapToastCount = sharedpreferences.getInt("double_tap_toast_count", mDoubleTapToastCount);
        nativeSync(browserframe.mNativeFrame);
        mSyncPending = false;
        mEventHandler.createHandler();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private static final String ACCEPT_LANG_FOR_US_LOCALE = "en-US";
    private static final String DESKTOP_USERAGENT = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/534.24 (KHTML, like Gecko) Chrome/11.0.696.34 Safari/534.24";
    private static final String DOUBLE_TAP_TOAST_COUNT = "double_tap_toast_count";
    private static final String IPHONE_USERAGENT = "Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_0 like Mac OS X; en-us) AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0 Mobile/7A341 Safari/528.16";
    private static final String PREF_FILE = "WebViewSettings";
    private static final String PREVIOUS_VERSION = "4.0.4";
    private static int mDoubleTapToastCount = 3;
    private static Locale sLocale;
    private static Object sLockForLocaleSettings;
    private String mAcceptLanguage;
    private boolean mAllowContentAccess;
    private boolean mAllowFileAccess;
    private boolean mAllowFileAccessFromFileURLs;
    private boolean mAllowUniversalAccessFromFileURLs;
    private boolean mAppCacheEnabled;
    private long mAppCacheMaxSize;
    private String mAppCachePath;
    private boolean mAutoFillEnabled;
    private AutoFillProfile mAutoFillProfile;
    private boolean mBlockNetworkImage;
    private boolean mBlockNetworkLoads;
    private BrowserFrame mBrowserFrame;
    private boolean mBuiltInZoomControls;
    private Context mContext;
    private String mCursiveFontFamily;
    private boolean mDatabaseEnabled;
    private String mDatabasePath;
    private boolean mDatabasePathHasBeenSet;
    private int mDefaultFixedFontSize;
    private int mDefaultFontSize;
    private String mDefaultTextEncoding;
    private WebSettings.ZoomDensity mDefaultZoom;
    private boolean mDisplayZoomControls;
    private boolean mDomStorageEnabled;
    private int mDoubleTapZoom;
    private boolean mEnableSmoothTransition;
    private final EventHandler mEventHandler;
    private String mFantasyFontFamily;
    private String mFixedFontFamily;
    private boolean mForceUserScalable;
    private String mGeolocationDatabasePath;
    private boolean mGeolocationEnabled;
    private boolean mHardwareAccelSkia;
    private boolean mJavaScriptCanOpenWindowsAutomatically;
    private boolean mJavaScriptEnabled;
    private WebSettings.LayoutAlgorithm mLayoutAlgorithm;
    private boolean mLightTouchEnabled;
    private boolean mLinkPrefetchEnabled;
    private boolean mLoadWithOverviewMode;
    private boolean mLoadsImagesAutomatically;
    private long mMaximumDecodedImageSize;
    private int mMinimumFontSize;
    private int mMinimumLogicalFontSize;
    private boolean mNavDump;
    private boolean mNeedInitialFocus;
    private boolean mNightReadMode;
    private int mOverrideCacheMode;
    private int mPageCacheCapacity;
    private boolean mPasswordEchoEnabled;
    private WebSettings.PluginState mPluginState;
    private boolean mPrivateBrowsingEnabled;
    private WebSettings.RenderPriority mRenderPriority;
    private String mSansSerifFontFamily;
    private boolean mSaveFormData;
    private boolean mSavePassword;
    private String mSerifFontFamily;
    private boolean mShowVisualIndicator;
    private boolean mShrinksStandaloneImagesToFit;
    private String mStandardFontFamily;
    private boolean mSupportMultipleWindows;
    private boolean mSupportZoom;
    private boolean mSyncPending;
    private boolean mSyntheticLinksEnabled;
    private int mTextSize;
    private boolean mUseDefaultUserAgent;
    private boolean mUseDoubleTree;
    private boolean mUseWebViewBackgroundForOverscroll;
    private boolean mUseWideViewport;
    private String mUserAgent;
    private WebViewClassic mWebView;
    private boolean mWorkersEnabled;
    private boolean mXSSAuditorEnabled;





/*
    static boolean access$202(WebSettingsClassic websettingsclassic, boolean flag) {
        websettingsclassic.mSyncPending = flag;
        return flag;
    }

*/



}
