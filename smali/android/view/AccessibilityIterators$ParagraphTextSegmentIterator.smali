.class Landroid/view/AccessibilityIterators$ParagraphTextSegmentIterator;
.super Landroid/view/AccessibilityIterators$AbstractTextSegmentIterator;
.source "AccessibilityIterators.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/view/AccessibilityIterators;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "ParagraphTextSegmentIterator"
.end annotation


# static fields
.field private static sInstance:Landroid/view/AccessibilityIterators$ParagraphTextSegmentIterator;


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 257
    invoke-direct {p0}, Landroid/view/AccessibilityIterators$AbstractTextSegmentIterator;-><init>()V

    return-void
.end method

.method public static getInstance()Landroid/view/AccessibilityIterators$ParagraphTextSegmentIterator;
    .registers 1

    .prologue
    .line 261
    sget-object v0, Landroid/view/AccessibilityIterators$ParagraphTextSegmentIterator;->sInstance:Landroid/view/AccessibilityIterators$ParagraphTextSegmentIterator;

    if-nez v0, :cond_b

    .line 262
    new-instance v0, Landroid/view/AccessibilityIterators$ParagraphTextSegmentIterator;

    invoke-direct {v0}, Landroid/view/AccessibilityIterators$ParagraphTextSegmentIterator;-><init>()V

    sput-object v0, Landroid/view/AccessibilityIterators$ParagraphTextSegmentIterator;->sInstance:Landroid/view/AccessibilityIterators$ParagraphTextSegmentIterator;

    .line 264
    :cond_b
    sget-object v0, Landroid/view/AccessibilityIterators$ParagraphTextSegmentIterator;->sInstance:Landroid/view/AccessibilityIterators$ParagraphTextSegmentIterator;

    return-object v0
.end method

