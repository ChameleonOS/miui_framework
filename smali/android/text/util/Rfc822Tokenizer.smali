.class public Landroid/text/util/Rfc822Tokenizer;
.super Ljava/lang/Object;
.source "Rfc822Tokenizer.java"

# interfaces
.implements Landroid/widget/MultiAutoCompleteTextView$Tokenizer;


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 30
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static crunch(Ljava/lang/StringBuilder;)V
    .registers 6
    .parameter "sb"

    .prologue
    const/16 v4, 0x20

    .line 178
    const/4 v1, 0x0

    .line 179
    .local v1, i:I
    invoke-virtual {p0}, Ljava/lang/StringBuilder;->length()I

    move-result v2

    .line 181
    .local v2, len:I
    :goto_7
    if-ge v1, v2, :cond_41

    .line 182
    invoke-virtual {p0, v1}, Ljava/lang/StringBuilder;->charAt(I)C

    move-result v0

    .line 184
    .local v0, c:C
    if-nez v0, :cond_3e

    .line 185
    if-eqz v1, :cond_35

    add-int/lit8 v3, v2, -0x1

    if-eq v1, v3, :cond_35

    add-int/lit8 v3, v1, -0x1

    invoke-virtual {p0, v3}, Ljava/lang/StringBuilder;->charAt(I)C

    move-result v3

    if-eq v3, v4, :cond_35

    add-int/lit8 v3, v1, -0x1

    invoke-virtual {p0, v3}, Ljava/lang/StringBuilder;->charAt(I)C

    move-result v3

    if-eqz v3, :cond_35

    add-int/lit8 v3, v1, 0x1

    invoke-virtual {p0, v3}, Ljava/lang/StringBuilder;->charAt(I)C

    move-result v3

    if-eq v3, v4, :cond_35

    add-int/lit8 v3, v1, 0x1

    invoke-virtual {p0, v3}, Ljava/lang/StringBuilder;->charAt(I)C

    move-result v3

    if-nez v3, :cond_3b

    .line 190
    :cond_35
    invoke-virtual {p0, v1}, Ljava/lang/StringBuilder;->deleteCharAt(I)Ljava/lang/StringBuilder;

    .line 191
    add-int/lit8 v2, v2, -0x1

    goto :goto_7

    .line 193
    :cond_3b
    add-int/lit8 v1, v1, 0x1

    goto :goto_7

    .line 196
    :cond_3e
    add-int/lit8 v1, v1, 0x1

    goto :goto_7

    .line 200
    .end local v0           #c:C
    :cond_41
    const/4 v1, 0x0

    :goto_42
    if-ge v1, v2, :cond_50

    .line 201
    invoke-virtual {p0, v1}, Ljava/lang/StringBuilder;->charAt(I)C

    move-result v3

    if-nez v3, :cond_4d

    .line 202
    invoke-virtual {p0, v1, v4}, Ljava/lang/StringBuilder;->setCharAt(IC)V

    .line 200
    :cond_4d
    add-int/lit8 v1, v1, 0x1

    goto :goto_42

    .line 205
    :cond_50
    return-void
.end method

