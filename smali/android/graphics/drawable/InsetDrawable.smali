.class public Landroid/graphics/drawable/InsetDrawable;
.super Landroid/graphics/drawable/Drawable;
.source "InsetDrawable.java"

# interfaces
.implements Landroid/graphics/drawable/Drawable$Callback;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/graphics/drawable/InsetDrawable$1;,
        Landroid/graphics/drawable/InsetDrawable$InsetState;
    }
.end annotation


# instance fields
.field private mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

.field private mMutated:Z

.field private final mTmpRect:Landroid/graphics/Rect;


# direct methods
.method constructor <init>()V
    .registers 2

    .prologue
    const/4 v0, 0x0

    .line 54
    invoke-direct {p0, v0, v0}, Landroid/graphics/drawable/InsetDrawable;-><init>(Landroid/graphics/drawable/InsetDrawable$InsetState;Landroid/content/res/Resources;)V

    .line 55
    return-void
.end method

.method public constructor <init>(Landroid/graphics/drawable/Drawable;I)V
    .registers 9
    .parameter "drawable"
    .parameter "inset"

    .prologue
    .line 58
    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move v3, p2

    move v4, p2

    move v5, p2

    invoke-direct/range {v0 .. v5}, Landroid/graphics/drawable/InsetDrawable;-><init>(Landroid/graphics/drawable/Drawable;IIII)V

    .line 59
    return-void
.end method

.method public constructor <init>(Landroid/graphics/drawable/Drawable;IIII)V
    .registers 7
    .parameter "drawable"
    .parameter "insetLeft"
    .parameter "insetTop"
    .parameter "insetRight"
    .parameter "insetBottom"

    .prologue
    const/4 v0, 0x0

    .line 63
    invoke-direct {p0, v0, v0}, Landroid/graphics/drawable/InsetDrawable;-><init>(Landroid/graphics/drawable/InsetDrawable$InsetState;Landroid/content/res/Resources;)V

    .line 65
    iget-object v0, p0, Landroid/graphics/drawable/InsetDrawable;->mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

    iput-object p1, v0, Landroid/graphics/drawable/InsetDrawable$InsetState;->mDrawable:Landroid/graphics/drawable/Drawable;

    .line 66
    iget-object v0, p0, Landroid/graphics/drawable/InsetDrawable;->mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

    iput p2, v0, Landroid/graphics/drawable/InsetDrawable$InsetState;->mInsetLeft:I

    .line 67
    iget-object v0, p0, Landroid/graphics/drawable/InsetDrawable;->mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

    iput p3, v0, Landroid/graphics/drawable/InsetDrawable$InsetState;->mInsetTop:I

    .line 68
    iget-object v0, p0, Landroid/graphics/drawable/InsetDrawable;->mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

    iput p4, v0, Landroid/graphics/drawable/InsetDrawable$InsetState;->mInsetRight:I

    .line 69
    iget-object v0, p0, Landroid/graphics/drawable/InsetDrawable;->mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

    iput p5, v0, Landroid/graphics/drawable/InsetDrawable$InsetState;->mInsetBottom:I

    .line 71
    if-eqz p1, :cond_1d

    .line 72
    invoke-virtual {p1, p0}, Landroid/graphics/drawable/Drawable;->setCallback(Landroid/graphics/drawable/Drawable$Callback;)V

    .line 74
    :cond_1d
    return-void
.end method

.method private constructor <init>(Landroid/graphics/drawable/InsetDrawable$InsetState;Landroid/content/res/Resources;)V
    .registers 4
    .parameter "state"
    .parameter "res"

    .prologue
    .line 312
    invoke-direct {p0}, Landroid/graphics/drawable/Drawable;-><init>()V

    .line 50
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Landroid/graphics/drawable/InsetDrawable;->mTmpRect:Landroid/graphics/Rect;

    .line 313
    new-instance v0, Landroid/graphics/drawable/InsetDrawable$InsetState;

    invoke-direct {v0, p1, p0, p2}, Landroid/graphics/drawable/InsetDrawable$InsetState;-><init>(Landroid/graphics/drawable/InsetDrawable$InsetState;Landroid/graphics/drawable/InsetDrawable;Landroid/content/res/Resources;)V

    iput-object v0, p0, Landroid/graphics/drawable/InsetDrawable;->mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

    .line 314
    return-void
