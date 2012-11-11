.class Landroid/net/http/CharArrayBuffers;
.super Ljava/lang/Object;
.source "CharArrayBuffers.java"


# static fields
.field static final uppercaseAddon:C = ' '


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static containsIgnoreCaseTrimmed(Lorg/apache/http/util/CharArrayBuffer;ILjava/lang/String;)Z
    .registers 13
    .parameter "buffer"
    .parameter "beginIndex"
    .parameter "str"

    .prologue
    const/4 v7, 0x1

    const/4 v8, 0x0

    invoke-virtual {p0}, Lorg/apache/http/util/CharArrayBuffer;->length()I

    move-result v4

    .local v4, len:I
    invoke-virtual {p0}, Lorg/apache/http/util/CharArrayBuffer;->buffer()[C

    move-result-object v2

    .local v2, chars:[C
    :goto_a
    if-ge p1, v4, :cond_17

    aget-char v9, v2, p1

    invoke-static {v9}, Lorg/apache/http/protocol/HTTP;->isWhitespace(C)Z

    move-result v9

    if-eqz v9, :cond_17

    add-int/lit8 p1, p1, 0x1

    goto :goto_a

    :cond_17
    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v6

    .local v6, size:I
    add-int v9, p1, v6

    if-lt v4, v9, :cond_3d

    move v5, v7

    .local v5, ok:Z
    :goto_20
    const/4 v3, 0x0

    .local v3, j:I
    :goto_21
    if-eqz v5, :cond_41

    if-ge v3, v6, :cond_41

    add-int v9, p1, v3

    aget-char v0, v2, v9

    .local v0, a:C
    invoke-virtual {p2, v3}, Ljava/lang/String;->charAt(I)C

    move-result v1

    .local v1, b:C
    if-eq v0, v1, :cond_3a

    invoke-static {v0}, Landroid/net/http/CharArrayBuffers;->toLower(C)C

    move-result v0

    invoke-static {v1}, Landroid/net/http/CharArrayBuffers;->toLower(C)C

    move-result v1

    if-ne v0, v1, :cond_3f

    move v5, v7

    :cond_3a
    :goto_3a
    add-int/lit8 v3, v3, 0x1

    goto :goto_21

    .end local v0           #a:C
    .end local v1           #b:C
    .end local v3           #j:I
    .end local v5           #ok:Z
    :cond_3d
    move v5, v8

    goto :goto_20

    .restart local v0       #a:C
    .restart local v1       #b:C
    .restart local v3       #j:I
    .restart local v5       #ok:Z
    :cond_3f
    move v5, v8

    goto :goto_3a

    .end local v0           #a:C
    .end local v1           #b:C
    :cond_41
    return v5
.end method

.method static setLowercaseIndexOf(Lorg/apache/http/util/CharArrayBuffer;I)I
    .registers 8
    .parameter "buffer"
    .parameter "ch"

    .prologue
    const/4 v0, 0x0

    .local v0, beginIndex:I
    invoke-virtual {p0}, Lorg/apache/http/util/CharArrayBuffer;->length()I

    move-result v3

    .local v3, endIndex:I
    invoke-virtual {p0}, Lorg/apache/http/util/CharArrayBuffer;->buffer()[C

    move-result-object v1

    .local v1, chars:[C
    move v4, v0

    .local v4, i:I
    :goto_a
    if-ge v4, v3, :cond_21

    aget-char v2, v1, v4

    .local v2, current:C
    if-ne v2, p1, :cond_11

    .end local v2           #current:C
    .end local v4           #i:I
    :goto_10
    return v4

    .restart local v2       #current:C
    .restart local v4       #i:I
    :cond_11
    const/16 v5, 0x41

    if-lt v2, v5, :cond_1e

    const/16 v5, 0x5a

    if-gt v2, v5, :cond_1e

    add-int/lit8 v5, v2, 0x20

    int-to-char v2, v5

    aput-char v2, v1, v4

    :cond_1e
    add-int/lit8 v4, v4, 0x1

    goto :goto_a

    .end local v2           #current:C
    :cond_21
    const/4 v4, -0x1

    goto :goto_10
.end method

.method private static toLower(C)C
    .registers 2
    .parameter "c"

    .prologue
    const/16 v0, 0x41

    if-lt p0, v0, :cond_b

    const/16 v0, 0x5a

    if-gt p0, v0, :cond_b

    add-int/lit8 v0, p0, 0x20

    int-to-char p0, v0

    :cond_b
    return p0
.end method
