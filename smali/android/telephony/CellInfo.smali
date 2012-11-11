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
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    if-ltz p1, :cond_8

    const/4 v0, 0x4

    if-le p1, v0, :cond_21

    :cond_8
    const/4 v0, 0x0

    iput v0, p0, Landroid/telephony/CellInfo;->mTimeStampType:I

    :goto_b
    iput-boolean p6, p0, Landroid/telephony/CellInfo;->mRegistered:Z

    iput-wide p2, p0, Landroid/telephony/CellInfo;->mTimeStamp:J

    iput-wide p4, p0, Landroid/telephony/CellInfo;->mTimingAdvance:J

    new-instance v0, Landroid/telephony/SignalStrength;

    invoke-direct {v0, p7}, Landroid/telephony/SignalStrength;-><init>(Landroid/telephony/SignalStrength;)V

    iput-object v0, p0, Landroid/telephony/CellInfo;->mStrength:Landroid/telephony/SignalStrength;

    invoke-virtual {p8}, Landroid/telephony/CellIdentity;->getCellIdType()I

    move-result v0

    iput v0, p0, Landroid/telephony/CellInfo;->mCellIdentityType:I

    iput-object p8, p0, Landroid/telephony/CellInfo;->mCellIdentity:Landroid/telephony/CellIdentity;

    return-void

    :cond_21
    iput p1, p0, Landroid/telephony/CellInfo;->mTimeStampType:I

    goto :goto_b
.end method

.method private constructor <init>(Landroid/os/Parcel;)V
    .registers 4
    .parameter "in"

    .prologue
    const/4 v0, 0x1

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    iput v1, p0, Landroid/telephony/CellInfo;->mTimeStampType:I

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    if-ne v1, v0, :cond_37

    :goto_10
    iput-boolean v0, p0, Landroid/telephony/CellInfo;->mRegistered:Z

    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Landroid/telephony/CellInfo;->mTimeStamp:J

    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Landroid/telephony/CellInfo;->mTimingAdvance:J

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/telephony/CellInfo;->mCellIdentityType:I

    sget-object v0, Landroid/telephony/SignalStrength;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p1}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/telephony/SignalStrength;

    iput-object v0, p0, Landroid/telephony/CellInfo;->mStrength:Landroid/telephony/SignalStrength;

    iget v0, p0, Landroid/telephony/CellInfo;->mCellIdentityType:I

    packed-switch v0, :pswitch_data_44

    const/4 v0, 0x0

    iput-object v0, p0, Landroid/telephony/CellInfo;->mCellIdentity:Landroid/telephony/CellIdentity;

    :goto_36
    return-void

    :cond_37
    const/4 v0, 0x0

    goto :goto_10

    :pswitch_39
    sget-object v0, Landroid/telephony/GsmCellIdentity;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p1}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/telephony/CellIdentity;

    iput-object v0, p0, Landroid/telephony/CellInfo;->mCellIdentity:Landroid/telephony/CellIdentity;

    goto :goto_36

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
    invoke-direct {p0, p1}, Landroid/telephony/CellInfo;-><init>(Landroid/os/Parcel;)V

    return-void
.end method

.method public constructor <init>(Landroid/telephony/CellInfo;)V
    .registers 4
    .parameter "ci"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iget v0, p1, Landroid/telephony/CellInfo;->mTimeStampType:I

    iput v0, p0, Landroid/telephony/CellInfo;->mTimeStampType:I

    iget-boolean v0, p1, Landroid/telephony/CellInfo;->mRegistered:Z

    iput-boolean v0, p0, Landroid/telephony/CellInfo;->mRegistered:Z

    iget-wide v0, p1, Landroid/telephony/CellInfo;->mTimeStamp:J

    iput-wide v0, p0, Landroid/telephony/CellInfo;->mTimeStamp:J

    iget-wide v0, p1, Landroid/telephony/CellInfo;->mTimingAdvance:J

    iput-wide v0, p0, Landroid/telephony/CellInfo;->mTimingAdvance:J

    iget v0, p1, Landroid/telephony/CellInfo;->mCellIdentityType:I

    iput v0, p0, Landroid/telephony/CellInfo;->mCellIdentityType:I

    new-instance v0, Landroid/telephony/SignalStrength;

    iget-object v1, p1, Landroid/telephony/CellInfo;->mStrength:Landroid/telephony/SignalStrength;

    invoke-direct {v0, v1}, Landroid/telephony/SignalStrength;-><init>(Landroid/telephony/SignalStrength;)V

    iput-object v0, p0, Landroid/telephony/CellInfo;->mStrength:Landroid/telephony/SignalStrength;

    iget v0, p0, Landroid/telephony/CellInfo;->mCellIdentityType:I

    packed-switch v0, :pswitch_data_36

    const/4 v0, 0x0

    iput-object v0, p0, Landroid/telephony/CellInfo;->mCellIdentity:Landroid/telephony/CellIdentity;

    :goto_28
    return-void

    :pswitch_29
    new-instance v1, Landroid/telephony/GsmCellIdentity;

    iget-object v0, p1, Landroid/telephony/CellInfo;->mCellIdentity:Landroid/telephony/CellIdentity;

    check-cast v0, Landroid/telephony/GsmCellIdentity;

    invoke-direct {v1, v0}, Landroid/telephony/GsmCellIdentity;-><init>(Landroid/telephony/GsmCellIdentity;)V

    iput-object v1, p0, Landroid/telephony/CellInfo;->mCellIdentity:Landroid/telephony/CellIdentity;

    goto :goto_28

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
    const/4 v0, 0x0

    return v0
