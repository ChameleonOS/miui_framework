.class Landroid/text/AndroidBidi;
.super Ljava/lang/Object;
.source "AndroidBidi.java"


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 25
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static bidi(I[C[BIZ)I
    .registers 7
    .parameter "dir"
    .parameter "chs"
    .parameter "chInfo"
    .parameter "n"
    .parameter "haveInfo"

    .prologue
    .line 28
    if-eqz p1, :cond_4

    if-nez p2, :cond_a

    .line 29
    :cond_4
    new-instance v1, Ljava/lang/NullPointerException;

    invoke-direct {v1}, Ljava/lang/NullPointerException;-><init>()V

    throw v1

    .line 32
    :cond_a
    if-ltz p3, :cond_12

    array-length v1, p1

    if-lt v1, p3, :cond_12

    array-length v1, p2

    if-ge v1, p3, :cond_18

    .line 33
    :cond_12
    new-instance v1, Ljava/lang/IndexOutOfBoundsException;

    invoke-direct {v1}, Ljava/lang/IndexOutOfBoundsException;-><init>()V

    throw v1

    .line 36
    :cond_18
    packed-switch p0, :pswitch_data_30

    .line 41
    :pswitch_1b
    const/4 p0, 0x0

    .line 44
    :goto_1c
    invoke-static {p0, p1, p2, p3, p4}, Landroid/text/AndroidBidi;->runBidi(I[C[BIZ)I

    move-result v0

    .line 45
    .local v0, result:I
    and-int/lit8 v1, v0, 0x1

    if-nez v1, :cond_2e

    const/4 v0, 0x1

    .line 46
    :goto_25
    return v0

    .line 37
    .end local v0           #result:I
    :pswitch_26
    const/4 p0, 0x0

    goto :goto_1c

    .line 38
    :pswitch_28
    const/4 p0, 0x1

    goto :goto_1c

    .line 39
    :pswitch_2a
    const/4 p0, -0x2

    goto :goto_1c

    .line 40
    :pswitch_2c
    const/4 p0, -0x1

    goto :goto_1c

    .line 45
    .restart local v0       #result:I
    :cond_2e
    const/4 v0, -0x1

    goto :goto_25

    .line 36
    :pswitch_data_30
    .packed-switch -0x2
        :pswitch_2c
        :pswitch_28
        :pswitch_1b
        :pswitch_26
        :pswitch_2a
    .end packed-switch
.end method

.method public static directions(I[BI[CII)Landroid/text/Layout$Directions;
    .registers 29
    .parameter "dir"
    .parameter "levels"
    .parameter "lstart"
    .parameter "chars"
    .parameter "cstart"
    .parameter "len"

    .prologue
    .line 64
    const/16 v21, 0x1

    move/from16 v0, p0

    move/from16 v1, v21

    if-ne v0, v1, :cond_1e

    const/4 v2, 0x0

    .line 65
    .local v2, baseLevel:I
    :goto_9
    aget-byte v4, p1, p2

    .line 66
    .local v4, curLevel:I
    move v13, v4

    .line 67
    .local v13, minLevel:I
    const/16 v17, 0x1

    .line 68
    .local v17, runCount:I
    add-int/lit8 v7, p2, 0x1

    .local v7, i:I
    add-int v5, p2, p5

    .local v5, e:I
    :goto_12
    if-ge v7, v5, :cond_20

    .line 69
    aget-byte v9, p1, v7

    .line 70
    .local v9, level:I
    if-eq v9, v4, :cond_1b

    .line 71
    move v4, v9

    .line 72
    add-int/lit8 v17, v17, 0x1

    .line 68
    :cond_1b
    add-int/lit8 v7, v7, 0x1

    goto :goto_12

    .line 64
    .end local v2           #baseLevel:I
    .end local v4           #curLevel:I
    .end local v5           #e:I
    .end local v7           #i:I
    .end local v9           #level:I
    .end local v13           #minLevel:I
    .end local v17           #runCount:I
    :cond_1e
    const/4 v2, 0x1

    goto :goto_9

    .line 77
    .restart local v2       #baseLevel:I
    .restart local v4       #curLevel:I
    .restart local v5       #e:I
    .restart local v7       #i:I
    .restart local v13       #minLevel:I
    .restart local v17       #runCount:I
    :cond_20
    move/from16 v19, p5

    .line 78
    .local v19, visLen:I
    and-int/lit8 v21, v4, 0x1

    and-int/lit8 v22, v2, 0x1

    move/from16 v0, v21

    move/from16 v1, v22

    if-eq v0, v1, :cond_46

    .line 80
    :cond_2c
    add-int/lit8 v19, v19, -0x1

    if-ltz v19, :cond_3c

    .line 81
    add-int v21, p4, v19

    aget-char v3, p3, v21

    .line 83
    .local v3, ch:C
    const/16 v21, 0xa

    move/from16 v0, v21

    if-ne v3, v0, :cond_57

    .line 84
    add-int/lit8 v19, v19, -0x1

    .line 92
    .end local v3           #ch:C
    :cond_3c
    :goto_3c
    add-int/lit8 v19, v19, 0x1

    .line 93
    move/from16 v0, v19

    move/from16 v1, p5

    if-eq v0, v1, :cond_46

    .line 94
    add-int/lit8 v17, v17, 0x1

    .line 98
    :cond_46
    const/16 v21, 0x1

    move/from16 v0, v17

    move/from16 v1, v21

    if-ne v0, v1, :cond_67

    if-ne v13, v2, :cond_67

    .line 100
    and-int/lit8 v21, v13, 0x1

    if-eqz v21, :cond_64

    .line 101
    sget-object v21, Landroid/text/Layout;->DIRS_ALL_RIGHT_TO_LEFT:Landroid/text/Layout$Directions;

    .line 173
    :goto_56
    return-object v21

    .line 88
    .restart local v3       #ch:C
    :cond_57
    const/16 v21, 0x20

    move/from16 v0, v21

    if-eq v3, v0, :cond_2c

    const/16 v21, 0x9

    move/from16 v0, v21

    if-eq v3, v0, :cond_2c

    goto :goto_3c

    .line 103
    .end local v3           #ch:C
    :cond_64
    sget-object v21, Landroid/text/Layout;->DIRS_ALL_LEFT_TO_RIGHT:Landroid/text/Layout$Directions;

    goto :goto_56

    .line 106
    :cond_67
    mul-int/lit8 v21, v17, 0x2

    move/from16 v0, v21

    new-array v8, v0, [I

    .line 107
    .local v8, ld:[I
    move v12, v13

    .line 108
    .local v12, maxLevel:I
    shl-int/lit8 v10, v13, 0x1a

    .line 113
    .local v10, levelBits:I
    const/4 v14, 0x1

    .line 114
    .local v14, n:I
    move/from16 v16, p2

    .line 115
    .local v16, prev:I
    move v4, v13

    .line 116
    move/from16 v7, p2

    add-int v5, p2, v19

    move v15, v14

    .end local v14           #n:I
    .local v15, n:I
    :goto_79
    if-ge v7, v5, :cond_9e

    .line 117
    aget-byte v9, p1, v7

    .line 118
    .restart local v9       #level:I
    if-eq v9, v4, :cond_136

    .line 119
    move v4, v9

    .line 120
    if-le v9, v12, :cond_9a

    .line 121
    move v12, v9

    .line 126
    :cond_83
    :goto_83
    add-int/lit8 v14, v15, 0x1

    .end local v15           #n:I
    .restart local v14       #n:I
    sub-int v21, v7, v16

    or-int v21, v21, v10

    aput v21, v8, v15

    .line 127
    add-int/lit8 v15, v14, 0x1

    .end local v14           #n:I
    .restart local v15       #n:I
    sub-int v21, v7, p2

    aput v21, v8, v14

    .line 128
    shl-int/lit8 v10, v4, 0x1a

    .line 129
    move/from16 v16, v7

    move v14, v15

    .line 116
    .end local v15           #n:I
    .restart local v14       #n:I
    :goto_96
    add-int/lit8 v7, v7, 0x1

    move v15, v14

    .end local v14           #n:I
    .restart local v15       #n:I
    goto :goto_79

    .line 122
    :cond_9a
    if-ge v9, v13, :cond_83

    .line 123
    move v13, v9

    goto :goto_83

    .line 132
    .end local v9           #level:I
    :cond_9e
    add-int v21, p2, v19

    sub-int v21, v21, v16

    or-int v21, v21, v10

    aput v21, v8, v15

    .line 133
    move/from16 v0, v19

    move/from16 v1, p5

    if-ge v0, v1, :cond_134

    .line 134
    add-int/lit8 v14, v15, 0x1

    .end local v15           #n:I
    .restart local v14       #n:I
    aput v19, v8, v14

    .line 135
    add-int/lit8 v14, v14, 0x1

    sub-int v21, p5, v19

    shl-int/lit8 v22, v2, 0x1a

    or-int v21, v21, v22

    aput v21, v8, v14

    .line 150
    :goto_ba
    and-int/lit8 v21, v13, 0x1

    move/from16 v0, v21

    if-ne v0, v2, :cond_f3

    .line 151
    add-int/lit8 v13, v13, 0x1

    .line 152
    if-le v12, v13, :cond_f0

    const/16 v18, 0x1

    .line 156
    .local v18, swap:Z
    :goto_c6
    if-eqz v18, :cond_12b

    .line 157
    add-int/lit8 v9, v12, -0x1

    .restart local v9       #level:I
    :goto_ca
    if-lt v9, v13, :cond_12b

    .line 158
    const/4 v7, 0x0

    :goto_cd
    array-length v0, v8

    move/from16 v21, v0

    move/from16 v0, v21

    if-ge v7, v0, :cond_128

    .line 159
    aget v21, v8, v7

    aget-byte v21, p1, v21

    move/from16 v0, v21

    if-lt v0, v9, :cond_125

    .line 160
    add-int/lit8 v5, v7, 0x2

    .line 161
    :goto_de
    array-length v0, v8

    move/from16 v21, v0

    move/from16 v0, v21

    if-ge v5, v0, :cond_101

    aget v21, v8, v5

    aget-byte v21, p1, v21

    move/from16 v0, v21

    if-lt v0, v9, :cond_101

    .line 162
    add-int/lit8 v5, v5, 0x2

    goto :goto_de

    .line 152
    .end local v9           #level:I
    .end local v18           #swap:Z
    :cond_f0
    const/16 v18, 0x0

    goto :goto_c6

    .line 154
    :cond_f3
    const/16 v21, 0x1

    move/from16 v0, v17

    move/from16 v1, v21

    if-le v0, v1, :cond_fe

    const/16 v18, 0x1

    .restart local v18       #swap:Z
    :goto_fd
    goto :goto_c6

    .end local v18           #swap:Z
    :cond_fe
    const/16 v18, 0x0

    goto :goto_fd

    .line 164
    .restart local v9       #level:I
    .restart local v18       #swap:Z
    :cond_101
    move v11, v7

    .local v11, low:I
    add-int/lit8 v6, v5, -0x2

    .local v6, hi:I
    :goto_104
    if-ge v11, v6, :cond_123

    .line 165
    aget v20, v8, v11

    .local v20, x:I
    aget v21, v8, v6

    aput v21, v8, v11

    aput v20, v8, v6

    .line 166
    add-int/lit8 v21, v11, 0x1

    aget v20, v8, v21

    add-int/lit8 v21, v11, 0x1

    add-int/lit8 v22, v6, 0x1

    aget v22, v8, v22

    aput v22, v8, v21

    add-int/lit8 v21, v6, 0x1

    aput v20, v8, v21

    .line 164
    add-int/lit8 v11, v11, 0x2

    add-int/lit8 v6, v6, -0x2

    goto :goto_104

    .line 168
    .end local v20           #x:I
    :cond_123
    add-int/lit8 v7, v5, 0x2

    .line 158
    .end local v6           #hi:I
    .end local v11           #low:I
    :cond_125
    add-int/lit8 v7, v7, 0x2

    goto :goto_cd

    .line 157
    :cond_128
    add-int/lit8 v9, v9, -0x1

    goto :goto_ca

    .line 173
    .end local v9           #level:I
    :cond_12b
    new-instance v21, Landroid/text/Layout$Directions;

    move-object/from16 v0, v21

    invoke-direct {v0, v8}, Landroid/text/Layout$Directions;-><init>([I)V

    goto/16 :goto_56

    .end local v14           #n:I
    .end local v18           #swap:Z
    .restart local v15       #n:I
    :cond_134
    move v14, v15

    .end local v15           #n:I
    .restart local v14       #n:I
    goto :goto_ba

    .end local v14           #n:I
    .restart local v9       #level:I
    .restart local v15       #n:I
    :cond_136
    move v14, v15

    .end local v15           #n:I
    .restart local v14       #n:I
    goto/16 :goto_96
.end method

.method private static native runBidi(I[C[BIZ)I
.end method
