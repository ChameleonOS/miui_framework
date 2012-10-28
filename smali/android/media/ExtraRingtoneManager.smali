.class public Landroid/media/ExtraRingtoneManager;
.super Ljava/lang/Object;
.source "ExtraRingtoneManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/media/ExtraRingtoneManager$RingtoneItem;
    }
.end annotation


# static fields
.field private static final ACTUAL_DEFAULT_RINGTONE_BASE_URI:Landroid/net/Uri; = null

.field private static final TARGET_USER:Ljava/lang/String; = "root"

.field public static final TYPE_MUSIC:I = 0x20

.field public static final TYPE_SMS_DELIVERED_SOUND:I = 0x8

.field public static final TYPE_SMS_RECEIVED_SOUND:I = 0x10

.field private static sRingtoneList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/media/ExtraRingtoneManager$RingtoneItem;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .registers 4

    .prologue
    .line 39
    const-string v0, "file:///data/system/ringtones"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Landroid/media/ExtraRingtoneManager;->ACTUAL_DEFAULT_RINGTONE_BASE_URI:Landroid/net/Uri;

    .line 43
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Landroid/media/ExtraRingtoneManager;->sRingtoneList:Ljava/util/ArrayList;

    .line 44
    const/4 v0, 0x1

    const-string/jumbo v1, "ringtone.mp3"

    sget-object v2, Landroid/provider/Settings$System;->DEFAULT_RINGTONE_URI:Landroid/net/Uri;

    const-string/jumbo v3, "ringtone"

    invoke-static {v0, v1, v2, v3}, Landroid/media/ExtraRingtoneManager;->addRingtoneItem(ILjava/lang/String;Landroid/net/Uri;Ljava/lang/String;)V

    .line 45
    const/4 v0, 0x2

    const-string/jumbo v1, "notification.mp3"

    sget-object v2, Landroid/provider/Settings$System;->DEFAULT_NOTIFICATION_URI:Landroid/net/Uri;

    const-string/jumbo v3, "notification_sound"

    invoke-static {v0, v1, v2, v3}, Landroid/media/ExtraRingtoneManager;->addRingtoneItem(ILjava/lang/String;Landroid/net/Uri;Ljava/lang/String;)V

    .line 46
    const/4 v0, 0x4

    const-string v1, "alarm.mp3"

    sget-object v2, Landroid/provider/Settings$System;->DEFAULT_ALARM_ALERT_URI:Landroid/net/Uri;

    const-string v3, "alarm_alert"

    invoke-static {v0, v1, v2, v3}, Landroid/media/ExtraRingtoneManager;->addRingtoneItem(ILjava/lang/String;Landroid/net/Uri;Ljava/lang/String;)V

    .line 47
    const/16 v0, 0x8

    const-string/jumbo v1, "sms_delivered_sound.mp3"

    sget-object v2, Lmiui/provider/ExtraSettings$System;->DEFAULT_SMS_DELIVERED_RINGTONE_URI:Landroid/net/Uri;

    const-string/jumbo v3, "sms_delivered_sound"

    invoke-static {v0, v1, v2, v3}, Landroid/media/ExtraRingtoneManager;->addRingtoneItem(ILjava/lang/String;Landroid/net/Uri;Ljava/lang/String;)V

    .line 48
    const/16 v0, 0x10

    const-string/jumbo v1, "sms_received_sound.mp3"

    sget-object v2, Lmiui/provider/ExtraSettings$System;->DEFAULT_SMS_RECEIVED_RINGTONE_URI:Landroid/net/Uri;

    const-string/jumbo v3, "sms_received_sound"

    invoke-static {v0, v1, v2, v3}, Landroid/media/ExtraRingtoneManager;->addRingtoneItem(ILjava/lang/String;Landroid/net/Uri;Ljava/lang/String;)V

    .line 49
    return-void
.end method

.method private constructor <init>()V
    .registers 1

    .prologue
    .line 51
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 52
    return-void
.end method

