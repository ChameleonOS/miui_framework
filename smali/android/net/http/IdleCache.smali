.class Landroid/net/http/IdleCache;
.super Ljava/lang/Object;
.source "IdleCache.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/net/http/IdleCache$1;,
        Landroid/net/http/IdleCache$IdleReaper;,
        Landroid/net/http/IdleCache$Entry;
    }
.end annotation


# static fields
.field private static final CHECK_INTERVAL:I = 0x7d0

.field private static final EMPTY_CHECK_MAX:I = 0x5

.field private static final IDLE_CACHE_MAX:I = 0x8

.field private static final TIMEOUT:I = 0x1770


# instance fields
.field private mCached:I

.field private mCount:I

.field private mEntries:[Landroid/net/http/IdleCache$Entry;

.field private mReused:I

.field private mThread:Landroid/net/http/IdleCache$IdleReaper;


# direct methods
.method constructor <init>()V
    .registers 5

    .prologue
    const/16 v3, 0x8

    const/4 v2, 0x0

    .line 56
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 46
    new-array v1, v3, [Landroid/net/http/IdleCache$Entry;

    iput-object v1, p0, Landroid/net/http/IdleCache;->mEntries:[Landroid/net/http/IdleCache$Entry;

    .line 48
    iput v2, p0, Landroid/net/http/IdleCache;->mCount:I

    .line 50
    const/4 v1, 0x0

    iput-object v1, p0, Landroid/net/http/IdleCache;->mThread:Landroid/net/http/IdleCache$IdleReaper;

    .line 53
    iput v2, p0, Landroid/net/http/IdleCache;->mCached:I

    .line 54
    iput v2, p0, Landroid/net/http/IdleCache;->mReused:I

    .line 57
    const/4 v0, 0x0

    .local v0, i:I
    :goto_14
    if-ge v0, v3, :cond_22

    .line 58
    iget-object v1, p0, Landroid/net/http/IdleCache;->mEntries:[Landroid/net/http/IdleCache$Entry;

    new-instance v2, Landroid/net/http/IdleCache$Entry;

    invoke-direct {v2, p0}, Landroid/net/http/IdleCache$Entry;-><init>(Landroid/net/http/IdleCache;)V

    aput-object v2, v1, v0

    .line 57
    add-int/lit8 v0, v0, 0x1

    goto :goto_14

    .line 60
    :cond_22
    return-void
.end method

.method static synthetic access$100(Landroid/net/http/IdleCache;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 30
    iget v0, p0, Landroid/net/http/IdleCache;->mCount:I

    return v0
.end method

.method static synthetic access$200(Landroid/net/http/IdleCache;)V
    .registers 1
    .parameter "x0"

    .prologue
    .line 30
    invoke-direct {p0}, Landroid/net/http/IdleCache;->clearIdle()V

    return-void
.end method

.method static synthetic access$302(Landroid/net/http/IdleCache;Landroid/net/http/IdleCache$IdleReaper;)Landroid/net/http/IdleCache$IdleReaper;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 30
    iput-object p1, p0, Landroid/net/http/IdleCache;->mThread:Landroid/net/http/IdleCache$IdleReaper;

    return-object p1
.end method

.method private declared-synchronized clearIdle()V
    .registers 7

    .prologue
    .line 130
    monitor-enter p0

    :try_start_1
    iget v4, p0, Landroid/net/http/IdleCache;->mCount:I

    if-lez v4, :cond_30

    .line 131
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v2

    .line 132
    .local v2, time:J
    const/4 v1, 0x0

    .local v1, i:I
    :goto_a
    const/16 v4, 0x8

    if-ge v1, v4, :cond_30

    .line 133
    iget-object v4, p0, Landroid/net/http/IdleCache;->mEntries:[Landroid/net/http/IdleCache$Entry;

    aget-object v0, v4, v1

    .line 134
    .local v0, entry:Landroid/net/http/IdleCache$Entry;
    iget-object v4, v0, Landroid/net/http/IdleCache$Entry;->mHost:Lorg/apache/http/HttpHost;

    if-eqz v4, :cond_2d

    iget-wide v4, v0, Landroid/net/http/IdleCache$Entry;->mTimeout:J

    cmp-long v4, v2, v4

    if-lez v4, :cond_2d

    .line 135
    const/4 v4, 0x0

    iput-object v4, v0, Landroid/net/http/IdleCache$Entry;->mHost:Lorg/apache/http/HttpHost;

    .line 136
    iget-object v4, v0, Landroid/net/http/IdleCache$Entry;->mConnection:Landroid/net/http/Connection;

    invoke-virtual {v4}, Landroid/net/http/Connection;->closeConnection()V

    .line 137
    const/4 v4, 0x0

    iput-object v4, v0, Landroid/net/http/IdleCache$Entry;->mConnection:Landroid/net/http/Connection;

    .line 138
    iget v4, p0, Landroid/net/http/IdleCache;->mCount:I

    add-int/lit8 v4, v4, -0x1

    iput v4, p0, Landroid/net/http/IdleCache;->mCount:I
    :try_end_2d
    .catchall {:try_start_1 .. :try_end_2d} :catchall_32

    .line 132
    :cond_2d
    add-int/lit8 v1, v1, 0x1

    goto :goto_a

    .line 142
    .end local v0           #entry:Landroid/net/http/IdleCache$Entry;
    .end local v1           #i:I
    .end local v2           #time:J
    :cond_30
    monitor-exit p0

    return-void

    .line 130
    :catchall_32
    move-exception v4

    monitor-exit p0

    throw v4
.end method


# virtual methods
.method declared-synchronized cacheConnection(Lorg/apache/http/HttpHost;Landroid/net/http/Connection;)Z
    .registers 10
    .parameter "host"
    .parameter "connection"

    .prologue
    const/16 v6, 0x8

    .line 69
    monitor-enter p0

    const/4 v2, 0x0

    .line 75
    .local v2, ret:Z
    :try_start_4
    iget v5, p0, Landroid/net/http/IdleCache;->mCount:I

    if-ge v5, v6, :cond_38

    .line 76
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v3

    .line 77
    .local v3, time:J
    const/4 v1, 0x0

    .local v1, i:I
    :goto_d
    if-ge v1, v6, :cond_38

    .line 78
    iget-object v5, p0, Landroid/net/http/IdleCache;->mEntries:[Landroid/net/http/IdleCache$Entry;

    aget-object v0, v5, v1

    .line 79
    .local v0, entry:Landroid/net/http/IdleCache$Entry;
    iget-object v5, v0, Landroid/net/http/IdleCache$Entry;->mHost:Lorg/apache/http/HttpHost;

    if-nez v5, :cond_3a

    .line 80
    iput-object p1, v0, Landroid/net/http/IdleCache$Entry;->mHost:Lorg/apache/http/HttpHost;

    .line 81
    iput-object p2, v0, Landroid/net/http/IdleCache$Entry;->mConnection:Landroid/net/http/Connection;

    .line 82
    const-wide/16 v5, 0x1770

    add-long/2addr v5, v3

    iput-wide v5, v0, Landroid/net/http/IdleCache$Entry;->mTimeout:J

    .line 83
    iget v5, p0, Landroid/net/http/IdleCache;->mCount:I

    add-int/lit8 v5, v5, 0x1

    iput v5, p0, Landroid/net/http/IdleCache;->mCount:I

    .line 85
    const/4 v2, 0x1

    .line 86
    iget-object v5, p0, Landroid/net/http/IdleCache;->mThread:Landroid/net/http/IdleCache$IdleReaper;

    if-nez v5, :cond_38

    .line 87
    new-instance v5, Landroid/net/http/IdleCache$IdleReaper;

    const/4 v6, 0x0

    invoke-direct {v5, p0, v6}, Landroid/net/http/IdleCache$IdleReaper;-><init>(Landroid/net/http/IdleCache;Landroid/net/http/IdleCache$1;)V

    iput-object v5, p0, Landroid/net/http/IdleCache;->mThread:Landroid/net/http/IdleCache$IdleReaper;

    .line 88
    iget-object v5, p0, Landroid/net/http/IdleCache;->mThread:Landroid/net/http/IdleCache$IdleReaper;

    invoke-virtual {v5}, Landroid/net/http/IdleCache$IdleReaper;->start()V
    :try_end_38
    .catchall {:try_start_4 .. :try_end_38} :catchall_3d

    .line 94
    .end local v0           #entry:Landroid/net/http/IdleCache$Entry;
    .end local v1           #i:I
    .end local v3           #time:J
    :cond_38
    monitor-exit p0

    return v2

    .line 77
    .restart local v0       #entry:Landroid/net/http/IdleCache$Entry;
    .restart local v1       #i:I
    .restart local v3       #time:J
    :cond_3a
    add-int/lit8 v1, v1, 0x1

    goto :goto_d

    .line 69
    .end local v0           #entry:Landroid/net/http/IdleCache$Entry;
    .end local v1           #i:I
    .end local v3           #time:J
    :catchall_3d
    move-exception v5

    monitor-exit p0

    throw v5
.end method

.method declared-synchronized clear()V
    .registers 4

    .prologue
    .line 118
    monitor-enter p0

    const/4 v1, 0x0

    .local v1, i:I
    :goto_2
    :try_start_2
    iget v2, p0, Landroid/net/http/IdleCache;->mCount:I

    if-lez v2, :cond_26

    const/16 v2, 0x8

    if-ge v1, v2, :cond_26

    .line 119
    iget-object v2, p0, Landroid/net/http/IdleCache;->mEntries:[Landroid/net/http/IdleCache$Entry;

    aget-object v0, v2, v1

    .line 120
    .local v0, entry:Landroid/net/http/IdleCache$Entry;
    iget-object v2, v0, Landroid/net/http/IdleCache$Entry;->mHost:Lorg/apache/http/HttpHost;

    if-eqz v2, :cond_23

    .line 121
    const/4 v2, 0x0

    iput-object v2, v0, Landroid/net/http/IdleCache$Entry;->mHost:Lorg/apache/http/HttpHost;

    .line 122
    iget-object v2, v0, Landroid/net/http/IdleCache$Entry;->mConnection:Landroid/net/http/Connection;

    invoke-virtual {v2}, Landroid/net/http/Connection;->closeConnection()V

    .line 123
    const/4 v2, 0x0

    iput-object v2, v0, Landroid/net/http/IdleCache$Entry;->mConnection:Landroid/net/http/Connection;

    .line 124
    iget v2, p0, Landroid/net/http/IdleCache;->mCount:I

    add-int/lit8 v2, v2, -0x1

    iput v2, p0, Landroid/net/http/IdleCache;->mCount:I
    :try_end_23
    .catchall {:try_start_2 .. :try_end_23} :catchall_28

    .line 118
    :cond_23
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    .line 127
    .end local v0           #entry:Landroid/net/http/IdleCache$Entry;
    :cond_26
    monitor-exit p0

    return-void

    .line 118
    :catchall_28
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method declared-synchronized getConnection(Lorg/apache/http/HttpHost;)Landroid/net/http/Connection;
    .registers 7
    .parameter "host"

    .prologue
    .line 98
    monitor-enter p0

    const/4 v3, 0x0

    .line 100
    .local v3, ret:Landroid/net/http/Connection;
    :try_start_2
    iget v4, p0, Landroid/net/http/IdleCache;->mCount:I

    if-lez v4, :cond_27

    .line 101
    const/4 v2, 0x0

    .local v2, i:I
    :goto_7
    const/16 v4, 0x8

    if-ge v2, v4, :cond_27

    .line 102
    iget-object v4, p0, Landroid/net/http/IdleCache;->mEntries:[Landroid/net/http/IdleCache$Entry;

    aget-object v1, v4, v2

    .line 103
    .local v1, entry:Landroid/net/http/IdleCache$Entry;
    iget-object v0, v1, Landroid/net/http/IdleCache$Entry;->mHost:Lorg/apache/http/HttpHost;

    .line 104
    .local v0, eHost:Lorg/apache/http/HttpHost;
    if-eqz v0, :cond_29

    invoke-virtual {v0, p1}, Lorg/apache/http/HttpHost;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_29

    .line 105
    iget-object v3, v1, Landroid/net/http/IdleCache$Entry;->mConnection:Landroid/net/http/Connection;

    .line 106
    const/4 v4, 0x0

    iput-object v4, v1, Landroid/net/http/IdleCache$Entry;->mHost:Lorg/apache/http/HttpHost;

    .line 107
    const/4 v4, 0x0

    iput-object v4, v1, Landroid/net/http/IdleCache$Entry;->mConnection:Landroid/net/http/Connection;

    .line 108
    iget v4, p0, Landroid/net/http/IdleCache;->mCount:I

    add-int/lit8 v4, v4, -0x1

    iput v4, p0, Landroid/net/http/IdleCache;->mCount:I
    :try_end_27
    .catchall {:try_start_2 .. :try_end_27} :catchall_2c

    .line 114
    .end local v0           #eHost:Lorg/apache/http/HttpHost;
    .end local v1           #entry:Landroid/net/http/IdleCache$Entry;
    .end local v2           #i:I
    :cond_27
    monitor-exit p0

    return-object v3

    .line 101
    .restart local v0       #eHost:Lorg/apache/http/HttpHost;
    .restart local v1       #entry:Landroid/net/http/IdleCache$Entry;
    .restart local v2       #i:I
    :cond_29
    add-int/lit8 v2, v2, 0x1

    goto :goto_7

    .line 98
    .end local v0           #eHost:Lorg/apache/http/HttpHost;
    .end local v1           #entry:Landroid/net/http/IdleCache$Entry;
    .end local v2           #i:I
    :catchall_2c
    move-exception v4

    monitor-exit p0

    throw v4
.end method
