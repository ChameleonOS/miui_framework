.class Landroid/webkit/AccessibilityInjector;
.super Ljava/lang/Object;
.source "AccessibilityInjector.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/webkit/AccessibilityInjector$1;,
        Landroid/webkit/AccessibilityInjector$CallbackHandler;
    }
.end annotation


# static fields
.field private static final ACCESSIBILITY_ANDROIDVOX_TEMPLATE:Ljava/lang/String; = "cvox.AndroidVox.performAction(\'%1s\')"

.field private static final ACCESSIBILITY_SCREEN_READER_JAVASCRIPT_TEMPLATE:Ljava/lang/String; = "javascript:(function() {    var chooser = document.createElement(\'script\');    chooser.type = \'text/javascript\';    chooser.src = \'%1s\';    document.getElementsByTagName(\'head\')[0].appendChild(chooser);  })();"

.field private static final ACCESSIBILITY_SCRIPT_INJECTION_OPTED_OUT:I = 0x0

.field private static final ACCESSIBILITY_SCRIPT_INJECTION_PROVIDED:I = 0x1

.field private static final ACCESSIBILITY_SCRIPT_INJECTION_UNDEFINED:I = -0x1

.field private static final ALIAS_TRAVERSAL_JS_INTERFACE:Ljava/lang/String; = "accessibilityTraversal"

.field private static final ALIAS_TTS_JS_INTERFACE:Ljava/lang/String; = "accessibility"


# instance fields
.field private mAccessibilityInjectorFallback:Landroid/webkit/AccessibilityInjectorFallback;

.field private mAccessibilityJSONObject:Lorg/json/JSONObject;

.field private mAccessibilityManager:Landroid/view/accessibility/AccessibilityManager;

.field private mAccessibilityScriptInjected:Z

.field private mCallback:Landroid/webkit/AccessibilityInjector$CallbackHandler;

.field private final mContext:Landroid/content/Context;

.field private mTextToSpeech:Landroid/speech/tts/TextToSpeech;

.field private final mWebView:Landroid/webkit/WebView;

.field private final mWebViewClassic:Landroid/webkit/WebViewClassic;


# direct methods
.method public constructor <init>(Landroid/webkit/WebViewClassic;)V
    .registers 3
    .parameter "webViewClassic"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroid/webkit/AccessibilityInjector;->mWebViewClassic:Landroid/webkit/WebViewClassic;

    invoke-virtual {p1}, Landroid/webkit/WebViewClassic;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    iput-object v0, p0, Landroid/webkit/AccessibilityInjector;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {p1}, Landroid/webkit/WebViewClassic;->getContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Landroid/webkit/AccessibilityInjector;->mContext:Landroid/content/Context;

    iget-object v0, p0, Landroid/webkit/AccessibilityInjector;->mContext:Landroid/content/Context;

    invoke-static {v0}, Landroid/view/accessibility/AccessibilityManager;->getInstance(Landroid/content/Context;)Landroid/view/accessibility/AccessibilityManager;

    move-result-object v0

    iput-object v0, p0, Landroid/webkit/AccessibilityInjector;->mAccessibilityManager:Landroid/view/accessibility/AccessibilityManager;

    return-void
.end method

.method private addCallbackApis()V
    .registers 4

    .prologue
    iget-object v0, p0, Landroid/webkit/AccessibilityInjector;->mCallback:Landroid/webkit/AccessibilityInjector$CallbackHandler;

    if-eqz v0, :cond_5

    :goto_4
    return-void

    :cond_5
    new-instance v0, Landroid/webkit/AccessibilityInjector$CallbackHandler;

    const-string v1, "accessibilityTraversal"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Landroid/webkit/AccessibilityInjector$CallbackHandler;-><init>(Ljava/lang/String;Landroid/webkit/AccessibilityInjector$1;)V

    iput-object v0, p0, Landroid/webkit/AccessibilityInjector;->mCallback:Landroid/webkit/AccessibilityInjector$CallbackHandler;

    iget-object v0, p0, Landroid/webkit/AccessibilityInjector;->mWebView:Landroid/webkit/WebView;

    iget-object v1, p0, Landroid/webkit/AccessibilityInjector;->mCallback:Landroid/webkit/AccessibilityInjector$CallbackHandler;

    const-string v2, "accessibilityTraversal"

    invoke-virtual {v0, v1, v2}, Landroid/webkit/WebView;->addJavascriptInterface(Ljava/lang/Object;Ljava/lang/String;)V

    goto :goto_4
