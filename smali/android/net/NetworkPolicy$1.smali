.class final Landroid/net/NetworkPolicy$1;
.super Ljava/lang/Object;
.source "NetworkPolicy.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/net/NetworkPolicy;
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
        "Landroid/net/NetworkPolicy;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 183
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Landroid/net/NetworkPolicy;
    .registers 3
    .parameter "in"

    .prologue
    .line 186
    new-instance v0, Landroid/net/NetworkPolicy;

    invoke-direct {v0, p1}, Landroid/net/NetworkPolicy;-><init>(Landroid/os/Parcel;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 183
    invoke-virtual {p0, p1}, Landroid/net/NetworkPolicy$1;->createFromParcel(Landroid/os/Parcel;)Landroid/net/NetworkPolicy;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Landroid/net/NetworkPolicy;
    .registers 3
    .parameter "size"

    .prologue
    .line 191
    new-array v0, p1, [Landroid/net/NetworkPolicy;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 183
    invoke-virtual {p0, p1}, Landroid/net/NetworkPolicy$1;->newArray(I)[Landroid/net/NetworkPolicy;

    move-result-object v0

    return-object v0
.end method
