.class public Lcom/android/internal/net/NetworkStatsFactory;
.super Ljava/lang/Object;
.source "NetworkStatsFactory.java"


# static fields
.field private static final TAG:Ljava/lang/String; = "NetworkStatsFactory"


# instance fields
.field private final mStatsXtIfaceAll:Ljava/io/File;

.field private final mStatsXtIfaceFmt:Ljava/io/File;

.field private final mStatsXtUid:Ljava/io/File;


# direct methods
.method public constructor <init>()V
    .registers 3

    .prologue
    .line 53
    new-instance v0, Ljava/io/File;

    const-string v1, "/proc/"

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-direct {p0, v0}, Lcom/android/internal/net/NetworkStatsFactory;-><init>(Ljava/io/File;)V

    .line 54
    return-void
.end method

.method public constructor <init>(Ljava/io/File;)V
    .registers 4
    .parameter "procRoot"

    .prologue
    .line 57
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 58
    new-instance v0, Ljava/io/File;

    const-string/jumbo v1, "net/xt_qtaguid/iface_stat_all"

    invoke-direct {v0, p1, v1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/android/internal/net/NetworkStatsFactory;->mStatsXtIfaceAll:Ljava/io/File;

    .line 59
    new-instance v0, Ljava/io/File;

    const-string/jumbo v1, "net/xt_qtaguid/iface_stat_fmt"

    invoke-direct {v0, p1, v1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/android/internal/net/NetworkStatsFactory;->mStatsXtIfaceFmt:Ljava/io/File;

    .line 60
    new-instance v0, Ljava/io/File;

    const-string/jumbo v1, "net/xt_qtaguid/stats"

    invoke-direct {v0, p1, v1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/android/internal/net/NetworkStatsFactory;->mStatsXtUid:Ljava/io/File;

    .line 61
    return-void
.end method


# virtual methods
.method public readNetworkStatsDetail()Landroid/net/NetworkStats;
    .registers 2

    .prologue
    .line 169
    const/4 v0, -0x1

    invoke-virtual {p0, v0}, Lcom/android/internal/net/NetworkStatsFactory;->readNetworkStatsDetail(I)Landroid/net/NetworkStats;

    move-result-object v0

    return-object v0
.end method

.method public readNetworkStatsDetail(I)Landroid/net/NetworkStats;
    .registers 13
    .parameter "limitUid"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 179
    invoke-static {}, Landroid/os/StrictMode;->allowThreadDiskReads()Landroid/os/StrictMode$ThreadPolicy;

    move-result-object v6

    .line 181
    .local v6, savedPolicy:Landroid/os/StrictMode$ThreadPolicy;
    new-instance v7, Landroid/net/NetworkStats;

    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v8

    const/16 v10, 0x18

    invoke-direct {v7, v8, v9, v10}, Landroid/net/NetworkStats;-><init>(JI)V

    .line 182
    .local v7, stats:Landroid/net/NetworkStats;
    new-instance v1, Landroid/net/NetworkStats$Entry;

    invoke-direct {v1}, Landroid/net/NetworkStats$Entry;-><init>()V

    .line 184
    .local v1, entry:Landroid/net/NetworkStats$Entry;
    const/4 v2, 0x1

    .line 185
    .local v2, idx:I
    const/4 v3, 0x1

    .line 187
    .local v3, lastIdx:I
    const/4 v4, 0x0

    .line 190
    .local v4, reader:Lcom/android/internal/util/ProcFileReader;
    :try_start_17
    new-instance v5, Lcom/android/internal/util/ProcFileReader;

    new-instance v8, Ljava/io/FileInputStream;

    iget-object v9, p0, Lcom/android/internal/net/NetworkStatsFactory;->mStatsXtUid:Ljava/io/File;

    invoke-direct {v8, v9}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    invoke-direct {v5, v8}, Lcom/android/internal/util/ProcFileReader;-><init>(Ljava/io/InputStream;)V
    :try_end_23
    .catchall {:try_start_17 .. :try_end_23} :catchall_73
    .catch Ljava/lang/NullPointerException; {:try_start_17 .. :try_end_23} :catch_106
    .catch Ljava/lang/NumberFormatException; {:try_start_17 .. :try_end_23} :catch_104
    .catch Ljava/io/IOException; {:try_start_17 .. :try_end_23} :catch_e2

    .line 191
    .end local v4           #reader:Lcom/android/internal/util/ProcFileReader;
    .local v5, reader:Lcom/android/internal/util/ProcFileReader;
    :try_start_23
    invoke-virtual {v5}, Lcom/android/internal/util/ProcFileReader;->finishLine()V

    .line 193
    :goto_26
    invoke-virtual {v5}, Lcom/android/internal/util/ProcFileReader;->hasMoreData()Z

    move-result v8

    if-eqz v8, :cond_db

    .line 194
    invoke-virtual {v5}, Lcom/android/internal/util/ProcFileReader;->nextInt()I

    move-result v2

    .line 195
    add-int/lit8 v8, v3, 0x1

    if-eq v2, v8, :cond_7b

    .line 196
    new-instance v8, Ljava/lang/IllegalStateException;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "inconsistent idx="

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, " after lastIdx="

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v8
    :try_end_57
    .catchall {:try_start_23 .. :try_end_57} :catchall_fd
    .catch Ljava/lang/NullPointerException; {:try_start_23 .. :try_end_57} :catch_57
    .catch Ljava/lang/NumberFormatException; {:try_start_23 .. :try_end_57} :catch_bf
    .catch Ljava/io/IOException; {:try_start_23 .. :try_end_57} :catch_101

    .line 216
    :catch_57
    move-exception v0

    move-object v4, v5

    .line 217
    .end local v5           #reader:Lcom/android/internal/util/ProcFileReader;
    .local v0, e:Ljava/lang/NullPointerException;
    .restart local v4       #reader:Lcom/android/internal/util/ProcFileReader;
    :goto_59
    :try_start_59
    new-instance v8, Ljava/lang/IllegalStateException;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v10, "problem parsing idx "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v8
    :try_end_73
    .catchall {:try_start_59 .. :try_end_73} :catchall_73

    .line 223
    .end local v0           #e:Ljava/lang/NullPointerException;
    :catchall_73
    move-exception v8

    :goto_74
    invoke-static {v4}, Llibcore/io/IoUtils;->closeQuietly(Ljava/lang/AutoCloseable;)V

    .line 224
    invoke-static {v6}, Landroid/os/StrictMode;->setThreadPolicy(Landroid/os/StrictMode$ThreadPolicy;)V

    throw v8

    .line 199
    .end local v4           #reader:Lcom/android/internal/util/ProcFileReader;
    .restart local v5       #reader:Lcom/android/internal/util/ProcFileReader;
    :cond_7b
    move v3, v2

    .line 201
    :try_start_7c
    invoke-virtual {v5}, Lcom/android/internal/util/ProcFileReader;->nextString()Ljava/lang/String;

    move-result-object v8

    iput-object v8, v1, Landroid/net/NetworkStats$Entry;->iface:Ljava/lang/String;

    .line 202
    invoke-virtual {v5}, Lcom/android/internal/util/ProcFileReader;->nextString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Lcom/android/server/NetworkManagementSocketTagger;->kernelToTag(Ljava/lang/String;)I

    move-result v8

    iput v8, v1, Landroid/net/NetworkStats$Entry;->tag:I

    .line 203
    invoke-virtual {v5}, Lcom/android/internal/util/ProcFileReader;->nextInt()I

    move-result v8

    iput v8, v1, Landroid/net/NetworkStats$Entry;->uid:I

    .line 204
    invoke-virtual {v5}, Lcom/android/internal/util/ProcFileReader;->nextInt()I

    move-result v8

    iput v8, v1, Landroid/net/NetworkStats$Entry;->set:I

    .line 205
    invoke-virtual {v5}, Lcom/android/internal/util/ProcFileReader;->nextLong()J

    move-result-wide v8

    iput-wide v8, v1, Landroid/net/NetworkStats$Entry;->rxBytes:J

    .line 206
    invoke-virtual {v5}, Lcom/android/internal/util/ProcFileReader;->nextLong()J

    move-result-wide v8

    iput-wide v8, v1, Landroid/net/NetworkStats$Entry;->rxPackets:J

    .line 207
    invoke-virtual {v5}, Lcom/android/internal/util/ProcFileReader;->nextLong()J

    move-result-wide v8

    iput-wide v8, v1, Landroid/net/NetworkStats$Entry;->txBytes:J

    .line 208
    invoke-virtual {v5}, Lcom/android/internal/util/ProcFileReader;->nextLong()J

    move-result-wide v8

    iput-wide v8, v1, Landroid/net/NetworkStats$Entry;->txPackets:J

    .line 210
    const/4 v8, -0x1

    if-eq p1, v8, :cond_b7

    iget v8, v1, Landroid/net/NetworkStats$Entry;->uid:I

    if-ne p1, v8, :cond_ba

    .line 211
    :cond_b7
    invoke-virtual {v7, v1}, Landroid/net/NetworkStats;->addValues(Landroid/net/NetworkStats$Entry;)Landroid/net/NetworkStats;

    .line 214
    :cond_ba
    invoke-virtual {v5}, Lcom/android/internal/util/ProcFileReader;->finishLine()V
    :try_end_bd
    .catchall {:try_start_7c .. :try_end_bd} :catchall_fd
    .catch Ljava/lang/NullPointerException; {:try_start_7c .. :try_end_bd} :catch_57
    .catch Ljava/lang/NumberFormatException; {:try_start_7c .. :try_end_bd} :catch_bf
    .catch Ljava/io/IOException; {:try_start_7c .. :try_end_bd} :catch_101

    goto/16 :goto_26

    .line 218
    :catch_bf
    move-exception v0

    move-object v4, v5

    .line 219
    .end local v5           #reader:Lcom/android/internal/util/ProcFileReader;
    .local v0, e:Ljava/lang/NumberFormatException;
    .restart local v4       #reader:Lcom/android/internal/util/ProcFileReader;
    :goto_c1
    :try_start_c1
    new-instance v8, Ljava/lang/IllegalStateException;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v10, "problem parsing idx "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v8
    :try_end_db
    .catchall {:try_start_c1 .. :try_end_db} :catchall_73

    .line 223
    .end local v0           #e:Ljava/lang/NumberFormatException;
    .end local v4           #reader:Lcom/android/internal/util/ProcFileReader;
    .restart local v5       #reader:Lcom/android/internal/util/ProcFileReader;
    :cond_db
    invoke-static {v5}, Llibcore/io/IoUtils;->closeQuietly(Ljava/lang/AutoCloseable;)V

    .line 224
    invoke-static {v6}, Landroid/os/StrictMode;->setThreadPolicy(Landroid/os/StrictMode$ThreadPolicy;)V

    .line 227
    return-object v7

    .line 220
    .end local v5           #reader:Lcom/android/internal/util/ProcFileReader;
    .restart local v4       #reader:Lcom/android/internal/util/ProcFileReader;
    :catch_e2
    move-exception v0

    .line 221
    .local v0, e:Ljava/io/IOException;
    :goto_e3
    :try_start_e3
    new-instance v8, Ljava/lang/IllegalStateException;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v10, "problem parsing idx "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v8
    :try_end_fd
    .catchall {:try_start_e3 .. :try_end_fd} :catchall_73

    .line 223
    .end local v0           #e:Ljava/io/IOException;
    .end local v4           #reader:Lcom/android/internal/util/ProcFileReader;
    .restart local v5       #reader:Lcom/android/internal/util/ProcFileReader;
    :catchall_fd
    move-exception v8

    move-object v4, v5

    .end local v5           #reader:Lcom/android/internal/util/ProcFileReader;
    .restart local v4       #reader:Lcom/android/internal/util/ProcFileReader;
    goto/16 :goto_74

    .line 220
    .end local v4           #reader:Lcom/android/internal/util/ProcFileReader;
    .restart local v5       #reader:Lcom/android/internal/util/ProcFileReader;
    :catch_101
    move-exception v0

    move-object v4, v5

    .end local v5           #reader:Lcom/android/internal/util/ProcFileReader;
    .restart local v4       #reader:Lcom/android/internal/util/ProcFileReader;
    goto :goto_e3

    .line 218
    :catch_104
    move-exception v0

    goto :goto_c1

    .line 216
    :catch_106
    move-exception v0

    goto/16 :goto_59
.end method

.method public readNetworkStatsSummaryDev()Landroid/net/NetworkStats;
    .registers 13
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    const/4 v7, 0x0

    .line 72
    invoke-static {}, Landroid/os/StrictMode;->allowThreadDiskReads()Landroid/os/StrictMode$ThreadPolicy;

    move-result-object v5

    .line 74
    .local v5, savedPolicy:Landroid/os/StrictMode$ThreadPolicy;
    new-instance v6, Landroid/net/NetworkStats;

    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v8

    const/4 v10, 0x6

    invoke-direct {v6, v8, v9, v10}, Landroid/net/NetworkStats;-><init>(JI)V

    .line 75
    .local v6, stats:Landroid/net/NetworkStats;
    new-instance v2, Landroid/net/NetworkStats$Entry;

    invoke-direct {v2}, Landroid/net/NetworkStats$Entry;-><init>()V

    .line 77
    .local v2, entry:Landroid/net/NetworkStats$Entry;
    const/4 v3, 0x0

    .line 79
    .local v3, reader:Lcom/android/internal/util/ProcFileReader;
    :try_start_15
    new-instance v4, Lcom/android/internal/util/ProcFileReader;

    new-instance v8, Ljava/io/FileInputStream;

    iget-object v9, p0, Lcom/android/internal/net/NetworkStatsFactory;->mStatsXtIfaceAll:Ljava/io/File;

    invoke-direct {v8, v9}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    invoke-direct {v4, v8}, Lcom/android/internal/util/ProcFileReader;-><init>(Ljava/io/InputStream;)V
    :try_end_21
    .catchall {:try_start_15 .. :try_end_21} :catchall_9e
    .catch Ljava/lang/NullPointerException; {:try_start_15 .. :try_end_21} :catch_ee
    .catch Ljava/lang/NumberFormatException; {:try_start_15 .. :try_end_21} :catch_af
    .catch Ljava/io/IOException; {:try_start_15 .. :try_end_21} :catch_ca

    .line 81
    .end local v3           #reader:Lcom/android/internal/util/ProcFileReader;
    .local v4, reader:Lcom/android/internal/util/ProcFileReader;
    :goto_21
    :try_start_21
    invoke-virtual {v4}, Lcom/android/internal/util/ProcFileReader;->hasMoreData()Z

    move-result v8

    if-eqz v8, :cond_a8

    .line 82
    invoke-virtual {v4}, Lcom/android/internal/util/ProcFileReader;->nextString()Ljava/lang/String;

    move-result-object v8

    iput-object v8, v2, Landroid/net/NetworkStats$Entry;->iface:Ljava/lang/String;

    .line 83
    const/4 v8, -0x1

    iput v8, v2, Landroid/net/NetworkStats$Entry;->uid:I

    .line 84
    const/4 v8, -0x1

    iput v8, v2, Landroid/net/NetworkStats$Entry;->set:I

    .line 85
    const/4 v8, 0x0

    iput v8, v2, Landroid/net/NetworkStats$Entry;->tag:I

    .line 87
    invoke-virtual {v4}, Lcom/android/internal/util/ProcFileReader;->nextInt()I

    move-result v8

    if-eqz v8, :cond_a6

    const/4 v0, 0x1

    .line 90
    .local v0, active:Z
    :goto_3d
    invoke-virtual {v4}, Lcom/android/internal/util/ProcFileReader;->nextLong()J

    move-result-wide v8

    iput-wide v8, v2, Landroid/net/NetworkStats$Entry;->rxBytes:J

    .line 91
    invoke-virtual {v4}, Lcom/android/internal/util/ProcFileReader;->nextLong()J

    move-result-wide v8

    iput-wide v8, v2, Landroid/net/NetworkStats$Entry;->rxPackets:J

    .line 92
    invoke-virtual {v4}, Lcom/android/internal/util/ProcFileReader;->nextLong()J

    move-result-wide v8

    iput-wide v8, v2, Landroid/net/NetworkStats$Entry;->txBytes:J

    .line 93
    invoke-virtual {v4}, Lcom/android/internal/util/ProcFileReader;->nextLong()J

    move-result-wide v8

    iput-wide v8, v2, Landroid/net/NetworkStats$Entry;->txPackets:J

    .line 96
    if-eqz v0, :cond_7b

    .line 97
    iget-wide v8, v2, Landroid/net/NetworkStats$Entry;->rxBytes:J

    invoke-virtual {v4}, Lcom/android/internal/util/ProcFileReader;->nextLong()J

    move-result-wide v10

    add-long/2addr v8, v10

    iput-wide v8, v2, Landroid/net/NetworkStats$Entry;->rxBytes:J

    .line 98
    iget-wide v8, v2, Landroid/net/NetworkStats$Entry;->rxPackets:J

    invoke-virtual {v4}, Lcom/android/internal/util/ProcFileReader;->nextLong()J

    move-result-wide v10

    add-long/2addr v8, v10

    iput-wide v8, v2, Landroid/net/NetworkStats$Entry;->rxPackets:J

    .line 99
    iget-wide v8, v2, Landroid/net/NetworkStats$Entry;->txBytes:J

    invoke-virtual {v4}, Lcom/android/internal/util/ProcFileReader;->nextLong()J

    move-result-wide v10

    add-long/2addr v8, v10

    iput-wide v8, v2, Landroid/net/NetworkStats$Entry;->txBytes:J

    .line 100
    iget-wide v8, v2, Landroid/net/NetworkStats$Entry;->txPackets:J

    invoke-virtual {v4}, Lcom/android/internal/util/ProcFileReader;->nextLong()J

    move-result-wide v10

    add-long/2addr v8, v10

    iput-wide v8, v2, Landroid/net/NetworkStats$Entry;->txPackets:J

    .line 103
    :cond_7b
    invoke-virtual {v6, v2}, Landroid/net/NetworkStats;->addValues(Landroid/net/NetworkStats$Entry;)Landroid/net/NetworkStats;

    .line 104
    invoke-virtual {v4}, Lcom/android/internal/util/ProcFileReader;->finishLine()V
    :try_end_81
    .catchall {:try_start_21 .. :try_end_81} :catchall_e5
    .catch Ljava/lang/NullPointerException; {:try_start_21 .. :try_end_81} :catch_82
    .catch Ljava/lang/NumberFormatException; {:try_start_21 .. :try_end_81} :catch_eb
    .catch Ljava/io/IOException; {:try_start_21 .. :try_end_81} :catch_e8

    goto :goto_21

    .line 106
    .end local v0           #active:Z
    :catch_82
    move-exception v1

    move-object v3, v4

    .line 107
    .end local v4           #reader:Lcom/android/internal/util/ProcFileReader;
    .local v1, e:Ljava/lang/NullPointerException;
    .restart local v3       #reader:Lcom/android/internal/util/ProcFileReader;
    :goto_84
    :try_start_84
    new-instance v7, Ljava/lang/IllegalStateException;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v9, "problem parsing stats: "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v7
    :try_end_9e
    .catchall {:try_start_84 .. :try_end_9e} :catchall_9e

    .line 113
    .end local v1           #e:Ljava/lang/NullPointerException;
    :catchall_9e
    move-exception v7

    :goto_9f
    invoke-static {v3}, Llibcore/io/IoUtils;->closeQuietly(Ljava/lang/AutoCloseable;)V

    .line 114
    invoke-static {v5}, Landroid/os/StrictMode;->setThreadPolicy(Landroid/os/StrictMode$ThreadPolicy;)V

    throw v7

    .end local v3           #reader:Lcom/android/internal/util/ProcFileReader;
    .restart local v4       #reader:Lcom/android/internal/util/ProcFileReader;
    :cond_a6
    move v0, v7

    .line 87
    goto :goto_3d

    .line 113
    :cond_a8
    invoke-static {v4}, Llibcore/io/IoUtils;->closeQuietly(Ljava/lang/AutoCloseable;)V

    .line 114
    invoke-static {v5}, Landroid/os/StrictMode;->setThreadPolicy(Landroid/os/StrictMode$ThreadPolicy;)V

    .line 116
    return-object v6

    .line 108
    .end local v4           #reader:Lcom/android/internal/util/ProcFileReader;
    .restart local v3       #reader:Lcom/android/internal/util/ProcFileReader;
    :catch_af
    move-exception v1

    .line 109
    .local v1, e:Ljava/lang/NumberFormatException;
    :goto_b0
    :try_start_b0
    new-instance v7, Ljava/lang/IllegalStateException;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v9, "problem parsing stats: "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v7

    .line 110
    .end local v1           #e:Ljava/lang/NumberFormatException;
    :catch_ca
    move-exception v1

    .line 111
    .local v1, e:Ljava/io/IOException;
    :goto_cb
    new-instance v7, Ljava/lang/IllegalStateException;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v9, "problem parsing stats: "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v7
    :try_end_e5
    .catchall {:try_start_b0 .. :try_end_e5} :catchall_9e

    .line 113
    .end local v1           #e:Ljava/io/IOException;
    .end local v3           #reader:Lcom/android/internal/util/ProcFileReader;
    .restart local v4       #reader:Lcom/android/internal/util/ProcFileReader;
    :catchall_e5
    move-exception v7

    move-object v3, v4

    .end local v4           #reader:Lcom/android/internal/util/ProcFileReader;
    .restart local v3       #reader:Lcom/android/internal/util/ProcFileReader;
    goto :goto_9f

    .line 110
    .end local v3           #reader:Lcom/android/internal/util/ProcFileReader;
    .restart local v4       #reader:Lcom/android/internal/util/ProcFileReader;
    :catch_e8
    move-exception v1

    move-object v3, v4

    .end local v4           #reader:Lcom/android/internal/util/ProcFileReader;
    .restart local v3       #reader:Lcom/android/internal/util/ProcFileReader;
    goto :goto_cb

    .line 108
    .end local v3           #reader:Lcom/android/internal/util/ProcFileReader;
    .restart local v4       #reader:Lcom/android/internal/util/ProcFileReader;
    :catch_eb
    move-exception v1

    move-object v3, v4

    .end local v4           #reader:Lcom/android/internal/util/ProcFileReader;
    .restart local v3       #reader:Lcom/android/internal/util/ProcFileReader;
    goto :goto_b0

    .line 106
    :catch_ee
    move-exception v1

    goto :goto_84
.end method

.method public readNetworkStatsSummaryXt()Landroid/net/NetworkStats;
    .registers 10
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 127
    invoke-static {}, Landroid/os/StrictMode;->allowThreadDiskReads()Landroid/os/StrictMode$ThreadPolicy;

    move-result-object v4

    .line 130
    .local v4, savedPolicy:Landroid/os/StrictMode$ThreadPolicy;
    iget-object v6, p0, Lcom/android/internal/net/NetworkStatsFactory;->mStatsXtIfaceFmt:Ljava/io/File;

    invoke-virtual {v6}, Ljava/io/File;->exists()Z

    move-result v6

    if-nez v6, :cond_e

    const/4 v5, 0x0

    .line 165
    :goto_d
    return-object v5

    .line 132
    :cond_e
    new-instance v5, Landroid/net/NetworkStats;

    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v6

    const/4 v8, 0x6

    invoke-direct {v5, v6, v7, v8}, Landroid/net/NetworkStats;-><init>(JI)V

    .line 133
    .local v5, stats:Landroid/net/NetworkStats;
    new-instance v1, Landroid/net/NetworkStats$Entry;

    invoke-direct {v1}, Landroid/net/NetworkStats$Entry;-><init>()V

    .line 135
    .local v1, entry:Landroid/net/NetworkStats$Entry;
    const/4 v2, 0x0

    .line 138
    .local v2, reader:Lcom/android/internal/util/ProcFileReader;
    :try_start_1e
    new-instance v3, Lcom/android/internal/util/ProcFileReader;

    new-instance v6, Ljava/io/FileInputStream;

    iget-object v7, p0, Lcom/android/internal/net/NetworkStatsFactory;->mStatsXtIfaceFmt:Ljava/io/File;

    invoke-direct {v6, v7}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    invoke-direct {v3, v6}, Lcom/android/internal/util/ProcFileReader;-><init>(Ljava/io/InputStream;)V
    :try_end_2a
    .catchall {:try_start_1e .. :try_end_2a} :catchall_7d
    .catch Ljava/lang/NullPointerException; {:try_start_1e .. :try_end_2a} :catch_cb
    .catch Ljava/lang/NumberFormatException; {:try_start_1e .. :try_end_2a} :catch_8c
    .catch Ljava/io/IOException; {:try_start_1e .. :try_end_2a} :catch_a7

    .line 139
    .end local v2           #reader:Lcom/android/internal/util/ProcFileReader;
    .local v3, reader:Lcom/android/internal/util/ProcFileReader;
    :try_start_2a
    invoke-virtual {v3}, Lcom/android/internal/util/ProcFileReader;->finishLine()V

    .line 141
    :goto_2d
    invoke-virtual {v3}, Lcom/android/internal/util/ProcFileReader;->hasMoreData()Z

    move-result v6

    if-eqz v6, :cond_85

    .line 142
    invoke-virtual {v3}, Lcom/android/internal/util/ProcFileReader;->nextString()Ljava/lang/String;

    move-result-object v6

    iput-object v6, v1, Landroid/net/NetworkStats$Entry;->iface:Ljava/lang/String;

    .line 143
    const/4 v6, -0x1

    iput v6, v1, Landroid/net/NetworkStats$Entry;->uid:I

    .line 144
    const/4 v6, -0x1

    iput v6, v1, Landroid/net/NetworkStats$Entry;->set:I

    .line 145
    const/4 v6, 0x0

    iput v6, v1, Landroid/net/NetworkStats$Entry;->tag:I

    .line 147
    invoke-virtual {v3}, Lcom/android/internal/util/ProcFileReader;->nextLong()J

    move-result-wide v6

    iput-wide v6, v1, Landroid/net/NetworkStats$Entry;->rxBytes:J

    .line 148
    invoke-virtual {v3}, Lcom/android/internal/util/ProcFileReader;->nextLong()J

    move-result-wide v6

    iput-wide v6, v1, Landroid/net/NetworkStats$Entry;->rxPackets:J

    .line 149
    invoke-virtual {v3}, Lcom/android/internal/util/ProcFileReader;->nextLong()J

    move-result-wide v6

    iput-wide v6, v1, Landroid/net/NetworkStats$Entry;->txBytes:J

    .line 150
    invoke-virtual {v3}, Lcom/android/internal/util/ProcFileReader;->nextLong()J

    move-result-wide v6

    iput-wide v6, v1, Landroid/net/NetworkStats$Entry;->txPackets:J

    .line 152
    invoke-virtual {v5, v1}, Landroid/net/NetworkStats;->addValues(Landroid/net/NetworkStats$Entry;)Landroid/net/NetworkStats;

    .line 153
    invoke-virtual {v3}, Lcom/android/internal/util/ProcFileReader;->finishLine()V
    :try_end_60
    .catchall {:try_start_2a .. :try_end_60} :catchall_c2
    .catch Ljava/lang/NullPointerException; {:try_start_2a .. :try_end_60} :catch_61
    .catch Ljava/lang/NumberFormatException; {:try_start_2a .. :try_end_60} :catch_c8
    .catch Ljava/io/IOException; {:try_start_2a .. :try_end_60} :catch_c5

    goto :goto_2d

    .line 155
    :catch_61
    move-exception v0

    move-object v2, v3

    .line 156
    .end local v3           #reader:Lcom/android/internal/util/ProcFileReader;
    .local v0, e:Ljava/lang/NullPointerException;
    .restart local v2       #reader:Lcom/android/internal/util/ProcFileReader;
    :goto_63
    :try_start_63
    new-instance v6, Ljava/lang/IllegalStateException;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "problem parsing stats: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v6
    :try_end_7d
    .catchall {:try_start_63 .. :try_end_7d} :catchall_7d

    .line 162
    .end local v0           #e:Ljava/lang/NullPointerException;
    :catchall_7d
    move-exception v6

    :goto_7e
    invoke-static {v2}, Llibcore/io/IoUtils;->closeQuietly(Ljava/lang/AutoCloseable;)V

    .line 163
    invoke-static {v4}, Landroid/os/StrictMode;->setThreadPolicy(Landroid/os/StrictMode$ThreadPolicy;)V

    throw v6

    .line 162
    .end local v2           #reader:Lcom/android/internal/util/ProcFileReader;
    .restart local v3       #reader:Lcom/android/internal/util/ProcFileReader;
    :cond_85
    invoke-static {v3}, Llibcore/io/IoUtils;->closeQuietly(Ljava/lang/AutoCloseable;)V

    .line 163
    invoke-static {v4}, Landroid/os/StrictMode;->setThreadPolicy(Landroid/os/StrictMode$ThreadPolicy;)V

    goto :goto_d

    .line 157
    .end local v3           #reader:Lcom/android/internal/util/ProcFileReader;
    .restart local v2       #reader:Lcom/android/internal/util/ProcFileReader;
    :catch_8c
    move-exception v0

    .line 158
    .local v0, e:Ljava/lang/NumberFormatException;
    :goto_8d
    :try_start_8d
    new-instance v6, Ljava/lang/IllegalStateException;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "problem parsing stats: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 159
    .end local v0           #e:Ljava/lang/NumberFormatException;
    :catch_a7
    move-exception v0

    .line 160
    .local v0, e:Ljava/io/IOException;
    :goto_a8
    new-instance v6, Ljava/lang/IllegalStateException;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "problem parsing stats: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v6
    :try_end_c2
    .catchall {:try_start_8d .. :try_end_c2} :catchall_7d

    .line 162
    .end local v0           #e:Ljava/io/IOException;
    .end local v2           #reader:Lcom/android/internal/util/ProcFileReader;
    .restart local v3       #reader:Lcom/android/internal/util/ProcFileReader;
    :catchall_c2
    move-exception v6

    move-object v2, v3

    .end local v3           #reader:Lcom/android/internal/util/ProcFileReader;
    .restart local v2       #reader:Lcom/android/internal/util/ProcFileReader;
    goto :goto_7e

    .line 159
    .end local v2           #reader:Lcom/android/internal/util/ProcFileReader;
    .restart local v3       #reader:Lcom/android/internal/util/ProcFileReader;
    :catch_c5
    move-exception v0

    move-object v2, v3

    .end local v3           #reader:Lcom/android/internal/util/ProcFileReader;
    .restart local v2       #reader:Lcom/android/internal/util/ProcFileReader;
    goto :goto_a8

    .line 157
    .end local v2           #reader:Lcom/android/internal/util/ProcFileReader;
    .restart local v3       #reader:Lcom/android/internal/util/ProcFileReader;
    :catch_c8
    move-exception v0

    move-object v2, v3

    .end local v3           #reader:Lcom/android/internal/util/ProcFileReader;
    .restart local v2       #reader:Lcom/android/internal/util/ProcFileReader;
    goto :goto_8d

    .line 155
    :catch_cb
    move-exception v0

    goto :goto_63
.end method
