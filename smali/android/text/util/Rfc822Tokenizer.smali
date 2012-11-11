.class public Landroid/text/util/Rfc822Tokenizer;
.super Ljava/lang/Object;
.source "Rfc822Tokenizer.java"

# interfaces
.implements Landroid/widget/MultiAutoCompleteTextView$Tokenizer;


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static crunch(Ljava/lang/StringBuilder;)V
    .registers 6
    .parameter "sb"

    .prologue
    const/16 v4, 0x20

    const/4 v1, 0x0

    .local v1, i:I
    invoke-virtual {p0}, Ljava/lang/StringBuilder;->length()I

    move-result v2

    .local v2, len:I
    :goto_7
    if-ge v1, v2, :cond_41

    invoke-virtual {p0, v1}, Ljava/lang/StringBuilder;->charAt(I)C

    move-result v0

    .local v0, c:C
    if-nez v0, :cond_3e

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

    :cond_35
    invoke-virtual {p0, v1}, Ljava/lang/StringBuilder;->deleteCharAt(I)Ljava/lang/StringBuilder;

    add-int/lit8 v2, v2, -0x1

    goto :goto_7

    :cond_3b
    add-int/lit8 v1, v1, 0x1

    goto :goto_7

    :cond_3e
    add-int/lit8 v1, v1, 0x1

    goto :goto_7

    .end local v0           #c:C
    :cond_41
    const/4 v1, 0x0

    :goto_42
    if-ge v1, v2, :cond_50

    invoke-virtual {p0, v1}, Ljava/lang/StringBuilder;->charAt(I)C

    move-result v3

    if-nez v3, :cond_4d

    invoke-virtual {p0, v1, v4}, Ljava/lang/StringBuilder;->setCharAt(IC)V

    :cond_4d
    add-int/lit8 v1, v1, 0x1

    goto :goto_42

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
    .local p1, out:Ljava/util/Collection;,"Ljava/util/Collection<Landroid/text/util/Rfc822Token;>;"
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    .local v6, name:Ljava/lang/StringBuilder;
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .local v0, address:Ljava/lang/StringBuilder;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .local v2, comment:Ljava/lang/StringBuilder;
    const/4 v4, 0x0

    .local v4, i:I
    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v3

    .local v3, cursor:I
    :cond_14
    :goto_14
    if-ge v4, v3, :cond_111

    invoke-interface {p0, v4}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v1

    .local v1, c:C
    const/16 v7, 0x2c

    if-eq v1, v7, :cond_22

    const/16 v7, 0x3b

    if-ne v1, v7, :cond_73

    :cond_22
    add-int/lit8 v4, v4, 0x1

    :goto_24
    if-ge v4, v3, :cond_31

    invoke-interface {p0, v4}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v7

    const/16 v8, 0x20

    if-ne v7, v8, :cond_31

    add-int/lit8 v4, v4, 0x1

    goto :goto_24

    :cond_31
    invoke-static {v6}, Landroid/text/util/Rfc822Tokenizer;->crunch(Ljava/lang/StringBuilder;)V

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->length()I

    move-result v7

    if-lez v7, :cond_5b

    new-instance v7, Landroid/text/util/Rfc822Token;

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-direct {v7, v8, v9, v10}, Landroid/text/util/Rfc822Token;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {p1, v7}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    :cond_4e
    :goto_4e
    const/4 v7, 0x0

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->setLength(I)V

    const/4 v7, 0x0

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->setLength(I)V

    const/4 v7, 0x0

    invoke-virtual {v2, v7}, Ljava/lang/StringBuilder;->setLength(I)V

    goto :goto_14

    :cond_5b
    invoke-virtual {v6}, Ljava/lang/StringBuilder;->length()I

    move-result v7

    if-lez v7, :cond_4e

    new-instance v7, Landroid/text/util/Rfc822Token;

    const/4 v8, 0x0

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-direct {v7, v8, v9, v10}, Landroid/text/util/Rfc822Token;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {p1, v7}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    goto :goto_4e

    :cond_73
    const/16 v7, 0x22

    if-ne v1, v7, :cond_a0

    add-int/lit8 v4, v4, 0x1

    :goto_79
    if-ge v4, v3, :cond_14

    invoke-interface {p0, v4}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v1

    const/16 v7, 0x22

    if-ne v1, v7, :cond_86

    add-int/lit8 v4, v4, 0x1

    goto :goto_14

    :cond_86
    const/16 v7, 0x5c

    if-ne v1, v7, :cond_9a

    add-int/lit8 v7, v4, 0x1

    if-ge v7, v3, :cond_97

    add-int/lit8 v7, v4, 0x1

    invoke-interface {p0, v7}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    :cond_97
    add-int/lit8 v4, v4, 0x2

    goto :goto_79

    :cond_9a
    invoke-virtual {v6, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    add-int/lit8 v4, v4, 0x1

    goto :goto_79

    :cond_a0
    const/16 v7, 0x28

    if-ne v1, v7, :cond_e4

    const/4 v5, 0x1

    .local v5, level:I
    add-int/lit8 v4, v4, 0x1

    :goto_a7
    if-ge v4, v3, :cond_14

    if-lez v5, :cond_14

    invoke-interface {p0, v4}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v1

    const/16 v7, 0x29

    if-ne v1, v7, :cond_be

    const/4 v7, 0x1

    if-le v5, v7, :cond_b9

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    :cond_b9
    add-int/lit8 v5, v5, -0x1

    add-int/lit8 v4, v4, 0x1

    goto :goto_a7

    :cond_be
    const/16 v7, 0x28

    if-ne v1, v7, :cond_ca

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    add-int/lit8 v5, v5, 0x1

    add-int/lit8 v4, v4, 0x1

    goto :goto_a7

    :cond_ca
    const/16 v7, 0x5c

    if-ne v1, v7, :cond_de

    add-int/lit8 v7, v4, 0x1

    if-ge v7, v3, :cond_db

    add-int/lit8 v7, v4, 0x1

    invoke-interface {p0, v7}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v7

    invoke-virtual {v2, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    :cond_db
    add-int/lit8 v4, v4, 0x2

    goto :goto_a7

    :cond_de
    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    add-int/lit8 v4, v4, 0x1

    goto :goto_a7

    .end local v5           #level:I
    :cond_e4
    const/16 v7, 0x3c

    if-ne v1, v7, :cond_fe

    add-int/lit8 v4, v4, 0x1

    :goto_ea
    if-ge v4, v3, :cond_14

    invoke-interface {p0, v4}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v1

    const/16 v7, 0x3e

    if-ne v1, v7, :cond_f8

    add-int/lit8 v4, v4, 0x1

    goto/16 :goto_14

    :cond_f8
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    add-int/lit8 v4, v4, 0x1

    goto :goto_ea

    :cond_fe
    const/16 v7, 0x20

    if-ne v1, v7, :cond_10a

    const/4 v7, 0x0

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    add-int/lit8 v4, v4, 0x1

    goto/16 :goto_14

    :cond_10a
    invoke-virtual {v6, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    add-int/lit8 v4, v4, 0x1

    goto/16 :goto_14

    .end local v1           #c:C
    :cond_111
    invoke-static {v6}, Landroid/text/util/Rfc822Tokenizer;->crunch(Ljava/lang/StringBuilder;)V

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->length()I

    move-result v7

    if-lez v7, :cond_12f

    new-instance v7, Landroid/text/util/Rfc822Token;

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-direct {v7, v8, v9, v10}, Landroid/text/util/Rfc822Token;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {p1, v7}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    :cond_12e
    :goto_12e
    return-void

    :cond_12f
    invoke-virtual {v6}, Ljava/lang/StringBuilder;->length()I

    move-result v7

    if-lez v7, :cond_12e

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
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .local v0, out:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/text/util/Rfc822Token;>;"
    invoke-static {p0, v0}, Landroid/text/util/Rfc822Tokenizer;->tokenize(Ljava/lang/CharSequence;Ljava/util/Collection;)V

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

    invoke-interface {p1}, Ljava/lang/CharSequence;->length()I

    move-result v2

    .local v2, len:I
    move v1, p2

    .local v1, i:I
    :cond_b
    :goto_b
    if-ge v1, v2, :cond_19

    invoke-interface {p1, v1}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v0

    .local v0, c:C
    const/16 v4, 0x2c

    if-eq v0, v4, :cond_19

    const/16 v4, 0x3b

    if-ne v0, v4, :cond_1a

    .end local v0           #c:C
    :cond_19
    return v1

    .restart local v0       #c:C
    :cond_1a
    if-ne v0, v5, :cond_35

    add-int/lit8 v1, v1, 0x1

    :goto_1e
    if-ge v1, v2, :cond_b

    invoke-interface {p1, v1}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v0

    if-ne v0, v5, :cond_29

    add-int/lit8 v1, v1, 0x1

    goto :goto_b

    :cond_29
    if-ne v0, v7, :cond_32

    add-int/lit8 v4, v1, 0x1

    if-ge v4, v2, :cond_32

    add-int/lit8 v1, v1, 0x2

    goto :goto_1e

    :cond_32
    add-int/lit8 v1, v1, 0x1

    goto :goto_1e

    :cond_35
    if-ne v0, v6, :cond_5e

    const/4 v3, 0x1

    .local v3, level:I
    add-int/lit8 v1, v1, 0x1

    :goto_3a
    if-ge v1, v2, :cond_b

    if-lez v3, :cond_b

    invoke-interface {p1, v1}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v0

    const/16 v4, 0x29

    if-ne v0, v4, :cond_4b

    add-int/lit8 v3, v3, -0x1

    add-int/lit8 v1, v1, 0x1

    goto :goto_3a

    :cond_4b
    if-ne v0, v6, :cond_52

    add-int/lit8 v3, v3, 0x1

    add-int/lit8 v1, v1, 0x1

    goto :goto_3a

    :cond_52
    if-ne v0, v7, :cond_5b

    add-int/lit8 v4, v1, 0x1

    if-ge v4, v2, :cond_5b

    add-int/lit8 v1, v1, 0x2

    goto :goto_3a

    :cond_5b
    add-int/lit8 v1, v1, 0x1

    goto :goto_3a

    .end local v3           #level:I
    :cond_5e
    const/16 v4, 0x3c

    if-ne v0, v4, :cond_74

    add-int/lit8 v1, v1, 0x1

    :goto_64
    if-ge v1, v2, :cond_b

    invoke-interface {p1, v1}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v0

    const/16 v4, 0x3e

    if-ne v0, v4, :cond_71

    add-int/lit8 v1, v1, 0x1

    goto :goto_b

    :cond_71
    add-int/lit8 v1, v1, 0x1

    goto :goto_64

    :cond_74
    add-int/lit8 v1, v1, 0x1

    goto :goto_b
.end method

.method public findTokenStart(Ljava/lang/CharSequence;I)I
    .registers 7
    .parameter "text"
    .parameter "cursor"

    .prologue
    const/4 v0, 0x0

    .local v0, best:I
    const/4 v1, 0x0

    .local v1, i:I
    :cond_2
    :goto_2
    if-ge v1, p2, :cond_1d

    invoke-virtual {p0, p1, v1}, Landroid/text/util/Rfc822Tokenizer;->findTokenEnd(Ljava/lang/CharSequence;I)I

    move-result v1

    if-ge v1, p2, :cond_2

    add-int/lit8 v1, v1, 0x1

    :goto_c
    if-ge v1, p2, :cond_19

    invoke-interface {p1, v1}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v2

    const/16 v3, 0x20

    if-ne v2, v3, :cond_19

    add-int/lit8 v1, v1, 0x1

    goto :goto_c

    :cond_19
    if-ge v1, p2, :cond_2

    move v0, v1

    goto :goto_2

    :cond_1d
    return v0
.end method

.method public terminateToken(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    .registers 4
    .parameter "text"

    .prologue
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
