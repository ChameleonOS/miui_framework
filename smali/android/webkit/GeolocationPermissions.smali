.class public Landroid/webkit/GeolocationPermissions;
.super Ljava/lang/Object;
.source "GeolocationPermissions.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/webkit/GeolocationPermissions$Callback;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 138
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getInstance()Landroid/webkit/GeolocationPermissions;
    .registers 1

    .prologue
    .line 69
    invoke-static {}, Landroid/webkit/WebViewFactory;->getProvider()Landroid/webkit/WebViewFactoryProvider;

    move-result-object v0

    invoke-interface {v0}, Landroid/webkit/WebViewFactoryProvider;->getGeolocationPermissions()Landroid/webkit/GeolocationPermissions;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public allow(Ljava/lang/String;)V
    .registers 2
    .parameter "origin"

    .prologue
    .line 121
    return-void
.end method

.method public clear(Ljava/lang/String;)V
    .registers 2
    .parameter "origin"

    .prologue
    .line 112
    return-void
.end method

.method public clearAll()V
    .registers 1

    .prologue
    .line 128
    return-void
.end method

.method public getAllowed(Ljava/lang/String;Landroid/webkit/ValueCallback;)V
    .registers 3
    .parameter "origin"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Landroid/webkit/ValueCallback",
            "<",
            "Ljava/lang/Boolean;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 103
    .local p2, callback:Landroid/webkit/ValueCallback;,"Landroid/webkit/ValueCallback<Ljava/lang/Boolean;>;"
    return-void
.end method

.method public getOrigins(Landroid/webkit/ValueCallback;)V
    .registers 2
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/webkit/ValueCallback",
            "<",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 88
    .local p1, callback:Landroid/webkit/ValueCallback;,"Landroid/webkit/ValueCallback<Ljava/util/Set<Ljava/lang/String;>;>;"
    return-void
.end method
