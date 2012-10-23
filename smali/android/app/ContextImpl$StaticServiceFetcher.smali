.class abstract Landroid/app/ContextImpl$StaticServiceFetcher;
.super Landroid/app/ContextImpl$ServiceFetcher;
.source "ContextImpl.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/app/ContextImpl;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x408
    name = "StaticServiceFetcher"
.end annotation


# instance fields
.field private mCachedInstance:Ljava/lang/Object;


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 229
    invoke-direct {p0}, Landroid/app/ContextImpl$ServiceFetcher;-><init>()V

    return-void
.end method


# virtual methods
.method public abstract createStaticService()Ljava/lang/Object;
.end method

.method public final getService(Landroid/app/ContextImpl;)Ljava/lang/Object;
    .registers 4
    .parameter "unused"

    .prologue
    .line 234
    monitor-enter p0

    .line 235
    :try_start_1
    iget-object v0, p0, Landroid/app/ContextImpl$StaticServiceFetcher;->mCachedInstance:Ljava/lang/Object;

    .line 236
    .local v0, service:Ljava/lang/Object;
    if-eqz v0, :cond_7

    .line 237
    monitor-exit p0

    .line 239
    .end local v0           #service:Ljava/lang/Object;
    :goto_6
    return-object v0

    .restart local v0       #service:Ljava/lang/Object;
    :cond_7
    invoke-virtual {p0}, Landroid/app/ContextImpl$StaticServiceFetcher;->createStaticService()Ljava/lang/Object;

    move-result-object v0

    .end local v0           #service:Ljava/lang/Object;
    iput-object v0, p0, Landroid/app/ContextImpl$StaticServiceFetcher;->mCachedInstance:Ljava/lang/Object;

    monitor-exit p0

    goto :goto_6

    .line 240
    :catchall_f
    move-exception v1

    monitor-exit p0
    :try_end_11
    .catchall {:try_start_1 .. :try_end_11} :catchall_f

    throw v1
.end method