.method public static tokenize(Ljava/lang/CharSequence;Ljava/util/Collection;)V
    .registers 13
    .parameter "text"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/CharSequence;",
            "Ljava/util/Collection",
            "<",
            "Landroid/text/util/Rfc822Token;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 46
    .local p1, out:Ljava/util/Collection;,"Ljava/util/Collection<Landroid/text/util/Rfc822Token;>;"
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    .line 47
    .local v6, name:Ljava/lang/StringBuilder;
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 48
    .local v0, address:Ljava/lang/StringBuilder;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 50
    .local v2, comment:Ljava/lang/StringBuilder;
    const/4 v4, 0x0

    .line 51
    .local v4, i:I
    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v3

    .line 53
    .local v3, cursor:I
    :cond_14
    :goto_14
    if-ge v4, v3, :cond_111

    .line 54
    invoke-interface {p0, v4}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v1

    .line 56
    .local v1, c:C
    const/16 v7, 0x2c

    if-eq v1, v7, :cond_22

    const/16 v7, 0x3b

    if-ne v1, v7, :cond_73

    .line 57
    :cond_22
    add-int/lit8 v4, v4, 0x1

    .line 59
    :goto_24
    if-ge v4, v3, :cond_31

    invoke-interface {p0, v4}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v7

    const/16 v8, 0x20

    if-ne v7, v8, :cond_31

    .line 60
    add-int/lit8 v4, v4, 0x1

    goto :goto_24

    .line 63
    :cond_31
    invoke-static {v6}, Landroid/text/util/Rfc822Tokenizer;->crunch(Ljava/lang/StringBuilder;)V

    .line 65
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->length()I

    move-result v7

    if-lez v7, :cond_5b

    .line 66
    new-instance v7, Landroid/text/util/Rfc822Token;

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-direct {v7, v8, v9, v10}, Landroid/text/util/Rfc822Token;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {p1, v7}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    .line 75
    :cond_4e
    :goto_4e
    const/4 v7, 0x0

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->setLength(I)V

    .line 76
    const/4 v7, 0x0

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->setLength(I)V

    .line 77
    const/4 v7, 0x0

    invoke-virtual {v2, v7}, Ljava/lang/StringBuilder;->setLength(I)V

    goto :goto_14

    .line 69
    :cond_5b
    invoke-virtual {v6}, Ljava/lang/StringBuilder;->length()I

    move-result v7

    if-lez v7, :cond_4e

    .line 70
    new-instance v7, Landroid/text/util/Rfc822Token;

    const/4 v8, 0x0

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-direct {v7, v8, v9, v10}, Landroid/text/util/Rfc822Token;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {p1, v7}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    goto :goto_4e

    .line 78
    :cond_73
    const/16 v7, 0x22

    if-ne v1, v7, :cond_a0

    .line 79
    add-int/lit8 v4, v4, 0x1

    .line 81
    :goto_79
    if-ge v4, v3, :cond_14

    .line 82
    invoke-interface {p0, v4}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v1

    .line 84
    const/16 v7, 0x22

    if-ne v1, v7, :cond_86

    .line 85
    add-int/lit8 v4, v4, 0x1

    .line 86
    goto :goto_14

    .line 87
    :cond_86
    const/16 v7, 0x5c

    if-ne v1, v7, :cond_9a

    .line 88
    add-int/lit8 v7, v4, 0x1

    if-ge v7, v3, :cond_97

    .line 89
    add-int/lit8 v7, v4, 0x1

    invoke-interface {p0, v7}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 91
    :cond_97
    add-int/lit8 v4, v4, 0x2

    goto :goto_79

    .line 93
    :cond_9a
    invoke-virtual {v6, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 94
    add-int/lit8 v4, v4, 0x1

    goto :goto_79

    .line 97
    :cond_a0
    const/16 v7, 0x28

    if-ne v1, v7, :cond_e4

    .line 98
    const/4 v5, 0x1

    .line 99
    .local v5, level:I
    add-int/lit8 v4, v4, 0x1

    .line 101
    :goto_a7
    if-ge v4, v3, :cond_14

    if-lez v5, :cond_14

    .line 102
    invoke-interface {p0, v4}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v1

    .line 104
    const/16 v7, 0x29

    if-ne v1, v7, :cond_be

    .line 105
    const/4 v7, 0x1

    if-le v5, v7, :cond_b9

    .line 106
    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 109
    :cond_b9
    add-int/lit8 v5, v5, -0x1

    .line 110
    add-int/lit8 v4, v4, 0x1

    goto :goto_a7

    .line 111
    :cond_be
    const/16 v7, 0x28

    if-ne v1, v7, :cond_ca

    .line 112
    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 113
    add-int/lit8 v5, v5, 0x1

    .line 114
    add-int/lit8 v4, v4, 0x1

    goto :goto_a7

    .line 115
    :cond_ca
    const/16 v7, 0x5c

    if-ne v1, v7, :cond_de

    .line 116
    add-int/lit8 v7, v4, 0x1

    if-ge v7, v3, :cond_db

    .line 117
    add-int/lit8 v7, v4, 0x1

    invoke-interface {p0, v7}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v7

    invoke-virtual {v2, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 119
    :cond_db
    add-int/lit8 v4, v4, 0x2

    goto :goto_a7

    .line 121
    :cond_de
    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 122
    add-int/lit8 v4, v4, 0x1

    goto :goto_a7

    .line 125
    .end local v5           #level:I
    :cond_e4
    const/16 v7, 0x3c

    if-ne v1, v7, :cond_fe

    .line 126
    add-int/lit8 v4, v4, 0x1

    .line 128
    :goto_ea
    if-ge v4, v3, :cond_14

    .line 129
    invoke-interface {p0, v4}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v1

    .line 131
    const/16 v7, 0x3e

    if-ne v1, v7, :cond_f8

    .line 132
    add-int/lit8 v4, v4, 0x1

    .line 133
    goto/16 :goto_14

    .line 135
    :cond_f8
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 136
    add-int/lit8 v4, v4, 0x1

    goto :goto_ea

    .line 139
    :cond_fe
    const/16 v7, 0x20

    if-ne v1, v7, :cond_10a

    .line 140
    const/4 v7, 0x0

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 141
    add-int/lit8 v4, v4, 0x1

    goto/16 :goto_14

    .line 143
    :cond_10a
    invoke-virtual {v6, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 144
    add-int/lit8 v4, v4, 0x1

    goto/16 :goto_14

    .line 148
    .end local v1           #c:C
    :cond_111
    invoke-static {v6}, Landroid/text/util/Rfc822Tokenizer;->crunch(Ljava/lang/StringBuilder;)V

    .line 150
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->length()I

    move-result v7

    if-lez v7, :cond_12f

    .line 151
    new-instance v7, Landroid/text/util/Rfc822Token;

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-direct {v7, v8, v9, v10}, Landroid/text/util/Rfc822Token;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {p1, v7}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    .line 159
    :cond_12e
    :goto_12e
    return-void

    .line 154
    :cond_12f
    invoke-virtual {v6}, Ljava/lang/StringBuilder;->length()I

    move-result v7

    if-lez v7, :cond_12e

    .line 155
    new-instance v7, Landroid/text/util/Rfc822Token;

    const/4 v8, 0x0

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-direct {v7, v8, v9, v10}, Landroid/text/util/Rfc822Token;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {p1, v7}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    goto :goto_12e
.end method

.method public static tokenize(Ljava/lang/CharSequence;)[Landroid/text/util/Rfc822Token;
    .registers 3
    .parameter "text"

    .prologue
    .line 172
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 173
    .local v0, out:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/text/util/Rfc822Token;>;"
    invoke-static {p0, v0}, Landroid/text/util/Rfc822Tokenizer;->tokenize(Ljava/lang/CharSequence;Ljava/util/Collection;)V

    .line 174
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v1

    new-array v1, v1, [Landroid/text/util/Rfc822Token;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Landroid/text/util/Rfc822Token;

    return-object v1
.end method


# virtual methods
.method public findTokenEnd(Ljava/lang/CharSequence;I)I
    .registers 11
    .parameter "text"
    .parameter "cursor"

    .prologue
    const/16 v7, 0x5c

    const/16 v6, 0x28

    const/16 v5, 0x22

    .line 242
    invoke-interface {p1}, Ljava/lang/CharSequence;->length()I

    move-result v2

    .line 243
    .local v2, len:I
    move v1, p2

    .line 245
    .local v1, i:I
    :cond_b
    :goto_b
    if-ge v1, v2, :cond_19

    .line 246
    invoke-interface {p1, v1}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v0

    .line 248
    .local v0, c:C
    const/16 v4, 0x2c

    if-eq v0, v4, :cond_19

    const/16 v4, 0x3b

    if-ne v0, v4, :cond_1a

    .line 302
    .end local v0           #c:C
    :cond_19
    return v1

    .line 250
    .restart local v0       #c:C
    :cond_1a
    if-ne v0, v5, :cond_35

    .line 251
    add-int/lit8 v1, v1, 0x1

    .line 253
    :goto_1e
    if-ge v1, v2, :cond_b

    .line 254
    invoke-interface {p1, v1}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v0

    .line 256
    if-ne v0, v5, :cond_29

    .line 257
    add-int/lit8 v1, v1, 0x1

    .line 258
    goto :goto_b

    .line 259
    :cond_29
    if-ne v0, v7, :cond_32

    add-int/lit8 v4, v1, 0x1

    if-ge v4, v2, :cond_32

    .line 260
    add-int/lit8 v1, v1, 0x2

    goto :goto_1e

    .line 262
    :cond_32
    add-int/lit8 v1, v1, 0x1

    goto :goto_1e

    .line 265
    :cond_35
    if-ne v0, v6, :cond_5e

    .line 266
    const/4 v3, 0x1

    .line 267
    .local v3, level:I
    add-int/lit8 v1, v1, 0x1

    .line 269
    :goto_3a
    if-ge v1, v2, :cond_b

    if-lez v3, :cond_b

    .line 270
    invoke-interface {p1, v1}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v0

    .line 272
    const/16 v4, 0x29

    if-ne v0, v4, :cond_4b

    .line 273
    add-int/lit8 v3, v3, -0x1

    .line 274
    add-int/lit8 v1, v1, 0x1

    goto :goto_3a

    .line 275
    :cond_4b
    if-ne v0, v6, :cond_52

    .line 276
    add-int/lit8 v3, v3, 0x1

    .line 277
    add-int/lit8 v1, v1, 0x1

    goto :goto_3a

    .line 278
    :cond_52
    if-ne v0, v7, :cond_5b

    add-int/lit8 v4, v1, 0x1

    if-ge v4, v2, :cond_5b

    .line 279
    add-int/lit8 v1, v1, 0x2

    goto :goto_3a

    .line 281
    :cond_5b
    add-int/lit8 v1, v1, 0x1

    goto :goto_3a

    .line 284
    .end local v3           #level:I
    :cond_5e
    const/16 v4, 0x3c

    if-ne v0, v4, :cond_74

    .line 285
    add-int/lit8 v1, v1, 0x1

    .line 287
    :goto_64
    if-ge v1, v2, :cond_b

    .line 288
    invoke-interface {p1, v1}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v0

    .line 290
    const/16 v4, 0x3e

    if-ne v0, v4, :cond_71

    .line 291
    add-int/lit8 v1, v1, 0x1

    .line 292
    goto :goto_b

    .line 294
    :cond_71
    add-int/lit8 v1, v1, 0x1

    goto :goto_64

    .line 298
    :cond_74
    add-int/lit8 v1, v1, 0x1

    goto :goto_b
.end method

.method public findTokenStart(Ljava/lang/CharSequence;I)I
    .registers 7
    .parameter "text"
    .parameter "cursor"

    .prologue
    .line 216
    const/4 v0, 0x0

    .line 217
    .local v0, best:I
    const/4 v1, 0x0

    .line 219
    .local v1, i:I
    :cond_2
    :goto_2
    if-ge v1, p2, :cond_1d

    .line 220
    invoke-virtual {p0, p1, v1}, Landroid/text/util/Rfc822Tokenizer;->findTokenEnd(Ljava/lang/CharSequence;I)I

    move-result v1

    .line 222
    if-ge v1, p2, :cond_2

    .line 223
    add-int/lit8 v1, v1, 0x1

    .line 225
    :goto_c
    if-ge v1, p2, :cond_19

    invoke-interface {p1, v1}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v2

    const/16 v3, 0x20

    if-ne v2, v3, :cond_19

    .line 226
    add-int/lit8 v1, v1, 0x1

    goto :goto_c

    .line 229
    :cond_19
    if-ge v1, p2, :cond_2

    .line 230
    move v0, v1

    goto :goto_2

    .line 235
    :cond_1d
    return v0
.end method

.method public terminateToken(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    .registers 4
    .parameter "text"

    .prologue
    .line 312
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
