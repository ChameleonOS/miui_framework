.class final Landroid/os/Messenger$1;
.super Ljava/lang/Object;
.source "Messenger.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/os/Messenger;
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
        "Landroid/os/Messenger;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 92
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Landroid/os/Messenger;
    .registers 4
    .parameter "in"

    .prologue
    .line 94
    invoke-virtual {p1}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v0

    .line 95
    .local v0, target:Landroid/os/IBinder;
    if-eqz v0, :cond_c

    new-instance v1, Landroid/os/Messenger;

    invoke-direct {v1, v0}, Landroid/os/Messenger;-><init>(Landroid/os/IBinder;)V

    :goto_b
    return-object v1

    :cond_c
    const/4 v1, 0x0

    goto :goto_b
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 92
    invoke-virtual {p0, p1}, Landroid/os/Messenger$1;->createFromParcel(Landroid/os/Parcel;)Landroid/os/Messenger;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Landroid/os/Messenger;
    .registers 3
    .parameter "size"

    .prologue
    .line 99
    new-array v0, p1, [Landroid/os/Messenger;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 92
    invoke-virtual {p0, p1}, Landroid/os/Messenger$1;->newArray(I)[Landroid/os/Messenger;

    move-result-object v0

    return-object v0
.end method