.method private static addRingtoneItem(ILjava/lang/String;Landroid/net/Uri;Ljava/lang/String;)V
    .registers 7
    .parameter "type"
    .parameter "name"
    .parameter "defaultUri"
    .parameter "key"

    .prologue
    .line 176
    sget-object v2, Landroid/media/ExtraRingtoneManager;->ACTUAL_DEFAULT_RINGTONE_BASE_URI:Landroid/net/Uri;

    invoke-static {v2, p1}, Landroid/net/Uri;->withAppendedPath(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 177
    .local v1, uri:Landroid/net/Uri;
    new-instance v0, Landroid/media/ExtraRingtoneManager$RingtoneItem;

    invoke-direct {v0, p0, v1, p2, p3}, Landroid/media/ExtraRingtoneManager$RingtoneItem;-><init>(ILandroid/net/Uri;Landroid/net/Uri;Ljava/lang/String;)V

    .line 178
    .local v0, ringtoneItem:Landroid/media/ExtraRingtoneManager$RingtoneItem;
    sget-object v2, Landroid/media/ExtraRingtoneManager;->sRingtoneList:Ljava/util/ArrayList;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 179
    return-void
.end method

.method public static copyRingtone(Ljava/lang/String;I)V
    .registers 6
    .parameter "path"
    .parameter "type"

    .prologue
    .line 123
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_7

    .line 134
    :goto_6
    return-void

    .line 126
    :cond_7
    sget-object v2, Landroid/media/ExtraRingtoneManager;->ACTUAL_DEFAULT_RINGTONE_BASE_URI:Landroid/net/Uri;

    invoke-virtual {v2}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v0

    .line 127
    .local v0, dir:Ljava/lang/String;
    new-instance v2, Ljava/io/File;

    invoke-direct {v2, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v2

    if-nez v2, :cond_1e

    .line 128
    const-string/jumbo v2, "root"

    invoke-static {v0, v2}, Lmiui/util/CommandLineUtils;->mkdir(Ljava/lang/String;Ljava/lang/String;)Z

    .line 130
    :cond_1e
    const-string v2, "755"

    const-string/jumbo v3, "root"

    invoke-static {v0, v2, v3}, Lmiui/util/CommandLineUtils;->chmod(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    .line 131
    invoke-static {p1}, Landroid/media/ExtraRingtoneManager;->getDefaultRingtoneUri(I)Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v2}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v1

    .line 132
    .local v1, ringtonePath:Ljava/lang/String;
    const-string/jumbo v2, "root"

    invoke-static {p0, v1, v2}, Lmiui/util/CommandLineUtils;->cp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    .line 133
    const-string v2, "644"

    const-string/jumbo v3, "root"

    invoke-static {v1, v2, v3}, Lmiui/util/CommandLineUtils;->chmod(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    goto :goto_6
.end method

.method public static getDefaultRingtoneUri(I)Landroid/net/Uri;
    .registers 4
    .parameter "type"

    .prologue
    .line 63
    sget-object v2, Landroid/media/ExtraRingtoneManager;->sRingtoneList:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, i$:Ljava/util/Iterator;
    :cond_6
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1a

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/media/ExtraRingtoneManager$RingtoneItem;

    .line 64
    .local v1, ringtoneItem:Landroid/media/ExtraRingtoneManager$RingtoneItem;
    iget v2, v1, Landroid/media/ExtraRingtoneManager$RingtoneItem;->mRingtoneType:I

    and-int/2addr v2, p0

    if-eqz v2, :cond_6

    .line 65
    iget-object v2, v1, Landroid/media/ExtraRingtoneManager$RingtoneItem;->mActualDefaultRingtoneUri:Landroid/net/Uri;

    .line 69
    .end local v1           #ringtoneItem:Landroid/media/ExtraRingtoneManager$RingtoneItem;
    :goto_19
    return-object v2

    :cond_1a
    const/4 v2, 0x0

    goto :goto_19
.end method

.method public static getRingtoneUri(Landroid/content/Context;I)Landroid/net/Uri;
    .registers 6
    .parameter "context"
    .parameter "type"

    .prologue
    const/4 v2, 0x0

    .line 169
    invoke-static {p1}, Landroid/media/ExtraRingtoneManager;->getSettingForType(I)Ljava/lang/String;

    move-result-object v0

    .line 170
    .local v0, setting:Ljava/lang/String;
    if-nez v0, :cond_8

    .line 172
    :cond_7
    :goto_7
    return-object v2

    .line 171
    :cond_8
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    invoke-static {v3, v0}, Landroid/provider/Settings$System;->getString(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 172
    .local v1, uriString:Ljava/lang/String;
    if-eqz v1, :cond_7

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    goto :goto_7
.end method

.method private static getSettingForType(I)Ljava/lang/String;
    .registers 4
    .parameter "type"

    .prologue
    .line 160
    sget-object v2, Landroid/media/ExtraRingtoneManager;->sRingtoneList:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, i$:Ljava/util/Iterator;
    :cond_6
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1a

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/media/ExtraRingtoneManager$RingtoneItem;

    .line 161
    .local v1, ringtoneItem:Landroid/media/ExtraRingtoneManager$RingtoneItem;
    iget v2, v1, Landroid/media/ExtraRingtoneManager$RingtoneItem;->mRingtoneType:I

    and-int/2addr v2, p0

    if-eqz v2, :cond_6

    .line 162
    iget-object v2, v1, Landroid/media/ExtraRingtoneManager$RingtoneItem;->mSettingType:Ljava/lang/String;

    .line 165
    .end local v1           #ringtoneItem:Landroid/media/ExtraRingtoneManager$RingtoneItem;
    :goto_19
    return-object v2

    :cond_1a
    const/4 v2, 0x0

    goto :goto_19
.end method

.method public static getUriForExtraCases(Landroid/net/Uri;I)Landroid/net/Uri;
    .registers 5
    .parameter "soundUri"
    .parameter "ringtoneType"

    .prologue
    .line 141
    invoke-static {p0}, Landroid/media/ExtraRingtoneManager;->isExtraCases(Landroid/net/Uri;)Z

    move-result v1

    if-eqz v1, :cond_1a

    .line 142
    invoke-static {p1}, Landroid/media/ExtraRingtoneManager;->getDefaultRingtoneUri(I)Landroid/net/Uri;

    move-result-object v0

    .line 143
    .local v0, actualSoundUri:Landroid/net/Uri;
    new-instance v1, Ljava/io/File;

    invoke-virtual {v0}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_1a

    .line 144
    move-object p0, v0

    .line 147
    .end local v0           #actualSoundUri:Landroid/net/Uri;
    :cond_1a
    return-object p0
.end method

.method public static isExtraCases(Landroid/net/Uri;)Z
    .registers 3
    .parameter "soundUri"

    .prologue
    .line 137
    const-string v0, "file"

    invoke-virtual {p0}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public static resolveDefaultRingtoneUri(Landroid/content/Context;ILandroid/net/Uri;)Landroid/net/Uri;
    .registers 7
    .parameter "context"
    .parameter "type"
    .parameter "uri"

    .prologue
    .line 82
    if-nez p2, :cond_4

    move-object v1, p2

    .line 93
    .end local p2
    .local v1, uri:Landroid/net/Uri;
    :goto_3
    return-object v1

    .line 85
    .end local v1           #uri:Landroid/net/Uri;
    .restart local p2
    :cond_4
    const-string v0, ""

    .line 86
    .local v0, path:Ljava/lang/String;
    const-string/jumbo v2, "media"

    invoke-virtual {p2}, Landroid/net/Uri;->getAuthority()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_25

    .line 87
    invoke-static {p0, p2}, Landroid/media/ExtraRingtoneManager;->resolveRingtonePath(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v0

    .line 88
    new-instance v2, Ljava/io/File;

    invoke-direct {v2, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-static {v2}, Landroid/net/Uri;->fromFile(Ljava/io/File;)Landroid/net/Uri;

    move-result-object p2

    .line 92
    :cond_20
    :goto_20
    invoke-static {v0, p1}, Landroid/media/ExtraRingtoneManager;->copyRingtone(Ljava/lang/String;I)V

    move-object v1, p2

    .line 93
    .end local p2
    .restart local v1       #uri:Landroid/net/Uri;
    goto :goto_3

    .line 89
    .end local v1           #uri:Landroid/net/Uri;
    .restart local p2
    :cond_25
    const-string v2, "file"

    invoke-virtual {p2}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_20

    .line 90
    invoke-virtual {p2}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v0

    goto :goto_20
.end method

.method public static resolveRingtonePath(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;
    .registers 11
    .parameter "context"
    .parameter "uri"

    .prologue
    const/4 v8, 0x0

    const/4 v3, 0x0

    .line 104
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    .line 105
    .local v0, mediaProvider:Landroid/content/ContentResolver;
    const/4 v1, 0x1

    new-array v2, v1, [Ljava/lang/String;

    const-string v1, "_data"

    aput-object v1, v2, v8

    move-object v1, p1

    move-object v4, v3

    move-object v5, v3

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 108
    .local v6, c:Landroid/database/Cursor;
    const/4 v7, 0x0

    .line 109
    .local v7, path:Ljava/lang/String;
    if-eqz v6, :cond_24

    invoke-interface {v6}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_24

    .line 110
    invoke-interface {v6, v8}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v7

    .line 111
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    .line 113
    :cond_24
    return-object v7
.end method

.method public static setRingtoneUri(Landroid/content/Context;ILandroid/net/Uri;)V
    .registers 6
    .parameter "context"
    .parameter "type"
    .parameter "ringtoneUri"

    .prologue
    .line 151
    invoke-static {p1}, Landroid/media/ExtraRingtoneManager;->getSettingForType(I)Ljava/lang/String;

    move-result-object v0

    .line 152
    .local v0, setting:Ljava/lang/String;
    if-nez v0, :cond_7

    .line 157
    :goto_6
    return-void

    .line 155
    :cond_7
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    if-eqz p2, :cond_15

    invoke-virtual {p2}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v1

    :goto_11
    invoke-static {v2, v0, v1}, Landroid/provider/Settings$System;->putString(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Z

    goto :goto_6

    :cond_15
    const/4 v1, 0x0

    goto :goto_11
.end method
