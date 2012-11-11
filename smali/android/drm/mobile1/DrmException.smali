.class public Landroid/drm/mobile1/DrmException;
.super Ljava/lang/Exception;
.source "DrmException.java"


# direct methods
.method private constructor <init>()V
    .registers 1

    .prologue
    invoke-direct {p0}, Ljava/lang/Exception;-><init>()V

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .registers 2
    .parameter "message"

    .prologue
    invoke-direct {p0, p1}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    return-void
.end method
