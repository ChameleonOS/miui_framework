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
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public constructor <init>(DDD)V
    .registers 7
    .parameter "initX"
    .parameter "initY"
    .parameter "initZ"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-wide p1, p0, Landroid/renderscript/Double3;->x:D

    iput-wide p3, p0, Landroid/renderscript/Double3;->y:D

    iput-wide p5, p0, Landroid/renderscript/Double3;->z:D

    return-void
.end method
