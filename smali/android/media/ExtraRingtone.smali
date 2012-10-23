.class public Landroid/media/ExtraRingtone;
.super Ljava/lang/Object;
.source "ExtraRingtone.java"


# static fields
.field private static final DRM_COLUMNS:[Ljava/lang/String;

.field private static final MEDIA_COLUMNS:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .registers 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 17
    new-array v0, v5, [Ljava/lang/String;

    const-string v1, "_id"

    aput-object v1, v0, v2

    const-string v1, "_data"

    aput-object v1, v0, v3

    const-string/jumbo v1, "title"

    aput-object v1, v0, v4

    sput-object v0, Landroid/media/ExtraRingtone;->MEDIA_COLUMNS:[Ljava/lang/String;

    .line 23
    new-array v0, v5, [Ljava/lang/String;

    const-string v1, "_id"

    aput-object v1, v0, v2

    const-string v1, "_data"

    aput-object v1, v0, v3

    const-string/jumbo v1, "title"

    aput-object v1, v0, v4

    sput-object v0, Landroid/media/ExtraRingtone;->DRM_COLUMNS:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 15
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getRingtoneTitle(Landroid/content/Context;Landroid/net/Uri;Z)Ljava/lang/String;
    .registers 7
    .parameter "context"
    .parameter "uri"
    .parameter "formatSystemRingtone"

    .prologue
    const/4 v3, 0x1

    .line 41
    invoke-static {p0, p1, v3}, Landroid/media/ExtraRingtone;->getTitle(Landroid/content/Context;Landroid/net/Uri;Z)Ljava/lang/String;

    move-result-object v0

    .line 42
    .local v0, title:Ljava/lang/String;
    if-eqz p1, :cond_22

    if-eqz p2, :cond_22

    const-string/jumbo v1, "settings"

    invoke-virtual {p1}, Landroid/net/Uri;->getAuthority()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_22

    .line 43
    const v1, 0x60c017d

    new-array v2, v3, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object v0, v2, v3

    invoke-virtual {p0, v1, v2}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 47
    :cond_22
    return-object v0
.end method

.method private static getTitle(Landroid/content/Context;Landroid/net/Uri;Z)Ljava/lang/String;
    .registers 14
    .parameter "context"
    .parameter "uri"
    .parameter "followSettingsUri"

    .prologue
    const/4 v3, 0x0

    .line 51
    const/4 v8, 0x0

    .line 52
    .local v8, cursor:Landroid/database/Cursor;
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    .line 54
    .local v0, res:Landroid/content/ContentResolver;
    const/4 v10, 0x0

    .line 56
    .local v10, title:Ljava/lang/String;
    if-eqz p1, :cond_53

    .line 57
    invoke-virtual {p1}, Landroid/net/Uri;->getAuthority()Ljava/lang/String;

    move-result-object v7

    .line 59
    .local v7, authority:Ljava/lang/String;
    const-string/jumbo v1, "settings"

    invoke-virtual {v1, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_26

    .line 60
    if-eqz p2, :cond_53

    .line 61
    invoke-static {p1}, Landroid/media/RingtoneManager;->getDefaultType(Landroid/net/Uri;)I

    move-result v1

    invoke-static {p0, v1}, Landroid/media/RingtoneManager;->getActualDefaultRingtoneUri(Landroid/content/Context;I)Landroid/net/Uri;

    move-result-object v6

    .line 63
    .local v6, actualUri:Landroid/net/Uri;
    const/4 v1, 0x0

    invoke-static {p0, v6, v1}, Landroid/media/ExtraRingtone;->getTitle(Landroid/content/Context;Landroid/net/Uri;Z)Ljava/lang/String;

    move-result-object v1

    .line 102
    .end local v6           #actualUri:Landroid/net/Uri;
    .end local v7           #authority:Ljava/lang/String;
    :goto_25
    return-object v1

    .line 66
    .restart local v7       #authority:Ljava/lang/String;
    :cond_26
    const/4 v9, 0x0

    .line 68
    .local v9, fromDataBase:Z
    const-string v1, "drm"

    invoke-virtual {v1, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5e

    .line 69
    sget-object v2, Landroid/media/ExtraRingtone;->DRM_COLUMNS:[Ljava/lang/String;

    move-object v1, p1

    move-object v4, v3

    move-object v5, v3

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 70
    const/4 v9, 0x1

    .line 77
    :cond_39
    :goto_39
    if-eqz v8, :cond_72

    :try_start_3b
    invoke-interface {v8}, Landroid/database/Cursor;->getCount()I

    move-result v1

    const/4 v2, 0x1

    if-ne v1, v2, :cond_72

    .line 78
    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z

    .line 79
    const/4 v1, 0x2

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v10

    .line 80
    if-nez v10, :cond_4e

    .line 81
    const-string v10, ""
    :try_end_4e
    .catchall {:try_start_3b .. :try_end_4e} :catchall_7c

    .line 89
    :cond_4e
    :goto_4e
    if-eqz v8, :cond_53

    .line 90
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    .line 96
    .end local v7           #authority:Ljava/lang/String;
    .end local v9           #fromDataBase:Z
    :cond_53
    if-nez v10, :cond_83

    .line 97
    const v1, 0x60c0195

    invoke-virtual {p0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v10

    :cond_5c
    :goto_5c
    move-object v1, v10

    .line 102
    goto :goto_25

    .line 71
    .restart local v7       #authority:Ljava/lang/String;
    .restart local v9       #fromDataBase:Z
    :cond_5e
    const-string/jumbo v1, "media"

    invoke-virtual {v1, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_39

    .line 72
    sget-object v2, Landroid/media/ExtraRingtone;->MEDIA_COLUMNS:[Ljava/lang/String;

    move-object v1, p1

    move-object v4, v3

    move-object v5, v3

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 73
    const/4 v9, 0x1

    goto :goto_39

    .line 83
    :cond_72
    if-eqz v9, :cond_77

    .line 84
    :try_start_74
    const-string v10, ""

    goto :goto_4e

    .line 86
    :cond_77
    invoke-virtual {p1}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;
    :try_end_7a
    .catchall {:try_start_74 .. :try_end_7a} :catchall_7c

    move-result-object v10

    goto :goto_4e

    .line 89
    :catchall_7c
    move-exception v1

    if-eqz v8, :cond_82

    .line 90
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    .line 89
    :cond_82
    throw v1

    .line 98
    .end local v7           #authority:Ljava/lang/String;
    .end local v9           #fromDataBase:Z
    :cond_83
    invoke-virtual {v10}, Ljava/lang/String;->length()I

    move-result v1

    if-nez v1, :cond_5c

    .line 99
    const v1, 0x60c0197

    invoke-virtual {p0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v10

    goto :goto_5c
.end method
