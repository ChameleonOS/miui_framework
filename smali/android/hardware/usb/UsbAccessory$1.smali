.class final Landroid/hardware/usb/UsbAccessory$1;
.super Ljava/lang/Object;
.source "UsbAccessory.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/hardware/usb/UsbAccessory;
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
        "Landroid/hardware/usb/UsbAccessory;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 196
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Landroid/hardware/usb/UsbAccessory;
    .registers 9
    .parameter "in"

    .prologue
    .line 198
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    .line 199
    .local v1, manufacturer:Ljava/lang/String;
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v2

    .line 200
    .local v2, model:Ljava/lang/String;
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    .line 201
    .local v3, description:Ljava/lang/String;
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v4

    .line 202
    .local v4, version:Ljava/lang/String;
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v5

    .line 203
    .local v5, uri:Ljava/lang/String;
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v6

    .line 204
    .local v6, serial:Ljava/lang/String;
    new-instance v0, Landroid/hardware/usb/UsbAccessory;

    invoke-direct/range {v0 .. v6}, Landroid/hardware/usb/UsbAccessory;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 196
    invoke-virtual {p0, p1}, Landroid/hardware/usb/UsbAccessory$1;->createFromParcel(Landroid/os/Parcel;)Landroid/hardware/usb/UsbAccessory;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Landroid/hardware/usb/UsbAccessory;
    .registers 3
    .parameter "size"

    .prologue
    .line 208
    new-array v0, p1, [Landroid/hardware/usb/UsbAccessory;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 196
    invoke-virtual {p0, p1}, Landroid/hardware/usb/UsbAccessory$1;->newArray(I)[Landroid/hardware/usb/UsbAccessory;

    move-result-object v0

    return-object v0
.end method
