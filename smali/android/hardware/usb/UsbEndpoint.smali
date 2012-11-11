.class public Landroid/hardware/usb/UsbEndpoint;
.super Ljava/lang/Object;
.source "UsbEndpoint.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Landroid/hardware/usb/UsbEndpoint;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final mAddress:I

.field private final mAttributes:I

.field private final mInterval:I

.field private final mMaxPacketSize:I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    new-instance v0, Landroid/hardware/usb/UsbEndpoint$1;

    invoke-direct {v0}, Landroid/hardware/usb/UsbEndpoint$1;-><init>()V

    sput-object v0, Landroid/hardware/usb/UsbEndpoint;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(IIII)V
    .registers 5
    .parameter "address"
    .parameter "attributes"
    .parameter "maxPacketSize"
    .parameter "interval"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Landroid/hardware/usb/UsbEndpoint;->mAddress:I

    iput p2, p0, Landroid/hardware/usb/UsbEndpoint;->mAttributes:I

    iput p3, p0, Landroid/hardware/usb/UsbEndpoint;->mMaxPacketSize:I

    iput p4, p0, Landroid/hardware/usb/UsbEndpoint;->mInterval:I

    return-void
.end method


# virtual methods
.method public describeContents()I
    .registers 2

    .prologue
    const/4 v0, 0x0

    return v0
.end method

.method public getAddress()I
    .registers 2

    .prologue
    iget v0, p0, Landroid/hardware/usb/UsbEndpoint;->mAddress:I

    return v0
.end method

.method public getAttributes()I
    .registers 2

    .prologue
    iget v0, p0, Landroid/hardware/usb/UsbEndpoint;->mAttributes:I

    return v0
.end method

.method public getDirection()I
    .registers 2

    .prologue
    iget v0, p0, Landroid/hardware/usb/UsbEndpoint;->mAddress:I

    and-int/lit16 v0, v0, 0x80

    return v0
.end method

.method public getEndpointNumber()I
    .registers 2

    .prologue
    iget v0, p0, Landroid/hardware/usb/UsbEndpoint;->mAddress:I

    and-int/lit8 v0, v0, 0xf

    return v0
.end method

.method public getInterval()I
    .registers 2

    .prologue
    iget v0, p0, Landroid/hardware/usb/UsbEndpoint;->mInterval:I

    return v0
.end method

.method public getMaxPacketSize()I
    .registers 2

    .prologue
    iget v0, p0, Landroid/hardware/usb/UsbEndpoint;->mMaxPacketSize:I

    return v0
.end method

.method public getType()I
    .registers 2

    .prologue
    iget v0, p0, Landroid/hardware/usb/UsbEndpoint;->mAttributes:I

    and-int/lit8 v0, v0, 0x3

    return v0
.end method

.method public toString()Ljava/lang/String;
    .registers 3

    .prologue
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "UsbEndpoint[mAddress="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Landroid/hardware/usb/UsbEndpoint;->mAddress:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ",mAttributes="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Landroid/hardware/usb/UsbEndpoint;->mAttributes:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ",mMaxPacketSize="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Landroid/hardware/usb/UsbEndpoint;->mMaxPacketSize:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ",mInterval="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Landroid/hardware/usb/UsbEndpoint;->mInterval:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 4
    .parameter "parcel"
    .parameter "flags"

    .prologue
    iget v0, p0, Landroid/hardware/usb/UsbEndpoint;->mAddress:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p0, Landroid/hardware/usb/UsbEndpoint;->mAttributes:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p0, Landroid/hardware/usb/UsbEndpoint;->mMaxPacketSize:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p0, Landroid/hardware/usb/UsbEndpoint;->mInterval:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    return-void
.end method
