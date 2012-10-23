.class public Landroid/security/KeyStore;
.super Ljava/lang/Object;
.source "KeyStore.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/security/KeyStore$State;
    }
.end annotation


# static fields
.field public static final KEY_NOT_FOUND:I = 0x7

.field public static final LOCKED:I = 0x2

.field public static final NO_ERROR:I = 0x1

.field public static final PERMISSION_DENIED:I = 0x6

.field public static final PROTOCOL_ERROR:I = 0x5

.field public static final SYSTEM_ERROR:I = 0x4

.field public static final UNDEFINED_ACTION:I = 0x9

.field public static final UNINITIALIZED:I = 0x3

.field public static final VALUE_CORRUPTED:I = 0x8

.field public static final WRONG_PASSWORD:I = 0xa

.field private static final sAddress:Landroid/net/LocalSocketAddress;


# instance fields
.field private mError:I


# direct methods
.method static constructor <clinit>()V
    .registers 3

    .prologue
    .line 51
    new-instance v0, Landroid/net/LocalSocketAddress;

    const-string v1, "keystore"

    sget-object v2, Landroid/net/LocalSocketAddress$Namespace;->RESERVED:Landroid/net/LocalSocketAddress$Namespace;

    invoke-direct {v0, v1, v2}, Landroid/net/LocalSocketAddress;-><init>(Ljava/lang/String;Landroid/net/LocalSocketAddress$Namespace;)V

    sput-object v0, Landroid/security/KeyStore;->sAddress:Landroid/net/LocalSocketAddress;

    return-void
.end method

.method private constructor <init>()V
    .registers 2

    .prologue
    .line 56
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 54
    const/4 v0, 0x1

    iput v0, p0, Landroid/security/KeyStore;->mError:I

    .line 56
    return-void
.end method

