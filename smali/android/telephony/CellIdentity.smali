.class public abstract Landroid/telephony/CellIdentity;
.super Ljava/lang/Object;
.source "CellIdentity.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CELLID_TYPE_CDMA:I = 0x2

.field public static final CELLID_TYPE_GSM:I = 0x1

.field public static final CELLID_TYPE_LTE:I = 0x3


# instance fields
.field private mCellIdAttributes:Ljava/lang/String;

.field private mCellIdType:I


# direct methods
.method protected constructor <init>(ILjava/lang/String;)V
    .registers 4
    .parameter "type"
    .parameter "attr"

    .prologue
    .line 40
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 41
    iput p1, p0, Landroid/telephony/CellIdentity;->mCellIdType:I

    .line 42
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0, p2}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Landroid/telephony/CellIdentity;->mCellIdAttributes:Ljava/lang/String;

    .line 43
    return-void
.end method

.method protected constructor <init>(Landroid/os/Parcel;)V
    .registers 4
    .parameter "in"

    .prologue
    .line 45
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 46
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/telephony/CellIdentity;->mCellIdType:I

    .line 47
    new-instance v0, Ljava/lang/String;

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Landroid/telephony/CellIdentity;->mCellIdAttributes:Ljava/lang/String;

    .line 48
    return-void
.end method

.method protected constructor <init>(Landroid/telephony/CellIdentity;)V
    .registers 4
    .parameter "cid"

    .prologue
    .line 50
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 51
    iget v0, p1, Landroid/telephony/CellIdentity;->mCellIdType:I

    iput v0, p0, Landroid/telephony/CellIdentity;->mCellIdType:I

    .line 52
    new-instance v0, Ljava/lang/String;

    iget-object v1, p1, Landroid/telephony/CellIdentity;->mCellIdAttributes:Ljava/lang/String;

    invoke-direct {v0, v1}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Landroid/telephony/CellIdentity;->mCellIdAttributes:Ljava/lang/String;

    .line 53
    return-void
.end method


# virtual methods
.method public describeContents()I
    .registers 2

    .prologue
    .line 80
    const/4 v0, 0x0

    return v0
.end method

.method public getCellIdAttributes()Ljava/lang/String;
    .registers 2

    .prologue
    .line 73
    iget-object v0, p0, Landroid/telephony/CellIdentity;->mCellIdAttributes:Ljava/lang/String;

    return-object v0
.end method

.method public getCellIdType()I
    .registers 2

    .prologue
    .line 59
    iget v0, p0, Landroid/telephony/CellIdentity;->mCellIdType:I

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 4
    .parameter "dest"
    .parameter "flags"

    .prologue
    .line 86
    iget v0, p0, Landroid/telephony/CellIdentity;->mCellIdType:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 87
    iget-object v0, p0, Landroid/telephony/CellIdentity;->mCellIdAttributes:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 88
    return-void
.end method
