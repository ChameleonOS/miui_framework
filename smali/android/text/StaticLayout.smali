.class public Landroid/text/StaticLayout;
.super Landroid/text/Layout;
.source "StaticLayout.java"


# static fields
.field private static final CHAR_COLON:C = ':'

.field private static final CHAR_COMMA:C = ','

.field private static final CHAR_DOT:C = '.'

.field private static final CHAR_FIRST_CJK:C = '\u2e80'

.field private static final CHAR_FIRST_HIGH_SURROGATE:I = 0xd800

.field private static final CHAR_HYPHEN:C = '-'

.field private static final CHAR_LAST_LOW_SURROGATE:I = 0xdfff

.field private static final CHAR_NEW_LINE:C = '\n'

.field private static final CHAR_SEMICOLON:C = ';'

.field private static final CHAR_SLASH:C = '/'

.field private static final CHAR_SPACE:C = ' '

.field private static final CHAR_TAB:C = '\t'

.field private static final COLUMNS_ELLIPSIZE:I = 0x5

.field private static final COLUMNS_NORMAL:I = 0x3

.field private static final DESCENT:I = 0x2

.field private static final DIR:I = 0x0

.field private static final DIR_SHIFT:I = 0x1e

.field private static final ELLIPSIS_COUNT:I = 0x4

.field private static final ELLIPSIS_START:I = 0x3

.field private static final EXTRA_ROUNDING:D = 0.5

.field private static final START:I = 0x0

.field private static final START_MASK:I = 0x1fffffff

.field private static final TAB:I = 0x0

.field private static final TAB_INCREMENT:I = 0x14

.field private static final TAB_MASK:I = 0x20000000

.field static final TAG:Ljava/lang/String; = "StaticLayout"

.field private static final TOP:I = 0x1


# instance fields
.field private mBottomPadding:I

.field private mColumns:I

.field private mEllipsizedWidth:I

.field private mFontMetricsInt:Landroid/graphics/Paint$FontMetricsInt;

.field private mLineCount:I

