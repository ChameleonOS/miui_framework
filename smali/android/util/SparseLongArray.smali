.class public Landroid/util/SparseLongArray;
.super Ljava/lang/Object;
.source "SparseLongArray.java"

# interfaces
.implements Ljava/lang/Cloneable;


# instance fields
.field private mKeys:[I

.field private mSize:I

.field private mValues:[J


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    const/16 v0, 0xa

    invoke-direct {p0, v0}, Landroid/util/SparseLongArray;-><init>(I)V

    return-void
.end method

.method public constructor <init>(I)V
    .registers 3
    .parameter "initialCapacity"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    invoke-static {p1}, Lcom/android/internal/util/ArrayUtils;->idealLongArraySize(I)I

    move-result p1

    new-array v0, p1, [I

    iput-object v0, p0, Landroid/util/SparseLongArray;->mKeys:[I

    new-array v0, p1, [J

    iput-object v0, p0, Landroid/util/SparseLongArray;->mValues:[J

    const/4 v0, 0x0

    iput v0, p0, Landroid/util/SparseLongArray;->mSize:I

    return-void
.end method

.method private static binarySearch([IIIJ)I
    .registers 10
    .parameter "a"
    .parameter "start"
    .parameter "len"
    .parameter "key"

    .prologue
    add-int v1, p1, p2

    .local v1, high:I
    add-int/lit8 v2, p1, -0x1

    .local v2, low:I
    :goto_4
    sub-int v3, v1, v2

    const/4 v4, 0x1

    if-le v3, v4, :cond_18

    add-int v3, v1, v2

    div-int/lit8 v0, v3, 0x2

    .local v0, guess:I
    aget v3, p0, v0

    int-to-long v3, v3

    cmp-long v3, v3, p3

    if-gez v3, :cond_16

    move v2, v0

    goto :goto_4

    :cond_16
    move v1, v0

    goto :goto_4

    .end local v0           #guess:I
    :cond_18
    add-int v3, p1, p2

    if-ne v1, v3, :cond_21

    add-int v3, p1, p2

    xor-int/lit8 v1, v3, -0x1

    .end local v1           #high:I
    :cond_20
    :goto_20
    return v1

    .restart local v1       #high:I
    :cond_21
    aget v3, p0, v1

    int-to-long v3, v3

    cmp-long v3, v3, p3

    if-eqz v3, :cond_20

    xor-int/lit8 v1, v1, -0x1

    goto :goto_20
.end method

.method private growKeyAndValueArrays(I)V
    .registers 8
    .parameter "minNeededSize"

    .prologue
    const/4 v5, 0x0

    invoke-static {p1}, Lcom/android/internal/util/ArrayUtils;->idealLongArraySize(I)I

    move-result v0

    .local v0, n:I
    new-array v1, v0, [I

    .local v1, nkeys:[I
    new-array v2, v0, [J

    .local v2, nvalues:[J
    iget-object v3, p0, Landroid/util/SparseLongArray;->mKeys:[I

    iget-object v4, p0, Landroid/util/SparseLongArray;->mKeys:[I

    array-length v4, v4

    invoke-static {v3, v5, v1, v5, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    iget-object v3, p0, Landroid/util/SparseLongArray;->mValues:[J

    iget-object v4, p0, Landroid/util/SparseLongArray;->mValues:[J

    array-length v4, v4

    invoke-static {v3, v5, v2, v5, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    iput-object v1, p0, Landroid/util/SparseLongArray;->mKeys:[I

    iput-object v2, p0, Landroid/util/SparseLongArray;->mValues:[J

    return-void
.end method


# virtual methods
.method public append(IJ)V
    .registers 7
    .parameter "key"
    .parameter "value"

    .prologue
    iget v1, p0, Landroid/util/SparseLongArray;->mSize:I

    if-eqz v1, :cond_12

    iget-object v1, p0, Landroid/util/SparseLongArray;->mKeys:[I

    iget v2, p0, Landroid/util/SparseLongArray;->mSize:I

    add-int/lit8 v2, v2, -0x1

    aget v1, v1, v2

    if-gt p1, v1, :cond_12

    invoke-virtual {p0, p1, p2, p3}, Landroid/util/SparseLongArray;->put(IJ)V

    :goto_11
    return-void

    :cond_12
    iget v0, p0, Landroid/util/SparseLongArray;->mSize:I

    .local v0, pos:I
    iget-object v1, p0, Landroid/util/SparseLongArray;->mKeys:[I

    array-length v1, v1

    if-lt v0, v1, :cond_1e

    add-int/lit8 v1, v0, 0x1

    invoke-direct {p0, v1}, Landroid/util/SparseLongArray;->growKeyAndValueArrays(I)V

    :cond_1e
    iget-object v1, p0, Landroid/util/SparseLongArray;->mKeys:[I

    aput p1, v1, v0

    iget-object v1, p0, Landroid/util/SparseLongArray;->mValues:[J

    aput-wide p2, v1, v0

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Landroid/util/SparseLongArray;->mSize:I

    goto :goto_11
.end method

.method public clear()V
    .registers 2

    .prologue
    const/4 v0, 0x0

    iput v0, p0, Landroid/util/SparseLongArray;->mSize:I

    return-void
.end method

.method public clone()Landroid/util/SparseLongArray;
    .registers 4

    .prologue
    const/4 v1, 0x0

    .local v1, clone:Landroid/util/SparseLongArray;
    :try_start_1
    invoke-super {p0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v2

    move-object v0, v2

    check-cast v0, Landroid/util/SparseLongArray;

    move-object v1, v0

    iget-object v2, p0, Landroid/util/SparseLongArray;->mKeys:[I

    invoke-virtual {v2}, [I->clone()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [I

    iput-object v2, v1, Landroid/util/SparseLongArray;->mKeys:[I

    iget-object v2, p0, Landroid/util/SparseLongArray;->mValues:[J

    invoke-virtual {v2}, [J->clone()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [J

    iput-object v2, v1, Landroid/util/SparseLongArray;->mValues:[J
    :try_end_1d
    .catch Ljava/lang/CloneNotSupportedException; {:try_start_1 .. :try_end_1d} :catch_1e

    :goto_1d
    return-object v1

    :catch_1e
    move-exception v2

    goto :goto_1d
.end method

.method public bridge synthetic clone()Ljava/lang/Object;
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    invoke-virtual {p0}, Landroid/util/SparseLongArray;->clone()Landroid/util/SparseLongArray;

    move-result-object v0

    return-object v0
.end method

.method public delete(I)V
    .registers 8
    .parameter "key"

    .prologue
    iget-object v1, p0, Landroid/util/SparseLongArray;->mKeys:[I

    const/4 v2, 0x0

    iget v3, p0, Landroid/util/SparseLongArray;->mSize:I

    int-to-long v4, p1

    invoke-static {v1, v2, v3, v4, v5}, Landroid/util/SparseLongArray;->binarySearch([IIIJ)I

    move-result v0

    .local v0, i:I
    if-ltz v0, :cond_f

    invoke-virtual {p0, v0}, Landroid/util/SparseLongArray;->removeAt(I)V

    :cond_f
    return-void
.end method

.method public get(I)J
    .registers 4
    .parameter "key"

    .prologue
    const-wide/16 v0, 0x0

    invoke-virtual {p0, p1, v0, v1}, Landroid/util/SparseLongArray;->get(IJ)J

    move-result-wide v0

    return-wide v0
.end method

.method public get(IJ)J
    .registers 10
    .parameter "key"
    .parameter "valueIfKeyNotFound"

    .prologue
    iget-object v1, p0, Landroid/util/SparseLongArray;->mKeys:[I

    const/4 v2, 0x0

    iget v3, p0, Landroid/util/SparseLongArray;->mSize:I

    int-to-long v4, p1

    invoke-static {v1, v2, v3, v4, v5}, Landroid/util/SparseLongArray;->binarySearch([IIIJ)I

    move-result v0

    .local v0, i:I
    if-gez v0, :cond_d

    .end local p2
    :goto_c
    return-wide p2

    .restart local p2
    :cond_d
    iget-object v1, p0, Landroid/util/SparseLongArray;->mValues:[J

    aget-wide p2, v1, v0

    goto :goto_c
.end method

.method public indexOfKey(I)I
    .registers 7
    .parameter "key"

    .prologue
    iget-object v0, p0, Landroid/util/SparseLongArray;->mKeys:[I

    const/4 v1, 0x0

    iget v2, p0, Landroid/util/SparseLongArray;->mSize:I

    int-to-long v3, p1

    invoke-static {v0, v1, v2, v3, v4}, Landroid/util/SparseLongArray;->binarySearch([IIIJ)I

    move-result v0

    return v0
.end method

.method public indexOfValue(J)I
    .registers 6
    .parameter "value"

    .prologue
    const/4 v0, 0x0

    .local v0, i:I
    :goto_1
    iget v1, p0, Landroid/util/SparseLongArray;->mSize:I

    if-ge v0, v1, :cond_11

    iget-object v1, p0, Landroid/util/SparseLongArray;->mValues:[J

    aget-wide v1, v1, v0

    cmp-long v1, v1, p1

    if-nez v1, :cond_e

    .end local v0           #i:I
    :goto_d
    return v0

    .restart local v0       #i:I
    :cond_e
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_11
    const/4 v0, -0x1

    goto :goto_d
.end method

.method public keyAt(I)I
    .registers 3
    .parameter "index"

    .prologue
    iget-object v0, p0, Landroid/util/SparseLongArray;->mKeys:[I

    aget v0, v0, p1

    return v0
.end method

.method public put(IJ)V
    .registers 10
    .parameter "key"
    .parameter "value"

    .prologue
    iget-object v1, p0, Landroid/util/SparseLongArray;->mKeys:[I

    const/4 v2, 0x0

    iget v3, p0, Landroid/util/SparseLongArray;->mSize:I

    int-to-long v4, p1

    invoke-static {v1, v2, v3, v4, v5}, Landroid/util/SparseLongArray;->binarySearch([IIIJ)I

    move-result v0

    .local v0, i:I
    if-ltz v0, :cond_11

    iget-object v1, p0, Landroid/util/SparseLongArray;->mValues:[J

    aput-wide p2, v1, v0

    :goto_10
    return-void

    :cond_11
    xor-int/lit8 v0, v0, -0x1

    iget v1, p0, Landroid/util/SparseLongArray;->mSize:I

    iget-object v2, p0, Landroid/util/SparseLongArray;->mKeys:[I

    array-length v2, v2

    if-lt v1, v2, :cond_21

    iget v1, p0, Landroid/util/SparseLongArray;->mSize:I

    add-int/lit8 v1, v1, 0x1

    invoke-direct {p0, v1}, Landroid/util/SparseLongArray;->growKeyAndValueArrays(I)V

    :cond_21
    iget v1, p0, Landroid/util/SparseLongArray;->mSize:I

    sub-int/2addr v1, v0

    if-eqz v1, :cond_3e

    iget-object v1, p0, Landroid/util/SparseLongArray;->mKeys:[I

    iget-object v2, p0, Landroid/util/SparseLongArray;->mKeys:[I

    add-int/lit8 v3, v0, 0x1

    iget v4, p0, Landroid/util/SparseLongArray;->mSize:I

    sub-int/2addr v4, v0

    invoke-static {v1, v0, v2, v3, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    iget-object v1, p0, Landroid/util/SparseLongArray;->mValues:[J

    iget-object v2, p0, Landroid/util/SparseLongArray;->mValues:[J

    add-int/lit8 v3, v0, 0x1

    iget v4, p0, Landroid/util/SparseLongArray;->mSize:I

    sub-int/2addr v4, v0

    invoke-static {v1, v0, v2, v3, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    :cond_3e
    iget-object v1, p0, Landroid/util/SparseLongArray;->mKeys:[I

    aput p1, v1, v0

    iget-object v1, p0, Landroid/util/SparseLongArray;->mValues:[J

    aput-wide p2, v1, v0

    iget v1, p0, Landroid/util/SparseLongArray;->mSize:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Landroid/util/SparseLongArray;->mSize:I

    goto :goto_10
.end method

.method public removeAt(I)V
    .registers 7
    .parameter "index"

    .prologue
    iget-object v0, p0, Landroid/util/SparseLongArray;->mKeys:[I

    add-int/lit8 v1, p1, 0x1

    iget-object v2, p0, Landroid/util/SparseLongArray;->mKeys:[I

    iget v3, p0, Landroid/util/SparseLongArray;->mSize:I

    add-int/lit8 v4, p1, 0x1

    sub-int/2addr v3, v4

    invoke-static {v0, v1, v2, p1, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    iget-object v0, p0, Landroid/util/SparseLongArray;->mValues:[J

    add-int/lit8 v1, p1, 0x1

    iget-object v2, p0, Landroid/util/SparseLongArray;->mValues:[J

    iget v3, p0, Landroid/util/SparseLongArray;->mSize:I

    add-int/lit8 v4, p1, 0x1

    sub-int/2addr v3, v4

    invoke-static {v0, v1, v2, p1, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    iget v0, p0, Landroid/util/SparseLongArray;->mSize:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Landroid/util/SparseLongArray;->mSize:I

    return-void
.end method

.method public size()I
    .registers 2

    .prologue
    iget v0, p0, Landroid/util/SparseLongArray;->mSize:I

    return v0
.end method

.method public valueAt(I)J
    .registers 4
    .parameter "index"

    .prologue
    iget-object v0, p0, Landroid/util/SparseLongArray;->mValues:[J

    aget-wide v0, v0, p1

    return-wide v0
.end method