.end method

.method private addTtsApis()V
    .registers 8

    .prologue
    const/4 v2, 0x0

    iget-object v0, p0, Landroid/webkit/AccessibilityInjector;->mTextToSpeech:Landroid/speech/tts/TextToSpeech;

    if-eqz v0, :cond_6

    :goto_5
    return-void

    :cond_6
    iget-object v0, p0, Landroid/webkit/AccessibilityInjector;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v6

    .local v6, pkgName:Ljava/lang/String;
    new-instance v0, Landroid/speech/tts/TextToSpeech;

    iget-object v1, p0, Landroid/webkit/AccessibilityInjector;->mContext:Landroid/content/Context;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ".**webview**"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x1

    move-object v3, v2

    invoke-direct/range {v0 .. v5}, Landroid/speech/tts/TextToSpeech;-><init>(Landroid/content/Context;Landroid/speech/tts/TextToSpeech$OnInitListener;Ljava/lang/String;Ljava/lang/String;Z)V

    iput-object v0, p0, Landroid/webkit/AccessibilityInjector;->mTextToSpeech:Landroid/speech/tts/TextToSpeech;

    iget-object v0, p0, Landroid/webkit/AccessibilityInjector;->mWebView:Landroid/webkit/WebView;

    iget-object v1, p0, Landroid/webkit/AccessibilityInjector;->mTextToSpeech:Landroid/speech/tts/TextToSpeech;

    const-string v2, "accessibility"

    invoke-virtual {v0, v1, v2}, Landroid/webkit/WebView;->addJavascriptInterface(Ljava/lang/Object;Ljava/lang/String;)V

    goto :goto_5
.end method

.method private getAxsUrlParameterValue(Ljava/lang/String;)I
    .registers 8
    .parameter "url"

    .prologue
    const/4 v3, -0x1

    if-nez p1, :cond_4

    :cond_3
    :goto_3
    return v3

    :cond_4
    :try_start_4
    new-instance v4, Ljava/net/URI;

    invoke-direct {v4, p1}, Ljava/net/URI;-><init>(Ljava/lang/String;)V

    const/4 v5, 0x0

    invoke-static {v4, v5}, Lorg/apache/http/client/utils/URLEncodedUtils;->parse(Ljava/net/URI;Ljava/lang/String;)Ljava/util/List;

    move-result-object v2

    .local v2, params:Ljava/util/List;,"Ljava/util/List<Lorg/apache/http/NameValuePair;>;"
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, i$:Ljava/util/Iterator;
    :cond_12
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_3

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/apache/http/NameValuePair;

    .local v1, param:Lorg/apache/http/NameValuePair;
    const-string v4, "axs"

    invoke-interface {v1}, Lorg/apache/http/NameValuePair;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_12

    invoke-interface {v1}, Lorg/apache/http/NameValuePair;->getValue()Ljava/lang/String;

    move-result-object v4

    invoke-direct {p0, v4}, Landroid/webkit/AccessibilityInjector;->verifyInjectionValue(Ljava/lang/String;)I
    :try_end_31
    .catch Ljava/net/URISyntaxException; {:try_start_4 .. :try_end_31} :catch_33

    move-result v3

    goto :goto_3

    .end local v0           #i$:Ljava/util/Iterator;
    .end local v1           #param:Lorg/apache/http/NameValuePair;
    .end local v2           #params:Ljava/util/List;,"Ljava/util/List<Lorg/apache/http/NameValuePair;>;"
    :catch_33
    move-exception v4

    goto :goto_3
