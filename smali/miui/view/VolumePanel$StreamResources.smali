.class final enum Lmiui/view/VolumePanel$StreamResources;
.super Ljava/lang/Enum;
.source "VolumePanel.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/view/VolumePanel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "StreamResources"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lmiui/view/VolumePanel$StreamResources;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lmiui/view/VolumePanel$StreamResources;

.field public static final enum AlarmStream:Lmiui/view/VolumePanel$StreamResources;

.field public static final enum BluetoothSCOStream:Lmiui/view/VolumePanel$StreamResources;

.field public static final enum MasterStream:Lmiui/view/VolumePanel$StreamResources;

.field public static final enum MediaStream:Lmiui/view/VolumePanel$StreamResources;

.field public static final enum NotificationStream:Lmiui/view/VolumePanel$StreamResources;

.field public static final enum RemoteStream:Lmiui/view/VolumePanel$StreamResources;

.field public static final enum RingerStream:Lmiui/view/VolumePanel$StreamResources;

.field public static final enum VoiceStream:Lmiui/view/VolumePanel$StreamResources;


# instance fields
.field descRes:I

.field iconMuteRes:I

.field iconRes:I

.field show:Z

.field streamType:I


# direct methods
.method static constructor <clinit>()V
    .registers 15

    .prologue
    const/4 v14, 0x3

    const/4 v13, 0x2

    const/4 v12, 0x1

    const v11, 0x60201f9

    const/4 v2, 0x0

    .line 135
    new-instance v0, Lmiui/view/VolumePanel$StreamResources;

    const-string v1, "BluetoothSCOStream"

    const/4 v3, 0x6

    const v4, 0x60c01a1

    const v5, 0x6020156

    const v6, 0x6020156

    move v7, v2

    invoke-direct/range {v0 .. v7}, Lmiui/view/VolumePanel$StreamResources;-><init>(Ljava/lang/String;IIIIIZ)V

    sput-object v0, Lmiui/view/VolumePanel$StreamResources;->BluetoothSCOStream:Lmiui/view/VolumePanel$StreamResources;

    .line 140
    new-instance v3, Lmiui/view/VolumePanel$StreamResources;

    const-string v4, "RingerStream"

    const v7, 0x60c01a2

    const v8, 0x602015b

    const v9, 0x602015c

    move v5, v12

    move v6, v13

    move v10, v2

    invoke-direct/range {v3 .. v10}, Lmiui/view/VolumePanel$StreamResources;-><init>(Ljava/lang/String;IIIIIZ)V

    sput-object v3, Lmiui/view/VolumePanel$StreamResources;->RingerStream:Lmiui/view/VolumePanel$StreamResources;

    .line 145
    new-instance v3, Lmiui/view/VolumePanel$StreamResources;

    const-string v4, "VoiceStream"

    const v7, 0x60c01a3

    const v8, 0x602015a

    const v9, 0x602015a

    move v5, v13

    move v6, v2

    move v10, v2

    invoke-direct/range {v3 .. v10}, Lmiui/view/VolumePanel$StreamResources;-><init>(Ljava/lang/String;IIIIIZ)V

    sput-object v3, Lmiui/view/VolumePanel$StreamResources;->VoiceStream:Lmiui/view/VolumePanel$StreamResources;

    .line 150
    new-instance v3, Lmiui/view/VolumePanel$StreamResources;

    const-string v4, "AlarmStream"

    const/4 v6, 0x4

    const v7, 0x60c01a6

    const v8, 0x6020154

    const v9, 0x6020155

    move v5, v14

    move v10, v2

    invoke-direct/range {v3 .. v10}, Lmiui/view/VolumePanel$StreamResources;-><init>(Ljava/lang/String;IIIIIZ)V

    sput-object v3, Lmiui/view/VolumePanel$StreamResources;->AlarmStream:Lmiui/view/VolumePanel$StreamResources;

    .line 155
    new-instance v3, Lmiui/view/VolumePanel$StreamResources;

    const-string v4, "MediaStream"

    const/4 v5, 0x4

    const v7, 0x60c01a4

    move v6, v14

    move v8, v11

    move v9, v11

    move v10, v12

    invoke-direct/range {v3 .. v10}, Lmiui/view/VolumePanel$StreamResources;-><init>(Ljava/lang/String;IIIIIZ)V

    sput-object v3, Lmiui/view/VolumePanel$StreamResources;->MediaStream:Lmiui/view/VolumePanel$StreamResources;

    .line 160
    new-instance v3, Lmiui/view/VolumePanel$StreamResources;

    const-string v4, "NotificationStream"

    const/4 v5, 0x5

    const/4 v6, 0x5

    const v7, 0x60c01a5

    const v8, 0x6020158

    const v9, 0x6020159

    move v10, v12

    invoke-direct/range {v3 .. v10}, Lmiui/view/VolumePanel$StreamResources;-><init>(Ljava/lang/String;IIIIIZ)V

    sput-object v3, Lmiui/view/VolumePanel$StreamResources;->NotificationStream:Lmiui/view/VolumePanel$StreamResources;

    .line 166
    new-instance v3, Lmiui/view/VolumePanel$StreamResources;

    const-string v4, "MasterStream"

    const/4 v5, 0x6

    const/16 v6, -0x64

    const v7, 0x60c01a4

    move v8, v11

    move v9, v11

    move v10, v2

    invoke-direct/range {v3 .. v10}, Lmiui/view/VolumePanel$StreamResources;-><init>(Ljava/lang/String;IIIIIZ)V

    sput-object v3, Lmiui/view/VolumePanel$StreamResources;->MasterStream:Lmiui/view/VolumePanel$StreamResources;

    .line 171
    new-instance v3, Lmiui/view/VolumePanel$StreamResources;

    const-string v4, "RemoteStream"

    const/4 v5, 0x7

    const/16 v6, -0xc8

    const v7, 0x60c01a4

    move v8, v11

    move v9, v11

    move v10, v2

    invoke-direct/range {v3 .. v10}, Lmiui/view/VolumePanel$StreamResources;-><init>(Ljava/lang/String;IIIIIZ)V

    sput-object v3, Lmiui/view/VolumePanel$StreamResources;->RemoteStream:Lmiui/view/VolumePanel$StreamResources;

    .line 134
    const/16 v0, 0x8

    new-array v0, v0, [Lmiui/view/VolumePanel$StreamResources;

    sget-object v1, Lmiui/view/VolumePanel$StreamResources;->BluetoothSCOStream:Lmiui/view/VolumePanel$StreamResources;

    aput-object v1, v0, v2

    sget-object v1, Lmiui/view/VolumePanel$StreamResources;->RingerStream:Lmiui/view/VolumePanel$StreamResources;

    aput-object v1, v0, v12

    sget-object v1, Lmiui/view/VolumePanel$StreamResources;->VoiceStream:Lmiui/view/VolumePanel$StreamResources;

    aput-object v1, v0, v13

    sget-object v1, Lmiui/view/VolumePanel$StreamResources;->AlarmStream:Lmiui/view/VolumePanel$StreamResources;

    aput-object v1, v0, v14

    const/4 v1, 0x4

    sget-object v2, Lmiui/view/VolumePanel$StreamResources;->MediaStream:Lmiui/view/VolumePanel$StreamResources;

    aput-object v2, v0, v1

    const/4 v1, 0x5

    sget-object v2, Lmiui/view/VolumePanel$StreamResources;->NotificationStream:Lmiui/view/VolumePanel$StreamResources;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lmiui/view/VolumePanel$StreamResources;->MasterStream:Lmiui/view/VolumePanel$StreamResources;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lmiui/view/VolumePanel$StreamResources;->RemoteStream:Lmiui/view/VolumePanel$StreamResources;

    aput-object v2, v0, v1

    sput-object v0, Lmiui/view/VolumePanel$StreamResources;->$VALUES:[Lmiui/view/VolumePanel$StreamResources;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;IIIIIZ)V
    .registers 8
    .parameter
    .parameter
    .parameter "streamType"
    .parameter "descRes"
    .parameter "iconRes"
    .parameter "iconMuteRes"
    .parameter "show"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(IIIIZ)V"
        }
    .end annotation

    .prologue
    .line 184
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 185
    iput p3, p0, Lmiui/view/VolumePanel$StreamResources;->streamType:I

    .line 186
    iput p4, p0, Lmiui/view/VolumePanel$StreamResources;->descRes:I

    .line 187
    iput p5, p0, Lmiui/view/VolumePanel$StreamResources;->iconRes:I

    .line 188
    iput p6, p0, Lmiui/view/VolumePanel$StreamResources;->iconMuteRes:I

    .line 189
    iput-boolean p7, p0, Lmiui/view/VolumePanel$StreamResources;->show:Z

    .line 190
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lmiui/view/VolumePanel$StreamResources;
    .registers 2
    .parameter "name"

    .prologue
    .line 134
    const-class v0, Lmiui/view/VolumePanel$StreamResources;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lmiui/view/VolumePanel$StreamResources;

    return-object v0
.end method

.method public static values()[Lmiui/view/VolumePanel$StreamResources;
    .registers 1

    .prologue
    .line 134
    sget-object v0, Lmiui/view/VolumePanel$StreamResources;->$VALUES:[Lmiui/view/VolumePanel$StreamResources;

    invoke-virtual {v0}, [Lmiui/view/VolumePanel$StreamResources;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lmiui/view/VolumePanel$StreamResources;

    return-object v0
.end method
