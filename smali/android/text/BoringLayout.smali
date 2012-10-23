.class public Landroid/text/BoringLayout;
.super Landroid/text/Layout;
.source "BoringLayout.java"

# interfaces
.implements Landroid/text/TextUtils$EllipsizeCallback;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/text/BoringLayout$Metrics;
    }
.end annotation


# static fields
.field private static final FIRST_RIGHT_TO_LEFT:C = '\u0590'

.field private static final sTemp:Landroid/text/TextPaint;


# instance fields
.field mBottom:I

.field private mBottomPadding:I

.field mDesc:I

.field private mDirect:Ljava/lang/String;

.field private mEllipsizedCount:I

.field private mEllipsizedStart:I

.field private mEllipsizedWidth:I

.field private mMax:F

.field private mPaint:Landroid/graphics/Paint;

.field private mTopPadding:I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 422
    new-instance v0, Landroid/text/TextPaint;

    invoke-direct {v0}, Landroid/text/TextPaint;-><init>()V

    sput-object v0, Landroid/text/BoringLayout;->sTemp:Landroid/text/TextPaint;

    return-void
.end method

.method public constructor <init>(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFLandroid/text/BoringLayout$Metrics;Z)V
    .registers 19
    .parameter "source"
    .parameter "paint"
    .parameter "outerwidth"
    .parameter "align"
    .parameter "spacingmult"
    .parameter "spacingadd"
    .parameter "metrics"
    .parameter "includepad"

    .prologue
    .line 124
    invoke-direct/range {p0 .. p6}, Landroid/text/Layout;-><init>(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;FF)V

    .line 126
    iput p3, p0, Landroid/text/BoringLayout;->mEllipsizedWidth:I

    .line 127
    const/4 v0, 0x0

    iput v0, p0, Landroid/text/BoringLayout;->mEllipsizedStart:I

    .line 128
    const/4 v0, 0x0

    iput v0, p0, Landroid/text/BoringLayout;->mEllipsizedCount:I

    .line 130
    const/4 v9, 0x1

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move v3, p3

    move-object v4, p4

    move v5, p5

    move/from16 v6, p6

    move-object/from16 v7, p7

    move/from16 v8, p8

    invoke-virtual/range {v0 .. v9}, Landroid/text/BoringLayout;->init(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFLandroid/text/BoringLayout$Metrics;ZZ)V

    .line 132
    return-void
.end method

.method public constructor <init>(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFLandroid/text/BoringLayout$Metrics;ZLandroid/text/TextUtils$TruncateAt;I)V
    .registers 22
    .parameter "source"
    .parameter "paint"
    .parameter "outerwidth"
    .parameter "align"
    .parameter "spacingmult"
    .parameter "spacingadd"
    .parameter "metrics"
    .parameter "includepad"
    .parameter "ellipsize"
    .parameter "ellipsizedWidth"

    .prologue
    .line 145
    invoke-direct/range {p0 .. p6}, Landroid/text/Layout;-><init>(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;FF)V

    .line 149
    if-eqz p9, :cond_b

    sget-object v1, Landroid/text/TextUtils$TruncateAt;->MARQUEE:Landroid/text/TextUtils$TruncateAt;

    move-object/from16 v0, p9

    if-ne v0, v1, :cond_28

    .line 150
    :cond_b
    iput p3, p0, Landroid/text/BoringLayout;->mEllipsizedWidth:I

    .line 151
    const/4 v1, 0x0

    iput v1, p0, Landroid/text/BoringLayout;->mEllipsizedStart:I

    .line 152
    const/4 v1, 0x0

    iput v1, p0, Landroid/text/BoringLayout;->mEllipsizedCount:I

    .line 153
    const/4 v10, 0x1

    .line 165
    .local v10, trust:Z
    :goto_14
    invoke-virtual {p0}, Landroid/text/BoringLayout;->getText()Ljava/lang/CharSequence;

    move-result-object v2

    move-object v1, p0

    move-object v3, p2

    move v4, p3

    move-object v5, p4

    move/from16 v6, p5

    move/from16 v7, p6

    move-object/from16 v8, p7

    move/from16 v9, p8

    invoke-virtual/range {v1 .. v10}, Landroid/text/BoringLayout;->init(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFLandroid/text/BoringLayout$Metrics;ZZ)V

    .line 167
    return-void

    .line 155
    .end local v10           #trust:Z
    :cond_28
    move/from16 v0, p10

    int-to-float v3, v0

    const/4 v5, 0x1

    move-object v1, p1

    move-object v2, p2

    move-object/from16 v4, p9

    move-object v6, p0

    invoke-static/range {v1 .. v6}, Landroid/text/TextUtils;->ellipsize(Ljava/lang/CharSequence;Landroid/text/TextPaint;FLandroid/text/TextUtils$TruncateAt;ZLandroid/text/TextUtils$EllipsizeCallback;)Ljava/lang/CharSequence;

    move-result-object v2

    move-object v1, p0

    move-object v3, p2

    move v4, p3

    move-object v5, p4

    move/from16 v6, p5

    move/from16 v7, p6

    invoke-virtual/range {v1 .. v7}, Landroid/text/BoringLayout;->replaceWith(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;FF)V

    .line 161
    move/from16 v0, p10

    iput v0, p0, Landroid/text/BoringLayout;->mEllipsizedWidth:I

    .line 162
    const/4 v10, 0x0

    .restart local v10       #trust:Z
    goto :goto_14