.end method

.method public getCellIdentity()Landroid/telephony/CellIdentity;
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/telephony/CellInfo;->mCellIdentity:Landroid/telephony/CellIdentity;

    return-object v0
.end method

.method public getSignalStrength()Landroid/telephony/SignalStrength;
    .registers 3

    .prologue
    new-instance v0, Landroid/telephony/SignalStrength;

    iget-object v1, p0, Landroid/telephony/CellInfo;->mStrength:Landroid/telephony/SignalStrength;

    invoke-direct {v0, v1}, Landroid/telephony/SignalStrength;-><init>(Landroid/telephony/SignalStrength;)V

    return-object v0
.end method

.method public getTimeStamp()J
    .registers 3

    .prologue
    iget-wide v0, p0, Landroid/telephony/CellInfo;->mTimeStamp:J

    return-wide v0
.end method

.method public getTimeStampType()I
    .registers 2

    .prologue
    iget v0, p0, Landroid/telephony/CellInfo;->mTimeStampType:I

    return v0
.end method

.method public getTimingAdvance()J
    .registers 3

    .prologue
    iget-wide v0, p0, Landroid/telephony/CellInfo;->mTimingAdvance:J

    return-wide v0
.end method

.method public isRegistered()Z
    .registers 2

    .prologue
    iget-boolean v0, p0, Landroid/telephony/CellInfo;->mRegistered:Z

    return v0
.end method

.method public toString()Ljava/lang/String;
    .registers 5

    .prologue
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .local v0, sb:Ljava/lang/StringBuffer;
    const-string v1, "TimeStampType: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    iget v1, p0, Landroid/telephony/CellInfo;->mTimeStampType:I

    packed-switch v1, :pswitch_data_92

    const-string/jumbo v1, "unknown"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    :goto_15
    const-string v1, ", TimeStamp: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    iget-wide v2, p0, Landroid/telephony/CellInfo;->mTimeStamp:J

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuffer;->append(J)Ljava/lang/StringBuffer;

    move-result-object v1

    const-string v2, " ns"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    const-string v1, ", Registered: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    iget-boolean v1, p0, Landroid/telephony/CellInfo;->mRegistered:Z

    if-eqz v1, :cond_8f

    const-string v1, "YES"

    :goto_32
    invoke-virtual {v2, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    const-string v1, ", TimingAdvance: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    iget-wide v2, p0, Landroid/telephony/CellInfo;->mTimingAdvance:J

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuffer;->append(J)Ljava/lang/StringBuffer;

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

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1

    :pswitch_75
    const-string v1, "antenna"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_15

    :pswitch_7b
    const-string/jumbo v1, "modem"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_15

    :pswitch_82
    const-string/jumbo v1, "oem_ril"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_15

    :pswitch_89
    const-string v1, "java_ril"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_15

    :cond_8f
    const-string v1, "NO"

    goto :goto_32

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
    iget v0, p0, Landroid/telephony/CellInfo;->mTimeStampType:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget-boolean v0, p0, Landroid/telephony/CellInfo;->mRegistered:Z

    if-eqz v0, :cond_27

    const/4 v0, 0x1

    :goto_a
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget-wide v0, p0, Landroid/telephony/CellInfo;->mTimeStamp:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    iget-wide v0, p0, Landroid/telephony/CellInfo;->mTimingAdvance:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    iget v0, p0, Landroid/telephony/CellInfo;->mCellIdentityType:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget-object v0, p0, Landroid/telephony/CellInfo;->mStrength:Landroid/telephony/SignalStrength;

    invoke-virtual {v0, p1, p2}, Landroid/telephony/SignalStrength;->writeToParcel(Landroid/os/Parcel;I)V

    iget-object v0, p0, Landroid/telephony/CellInfo;->mCellIdentity:Landroid/telephony/CellIdentity;

    invoke-virtual {v0, p1, p2}, Landroid/telephony/CellIdentity;->writeToParcel(Landroid/os/Parcel;I)V

    return-void

    :cond_27
    const/4 v0, 0x0

    goto :goto_a
.end method