.method private isEndBoundary(I)Z
    .registers 5
    .parameter "index"

    .prologue
    const/16 v2, 0xa

    .line 326
    if-lez p1, :cond_20

    iget-object v0, p0, Landroid/view/AccessibilityIterators$AbstractTextSegmentIterator;->mText:Ljava/lang/String;

    add-int/lit8 v1, p1, -0x1

    invoke-virtual {v0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v0

    if-eq v0, v2, :cond_20

    iget-object v0, p0, Landroid/view/AccessibilityIterators$AbstractTextSegmentIterator;->mText:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-eq p1, v0, :cond_1e

    iget-object v0, p0, Landroid/view/AccessibilityIterators$AbstractTextSegmentIterator;->mText:Ljava/lang/String;

    invoke-virtual {v0, p1}, Ljava/lang/String;->charAt(I)C

    move-result v0

    if-ne v0, v2, :cond_20

    :cond_1e
    const/4 v0, 0x1

    :goto_1f
    return v0

    :cond_20
    const/4 v0, 0x0

    goto :goto_1f
.end method

.method private isStartBoundary(I)Z
    .registers 5
    .parameter "index"

    .prologue
    const/16 v2, 0xa

    .line 321
    iget-object v0, p0, Landroid/view/AccessibilityIterators$AbstractTextSegmentIterator;->mText:Ljava/lang/String;

    invoke-virtual {v0, p1}, Ljava/lang/String;->charAt(I)C

    move-result v0

    if-eq v0, v2, :cond_18

    if-eqz p1, :cond_16

    iget-object v0, p0, Landroid/view/AccessibilityIterators$AbstractTextSegmentIterator;->mText:Ljava/lang/String;

    add-int/lit8 v1, p1, -0x1

    invoke-virtual {v0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v0

    if-ne v0, v2, :cond_18

    :cond_16
    const/4 v0, 0x1

    :goto_17
    return v0

    :cond_18
    const/4 v0, 0x0

    goto :goto_17
.end method


# virtual methods
.method public following(I)[I
    .registers 8
    .parameter "offset"

    .prologue
    const/4 v3, 0x0

    .line 269
    iget-object v4, p0, Landroid/view/AccessibilityIterators$AbstractTextSegmentIterator;->mText:Ljava/lang/String;

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v2

    .line 270
    .local v2, textLength:I
    if-gtz v2, :cond_a

    .line 291
    :cond_9
    :goto_9
    return-object v3

    .line 273
    :cond_a
    if-ge p1, v2, :cond_9

    .line 276
    move v1, p1

    .line 277
    .local v1, start:I
    if-gez v1, :cond_10

    .line 278
    const/4 v1, 0x0

    .line 281
    :cond_10
    :goto_10
    if-ge v1, v2, :cond_25

    iget-object v4, p0, Landroid/view/AccessibilityIterators$AbstractTextSegmentIterator;->mText:Ljava/lang/String;

    invoke-virtual {v4, v1}, Ljava/lang/String;->charAt(I)C

    move-result v4

    const/16 v5, 0xa

    if-ne v4, v5, :cond_25

    invoke-direct {p0, v1}, Landroid/view/AccessibilityIterators$ParagraphTextSegmentIterator;->isStartBoundary(I)Z

    move-result v4

    if-nez v4, :cond_25

    .line 282
    add-int/lit8 v1, v1, 0x1

    goto :goto_10

    .line 284
    :cond_25
    if-ge v1, v2, :cond_9

    .line 287
    add-int/lit8 v0, v1, 0x1

    .line 288
    .local v0, end:I
    :goto_29
    if-ge v0, v2, :cond_34

    invoke-direct {p0, v0}, Landroid/view/AccessibilityIterators$ParagraphTextSegmentIterator;->isEndBoundary(I)Z

    move-result v3

    if-nez v3, :cond_34

    .line 289
    add-int/lit8 v0, v0, 0x1

    goto :goto_29

    .line 291
    :cond_34
    invoke-virtual {p0, v1, v0}, Landroid/view/AccessibilityIterators$ParagraphTextSegmentIterator;->getRange(II)[I

    move-result-object v3

    goto :goto_9
.end method

.method public preceding(I)[I
    .registers 8
    .parameter "offset"

    .prologue
    const/4 v3, 0x0

    .line 296
    iget-object v4, p0, Landroid/view/AccessibilityIterators$AbstractTextSegmentIterator;->mText:Ljava/lang/String;

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v2

    .line 297
    .local v2, textLength:I
    if-gtz v2, :cond_a

    .line 317
    :cond_9
    :goto_9
    return-object v3

    .line 300
    :cond_a
    if-lez p1, :cond_9

    .line 303
    move v0, p1

    .line 304
    .local v0, end:I
    if-le v0, v2, :cond_10

    .line 305
    move v0, v2

    .line 307
    :cond_10
    :goto_10
    if-lez v0, :cond_27

    iget-object v4, p0, Landroid/view/AccessibilityIterators$AbstractTextSegmentIterator;->mText:Ljava/lang/String;

    add-int/lit8 v5, v0, -0x1

    invoke-virtual {v4, v5}, Ljava/lang/String;->charAt(I)C

    move-result v4

    const/16 v5, 0xa

    if-ne v4, v5, :cond_27

    invoke-direct {p0, v0}, Landroid/view/AccessibilityIterators$ParagraphTextSegmentIterator;->isEndBoundary(I)Z

    move-result v4

    if-nez v4, :cond_27

    .line 308
    add-int/lit8 v0, v0, -0x1

    goto :goto_10

    .line 310
    :cond_27
    if-lez v0, :cond_9

    .line 313
    add-int/lit8 v1, v0, -0x1

    .line 314
    .local v1, start:I
    :goto_2b
    if-lez v1, :cond_36

    invoke-direct {p0, v1}, Landroid/view/AccessibilityIterators$ParagraphTextSegmentIterator;->isStartBoundary(I)Z

    move-result v3

    if-nez v3, :cond_36

    .line 315
    add-int/lit8 v1, v1, -0x1

    goto :goto_2b

    .line 317
    :cond_36
    invoke-virtual {p0, v1, v0}, Landroid/view/AccessibilityIterators$ParagraphTextSegmentIterator;->getRange(II)[I

    move-result-object v3

    goto :goto_9
.end method
