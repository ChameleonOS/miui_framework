.class final Lcom/android/internal/telephony/cat/Duration$1;
.super Ljava/lang/Object;
.source "Duration.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/telephony/cat/Duration;
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
        "Lcom/android/internal/telephony/cat/Duration;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Lcom/android/internal/telephony/cat/Duration;
    .registers 4
    .parameter "in"

    .prologue
    new-instance v0, Lcom/android/internal/telephony/cat/Duration;

    const/4 v1, 0x0

    invoke-direct {v0, p1, v1}, Lcom/android/internal/telephony/cat/Duration;-><init>(Landroid/os/Parcel;Lcom/android/internal/telephony/cat/Duration$1;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    invoke-virtual {p0, p1}, Lcom/android/internal/telephony/cat/Duration$1;->createFromParcel(Landroid/os/Parcel;)Lcom/android/internal/telephony/cat/Duration;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Lcom/android/internal/telephony/cat/Duration;
    .registers 3
    .parameter "size"

    .prologue
    new-array v0, p1, [Lcom/android/internal/telephony/cat/Duration;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    invoke-virtual {p0, p1}, Lcom/android/internal/telephony/cat/Duration$1;->newArray(I)[Lcom/android/internal/telephony/cat/Duration;

    move-result-object v0

    return-object v0
.end method
