.class public Lmiui/security/MiuiLockPatternUtils;
.super Lcom/android/internal/widget/LockPatternUtils;
.source "MiuiLockPatternUtils.java"


# static fields
.field public static final LOCK_AC_FILE:Ljava/lang/String; = "access_control.key"

.field private static final SYSTEM_DIRECTORY:Ljava/lang/String; = "/system/"

.field private static final TAG:Ljava/lang/String; = "MiuiLockPatternUtils"

.field public static final sHaveNonZeroACFile:Ljava/util/concurrent/atomic/AtomicBoolean;

.field public static sLockACFilename:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .registers 2

    .prologue
    .line 28
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    sput-object v0, Lmiui/security/MiuiLockPatternUtils;->sHaveNonZeroACFile:Ljava/util/concurrent/atomic/AtomicBoolean;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .registers 9
    .parameter "context"

    .prologue
    .line 34
    invoke-direct {p0, p1}, Lcom/android/internal/widget/LockPatternUtils;-><init>(Landroid/content/Context;)V

    .line 35
    sget-object v1, Lmiui/security/MiuiLockPatternUtils;->sLockACFilename:Ljava/lang/String;

    if-nez v1, :cond_4e

    .line 36
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Landroid/os/Environment;->getDataDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/system/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 39
    .local v0, dataSystemDirectory:Ljava/lang/String;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "access_control.key"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    sput-object v1, Lmiui/security/MiuiLockPatternUtils;->sLockACFilename:Ljava/lang/String;

    .line 40
    sget-object v2, Lmiui/security/MiuiLockPatternUtils;->sHaveNonZeroACFile:Ljava/util/concurrent/atomic/AtomicBoolean;

    new-instance v1, Ljava/io/File;

    sget-object v3, Lmiui/security/MiuiLockPatternUtils;->sLockACFilename:Ljava/lang/String;

    invoke-direct {v1, v3}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/io/File;->length()J

    move-result-wide v3

    const-wide/16 v5, 0x0

    cmp-long v1, v3, v5

    if-lez v1, :cond_4f

    const/4 v1, 0x1

    :goto_4b
    invoke-virtual {v2, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 42
    .end local v0           #dataSystemDirectory:Ljava/lang/String;
    :cond_4e
    return-void

    .line 40
    .restart local v0       #dataSystemDirectory:Ljava/lang/String;
    :cond_4f
    const/4 v1, 0x0

    goto :goto_4b
.end method


# virtual methods
.method public checkAccessControl(Ljava/util/List;)Z
    .registers 10
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/android/internal/widget/LockPatternView$Cell;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .local p1, pattern:Ljava/util/List;,"Ljava/util/List<Lcom/android/internal/widget/LockPatternView$Cell;>;"
    const/4 v5, 0x1

    .line 53
    :try_start_1
    new-instance v3, Ljava/io/RandomAccessFile;

    sget-object v6, Lmiui/security/MiuiLockPatternUtils;->sLockACFilename:Ljava/lang/String;

    const-string/jumbo v7, "r"

    invoke-direct {v3, v6, v7}, Ljava/io/RandomAccessFile;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 54
    .local v3, raf:Ljava/io/RandomAccessFile;
    invoke-virtual {v3}, Ljava/io/RandomAccessFile;->length()J

    move-result-wide v6

    long-to-int v6, v6

    new-array v4, v6, [B

    .line 55
    .local v4, stored:[B
    const/4 v6, 0x0

    array-length v7, v4

    invoke-virtual {v3, v4, v6, v7}, Ljava/io/RandomAccessFile;->read([BII)I

    move-result v1

    .line 56
    .local v1, got:I
    invoke-virtual {v3}, Ljava/io/RandomAccessFile;->close()V

    .line 57
    if-gtz v1, :cond_1e

    .line 65
    .end local v1           #got:I
    .end local v3           #raf:Ljava/io/RandomAccessFile;
    .end local v4           #stored:[B
    :goto_1d
    return v5

    .line 61
    .restart local v1       #got:I
    .restart local v3       #raf:Ljava/io/RandomAccessFile;
    .restart local v4       #stored:[B
    :cond_1e
    invoke-static {p1}, Lcom/android/internal/widget/LockPatternUtils;->patternToHash(Ljava/util/List;)[B

    move-result-object v6

    invoke-static {v4, v6}, Ljava/util/Arrays;->equals([B[B)Z
    :try_end_25
    .catch Ljava/io/FileNotFoundException; {:try_start_1 .. :try_end_25} :catch_27
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_25} :catch_29

    move-result v5

    goto :goto_1d

    .line 62
    .end local v1           #got:I
    .end local v3           #raf:Ljava/io/RandomAccessFile;
    .end local v4           #stored:[B
    :catch_27
    move-exception v0

    .line 63
    .local v0, fnfe:Ljava/io/FileNotFoundException;
    goto :goto_1d

    .line 64
    .end local v0           #fnfe:Ljava/io/FileNotFoundException;
    :catch_29
    move-exception v2

    .line 65
    .local v2, ioe:Ljava/io/IOException;
    goto :goto_1d
.end method

.method public saveACLockPattern(Ljava/util/List;)V
    .registers 9
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/android/internal/widget/LockPatternView$Cell;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 83
    .local p1, pattern:Ljava/util/List;,"Ljava/util/List<Lcom/android/internal/widget/LockPatternView$Cell;>;"
    invoke-static {p1}, Lcom/android/internal/widget/LockPatternUtils;->patternToHash(Ljava/util/List;)[B

    move-result-object v1

    .line 86
    .local v1, hash:[B
    :try_start_4
    new-instance v3, Ljava/io/RandomAccessFile;

    sget-object v4, Lmiui/security/MiuiLockPatternUtils;->sLockACFilename:Ljava/lang/String;

    const-string/jumbo v5, "rw"

    invoke-direct {v3, v4, v5}, Ljava/io/RandomAccessFile;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 88
    .local v3, raf:Ljava/io/RandomAccessFile;
    if-nez p1, :cond_19

    .line 89
    const-wide/16 v4, 0x0

    invoke-virtual {v3, v4, v5}, Ljava/io/RandomAccessFile;->setLength(J)V

    .line 93
    :goto_15
    invoke-virtual {v3}, Ljava/io/RandomAccessFile;->close()V

    .line 101
    .end local v3           #raf:Ljava/io/RandomAccessFile;
    :goto_18
    return-void

    .line 91
    .restart local v3       #raf:Ljava/io/RandomAccessFile;
    :cond_19
    const/4 v4, 0x0

    array-length v5, v1

    invoke-virtual {v3, v1, v4, v5}, Ljava/io/RandomAccessFile;->write([BII)V
    :try_end_1e
    .catch Ljava/io/FileNotFoundException; {:try_start_4 .. :try_end_1e} :catch_1f
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_1e} :catch_3b

    goto :goto_15

    .line 94
    .end local v3           #raf:Ljava/io/RandomAccessFile;
    :catch_1f
    move-exception v0

    .line 96
    .local v0, fnfe:Ljava/io/FileNotFoundException;
    const-string v4, "MiuiLockPatternUtils"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Unable to save lock pattern to "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    sget-object v6, Lmiui/security/MiuiLockPatternUtils;->sLockACFilename:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_18

    .line 97
    .end local v0           #fnfe:Ljava/io/FileNotFoundException;
    :catch_3b
    move-exception v2

    .line 99
    .local v2, ioe:Ljava/io/IOException;
    const-string v4, "MiuiLockPatternUtils"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Unable to save lock pattern to "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    sget-object v6, Lmiui/security/MiuiLockPatternUtils;->sLockACFilename:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_18
.end method

.method public savedAccessControlExists()Z
    .registers 2

    .prologue
    .line 74
    sget-object v0, Lmiui/security/MiuiLockPatternUtils;->sHaveNonZeroACFile:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    return v0
.end method
