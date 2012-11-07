.class public Landroid/app/MiuiDownloadManager;
.super Landroid/app/DownloadManager;
.source "MiuiDownloadManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/app/MiuiDownloadManager$Query;,
        Landroid/app/MiuiDownloadManager$Request;
    }
.end annotation


# static fields
.field public static final ACTION_DOWNLOAD_DELETED:Ljava/lang/String; = "android.intent.action.DOWNLOAD_DELETED"

.field public static final ACTION_DOWNLOAD_UPDATED:Ljava/lang/String; = "android.intent.action.DOWNLOAD_UPDATED"

.field public static final ACTION_OPERATE_DOWNLOADSET_UPDATE_PROGRESS:Ljava/lang/String; = "android.intent.action.OPERATE_DOWNLOADSET_UPDATE_PROGRESS"

.field private static final DOWNLOAD_UPDATE_RECEIVER_COMPONENT:Landroid/content/ComponentName; = null

.field public static final EXTRA_DOWNLOAD_CURRENT_BYTES:Ljava/lang/String; = "extra_download_current_bytes"

.field public static final EXTRA_DOWNLOAD_STATUS:Ljava/lang/String; = "extra_download_status"

.field public static final EXTRA_DOWNLOAD_TOTAL_BYTES:Ljava/lang/String; = "extra_download_total_bytes"

.field public static final INTENT_EXTRA_APPLICATION_PACKAGENAME:Ljava/lang/String; = "intent_extra_application_packagename"

.field public static final INTENT_EXTRA_REGISTER_DOWNLOADS_UPDATE_PROGRESS:Ljava/lang/String; = "intent_extra_register_downloads_update_progress"

.field public static final INTENT_EXTRA_UNREGISTER_DOWNLOADS_UPDATE_PROGRESS:Ljava/lang/String; = "intent_extra_unregister_downloads_update_progress"

