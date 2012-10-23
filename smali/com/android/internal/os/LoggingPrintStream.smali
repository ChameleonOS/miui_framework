.class abstract Lcom/android/internal/os/LoggingPrintStream;
.super Ljava/io/PrintStream;
.source "LoggingPrintStream.java"


# instance fields
.field private final builder:Ljava/lang/StringBuilder;

.field private decodedChars:Ljava/nio/CharBuffer;

.field private decoder:Ljava/nio/charset/CharsetDecoder;

.field private encodedBytes:Ljava/nio/ByteBuffer;

.field private final formatter:Ljava/util/Formatter;


# direct methods
.method protected constructor <init>()V
    .registers 4

    .prologue
    .line 62
    new-instance v0, Lcom/android/internal/os/LoggingPrintStream$1;

    invoke-direct {v0}, Lcom/android/internal/os/LoggingPrintStream$1;-><init>()V

    invoke-direct {p0, v0}, Ljava/io/PrintStream;-><init>(Ljava/io/OutputStream;)V

    .line 38
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iput-object v0, p0, Lcom/android/internal/os/LoggingPrintStream;->builder:Ljava/lang/StringBuilder;

    .line 182
    new-instance v0, Ljava/util/Formatter;

    iget-object v1, p0, Lcom/android/internal/os/LoggingPrintStream;->builder:Ljava/lang/StringBuilder;

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Ljava/util/Formatter;-><init>(Ljava/lang/Appendable;Ljava/util/Locale;)V

    iput-object v0, p0, Lcom/android/internal/os/LoggingPrintStream;->formatter:Ljava/util/Formatter;

    .line 67
    return-void
.end method

.method private flush(Z)V
    .registers 8
    .parameter "completely"

    .prologue
    const/4 v5, 0x0

    .line 86
    iget-object v3, p0, Lcom/android/internal/os/LoggingPrintStream;->builder:Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->length()I

    move-result v0

    .line 88
    .local v0, length:I
    const/4 v2, 0x0

    .line 93
    .local v2, start:I
    :goto_8
    if-ge v2, v0, :cond_21

    iget-object v3, p0, Lcom/android/internal/os/LoggingPrintStream;->builder:Ljava/lang/StringBuilder;

    const-string v4, "\n"

    invoke-virtual {v3, v4, v2}, Ljava/lang/StringBuilder;->indexOf(Ljava/lang/String;I)I

    move-result v1

    .local v1, nextBreak:I
    const/4 v3, -0x1

    if-eq v1, v3, :cond_21

    .line 94
    iget-object v3, p0, Lcom/android/internal/os/LoggingPrintStream;->builder:Ljava/lang/StringBuilder;

    invoke-virtual {v3, v2, v1}, Ljava/lang/StringBuilder;->substring(II)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v3}, Lcom/android/internal/os/LoggingPrintStream;->log(Ljava/lang/String;)V

    .line 95
    add-int/lit8 v2, v1, 0x1

    goto :goto_8

    .line 98
    .end local v1           #nextBreak:I
    :cond_21
    if-eqz p1, :cond_34

    .line 100
    if-ge v2, v0, :cond_2e

    .line 101
    iget-object v3, p0, Lcom/android/internal/os/LoggingPrintStream;->builder:Ljava/lang/StringBuilder;

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->substring(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v3}, Lcom/android/internal/os/LoggingPrintStream;->log(Ljava/lang/String;)V

    .line 103
    :cond_2e
    iget-object v3, p0, Lcom/android/internal/os/LoggingPrintStream;->builder:Ljava/lang/StringBuilder;

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->setLength(I)V

    .line 108
    :goto_33
    return-void

    .line 106
    :cond_34
    iget-object v3, p0, Lcom/android/internal/os/LoggingPrintStream;->builder:Ljava/lang/StringBuilder;

    invoke-virtual {v3, v5, v2}, Ljava/lang/StringBuilder;->delete(II)Ljava/lang/StringBuilder;

    goto :goto_33
.end method


