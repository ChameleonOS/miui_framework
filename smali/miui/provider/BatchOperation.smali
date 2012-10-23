.class public final Lmiui/provider/BatchOperation;
.super Ljava/lang/Object;
.source "BatchOperation.java"


# static fields
.field public static final BATCH_EXECUTE_SIZE:I = 0x64


# instance fields
.field private final mAuthority:Ljava/lang/String;

.field private final mOperations:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/content/ContentProviderOperation;",
            ">;"
        }
    .end annotation
.end field

.field private final mResolver:Landroid/content/ContentResolver;


# direct methods
.method public constructor <init>(Landroid/content/ContentResolver;Ljava/lang/String;)V
    .registers 4
    .parameter "resolver"
    .parameter "authority"

    .prologue
    .line 28
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 29
    iput-object p1, p0, Lmiui/provider/BatchOperation;->mResolver:Landroid/content/ContentResolver;

    .line 30
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lmiui/provider/BatchOperation;->mOperations:Ljava/util/ArrayList;

    .line 31
    iput-object p2, p0, Lmiui/provider/BatchOperation;->mAuthority:Ljava/lang/String;

    .line 32
    return-void
.end method


# virtual methods
.method public add(Landroid/content/ContentProviderOperation;)V
    .registers 3
    .parameter "cpo"

    .prologue
    .line 39
    iget-object v0, p0, Lmiui/provider/BatchOperation;->mOperations:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 40
    return-void
.end method

.method public execute()Landroid/net/Uri;
    .registers 9

    .prologue
    .line 47
    const/4 v2, 0x0

    .line 49
    .local v2, result:Landroid/net/Uri;
    iget-object v5, p0, Lmiui/provider/BatchOperation;->mOperations:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v5

    if-nez v5, :cond_b

    move-object v3, v2

    .line 64
    .end local v2           #result:Landroid/net/Uri;
    .local v3, result:Landroid/net/Uri;
    :goto_a
    return-object v3

    .line 54
    .end local v3           #result:Landroid/net/Uri;
    .restart local v2       #result:Landroid/net/Uri;
    :cond_b
    :try_start_b
    iget-object v5, p0, Lmiui/provider/BatchOperation;->mResolver:Landroid/content/ContentResolver;

    iget-object v6, p0, Lmiui/provider/BatchOperation;->mAuthority:Ljava/lang/String;

    iget-object v7, p0, Lmiui/provider/BatchOperation;->mOperations:Ljava/util/ArrayList;

    invoke-virtual {v5, v6, v7}, Landroid/content/ContentResolver;->applyBatch(Ljava/lang/String;Ljava/util/ArrayList;)[Landroid/content/ContentProviderResult;

    move-result-object v4

    .line 56
    .local v4, results:[Landroid/content/ContentProviderResult;
    if-eqz v4, :cond_1f

    array-length v5, v4

    if-lez v5, :cond_1f

    .line 57
    const/4 v5, 0x0

    aget-object v5, v4, v5

    iget-object v2, v5, Landroid/content/ContentProviderResult;->uri:Landroid/net/Uri;
    :try_end_1f
    .catch Landroid/content/OperationApplicationException; {:try_start_b .. :try_end_1f} :catch_26
    .catch Landroid/os/RemoteException; {:try_start_b .. :try_end_1f} :catch_30

    .line 63
    .end local v4           #results:[Landroid/content/ContentProviderResult;
    :cond_1f
    :goto_1f
    iget-object v5, p0, Lmiui/provider/BatchOperation;->mOperations:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->clear()V

    move-object v3, v2

    .line 64
    .end local v2           #result:Landroid/net/Uri;
    .restart local v3       #result:Landroid/net/Uri;
    goto :goto_a

    .line 58
    .end local v3           #result:Landroid/net/Uri;
    .restart local v2       #result:Landroid/net/Uri;
    :catch_26
    move-exception v0

    .line 59
    .local v0, e1:Landroid/content/OperationApplicationException;
    const-string v5, "BatchOperation"

    const-string/jumbo v6, "storing contact data failed"

    invoke-static {v5, v6, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_1f

    .line 60
    .end local v0           #e1:Landroid/content/OperationApplicationException;
    :catch_30
    move-exception v1

    .line 61
    .local v1, e2:Landroid/os/RemoteException;
    const-string v5, "BatchOperation"

    const-string/jumbo v6, "storing contact data failed"

    invoke-static {v5, v6, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_1f
.end method

.method public getContentResolver()Landroid/content/ContentResolver;
    .registers 2

    .prologue
    .line 43
    iget-object v0, p0, Lmiui/provider/BatchOperation;->mResolver:Landroid/content/ContentResolver;

    return-object v0
.end method

.method public size()I
    .registers 2

    .prologue
    .line 35
    iget-object v0, p0, Lmiui/provider/BatchOperation;->mOperations:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public toString()Ljava/lang/String;
    .registers 6

    .prologue
    .line 69
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 70
    .local v2, sb:Ljava/lang/StringBuilder;
    iget-object v3, p0, Lmiui/provider/BatchOperation;->mOperations:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, i$:Ljava/util/Iterator;
    :goto_b
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_32

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/content/ContentProviderOperation;

    .line 71
    .local v1, op:Landroid/content/ContentProviderOperation;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1}, Landroid/content/ContentProviderOperation;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\n"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_b

    .line 73
    .end local v1           #op:Landroid/content/ContentProviderOperation;
    :cond_32
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3
.end method
