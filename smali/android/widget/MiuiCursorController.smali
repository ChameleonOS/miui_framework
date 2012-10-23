.class public abstract Landroid/widget/MiuiCursorController;
.super Ljava/lang/Object;
.source "MiuiCursorController.java"

# interfaces
.implements Landroid/view/ViewTreeObserver$OnTouchModeChangeListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/widget/MiuiCursorController$SelectionEndHandleView;,
        Landroid/widget/MiuiCursorController$SelectionStartHandleView;,
        Landroid/widget/MiuiCursorController$MagnifierInsertionHandleView;,
        Landroid/widget/MiuiCursorController$InsertionHandleView;,
        Landroid/widget/MiuiCursorController$MiuiHandleView;,
        Landroid/widget/MiuiCursorController$SelectionModifierCursorController;,
        Landroid/widget/MiuiCursorController$InsertionPointCursorController;,
        Landroid/widget/MiuiCursorController$FloatPanelViewController;
    }
.end annotation


# static fields
.field public static final INSERT_CURSOR_TYPE:I = 0x1

.field public static final LOG_TAG:Ljava/lang/String; = "MiuiCursorController"

.field public static final MAX_CLIP_DATA_NUMBER:I = 0x3

.field public static final SELECT_CURSOR_TYPE:I = 0x2


# instance fields
.field protected mContext:Landroid/content/Context;

.field protected mOwner:Landroid/widget/Editor;

.field protected mTextView:Landroid/widget/TextView;


# direct methods
.method constructor <init>(Landroid/widget/Editor;Landroid/content/Context;)V
    .registers 4
    .parameter "owner"
    .parameter "context"

    .prologue
    .line 68
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 69
    iput-object p1, p0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    .line 70
    iput-object p2, p0, Landroid/widget/MiuiCursorController;->mContext:Landroid/content/Context;

    .line 71
    iget-object v0, p0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    invoke-virtual {v0}, Landroid/widget/Editor;->textview()Landroid/widget/TextView;

    move-result-object v0

    iput-object v0, p0, Landroid/widget/MiuiCursorController;->mTextView:Landroid/widget/TextView;

    .line 72
    return-void
.end method

.method static synthetic access$300(J)I
    .registers 3
    .parameter "x0"

    .prologue
    .line 54
    invoke-static {p0, p1}, Landroid/widget/MiuiCursorController;->extractRangeStartFromLong(J)I

    move-result v0

    return v0
.end method

.method static synthetic access$400(J)I
    .registers 3
    .parameter "x0"

    .prologue
    .line 54
    invoke-static {p0, p1}, Landroid/widget/MiuiCursorController;->extractRangeEndFromLong(J)I

    move-result v0

    return v0
.end method

.method static create(Landroid/widget/Editor;Landroid/content/Context;I)Landroid/widget/MiuiCursorController;
    .registers 4
    .parameter "owner"
    .parameter "context"
    .parameter "type"

    .prologue
    .line 102
    const/4 v0, 0x1

    if-ne p2, v0, :cond_9

    .line 103
    new-instance v0, Landroid/widget/MiuiCursorController$InsertionPointCursorController;

    invoke-direct {v0, p0, p1}, Landroid/widget/MiuiCursorController$InsertionPointCursorController;-><init>(Landroid/widget/Editor;Landroid/content/Context;)V

    .line 109
    :goto_8
    return-object v0

    .line 105
    :cond_9
    const/4 v0, 0x2

    if-ne p2, v0, :cond_12

    .line 106
    new-instance v0, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;

    invoke-direct {v0, p0, p1}, Landroid/widget/MiuiCursorController$SelectionModifierCursorController;-><init>(Landroid/widget/Editor;Landroid/content/Context;)V

    goto :goto_8

    .line 109
    :cond_12
    const/4 v0, 0x0

    goto :goto_8
.end method

.method private static extractRangeEndFromLong(J)I
    .registers 4
    .parameter "range"

    .prologue
    .line 210
    const-wide v0, 0xffffffffL

    and-long/2addr v0, p0

    long-to-int v0, v0

    return v0
.end method

.method private static extractRangeStartFromLong(J)I
    .registers 4
    .parameter "range"

    .prologue
    .line 206
    const/16 v0, 0x20

    ushr-long v0, p0, v0

    long-to-int v0, v0

    return v0
.end method


