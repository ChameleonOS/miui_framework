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
    .line 38
    const/16 v0, 0xa

    invoke-direct {p0, v0}, Landroid/util/SparseLongArray;-><init>(I)V

    .line 39
    return-void
.end method

.method public constructor <init>(I)V
    .registers 3
    .parameter "initialCapacity"

    .prologue
    .line 46
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 47
    invoke-static {p1}, Lcom/android/internal/util/ArrayUtils;->idealLongArraySize(I)I

    move-result p1

    .line 49
    new-array v0, p1, [I

    iput-object v0, p0, Landroid/util/SparseLongArray;->mKeys:[I

    .line 50
    new-array v0, p1, [J

    iput-object v0, p0, Landroid/util/SparseLongArray;->mValues:[J

    .line 51
    const/4 v0, 0x0

    iput v0, p0, Landroid/util/SparseLongArray;->mSize:I

    .line 52
    return-void
.end method

.method private static binarySearch([IIIJ)I
    .registers 10
    .parameter "a"
    .parameter "start"
    .parameter "len"
    .parameter "key"

    .prologue
    .line 229
    add-int v1, p1, p2

    .local v1, high:I
    add-int/lit8 v2, p1, -0x1

    .line 231
    .local v2, low:I
    :goto_4
    sub-int v3, v1, v2

    const/4 v4, 0x1

    if-le v3, v4, :cond_18

    .line 232
    add-int v3, v1, v2

    div-int/lit8 v0, v3, 0x2

    .line 234
    .local v0, guess:I
    aget v3, p0, v0

    int-to-long v3, v3

    cmp-long v3, v3, p3

    if-gez v3, :cond_16

    .line 235
    move v2, v0

    goto :goto_4

    .line 237
    :cond_16
    move v1, v0

    goto :goto_4

    .line 240
    .end local v0           #guess:I
    :cond_18
    add-int v3, p1, p2

    if-ne v1, v3, :cond_21

    .line 241
    add-int v3, p1, p2

    xor-int/lit8 v1, v3, -0x1

    .line 245
    .end local v1           #high:I
    :cond_20
    :goto_20
    return v1

    .line 242
    .restart local v1       #high:I
    :cond_21
    aget v3, p0, v1

    int-to-long v3, v3

    cmp-long v3, v3, p3

    if-eqz v3, :cond_20

    .line 245
    xor-int/lit8 v1, v1, -0x1

    goto :goto_20
.end method

.method private growKeyAndValueArrays(I)V
    .registers 8
    .parameter "minNeededSize"

    .prologue
    const/4 v5, 0x0

    .line 216
    invoke-static {p1}, Lcom/android/internal/util/ArrayUtils;->idealLongArraySize(I)I

    move-result v0

    .line 218
    .local v0, n:I
    new-array v1, v0, [I

    .line 219
    .local v1, nkeys:[I
    new-array v2, v0, [J

    .line 221
    .local v2, nvalues:[J
    iget-object v3, p0, Landroid/util/SparseLongArray;->mKeys:[I

    iget-object v4, p0, Landroid/util/SparseLongArray;->mKeys:[I

    array-length v4, v4

    invoke-static {v3, v5, v1, v5, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 222
    iget-object v3, p0, Landroid/util/SparseLongArray;->mValues:[J

    iget-object v4, p0, Landroid/util/SparseLongArray;->mValues:[J

    array-length v4, v4

    invoke-static {v3, v5, v2, v5, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 224
    iput-object v1, p0, Landroid/util/SparseLongArray;->mKeys:[I

    .line 225
    iput-object v2, p0, Landroid/util/SparseLongArray;->mValues:[J

    .line 226
    return-void
.end method


# virtual methods
.method public append(IJ)V
    .registers 7
    .parameter "key"
    .parameter "value"

    .prologue
    .line 200
    iget v1, p0, Landroid/util/SparseLongArray;->mSize:I

    if-eqz v1, :cond_12

    iget-object v1, p0, Landroid/util/SparseLongArray;->mKeys:[I

    iget v2, p0, Landroid/util/SparseLongArray;->mSize:I

    add-int/lit8 v2, v2, -0x1

    aget v1, v1, v2

    if-gt p1, v1, :cond_12

    .line 201
    invoke-virtual {p0, p1, p2, p3}, Landroid/util/SparseLongArray;->put(IJ)V

    .line 213
    :goto_11
    return-void

    .line 205
    :cond_12
    iget v0, p0, Landroid/util/SparseLongArray;->mSize:I

    .line 206
    .local v0, pos:I
    iget-object v1, p0, Landroid/util/SparseLongArray;->mKeys:[I

    array-length v1, v1

    if-lt v0, v1, :cond_1e

    .line 207
    add-int/lit8 v1, v0, 0x1

    invoke-direct {p0, v1}, Landroid/util/SparseLongArray;->growKeyAndValueArrays(I)V

    .line 210
    :cond_1e
    iget-object v1, p0, Landroid/util/SparseLongArray;->mKeys:[I

    aput p1, v1, v0

    .line 211
    iget-object v1, p0, Landroid/util/SparseLongArray;->mValues:[J

    aput-wide p2, v1, v0

    .line 212
    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Landroid/util/SparseLongArray;->mSize:I

    goto :goto_11
.end method

.method public clear()V
    .registers 2

    .prologue
    .line 192
    const/4 v0, 0x0

    iput v0, p0, Landroid/util/SparseLongArray;->mSize:I

    .line 193
    return-void
.end method

.method public clone()Landroid/util/SparseLongArray;
    .registers 4

    .prologue
    .line 56
    const/4 v1, 0x0

    .line 58
    .local v1, clone:Landroid/util/SparseLongArray;
    :try_start_1
    invoke-super {p0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    move-result-object v2

    move-object v0, v2

    check-cast v0, Landroid/util/SparseLongArray;

    move-object v1, v0

    .line 59
    iget-object v2, p0, Landroid/util/SparseLongArray;->mKeys:[I

    invoke-virtual {v2}, [I->clone()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [I

    iput-object v2, v1, Landroid/util/SparseLongArray;->mKeys:[I

    .line 60
    iget-object v2, p0, Landroid/util/SparseLongArray;->mValues:[J

    invoke-virtual {v2}, [J->clone()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [J

    iput-object v2, v1, Landroid/util/SparseLongArray;->mValues:[J
    :try_end_1d
    .catch Ljava/lang/CloneNotSupportedException; {:try_start_1 .. :try_end_1d} :catch_1e

    .line 64
    :goto_1d
    return-object v1

    .line 61
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
    .line 28
    invoke-virtual {p0}, Landroid/util/SparseLongArray;->clone()Landroid/util/SparseLongArray;

    move-result-object v0

    return-object v0
.end method

.method public delete(I)V
    .registers 8
    .parameter "key"

    .prologue
    .line 93
    iget-object v1, p0, Landroid/util/SparseLongArray;->mKeys:[I

    const/4 v2, 0x0

    iget v3, p0, Landroid/util/SparseLongArray;->mSize:I

    int-to-long v4, p1

    invoke-static {v1, v2, v3, v4, v5}, Landroid/util/SparseLongArray;->binarySearch([IIIJ)I

    move-result v0

    .line 95
    .local v0, i:I
    if-ltz v0, :cond_f

    .line 96
    invoke-virtual {p0, v0}, Landroid/util/SparseLongArray;->removeAt(I)V

    .line 98
    :cond_f
    return-void
.end method

.method public get(I)J
    .registers 4
    .parameter "key"

    .prologue
    .line 72
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
    .line 80
    iget-object v1, p0, Landroid/util/SparseLongArray;->mKeys:[I

    const/4 v2, 0x0

    iget v3, p0, Landroid/util/SparseLongArray;->mSize:I

    int-to-long v4, p1

    invoke-static {v1, v2, v3, v4, v5}, Landroid/util/SparseLongArray;->binarySearch([IIIJ)I

    move-result v0

    .line 82
    .local v0, i:I
    if-gez v0, :cond_d

    .line 85
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
    .line 169
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
    .line 181
    const/4 v0, 0x0

    .local v0, i:I
    :goto_1
    iget v1, p0, Landroid/util/SparseLongArray;->mSize:I

    if-ge v0, v1, :cond_11

    .line 182
    iget-object v1, p0, Landroid/util/SparseLongArray;->mValues:[J

    aget-wide v1, v1, v0

    cmp-long v1, v1, p1

    if-nez v1, :cond_e

    .line 185
    .end local v0           #i:I
    :goto_d
    return v0

    .line 181
    .restart local v0       #i:I
    :cond_e
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 185
    :cond_11
    const/4 v0, -0x1

    goto :goto_d
.end method

.method public keyAt(I)I
    .registers 3
    .parameter "index"

    .prologue
    .line 151
    iget-object v0, p0, Landroid/util/SparseLongArray;->mKeys:[I

    aget v0, v0, p1

    return v0
.end method

.method public put(IJ)V
    .registers 10
    .parameter "key"
    .parameter "value"

    .prologue
    .line 115
    iget-object v1, p0, Landroid/util/SparseLongArray;->mKeys:[I

    const/4 v2, 0x0

    iget v3, p0, Landroid/util/SparseLongArray;->mSize:I

    int-to-long v4, p1

    invoke-static {v1, v2, v3, v4, v5}, Landroid/util/SparseLongArray;->binarySearch([IIIJ)I

    move-result v0

    .line 117
    .local v0, i:I
    if-ltz v0, :cond_11

    .line 118
    iget-object v1, p0, Landroid/util/SparseLongArray;->mValues:[J

    aput-wide p2, v1, v0

    .line 135
    :goto_10
    return-void

    .line 120
    :cond_11
    xor-int/lit8 v0, v0, -0x1

    .line 122
    iget v1, p0, Landroid/util/SparseLongArray;->mSize:I

    iget-object v2, p0, Landroid/util/SparseLongArray;->mKeys:[I

    array-length v2, v2

    if-lt v1, v2, :cond_21

    .line 123
    iget v1, p0, Landroid/util/SparseLongArray;->mSize:I

    add-int/lit8 v1, v1, 0x1

    invoke-direct {p0, v1}, Landroid/util/SparseLongArray;->growKeyAndValueArrays(I)V

    .line 126
    :cond_21
    iget v1, p0, Landroid/util/SparseLongArray;->mSize:I

    sub-int/2addr v1, v0

    if-eqz v1, :cond_3e

    .line 127
    iget-object v1, p0, Landroid/util/SparseLongArray;->mKeys:[I

    iget-object v2, p0, Landroid/util/SparseLongArray;->mKeys:[I

    add-int/lit8 v3, v0, 0x1

    iget v4, p0, Landroid/util/SparseLongArray;->mSize:I

    sub-int/2addr v4, v0

    invoke-static {v1, v0, v2, v3, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 128
    iget-object v1, p0, Landroid/util/SparseLongArray;->mValues:[J

    iget-object v2, p0, Landroid/util/SparseLongArray;->mValues:[J

    add-int/lit8 v3, v0, 0x1

    iget v4, p0, Landroid/util/SparseLongArray;->mSize:I

    sub-int/2addr v4, v0

    invoke-static {v1, v0, v2, v3, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 131
    :cond_3e
    iget-object v1, p0, Landroid/util/SparseLongArray;->mKeys:[I

    aput p1, v1, v0

    .line 132
    iget-object v1, p0, Landroid/util/SparseLongArray;->mValues:[J

    aput-wide p2, v1, v0

    .line 133
    iget v1, p0, Landroid/util/SparseLongArray;->mSize:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Landroid/util/SparseLongArray;->mSize:I

    goto :goto_10
.end method

.method public removeAt(I)V
    .registers 7
    .parameter "index"

    .prologue
    .line 104
    iget-object v0, p0, Landroid/util/SparseLongArray;->mKeys:[I

    add-int/lit8 v1, p1, 0x1

    iget-object v2, p0, Landroid/util/SparseLongArray;->mKeys:[I

    iget v3, p0, Landroid/util/SparseLongArray;->mSize:I

    add-int/lit8 v4, p1, 0x1

    sub-int/2addr v3, v4

    invoke-static {v0, v1, v2, p1, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 105
    iget-object v0, p0, Landroid/util/SparseLongArray;->mValues:[J

    add-int/lit8 v1, p1, 0x1

    iget-object v2, p0, Landroid/util/SparseLongArray;->mValues:[J

    iget v3, p0, Landroid/util/SparseLongArray;->mSize:I

    add-int/lit8 v4, p1, 0x1

    sub-int/2addr v3, v4

    invoke-static {v0, v1, v2, p1, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 106
    iget v0, p0, Landroid/util/SparseLongArray;->mSize:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Landroid/util/SparseLongArray;->mSize:I

    .line 107
    return-void
.end method

.method public size()I
    .registers 2

    .prologue
    .line 142
    iget v0, p0, Landroid/util/SparseLongArray;->mSize:I

    return v0
.end method

.method public valueAt(I)J
    .registers 4
    .parameter "index"

    .prologue
    .line 160
    iget-object v0, p0, Landroid/util/SparseLongArray;->mValues:[J

    aget-wide v0, v0, p1

    return-wide v0
.end method
