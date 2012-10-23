.class Landroid/content/ISyncAdapter$Stub$Proxy;
.super Ljava/lang/Object;
.source "ISyncAdapter.java"

# interfaces
.implements Landroid/content/ISyncAdapter;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/content/ISyncAdapter$Stub;
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
    .line 103
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 104
    iput-object p1, p0, Landroid/content/ISyncAdapter$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    .line 105
    return-void
.end method


# virtual methods
.method public asBinder()Landroid/os/IBinder;
    .registers 2

    .prologue
    .line 108
    iget-object v0, p0, Landroid/content/ISyncAdapter$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    return-object v0
.end method

.method public cancelSync(Landroid/content/ISyncContext;)V
    .registers 7
    .parameter "syncContext"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 158
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v0

    .line 160
    .local v0, _data:Landroid/os/Parcel;
    :try_start_5
    const-string v2, "android.content.ISyncAdapter"

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInterfaceToken(Ljava/lang/String;)V

    .line 161
    if-eqz p1, :cond_10

    invoke-interface {p1}, Landroid/content/ISyncContext;->asBinder()Landroid/os/IBinder;

    move-result-object v1

    :cond_10
    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeStrongBinder(Landroid/os/IBinder;)V

    .line 162
    iget-object v1, p0, Landroid/content/ISyncAdapter$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    const/4 v2, 0x2

    const/4 v3, 0x0

    const/4 v4, 0x1

    invoke-interface {v1, v2, v0, v3, v4}, Landroid/os/IBinder;->transact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    :try_end_1b
    .catchall {:try_start_5 .. :try_end_1b} :catchall_1f

    .line 165
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 167
    return-void

    .line 165
    :catchall_1f
    move-exception v1

    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    throw v1
.end method

.method public getInterfaceDescriptor()Ljava/lang/String;
    .registers 2

    .prologue
    .line 112
    const-string v0, "android.content.ISyncAdapter"

    return-object v0
.end method

.method public initialize(Landroid/accounts/Account;Ljava/lang/String;)V
    .registers 8
    .parameter "account"
    .parameter "authority"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 176
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v0

    .line 178
    .local v0, _data:Landroid/os/Parcel;
    :try_start_4
    const-string v1, "android.content.ISyncAdapter"

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInterfaceToken(Ljava/lang/String;)V

    .line 179
    if-eqz p1, :cond_22

    .line 180
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 181
    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/accounts/Account;->writeToParcel(Landroid/os/Parcel;I)V

    .line 186
    :goto_13
    invoke-virtual {v0, p2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 187
    iget-object v1, p0, Landroid/content/ISyncAdapter$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    const/4 v2, 0x3

    const/4 v3, 0x0

    const/4 v4, 0x1

    invoke-interface {v1, v2, v0, v3, v4}, Landroid/os/IBinder;->transact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    :try_end_1e
    .catchall {:try_start_4 .. :try_end_1e} :catchall_27

    .line 190
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 192
    return-void

    .line 184
    :cond_22
    const/4 v1, 0x0

    :try_start_23
    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInt(I)V
    :try_end_26
    .catchall {:try_start_23 .. :try_end_26} :catchall_27

    goto :goto_13

    .line 190
    :catchall_27
    move-exception v1

    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    throw v1
.end method

.method public startSync(Landroid/content/ISyncContext;Ljava/lang/String;Landroid/accounts/Account;Landroid/os/Bundle;)V
    .registers 10
    .parameter "syncContext"
    .parameter "authority"
    .parameter "account"
    .parameter "extras"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 126
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v0

    .line 128
    .local v0, _data:Landroid/os/Parcel;
    :try_start_5
    const-string v2, "android.content.ISyncAdapter"

    invoke-virtual {v0, v2}, Landroid/os/Parcel;->writeInterfaceToken(Ljava/lang/String;)V

    .line 129
    if-eqz p1, :cond_10

    invoke-interface {p1}, Landroid/content/ISyncContext;->asBinder()Landroid/os/IBinder;

    move-result-object v1

    :cond_10
    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeStrongBinder(Landroid/os/IBinder;)V

    .line 130
    invoke-virtual {v0, p2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 131
    if-eqz p3, :cond_36

    .line 132
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 133
    const/4 v1, 0x0

    invoke-virtual {p3, v0, v1}, Landroid/accounts/Account;->writeToParcel(Landroid/os/Parcel;I)V

    .line 138
    :goto_20
    if-eqz p4, :cond_40

    .line 139
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 140
    const/4 v1, 0x0

    invoke-virtual {p4, v0, v1}, Landroid/os/Bundle;->writeToParcel(Landroid/os/Parcel;I)V

    .line 145
    :goto_2a
    iget-object v1, p0, Landroid/content/ISyncAdapter$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    const/4 v2, 0x1

    const/4 v3, 0x0

    const/4 v4, 0x1

    invoke-interface {v1, v2, v0, v3, v4}, Landroid/os/IBinder;->transact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    :try_end_32
    .catchall {:try_start_5 .. :try_end_32} :catchall_3b

    .line 148
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 150
    return-void

    .line 136
    :cond_36
    const/4 v1, 0x0

    :try_start_37
    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInt(I)V
    :try_end_3a
    .catchall {:try_start_37 .. :try_end_3a} :catchall_3b

    goto :goto_20

    .line 148
    :catchall_3b
    move-exception v1

    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    throw v1

    .line 143
    :cond_40
    const/4 v1, 0x0

    :try_start_41
    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInt(I)V
    :try_end_44
    .catchall {:try_start_41 .. :try_end_44} :catchall_3b

    goto :goto_2a
.end method
