.class final Lcom/android/internal/telephony/cat/Input$1;
.super Ljava/lang/Object;
.source "Input.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/telephony/cat/Input;
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
        "Lcom/android/internal/telephony/cat/Input;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 90
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Lcom/android/internal/telephony/cat/Input;
    .registers 4
    .parameter "in"

    .prologue
    .line 92
    new-instance v0, Lcom/android/internal/telephony/cat/Input;

    const/4 v1, 0x0

    invoke-direct {v0, p1, v1}, Lcom/android/internal/telephony/cat/Input;-><init>(Landroid/os/Parcel;Lcom/android/internal/telephony/cat/Input$1;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 90
    invoke-virtual {p0, p1}, Lcom/android/internal/telephony/cat/Input$1;->createFromParcel(Landroid/os/Parcel;)Lcom/android/internal/telephony/cat/Input;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Lcom/android/internal/telephony/cat/Input;
    .registers 3
    .parameter "size"

    .prologue
    .line 96
    new-array v0, p1, [Lcom/android/internal/telephony/cat/Input;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 90
    invoke-virtual {p0, p1}, Lcom/android/internal/telephony/cat/Input$1;->newArray(I)[Lcom/android/internal/telephony/cat/Input;

    move-result-object v0

    return-object v0
.end method
