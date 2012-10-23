.class public final Landroid/view/ViewStub;
.super Landroid/view/View;
.source "ViewStub.java"


# annotations
.annotation runtime Landroid/widget/RemoteViews$RemoteView;
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/view/ViewStub$OnInflateListener;
    }
.end annotation


# instance fields
.field private mInflateListener:Landroid/view/ViewStub$OnInflateListener;

.field private mInflatedId:I

.field private mInflatedViewRef:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end field

.field private mInflater:Landroid/view/LayoutInflater;

.field private mLayoutResource:I


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .registers 3
    .parameter "context"

    .prologue
    .line 80
    invoke-direct {p0}, Landroid/view/View;-><init>()V

    .line 72
    const/4 v0, 0x0

    iput v0, p0, Landroid/view/ViewStub;->mLayoutResource:I

    .line 81
    invoke-direct {p0, p1}, Landroid/view/ViewStub;->initialize(Landroid/content/Context;)V

    .line 82
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;I)V
    .registers 4
    .parameter "context"
    .parameter "layoutResource"

    .prologue
    .line 90
    invoke-direct {p0}, Landroid/view/View;-><init>()V

    .line 72
    const/4 v0, 0x0

    iput v0, p0, Landroid/view/ViewStub;->mLayoutResource:I

    .line 91
    iput p2, p0, Landroid/view/ViewStub;->mLayoutResource:I

    .line 92
    invoke-direct {p0, p1}, Landroid/view/ViewStub;->initialize(Landroid/content/Context;)V

    .line 93
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 4
    .parameter "context"
    .parameter "attrs"

    .prologue
    .line 96
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Landroid/view/ViewStub;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 97
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .registers 8
    .parameter "context"
    .parameter "attrs"
    .parameter "defStyle"

    .prologue
    const/4 v3, -0x1

    const/4 v2, 0x0

    .line 100
    invoke-direct {p0}, Landroid/view/View;-><init>()V

    .line 72
    iput v2, p0, Landroid/view/ViewStub;->mLayoutResource:I

    .line 101
    sget-object v1, Lcom/android/internal/R$styleable;->ViewStub:[I

    invoke-virtual {p1, p2, v1, p3, v2}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 104
    .local v0, a:Landroid/content/res/TypedArray;
    const/4 v1, 0x1

    invoke-virtual {v0, v1, v3}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v1

    iput v1, p0, Landroid/view/ViewStub;->mInflatedId:I

    .line 105
    invoke-virtual {v0, v2, v2}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v1

    iput v1, p0, Landroid/view/ViewStub;->mLayoutResource:I

    .line 107
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 109
    sget-object v1, Lcom/android/internal/R$styleable;->View:[I

    invoke-virtual {p1, p2, v1, p3, v2}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 110
    const/16 v1, 0x8

    invoke-virtual {v0, v1, v3}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v1

    iput v1, p0, Landroid/view/View;->mID:I

    .line 111
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 113
    invoke-direct {p0, p1}, Landroid/view/ViewStub;->initialize(Landroid/content/Context;)V

    .line 114
    return-void
.end method

.method private initialize(Landroid/content/Context;)V
    .registers 3
    .parameter "context"

    .prologue
    .line 117
    iput-object p1, p0, Landroid/view/View;->mContext:Landroid/content/Context;

    .line 118
    const/16 v0, 0x8

    invoke-virtual {p0, v0}, Landroid/view/ViewStub;->setVisibility(I)V

    .line 119
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Landroid/view/ViewStub;->setWillNotDraw(Z)V

    .line 120
    return-void
.end method


# virtual methods
.method protected dispatchDraw(Landroid/graphics/Canvas;)V
    .registers 2
    .parameter "canvas"

    .prologue
    .line 210
    return-void
.end method

.method public draw(Landroid/graphics/Canvas;)V
    .registers 2
    .parameter "canvas"

    .prologue
    .line 206
    return-void
.end method

.method public getInflatedId()I
    .registers 2

    .prologue
    .line 133
    iget v0, p0, Landroid/view/ViewStub;->mInflatedId:I

    return v0
.end method

.method public getLayoutInflater()Landroid/view/LayoutInflater;
    .registers 2

    .prologue
    .line 196
    iget-object v0, p0, Landroid/view/ViewStub;->mInflater:Landroid/view/LayoutInflater;

    return-object v0
.end method

.method public getLayoutResource()I
    .registers 2

    .prologue
    .line 164
    iget v0, p0, Landroid/view/ViewStub;->mLayoutResource:I

    return v0
.end method

.method public inflate()Landroid/view/View;
    .registers 9

    .prologue
    .line 247
    invoke-virtual {p0}, Landroid/view/ViewStub;->getParent()Landroid/view/ViewParent;

    move-result-object v5

    .line 249
    .local v5, viewParent:Landroid/view/ViewParent;
    if-eqz v5, :cond_5c

    instance-of v6, v5, Landroid/view/ViewGroup;

    if-eqz v6, :cond_5c

    .line 250
    iget v6, p0, Landroid/view/ViewStub;->mLayoutResource:I

    if-eqz v6, :cond_54

    move-object v3, v5

    .line 251
    check-cast v3, Landroid/view/ViewGroup;

    .line 253
    .local v3, parent:Landroid/view/ViewGroup;
    iget-object v6, p0, Landroid/view/ViewStub;->mInflater:Landroid/view/LayoutInflater;

    if-eqz v6, :cond_49

    .line 254
    iget-object v0, p0, Landroid/view/ViewStub;->mInflater:Landroid/view/LayoutInflater;

    .line 258
    .local v0, factory:Landroid/view/LayoutInflater;
    :goto_17
    iget v6, p0, Landroid/view/ViewStub;->mLayoutResource:I

    const/4 v7, 0x0

    invoke-virtual {v0, v6, v3, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v4

    .line 261
    .local v4, view:Landroid/view/View;
    iget v6, p0, Landroid/view/ViewStub;->mInflatedId:I

    const/4 v7, -0x1

    if-eq v6, v7, :cond_28

    .line 262
    iget v6, p0, Landroid/view/ViewStub;->mInflatedId:I

    invoke-virtual {v4, v6}, Landroid/view/View;->setId(I)V

    .line 265
    :cond_28
    invoke-virtual {v3, p0}, Landroid/view/ViewGroup;->indexOfChild(Landroid/view/View;)I

    move-result v1

    .line 266
    .local v1, index:I
    invoke-virtual {v3, p0}, Landroid/view/ViewGroup;->removeViewInLayout(Landroid/view/View;)V

    .line 268
    invoke-virtual {p0}, Landroid/view/ViewStub;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    .line 269
    .local v2, layoutParams:Landroid/view/ViewGroup$LayoutParams;
    if-eqz v2, :cond_50

    .line 270
    invoke-virtual {v3, v4, v1, v2}, Landroid/view/ViewGroup;->addView(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V

    .line 275
    :goto_38
    new-instance v6, Ljava/lang/ref/WeakReference;

    invoke-direct {v6, v4}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v6, p0, Landroid/view/ViewStub;->mInflatedViewRef:Ljava/lang/ref/WeakReference;

    .line 277
    iget-object v6, p0, Landroid/view/ViewStub;->mInflateListener:Landroid/view/ViewStub$OnInflateListener;

    if-eqz v6, :cond_48

    .line 278
    iget-object v6, p0, Landroid/view/ViewStub;->mInflateListener:Landroid/view/ViewStub$OnInflateListener;

    invoke-interface {v6, p0, v4}, Landroid/view/ViewStub$OnInflateListener;->onInflate(Landroid/view/ViewStub;Landroid/view/View;)V

    .line 281
    :cond_48
    return-object v4

    .line 256
    .end local v0           #factory:Landroid/view/LayoutInflater;
    .end local v1           #index:I
    .end local v2           #layoutParams:Landroid/view/ViewGroup$LayoutParams;
    .end local v4           #view:Landroid/view/View;
    :cond_49
    iget-object v6, p0, Landroid/view/View;->mContext:Landroid/content/Context;

    invoke-static {v6}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .restart local v0       #factory:Landroid/view/LayoutInflater;
    goto :goto_17

    .line 272
    .restart local v1       #index:I
    .restart local v2       #layoutParams:Landroid/view/ViewGroup$LayoutParams;
    .restart local v4       #view:Landroid/view/View;
    :cond_50
    invoke-virtual {v3, v4, v1}, Landroid/view/ViewGroup;->addView(Landroid/view/View;I)V

    goto :goto_38

    .line 283
    .end local v0           #factory:Landroid/view/LayoutInflater;
    .end local v1           #index:I
    .end local v2           #layoutParams:Landroid/view/ViewGroup$LayoutParams;
    .end local v3           #parent:Landroid/view/ViewGroup;
    .end local v4           #view:Landroid/view/View;
    :cond_54
    new-instance v6, Ljava/lang/IllegalArgumentException;

    const-string v7, "ViewStub must have a valid layoutResource"

    invoke-direct {v6, v7}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 286
    :cond_5c
    new-instance v6, Ljava/lang/IllegalStateException;

    const-string v7, "ViewStub must have a non-null ViewGroup viewParent"

    invoke-direct {v6, v7}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v6
.end method

.method protected onMeasure(II)V
    .registers 4
    .parameter "widthMeasureSpec"
    .parameter "heightMeasureSpec"

    .prologue
    const/4 v0, 0x0

    .line 201
    invoke-virtual {p0, v0, v0}, Landroid/view/ViewStub;->setMeasuredDimension(II)V

    .line 202
    return-void
.end method

.method public setInflatedId(I)V
    .registers 2
    .parameter "inflatedId"
    .annotation runtime Landroid/view/RemotableViewMethod;
    .end annotation

    .prologue
    .line 148
    iput p1, p0, Landroid/view/ViewStub;->mInflatedId:I

    .line 149
    return-void
.end method

.method public setLayoutInflater(Landroid/view/LayoutInflater;)V
    .registers 2
    .parameter "inflater"

    .prologue
    .line 189
    iput-object p1, p0, Landroid/view/ViewStub;->mInflater:Landroid/view/LayoutInflater;

    .line 190
    return-void
.end method

.method public setLayoutResource(I)V
    .registers 2
    .parameter "layoutResource"
    .annotation runtime Landroid/view/RemotableViewMethod;
    .end annotation

    .prologue
    .line 181
    iput p1, p0, Landroid/view/ViewStub;->mLayoutResource:I

    .line 182
    return-void
.end method

.method public setOnInflateListener(Landroid/view/ViewStub$OnInflateListener;)V
    .registers 2
    .parameter "inflateListener"

    .prologue
    .line 299
    iput-object p1, p0, Landroid/view/ViewStub;->mInflateListener:Landroid/view/ViewStub$OnInflateListener;

    .line 300
    return-void
.end method

.method public setVisibility(I)V
    .registers 5
    .parameter "visibility"
    .annotation runtime Landroid/view/RemotableViewMethod;
    .end annotation

    .prologue
    .line 224
    iget-object v1, p0, Landroid/view/ViewStub;->mInflatedViewRef:Ljava/lang/ref/WeakReference;

    if-eqz v1, :cond_1b

    .line 225
    iget-object v1, p0, Landroid/view/ViewStub;->mInflatedViewRef:Ljava/lang/ref/WeakReference;

    invoke-virtual {v1}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    .line 226
    .local v0, view:Landroid/view/View;
    if-eqz v0, :cond_12

    .line 227
    invoke-virtual {v0, p1}, Landroid/view/View;->setVisibility(I)V

    .line 237
    .end local v0           #view:Landroid/view/View;
    :cond_11
    :goto_11
    return-void

    .line 229
    .restart local v0       #view:Landroid/view/View;
    :cond_12
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string/jumbo v2, "setVisibility called on un-referenced view"

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 232
    .end local v0           #view:Landroid/view/View;
    :cond_1b
    invoke-super {p0, p1}, Landroid/view/View;->setVisibility(I)V

    .line 233
    if-eqz p1, :cond_23

    const/4 v1, 0x4

    if-ne p1, v1, :cond_11

    .line 234
    :cond_23
    invoke-virtual {p0}, Landroid/view/ViewStub;->inflate()Landroid/view/View;

    goto :goto_11
.end method
