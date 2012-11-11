.class public final Landroid/net/http/HttpResponseCache;
.super Ljava/net/ResponseCache;
.source "HttpResponseCache.java"

# interfaces
.implements Ljava/io/Closeable;
.implements Ljava/net/ExtendedResponseCache;


# instance fields
.field private final delegate:Llibcore/net/http/HttpResponseCache;


# direct methods
.method private constructor <init>(Ljava/io/File;J)V
    .registers 5
    .parameter "directory"
    .parameter "maxSize"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    invoke-direct {p0}, Ljava/net/ResponseCache;-><init>()V

    new-instance v0, Llibcore/net/http/HttpResponseCache;

    invoke-direct {v0, p1, p2, p3}, Llibcore/net/http/HttpResponseCache;-><init>(Ljava/io/File;J)V

    iput-object v0, p0, Landroid/net/http/HttpResponseCache;->delegate:Llibcore/net/http/HttpResponseCache;

    return-void
.end method

.method public static getInstalled()Landroid/net/http/HttpResponseCache;
    .registers 2

    .prologue
    invoke-static {}, Ljava/net/ResponseCache;->getDefault()Ljava/net/ResponseCache;

    move-result-object v0

    .local v0, installed:Ljava/net/ResponseCache;
    instance-of v1, v0, Landroid/net/http/HttpResponseCache;

    if-eqz v1, :cond_b

    check-cast v0, Landroid/net/http/HttpResponseCache;

    .end local v0           #installed:Ljava/net/ResponseCache;
    :goto_a
    return-object v0

    .restart local v0       #installed:Ljava/net/ResponseCache;
    :cond_b
    const/4 v0, 0x0

    goto :goto_a
.end method

.method public static install(Ljava/io/File;J)Landroid/net/http/HttpResponseCache;
    .registers 8
    .parameter "directory"
    .parameter "maxSize"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    invoke-static {}, Landroid/net/http/HttpResponseCache;->getInstalled()Landroid/net/http/HttpResponseCache;

    move-result-object v0

    .local v0, installed:Landroid/net/http/HttpResponseCache;
    if-eqz v0, :cond_28

    iget-object v3, v0, Landroid/net/http/HttpResponseCache;->delegate:Llibcore/net/http/HttpResponseCache;

    invoke-virtual {v3}, Llibcore/net/http/HttpResponseCache;->getCache()Llibcore/io/DiskLruCache;

    move-result-object v1

    .local v1, installedCache:Llibcore/io/DiskLruCache;
    invoke-virtual {v1}, Llibcore/io/DiskLruCache;->getDirectory()Ljava/io/File;

    move-result-object v3

    invoke-virtual {v3, p0}, Ljava/io/File;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_25

    invoke-virtual {v1}, Llibcore/io/DiskLruCache;->maxSize()J

    move-result-wide v3

    cmp-long v3, v3, p1

    if-nez v3, :cond_25

    invoke-virtual {v1}, Llibcore/io/DiskLruCache;->isClosed()Z

    move-result v3

    if-nez v3, :cond_25

    .end local v0           #installed:Landroid/net/http/HttpResponseCache;
    .end local v1           #installedCache:Llibcore/io/DiskLruCache;
    :goto_24
    return-object v0

    .restart local v0       #installed:Landroid/net/http/HttpResponseCache;
    .restart local v1       #installedCache:Llibcore/io/DiskLruCache;
    :cond_25
    invoke-static {v0}, Llibcore/io/IoUtils;->closeQuietly(Ljava/lang/AutoCloseable;)V

    .end local v1           #installedCache:Llibcore/io/DiskLruCache;
    :cond_28
    new-instance v2, Landroid/net/http/HttpResponseCache;

    invoke-direct {v2, p0, p1, p2}, Landroid/net/http/HttpResponseCache;-><init>(Ljava/io/File;J)V

    .local v2, result:Landroid/net/http/HttpResponseCache;
    invoke-static {v2}, Ljava/net/ResponseCache;->setDefault(Ljava/net/ResponseCache;)V

    move-object v0, v2

    goto :goto_24
.end method


# virtual methods
.method public close()V
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    invoke-static {}, Ljava/net/ResponseCache;->getDefault()Ljava/net/ResponseCache;

    move-result-object v0

    if-ne v0, p0, :cond_a

    const/4 v0, 0x0

    invoke-static {v0}, Ljava/net/ResponseCache;->setDefault(Ljava/net/ResponseCache;)V

    :cond_a
    iget-object v0, p0, Landroid/net/http/HttpResponseCache;->delegate:Llibcore/net/http/HttpResponseCache;

    invoke-virtual {v0}, Llibcore/net/http/HttpResponseCache;->getCache()Llibcore/io/DiskLruCache;

    move-result-object v0

    invoke-virtual {v0}, Llibcore/io/DiskLruCache;->close()V

    return-void
.end method

.method public delete()V
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    invoke-static {}, Ljava/net/ResponseCache;->getDefault()Ljava/net/ResponseCache;

    move-result-object v0

    if-ne v0, p0, :cond_a

    const/4 v0, 0x0

    invoke-static {v0}, Ljava/net/ResponseCache;->setDefault(Ljava/net/ResponseCache;)V

    :cond_a
    iget-object v0, p0, Landroid/net/http/HttpResponseCache;->delegate:Llibcore/net/http/HttpResponseCache;

    invoke-virtual {v0}, Llibcore/net/http/HttpResponseCache;->getCache()Llibcore/io/DiskLruCache;

    move-result-object v0

    invoke-virtual {v0}, Llibcore/io/DiskLruCache;->delete()V

    return-void
