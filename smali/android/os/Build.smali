.class public Landroid/os/Build;
.super Ljava/lang/Object;
.source "Build.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/os/Build$VERSION_CODES;,
        Landroid/os/Build$VERSION;
    }
.end annotation


# static fields
.field public static final BOARD:Ljava/lang/String; = null

.field public static final BOOTLOADER:Ljava/lang/String; = null

.field public static final BRAND:Ljava/lang/String; = null

.field public static final CPU_ABI:Ljava/lang/String; = null

.field public static final CPU_ABI2:Ljava/lang/String; = null

.field public static final DEVICE:Ljava/lang/String; = null

.field public static final DISPLAY:Ljava/lang/String; = null

.field public static final FINGERPRINT:Ljava/lang/String; = null

.field public static final HARDWARE:Ljava/lang/String; = null

.field public static final HOST:Ljava/lang/String; = null

.field public static final ID:Ljava/lang/String; = null

#the value of this static final field might be set in the static constructor
.field public static final IS_DEBUGGABLE:Z = false

.field public static final MANUFACTURER:Ljava/lang/String; = null

.field public static final MODEL:Ljava/lang/String; = null

.field public static final PRODUCT:Ljava/lang/String; = null

.field public static final RADIO:Ljava/lang/String; = null
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final SERIAL:Ljava/lang/String; = null

.field public static final TAGS:Ljava/lang/String; = null

#the value of this static final field might be set in the static constructor
.field public static final TIME:J = 0x0L

.field public static final TYPE:Ljava/lang/String; = null

.field public static final UNKNOWN:Ljava/lang/String; = "unknown"

.field public static final USER:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .registers 6

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 29
    const-string/jumbo v2, "ro.build.id"

    invoke-static {v2}, Landroid/os/Build;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Landroid/os/Build;->ID:Ljava/lang/String;

    .line 32
    const-string/jumbo v2, "ro.build.display.id"

    invoke-static {v2}, Landroid/os/Build;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Landroid/os/Build;->DISPLAY:Ljava/lang/String;

    .line 35
    const-string/jumbo v2, "ro.product.name"

    invoke-static {v2}, Landroid/os/Build;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Landroid/os/Build;->PRODUCT:Ljava/lang/String;

    .line 38
    const-string/jumbo v2, "ro.product.device"

    invoke-static {v2}, Landroid/os/Build;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Landroid/os/Build;->DEVICE:Ljava/lang/String;

    .line 41
    const-string/jumbo v2, "ro.product.board"

    invoke-static {v2}, Landroid/os/Build;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Landroid/os/Build;->BOARD:Ljava/lang/String;

    .line 44
    const-string/jumbo v2, "ro.product.cpu.abi"

    invoke-static {v2}, Landroid/os/Build;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Landroid/os/Build;->CPU_ABI:Ljava/lang/String;

    .line 47
    const-string/jumbo v2, "ro.product.cpu.abi2"

    invoke-static {v2}, Landroid/os/Build;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Landroid/os/Build;->CPU_ABI2:Ljava/lang/String;

    .line 50
    const-string/jumbo v2, "ro.product.manufacturer"

    invoke-static {v2}, Landroid/os/Build;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    .line 53
    const-string/jumbo v2, "ro.product.brand"

    invoke-static {v2}, Landroid/os/Build;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Landroid/os/Build;->BRAND:Ljava/lang/String;

    .line 56
    const-string/jumbo v2, "ro.product.model"

    invoke-static {v2}, Landroid/os/Build;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Landroid/os/Build;->MODEL:Ljava/lang/String;

    .line 59
    const-string/jumbo v2, "ro.bootloader"

    invoke-static {v2}, Landroid/os/Build;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Landroid/os/Build;->BOOTLOADER:Ljava/lang/String;

    .line 70
    const-string v2, "gsm.version.baseband"

    invoke-static {v2}, Landroid/os/Build;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Landroid/os/Build;->RADIO:Ljava/lang/String;

    .line 73
    const-string/jumbo v2, "ro.hardware"

    invoke-static {v2}, Landroid/os/Build;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Landroid/os/Build;->HARDWARE:Ljava/lang/String;

    .line 76
    const-string/jumbo v2, "ro.serialno"

    invoke-static {v2}, Landroid/os/Build;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Landroid/os/Build;->SERIAL:Ljava/lang/String;

    .line 417
    const-string/jumbo v2, "ro.build.type"

    invoke-static {v2}, Landroid/os/Build;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Landroid/os/Build;->TYPE:Ljava/lang/String;

    .line 420
    const-string/jumbo v2, "ro.build.tags"

    invoke-static {v2}, Landroid/os/Build;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Landroid/os/Build;->TAGS:Ljava/lang/String;

    .line 423
    const-string/jumbo v2, "ro.build.fingerprint"

    invoke-static {v2}, Landroid/os/Build;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Landroid/os/Build;->FINGERPRINT:Ljava/lang/String;

    .line 426
    const-string/jumbo v2, "ro.build.date.utc"

    invoke-static {v2}, Landroid/os/Build;->getLong(Ljava/lang/String;)J

    move-result-wide v2

    const-wide/16 v4, 0x3e8

    mul-long/2addr v2, v4

    sput-wide v2, Landroid/os/Build;->TIME:J

    .line 427
    const-string/jumbo v2, "ro.build.user"

    invoke-static {v2}, Landroid/os/Build;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Landroid/os/Build;->USER:Ljava/lang/String;

    .line 428
    const-string/jumbo v2, "ro.build.host"

    invoke-static {v2}, Landroid/os/Build;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Landroid/os/Build;->HOST:Ljava/lang/String;

    .line 434
    const-string/jumbo v2, "ro.debuggable"

    invoke-static {v2, v1}, Landroid/os/SystemProperties;->getInt(Ljava/lang/String;I)I

    move-result v2

    if-ne v2, v0, :cond_c4

    :goto_c1
    sput-boolean v0, Landroid/os/Build;->IS_DEBUGGABLE:Z

    return-void

    :cond_c4
    move v0, v1

    goto :goto_c1
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 24
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 129
    return-void
.end method

.method static synthetic access$000(Ljava/lang/String;)Ljava/lang/String;
    .registers 2
    .parameter "x0"

    .prologue
    .line 24
    invoke-static {p0}, Landroid/os/Build;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static getLong(Ljava/lang/String;)J
    .registers 4
    .parameter "property"

    .prologue
    .line 451
    :try_start_0
    invoke-static {p0}, Landroid/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J
    :try_end_7
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_7} :catch_9

    move-result-wide v1

    .line 453
    :goto_8
    return-wide v1

    .line 452
    :catch_9
    move-exception v0

    .line 453
    .local v0, e:Ljava/lang/NumberFormatException;
    const-wide/16 v1, -0x1

    goto :goto_8
.end method

.method public static getRadioVersion()Ljava/lang/String;
    .registers 2

    .prologue
    .line 442
    const-string v0, "gsm.version.baseband"

    const/4 v1, 0x0

    invoke-static {v0, v1}, Landroid/os/SystemProperties;->get(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static getString(Ljava/lang/String;)Ljava/lang/String;
    .registers 2
    .parameter "property"

    .prologue
    .line 446
    const-string/jumbo v0, "unknown"

    invoke-static {p0, v0}, Landroid/os/SystemProperties;->get(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
