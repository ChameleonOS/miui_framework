.class public Landroid/webkit/WebView$PrivateAccess;
.super Ljava/lang/Object;
.source "WebView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/webkit/WebView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "PrivateAccess"
.end annotation


# instance fields
.field final synthetic this$0:Landroid/webkit/WebView;


# direct methods
.method public constructor <init>(Landroid/webkit/WebView;)V
    .registers 2
    .parameter

    .prologue
    .line 1679
    iput-object p1, p0, Landroid/webkit/WebView$PrivateAccess;->this$0:Landroid/webkit/WebView;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public awakenScrollBars(I)V
    .registers 3
    .parameter "duration"

    .prologue
    .line 1736
    iget-object v0, p0, Landroid/webkit/WebView$PrivateAccess;->this$0:Landroid/webkit/WebView;

    #calls: Landroid/webkit/WebView;->awakenScrollBars(I)Z
    invoke-static {v0, p1}, Landroid/webkit/WebView;->access$1200(Landroid/webkit/WebView;I)Z

    .line 1737
    return-void
.end method

.method public awakenScrollBars(IZ)V
    .registers 4
    .parameter "duration"
    .parameter "invalidate"

    .prologue
    .line 1740
    iget-object v0, p0, Landroid/webkit/WebView$PrivateAccess;->this$0:Landroid/webkit/WebView;

    #calls: Landroid/webkit/WebView;->awakenScrollBars(IZ)Z
    invoke-static {v0, p1, p2}, Landroid/webkit/WebView;->access$1300(Landroid/webkit/WebView;IZ)Z

    .line 1741
    return-void
.end method

.method public getHorizontalScrollFactor()F
    .registers 2

    .prologue
    .line 1748
    iget-object v0, p0, Landroid/webkit/WebView$PrivateAccess;->this$0:Landroid/webkit/WebView;

    #calls: Landroid/webkit/WebView;->getHorizontalScrollFactor()F
    invoke-static {v0}, Landroid/webkit/WebView;->access$1500(Landroid/webkit/WebView;)F

    move-result v0

    return v0
.end method

.method public getHorizontalScrollbarHeight()I
    .registers 2

    .prologue
    .line 1760
    iget-object v0, p0, Landroid/webkit/WebView$PrivateAccess;->this$0:Landroid/webkit/WebView;

    #calls: Landroid/webkit/WebView;->getHorizontalScrollbarHeight()I
    invoke-static {v0}, Landroid/webkit/WebView;->access$1700(Landroid/webkit/WebView;)I

    move-result v0

    return v0
.end method

.method public getVerticalScrollFactor()F
    .registers 2

    .prologue
    .line 1744
    iget-object v0, p0, Landroid/webkit/WebView$PrivateAccess;->this$0:Landroid/webkit/WebView;

    #calls: Landroid/webkit/WebView;->getVerticalScrollFactor()F
    invoke-static {v0}, Landroid/webkit/WebView;->access$1400(Landroid/webkit/WebView;)F

    move-result v0

    return v0
.end method

.method public onScrollChanged(IIII)V
    .registers 6
    .parameter "l"
    .parameter "t"
    .parameter "oldl"
    .parameter "oldt"

    .prologue
    .line 1756
    iget-object v0, p0, Landroid/webkit/WebView$PrivateAccess;->this$0:Landroid/webkit/WebView;

    invoke-virtual {v0, p1, p2, p3, p4}, Landroid/webkit/WebView;->onScrollChanged(IIII)V

    .line 1757
    return-void
.end method

