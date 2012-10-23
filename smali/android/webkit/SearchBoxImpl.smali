.class final Landroid/webkit/SearchBoxImpl;
.super Ljava/lang/Object;
.source "SearchBoxImpl.java"

# interfaces
.implements Landroid/webkit/SearchBox;


# static fields
.field private static final DISPATCH_EVENT_SCRIPT:Ljava/lang/String; = "if (window.chrome && window.chrome.searchBox && window.chrome.searchBox.on%1$s) {  window.chrome.searchBox.on%1$s();  window.searchBoxJavaBridge_.dispatchCompleteCallback(\'%1$s\', %2$d, true);} else {  window.searchBoxJavaBridge_.dispatchCompleteCallback(\'%1$s\', %2$d, false);}"

.field private static final EVENT_CANCEL:Ljava/lang/String; = "cancel"

.field private static final EVENT_CHANGE:Ljava/lang/String; = "change"

.field private static final EVENT_RESIZE:Ljava/lang/String; = "resize"

.field private static final EVENT_SUBMIT:Ljava/lang/String; = "submit"

.field private static final IS_SUPPORTED_SCRIPT:Ljava/lang/String; = "if (window.searchBoxJavaBridge_) {  if (window.chrome && window.chrome.sv) {    window.searchBoxJavaBridge_.isSupportedCallback(true);  } else {    window.searchBoxJavaBridge_.isSupportedCallback(false);  }}"

.field static final JS_BRIDGE:Ljava/lang/String; = "(function(){if (!window.chrome) {  window.chrome = {};}if (!window.chrome.searchBox) {  var sb = window.chrome.searchBox = {};  sb.setSuggestions = function(suggestions) {    if (window.searchBoxJavaBridge_) {      window.searchBoxJavaBridge_.setSuggestions(JSON.stringify(suggestions));    }  };  sb.setValue = function(valueArray) { sb.value = valueArray[0]; };  sb.value = \'\';  sb.x = 0;  sb.y = 0;  sb.width = 0;  sb.height = 0;  sb.selectionStart = 0;  sb.selectionEnd = 0;  sb.verbatim = false;}})();"

.field static final JS_INTERFACE_NAME:Ljava/lang/String; = "searchBoxJavaBridge_"

.field private static final SET_DIMENSIONS_SCRIPT:Ljava/lang/String; = "if (window.chrome && window.chrome.searchBox) {   var f = window.chrome.searchBox;  f.x = %d;  f.y = %d;  f.width = %d;  f.height = %d;}"

.field private static final SET_QUERY_SCRIPT:Ljava/lang/String; = "if (window.chrome && window.chrome.searchBox) {  window.chrome.searchBox.setValue(%s);}"

.field private static final SET_SELECTION_SCRIPT:Ljava/lang/String; = "if (window.chrome && window.chrome.searchBox) {  var f = window.chrome.searchBox;  f.selectionStart = %d  f.selectionEnd = %d}"

.field private static final SET_VERBATIM_SCRIPT:Ljava/lang/String; = "if (window.chrome && window.chrome.searchBox) {  window.chrome.searchBox.verbatim = %1$s;}"

.field private static final TAG:Ljava/lang/String; = "WebKit.SearchBoxImpl"


# instance fields
.field private final mCallbackProxy:Landroid/webkit/CallbackProxy;

.field private final mEventCallbacks:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Integer;",
            "Landroid/webkit/SearchBox$SearchBoxListener;",
            ">;"
        }
    .end annotation
.end field

.field private final mListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Landroid/webkit/SearchBox$SearchBoxListener;",
            ">;"
        }
    .end annotation
.end field

.field private mNextEventId:I

.field private mSupportedCallback:Landroid/webkit/SearchBox$IsSupportedCallback;

.field private final mWebViewCore:Landroid/webkit/WebViewCore;


