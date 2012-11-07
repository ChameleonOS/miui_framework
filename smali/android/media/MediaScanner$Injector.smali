.class Landroid/media/MediaScanner$Injector;
.super Ljava/lang/Object;
.source "MediaScanner.java"


# annotations
.annotation build Landroid/annotation/MiuiHook;
    value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_CLASS:Landroid/annotation/MiuiHook$MiuiHookType;
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/media/MediaScanner;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Injector"
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 120
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static setAllSettingsIfNotSet(Landroid/media/MediaScanner;Landroid/media/MediaScanner$FileEntry;ZZZ)V
    .registers 7
    .parameter "scanner"
    .parameter "entry"
    .parameter "ringtones"
    .parameter "notifications"
    .parameter "alarms"

    .prologue
    .line 122
    if-eqz p3, :cond_1b

    .line 123
    const-string/jumbo v0, "notification_sound"

    iget-object v1, p1, Landroid/media/MediaScanner$FileEntry;->mPath:Ljava/lang/String;

    invoke-static {p0, v0, v1}, Landroid/media/MediaScanner$Injector;->setSettingIfNotSet(Landroid/media/MediaScanner;Ljava/lang/String;Ljava/lang/String;)V

    .line 124
    const-string/jumbo v0, "sms_delivered_sound"

    iget-object v1, p1, Landroid/media/MediaScanner$FileEntry;->mPath:Ljava/lang/String;

    invoke-static {p0, v0, v1}, Landroid/media/MediaScanner$Injector;->setSettingIfNotSet(Landroid/media/MediaScanner;Ljava/lang/String;Ljava/lang/String;)V

    .line 125
    const-string/jumbo v0, "sms_received_sound"

    iget-object v1, p1, Landroid/media/MediaScanner$FileEntry;->mPath:Ljava/lang/String;

    invoke-static {p0, v0, v1}, Landroid/media/MediaScanner$Injector;->setSettingIfNotSet(Landroid/media/MediaScanner;Ljava/lang/String;Ljava/lang/String;)V

    .line 131
    :cond_1a
    :goto_1a
    return-void

    .line 126
    :cond_1b
    if-eqz p2, :cond_26

    .line 127
    const-string/jumbo v0, "ringtone"

    iget-object v1, p1, Landroid/media/MediaScanner$FileEntry;->mPath:Ljava/lang/String;

    invoke-static {p0, v0, v1}, Landroid/media/MediaScanner$Injector;->setSettingIfNotSet(Landroid/media/MediaScanner;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1a

    .line 128
    :cond_26
    if-eqz p4, :cond_1a

    .line 129
    const-string v0, "alarm_alert"

    iget-object v1, p1, Landroid/media/MediaScanner$FileEntry;->mPath:Ljava/lang/String;

    invoke-static {p0, v0, v1}, Landroid/media/MediaScanner$Injector;->setSettingIfNotSet(Landroid/media/MediaScanner;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1a
.end method

.method static setSettingIfNotSet(Landroid/media/MediaScanner;Ljava/lang/String;Ljava/lang/String;)V
    .registers 7
    .parameter "scanner"
    .parameter "settingName"
    .parameter "path"

    .prologue
    .line 134
    invoke-virtual {p0}, Landroid/media/MediaScanner;->getContext()Landroid/content/Context;

    move-result-object v0

    .line 135
    .local v0, context:Landroid/content/Context;
    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    invoke-static {v2, p1}, Landroid/provider/Settings$System;->getString(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 138
    .local v1, existingSettingValue:Ljava/lang/String;
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_26

    .line 140
    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    new-instance v3, Ljava/io/File;

    invoke-direct {v3, p2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-static {v3}, Landroid/net/Uri;->fromFile(Ljava/io/File;)Landroid/net/Uri;

    move-result-object v3

    invoke-virtual {v3}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, p1, v3}, Landroid/provider/Settings$System;->putString(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Z

    .line 143
    :cond_26
    return-void
.end method
