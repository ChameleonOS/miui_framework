.class final Landroid/app/ContextImpl$ApplicationContentResolver;
.super Landroid/content/ContentResolver;
.source "ContextImpl.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/app/ContextImpl;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "ApplicationContentResolver"
.end annotation


# instance fields
.field private final mMainThread:Landroid/app/ActivityThread;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/app/ActivityThread;)V
    .registers 3
    .parameter "context"
    .parameter "mainThread"

    .prologue
    .line 1704
    invoke-direct {p0, p1}, Landroid/content/ContentResolver;-><init>(Landroid/content/Context;)V

    .line 1705
    iput-object p2, p0, Landroid/app/ContextImpl$ApplicationContentResolver;->mMainThread:Landroid/app/ActivityThread;

    .line 1706
    return-void
.end method


# virtual methods
.method protected acquireExistingProvider(Landroid/content/Context;Ljava/lang/String;)Landroid/content/IContentProvider;
    .registers 5
    .parameter "context"
    .parameter "name"

    .prologue
    .line 1715
    iget-object v0, p0, Landroid/app/ContextImpl$ApplicationContentResolver;->mMainThread:Landroid/app/ActivityThread;

    const/4 v1, 0x1

    invoke-virtual {v0, p1, p2, v1}, Landroid/app/ActivityThread;->acquireExistingProvider(Landroid/content/Context;Ljava/lang/String;Z)Landroid/content/IContentProvider;

    move-result-object v0

    return-object v0
.end method

.method protected acquireProvider(Landroid/content/Context;Ljava/lang/String;)Landroid/content/IContentProvider;
    .registers 5
    .parameter "context"
    .parameter "name"

    .prologue
    .line 1710
    iget-object v0, p0, Landroid/app/ContextImpl$ApplicationContentResolver;->mMainThread:Landroid/app/ActivityThread;

    const/4 v1, 0x1

    invoke-virtual {v0, p1, p2, v1}, Landroid/app/ActivityThread;->acquireProvider(Landroid/content/Context;Ljava/lang/String;Z)Landroid/content/IContentProvider;

    move-result-object v0

    return-object v0
.end method

.method protected acquireUnstableProvider(Landroid/content/Context;Ljava/lang/String;)Landroid/content/IContentProvider;
    .registers 5
    .parameter "c"
    .parameter "name"

    .prologue
    .line 1725
    iget-object v0, p0, Landroid/app/ContextImpl$ApplicationContentResolver;->mMainThread:Landroid/app/ActivityThread;

    const/4 v1, 0x0

    invoke-virtual {v0, p1, p2, v1}, Landroid/app/ActivityThread;->acquireProvider(Landroid/content/Context;Ljava/lang/String;Z)Landroid/content/IContentProvider;

    move-result-object v0

    return-object v0
.end method

.method public releaseProvider(Landroid/content/IContentProvider;)Z
    .registers 4
    .parameter "provider"

    .prologue
    .line 1720
    iget-object v0, p0, Landroid/app/ContextImpl$ApplicationContentResolver;->mMainThread:Landroid/app/ActivityThread;

    const/4 v1, 0x1

    invoke-virtual {v0, p1, v1}, Landroid/app/ActivityThread;->releaseProvider(Landroid/content/IContentProvider;Z)Z

    move-result v0

    return v0
.end method

.method public releaseUnstableProvider(Landroid/content/IContentProvider;)Z
    .registers 4
    .parameter "icp"

    .prologue
    .line 1730
    iget-object v0, p0, Landroid/app/ContextImpl$ApplicationContentResolver;->mMainThread:Landroid/app/ActivityThread;

    const/4 v1, 0x0

    invoke-virtual {v0, p1, v1}, Landroid/app/ActivityThread;->releaseProvider(Landroid/content/IContentProvider;Z)Z

    move-result v0

    return v0
.end method

.method public unstableProviderDied(Landroid/content/IContentProvider;)V
    .registers 5
    .parameter "icp"

    .prologue
    .line 1735
    iget-object v0, p0, Landroid/app/ContextImpl$ApplicationContentResolver;->mMainThread:Landroid/app/ActivityThread;

    invoke-interface {p1}, Landroid/content/IContentProvider;->asBinder()Landroid/os/IBinder;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/app/ActivityThread;->handleUnstableProviderDied(Landroid/os/IBinder;Z)V

    .line 1736
    return-void
.end method
