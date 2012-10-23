.class final Lcom/android/internal/telephony/cat/Tone$1;
.super Ljava/lang/Object;
.source "Tone.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/telephony/cat/Tone;
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
        "Lcom/android/internal/telephony/cat/Tone;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 181
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Lcom/android/internal/telephony/cat/Tone;
    .registers 4
    .parameter "in"

    .prologue
    .line 183
    invoke-static {}, Lcom/android/internal/telephony/cat/Tone;->values()[Lcom/android/internal/telephony/cat/Tone;

    move-result-object v0

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    aget-object v0, v0, v1

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 181
    invoke-virtual {p0, p1}, Lcom/android/internal/telephony/cat/Tone$1;->createFromParcel(Landroid/os/Parcel;)Lcom/android/internal/telephony/cat/Tone;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Lcom/android/internal/telephony/cat/Tone;
    .registers 3
    .parameter "size"

    .prologue
    .line 187
    new-array v0, p1, [Lcom/android/internal/telephony/cat/Tone;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 181
    invoke-virtual {p0, p1}, Lcom/android/internal/telephony/cat/Tone$1;->newArray(I)[Lcom/android/internal/telephony/cat/Tone;

    move-result-object v0

    return-object v0
.end method
