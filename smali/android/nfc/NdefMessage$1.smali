.class final Landroid/nfc/NdefMessage$1;
.super Ljava/lang/Object;
.source "NdefMessage.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/nfc/NdefMessage;
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
        "Landroid/nfc/NdefMessage;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 217
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Landroid/nfc/NdefMessage;
    .registers 5
    .parameter "in"

    .prologue
    .line 220
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .line 221
    .local v1, recordsLength:I
    new-array v0, v1, [Landroid/nfc/NdefRecord;

    .line 222
    .local v0, records:[Landroid/nfc/NdefRecord;
    sget-object v2, Landroid/nfc/NdefRecord;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-virtual {p1, v0, v2}, Landroid/os/Parcel;->readTypedArray([Ljava/lang/Object;Landroid/os/Parcelable$Creator;)V

    .line 223
    new-instance v2, Landroid/nfc/NdefMessage;

    invoke-direct {v2, v0}, Landroid/nfc/NdefMessage;-><init>([Landroid/nfc/NdefRecord;)V

    return-object v2
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 217
    invoke-virtual {p0, p1}, Landroid/nfc/NdefMessage$1;->createFromParcel(Landroid/os/Parcel;)Landroid/nfc/NdefMessage;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Landroid/nfc/NdefMessage;
    .registers 3
    .parameter "size"

    .prologue
    .line 227
    new-array v0, p1, [Landroid/nfc/NdefMessage;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 217
    invoke-virtual {p0, p1}, Landroid/nfc/NdefMessage$1;->newArray(I)[Landroid/nfc/NdefMessage;

    move-result-object v0

    return-object v0
.end method
