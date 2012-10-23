.class public Landroid/telephony/NeighboringCellInfo;
.super Ljava/lang/Object;
.source "NeighboringCellInfo.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator; = null
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Landroid/telephony/NeighboringCellInfo;",
            ">;"
        }
    .end annotation
.end field

.field public static final UNKNOWN_CID:I = -0x1

.field public static final UNKNOWN_RSSI:I = 0x63


# instance fields
.field private mCid:I

.field private mLac:I

.field private mNetworkType:I

.field private mPsc:I

.field private mRssi:I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 289
    new-instance v0, Landroid/telephony/NeighboringCellInfo$1;

    invoke-direct {v0}, Landroid/telephony/NeighboringCellInfo$1;-><init>()V

    sput-object v0, Landroid/telephony/NeighboringCellInfo;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .registers 3
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    const/4 v1, -0x1

    .line 80
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 81
    const/16 v0, 0x63

    iput v0, p0, Landroid/telephony/NeighboringCellInfo;->mRssi:I

    .line 82
    iput v1, p0, Landroid/telephony/NeighboringCellInfo;->mLac:I

    .line 83
    iput v1, p0, Landroid/telephony/NeighboringCellInfo;->mCid:I

    .line 84
    iput v1, p0, Landroid/telephony/NeighboringCellInfo;->mPsc:I

    .line 85
    const/4 v0, 0x0

    iput v0, p0, Landroid/telephony/NeighboringCellInfo;->mNetworkType:I

    .line 86
    return-void
.end method

.method public constructor <init>(II)V
    .registers 3
    .parameter "rssi"
    .parameter "cid"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 98
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 99
    iput p1, p0, Landroid/telephony/NeighboringCellInfo;->mRssi:I

    .line 100
    iput p2, p0, Landroid/telephony/NeighboringCellInfo;->mCid:I

    .line 101
    return-void
.end method

