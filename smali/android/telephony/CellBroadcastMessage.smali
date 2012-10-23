.class public Landroid/telephony/CellBroadcastMessage;
.super Ljava/lang/Object;
.source "CellBroadcastMessage.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator; = null
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Landroid/telephony/CellBroadcastMessage;",
            ">;"
        }
    .end annotation
.end field

.field public static final SMS_CB_MESSAGE_EXTRA:Ljava/lang/String; = "com.android.cellbroadcastreceiver.SMS_CB_MESSAGE"


# instance fields
.field private final mDeliveryTime:J

.field private mIsRead:Z

.field private final mSmsCbMessage:Landroid/telephony/SmsCbMessage;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 89
    new-instance v0, Landroid/telephony/CellBroadcastMessage$1;

    invoke-direct {v0}, Landroid/telephony/CellBroadcastMessage$1;-><init>()V

    sput-object v0, Landroid/telephony/CellBroadcastMessage;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method private constructor <init>(Landroid/os/Parcel;)V
    .registers 4
    .parameter "in"

    .prologue
    .line 72
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 73
    new-instance v0, Landroid/telephony/SmsCbMessage;

    invoke-direct {v0, p1}, Landroid/telephony/SmsCbMessage;-><init>(Landroid/os/Parcel;)V

    iput-object v0, p0, Landroid/telephony/CellBroadcastMessage;->mSmsCbMessage:Landroid/telephony/SmsCbMessage;

    .line 74
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Landroid/telephony/CellBroadcastMessage;->mDeliveryTime:J

    .line 75
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_1a

    const/4 v0, 0x1

    :goto_17
    iput-boolean v0, p0, Landroid/telephony/CellBroadcastMessage;->mIsRead:Z

    .line 76
    return-void

    .line 75
    :cond_1a
    const/4 v0, 0x0

    goto :goto_17
.end method

