.class final Landroid/telephony/SmsCbEtwsInfo$1;
.super Ljava/lang/Object;
.source "SmsCbEtwsInfo.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/telephony/SmsCbEtwsInfo;
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
        "Landroid/telephony/SmsCbEtwsInfo;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 197
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Landroid/telephony/SmsCbEtwsInfo;
    .registers 3
    .parameter "in"

    .prologue
    .line 199
    new-instance v0, Landroid/telephony/SmsCbEtwsInfo;

    invoke-direct {v0, p1}, Landroid/telephony/SmsCbEtwsInfo;-><init>(Landroid/os/Parcel;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 197
    invoke-virtual {p0, p1}, Landroid/telephony/SmsCbEtwsInfo$1;->createFromParcel(Landroid/os/Parcel;)Landroid/telephony/SmsCbEtwsInfo;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Landroid/telephony/SmsCbEtwsInfo;
    .registers 3
    .parameter "size"

    .prologue
    .line 203
    new-array v0, p1, [Landroid/telephony/SmsCbEtwsInfo;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 197
    invoke-virtual {p0, p1}, Landroid/telephony/SmsCbEtwsInfo$1;->newArray(I)[Landroid/telephony/SmsCbEtwsInfo;

    move-result-object v0

    return-object v0
.end method