.method public constructor <init>(ILjava/lang/String;I)V
    .registers 11
    .parameter "rssi"
    .parameter "location"
    .parameter "radioType"

    .prologue
    const/16 v3, 0x8

    const/4 v6, 0x0

    const/4 v5, -0x1

    .line 113
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 115
    iput p1, p0, Landroid/telephony/NeighboringCellInfo;->mRssi:I

    .line 116
    iput v6, p0, Landroid/telephony/NeighboringCellInfo;->mNetworkType:I

    .line 117
    iput v5, p0, Landroid/telephony/NeighboringCellInfo;->mPsc:I

    .line 118
    iput v5, p0, Landroid/telephony/NeighboringCellInfo;->mLac:I

    .line 119
    iput v5, p0, Landroid/telephony/NeighboringCellInfo;->mCid:I

    .line 123
    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v2

    .line 124
    .local v2, l:I
    if-le v2, v3, :cond_18

    .line 157
    :cond_17
    :goto_17
    return-void

    .line 125
    :cond_18
    if-ge v2, v3, :cond_35

    .line 126
    const/4 v1, 0x0

    .local v1, i:I
    :goto_1b
    rsub-int/lit8 v3, v2, 0x8

    if-ge v1, v3, :cond_35

    .line 127
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "0"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    .line 126
    add-int/lit8 v1, v1, 0x1

    goto :goto_1b

    .line 132
    .end local v1           #i:I
    :cond_35
    packed-switch p3, :pswitch_data_80

    :pswitch_38
    goto :goto_17

    .line 135
    :pswitch_39
    :try_start_39
    iput p3, p0, Landroid/telephony/NeighboringCellInfo;->mNetworkType:I

    .line 137
    const-string v3, "FFFFFFFF"

    invoke-virtual {p2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_17

    .line 138
    const/4 v3, 0x4

    invoke-virtual {p2, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v3

    const/16 v4, 0x10

    invoke-static {v3, v4}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v3

    iput v3, p0, Landroid/telephony/NeighboringCellInfo;->mCid:I

    .line 139
    const/4 v3, 0x0

    const/4 v4, 0x4

    invoke-virtual {p2, v3, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    const/16 v4, 0x10

    invoke-static {v3, v4}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v3

    iput v3, p0, Landroid/telephony/NeighboringCellInfo;->mLac:I
    :try_end_66
    .catch Ljava/lang/NumberFormatException; {:try_start_39 .. :try_end_66} :catch_67

    goto :goto_17

    .line 150
    :catch_67
    move-exception v0

    .line 152
    .local v0, e:Ljava/lang/NumberFormatException;
    iput v5, p0, Landroid/telephony/NeighboringCellInfo;->mPsc:I

    .line 153
    iput v5, p0, Landroid/telephony/NeighboringCellInfo;->mLac:I

    .line 154
    iput v5, p0, Landroid/telephony/NeighboringCellInfo;->mCid:I

    .line 155
    iput v6, p0, Landroid/telephony/NeighboringCellInfo;->mNetworkType:I

    goto :goto_17

    .line 146
    .end local v0           #e:Ljava/lang/NumberFormatException;
    :pswitch_71
    :try_start_71
    iput p3, p0, Landroid/telephony/NeighboringCellInfo;->mNetworkType:I

    .line 147
    const/16 v3, 0x10

    invoke-static {p2, v3}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v3

    iput v3, p0, Landroid/telephony/NeighboringCellInfo;->mPsc:I
    :try_end_7f
    .catch Ljava/lang/NumberFormatException; {:try_start_71 .. :try_end_7f} :catch_67

    goto :goto_17

    .line 132
    :pswitch_data_80
    .packed-switch 0x1
        :pswitch_39
        :pswitch_39
        :pswitch_71
        :pswitch_38
        :pswitch_38
        :pswitch_38
        :pswitch_38
        :pswitch_71
        :pswitch_71
        :pswitch_71
    .end packed-switch
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .registers 3
    .parameter "in"

    .prologue
    .line 162
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 163
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/telephony/NeighboringCellInfo;->mRssi:I

    .line 164
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/telephony/NeighboringCellInfo;->mLac:I

    .line 165
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/telephony/NeighboringCellInfo;->mCid:I

    .line 166
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/telephony/NeighboringCellInfo;->mPsc:I

    .line 167
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/telephony/NeighboringCellInfo;->mNetworkType:I

    .line 168
    return-void
.end method


# virtual methods
.method public describeContents()I
    .registers 2

    .prologue
    .line 278
    const/4 v0, 0x0

    return v0
.end method

.method public getCid()I
    .registers 2

    .prologue
    .line 194
    iget v0, p0, Landroid/telephony/NeighboringCellInfo;->mCid:I

    return v0
.end method

.method public getLac()I
    .registers 2

    .prologue
    .line 186
    iget v0, p0, Landroid/telephony/NeighboringCellInfo;->mLac:I

    return v0
.end method

.method public getNetworkType()I
    .registers 2

    .prologue
    .line 227
    iget v0, p0, Landroid/telephony/NeighboringCellInfo;->mNetworkType:I

    return v0
.end method

.method public getPsc()I
    .registers 2

    .prologue
    .line 202
    iget v0, p0, Landroid/telephony/NeighboringCellInfo;->mPsc:I

    return v0
.end method

.method public getRssi()I
    .registers 2

    .prologue
    .line 178
    iget v0, p0, Landroid/telephony/NeighboringCellInfo;->mRssi:I

    return v0
.end method

.method public setCid(I)V
    .registers 2
    .parameter "cid"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 241
    iput p1, p0, Landroid/telephony/NeighboringCellInfo;->mCid:I

    .line 242
    return-void
.end method

.method public setRssi(I)V
    .registers 2
    .parameter "rssi"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 256
    iput p1, p0, Landroid/telephony/NeighboringCellInfo;->mRssi:I

    .line 257
    return-void
.end method

.method public toString()Ljava/lang/String;
    .registers 5

    .prologue
    const/16 v3, 0x63

    const/4 v2, -0x1

    .line 261
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 263
    .local v0, sb:Ljava/lang/StringBuilder;
    const-string v1, "["

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 264
    iget v1, p0, Landroid/telephony/NeighboringCellInfo;->mPsc:I

    if-eq v1, v2, :cond_3b

    .line 265
    iget v1, p0, Landroid/telephony/NeighboringCellInfo;->mPsc:I

    invoke-static {v1}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "@"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget v1, p0, Landroid/telephony/NeighboringCellInfo;->mRssi:I

    if-ne v1, v3, :cond_34

    const-string v1, "-"

    :goto_27
    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 272
    :cond_2a
    :goto_2a
    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 274
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1

    .line 265
    :cond_34
    iget v1, p0, Landroid/telephony/NeighboringCellInfo;->mRssi:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    goto :goto_27

    .line 267
    :cond_3b
    iget v1, p0, Landroid/telephony/NeighboringCellInfo;->mLac:I

    if-eq v1, v2, :cond_2a

    iget v1, p0, Landroid/telephony/NeighboringCellInfo;->mCid:I

    if-eq v1, v2, :cond_2a

    .line 268
    iget v1, p0, Landroid/telephony/NeighboringCellInfo;->mLac:I

    invoke-static {v1}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Landroid/telephony/NeighboringCellInfo;->mCid:I

    invoke-static {v2}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "@"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget v1, p0, Landroid/telephony/NeighboringCellInfo;->mRssi:I

    if-ne v1, v3, :cond_67

    const-string v1, "-"

    :goto_63
    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    goto :goto_2a

    :cond_67
    iget v1, p0, Landroid/telephony/NeighboringCellInfo;->mRssi:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    goto :goto_63
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 4
    .parameter "dest"
    .parameter "flags"

    .prologue
    .line 282
    iget v0, p0, Landroid/telephony/NeighboringCellInfo;->mRssi:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 283
    iget v0, p0, Landroid/telephony/NeighboringCellInfo;->mLac:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 284
    iget v0, p0, Landroid/telephony/NeighboringCellInfo;->mCid:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 285
    iget v0, p0, Landroid/telephony/NeighboringCellInfo;->mPsc:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 286
    iget v0, p0, Landroid/telephony/NeighboringCellInfo;->mNetworkType:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 287
    return-void
.end method
