.class public final Landroid/telephony/CellInfo;
.super Ljava/lang/Object;
.source "CellInfo.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CELL_INFO_TIMESTAMP_TYPE_ANTENNA:I = 0x1

.field public static final CELL_INFO_TIMESTAMP_TYPE_JAVA_RIL:I = 0x4

.field public static final CELL_INFO_TIMESTAMP_TYPE_MODEM:I = 0x2

.field public static final CELL_INFO_TIMESTAMP_TYPE_OEM_RIL:I = 0x3

.field public static final CELL_INFO_TIMESTAMP_TYPE_UNKNOWN:I

.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Landroid/telephony/CellInfo;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final mCellIdentity:Landroid/telephony/CellIdentity;

.field private final mCellIdentityType:I

.field private final mRegistered:Z

.field private final mStrength:Landroid/telephony/SignalStrength;

.field private final mTimeStamp:J

.field private final mTimeStampType:I

.field private final mTimingAdvance:J


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 206
    new-instance v0, Landroid/telephony/CellInfo$1;

    invoke-direct {v0}, Landroid/telephony/CellInfo$1;-><init>()V

    sput-object v0, Landroid/telephony/CellInfo;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(IJJZLandroid/telephony/SignalStrength;Landroid/telephony/CellIdentity;)V
    .registers 10
    .parameter "timeStampType"
    .parameter "timeStamp"
    .parameter "timingAdv"
    .parameter "registered"
    .parameter "strength"
    .parameter "cellIdentity"

    .prologue
    .line 61
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 63
    if-ltz p1, :cond_8

    const/4 v0, 0x4

    if-le p1, v0, :cond_21

    .line 65
    :cond_8
    const/4 v0, 0x0

    iput v0, p0, Landroid/telephony/CellInfo;->mTimeStampType:I

    .line 70
    :goto_b
    iput-boolean p6, p0, Landroid/telephony/CellInfo;->mRegistered:Z

    .line 71
    iput-wide p2, p0, Landroid/telephony/CellInfo;->mTimeStamp:J

    .line 72
    iput-wide p4, p0, Landroid/telephony/CellInfo;->mTimingAdvance:J

    .line 73
    new-instance v0, Landroid/telephony/SignalStrength;

    invoke-direct {v0, p7}, Landroid/telephony/SignalStrength;-><init>(Landroid/telephony/SignalStrength;)V

    iput-object v0, p0, Landroid/telephony/CellInfo;->mStrength:Landroid/telephony/SignalStrength;

    .line 75
    invoke-virtual {p8}, Landroid/telephony/CellIdentity;->getCellIdType()I

    move-result v0

    iput v0, p0, Landroid/telephony/CellInfo;->mCellIdentityType:I

    .line 77
    iput-object p8, p0, Landroid/telephony/CellInfo;->mCellIdentity:Landroid/telephony/CellIdentity;

    .line 78
    return-void

    .line 67
    :cond_21
    iput p1, p0, Landroid/telephony/CellInfo;->mTimeStampType:I

    goto :goto_b
.end method

.method private constructor <init>(Landroid/os/Parcel;)V
    .registers 4
    .parameter "in"

    .prologue
    const/4 v0, 0x1

    .line 96
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 97
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    iput v1, p0, Landroid/telephony/CellInfo;->mTimeStampType:I

    .line 98
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    if-ne v1, v0, :cond_37

    :goto_10
    iput-boolean v0, p0, Landroid/telephony/CellInfo;->mRegistered:Z

    .line 99
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Landroid/telephony/CellInfo;->mTimeStamp:J

    .line 100
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Landroid/telephony/CellInfo;->mTimingAdvance:J

    .line 101
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/telephony/CellInfo;->mCellIdentityType:I

    .line 102
    sget-object v0, Landroid/telephony/SignalStrength;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p1}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/telephony/SignalStrength;

    iput-object v0, p0, Landroid/telephony/CellInfo;->mStrength:Landroid/telephony/SignalStrength;

    .line 103
    iget v0, p0, Landroid/telephony/CellInfo;->mCellIdentityType:I

    packed-switch v0, :pswitch_data_44

    .line 108
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/telephony/CellInfo;->mCellIdentity:Landroid/telephony/CellIdentity;

    .line 110
    :goto_36
    return-void

    .line 98
    :cond_37
    const/4 v0, 0x0

    goto :goto_10

    .line 105
    :pswitch_39
    sget-object v0, Landroid/telephony/GsmCellIdentity;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p1}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/telephony/CellIdentity;

    iput-object v0, p0, Landroid/telephony/CellInfo;->mCellIdentity:Landroid/telephony/CellIdentity;

    goto :goto_36

    .line 103
    :pswitch_data_44
    .packed-switch 0x1
        :pswitch_39
    .end packed-switch
