.class Landroid/app/ApplicationLoaders;
.super Ljava/lang/Object;
.source "ApplicationLoaders.java"


# static fields
.field private static final gApplicationLoaders:Landroid/app/ApplicationLoaders;


# instance fields
.field private final mLoaders:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/ClassLoader;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 70
    new-instance v0, Landroid/app/ApplicationLoaders;

    invoke-direct {v0}, Landroid/app/ApplicationLoaders;-><init>()V

    sput-object v0, Landroid/app/ApplicationLoaders;->gApplicationLoaders:Landroid/app/ApplicationLoaders;

    return-void
.end method

.method constructor <init>()V
    .registers 2

    .prologue
    .line 24
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 68
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroid/app/ApplicationLoaders;->mLoaders:Ljava/util/Map;

    return-void
.end method

.method public static getDefault()Landroid/app/ApplicationLoaders;
    .registers 1

    .prologue
    .line 28
    sget-object v0, Landroid/app/ApplicationLoaders;->gApplicationLoaders:Landroid/app/ApplicationLoaders;

    return-object v0
.end method


# virtual methods
.method public getClassLoader(Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)Ljava/lang/ClassLoader;
    .registers 9
    .parameter "zip"
    .parameter "libPath"
    .parameter "parent"

    .prologue
    .line 39
    invoke-static {}, Ljava/lang/ClassLoader;->getSystemClassLoader()Ljava/lang/ClassLoader;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/ClassLoader;->getParent()Ljava/lang/ClassLoader;

    move-result-object v0

    .line 41
    .local v0, baseParent:Ljava/lang/ClassLoader;
    iget-object v4, p0, Landroid/app/ApplicationLoaders;->mLoaders:Ljava/util/Map;

    monitor-enter v4

    .line 42
    if-nez p3, :cond_e

    .line 43
    move-object p3, v0

    .line 51
    :cond_e
    if-ne p3, v0, :cond_29

    .line 52
    :try_start_10
    iget-object v3, p0, Landroid/app/ApplicationLoaders;->mLoaders:Ljava/util/Map;

    invoke-interface {v3, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/ClassLoader;

    .line 53
    .local v1, loader:Ljava/lang/ClassLoader;
    if-eqz v1, :cond_1c

    .line 54
    monitor-exit v4

    .line 64
    .end local v1           #loader:Ljava/lang/ClassLoader;
    :goto_1b
    return-object v1

    .line 57
    .restart local v1       #loader:Ljava/lang/ClassLoader;
    :cond_1c
    new-instance v2, Ldalvik/system/PathClassLoader;

    invoke-direct {v2, p1, p2, p3}, Ldalvik/system/PathClassLoader;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V

    .line 60
    .local v2, pathClassloader:Ldalvik/system/PathClassLoader;
    iget-object v3, p0, Landroid/app/ApplicationLoaders;->mLoaders:Ljava/util/Map;

    invoke-interface {v3, p1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 61
    monitor-exit v4

    move-object v1, v2

    goto :goto_1b

    .line 64
    .end local v1           #loader:Ljava/lang/ClassLoader;
    .end local v2           #pathClassloader:Ldalvik/system/PathClassLoader;
    :cond_29
    new-instance v1, Ldalvik/system/PathClassLoader;

    invoke-direct {v1, p1, p3}, Ldalvik/system/PathClassLoader;-><init>(Ljava/lang/String;Ljava/lang/ClassLoader;)V

    monitor-exit v4

    goto :goto_1b

    .line 65
    :catchall_30
    move-exception v3

    monitor-exit v4
    :try_end_32
    .catchall {:try_start_10 .. :try_end_32} :catchall_30

    throw v3
.end method
