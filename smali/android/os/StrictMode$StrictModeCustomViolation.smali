.class Landroid/os/StrictMode$StrictModeCustomViolation;
.super Landroid/os/StrictMode$StrictModeViolation;
.source "StrictMode.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/os/StrictMode;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "StrictModeCustomViolation"
.end annotation


# direct methods
.method public constructor <init>(ILjava/lang/String;)V
    .registers 4
    .parameter "policyMask"
    .parameter "name"

    .prologue
    .line 827
    const/16 v0, 0x8

    invoke-direct {p0, p1, v0, p2}, Landroid/os/StrictMode$StrictModeViolation;-><init>(IILjava/lang/String;)V

    .line 828
    return-void
.end method
