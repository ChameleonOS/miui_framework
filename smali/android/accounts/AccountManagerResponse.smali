.class public Landroid/accounts/AccountManagerResponse;
.super Ljava/lang/Object;
.source "AccountManagerResponse.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Landroid/accounts/AccountManagerResponse;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private mResponse:Landroid/accounts/IAccountManagerResponse;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    new-instance v0, Landroid/accounts/AccountManagerResponse$1;

    invoke-direct {v0}, Landroid/accounts/AccountManagerResponse$1;-><init>()V

    sput-object v0, Landroid/accounts/AccountManagerResponse;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(Landroid/accounts/IAccountManagerResponse;)V
    .registers 2
    .parameter "response"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroid/accounts/AccountManagerResponse;->mResponse:Landroid/accounts/IAccountManagerResponse;

    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .registers 3
    .parameter "parcel"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    invoke-virtual {p1}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v0

    invoke-static {v0}, Landroid/accounts/IAccountManagerResponse$Stub;->asInterface(Landroid/os/IBinder;)Landroid/accounts/IAccountManagerResponse;

    move-result-object v0

    iput-object v0, p0, Landroid/accounts/AccountManagerResponse;->mResponse:Landroid/accounts/IAccountManagerResponse;

    return-void
.end method


# virtual methods
.method public describeContents()I
    .registers 2

    .prologue
    const/4 v0, 0x0

    return v0
.end method

.method public onError(ILjava/lang/String;)V
    .registers 4
    .parameter "errorCode"
    .parameter "errorMessage"

    .prologue
    :try_start_0
    iget-object v0, p0, Landroid/accounts/AccountManagerResponse;->mResponse:Landroid/accounts/IAccountManagerResponse;

    invoke-interface {v0, p1, p2}, Landroid/accounts/IAccountManagerResponse;->onError(ILjava/lang/String;)V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    :goto_5
    return-void

    :catch_6
    move-exception v0

    goto :goto_5
.end method

.method public onResult(Landroid/os/Bundle;)V
    .registers 3
    .parameter "result"

    .prologue
    :try_start_0
    iget-object v0, p0, Landroid/accounts/AccountManagerResponse;->mResponse:Landroid/accounts/IAccountManagerResponse;

    invoke-interface {v0, p1}, Landroid/accounts/IAccountManagerResponse;->onResult(Landroid/os/Bundle;)V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_5} :catch_6

    :goto_5
    return-void

    :catch_6
    move-exception v0

    goto :goto_5
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 4
    .parameter "dest"
    .parameter "flags"

    .prologue
    iget-object v0, p0, Landroid/accounts/AccountManagerResponse;->mResponse:Landroid/accounts/IAccountManagerResponse;

    invoke-interface {v0}, Landroid/accounts/IAccountManagerResponse;->asBinder()Landroid/os/IBinder;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeStrongBinder(Landroid/os/IBinder;)V

    return-void
.end method
