.class Landroid/os/storage/StorageManager$ObbStateChangedStorageEvent;
.super Landroid/os/storage/StorageManager$StorageEvent;
.source "StorageManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/os/storage/StorageManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ObbStateChangedStorageEvent"
.end annotation


# instance fields
.field public final path:Ljava/lang/String;

.field public final state:I

.field final synthetic this$0:Landroid/os/storage/StorageManager;


# direct methods
.method public constructor <init>(Landroid/os/storage/StorageManager;Ljava/lang/String;I)V
    .registers 5
    .parameter
    .parameter "path"
    .parameter "state"

    .prologue
    .line 189
    iput-object p1, p0, Landroid/os/storage/StorageManager$ObbStateChangedStorageEvent;->this$0:Landroid/os/storage/StorageManager;

    .line 190
    const/4 v0, 0x3

    invoke-direct {p0, p1, v0}, Landroid/os/storage/StorageManager$StorageEvent;-><init>(Landroid/os/storage/StorageManager;I)V

    .line 191
    iput-object p2, p0, Landroid/os/storage/StorageManager$ObbStateChangedStorageEvent;->path:Ljava/lang/String;

    .line 192
    iput p3, p0, Landroid/os/storage/StorageManager$ObbStateChangedStorageEvent;->state:I

    .line 193
    return-void
.end method
