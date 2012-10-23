.class public final Landroid/provider/Downloads$Impl;
.super Ljava/lang/Object;
.source "Downloads.java"

# interfaces
.implements Landroid/provider/BaseColumns;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/provider/Downloads;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Impl"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/provider/Downloads$Impl$RequestHeaders;
    }
.end annotation


# static fields
.field public static final ACTION_DOWNLOAD_COMPLETED:Ljava/lang/String; = "android.intent.action.DOWNLOAD_COMPLETED"

.field public static final ACTION_NOTIFICATION_CLICKED:Ljava/lang/String; = "android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED"

.field public static final ALL_DOWNLOADS_CONTENT_URI:Landroid/net/Uri; = null

.field public static final COLUMN_ALLOWED_NETWORK_TYPES:Ljava/lang/String; = "allowed_network_types"

.field public static final COLUMN_ALLOW_METERED:Ljava/lang/String; = "allow_metered"

.field public static final COLUMN_ALLOW_ROAMING:Ljava/lang/String; = "allow_roaming"

.field public static final COLUMN_APP_DATA:Ljava/lang/String; = "entity"

.field public static final COLUMN_BYPASS_RECOMMENDED_SIZE_LIMIT:Ljava/lang/String; = "bypass_recommended_size_limit"

.field public static final COLUMN_CONTROL:Ljava/lang/String; = "control"

.field public static final COLUMN_COOKIE_DATA:Ljava/lang/String; = "cookiedata"

.field public static final COLUMN_CURRENT_BYTES:Ljava/lang/String; = "current_bytes"

.field public static final COLUMN_DELETED:Ljava/lang/String; = "deleted"

.field public static final COLUMN_DESCRIPTION:Ljava/lang/String; = "description"

.field public static final COLUMN_DESTINATION:Ljava/lang/String; = "destination"

.field public static final COLUMN_ERROR_MSG:Ljava/lang/String; = "errorMsg"

.field public static final COLUMN_FILE_NAME_HINT:Ljava/lang/String; = "hint"

.field public static final COLUMN_IS_PUBLIC_API:Ljava/lang/String; = "is_public_api"

.field public static final COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI:Ljava/lang/String; = "is_visible_in_downloads_ui"

.field public static final COLUMN_LAST_MODIFICATION:Ljava/lang/String; = "lastmod"

.field public static final COLUMN_LAST_UPDATESRC:Ljava/lang/String; = "lastUpdateSrc"

.field public static final COLUMN_MEDIAPROVIDER_URI:Ljava/lang/String; = "mediaprovider_uri"

.field public static final COLUMN_MEDIA_SCANNED:Ljava/lang/String; = "scanned"

.field public static final COLUMN_MIME_TYPE:Ljava/lang/String; = "mimetype"

.field public static final COLUMN_NOTIFICATION_CLASS:Ljava/lang/String; = "notificationclass"

.field public static final COLUMN_NOTIFICATION_EXTRAS:Ljava/lang/String; = "notificationextras"

.field public static final COLUMN_NOTIFICATION_PACKAGE:Ljava/lang/String; = "notificationpackage"

.field public static final COLUMN_NO_INTEGRITY:Ljava/lang/String; = "no_integrity"

.field public static final COLUMN_OTHER_UID:Ljava/lang/String; = "otheruid"

.field public static final COLUMN_REFERER:Ljava/lang/String; = "referer"

.field public static final COLUMN_STATUS:Ljava/lang/String; = "status"

.field public static final COLUMN_TITLE:Ljava/lang/String; = "title"

.field public static final COLUMN_TOTAL_BYTES:Ljava/lang/String; = "total_bytes"

.field public static final COLUMN_URI:Ljava/lang/String; = "uri"

.field public static final COLUMN_USER_AGENT:Ljava/lang/String; = "useragent"

.field public static final COLUMN_VISIBILITY:Ljava/lang/String; = "visibility"

.field public static final CONTENT_URI:Landroid/net/Uri; = null

.field public static final CONTROL_PAUSED:I = 0x1

.field public static final CONTROL_RUN:I = 0x0