.field private mLineDirections:[Landroid/text/Layout$Directions;

.field private mLines:[I

.field private mMaximumVisibleLineCount:I

.field private mMeasured:Landroid/text/MeasuredText;

.field private mTopPadding:I


# direct methods
.method constructor <init>(Ljava/lang/CharSequence;)V
    .registers 9
    .parameter "text"

    .prologue
    const/4 v2, 0x0

    const/4 v5, 0x0

    .line 149
    const/4 v3, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v4, v2

    move v6, v5

    invoke-direct/range {v0 .. v6}, Landroid/text/Layout;-><init>(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;FF)V

    .line 962
    const v0, 0x7fffffff

    iput v0, p0, Landroid/text/StaticLayout;->mMaximumVisibleLineCount:I

    .line 991
    new-instance v0, Landroid/graphics/Paint$FontMetricsInt;

    invoke-direct {v0}, Landroid/graphics/Paint$FontMetricsInt;-><init>()V

    iput-object v0, p0, Landroid/text/StaticLayout;->mFontMetricsInt:Landroid/graphics/Paint$FontMetricsInt;

    .line 151
    const/4 v0, 0x5

    iput v0, p0, Landroid/text/StaticLayout;->mColumns:I

    .line 152
    iget v0, p0, Landroid/text/StaticLayout;->mColumns:I

    mul-int/lit8 v0, v0, 0x2

    invoke-static {v0}, Lcom/android/internal/util/ArrayUtils;->idealIntArraySize(I)I

    move-result v0

    new-array v0, v0, [I

    iput-object v0, p0, Landroid/text/StaticLayout;->mLines:[I

    .line 153
    iget v0, p0, Landroid/text/StaticLayout;->mColumns:I

    mul-int/lit8 v0, v0, 0x2

    invoke-static {v0}, Lcom/android/internal/util/ArrayUtils;->idealIntArraySize(I)I

    move-result v0

    new-array v0, v0, [Landroid/text/Layout$Directions;

    iput-object v0, p0, Landroid/text/StaticLayout;->mLineDirections:[Landroid/text/Layout$Directions;

    .line 155
    invoke-static {}, Landroid/text/MeasuredText;->obtain()Landroid/text/MeasuredText;

    move-result-object v0

    iput-object v0, p0, Landroid/text/StaticLayout;->mMeasured:Landroid/text/MeasuredText;

    .line 156
    return-void
.end method

.method public constructor <init>(Ljava/lang/CharSequence;IILandroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFZ)V
    .registers 22
    .parameter "source"
    .parameter "bufstart"
    .parameter "bufend"
    .parameter "paint"
    .parameter "outerwidth"
    .parameter "align"
    .parameter "spacingmult"
    .parameter "spacingadd"
    .parameter "includepad"

    .prologue
    .line 68
    const/4 v10, 0x0

    const/4 v11, 0x0

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move v3, p3

    move-object/from16 v4, p4

    move/from16 v5, p5

    move-object/from16 v6, p6

    move/from16 v7, p7

    move/from16 v8, p8

    move/from16 v9, p9

    invoke-direct/range {v0 .. v11}, Landroid/text/StaticLayout;-><init>(Ljava/lang/CharSequence;IILandroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFZLandroid/text/TextUtils$TruncateAt;I)V

    .line 70
    return-void
.end method

.method public constructor <init>(Ljava/lang/CharSequence;IILandroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFZLandroid/text/TextUtils$TruncateAt;I)V
    .registers 26
    .parameter "source"
    .parameter "bufstart"
    .parameter "bufend"
    .parameter "paint"
    .parameter "outerwidth"
    .parameter "align"
    .parameter "spacingmult"
    .parameter "spacingadd"
    .parameter "includepad"
    .parameter "ellipsize"
    .parameter "ellipsizedWidth"

    .prologue
    .line 90
    sget-object v7, Landroid/text/TextDirectionHeuristics;->FIRSTSTRONG_LTR:Landroid/text/TextDirectionHeuristic;

    const v13, 0x7fffffff

    move-object v0, p0

    move-object v1, p1

    move/from16 v2, p2

    move/from16 v3, p3

    move-object/from16 v4, p4

    move/from16 v5, p5

    move-object/from16 v6, p6

    move/from16 v8, p7

    move/from16 v9, p8

    move/from16 v10, p9

    move-object/from16 v11, p10

    move/from16 v12, p11

    invoke-direct/range {v0 .. v13}, Landroid/text/StaticLayout;-><init>(Ljava/lang/CharSequence;IILandroid/text/TextPaint;ILandroid/text/Layout$Alignment;Landroid/text/TextDirectionHeuristic;FFZLandroid/text/TextUtils$TruncateAt;II)V

    .line 93
    return-void
.end method

.method public constructor <init>(Ljava/lang/CharSequence;IILandroid/text/TextPaint;ILandroid/text/Layout$Alignment;Landroid/text/TextDirectionHeuristic;FFZ)V
    .registers 25
    .parameter "source"
    .parameter "bufstart"
    .parameter "bufend"
    .parameter "paint"
    .parameter "outerwidth"
    .parameter "align"
    .parameter "textDir"
    .parameter "spacingmult"
    .parameter "spacingadd"
    .parameter "includepad"

    .prologue
    .line 80
    const/4 v11, 0x0

    const/4 v12, 0x0

    const v13, 0x7fffffff

    move-object v0, p0

    move-object v1, p1

    move/from16 v2, p2

    move/from16 v3, p3

    move-object/from16 v4, p4

    move/from16 v5, p5

    move-object/from16 v6, p6

    move-object/from16 v7, p7

    move/from16 v8, p8

    move/from16 v9, p9

    move/from16 v10, p10

    invoke-direct/range {v0 .. v13}, Landroid/text/StaticLayout;-><init>(Ljava/lang/CharSequence;IILandroid/text/TextPaint;ILandroid/text/Layout$Alignment;Landroid/text/TextDirectionHeuristic;FFZLandroid/text/TextUtils$TruncateAt;II)V

    .line 82
    return-void
.end method

.method public constructor <init>(Ljava/lang/CharSequence;IILandroid/text/TextPaint;ILandroid/text/Layout$Alignment;Landroid/text/TextDirectionHeuristic;FFZLandroid/text/TextUtils$TruncateAt;II)V
    .registers 29
    .parameter "source"
    .parameter "bufstart"
    .parameter "bufend"
    .parameter "paint"
    .parameter "outerwidth"
    .parameter "align"
    .parameter "textDir"
    .parameter "spacingmult"
    .parameter "spacingadd"
    .parameter "includepad"
    .parameter "ellipsize"
    .parameter "ellipsizedWidth"
    .parameter "maxLines"

    .prologue
    .line 104
    if-nez p11, :cond_84

    move-object/from16 v2, p1

    :goto_4
    move-object v1, p0

    move-object/from16 v3, p4

    move/from16 v4, p5

    move-object/from16 v5, p6

    move-object/from16 v6, p7

    move/from16 v7, p8

    move/from16 v8, p9

    invoke-direct/range {v1 .. v8}, Landroid/text/Layout;-><init>(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;Landroid/text/TextDirectionHeuristic;FF)V

    .line 962
    const v1, 0x7fffffff

    iput v1, p0, Landroid/text/StaticLayout;->mMaximumVisibleLineCount:I

    .line 991
    new-instance v1, Landroid/graphics/Paint$FontMetricsInt;

    invoke-direct {v1}, Landroid/graphics/Paint$FontMetricsInt;-><init>()V

    iput-object v1, p0, Landroid/text/StaticLayout;->mFontMetricsInt:Landroid/graphics/Paint$FontMetricsInt;

    .line 119
    if-eqz p11, :cond_9c

    .line 120
    invoke-virtual {p0}, Landroid/text/StaticLayout;->getText()Ljava/lang/CharSequence;

    move-result-object v14

    check-cast v14, Landroid/text/Layout$Ellipsizer;

    .line 122
    .local v14, e:Landroid/text/Layout$Ellipsizer;
    iput-object p0, v14, Landroid/text/Layout$Ellipsizer;->mLayout:Landroid/text/Layout;

    .line 123
    move/from16 v0, p12

    iput v0, v14, Landroid/text/Layout$Ellipsizer;->mWidth:I

    .line 124
    move-object/from16 v0, p11

    iput-object v0, v14, Landroid/text/Layout$Ellipsizer;->mMethod:Landroid/text/TextUtils$TruncateAt;

    .line 125
    move/from16 v0, p12

    iput v0, p0, Landroid/text/StaticLayout;->mEllipsizedWidth:I

    .line 127
    const/4 v1, 0x5

    iput v1, p0, Landroid/text/StaticLayout;->mColumns:I

    .line 133
    .end local v14           #e:Landroid/text/Layout$Ellipsizer;
    :goto_39
    iget v1, p0, Landroid/text/StaticLayout;->mColumns:I

    mul-int/lit8 v1, v1, 0x2

    invoke-static {v1}, Lcom/android/internal/util/ArrayUtils;->idealIntArraySize(I)I

    move-result v1

    new-array v1, v1, [I

    iput-object v1, p0, Landroid/text/StaticLayout;->mLines:[I

    .line 134
    iget v1, p0, Landroid/text/StaticLayout;->mColumns:I

    mul-int/lit8 v1, v1, 0x2

    invoke-static {v1}, Lcom/android/internal/util/ArrayUtils;->idealIntArraySize(I)I

    move-result v1

    new-array v1, v1, [Landroid/text/Layout$Directions;

    iput-object v1, p0, Landroid/text/StaticLayout;->mLineDirections:[Landroid/text/Layout$Directions;

    .line 136
    move/from16 v0, p13

    iput v0, p0, Landroid/text/StaticLayout;->mMaximumVisibleLineCount:I

    .line 138
    invoke-static {}, Landroid/text/MeasuredText;->obtain()Landroid/text/MeasuredText;

    move-result-object v1

    iput-object v1, p0, Landroid/text/StaticLayout;->mMeasured:Landroid/text/MeasuredText;

    .line 140
    move/from16 v0, p12

    int-to-float v12, v0

    move-object v1, p0

    move-object/from16 v2, p1

    move/from16 v3, p2

    move/from16 v4, p3

    move-object/from16 v5, p4

    move/from16 v6, p5

    move-object/from16 v7, p7

    move/from16 v8, p8

    move/from16 v9, p9

    move/from16 v10, p10

    move/from16 v11, p10

    move-object/from16 v13, p11

    invoke-virtual/range {v1 .. v13}, Landroid/text/StaticLayout;->generate(Ljava/lang/CharSequence;IILandroid/text/TextPaint;ILandroid/text/TextDirectionHeuristic;FFZZFLandroid/text/TextUtils$TruncateAt;)V

    .line 144
    iget-object v1, p0, Landroid/text/StaticLayout;->mMeasured:Landroid/text/MeasuredText;

    invoke-static {v1}, Landroid/text/MeasuredText;->recycle(Landroid/text/MeasuredText;)Landroid/text/MeasuredText;

    move-result-object v1

    iput-object v1, p0, Landroid/text/StaticLayout;->mMeasured:Landroid/text/MeasuredText;

    .line 145
    const/4 v1, 0x0

    iput-object v1, p0, Landroid/text/StaticLayout;->mFontMetricsInt:Landroid/graphics/Paint$FontMetricsInt;

    .line 146
    return-void

    .line 104
    :cond_84
    move-object/from16 v0, p1

    instance-of v1, v0, Landroid/text/Spanned;

    if-eqz v1, :cond_93

    new-instance v2, Landroid/text/Layout$SpannedEllipsizer;

    move-object/from16 v0, p1

    invoke-direct {v2, v0}, Landroid/text/Layout$SpannedEllipsizer;-><init>(Ljava/lang/CharSequence;)V

    goto/16 :goto_4

    :cond_93
    new-instance v2, Landroid/text/Layout$Ellipsizer;

    move-object/from16 v0, p1

    invoke-direct {v2, v0}, Landroid/text/Layout$Ellipsizer;-><init>(Ljava/lang/CharSequence;)V

    goto/16 :goto_4

    .line 129
    :cond_9c
    const/4 v1, 0x3

    iput v1, p0, Landroid/text/StaticLayout;->mColumns:I

    .line 130
    move/from16 v0, p5

    iput v0, p0, Landroid/text/StaticLayout;->mEllipsizedWidth:I

    goto :goto_39
.end method

.method public constructor <init>(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFZ)V
    .registers 18
    .parameter "source"
    .parameter "paint"
    .parameter "width"
    .parameter "align"
    .parameter "spacingmult"
    .parameter "spacingadd"
    .parameter "includepad"

    .prologue
    .line 48
    const/4 v2, 0x0

    invoke-interface {p1}, Ljava/lang/CharSequence;->length()I

    move-result v3

    move-object v0, p0

    move-object v1, p1

    move-object v4, p2

    move v5, p3

    move-object v6, p4

    move v7, p5

    move/from16 v8, p6

    move/from16 v9, p7

    invoke-direct/range {v0 .. v9}, Landroid/text/StaticLayout;-><init>(Ljava/lang/CharSequence;IILandroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFZ)V

    .line 50
    return-void
.end method

.method public constructor <init>(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;Landroid/text/TextDirectionHeuristic;FFZ)V
    .registers 20
    .parameter "source"
    .parameter "paint"
    .parameter "width"
    .parameter "align"
    .parameter "textDir"
    .parameter "spacingmult"
    .parameter "spacingadd"
    .parameter "includepad"

    .prologue
    .line 59
    const/4 v2, 0x0

    invoke-interface {p1}, Ljava/lang/CharSequence;->length()I

    move-result v3

    move-object v0, p0

    move-object v1, p1

    move-object v4, p2

    move v5, p3

    move-object v6, p4

    move-object/from16 v7, p5

    move/from16 v8, p6

    move/from16 v9, p7

    move/from16 v10, p8

    invoke-direct/range {v0 .. v10}, Landroid/text/StaticLayout;-><init>(Ljava/lang/CharSequence;IILandroid/text/TextPaint;ILandroid/text/Layout$Alignment;Landroid/text/TextDirectionHeuristic;FFZ)V

    .line 61
    return-void
.end method

.method private calculateEllipsis(II[FIFLandroid/text/TextUtils$TruncateAt;IFLandroid/text/TextPaint;Z)V
    .registers 31
    .parameter "lineStart"
    .parameter "lineEnd"
    .parameter "widths"
    .parameter "widthStart"
    .parameter "avail"
    .parameter "where"
    .parameter "line"
    .parameter "textWidth"
    .parameter "paint"
    .parameter "forceEllipsis"

    .prologue
    .line 735
    cmpg-float v17, p8, p5

    if-gtz v17, :cond_2f

    if-nez p10, :cond_2f

    .line 737
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/text/StaticLayout;->mLines:[I

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget v0, v0, Landroid/text/StaticLayout;->mColumns:I

    move/from16 v18, v0

    mul-int v18, v18, p7

    add-int/lit8 v18, v18, 0x3

    const/16 v19, 0x0

    aput v19, v17, v18

    .line 738
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/text/StaticLayout;->mLines:[I

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget v0, v0, Landroid/text/StaticLayout;->mColumns:I

    move/from16 v18, v0

    mul-int v18, v18, p7

    add-int/lit8 v18, v18, 0x4

    const/16 v19, 0x0

    aput v19, v17, v18

    .line 832
    :goto_2e
    return-void

    .line 742
    :cond_2f
    sget-object v17, Landroid/text/TextUtils$TruncateAt;->END_SMALL:Landroid/text/TextUtils$TruncateAt;

    move-object/from16 v0, p6

    move-object/from16 v1, v17

    if-ne v0, v1, :cond_9e

    sget-object v17, Landroid/text/StaticLayout;->ELLIPSIS_TWO_DOTS:[C

    :goto_39
    const/16 v18, 0x0

    const/16 v19, 0x1

    move-object/from16 v0, p9

    move-object/from16 v1, v17

    move/from16 v2, v18

    move/from16 v3, v19

    invoke-virtual {v0, v1, v2, v3}, Landroid/text/TextPaint;->measureText([CII)F

    move-result v6

    .line 745
    .local v6, ellipsisWidth:F
    const/4 v5, 0x0

    .line 746
    .local v5, ellipsisStart:I
    const/4 v4, 0x0

    .line 747
    .local v4, ellipsisCount:I
    sub-int v10, p2, p1

    .line 750
    .local v10, len:I
    sget-object v17, Landroid/text/TextUtils$TruncateAt;->START:Landroid/text/TextUtils$TruncateAt;

    move-object/from16 v0, p6

    move-object/from16 v1, v17

    if-ne v0, v1, :cond_b8

    .line 751
    move-object/from16 v0, p0

    iget v0, v0, Landroid/text/StaticLayout;->mMaximumVisibleLineCount:I

    move/from16 v17, v0

    const/16 v18, 0x1

    move/from16 v0, v17

    move/from16 v1, v18

    if-ne v0, v1, :cond_a6

    .line 752
    const/4 v15, 0x0

    .line 755
    .local v15, sum:F
    move v7, v10

    .local v7, i:I
    :goto_65
    if-ltz v7, :cond_77

    .line 756
    add-int/lit8 v17, v7, -0x1

    add-int v17, v17, p1

    sub-int v17, v17, p4

    aget v16, p3, v17

    .line 758
    .local v16, w:F
    add-float v17, v16, v15

    add-float v17, v17, v6

    cmpl-float v17, v17, p5

    if-lez v17, :cond_a1

    .line 765
    .end local v16           #w:F
    :cond_77
    const/4 v5, 0x0

    .line 766
    move v4, v7

    .line 830
    .end local v7           #i:I
    .end local v15           #sum:F
    :cond_79
    :goto_79
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/text/StaticLayout;->mLines:[I

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget v0, v0, Landroid/text/StaticLayout;->mColumns:I

    move/from16 v18, v0

    mul-int v18, v18, p7

    add-int/lit8 v18, v18, 0x3

    aput v5, v17, v18

    .line 831
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/text/StaticLayout;->mLines:[I

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget v0, v0, Landroid/text/StaticLayout;->mColumns:I

    move/from16 v18, v0

    mul-int v18, v18, p7

    add-int/lit8 v18, v18, 0x4

    aput v4, v17, v18

    goto :goto_2e

    .line 742
    .end local v4           #ellipsisCount:I
    .end local v5           #ellipsisStart:I
    .end local v6           #ellipsisWidth:F
    .end local v10           #len:I
    :cond_9e
    sget-object v17, Landroid/text/StaticLayout;->ELLIPSIS_NORMAL:[C

    goto :goto_39

    .line 762
    .restart local v4       #ellipsisCount:I
    .restart local v5       #ellipsisStart:I
    .restart local v6       #ellipsisWidth:F
    .restart local v7       #i:I
    .restart local v10       #len:I
    .restart local v15       #sum:F
    .restart local v16       #w:F
    :cond_a1
    add-float v15, v15, v16

    .line 755
    add-int/lit8 v7, v7, -0x1

    goto :goto_65

    .line 768
    .end local v7           #i:I
    .end local v15           #sum:F
    .end local v16           #w:F
    :cond_a6
    const-string v17, "StaticLayout"

    const/16 v18, 0x5

    invoke-static/range {v17 .. v18}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v17

    if-eqz v17, :cond_79

    .line 769
    const-string v17, "StaticLayout"

    const-string v18, "Start Ellipsis only supported with one line"

    invoke-static/range {v17 .. v18}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_79

    .line 772
    :cond_b8
    sget-object v17, Landroid/text/TextUtils$TruncateAt;->END:Landroid/text/TextUtils$TruncateAt;

    move-object/from16 v0, p6

    move-object/from16 v1, v17

    if-eq v0, v1, :cond_d0

    sget-object v17, Landroid/text/TextUtils$TruncateAt;->MARQUEE:Landroid/text/TextUtils$TruncateAt;

    move-object/from16 v0, p6

    move-object/from16 v1, v17

    if-eq v0, v1, :cond_d0

    sget-object v17, Landroid/text/TextUtils$TruncateAt;->END_SMALL:Landroid/text/TextUtils$TruncateAt;

    move-object/from16 v0, p6

    move-object/from16 v1, v17

    if-ne v0, v1, :cond_f4

    .line 774
    :cond_d0
    const/4 v15, 0x0

    .line 777
    .restart local v15       #sum:F
    const/4 v7, 0x0

    .restart local v7       #i:I
    :goto_d2
    if-ge v7, v10, :cond_e2

    .line 778
    add-int v17, v7, p1

    sub-int v17, v17, p4

    aget v16, p3, v17

    .line 780
    .restart local v16       #w:F
    add-float v17, v16, v15

    add-float v17, v17, v6

    cmpl-float v17, v17, p5

    if-lez v17, :cond_ef

    .line 787
    .end local v16           #w:F
    :cond_e2
    move v5, v7

    .line 788
    sub-int v4, v10, v7

    .line 789
    if-eqz p10, :cond_79

    if-nez v4, :cond_79

    if-lez v10, :cond_79

    .line 790
    add-int/lit8 v5, v10, -0x1

    .line 791
    const/4 v4, 0x1

    goto :goto_79

    .line 784
    .restart local v16       #w:F
    :cond_ef
    add-float v15, v15, v16

    .line 777
    add-int/lit8 v7, v7, 0x1

    goto :goto_d2

    .line 795
    .end local v7           #i:I
    .end local v15           #sum:F
    .end local v16           #w:F
    :cond_f4
    move-object/from16 v0, p0

    iget v0, v0, Landroid/text/StaticLayout;->mMaximumVisibleLineCount:I

    move/from16 v17, v0

    const/16 v18, 0x1

    move/from16 v0, v17

    move/from16 v1, v18

    if-ne v0, v1, :cond_13f

    .line 796
    const/4 v11, 0x0

    .local v11, lsum:F
    const/4 v14, 0x0

    .line 797
    .local v14, rsum:F
    const/4 v9, 0x0

    .local v9, left:I
    move v13, v10

    .line 799
    .local v13, right:I
    sub-float v17, p5, v6

    const/high16 v18, 0x4000

    div-float v12, v17, v18

    .line 800
    .local v12, ravail:F
    move v13, v10

    :goto_10d
    if-ltz v13, :cond_11d

    .line 801
    add-int/lit8 v17, v13, -0x1

    add-int v17, v17, p1

    sub-int v17, v17, p4

    aget v16, p3, v17

    .line 803
    .restart local v16       #w:F
    add-float v17, v16, v14

    cmpl-float v17, v17, v12

    if-lez v17, :cond_135

    .line 810
    .end local v16           #w:F
    :cond_11d
    sub-float v17, p5, v6

    sub-float v8, v17, v14

    .line 811
    .local v8, lavail:F
    const/4 v9, 0x0

    :goto_122
    if-ge v9, v13, :cond_130

    .line 812
    add-int v17, v9, p1

    sub-int v17, v17, p4

    aget v16, p3, v17

    .line 814
    .restart local v16       #w:F
    add-float v17, v16, v11

    cmpl-float v17, v17, v8

    if-lez v17, :cond_13a

    .line 821
    .end local v16           #w:F
    :cond_130
    move v5, v9

    .line 822
    sub-int v4, v13, v9

    .line 823
    goto/16 :goto_79

    .line 807
    .end local v8           #lavail:F
    .restart local v16       #w:F
    :cond_135
    add-float v14, v14, v16

    .line 800
    add-int/lit8 v13, v13, -0x1

    goto :goto_10d

    .line 818
    .restart local v8       #lavail:F
    :cond_13a
    add-float v11, v11, v16

    .line 811
    add-int/lit8 v9, v9, 0x1

    goto :goto_122

    .line 824
    .end local v8           #lavail:F
    .end local v9           #left:I
    .end local v11           #lsum:F
    .end local v12           #ravail:F
    .end local v13           #right:I
    .end local v14           #rsum:F
    .end local v16           #w:F
    :cond_13f
    const-string v17, "StaticLayout"

    const/16 v18, 0x5

    invoke-static/range {v17 .. v18}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v17

    if-eqz v17, :cond_79

    .line 825
    const-string v17, "StaticLayout"

    const-string v18, "Middle Ellipsis only supported with one line"

    invoke-static/range {v17 .. v18}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_79
.end method

.method private static final isIdeographic(CZ)Z
    .registers 5
    .parameter "c"
    .parameter "includeNonStarters"

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x1

    .line 521
    const/16 v2, 0x2e80

    if-lt p0, v2, :cond_b

    const/16 v2, 0x2fff

    if-gt p0, v2, :cond_b

    .line 598
    :cond_a
    :goto_a
    return v0

    .line 524
    :cond_b
    const/16 v2, 0x3000

    if-eq p0, v2, :cond_a

    .line 527
    const/16 v2, 0x3040

    if-lt p0, v2, :cond_1f

    const/16 v2, 0x309f

    if-gt p0, v2, :cond_1f

    .line 528
    if-nez p1, :cond_a

    .line 529
    sparse-switch p0, :sswitch_data_74

    goto :goto_a

    :sswitch_1d
    move v0, v1

    .line 546
    goto :goto_a

    .line 551
    :cond_1f
    const/16 v2, 0x30a0

    if-lt p0, v2, :cond_2f

    const/16 v2, 0x30ff

    if-gt p0, v2, :cond_2f

    .line 552
    if-nez p1, :cond_a

    .line 553
    sparse-switch p0, :sswitch_data_b6

    goto :goto_a

    :sswitch_2d
    move v0, v1

    .line 571
    goto :goto_a

    .line 576
    :cond_2f
    const/16 v2, 0x3400

    if-lt p0, v2, :cond_37

    const/16 v2, 0x4db5

    if-le p0, v2, :cond_a

    .line 579
    :cond_37
    const/16 v2, 0x4e00

    if-lt p0, v2, :cond_40

    const v2, 0x9fbb

    if-le p0, v2, :cond_a

    .line 582
    :cond_40
    const v2, 0xf900

    if-lt p0, v2, :cond_4a

    const v2, 0xfad9

    if-le p0, v2, :cond_a

    .line 585
    :cond_4a
    const v2, 0xa000

    if-lt p0, v2, :cond_54

    const v2, 0xa48f

    if-le p0, v2, :cond_a

    .line 588
    :cond_54
    const v2, 0xa490

    if-lt p0, v2, :cond_5e

    const v2, 0xa4cf

    if-le p0, v2, :cond_a

    .line 591
    :cond_5e
    const v2, 0xfe62

    if-lt p0, v2, :cond_68

    const v2, 0xfe66

    if-le p0, v2, :cond_a

    .line 594
    :cond_68
    const v2, 0xff10

    if-lt p0, v2, :cond_72

    const v2, 0xff19

    if-le p0, v2, :cond_a

    :cond_72
    move v0, v1

    .line 598
    goto :goto_a

    .line 529
    :sswitch_data_74
    .sparse-switch
        0x3041 -> :sswitch_1d
        0x3043 -> :sswitch_1d
        0x3045 -> :sswitch_1d
        0x3047 -> :sswitch_1d
        0x3049 -> :sswitch_1d
        0x3063 -> :sswitch_1d
        0x3083 -> :sswitch_1d
        0x3085 -> :sswitch_1d
        0x3087 -> :sswitch_1d
        0x308e -> :sswitch_1d
        0x3095 -> :sswitch_1d
        0x3096 -> :sswitch_1d
        0x309b -> :sswitch_1d
        0x309c -> :sswitch_1d
        0x309d -> :sswitch_1d
        0x309e -> :sswitch_1d
    .end sparse-switch

    .line 553
    :sswitch_data_b6
    .sparse-switch
        0x30a0 -> :sswitch_2d
        0x30a1 -> :sswitch_2d
        0x30a3 -> :sswitch_2d
        0x30a5 -> :sswitch_2d
        0x30a7 -> :sswitch_2d
        0x30a9 -> :sswitch_2d
        0x30c3 -> :sswitch_2d
        0x30e3 -> :sswitch_2d
        0x30e5 -> :sswitch_2d
        0x30e7 -> :sswitch_2d
        0x30ee -> :sswitch_2d
        0x30f5 -> :sswitch_2d
        0x30f6 -> :sswitch_2d
        0x30fb -> :sswitch_2d
        0x30fc -> :sswitch_2d
        0x30fd -> :sswitch_2d
        0x30fe -> :sswitch_2d
    .end sparse-switch
.end method

.method private out(Ljava/lang/CharSequence;IIIIIIIFF[Landroid/text/style/LineHeightSpan;[ILandroid/graphics/Paint$FontMetricsInt;ZZ[BIZIZZ[C[FILandroid/text/TextUtils$TruncateAt;FFLandroid/text/TextPaint;Z)I
    .registers 58
    .parameter "text"
    .parameter "start"
    .parameter "end"
    .parameter "above"
    .parameter "below"
    .parameter "top"
    .parameter "bottom"
    .parameter "v"
    .parameter "spacingmult"
    .parameter "spacingadd"
    .parameter "chooseHt"
    .parameter "chooseHtv"
    .parameter "fm"
    .parameter "hasTabOrEmoji"
    .parameter "needMultiply"
    .parameter "chdirs"
    .parameter "dir"
    .parameter "easy"
    .parameter "bufEnd"
    .parameter "includePad"
    .parameter "trackPad"
    .parameter "chs"
    .parameter "widths"
    .parameter "widthStart"
    .parameter "ellipsize"
    .parameter "ellipsisWidth"
    .parameter "textWidth"
    .parameter "paint"
    .parameter "moreChars"

    .prologue
    .line 612
    move-object/from16 v0, p0

    iget v0, v0, Landroid/text/StaticLayout;->mLineCount:I

    move/from16 v22, v0

    .line 613
    .local v22, j:I
    move-object/from16 v0, p0

    iget v2, v0, Landroid/text/StaticLayout;->mColumns:I

    mul-int v26, v22, v2

    .line 614
    .local v26, off:I
    move-object/from16 v0, p0

    iget v2, v0, Landroid/text/StaticLayout;->mColumns:I

    add-int v2, v2, v26

    add-int/lit8 v27, v2, 0x1

    .line 615
    .local v27, want:I
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/text/StaticLayout;->mLines:[I

    move-object/from16 v24, v0

    .line 617
    .local v24, lines:[I
    move-object/from16 v0, v24

    array-length v2, v0

    move/from16 v0, v27

    if-lt v0, v2, :cond_5d

    .line 618
    add-int/lit8 v2, v27, 0x1

    invoke-static {v2}, Lcom/android/internal/util/ArrayUtils;->idealIntArraySize(I)I

    move-result v25

    .line 619
    .local v25, nlen:I
    move/from16 v0, v25

    new-array v0, v0, [I

    move-object/from16 v19, v0

    .line 620
    .local v19, grow:[I
    const/4 v2, 0x0

    const/4 v3, 0x0

    move-object/from16 v0, v24

    array-length v4, v0

    move-object/from16 v0, v24

    move-object/from16 v1, v19

    invoke-static {v0, v2, v1, v3, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 621
    move-object/from16 v0, v19

    move-object/from16 v1, p0

    iput-object v0, v1, Landroid/text/StaticLayout;->mLines:[I

    .line 622
    move-object/from16 v24, v19

    .line 624
    move/from16 v0, v25

    new-array v0, v0, [Landroid/text/Layout$Directions;

    move-object/from16 v20, v0

    .line 625
    .local v20, grow2:[Landroid/text/Layout$Directions;
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/text/StaticLayout;->mLineDirections:[Landroid/text/Layout$Directions;

    const/4 v3, 0x0

    const/4 v4, 0x0

    move-object/from16 v0, p0

    iget-object v5, v0, Landroid/text/StaticLayout;->mLineDirections:[Landroid/text/Layout$Directions;

    array-length v5, v5

    move-object/from16 v0, v20

    invoke-static {v2, v3, v0, v4, v5}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 627
    move-object/from16 v0, v20

    move-object/from16 v1, p0

    iput-object v0, v1, Landroid/text/StaticLayout;->mLineDirections:[Landroid/text/Layout$Directions;

    .line 630
    .end local v19           #grow:[I
    .end local v20           #grow2:[Landroid/text/Layout$Directions;
    .end local v25           #nlen:I
    :cond_5d
    if-eqz p11, :cond_c8

    .line 631
    move/from16 v0, p4

    move-object/from16 v1, p13

    iput v0, v1, Landroid/graphics/Paint$FontMetricsInt;->ascent:I

    .line 632
    move/from16 v0, p5

    move-object/from16 v1, p13

    iput v0, v1, Landroid/graphics/Paint$FontMetricsInt;->descent:I

    .line 633
    move/from16 v0, p6

    move-object/from16 v1, p13

    iput v0, v1, Landroid/graphics/Paint$FontMetricsInt;->top:I

    .line 634
    move/from16 v0, p7

    move-object/from16 v1, p13

    iput v0, v1, Landroid/graphics/Paint$FontMetricsInt;->bottom:I

    .line 636
    const/16 v21, 0x0

    .local v21, i:I
    :goto_79
    move-object/from16 v0, p11

    array-length v2, v0

    move/from16 v0, v21

    if-ge v0, v2, :cond_b0

    .line 637
    aget-object v2, p11, v21

    instance-of v2, v2, Landroid/text/style/LineHeightSpan$WithDensity;

    if-eqz v2, :cond_9e

    .line 638
    aget-object v2, p11, v21

    check-cast v2, Landroid/text/style/LineHeightSpan$WithDensity;

    aget v6, p12, v21

    move-object/from16 v3, p1

    move/from16 v4, p2

    move/from16 v5, p3

    move/from16 v7, p8

    move-object/from16 v8, p13

    move-object/from16 v9, p28

    invoke-interface/range {v2 .. v9}, Landroid/text/style/LineHeightSpan$WithDensity;->chooseHeight(Ljava/lang/CharSequence;IIIILandroid/graphics/Paint$FontMetricsInt;Landroid/text/TextPaint;)V

    .line 636
    :goto_9b
    add-int/lit8 v21, v21, 0x1

    goto :goto_79

    .line 642
    :cond_9e
    aget-object v2, p11, v21

    aget v6, p12, v21

    move-object/from16 v3, p1

    move/from16 v4, p2

    move/from16 v5, p3

    move/from16 v7, p8

    move-object/from16 v8, p13

    invoke-interface/range {v2 .. v8}, Landroid/text/style/LineHeightSpan;->chooseHeight(Ljava/lang/CharSequence;IIIILandroid/graphics/Paint$FontMetricsInt;)V

    goto :goto_9b

    .line 646
    :cond_b0
    move-object/from16 v0, p13

    iget v0, v0, Landroid/graphics/Paint$FontMetricsInt;->ascent:I

    move/from16 p4, v0

    .line 647
    move-object/from16 v0, p13

    iget v0, v0, Landroid/graphics/Paint$FontMetricsInt;->descent:I

    move/from16 p5, v0

    .line 648
    move-object/from16 v0, p13

    iget v0, v0, Landroid/graphics/Paint$FontMetricsInt;->top:I

    move/from16 p6, v0

    .line 649
    move-object/from16 v0, p13

    iget v0, v0, Landroid/graphics/Paint$FontMetricsInt;->bottom:I

    move/from16 p7, v0

    .line 652
    .end local v21           #i:I
    :cond_c8
    if-nez v22, :cond_d6

    .line 653
    if-eqz p21, :cond_d2

    .line 654
    sub-int v2, p6, p4

    move-object/from16 v0, p0

    iput v2, v0, Landroid/text/StaticLayout;->mTopPadding:I

    .line 657
    :cond_d2
    if-eqz p20, :cond_d6

    .line 658
    move/from16 p4, p6

    .line 661
    :cond_d6
    move/from16 v0, p3

    move/from16 v1, p19

    if-ne v0, v1, :cond_e8

    .line 662
    if-eqz p21, :cond_e4

    .line 663
    sub-int v2, p7, p5

    move-object/from16 v0, p0

    iput v2, v0, Landroid/text/StaticLayout;->mBottomPadding:I

    .line 666
    :cond_e4
    if-eqz p20, :cond_e8

    .line 667
    move/from16 p5, p7

    .line 673
    :cond_e8
    if-eqz p15, :cond_1b3

    .line 674
    sub-int v2, p5, p4

    int-to-float v2, v2

    const/high16 v3, 0x3f80

    sub-float v3, p9, v3

    mul-float/2addr v2, v3

    add-float v2, v2, p10

    float-to-double v15, v2

    .line 675
    .local v15, ex:D
    const-wide/16 v2, 0x0

    cmpl-double v2, v15, v2

    if-ltz v2, :cond_1a9

    .line 676
    const-wide/high16 v2, 0x3fe0

    add-double/2addr v2, v15

    double-to-int v0, v2

    move/from16 v17, v0

    .line 684
    .end local v15           #ex:D
    .local v17, extra:I
    :goto_101
    add-int/lit8 v2, v26, 0x0

    aput p2, v24, v2

    .line 685
    add-int/lit8 v2, v26, 0x1

    aput p8, v24, v2

    .line 686
    add-int/lit8 v2, v26, 0x2

    add-int v3, p5, v17

    aput v3, v24, v2

    .line 688
    sub-int v2, p5, p4

    add-int v2, v2, v17

    add-int p8, p8, v2

    .line 689
    move-object/from16 v0, p0

    iget v2, v0, Landroid/text/StaticLayout;->mColumns:I

    add-int v2, v2, v26

    add-int/lit8 v2, v2, 0x0

    aput p3, v24, v2

    .line 690
    move-object/from16 v0, p0

    iget v2, v0, Landroid/text/StaticLayout;->mColumns:I

    add-int v2, v2, v26

    add-int/lit8 v2, v2, 0x1

    aput p8, v24, v2

    .line 692
    if-eqz p14, :cond_134

    .line 693
    add-int/lit8 v2, v26, 0x0

    aget v3, v24, v2

    const/high16 v4, 0x2000

    or-int/2addr v3, v4

    aput v3, v24, v2

    .line 695
    :cond_134
    add-int/lit8 v2, v26, 0x0

    aget v3, v24, v2

    shl-int/lit8 v4, p17, 0x1e

    or-int/2addr v3, v4

    aput v3, v24, v2

    .line 696
    sget-object v23, Landroid/text/StaticLayout;->DIRS_ALL_LEFT_TO_RIGHT:Landroid/text/Layout$Directions;

    .line 700
    .local v23, linedirs:Landroid/text/Layout$Directions;
    if-eqz p18, :cond_1b7

    .line 701
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/text/StaticLayout;->mLineDirections:[Landroid/text/Layout$Directions;

    aput-object v23, v2, v22

    .line 707
    :goto_147
    if-eqz p25, :cond_19e

    .line 710
    if-nez v22, :cond_1cf

    const/16 v18, 0x1

    .line 711
    .local v18, firstLine:Z
    :goto_14d
    add-int/lit8 v2, v22, 0x1

    move-object/from16 v0, p0

    iget v3, v0, Landroid/text/StaticLayout;->mMaximumVisibleLineCount:I

    if-ne v2, v3, :cond_1d3

    const/4 v13, 0x1

    .line 712
    .local v13, currentLineIsTheLastVisibleOne:Z
    :goto_156
    if-eqz p29, :cond_1d5

    move-object/from16 v0, p0

    iget v2, v0, Landroid/text/StaticLayout;->mLineCount:I

    add-int/lit8 v2, v2, 0x1

    move-object/from16 v0, p0

    iget v3, v0, Landroid/text/StaticLayout;->mMaximumVisibleLineCount:I

    if-ne v2, v3, :cond_1d5

    const/4 v12, 0x1

    .line 714
    .local v12, forceEllipsis:Z
    :goto_165
    move-object/from16 v0, p0

    iget v2, v0, Landroid/text/StaticLayout;->mMaximumVisibleLineCount:I

    const/4 v3, 0x1

    if-ne v2, v3, :cond_16e

    if-nez p29, :cond_172

    :cond_16e
    if-eqz v18, :cond_178

    if-nez p29, :cond_178

    :cond_172
    sget-object v2, Landroid/text/TextUtils$TruncateAt;->MARQUEE:Landroid/text/TextUtils$TruncateAt;

    move-object/from16 v0, p25

    if-ne v0, v2, :cond_184

    :cond_178
    if-nez v18, :cond_1d7

    if-nez v13, :cond_17e

    if-nez p29, :cond_1d7

    :cond_17e
    sget-object v2, Landroid/text/TextUtils$TruncateAt;->END:Landroid/text/TextUtils$TruncateAt;

    move-object/from16 v0, p25

    if-ne v0, v2, :cond_1d7

    :cond_184
    const/4 v14, 0x1

    .line 719
    .local v14, doEllipsis:Z
    :goto_185
    if-eqz v14, :cond_19e

    move-object/from16 v2, p0

    move/from16 v3, p2

    move/from16 v4, p3

    move-object/from16 v5, p23

    move/from16 v6, p24

    move/from16 v7, p26

    move-object/from16 v8, p25

    move/from16 v9, v22

    move/from16 v10, p27

    move-object/from16 v11, p28

    .line 720
    invoke-direct/range {v2 .. v12}, Landroid/text/StaticLayout;->calculateEllipsis(II[FIFLandroid/text/TextUtils$TruncateAt;IFLandroid/text/TextPaint;Z)V

    .line 726
    .end local v12           #forceEllipsis:Z
    .end local v13           #currentLineIsTheLastVisibleOne:Z
    .end local v14           #doEllipsis:Z
    .end local v18           #firstLine:Z
    :cond_19e
    move-object/from16 v0, p0

    iget v2, v0, Landroid/text/StaticLayout;->mLineCount:I

    add-int/lit8 v2, v2, 0x1

    move-object/from16 v0, p0

    iput v2, v0, Landroid/text/StaticLayout;->mLineCount:I

    .line 727
    return p8

    .line 678
    .end local v17           #extra:I
    .end local v23           #linedirs:Landroid/text/Layout$Directions;
    .restart local v15       #ex:D
    :cond_1a9
    neg-double v2, v15

    const-wide/high16 v4, 0x3fe0

    add-double/2addr v2, v4

    double-to-int v2, v2

    neg-int v0, v2

    move/from16 v17, v0

    .restart local v17       #extra:I
    goto/16 :goto_101

    .line 681
    .end local v15           #ex:D
    .end local v17           #extra:I
    :cond_1b3
    const/16 v17, 0x0

    .restart local v17       #extra:I
    goto/16 :goto_101

    .line 703
    .restart local v23       #linedirs:Landroid/text/Layout$Directions;
    :cond_1b7
    move-object/from16 v0, p0

    iget-object v8, v0, Landroid/text/StaticLayout;->mLineDirections:[Landroid/text/Layout$Directions;

    sub-int v4, p2, p24

    sub-int v6, p2, p24

    sub-int v7, p3, p2

    move/from16 v2, p17

    move-object/from16 v3, p16

    move-object/from16 v5, p22

    invoke-static/range {v2 .. v7}, Landroid/text/AndroidBidi;->directions(I[BI[CII)Landroid/text/Layout$Directions;

    move-result-object v2

    aput-object v2, v8, v22

    goto/16 :goto_147

    .line 710
    :cond_1cf
    const/16 v18, 0x0

    goto/16 :goto_14d

    .line 711
    .restart local v18       #firstLine:Z
    :cond_1d3
    const/4 v13, 0x0

    goto :goto_156

    .line 712
    .restart local v13       #currentLineIsTheLastVisibleOne:Z
    :cond_1d5
    const/4 v12, 0x0

    goto :goto_165

    .line 714
    .restart local v12       #forceEllipsis:Z
    :cond_1d7
    const/4 v14, 0x0

    goto :goto_185
.end method


# virtual methods
.method finish()V
    .registers 2

    .prologue
    .line 942
    iget-object v0, p0, Landroid/text/StaticLayout;->mMeasured:Landroid/text/MeasuredText;

    invoke-static {v0}, Landroid/text/MeasuredText;->recycle(Landroid/text/MeasuredText;)Landroid/text/MeasuredText;

    move-result-object v0

    iput-object v0, p0, Landroid/text/StaticLayout;->mMeasured:Landroid/text/MeasuredText;

    .line 943
    return-void
.end method

.method generate(Ljava/lang/CharSequence;IILandroid/text/TextPaint;ILandroid/text/TextDirectionHeuristic;FFZZFLandroid/text/TextUtils$TruncateAt;)V
    .registers 142
    .parameter "source"
    .parameter "bufStart"
    .parameter "bufEnd"
    .parameter "paint"
    .parameter "outerWidth"
    .parameter "textDir"
    .parameter "spacingmult"
    .parameter "spacingadd"
    .parameter "includepad"
    .parameter "trackpad"
    .parameter "ellipsizedWidth"
    .parameter "ellipsize"

    .prologue
    .line 164
    const/4 v5, 0x0

    move-object/from16 v0, p0

    iput v5, v0, Landroid/text/StaticLayout;->mLineCount:I

    .line 166
    const/4 v13, 0x0

    .line 167
    .local v13, v:I
    const/high16 v5, 0x3f80

    cmpl-float v5, p7, v5

    if-nez v5, :cond_11

    const/4 v5, 0x0

    cmpl-float v5, p8, v5

    if-eqz v5, :cond_a1

    :cond_11
    const/16 v20, 0x1

    .line 169
    .local v20, needMultiply:Z
    :goto_13
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/text/StaticLayout;->mFontMetricsInt:Landroid/graphics/Paint$FontMetricsInt;

    move-object/from16 v18, v0

    .line 170
    .local v18, fm:Landroid/graphics/Paint$FontMetricsInt;
    const/16 v17, 0x0

    .line 172
    .local v17, chooseHtv:[I
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/text/StaticLayout;->mMeasured:Landroid/text/MeasuredText;

    move-object/from16 v110, v0

    .line 174
    .local v110, measured:Landroid/text/MeasuredText;
    const/16 v123, 0x0

    .line 175
    .local v123, spanned:Landroid/text/Spanned;
    move-object/from16 v0, p1

    instance-of v5, v0, Landroid/text/Spanned;

    if-eqz v5, :cond_2d

    move-object/from16 v123, p1

    .line 176
    check-cast v123, Landroid/text/Spanned;

    .line 178
    :cond_2d
    const/16 v80, 0x1

    .line 181
    .local v80, DEFAULT_DIR:I
    move/from16 v29, p2

    .local v29, paraStart:I
    :goto_31
    move/from16 v0, v29

    move/from16 v1, p3

    if-gt v0, v1, :cond_475

    .line 182
    const/16 v5, 0xa

    move-object/from16 v0, p1

    move/from16 v1, v29

    move/from16 v2, p3

    invoke-static {v0, v5, v1, v2}, Landroid/text/TextUtils;->indexOf(Ljava/lang/CharSequence;CII)I

    move-result v38

    .line 183
    .local v38, paraEnd:I
    if-gez v38, :cond_a5

    .line 184
    move/from16 v38, p3

    .line 188
    :goto_47
    move-object/from16 v0, p0

    iget v5, v0, Landroid/text/StaticLayout;->mLineCount:I

    add-int/lit8 v97, v5, 0x1

    .line 189
    .local v97, firstWidthLineLimit:I
    move/from16 v96, p5

    .line 190
    .local v96, firstWidth:I
    move/from16 v118, p5

    .line 192
    .local v118, restWidth:I
    const/16 v16, 0x0

    .line 194
    .local v16, chooseHt:[Landroid/text/style/LineHeightSpan;
    if-eqz v123, :cond_fd

    .line 195
    const-class v5, Landroid/text/style/LeadingMarginSpan;

    move-object/from16 v0, v123

    move/from16 v1, v29

    move/from16 v2, v38

    invoke-static {v0, v1, v2, v5}, Landroid/text/StaticLayout;->getParagraphSpans(Landroid/text/Spanned;IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v119

    check-cast v119, [Landroid/text/style/LeadingMarginSpan;

    .line 197
    .local v119, sp:[Landroid/text/style/LeadingMarginSpan;
    const/16 v105, 0x0

    .local v105, i:I
    :goto_65
    move-object/from16 v0, v119

    array-length v5, v0

    move/from16 v0, v105

    if-ge v0, v5, :cond_a8

    .line 198
    aget-object v107, v119, v105

    .line 199
    .local v107, lms:Landroid/text/style/LeadingMarginSpan;
    aget-object v5, v119, v105

    const/4 v6, 0x1

    invoke-interface {v5, v6}, Landroid/text/style/LeadingMarginSpan;->getLeadingMargin(Z)I

    move-result v5

    sub-int v96, v96, v5

    .line 200
    aget-object v5, v119, v105

    const/4 v6, 0x0

    invoke-interface {v5, v6}, Landroid/text/style/LeadingMarginSpan;->getLeadingMargin(Z)I

    move-result v5

    sub-int v118, v118, v5

    .line 206
    move-object/from16 v0, v107

    instance-of v5, v0, Landroid/text/style/LeadingMarginSpan$LeadingMarginSpan2;

    if-eqz v5, :cond_9e

    move-object/from16 v108, v107

    .line 207
    check-cast v108, Landroid/text/style/LeadingMarginSpan$LeadingMarginSpan2;

    .line 208
    .local v108, lms2:Landroid/text/style/LeadingMarginSpan$LeadingMarginSpan2;
    move-object/from16 v0, v123

    move-object/from16 v1, v108

    invoke-interface {v0, v1}, Landroid/text/Spanned;->getSpanStart(Ljava/lang/Object;)I

    move-result v5

    move-object/from16 v0, p0

    invoke-virtual {v0, v5}, Landroid/text/StaticLayout;->getLineForOffset(I)I

    move-result v109

    .line 209
    .local v109, lmsFirstLine:I
    invoke-interface/range {v108 .. v108}, Landroid/text/style/LeadingMarginSpan$LeadingMarginSpan2;->getLeadingMarginLineCount()I

    move-result v5

    add-int v97, v109, v5

    .line 197
    .end local v108           #lms2:Landroid/text/style/LeadingMarginSpan$LeadingMarginSpan2;
    .end local v109           #lmsFirstLine:I
    :cond_9e
    add-int/lit8 v105, v105, 0x1

    goto :goto_65

    .line 167
    .end local v16           #chooseHt:[Landroid/text/style/LineHeightSpan;
    .end local v17           #chooseHtv:[I
    .end local v18           #fm:Landroid/graphics/Paint$FontMetricsInt;
    .end local v20           #needMultiply:Z
    .end local v29           #paraStart:I
    .end local v38           #paraEnd:I
    .end local v80           #DEFAULT_DIR:I
    .end local v96           #firstWidth:I
    .end local v97           #firstWidthLineLimit:I
    .end local v105           #i:I
    .end local v107           #lms:Landroid/text/style/LeadingMarginSpan;
    .end local v110           #measured:Landroid/text/MeasuredText;
    .end local v118           #restWidth:I
    .end local v119           #sp:[Landroid/text/style/LeadingMarginSpan;
    .end local v123           #spanned:Landroid/text/Spanned;
    :cond_a1
    const/16 v20, 0x0

    goto/16 :goto_13

    .line 186
    .restart local v17       #chooseHtv:[I
    .restart local v18       #fm:Landroid/graphics/Paint$FontMetricsInt;
    .restart local v20       #needMultiply:Z
    .restart local v29       #paraStart:I
    .restart local v38       #paraEnd:I
    .restart local v80       #DEFAULT_DIR:I
    .restart local v110       #measured:Landroid/text/MeasuredText;
    .restart local v123       #spanned:Landroid/text/Spanned;
    :cond_a5
    add-int/lit8 v38, v38, 0x1

    goto :goto_47

    .line 213
    .restart local v16       #chooseHt:[Landroid/text/style/LineHeightSpan;
    .restart local v96       #firstWidth:I
    .restart local v97       #firstWidthLineLimit:I
    .restart local v105       #i:I
    .restart local v118       #restWidth:I
    .restart local v119       #sp:[Landroid/text/style/LeadingMarginSpan;
    :cond_a8
    const-class v5, Landroid/text/style/LineHeightSpan;

    move-object/from16 v0, v123

    move/from16 v1, v29

    move/from16 v2, v38

    invoke-static {v0, v1, v2, v5}, Landroid/text/StaticLayout;->getParagraphSpans(Landroid/text/Spanned;IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v16

    .end local v16           #chooseHt:[Landroid/text/style/LineHeightSpan;
    check-cast v16, [Landroid/text/style/LineHeightSpan;

    .line 215
    .restart local v16       #chooseHt:[Landroid/text/style/LineHeightSpan;
    move-object/from16 v0, v16

    array-length v5, v0

    if-eqz v5, :cond_fd

    .line 216
    if-eqz v17, :cond_c5

    move-object/from16 v0, v17

    array-length v5, v0

    move-object/from16 v0, v16

    array-length v6, v0

    if-ge v5, v6, :cond_d0

    .line 218
    :cond_c5
    move-object/from16 v0, v16

    array-length v5, v0

    invoke-static {v5}, Lcom/android/internal/util/ArrayUtils;->idealIntArraySize(I)I

    move-result v5

    new-array v0, v5, [I

    move-object/from16 v17, v0

    .line 222
    :cond_d0
    const/16 v105, 0x0

    :goto_d2
    move-object/from16 v0, v16

    array-length v5, v0

    move/from16 v0, v105

    if-ge v0, v5, :cond_fd

    .line 223
    aget-object v5, v16, v105

    move-object/from16 v0, v123

    invoke-interface {v0, v5}, Landroid/text/Spanned;->getSpanStart(Ljava/lang/Object;)I

    move-result v111

    .line 225
    .local v111, o:I
    move/from16 v0, v111

    move/from16 v1, v29

    if-ge v0, v1, :cond_fa

    .line 229
    move-object/from16 v0, p0

    move/from16 v1, v111

    invoke-virtual {v0, v1}, Landroid/text/StaticLayout;->getLineForOffset(I)I

    move-result v5

    move-object/from16 v0, p0

    invoke-virtual {v0, v5}, Landroid/text/StaticLayout;->getLineTop(I)I

    move-result v5

    aput v5, v17, v105

    .line 222
    :goto_f7
    add-int/lit8 v105, v105, 0x1

    goto :goto_d2

    .line 233
    :cond_fa
    aput v13, v17, v105

    goto :goto_f7

    .line 239
    .end local v105           #i:I
    .end local v111           #o:I
    .end local v119           #sp:[Landroid/text/style/LeadingMarginSpan;
    :cond_fd
    move-object/from16 v0, v110

    move-object/from16 v1, p1

    move/from16 v2, v29

    move/from16 v3, v38

    move-object/from16 v4, p6

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/text/MeasuredText;->setPara(Ljava/lang/CharSequence;IILandroid/text/TextDirectionHeuristic;)V

    .line 240
    move-object/from16 v0, v110

    iget-object v0, v0, Landroid/text/MeasuredText;->mChars:[C

    move-object/from16 v27, v0

    .line 241
    .local v27, chs:[C
    move-object/from16 v0, v110

    iget-object v0, v0, Landroid/text/MeasuredText;->mWidths:[F

    move-object/from16 v28, v0

    .line 242
    .local v28, widths:[F
    move-object/from16 v0, v110

    iget-object v0, v0, Landroid/text/MeasuredText;->mLevels:[B

    move-object/from16 v21, v0

    .line 243
    .local v21, chdirs:[B
    move-object/from16 v0, v110

    iget v0, v0, Landroid/text/MeasuredText;->mDir:I

    move/from16 v22, v0

    .line 244
    .local v22, dir:I
    move-object/from16 v0, v110

    iget-boolean v0, v0, Landroid/text/MeasuredText;->mEasy:Z

    move/from16 v23, v0

    .line 246
    .local v23, easy:Z
    move/from16 v128, v96

    .line 248
    .local v128, width:I
    const/16 v62, 0x0

    .line 250
    .local v62, w:F
    move/from16 v7, v29

    .line 254
    .local v7, here:I
    move/from16 v112, v29

    .line 255
    .local v112, ok:I
    move/from16 v117, v62

    .line 256
    .local v117, okWidth:F
    const/16 v113, 0x0

    .local v113, okAscent:I
    const/16 v115, 0x0

    .local v115, okDescent:I
    const/16 v116, 0x0

    .local v116, okTop:I
    const/16 v114, 0x0

    .line 260
    .local v114, okBottom:I
    move/from16 v98, v29

    .line 261
    .local v98, fit:I
    move/from16 v99, v62

    .line 262
    .local v99, fitWidth:F
    const/16 v39, 0x0

    .local v39, fitAscent:I
    const/16 v40, 0x0

    .local v40, fitDescent:I
    const/16 v41, 0x0

    .local v41, fitTop:I
    const/16 v42, 0x0

    .line 264
    .local v42, fitBottom:I
    const/16 v19, 0x0

    .line 265
    .local v19, hasTabOrEmoji:Z
    const/16 v104, 0x0

    .line 266
    .local v104, hasTab:Z
    const/16 v125, 0x0

    .line 268
    .local v125, tabStops:Landroid/text/Layout$TabStops;
    move/from16 v122, v29

    .local v122, spanStart:I
    :goto_14e
    move/from16 v0, v122

    move/from16 v1, v38

    if-ge v0, v1, :cond_3fe

    .line 270
    if-nez v123, :cond_272

    .line 271
    move/from16 v120, v38

    .line 272
    .local v120, spanEnd:I
    sub-int v121, v120, v122

    .line 273
    .local v121, spanLen:I
    move-object/from16 v0, v110

    move-object/from16 v1, p4

    move/from16 v2, v121

    move-object/from16 v3, v18

    invoke-virtual {v0, v1, v2, v3}, Landroid/text/MeasuredText;->addStyleRun(Landroid/text/TextPaint;ILandroid/graphics/Paint$FontMetricsInt;)F

    .line 284
    :goto_165
    move-object/from16 v0, v18

    iget v0, v0, Landroid/graphics/Paint$FontMetricsInt;->top:I

    move/from16 v103, v0

    .line 285
    .local v103, fmTop:I
    move-object/from16 v0, v18

    iget v0, v0, Landroid/graphics/Paint$FontMetricsInt;->bottom:I

    move/from16 v101, v0

    .line 286
    .local v101, fmBottom:I
    move-object/from16 v0, v18

    iget v0, v0, Landroid/graphics/Paint$FontMetricsInt;->ascent:I

    move/from16 v100, v0

    .line 287
    .local v100, fmAscent:I
    move-object/from16 v0, v18

    iget v0, v0, Landroid/graphics/Paint$FontMetricsInt;->descent:I

    move/from16 v102, v0

    .line 289
    .local v102, fmDescent:I
    move/from16 v106, v122

    .local v106, j:I
    :goto_17f
    move/from16 v0, v106

    move/from16 v1, v120

    if-ge v0, v1, :cond_26e

    .line 290
    sub-int v5, v106, v29

    aget-char v94, v27, v5

    .line 292
    .local v94, c:C
    const/16 v5, 0xa

    move/from16 v0, v94

    if-ne v0, v5, :cond_2a9

    .line 343
    :goto_18f
    move/from16 v0, v128

    int-to-float v5, v0

    cmpg-float v5, v62, v5

    if-gtz v5, :cond_35a

    .line 344
    move/from16 v99, v62

    .line 345
    add-int/lit8 v98, v106, 0x1

    .line 347
    move/from16 v0, v103

    move/from16 v1, v41

    if-ge v0, v1, :cond_1a2

    .line 348
    move/from16 v41, v103

    .line 349
    :cond_1a2
    move/from16 v0, v100

    move/from16 v1, v39

    if-ge v0, v1, :cond_1aa

    .line 350
    move/from16 v39, v100

    .line 351
    :cond_1aa
    move/from16 v0, v102

    move/from16 v1, v40

    if-le v0, v1, :cond_1b2

    .line 352
    move/from16 v40, v102

    .line 353
    :cond_1b2
    move/from16 v0, v101

    move/from16 v1, v42

    if-le v0, v1, :cond_1ba

    .line 354
    move/from16 v42, v101

    .line 371
    :cond_1ba
    const/16 v5, 0x20

    move/from16 v0, v94

    if-eq v0, v5, :cond_240

    const/16 v5, 0x9

    move/from16 v0, v94

    if-eq v0, v5, :cond_240

    const/16 v5, 0x2e

    move/from16 v0, v94

    if-eq v0, v5, :cond_1de

    const/16 v5, 0x2c

    move/from16 v0, v94

    if-eq v0, v5, :cond_1de

    const/16 v5, 0x3a

    move/from16 v0, v94

    if-eq v0, v5, :cond_1de

    const/16 v5, 0x3b

    move/from16 v0, v94

    if-ne v0, v5, :cond_200

    :cond_1de
    add-int/lit8 v5, v106, -0x1

    if-lt v5, v7, :cond_1ee

    add-int/lit8 v5, v106, -0x1

    sub-int v5, v5, v29

    aget-char v5, v27, v5

    invoke-static {v5}, Ljava/lang/Character;->isDigit(C)Z

    move-result v5

    if-nez v5, :cond_200

    :cond_1ee
    add-int/lit8 v5, v106, 0x1

    move/from16 v0, v120

    if-ge v5, v0, :cond_240

    add-int/lit8 v5, v106, 0x1

    sub-int v5, v5, v29

    aget-char v5, v27, v5

    invoke-static {v5}, Ljava/lang/Character;->isDigit(C)Z

    move-result v5

    if-eqz v5, :cond_240

    :cond_200
    const/16 v5, 0x2f

    move/from16 v0, v94

    if-eq v0, v5, :cond_20c

    const/16 v5, 0x2d

    move/from16 v0, v94

    if-ne v0, v5, :cond_21e

    :cond_20c
    add-int/lit8 v5, v106, 0x1

    move/from16 v0, v120

    if-ge v5, v0, :cond_240

    add-int/lit8 v5, v106, 0x1

    sub-int v5, v5, v29

    aget-char v5, v27, v5

    invoke-static {v5}, Ljava/lang/Character;->isDigit(C)Z

    move-result v5

    if-eqz v5, :cond_240

    :cond_21e
    const/16 v5, 0x2e80

    move/from16 v0, v94

    if-lt v0, v5, :cond_264

    const/4 v5, 0x1

    move/from16 v0, v94

    invoke-static {v0, v5}, Landroid/text/StaticLayout;->isIdeographic(CZ)Z

    move-result v5

    if-eqz v5, :cond_264

    add-int/lit8 v5, v106, 0x1

    move/from16 v0, v120

    if-ge v5, v0, :cond_264

    add-int/lit8 v5, v106, 0x1

    sub-int v5, v5, v29

    aget-char v5, v27, v5

    const/4 v6, 0x0

    invoke-static {v5, v6}, Landroid/text/StaticLayout;->isIdeographic(CZ)Z

    move-result v5

    if-eqz v5, :cond_264

    .line 380
    :cond_240
    move/from16 v117, v62

    .line 381
    add-int/lit8 v112, v106, 0x1

    .line 383
    move/from16 v0, v41

    move/from16 v1, v116

    if-ge v0, v1, :cond_24c

    .line 384
    move/from16 v116, v41

    .line 385
    :cond_24c
    move/from16 v0, v39

    move/from16 v1, v113

    if-ge v0, v1, :cond_254

    .line 386
    move/from16 v113, v39

    .line 387
    :cond_254
    move/from16 v0, v40

    move/from16 v1, v115

    if-le v0, v1, :cond_25c

    .line 388
    move/from16 v115, v40

    .line 389
    :cond_25c
    move/from16 v0, v42

    move/from16 v1, v114

    if-le v0, v1, :cond_264

    .line 390
    move/from16 v114, v42

    .line 455
    :cond_264
    move-object/from16 v0, p0

    iget v5, v0, Landroid/text/StaticLayout;->mLineCount:I

    move-object/from16 v0, p0

    iget v6, v0, Landroid/text/StaticLayout;->mMaximumVisibleLineCount:I

    if-lt v5, v6, :cond_3fa

    .line 268
    .end local v94           #c:C
    :cond_26e
    :goto_26e
    move/from16 v122, v120

    goto/16 :goto_14e

    .line 275
    .end local v100           #fmAscent:I
    .end local v101           #fmBottom:I
    .end local v102           #fmDescent:I
    .end local v103           #fmTop:I
    .end local v106           #j:I
    .end local v120           #spanEnd:I
    .end local v121           #spanLen:I
    :cond_272
    const-class v5, Landroid/text/style/MetricAffectingSpan;

    move-object/from16 v0, v123

    move/from16 v1, v122

    move/from16 v2, v38

    invoke-interface {v0, v1, v2, v5}, Landroid/text/Spanned;->nextSpanTransition(IILjava/lang/Class;)I

    move-result v120

    .line 277
    .restart local v120       #spanEnd:I
    sub-int v121, v120, v122

    .line 278
    .restart local v121       #spanLen:I
    const-class v5, Landroid/text/style/MetricAffectingSpan;

    move-object/from16 v0, v123

    move/from16 v1, v122

    move/from16 v2, v120

    invoke-interface {v0, v1, v2, v5}, Landroid/text/Spanned;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v124

    check-cast v124, [Landroid/text/style/MetricAffectingSpan;

    .line 280
    .local v124, spans:[Landroid/text/style/MetricAffectingSpan;
    const-class v5, Landroid/text/style/MetricAffectingSpan;

    move-object/from16 v0, v124

    move-object/from16 v1, v123

    invoke-static {v0, v1, v5}, Landroid/text/TextUtils;->removeEmptySpans([Ljava/lang/Object;Landroid/text/Spanned;Ljava/lang/Class;)[Ljava/lang/Object;

    move-result-object v124

    .end local v124           #spans:[Landroid/text/style/MetricAffectingSpan;
    check-cast v124, [Landroid/text/style/MetricAffectingSpan;

    .line 281
    .restart local v124       #spans:[Landroid/text/style/MetricAffectingSpan;
    move-object/from16 v0, v110

    move-object/from16 v1, p4

    move-object/from16 v2, v124

    move/from16 v3, v121

    move-object/from16 v4, v18

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/text/MeasuredText;->addStyleRun(Landroid/text/TextPaint;[Landroid/text/style/MetricAffectingSpan;ILandroid/graphics/Paint$FontMetricsInt;)F

    goto/16 :goto_165

    .line 294
    .end local v124           #spans:[Landroid/text/style/MetricAffectingSpan;
    .restart local v94       #c:C
    .restart local v100       #fmAscent:I
    .restart local v101       #fmBottom:I
    .restart local v102       #fmDescent:I
    .restart local v103       #fmTop:I
    .restart local v106       #j:I
    :cond_2a9
    const/16 v5, 0x9

    move/from16 v0, v94

    if-ne v0, v5, :cond_2eb

    .line 295
    if-nez v104, :cond_2d5

    .line 296
    const/16 v104, 0x1

    .line 297
    const/16 v19, 0x1

    .line 298
    if-eqz v123, :cond_2d5

    .line 300
    const-class v5, Landroid/text/style/TabStopSpan;

    move-object/from16 v0, v123

    move/from16 v1, v29

    move/from16 v2, v38

    invoke-static {v0, v1, v2, v5}, Landroid/text/StaticLayout;->getParagraphSpans(Landroid/text/Spanned;IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v124

    check-cast v124, [Landroid/text/style/TabStopSpan;

    .line 302
    .local v124, spans:[Landroid/text/style/TabStopSpan;
    move-object/from16 v0, v124

    array-length v5, v0

    if-lez v5, :cond_2d5

    .line 303
    new-instance v125, Landroid/text/Layout$TabStops;

    .end local v125           #tabStops:Landroid/text/Layout$TabStops;
    const/16 v5, 0x14

    move-object/from16 v0, v125

    move-object/from16 v1, v124

    invoke-direct {v0, v5, v1}, Landroid/text/Layout$TabStops;-><init>(I[Ljava/lang/Object;)V

    .line 307
    .end local v124           #spans:[Landroid/text/style/TabStopSpan;
    .restart local v125       #tabStops:Landroid/text/Layout$TabStops;
    :cond_2d5
    if-eqz v125, :cond_2e1

    .line 308
    move-object/from16 v0, v125

    move/from16 v1, v62

    invoke-virtual {v0, v1}, Landroid/text/Layout$TabStops;->nextTab(F)F

    move-result v62

    goto/16 :goto_18f

    .line 310
    :cond_2e1
    const/16 v5, 0x14

    move/from16 v0, v62

    invoke-static {v0, v5}, Landroid/text/Layout$TabStops;->nextDefaultStop(FI)F

    move-result v62

    goto/16 :goto_18f

    .line 312
    :cond_2eb
    const v5, 0xd800

    move/from16 v0, v94

    if-lt v0, v5, :cond_352

    const v5, 0xdfff

    move/from16 v0, v94

    if-gt v0, v5, :cond_352

    add-int/lit8 v5, v106, 0x1

    move/from16 v0, v120

    if-ge v5, v0, :cond_352

    .line 314
    sub-int v5, v106, v29

    move-object/from16 v0, v27

    invoke-static {v0, v5}, Ljava/lang/Character;->codePointAt([CI)I

    move-result v95

    .line 316
    .local v95, emoji:I
    sget v5, Landroid/text/StaticLayout;->MIN_EMOJI:I

    move/from16 v0, v95

    if-lt v0, v5, :cond_34a

    sget v5, Landroid/text/StaticLayout;->MAX_EMOJI:I

    move/from16 v0, v95

    if-gt v0, v5, :cond_34a

    .line 317
    sget-object v5, Landroid/text/StaticLayout;->EMOJI_FACTORY:Landroid/emoji/EmojiFactory;

    move/from16 v0, v95

    invoke-virtual {v5, v0}, Landroid/emoji/EmojiFactory;->getBitmapFromAndroidPua(I)Landroid/graphics/Bitmap;

    move-result-object v93

    .line 319
    .local v93, bm:Landroid/graphics/Bitmap;
    if-eqz v93, :cond_342

    .line 322
    if-nez v123, :cond_33b

    .line 323
    move-object/from16 v126, p4

    .line 328
    .local v126, whichPaint:Landroid/graphics/Paint;
    :goto_321
    invoke-virtual/range {v93 .. v93}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v5

    int-to-float v5, v5

    invoke-virtual/range {v126 .. v126}, Landroid/text/TextPaint;->ascent()F

    move-result v6

    neg-float v6, v6

    mul-float/2addr v5, v6

    invoke-virtual/range {v93 .. v93}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v6

    int-to-float v6, v6

    div-float v127, v5, v6

    .line 330
    .local v127, wid:F
    add-float v62, v62, v127

    .line 331
    const/16 v19, 0x1

    .line 332
    add-int/lit8 v106, v106, 0x1

    .line 333
    goto/16 :goto_18f

    .line 325
    .end local v126           #whichPaint:Landroid/graphics/Paint;
    .end local v127           #wid:F
    :cond_33b
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/text/Layout;->mWorkPaint:Landroid/text/TextPaint;

    move-object/from16 v126, v0

    .restart local v126       #whichPaint:Landroid/graphics/Paint;
    goto :goto_321

    .line 334
    .end local v126           #whichPaint:Landroid/graphics/Paint;
    :cond_342
    sub-int v5, v106, v29

    aget v5, v28, v5

    add-float v62, v62, v5

    goto/16 :goto_18f

    .line 337
    .end local v93           #bm:Landroid/graphics/Bitmap;
    :cond_34a
    sub-int v5, v106, v29

    aget v5, v28, v5

    add-float v62, v62, v5

    goto/16 :goto_18f

    .line 340
    .end local v95           #emoji:I
    :cond_352
    sub-int v5, v106, v29

    aget v5, v28, v5

    add-float v62, v62, v5

    goto/16 :goto_18f

    .line 393
    :cond_35a
    add-int/lit8 v5, v106, 0x1

    move/from16 v0, v120

    if-ge v5, v0, :cond_37f

    const/16 v34, 0x1

    .line 398
    .local v34, moreChars:Z
    :goto_362
    move/from16 v0, v112

    if-eq v0, v7, :cond_3d2

    .line 400
    const/16 v5, 0x20

    move/from16 v0, v94

    if-ne v0, v5, :cond_36e

    add-int/lit8 v112, v106, 0x1

    .line 402
    :cond_36e
    :goto_36e
    move/from16 v0, v112

    move/from16 v1, v120

    if-ge v0, v1, :cond_382

    sub-int v5, v112, v29

    aget-char v5, v27, v5

    const/16 v6, 0x20

    if-ne v5, v6, :cond_382

    .line 403
    add-int/lit8 v112, v112, 0x1

    goto :goto_36e

    .line 393
    .end local v34           #moreChars:Z
    :cond_37f
    const/16 v34, 0x0

    goto :goto_362

    .line 406
    .restart local v34       #moreChars:Z
    :cond_382
    move/from16 v8, v112

    .line 407
    .local v8, endPos:I
    move/from16 v9, v113

    .line 408
    .local v9, above:I
    move/from16 v10, v115

    .line 409
    .local v10, below:I
    move/from16 v11, v116

    .line 410
    .local v11, top:I
    move/from16 v12, v114

    .line 411
    .local v12, bottom:I
    move/from16 v32, v117

    .local v32, currentTextWidth:F
    :goto_38e
    move-object/from16 v5, p0

    move-object/from16 v6, p1

    move/from16 v14, p7

    move/from16 v15, p8

    move/from16 v24, p3

    move/from16 v25, p9

    move/from16 v26, p10

    move-object/from16 v30, p12

    move/from16 v31, p11

    move-object/from16 v33, p4

    .line 428
    invoke-direct/range {v5 .. v34}, Landroid/text/StaticLayout;->out(Ljava/lang/CharSequence;IIIIIIIFF[Landroid/text/style/LineHeightSpan;[ILandroid/graphics/Paint$FontMetricsInt;ZZ[BIZIZZ[C[FILandroid/text/TextUtils$TruncateAt;FFLandroid/text/TextPaint;Z)I

    move-result v13

    .line 435
    move v7, v8

    .line 436
    add-int/lit8 v106, v7, -0x1

    .line 437
    move/from16 v98, v7

    move/from16 v112, v7

    .line 438
    const/16 v62, 0x0

    .line 439
    const/16 v42, 0x0

    move/from16 v41, v42

    move/from16 v40, v42

    move/from16 v39, v42

    .line 440
    const/16 v114, 0x0

    move/from16 v116, v114

    move/from16 v115, v114

    move/from16 v113, v114

    .line 442
    add-int/lit8 v97, v97, -0x1

    if-gtz v97, :cond_3c5

    .line 443
    move/from16 v128, v118

    .line 446
    :cond_3c5
    move/from16 v0, v122

    if-ge v7, v0, :cond_264

    .line 449
    move-object/from16 v0, v110

    invoke-virtual {v0, v7}, Landroid/text/MeasuredText;->setPos(I)V

    .line 450
    move/from16 v120, v7

    .line 451
    goto/16 :goto_26e

    .line 412
    .end local v8           #endPos:I
    .end local v9           #above:I
    .end local v10           #below:I
    .end local v11           #top:I
    .end local v12           #bottom:I
    .end local v32           #currentTextWidth:F
    :cond_3d2
    move/from16 v0, v98

    if-eq v0, v7, :cond_3e3

    .line 413
    move/from16 v8, v98

    .line 414
    .restart local v8       #endPos:I
    move/from16 v9, v39

    .line 415
    .restart local v9       #above:I
    move/from16 v10, v40

    .line 416
    .restart local v10       #below:I
    move/from16 v11, v41

    .line 417
    .restart local v11       #top:I
    move/from16 v12, v42

    .line 418
    .restart local v12       #bottom:I
    move/from16 v32, v99

    .restart local v32       #currentTextWidth:F
    goto :goto_38e

    .line 420
    .end local v8           #endPos:I
    .end local v9           #above:I
    .end local v10           #below:I
    .end local v11           #top:I
    .end local v12           #bottom:I
    .end local v32           #currentTextWidth:F
    :cond_3e3
    add-int/lit8 v8, v7, 0x1

    .line 421
    .restart local v8       #endPos:I
    move-object/from16 v0, v18

    iget v9, v0, Landroid/graphics/Paint$FontMetricsInt;->ascent:I

    .line 422
    .restart local v9       #above:I
    move-object/from16 v0, v18

    iget v10, v0, Landroid/graphics/Paint$FontMetricsInt;->descent:I

    .line 423
    .restart local v10       #below:I
    move-object/from16 v0, v18

    iget v11, v0, Landroid/graphics/Paint$FontMetricsInt;->top:I

    .line 424
    .restart local v11       #top:I
    move-object/from16 v0, v18

    iget v12, v0, Landroid/graphics/Paint$FontMetricsInt;->bottom:I

    .line 425
    .restart local v12       #bottom:I
    sub-int v5, v7, v29

    aget v32, v28, v5

    .restart local v32       #currentTextWidth:F
    goto :goto_38e

    .line 289
    .end local v8           #endPos:I
    .end local v9           #above:I
    .end local v10           #below:I
    .end local v11           #top:I
    .end local v12           #bottom:I
    .end local v32           #currentTextWidth:F
    .end local v34           #moreChars:Z
    :cond_3fa
    add-int/lit8 v106, v106, 0x1

    goto/16 :goto_17f

    .line 461
    .end local v94           #c:C
    .end local v100           #fmAscent:I
    .end local v101           #fmBottom:I
    .end local v102           #fmDescent:I
    .end local v103           #fmTop:I
    .end local v106           #j:I
    .end local v120           #spanEnd:I
    .end local v121           #spanLen:I
    :cond_3fe
    move/from16 v0, v38

    if-eq v0, v7, :cond_46d

    move-object/from16 v0, p0

    iget v5, v0, Landroid/text/StaticLayout;->mLineCount:I

    move-object/from16 v0, p0

    iget v6, v0, Landroid/text/StaticLayout;->mMaximumVisibleLineCount:I

    if-ge v5, v6, :cond_46d

    .line 462
    or-int v5, v41, v42

    or-int v5, v5, v40

    or-int v5, v5, v39

    if-nez v5, :cond_433

    .line 463
    move-object/from16 v0, p4

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Landroid/text/TextPaint;->getFontMetricsInt(Landroid/graphics/Paint$FontMetricsInt;)I

    .line 465
    move-object/from16 v0, v18

    iget v0, v0, Landroid/graphics/Paint$FontMetricsInt;->top:I

    move/from16 v41, v0

    .line 466
    move-object/from16 v0, v18

    iget v0, v0, Landroid/graphics/Paint$FontMetricsInt;->bottom:I

    move/from16 v42, v0

    .line 467
    move-object/from16 v0, v18

    iget v0, v0, Landroid/graphics/Paint$FontMetricsInt;->ascent:I

    move/from16 v39, v0

    .line 468
    move-object/from16 v0, v18

    iget v0, v0, Landroid/graphics/Paint$FontMetricsInt;->descent:I

    move/from16 v40, v0

    .line 473
    :cond_433
    move/from16 v0, v38

    move/from16 v1, p3

    if-eq v0, v1, :cond_4e7

    const/16 v64, 0x1

    :goto_43b
    move-object/from16 v35, p0

    move-object/from16 v36, p1

    move/from16 v37, v7

    move/from16 v43, v13

    move/from16 v44, p7

    move/from16 v45, p8

    move-object/from16 v46, v16

    move-object/from16 v47, v17

    move-object/from16 v48, v18

    move/from16 v49, v19

    move/from16 v50, v20

    move-object/from16 v51, v21

    move/from16 v52, v22

    move/from16 v53, v23

    move/from16 v54, p3

    move/from16 v55, p9

    move/from16 v56, p10

    move-object/from16 v57, v27

    move-object/from16 v58, v28

    move/from16 v59, v29

    move-object/from16 v60, p12

    move/from16 v61, p11

    move-object/from16 v63, p4

    invoke-direct/range {v35 .. v64}, Landroid/text/StaticLayout;->out(Ljava/lang/CharSequence;IIIIIIIFF[Landroid/text/style/LineHeightSpan;[ILandroid/graphics/Paint$FontMetricsInt;ZZ[BIZIZZ[C[FILandroid/text/TextUtils$TruncateAt;FFLandroid/text/TextPaint;Z)I

    move-result v13

    .line 485
    :cond_46d
    move/from16 v29, v38

    .line 487
    move/from16 v0, v38

    move/from16 v1, p3

    if-ne v0, v1, :cond_4eb

    .line 491
    .end local v7           #here:I
    .end local v16           #chooseHt:[Landroid/text/style/LineHeightSpan;
    .end local v19           #hasTabOrEmoji:Z
    .end local v21           #chdirs:[B
    .end local v22           #dir:I
    .end local v23           #easy:Z
    .end local v27           #chs:[C
    .end local v28           #widths:[F
    .end local v38           #paraEnd:I
    .end local v39           #fitAscent:I
    .end local v40           #fitDescent:I
    .end local v41           #fitTop:I
    .end local v42           #fitBottom:I
    .end local v62           #w:F
    .end local v96           #firstWidth:I
    .end local v97           #firstWidthLineLimit:I
    .end local v98           #fit:I
    .end local v99           #fitWidth:F
    .end local v104           #hasTab:Z
    .end local v112           #ok:I
    .end local v113           #okAscent:I
    .end local v114           #okBottom:I
    .end local v115           #okDescent:I
    .end local v116           #okTop:I
    .end local v117           #okWidth:F
    .end local v118           #restWidth:I
    .end local v122           #spanStart:I
    .end local v125           #tabStops:Landroid/text/Layout$TabStops;
    .end local v128           #width:I
    :cond_475
    move/from16 v0, p3

    move/from16 v1, p2

    if-eq v0, v1, :cond_487

    add-int/lit8 v5, p3, -0x1

    move-object/from16 v0, p1

    invoke-interface {v0, v5}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v5

    const/16 v6, 0xa

    if-ne v5, v6, :cond_4e6

    :cond_487
    move-object/from16 v0, p0

    iget v5, v0, Landroid/text/StaticLayout;->mLineCount:I

    move-object/from16 v0, p0

    iget v6, v0, Landroid/text/StaticLayout;->mMaximumVisibleLineCount:I

    if-ge v5, v6, :cond_4e6

    .line 495
    move-object/from16 v0, p4

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Landroid/text/TextPaint;->getFontMetricsInt(Landroid/graphics/Paint$FontMetricsInt;)I

    .line 497
    move-object/from16 v0, v18

    iget v0, v0, Landroid/graphics/Paint$FontMetricsInt;->ascent:I

    move/from16 v67, v0

    move-object/from16 v0, v18

    iget v0, v0, Landroid/graphics/Paint$FontMetricsInt;->descent:I

    move/from16 v68, v0

    move-object/from16 v0, v18

    iget v0, v0, Landroid/graphics/Paint$FontMetricsInt;->top:I

    move/from16 v69, v0

    move-object/from16 v0, v18

    iget v0, v0, Landroid/graphics/Paint$FontMetricsInt;->bottom:I

    move/from16 v70, v0

    const/16 v74, 0x0

    const/16 v75, 0x0

    const/16 v77, 0x0

    const/16 v79, 0x0

    const/16 v81, 0x1

    const/16 v85, 0x0

    const/16 v86, 0x0

    const/16 v90, 0x0

    const/16 v92, 0x0

    move-object/from16 v63, p0

    move-object/from16 v64, p1

    move/from16 v65, p3

    move/from16 v66, p3

    move/from16 v71, v13

    move/from16 v72, p7

    move/from16 v73, p8

    move-object/from16 v76, v18

    move/from16 v78, v20

    move/from16 v82, p3

    move/from16 v83, p9

    move/from16 v84, p10

    move/from16 v87, p2

    move-object/from16 v88, p12

    move/from16 v89, p11

    move-object/from16 v91, p4

    invoke-direct/range {v63 .. v92}, Landroid/text/StaticLayout;->out(Ljava/lang/CharSequence;IIIIIIIFF[Landroid/text/style/LineHeightSpan;[ILandroid/graphics/Paint$FontMetricsInt;ZZ[BIZIZZ[C[FILandroid/text/TextUtils$TruncateAt;FFLandroid/text/TextPaint;Z)I

    move-result v13

    .line 508
    :cond_4e6
    return-void

    .line 473
    .restart local v7       #here:I
    .restart local v16       #chooseHt:[Landroid/text/style/LineHeightSpan;
    .restart local v19       #hasTabOrEmoji:Z
    .restart local v21       #chdirs:[B
    .restart local v22       #dir:I
    .restart local v23       #easy:Z
    .restart local v27       #chs:[C
    .restart local v28       #widths:[F
    .restart local v38       #paraEnd:I
    .restart local v39       #fitAscent:I
    .restart local v40       #fitDescent:I
    .restart local v41       #fitTop:I
    .restart local v42       #fitBottom:I
    .restart local v62       #w:F
    .restart local v96       #firstWidth:I
    .restart local v97       #firstWidthLineLimit:I
    .restart local v98       #fit:I
    .restart local v99       #fitWidth:F
    .restart local v104       #hasTab:Z
    .restart local v112       #ok:I
    .restart local v113       #okAscent:I
    .restart local v114       #okBottom:I
    .restart local v115       #okDescent:I
    .restart local v116       #okTop:I
    .restart local v117       #okWidth:F
    .restart local v118       #restWidth:I
    .restart local v122       #spanStart:I
    .restart local v125       #tabStops:Landroid/text/Layout$TabStops;
    .restart local v128       #width:I
    :cond_4e7
    const/16 v64, 0x0

    goto/16 :goto_43b

    .line 181
    :cond_4eb
    move/from16 v29, v38

    goto/16 :goto_31
.end method

.method public getBottomPadding()I
    .registers 2

    .prologue
    .line 911
    iget v0, p0, Landroid/text/StaticLayout;->mBottomPadding:I

    return v0
.end method

.method public getEllipsisCount(I)I
    .registers 4
    .parameter "line"

    .prologue
    .line 916
    iget v0, p0, Landroid/text/StaticLayout;->mColumns:I

    const/4 v1, 0x5

    if-ge v0, v1, :cond_7

    .line 917
    const/4 v0, 0x0

    .line 920
    :goto_6
    return v0

    :cond_7
    iget-object v0, p0, Landroid/text/StaticLayout;->mLines:[I

    iget v1, p0, Landroid/text/StaticLayout;->mColumns:I

    mul-int/2addr v1, p1

    add-int/lit8 v1, v1, 0x4

    aget v0, v0, v1

    goto :goto_6
.end method

.method public getEllipsisStart(I)I
    .registers 4
    .parameter "line"

    .prologue
    .line 925
    iget v0, p0, Landroid/text/StaticLayout;->mColumns:I

    const/4 v1, 0x5

    if-ge v0, v1, :cond_7

    .line 926
    const/4 v0, 0x0

    .line 929
    :goto_6
    return v0

    :cond_7
    iget-object v0, p0, Landroid/text/StaticLayout;->mLines:[I

    iget v1, p0, Landroid/text/StaticLayout;->mColumns:I

    mul-int/2addr v1, p1

    add-int/lit8 v1, v1, 0x3

    aget v0, v0, v1

    goto :goto_6
.end method

.method public getEllipsizedWidth()I
    .registers 2

    .prologue
    .line 934
    iget v0, p0, Landroid/text/StaticLayout;->mEllipsizedWidth:I

    return v0
.end method

.method public getLineContainsTab(I)Z
    .registers 4
    .parameter "line"

    .prologue
    .line 896
    iget-object v0, p0, Landroid/text/StaticLayout;->mLines:[I

    iget v1, p0, Landroid/text/StaticLayout;->mColumns:I

    mul-int/2addr v1, p1

    add-int/lit8 v1, v1, 0x0

    aget v0, v0, v1

    const/high16 v1, 0x2000

    and-int/2addr v0, v1

    if-eqz v0, :cond_10

    const/4 v0, 0x1

    :goto_f
    return v0

    :cond_10
    const/4 v0, 0x0

    goto :goto_f
.end method

.method public getLineCount()I
    .registers 2

    .prologue
    .line 861
    iget v0, p0, Landroid/text/StaticLayout;->mLineCount:I

    return v0
.end method

.method public getLineDescent(I)I
    .registers 5
    .parameter "line"

    .prologue
    .line 876
    iget-object v1, p0, Landroid/text/StaticLayout;->mLines:[I

    iget v2, p0, Landroid/text/StaticLayout;->mColumns:I

    mul-int/2addr v2, p1

    add-int/lit8 v2, v2, 0x2

    aget v0, v1, v2

    .line 877
    .local v0, descent:I
    iget v1, p0, Landroid/text/StaticLayout;->mMaximumVisibleLineCount:I

    if-lez v1, :cond_1c

    iget v1, p0, Landroid/text/StaticLayout;->mMaximumVisibleLineCount:I

    add-int/lit8 v1, v1, -0x1

    if-lt p1, v1, :cond_1c

    iget v1, p0, Landroid/text/StaticLayout;->mLineCount:I

    if-eq p1, v1, :cond_1c

    .line 879
    invoke-virtual {p0}, Landroid/text/StaticLayout;->getBottomPadding()I

    move-result v1

    add-int/2addr v0, v1

    .line 881
    :cond_1c
    return v0
.end method

.method public final getLineDirections(I)Landroid/text/Layout$Directions;
    .registers 3
    .parameter "line"

    .prologue
    .line 901
    iget-object v0, p0, Landroid/text/StaticLayout;->mLineDirections:[Landroid/text/Layout$Directions;

    aget-object v0, v0, p1

    return-object v0
.end method

.method public getLineForVertical(I)I
    .registers 8
    .parameter "vertical"

    .prologue
    .line 840
    iget v1, p0, Landroid/text/StaticLayout;->mLineCount:I

    .line 841
    .local v1, high:I
    const/4 v3, -0x1

    .line 843
    .local v3, low:I
    iget-object v2, p0, Landroid/text/StaticLayout;->mLines:[I

    .line 844
    .local v2, lines:[I
    :goto_5
    sub-int v4, v1, v3

    const/4 v5, 0x1

    if-le v4, v5, :cond_1b

    .line 845
    add-int v4, v1, v3

    shr-int/lit8 v0, v4, 0x1

    .line 846
    .local v0, guess:I
    iget v4, p0, Landroid/text/StaticLayout;->mColumns:I

    mul-int/2addr v4, v0

    add-int/lit8 v4, v4, 0x1

    aget v4, v2, v4

    if-le v4, p1, :cond_19

    .line 847
    move v1, v0

    goto :goto_5

    .line 849
    :cond_19
    move v3, v0

    goto :goto_5

    .line 852
    .end local v0           #guess:I
    :cond_1b
    if-gez v3, :cond_1e

    .line 853
    const/4 v3, 0x0

    .line 855
    .end local v3           #low:I
    :cond_1e
    return v3
.end method

.method public getLineStart(I)I
    .registers 4
    .parameter "line"

    .prologue
    .line 886
    iget-object v0, p0, Landroid/text/StaticLayout;->mLines:[I

    iget v1, p0, Landroid/text/StaticLayout;->mColumns:I

    mul-int/2addr v1, p1

    add-int/lit8 v1, v1, 0x0

    aget v0, v0, v1

    const v1, 0x1fffffff

    and-int/2addr v0, v1

    return v0
.end method

.method public getLineTop(I)I
    .registers 5
    .parameter "line"

    .prologue
    .line 866
    iget-object v1, p0, Landroid/text/StaticLayout;->mLines:[I

    iget v2, p0, Landroid/text/StaticLayout;->mColumns:I

    mul-int/2addr v2, p1

    add-int/lit8 v2, v2, 0x1

    aget v0, v1, v2

    .line 867
    .local v0, top:I
    iget v1, p0, Landroid/text/StaticLayout;->mMaximumVisibleLineCount:I

    if-lez v1, :cond_1a

    iget v1, p0, Landroid/text/StaticLayout;->mMaximumVisibleLineCount:I

    if-lt p1, v1, :cond_1a

    iget v1, p0, Landroid/text/StaticLayout;->mLineCount:I

    if-eq p1, v1, :cond_1a

    .line 869
    invoke-virtual {p0}, Landroid/text/StaticLayout;->getBottomPadding()I

    move-result v1

    add-int/2addr v0, v1

    .line 871
    :cond_1a
    return v0
.end method

.method public getParagraphDirection(I)I
    .registers 4
    .parameter "line"

    .prologue
    .line 891
    iget-object v0, p0, Landroid/text/StaticLayout;->mLines:[I

    iget v1, p0, Landroid/text/StaticLayout;->mColumns:I

    mul-int/2addr v1, p1

    add-int/lit8 v1, v1, 0x0

    aget v0, v0, v1

    shr-int/lit8 v0, v0, 0x1e

    return v0
.end method

.method public getTopPadding()I
    .registers 2

    .prologue
    .line 906
    iget v0, p0, Landroid/text/StaticLayout;->mTopPadding:I

    return v0
.end method

.method prepare()V
    .registers 2

    .prologue
    .line 938
    invoke-static {}, Landroid/text/MeasuredText;->obtain()Landroid/text/MeasuredText;

    move-result-object v0

    iput-object v0, p0, Landroid/text/StaticLayout;->mMeasured:Landroid/text/MeasuredText;

    .line 939
    return-void
.end method
