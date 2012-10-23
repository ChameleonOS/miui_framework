.class Landroid/media/ExtraRingtoneManager$RingtoneItem;
.super Ljava/lang/Object;
.source "ExtraRingtoneManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/media/ExtraRingtoneManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "RingtoneItem"
.end annotation


# instance fields
.field mActualDefaultRingtoneUri:Landroid/net/Uri;

.field mDefaultRingtoneUri:Landroid/net/Uri;

.field mRingtoneType:I

.field mSettingType:Ljava/lang/String;


# direct methods
.method public constructor <init>(ILandroid/net/Uri;Landroid/net/Uri;Ljava/lang/String;)V
    .registers 5
    .parameter "ringtoneType"
    .parameter "actualDefaultRingtoneUri"
    .parameter "defaultRingtoneUri"
    .parameter "settingType"

    .prologue
    .line 185
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 186
    iput p1, p0, Landroid/media/ExtraRingtoneManager$RingtoneItem;->mRingtoneType:I

    .line 187
    iput-object p2, p0, Landroid/media/ExtraRingtoneManager$RingtoneItem;->mActualDefaultRingtoneUri:Landroid/net/Uri;

    .line 188
    iput-object p3, p0, Landroid/media/ExtraRingtoneManager$RingtoneItem;->mDefaultRingtoneUri:Landroid/net/Uri;

    .line 189
    iput-object p4, p0, Landroid/media/ExtraRingtoneManager$RingtoneItem;->mSettingType:Ljava/lang/String;

    .line 190
    return-void
.end method
