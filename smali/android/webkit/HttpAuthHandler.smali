.class public Landroid/webkit/HttpAuthHandler;
.super Landroid/os/Handler;
.source "HttpAuthHandler.java"


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public cancel()V
    .registers 1

    .prologue
    return-void
.end method

.method public proceed(Ljava/lang/String;Ljava/lang/String;)V
    .registers 3
    .parameter "username"
    .parameter "password"

    .prologue
    return-void
.end method

.method public suppressDialog()Z
    .registers 2

    .prologue
    const/4 v0, 0x0

    return v0
.end method

.method public useHttpAuthUsernamePassword()Z
    .registers 2

    .prologue
    const/4 v0, 0x0

    return v0
.end method
