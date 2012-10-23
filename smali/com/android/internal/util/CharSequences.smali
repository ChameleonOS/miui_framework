.class public Lcom/android/internal/util/CharSequences;
.super Ljava/lang/Object;
.source "CharSequences.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 22
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static compareToIgnoreCase(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)I
    .registers 12
    .parameter "me"
    .parameter "another"

    .prologue
    .line 119
    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v4

    .local v4, myLen:I
    invoke-interface {p1}, Ljava/lang/CharSequence;->length()I

    move-result v0

    .line 120
    .local v0, anotherLen:I
    const/4 v5, 0x0

    .local v5, myPos:I
    const/4 v1, 0x0

    .line 121
    .local v1, anotherPos:I
    if-ge v4, v0, :cond_2a

    move v3, v4

    .local v3, end:I
    :goto_d
    move v2, v1

    .end local v1           #anotherPos:I
    .local v2, anotherPos:I
    move v6, v5

    .line 123
    .end local v5           #myPos:I
    .local v6, myPos:I
    :goto_f
    if-ge v6, v3, :cond_2c

    .line 124
    add-int/lit8 v5, v6, 0x1

    .end local v6           #myPos:I
    .restart local v5       #myPos:I
    invoke-interface {p0, v6}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v8

    invoke-static {v8}, Ljava/lang/Character;->toLowerCase(C)C

    move-result v8

    add-int/lit8 v1, v2, 0x1

    .end local v2           #anotherPos:I
    .restart local v1       #anotherPos:I
    invoke-interface {p1, v2}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v9

    invoke-static {v9}, Ljava/lang/Character;->toLowerCase(C)C

    move-result v9

    sub-int v7, v8, v9

    .local v7, result:I
    if-eqz v7, :cond_31

    .line 129
    .end local v7           #result:I
    :goto_29
    return v7

    .end local v3           #end:I
    :cond_2a
    move v3, v0

    .line 121
    goto :goto_d

    .line 129
    .end local v1           #anotherPos:I
    .end local v5           #myPos:I
    .restart local v2       #anotherPos:I
    .restart local v3       #end:I
    .restart local v6       #myPos:I
    :cond_2c
    sub-int v7, v4, v0

    move v1, v2

    .end local v2           #anotherPos:I
    .restart local v1       #anotherPos:I
    move v5, v6

    .end local v6           #myPos:I
    .restart local v5       #myPos:I
    goto :goto_29

    .restart local v7       #result:I
    :cond_31
    move v2, v1

    .end local v1           #anotherPos:I
    .restart local v2       #anotherPos:I
    move v6, v5

    .end local v5           #myPos:I
    .restart local v6       #myPos:I
    goto :goto_f
.end method

.method public static equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    .registers 7
    .parameter "a"
    .parameter "b"

    .prologue
    const/4 v2, 0x0

    .line 97
    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v3

    invoke-interface {p1}, Ljava/lang/CharSequence;->length()I

    move-result v4

    if-eq v3, v4, :cond_c

    .line 107
    :cond_b
    :goto_b
    return v2

    .line 101
    :cond_c
    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v1

    .line 102
    .local v1, length:I
    const/4 v0, 0x0

    .local v0, i:I
    :goto_11
    if-ge v0, v1, :cond_20

    .line 103
    invoke-interface {p0, v0}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v3

    invoke-interface {p1, v0}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v4

    if-ne v3, v4, :cond_b

    .line 102
    add-int/lit8 v0, v0, 0x1

    goto :goto_11

    .line 107
    :cond_20
    const/4 v2, 0x1

    goto :goto_b
.end method

.method public static forAsciiBytes([B)Ljava/lang/CharSequence;
    .registers 2
    .parameter "bytes"

    .prologue
    .line 31
    new-instance v0, Lcom/android/internal/util/CharSequences$1;

    invoke-direct {v0, p0}, Lcom/android/internal/util/CharSequences$1;-><init>([B)V

    return-object v0
.end method

.method public static forAsciiBytes([BII)Ljava/lang/CharSequence;
    .registers 4
    .parameter "bytes"
    .parameter "start"
    .parameter "end"

    .prologue
    .line 63
    array-length v0, p0

    invoke-static {p1, p2, v0}, Lcom/android/internal/util/CharSequences;->validate(III)V

    .line 64
    new-instance v0, Lcom/android/internal/util/CharSequences$2;

    invoke-direct {v0, p0, p1, p2}, Lcom/android/internal/util/CharSequences$2;-><init>([BII)V

    return-object v0
.end method

.method static validate(III)V
    .registers 4
    .parameter "start"
    .parameter "end"
    .parameter "length"

    .prologue
    .line 87
    if-gez p0, :cond_8

    new-instance v0, Ljava/lang/IndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/IndexOutOfBoundsException;-><init>()V

    throw v0

    .line 88
    :cond_8
    if-gez p1, :cond_10

    new-instance v0, Ljava/lang/IndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/IndexOutOfBoundsException;-><init>()V

    throw v0

    .line 89
    :cond_10
    if-le p1, p2, :cond_18

    new-instance v0, Ljava/lang/IndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/IndexOutOfBoundsException;-><init>()V

    throw v0

    .line 90
    :cond_18
    if-le p0, p1, :cond_20

    new-instance v0, Ljava/lang/IndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/IndexOutOfBoundsException;-><init>()V

    throw v0

    .line 91
    :cond_20
    return-void
.end method
