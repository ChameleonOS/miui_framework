.class public Landroid/graphics/PixelXorXfermode;
.super Landroid/graphics/Xfermode;
.source "PixelXorXfermode.java"


# annotations
.annotation runtime Ljava/lang/Deprecated;
.end annotation


# direct methods
.method public constructor <init>(I)V
    .registers 3
    .parameter "opColor"

    .prologue
    invoke-direct {p0}, Landroid/graphics/Xfermode;-><init>()V

    invoke-static {p1}, Landroid/graphics/PixelXorXfermode;->nativeCreate(I)I

    move-result v0

    iput v0, p0, Landroid/graphics/Xfermode;->native_instance:I

    return-void
.end method

.method private static native nativeCreate(I)I
.end method