.end method

.method synthetic constructor <init>(Landroid/graphics/drawable/InsetDrawable$InsetState;Landroid/content/res/Resources;Landroid/graphics/drawable/InsetDrawable$1;)V
    .registers 4
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"

    .prologue
    .line 46
    invoke-direct {p0, p1, p2}, Landroid/graphics/drawable/InsetDrawable;-><init>(Landroid/graphics/drawable/InsetDrawable$InsetState;Landroid/content/res/Resources;)V

    return-void
.end method


# virtual methods
.method public draw(Landroid/graphics/Canvas;)V
    .registers 3
    .parameter "canvas"

    .prologue
    .line 158
    iget-object v0, p0, Landroid/graphics/drawable/InsetDrawable;->mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

    iget-object v0, v0, Landroid/graphics/drawable/InsetDrawable$InsetState;->mDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 159
    return-void
.end method

.method public getChangingConfigurations()I
    .registers 3

    .prologue
    .line 163
    invoke-super {p0}, Landroid/graphics/drawable/Drawable;->getChangingConfigurations()I

    move-result v0

    iget-object v1, p0, Landroid/graphics/drawable/InsetDrawable;->mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

    iget v1, v1, Landroid/graphics/drawable/InsetDrawable$InsetState;->mChangingConfigurations:I

    or-int/2addr v0, v1

    iget-object v1, p0, Landroid/graphics/drawable/InsetDrawable;->mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

    iget-object v1, v1, Landroid/graphics/drawable/InsetDrawable$InsetState;->mDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v1}, Landroid/graphics/drawable/Drawable;->getChangingConfigurations()I

    move-result v1

    or-int/2addr v0, v1

    return v0
.end method

.method public getConstantState()Landroid/graphics/drawable/Drawable$ConstantState;
    .registers 3

    .prologue
    .line 243
    iget-object v0, p0, Landroid/graphics/drawable/InsetDrawable;->mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

    invoke-virtual {v0}, Landroid/graphics/drawable/InsetDrawable$InsetState;->canConstantState()Z

    move-result v0

    if-eqz v0, :cond_13

    .line 244
    iget-object v0, p0, Landroid/graphics/drawable/InsetDrawable;->mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

    invoke-virtual {p0}, Landroid/graphics/drawable/InsetDrawable;->getChangingConfigurations()I

    move-result v1

    iput v1, v0, Landroid/graphics/drawable/InsetDrawable$InsetState;->mChangingConfigurations:I

    .line 245
    iget-object v0, p0, Landroid/graphics/drawable/InsetDrawable;->mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

    .line 247
    :goto_12
    return-object v0

    :cond_13
    const/4 v0, 0x0

    goto :goto_12
.end method

.method public getIntrinsicHeight()I
    .registers 2

    .prologue
    .line 238
    iget-object v0, p0, Landroid/graphics/drawable/InsetDrawable;->mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

    iget-object v0, v0, Landroid/graphics/drawable/InsetDrawable$InsetState;->mDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v0

    return v0
.end method

.method public getIntrinsicWidth()I
    .registers 2

    .prologue
    .line 233
    iget-object v0, p0, Landroid/graphics/drawable/InsetDrawable;->mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

    iget-object v0, v0, Landroid/graphics/drawable/InsetDrawable$InsetState;->mDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v0

    return v0
.end method

.method public getOpacity()I
    .registers 2

    .prologue
    .line 203
    iget-object v0, p0, Landroid/graphics/drawable/InsetDrawable;->mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

    iget-object v0, v0, Landroid/graphics/drawable/InsetDrawable$InsetState;->mDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getOpacity()I

    move-result v0

    return v0
