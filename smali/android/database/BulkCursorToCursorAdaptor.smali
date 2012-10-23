.class public final Landroid/database/BulkCursorToCursorAdaptor;
.super Landroid/database/AbstractWindowedCursor;
.source "BulkCursorToCursorAdaptor.java"


# static fields
.field private static final TAG:Ljava/lang/String; = "BulkCursor"


# instance fields
.field private mBulkCursor:Landroid/database/IBulkCursor;

.field private mColumns:[Ljava/lang/String;

.field private mCount:I

.field private mObserverBridge:Landroid/database/AbstractCursor$SelfContentObserver;

.field private mWantsAllOnMoveCalls:Z


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 28
    invoke-direct {p0}, Landroid/database/AbstractWindowedCursor;-><init>()V

    .line 31
    new-instance v0, Landroid/database/AbstractCursor$SelfContentObserver;

    invoke-direct {v0, p0}, Landroid/database/AbstractCursor$SelfContentObserver;-><init>(Landroid/database/AbstractCursor;)V

    iput-object v0, p0, Landroid/database/BulkCursorToCursorAdaptor;->mObserverBridge:Landroid/database/AbstractCursor$SelfContentObserver;

    return-void
.end method

.method private throwIfCursorIsClosed()V
    .registers 3

    .prologue
    .line 63
    iget-object v0, p0, Landroid/database/BulkCursorToCursorAdaptor;->mBulkCursor:Landroid/database/IBulkCursor;

    if-nez v0, :cond_c

    .line 64
    new-instance v0, Landroid/database/StaleDataException;

    const-string v1, "Attempted to access a cursor after it has been closed."

    invoke-direct {v0, v1}, Landroid/database/StaleDataException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 66
    :cond_c
    return-void
.end method


# virtual methods
.method public close()V
    .registers 5

    .prologue
    const/4 v3, 0x0

    .line 118
    invoke-super {p0}, Landroid/database/AbstractWindowedCursor;->close()V

    .line 120
    iget-object v1, p0, Landroid/database/BulkCursorToCursorAdaptor;->mBulkCursor:Landroid/database/IBulkCursor;

    if-eqz v1, :cond_f

    .line 122
    :try_start_8
    iget-object v1, p0, Landroid/database/BulkCursorToCursorAdaptor;->mBulkCursor:Landroid/database/IBulkCursor;

    invoke-interface {v1}, Landroid/database/IBulkCursor;->close()V
    :try_end_d
    .catchall {:try_start_8 .. :try_end_d} :catchall_19
    .catch Landroid/os/RemoteException; {:try_start_8 .. :try_end_d} :catch_10

    .line 126
    :goto_d
    iput-object v3, p0, Landroid/database/BulkCursorToCursorAdaptor;->mBulkCursor:Landroid/database/IBulkCursor;

    .line 129
    :cond_f
    return-void

    .line 123
    :catch_10
    move-exception v0

    .line 124
    .local v0, ex:Landroid/os/RemoteException;
    :try_start_11
    const-string v1, "BulkCursor"

    const-string v2, "Remote process exception when closing"

    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_18
    .catchall {:try_start_11 .. :try_end_18} :catchall_19

    goto :goto_d

    .line 126
    .end local v0           #ex:Landroid/os/RemoteException;
    :catchall_19
    move-exception v1

    iput-object v3, p0, Landroid/database/BulkCursorToCursorAdaptor;->mBulkCursor:Landroid/database/IBulkCursor;

    throw v1
.end method

.method public deactivate()V
    .registers 4

    .prologue
    .line 105
    invoke-super {p0}, Landroid/database/AbstractWindowedCursor;->deactivate()V

    .line 107
    iget-object v1, p0, Landroid/database/BulkCursorToCursorAdaptor;->mBulkCursor:Landroid/database/IBulkCursor;

    if-eqz v1, :cond_c

    .line 109
    :try_start_7
    iget-object v1, p0, Landroid/database/BulkCursorToCursorAdaptor;->mBulkCursor:Landroid/database/IBulkCursor;

    invoke-interface {v1}, Landroid/database/IBulkCursor;->deactivate()V
    :try_end_c
    .catch Landroid/os/RemoteException; {:try_start_7 .. :try_end_c} :catch_d

    .line 114
    :cond_c
    :goto_c
    return-void

    .line 110
    :catch_d
    move-exception v0

    .line 111
    .local v0, ex:Landroid/os/RemoteException;
    const-string v1, "BulkCursor"

    const-string v2, "Remote process exception when deactivating"

    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_c
.end method

.method public getColumnNames()[Ljava/lang/String;
    .registers 2

    .prologue
    .line 159
    invoke-direct {p0}, Landroid/database/BulkCursorToCursorAdaptor;->throwIfCursorIsClosed()V

    .line 161
    iget-object v0, p0, Landroid/database/BulkCursorToCursorAdaptor;->mColumns:[Ljava/lang/String;

    return-object v0
.end method

.method public getCount()I
    .registers 2

    .prologue
    .line 70
    invoke-direct {p0}, Landroid/database/BulkCursorToCursorAdaptor;->throwIfCursorIsClosed()V

    .line 71
    iget v0, p0, Landroid/database/BulkCursorToCursorAdaptor;->mCount:I

    return v0
.end method

.method public getExtras()Landroid/os/Bundle;
    .registers 3

    .prologue
    .line 166
    invoke-direct {p0}, Landroid/database/BulkCursorToCursorAdaptor;->throwIfCursorIsClosed()V

    .line 169
    :try_start_3
    iget-object v1, p0, Landroid/database/BulkCursorToCursorAdaptor;->mBulkCursor:Landroid/database/IBulkCursor;

    invoke-interface {v1}, Landroid/database/IBulkCursor;->getExtras()Landroid/os/Bundle;
    :try_end_8
    .catch Landroid/os/RemoteException; {:try_start_3 .. :try_end_8} :catch_a

    move-result-object v1

    return-object v1

    .line 170
    :catch_a
    move-exception v0

    .line 173
    .local v0, e:Landroid/os/RemoteException;
    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public getObserver()Landroid/database/IContentObserver;
    .registers 2

    .prologue
    .line 59
    iget-object v0, p0, Landroid/database/BulkCursorToCursorAdaptor;->mObserverBridge:Landroid/database/AbstractCursor$SelfContentObserver;

    invoke-virtual {v0}, Landroid/database/AbstractCursor$SelfContentObserver;->getContentObserver()Landroid/database/IContentObserver;

    move-result-object v0

    return-object v0
.end method

.method public initialize(Landroid/database/BulkCursorDescriptor;)V
    .registers 3
    .parameter "d"

    .prologue
    .line 42
    iget-object v0, p1, Landroid/database/BulkCursorDescriptor;->cursor:Landroid/database/IBulkCursor;

    iput-object v0, p0, Landroid/database/BulkCursorToCursorAdaptor;->mBulkCursor:Landroid/database/IBulkCursor;

    .line 43
    iget-object v0, p1, Landroid/database/BulkCursorDescriptor;->columnNames:[Ljava/lang/String;

    iput-object v0, p0, Landroid/database/BulkCursorToCursorAdaptor;->mColumns:[Ljava/lang/String;

    .line 44
    iget-object v0, p0, Landroid/database/BulkCursorToCursorAdaptor;->mColumns:[Ljava/lang/String;

    invoke-static {v0}, Landroid/database/DatabaseUtils;->findRowIdColumnIndex([Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Landroid/database/AbstractCursor;->mRowIdColumnIndex:I

    .line 45
    iget-boolean v0, p1, Landroid/database/BulkCursorDescriptor;->wantsAllOnMoveCalls:Z

    iput-boolean v0, p0, Landroid/database/BulkCursorToCursorAdaptor;->mWantsAllOnMoveCalls:Z

    .line 46
    iget v0, p1, Landroid/database/BulkCursorDescriptor;->count:I

    iput v0, p0, Landroid/database/BulkCursorToCursorAdaptor;->mCount:I

    .line 47
    iget-object v0, p1, Landroid/database/BulkCursorDescriptor;->window:Landroid/database/CursorWindow;

    if-eqz v0, :cond_21

    .line 48
    iget-object v0, p1, Landroid/database/BulkCursorDescriptor;->window:Landroid/database/CursorWindow;

    invoke-virtual {p0, v0}, Landroid/database/BulkCursorToCursorAdaptor;->setWindow(Landroid/database/CursorWindow;)V

    .line 50
    :cond_21
    return-void
.end method

.method public onMove(II)Z
    .registers 7
    .parameter "oldPosition"
    .parameter "newPosition"

    .prologue
    const/4 v1, 0x0

    .line 76
    invoke-direct {p0}, Landroid/database/BulkCursorToCursorAdaptor;->throwIfCursorIsClosed()V

    .line 80
    :try_start_4
    iget-object v2, p0, Landroid/database/AbstractWindowedCursor;->mWindow:Landroid/database/CursorWindow;

    if-eqz v2, :cond_1f

    iget-object v2, p0, Landroid/database/AbstractWindowedCursor;->mWindow:Landroid/database/CursorWindow;

    invoke-virtual {v2}, Landroid/database/CursorWindow;->getStartPosition()I

    move-result v2

    if-lt p2, v2, :cond_1f

    iget-object v2, p0, Landroid/database/AbstractWindowedCursor;->mWindow:Landroid/database/CursorWindow;

    invoke-virtual {v2}, Landroid/database/CursorWindow;->getStartPosition()I

    move-result v2

    iget-object v3, p0, Landroid/database/AbstractWindowedCursor;->mWindow:Landroid/database/CursorWindow;

    invoke-virtual {v3}, Landroid/database/CursorWindow;->getNumRows()I

    move-result v3

    add-int/2addr v2, v3

    if-lt p2, v2, :cond_2d

    .line 83
    :cond_1f
    iget-object v2, p0, Landroid/database/BulkCursorToCursorAdaptor;->mBulkCursor:Landroid/database/IBulkCursor;

    invoke-interface {v2, p2}, Landroid/database/IBulkCursor;->getWindow(I)Landroid/database/CursorWindow;

    move-result-object v2

    invoke-virtual {p0, v2}, Landroid/database/BulkCursorToCursorAdaptor;->setWindow(Landroid/database/CursorWindow;)V
    :try_end_28
    .catch Landroid/os/RemoteException; {:try_start_4 .. :try_end_28} :catch_37

    .line 94
    :cond_28
    :goto_28
    iget-object v2, p0, Landroid/database/AbstractWindowedCursor;->mWindow:Landroid/database/CursorWindow;

    if-nez v2, :cond_40

    .line 98
    :goto_2c
    return v1

    .line 84
    :cond_2d
    :try_start_2d
    iget-boolean v2, p0, Landroid/database/BulkCursorToCursorAdaptor;->mWantsAllOnMoveCalls:Z

    if-eqz v2, :cond_28

    .line 85
    iget-object v2, p0, Landroid/database/BulkCursorToCursorAdaptor;->mBulkCursor:Landroid/database/IBulkCursor;

    invoke-interface {v2, p2}, Landroid/database/IBulkCursor;->onMove(I)V
    :try_end_36
    .catch Landroid/os/RemoteException; {:try_start_2d .. :try_end_36} :catch_37

    goto :goto_28

    .line 87
    :catch_37
    move-exception v0

    .line 89
    .local v0, ex:Landroid/os/RemoteException;
    const-string v2, "BulkCursor"

    const-string v3, "Unable to get window because the remote process is dead"

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_2c

    .line 98
    .end local v0           #ex:Landroid/os/RemoteException;
    :cond_40
    const/4 v1, 0x1

    goto :goto_2c
.end method

.method public requery()Z
    .registers 6

    .prologue
    const/4 v1, 0x0

    const/4 v4, -0x1

    .line 133
    invoke-direct {p0}, Landroid/database/BulkCursorToCursorAdaptor;->throwIfCursorIsClosed()V

    .line 136
    :try_start_5
    iget-object v2, p0, Landroid/database/BulkCursorToCursorAdaptor;->mBulkCursor:Landroid/database/IBulkCursor;

    invoke-virtual {p0}, Landroid/database/BulkCursorToCursorAdaptor;->getObserver()Landroid/database/IContentObserver;

    move-result-object v3

    invoke-interface {v2, v3}, Landroid/database/IBulkCursor;->requery(Landroid/database/IContentObserver;)I

    move-result v2

    iput v2, p0, Landroid/database/BulkCursorToCursorAdaptor;->mCount:I

    .line 137
    iget v2, p0, Landroid/database/BulkCursorToCursorAdaptor;->mCount:I

    if-eq v2, v4, :cond_20

    .line 138
    const/4 v2, -0x1

    iput v2, p0, Landroid/database/AbstractCursor;->mPos:I

    .line 139
    invoke-virtual {p0}, Landroid/database/BulkCursorToCursorAdaptor;->closeWindow()V

    .line 144
    invoke-super {p0}, Landroid/database/AbstractWindowedCursor;->requery()Z

    .line 145
    const/4 v1, 0x1

    .line 153
    :goto_1f
    return v1

    .line 147
    :cond_20
    invoke-virtual {p0}, Landroid/database/BulkCursorToCursorAdaptor;->deactivate()V
    :try_end_23
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_23} :catch_24

    goto :goto_1f

    .line 150
    :catch_24
    move-exception v0

    .line 151
    .local v0, ex:Ljava/lang/Exception;
    const-string v2, "BulkCursor"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unable to requery because the remote process exception "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 152
    invoke-virtual {p0}, Landroid/database/BulkCursorToCursorAdaptor;->deactivate()V

    goto :goto_1f
.end method

.method public respond(Landroid/os/Bundle;)Landroid/os/Bundle;
    .registers 5
    .parameter "extras"

    .prologue
    .line 179
    invoke-direct {p0}, Landroid/database/BulkCursorToCursorAdaptor;->throwIfCursorIsClosed()V

    .line 182
    :try_start_3
    iget-object v1, p0, Landroid/database/BulkCursorToCursorAdaptor;->mBulkCursor:Landroid/database/IBulkCursor;

    invoke-interface {v1, p1}, Landroid/database/IBulkCursor;->respond(Landroid/os/Bundle;)Landroid/os/Bundle;
    :try_end_8
    .catch Landroid/os/RemoteException; {:try_start_3 .. :try_end_8} :catch_a

    move-result-object v1

    .line 188
    :goto_9
    return-object v1

    .line 183
    :catch_a
    move-exception v0

    .line 187
    .local v0, e:Landroid/os/RemoteException;
    const-string v1, "BulkCursor"

    const-string/jumbo v2, "respond() threw RemoteException, returning an empty bundle."

    invoke-static {v1, v2, v0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 188
    sget-object v1, Landroid/os/Bundle;->EMPTY:Landroid/os/Bundle;

    goto :goto_9
.end method
