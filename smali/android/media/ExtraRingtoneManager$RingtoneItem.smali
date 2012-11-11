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
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Landroid/media/ExtraRingtoneManager$RingtoneItem;->mRingtoneType:I

    iput-object p2, p0, Landroid/media/ExtraRingtoneManager$RingtoneItem;->mActualDefaultRingtoneUri:Landroid/net/Uri;

    iput-object p3, p0, Landroid/media/ExtraRingtoneManager$RingtoneItem;->mDefaultRingtoneUri:Landroid/net/Uri;

    iput-object p4, p0, Landroid/media/ExtraRingtoneManager$RingtoneItem;->mSettingType:Ljava/lang/String;

    return-void
.end method