.end method

.method private getScreenReaderInjectionUrl()Ljava/lang/String;
    .registers 5

    .prologue
    iget-object v1, p0, Landroid/webkit/AccessibilityInjector;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    const-string v2, "accessibility_script_injection_url"

    invoke-static {v1, v2}, Landroid/provider/Settings$Secure;->getString(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .local v0, screenReaderUrl:Ljava/lang/String;
    const-string v1, "javascript:(function() {    var chooser = document.createElement(\'script\');    chooser.type = \'text/javascript\';    chooser.src = \'%1s\';    document.getElementsByTagName(\'head\')[0].appendChild(chooser);  })();"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object v0, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method private isAccessibilityEnabled()Z
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/webkit/AccessibilityInjector;->mAccessibilityManager:Landroid/view/accessibility/AccessibilityManager;

    invoke-virtual {v0}, Landroid/view/accessibility/AccessibilityManager;->isEnabled()Z

    move-result v0

    return v0
.end method

.method private isJavaScriptEnabled()Z
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/webkit/AccessibilityInjector;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/WebSettings;->getJavaScriptEnabled()Z

    move-result v0

    return v0
.end method

.method private isScriptInjectionEnabled()Z
    .registers 6

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    iget-object v3, p0, Landroid/webkit/AccessibilityInjector;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    const-string v4, "accessibility_script_injection"

    invoke-static {v3, v4, v2}, Landroid/provider/Settings$Secure;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v0

    .local v0, injectionSetting:I
    if-ne v0, v1, :cond_11

    :goto_10
    return v1

    :cond_11
    move v1, v2

    goto :goto_10
.end method

.method private removeCallbackApis()V
    .registers 3

    .prologue
    iget-object v0, p0, Landroid/webkit/AccessibilityInjector;->mCallback:Landroid/webkit/AccessibilityInjector$CallbackHandler;

    if-nez v0, :cond_5

    :goto_4
    return-void

    :cond_5
    iget-object v0, p0, Landroid/webkit/AccessibilityInjector;->mWebView:Landroid/webkit/WebView;

    const-string v1, "accessibilityTraversal"

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->removeJavascriptInterface(Ljava/lang/String;)V

    const/4 v0, 0x0

    iput-object v0, p0, Landroid/webkit/AccessibilityInjector;->mCallback:Landroid/webkit/AccessibilityInjector$CallbackHandler;

    goto :goto_4
.end method

.method private removeTtsApis()V
    .registers 3

    .prologue
    iget-object v0, p0, Landroid/webkit/AccessibilityInjector;->mTextToSpeech:Landroid/speech/tts/TextToSpeech;

    if-nez v0, :cond_5

    :goto_4
    return-void

    :cond_5
    iget-object v0, p0, Landroid/webkit/AccessibilityInjector;->mWebView:Landroid/webkit/WebView;

    const-string v1, "accessibility"

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->removeJavascriptInterface(Ljava/lang/String;)V

    iget-object v0, p0, Landroid/webkit/AccessibilityInjector;->mTextToSpeech:Landroid/speech/tts/TextToSpeech;

    invoke-virtual {v0}, Landroid/speech/tts/TextToSpeech;->stop()I

    iget-object v0, p0, Landroid/webkit/AccessibilityInjector;->mTextToSpeech:Landroid/speech/tts/TextToSpeech;

    invoke-virtual {v0}, Landroid/speech/tts/TextToSpeech;->shutdown()V

    const/4 v0, 0x0

    iput-object v0, p0, Landroid/webkit/AccessibilityInjector;->mTextToSpeech:Landroid/speech/tts/TextToSpeech;

    goto :goto_4
.end method

.method private sendActionToAndroidVox(ILandroid/os/Bundle;)Z
    .registers 13
    .parameter "action"
    .parameter "arguments"

    .prologue
    const/4 v6, 0x0

    iget-object v7, p0, Landroid/webkit/AccessibilityInjector;->mAccessibilityJSONObject:Lorg/json/JSONObject;

    if-nez v7, :cond_34

    new-instance v7, Lorg/json/JSONObject;

    invoke-direct {v7}, Lorg/json/JSONObject;-><init>()V

    iput-object v7, p0, Landroid/webkit/AccessibilityInjector;->mAccessibilityJSONObject:Lorg/json/JSONObject;

    :cond_c
    :try_start_c
    iget-object v7, p0, Landroid/webkit/AccessibilityInjector;->mAccessibilityJSONObject:Lorg/json/JSONObject;

    const-string v8, "action"

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v7, v8, v9}, Lorg/json/JSONObject;->accumulate(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_17
    .catch Lorg/json/JSONException; {:try_start_c .. :try_end_17} :catch_5b

    sparse-switch p1, :sswitch_data_6e

    :cond_1a
    :goto_1a
    iget-object v7, p0, Landroid/webkit/AccessibilityInjector;->mAccessibilityJSONObject:Lorg/json/JSONObject;

    invoke-virtual {v7}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v4

    .local v4, jsonString:Ljava/lang/String;
    const-string v7, "cvox.AndroidVox.performAction(\'%1s\')"

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Object;

    aput-object v4, v8, v6

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .local v3, jsCode:Ljava/lang/String;
    iget-object v6, p0, Landroid/webkit/AccessibilityInjector;->mCallback:Landroid/webkit/AccessibilityInjector$CallbackHandler;

    iget-object v7, p0, Landroid/webkit/AccessibilityInjector;->mWebView:Landroid/webkit/WebView;

    #calls: Landroid/webkit/AccessibilityInjector$CallbackHandler;->performAction(Landroid/webkit/WebView;Ljava/lang/String;)Z
    invoke-static {v6, v7, v3}, Landroid/webkit/AccessibilityInjector$CallbackHandler;->access$100(Landroid/webkit/AccessibilityInjector$CallbackHandler;Landroid/webkit/WebView;Ljava/lang/String;)Z

    move-result v6

    .end local v3           #jsCode:Ljava/lang/String;
    .end local v4           #jsonString:Ljava/lang/String;
    :goto_33
    return v6

    :cond_34
    iget-object v7, p0, Landroid/webkit/AccessibilityInjector;->mAccessibilityJSONObject:Lorg/json/JSONObject;

    invoke-virtual {v7}, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;

    move-result-object v5

    .local v5, keys:Ljava/util/Iterator;,"Ljava/util/Iterator<*>;"
    :goto_3a
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_c

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    invoke-interface {v5}, Ljava/util/Iterator;->remove()V

    goto :goto_3a

    .end local v5           #keys:Ljava/util/Iterator;,"Ljava/util/Iterator<*>;"
    :sswitch_47
    if-eqz p2, :cond_1a

    :try_start_49
    const-string v7, "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT"

    invoke-virtual {p2, v7}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v2

    .local v2, granularity:I
    iget-object v7, p0, Landroid/webkit/AccessibilityInjector;->mAccessibilityJSONObject:Lorg/json/JSONObject;

    const-string v8, "granularity"

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v7, v8, v9}, Lorg/json/JSONObject;->accumulate(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_1a

    .end local v2           #granularity:I
    :catch_5b
    move-exception v0

    .local v0, e:Lorg/json/JSONException;
    goto :goto_33

    .end local v0           #e:Lorg/json/JSONException;
    :sswitch_5d
    if-eqz p2, :cond_1a

    const-string v7, "ACTION_ARGUMENT_HTML_ELEMENT_STRING"

    invoke-virtual {p2, v7}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .local v1, element:Ljava/lang/String;
    iget-object v7, p0, Landroid/webkit/AccessibilityInjector;->mAccessibilityJSONObject:Lorg/json/JSONObject;

    const-string v8, "element"

    invoke-virtual {v7, v8, v1}, Lorg/json/JSONObject;->accumulate(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_6c
    .catch Lorg/json/JSONException; {:try_start_49 .. :try_end_6c} :catch_5b

    goto :goto_1a

    nop

    :sswitch_data_6e
    .sparse-switch
        0x100 -> :sswitch_47
        0x200 -> :sswitch_47
        0x400 -> :sswitch_5d
        0x800 -> :sswitch_5d
    .end sparse-switch
.end method

.method private shouldInjectJavaScript(Ljava/lang/String;)Z
    .registers 4
    .parameter "url"

    .prologue
    const/4 v0, 0x0

    invoke-direct {p0}, Landroid/webkit/AccessibilityInjector;->isJavaScriptEnabled()Z

    move-result v1

    if-nez v1, :cond_8

    :cond_7
    :goto_7
    return v0

    :cond_8
    invoke-direct {p0, p1}, Landroid/webkit/AccessibilityInjector;->getAxsUrlParameterValue(Ljava/lang/String;)I

    move-result v1

    if-eqz v1, :cond_7

    invoke-direct {p0}, Landroid/webkit/AccessibilityInjector;->isScriptInjectionEnabled()Z

    move-result v1

    if-eqz v1, :cond_7

    const/4 v0, 0x1

    goto :goto_7
.end method

.method private toggleFallbackAccessibilityInjector(Z)V
    .registers 4
    .parameter "enabled"

    .prologue
    if-eqz p1, :cond_10

    iget-object v0, p0, Landroid/webkit/AccessibilityInjector;->mAccessibilityInjectorFallback:Landroid/webkit/AccessibilityInjectorFallback;

    if-nez v0, :cond_10

    new-instance v0, Landroid/webkit/AccessibilityInjectorFallback;

    iget-object v1, p0, Landroid/webkit/AccessibilityInjector;->mWebViewClassic:Landroid/webkit/WebViewClassic;

    invoke-direct {v0, v1}, Landroid/webkit/AccessibilityInjectorFallback;-><init>(Landroid/webkit/WebViewClassic;)V

    iput-object v0, p0, Landroid/webkit/AccessibilityInjector;->mAccessibilityInjectorFallback:Landroid/webkit/AccessibilityInjectorFallback;

    :goto_f
    return-void

    :cond_10
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/webkit/AccessibilityInjector;->mAccessibilityInjectorFallback:Landroid/webkit/AccessibilityInjectorFallback;

    goto :goto_f
.end method

.method private verifyInjectionValue(Ljava/lang/String;)I
    .registers 4
    .parameter "value"

    .prologue
    :try_start_0
    invoke-static {p1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_3
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_3} :catch_d

    move-result v0

    .local v0, parsed:I
    packed-switch v0, :pswitch_data_10

    .end local v0           #parsed:I
    :goto_7
    const/4 v1, -0x1

    :goto_8
    return v1

    .restart local v0       #parsed:I
    :pswitch_9
    const/4 v1, 0x0

    goto :goto_8

    :pswitch_b
    const/4 v1, 0x1

    goto :goto_8

    .end local v0           #parsed:I
    :catch_d
    move-exception v1

    goto :goto_7

    nop

    :pswitch_data_10
    .packed-switch 0x0
        :pswitch_9
        :pswitch_b
    .end packed-switch
.end method


# virtual methods
.method public addAccessibilityApisIfNecessary()V
    .registers 2

    .prologue
    invoke-direct {p0}, Landroid/webkit/AccessibilityInjector;->isAccessibilityEnabled()Z

    move-result v0

    if-eqz v0, :cond_c

    invoke-direct {p0}, Landroid/webkit/AccessibilityInjector;->isJavaScriptEnabled()Z

    move-result v0

    if-nez v0, :cond_d

    :cond_c
    :goto_c
    return-void

    :cond_d
    invoke-direct {p0}, Landroid/webkit/AccessibilityInjector;->addTtsApis()V

    invoke-direct {p0}, Landroid/webkit/AccessibilityInjector;->addCallbackApis()V

    goto :goto_c
.end method

.method public handleKeyEventIfNecessary(Landroid/view/KeyEvent;)Z
    .registers 6
    .parameter "event"

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    invoke-direct {p0}, Landroid/webkit/AccessibilityInjector;->isAccessibilityEnabled()Z

    move-result v2

    if-nez v2, :cond_e

    iput-boolean v0, p0, Landroid/webkit/AccessibilityInjector;->mAccessibilityScriptInjected:Z

    invoke-direct {p0, v0}, Landroid/webkit/AccessibilityInjector;->toggleFallbackAccessibilityInjector(Z)V

    :cond_d
    :goto_d
    return v0

    :cond_e
    iget-boolean v2, p0, Landroid/webkit/AccessibilityInjector;->mAccessibilityScriptInjected:Z

    if-eqz v2, :cond_2f

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getAction()I

    move-result v2

    if-ne v2, v1, :cond_21

    iget-object v2, p0, Landroid/webkit/AccessibilityInjector;->mWebViewClassic:Landroid/webkit/WebViewClassic;

    const/16 v3, 0x68

    invoke-virtual {v2, v3, v0, v0, p1}, Landroid/webkit/WebViewClassic;->sendBatchableInputMessage(IIILjava/lang/Object;)V

    :goto_1f
    move v0, v1

    goto :goto_d

    :cond_21
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getAction()I

    move-result v2

    if-nez v2, :cond_d

    iget-object v2, p0, Landroid/webkit/AccessibilityInjector;->mWebViewClassic:Landroid/webkit/WebViewClassic;

    const/16 v3, 0x67

    invoke-virtual {v2, v3, v0, v0, p1}, Landroid/webkit/WebViewClassic;->sendBatchableInputMessage(IIILjava/lang/Object;)V

    goto :goto_1f

    :cond_2f
    iget-object v1, p0, Landroid/webkit/AccessibilityInjector;->mAccessibilityInjectorFallback:Landroid/webkit/AccessibilityInjectorFallback;

    if-eqz v1, :cond_d

    iget-object v0, p0, Landroid/webkit/AccessibilityInjector;->mAccessibilityInjectorFallback:Landroid/webkit/AccessibilityInjectorFallback;

    invoke-virtual {v0, p1}, Landroid/webkit/AccessibilityInjectorFallback;->onKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v0

    goto :goto_d
.end method

.method public handleSelectionChangedIfNecessary(Ljava/lang/String;)V
    .registers 3
    .parameter "selectionString"

    .prologue
    iget-object v0, p0, Landroid/webkit/AccessibilityInjector;->mAccessibilityInjectorFallback:Landroid/webkit/AccessibilityInjectorFallback;

    if-eqz v0, :cond_9

    iget-object v0, p0, Landroid/webkit/AccessibilityInjector;->mAccessibilityInjectorFallback:Landroid/webkit/AccessibilityInjectorFallback;

    invoke-virtual {v0, p1}, Landroid/webkit/AccessibilityInjectorFallback;->onSelectionStringChange(Ljava/lang/String;)V

    :cond_9
    return-void
.end method

.method public onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V
    .registers 3
    .parameter "info"

    .prologue
    const/16 v0, 0x1f

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityNodeInfo;->setMovementGranularities(I)V

    const/16 v0, 0x100

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityNodeInfo;->addAction(I)V

    const/16 v0, 0x200

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityNodeInfo;->addAction(I)V

    const/16 v0, 0x400

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityNodeInfo;->addAction(I)V

    const/16 v0, 0x800

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityNodeInfo;->addAction(I)V

    const/16 v0, 0x10

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityNodeInfo;->addAction(I)V

    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityNodeInfo;->setClickable(Z)V

    return-void
.end method

.method public onPageFinished(Ljava/lang/String;)V
    .registers 6
    .parameter "url"

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    invoke-direct {p0}, Landroid/webkit/AccessibilityInjector;->isAccessibilityEnabled()Z

    move-result v1

    if-nez v1, :cond_e

    iput-boolean v2, p0, Landroid/webkit/AccessibilityInjector;->mAccessibilityScriptInjected:Z

    invoke-direct {p0, v2}, Landroid/webkit/AccessibilityInjector;->toggleFallbackAccessibilityInjector(Z)V

    :goto_d
    return-void

    :cond_e
    invoke-direct {p0, p1}, Landroid/webkit/AccessibilityInjector;->shouldInjectJavaScript(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_18

    invoke-direct {p0, v3}, Landroid/webkit/AccessibilityInjector;->toggleFallbackAccessibilityInjector(Z)V

    goto :goto_d

    :cond_18
    invoke-direct {p0, v2}, Landroid/webkit/AccessibilityInjector;->toggleFallbackAccessibilityInjector(Z)V

    invoke-direct {p0}, Landroid/webkit/AccessibilityInjector;->getScreenReaderInjectionUrl()Ljava/lang/String;

    move-result-object v0

    .local v0, injectionUrl:Ljava/lang/String;
    iget-object v1, p0, Landroid/webkit/AccessibilityInjector;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v1, v0}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    iput-boolean v3, p0, Landroid/webkit/AccessibilityInjector;->mAccessibilityScriptInjected:Z

    goto :goto_d
.end method

.method public onPageStarted(Ljava/lang/String;)V
    .registers 3
    .parameter "url"

    .prologue
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/webkit/AccessibilityInjector;->mAccessibilityScriptInjected:Z

    return-void
.end method

.method public performAccessibilityAction(ILandroid/os/Bundle;)Z
    .registers 5
    .parameter "action"
    .parameter "arguments"

    .prologue
    const/4 v0, 0x0

    invoke-direct {p0}, Landroid/webkit/AccessibilityInjector;->isAccessibilityEnabled()Z

    move-result v1

    if-nez v1, :cond_d

    iput-boolean v0, p0, Landroid/webkit/AccessibilityInjector;->mAccessibilityScriptInjected:Z

    invoke-direct {p0, v0}, Landroid/webkit/AccessibilityInjector;->toggleFallbackAccessibilityInjector(Z)V

    :cond_c
    :goto_c
    return v0

    :cond_d
    iget-boolean v1, p0, Landroid/webkit/AccessibilityInjector;->mAccessibilityScriptInjected:Z

    if-eqz v1, :cond_16

    invoke-direct {p0, p1, p2}, Landroid/webkit/AccessibilityInjector;->sendActionToAndroidVox(ILandroid/os/Bundle;)Z

    move-result v0

    goto :goto_c

    :cond_16
    iget-object v1, p0, Landroid/webkit/AccessibilityInjector;->mAccessibilityInjectorFallback:Landroid/webkit/AccessibilityInjectorFallback;

    if-eqz v1, :cond_c

    iget-object v0, p0, Landroid/webkit/AccessibilityInjector;->mAccessibilityInjectorFallback:Landroid/webkit/AccessibilityInjectorFallback;

    invoke-virtual {v0, p1, p2}, Landroid/webkit/AccessibilityInjectorFallback;->performAccessibilityAction(ILandroid/os/Bundle;)Z

    move-result v0

    goto :goto_c
.end method

.method public removeAccessibilityApisIfNecessary()V
    .registers 1

    .prologue
    invoke-direct {p0}, Landroid/webkit/AccessibilityInjector;->removeTtsApis()V

    invoke-direct {p0}, Landroid/webkit/AccessibilityInjector;->removeCallbackApis()V

    return-void
.end method

.method public supportsAccessibilityAction(I)Z
    .registers 3
    .parameter "action"

    .prologue
    sparse-switch p1, :sswitch_data_8

    const/4 v0, 0x0

    :goto_4
    return v0

    :sswitch_5
    const/4 v0, 0x1

    goto :goto_4

    nop

    :sswitch_data_8
    .sparse-switch
        0x10 -> :sswitch_5
        0x100 -> :sswitch_5
        0x200 -> :sswitch_5
        0x400 -> :sswitch_5
        0x800 -> :sswitch_5
    .end sparse-switch
.end method
