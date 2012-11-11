.class public Landroid/graphics/drawable/ColorDrawable;
.super Landroid/graphics/drawable/Drawable;
.source "ColorDrawable.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/graphics/drawable/ColorDrawable$1;,
        Landroid/graphics/drawable/ColorDrawable$ColorState;
    }
.end annotation


# instance fields
.field private final mPaint:Landroid/graphics/Paint;

.field private mState:Landroid/graphics/drawable/ColorDrawable$ColorState;


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Landroid/graphics/drawable/ColorDrawable;-><init>(Landroid/graphics/drawable/ColorDrawable$ColorState;)V

    return-void
.end method

.method public constructor <init>(I)V
    .registers 3
    .parameter "color"

    .prologue
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Landroid/graphics/drawable/ColorDrawable;-><init>(Landroid/graphics/drawable/ColorDrawable$ColorState;)V

    invoke-virtual {p0, p1}, Landroid/graphics/drawable/ColorDrawable;->setColor(I)V

    return-void
.end method

.method private constructor <init>(Landroid/graphics/drawable/ColorDrawable$ColorState;)V
    .registers 3
    .parameter "state"

    .prologue
    invoke-direct {p0}, Landroid/graphics/drawable/Drawable;-><init>()V

    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Landroid/graphics/drawable/ColorDrawable;->mPaint:Landroid/graphics/Paint;

    new-instance v0, Landroid/graphics/drawable/ColorDrawable$ColorState;

    invoke-direct {v0, p1}, Landroid/graphics/drawable/ColorDrawable$ColorState;-><init>(Landroid/graphics/drawable/ColorDrawable$ColorState;)V

    iput-object v0, p0, Landroid/graphics/drawable/ColorDrawable;->mState:Landroid/graphics/drawable/ColorDrawable$ColorState;

    return-void
.end method