.field public static final DESTINATION_CACHE_PARTITION:I = 0x1

.field public static final DESTINATION_CACHE_PARTITION_NOROAMING:I = 0x3

.field public static final DESTINATION_CACHE_PARTITION_PURGEABLE:I = 0x2

.field public static final DESTINATION_EXTERNAL:I = 0x0

.field public static final DESTINATION_FILE_URI:I = 0x4

.field public static final DESTINATION_NON_DOWNLOADMANAGER_DOWNLOAD:I = 0x6

.field public static final DESTINATION_SYSTEMCACHE_PARTITION:I = 0x5

.field public static final LAST_UPDATESRC_DONT_NOTIFY_DOWNLOADSVC:I = 0x1

.field public static final LAST_UPDATESRC_NOT_RELEVANT:I = 0x0

.field public static final MIN_ARTIFICIAL_ERROR_STATUS:I = 0x1e8

.field public static final PERMISSION_ACCESS:Ljava/lang/String; = "android.permission.ACCESS_DOWNLOAD_MANAGER"

.field public static final PERMISSION_ACCESS_ADVANCED:Ljava/lang/String; = "android.permission.ACCESS_DOWNLOAD_MANAGER_ADVANCED"

.field public static final PERMISSION_ACCESS_ALL:Ljava/lang/String; = "android.permission.ACCESS_ALL_DOWNLOADS"

.field public static final PERMISSION_CACHE:Ljava/lang/String; = "android.permission.ACCESS_CACHE_FILESYSTEM"

.field public static final PERMISSION_CACHE_NON_PURGEABLE:Ljava/lang/String; = "android.permission.DOWNLOAD_CACHE_NON_PURGEABLE"

.field public static final PERMISSION_NO_NOTIFICATION:Ljava/lang/String; = "android.permission.DOWNLOAD_WITHOUT_NOTIFICATION"

.field public static final PERMISSION_SEND_INTENTS:Ljava/lang/String; = "android.permission.SEND_DOWNLOAD_COMPLETED_INTENTS"

.field public static final PUBLICLY_ACCESSIBLE_DOWNLOADS_URI:Landroid/net/Uri; = null

.field public static final PUBLICLY_ACCESSIBLE_DOWNLOADS_URI_SEGMENT:Ljava/lang/String; = "public_downloads"

.field public static final STATUS_BAD_REQUEST:I = 0x190

.field public static final STATUS_BLOCKED:I = 0x1f2
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final STATUS_CANCELED:I = 0x1ea

.field public static final STATUS_CANNOT_RESUME:I = 0x1e9

.field public static final STATUS_DEVICE_NOT_FOUND_ERROR:I = 0xc7

.field public static final STATUS_FILE_ALREADY_EXISTS_ERROR:I = 0x1e8

.field public static final STATUS_FILE_ERROR:I = 0x1ec

.field public static final STATUS_HTTP_DATA_ERROR:I = 0x1ef

.field public static final STATUS_HTTP_EXCEPTION:I = 0x1f0

.field public static final STATUS_INSUFFICIENT_SPACE_ERROR:I = 0xc6

.field public static final STATUS_LENGTH_REQUIRED:I = 0x19b

.field public static final STATUS_NOT_ACCEPTABLE:I = 0x196

.field public static final STATUS_PAUSED_BY_APP:I = 0xc1

.field public static final STATUS_PENDING:I = 0xbe

.field public static final STATUS_PRECONDITION_FAILED:I = 0x19c

.field public static final STATUS_QUEUED_FOR_WIFI:I = 0xc4

.field public static final STATUS_RUNNING:I = 0xc0

.field public static final STATUS_SUCCESS:I = 0xc8

.field public static final STATUS_TOO_MANY_REDIRECTS:I = 0x1f1

.field public static final STATUS_UNHANDLED_HTTP_CODE:I = 0x1ee

.field public static final STATUS_UNHANDLED_REDIRECT:I = 0x1ed

.field public static final STATUS_UNKNOWN_ERROR:I = 0x1eb

.field public static final STATUS_WAITING_FOR_NETWORK:I = 0xc3

