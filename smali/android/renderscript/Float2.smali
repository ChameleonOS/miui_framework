.class public Landroid/renderscript/Float2;
.super Ljava/lang/Object;
.source "Float2.java"


# instance fields
.field public x:F

.field public y:F


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 28
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 29
    return-void
.end method

.method public constructor <init>(FF)V
    .registers 3
    .parameter "initX"
    .parameter "initY"

    .prologue
    .line 31
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 32
    iput p1, p0, Landroid/renderscript/Float2;->x:F

    .line 33
    iput p2, p0, Landroid/renderscript/Float2;->y:F

    .line 34
    return-void
.end method
