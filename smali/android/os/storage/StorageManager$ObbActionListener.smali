.class Landroid/os/storage/StorageManager$ObbActionListener;
.super Landroid/os/storage/IObbActionListener$Stub;
.source "StorageManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/os/storage/StorageManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ObbActionListener"
.end annotation


# instance fields
.field private mListeners:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Landroid/os/storage/StorageManager$ObbListenerDelegate;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic this$0:Landroid/os/storage/StorageManager;


# direct methods
.method private constructor <init>(Landroid/os/storage/StorageManager;)V
    .registers 3
    .parameter

    .prologue
    iput-object p1, p0, Landroid/os/storage/StorageManager$ObbActionListener;->this$0:Landroid/os/storage/StorageManager;

    invoke-direct {p0}, Landroid/os/storage/IObbActionListener$Stub;-><init>()V

    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    iput-object v0, p0, Landroid/os/storage/StorageManager$ObbActionListener;->mListeners:Landroid/util/SparseArray;

    return-void
.end method

.method synthetic constructor <init>(Landroid/os/storage/StorageManager;Landroid/os/storage/StorageManager$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    invoke-direct {p0, p1}, Landroid/os/storage/StorageManager$ObbActionListener;-><init>(Landroid/os/storage/StorageManager;)V

    return-void
.end method


# virtual methods
.method public addListener(Landroid/os/storage/OnObbStateChangeListener;)I
    .registers 6
    .parameter "listener"

    .prologue
    new-instance v0, Landroid/os/storage/StorageManager$ObbListenerDelegate;

    iget-object v1, p0, Landroid/os/storage/StorageManager$ObbActionListener;->this$0:Landroid/os/storage/StorageManager;

    invoke-direct {v0, v1, p1}, Landroid/os/storage/StorageManager$ObbListenerDelegate;-><init>(Landroid/os/storage/StorageManager;Landroid/os/storage/OnObbStateChangeListener;)V

    .local v0, delegate:Landroid/os/storage/StorageManager$ObbListenerDelegate;
    iget-object v2, p0, Landroid/os/storage/StorageManager$ObbActionListener;->mListeners:Landroid/util/SparseArray;

    monitor-enter v2

    :try_start_a
    iget-object v1, p0, Landroid/os/storage/StorageManager$ObbActionListener;->mListeners:Landroid/util/SparseArray;

    #getter for: Landroid/os/storage/StorageManager$ObbListenerDelegate;->nonce:I
    invoke-static {v0}, Landroid/os/storage/StorageManager$ObbListenerDelegate;->access$200(Landroid/os/storage/StorageManager$ObbListenerDelegate;)I

    move-result v3

    invoke-virtual {v1, v3, v0}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    monitor-exit v2
    :try_end_14
    .catchall {:try_start_a .. :try_end_14} :catchall_19

    #getter for: Landroid/os/storage/StorageManager$ObbListenerDelegate;->nonce:I
    invoke-static {v0}, Landroid/os/storage/StorageManager$ObbListenerDelegate;->access$200(Landroid/os/storage/StorageManager$ObbListenerDelegate;)I

    move-result v1

    return v1

    :catchall_19
    move-exception v1

    :try_start_1a
    monitor-exit v2
    :try_end_1b
    .catchall {:try_start_1a .. :try_end_1b} :catchall_19

    throw v1
.end method

.method public onObbResult(Ljava/lang/String;II)V
    .registers 7
    .parameter "filename"
    .parameter "nonce"
    .parameter "status"

    .prologue
    iget-object v2, p0, Landroid/os/storage/StorageManager$ObbActionListener;->mListeners:Landroid/util/SparseArray;

    monitor-enter v2

    :try_start_3
    iget-object v1, p0, Landroid/os/storage/StorageManager$ObbActionListener;->mListeners:Landroid/util/SparseArray;

    invoke-virtual {v1, p2}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/storage/StorageManager$ObbListenerDelegate;

    .local v0, delegate:Landroid/os/storage/StorageManager$ObbListenerDelegate;
    if-eqz v0, :cond_12

    iget-object v1, p0, Landroid/os/storage/StorageManager$ObbActionListener;->mListeners:Landroid/util/SparseArray;

    invoke-virtual {v1, p2}, Landroid/util/SparseArray;->remove(I)V

    :cond_12
    monitor-exit v2
    :try_end_13
    .catchall {:try_start_3 .. :try_end_13} :catchall_19

    if-eqz v0, :cond_18

    invoke-virtual {v0, p1, p3}, Landroid/os/storage/StorageManager$ObbListenerDelegate;->sendObbStateChanged(Ljava/lang/String;I)V

    :cond_18
    return-void

    .end local v0           #delegate:Landroid/os/storage/StorageManager$ObbListenerDelegate;
    :catchall_19
    move-exception v1

    :try_start_1a
    monitor-exit v2
    :try_end_1b
    .catchall {:try_start_1a .. :try_end_1b} :catchall_19

    throw v1
.end method
