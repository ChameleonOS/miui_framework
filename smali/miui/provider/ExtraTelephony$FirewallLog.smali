.class public final Lmiui/provider/ExtraTelephony$FirewallLog;
.super Ljava/lang/Object;
.source "ExtraTelephony.java"

# interfaces
.implements Landroid/provider/BaseColumns;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/provider/ExtraTelephony;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "FirewallLog"
.end annotation


# static fields
.field public static final BLOCK_BY_BL:I = 0x1

.field public static final BLOCK_BY_WL:I = 0x2

.field public static final BLOCK_FILTER:I = 0x3

.field public static final BLOCK_NONE:I = 0x0

.field public static final BLOCK_PRVIATE_CALL:I = 0x4

.field public static final CONTENT_ITEM_TYPE:Ljava/lang/String; = "vnd.android.cursor.item/firewall-log"

.field public static final CONTENT_TYPE:Ljava/lang/String; = "vnd.android.cursor.dir/firewall-log"

.field public static final CONTENT_URI:Landroid/net/Uri; = null

.field public static final CONTENT_URI_LOG_CONVERSATION:Landroid/net/Uri; = null

.field public static final DATA1:Ljava/lang/String; = "data1"

.field public static final DATA2:Ljava/lang/String; = "data2"

.field public static final DATE:Ljava/lang/String; = "date"

.field public static final NUMBER:Ljava/lang/String; = "number"

.field public static final READ:Ljava/lang/String; = "read"

.field public static final REASON:Ljava/lang/String; = "reason"

.field public static final REASON_BL_DELMMS:I = 0x6

.field public static final REASON_BL_DELSMS:I = 0x4

.field public static final REASON_BL_HANGUP:I = 0x1

.field public static final REASON_BL_MUTE:I = 0x2

.field public static final REASON_BL_MUTEMMS:I = 0x5

.field public static final REASON_BL_MUTESMS:I = 0x3

.field public static final REASON_FILTER_SMS:I = 0x10000

.field public static final REASON_IMPORT_SMS:I = 0x20000

.field public static final REASON_NONE:I = 0x0

.field public static final REASON_PRIVATE_CALL_HANGUP:I = 0x7

.field public static final REASON_WL_DELMMS:I = 0x106

.field public static final REASON_WL_DELSMS:I = 0x104

.field public static final REASON_WL_FLAG:I = 0x100

.field public static final REASON_WL_HANGUP:I = 0x101

.field public static final REASON_WL_MUTE:I = 0x102

.field public static final REASON_WL_MUTEMMS:I = 0x105

.field public static final REASON_WL_MUTESMS:I = 0x103

.field public static final TYPE:Ljava/lang/String; = "type"

.field public static final TYPE_CALL:I = 0x1

.field public static final TYPE_MMS:I = 0x3

.field public static final TYPE_SMS:I = 0x2

.field public static final TYPE_UNKNOWN:I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 967
    const-string v0, "content://firewall/log"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lmiui/provider/ExtraTelephony$FirewallLog;->CONTENT_URI:Landroid/net/Uri;

    .line 969
    const-string v0, "content://firewall/logconversation"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lmiui/provider/ExtraTelephony$FirewallLog;->CONTENT_URI_LOG_CONVERSATION:Landroid/net/Uri;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 963
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
