.class Landroid/os/StrictMode$LogStackTrace;
.super Ljava/lang/Exception;
.source "StrictMode.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/os/StrictMode;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "LogStackTrace"
.end annotation


# direct methods
.method private constructor <init>()V
    .registers 1

    .prologue
    .line 1647
    invoke-direct {p0}, Ljava/lang/Exception;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Landroid/os/StrictMode$1;)V
    .registers 2
    .parameter "x0"

    .prologue
    .line 1647
    invoke-direct {p0}, Landroid/os/StrictMode$LogStackTrace;-><init>()V

    return-void
.end method
