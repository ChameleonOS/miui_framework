.class public final Landroid/content/res/AssetManager$AssetInputStream;
.super Ljava/io/InputStream;
.source "AssetManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/content/res/AssetManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x11
    name = "AssetInputStream"
.end annotation


# instance fields
.field private mAsset:I

.field private mLength:J

.field private mMarkPos:J

.field final synthetic this$0:Landroid/content/res/AssetManager;


# direct methods
.method private constructor <init>(Landroid/content/res/AssetManager;I)V
    .registers 5
    .parameter
    .parameter "asset"

    .prologue
    iput-object p1, p0, Landroid/content/res/AssetManager$AssetInputStream;->this$0:Landroid/content/res/AssetManager;

    invoke-direct {p0}, Ljava/io/InputStream;-><init>()V

    iput p2, p0, Landroid/content/res/AssetManager$AssetInputStream;->mAsset:I

    #calls: Landroid/content/res/AssetManager;->getAssetLength(I)J
    invoke-static {p1, p2}, Landroid/content/res/AssetManager;->access$100(Landroid/content/res/AssetManager;I)J

    move-result-wide v0

    iput-wide v0, p0, Landroid/content/res/AssetManager$AssetInputStream;->mLength:J

    return-void
.end method

.method synthetic constructor <init>(Landroid/content/res/AssetManager;ILandroid/content/res/AssetManager$1;)V
    .registers 4
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"

    .prologue
    invoke-direct {p0, p1, p2}, Landroid/content/res/AssetManager$AssetInputStream;-><init>(Landroid/content/res/AssetManager;I)V

    return-void
.end method


# virtual methods
.method public final available()I
    .registers 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    iget-object v2, p0, Landroid/content/res/AssetManager$AssetInputStream;->this$0:Landroid/content/res/AssetManager;

    iget v3, p0, Landroid/content/res/AssetManager$AssetInputStream;->mAsset:I

    #calls: Landroid/content/res/AssetManager;->getAssetRemainingLength(I)J
    invoke-static {v2, v3}, Landroid/content/res/AssetManager;->access$300(Landroid/content/res/AssetManager;I)J

    move-result-wide v0

    .local v0, len:J
    const-wide/32 v2, 0x7fffffff

    cmp-long v2, v0, v2

    if-lez v2, :cond_13

    const v2, 0x7fffffff

    :goto_12
    return v2

    :cond_13
    long-to-int v2, v0

    goto :goto_12
.end method

.method public final close()V
    .registers 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    iget-object v1, p0, Landroid/content/res/AssetManager$AssetInputStream;->this$0:Landroid/content/res/AssetManager;

    monitor-enter v1

    :try_start_3
    iget v0, p0, Landroid/content/res/AssetManager$AssetInputStream;->mAsset:I

    if-eqz v0, :cond_1a

    iget-object v0, p0, Landroid/content/res/AssetManager$AssetInputStream;->this$0:Landroid/content/res/AssetManager;

    iget v2, p0, Landroid/content/res/AssetManager$AssetInputStream;->mAsset:I

    #calls: Landroid/content/res/AssetManager;->destroyAsset(I)V
    invoke-static {v0, v2}, Landroid/content/res/AssetManager;->access$400(Landroid/content/res/AssetManager;I)V

    const/4 v0, 0x0

    iput v0, p0, Landroid/content/res/AssetManager$AssetInputStream;->mAsset:I

    iget-object v0, p0, Landroid/content/res/AssetManager$AssetInputStream;->this$0:Landroid/content/res/AssetManager;

    invoke-virtual {p0}, Ljava/lang/Object;->hashCode()I

    move-result v2

    #calls: Landroid/content/res/AssetManager;->decRefsLocked(I)V
    invoke-static {v0, v2}, Landroid/content/res/AssetManager;->access$500(Landroid/content/res/AssetManager;I)V

    :cond_1a
    monitor-exit v1

    return-void

    :catchall_1c
    move-exception v0

    monitor-exit v1
    :try_end_1e
    .catchall {:try_start_3 .. :try_end_1e} :catchall_1c

    throw v0
.end method

.method protected finalize()V
    .registers 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    invoke-virtual {p0}, Landroid/content/res/AssetManager$AssetInputStream;->close()V

    return-void
.end method

.method public final getAssetInt()I
    .registers 2

    .prologue
    iget v0, p0, Landroid/content/res/AssetManager$AssetInputStream;->mAsset:I

    return v0
.end method

