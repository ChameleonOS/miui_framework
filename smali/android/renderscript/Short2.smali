.class public Landroid/renderscript/Short2;
.super Ljava/lang/Object;
.source "Short2.java"


# instance fields
.field public x:S

.field public y:S


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public constructor <init>(SS)V
    .registers 3
    .parameter "initX"
    .parameter "initY"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-short p1, p0, Landroid/renderscript/Short2;->x:S

    iput-short p2, p0, Landroid/renderscript/Short2;->y:S

    return-void
.end method
