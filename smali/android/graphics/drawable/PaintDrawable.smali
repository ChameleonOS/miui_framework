.class public Landroid/graphics/drawable/PaintDrawable;
.super Landroid/graphics/drawable/ShapeDrawable;
.source "PaintDrawable.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct {p0}, Landroid/graphics/drawable/ShapeDrawable;-><init>()V

    return-void
.end method

.method public constructor <init>(I)V
    .registers 3
    .parameter "color"

    .prologue
    invoke-direct {p0}, Landroid/graphics/drawable/ShapeDrawable;-><init>()V

    invoke-virtual {p0}, Landroid/graphics/drawable/PaintDrawable;->getPaint()Landroid/graphics/Paint;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setColor(I)V

    return-void
.end method


# virtual methods
.method protected inflateTag(Ljava/lang/String;Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;)Z
    .registers 14
    .parameter "name"
    .parameter "r"
    .parameter "parser"
    .parameter "attrs"

    .prologue
    const-string v6, "corners"

    invoke-virtual {p1, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_60

    sget-object v6, Lcom/android/internal/R$styleable;->DrawableCorners:[I

    invoke-virtual {p2, p4, v6}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .local v0, a:Landroid/content/res/TypedArray;
    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual {v0, v6, v7}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v3

    .local v3, radius:I
    int-to-float v6, v3

    invoke-virtual {p0, v6}, Landroid/graphics/drawable/PaintDrawable;->setCornerRadius(F)V

    const/4 v6, 0x1

    invoke-virtual {v0, v6, v3}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v4

    .local v4, topLeftRadius:I
    const/4 v6, 0x2

    invoke-virtual {v0, v6, v3}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v5

    .local v5, topRightRadius:I
    const/4 v6, 0x3

    invoke-virtual {v0, v6, v3}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v1

    .local v1, bottomLeftRadius:I
    const/4 v6, 0x4

    invoke-virtual {v0, v6, v3}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v2

    .local v2, bottomRightRadius:I
    if-ne v4, v3, :cond_34

    if-ne v5, v3, :cond_34

    if-ne v1, v3, :cond_34

    if-eq v2, v3, :cond_5b

    :cond_34
    const/16 v6, 0x8

    new-array v6, v6, [F

    const/4 v7, 0x0

    int-to-float v8, v4

    aput v8, v6, v7

    const/4 v7, 0x1

    int-to-float v8, v4

    aput v8, v6, v7

    const/4 v7, 0x2

    int-to-float v8, v5

    aput v8, v6, v7

    const/4 v7, 0x3

    int-to-float v8, v5

    aput v8, v6, v7

    const/4 v7, 0x4

    int-to-float v8, v1

    aput v8, v6, v7

    const/4 v7, 0x5

    int-to-float v8, v1

    aput v8, v6, v7

    const/4 v7, 0x6

    int-to-float v8, v2

    aput v8, v6, v7

    const/4 v7, 0x7

    int-to-float v8, v2

    aput v8, v6, v7

    invoke-virtual {p0, v6}, Landroid/graphics/drawable/PaintDrawable;->setCornerRadii([F)V

    :cond_5b
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    const/4 v6, 0x1

    .end local v0           #a:Landroid/content/res/TypedArray;
    .end local v1           #bottomLeftRadius:I
    .end local v2           #bottomRightRadius:I
    .end local v3           #radius:I
    .end local v4           #topLeftRadius:I
    .end local v5           #topRightRadius:I
    :goto_5f
    return v6

    :cond_60
    invoke-super {p0, p1, p2, p3, p4}, Landroid/graphics/drawable/ShapeDrawable;->inflateTag(Ljava/lang/String;Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;)Z

    move-result v6

    goto :goto_5f
.end method

.method public setCornerRadii([F)V
    .registers 4
    .parameter "radii"

    .prologue
    const/4 v1, 0x0

    if-nez p1, :cond_10

    invoke-virtual {p0}, Landroid/graphics/drawable/PaintDrawable;->getShape()Landroid/graphics/drawable/shapes/Shape;

    move-result-object v0

    if-eqz v0, :cond_c

    invoke-virtual {p0, v1}, Landroid/graphics/drawable/PaintDrawable;->setShape(Landroid/graphics/drawable/shapes/Shape;)V

    :cond_c
    :goto_c
    invoke-virtual {p0}, Landroid/graphics/drawable/PaintDrawable;->invalidateSelf()V

    return-void

    :cond_10
    new-instance v0, Landroid/graphics/drawable/shapes/RoundRectShape;

    invoke-direct {v0, p1, v1, v1}, Landroid/graphics/drawable/shapes/RoundRectShape;-><init>([FLandroid/graphics/RectF;[F)V

    invoke-virtual {p0, v0}, Landroid/graphics/drawable/PaintDrawable;->setShape(Landroid/graphics/drawable/shapes/Shape;)V

    goto :goto_c
.end method

.method public setCornerRadius(F)V
    .registers 6
    .parameter "radius"

    .prologue
    const/16 v3, 0x8

    const/4 v1, 0x0

    .local v1, radii:[F
    const/4 v2, 0x0

    cmpl-float v2, p1, v2

    if-lez v2, :cond_12

    new-array v1, v3, [F

    const/4 v0, 0x0

    .local v0, i:I
    :goto_b
    if-ge v0, v3, :cond_12

    aput p1, v1, v0

    add-int/lit8 v0, v0, 0x1

    goto :goto_b

    .end local v0           #i:I
    :cond_12
    invoke-virtual {p0, v1}, Landroid/graphics/drawable/PaintDrawable;->setCornerRadii([F)V

    return-void
.end method