.method public final mark(I)V
    .registers 7
    .parameter "readlimit"

    .prologue
    iget-object v0, p0, Landroid/content/res/AssetManager$AssetInputStream;->this$0:Landroid/content/res/AssetManager;

    iget v1, p0, Landroid/content/res/AssetManager$AssetInputStream;->mAsset:I

    const-wide/16 v2, 0x0

    const/4 v4, 0x0

    #calls: Landroid/content/res/AssetManager;->seekAsset(IJI)J
    invoke-static {v0, v1, v2, v3, v4}, Landroid/content/res/AssetManager;->access$600(Landroid/content/res/AssetManager;IJI)J

    move-result-wide v0

    iput-wide v0, p0, Landroid/content/res/AssetManager$AssetInputStream;->mMarkPos:J

    return-void
.end method

.method public final markSupported()Z
    .registers 2

    .prologue
    const/4 v0, 0x1

    return v0
.end method

.method public final read()I
    .registers 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    iget-object v0, p0, Landroid/content/res/AssetManager$AssetInputStream;->this$0:Landroid/content/res/AssetManager;

    iget v1, p0, Landroid/content/res/AssetManager$AssetInputStream;->mAsset:I

    #calls: Landroid/content/res/AssetManager;->readAssetChar(I)I
    invoke-static {v0, v1}, Landroid/content/res/AssetManager;->access$200(Landroid/content/res/AssetManager;I)I

    move-result v0

    return v0
.end method

.method public final read([B)I
    .registers 6
    .parameter "b"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    iget-object v0, p0, Landroid/content/res/AssetManager$AssetInputStream;->this$0:Landroid/content/res/AssetManager;

    iget v1, p0, Landroid/content/res/AssetManager$AssetInputStream;->mAsset:I

    const/4 v2, 0x0

    array-length v3, p1

    #calls: Landroid/content/res/AssetManager;->readAsset(I[BII)I
    invoke-static {v0, v1, p1, v2, v3}, Landroid/content/res/AssetManager;->access$700(Landroid/content/res/AssetManager;I[BII)I

    move-result v0

    return v0
.end method

.method public final read([BII)I
    .registers 6
    .parameter "b"
    .parameter "off"
    .parameter "len"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    iget-object v0, p0, Landroid/content/res/AssetManager$AssetInputStream;->this$0:Landroid/content/res/AssetManager;

    iget v1, p0, Landroid/content/res/AssetManager$AssetInputStream;->mAsset:I

    #calls: Landroid/content/res/AssetManager;->readAsset(I[BII)I
    invoke-static {v0, v1, p1, p2, p3}, Landroid/content/res/AssetManager;->access$700(Landroid/content/res/AssetManager;I[BII)I

    move-result v0

    return v0
.end method

.method public final reset()V
    .registers 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    iget-object v0, p0, Landroid/content/res/AssetManager$AssetInputStream;->this$0:Landroid/content/res/AssetManager;

    iget v1, p0, Landroid/content/res/AssetManager$AssetInputStream;->mAsset:I

    iget-wide v2, p0, Landroid/content/res/AssetManager$AssetInputStream;->mMarkPos:J

    const/4 v4, -0x1

    #calls: Landroid/content/res/AssetManager;->seekAsset(IJI)J
    invoke-static {v0, v1, v2, v3, v4}, Landroid/content/res/AssetManager;->access$600(Landroid/content/res/AssetManager;IJI)J

    return-void
.end method

.method public final skip(J)J
    .registers 12
    .parameter "n"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const-wide/16 v7, 0x0

    const/4 v6, 0x0

    iget-object v2, p0, Landroid/content/res/AssetManager$AssetInputStream;->this$0:Landroid/content/res/AssetManager;

    iget v3, p0, Landroid/content/res/AssetManager$AssetInputStream;->mAsset:I

    #calls: Landroid/content/res/AssetManager;->seekAsset(IJI)J
    invoke-static {v2, v3, v7, v8, v6}, Landroid/content/res/AssetManager;->access$600(Landroid/content/res/AssetManager;IJI)J

    move-result-wide v0

    .local v0, pos:J
    add-long v2, v0, p1

    iget-wide v4, p0, Landroid/content/res/AssetManager$AssetInputStream;->mLength:J

    cmp-long v2, v2, v4

    if-lez v2, :cond_17

    iget-wide v2, p0, Landroid/content/res/AssetManager$AssetInputStream;->mLength:J

    sub-long p1, v2, v0

    :cond_17
    cmp-long v2, p1, v7

    if-lez v2, :cond_22

    iget-object v2, p0, Landroid/content/res/AssetManager$AssetInputStream;->this$0:Landroid/content/res/AssetManager;

    iget v3, p0, Landroid/content/res/AssetManager$AssetInputStream;->mAsset:I

    #calls: Landroid/content/res/AssetManager;->seekAsset(IJI)J
    invoke-static {v2, v3, p1, p2, v6}, Landroid/content/res/AssetManager;->access$600(Landroid/content/res/AssetManager;IJI)J

    :cond_22
    return-wide p1
.end method
