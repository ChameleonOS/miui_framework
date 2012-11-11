.class public Lcom/android/internal/util/ArrayUtils;
.super Ljava/lang/Object;
.source "ArrayUtils.java"


# static fields
.field private static final CACHE_SIZE:I = 0x49

.field private static EMPTY:[Ljava/lang/Object;

.field private static sCache:[Ljava/lang/Object;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    sput-object v0, Lcom/android/internal/util/ArrayUtils;->EMPTY:[Ljava/lang/Object;

    const/16 v0, 0x49

    new-array v0, v0, [Ljava/lang/Object;

    sput-object v0, Lcom/android/internal/util/ArrayUtils;->sCache:[Ljava/lang/Object;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static appendElement(Ljava/lang/Class;[Ljava/lang/Object;Ljava/lang/Object;)[Ljava/lang/Object;
    .registers 7
    .parameter
    .parameter
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class",
            "<TT;>;[TT;TT;)[TT;"
        }
    .end annotation

    .prologue
    .local p0, kind:Ljava/lang/Class;,"Ljava/lang/Class<TT;>;"
    .local p1, array:[Ljava/lang/Object;,"[TT;"
    .local p2, element:Ljava/lang/Object;,"TT;"
    const/4 v3, 0x0

    if-eqz p1, :cond_15

    array-length v0, p1

    .local v0, end:I
    add-int/lit8 v2, v0, 0x1

    invoke-static {p0, v2}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Ljava/lang/Object;

    move-object v1, v2

    check-cast v1, [Ljava/lang/Object;

    .local v1, result:[Ljava/lang/Object;,"[TT;"
    invoke-static {p1, v3, v1, v3, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    :goto_12
    aput-object p2, v1, v0

    return-object v1

    .end local v0           #end:I
    .end local v1           #result:[Ljava/lang/Object;,"[TT;"
    :cond_15
    const/4 v0, 0x0

    .restart local v0       #end:I
    const/4 v2, 0x1

    invoke-static {p0, v2}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Ljava/lang/Object;

    move-object v1, v2

    check-cast v1, [Ljava/lang/Object;

    .restart local v1       #result:[Ljava/lang/Object;,"[TT;"
    goto :goto_12
.end method

.method public static appendInt([II)[I
    .registers 7
    .parameter "cur"
    .parameter "val"

    .prologue
    const/4 v4, 0x0

    if-nez p0, :cond_9

    const/4 v3, 0x1

    new-array p0, v3, [I

    .end local p0
    aput p1, p0, v4

    :cond_8
    :goto_8
    return-object p0

    .restart local p0
    :cond_9
    array-length v0, p0

    .local v0, N:I
    const/4 v1, 0x0

    .local v1, i:I
    :goto_b
    if-ge v1, v0, :cond_14

    aget v3, p0, v1

    if-eq v3, p1, :cond_8

    add-int/lit8 v1, v1, 0x1

    goto :goto_b

    :cond_14
    add-int/lit8 v3, v0, 0x1

    new-array v2, v3, [I

    .local v2, ret:[I
    invoke-static {p0, v4, v2, v4, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    aput p1, v2, v0

    move-object p0, v2

    goto :goto_8
.end method

.method public static contains([II)Z
    .registers 7
    .parameter "array"
    .parameter "value"

    .prologue
    move-object v0, p0

    .local v0, arr$:[I
    array-length v3, v0

    .local v3, len$:I
    const/4 v2, 0x0

    .local v2, i$:I
    :goto_3
    if-ge v2, v3, :cond_e

    aget v1, v0, v2

    .local v1, element:I
    if-ne v1, p1, :cond_b

    const/4 v4, 0x1

    .end local v1           #element:I
    :goto_a
    return v4

    .restart local v1       #element:I
    :cond_b
    add-int/lit8 v2, v2, 0x1

    goto :goto_3

    .end local v1           #element:I
    :cond_e
    const/4 v4, 0x0

    goto :goto_a
.end method

.method public static contains([Ljava/lang/Object;Ljava/lang/Object;)Z
    .registers 8
    .parameter
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">([TT;TT;)Z"
        }
    .end annotation

    .prologue
    .local p0, array:[Ljava/lang/Object;,"[TT;"
    .local p1, value:Ljava/lang/Object;,"TT;"
    const/4 v4, 0x1

    move-object v0, p0

    .local v0, arr$:[Ljava/lang/Object;
    array-length v3, v0

    .local v3, len$:I
    const/4 v2, 0x0

    .local v2, i$:I
    :goto_4
    if-ge v2, v3, :cond_18

    aget-object v1, v0, v2

    .local v1, element:Ljava/lang/Object;,"TT;"
    if-nez v1, :cond_d

    if-nez p1, :cond_15

    .end local v1           #element:Ljava/lang/Object;,"TT;"
    :cond_c
    :goto_c
    return v4

    .restart local v1       #element:Ljava/lang/Object;,"TT;"
    :cond_d
    if-eqz p1, :cond_15

    invoke-virtual {v1, p1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_c

    :cond_15
    add-int/lit8 v2, v2, 0x1

    goto :goto_4

    .end local v1           #element:Ljava/lang/Object;,"TT;"
    :cond_18
    const/4 v4, 0x0

    goto :goto_c
.end method

.method public static emptyArray(Ljava/lang/Class;)[Ljava/lang/Object;
    .registers 5
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class",
            "<TT;>;)[TT;"
        }
    .end annotation

    .prologue
    .local p0, kind:Ljava/lang/Class;,"Ljava/lang/Class<TT;>;"
    const-class v2, Ljava/lang/Object;

    if-ne p0, v2, :cond_9

    sget-object v2, Lcom/android/internal/util/ArrayUtils;->EMPTY:[Ljava/lang/Object;

    check-cast v2, [Ljava/lang/Object;

    :goto_8
    return-object v2

    :cond_9
    invoke-static {p0}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v2

    div-int/lit8 v2, v2, 0x8

    const v3, 0x7fffffff

    and-int/2addr v2, v3

    rem-int/lit8 v0, v2, 0x49

    .local v0, bucket:I
    sget-object v2, Lcom/android/internal/util/ArrayUtils;->sCache:[Ljava/lang/Object;

    aget-object v1, v2, v0

    .local v1, cache:Ljava/lang/Object;
    if-eqz v1, :cond_25

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    move-result-object v2

    if-eq v2, p0, :cond_2e

    :cond_25
    const/4 v2, 0x0

    invoke-static {p0, v2}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v1

    sget-object v2, Lcom/android/internal/util/ArrayUtils;->sCache:[Ljava/lang/Object;

    aput-object v1, v2, v0

    :cond_2e
    check-cast v1, [Ljava/lang/Object;

    .end local v1           #cache:Ljava/lang/Object;
    check-cast v1, [Ljava/lang/Object;

    move-object v2, v1

    goto :goto_8
.end method

.method public static equals([B[BI)Z
    .registers 8
    .parameter "array1"
    .parameter "array2"
    .parameter "length"

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    if-ne p0, p1, :cond_5

    :cond_4
    :goto_4
    return v1

    :cond_5
    if-eqz p0, :cond_f

    if-eqz p1, :cond_f

    array-length v3, p0

    if-lt v3, p2, :cond_f

    array-length v3, p1

    if-ge v3, p2, :cond_11

    :cond_f
    move v1, v2

    goto :goto_4

    :cond_11
    const/4 v0, 0x0

    .local v0, i:I
    :goto_12
    if-ge v0, p2, :cond_4

    aget-byte v3, p0, v0

    aget-byte v4, p1, v0

    if-eq v3, v4, :cond_1c

    move v1, v2

    goto :goto_4

    :cond_1c
    add-int/lit8 v0, v0, 0x1

    goto :goto_12
.end method

.method public static idealBooleanArraySize(I)I
    .registers 2
    .parameter "need"

    .prologue
    invoke-static {p0}, Lcom/android/internal/util/ArrayUtils;->idealByteArraySize(I)I

    move-result v0

    return v0
.end method

.method public static idealByteArraySize(I)I
    .registers 4
    .parameter "need"

    .prologue
    const/4 v2, 0x1

    const/4 v0, 0x4

    .local v0, i:I
    :goto_2
    const/16 v1, 0x20

    if-ge v0, v1, :cond_10

    shl-int v1, v2, v0

    add-int/lit8 v1, v1, -0xc

    if-gt p0, v1, :cond_11

    shl-int v1, v2, v0

    add-int/lit8 p0, v1, -0xc

    .end local p0
    :cond_10
    return p0

    .restart local p0
    :cond_11
    add-int/lit8 v0, v0, 0x1

    goto :goto_2
.end method

.method public static idealCharArraySize(I)I
    .registers 2
    .parameter "need"

    .prologue
    mul-int/lit8 v0, p0, 0x2

    invoke-static {v0}, Lcom/android/internal/util/ArrayUtils;->idealByteArraySize(I)I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    return v0
.end method

.method public static idealFloatArraySize(I)I
    .registers 2
    .parameter "need"

    .prologue
    mul-int/lit8 v0, p0, 0x4

    invoke-static {v0}, Lcom/android/internal/util/ArrayUtils;->idealByteArraySize(I)I

    move-result v0

    div-int/lit8 v0, v0, 0x4

    return v0
.end method

.method public static idealIntArraySize(I)I
    .registers 2
    .parameter "need"

    .prologue
    mul-int/lit8 v0, p0, 0x4

    invoke-static {v0}, Lcom/android/internal/util/ArrayUtils;->idealByteArraySize(I)I

    move-result v0

    div-int/lit8 v0, v0, 0x4

    return v0
.end method

.method public static idealLongArraySize(I)I
    .registers 2
    .parameter "need"

    .prologue
    mul-int/lit8 v0, p0, 0x8

    invoke-static {v0}, Lcom/android/internal/util/ArrayUtils;->idealByteArraySize(I)I

    move-result v0

    div-int/lit8 v0, v0, 0x8

    return v0
.end method

.method public static idealObjectArraySize(I)I
    .registers 2
    .parameter "need"

    .prologue
    mul-int/lit8 v0, p0, 0x4

    invoke-static {v0}, Lcom/android/internal/util/ArrayUtils;->idealByteArraySize(I)I

    move-result v0

    div-int/lit8 v0, v0, 0x4

    return v0
.end method

.method public static idealShortArraySize(I)I
    .registers 2
    .parameter "need"

    .prologue
    mul-int/lit8 v0, p0, 0x2

    invoke-static {v0}, Lcom/android/internal/util/ArrayUtils;->idealByteArraySize(I)I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    return v0
.end method

.method public static removeElement(Ljava/lang/Class;[Ljava/lang/Object;Ljava/lang/Object;)[Ljava/lang/Object;
    .registers 8
    .parameter
    .parameter
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class",
            "<TT;>;[TT;TT;)[TT;"
        }
    .end annotation

    .prologue
    .local p0, kind:Ljava/lang/Class;,"Ljava/lang/Class<TT;>;"
    .local p1, array:[Ljava/lang/Object;,"[TT;"
    .local p2, element:Ljava/lang/Object;,"TT;"
    const/4 v4, 0x0

    if-eqz p1, :cond_2b

    array-length v1, p1

    .local v1, length:I
    const/4 v0, 0x0

    .local v0, i:I
    :goto_5
    if-ge v0, v1, :cond_2b

    aget-object v3, p1, v0

    if-ne v3, p2, :cond_28

    const/4 v3, 0x1

    if-ne v1, v3, :cond_10

    const/4 v2, 0x0

    .end local v0           #i:I
    .end local v1           #length:I
    :goto_f
    return-object v2

    .restart local v0       #i:I
    .restart local v1       #length:I
    :cond_10
    add-int/lit8 v3, v1, -0x1

    invoke-static {p0, v3}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, [Ljava/lang/Object;

    move-object v2, v3

    check-cast v2, [Ljava/lang/Object;

    .local v2, result:[Ljava/lang/Object;,"[TT;"
    invoke-static {p1, v4, v2, v4, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    add-int/lit8 v3, v0, 0x1

    sub-int v4, v1, v0

    add-int/lit8 v4, v4, -0x1

    invoke-static {p1, v3, v2, v0, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    goto :goto_f

    .end local v2           #result:[Ljava/lang/Object;,"[TT;"
    :cond_28
    add-int/lit8 v0, v0, 0x1

    goto :goto_5

    .end local v0           #i:I
    .end local v1           #length:I
    :cond_2b
    move-object v2, p1

    goto :goto_f
.end method

.method public static removeInt([II)[I
    .registers 7
    .parameter "cur"
    .parameter "val"

    .prologue
    const/4 v4, 0x0

    if-nez p0, :cond_5

    const/4 v2, 0x0

    :cond_4
    :goto_4
    return-object v2

    :cond_5
    array-length v0, p0

    .local v0, N:I
    const/4 v1, 0x0

    .local v1, i:I
    :goto_7
    if-ge v1, v0, :cond_27

    aget v3, p0, v1

    if-ne v3, p1, :cond_24

    add-int/lit8 v3, v0, -0x1

    new-array v2, v3, [I

    .local v2, ret:[I
    if-lez v1, :cond_16

    invoke-static {p0, v4, v2, v4, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    :cond_16
    add-int/lit8 v3, v0, -0x1

    if-ge v1, v3, :cond_4

    add-int/lit8 v3, v1, 0x1

    sub-int v4, v0, v1

    add-int/lit8 v4, v4, -0x1

    invoke-static {p0, v3, v2, v1, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    goto :goto_4

    .end local v2           #ret:[I
    :cond_24
    add-int/lit8 v1, v1, 0x1

    goto :goto_7

    :cond_27
    move-object v2, p0

    goto :goto_4
.end method

.method public static total([J)J
    .registers 8
    .parameter "array"

    .prologue
    const-wide/16 v3, 0x0

    .local v3, total:J
    move-object v0, p0

    .local v0, arr$:[J
    array-length v2, v0

    .local v2, len$:I
    const/4 v1, 0x0

    .local v1, i$:I
    :goto_5
    if-ge v1, v2, :cond_d

    aget-wide v5, v0, v1

    .local v5, value:J
    add-long/2addr v3, v5

    add-int/lit8 v1, v1, 0x1

    goto :goto_5

    .end local v5           #value:J
    :cond_d
    return-wide v3
.end method
