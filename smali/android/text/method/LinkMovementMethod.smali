.class public Landroid/text/method/LinkMovementMethod;
.super Landroid/text/method/ScrollingMovementMethod;
.source "LinkMovementMethod.java"


# static fields
.field private static final CLICK:I = 0x1

.field private static final DOWN:I = 0x3

.field private static FROM_BELOW:Ljava/lang/Object; = null

.field private static final UP:I = 0x2

.field private static sInstance:Landroid/text/method/LinkMovementMethod;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 253
    new-instance v0, Landroid/text/NoCopySpan$Concrete;

    invoke-direct {v0}, Landroid/text/NoCopySpan$Concrete;-><init>()V

    sput-object v0, Landroid/text/method/LinkMovementMethod;->FROM_BELOW:Ljava/lang/Object;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 33
    invoke-direct {p0}, Landroid/text/method/ScrollingMovementMethod;-><init>()V

    return-void
.end method

.method private action(ILandroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 29
    .parameter "what"
    .parameter "widget"
    .parameter "buffer"

    .prologue
    .line 92
    invoke-virtual/range {p2 .. p2}, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;

    move-result-object v15

    .line 94
    .local v15, layout:Landroid/text/Layout;
    invoke-virtual/range {p2 .. p2}, Landroid/widget/TextView;->getTotalPaddingTop()I

    move-result v23

    invoke-virtual/range {p2 .. p2}, Landroid/widget/TextView;->getTotalPaddingBottom()I

    move-result v24

    add-int v19, v23, v24

    .line 96
    .local v19, padding:I
    invoke-virtual/range {p2 .. p2}, Landroid/widget/TextView;->getScrollY()I

    move-result v6

    .line 97
    .local v6, areatop:I
    invoke-virtual/range {p2 .. p2}, Landroid/widget/TextView;->getHeight()I

    move-result v23

    add-int v23, v23, v6

    sub-int v5, v23, v19

    .line 99
    .local v5, areabot:I
    invoke-virtual {v15, v6}, Landroid/text/Layout;->getLineForVertical(I)I

    move-result v17

    .line 100
    .local v17, linetop:I
    invoke-virtual {v15, v5}, Landroid/text/Layout;->getLineForVertical(I)I

    move-result v16

    .line 102
    .local v16, linebot:I
    move/from16 v0, v17

    invoke-virtual {v15, v0}, Landroid/text/Layout;->getLineStart(I)I

    move-result v12

    .line 103
    .local v12, first:I
    invoke-virtual/range {v15 .. v16}, Landroid/text/Layout;->getLineEnd(I)I

    move-result v14

    .line 105
    .local v14, last:I
    const-class v23, Landroid/text/style/ClickableSpan;

    move-object/from16 v0, p3

    move-object/from16 v1, v23

    invoke-interface {v0, v12, v14, v1}, Landroid/text/Spannable;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v10

    check-cast v10, [Landroid/text/style/ClickableSpan;

    .line 107
    .local v10, candidates:[Landroid/text/style/ClickableSpan;
    invoke-static/range {p3 .. p3}, Landroid/text/Selection;->getSelectionStart(Ljava/lang/CharSequence;)I

    move-result v4

    .line 108
    .local v4, a:I
    invoke-static/range {p3 .. p3}, Landroid/text/Selection;->getSelectionEnd(Ljava/lang/CharSequence;)I

    move-result v7

    .line 110
    .local v7, b:I
    invoke-static {v4, v7}, Ljava/lang/Math;->min(II)I

    move-result v21

    .line 111
    .local v21, selStart:I
    invoke-static {v4, v7}, Ljava/lang/Math;->max(II)I

    move-result v20

    .line 113
    .local v20, selEnd:I
    if-gez v21, :cond_5c

    .line 114
    sget-object v23, Landroid/text/method/LinkMovementMethod;->FROM_BELOW:Ljava/lang/Object;

    move-object/from16 v0, p3

    move-object/from16 v1, v23

    invoke-interface {v0, v1}, Landroid/text/Spannable;->getSpanStart(Ljava/lang/Object;)I

    move-result v23

    if-ltz v23, :cond_5c

    .line 115
    invoke-interface/range {p3 .. p3}, Landroid/text/Spannable;->length()I

    move-result v20

    move/from16 v21, v20

    .line 119
    :cond_5c
    move/from16 v0, v21

    if-le v0, v14, :cond_65

    .line 120
    const v20, 0x7fffffff

    move/from16 v21, v20

    .line 121
    :cond_65
    move/from16 v0, v20

    if-ge v0, v12, :cond_6d

    .line 122
    const/16 v20, -0x1

    move/from16 v21, v20

    .line 124
    :cond_6d
    packed-switch p1, :pswitch_data_128

    .line 185
    :cond_70
    :goto_70
    const/16 v23, 0x0

    :goto_72
    return v23

    .line 126
    :pswitch_73
    move/from16 v0, v21

    move/from16 v1, v20

    if-ne v0, v1, :cond_7c

    .line 127
    const/16 v23, 0x0

    goto :goto_72

    .line 130
    :cond_7c
    const-class v23, Landroid/text/style/ClickableSpan;

    move-object/from16 v0, p3

    move/from16 v1, v21

    move/from16 v2, v20

    move-object/from16 v3, v23

    invoke-interface {v0, v1, v2, v3}, Landroid/text/Spannable;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v18

    check-cast v18, [Landroid/text/style/ClickableSpan;

    .line 132
    .local v18, link:[Landroid/text/style/ClickableSpan;
    move-object/from16 v0, v18

    array-length v0, v0

    move/from16 v23, v0

    const/16 v24, 0x1

    move/from16 v0, v23

    move/from16 v1, v24

    if-eq v0, v1, :cond_9c

    .line 133
    const/16 v23, 0x0

    goto :goto_72

    .line 135
    :cond_9c
    const/16 v23, 0x0

    aget-object v23, v18, v23

    move-object/from16 v0, v23

    move-object/from16 v1, p2

    invoke-virtual {v0, v1}, Landroid/text/style/ClickableSpan;->onClick(Landroid/view/View;)V

    goto :goto_70

    .line 141
    .end local v18           #link:[Landroid/text/style/ClickableSpan;
    :pswitch_a8
    const/4 v9, -0x1

    .line 142
    .local v9, beststart:I
    const/4 v8, -0x1

    .line 144
    .local v8, bestend:I
    const/4 v13, 0x0

    .local v13, i:I
    :goto_ab
    array-length v0, v10

    move/from16 v23, v0

    move/from16 v0, v23

    if-ge v13, v0, :cond_d6

    .line 145
    aget-object v23, v10, v13

    move-object/from16 v0, p3

    move-object/from16 v1, v23

    invoke-interface {v0, v1}, Landroid/text/Spannable;->getSpanEnd(Ljava/lang/Object;)I

    move-result v11

    .line 147
    .local v11, end:I
    move/from16 v0, v20

    if-lt v11, v0, :cond_c6

    move/from16 v0, v21

    move/from16 v1, v20

    if-ne v0, v1, :cond_d3

    .line 148
    :cond_c6
    if-le v11, v8, :cond_d3

    .line 149
    aget-object v23, v10, v13

    move-object/from16 v0, p3

    move-object/from16 v1, v23

    invoke-interface {v0, v1}, Landroid/text/Spannable;->getSpanStart(Ljava/lang/Object;)I

    move-result v9

    .line 150
    move v8, v11

    .line 144
    :cond_d3
    add-int/lit8 v13, v13, 0x1

    goto :goto_ab

    .line 155
    .end local v11           #end:I
    :cond_d6
    if-ltz v9, :cond_70

    .line 156
    move-object/from16 v0, p3

    invoke-static {v0, v8, v9}, Landroid/text/Selection;->setSelection(Landroid/text/Spannable;II)V

    .line 157
    const/16 v23, 0x1

    goto :goto_72

    .line 163
    .end local v8           #bestend:I
    .end local v9           #beststart:I
    .end local v13           #i:I
    :pswitch_e0
    const v9, 0x7fffffff

    .line 164
    .restart local v9       #beststart:I
    const v8, 0x7fffffff

    .line 166
    .restart local v8       #bestend:I
    const/4 v13, 0x0

    .restart local v13       #i:I
    :goto_e7
    array-length v0, v10

    move/from16 v23, v0

    move/from16 v0, v23

    if-ge v13, v0, :cond_117

    .line 167
    aget-object v23, v10, v13

    move-object/from16 v0, p3

    move-object/from16 v1, v23

    invoke-interface {v0, v1}, Landroid/text/Spannable;->getSpanStart(Ljava/lang/Object;)I

    move-result v22

    .line 169
    .local v22, start:I
    move/from16 v0, v22

    move/from16 v1, v21

    if-gt v0, v1, :cond_104

    move/from16 v0, v21

    move/from16 v1, v20

    if-ne v0, v1, :cond_114

    .line 170
    :cond_104
    move/from16 v0, v22

    if-ge v0, v9, :cond_114

    .line 171
    move/from16 v9, v22

    .line 172
    aget-object v23, v10, v13

    move-object/from16 v0, p3

    move-object/from16 v1, v23

    invoke-interface {v0, v1}, Landroid/text/Spannable;->getSpanEnd(Ljava/lang/Object;)I

    move-result v8

    .line 166
    :cond_114
    add-int/lit8 v13, v13, 0x1

    goto :goto_e7

    .line 177
    .end local v22           #start:I
    :cond_117
    const v23, 0x7fffffff

    move/from16 v0, v23

    if-ge v8, v0, :cond_70

    .line 178
    move-object/from16 v0, p3

    invoke-static {v0, v9, v8}, Landroid/text/Selection;->setSelection(Landroid/text/Spannable;II)V

    .line 179
    const/16 v23, 0x1

    goto/16 :goto_72

    .line 124
    nop

    :pswitch_data_128
    .packed-switch 0x1
        :pswitch_73
        :pswitch_a8
        :pswitch_e0
    .end packed-switch
.end method

.method public static getInstance()Landroid/text/method/MovementMethod;
    .registers 1

    .prologue
    .line 246
    sget-object v0, Landroid/text/method/LinkMovementMethod;->sInstance:Landroid/text/method/LinkMovementMethod;

    if-nez v0, :cond_b

    .line 247
    new-instance v0, Landroid/text/method/LinkMovementMethod;

    invoke-direct {v0}, Landroid/text/method/LinkMovementMethod;-><init>()V

    sput-object v0, Landroid/text/method/LinkMovementMethod;->sInstance:Landroid/text/method/LinkMovementMethod;

    .line 249
    :cond_b
    sget-object v0, Landroid/text/method/LinkMovementMethod;->sInstance:Landroid/text/method/LinkMovementMethod;

    return-object v0
.end method


# virtual methods
.method protected down(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 4
    .parameter "widget"
    .parameter "buffer"

    .prologue
    .line 66
    const/4 v0, 0x3

    invoke-direct {p0, v0, p1, p2}, Landroid/text/method/LinkMovementMethod;->action(ILandroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 67
    const/4 v0, 0x1

    .line 70
    :goto_8
    return v0

    :cond_9
    invoke-super {p0, p1, p2}, Landroid/text/method/ScrollingMovementMethod;->down(Landroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    goto :goto_8
.end method

.method protected handleMovementKey(Landroid/widget/TextView;Landroid/text/Spannable;IILandroid/view/KeyEvent;)Z
    .registers 8
    .parameter "widget"
    .parameter "buffer"
    .parameter "keyCode"
    .parameter "movementMetaState"
    .parameter "event"

    .prologue
    const/4 v0, 0x1

    .line 41
    sparse-switch p3, :sswitch_data_22

    .line 52
    :cond_4
    invoke-super/range {p0 .. p5}, Landroid/text/method/ScrollingMovementMethod;->handleMovementKey(Landroid/widget/TextView;Landroid/text/Spannable;IILandroid/view/KeyEvent;)Z

    move-result v0

    :goto_8
    return v0

    .line 44
    :sswitch_9
    invoke-static {p4}, Landroid/view/KeyEvent;->metaStateHasNoModifiers(I)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 45
    invoke-virtual {p5}, Landroid/view/KeyEvent;->getAction()I

    move-result v1

    if-nez v1, :cond_4

    invoke-virtual {p5}, Landroid/view/KeyEvent;->getRepeatCount()I

    move-result v1

    if-nez v1, :cond_4

    invoke-direct {p0, v0, p1, p2}, Landroid/text/method/LinkMovementMethod;->action(ILandroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v1

    if-eqz v1, :cond_4

    goto :goto_8

    .line 41
    :sswitch_data_22
    .sparse-switch
        0x17 -> :sswitch_9
        0x42 -> :sswitch_9
    .end sparse-switch
.end method

.method public initialize(Landroid/widget/TextView;Landroid/text/Spannable;)V
    .registers 4
    .parameter "widget"
    .parameter "text"

    .prologue
    .line 230
    invoke-static {p2}, Landroid/text/Selection;->removeSelection(Landroid/text/Spannable;)V

    .line 231
    sget-object v0, Landroid/text/method/LinkMovementMethod;->FROM_BELOW:Ljava/lang/Object;

    invoke-interface {p2, v0}, Landroid/text/Spannable;->removeSpan(Ljava/lang/Object;)V

    .line 232
    return-void
.end method

.method protected left(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 4
    .parameter "widget"
    .parameter "buffer"

    .prologue
    .line 75
    const/4 v0, 0x2

    invoke-direct {p0, v0, p1, p2}, Landroid/text/method/LinkMovementMethod;->action(ILandroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 76
    const/4 v0, 0x1

    .line 79
    :goto_8
    return v0

    :cond_9
    invoke-super {p0, p1, p2}, Landroid/text/method/ScrollingMovementMethod;->left(Landroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    goto :goto_8
.end method

.method public onTakeFocus(Landroid/widget/TextView;Landroid/text/Spannable;I)V
    .registers 7
    .parameter "view"
    .parameter "text"
    .parameter "dir"

    .prologue
    const/4 v2, 0x0

    .line 236
    invoke-static {p2}, Landroid/text/Selection;->removeSelection(Landroid/text/Spannable;)V

    .line 238
    and-int/lit8 v0, p3, 0x1

    if-eqz v0, :cond_10

    .line 239
    sget-object v0, Landroid/text/method/LinkMovementMethod;->FROM_BELOW:Ljava/lang/Object;

    const/16 v1, 0x22

    invoke-interface {p2, v0, v2, v2, v1}, Landroid/text/Spannable;->setSpan(Ljava/lang/Object;III)V

    .line 243
    :goto_f
    return-void

    .line 241
    :cond_10
    sget-object v0, Landroid/text/method/LinkMovementMethod;->FROM_BELOW:Ljava/lang/Object;

    invoke-interface {p2, v0}, Landroid/text/Spannable;->removeSpan(Ljava/lang/Object;)V

    goto :goto_f
.end method

.method public onTouchEvent(Landroid/widget/TextView;Landroid/text/Spannable;Landroid/view/MotionEvent;)Z
    .registers 14
    .parameter "widget"
    .parameter "buffer"
    .parameter "event"

    .prologue
    const/4 v7, 0x1

    const/4 v9, 0x0

    .line 191
    invoke-virtual {p3}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    .line 193
    .local v0, action:I
    if-eq v0, v7, :cond_a

    if-nez v0, :cond_5d

    .line 195
    :cond_a
    invoke-virtual {p3}, Landroid/view/MotionEvent;->getX()F

    move-result v8

    float-to-int v5, v8

    .line 196
    .local v5, x:I
    invoke-virtual {p3}, Landroid/view/MotionEvent;->getY()F

    move-result v8

    float-to-int v6, v8

    .line 198
    .local v6, y:I
    invoke-virtual {p1}, Landroid/widget/TextView;->getTotalPaddingLeft()I

    move-result v8

    sub-int/2addr v5, v8

    .line 199
    invoke-virtual {p1}, Landroid/widget/TextView;->getTotalPaddingTop()I

    move-result v8

    sub-int/2addr v6, v8

    .line 201
    invoke-virtual {p1}, Landroid/widget/TextView;->getScrollX()I

    move-result v8

    add-int/2addr v5, v8

    .line 202
    invoke-virtual {p1}, Landroid/widget/TextView;->getScrollY()I

    move-result v8

    add-int/2addr v6, v8

    .line 204
    invoke-virtual {p1}, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;

    move-result-object v1

    .line 205
    .local v1, layout:Landroid/text/Layout;
    invoke-virtual {v1, v6}, Landroid/text/Layout;->getLineForVertical(I)I

    move-result v2

    .line 206
    .local v2, line:I
    int-to-float v8, v5

    invoke-virtual {v1, v2, v8}, Landroid/text/Layout;->getOffsetForHorizontal(IF)I

    move-result v4

    .line 208
    .local v4, off:I
    const-class v8, Landroid/text/style/ClickableSpan;

    invoke-interface {p2, v4, v4, v8}, Landroid/text/Spannable;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v3

    check-cast v3, [Landroid/text/style/ClickableSpan;

    .line 210
    .local v3, link:[Landroid/text/style/ClickableSpan;
    array-length v8, v3

    if-eqz v8, :cond_5a

    .line 211
    if-ne v0, v7, :cond_48

    .line 212
    aget-object v8, v3, v9

    invoke-virtual {v8, p1}, Landroid/text/style/ClickableSpan;->onClick(Landroid/view/View;)V

    .line 225
    .end local v1           #layout:Landroid/text/Layout;
    .end local v2           #line:I
    .end local v3           #link:[Landroid/text/style/ClickableSpan;
    .end local v4           #off:I
    .end local v5           #x:I
    .end local v6           #y:I
    :cond_47
    :goto_47
    return v7

    .line 213
    .restart local v1       #layout:Landroid/text/Layout;
    .restart local v2       #line:I
    .restart local v3       #link:[Landroid/text/style/ClickableSpan;
    .restart local v4       #off:I
    .restart local v5       #x:I
    .restart local v6       #y:I
    :cond_48
    if-nez v0, :cond_47

    .line 214
    aget-object v8, v3, v9

    invoke-interface {p2, v8}, Landroid/text/Spannable;->getSpanStart(Ljava/lang/Object;)I

    move-result v8

    aget-object v9, v3, v9

    invoke-interface {p2, v9}, Landroid/text/Spannable;->getSpanEnd(Ljava/lang/Object;)I

    move-result v9

    invoke-static {p2, v8, v9}, Landroid/text/Selection;->setSelection(Landroid/text/Spannable;II)V

    goto :goto_47

    .line 221
    :cond_5a
    invoke-static {p2}, Landroid/text/Selection;->removeSelection(Landroid/text/Spannable;)V

    .line 225
    .end local v1           #layout:Landroid/text/Layout;
    .end local v2           #line:I
    .end local v3           #link:[Landroid/text/style/ClickableSpan;
    .end local v4           #off:I
    .end local v5           #x:I
    .end local v6           #y:I
    :cond_5d
    invoke-super {p0, p1, p2, p3}, Landroid/text/method/ScrollingMovementMethod;->onTouchEvent(Landroid/widget/TextView;Landroid/text/Spannable;Landroid/view/MotionEvent;)Z

    move-result v7

    goto :goto_47
.end method

.method protected right(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 4
    .parameter "widget"
    .parameter "buffer"

    .prologue
    .line 84
    const/4 v0, 0x3

    invoke-direct {p0, v0, p1, p2}, Landroid/text/method/LinkMovementMethod;->action(ILandroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 85
    const/4 v0, 0x1

    .line 88
    :goto_8
    return v0

    :cond_9
    invoke-super {p0, p1, p2}, Landroid/text/method/ScrollingMovementMethod;->right(Landroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    goto :goto_8
.end method

.method protected up(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .registers 4
    .parameter "widget"
    .parameter "buffer"

    .prologue
    .line 57
    const/4 v0, 0x2

    invoke-direct {p0, v0, p1, p2}, Landroid/text/method/LinkMovementMethod;->action(ILandroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 58
    const/4 v0, 0x1

    .line 61
    :goto_8
    return v0

    :cond_9
    invoke-super {p0, p1, p2}, Landroid/text/method/ScrollingMovementMethod;->up(Landroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    goto :goto_8
.end method