.method synthetic constructor <init>(Landroid/os/Parcel;Landroid/telephony/CellBroadcastMessage$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 48
    invoke-direct {p0, p1}, Landroid/telephony/CellBroadcastMessage;-><init>(Landroid/os/Parcel;)V

    return-void
.end method

.method public constructor <init>(Landroid/telephony/SmsCbMessage;)V
    .registers 4
    .parameter "message"

    .prologue
    .line 60
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 61
    iput-object p1, p0, Landroid/telephony/CellBroadcastMessage;->mSmsCbMessage:Landroid/telephony/SmsCbMessage;

    .line 62
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Landroid/telephony/CellBroadcastMessage;->mDeliveryTime:J

    .line 63
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/telephony/CellBroadcastMessage;->mIsRead:Z

    .line 64
    return-void
.end method

.method private constructor <init>(Landroid/telephony/SmsCbMessage;JZ)V
    .registers 5
    .parameter "message"
    .parameter "deliveryTime"
    .parameter "isRead"

    .prologue
    .line 66
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 67
    iput-object p1, p0, Landroid/telephony/CellBroadcastMessage;->mSmsCbMessage:Landroid/telephony/SmsCbMessage;

    .line 68
    iput-wide p2, p0, Landroid/telephony/CellBroadcastMessage;->mDeliveryTime:J

    .line 69
    iput-boolean p4, p0, Landroid/telephony/CellBroadcastMessage;->mIsRead:Z

    .line 70
    return-void
.end method

.method public static createFromCursor(Landroid/database/Cursor;)Landroid/telephony/CellBroadcastMessage;
    .registers 43
    .parameter "cursor"

    .prologue
    .line 107
    const-string v22, "geo_scope"

    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v22

    move-object/from16 v0, p0

    move/from16 v1, v22

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v14

    .line 109
    .local v14, geoScope:I
    const-string/jumbo v22, "serial_number"

    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v22

    move-object/from16 v0, p0

    move/from16 v1, v22

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v15

    .line 111
    .local v15, serialNum:I
    const-string/jumbo v22, "service_category"

    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v22

    move-object/from16 v0, p0

    move/from16 v1, v22

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v17

    .line 113
    .local v17, category:I
    const-string v22, "language"

    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v22

    move-object/from16 v0, p0

    move/from16 v1, v22

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v18

    .line 115
    .local v18, language:Ljava/lang/String;
    const-string v22, "body"

    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v22

    move-object/from16 v0, p0

    move/from16 v1, v22

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v19

    .line 117
    .local v19, body:Ljava/lang/String;
    const-string v22, "format"

    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v22

    move-object/from16 v0, p0

    move/from16 v1, v22

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v13

    .line 119
    .local v13, format:I
    const-string/jumbo v22, "priority"

    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v22

    move-object/from16 v0, p0

    move/from16 v1, v22

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v20

    .line 123
    .local v20, priority:I
    const-string/jumbo v22, "plmn"

    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v38

    .line 124
    .local v38, plmnColumn:I
    const/16 v22, -0x1

    move/from16 v0, v38

    move/from16 v1, v22

    if-eq v0, v1, :cond_24d

    move-object/from16 v0, p0

    move/from16 v1, v38

    invoke-interface {v0, v1}, Landroid/database/Cursor;->isNull(I)Z

    move-result v22

    if-nez v22, :cond_24d

    .line 125
    move-object/from16 v0, p0

    move/from16 v1, v38

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v37

    .line 131
    .local v37, plmn:Ljava/lang/String;
    :goto_a6
    const-string v22, "lac"

    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v36

    .line 132
    .local v36, lacColumn:I
    const/16 v22, -0x1

    move/from16 v0, v36

    move/from16 v1, v22

    if-eq v0, v1, :cond_251

    move-object/from16 v0, p0

    move/from16 v1, v36

    invoke-interface {v0, v1}, Landroid/database/Cursor;->isNull(I)Z

    move-result v22

    if-nez v22, :cond_251

    .line 133
    move-object/from16 v0, p0

    move/from16 v1, v36

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v35

    .line 139
    .local v35, lac:I
    :goto_ca
    const-string v22, "cid"

    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v24

    .line 140
    .local v24, cidColumn:I
    const/16 v22, -0x1

    move/from16 v0, v24

    move/from16 v1, v22

    if-eq v0, v1, :cond_255

    move-object/from16 v0, p0

    move/from16 v1, v24

    invoke-interface {v0, v1}, Landroid/database/Cursor;->isNull(I)Z

    move-result v22

    if-nez v22, :cond_255

    .line 141
    move-object/from16 v0, p0

    move/from16 v1, v24

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v23

    .line 146
    .local v23, cid:I
    :goto_ee
    new-instance v16, Landroid/telephony/SmsCbLocation;

    move-object/from16 v0, v16

    move-object/from16 v1, v37

    move/from16 v2, v35

    move/from16 v3, v23

    invoke-direct {v0, v1, v2, v3}, Landroid/telephony/SmsCbLocation;-><init>(Ljava/lang/String;II)V

    .line 149
    .local v16, location:Landroid/telephony/SmsCbLocation;
    const-string v22, "etws_warning_type"

    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v33

    .line 151
    .local v33, etwsWarningTypeColumn:I
    const/16 v22, -0x1

    move/from16 v0, v33

    move/from16 v1, v22

    if-eq v0, v1, :cond_259

    move-object/from16 v0, p0

    move/from16 v1, v33

    invoke-interface {v0, v1}, Landroid/database/Cursor;->isNull(I)Z

    move-result v22

    if-nez v22, :cond_259

    .line 152
    move-object/from16 v0, p0

    move/from16 v1, v33

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v39

    .line 153
    .local v39, warningType:I
    new-instance v21, Landroid/telephony/SmsCbEtwsInfo;

    const/16 v22, 0x0

    const/16 v40, 0x0

    const/16 v41, 0x0

    move-object/from16 v0, v21

    move/from16 v1, v39

    move/from16 v2, v22

    move/from16 v3, v40

    move-object/from16 v4, v41

    invoke-direct {v0, v1, v2, v3, v4}, Landroid/telephony/SmsCbEtwsInfo;-><init>(IZZ[B)V

    .line 159
    .end local v39           #warningType:I
    .local v21, etwsInfo:Landroid/telephony/SmsCbEtwsInfo;
    :goto_134
    const-string v22, "cmas_message_class"

    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v27

    .line 161
    .local v27, cmasMessageClassColumn:I
    const/16 v22, -0x1

    move/from16 v0, v27

    move/from16 v1, v22

    if-eq v0, v1, :cond_26a

    move-object/from16 v0, p0

    move/from16 v1, v27

    invoke-interface {v0, v1}, Landroid/database/Cursor;->isNull(I)Z

    move-result v22

    if-nez v22, :cond_26a

    .line 162
    move-object/from16 v0, p0

    move/from16 v1, v27

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v6

    .line 165
    .local v6, messageClass:I
    const-string v22, "cmas_category"

    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v25

    .line 167
    .local v25, cmasCategoryColumn:I
    const/16 v22, -0x1

    move/from16 v0, v25

    move/from16 v1, v22

    if-eq v0, v1, :cond_25d

    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-interface {v0, v1}, Landroid/database/Cursor;->isNull(I)Z

    move-result v22

    if-nez v22, :cond_25d

    .line 168
    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v7

    .line 174
    .local v7, cmasCategory:I
    :goto_17c
    const-string v22, "cmas_response_type"

    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v28

    .line 176
    .local v28, cmasResponseTypeColumn:I
    const/16 v22, -0x1

    move/from16 v0, v28

    move/from16 v1, v22

    if-eq v0, v1, :cond_260

    move-object/from16 v0, p0

    move/from16 v1, v28

    invoke-interface {v0, v1}, Landroid/database/Cursor;->isNull(I)Z

    move-result v22

    if-nez v22, :cond_260

    .line 177
    move-object/from16 v0, p0

    move/from16 v1, v28

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v8

    .line 183
    .local v8, responseType:I
    :goto_1a0
    const-string v22, "cmas_severity"

    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v29

    .line 185
    .local v29, cmasSeverityColumn:I
    const/16 v22, -0x1

    move/from16 v0, v29

    move/from16 v1, v22

    if-eq v0, v1, :cond_263

    move-object/from16 v0, p0

    move/from16 v1, v29

    invoke-interface {v0, v1}, Landroid/database/Cursor;->isNull(I)Z

    move-result v22

    if-nez v22, :cond_263

    .line 186
    move-object/from16 v0, p0

    move/from16 v1, v29

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v9

    .line 192
    .local v9, severity:I
    :goto_1c4
    const-string v22, "cmas_urgency"

    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v30

    .line 194
    .local v30, cmasUrgencyColumn:I
    const/16 v22, -0x1

    move/from16 v0, v30

    move/from16 v1, v22

    if-eq v0, v1, :cond_266

    move-object/from16 v0, p0

    move/from16 v1, v30

    invoke-interface {v0, v1}, Landroid/database/Cursor;->isNull(I)Z

    move-result v22

    if-nez v22, :cond_266

    .line 195
    move-object/from16 v0, p0

    move/from16 v1, v30

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v10

    .line 201
    .local v10, urgency:I
    :goto_1e8
    const-string v22, "cmas_certainty"

    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v26

    .line 203
    .local v26, cmasCertaintyColumn:I
    const/16 v22, -0x1

    move/from16 v0, v26

    move/from16 v1, v22

    if-eq v0, v1, :cond_268

    move-object/from16 v0, p0

    move/from16 v1, v26

    invoke-interface {v0, v1}, Landroid/database/Cursor;->isNull(I)Z

    move-result v22

    if-nez v22, :cond_268

    .line 204
    move-object/from16 v0, p0

    move/from16 v1, v26

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v11

    .line 209
    .local v11, certainty:I
    :goto_20c
    new-instance v5, Landroid/telephony/SmsCbCmasInfo;

    invoke-direct/range {v5 .. v11}, Landroid/telephony/SmsCbCmasInfo;-><init>(IIIIII)V

    .line 215
    .end local v6           #messageClass:I
    .end local v7           #cmasCategory:I
    .end local v8           #responseType:I
    .end local v9           #severity:I
    .end local v10           #urgency:I
    .end local v11           #certainty:I
    .end local v25           #cmasCategoryColumn:I
    .end local v26           #cmasCertaintyColumn:I
    .end local v28           #cmasResponseTypeColumn:I
    .end local v29           #cmasSeverityColumn:I
    .end local v30           #cmasUrgencyColumn:I
    .local v5, cmasInfo:Landroid/telephony/SmsCbCmasInfo;
    :goto_211
    new-instance v12, Landroid/telephony/SmsCbMessage;

    move-object/from16 v22, v5

    invoke-direct/range {v12 .. v22}, Landroid/telephony/SmsCbMessage;-><init>(IIILandroid/telephony/SmsCbLocation;ILjava/lang/String;Ljava/lang/String;ILandroid/telephony/SmsCbEtwsInfo;Landroid/telephony/SmsCbCmasInfo;)V

    .line 218
    .local v12, msg:Landroid/telephony/SmsCbMessage;
    const-string v22, "date"

    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v22

    move-object/from16 v0, p0

    move/from16 v1, v22

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v31

    .line 220
    .local v31, deliveryTime:J
    const-string/jumbo v22, "read"

    move-object/from16 v0, p0

    move-object/from16 v1, v22

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v22

    move-object/from16 v0, p0

    move/from16 v1, v22

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v22

    if-eqz v22, :cond_26c

    const/16 v34, 0x1

    .line 223
    .local v34, isRead:Z
    :goto_241
    new-instance v22, Landroid/telephony/CellBroadcastMessage;

    move-object/from16 v0, v22

    move-wide/from16 v1, v31

    move/from16 v3, v34

    invoke-direct {v0, v12, v1, v2, v3}, Landroid/telephony/CellBroadcastMessage;-><init>(Landroid/telephony/SmsCbMessage;JZ)V

    return-object v22

    .line 127
    .end local v5           #cmasInfo:Landroid/telephony/SmsCbCmasInfo;
    .end local v12           #msg:Landroid/telephony/SmsCbMessage;
    .end local v16           #location:Landroid/telephony/SmsCbLocation;
    .end local v21           #etwsInfo:Landroid/telephony/SmsCbEtwsInfo;
    .end local v23           #cid:I
    .end local v24           #cidColumn:I
    .end local v27           #cmasMessageClassColumn:I
    .end local v31           #deliveryTime:J
    .end local v33           #etwsWarningTypeColumn:I
    .end local v34           #isRead:Z
    .end local v35           #lac:I
    .end local v36           #lacColumn:I
    .end local v37           #plmn:Ljava/lang/String;
    :cond_24d
    const/16 v37, 0x0

    .restart local v37       #plmn:Ljava/lang/String;
    goto/16 :goto_a6

    .line 135
    .restart local v36       #lacColumn:I
    :cond_251
    const/16 v35, -0x1

    .restart local v35       #lac:I
    goto/16 :goto_ca

    .line 143
    .restart local v24       #cidColumn:I
    :cond_255
    const/16 v23, -0x1

    .restart local v23       #cid:I
    goto/16 :goto_ee

    .line 155
    .restart local v16       #location:Landroid/telephony/SmsCbLocation;
    .restart local v33       #etwsWarningTypeColumn:I
    :cond_259
    const/16 v21, 0x0

    .restart local v21       #etwsInfo:Landroid/telephony/SmsCbEtwsInfo;
    goto/16 :goto_134

    .line 170
    .restart local v6       #messageClass:I
    .restart local v25       #cmasCategoryColumn:I
    .restart local v27       #cmasMessageClassColumn:I
    :cond_25d
    const/4 v7, -0x1

    .restart local v7       #cmasCategory:I
    goto/16 :goto_17c

    .line 179
    .restart local v28       #cmasResponseTypeColumn:I
    :cond_260
    const/4 v8, -0x1

    .restart local v8       #responseType:I
    goto/16 :goto_1a0

    .line 188
    .restart local v29       #cmasSeverityColumn:I
    :cond_263
    const/4 v9, -0x1

    .restart local v9       #severity:I
    goto/16 :goto_1c4

    .line 197
    .restart local v30       #cmasUrgencyColumn:I
    :cond_266
    const/4 v10, -0x1

    .restart local v10       #urgency:I
    goto :goto_1e8

    .line 206
    .restart local v26       #cmasCertaintyColumn:I
    :cond_268
    const/4 v11, -0x1

    .restart local v11       #certainty:I
    goto :goto_20c

    .line 212
    .end local v6           #messageClass:I
    .end local v7           #cmasCategory:I
    .end local v8           #responseType:I
    .end local v9           #severity:I
    .end local v10           #urgency:I
    .end local v11           #certainty:I
    .end local v25           #cmasCategoryColumn:I
    .end local v26           #cmasCertaintyColumn:I
    .end local v28           #cmasResponseTypeColumn:I
    .end local v29           #cmasSeverityColumn:I
    .end local v30           #cmasUrgencyColumn:I
    :cond_26a
    const/4 v5, 0x0

    .restart local v5       #cmasInfo:Landroid/telephony/SmsCbCmasInfo;
    goto :goto_211

    .line 220
    .restart local v12       #msg:Landroid/telephony/SmsCbMessage;
    .restart local v31       #deliveryTime:J
    :cond_26c
    const/16 v34, 0x0

    goto :goto_241
.end method


# virtual methods
.method public describeContents()I
    .registers 2

    .prologue
    .line 80
    const/4 v0, 0x0

    return v0
.end method

.method public getCmasMessageClass()I
    .registers 2

    .prologue
    .line 364
    iget-object v0, p0, Landroid/telephony/CellBroadcastMessage;->mSmsCbMessage:Landroid/telephony/SmsCbMessage;

    invoke-virtual {v0}, Landroid/telephony/SmsCbMessage;->isCmasMessage()Z

    move-result v0

    if-eqz v0, :cond_13

    .line 365
    iget-object v0, p0, Landroid/telephony/CellBroadcastMessage;->mSmsCbMessage:Landroid/telephony/SmsCbMessage;

    invoke-virtual {v0}, Landroid/telephony/SmsCbMessage;->getCmasWarningInfo()Landroid/telephony/SmsCbCmasInfo;

    move-result-object v0

    invoke-virtual {v0}, Landroid/telephony/SmsCbCmasInfo;->getMessageClass()I

    move-result v0

    .line 367
    :goto_12
    return v0

    :cond_13
    const/4 v0, -0x1

    goto :goto_12
.end method

.method public getCmasWarningInfo()Landroid/telephony/SmsCbCmasInfo;
    .registers 2

    .prologue
    .line 304
    iget-object v0, p0, Landroid/telephony/CellBroadcastMessage;->mSmsCbMessage:Landroid/telephony/SmsCbMessage;

    invoke-virtual {v0}, Landroid/telephony/SmsCbMessage;->getCmasWarningInfo()Landroid/telephony/SmsCbCmasInfo;

    move-result-object v0

    return-object v0
.end method

.method public getContentValues()Landroid/content/ContentValues;
    .registers 9

    .prologue
    const/4 v7, -0x1

    .line 231
    new-instance v1, Landroid/content/ContentValues;

    const/16 v5, 0x10

    invoke-direct {v1, v5}, Landroid/content/ContentValues;-><init>(I)V

    .line 232
    .local v1, cv:Landroid/content/ContentValues;
    iget-object v4, p0, Landroid/telephony/CellBroadcastMessage;->mSmsCbMessage:Landroid/telephony/SmsCbMessage;

    .line 233
    .local v4, msg:Landroid/telephony/SmsCbMessage;
    const-string v5, "geo_scope"

    invoke-virtual {v4}, Landroid/telephony/SmsCbMessage;->getGeographicalScope()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v1, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 234
    invoke-virtual {v4}, Landroid/telephony/SmsCbMessage;->getLocation()Landroid/telephony/SmsCbLocation;

    move-result-object v3

    .line 235
    .local v3, location:Landroid/telephony/SmsCbLocation;
    invoke-virtual {v3}, Landroid/telephony/SmsCbLocation;->getPlmn()Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_2b

    .line 236
    const-string/jumbo v5, "plmn"

    invoke-virtual {v3}, Landroid/telephony/SmsCbLocation;->getPlmn()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v1, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 238
    :cond_2b
    invoke-virtual {v3}, Landroid/telephony/SmsCbLocation;->getLac()I

    move-result v5

    if-eq v5, v7, :cond_3e

    .line 239
    const-string v5, "lac"

    invoke-virtual {v3}, Landroid/telephony/SmsCbLocation;->getLac()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v1, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 241
    :cond_3e
    invoke-virtual {v3}, Landroid/telephony/SmsCbLocation;->getCid()I

    move-result v5

    if-eq v5, v7, :cond_51

    .line 242
    const-string v5, "cid"

    invoke-virtual {v3}, Landroid/telephony/SmsCbLocation;->getCid()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v1, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 244
    :cond_51
    const-string/jumbo v5, "serial_number"

    invoke-virtual {v4}, Landroid/telephony/SmsCbMessage;->getSerialNumber()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v1, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 245
    const-string/jumbo v5, "service_category"

    invoke-virtual {v4}, Landroid/telephony/SmsCbMessage;->getServiceCategory()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v1, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 246
    const-string v5, "language"

    invoke-virtual {v4}, Landroid/telephony/SmsCbMessage;->getLanguageCode()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v1, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 247
    const-string v5, "body"

    invoke-virtual {v4}, Landroid/telephony/SmsCbMessage;->getMessageBody()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v1, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 248
    const-string v5, "date"

    iget-wide v6, p0, Landroid/telephony/CellBroadcastMessage;->mDeliveryTime:J

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-virtual {v1, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 249
    const-string/jumbo v5, "read"

    iget-boolean v6, p0, Landroid/telephony/CellBroadcastMessage;->mIsRead:Z

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    invoke-virtual {v1, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 250
    const-string v5, "format"

    invoke-virtual {v4}, Landroid/telephony/SmsCbMessage;->getMessageFormat()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v1, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 251
    const-string/jumbo v5, "priority"

    invoke-virtual {v4}, Landroid/telephony/SmsCbMessage;->getMessagePriority()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v1, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 253
    iget-object v5, p0, Landroid/telephony/CellBroadcastMessage;->mSmsCbMessage:Landroid/telephony/SmsCbMessage;

    invoke-virtual {v5}, Landroid/telephony/SmsCbMessage;->getEtwsWarningInfo()Landroid/telephony/SmsCbEtwsInfo;

    move-result-object v2

    .line 254
    .local v2, etwsInfo:Landroid/telephony/SmsCbEtwsInfo;
    if-eqz v2, :cond_c6

    .line 255
    const-string v5, "etws_warning_type"

    invoke-virtual {v2}, Landroid/telephony/SmsCbEtwsInfo;->getWarningType()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v1, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 258
    :cond_c6
    iget-object v5, p0, Landroid/telephony/CellBroadcastMessage;->mSmsCbMessage:Landroid/telephony/SmsCbMessage;

    invoke-virtual {v5}, Landroid/telephony/SmsCbMessage;->getCmasWarningInfo()Landroid/telephony/SmsCbCmasInfo;

    move-result-object v0

    .line 259
    .local v0, cmasInfo:Landroid/telephony/SmsCbCmasInfo;
    if-eqz v0, :cond_11c

    .line 260
    const-string v5, "cmas_message_class"

    invoke-virtual {v0}, Landroid/telephony/SmsCbCmasInfo;->getMessageClass()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v1, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 261
    const-string v5, "cmas_category"

    invoke-virtual {v0}, Landroid/telephony/SmsCbCmasInfo;->getCategory()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v1, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 262
    const-string v5, "cmas_response_type"

    invoke-virtual {v0}, Landroid/telephony/SmsCbCmasInfo;->getResponseType()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v1, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 263
    const-string v5, "cmas_severity"

    invoke-virtual {v0}, Landroid/telephony/SmsCbCmasInfo;->getSeverity()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v1, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 264
    const-string v5, "cmas_urgency"

    invoke-virtual {v0}, Landroid/telephony/SmsCbCmasInfo;->getUrgency()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v1, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 265
    const-string v5, "cmas_certainty"

    invoke-virtual {v0}, Landroid/telephony/SmsCbCmasInfo;->getCertainty()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v1, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 268
    :cond_11c
    return-object v1
.end method

.method public getDateString(Landroid/content/Context;)Ljava/lang/String;
    .registers 5
    .parameter "context"

    .prologue
    .line 407
    const v0, 0x80b11

    .line 410
    .local v0, flags:I
    iget-wide v1, p0, Landroid/telephony/CellBroadcastMessage;->mDeliveryTime:J

    invoke-static {p1, v1, v2, v0}, Landroid/text/format/DateUtils;->formatDateTime(Landroid/content/Context;JI)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public getDeliveryTime()J
    .registers 3

    .prologue
    .line 288
    iget-wide v0, p0, Landroid/telephony/CellBroadcastMessage;->mDeliveryTime:J

    return-wide v0
.end method

.method public getEtwsWarningInfo()Landroid/telephony/SmsCbEtwsInfo;
    .registers 2

    .prologue
    .line 308
    iget-object v0, p0, Landroid/telephony/CellBroadcastMessage;->mSmsCbMessage:Landroid/telephony/SmsCbMessage;

    invoke-virtual {v0}, Landroid/telephony/SmsCbMessage;->getEtwsWarningInfo()Landroid/telephony/SmsCbEtwsInfo;

    move-result-object v0

    return-object v0
.end method

.method public getLanguageCode()Ljava/lang/String;
    .registers 2

    .prologue
    .line 280
    iget-object v0, p0, Landroid/telephony/CellBroadcastMessage;->mSmsCbMessage:Landroid/telephony/SmsCbMessage;

    invoke-virtual {v0}, Landroid/telephony/SmsCbMessage;->getLanguageCode()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getMessageBody()Ljava/lang/String;
    .registers 2

    .prologue
    .line 292
    iget-object v0, p0, Landroid/telephony/CellBroadcastMessage;->mSmsCbMessage:Landroid/telephony/SmsCbMessage;

    invoke-virtual {v0}, Landroid/telephony/SmsCbMessage;->getMessageBody()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getSerialNumber()I
    .registers 2

    .prologue
    .line 300
    iget-object v0, p0, Landroid/telephony/CellBroadcastMessage;->mSmsCbMessage:Landroid/telephony/SmsCbMessage;

    invoke-virtual {v0}, Landroid/telephony/SmsCbMessage;->getSerialNumber()I

    move-result v0

    return v0
.end method

.method public getServiceCategory()I
    .registers 2

    .prologue
    .line 284
    iget-object v0, p0, Landroid/telephony/CellBroadcastMessage;->mSmsCbMessage:Landroid/telephony/SmsCbMessage;

    invoke-virtual {v0}, Landroid/telephony/SmsCbMessage;->getServiceCategory()I

    move-result v0

    return v0
.end method

.method public getSpokenDateString(Landroid/content/Context;)Ljava/lang/String;
    .registers 5
    .parameter "context"

    .prologue
    .line 419
    const/16 v0, 0x11

    .line 420
    .local v0, flags:I
    iget-wide v1, p0, Landroid/telephony/CellBroadcastMessage;->mDeliveryTime:J

    invoke-static {p1, v1, v2, v0}, Landroid/text/format/DateUtils;->formatDateTime(Landroid/content/Context;JI)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public isCmasMessage()Z
    .registers 2

    .prologue
    .line 355
    iget-object v0, p0, Landroid/telephony/CellBroadcastMessage;->mSmsCbMessage:Landroid/telephony/SmsCbMessage;

    invoke-virtual {v0}, Landroid/telephony/SmsCbMessage;->isCmasMessage()Z

    move-result v0

    return v0
.end method

.method public isEmergencyAlertMessage()Z
    .registers 5

    .prologue
    const/4 v1, 0x0

    .line 331
    iget-object v2, p0, Landroid/telephony/CellBroadcastMessage;->mSmsCbMessage:Landroid/telephony/SmsCbMessage;

    invoke-virtual {v2}, Landroid/telephony/SmsCbMessage;->isEmergencyMessage()Z

    move-result v2

    if-nez v2, :cond_a

    .line 339
    :cond_9
    :goto_9
    return v1

    .line 334
    :cond_a
    iget-object v2, p0, Landroid/telephony/CellBroadcastMessage;->mSmsCbMessage:Landroid/telephony/SmsCbMessage;

    invoke-virtual {v2}, Landroid/telephony/SmsCbMessage;->getCmasWarningInfo()Landroid/telephony/SmsCbCmasInfo;

    move-result-object v0

    .line 335
    .local v0, cmasInfo:Landroid/telephony/SmsCbCmasInfo;
    if-eqz v0, :cond_19

    invoke-virtual {v0}, Landroid/telephony/SmsCbCmasInfo;->getMessageClass()I

    move-result v2

    const/4 v3, 0x3

    if-eq v2, v3, :cond_9

    .line 339
    :cond_19
    const/4 v1, 0x1

    goto :goto_9
.end method

.method public isEtwsEmergencyUserAlert()Z
    .registers 3

    .prologue
    .line 387
    iget-object v1, p0, Landroid/telephony/CellBroadcastMessage;->mSmsCbMessage:Landroid/telephony/SmsCbMessage;

    invoke-virtual {v1}, Landroid/telephony/SmsCbMessage;->getEtwsWarningInfo()Landroid/telephony/SmsCbEtwsInfo;

    move-result-object v0

    .line 388
    .local v0, etwsInfo:Landroid/telephony/SmsCbEtwsInfo;
    if-eqz v0, :cond_10

    invoke-virtual {v0}, Landroid/telephony/SmsCbEtwsInfo;->isEmergencyUserAlert()Z

    move-result v1

    if-eqz v1, :cond_10

    const/4 v1, 0x1

    :goto_f
    return v1

    :cond_10
    const/4 v1, 0x0

    goto :goto_f
.end method

.method public isEtwsMessage()Z
    .registers 2

    .prologue
    .line 347
    iget-object v0, p0, Landroid/telephony/CellBroadcastMessage;->mSmsCbMessage:Landroid/telephony/SmsCbMessage;

    invoke-virtual {v0}, Landroid/telephony/SmsCbMessage;->isEtwsMessage()Z

    move-result v0

    return v0
.end method

.method public isEtwsPopupAlert()Z
    .registers 3

    .prologue
    .line 377
    iget-object v1, p0, Landroid/telephony/CellBroadcastMessage;->mSmsCbMessage:Landroid/telephony/SmsCbMessage;

    invoke-virtual {v1}, Landroid/telephony/SmsCbMessage;->getEtwsWarningInfo()Landroid/telephony/SmsCbEtwsInfo;

    move-result-object v0

    .line 378
    .local v0, etwsInfo:Landroid/telephony/SmsCbEtwsInfo;
    if-eqz v0, :cond_10

    invoke-virtual {v0}, Landroid/telephony/SmsCbEtwsInfo;->isPopupAlert()Z

    move-result v1

    if-eqz v1, :cond_10

    const/4 v1, 0x1

    :goto_f
    return v1

    :cond_10
    const/4 v1, 0x0

    goto :goto_f
.end method

.method public isEtwsTestMessage()Z
    .registers 4

    .prologue
    .line 396
    iget-object v1, p0, Landroid/telephony/CellBroadcastMessage;->mSmsCbMessage:Landroid/telephony/SmsCbMessage;

    invoke-virtual {v1}, Landroid/telephony/SmsCbMessage;->getEtwsWarningInfo()Landroid/telephony/SmsCbEtwsInfo;

    move-result-object v0

    .line 397
    .local v0, etwsInfo:Landroid/telephony/SmsCbEtwsInfo;
    if-eqz v0, :cond_11

    invoke-virtual {v0}, Landroid/telephony/SmsCbEtwsInfo;->getWarningType()I

    move-result v1

    const/4 v2, 0x3

    if-ne v1, v2, :cond_11

    const/4 v1, 0x1

    :goto_10
    return v1

    :cond_11
    const/4 v1, 0x0

    goto :goto_10
.end method

.method public isPublicAlertMessage()Z
    .registers 2

    .prologue
    .line 321
    iget-object v0, p0, Landroid/telephony/CellBroadcastMessage;->mSmsCbMessage:Landroid/telephony/SmsCbMessage;

    invoke-virtual {v0}, Landroid/telephony/SmsCbMessage;->isEmergencyMessage()Z

    move-result v0

    return v0
.end method

.method public isRead()Z
    .registers 2

    .prologue
    .line 296
    iget-boolean v0, p0, Landroid/telephony/CellBroadcastMessage;->mIsRead:Z

    return v0
.end method

.method public setIsRead(Z)V
    .registers 2
    .parameter "isRead"

    .prologue
    .line 276
    iput-boolean p1, p0, Landroid/telephony/CellBroadcastMessage;->mIsRead:Z

    .line 277
    return-void
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 5
    .parameter "out"
    .parameter "flags"

    .prologue
    .line 84
    iget-object v0, p0, Landroid/telephony/CellBroadcastMessage;->mSmsCbMessage:Landroid/telephony/SmsCbMessage;

    invoke-virtual {v0, p1, p2}, Landroid/telephony/SmsCbMessage;->writeToParcel(Landroid/os/Parcel;I)V

    .line 85
    iget-wide v0, p0, Landroid/telephony/CellBroadcastMessage;->mDeliveryTime:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 86
    iget-boolean v0, p0, Landroid/telephony/CellBroadcastMessage;->mIsRead:Z

    if-eqz v0, :cond_13

    const/4 v0, 0x1

    :goto_f
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 87
    return-void

    .line 86
    :cond_13
    const/4 v0, 0x0

    goto :goto_f
.end method