.method synthetic constructor <init>(Landroid/graphics/drawable/ColorDrawable$ColorState;Landroid/graphics/drawable/ColorDrawable$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    invoke-direct {p0, p1}, Landroid/graphics/drawable/ColorDrawable;-><init>(Landroid/graphics/drawable/ColorDrawable$ColorState;)V

    return-void
.end method


# virtual methods
.method public draw(Landroid/graphics/Canvas;)V
    .registers 4
    .parameter "canvas"

    .prologue
    iget-object v0, p0, Landroid/graphics/drawable/ColorDrawable;->mState:Landroid/graphics/drawable/ColorDrawable$ColorState;

    iget v0, v0, Landroid/graphics/drawable/ColorDrawable$ColorState;->mUseColor:I

    ushr-int/lit8 v0, v0, 0x18

    if-eqz v0, :cond_1a

    iget-object v0, p0, Landroid/graphics/drawable/ColorDrawable;->mPaint:Landroid/graphics/Paint;

    iget-object v1, p0, Landroid/graphics/drawable/ColorDrawable;->mState:Landroid/graphics/drawable/ColorDrawable$ColorState;

    iget v1, v1, Landroid/graphics/drawable/ColorDrawable$ColorState;->mUseColor:I

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    invoke-virtual {p0}, Landroid/graphics/drawable/ColorDrawable;->getBounds()Landroid/graphics/Rect;

    move-result-object v0

    iget-object v1, p0, Landroid/graphics/drawable/ColorDrawable;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    :cond_1a
    return-void
.end method

.method public getAlpha()I
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/graphics/drawable/ColorDrawable;->mState:Landroid/graphics/drawable/ColorDrawable$ColorState;

    iget v0, v0, Landroid/graphics/drawable/ColorDrawable$ColorState;->mUseColor:I

    ushr-int/lit8 v0, v0, 0x18

    return v0
.end method

.method public getChangingConfigurations()I
    .registers 3

    .prologue
    invoke-super {p0}, Landroid/graphics/drawable/Drawable;->getChangingConfigurations()I

    move-result v0

    iget-object v1, p0, Landroid/graphics/drawable/ColorDrawable;->mState:Landroid/graphics/drawable/ColorDrawable$ColorState;

    iget v1, v1, Landroid/graphics/drawable/ColorDrawable$ColorState;->mChangingConfigurations:I

    or-int/2addr v0, v1

    return v0
.end method

.method public getColor()I
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/graphics/drawable/ColorDrawable;->mState:Landroid/graphics/drawable/ColorDrawable$ColorState;

    iget v0, v0, Landroid/graphics/drawable/ColorDrawable$ColorState;->mUseColor:I

    return v0
.end method

.method public getConstantState()Landroid/graphics/drawable/Drawable$ConstantState;
    .registers 3

    .prologue
    iget-object v0, p0, Landroid/graphics/drawable/ColorDrawable;->mState:Landroid/graphics/drawable/ColorDrawable$ColorState;

    invoke-virtual {p0}, Landroid/graphics/drawable/ColorDrawable;->getChangingConfigurations()I

    move-result v1

    iput v1, v0, Landroid/graphics/drawable/ColorDrawable$ColorState;->mChangingConfigurations:I

    iget-object v0, p0, Landroid/graphics/drawable/ColorDrawable;->mState:Landroid/graphics/drawable/ColorDrawable$ColorState;

    return-object v0
.end method

.method public getOpacity()I
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/graphics/drawable/ColorDrawable;->mState:Landroid/graphics/drawable/ColorDrawable$ColorState;

    iget v0, v0, Landroid/graphics/drawable/ColorDrawable$ColorState;->mUseColor:I

    ushr-int/lit8 v0, v0, 0x18

    sparse-switch v0, :sswitch_data_10

    const/4 v0, -0x3

    :goto_a
    return v0

    :sswitch_b
    const/4 v0, -0x1

    goto :goto_a

    :sswitch_d
    const/4 v0, -0x2

    goto :goto_a

    nop

    :sswitch_data_10
    .sparse-switch
        0x0 -> :sswitch_d
        0xff -> :sswitch_b
    .end sparse-switch
.end method

.method public inflate(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;)V
    .registers 8
    .parameter "r"
    .parameter "parser"
    .parameter "attrs"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    invoke-super {p0, p1, p2, p3}, Landroid/graphics/drawable/Drawable;->inflate(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;)V

    sget-object v2, Lcom/android/internal/R$styleable;->ColorDrawable:[I

    invoke-virtual {p1, p3, v2}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .local v0, a:Landroid/content/res/TypedArray;
    iget-object v2, p0, Landroid/graphics/drawable/ColorDrawable;->mState:Landroid/graphics/drawable/ColorDrawable$ColorState;

    iget v1, v2, Landroid/graphics/drawable/ColorDrawable$ColorState;->mBaseColor:I

    .local v1, color:I
    const/4 v2, 0x0

    invoke-virtual {v0, v2, v1}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v1

    iget-object v2, p0, Landroid/graphics/drawable/ColorDrawable;->mState:Landroid/graphics/drawable/ColorDrawable$ColorState;

    iget-object v3, p0, Landroid/graphics/drawable/ColorDrawable;->mState:Landroid/graphics/drawable/ColorDrawable$ColorState;

    iput v1, v3, Landroid/graphics/drawable/ColorDrawable$ColorState;->mUseColor:I

    iput v1, v2, Landroid/graphics/drawable/ColorDrawable$ColorState;->mBaseColor:I

    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    return-void
.end method

.method public setAlpha(I)V
    .registers 8
    .parameter "alpha"

    .prologue
    shr-int/lit8 v3, p1, 0x7

    add-int/2addr p1, v3

    iget-object v3, p0, Landroid/graphics/drawable/ColorDrawable;->mState:Landroid/graphics/drawable/ColorDrawable$ColorState;

    iget v3, v3, Landroid/graphics/drawable/ColorDrawable$ColorState;->mBaseColor:I

    ushr-int/lit8 v0, v3, 0x18

    .local v0, baseAlpha:I
    mul-int v3, v0, p1

    shr-int/lit8 v2, v3, 0x8

    .local v2, useAlpha:I
    iget-object v3, p0, Landroid/graphics/drawable/ColorDrawable;->mState:Landroid/graphics/drawable/ColorDrawable$ColorState;

    iget v1, v3, Landroid/graphics/drawable/ColorDrawable$ColorState;->mUseColor:I

    .local v1, oldUseColor:I
    iget-object v3, p0, Landroid/graphics/drawable/ColorDrawable;->mState:Landroid/graphics/drawable/ColorDrawable$ColorState;

    iget-object v4, p0, Landroid/graphics/drawable/ColorDrawable;->mState:Landroid/graphics/drawable/ColorDrawable$ColorState;

    iget v4, v4, Landroid/graphics/drawable/ColorDrawable$ColorState;->mBaseColor:I

    shl-int/lit8 v4, v4, 0x8

    ushr-int/lit8 v4, v4, 0x8

    shl-int/lit8 v5, v2, 0x18

    or-int/2addr v4, v5

    iput v4, v3, Landroid/graphics/drawable/ColorDrawable$ColorState;->mUseColor:I

    iget-object v3, p0, Landroid/graphics/drawable/ColorDrawable;->mState:Landroid/graphics/drawable/ColorDrawable$ColorState;

    iget v3, v3, Landroid/graphics/drawable/ColorDrawable$ColorState;->mUseColor:I

    if-eq v1, v3, :cond_29

    invoke-virtual {p0}, Landroid/graphics/drawable/ColorDrawable;->invalidateSelf()V

    :cond_29
    return-void
.end method

.method public setColor(I)V
    .registers 4
    .parameter "color"

    .prologue
    iget-object v0, p0, Landroid/graphics/drawable/ColorDrawable;->mState:Landroid/graphics/drawable/ColorDrawable$ColorState;

    iget v0, v0, Landroid/graphics/drawable/ColorDrawable$ColorState;->mBaseColor:I

    if-ne v0, p1, :cond_c

    iget-object v0, p0, Landroid/graphics/drawable/ColorDrawable;->mState:Landroid/graphics/drawable/ColorDrawable$ColorState;

    iget v0, v0, Landroid/graphics/drawable/ColorDrawable$ColorState;->mUseColor:I

    if-eq v0, p1, :cond_17

    :cond_c
    invoke-virtual {p0}, Landroid/graphics/drawable/ColorDrawable;->invalidateSelf()V

    iget-object v0, p0, Landroid/graphics/drawable/ColorDrawable;->mState:Landroid/graphics/drawable/ColorDrawable$ColorState;

    iget-object v1, p0, Landroid/graphics/drawable/ColorDrawable;->mState:Landroid/graphics/drawable/ColorDrawable$ColorState;

    iput p1, v1, Landroid/graphics/drawable/ColorDrawable$ColorState;->mUseColor:I

    iput p1, v0, Landroid/graphics/drawable/ColorDrawable$ColorState;->mBaseColor:I

    :cond_17
    return-void
.end method

.method public setColorFilter(Landroid/graphics/ColorFilter;)V
    .registers 2
    .parameter "colorFilter"

    .prologue
    return-void
.end method
