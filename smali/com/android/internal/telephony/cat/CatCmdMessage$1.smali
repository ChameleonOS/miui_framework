.class final Lcom/android/internal/telephony/cat/CatCmdMessage$1;
.super Ljava/lang/Object;
.source "CatCmdMessage.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/telephony/cat/CatCmdMessage;
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
        "Lcom/android/internal/telephony/cat/CatCmdMessage;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 140
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Lcom/android/internal/telephony/cat/CatCmdMessage;
    .registers 3
    .parameter "in"

    .prologue
    .line 142
    new-instance v0, Lcom/android/internal/telephony/cat/CatCmdMessage;

    invoke-direct {v0, p1}, Lcom/android/internal/telephony/cat/CatCmdMessage;-><init>(Landroid/os/Parcel;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 140
    invoke-virtual {p0, p1}, Lcom/android/internal/telephony/cat/CatCmdMessage$1;->createFromParcel(Landroid/os/Parcel;)Lcom/android/internal/telephony/cat/CatCmdMessage;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Lcom/android/internal/telephony/cat/CatCmdMessage;
    .registers 3
    .parameter "size"

    .prologue
    .line 146
    new-array v0, p1, [Lcom/android/internal/telephony/cat/CatCmdMessage;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 140
    invoke-virtual {p0, p1}, Lcom/android/internal/telephony/cat/CatCmdMessage$1;->newArray(I)[Lcom/android/internal/telephony/cat/CatCmdMessage;

    move-result-object v0

    return-object v0
.end method
