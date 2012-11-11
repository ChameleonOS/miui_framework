.class public abstract Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;
.super Landroid/graphics/drawable/Drawable$ConstantState;
.source "DrawableContainer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/graphics/drawable/DrawableContainer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "DrawableContainerState"
.end annotation


# instance fields
.field mCanConstantState:Z

.field mChangingConfigurations:I

.field mCheckedConstantState:Z

.field mChildrenChangingConfigurations:I

.field mComputedConstantSize:Z

.field mConstantHeight:I

.field mConstantMinimumHeight:I

.field mConstantMinimumWidth:I

.field mConstantPadding:Landroid/graphics/Rect;

.field mConstantSize:Z

.field mConstantWidth:I

.field mDither:Z

.field mDrawables:[Landroid/graphics/drawable/Drawable;

.field mEnterFadeDuration:I

.field mExitFadeDuration:I

.field mHaveOpacity:Z

.field mHaveStateful:Z

.field mNumChildren:I

.field mOpacity:I

.field final mOwner:Landroid/graphics/drawable/DrawableContainer;

.field mPaddingChecked:Z

.field mStateful:Z

.field mVariablePadding:Z


# direct methods
.method constructor <init>(Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;Landroid/graphics/drawable/DrawableContainer;Landroid/content/res/Resources;)V
    .registers 10
    .parameter "orig"
    .parameter "owner"
    .parameter "res"
    .annotation build Landroid/annotation/MiuiHook;
        value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->CHANGE_CODE:Landroid/annotation/MiuiHook$MiuiHookType;
    .end annotation

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    invoke-direct {p0}, Landroid/graphics/drawable/Drawable$ConstantState;-><init>()V

    iput-boolean v4, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mVariablePadding:Z

    const/4 v3, 0x0

    iput-object v3, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mConstantPadding:Landroid/graphics/Rect;

    iput-boolean v4, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mConstantSize:Z

    iput-boolean v4, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mComputedConstantSize:Z

    iput-boolean v4, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mHaveOpacity:Z

    iput-boolean v4, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mHaveStateful:Z

    iput-boolean v4, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mPaddingChecked:Z

    iput-boolean v5, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mDither:Z

    iput-object p2, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mOwner:Landroid/graphics/drawable/DrawableContainer;

    if-eqz p1, :cond_a5

    iget v3, p1, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mChangingConfigurations:I

    iput v3, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mChangingConfigurations:I

    iget v3, p1, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mChildrenChangingConfigurations:I

    iput v3, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mChildrenChangingConfigurations:I

    iget-object v2, p1, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mDrawables:[Landroid/graphics/drawable/Drawable;

    .local v2, origDr:[Landroid/graphics/drawable/Drawable;
    array-length v3, v2

    new-array v3, v3, [Landroid/graphics/drawable/Drawable;

    iput-object v3, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mDrawables:[Landroid/graphics/drawable/Drawable;

    iget v3, p1, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mNumChildren:I

    iput v3, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mNumChildren:I

    iget v0, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mNumChildren:I

    .local v0, N:I
    const/4 v1, 0x0

    .local v1, i:I
    :goto_30
    if-ge v1, v0, :cond_5b

    if-eqz p3, :cond_4c

    iget-object v3, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mDrawables:[Landroid/graphics/drawable/Drawable;

    aget-object v4, v2, v1

    invoke-virtual {v4}, Landroid/graphics/drawable/Drawable;->getConstantState()Landroid/graphics/drawable/Drawable$ConstantState;

    move-result-object v4

    invoke-virtual {v4, p3}, Landroid/graphics/drawable/Drawable$ConstantState;->newDrawable(Landroid/content/res/Resources;)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    aput-object v4, v3, v1

    :goto_42
    iget-object v3, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mDrawables:[Landroid/graphics/drawable/Drawable;

    aget-object v3, v3, v1

    invoke-virtual {v3, p2}, Landroid/graphics/drawable/Drawable;->setCallback(Landroid/graphics/drawable/Drawable$Callback;)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_30

    :cond_4c
    iget-object v3, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mDrawables:[Landroid/graphics/drawable/Drawable;

    aget-object v4, v2, v1

    invoke-virtual {v4}, Landroid/graphics/drawable/Drawable;->getConstantState()Landroid/graphics/drawable/Drawable$ConstantState;

    move-result-object v4

    invoke-virtual {v4}, Landroid/graphics/drawable/Drawable$ConstantState;->newDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    aput-object v4, v3, v1

    goto :goto_42

    :cond_5b
    iput-boolean v5, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mCanConstantState:Z

    iput-boolean v5, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mCheckedConstantState:Z

    iget-boolean v3, p1, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mVariablePadding:Z

    iput-boolean v3, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mVariablePadding:Z

    iget-object v3, p1, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mConstantPadding:Landroid/graphics/Rect;

    if-eqz v3, :cond_70

    new-instance v3, Landroid/graphics/Rect;

    iget-object v4, p1, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mConstantPadding:Landroid/graphics/Rect;

    invoke-direct {v3, v4}, Landroid/graphics/Rect;-><init>(Landroid/graphics/Rect;)V

    iput-object v3, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mConstantPadding:Landroid/graphics/Rect;

    :cond_70
    iget-boolean v3, p1, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mConstantSize:Z

    iput-boolean v3, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mConstantSize:Z

    iget-boolean v3, p1, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mComputedConstantSize:Z

    iput-boolean v3, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mComputedConstantSize:Z

    iget v3, p1, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mConstantWidth:I

    iput v3, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mConstantWidth:I

    iget v3, p1, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mConstantHeight:I

    iput v3, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mConstantHeight:I

    iget v3, p1, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mConstantMinimumWidth:I

    iput v3, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mConstantMinimumWidth:I

    iget v3, p1, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mConstantMinimumHeight:I

    iput v3, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mConstantMinimumHeight:I

    iget-boolean v3, p1, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mHaveOpacity:Z

    iput-boolean v3, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mHaveOpacity:Z

    iget v3, p1, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mOpacity:I

    iput v3, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mOpacity:I

    iget-boolean v3, p1, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mHaveStateful:Z

    iput-boolean v3, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mHaveStateful:Z

    iget-boolean v3, p1, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mStateful:Z

    iput-boolean v3, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mStateful:Z

    iget-boolean v3, p1, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mDither:Z

    iput-boolean v3, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mDither:Z

    iget v3, p1, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mEnterFadeDuration:I

    iput v3, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mEnterFadeDuration:I

    iget v3, p1, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mExitFadeDuration:I

    iput v3, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mExitFadeDuration:I

    .end local v0           #N:I
    .end local v1           #i:I
    .end local v2           #origDr:[Landroid/graphics/drawable/Drawable;
    :goto_a4
    return-void

    :cond_a5
    const/16 v3, 0xa

    new-array v3, v3, [Landroid/graphics/drawable/Drawable;

    iput-object v3, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mDrawables:[Landroid/graphics/drawable/Drawable;

    iput v4, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mNumChildren:I

    iput-boolean v4, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mCanConstantState:Z

    iput-boolean v4, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mCheckedConstantState:Z

    goto :goto_a4
.end method


# virtual methods
.method public final addChild(Landroid/graphics/drawable/Drawable;)I
    .registers 6
    .parameter "dr"

    .prologue
    const/4 v3, 0x0

    iget v0, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mNumChildren:I

    .local v0, pos:I
    iget-object v1, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mDrawables:[Landroid/graphics/drawable/Drawable;

    array-length v1, v1

    if-lt v0, v1, :cond_d

    add-int/lit8 v1, v0, 0xa

    invoke-virtual {p0, v0, v1}, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->growArray(II)V

    :cond_d
    const/4 v1, 0x1

    invoke-virtual {p1, v3, v1}, Landroid/graphics/drawable/Drawable;->setVisible(ZZ)Z

    iget-object v1, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mOwner:Landroid/graphics/drawable/DrawableContainer;

    invoke-virtual {p1, v1}, Landroid/graphics/drawable/Drawable;->setCallback(Landroid/graphics/drawable/Drawable$Callback;)V

    iget-object v1, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mDrawables:[Landroid/graphics/drawable/Drawable;

    aput-object p1, v1, v0

    iget v1, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mNumChildren:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mNumChildren:I

    iget v1, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mChildrenChangingConfigurations:I

    invoke-virtual {p1}, Landroid/graphics/drawable/Drawable;->getChangingConfigurations()I

    move-result v2

    or-int/2addr v1, v2

    iput v1, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mChildrenChangingConfigurations:I

    iput-boolean v3, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mHaveOpacity:Z

    iput-boolean v3, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mHaveStateful:Z

    const/4 v1, 0x0

    iput-object v1, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mConstantPadding:Landroid/graphics/Rect;

    iput-boolean v3, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mPaddingChecked:Z

    iput-boolean v3, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mComputedConstantSize:Z

    return v0
.end method

.method public declared-synchronized canConstantState()Z
    .registers 4

    .prologue
    monitor-enter p0

    :try_start_1
    iget-boolean v2, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mCheckedConstantState:Z

    if-nez v2, :cond_1d

    const/4 v2, 0x1

    iput-boolean v2, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mCanConstantState:Z

    iget v0, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mNumChildren:I

    .local v0, N:I
    const/4 v1, 0x0

    .local v1, i:I
    :goto_b
    if-ge v1, v0, :cond_1a

    iget-object v2, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mDrawables:[Landroid/graphics/drawable/Drawable;

    aget-object v2, v2, v1

    invoke-virtual {v2}, Landroid/graphics/drawable/Drawable;->getConstantState()Landroid/graphics/drawable/Drawable$ConstantState;

    move-result-object v2

    if-nez v2, :cond_21

    const/4 v2, 0x0

    iput-boolean v2, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mCanConstantState:Z

    :cond_1a
    const/4 v2, 0x1

    iput-boolean v2, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mCheckedConstantState:Z

    .end local v0           #N:I
    .end local v1           #i:I
    :cond_1d
    iget-boolean v2, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mCanConstantState:Z
    :try_end_1f
    .catchall {:try_start_1 .. :try_end_1f} :catchall_24

    monitor-exit p0

    return v2

    .restart local v0       #N:I
    .restart local v1       #i:I
    :cond_21
    add-int/lit8 v1, v1, 0x1

    goto :goto_b

    .end local v0           #N:I
    .end local v1           #i:I
    :catchall_24
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method protected computeConstantSize()V
    .registers 7

    .prologue
    const/4 v5, 0x1

    iput-boolean v5, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mComputedConstantSize:Z

    invoke-virtual {p0}, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->getChildCount()I

    move-result v0

    .local v0, N:I
    iget-object v2, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mDrawables:[Landroid/graphics/drawable/Drawable;

    .local v2, drawables:[Landroid/graphics/drawable/Drawable;
    const/4 v5, -0x1

    iput v5, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mConstantHeight:I

    iput v5, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mConstantWidth:I

    const/4 v5, 0x0

    iput v5, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mConstantMinimumHeight:I

    iput v5, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mConstantMinimumWidth:I

    const/4 v3, 0x0

    .local v3, i:I
    :goto_14
    if-ge v3, v0, :cond_43

    aget-object v1, v2, v3

    .local v1, dr:Landroid/graphics/drawable/Drawable;
    invoke-virtual {v1}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v4

    .local v4, s:I
    iget v5, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mConstantWidth:I

    if-le v4, v5, :cond_22

    iput v4, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mConstantWidth:I

    :cond_22
    invoke-virtual {v1}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v4

    iget v5, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mConstantHeight:I

    if-le v4, v5, :cond_2c

    iput v4, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mConstantHeight:I

    :cond_2c
    invoke-virtual {v1}, Landroid/graphics/drawable/Drawable;->getMinimumWidth()I

    move-result v4

    iget v5, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mConstantMinimumWidth:I

    if-le v4, v5, :cond_36

    iput v4, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mConstantMinimumWidth:I

    :cond_36
    invoke-virtual {v1}, Landroid/graphics/drawable/Drawable;->getMinimumHeight()I

    move-result v4

    iget v5, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mConstantMinimumHeight:I

    if-le v4, v5, :cond_40

    iput v4, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mConstantMinimumHeight:I

    :cond_40
    add-int/lit8 v3, v3, 0x1

    goto :goto_14

    .end local v1           #dr:Landroid/graphics/drawable/Drawable;
    .end local v4           #s:I
    :cond_43
    return-void
.end method

.method public getChangingConfigurations()I
    .registers 2

    .prologue
    iget v0, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mChangingConfigurations:I

    return v0
.end method

.method public final getChildCount()I
    .registers 2

    .prologue
    iget v0, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mNumChildren:I

    return v0
.end method

.method public final getChildren()[Landroid/graphics/drawable/Drawable;
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mDrawables:[Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method public final getConstantHeight()I
    .registers 2

    .prologue
    iget-boolean v0, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mComputedConstantSize:Z

    if-nez v0, :cond_7

    invoke-virtual {p0}, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->computeConstantSize()V

    :cond_7
    iget v0, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mConstantHeight:I

    return v0
.end method

.method public final getConstantMinimumHeight()I
    .registers 2

    .prologue
    iget-boolean v0, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mComputedConstantSize:Z

    if-nez v0, :cond_7

    invoke-virtual {p0}, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->computeConstantSize()V

    :cond_7
    iget v0, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mConstantMinimumHeight:I

    return v0
.end method

.method public final getConstantMinimumWidth()I
    .registers 2

    .prologue
    iget-boolean v0, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mComputedConstantSize:Z

    if-nez v0, :cond_7

    invoke-virtual {p0}, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->computeConstantSize()V

    :cond_7
    iget v0, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mConstantMinimumWidth:I

    return v0
.end method

.method public final getConstantPadding()Landroid/graphics/Rect;
    .registers 9

    .prologue
    const/4 v7, 0x0

    iget-boolean v5, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mVariablePadding:Z

    if-eqz v5, :cond_7

    const/4 v3, 0x0

    :goto_6
    return-object v3

    :cond_7
    iget-object v5, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mConstantPadding:Landroid/graphics/Rect;

    if-nez v5, :cond_f

    iget-boolean v5, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mPaddingChecked:Z

    if-eqz v5, :cond_12

    :cond_f
    iget-object v3, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mConstantPadding:Landroid/graphics/Rect;

    goto :goto_6

    :cond_12
    const/4 v3, 0x0

    .local v3, r:Landroid/graphics/Rect;
    new-instance v4, Landroid/graphics/Rect;

    invoke-direct {v4}, Landroid/graphics/Rect;-><init>()V

    .local v4, t:Landroid/graphics/Rect;
    invoke-virtual {p0}, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->getChildCount()I

    move-result v0

    .local v0, N:I
    iget-object v1, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mDrawables:[Landroid/graphics/drawable/Drawable;

    .local v1, drawables:[Landroid/graphics/drawable/Drawable;
    const/4 v2, 0x0

    .local v2, i:I
    :goto_1f
    if-ge v2, v0, :cond_5b

    aget-object v5, v1, v2

    invoke-virtual {v5, v4}, Landroid/graphics/drawable/Drawable;->getPadding(Landroid/graphics/Rect;)Z

    move-result v5

    if-eqz v5, :cond_58

    if-nez v3, :cond_30

    new-instance v3, Landroid/graphics/Rect;

    .end local v3           #r:Landroid/graphics/Rect;
    invoke-direct {v3, v7, v7, v7, v7}, Landroid/graphics/Rect;-><init>(IIII)V

    .restart local v3       #r:Landroid/graphics/Rect;
    :cond_30
    iget v5, v4, Landroid/graphics/Rect;->left:I

    iget v6, v3, Landroid/graphics/Rect;->left:I

    if-le v5, v6, :cond_3a

    iget v5, v4, Landroid/graphics/Rect;->left:I

    iput v5, v3, Landroid/graphics/Rect;->left:I

    :cond_3a
    iget v5, v4, Landroid/graphics/Rect;->top:I

    iget v6, v3, Landroid/graphics/Rect;->top:I

    if-le v5, v6, :cond_44

    iget v5, v4, Landroid/graphics/Rect;->top:I

    iput v5, v3, Landroid/graphics/Rect;->top:I

    :cond_44
    iget v5, v4, Landroid/graphics/Rect;->right:I

    iget v6, v3, Landroid/graphics/Rect;->right:I

    if-le v5, v6, :cond_4e

    iget v5, v4, Landroid/graphics/Rect;->right:I

    iput v5, v3, Landroid/graphics/Rect;->right:I

    :cond_4e
    iget v5, v4, Landroid/graphics/Rect;->bottom:I

    iget v6, v3, Landroid/graphics/Rect;->bottom:I

    if-le v5, v6, :cond_58

    iget v5, v4, Landroid/graphics/Rect;->bottom:I

    iput v5, v3, Landroid/graphics/Rect;->bottom:I

    :cond_58
    add-int/lit8 v2, v2, 0x1

    goto :goto_1f

    :cond_5b
    const/4 v5, 0x1

    iput-boolean v5, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mPaddingChecked:Z

    iput-object v3, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mConstantPadding:Landroid/graphics/Rect;

    goto :goto_6
.end method

.method public final getConstantWidth()I
    .registers 2

    .prologue
    iget-boolean v0, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mComputedConstantSize:Z

    if-nez v0, :cond_7

    invoke-virtual {p0}, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->computeConstantSize()V

    :cond_7
    iget v0, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mConstantWidth:I

    return v0
.end method

.method public final getEnterFadeDuration()I
    .registers 2

    .prologue
    iget v0, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mEnterFadeDuration:I

    return v0
.end method

.method public final getExitFadeDuration()I
    .registers 2

    .prologue
    iget v0, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mExitFadeDuration:I

    return v0
.end method

.method public final getOpacity()I
    .registers 6

    .prologue
    iget-boolean v4, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mHaveOpacity:Z

    if-eqz v4, :cond_7

    iget v3, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mOpacity:I

    :goto_6
    return v3

    :cond_7
    invoke-virtual {p0}, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->getChildCount()I

    move-result v0

    .local v0, N:I
    iget-object v1, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mDrawables:[Landroid/graphics/drawable/Drawable;

    .local v1, drawables:[Landroid/graphics/drawable/Drawable;
    if-lez v0, :cond_26

    const/4 v4, 0x0

    aget-object v4, v1, v4

    invoke-virtual {v4}, Landroid/graphics/drawable/Drawable;->getOpacity()I

    move-result v3

    .local v3, op:I
    :goto_16
    const/4 v2, 0x1

    .local v2, i:I
    :goto_17
    if-ge v2, v0, :cond_28

    aget-object v4, v1, v2

    invoke-virtual {v4}, Landroid/graphics/drawable/Drawable;->getOpacity()I

    move-result v4

    invoke-static {v3, v4}, Landroid/graphics/drawable/Drawable;->resolveOpacity(II)I

    move-result v3

    add-int/lit8 v2, v2, 0x1

    goto :goto_17

    .end local v2           #i:I
    .end local v3           #op:I
    :cond_26
    const/4 v3, -0x2

    goto :goto_16

    .restart local v2       #i:I
    .restart local v3       #op:I
    :cond_28
    iput v3, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mOpacity:I

    const/4 v4, 0x1

    iput-boolean v4, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mHaveOpacity:Z

    goto :goto_6
.end method

.method public growArray(II)V
    .registers 6
    .parameter "oldSize"
    .parameter "newSize"

    .prologue
    const/4 v2, 0x0

    new-array v0, p2, [Landroid/graphics/drawable/Drawable;

    .local v0, newDrawables:[Landroid/graphics/drawable/Drawable;
    iget-object v1, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mDrawables:[Landroid/graphics/drawable/Drawable;

    invoke-static {v1, v2, v0, v2, p1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    iput-object v0, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mDrawables:[Landroid/graphics/drawable/Drawable;

    return-void
.end method

.method public final isConstantSize()Z
    .registers 2

    .prologue
    iget-boolean v0, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mConstantSize:Z

    return v0
.end method

.method public final isStateful()Z
    .registers 5

    .prologue
    iget-boolean v3, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mHaveStateful:Z

    if-eqz v3, :cond_7

    iget-boolean v2, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mStateful:Z

    :goto_6
    return v2

    :cond_7
    const/4 v2, 0x0

    .local v2, stateful:Z
    invoke-virtual {p0}, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->getChildCount()I

    move-result v0

    .local v0, N:I
    const/4 v1, 0x0

    .local v1, i:I
    :goto_d
    if-ge v1, v0, :cond_1a

    iget-object v3, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mDrawables:[Landroid/graphics/drawable/Drawable;

    aget-object v3, v3, v1

    invoke-virtual {v3}, Landroid/graphics/drawable/Drawable;->isStateful()Z

    move-result v3

    if-eqz v3, :cond_20

    const/4 v2, 0x1

    :cond_1a
    iput-boolean v2, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mStateful:Z

    const/4 v3, 0x1

    iput-boolean v3, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mHaveStateful:Z

    goto :goto_6

    :cond_20
    add-int/lit8 v1, v1, 0x1

    goto :goto_d
.end method

.method public final setConstantSize(Z)V
    .registers 2
    .parameter "constant"

    .prologue
    iput-boolean p1, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mConstantSize:Z

    return-void
.end method

.method public final setEnterFadeDuration(I)V
    .registers 2
    .parameter "duration"

    .prologue
    iput p1, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mEnterFadeDuration:I

    return-void
.end method

.method public final setExitFadeDuration(I)V
    .registers 2
    .parameter "duration"

    .prologue
    iput p1, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mExitFadeDuration:I

    return-void
.end method

.method public final setVariablePadding(Z)V
    .registers 2
    .parameter "variable"

    .prologue
    iput-boolean p1, p0, Landroid/graphics/drawable/DrawableContainer$DrawableContainerState;->mVariablePadding:Z

    return-void
.end method
