.class final Landroid/os/ResultReceiver$1;
.super Ljava/lang/Object;
.source "ResultReceiver.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/os/ResultReceiver;
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
        "Landroid/os/ResultReceiver;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 122
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Landroid/os/ResultReceiver;
    .registers 3
    .parameter "in"

    .prologue
    .line 124
    new-instance v0, Landroid/os/ResultReceiver;

    invoke-direct {v0, p1}, Landroid/os/ResultReceiver;-><init>(Landroid/os/Parcel;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 122
    invoke-virtual {p0, p1}, Landroid/os/ResultReceiver$1;->createFromParcel(Landroid/os/Parcel;)Landroid/os/ResultReceiver;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Landroid/os/ResultReceiver;
    .registers 3
    .parameter "size"

    .prologue
    .line 127
    new-array v0, p1, [Landroid/os/ResultReceiver;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 122
    invoke-virtual {p0, p1}, Landroid/os/ResultReceiver$1;->newArray(I)[Landroid/os/ResultReceiver;

    move-result-object v0

    return-object v0
.end method