# direct methods
.method constructor <init>(Landroid/webkit/WebViewCore;Landroid/webkit/CallbackProxy;)V
    .registers 4
    .parameter "webViewCore"
    .parameter "callbackProxy"

    .prologue
    .line 121
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 118
    const/4 v0, 0x1

    iput v0, p0, Landroid/webkit/SearchBoxImpl;->mNextEventId:I

    .line 122
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/webkit/SearchBoxImpl;->mListeners:Ljava/util/List;

    .line 123
    iput-object p1, p0, Landroid/webkit/SearchBoxImpl;->mWebViewCore:Landroid/webkit/WebViewCore;

    .line 124
    iput-object p2, p0, Landroid/webkit/SearchBoxImpl;->mCallbackProxy:Landroid/webkit/CallbackProxy;

    .line 125
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroid/webkit/SearchBoxImpl;->mEventCallbacks:Ljava/util/HashMap;

    .line 126
    return-void
.end method

.method private dispatchEvent(Ljava/lang/String;Landroid/webkit/SearchBox$SearchBoxListener;)V
    .registers 9
    .parameter "eventName"
    .parameter "callback"

    .prologue
    .line 178
    if-eqz p2, :cond_2d

    .line 179
    monitor-enter p0

    .line 180
    :try_start_3
    iget v0, p0, Landroid/webkit/SearchBoxImpl;->mNextEventId:I

    add-int/lit8 v2, v0, 0x1

    iput v2, p0, Landroid/webkit/SearchBoxImpl;->mNextEventId:I

    .line 181
    .local v0, eventId:I
    iget-object v2, p0, Landroid/webkit/SearchBoxImpl;->mEventCallbacks:Ljava/util/HashMap;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v2, v3, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 182
    monitor-exit p0
    :try_end_13
    .catchall {:try_start_3 .. :try_end_13} :catchall_2a

    .line 186
    :goto_13
    const-string v2, "if (window.chrome && window.chrome.searchBox && window.chrome.searchBox.on%1$s) {  window.chrome.searchBox.on%1$s();  window.searchBoxJavaBridge_.dispatchCompleteCallback(\'%1$s\', %2$d, true);} else {  window.searchBoxJavaBridge_.dispatchCompleteCallback(\'%1$s\', %2$d, false);}"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p1, v3, v4

    const/4 v4, 0x1

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 187
    .local v1, js:Ljava/lang/String;
    invoke-direct {p0, v1}, Landroid/webkit/SearchBoxImpl;->dispatchJs(Ljava/lang/String;)V

    .line 188
    return-void

    .line 182
    .end local v0           #eventId:I
    .end local v1           #js:Ljava/lang/String;
    :catchall_2a
    move-exception v2

    :try_start_2b
    monitor-exit p0
    :try_end_2c
    .catchall {:try_start_2b .. :try_end_2c} :catchall_2a

    throw v2

    .line 184
    :cond_2d
    const/4 v0, 0x0

    .restart local v0       #eventId:I
    goto :goto_13
.end method

.method private dispatchJs(Ljava/lang/String;)V
    .registers 4
    .parameter "js"

    .prologue
    .line 191
    iget-object v0, p0, Landroid/webkit/SearchBoxImpl;->mWebViewCore:Landroid/webkit/WebViewCore;

    const/16 v1, 0xc2

    invoke-virtual {v0, v1, p1}, Landroid/webkit/WebViewCore;->sendMessage(ILjava/lang/Object;)V

    .line 192
    return-void
.end method

