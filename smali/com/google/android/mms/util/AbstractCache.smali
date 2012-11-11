.class public abstract Lcom/google/android/mms/util/AbstractCache;
.super Ljava/lang/Object;
.source "AbstractCache.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/mms/util/AbstractCache$1;,
        Lcom/google/android/mms/util/AbstractCache$CacheEntry;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<K:",
        "Ljava/lang/Object;",
        "V:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# static fields
.field private static final DEBUG:Z = false

.field private static final LOCAL_LOGV:Z = false

.field private static final MAX_CACHED_ITEMS:I = 0x1f4

.field private static final TAG:Ljava/lang/String; = "AbstractCache"


# instance fields
.field private final mCacheMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<TK;",
            "Lcom/google/android/mms/util/AbstractCache$CacheEntry",
            "<TV;>;>;"
        }
    .end annotation
.end field


# direct methods
.method protected constructor <init>()V
    .registers 2

    .prologue
    .local p0, this:Lcom/google/android/mms/util/AbstractCache;,"Lcom/google/android/mms/util/AbstractCache<TK;TV;>;"
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/google/android/mms/util/AbstractCache;->mCacheMap:Ljava/util/HashMap;

    return-void
.end method


# virtual methods
.method public get(Ljava/lang/Object;)Ljava/lang/Object;
    .registers 4
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;)TV;"
        }
    .end annotation

    .prologue
    .local p0, this:Lcom/google/android/mms/util/AbstractCache;,"Lcom/google/android/mms/util/AbstractCache<TK;TV;>;"
    .local p1, key:Ljava/lang/Object;,"TK;"
    if-eqz p1, :cond_15

    iget-object v1, p0, Lcom/google/android/mms/util/AbstractCache;->mCacheMap:Ljava/util/HashMap;

    invoke-virtual {v1, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/mms/util/AbstractCache$CacheEntry;

    .local v0, cacheEntry:Lcom/google/android/mms/util/AbstractCache$CacheEntry;,"Lcom/google/android/mms/util/AbstractCache$CacheEntry<TV;>;"
    if-eqz v0, :cond_15

    iget v1, v0, Lcom/google/android/mms/util/AbstractCache$CacheEntry;->hit:I

    add-int/lit8 v1, v1, 0x1

    iput v1, v0, Lcom/google/android/mms/util/AbstractCache$CacheEntry;->hit:I

    iget-object v1, v0, Lcom/google/android/mms/util/AbstractCache$CacheEntry;->value:Ljava/lang/Object;

    .end local v0           #cacheEntry:Lcom/google/android/mms/util/AbstractCache$CacheEntry;,"Lcom/google/android/mms/util/AbstractCache$CacheEntry<TV;>;"
    :goto_14
    return-object v1

    :cond_15
    const/4 v1, 0x0

    goto :goto_14
.end method

.method public purge(Ljava/lang/Object;)Ljava/lang/Object;
    .registers 4
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;)TV;"
        }
    .end annotation

    .prologue
    .local p0, this:Lcom/google/android/mms/util/AbstractCache;,"Lcom/google/android/mms/util/AbstractCache<TK;TV;>;"
    .local p1, key:Ljava/lang/Object;,"TK;"
    iget-object v1, p0, Lcom/google/android/mms/util/AbstractCache;->mCacheMap:Ljava/util/HashMap;

    invoke-virtual {v1, p1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/mms/util/AbstractCache$CacheEntry;

    .local v0, v:Lcom/google/android/mms/util/AbstractCache$CacheEntry;,"Lcom/google/android/mms/util/AbstractCache$CacheEntry<TV;>;"
    if-eqz v0, :cond_d

    iget-object v1, v0, Lcom/google/android/mms/util/AbstractCache$CacheEntry;->value:Ljava/lang/Object;

    :goto_c
    return-object v1

    :cond_d
    const/4 v1, 0x0

    goto :goto_c
.end method

.method public purgeAll()V
    .registers 2

    .prologue
    .local p0, this:Lcom/google/android/mms/util/AbstractCache;,"Lcom/google/android/mms/util/AbstractCache<TK;TV;>;"
    iget-object v0, p0, Lcom/google/android/mms/util/AbstractCache;->mCacheMap:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    return-void
.end method

.method public put(Ljava/lang/Object;Ljava/lang/Object;)Z
    .registers 7
    .parameter
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;TV;)Z"
        }
    .end annotation

    .prologue
    .local p0, this:Lcom/google/android/mms/util/AbstractCache;,"Lcom/google/android/mms/util/AbstractCache<TK;TV;>;"
    .local p1, key:Ljava/lang/Object;,"TK;"
    .local p2, value:Ljava/lang/Object;,"TV;"
    const/4 v1, 0x0

    iget-object v2, p0, Lcom/google/android/mms/util/AbstractCache;->mCacheMap:Ljava/util/HashMap;

    invoke-virtual {v2}, Ljava/util/HashMap;->size()I

    move-result v2

    const/16 v3, 0x1f4

    if-lt v2, v3, :cond_c

    :cond_b
    :goto_b
    return v1

    :cond_c
    if-eqz p1, :cond_b

    new-instance v0, Lcom/google/android/mms/util/AbstractCache$CacheEntry;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/google/android/mms/util/AbstractCache$CacheEntry;-><init>(Lcom/google/android/mms/util/AbstractCache$1;)V

    .local v0, cacheEntry:Lcom/google/android/mms/util/AbstractCache$CacheEntry;,"Lcom/google/android/mms/util/AbstractCache$CacheEntry<TV;>;"
    iput-object p2, v0, Lcom/google/android/mms/util/AbstractCache$CacheEntry;->value:Ljava/lang/Object;

    iget-object v1, p0, Lcom/google/android/mms/util/AbstractCache;->mCacheMap:Ljava/util/HashMap;

    invoke-virtual {v1, p1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const/4 v1, 0x1

    goto :goto_b
.end method

.method public size()I
    .registers 2

    .prologue
    .local p0, this:Lcom/google/android/mms/util/AbstractCache;,"Lcom/google/android/mms/util/AbstractCache<TK;TV;>;"
    iget-object v0, p0, Lcom/google/android/mms/util/AbstractCache;->mCacheMap:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->size()I

    move-result v0

    return v0
.end method