.field public static final MIUI_UNDERLYING_COLUMNS:[Ljava/lang/String; = null

.field public static final PAUSED_BY_APP:I = 0x5


# instance fields
.field private mResolver:Landroid/content/ContentResolver;


# direct methods
.method static constructor <clinit>()V
    .registers 4

    .prologue
    .line 69
    new-instance v0, Landroid/content/ComponentName;

    const-string v1, "com.android.providers.downloads"

    const-string v2, "com.android.providers.downloads.DownloadUpdateReceiver"

    invoke-direct {v0, v1, v2}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    sput-object v0, Landroid/app/MiuiDownloadManager;->DOWNLOAD_UPDATE_RECEIVER_COMPONENT:Landroid/content/ComponentName;

    .line 76
    sget-object v0, Landroid/app/MiuiDownloadManager;->UNDERLYING_COLUMNS:[Ljava/lang/String;

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v3, "bypass_recommended_size_limit"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "allowed_network_types"

    aput-object v3, v1, v2

    const-class v2, Ljava/lang/String;

    invoke-static {v0, v1, v2}, Landroid/app/MiuiDownloadManager;->concatArrays([Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/Class;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ljava/lang/String;

    sput-object v0, Landroid/app/MiuiDownloadManager;->MIUI_UNDERLYING_COLUMNS:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/ContentResolver;Ljava/lang/String;)V
    .registers 3
    .parameter "resolver"
    .parameter "packageName"

    .prologue
    .line 286
    invoke-direct {p0, p1, p2}, Landroid/app/DownloadManager;-><init>(Landroid/content/ContentResolver;Ljava/lang/String;)V

    .line 287
    iput-object p1, p0, Landroid/app/MiuiDownloadManager;->mResolver:Landroid/content/ContentResolver;

    .line 288
    return-void
.end method

.method public static addRunningStatusAndControlRun(Landroid/content/ContentValues;)V
    .registers 3
    .parameter "values"

    .prologue
    .line 370
    if-eqz p0, :cond_18

    .line 371
    const-string/jumbo v0, "status"

    const/16 v1, 0xc0

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 372
    const-string v0, "control"

    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 374
    :cond_18
    return-void
.end method

.method private static concatArrays([Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/Class;)[Ljava/lang/Object;
    .registers 7
    .parameter
    .parameter
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">([TT;[TT;",
            "Ljava/lang/Class",
            "<TT;>;)[TT;"
        }
    .end annotation

    .prologue
    .local p0, src1:[Ljava/lang/Object;,"[TT;"
    .local p1, src2:[Ljava/lang/Object;,"[TT;"
    .local p2, type:Ljava/lang/Class;,"Ljava/lang/Class<TT;>;"
    const/4 v3, 0x0

    .line 87
    array-length v1, p0

    array-length v2, p1

    add-int/2addr v1, v2

    invoke-static {p2, v1}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Ljava/lang/Object;

    move-object v0, v1

    check-cast v0, [Ljava/lang/Object;

    .line 88
    .local v0, dst:[Ljava/lang/Object;,"[TT;"
    array-length v1, p0

    invoke-static {p0, v3, v0, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 89
    array-length v1, p0

    array-length v2, p1

    invoke-static {p1, v3, v0, v1, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 90
    return-object v0
.end method

.method public static getMobileFileSizePromptEnabled(Landroid/content/Context;)Ljava/lang/Integer;
    .registers 4
    .parameter "context"

    .prologue
    .line 406
    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    sget-object v2, Lmiui/provider/ExtraSettings$Secure;->MOBILE_DOWNLOAD_FILE_SIZE_PROMPT_POPUP_ENABLED:Ljava/lang/String;

    invoke-static {v1, v2}, Landroid/provider/Settings$Secure;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    :try_end_d
    .catch Landroid/provider/Settings$SettingNotFoundException; {:try_start_0 .. :try_end_d} :catch_f

    move-result-object v1

    .line 409
    :goto_e
    return-object v1

    .line 408
    :catch_f
    move-exception v0

    .line 409
    .local v0, e:Landroid/provider/Settings$SettingNotFoundException;
    const/4 v1, 0x0

    goto :goto_e
.end method

.method private static getWhereArgsForStatuses([I)[Ljava/lang/String;
    .registers 4
    .parameter "statuses"

    .prologue
    .line 362
    array-length v2, p0

    new-array v1, v2, [Ljava/lang/String;

    .line 363
    .local v1, whereArgs:[Ljava/lang/String;
    const/4 v0, 0x0

    .local v0, i:I
    :goto_4
    array-length v2, p0

    if-ge v0, v2, :cond_12

    .line 364
    aget v2, p0, v0

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v0

    .line 363
    add-int/lit8 v0, v0, 0x1

    goto :goto_4

    .line 366
    :cond_12
    return-object v1
.end method

.method private static getWhereClauseForStatuses([Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    .registers 6
    .parameter "operators"
    .parameter "jointConditions"

    .prologue
    .line 348
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 349
    .local v1, whereClause:Ljava/lang/StringBuilder;
    const-string v2, "("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 350
    const/4 v0, 0x0

    .local v0, i:I
    :goto_b
    array-length v2, p0

    if-ge v0, v2, :cond_51

    .line 351
    if-lez v0, :cond_2a

    .line 352
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    add-int/lit8 v3, v0, -0x1

    aget-object v3, p1, v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 354
    :cond_2a
    const-string/jumbo v2, "status"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 355
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    aget-object v3, p0, v0

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " ? "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 350
    add-int/lit8 v0, v0, 0x1

    goto :goto_b

    .line 357
    :cond_51
    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 358
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method public static isDownloadSuccess(Landroid/database/Cursor;)Z
    .registers 4
    .parameter "cursor"

    .prologue
    .line 390
    move-object v0, p0

    check-cast v0, Landroid/app/DownloadManager$CursorTranslator;

    .line 391
    .local v0, cusorTranslator:Landroid/app/DownloadManager$CursorTranslator;
    const-string/jumbo v1, "status"

    invoke-virtual {v0, v1}, Landroid/app/DownloadManager$CursorTranslator;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/app/DownloadManager$CursorTranslator;->getInt(I)I

    move-result v1

    const/16 v2, 0x8

    if-ne v1, v2, :cond_14

    const/4 v1, 0x1

    :goto_13
    return v1

    :cond_14
    const/4 v1, 0x0

    goto :goto_13
.end method

.method public static isDownloading(Landroid/database/Cursor;)Z
    .registers 5
    .parameter "cursor"

    .prologue
    .line 377
    const/4 v1, 0x0

    .local v1, ret:Z
    move-object v0, p0

    .line 378
    check-cast v0, Landroid/app/DownloadManager$CursorTranslator;

    .line 379
    .local v0, cusorTranslator:Landroid/app/DownloadManager$CursorTranslator;
    const-string/jumbo v3, "status"

    invoke-virtual {v0, v3}, Landroid/app/DownloadManager$CursorTranslator;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-virtual {v0, v3}, Landroid/app/DownloadManager$CursorTranslator;->getInt(I)I

    move-result v2

    .line 380
    .local v2, status:I
    packed-switch v2, :pswitch_data_16

    .line 386
    :goto_12
    return v1

    .line 383
    :pswitch_13
    const/4 v1, 0x1

    goto :goto_12

    .line 380
    nop

    :pswitch_data_16
    .packed-switch 0x1
        :pswitch_13
        :pswitch_13
    .end packed-switch
.end method

.method public static operateDownloadsNeedToUpdateProgress(Landroid/content/Context;[J[J)V
    .registers 5
    .parameter "context"
    .parameter "registerIds"
    .parameter "unregisterIds"

    .prologue
    .line 98
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.OPERATE_DOWNLOADSET_UPDATE_PROGRESS"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 99
    .local v0, intent:Landroid/content/Intent;
    sget-object v1, Landroid/app/MiuiDownloadManager;->DOWNLOAD_UPDATE_RECEIVER_COMPONENT:Landroid/content/ComponentName;

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setComponent(Landroid/content/ComponentName;)Landroid/content/Intent;

    .line 100
    const-string v1, "intent_extra_register_downloads_update_progress"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[J)Landroid/content/Intent;

    .line 101
    const-string v1, "intent_extra_unregister_downloads_update_progress"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[J)Landroid/content/Intent;

    .line 102
    invoke-virtual {p0, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 103
    return-void
.end method

.method public static setMobileFileSizePromptEnabled(Landroid/content/Context;Z)Z
    .registers 5
    .parameter "context"
    .parameter "enabled"

    .prologue
    .line 414
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    sget-object v2, Lmiui/provider/ExtraSettings$Secure;->MOBILE_DOWNLOAD_FILE_SIZE_PROMPT_POPUP_ENABLED:Ljava/lang/String;

    if-eqz p1, :cond_e

    const/4 v0, 0x1

    :goto_9
    invoke-static {v1, v2, v0}, Landroid/provider/Settings$Secure;->putInt(Landroid/content/ContentResolver;Ljava/lang/String;I)Z

    move-result v0

    return v0

    :cond_e
    const/4 v0, 0x0

    goto :goto_9
.end method

.method public static setRecommendedMaxBytesOverMobile(Landroid/content/Context;J)Z
    .registers 5
    .parameter "context"
    .parameter "size"

    .prologue
    .line 427
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const-string v1, "download_manager_recommended_max_bytes_over_mobile"

    invoke-static {v0, v1, p1, p2}, Landroid/provider/Settings$Secure;->putLong(Landroid/content/ContentResolver;Ljava/lang/String;J)Z

    move-result v0

    return v0
.end method

.method public static translateStatus(I)I
    .registers 2
    .parameter "downloadsStatus"

    .prologue
    .line 401
    invoke-static {p0}, Landroid/app/DownloadManager$CursorTranslator;->translateStatus(I)I

    move-result v0

    return v0
.end method


# virtual methods
.method public varargs pauseDownload([J)V
    .registers 11
    .parameter "ids"

    .prologue
    const/4 v8, 0x2

    const/4 v7, 0x0

    const/4 v6, 0x1

    .line 320
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 321
    .local v0, values:Landroid/content/ContentValues;
    const-string/jumbo v3, "status"

    const/16 v4, 0xc1

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 322
    const-string v3, "control"

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 324
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "( "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-static {p1}, Landroid/app/MiuiDownloadManager;->getWhereClauseForIds([J)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " AND "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    new-array v4, v8, [Ljava/lang/String;

    const-string v5, "!="

    aput-object v5, v4, v7

    const-string v5, "!="

    aput-object v5, v4, v6

    new-array v5, v6, [Ljava/lang/String;

    const-string v6, "AND"

    aput-object v6, v5, v7

    invoke-static {v4, v5}, Landroid/app/MiuiDownloadManager;->getWhereClauseForStatuses([Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ")"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 326
    .local v2, whereClause:Ljava/lang/String;
    invoke-static {p1}, Landroid/app/MiuiDownloadManager;->getWhereArgsForIds([J)[Ljava/lang/String;

    move-result-object v3

    new-array v4, v8, [I

    fill-array-data v4, :array_78

    invoke-static {v4}, Landroid/app/MiuiDownloadManager;->getWhereArgsForStatuses([I)[Ljava/lang/String;

    move-result-object v4

    const-class v5, Ljava/lang/String;

    invoke-static {v3, v4, v5}, Landroid/app/MiuiDownloadManager;->concatArrays([Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/Class;)[Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Ljava/lang/String;

    .line 329
    .local v1, whereArgs:[Ljava/lang/String;
    iget-object v3, p0, Landroid/app/MiuiDownloadManager;->mResolver:Landroid/content/ContentResolver;

    invoke-virtual {p0}, Landroid/app/MiuiDownloadManager;->getBaseUri()Landroid/net/Uri;

    move-result-object v4

    invoke-virtual {v3, v4, v0, v2, v1}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 330
    return-void

    .line 326
    nop

    :array_78
    .array-data 0x4
        0x1t 0x0t 0x0t 0x0t
        0x2t 0x0t 0x0t 0x0t
    .end array-data
.end method

.method public query(Landroid/app/DownloadManager$Query;)Landroid/database/Cursor;
    .registers 6
    .parameter "query"

    .prologue
    .line 292
    iget-object v1, p0, Landroid/app/MiuiDownloadManager;->mResolver:Landroid/content/ContentResolver;

    sget-object v2, Landroid/app/MiuiDownloadManager;->MIUI_UNDERLYING_COLUMNS:[Ljava/lang/String;

    invoke-virtual {p0}, Landroid/app/MiuiDownloadManager;->getBaseUri()Landroid/net/Uri;

    move-result-object v3

    invoke-virtual {p1, v1, v2, v3}, Landroid/app/DownloadManager$Query;->runQuery(Landroid/content/ContentResolver;[Ljava/lang/String;Landroid/net/Uri;)Landroid/database/Cursor;

    move-result-object v0

    .line 293
    .local v0, underlyingCursor:Landroid/database/Cursor;
    if-nez v0, :cond_10

    .line 294
    const/4 v1, 0x0

    .line 296
    :goto_f
    return-object v1

    :cond_10
    new-instance v1, Landroid/app/DownloadManager$CursorTranslator;

    invoke-virtual {p0}, Landroid/app/MiuiDownloadManager;->getBaseUri()Landroid/net/Uri;

    move-result-object v2

    invoke-direct {v1, v0, v2}, Landroid/app/DownloadManager$CursorTranslator;-><init>(Landroid/database/Cursor;Landroid/net/Uri;)V

    goto :goto_f
.end method

.method public varargs removeRecordOnly([J)I
    .registers 6
    .parameter "ids"

    .prologue
    .line 308
    if-eqz p1, :cond_5

    array-length v0, p1

    if-nez v0, :cond_d

    .line 310
    :cond_5
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "input param \'ids\' can\'t be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 312
    :cond_d
    iget-object v0, p0, Landroid/app/MiuiDownloadManager;->mResolver:Landroid/content/ContentResolver;

    invoke-virtual {p0}, Landroid/app/MiuiDownloadManager;->getBaseUri()Landroid/net/Uri;

    move-result-object v1

    invoke-static {p1}, Landroid/app/MiuiDownloadManager;->getWhereClauseForIds([J)Ljava/lang/String;

    move-result-object v2

    invoke-static {p1}, Landroid/app/MiuiDownloadManager;->getWhereArgsForIds([J)[Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public varargs resumeDownload([J)V
    .registers 10
    .parameter "ids"

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 337
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 338
    .local v0, values:Landroid/content/ContentValues;
    invoke-static {v0}, Landroid/app/MiuiDownloadManager;->addRunningStatusAndControlRun(Landroid/content/ContentValues;)V

    .line 339
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "( "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-static {p1}, Landroid/app/MiuiDownloadManager;->getWhereClauseForIds([J)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " AND "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    new-array v4, v7, [Ljava/lang/String;

    const-string v5, "!="

    aput-object v5, v4, v6

    const/4 v5, 0x0

    invoke-static {v4, v5}, Landroid/app/MiuiDownloadManager;->getWhereClauseForStatuses([Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ")"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 341
    .local v2, whereClause:Ljava/lang/String;
    invoke-static {p1}, Landroid/app/MiuiDownloadManager;->getWhereArgsForIds([J)[Ljava/lang/String;

    move-result-object v3

    new-array v4, v7, [I

    const/4 v5, 0x4

    aput v5, v4, v6

    invoke-static {v4}, Landroid/app/MiuiDownloadManager;->getWhereArgsForStatuses([I)[Ljava/lang/String;

    move-result-object v4

    const-class v5, Ljava/lang/String;

    invoke-static {v3, v4, v5}, Landroid/app/MiuiDownloadManager;->concatArrays([Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/Class;)[Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Ljava/lang/String;

    .line 344
    .local v1, whereArgs:[Ljava/lang/String;
    iget-object v3, p0, Landroid/app/MiuiDownloadManager;->mResolver:Landroid/content/ContentResolver;

    invoke-virtual {p0}, Landroid/app/MiuiDownloadManager;->getBaseUri()Landroid/net/Uri;

    move-result-object v4

    invoke-virtual {v3, v4, v0, v2, v1}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 345
    return-void
.end method
