.class Landroid/app/IWallpaperManagerCallback$Stub$Proxy;
.super Ljava/lang/Object;
.source "IWallpaperManagerCallback.java"

# interfaces
.implements Landroid/app/IWallpaperManagerCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/app/IWallpaperManagerCallback$Stub;
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
    .line 65
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 66
    iput-object p1, p0, Landroid/app/IWallpaperManagerCallback$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    .line 67
    return-void
.end method


# virtual methods
.method public asBinder()Landroid/os/IBinder;
    .registers 2

    .prologue
    .line 70
    iget-object v0, p0, Landroid/app/IWallpaperManagerCallback$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    return-object v0
.end method

.method public getInterfaceDescriptor()Ljava/lang/String;
    .registers 2

    .prologue
    .line 74
    const-string v0, "android.app.IWallpaperManagerCallback"

    return-object v0
.end method

.method public onWallpaperChanged()V
    .registers 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 81
    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v0

    .line 83
    .local v0, _data:Landroid/os/Parcel;
    :try_start_4
    const-string v1, "android.app.IWallpaperManagerCallback"

    invoke-virtual {v0, v1}, Landroid/os/Parcel;->writeInterfaceToken(Ljava/lang/String;)V

    .line 84
    iget-object v1, p0, Landroid/app/IWallpaperManagerCallback$Stub$Proxy;->mRemote:Landroid/os/IBinder;

    const/4 v2, 0x1

    const/4 v3, 0x0

    const/4 v4, 0x1

    invoke-interface {v1, v2, v0, v3, v4}, Landroid/os/IBinder;->transact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    :try_end_11
    .catchall {:try_start_4 .. :try_end_11} :catchall_15

    .line 87
    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    .line 89
    return-void

    .line 87
    :catchall_15
    move-exception v1

    invoke-virtual {v0}, Landroid/os/Parcel;->recycle()V

    throw v1
.end method
