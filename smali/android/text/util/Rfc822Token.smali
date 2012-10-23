.class public Landroid/text/util/Rfc822Token;
.super Ljava/lang/Object;
.source "Rfc822Token.java"


# instance fields
.field private mAddress:Ljava/lang/String;

.field private mComment:Ljava/lang/String;

.field private mName:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .registers 4
    .parameter "name"
    .parameter "address"
    .parameter "comment"

    .prologue
    .line 30
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 31
    iput-object p1, p0, Landroid/text/util/Rfc822Token;->mName:Ljava/lang/String;

    .line 32
    iput-object p2, p0, Landroid/text/util/Rfc822Token;->mAddress:Ljava/lang/String;

    .line 33
    iput-object p3, p0, Landroid/text/util/Rfc822Token;->mComment:Ljava/lang/String;

    .line 34
    return-void
.end method

.method public static quoteComment(Ljava/lang/String;)Ljava/lang/String;
    .registers 7
    .parameter "comment"

    .prologue
    const/16 v5, 0x5c

    .line 156
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    .line 157
    .local v2, len:I
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 159
    .local v3, sb:Ljava/lang/StringBuilder;
    const/4 v1, 0x0

    .local v1, i:I
    :goto_c
    if-ge v1, v2, :cond_25

    .line 160
    invoke-virtual {p0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 162
    .local v0, c:C
    const/16 v4, 0x28

    if-eq v0, v4, :cond_1c

    const/16 v4, 0x29

    if-eq v0, v4, :cond_1c

    if-ne v0, v5, :cond_1f

    .line 163
    :cond_1c
    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 166
    :cond_1f
    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 159
    add-int/lit8 v1, v1, 0x1

    goto :goto_c

    .line 169
    .end local v0           #c:C
    :cond_25
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    return-object v4
.end method

.method public static quoteName(Ljava/lang/String;)Ljava/lang/String;
    .registers 7
    .parameter "name"

    .prologue
    const/16 v5, 0x5c

    .line 134
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 136
    .local v3, sb:Ljava/lang/StringBuilder;
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    .line 137
    .local v2, len:I
    const/4 v1, 0x0

    .local v1, i:I
    :goto_c
    if-ge v1, v2, :cond_21

    .line 138
    invoke-virtual {p0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 140
    .local v0, c:C
    if-eq v0, v5, :cond_18

    const/16 v4, 0x22

    if-ne v0, v4, :cond_1b

    .line 141
    :cond_18
    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 144
    :cond_1b
    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 137
    add-int/lit8 v1, v1, 0x1

    goto :goto_c

    .line 147
    .end local v0           #c:C
    :cond_21
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    return-object v4
.end method

.method public static quoteNameIfNecessary(Ljava/lang/String;)Ljava/lang/String;
    .registers 7
    .parameter "name"

    .prologue
    const/16 v5, 0x22

    .line 112
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    .line 114
    .local v2, len:I
    const/4 v1, 0x0

    .local v1, i:I
    :goto_7
    if-ge v1, v2, :cond_42

    .line 115
    invoke-virtual {p0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 117
    .local v0, c:C
    const/16 v3, 0x41

    if-lt v0, v3, :cond_15

    const/16 v3, 0x5a

    if-le v0, v3, :cond_43

    :cond_15
    const/16 v3, 0x61

    if-lt v0, v3, :cond_1d

    const/16 v3, 0x7a

    if-le v0, v3, :cond_43

    :cond_1d
    const/16 v3, 0x20

    if-eq v0, v3, :cond_43

    const/16 v3, 0x30

    if-lt v0, v3, :cond_29

    const/16 v3, 0x39

    if-le v0, v3, :cond_43

    .line 121
    :cond_29
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-static {p0}, Landroid/text/util/Rfc822Token;->quoteName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    .line 125
    .end local v0           #c:C
    .end local p0
    :cond_42
    return-object p0

    .line 114
    .restart local v0       #c:C
    .restart local p0
    :cond_43
    add-int/lit8 v1, v1, 0x1

    goto :goto_7
.end method

.method private static stringEquals(Ljava/lang/String;Ljava/lang/String;)Z
    .registers 3
    .parameter "a"
    .parameter "b"

    .prologue
    .line 181
    if-nez p0, :cond_8

    .line 182
    if-nez p1, :cond_6

    const/4 v0, 0x1

    .line 184
    :goto_5
    return v0

    .line 182
    :cond_6
    const/4 v0, 0x0

    goto :goto_5

    .line 184
    :cond_8
    invoke-virtual {p0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    goto :goto_5
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .registers 6
    .parameter "o"

    .prologue
    const/4 v1, 0x0

    .line 189
    instance-of v2, p1, Landroid/text/util/Rfc822Token;

    if-nez v2, :cond_6

    .line 193
    :cond_5
    :goto_5
    return v1

    :cond_6
    move-object v0, p1

    .line 192
    check-cast v0, Landroid/text/util/Rfc822Token;

    .line 193
    .local v0, other:Landroid/text/util/Rfc822Token;
    iget-object v2, p0, Landroid/text/util/Rfc822Token;->mName:Ljava/lang/String;

    iget-object v3, v0, Landroid/text/util/Rfc822Token;->mName:Ljava/lang/String;

    invoke-static {v2, v3}, Landroid/text/util/Rfc822Token;->stringEquals(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_5

    iget-object v2, p0, Landroid/text/util/Rfc822Token;->mAddress:Ljava/lang/String;

    iget-object v3, v0, Landroid/text/util/Rfc822Token;->mAddress:Ljava/lang/String;

    invoke-static {v2, v3}, Landroid/text/util/Rfc822Token;->stringEquals(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_5

    iget-object v2, p0, Landroid/text/util/Rfc822Token;->mComment:Ljava/lang/String;

    iget-object v3, v0, Landroid/text/util/Rfc822Token;->mComment:Ljava/lang/String;

    invoke-static {v2, v3}, Landroid/text/util/Rfc822Token;->stringEquals(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_5

    const/4 v1, 0x1

    goto :goto_5
.end method

.method public getAddress()Ljava/lang/String;
    .registers 2

    .prologue
    .line 47
    iget-object v0, p0, Landroid/text/util/Rfc822Token;->mAddress:Ljava/lang/String;

    return-object v0
.end method

.method public getComment()Ljava/lang/String;
    .registers 2

    .prologue
    .line 54
    iget-object v0, p0, Landroid/text/util/Rfc822Token;->mComment:Ljava/lang/String;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .registers 2

    .prologue
    .line 40
    iget-object v0, p0, Landroid/text/util/Rfc822Token;->mName:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .registers 4

    .prologue
    .line 173
    const/16 v0, 0x11

    .line 174
    .local v0, result:I
    iget-object v1, p0, Landroid/text/util/Rfc822Token;->mName:Ljava/lang/String;

    if-eqz v1, :cond_e

    iget-object v1, p0, Landroid/text/util/Rfc822Token;->mName:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    add-int/lit16 v0, v1, 0x20f

    .line 175
    :cond_e
    iget-object v1, p0, Landroid/text/util/Rfc822Token;->mAddress:Ljava/lang/String;

    if-eqz v1, :cond_1c

    mul-int/lit8 v1, v0, 0x1f

    iget-object v2, p0, Landroid/text/util/Rfc822Token;->mAddress:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    add-int v0, v1, v2

    .line 176
    :cond_1c
    iget-object v1, p0, Landroid/text/util/Rfc822Token;->mComment:Ljava/lang/String;

    if-eqz v1, :cond_2a

    mul-int/lit8 v1, v0, 0x1f

    iget-object v2, p0, Landroid/text/util/Rfc822Token;->mComment:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    add-int v0, v1, v2

    .line 177
    :cond_2a
    return v0
.end method

.method public setAddress(Ljava/lang/String;)V
    .registers 2
    .parameter "address"

    .prologue
    .line 68
    iput-object p1, p0, Landroid/text/util/Rfc822Token;->mAddress:Ljava/lang/String;

    .line 69
    return-void
.end method

.method public setComment(Ljava/lang/String;)V
    .registers 2
    .parameter "comment"

    .prologue
    .line 75
    iput-object p1, p0, Landroid/text/util/Rfc822Token;->mComment:Ljava/lang/String;

    .line 76
    return-void
.end method

.method public setName(Ljava/lang/String;)V
    .registers 2
    .parameter "name"

    .prologue
    .line 61
    iput-object p1, p0, Landroid/text/util/Rfc822Token;->mName:Ljava/lang/String;

    .line 62
    return-void
.end method

.method public toString()Ljava/lang/String;
    .registers 3

    .prologue
    .line 84
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 86
    .local v0, sb:Ljava/lang/StringBuilder;
    iget-object v1, p0, Landroid/text/util/Rfc822Token;->mName:Ljava/lang/String;

    if-eqz v1, :cond_1f

    iget-object v1, p0, Landroid/text/util/Rfc822Token;->mName:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-eqz v1, :cond_1f

    .line 87
    iget-object v1, p0, Landroid/text/util/Rfc822Token;->mName:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/util/Rfc822Token;->quoteNameIfNecessary(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 88
    const/16 v1, 0x20

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 91
    :cond_1f
    iget-object v1, p0, Landroid/text/util/Rfc822Token;->mComment:Ljava/lang/String;

    if-eqz v1, :cond_3e

    iget-object v1, p0, Landroid/text/util/Rfc822Token;->mComment:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-eqz v1, :cond_3e

    .line 92
    const/16 v1, 0x28

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 93
    iget-object v1, p0, Landroid/text/util/Rfc822Token;->mComment:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/util/Rfc822Token;->quoteComment(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 94
    const-string v1, ") "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 97
    :cond_3e
    iget-object v1, p0, Landroid/text/util/Rfc822Token;->mAddress:Ljava/lang/String;

    if-eqz v1, :cond_59

    iget-object v1, p0, Landroid/text/util/Rfc822Token;->mAddress:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-eqz v1, :cond_59

    .line 98
    const/16 v1, 0x3c

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 99
    iget-object v1, p0, Landroid/text/util/Rfc822Token;->mAddress:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 100
    const/16 v1, 0x3e

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 103
    :cond_59
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
