.class public Landroid/net/http/LoggingEventHandler;
.super Ljava/lang/Object;
.source "LoggingEventHandler.java"

# interfaces
.implements Landroid/net/http/EventHandler;


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 28
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public certificate(Landroid/net/http/SslCertificate;)V
    .registers 2
    .parameter "certificate"

    .prologue
    .line 76
    return-void
.end method

.method public data([BI)V
    .registers 3
    .parameter "data"
    .parameter "len"

    .prologue
    .line 65
    return-void
.end method

.method public endData()V
    .registers 1

    .prologue
    .line 70
    return-void
.end method

.method public error(ILjava/lang/String;)V
    .registers 3
    .parameter "id"
    .parameter "description"

    .prologue
    .line 83
    return-void
.end method

.method public handleSslErrorRequest(Landroid/net/http/SslError;)Z
    .registers 3
    .parameter "error"

    .prologue
    .line 90
    const/4 v0, 0x0

    return v0
.end method

.method public headers(Landroid/net/http/Headers;)V
    .registers 2
    .parameter "headers"

    .prologue
    .line 51
    return-void
.end method

.method public locationChanged(Ljava/lang/String;Z)V
    .registers 3
    .parameter "newLocation"
    .parameter "permanent"

    .prologue
    .line 58
    return-void
.end method

.method public requestSent()V
    .registers 2

    .prologue
    .line 31
    const-string v0, "LoggingEventHandler:requestSent()"

    invoke-static {v0}, Landroid/net/http/HttpLog;->v(Ljava/lang/String;)V

    .line 32
    return-void
.end method

.method public status(IIILjava/lang/String;)V
    .registers 5
    .parameter "major_version"
    .parameter "minor_version"
    .parameter "code"
    .parameter "reason_phrase"

    .prologue
    .line 44
    return-void
.end method
