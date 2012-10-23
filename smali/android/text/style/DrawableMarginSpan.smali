.class public Landroid/text/style/DrawableMarginSpan;
.super Ljava/lang/Object;
.source "DrawableMarginSpan.java"

# interfaces
.implements Landroid/text/style/LeadingMarginSpan;
.implements Landroid/text/style/LineHeightSpan;


# instance fields
.field private mDrawable:Landroid/graphics/drawable/Drawable;

.field private mPad:I


# direct methods
.method public constructor <init>(Landroid/graphics/drawable/Drawable;)V
    .registers 2
    .parameter "b"

    .prologue
    .line 29
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 30
    iput-object p1, p0, Landroid/text/style/DrawableMarginSpan;->mDrawable:Landroid/graphics/drawable/Drawable;

    .line 31
    return-void
.end method

.method public constructor <init>(Landroid/graphics/drawable/Drawable;I)V
    .registers 3
    .parameter "b"
    .parameter "pad"

    .prologue
    .line 33
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 34
    iput-object p1, p0, Landroid/text/style/DrawableMarginSpan;->mDrawable:Landroid/graphics/drawable/Drawable;

    .line 35
    iput p2, p0, Landroid/text/style/DrawableMarginSpan;->mPad:I

    .line 36
    return-void
.end method


# virtual methods
.method public chooseHeight(Ljava/lang/CharSequence;IIIILandroid/graphics/Paint$FontMetricsInt;)V
    .registers 11
    .parameter "text"
    .parameter "start"
    .parameter "end"
    .parameter "istartv"
    .parameter "v"
    .parameter "fm"

    .prologue
    .line 61
    check-cast p1, Landroid/text/Spanned;

    .end local p1
    invoke-interface {p1, p0}, Landroid/text/Spanned;->getSpanEnd(Ljava/lang/Object;)I

    move-result v2

    if-ne p3, v2, :cond_2e

    .line 62
    iget-object v2, p0, Landroid/text/style/DrawableMarginSpan;->mDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v2}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v0

    .line 64
    .local v0, ht:I
    iget v2, p6, Landroid/graphics/Paint$FontMetricsInt;->descent:I

    add-int/2addr v2, p5

    iget v3, p6, Landroid/graphics/Paint$FontMetricsInt;->ascent:I

    sub-int/2addr v2, v3

    sub-int/2addr v2, p4

    sub-int v1, v0, v2

    .line 65
    .local v1, need:I
    if-lez v1, :cond_1e

    .line 66
    iget v2, p6, Landroid/graphics/Paint$FontMetricsInt;->descent:I

    add-int/2addr v2, v1

    iput v2, p6, Landroid/graphics/Paint$FontMetricsInt;->descent:I

    .line 68
    :cond_1e
    iget v2, p6, Landroid/graphics/Paint$FontMetricsInt;->bottom:I

    add-int/2addr v2, p5

    iget v3, p6, Landroid/graphics/Paint$FontMetricsInt;->top:I

    sub-int/2addr v2, v3

    sub-int/2addr v2, p4

    sub-int v1, v0, v2

    .line 69
    if-lez v1, :cond_2e

    .line 70
    iget v2, p6, Landroid/graphics/Paint$FontMetricsInt;->bottom:I

    add-int/2addr v2, v1

    iput v2, p6, Landroid/graphics/Paint$FontMetricsInt;->bottom:I

    .line 72
    .end local v0           #ht:I
    .end local v1           #need:I
    :cond_2e
    return-void
.end method

.method public drawLeadingMargin(Landroid/graphics/Canvas;Landroid/graphics/Paint;IIIIILjava/lang/CharSequence;IIZLandroid/text/Layout;)V
    .registers 22
    .parameter "c"
    .parameter "p"
    .parameter "x"
    .parameter "dir"
    .parameter "top"
    .parameter "baseline"
    .parameter "bottom"
    .parameter "text"
    .parameter "start"
    .parameter "end"
    .parameter "first"
    .parameter "layout"

    .prologue
    .line 46
    check-cast p8, Landroid/text/Spanned;

    .end local p8
    move-object/from16 v0, p8

    invoke-interface {v0, p0}, Landroid/text/Spanned;->getSpanStart(Ljava/lang/Object;)I

    move-result v5

    .line 47
    .local v5, st:I
    move v4, p3

    .line 48
    .local v4, ix:I
    move-object/from16 v0, p12

    invoke-virtual {v0, v5}, Landroid/text/Layout;->getLineForOffset(I)I

    move-result v6

    move-object/from16 v0, p12

    invoke-virtual {v0, v6}, Landroid/text/Layout;->getLineTop(I)I

    move-result v3

    .line 50
    .local v3, itop:I
    iget-object v6, p0, Landroid/text/style/DrawableMarginSpan;->mDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v6}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v2

    .line 51
    .local v2, dw:I
    iget-object v6, p0, Landroid/text/style/DrawableMarginSpan;->mDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v6}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v1

    .line 54
    .local v1, dh:I
    iget-object v6, p0, Landroid/text/style/DrawableMarginSpan;->mDrawable:Landroid/graphics/drawable/Drawable;

    add-int v7, v4, v2

    add-int v8, v3, v1

    invoke-virtual {v6, v4, v3, v7, v8}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 55
    iget-object v6, p0, Landroid/text/style/DrawableMarginSpan;->mDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v6, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 56
    return-void
.end method

.method public getLeadingMargin(Z)I
    .registers 4
    .parameter "first"

    .prologue
    .line 39
    iget-object v0, p0, Landroid/text/style/DrawableMarginSpan;->mDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v0

    iget v1, p0, Landroid/text/style/DrawableMarginSpan;->mPad:I

    add-int/2addr v0, v1

    return v0
.end method
