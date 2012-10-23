.class public Landroid/text/method/BaseMovementMethod;
.super Ljava/lang/Object;
.source "BaseMovementMethod.java"

# interfaces
.implements Landroid/text/method/MovementMethod;


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 29
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private getBottomLine(Landroid/widget/TextView;)I
    .registers 5
    .parameter "widget"

    .prologue
    .line 407
    invoke-virtual {p1}, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;

    move-result-object v0

    invoke-virtual {p1}, Landroid/widget/TextView;->getScrollY()I

    move-result v1

    invoke-direct {p0, p1}, Landroid/text/method/BaseMovementMethod;->getInnerHeight(Landroid/widget/TextView;)I

    move-result v2

    add-int/2addr v1, v2

    invoke-virtual {v0, v1}, Landroid/text/Layout;->getLineForVertical(I)I

    move-result v0

    return v0
.end method

.method private getCharacterWidth(Landroid/widget/TextView;)I
    .registers 4
    .parameter "widget"

    .prologue
    .line 419
    invoke-virtual {p1}, Landroid/widget/TextView;->getPaint()Landroid/text/TextPaint;

    move-result-object v0

    invoke-virtual {v0}, Landroid/text/TextPaint;->getFontSpacing()F

    move-result v0

    float-to-double v0, v0

    invoke-static {v0, v1}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v0

    double-to-int v0, v0

    return v0
.end method

.method private getInnerHeight(Landroid/widget/TextView;)I
    .registers 4
    .parameter "widget"

    .prologue
    .line 415
    invoke-virtual {p1}, Landroid/widget/TextView;->getHeight()I

    move-result v0

    invoke-virtual {p1}, Landroid/widget/TextView;->getTotalPaddingTop()I

    move-result v1

    sub-int/2addr v0, v1

    invoke-virtual {p1}, Landroid/widget/TextView;->getTotalPaddingBottom()I

    move-result v1

    sub-int/2addr v0, v1

    return v0
.end method

.method private getInnerWidth(Landroid/widget/TextView;)I
    .registers 4
    .parameter "widget"

    .prologue
    .line 411
    invoke-virtual {p1}, Landroid/widget/TextView;->getWidth()I

    move-result v0

    invoke-virtual {p1}, Landroid/widget/TextView;->getTotalPaddingLeft()I

    move-result v1

    sub-int/2addr v0, v1

    invoke-virtual {p1}, Landroid/widget/TextView;->getTotalPaddingRight()I

    move-result v1

    sub-int/2addr v0, v1

    return v0
.end method

.method private getScrollBoundsLeft(Landroid/widget/TextView;)I
    .registers 10
    .parameter "widget"

    .prologue
    .line 423
    invoke-virtual {p1}, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;

    move-result-object v1

    .line 424
    .local v1, layout:Landroid/text/Layout;
    invoke-direct {p0, p1}, Landroid/text/method/BaseMovementMethod;->getTopLine(Landroid/widget/TextView;)I

    move-result v5

    .line 425
    .local v5, topLine:I
    invoke-direct {p0, p1}, Landroid/text/method/BaseMovementMethod;->getBottomLine(Landroid/widget/TextView;)I

    move-result v0

    .line 426
    .local v0, bottomLine:I
    if-le v5, v0, :cond_10

    .line 427
    const/4 v2, 0x0

    .line 436
    :cond_f
    return v2

    .line 429
    :cond_10
    const v2, 0x7fffffff

    .line 430
    .local v2, left:I
    move v3, v5

    .local v3, line:I
    :goto_14
    if-gt v3, v0, :cond_f

    .line 431
    invoke-virtual {v1, v3}, Landroid/text/Layout;->getLineLeft(I)F

    move-result v6

    float-to-double v6, v6

    invoke-static {v6, v7}, Ljava/lang/Math;->floor(D)D

    move-result-wide v6

    double-to-int v4, v6

    .line 432
    .local v4, lineLeft:I
    if-ge v4, v2, :cond_23

    .line 433
    move v2, v4

    .line 430
    :cond_23
    add-int/lit8 v3, v3, 0x1

    goto :goto_14
.end method

.method private getScrollBoundsRight(Landroid/widget/TextView;)I
    .registers 10
    .parameter "widget"

    .prologue
    .line 440
    invoke-virtual {p1}, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;

    move-result-object v1

    .line 441
    .local v1, layout:Landroid/text/Layout;
    invoke-direct {p0, p1}, Landroid/text/method/BaseMovementMethod;->getTopLine(Landroid/widget/TextView;)I

    move-result v5

    .line 442
    .local v5, topLine:I
    invoke-direct {p0, p1}, Landroid/text/method/BaseMovementMethod;->getBottomLine(Landroid/widget/TextView;)I

    move-result v0

    .line 443
    .local v0, bottomLine:I
    if-le v5, v0, :cond_10

    .line 444
    const/4 v4, 0x0

    .line 453
    :cond_f
    return v4

    .line 446
    :cond_10
    const/high16 v4, -0x8000

    .line 447
    .local v4, right:I
    move v2, v5

    .local v2, line:I
    :goto_13
    if-gt v2, v0, :cond_f

    .line 448
    invoke-virtual {v1, v2}, Landroid/text/Layout;->getLineRight(I)F

    move-result v6

    float-to-double v6, v6

    invoke-static {v6, v7}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v6

    double-to-int v3, v6

    .line 449
    .local v3, lineRight:I
    if-le v3, v4, :cond_22

    .line 450
    move v4, v3

    .line 447
    :cond_22
    add-int/lit8 v2, v2, 0x1

    goto :goto_13
