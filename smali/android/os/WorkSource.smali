.class public Landroid/os/WorkSource;
.super Ljava/lang/Object;
.source "WorkSource.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Landroid/os/WorkSource;",
            ">;"
        }
    .end annotation
.end field

.field static sGoneWork:Landroid/os/WorkSource;

.field static sNewbWork:Landroid/os/WorkSource;

.field static final sTmpWorkSource:Landroid/os/WorkSource;


# instance fields
.field mNum:I

.field mUids:[I


# direct methods
.method static constructor <clinit>()V
    .registers 2

    .prologue
    .line 17
    new-instance v0, Landroid/os/WorkSource;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Landroid/os/WorkSource;-><init>(I)V

    sput-object v0, Landroid/os/WorkSource;->sTmpWorkSource:Landroid/os/WorkSource;

    .line 302
    new-instance v0, Landroid/os/WorkSource$1;

    invoke-direct {v0}, Landroid/os/WorkSource$1;-><init>()V

    sput-object v0, Landroid/os/WorkSource;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .registers 2

    .prologue
    .line 30
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 31
    const/4 v0, 0x0

    iput v0, p0, Landroid/os/WorkSource;->mNum:I

    .line 32
    return-void
.end method

.method public constructor <init>(I)V
    .registers 5
    .parameter "uid"

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 52
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 53
    iput v2, p0, Landroid/os/WorkSource;->mNum:I

    .line 54
    const/4 v0, 0x2

    new-array v0, v0, [I

    aput p1, v0, v1

    aput v1, v0, v2

    iput-object v0, p0, Landroid/os/WorkSource;->mUids:[I

    .line 55
    return-void
.end method

.method constructor <init>(Landroid/os/Parcel;)V
    .registers 3
    .parameter "in"

    .prologue
    .line 57
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 58
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/os/WorkSource;->mNum:I

    .line 59
    invoke-virtual {p1}, Landroid/os/Parcel;->createIntArray()[I

    move-result-object v0

    iput-object v0, p0, Landroid/os/WorkSource;->mUids:[I

    .line 60
    return-void
.end method

.method public constructor <init>(Landroid/os/WorkSource;)V
    .registers 3
    .parameter "orig"

    .prologue
    .line 38
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 39
    if-nez p1, :cond_9

    .line 40
    const/4 v0, 0x0

    iput v0, p0, Landroid/os/WorkSource;->mNum:I

    .line 49
    :goto_8
    return-void

    .line 43
    :cond_9
    iget v0, p1, Landroid/os/WorkSource;->mNum:I

    iput v0, p0, Landroid/os/WorkSource;->mNum:I

    .line 44
    iget-object v0, p1, Landroid/os/WorkSource;->mUids:[I

    if-eqz v0, :cond_1c

    .line 45
    iget-object v0, p1, Landroid/os/WorkSource;->mUids:[I

    invoke-virtual {v0}, [I->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [I

    iput-object v0, p0, Landroid/os/WorkSource;->mUids:[I

    goto :goto_8

    .line 47
    :cond_1c
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/os/WorkSource;->mUids:[I

    goto :goto_8
.end method

.method private addLocked(I)V
    .registers 6
    .parameter "uid"

    .prologue
    const/4 v3, 0x0

    .line 275
    iget-object v1, p0, Landroid/os/WorkSource;->mUids:[I

    if-nez v1, :cond_12

    .line 276
    const/4 v1, 0x4

    new-array v1, v1, [I

    iput-object v1, p0, Landroid/os/WorkSource;->mUids:[I

    .line 277
    iget-object v1, p0, Landroid/os/WorkSource;->mUids:[I

    aput p1, v1, v3

    .line 278
    const/4 v1, 0x1

    iput v1, p0, Landroid/os/WorkSource;->mNum:I

    .line 289
    :goto_11
    return-void

    .line 281
    :cond_12
    iget v1, p0, Landroid/os/WorkSource;->mNum:I

    iget-object v2, p0, Landroid/os/WorkSource;->mUids:[I

    array-length v2, v2

    if-lt v1, v2, :cond_2a

    .line 282
    iget v1, p0, Landroid/os/WorkSource;->mNum:I

    mul-int/lit8 v1, v1, 0x3

    div-int/lit8 v1, v1, 0x2

    new-array v0, v1, [I

    .line 283
    .local v0, newuids:[I
    iget-object v1, p0, Landroid/os/WorkSource;->mUids:[I

    iget v2, p0, Landroid/os/WorkSource;->mNum:I

    invoke-static {v1, v3, v0, v3, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 284
    iput-object v0, p0, Landroid/os/WorkSource;->mUids:[I

    .line 287
    .end local v0           #newuids:[I
    :cond_2a
    iget-object v1, p0, Landroid/os/WorkSource;->mUids:[I

    iget v2, p0, Landroid/os/WorkSource;->mNum:I

    aput p1, v1, v2

    .line 288
    iget v1, p0, Landroid/os/WorkSource;->mNum:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Landroid/os/WorkSource;->mNum:I

    goto :goto_11
.end method

.method private updateLocked(Landroid/os/WorkSource;ZZ)Z
    .registers 16
    .parameter "other"
    .parameter "set"
    .parameter "returnNewbs"

    .prologue
    const/4 v11, 0x0

    .line 206
    iget v0, p0, Landroid/os/WorkSource;->mNum:I

    .line 207
    .local v0, N1:I
    iget-object v7, p0, Landroid/os/WorkSource;->mUids:[I

    .line 208
    .local v7, uids1:[I
    iget v1, p1, Landroid/os/WorkSource;->mNum:I

    .line 209
    .local v1, N2:I
    iget-object v8, p1, Landroid/os/WorkSource;->mUids:[I

    .line 210
    .local v8, uids2:[I
    const/4 v2, 0x0

    .line 211
    .local v2, changed:Z
    const/4 v3, 0x0

    .line 212
    .local v3, i1:I
    const/4 v4, 0x0

    .local v4, i2:I
    :goto_c
    if-ge v4, v1, :cond_ae

    .line 213
    if-ge v3, v0, :cond_16

    aget v9, v8, v4

    aget v10, v7, v3

    if-ge v9, v10, :cond_6a

    .line 215
    :cond_16
    const/4 v2, 0x1

    .line 216
    if-nez v7, :cond_36

    .line 217
    const/4 v9, 0x4

    new-array v7, v9, [I

    .line 218
    aget v9, v8, v4

    aput v9, v7, v11

    .line 229
    :goto_20
    if-eqz p3, :cond_2f

    .line 230
    sget-object v9, Landroid/os/WorkSource;->sNewbWork:Landroid/os/WorkSource;

    if-nez v9, :cond_62

    .line 231
    new-instance v9, Landroid/os/WorkSource;

    aget v10, v8, v4

    invoke-direct {v9, v10}, Landroid/os/WorkSource;-><init>(I)V

    sput-object v9, Landroid/os/WorkSource;->sNewbWork:Landroid/os/WorkSource;

    .line 236
    :cond_2f
    :goto_2f
    add-int/lit8 v0, v0, 0x1

    .line 237
    add-int/lit8 v3, v3, 0x1

    .line 212
    :cond_33
    :goto_33
    add-int/lit8 v4, v4, 0x1

    goto :goto_c

    .line 219
    :cond_36
    array-length v9, v7

    if-lt v3, v9, :cond_54

    .line 220
    array-length v9, v7

    mul-int/lit8 v9, v9, 0x3

    div-int/lit8 v9, v9, 0x2

    new-array v5, v9, [I

    .line 221
    .local v5, newuids:[I
    if-lez v3, :cond_45

    invoke-static {v7, v11, v5, v11, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 222
    :cond_45
    if-ge v3, v0, :cond_4e

    add-int/lit8 v9, v3, 0x1

    sub-int v10, v0, v3

    invoke-static {v7, v3, v5, v9, v10}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 223
    :cond_4e
    move-object v7, v5

    .line 224
    aget v9, v8, v4

    aput v9, v7, v3

    goto :goto_20

    .line 226
    .end local v5           #newuids:[I
    :cond_54
    if-ge v3, v0, :cond_5d

    add-int/lit8 v9, v3, 0x1

    sub-int v10, v0, v3

    invoke-static {v7, v3, v7, v9, v10}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 227
    :cond_5d
    aget v9, v8, v4

    aput v9, v7, v3

    goto :goto_20

    .line 233
    :cond_62
    sget-object v9, Landroid/os/WorkSource;->sNewbWork:Landroid/os/WorkSource;

    aget v10, v8, v4

    invoke-direct {v9, v10}, Landroid/os/WorkSource;->addLocked(I)V

    goto :goto_2f

    .line 239
    :cond_6a
    if-nez p2, :cond_77

    .line 242
    :cond_6c
    add-int/lit8 v3, v3, 0x1

    .line 243
    if-ge v3, v0, :cond_33

    aget v9, v8, v4

    aget v10, v7, v3

    if-ge v9, v10, :cond_6c

    goto :goto_33

    .line 246
    :cond_77
    move v6, v3

    .line 247
    .local v6, start:I
    :goto_78
    if-ge v3, v0, :cond_98

    aget v9, v8, v4

    aget v10, v7, v3

    if-le v9, v10, :cond_98

    .line 248
    sget-object v9, Landroid/os/WorkSource;->sGoneWork:Landroid/os/WorkSource;

    if-nez v9, :cond_90

    .line 249
    new-instance v9, Landroid/os/WorkSource;

    aget v10, v7, v3

    invoke-direct {v9, v10}, Landroid/os/WorkSource;-><init>(I)V

    sput-object v9, Landroid/os/WorkSource;->sGoneWork:Landroid/os/WorkSource;

    .line 253
    :goto_8d
    add-int/lit8 v3, v3, 0x1

    goto :goto_78

    .line 251
    :cond_90
    sget-object v9, Landroid/os/WorkSource;->sGoneWork:Landroid/os/WorkSource;

    aget v10, v7, v3

    invoke-direct {v9, v10}, Landroid/os/WorkSource;->addLocked(I)V

    goto :goto_8d

    .line 255
    :cond_98
    if-ge v6, v3, :cond_a3

    .line 256
    sub-int v9, v3, v6

    invoke-static {v7, v3, v7, v6, v9}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 257
    sub-int v9, v3, v6

    sub-int/2addr v0, v9

    .line 258
    move v3, v6

    .line 261
    :cond_a3
    if-ge v3, v0, :cond_33

    aget v9, v8, v3

    aget v10, v7, v3

    if-ne v9, v10, :cond_33

    .line 262
    add-int/lit8 v3, v3, 0x1

    goto :goto_33

    .line 268
    .end local v6           #start:I
    :cond_ae
    iput v0, p0, Landroid/os/WorkSource;->mNum:I

    .line 269
    iput-object v7, p0, Landroid/os/WorkSource;->mUids:[I

    .line 271
    return v2
.end method


# virtual methods
.method public add(I)Z
    .registers 6
    .parameter "uid"

    .prologue
    .line 167
    sget-object v1, Landroid/os/WorkSource;->sTmpWorkSource:Landroid/os/WorkSource;

    monitor-enter v1

    .line 168
    :try_start_3
    sget-object v0, Landroid/os/WorkSource;->sTmpWorkSource:Landroid/os/WorkSource;

    iget-object v0, v0, Landroid/os/WorkSource;->mUids:[I

    const/4 v2, 0x0

    aput p1, v0, v2

    .line 169
    sget-object v0, Landroid/os/WorkSource;->sTmpWorkSource:Landroid/os/WorkSource;

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-direct {p0, v0, v2, v3}, Landroid/os/WorkSource;->updateLocked(Landroid/os/WorkSource;ZZ)Z

    move-result v0

    monitor-exit v1

    return v0

    .line 170
    :catchall_14
    move-exception v0

    monitor-exit v1
    :try_end_16
    .catchall {:try_start_3 .. :try_end_16} :catchall_14

    throw v0
.end method

.method public add(Landroid/os/WorkSource;)Z
    .registers 5
    .parameter "other"

    .prologue
    .line 151
    sget-object v1, Landroid/os/WorkSource;->sTmpWorkSource:Landroid/os/WorkSource;

    monitor-enter v1

    .line 152
    const/4 v0, 0x0

    const/4 v2, 0x0

    :try_start_5
    invoke-direct {p0, p1, v0, v2}, Landroid/os/WorkSource;->updateLocked(Landroid/os/WorkSource;ZZ)Z

    move-result v0

    monitor-exit v1

    return v0

    .line 153
    :catchall_b
    move-exception v0

    monitor-exit v1
    :try_end_d
    .catchall {:try_start_5 .. :try_end_d} :catchall_b

    throw v0
.end method

.method public addReturningNewbs(I)Landroid/os/WorkSource;
    .registers 6
    .parameter "uid"

    .prologue
    .line 175
    sget-object v1, Landroid/os/WorkSource;->sTmpWorkSource:Landroid/os/WorkSource;

    monitor-enter v1

    .line 176
    const/4 v0, 0x0

    :try_start_4
    sput-object v0, Landroid/os/WorkSource;->sNewbWork:Landroid/os/WorkSource;

    .line 177
    sget-object v0, Landroid/os/WorkSource;->sTmpWorkSource:Landroid/os/WorkSource;

    iget-object v0, v0, Landroid/os/WorkSource;->mUids:[I

    const/4 v2, 0x0

    aput p1, v0, v2

    .line 178
    sget-object v0, Landroid/os/WorkSource;->sTmpWorkSource:Landroid/os/WorkSource;

    const/4 v2, 0x0

    const/4 v3, 0x1

    invoke-direct {p0, v0, v2, v3}, Landroid/os/WorkSource;->updateLocked(Landroid/os/WorkSource;ZZ)Z

    .line 179
    sget-object v0, Landroid/os/WorkSource;->sNewbWork:Landroid/os/WorkSource;

    monitor-exit v1

    return-object v0

    .line 180
    :catchall_18
    move-exception v0

    monitor-exit v1
    :try_end_1a
    .catchall {:try_start_4 .. :try_end_1a} :catchall_18

    throw v0
.end method

.method public addReturningNewbs(Landroid/os/WorkSource;)Landroid/os/WorkSource;
    .registers 5
    .parameter "other"

    .prologue
    .line 158
    sget-object v1, Landroid/os/WorkSource;->sTmpWorkSource:Landroid/os/WorkSource;

    monitor-enter v1

    .line 159
    const/4 v0, 0x0

    :try_start_4
    sput-object v0, Landroid/os/WorkSource;->sNewbWork:Landroid/os/WorkSource;

    .line 160
    const/4 v0, 0x0

    const/4 v2, 0x1

    invoke-direct {p0, p1, v0, v2}, Landroid/os/WorkSource;->updateLocked(Landroid/os/WorkSource;ZZ)Z

    .line 161
    sget-object v0, Landroid/os/WorkSource;->sNewbWork:Landroid/os/WorkSource;

    monitor-exit v1

    return-object v0

    .line 162
    :catchall_f
    move-exception v0

    monitor-exit v1
    :try_end_11
    .catchall {:try_start_4 .. :try_end_11} :catchall_f

    throw v0
.end method

.method public clear()V
    .registers 2

    .prologue
    .line 76
    const/4 v0, 0x0

    iput v0, p0, Landroid/os/WorkSource;->mNum:I

    .line 77
    return-void
.end method

.method public describeContents()I
    .registers 2

    .prologue
    .line 293
    const/4 v0, 0x0

    return v0
.end method

.method public diff(Landroid/os/WorkSource;)Z
    .registers 9
    .parameter "other"

    .prologue
    const/4 v4, 0x1

    .line 85
    iget v0, p0, Landroid/os/WorkSource;->mNum:I

    .line 86
    .local v0, N:I
    iget v5, p1, Landroid/os/WorkSource;->mNum:I

    if-eq v0, v5, :cond_8

    .line 96
    :cond_7
    :goto_7
    return v4

    .line 89
    :cond_8
    iget-object v2, p0, Landroid/os/WorkSource;->mUids:[I

    .line 90
    .local v2, uids1:[I
    iget-object v3, p1, Landroid/os/WorkSource;->mUids:[I

    .line 91
    .local v3, uids2:[I
    const/4 v1, 0x0

    .local v1, i:I
    :goto_d
    if-ge v1, v0, :cond_18

    .line 92
    aget v5, v2, v1

    aget v6, v3, v1

    if-ne v5, v6, :cond_7

    .line 91
    add-int/lit8 v1, v1, 0x1

    goto :goto_d

    .line 96
    :cond_18
    const/4 v4, 0x0

    goto :goto_7
.end method

.method public get(I)I
    .registers 3
    .parameter "index"

    .prologue
    .line 69
    iget-object v0, p0, Landroid/os/WorkSource;->mUids:[I

    aget v0, v0, p1

    return v0
.end method

.method public remove(Landroid/os/WorkSource;)Z
    .registers 11
    .parameter "other"

    .prologue
    .line 184
    iget v0, p0, Landroid/os/WorkSource;->mNum:I

    .line 185
    .local v0, N1:I
    iget-object v5, p0, Landroid/os/WorkSource;->mUids:[I

    .line 186
    .local v5, uids1:[I
    iget v1, p1, Landroid/os/WorkSource;->mNum:I

    .line 187
    .local v1, N2:I
    iget-object v6, p1, Landroid/os/WorkSource;->mUids:[I

    .line 188
    .local v6, uids2:[I
    const/4 v2, 0x0

    .line 189
    .local v2, changed:Z
    const/4 v3, 0x0

    .line 190
    .local v3, i1:I
    const/4 v4, 0x0

    .local v4, i2:I
    :goto_b
    if-ge v4, v1, :cond_2e

    if-ge v3, v0, :cond_2e

    .line 191
    aget v7, v6, v4

    aget v8, v5, v3

    if-ne v7, v8, :cond_20

    .line 192
    add-int/lit8 v0, v0, -0x1

    .line 193
    if-ge v3, v0, :cond_20

    add-int/lit8 v7, v3, 0x1

    sub-int v8, v0, v3

    invoke-static {v5, v7, v5, v3, v8}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 195
    :cond_20
    :goto_20
    if-ge v3, v0, :cond_2b

    aget v7, v6, v4

    aget v8, v5, v3

    if-le v7, v8, :cond_2b

    .line 196
    add-int/lit8 v3, v3, 0x1

    goto :goto_20

    .line 190
    :cond_2b
    add-int/lit8 v4, v4, 0x1

    goto :goto_b

    .line 200
    :cond_2e
    iput v0, p0, Landroid/os/WorkSource;->mNum:I

    .line 202
    return v2
.end method

.method public set(I)V
    .registers 4
    .parameter "uid"

    .prologue
    .line 123
    const/4 v0, 0x1

    iput v0, p0, Landroid/os/WorkSource;->mNum:I

    .line 124
    iget-object v0, p0, Landroid/os/WorkSource;->mUids:[I

    if-nez v0, :cond_c

    const/4 v0, 0x2

    new-array v0, v0, [I

    iput-object v0, p0, Landroid/os/WorkSource;->mUids:[I

    .line 125
    :cond_c
    iget-object v0, p0, Landroid/os/WorkSource;->mUids:[I

    const/4 v1, 0x0

    aput p1, v0, v1

    .line 126
    return-void
.end method

.method public set(Landroid/os/WorkSource;)V
    .registers 6
    .parameter "other"

    .prologue
    const/4 v3, 0x0

    .line 105
    if-nez p1, :cond_6

    .line 106
    iput v3, p0, Landroid/os/WorkSource;->mNum:I

    .line 119
    :goto_5
    return-void

    .line 109
    :cond_6
    iget v0, p1, Landroid/os/WorkSource;->mNum:I

    iput v0, p0, Landroid/os/WorkSource;->mNum:I

    .line 110
    iget-object v0, p1, Landroid/os/WorkSource;->mUids:[I

    if-eqz v0, :cond_2e

    .line 111
    iget-object v0, p0, Landroid/os/WorkSource;->mUids:[I

    if-eqz v0, :cond_23

    iget-object v0, p0, Landroid/os/WorkSource;->mUids:[I

    array-length v0, v0

    iget v1, p0, Landroid/os/WorkSource;->mNum:I

    if-lt v0, v1, :cond_23

    .line 112
    iget-object v0, p1, Landroid/os/WorkSource;->mUids:[I

    iget-object v1, p0, Landroid/os/WorkSource;->mUids:[I

    iget v2, p0, Landroid/os/WorkSource;->mNum:I

    invoke-static {v0, v3, v1, v3, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    goto :goto_5

    .line 114
    :cond_23
    iget-object v0, p1, Landroid/os/WorkSource;->mUids:[I

    invoke-virtual {v0}, [I->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [I

    iput-object v0, p0, Landroid/os/WorkSource;->mUids:[I

    goto :goto_5

    .line 117
    :cond_2e
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/os/WorkSource;->mUids:[I

    goto :goto_5
.end method

.method public setReturningDiffs(Landroid/os/WorkSource;)[Landroid/os/WorkSource;
    .registers 6
    .parameter "other"

    .prologue
    const/4 v0, 0x0

    .line 130
    sget-object v2, Landroid/os/WorkSource;->sTmpWorkSource:Landroid/os/WorkSource;

    monitor-enter v2

    .line 131
    const/4 v1, 0x0

    :try_start_5
    sput-object v1, Landroid/os/WorkSource;->sNewbWork:Landroid/os/WorkSource;

    .line 132
    const/4 v1, 0x0

    sput-object v1, Landroid/os/WorkSource;->sGoneWork:Landroid/os/WorkSource;

    .line 133
    const/4 v1, 0x1

    const/4 v3, 0x1

    invoke-direct {p0, p1, v1, v3}, Landroid/os/WorkSource;->updateLocked(Landroid/os/WorkSource;ZZ)Z

    .line 134
    sget-object v1, Landroid/os/WorkSource;->sNewbWork:Landroid/os/WorkSource;

    if-nez v1, :cond_17

    sget-object v1, Landroid/os/WorkSource;->sGoneWork:Landroid/os/WorkSource;

    if-eqz v1, :cond_26

    .line 135
    :cond_17
    const/4 v1, 0x2

    new-array v0, v1, [Landroid/os/WorkSource;

    .line 136
    .local v0, diffs:[Landroid/os/WorkSource;
    const/4 v1, 0x0

    sget-object v3, Landroid/os/WorkSource;->sNewbWork:Landroid/os/WorkSource;

    aput-object v3, v0, v1

    .line 137
    const/4 v1, 0x1

    sget-object v3, Landroid/os/WorkSource;->sGoneWork:Landroid/os/WorkSource;

    aput-object v3, v0, v1

    .line 138
    monitor-exit v2

    .line 140
    .end local v0           #diffs:[Landroid/os/WorkSource;
    :goto_25
    return-object v0

    :cond_26
    monitor-exit v2

    goto :goto_25

    .line 141
    :catchall_28
    move-exception v1

    monitor-exit v2
    :try_end_2a
    .catchall {:try_start_5 .. :try_end_2a} :catchall_28

    throw v1
.end method

.method public size()I
    .registers 2

    .prologue
    .line 64
    iget v0, p0, Landroid/os/WorkSource;->mNum:I

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 4
    .parameter "dest"
    .parameter "flags"

    .prologue
    .line 298
    iget v0, p0, Landroid/os/WorkSource;->mNum:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 299
    iget-object v0, p0, Landroid/os/WorkSource;->mUids:[I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeIntArray([I)V

    .line 300
    return-void
.end method
