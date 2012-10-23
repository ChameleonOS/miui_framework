.class public Landroid/renderscript/Int2;
.super Ljava/lang/Object;
.source "Int2.java"


# instance fields
.field public x:I

.field public y:I


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 28
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 29
    return-void
.end method

.method public constructor <init>(II)V
    .registers 3
    .parameter "initX"
    .parameter "initY"

    .prologue
    .line 31
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 32
    iput p1, p0, Landroid/renderscript/Int2;->x:I

    .line 33
    iput p2, p0, Landroid/renderscript/Int2;->y:I

    .line 34
    return-void
.end method
