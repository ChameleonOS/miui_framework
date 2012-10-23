.class final Landroid/text/util/Linkify$4;
.super Ljava/lang/Object;
.source "Linkify.java"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/text/util/Linkify;->pruneOverlaps(Ljava/util/ArrayList;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Landroid/text/util/Linkify$LinkSpec;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 502
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final compare(Landroid/text/util/Linkify$LinkSpec;Landroid/text/util/Linkify$LinkSpec;)I
    .registers 7
    .parameter "a"
    .parameter "b"

    .prologue
    const/4 v1, 0x1

    const/4 v0, -0x1

    .line 504
    iget v2, p1, Landroid/text/util/Linkify$LinkSpec;->start:I

    iget v3, p2, Landroid/text/util/Linkify$LinkSpec;->start:I

    if-ge v2, v3, :cond_9

    .line 520
    :cond_8
    :goto_8
    return v0

    .line 508
    :cond_9
    iget v2, p1, Landroid/text/util/Linkify$LinkSpec;->start:I

    iget v3, p2, Landroid/text/util/Linkify$LinkSpec;->start:I

    if-le v2, v3, :cond_11

    move v0, v1

    .line 509
    goto :goto_8

    .line 512
    :cond_11
    iget v2, p1, Landroid/text/util/Linkify$LinkSpec;->end:I

    iget v3, p2, Landroid/text/util/Linkify$LinkSpec;->end:I

    if-ge v2, v3, :cond_19

    move v0, v1

    .line 513
    goto :goto_8

    .line 516
    :cond_19
    iget v1, p1, Landroid/text/util/Linkify$LinkSpec;->end:I

    iget v2, p2, Landroid/text/util/Linkify$LinkSpec;->end:I

    if-gt v1, v2, :cond_8

    .line 520
    const/4 v0, 0x0

    goto :goto_8
.end method

.method public bridge synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .registers 4
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 502
    check-cast p1, Landroid/text/util/Linkify$LinkSpec;

    .end local p1
    check-cast p2, Landroid/text/util/Linkify$LinkSpec;

    .end local p2
    invoke-virtual {p0, p1, p2}, Landroid/text/util/Linkify$4;->compare(Landroid/text/util/Linkify$LinkSpec;Landroid/text/util/Linkify$LinkSpec;)I

    move-result v0

    return v0
.end method

.method public final equals(Ljava/lang/Object;)Z
    .registers 3
    .parameter "o"

    .prologue
    .line 524
    const/4 v0, 0x0

    return v0
.end method
