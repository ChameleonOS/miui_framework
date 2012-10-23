.class public Landroid/graphics/drawable/shapes/PathShape;
.super Landroid/graphics/drawable/shapes/Shape;
.source "PathShape.java"


# instance fields
.field private mPath:Landroid/graphics/Path;

.field private mScaleX:F

.field private mScaleY:F

.field private mStdHeight:F

.field private mStdWidth:F


# direct methods
.method public constructor <init>(Landroid/graphics/Path;FF)V
    .registers 4
    .parameter "path"
    .parameter "stdWidth"
    .parameter "stdHeight"

    .prologue
    .line 48
    invoke-direct {p0}, Landroid/graphics/drawable/shapes/Shape;-><init>()V

    .line 49
    iput-object p1, p0, Landroid/graphics/drawable/shapes/PathShape;->mPath:Landroid/graphics/Path;

    .line 50
    iput p2, p0, Landroid/graphics/drawable/shapes/PathShape;->mStdWidth:F

    .line 51
    iput p3, p0, Landroid/graphics/drawable/shapes/PathShape;->mStdHeight:F

    .line 52
    return-void
.end method


# virtual methods
.method public clone()Landroid/graphics/drawable/shapes/PathShape;
    .registers 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    .line 70
    invoke-super {p0}, Landroid/graphics/drawable/shapes/Shape;->clone()Landroid/graphics/drawable/shapes/Shape;

    move-result-object v0

    check-cast v0, Landroid/graphics/drawable/shapes/PathShape;

    .line 71
    .local v0, shape:Landroid/graphics/drawable/shapes/PathShape;
    new-instance v1, Landroid/graphics/Path;

    iget-object v2, p0, Landroid/graphics/drawable/shapes/PathShape;->mPath:Landroid/graphics/Path;

    invoke-direct {v1, v2}, Landroid/graphics/Path;-><init>(Landroid/graphics/Path;)V

    iput-object v1, v0, Landroid/graphics/drawable/shapes/PathShape;->mPath:Landroid/graphics/Path;

    .line 72
    return-object v0
.end method

.method public bridge synthetic clone()Landroid/graphics/drawable/shapes/Shape;
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    .line 29
    invoke-virtual {p0}, Landroid/graphics/drawable/shapes/PathShape;->clone()Landroid/graphics/drawable/shapes/PathShape;

    move-result-object v0

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
    .line 29
    invoke-virtual {p0}, Landroid/graphics/drawable/shapes/PathShape;->clone()Landroid/graphics/drawable/shapes/PathShape;

    move-result-object v0

    return-object v0
.end method

.method public draw(Landroid/graphics/Canvas;Landroid/graphics/Paint;)V
    .registers 5
    .parameter "canvas"
    .parameter "paint"

    .prologue
    .line 56
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    .line 57
    iget v0, p0, Landroid/graphics/drawable/shapes/PathShape;->mScaleX:F

    iget v1, p0, Landroid/graphics/drawable/shapes/PathShape;->mScaleY:F

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->scale(FF)V

    .line 58
    iget-object v0, p0, Landroid/graphics/drawable/shapes/PathShape;->mPath:Landroid/graphics/Path;

    invoke-virtual {p1, v0, p2}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 59
    invoke-virtual {p1}, Landroid/graphics/Canvas;->restore()V

    .line 60
    return-void
.end method

.method protected onResize(FF)V
    .registers 4
    .parameter "width"
    .parameter "height"

    .prologue
    .line 64
    iget v0, p0, Landroid/graphics/drawable/shapes/PathShape;->mStdWidth:F

    div-float v0, p1, v0

    iput v0, p0, Landroid/graphics/drawable/shapes/PathShape;->mScaleX:F

    .line 65
    iget v0, p0, Landroid/graphics/drawable/shapes/PathShape;->mStdHeight:F

    div-float v0, p2, v0

    iput v0, p0, Landroid/graphics/drawable/shapes/PathShape;->mScaleY:F

    .line 66
    return-void
.end method
