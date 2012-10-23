.class public Landroid/content/pm/LimitedLengthInputStream;
.super Ljava/io/FilterInputStream;
.source "LimitedLengthInputStream.java"


# instance fields
.field private final mEnd:J

.field private mOffset:J


# direct methods
.method public constructor <init>(Ljava/io/InputStream;JJ)V
    .registers 9
    .parameter "in"
    .parameter "offset"
    .parameter "length"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const-wide/16 v1, 0x0

    .line 33
    invoke-direct {p0, p1}, Ljava/io/FilterInputStream;-><init>(Ljava/io/InputStream;)V

    .line 35
    if-nez p1, :cond_f

    .line 36
    new-instance v0, Ljava/io/IOException;

    const-string v1, "in == null"

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 39
    :cond_f
    cmp-long v0, p2, v1

    if-gez v0, :cond_1c

    .line 40
    new-instance v0, Ljava/io/IOException;

    const-string/jumbo v1, "offset < 0"

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 43
    :cond_1c
    cmp-long v0, p4, v1

    if-gez v0, :cond_29

    .line 44
    new-instance v0, Ljava/io/IOException;

    const-string/jumbo v1, "length < 0"

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 47
    :cond_29
    const-wide v0, 0x7fffffffffffffffL

    sub-long/2addr v0, p2

    cmp-long v0, p4, v0

    if-lez v0, :cond_3c

    .line 48
    new-instance v0, Ljava/io/IOException;

    const-string/jumbo v1, "offset + length > Long.MAX_VALUE"

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 51
    :cond_3c
    add-long v0, p2, p4

    iput-wide v0, p0, Landroid/content/pm/LimitedLengthInputStream;->mEnd:J

    .line 53
    invoke-virtual {p0, p2, p3}, Landroid/content/pm/LimitedLengthInputStream;->skip(J)J

    .line 54
    iput-wide p2, p0, Landroid/content/pm/LimitedLengthInputStream;->mOffset:J

    .line 55
    return-void
.end method


# virtual methods
.method public declared-synchronized read()I
    .registers 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 59
    monitor-enter p0

    :try_start_1
    iget-wide v0, p0, Landroid/content/pm/LimitedLengthInputStream;->mOffset:J

    iget-wide v2, p0, Landroid/content/pm/LimitedLengthInputStream;->mEnd:J
    :try_end_5
    .catchall {:try_start_1 .. :try_end_5} :catchall_18

    cmp-long v0, v0, v2

    if-ltz v0, :cond_c

    .line 60
    const/4 v0, -0x1

    .line 64
    :goto_a
    monitor-exit p0

    return v0

    .line 63
    :cond_c
    :try_start_c
    iget-wide v0, p0, Landroid/content/pm/LimitedLengthInputStream;->mOffset:J

    const-wide/16 v2, 0x1

    add-long/2addr v0, v2

    iput-wide v0, p0, Landroid/content/pm/LimitedLengthInputStream;->mOffset:J

    .line 64
    invoke-super {p0}, Ljava/io/FilterInputStream;->read()I
    :try_end_16
    .catchall {:try_start_c .. :try_end_16} :catchall_18

    move-result v0

    goto :goto_a

    .line 59
    :catchall_18
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public read([B)I
    .registers 4
    .parameter "buffer"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 92
    const/4 v0, 0x0

    array-length v1, p1

    invoke-virtual {p0, p1, v0, v1}, Landroid/content/pm/LimitedLengthInputStream;->read([BII)I

    move-result v0

    return v0
.end method

.method public read([BII)I
    .registers 12
    .parameter "buffer"
    .parameter "offset"
    .parameter "byteCount"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 69
    iget-wide v2, p0, Landroid/content/pm/LimitedLengthInputStream;->mOffset:J

    iget-wide v4, p0, Landroid/content/pm/LimitedLengthInputStream;->mEnd:J

    cmp-long v2, v2, v4

    if-ltz v2, :cond_a

    .line 70
    const/4 v1, -0x1

    .line 87
    :goto_9
    return v1

    .line 73
    :cond_a
    array-length v0, p1

    .line 74
    .local v0, arrayLength:I
    invoke-static {v0, p2, p3}, Ljava/util/Arrays;->checkOffsetAndCount(III)V

    .line 76
    iget-wide v2, p0, Landroid/content/pm/LimitedLengthInputStream;->mOffset:J

    const-wide v4, 0x7fffffffffffffffL

    int-to-long v6, p3

    sub-long/2addr v4, v6

    cmp-long v2, v2, v4

    if-lez v2, :cond_41

    .line 77
    new-instance v2, Ljava/io/IOException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "offset out of bounds: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-wide v4, p0, Landroid/content/pm/LimitedLengthInputStream;->mOffset:J

    invoke-virtual {v3, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " + "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 80
    :cond_41
    iget-wide v2, p0, Landroid/content/pm/LimitedLengthInputStream;->mOffset:J

    int-to-long v4, p3

    add-long/2addr v2, v4

    iget-wide v4, p0, Landroid/content/pm/LimitedLengthInputStream;->mEnd:J

    cmp-long v2, v2, v4

    if-lez v2, :cond_51

    .line 81
    iget-wide v2, p0, Landroid/content/pm/LimitedLengthInputStream;->mEnd:J

    iget-wide v4, p0, Landroid/content/pm/LimitedLengthInputStream;->mOffset:J

    sub-long/2addr v2, v4

    long-to-int p3, v2

    .line 84
    :cond_51
    invoke-super {p0, p1, p2, p3}, Ljava/io/FilterInputStream;->read([BII)I

    move-result v1

    .line 85
    .local v1, numRead:I
    iget-wide v2, p0, Landroid/content/pm/LimitedLengthInputStream;->mOffset:J

    int-to-long v4, v1

    add-long/2addr v2, v4

    iput-wide v2, p0, Landroid/content/pm/LimitedLengthInputStream;->mOffset:J

    goto :goto_9
.end method