.method private contains([B)Z
    .registers 6
    .parameter "key"

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x1

    .line 100
    const/16 v2, 0x65

    new-array v3, v0, [[B

    aput-object p1, v3, v1

    invoke-direct {p0, v2, v3}, Landroid/security/KeyStore;->execute(I[[B)Ljava/util/ArrayList;

    .line 101
    iget v2, p0, Landroid/security/KeyStore;->mError:I

    if-ne v2, v0, :cond_10

    :goto_f
    return v0

    :cond_10
    move v0, v1

    goto :goto_f
.end method

.method private delKey([B)Z
    .registers 6
    .parameter "key"

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x1

    .line 186
    const/16 v2, 0x6b

    new-array v3, v0, [[B

    aput-object p1, v3, v1

    invoke-direct {p0, v2, v3}, Landroid/security/KeyStore;->execute(I[[B)Ljava/util/ArrayList;

    .line 187
    iget v2, p0, Landroid/security/KeyStore;->mError:I

    if-ne v2, v0, :cond_10

    :goto_f
    return v0

    :cond_10
    move v0, v1

    goto :goto_f
.end method

.method private delete([B)Z
    .registers 6
    .parameter "key"

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x1

    .line 91
    const/16 v2, 0x64

    new-array v3, v0, [[B

    aput-object p1, v3, v1

    invoke-direct {p0, v2, v3}, Landroid/security/KeyStore;->execute(I[[B)Ljava/util/ArrayList;

    .line 92
    iget v2, p0, Landroid/security/KeyStore;->mError:I

    if-ne v2, v0, :cond_10

    :goto_f
    return v0

    :cond_10
    move v0, v1

    goto :goto_f
.end method

.method private varargs execute(I[[B)Ljava/util/ArrayList;
    .registers 16
    .parameter "code"
    .parameter "parameters"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I[[B)",
            "Ljava/util/ArrayList",
            "<[B>;"
        }
    .end annotation

    .prologue
    .line 235
    const/4 v11, 0x5

    iput v11, p0, Landroid/security/KeyStore;->mError:I

    .line 237
    move-object v0, p2

    .local v0, arr$:[[B
    array-length v5, v0

    .local v5, len$:I
    const/4 v2, 0x0

    .local v2, i$:I
    :goto_6
    if-ge v2, v5, :cond_17

    aget-object v7, v0, v2

    .line 238
    .local v7, parameter:[B
    if-eqz v7, :cond_12

    array-length v11, v7

    const v12, 0xffff

    if-le v11, v12, :cond_14

    .line 239
    :cond_12
    const/4 v10, 0x0

    .line 291
    .end local v7           #parameter:[B
    :goto_13
    return-object v10

    .line 237
    .restart local v7       #parameter:[B
    :cond_14
    add-int/lit8 v2, v2, 0x1

    goto :goto_6

    .line 243
    .end local v7           #parameter:[B
    :cond_17
    new-instance v8, Landroid/net/LocalSocket;

    invoke-direct {v8}, Landroid/net/LocalSocket;-><init>()V

    .line 245
    .local v8, socket:Landroid/net/LocalSocket;
    :try_start_1c
    sget-object v11, Landroid/security/KeyStore;->sAddress:Landroid/net/LocalSocketAddress;

    invoke-virtual {v8, v11}, Landroid/net/LocalSocket;->connect(Landroid/net/LocalSocketAddress;)V

    .line 247
    invoke-virtual {v8}, Landroid/net/LocalSocket;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v6

    .line 248
    .local v6, out:Ljava/io/OutputStream;
    invoke-virtual {v6, p1}, Ljava/io/OutputStream;->write(I)V

    .line 249
    move-object v0, p2

    array-length v5, v0

    const/4 v2, 0x0

    :goto_2b
    if-ge v2, v5, :cond_3f

    aget-object v7, v0, v2

    .line 250
    .restart local v7       #parameter:[B
    array-length v11, v7

    shr-int/lit8 v11, v11, 0x8

    invoke-virtual {v6, v11}, Ljava/io/OutputStream;->write(I)V

    .line 251
    array-length v11, v7

    invoke-virtual {v6, v11}, Ljava/io/OutputStream;->write(I)V

    .line 252
    invoke-virtual {v6, v7}, Ljava/io/OutputStream;->write([B)V

    .line 249
    add-int/lit8 v2, v2, 0x1

    goto :goto_2b

    .line 254
    .end local v7           #parameter:[B
    :cond_3f
    invoke-virtual {v6}, Ljava/io/OutputStream;->flush()V

    .line 255
    invoke-virtual {v8}, Landroid/net/LocalSocket;->shutdownOutput()V

    .line 257
    invoke-virtual {v8}, Landroid/net/LocalSocket;->getInputStream()Ljava/io/InputStream;

    move-result-object v3

    .line 258
    .local v3, in:Ljava/io/InputStream;
    invoke-virtual {v3}, Ljava/io/InputStream;->read()I

    move-result p1

    const/4 v11, 0x1

    if-eq p1, v11, :cond_5c

    .line 259
    const/4 v11, -0x1

    if-eq p1, v11, :cond_55

    .line 260
    iput p1, p0, Landroid/security/KeyStore;->mError:I
    :try_end_55
    .catchall {:try_start_1c .. :try_end_55} :catchall_9f
    .catch Ljava/io/IOException; {:try_start_1c .. :try_end_55} :catch_98

    .line 262
    :cond_55
    const/4 v10, 0x0

    .line 288
    :try_start_56
    invoke-virtual {v8}, Landroid/net/LocalSocket;->close()V
    :try_end_59
    .catch Ljava/io/IOException; {:try_start_56 .. :try_end_59} :catch_5a

    goto :goto_13

    .line 289
    :catch_5a
    move-exception v11

    goto :goto_13

    .line 265
    :cond_5c
    :try_start_5c
    new-instance v10, Ljava/util/ArrayList;

    invoke-direct {v10}, Ljava/util/ArrayList;-><init>()V

    .line 268
    .local v10, values:Ljava/util/ArrayList;,"Ljava/util/ArrayList<[B>;"
    :goto_61
    invoke-virtual {v3}, Ljava/io/InputStream;->read()I

    move-result v1

    .local v1, i:I
    const/4 v11, -0x1

    if-ne v1, v11, :cond_6f

    .line 282
    const/4 v11, 0x1

    iput v11, p0, Landroid/security/KeyStore;->mError:I
    :try_end_6b
    .catchall {:try_start_5c .. :try_end_6b} :catchall_9f
    .catch Ljava/io/IOException; {:try_start_5c .. :try_end_6b} :catch_98

    .line 288
    :try_start_6b
    invoke-virtual {v8}, Landroid/net/LocalSocket;->close()V
    :try_end_6e
    .catch Ljava/io/IOException; {:try_start_6b .. :try_end_6e} :catch_5a

    goto :goto_13

    .line 271
    :cond_6f
    :try_start_6f
    invoke-virtual {v3}, Ljava/io/InputStream;->read()I
    :try_end_72
    .catchall {:try_start_6f .. :try_end_72} :catchall_9f
    .catch Ljava/io/IOException; {:try_start_6f .. :try_end_72} :catch_98

    move-result v4

    .local v4, j:I
    const/4 v11, -0x1

    if-ne v4, v11, :cond_7b

    .line 272
    const/4 v10, 0x0

    .line 288
    .end local v10           #values:Ljava/util/ArrayList;,"Ljava/util/ArrayList<[B>;"
    :try_start_77
    invoke-virtual {v8}, Landroid/net/LocalSocket;->close()V
    :try_end_7a
    .catch Ljava/io/IOException; {:try_start_77 .. :try_end_7a} :catch_5a

    goto :goto_13

    .line 274
    .restart local v10       #values:Ljava/util/ArrayList;,"Ljava/util/ArrayList<[B>;"
    :cond_7b
    shl-int/lit8 v11, v1, 0x8

    or-int/2addr v11, v4

    :try_start_7e
    new-array v9, v11, [B

    .line 275
    .local v9, value:[B
    const/4 v1, 0x0

    :goto_81
    array-length v11, v9

    if-ge v1, v11, :cond_94

    .line 276
    array-length v11, v9

    sub-int/2addr v11, v1

    invoke-virtual {v3, v9, v1, v11}, Ljava/io/InputStream;->read([BII)I
    :try_end_89
    .catchall {:try_start_7e .. :try_end_89} :catchall_9f
    .catch Ljava/io/IOException; {:try_start_7e .. :try_end_89} :catch_98

    move-result v4

    const/4 v11, -0x1

    if-ne v4, v11, :cond_92

    .line 277
    const/4 v10, 0x0

    .line 288
    .end local v10           #values:Ljava/util/ArrayList;,"Ljava/util/ArrayList<[B>;"
    :try_start_8e
    invoke-virtual {v8}, Landroid/net/LocalSocket;->close()V
    :try_end_91
    .catch Ljava/io/IOException; {:try_start_8e .. :try_end_91} :catch_5a

    goto :goto_13

    .line 275
    .restart local v10       #values:Ljava/util/ArrayList;,"Ljava/util/ArrayList<[B>;"
    :cond_92
    add-int/2addr v1, v4

    goto :goto_81

    .line 280
    :cond_94
    :try_start_94
    invoke-virtual {v10, v9}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_97
    .catchall {:try_start_94 .. :try_end_97} :catchall_9f
    .catch Ljava/io/IOException; {:try_start_94 .. :try_end_97} :catch_98

    goto :goto_61

    .line 284
    .end local v1           #i:I
    .end local v3           #in:Ljava/io/InputStream;
    .end local v4           #j:I
    .end local v6           #out:Ljava/io/OutputStream;
    .end local v9           #value:[B
    .end local v10           #values:Ljava/util/ArrayList;,"Ljava/util/ArrayList<[B>;"
    :catch_98
    move-exception v11

    .line 288
    :try_start_99
    invoke-virtual {v8}, Landroid/net/LocalSocket;->close()V
    :try_end_9c
    .catch Ljava/io/IOException; {:try_start_99 .. :try_end_9c} :catch_a4

    .line 291
    :goto_9c
    const/4 v10, 0x0

    goto/16 :goto_13

    .line 287
    :catchall_9f
    move-exception v11

    .line 288
    :try_start_a0
    invoke-virtual {v8}, Landroid/net/LocalSocket;->close()V
    :try_end_a3
    .catch Ljava/io/IOException; {:try_start_a0 .. :try_end_a3} :catch_a6

    .line 287
    :goto_a3
    throw v11

    .line 289
    :catch_a4
    move-exception v11

    goto :goto_9c

    :catch_a6
    move-exception v12

    goto :goto_a3
.end method

.method private generate([B)Z
    .registers 6
    .parameter "key"

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x1

    .line 159
    const/16 v2, 0x61

    new-array v3, v0, [[B

    aput-object p1, v3, v1

    invoke-direct {p0, v2, v3}, Landroid/security/KeyStore;->execute(I[[B)Ljava/util/ArrayList;

    .line 160
    iget v2, p0, Landroid/security/KeyStore;->mError:I

    if-ne v2, v0, :cond_10

    :goto_f
    return v0

    :cond_10
    move v0, v1

    goto :goto_f
.end method

.method private get([B)[B
    .registers 6
    .parameter "key"

    .prologue
    const/4 v3, 0x0

    .line 73
    const/16 v1, 0x67

    const/4 v2, 0x1

    new-array v2, v2, [[B

    aput-object p1, v2, v3

    invoke-direct {p0, v1, v2}, Landroid/security/KeyStore;->execute(I[[B)Ljava/util/ArrayList;

    move-result-object v0

    .line 74
    .local v0, values:Ljava/util/ArrayList;,"Ljava/util/ArrayList<[B>;"
    if-eqz v0, :cond_14

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_16

    :cond_14
    const/4 v1, 0x0

    :goto_15
    return-object v1

    :cond_16
    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [B

    goto :goto_15
.end method

.method private static getBytes(Ljava/lang/String;)[B
    .registers 2
    .parameter "string"

    .prologue
    .line 295
    sget-object v0, Ljava/nio/charset/Charsets;->UTF_8:Ljava/nio/charset/Charset;

    invoke-virtual {p0, v0}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object v0

    return-object v0
.end method

.method public static getInstance()Landroid/security/KeyStore;
    .registers 1

    .prologue
    .line 59
    new-instance v0, Landroid/security/KeyStore;

    invoke-direct {v0}, Landroid/security/KeyStore;-><init>()V

    return-object v0
.end method

.method private getPubkey([B)[B
    .registers 6
    .parameter "key"

    .prologue
    const/4 v3, 0x0

    .line 177
    const/16 v1, 0x62

    const/4 v2, 0x1

    new-array v2, v2, [[B

    aput-object p1, v2, v3

    invoke-direct {p0, v1, v2}, Landroid/security/KeyStore;->execute(I[[B)Ljava/util/ArrayList;

    move-result-object v0

    .line 178
    .local v0, values:Ljava/util/ArrayList;,"Ljava/util/ArrayList<[B>;"
    if-eqz v0, :cond_14

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_16

    :cond_14
    const/4 v1, 0x0

    :goto_15
    return-object v1

    :cond_16
    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [B

    goto :goto_15
.end method

.method private grant([B[B)Z
    .registers 7
    .parameter "key"
    .parameter "uid"

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x1

    .line 213
    const/16 v2, 0x78

    const/4 v3, 0x2

    new-array v3, v3, [[B

    aput-object p1, v3, v1

    aput-object p2, v3, v0

    invoke-direct {p0, v2, v3}, Landroid/security/KeyStore;->execute(I[[B)Ljava/util/ArrayList;

    .line 214
    iget v2, p0, Landroid/security/KeyStore;->mError:I

    if-ne v2, v0, :cond_13

    :goto_12
    return v0

    :cond_13
    move v0, v1

    goto :goto_12
.end method

.method private importKey([B[B)Z
    .registers 7
    .parameter "keyName"
    .parameter "key"

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x1

    .line 168
    const/16 v2, 0x6d

    const/4 v3, 0x2

    new-array v3, v3, [[B

    aput-object p1, v3, v1

    aput-object p2, v3, v0

    invoke-direct {p0, v2, v3}, Landroid/security/KeyStore;->execute(I[[B)Ljava/util/ArrayList;

    .line 169
    iget v2, p0, Landroid/security/KeyStore;->mError:I

    if-ne v2, v0, :cond_13

    :goto_12
    return v0

    :cond_13
    move v0, v1

    goto :goto_12
.end method

.method private password([B)Z
    .registers 6
    .parameter "password"

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x1

    .line 131
    const/16 v2, 0x70

    new-array v3, v0, [[B

    aput-object p1, v3, v1

    invoke-direct {p0, v2, v3}, Landroid/security/KeyStore;->execute(I[[B)Ljava/util/ArrayList;

    .line 132
    iget v2, p0, Landroid/security/KeyStore;->mError:I

    if-ne v2, v0, :cond_10

    :goto_f
    return v0

    :cond_10
    move v0, v1

    goto :goto_f
.end method

.method private put([B[B)Z
    .registers 7
    .parameter "key"
    .parameter "value"

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x1

    .line 82
    const/16 v2, 0x69

    const/4 v3, 0x2

    new-array v3, v3, [[B

    aput-object p1, v3, v1

    aput-object p2, v3, v0

    invoke-direct {p0, v2, v3}, Landroid/security/KeyStore;->execute(I[[B)Ljava/util/ArrayList;

    .line 83
    iget v2, p0, Landroid/security/KeyStore;->mError:I

    if-ne v2, v0, :cond_13

    :goto_12
    return v0

    :cond_13
    move v0, v1

    goto :goto_12
.end method

.method private sign([B[B)[B
    .registers 8
    .parameter "keyName"
    .parameter "data"

    .prologue
    const/4 v4, 0x0

    .line 195
    const/16 v1, 0x6e

    const/4 v2, 0x2

    new-array v2, v2, [[B

    aput-object p1, v2, v4

    const/4 v3, 0x1

    aput-object p2, v2, v3

    invoke-direct {p0, v1, v2}, Landroid/security/KeyStore;->execute(I[[B)Ljava/util/ArrayList;

    move-result-object v0

    .line 196
    .local v0, values:Ljava/util/ArrayList;,"Ljava/util/ArrayList<[B>;"
    if-eqz v0, :cond_17

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_19

    :cond_17
    const/4 v1, 0x0

    :goto_18
    return-object v1

    :cond_19
    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [B

    goto :goto_18
.end method

.method private static toString([B)Ljava/lang/String;
    .registers 3
    .parameter "bytes"

    .prologue
    .line 299
    new-instance v0, Ljava/lang/String;

    sget-object v1, Ljava/nio/charset/Charsets;->UTF_8:Ljava/nio/charset/Charset;

    invoke-direct {v0, p0, v1}, Ljava/lang/String;-><init>([BLjava/nio/charset/Charset;)V

    return-object v0
.end method

.method private ungrant([B[B)Z
    .registers 7
    .parameter "key"
    .parameter "uid"

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x1

    .line 222
    const/16 v2, 0x79

    const/4 v3, 0x2

    new-array v3, v3, [[B

    aput-object p1, v3, v1

    aput-object p2, v3, v0

    invoke-direct {p0, v2, v3}, Landroid/security/KeyStore;->execute(I[[B)Ljava/util/ArrayList;

    .line 223
    iget v2, p0, Landroid/security/KeyStore;->mError:I

    if-ne v2, v0, :cond_13

    :goto_12
    return v0

    :cond_13
    move v0, v1

    goto :goto_12
.end method

.method private unlock([B)Z
    .registers 6
    .parameter "password"

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x1

    .line 145
    const/16 v2, 0x75

    new-array v3, v0, [[B

    aput-object p1, v3, v1

    invoke-direct {p0, v2, v3}, Landroid/security/KeyStore;->execute(I[[B)Ljava/util/ArrayList;

    .line 146
    iget v2, p0, Landroid/security/KeyStore;->mError:I

    if-ne v2, v0, :cond_10

    :goto_f
    return v0

    :cond_10
    move v0, v1

    goto :goto_f
.end method

.method private verify([B[B[B)Z
    .registers 9
    .parameter "keyName"
    .parameter "data"
    .parameter "signature"

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x1

    .line 204
    const/16 v2, 0x76

    const/4 v3, 0x3

    new-array v3, v3, [[B

    aput-object p1, v3, v1

    aput-object p2, v3, v0

    const/4 v4, 0x2

    aput-object p3, v3, v4

    invoke-direct {p0, v2, v3}, Landroid/security/KeyStore;->execute(I[[B)Ljava/util/ArrayList;

    .line 205
    iget v2, p0, Landroid/security/KeyStore;->mError:I

    if-ne v2, v0, :cond_16

    :goto_15
    return v0

    :cond_16
    move v0, v1

    goto :goto_15
.end method


# virtual methods
.method public contains(Ljava/lang/String;)Z
    .registers 3
    .parameter "key"

    .prologue
    .line 105
    invoke-static {p1}, Landroid/security/KeyStore;->getBytes(Ljava/lang/String;)[B

    move-result-object v0

    invoke-direct {p0, v0}, Landroid/security/KeyStore;->contains([B)Z

    move-result v0

    return v0
.end method

.method public delKey(Ljava/lang/String;)Z
    .registers 3
    .parameter "key"

    .prologue
    .line 191
    invoke-static {p1}, Landroid/security/KeyStore;->getBytes(Ljava/lang/String;)[B

    move-result-object v0

    invoke-direct {p0, v0}, Landroid/security/KeyStore;->delKey([B)Z

    move-result v0

    return v0
.end method

.method public delete(Ljava/lang/String;)Z
    .registers 3
    .parameter "key"

    .prologue
    .line 96
    invoke-static {p1}, Landroid/security/KeyStore;->getBytes(Ljava/lang/String;)[B

    move-result-object v0

    invoke-direct {p0, v0}, Landroid/security/KeyStore;->delete([B)Z

    move-result v0

    return v0
.end method

.method public generate(Ljava/lang/String;)Z
    .registers 3
    .parameter "key"

    .prologue
    .line 164
    invoke-static {p1}, Landroid/security/KeyStore;->getBytes(Ljava/lang/String;)[B

    move-result-object v0

    invoke-direct {p0, v0}, Landroid/security/KeyStore;->generate([B)Z

    move-result v0

    return v0
.end method

.method public get(Ljava/lang/String;)[B
    .registers 3
    .parameter "key"

    .prologue
    .line 78
    invoke-static {p1}, Landroid/security/KeyStore;->getBytes(Ljava/lang/String;)[B

    move-result-object v0

    invoke-direct {p0, v0}, Landroid/security/KeyStore;->get([B)[B

    move-result-object v0

    return-object v0
.end method

.method public getLastError()I
    .registers 2

    .prologue
    .line 231
    iget v0, p0, Landroid/security/KeyStore;->mError:I

    return v0
.end method

.method public getPubkey(Ljava/lang/String;)[B
    .registers 3
    .parameter "key"

    .prologue
    .line 182
    invoke-static {p1}, Landroid/security/KeyStore;->getBytes(Ljava/lang/String;)[B

    move-result-object v0

    invoke-direct {p0, v0}, Landroid/security/KeyStore;->getPubkey([B)[B

    move-result-object v0

    return-object v0
.end method

.method public grant(Ljava/lang/String;I)Z
    .registers 5
    .parameter "key"
    .parameter "uid"

    .prologue
    .line 218
    invoke-static {p1}, Landroid/security/KeyStore;->getBytes(Ljava/lang/String;)[B

    move-result-object v0

    invoke-static {p2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->getBytes()[B

    move-result-object v1

    invoke-direct {p0, v0, v1}, Landroid/security/KeyStore;->grant([B[B)Z

    move-result v0

    return v0
.end method

.method public importKey(Ljava/lang/String;[B)Z
    .registers 4
    .parameter "keyName"
    .parameter "key"

    .prologue
    .line 173
    invoke-static {p1}, Landroid/security/KeyStore;->getBytes(Ljava/lang/String;)[B

    move-result-object v0

    invoke-direct {p0, v0, p2}, Landroid/security/KeyStore;->importKey([B[B)Z

    move-result v0

    return v0
.end method

.method public isEmpty()Z
    .registers 4

    .prologue
    const/4 v0, 0x0

    .line 154
    const/16 v1, 0x7a

    new-array v2, v0, [[B

    invoke-direct {p0, v1, v2}, Landroid/security/KeyStore;->execute(I[[B)Ljava/util/ArrayList;

    .line 155
    iget v1, p0, Landroid/security/KeyStore;->mError:I

    const/4 v2, 0x7

    if-ne v1, v2, :cond_e

    const/4 v0, 0x1

    :cond_e
    return v0
.end method

.method public lock()Z
    .registers 5

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 140
    const/16 v2, 0x6c

    new-array v3, v1, [[B

    invoke-direct {p0, v2, v3}, Landroid/security/KeyStore;->execute(I[[B)Ljava/util/ArrayList;

    .line 141
    iget v2, p0, Landroid/security/KeyStore;->mError:I

    if-ne v2, v0, :cond_e

    :goto_d
    return v0

    :cond_e
    move v0, v1

    goto :goto_d
.end method

.method public password(Ljava/lang/String;)Z
    .registers 3
    .parameter "password"

    .prologue
    .line 136
    invoke-static {p1}, Landroid/security/KeyStore;->getBytes(Ljava/lang/String;)[B

    move-result-object v0

    invoke-direct {p0, v0}, Landroid/security/KeyStore;->password([B)Z

    move-result v0

    return v0
.end method

.method public put(Ljava/lang/String;[B)Z
    .registers 4
    .parameter "key"
    .parameter "value"

    .prologue
    .line 87
    invoke-static {p1}, Landroid/security/KeyStore;->getBytes(Ljava/lang/String;)[B

    move-result-object v0

    invoke-direct {p0, v0, p2}, Landroid/security/KeyStore;->put([B[B)Z

    move-result v0

    return v0
.end method

.method public reset()Z
    .registers 5

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 126
    const/16 v2, 0x72

    new-array v3, v1, [[B

    invoke-direct {p0, v2, v3}, Landroid/security/KeyStore;->execute(I[[B)Ljava/util/ArrayList;

    .line 127
    iget v2, p0, Landroid/security/KeyStore;->mError:I

    if-ne v2, v0, :cond_e

    :goto_d
    return v0

    :cond_e
    move v0, v1

    goto :goto_d
.end method

.method public saw(Ljava/lang/String;)[Ljava/lang/String;
    .registers 6
    .parameter "prefix"

    .prologue
    .line 114
    invoke-static {p1}, Landroid/security/KeyStore;->getBytes(Ljava/lang/String;)[B

    move-result-object v3

    invoke-virtual {p0, v3}, Landroid/security/KeyStore;->saw([B)[[B

    move-result-object v2

    .line 115
    .local v2, values:[[B
    if-nez v2, :cond_c

    .line 116
    const/4 v1, 0x0

    .line 122
    :cond_b
    return-object v1

    .line 118
    :cond_c
    array-length v3, v2

    new-array v1, v3, [Ljava/lang/String;

    .line 119
    .local v1, strings:[Ljava/lang/String;
    const/4 v0, 0x0

    .local v0, i:I
    :goto_10
    array-length v3, v2

    if-ge v0, v3, :cond_b

    .line 120
    aget-object v3, v2, v0

    invoke-static {v3}, Landroid/security/KeyStore;->toString([B)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v0

    .line 119
    add-int/lit8 v0, v0, 0x1

    goto :goto_10
.end method

.method public saw([B)[[B
    .registers 6
    .parameter "prefix"

    .prologue
    .line 109
    const/16 v1, 0x73

    const/4 v2, 0x1

    new-array v2, v2, [[B

    const/4 v3, 0x0

    aput-object p1, v2, v3

    invoke-direct {p0, v1, v2}, Landroid/security/KeyStore;->execute(I[[B)Ljava/util/ArrayList;

    move-result-object v0

    .line 110
    .local v0, values:Ljava/util/ArrayList;,"Ljava/util/ArrayList<[B>;"
    if-nez v0, :cond_12

    const/4 v1, 0x0

    check-cast v1, [[B

    :goto_11
    return-object v1

    :cond_12
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v1

    new-array v1, v1, [[B

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [[B

    goto :goto_11
.end method

.method public sign(Ljava/lang/String;[B)[B
    .registers 4
    .parameter "key"
    .parameter "data"

    .prologue
    .line 200
    invoke-static {p1}, Landroid/security/KeyStore;->getBytes(Ljava/lang/String;)[B

    move-result-object v0

    invoke-direct {p0, v0, p2}, Landroid/security/KeyStore;->sign([B[B)[B

    move-result-object v0

    return-object v0
.end method

.method public state()Landroid/security/KeyStore$State;
    .registers 3

    .prologue
    .line 63
    const/16 v0, 0x74

    const/4 v1, 0x0

    new-array v1, v1, [[B

    invoke-direct {p0, v0, v1}, Landroid/security/KeyStore;->execute(I[[B)Ljava/util/ArrayList;

    .line 64
    iget v0, p0, Landroid/security/KeyStore;->mError:I

    packed-switch v0, :pswitch_data_1e

    .line 68
    new-instance v0, Ljava/lang/AssertionError;

    iget v1, p0, Landroid/security/KeyStore;->mError:I

    invoke-direct {v0, v1}, Ljava/lang/AssertionError;-><init>(I)V

    throw v0

    .line 65
    :pswitch_15
    sget-object v0, Landroid/security/KeyStore$State;->UNLOCKED:Landroid/security/KeyStore$State;

    .line 67
    :goto_17
    return-object v0

    .line 66
    :pswitch_18
    sget-object v0, Landroid/security/KeyStore$State;->LOCKED:Landroid/security/KeyStore$State;

    goto :goto_17

    .line 67
    :pswitch_1b
    sget-object v0, Landroid/security/KeyStore$State;->UNINITIALIZED:Landroid/security/KeyStore$State;

    goto :goto_17

    .line 64
    :pswitch_data_1e
    .packed-switch 0x1
        :pswitch_15
        :pswitch_18
        :pswitch_1b
    .end packed-switch
.end method

.method public ungrant(Ljava/lang/String;I)Z
    .registers 5
    .parameter "key"
    .parameter "uid"

    .prologue
    .line 227
    invoke-static {p1}, Landroid/security/KeyStore;->getBytes(Ljava/lang/String;)[B

    move-result-object v0

    invoke-static {p2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->getBytes()[B

    move-result-object v1

    invoke-direct {p0, v0, v1}, Landroid/security/KeyStore;->ungrant([B[B)Z

    move-result v0

    return v0
.end method

.method public unlock(Ljava/lang/String;)Z
    .registers 3
    .parameter "password"

    .prologue
    .line 150
    invoke-static {p1}, Landroid/security/KeyStore;->getBytes(Ljava/lang/String;)[B

    move-result-object v0

    invoke-direct {p0, v0}, Landroid/security/KeyStore;->unlock([B)Z

    move-result v0

    return v0
.end method

.method public verify(Ljava/lang/String;[B[B)Z
    .registers 5
    .parameter "key"
    .parameter "data"
    .parameter "signature"

    .prologue
    .line 209
    invoke-static {p1}, Landroid/security/KeyStore;->getBytes(Ljava/lang/String;)[B

    move-result-object v0

    invoke-direct {p0, v0, p2, p3}, Landroid/security/KeyStore;->verify([B[B[B)Z

    move-result v0

    return v0
.end method
