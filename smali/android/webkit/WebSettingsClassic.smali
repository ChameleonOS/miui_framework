.class public Landroid/webkit/WebSettingsClassic;
.super Landroid/webkit/WebSettings;
.source "WebSettingsClassic.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/webkit/WebSettingsClassic$1;,
        Landroid/webkit/WebSettingsClassic$EventHandler;,
        Landroid/webkit/WebSettingsClassic$AutoFillProfile;
    }
.end annotation


# static fields
.field private static final ACCEPT_LANG_FOR_US_LOCALE:Ljava/lang/String; = "en-US"

.field private static final DESKTOP_USERAGENT:Ljava/lang/String; = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/534.24 (KHTML, like Gecko) Chrome/11.0.696.34 Safari/534.24"

.field private static final DOUBLE_TAP_TOAST_COUNT:Ljava/lang/String; = "double_tap_toast_count"

.field private static final IPHONE_USERAGENT:Ljava/lang/String; = "Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_0 like Mac OS X; en-us) AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0 Mobile/7A341 Safari/528.16"

.field private static final PREF_FILE:Ljava/lang/String; = "WebViewSettings"

.field private static final PREVIOUS_VERSION:Ljava/lang/String; = "4.0.4"

.field private static mDoubleTapToastCount:I

.field private static sLocale:Ljava/util/Locale;

.field private static sLockForLocaleSettings:Ljava/lang/Object;


# instance fields
.field private mAcceptLanguage:Ljava/lang/String;

.field private mAllowContentAccess:Z

.field private mAllowFileAccess:Z

.field private mAllowFileAccessFromFileURLs:Z

.field private mAllowUniversalAccessFromFileURLs:Z

.field private mAppCacheEnabled:Z

.field private mAppCacheMaxSize:J

.field private mAppCachePath:Ljava/lang/String;

.field private mAutoFillEnabled:Z

.field private mAutoFillProfile:Landroid/webkit/WebSettingsClassic$AutoFillProfile;

.field private mBlockNetworkImage:Z

.field private mBlockNetworkLoads:Z

.field private mBrowserFrame:Landroid/webkit/BrowserFrame;

.field private mBuiltInZoomControls:Z

.field private mContext:Landroid/content/Context;

.field private mCursiveFontFamily:Ljava/lang/String;

.field private mDatabaseEnabled:Z

.field private mDatabasePath:Ljava/lang/String;

.field private mDatabasePathHasBeenSet:Z

.field private mDefaultFixedFontSize:I

.field private mDefaultFontSize:I

.field private mDefaultTextEncoding:Ljava/lang/String;

.field private mDefaultZoom:Landroid/webkit/WebSettings$ZoomDensity;

.field private mDisplayZoomControls:Z

.field private mDomStorageEnabled:Z

.field private mDoubleTapZoom:I

.field private mEnableSmoothTransition:Z

.field private final mEventHandler:Landroid/webkit/WebSettingsClassic$EventHandler;

.field private mFantasyFontFamily:Ljava/lang/String;

.field private mFixedFontFamily:Ljava/lang/String;

.field private mForceUserScalable:Z

.field private mGeolocationDatabasePath:Ljava/lang/String;

.field private mGeolocationEnabled:Z

.field private mHardwareAccelSkia:Z

.field private mJavaScriptCanOpenWindowsAutomatically:Z

.field private mJavaScriptEnabled:Z

.field private mLayoutAlgorithm:Landroid/webkit/WebSettings$LayoutAlgorithm;

.field private mLightTouchEnabled:Z

.field private mLinkPrefetchEnabled:Z

.field private mLoadWithOverviewMode:Z

.field private mLoadsImagesAutomatically:Z

.field private mMaximumDecodedImageSize:J

.field private mMinimumFontSize:I

.field private mMinimumLogicalFontSize:I

.field private mNavDump:Z

.field private mNeedInitialFocus:Z

.field private mNightReadMode:Z
    .annotation build Landroid/annotation/MiuiHook;
        value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_FIELD:Landroid/annotation/MiuiHook$MiuiHookType;
    .end annotation
.end field

.field private mOverrideCacheMode:I

.field private mPageCacheCapacity:I

.field private mPasswordEchoEnabled:Z

.field private mPluginState:Landroid/webkit/WebSettings$PluginState;

.field private mPrivateBrowsingEnabled:Z

.field private mRenderPriority:Landroid/webkit/WebSettings$RenderPriority;

.field private mSansSerifFontFamily:Ljava/lang/String;

.field private mSaveFormData:Z

.field private mSavePassword:Z

.field private mSerifFontFamily:Ljava/lang/String;

.field private mShowVisualIndicator:Z

.field private mShrinksStandaloneImagesToFit:Z

.field private mStandardFontFamily:Ljava/lang/String;

.field private mSupportMultipleWindows:Z

.field private mSupportZoom:Z

.field private mSyncPending:Z

.field private mSyntheticLinksEnabled:Z

.field private mTextSize:I

.field private mUseDefaultUserAgent:Z

.field private mUseDoubleTree:Z

.field private mUseWebViewBackgroundForOverscroll:Z

.field private mUseWideViewport:Z

.field private mUserAgent:Ljava/lang/String;

.field private mWebView:Landroid/webkit/WebViewClassic;

.field private mWorkersEnabled:Z

.field private mXSSAuditorEnabled:Z


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 183
    const/4 v0, 0x3

    sput v0, Landroid/webkit/WebSettingsClassic;->mDoubleTapToastCount:I

    return-void
.end method

