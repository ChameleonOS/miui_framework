.class Lcom/android/internal/os/IDropBoxManagerService$Stub$Proxy;
.super Ljava/lang/Object;
.source "IDropBoxManagerService.java"

# interfaces
.implements Lcom/android/internal/os/IDropBoxManagerService;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/os/IDropBoxManagerService$Stub;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "Proxy"
.end annotation


# instance fields
.field private mRemote:Landroid/os/IBinder;


# direct methods
.method constructor <init>(Landroid/os/IBinder;)V
    .registers 2
    .parameter "remote"

    .prologue
    .line 101
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 102
    iput-object p1, p0, Lcom/android/internal/os/IDropBoxManagerService$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    .line 103
    return-void
.end method


# virtual methods
.method public add(Landroid/os/DropBoxManager$Entry;)V
    .registers 7
    .parameter "entry"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 119
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v0

    .line 120
    .local v0, _data:Landroid/os/Parcel;
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v1

    .line 122
    .local v1, _reply:Landroid/os/Parcel;
    :try_start_8
    const-string v2, "com.android.internal.os.IDropBoxManagerService"

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInterfaceToken(Ljava/lang/String;)V

    .line 123
    if-eqz p1, :cond_28

    .line 124
    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInt(I)V

    .line 125
    const/4 v2, 0x0

    invoke-virtual {p1, v0, v2}, Landroid/os/DropBoxManager$Entry;->writeToParcel(Landroid/os/Parcel;I)V

    .line 130
    :goto_17
    iget-object v2, p0, Lcom/android/internal/os/IDropBoxManagerService$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    const/4 v3, 0x1

    const/4 v4, 0x0

    invoke-interface {v2, v3, v0, v1, v4}, Landroid/os/IBinder;->transact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    .line 131
    invoke-virtual {v1}, Landroid/os/Parcel;->readException()V
    :try_end_21
    .catchall {:try_start_8 .. :try_end_21} :catchall_2d

    .line 134
    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 135
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 137
    return-void

    .line 128
    :cond_28
    const/4 v2, 0x0

    :try_start_29
    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInt(I)V
    :try_end_2c
    .catchall {:try_start_29 .. :try_end_2c} :catchall_2d

    goto :goto_17

    .line 134
    :catchall_2d
    move-exception v2

    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 135
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    throw v2
.end method

.method public asBinder()Landroid/os/IBinder;
    .registers 2

    .prologue
    .line 106
    iget-object v0, p0, Lcom/android/internal/os/IDropBoxManagerService$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    return-object v0
.end method

.method public getInterfaceDescriptor()Ljava/lang/String;
    .registers 2

    .prologue
    .line 110
    const-string v0, "com.android.internal.os.IDropBoxManagerService"

    return-object v0
.end method

.method public getNextEntry(Ljava/lang/String;J)Landroid/os/DropBoxManager$Entry;
    .registers 10
    .parameter "tag"
    .parameter "millis"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 160
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v0

    .line 161
    .local v0, _data:Landroid/os/Parcel;
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v1

    .line 164
    .local v1, _reply:Landroid/os/Parcel;
    :try_start_8
    const-string v3, "com.android.internal.os.IDropBoxManagerService"

    invoke-virtual {v0, v3}, Landroid/os/Parcel;->writeInterfaceToken(Ljava/lang/String;)V

    .line 165
    invoke-virtual {v0, p1}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 166
    invoke-virtual {v0, p2, p3}, Landroid/os/Parcel;->writeLong(J)V

    .line 167
    iget-object v3, p0, Lcom/android/internal/os/IDropBoxManagerService$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    const/4 v4, 0x3

    const/4 v5, 0x0

    invoke-interface {v3, v4, v0, v1, v5}, Landroid/os/IBinder;->transact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    .line 168
    invoke-virtual {v1}, Landroid/os/Parcel;->readException()V

    .line 169
    invoke-virtual {v1}, Landroid/os/Parcel;->readInt()I

    move-result v3

    if-eqz v3, :cond_32

    .line 170
    sget-object v3, Landroid/os/DropBoxManager$Entry;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v3, v1}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/os/DropBoxManager$Entry;
    :try_end_2b
    .catchall {:try_start_8 .. :try_end_2b} :catchall_34

    .line 177
    .local v2, _result:Landroid/os/DropBoxManager$Entry;
    :goto_2b
    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 178
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 180
    return-object v2

    .line 173
    .end local v2           #_result:Landroid/os/DropBoxManager$Entry;
    :cond_32
    const/4 v2, 0x0

    .restart local v2       #_result:Landroid/os/DropBoxManager$Entry;
    goto :goto_2b

    .line 177
    .end local v2           #_result:Landroid/os/DropBoxManager$Entry;
    :catchall_34
    move-exception v3

    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 178
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    throw v3
.end method

.method public isTagEnabled(Ljava/lang/String;)Z
    .registers 8
    .parameter "tag"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 141
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v0

    .line 142
    .local v0, _data:Landroid/os/Parcel;
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v1

    .line 145
    .local v1, _reply:Landroid/os/Parcel;
    :try_start_9
    const-string v3, "com.android.internal.os.IDropBoxManagerService"

    invoke-virtual {v0, v3}, Landroid/os/Parcel;->writeInterfaceToken(Ljava/lang/String;)V

    .line 146
    invoke-virtual {v0, p1}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 147
    iget-object v3, p0, Lcom/android/internal/os/IDropBoxManagerService$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    const/4 v4, 0x2

    const/4 v5, 0x0

    invoke-interface {v3, v4, v0, v1, v5}, Landroid/os/IBinder;->transact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    .line 148
    invoke-virtual {v1}, Landroid/os/Parcel;->readException()V

    .line 149
    invoke-virtual {v1}, Landroid/os/Parcel;->readInt()I
    :try_end_1e
    .catchall {:try_start_9 .. :try_end_1e} :catchall_29

    move-result v3

    if-eqz v3, :cond_22

    const/4 v2, 0x1

    .line 152
    .local v2, _result:Z
    :cond_22
    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 153
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 155
    return v2

    .line 152
    .end local v2           #_result:Z
    :catchall_29
    move-exception v3

    invoke-virtual {v1}, Landroid/os/Parcel;->recycle()V

    .line 153
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    throw v3
.end method
