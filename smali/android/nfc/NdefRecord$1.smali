.class final Landroid/nfc/NdefRecord$1;
.super Ljava/lang/Object;
.source "NdefRecord.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/nfc/NdefRecord;
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
        "Landroid/nfc/NdefRecord;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 949
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Landroid/nfc/NdefRecord;
    .registers 10
    .parameter "in"

    .prologue
    .line 952
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v7

    int-to-short v4, v7

    .line 953
    .local v4, tnf:S
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v6

    .line 954
    .local v6, typeLength:I
    new-array v5, v6, [B

    .line 955
    .local v5, type:[B
    invoke-virtual {p1, v5}, Landroid/os/Parcel;->readByteArray([B)V

    .line 956
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .line 957
    .local v1, idLength:I
    new-array v0, v1, [B

    .line 958
    .local v0, id:[B
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->readByteArray([B)V

    .line 959
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v3

    .line 960
    .local v3, payloadLength:I
    new-array v2, v3, [B

    .line 961
    .local v2, payload:[B
    invoke-virtual {p1, v2}, Landroid/os/Parcel;->readByteArray([B)V

    .line 963
    new-instance v7, Landroid/nfc/NdefRecord;

    invoke-direct {v7, v4, v5, v0, v2}, Landroid/nfc/NdefRecord;-><init>(S[B[B[B)V

    return-object v7
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 949
    invoke-virtual {p0, p1}, Landroid/nfc/NdefRecord$1;->createFromParcel(Landroid/os/Parcel;)Landroid/nfc/NdefRecord;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Landroid/nfc/NdefRecord;
    .registers 3
    .parameter "size"

    .prologue
    .line 967
    new-array v0, p1, [Landroid/nfc/NdefRecord;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 949
    invoke-virtual {p0, p1}, Landroid/nfc/NdefRecord$1;->newArray(I)[Landroid/nfc/NdefRecord;

    move-result-object v0

    return-object v0
.end method
