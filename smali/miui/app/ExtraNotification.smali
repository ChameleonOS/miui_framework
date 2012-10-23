.class public Lmiui/app/ExtraNotification;
.super Ljava/lang/Object;
.source "ExtraNotification.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 3
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getLedPwmOffOn(I)[I
    .registers 4
    .parameter "totalLength"

    .prologue
    const/4 v2, 0x0

    .line 10
    const/4 v1, 0x2

    new-array v0, v1, [I

    .line 11
    .local v0, values:[I
    div-int/lit8 v1, p0, 0x4

    mul-int/lit8 v1, v1, 0x3

    aput v1, v0, v2

    .line 12
    const/4 v1, 0x1

    aget v2, v0, v2

    sub-int v2, p0, v2

    aput v2, v0, v1

    .line 13
    return-object v0
.end method
