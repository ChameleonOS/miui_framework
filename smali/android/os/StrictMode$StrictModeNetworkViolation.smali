.class public Landroid/os/StrictMode$StrictModeNetworkViolation;
.super Landroid/os/StrictMode$StrictModeViolation;
.source "StrictMode.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/os/StrictMode;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StrictModeNetworkViolation"
.end annotation


# direct methods
.method public constructor <init>(I)V
    .registers 4
    .parameter "policyMask"

    .prologue
    .line 800
    const/4 v0, 0x4

    const/4 v1, 0x0

    invoke-direct {p0, p1, v0, v1}, Landroid/os/StrictMode$StrictModeViolation;-><init>(IILjava/lang/String;)V

    .line 801
    return-void
.end method