.end method

.method public flush()V
    .registers 2

    .prologue
    :try_start_0
    iget-object v0, p0, Landroid/net/http/HttpResponseCache;->delegate:Llibcore/net/http/HttpResponseCache;

    invoke-virtual {v0}, Llibcore/net/http/HttpResponseCache;->getCache()Llibcore/io/DiskLruCache;

    move-result-object v0

    invoke-virtual {v0}, Llibcore/io/DiskLruCache;->flush()V
    :try_end_9
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_9} :catch_a

    :goto_9
    return-void

    :catch_a
    move-exception v0

    goto :goto_9
.end method

.method public get(Ljava/net/URI;Ljava/lang/String;Ljava/util/Map;)Ljava/net/CacheResponse;
    .registers 5
    .parameter "uri"
    .parameter "requestMethod"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/net/URI;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;)",
            "Ljava/net/CacheResponse;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .local p3, requestHeaders:Ljava/util/Map;,"Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    iget-object v0, p0, Landroid/net/http/HttpResponseCache;->delegate:Llibcore/net/http/HttpResponseCache;

    invoke-virtual {v0, p1, p2, p3}, Llibcore/net/http/HttpResponseCache;->get(Ljava/net/URI;Ljava/lang/String;Ljava/util/Map;)Ljava/net/CacheResponse;

    move-result-object v0

    return-object v0
.end method

.method public getHitCount()I
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/net/http/HttpResponseCache;->delegate:Llibcore/net/http/HttpResponseCache;

    invoke-virtual {v0}, Llibcore/net/http/HttpResponseCache;->getHitCount()I

    move-result v0

    return v0
.end method

.method public getNetworkCount()I
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/net/http/HttpResponseCache;->delegate:Llibcore/net/http/HttpResponseCache;

    invoke-virtual {v0}, Llibcore/net/http/HttpResponseCache;->getNetworkCount()I

    move-result v0

    return v0
.end method

.method public getRequestCount()I
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/net/http/HttpResponseCache;->delegate:Llibcore/net/http/HttpResponseCache;

    invoke-virtual {v0}, Llibcore/net/http/HttpResponseCache;->getRequestCount()I

    move-result v0

    return v0
.end method

.method public maxSize()J
    .registers 3

    .prologue
    iget-object v0, p0, Landroid/net/http/HttpResponseCache;->delegate:Llibcore/net/http/HttpResponseCache;

    invoke-virtual {v0}, Llibcore/net/http/HttpResponseCache;->getCache()Llibcore/io/DiskLruCache;

    move-result-object v0

    invoke-virtual {v0}, Llibcore/io/DiskLruCache;->maxSize()J

    move-result-wide v0

    return-wide v0
.end method

.method public put(Ljava/net/URI;Ljava/net/URLConnection;)Ljava/net/CacheRequest;
    .registers 4
    .parameter "uri"
    .parameter "urlConnection"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    iget-object v0, p0, Landroid/net/http/HttpResponseCache;->delegate:Llibcore/net/http/HttpResponseCache;

    invoke-virtual {v0, p1, p2}, Llibcore/net/http/HttpResponseCache;->put(Ljava/net/URI;Ljava/net/URLConnection;)Ljava/net/CacheRequest;

    move-result-object v0

    return-object v0
.end method

.method public size()J
    .registers 3

    .prologue
    iget-object v0, p0, Landroid/net/http/HttpResponseCache;->delegate:Llibcore/net/http/HttpResponseCache;

    invoke-virtual {v0}, Llibcore/net/http/HttpResponseCache;->getCache()Llibcore/io/DiskLruCache;

    move-result-object v0

    invoke-virtual {v0}, Llibcore/io/DiskLruCache;->size()J

    move-result-wide v0

    return-wide v0
.end method

.method public trackConditionalCacheHit()V
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/net/http/HttpResponseCache;->delegate:Llibcore/net/http/HttpResponseCache;

    invoke-virtual {v0}, Llibcore/net/http/HttpResponseCache;->trackConditionalCacheHit()V

    return-void
.end method

.method public trackResponse(Ljava/net/ResponseSource;)V
    .registers 3
    .parameter "source"

    .prologue
    iget-object v0, p0, Landroid/net/http/HttpResponseCache;->delegate:Llibcore/net/http/HttpResponseCache;

    invoke-virtual {v0, p1}, Llibcore/net/http/HttpResponseCache;->trackResponse(Ljava/net/ResponseSource;)V

    return-void
.end method

.method public update(Ljava/net/CacheResponse;Ljava/net/HttpURLConnection;)V
    .registers 4
    .parameter "conditionalCacheHit"
    .parameter "connection"

    .prologue
    iget-object v0, p0, Landroid/net/http/HttpResponseCache;->delegate:Llibcore/net/http/HttpResponseCache;

    invoke-virtual {v0, p1, p2}, Llibcore/net/http/HttpResponseCache;->update(Ljava/net/CacheResponse;Ljava/net/HttpURLConnection;)V

    return-void
.end method
