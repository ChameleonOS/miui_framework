.class public final Lmiui/provider/ExtraTelephony$MmsSms;
.super Ljava/lang/Object;
.source "ExtraTelephony.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/provider/ExtraTelephony;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "MmsSms"
.end annotation


# static fields
.field public static final CONTENT_ALL_LOCKED_URI:Landroid/net/Uri; = null

.field public static final CONTENT_EXPIRED_URI:Landroid/net/Uri; = null

.field public static final CONTENT_PREVIEW_URI:Landroid/net/Uri; = null

.field public static final CONTENT_RECENT_RECIPIENTS_URI:Landroid/net/Uri; = null

.field public static final INSERT_PATH_IGNORED:Ljava/lang/String; = "ignored"

.field public static final INSERT_PATH_INSERTED:Ljava/lang/String; = "inserted"

.field public static final INSERT_PATH_RESTORED:Ljava/lang/String; = "restored"

.field public static final INSERT_PATH_UPDATED:Ljava/lang/String; = "updated"

.field public static final PREVIEW_ADDRESS_COLUMN_INDEX:I = 0x1

.field public static final PREVIEW_BODY_COLUMN_INDEX:I = 0x4

.field public static final PREVIEW_CHARSET_COLUMN_INDEX:I = 0x5

.field public static final PREVIEW_DATE_COLUMN_INDEX:I = 0x2

.field public static final PREVIEW_ID_COLUMN_INDEX:I = 0x0

.field public static final PREVIEW_THREAD_ID_COLUMN_INDEX:I = 0x6

.field public static final PREVIEW_TYPE_COLUMN_INDEX:I = 0x3

.field public static final SYNC_STATE_DIRTY:I = 0x0

.field public static final SYNC_STATE_SYNCED:I = 0x2

.field public static final SYNC_STATE_SYNCING:I = 0x1


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 387
    const-string v0, "content://mms-sms/message/preview"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lmiui/provider/ExtraTelephony$MmsSms;->CONTENT_PREVIEW_URI:Landroid/net/Uri;

    .line 393
    const-string v0, "content://mms-sms/locked/all"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lmiui/provider/ExtraTelephony$MmsSms;->CONTENT_ALL_LOCKED_URI:Landroid/net/Uri;

    .line 396
    const-string v0, "content://mms-sms/expired"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lmiui/provider/ExtraTelephony$MmsSms;->CONTENT_EXPIRED_URI:Landroid/net/Uri;

    .line 399
    const-string v0, "content://mms-sms/recent-recipients"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lmiui/provider/ExtraTelephony$MmsSms;->CONTENT_RECENT_RECIPIENTS_URI:Landroid/net/Uri;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 385
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
