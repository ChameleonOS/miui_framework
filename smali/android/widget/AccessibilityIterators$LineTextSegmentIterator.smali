.class Landroid/widget/AccessibilityIterators$LineTextSegmentIterator;
.super Landroid/view/AccessibilityIterators$AbstractTextSegmentIterator;
.source "AccessibilityIterators.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/AccessibilityIterators;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "LineTextSegmentIterator"
.end annotation


# static fields
.field protected static final DIRECTION_END:I = 0x1

.field protected static final DIRECTION_START:I = -0x1

.field private static sLineInstance:Landroid/widget/AccessibilityIterators$LineTextSegmentIterator;


# instance fields
.field protected mLayout:Landroid/text/Layout;


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 30
    invoke-direct {p0}, Landroid/view/AccessibilityIterators$AbstractTextSegmentIterator;-><init>()V

    return-void
.end method

.method public static getInstance()Landroid/widget/AccessibilityIterators$LineTextSegmentIterator;
    .registers 1

    .prologue
    .line 39
    sget-object v0, Landroid/widget/AccessibilityIterators$LineTextSegmentIterator;->sLineInstance:Landroid/widget/AccessibilityIterators$LineTextSegmentIterator;

    if-nez v0, :cond_b

    .line 40
    new-instance v0, Landroid/widget/AccessibilityIterators$LineTextSegmentIterator;

    invoke-direct {v0}, Landroid/widget/AccessibilityIterators$LineTextSegmentIterator;-><init>()V

    sput-object v0, Landroid/widget/AccessibilityIterators$LineTextSegmentIterator;->sLineInstance:Landroid/widget/AccessibilityIterators$LineTextSegmentIterator;

    .line 42
    :cond_b
    sget-object v0, Landroid/widget/AccessibilityIterators$LineTextSegmentIterator;->sLineInstance:Landroid/widget/AccessibilityIterators$LineTextSegmentIterator;

    return-object v0
.end method


