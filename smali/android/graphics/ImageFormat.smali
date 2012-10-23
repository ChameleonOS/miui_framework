.class public Landroid/graphics/ImageFormat;
.super Ljava/lang/Object;
.source "ImageFormat.java"


# static fields
.field public static final BAYER_RGGB:I = 0x200

.field public static final JPEG:I = 0x100

.field public static final NV16:I = 0x10

.field public static final NV21:I = 0x11

.field public static final RGB_565:I = 0x4

.field public static final UNKNOWN:I = 0x0

.field public static final YUY2:I = 0x14

.field public static final YV12:I = 0x32315659


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 19
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getBitsPerPixel(I)I
    .registers 3
    .parameter "format"

    .prologue
    const/16 v1, 0xc

    const/16 v0, 0x10

    .line 121
    sparse-switch p0, :sswitch_data_e

    .line 135
    const/4 v0, -0x1

    :goto_8
    :sswitch_8
    return v0

    :sswitch_9
    move v0, v1

    .line 129
    goto :goto_8

    :sswitch_b
    move v0, v1

    .line 131
    goto :goto_8

    .line 121
    nop

    :sswitch_data_e
    .sparse-switch
        0x4 -> :sswitch_8
        0x10 -> :sswitch_8
        0x11 -> :sswitch_b
        0x14 -> :sswitch_8
        0x200 -> :sswitch_8
        0x32315659 -> :sswitch_9
    .end sparse-switch
.end method