.end method

.method public static isBoring(Ljava/lang/CharSequence;Landroid/text/TextPaint;)Landroid/text/BoringLayout$Metrics;
    .registers 4
    .parameter "text"
    .parameter "paint"

    .prologue
    .line 229
    sget-object v0, Landroid/text/TextDirectionHeuristics;->FIRSTSTRONG_LTR:Landroid/text/TextDirectionHeuristic;

    const/4 v1, 0x0

    invoke-static {p0, p1, v0, v1}, Landroid/text/BoringLayout;->isBoring(Ljava/lang/CharSequence;Landroid/text/TextPaint;Landroid/text/TextDirectionHeuristic;Landroid/text/BoringLayout$Metrics;)Landroid/text/BoringLayout$Metrics;

    move-result-object v0

    return-object v0
.end method

.method public static isBoring(Ljava/lang/CharSequence;Landroid/text/TextPaint;Landroid/text/BoringLayout$Metrics;)Landroid/text/BoringLayout$Metrics;
    .registers 4
    .parameter "text"
    .parameter "paint"
    .parameter "metrics"

    .prologue
    .line 248
    sget-object v0, Landroid/text/TextDirectionHeuristics;->FIRSTSTRONG_LTR:Landroid/text/TextDirectionHeuristic;

    invoke-static {p0, p1, v0, p2}, Landroid/text/BoringLayout;->isBoring(Ljava/lang/CharSequence;Landroid/text/TextPaint;Landroid/text/TextDirectionHeuristic;Landroid/text/BoringLayout$Metrics;)Landroid/text/BoringLayout$Metrics;

    move-result-object v0

    return-object v0
.end method

.method public static isBoring(Ljava/lang/CharSequence;Landroid/text/TextPaint;Landroid/text/TextDirectionHeuristic;)Landroid/text/BoringLayout$Metrics;
    .registers 4
    .parameter "text"
    .parameter "paint"
    .parameter "textDir"

    .prologue
    .line 239
    const/4 v0, 0x0

    invoke-static {p0, p1, p2, v0}, Landroid/text/BoringLayout;->isBoring(Ljava/lang/CharSequence;Landroid/text/TextPaint;Landroid/text/TextDirectionHeuristic;Landroid/text/BoringLayout$Metrics;)Landroid/text/BoringLayout$Metrics;

    move-result-object v0

    return-object v0
.end method

