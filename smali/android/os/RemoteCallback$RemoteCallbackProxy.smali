.class Landroid/os/RemoteCallback$RemoteCallbackProxy;
.super Landroid/os/RemoteCallback;
.source "RemoteCallback.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/os/RemoteCallback;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "RemoteCallbackProxy"
.end annotation


# direct methods
.method constructor <init>(Landroid/os/IRemoteCallback;)V
    .registers 2
    .parameter "target"

    .prologue
    .line 48
    invoke-direct {p0, p1}, Landroid/os/RemoteCallback;-><init>(Landroid/os/IRemoteCallback;)V

    .line 49
    return-void
.end method


# virtual methods
.method protected onResult(Landroid/os/Bundle;)V
    .registers 2
    .parameter "bundle"

    .prologue
    .line 52
    return-void
.end method
