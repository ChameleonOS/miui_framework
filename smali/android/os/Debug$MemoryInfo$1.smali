.class final Landroid/os/Debug$MemoryInfo$1;
.super Ljava/lang/Object;
.source "Debug.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/os/Debug$MemoryInfo;
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
        "Landroid/os/Debug$MemoryInfo;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 223
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Landroid/os/Debug$MemoryInfo;
    .registers 4
    .parameter "source"

    .prologue
    .line 225
    new-instance v0, Landroid/os/Debug$MemoryInfo;

    const/4 v1, 0x0

    invoke-direct {v0, p1, v1}, Landroid/os/Debug$MemoryInfo;-><init>(Landroid/os/Parcel;Landroid/os/Debug$1;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 223
    invoke-virtual {p0, p1}, Landroid/os/Debug$MemoryInfo$1;->createFromParcel(Landroid/os/Parcel;)Landroid/os/Debug$MemoryInfo;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Landroid/os/Debug$MemoryInfo;
    .registers 3
    .parameter "size"

    .prologue
    .line 228
    new-array v0, p1, [Landroid/os/Debug$MemoryInfo;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 223
    invoke-virtual {p0, p1}, Landroid/os/Debug$MemoryInfo$1;->newArray(I)[Landroid/os/Debug$MemoryInfo;

    move-result-object v0

    return-object v0
.end method
