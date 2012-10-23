.class public abstract Landroid/graphics/drawable/shapes/Shape;
.super Ljava/lang/Object;
.source "Shape.java"

# interfaces
.implements Ljava/lang/Cloneable;


# instance fields
.field private mHeight:F

.field private mWidth:F


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 28
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public clone()Landroid/graphics/drawable/shapes/Shape;
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    .line 98
    invoke-super {p0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/graphics/drawable/shapes/Shape;

    return-object v0
.end method

.method public bridge synthetic clone()Ljava/lang/Object;
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    .line 28
    invoke-virtual {p0}, Landroid/graphics/drawable/shapes/Shape;->clone()Landroid/graphics/drawable/shapes/Shape;

    move-result-object v0

    return-object v0
.end method

.method public abstract draw(Landroid/graphics/Canvas;Landroid/graphics/Paint;)V
.end method

.method public final getHeight()F
    .registers 2

    .prologue
    .line 43
    iget v0, p0, Landroid/graphics/drawable/shapes/Shape;->mHeight:F

    return v0
.end method

.method public final getWidth()F
    .registers 2

    .prologue
    .line 36
    iget v0, p0, Landroid/graphics/drawable/shapes/Shape;->mWidth:F

    return v0
.end method

.method public hasAlpha()Z
    .registers 2

    .prologue
    .line 85
    const/4 v0, 0x1

    return v0
.end method

.method protected onResize(FF)V
    .registers 3
    .parameter "width"
    .parameter "height"

    .prologue
    .line 94
    return-void
.end method

.method public final resize(FF)V
    .registers 5
    .parameter "width"
    .parameter "height"

    .prologue
    const/4 v1, 0x0

    .line 65
    cmpg-float v0, p1, v1

    if-gez v0, :cond_6

    .line 66
    const/4 p1, 0x0

    .line 68
    :cond_6
    cmpg-float v0, p2, v1

    if-gez v0, :cond_b

    .line 69
    const/4 p2, 0x0

    .line 71
    :cond_b
    iget v0, p0, Landroid/graphics/drawable/shapes/Shape;->mWidth:F

    cmpl-float v0, v0, p1

    if-nez v0, :cond_17

    iget v0, p0, Landroid/graphics/drawable/shapes/Shape;->mHeight:F

    cmpl-float v0, v0, p2

    if-eqz v0, :cond_1e

    .line 72
    :cond_17
    iput p1, p0, Landroid/graphics/drawable/shapes/Shape;->mWidth:F

    .line 73
    iput p2, p0, Landroid/graphics/drawable/shapes/Shape;->mHeight:F

    .line 74
    invoke-virtual {p0, p1, p2}, Landroid/graphics/drawable/shapes/Shape;->onResize(FF)V

    .line 76
    :cond_1e
    return-void
.end method
