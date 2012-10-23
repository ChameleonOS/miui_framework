.class public Landroid/renderscript/Double3;
.super Ljava/lang/Object;
.source "Double3.java"


# instance fields
.field public x:D

.field public y:D

.field public z:D


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 29
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 30
    return-void
.end method

.method public constructor <init>(DDD)V
    .registers 7
    .parameter "initX"
    .parameter "initY"
    .parameter "initZ"

    .prologue
    .line 32
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 33
    iput-wide p1, p0, Landroid/renderscript/Double3;->x:D

    .line 34
    iput-wide p3, p0, Landroid/renderscript/Double3;->y:D

    .line 35
    iput-wide p5, p0, Landroid/renderscript/Double3;->z:D

    .line 36
    return-void
.end method