# virtual methods
.method public abstract computePanelPosition([I)V
.end method

.method public abstract computePanelPositionOnBottom()I
.end method

.method public createFloatPanelViewController(I)Landroid/widget/MiuiCursorController$FloatPanelViewController;
    .registers 3
    .parameter "resId"

    .prologue
    .line 132
    new-instance v0, Landroid/widget/MiuiCursorController$FloatPanelViewController;

    invoke-direct {v0, p0, p0, p1}, Landroid/widget/MiuiCursorController$FloatPanelViewController;-><init>(Landroid/widget/MiuiCursorController;Landroid/widget/MiuiCursorController;I)V

    return-object v0
.end method

.method public getMaxTouchOffset()I
    .registers 2

    .prologue
    .line 125
    const/4 v0, 0x0

    return v0
.end method

.method public getMinTouchOffset()I
    .registers 2

    .prologue
    .line 118
    const/4 v0, -0x1

    return v0
.end method

.method public abstract hide()V
.end method

.method initHandleView(Landroid/widget/Editor;ILandroid/widget/MiuiCursorController;)Landroid/widget/MiuiCursorController$MiuiHandleView;
    .registers 9
    .parameter "textview"
    .parameter "type"
    .parameter "cc"

    .prologue
    .line 1353
    const/4 v0, 0x0

    .line 1354
    .local v0, handle:Landroid/widget/MiuiCursorController$MiuiHandleView;
    if-nez p2, :cond_2a

    .line 1355
    invoke-virtual {p1}, Landroid/widget/Editor;->hasMagnifierController()Z

    move-result v3

    if-eqz v3, :cond_1e

    .line 1356
    new-instance v0, Landroid/widget/MiuiCursorController$MagnifierInsertionHandleView;

    .end local v0           #handle:Landroid/widget/MiuiCursorController$MiuiHandleView;
    iget-object v3, p0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    invoke-virtual {v3}, Landroid/widget/Editor;->getSelectHandleCenterRes()Landroid/graphics/drawable/Drawable;

    move-result-object v3

    invoke-direct {v0, p0, p1, v3}, Landroid/widget/MiuiCursorController$MagnifierInsertionHandleView;-><init>(Landroid/widget/MiuiCursorController;Landroid/widget/Editor;Landroid/graphics/drawable/Drawable;)V

    .line 1375
    .restart local v0       #handle:Landroid/widget/MiuiCursorController$MiuiHandleView;
    :cond_14
    :goto_14
    if-nez v0, :cond_47

    .line 1376
    const-string v3, "MiuiCursorController"

    const-string v4, "Failed to init handle view."

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1382
    :goto_1d
    return-object v0

    .line 1359
    :cond_1e
    new-instance v0, Landroid/widget/MiuiCursorController$InsertionHandleView;

    .end local v0           #handle:Landroid/widget/MiuiCursorController$MiuiHandleView;
    iget-object v3, p0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    invoke-virtual {v3}, Landroid/widget/Editor;->getSelectHandleCenterRes()Landroid/graphics/drawable/Drawable;

    move-result-object v3

    invoke-direct {v0, p0, p1, v3}, Landroid/widget/MiuiCursorController$InsertionHandleView;-><init>(Landroid/widget/MiuiCursorController;Landroid/widget/Editor;Landroid/graphics/drawable/Drawable;)V

    .restart local v0       #handle:Landroid/widget/MiuiCursorController$MiuiHandleView;
    goto :goto_14

    .line 1363
    :cond_2a
    iget-object v3, p0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    invoke-virtual {v3}, Landroid/widget/Editor;->getSelectHandleRightRes()Landroid/graphics/drawable/Drawable;

    move-result-object v2

    .line 1364
    .local v2, right:Landroid/graphics/drawable/Drawable;
    iget-object v3, p0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    invoke-virtual {v3}, Landroid/widget/Editor;->getSelectHandleLeftRes()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    .line 1366
    .local v1, left:Landroid/graphics/drawable/Drawable;
    const/4 v3, 0x1

    if-ne p2, v3, :cond_3e

    .line 1367
    new-instance v0, Landroid/widget/MiuiCursorController$SelectionStartHandleView;

    .end local v0           #handle:Landroid/widget/MiuiCursorController$MiuiHandleView;
    invoke-direct {v0, p0, p1, v1, v2}, Landroid/widget/MiuiCursorController$SelectionStartHandleView;-><init>(Landroid/widget/MiuiCursorController;Landroid/widget/Editor;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 1370
    .restart local v0       #handle:Landroid/widget/MiuiCursorController$MiuiHandleView;
    :cond_3e
    const/4 v3, 0x2

    if-ne p2, v3, :cond_14

    .line 1371
    new-instance v0, Landroid/widget/MiuiCursorController$SelectionEndHandleView;

    .end local v0           #handle:Landroid/widget/MiuiCursorController$MiuiHandleView;
    invoke-direct {v0, p0, p1, v2, v1}, Landroid/widget/MiuiCursorController$SelectionEndHandleView;-><init>(Landroid/widget/MiuiCursorController;Landroid/widget/Editor;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .restart local v0       #handle:Landroid/widget/MiuiCursorController$MiuiHandleView;
    goto :goto_14

    .line 1379
    .end local v1           #left:Landroid/graphics/drawable/Drawable;
    .end local v2           #right:Landroid/graphics/drawable/Drawable;
    :cond_47
    invoke-virtual {v0, p3}, Landroid/widget/MiuiCursorController$MiuiHandleView;->setCursorController(Landroid/widget/MiuiCursorController;)V

    .line 1380
    invoke-virtual {v0, p2}, Landroid/widget/MiuiCursorController$MiuiHandleView;->setType(I)V

    goto :goto_1d
.end method

.method public isSelectionStartDragged()Z
    .registers 2

    .prologue
    .line 115
    const/4 v0, 0x0

    return v0
.end method

.method public abstract isShowing()Z
.end method

.method public onDetached()V
    .registers 1

    .prologue
    .line 98
    return-void
.end method

.method public abstract onHandleTouchEvent(Landroid/widget/MiuiCursorController$MiuiHandleView;Landroid/view/MotionEvent;)Z
.end method

.method public abstract onTouchEvent(Landroid/view/MotionEvent;)Z
.end method

.method public onTouchModeChanged(Z)V
    .registers 2
    .parameter "isInTouchMode"

    .prologue
    .line 89
    if-nez p1, :cond_5

    .line 90
    invoke-virtual {p0}, Landroid/widget/MiuiCursorController;->hide()V

    .line 92
    :cond_5
    return-void
.end method

.method public resetTouchOffsets()V
    .registers 1

    .prologue
    .line 122
    return-void
.end method

.method public selectCurrentRange()Z
    .registers 18

    .prologue
    .line 137
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/widget/MiuiCursorController;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v15}, Landroid/widget/TextView;->getTransformationMethod()Landroid/text/method/TransformationMethod;

    move-result-object v15

    instance-of v15, v15, Landroid/text/method/PasswordTransformationMethod;

    if-eqz v15, :cond_15

    .line 141
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    invoke-virtual {v15}, Landroid/widget/Editor;->selectAllWrap()Z

    move-result v15

    .line 202
    :goto_14
    return v15

    .line 144
    :cond_15
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/widget/MiuiCursorController;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v15}, Landroid/widget/TextView;->getInputType()I

    move-result v1

    .line 145
    .local v1, inputType:I
    and-int/lit8 v2, v1, 0xf

    .line 146
    .local v2, klass:I
    and-int/lit16 v13, v1, 0xff0

    .line 149
    .local v13, variation:I
    const/4 v15, 0x2

    if-eq v2, v15, :cond_3a

    const/4 v15, 0x3

    if-eq v2, v15, :cond_3a

    const/4 v15, 0x4

    if-eq v2, v15, :cond_3a

    const/16 v15, 0x10

    if-eq v13, v15, :cond_3a

    const/16 v15, 0x20

    if-eq v13, v15, :cond_3a

    const/16 v15, 0xd0

    if-eq v13, v15, :cond_3a

    const/16 v15, 0xb0

    if-ne v13, v15, :cond_43

    .line 156
    :cond_3a
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    invoke-virtual {v15}, Landroid/widget/Editor;->selectAllWrap()Z

    move-result v15

    goto :goto_14

    .line 159
    :cond_43
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    invoke-virtual {v15}, Landroid/widget/Editor;->getSelectionController()Landroid/widget/MiuiCursorController;

    move-result-object v7

    .line 160
    .local v7, selectionController:Landroid/widget/MiuiCursorController;
    invoke-virtual {v7}, Landroid/widget/MiuiCursorController;->getMinTouchOffset()I

    move-result v4

    .line 161
    .local v4, minOffset:I
    invoke-virtual {v7}, Landroid/widget/MiuiCursorController;->getMaxTouchOffset()I

    move-result v3

    .line 163
    .local v3, maxOffset:I
    if-ltz v4, :cond_5f

    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/widget/MiuiCursorController;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v15}, Landroid/widget/TextView;->length()I

    move-result v15

    if-le v4, v15, :cond_61

    :cond_5f
    const/4 v15, 0x0

    goto :goto_14

    .line 164
    :cond_61
    if-ltz v3, :cond_6d

    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/widget/MiuiCursorController;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v15}, Landroid/widget/TextView;->length()I

    move-result v15

    if-le v3, v15, :cond_6f

    :cond_6d
    const/4 v15, 0x0

    goto :goto_14

    .line 168
    :cond_6f
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/widget/MiuiCursorController;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v15}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v10

    .local v10, text:Ljava/lang/CharSequence;
    move-object v15, v10

    .line 170
    check-cast v15, Landroid/text/Spanned;

    const-class v16, Landroid/text/style/URLSpan;

    move-object/from16 v0, v16

    invoke-interface {v15, v4, v3, v0}, Landroid/text/Spanned;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v12

    check-cast v12, [Landroid/text/style/URLSpan;

    .line 171
    .local v12, urlSpans:[Landroid/text/style/URLSpan;
    array-length v15, v12

    const/16 v16, 0x1

    move/from16 v0, v16

    if-lt v15, v0, :cond_a6

    .line 172
    const/4 v15, 0x0

    aget-object v11, v12, v15

    .local v11, urlSpan:Landroid/text/style/URLSpan;
    move-object v15, v10

    .line 173
    check-cast v15, Landroid/text/Spanned;

    invoke-interface {v15, v11}, Landroid/text/Spanned;->getSpanStart(Ljava/lang/Object;)I

    move-result v9

    .local v9, selectionStart:I
    move-object v15, v10

    .line 174
    check-cast v15, Landroid/text/Spanned;

    invoke-interface {v15, v11}, Landroid/text/Spanned;->getSpanEnd(Ljava/lang/Object;)I

    move-result v8

    .line 201
    .end local v11           #urlSpan:Landroid/text/style/URLSpan;
    .local v8, selectionEnd:I
    :cond_9c
    :goto_9c
    check-cast v10, Landroid/text/Spannable;

    .end local v10           #text:Ljava/lang/CharSequence;
    invoke-static {v10, v9, v8}, Landroid/text/Selection;->setSelection(Landroid/text/Spannable;II)V

    .line 202
    if-le v8, v9, :cond_df

    const/4 v15, 0x1

    goto/16 :goto_14

    .line 176
    .end local v8           #selectionEnd:I
    .end local v9           #selectionStart:I
    .restart local v10       #text:Ljava/lang/CharSequence;
    :cond_a6
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    invoke-virtual {v15}, Landroid/widget/Editor;->getWordIterator()Landroid/text/method/WordIterator;

    move-result-object v14

    .line 177
    .local v14, wordIterator:Landroid/text/method/WordIterator;
    invoke-virtual {v14, v10, v4, v3}, Landroid/text/method/WordIterator;->setCharSequence(Ljava/lang/CharSequence;II)V

    .line 179
    invoke-virtual {v14, v4}, Landroid/text/method/WordIterator;->getBeginning(I)I

    move-result v9

    .line 180
    .restart local v9       #selectionStart:I
    invoke-virtual {v14, v3}, Landroid/text/method/WordIterator;->getEnd(I)I

    move-result v8

    .line 182
    .restart local v8       #selectionEnd:I
    const/4 v15, -0x1

    if-eq v9, v15, :cond_bf

    const/4 v15, -0x1

    if-ne v8, v15, :cond_c8

    .line 183
    :cond_bf
    invoke-interface {v10}, Ljava/lang/CharSequence;->length()I

    move-result v15

    if-ne v3, v15, :cond_db

    .line 184
    add-int/lit8 v9, v3, -0x1

    .line 185
    move v8, v3

    .line 193
    :cond_c8
    :goto_c8
    if-ne v9, v8, :cond_9c

    .line 195
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/widget/MiuiCursorController;->mOwner:Landroid/widget/Editor;

    invoke-virtual {v15, v9}, Landroid/widget/Editor;->getCharRangeWrap(I)J

    move-result-wide v5

    .line 196
    .local v5, range:J
    invoke-static {v5, v6}, Landroid/widget/MiuiCursorController;->extractRangeStartFromLong(J)I

    move-result v9

    .line 197
    invoke-static {v5, v6}, Landroid/widget/MiuiCursorController;->extractRangeEndFromLong(J)I

    move-result v8

    goto :goto_9c

    .line 188
    .end local v5           #range:J
    :cond_db
    move v9, v3

    .line 189
    add-int/lit8 v8, v3, 0x1

    goto :goto_c8

    .line 202
    .end local v10           #text:Ljava/lang/CharSequence;
    .end local v14           #wordIterator:Landroid/text/method/WordIterator;
    :cond_df
    const/4 v15, 0x0

    goto/16 :goto_14
.end method

.method public setMinMaxOffset(I)V
    .registers 2
    .parameter "offset"

    .prologue
    .line 128
    return-void
.end method

.method public abstract show()V
.end method

.method public abstract updatePosition()V
.end method
