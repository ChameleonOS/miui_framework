.class Landroid/os/StrictMode$StrictModeDiskWriteViolation;
.super Landroid/os/StrictMode$StrictModeViolation;
.source "StrictMode.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/os/StrictMode;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "StrictModeDiskWriteViolation"
.end annotation


# direct methods
.method public constructor <init>(I)V
    .registers 4
    .parameter "policyMask"

    .prologue
    .line 818
    const/4 v0, 0x1

    const/4 v1, 0x0

    invoke-direct {p0, p1, v0, v1}, Landroid/os/StrictMode$StrictModeViolation;-><init>(IILjava/lang/String;)V

    .line 819
    return-void
.end method