.field public static final STATUS_WAITING_TO_RETRY:I = 0xc2

.field public static final VISIBILITY_HIDDEN:I = 0x2

.field public static final VISIBILITY_VISIBLE:I = 0x0

.field public static final VISIBILITY_VISIBLE_NOTIFY_COMPLETED:I = 0x1

.field public static final _DATA:Ljava/lang/String; = "_data"


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 89
    const-string v0, "content://downloads/my_downloads"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Landroid/provider/Downloads$Impl;->CONTENT_URI:Landroid/net/Uri;

    .line 96
    const-string v0, "content://downloads/all_downloads"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Landroid/provider/Downloads$Impl;->ALL_DOWNLOADS_CONTENT_URI:Landroid/net/Uri;

    .line 106
    const-string v0, "content://downloads/public_downloads"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Landroid/provider/Downloads$Impl;->PUBLICLY_ACCESSIBLE_DOWNLOADS_URI:Landroid/net/Uri;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    .prologue
    .line 42
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static isNotificationToBeDisplayed(I)Z
    .registers 3
    .parameter "visibility"

    .prologue
    const/4 v0, 0x1

    .line 547
    if-eq p0, v0, :cond_6

    const/4 v1, 0x3

    if-ne p0, v1, :cond_7

    :cond_6
    :goto_6
    return v0

    :cond_7
    const/4 v0, 0x0

    goto :goto_6
.end method

.method public static isStatusClientError(I)Z
    .registers 2
    .parameter "status"

    .prologue
    .line 530
    const/16 v0, 0x190

    if-lt p0, v0, :cond_a

    const/16 v0, 0x1f4

    if-ge p0, v0, :cond_a

    const/4 v0, 0x1

    :goto_9
    return v0

    :cond_a
    const/4 v0, 0x0

    goto :goto_9
.end method

.method public static isStatusCompleted(I)Z
    .registers 2
    .parameter "status"

    .prologue
    .line 556
    const/16 v0, 0xc8

    if-lt p0, v0, :cond_8

    const/16 v0, 0x12c

    if-lt p0, v0, :cond_10

    :cond_8
    const/16 v0, 0x190

    if-lt p0, v0, :cond_12

    const/16 v0, 0x258

    if-ge p0, v0, :cond_12

    :cond_10
    const/4 v0, 0x1

    :goto_11
    return v0

    :cond_12
    const/4 v0, 0x0

    goto :goto_11
.end method

.method public static isStatusError(I)Z
    .registers 2
    .parameter "status"

    .prologue
    .line 523
    const/16 v0, 0x190

    if-lt p0, v0, :cond_a

    const/16 v0, 0x258

    if-ge p0, v0, :cond_a

    const/4 v0, 0x1

    :goto_9
    return v0

    :cond_a
    const/4 v0, 0x0

    goto :goto_9
.end method

.method public static isStatusInformational(I)Z
    .registers 2
    .parameter "status"

    .prologue
    .line 509
    const/16 v0, 0x64

    if-lt p0, v0, :cond_a

    const/16 v0, 0xc8

    if-ge p0, v0, :cond_a

    const/4 v0, 0x1

    :goto_9
    return v0

    :cond_a
    const/4 v0, 0x0

    goto :goto_9
.end method

.method public static isStatusServerError(I)Z
    .registers 2
    .parameter "status"

    .prologue
    .line 537
    const/16 v0, 0x1f4

    if-lt p0, v0, :cond_a

    const/16 v0, 0x258

    if-ge p0, v0, :cond_a

    const/4 v0, 0x1

    :goto_9
    return v0

    :cond_a
    const/4 v0, 0x0

    goto :goto_9
.end method

.method public static isStatusSuccess(I)Z
    .registers 2
    .parameter "status"

    .prologue
    .line 516
    const/16 v0, 0xc8

    if-lt p0, v0, :cond_a

    const/16 v0, 0x12c

    if-ge p0, v0, :cond_a

    const/4 v0, 0x1

    :goto_9
    return v0

    :cond_a
    const/4 v0, 0x0

    goto :goto_9
.end method

