.class public Lcom/android/internal/view/menu/IconMenuView$LayoutParams;
.super Landroid/view/ViewGroup$MarginLayoutParams;
.source "IconMenuView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/view/menu/IconMenuView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LayoutParams"
.end annotation


# instance fields
.field bottom:I

.field desiredWidth:I

.field left:I

.field maxNumItemsOnRow:I

.field right:I

.field top:I


# direct methods
.method public constructor <init>(II)V
    .registers 3
    .parameter "width"
    .parameter "height"

    .prologue
    .line 758
    invoke-direct {p0, p1, p2}, Landroid/view/ViewGroup$MarginLayoutParams;-><init>(II)V

    .line 759
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 3
    .parameter "c"
    .parameter "attrs"

    .prologue
    .line 754
    invoke-direct {p0, p1, p2}, Landroid/view/ViewGroup$MarginLayoutParams;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 755
    return-void
.end method
