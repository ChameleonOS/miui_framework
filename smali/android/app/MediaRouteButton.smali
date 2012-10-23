.class public Landroid/app/MediaRouteButton;
.super Landroid/view/View;
.source "MediaRouteButton.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/app/MediaRouteButton$MediaRouteCallback;
    }
.end annotation


# static fields
.field private static final ACTIVATED_STATE_SET:[I = null

.field private static final TAG:Ljava/lang/String; = "MediaRouteButton"


# instance fields
.field private mAttachedToWindow:Z

.field private mDialogFragment:Lcom/android/internal/app/MediaRouteChooserDialogFragment;

.field private mExtendedSettingsClickListener:Landroid/view/View$OnClickListener;

.field private mMinHeight:I

.field private mMinWidth:I

.field private mRemoteActive:Z

.field private mRemoteIndicator:Landroid/graphics/drawable/Drawable;

.field private mRouteTypes:I

.field private mRouter:Landroid/media/MediaRouter;

.field private final mRouterCallback:Landroid/app/MediaRouteButton$MediaRouteCallback;

.field private mToggleMode:Z


# direct methods
.method static constructor <clinit>()V
    .registers 3

    .prologue
    .line 54
    const/4 v0, 0x1

    new-array v0, v0, [I

    const/4 v1, 0x0

    const v2, 0x10102fe

    aput v2, v0, v1

    sput-object v0, Landroid/app/MediaRouteButton;->ACTIVATED_STATE_SET:[I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .registers 3
    .parameter "context"

    .prologue
    .line 59
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroid/app/MediaRouteButton;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 60
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 4
    .parameter "context"
    .parameter "attrs"

    .prologue
    .line 63
    const v0, 0x10103ad

    invoke-direct {p0, p1, p2, v0}, Landroid/app/MediaRouteButton;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 64
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .registers 10
    .parameter "context"
    .parameter "attrs"
    .parameter "defStyleAttr"

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 67
    invoke-direct {p0, p1, p2, p3}, Landroid/view/View;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 39
    new-instance v2, Landroid/app/MediaRouteButton$MediaRouteCallback;

    const/4 v3, 0x0

    invoke-direct {v2, p0, v3}, Landroid/app/MediaRouteButton$MediaRouteCallback;-><init>(Landroid/app/MediaRouteButton;Landroid/app/MediaRouteButton$1;)V

    iput-object v2, p0, Landroid/app/MediaRouteButton;->mRouterCallback:Landroid/app/MediaRouteButton$MediaRouteCallback;

    .line 69
    const-string/jumbo v2, "media_router"

    invoke-virtual {p1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/media/MediaRouter;

    iput-object v2, p0, Landroid/app/MediaRouteButton;->mRouter:Landroid/media/MediaRouter;

    .line 71
    sget-object v2, Lcom/android/internal/R$styleable;->MediaRouteButton:[I

    invoke-virtual {p1, p2, v2, p3, v4}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 73
    .local v0, a:Landroid/content/res/TypedArray;
    const/4 v2, 0x3

    invoke-virtual {v0, v2}, Landroid/content/res/TypedArray;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-direct {p0, v2}, Landroid/app/MediaRouteButton;->setRemoteIndicatorDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 75
    invoke-virtual {v0, v4, v4}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v2

    iput v2, p0, Landroid/app/MediaRouteButton;->mMinWidth:I

    .line 77
    invoke-virtual {v0, v5, v4}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v2

    iput v2, p0, Landroid/app/MediaRouteButton;->mMinHeight:I

    .line 79
    const/4 v2, 0x2

    invoke-virtual {v0, v2, v5}, Landroid/content/res/TypedArray;->getInteger(II)I

    move-result v1

    .line 82
    .local v1, routeTypes:I
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 84
    invoke-virtual {p0, v5}, Landroid/app/MediaRouteButton;->setClickable(Z)V

    .line 86
    invoke-virtual {p0, v1}, Landroid/app/MediaRouteButton;->setRouteTypes(I)V

    .line 87
    return-void
.end method

.method static synthetic access$102(Landroid/app/MediaRouteButton;Lcom/android/internal/app/MediaRouteChooserDialogFragment;)Lcom/android/internal/app/MediaRouteChooserDialogFragment;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 35
    iput-object p1, p0, Landroid/app/MediaRouteButton;->mDialogFragment:Lcom/android/internal/app/MediaRouteChooserDialogFragment;

    return-object p1
.end method

.method private getActivity()Landroid/app/Activity;
    .registers 4

    .prologue
    .line 346
    invoke-virtual {p0}, Landroid/app/MediaRouteButton;->getContext()Landroid/content/Context;

    move-result-object v0

    .line 347
    .local v0, context:Landroid/content/Context;
    :goto_4
    instance-of v1, v0, Landroid/content/ContextWrapper;

    if-eqz v1, :cond_13

    instance-of v1, v0, Landroid/app/Activity;

    if-nez v1, :cond_13

    .line 348
    check-cast v0, Landroid/content/ContextWrapper;

    .end local v0           #context:Landroid/content/Context;
    invoke-virtual {v0}, Landroid/content/ContextWrapper;->getBaseContext()Landroid/content/Context;

    move-result-object v0

    .restart local v0       #context:Landroid/content/Context;
    goto :goto_4

    .line 350
    :cond_13
    instance-of v1, v0, Landroid/app/Activity;

    if-nez v1, :cond_1f

    .line 351
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "The MediaRouteButton\'s Context is not an Activity."

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 354
    :cond_1f
    check-cast v0, Landroid/app/Activity;

    .end local v0           #context:Landroid/content/Context;
    return-object v0
.end method

.method private setRemoteIndicatorDrawable(Landroid/graphics/drawable/Drawable;)V
    .registers 5
    .parameter "d"

    .prologue
    const/4 v1, 0x0

    .line 90
    iget-object v0, p0, Landroid/app/MediaRouteButton;->mRemoteIndicator:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_10

    .line 91
    iget-object v0, p0, Landroid/app/MediaRouteButton;->mRemoteIndicator:Landroid/graphics/drawable/Drawable;

    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Landroid/graphics/drawable/Drawable;->setCallback(Landroid/graphics/drawable/Drawable$Callback;)V

    .line 92
    iget-object v0, p0, Landroid/app/MediaRouteButton;->mRemoteIndicator:Landroid/graphics/drawable/Drawable;

    invoke-virtual {p0, v0}, Landroid/app/MediaRouteButton;->unscheduleDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 94
    :cond_10
    iput-object p1, p0, Landroid/app/MediaRouteButton;->mRemoteIndicator:Landroid/graphics/drawable/Drawable;

    .line 95
    if-eqz p1, :cond_28

    .line 96
    invoke-virtual {p1, p0}, Landroid/graphics/drawable/Drawable;->setCallback(Landroid/graphics/drawable/Drawable$Callback;)V

    .line 97
    invoke-virtual {p0}, Landroid/app/MediaRouteButton;->getDrawableState()[I

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/graphics/drawable/Drawable;->setState([I)Z

    .line 98
    invoke-virtual {p0}, Landroid/app/MediaRouteButton;->getVisibility()I

    move-result v0

    if-nez v0, :cond_2c

    const/4 v0, 0x1

    :goto_25
    invoke-virtual {p1, v0, v1}, Landroid/graphics/drawable/Drawable;->setVisible(ZZ)Z

    .line 101
    :cond_28
    invoke-virtual {p0}, Landroid/app/MediaRouteButton;->refreshDrawableState()V

    .line 102
    return-void

    :cond_2c
    move v0, v1

    .line 98
    goto :goto_25
.end method

.method private updateRouteInfo()V
    .registers 1

    .prologue
    .line 151
    invoke-virtual {p0}, Landroid/app/MediaRouteButton;->updateRemoteIndicator()V

    .line 152
    invoke-virtual {p0}, Landroid/app/MediaRouteButton;->updateRouteCount()V

    .line 153
    return-void
.end method


# virtual methods
.method protected drawableStateChanged()V
    .registers 3

    .prologue
    .line 199
    invoke-super {p0}, Landroid/view/View;->drawableStateChanged()V

    .line 201
    iget-object v1, p0, Landroid/app/MediaRouteButton;->mRemoteIndicator:Landroid/graphics/drawable/Drawable;

    if-eqz v1, :cond_13

    .line 202
    invoke-virtual {p0}, Landroid/app/MediaRouteButton;->getDrawableState()[I

    move-result-object v0

    .line 203
    .local v0, myDrawableState:[I
    iget-object v1, p0, Landroid/app/MediaRouteButton;->mRemoteIndicator:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v1, v0}, Landroid/graphics/drawable/Drawable;->setState([I)Z

    .line 204
    invoke-virtual {p0}, Landroid/app/MediaRouteButton;->invalidate()V

    .line 206
    .end local v0           #myDrawableState:[I
    :cond_13
    return-void
.end method

.method public getRouteTypes()I
    .registers 2

    .prologue
    .line 156
    iget v0, p0, Landroid/app/MediaRouteButton;->mRouteTypes:I

    return v0
.end method

.method public jumpDrawablesToCurrentState()V
    .registers 2

    .prologue
    .line 215
    invoke-super {p0}, Landroid/view/View;->jumpDrawablesToCurrentState()V

    .line 216
    iget-object v0, p0, Landroid/app/MediaRouteButton;->mRemoteIndicator:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_c

    iget-object v0, p0, Landroid/app/MediaRouteButton;->mRemoteIndicator:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->jumpToCurrentState()V

    .line 217
    :cond_c
    return-void
.end method

.method public onAttachedToWindow()V
    .registers 4

    .prologue
    .line 229
    invoke-super {p0}, Landroid/view/View;->onAttachedToWindow()V

    .line 230
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/app/MediaRouteButton;->mAttachedToWindow:Z

    .line 231
    iget v0, p0, Landroid/app/MediaRouteButton;->mRouteTypes:I

    if-eqz v0, :cond_16

    .line 232
    iget-object v0, p0, Landroid/app/MediaRouteButton;->mRouter:Landroid/media/MediaRouter;

    iget v1, p0, Landroid/app/MediaRouteButton;->mRouteTypes:I

    iget-object v2, p0, Landroid/app/MediaRouteButton;->mRouterCallback:Landroid/app/MediaRouteButton$MediaRouteCallback;

    invoke-virtual {v0, v1, v2}, Landroid/media/MediaRouter;->addCallback(ILandroid/media/MediaRouter$Callback;)V

    .line 233
    invoke-direct {p0}, Landroid/app/MediaRouteButton;->updateRouteInfo()V

    .line 235
    :cond_16
    return-void
.end method

.method protected onCreateDrawableState(I)[I
    .registers 4
    .parameter "extraSpace"

    .prologue
    .line 190
    add-int/lit8 v1, p1, 0x1

    invoke-super {p0, v1}, Landroid/view/View;->onCreateDrawableState(I)[I

    move-result-object v0

    .line 191
    .local v0, drawableState:[I
    iget-boolean v1, p0, Landroid/app/MediaRouteButton;->mRemoteActive:Z

    if-eqz v1, :cond_f

    .line 192
    sget-object v1, Landroid/app/MediaRouteButton;->ACTIVATED_STATE_SET:[I

    invoke-static {v0, v1}, Landroid/app/MediaRouteButton;->mergeDrawableStates([I[I)[I

    .line 194
    :cond_f
    return-object v0
.end method

.method public onDetachedFromWindow()V
    .registers 3

    .prologue
    .line 239
    iget v0, p0, Landroid/app/MediaRouteButton;->mRouteTypes:I

    if-eqz v0, :cond_b

    .line 240
    iget-object v0, p0, Landroid/app/MediaRouteButton;->mRouter:Landroid/media/MediaRouter;

    iget-object v1, p0, Landroid/app/MediaRouteButton;->mRouterCallback:Landroid/app/MediaRouteButton$MediaRouteCallback;

    invoke-virtual {v0, v1}, Landroid/media/MediaRouter;->removeCallback(Landroid/media/MediaRouter$Callback;)V

    .line 242
    :cond_b
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/app/MediaRouteButton;->mAttachedToWindow:Z

    .line 243
    invoke-super {p0}, Landroid/view/View;->onDetachedFromWindow()V

    .line 244
    return-void
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .registers 13
    .parameter "canvas"

    .prologue
    .line 291
    invoke-super {p0, p1}, Landroid/view/View;->onDraw(Landroid/graphics/Canvas;)V

    .line 293
    iget-object v8, p0, Landroid/app/MediaRouteButton;->mRemoteIndicator:Landroid/graphics/drawable/Drawable;

    if-nez v8, :cond_8

    .line 307
    :goto_7
    return-void

    .line 295
    :cond_8
    invoke-virtual {p0}, Landroid/app/MediaRouteButton;->getPaddingLeft()I

    move-result v5

    .line 296
    .local v5, left:I
    invoke-virtual {p0}, Landroid/app/MediaRouteButton;->getWidth()I

    move-result v8

    invoke-virtual {p0}, Landroid/app/MediaRouteButton;->getPaddingRight()I

    move-result v9

    sub-int v6, v8, v9

    .line 297
    .local v6, right:I
    invoke-virtual {p0}, Landroid/app/MediaRouteButton;->getPaddingTop()I

    move-result v7

    .line 298
    .local v7, top:I
    invoke-virtual {p0}, Landroid/app/MediaRouteButton;->getHeight()I

    move-result v8

    invoke-virtual {p0}, Landroid/app/MediaRouteButton;->getPaddingBottom()I

    move-result v9

    sub-int v0, v8, v9

    .line 300
    .local v0, bottom:I
    iget-object v8, p0, Landroid/app/MediaRouteButton;->mRemoteIndicator:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v8}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v4

    .line 301
    .local v4, drawWidth:I
    iget-object v8, p0, Landroid/app/MediaRouteButton;->mRemoteIndicator:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v8}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v1

    .line 302
    .local v1, drawHeight:I
    sub-int v8, v6, v5

    sub-int/2addr v8, v4

    div-int/lit8 v8, v8, 0x2

    add-int v2, v5, v8

    .line 303
    .local v2, drawLeft:I
    sub-int v8, v0, v7

    sub-int/2addr v8, v1

    div-int/lit8 v8, v8, 0x2

    add-int v3, v7, v8

    .line 305
    .local v3, drawTop:I
    iget-object v8, p0, Landroid/app/MediaRouteButton;->mRemoteIndicator:Landroid/graphics/drawable/Drawable;

    add-int v9, v2, v4

    add-int v10, v3, v1

    invoke-virtual {v8, v2, v3, v9, v10}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 306
    iget-object v8, p0, Landroid/app/MediaRouteButton;->mRemoteIndicator:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v8, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    goto :goto_7
.end method

.method protected onMeasure(II)V
    .registers 14
    .parameter "widthMeasureSpec"
    .parameter "heightMeasureSpec"

    .prologue
    const/4 v9, 0x0

    .line 248
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v7

    .line 249
    .local v7, widthSize:I
    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v2

    .line 250
    .local v2, heightSize:I
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v6

    .line 251
    .local v6, widthMode:I
    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v1

    .line 253
    .local v1, heightMode:I
    iget v10, p0, Landroid/app/MediaRouteButton;->mMinWidth:I

    iget-object v8, p0, Landroid/app/MediaRouteButton;->mRemoteIndicator:Landroid/graphics/drawable/Drawable;

    if-eqz v8, :cond_51

    iget-object v8, p0, Landroid/app/MediaRouteButton;->mRemoteIndicator:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v8}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v8

    :goto_1d
    invoke-static {v10, v8}, Ljava/lang/Math;->max(II)I

    move-result v4

    .line 255
    .local v4, minWidth:I
    iget v8, p0, Landroid/app/MediaRouteButton;->mMinHeight:I

    iget-object v10, p0, Landroid/app/MediaRouteButton;->mRemoteIndicator:Landroid/graphics/drawable/Drawable;

    if-eqz v10, :cond_2d

    iget-object v9, p0, Landroid/app/MediaRouteButton;->mRemoteIndicator:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v9}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v9

    :cond_2d
    invoke-static {v8, v9}, Ljava/lang/Math;->max(II)I

    move-result v3

    .line 259
    .local v3, minHeight:I
    sparse-switch v6, :sswitch_data_76

    .line 268
    invoke-virtual {p0}, Landroid/app/MediaRouteButton;->getPaddingLeft()I

    move-result v8

    add-int/2addr v8, v4

    invoke-virtual {p0}, Landroid/app/MediaRouteButton;->getPaddingRight()I

    move-result v9

    add-int v5, v8, v9

    .line 273
    .local v5, width:I
    :goto_3f
    sparse-switch v1, :sswitch_data_80

    .line 282
    invoke-virtual {p0}, Landroid/app/MediaRouteButton;->getPaddingTop()I

    move-result v8

    add-int/2addr v8, v3

    invoke-virtual {p0}, Landroid/app/MediaRouteButton;->getPaddingBottom()I

    move-result v9

    add-int v0, v8, v9

    .line 286
    .local v0, height:I
    :goto_4d
    invoke-virtual {p0, v5, v0}, Landroid/app/MediaRouteButton;->setMeasuredDimension(II)V

    .line 287
    return-void

    .end local v0           #height:I
    .end local v3           #minHeight:I
    .end local v4           #minWidth:I
    .end local v5           #width:I
    :cond_51
    move v8, v9

    .line 253
    goto :goto_1d

    .line 261
    .restart local v3       #minHeight:I
    .restart local v4       #minWidth:I
    :sswitch_53
    move v5, v7

    .line 262
    .restart local v5       #width:I
    goto :goto_3f

    .line 264
    .end local v5           #width:I
    :sswitch_55
    invoke-virtual {p0}, Landroid/app/MediaRouteButton;->getPaddingLeft()I

    move-result v8

    add-int/2addr v8, v4

    invoke-virtual {p0}, Landroid/app/MediaRouteButton;->getPaddingRight()I

    move-result v9

    add-int/2addr v8, v9

    invoke-static {v7, v8}, Ljava/lang/Math;->min(II)I

    move-result v5

    .line 265
    .restart local v5       #width:I
    goto :goto_3f

    .line 275
    :sswitch_64
    move v0, v2

    .line 276
    .restart local v0       #height:I
    goto :goto_4d

    .line 278
    .end local v0           #height:I
    :sswitch_66
    invoke-virtual {p0}, Landroid/app/MediaRouteButton;->getPaddingTop()I

    move-result v8

    add-int/2addr v8, v3

    invoke-virtual {p0}, Landroid/app/MediaRouteButton;->getPaddingBottom()I

    move-result v9

    add-int/2addr v8, v9

    invoke-static {v2, v8}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 279
    .restart local v0       #height:I
    goto :goto_4d

    .line 259
    nop

    :sswitch_data_76
    .sparse-switch
        -0x80000000 -> :sswitch_55
        0x40000000 -> :sswitch_53
    .end sparse-switch

    .line 273
    :sswitch_data_80
    .sparse-switch
        -0x80000000 -> :sswitch_66
        0x40000000 -> :sswitch_64
    .end sparse-switch
.end method

.method public performClick()Z
    .registers 8

    .prologue
    .line 107
    invoke-super {p0}, Landroid/view/View;->performClick()Z

    move-result v1

    .line 108
    .local v1, handled:Z
    if-nez v1, :cond_a

    .line 109
    const/4 v4, 0x0

    invoke-virtual {p0, v4}, Landroid/app/MediaRouteButton;->playSoundEffect(I)V

    .line 112
    :cond_a
    iget-boolean v4, p0, Landroid/app/MediaRouteButton;->mToggleMode:Z

    if-eqz v4, :cond_4a

    .line 113
    iget-boolean v4, p0, Landroid/app/MediaRouteButton;->mRemoteActive:Z

    if-eqz v4, :cond_20

    .line 114
    iget-object v4, p0, Landroid/app/MediaRouteButton;->mRouter:Landroid/media/MediaRouter;

    iget v5, p0, Landroid/app/MediaRouteButton;->mRouteTypes:I

    iget-object v6, p0, Landroid/app/MediaRouteButton;->mRouter:Landroid/media/MediaRouter;

    invoke-virtual {v6}, Landroid/media/MediaRouter;->getSystemAudioRoute()Landroid/media/MediaRouter$RouteInfo;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Landroid/media/MediaRouter;->selectRouteInt(ILandroid/media/MediaRouter$RouteInfo;)V

    .line 129
    :cond_1f
    :goto_1f
    return v1

    .line 116
    :cond_20
    iget-object v4, p0, Landroid/app/MediaRouteButton;->mRouter:Landroid/media/MediaRouter;

    invoke-virtual {v4}, Landroid/media/MediaRouter;->getRouteCount()I

    move-result v0

    .line 117
    .local v0, N:I
    const/4 v2, 0x0

    .local v2, i:I
    :goto_27
    if-ge v2, v0, :cond_1f

    .line 118
    iget-object v4, p0, Landroid/app/MediaRouteButton;->mRouter:Landroid/media/MediaRouter;

    invoke-virtual {v4, v2}, Landroid/media/MediaRouter;->getRouteAt(I)Landroid/media/MediaRouter$RouteInfo;

    move-result-object v3

    .line 119
    .local v3, route:Landroid/media/MediaRouter$RouteInfo;
    invoke-virtual {v3}, Landroid/media/MediaRouter$RouteInfo;->getSupportedTypes()I

    move-result v4

    iget v5, p0, Landroid/app/MediaRouteButton;->mRouteTypes:I

    and-int/2addr v4, v5

    if-eqz v4, :cond_47

    iget-object v4, p0, Landroid/app/MediaRouteButton;->mRouter:Landroid/media/MediaRouter;

    invoke-virtual {v4}, Landroid/media/MediaRouter;->getSystemAudioRoute()Landroid/media/MediaRouter$RouteInfo;

    move-result-object v4

    if-eq v3, v4, :cond_47

    .line 121
    iget-object v4, p0, Landroid/app/MediaRouteButton;->mRouter:Landroid/media/MediaRouter;

    iget v5, p0, Landroid/app/MediaRouteButton;->mRouteTypes:I

    invoke-virtual {v4, v5, v3}, Landroid/media/MediaRouter;->selectRouteInt(ILandroid/media/MediaRouter$RouteInfo;)V

    .line 117
    :cond_47
    add-int/lit8 v2, v2, 0x1

    goto :goto_27

    .line 126
    .end local v0           #N:I
    .end local v2           #i:I
    .end local v3           #route:Landroid/media/MediaRouter$RouteInfo;
    :cond_4a
    invoke-virtual {p0}, Landroid/app/MediaRouteButton;->showDialog()V

    goto :goto_1f
.end method

.method public setExtendedSettingsClickListener(Landroid/view/View$OnClickListener;)V
    .registers 3
    .parameter "listener"

    .prologue
    .line 310
    iput-object p1, p0, Landroid/app/MediaRouteButton;->mExtendedSettingsClickListener:Landroid/view/View$OnClickListener;

    .line 311
    iget-object v0, p0, Landroid/app/MediaRouteButton;->mDialogFragment:Lcom/android/internal/app/MediaRouteChooserDialogFragment;

    if-eqz v0, :cond_b

    .line 312
    iget-object v0, p0, Landroid/app/MediaRouteButton;->mDialogFragment:Lcom/android/internal/app/MediaRouteChooserDialogFragment;

    invoke-virtual {v0, p1}, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->setExtendedSettingsClickListener(Landroid/view/View$OnClickListener;)V

    .line 314
    :cond_b
    return-void
.end method

.method public setRouteTypes(I)V
    .registers 4
    .parameter "types"

    .prologue
    .line 133
    iget v0, p0, Landroid/app/MediaRouteButton;->mRouteTypes:I

    if-ne p1, v0, :cond_5

    .line 148
    :cond_4
    :goto_4
    return-void

    .line 138
    :cond_5
    iget-boolean v0, p0, Landroid/app/MediaRouteButton;->mAttachedToWindow:Z

    if-eqz v0, :cond_14

    iget v0, p0, Landroid/app/MediaRouteButton;->mRouteTypes:I

    if-eqz v0, :cond_14

    .line 139
    iget-object v0, p0, Landroid/app/MediaRouteButton;->mRouter:Landroid/media/MediaRouter;

    iget-object v1, p0, Landroid/app/MediaRouteButton;->mRouterCallback:Landroid/app/MediaRouteButton$MediaRouteCallback;

    invoke-virtual {v0, v1}, Landroid/media/MediaRouter;->removeCallback(Landroid/media/MediaRouter$Callback;)V

    .line 142
    :cond_14
    iput p1, p0, Landroid/app/MediaRouteButton;->mRouteTypes:I

    .line 144
    iget-boolean v0, p0, Landroid/app/MediaRouteButton;->mAttachedToWindow:Z

    if-eqz v0, :cond_4

    .line 145
    invoke-direct {p0}, Landroid/app/MediaRouteButton;->updateRouteInfo()V

    .line 146
    iget-object v0, p0, Landroid/app/MediaRouteButton;->mRouter:Landroid/media/MediaRouter;

    iget-object v1, p0, Landroid/app/MediaRouteButton;->mRouterCallback:Landroid/app/MediaRouteButton$MediaRouteCallback;

    invoke-virtual {v0, p1, v1}, Landroid/media/MediaRouter;->addCallback(ILandroid/media/MediaRouter$Callback;)V

    goto :goto_4
.end method

.method public setVisibility(I)V
    .registers 5
    .parameter "visibility"

    .prologue
    const/4 v1, 0x0

    .line 221
    invoke-super {p0, p1}, Landroid/view/View;->setVisibility(I)V

    .line 222
    iget-object v0, p0, Landroid/app/MediaRouteButton;->mRemoteIndicator:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_14

    .line 223
    iget-object v2, p0, Landroid/app/MediaRouteButton;->mRemoteIndicator:Landroid/graphics/drawable/Drawable;

    invoke-virtual {p0}, Landroid/app/MediaRouteButton;->getVisibility()I

    move-result v0

    if-nez v0, :cond_15

    const/4 v0, 0x1

    :goto_11
    invoke-virtual {v2, v0, v1}, Landroid/graphics/drawable/Drawable;->setVisible(ZZ)Z

    .line 225
    :cond_14
    return-void

    :cond_15
    move v0, v1

    .line 223
    goto :goto_11
.end method

.method public showDialog()V
    .registers 4

    .prologue
    .line 321
    invoke-direct {p0}, Landroid/app/MediaRouteButton;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Activity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    .line 322
    .local v0, fm:Landroid/app/FragmentManager;
    iget-object v1, p0, Landroid/app/MediaRouteButton;->mDialogFragment:Lcom/android/internal/app/MediaRouteChooserDialogFragment;

    if-nez v1, :cond_16

    .line 324
    const-string v1, "android:MediaRouteChooserDialogFragment"

    invoke-virtual {v0, v1}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v1

    check-cast v1, Lcom/android/internal/app/MediaRouteChooserDialogFragment;

    iput-object v1, p0, Landroid/app/MediaRouteButton;->mDialogFragment:Lcom/android/internal/app/MediaRouteChooserDialogFragment;

    .line 327
    :cond_16
    iget-object v1, p0, Landroid/app/MediaRouteButton;->mDialogFragment:Lcom/android/internal/app/MediaRouteChooserDialogFragment;

    if-eqz v1, :cond_23

    .line 328
    const-string v1, "MediaRouteButton"

    const-string/jumbo v2, "showDialog(): Already showing!"

    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 342
    :goto_22
    return-void

    .line 332
    :cond_23
    new-instance v1, Lcom/android/internal/app/MediaRouteChooserDialogFragment;

    invoke-direct {v1}, Lcom/android/internal/app/MediaRouteChooserDialogFragment;-><init>()V

    iput-object v1, p0, Landroid/app/MediaRouteButton;->mDialogFragment:Lcom/android/internal/app/MediaRouteChooserDialogFragment;

    .line 333
    iget-object v1, p0, Landroid/app/MediaRouteButton;->mDialogFragment:Lcom/android/internal/app/MediaRouteChooserDialogFragment;

    iget-object v2, p0, Landroid/app/MediaRouteButton;->mExtendedSettingsClickListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->setExtendedSettingsClickListener(Landroid/view/View$OnClickListener;)V

    .line 334
    iget-object v1, p0, Landroid/app/MediaRouteButton;->mDialogFragment:Lcom/android/internal/app/MediaRouteChooserDialogFragment;

    new-instance v2, Landroid/app/MediaRouteButton$1;

    invoke-direct {v2, p0}, Landroid/app/MediaRouteButton$1;-><init>(Landroid/app/MediaRouteButton;)V

    invoke-virtual {v1, v2}, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->setLauncherListener(Lcom/android/internal/app/MediaRouteChooserDialogFragment$LauncherListener;)V

    .line 340
    iget-object v1, p0, Landroid/app/MediaRouteButton;->mDialogFragment:Lcom/android/internal/app/MediaRouteChooserDialogFragment;

    iget v2, p0, Landroid/app/MediaRouteButton;->mRouteTypes:I

    invoke-virtual {v1, v2}, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->setRouteTypes(I)V

    .line 341
    iget-object v1, p0, Landroid/app/MediaRouteButton;->mDialogFragment:Lcom/android/internal/app/MediaRouteChooserDialogFragment;

    const-string v2, "android:MediaRouteChooserDialogFragment"

    invoke-virtual {v1, v0, v2}, Lcom/android/internal/app/MediaRouteChooserDialogFragment;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    goto :goto_22
.end method

.method updateRemoteIndicator()V
    .registers 4

    .prologue
    .line 160
    iget-object v1, p0, Landroid/app/MediaRouteButton;->mRouter:Landroid/media/MediaRouter;

    iget v2, p0, Landroid/app/MediaRouteButton;->mRouteTypes:I

    invoke-virtual {v1, v2}, Landroid/media/MediaRouter;->getSelectedRoute(I)Landroid/media/MediaRouter$RouteInfo;

    move-result-object v1

    iget-object v2, p0, Landroid/app/MediaRouteButton;->mRouter:Landroid/media/MediaRouter;

    invoke-virtual {v2}, Landroid/media/MediaRouter;->getSystemAudioRoute()Landroid/media/MediaRouter$RouteInfo;

    move-result-object v2

    if-eq v1, v2, :cond_1b

    const/4 v0, 0x1

    .line 162
    .local v0, isRemote:Z
    :goto_11
    iget-boolean v1, p0, Landroid/app/MediaRouteButton;->mRemoteActive:Z

    if-eq v1, v0, :cond_1a

    .line 163
    iput-boolean v0, p0, Landroid/app/MediaRouteButton;->mRemoteActive:Z

    .line 164
    invoke-virtual {p0}, Landroid/app/MediaRouteButton;->refreshDrawableState()V

    .line 166
    :cond_1a
    return-void

    .line 160
    .end local v0           #isRemote:Z
    :cond_1b
    const/4 v0, 0x0

    goto :goto_11
.end method

.method updateRouteCount()V
    .registers 9

    .prologue
    const/4 v5, 0x1

    const/4 v6, 0x0

    .line 169
    iget-object v4, p0, Landroid/app/MediaRouteButton;->mRouter:Landroid/media/MediaRouter;

    invoke-virtual {v4}, Landroid/media/MediaRouter;->getRouteCount()I

    move-result v0

    .line 170
    .local v0, N:I
    const/4 v1, 0x0

    .line 171
    .local v1, count:I
    const/4 v2, 0x0

    .local v2, i:I
    :goto_a
    if-ge v2, v0, :cond_2c

    .line 172
    iget-object v4, p0, Landroid/app/MediaRouteButton;->mRouter:Landroid/media/MediaRouter;

    invoke-virtual {v4, v2}, Landroid/media/MediaRouter;->getRouteAt(I)Landroid/media/MediaRouter$RouteInfo;

    move-result-object v3

    .line 173
    .local v3, route:Landroid/media/MediaRouter$RouteInfo;
    invoke-virtual {v3}, Landroid/media/MediaRouter$RouteInfo;->getSupportedTypes()I

    move-result v4

    iget v7, p0, Landroid/app/MediaRouteButton;->mRouteTypes:I

    and-int/2addr v4, v7

    if-eqz v4, :cond_26

    .line 174
    instance-of v4, v3, Landroid/media/MediaRouter$RouteGroup;

    if-eqz v4, :cond_29

    .line 175
    check-cast v3, Landroid/media/MediaRouter$RouteGroup;

    .end local v3           #route:Landroid/media/MediaRouter$RouteInfo;
    invoke-virtual {v3}, Landroid/media/MediaRouter$RouteGroup;->getRouteCount()I

    move-result v4

    add-int/2addr v1, v4

    .line 171
    :cond_26
    :goto_26
    add-int/lit8 v2, v2, 0x1

    goto :goto_a

    .line 177
    .restart local v3       #route:Landroid/media/MediaRouter$RouteInfo;
    :cond_29
    add-int/lit8 v1, v1, 0x1

    goto :goto_26

    .line 182
    .end local v3           #route:Landroid/media/MediaRouter$RouteInfo;
    :cond_2c
    if-eqz v1, :cond_3e

    move v4, v5

    :goto_2f
    invoke-virtual {p0, v4}, Landroid/app/MediaRouteButton;->setEnabled(Z)V

    .line 185
    const/4 v4, 0x2

    if-ne v1, v4, :cond_40

    iget v4, p0, Landroid/app/MediaRouteButton;->mRouteTypes:I

    and-int/lit8 v4, v4, 0x1

    if-eqz v4, :cond_40

    :goto_3b
    iput-boolean v5, p0, Landroid/app/MediaRouteButton;->mToggleMode:Z

    .line 186
    return-void

    :cond_3e
    move v4, v6

    .line 182
    goto :goto_2f

    :cond_40
    move v5, v6

    .line 185
    goto :goto_3b
.end method

.method protected verifyDrawable(Landroid/graphics/drawable/Drawable;)Z
    .registers 3
    .parameter "who"

    .prologue
    .line 210
    invoke-super {p0, p1}, Landroid/view/View;->verifyDrawable(Landroid/graphics/drawable/Drawable;)Z

    move-result v0

    if-nez v0, :cond_a

    iget-object v0, p0, Landroid/app/MediaRouteButton;->mRemoteIndicator:Landroid/graphics/drawable/Drawable;

    if-ne p1, v0, :cond_c

    :cond_a
    const/4 v0, 0x1

    :goto_b
    return v0

    :cond_c
    const/4 v0, 0x0

    goto :goto_b
.end method