.method private static jsonSerialize(Ljava/lang/String;)Ljava/lang/String;
    .registers 6
    .parameter "query"

    .prologue
    .line 256
    new-instance v1, Lorg/json/JSONStringer;

    invoke-direct {v1}, Lorg/json/JSONStringer;-><init>()V

    .line 258
    .local v1, stringer:Lorg/json/JSONStringer;
    :try_start_5
    invoke-virtual {v1}, Lorg/json/JSONStringer;->array()Lorg/json/JSONStringer;

    move-result-object v2

    invoke-virtual {v2, p0}, Lorg/json/JSONStringer;->value(Ljava/lang/Object;)Lorg/json/JSONStringer;

    move-result-object v2

    invoke-virtual {v2}, Lorg/json/JSONStringer;->endArray()Lorg/json/JSONStringer;
    :try_end_10
    .catch Lorg/json/JSONException; {:try_start_5 .. :try_end_10} :catch_15

    .line 263
    invoke-virtual {v1}, Lorg/json/JSONStringer;->toString()Ljava/lang/String;

    move-result-object v2

    :goto_14
    return-object v2

    .line 259
    :catch_15
    move-exception v0

    .line 260
    .local v0, e:Lorg/json/JSONException;
    const-string v2, "WebKit.SearchBoxImpl"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Error serializing query : "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 261
    const/4 v2, 0x0

    goto :goto_14
.end method


# virtual methods
.method public addSearchBoxListener(Landroid/webkit/SearchBox$SearchBoxListener;)V
    .registers 4
    .parameter "l"

    .prologue
    .line 196
    iget-object v1, p0, Landroid/webkit/SearchBoxImpl;->mListeners:Ljava/util/List;

    monitor-enter v1

    .line 197
    :try_start_3
    iget-object v0, p0, Landroid/webkit/SearchBoxImpl;->mListeners:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 198
    monitor-exit v1

    .line 199
    return-void

    .line 198
    :catchall_a
    move-exception v0

    monitor-exit v1
    :try_end_c
    .catchall {:try_start_3 .. :try_end_c} :catchall_a

    throw v0
.end method

.method public dispatchCompleteCallback(Ljava/lang/String;IZ)V
    .registers 5
    .parameter "function"
    .parameter "id"
    .parameter "successful"

    .prologue
    .line 229
    iget-object v0, p0, Landroid/webkit/SearchBoxImpl;->mCallbackProxy:Landroid/webkit/CallbackProxy;

    invoke-virtual {v0, p1, p2, p3}, Landroid/webkit/CallbackProxy;->onSearchboxDispatchCompleteCallback(Ljava/lang/String;IZ)V

    .line 230
    return-void
.end method

