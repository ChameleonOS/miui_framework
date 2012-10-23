.class public Lcom/android/internal/util/JournaledFile;
.super Ljava/lang/Object;
.source "JournaledFile.java"


# instance fields
.field mReal:Ljava/io/File;

.field mTemp:Ljava/io/File;

.field mWriting:Z


# direct methods
.method public constructor <init>(Ljava/io/File;Ljava/io/File;)V
    .registers 3
    .parameter "real"
    .parameter "temp"

    .prologue
    .line 27
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 28
    iput-object p1, p0, Lcom/android/internal/util/JournaledFile;->mReal:Ljava/io/File;

    .line 29
    iput-object p2, p0, Lcom/android/internal/util/JournaledFile;->mTemp:Ljava/io/File;

    .line 30
    return-void
.end method


# virtual methods
.method public chooseForRead()Ljava/io/File;
    .registers 4

    .prologue
    .line 40
    iget-object v1, p0, Lcom/android/internal/util/JournaledFile;->mReal:Ljava/io/File;

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_18

    .line 41
    iget-object v0, p0, Lcom/android/internal/util/JournaledFile;->mReal:Ljava/io/File;

    .line 42
    .local v0, result:Ljava/io/File;
    iget-object v1, p0, Lcom/android/internal/util/JournaledFile;->mTemp:Ljava/io/File;

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_17

    .line 43
    iget-object v1, p0, Lcom/android/internal/util/JournaledFile;->mTemp:Ljava/io/File;

    invoke-virtual {v1}, Ljava/io/File;->delete()Z

    .line 51
    .end local v0           #result:Ljava/io/File;
    :cond_17
    :goto_17
    return-object v0

    .line 45
    :cond_18
    iget-object v1, p0, Lcom/android/internal/util/JournaledFile;->mTemp:Ljava/io/File;

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_2a

    .line 46
    iget-object v0, p0, Lcom/android/internal/util/JournaledFile;->mTemp:Ljava/io/File;

    .line 47
    .restart local v0       #result:Ljava/io/File;
    iget-object v1, p0, Lcom/android/internal/util/JournaledFile;->mTemp:Ljava/io/File;

    iget-object v2, p0, Lcom/android/internal/util/JournaledFile;->mReal:Ljava/io/File;

    invoke-virtual {v1, v2}, Ljava/io/File;->renameTo(Ljava/io/File;)Z

    goto :goto_17

    .line 49
    .end local v0           #result:Ljava/io/File;
    :cond_2a
    iget-object v0, p0, Lcom/android/internal/util/JournaledFile;->mReal:Ljava/io/File;

    goto :goto_17
.end method

.method public chooseForWrite()Ljava/io/File;
    .registers 3

    .prologue
    .line 63
    iget-boolean v0, p0, Lcom/android/internal/util/JournaledFile;->mWriting:Z

    if-eqz v0, :cond_d

    .line 64
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "uncommitted write already in progress"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 66
    :cond_d
    iget-object v0, p0, Lcom/android/internal/util/JournaledFile;->mReal:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-nez v0, :cond_1a

    .line 73
    :try_start_15
    iget-object v0, p0, Lcom/android/internal/util/JournaledFile;->mReal:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->createNewFile()Z
    :try_end_1a
    .catch Ljava/io/IOException; {:try_start_15 .. :try_end_1a} :catch_2d

    .line 79
    :cond_1a
    :goto_1a
    iget-object v0, p0, Lcom/android/internal/util/JournaledFile;->mTemp:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_27

    .line 80
    iget-object v0, p0, Lcom/android/internal/util/JournaledFile;->mTemp:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->delete()Z

    .line 82
    :cond_27
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/internal/util/JournaledFile;->mWriting:Z

    .line 83
    iget-object v0, p0, Lcom/android/internal/util/JournaledFile;->mTemp:Ljava/io/File;

    return-object v0

    .line 74
    :catch_2d
    move-exception v0

    goto :goto_1a
.end method

.method public commit()V
    .registers 3

    .prologue
    .line 90
    iget-boolean v0, p0, Lcom/android/internal/util/JournaledFile;->mWriting:Z

    if-nez v0, :cond_d

    .line 91
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "no file to commit"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 93
    :cond_d
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/internal/util/JournaledFile;->mWriting:Z

    .line 94
    iget-object v0, p0, Lcom/android/internal/util/JournaledFile;->mTemp:Ljava/io/File;

    iget-object v1, p0, Lcom/android/internal/util/JournaledFile;->mReal:Ljava/io/File;

    invoke-virtual {v0, v1}, Ljava/io/File;->renameTo(Ljava/io/File;)Z

    .line 95
    return-void
.end method

.method public rollback()V
    .registers 3

    .prologue
    .line 101
    iget-boolean v0, p0, Lcom/android/internal/util/JournaledFile;->mWriting:Z

    if-nez v0, :cond_d

    .line 102
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "no file to roll back"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 104
    :cond_d
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/internal/util/JournaledFile;->mWriting:Z

    .line 105
    iget-object v0, p0, Lcom/android/internal/util/JournaledFile;->mTemp:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->delete()Z

    .line 106
    return-void
.end method
