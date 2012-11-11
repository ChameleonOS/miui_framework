.class public Landroid/text/method/ArrowKeyMovementMethod;
.super Landroid/text/method/BaseMovementMethod;
.source "ArrowKeyMovementMethod.java"

# interfaces
.implements Landroid/text/method/MovementMethod;


# static fields
.field private static final LAST_TAP_DOWN:Ljava/lang/Object;

.field private static sInstance:Landroid/text/method/ArrowKeyMovementMethod;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Landroid/text/method/ArrowKeyMovementMethod;->LAST_TAP_DOWN:Ljava/lang/Object;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct {p0}, Landroid/text/method/BaseMovementMethod;-><init>()V

    return-void
.end method

.method private static getCurrentLineTop(Landroid/text/Spannable;Landroid/text/Layout;)I
    .registers 3
    .parameter "buffer"
    .parameter "layout"

    .prologue
    invoke-static {p0}, Landroid/text/Selection;->getSelectionEnd(Ljava/lang/CharSequence;)I

    move-result v0

    invoke-virtual {p1, v0}, Landroid/text/Layout;->getLineForOffset(I)I

    move-result v0

    invoke-virtual {p1, v0}, Landroid/text/Layout;->getLineTop(I)I

    move-result v0

    return v0
.end method

.method public static getInstance()Landroid/text/method/MovementMethod;
    .registers 1

    .prologue
    sget-object v0, Landroid/text/method/ArrowKeyMovementMethod;->sInstance:Landroid/text/method/ArrowKeyMovementMethod;

    if-nez v0, :cond_b

    new-instance v0, Landroid/text/method/ArrowKeyMovementMethod;

    invoke-direct {v0}, Landroid/text/method/ArrowKeyMovementMethod;-><init>()V

    sput-object v0, Landroid/text/method/ArrowKeyMovementMethod;->sInstance:Landroid/text/method/ArrowKeyMovementMethod;

    :cond_b
    sget-object v0, Landroid/text/method/ArrowKeyMovementMethod;->sInstance:Landroid/text/method/ArrowKeyMovementMethod;

    return-object v0
.end method

.method private static getPageHeight(Landroid/widget/TextView;)I
    .registers 3
    .parameter "widget"

    .prologue
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    .local v0, rect:Landroid/graphics/Rect;
    invoke-virtual {p0, v0}, Landroid/widget/TextView;->getGlobalVisibleRect(Landroid/graphics/Rect;)Z

    move-result v1

    if-eqz v1, :cond_10

    invoke-virtual {v0}, Landroid/graphics/Rect;->height()I

    move-result v1

    :goto_f
    return v1

    :cond_10
    const/4 v1, 0x0

    goto :goto_f
.end method

.method private static isSelecting(Landroid/text/Spannable;)Z
    .registers 3
    .parameter "buffer"

    .prologue
    const/4 v0, 0x1

    invoke-static {p0, v0}, Landroid/text/method/MetaKeyKeyListener;->getMetaState(Ljava/lang/CharSequence;I)I

    move-result v1

    if-eq v1, v0, :cond_f

    const/16 v1, 0x800

    invoke-static {p0, v1}, Landroid/text/method/MetaKeyKeyListener;->getMetaState(Ljava/lang/CharSequence;I)I

    move-result v1

    if-eqz v1, :cond_10

    :cond_f
    :goto_f
    return v0

    :cond_10
    const/4 v0, 0x0

    goto :goto_f
.end method