# virtual methods
.method public declared-synchronized append(C)Ljava/io/PrintStream;
    .registers 3
    .parameter "c"

    .prologue
    .line 327
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0, p1}, Lcom/android/internal/os/LoggingPrintStream;->print(C)V
    :try_end_4
    .catchall {:try_start_1 .. :try_end_4} :catchall_6

    .line 328
    monitor-exit p0

    return-object p0

    .line 327
    :catchall_6
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized append(Ljava/lang/CharSequence;)Ljava/io/PrintStream;
    .registers 3
    .parameter "csq"

    .prologue
    .line 333
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lcom/android/internal/os/LoggingPrintStream;->builder:Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;

    .line 334
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/android/internal/os/LoggingPrintStream;->flush(Z)V
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_c

    .line 335
    monitor-exit p0

    return-object p0

    .line 333
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized append(Ljava/lang/CharSequence;II)Ljava/io/PrintStream;
    .registers 5
    .parameter "csq"
    .parameter "start"
    .parameter "end"

    .prologue
    .line 341
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lcom/android/internal/os/LoggingPrintStream;->builder:Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1, p2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;II)Ljava/lang/StringBuilder;

    .line 342
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/android/internal/os/LoggingPrintStream;->flush(Z)V
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_c

    .line 343
    monitor-exit p0

    return-object p0

    .line 341
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public bridge synthetic append(C)Ljava/lang/Appendable;
    .registers 3
    .parameter "x0"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 36
    invoke-virtual {p0, p1}, Lcom/android/internal/os/LoggingPrintStream;->append(C)Ljava/io/PrintStream;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic append(Ljava/lang/CharSequence;)Ljava/lang/Appendable;
    .registers 3
    .parameter "x0"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 36
    invoke-virtual {p0, p1}, Lcom/android/internal/os/LoggingPrintStream;->append(Ljava/lang/CharSequence;)Ljava/io/PrintStream;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic append(Ljava/lang/CharSequence;II)Ljava/lang/Appendable;
    .registers 5
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 36
    invoke-virtual {p0, p1, p2, p3}, Lcom/android/internal/os/LoggingPrintStream;->append(Ljava/lang/CharSequence;II)Ljava/io/PrintStream;

    move-result-object v0

    return-object v0
.end method

.method public checkError()Z
    .registers 2

    .prologue
    .line 156
    const/4 v0, 0x0

    return v0
.end method

.method public close()V
    .registers 1

    .prologue
    .line 165
    return-void
.end method

.method public declared-synchronized flush()V
    .registers 2

    .prologue
    .line 76
    monitor-enter p0

    const/4 v0, 0x1

    :try_start_2
    invoke-direct {p0, v0}, Lcom/android/internal/os/LoggingPrintStream;->flush(Z)V
    :try_end_5
    .catchall {:try_start_2 .. :try_end_5} :catchall_7

    .line 77
    monitor-exit p0

    return-void

    .line 76
    :catchall_7
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public varargs format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
    .registers 4
    .parameter "format"
    .parameter "args"

    .prologue
    .line 169
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v0

    invoke-virtual {p0, v0, p1, p2}, Lcom/android/internal/os/LoggingPrintStream;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;

    move-result-object v0

    return-object v0
.end method

.method public varargs declared-synchronized format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
    .registers 6
    .parameter "l"
    .parameter "format"
    .parameter "args"

    .prologue
    .line 187
    monitor-enter p0

    if-nez p2, :cond_e

    .line 188
    :try_start_3
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "format"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_b
    .catchall {:try_start_3 .. :try_end_b} :catchall_b

    .line 187
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0

    .line 191
    :cond_e
    :try_start_e
    iget-object v0, p0, Lcom/android/internal/os/LoggingPrintStream;->formatter:Ljava/util/Formatter;

    invoke-virtual {v0, p1, p2, p3}, Ljava/util/Formatter;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/util/Formatter;

    .line 192
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/android/internal/os/LoggingPrintStream;->flush(Z)V
    :try_end_17
    .catchall {:try_start_e .. :try_end_17} :catchall_b

    .line 193
    monitor-exit p0

    return-object p0
.end method

.method protected abstract log(Ljava/lang/String;)V
.end method

