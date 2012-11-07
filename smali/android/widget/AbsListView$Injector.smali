.class Landroid/widget/AbsListView$Injector;
.super Ljava/lang/Object;
.source "AbsListView.java"


# annotations
.annotation build Landroid/annotation/MiuiHook;
    value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_CLASS:Landroid/annotation/MiuiHook$MiuiHookType;
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/AbsListView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Injector"
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 120
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static isOutOfTouchRange(Landroid/widget/AbsListView;Landroid/view/MotionEvent;)Z
    .registers 5
    .parameter "alv"
    .parameter "ev"

    .prologue
    .line 122
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v0

    iget v1, p0, Landroid/widget/AbsListView;->mTouchPaddingLeft:I

    int-to-float v1, v1

    cmpg-float v0, v0, v1

    if-ltz v0, :cond_1b

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v0

    invoke-virtual {p0}, Landroid/widget/AbsListView;->getWidth()I

    move-result v1

    iget v2, p0, Landroid/widget/AbsListView;->mTouchPaddingRight:I

    sub-int/2addr v1, v2

    int-to-float v1, v1

    cmpl-float v0, v0, v1

    if-lez v0, :cond_1d

    .line 124
    :cond_1b
    const/4 v0, 0x1

    .line 126
    :goto_1c
    return v0

    :cond_1d
    const/4 v0, 0x0

    goto :goto_1c
.end method

.method static tagSequenceState(Landroid/view/View;ILandroid/widget/Adapter;)V
    .registers 5
    .parameter "v"
    .parameter "position"
    .parameter "adapter"

    .prologue
    .line 130
    if-nez p1, :cond_14

    .line 131
    invoke-interface {p2}, Landroid/widget/Adapter;->getCount()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_10

    const v0, 0x10100a3

    :goto_c
    invoke-virtual {p0, v0}, Landroid/view/View;->setAdditionalState(I)V

    .line 137
    :goto_f
    return-void

    .line 131
    :cond_10
    const v0, 0x10100a4

    goto :goto_c

    .line 132
    :cond_14
    invoke-interface {p2}, Landroid/widget/Adapter;->getCount()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    if-ne p1, v0, :cond_23

    .line 133
    const v0, 0x10100a6

    invoke-virtual {p0, v0}, Landroid/view/View;->setAdditionalState(I)V

    goto :goto_f

    .line 135
    :cond_23
    const v0, 0x10100a5

    invoke-virtual {p0, v0}, Landroid/view/View;->setAdditionalState(I)V

    goto :goto_f
.end method
