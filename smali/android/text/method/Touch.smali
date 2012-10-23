.class public Landroid/text/method/Touch;
.super Ljava/lang/Object;
.source "Touch.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/text/method/Touch$DragState;
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .registers 1

    .prologue
    .line 29
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getInitialScrollX(Landroid/widget/TextView;Landroid/text/Spannable;)I
    .registers 6
    .parameter "widget"
    .parameter "buffer"

    .prologue
    const/4 v3, 0x0

    .line 182
    invoke-interface {p1}, Landroid/text/Spannable;->length()I

    move-result v1

    const-class v2, Landroid/text/method/Touch$DragState;

    invoke-interface {p1, v3, v1, v2}, Landroid/text/Spannable;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroid/text/method/Touch$DragState;

    .line 183
    .local v0, ds:[Landroid/text/method/Touch$DragState;
    array-length v1, v0

    if-lez v1, :cond_15

    aget-object v1, v0, v3

    iget v1, v1, Landroid/text/method/Touch$DragState;->mScrollX:I

    :goto_14
    return v1

    :cond_15
    const/4 v1, -0x1

    goto :goto_14
.end method

.method public static getInitialScrollY(Landroid/widget/TextView;Landroid/text/Spannable;)I
    .registers 6
    .parameter "widget"
    .parameter "buffer"

    .prologue
    const/4 v3, 0x0

    .line 191
    invoke-interface {p1}, Landroid/text/Spannable;->length()I

    move-result v1

    const-class v2, Landroid/text/method/Touch$DragState;

    invoke-interface {p1, v3, v1, v2}, Landroid/text/Spannable;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroid/text/method/Touch$DragState;

    .line 192
    .local v0, ds:[Landroid/text/method/Touch$DragState;
    array-length v1, v0

    if-lez v1, :cond_15

    aget-object v1, v0, v3

    iget v1, v1, Landroid/text/method/Touch$DragState;->mScrollY:I

    :goto_14
    return v1

    :cond_15
    const/4 v1, -0x1

    goto :goto_14
.end method

.method public static onTouchEvent(Landroid/widget/TextView;Landroid/text/Spannable;Landroid/view/MotionEvent;)Z
    .registers 25
    .parameter "widget"
    .parameter "buffer"
    .parameter "event"

    .prologue
    .line 90
    invoke-virtual/range {p2 .. p2}, Landroid/view/MotionEvent;->getActionMasked()I

    move-result v17

    packed-switch v17, :pswitch_data_21c

    .line 174
    :cond_7
    const/16 v17, 0x0

    :goto_9
    return v17

    .line 92
    :pswitch_a
    const/16 v17, 0x0

    invoke-interface/range {p1 .. p1}, Landroid/text/Spannable;->length()I

    move-result v18

    const-class v19, Landroid/text/method/Touch$DragState;

    move-object/from16 v0, p1

    move/from16 v1, v17

    move/from16 v2, v18

    move-object/from16 v3, v19

    invoke-interface {v0, v1, v2, v3}, Landroid/text/Spannable;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v6

    check-cast v6, [Landroid/text/method/Touch$DragState;

    .line 94
    .local v6, ds:[Landroid/text/method/Touch$DragState;
    const/4 v9, 0x0

    .local v9, i:I
    :goto_21
    array-length v0, v6

    move/from16 v17, v0

    move/from16 v0, v17

    if-ge v9, v0, :cond_34

    .line 95
    aget-object v17, v6, v9

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    invoke-interface {v0, v1}, Landroid/text/Spannable;->removeSpan(Ljava/lang/Object;)V

    .line 94
    add-int/lit8 v9, v9, 0x1

    goto :goto_21

    .line 98
    :cond_34
    new-instance v17, Landroid/text/method/Touch$DragState;

    invoke-virtual/range {p2 .. p2}, Landroid/view/MotionEvent;->getX()F

    move-result v18

    invoke-virtual/range {p2 .. p2}, Landroid/view/MotionEvent;->getY()F

    move-result v19

    invoke-virtual/range {p0 .. p0}, Landroid/widget/TextView;->getScrollX()I

    move-result v20

    invoke-virtual/range {p0 .. p0}, Landroid/widget/TextView;->getScrollY()I

    move-result v21

    invoke-direct/range {v17 .. v21}, Landroid/text/method/Touch$DragState;-><init>(FFII)V

    const/16 v18, 0x0

    const/16 v19, 0x0

    const/16 v20, 0x11

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    move/from16 v2, v18

    move/from16 v3, v19

    move/from16 v4, v20

    invoke-interface {v0, v1, v2, v3, v4}, Landroid/text/Spannable;->setSpan(Ljava/lang/Object;III)V

    .line 101
    const/16 v17, 0x1

    goto :goto_9

    .line 104
    .end local v6           #ds:[Landroid/text/method/Touch$DragState;
    .end local v9           #i:I
    :pswitch_5f
    const/16 v17, 0x0

    invoke-interface/range {p1 .. p1}, Landroid/text/Spannable;->length()I

    move-result v18

    const-class v19, Landroid/text/method/Touch$DragState;

    move-object/from16 v0, p1

    move/from16 v1, v17

    move/from16 v2, v18

    move-object/from16 v3, v19

    invoke-interface {v0, v1, v2, v3}, Landroid/text/Spannable;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v6

    check-cast v6, [Landroid/text/method/Touch$DragState;

    .line 106
    .restart local v6       #ds:[Landroid/text/method/Touch$DragState;
    const/4 v9, 0x0

    .restart local v9       #i:I
    :goto_76
    array-length v0, v6

    move/from16 v17, v0

    move/from16 v0, v17

    if-ge v9, v0, :cond_89

    .line 107
    aget-object v17, v6, v9

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    invoke-interface {v0, v1}, Landroid/text/Spannable;->removeSpan(Ljava/lang/Object;)V

    .line 106
    add-int/lit8 v9, v9, 0x1

    goto :goto_76

    .line 110
    :cond_89
    array-length v0, v6

    move/from16 v17, v0

    if-lez v17, :cond_9e

    const/16 v17, 0x0

    aget-object v17, v6, v17

    move-object/from16 v0, v17

    iget-boolean v0, v0, Landroid/text/method/Touch$DragState;->mUsed:Z

    move/from16 v17, v0

    if-eqz v17, :cond_9e

    .line 111
    const/16 v17, 0x1

    goto/16 :goto_9

    .line 113
    :cond_9e
    const/16 v17, 0x0

    goto/16 :goto_9

    .line 117
    .end local v6           #ds:[Landroid/text/method/Touch$DragState;
    .end local v9           #i:I
    :pswitch_a2
    const/16 v17, 0x0

    invoke-interface/range {p1 .. p1}, Landroid/text/Spannable;->length()I

    move-result v18

    const-class v19, Landroid/text/method/Touch$DragState;

    move-object/from16 v0, p1

    move/from16 v1, v17

    move/from16 v2, v18

    move-object/from16 v3, v19

    invoke-interface {v0, v1, v2, v3}, Landroid/text/Spannable;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v6

    check-cast v6, [Landroid/text/method/Touch$DragState;

    .line 119
    .restart local v6       #ds:[Landroid/text/method/Touch$DragState;
    array-length v0, v6

    move/from16 v17, v0

    if-lez v17, :cond_7

    .line 120
    const/16 v17, 0x0

    aget-object v17, v6, v17

    move-object/from16 v0, v17

    iget-boolean v0, v0, Landroid/text/method/Touch$DragState;->mFarEnough:Z

    move/from16 v17, v0

    if-nez v17, :cond_11b

    .line 121
    invoke-virtual/range {p0 .. p0}, Landroid/widget/TextView;->getContext()Landroid/content/Context;

    move-result-object v17

    invoke-static/range {v17 .. v17}, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Landroid/view/ViewConfiguration;->getScaledTouchSlop()I

    move-result v16

    .line 123
    .local v16, slop:I
    invoke-virtual/range {p2 .. p2}, Landroid/view/MotionEvent;->getX()F

    move-result v17

    const/16 v18, 0x0

    aget-object v18, v6, v18

    move-object/from16 v0, v18

    iget v0, v0, Landroid/text/method/Touch$DragState;->mX:F

    move/from16 v18, v0

    sub-float v17, v17, v18

    invoke-static/range {v17 .. v17}, Ljava/lang/Math;->abs(F)F

    move-result v17

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v18, v0

    cmpl-float v17, v17, v18

    if-gez v17, :cond_10f

    invoke-virtual/range {p2 .. p2}, Landroid/view/MotionEvent;->getY()F

    move-result v17

    const/16 v18, 0x0

    aget-object v18, v6, v18

    move-object/from16 v0, v18

    iget v0, v0, Landroid/text/method/Touch$DragState;->mY:F

    move/from16 v18, v0

    sub-float v17, v17, v18

    invoke-static/range {v17 .. v17}, Ljava/lang/Math;->abs(F)F

    move-result v17

    move/from16 v0, v16

    int-to-float v0, v0

    move/from16 v18, v0

    cmpl-float v17, v17, v18

    if-ltz v17, :cond_11b

    .line 125
    :cond_10f
    const/16 v17, 0x0

    aget-object v17, v6, v17

    const/16 v18, 0x1

    move/from16 v0, v18

    move-object/from16 v1, v17

    iput-boolean v0, v1, Landroid/text/method/Touch$DragState;->mFarEnough:Z

    .line 129
    .end local v16           #slop:I
    :cond_11b
    const/16 v17, 0x0

    aget-object v17, v6, v17

    move-object/from16 v0, v17

    iget-boolean v0, v0, Landroid/text/method/Touch$DragState;->mFarEnough:Z

    move/from16 v17, v0

    if-eqz v17, :cond_7

    .line 130
    const/16 v17, 0x0

    aget-object v17, v6, v17

    const/16 v18, 0x1

    move/from16 v0, v18

    move-object/from16 v1, v17

    iput-boolean v0, v1, Landroid/text/method/Touch$DragState;->mUsed:Z

    .line 131
    invoke-virtual/range {p2 .. p2}, Landroid/view/MotionEvent;->getMetaState()I

    move-result v17

    and-int/lit8 v17, v17, 0x1

    if-nez v17, :cond_159

    const/16 v17, 0x1

    move-object/from16 v0, p1

    move/from16 v1, v17

    invoke-static {v0, v1}, Landroid/text/method/MetaKeyKeyListener;->getMetaState(Ljava/lang/CharSequence;I)I

    move-result v17

    const/16 v18, 0x1

    move/from16 v0, v17

    move/from16 v1, v18

    if-eq v0, v1, :cond_159

    const/16 v17, 0x800

    move-object/from16 v0, p1

    move/from16 v1, v17

    invoke-static {v0, v1}, Landroid/text/method/MetaKeyKeyListener;->getMetaState(Ljava/lang/CharSequence;I)I

    move-result v17

    if-eqz v17, :cond_1f6

    :cond_159
    const/4 v5, 0x1

    .line 138
    .local v5, cap:Z
    :goto_15a
    if-eqz v5, :cond_1f9

    .line 141
    invoke-virtual/range {p2 .. p2}, Landroid/view/MotionEvent;->getX()F

    move-result v17

    const/16 v18, 0x0

    aget-object v18, v6, v18

    move-object/from16 v0, v18

    iget v0, v0, Landroid/text/method/Touch$DragState;->mX:F

    move/from16 v18, v0

    sub-float v7, v17, v18

    .line 142
    .local v7, dx:F
    invoke-virtual/range {p2 .. p2}, Landroid/view/MotionEvent;->getY()F

    move-result v17

    const/16 v18, 0x0

    aget-object v18, v6, v18

    move-object/from16 v0, v18

    iget v0, v0, Landroid/text/method/Touch$DragState;->mY:F

    move/from16 v18, v0

    sub-float v8, v17, v18

    .line 147
    .local v8, dy:F
    :goto_17c
    const/16 v17, 0x0

    aget-object v17, v6, v17

    invoke-virtual/range {p2 .. p2}, Landroid/view/MotionEvent;->getX()F

    move-result v18

    move/from16 v0, v18

    move-object/from16 v1, v17

    iput v0, v1, Landroid/text/method/Touch$DragState;->mX:F

    .line 148
    const/16 v17, 0x0

    aget-object v17, v6, v17

    invoke-virtual/range {p2 .. p2}, Landroid/view/MotionEvent;->getY()F

    move-result v18

    move/from16 v0, v18

    move-object/from16 v1, v17

    iput v0, v1, Landroid/text/method/Touch$DragState;->mY:F

    .line 150
    invoke-virtual/range {p0 .. p0}, Landroid/widget/TextView;->getScrollX()I

    move-result v17

    float-to-int v0, v7

    move/from16 v18, v0

    add-int v11, v17, v18

    .line 151
    .local v11, nx:I
    invoke-virtual/range {p0 .. p0}, Landroid/widget/TextView;->getScrollY()I

    move-result v17

    float-to-int v0, v8

    move/from16 v18, v0

    add-int v12, v17, v18

    .line 153
    .local v12, ny:I
    invoke-virtual/range {p0 .. p0}, Landroid/widget/TextView;->getTotalPaddingTop()I

    move-result v17

    invoke-virtual/range {p0 .. p0}, Landroid/widget/TextView;->getTotalPaddingBottom()I

    move-result v18

    add-int v15, v17, v18

    .line 154
    .local v15, padding:I
    invoke-virtual/range {p0 .. p0}, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;

    move-result-object v10

    .line 156
    .local v10, layout:Landroid/text/Layout;
    invoke-virtual {v10}, Landroid/text/Layout;->getHeight()I

    move-result v17

    invoke-virtual/range {p0 .. p0}, Landroid/widget/TextView;->getHeight()I

    move-result v18

    sub-int v18, v18, v15

    sub-int v17, v17, v18

    move/from16 v0, v17

    invoke-static {v12, v0}, Ljava/lang/Math;->min(II)I

    move-result v12

    .line 157
    const/16 v17, 0x0

    move/from16 v0, v17

    invoke-static {v12, v0}, Ljava/lang/Math;->max(II)I

    move-result v12

    .line 159
    invoke-virtual/range {p0 .. p0}, Landroid/widget/TextView;->getScrollX()I

    move-result v13

    .line 160
    .local v13, oldX:I
    invoke-virtual/range {p0 .. p0}, Landroid/widget/TextView;->getScrollY()I

    move-result v14

    .line 162
    .local v14, oldY:I
    move-object/from16 v0, p0

    invoke-static {v0, v10, v11, v12}, Landroid/text/method/Touch;->scrollTo(Landroid/widget/TextView;Landroid/text/Layout;II)V

    .line 165
    invoke-virtual/range {p0 .. p0}, Landroid/widget/TextView;->getScrollX()I

    move-result v17

    move/from16 v0, v17

    if-ne v13, v0, :cond_1ef

    invoke-virtual/range {p0 .. p0}, Landroid/widget/TextView;->getScrollY()I

    move-result v17

    move/from16 v0, v17

    if-eq v14, v0, :cond_1f2

    .line 166
    :cond_1ef
    invoke-virtual/range {p0 .. p0}, Landroid/widget/TextView;->cancelLongPress()V

    .line 169
    :cond_1f2
    const/16 v17, 0x1

    goto/16 :goto_9

    .line 131
    .end local v5           #cap:Z
    .end local v7           #dx:F
    .end local v8           #dy:F
    .end local v10           #layout:Landroid/text/Layout;
    .end local v11           #nx:I
    .end local v12           #ny:I
    .end local v13           #oldX:I
    .end local v14           #oldY:I
    .end local v15           #padding:I
    :cond_1f6
    const/4 v5, 0x0

    goto/16 :goto_15a

    .line 144
    .restart local v5       #cap:Z
    :cond_1f9
    const/16 v17, 0x0

    aget-object v17, v6, v17

    move-object/from16 v0, v17

    iget v0, v0, Landroid/text/method/Touch$DragState;->mX:F

    move/from16 v17, v0

    invoke-virtual/range {p2 .. p2}, Landroid/view/MotionEvent;->getX()F

    move-result v18

    sub-float v7, v17, v18

    .line 145
    .restart local v7       #dx:F
    const/16 v17, 0x0

    aget-object v17, v6, v17

    move-object/from16 v0, v17

    iget v0, v0, Landroid/text/method/Touch$DragState;->mY:F

    move/from16 v17, v0

    invoke-virtual/range {p2 .. p2}, Landroid/view/MotionEvent;->getY()F

    move-result v18

    sub-float v8, v17, v18

    .restart local v8       #dy:F
    goto/16 :goto_17c

    .line 90
    nop

    :pswitch_data_21c
    .packed-switch 0x0
        :pswitch_a
        :pswitch_5f
        :pswitch_a2
    .end packed-switch
.end method

.method public static scrollTo(Landroid/widget/TextView;Landroid/text/Layout;II)V
    .registers 19
    .parameter "widget"
    .parameter "layout"
    .parameter "x"
    .parameter "y"

    .prologue
    .line 38
    invoke-virtual {p0}, Landroid/widget/TextView;->getTotalPaddingLeft()I

    move-result v13

    invoke-virtual {p0}, Landroid/widget/TextView;->getTotalPaddingRight()I

    move-result v14

    add-int v6, v13, v14

    .line 39
    .local v6, horizontalPadding:I
    invoke-virtual {p0}, Landroid/widget/TextView;->getWidth()I

    move-result v13

    sub-int v4, v13, v6

    .line 41
    .local v4, availableWidth:I
    move-object/from16 v0, p1

    move/from16 v1, p3

    invoke-virtual {v0, v1}, Landroid/text/Layout;->getLineForVertical(I)I

    move-result v11

    .line 42
    .local v11, top:I
    move-object/from16 v0, p1

    invoke-virtual {v0, v11}, Landroid/text/Layout;->getParagraphAlignment(I)Landroid/text/Layout$Alignment;

    move-result-object v2

    .line 43
    .local v2, a:Landroid/text/Layout$Alignment;
    move-object/from16 v0, p1

    invoke-virtual {v0, v11}, Landroid/text/Layout;->getParagraphDirection(I)I

    move-result v13

    if-lez v13, :cond_66

    const/4 v9, 0x1

    .line 46
    .local v9, ltr:Z
    :goto_27
    invoke-virtual {p0}, Landroid/widget/TextView;->getHorizontallyScrolling()Z

    move-result v13

    if-eqz v13, :cond_68

    .line 47
    invoke-virtual {p0}, Landroid/widget/TextView;->getTotalPaddingTop()I

    move-result v13

    invoke-virtual {p0}, Landroid/widget/TextView;->getTotalPaddingBottom()I

    move-result v14

    add-int v12, v13, v14

    .line 48
    .local v12, verticalPadding:I
    invoke-virtual {p0}, Landroid/widget/TextView;->getHeight()I

    move-result v13

    add-int v13, v13, p3

    sub-int/2addr v13, v12

    move-object/from16 v0, p1

    invoke-virtual {v0, v13}, Landroid/text/Layout;->getLineForVertical(I)I

    move-result v5

    .line 50
    .local v5, bottom:I
    const v8, 0x7fffffff

    .line 51
    .local v8, left:I
    const/4 v10, 0x0

    .line 53
    .local v10, right:I
    move v7, v11

    .local v7, i:I
    :goto_49
    if-gt v7, v5, :cond_6a

    .line 54
    int-to-float v13, v8

    move-object/from16 v0, p1

    invoke-virtual {v0, v7}, Landroid/text/Layout;->getLineLeft(I)F

    move-result v14

    invoke-static {v13, v14}, Ljava/lang/Math;->min(FF)F

    move-result v13

    float-to-int v8, v13

    .line 55
    int-to-float v13, v10

    move-object/from16 v0, p1

    invoke-virtual {v0, v7}, Landroid/text/Layout;->getLineRight(I)F

    move-result v14

    invoke-static {v13, v14}, Ljava/lang/Math;->max(FF)F

    move-result v13

    float-to-int v10, v13

    .line 53
    add-int/lit8 v7, v7, 0x1

    goto :goto_49

    .line 43
    .end local v5           #bottom:I
    .end local v7           #i:I
    .end local v8           #left:I
    .end local v9           #ltr:Z
    .end local v10           #right:I
    .end local v12           #verticalPadding:I
    :cond_66
    const/4 v9, 0x0

    goto :goto_27

    .line 58
    .restart local v9       #ltr:Z
    :cond_68
    const/4 v8, 0x0

    .line 59
    .restart local v8       #left:I
    move v10, v4

    .line 62
    .restart local v10       #right:I
    :cond_6a
    sub-int v3, v10, v8

    .line 64
    .local v3, actualWidth:I
    if-ge v3, v4, :cond_92

    .line 65
    sget-object v13, Landroid/text/Layout$Alignment;->ALIGN_CENTER:Landroid/text/Layout$Alignment;

    if-ne v2, v13, :cond_80

    .line 66
    sub-int v13, v4, v3

    div-int/lit8 v13, v13, 0x2

    sub-int p2, v8, v13

    .line 79
    :goto_78
    move/from16 v0, p2

    move/from16 v1, p3

    invoke-virtual {p0, v0, v1}, Landroid/widget/TextView;->scrollTo(II)V

    .line 80
    return-void

    .line 67
    :cond_80
    if-eqz v9, :cond_86

    sget-object v13, Landroid/text/Layout$Alignment;->ALIGN_OPPOSITE:Landroid/text/Layout$Alignment;

    if-eq v2, v13, :cond_8a

    :cond_86
    sget-object v13, Landroid/text/Layout$Alignment;->ALIGN_RIGHT:Landroid/text/Layout$Alignment;

    if-ne v2, v13, :cond_8f

    .line 70
    :cond_8a
    sub-int v13, v4, v3

    sub-int p2, v8, v13

    goto :goto_78

    .line 72
    :cond_8f
    move/from16 p2, v8

    goto :goto_78

    .line 75
    :cond_92
    sub-int v13, v10, v4

    move/from16 v0, p2

    invoke-static {v0, v13}, Ljava/lang/Math;->min(II)I

    move-result p2

    .line 76
    move/from16 v0, p2

    invoke-static {v0, v8}, Ljava/lang/Math;->max(II)I

    move-result p2

    goto :goto_78
.end method