.method public static statusToString(I)Ljava/lang/String;
    .registers 2
    .parameter "status"

    .prologue
    .line 720
    sparse-switch p0, :sswitch_data_50

    .line 745
    invoke-static {p0}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v0

    :goto_7
    return-object v0

    .line 721
    :sswitch_8
    const-string v0, "PENDING"

    goto :goto_7

    .line 722
    :sswitch_b
    const-string v0, "RUNNING"

    goto :goto_7

    .line 723
    :sswitch_e
    const-string v0, "PAUSED_BY_APP"

    goto :goto_7

    .line 724
    :sswitch_11
    const-string v0, "WAITING_TO_RETRY"

    goto :goto_7

    .line 725
    :sswitch_14
    const-string v0, "WAITING_FOR_NETWORK"

    goto :goto_7

    .line 726
    :sswitch_17
    const-string v0, "QUEUED_FOR_WIFI"

    goto :goto_7

    .line 727
    :sswitch_1a
    const-string v0, "INSUFFICIENT_SPACE_ERROR"

    goto :goto_7

    .line 728
    :sswitch_1d
    const-string v0, "DEVICE_NOT_FOUND_ERROR"

    goto :goto_7

    .line 729
    :sswitch_20
    const-string v0, "SUCCESS"

    goto :goto_7

    .line 730
    :sswitch_23
    const-string v0, "BAD_REQUEST"

    goto :goto_7

    .line 731
    :sswitch_26
    const-string v0, "NOT_ACCEPTABLE"

    goto :goto_7

    .line 732
    :sswitch_29
    const-string v0, "LENGTH_REQUIRED"

    goto :goto_7

    .line 733
    :sswitch_2c
    const-string v0, "PRECONDITION_FAILED"

    goto :goto_7

    .line 734
    :sswitch_2f
    const-string v0, "FILE_ALREADY_EXISTS_ERROR"

    goto :goto_7

    .line 735
    :sswitch_32
    const-string v0, "CANNOT_RESUME"

    goto :goto_7

    .line 736
    :sswitch_35
    const-string v0, "CANCELED"

    goto :goto_7

    .line 737
    :sswitch_38
    const-string v0, "UNKNOWN_ERROR"

    goto :goto_7

    .line 738
    :sswitch_3b
    const-string v0, "FILE_ERROR"

    goto :goto_7

    .line 739
    :sswitch_3e
    const-string v0, "UNHANDLED_REDIRECT"

    goto :goto_7

    .line 740
    :sswitch_41
    const-string v0, "UNHANDLED_HTTP_CODE"

    goto :goto_7

    .line 741
    :sswitch_44
    const-string v0, "HTTP_DATA_ERROR"

    goto :goto_7

    .line 742
    :sswitch_47
    const-string v0, "HTTP_EXCEPTION"

    goto :goto_7

    .line 743
    :sswitch_4a
    const-string v0, "TOO_MANY_REDIRECTS"

    goto :goto_7

    .line 744
    :sswitch_4d
    const-string v0, "BLOCKED"

    goto :goto_7

    .line 720
    :sswitch_data_50
    .sparse-switch
        0xbe -> :sswitch_8
        0xc0 -> :sswitch_b
        0xc1 -> :sswitch_e
        0xc2 -> :sswitch_11
        0xc3 -> :sswitch_14
        0xc4 -> :sswitch_17
        0xc6 -> :sswitch_1a
        0xc7 -> :sswitch_1d
        0xc8 -> :sswitch_20
        0x190 -> :sswitch_23
        0x196 -> :sswitch_26
        0x19b -> :sswitch_29
        0x19c -> :sswitch_2c
        0x1e8 -> :sswitch_2f
        0x1e9 -> :sswitch_32
        0x1ea -> :sswitch_35
        0x1eb -> :sswitch_38
        0x1ec -> :sswitch_3b
        0x1ed -> :sswitch_3e
        0x1ee -> :sswitch_41
        0x1ef -> :sswitch_44
        0x1f0 -> :sswitch_47
        0x1f1 -> :sswitch_4a
        0x1f2 -> :sswitch_4d
    .end sparse-switch
.end method