.method public static isBoring(Ljava/lang/CharSequence;Landroid/text/TextPaint;Landroid/text/TextDirectionHeuristic;Landroid/text/BoringLayout$Metrics;)Landroid/text/BoringLayout$Metrics;
    .registers 27
    .parameter "text"
    .parameter "paint"
    .parameter "textDir"
    .parameter "metrics"

    .prologue
    .line 259
    const/16 v5, 0x1f4

    invoke-static {v5}, Landroid/text/TextUtils;->obtain(I)[C

    move-result-object v22

    .line 260
    .local v22, temp:[C
    invoke-interface/range {p0 .. p0}, Ljava/lang/CharSequence;->length()I

    move-result v8

    .line 261
    .local v8, length:I
    const/4 v14, 0x1

    .line 264
    .local v14, boring:Z
    const/16 v17, 0x0

    .local v17, i:I
    :goto_d
    move/from16 v0, v17

    if-ge v0, v8, :cond_3f

    .line 265
    move/from16 v0, v17

    add-int/lit16 v0, v0, 0x1f4

    move/from16 v18, v0

    .line 267
    .local v18, j:I
    move/from16 v0, v18

    if-le v0, v8, :cond_1d

    .line 268
    move/from16 v18, v8

    .line 270
    :cond_1d
    const/4 v5, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v17

    move/from16 v2, v18

    move-object/from16 v3, v22

    invoke-static {v0, v1, v2, v3, v5}, Landroid/text/TextUtils;->getChars(Ljava/lang/CharSequence;II[CI)V

    .line 272
    sub-int v19, v18, v17

    .line 274
    .local v19, n:I
    const/4 v13, 0x0

    .local v13, a:I
    :goto_2c
    move/from16 v0, v19

    if-ge v13, v0, :cond_8f

    .line 275
    aget-char v15, v22, v13

    .line 277
    .local v15, c:C
    const/16 v5, 0xa

    if-eq v15, v5, :cond_3e

    const/16 v5, 0x9

    if-eq v15, v5, :cond_3e

    const/16 v5, 0x590

    if-lt v15, v5, :cond_8c

    .line 278
    :cond_3e
    const/4 v14, 0x0

    .line 289
    .end local v13           #a:I
    .end local v15           #c:C
    .end local v18           #j:I
    .end local v19           #n:I
    :cond_3f
    :goto_3f
    invoke-static/range {v22 .. v22}, Landroid/text/TextUtils;->recycle([C)V

    .line 291
    if-eqz v14, :cond_5d

    move-object/from16 v0, p0

    instance-of v5, v0, Landroid/text/Spanned;

    if-eqz v5, :cond_5d

    move-object/from16 v20, p0

    .line 292
    check-cast v20, Landroid/text/Spanned;

    .line 293
    .local v20, sp:Landroid/text/Spanned;
    const/4 v5, 0x0

    const-class v6, Landroid/text/style/ParagraphStyle;

    move-object/from16 v0, v20

    invoke-interface {v0, v5, v8, v6}, Landroid/text/Spanned;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v21

    .line 294
    .local v21, styles:[Ljava/lang/Object;
    move-object/from16 v0, v21

    array-length v5, v0

    if-lez v5, :cond_5d

    .line 295
    const/4 v14, 0x0

    .line 299
    .end local v20           #sp:Landroid/text/Spanned;
    .end local v21           #styles:[Ljava/lang/Object;
    :cond_5d
    if-eqz v14, :cond_a8

    .line 300
    move-object/from16 v16, p3

    .line 301
    .local v16, fm:Landroid/text/BoringLayout$Metrics;
    if-nez v16, :cond_68

    .line 302
    new-instance v16, Landroid/text/BoringLayout$Metrics;

    .end local v16           #fm:Landroid/text/BoringLayout$Metrics;
    invoke-direct/range {v16 .. v16}, Landroid/text/BoringLayout$Metrics;-><init>()V

    .line 305
    .restart local v16       #fm:Landroid/text/BoringLayout$Metrics;
    :cond_68
    invoke-static {}, Landroid/text/TextLine;->obtain()Landroid/text/TextLine;

    move-result-object v4

    .line 306
    .local v4, line:Landroid/text/TextLine;
    const/4 v7, 0x0

    const/4 v9, 0x1

    sget-object v10, Landroid/text/Layout;->DIRS_ALL_LEFT_TO_RIGHT:Landroid/text/Layout$Directions;

    const/4 v11, 0x0

    const/4 v12, 0x0

    move-object/from16 v5, p1

    move-object/from16 v6, p0

    invoke-virtual/range {v4 .. v12}, Landroid/text/TextLine;->set(Landroid/text/TextPaint;Ljava/lang/CharSequence;IIILandroid/text/Layout$Directions;ZLandroid/text/Layout$TabStops;)V

    .line 308
    move-object/from16 v0, v16

    invoke-virtual {v4, v0}, Landroid/text/TextLine;->metrics(Landroid/graphics/Paint$FontMetricsInt;)F

    move-result v5

    invoke-static {v5}, Landroid/util/FloatMath;->ceil(F)F

    move-result v5

    float-to-int v5, v5

    move-object/from16 v0, v16

    iput v5, v0, Landroid/text/BoringLayout$Metrics;->width:I

    .line 309
    invoke-static {v4}, Landroid/text/TextLine;->recycle(Landroid/text/TextLine;)Landroid/text/TextLine;

    .line 313
    .end local v4           #line:Landroid/text/TextLine;
    .end local v16           #fm:Landroid/text/BoringLayout$Metrics;
    :goto_8b
    return-object v16

    .line 274
    .restart local v13       #a:I
    .restart local v15       #c:C
    .restart local v18       #j:I
    .restart local v19       #n:I
    :cond_8c
    add-int/lit8 v13, v13, 0x1

    goto :goto_2c

    .line 283
    .end local v15           #c:C
    :cond_8f
    if-eqz p2, :cond_a0

    const/4 v5, 0x0

    move-object/from16 v0, p2

    move-object/from16 v1, v22

    move/from16 v2, v19

    invoke-interface {v0, v1, v5, v2}, Landroid/text/TextDirectionHeuristic;->isRtl([CII)Z

    move-result v5

    if-eqz v5, :cond_a0

    .line 284
    const/4 v14, 0x0

    .line 285
    goto :goto_3f

    .line 264
    :cond_a0
    move/from16 v0, v17

    add-int/lit16 v0, v0, 0x1f4

    move/from16 v17, v0

    goto/16 :goto_d

    .line 313
    .end local v13           #a:I
    .end local v18           #j:I
    .end local v19           #n:I
    :cond_a8
    const/16 v16, 0x0

    goto :goto_8b
.end method

.method public static make(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFLandroid/text/BoringLayout$Metrics;Z)Landroid/text/BoringLayout;
    .registers 17
    .parameter "source"
    .parameter "paint"
    .parameter "outerwidth"
    .parameter "align"
    .parameter "spacingmult"
    .parameter "spacingadd"
    .parameter "metrics"
    .parameter "includepad"

    .prologue
    .line 44
    new-instance v0, Landroid/text/BoringLayout;

    move-object v1, p0

    move-object v2, p1

    move v3, p2

    move-object v4, p3

    move v5, p4

    move v6, p5

    move-object v7, p6

    move/from16 v8, p7

    invoke-direct/range {v0 .. v8}, Landroid/text/BoringLayout;-><init>(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFLandroid/text/BoringLayout$Metrics;Z)V

    return-object v0
.end method

.method public static make(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFLandroid/text/BoringLayout$Metrics;ZLandroid/text/TextUtils$TruncateAt;I)Landroid/text/BoringLayout;
    .registers 21
    .parameter "source"
    .parameter "paint"
    .parameter "outerwidth"
    .parameter "align"
    .parameter "spacingmult"
    .parameter "spacingadd"
    .parameter "metrics"
    .parameter "includepad"
    .parameter "ellipsize"
    .parameter "ellipsizedWidth"

    .prologue
    .line 55
    new-instance v0, Landroid/text/BoringLayout;

    move-object v1, p0

    move-object v2, p1

    move v3, p2

    move-object v4, p3

    move v5, p4

    move/from16 v6, p5

    move-object/from16 v7, p6

    move/from16 v8, p7

    move-object/from16 v9, p8

    move/from16 v10, p9

    invoke-direct/range {v0 .. v10}, Landroid/text/BoringLayout;-><init>(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFLandroid/text/BoringLayout$Metrics;ZLandroid/text/TextUtils$TruncateAt;I)V

    return-object v0
.end method


# virtual methods
.method public draw(Landroid/graphics/Canvas;Landroid/graphics/Path;Landroid/graphics/Paint;I)V
    .registers 9
    .parameter "c"
    .parameter "highlight"
    .parameter "highlightpaint"
    .parameter "cursorOffset"

    .prologue
    .line 397
    iget-object v0, p0, Landroid/text/BoringLayout;->mDirect:Ljava/lang/String;

    if-eqz v0, :cond_15

    if-nez p2, :cond_15

    .line 398
    iget-object v0, p0, Landroid/text/BoringLayout;->mDirect:Ljava/lang/String;

    const/4 v1, 0x0

    iget v2, p0, Landroid/text/BoringLayout;->mBottom:I

    iget v3, p0, Landroid/text/BoringLayout;->mDesc:I

    sub-int/2addr v2, v3

    int-to-float v2, v2

    iget-object v3, p0, Landroid/text/BoringLayout;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 402
    :goto_14
    return-void

    .line 400
    :cond_15
    invoke-super {p0, p1, p2, p3, p4}, Landroid/text/Layout;->draw(Landroid/graphics/Canvas;Landroid/graphics/Path;Landroid/graphics/Paint;I)V

    goto :goto_14
.end method

.method public ellipsized(II)V
    .registers 4
    .parameter "start"
    .parameter "end"

    .prologue
    .line 408
    iput p1, p0, Landroid/text/BoringLayout;->mEllipsizedStart:I

    .line 409
    sub-int v0, p2, p1

    iput v0, p0, Landroid/text/BoringLayout;->mEllipsizedCount:I

    .line 410
    return-void
.end method

.method public getBottomPadding()I
    .registers 2

    .prologue
    .line 375
    iget v0, p0, Landroid/text/BoringLayout;->mBottomPadding:I

    return v0
.end method

.method public getEllipsisCount(I)I
    .registers 3
    .parameter "line"

    .prologue
    .line 380
    iget v0, p0, Landroid/text/BoringLayout;->mEllipsizedCount:I

    return v0
.end method

.method public getEllipsisStart(I)I
    .registers 3
    .parameter "line"

    .prologue
    .line 385
    iget v0, p0, Landroid/text/BoringLayout;->mEllipsizedStart:I

    return v0
.end method

.method public getEllipsizedWidth()I
    .registers 2

    .prologue
    .line 390
    iget v0, p0, Landroid/text/BoringLayout;->mEllipsizedWidth:I

    return v0
.end method

.method public getHeight()I
    .registers 2

    .prologue
    .line 319
    iget v0, p0, Landroid/text/BoringLayout;->mBottom:I

    return v0
.end method

.method public getLineContainsTab(I)Z
    .registers 3
    .parameter "line"

    .prologue
    .line 355
    const/4 v0, 0x0

    return v0
.end method

.method public getLineCount()I
    .registers 2

    .prologue
    .line 324
    const/4 v0, 0x1

    return v0
.end method

.method public getLineDescent(I)I
    .registers 3
    .parameter "line"

    .prologue
    .line 337
    iget v0, p0, Landroid/text/BoringLayout;->mDesc:I

    return v0
.end method

.method public final getLineDirections(I)Landroid/text/Layout$Directions;
    .registers 3
    .parameter "line"

    .prologue
    .line 365
    sget-object v0, Landroid/text/Layout;->DIRS_ALL_LEFT_TO_RIGHT:Landroid/text/Layout$Directions;

    return-object v0
.end method

.method public getLineMax(I)F
    .registers 3
    .parameter "line"

    .prologue
    .line 360
    iget v0, p0, Landroid/text/BoringLayout;->mMax:F

    return v0
.end method

.method public getLineStart(I)I
    .registers 3
    .parameter "line"

    .prologue
    .line 342
    if-nez p1, :cond_4

    .line 343
    const/4 v0, 0x0

    .line 345
    :goto_3
    return v0

    :cond_4
    invoke-virtual {p0}, Landroid/text/BoringLayout;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/CharSequence;->length()I

    move-result v0

    goto :goto_3
.end method

.method public getLineTop(I)I
    .registers 3
    .parameter "line"

    .prologue
    .line 329
    if-nez p1, :cond_4

    .line 330
    const/4 v0, 0x0

    .line 332
    :goto_3
    return v0

    :cond_4
    iget v0, p0, Landroid/text/BoringLayout;->mBottom:I

    goto :goto_3
.end method

.method public getParagraphDirection(I)I
    .registers 3
    .parameter "line"

    .prologue
    .line 350
    const/4 v0, 0x1

    return v0
.end method

.method public getTopPadding()I
    .registers 2

    .prologue
    .line 370
    iget v0, p0, Landroid/text/BoringLayout;->mTopPadding:I

    return v0
.end method

.method init(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFLandroid/text/BoringLayout$Metrics;ZZ)V
    .registers 21
    .parameter "source"
    .parameter "paint"
    .parameter "outerwidth"
    .parameter "align"
    .parameter "spacingmult"
    .parameter "spacingadd"
    .parameter "metrics"
    .parameter "includepad"
    .parameter "trustWidth"

    .prologue
    .line 177
    instance-of v2, p1, Ljava/lang/String;

    if-eqz v2, :cond_5d

    sget-object v2, Landroid/text/Layout$Alignment;->ALIGN_NORMAL:Landroid/text/Layout$Alignment;

    if-ne p4, v2, :cond_5d

    .line 178
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Landroid/text/BoringLayout;->mDirect:Ljava/lang/String;

    .line 183
    :goto_e
    iput-object p2, p0, Landroid/text/BoringLayout;->mPaint:Landroid/graphics/Paint;

    .line 185
    if-eqz p8, :cond_61

    .line 186
    move-object/from16 v0, p7

    iget v2, v0, Landroid/graphics/Paint$FontMetricsInt;->bottom:I

    move-object/from16 v0, p7

    iget v3, v0, Landroid/graphics/Paint$FontMetricsInt;->top:I

    sub-int v10, v2, v3

    .line 191
    .local v10, spacing:I
    :goto_1c
    const/high16 v2, 0x3f80

    cmpl-float v2, p5, v2

    if-nez v2, :cond_27

    const/4 v2, 0x0

    cmpl-float v2, p6, v2

    if-eqz v2, :cond_30

    .line 192
    :cond_27
    int-to-float v2, v10

    mul-float v2, v2, p5

    add-float v2, v2, p6

    const/high16 v3, 0x3f00

    add-float/2addr v2, v3

    float-to-int v10, v2

    .line 195
    :cond_30
    iput v10, p0, Landroid/text/BoringLayout;->mBottom:I

    .line 197
    if-eqz p8, :cond_6c

    .line 198
    move-object/from16 v0, p7

    iget v2, v0, Landroid/graphics/Paint$FontMetricsInt;->top:I

    add-int/2addr v2, v10

    iput v2, p0, Landroid/text/BoringLayout;->mDesc:I

    .line 203
    :goto_3b
    if-eqz p9, :cond_74

    .line 204
    move-object/from16 v0, p7

    iget v2, v0, Landroid/text/BoringLayout$Metrics;->width:I

    int-to-float v2, v2

    iput v2, p0, Landroid/text/BoringLayout;->mMax:F

    .line 218
    :goto_44
    if-eqz p8, :cond_5c

    .line 219
    move-object/from16 v0, p7

    iget v2, v0, Landroid/graphics/Paint$FontMetricsInt;->top:I

    move-object/from16 v0, p7

    iget v3, v0, Landroid/graphics/Paint$FontMetricsInt;->ascent:I

    sub-int/2addr v2, v3

    iput v2, p0, Landroid/text/BoringLayout;->mTopPadding:I

    .line 220
    move-object/from16 v0, p7

    iget v2, v0, Landroid/graphics/Paint$FontMetricsInt;->bottom:I

    move-object/from16 v0, p7

    iget v3, v0, Landroid/graphics/Paint$FontMetricsInt;->descent:I

    sub-int/2addr v2, v3

    iput v2, p0, Landroid/text/BoringLayout;->mBottomPadding:I

    .line 222
    :cond_5c
    return-void

    .line 180
    .end local v10           #spacing:I
    :cond_5d
    const/4 v2, 0x0

    iput-object v2, p0, Landroid/text/BoringLayout;->mDirect:Ljava/lang/String;

    goto :goto_e

    .line 188
    :cond_61
    move-object/from16 v0, p7

    iget v2, v0, Landroid/graphics/Paint$FontMetricsInt;->descent:I

    move-object/from16 v0, p7

    iget v3, v0, Landroid/graphics/Paint$FontMetricsInt;->ascent:I

    sub-int v10, v2, v3

    .restart local v10       #spacing:I
    goto :goto_1c

    .line 200
    :cond_6c
    move-object/from16 v0, p7

    iget v2, v0, Landroid/graphics/Paint$FontMetricsInt;->ascent:I

    add-int/2addr v2, v10

    iput v2, p0, Landroid/text/BoringLayout;->mDesc:I

    goto :goto_3b

    .line 211
    :cond_74
    invoke-static {}, Landroid/text/TextLine;->obtain()Landroid/text/TextLine;

    move-result-object v1

    .line 212
    .local v1, line:Landroid/text/TextLine;
    const/4 v4, 0x0

    invoke-interface {p1}, Ljava/lang/CharSequence;->length()I

    move-result v5

    const/4 v6, 0x1

    sget-object v7, Landroid/text/Layout;->DIRS_ALL_LEFT_TO_RIGHT:Landroid/text/Layout$Directions;

    const/4 v8, 0x0

    const/4 v9, 0x0

    move-object v2, p2

    move-object v3, p1

    invoke-virtual/range {v1 .. v9}, Landroid/text/TextLine;->set(Landroid/text/TextPaint;Ljava/lang/CharSequence;IIILandroid/text/Layout$Directions;ZLandroid/text/Layout$TabStops;)V

    .line 214
    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/text/TextLine;->metrics(Landroid/graphics/Paint$FontMetricsInt;)F

    move-result v2

    invoke-static {v2}, Landroid/util/FloatMath;->ceil(F)F

    move-result v2

    float-to-int v2, v2

    int-to-float v2, v2

    iput v2, p0, Landroid/text/BoringLayout;->mMax:F

    .line 215
    invoke-static {v1}, Landroid/text/TextLine;->recycle(Landroid/text/TextLine;)Landroid/text/TextLine;

    goto :goto_44
.end method

.method public replaceOrMake(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFLandroid/text/BoringLayout$Metrics;Z)Landroid/text/BoringLayout;
    .registers 19
    .parameter "source"
    .parameter "paint"
    .parameter "outerwidth"
    .parameter "align"
    .parameter "spacingmult"
    .parameter "spacingadd"
    .parameter "metrics"
    .parameter "includepad"

    .prologue
    .line 70
    invoke-virtual/range {p0 .. p6}, Landroid/text/BoringLayout;->replaceWith(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;FF)V

    .line 73
    iput p3, p0, Landroid/text/BoringLayout;->mEllipsizedWidth:I

    .line 74
    const/4 v0, 0x0

    iput v0, p0, Landroid/text/BoringLayout;->mEllipsizedStart:I

    .line 75
    const/4 v0, 0x0

    iput v0, p0, Landroid/text/BoringLayout;->mEllipsizedCount:I

    .line 77
    const/4 v9, 0x1

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move v3, p3

    move-object v4, p4

    move v5, p5

    move/from16 v6, p6

    move-object/from16 v7, p7

    move/from16 v8, p8

    invoke-virtual/range {v0 .. v9}, Landroid/text/BoringLayout;->init(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFLandroid/text/BoringLayout$Metrics;ZZ)V

    .line 79
    return-object p0
.end method

.method public replaceOrMake(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFLandroid/text/BoringLayout$Metrics;ZLandroid/text/TextUtils$TruncateAt;I)Landroid/text/BoringLayout;
    .registers 22
    .parameter "source"
    .parameter "paint"
    .parameter "outerwidth"
    .parameter "align"
    .parameter "spacingmult"
    .parameter "spacingadd"
    .parameter "metrics"
    .parameter "includepad"
    .parameter "ellipsize"
    .parameter "ellipsizedWidth"

    .prologue
    .line 96
    if-eqz p9, :cond_8

    sget-object v1, Landroid/text/TextUtils$TruncateAt;->MARQUEE:Landroid/text/TextUtils$TruncateAt;

    move-object/from16 v0, p9

    if-ne v0, v1, :cond_28

    .line 97
    :cond_8
    invoke-virtual/range {p0 .. p6}, Landroid/text/BoringLayout;->replaceWith(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;FF)V

    .line 100
    iput p3, p0, Landroid/text/BoringLayout;->mEllipsizedWidth:I

    .line 101
    const/4 v1, 0x0

    iput v1, p0, Landroid/text/BoringLayout;->mEllipsizedStart:I

    .line 102
    const/4 v1, 0x0

    iput v1, p0, Landroid/text/BoringLayout;->mEllipsizedCount:I

    .line 103
    const/4 v10, 0x1

    .line 114
    .local v10, trust:Z
    :goto_14
    invoke-virtual {p0}, Landroid/text/BoringLayout;->getText()Ljava/lang/CharSequence;

    move-result-object v2

    move-object v1, p0

    move-object v3, p2

    move v4, p3

    move-object v5, p4

    move/from16 v6, p5

    move/from16 v7, p6

    move-object/from16 v8, p7

    move/from16 v9, p8

    invoke-virtual/range {v1 .. v10}, Landroid/text/BoringLayout;->init(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFLandroid/text/BoringLayout$Metrics;ZZ)V

    .line 116
    return-object p0

    .line 105
    .end local v10           #trust:Z
    :cond_28
    move/from16 v0, p10

    int-to-float v3, v0

    const/4 v5, 0x1

    move-object v1, p1

    move-object v2, p2

    move-object/from16 v4, p9

    move-object v6, p0

    invoke-static/range {v1 .. v6}, Landroid/text/TextUtils;->ellipsize(Ljava/lang/CharSequence;Landroid/text/TextPaint;FLandroid/text/TextUtils$TruncateAt;ZLandroid/text/TextUtils$EllipsizeCallback;)Ljava/lang/CharSequence;

    move-result-object v2

    move-object v1, p0

    move-object v3, p2

    move v4, p3

    move-object v5, p4

    move/from16 v6, p5

    move/from16 v7, p6

    invoke-virtual/range {v1 .. v7}, Landroid/text/BoringLayout;->replaceWith(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;FF)V

    .line 110
    move/from16 v0, p10

    iput v0, p0, Landroid/text/BoringLayout;->mEllipsizedWidth:I

    .line 111
    const/4 v10, 0x0

    .restart local v10       #trust:Z
    goto :goto_14
.end method
