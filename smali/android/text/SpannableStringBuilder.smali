.class public Landroid/text/SpannableStringBuilder;
.super Ljava/lang/Object;
.source "SpannableStringBuilder.java"

# interfaces
.implements Ljava/lang/CharSequence;
.implements Landroid/text/GetChars;
.implements Landroid/text/Spannable;
.implements Landroid/text/Editable;
.implements Ljava/lang/Appendable;
.implements Landroid/text/GraphicsOperations;


# static fields
.field private static final END_MASK:I = 0xf

.field private static final MARK:I = 0x1

.field private static final NO_FILTERS:[Landroid/text/InputFilter; = null

.field private static final PARAGRAPH:I = 0x3

.field private static final POINT:I = 0x2

.field private static final SPAN_END_AT_END:I = 0x8000

.field private static final SPAN_END_AT_START:I = 0x4000

.field private static final SPAN_START_AT_END:I = 0x2000

.field private static final SPAN_START_AT_START:I = 0x1000

.field private static final SPAN_START_END_MASK:I = 0xf000

.field private static final START_MASK:I = 0xf0

.field private static final START_SHIFT:I = 0x4


# instance fields
.field private mFilters:[Landroid/text/InputFilter;

.field private mGapLength:I

.field private mGapStart:I

.field private mSpanCount:I

.field private mSpanCountBeforeAdd:I

.field private mSpanEnds:[I

.field private mSpanFlags:[I

.field private mSpanStarts:[I

.field private mSpans:[Ljava/lang/Object;

.field private mText:[C


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 1320
    const/4 v0, 0x0

    new-array v0, v0, [Landroid/text/InputFilter;

    sput-object v0, Landroid/text/SpannableStringBuilder;->NO_FILTERS:[Landroid/text/InputFilter;

    return-void
.end method

.method public constructor <init>()V
    .registers 2

    .prologue
    .line 36
    const-string v0, ""

    invoke-direct {p0, v0}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 37
    return-void
.end method

.method public constructor <init>(Ljava/lang/CharSequence;)V
    .registers 4
    .parameter "text"

    .prologue
    .line 44
    const/4 v0, 0x0

    invoke-interface {p1}, Ljava/lang/CharSequence;->length()I

    move-result v1

    invoke-direct {p0, p1, v0, v1}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;II)V

    .line 45
    return-void
.end method

.method public constructor <init>(Ljava/lang/CharSequence;II)V
    .registers 16
    .parameter "text"
    .parameter "start"
    .parameter "end"

    .prologue
    const/4 v1, 0x0

    .line 51
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 1321
    sget-object v0, Landroid/text/SpannableStringBuilder;->NO_FILTERS:[Landroid/text/InputFilter;

    iput-object v0, p0, Landroid/text/SpannableStringBuilder;->mFilters:[Landroid/text/InputFilter;

    .line 52
    sub-int v11, p3, p2

    .line 54
    .local v11, srclen:I
    if-gez v11, :cond_12

    new-instance v0, Ljava/lang/StringIndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/StringIndexOutOfBoundsException;-><init>()V

    throw v0

    .line 56
    :cond_12
    add-int/lit8 v0, v11, 0x1

    invoke-static {v0}, Lcom/android/internal/util/ArrayUtils;->idealCharArraySize(I)I

    move-result v8

    .line 57
    .local v8, len:I
    new-array v0, v8, [C

    iput-object v0, p0, Landroid/text/SpannableStringBuilder;->mText:[C

    .line 58
    iput v11, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    .line 59
    sub-int v0, v8, v11

    iput v0, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    .line 61
    iget-object v0, p0, Landroid/text/SpannableStringBuilder;->mText:[C

    invoke-static {p1, p2, p3, v0, v1}, Landroid/text/TextUtils;->getChars(Ljava/lang/CharSequence;II[CI)V

    .line 63
    iput v1, p0, Landroid/text/SpannableStringBuilder;->mSpanCount:I

    .line 64
    invoke-static {v1}, Lcom/android/internal/util/ArrayUtils;->idealIntArraySize(I)I

    move-result v6

    .line 65
    .local v6, alloc:I
    new-array v0, v6, [Ljava/lang/Object;

    iput-object v0, p0, Landroid/text/SpannableStringBuilder;->mSpans:[Ljava/lang/Object;

    .line 66
    new-array v0, v6, [I

    iput-object v0, p0, Landroid/text/SpannableStringBuilder;->mSpanStarts:[I

    .line 67
    new-array v0, v6, [I

    iput-object v0, p0, Landroid/text/SpannableStringBuilder;->mSpanEnds:[I

    .line 68
    new-array v0, v6, [I

    iput-object v0, p0, Landroid/text/SpannableStringBuilder;->mSpanFlags:[I

    .line 70
    instance-of v0, p1, Landroid/text/Spanned;

    if-eqz v0, :cond_86

    move-object v9, p1

    .line 71
    check-cast v9, Landroid/text/Spanned;

    .line 72
    .local v9, sp:Landroid/text/Spanned;
    const-class v0, Ljava/lang/Object;

    invoke-interface {v9, p2, p3, v0}, Landroid/text/Spanned;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v10

    .line 74
    .local v10, spans:[Ljava/lang/Object;
    const/4 v7, 0x0

    .local v7, i:I
    :goto_4b
    array-length v0, v10

    if-ge v7, v0, :cond_86

    .line 75
    aget-object v0, v10, v7

    instance-of v0, v0, Landroid/text/NoCopySpan;

    if-eqz v0, :cond_57

    .line 74
    :goto_54
    add-int/lit8 v7, v7, 0x1

    goto :goto_4b

    .line 79
    :cond_57
    aget-object v0, v10, v7

    invoke-interface {v9, v0}, Landroid/text/Spanned;->getSpanStart(Ljava/lang/Object;)I

    move-result v0

    sub-int v3, v0, p2

    .line 80
    .local v3, st:I
    aget-object v0, v10, v7

    invoke-interface {v9, v0}, Landroid/text/Spanned;->getSpanEnd(Ljava/lang/Object;)I

    move-result v0

    sub-int v4, v0, p2

    .line 81
    .local v4, en:I
    aget-object v0, v10, v7

    invoke-interface {v9, v0}, Landroid/text/Spanned;->getSpanFlags(Ljava/lang/Object;)I

    move-result v5

    .line 83
    .local v5, fl:I
    if-gez v3, :cond_70

    .line 84
    const/4 v3, 0x0

    .line 85
    :cond_70
    sub-int v0, p3, p2

    if-le v3, v0, :cond_76

    .line 86
    sub-int v3, p3, p2

    .line 88
    :cond_76
    if-gez v4, :cond_79

    .line 89
    const/4 v4, 0x0

    .line 90
    :cond_79
    sub-int v0, p3, p2

    if-le v4, v0, :cond_7f

    .line 91
    sub-int v4, p3, p2

    .line 93
    :cond_7f
    aget-object v2, v10, v7

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Landroid/text/SpannableStringBuilder;->setSpan(ZLjava/lang/Object;III)V

    goto :goto_54

    .line 96
    .end local v3           #st:I
    .end local v4           #en:I
    .end local v5           #fl:I
    .end local v7           #i:I
    .end local v9           #sp:Landroid/text/Spanned;
    .end local v10           #spans:[Ljava/lang/Object;
    :cond_86
    return-void
.end method

.method private change(IILjava/lang/CharSequence;II)V
    .registers 44
    .parameter "start"
    .parameter "end"
    .parameter "cs"
    .parameter "csStart"
    .parameter "csEnd"

    .prologue
    .line 263
    sub-int v33, p2, p1

    .line 264
    .local v33, replacedLength:I
    sub-int v34, p5, p4

    .line 265
    .local v34, replacementLength:I
    sub-int v12, v34, v33

    .line 267
    .local v12, nbNewChars:I
    move-object/from16 v0, p0

    iget v4, v0, Landroid/text/SpannableStringBuilder;->mSpanCount:I

    add-int/lit8 v30, v4, -0x1

    .local v30, i:I
    :goto_c
    if-ltz v30, :cond_d9

    .line 268
    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/text/SpannableStringBuilder;->mSpanStarts:[I

    aget v7, v4, v30

    .line 269
    .local v7, spanStart:I
    move-object/from16 v0, p0

    iget v4, v0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    if-le v7, v4, :cond_1f

    .line 270
    move-object/from16 v0, p0

    iget v4, v0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    sub-int/2addr v7, v4

    .line 272
    :cond_1f
    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/text/SpannableStringBuilder;->mSpanEnds:[I

    aget v8, v4, v30

    .line 273
    .local v8, spanEnd:I
    move-object/from16 v0, p0

    iget v4, v0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    if-le v8, v4, :cond_30

    .line 274
    move-object/from16 v0, p0

    iget v4, v0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    sub-int/2addr v8, v4

    .line 276
    :cond_30
    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/text/SpannableStringBuilder;->mSpanFlags:[I

    aget v4, v4, v30

    and-int/lit8 v4, v4, 0x33

    const/16 v5, 0x33

    if-ne v4, v5, :cond_9a

    .line 277
    move/from16 v32, v7

    .line 278
    .local v32, ost:I
    move/from16 v31, v8

    .line 279
    .local v31, oen:I
    invoke-virtual/range {p0 .. p0}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v27

    .line 281
    .local v27, clen:I
    move/from16 v0, p1

    if-le v7, v0, :cond_62

    move/from16 v0, p2

    if-gt v7, v0, :cond_62

    .line 282
    move/from16 v7, p2

    :goto_4e
    move/from16 v0, v27

    if-ge v7, v0, :cond_62

    .line 283
    move/from16 v0, p2

    if-le v7, v0, :cond_be

    add-int/lit8 v4, v7, -0x1

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Landroid/text/SpannableStringBuilder;->charAt(I)C

    move-result v4

    const/16 v5, 0xa

    if-ne v4, v5, :cond_be

    .line 287
    :cond_62
    move/from16 v0, p1

    if-le v8, v0, :cond_80

    move/from16 v0, p2

    if-gt v8, v0, :cond_80

    .line 288
    move/from16 v8, p2

    :goto_6c
    move/from16 v0, v27

    if-ge v8, v0, :cond_80

    .line 289
    move/from16 v0, p2

    if-le v8, v0, :cond_c1

    add-int/lit8 v4, v8, -0x1

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Landroid/text/SpannableStringBuilder;->charAt(I)C

    move-result v4

    const/16 v5, 0xa

    if-ne v4, v5, :cond_c1

    .line 293
    :cond_80
    move/from16 v0, v32

    if-ne v7, v0, :cond_88

    move/from16 v0, v31

    if-eq v8, v0, :cond_9a

    .line 294
    :cond_88
    const/4 v5, 0x0

    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/text/SpannableStringBuilder;->mSpans:[Ljava/lang/Object;

    aget-object v6, v4, v30

    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/text/SpannableStringBuilder;->mSpanFlags:[I

    aget v9, v4, v30

    move-object/from16 v4, p0

    invoke-direct/range {v4 .. v9}, Landroid/text/SpannableStringBuilder;->setSpan(ZLjava/lang/Object;III)V

    .line 297
    .end local v27           #clen:I
    .end local v31           #oen:I
    .end local v32           #ost:I
    :cond_9a
    const/16 v29, 0x0

    .line 298
    .local v29, flags:I
    move/from16 v0, p1

    if-ne v7, v0, :cond_c4

    move/from16 v0, v29

    or-int/lit16 v0, v0, 0x1000

    move/from16 v29, v0

    .line 300
    :cond_a6
    :goto_a6
    move/from16 v0, p1

    if-ne v8, v0, :cond_cf

    move/from16 v0, v29

    or-int/lit16 v0, v0, 0x4000

    move/from16 v29, v0

    .line 302
    :cond_b0
    :goto_b0
    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/text/SpannableStringBuilder;->mSpanFlags:[I

    aget v5, v4, v30

    or-int v5, v5, v29

    aput v5, v4, v30

    .line 267
    add-int/lit8 v30, v30, -0x1

    goto/16 :goto_c

    .line 282
    .end local v29           #flags:I
    .restart local v27       #clen:I
    .restart local v31       #oen:I
    .restart local v32       #ost:I
    :cond_be
    add-int/lit8 v7, v7, 0x1

    goto :goto_4e

    .line 288
    :cond_c1
    add-int/lit8 v8, v8, 0x1

    goto :goto_6c

    .line 299
    .end local v27           #clen:I
    .end local v31           #oen:I
    .end local v32           #ost:I
    .restart local v29       #flags:I
    :cond_c4
    add-int v4, p2, v12

    if-ne v7, v4, :cond_a6

    move/from16 v0, v29

    or-int/lit16 v0, v0, 0x2000

    move/from16 v29, v0

    goto :goto_a6

    .line 301
    :cond_cf
    add-int v4, p2, v12

    if-ne v8, v4, :cond_b0

    const v4, 0x8000

    or-int v29, v29, v4

    goto :goto_b0

    .line 305
    .end local v7           #spanStart:I
    .end local v8           #spanEnd:I
    .end local v29           #flags:I
    :cond_d9
    move-object/from16 v0, p0

    move/from16 v1, p2

    invoke-direct {v0, v1}, Landroid/text/SpannableStringBuilder;->moveGapTo(I)V

    .line 307
    move-object/from16 v0, p0

    iget v4, v0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    if-lt v12, v4, :cond_f6

    .line 308
    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/text/SpannableStringBuilder;->mText:[C

    array-length v4, v4

    add-int/2addr v4, v12

    move-object/from16 v0, p0

    iget v5, v0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    sub-int/2addr v4, v5

    move-object/from16 v0, p0

    invoke-direct {v0, v4}, Landroid/text/SpannableStringBuilder;->resizeFor(I)V

    .line 311
    :cond_f6
    if-nez v34, :cond_167

    const/4 v15, 0x1

    .line 314
    .local v15, textIsRemoved:Z
    :goto_f9
    if-lez v33, :cond_16c

    .line 319
    const/16 v30, 0x0

    .line 320
    :goto_fd
    move-object/from16 v0, p0

    iget v4, v0, Landroid/text/SpannableStringBuilder;->mSpanCount:I

    move/from16 v0, v30

    if-ge v0, v4, :cond_16c

    .line 321
    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/text/SpannableStringBuilder;->mSpanFlags:[I

    aget v4, v4, v30

    and-int/lit8 v4, v4, 0x21

    const/16 v5, 0x21

    if-ne v4, v5, :cond_169

    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/text/SpannableStringBuilder;->mSpanStarts:[I

    aget v4, v4, v30

    move/from16 v0, p1

    if-lt v4, v0, :cond_169

    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/text/SpannableStringBuilder;->mSpanStarts:[I

    aget v4, v4, v30

    move-object/from16 v0, p0

    iget v5, v0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    move-object/from16 v0, p0

    iget v6, v0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    add-int/2addr v5, v6

    if-ge v4, v5, :cond_169

    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/text/SpannableStringBuilder;->mSpanEnds:[I

    aget v4, v4, v30

    move/from16 v0, p1

    if-lt v4, v0, :cond_169

    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/text/SpannableStringBuilder;->mSpanEnds:[I

    aget v4, v4, v30

    move-object/from16 v0, p0

    iget v5, v0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    move-object/from16 v0, p0

    iget v6, v0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    add-int/2addr v5, v6

    if-ge v4, v5, :cond_169

    if-nez v15, :cond_15f

    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/text/SpannableStringBuilder;->mSpanStarts:[I

    aget v4, v4, v30

    move/from16 v0, p1

    if-gt v4, v0, :cond_15f

    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/text/SpannableStringBuilder;->mSpanEnds:[I

    aget v4, v4, v30

    move-object/from16 v0, p0

    iget v5, v0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    if-ge v4, v5, :cond_169

    .line 327
    :cond_15f
    move-object/from16 v0, p0

    move/from16 v1, v30

    invoke-direct {v0, v1}, Landroid/text/SpannableStringBuilder;->removeSpan(I)V

    goto :goto_fd

    .line 311
    .end local v15           #textIsRemoved:Z
    :cond_167
    const/4 v15, 0x0

    goto :goto_f9

    .line 331
    .restart local v15       #textIsRemoved:Z
    :cond_169
    add-int/lit8 v30, v30, 0x1

    goto :goto_fd

    .line 335
    :cond_16c
    move-object/from16 v0, p0

    iget v4, v0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    add-int/2addr v4, v12

    move-object/from16 v0, p0

    iput v4, v0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    .line 336
    move-object/from16 v0, p0

    iget v4, v0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    sub-int/2addr v4, v12

    move-object/from16 v0, p0

    iput v4, v0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    .line 338
    move-object/from16 v0, p0

    iget v4, v0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    const/4 v5, 0x1

    if-ge v4, v5, :cond_18f

    .line 339
    new-instance v4, Ljava/lang/Exception;

    const-string v5, "mGapLength < 1"

    invoke-direct {v4, v5}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4}, Ljava/lang/Exception;->printStackTrace()V

    .line 341
    :cond_18f
    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/text/SpannableStringBuilder;->mText:[C

    move-object/from16 v0, p3

    move/from16 v1, p4

    move/from16 v2, p5

    move/from16 v3, p1

    invoke-static {v0, v1, v2, v4, v3}, Landroid/text/TextUtils;->getChars(Ljava/lang/CharSequence;II[CI)V

    .line 343
    if-lez v33, :cond_200

    .line 344
    move-object/from16 v0, p0

    iget v4, v0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    move-object/from16 v0, p0

    iget v5, v0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    add-int/2addr v4, v5

    move-object/from16 v0, p0

    iget-object v5, v0, Landroid/text/SpannableStringBuilder;->mText:[C

    array-length v5, v5

    if-ne v4, v5, :cond_1fe

    const/4 v14, 0x1

    .line 346
    .local v14, atEnd:Z
    :goto_1b1
    const/16 v30, 0x0

    :goto_1b3
    move-object/from16 v0, p0

    iget v4, v0, Landroid/text/SpannableStringBuilder;->mSpanCount:I

    move/from16 v0, v30

    if-ge v0, v4, :cond_200

    .line 347
    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/text/SpannableStringBuilder;->mSpanFlags:[I

    aget v4, v4, v30

    and-int/lit16 v4, v4, 0xf0

    shr-int/lit8 v13, v4, 0x4

    .line 348
    .local v13, startFlag:I
    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/text/SpannableStringBuilder;->mSpanStarts:[I

    move-object/from16 v0, p0

    iget-object v5, v0, Landroid/text/SpannableStringBuilder;->mSpanStarts:[I

    aget v10, v5, v30

    move-object/from16 v9, p0

    move/from16 v11, p1

    invoke-direct/range {v9 .. v15}, Landroid/text/SpannableStringBuilder;->updatedIntervalBound(IIIIZZ)I

    move-result v5

    aput v5, v4, v30

    .line 351
    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/text/SpannableStringBuilder;->mSpanFlags:[I

    aget v4, v4, v30

    and-int/lit8 v20, v4, 0xf

    .line 352
    .local v20, endFlag:I
    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/text/SpannableStringBuilder;->mSpanEnds:[I

    move-object/from16 v0, p0

    iget-object v5, v0, Landroid/text/SpannableStringBuilder;->mSpanEnds:[I

    aget v17, v5, v30

    move-object/from16 v16, p0

    move/from16 v18, p1

    move/from16 v19, v12

    move/from16 v21, v14

    move/from16 v22, v15

    invoke-direct/range {v16 .. v22}, Landroid/text/SpannableStringBuilder;->updatedIntervalBound(IIIIZZ)I

    move-result v5

    aput v5, v4, v30

    .line 346
    add-int/lit8 v30, v30, 0x1

    goto :goto_1b3

    .line 344
    .end local v13           #startFlag:I
    .end local v14           #atEnd:Z
    .end local v20           #endFlag:I
    :cond_1fe
    const/4 v14, 0x0

    goto :goto_1b1

    .line 357
    :cond_200
    move-object/from16 v0, p0

    iget v4, v0, Landroid/text/SpannableStringBuilder;->mSpanCount:I

    move-object/from16 v0, p0

    iput v4, v0, Landroid/text/SpannableStringBuilder;->mSpanCountBeforeAdd:I

    .line 359
    move-object/from16 v0, p3

    instance-of v4, v0, Landroid/text/Spanned;

    if-eqz v4, :cond_26d

    move-object/from16 v35, p3

    .line 360
    check-cast v35, Landroid/text/Spanned;

    .line 361
    .local v35, sp:Landroid/text/Spanned;
    const-class v4, Ljava/lang/Object;

    move-object/from16 v0, v35

    move/from16 v1, p4

    move/from16 v2, p5

    invoke-interface {v0, v1, v2, v4}, Landroid/text/Spanned;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v36

    .line 363
    .local v36, spans:[Ljava/lang/Object;
    const/16 v30, 0x0

    :goto_220
    move-object/from16 v0, v36

    array-length v4, v0

    move/from16 v0, v30

    if-ge v0, v4, :cond_26d

    .line 364
    aget-object v4, v36, v30

    move-object/from16 v0, v35

    invoke-interface {v0, v4}, Landroid/text/Spanned;->getSpanStart(Ljava/lang/Object;)I

    move-result v37

    .line 365
    .local v37, st:I
    aget-object v4, v36, v30

    move-object/from16 v0, v35

    invoke-interface {v0, v4}, Landroid/text/Spanned;->getSpanEnd(Ljava/lang/Object;)I

    move-result v28

    .line 367
    .local v28, en:I
    move/from16 v0, v37

    move/from16 v1, p4

    if-ge v0, v1, :cond_23f

    move/from16 v37, p4

    .line 368
    :cond_23f
    move/from16 v0, v28

    move/from16 v1, p5

    if-le v0, v1, :cond_247

    move/from16 v28, p5

    .line 371
    :cond_247
    aget-object v4, v36, v30

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Landroid/text/SpannableStringBuilder;->getSpanStart(Ljava/lang/Object;)I

    move-result v4

    if-gez v4, :cond_26a

    .line 372
    const/16 v22, 0x0

    aget-object v23, v36, v30

    sub-int v4, v37, p4

    add-int v24, v4, p1

    sub-int v4, v28, p4

    add-int v25, v4, p1

    aget-object v4, v36, v30

    move-object/from16 v0, v35

    invoke-interface {v0, v4}, Landroid/text/Spanned;->getSpanFlags(Ljava/lang/Object;)I

    move-result v26

    move-object/from16 v21, p0

    invoke-direct/range {v21 .. v26}, Landroid/text/SpannableStringBuilder;->setSpan(ZLjava/lang/Object;III)V

    .line 363
    :cond_26a
    add-int/lit8 v30, v30, 0x1

    goto :goto_220

    .line 377
    .end local v28           #en:I
    .end local v35           #sp:Landroid/text/Spanned;
    .end local v36           #spans:[Ljava/lang/Object;
    .end local v37           #st:I
    :cond_26d
    return-void
.end method

.method private checkRange(Ljava/lang/String;II)V
    .registers 8
    .parameter "operation"
    .parameter "start"
    .parameter "end"

    .prologue
    .line 1008
    if-ge p3, p2, :cond_29

    .line 1009
    new-instance v1, Ljava/lang/IndexOutOfBoundsException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p2, p3}, Landroid/text/SpannableStringBuilder;->region(II)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " has end before start"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1013
    :cond_29
    invoke-virtual {p0}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v0

    .line 1015
    .local v0, len:I
    if-gt p2, v0, :cond_31

    if-le p3, v0, :cond_5c

    .line 1016
    :cond_31
    new-instance v1, Ljava/lang/IndexOutOfBoundsException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p2, p3}, Landroid/text/SpannableStringBuilder;->region(II)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " ends beyond length "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1020
    :cond_5c
    if-ltz p2, :cond_60

    if-gez p3, :cond_87

    .line 1021
    :cond_60
    new-instance v1, Ljava/lang/IndexOutOfBoundsException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p2, p3}, Landroid/text/SpannableStringBuilder;->region(II)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " starts before 0"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1024
    :cond_87
    return-void
.end method

.method private static hasNonExclusiveExclusiveSpanAt(Ljava/lang/CharSequence;I)Z
    .registers 9
    .parameter "text"
    .parameter "offset"

    .prologue
    .line 506
    instance-of v6, p0, Landroid/text/Spanned;

    if-eqz v6, :cond_20

    move-object v4, p0

    .line 507
    check-cast v4, Landroid/text/Spanned;

    .line 508
    .local v4, spanned:Landroid/text/Spanned;
    const-class v6, Ljava/lang/Object;

    invoke-interface {v4, p1, p1, v6}, Landroid/text/Spanned;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v5

    .line 509
    .local v5, spans:[Ljava/lang/Object;
    array-length v2, v5

    .line 510
    .local v2, length:I
    const/4 v1, 0x0

    .local v1, i:I
    :goto_f
    if-ge v1, v2, :cond_20

    .line 511
    aget-object v3, v5, v1

    .line 512
    .local v3, span:Ljava/lang/Object;
    invoke-interface {v4, v3}, Landroid/text/Spanned;->getSpanFlags(Ljava/lang/Object;)I

    move-result v0

    .line 513
    .local v0, flags:I
    const/16 v6, 0x21

    if-eq v0, v6, :cond_1d

    const/4 v6, 0x1

    .line 516
    .end local v0           #flags:I
    .end local v1           #i:I
    .end local v2           #length:I
    .end local v3           #span:Ljava/lang/Object;
    .end local v4           #spanned:Landroid/text/Spanned;
    .end local v5           #spans:[Ljava/lang/Object;
    :goto_1c
    return v6

    .line 510
    .restart local v0       #flags:I
    .restart local v1       #i:I
    .restart local v2       #length:I
    .restart local v3       #span:Ljava/lang/Object;
    .restart local v4       #spanned:Landroid/text/Spanned;
    .restart local v5       #spans:[Ljava/lang/Object;
    :cond_1d
    add-int/lit8 v1, v1, 0x1

    goto :goto_f

    .line 516
    .end local v0           #flags:I
    .end local v1           #i:I
    .end local v2           #length:I
    .end local v3           #span:Ljava/lang/Object;
    .end local v4           #spanned:Landroid/text/Spanned;
    .end local v5           #spans:[Ljava/lang/Object;
    :cond_20
    const/4 v6, 0x0

    goto :goto_1c
.end method

.method private moveGapTo(I)V
    .registers 14
    .parameter "where"

    .prologue
    const/4 v11, 0x3

    const/4 v10, 0x2

    .line 153
    iget v6, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    if-ne p1, v6, :cond_7

    .line 198
    :goto_6
    return-void

    .line 156
    :cond_7
    invoke-virtual {p0}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v6

    if-ne p1, v6, :cond_53

    const/4 v0, 0x1

    .line 158
    .local v0, atEnd:Z
    :goto_e
    iget v6, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    if-ge p1, v6, :cond_55

    .line 159
    iget v6, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    sub-int v4, v6, p1

    .line 160
    .local v4, overlap:I
    iget-object v6, p0, Landroid/text/SpannableStringBuilder;->mText:[C

    iget-object v7, p0, Landroid/text/SpannableStringBuilder;->mText:[C

    iget v8, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    iget v9, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    add-int/2addr v8, v9

    sub-int/2addr v8, v4

    invoke-static {v6, p1, v7, v8, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 167
    :goto_23
    const/4 v3, 0x0

    .local v3, i:I
    :goto_24
    iget v6, p0, Landroid/text/SpannableStringBuilder;->mSpanCount:I

    if-ge v3, v6, :cond_8d

    .line 168
    iget-object v6, p0, Landroid/text/SpannableStringBuilder;->mSpanStarts:[I

    aget v5, v6, v3

    .line 169
    .local v5, start:I
    iget-object v6, p0, Landroid/text/SpannableStringBuilder;->mSpanEnds:[I

    aget v1, v6, v3

    .line 171
    .local v1, end:I
    iget v6, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    if-le v5, v6, :cond_37

    .line 172
    iget v6, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    sub-int/2addr v5, v6

    .line 173
    :cond_37
    if-le v5, p1, :cond_67

    .line 174
    iget v6, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    add-int/2addr v5, v6

    .line 182
    :cond_3c
    :goto_3c
    iget v6, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    if-le v1, v6, :cond_43

    .line 183
    iget v6, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    sub-int/2addr v1, v6

    .line 184
    :cond_43
    if-le v1, p1, :cond_7b

    .line 185
    iget v6, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    add-int/2addr v1, v6

    .line 193
    :cond_48
    :goto_48
    iget-object v6, p0, Landroid/text/SpannableStringBuilder;->mSpanStarts:[I

    aput v5, v6, v3

    .line 194
    iget-object v6, p0, Landroid/text/SpannableStringBuilder;->mSpanEnds:[I

    aput v1, v6, v3

    .line 167
    add-int/lit8 v3, v3, 0x1

    goto :goto_24

    .line 156
    .end local v0           #atEnd:Z
    .end local v1           #end:I
    .end local v3           #i:I
    .end local v4           #overlap:I
    .end local v5           #start:I
    :cond_53
    const/4 v0, 0x0

    goto :goto_e

    .line 162
    .restart local v0       #atEnd:Z
    :cond_55
    iget v6, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    sub-int v4, p1, v6

    .line 163
    .restart local v4       #overlap:I
    iget-object v6, p0, Landroid/text/SpannableStringBuilder;->mText:[C

    iget v7, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    add-int/2addr v7, p1

    sub-int/2addr v7, v4

    iget-object v8, p0, Landroid/text/SpannableStringBuilder;->mText:[C

    iget v9, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    invoke-static {v6, v7, v8, v9, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    goto :goto_23

    .line 175
    .restart local v1       #end:I
    .restart local v3       #i:I
    .restart local v5       #start:I
    :cond_67
    if-ne v5, p1, :cond_3c

    .line 176
    iget-object v6, p0, Landroid/text/SpannableStringBuilder;->mSpanFlags:[I

    aget v6, v6, v3

    and-int/lit16 v6, v6, 0xf0

    shr-int/lit8 v2, v6, 0x4

    .line 178
    .local v2, flag:I
    if-eq v2, v10, :cond_77

    if-eqz v0, :cond_3c

    if-ne v2, v11, :cond_3c

    .line 179
    :cond_77
    iget v6, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    add-int/2addr v5, v6

    goto :goto_3c

    .line 186
    .end local v2           #flag:I
    :cond_7b
    if-ne v1, p1, :cond_48

    .line 187
    iget-object v6, p0, Landroid/text/SpannableStringBuilder;->mSpanFlags:[I

    aget v6, v6, v3

    and-int/lit8 v2, v6, 0xf

    .line 189
    .restart local v2       #flag:I
    if-eq v2, v10, :cond_89

    if-eqz v0, :cond_48

    if-ne v2, v11, :cond_48

    .line 190
    :cond_89
    iget v6, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    add-int/2addr v1, v6

    goto :goto_48

    .line 197
    .end local v1           #end:I
    .end local v2           #flag:I
    .end local v5           #start:I
    :cond_8d
    iput p1, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    goto/16 :goto_6
.end method

.method private static region(II)Ljava/lang/String;
    .registers 4
    .parameter "start"
    .parameter "end"

    .prologue
    .line 1004
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "("

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " ... "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private removeSpan(I)V
    .registers 9
    .parameter "i"

    .prologue
    .line 412
    iget-object v4, p0, Landroid/text/SpannableStringBuilder;->mSpans:[Ljava/lang/Object;

    aget-object v2, v4, p1

    .line 414
    .local v2, object:Ljava/lang/Object;
    iget-object v4, p0, Landroid/text/SpannableStringBuilder;->mSpanStarts:[I

    aget v3, v4, p1

    .line 415
    .local v3, start:I
    iget-object v4, p0, Landroid/text/SpannableStringBuilder;->mSpanEnds:[I

    aget v1, v4, p1

    .line 417
    .local v1, end:I
    iget v4, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    if-le v3, v4, :cond_13

    iget v4, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    sub-int/2addr v3, v4

    .line 418
    :cond_13
    iget v4, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    if-le v1, v4, :cond_1a

    iget v4, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    sub-int/2addr v1, v4

    .line 420
    :cond_1a
    iget v4, p0, Landroid/text/SpannableStringBuilder;->mSpanCount:I

    add-int/lit8 v5, p1, 0x1

    sub-int v0, v4, v5

    .line 421
    .local v0, count:I
    iget-object v4, p0, Landroid/text/SpannableStringBuilder;->mSpans:[Ljava/lang/Object;

    add-int/lit8 v5, p1, 0x1

    iget-object v6, p0, Landroid/text/SpannableStringBuilder;->mSpans:[Ljava/lang/Object;

    invoke-static {v4, v5, v6, p1, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 422
    iget-object v4, p0, Landroid/text/SpannableStringBuilder;->mSpanStarts:[I

    add-int/lit8 v5, p1, 0x1

    iget-object v6, p0, Landroid/text/SpannableStringBuilder;->mSpanStarts:[I

    invoke-static {v4, v5, v6, p1, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 423
    iget-object v4, p0, Landroid/text/SpannableStringBuilder;->mSpanEnds:[I

    add-int/lit8 v5, p1, 0x1

    iget-object v6, p0, Landroid/text/SpannableStringBuilder;->mSpanEnds:[I

    invoke-static {v4, v5, v6, p1, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 424
    iget-object v4, p0, Landroid/text/SpannableStringBuilder;->mSpanFlags:[I

    add-int/lit8 v5, p1, 0x1

    iget-object v6, p0, Landroid/text/SpannableStringBuilder;->mSpanFlags:[I

    invoke-static {v4, v5, v6, p1, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 426
    iget v4, p0, Landroid/text/SpannableStringBuilder;->mSpanCount:I

    add-int/lit8 v4, v4, -0x1

    iput v4, p0, Landroid/text/SpannableStringBuilder;->mSpanCount:I

    .line 428
    iget-object v4, p0, Landroid/text/SpannableStringBuilder;->mSpans:[Ljava/lang/Object;

    iget v5, p0, Landroid/text/SpannableStringBuilder;->mSpanCount:I

    const/4 v6, 0x0

    aput-object v6, v4, v5

    .line 430
    invoke-direct {p0, v2, v3, v1}, Landroid/text/SpannableStringBuilder;->sendSpanRemoved(Ljava/lang/Object;II)V

    .line 431
    return-void
.end method

.method private resizeFor(I)V
    .registers 11
    .parameter "size"

    .prologue
    const/4 v8, 0x0

    .line 131
    iget-object v6, p0, Landroid/text/SpannableStringBuilder;->mText:[C

    array-length v5, v6

    .line 132
    .local v5, oldLength:I
    add-int/lit8 v6, p1, 0x1

    invoke-static {v6}, Lcom/android/internal/util/ArrayUtils;->idealCharArraySize(I)I

    move-result v3

    .line 133
    .local v3, newLength:I
    sub-int v1, v3, v5

    .line 134
    .local v1, delta:I
    if-nez v1, :cond_f

    .line 150
    :cond_e
    return-void

    .line 136
    :cond_f
    new-array v4, v3, [C

    .line 137
    .local v4, newText:[C
    iget-object v6, p0, Landroid/text/SpannableStringBuilder;->mText:[C

    iget v7, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    invoke-static {v6, v8, v4, v8, v7}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 138
    iget v6, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    iget v7, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    add-int/2addr v6, v7

    sub-int v0, v5, v6

    .line 139
    .local v0, after:I
    iget-object v6, p0, Landroid/text/SpannableStringBuilder;->mText:[C

    sub-int v7, v5, v0

    sub-int v8, v3, v0

    invoke-static {v6, v7, v4, v8, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 140
    iput-object v4, p0, Landroid/text/SpannableStringBuilder;->mText:[C

    .line 142
    iget v6, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    add-int/2addr v6, v1

    iput v6, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    .line 143
    iget v6, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    const/4 v7, 0x1

    if-ge v6, v7, :cond_3e

    .line 144
    new-instance v6, Ljava/lang/Exception;

    const-string v7, "mGapLength < 1"

    invoke-direct {v6, v7}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6}, Ljava/lang/Exception;->printStackTrace()V

    .line 146
    :cond_3e
    const/4 v2, 0x0

    .local v2, i:I
    :goto_3f
    iget v6, p0, Landroid/text/SpannableStringBuilder;->mSpanCount:I

    if-ge v2, v6, :cond_e

    .line 147
    iget-object v6, p0, Landroid/text/SpannableStringBuilder;->mSpanStarts:[I

    aget v6, v6, v2

    iget v7, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    if-le v6, v7, :cond_52

    iget-object v6, p0, Landroid/text/SpannableStringBuilder;->mSpanStarts:[I

    aget v7, v6, v2

    add-int/2addr v7, v1

    aput v7, v6, v2

    .line 148
    :cond_52
    iget-object v6, p0, Landroid/text/SpannableStringBuilder;->mSpanEnds:[I

    aget v6, v6, v2

    iget v7, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    if-le v6, v7, :cond_61

    iget-object v6, p0, Landroid/text/SpannableStringBuilder;->mSpanEnds:[I

    aget v7, v6, v2

    add-int/2addr v7, v1

    aput v7, v6, v2

    .line 146
    :cond_61
    add-int/lit8 v2, v2, 0x1

    goto :goto_3f
.end method

.method private sendAfterTextChanged([Landroid/text/TextWatcher;)V
    .registers 5
    .parameter "watchers"

    .prologue
    .line 967
    array-length v1, p1

    .line 969
    .local v1, n:I
    const/4 v0, 0x0

    .local v0, i:I
    :goto_2
    if-ge v0, v1, :cond_c

    .line 970
    aget-object v2, p1, v0

    invoke-interface {v2, p0}, Landroid/text/TextWatcher;->afterTextChanged(Landroid/text/Editable;)V

    .line 969
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 972
    :cond_c
    return-void
.end method

.method private sendBeforeTextChanged([Landroid/text/TextWatcher;III)V
    .registers 8
    .parameter "watchers"
    .parameter "start"
    .parameter "before"
    .parameter "after"

    .prologue
    .line 951
    array-length v1, p1

    .line 953
    .local v1, n:I
    const/4 v0, 0x0

    .local v0, i:I
    :goto_2
    if-ge v0, v1, :cond_c

    .line 954
    aget-object v2, p1, v0

    invoke-interface {v2, p0, p2, p3, p4}, Landroid/text/TextWatcher;->beforeTextChanged(Ljava/lang/CharSequence;III)V

    .line 953
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 956
    :cond_c
    return-void
.end method

.method private sendSpanAdded(Ljava/lang/Object;II)V
    .registers 8
    .parameter "what"
    .parameter "start"
    .parameter "end"

    .prologue
    .line 975
    const-class v3, Landroid/text/SpanWatcher;

    invoke-virtual {p0, p2, p3, v3}, Landroid/text/SpannableStringBuilder;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Landroid/text/SpanWatcher;

    .line 976
    .local v2, recip:[Landroid/text/SpanWatcher;
    array-length v1, v2

    .line 978
    .local v1, n:I
    const/4 v0, 0x0

    .local v0, i:I
    :goto_a
    if-ge v0, v1, :cond_14

    .line 979
    aget-object v3, v2, v0

    invoke-interface {v3, p0, p1, p2, p3}, Landroid/text/SpanWatcher;->onSpanAdded(Landroid/text/Spannable;Ljava/lang/Object;II)V

    .line 978
    add-int/lit8 v0, v0, 0x1

    goto :goto_a

    .line 981
    :cond_14
    return-void
.end method

.method private sendSpanChanged(Ljava/lang/Object;IIII)V
    .registers 16
    .parameter "what"
    .parameter "oldStart"
    .parameter "oldEnd"
    .parameter "start"
    .parameter "end"

    .prologue
    .line 995
    invoke-static {p2, p4}, Ljava/lang/Math;->min(II)I

    move-result v0

    invoke-static {p3, p5}, Ljava/lang/Math;->max(II)I

    move-result v1

    invoke-virtual {p0}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v2

    invoke-static {v1, v2}, Ljava/lang/Math;->min(II)I

    move-result v1

    const-class v2, Landroid/text/SpanWatcher;

    invoke-virtual {p0, v0, v1, v2}, Landroid/text/SpannableStringBuilder;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v9

    check-cast v9, [Landroid/text/SpanWatcher;

    .line 997
    .local v9, spanWatchers:[Landroid/text/SpanWatcher;
    array-length v8, v9

    .line 998
    .local v8, n:I
    const/4 v7, 0x0

    .local v7, i:I
    :goto_1a
    if-ge v7, v8, :cond_2a

    .line 999
    aget-object v0, v9, v7

    move-object v1, p0

    move-object v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    move v6, p5

    invoke-interface/range {v0 .. v6}, Landroid/text/SpanWatcher;->onSpanChanged(Landroid/text/Spannable;Ljava/lang/Object;IIII)V

    .line 998
    add-int/lit8 v7, v7, 0x1

    goto :goto_1a

    .line 1001
    :cond_2a
    return-void
.end method

.method private sendSpanRemoved(Ljava/lang/Object;II)V
    .registers 8
    .parameter "what"
    .parameter "start"
    .parameter "end"

    .prologue
    .line 984
    const-class v3, Landroid/text/SpanWatcher;

    invoke-virtual {p0, p2, p3, v3}, Landroid/text/SpannableStringBuilder;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Landroid/text/SpanWatcher;

    .line 985
    .local v2, recip:[Landroid/text/SpanWatcher;
    array-length v1, v2

    .line 987
    .local v1, n:I
    const/4 v0, 0x0

    .local v0, i:I
    :goto_a
    if-ge v0, v1, :cond_14

    .line 988
    aget-object v3, v2, v0

    invoke-interface {v3, p0, p1, p2, p3}, Landroid/text/SpanWatcher;->onSpanRemoved(Landroid/text/Spannable;Ljava/lang/Object;II)V

    .line 987
    add-int/lit8 v0, v0, 0x1

    goto :goto_a

    .line 990
    :cond_14
    return-void
.end method

.method private sendTextChanged([Landroid/text/TextWatcher;III)V
    .registers 8
    .parameter "watchers"
    .parameter "start"
    .parameter "before"
    .parameter "after"

    .prologue
    .line 959
    array-length v1, p1

    .line 961
    .local v1, n:I
    const/4 v0, 0x0

    .local v0, i:I
    :goto_2
    if-ge v0, v1, :cond_c

    .line 962
    aget-object v2, p1, v0

    invoke-interface {v2, p0, p2, p3, p4}, Landroid/text/TextWatcher;->onTextChanged(Ljava/lang/CharSequence;III)V

    .line 961
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 964
    :cond_c
    return-void
.end method

.method private sendToSpanWatchers(III)V
    .registers 16
    .parameter "replaceStart"
    .parameter "replaceEnd"
    .parameter "nbNewChars"

    .prologue
    const v11, 0x8000

    .line 520
    const/4 v6, 0x0

    .local v6, i:I
    :goto_4
    iget v0, p0, Landroid/text/SpannableStringBuilder;->mSpanCountBeforeAdd:I

    if-ge v6, v0, :cond_70

    .line 521
    iget-object v0, p0, Landroid/text/SpannableStringBuilder;->mSpanStarts:[I

    aget v4, v0, v6

    .line 522
    .local v4, spanStart:I
    iget-object v0, p0, Landroid/text/SpannableStringBuilder;->mSpanEnds:[I

    aget v5, v0, v6

    .line 523
    .local v5, spanEnd:I
    iget v0, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    if-le v4, v0, :cond_17

    iget v0, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    sub-int/2addr v4, v0

    .line 524
    :cond_17
    iget v0, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    if-le v5, v0, :cond_1e

    iget v0, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    sub-int/2addr v5, v0

    .line 525
    :cond_1e
    iget-object v0, p0, Landroid/text/SpannableStringBuilder;->mSpanFlags:[I

    aget v9, v0, v6

    .line 527
    .local v9, spanFlags:I
    add-int v7, p2, p3

    .line 528
    .local v7, newReplaceEnd:I
    const/4 v8, 0x0

    .line 530
    .local v8, spanChanged:Z
    move v2, v4

    .line 531
    .local v2, previousSpanStart:I
    if-le v4, v7, :cond_4a

    .line 532
    if-eqz p3, :cond_2c

    .line 533
    sub-int/2addr v2, p3

    .line 534
    const/4 v8, 0x1

    .line 549
    :cond_2c
    :goto_2c
    move v3, v5

    .line 550
    .local v3, previousSpanEnd:I
    if-le v5, v7, :cond_5e

    .line 551
    if-eqz p3, :cond_33

    .line 552
    sub-int/2addr v3, p3

    .line 553
    const/4 v8, 0x1

    .line 566
    :cond_33
    :goto_33
    if-eqz v8, :cond_3d

    .line 567
    iget-object v0, p0, Landroid/text/SpannableStringBuilder;->mSpans:[Ljava/lang/Object;

    aget-object v1, v0, v6

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Landroid/text/SpannableStringBuilder;->sendSpanChanged(Ljava/lang/Object;IIII)V

    .line 569
    :cond_3d
    iget-object v0, p0, Landroid/text/SpannableStringBuilder;->mSpanFlags:[I

    aget v1, v0, v6

    const v10, -0xf001

    and-int/2addr v1, v10

    aput v1, v0, v6

    .line 520
    add-int/lit8 v6, v6, 0x1

    goto :goto_4

    .line 536
    .end local v3           #previousSpanEnd:I
    :cond_4a
    if-lt v4, p1, :cond_2c

    .line 538
    if-ne v4, p1, :cond_54

    and-int/lit16 v0, v9, 0x1000

    const/16 v1, 0x1000

    if-eq v0, v1, :cond_2c

    :cond_54
    if-ne v4, v7, :cond_5c

    and-int/lit16 v0, v9, 0x2000

    const/16 v1, 0x2000

    if-eq v0, v1, :cond_2c

    .line 545
    :cond_5c
    const/4 v8, 0x1

    goto :goto_2c

    .line 555
    .restart local v3       #previousSpanEnd:I
    :cond_5e
    if-lt v5, p1, :cond_33

    .line 557
    if-ne v5, p1, :cond_68

    and-int/lit16 v0, v9, 0x4000

    const/16 v1, 0x4000

    if-eq v0, v1, :cond_33

    :cond_68
    if-ne v5, v7, :cond_6e

    and-int v0, v9, v11

    if-eq v0, v11, :cond_33

    .line 562
    :cond_6e
    const/4 v8, 0x1

    goto :goto_33

    .line 573
    .end local v2           #previousSpanStart:I
    .end local v3           #previousSpanEnd:I
    .end local v4           #spanStart:I
    .end local v5           #spanEnd:I
    .end local v7           #newReplaceEnd:I
    .end local v8           #spanChanged:Z
    .end local v9           #spanFlags:I
    :cond_70
    iget v6, p0, Landroid/text/SpannableStringBuilder;->mSpanCountBeforeAdd:I

    :goto_72
    iget v0, p0, Landroid/text/SpannableStringBuilder;->mSpanCount:I

    if-ge v6, v0, :cond_96

    .line 574
    iget-object v0, p0, Landroid/text/SpannableStringBuilder;->mSpanStarts:[I

    aget v4, v0, v6

    .line 575
    .restart local v4       #spanStart:I
    iget-object v0, p0, Landroid/text/SpannableStringBuilder;->mSpanEnds:[I

    aget v5, v0, v6

    .line 576
    .restart local v5       #spanEnd:I
    iget v0, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    if-le v4, v0, :cond_85

    iget v0, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    sub-int/2addr v4, v0

    .line 577
    :cond_85
    iget v0, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    if-le v5, v0, :cond_8c

    iget v0, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    sub-int/2addr v5, v0

    .line 578
    :cond_8c
    iget-object v0, p0, Landroid/text/SpannableStringBuilder;->mSpans:[Ljava/lang/Object;

    aget-object v0, v0, v6

    invoke-direct {p0, v0, v4, v5}, Landroid/text/SpannableStringBuilder;->sendSpanAdded(Ljava/lang/Object;II)V

    .line 573
    add-int/lit8 v6, v6, 0x1

    goto :goto_72

    .line 580
    .end local v4           #spanStart:I
    .end local v5           #spanEnd:I
    :cond_96
    return-void
.end method

.method private setSpan(ZLjava/lang/Object;III)V
    .registers 28
    .parameter "send"
    .parameter "what"
    .parameter "start"
    .parameter "end"
    .parameter "flags"

    .prologue
    .line 592
    const-string/jumbo v3, "setSpan"

    move-object/from16 v0, p0

    move/from16 v1, p3

    move/from16 v2, p4

    invoke-direct {v0, v3, v1, v2}, Landroid/text/SpannableStringBuilder;->checkRange(Ljava/lang/String;II)V

    .line 594
    move/from16 v0, p5

    and-int/lit16 v3, v0, 0xf0

    shr-int/lit8 v12, v3, 0x4

    .line 595
    .local v12, flagsStart:I
    const/4 v3, 0x3

    if-ne v12, v3, :cond_33

    .line 596
    if-eqz p3, :cond_33

    invoke-virtual/range {p0 .. p0}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v3

    move/from16 v0, p3

    if-eq v0, v3, :cond_33

    .line 597
    add-int/lit8 v3, p3, -0x1

    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Landroid/text/SpannableStringBuilder;->charAt(I)C

    move-result v9

    .line 599
    .local v9, c:C
    const/16 v3, 0xa

    if-eq v9, v3, :cond_33

    .line 600
    new-instance v3, Ljava/lang/RuntimeException;

    const-string v4, "PARAGRAPH span must start at paragraph boundary"

    invoke-direct {v3, v4}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 604
    .end local v9           #c:C
    :cond_33
    and-int/lit8 v11, p5, 0xf

    .line 605
    .local v11, flagsEnd:I
    const/4 v3, 0x3

    if-ne v11, v3, :cond_56

    .line 606
    if-eqz p4, :cond_56

    invoke-virtual/range {p0 .. p0}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v3

    move/from16 v0, p4

    if-eq v0, v3, :cond_56

    .line 607
    add-int/lit8 v3, p4, -0x1

    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Landroid/text/SpannableStringBuilder;->charAt(I)C

    move-result v9

    .line 609
    .restart local v9       #c:C
    const/16 v3, 0xa

    if-eq v9, v3, :cond_56

    .line 610
    new-instance v3, Ljava/lang/RuntimeException;

    const-string v4, "PARAGRAPH span must end at paragraph boundary"

    invoke-direct {v3, v4}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 615
    .end local v9           #c:C
    :cond_56
    const/4 v3, 0x2

    if-ne v12, v3, :cond_6c

    const/4 v3, 0x1

    if-ne v11, v3, :cond_6c

    move/from16 v0, p3

    move/from16 v1, p4

    if-ne v0, v1, :cond_6c

    .line 616
    if-eqz p1, :cond_6b

    const-string v3, "SpannableStringBuilder"

    const-string v4, "SPAN_EXCLUSIVE_EXCLUSIVE spans cannot have a zero length"

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 689
    :cond_6b
    :goto_6b
    return-void

    .line 624
    :cond_6c
    move/from16 v7, p3

    .line 625
    .local v7, nstart:I
    move/from16 v8, p4

    .line 627
    .local v8, nend:I
    move-object/from16 v0, p0

    iget v3, v0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    move/from16 v0, p3

    if-le v0, v3, :cond_dd

    .line 628
    move-object/from16 v0, p0

    iget v3, v0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    add-int p3, p3, v3

    .line 634
    :cond_7e
    :goto_7e
    move-object/from16 v0, p0

    iget v3, v0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    move/from16 v0, p4

    if-le v0, v3, :cond_fa

    .line 635
    move-object/from16 v0, p0

    iget v3, v0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    add-int p4, p4, v3

    .line 641
    :cond_8c
    :goto_8c
    move-object/from16 v0, p0

    iget v10, v0, Landroid/text/SpannableStringBuilder;->mSpanCount:I

    .line 642
    .local v10, count:I
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/text/SpannableStringBuilder;->mSpans:[Ljava/lang/Object;

    move-object/from16 v19, v0

    .line 644
    .local v19, spans:[Ljava/lang/Object;
    const/4 v13, 0x0

    .local v13, i:I
    :goto_97
    if-ge v13, v10, :cond_11c

    .line 645
    aget-object v3, v19, v13

    move-object/from16 v0, p2

    if-ne v3, v0, :cond_118

    .line 646
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/text/SpannableStringBuilder;->mSpanStarts:[I

    aget v5, v3, v13

    .line 647
    .local v5, ostart:I
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/text/SpannableStringBuilder;->mSpanEnds:[I

    aget v6, v3, v13

    .line 649
    .local v6, oend:I
    move-object/from16 v0, p0

    iget v3, v0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    if-le v5, v3, :cond_b6

    .line 650
    move-object/from16 v0, p0

    iget v3, v0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    sub-int/2addr v5, v3

    .line 651
    :cond_b6
    move-object/from16 v0, p0

    iget v3, v0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    if-le v6, v3, :cond_c1

    .line 652
    move-object/from16 v0, p0

    iget v3, v0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    sub-int/2addr v6, v3

    .line 654
    :cond_c1
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/text/SpannableStringBuilder;->mSpanStarts:[I

    aput p3, v3, v13

    .line 655
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/text/SpannableStringBuilder;->mSpanEnds:[I

    aput p4, v3, v13

    .line 656
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/text/SpannableStringBuilder;->mSpanFlags:[I

    aput p5, v3, v13

    .line 658
    if-eqz p1, :cond_6b

    move-object/from16 v3, p0

    move-object/from16 v4, p2

    invoke-direct/range {v3 .. v8}, Landroid/text/SpannableStringBuilder;->sendSpanChanged(Ljava/lang/Object;IIII)V

    goto :goto_6b

    .line 629
    .end local v5           #ostart:I
    .end local v6           #oend:I
    .end local v10           #count:I
    .end local v13           #i:I
    .end local v19           #spans:[Ljava/lang/Object;
    :cond_dd
    move-object/from16 v0, p0

    iget v3, v0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    move/from16 v0, p3

    if-ne v0, v3, :cond_7e

    .line 630
    const/4 v3, 0x2

    if-eq v12, v3, :cond_f3

    const/4 v3, 0x3

    if-ne v12, v3, :cond_7e

    invoke-virtual/range {p0 .. p0}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v3

    move/from16 v0, p3

    if-ne v0, v3, :cond_7e

    .line 631
    :cond_f3
    move-object/from16 v0, p0

    iget v3, v0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    add-int p3, p3, v3

    goto :goto_7e

    .line 636
    :cond_fa
    move-object/from16 v0, p0

    iget v3, v0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    move/from16 v0, p4

    if-ne v0, v3, :cond_8c

    .line 637
    const/4 v3, 0x2

    if-eq v11, v3, :cond_110

    const/4 v3, 0x3

    if-ne v11, v3, :cond_8c

    invoke-virtual/range {p0 .. p0}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v3

    move/from16 v0, p4

    if-ne v0, v3, :cond_8c

    .line 638
    :cond_110
    move-object/from16 v0, p0

    iget v3, v0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    add-int p4, p4, v3

    goto/16 :goto_8c

    .line 644
    .restart local v10       #count:I
    .restart local v13       #i:I
    .restart local v19       #spans:[Ljava/lang/Object;
    :cond_118
    add-int/lit8 v13, v13, 0x1

    goto/16 :goto_97

    .line 664
    :cond_11c
    move-object/from16 v0, p0

    iget v3, v0, Landroid/text/SpannableStringBuilder;->mSpanCount:I

    add-int/lit8 v3, v3, 0x1

    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/text/SpannableStringBuilder;->mSpans:[Ljava/lang/Object;

    array-length v4, v4

    if-lt v3, v4, :cond_1ad

    .line 665
    move-object/from16 v0, p0

    iget v3, v0, Landroid/text/SpannableStringBuilder;->mSpanCount:I

    add-int/lit8 v3, v3, 0x1

    invoke-static {v3}, Lcom/android/internal/util/ArrayUtils;->idealIntArraySize(I)I

    move-result v14

    .line 666
    .local v14, newsize:I
    new-array v0, v14, [Ljava/lang/Object;

    move-object/from16 v17, v0

    .line 667
    .local v17, newspans:[Ljava/lang/Object;
    new-array v0, v14, [I

    move-object/from16 v18, v0

    .line 668
    .local v18, newspanstarts:[I
    new-array v15, v14, [I

    .line 669
    .local v15, newspanends:[I
    new-array v0, v14, [I

    move-object/from16 v16, v0

    .line 671
    .local v16, newspanflags:[I
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/text/SpannableStringBuilder;->mSpans:[Ljava/lang/Object;

    const/4 v4, 0x0

    const/16 v20, 0x0

    move-object/from16 v0, p0

    iget v0, v0, Landroid/text/SpannableStringBuilder;->mSpanCount:I

    move/from16 v21, v0

    move-object/from16 v0, v17

    move/from16 v1, v20

    move/from16 v2, v21

    invoke-static {v3, v4, v0, v1, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 672
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/text/SpannableStringBuilder;->mSpanStarts:[I

    const/4 v4, 0x0

    const/16 v20, 0x0

    move-object/from16 v0, p0

    iget v0, v0, Landroid/text/SpannableStringBuilder;->mSpanCount:I

    move/from16 v21, v0

    move-object/from16 v0, v18

    move/from16 v1, v20

    move/from16 v2, v21

    invoke-static {v3, v4, v0, v1, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 673
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/text/SpannableStringBuilder;->mSpanEnds:[I

    const/4 v4, 0x0

    const/16 v20, 0x0

    move-object/from16 v0, p0

    iget v0, v0, Landroid/text/SpannableStringBuilder;->mSpanCount:I

    move/from16 v21, v0

    move/from16 v0, v20

    move/from16 v1, v21

    invoke-static {v3, v4, v15, v0, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 674
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/text/SpannableStringBuilder;->mSpanFlags:[I

    const/4 v4, 0x0

    const/16 v20, 0x0

    move-object/from16 v0, p0

    iget v0, v0, Landroid/text/SpannableStringBuilder;->mSpanCount:I

    move/from16 v21, v0

    move-object/from16 v0, v16

    move/from16 v1, v20

    move/from16 v2, v21

    invoke-static {v3, v4, v0, v1, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 676
    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Landroid/text/SpannableStringBuilder;->mSpans:[Ljava/lang/Object;

    .line 677
    move-object/from16 v0, v18

    move-object/from16 v1, p0

    iput-object v0, v1, Landroid/text/SpannableStringBuilder;->mSpanStarts:[I

    .line 678
    move-object/from16 v0, p0

    iput-object v15, v0, Landroid/text/SpannableStringBuilder;->mSpanEnds:[I

    .line 679
    move-object/from16 v0, v16

    move-object/from16 v1, p0

    iput-object v0, v1, Landroid/text/SpannableStringBuilder;->mSpanFlags:[I

    .line 682
    .end local v14           #newsize:I
    .end local v15           #newspanends:[I
    .end local v16           #newspanflags:[I
    .end local v17           #newspans:[Ljava/lang/Object;
    .end local v18           #newspanstarts:[I
    :cond_1ad
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/text/SpannableStringBuilder;->mSpans:[Ljava/lang/Object;

    move-object/from16 v0, p0

    iget v4, v0, Landroid/text/SpannableStringBuilder;->mSpanCount:I

    aput-object p2, v3, v4

    .line 683
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/text/SpannableStringBuilder;->mSpanStarts:[I

    move-object/from16 v0, p0

    iget v4, v0, Landroid/text/SpannableStringBuilder;->mSpanCount:I

    aput p3, v3, v4

    .line 684
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/text/SpannableStringBuilder;->mSpanEnds:[I

    move-object/from16 v0, p0

    iget v4, v0, Landroid/text/SpannableStringBuilder;->mSpanCount:I

    aput p4, v3, v4

    .line 685
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/text/SpannableStringBuilder;->mSpanFlags:[I

    move-object/from16 v0, p0

    iget v4, v0, Landroid/text/SpannableStringBuilder;->mSpanCount:I

    aput p5, v3, v4

    .line 686
    move-object/from16 v0, p0

    iget v3, v0, Landroid/text/SpannableStringBuilder;->mSpanCount:I

    add-int/lit8 v3, v3, 0x1

    move-object/from16 v0, p0

    iput v3, v0, Landroid/text/SpannableStringBuilder;->mSpanCount:I

    .line 688
    if-eqz p1, :cond_6b

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-direct {v0, v1, v7, v8}, Landroid/text/SpannableStringBuilder;->sendSpanAdded(Ljava/lang/Object;II)V

    goto/16 :goto_6b
.end method

.method private updatedIntervalBound(IIIIZZ)I
    .registers 9
    .parameter "offset"
    .parameter "start"
    .parameter "nbNewChars"
    .parameter "flag"
    .parameter "atEnd"
    .parameter "textIsRemoved"

    .prologue
    .line 381
    if-lt p1, p2, :cond_2d

    iget v0, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    iget v1, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    add-int/2addr v0, v1

    if-ge p1, v0, :cond_2d

    .line 382
    const/4 v0, 0x2

    if-ne p4, v0, :cond_17

    .line 387
    if-nez p6, :cond_10

    if-le p1, p2, :cond_2d

    .line 388
    :cond_10
    iget v0, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    iget v1, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    add-int p2, v0, v1

    .line 408
    .end local p2
    :cond_16
    :goto_16
    return p2

    .line 391
    .restart local p2
    :cond_17
    const/4 v0, 0x3

    if-ne p4, v0, :cond_23

    .line 392
    if-eqz p5, :cond_2d

    .line 393
    iget v0, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    iget v1, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    add-int p2, v0, v1

    goto :goto_16

    .line 399
    :cond_23
    if-nez p6, :cond_16

    iget v0, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    sub-int/2addr v0, p3

    if-lt p1, v0, :cond_16

    .line 403
    iget p2, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    goto :goto_16

    :cond_2d
    move p2, p1

    .line 408
    goto :goto_16
.end method

.method public static valueOf(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    .registers 2
    .parameter "source"

    .prologue
    .line 99
    instance-of v0, p0, Landroid/text/SpannableStringBuilder;

    if-eqz v0, :cond_7

    .line 100
    check-cast p0, Landroid/text/SpannableStringBuilder;

    .line 102
    .end local p0
    :goto_6
    return-object p0

    .restart local p0
    :cond_7
    new-instance v0, Landroid/text/SpannableStringBuilder;

    invoke-direct {v0, p0}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    move-object p0, v0

    goto :goto_6
.end method


# virtual methods
.method public bridge synthetic append(C)Landroid/text/Editable;
    .registers 3
    .parameter "x0"

    .prologue
    .line 30
    invoke-virtual {p0, p1}, Landroid/text/SpannableStringBuilder;->append(C)Landroid/text/SpannableStringBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic append(Ljava/lang/CharSequence;)Landroid/text/Editable;
    .registers 3
    .parameter "x0"

    .prologue
    .line 30
    invoke-virtual {p0, p1}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic append(Ljava/lang/CharSequence;II)Landroid/text/Editable;
    .registers 5
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"

    .prologue
    .line 30
    invoke-virtual {p0, p1, p2, p3}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;II)Landroid/text/SpannableStringBuilder;

    move-result-object v0

    return-object v0
.end method

.method public append(C)Landroid/text/SpannableStringBuilder;
    .registers 3
    .parameter "text"

    .prologue
    .line 258
    invoke-static {p1}, Ljava/lang/String;->valueOf(C)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    move-result-object v0

    return-object v0
.end method

.method public append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    .registers 8
    .parameter "text"

    .prologue
    .line 246
    invoke-virtual {p0}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v1

    .line 247
    .local v1, length:I
    const/4 v4, 0x0

    invoke-interface {p1}, Ljava/lang/CharSequence;->length()I

    move-result v5

    move-object v0, p0

    move v2, v1

    move-object v3, p1

    invoke-virtual/range {v0 .. v5}, Landroid/text/SpannableStringBuilder;->replace(IILjava/lang/CharSequence;II)Landroid/text/SpannableStringBuilder;

    move-result-object v0

    return-object v0
.end method

.method public append(Ljava/lang/CharSequence;II)Landroid/text/SpannableStringBuilder;
    .registers 10
    .parameter "text"
    .parameter "start"
    .parameter "end"

    .prologue
    .line 252
    invoke-virtual {p0}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v1

    .local v1, length:I
    move-object v0, p0

    move v2, v1

    move-object v3, p1

    move v4, p2

    move v5, p3

    .line 253
    invoke-virtual/range {v0 .. v5}, Landroid/text/SpannableStringBuilder;->replace(IILjava/lang/CharSequence;II)Landroid/text/SpannableStringBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic append(C)Ljava/lang/Appendable;
    .registers 3
    .parameter "x0"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 30
    invoke-virtual {p0, p1}, Landroid/text/SpannableStringBuilder;->append(C)Landroid/text/SpannableStringBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic append(Ljava/lang/CharSequence;)Ljava/lang/Appendable;
    .registers 3
    .parameter "x0"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 30
    invoke-virtual {p0, p1}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic append(Ljava/lang/CharSequence;II)Ljava/lang/Appendable;
    .registers 5
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 30
    invoke-virtual {p0, p1, p2, p3}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;II)Landroid/text/SpannableStringBuilder;

    move-result-object v0

    return-object v0
.end method

.method public charAt(I)C
    .registers 6
    .parameter "where"

    .prologue
    .line 110
    invoke-virtual {p0}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v0

    .line 111
    .local v0, len:I
    if-gez p1, :cond_25

    .line 112
    new-instance v1, Ljava/lang/IndexOutOfBoundsException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "charAt: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " < 0"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 113
    :cond_25
    if-lt p1, v0, :cond_4a

    .line 114
    new-instance v1, Ljava/lang/IndexOutOfBoundsException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "charAt: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " >= length "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 117
    :cond_4a
    iget v1, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    if-lt p1, v1, :cond_56

    .line 118
    iget-object v1, p0, Landroid/text/SpannableStringBuilder;->mText:[C

    iget v2, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    add-int/2addr v2, p1

    aget-char v1, v1, v2

    .line 120
    :goto_55
    return v1

    :cond_56
    iget-object v1, p0, Landroid/text/SpannableStringBuilder;->mText:[C

    aget-char v1, v1, p1

    goto :goto_55
.end method

.method public clear()V
    .registers 7

    .prologue
    const/4 v1, 0x0

    .line 222
    invoke-virtual {p0}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v2

    const-string v3, ""

    move-object v0, p0

    move v4, v1

    move v5, v1

    invoke-virtual/range {v0 .. v5}, Landroid/text/SpannableStringBuilder;->replace(IILjava/lang/CharSequence;II)Landroid/text/SpannableStringBuilder;

    .line 223
    return-void
.end method

.method public clearSpans()V
    .registers 7

    .prologue
    .line 227
    iget v4, p0, Landroid/text/SpannableStringBuilder;->mSpanCount:I

    add-int/lit8 v0, v4, -0x1

    .local v0, i:I
    :goto_4
    if-ltz v0, :cond_2d

    .line 228
    iget-object v4, p0, Landroid/text/SpannableStringBuilder;->mSpans:[Ljava/lang/Object;

    aget-object v3, v4, v0

    .line 229
    .local v3, what:Ljava/lang/Object;
    iget-object v4, p0, Landroid/text/SpannableStringBuilder;->mSpanStarts:[I

    aget v2, v4, v0

    .line 230
    .local v2, ostart:I
    iget-object v4, p0, Landroid/text/SpannableStringBuilder;->mSpanEnds:[I

    aget v1, v4, v0

    .line 232
    .local v1, oend:I
    iget v4, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    if-le v2, v4, :cond_19

    .line 233
    iget v4, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    sub-int/2addr v2, v4

    .line 234
    :cond_19
    iget v4, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    if-le v1, v4, :cond_20

    .line 235
    iget v4, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    sub-int/2addr v1, v4

    .line 237
    :cond_20
    iput v0, p0, Landroid/text/SpannableStringBuilder;->mSpanCount:I

    .line 238
    iget-object v4, p0, Landroid/text/SpannableStringBuilder;->mSpans:[Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v5, v4, v0

    .line 240
    invoke-direct {p0, v3, v2, v1}, Landroid/text/SpannableStringBuilder;->sendSpanRemoved(Ljava/lang/Object;II)V

    .line 227
    add-int/lit8 v0, v0, -0x1

    goto :goto_4

    .line 242
    .end local v1           #oend:I
    .end local v2           #ostart:I
    .end local v3           #what:Ljava/lang/Object;
    :cond_2d
    return-void
.end method

.method public bridge synthetic delete(II)Landroid/text/Editable;
    .registers 4
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 30
    invoke-virtual {p0, p1, p2}, Landroid/text/SpannableStringBuilder;->delete(II)Landroid/text/SpannableStringBuilder;

    move-result-object v0

    return-object v0
.end method

.method public delete(II)Landroid/text/SpannableStringBuilder;
    .registers 10
    .parameter "start"
    .parameter "end"

    .prologue
    const/4 v4, 0x0

    .line 212
    const-string v3, ""

    move-object v0, p0

    move v1, p1

    move v2, p2

    move v5, v4

    invoke-virtual/range {v0 .. v5}, Landroid/text/SpannableStringBuilder;->replace(IILjava/lang/CharSequence;II)Landroid/text/SpannableStringBuilder;

    move-result-object v6

    .line 214
    .local v6, ret:Landroid/text/SpannableStringBuilder;
    iget v0, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    invoke-virtual {p0}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v1

    mul-int/lit8 v1, v1, 0x2

    if-le v0, v1, :cond_1c

    .line 215
    invoke-virtual {p0}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v0

    invoke-direct {p0, v0}, Landroid/text/SpannableStringBuilder;->resizeFor(I)V

    .line 217
    :cond_1c
    return-object v6
.end method

.method public drawText(Landroid/graphics/Canvas;IIFFLandroid/graphics/Paint;)V
    .registers 14
    .parameter "c"
    .parameter "start"
    .parameter "end"
    .parameter "x"
    .parameter "y"
    .parameter "p"

    .prologue
    const/4 v2, 0x0

    .line 1112
    const-string v0, "drawText"

    invoke-direct {p0, v0, p2, p3}, Landroid/text/SpannableStringBuilder;->checkRange(Ljava/lang/String;II)V

    .line 1114
    iget v0, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    if-gt p3, v0, :cond_17

    .line 1115
    iget-object v1, p0, Landroid/text/SpannableStringBuilder;->mText:[C

    sub-int v3, p3, p2

    move-object v0, p1

    move v2, p2

    move v4, p4

    move v5, p5

    move-object v6, p6

    invoke-virtual/range {v0 .. v6}, Landroid/graphics/Canvas;->drawText([CIIFFLandroid/graphics/Paint;)V

    .line 1125
    :goto_16
    return-void

    .line 1116
    :cond_17
    iget v0, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    if-lt p2, v0, :cond_2b

    .line 1117
    iget-object v1, p0, Landroid/text/SpannableStringBuilder;->mText:[C

    iget v0, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    add-int v2, p2, v0

    sub-int v3, p3, p2

    move-object v0, p1

    move v4, p4

    move v5, p5

    move-object v6, p6

    invoke-virtual/range {v0 .. v6}, Landroid/graphics/Canvas;->drawText([CIIFFLandroid/graphics/Paint;)V

    goto :goto_16

    .line 1119
    :cond_2b
    sub-int v0, p3, p2

    invoke-static {v0}, Landroid/text/TextUtils;->obtain(I)[C

    move-result-object v1

    .line 1121
    .local v1, buf:[C
    invoke-virtual {p0, p2, p3, v1, v2}, Landroid/text/SpannableStringBuilder;->getChars(II[CI)V

    .line 1122
    sub-int v3, p3, p2

    move-object v0, p1

    move v4, p4

    move v5, p5

    move-object v6, p6

    invoke-virtual/range {v0 .. v6}, Landroid/graphics/Canvas;->drawText([CIIFFLandroid/graphics/Paint;)V

    .line 1123
    invoke-static {v1}, Landroid/text/TextUtils;->recycle([C)V

    goto :goto_16
.end method

.method public drawTextRun(Landroid/graphics/Canvas;IIIIFFILandroid/graphics/Paint;)V
    .registers 20
    .parameter "c"
    .parameter "start"
    .parameter "end"
    .parameter "contextStart"
    .parameter "contextEnd"
    .parameter "x"
    .parameter "y"
    .parameter "flags"
    .parameter "p"

    .prologue
    .line 1134
    const-string v0, "drawTextRun"

    invoke-direct {p0, v0, p2, p3}, Landroid/text/SpannableStringBuilder;->checkRange(Ljava/lang/String;II)V

    .line 1136
    sub-int v5, p5, p4

    .line 1137
    .local v5, contextLen:I
    sub-int v3, p3, p2

    .line 1138
    .local v3, len:I
    iget v0, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    if-gt p5, v0, :cond_1e

    .line 1139
    iget-object v1, p0, Landroid/text/SpannableStringBuilder;->mText:[C

    move-object v0, p1

    move v2, p2

    move v4, p4

    move/from16 v6, p6

    move/from16 v7, p7

    move/from16 v8, p8

    move-object/from16 v9, p9

    invoke-virtual/range {v0 .. v9}, Landroid/graphics/Canvas;->drawTextRun([CIIIIFFILandroid/graphics/Paint;)V

    .line 1149
    :goto_1d
    return-void

    .line 1140
    :cond_1e
    iget v0, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    if-lt p4, v0, :cond_39

    .line 1141
    iget-object v1, p0, Landroid/text/SpannableStringBuilder;->mText:[C

    iget v0, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    add-int v2, p2, v0

    iget v0, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    add-int v4, p4, v0

    move-object v0, p1

    move/from16 v6, p6

    move/from16 v7, p7

    move/from16 v8, p8

    move-object/from16 v9, p9

    invoke-virtual/range {v0 .. v9}, Landroid/graphics/Canvas;->drawTextRun([CIIIIFFILandroid/graphics/Paint;)V

    goto :goto_1d

    .line 1144
    :cond_39
    invoke-static {v5}, Landroid/text/TextUtils;->obtain(I)[C

    move-result-object v1

    .line 1145
    .local v1, buf:[C
    const/4 v0, 0x0

    invoke-virtual {p0, p4, p5, v1, v0}, Landroid/text/SpannableStringBuilder;->getChars(II[CI)V

    .line 1146
    sub-int v2, p2, p4

    const/4 v4, 0x0

    move-object v0, p1

    move/from16 v6, p6

    move/from16 v7, p7

    move/from16 v8, p8

    move-object/from16 v9, p9

    invoke-virtual/range {v0 .. v9}, Landroid/graphics/Canvas;->drawTextRun([CIIIIFFILandroid/graphics/Paint;)V

    .line 1147
    invoke-static {v1}, Landroid/text/TextUtils;->recycle([C)V

    goto :goto_1d
.end method

.method public getChars(II[CI)V
    .registers 9
    .parameter "start"
    .parameter "end"
    .parameter "dest"
    .parameter "destoff"

    .prologue
    .line 913
    const-string v0, "getChars"

    invoke-direct {p0, v0, p1, p2}, Landroid/text/SpannableStringBuilder;->checkRange(Ljava/lang/String;II)V

    .line 915
    iget v0, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    if-gt p2, v0, :cond_11

    .line 916
    iget-object v0, p0, Landroid/text/SpannableStringBuilder;->mText:[C

    sub-int v1, p2, p1

    invoke-static {v0, p1, p3, p4, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 925
    :goto_10
    return-void

    .line 917
    :cond_11
    iget v0, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    if-lt p1, v0, :cond_20

    .line 918
    iget-object v0, p0, Landroid/text/SpannableStringBuilder;->mText:[C

    iget v1, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    add-int/2addr v1, p1

    sub-int v2, p2, p1

    invoke-static {v0, v1, p3, p4, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    goto :goto_10

    .line 920
    :cond_20
    iget-object v0, p0, Landroid/text/SpannableStringBuilder;->mText:[C

    iget v1, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    sub-int/2addr v1, p1

    invoke-static {v0, p1, p3, p4, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 921
    iget-object v0, p0, Landroid/text/SpannableStringBuilder;->mText:[C

    iget v1, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    iget v2, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    add-int/2addr v1, v2

    iget v2, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    sub-int/2addr v2, p1

    add-int/2addr v2, p4

    iget v3, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    sub-int v3, p2, v3

    invoke-static {v0, v1, p3, v2, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    goto :goto_10
.end method

.method public getFilters()[Landroid/text/InputFilter;
    .registers 2

    .prologue
    .line 1317
    iget-object v0, p0, Landroid/text/SpannableStringBuilder;->mFilters:[Landroid/text/InputFilter;

    return-object v0
.end method

.method public getSpanEnd(Ljava/lang/Object;)I
    .registers 7
    .parameter "what"

    .prologue
    .line 730
    iget v0, p0, Landroid/text/SpannableStringBuilder;->mSpanCount:I

    .line 731
    .local v0, count:I
    iget-object v2, p0, Landroid/text/SpannableStringBuilder;->mSpans:[Ljava/lang/Object;

    .line 733
    .local v2, spans:[Ljava/lang/Object;
    add-int/lit8 v1, v0, -0x1

    .local v1, i:I
    :goto_6
    if-ltz v1, :cond_1b

    .line 734
    aget-object v4, v2, v1

    if-ne v4, p1, :cond_18

    .line 735
    iget-object v4, p0, Landroid/text/SpannableStringBuilder;->mSpanEnds:[I

    aget v3, v4, v1

    .line 737
    .local v3, where:I
    iget v4, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    if-le v3, v4, :cond_17

    .line 738
    iget v4, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    sub-int/2addr v3, v4

    .line 744
    .end local v3           #where:I
    :cond_17
    :goto_17
    return v3

    .line 733
    :cond_18
    add-int/lit8 v1, v1, -0x1

    goto :goto_6

    .line 744
    :cond_1b
    const/4 v3, -0x1

    goto :goto_17
.end method

.method public getSpanFlags(Ljava/lang/Object;)I
    .registers 6
    .parameter "what"

    .prologue
    .line 752
    iget v0, p0, Landroid/text/SpannableStringBuilder;->mSpanCount:I

    .line 753
    .local v0, count:I
    iget-object v2, p0, Landroid/text/SpannableStringBuilder;->mSpans:[Ljava/lang/Object;

    .line 755
    .local v2, spans:[Ljava/lang/Object;
    add-int/lit8 v1, v0, -0x1

    .local v1, i:I
    :goto_6
    if-ltz v1, :cond_14

    .line 756
    aget-object v3, v2, v1

    if-ne v3, p1, :cond_11

    .line 757
    iget-object v3, p0, Landroid/text/SpannableStringBuilder;->mSpanFlags:[I

    aget v3, v3, v1

    .line 761
    :goto_10
    return v3

    .line 755
    :cond_11
    add-int/lit8 v1, v1, -0x1

    goto :goto_6

    .line 761
    :cond_14
    const/4 v3, 0x0

    goto :goto_10
.end method

.method public getSpanStart(Ljava/lang/Object;)I
    .registers 7
    .parameter "what"

    .prologue
    .line 708
    iget v0, p0, Landroid/text/SpannableStringBuilder;->mSpanCount:I

    .line 709
    .local v0, count:I
    iget-object v2, p0, Landroid/text/SpannableStringBuilder;->mSpans:[Ljava/lang/Object;

    .line 711
    .local v2, spans:[Ljava/lang/Object;
    add-int/lit8 v1, v0, -0x1

    .local v1, i:I
    :goto_6
    if-ltz v1, :cond_1b

    .line 712
    aget-object v4, v2, v1

    if-ne v4, p1, :cond_18

    .line 713
    iget-object v4, p0, Landroid/text/SpannableStringBuilder;->mSpanStarts:[I

    aget v3, v4, v1

    .line 715
    .local v3, where:I
    iget v4, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    if-le v3, v4, :cond_17

    .line 716
    iget v4, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    sub-int/2addr v3, v4

    .line 722
    .end local v3           #where:I
    :cond_17
    :goto_17
    return v3

    .line 711
    :cond_18
    add-int/lit8 v1, v1, -0x1

    goto :goto_6

    .line 722
    :cond_1b
    const/4 v3, -0x1

    goto :goto_17
.end method

.method public getSpans(IILjava/lang/Class;)[Ljava/lang/Object;
    .registers 26
    .parameter "queryStart"
    .parameter "queryEnd"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(II",
            "Ljava/lang/Class",
            "<TT;>;)[TT;"
        }
    .end annotation

    .prologue
    .line 771
    .local p3, kind:Ljava/lang/Class;,"Ljava/lang/Class<TT;>;"
    if-nez p3, :cond_7

    invoke-static/range {p3 .. p3}, Lcom/android/internal/util/ArrayUtils;->emptyArray(Ljava/lang/Class;)[Ljava/lang/Object;

    move-result-object v13

    .line 862
    :cond_6
    :goto_6
    return-object v13

    .line 773
    :cond_7
    move-object/from16 v0, p0

    iget v15, v0, Landroid/text/SpannableStringBuilder;->mSpanCount:I

    .line 774
    .local v15, spanCount:I
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/text/SpannableStringBuilder;->mSpans:[Ljava/lang/Object;

    move-object/from16 v18, v0

    .line 775
    .local v18, spans:[Ljava/lang/Object;
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/text/SpannableStringBuilder;->mSpanStarts:[I

    move-object/from16 v19, v0

    .line 776
    .local v19, starts:[I
    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/text/SpannableStringBuilder;->mSpanEnds:[I

    .line 777
    .local v4, ends:[I
    move-object/from16 v0, p0

    iget-object v5, v0, Landroid/text/SpannableStringBuilder;->mSpanFlags:[I

    .line 778
    .local v5, flags:[I
    move-object/from16 v0, p0

    iget v7, v0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    .line 779
    .local v7, gapstart:I
    move-object/from16 v0, p0

    iget v6, v0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    .line 781
    .local v6, gaplen:I
    const/4 v2, 0x0

    .line 782
    .local v2, count:I
    const/4 v13, 0x0

    .line 783
    .local v13, ret:[Ljava/lang/Object;,"[TT;"
    const/4 v14, 0x0

    .line 785
    .local v14, ret1:Ljava/lang/Object;,"TT;"
    const/4 v8, 0x0

    .local v8, i:I
    move v3, v2

    .end local v2           #count:I
    .end local v14           #ret1:Ljava/lang/Object;,"TT;"
    .local v3, count:I
    :goto_2c
    if-ge v8, v15, :cond_d7

    .line 786
    aget v17, v19, v8

    .line 787
    .local v17, spanStart:I
    move/from16 v0, v17

    if-le v0, v7, :cond_36

    .line 788
    sub-int v17, v17, v6

    .line 790
    :cond_36
    move/from16 v0, v17

    move/from16 v1, p2

    if-le v0, v1, :cond_41

    move v2, v3

    .line 785
    .end local v3           #count:I
    .restart local v2       #count:I
    :goto_3d
    add-int/lit8 v8, v8, 0x1

    move v3, v2

    .end local v2           #count:I
    .restart local v3       #count:I
    goto :goto_2c

    .line 794
    :cond_41
    aget v16, v4, v8

    .line 795
    .local v16, spanEnd:I
    move/from16 v0, v16

    if-le v0, v7, :cond_49

    .line 796
    sub-int v16, v16, v6

    .line 798
    :cond_49
    move/from16 v0, v16

    move/from16 v1, p1

    if-ge v0, v1, :cond_51

    move v2, v3

    .line 799
    .end local v3           #count:I
    .restart local v2       #count:I
    goto :goto_3d

    .line 802
    .end local v2           #count:I
    .restart local v3       #count:I
    :cond_51
    move/from16 v0, v17

    move/from16 v1, v16

    if-eq v0, v1, :cond_6d

    move/from16 v0, p1

    move/from16 v1, p2

    if-eq v0, v1, :cond_6d

    .line 803
    move/from16 v0, v17

    move/from16 v1, p2

    if-ne v0, v1, :cond_65

    move v2, v3

    .line 804
    .end local v3           #count:I
    .restart local v2       #count:I
    goto :goto_3d

    .line 805
    .end local v2           #count:I
    .restart local v3       #count:I
    :cond_65
    move/from16 v0, v16

    move/from16 v1, p1

    if-ne v0, v1, :cond_6d

    move v2, v3

    .line 806
    .end local v3           #count:I
    .restart local v2       #count:I
    goto :goto_3d

    .line 810
    .end local v2           #count:I
    .restart local v3       #count:I
    :cond_6d
    aget-object v20, v18, v8

    move-object/from16 v0, p3

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/Class;->isInstance(Ljava/lang/Object;)Z

    move-result v20

    if-nez v20, :cond_7b

    move v2, v3

    .end local v3           #count:I
    .restart local v2       #count:I
    goto :goto_3d

    .line 812
    .end local v2           #count:I
    .restart local v3       #count:I
    :cond_7b
    if-nez v3, :cond_82

    .line 814
    aget-object v14, v18, v8

    .line 815
    .restart local v14       #ret1:Ljava/lang/Object;,"TT;"
    add-int/lit8 v2, v3, 0x1

    .end local v3           #count:I
    .restart local v2       #count:I
    goto :goto_3d

    .line 817
    .end local v2           #count:I
    .end local v14           #ret1:Ljava/lang/Object;,"TT;"
    .restart local v3       #count:I
    :cond_82
    const/16 v20, 0x1

    move/from16 v0, v20

    if-ne v3, v0, :cond_9e

    .line 819
    sub-int v20, v15, v8

    add-int/lit8 v20, v20, 0x1

    move-object/from16 v0, p3

    move/from16 v1, v20

    invoke-static {v0, v1}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v20

    check-cast v20, [Ljava/lang/Object;

    move-object/from16 v13, v20

    check-cast v13, [Ljava/lang/Object;

    .line 820
    const/16 v20, 0x0

    aput-object v14, v13, v20

    .line 823
    :cond_9e
    aget v20, v5, v8

    const/high16 v21, 0xff

    and-int v12, v20, v21

    .line 824
    .local v12, prio:I
    if-eqz v12, :cond_cf

    .line 827
    const/4 v9, 0x0

    .local v9, j:I
    :goto_a7
    if-ge v9, v3, :cond_b9

    .line 828
    aget-object v20, v13, v9

    move-object/from16 v0, p0

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Landroid/text/SpannableStringBuilder;->getSpanFlags(Ljava/lang/Object;)I

    move-result v20

    const/high16 v21, 0xff

    and-int v11, v20, v21

    .line 830
    .local v11, p:I
    if-le v12, v11, :cond_cc

    .line 835
    .end local v11           #p:I
    :cond_b9
    add-int/lit8 v20, v9, 0x1

    sub-int v21, v3, v9

    move/from16 v0, v20

    move/from16 v1, v21

    invoke-static {v13, v9, v13, v0, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 837
    aget-object v20, v18, v8

    aput-object v20, v13, v9

    .line 838
    add-int/lit8 v2, v3, 0x1

    .line 839
    .end local v3           #count:I
    .restart local v2       #count:I
    goto/16 :goto_3d

    .line 827
    .end local v2           #count:I
    .restart local v3       #count:I
    .restart local v11       #p:I
    :cond_cc
    add-int/lit8 v9, v9, 0x1

    goto :goto_a7

    .line 841
    .end local v9           #j:I
    .end local v11           #p:I
    :cond_cf
    add-int/lit8 v2, v3, 0x1

    .end local v3           #count:I
    .restart local v2       #count:I
    aget-object v20, v18, v8

    aput-object v20, v13, v3

    goto/16 :goto_3d

    .line 846
    .end local v2           #count:I
    .end local v12           #prio:I
    .end local v16           #spanEnd:I
    .end local v17           #spanStart:I
    .restart local v3       #count:I
    :cond_d7
    if-nez v3, :cond_df

    .line 847
    invoke-static/range {p3 .. p3}, Lcom/android/internal/util/ArrayUtils;->emptyArray(Ljava/lang/Class;)[Ljava/lang/Object;

    move-result-object v13

    goto/16 :goto_6

    .line 849
    :cond_df
    const/16 v20, 0x1

    move/from16 v0, v20

    if-ne v3, v0, :cond_fb

    .line 851
    const/16 v20, 0x1

    move-object/from16 v0, p3

    move/from16 v1, v20

    invoke-static {v0, v1}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v20

    check-cast v20, [Ljava/lang/Object;

    move-object/from16 v13, v20

    check-cast v13, [Ljava/lang/Object;

    .line 852
    const/16 v20, 0x0

    aput-object v14, v13, v20

    goto/16 :goto_6

    .line 855
    :cond_fb
    array-length v0, v13

    move/from16 v20, v0

    move/from16 v0, v20

    if-eq v3, v0, :cond_6

    .line 860
    move-object/from16 v0, p3

    invoke-static {v0, v3}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v20

    check-cast v20, [Ljava/lang/Object;

    move-object/from16 v10, v20

    check-cast v10, [Ljava/lang/Object;

    .line 861
    .local v10, nret:[Ljava/lang/Object;,"[TT;"
    const/16 v20, 0x0

    const/16 v21, 0x0

    move/from16 v0, v20

    move/from16 v1, v21

    invoke-static {v13, v0, v10, v1, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    move-object v13, v10

    .line 862
    goto/16 :goto_6
.end method

.method public getTextRunAdvances(IIIII[FILandroid/graphics/Paint;)F
    .registers 19
    .parameter "start"
    .parameter "end"
    .parameter "contextStart"
    .parameter "contextEnd"
    .parameter "flags"
    .parameter "advances"
    .parameter "advancesPos"
    .parameter "p"

    .prologue
    .line 1208
    sub-int v5, p4, p3

    .line 1209
    .local v5, contextLen:I
    sub-int v3, p2, p1

    .line 1211
    .local v3, len:I
    iget v0, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    if-gt p2, v0, :cond_18

    .line 1212
    iget-object v1, p0, Landroid/text/SpannableStringBuilder;->mText:[C

    move-object/from16 v0, p8

    move v2, p1

    move v4, p3

    move v6, p5

    move-object/from16 v7, p6

    move/from16 v8, p7

    invoke-virtual/range {v0 .. v8}, Landroid/graphics/Paint;->getTextRunAdvances([CIIIII[FI)F

    move-result v9

    .line 1225
    .local v9, ret:F
    :goto_17
    return v9

    .line 1214
    .end local v9           #ret:F
    :cond_18
    iget v0, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    if-lt p1, v0, :cond_32

    .line 1215
    iget-object v1, p0, Landroid/text/SpannableStringBuilder;->mText:[C

    iget v0, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    add-int v2, p1, v0

    iget v0, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    add-int v4, p3, v0

    move-object/from16 v0, p8

    move v6, p5

    move-object/from16 v7, p6

    move/from16 v8, p7

    invoke-virtual/range {v0 .. v8}, Landroid/graphics/Paint;->getTextRunAdvances([CIIIII[FI)F

    move-result v9

    .restart local v9       #ret:F
    goto :goto_17

    .line 1218
    .end local v9           #ret:F
    :cond_32
    invoke-static {v5}, Landroid/text/TextUtils;->obtain(I)[C

    move-result-object v1

    .line 1219
    .local v1, buf:[C
    const/4 v0, 0x0

    invoke-virtual {p0, p3, p4, v1, v0}, Landroid/text/SpannableStringBuilder;->getChars(II[CI)V

    .line 1220
    sub-int v2, p1, p3

    const/4 v4, 0x0

    move-object/from16 v0, p8

    move v6, p5

    move-object/from16 v7, p6

    move/from16 v8, p7

    invoke-virtual/range {v0 .. v8}, Landroid/graphics/Paint;->getTextRunAdvances([CIIIII[FI)F

    move-result v9

    .line 1222
    .restart local v9       #ret:F
    invoke-static {v1}, Landroid/text/TextUtils;->recycle([C)V

    goto :goto_17
.end method

.method public getTextRunAdvances(IIIII[FILandroid/graphics/Paint;I)F
    .registers 21
    .parameter "start"
    .parameter "end"
    .parameter "contextStart"
    .parameter "contextEnd"
    .parameter "flags"
    .parameter "advances"
    .parameter "advancesPos"
    .parameter "p"
    .parameter "reserved"

    .prologue
    .line 1237
    sub-int v5, p4, p3

    .line 1238
    .local v5, contextLen:I
    sub-int v3, p2, p1

    .line 1240
    .local v3, len:I
    iget v0, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    if-gt p2, v0, :cond_1b

    .line 1241
    iget-object v1, p0, Landroid/text/SpannableStringBuilder;->mText:[C

    move-object/from16 v0, p8

    move v2, p1

    move v4, p3

    move/from16 v6, p5

    move-object/from16 v7, p6

    move/from16 v8, p7

    move/from16 v9, p9

    invoke-virtual/range {v0 .. v9}, Landroid/graphics/Paint;->getTextRunAdvances([CIIIII[FII)F

    move-result v10

    .line 1254
    .local v10, ret:F
    :goto_1a
    return v10

    .line 1243
    .end local v10           #ret:F
    :cond_1b
    iget v0, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    if-lt p1, v0, :cond_38

    .line 1244
    iget-object v1, p0, Landroid/text/SpannableStringBuilder;->mText:[C

    iget v0, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    add-int v2, p1, v0

    iget v0, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    add-int v4, p3, v0

    move-object/from16 v0, p8

    move/from16 v6, p5

    move-object/from16 v7, p6

    move/from16 v8, p7

    move/from16 v9, p9

    invoke-virtual/range {v0 .. v9}, Landroid/graphics/Paint;->getTextRunAdvances([CIIIII[FII)F

    move-result v10

    .restart local v10       #ret:F
    goto :goto_1a

    .line 1247
    .end local v10           #ret:F
    :cond_38
    invoke-static {v5}, Landroid/text/TextUtils;->obtain(I)[C

    move-result-object v1

    .line 1248
    .local v1, buf:[C
    const/4 v0, 0x0

    invoke-virtual {p0, p3, p4, v1, v0}, Landroid/text/SpannableStringBuilder;->getChars(II[CI)V

    .line 1249
    sub-int v2, p1, p3

    const/4 v4, 0x0

    move-object/from16 v0, p8

    move/from16 v6, p5

    move-object/from16 v7, p6

    move/from16 v8, p7

    move/from16 v9, p9

    invoke-virtual/range {v0 .. v9}, Landroid/graphics/Paint;->getTextRunAdvances([CIIIII[FII)F

    move-result v10

    .line 1251
    .restart local v10       #ret:F
    invoke-static {v1}, Landroid/text/TextUtils;->recycle([C)V

    goto :goto_1a
.end method

.method public getTextRunCursor(IIIIILandroid/graphics/Paint;)I
    .registers 15
    .parameter "contextStart"
    .parameter "contextEnd"
    .parameter "flags"
    .parameter "offset"
    .parameter "cursorOpt"
    .parameter "p"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 1288
    sub-int v3, p2, p1

    .line 1289
    .local v3, contextLen:I
    iget v0, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    if-gt p2, v0, :cond_13

    .line 1290
    iget-object v1, p0, Landroid/text/SpannableStringBuilder;->mText:[C

    move-object v0, p6

    move v2, p1

    move v4, p3

    move v5, p4

    move v6, p5

    invoke-virtual/range {v0 .. v6}, Landroid/graphics/Paint;->getTextRunCursor([CIIIII)I

    move-result v7

    .line 1303
    .local v7, ret:I
    :goto_12
    return v7

    .line 1292
    .end local v7           #ret:I
    :cond_13
    iget v0, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    if-lt p1, v0, :cond_2d

    .line 1293
    iget-object v1, p0, Landroid/text/SpannableStringBuilder;->mText:[C

    iget v0, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    add-int v2, p1, v0

    iget v0, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    add-int v5, p4, v0

    move-object v0, p6

    move v4, p3

    move v6, p5

    invoke-virtual/range {v0 .. v6}, Landroid/graphics/Paint;->getTextRunCursor([CIIIII)I

    move-result v0

    iget v2, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    sub-int v7, v0, v2

    .restart local v7       #ret:I
    goto :goto_12

    .line 1296
    .end local v7           #ret:I
    :cond_2d
    invoke-static {v3}, Landroid/text/TextUtils;->obtain(I)[C

    move-result-object v1

    .line 1297
    .local v1, buf:[C
    invoke-virtual {p0, p1, p2, v1, v2}, Landroid/text/SpannableStringBuilder;->getChars(II[CI)V

    .line 1298
    sub-int v5, p4, p1

    move-object v0, p6

    move v4, p3

    move v6, p5

    invoke-virtual/range {v0 .. v6}, Landroid/graphics/Paint;->getTextRunCursor([CIIIII)I

    move-result v0

    add-int v7, v0, p1

    .line 1300
    .restart local v7       #ret:I
    invoke-static {v1}, Landroid/text/TextUtils;->recycle([C)V

    goto :goto_12
.end method

.method public getTextWidths(II[FLandroid/graphics/Paint;)I
    .registers 10
    .parameter "start"
    .parameter "end"
    .parameter "widths"
    .parameter "p"

    .prologue
    const/4 v3, 0x0

    .line 1180
    const-string v2, "getTextWidths"

    invoke-direct {p0, v2, p1, p2}, Landroid/text/SpannableStringBuilder;->checkRange(Ljava/lang/String;II)V

    .line 1184
    iget v2, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    if-gt p2, v2, :cond_13

    .line 1185
    iget-object v2, p0, Landroid/text/SpannableStringBuilder;->mText:[C

    sub-int v3, p2, p1

    invoke-virtual {p4, v2, p1, v3, p3}, Landroid/graphics/Paint;->getTextWidths([CII[F)I

    move-result v1

    .line 1196
    .local v1, ret:I
    :goto_12
    return v1

    .line 1186
    .end local v1           #ret:I
    :cond_13
    iget v2, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    if-lt p1, v2, :cond_23

    .line 1187
    iget-object v2, p0, Landroid/text/SpannableStringBuilder;->mText:[C

    iget v3, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    add-int/2addr v3, p1

    sub-int v4, p2, p1

    invoke-virtual {p4, v2, v3, v4, p3}, Landroid/graphics/Paint;->getTextWidths([CII[F)I

    move-result v1

    .restart local v1       #ret:I
    goto :goto_12

    .line 1189
    .end local v1           #ret:I
    :cond_23
    sub-int v2, p2, p1

    invoke-static {v2}, Landroid/text/TextUtils;->obtain(I)[C

    move-result-object v0

    .line 1191
    .local v0, buf:[C
    invoke-virtual {p0, p1, p2, v0, v3}, Landroid/text/SpannableStringBuilder;->getChars(II[CI)V

    .line 1192
    sub-int v2, p2, p1

    invoke-virtual {p4, v0, v3, v2, p3}, Landroid/graphics/Paint;->getTextWidths([CII[F)I

    move-result v1

    .line 1193
    .restart local v1       #ret:I
    invoke-static {v0}, Landroid/text/TextUtils;->recycle([C)V

    goto :goto_12
.end method

.method public bridge synthetic insert(ILjava/lang/CharSequence;)Landroid/text/Editable;
    .registers 4
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 30
    invoke-virtual {p0, p1, p2}, Landroid/text/SpannableStringBuilder;->insert(ILjava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic insert(ILjava/lang/CharSequence;II)Landroid/text/Editable;
    .registers 6
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"
    .parameter "x3"

    .prologue
    .line 30
    invoke-virtual {p0, p1, p2, p3, p4}, Landroid/text/SpannableStringBuilder;->insert(ILjava/lang/CharSequence;II)Landroid/text/SpannableStringBuilder;

    move-result-object v0

    return-object v0
.end method

.method public insert(ILjava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    .registers 9
    .parameter "where"
    .parameter "tb"

    .prologue
    .line 207
    const/4 v4, 0x0

    invoke-interface {p2}, Ljava/lang/CharSequence;->length()I

    move-result v5

    move-object v0, p0

    move v1, p1

    move v2, p1

    move-object v3, p2

    invoke-virtual/range {v0 .. v5}, Landroid/text/SpannableStringBuilder;->replace(IILjava/lang/CharSequence;II)Landroid/text/SpannableStringBuilder;

    move-result-object v0

    return-object v0
.end method

.method public insert(ILjava/lang/CharSequence;II)Landroid/text/SpannableStringBuilder;
    .registers 11
    .parameter "where"
    .parameter "tb"
    .parameter "start"
    .parameter "end"

    .prologue
    .line 202
    move-object v0, p0

    move v1, p1

    move v2, p1

    move-object v3, p2

    move v4, p3

    move v5, p4

    invoke-virtual/range {v0 .. v5}, Landroid/text/SpannableStringBuilder;->replace(IILjava/lang/CharSequence;II)Landroid/text/SpannableStringBuilder;

    move-result-object v0

    return-object v0
.end method

.method public length()I
    .registers 3

    .prologue
    .line 127
    iget-object v0, p0, Landroid/text/SpannableStringBuilder;->mText:[C

    array-length v0, v0

    iget v1, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    sub-int/2addr v0, v1

    return v0
.end method

.method public measureText(IILandroid/graphics/Paint;)F
    .registers 9
    .parameter "start"
    .parameter "end"
    .parameter "p"

    .prologue
    const/4 v3, 0x0

    .line 1156
    const-string/jumbo v2, "measureText"

    invoke-direct {p0, v2, p1, p2}, Landroid/text/SpannableStringBuilder;->checkRange(Ljava/lang/String;II)V

    .line 1160
    iget v2, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    if-gt p2, v2, :cond_14

    .line 1161
    iget-object v2, p0, Landroid/text/SpannableStringBuilder;->mText:[C

    sub-int v3, p2, p1

    invoke-virtual {p3, v2, p1, v3}, Landroid/graphics/Paint;->measureText([CII)F

    move-result v1

    .line 1172
    .local v1, ret:F
    :goto_13
    return v1

    .line 1162
    .end local v1           #ret:F
    :cond_14
    iget v2, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    if-lt p1, v2, :cond_24

    .line 1163
    iget-object v2, p0, Landroid/text/SpannableStringBuilder;->mText:[C

    iget v3, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    add-int/2addr v3, p1

    sub-int v4, p2, p1

    invoke-virtual {p3, v2, v3, v4}, Landroid/graphics/Paint;->measureText([CII)F

    move-result v1

    .restart local v1       #ret:F
    goto :goto_13

    .line 1165
    .end local v1           #ret:F
    :cond_24
    sub-int v2, p2, p1

    invoke-static {v2}, Landroid/text/TextUtils;->obtain(I)[C

    move-result-object v0

    .line 1167
    .local v0, buf:[C
    invoke-virtual {p0, p1, p2, v0, v3}, Landroid/text/SpannableStringBuilder;->getChars(II[CI)V

    .line 1168
    sub-int v2, p2, p1

    invoke-virtual {p3, v0, v3, v2}, Landroid/graphics/Paint;->measureText([CII)F

    move-result v1

    .line 1169
    .restart local v1       #ret:F
    invoke-static {v0}, Landroid/text/TextUtils;->recycle([C)V

    goto :goto_13
.end method

.method public nextSpanTransition(IILjava/lang/Class;)I
    .registers 14
    .parameter "start"
    .parameter "limit"
    .parameter "kind"

    .prologue
    .line 871
    iget v0, p0, Landroid/text/SpannableStringBuilder;->mSpanCount:I

    .line 872
    .local v0, count:I
    iget-object v6, p0, Landroid/text/SpannableStringBuilder;->mSpans:[Ljava/lang/Object;

    .line 873
    .local v6, spans:[Ljava/lang/Object;
    iget-object v8, p0, Landroid/text/SpannableStringBuilder;->mSpanStarts:[I

    .line 874
    .local v8, starts:[I
    iget-object v2, p0, Landroid/text/SpannableStringBuilder;->mSpanEnds:[I

    .line 875
    .local v2, ends:[I
    iget v4, p0, Landroid/text/SpannableStringBuilder;->mGapStart:I

    .line 876
    .local v4, gapstart:I
    iget v3, p0, Landroid/text/SpannableStringBuilder;->mGapLength:I

    .line 878
    .local v3, gaplen:I
    if-nez p3, :cond_10

    .line 879
    const-class p3, Ljava/lang/Object;

    .line 882
    :cond_10
    const/4 v5, 0x0

    .local v5, i:I
    :goto_11
    if-ge v5, v0, :cond_3a

    .line 883
    aget v7, v8, v5

    .line 884
    .local v7, st:I
    aget v1, v2, v5

    .line 886
    .local v1, en:I
    if-le v7, v4, :cond_1a

    .line 887
    sub-int/2addr v7, v3

    .line 888
    :cond_1a
    if-le v1, v4, :cond_1d

    .line 889
    sub-int/2addr v1, v3

    .line 891
    :cond_1d
    if-le v7, p1, :cond_2a

    if-ge v7, p2, :cond_2a

    aget-object v9, v6, v5

    invoke-virtual {p3, v9}, Ljava/lang/Class;->isInstance(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_2a

    .line 892
    move p2, v7

    .line 893
    :cond_2a
    if-le v1, p1, :cond_37

    if-ge v1, p2, :cond_37

    aget-object v9, v6, v5

    invoke-virtual {p3, v9}, Ljava/lang/Class;->isInstance(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_37

    .line 894
    move p2, v1

    .line 882
    :cond_37
    add-int/lit8 v5, v5, 0x1

    goto :goto_11

    .line 897
    .end local v1           #en:I
    .end local v7           #st:I
    :cond_3a
    return p2
.end method

.method public removeSpan(Ljava/lang/Object;)V
    .registers 4
    .parameter "what"

    .prologue
    .line 695
    iget v1, p0, Landroid/text/SpannableStringBuilder;->mSpanCount:I

    add-int/lit8 v0, v1, -0x1

    .local v0, i:I
    :goto_4
    if-ltz v0, :cond_f

    .line 696
    iget-object v1, p0, Landroid/text/SpannableStringBuilder;->mSpans:[Ljava/lang/Object;

    aget-object v1, v1, v0

    if-ne v1, p1, :cond_10

    .line 697
    invoke-direct {p0, v0}, Landroid/text/SpannableStringBuilder;->removeSpan(I)V

    .line 701
    :cond_f
    return-void

    .line 695
    :cond_10
    add-int/lit8 v0, v0, -0x1

    goto :goto_4
.end method

.method public bridge synthetic replace(IILjava/lang/CharSequence;)Landroid/text/Editable;
    .registers 5
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"

    .prologue
    .line 30
    invoke-virtual {p0, p1, p2, p3}, Landroid/text/SpannableStringBuilder;->replace(IILjava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic replace(IILjava/lang/CharSequence;II)Landroid/text/Editable;
    .registers 7
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"
    .parameter "x3"
    .parameter "x4"

    .prologue
    .line 30
    invoke-virtual/range {p0 .. p5}, Landroid/text/SpannableStringBuilder;->replace(IILjava/lang/CharSequence;II)Landroid/text/SpannableStringBuilder;

    move-result-object v0

    return-object v0
.end method

.method public replace(IILjava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    .registers 10
    .parameter "start"
    .parameter "end"
    .parameter "tb"

    .prologue
    .line 435
    const/4 v4, 0x0

    invoke-interface {p3}, Ljava/lang/CharSequence;->length()I

    move-result v5

    move-object v0, p0

    move v1, p1

    move v2, p2

    move-object v3, p3

    invoke-virtual/range {v0 .. v5}, Landroid/text/SpannableStringBuilder;->replace(IILjava/lang/CharSequence;II)Landroid/text/SpannableStringBuilder;

    move-result-object v0

    return-object v0
.end method

.method public replace(IILjava/lang/CharSequence;II)Landroid/text/SpannableStringBuilder;
    .registers 29
    .parameter "start"
    .parameter "end"
    .parameter "tb"
    .parameter "tbstart"
    .parameter "tbend"

    .prologue
    .line 441
    const-string/jumbo v5, "replace"

    move-object/from16 v0, p0

    move/from16 v1, p1

    move/from16 v2, p2

    invoke-direct {v0, v5, v1, v2}, Landroid/text/SpannableStringBuilder;->checkRange(Ljava/lang/String;II)V

    .line 443
    move-object/from16 v0, p0

    iget-object v5, v0, Landroid/text/SpannableStringBuilder;->mFilters:[Landroid/text/InputFilter;

    array-length v0, v5

    move/from16 v16, v0

    .line 444
    .local v16, filtercount:I
    const/16 v17, 0x0

    .local v17, i:I
    :goto_15
    move/from16 v0, v17

    move/from16 v1, v16

    if-ge v0, v1, :cond_3e

    .line 445
    move-object/from16 v0, p0

    iget-object v5, v0, Landroid/text/SpannableStringBuilder;->mFilters:[Landroid/text/InputFilter;

    aget-object v5, v5, v17

    move-object/from16 v6, p3

    move/from16 v7, p4

    move/from16 v8, p5

    move-object/from16 v9, p0

    move/from16 v10, p1

    move/from16 v11, p2

    invoke-interface/range {v5 .. v11}, Landroid/text/InputFilter;->filter(Ljava/lang/CharSequence;IILandroid/text/Spanned;II)Ljava/lang/CharSequence;

    move-result-object v21

    .line 447
    .local v21, repl:Ljava/lang/CharSequence;
    if-eqz v21, :cond_3b

    .line 448
    move-object/from16 p3, v21

    .line 449
    const/16 p4, 0x0

    .line 450
    invoke-interface/range {v21 .. v21}, Ljava/lang/CharSequence;->length()I

    move-result p5

    .line 444
    :cond_3b
    add-int/lit8 v17, v17, 0x1

    goto :goto_15

    .line 454
    .end local v21           #repl:Ljava/lang/CharSequence;
    :cond_3e
    sub-int v20, p2, p1

    .line 455
    .local v20, origLen:I
    sub-int v18, p5, p4

    .line 457
    .local v18, newLen:I
    if-nez v20, :cond_4d

    if-nez v18, :cond_4d

    invoke-static/range {p3 .. p4}, Landroid/text/SpannableStringBuilder;->hasNonExclusiveExclusiveSpanAt(Ljava/lang/CharSequence;I)Z

    move-result v5

    if-nez v5, :cond_4d

    .line 502
    :goto_4c
    return-object p0

    .line 463
    :cond_4d
    add-int v5, p1, v20

    const-class v6, Landroid/text/TextWatcher;

    move-object/from16 v0, p0

    move/from16 v1, p1

    invoke-virtual {v0, v1, v5, v6}, Landroid/text/SpannableStringBuilder;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v22

    check-cast v22, [Landroid/text/TextWatcher;

    .line 464
    .local v22, textWatchers:[Landroid/text/TextWatcher;
    move-object/from16 v0, p0

    move-object/from16 v1, v22

    move/from16 v2, p1

    move/from16 v3, v20

    move/from16 v4, v18

    invoke-direct {v0, v1, v2, v3, v4}, Landroid/text/SpannableStringBuilder;->sendBeforeTextChanged([Landroid/text/TextWatcher;III)V

    .line 469
    if-eqz v20, :cond_d5

    if-eqz v18, :cond_d5

    const/4 v15, 0x1

    .line 470
    .local v15, adjustSelection:Z
    :goto_6d
    const/4 v8, 0x0

    .line 471
    .local v8, selectionStart:I
    const/4 v12, 0x0

    .line 472
    .local v12, selectionEnd:I
    if-eqz v15, :cond_79

    .line 473
    invoke-static/range {p0 .. p0}, Landroid/text/Selection;->getSelectionStart(Ljava/lang/CharSequence;)I

    move-result v8

    .line 474
    invoke-static/range {p0 .. p0}, Landroid/text/Selection;->getSelectionEnd(Ljava/lang/CharSequence;)I

    move-result v12

    .line 477
    :cond_79
    invoke-direct/range {p0 .. p5}, Landroid/text/SpannableStringBuilder;->change(IILjava/lang/CharSequence;II)V

    .line 479
    if-eqz v15, :cond_b4

    .line 480
    move/from16 v0, p1

    if-le v8, v0, :cond_99

    move/from16 v0, p2

    if-ge v8, v0, :cond_99

    .line 481
    sub-int v5, v8, p1

    mul-int v5, v5, v18

    div-int v19, v5, v20

    .line 482
    .local v19, offset:I
    add-int v8, p1, v19

    .line 484
    const/4 v6, 0x0

    sget-object v7, Landroid/text/Selection;->SELECTION_START:Ljava/lang/Object;

    const/16 v10, 0x22

    move-object/from16 v5, p0

    move v9, v8

    invoke-direct/range {v5 .. v10}, Landroid/text/SpannableStringBuilder;->setSpan(ZLjava/lang/Object;III)V

    .line 487
    .end local v19           #offset:I
    :cond_99
    move/from16 v0, p1

    if-le v12, v0, :cond_b4

    move/from16 v0, p2

    if-ge v12, v0, :cond_b4

    .line 488
    sub-int v5, v12, p1

    mul-int v5, v5, v18

    div-int v19, v5, v20

    .line 489
    .restart local v19       #offset:I
    add-int v12, p1, v19

    .line 491
    const/4 v10, 0x0

    sget-object v11, Landroid/text/Selection;->SELECTION_END:Ljava/lang/Object;

    const/16 v14, 0x22

    move-object/from16 v9, p0

    move v13, v12

    invoke-direct/range {v9 .. v14}, Landroid/text/SpannableStringBuilder;->setSpan(ZLjava/lang/Object;III)V

    .line 496
    .end local v19           #offset:I
    :cond_b4
    move-object/from16 v0, p0

    move-object/from16 v1, v22

    move/from16 v2, p1

    move/from16 v3, v20

    move/from16 v4, v18

    invoke-direct {v0, v1, v2, v3, v4}, Landroid/text/SpannableStringBuilder;->sendTextChanged([Landroid/text/TextWatcher;III)V

    .line 497
    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-direct {v0, v1}, Landroid/text/SpannableStringBuilder;->sendAfterTextChanged([Landroid/text/TextWatcher;)V

    .line 500
    sub-int v5, v18, v20

    move-object/from16 v0, p0

    move/from16 v1, p1

    move/from16 v2, p2

    invoke-direct {v0, v1, v2, v5}, Landroid/text/SpannableStringBuilder;->sendToSpanWatchers(III)V

    goto/16 :goto_4c

    .line 469
    .end local v8           #selectionStart:I
    .end local v12           #selectionEnd:I
    .end local v15           #adjustSelection:Z
    :cond_d5
    const/4 v15, 0x0

    goto :goto_6d
.end method

.method public setFilters([Landroid/text/InputFilter;)V
    .registers 3
    .parameter "filters"

    .prologue
    .line 1308
    if-nez p1, :cond_8

    .line 1309
    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-direct {v0}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v0

    .line 1312
    :cond_8
    iput-object p1, p0, Landroid/text/SpannableStringBuilder;->mFilters:[Landroid/text/InputFilter;

    .line 1313
    return-void
.end method

.method public setSpan(Ljava/lang/Object;III)V
    .registers 11
    .parameter "what"
    .parameter "start"
    .parameter "end"
    .parameter "flags"

    .prologue
    .line 588
    const/4 v1, 0x1

    move-object v0, p0

    move-object v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    invoke-direct/range {v0 .. v5}, Landroid/text/SpannableStringBuilder;->setSpan(ZLjava/lang/Object;III)V

    .line 589
    return-void
.end method

.method public subSequence(II)Ljava/lang/CharSequence;
    .registers 4
    .parameter "start"
    .parameter "end"

    .prologue
    .line 905
    new-instance v0, Landroid/text/SpannableStringBuilder;

    invoke-direct {v0, p0, p1, p2}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;II)V

    return-object v0
.end method

.method public substring(II)Ljava/lang/String;
    .registers 5
    .parameter "start"
    .parameter "end"

    .prologue
    .line 945
    sub-int v1, p2, p1

    new-array v0, v1, [C

    .line 946
    .local v0, buf:[C
    const/4 v1, 0x0

    invoke-virtual {p0, p1, p2, v0, v1}, Landroid/text/SpannableStringBuilder;->getChars(II[CI)V

    .line 947
    new-instance v1, Ljava/lang/String;

    invoke-direct {v1, v0}, Ljava/lang/String;-><init>([C)V

    return-object v1
.end method

.method public toString()Ljava/lang/String;
    .registers 4

    .prologue
    const/4 v2, 0x0

    .line 932
    invoke-virtual {p0}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v1

    .line 933
    .local v1, len:I
    new-array v0, v1, [C

    .line 935
    .local v0, buf:[C
    invoke-virtual {p0, v2, v1, v0, v2}, Landroid/text/SpannableStringBuilder;->getChars(II[CI)V

    .line 936
    new-instance v2, Ljava/lang/String;

    invoke-direct {v2, v0}, Ljava/lang/String;-><init>([C)V

    return-object v2
.end method
