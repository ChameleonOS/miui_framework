.class public Landroid/renderscript/Long4;
.super Ljava/lang/Object;
.source "Long4.java"


# instance fields
.field public w:J

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

.method public constructor <init>(JJJJ)V
    .registers 9
    .parameter "initX"
    .parameter "initY"
    .parameter "initZ"
    .parameter "initW"

    .prologue
    .line 30
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 31
    iput-wide p1, p0, Landroid/renderscript/Long4;->x:J

    .line 32
    iput-wide p3, p0, Landroid/renderscript/Long4;->y:J

    .line 33
    iput-wide p5, p0, Landroid/renderscript/Long4;->z:J

    .line 34
    iput-wide p7, p0, Landroid/renderscript/Long4;->w:J

    .line 35
    return-void
.end method
