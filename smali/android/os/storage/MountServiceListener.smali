.class public abstract Landroid/os/storage/MountServiceListener;
.super Ljava/lang/Object;
.source "MountServiceListener.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 24
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method onStorageStateChange(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .registers 4
    .parameter "path"
    .parameter "oldState"
    .parameter "newState"

    .prologue
    .line 43
    return-void
.end method

.method onUsbMassStorageConnectionChanged(Z)V
    .registers 2
    .parameter "connected"

    .prologue
    .line 31
    return-void
.end method
