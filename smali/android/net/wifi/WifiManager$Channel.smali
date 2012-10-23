.class public Landroid/net/wifi/WifiManager$Channel;
.super Ljava/lang/Object;
.source "WifiManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/net/wifi/WifiManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Channel"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/net/wifi/WifiManager$Channel$WifiHandler;
    }
.end annotation


# static fields
.field private static final INVALID_KEY:I = -0x1


# instance fields
.field mAsyncChannel:Lcom/android/internal/util/AsyncChannel;

.field private mChannelListener:Landroid/net/wifi/WifiManager$ChannelListener;

.field mHandler:Landroid/net/wifi/WifiManager$Channel$WifiHandler;

.field private mListenerKey:I

.field private mListenerMap:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field private mListenerMapLock:Ljava/lang/Object;


# direct methods
.method constructor <init>(Landroid/os/Looper;Landroid/net/wifi/WifiManager$ChannelListener;)V
    .registers 4
    .parameter "looper"
    .parameter "l"

    .prologue
    .line 1215
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 1221
    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    iput-object v0, p0, Landroid/net/wifi/WifiManager$Channel;->mListenerMap:Landroid/util/SparseArray;

    .line 1222
    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Landroid/net/wifi/WifiManager$Channel;->mListenerMapLock:Ljava/lang/Object;

    .line 1223
    const/4 v0, 0x0

    iput v0, p0, Landroid/net/wifi/WifiManager$Channel;->mListenerKey:I

    .line 1216
    new-instance v0, Lcom/android/internal/util/AsyncChannel;

    invoke-direct {v0}, Lcom/android/internal/util/AsyncChannel;-><init>()V

    iput-object v0, p0, Landroid/net/wifi/WifiManager$Channel;->mAsyncChannel:Lcom/android/internal/util/AsyncChannel;

    .line 1217
    new-instance v0, Landroid/net/wifi/WifiManager$Channel$WifiHandler;

    invoke-direct {v0, p0, p1}, Landroid/net/wifi/WifiManager$Channel$WifiHandler;-><init>(Landroid/net/wifi/WifiManager$Channel;Landroid/os/Looper;)V

    iput-object v0, p0, Landroid/net/wifi/WifiManager$Channel;->mHandler:Landroid/net/wifi/WifiManager$Channel$WifiHandler;

    .line 1218
    iput-object p2, p0, Landroid/net/wifi/WifiManager$Channel;->mChannelListener:Landroid/net/wifi/WifiManager$ChannelListener;

    .line 1219
    return-void
.end method

.method static synthetic access$000(Landroid/net/wifi/WifiManager$Channel;)Landroid/net/wifi/WifiManager$ChannelListener;
    .registers 2
    .parameter "x0"

    .prologue
    .line 1214
    iget-object v0, p0, Landroid/net/wifi/WifiManager$Channel;->mChannelListener:Landroid/net/wifi/WifiManager$ChannelListener;

    return-object v0
.end method

.method static synthetic access$002(Landroid/net/wifi/WifiManager$Channel;Landroid/net/wifi/WifiManager$ChannelListener;)Landroid/net/wifi/WifiManager$ChannelListener;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 1214
    iput-object p1, p0, Landroid/net/wifi/WifiManager$Channel;->mChannelListener:Landroid/net/wifi/WifiManager$ChannelListener;

    return-object p1
.end method

.method static synthetic access$100(Landroid/net/wifi/WifiManager$Channel;)Ljava/lang/Object;
    .registers 2
    .parameter "x0"

    .prologue
    .line 1214
    iget-object v0, p0, Landroid/net/wifi/WifiManager$Channel;->mListenerMapLock:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic access$200(Landroid/net/wifi/WifiManager$Channel;)Landroid/util/SparseArray;
    .registers 2
    .parameter "x0"

    .prologue
    .line 1214
    iget-object v0, p0, Landroid/net/wifi/WifiManager$Channel;->mListenerMap:Landroid/util/SparseArray;

    return-object v0
.end method


# virtual methods
.method putListener(Ljava/lang/Object;)I
    .registers 6
    .parameter "listener"

    .prologue
    const/4 v1, -0x1

    .line 1291
    if-nez p1, :cond_5

    move v0, v1

    .line 1299
    :goto_4
    return v0

    .line 1293
    :cond_5
    iget-object v2, p0, Landroid/net/wifi/WifiManager$Channel;->mListenerMapLock:Ljava/lang/Object;

    monitor-enter v2

    .line 1295
    :cond_8
    :try_start_8
    iget v0, p0, Landroid/net/wifi/WifiManager$Channel;->mListenerKey:I

    add-int/lit8 v3, v0, 0x1

    iput v3, p0, Landroid/net/wifi/WifiManager$Channel;->mListenerKey:I

    .line 1296
    .local v0, key:I
    if-eq v0, v1, :cond_8

    .line 1297
    iget-object v1, p0, Landroid/net/wifi/WifiManager$Channel;->mListenerMap:Landroid/util/SparseArray;

    invoke-virtual {v1, v0, p1}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 1298
    monitor-exit v2

    goto :goto_4

    .end local v0           #key:I
    :catchall_17
    move-exception v1

    monitor-exit v2
    :try_end_19
    .catchall {:try_start_8 .. :try_end_19} :catchall_17

    throw v1
.end method

.method removeListener(I)Ljava/lang/Object;
    .registers 5
    .parameter "key"

    .prologue
    .line 1303
    const/4 v1, -0x1

    if-ne p1, v1, :cond_5

    const/4 v0, 0x0

    .line 1307
    :goto_4
    return-object v0

    .line 1304
    :cond_5
    iget-object v2, p0, Landroid/net/wifi/WifiManager$Channel;->mListenerMapLock:Ljava/lang/Object;

    monitor-enter v2

    .line 1305
    :try_start_8
    iget-object v1, p0, Landroid/net/wifi/WifiManager$Channel;->mListenerMap:Landroid/util/SparseArray;

    invoke-virtual {v1, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    .line 1306
    .local v0, listener:Ljava/lang/Object;
    iget-object v1, p0, Landroid/net/wifi/WifiManager$Channel;->mListenerMap:Landroid/util/SparseArray;

    invoke-virtual {v1, p1}, Landroid/util/SparseArray;->remove(I)V

    .line 1307
    monitor-exit v2

    goto :goto_4

    .line 1308
    .end local v0           #listener:Ljava/lang/Object;
    :catchall_15
    move-exception v1

    monitor-exit v2
    :try_end_17
    .catchall {:try_start_8 .. :try_end_17} :catchall_15

    throw v1
.end method
