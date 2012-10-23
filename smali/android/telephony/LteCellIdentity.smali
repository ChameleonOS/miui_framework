.class public final Landroid/telephony/LteCellIdentity;
.super Landroid/telephony/CellIdentity;
.source "LteCellIdentity.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Landroid/telephony/LteCellIdentity;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final mCi:I

.field private final mMcc:I

.field private final mMnc:I

.field private final mPci:I

.field private final mTac:I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 130
    new-instance v0, Landroid/telephony/LteCellIdentity$1;

    invoke-direct {v0}, Landroid/telephony/LteCellIdentity$1;-><init>()V

    sput-object v0, Landroid/telephony/LteCellIdentity;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(IIIIILjava/lang/String;)V
    .registers 8
    .parameter "mcc"
    .parameter "mnc"
    .parameter "ci"
    .parameter "pci"
    .parameter "tac"
    .parameter "attr"

    .prologue
    .line 51
    const/4 v0, 0x2

    invoke-direct {p0, v0, p6}, Landroid/telephony/CellIdentity;-><init>(ILjava/lang/String;)V

    .line 52
    iput p1, p0, Landroid/telephony/LteCellIdentity;->mMcc:I

    .line 53
    iput p2, p0, Landroid/telephony/LteCellIdentity;->mMnc:I

    .line 54
    iput p3, p0, Landroid/telephony/LteCellIdentity;->mCi:I

    .line 55
    iput p4, p0, Landroid/telephony/LteCellIdentity;->mPci:I

    .line 56
    iput p5, p0, Landroid/telephony/LteCellIdentity;->mTac:I

    .line 57
    return-void
.end method

.method private constructor <init>(Landroid/os/Parcel;)V
    .registers 3
    .parameter "in"

    .prologue
    .line 60
    invoke-direct {p0, p1}, Landroid/telephony/CellIdentity;-><init>(Landroid/os/Parcel;)V

    .line 61
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/telephony/LteCellIdentity;->mMcc:I

    .line 62
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/telephony/LteCellIdentity;->mMnc:I

    .line 63
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/telephony/LteCellIdentity;->mCi:I

    .line 64
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/telephony/LteCellIdentity;->mPci:I

    .line 65
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/telephony/LteCellIdentity;->mTac:I

    .line 66
    return-void
.end method

.method synthetic constructor <init>(Landroid/os/Parcel;Landroid/telephony/LteCellIdentity$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 27
    invoke-direct {p0, p1}, Landroid/telephony/LteCellIdentity;-><init>(Landroid/os/Parcel;)V

    return-void
.end method

.method constructor <init>(Landroid/telephony/LteCellIdentity;)V
    .registers 3
    .parameter "cid"

    .prologue
    .line 69
    invoke-direct {p0, p1}, Landroid/telephony/CellIdentity;-><init>(Landroid/telephony/CellIdentity;)V

    .line 70
    iget v0, p1, Landroid/telephony/LteCellIdentity;->mMcc:I

    iput v0, p0, Landroid/telephony/LteCellIdentity;->mMcc:I

    .line 71
    iget v0, p1, Landroid/telephony/LteCellIdentity;->mMnc:I

    iput v0, p0, Landroid/telephony/LteCellIdentity;->mMnc:I

    .line 72
    iget v0, p1, Landroid/telephony/LteCellIdentity;->mCi:I

    iput v0, p0, Landroid/telephony/LteCellIdentity;->mCi:I

    .line 73
    iget v0, p1, Landroid/telephony/LteCellIdentity;->mPci:I

    iput v0, p0, Landroid/telephony/LteCellIdentity;->mPci:I

    .line 74
    iget v0, p1, Landroid/telephony/LteCellIdentity;->mTac:I

    iput v0, p0, Landroid/telephony/LteCellIdentity;->mTac:I

    .line 75
    return-void
.end method


# virtual methods
.method public describeContents()I
    .registers 2

    .prologue
    .line 115
    const/4 v0, 0x0

    return v0
.end method

.method public getCi()I
    .registers 2

    .prologue
    .line 95
    iget v0, p0, Landroid/telephony/LteCellIdentity;->mCi:I

    return v0
.end method

.method public getMcc()I
    .registers 2

    .prologue
    .line 81
    iget v0, p0, Landroid/telephony/LteCellIdentity;->mMcc:I

    return v0
.end method

.method public getMnc()I
    .registers 2

    .prologue
    .line 88
    iget v0, p0, Landroid/telephony/LteCellIdentity;->mMnc:I

    return v0
.end method

.method public getPci()I
    .registers 2

    .prologue
    .line 102
    iget v0, p0, Landroid/telephony/LteCellIdentity;->mPci:I

    return v0
.end method

.method public getTac()I
    .registers 2

    .prologue
    .line 109
    iget v0, p0, Landroid/telephony/LteCellIdentity;->mTac:I

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 4
    .parameter "dest"
    .parameter "flags"

    .prologue
    .line 121
    invoke-super {p0, p1, p2}, Landroid/telephony/CellIdentity;->writeToParcel(Landroid/os/Parcel;I)V

    .line 122
    iget v0, p0, Landroid/telephony/LteCellIdentity;->mMcc:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 123
    iget v0, p0, Landroid/telephony/LteCellIdentity;->mMnc:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 124
    iget v0, p0, Landroid/telephony/LteCellIdentity;->mCi:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 125
    iget v0, p0, Landroid/telephony/LteCellIdentity;->mPci:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 126
    iget v0, p0, Landroid/telephony/LteCellIdentity;->mTac:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 127
    return-void
.end method
