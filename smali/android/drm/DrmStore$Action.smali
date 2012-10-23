.class public Landroid/drm/DrmStore$Action;
.super Ljava/lang/Object;
.source "DrmStore.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/drm/DrmStore;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Action"
.end annotation


# static fields
.field public static final DEFAULT:I = 0x0

.field public static final DISPLAY:I = 0x7

.field public static final EXECUTE:I = 0x6

.field public static final OUTPUT:I = 0x4

.field public static final PLAY:I = 0x1

.field public static final PREVIEW:I = 0x5

.field public static final RINGTONE:I = 0x2

.field public static final TRANSFER:I = 0x3


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 218
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static isValid(I)Z
    .registers 2
    .parameter "action"

    .prologue
    .line 198
    const/4 v0, 0x0

    .line 200
    .local v0, isValid:Z
    packed-switch p0, :pswitch_data_8

    .line 211
    :goto_4
    return v0

    .line 209
    :pswitch_5
    const/4 v0, 0x1

    goto :goto_4

    .line 200
    nop

    :pswitch_data_8
    .packed-switch 0x0
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
        :pswitch_5
    .end packed-switch
.end method
