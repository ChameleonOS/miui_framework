.class final Landroid/widget/GridLayout$Interval;
.super Ljava/lang/Object;
.source "GridLayout.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/GridLayout;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "Interval"
.end annotation


# instance fields
.field public final max:I

.field public final min:I


# direct methods
.method public constructor <init>(II)V
    .registers 3
    .parameter "min"
    .parameter "max"

    .prologue
    .line 2266
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 2267
    iput p1, p0, Landroid/widget/GridLayout$Interval;->min:I

    .line 2268
    iput p2, p0, Landroid/widget/GridLayout$Interval;->max:I

    .line 2269
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .registers 7
    .parameter "that"

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 2291
    if-ne p0, p1, :cond_5

    .line 2308
    :cond_4
    :goto_4
    return v1

    .line 2294
    :cond_5
    if-eqz p1, :cond_11

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_13

    :cond_11
    move v1, v2

    .line 2295
    goto :goto_4

    :cond_13
    move-object v0, p1

    .line 2298
    check-cast v0, Landroid/widget/GridLayout$Interval;

    .line 2300
    .local v0, interval:Landroid/widget/GridLayout$Interval;
    iget v3, p0, Landroid/widget/GridLayout$Interval;->max:I

    iget v4, v0, Landroid/widget/GridLayout$Interval;->max:I

    if-eq v3, v4, :cond_1e

    move v1, v2

    .line 2301
    goto :goto_4

    .line 2304
    :cond_1e
    iget v3, p0, Landroid/widget/GridLayout$Interval;->min:I

    iget v4, v0, Landroid/widget/GridLayout$Interval;->min:I

    if-eq v3, v4, :cond_4

    move v1, v2

    .line 2305
    goto :goto_4
.end method

.method public hashCode()I
    .registers 4

    .prologue
    .line 2313
    iget v0, p0, Landroid/widget/GridLayout$Interval;->min:I

    .line 2314
    .local v0, result:I
    mul-int/lit8 v1, v0, 0x1f

    iget v2, p0, Landroid/widget/GridLayout$Interval;->max:I

    add-int v0, v1, v2

    .line 2315
    return v0
.end method

.method inverse()Landroid/widget/GridLayout$Interval;
    .registers 4

    .prologue
    .line 2276
    new-instance v0, Landroid/widget/GridLayout$Interval;

    iget v1, p0, Landroid/widget/GridLayout$Interval;->max:I

    iget v2, p0, Landroid/widget/GridLayout$Interval;->min:I

    invoke-direct {v0, v1, v2}, Landroid/widget/GridLayout$Interval;-><init>(II)V

    return-object v0
.end method

.method size()I
    .registers 3

    .prologue
    .line 2272
    iget v0, p0, Landroid/widget/GridLayout$Interval;->max:I

    iget v1, p0, Landroid/widget/GridLayout$Interval;->min:I

    sub-int/2addr v0, v1

    return v0
.end method

.method public toString()Ljava/lang/String;
    .registers 3

    .prologue
    .line 2320
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "["

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Landroid/widget/GridLayout$Interval;->min:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Landroid/widget/GridLayout$Interval;->max:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
