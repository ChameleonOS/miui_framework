.class final Landroid/webkit/CacheManager$1;
.super Ljava/lang/Object;
.source "CacheManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/webkit/CacheManager;->removeAllCacheFiles()Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 434
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 7

    .prologue
    .line 438
    :try_start_0
    invoke-static {}, Landroid/webkit/CacheManager;->access$000()Ljava/io/File;

    move-result-object v3

    invoke-virtual {v3}, Ljava/io/File;->list()[Ljava/lang/String;

    move-result-object v1

    .line 440
    .local v1, files:[Ljava/lang/String;
    if-eqz v1, :cond_3f

    .line 441
    const/4 v2, 0x0

    .local v2, i:I
    :goto_b
    array-length v3, v1

    if-ge v2, v3, :cond_3f

    .line 442
    new-instance v0, Ljava/io/File;

    invoke-static {}, Landroid/webkit/CacheManager;->access$000()Ljava/io/File;

    move-result-object v3

    aget-object v4, v1, v2

    invoke-direct {v0, v3, v4}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 443
    .local v0, f:Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->delete()Z

    move-result v3

    if-nez v3, :cond_3b

    .line 444
    const-string v3, "cache"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " delete failed."

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_3b
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_3b} :catch_3e

    .line 441
    :cond_3b
    add-int/lit8 v2, v2, 0x1

    goto :goto_b

    .line 448
    .end local v0           #f:Ljava/io/File;
    .end local v1           #files:[Ljava/lang/String;
    .end local v2           #i:I
    :catch_3e
    move-exception v3

    .line 451
    :cond_3f
    return-void
.end method
