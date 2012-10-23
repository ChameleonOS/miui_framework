.class public Landroid/bluetooth/AtParser;
.super Ljava/lang/Object;
.source "AtParser.java"


# static fields
.field private static final TYPE_ACTION:I = 0x0

.field private static final TYPE_READ:I = 0x1

.field private static final TYPE_SET:I = 0x2

.field private static final TYPE_TEST:I = 0x3


# instance fields
.field private mBasicHandlers:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Character;",
            "Landroid/bluetooth/AtCommandHandler;",
            ">;"
        }
    .end annotation
.end field

.field private mExtHandlers:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Landroid/bluetooth/AtCommandHandler;",
            ">;"
        }
    .end annotation
.end field

.field private mLastInput:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 103
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 104
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroid/bluetooth/AtParser;->mBasicHandlers:Ljava/util/HashMap;

    .line 105
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroid/bluetooth/AtParser;->mExtHandlers:Ljava/util/HashMap;

    .line 106
    const-string v0, ""

    iput-object v0, p0, Landroid/bluetooth/AtParser;->mLastInput:Ljava/lang/String;

    .line 107
    return-void
.end method

.method private static clean(Ljava/lang/String;)Ljava/lang/String;
    .registers 7
    .parameter "input"

    .prologue
    const/16 v5, 0x22

    .line 143
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 145
    .local v3, out:Ljava/lang/StringBuilder;
    const/4 v1, 0x0

    .local v1, i:I
    :goto_c
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v4

    if-ge v1, v4, :cond_2f

    .line 146
    invoke-virtual {p0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 147
    .local v0, c:C
    if-ne v0, v5, :cond_41

    .line 148
    add-int/lit8 v4, v1, 0x1

    invoke-virtual {p0, v5, v4}, Ljava/lang/String;->indexOf(II)I

    move-result v2

    .line 149
    .local v2, j:I
    const/4 v4, -0x1

    if-ne v2, v4, :cond_34

    .line 150
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v4

    invoke-virtual {p0, v1, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 151
    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 161
    .end local v0           #c:C
    .end local v2           #j:I
    :cond_2f
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    return-object v4

    .line 154
    .restart local v0       #c:C
    .restart local v2       #j:I
    :cond_34
    add-int/lit8 v4, v2, 0x1

    invoke-virtual {p0, v1, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 155
    move v1, v2

    .line 145
    .end local v2           #j:I
    :cond_3e
    :goto_3e
    add-int/lit8 v1, v1, 0x1

    goto :goto_c

    .line 156
    :cond_41
    const/16 v4, 0x20

    if-eq v0, v4, :cond_3e

    .line 157
    invoke-static {v0}, Ljava/lang/Character;->toUpperCase(C)C

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_3e
.end method

.method private static findChar(CLjava/lang/String;I)I
    .registers 7
    .parameter "ch"
    .parameter "input"
    .parameter "fromIndex"

    .prologue
    const/16 v3, 0x22

    .line 173
    move v1, p2

    .local v1, i:I
    :goto_3
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v2

    if-ge v1, v2, :cond_24

    .line 174
    invoke-virtual {p1, v1}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 175
    .local v0, c:C
    if-ne v0, v3, :cond_1d

    .line 176
    add-int/lit8 v2, v1, 0x1

    invoke-virtual {p1, v3, v2}, Ljava/lang/String;->indexOf(II)I

    move-result v1

    .line 177
    const/4 v2, -0x1

    if-ne v1, v2, :cond_21

    .line 178
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v2

    .line 184
    .end local v0           #c:C
    :goto_1c
    return v2

    .line 180
    .restart local v0       #c:C
    :cond_1d
    if-ne v0, p0, :cond_21

    move v2, v1

    .line 181
    goto :goto_1c

    .line 173
    :cond_21
    add-int/lit8 v1, v1, 0x1

    goto :goto_3

    .line 184
    .end local v0           #c:C
    :cond_24
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v2

    goto :goto_1c
.end method

.method private static findEndExtendedName(Ljava/lang/String;I)I
    .registers 5
    .parameter "input"
    .parameter "index"

    .prologue
    .line 217
    move v1, p1

    .local v1, i:I
    :goto_1
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    if-ge v1, v2, :cond_20

    .line 218
    invoke-virtual {p0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 222
    .local v0, c:C
    invoke-static {v0}, Landroid/bluetooth/AtParser;->isAtoZ(C)Z

    move-result v2

    if-eqz v2, :cond_14

    .line 217
    :cond_11
    :sswitch_11
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 223
    :cond_14
    const/16 v2, 0x30

    if-lt v0, v2, :cond_1c

    const/16 v2, 0x39

    if-le v0, v2, :cond_11

    .line 224
    :cond_1c
    sparse-switch v0, :sswitch_data_26

    .line 237
    .end local v0           #c:C
    .end local v1           #i:I
    :goto_1f
    return v1

    .restart local v1       #i:I
    :cond_20
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v1

    goto :goto_1f

    .line 224
    nop

    :sswitch_data_26
    .sparse-switch
        0x21 -> :sswitch_11
        0x25 -> :sswitch_11
        0x2d -> :sswitch_11
        0x2e -> :sswitch_11
        0x2f -> :sswitch_11
        0x3a -> :sswitch_11
        0x5f -> :sswitch_11
    .end sparse-switch
.end method

.method private static generateArgs(Ljava/lang/String;)[Ljava/lang/Object;
    .registers 7
    .parameter "input"

    .prologue
    .line 193
    const/4 v2, 0x0

    .line 195
    .local v2, i:I
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 196
    .local v4, out:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Ljava/lang/Object;>;"
    :goto_6
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v5

    if-gt v2, v5, :cond_26

    .line 197
    const/16 v5, 0x2c

    invoke-static {v5, p0, v2}, Landroid/bluetooth/AtParser;->findChar(CLjava/lang/String;I)I

    move-result v3

    .line 199
    .local v3, j:I
    invoke-virtual {p0, v2, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 201
    .local v0, arg:Ljava/lang/String;
    :try_start_16
    new-instance v5, Ljava/lang/Integer;

    invoke-direct {v5, v0}, Ljava/lang/Integer;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_1e
    .catch Ljava/lang/NumberFormatException; {:try_start_16 .. :try_end_1e} :catch_21

    .line 206
    :goto_1e
    add-int/lit8 v2, v3, 0x1

    .line 207
    goto :goto_6

    .line 202
    :catch_21
    move-exception v1

    .line 203
    .local v1, e:Ljava/lang/NumberFormatException;
    invoke-virtual {v4, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1e

    .line 208
    .end local v0           #arg:Ljava/lang/String;
    .end local v1           #e:Ljava/lang/NumberFormatException;
    .end local v3           #j:I
    :cond_26
    invoke-virtual {v4}, Ljava/util/ArrayList;->toArray()[Ljava/lang/Object;

    move-result-object v5

    return-object v5
.end method

.method private static isAtoZ(C)Z
    .registers 2
    .parameter "c"

    .prologue
    .line 165
    const/16 v0, 0x41

    if-lt p0, v0, :cond_a

    const/16 v0, 0x5a

    if-gt p0, v0, :cond_a

    const/4 v0, 0x1

    :goto_9
    return v0

    :cond_a
    const/4 v0, 0x0

    goto :goto_9
.end method


# virtual methods
.method public process(Ljava/lang/String;)Landroid/bluetooth/AtCommandResult;
    .registers 16
    .parameter "raw_input"

    .prologue
    .line 249
    invoke-static {p1}, Landroid/bluetooth/AtParser;->clean(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 252
    .local v7, input:Ljava/lang/String;
    const/4 v10, 0x0

    const-string v11, "A/"

    const/4 v12, 0x0

    const/4 v13, 0x2

    invoke-virtual {v7, v10, v11, v12, v13}, Ljava/lang/String;->regionMatches(ILjava/lang/String;II)Z

    move-result v10

    if-eqz v10, :cond_25

    .line 253
    new-instance v7, Ljava/lang/String;

    .end local v7           #input:Ljava/lang/String;
    iget-object v10, p0, Landroid/bluetooth/AtParser;->mLastInput:Ljava/lang/String;

    invoke-direct {v7, v10}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    .line 259
    .restart local v7       #input:Ljava/lang/String;
    :goto_16
    const-string v10, ""

    invoke-virtual {v7, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_2d

    .line 261
    new-instance v8, Landroid/bluetooth/AtCommandResult;

    const/4 v10, 0x2

    invoke-direct {v8, v10}, Landroid/bluetooth/AtCommandResult;-><init>(I)V

    .line 365
    :cond_24
    :goto_24
    return-object v8

    .line 255
    :cond_25
    new-instance v10, Ljava/lang/String;

    invoke-direct {v10, v7}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    iput-object v10, p0, Landroid/bluetooth/AtParser;->mLastInput:Ljava/lang/String;

    goto :goto_16

    .line 265
    :cond_2d
    const/4 v10, 0x0

    const-string v11, "AT"

    const/4 v12, 0x0

    const/4 v13, 0x2

    invoke-virtual {v7, v10, v11, v12, v13}, Ljava/lang/String;->regionMatches(ILjava/lang/String;II)Z

    move-result v10

    if-nez v10, :cond_3f

    .line 267
    new-instance v8, Landroid/bluetooth/AtCommandResult;

    const/4 v10, 0x1

    invoke-direct {v8, v10}, Landroid/bluetooth/AtCommandResult;-><init>(I)V

    goto :goto_24

    .line 271
    :cond_3f
    const/4 v6, 0x2

    .line 272
    .local v6, index:I
    new-instance v8, Landroid/bluetooth/AtCommandResult;

    const/4 v10, 0x2

    invoke-direct {v8, v10}, Landroid/bluetooth/AtCommandResult;-><init>(I)V

    .line 274
    .local v8, result:Landroid/bluetooth/AtCommandResult;
    :goto_46
    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v10

    if-ge v6, v10, :cond_24

    .line 275
    invoke-virtual {v7, v6}, Ljava/lang/String;->charAt(I)C

    move-result v1

    .line 277
    .local v1, c:C
    invoke-static {v1}, Landroid/bluetooth/AtParser;->isAtoZ(C)Z

    move-result v10

    if-eqz v10, :cond_86

    .line 281
    add-int/lit8 v10, v6, 0x1

    invoke-virtual {v7, v10}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    .line 282
    .local v0, args:Ljava/lang/String;
    iget-object v10, p0, Landroid/bluetooth/AtParser;->mBasicHandlers:Ljava/util/HashMap;

    invoke-static {v1}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_7c

    .line 283
    iget-object v10, p0, Landroid/bluetooth/AtParser;->mBasicHandlers:Ljava/util/HashMap;

    invoke-static {v1}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Landroid/bluetooth/AtCommandHandler;

    invoke-virtual {v10, v0}, Landroid/bluetooth/AtCommandHandler;->handleBasicCommand(Ljava/lang/String;)Landroid/bluetooth/AtCommandResult;

    move-result-object v10

    invoke-virtual {v8, v10}, Landroid/bluetooth/AtCommandResult;->addResult(Landroid/bluetooth/AtCommandResult;)V

    goto :goto_24

    .line 288
    :cond_7c
    new-instance v10, Landroid/bluetooth/AtCommandResult;

    const/4 v11, 0x1

    invoke-direct {v10, v11}, Landroid/bluetooth/AtCommandResult;-><init>(I)V

    invoke-virtual {v8, v10}, Landroid/bluetooth/AtCommandResult;->addResult(Landroid/bluetooth/AtCommandResult;)V

    goto :goto_24

    .line 295
    .end local v0           #args:Ljava/lang/String;
    :cond_86
    const/16 v10, 0x2b

    if-ne v1, v10, :cond_115

    .line 299
    add-int/lit8 v10, v6, 0x1

    invoke-static {v7, v10}, Landroid/bluetooth/AtParser;->findEndExtendedName(Ljava/lang/String;I)I

    move-result v5

    .line 300
    .local v5, i:I
    invoke-virtual {v7, v6, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    .line 301
    .local v2, commandName:Ljava/lang/String;
    iget-object v10, p0, Landroid/bluetooth/AtParser;->mExtHandlers:Ljava/util/HashMap;

    invoke-virtual {v10, v2}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v10

    if-nez v10, :cond_a7

    .line 303
    new-instance v10, Landroid/bluetooth/AtCommandResult;

    const/4 v11, 0x1

    invoke-direct {v10, v11}, Landroid/bluetooth/AtCommandResult;-><init>(I)V

    invoke-virtual {v8, v10}, Landroid/bluetooth/AtCommandResult;->addResult(Landroid/bluetooth/AtCommandResult;)V

    goto/16 :goto_24

    .line 307
    :cond_a7
    iget-object v10, p0, Landroid/bluetooth/AtParser;->mExtHandlers:Ljava/util/HashMap;

    invoke-virtual {v10, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/bluetooth/AtCommandHandler;

    .line 311
    .local v4, handler:Landroid/bluetooth/AtCommandHandler;
    const/16 v10, 0x3b

    invoke-static {v10, v7, v6}, Landroid/bluetooth/AtParser;->findChar(CLjava/lang/String;I)I

    move-result v3

    .line 318
    .local v3, endIndex:I
    if-lt v5, v3, :cond_c3

    .line 319
    const/4 v9, 0x0

    .line 337
    .local v9, type:I
    :goto_b8
    packed-switch v9, :pswitch_data_11a

    .line 353
    :goto_bb
    invoke-virtual {v8}, Landroid/bluetooth/AtCommandResult;->getResultCode()I

    move-result v10

    if-nez v10, :cond_24

    .line 357
    move v6, v3

    .line 358
    goto :goto_46

    .line 320
    .end local v9           #type:I
    :cond_c3
    invoke-virtual {v7, v5}, Ljava/lang/String;->charAt(I)C

    move-result v10

    const/16 v11, 0x3f

    if-ne v10, v11, :cond_cd

    .line 321
    const/4 v9, 0x1

    .restart local v9       #type:I
    goto :goto_b8

    .line 322
    .end local v9           #type:I
    :cond_cd
    invoke-virtual {v7, v5}, Ljava/lang/String;->charAt(I)C

    move-result v10

    const/16 v11, 0x3d

    if-ne v10, v11, :cond_e9

    .line 323
    add-int/lit8 v10, v5, 0x1

    if-ge v10, v3, :cond_e7

    .line 324
    add-int/lit8 v10, v5, 0x1

    invoke-virtual {v7, v10}, Ljava/lang/String;->charAt(I)C

    move-result v10

    const/16 v11, 0x3f

    if-ne v10, v11, :cond_e5

    .line 325
    const/4 v9, 0x3

    .restart local v9       #type:I
    goto :goto_b8

    .line 327
    .end local v9           #type:I
    :cond_e5
    const/4 v9, 0x2

    .restart local v9       #type:I
    goto :goto_b8

    .line 330
    .end local v9           #type:I
    :cond_e7
    const/4 v9, 0x2

    .restart local v9       #type:I
    goto :goto_b8

    .line 333
    .end local v9           #type:I
    :cond_e9
    const/4 v9, 0x0

    .restart local v9       #type:I
    goto :goto_b8

    .line 339
    :pswitch_eb
    invoke-virtual {v4}, Landroid/bluetooth/AtCommandHandler;->handleActionCommand()Landroid/bluetooth/AtCommandResult;

    move-result-object v10

    invoke-virtual {v8, v10}, Landroid/bluetooth/AtCommandResult;->addResult(Landroid/bluetooth/AtCommandResult;)V

    goto :goto_bb

    .line 342
    :pswitch_f3
    invoke-virtual {v4}, Landroid/bluetooth/AtCommandHandler;->handleReadCommand()Landroid/bluetooth/AtCommandResult;

    move-result-object v10

    invoke-virtual {v8, v10}, Landroid/bluetooth/AtCommandResult;->addResult(Landroid/bluetooth/AtCommandResult;)V

    goto :goto_bb

    .line 345
    :pswitch_fb
    invoke-virtual {v4}, Landroid/bluetooth/AtCommandHandler;->handleTestCommand()Landroid/bluetooth/AtCommandResult;

    move-result-object v10

    invoke-virtual {v8, v10}, Landroid/bluetooth/AtCommandResult;->addResult(Landroid/bluetooth/AtCommandResult;)V

    goto :goto_bb

    .line 348
    :pswitch_103
    add-int/lit8 v10, v5, 0x1

    invoke-virtual {v7, v10, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Landroid/bluetooth/AtParser;->generateArgs(Ljava/lang/String;)[Ljava/lang/Object;

    move-result-object v0

    .line 350
    .local v0, args:[Ljava/lang/Object;
    invoke-virtual {v4, v0}, Landroid/bluetooth/AtCommandHandler;->handleSetCommand([Ljava/lang/Object;)Landroid/bluetooth/AtCommandResult;

    move-result-object v10

    invoke-virtual {v8, v10}, Landroid/bluetooth/AtCommandResult;->addResult(Landroid/bluetooth/AtCommandResult;)V

    goto :goto_bb

    .line 361
    .end local v0           #args:[Ljava/lang/Object;
    .end local v2           #commandName:Ljava/lang/String;
    .end local v3           #endIndex:I
    .end local v4           #handler:Landroid/bluetooth/AtCommandHandler;
    .end local v5           #i:I
    .end local v9           #type:I
    :cond_115
    add-int/lit8 v6, v6, 0x1

    goto/16 :goto_46

    .line 337
    nop

    :pswitch_data_11a
    .packed-switch 0x0
        :pswitch_eb
        :pswitch_f3
        :pswitch_103
        :pswitch_fb
    .end packed-switch
.end method

.method public register(Ljava/lang/Character;Landroid/bluetooth/AtCommandHandler;)V
    .registers 4
    .parameter "command"
    .parameter "handler"

    .prologue
    .line 117
    iget-object v0, p0, Landroid/bluetooth/AtParser;->mBasicHandlers:Ljava/util/HashMap;

    invoke-virtual {v0, p1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 118
    return-void
.end method

.method public register(Ljava/lang/String;Landroid/bluetooth/AtCommandHandler;)V
    .registers 4
    .parameter "command"
    .parameter "handler"

    .prologue
    .line 133
    iget-object v0, p0, Landroid/bluetooth/AtParser;->mExtHandlers:Ljava/util/HashMap;

    invoke-virtual {v0, p1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 134
    return-void
.end method