# virtual methods
.method protected bottom(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 4
    .parameter "widget"
    .parameter "buffer"

    .prologue
    invoke-static {p2}, Landroid/text/method/ArrowKeyMovementMethod;->isSelecting(Landroid/text/Spannable;)Z

    move-result v0

    if-eqz v0, :cond_f

    invoke-interface {p2}, Landroid/text/Spannable;->length()I

    move-result v0

    invoke-static {p2, v0}, Landroid/text/Selection;->extendSelection(Landroid/text/Spannable;I)V

    :goto_d
    const/4 v0, 0x1

    return v0

    :cond_f
    invoke-interface {p2}, Landroid/text/Spannable;->length()I

    move-result v0

    invoke-static {p2, v0}, Landroid/text/Selection;->setSelection(Landroid/text/Spannable;I)V

    goto :goto_d
.end method

.method public canSelectArbitrarily()Z
    .registers 2

    .prologue
    const/4 v0, 0x1

    return v0
.end method

.method protected down(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 5
    .parameter "widget"
    .parameter "buffer"

    .prologue
    invoke-virtual {p1}, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;

    move-result-object v0

    .local v0, layout:Landroid/text/Layout;
    invoke-static {p2}, Landroid/text/method/ArrowKeyMovementMethod;->isSelecting(Landroid/text/Spannable;)Z

    move-result v1

    if-eqz v1, :cond_f

    invoke-static {p2, v0}, Landroid/text/Selection;->extendDown(Landroid/text/Spannable;Landroid/text/Layout;)Z

    move-result v1

    :goto_e
    return v1

    :cond_f
    invoke-static {p2, v0}, Landroid/text/Selection;->moveDown(Landroid/text/Spannable;Landroid/text/Layout;)Z

    move-result v1

    goto :goto_e
.end method

.method protected end(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 4
    .parameter "widget"
    .parameter "buffer"

    .prologue
    invoke-virtual {p0, p1, p2}, Landroid/text/method/ArrowKeyMovementMethod;->lineEnd(Landroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    return v0
.end method

.method protected handleMovementKey(Landroid/widget/TextView;Landroid/text/Spannable;IILandroid/view/KeyEvent;)Z
    .registers 7
    .parameter "widget"
    .parameter "buffer"
    .parameter "keyCode"
    .parameter "movementMetaState"
    .parameter "event"

    .prologue
    packed-switch p3, :pswitch_data_28

    :cond_3
    invoke-super/range {p0 .. p5}, Landroid/text/method/BaseMovementMethod;->handleMovementKey(Landroid/widget/TextView;Landroid/text/Spannable;IILandroid/view/KeyEvent;)Z

    move-result v0

    :goto_7
    return v0

    :pswitch_8
    invoke-static {p4}, Landroid/view/KeyEvent;->metaStateHasNoModifiers(I)Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-virtual {p5}, Landroid/view/KeyEvent;->getAction()I

    move-result v0

    if-nez v0, :cond_3

    invoke-virtual {p5}, Landroid/view/KeyEvent;->getRepeatCount()I

    move-result v0

    if-nez v0, :cond_3

    const/16 v0, 0x800

    invoke-static {p2, v0}, Landroid/text/method/MetaKeyKeyListener;->getMetaState(Ljava/lang/CharSequence;I)I

    move-result v0

    if-eqz v0, :cond_3

    invoke-virtual {p1}, Landroid/widget/TextView;->showContextMenu()Z

    move-result v0

    goto :goto_7

    nop

    :pswitch_data_28
    .packed-switch 0x17
        :pswitch_8
    .end packed-switch
.end method

.method protected home(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 4
    .parameter "widget"
    .parameter "buffer"

    .prologue
    invoke-virtual {p0, p1, p2}, Landroid/text/method/ArrowKeyMovementMethod;->lineStart(Landroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    return v0
.end method

.method public initialize(Landroid/widget/TextView;Landroid/text/Spannable;)V
    .registers 4
    .parameter "widget"
    .parameter "text"

    .prologue
    const/4 v0, 0x0

    invoke-static {p2, v0}, Landroid/text/Selection;->setSelection(Landroid/text/Spannable;I)V

    return-void
.end method

.method protected left(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 5
    .parameter "widget"
    .parameter "buffer"

    .prologue
    invoke-virtual {p1}, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;

    move-result-object v0

    .local v0, layout:Landroid/text/Layout;
    invoke-static {p2}, Landroid/text/method/ArrowKeyMovementMethod;->isSelecting(Landroid/text/Spannable;)Z

    move-result v1

    if-eqz v1, :cond_f

    invoke-static {p2, v0}, Landroid/text/Selection;->extendLeft(Landroid/text/Spannable;Landroid/text/Layout;)Z

    move-result v1

    :goto_e
    return v1

    :cond_f
    invoke-static {p2, v0}, Landroid/text/Selection;->moveLeft(Landroid/text/Spannable;Landroid/text/Layout;)Z

    move-result v1

    goto :goto_e
.end method

.method protected leftWord(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 6
    .parameter "widget"
    .parameter "buffer"

    .prologue
    invoke-virtual {p1}, Landroid/widget/TextView;->getSelectionEnd()I

    move-result v0

    .local v0, selectionEnd:I
    invoke-virtual {p1}, Landroid/widget/TextView;->getWordIterator()Landroid/text/method/WordIterator;

    move-result-object v1

    .local v1, wordIterator:Landroid/text/method/WordIterator;
    invoke-virtual {v1, p2, v0, v0}, Landroid/text/method/WordIterator;->setCharSequence(Ljava/lang/CharSequence;II)V

    invoke-static {p2}, Landroid/text/method/ArrowKeyMovementMethod;->isSelecting(Landroid/text/Spannable;)Z

    move-result v2

    invoke-static {p2, v1, v2}, Landroid/text/Selection;->moveToPreceding(Landroid/text/Spannable;Landroid/text/Selection$PositionIterator;Z)Z

    move-result v2

    return v2
.end method

.method protected lineEnd(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 5
    .parameter "widget"
    .parameter "buffer"

    .prologue
    invoke-virtual {p1}, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;

    move-result-object v0

    .local v0, layout:Landroid/text/Layout;
    invoke-static {p2}, Landroid/text/method/ArrowKeyMovementMethod;->isSelecting(Landroid/text/Spannable;)Z

    move-result v1

    if-eqz v1, :cond_f

    invoke-static {p2, v0}, Landroid/text/Selection;->extendToRightEdge(Landroid/text/Spannable;Landroid/text/Layout;)Z

    move-result v1

    :goto_e
    return v1

    :cond_f
    invoke-static {p2, v0}, Landroid/text/Selection;->moveToRightEdge(Landroid/text/Spannable;Landroid/text/Layout;)Z

    move-result v1

    goto :goto_e
.end method

.method protected lineStart(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 5
    .parameter "widget"
    .parameter "buffer"

    .prologue
    invoke-virtual {p1}, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;

    move-result-object v0

    .local v0, layout:Landroid/text/Layout;
    invoke-static {p2}, Landroid/text/method/ArrowKeyMovementMethod;->isSelecting(Landroid/text/Spannable;)Z

    move-result v1

    if-eqz v1, :cond_f

    invoke-static {p2, v0}, Landroid/text/Selection;->extendToLeftEdge(Landroid/text/Spannable;Landroid/text/Layout;)Z

    move-result v1

    :goto_e
    return v1

    :cond_f
    invoke-static {p2, v0}, Landroid/text/Selection;->moveToLeftEdge(Landroid/text/Spannable;Landroid/text/Layout;)Z

    move-result v1

    goto :goto_e
.end method

.method public onTakeFocus(Landroid/widget/TextView;Landroid/text/Spannable;I)V
    .registers 5
    .parameter "view"
    .parameter "text"
    .parameter "dir"

    .prologue
    and-int/lit16 v0, p3, 0x82

    if-eqz v0, :cond_12

    invoke-virtual {p1}, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;

    move-result-object v0

    if-nez v0, :cond_11

    invoke-interface {p2}, Landroid/text/Spannable;->length()I

    move-result v0

    invoke-static {p2, v0}, Landroid/text/Selection;->setSelection(Landroid/text/Spannable;I)V

    :cond_11
    :goto_11
    return-void

    :cond_12
    invoke-interface {p2}, Landroid/text/Spannable;->length()I

    move-result v0

    invoke-static {p2, v0}, Landroid/text/Selection;->setSelection(Landroid/text/Spannable;I)V

    goto :goto_11
.end method

.method public onTouchEvent(Landroid/widget/TextView;Landroid/text/Spannable;Landroid/view/MotionEvent;)Z
    .registers 12
    .parameter "widget"
    .parameter "buffer"
    .parameter "event"

    .prologue
    const/4 v5, 0x1

    const/4 v2, -0x1

    .local v2, initialScrollX:I
    const/4 v3, -0x1

    .local v3, initialScrollY:I
    invoke-virtual {p3}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    .local v0, action:I
    if-ne v0, v5, :cond_11

    invoke-static {p1, p2}, Landroid/text/method/Touch;->getInitialScrollX(Landroid/widget/TextView;Landroid/text/Spannable;)I

    move-result v2

    invoke-static {p1, p2}, Landroid/text/method/Touch;->getInitialScrollY(Landroid/widget/TextView;Landroid/text/Spannable;)I

    move-result v3

    :cond_11
    invoke-static {p1, p2, p3}, Landroid/text/method/Touch;->onTouchEvent(Landroid/widget/TextView;Landroid/text/Spannable;Landroid/view/MotionEvent;)Z

    move-result v1

    .local v1, handled:Z
    invoke-virtual {p1}, Landroid/widget/TextView;->isFocused()Z

    move-result v6

    if-eqz v6, :cond_43

    invoke-virtual {p1}, Landroid/widget/TextView;->didTouchFocusSelect()Z

    move-result v6

    if-nez v6, :cond_43

    if-nez v0, :cond_44

    invoke-static {p2}, Landroid/text/method/ArrowKeyMovementMethod;->isSelecting(Landroid/text/Spannable;)Z

    move-result v6

    if-eqz v6, :cond_43

    invoke-virtual {p3}, Landroid/view/MotionEvent;->getX()F

    move-result v6

    invoke-virtual {p3}, Landroid/view/MotionEvent;->getY()F

    move-result v7

    invoke-virtual {p1, v6, v7}, Landroid/widget/TextView;->getOffsetForPosition(FF)I

    move-result v4

    .local v4, offset:I
    sget-object v6, Landroid/text/method/ArrowKeyMovementMethod;->LAST_TAP_DOWN:Ljava/lang/Object;

    const/16 v7, 0x22

    invoke-interface {p2, v6, v4, v4, v7}, Landroid/text/Spannable;->setSpan(Ljava/lang/Object;III)V

    invoke-virtual {p1}, Landroid/widget/TextView;->getParent()Landroid/view/ViewParent;

    move-result-object v6

    invoke-interface {v6, v5}, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V

    .end local v1           #handled:Z
    .end local v4           #offset:I
    :cond_43
    :goto_43
    return v1

    .restart local v1       #handled:Z
    :cond_44
    const/4 v6, 0x2

    if-ne v0, v6, :cond_63

    invoke-static {p2}, Landroid/text/method/ArrowKeyMovementMethod;->isSelecting(Landroid/text/Spannable;)Z

    move-result v6

    if-eqz v6, :cond_43

    if-eqz v1, :cond_43

    invoke-virtual {p1}, Landroid/widget/TextView;->cancelLongPress()V

    invoke-virtual {p3}, Landroid/view/MotionEvent;->getX()F

    move-result v6

    invoke-virtual {p3}, Landroid/view/MotionEvent;->getY()F

    move-result v7

    invoke-virtual {p1, v6, v7}, Landroid/widget/TextView;->getOffsetForPosition(FF)I

    move-result v4

    .restart local v4       #offset:I
    invoke-static {p2, v4}, Landroid/text/Selection;->extendSelection(Landroid/text/Spannable;I)V

    move v1, v5

    goto :goto_43

    .end local v4           #offset:I
    :cond_63
    if-ne v0, v5, :cond_43

    if-ltz v3, :cond_6d

    invoke-virtual {p1}, Landroid/widget/TextView;->getScrollY()I

    move-result v6

    if-ne v3, v6, :cond_75

    :cond_6d
    if-ltz v2, :cond_7a

    invoke-virtual {p1}, Landroid/widget/TextView;->getScrollX()I

    move-result v6

    if-eq v2, v6, :cond_7a

    :cond_75
    invoke-virtual {p1}, Landroid/widget/TextView;->moveCursorToVisibleOffset()Z

    move v1, v5

    goto :goto_43

    :cond_7a
    invoke-virtual {p3}, Landroid/view/MotionEvent;->getX()F

    move-result v6

    invoke-virtual {p3}, Landroid/view/MotionEvent;->getY()F

    move-result v7

    invoke-virtual {p1, v6, v7}, Landroid/widget/TextView;->getOffsetForPosition(FF)I

    move-result v4

    .restart local v4       #offset:I
    invoke-static {p2}, Landroid/text/method/ArrowKeyMovementMethod;->isSelecting(Landroid/text/Spannable;)Z

    move-result v6

    if-eqz v6, :cond_94

    sget-object v6, Landroid/text/method/ArrowKeyMovementMethod;->LAST_TAP_DOWN:Ljava/lang/Object;

    invoke-interface {p2, v6}, Landroid/text/Spannable;->removeSpan(Ljava/lang/Object;)V

    invoke-static {p2, v4}, Landroid/text/Selection;->extendSelection(Landroid/text/Spannable;I)V

    :cond_94
    invoke-static {p2}, Landroid/text/method/MetaKeyKeyListener;->adjustMetaAfterKeypress(Landroid/text/Spannable;)V

    invoke-static {p2}, Landroid/text/method/MetaKeyKeyListener;->resetLockedMeta(Landroid/text/Spannable;)V

    move v1, v5

    goto :goto_43
.end method

.method protected pageDown(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 10
    .parameter "widget"
    .parameter "buffer"

    .prologue
    invoke-virtual {p1}, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;

    move-result-object v1

    .local v1, layout:Landroid/text/Layout;
    invoke-static {p2}, Landroid/text/method/ArrowKeyMovementMethod;->isSelecting(Landroid/text/Spannable;)Z

    move-result v3

    .local v3, selecting:Z
    invoke-static {p2, v1}, Landroid/text/method/ArrowKeyMovementMethod;->getCurrentLineTop(Landroid/text/Spannable;Landroid/text/Layout;)I

    move-result v5

    invoke-static {p1}, Landroid/text/method/ArrowKeyMovementMethod;->getPageHeight(Landroid/widget/TextView;)I

    move-result v6

    add-int v4, v5, v6

    .local v4, targetY:I
    const/4 v0, 0x0

    .local v0, handled:Z
    :cond_13
    invoke-static {p2}, Landroid/text/Selection;->getSelectionEnd(Ljava/lang/CharSequence;)I

    move-result v2

    .local v2, previousSelectionEnd:I
    if-eqz v3, :cond_23

    invoke-static {p2, v1}, Landroid/text/Selection;->extendDown(Landroid/text/Spannable;Landroid/text/Layout;)Z

    :goto_1c
    invoke-static {p2}, Landroid/text/Selection;->getSelectionEnd(Ljava/lang/CharSequence;)I

    move-result v5

    if-ne v5, v2, :cond_27

    :goto_22
    return v0

    :cond_23
    invoke-static {p2, v1}, Landroid/text/Selection;->moveDown(Landroid/text/Spannable;Landroid/text/Layout;)Z

    goto :goto_1c

    :cond_27
    const/4 v0, 0x1

    invoke-static {p2, v1}, Landroid/text/method/ArrowKeyMovementMethod;->getCurrentLineTop(Landroid/text/Spannable;Landroid/text/Layout;)I

    move-result v5

    if-lt v5, v4, :cond_13

    goto :goto_22
.end method

.method protected pageUp(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 10
    .parameter "widget"
    .parameter "buffer"

    .prologue
    invoke-virtual {p1}, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;

    move-result-object v1

    .local v1, layout:Landroid/text/Layout;
    invoke-static {p2}, Landroid/text/method/ArrowKeyMovementMethod;->isSelecting(Landroid/text/Spannable;)Z

    move-result v3

    .local v3, selecting:Z
    invoke-static {p2, v1}, Landroid/text/method/ArrowKeyMovementMethod;->getCurrentLineTop(Landroid/text/Spannable;Landroid/text/Layout;)I

    move-result v5

    invoke-static {p1}, Landroid/text/method/ArrowKeyMovementMethod;->getPageHeight(Landroid/widget/TextView;)I

    move-result v6

    sub-int v4, v5, v6

    .local v4, targetY:I
    const/4 v0, 0x0

    .local v0, handled:Z
    :cond_13
    invoke-static {p2}, Landroid/text/Selection;->getSelectionEnd(Ljava/lang/CharSequence;)I

    move-result v2

    .local v2, previousSelectionEnd:I
    if-eqz v3, :cond_23

    invoke-static {p2, v1}, Landroid/text/Selection;->extendUp(Landroid/text/Spannable;Landroid/text/Layout;)Z

    :goto_1c
    invoke-static {p2}, Landroid/text/Selection;->getSelectionEnd(Ljava/lang/CharSequence;)I

    move-result v5

    if-ne v5, v2, :cond_27

    :goto_22
    return v0

    :cond_23
    invoke-static {p2, v1}, Landroid/text/Selection;->moveUp(Landroid/text/Spannable;Landroid/text/Layout;)Z

    goto :goto_1c

    :cond_27
    const/4 v0, 0x1

    invoke-static {p2, v1}, Landroid/text/method/ArrowKeyMovementMethod;->getCurrentLineTop(Landroid/text/Spannable;Landroid/text/Layout;)I

    move-result v5

    if-gt v5, v4, :cond_13

    goto :goto_22
.end method

.method protected right(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 5
    .parameter "widget"
    .parameter "buffer"

    .prologue
    invoke-virtual {p1}, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;

    move-result-object v0

    .local v0, layout:Landroid/text/Layout;
    invoke-static {p2}, Landroid/text/method/ArrowKeyMovementMethod;->isSelecting(Landroid/text/Spannable;)Z

    move-result v1

    if-eqz v1, :cond_f

    invoke-static {p2, v0}, Landroid/text/Selection;->extendRight(Landroid/text/Spannable;Landroid/text/Layout;)Z

    move-result v1

    :goto_e
    return v1

    :cond_f
    invoke-static {p2, v0}, Landroid/text/Selection;->moveRight(Landroid/text/Spannable;Landroid/text/Layout;)Z

    move-result v1

    goto :goto_e
.end method

.method protected rightWord(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 6
    .parameter "widget"
    .parameter "buffer"

    .prologue
    invoke-virtual {p1}, Landroid/widget/TextView;->getSelectionEnd()I

    move-result v0

    .local v0, selectionEnd:I
    invoke-virtual {p1}, Landroid/widget/TextView;->getWordIterator()Landroid/text/method/WordIterator;

    move-result-object v1

    .local v1, wordIterator:Landroid/text/method/WordIterator;
    invoke-virtual {v1, p2, v0, v0}, Landroid/text/method/WordIterator;->setCharSequence(Ljava/lang/CharSequence;II)V

    invoke-static {p2}, Landroid/text/method/ArrowKeyMovementMethod;->isSelecting(Landroid/text/Spannable;)Z

    move-result v2

    invoke-static {p2, v1, v2}, Landroid/text/Selection;->moveToFollowing(Landroid/text/Spannable;Landroid/text/Selection$PositionIterator;Z)Z

    move-result v2

    return v2
.end method

.method protected top(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 5
    .parameter "widget"
    .parameter "buffer"

    .prologue
    const/4 v1, 0x0

    invoke-static {p2}, Landroid/text/method/ArrowKeyMovementMethod;->isSelecting(Landroid/text/Spannable;)Z

    move-result v0

    if-eqz v0, :cond_c

    invoke-static {p2, v1}, Landroid/text/Selection;->extendSelection(Landroid/text/Spannable;I)V

    :goto_a
    const/4 v0, 0x1

    return v0

    :cond_c
    invoke-static {p2, v1}, Landroid/text/Selection;->setSelection(Landroid/text/Spannable;I)V

    goto :goto_a
.end method

.method protected up(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 5
    .parameter "widget"
    .parameter "buffer"

    .prologue
    invoke-virtual {p1}, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;

    move-result-object v0

    .local v0, layout:Landroid/text/Layout;
    invoke-static {p2}, Landroid/text/method/ArrowKeyMovementMethod;->isSelecting(Landroid/text/Spannable;)Z

    move-result v1

    if-eqz v1, :cond_f

    invoke-static {p2, v0}, Landroid/text/Selection;->extendUp(Landroid/text/Spannable;Landroid/text/Layout;)Z

    move-result v1

    :goto_e
    return v1

    :cond_f
    invoke-static {p2, v0}, Landroid/text/Selection;->moveUp(Landroid/text/Spannable;Landroid/text/Layout;)Z

    move-result v1

    goto :goto_e
.end method
