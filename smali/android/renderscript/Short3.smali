.class public Landroid/renderscript/Short3;
.super Ljava/lang/Object;
.source "Short3.java"


# instance fields
.field public x:S

.field public y:S

.field public z:S


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 28
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 29
    return-void
.end method

.method public constructor <init>(SSS)V
    .registers 4
    .parameter "initX"
    .parameter "initY"
    .parameter "initZ"

    .prologue
    .line 31
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 32
    iput-short p1, p0, Landroid/renderscript/Short3;->x:S

    .line 33
    iput-short p2, p0, Landroid/renderscript/Short3;->y:S

    .line 34
    iput-short p3, p0, Landroid/renderscript/Short3;->z:S

    .line 35
    return-void
.end method