.end method

.method synthetic constructor <init>(Landroid/os/Parcel;Landroid/telephony/CellInfo$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 28
    invoke-direct {p0, p1}, Landroid/telephony/CellInfo;-><init>(Landroid/os/Parcel;)V

    return-void
.end method

.method public constructor <init>(Landroid/telephony/CellInfo;)V
    .registers 4
    .parameter "ci"

    .prologue
    .line 80
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 81
    iget v0, p1, Landroid/telephony/CellInfo;->mTimeStampType:I

    iput v0, p0, Landroid/telephony/CellInfo;->mTimeStampType:I

    .line 82
    iget-boolean v0, p1, Landroid/telephony/CellInfo;->mRegistered:Z

    iput-boolean v0, p0, Landroid/telephony/CellInfo;->mRegistered:Z

    .line 83
    iget-wide v0, p1, Landroid/telephony/CellInfo;->mTimeStamp:J

    iput-wide v0, p0, Landroid/telephony/CellInfo;->mTimeStamp:J

    .line 84
    iget-wide v0, p1, Landroid/telephony/CellInfo;->mTimingAdvance:J

    iput-wide v0, p0, Landroid/telephony/CellInfo;->mTimingAdvance:J

    .line 85
    iget v0, p1, Landroid/telephony/CellInfo;->mCellIdentityType:I

    iput v0, p0, Landroid/telephony/CellInfo;->mCellIdentityType:I

    .line 86
    new-instance v0, Landroid/telephony/SignalStrength;

    iget-object v1, p1, Landroid/telephony/CellInfo;->mStrength:Landroid/telephony/SignalStrength;

    invoke-direct {v0, v1}, Landroid/telephony/SignalStrength;-><init>(Landroid/telephony/SignalStrength;)V

    iput-object v0, p0, Landroid/telephony/CellInfo;->mStrength:Landroid/telephony/SignalStrength;

    .line 87
    iget v0, p0, Landroid/telephony/CellInfo;->mCellIdentityType:I

    packed-switch v0, :pswitch_data_36

    .line 92
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/telephony/CellInfo;->mCellIdentity:Landroid/telephony/CellIdentity;

    .line 94
    :goto_28
    return-void

    .line 89
    :pswitch_29
    new-instance v1, Landroid/telephony/GsmCellIdentity;

    iget-object v0, p1, Landroid/telephony/CellInfo;->mCellIdentity:Landroid/telephony/CellIdentity;

    check-cast v0, Landroid/telephony/GsmCellIdentity;

    invoke-direct {v1, v0}, Landroid/telephony/GsmCellIdentity;-><init>(Landroid/telephony/GsmCellIdentity;)V

    iput-object v1, p0, Landroid/telephony/CellInfo;->mCellIdentity:Landroid/telephony/CellIdentity;

    goto :goto_28

    .line 87
    nop

    :pswitch_data_36
    .packed-switch 0x1
        :pswitch_29
    .end packed-switch
.end method


# virtual methods
.method public describeContents()I
    .registers 2

    .prologue
    .line 190
    const/4 v0, 0x0

    return v0
.end method

.method public getCellIdentity()Landroid/telephony/CellIdentity;
    .registers 2

    .prologue
    .line 154
    iget-object v0, p0, Landroid/telephony/CellInfo;->mCellIdentity:Landroid/telephony/CellIdentity;

    return-object v0
.end method

.method public getSignalStrength()Landroid/telephony/SignalStrength;
    .registers 3

    .prologue
    .line 146
    new-instance v0, Landroid/telephony/SignalStrength;

    iget-object v1, p0, Landroid/telephony/CellInfo;->mStrength:Landroid/telephony/SignalStrength;

    invoke-direct {v0, v1}, Landroid/telephony/SignalStrength;-><init>(Landroid/telephony/SignalStrength;)V

    return-object v0
.end method

.method public getTimeStamp()J
    .registers 3

    .prologue
    .line 116
    iget-wide v0, p0, Landroid/telephony/CellInfo;->mTimeStamp:J

    return-wide v0
.end method

.method public getTimeStampType()I
    .registers 2

    .prologue
    .line 124
    iget v0, p0, Landroid/telephony/CellInfo;->mTimeStampType:I

    return v0
.end method

.method public getTimingAdvance()J
    .registers 3

    .prologue
    .line 138
    iget-wide v0, p0, Landroid/telephony/CellInfo;->mTimingAdvance:J

    return-wide v0
.end method

.method public isRegistered()Z
    .registers 2

    .prologue
    .line 131
    iget-boolean v0, p0, Landroid/telephony/CellInfo;->mRegistered:Z

    return v0
.end method

.method public toString()Ljava/lang/String;
    .registers 5

    .prologue
    .line 159
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 161
    .local v0, sb:Ljava/lang/StringBuffer;
    const-string v1, "TimeStampType: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 162
    iget v1, p0, Landroid/telephony/CellInfo;->mTimeStampType:I

    packed-switch v1, :pswitch_data_92

    .line 176
    const-string/jumbo v1, "unknown"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 178
    :goto_15
    const-string v1, ", TimeStamp: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    iget-wide v2, p0, Landroid/telephony/CellInfo;->mTimeStamp:J

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuffer;->append(J)Ljava/lang/StringBuffer;

    move-result-object v1

    const-string v2, " ns"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 179
    const-string v1, ", Registered: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    iget-boolean v1, p0, Landroid/telephony/CellInfo;->mRegistered:Z

    if-eqz v1, :cond_8f

    const-string v1, "YES"

    :goto_32
    invoke-virtual {v2, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 180
    const-string v1, ", TimingAdvance: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    iget-wide v2, p0, Landroid/telephony/CellInfo;->mTimingAdvance:J

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuffer;->append(J)Ljava/lang/StringBuffer;

    .line 181
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, ", Strength : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Landroid/telephony/CellInfo;->mStrength:Landroid/telephony/SignalStrength;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 182
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, ", Cell Iden: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Landroid/telephony/CellInfo;->mCellIdentity:Landroid/telephony/CellIdentity;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 184
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1

    .line 164
    :pswitch_75
    const-string v1, "antenna"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_15

    .line 167
    :pswitch_7b
    const-string/jumbo v1, "modem"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_15

    .line 170
    :pswitch_82
    const-string/jumbo v1, "oem_ril"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_15

    .line 173
    :pswitch_89
    const-string v1, "java_ril"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_15

    .line 179
    :cond_8f
    const-string v1, "NO"

    goto :goto_32

    .line 162
    :pswitch_data_92
    .packed-switch 0x1
        :pswitch_75
        :pswitch_7b
        :pswitch_82
        :pswitch_89
    .end packed-switch
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 5
    .parameter "dest"
    .parameter "flags"

    .prologue
    .line 196
    iget v0, p0, Landroid/telephony/CellInfo;->mTimeStampType:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 197
    iget-boolean v0, p0, Landroid/telephony/CellInfo;->mRegistered:Z

    if-eqz v0, :cond_27

    const/4 v0, 0x1

    :goto_a
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 198
    iget-wide v0, p0, Landroid/telephony/CellInfo;->mTimeStamp:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 199
    iget-wide v0, p0, Landroid/telephony/CellInfo;->mTimingAdvance:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 200
    iget v0, p0, Landroid/telephony/CellInfo;->mCellIdentityType:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 201
    iget-object v0, p0, Landroid/telephony/CellInfo;->mStrength:Landroid/telephony/SignalStrength;

    invoke-virtual {v0, p1, p2}, Landroid/telephony/SignalStrength;->writeToParcel(Landroid/os/Parcel;I)V

    .line 202
    iget-object v0, p0, Landroid/telephony/CellInfo;->mCellIdentity:Landroid/telephony/CellIdentity;

    invoke-virtual {v0, p1, p2}, Landroid/telephony/CellIdentity;->writeToParcel(Landroid/os/Parcel;I)V

    .line 203
    return-void

    .line 197
    :cond_27
    const/4 v0, 0x0

    goto :goto_a
.end method
