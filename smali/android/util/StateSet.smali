.class public Landroid/util/StateSet;
.super Ljava/lang/Object;
.source "StateSet.java"


# static fields
.field public static final NOTHING:[I

.field public static final WILD_CARD:[I


# direct methods
.method static constructor <clinit>()V
    .registers 2

    .prologue
    const/4 v1, 0x0

    new-array v0, v1, [I

    sput-object v0, Landroid/util/StateSet;->WILD_CARD:[I

    const/4 v0, 0x1

    new-array v0, v0, [I

    aput v1, v0, v1

    sput-object v0, Landroid/util/StateSet;->NOTHING:[I

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static dump([I)Ljava/lang/String;
    .registers 5
    .parameter "states"

    .prologue
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .local v2, sb:Ljava/lang/StringBuilder;
    array-length v0, p0

    .local v0, count:I
    const/4 v1, 0x0

    .local v1, i:I
    :goto_7
    if-ge v1, v0, :cond_2f

    aget v3, p0, v1

    sparse-switch v3, :sswitch_data_34

    :goto_e
    add-int/lit8 v1, v1, 0x1

    goto :goto_7

    :sswitch_11
    const-string v3, "W "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_e

    :sswitch_17
    const-string v3, "P "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_e

    :sswitch_1d
    const-string v3, "S "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_e

    :sswitch_23
    const-string v3, "F "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_e

    :sswitch_29
    const-string v3, "E "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_e

    :cond_2f
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3

    :sswitch_data_34
    .sparse-switch
        0x101009c -> :sswitch_23
        0x101009d -> :sswitch_11
        0x101009e -> :sswitch_29
        0x10100a1 -> :sswitch_1d
        0x10100a7 -> :sswitch_17
    .end sparse-switch
.end method

.method public static isWildCard([I)Z
    .registers 3
    .parameter "stateSetOrSpec"

    .prologue
    const/4 v0, 0x0

    array-length v1, p0

    if-eqz v1, :cond_8

    aget v1, p0, v0

    if-nez v1, :cond_9

    :cond_8
    const/4 v0, 0x1

    :cond_9
    return v0
.end method

.method public static stateSetMatches([II)Z
    .registers 8
    .parameter "stateSpec"
    .parameter "state"

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    array-length v1, p0

    .local v1, stateSpecSize:I
    const/4 v0, 0x0

    .local v0, i:I
    :goto_4
    if-ge v0, v1, :cond_a

    aget v2, p0, v0

    .local v2, stateSpecState:I
    if-nez v2, :cond_b

    .end local v2           #stateSpecState:I
    :cond_a
    :goto_a
    return v3

    .restart local v2       #stateSpecState:I
    :cond_b
    if-lez v2, :cond_11

    if-eq p1, v2, :cond_16

    move v3, v4

    goto :goto_a

    :cond_11
    neg-int v5, v2

    if-ne p1, v5, :cond_16

    move v3, v4

    goto :goto_a

    :cond_16
    add-int/lit8 v0, v0, 0x1

    goto :goto_4
.end method

.method public static stateSetMatches([I[I)Z
    .registers 13
    .parameter "stateSpec"
    .parameter "stateSet"

    .prologue
    const/4 v9, 0x1

    const/4 v8, 0x0

    if-nez p1, :cond_e

    if-eqz p0, :cond_c

    invoke-static {p0}, Landroid/util/StateSet;->isWildCard([I)Z

    move-result v10

    if-eqz v10, :cond_d

    :cond_c
    move v8, v9

    :cond_d
    :goto_d
    return v8

    :cond_e
    array-length v6, p0

    .local v6, stateSpecSize:I
    array-length v5, p1

    .local v5, stateSetSize:I
    const/4 v1, 0x0

    .local v1, i:I
    :goto_11
    if-ge v1, v6, :cond_39

    aget v7, p0, v1

    .local v7, stateSpecState:I
    if-nez v7, :cond_19

    move v8, v9

    goto :goto_d

    :cond_19
    if-lez v7, :cond_2d

    const/4 v3, 0x1

    .local v3, mustMatch:Z
    :goto_1c
    const/4 v0, 0x0

    .local v0, found:Z
    const/4 v2, 0x0

    .local v2, j:I
    :goto_1e
    if-ge v2, v5, :cond_26

    aget v4, p1, v2

    .local v4, state:I
    if-nez v4, :cond_30

    if-nez v3, :cond_d

    .end local v4           #state:I
    :cond_26
    :goto_26
    if-eqz v3, :cond_2a

    if-eqz v0, :cond_d

    :cond_2a
    add-int/lit8 v1, v1, 0x1

    goto :goto_11

    .end local v0           #found:Z
    .end local v2           #j:I
    .end local v3           #mustMatch:Z
    :cond_2d
    const/4 v3, 0x0

    .restart local v3       #mustMatch:Z
    neg-int v7, v7

    goto :goto_1c

    .restart local v0       #found:Z
    .restart local v2       #j:I
    .restart local v4       #state:I
    :cond_30
    if-ne v4, v7, :cond_36

    if-eqz v3, :cond_d

    const/4 v0, 0x1

    goto :goto_26

    :cond_36
    add-int/lit8 v2, v2, 0x1

    goto :goto_1e

    .end local v0           #found:Z
    .end local v2           #j:I
    .end local v3           #mustMatch:Z
    .end local v4           #state:I
    .end local v7           #stateSpecState:I
    :cond_39
    move v8, v9

    goto :goto_d
.end method

.method public static trimStateSet([II)[I
    .registers 5
    .parameter "states"
    .parameter "newSize"

    .prologue
    const/4 v2, 0x0

    array-length v1, p0

    if-ne v1, p1, :cond_5

    .end local p0
    :goto_4
    return-object p0

    .restart local p0
    :cond_5
    new-array v0, p1, [I

    .local v0, trimmedStates:[I
    invoke-static {p0, v2, v0, v2, p1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    move-object p0, v0

    goto :goto_4
.end method
