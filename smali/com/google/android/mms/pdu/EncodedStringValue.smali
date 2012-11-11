.class public Lcom/google/android/mms/pdu/EncodedStringValue;
.super Ljava/lang/Object;
.source "EncodedStringValue.java"

# interfaces
.implements Ljava/lang/Cloneable;


# static fields
.field private static final DEBUG:Z = false

.field private static final LOCAL_LOGV:Z = false

.field private static final TAG:Ljava/lang/String; = "EncodedStringValue"


# instance fields
.field private mCharacterSet:I

.field private mData:[B


# direct methods
.method public constructor <init>(I[B)V
    .registers 6
    .parameter "charset"
    .parameter "data"

    .prologue
    const/4 v2, 0x0

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    if-nez p2, :cond_e

    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "EncodedStringValue: Text-string is null."

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_e
    iput p1, p0, Lcom/google/android/mms/pdu/EncodedStringValue;->mCharacterSet:I

    array-length v0, p2

    new-array v0, v0, [B

    iput-object v0, p0, Lcom/google/android/mms/pdu/EncodedStringValue;->mData:[B

    iget-object v0, p0, Lcom/google/android/mms/pdu/EncodedStringValue;->mData:[B

    array-length v1, p2

    invoke-static {p2, v2, v0, v2, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .registers 5
    .parameter "data"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    :try_start_3
    const-string/jumbo v1, "utf-8"

    invoke-virtual {p1, v1}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v1

    iput-object v1, p0, Lcom/google/android/mms/pdu/EncodedStringValue;->mData:[B

    const/16 v1, 0x6a

    iput v1, p0, Lcom/google/android/mms/pdu/EncodedStringValue;->mCharacterSet:I
    :try_end_10
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_3 .. :try_end_10} :catch_11

    :goto_10
    return-void

    :catch_11
    move-exception v0

    .local v0, e:Ljava/io/UnsupportedEncodingException;
    const-string v1, "EncodedStringValue"

    const-string v2, "Default encoding must be supported."

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_10
.end method

.method public constructor <init>([B)V
    .registers 3
    .parameter "data"

    .prologue
    const/16 v0, 0x6a

    invoke-direct {p0, v0, p1}, Lcom/google/android/mms/pdu/EncodedStringValue;-><init>(I[B)V

    return-void
.end method

.method public static concat([Lcom/google/android/mms/pdu/EncodedStringValue;)Ljava/lang/String;
    .registers 5
    .parameter "addr"

    .prologue
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .local v2, sb:Ljava/lang/StringBuilder;
    array-length v3, p0

    add-int/lit8 v1, v3, -0x1

    .local v1, maxIndex:I
    const/4 v0, 0x0

    .local v0, i:I
    :goto_9
    if-gt v0, v1, :cond_1e

    aget-object v3, p0, v0

    invoke-virtual {v3}, Lcom/google/android/mms/pdu/EncodedStringValue;->getString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    if-ge v0, v1, :cond_1b

    const-string v3, ";"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :cond_1b
    add-int/lit8 v0, v0, 0x1

    goto :goto_9

    :cond_1e
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3
.end method

.method public static copy(Lcom/google/android/mms/pdu/EncodedStringValue;)Lcom/google/android/mms/pdu/EncodedStringValue;
    .registers 4
    .parameter "value"

    .prologue
    if-nez p0, :cond_4

    const/4 v0, 0x0

    :goto_3
    return-object v0

    :cond_4
    new-instance v0, Lcom/google/android/mms/pdu/EncodedStringValue;

    iget v1, p0, Lcom/google/android/mms/pdu/EncodedStringValue;->mCharacterSet:I

    iget-object v2, p0, Lcom/google/android/mms/pdu/EncodedStringValue;->mData:[B

    invoke-direct {v0, v1, v2}, Lcom/google/android/mms/pdu/EncodedStringValue;-><init>(I[B)V

    goto :goto_3
.end method

.method public static encodeStrings([Ljava/lang/String;)[Lcom/google/android/mms/pdu/EncodedStringValue;
    .registers 6
    .parameter "array"

    .prologue
    array-length v0, p0

    .local v0, count:I
    if-lez v0, :cond_14

    new-array v1, v0, [Lcom/google/android/mms/pdu/EncodedStringValue;

    .local v1, encodedArray:[Lcom/google/android/mms/pdu/EncodedStringValue;
    const/4 v2, 0x0

    .local v2, i:I
    :goto_6
    if-ge v2, v0, :cond_15

    new-instance v3, Lcom/google/android/mms/pdu/EncodedStringValue;

    aget-object v4, p0, v2

    invoke-direct {v3, v4}, Lcom/google/android/mms/pdu/EncodedStringValue;-><init>(Ljava/lang/String;)V

    aput-object v3, v1, v2

    add-int/lit8 v2, v2, 0x1

    goto :goto_6

    .end local v1           #encodedArray:[Lcom/google/android/mms/pdu/EncodedStringValue;
    .end local v2           #i:I
    :cond_14
    const/4 v1, 0x0

    :cond_15
    return-object v1
.end method

.method public static extract(Ljava/lang/String;)[Lcom/google/android/mms/pdu/EncodedStringValue;
    .registers 7
    .parameter "src"

    .prologue
    const-string v4, ";"

    invoke-virtual {p0, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .local v3, values:[Ljava/lang/String;
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .local v2, list:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Lcom/google/android/mms/pdu/EncodedStringValue;>;"
    const/4 v0, 0x0

    .local v0, i:I
    :goto_c
    array-length v4, v3

    if-ge v0, v4, :cond_24

    aget-object v4, v3, v0

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    if-lez v4, :cond_21

    new-instance v4, Lcom/google/android/mms/pdu/EncodedStringValue;

    aget-object v5, v3, v0

    invoke-direct {v4, v5}, Lcom/google/android/mms/pdu/EncodedStringValue;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_21
    add-int/lit8 v0, v0, 0x1

    goto :goto_c

    :cond_24
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v1

    .local v1, len:I
    if-lez v1, :cond_33

    new-array v4, v1, [Lcom/google/android/mms/pdu/EncodedStringValue;

    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v4

    check-cast v4, [Lcom/google/android/mms/pdu/EncodedStringValue;

    :goto_32
    return-object v4

    :cond_33
    const/4 v4, 0x0

    goto :goto_32
.end method


# virtual methods
.method public appendTextString([B)V
    .registers 7
    .parameter "textString"

    .prologue
    const/4 v4, 0x0

    if-nez p1, :cond_b

    new-instance v2, Ljava/lang/NullPointerException;

    const-string v3, "Text-string is null."

    invoke-direct {v2, v3}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v2

    :cond_b
    iget-object v2, p0, Lcom/google/android/mms/pdu/EncodedStringValue;->mData:[B

    if-nez v2, :cond_1b

    array-length v2, p1

    new-array v2, v2, [B

    iput-object v2, p0, Lcom/google/android/mms/pdu/EncodedStringValue;->mData:[B

    iget-object v2, p0, Lcom/google/android/mms/pdu/EncodedStringValue;->mData:[B

    array-length v3, p1

    invoke-static {p1, v4, v2, v4, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    :goto_1a
    return-void

    :cond_1b
    new-instance v1, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v1}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .local v1, newTextString:Ljava/io/ByteArrayOutputStream;
    :try_start_20
    iget-object v2, p0, Lcom/google/android/mms/pdu/EncodedStringValue;->mData:[B

    invoke-virtual {v1, v2}, Ljava/io/ByteArrayOutputStream;->write([B)V

    invoke-virtual {v1, p1}, Ljava/io/ByteArrayOutputStream;->write([B)V
    :try_end_28
    .catch Ljava/io/IOException; {:try_start_20 .. :try_end_28} :catch_2f

    invoke-virtual {v1}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v2

    iput-object v2, p0, Lcom/google/android/mms/pdu/EncodedStringValue;->mData:[B

    goto :goto_1a

    :catch_2f
    move-exception v0

    .local v0, e:Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    new-instance v2, Ljava/lang/NullPointerException;

    const-string v3, "appendTextString: failed when write a new Text-string"

    invoke-direct {v2, v3}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v2
.end method

.method public clone()Ljava/lang/Object;
    .registers 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    invoke-super {p0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    iget-object v3, p0, Lcom/google/android/mms/pdu/EncodedStringValue;->mData:[B

    array-length v2, v3

    .local v2, len:I
    new-array v0, v2, [B

    .local v0, dstBytes:[B
    iget-object v3, p0, Lcom/google/android/mms/pdu/EncodedStringValue;->mData:[B

    invoke-static {v3, v4, v0, v4, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    :try_start_e
    new-instance v3, Lcom/google/android/mms/pdu/EncodedStringValue;

    iget v4, p0, Lcom/google/android/mms/pdu/EncodedStringValue;->mCharacterSet:I

    invoke-direct {v3, v4, v0}, Lcom/google/android/mms/pdu/EncodedStringValue;-><init>(I[B)V
    :try_end_15
    .catch Ljava/lang/Exception; {:try_start_e .. :try_end_15} :catch_16

    return-object v3

    :catch_16
    move-exception v1

    .local v1, e:Ljava/lang/Exception;
    const-string v3, "EncodedStringValue"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "failed to clone an EncodedStringValue: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    new-instance v3, Ljava/lang/CloneNotSupportedException;

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/CloneNotSupportedException;-><init>(Ljava/lang/String;)V

    throw v3
.end method

.method public getCharacterSet()I
    .registers 2

    .prologue
    iget v0, p0, Lcom/google/android/mms/pdu/EncodedStringValue;->mCharacterSet:I

    return v0
.end method

.method public getString()Ljava/lang/String;
    .registers 7

    .prologue
    iget v3, p0, Lcom/google/android/mms/pdu/EncodedStringValue;->mCharacterSet:I

    if-nez v3, :cond_c

    new-instance v3, Ljava/lang/String;

    iget-object v4, p0, Lcom/google/android/mms/pdu/EncodedStringValue;->mData:[B

    invoke-direct {v3, v4}, Ljava/lang/String;-><init>([B)V

    :goto_b
    return-object v3

    :cond_c
    :try_start_c
    iget v3, p0, Lcom/google/android/mms/pdu/EncodedStringValue;->mCharacterSet:I

    invoke-static {v3}, Lcom/google/android/mms/pdu/CharacterSets;->getMimeName(I)Ljava/lang/String;

    move-result-object v2

    .local v2, name:Ljava/lang/String;
    new-instance v3, Ljava/lang/String;

    iget-object v4, p0, Lcom/google/android/mms/pdu/EncodedStringValue;->mData:[B

    invoke-direct {v3, v4, v2}, Ljava/lang/String;-><init>([BLjava/lang/String;)V
    :try_end_19
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_c .. :try_end_19} :catch_1a

    goto :goto_b

    .end local v2           #name:Ljava/lang/String;
    :catch_1a
    move-exception v1

    .local v1, e:Ljava/io/UnsupportedEncodingException;
    :try_start_1b
    new-instance v3, Ljava/lang/String;

    iget-object v4, p0, Lcom/google/android/mms/pdu/EncodedStringValue;->mData:[B

    const-string v5, "iso-8859-1"

    invoke-direct {v3, v4, v5}, Ljava/lang/String;-><init>([BLjava/lang/String;)V
    :try_end_24
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_1b .. :try_end_24} :catch_25

    goto :goto_b

    :catch_25
    move-exception v0

    .local v0, _:Ljava/io/UnsupportedEncodingException;
    new-instance v3, Ljava/lang/String;

    iget-object v4, p0, Lcom/google/android/mms/pdu/EncodedStringValue;->mData:[B

    invoke-direct {v3, v4}, Ljava/lang/String;-><init>([B)V

    goto :goto_b
.end method

.method public getTextString()[B
    .registers 5

    .prologue
    const/4 v3, 0x0

    iget-object v1, p0, Lcom/google/android/mms/pdu/EncodedStringValue;->mData:[B

    array-length v1, v1

    new-array v0, v1, [B

    .local v0, byteArray:[B
    iget-object v1, p0, Lcom/google/android/mms/pdu/EncodedStringValue;->mData:[B

    iget-object v2, p0, Lcom/google/android/mms/pdu/EncodedStringValue;->mData:[B

    array-length v2, v2

    invoke-static {v1, v3, v0, v3, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-object v0
.end method

.method public setCharacterSet(I)V
    .registers 2
    .parameter "charset"

    .prologue
    iput p1, p0, Lcom/google/android/mms/pdu/EncodedStringValue;->mCharacterSet:I

    return-void
.end method

.method public setTextString([B)V
    .registers 5
    .parameter "textString"

    .prologue
    const/4 v2, 0x0

    if-nez p1, :cond_b

    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "EncodedStringValue: Text-string is null."

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_b
    array-length v0, p1

    new-array v0, v0, [B

    iput-object v0, p0, Lcom/google/android/mms/pdu/EncodedStringValue;->mData:[B

    iget-object v0, p0, Lcom/google/android/mms/pdu/EncodedStringValue;->mData:[B

    array-length v1, p1

    invoke-static {p1, v2, v0, v2, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-void
.end method

.method public split(Ljava/lang/String;)[Lcom/google/android/mms/pdu/EncodedStringValue;
    .registers 9
    .parameter "pattern"

    .prologue
    invoke-virtual {p0}, Lcom/google/android/mms/pdu/EncodedStringValue;->getString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .local v3, temp:[Ljava/lang/String;
    array-length v4, v3

    new-array v2, v4, [Lcom/google/android/mms/pdu/EncodedStringValue;

    .local v2, ret:[Lcom/google/android/mms/pdu/EncodedStringValue;
    const/4 v1, 0x0

    .local v1, i:I
    :goto_c
    array-length v4, v2

    if-ge v1, v4, :cond_23

    :try_start_f
    new-instance v4, Lcom/google/android/mms/pdu/EncodedStringValue;

    iget v5, p0, Lcom/google/android/mms/pdu/EncodedStringValue;->mCharacterSet:I

    aget-object v6, v3, v1

    invoke-virtual {v6}, Ljava/lang/String;->getBytes()[B

    move-result-object v6

    invoke-direct {v4, v5, v6}, Lcom/google/android/mms/pdu/EncodedStringValue;-><init>(I[B)V

    aput-object v4, v2, v1
    :try_end_1e
    .catch Ljava/lang/NullPointerException; {:try_start_f .. :try_end_1e} :catch_21

    add-int/lit8 v1, v1, 0x1

    goto :goto_c

    :catch_21
    move-exception v0

    .local v0, _:Ljava/lang/NullPointerException;
    const/4 v2, 0x0

    .end local v0           #_:Ljava/lang/NullPointerException;
    .end local v2           #ret:[Lcom/google/android/mms/pdu/EncodedStringValue;
    :cond_23
    return-object v2
.end method