.method public declared-synchronized print(C)V
    .registers 3
    .parameter "ch"

    .prologue
    .line 204
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lcom/android/internal/os/LoggingPrintStream;->builder:Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 205
    const/16 v0, 0xa

    if-ne p1, v0, :cond_e

    .line 206
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/android/internal/os/LoggingPrintStream;->flush(Z)V
    :try_end_e
    .catchall {:try_start_1 .. :try_end_e} :catchall_10

    .line 208
    :cond_e
    monitor-exit p0

    return-void

    .line 204
    :catchall_10
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized print(D)V
    .registers 4
    .parameter "dnum"

    .prologue
    .line 212
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lcom/android/internal/os/LoggingPrintStream;->builder:Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1, p2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;
    :try_end_6
    .catchall {:try_start_1 .. :try_end_6} :catchall_8

    .line 213
    monitor-exit p0

    return-void

    .line 212
    :catchall_8
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized print(F)V
    .registers 3
    .parameter "fnum"

    .prologue
    .line 217
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lcom/android/internal/os/LoggingPrintStream;->builder:Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;
    :try_end_6
    .catchall {:try_start_1 .. :try_end_6} :catchall_8

    .line 218
    monitor-exit p0

    return-void

    .line 217
    :catchall_8
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized print(I)V
    .registers 3
    .parameter "inum"

    .prologue
    .line 222
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lcom/android/internal/os/LoggingPrintStream;->builder:Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    :try_end_6
    .catchall {:try_start_1 .. :try_end_6} :catchall_8

    .line 223
    monitor-exit p0

    return-void

    .line 222
    :catchall_8
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized print(J)V
    .registers 4
    .parameter "lnum"

    .prologue
    .line 227
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lcom/android/internal/os/LoggingPrintStream;->builder:Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    :try_end_6
    .catchall {:try_start_1 .. :try_end_6} :catchall_8

    .line 228
    monitor-exit p0

    return-void

    .line 227
    :catchall_8
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized print(Ljava/lang/Object;)V
    .registers 3
    .parameter "obj"

    .prologue
    .line 232
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lcom/android/internal/os/LoggingPrintStream;->builder:Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 233
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/android/internal/os/LoggingPrintStream;->flush(Z)V
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_c

    .line 234
    monitor-exit p0

    return-void

    .line 232
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized print(Ljava/lang/String;)V
    .registers 3
    .parameter "str"

    .prologue
    .line 238
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lcom/android/internal/os/LoggingPrintStream;->builder:Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 239
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/android/internal/os/LoggingPrintStream;->flush(Z)V
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_c

    .line 240
    monitor-exit p0

    return-void

    .line 238
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized print(Z)V
    .registers 3
    .parameter "bool"

    .prologue
    .line 244
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lcom/android/internal/os/LoggingPrintStream;->builder:Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    :try_end_6
    .catchall {:try_start_1 .. :try_end_6} :catchall_8

    .line 245
    monitor-exit p0

    return-void

    .line 244
    :catchall_8
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized print([C)V
    .registers 3
    .parameter "charArray"

    .prologue
    .line 198
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lcom/android/internal/os/LoggingPrintStream;->builder:Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append([C)Ljava/lang/StringBuilder;

    .line 199
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/android/internal/os/LoggingPrintStream;->flush(Z)V
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_c

    .line 200
    monitor-exit p0

    return-void

    .line 198
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public varargs printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
    .registers 4
    .parameter "format"
    .parameter "args"

    .prologue
    .line 174
    invoke-virtual {p0, p1, p2}, Lcom/android/internal/os/LoggingPrintStream;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;

    move-result-object v0

    return-object v0
.end method

.method public varargs printf(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
    .registers 5
    .parameter "l"
    .parameter "format"
    .parameter "args"

    .prologue
    .line 179
    invoke-virtual {p0, p1, p2, p3}, Lcom/android/internal/os/LoggingPrintStream;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;

    move-result-object v0

    return-object v0
.end method

.method public declared-synchronized println()V
    .registers 2

    .prologue
    .line 249
    monitor-enter p0

    const/4 v0, 0x1

    :try_start_2
    invoke-direct {p0, v0}, Lcom/android/internal/os/LoggingPrintStream;->flush(Z)V
    :try_end_5
    .catchall {:try_start_2 .. :try_end_5} :catchall_7

    .line 250
    monitor-exit p0

    return-void

    .line 249
    :catchall_7
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized println(C)V
    .registers 3
    .parameter "ch"

    .prologue
    .line 260
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lcom/android/internal/os/LoggingPrintStream;->builder:Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 261
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/android/internal/os/LoggingPrintStream;->flush(Z)V
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_c

    .line 262
    monitor-exit p0

    return-void

    .line 260
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized println(D)V
    .registers 4
    .parameter "dnum"

    .prologue
    .line 266
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lcom/android/internal/os/LoggingPrintStream;->builder:Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1, p2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    .line 267
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/android/internal/os/LoggingPrintStream;->flush(Z)V
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_c

    .line 268
    monitor-exit p0

    return-void

    .line 266
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized println(F)V
    .registers 3
    .parameter "fnum"

    .prologue
    .line 272
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lcom/android/internal/os/LoggingPrintStream;->builder:Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    .line 273
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/android/internal/os/LoggingPrintStream;->flush(Z)V
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_c

    .line 274
    monitor-exit p0

    return-void

    .line 272
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized println(I)V
    .registers 3
    .parameter "inum"

    .prologue
    .line 278
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lcom/android/internal/os/LoggingPrintStream;->builder:Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 279
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/android/internal/os/LoggingPrintStream;->flush(Z)V
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_c

    .line 280
    monitor-exit p0

    return-void

    .line 278
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized println(J)V
    .registers 4
    .parameter "lnum"

    .prologue
    .line 284
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lcom/android/internal/os/LoggingPrintStream;->builder:Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    .line 285
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/android/internal/os/LoggingPrintStream;->flush(Z)V
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_c

    .line 286
    monitor-exit p0

    return-void

    .line 284
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized println(Ljava/lang/Object;)V
    .registers 3
    .parameter "obj"

    .prologue
    .line 290
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lcom/android/internal/os/LoggingPrintStream;->builder:Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 291
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/android/internal/os/LoggingPrintStream;->flush(Z)V
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_c

    .line 292
    monitor-exit p0

    return-void

    .line 290
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized println(Ljava/lang/String;)V
    .registers 6
    .parameter "s"

    .prologue
    .line 296
    monitor-enter p0

    :try_start_1
    iget-object v3, p0, Lcom/android/internal/os/LoggingPrintStream;->builder:Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->length()I

    move-result v3

    if-nez v3, :cond_2e

    .line 298
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    .line 300
    .local v0, length:I
    const/4 v2, 0x0

    .line 305
    .local v2, start:I
    :goto_e
    if-ge v2, v0, :cond_23

    const/16 v3, 0xa

    invoke-virtual {p1, v3, v2}, Ljava/lang/String;->indexOf(II)I

    move-result v1

    .local v1, nextBreak:I
    const/4 v3, -0x1

    if-eq v1, v3, :cond_23

    .line 306
    invoke-virtual {p1, v2, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v3}, Lcom/android/internal/os/LoggingPrintStream;->log(Ljava/lang/String;)V

    .line 307
    add-int/lit8 v2, v1, 0x1

    goto :goto_e

    .line 310
    .end local v1           #nextBreak:I
    :cond_23
    if-ge v2, v0, :cond_2c

    .line 311
    invoke-virtual {p1, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v3}, Lcom/android/internal/os/LoggingPrintStream;->log(Ljava/lang/String;)V
    :try_end_2c
    .catchall {:try_start_1 .. :try_end_2c} :catchall_38

    .line 317
    .end local v0           #length:I
    .end local v2           #start:I
    :cond_2c
    :goto_2c
    monitor-exit p0

    return-void

    .line 314
    :cond_2e
    :try_start_2e
    iget-object v3, p0, Lcom/android/internal/os/LoggingPrintStream;->builder:Ljava/lang/StringBuilder;

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 315
    const/4 v3, 0x1

    invoke-direct {p0, v3}, Lcom/android/internal/os/LoggingPrintStream;->flush(Z)V
    :try_end_37
    .catchall {:try_start_2e .. :try_end_37} :catchall_38

    goto :goto_2c

    .line 296
    :catchall_38
    move-exception v3

    monitor-exit p0

    throw v3
.end method

.method public declared-synchronized println(Z)V
    .registers 3
    .parameter "bool"

    .prologue
    .line 321
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lcom/android/internal/os/LoggingPrintStream;->builder:Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    .line 322
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/android/internal/os/LoggingPrintStream;->flush(Z)V
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_c

    .line 323
    monitor-exit p0

    return-void

    .line 321
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized println([C)V
    .registers 3
    .parameter "charArray"

    .prologue
    .line 254
    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lcom/android/internal/os/LoggingPrintStream;->builder:Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append([C)Ljava/lang/StringBuilder;

    .line 255
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/android/internal/os/LoggingPrintStream;->flush(Z)V
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_c

    .line 256
    monitor-exit p0

    return-void

    .line 254
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method protected setError()V
    .registers 1

    .prologue
    .line 161
    return-void
.end method

.method public write(I)V
    .registers 6
    .parameter "oneByte"

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 111
    new-array v0, v3, [B

    int-to-byte v1, p1

    aput-byte v1, v0, v2

    invoke-virtual {p0, v0, v2, v3}, Lcom/android/internal/os/LoggingPrintStream;->write([BII)V

    .line 112
    return-void
.end method

.method public write([B)V
    .registers 4
    .parameter "buffer"

    .prologue
    .line 116
    const/4 v0, 0x0

    array-length v1, p1

    invoke-virtual {p0, p1, v0, v1}, Lcom/android/internal/os/LoggingPrintStream;->write([BII)V

    .line 117
    return-void
.end method

.method public declared-synchronized write([BII)V
    .registers 11
    .parameter "bytes"
    .parameter "start"
    .parameter "count"

    .prologue
    .line 121
    monitor-enter p0

    :try_start_1
    iget-object v3, p0, Lcom/android/internal/os/LoggingPrintStream;->decoder:Ljava/nio/charset/CharsetDecoder;

    if-nez v3, :cond_2b

    .line 122
    const/16 v3, 0x50

    invoke-static {v3}, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;

    move-result-object v3

    iput-object v3, p0, Lcom/android/internal/os/LoggingPrintStream;->encodedBytes:Ljava/nio/ByteBuffer;

    .line 123
    const/16 v3, 0x50

    invoke-static {v3}, Ljava/nio/CharBuffer;->allocate(I)Ljava/nio/CharBuffer;

    move-result-object v3

    iput-object v3, p0, Lcom/android/internal/os/LoggingPrintStream;->decodedChars:Ljava/nio/CharBuffer;

    .line 124
    invoke-static {}, Ljava/nio/charset/Charset;->defaultCharset()Ljava/nio/charset/Charset;

    move-result-object v3

    invoke-virtual {v3}, Ljava/nio/charset/Charset;->newDecoder()Ljava/nio/charset/CharsetDecoder;

    move-result-object v3

    sget-object v4, Ljava/nio/charset/CodingErrorAction;->REPLACE:Ljava/nio/charset/CodingErrorAction;

    invoke-virtual {v3, v4}, Ljava/nio/charset/CharsetDecoder;->onMalformedInput(Ljava/nio/charset/CodingErrorAction;)Ljava/nio/charset/CharsetDecoder;

    move-result-object v3

    sget-object v4, Ljava/nio/charset/CodingErrorAction;->REPLACE:Ljava/nio/charset/CodingErrorAction;

    invoke-virtual {v3, v4}, Ljava/nio/charset/CharsetDecoder;->onUnmappableCharacter(Ljava/nio/charset/CodingErrorAction;)Ljava/nio/charset/CharsetDecoder;

    move-result-object v3

    iput-object v3, p0, Lcom/android/internal/os/LoggingPrintStream;->decoder:Ljava/nio/charset/CharsetDecoder;

    .line 129
    :cond_2b
    add-int v1, p2, p3

    .line 130
    .local v1, end:I
    :goto_2d
    if-ge p2, v1, :cond_71

    .line 133
    iget-object v3, p0, Lcom/android/internal/os/LoggingPrintStream;->encodedBytes:Ljava/nio/ByteBuffer;

    invoke-virtual {v3}, Ljava/nio/ByteBuffer;->remaining()I

    move-result v3

    sub-int v4, v1, p2

    invoke-static {v3, v4}, Ljava/lang/Math;->min(II)I

    move-result v2

    .line 134
    .local v2, numBytes:I
    iget-object v3, p0, Lcom/android/internal/os/LoggingPrintStream;->encodedBytes:Ljava/nio/ByteBuffer;

    invoke-virtual {v3, p1, p2, v2}, Ljava/nio/ByteBuffer;->put([BII)Ljava/nio/ByteBuffer;

    .line 135
    add-int/2addr p2, v2

    .line 137
    iget-object v3, p0, Lcom/android/internal/os/LoggingPrintStream;->encodedBytes:Ljava/nio/ByteBuffer;

    invoke-virtual {v3}, Ljava/nio/ByteBuffer;->flip()Ljava/nio/Buffer;

    .line 141
    :cond_46
    iget-object v3, p0, Lcom/android/internal/os/LoggingPrintStream;->decoder:Ljava/nio/charset/CharsetDecoder;

    iget-object v4, p0, Lcom/android/internal/os/LoggingPrintStream;->encodedBytes:Ljava/nio/ByteBuffer;

    iget-object v5, p0, Lcom/android/internal/os/LoggingPrintStream;->decodedChars:Ljava/nio/CharBuffer;

    const/4 v6, 0x0

    invoke-virtual {v3, v4, v5, v6}, Ljava/nio/charset/CharsetDecoder;->decode(Ljava/nio/ByteBuffer;Ljava/nio/CharBuffer;Z)Ljava/nio/charset/CoderResult;

    move-result-object v0

    .line 144
    .local v0, coderResult:Ljava/nio/charset/CoderResult;
    iget-object v3, p0, Lcom/android/internal/os/LoggingPrintStream;->decodedChars:Ljava/nio/CharBuffer;

    invoke-virtual {v3}, Ljava/nio/CharBuffer;->flip()Ljava/nio/Buffer;

    .line 145
    iget-object v3, p0, Lcom/android/internal/os/LoggingPrintStream;->builder:Ljava/lang/StringBuilder;

    iget-object v4, p0, Lcom/android/internal/os/LoggingPrintStream;->decodedChars:Ljava/nio/CharBuffer;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;

    .line 146
    iget-object v3, p0, Lcom/android/internal/os/LoggingPrintStream;->decodedChars:Ljava/nio/CharBuffer;

    invoke-virtual {v3}, Ljava/nio/CharBuffer;->clear()Ljava/nio/Buffer;

    .line 147
    invoke-virtual {v0}, Ljava/nio/charset/CoderResult;->isOverflow()Z

    move-result v3

    if-nez v3, :cond_46

    .line 148
    iget-object v3, p0, Lcom/android/internal/os/LoggingPrintStream;->encodedBytes:Ljava/nio/ByteBuffer;

    invoke-virtual {v3}, Ljava/nio/ByteBuffer;->compact()Ljava/nio/ByteBuffer;
    :try_end_6d
    .catchall {:try_start_1 .. :try_end_6d} :catchall_6e

    goto :goto_2d

    .line 121
    .end local v0           #coderResult:Ljava/nio/charset/CoderResult;
    .end local v1           #end:I
    .end local v2           #numBytes:I
    :catchall_6e
    move-exception v3

    monitor-exit p0

    throw v3

    .line 150
    .restart local v1       #end:I
    :cond_71
    const/4 v3, 0x0

    :try_start_72
    invoke-direct {p0, v3}, Lcom/android/internal/os/LoggingPrintStream;->flush(Z)V
    :try_end_75
    .catchall {:try_start_72 .. :try_end_75} :catchall_6e

    .line 151
    monitor-exit p0

    return-void
.end method
