.class Landroid/text/PackedObjectVector;
.super Ljava/lang/Object;
.source "PackedObjectVector.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<E:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private mColumns:I

.field private mRowGapLength:I

.field private mRowGapStart:I

.field private mRows:I

.field private mValues:[Ljava/lang/Object;


# direct methods
.method public constructor <init>(I)V
    .registers 5
    .parameter "columns"

    .prologue
    .local p0, this:Landroid/text/PackedObjectVector;,"Landroid/text/PackedObjectVector<TE;>;"
    const/4 v2, 0x0

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Landroid/text/PackedObjectVector;->mColumns:I

    invoke-static {v2}, Lcom/android/internal/util/ArrayUtils;->idealIntArraySize(I)I

    move-result v0

    iget v1, p0, Landroid/text/PackedObjectVector;->mColumns:I

    div-int/2addr v0, v1

    iput v0, p0, Landroid/text/PackedObjectVector;->mRows:I

    iput v2, p0, Landroid/text/PackedObjectVector;->mRowGapStart:I

    iget v0, p0, Landroid/text/PackedObjectVector;->mRows:I

    iput v0, p0, Landroid/text/PackedObjectVector;->mRowGapLength:I

    iget v0, p0, Landroid/text/PackedObjectVector;->mRows:I

    iget v1, p0, Landroid/text/PackedObjectVector;->mColumns:I

    mul-int/2addr v0, v1

    new-array v0, v0, [Ljava/lang/Object;

    iput-object v0, p0, Landroid/text/PackedObjectVector;->mValues:[Ljava/lang/Object;

    return-void
.end method

.method private growBuffer()V
    .registers 8

    .prologue
    .local p0, this:Landroid/text/PackedObjectVector;,"Landroid/text/PackedObjectVector<TE;>;"
    const/4 v6, 0x0

    invoke-virtual {p0}, Landroid/text/PackedObjectVector;->size()I

    move-result v3

    add-int/lit8 v1, v3, 0x1

    .local v1, newsize:I
    iget v3, p0, Landroid/text/PackedObjectVector;->mColumns:I

    mul-int/2addr v3, v1

    invoke-static {v3}, Lcom/android/internal/util/ArrayUtils;->idealIntArraySize(I)I

    move-result v3

    iget v4, p0, Landroid/text/PackedObjectVector;->mColumns:I

    div-int v1, v3, v4

    iget v3, p0, Landroid/text/PackedObjectVector;->mColumns:I

    mul-int/2addr v3, v1

    new-array v2, v3, [Ljava/lang/Object;

    .local v2, newvalues:[Ljava/lang/Object;
    iget v3, p0, Landroid/text/PackedObjectVector;->mRows:I

    iget v4, p0, Landroid/text/PackedObjectVector;->mRowGapStart:I

    iget v5, p0, Landroid/text/PackedObjectVector;->mRowGapLength:I

    add-int/2addr v4, v5

    sub-int v0, v3, v4

    .local v0, after:I
    iget-object v3, p0, Landroid/text/PackedObjectVector;->mValues:[Ljava/lang/Object;

    iget v4, p0, Landroid/text/PackedObjectVector;->mColumns:I

    iget v5, p0, Landroid/text/PackedObjectVector;->mRowGapStart:I

    mul-int/2addr v4, v5

    invoke-static {v3, v6, v2, v6, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    iget-object v3, p0, Landroid/text/PackedObjectVector;->mValues:[Ljava/lang/Object;

    iget v4, p0, Landroid/text/PackedObjectVector;->mRows:I

    sub-int/2addr v4, v0

    iget v5, p0, Landroid/text/PackedObjectVector;->mColumns:I

    mul-int/2addr v4, v5

    sub-int v5, v1, v0

    iget v6, p0, Landroid/text/PackedObjectVector;->mColumns:I

    mul-int/2addr v5, v6

    iget v6, p0, Landroid/text/PackedObjectVector;->mColumns:I

    mul-int/2addr v6, v0

    invoke-static {v3, v4, v2, v5, v6}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    iget v3, p0, Landroid/text/PackedObjectVector;->mRowGapLength:I

    iget v4, p0, Landroid/text/PackedObjectVector;->mRows:I

    sub-int v4, v1, v4

    add-int/2addr v3, v4

    iput v3, p0, Landroid/text/PackedObjectVector;->mRowGapLength:I

    iput v1, p0, Landroid/text/PackedObjectVector;->mRows:I

    iput-object v2, p0, Landroid/text/PackedObjectVector;->mValues:[Ljava/lang/Object;

    return-void
.end method

.method private moveRowGapTo(I)V
    .registers 10
    .parameter "where"

    .prologue
    .local p0, this:Landroid/text/PackedObjectVector;,"Landroid/text/PackedObjectVector<TE;>;"
    iget v5, p0, Landroid/text/PackedObjectVector;->mRowGapStart:I

    if-ne p1, v5, :cond_5

    :goto_4
    return-void

    :cond_5
    iget v5, p0, Landroid/text/PackedObjectVector;->mRowGapStart:I

    if-le p1, v5, :cond_47

    iget v5, p0, Landroid/text/PackedObjectVector;->mRowGapLength:I

    add-int/2addr v5, p1

    iget v6, p0, Landroid/text/PackedObjectVector;->mRowGapStart:I

    iget v7, p0, Landroid/text/PackedObjectVector;->mRowGapLength:I

    add-int/2addr v6, v7

    sub-int v3, v5, v6

    .local v3, moving:I
    iget v5, p0, Landroid/text/PackedObjectVector;->mRowGapStart:I

    iget v6, p0, Landroid/text/PackedObjectVector;->mRowGapLength:I

    add-int v1, v5, v6

    .local v1, i:I
    :goto_19
    iget v5, p0, Landroid/text/PackedObjectVector;->mRowGapStart:I

    iget v6, p0, Landroid/text/PackedObjectVector;->mRowGapLength:I

    add-int/2addr v5, v6

    add-int/2addr v5, v3

    if-ge v1, v5, :cond_76

    iget v5, p0, Landroid/text/PackedObjectVector;->mRowGapStart:I

    iget v6, p0, Landroid/text/PackedObjectVector;->mRowGapLength:I

    add-int/2addr v5, v6

    sub-int v5, v1, v5

    iget v6, p0, Landroid/text/PackedObjectVector;->mRowGapStart:I

    add-int v0, v5, v6

    .local v0, destrow:I
    const/4 v2, 0x0

    .local v2, j:I
    :goto_2d
    iget v5, p0, Landroid/text/PackedObjectVector;->mColumns:I

    if-ge v2, v5, :cond_44

    iget-object v5, p0, Landroid/text/PackedObjectVector;->mValues:[Ljava/lang/Object;

    iget v6, p0, Landroid/text/PackedObjectVector;->mColumns:I

    mul-int/2addr v6, v1

    add-int/2addr v6, v2

    aget-object v4, v5, v6

    .local v4, val:Ljava/lang/Object;
    iget-object v5, p0, Landroid/text/PackedObjectVector;->mValues:[Ljava/lang/Object;

    iget v6, p0, Landroid/text/PackedObjectVector;->mColumns:I

    mul-int/2addr v6, v0

    add-int/2addr v6, v2

    aput-object v4, v5, v6

    add-int/lit8 v2, v2, 0x1

    goto :goto_2d

    .end local v4           #val:Ljava/lang/Object;
    :cond_44
    add-int/lit8 v1, v1, 0x1

    goto :goto_19

    .end local v0           #destrow:I
    .end local v1           #i:I
    .end local v2           #j:I
    .end local v3           #moving:I
    :cond_47
    iget v5, p0, Landroid/text/PackedObjectVector;->mRowGapStart:I

    sub-int v3, v5, p1

    .restart local v3       #moving:I
    add-int v5, p1, v3

    add-int/lit8 v1, v5, -0x1

    .restart local v1       #i:I
    :goto_4f
    if-lt v1, p1, :cond_76

    sub-int v5, v1, p1

    iget v6, p0, Landroid/text/PackedObjectVector;->mRowGapStart:I

    add-int/2addr v5, v6

    iget v6, p0, Landroid/text/PackedObjectVector;->mRowGapLength:I

    add-int/2addr v5, v6

    sub-int v0, v5, v3

    .restart local v0       #destrow:I
    const/4 v2, 0x0

    .restart local v2       #j:I
    :goto_5c
    iget v5, p0, Landroid/text/PackedObjectVector;->mColumns:I

    if-ge v2, v5, :cond_73

    iget-object v5, p0, Landroid/text/PackedObjectVector;->mValues:[Ljava/lang/Object;

    iget v6, p0, Landroid/text/PackedObjectVector;->mColumns:I

    mul-int/2addr v6, v1

    add-int/2addr v6, v2

    aget-object v4, v5, v6

    .restart local v4       #val:Ljava/lang/Object;
    iget-object v5, p0, Landroid/text/PackedObjectVector;->mValues:[Ljava/lang/Object;

    iget v6, p0, Landroid/text/PackedObjectVector;->mColumns:I

    mul-int/2addr v6, v0

    add-int/2addr v6, v2

    aput-object v4, v5, v6

    add-int/lit8 v2, v2, 0x1

    goto :goto_5c

    .end local v4           #val:Ljava/lang/Object;
    :cond_73
    add-int/lit8 v1, v1, -0x1

    goto :goto_4f

    .end local v0           #destrow:I
    .end local v2           #j:I
    :cond_76
    iput p1, p0, Landroid/text/PackedObjectVector;->mRowGapStart:I

    goto :goto_4
.end method


# virtual methods
.method public deleteAt(II)V
    .registers 5
    .parameter "row"
    .parameter "count"

    .prologue
    .local p0, this:Landroid/text/PackedObjectVector;,"Landroid/text/PackedObjectVector<TE;>;"
    add-int v0, p1, p2

    invoke-direct {p0, v0}, Landroid/text/PackedObjectVector;->moveRowGapTo(I)V

    iget v0, p0, Landroid/text/PackedObjectVector;->mRowGapStart:I

    sub-int/2addr v0, p2

    iput v0, p0, Landroid/text/PackedObjectVector;->mRowGapStart:I

    iget v0, p0, Landroid/text/PackedObjectVector;->mRowGapLength:I

    add-int/2addr v0, p2

    iput v0, p0, Landroid/text/PackedObjectVector;->mRowGapLength:I

    iget v0, p0, Landroid/text/PackedObjectVector;->mRowGapLength:I

    invoke-virtual {p0}, Landroid/text/PackedObjectVector;->size()I

    move-result v1

    mul-int/lit8 v1, v1, 0x2

    if-le v0, v1, :cond_19

    :cond_19
    return-void
.end method

.method public dump()V
    .registers 7

    .prologue
    .local p0, this:Landroid/text/PackedObjectVector;,"Landroid/text/PackedObjectVector<TE;>;"
    const/4 v0, 0x0

    .local v0, i:I
    :goto_1
    iget v3, p0, Landroid/text/PackedObjectVector;->mRows:I

    if-ge v0, v3, :cond_61

    const/4 v1, 0x0

    .local v1, j:I
    :goto_6
    iget v3, p0, Landroid/text/PackedObjectVector;->mColumns:I

    if-ge v1, v3, :cond_57

    iget-object v3, p0, Landroid/text/PackedObjectVector;->mValues:[Ljava/lang/Object;

    iget v4, p0, Landroid/text/PackedObjectVector;->mColumns:I

    mul-int/2addr v4, v0

    add-int/2addr v4, v1

    aget-object v2, v3, v4

    .local v2, val:Ljava/lang/Object;
    iget v3, p0, Landroid/text/PackedObjectVector;->mRowGapStart:I

    if-lt v0, v3, :cond_1d

    iget v3, p0, Landroid/text/PackedObjectVector;->mRowGapStart:I

    iget v4, p0, Landroid/text/PackedObjectVector;->mRowGapLength:I

    add-int/2addr v3, v4

    if-lt v0, v3, :cond_38

    :cond_1d
    sget-object v3, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/io/PrintStream;->print(Ljava/lang/String;)V

    :goto_35
    add-int/lit8 v1, v1, 0x1

    goto :goto_6

    :cond_38
    sget-object v3, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "("

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ") "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/io/PrintStream;->print(Ljava/lang/String;)V

    goto :goto_35

    .end local v2           #val:Ljava/lang/Object;
    :cond_57
    sget-object v3, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v4, " << \n"

    invoke-virtual {v3, v4}, Ljava/io/PrintStream;->print(Ljava/lang/String;)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .end local v1           #j:I
    :cond_61
    sget-object v3, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v4, "-----\n\n"

    invoke-virtual {v3, v4}, Ljava/io/PrintStream;->print(Ljava/lang/String;)V

    return-void
.end method

.method public getValue(II)Ljava/lang/Object;
    .registers 6
    .parameter "row"
    .parameter "column"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(II)TE;"
        }
    .end annotation

    .prologue
    .local p0, this:Landroid/text/PackedObjectVector;,"Landroid/text/PackedObjectVector<TE;>;"
    iget v1, p0, Landroid/text/PackedObjectVector;->mRowGapStart:I

    if-lt p1, v1, :cond_7

    iget v1, p0, Landroid/text/PackedObjectVector;->mRowGapLength:I

    add-int/2addr p1, v1

    :cond_7
    iget-object v1, p0, Landroid/text/PackedObjectVector;->mValues:[Ljava/lang/Object;

    iget v2, p0, Landroid/text/PackedObjectVector;->mColumns:I

    mul-int/2addr v2, p1

    add-int/2addr v2, p2

    aget-object v0, v1, v2

    .local v0, value:Ljava/lang/Object;
    return-object v0
.end method

.method public insertAt(I[Ljava/lang/Object;)V
    .registers 5
    .parameter "row"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I[TE;)V"
        }
    .end annotation

    .prologue
    .local p0, this:Landroid/text/PackedObjectVector;,"Landroid/text/PackedObjectVector<TE;>;"
    .local p2, values:[Ljava/lang/Object;,"[TE;"
    invoke-direct {p0, p1}, Landroid/text/PackedObjectVector;->moveRowGapTo(I)V

    iget v1, p0, Landroid/text/PackedObjectVector;->mRowGapLength:I

    if-nez v1, :cond_a

    invoke-direct {p0}, Landroid/text/PackedObjectVector;->growBuffer()V

    :cond_a
    iget v1, p0, Landroid/text/PackedObjectVector;->mRowGapStart:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Landroid/text/PackedObjectVector;->mRowGapStart:I

    iget v1, p0, Landroid/text/PackedObjectVector;->mRowGapLength:I

    add-int/lit8 v1, v1, -0x1

    iput v1, p0, Landroid/text/PackedObjectVector;->mRowGapLength:I

    if-nez p2, :cond_24

    const/4 v0, 0x0

    .local v0, i:I
    :goto_19
    iget v1, p0, Landroid/text/PackedObjectVector;->mColumns:I

    if-ge v0, v1, :cond_31

    const/4 v1, 0x0

    invoke-virtual {p0, p1, v0, v1}, Landroid/text/PackedObjectVector;->setValue(IILjava/lang/Object;)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_19

    .end local v0           #i:I
    :cond_24
    const/4 v0, 0x0

    .restart local v0       #i:I
    :goto_25
    iget v1, p0, Landroid/text/PackedObjectVector;->mColumns:I

    if-ge v0, v1, :cond_31

    aget-object v1, p2, v0

    invoke-virtual {p0, p1, v0, v1}, Landroid/text/PackedObjectVector;->setValue(IILjava/lang/Object;)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_25

    :cond_31
    return-void
.end method

.method public setValue(IILjava/lang/Object;)V
    .registers 6
    .parameter "row"
    .parameter "column"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(IITE;)V"
        }
    .end annotation

    .prologue
    .local p0, this:Landroid/text/PackedObjectVector;,"Landroid/text/PackedObjectVector<TE;>;"
    .local p3, value:Ljava/lang/Object;,"TE;"
    iget v0, p0, Landroid/text/PackedObjectVector;->mRowGapStart:I

    if-lt p1, v0, :cond_7

    iget v0, p0, Landroid/text/PackedObjectVector;->mRowGapLength:I

    add-int/2addr p1, v0

    :cond_7
    iget-object v0, p0, Landroid/text/PackedObjectVector;->mValues:[Ljava/lang/Object;

    iget v1, p0, Landroid/text/PackedObjectVector;->mColumns:I

    mul-int/2addr v1, p1

    add-int/2addr v1, p2

    aput-object p3, v0, v1

    return-void
.end method

.method public size()I
    .registers 3

    .prologue
    .local p0, this:Landroid/text/PackedObjectVector;,"Landroid/text/PackedObjectVector<TE;>;"
    iget v0, p0, Landroid/text/PackedObjectVector;->mRows:I

    iget v1, p0, Landroid/text/PackedObjectVector;->mRowGapLength:I

    sub-int/2addr v0, v1

    return v0
.end method

.method public width()I
    .registers 2

    .prologue
    .local p0, this:Landroid/text/PackedObjectVector;,"Landroid/text/PackedObjectVector<TE;>;"
    iget v0, p0, Landroid/text/PackedObjectVector;->mColumns:I

    return v0
.end method
