.class public Landroid/renderscript/Long3;
.super Ljava/lang/Object;
.source "Long3.java"


# instance fields
.field public x:J

.field public y:J

.field public z:J


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 27
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 28
    return-void
.end method

.method public constructor <init>(JJJ)V
    .registers 7
    .parameter "initX"
    .parameter "initY"
    .parameter "initZ"

    .prologue
    .line 30
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 31
    iput-wide p1, p0, Landroid/renderscript/Long3;->x:J

    .line 32
    iput-wide p3, p0, Landroid/renderscript/Long3;->y:J

    .line 33
    iput-wide p5, p0, Landroid/renderscript/Long3;->z:J

    .line 34
    return-void
.end method
