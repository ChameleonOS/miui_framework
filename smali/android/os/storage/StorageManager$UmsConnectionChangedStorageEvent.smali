.class Landroid/os/storage/StorageManager$UmsConnectionChangedStorageEvent;
.super Landroid/os/storage/StorageManager$StorageEvent;
.source "StorageManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/os/storage/StorageManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "UmsConnectionChangedStorageEvent"
.end annotation


# instance fields
.field public available:Z

.field final synthetic this$0:Landroid/os/storage/StorageManager;


# direct methods
.method public constructor <init>(Landroid/os/storage/StorageManager;Z)V
    .registers 4
    .parameter
    .parameter "a"

    .prologue
    .line 224
    iput-object p1, p0, Landroid/os/storage/StorageManager$UmsConnectionChangedStorageEvent;->this$0:Landroid/os/storage/StorageManager;

    .line 225
    const/4 v0, 0x1

    invoke-direct {p0, p1, v0}, Landroid/os/storage/StorageManager$StorageEvent;-><init>(Landroid/os/storage/StorageManager;I)V

    .line 226
    iput-boolean p2, p0, Landroid/os/storage/StorageManager$UmsConnectionChangedStorageEvent;->available:Z

    .line 227
    return-void
.end method
