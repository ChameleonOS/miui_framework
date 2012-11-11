.class public Landroid/net/nsd/DnsSdTxtRecord;
.super Ljava/lang/Object;
.source "DnsSdTxtRecord.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator; = null
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Landroid/net/nsd/DnsSdTxtRecord;",
            ">;"
        }
    .end annotation
.end field

.field private static final mSeperator:B = 0x3dt


# instance fields
.field private mData:[B


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    new-instance v0, Landroid/net/nsd/DnsSdTxtRecord$1;

    invoke-direct {v0}, Landroid/net/nsd/DnsSdTxtRecord$1;-><init>()V

    sput-object v0, Landroid/net/nsd/DnsSdTxtRecord;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .registers 2

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    new-array v0, v0, [B

    iput-object v0, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    return-void
.end method

.method public constructor <init>(Landroid/net/nsd/DnsSdTxtRecord;)V
    .registers 3
    .parameter "src"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    if-eqz p1, :cond_15

    iget-object v0, p1, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    if-eqz v0, :cond_15

    iget-object v0, p1, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    invoke-virtual {v0}, [B->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [B

    check-cast v0, [B

    iput-object v0, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    :cond_15
    return-void
.end method

.method public constructor <init>([B)V
    .registers 3
    .parameter "data"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    invoke-virtual {p1}, [B->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [B

    check-cast v0, [B

    iput-object v0, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    return-void
.end method

.method static synthetic access$000(Landroid/net/nsd/DnsSdTxtRecord;)[B
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    return-object v0
.end method

.method private getKey(I)Ljava/lang/String;
    .registers 9
    .parameter "index"

    .prologue
    const/4 v2, 0x0

    .local v2, avStart:I
    const/4 v3, 0x0

    .local v3, i:I
    :goto_2
    if-ge v3, p1, :cond_13

    iget-object v4, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    array-length v4, v4

    if-ge v2, v4, :cond_13

    iget-object v4, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    aget-byte v4, v4, v2

    add-int/lit8 v4, v4, 0x1

    add-int/2addr v2, v4

    add-int/lit8 v3, v3, 0x1

    goto :goto_2

    :cond_13
    iget-object v4, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    array-length v4, v4

    if-ge v2, v4, :cond_39

    iget-object v4, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    aget-byte v1, v4, v2

    .local v1, avLen:I
    const/4 v0, 0x0

    .local v0, aLen:I
    const/4 v0, 0x0

    :goto_1e
    if-ge v0, v1, :cond_2c

    iget-object v4, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    add-int v5, v2, v0

    add-int/lit8 v5, v5, 0x1

    aget-byte v4, v4, v5

    const/16 v5, 0x3d

    if-ne v4, v5, :cond_36

    :cond_2c
    new-instance v4, Ljava/lang/String;

    iget-object v5, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    add-int/lit8 v6, v2, 0x1

    invoke-direct {v4, v5, v6, v0}, Ljava/lang/String;-><init>([BII)V

    .end local v0           #aLen:I
    .end local v1           #avLen:I
    :goto_35
    return-object v4

    .restart local v0       #aLen:I
    .restart local v1       #avLen:I
    :cond_36
    add-int/lit8 v0, v0, 0x1

    goto :goto_1e

    .end local v0           #aLen:I
    .end local v1           #avLen:I
    :cond_39
    const/4 v4, 0x0

    goto :goto_35
.end method

.method private getValue(I)[B
    .registers 11
    .parameter "index"

    .prologue
    const/4 v2, 0x0

    .local v2, avStart:I
    const/4 v4, 0x0

    .local v4, value:[B
    const/4 v3, 0x0

    .local v3, i:I
    :goto_3
    if-ge v3, p1, :cond_14

    iget-object v5, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    array-length v5, v5

    if-ge v2, v5, :cond_14

    iget-object v5, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    aget-byte v5, v5, v2

    add-int/lit8 v5, v5, 0x1

    add-int/2addr v2, v5

    add-int/lit8 v3, v3, 0x1

    goto :goto_3

    :cond_14
    iget-object v5, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    array-length v5, v5

    if-ge v2, v5, :cond_41

    iget-object v5, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    aget-byte v1, v5, v2

    .local v1, avLen:I
    const/4 v0, 0x0

    .local v0, aLen:I
    const/4 v0, 0x0

    :goto_1f
    if-ge v0, v1, :cond_41

    iget-object v5, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    add-int v6, v2, v0

    add-int/lit8 v6, v6, 0x1

    aget-byte v5, v5, v6

    const/16 v6, 0x3d

    if-ne v5, v6, :cond_42

    sub-int v5, v1, v0

    add-int/lit8 v5, v5, -0x1

    new-array v4, v5, [B

    iget-object v5, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    add-int v6, v2, v0

    add-int/lit8 v6, v6, 0x2

    const/4 v7, 0x0

    sub-int v8, v1, v0

    add-int/lit8 v8, v8, -0x1

    invoke-static {v5, v6, v4, v7, v8}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .end local v0           #aLen:I
    .end local v1           #avLen:I
    :cond_41
    return-object v4

    .restart local v0       #aLen:I
    .restart local v1       #avLen:I
    :cond_42
    add-int/lit8 v0, v0, 0x1

    goto :goto_1f
.end method

.method private getValue(Ljava/lang/String;)[B
    .registers 5
    .parameter "forKey"

    .prologue
    const/4 v1, 0x0

    .local v1, s:Ljava/lang/String;
    const/4 v0, 0x0

    .local v0, i:I
    :goto_2
    invoke-direct {p0, v0}, Landroid/net/nsd/DnsSdTxtRecord;->getKey(I)Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_16

    invoke-virtual {p1, v1}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v2

    if-nez v2, :cond_13

    invoke-direct {p0, v0}, Landroid/net/nsd/DnsSdTxtRecord;->getValue(I)[B

    move-result-object v2

    :goto_12
    return-object v2

    :cond_13
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    :cond_16
    const/4 v2, 0x0

    goto :goto_12
.end method

.method private getValueAsString(I)Ljava/lang/String;
    .registers 4
    .parameter "index"

    .prologue
    invoke-direct {p0, p1}, Landroid/net/nsd/DnsSdTxtRecord;->getValue(I)[B

    move-result-object v0

    .local v0, value:[B
    if-eqz v0, :cond_c

    new-instance v1, Ljava/lang/String;

    invoke-direct {v1, v0}, Ljava/lang/String;-><init>([B)V

    :goto_b
    return-object v1

    :cond_c
    const/4 v1, 0x0

    goto :goto_b
.end method

.method private insert([B[BI)V
    .registers 15
    .parameter "keyBytes"
    .parameter "value"
    .parameter "index"

    .prologue
    const/4 v7, 0x0

    iget-object v4, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    .local v4, oldBytes:[B
    if-eqz p2, :cond_1b

    array-length v6, p2

    .local v6, valLen:I
    :goto_6
    const/4 v2, 0x0

    .local v2, insertion:I
    const/4 v1, 0x0

    .local v1, i:I
    :goto_8
    if-ge v1, p3, :cond_1d

    iget-object v8, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    array-length v8, v8

    if-ge v2, v8, :cond_1d

    iget-object v8, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    aget-byte v8, v8, v2

    add-int/lit8 v8, v8, 0x1

    and-int/lit16 v8, v8, 0xff

    add-int/2addr v2, v8

    add-int/lit8 v1, v1, 0x1

    goto :goto_8

    .end local v1           #i:I
    .end local v2           #insertion:I
    .end local v6           #valLen:I
    :cond_1b
    move v6, v7

    goto :goto_6

    .restart local v1       #i:I
    .restart local v2       #insertion:I
    .restart local v6       #valLen:I
    :cond_1d
    array-length v8, p1

    add-int v9, v8, v6

    if-eqz p2, :cond_5f

    const/4 v8, 0x1

    :goto_23
    add-int v0, v9, v8

    .local v0, avLen:I
    array-length v8, v4

    add-int/2addr v8, v0

    add-int/lit8 v3, v8, 0x1

    .local v3, newLen:I
    new-array v8, v3, [B

    iput-object v8, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    iget-object v8, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    invoke-static {v4, v7, v8, v7, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    array-length v8, v4

    sub-int v5, v8, v2

    .local v5, secondHalfLen:I
    iget-object v8, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    sub-int v9, v3, v5

    invoke-static {v4, v2, v8, v9, v5}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    iget-object v8, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    int-to-byte v9, v0

    aput-byte v9, v8, v2

    iget-object v8, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    add-int/lit8 v9, v2, 0x1

    array-length v10, p1

    invoke-static {p1, v7, v8, v9, v10}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    if-eqz p2, :cond_5e

    iget-object v8, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    add-int/lit8 v9, v2, 0x1

    array-length v10, p1

    add-int/2addr v9, v10

    const/16 v10, 0x3d

    aput-byte v10, v8, v9

    iget-object v8, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    array-length v9, p1

    add-int/2addr v9, v2

    add-int/lit8 v9, v9, 0x2

    invoke-static {p2, v7, v8, v9, v6}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    :cond_5e
    return-void

    .end local v0           #avLen:I
    .end local v3           #newLen:I
    .end local v5           #secondHalfLen:I
    :cond_5f
    move v8, v7

    goto :goto_23
.end method


# virtual methods
.method public contains(Ljava/lang/String;)Z
    .registers 5
    .parameter "key"

    .prologue
    const/4 v1, 0x0

    .local v1, s:Ljava/lang/String;
    const/4 v0, 0x0

    .local v0, i:I
    :goto_2
    invoke-direct {p0, v0}, Landroid/net/nsd/DnsSdTxtRecord;->getKey(I)Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_13

    invoke-virtual {p1, v1}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v2

    if-nez v2, :cond_10

    const/4 v2, 0x1

    :goto_f
    return v2

    :cond_10
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    :cond_13
    const/4 v2, 0x0

    goto :goto_f
.end method

.method public describeContents()I
    .registers 2

    .prologue
    const/4 v0, 0x0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .registers 5
    .parameter "o"

    .prologue
    if-ne p1, p0, :cond_4

    const/4 v1, 0x1

    :goto_3
    return v1

    :cond_4
    instance-of v1, p1, Landroid/net/nsd/DnsSdTxtRecord;

    if-nez v1, :cond_a

    const/4 v1, 0x0

    goto :goto_3

    :cond_a
    move-object v0, p1

    check-cast v0, Landroid/net/nsd/DnsSdTxtRecord;

    .local v0, record:Landroid/net/nsd/DnsSdTxtRecord;
    iget-object v1, v0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    iget-object v2, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    invoke-static {v1, v2}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v1

    goto :goto_3
.end method

.method public get(Ljava/lang/String;)Ljava/lang/String;
    .registers 4
    .parameter "key"

    .prologue
    invoke-direct {p0, p1}, Landroid/net/nsd/DnsSdTxtRecord;->getValue(Ljava/lang/String;)[B

    move-result-object v0

    .local v0, val:[B
    if-eqz v0, :cond_c

    new-instance v1, Ljava/lang/String;

    invoke-direct {v1, v0}, Ljava/lang/String;-><init>([B)V

    :goto_b
    return-object v1

    :cond_c
    const/4 v1, 0x0

    goto :goto_b
.end method

.method public getRawData()[B
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    invoke-virtual {v0}, [B->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [B

    check-cast v0, [B

    return-object v0
.end method

.method public hashCode()I
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    invoke-static {v0}, Ljava/util/Arrays;->hashCode([B)I

    move-result v0

    return v0
.end method

.method public keyCount()I
    .registers 4

    .prologue
    const/4 v0, 0x0

    .local v0, count:I
    const/4 v1, 0x0

    .local v1, nextKey:I
    :goto_2
    iget-object v2, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    array-length v2, v2

    if-ge v1, v2, :cond_13

    iget-object v2, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    aget-byte v2, v2, v1

    add-int/lit8 v2, v2, 0x1

    and-int/lit16 v2, v2, 0xff

    add-int/2addr v1, v2

    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    :cond_13
    return v0
.end method

.method public remove(Ljava/lang/String;)I
    .registers 11
    .parameter "key"

    .prologue
    const/4 v8, 0x0

    const/4 v1, 0x0

    .local v1, avStart:I
    const/4 v2, 0x0

    .local v2, i:I
    :goto_3
    iget-object v5, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    array-length v5, v5

    if-ge v1, v5, :cond_60

    iget-object v5, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    aget-byte v0, v5, v1

    .local v0, avLen:I
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v5

    if-gt v5, v0, :cond_58

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v5

    if-eq v5, v0, :cond_27

    iget-object v5, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v6

    add-int/2addr v6, v1

    add-int/lit8 v6, v6, 0x1

    aget-byte v5, v5, v6

    const/16 v6, 0x3d

    if-ne v5, v6, :cond_58

    :cond_27
    new-instance v4, Ljava/lang/String;

    iget-object v5, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    add-int/lit8 v6, v1, 0x1

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v7

    invoke-direct {v4, v5, v6, v7}, Ljava/lang/String;-><init>([BII)V

    .local v4, s:Ljava/lang/String;
    invoke-virtual {p1, v4}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v5

    if-nez v5, :cond_58

    iget-object v3, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    .local v3, oldBytes:[B
    array-length v5, v3

    sub-int/2addr v5, v0

    add-int/lit8 v5, v5, -0x1

    new-array v5, v5, [B

    iput-object v5, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    iget-object v5, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    invoke-static {v3, v8, v5, v8, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    add-int v5, v1, v0

    add-int/lit8 v5, v5, 0x1

    iget-object v6, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    array-length v7, v3

    sub-int/2addr v7, v1

    sub-int/2addr v7, v0

    add-int/lit8 v7, v7, -0x1

    invoke-static {v3, v5, v6, v1, v7}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .end local v0           #avLen:I
    .end local v2           #i:I
    .end local v3           #oldBytes:[B
    .end local v4           #s:Ljava/lang/String;
    :goto_57
    return v2

    .restart local v0       #avLen:I
    .restart local v2       #i:I
    :cond_58
    add-int/lit8 v5, v0, 0x1

    and-int/lit16 v5, v5, 0xff

    add-int/2addr v1, v5

    add-int/lit8 v2, v2, 0x1

    goto :goto_3

    .end local v0           #avLen:I
    :cond_60
    const/4 v2, -0x1

    goto :goto_57
.end method

.method public set(Ljava/lang/String;Ljava/lang/String;)V
    .registers 11
    .parameter "key"
    .parameter "value"

    .prologue
    if-eqz p2, :cond_1f

    invoke-virtual {p2}, Ljava/lang/String;->getBytes()[B

    move-result-object v4

    .local v4, valBytes:[B
    array-length v5, v4

    .local v5, valLen:I
    :goto_7
    :try_start_7
    const-string v6, "US-ASCII"

    invoke-virtual {p1, v6}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B
    :try_end_c
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_7 .. :try_end_c} :catch_22

    move-result-object v3

    .local v3, keyBytes:[B
    const/4 v2, 0x0

    .local v2, i:I
    :goto_e
    array-length v6, v3

    if-ge v2, v6, :cond_2e

    aget-byte v6, v3, v2

    const/16 v7, 0x3d

    if-ne v6, v7, :cond_2b

    new-instance v6, Ljava/lang/IllegalArgumentException;

    const-string v7, "= is not a valid character in key"

    invoke-direct {v6, v7}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v6

    .end local v2           #i:I
    .end local v3           #keyBytes:[B
    .end local v4           #valBytes:[B
    .end local v5           #valLen:I
    :cond_1f
    const/4 v4, 0x0

    .restart local v4       #valBytes:[B
    const/4 v5, 0x0

    .restart local v5       #valLen:I
    goto :goto_7

    :catch_22
    move-exception v1

    .local v1, e:Ljava/io/UnsupportedEncodingException;
    new-instance v6, Ljava/lang/IllegalArgumentException;

    const-string v7, "key should be US-ASCII"

    invoke-direct {v6, v7}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v6

    .end local v1           #e:Ljava/io/UnsupportedEncodingException;
    .restart local v2       #i:I
    .restart local v3       #keyBytes:[B
    :cond_2b
    add-int/lit8 v2, v2, 0x1

    goto :goto_e

    :cond_2e
    array-length v6, v3

    add-int/2addr v6, v5

    const/16 v7, 0xff

    if-lt v6, v7, :cond_3c

    new-instance v6, Ljava/lang/IllegalArgumentException;

    const-string v7, "Key and Value length cannot exceed 255 bytes"

    invoke-direct {v6, v7}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v6

    :cond_3c
    invoke-virtual {p0, p1}, Landroid/net/nsd/DnsSdTxtRecord;->remove(Ljava/lang/String;)I

    move-result v0

    .local v0, currentLoc:I
    const/4 v6, -0x1

    if-ne v0, v6, :cond_47

    invoke-virtual {p0}, Landroid/net/nsd/DnsSdTxtRecord;->keyCount()I

    move-result v0

    :cond_47
    invoke-direct {p0, v3, v4, v0}, Landroid/net/nsd/DnsSdTxtRecord;->insert([B[BI)V

    return-void
.end method

.method public size()I
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    array-length v0, v0

    return v0
.end method

.method public toString()Ljava/lang/String;
    .registers 8

    .prologue
    const/4 v3, 0x0

    .local v3, result:Ljava/lang/String;
    const/4 v2, 0x0

    .local v2, i:I
    :goto_2
    invoke-direct {p0, v2}, Landroid/net/nsd/DnsSdTxtRecord;->getKey(I)Ljava/lang/String;

    move-result-object v0

    .local v0, a:Ljava/lang/String;
    if-eqz v0, :cond_73

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "{"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .local v1, av:Ljava/lang/String;
    invoke-direct {p0, v2}, Landroid/net/nsd/DnsSdTxtRecord;->getValueAsString(I)Ljava/lang/String;

    move-result-object v4

    .local v4, val:Ljava/lang/String;
    if-eqz v4, :cond_46

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, "}"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    :goto_40
    if-nez v3, :cond_5b

    move-object v3, v1

    :goto_43
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    :cond_46
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, "}"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_40

    :cond_5b
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ", "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    goto :goto_43

    .end local v1           #av:Ljava/lang/String;
    .end local v4           #val:Ljava/lang/String;
    :cond_73
    if-eqz v3, :cond_76

    .end local v3           #result:Ljava/lang/String;
    :goto_75
    return-object v3

    .restart local v3       #result:Ljava/lang/String;
    :cond_76
    const-string v3, ""

    goto :goto_75
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 4
    .parameter "dest"
    .parameter "flags"

    .prologue
    iget-object v0, p0, Landroid/net/nsd/DnsSdTxtRecord;->mData:[B

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeByteArray([B)V

    return-void
.end method