.method constructor <init>(Landroid/content/Context;Landroid/webkit/WebViewClassic;)V
    .registers 11
    .parameter "context"
    .parameter "webview"

    .prologue
    const/16 v6, 0x64

    const/16 v7, 0x10

    const/16 v4, 0x8

    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 280
    invoke-direct {p0}, Landroid/webkit/WebSettings;-><init>()V

    .line 47
    iput-boolean v3, p0, Landroid/webkit/WebSettingsClassic;->mSyncPending:Z

    .line 57
    sget-object v1, Landroid/webkit/WebSettings$LayoutAlgorithm;->NARROW_COLUMNS:Landroid/webkit/WebSettings$LayoutAlgorithm;

    iput-object v1, p0, Landroid/webkit/WebSettingsClassic;->mLayoutAlgorithm:Landroid/webkit/WebSettings$LayoutAlgorithm;

    .line 59
    iput v6, p0, Landroid/webkit/WebSettingsClassic;->mTextSize:I

    .line 60
    iput-boolean v3, p0, Landroid/webkit/WebSettingsClassic;->mNightReadMode:Z

    .line 62
    const-string/jumbo v1, "sans-serif"

    iput-object v1, p0, Landroid/webkit/WebSettingsClassic;->mStandardFontFamily:Ljava/lang/String;

    .line 63
    const-string/jumbo v1, "monospace"

    iput-object v1, p0, Landroid/webkit/WebSettingsClassic;->mFixedFontFamily:Ljava/lang/String;

    .line 64
    const-string/jumbo v1, "sans-serif"

    iput-object v1, p0, Landroid/webkit/WebSettingsClassic;->mSansSerifFontFamily:Ljava/lang/String;

    .line 65
    const-string/jumbo v1, "serif"

    iput-object v1, p0, Landroid/webkit/WebSettingsClassic;->mSerifFontFamily:Ljava/lang/String;

    .line 66
    const-string v1, "cursive"

    iput-object v1, p0, Landroid/webkit/WebSettingsClassic;->mCursiveFontFamily:Ljava/lang/String;

    .line 67
    const-string v1, "fantasy"

    iput-object v1, p0, Landroid/webkit/WebSettingsClassic;->mFantasyFontFamily:Ljava/lang/String;

    .line 72
    iput v4, p0, Landroid/webkit/WebSettingsClassic;->mMinimumFontSize:I

    .line 73
    iput v4, p0, Landroid/webkit/WebSettingsClassic;->mMinimumLogicalFontSize:I

    .line 74
    iput v7, p0, Landroid/webkit/WebSettingsClassic;->mDefaultFontSize:I

    .line 75
    const/16 v1, 0xd

    iput v1, p0, Landroid/webkit/WebSettingsClassic;->mDefaultFixedFontSize:I

    .line 76
    iput v3, p0, Landroid/webkit/WebSettingsClassic;->mPageCacheCapacity:I

    .line 77
    iput-boolean v2, p0, Landroid/webkit/WebSettingsClassic;->mLoadsImagesAutomatically:Z

    .line 78
    iput-boolean v3, p0, Landroid/webkit/WebSettingsClassic;->mBlockNetworkImage:Z

    .line 80
    iput-boolean v3, p0, Landroid/webkit/WebSettingsClassic;->mJavaScriptEnabled:Z

    .line 81
    iput-boolean v3, p0, Landroid/webkit/WebSettingsClassic;->mAllowUniversalAccessFromFileURLs:Z

    .line 82
    iput-boolean v3, p0, Landroid/webkit/WebSettingsClassic;->mAllowFileAccessFromFileURLs:Z

    .line 83
    iput-boolean v3, p0, Landroid/webkit/WebSettingsClassic;->mHardwareAccelSkia:Z

    .line 84
    iput-boolean v3, p0, Landroid/webkit/WebSettingsClassic;->mShowVisualIndicator:Z

    .line 85
    sget-object v1, Landroid/webkit/WebSettings$PluginState;->OFF:Landroid/webkit/WebSettings$PluginState;

    iput-object v1, p0, Landroid/webkit/WebSettingsClassic;->mPluginState:Landroid/webkit/WebSettings$PluginState;

    .line 86
    iput-boolean v3, p0, Landroid/webkit/WebSettingsClassic;->mJavaScriptCanOpenWindowsAutomatically:Z

    .line 87
    iput-boolean v3, p0, Landroid/webkit/WebSettingsClassic;->mUseDoubleTree:Z

    .line 88
    iput-boolean v3, p0, Landroid/webkit/WebSettingsClassic;->mUseWideViewport:Z

    .line 89
    iput-boolean v3, p0, Landroid/webkit/WebSettingsClassic;->mSupportMultipleWindows:Z

    .line 90
    iput-boolean v3, p0, Landroid/webkit/WebSettingsClassic;->mShrinksStandaloneImagesToFit:Z

    .line 91
    const-wide/16 v4, 0x0

    iput-wide v4, p0, Landroid/webkit/WebSettingsClassic;->mMaximumDecodedImageSize:J

    .line 92
    iput-boolean v3, p0, Landroid/webkit/WebSettingsClassic;->mPrivateBrowsingEnabled:Z

    .line 93
    iput-boolean v2, p0, Landroid/webkit/WebSettingsClassic;->mSyntheticLinksEnabled:Z

    .line 95
    iput-boolean v3, p0, Landroid/webkit/WebSettingsClassic;->mAppCacheEnabled:Z

    .line 96
    iput-boolean v3, p0, Landroid/webkit/WebSettingsClassic;->mDatabaseEnabled:Z

    .line 97
    iput-boolean v3, p0, Landroid/webkit/WebSettingsClassic;->mDomStorageEnabled:Z

    .line 98
    iput-boolean v3, p0, Landroid/webkit/WebSettingsClassic;->mWorkersEnabled:Z

    .line 99
    iput-boolean v2, p0, Landroid/webkit/WebSettingsClassic;->mGeolocationEnabled:Z

    .line 100
    iput-boolean v3, p0, Landroid/webkit/WebSettingsClassic;->mXSSAuditorEnabled:Z

    .line 101
    iput-boolean v3, p0, Landroid/webkit/WebSettingsClassic;->mLinkPrefetchEnabled:Z

    .line 103
    const-wide v4, 0x7fffffffffffffffL

    iput-wide v4, p0, Landroid/webkit/WebSettingsClassic;->mAppCacheMaxSize:J

    .line 104
    const/4 v1, 0x0

    iput-object v1, p0, Landroid/webkit/WebSettingsClassic;->mAppCachePath:Ljava/lang/String;

    .line 105
    const-string v1, ""

    iput-object v1, p0, Landroid/webkit/WebSettingsClassic;->mDatabasePath:Ljava/lang/String;

    .line 108
    iput-boolean v3, p0, Landroid/webkit/WebSettingsClassic;->mDatabasePathHasBeenSet:Z

    .line 109
    const-string v1, ""

    iput-object v1, p0, Landroid/webkit/WebSettingsClassic;->mGeolocationDatabasePath:Ljava/lang/String;

    .line 113
    sget-object v1, Landroid/webkit/WebSettings$ZoomDensity;->MEDIUM:Landroid/webkit/WebSettings$ZoomDensity;

    iput-object v1, p0, Landroid/webkit/WebSettingsClassic;->mDefaultZoom:Landroid/webkit/WebSettings$ZoomDensity;

    .line 114
    sget-object v1, Landroid/webkit/WebSettings$RenderPriority;->NORMAL:Landroid/webkit/WebSettings$RenderPriority;

    iput-object v1, p0, Landroid/webkit/WebSettingsClassic;->mRenderPriority:Landroid/webkit/WebSettings$RenderPriority;

    .line 115
    const/4 v1, -0x1

    iput v1, p0, Landroid/webkit/WebSettingsClassic;->mOverrideCacheMode:I

    .line 116
    iput v6, p0, Landroid/webkit/WebSettingsClassic;->mDoubleTapZoom:I

    .line 117
    iput-boolean v2, p0, Landroid/webkit/WebSettingsClassic;->mSaveFormData:Z

    .line 118
    iput-boolean v3, p0, Landroid/webkit/WebSettingsClassic;->mAutoFillEnabled:Z

    .line 119
    iput-boolean v2, p0, Landroid/webkit/WebSettingsClassic;->mSavePassword:Z

    .line 120
    iput-boolean v3, p0, Landroid/webkit/WebSettingsClassic;->mLightTouchEnabled:Z

    .line 121
    iput-boolean v2, p0, Landroid/webkit/WebSettingsClassic;->mNeedInitialFocus:Z

    .line 122
    iput-boolean v3, p0, Landroid/webkit/WebSettingsClassic;->mNavDump:Z

    .line 123
    iput-boolean v2, p0, Landroid/webkit/WebSettingsClassic;->mSupportZoom:Z

    .line 124
    iput-boolean v3, p0, Landroid/webkit/WebSettingsClassic;->mBuiltInZoomControls:Z

    .line 125
    iput-boolean v2, p0, Landroid/webkit/WebSettingsClassic;->mDisplayZoomControls:Z

    .line 126
    iput-boolean v2, p0, Landroid/webkit/WebSettingsClassic;->mAllowFileAccess:Z

    .line 127
    iput-boolean v2, p0, Landroid/webkit/WebSettingsClassic;->mAllowContentAccess:Z

    .line 128
    iput-boolean v3, p0, Landroid/webkit/WebSettingsClassic;->mLoadWithOverviewMode:Z

    .line 129
    iput-boolean v3, p0, Landroid/webkit/WebSettingsClassic;->mEnableSmoothTransition:Z

    .line 130
    iput-boolean v3, p0, Landroid/webkit/WebSettingsClassic;->mForceUserScalable:Z

    .line 131
    iput-boolean v2, p0, Landroid/webkit/WebSettingsClassic;->mPasswordEchoEnabled:Z

    .line 180
    iput-boolean v2, p0, Landroid/webkit/WebSettingsClassic;->mUseWebViewBackgroundForOverscroll:Z

    .line 281
    new-instance v1, Landroid/webkit/WebSettingsClassic$EventHandler;

    const/4 v4, 0x0

    invoke-direct {v1, p0, v4}, Landroid/webkit/WebSettingsClassic$EventHandler;-><init>(Landroid/webkit/WebSettingsClassic;Landroid/webkit/WebSettingsClassic$1;)V

    iput-object v1, p0, Landroid/webkit/WebSettingsClassic;->mEventHandler:Landroid/webkit/WebSettingsClassic$EventHandler;

    .line 282
    iput-object p1, p0, Landroid/webkit/WebSettingsClassic;->mContext:Landroid/content/Context;

    .line 283
    iput-object p2, p0, Landroid/webkit/WebSettingsClassic;->mWebView:Landroid/webkit/WebViewClassic;

    .line 284
    const v1, 0x10400ba

    invoke-virtual {p1, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Landroid/webkit/WebSettingsClassic;->mDefaultTextEncoding:Ljava/lang/String;

    .line 287
    sget-object v1, Landroid/webkit/WebSettingsClassic;->sLockForLocaleSettings:Ljava/lang/Object;

    if-nez v1, :cond_d6

    .line 288
    new-instance v1, Ljava/lang/Object;

    invoke-direct/range {v1 .. v1}, Ljava/lang/Object;-><init>()V

    sput-object v1, Landroid/webkit/WebSettingsClassic;->sLockForLocaleSettings:Ljava/lang/Object;

    .line 289
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v1

    sput-object v1, Landroid/webkit/WebSettingsClassic;->sLocale:Ljava/util/Locale;

    .line 291
    :cond_d6
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->getCurrentAcceptLanguage()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Landroid/webkit/WebSettingsClassic;->mAcceptLanguage:Ljava/lang/String;

    .line 292
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->getCurrentUserAgent()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Landroid/webkit/WebSettingsClassic;->mUserAgent:Ljava/lang/String;

    .line 293
    iput-boolean v2, p0, Landroid/webkit/WebSettingsClassic;->mUseDefaultUserAgent:Z

    .line 295
    iget-object v1, p0, Landroid/webkit/WebSettingsClassic;->mContext:Landroid/content/Context;

    const-string v4, "android.permission.INTERNET"

    invoke-static {}, Landroid/os/Process;->myPid()I

    move-result v5

    invoke-static {}, Landroid/os/Process;->myUid()I

    move-result v6

    invoke-virtual {v1, v4, v5, v6}, Landroid/content/Context;->checkPermission(Ljava/lang/String;II)I

    move-result v1

    if-eqz v1, :cond_118

    move v1, v2

    :goto_f7
    iput-boolean v1, p0, Landroid/webkit/WebSettingsClassic;->mBlockNetworkLoads:Z

    .line 300
    iget-object v1, p0, Landroid/webkit/WebSettingsClassic;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v1

    iget v1, v1, Landroid/content/pm/ApplicationInfo;->targetSdkVersion:I

    if-ge v1, v7, :cond_107

    .line 302
    iput-boolean v2, p0, Landroid/webkit/WebSettingsClassic;->mAllowUniversalAccessFromFileURLs:Z

    .line 303
    iput-boolean v2, p0, Landroid/webkit/WebSettingsClassic;->mAllowFileAccessFromFileURLs:Z

    .line 306
    :cond_107
    :try_start_107
    invoke-virtual {p1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    const-string/jumbo v4, "show_password"

    invoke-static {v1, v4}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;)I

    move-result v1

    if-eqz v1, :cond_115

    move v3, v2

    :cond_115
    iput-boolean v3, p0, Landroid/webkit/WebSettingsClassic;->mPasswordEchoEnabled:Z
    :try_end_117
    .catch Landroid/provider/Settings$SettingNotFoundException; {:try_start_107 .. :try_end_117} :catch_11a

    .line 312
    :goto_117
    return-void

    :cond_118
    move v1, v3

    .line 295
    goto :goto_f7

    .line 309
    :catch_11a
    move-exception v0

    .line 310
    .local v0, e:Landroid/provider/Settings$SettingNotFoundException;
    iput-boolean v2, p0, Landroid/webkit/WebSettingsClassic;->mPasswordEchoEnabled:Z

    goto :goto_117
.end method

.method static synthetic access$000(Landroid/webkit/WebSettingsClassic;)Landroid/webkit/BrowserFrame;
    .registers 2
    .parameter "x0"

    .prologue
    .line 38
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mBrowserFrame:Landroid/webkit/BrowserFrame;

    return-object v0
.end method

.method static synthetic access$100(Landroid/webkit/WebSettingsClassic;I)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 38
    invoke-direct {p0, p1}, Landroid/webkit/WebSettingsClassic;->nativeSync(I)V

    return-void
.end method

.method static synthetic access$202(Landroid/webkit/WebSettingsClassic;Z)Z
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 38
    iput-boolean p1, p0, Landroid/webkit/WebSettingsClassic;->mSyncPending:Z

    return p1
.end method

.method static synthetic access$400(Landroid/webkit/WebSettingsClassic;)Landroid/content/Context;
    .registers 2
    .parameter "x0"

    .prologue
    .line 38
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$500()I
    .registers 1

    .prologue
    .line 38
    sget v0, Landroid/webkit/WebSettingsClassic;->mDoubleTapToastCount:I

    return v0
.end method

.method static synthetic access$600(Landroid/webkit/WebSettingsClassic;)Landroid/webkit/WebSettings$RenderPriority;
    .registers 2
    .parameter "x0"

    .prologue
    .line 38
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mRenderPriority:Landroid/webkit/WebSettings$RenderPriority;

    return-object v0
.end method

.method private static addLocaleToHttpAcceptLanguage(Ljava/lang/StringBuilder;Ljava/util/Locale;)V
    .registers 5
    .parameter "builder"
    .parameter "locale"

    .prologue
    .line 361
    invoke-virtual {p1}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/webkit/WebSettingsClassic;->convertObsoleteLanguageCodeToNew(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 362
    .local v1, language:Ljava/lang/String;
    if-eqz v1, :cond_1b

    .line 363
    invoke-virtual {p0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 364
    invoke-virtual {p1}, Ljava/util/Locale;->getCountry()Ljava/lang/String;

    move-result-object v0

    .line 365
    .local v0, country:Ljava/lang/String;
    if-eqz v0, :cond_1b

    .line 366
    const-string v2, "-"

    invoke-virtual {p0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 367
    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 370
    .end local v0           #country:Ljava/lang/String;
    :cond_1b
    return-void
.end method

.method private static convertObsoleteLanguageCodeToNew(Ljava/lang/String;)Ljava/lang/String;
    .registers 2
    .parameter "langCode"

    .prologue
    .line 343
    if-nez p0, :cond_4

    .line 344
    const/4 p0, 0x0

    .line 356
    .end local p0
    :cond_3
    :goto_3
    return-object p0

    .line 346
    .restart local p0
    :cond_4
    const-string v0, "iw"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_f

    .line 348
    const-string p0, "he"

    goto :goto_3

    .line 349
    :cond_f
    const-string v0, "in"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1a

    .line 351
    const-string p0, "id"

    goto :goto_3

    .line 352
    :cond_1a
    const-string v0, "ji"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 354
    const-string/jumbo p0, "yi"

    goto :goto_3
.end method

.method private getCurrentAcceptLanguage()Ljava/lang/String;
    .registers 5

    .prologue
    .line 322
    sget-object v3, Landroid/webkit/WebSettingsClassic;->sLockForLocaleSettings:Ljava/lang/Object;

    monitor-enter v3

    .line 323
    :try_start_3
    sget-object v1, Landroid/webkit/WebSettingsClassic;->sLocale:Ljava/util/Locale;

    .line 324
    .local v1, locale:Ljava/util/Locale;
    monitor-exit v3
    :try_end_6
    .catchall {:try_start_3 .. :try_end_6} :catchall_2b

    .line 325
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 326
    .local v0, buffer:Ljava/lang/StringBuilder;
    invoke-static {v0, v1}, Landroid/webkit/WebSettingsClassic;->addLocaleToHttpAcceptLanguage(Ljava/lang/StringBuilder;Ljava/util/Locale;)V

    .line 328
    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v2, v1}, Ljava/util/Locale;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_26

    .line 329
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->length()I

    move-result v2

    if-lez v2, :cond_21

    .line 330
    const-string v2, ", "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 332
    :cond_21
    const-string v2, "en-US"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 335
    :cond_26
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2

    .line 324
    .end local v0           #buffer:Ljava/lang/StringBuilder;
    .end local v1           #locale:Ljava/util/Locale;
    :catchall_2b
    move-exception v2

    :try_start_2c
    monitor-exit v3
    :try_end_2d
    .catchall {:try_start_2c .. :try_end_2d} :catchall_2b

    throw v2
.end method

.method private declared-synchronized getCurrentUserAgent()Ljava/lang/String;
    .registers 12

    .prologue
    .line 378
    monitor-enter p0

    :try_start_1
    sget-object v10, Landroid/webkit/WebSettingsClassic;->sLockForLocaleSettings:Ljava/lang/Object;

    monitor-enter v10
    :try_end_4
    .catchall {:try_start_1 .. :try_end_4} :catchall_a9

    .line 379
    :try_start_4
    sget-object v5, Landroid/webkit/WebSettingsClassic;->sLocale:Ljava/util/Locale;

    .line 380
    .local v5, locale:Ljava/util/Locale;
    monitor-exit v10
    :try_end_7
    .catchall {:try_start_4 .. :try_end_7} :catchall_a6

    .line 381
    :try_start_7
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    .line 383
    .local v1, buffer:Ljava/lang/StringBuffer;
    sget-object v8, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    .line 384
    .local v8, version:Ljava/lang/String;
    invoke-virtual {v8}, Ljava/lang/String;->length()I

    move-result v9

    if-lez v9, :cond_b3

    .line 385
    const/4 v9, 0x0

    invoke-virtual {v8, v9}, Ljava/lang/String;->charAt(I)C

    move-result v9

    invoke-static {v9}, Ljava/lang/Character;->isDigit(C)Z

    move-result v9

    if-eqz v9, :cond_ac

    .line 387
    invoke-virtual {v1, v8}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 397
    :goto_22
    const-string v9, "; "

    invoke-virtual {v1, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 398
    invoke-virtual {v5}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v4

    .line 399
    .local v4, language:Ljava/lang/String;
    if-eqz v4, :cond_ba

    .line 400
    invoke-static {v4}, Landroid/webkit/WebSettingsClassic;->convertObsoleteLanguageCodeToNew(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v1, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 401
    invoke-virtual {v5}, Ljava/util/Locale;->getCountry()Ljava/lang/String;

    move-result-object v2

    .line 402
    .local v2, country:Ljava/lang/String;
    if-eqz v2, :cond_46

    .line 403
    const-string v9, "-"

    invoke-virtual {v1, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 404
    invoke-virtual {v2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v1, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 410
    .end local v2           #country:Ljava/lang/String;
    :cond_46
    :goto_46
    const-string v9, ";"

    invoke-virtual {v1, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 412
    const-string v9, "REL"

    sget-object v10, Landroid/os/Build$VERSION;->CODENAME:Ljava/lang/String;

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_65

    .line 413
    sget-object v7, Landroid/os/Build;->MODEL:Ljava/lang/String;

    .line 414
    .local v7, model:Ljava/lang/String;
    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v9

    if-lez v9, :cond_65

    .line 415
    const-string v9, " "

    invoke-virtual {v1, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 416
    invoke-virtual {v1, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 419
    .end local v7           #model:Ljava/lang/String;
    :cond_65
    sget-object v3, Landroid/os/Build;->ID:Ljava/lang/String;

    .line 420
    .local v3, id:Ljava/lang/String;
    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v9

    if-lez v9, :cond_75

    .line 421
    const-string v9, " Build/"

    invoke-virtual {v1, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 422
    invoke-virtual {v1, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 424
    :cond_75
    iget-object v9, p0, Landroid/webkit/WebSettingsClassic;->mContext:Landroid/content/Context;

    invoke-virtual {v9}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v9

    const v10, 0x104033c

    invoke-virtual {v9, v10}, Landroid/content/res/Resources;->getText(I)Ljava/lang/CharSequence;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    .line 426
    .local v6, mobile:Ljava/lang/String;
    iget-object v9, p0, Landroid/webkit/WebSettingsClassic;->mContext:Landroid/content/Context;

    invoke-virtual {v9}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v9

    const v10, 0x104033b

    invoke-virtual {v9, v10}, Landroid/content/res/Resources;->getText(I)Ljava/lang/CharSequence;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 428
    .local v0, base:Ljava/lang/String;
    const/4 v9, 0x2

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    aput-object v1, v9, v10

    const/4 v10, 0x1

    aput-object v6, v9, v10

    invoke-static {v0, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    :try_end_a3
    .catchall {:try_start_7 .. :try_end_a3} :catchall_a9

    move-result-object v9

    monitor-exit p0

    return-object v9

    .line 380
    .end local v0           #base:Ljava/lang/String;
    .end local v1           #buffer:Ljava/lang/StringBuffer;
    .end local v3           #id:Ljava/lang/String;
    .end local v4           #language:Ljava/lang/String;
    .end local v5           #locale:Ljava/util/Locale;
    .end local v6           #mobile:Ljava/lang/String;
    .end local v8           #version:Ljava/lang/String;
    :catchall_a6
    move-exception v9

    :try_start_a7
    monitor-exit v10
    :try_end_a8
    .catchall {:try_start_a7 .. :try_end_a8} :catchall_a6

    :try_start_a8
    throw v9
    :try_end_a9
    .catchall {:try_start_a8 .. :try_end_a9} :catchall_a9

    .line 378
    :catchall_a9
    move-exception v9

    monitor-exit p0

    throw v9

    .line 391
    .restart local v1       #buffer:Ljava/lang/StringBuffer;
    .restart local v5       #locale:Ljava/util/Locale;
    .restart local v8       #version:Ljava/lang/String;
    :cond_ac
    :try_start_ac
    const-string v9, "4.0.4"

    invoke-virtual {v1, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto/16 :goto_22

    .line 395
    :cond_b3
    const-string v9, "1.0"

    invoke-virtual {v1, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto/16 :goto_22

    .line 408
    .restart local v4       #language:Ljava/lang/String;
    :cond_ba
    const-string v9, "en"

    invoke-virtual {v1, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;
    :try_end_bf
    .catchall {:try_start_ac .. :try_end_bf} :catchall_a9

    goto :goto_46
.end method

.method private native nativeSync(I)V
.end method

.method private pin(I)I
    .registers 4
    .parameter "size"

    .prologue
    const/16 v1, 0x48

    const/4 v0, 0x1

    .line 1739
    if-ge p1, v0, :cond_7

    move p1, v0

    .line 1744
    .end local p1
    :cond_6
    :goto_6
    return p1

    .line 1741
    .restart local p1
    :cond_7
    if-le p1, v1, :cond_6

    move p1, v1

    .line 1742
    goto :goto_6
.end method

.method private declared-synchronized postSync()V
    .registers 4

    .prologue
    .line 1750
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mSyncPending:Z

    if-nez v0, :cond_13

    .line 1751
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mEventHandler:Landroid/webkit/WebSettingsClassic$EventHandler;

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-static {v1, v2}, Landroid/os/Message;->obtain(Landroid/os/Handler;I)Landroid/os/Message;

    move-result-object v1

    #calls: Landroid/webkit/WebSettingsClassic$EventHandler;->sendMessage(Landroid/os/Message;)Z
    invoke-static {v0, v1}, Landroid/webkit/WebSettingsClassic$EventHandler;->access$800(Landroid/webkit/WebSettingsClassic$EventHandler;Landroid/os/Message;)Z

    move-result v0

    iput-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mSyncPending:Z
    :try_end_13
    .catchall {:try_start_1 .. :try_end_13} :catchall_15

    .line 1754
    :cond_13
    monitor-exit p0

    return-void

    .line 1750
    :catchall_15
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private verifyNetworkAccess()V
    .registers 5

    .prologue
    .line 1121
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mBlockNetworkLoads:Z

    if-nez v0, :cond_1e

    .line 1122
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mContext:Landroid/content/Context;

    const-string v1, "android.permission.INTERNET"

    invoke-static {}, Landroid/os/Process;->myPid()I

    move-result v2

    invoke-static {}, Landroid/os/Process;->myUid()I

    move-result v3

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/Context;->checkPermission(Ljava/lang/String;II)I

    move-result v0

    if-eqz v0, :cond_1e

    .line 1125
    new-instance v0, Ljava/lang/SecurityException;

    const-string v1, "Permission denied - application missing INTERNET permission"

    invoke-direct {v0, v1}, Ljava/lang/SecurityException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1130
    :cond_1e
    return-void
.end method


# virtual methods
.method public enableSmoothTransition()Z
    .registers 2

    .prologue
    .line 561
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mEnableSmoothTransition:Z

    return v0
.end method

.method public forceUserScalable()Z
    .registers 2

    .prologue
    .line 1643
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mForceUserScalable:Z

    return v0
.end method

.method declared-synchronized getAcceptLanguage()Ljava/lang/String;
    .registers 4

    .prologue
    .line 1523
    monitor-enter p0

    :try_start_1
    sget-object v2, Landroid/webkit/WebSettingsClassic;->sLockForLocaleSettings:Ljava/lang/Object;

    monitor-enter v2
    :try_end_4
    .catchall {:try_start_1 .. :try_end_4} :catchall_20

    .line 1524
    :try_start_4
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v0

    .line 1525
    .local v0, currentLocale:Ljava/util/Locale;
    sget-object v1, Landroid/webkit/WebSettingsClassic;->sLocale:Ljava/util/Locale;

    invoke-virtual {v1, v0}, Ljava/util/Locale;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_18

    .line 1526
    sput-object v0, Landroid/webkit/WebSettingsClassic;->sLocale:Ljava/util/Locale;

    .line 1527
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->getCurrentAcceptLanguage()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Landroid/webkit/WebSettingsClassic;->mAcceptLanguage:Ljava/lang/String;

    .line 1529
    :cond_18
    monitor-exit v2
    :try_end_19
    .catchall {:try_start_4 .. :try_end_19} :catchall_1d

    .line 1530
    :try_start_19
    iget-object v1, p0, Landroid/webkit/WebSettingsClassic;->mAcceptLanguage:Ljava/lang/String;
    :try_end_1b
    .catchall {:try_start_19 .. :try_end_1b} :catchall_20

    monitor-exit p0

    return-object v1

    .line 1529
    .end local v0           #currentLocale:Ljava/util/Locale;
    :catchall_1d
    move-exception v1

    :try_start_1e
    monitor-exit v2
    :try_end_1f
    .catchall {:try_start_1e .. :try_end_1f} :catchall_1d

    :try_start_1f
    throw v1
    :try_end_20
    .catchall {:try_start_1f .. :try_end_20} :catchall_20

    .line 1523
    :catchall_20
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public getAllowContentAccess()Z
    .registers 2

    .prologue
    .line 529
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mAllowContentAccess:Z

    return v0
.end method

.method public getAllowFileAccess()Z
    .registers 2

    .prologue
    .line 513
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mAllowFileAccess:Z

    return v0
.end method

.method public declared-synchronized getAllowFileAccessFromFileURLs()Z
    .registers 2

    .prologue
    .line 1401
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mAllowFileAccessFromFileURLs:Z
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getAllowUniversalAccessFromFileURLs()Z
    .registers 2

    .prologue
    .line 1393
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mAllowUniversalAccessFromFileURLs:Z
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getAutoFillEnabled()Z
    .registers 2

    .prologue
    .line 1671
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mAutoFillEnabled:Z
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getAutoFillProfile()Landroid/webkit/WebSettingsClassic$AutoFillProfile;
    .registers 2

    .prologue
    .line 1682
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mAutoFillProfile:Landroid/webkit/WebSettingsClassic$AutoFillProfile;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-object v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getBlockNetworkImage()Z
    .registers 2

    .prologue
    .line 1096
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mBlockNetworkImage:Z
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getBlockNetworkLoads()Z
    .registers 2

    .prologue
    .line 1116
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mBlockNetworkLoads:Z
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getBuiltInZoomControls()Z
    .registers 2

    .prologue
    .line 480
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mBuiltInZoomControls:Z

    return v0
.end method

.method public getCacheMode()I
    .registers 2

    .prologue
    .line 1580
    iget v0, p0, Landroid/webkit/WebSettingsClassic;->mOverrideCacheMode:I

    return v0
.end method

.method public declared-synchronized getCursiveFontFamily()Ljava/lang/String;
    .registers 2

    .prologue
    .line 946
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mCursiveFontFamily:Ljava/lang/String;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-object v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getDatabaseEnabled()Z
    .registers 2

    .prologue
    .line 1331
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mDatabaseEnabled:Z
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getDatabasePath()Ljava/lang/String;
    .registers 2

    .prologue
    .line 1323
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mDatabasePath:Ljava/lang/String;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-object v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getDefaultFixedFontSize()I
    .registers 2

    .prologue
    .line 1045
    monitor-enter p0

    :try_start_1
    iget v0, p0, Landroid/webkit/WebSettingsClassic;->mDefaultFixedFontSize:I
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getDefaultFontSize()I
    .registers 2

    .prologue
    .line 1025
    monitor-enter p0

    :try_start_1
    iget v0, p0, Landroid/webkit/WebSettingsClassic;->mDefaultFontSize:I
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getDefaultTextEncodingName()Ljava/lang/String;
    .registers 2

    .prologue
    .line 1466
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mDefaultTextEncoding:Ljava/lang/String;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-object v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getDefaultZoom()Landroid/webkit/WebSettings$ZoomDensity;
    .registers 2

    .prologue
    .line 717
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mDefaultZoom:Landroid/webkit/WebSettings$ZoomDensity;

    return-object v0
.end method

.method public getDisplayZoomControls()Z
    .registers 2

    .prologue
    .line 497
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mDisplayZoomControls:Z

    return v0
.end method

.method public declared-synchronized getDomStorageEnabled()Z
    .registers 2

    .prologue
    .line 1315
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mDomStorageEnabled:Z
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method getDoubleTapToastCount()I
    .registers 2

    .prologue
    .line 1686
    sget v0, Landroid/webkit/WebSettingsClassic;->mDoubleTapToastCount:I

    return v0
.end method

.method public getDoubleTapZoom()I
    .registers 2

    .prologue
    .line 698
    iget v0, p0, Landroid/webkit/WebSettingsClassic;->mDoubleTapZoom:I

    return v0
.end method

.method public declared-synchronized getFantasyFontFamily()Ljava/lang/String;
    .registers 2

    .prologue
    .line 965
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mFantasyFontFamily:Ljava/lang/String;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-object v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getFixedFontFamily()Ljava/lang/String;
    .registers 2

    .prologue
    .line 889
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mFixedFontFamily:Ljava/lang/String;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-object v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getHardwareAccelSkiaEnabled()Z
    .registers 2

    .prologue
    .line 1180
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mHardwareAccelSkia:Z
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getJavaScriptCanOpenWindowsAutomatically()Z
    .registers 2

    .prologue
    .line 1447
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mJavaScriptCanOpenWindowsAutomatically:Z
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getJavaScriptEnabled()Z
    .registers 2

    .prologue
    .line 1385
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mJavaScriptEnabled:Z
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getLayoutAlgorithm()Landroid/webkit/WebSettings$LayoutAlgorithm;
    .registers 2

    .prologue
    .line 851
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mLayoutAlgorithm:Landroid/webkit/WebSettings$LayoutAlgorithm;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-object v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getLightTouchEnabled()Z
    .registers 2

    .prologue
    .line 733
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mLightTouchEnabled:Z

    return v0
.end method

.method public getLoadWithOverviewMode()Z
    .registers 2

    .prologue
    .line 545
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mLoadWithOverviewMode:Z

    return v0
.end method

.method public declared-synchronized getLoadsImagesAutomatically()Z
    .registers 2

    .prologue
    .line 1077
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mLoadsImagesAutomatically:Z
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getMinimumFontSize()I
    .registers 2

    .prologue
    .line 985
    monitor-enter p0

    :try_start_1
    iget v0, p0, Landroid/webkit/WebSettingsClassic;->mMinimumFontSize:I
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getMinimumLogicalFontSize()I
    .registers 2

    .prologue
    .line 1005
    monitor-enter p0

    :try_start_1
    iget v0, p0, Landroid/webkit/WebSettingsClassic;->mMinimumLogicalFontSize:I
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getNavDump()Z
    .registers 2
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 446
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mNavDump:Z

    return v0
.end method

.method getNeedInitialFocus()Z
    .registers 2

    .prologue
    .line 1549
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mNeedInitialFocus:Z

    return v0
.end method

.method public declared-synchronized getNightReadModeEnabled()Z
    .registers 2
    .annotation build Landroid/annotation/MiuiHook;
        value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_METHOD:Landroid/annotation/MiuiHook$MiuiHookType;
    .end annotation

    .prologue
    .line 679
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mNightReadMode:Z
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getPluginState()Landroid/webkit/WebSettings$PluginState;
    .registers 2

    .prologue
    .line 1418
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mPluginState:Landroid/webkit/WebSettings$PluginState;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-object v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getPluginsEnabled()Z
    .registers 3
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 1410
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mPluginState:Landroid/webkit/WebSettings$PluginState;

    sget-object v1, Landroid/webkit/WebSettings$PluginState;->ON:Landroid/webkit/WebSettings$PluginState;
    :try_end_5
    .catchall {:try_start_1 .. :try_end_5} :catchall_c

    if-ne v0, v1, :cond_a

    const/4 v0, 0x1

    :goto_8
    monitor-exit p0

    return v0

    :cond_a
    const/4 v0, 0x0

    goto :goto_8

    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getPluginsPath()Ljava/lang/String;
    .registers 2
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 1427
    monitor-enter p0

    :try_start_1
    const-string v0, ""
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-object v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getProperty(Ljava/lang/String;)Ljava/lang/String;
    .registers 3
    .parameter "key"

    .prologue
    .line 1705
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mWebView:Landroid/webkit/WebViewClassic;

    invoke-virtual {v0, p1}, Landroid/webkit/WebViewClassic;->nativeGetProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public declared-synchronized getSansSerifFontFamily()Ljava/lang/String;
    .registers 2

    .prologue
    .line 908
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mSansSerifFontFamily:Ljava/lang/String;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-object v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getSaveFormData()Z
    .registers 2

    .prologue
    .line 595
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mSaveFormData:Z

    if-eqz v0, :cond_a

    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mPrivateBrowsingEnabled:Z

    if-nez v0, :cond_a

    const/4 v0, 0x1

    :goto_9
    return v0

    :cond_a
    const/4 v0, 0x0

    goto :goto_9
.end method

.method public getSavePassword()Z
    .registers 2

    .prologue
    .line 611
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mSavePassword:Z

    return v0
.end method

.method public declared-synchronized getSerifFontFamily()Ljava/lang/String;
    .registers 2

    .prologue
    .line 927
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mSerifFontFamily:Ljava/lang/String;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-object v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getShowVisualIndicator()Z
    .registers 2

    .prologue
    .line 1198
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mShowVisualIndicator:Z
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getStandardFontFamily()Ljava/lang/String;
    .registers 2

    .prologue
    .line 870
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mStandardFontFamily:Ljava/lang/String;
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return-object v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getTextSize()Landroid/webkit/WebSettings$TextSize;
    .registers 10

    .prologue
    .line 650
    monitor-enter p0

    const/4 v1, 0x0

    .line 651
    .local v1, closestSize:Landroid/webkit/WebSettings$TextSize;
    const v6, 0x7fffffff

    .line 652
    .local v6, smallestDelta:I
    :try_start_5
    invoke-static {}, Landroid/webkit/WebSettings$TextSize;->values()[Landroid/webkit/WebSettings$TextSize;

    move-result-object v0

    .local v0, arr$:[Landroid/webkit/WebSettings$TextSize;
    array-length v4, v0

    .local v4, len$:I
    const/4 v3, 0x0

    .local v3, i$:I
    :goto_b
    if-ge v3, v4, :cond_23

    aget-object v5, v0, v3

    .line 653
    .local v5, size:Landroid/webkit/WebSettings$TextSize;
    iget v7, p0, Landroid/webkit/WebSettingsClassic;->mTextSize:I

    iget v8, v5, Landroid/webkit/WebSettings$TextSize;->value:I

    sub-int/2addr v7, v8

    invoke-static {v7}, Ljava/lang/Math;->abs(I)I
    :try_end_17
    .catchall {:try_start_5 .. :try_end_17} :catchall_2a

    move-result v2

    .line 654
    .local v2, delta:I
    if-nez v2, :cond_1c

    .line 662
    .end local v1           #closestSize:Landroid/webkit/WebSettings$TextSize;
    .end local v2           #delta:I
    .end local v5           #size:Landroid/webkit/WebSettings$TextSize;
    :goto_1a
    monitor-exit p0

    return-object v5

    .line 657
    .restart local v1       #closestSize:Landroid/webkit/WebSettings$TextSize;
    .restart local v2       #delta:I
    .restart local v5       #size:Landroid/webkit/WebSettings$TextSize;
    :cond_1c
    if-ge v2, v6, :cond_20

    .line 658
    move v6, v2

    .line 659
    move-object v1, v5

    .line 652
    :cond_20
    add-int/lit8 v3, v3, 0x1

    goto :goto_b

    .line 662
    .end local v2           #delta:I
    .end local v5           #size:Landroid/webkit/WebSettings$TextSize;
    :cond_23
    if-eqz v1, :cond_27

    .end local v1           #closestSize:Landroid/webkit/WebSettings$TextSize;
    :goto_25
    move-object v5, v1

    goto :goto_1a

    .restart local v1       #closestSize:Landroid/webkit/WebSettings$TextSize;
    :cond_27
    :try_start_27
    sget-object v1, Landroid/webkit/WebSettings$TextSize;->NORMAL:Landroid/webkit/WebSettings$TextSize;
    :try_end_29
    .catchall {:try_start_27 .. :try_end_29} :catchall_2a

    goto :goto_25

    .line 650
    .end local v0           #arr$:[Landroid/webkit/WebSettings$TextSize;
    .end local v3           #i$:I
    .end local v4           #len$:I
    :catchall_2a
    move-exception v7

    monitor-exit p0

    throw v7
.end method

.method public declared-synchronized getTextZoom()I
    .registers 2

    .prologue
    .line 634
    monitor-enter p0

    :try_start_1
    iget v0, p0, Landroid/webkit/WebSettingsClassic;->mTextSize:I
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getUseDoubleTree()Z
    .registers 2
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 751
    monitor-enter p0

    const/4 v0, 0x0

    monitor-exit p0

    return v0
.end method

.method getUseFixedViewport()Z
    .registers 2

    .prologue
    .line 1613
    invoke-virtual {p0}, Landroid/webkit/WebSettingsClassic;->getUseWideViewPort()Z

    move-result v0

    return v0
.end method

.method public getUseWebViewBackgroundForOverscrollBackground()Z
    .registers 2
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 579
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mUseWebViewBackgroundForOverscroll:Z

    return v0
.end method

.method public declared-synchronized getUseWideViewPort()Z
    .registers 2

    .prologue
    .line 811
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mUseWideViewport:Z
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getUserAgent()I
    .registers 3
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 785
    monitor-enter p0

    :try_start_1
    const-string v0, "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/534.24 (KHTML, like Gecko) Chrome/11.0.696.34 Safari/534.24"

    iget-object v1, p0, Landroid/webkit/WebSettingsClassic;->mUserAgent:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    :try_end_8
    .catchall {:try_start_1 .. :try_end_8} :catchall_22

    move-result v0

    if-eqz v0, :cond_e

    .line 786
    const/4 v0, 0x1

    .line 792
    :goto_c
    monitor-exit p0

    return v0

    .line 787
    :cond_e
    :try_start_e
    const-string v0, "Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_0 like Mac OS X; en-us) AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0 Mobile/7A341 Safari/528.16"

    iget-object v1, p0, Landroid/webkit/WebSettingsClassic;->mUserAgent:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1a

    .line 788
    const/4 v0, 0x2

    goto :goto_c

    .line 789
    :cond_1a
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mUseDefaultUserAgent:Z
    :try_end_1c
    .catchall {:try_start_e .. :try_end_1c} :catchall_22

    if-eqz v0, :cond_20

    .line 790
    const/4 v0, 0x0

    goto :goto_c

    .line 792
    :cond_20
    const/4 v0, -0x1

    goto :goto_c

    .line 785
    :catchall_22
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getUserAgentString()Ljava/lang/String;
    .registers 5

    .prologue
    .line 1499
    monitor-enter p0

    :try_start_1
    const-string v2, "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/534.24 (KHTML, like Gecko) Chrome/11.0.696.34 Safari/534.24"

    iget-object v3, p0, Landroid/webkit/WebSettingsClassic;->mUserAgent:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_19

    const-string v2, "Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_0 like Mac OS X; en-us) AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0 Mobile/7A341 Safari/528.16"

    iget-object v3, p0, Landroid/webkit/WebSettingsClassic;->mUserAgent:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_19

    iget-boolean v2, p0, Landroid/webkit/WebSettingsClassic;->mUseDefaultUserAgent:Z

    if-nez v2, :cond_1d

    .line 1502
    :cond_19
    iget-object v2, p0, Landroid/webkit/WebSettingsClassic;->mUserAgent:Ljava/lang/String;
    :try_end_1b
    .catchall {:try_start_1 .. :try_end_1b} :catchall_48

    .line 1518
    :goto_1b
    monitor-exit p0

    return-object v2

    .line 1505
    :cond_1d
    const/4 v1, 0x0

    .line 1506
    .local v1, doPostSync:Z
    :try_start_1e
    sget-object v3, Landroid/webkit/WebSettingsClassic;->sLockForLocaleSettings:Ljava/lang/Object;

    monitor-enter v3
    :try_end_21
    .catchall {:try_start_1e .. :try_end_21} :catchall_48

    .line 1507
    :try_start_21
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v0

    .line 1508
    .local v0, currentLocale:Ljava/util/Locale;
    sget-object v2, Landroid/webkit/WebSettingsClassic;->sLocale:Ljava/util/Locale;

    invoke-virtual {v2, v0}, Ljava/util/Locale;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_3c

    .line 1509
    sput-object v0, Landroid/webkit/WebSettingsClassic;->sLocale:Ljava/util/Locale;

    .line 1510
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->getCurrentUserAgent()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Landroid/webkit/WebSettingsClassic;->mUserAgent:Ljava/lang/String;

    .line 1511
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->getCurrentAcceptLanguage()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Landroid/webkit/WebSettingsClassic;->mAcceptLanguage:Ljava/lang/String;

    .line 1512
    const/4 v1, 0x1

    .line 1514
    :cond_3c
    monitor-exit v3
    :try_end_3d
    .catchall {:try_start_21 .. :try_end_3d} :catchall_45

    .line 1515
    if-eqz v1, :cond_42

    .line 1516
    :try_start_3f
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V

    .line 1518
    :cond_42
    iget-object v2, p0, Landroid/webkit/WebSettingsClassic;->mUserAgent:Ljava/lang/String;
    :try_end_44
    .catchall {:try_start_3f .. :try_end_44} :catchall_48

    goto :goto_1b

    .line 1514
    .end local v0           #currentLocale:Ljava/util/Locale;
    :catchall_45
    move-exception v2

    :try_start_46
    monitor-exit v3
    :try_end_47
    .catchall {:try_start_46 .. :try_end_47} :catchall_45

    :try_start_47
    throw v2
    :try_end_48
    .catchall {:try_start_47 .. :try_end_48} :catchall_48

    .line 1499
    .end local v1           #doPostSync:Z
    :catchall_48
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method isNarrowColumnLayout()Z
    .registers 3

    .prologue
    .line 1534
    invoke-virtual {p0}, Landroid/webkit/WebSettingsClassic;->getLayoutAlgorithm()Landroid/webkit/WebSettings$LayoutAlgorithm;

    move-result-object v0

    sget-object v1, Landroid/webkit/WebSettings$LayoutAlgorithm;->NARROW_COLUMNS:Landroid/webkit/WebSettings$LayoutAlgorithm;

    if-ne v0, v1, :cond_a

    const/4 v0, 0x1

    :goto_9
    return v0

    :cond_a
    const/4 v0, 0x0

    goto :goto_9
.end method

.method isPrivateBrowsingEnabled()Z
    .registers 2

    .prologue
    .line 1620
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mPrivateBrowsingEnabled:Z

    return v0
.end method

.method declared-synchronized onDestroyed()V
    .registers 1

    .prologue
    .line 1735
    monitor-enter p0

    monitor-exit p0

    return-void
.end method

.method public setAllowContentAccess(Z)V
    .registers 2
    .parameter "allow"

    .prologue
    .line 521
    iput-boolean p1, p0, Landroid/webkit/WebSettingsClassic;->mAllowContentAccess:Z

    .line 522
    return-void
.end method

.method public setAllowFileAccess(Z)V
    .registers 2
    .parameter "allow"

    .prologue
    .line 505
    iput-boolean p1, p0, Landroid/webkit/WebSettingsClassic;->mAllowFileAccess:Z

    .line 506
    return-void
.end method

.method public declared-synchronized setAllowFileAccessFromFileURLs(Z)V
    .registers 3
    .parameter "flag"

    .prologue
    .line 1159
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mAllowFileAccessFromFileURLs:Z

    if-eq v0, p1, :cond_a

    .line 1160
    iput-boolean p1, p0, Landroid/webkit/WebSettingsClassic;->mAllowFileAccessFromFileURLs:Z

    .line 1161
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_c

    .line 1163
    :cond_a
    monitor-exit p0

    return-void

    .line 1159
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setAllowUniversalAccessFromFileURLs(Z)V
    .registers 3
    .parameter "flag"

    .prologue
    .line 1148
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mAllowUniversalAccessFromFileURLs:Z

    if-eq v0, p1, :cond_a

    .line 1149
    iput-boolean p1, p0, Landroid/webkit/WebSettingsClassic;->mAllowUniversalAccessFromFileURLs:Z

    .line 1150
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_c

    .line 1152
    :cond_a
    monitor-exit p0

    return-void

    .line 1148
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setAppCacheEnabled(Z)V
    .registers 3
    .parameter "flag"

    .prologue
    .line 1258
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mAppCacheEnabled:Z

    if-eq v0, p1, :cond_a

    .line 1259
    iput-boolean p1, p0, Landroid/webkit/WebSettingsClassic;->mAppCacheEnabled:Z

    .line 1260
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_c

    .line 1262
    :cond_a
    monitor-exit p0

    return-void

    .line 1258
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setAppCacheMaxSize(J)V
    .registers 5
    .parameter "appCacheMaxSize"

    .prologue
    .line 1282
    monitor-enter p0

    :try_start_1
    iget-wide v0, p0, Landroid/webkit/WebSettingsClassic;->mAppCacheMaxSize:J

    cmp-long v0, p1, v0

    if-eqz v0, :cond_c

    .line 1283
    iput-wide p1, p0, Landroid/webkit/WebSettingsClassic;->mAppCacheMaxSize:J

    .line 1284
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_c
    .catchall {:try_start_1 .. :try_end_c} :catchall_e

    .line 1286
    :cond_c
    monitor-exit p0

    return-void

    .line 1282
    :catchall_e
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setAppCachePath(Ljava/lang/String;)V
    .registers 3
    .parameter "path"

    .prologue
    .line 1271
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mAppCachePath:Ljava/lang/String;

    if-nez v0, :cond_12

    if-eqz p1, :cond_12

    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_12

    .line 1272
    iput-object p1, p0, Landroid/webkit/WebSettingsClassic;->mAppCachePath:Ljava/lang/String;

    .line 1273
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_12
    .catchall {:try_start_1 .. :try_end_12} :catchall_14

    .line 1275
    :cond_12
    monitor-exit p0

    return-void

    .line 1271
    :catchall_14
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setAutoFillEnabled(Z)V
    .registers 4
    .parameter "enabled"

    .prologue
    .line 1663
    monitor-enter p0

    if-eqz p1, :cond_13

    :try_start_3
    iget-boolean v1, p0, Landroid/webkit/WebSettingsClassic;->mPrivateBrowsingEnabled:Z

    if-nez v1, :cond_13

    const/4 v0, 0x1

    .line 1664
    .local v0, autoFillEnabled:Z
    :goto_8
    iget-boolean v1, p0, Landroid/webkit/WebSettingsClassic;->mAutoFillEnabled:Z

    if-eq v1, v0, :cond_11

    .line 1665
    iput-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mAutoFillEnabled:Z

    .line 1666
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_11
    .catchall {:try_start_3 .. :try_end_11} :catchall_15

    .line 1668
    :cond_11
    monitor-exit p0

    return-void

    .line 1663
    .end local v0           #autoFillEnabled:Z
    :cond_13
    const/4 v0, 0x0

    goto :goto_8

    :catchall_15
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized setAutoFillProfile(Landroid/webkit/WebSettingsClassic$AutoFillProfile;)V
    .registers 3
    .parameter "profile"

    .prologue
    .line 1675
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mAutoFillProfile:Landroid/webkit/WebSettingsClassic$AutoFillProfile;

    if-eq v0, p1, :cond_a

    .line 1676
    iput-object p1, p0, Landroid/webkit/WebSettingsClassic;->mAutoFillProfile:Landroid/webkit/WebSettingsClassic$AutoFillProfile;

    .line 1677
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_c

    .line 1679
    :cond_a
    monitor-exit p0

    return-void

    .line 1675
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setBlockNetworkImage(Z)V
    .registers 3
    .parameter "flag"

    .prologue
    .line 1085
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mBlockNetworkImage:Z

    if-eq v0, p1, :cond_a

    .line 1086
    iput-boolean p1, p0, Landroid/webkit/WebSettingsClassic;->mBlockNetworkImage:Z

    .line 1087
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_c

    .line 1089
    :cond_a
    monitor-exit p0

    return-void

    .line 1085
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setBlockNetworkLoads(Z)V
    .registers 3
    .parameter "flag"

    .prologue
    .line 1104
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mBlockNetworkLoads:Z

    if-eq v0, p1, :cond_d

    .line 1105
    iput-boolean p1, p0, Landroid/webkit/WebSettingsClassic;->mBlockNetworkLoads:Z

    .line 1106
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->verifyNetworkAccess()V

    .line 1107
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_d
    .catchall {:try_start_1 .. :try_end_d} :catchall_f

    .line 1109
    :cond_d
    monitor-exit p0

    return-void

    .line 1104
    :catchall_f
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public setBuiltInZoomControls(Z)V
    .registers 4
    .parameter "enabled"

    .prologue
    .line 471
    iput-boolean p1, p0, Landroid/webkit/WebSettingsClassic;->mBuiltInZoomControls:Z

    .line 472
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mWebView:Landroid/webkit/WebViewClassic;

    iget-object v1, p0, Landroid/webkit/WebSettingsClassic;->mContext:Landroid/content/Context;

    invoke-virtual {v0, v1}, Landroid/webkit/WebViewClassic;->updateMultiTouchSupport(Landroid/content/Context;)V

    .line 473
    return-void
.end method

.method public setCacheMode(I)V
    .registers 3
    .parameter "mode"

    .prologue
    .line 1569
    iget v0, p0, Landroid/webkit/WebSettingsClassic;->mOverrideCacheMode:I

    if-eq p1, v0, :cond_9

    .line 1570
    iput p1, p0, Landroid/webkit/WebSettingsClassic;->mOverrideCacheMode:I

    .line 1571
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V

    .line 1573
    :cond_9
    return-void
.end method

.method public declared-synchronized setCursiveFontFamily(Ljava/lang/String;)V
    .registers 3
    .parameter "font"

    .prologue
    .line 935
    monitor-enter p0

    if-eqz p1, :cond_10

    :try_start_3
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mCursiveFontFamily:Ljava/lang/String;

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_10

    .line 936
    iput-object p1, p0, Landroid/webkit/WebSettingsClassic;->mCursiveFontFamily:Ljava/lang/String;

    .line 937
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_10
    .catchall {:try_start_3 .. :try_end_10} :catchall_12

    .line 939
    :cond_10
    monitor-exit p0

    return-void

    .line 935
    :catchall_12
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setDatabaseEnabled(Z)V
    .registers 3
    .parameter "flag"

    .prologue
    .line 1293
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mDatabaseEnabled:Z

    if-eq v0, p1, :cond_a

    .line 1294
    iput-boolean p1, p0, Landroid/webkit/WebSettingsClassic;->mDatabaseEnabled:Z

    .line 1295
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_c

    .line 1297
    :cond_a
    monitor-exit p0

    return-void

    .line 1293
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setDatabasePath(Ljava/lang/String;)V
    .registers 3
    .parameter "databasePath"

    .prologue
    .line 1234
    monitor-enter p0

    if-eqz p1, :cond_f

    :try_start_3
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mDatabasePathHasBeenSet:Z

    if-nez v0, :cond_f

    .line 1235
    iput-object p1, p0, Landroid/webkit/WebSettingsClassic;->mDatabasePath:Ljava/lang/String;

    .line 1236
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mDatabasePathHasBeenSet:Z

    .line 1237
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_f
    .catchall {:try_start_3 .. :try_end_f} :catchall_11

    .line 1239
    :cond_f
    monitor-exit p0

    return-void

    .line 1234
    :catchall_11
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setDefaultFixedFontSize(I)V
    .registers 3
    .parameter "size"

    .prologue
    .line 1033
    monitor-enter p0

    :try_start_1
    invoke-direct {p0, p1}, Landroid/webkit/WebSettingsClassic;->pin(I)I

    move-result p1

    .line 1034
    iget v0, p0, Landroid/webkit/WebSettingsClassic;->mDefaultFixedFontSize:I

    if-eq v0, p1, :cond_e

    .line 1035
    iput p1, p0, Landroid/webkit/WebSettingsClassic;->mDefaultFixedFontSize:I

    .line 1036
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_e
    .catchall {:try_start_1 .. :try_end_e} :catchall_10

    .line 1038
    :cond_e
    monitor-exit p0

    return-void

    .line 1033
    :catchall_10
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setDefaultFontSize(I)V
    .registers 3
    .parameter "size"

    .prologue
    .line 1013
    monitor-enter p0

    :try_start_1
    invoke-direct {p0, p1}, Landroid/webkit/WebSettingsClassic;->pin(I)I

    move-result p1

    .line 1014
    iget v0, p0, Landroid/webkit/WebSettingsClassic;->mDefaultFontSize:I

    if-eq v0, p1, :cond_e

    .line 1015
    iput p1, p0, Landroid/webkit/WebSettingsClassic;->mDefaultFontSize:I

    .line 1016
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_e
    .catchall {:try_start_1 .. :try_end_e} :catchall_10

    .line 1018
    :cond_e
    monitor-exit p0

    return-void

    .line 1013
    :catchall_10
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setDefaultTextEncodingName(Ljava/lang/String;)V
    .registers 3
    .parameter "encoding"

    .prologue
    .line 1455
    monitor-enter p0

    if-eqz p1, :cond_10

    :try_start_3
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mDefaultTextEncoding:Ljava/lang/String;

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_10

    .line 1456
    iput-object p1, p0, Landroid/webkit/WebSettingsClassic;->mDefaultTextEncoding:Ljava/lang/String;

    .line 1457
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_10
    .catchall {:try_start_3 .. :try_end_10} :catchall_12

    .line 1459
    :cond_10
    monitor-exit p0

    return-void

    .line 1455
    :catchall_12
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public setDefaultZoom(Landroid/webkit/WebSettings$ZoomDensity;)V
    .registers 4
    .parameter "zoom"

    .prologue
    .line 706
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mDefaultZoom:Landroid/webkit/WebSettings$ZoomDensity;

    if-eq v0, p1, :cond_d

    .line 707
    iput-object p1, p0, Landroid/webkit/WebSettingsClassic;->mDefaultZoom:Landroid/webkit/WebSettings$ZoomDensity;

    .line 708
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mWebView:Landroid/webkit/WebViewClassic;

    iget v1, p1, Landroid/webkit/WebSettings$ZoomDensity;->value:I

    invoke-virtual {v0, v1}, Landroid/webkit/WebViewClassic;->adjustDefaultZoomDensity(I)V

    .line 710
    :cond_d
    return-void
.end method

.method public setDisplayZoomControls(Z)V
    .registers 4
    .parameter "enabled"

    .prologue
    .line 488
    iput-boolean p1, p0, Landroid/webkit/WebSettingsClassic;->mDisplayZoomControls:Z

    .line 489
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mWebView:Landroid/webkit/WebViewClassic;

    iget-object v1, p0, Landroid/webkit/WebSettingsClassic;->mContext:Landroid/content/Context;

    invoke-virtual {v0, v1}, Landroid/webkit/WebViewClassic;->updateMultiTouchSupport(Landroid/content/Context;)V

    .line 490
    return-void
.end method

.method public declared-synchronized setDomStorageEnabled(Z)V
    .registers 3
    .parameter "flag"

    .prologue
    .line 1304
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mDomStorageEnabled:Z

    if-eq v0, p1, :cond_a

    .line 1305
    iput-boolean p1, p0, Landroid/webkit/WebSettingsClassic;->mDomStorageEnabled:Z

    .line 1306
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_c

    .line 1308
    :cond_a
    monitor-exit p0

    return-void

    .line 1304
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method setDoubleTapToastCount(I)V
    .registers 5
    .parameter "count"

    .prologue
    .line 1690
    sget v0, Landroid/webkit/WebSettingsClassic;->mDoubleTapToastCount:I

    if-eq v0, p1, :cond_11

    .line 1691
    sput p1, Landroid/webkit/WebSettingsClassic;->mDoubleTapToastCount:I

    .line 1693
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mEventHandler:Landroid/webkit/WebSettingsClassic$EventHandler;

    const/4 v1, 0x0

    const/4 v2, 0x2

    invoke-static {v1, v2}, Landroid/os/Message;->obtain(Landroid/os/Handler;I)Landroid/os/Message;

    move-result-object v1

    #calls: Landroid/webkit/WebSettingsClassic$EventHandler;->sendMessage(Landroid/os/Message;)Z
    invoke-static {v0, v1}, Landroid/webkit/WebSettingsClassic$EventHandler;->access$800(Landroid/webkit/WebSettingsClassic$EventHandler;Landroid/os/Message;)Z

    .line 1696
    :cond_11
    return-void
.end method

.method public setDoubleTapZoom(I)V
    .registers 3
    .parameter "doubleTapZoom"

    .prologue
    .line 687
    iget v0, p0, Landroid/webkit/WebSettingsClassic;->mDoubleTapZoom:I

    if-eq v0, p1, :cond_b

    .line 688
    iput p1, p0, Landroid/webkit/WebSettingsClassic;->mDoubleTapZoom:I

    .line 689
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mWebView:Landroid/webkit/WebViewClassic;

    invoke-virtual {v0, p1}, Landroid/webkit/WebViewClassic;->updateDoubleTapZoom(I)V

    .line 691
    :cond_b
    return-void
.end method

.method public setEnableSmoothTransition(Z)V
    .registers 2
    .parameter "enable"

    .prologue
    .line 553
    iput-boolean p1, p0, Landroid/webkit/WebSettingsClassic;->mEnableSmoothTransition:Z

    .line 554
    return-void
.end method

.method public declared-synchronized setFantasyFontFamily(Ljava/lang/String;)V
    .registers 3
    .parameter "font"

    .prologue
    .line 954
    monitor-enter p0

    if-eqz p1, :cond_10

    :try_start_3
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mFantasyFontFamily:Ljava/lang/String;

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_10

    .line 955
    iput-object p1, p0, Landroid/webkit/WebSettingsClassic;->mFantasyFontFamily:Ljava/lang/String;

    .line 956
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_10
    .catchall {:try_start_3 .. :try_end_10} :catchall_12

    .line 958
    :cond_10
    monitor-exit p0

    return-void

    .line 954
    :catchall_12
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setFixedFontFamily(Ljava/lang/String;)V
    .registers 3
    .parameter "font"

    .prologue
    .line 878
    monitor-enter p0

    if-eqz p1, :cond_10

    :try_start_3
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mFixedFontFamily:Ljava/lang/String;

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_10

    .line 879
    iput-object p1, p0, Landroid/webkit/WebSettingsClassic;->mFixedFontFamily:Ljava/lang/String;

    .line 880
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_10
    .catchall {:try_start_3 .. :try_end_10} :catchall_12

    .line 882
    :cond_10
    monitor-exit p0

    return-void

    .line 878
    :catchall_12
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setForceUserScalable(Z)V
    .registers 3
    .parameter "flag"

    .prologue
    .line 1651
    monitor-enter p0

    :try_start_1
    iput-boolean p1, p0, Landroid/webkit/WebSettingsClassic;->mForceUserScalable:Z
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    .line 1652
    monitor-exit p0

    return-void

    .line 1651
    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setGeolocationDatabasePath(Ljava/lang/String;)V
    .registers 3
    .parameter "databasePath"

    .prologue
    .line 1246
    monitor-enter p0

    if-eqz p1, :cond_10

    :try_start_3
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mGeolocationDatabasePath:Ljava/lang/String;

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_10

    .line 1248
    iput-object p1, p0, Landroid/webkit/WebSettingsClassic;->mGeolocationDatabasePath:Ljava/lang/String;

    .line 1249
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_10
    .catchall {:try_start_3 .. :try_end_10} :catchall_12

    .line 1251
    :cond_10
    monitor-exit p0

    return-void

    .line 1246
    :catchall_12
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setGeolocationEnabled(Z)V
    .registers 3
    .parameter "flag"

    .prologue
    .line 1352
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mGeolocationEnabled:Z

    if-eq v0, p1, :cond_a

    .line 1353
    iput-boolean p1, p0, Landroid/webkit/WebSettingsClassic;->mGeolocationEnabled:Z

    .line 1354
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_c

    .line 1356
    :cond_a
    monitor-exit p0

    return-void

    .line 1352
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setHardwareAccelSkiaEnabled(Z)V
    .registers 3
    .parameter "flag"

    .prologue
    .line 1170
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mHardwareAccelSkia:Z

    if-eq v0, p1, :cond_a

    .line 1171
    iput-boolean p1, p0, Landroid/webkit/WebSettingsClassic;->mHardwareAccelSkia:Z

    .line 1172
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_c

    .line 1174
    :cond_a
    monitor-exit p0

    return-void

    .line 1170
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setJavaScriptCanOpenWindowsAutomatically(Z)V
    .registers 3
    .parameter "flag"

    .prologue
    .line 1436
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mJavaScriptCanOpenWindowsAutomatically:Z

    if-eq v0, p1, :cond_a

    .line 1437
    iput-boolean p1, p0, Landroid/webkit/WebSettingsClassic;->mJavaScriptCanOpenWindowsAutomatically:Z

    .line 1438
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_c

    .line 1440
    :cond_a
    monitor-exit p0

    return-void

    .line 1436
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setJavaScriptEnabled(Z)V
    .registers 3
    .parameter "flag"

    .prologue
    .line 1137
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mJavaScriptEnabled:Z

    if-eq v0, p1, :cond_a

    .line 1138
    iput-boolean p1, p0, Landroid/webkit/WebSettingsClassic;->mJavaScriptEnabled:Z

    .line 1139
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_c

    .line 1141
    :cond_a
    monitor-exit p0

    return-void

    .line 1137
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setLayoutAlgorithm(Landroid/webkit/WebSettings$LayoutAlgorithm;)V
    .registers 3
    .parameter "l"

    .prologue
    .line 840
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mLayoutAlgorithm:Landroid/webkit/WebSettings$LayoutAlgorithm;

    if-eq v0, p1, :cond_a

    .line 841
    iput-object p1, p0, Landroid/webkit/WebSettingsClassic;->mLayoutAlgorithm:Landroid/webkit/WebSettings$LayoutAlgorithm;

    .line 842
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_c

    .line 844
    :cond_a
    monitor-exit p0

    return-void

    .line 840
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public setLightTouchEnabled(Z)V
    .registers 2
    .parameter "enabled"

    .prologue
    .line 725
    iput-boolean p1, p0, Landroid/webkit/WebSettingsClassic;->mLightTouchEnabled:Z

    .line 726
    return-void
.end method

.method public declared-synchronized setLinkPrefetchEnabled(Z)V
    .registers 3
    .parameter "flag"

    .prologue
    .line 1374
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mLinkPrefetchEnabled:Z

    if-eq v0, p1, :cond_a

    .line 1375
    iput-boolean p1, p0, Landroid/webkit/WebSettingsClassic;->mLinkPrefetchEnabled:Z

    .line 1376
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_c

    .line 1378
    :cond_a
    monitor-exit p0

    return-void

    .line 1374
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public setLoadWithOverviewMode(Z)V
    .registers 2
    .parameter "overview"

    .prologue
    .line 537
    iput-boolean p1, p0, Landroid/webkit/WebSettingsClassic;->mLoadWithOverviewMode:Z

    .line 538
    return-void
.end method

.method public declared-synchronized setLoadsImagesAutomatically(Z)V
    .registers 3
    .parameter "flag"

    .prologue
    .line 1066
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mLoadsImagesAutomatically:Z

    if-eq v0, p1, :cond_a

    .line 1067
    iput-boolean p1, p0, Landroid/webkit/WebSettingsClassic;->mLoadsImagesAutomatically:Z

    .line 1068
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_c

    .line 1070
    :cond_a
    monitor-exit p0

    return-void

    .line 1066
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public setMaximumDecodedImageSize(J)V
    .registers 5
    .parameter "size"

    .prologue
    .line 1602
    iget-wide v0, p0, Landroid/webkit/WebSettingsClassic;->mMaximumDecodedImageSize:J

    cmp-long v0, v0, p1

    if-eqz v0, :cond_b

    .line 1603
    iput-wide p1, p0, Landroid/webkit/WebSettingsClassic;->mMaximumDecodedImageSize:J

    .line 1604
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V

    .line 1606
    :cond_b
    return-void
.end method

.method public declared-synchronized setMinimumFontSize(I)V
    .registers 3
    .parameter "size"

    .prologue
    .line 973
    monitor-enter p0

    :try_start_1
    invoke-direct {p0, p1}, Landroid/webkit/WebSettingsClassic;->pin(I)I

    move-result p1

    .line 974
    iget v0, p0, Landroid/webkit/WebSettingsClassic;->mMinimumFontSize:I

    if-eq v0, p1, :cond_e

    .line 975
    iput p1, p0, Landroid/webkit/WebSettingsClassic;->mMinimumFontSize:I

    .line 976
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_e
    .catchall {:try_start_1 .. :try_end_e} :catchall_10

    .line 978
    :cond_e
    monitor-exit p0

    return-void

    .line 973
    :catchall_10
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setMinimumLogicalFontSize(I)V
    .registers 3
    .parameter "size"

    .prologue
    .line 993
    monitor-enter p0

    :try_start_1
    invoke-direct {p0, p1}, Landroid/webkit/WebSettingsClassic;->pin(I)I

    move-result p1

    .line 994
    iget v0, p0, Landroid/webkit/WebSettingsClassic;->mMinimumLogicalFontSize:I

    if-eq v0, p1, :cond_e

    .line 995
    iput p1, p0, Landroid/webkit/WebSettingsClassic;->mMinimumLogicalFontSize:I

    .line 996
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_e
    .catchall {:try_start_1 .. :try_end_e} :catchall_10

    .line 998
    :cond_e
    monitor-exit p0

    return-void

    .line 993
    :catchall_10
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public setNavDump(Z)V
    .registers 2
    .parameter "enabled"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 437
    iput-boolean p1, p0, Landroid/webkit/WebSettingsClassic;->mNavDump:Z

    .line 438
    return-void
.end method

.method public setNeedInitialFocus(Z)V
    .registers 3
    .parameter "flag"

    .prologue
    .line 1542
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mNeedInitialFocus:Z

    if-eq v0, p1, :cond_6

    .line 1543
    iput-boolean p1, p0, Landroid/webkit/WebSettingsClassic;->mNeedInitialFocus:Z

    .line 1545
    :cond_6
    return-void
.end method

.method public declared-synchronized setNightReadModeEnabled(Z)V
    .registers 3
    .parameter "enable"
    .annotation build Landroid/annotation/MiuiHook;
        value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_METHOD:Landroid/annotation/MiuiHook$MiuiHookType;
    .end annotation

    .prologue
    .line 670
    monitor-enter p0

    :try_start_1
    iput-boolean p1, p0, Landroid/webkit/WebSettingsClassic;->mNightReadMode:Z

    .line 671
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_6
    .catchall {:try_start_1 .. :try_end_6} :catchall_8

    .line 672
    monitor-exit p0

    return-void

    .line 670
    :catchall_8
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setPageCacheCapacity(I)V
    .registers 3
    .parameter "size"

    .prologue
    .line 1053
    monitor-enter p0

    if-gez p1, :cond_4

    const/4 p1, 0x0

    .line 1054
    :cond_4
    const/16 v0, 0x14

    if-le p1, v0, :cond_a

    const/16 p1, 0x14

    .line 1055
    :cond_a
    :try_start_a
    iget v0, p0, Landroid/webkit/WebSettingsClassic;->mPageCacheCapacity:I

    if-eq v0, p1, :cond_13

    .line 1056
    iput p1, p0, Landroid/webkit/WebSettingsClassic;->mPageCacheCapacity:I

    .line 1057
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_13
    .catchall {:try_start_a .. :try_end_13} :catchall_15

    .line 1059
    :cond_13
    monitor-exit p0

    return-void

    .line 1053
    :catchall_15
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setPluginState(Landroid/webkit/WebSettings$PluginState;)V
    .registers 3
    .parameter "state"

    .prologue
    .line 1215
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mPluginState:Landroid/webkit/WebSettings$PluginState;

    if-eq v0, p1, :cond_a

    .line 1216
    iput-object p1, p0, Landroid/webkit/WebSettingsClassic;->mPluginState:Landroid/webkit/WebSettings$PluginState;

    .line 1217
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_c

    .line 1219
    :cond_a
    monitor-exit p0

    return-void

    .line 1215
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setPluginsEnabled(Z)V
    .registers 3
    .parameter "flag"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 1207
    monitor-enter p0

    if-eqz p1, :cond_a

    :try_start_3
    sget-object v0, Landroid/webkit/WebSettings$PluginState;->ON:Landroid/webkit/WebSettings$PluginState;

    :goto_5
    invoke-virtual {p0, v0}, Landroid/webkit/WebSettingsClassic;->setPluginState(Landroid/webkit/WebSettings$PluginState;)V
    :try_end_8
    .catchall {:try_start_3 .. :try_end_8} :catchall_d

    .line 1208
    monitor-exit p0

    return-void

    .line 1207
    :cond_a
    :try_start_a
    sget-object v0, Landroid/webkit/WebSettings$PluginState;->OFF:Landroid/webkit/WebSettings$PluginState;
    :try_end_c
    .catchall {:try_start_a .. :try_end_c} :catchall_d

    goto :goto_5

    :catchall_d
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setPluginsPath(Ljava/lang/String;)V
    .registers 2
    .parameter "pluginsPath"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 1227
    monitor-enter p0

    monitor-exit p0

    return-void
.end method

.method declared-synchronized setPrivateBrowsingEnabled(Z)V
    .registers 3
    .parameter "flag"

    .prologue
    .line 1628
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mPrivateBrowsingEnabled:Z

    if-eq v0, p1, :cond_f

    .line 1629
    iput-boolean p1, p0, Landroid/webkit/WebSettingsClassic;->mPrivateBrowsingEnabled:Z

    .line 1633
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mAutoFillEnabled:Z

    invoke-virtual {p0, v0}, Landroid/webkit/WebSettingsClassic;->setAutoFillEnabled(Z)V

    .line 1635
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_f
    .catchall {:try_start_1 .. :try_end_f} :catchall_11

    .line 1637
    :cond_f
    monitor-exit p0

    return-void

    .line 1628
    :catchall_11
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public setProperty(Ljava/lang/String;Ljava/lang/String;)V
    .registers 4
    .parameter "key"
    .parameter "value"

    .prologue
    .line 1699
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mWebView:Landroid/webkit/WebViewClassic;

    invoke-virtual {v0, p1, p2}, Landroid/webkit/WebViewClassic;->nativeSetProperty(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_d

    .line 1700
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mWebView:Landroid/webkit/WebViewClassic;

    invoke-virtual {v0}, Landroid/webkit/WebViewClassic;->invalidate()V

    .line 1702
    :cond_d
    return-void
.end method

.method public declared-synchronized setRenderPriority(Landroid/webkit/WebSettings$RenderPriority;)V
    .registers 5
    .parameter "priority"

    .prologue
    .line 1557
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mRenderPriority:Landroid/webkit/WebSettings$RenderPriority;

    if-eq v0, p1, :cond_12

    .line 1558
    iput-object p1, p0, Landroid/webkit/WebSettingsClassic;->mRenderPriority:Landroid/webkit/WebSettings$RenderPriority;

    .line 1559
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mEventHandler:Landroid/webkit/WebSettingsClassic$EventHandler;

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-static {v1, v2}, Landroid/os/Message;->obtain(Landroid/os/Handler;I)Landroid/os/Message;

    move-result-object v1

    #calls: Landroid/webkit/WebSettingsClassic$EventHandler;->sendMessage(Landroid/os/Message;)Z
    invoke-static {v0, v1}, Landroid/webkit/WebSettingsClassic$EventHandler;->access$800(Landroid/webkit/WebSettingsClassic$EventHandler;Landroid/os/Message;)Z
    :try_end_12
    .catchall {:try_start_1 .. :try_end_12} :catchall_14

    .line 1562
    :cond_12
    monitor-exit p0

    return-void

    .line 1557
    :catchall_14
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setSansSerifFontFamily(Ljava/lang/String;)V
    .registers 3
    .parameter "font"

    .prologue
    .line 897
    monitor-enter p0

    if-eqz p1, :cond_10

    :try_start_3
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mSansSerifFontFamily:Ljava/lang/String;

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_10

    .line 898
    iput-object p1, p0, Landroid/webkit/WebSettingsClassic;->mSansSerifFontFamily:Ljava/lang/String;

    .line 899
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_10
    .catchall {:try_start_3 .. :try_end_10} :catchall_12

    .line 901
    :cond_10
    monitor-exit p0

    return-void

    .line 897
    :catchall_12
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public setSaveFormData(Z)V
    .registers 2
    .parameter "save"

    .prologue
    .line 587
    iput-boolean p1, p0, Landroid/webkit/WebSettingsClassic;->mSaveFormData:Z

    .line 588
    return-void
.end method

.method public setSavePassword(Z)V
    .registers 2
    .parameter "save"

    .prologue
    .line 603
    iput-boolean p1, p0, Landroid/webkit/WebSettingsClassic;->mSavePassword:Z

    .line 604
    return-void
.end method

.method public declared-synchronized setSerifFontFamily(Ljava/lang/String;)V
    .registers 3
    .parameter "font"

    .prologue
    .line 916
    monitor-enter p0

    if-eqz p1, :cond_10

    :try_start_3
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mSerifFontFamily:Ljava/lang/String;

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_10

    .line 917
    iput-object p1, p0, Landroid/webkit/WebSettingsClassic;->mSerifFontFamily:Ljava/lang/String;

    .line 918
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_10
    .catchall {:try_start_3 .. :try_end_10} :catchall_12

    .line 920
    :cond_10
    monitor-exit p0

    return-void

    .line 916
    :catchall_12
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setShowVisualIndicator(Z)V
    .registers 3
    .parameter "flag"

    .prologue
    .line 1188
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mShowVisualIndicator:Z

    if-eq v0, p1, :cond_a

    .line 1189
    iput-boolean p1, p0, Landroid/webkit/WebSettingsClassic;->mShowVisualIndicator:Z

    .line 1190
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_c

    .line 1192
    :cond_a
    monitor-exit p0

    return-void

    .line 1188
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public setShrinksStandaloneImagesToFit(Z)V
    .registers 3
    .parameter "shrink"

    .prologue
    .line 1590
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mShrinksStandaloneImagesToFit:Z

    if-eq v0, p1, :cond_9

    .line 1591
    iput-boolean p1, p0, Landroid/webkit/WebSettingsClassic;->mShrinksStandaloneImagesToFit:Z

    .line 1592
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V

    .line 1594
    :cond_9
    return-void
.end method

.method public declared-synchronized setStandardFontFamily(Ljava/lang/String;)V
    .registers 3
    .parameter "font"

    .prologue
    .line 859
    monitor-enter p0

    if-eqz p1, :cond_10

    :try_start_3
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mStandardFontFamily:Ljava/lang/String;

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_10

    .line 860
    iput-object p1, p0, Landroid/webkit/WebSettingsClassic;->mStandardFontFamily:Ljava/lang/String;

    .line 861
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_10
    .catchall {:try_start_3 .. :try_end_10} :catchall_12

    .line 863
    :cond_10
    monitor-exit p0

    return-void

    .line 859
    :catchall_12
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setSupportMultipleWindows(Z)V
    .registers 3
    .parameter "support"

    .prologue
    .line 819
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mSupportMultipleWindows:Z

    if-eq v0, p1, :cond_a

    .line 820
    iput-boolean p1, p0, Landroid/webkit/WebSettingsClassic;->mSupportMultipleWindows:Z

    .line 821
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_c

    .line 823
    :cond_a
    monitor-exit p0

    return-void

    .line 819
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public setSupportZoom(Z)V
    .registers 4
    .parameter "support"

    .prologue
    .line 454
    iput-boolean p1, p0, Landroid/webkit/WebSettingsClassic;->mSupportZoom:Z

    .line 455
    iget-object v0, p0, Landroid/webkit/WebSettingsClassic;->mWebView:Landroid/webkit/WebViewClassic;

    iget-object v1, p0, Landroid/webkit/WebSettingsClassic;->mContext:Landroid/content/Context;

    invoke-virtual {v0, v1}, Landroid/webkit/WebViewClassic;->updateMultiTouchSupport(Landroid/content/Context;)V

    .line 456
    return-void
.end method

.method declared-synchronized setSyntheticLinksEnabled(Z)V
    .registers 3
    .parameter "flag"

    .prologue
    .line 1655
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mSyntheticLinksEnabled:Z

    if-eq v0, p1, :cond_a

    .line 1656
    iput-boolean p1, p0, Landroid/webkit/WebSettingsClassic;->mSyntheticLinksEnabled:Z

    .line 1657
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_c

    .line 1659
    :cond_a
    monitor-exit p0

    return-void

    .line 1655
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setTextSize(Landroid/webkit/WebSettings$TextSize;)V
    .registers 3
    .parameter "t"

    .prologue
    .line 642
    monitor-enter p0

    :try_start_1
    iget v0, p1, Landroid/webkit/WebSettings$TextSize;->value:I

    invoke-virtual {p0, v0}, Landroid/webkit/WebSettingsClassic;->setTextZoom(I)V
    :try_end_6
    .catchall {:try_start_1 .. :try_end_6} :catchall_8

    .line 643
    monitor-exit p0

    return-void

    .line 642
    :catchall_8
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setTextZoom(I)V
    .registers 6
    .parameter "textZoom"

    .prologue
    .line 619
    monitor-enter p0

    :try_start_1
    iget v0, p0, Landroid/webkit/WebSettingsClassic;->mTextSize:I

    if-eq v0, p1, :cond_27

    .line 620
    sget-boolean v0, Landroid/webkit/WebViewClassic;->mLogEvent:Z

    if-eqz v0, :cond_22

    .line 621
    const v0, 0x11207

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget v3, p0, Landroid/webkit/WebSettingsClassic;->mTextSize:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Landroid/util/EventLog;->writeEvent(I[Ljava/lang/Object;)I

    .line 624
    :cond_22
    iput p1, p0, Landroid/webkit/WebSettingsClassic;->mTextSize:I

    .line 625
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_27
    .catchall {:try_start_1 .. :try_end_27} :catchall_29

    .line 627
    :cond_27
    monitor-exit p0

    return-void

    .line 619
    :catchall_29
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setUseDoubleTree(Z)V
    .registers 2
    .parameter "use"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 742
    monitor-enter p0

    monitor-exit p0

    return-void
.end method

.method public setUseWebViewBackgroundForOverscrollBackground(Z)V
    .registers 2
    .parameter "view"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 570
    iput-boolean p1, p0, Landroid/webkit/WebSettingsClassic;->mUseWebViewBackgroundForOverscroll:Z

    .line 571
    return-void
.end method

.method public declared-synchronized setUseWideViewPort(Z)V
    .registers 3
    .parameter "use"

    .prologue
    .line 800
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mUseWideViewport:Z

    if-eq v0, p1, :cond_a

    .line 801
    iput-boolean p1, p0, Landroid/webkit/WebSettingsClassic;->mUseWideViewport:Z

    .line 802
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_c

    .line 804
    :cond_a
    monitor-exit p0

    return-void

    .line 800
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setUserAgent(I)V
    .registers 5
    .parameter "ua"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 760
    monitor-enter p0

    const/4 v0, 0x0

    .line 761
    .local v0, uaString:Ljava/lang/String;
    const/4 v1, 0x1

    if-ne p1, v1, :cond_1a

    .line 762
    :try_start_5
    const-string v1, "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/534.24 (KHTML, like Gecko) Chrome/11.0.696.34 Safari/534.24"

    iget-object v2, p0, Landroid/webkit/WebSettingsClassic;->mUserAgent:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    :try_end_c
    .catchall {:try_start_5 .. :try_end_c} :catchall_17

    move-result v1

    if-eqz v1, :cond_11

    .line 777
    :cond_f
    :goto_f
    monitor-exit p0

    return-void

    .line 765
    :cond_11
    :try_start_11
    const-string v0, "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/534.24 (KHTML, like Gecko) Chrome/11.0.696.34 Safari/534.24"

    .line 776
    :cond_13
    :goto_13
    invoke-virtual {p0, v0}, Landroid/webkit/WebSettingsClassic;->setUserAgentString(Ljava/lang/String;)V
    :try_end_16
    .catchall {:try_start_11 .. :try_end_16} :catchall_17

    goto :goto_f

    .line 760
    :catchall_17
    move-exception v1

    monitor-exit p0

    throw v1

    .line 767
    :cond_1a
    const/4 v1, 0x2

    if-ne p1, v1, :cond_2a

    .line 768
    :try_start_1d
    const-string v1, "Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_0 like Mac OS X; en-us) AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0 Mobile/7A341 Safari/528.16"

    iget-object v2, p0, Landroid/webkit/WebSettingsClassic;->mUserAgent:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_f

    .line 771
    const-string v0, "Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_0 like Mac OS X; en-us) AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0 Mobile/7A341 Safari/528.16"
    :try_end_29
    .catchall {:try_start_1d .. :try_end_29} :catchall_17

    goto :goto_13

    .line 773
    :cond_2a
    if-eqz p1, :cond_13

    goto :goto_f
.end method

.method public declared-synchronized setUserAgentString(Ljava/lang/String;)V
    .registers 5
    .parameter "ua"

    .prologue
    .line 1474
    monitor-enter p0

    if-eqz p1, :cond_9

    :try_start_3
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    if-nez v1, :cond_3d

    .line 1475
    :cond_9
    sget-object v2, Landroid/webkit/WebSettingsClassic;->sLockForLocaleSettings:Ljava/lang/Object;

    monitor-enter v2
    :try_end_c
    .catchall {:try_start_3 .. :try_end_c} :catchall_3a

    .line 1476
    :try_start_c
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v0

    .line 1477
    .local v0, currentLocale:Ljava/util/Locale;
    sget-object v1, Landroid/webkit/WebSettingsClassic;->sLocale:Ljava/util/Locale;

    invoke-virtual {v1, v0}, Ljava/util/Locale;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_20

    .line 1478
    sput-object v0, Landroid/webkit/WebSettingsClassic;->sLocale:Ljava/util/Locale;

    .line 1479
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->getCurrentAcceptLanguage()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Landroid/webkit/WebSettingsClassic;->mAcceptLanguage:Ljava/lang/String;

    .line 1481
    :cond_20
    monitor-exit v2
    :try_end_21
    .catchall {:try_start_c .. :try_end_21} :catchall_37

    .line 1482
    :try_start_21
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->getCurrentUserAgent()Ljava/lang/String;

    move-result-object p1

    .line 1483
    const/4 v1, 0x1

    iput-boolean v1, p0, Landroid/webkit/WebSettingsClassic;->mUseDefaultUserAgent:Z

    .line 1488
    .end local v0           #currentLocale:Ljava/util/Locale;
    :goto_28
    iget-object v1, p0, Landroid/webkit/WebSettingsClassic;->mUserAgent:Ljava/lang/String;

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_35

    .line 1489
    iput-object p1, p0, Landroid/webkit/WebSettingsClassic;->mUserAgent:Ljava/lang/String;

    .line 1490
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_35
    .catchall {:try_start_21 .. :try_end_35} :catchall_3a

    .line 1492
    :cond_35
    monitor-exit p0

    return-void

    .line 1481
    :catchall_37
    move-exception v1

    :try_start_38
    monitor-exit v2
    :try_end_39
    .catchall {:try_start_38 .. :try_end_39} :catchall_37

    :try_start_39
    throw v1
    :try_end_3a
    .catchall {:try_start_39 .. :try_end_3a} :catchall_3a

    .line 1474
    :catchall_3a
    move-exception v1

    monitor-exit p0

    throw v1

    .line 1485
    :cond_3d
    const/4 v1, 0x0

    :try_start_3e
    iput-boolean v1, p0, Landroid/webkit/WebSettingsClassic;->mUseDefaultUserAgent:Z
    :try_end_40
    .catchall {:try_start_3e .. :try_end_40} :catchall_3a

    goto :goto_28
.end method

.method public declared-synchronized setWorkersEnabled(Z)V
    .registers 3
    .parameter "flag"

    .prologue
    .line 1341
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mWorkersEnabled:Z

    if-eq v0, p1, :cond_a

    .line 1342
    iput-boolean p1, p0, Landroid/webkit/WebSettingsClassic;->mWorkersEnabled:Z

    .line 1343
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_c

    .line 1345
    :cond_a
    monitor-exit p0

    return-void

    .line 1341
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setXSSAuditorEnabled(Z)V
    .registers 3
    .parameter "flag"

    .prologue
    .line 1364
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mXSSAuditorEnabled:Z

    if-eq v0, p1, :cond_a

    .line 1365
    iput-boolean p1, p0, Landroid/webkit/WebSettingsClassic;->mXSSAuditorEnabled:Z

    .line 1366
    invoke-direct {p0}, Landroid/webkit/WebSettingsClassic;->postSync()V
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_c

    .line 1368
    :cond_a
    monitor-exit p0

    return-void

    .line 1364
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized supportMultipleWindows()Z
    .registers 2

    .prologue
    .line 830
    monitor-enter p0

    :try_start_1
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mSupportMultipleWindows:Z
    :try_end_3
    .catchall {:try_start_1 .. :try_end_3} :catchall_5

    monitor-exit p0

    return v0

    :catchall_5
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public supportZoom()Z
    .registers 2

    .prologue
    .line 463
    iget-boolean v0, p0, Landroid/webkit/WebSettingsClassic;->mSupportZoom:Z

    return v0
.end method

.method declared-synchronized syncSettingsAndCreateHandler(Landroid/webkit/BrowserFrame;)V
    .registers 6
    .parameter "frame"

    .prologue
    .line 1714
    monitor-enter p0

    :try_start_1
    iput-object p1, p0, Landroid/webkit/WebSettingsClassic;->mBrowserFrame:Landroid/webkit/BrowserFrame;

    .line 1719
    iget-object v1, p0, Landroid/webkit/WebSettingsClassic;->mContext:Landroid/content/Context;

    const-string v2, "WebViewSettings"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 1721
    .local v0, sp:Landroid/content/SharedPreferences;
    sget v1, Landroid/webkit/WebSettingsClassic;->mDoubleTapToastCount:I

    if-lez v1, :cond_1a

    .line 1722
    const-string v1, "double_tap_toast_count"

    sget v2, Landroid/webkit/WebSettingsClassic;->mDoubleTapToastCount:I

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v1

    sput v1, Landroid/webkit/WebSettingsClassic;->mDoubleTapToastCount:I

    .line 1725
    :cond_1a
    iget v1, p1, Landroid/webkit/BrowserFrame;->mNativeFrame:I

    invoke-direct {p0, v1}, Landroid/webkit/WebSettingsClassic;->nativeSync(I)V

    .line 1726
    const/4 v1, 0x0

    iput-boolean v1, p0, Landroid/webkit/WebSettingsClassic;->mSyncPending:Z

    .line 1727
    iget-object v1, p0, Landroid/webkit/WebSettingsClassic;->mEventHandler:Landroid/webkit/WebSettingsClassic$EventHandler;

    #calls: Landroid/webkit/WebSettingsClassic$EventHandler;->createHandler()V
    invoke-static {v1}, Landroid/webkit/WebSettingsClassic$EventHandler;->access$900(Landroid/webkit/WebSettingsClassic$EventHandler;)V
    :try_end_27
    .catchall {:try_start_1 .. :try_end_27} :catchall_29

    .line 1728
    monitor-exit p0

    return-void

    .line 1714
    .end local v0           #sp:Landroid/content/SharedPreferences;
    :catchall_29
    move-exception v1

    monitor-exit p0

    throw v1
.end method