.method public overScrollBy(IIIIIIIIZ)V
    .registers 20
    .parameter "deltaX"
    .parameter "deltaY"
    .parameter "scrollX"
    .parameter "scrollY"
    .parameter "scrollRangeX"
    .parameter "scrollRangeY"
    .parameter "maxOverScrollX"
    .parameter "maxOverScrollY"
    .parameter "isTouchEvent"

    .prologue
    .line 1731
    iget-object v0, p0, Landroid/webkit/WebView$PrivateAccess;->this$0:Landroid/webkit/WebView;

    move v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    move v5, p5

    move/from16 v6, p6

    move/from16 v7, p7

    move/from16 v8, p8

    move/from16 v9, p9

    #calls: Landroid/webkit/WebView;->overScrollBy(IIIIIIIIZ)Z
    invoke-static/range {v0 .. v9}, Landroid/webkit/WebView;->access$1100(Landroid/webkit/WebView;IIIIIIIIZ)Z

    .line 1733
    return-void
.end method

.method public setMeasuredDimension(II)V
    .registers 4
    .parameter "measuredWidth"
    .parameter "measuredHeight"

    .prologue
    .line 1752
    iget-object v0, p0, Landroid/webkit/WebView$PrivateAccess;->this$0:Landroid/webkit/WebView;

    #calls: Landroid/webkit/WebView;->setMeasuredDimension(II)V
    invoke-static {v0, p1, p2}, Landroid/webkit/WebView;->access$1600(Landroid/webkit/WebView;II)V

    .line 1753
    return-void
.end method

.method public setScrollXRaw(I)V
    .registers 3
    .parameter "scrollX"

    .prologue
    .line 1766
    iget-object v0, p0, Landroid/webkit/WebView$PrivateAccess;->this$0:Landroid/webkit/WebView;

    #setter for: Landroid/view/View;->mScrollX:I
    invoke-static {v0, p1}, Landroid/webkit/WebView;->access$1802(Landroid/webkit/WebView;I)I

    .line 1767
    return-void
.end method

.method public setScrollYRaw(I)V
    .registers 3
    .parameter "scrollY"

    .prologue
    .line 1771
    iget-object v0, p0, Landroid/webkit/WebView$PrivateAccess;->this$0:Landroid/webkit/WebView;

    #setter for: Landroid/view/View;->mScrollY:I
    invoke-static {v0, p1}, Landroid/webkit/WebView;->access$1902(Landroid/webkit/WebView;I)I

    .line 1772
    return-void
.end method

.method public super_computeScroll()V
    .registers 2

    .prologue
    .line 1690
    iget-object v0, p0, Landroid/webkit/WebView$PrivateAccess;->this$0:Landroid/webkit/WebView;

    #calls: Landroid/view/View;->computeScroll()V
    invoke-static {v0}, Landroid/webkit/WebView;->access$201(Landroid/webkit/WebView;)V

    .line 1691
    return-void
.end method

.method public super_dispatchKeyEvent(Landroid/view/KeyEvent;)Z
    .registers 3
    .parameter "event"

    .prologue
    .line 1710
    iget-object v0, p0, Landroid/webkit/WebView$PrivateAccess;->this$0:Landroid/webkit/WebView;

    #calls: Landroid/view/ViewGroup;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z
    invoke-static {v0, p1}, Landroid/webkit/WebView;->access$701(Landroid/webkit/WebView;Landroid/view/KeyEvent;)Z

    move-result v0

    return v0
.end method

.method public super_getScrollBarStyle()I
    .registers 2

    .prologue
    .line 1682
    iget-object v0, p0, Landroid/webkit/WebView$PrivateAccess;->this$0:Landroid/webkit/WebView;

    #calls: Landroid/view/View;->getScrollBarStyle()I
    invoke-static {v0}, Landroid/webkit/WebView;->access$001(Landroid/webkit/WebView;)I

    move-result v0

    return v0
.end method

.method public super_onGenericMotionEvent(Landroid/view/MotionEvent;)Z
    .registers 3
    .parameter "event"

    .prologue
    .line 1714
    iget-object v0, p0, Landroid/webkit/WebView$PrivateAccess;->this$0:Landroid/webkit/WebView;

    #calls: Landroid/view/View;->onGenericMotionEvent(Landroid/view/MotionEvent;)Z
    invoke-static {v0, p1}, Landroid/webkit/WebView;->access$801(Landroid/webkit/WebView;Landroid/view/MotionEvent;)Z

    move-result v0

    return v0
