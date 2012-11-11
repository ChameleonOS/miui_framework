.class public Landroid/content/SyncStorageEngine$PendingOperation;
.super Ljava/lang/Object;
.source "SyncStorageEngine.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/content/SyncStorageEngine;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PendingOperation"
.end annotation


# instance fields
.field final account:Landroid/accounts/Account;

.field final authority:Ljava/lang/String;

.field authorityId:I

.field final expedited:Z

.field final extras:Landroid/os/Bundle;

.field flatExtras:[B

.field final syncSource:I

.field final userId:I


# direct methods
.method constructor <init>(Landroid/accounts/Account;IILjava/lang/String;Landroid/os/Bundle;Z)V
    .registers 8
    .parameter "account"
    .parameter "userId"
    .parameter "source"
    .parameter "authority"
    .parameter "extras"
    .parameter "expedited"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroid/content/SyncStorageEngine$PendingOperation;->account:Landroid/accounts/Account;

    iput p2, p0, Landroid/content/SyncStorageEngine$PendingOperation;->userId:I

    iput p3, p0, Landroid/content/SyncStorageEngine$PendingOperation;->syncSource:I

    iput-object p4, p0, Landroid/content/SyncStorageEngine$PendingOperation;->authority:Ljava/lang/String;

    if-eqz p5, :cond_13

    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0, p5}, Landroid/os/Bundle;-><init>(Landroid/os/Bundle;)V

    move-object p5, v0

    .end local p5
    :cond_13
    iput-object p5, p0, Landroid/content/SyncStorageEngine$PendingOperation;->extras:Landroid/os/Bundle;

    iput-boolean p6, p0, Landroid/content/SyncStorageEngine$PendingOperation;->expedited:Z

    const/4 v0, -0x1

    iput v0, p0, Landroid/content/SyncStorageEngine$PendingOperation;->authorityId:I

    return-void
.end method

.method constructor <init>(Landroid/content/SyncStorageEngine$PendingOperation;)V
    .registers 3
    .parameter "other"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iget-object v0, p1, Landroid/content/SyncStorageEngine$PendingOperation;->account:Landroid/accounts/Account;

    iput-object v0, p0, Landroid/content/SyncStorageEngine$PendingOperation;->account:Landroid/accounts/Account;

    iget v0, p1, Landroid/content/SyncStorageEngine$PendingOperation;->userId:I

    iput v0, p0, Landroid/content/SyncStorageEngine$PendingOperation;->userId:I

    iget v0, p1, Landroid/content/SyncStorageEngine$PendingOperation;->syncSource:I

    iput v0, p0, Landroid/content/SyncStorageEngine$PendingOperation;->syncSource:I

    iget-object v0, p1, Landroid/content/SyncStorageEngine$PendingOperation;->authority:Ljava/lang/String;

    iput-object v0, p0, Landroid/content/SyncStorageEngine$PendingOperation;->authority:Ljava/lang/String;

    iget-object v0, p1, Landroid/content/SyncStorageEngine$PendingOperation;->extras:Landroid/os/Bundle;

    iput-object v0, p0, Landroid/content/SyncStorageEngine$PendingOperation;->extras:Landroid/os/Bundle;

    iget v0, p1, Landroid/content/SyncStorageEngine$PendingOperation;->authorityId:I

    iput v0, p0, Landroid/content/SyncStorageEngine$PendingOperation;->authorityId:I

    iget-boolean v0, p1, Landroid/content/SyncStorageEngine$PendingOperation;->expedited:Z

    iput-boolean v0, p0, Landroid/content/SyncStorageEngine$PendingOperation;->expedited:Z

    return-void
.end method
