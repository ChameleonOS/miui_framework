.class Landroid/text/StaticLayout$Injector;
.super Ljava/lang/Object;
.source "StaticLayout.java"


# annotations
.annotation build Landroid/annotation/MiuiHook;
    value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_CLASS:Landroid/annotation/MiuiHook$MiuiHookType;
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/text/StaticLayout;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Injector"
.end annotation


# static fields
.field static CHAR_UNKNOWN:C


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 45
    const/16 v0, 0x2e7f

    sput-char v0, Landroid/text/StaticLayout$Injector;->CHAR_UNKNOWN:C

    return-void
.end method

.method constructor <init>()V
    .registers 1

    .prologue
    .line 44
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static isIdeographic(CZ)Z
    .registers 4
    .parameter "c"
    .parameter "includeNonStarters"

    .prologue
    const/4 v0, 0x0

    .line 63
    const/16 v1, 0x3001

    if-lt p0, v1, :cond_f

    const/16 v1, 0x3017

    if-gt p0, v1, :cond_f

    .line 64
    sparse-switch p0, :sswitch_data_34

    .line 71
    sparse-switch p0, :sswitch_data_46

    .line 81
    :cond_f
    const v1, 0xfe5d

    if-ne p0, v1, :cond_18

    move p1, v0

    .line 100
    .end local p1
    :cond_15
    :goto_15
    :sswitch_15
    return p1

    .restart local p1
    :sswitch_16
    move p1, v0

    .line 69
    goto :goto_15

    .line 83
    :cond_18
    const v1, 0xfe5e

    if-eq p0, v1, :cond_15

    .line 86
    const v1, 0xff01

    if-lt p0, v1, :cond_31

    const v1, 0xff1f

    if-gt p0, v1, :cond_31

    .line 87
    const v1, 0xff08

    if-ne p0, v1, :cond_2e

    move p1, v0

    .line 88
    goto :goto_15

    .line 90
    :cond_2e
    sparse-switch p0, :sswitch_data_60

    :cond_31
    move p1, v0

    .line 100
    goto :goto_15

    .line 64
    nop

    :sswitch_data_34
    .sparse-switch
        0x300a -> :sswitch_16
        0x300e -> :sswitch_16
        0x3010 -> :sswitch_16
        0x3016 -> :sswitch_16
    .end sparse-switch

    .line 71
    :sswitch_data_46
    .sparse-switch
        0x3001 -> :sswitch_15
        0x3002 -> :sswitch_15
        0x300b -> :sswitch_15
        0x300f -> :sswitch_15
        0x3011 -> :sswitch_15
        0x3017 -> :sswitch_15
    .end sparse-switch

    .line 90
    :sswitch_data_60
    .sparse-switch
        0xff01 -> :sswitch_15
        0xff09 -> :sswitch_15
        0xff0c -> :sswitch_15
        0xff1a -> :sswitch_15
        0xff1b -> :sswitch_15
        0xff1f -> :sswitch_15
    .end sparse-switch
.end method

.method static validateCJKCharAsSpace(C[CIII)C
    .registers 9
    .parameter "c"
    .parameter "chs"
    .parameter "j"
    .parameter "spanEnd"
    .parameter "paraStart"

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    const/16 v1, 0x2e80

    .line 47
    if-lt p0, v1, :cond_22

    invoke-static {p0, v3}, Landroid/text/StaticLayout$Injector;->isIdeographic(CZ)Z

    move-result v0

    if-eqz v0, :cond_22

    add-int/lit8 v0, p2, 0x1

    if-ge v0, p3, :cond_22

    add-int/lit8 v0, p2, 0x1

    sub-int/2addr v0, p4

    aget-char v0, p1, v0

    if-lt v0, v1, :cond_40

    add-int/lit8 v0, p2, 0x1

    sub-int/2addr v0, p4

    aget-char v0, p1, v0

    invoke-static {v0, v2}, Landroid/text/StaticLayout$Injector;->isIdeographic(CZ)Z

    move-result v0

    if-nez v0, :cond_40

    :cond_22
    if-ge p0, v1, :cond_43

    add-int/lit8 v0, p2, 0x1

    if-ge v0, p3, :cond_43

    add-int/lit8 v0, p2, 0x1

    sub-int/2addr v0, p4

    aget-char v0, p1, v0

    if-lt v0, v1, :cond_43

    invoke-static {p0, v3}, Landroid/text/StaticLayout$Injector;->isIdeographic(CZ)Z

    move-result v0

    if-nez v0, :cond_43

    add-int/lit8 v0, p2, 0x1

    sub-int/2addr v0, p4

    aget-char v0, p1, v0

    invoke-static {v0, v2}, Landroid/text/StaticLayout$Injector;->isIdeographic(CZ)Z

    move-result v0

    if-eqz v0, :cond_43

    .line 51
    :cond_40
    const/16 p0, 0x20

    .line 59
    .end local p0
    :cond_42
    :goto_42
    return p0

    .line 54
    .restart local p0
    :cond_43
    if-lt p0, v1, :cond_42

    invoke-static {p0, v3}, Landroid/text/StaticLayout$Injector;->isIdeographic(CZ)Z

    move-result v0

    if-eqz v0, :cond_42

    add-int/lit8 v0, p2, 0x1

    if-ge v0, p3, :cond_42

    add-int/lit8 v0, p2, 0x1

    sub-int/2addr v0, p4

    aget-char v0, p1, v0

    invoke-static {v0, v2}, Landroid/text/StaticLayout$Injector;->isIdeographic(CZ)Z

    move-result v0

    if-eqz v0, :cond_42

    .line 57
    sget-char p0, Landroid/text/StaticLayout$Injector;->CHAR_UNKNOWN:C

    goto :goto_42
.end method
