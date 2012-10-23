.class public Landroid/telephony/SmsCbEtwsInfo;
.super Ljava/lang/Object;
.source "SmsCbEtwsInfo.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator; = null
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Landroid/telephony/SmsCbEtwsInfo;",
            ">;"
        }
    .end annotation
.end field

.field public static final ETWS_WARNING_TYPE_EARTHQUAKE:I = 0x0

.field public static final ETWS_WARNING_TYPE_EARTHQUAKE_AND_TSUNAMI:I = 0x2

.field public static final ETWS_WARNING_TYPE_OTHER_EMERGENCY:I = 0x4

.field public static final ETWS_WARNING_TYPE_TEST_MESSAGE:I = 0x3

.field public static final ETWS_WARNING_TYPE_TSUNAMI:I = 0x1

.field public static final ETWS_WARNING_TYPE_UNKNOWN:I = -0x1


# instance fields
.field private final mActivatePopup:Z

.field private final mEmergencyUserAlert:Z

.field private final mWarningSecurityInformation:[B

.field private final mWarningType:I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 197
    new-instance v0, Landroid/telephony/SmsCbEtwsInfo$1;

    invoke-direct {v0}, Landroid/telephony/SmsCbEtwsInfo$1;-><init>()V

    sput-object v0, Landroid/telephony/SmsCbEtwsInfo;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(IZZ[B)V
    .registers 5
    .parameter "warningType"
    .parameter "emergencyUserAlert"
    .parameter "activatePopup"
    .parameter "warningSecurityInformation"

    .prologue
    .line 73
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 74
    iput p1, p0, Landroid/telephony/SmsCbEtwsInfo;->mWarningType:I

    .line 75
    iput-boolean p2, p0, Landroid/telephony/SmsCbEtwsInfo;->mEmergencyUserAlert:Z

    .line 76
    iput-boolean p3, p0, Landroid/telephony/SmsCbEtwsInfo;->mActivatePopup:Z

    .line 77
    iput-object p4, p0, Landroid/telephony/SmsCbEtwsInfo;->mWarningSecurityInformation:[B

    .line 78
    return-void
.end method

.method constructor <init>(Landroid/os/Parcel;)V
    .registers 5
    .parameter "in"

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 81
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 82
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/telephony/SmsCbEtwsInfo;->mWarningType:I

    .line 83
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_23

    move v0, v1

    :goto_12
    iput-boolean v0, p0, Landroid/telephony/SmsCbEtwsInfo;->mEmergencyUserAlert:Z

    .line 84
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_25

    :goto_1a
    iput-boolean v1, p0, Landroid/telephony/SmsCbEtwsInfo;->mActivatePopup:Z

    .line 85
    invoke-virtual {p1}, Landroid/os/Parcel;->createByteArray()[B

    move-result-object v0

    iput-object v0, p0, Landroid/telephony/SmsCbEtwsInfo;->mWarningSecurityInformation:[B

    .line 86
    return-void

    :cond_23
    move v0, v2

    .line 83
    goto :goto_12

    :cond_25
    move v1, v2

    .line 84
    goto :goto_1a
.end method


# virtual methods
.method public describeContents()I
    .registers 2

    .prologue
    .line 193
    const/4 v0, 0x0

    return v0
.end method

.method public getPrimaryNotificationSignature()[B
    .registers 4

    .prologue
    const/16 v2, 0x32

    .line 175
    iget-object v0, p0, Landroid/telephony/SmsCbEtwsInfo;->mWarningSecurityInformation:[B

    if-eqz v0, :cond_b

    iget-object v0, p0, Landroid/telephony/SmsCbEtwsInfo;->mWarningSecurityInformation:[B

    array-length v0, v0

    if-ge v0, v2, :cond_d

    .line 176
    :cond_b
    const/4 v0, 0x0

    .line 178
    :goto_c
    return-object v0

    :cond_d
    iget-object v0, p0, Landroid/telephony/SmsCbEtwsInfo;->mWarningSecurityInformation:[B

    const/4 v1, 0x7

    invoke-static {v0, v1, v2}, Ljava/util/Arrays;->copyOfRange([BII)[B

    move-result-object v0

    goto :goto_c
.end method

.method public getPrimaryNotificationTimestamp()J
    .registers 14

    .prologue
    const/4 v11, 0x1

    .line 132
    iget-object v9, p0, Landroid/telephony/SmsCbEtwsInfo;->mWarningSecurityInformation:[B

    if-eqz v9, :cond_b

    iget-object v9, p0, Landroid/telephony/SmsCbEtwsInfo;->mWarningSecurityInformation:[B

    array-length v9, v9

    const/4 v10, 0x7

    if-ge v9, v10, :cond_e

    .line 133
    :cond_b
    const-wide/16 v9, 0x0

    .line 166
    :goto_d
    return-wide v9

    .line 136
    :cond_e
    iget-object v9, p0, Landroid/telephony/SmsCbEtwsInfo;->mWarningSecurityInformation:[B

    const/4 v10, 0x0

    aget-byte v9, v9, v10

    invoke-static {v9}, Lcom/android/internal/telephony/IccUtils;->gsmBcdByteToInt(B)I

    move-result v8

    .line 137
    .local v8, year:I
    iget-object v9, p0, Landroid/telephony/SmsCbEtwsInfo;->mWarningSecurityInformation:[B

    aget-byte v9, v9, v11

    invoke-static {v9}, Lcom/android/internal/telephony/IccUtils;->gsmBcdByteToInt(B)I

    move-result v3

    .line 138
    .local v3, month:I
    iget-object v9, p0, Landroid/telephony/SmsCbEtwsInfo;->mWarningSecurityInformation:[B

    const/4 v10, 0x2

    aget-byte v9, v9, v10

    invoke-static {v9}, Lcom/android/internal/telephony/IccUtils;->gsmBcdByteToInt(B)I

    move-result v0

    .line 139
    .local v0, day:I
    iget-object v9, p0, Landroid/telephony/SmsCbEtwsInfo;->mWarningSecurityInformation:[B

    const/4 v10, 0x3

    aget-byte v9, v9, v10

    invoke-static {v9}, Lcom/android/internal/telephony/IccUtils;->gsmBcdByteToInt(B)I

    move-result v1

    .line 140
    .local v1, hour:I
    iget-object v9, p0, Landroid/telephony/SmsCbEtwsInfo;->mWarningSecurityInformation:[B

    const/4 v10, 0x4

    aget-byte v9, v9, v10

    invoke-static {v9}, Lcom/android/internal/telephony/IccUtils;->gsmBcdByteToInt(B)I

    move-result v2

    .line 141
    .local v2, minute:I
    iget-object v9, p0, Landroid/telephony/SmsCbEtwsInfo;->mWarningSecurityInformation:[B

    const/4 v10, 0x5

    aget-byte v9, v9, v10

    invoke-static {v9}, Lcom/android/internal/telephony/IccUtils;->gsmBcdByteToInt(B)I

    move-result v4

    .line 148
    .local v4, second:I
    iget-object v9, p0, Landroid/telephony/SmsCbEtwsInfo;->mWarningSecurityInformation:[B

    const/4 v10, 0x6

    aget-byte v7, v9, v10

    .line 151
    .local v7, tzByte:B
    and-int/lit8 v9, v7, -0x9

    int-to-byte v9, v9

    invoke-static {v9}, Lcom/android/internal/telephony/IccUtils;->gsmBcdByteToInt(B)I

    move-result v6

    .line 153
    .local v6, timezoneOffset:I
    and-int/lit8 v9, v7, 0x8

    if-nez v9, :cond_77

    .line 155
    :goto_53
    new-instance v5, Landroid/text/format/Time;

    const-string v9, "UTC"

    invoke-direct {v5, v9}, Landroid/text/format/Time;-><init>(Ljava/lang/String;)V

    .line 158
    .local v5, time:Landroid/text/format/Time;
    add-int/lit16 v9, v8, 0x7d0

    iput v9, v5, Landroid/text/format/Time;->year:I

    .line 159
    add-int/lit8 v9, v3, -0x1

    iput v9, v5, Landroid/text/format/Time;->month:I

    .line 160
    iput v0, v5, Landroid/text/format/Time;->monthDay:I

    .line 161
    iput v1, v5, Landroid/text/format/Time;->hour:I

    .line 162
    iput v2, v5, Landroid/text/format/Time;->minute:I

    .line 163
    iput v4, v5, Landroid/text/format/Time;->second:I

    .line 166
    invoke-virtual {v5, v11}, Landroid/text/format/Time;->toMillis(Z)J

    move-result-wide v9

    mul-int/lit8 v11, v6, 0xf

    mul-int/lit8 v11, v11, 0x3c

    mul-int/lit16 v11, v11, 0x3e8

    int-to-long v11, v11

    sub-long/2addr v9, v11

    goto :goto_d

    .line 153
    .end local v5           #time:Landroid/text/format/Time;
    :cond_77
    neg-int v6, v6

    goto :goto_53
.end method

.method public getWarningType()I
    .registers 2

    .prologue
    .line 107
    iget v0, p0, Landroid/telephony/SmsCbEtwsInfo;->mWarningType:I

    return v0
.end method

.method public isEmergencyUserAlert()Z
    .registers 2

    .prologue
    .line 115
    iget-boolean v0, p0, Landroid/telephony/SmsCbEtwsInfo;->mEmergencyUserAlert:Z

    return v0
.end method

.method public isPopupAlert()Z
    .registers 2

    .prologue
    .line 123
    iget-boolean v0, p0, Landroid/telephony/SmsCbEtwsInfo;->mActivatePopup:Z

    return v0
.end method

.method public toString()Ljava/lang/String;
    .registers 3

    .prologue
    .line 183
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "SmsCbEtwsInfo{warningType="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Landroid/telephony/SmsCbEtwsInfo;->mWarningType:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", emergencyUserAlert="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Landroid/telephony/SmsCbEtwsInfo;->mEmergencyUserAlert:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", activatePopup="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Landroid/telephony/SmsCbEtwsInfo;->mActivatePopup:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0x7d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 6
    .parameter "dest"
    .parameter "flags"

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 96
    iget v0, p0, Landroid/telephony/SmsCbEtwsInfo;->mWarningType:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 97
    iget-boolean v0, p0, Landroid/telephony/SmsCbEtwsInfo;->mEmergencyUserAlert:Z

    if-eqz v0, :cond_1c

    move v0, v1

    :goto_c
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 98
    iget-boolean v0, p0, Landroid/telephony/SmsCbEtwsInfo;->mActivatePopup:Z

    if-eqz v0, :cond_1e

    :goto_13
    invoke-virtual {p1, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 99
    iget-object v0, p0, Landroid/telephony/SmsCbEtwsInfo;->mWarningSecurityInformation:[B

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeByteArray([B)V

    .line 100
    return-void

    :cond_1c
    move v0, v2

    .line 97
    goto :goto_c

    :cond_1e
    move v1, v2

    .line 98
    goto :goto_13
.end method