.method public handleDispatchCompleteCallback(Ljava/lang/String;IZ)V
    .registers 7
    .parameter "function"
    .parameter "id"
    .parameter "successful"

    .prologue
    .line 233
    if-eqz p2, :cond_26

    .line 235
    monitor-enter p0

    .line 236
    :try_start_3
    iget-object v1, p0, Landroid/webkit/SearchBoxImpl;->mEventCallbacks:Ljava/util/HashMap;

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/webkit/SearchBox$SearchBoxListener;

    .line 237
    .local v0, listener:Landroid/webkit/SearchBox$SearchBoxListener;
    iget-object v1, p0, Landroid/webkit/SearchBoxImpl;->mEventCallbacks:Ljava/util/HashMap;

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 238
    monitor-exit p0
    :try_end_19
    .catchall {:try_start_3 .. :try_end_19} :catchall_27

    .line 239
    if-eqz v0, :cond_26

    .line 240
    const-string v1, "change"

    invoke-static {v1, p1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_2a

    .line 241
    invoke-virtual {v0, p3}, Landroid/webkit/SearchBox$SearchBoxListener;->onChangeComplete(Z)V

    .line 251
    .end local v0           #listener:Landroid/webkit/SearchBox$SearchBoxListener;
    :cond_26
    :goto_26
    return-void

    .line 238
    :catchall_27
    move-exception v1

    :try_start_28
    monitor-exit p0
    :try_end_29
    .catchall {:try_start_28 .. :try_end_29} :catchall_27

    throw v1

    .line 242
    .restart local v0       #listener:Landroid/webkit/SearchBox$SearchBoxListener;
    :cond_2a
    const-string/jumbo v1, "submit"

    invoke-static {v1, p1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_37

    .line 243
    invoke-virtual {v0, p3}, Landroid/webkit/SearchBox$SearchBoxListener;->onSubmitComplete(Z)V

    goto :goto_26

    .line 244
    :cond_37
    const-string/jumbo v1, "resize"

    invoke-static {v1, p1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_44

    .line 245
    invoke-virtual {v0, p3}, Landroid/webkit/SearchBox$SearchBoxListener;->onResizeComplete(Z)V

    goto :goto_26

    .line 246
    :cond_44
    const-string v1, "cancel"

    invoke-static {v1, p1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_26

    .line 247
    invoke-virtual {v0, p3}, Landroid/webkit/SearchBox$SearchBoxListener;->onCancelComplete(Z)V

    goto :goto_26
.end method

.method public handleIsSupportedCallback(Z)V
    .registers 4
    .parameter "isSupported"

    .prologue
    .line 220
    iget-object v0, p0, Landroid/webkit/SearchBoxImpl;->mSupportedCallback:Landroid/webkit/SearchBox$IsSupportedCallback;

    .line 221
    .local v0, callback:Landroid/webkit/SearchBox$IsSupportedCallback;
    const/4 v1, 0x0

    iput-object v1, p0, Landroid/webkit/SearchBoxImpl;->mSupportedCallback:Landroid/webkit/SearchBox$IsSupportedCallback;

    .line 222
    if-eqz v0, :cond_a

    .line 223
    invoke-interface {v0, p1}, Landroid/webkit/SearchBox$IsSupportedCallback;->searchBoxIsSupported(Z)V

    .line 225
    :cond_a
    return-void
.end method

.method handleSuggestions(Ljava/lang/String;Ljava/util/List;)V
    .registers 6
    .parameter "query"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 298
    .local p2, suggestions:Ljava/util/List;,"Ljava/util/List<Ljava/lang/String;>;"
    iget-object v2, p0, Landroid/webkit/SearchBoxImpl;->mListeners:Ljava/util/List;

    monitor-enter v2

    .line 299
    :try_start_3
    iget-object v1, p0, Landroid/webkit/SearchBoxImpl;->mListeners:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    add-int/lit8 v0, v1, -0x1

    .local v0, i:I
    :goto_b
    if-ltz v0, :cond_1b

    .line 300
    iget-object v1, p0, Landroid/webkit/SearchBoxImpl;->mListeners:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/webkit/SearchBox$SearchBoxListener;

    invoke-virtual {v1, p1, p2}, Landroid/webkit/SearchBox$SearchBoxListener;->onSuggestionsReceived(Ljava/lang/String;Ljava/util/List;)V

    .line 299
    add-int/lit8 v0, v0, -0x1

    goto :goto_b

    .line 302
    :cond_1b
    monitor-exit v2

    .line 303
    return-void

    .line 302
    .end local v0           #i:I
    :catchall_1d
    move-exception v1

    monitor-exit v2
    :try_end_1f
    .catchall {:try_start_3 .. :try_end_1f} :catchall_1d

    throw v1
.end method

.method public isSupported(Landroid/webkit/SearchBox$IsSupportedCallback;)V
    .registers 3
    .parameter "callback"

    .prologue
    .line 210
    iput-object p1, p0, Landroid/webkit/SearchBoxImpl;->mSupportedCallback:Landroid/webkit/SearchBox$IsSupportedCallback;

    .line 211
    const-string v0, "if (window.searchBoxJavaBridge_) {  if (window.chrome && window.chrome.sv) {    window.searchBoxJavaBridge_.isSupportedCallback(true);  } else {    window.searchBoxJavaBridge_.isSupportedCallback(false);  }}"

    invoke-direct {p0, v0}, Landroid/webkit/SearchBoxImpl;->dispatchJs(Ljava/lang/String;)V

    .line 212
    return-void
.end method

.method public isSupportedCallback(Z)V
    .registers 3
    .parameter "isSupported"

    .prologue
    .line 216
    iget-object v0, p0, Landroid/webkit/SearchBoxImpl;->mCallbackProxy:Landroid/webkit/CallbackProxy;

    invoke-virtual {v0, p1}, Landroid/webkit/CallbackProxy;->onIsSupportedCallback(Z)V

    .line 217
    return-void
.end method

.method public oncancel(Landroid/webkit/SearchBox$SearchBoxListener;)V
    .registers 3
    .parameter "callback"

    .prologue
    .line 173
    const-string v0, "cancel"

    invoke-direct {p0, v0, p1}, Landroid/webkit/SearchBoxImpl;->dispatchEvent(Ljava/lang/String;Landroid/webkit/SearchBox$SearchBoxListener;)V

    .line 174
    return-void
.end method

.method public onchange(Landroid/webkit/SearchBox$SearchBoxListener;)V
    .registers 3
    .parameter "callback"

    .prologue
    .line 158
    const-string v0, "change"

    invoke-direct {p0, v0, p1}, Landroid/webkit/SearchBoxImpl;->dispatchEvent(Ljava/lang/String;Landroid/webkit/SearchBox$SearchBoxListener;)V

    .line 159
    return-void
.end method

.method public onresize(Landroid/webkit/SearchBox$SearchBoxListener;)V
    .registers 3
    .parameter "callback"

    .prologue
    .line 168
    const-string/jumbo v0, "resize"

    invoke-direct {p0, v0, p1}, Landroid/webkit/SearchBoxImpl;->dispatchEvent(Ljava/lang/String;Landroid/webkit/SearchBox$SearchBoxListener;)V

    .line 169
    return-void
.end method

.method public onsubmit(Landroid/webkit/SearchBox$SearchBoxListener;)V
    .registers 3
    .parameter "callback"

    .prologue
    .line 163
    const-string/jumbo v0, "submit"

    invoke-direct {p0, v0, p1}, Landroid/webkit/SearchBoxImpl;->dispatchEvent(Ljava/lang/String;Landroid/webkit/SearchBox$SearchBoxListener;)V

    .line 164
    return-void
.end method

.method public removeSearchBoxListener(Landroid/webkit/SearchBox$SearchBoxListener;)V
    .registers 4
    .parameter "l"

    .prologue
    .line 203
    iget-object v1, p0, Landroid/webkit/SearchBoxImpl;->mListeners:Ljava/util/List;

    monitor-enter v1

    .line 204
    :try_start_3
    iget-object v0, p0, Landroid/webkit/SearchBoxImpl;->mListeners:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 205
    monitor-exit v1

    .line 206
    return-void

    .line 205
    :catchall_a
    move-exception v0

    monitor-exit v1
    :try_end_c
    .catchall {:try_start_3 .. :try_end_c} :catchall_a

    throw v0
.end method

.method public setDimensions(IIII)V
    .registers 10
    .parameter "x"
    .parameter "y"
    .parameter "width"
    .parameter "height"

    .prologue
    .line 152
    const-string v1, "if (window.chrome && window.chrome.searchBox) {   var f = window.chrome.searchBox;  f.x = %d;  f.y = %d;  f.width = %d;  f.height = %d;}"

    const/4 v2, 0x4

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x2

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x3

    invoke-static {p4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 153
    .local v0, js:Ljava/lang/String;
    invoke-direct {p0, v0}, Landroid/webkit/SearchBoxImpl;->dispatchJs(Ljava/lang/String;)V

    .line 154
    return-void
.end method

.method public setQuery(Ljava/lang/String;)V
    .registers 7
    .parameter "query"

    .prologue
    .line 130
    invoke-static {p1}, Landroid/webkit/SearchBoxImpl;->jsonSerialize(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 131
    .local v0, formattedQuery:Ljava/lang/String;
    if-eqz v0, :cond_15

    .line 132
    const-string v2, "if (window.chrome && window.chrome.searchBox) {  window.chrome.searchBox.setValue(%s);}"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 133
    .local v1, js:Ljava/lang/String;
    invoke-direct {p0, v1}, Landroid/webkit/SearchBoxImpl;->dispatchJs(Ljava/lang/String;)V

    .line 135
    .end local v1           #js:Ljava/lang/String;
    :cond_15
    return-void
.end method

.method public setSelection(II)V
    .registers 8
    .parameter "selectionStart"
    .parameter "selectionEnd"

    .prologue
    .line 146
    const-string v1, "if (window.chrome && window.chrome.searchBox) {  var f = window.chrome.searchBox;  f.selectionStart = %d  f.selectionEnd = %d}"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 147
    .local v0, js:Ljava/lang/String;
    invoke-direct {p0, v0}, Landroid/webkit/SearchBoxImpl;->dispatchJs(Ljava/lang/String;)V

    .line 148
    return-void
.end method

.method public setSuggestions(Ljava/lang/String;)V
    .registers 13
    .parameter "jsonArguments"

    .prologue
    .line 268
    if-nez p1, :cond_3

    .line 295
    :goto_2
    return-void

    .line 272
    :cond_3
    const/4 v2, 0x0

    .line 273
    .local v2, query:Ljava/lang/String;
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 275
    .local v4, suggestions:Ljava/util/List;,"Ljava/util/List<Ljava/lang/String;>;"
    :try_start_9
    new-instance v6, Lorg/json/JSONObject;

    invoke-direct {v6, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 276
    .local v6, suggestionsJson:Lorg/json/JSONObject;
    const-string/jumbo v8, "query"

    invoke-virtual {v6, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 278
    const-string/jumbo v8, "suggestions"

    invoke-virtual {v6, v8}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v5

    .line 279
    .local v5, suggestionsArray:Lorg/json/JSONArray;
    const/4 v0, 0x0

    .local v0, i:I
    :goto_1d
    invoke-virtual {v5}, Lorg/json/JSONArray;->length()I

    move-result v8

    if-ge v0, v8, :cond_5a

    .line 280
    invoke-virtual {v5, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    .line 281
    .local v3, suggestion:Lorg/json/JSONObject;
    const-string/jumbo v8, "value"

    invoke-virtual {v3, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 282
    .local v7, value:Ljava/lang/String;
    if-eqz v7, :cond_33

    .line 283
    invoke-interface {v4, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_33
    .catch Lorg/json/JSONException; {:try_start_9 .. :try_end_33} :catch_36

    .line 279
    :cond_33
    add-int/lit8 v0, v0, 0x1

    goto :goto_1d

    .line 289
    .end local v0           #i:I
    .end local v3           #suggestion:Lorg/json/JSONObject;
    .end local v5           #suggestionsArray:Lorg/json/JSONArray;
    .end local v6           #suggestionsJson:Lorg/json/JSONObject;
    .end local v7           #value:Ljava/lang/String;
    :catch_36
    move-exception v1

    .line 290
    .local v1, je:Lorg/json/JSONException;
    const-string v8, "WebKit.SearchBoxImpl"

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "Error parsing json ["

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, "], exception = "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_2

    .line 294
    .end local v1           #je:Lorg/json/JSONException;
    .restart local v0       #i:I
    .restart local v5       #suggestionsArray:Lorg/json/JSONArray;
    .restart local v6       #suggestionsJson:Lorg/json/JSONObject;
    :cond_5a
    iget-object v8, p0, Landroid/webkit/SearchBoxImpl;->mCallbackProxy:Landroid/webkit/CallbackProxy;

    invoke-virtual {v8, v2, v4}, Landroid/webkit/CallbackProxy;->onSearchboxSuggestionsReceived(Ljava/lang/String;Ljava/util/List;)V

    goto :goto_2
.end method

.method public setVerbatim(Z)V
    .registers 7
    .parameter "verbatim"

    .prologue
    .line 139
    const-string v1, "if (window.chrome && window.chrome.searchBox) {  window.chrome.searchBox.verbatim = %1$s;}"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-static {p1}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 140
    .local v0, js:Ljava/lang/String;
    invoke-direct {p0, v0}, Landroid/webkit/SearchBoxImpl;->dispatchJs(Ljava/lang/String;)V

    .line 141
    return-void
.end method