# virtual methods
.method public following(I)[I
    .registers 11
    .parameter "offset"

    .prologue
    const/4 v8, -0x1

    const/4 v5, 0x0

    .line 52
    iget-object v6, p0, Landroid/view/AccessibilityIterators$AbstractTextSegmentIterator;->mText:Ljava/lang/String;

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v4

    .line 53
    .local v4, textLegth:I
    if-gtz v4, :cond_b

    .line 75
    :cond_a
    :goto_a
    return-object v5

    .line 56
    :cond_b
    iget-object v6, p0, Landroid/view/AccessibilityIterators$AbstractTextSegmentIterator;->mText:Ljava/lang/String;

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v6

    if-ge p1, v6, :cond_a

    .line 60
    if-gez p1, :cond_34

    .line 61
    iget-object v6, p0, Landroid/widget/AccessibilityIterators$LineTextSegmentIterator;->mLayout:Landroid/text/Layout;

    const/4 v7, 0x0

    invoke-virtual {v6, v7}, Landroid/text/Layout;->getLineForOffset(I)I

    move-result v2

    .line 70
    .local v2, nextLine:I
    :goto_1c
    iget-object v6, p0, Landroid/widget/AccessibilityIterators$LineTextSegmentIterator;->mLayout:Landroid/text/Layout;

    invoke-virtual {v6}, Landroid/text/Layout;->getLineCount()I

    move-result v6

    if-ge v2, v6, :cond_a

    .line 73
    invoke-virtual {p0, v2, v8}, Landroid/widget/AccessibilityIterators$LineTextSegmentIterator;->getLineEdgeIndex(II)I

    move-result v3

    .line 74
    .local v3, start:I
    const/4 v5, 0x1

    invoke-virtual {p0, v2, v5}, Landroid/widget/AccessibilityIterators$LineTextSegmentIterator;->getLineEdgeIndex(II)I

    move-result v5

    add-int/lit8 v1, v5, 0x1

    .line 75
    .local v1, end:I
    invoke-virtual {p0, v3, v1}, Landroid/widget/AccessibilityIterators$LineTextSegmentIterator;->getRange(II)[I

    move-result-object v5

    goto :goto_a

    .line 63
    .end local v1           #end:I
    .end local v2           #nextLine:I
    .end local v3           #start:I
    :cond_34
    iget-object v6, p0, Landroid/widget/AccessibilityIterators$LineTextSegmentIterator;->mLayout:Landroid/text/Layout;

    invoke-virtual {v6, p1}, Landroid/text/Layout;->getLineForOffset(I)I

    move-result v0

    .line 64
    .local v0, currentLine:I
    invoke-virtual {p0, v0, v8}, Landroid/widget/AccessibilityIterators$LineTextSegmentIterator;->getLineEdgeIndex(II)I

    move-result v6

    if-ne v6, p1, :cond_42

    .line 65
    move v2, v0

    .restart local v2       #nextLine:I
    goto :goto_1c

    .line 67
    .end local v2           #nextLine:I
    :cond_42
    add-int/lit8 v2, v0, 0x1

    .restart local v2       #nextLine:I
    goto :goto_1c
.end method

.method protected getLineEdgeIndex(II)I
    .registers 5
    .parameter "lineNumber"
    .parameter "direction"

    .prologue
    .line 107
    iget-object v1, p0, Landroid/widget/AccessibilityIterators$LineTextSegmentIterator;->mLayout:Landroid/text/Layout;

    invoke-virtual {v1, p1}, Landroid/text/Layout;->getParagraphDirection(I)I

    move-result v0

    .line 108
    .local v0, paragraphDirection:I
    mul-int v1, p2, v0

    if-gez v1, :cond_11

    .line 109
    iget-object v1, p0, Landroid/widget/AccessibilityIterators$LineTextSegmentIterator;->mLayout:Landroid/text/Layout;

    invoke-virtual {v1, p1}, Landroid/text/Layout;->getLineStart(I)I

    move-result v1

    .line 111
    :goto_10
    return v1

    :cond_11
    iget-object v1, p0, Landroid/widget/AccessibilityIterators$LineTextSegmentIterator;->mLayout:Landroid/text/Layout;

    invoke-virtual {v1, p1}, Landroid/text/Layout;->getLineEnd(I)I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    goto :goto_10
.end method

.method public initialize(Landroid/text/Spannable;Landroid/text/Layout;)V
    .registers 4
    .parameter "text"
    .parameter "layout"

    .prologue
    .line 46
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroid/view/AccessibilityIterators$AbstractTextSegmentIterator;->mText:Ljava/lang/String;

    .line 47
    iput-object p2, p0, Landroid/widget/AccessibilityIterators$LineTextSegmentIterator;->mLayout:Landroid/text/Layout;

    .line 48
    return-void
.end method

.method public preceding(I)[I
    .registers 11
    .parameter "offset"

    .prologue
    const/4 v8, 0x1

    const/4 v5, 0x0

    .line 80
    iget-object v6, p0, Landroid/view/AccessibilityIterators$AbstractTextSegmentIterator;->mText:Ljava/lang/String;

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v4

    .line 81
    .local v4, textLegth:I
    if-gtz v4, :cond_b

    .line 103
    :cond_a
    :goto_a
    return-object v5

    .line 84
    :cond_b
    if-lez p1, :cond_a

    .line 88
    iget-object v6, p0, Landroid/view/AccessibilityIterators$AbstractTextSegmentIterator;->mText:Ljava/lang/String;

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v6

    if-le p1, v6, :cond_33

    .line 89
    iget-object v6, p0, Landroid/widget/AccessibilityIterators$LineTextSegmentIterator;->mLayout:Landroid/text/Layout;

    iget-object v7, p0, Landroid/view/AccessibilityIterators$AbstractTextSegmentIterator;->mText:Ljava/lang/String;

    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v7

    invoke-virtual {v6, v7}, Landroid/text/Layout;->getLineForOffset(I)I

    move-result v2

    .line 98
    .local v2, previousLine:I
    :goto_21
    if-ltz v2, :cond_a

    .line 101
    const/4 v5, -0x1

    invoke-virtual {p0, v2, v5}, Landroid/widget/AccessibilityIterators$LineTextSegmentIterator;->getLineEdgeIndex(II)I

    move-result v3

    .line 102
    .local v3, start:I
    invoke-virtual {p0, v2, v8}, Landroid/widget/AccessibilityIterators$LineTextSegmentIterator;->getLineEdgeIndex(II)I

    move-result v5

    add-int/lit8 v1, v5, 0x1

    .line 103
    .local v1, end:I
    invoke-virtual {p0, v3, v1}, Landroid/widget/AccessibilityIterators$LineTextSegmentIterator;->getRange(II)[I

    move-result-object v5

    goto :goto_a

    .line 91
    .end local v1           #end:I
    .end local v2           #previousLine:I
    .end local v3           #start:I
    :cond_33
    iget-object v6, p0, Landroid/widget/AccessibilityIterators$LineTextSegmentIterator;->mLayout:Landroid/text/Layout;

    invoke-virtual {v6, p1}, Landroid/text/Layout;->getLineForOffset(I)I

    move-result v0

    .line 92
    .local v0, currentLine:I
    invoke-virtual {p0, v0, v8}, Landroid/widget/AccessibilityIterators$LineTextSegmentIterator;->getLineEdgeIndex(II)I

    move-result v6

    add-int/lit8 v6, v6, 0x1

    if-ne v6, p1, :cond_43

    .line 93
    move v2, v0

    .restart local v2       #previousLine:I
    goto :goto_21

    .line 95
    .end local v2           #previousLine:I
    :cond_43
    add-int/lit8 v2, v0, -0x1

    .restart local v2       #previousLine:I
    goto :goto_21
.end method
