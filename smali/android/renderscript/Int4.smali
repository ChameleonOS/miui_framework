.class public Landroid/renderscript/Int4;
.super Ljava/lang/Object;
.source "Int4.java"


# instance fields
.field public w:I

.field public x:I

.field public y:I

.field public z:I


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 28
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 29
    return-void
.end method

.method public constructor <init>(IIII)V
    .registers 5
    .parameter "initX"
    .parameter "initY"
    .parameter "initZ"
    .parameter "initW"

    .prologue
    .line 31
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 32
    iput p1, p0, Landroid/renderscript/Int4;->x:I

    .line 33
    iput p2, p0, Landroid/renderscript/Int4;->y:I

    .line 34
    iput p3, p0, Landroid/renderscript/Int4;->z:I

    .line 35
    iput p4, p0, Landroid/renderscript/Int4;->w:I

    .line 36
    return-void
.end method
