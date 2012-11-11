.class public Landroid/view/SoundEffectConstants;
.super Ljava/lang/Object;
.source "SoundEffectConstants.java"


# static fields
.field public static final CLICK:I = 0x0

.field public static final NAVIGATION_DOWN:I = 0x4

.field public static final NAVIGATION_LEFT:I = 0x1

.field public static final NAVIGATION_RIGHT:I = 0x3

.field public static final NAVIGATION_UP:I = 0x2


# direct methods
.method private constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getContantForFocusDirection(I)I
    .registers 3
    .parameter "direction"

    .prologue
    sparse-switch p0, :sswitch_data_14

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT, FOCUS_FORWARD, FOCUS_BACKWARD}."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :sswitch_b
    const/4 v0, 0x3

    :goto_c
    return v0

    :sswitch_d
    const/4 v0, 0x4

    goto :goto_c

    :sswitch_f
    const/4 v0, 0x1

    goto :goto_c

    :sswitch_11
    const/4 v0, 0x2

    goto :goto_c

    nop

    :sswitch_data_14
    .sparse-switch
        0x1 -> :sswitch_11
        0x2 -> :sswitch_d
        0x11 -> :sswitch_f
        0x21 -> :sswitch_11
        0x42 -> :sswitch_b
        0x82 -> :sswitch_d
    .end sparse-switch
.end method