.end method

.method public getPadding(Landroid/graphics/Rect;)Z
    .registers 5
    .parameter "padding"

    .prologue
    .line 170
    iget-object v1, p0, Landroid/graphics/drawable/InsetDrawable;->mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

    iget-object v1, v1, Landroid/graphics/drawable/InsetDrawable$InsetState;->mDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v1, p1}, Landroid/graphics/drawable/Drawable;->getPadding(Landroid/graphics/Rect;)Z

    move-result v0

    .line 172
    .local v0, pad:Z
    iget v1, p1, Landroid/graphics/Rect;->left:I

    iget-object v2, p0, Landroid/graphics/drawable/InsetDrawable;->mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

    iget v2, v2, Landroid/graphics/drawable/InsetDrawable$InsetState;->mInsetLeft:I

    add-int/2addr v1, v2

    iput v1, p1, Landroid/graphics/Rect;->left:I

    .line 173
    iget v1, p1, Landroid/graphics/Rect;->right:I

    iget-object v2, p0, Landroid/graphics/drawable/InsetDrawable;->mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

    iget v2, v2, Landroid/graphics/drawable/InsetDrawable$InsetState;->mInsetRight:I

    add-int/2addr v1, v2

    iput v1, p1, Landroid/graphics/Rect;->right:I

    .line 174
    iget v1, p1, Landroid/graphics/Rect;->top:I

    iget-object v2, p0, Landroid/graphics/drawable/InsetDrawable;->mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

    iget v2, v2, Landroid/graphics/drawable/InsetDrawable$InsetState;->mInsetTop:I

    add-int/2addr v1, v2

    iput v1, p1, Landroid/graphics/Rect;->top:I

    .line 175
    iget v1, p1, Landroid/graphics/Rect;->bottom:I

    iget-object v2, p0, Landroid/graphics/drawable/InsetDrawable;->mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

    iget v2, v2, Landroid/graphics/drawable/InsetDrawable$InsetState;->mInsetBottom:I

    add-int/2addr v1, v2

    iput v1, p1, Landroid/graphics/Rect;->bottom:I

    .line 177
    if-nez v0, :cond_43

    iget-object v1, p0, Landroid/graphics/drawable/InsetDrawable;->mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

    iget v1, v1, Landroid/graphics/drawable/InsetDrawable$InsetState;->mInsetLeft:I

    iget-object v2, p0, Landroid/graphics/drawable/InsetDrawable;->mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

    iget v2, v2, Landroid/graphics/drawable/InsetDrawable$InsetState;->mInsetRight:I

    or-int/2addr v1, v2

    iget-object v2, p0, Landroid/graphics/drawable/InsetDrawable;->mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

    iget v2, v2, Landroid/graphics/drawable/InsetDrawable$InsetState;->mInsetTop:I

    or-int/2addr v1, v2

    iget-object v2, p0, Landroid/graphics/drawable/InsetDrawable;->mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

    iget v2, v2, Landroid/graphics/drawable/InsetDrawable$InsetState;->mInsetBottom:I

    or-int/2addr v1, v2

    if-eqz v1, :cond_45

    .line 179
    :cond_43
    const/4 v1, 0x1

    .line 181
    :goto_44
    return v1

    :cond_45
    const/4 v1, 0x0

    goto :goto_44
.end method

