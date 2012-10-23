.class final Landroid/accounts/AccountManagerResponse$1;
.super Ljava/lang/Object;
.source "AccountManagerResponse.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/accounts/AccountManagerResponse;
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
        "Landroid/accounts/AccountManagerResponse;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 70
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Landroid/accounts/AccountManagerResponse;
    .registers 3
    .parameter "source"

    .prologue
    .line 72
    new-instance v0, Landroid/accounts/AccountManagerResponse;

    invoke-direct {v0, p1}, Landroid/accounts/AccountManagerResponse;-><init>(Landroid/os/Parcel;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 70
    invoke-virtual {p0, p1}, Landroid/accounts/AccountManagerResponse$1;->createFromParcel(Landroid/os/Parcel;)Landroid/accounts/AccountManagerResponse;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Landroid/accounts/AccountManagerResponse;
    .registers 3
    .parameter "size"

    .prologue
    .line 76
    new-array v0, p1, [Landroid/accounts/AccountManagerResponse;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 70
    invoke-virtual {p0, p1}, Landroid/accounts/AccountManagerResponse$1;->newArray(I)[Landroid/accounts/AccountManagerResponse;

    move-result-object v0

    return-object v0
.end method
