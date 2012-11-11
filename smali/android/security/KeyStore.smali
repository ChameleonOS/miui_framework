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
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x1

    iput v0, p0, Landroid/security/KeyStore;->mError:I

    return-void
.end method

.method private contains([B)Z
    .registers 6
    .parameter "key"

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x1

    const/16 v2, 0x65

    new-array v3, v0, [[B

    aput-object p1, v3, v1

    invoke-direct {p0, v2, v3}, Landroid/security/KeyStore;->execute(I[[B)Ljava/util/ArrayList;

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

    const/16 v2, 0x6b

    new-array v3, v0, [[B

    aput-object p1, v3, v1

    invoke-direct {p0, v2, v3}, Landroid/security/KeyStore;->execute(I[[B)Ljava/util/ArrayList;

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

    const/16 v2, 0x64

    new-array v3, v0, [[B

    aput-object p1, v3, v1

    invoke-direct {p0, v2, v3}, Landroid/security/KeyStore;->execute(I[[B)Ljava/util/ArrayList;

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
    const/4 v11, 0x5

    iput v11, p0, Landroid/security/KeyStore;->mError:I

    move-object v0, p2

    .local v0, arr$:[[B
    array-length v5, v0

    .local v5, len$:I
    const/4 v2, 0x0

    .local v2, i$:I
    :goto_6
    if-ge v2, v5, :cond_17

    aget-object v7, v0, v2

    .local v7, parameter:[B
    if-eqz v7, :cond_12

    array-length v11, v7

    const v12, 0xffff

    if-le v11, v12, :cond_14

    :cond_12
    const/4 v10, 0x0

    .end local v7           #parameter:[B
    :goto_13
    return-object v10

    .restart local v7       #parameter:[B
    :cond_14
    add-int/lit8 v2, v2, 0x1

    goto :goto_6

    .end local v7           #parameter:[B
    :cond_17
    new-instance v8, Landroid/net/LocalSocket;

    invoke-direct {v8}, Landroid/net/LocalSocket;-><init>()V

    .local v8, socket:Landroid/net/LocalSocket;
    :try_start_1c
    sget-object v11, Landroid/security/KeyStore;->sAddress:Landroid/net/LocalSocketAddress;

    invoke-virtual {v8, v11}, Landroid/net/LocalSocket;->connect(Landroid/net/LocalSocketAddress;)V

    invoke-virtual {v8}, Landroid/net/LocalSocket;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v6

    .local v6, out:Ljava/io/OutputStream;
    invoke-virtual {v6, p1}, Ljava/io/OutputStream;->write(I)V

    move-object v0, p2

    array-length v5, v0

    const/4 v2, 0x0

    :goto_2b
    if-ge v2, v5, :cond_3f

    aget-object v7, v0, v2

    .restart local v7       #parameter:[B
    array-length v11, v7

    shr-int/lit8 v11, v11, 0x8

    invoke-virtual {v6, v11}, Ljava/io/OutputStream;->write(I)V

    array-length v11, v7

    invoke-virtual {v6, v11}, Ljava/io/OutputStream;->write(I)V

    invoke-virtual {v6, v7}, Ljava/io/OutputStream;->write([B)V

    add-int/lit8 v2, v2, 0x1

    goto :goto_2b

    .end local v7           #parameter:[B
    :cond_3f
    invoke-virtual {v6}, Ljava/io/OutputStream;->flush()V

    invoke-virtual {v8}, Landroid/net/LocalSocket;->shutdownOutput()V

    invoke-virtual {v8}, Landroid/net/LocalSocket;->getInputStream()Ljava/io/InputStream;

    move-result-object v3

    .local v3, in:Ljava/io/InputStream;
    invoke-virtual {v3}, Ljava/io/InputStream;->read()I

    move-result p1

    const/4 v11, 0x1

    if-eq p1, v11, :cond_5c

    const/4 v11, -0x1

    if-eq p1, v11, :cond_55

    iput p1, p0, Landroid/security/KeyStore;->mError:I
    :try_end_55
    .catchall {:try_start_1c .. :try_end_55} :catchall_9f
    .catch Ljava/io/IOException; {:try_start_1c .. :try_end_55} :catch_98

    :cond_55
    const/4 v10, 0x0

    :try_start_56
    invoke-virtual {v8}, Landroid/net/LocalSocket;->close()V
    :try_end_59
    .catch Ljava/io/IOException; {:try_start_56 .. :try_end_59} :catch_5a

    goto :goto_13

    :catch_5a
    move-exception v11

    goto :goto_13

    :cond_5c
    :try_start_5c
    new-instance v10, Ljava/util/ArrayList;

    invoke-direct {v10}, Ljava/util/ArrayList;-><init>()V

    .local v10, values:Ljava/util/ArrayList;,"Ljava/util/ArrayList<[B>;"
    :goto_61
    invoke-virtual {v3}, Ljava/io/InputStream;->read()I

    move-result v1

    .local v1, i:I
    const/4 v11, -0x1

    if-ne v1, v11, :cond_6f

    const/4 v11, 0x1

    iput v11, p0, Landroid/security/KeyStore;->mError:I
    :try_end_6b
    .catchall {:try_start_5c .. :try_end_6b} :catchall_9f
    .catch Ljava/io/IOException; {:try_start_5c .. :try_end_6b} :catch_98

    :try_start_6b
    invoke-virtual {v8}, Landroid/net/LocalSocket;->close()V
    :try_end_6e
    .catch Ljava/io/IOException; {:try_start_6b .. :try_end_6e} :catch_5a

    goto :goto_13

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

    const/4 v10, 0x0

    .end local v10           #values:Ljava/util/ArrayList;,"Ljava/util/ArrayList<[B>;"
    :try_start_77
    invoke-virtual {v8}, Landroid/net/LocalSocket;->close()V
    :try_end_7a
    .catch Ljava/io/IOException; {:try_start_77 .. :try_end_7a} :catch_5a

    goto :goto_13

    .restart local v10       #values:Ljava/util/ArrayList;,"Ljava/util/ArrayList<[B>;"
    :cond_7b
    shl-int/lit8 v11, v1, 0x8

    or-int/2addr v11, v4

    :try_start_7e
    new-array v9, v11, [B

    .local v9, value:[B
    const/4 v1, 0x0

    :goto_81
    array-length v11, v9

    if-ge v1, v11, :cond_94

    array-length v11, v9

    sub-int/2addr v11, v1

    invoke-virtual {v3, v9, v1, v11}, Ljava/io/InputStream;->read([BII)I
    :try_end_89
    .catchall {:try_start_7e .. :try_end_89} :catchall_9f
    .catch Ljava/io/IOException; {:try_start_7e .. :try_end_89} :catch_98

    move-result v4

    const/4 v11, -0x1

    if-ne v4, v11, :cond_92

    const/4 v10, 0x0

    .end local v10           #values:Ljava/util/ArrayList;,"Ljava/util/ArrayList<[B>;"
    :try_start_8e
    invoke-virtual {v8}, Landroid/net/LocalSocket;->close()V
    :try_end_91
    .catch Ljava/io/IOException; {:try_start_8e .. :try_end_91} :catch_5a

    goto :goto_13

    .restart local v10       #values:Ljava/util/ArrayList;,"Ljava/util/ArrayList<[B>;"
    :cond_92
    add-int/2addr v1, v4

    goto :goto_81

    :cond_94
    :try_start_94
    invoke-virtual {v10, v9}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_97
    .catchall {:try_start_94 .. :try_end_97} :catchall_9f
    .catch Ljava/io/IOException; {:try_start_94 .. :try_end_97} :catch_98

    goto :goto_61

    .end local v1           #i:I
    .end local v3           #in:Ljava/io/InputStream;
    .end local v4           #j:I
    .end local v6           #out:Ljava/io/OutputStream;
    .end local v9           #value:[B
    .end local v10           #values:Ljava/util/ArrayList;,"Ljava/util/ArrayList<[B>;"
    :catch_98
    move-exception v11

    :try_start_99
    invoke-virtual {v8}, Landroid/net/LocalSocket;->close()V
    :try_end_9c
    .catch Ljava/io/IOException; {:try_start_99 .. :try_end_9c} :catch_a4

    :goto_9c
    const/4 v10, 0x0

    goto/16 :goto_13

    :catchall_9f
    move-exception v11

    :try_start_a0
    invoke-virtual {v8}, Landroid/net/LocalSocket;->close()V
    :try_end_a3
    .catch Ljava/io/IOException; {:try_start_a0 .. :try_end_a3} :catch_a6

    :goto_a3
    throw v11

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

    const/16 v2, 0x61

    new-array v3, v0, [[B

    aput-object p1, v3, v1

    invoke-direct {p0, v2, v3}, Landroid/security/KeyStore;->execute(I[[B)Ljava/util/ArrayList;

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

    const/16 v1, 0x67

    const/4 v2, 0x1

    new-array v2, v2, [[B

    aput-object p1, v2, v3

    invoke-direct {p0, v1, v2}, Landroid/security/KeyStore;->execute(I[[B)Ljava/util/ArrayList;

    move-result-object v0

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

.method public static getInstance()Landroid/security/KeyStore;
    .registers 1

    .prologue
    new-instance v0, Landroid/security/KeyStore;

    invoke-direct {v0}, Landroid/security/KeyStore;-><init>()V

    return-object v0
.end method

.method private static getKeyBytes(Ljava/lang/String;)[B
    .registers 6
    .parameter "string"

    .prologue
    const/4 v3, 0x0

    :try_start_1
    invoke-static {p0, v3}, Ljava/nio/charset/ModifiedUtf8;->countBytes(Ljava/lang/String;Z)J

    move-result-wide v3

    long-to-int v2, v3

    .local v2, utfCount:I
    new-array v1, v2, [B

    .local v1, result:[B
    const/4 v3, 0x0

    invoke-static {v1, v3, p0}, Ljava/nio/charset/ModifiedUtf8;->encode([BILjava/lang/String;)V
    :try_end_c
    .catch Ljava/io/UTFDataFormatException; {:try_start_1 .. :try_end_c} :catch_d

    return-object v1

    .end local v1           #result:[B
    .end local v2           #utfCount:I
    :catch_d
    move-exception v0

    .local v0, e:Ljava/io/UTFDataFormatException;
    new-instance v3, Ljava/lang/RuntimeException;

    invoke-direct {v3, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v3
.end method

.method private static getPasswordBytes(Ljava/lang/String;)[B
    .registers 2
    .parameter "password"

    .prologue
    sget-object v0, Ljava/nio/charset/Charsets;->UTF_8:Ljava/nio/charset/Charset;

    invoke-virtual {p0, v0}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object v0

    return-object v0
.end method

.method private getPubkey([B)[B
    .registers 6
    .parameter "key"

    .prologue
    const/4 v3, 0x0

    const/16 v1, 0x62

    const/4 v2, 0x1

    new-array v2, v2, [[B

    aput-object p1, v2, v3

    invoke-direct {p0, v1, v2}, Landroid/security/KeyStore;->execute(I[[B)Ljava/util/ArrayList;

    move-result-object v0

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

.method private static getUidBytes(I)[B
    .registers 3
    .parameter "uid"

    .prologue
    invoke-static {p0}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v0

    sget-object v1, Ljava/nio/charset/Charsets;->UTF_8:Ljava/nio/charset/Charset;

    invoke-virtual {v0, v1}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object v0

    return-object v0
.end method

.method private grant([B[B)Z
    .registers 7
    .parameter "key"
    .parameter "uid"

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x1

    const/16 v2, 0x78

    const/4 v3, 0x2

    new-array v3, v3, [[B

    aput-object p1, v3, v1

    aput-object p2, v3, v0

    invoke-direct {p0, v2, v3}, Landroid/security/KeyStore;->execute(I[[B)Ljava/util/ArrayList;

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

    const/16 v2, 0x6d

    const/4 v3, 0x2

    new-array v3, v3, [[B

    aput-object p1, v3, v1

    aput-object p2, v3, v0

    invoke-direct {p0, v2, v3}, Landroid/security/KeyStore;->execute(I[[B)Ljava/util/ArrayList;

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

    const/16 v2, 0x70

    new-array v3, v0, [[B

    aput-object p1, v3, v1

    invoke-direct {p0, v2, v3}, Landroid/security/KeyStore;->execute(I[[B)Ljava/util/ArrayList;

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

    const/16 v2, 0x69

    const/4 v3, 0x2

    new-array v3, v3, [[B

    aput-object p1, v3, v1

    aput-object p2, v3, v0

    invoke-direct {p0, v2, v3}, Landroid/security/KeyStore;->execute(I[[B)Ljava/util/ArrayList;

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

    const/16 v1, 0x6e

    const/4 v2, 0x2

    new-array v2, v2, [[B

    aput-object p1, v2, v4

    const/4 v3, 0x1

    aput-object p2, v2, v3

    invoke-direct {p0, v1, v2}, Landroid/security/KeyStore;->execute(I[[B)Ljava/util/ArrayList;

    move-result-object v0

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

.method private static toKeyString([B)Ljava/lang/String;
    .registers 5
    .parameter "bytes"

    .prologue
    :try_start_0
    array-length v1, p0

    new-array v1, v1, [C

    const/4 v2, 0x0

    array-length v3, p0

    invoke-static {p0, v1, v2, v3}, Ljava/nio/charset/ModifiedUtf8;->decode([B[CII)Ljava/lang/String;
    :try_end_8
    .catch Ljava/io/UTFDataFormatException; {:try_start_0 .. :try_end_8} :catch_a

    move-result-object v1

    return-object v1

    :catch_a
    move-exception v0

    .local v0, e:Ljava/io/UTFDataFormatException;
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method private ungrant([B[B)Z
    .registers 7
    .parameter "key"
    .parameter "uid"

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x1

    const/16 v2, 0x79

    const/4 v3, 0x2

    new-array v3, v3, [[B

    aput-object p1, v3, v1

    aput-object p2, v3, v0

    invoke-direct {p0, v2, v3}, Landroid/security/KeyStore;->execute(I[[B)Ljava/util/ArrayList;

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

    const/16 v2, 0x75

    new-array v3, v0, [[B

    aput-object p1, v3, v1

    invoke-direct {p0, v2, v3}, Landroid/security/KeyStore;->execute(I[[B)Ljava/util/ArrayList;

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

    const/16 v2, 0x76

    const/4 v3, 0x3

    new-array v3, v3, [[B

    aput-object p1, v3, v1

    aput-object p2, v3, v0

    const/4 v4, 0x2

    aput-object p3, v3, v4

    invoke-direct {p0, v2, v3}, Landroid/security/KeyStore;->execute(I[[B)Ljava/util/ArrayList;

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
    invoke-static {p1}, Landroid/security/KeyStore;->getKeyBytes(Ljava/lang/String;)[B

    move-result-object v0

    invoke-direct {p0, v0}, Landroid/security/KeyStore;->contains([B)Z

    move-result v0

    return v0
.end method

.method public delKey(Ljava/lang/String;)Z
    .registers 3
    .parameter "key"

    .prologue
    invoke-static {p1}, Landroid/security/KeyStore;->getKeyBytes(Ljava/lang/String;)[B

    move-result-object v0

    invoke-direct {p0, v0}, Landroid/security/KeyStore;->delKey([B)Z

    move-result v0

    return v0
.end method

.method public delete(Ljava/lang/String;)Z
    .registers 3
    .parameter "key"

    .prologue
    invoke-static {p1}, Landroid/security/KeyStore;->getKeyBytes(Ljava/lang/String;)[B

    move-result-object v0

    invoke-direct {p0, v0}, Landroid/security/KeyStore;->delete([B)Z

    move-result v0

    return v0
.end method

.method public generate(Ljava/lang/String;)Z
    .registers 3
    .parameter "key"

    .prologue
    invoke-static {p1}, Landroid/security/KeyStore;->getKeyBytes(Ljava/lang/String;)[B

    move-result-object v0

    invoke-direct {p0, v0}, Landroid/security/KeyStore;->generate([B)Z

    move-result v0

    return v0
.end method

.method public get(Ljava/lang/String;)[B
    .registers 3
    .parameter "key"

    .prologue
    invoke-static {p1}, Landroid/security/KeyStore;->getKeyBytes(Ljava/lang/String;)[B

    move-result-object v0

    invoke-direct {p0, v0}, Landroid/security/KeyStore;->get([B)[B

    move-result-object v0

    return-object v0
.end method

.method public getLastError()I
    .registers 2

    .prologue
    iget v0, p0, Landroid/security/KeyStore;->mError:I

    return v0
.end method

.method public getPubkey(Ljava/lang/String;)[B
    .registers 3
    .parameter "key"

    .prologue
    invoke-static {p1}, Landroid/security/KeyStore;->getKeyBytes(Ljava/lang/String;)[B

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
    invoke-static {p1}, Landroid/security/KeyStore;->getKeyBytes(Ljava/lang/String;)[B

    move-result-object v0

    invoke-static {p2}, Landroid/security/KeyStore;->getUidBytes(I)[B

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
    invoke-static {p1}, Landroid/security/KeyStore;->getKeyBytes(Ljava/lang/String;)[B

    move-result-object v0

    invoke-direct {p0, v0, p2}, Landroid/security/KeyStore;->importKey([B[B)Z

    move-result v0

    return v0
.end method

.method public isEmpty()Z
    .registers 4

    .prologue
    const/4 v0, 0x0

    const/16 v1, 0x7a

    new-array v2, v0, [[B

    invoke-direct {p0, v1, v2}, Landroid/security/KeyStore;->execute(I[[B)Ljava/util/ArrayList;

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

    const/16 v2, 0x6c

    new-array v3, v1, [[B

    invoke-direct {p0, v2, v3}, Landroid/security/KeyStore;->execute(I[[B)Ljava/util/ArrayList;

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
    invoke-static {p1}, Landroid/security/KeyStore;->getPasswordBytes(Ljava/lang/String;)[B

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
    invoke-static {p1}, Landroid/security/KeyStore;->getKeyBytes(Ljava/lang/String;)[B

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

    const/16 v2, 0x72

    new-array v3, v1, [[B

    invoke-direct {p0, v2, v3}, Landroid/security/KeyStore;->execute(I[[B)Ljava/util/ArrayList;

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
    invoke-static {p1}, Landroid/security/KeyStore;->getKeyBytes(Ljava/lang/String;)[B

    move-result-object v3

    invoke-virtual {p0, v3}, Landroid/security/KeyStore;->saw([B)[[B

    move-result-object v2

    .local v2, values:[[B
    if-nez v2, :cond_c

    const/4 v1, 0x0

    :cond_b
    return-object v1

    :cond_c
    array-length v3, v2

    new-array v1, v3, [Ljava/lang/String;

    .local v1, strings:[Ljava/lang/String;
    const/4 v0, 0x0

    .local v0, i:I
    :goto_10
    array-length v3, v2

    if-ge v0, v3, :cond_b

    aget-object v3, v2, v0

    invoke-static {v3}, Landroid/security/KeyStore;->toKeyString([B)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v0

    add-int/lit8 v0, v0, 0x1

    goto :goto_10
.end method

.method public saw([B)[[B
    .registers 6
    .parameter "prefix"

    .prologue
    const/16 v1, 0x73

    const/4 v2, 0x1

    new-array v2, v2, [[B

    const/4 v3, 0x0

    aput-object p1, v2, v3

    invoke-direct {p0, v1, v2}, Landroid/security/KeyStore;->execute(I[[B)Ljava/util/ArrayList;

    move-result-object v0

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
    invoke-static {p1}, Landroid/security/KeyStore;->getKeyBytes(Ljava/lang/String;)[B

    move-result-object v0

    invoke-direct {p0, v0, p2}, Landroid/security/KeyStore;->sign([B[B)[B

    move-result-object v0

    return-object v0
.end method

.method public state()Landroid/security/KeyStore$State;
    .registers 3

    .prologue
    const/16 v0, 0x74

    const/4 v1, 0x0

    new-array v1, v1, [[B

    invoke-direct {p0, v0, v1}, Landroid/security/KeyStore;->execute(I[[B)Ljava/util/ArrayList;

    iget v0, p0, Landroid/security/KeyStore;->mError:I

    packed-switch v0, :pswitch_data_1e

    new-instance v0, Ljava/lang/AssertionError;

    iget v1, p0, Landroid/security/KeyStore;->mError:I

    invoke-direct {v0, v1}, Ljava/lang/AssertionError;-><init>(I)V

    throw v0

    :pswitch_15
    sget-object v0, Landroid/security/KeyStore$State;->UNLOCKED:Landroid/security/KeyStore$State;

    :goto_17
    return-object v0

    :pswitch_18
    sget-object v0, Landroid/security/KeyStore$State;->LOCKED:Landroid/security/KeyStore$State;

    goto :goto_17

    :pswitch_1b
    sget-object v0, Landroid/security/KeyStore$State;->UNINITIALIZED:Landroid/security/KeyStore$State;

    goto :goto_17

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
    invoke-static {p1}, Landroid/security/KeyStore;->getKeyBytes(Ljava/lang/String;)[B

    move-result-object v0

    invoke-static {p2}, Landroid/security/KeyStore;->getUidBytes(I)[B

    move-result-object v1

    invoke-direct {p0, v0, v1}, Landroid/security/KeyStore;->ungrant([B[B)Z

    move-result v0

    return v0
.end method

.method public unlock(Ljava/lang/String;)Z
    .registers 3
    .parameter "password"

    .prologue
    invoke-static {p1}, Landroid/security/KeyStore;->getPasswordBytes(Ljava/lang/String;)[B

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
    invoke-static {p1}, Landroid/security/KeyStore;->getKeyBytes(Ljava/lang/String;)[B

    move-result-object v0

    invoke-direct {p0, v0, p2, p3}, Landroid/security/KeyStore;->verify([B[B[B)Z

    move-result v0

    return v0
.end method