.end method

.method public super_onHoverEvent(Landroid/view/MotionEvent;)Z
    .registers 3
    .parameter "event"

    .prologue
    .line 1694
    iget-object v0, p0, Landroid/webkit/WebView$PrivateAccess;->this$0:Landroid/webkit/WebView;

    #calls: Landroid/view/View;->onHoverEvent(Landroid/view/MotionEvent;)Z
    invoke-static {v0, p1}, Landroid/webkit/WebView;->access$301(Landroid/webkit/WebView;Landroid/view/MotionEvent;)Z

    move-result v0

    return v0
.end method

.method public super_performAccessibilityAction(ILandroid/os/Bundle;)Z
    .registers 4
    .parameter "action"
    .parameter "arguments"

    .prologue
    .line 1698
    iget-object v0, p0, Landroid/webkit/WebView$PrivateAccess;->this$0:Landroid/webkit/WebView;

    #calls: Landroid/view/View;->performAccessibilityAction(ILandroid/os/Bundle;)Z
    invoke-static {v0, p1, p2}, Landroid/webkit/WebView;->access$401(Landroid/webkit/WebView;ILandroid/os/Bundle;)Z

    move-result v0

    return v0
.end method

.method public super_performLongClick()Z
    .registers 2

    .prologue
    .line 1702
    iget-object v0, p0, Landroid/webkit/WebView$PrivateAccess;->this$0:Landroid/webkit/WebView;

    #calls: Landroid/view/View;->performLongClick()Z
    invoke-static {v0}, Landroid/webkit/WebView;->access$501(Landroid/webkit/WebView;)Z

    move-result v0

    return v0
.end method

.method public super_requestFocus(ILandroid/graphics/Rect;)Z
    .registers 4
    .parameter "direction"
    .parameter "previouslyFocusedRect"

    .prologue
    .line 1718
    iget-object v0, p0, Landroid/webkit/WebView$PrivateAccess;->this$0:Landroid/webkit/WebView;

    #calls: Landroid/view/ViewGroup;->requestFocus(ILandroid/graphics/Rect;)Z
    invoke-static {v0, p1, p2}, Landroid/webkit/WebView;->access$901(Landroid/webkit/WebView;ILandroid/graphics/Rect;)Z

    move-result v0

    return v0
.end method

.method public super_scrollTo(II)V
    .registers 4
    .parameter "scrollX"
    .parameter "scrollY"

    .prologue
    .line 1686
    iget-object v0, p0, Landroid/webkit/WebView$PrivateAccess;->this$0:Landroid/webkit/WebView;

    #calls: Landroid/view/View;->scrollTo(II)V
    invoke-static {v0, p1, p2}, Landroid/webkit/WebView;->access$101(Landroid/webkit/WebView;II)V

    .line 1687
    return-void
.end method

.method public super_setFrame(IIII)Z
    .registers 6
    .parameter "left"
    .parameter "top"
    .parameter "right"
    .parameter "bottom"

    .prologue
    .line 1706
    iget-object v0, p0, Landroid/webkit/WebView$PrivateAccess;->this$0:Landroid/webkit/WebView;

    #calls: Landroid/view/View;->setFrame(IIII)Z
    invoke-static {v0, p1, p2, p3, p4}, Landroid/webkit/WebView;->access$601(Landroid/webkit/WebView;IIII)Z

    move-result v0

    return v0
.end method

.method public super_setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    .registers 3
    .parameter "params"

    .prologue
    .line 1722
    iget-object v0, p0, Landroid/webkit/WebView$PrivateAccess;->this$0:Landroid/webkit/WebView;

    #calls: Landroid/view/ViewGroup;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-static {v0, p1}, Landroid/webkit/WebView;->access$1001(Landroid/webkit/WebView;Landroid/view/ViewGroup$LayoutParams;)V

    .line 1723
    return-void
.end method
