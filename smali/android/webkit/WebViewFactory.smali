.class Landroid/webkit/WebViewFactory;
.super Ljava/lang/Object;
.source "WebViewFactory.java"


# static fields
.field private static final DEBUG:Z = false

.field private static final DEFAULT_WEB_VIEW_FACTORY:Ljava/lang/String; = "android.webkit.WebViewClassic$Factory"

.field private static final LOGTAG:Ljava/lang/String; = "WebViewFactory"

.field private static sProviderInstance:Landroid/webkit/WebViewFactoryProvider;


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static getFactoryByName(Ljava/lang/String;)Landroid/webkit/WebViewFactoryProvider;
    .registers 6
    .parameter "providerName"

    .prologue
    :try_start_0
    invoke-static {p0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    .local v0, c:Ljava/lang/Class;,"Ljava/lang/Class<*>;"
    invoke-virtual {v0}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/webkit/WebViewFactoryProvider;
    :try_end_a
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_a} :catch_b
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_a} :catch_26
    .catch Ljava/lang/InstantiationException; {:try_start_0 .. :try_end_a} :catch_40

    .end local v0           #c:Ljava/lang/Class;,"Ljava/lang/Class<*>;"
    :goto_a
    return-object v2

    :catch_b
    move-exception v1

    .local v1, e:Ljava/lang/ClassNotFoundException;
    const-string v2, "WebViewFactory"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "error loading "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .end local v1           #e:Ljava/lang/ClassNotFoundException;
    :goto_24
    const/4 v2, 0x0

    goto :goto_a

    :catch_26
    move-exception v1

    .local v1, e:Ljava/lang/IllegalAccessException;
    const-string v2, "WebViewFactory"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "error loading "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_24

    .end local v1           #e:Ljava/lang/IllegalAccessException;
    :catch_40
    move-exception v1

    .local v1, e:Ljava/lang/InstantiationException;
    const-string v2, "WebViewFactory"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "error loading "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_24
.end method

.method static declared-synchronized getProvider()Landroid/webkit/WebViewFactoryProvider;
    .registers 2

    .prologue
    const-class v1, Landroid/webkit/WebViewFactory;

    monitor-enter v1

    :try_start_3
    sget-object v0, Landroid/webkit/WebViewFactory;->sProviderInstance:Landroid/webkit/WebViewFactoryProvider;

    if-eqz v0, :cond_b

    sget-object v0, Landroid/webkit/WebViewFactory;->sProviderInstance:Landroid/webkit/WebViewFactoryProvider;
    :try_end_9
    .catchall {:try_start_3 .. :try_end_9} :catchall_21

    :goto_9
    monitor-exit v1

    return-object v0

    :cond_b
    :try_start_b
    const-string v0, "android.webkit.WebViewClassic$Factory"

    invoke-static {v0}, Landroid/webkit/WebViewFactory;->getFactoryByName(Ljava/lang/String;)Landroid/webkit/WebViewFactoryProvider;

    move-result-object v0

    sput-object v0, Landroid/webkit/WebViewFactory;->sProviderInstance:Landroid/webkit/WebViewFactoryProvider;

    sget-object v0, Landroid/webkit/WebViewFactory;->sProviderInstance:Landroid/webkit/WebViewFactoryProvider;

    if-nez v0, :cond_1e

    new-instance v0, Landroid/webkit/WebViewClassic$Factory;

    invoke-direct {v0}, Landroid/webkit/WebViewClassic$Factory;-><init>()V

    sput-object v0, Landroid/webkit/WebViewFactory;->sProviderInstance:Landroid/webkit/WebViewFactoryProvider;

    :cond_1e
    sget-object v0, Landroid/webkit/WebViewFactory;->sProviderInstance:Landroid/webkit/WebViewFactoryProvider;
    :try_end_20
    .catchall {:try_start_b .. :try_end_20} :catchall_21

    goto :goto_9

    :catchall_21
    move-exception v0

    monitor-exit v1

    throw v0
.end method
