.class public Landroid/text/SpanSet;
.super Ljava/lang/Object;
.source "SpanSet.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<E:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private final classType:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<+TE;>;"
        }
    .end annotation
.end field

.field numberOfSpans:I

.field spanEnds:[I

.field spanFlags:[I

.field spanStarts:[I

.field spans:[Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "[TE;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Ljava/lang/Class;)V
    .registers 3
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<+TE;>;)V"
        }
    .end annotation

    .prologue
    .local p0, this:Landroid/text/SpanSet;,"Landroid/text/SpanSet<TE;>;"
    .local p1, type:Ljava/lang/Class;,"Ljava/lang/Class<+TE;>;"
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroid/text/SpanSet;->classType:Ljava/lang/Class;

    const/4 v0, 0x0

    iput v0, p0, Landroid/text/SpanSet;->numberOfSpans:I

    return-void
.end method


# virtual methods
.method getNextTransition(II)I
    .registers 7
    .parameter "start"
    .parameter "limit"

    .prologue
    .local p0, this:Landroid/text/SpanSet;,"Landroid/text/SpanSet<TE;>;"
    const/4 v0, 0x0

    .local v0, i:I
    :goto_1
    iget v3, p0, Landroid/text/SpanSet;->numberOfSpans:I

    if-ge v0, v3, :cond_1a

    iget-object v3, p0, Landroid/text/SpanSet;->spanStarts:[I

    aget v2, v3, v0

    .local v2, spanStart:I
    iget-object v3, p0, Landroid/text/SpanSet;->spanEnds:[I

    aget v1, v3, v0

    .local v1, spanEnd:I
    if-le v2, p1, :cond_12

    if-ge v2, p2, :cond_12

    move p2, v2

    :cond_12
    if-le v1, p1, :cond_17

    if-ge v1, p2, :cond_17

    move p2, v1

    :cond_17
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .end local v1           #spanEnd:I
    .end local v2           #spanStart:I
    :cond_1a
    return p2
.end method

.method public hasSpansIntersecting(II)Z
    .registers 5
    .parameter "start"
    .parameter "end"

    .prologue
    .local p0, this:Landroid/text/SpanSet;,"Landroid/text/SpanSet<TE;>;"
    const/4 v0, 0x0

    .local v0, i:I
    :goto_1
    iget v1, p0, Landroid/text/SpanSet;->numberOfSpans:I

    if-ge v0, v1, :cond_16

    iget-object v1, p0, Landroid/text/SpanSet;->spanStarts:[I

    aget v1, v1, v0

    if-ge v1, p2, :cond_11

    iget-object v1, p0, Landroid/text/SpanSet;->spanEnds:[I

    aget v1, v1, v0

    if-gt v1, p1, :cond_14

    :cond_11
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_14
    const/4 v1, 0x1

    :goto_15
    return v1

    :cond_16
    const/4 v1, 0x0

    goto :goto_15
.end method

.method public init(Landroid/text/Spanned;II)V
    .registers 13
    .parameter "spanned"
    .parameter "start"
    .parameter "limit"

    .prologue
    .local p0, this:Landroid/text/SpanSet;,"Landroid/text/SpanSet<TE;>;"
    iget-object v7, p0, Landroid/text/SpanSet;->classType:Ljava/lang/Class;

    invoke-interface {p1, p2, p3, v7}, Landroid/text/Spanned;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v0

    .local v0, allSpans:[Ljava/lang/Object;,"[TE;"
    array-length v2, v0

    .local v2, length:I
    if-lez v2, :cond_2a

    iget-object v7, p0, Landroid/text/SpanSet;->spans:[Ljava/lang/Object;

    if-eqz v7, :cond_12

    iget-object v7, p0, Landroid/text/SpanSet;->spans:[Ljava/lang/Object;

    array-length v7, v7

    if-ge v7, v2, :cond_2a

    :cond_12
    iget-object v7, p0, Landroid/text/SpanSet;->classType:Ljava/lang/Class;

    invoke-static {v7, v2}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, [Ljava/lang/Object;

    check-cast v7, [Ljava/lang/Object;

    iput-object v7, p0, Landroid/text/SpanSet;->spans:[Ljava/lang/Object;

    new-array v7, v2, [I

    iput-object v7, p0, Landroid/text/SpanSet;->spanStarts:[I

    new-array v7, v2, [I

    iput-object v7, p0, Landroid/text/SpanSet;->spanEnds:[I

    new-array v7, v2, [I

    iput-object v7, p0, Landroid/text/SpanSet;->spanFlags:[I

    :cond_2a
    const/4 v7, 0x0

    iput v7, p0, Landroid/text/SpanSet;->numberOfSpans:I

    const/4 v1, 0x0

    .local v1, i:I
    :goto_2e
    if-ge v1, v2, :cond_62

    aget-object v3, v0, v1

    .local v3, span:Ljava/lang/Object;,"TE;"
    invoke-interface {p1, v3}, Landroid/text/Spanned;->getSpanStart(Ljava/lang/Object;)I

    move-result v6

    .local v6, spanStart:I
    invoke-interface {p1, v3}, Landroid/text/Spanned;->getSpanEnd(Ljava/lang/Object;)I

    move-result v4

    .local v4, spanEnd:I
    if-ne v6, v4, :cond_3f

    :goto_3c
    add-int/lit8 v1, v1, 0x1

    goto :goto_2e

    :cond_3f
    invoke-interface {p1, v3}, Landroid/text/Spanned;->getSpanFlags(Ljava/lang/Object;)I

    move-result v5

    .local v5, spanFlag:I
    iget-object v7, p0, Landroid/text/SpanSet;->spans:[Ljava/lang/Object;

    iget v8, p0, Landroid/text/SpanSet;->numberOfSpans:I

    aput-object v3, v7, v8

    iget-object v7, p0, Landroid/text/SpanSet;->spanStarts:[I

    iget v8, p0, Landroid/text/SpanSet;->numberOfSpans:I

    aput v6, v7, v8

    iget-object v7, p0, Landroid/text/SpanSet;->spanEnds:[I

    iget v8, p0, Landroid/text/SpanSet;->numberOfSpans:I

    aput v4, v7, v8

    iget-object v7, p0, Landroid/text/SpanSet;->spanFlags:[I

    iget v8, p0, Landroid/text/SpanSet;->numberOfSpans:I

    aput v5, v7, v8

    iget v7, p0, Landroid/text/SpanSet;->numberOfSpans:I

    add-int/lit8 v7, v7, 0x1

    iput v7, p0, Landroid/text/SpanSet;->numberOfSpans:I

    goto :goto_3c

    .end local v3           #span:Ljava/lang/Object;,"TE;"
    .end local v4           #spanEnd:I
    .end local v5           #spanFlag:I
    .end local v6           #spanStart:I
    :cond_62
    return-void
.end method

.method public recycle()V
    .registers 4

    .prologue
    .local p0, this:Landroid/text/SpanSet;,"Landroid/text/SpanSet<TE;>;"
    const/4 v0, 0x0

    .local v0, i:I
    :goto_1
    iget v1, p0, Landroid/text/SpanSet;->numberOfSpans:I

    if-ge v0, v1, :cond_d

    iget-object v1, p0, Landroid/text/SpanSet;->spans:[Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object v2, v1, v0

    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_d
    return-void
.end method
