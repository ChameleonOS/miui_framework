.class final Landroid/accounts/Account$1;
.super Ljava/lang/Object;
.source "Account.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/accounts/Account;
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
        "Landroid/accounts/Account;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 71
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Landroid/accounts/Account;
    .registers 3
    .parameter "source"

    .prologue
    .line 73
    new-instance v0, Landroid/accounts/Account;

    invoke-direct {v0, p1}, Landroid/accounts/Account;-><init>(Landroid/os/Parcel;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 71
    invoke-virtual {p0, p1}, Landroid/accounts/Account$1;->createFromParcel(Landroid/os/Parcel;)Landroid/accounts/Account;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Landroid/accounts/Account;
    .registers 3
    .parameter "size"

    .prologue
    .line 77
    new-array v0, p1, [Landroid/accounts/Account;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 71
    invoke-virtual {p0, p1}, Landroid/accounts/Account$1;->newArray(I)[Landroid/accounts/Account;

    move-result-object v0

    return-object v0
.end method
