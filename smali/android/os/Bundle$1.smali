.class final Landroid/os/Bundle$1;
.super Ljava/lang/Object;
.source "Bundle.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/os/Bundle;
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
        "Landroid/os/Bundle;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 1580
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Landroid/os/Bundle;
    .registers 3
    .parameter "in"

    .prologue
    .line 1582
    invoke-virtual {p1}, Landroid/os/Parcel;->readBundle()Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 1580
    invoke-virtual {p0, p1}, Landroid/os/Bundle$1;->createFromParcel(Landroid/os/Parcel;)Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Landroid/os/Bundle;
    .registers 3
    .parameter "size"

    .prologue
    .line 1586
    new-array v0, p1, [Landroid/os/Bundle;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 1580
    invoke-virtual {p0, p1}, Landroid/os/Bundle$1;->newArray(I)[Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method