.end method

.method private getTopLine(Landroid/widget/TextView;)I
    .registers 4
    .parameter "widget"

    .prologue
    .line 403
    invoke-virtual {p1}, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;

    move-result-object v0

    invoke-virtual {p1}, Landroid/widget/TextView;->getScrollY()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/text/Layout;->getLineForVertical(I)I

    move-result v0

    return v0
.end method


# virtual methods
.method protected bottom(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 4
    .parameter "widget"
    .parameter "buffer"

    .prologue
    .line 337
    const/4 v0, 0x0

    return v0
.end method

.method public canSelectArbitrarily()Z
    .registers 2

    .prologue
    .line 32
    const/4 v0, 0x0

    return v0
.end method

.method protected down(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 4
    .parameter "widget"
    .parameter "buffer"

    .prologue
    .line 289
    const/4 v0, 0x0

    return v0
.end method

.method protected end(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 4
    .parameter "widget"
    .parameter "buffer"

    .prologue
    .line 399
    const/4 v0, 0x0

    return v0
.end method

.method protected getMovementMetaState(Landroid/text/Spannable;Landroid/view/KeyEvent;)I
    .registers 6
    .parameter "buffer"
    .parameter "event"

    .prologue
    .line 138
    invoke-virtual {p2}, Landroid/view/KeyEvent;->getMetaState()I

    move-result v1

    invoke-static {p1}, Landroid/text/method/MetaKeyKeyListener;->getMetaState(Ljava/lang/CharSequence;)I

    move-result v2

    or-int/2addr v1, v2

    and-int/lit16 v0, v1, -0x601

    .line 140
    .local v0, metaState:I
    invoke-static {v0}, Landroid/view/KeyEvent;->normalizeMetaState(I)I

    move-result v1

    and-int/lit16 v1, v1, -0xc2

    return v1
.end method

.method protected handleMovementKey(Landroid/widget/TextView;Landroid/text/Spannable;IILandroid/view/KeyEvent;)Z
    .registers 9
    .parameter "widget"
    .parameter "buffer"
    .parameter "keyCode"
    .parameter "movementMetaState"
    .parameter "event"

    .prologue
    const/16 v2, 0x1000

    const/4 v1, 0x2

    .line 162
    sparse-switch p3, :sswitch_data_d6

    .line 241
    :cond_6
    const/4 v0, 0x0

    :goto_7
    return v0

    .line 164
    :sswitch_8
    invoke-static {p4}, Landroid/view/KeyEvent;->metaStateHasNoModifiers(I)Z

    move-result v0

    if-eqz v0, :cond_13

    .line 165
    invoke-virtual {p0, p1, p2}, Landroid/text/method/BaseMovementMethod;->left(Landroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    goto :goto_7

    .line 166
    :cond_13
    invoke-static {p4, v2}, Landroid/view/KeyEvent;->metaStateHasModifiers(II)Z

    move-result v0

    if-eqz v0, :cond_1e

    .line 168
    invoke-virtual {p0, p1, p2}, Landroid/text/method/BaseMovementMethod;->leftWord(Landroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    goto :goto_7

    .line 169
    :cond_1e
    invoke-static {p4, v1}, Landroid/view/KeyEvent;->metaStateHasModifiers(II)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 171
    invoke-virtual {p0, p1, p2}, Landroid/text/method/BaseMovementMethod;->lineStart(Landroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    goto :goto_7

    .line 176
    :sswitch_29
    invoke-static {p4}, Landroid/view/KeyEvent;->metaStateHasNoModifiers(I)Z

    move-result v0

    if-eqz v0, :cond_34

    .line 177
    invoke-virtual {p0, p1, p2}, Landroid/text/method/BaseMovementMethod;->right(Landroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    goto :goto_7

    .line 178
    :cond_34
    invoke-static {p4, v2}, Landroid/view/KeyEvent;->metaStateHasModifiers(II)Z

    move-result v0

    if-eqz v0, :cond_3f

    .line 180
    invoke-virtual {p0, p1, p2}, Landroid/text/method/BaseMovementMethod;->rightWord(Landroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    goto :goto_7

    .line 181
    :cond_3f
    invoke-static {p4, v1}, Landroid/view/KeyEvent;->metaStateHasModifiers(II)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 183
    invoke-virtual {p0, p1, p2}, Landroid/text/method/BaseMovementMethod;->lineEnd(Landroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    goto :goto_7

    .line 188
    :sswitch_4a
    invoke-static {p4}, Landroid/view/KeyEvent;->metaStateHasNoModifiers(I)Z

    move-result v0

    if-eqz v0, :cond_55

    .line 189
    invoke-virtual {p0, p1, p2}, Landroid/text/method/BaseMovementMethod;->up(Landroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    goto :goto_7

    .line 190
    :cond_55
    invoke-static {p4, v1}, Landroid/view/KeyEvent;->metaStateHasModifiers(II)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 192
    invoke-virtual {p0, p1, p2}, Landroid/text/method/BaseMovementMethod;->top(Landroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    goto :goto_7

    .line 197
    :sswitch_60
    invoke-static {p4}, Landroid/view/KeyEvent;->metaStateHasNoModifiers(I)Z

    move-result v0

    if-eqz v0, :cond_6b

    .line 198
    invoke-virtual {p0, p1, p2}, Landroid/text/method/BaseMovementMethod;->down(Landroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    goto :goto_7

    .line 199
    :cond_6b
    invoke-static {p4, v1}, Landroid/view/KeyEvent;->metaStateHasModifiers(II)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 201
    invoke-virtual {p0, p1, p2}, Landroid/text/method/BaseMovementMethod;->bottom(Landroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    goto :goto_7

    .line 206
    :sswitch_76
    invoke-static {p4}, Landroid/view/KeyEvent;->metaStateHasNoModifiers(I)Z

    move-result v0

    if-eqz v0, :cond_81

    .line 207
    invoke-virtual {p0, p1, p2}, Landroid/text/method/BaseMovementMethod;->pageUp(Landroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    goto :goto_7

    .line 208
    :cond_81
    invoke-static {p4, v1}, Landroid/view/KeyEvent;->metaStateHasModifiers(II)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 210
    invoke-virtual {p0, p1, p2}, Landroid/text/method/BaseMovementMethod;->top(Landroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    goto/16 :goto_7

    .line 215
    :sswitch_8d
    invoke-static {p4}, Landroid/view/KeyEvent;->metaStateHasNoModifiers(I)Z

    move-result v0

    if-eqz v0, :cond_99

    .line 216
    invoke-virtual {p0, p1, p2}, Landroid/text/method/BaseMovementMethod;->pageDown(Landroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    goto/16 :goto_7

    .line 217
    :cond_99
    invoke-static {p4, v1}, Landroid/view/KeyEvent;->metaStateHasModifiers(II)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 219
    invoke-virtual {p0, p1, p2}, Landroid/text/method/BaseMovementMethod;->bottom(Landroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    goto/16 :goto_7

    .line 224
    :sswitch_a5
    invoke-static {p4}, Landroid/view/KeyEvent;->metaStateHasNoModifiers(I)Z

    move-result v0

    if-eqz v0, :cond_b1

    .line 225
    invoke-virtual {p0, p1, p2}, Landroid/text/method/BaseMovementMethod;->home(Landroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    goto/16 :goto_7

    .line 226
    :cond_b1
    invoke-static {p4, v2}, Landroid/view/KeyEvent;->metaStateHasModifiers(II)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 228
    invoke-virtual {p0, p1, p2}, Landroid/text/method/BaseMovementMethod;->top(Landroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    goto/16 :goto_7

    .line 233
    :sswitch_bd
    invoke-static {p4}, Landroid/view/KeyEvent;->metaStateHasNoModifiers(I)Z

    move-result v0

    if-eqz v0, :cond_c9

    .line 234
    invoke-virtual {p0, p1, p2}, Landroid/text/method/BaseMovementMethod;->end(Landroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    goto/16 :goto_7

    .line 235
    :cond_c9
    invoke-static {p4, v2}, Landroid/view/KeyEvent;->metaStateHasModifiers(II)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 237
    invoke-virtual {p0, p1, p2}, Landroid/text/method/BaseMovementMethod;->bottom(Landroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    goto/16 :goto_7

    .line 162
    nop

    :sswitch_data_d6
    .sparse-switch
        0x13 -> :sswitch_4a
        0x14 -> :sswitch_60
        0x15 -> :sswitch_8
        0x16 -> :sswitch_29
        0x5c -> :sswitch_76
        0x5d -> :sswitch_8d
        0x7a -> :sswitch_a5
        0x7b -> :sswitch_bd
    .end sparse-switch
.end method

.method protected home(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 4
    .parameter "widget"
    .parameter "buffer"

    .prologue
    .line 385
    const/4 v0, 0x0

    return v0
.end method

.method public initialize(Landroid/widget/TextView;Landroid/text/Spannable;)V
    .registers 3
    .parameter "widget"
    .parameter "text"

    .prologue
    .line 37
    return-void
.end method

.method protected left(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 4
    .parameter "widget"
    .parameter "buffer"

    .prologue
    .line 253
    const/4 v0, 0x0

    return v0
.end method

.method protected leftWord(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 4
    .parameter "widget"
    .parameter "buffer"

    .prologue
    .line 366
    const/4 v0, 0x0

    return v0
.end method

.method protected lineEnd(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 4
    .parameter "widget"
    .parameter "buffer"

    .prologue
    .line 361
    const/4 v0, 0x0

    return v0
.end method

.method protected lineStart(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 4
    .parameter "widget"
    .parameter "buffer"

    .prologue
    .line 349
    const/4 v0, 0x0

    return v0
.end method

.method public onGenericMotionEvent(Landroid/widget/TextView;Landroid/text/Spannable;Landroid/view/MotionEvent;)Z
    .registers 10
    .parameter "widget"
    .parameter "text"
    .parameter "event"

    .prologue
    const/16 v4, 0x9

    const/4 v5, 0x0

    .line 94
    invoke-virtual {p3}, Landroid/view/MotionEvent;->getSource()I

    move-result v3

    and-int/lit8 v3, v3, 0x2

    if-eqz v3, :cond_12

    .line 95
    invoke-virtual {p3}, Landroid/view/MotionEvent;->getAction()I

    move-result v3

    packed-switch v3, :pswitch_data_70

    .line 122
    :cond_12
    const/4 v0, 0x0

    :cond_13
    :goto_13
    return v0

    .line 99
    :pswitch_14
    invoke-virtual {p3}, Landroid/view/MotionEvent;->getMetaState()I

    move-result v3

    and-int/lit8 v3, v3, 0x1

    if-eqz v3, :cond_43

    .line 100
    const/4 v2, 0x0

    .line 101
    .local v2, vscroll:F
    invoke-virtual {p3, v4}, Landroid/view/MotionEvent;->getAxisValue(I)F

    move-result v1

    .line 107
    .local v1, hscroll:F
    :goto_21
    const/4 v0, 0x0

    .line 108
    .local v0, handled:Z
    cmpg-float v3, v1, v5

    if-gez v3, :cond_4f

    .line 109
    neg-float v3, v1

    float-to-double v3, v3

    invoke-static {v3, v4}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v3

    double-to-int v3, v3

    invoke-virtual {p0, p1, p2, v3}, Landroid/text/method/BaseMovementMethod;->scrollLeft(Landroid/widget/TextView;Landroid/text/Spannable;I)Z

    move-result v3

    or-int/2addr v0, v3

    .line 113
    :cond_32
    :goto_32
    cmpg-float v3, v2, v5

    if-gez v3, :cond_5f

    .line 114
    neg-float v3, v2

    float-to-double v3, v3

    invoke-static {v3, v4}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v3

    double-to-int v3, v3

    invoke-virtual {p0, p1, p2, v3}, Landroid/text/method/BaseMovementMethod;->scrollUp(Landroid/widget/TextView;Landroid/text/Spannable;I)Z

    move-result v3

    or-int/2addr v0, v3

    goto :goto_13

    .line 103
    .end local v0           #handled:Z
    .end local v1           #hscroll:F
    .end local v2           #vscroll:F
    :cond_43
    invoke-virtual {p3, v4}, Landroid/view/MotionEvent;->getAxisValue(I)F

    move-result v3

    neg-float v2, v3

    .line 104
    .restart local v2       #vscroll:F
    const/16 v3, 0xa

    invoke-virtual {p3, v3}, Landroid/view/MotionEvent;->getAxisValue(I)F

    move-result v1

    .restart local v1       #hscroll:F
    goto :goto_21

    .line 110
    .restart local v0       #handled:Z
    :cond_4f
    cmpl-float v3, v1, v5

    if-lez v3, :cond_32

    .line 111
    float-to-double v3, v1

    invoke-static {v3, v4}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v3

    double-to-int v3, v3

    invoke-virtual {p0, p1, p2, v3}, Landroid/text/method/BaseMovementMethod;->scrollRight(Landroid/widget/TextView;Landroid/text/Spannable;I)Z

    move-result v3

    or-int/2addr v0, v3

    goto :goto_32

    .line 115
    :cond_5f
    cmpl-float v3, v2, v5

    if-lez v3, :cond_13

    .line 116
    float-to-double v3, v2

    invoke-static {v3, v4}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v3

    double-to-int v3, v3

    invoke-virtual {p0, p1, p2, v3}, Landroid/text/method/BaseMovementMethod;->scrollDown(Landroid/widget/TextView;Landroid/text/Spannable;I)Z

    move-result v3

    or-int/2addr v0, v3

    goto :goto_13

    .line 95
    nop

    :pswitch_data_70
    .packed-switch 0x8
        :pswitch_14
    .end packed-switch
.end method

.method public onKeyDown(Landroid/widget/TextView;Landroid/text/Spannable;ILandroid/view/KeyEvent;)Z
    .registers 12
    .parameter "widget"
    .parameter "text"
    .parameter "keyCode"
    .parameter "event"

    .prologue
    .line 41
    invoke-virtual {p0, p2, p4}, Landroid/text/method/BaseMovementMethod;->getMovementMetaState(Landroid/text/Spannable;Landroid/view/KeyEvent;)I

    move-result v4

    .local v4, movementMetaState:I
    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move v3, p3

    move-object v5, p4

    .line 42
    invoke-virtual/range {v0 .. v5}, Landroid/text/method/BaseMovementMethod;->handleMovementKey(Landroid/widget/TextView;Landroid/text/Spannable;IILandroid/view/KeyEvent;)Z

    move-result v6

    .line 43
    .local v6, handled:Z
    if-eqz v6, :cond_15

    .line 44
    invoke-static {p2}, Landroid/text/method/MetaKeyKeyListener;->adjustMetaAfterKeypress(Landroid/text/Spannable;)V

    .line 45
    invoke-static {p2}, Landroid/text/method/MetaKeyKeyListener;->resetLockedMeta(Landroid/text/Spannable;)V

    .line 47
    :cond_15
    return v6
.end method

.method public onKeyOther(Landroid/widget/TextView;Landroid/text/Spannable;Landroid/view/KeyEvent;)Z
    .registers 13
    .parameter "widget"
    .parameter "text"
    .parameter "event"

    .prologue
    .line 52
    invoke-virtual {p0, p2, p3}, Landroid/text/method/BaseMovementMethod;->getMovementMetaState(Landroid/text/Spannable;Landroid/view/KeyEvent;)I

    move-result v4

    .line 53
    .local v4, movementMetaState:I
    invoke-virtual {p3}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v3

    .line 54
    .local v3, keyCode:I
    if-eqz v3, :cond_30

    invoke-virtual {p3}, Landroid/view/KeyEvent;->getAction()I

    move-result v0

    const/4 v1, 0x2

    if-ne v0, v1, :cond_30

    .line 56
    invoke-virtual {p3}, Landroid/view/KeyEvent;->getRepeatCount()I

    move-result v8

    .line 57
    .local v8, repeat:I
    const/4 v6, 0x0

    .line 58
    .local v6, handled:Z
    const/4 v7, 0x0

    .local v7, i:I
    :goto_17
    if-ge v7, v8, :cond_23

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v5, p3

    .line 59
    invoke-virtual/range {v0 .. v5}, Landroid/text/method/BaseMovementMethod;->handleMovementKey(Landroid/widget/TextView;Landroid/text/Spannable;IILandroid/view/KeyEvent;)Z

    move-result v0

    if-nez v0, :cond_2c

    .line 64
    :cond_23
    if-eqz v6, :cond_2b

    .line 65
    invoke-static {p2}, Landroid/text/method/MetaKeyKeyListener;->adjustMetaAfterKeypress(Landroid/text/Spannable;)V

    .line 66
    invoke-static {p2}, Landroid/text/method/MetaKeyKeyListener;->resetLockedMeta(Landroid/text/Spannable;)V

    .line 70
    .end local v6           #handled:Z
    .end local v7           #i:I
    .end local v8           #repeat:I
    :cond_2b
    :goto_2b
    return v6

    .line 62
    .restart local v6       #handled:Z
    .restart local v7       #i:I
    .restart local v8       #repeat:I
    :cond_2c
    const/4 v6, 0x1

    .line 58
    add-int/lit8 v7, v7, 0x1

    goto :goto_17

    .line 70
    .end local v6           #handled:Z
    .end local v7           #i:I
    .end local v8           #repeat:I
    :cond_30
    const/4 v6, 0x0

    goto :goto_2b
.end method

.method public onKeyUp(Landroid/widget/TextView;Landroid/text/Spannable;ILandroid/view/KeyEvent;)Z
    .registers 6
    .parameter "widget"
    .parameter "text"
    .parameter "keyCode"
    .parameter "event"

    .prologue
    .line 75
    const/4 v0, 0x0

    return v0
.end method

.method public onTakeFocus(Landroid/widget/TextView;Landroid/text/Spannable;I)V
    .registers 4
    .parameter "widget"
    .parameter "text"
    .parameter "direction"

    .prologue
    .line 80
    return-void
.end method

.method public onTouchEvent(Landroid/widget/TextView;Landroid/text/Spannable;Landroid/view/MotionEvent;)Z
    .registers 5
    .parameter "widget"
    .parameter "text"
    .parameter "event"

    .prologue
    .line 84
    const/4 v0, 0x0

    return v0
.end method

.method public onTrackballEvent(Landroid/widget/TextView;Landroid/text/Spannable;Landroid/view/MotionEvent;)Z
    .registers 5
    .parameter "widget"
    .parameter "text"
    .parameter "event"

    .prologue
    .line 89
    const/4 v0, 0x0

    return v0
.end method

.method protected pageDown(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 4
    .parameter "widget"
    .parameter "buffer"

    .prologue
    .line 313
    const/4 v0, 0x0

    return v0
.end method

.method protected pageUp(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 4
    .parameter "widget"
    .parameter "buffer"

    .prologue
    .line 301
    const/4 v0, 0x0

    return v0
.end method

.method protected right(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 4
    .parameter "widget"
    .parameter "buffer"

    .prologue
    .line 265
    const/4 v0, 0x0

    return v0
.end method

.method protected rightWord(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 4
    .parameter "widget"
    .parameter "buffer"

    .prologue
    .line 371
    const/4 v0, 0x0

    return v0
.end method

.method protected scrollBottom(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 8
    .parameter "widget"
    .parameter "buffer"

    .prologue
    .line 626
    invoke-virtual {p1}, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;

    move-result-object v0

    .line 627
    .local v0, layout:Landroid/text/Layout;
    invoke-virtual {v0}, Landroid/text/Layout;->getLineCount()I

    move-result v1

    .line 628
    .local v1, lineCount:I
    invoke-direct {p0, p1}, Landroid/text/method/BaseMovementMethod;->getBottomLine(Landroid/widget/TextView;)I

    move-result v2

    add-int/lit8 v3, v1, -0x1

    if-gt v2, v3, :cond_22

    .line 629
    invoke-virtual {p1}, Landroid/widget/TextView;->getScrollX()I

    move-result v2

    invoke-virtual {v0, v1}, Landroid/text/Layout;->getLineTop(I)I

    move-result v3

    invoke-direct {p0, p1}, Landroid/text/method/BaseMovementMethod;->getInnerHeight(Landroid/widget/TextView;)I

    move-result v4

    sub-int/2addr v3, v4

    invoke-static {p1, v0, v2, v3}, Landroid/text/method/Touch;->scrollTo(Landroid/widget/TextView;Landroid/text/Layout;II)V

    .line 631
    const/4 v2, 0x1

    .line 633
    :goto_21
    return v2

    :cond_22
    const/4 v2, 0x0

    goto :goto_21
.end method

.method protected scrollDown(Landroid/widget/TextView;Landroid/text/Spannable;I)Z
    .registers 11
    .parameter "widget"
    .parameter "buffer"
    .parameter "amount"

    .prologue
    .line 536
    invoke-virtual {p1}, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;

    move-result-object v3

    .line 537
    .local v3, layout:Landroid/text/Layout;
    invoke-direct {p0, p1}, Landroid/text/method/BaseMovementMethod;->getInnerHeight(Landroid/widget/TextView;)I

    move-result v2

    .line 538
    .local v2, innerHeight:I
    invoke-virtual {p1}, Landroid/widget/TextView;->getScrollY()I

    move-result v5

    add-int v0, v5, v2

    .line 539
    .local v0, bottom:I
    invoke-virtual {v3, v0}, Landroid/text/Layout;->getLineForVertical(I)I

    move-result v1

    .line 540
    .local v1, bottomLine:I
    add-int/lit8 v5, v1, 0x1

    invoke-virtual {v3, v5}, Landroid/text/Layout;->getLineTop(I)I

    move-result v5

    add-int/lit8 v6, v0, 0x1

    if-ge v5, v6, :cond_1e

    .line 544
    add-int/lit8 v1, v1, 0x1

    .line 546
    :cond_1e
    invoke-virtual {v3}, Landroid/text/Layout;->getLineCount()I

    move-result v5

    add-int/lit8 v4, v5, -0x1

    .line 547
    .local v4, limit:I
    if-gt v1, v4, :cond_3e

    .line 548
    add-int v5, v1, p3

    add-int/lit8 v5, v5, -0x1

    invoke-static {v5, v4}, Ljava/lang/Math;->min(II)I

    move-result v1

    .line 549
    invoke-virtual {p1}, Landroid/widget/TextView;->getScrollX()I

    move-result v5

    add-int/lit8 v6, v1, 0x1

    invoke-virtual {v3, v6}, Landroid/text/Layout;->getLineTop(I)I

    move-result v6

    sub-int/2addr v6, v2

    invoke-static {p1, v3, v5, v6}, Landroid/text/method/Touch;->scrollTo(Landroid/widget/TextView;Landroid/text/Layout;II)V

    .line 551
    const/4 v5, 0x1

    .line 553
    :goto_3d
    return v5

    :cond_3e
    const/4 v5, 0x0

    goto :goto_3d
.end method

.method protected scrollLeft(Landroid/widget/TextView;Landroid/text/Spannable;I)Z
    .registers 7
    .parameter "widget"
    .parameter "buffer"
    .parameter "amount"

    .prologue
    .line 467
    invoke-direct {p0, p1}, Landroid/text/method/BaseMovementMethod;->getScrollBoundsLeft(Landroid/widget/TextView;)I

    move-result v0

    .line 468
    .local v0, minScrollX:I
    invoke-virtual {p1}, Landroid/widget/TextView;->getScrollX()I

    move-result v1

    .line 469
    .local v1, scrollX:I
    if-le v1, v0, :cond_1e

    .line 470
    invoke-direct {p0, p1}, Landroid/text/method/BaseMovementMethod;->getCharacterWidth(Landroid/widget/TextView;)I

    move-result v2

    mul-int/2addr v2, p3

    sub-int v2, v1, v2

    invoke-static {v2, v0}, Ljava/lang/Math;->max(II)I

    move-result v1

    .line 471
    invoke-virtual {p1}, Landroid/widget/TextView;->getScrollY()I

    move-result v2

    invoke-virtual {p1, v1, v2}, Landroid/widget/TextView;->scrollTo(II)V

    .line 472
    const/4 v2, 0x1

    .line 474
    :goto_1d
    return v2

    :cond_1e
    const/4 v2, 0x0

    goto :goto_1d
.end method

.method protected scrollLineEnd(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 7
    .parameter "widget"
    .parameter "buffer"

    .prologue
    .line 665
    invoke-direct {p0, p1}, Landroid/text/method/BaseMovementMethod;->getScrollBoundsRight(Landroid/widget/TextView;)I

    move-result v2

    invoke-direct {p0, p1}, Landroid/text/method/BaseMovementMethod;->getInnerWidth(Landroid/widget/TextView;)I

    move-result v3

    sub-int v0, v2, v3

    .line 666
    .local v0, maxScrollX:I
    invoke-virtual {p1}, Landroid/widget/TextView;->getScrollX()I

    move-result v1

    .line 667
    .local v1, scrollX:I
    if-ge v1, v0, :cond_19

    .line 668
    invoke-virtual {p1}, Landroid/widget/TextView;->getScrollY()I

    move-result v2

    invoke-virtual {p1, v0, v2}, Landroid/widget/TextView;->scrollTo(II)V

    .line 669
    const/4 v2, 0x1

    .line 671
    :goto_18
    return v2

    :cond_19
    const/4 v2, 0x0

    goto :goto_18
.end method

.method protected scrollLineStart(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 6
    .parameter "widget"
    .parameter "buffer"

    .prologue
    .line 646
    invoke-direct {p0, p1}, Landroid/text/method/BaseMovementMethod;->getScrollBoundsLeft(Landroid/widget/TextView;)I

    move-result v0

    .line 647
    .local v0, minScrollX:I
    invoke-virtual {p1}, Landroid/widget/TextView;->getScrollX()I

    move-result v1

    .line 648
    .local v1, scrollX:I
    if-le v1, v0, :cond_13

    .line 649
    invoke-virtual {p1}, Landroid/widget/TextView;->getScrollY()I

    move-result v2

    invoke-virtual {p1, v0, v2}, Landroid/widget/TextView;->scrollTo(II)V

    .line 650
    const/4 v2, 0x1

    .line 652
    :goto_12
    return v2

    :cond_13
    const/4 v2, 0x0

    goto :goto_12
.end method

.method protected scrollPageDown(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 9
    .parameter "widget"
    .parameter "buffer"

    .prologue
    .line 586
    invoke-virtual {p1}, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;

    move-result-object v3

    .line 587
    .local v3, layout:Landroid/text/Layout;
    invoke-direct {p0, p1}, Landroid/text/method/BaseMovementMethod;->getInnerHeight(Landroid/widget/TextView;)I

    move-result v2

    .line 588
    .local v2, innerHeight:I
    invoke-virtual {p1}, Landroid/widget/TextView;->getScrollY()I

    move-result v4

    add-int/2addr v4, v2

    add-int v0, v4, v2

    .line 589
    .local v0, bottom:I
    invoke-virtual {v3, v0}, Landroid/text/Layout;->getLineForVertical(I)I

    move-result v1

    .line 590
    .local v1, bottomLine:I
    invoke-virtual {v3}, Landroid/text/Layout;->getLineCount()I

    move-result v4

    add-int/lit8 v4, v4, -0x1

    if-gt v1, v4, :cond_2b

    .line 591
    invoke-virtual {p1}, Landroid/widget/TextView;->getScrollX()I

    move-result v4

    add-int/lit8 v5, v1, 0x1

    invoke-virtual {v3, v5}, Landroid/text/Layout;->getLineTop(I)I

    move-result v5

    sub-int/2addr v5, v2

    invoke-static {p1, v3, v4, v5}, Landroid/text/method/Touch;->scrollTo(Landroid/widget/TextView;Landroid/text/Layout;II)V

    .line 593
    const/4 v4, 0x1

    .line 595
    :goto_2a
    return v4

    :cond_2b
    const/4 v4, 0x0

    goto :goto_2a
.end method

.method protected scrollPageUp(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 8
    .parameter "widget"
    .parameter "buffer"

    .prologue
    .line 566
    invoke-virtual {p1}, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;

    move-result-object v0

    .line 567
    .local v0, layout:Landroid/text/Layout;
    invoke-virtual {p1}, Landroid/widget/TextView;->getScrollY()I

    move-result v3

    invoke-direct {p0, p1}, Landroid/text/method/BaseMovementMethod;->getInnerHeight(Landroid/widget/TextView;)I

    move-result v4

    sub-int v1, v3, v4

    .line 568
    .local v1, top:I
    invoke-virtual {v0, v1}, Landroid/text/Layout;->getLineForVertical(I)I

    move-result v2

    .line 569
    .local v2, topLine:I
    if-ltz v2, :cond_21

    .line 570
    invoke-virtual {p1}, Landroid/widget/TextView;->getScrollX()I

    move-result v3

    invoke-virtual {v0, v2}, Landroid/text/Layout;->getLineTop(I)I

    move-result v4

    invoke-static {p1, v0, v3, v4}, Landroid/text/method/Touch;->scrollTo(Landroid/widget/TextView;Landroid/text/Layout;II)V

    .line 571
    const/4 v3, 0x1

    .line 573
    :goto_20
    return v3

    :cond_21
    const/4 v3, 0x0

    goto :goto_20
.end method

.method protected scrollRight(Landroid/widget/TextView;Landroid/text/Spannable;I)Z
    .registers 8
    .parameter "widget"
    .parameter "buffer"
    .parameter "amount"

    .prologue
    .line 488
    invoke-direct {p0, p1}, Landroid/text/method/BaseMovementMethod;->getScrollBoundsRight(Landroid/widget/TextView;)I

    move-result v2

    invoke-direct {p0, p1}, Landroid/text/method/BaseMovementMethod;->getInnerWidth(Landroid/widget/TextView;)I

    move-result v3

    sub-int v0, v2, v3

    .line 489
    .local v0, maxScrollX:I
    invoke-virtual {p1}, Landroid/widget/TextView;->getScrollX()I

    move-result v1

    .line 490
    .local v1, scrollX:I
    if-ge v1, v0, :cond_23

    .line 491
    invoke-direct {p0, p1}, Landroid/text/method/BaseMovementMethod;->getCharacterWidth(Landroid/widget/TextView;)I

    move-result v2

    mul-int/2addr v2, p3

    add-int/2addr v2, v1

    invoke-static {v2, v0}, Ljava/lang/Math;->min(II)I

    move-result v1

    .line 492
    invoke-virtual {p1}, Landroid/widget/TextView;->getScrollY()I

    move-result v2

    invoke-virtual {p1, v1, v2}, Landroid/widget/TextView;->scrollTo(II)V

    .line 493
    const/4 v2, 0x1

    .line 495
    :goto_22
    return v2

    :cond_23
    const/4 v2, 0x0

    goto :goto_22
.end method

.method protected scrollTop(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 6
    .parameter "widget"
    .parameter "buffer"

    .prologue
    const/4 v1, 0x0

    .line 608
    invoke-virtual {p1}, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;

    move-result-object v0

    .line 609
    .local v0, layout:Landroid/text/Layout;
    invoke-direct {p0, p1}, Landroid/text/method/BaseMovementMethod;->getTopLine(Landroid/widget/TextView;)I

    move-result v2

    if-ltz v2, :cond_17

    .line 610
    invoke-virtual {p1}, Landroid/widget/TextView;->getScrollX()I

    move-result v2

    invoke-virtual {v0, v1}, Landroid/text/Layout;->getLineTop(I)I

    move-result v1

    invoke-static {p1, v0, v2, v1}, Landroid/text/method/Touch;->scrollTo(Landroid/widget/TextView;Landroid/text/Layout;II)V

    .line 611
    const/4 v1, 0x1

    .line 613
    :cond_17
    return v1
.end method

.method protected scrollUp(Landroid/widget/TextView;Landroid/text/Spannable;I)Z
    .registers 9
    .parameter "widget"
    .parameter "buffer"
    .parameter "amount"

    .prologue
    const/4 v3, 0x0

    .line 509
    invoke-virtual {p1}, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;

    move-result-object v0

    .line 510
    .local v0, layout:Landroid/text/Layout;
    invoke-virtual {p1}, Landroid/widget/TextView;->getScrollY()I

    move-result v1

    .line 511
    .local v1, top:I
    invoke-virtual {v0, v1}, Landroid/text/Layout;->getLineForVertical(I)I

    move-result v2

    .line 512
    .local v2, topLine:I
    invoke-virtual {v0, v2}, Landroid/text/Layout;->getLineTop(I)I

    move-result v4

    if-ne v4, v1, :cond_15

    .line 515
    add-int/lit8 v2, v2, -0x1

    .line 517
    :cond_15
    if-ltz v2, :cond_2b

    .line 518
    sub-int v4, v2, p3

    add-int/lit8 v4, v4, 0x1

    invoke-static {v4, v3}, Ljava/lang/Math;->max(II)I

    move-result v2

    .line 519
    invoke-virtual {p1}, Landroid/widget/TextView;->getScrollX()I

    move-result v3

    invoke-virtual {v0, v2}, Landroid/text/Layout;->getLineTop(I)I

    move-result v4

    invoke-static {p1, v0, v3, v4}, Landroid/text/method/Touch;->scrollTo(Landroid/widget/TextView;Landroid/text/Layout;II)V

    .line 520
    const/4 v3, 0x1

    .line 522
    :cond_2b
    return v3
.end method

.method protected top(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 4
    .parameter "widget"
    .parameter "buffer"

    .prologue
    .line 325
    const/4 v0, 0x0

    return v0
.end method

.method protected up(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 4
    .parameter "widget"
    .parameter "buffer"

    .prologue
    .line 277
    const/4 v0, 0x0

    return v0
.end method
