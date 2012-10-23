.class public Landroid/renderscript/Byte3;
.super Ljava/lang/Object;
.source "Byte3.java"


# instance fields
.field public x:B

.field public y:B

.field public z:B


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 28
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 29
    return-void
.end method

.method public constructor <init>(BBB)V
    .registers 4
    .parameter "initX"
    .parameter "initY"
    .parameter "initZ"

    .prologue
    .line 31
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 32
    iput-byte p1, p0, Landroid/renderscript/Byte3;->x:B

    .line 33
    iput-byte p2, p0, Landroid/renderscript/Byte3;->y:B

    .line 34
    iput-byte p3, p0, Landroid/renderscript/Byte3;->z:B

    .line 35
    return-void
.end method
