.class Lcom/android/internal/telephony/test/LineReader;
.super Ljava/lang/Object;
.source "ModelInterpreter.java"


# static fields
.field static final BUFFER_SIZE:I = 0x1000


# instance fields
.field buffer:[B

.field inStream:Ljava/io/InputStream;


# direct methods
.method constructor <init>(Ljava/io/InputStream;)V
    .registers 3
    .parameter "s"

    .prologue
    .line 55
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 48
    const/16 v0, 0x1000

    new-array v0, v0, [B

    iput-object v0, p0, Lcom/android/internal/telephony/test/LineReader;->buffer:[B

    .line 56
    iput-object p1, p0, Lcom/android/internal/telephony/test/LineReader;->inStream:Ljava/io/InputStream;

    .line 57
    return-void
.end method


# virtual methods
.method getNextLine()Ljava/lang/String;
    .registers 2

    .prologue
    .line 62
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/android/internal/telephony/test/LineReader;->getNextLine(Z)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method getNextLine(Z)Ljava/lang/String;
    .registers 11
    .parameter "ctrlZ"

    .prologue
    const/4 v4, 0x0

    .line 81
    const/4 v1, 0x0

    .local v1, i:I
    move v2, v1

    .line 87
    .end local v1           #i:I
    .local v2, i:I
    :goto_3
    :try_start_3
    iget-object v5, p0, Lcom/android/internal/telephony/test/LineReader;->inStream:Ljava/io/InputStream;

    invoke-virtual {v5}, Ljava/io/InputStream;->read()I
    :try_end_8
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_8} :catch_34
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_3 .. :try_end_8} :catch_37

    move-result v3

    .line 89
    .local v3, result:I
    if-gez v3, :cond_d

    move v1, v2

    .line 116
    .end local v2           #i:I
    .end local v3           #result:I
    .restart local v1       #i:I
    :goto_c
    return-object v4

    .line 93
    .end local v1           #i:I
    .restart local v2       #i:I
    .restart local v3       #result:I
    :cond_d
    if-eqz p1, :cond_20

    const/16 v5, 0x1a

    if-ne v3, v5, :cond_20

    :cond_13
    move v1, v2

    .line 113
    .end local v2           #i:I
    .end local v3           #result:I
    .restart local v1       #i:I
    :goto_14
    :try_start_14
    new-instance v5, Ljava/lang/String;

    iget-object v6, p0, Lcom/android/internal/telephony/test/LineReader;->buffer:[B

    const/4 v7, 0x0

    const-string v8, "US-ASCII"

    invoke-direct {v5, v6, v7, v1, v8}, Ljava/lang/String;-><init>([BIILjava/lang/String;)V
    :try_end_1e
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_14 .. :try_end_1e} :catch_41

    move-object v4, v5

    goto :goto_c

    .line 95
    .end local v1           #i:I
    .restart local v2       #i:I
    .restart local v3       #result:I
    :cond_20
    const/16 v5, 0xd

    if-eq v3, v5, :cond_28

    const/16 v5, 0xa

    if-ne v3, v5, :cond_2b

    .line 96
    :cond_28
    if-nez v2, :cond_13

    goto :goto_3

    .line 104
    :cond_2b
    :try_start_2b
    iget-object v5, p0, Lcom/android/internal/telephony/test/LineReader;->buffer:[B
    :try_end_2d
    .catch Ljava/io/IOException; {:try_start_2b .. :try_end_2d} :catch_34
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_2b .. :try_end_2d} :catch_37

    add-int/lit8 v1, v2, 0x1

    .end local v2           #i:I
    .restart local v1       #i:I
    int-to-byte v6, v3

    :try_start_30
    aput-byte v6, v5, v2
    :try_end_32
    .catch Ljava/io/IOException; {:try_start_30 .. :try_end_32} :catch_4c
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_30 .. :try_end_32} :catch_4a

    move v2, v1

    .line 105
    .end local v1           #i:I
    .restart local v2       #i:I
    goto :goto_3

    .line 106
    .end local v3           #result:I
    :catch_34
    move-exception v0

    move v1, v2

    .line 107
    .end local v2           #i:I
    .local v0, ex:Ljava/io/IOException;
    .restart local v1       #i:I
    :goto_36
    goto :goto_c

    .line 108
    .end local v0           #ex:Ljava/io/IOException;
    .end local v1           #i:I
    .restart local v2       #i:I
    :catch_37
    move-exception v0

    move v1, v2

    .line 109
    .end local v2           #i:I
    .local v0, ex:Ljava/lang/IndexOutOfBoundsException;
    .restart local v1       #i:I
    :goto_39
    sget-object v5, Ljava/lang/System;->err:Ljava/io/PrintStream;

    const-string v6, "ATChannel: buffer overflow"

    invoke-virtual {v5, v6}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    goto :goto_14

    .line 114
    .end local v0           #ex:Ljava/lang/IndexOutOfBoundsException;
    :catch_41
    move-exception v0

    .line 115
    .local v0, ex:Ljava/io/UnsupportedEncodingException;
    sget-object v5, Ljava/lang/System;->err:Ljava/io/PrintStream;

    const-string v6, "ATChannel: implausable UnsupportedEncodingException"

    invoke-virtual {v5, v6}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    goto :goto_c

    .line 108
    .end local v0           #ex:Ljava/io/UnsupportedEncodingException;
    .restart local v3       #result:I
    :catch_4a
    move-exception v0

    goto :goto_39

    .line 106
    :catch_4c
    move-exception v0

    goto :goto_36
.end method

.method getNextLineCtrlZ()Ljava/lang/String;
    .registers 2

    .prologue
    .line 68
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/android/internal/telephony/test/LineReader;->getNextLine(Z)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