.method public inflate(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;)V
    .registers 16
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
    const/4 v11, 0x4

    const/4 v10, 0x2

    const/4 v9, 0x0

    .line 81
    sget-object v8, Lcom/android/internal/R$styleable;->InsetDrawable:[I

    invoke-virtual {p1, p3, v8}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 84
    .local v0, a:Landroid/content/res/TypedArray;
    invoke-super {p0, p1, p2, v0, v9}, Landroid/graphics/drawable/Drawable;->inflateWithAttributes(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/content/res/TypedArray;I)V

    .line 87
    const/4 v8, 0x1

    invoke-virtual {v0, v8, v9}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v2

    .line 90
    .local v2, drawableRes:I
    invoke-virtual {v0, v10, v9}, Landroid/content/res/TypedArray;->getDimensionPixelOffset(II)I

    move-result v4

    .line 92
    .local v4, inLeft:I
    invoke-virtual {v0, v11, v9}, Landroid/content/res/TypedArray;->getDimensionPixelOffset(II)I

    move-result v6

    .line 94
    .local v6, inTop:I
    const/4 v8, 0x3

    invoke-virtual {v0, v8, v9}, Landroid/content/res/TypedArray;->getDimensionPixelOffset(II)I

    move-result v5

    .line 96
    .local v5, inRight:I
    const/4 v8, 0x5

    invoke-virtual {v0, v8, v9}, Landroid/content/res/TypedArray;->getDimensionPixelOffset(II)I

    move-result v3

    .line 99
    .local v3, inBottom:I
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 102
    if-eqz v2, :cond_4f

    .line 103
    invoke-virtual {p1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    .line 116
    .local v1, dr:Landroid/graphics/drawable/Drawable;
    :goto_2c
    if-nez v1, :cond_35

    .line 117
    const-string v8, "drawable"

    const-string v9, "No drawable specified for <inset>"

    invoke-static {v8, v9}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 120
    :cond_35
    iget-object v8, p0, Landroid/graphics/drawable/InsetDrawable;->mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

    iput-object v1, v8, Landroid/graphics/drawable/InsetDrawable$InsetState;->mDrawable:Landroid/graphics/drawable/Drawable;

    .line 121
    iget-object v8, p0, Landroid/graphics/drawable/InsetDrawable;->mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

    iput v4, v8, Landroid/graphics/drawable/InsetDrawable$InsetState;->mInsetLeft:I

    .line 122
    iget-object v8, p0, Landroid/graphics/drawable/InsetDrawable;->mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

    iput v5, v8, Landroid/graphics/drawable/InsetDrawable$InsetState;->mInsetRight:I

    .line 123
    iget-object v8, p0, Landroid/graphics/drawable/InsetDrawable;->mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

    iput v6, v8, Landroid/graphics/drawable/InsetDrawable$InsetState;->mInsetTop:I

    .line 124
    iget-object v8, p0, Landroid/graphics/drawable/InsetDrawable;->mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

    iput v3, v8, Landroid/graphics/drawable/InsetDrawable$InsetState;->mInsetBottom:I

    .line 126
    if-eqz v1, :cond_4e

    .line 127
    invoke-virtual {v1, p0}, Landroid/graphics/drawable/Drawable;->setCallback(Landroid/graphics/drawable/Drawable$Callback;)V

    .line 129
    :cond_4e
    return-void

    .line 105
    .end local v1           #dr:Landroid/graphics/drawable/Drawable;
    :cond_4f
    invoke-interface {p2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v7

    .local v7, type:I
    if-eq v7, v11, :cond_4f

    .line 107
    if-eq v7, v10, :cond_7a

    .line 108
    new-instance v8, Lorg/xmlpull/v1/XmlPullParserException;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface {p2}, Lorg/xmlpull/v1/XmlPullParser;->getPositionDescription()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, ": <inset> tag requires a \'drawable\' attribute or "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, "child tag defining a drawable"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Lorg/xmlpull/v1/XmlPullParserException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 113
    :cond_7a
    invoke-static {p1, p2, p3}, Landroid/graphics/drawable/Drawable;->createFromXmlInner(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    .restart local v1       #dr:Landroid/graphics/drawable/Drawable;
    goto :goto_2c
.end method

.method public invalidateDrawable(Landroid/graphics/drawable/Drawable;)V
    .registers 3
    .parameter "who"

    .prologue
    .line 134
    invoke-virtual {p0}, Landroid/graphics/drawable/InsetDrawable;->getCallback()Landroid/graphics/drawable/Drawable$Callback;

    move-result-object v0

    .line 135
    .local v0, callback:Landroid/graphics/drawable/Drawable$Callback;
    if-eqz v0, :cond_9

    .line 136
    invoke-interface {v0, p0}, Landroid/graphics/drawable/Drawable$Callback;->invalidateDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 138
    :cond_9
    return-void
.end method

.method public isStateful()Z
    .registers 2

    .prologue
    .line 208
    iget-object v0, p0, Landroid/graphics/drawable/InsetDrawable;->mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

    iget-object v0, v0, Landroid/graphics/drawable/InsetDrawable$InsetState;->mDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->isStateful()Z

    move-result v0

    return v0
.end method

.method public mutate()Landroid/graphics/drawable/Drawable;
    .registers 2

    .prologue
    .line 252
    iget-boolean v0, p0, Landroid/graphics/drawable/InsetDrawable;->mMutated:Z

    if-nez v0, :cond_14

    invoke-super {p0}, Landroid/graphics/drawable/Drawable;->mutate()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    if-ne v0, p0, :cond_14

    .line 253
    iget-object v0, p0, Landroid/graphics/drawable/InsetDrawable;->mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

    iget-object v0, v0, Landroid/graphics/drawable/InsetDrawable$InsetState;->mDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->mutate()Landroid/graphics/drawable/Drawable;

    .line 254
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/graphics/drawable/InsetDrawable;->mMutated:Z

    .line 256
    :cond_14
    return-object p0
.end method

.method protected onBoundsChange(Landroid/graphics/Rect;)V
    .registers 8
    .parameter "bounds"

    .prologue
    .line 220
    iget-object v0, p0, Landroid/graphics/drawable/InsetDrawable;->mTmpRect:Landroid/graphics/Rect;

    .line 221
    .local v0, r:Landroid/graphics/Rect;
    invoke-virtual {v0, p1}, Landroid/graphics/Rect;->set(Landroid/graphics/Rect;)V

    .line 223
    iget v1, v0, Landroid/graphics/Rect;->left:I

    iget-object v2, p0, Landroid/graphics/drawable/InsetDrawable;->mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

    iget v2, v2, Landroid/graphics/drawable/InsetDrawable$InsetState;->mInsetLeft:I

    add-int/2addr v1, v2

    iput v1, v0, Landroid/graphics/Rect;->left:I

    .line 224
    iget v1, v0, Landroid/graphics/Rect;->top:I

    iget-object v2, p0, Landroid/graphics/drawable/InsetDrawable;->mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

    iget v2, v2, Landroid/graphics/drawable/InsetDrawable$InsetState;->mInsetTop:I

    add-int/2addr v1, v2

    iput v1, v0, Landroid/graphics/Rect;->top:I

    .line 225
    iget v1, v0, Landroid/graphics/Rect;->right:I

    iget-object v2, p0, Landroid/graphics/drawable/InsetDrawable;->mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

    iget v2, v2, Landroid/graphics/drawable/InsetDrawable$InsetState;->mInsetRight:I

    sub-int/2addr v1, v2

    iput v1, v0, Landroid/graphics/Rect;->right:I

    .line 226
    iget v1, v0, Landroid/graphics/Rect;->bottom:I

    iget-object v2, p0, Landroid/graphics/drawable/InsetDrawable;->mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

    iget v2, v2, Landroid/graphics/drawable/InsetDrawable$InsetState;->mInsetBottom:I

    sub-int/2addr v1, v2

    iput v1, v0, Landroid/graphics/Rect;->bottom:I

    .line 228
    iget-object v1, p0, Landroid/graphics/drawable/InsetDrawable;->mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

    iget-object v1, v1, Landroid/graphics/drawable/InsetDrawable$InsetState;->mDrawable:Landroid/graphics/drawable/Drawable;

    iget v2, v0, Landroid/graphics/Rect;->left:I

    iget v3, v0, Landroid/graphics/Rect;->top:I

    iget v4, v0, Landroid/graphics/Rect;->right:I

    iget v5, v0, Landroid/graphics/Rect;->bottom:I

    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 229
    return-void
.end method

.method protected onStateChange([I)Z
    .registers 4
    .parameter "state"

    .prologue
    .line 213
    iget-object v1, p0, Landroid/graphics/drawable/InsetDrawable;->mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

    iget-object v1, v1, Landroid/graphics/drawable/InsetDrawable$InsetState;->mDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v1, p1}, Landroid/graphics/drawable/Drawable;->setState([I)Z

    move-result v0

    .line 214
    .local v0, changed:Z
    invoke-virtual {p0}, Landroid/graphics/drawable/InsetDrawable;->getBounds()Landroid/graphics/Rect;

    move-result-object v1

    invoke-virtual {p0, v1}, Landroid/graphics/drawable/InsetDrawable;->onBoundsChange(Landroid/graphics/Rect;)V

    .line 215
    return v0
.end method

.method public scheduleDrawable(Landroid/graphics/drawable/Drawable;Ljava/lang/Runnable;J)V
    .registers 6
    .parameter "who"
    .parameter "what"
    .parameter "when"

    .prologue
    .line 141
    invoke-virtual {p0}, Landroid/graphics/drawable/InsetDrawable;->getCallback()Landroid/graphics/drawable/Drawable$Callback;

    move-result-object v0

    .line 142
    .local v0, callback:Landroid/graphics/drawable/Drawable$Callback;
    if-eqz v0, :cond_9

    .line 143
    invoke-interface {v0, p0, p2, p3, p4}, Landroid/graphics/drawable/Drawable$Callback;->scheduleDrawable(Landroid/graphics/drawable/Drawable;Ljava/lang/Runnable;J)V

    .line 145
    :cond_9
    return-void
.end method

.method public setAlpha(I)V
    .registers 3
    .parameter "alpha"

    .prologue
    .line 193
    iget-object v0, p0, Landroid/graphics/drawable/InsetDrawable;->mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

    iget-object v0, v0, Landroid/graphics/drawable/InsetDrawable$InsetState;->mDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->setAlpha(I)V

    .line 194
    return-void
.end method

.method public setColorFilter(Landroid/graphics/ColorFilter;)V
    .registers 3
    .parameter "cf"

    .prologue
    .line 198
    iget-object v0, p0, Landroid/graphics/drawable/InsetDrawable;->mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

    iget-object v0, v0, Landroid/graphics/drawable/InsetDrawable$InsetState;->mDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->setColorFilter(Landroid/graphics/ColorFilter;)V

    .line 199
    return-void
.end method

.method public setVisible(ZZ)Z
    .registers 4
    .parameter "visible"
    .parameter "restart"

    .prologue
    .line 187
    iget-object v0, p0, Landroid/graphics/drawable/InsetDrawable;->mInsetState:Landroid/graphics/drawable/InsetDrawable$InsetState;

    iget-object v0, v0, Landroid/graphics/drawable/InsetDrawable$InsetState;->mDrawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, p1, p2}, Landroid/graphics/drawable/Drawable;->setVisible(ZZ)Z

    .line 188
    invoke-super {p0, p1, p2}, Landroid/graphics/drawable/Drawable;->setVisible(ZZ)Z

    move-result v0

    return v0
.end method

.method public unscheduleDrawable(Landroid/graphics/drawable/Drawable;Ljava/lang/Runnable;)V
    .registers 4
    .parameter "who"
    .parameter "what"

    .prologue
    .line 148
    invoke-virtual {p0}, Landroid/graphics/drawable/InsetDrawable;->getCallback()Landroid/graphics/drawable/Drawable$Callback;

    move-result-object v0

    .line 149
    .local v0, callback:Landroid/graphics/drawable/Drawable$Callback;
    if-eqz v0, :cond_9

    .line 150
    invoke-interface {v0, p0, p2}, Landroid/graphics/drawable/Drawable$Callback;->unscheduleDrawable(Landroid/graphics/drawable/Drawable;Ljava/lang/Runnable;)V

    .line 152
    :cond_9
    return-void
.end method
