.class final Landroid/os/RemoteCallback$1;
.super Ljava/lang/Object;
.source "RemoteCallback.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/os/RemoteCallback;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/os/Parcelable$Creator",
        "<",
        "Landroid/os/RemoteCallback;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 96
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Landroid/os/RemoteCallback;
    .registers 5
    .parameter "in"

    .prologue
    .line 98
    invoke-virtual {p1}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v0

    .line 99
    .local v0, target:Landroid/os/IBinder;
    if-eqz v0, :cond_10

    new-instance v1, Landroid/os/RemoteCallback$RemoteCallbackProxy;

    invoke-static {v0}, Landroid/os/IRemoteCallback$Stub;->asInterface(Landroid/os/IBinder;)Landroid/os/IRemoteCallback;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/os/RemoteCallback$RemoteCallbackProxy;-><init>(Landroid/os/IRemoteCallback;)V

    :goto_f
    return-object v1

    :cond_10
    const/4 v1, 0x0

    goto :goto_f
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 96
    invoke-virtual {p0, p1}, Landroid/os/RemoteCallback$1;->createFromParcel(Landroid/os/Parcel;)Landroid/os/RemoteCallback;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Landroid/os/RemoteCallback;
    .registers 3
    .parameter "size"

    .prologue
    .line 104
    new-array v0, p1, [Landroid/os/RemoteCallback;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 96
    invoke-virtual {p0, p1}, Landroid/os/RemoteCallback$1;->newArray(I)[Landroid/os/RemoteCallback;

    move-result-object v0

    return-object v0
.end method
