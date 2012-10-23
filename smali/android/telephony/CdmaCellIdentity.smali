.class public final Landroid/telephony/CdmaCellIdentity;
.super Landroid/telephony/CellIdentity;
.source "CdmaCellIdentity.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Landroid/telephony/CdmaCellIdentity;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final mBasestationId:I

.field private final mLatitude:I

.field private final mLongitude:I

.field private final mNetworkId:I

.field private final mSystemId:I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 152
    new-instance v0, Landroid/telephony/CdmaCellIdentity$1;

    invoke-direct {v0}, Landroid/telephony/CdmaCellIdentity$1;-><init>()V

    sput-object v0, Landroid/telephony/CdmaCellIdentity;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(IIIIILjava/lang/String;)V
    .registers 8
    .parameter "nid"
    .parameter "sid"
    .parameter "bid"
    .parameter "lon"
    .parameter "lat"
    .parameter "attr"

    .prologue
    .line 62
    const/4 v0, 0x2

    invoke-direct {p0, v0, p6}, Landroid/telephony/CellIdentity;-><init>(ILjava/lang/String;)V

    .line 63
    iput p1, p0, Landroid/telephony/CdmaCellIdentity;->mNetworkId:I

    .line 64
    iput p2, p0, Landroid/telephony/CdmaCellIdentity;->mSystemId:I

    .line 65
    iput p3, p0, Landroid/telephony/CdmaCellIdentity;->mBasestationId:I

    .line 66
    iput p4, p0, Landroid/telephony/CdmaCellIdentity;->mLongitude:I

    .line 67
    iput p5, p0, Landroid/telephony/CdmaCellIdentity;->mLatitude:I

    .line 68
    return-void
.end method

.method private constructor <init>(Landroid/os/Parcel;)V
    .registers 3
    .parameter "in"

    .prologue
    .line 71
    invoke-direct {p0, p1}, Landroid/telephony/CellIdentity;-><init>(Landroid/os/Parcel;)V

    .line 72
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/telephony/CdmaCellIdentity;->mNetworkId:I

    .line 73
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/telephony/CdmaCellIdentity;->mSystemId:I

    .line 74
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/telephony/CdmaCellIdentity;->mBasestationId:I

    .line 75
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/telephony/CdmaCellIdentity;->mLongitude:I

    .line 76
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/telephony/CdmaCellIdentity;->mLatitude:I

    .line 77
    return-void
.end method

.method synthetic constructor <init>(Landroid/os/Parcel;Landroid/telephony/CdmaCellIdentity$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 27
    invoke-direct {p0, p1}, Landroid/telephony/CdmaCellIdentity;-><init>(Landroid/os/Parcel;)V

    return-void
.end method

.method constructor <init>(Landroid/telephony/CdmaCellIdentity;)V
    .registers 3
    .parameter "cid"

    .prologue
    .line 80
    invoke-direct {p0, p1}, Landroid/telephony/CellIdentity;-><init>(Landroid/telephony/CellIdentity;)V

    .line 81
    iget v0, p1, Landroid/telephony/CdmaCellIdentity;->mNetworkId:I

    iput v0, p0, Landroid/telephony/CdmaCellIdentity;->mNetworkId:I

    .line 82
    iget v0, p1, Landroid/telephony/CdmaCellIdentity;->mSystemId:I

    iput v0, p0, Landroid/telephony/CdmaCellIdentity;->mSystemId:I

    .line 83
    iget v0, p1, Landroid/telephony/CdmaCellIdentity;->mBasestationId:I

    iput v0, p0, Landroid/telephony/CdmaCellIdentity;->mBasestationId:I

    .line 84
    iget v0, p1, Landroid/telephony/CdmaCellIdentity;->mLongitude:I

    iput v0, p0, Landroid/telephony/CdmaCellIdentity;->mLongitude:I

    .line 85
    iget v0, p1, Landroid/telephony/CdmaCellIdentity;->mLatitude:I

    iput v0, p0, Landroid/telephony/CdmaCellIdentity;->mLatitude:I

    .line 86
    return-void
.end method


# virtual methods
.method public describeContents()I
    .registers 2

    .prologue
    .line 137
    const/4 v0, 0x0

    return v0
.end method

.method public getBasestationId()I
    .registers 2

    .prologue
    .line 106
    iget v0, p0, Landroid/telephony/CdmaCellIdentity;->mBasestationId:I

    return v0
.end method

.method public getLatitude()I
    .registers 2

    .prologue
    .line 131
    iget v0, p0, Landroid/telephony/CdmaCellIdentity;->mLatitude:I

    return v0
.end method

.method public getLongitude()I
    .registers 2

    .prologue
    .line 117
    iget v0, p0, Landroid/telephony/CdmaCellIdentity;->mLongitude:I

    return v0
.end method

.method public getNetworkId()I
    .registers 2

    .prologue
    .line 92
    iget v0, p0, Landroid/telephony/CdmaCellIdentity;->mNetworkId:I

    return v0
.end method

.method public getSystemId()I
    .registers 2

    .prologue
    .line 99
    iget v0, p0, Landroid/telephony/CdmaCellIdentity;->mSystemId:I

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 4
    .parameter "dest"
    .parameter "flags"

    .prologue
    .line 143
    invoke-super {p0, p1, p2}, Landroid/telephony/CellIdentity;->writeToParcel(Landroid/os/Parcel;I)V

    .line 144
    iget v0, p0, Landroid/telephony/CdmaCellIdentity;->mNetworkId:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 145
    iget v0, p0, Landroid/telephony/CdmaCellIdentity;->mSystemId:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 146
    iget v0, p0, Landroid/telephony/CdmaCellIdentity;->mBasestationId:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 147
    iget v0, p0, Landroid/telephony/CdmaCellIdentity;->mLongitude:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 148
    iget v0, p0, Landroid/telephony/CdmaCellIdentity;->mLatitude:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 149
    return-void
.end method
