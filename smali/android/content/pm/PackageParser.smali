.class public Landroid/content/pm/PackageParser;
.super Ljava/lang/Object;
.source "PackageParser.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/content/pm/PackageParser$ServiceIntentInfo;,
        Landroid/content/pm/PackageParser$ActivityIntentInfo;,
        Landroid/content/pm/PackageParser$IntentInfo;,
        Landroid/content/pm/PackageParser$Instrumentation;,
        Landroid/content/pm/PackageParser$Provider;,
        Landroid/content/pm/PackageParser$Service;,
        Landroid/content/pm/PackageParser$Activity;,
        Landroid/content/pm/PackageParser$PermissionGroup;,
        Landroid/content/pm/PackageParser$Permission;,
        Landroid/content/pm/PackageParser$Component;,
        Landroid/content/pm/PackageParser$Package;,
        Landroid/content/pm/PackageParser$PackageLite;,
        Landroid/content/pm/PackageParser$ParseComponentArgs;,
        Landroid/content/pm/PackageParser$ParsePackageItemArgs;,
        Landroid/content/pm/PackageParser$SplitPermissionInfo;,
        Landroid/content/pm/PackageParser$NewPermissionInfo;
    }
.end annotation


# static fields
.field private static final ANDROID_MANIFEST_FILENAME:Ljava/lang/String; = "AndroidManifest.xml"

.field private static final ANDROID_RESOURCES:Ljava/lang/String; = "http://schemas.android.com/apk/res/android"

.field private static final DEBUG_BACKUP:Z = false

.field private static final DEBUG_JAR:Z = false

.field private static final DEBUG_PARSER:Z = false

.field public static final NEW_PERMISSIONS:[Landroid/content/pm/PackageParser$NewPermissionInfo; = null

.field public static final PARSE_CHATTY:I = 0x2

.field private static final PARSE_DEFAULT_INSTALL_LOCATION:I = -0x1

.field public static final PARSE_FORWARD_LOCK:I = 0x10

.field public static final PARSE_IGNORE_PROCESSES:I = 0x8

.field public static final PARSE_IS_SYSTEM:I = 0x1

.field public static final PARSE_IS_SYSTEM_DIR:I = 0x40

.field public static final PARSE_MUST_BE_APK:I = 0x4

.field public static final PARSE_ON_SDCARD:I = 0x20

.field private static final RIGID_PARSER:Z = false

.field private static final SDK_CODENAME:Ljava/lang/String; = null

#the value of this static final field might be set in the static constructor
.field private static final SDK_VERSION:I = 0x0

.field public static final SPLIT_PERMISSIONS:[Landroid/content/pm/PackageParser$SplitPermissionInfo; = null

.field private static final TAG:Ljava/lang/String; = "PackageParser"

.field private static mReadBuffer:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<[B>;"
        }
    .end annotation
.end field

.field private static final mSync:Ljava/lang/Object;

.field private static sCompatibilityModeEnabled:Z


# instance fields
.field private mArchiveSourcePath:Ljava/lang/String;

.field private mOnlyCoreApps:Z

.field private mParseActivityAliasArgs:Landroid/content/pm/PackageParser$ParseComponentArgs;

.field private mParseActivityArgs:Landroid/content/pm/PackageParser$ParseComponentArgs;

.field private mParseError:I

.field private mParseInstrumentationArgs:Landroid/content/pm/PackageParser$ParsePackageItemArgs;

.field private mParseProviderArgs:Landroid/content/pm/PackageParser$ParseComponentArgs;

.field private mParseServiceArgs:Landroid/content/pm/PackageParser$ParseComponentArgs;

.field private mSeparateProcesses:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .registers 9

    .prologue
    const/16 v8, 0x10

    const/4 v3, 0x4

    const/4 v7, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 119
    new-array v0, v7, [Landroid/content/pm/PackageParser$NewPermissionInfo;

    new-instance v1, Landroid/content/pm/PackageParser$NewPermissionInfo;

    const-string v2, "android.permission.WRITE_EXTERNAL_STORAGE"

    invoke-direct {v1, v2, v3, v5}, Landroid/content/pm/PackageParser$NewPermissionInfo;-><init>(Ljava/lang/String;II)V

    aput-object v1, v0, v5

    new-instance v1, Landroid/content/pm/PackageParser$NewPermissionInfo;

    const-string v2, "android.permission.READ_PHONE_STATE"

    invoke-direct {v1, v2, v3, v5}, Landroid/content/pm/PackageParser$NewPermissionInfo;-><init>(Ljava/lang/String;II)V

    aput-object v1, v0, v6

    sput-object v0, Landroid/content/pm/PackageParser;->NEW_PERMISSIONS:[Landroid/content/pm/PackageParser$NewPermissionInfo;

    .line 132
    const/4 v0, 0x3

    new-array v0, v0, [Landroid/content/pm/PackageParser$SplitPermissionInfo;

    new-instance v1, Landroid/content/pm/PackageParser$SplitPermissionInfo;

    const-string v2, "android.permission.WRITE_EXTERNAL_STORAGE"

    new-array v3, v6, [Ljava/lang/String;

    const-string v4, "android.permission.READ_EXTERNAL_STORAGE"

    aput-object v4, v3, v5

    const/16 v4, 0x2711

    invoke-direct {v1, v2, v3, v4}, Landroid/content/pm/PackageParser$SplitPermissionInfo;-><init>(Ljava/lang/String;[Ljava/lang/String;I)V

    aput-object v1, v0, v5

    new-instance v1, Landroid/content/pm/PackageParser$SplitPermissionInfo;

    const-string v2, "android.permission.READ_CONTACTS"

    new-array v3, v6, [Ljava/lang/String;

    const-string v4, "android.permission.READ_CALL_LOG"

    aput-object v4, v3, v5

    invoke-direct {v1, v2, v3, v8}, Landroid/content/pm/PackageParser$SplitPermissionInfo;-><init>(Ljava/lang/String;[Ljava/lang/String;I)V

    aput-object v1, v0, v6

    new-instance v1, Landroid/content/pm/PackageParser$SplitPermissionInfo;

    const-string v2, "android.permission.WRITE_CONTACTS"

    new-array v3, v6, [Ljava/lang/String;

    const-string v4, "android.permission.WRITE_CALL_LOG"

    aput-object v4, v3, v5

    invoke-direct {v1, v2, v3, v8}, Landroid/content/pm/PackageParser$SplitPermissionInfo;-><init>(Ljava/lang/String;[Ljava/lang/String;I)V

    aput-object v1, v0, v7

    sput-object v0, Landroid/content/pm/PackageParser;->SPLIT_PERMISSIONS:[Landroid/content/pm/PackageParser$SplitPermissionInfo;

    .line 152
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    sput v0, Landroid/content/pm/PackageParser;->SDK_VERSION:I

    .line 153
    const-string v0, "REL"

    sget-object v1, Landroid/os/Build$VERSION;->CODENAME:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6b

    const/4 v0, 0x0

    :goto_5f
    sput-object v0, Landroid/content/pm/PackageParser;->SDK_CODENAME:Ljava/lang/String;

    .line 158
    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Landroid/content/pm/PackageParser;->mSync:Ljava/lang/Object;

    .line 161
    sput-boolean v6, Landroid/content/pm/PackageParser;->sCompatibilityModeEnabled:Z

    return-void

    .line 153
    :cond_6b
    sget-object v0, Landroid/os/Build$VERSION;->CODENAME:Ljava/lang/String;

    goto :goto_5f
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .registers 3
    .parameter "archiveSourcePath"

    .prologue
    .line 234
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 156
    const/4 v0, 0x1

    iput v0, p0, Landroid/content/pm/PackageParser;->mParseError:I

    .line 235
    iput-object p1, p0, Landroid/content/pm/PackageParser;->mArchiveSourcePath:Ljava/lang/String;

    .line 236
    return-void
.end method

.method static synthetic access$000(Ljava/lang/String;Ljava/lang/CharSequence;[Ljava/lang/String;)Ljava/lang/String;
    .registers 4
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"

    .prologue
    .line 76
    invoke-static {p0, p1, p2}, Landroid/content/pm/PackageParser;->buildClassName(Ljava/lang/String;Ljava/lang/CharSequence;[Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$100(Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;I[Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    .registers 7
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"
    .parameter "x3"
    .parameter "x4"
    .parameter "x5"

    .prologue
    .line 76
    invoke-static/range {p0 .. p5}, Landroid/content/pm/PackageParser;->buildProcessName(Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;I[Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static buildClassName(Ljava/lang/String;Ljava/lang/CharSequence;[Ljava/lang/String;)Ljava/lang/String;
    .registers 10
    .parameter "pkg"
    .parameter "clsSeq"
    .parameter "outError"

    .prologue
    const/4 v3, 0x0

    const/16 v5, 0x2e

    const/4 v6, 0x0

    .line 1379
    if-eqz p1, :cond_c

    invoke-interface {p1}, Ljava/lang/CharSequence;->length()I

    move-result v4

    if-gtz v4, :cond_22

    .line 1380
    :cond_c
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Empty class name in package "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, p2, v6

    .line 1398
    :goto_21
    return-object v3

    .line 1383
    :cond_22
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    .line 1384
    .local v2, cls:Ljava/lang/String;
    invoke-virtual {v2, v6}, Ljava/lang/String;->charAt(I)C

    move-result v1

    .line 1385
    .local v1, c:C
    if-ne v1, v5, :cond_42

    .line 1386
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v3

    goto :goto_21

    .line 1388
    :cond_42
    invoke-virtual {v2, v5}, Ljava/lang/String;->indexOf(I)I

    move-result v4

    if-gez v4, :cond_5c

    .line 1389
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0, p0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 1390
    .local v0, b:Ljava/lang/StringBuilder;
    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1391
    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1392
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v3

    goto :goto_21

    .line 1394
    .end local v0           #b:Ljava/lang/StringBuilder;
    :cond_5c
    const/16 v4, 0x61

    if-lt v1, v4, :cond_69

    const/16 v4, 0x7a

    if-gt v1, v4, :cond_69

    .line 1395
    invoke-virtual {v2}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v3

    goto :goto_21

    .line 1397
    :cond_69
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Bad class name "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " in package "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, p2, v6

    goto :goto_21
.end method

.method private static buildCompoundName(Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    .registers 13
    .parameter "pkg"
    .parameter "procSeq"
    .parameter "type"
    .parameter "outError"

    .prologue
    const/4 v8, 0x1

    const/4 v4, 0x0

    const/4 v7, 0x0

    .line 1403
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    .line 1404
    .local v2, proc:Ljava/lang/String;
    invoke-virtual {v2, v7}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 1405
    .local v0, c:C
    if-eqz p0, :cond_9c

    const/16 v5, 0x3a

    if-ne v0, v5, :cond_9c

    .line 1406
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v5

    const/4 v6, 0x2

    if-ge v5, v6, :cond_48

    .line 1407
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Bad "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " name "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " in package "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ": must be at least two characters"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, p3, v7

    .line 1426
    :goto_47
    return-object v4

    .line 1411
    :cond_48
    invoke-virtual {v2, v8}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v3

    .line 1412
    .local v3, subName:Ljava/lang/String;
    invoke-static {v3, v7}, Landroid/content/pm/PackageParser;->validateName(Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v1

    .line 1413
    .local v1, nameError:Ljava/lang/String;
    if-eqz v1, :cond_86

    .line 1414
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Invalid "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " name "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " in package "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ": "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, p3, v7

    goto :goto_47

    .line 1418
    :cond_86
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v4

    goto :goto_47

    .line 1420
    .end local v1           #nameError:Ljava/lang/String;
    .end local v3           #subName:Ljava/lang/String;
    :cond_9c
    invoke-static {v2, v8}, Landroid/content/pm/PackageParser;->validateName(Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v1

    .line 1421
    .restart local v1       #nameError:Ljava/lang/String;
    if-eqz v1, :cond_e0

    const-string/jumbo v5, "system"

    invoke-virtual {v5, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_e0

    .line 1422
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Invalid "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " name "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " in package "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ": "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, p3, v7

    goto/16 :goto_47

    .line 1426
    :cond_e0
    invoke-virtual {v2}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v4

    goto/16 :goto_47
.end method

.method private static buildProcessName(Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;I[Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    .registers 9
    .parameter "pkg"
    .parameter "defProc"
    .parameter "procSeq"
    .parameter "flags"
    .parameter "separateProcesses"
    .parameter "outError"

    .prologue
    .line 1432
    and-int/lit8 v2, p3, 0x8

    if-eqz v2, :cond_12

    const-string/jumbo v2, "system"

    invoke-virtual {v2, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_12

    .line 1433
    if-eqz p1, :cond_10

    .line 1446
    .end local p1
    :cond_f
    :goto_f
    return-object p1

    .restart local p1
    :cond_10
    move-object p1, p0

    .line 1433
    goto :goto_f

    .line 1435
    :cond_12
    if-eqz p4, :cond_32

    .line 1436
    array-length v2, p4

    add-int/lit8 v0, v2, -0x1

    .local v0, i:I
    :goto_17
    if-ltz v0, :cond_32

    .line 1437
    aget-object v1, p4, v0

    .line 1438
    .local v1, sp:Ljava/lang/String;
    invoke-virtual {v1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_2d

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_2d

    invoke-virtual {v1, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2f

    :cond_2d
    move-object p1, p0

    .line 1439
    goto :goto_f

    .line 1436
    :cond_2f
    add-int/lit8 v0, v0, -0x1

    goto :goto_17

    .line 1443
    .end local v0           #i:I
    .end local v1           #sp:Ljava/lang/String;
    :cond_32
    if-eqz p2, :cond_f

    invoke-interface {p2}, Ljava/lang/CharSequence;->length()I

    move-result v2

    if-lez v2, :cond_f

    .line 1446
    const-string/jumbo v2, "process"

    invoke-static {p0, p2, v2, p5}, Landroid/content/pm/PackageParser;->buildCompoundName(Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    goto :goto_f
.end method

.method private static buildTaskAffinityName(Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;[Ljava/lang/String;)Ljava/lang/String;
    .registers 5
    .parameter "pkg"
    .parameter "defProc"
    .parameter "procSeq"
    .parameter "outError"

    .prologue
    .line 1451
    if-nez p2, :cond_3

    .line 1457
    .end local p1
    :goto_2
    return-object p1

    .line 1454
    .restart local p1
    :cond_3
    invoke-interface {p2}, Ljava/lang/CharSequence;->length()I

    move-result v0

    if-gtz v0, :cond_b

    .line 1455
    const/4 p1, 0x0

    goto :goto_2

    .line 1457
    :cond_b
    const-string/jumbo v0, "taskAffinity"

    invoke-static {p0, p2, v0, p3}, Landroid/content/pm/PackageParser;->buildCompoundName(Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    goto :goto_2
.end method

.method private checkPriority(II)I
    .registers 4
    .parameter "flags"
    .parameter "priority"
    .annotation build Landroid/annotation/MiuiHook;
        value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_METHOD:Landroid/annotation/MiuiHook$MiuiHookType;
    .end annotation

    .prologue
    .line 2958
    and-int/lit8 v0, p1, 0x1

    if-nez v0, :cond_a

    .line 2959
    const/16 v0, 0x3e8

    if-lt p2, v0, :cond_b

    .line 2960
    const/16 p2, 0x3e7

    .line 2965
    :cond_a
    :goto_a
    return p2

    .line 2961
    :cond_b
    const/16 v0, -0x3e8

    if-gt p2, v0, :cond_a

    .line 2962
    const/16 p2, -0x3e7

    goto :goto_a
.end method

.method private static copyNeeded(ILandroid/content/pm/PackageParser$Package;ILandroid/os/Bundle;)Z
    .registers 8
    .parameter "flags"
    .parameter "p"
    .parameter "enabledState"
    .parameter "metaData"

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 3435
    if-eqz p2, :cond_10

    .line 3436
    if-ne p2, v1, :cond_e

    move v0, v1

    .line 3437
    .local v0, enabled:Z
    :goto_7
    iget-object v3, p1, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget-boolean v3, v3, Landroid/content/pm/ApplicationInfo;->enabled:Z

    if-eq v3, v0, :cond_10

    .line 3449
    .end local v0           #enabled:Z
    :cond_d
    :goto_d
    return v1

    :cond_e
    move v0, v2

    .line 3436
    goto :goto_7

    .line 3441
    :cond_10
    and-int/lit16 v3, p0, 0x80

    if-eqz v3, :cond_1a

    if-nez p3, :cond_d

    iget-object v3, p1, Landroid/content/pm/PackageParser$Package;->mAppMetaData:Landroid/os/Bundle;

    if-nez v3, :cond_d

    .line 3445
    :cond_1a
    and-int/lit16 v3, p0, 0x400

    if-eqz v3, :cond_22

    iget-object v3, p1, Landroid/content/pm/PackageParser$Package;->usesLibraryFiles:[Ljava/lang/String;

    if-nez v3, :cond_d

    :cond_22
    move v1, v2

    .line 3449
    goto :goto_d
.end method

.method public static final generateActivityInfo(Landroid/content/pm/PackageParser$Activity;IZII)Landroid/content/pm/ActivityInfo;
    .registers 8
    .parameter "a"
    .parameter "flags"
    .parameter "stopped"
    .parameter "enabledState"
    .parameter "userId"

    .prologue
    .line 3556
    if-nez p0, :cond_4

    const/4 v0, 0x0

    .line 3564
    :goto_3
    return-object v0

    .line 3557
    :cond_4
    iget-object v1, p0, Landroid/content/pm/PackageParser$Component;->owner:Landroid/content/pm/PackageParser$Package;

    iget-object v2, p0, Landroid/content/pm/PackageParser$Component;->metaData:Landroid/os/Bundle;

    invoke-static {p1, v1, p3, v2}, Landroid/content/pm/PackageParser;->copyNeeded(ILandroid/content/pm/PackageParser$Package;ILandroid/os/Bundle;)Z

    move-result v1

    if-nez v1, :cond_13

    if-nez p4, :cond_13

    .line 3558
    iget-object v0, p0, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    goto :goto_3

    .line 3561
    :cond_13
    new-instance v0, Landroid/content/pm/ActivityInfo;

    iget-object v1, p0, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    invoke-direct {v0, v1}, Landroid/content/pm/ActivityInfo;-><init>(Landroid/content/pm/ActivityInfo;)V

    .line 3562
    .local v0, ai:Landroid/content/pm/ActivityInfo;
    iget-object v1, p0, Landroid/content/pm/PackageParser$Component;->metaData:Landroid/os/Bundle;

    iput-object v1, v0, Landroid/content/pm/PackageItemInfo;->metaData:Landroid/os/Bundle;

    .line 3563
    iget-object v1, p0, Landroid/content/pm/PackageParser$Component;->owner:Landroid/content/pm/PackageParser$Package;

    invoke-static {v1, p1, p2, p3, p4}, Landroid/content/pm/PackageParser;->generateApplicationInfo(Landroid/content/pm/PackageParser$Package;IZII)Landroid/content/pm/ApplicationInfo;

    move-result-object v1

    iput-object v1, v0, Landroid/content/pm/ComponentInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    goto :goto_3
.end method

.method public static generateApplicationInfo(Landroid/content/pm/PackageParser$Package;IZI)Landroid/content/pm/ApplicationInfo;
    .registers 5
    .parameter "p"
    .parameter "flags"
    .parameter "stopped"
    .parameter "enabledState"

    .prologue
    .line 3454
    invoke-static {}, Landroid/os/UserId;->getCallingUserId()I

    move-result v0

    invoke-static {p0, p1, p2, p3, v0}, Landroid/content/pm/PackageParser;->generateApplicationInfo(Landroid/content/pm/PackageParser$Package;IZII)Landroid/content/pm/ApplicationInfo;

    move-result-object v0

    return-object v0
.end method

.method public static generateApplicationInfo(Landroid/content/pm/PackageParser$Package;IZII)Landroid/content/pm/ApplicationInfo;
    .registers 13
    .parameter "p"
    .parameter "flags"
    .parameter "stopped"
    .parameter "enabledState"
    .parameter "userId"

    .prologue
    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x0

    const v3, -0x200001

    const/4 v4, 0x1

    .line 3459
    if-nez p0, :cond_b

    const/4 v0, 0x0

    .line 3508
    :goto_a
    return-object v0

    .line 3460
    :cond_b
    const/4 v1, 0x0

    invoke-static {p1, p0, p3, v1}, Landroid/content/pm/PackageParser;->copyNeeded(ILandroid/content/pm/PackageParser$Package;ILandroid/os/Bundle;)Z

    move-result v1

    if-nez v1, :cond_46

    if-nez p4, :cond_46

    .line 3463
    sget-boolean v1, Landroid/content/pm/PackageParser;->sCompatibilityModeEnabled:Z

    if-nez v1, :cond_1d

    .line 3464
    iget-object v1, p0, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    invoke-virtual {v1}, Landroid/content/pm/ApplicationInfo;->disableCompatibilityMode()V

    .line 3466
    :cond_1d
    if-eqz p2, :cond_35

    .line 3467
    iget-object v1, p0, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget v2, v1, Landroid/content/pm/ApplicationInfo;->flags:I

    const/high16 v3, 0x20

    or-int/2addr v2, v3

    iput v2, v1, Landroid/content/pm/ApplicationInfo;->flags:I

    .line 3471
    :goto_28
    if-ne p3, v4, :cond_3d

    .line 3472
    iget-object v1, p0, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iput-boolean v4, v1, Landroid/content/pm/ApplicationInfo;->enabled:Z

    .line 3477
    :cond_2e
    :goto_2e
    iget-object v1, p0, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iput p3, v1, Landroid/content/pm/ApplicationInfo;->enabledSetting:I

    .line 3478
    iget-object v0, p0, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    goto :goto_a

    .line 3469
    :cond_35
    iget-object v1, p0, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget v2, v1, Landroid/content/pm/ApplicationInfo;->flags:I

    and-int/2addr v2, v3

    iput v2, v1, Landroid/content/pm/ApplicationInfo;->flags:I

    goto :goto_28

    .line 3473
    :cond_3d
    if-eq p3, v6, :cond_41

    if-ne p3, v7, :cond_2e

    .line 3475
    :cond_41
    iget-object v1, p0, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iput-boolean v5, v1, Landroid/content/pm/ApplicationInfo;->enabled:Z

    goto :goto_2e

    .line 3482
    :cond_46
    new-instance v0, Landroid/content/pm/ApplicationInfo;

    iget-object v1, p0, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    invoke-direct {v0, v1}, Landroid/content/pm/ApplicationInfo;-><init>(Landroid/content/pm/ApplicationInfo;)V

    .line 3483
    .local v0, ai:Landroid/content/pm/ApplicationInfo;
    if-eqz p4, :cond_5f

    .line 3484
    iget v1, v0, Landroid/content/pm/ApplicationInfo;->uid:I

    invoke-static {p4, v1}, Landroid/os/UserId;->getUid(II)I

    move-result v1

    iput v1, v0, Landroid/content/pm/ApplicationInfo;->uid:I

    .line 3485
    iget-object v1, v0, Landroid/content/pm/PackageItemInfo;->packageName:Ljava/lang/String;

    invoke-static {p4, v1}, Landroid/content/pm/PackageManager;->getDataDirForUser(ILjava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Landroid/content/pm/ApplicationInfo;->dataDir:Ljava/lang/String;

    .line 3487
    :cond_5f
    and-int/lit16 v1, p1, 0x80

    if-eqz v1, :cond_67

    .line 3488
    iget-object v1, p0, Landroid/content/pm/PackageParser$Package;->mAppMetaData:Landroid/os/Bundle;

    iput-object v1, v0, Landroid/content/pm/PackageItemInfo;->metaData:Landroid/os/Bundle;

    .line 3490
    :cond_67
    and-int/lit16 v1, p1, 0x400

    if-eqz v1, :cond_6f

    .line 3491
    iget-object v1, p0, Landroid/content/pm/PackageParser$Package;->usesLibraryFiles:[Ljava/lang/String;

    iput-object v1, v0, Landroid/content/pm/ApplicationInfo;->sharedLibraryFiles:[Ljava/lang/String;

    .line 3493
    :cond_6f
    sget-boolean v1, Landroid/content/pm/PackageParser;->sCompatibilityModeEnabled:Z

    if-nez v1, :cond_76

    .line 3494
    invoke-virtual {v0}, Landroid/content/pm/ApplicationInfo;->disableCompatibilityMode()V

    .line 3496
    :cond_76
    if-eqz p2, :cond_86

    .line 3497
    iget v1, v0, Landroid/content/pm/ApplicationInfo;->flags:I

    const/high16 v2, 0x20

    or-int/2addr v1, v2

    iput v1, v0, Landroid/content/pm/ApplicationInfo;->flags:I

    .line 3501
    :goto_7f
    if-ne p3, v4, :cond_8c

    .line 3502
    iput-boolean v4, v0, Landroid/content/pm/ApplicationInfo;->enabled:Z

    .line 3507
    :cond_83
    :goto_83
    iput p3, v0, Landroid/content/pm/ApplicationInfo;->enabledSetting:I

    goto :goto_a

    .line 3499
    :cond_86
    iget v1, v0, Landroid/content/pm/ApplicationInfo;->flags:I

    and-int/2addr v1, v3

    iput v1, v0, Landroid/content/pm/ApplicationInfo;->flags:I

    goto :goto_7f

    .line 3503
    :cond_8c
    if-eq p3, v6, :cond_90

    if-ne p3, v7, :cond_83

    .line 3505
    :cond_90
    iput-boolean v5, v0, Landroid/content/pm/ApplicationInfo;->enabled:Z

    goto :goto_83
.end method

.method public static final generateInstrumentationInfo(Landroid/content/pm/PackageParser$Instrumentation;I)Landroid/content/pm/InstrumentationInfo;
    .registers 4
    .parameter "i"
    .parameter "flags"

    .prologue
    .line 3672
    if-nez p0, :cond_4

    const/4 v0, 0x0

    .line 3678
    :goto_3
    return-object v0

    .line 3673
    :cond_4
    and-int/lit16 v1, p1, 0x80

    if-nez v1, :cond_b

    .line 3674
    iget-object v0, p0, Landroid/content/pm/PackageParser$Instrumentation;->info:Landroid/content/pm/InstrumentationInfo;

    goto :goto_3

    .line 3676
    :cond_b
    new-instance v0, Landroid/content/pm/InstrumentationInfo;

    iget-object v1, p0, Landroid/content/pm/PackageParser$Instrumentation;->info:Landroid/content/pm/InstrumentationInfo;

    invoke-direct {v0, v1}, Landroid/content/pm/InstrumentationInfo;-><init>(Landroid/content/pm/InstrumentationInfo;)V

    .line 3677
    .local v0, ii:Landroid/content/pm/InstrumentationInfo;
    iget-object v1, p0, Landroid/content/pm/PackageParser$Component;->metaData:Landroid/os/Bundle;

    iput-object v1, v0, Landroid/content/pm/PackageItemInfo;->metaData:Landroid/os/Bundle;

    goto :goto_3
.end method

.method public static generatePackageInfo(Landroid/content/pm/PackageParser$Package;[IIJJLjava/util/HashSet;)Landroid/content/pm/PackageInfo;
    .registers 19
    .parameter "p"
    .parameter "gids"
    .parameter "flags"
    .parameter "firstInstallTime"
    .parameter "lastUpdateTime"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/pm/PackageParser$Package;",
            "[IIJJ",
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Landroid/content/pm/PackageInfo;"
        }
    .end annotation

    .prologue
    .line 254
    .local p7, grantedPermissions:Ljava/util/HashSet;,"Ljava/util/HashSet<Ljava/lang/String;>;"
    const/4 v8, 0x0

    const/4 v9, 0x0

    invoke-static {}, Landroid/os/UserId;->getCallingUserId()I

    move-result v10

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move-wide v3, p3

    move-wide/from16 v5, p5

    move-object/from16 v7, p7

    invoke-static/range {v0 .. v10}, Landroid/content/pm/PackageParser;->generatePackageInfo(Landroid/content/pm/PackageParser$Package;[IIJJLjava/util/HashSet;ZII)Landroid/content/pm/PackageInfo;

    move-result-object v0

    return-object v0
.end method

.method public static generatePackageInfo(Landroid/content/pm/PackageParser$Package;[IIJJLjava/util/HashSet;ZI)Landroid/content/pm/PackageInfo;
    .registers 21
    .parameter "p"
    .parameter "gids"
    .parameter "flags"
    .parameter "firstInstallTime"
    .parameter "lastUpdateTime"
    .parameter
    .parameter "stopped"
    .parameter "enabledState"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/pm/PackageParser$Package;",
            "[IIJJ",
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/String;",
            ">;ZI)",
            "Landroid/content/pm/PackageInfo;"
        }
    .end annotation

    .prologue
    .line 269
    .local p7, grantedPermissions:Ljava/util/HashSet;,"Ljava/util/HashSet<Ljava/lang/String;>;"
    invoke-static {}, Landroid/os/UserId;->getCallingUserId()I

    move-result v10

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move-wide v3, p3

    move-wide/from16 v5, p5

    move-object/from16 v7, p7

    move/from16 v8, p8

    move/from16 v9, p9

    invoke-static/range {v0 .. v10}, Landroid/content/pm/PackageParser;->generatePackageInfo(Landroid/content/pm/PackageParser$Package;[IIJJLjava/util/HashSet;ZII)Landroid/content/pm/PackageInfo;

    move-result-object v0

    return-object v0
.end method

.method public static generatePackageInfo(Landroid/content/pm/PackageParser$Package;[IIJJLjava/util/HashSet;ZII)Landroid/content/pm/PackageInfo;
    .registers 30
    .parameter "p"
    .parameter "gids"
    .parameter "flags"
    .parameter "firstInstallTime"
    .parameter "lastUpdateTime"
    .parameter
    .parameter "stopped"
    .parameter "enabledState"
    .parameter "userId"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/pm/PackageParser$Package;",
            "[IIJJ",
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/String;",
            ">;ZII)",
            "Landroid/content/pm/PackageInfo;"
        }
    .end annotation

    .prologue
    .line 277
    .local p7, grantedPermissions:Ljava/util/HashSet;,"Ljava/util/HashSet<Ljava/lang/String;>;"
    new-instance v12, Landroid/content/pm/PackageInfo;

    invoke-direct {v12}, Landroid/content/pm/PackageInfo;-><init>()V

    .line 278
    .local v12, pi:Landroid/content/pm/PackageInfo;
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/content/pm/PackageParser$Package;->packageName:Ljava/lang/String;

    iput-object v15, v12, Landroid/content/pm/PackageInfo;->packageName:Ljava/lang/String;

    .line 279
    move-object/from16 v0, p0

    iget v15, v0, Landroid/content/pm/PackageParser$Package;->mVersionCode:I

    iput v15, v12, Landroid/content/pm/PackageInfo;->versionCode:I

    .line 280
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/content/pm/PackageParser$Package;->mVersionName:Ljava/lang/String;

    iput-object v15, v12, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    .line 281
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/content/pm/PackageParser$Package;->mSharedUserId:Ljava/lang/String;

    iput-object v15, v12, Landroid/content/pm/PackageInfo;->sharedUserId:Ljava/lang/String;

    .line 282
    move-object/from16 v0, p0

    iget v15, v0, Landroid/content/pm/PackageParser$Package;->mSharedUserLabel:I

    iput v15, v12, Landroid/content/pm/PackageInfo;->sharedUserLabel:I

    .line 283
    move-object/from16 v0, p0

    move/from16 v1, p2

    move/from16 v2, p8

    move/from16 v3, p9

    move/from16 v4, p10

    invoke-static {v0, v1, v2, v3, v4}, Landroid/content/pm/PackageParser;->generateApplicationInfo(Landroid/content/pm/PackageParser$Package;IZII)Landroid/content/pm/ApplicationInfo;

    move-result-object v15

    iput-object v15, v12, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    .line 284
    move-object/from16 v0, p0

    iget v15, v0, Landroid/content/pm/PackageParser$Package;->installLocation:I

    iput v15, v12, Landroid/content/pm/PackageInfo;->installLocation:I

    .line 285
    move-wide/from16 v0, p3

    iput-wide v0, v12, Landroid/content/pm/PackageInfo;->firstInstallTime:J

    .line 286
    move-wide/from16 v0, p5

    iput-wide v0, v12, Landroid/content/pm/PackageInfo;->lastUpdateTime:J

    .line 287
    move/from16 v0, p2

    and-int/lit16 v15, v0, 0x100

    if-eqz v15, :cond_4b

    .line 288
    move-object/from16 v0, p1

    iput-object v0, v12, Landroid/content/pm/PackageInfo;->gids:[I

    .line 290
    :cond_4b
    move/from16 v0, p2

    and-int/lit16 v15, v0, 0x4000

    if-eqz v15, :cond_89

    .line 291
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/content/pm/PackageParser$Package;->configPreferences:Ljava/util/ArrayList;

    invoke-virtual {v15}, Ljava/util/ArrayList;->size()I

    move-result v5

    .line 292
    .local v5, N:I
    if-lez v5, :cond_6a

    .line 293
    new-array v15, v5, [Landroid/content/pm/ConfigurationInfo;

    iput-object v15, v12, Landroid/content/pm/PackageInfo;->configPreferences:[Landroid/content/pm/ConfigurationInfo;

    .line 294
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/content/pm/PackageParser$Package;->configPreferences:Ljava/util/ArrayList;

    iget-object v0, v12, Landroid/content/pm/PackageInfo;->configPreferences:[Landroid/content/pm/ConfigurationInfo;

    move-object/from16 v16, v0

    invoke-virtual/range {v15 .. v16}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    .line 296
    :cond_6a
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/content/pm/PackageParser$Package;->reqFeatures:Ljava/util/ArrayList;

    if-eqz v15, :cond_de

    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/content/pm/PackageParser$Package;->reqFeatures:Ljava/util/ArrayList;

    invoke-virtual {v15}, Ljava/util/ArrayList;->size()I

    move-result v5

    .line 297
    :goto_78
    if-lez v5, :cond_89

    .line 298
    new-array v15, v5, [Landroid/content/pm/FeatureInfo;

    iput-object v15, v12, Landroid/content/pm/PackageInfo;->reqFeatures:[Landroid/content/pm/FeatureInfo;

    .line 299
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/content/pm/PackageParser$Package;->reqFeatures:Ljava/util/ArrayList;

    iget-object v0, v12, Landroid/content/pm/PackageInfo;->reqFeatures:[Landroid/content/pm/FeatureInfo;

    move-object/from16 v16, v0

    invoke-virtual/range {v15 .. v16}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    .line 302
    .end local v5           #N:I
    :cond_89
    and-int/lit8 v15, p2, 0x1

    if-eqz v15, :cond_fe

    .line 303
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/content/pm/PackageParser$Package;->activities:Ljava/util/ArrayList;

    invoke-virtual {v15}, Ljava/util/ArrayList;->size()I

    move-result v5

    .line 304
    .restart local v5       #N:I
    if-lez v5, :cond_fe

    .line 305
    move/from16 v0, p2

    and-int/lit16 v15, v0, 0x200

    if-eqz v15, :cond_e0

    .line 306
    new-array v15, v5, [Landroid/content/pm/ActivityInfo;

    iput-object v15, v12, Landroid/content/pm/PackageInfo;->activities:[Landroid/content/pm/ActivityInfo;

    .line 314
    :goto_a1
    const/4 v7, 0x0

    .local v7, i:I
    const/4 v8, 0x0

    .local v8, j:I
    move v9, v8

    .end local v8           #j:I
    .local v9, j:I
    :goto_a4
    if-ge v7, v5, :cond_fe

    .line 315
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/content/pm/PackageParser$Package;->activities:Ljava/util/ArrayList;

    invoke-virtual {v15, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/content/pm/PackageParser$Activity;

    .line 316
    .local v6, activity:Landroid/content/pm/PackageParser$Activity;
    iget-object v15, v6, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    iget-boolean v15, v15, Landroid/content/pm/ComponentInfo;->enabled:Z

    if-nez v15, :cond_bc

    move/from16 v0, p2

    and-int/lit16 v15, v0, 0x200

    if-eqz v15, :cond_33b

    .line 318
    :cond_bc
    iget-object v0, v12, Landroid/content/pm/PackageInfo;->activities:[Landroid/content/pm/ActivityInfo;

    move-object/from16 v16, v0

    add-int/lit8 v8, v9, 0x1

    .end local v9           #j:I
    .restart local v8       #j:I
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/content/pm/PackageParser$Package;->activities:Ljava/util/ArrayList;

    invoke-virtual {v15, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Landroid/content/pm/PackageParser$Activity;

    move/from16 v0, p2

    move/from16 v1, p8

    move/from16 v2, p9

    move/from16 v3, p10

    invoke-static {v15, v0, v1, v2, v3}, Landroid/content/pm/PackageParser;->generateActivityInfo(Landroid/content/pm/PackageParser$Activity;IZII)Landroid/content/pm/ActivityInfo;

    move-result-object v15

    aput-object v15, v16, v9

    .line 314
    :goto_da
    add-int/lit8 v7, v7, 0x1

    move v9, v8

    .end local v8           #j:I
    .restart local v9       #j:I
    goto :goto_a4

    .line 296
    .end local v6           #activity:Landroid/content/pm/PackageParser$Activity;
    .end local v7           #i:I
    .end local v9           #j:I
    :cond_de
    const/4 v5, 0x0

    goto :goto_78

    .line 308
    :cond_e0
    const/4 v10, 0x0

    .line 309
    .local v10, num:I
    const/4 v7, 0x0

    .restart local v7       #i:I
    :goto_e2
    if-ge v7, v5, :cond_f9

    .line 310
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/content/pm/PackageParser$Package;->activities:Ljava/util/ArrayList;

    invoke-virtual {v15, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Landroid/content/pm/PackageParser$Activity;

    iget-object v15, v15, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    iget-boolean v15, v15, Landroid/content/pm/ComponentInfo;->enabled:Z

    if-eqz v15, :cond_f6

    add-int/lit8 v10, v10, 0x1

    .line 309
    :cond_f6
    add-int/lit8 v7, v7, 0x1

    goto :goto_e2

    .line 312
    :cond_f9
    new-array v15, v10, [Landroid/content/pm/ActivityInfo;

    iput-object v15, v12, Landroid/content/pm/PackageInfo;->activities:[Landroid/content/pm/ActivityInfo;

    goto :goto_a1

    .line 324
    .end local v5           #N:I
    .end local v7           #i:I
    .end local v10           #num:I
    :cond_fe
    and-int/lit8 v15, p2, 0x2

    if-eqz v15, :cond_171

    .line 325
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/content/pm/PackageParser$Package;->receivers:Ljava/util/ArrayList;

    invoke-virtual {v15}, Ljava/util/ArrayList;->size()I

    move-result v5

    .line 326
    .restart local v5       #N:I
    if-lez v5, :cond_171

    .line 327
    move/from16 v0, p2

    and-int/lit16 v15, v0, 0x200

    if-eqz v15, :cond_153

    .line 328
    new-array v15, v5, [Landroid/content/pm/ActivityInfo;

    iput-object v15, v12, Landroid/content/pm/PackageInfo;->receivers:[Landroid/content/pm/ActivityInfo;

    .line 336
    :goto_116
    const/4 v7, 0x0

    .restart local v7       #i:I
    const/4 v8, 0x0

    .restart local v8       #j:I
    move v9, v8

    .end local v8           #j:I
    .restart local v9       #j:I
    :goto_119
    if-ge v7, v5, :cond_171

    .line 337
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/content/pm/PackageParser$Package;->receivers:Ljava/util/ArrayList;

    invoke-virtual {v15, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/content/pm/PackageParser$Activity;

    .line 338
    .restart local v6       #activity:Landroid/content/pm/PackageParser$Activity;
    iget-object v15, v6, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    iget-boolean v15, v15, Landroid/content/pm/ComponentInfo;->enabled:Z

    if-nez v15, :cond_131

    move/from16 v0, p2

    and-int/lit16 v15, v0, 0x200

    if-eqz v15, :cond_338

    .line 340
    :cond_131
    iget-object v0, v12, Landroid/content/pm/PackageInfo;->receivers:[Landroid/content/pm/ActivityInfo;

    move-object/from16 v16, v0

    add-int/lit8 v8, v9, 0x1

    .end local v9           #j:I
    .restart local v8       #j:I
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/content/pm/PackageParser$Package;->receivers:Ljava/util/ArrayList;

    invoke-virtual {v15, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Landroid/content/pm/PackageParser$Activity;

    move/from16 v0, p2

    move/from16 v1, p8

    move/from16 v2, p9

    move/from16 v3, p10

    invoke-static {v15, v0, v1, v2, v3}, Landroid/content/pm/PackageParser;->generateActivityInfo(Landroid/content/pm/PackageParser$Activity;IZII)Landroid/content/pm/ActivityInfo;

    move-result-object v15

    aput-object v15, v16, v9

    .line 336
    :goto_14f
    add-int/lit8 v7, v7, 0x1

    move v9, v8

    .end local v8           #j:I
    .restart local v9       #j:I
    goto :goto_119

    .line 330
    .end local v6           #activity:Landroid/content/pm/PackageParser$Activity;
    .end local v7           #i:I
    .end local v9           #j:I
    :cond_153
    const/4 v10, 0x0

    .line 331
    .restart local v10       #num:I
    const/4 v7, 0x0

    .restart local v7       #i:I
    :goto_155
    if-ge v7, v5, :cond_16c

    .line 332
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/content/pm/PackageParser$Package;->receivers:Ljava/util/ArrayList;

    invoke-virtual {v15, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Landroid/content/pm/PackageParser$Activity;

    iget-object v15, v15, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    iget-boolean v15, v15, Landroid/content/pm/ComponentInfo;->enabled:Z

    if-eqz v15, :cond_169

    add-int/lit8 v10, v10, 0x1

    .line 331
    :cond_169
    add-int/lit8 v7, v7, 0x1

    goto :goto_155

    .line 334
    :cond_16c
    new-array v15, v10, [Landroid/content/pm/ActivityInfo;

    iput-object v15, v12, Landroid/content/pm/PackageInfo;->receivers:[Landroid/content/pm/ActivityInfo;

    goto :goto_116

    .line 346
    .end local v5           #N:I
    .end local v7           #i:I
    .end local v10           #num:I
    :cond_171
    and-int/lit8 v15, p2, 0x4

    if-eqz v15, :cond_1e4

    .line 347
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/content/pm/PackageParser$Package;->services:Ljava/util/ArrayList;

    invoke-virtual {v15}, Ljava/util/ArrayList;->size()I

    move-result v5

    .line 348
    .restart local v5       #N:I
    if-lez v5, :cond_1e4

    .line 349
    move/from16 v0, p2

    and-int/lit16 v15, v0, 0x200

    if-eqz v15, :cond_1c6

    .line 350
    new-array v15, v5, [Landroid/content/pm/ServiceInfo;

    iput-object v15, v12, Landroid/content/pm/PackageInfo;->services:[Landroid/content/pm/ServiceInfo;

    .line 358
    :goto_189
    const/4 v7, 0x0

    .restart local v7       #i:I
    const/4 v8, 0x0

    .restart local v8       #j:I
    move v9, v8

    .end local v8           #j:I
    .restart local v9       #j:I
    :goto_18c
    if-ge v7, v5, :cond_1e4

    .line 359
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/content/pm/PackageParser$Package;->services:Ljava/util/ArrayList;

    invoke-virtual {v15, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Landroid/content/pm/PackageParser$Service;

    .line 360
    .local v14, service:Landroid/content/pm/PackageParser$Service;
    iget-object v15, v14, Landroid/content/pm/PackageParser$Service;->info:Landroid/content/pm/ServiceInfo;

    iget-boolean v15, v15, Landroid/content/pm/ComponentInfo;->enabled:Z

    if-nez v15, :cond_1a4

    move/from16 v0, p2

    and-int/lit16 v15, v0, 0x200

    if-eqz v15, :cond_335

    .line 362
    :cond_1a4
    iget-object v0, v12, Landroid/content/pm/PackageInfo;->services:[Landroid/content/pm/ServiceInfo;

    move-object/from16 v16, v0

    add-int/lit8 v8, v9, 0x1

    .end local v9           #j:I
    .restart local v8       #j:I
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/content/pm/PackageParser$Package;->services:Ljava/util/ArrayList;

    invoke-virtual {v15, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Landroid/content/pm/PackageParser$Service;

    move/from16 v0, p2

    move/from16 v1, p8

    move/from16 v2, p9

    move/from16 v3, p10

    invoke-static {v15, v0, v1, v2, v3}, Landroid/content/pm/PackageParser;->generateServiceInfo(Landroid/content/pm/PackageParser$Service;IZII)Landroid/content/pm/ServiceInfo;

    move-result-object v15

    aput-object v15, v16, v9

    .line 358
    :goto_1c2
    add-int/lit8 v7, v7, 0x1

    move v9, v8

    .end local v8           #j:I
    .restart local v9       #j:I
    goto :goto_18c

    .line 352
    .end local v7           #i:I
    .end local v9           #j:I
    .end local v14           #service:Landroid/content/pm/PackageParser$Service;
    :cond_1c6
    const/4 v10, 0x0

    .line 353
    .restart local v10       #num:I
    const/4 v7, 0x0

    .restart local v7       #i:I
    :goto_1c8
    if-ge v7, v5, :cond_1df

    .line 354
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/content/pm/PackageParser$Package;->services:Ljava/util/ArrayList;

    invoke-virtual {v15, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Landroid/content/pm/PackageParser$Service;

    iget-object v15, v15, Landroid/content/pm/PackageParser$Service;->info:Landroid/content/pm/ServiceInfo;

    iget-boolean v15, v15, Landroid/content/pm/ComponentInfo;->enabled:Z

    if-eqz v15, :cond_1dc

    add-int/lit8 v10, v10, 0x1

    .line 353
    :cond_1dc
    add-int/lit8 v7, v7, 0x1

    goto :goto_1c8

    .line 356
    :cond_1df
    new-array v15, v10, [Landroid/content/pm/ServiceInfo;

    iput-object v15, v12, Landroid/content/pm/PackageInfo;->services:[Landroid/content/pm/ServiceInfo;

    goto :goto_189

    .line 368
    .end local v5           #N:I
    .end local v7           #i:I
    .end local v10           #num:I
    :cond_1e4
    and-int/lit8 v15, p2, 0x8

    if-eqz v15, :cond_257

    .line 369
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/content/pm/PackageParser$Package;->providers:Ljava/util/ArrayList;

    invoke-virtual {v15}, Ljava/util/ArrayList;->size()I

    move-result v5

    .line 370
    .restart local v5       #N:I
    if-lez v5, :cond_257

    .line 371
    move/from16 v0, p2

    and-int/lit16 v15, v0, 0x200

    if-eqz v15, :cond_239

    .line 372
    new-array v15, v5, [Landroid/content/pm/ProviderInfo;

    iput-object v15, v12, Landroid/content/pm/PackageInfo;->providers:[Landroid/content/pm/ProviderInfo;

    .line 380
    :goto_1fc
    const/4 v7, 0x0

    .restart local v7       #i:I
    const/4 v8, 0x0

    .restart local v8       #j:I
    move v9, v8

    .end local v8           #j:I
    .restart local v9       #j:I
    :goto_1ff
    if-ge v7, v5, :cond_257

    .line 381
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/content/pm/PackageParser$Package;->providers:Ljava/util/ArrayList;

    invoke-virtual {v15, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Landroid/content/pm/PackageParser$Provider;

    .line 382
    .local v13, provider:Landroid/content/pm/PackageParser$Provider;
    iget-object v15, v13, Landroid/content/pm/PackageParser$Provider;->info:Landroid/content/pm/ProviderInfo;

    iget-boolean v15, v15, Landroid/content/pm/ComponentInfo;->enabled:Z

    if-nez v15, :cond_217

    move/from16 v0, p2

    and-int/lit16 v15, v0, 0x200

    if-eqz v15, :cond_332

    .line 384
    :cond_217
    iget-object v0, v12, Landroid/content/pm/PackageInfo;->providers:[Landroid/content/pm/ProviderInfo;

    move-object/from16 v16, v0

    add-int/lit8 v8, v9, 0x1

    .end local v9           #j:I
    .restart local v8       #j:I
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/content/pm/PackageParser$Package;->providers:Ljava/util/ArrayList;

    invoke-virtual {v15, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Landroid/content/pm/PackageParser$Provider;

    move/from16 v0, p2

    move/from16 v1, p8

    move/from16 v2, p9

    move/from16 v3, p10

    invoke-static {v15, v0, v1, v2, v3}, Landroid/content/pm/PackageParser;->generateProviderInfo(Landroid/content/pm/PackageParser$Provider;IZII)Landroid/content/pm/ProviderInfo;

    move-result-object v15

    aput-object v15, v16, v9

    .line 380
    :goto_235
    add-int/lit8 v7, v7, 0x1

    move v9, v8

    .end local v8           #j:I
    .restart local v9       #j:I
    goto :goto_1ff

    .line 374
    .end local v7           #i:I
    .end local v9           #j:I
    .end local v13           #provider:Landroid/content/pm/PackageParser$Provider;
    :cond_239
    const/4 v10, 0x0

    .line 375
    .restart local v10       #num:I
    const/4 v7, 0x0

    .restart local v7       #i:I
    :goto_23b
    if-ge v7, v5, :cond_252

    .line 376
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/content/pm/PackageParser$Package;->providers:Ljava/util/ArrayList;

    invoke-virtual {v15, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Landroid/content/pm/PackageParser$Provider;

    iget-object v15, v15, Landroid/content/pm/PackageParser$Provider;->info:Landroid/content/pm/ProviderInfo;

    iget-boolean v15, v15, Landroid/content/pm/ComponentInfo;->enabled:Z

    if-eqz v15, :cond_24f

    add-int/lit8 v10, v10, 0x1

    .line 375
    :cond_24f
    add-int/lit8 v7, v7, 0x1

    goto :goto_23b

    .line 378
    :cond_252
    new-array v15, v10, [Landroid/content/pm/ProviderInfo;

    iput-object v15, v12, Landroid/content/pm/PackageInfo;->providers:[Landroid/content/pm/ProviderInfo;

    goto :goto_1fc

    .line 390
    .end local v5           #N:I
    .end local v7           #i:I
    .end local v10           #num:I
    :cond_257
    and-int/lit8 v15, p2, 0x10

    if-eqz v15, :cond_285

    .line 391
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/content/pm/PackageParser$Package;->instrumentation:Ljava/util/ArrayList;

    invoke-virtual {v15}, Ljava/util/ArrayList;->size()I

    move-result v5

    .line 392
    .restart local v5       #N:I
    if-lez v5, :cond_285

    .line 393
    new-array v15, v5, [Landroid/content/pm/InstrumentationInfo;

    iput-object v15, v12, Landroid/content/pm/PackageInfo;->instrumentation:[Landroid/content/pm/InstrumentationInfo;

    .line 394
    const/4 v7, 0x0

    .restart local v7       #i:I
    :goto_26a
    if-ge v7, v5, :cond_285

    .line 395
    iget-object v0, v12, Landroid/content/pm/PackageInfo;->instrumentation:[Landroid/content/pm/InstrumentationInfo;

    move-object/from16 v16, v0

    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/content/pm/PackageParser$Package;->instrumentation:Ljava/util/ArrayList;

    invoke-virtual {v15, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Landroid/content/pm/PackageParser$Instrumentation;

    move/from16 v0, p2

    invoke-static {v15, v0}, Landroid/content/pm/PackageParser;->generateInstrumentationInfo(Landroid/content/pm/PackageParser$Instrumentation;I)Landroid/content/pm/InstrumentationInfo;

    move-result-object v15

    aput-object v15, v16, v7

    .line 394
    add-int/lit8 v7, v7, 0x1

    goto :goto_26a

    .line 400
    .end local v5           #N:I
    .end local v7           #i:I
    :cond_285
    move/from16 v0, p2

    and-int/lit16 v15, v0, 0x1000

    if-eqz v15, :cond_305

    .line 401
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/content/pm/PackageParser$Package;->permissions:Ljava/util/ArrayList;

    invoke-virtual {v15}, Ljava/util/ArrayList;->size()I

    move-result v5

    .line 402
    .restart local v5       #N:I
    if-lez v5, :cond_2b5

    .line 403
    new-array v15, v5, [Landroid/content/pm/PermissionInfo;

    iput-object v15, v12, Landroid/content/pm/PackageInfo;->permissions:[Landroid/content/pm/PermissionInfo;

    .line 404
    const/4 v7, 0x0

    .restart local v7       #i:I
    :goto_29a
    if-ge v7, v5, :cond_2b5

    .line 405
    iget-object v0, v12, Landroid/content/pm/PackageInfo;->permissions:[Landroid/content/pm/PermissionInfo;

    move-object/from16 v16, v0

    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/content/pm/PackageParser$Package;->permissions:Ljava/util/ArrayList;

    invoke-virtual {v15, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Landroid/content/pm/PackageParser$Permission;

    move/from16 v0, p2

    invoke-static {v15, v0}, Landroid/content/pm/PackageParser;->generatePermissionInfo(Landroid/content/pm/PackageParser$Permission;I)Landroid/content/pm/PermissionInfo;

    move-result-object v15

    aput-object v15, v16, v7

    .line 404
    add-int/lit8 v7, v7, 0x1

    goto :goto_29a

    .line 408
    .end local v7           #i:I
    :cond_2b5
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/content/pm/PackageParser$Package;->requestedPermissions:Ljava/util/ArrayList;

    invoke-virtual {v15}, Ljava/util/ArrayList;->size()I

    move-result v5

    .line 409
    if-lez v5, :cond_305

    .line 410
    new-array v15, v5, [Ljava/lang/String;

    iput-object v15, v12, Landroid/content/pm/PackageInfo;->requestedPermissions:[Ljava/lang/String;

    .line 411
    new-array v15, v5, [I

    iput-object v15, v12, Landroid/content/pm/PackageInfo;->requestedPermissionsFlags:[I

    .line 412
    const/4 v7, 0x0

    .restart local v7       #i:I
    :goto_2c8
    if-ge v7, v5, :cond_305

    .line 413
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/content/pm/PackageParser$Package;->requestedPermissions:Ljava/util/ArrayList;

    invoke-virtual {v15, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/lang/String;

    .line 414
    .local v11, perm:Ljava/lang/String;
    iget-object v15, v12, Landroid/content/pm/PackageInfo;->requestedPermissions:[Ljava/lang/String;

    aput-object v11, v15, v7

    .line 415
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/content/pm/PackageParser$Package;->requestedPermissionsRequired:Ljava/util/ArrayList;

    invoke-virtual {v15, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Ljava/lang/Boolean;

    invoke-virtual {v15}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v15

    if-eqz v15, :cond_2f0

    .line 416
    iget-object v15, v12, Landroid/content/pm/PackageInfo;->requestedPermissionsFlags:[I

    aget v16, v15, v7

    or-int/lit8 v16, v16, 0x1

    aput v16, v15, v7

    .line 418
    :cond_2f0
    if-eqz p7, :cond_302

    move-object/from16 v0, p7

    invoke-virtual {v0, v11}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v15

    if-eqz v15, :cond_302

    .line 419
    iget-object v15, v12, Landroid/content/pm/PackageInfo;->requestedPermissionsFlags:[I

    aget v16, v15, v7

    or-int/lit8 v16, v16, 0x2

    aput v16, v15, v7

    .line 412
    :cond_302
    add-int/lit8 v7, v7, 0x1

    goto :goto_2c8

    .line 424
    .end local v5           #N:I
    .end local v7           #i:I
    .end local v11           #perm:Ljava/lang/String;
    :cond_305
    and-int/lit8 v15, p2, 0x40

    if-eqz v15, :cond_32f

    .line 425
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/content/pm/PackageParser$Package;->mSignatures:[Landroid/content/pm/Signature;

    if-eqz v15, :cond_330

    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/content/pm/PackageParser$Package;->mSignatures:[Landroid/content/pm/Signature;

    array-length v5, v15

    .line 426
    .restart local v5       #N:I
    :goto_314
    if-lez v5, :cond_32f

    .line 427
    new-array v15, v5, [Landroid/content/pm/Signature;

    iput-object v15, v12, Landroid/content/pm/PackageInfo;->signatures:[Landroid/content/pm/Signature;

    .line 428
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/content/pm/PackageParser$Package;->mSignatures:[Landroid/content/pm/Signature;

    const/16 v16, 0x0

    iget-object v0, v12, Landroid/content/pm/PackageInfo;->signatures:[Landroid/content/pm/Signature;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    move/from16 v0, v16

    move-object/from16 v1, v17

    move/from16 v2, v18

    invoke-static {v15, v0, v1, v2, v5}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 431
    .end local v5           #N:I
    :cond_32f
    return-object v12

    .line 425
    :cond_330
    const/4 v5, 0x0

    goto :goto_314

    .restart local v5       #N:I
    .restart local v7       #i:I
    .restart local v9       #j:I
    .restart local v13       #provider:Landroid/content/pm/PackageParser$Provider;
    :cond_332
    move v8, v9

    .end local v9           #j:I
    .restart local v8       #j:I
    goto/16 :goto_235

    .end local v8           #j:I
    .end local v13           #provider:Landroid/content/pm/PackageParser$Provider;
    .restart local v9       #j:I
    .restart local v14       #service:Landroid/content/pm/PackageParser$Service;
    :cond_335
    move v8, v9

    .end local v9           #j:I
    .restart local v8       #j:I
    goto/16 :goto_1c2

    .end local v8           #j:I
    .end local v14           #service:Landroid/content/pm/PackageParser$Service;
    .restart local v6       #activity:Landroid/content/pm/PackageParser$Activity;
    .restart local v9       #j:I
    :cond_338
    move v8, v9

    .end local v9           #j:I
    .restart local v8       #j:I
    goto/16 :goto_14f

    .end local v8           #j:I
    .restart local v9       #j:I
    :cond_33b
    move v8, v9

    .end local v9           #j:I
    .restart local v8       #j:I
    goto/16 :goto_da
.end method

.method public static final generatePermissionGroupInfo(Landroid/content/pm/PackageParser$PermissionGroup;I)Landroid/content/pm/PermissionGroupInfo;
    .registers 4
    .parameter "pg"
    .parameter "flags"

    .prologue
    .line 3524
    if-nez p0, :cond_4

    const/4 v0, 0x0

    .line 3530
    :goto_3
    return-object v0

    .line 3525
    :cond_4
    and-int/lit16 v1, p1, 0x80

    if-nez v1, :cond_b

    .line 3526
    iget-object v0, p0, Landroid/content/pm/PackageParser$PermissionGroup;->info:Landroid/content/pm/PermissionGroupInfo;

    goto :goto_3

    .line 3528
    :cond_b
    new-instance v0, Landroid/content/pm/PermissionGroupInfo;

    iget-object v1, p0, Landroid/content/pm/PackageParser$PermissionGroup;->info:Landroid/content/pm/PermissionGroupInfo;

    invoke-direct {v0, v1}, Landroid/content/pm/PermissionGroupInfo;-><init>(Landroid/content/pm/PermissionGroupInfo;)V

    .line 3529
    .local v0, pgi:Landroid/content/pm/PermissionGroupInfo;
    iget-object v1, p0, Landroid/content/pm/PackageParser$Component;->metaData:Landroid/os/Bundle;

    iput-object v1, v0, Landroid/content/pm/PackageItemInfo;->metaData:Landroid/os/Bundle;

    goto :goto_3
.end method

.method public static final generatePermissionInfo(Landroid/content/pm/PackageParser$Permission;I)Landroid/content/pm/PermissionInfo;
    .registers 4
    .parameter "p"
    .parameter "flags"

    .prologue
    .line 3513
    if-nez p0, :cond_4

    const/4 v0, 0x0

    .line 3519
    :goto_3
    return-object v0

    .line 3514
    :cond_4
    and-int/lit16 v1, p1, 0x80

    if-nez v1, :cond_b

    .line 3515
    iget-object v0, p0, Landroid/content/pm/PackageParser$Permission;->info:Landroid/content/pm/PermissionInfo;

    goto :goto_3

    .line 3517
    :cond_b
    new-instance v0, Landroid/content/pm/PermissionInfo;

    iget-object v1, p0, Landroid/content/pm/PackageParser$Permission;->info:Landroid/content/pm/PermissionInfo;

    invoke-direct {v0, v1}, Landroid/content/pm/PermissionInfo;-><init>(Landroid/content/pm/PermissionInfo;)V

    .line 3518
    .local v0, pi:Landroid/content/pm/PermissionInfo;
    iget-object v1, p0, Landroid/content/pm/PackageParser$Component;->metaData:Landroid/os/Bundle;

    iput-object v1, v0, Landroid/content/pm/PackageItemInfo;->metaData:Landroid/os/Bundle;

    goto :goto_3
.end method

.method public static final generateProviderInfo(Landroid/content/pm/PackageParser$Provider;IZII)Landroid/content/pm/ProviderInfo;
    .registers 9
    .parameter "p"
    .parameter "flags"
    .parameter "stopped"
    .parameter "enabledState"
    .parameter "userId"

    .prologue
    const/4 v1, 0x0

    .line 3633
    if-nez p0, :cond_5

    move-object v0, v1

    .line 3647
    :goto_4
    return-object v0

    .line 3634
    :cond_5
    iget-object v2, p0, Landroid/content/pm/PackageParser$Component;->owner:Landroid/content/pm/PackageParser$Package;

    iget-object v3, p0, Landroid/content/pm/PackageParser$Component;->metaData:Landroid/os/Bundle;

    invoke-static {p1, v2, p3, v3}, Landroid/content/pm/PackageParser;->copyNeeded(ILandroid/content/pm/PackageParser$Package;ILandroid/os/Bundle;)Z

    move-result v2

    if-nez v2, :cond_1e

    and-int/lit16 v2, p1, 0x800

    if-nez v2, :cond_19

    iget-object v2, p0, Landroid/content/pm/PackageParser$Provider;->info:Landroid/content/pm/ProviderInfo;

    iget-object v2, v2, Landroid/content/pm/ProviderInfo;->uriPermissionPatterns:[Landroid/os/PatternMatcher;

    if-nez v2, :cond_1e

    :cond_19
    if-nez p4, :cond_1e

    .line 3638
    iget-object v0, p0, Landroid/content/pm/PackageParser$Provider;->info:Landroid/content/pm/ProviderInfo;

    goto :goto_4

    .line 3641
    :cond_1e
    new-instance v0, Landroid/content/pm/ProviderInfo;

    iget-object v2, p0, Landroid/content/pm/PackageParser$Provider;->info:Landroid/content/pm/ProviderInfo;

    invoke-direct {v0, v2}, Landroid/content/pm/ProviderInfo;-><init>(Landroid/content/pm/ProviderInfo;)V

    .line 3642
    .local v0, pi:Landroid/content/pm/ProviderInfo;
    iget-object v2, p0, Landroid/content/pm/PackageParser$Component;->metaData:Landroid/os/Bundle;

    iput-object v2, v0, Landroid/content/pm/PackageItemInfo;->metaData:Landroid/os/Bundle;

    .line 3643
    and-int/lit16 v2, p1, 0x800

    if-nez v2, :cond_2f

    .line 3644
    iput-object v1, v0, Landroid/content/pm/ProviderInfo;->uriPermissionPatterns:[Landroid/os/PatternMatcher;

    .line 3646
    :cond_2f
    iget-object v1, p0, Landroid/content/pm/PackageParser$Component;->owner:Landroid/content/pm/PackageParser$Package;

    invoke-static {v1, p1, p2, p3, p4}, Landroid/content/pm/PackageParser;->generateApplicationInfo(Landroid/content/pm/PackageParser$Package;IZII)Landroid/content/pm/ApplicationInfo;

    move-result-object v1

    iput-object v1, v0, Landroid/content/pm/ComponentInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    goto :goto_4
.end method

.method public static final generateServiceInfo(Landroid/content/pm/PackageParser$Service;IZII)Landroid/content/pm/ServiceInfo;
    .registers 8
    .parameter "s"
    .parameter "flags"
    .parameter "stopped"
    .parameter "enabledState"
    .parameter "userId"

    .prologue
    .line 3590
    if-nez p0, :cond_4

    const/4 v0, 0x0

    .line 3599
    :goto_3
    return-object v0

    .line 3591
    :cond_4
    iget-object v1, p0, Landroid/content/pm/PackageParser$Component;->owner:Landroid/content/pm/PackageParser$Package;

    iget-object v2, p0, Landroid/content/pm/PackageParser$Component;->metaData:Landroid/os/Bundle;

    invoke-static {p1, v1, p3, v2}, Landroid/content/pm/PackageParser;->copyNeeded(ILandroid/content/pm/PackageParser$Package;ILandroid/os/Bundle;)Z

    move-result v1

    if-nez v1, :cond_1d

    iget-object v1, p0, Landroid/content/pm/PackageParser$Service;->info:Landroid/content/pm/ServiceInfo;

    iget-object v1, v1, Landroid/content/pm/ComponentInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget v1, v1, Landroid/content/pm/ApplicationInfo;->uid:I

    invoke-static {v1}, Landroid/os/UserId;->getUserId(I)I

    move-result v1

    if-ne p4, v1, :cond_1d

    .line 3593
    iget-object v0, p0, Landroid/content/pm/PackageParser$Service;->info:Landroid/content/pm/ServiceInfo;

    goto :goto_3

    .line 3596
    :cond_1d
    new-instance v0, Landroid/content/pm/ServiceInfo;

    iget-object v1, p0, Landroid/content/pm/PackageParser$Service;->info:Landroid/content/pm/ServiceInfo;

    invoke-direct {v0, v1}, Landroid/content/pm/ServiceInfo;-><init>(Landroid/content/pm/ServiceInfo;)V

    .line 3597
    .local v0, si:Landroid/content/pm/ServiceInfo;
    iget-object v1, p0, Landroid/content/pm/PackageParser$Component;->metaData:Landroid/os/Bundle;

    iput-object v1, v0, Landroid/content/pm/PackageItemInfo;->metaData:Landroid/os/Bundle;

    .line 3598
    iget-object v1, p0, Landroid/content/pm/PackageParser$Component;->owner:Landroid/content/pm/PackageParser$Package;

    invoke-static {v1, p1, p2, p3, p4}, Landroid/content/pm/PackageParser;->generateApplicationInfo(Landroid/content/pm/PackageParser$Package;IZII)Landroid/content/pm/ApplicationInfo;

    move-result-object v1

    iput-object v1, v0, Landroid/content/pm/ComponentInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    goto :goto_3
.end method

.method private static final isPackageFilename(Ljava/lang/String;)Z
    .registers 2
    .parameter "name"

    .prologue
    .line 247
    const-string v0, ".apk"

    invoke-virtual {p0, v0}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method private loadCertificates(Ljava/util/jar/JarFile;Ljava/util/jar/JarEntry;[B)[Ljava/security/cert/Certificate;
    .registers 10
    .parameter "jarFile"
    .parameter "je"
    .parameter "readBuffer"

    .prologue
    const/4 v2, 0x0

    .line 439
    :try_start_1
    new-instance v1, Ljava/io/BufferedInputStream;

    invoke-virtual {p1, p2}, Ljava/util/jar/JarFile;->getInputStream(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;

    move-result-object v3

    invoke-direct {v1, v3}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V

    .line 440
    .local v1, is:Ljava/io/InputStream;
    :cond_a
    const/4 v3, 0x0

    array-length v4, p3

    invoke-virtual {v1, p3, v3, v4}, Ljava/io/BufferedInputStream;->read([BII)I

    move-result v3

    const/4 v4, -0x1

    if-ne v3, v4, :cond_a

    .line 443
    invoke-virtual {v1}, Ljava/io/BufferedInputStream;->close()V

    .line 444
    if-eqz p2, :cond_1c

    invoke-virtual {p2}, Ljava/util/jar/JarEntry;->getCertificates()[Ljava/security/cert/Certificate;
    :try_end_1b
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1b} :catch_1d
    .catch Ljava/lang/RuntimeException; {:try_start_1 .. :try_end_1b} :catch_49

    move-result-object v2

    .line 452
    .end local v1           #is:Ljava/io/InputStream;
    :cond_1c
    :goto_1c
    return-object v2

    .line 445
    :catch_1d
    move-exception v0

    .line 446
    .local v0, e:Ljava/io/IOException;
    const-string v3, "PackageParser"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Exception reading "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {p2}, Ljava/util/jar/JarEntry;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " in "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {p1}, Ljava/util/jar/JarFile;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4, v0}, Landroid/util/Slog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_1c

    .line 448
    .end local v0           #e:Ljava/io/IOException;
    :catch_49
    move-exception v0

    .line 449
    .local v0, e:Ljava/lang/RuntimeException;
    const-string v3, "PackageParser"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Exception reading "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {p2}, Ljava/util/jar/JarEntry;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " in "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {p1}, Ljava/util/jar/JarFile;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4, v0}, Landroid/util/Slog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_1c
.end method

.method private parseActivity(Landroid/content/pm/PackageParser$Package;Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;I[Ljava/lang/String;ZZ)Landroid/content/pm/PackageParser$Activity;
    .registers 31
    .parameter "owner"
    .parameter "res"
    .parameter "parser"
    .parameter "attrs"
    .parameter "flags"
    .parameter "outError"
    .parameter "receiver"
    .parameter "hardwareAccelerated"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 2029
    sget-object v2, Lcom/android/internal/R$styleable;->AndroidManifestActivity:[I

    move-object/from16 v0, p2

    move-object/from16 v1, p4

    invoke-virtual {v0, v1, v2}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v18

    .line 2032
    .local v18, sa:Landroid/content/res/TypedArray;
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/content/pm/PackageParser;->mParseActivityArgs:Landroid/content/pm/PackageParser$ParseComponentArgs;

    if-nez v2, :cond_2a

    .line 2033
    new-instance v2, Landroid/content/pm/PackageParser$ParseComponentArgs;

    const/4 v5, 0x3

    const/4 v6, 0x1

    const/4 v7, 0x2

    const/16 v8, 0x17

    move-object/from16 v0, p0

    iget-object v9, v0, Landroid/content/pm/PackageParser;->mSeparateProcesses:[Ljava/lang/String;

    const/4 v10, 0x7

    const/16 v11, 0x11

    const/4 v12, 0x5

    move-object/from16 v3, p1

    move-object/from16 v4, p6

    invoke-direct/range {v2 .. v12}, Landroid/content/pm/PackageParser$ParseComponentArgs;-><init>(Landroid/content/pm/PackageParser$Package;[Ljava/lang/String;IIII[Ljava/lang/String;III)V

    move-object/from16 v0, p0

    iput-object v2, v0, Landroid/content/pm/PackageParser;->mParseActivityArgs:Landroid/content/pm/PackageParser$ParseComponentArgs;

    .line 2044
    :cond_2a
    move-object/from16 v0, p0

    iget-object v3, v0, Landroid/content/pm/PackageParser;->mParseActivityArgs:Landroid/content/pm/PackageParser$ParseComponentArgs;

    if-eqz p7, :cond_5c

    const-string v2, "<receiver>"

    :goto_32
    iput-object v2, v3, Landroid/content/pm/PackageParser$ParsePackageItemArgs;->tag:Ljava/lang/String;

    .line 2045
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/content/pm/PackageParser;->mParseActivityArgs:Landroid/content/pm/PackageParser$ParseComponentArgs;

    move-object/from16 v0, v18

    iput-object v0, v2, Landroid/content/pm/PackageParser$ParsePackageItemArgs;->sa:Landroid/content/res/TypedArray;

    .line 2046
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/content/pm/PackageParser;->mParseActivityArgs:Landroid/content/pm/PackageParser$ParseComponentArgs;

    move/from16 v0, p5

    iput v0, v2, Landroid/content/pm/PackageParser$ParseComponentArgs;->flags:I

    .line 2048
    new-instance v14, Landroid/content/pm/PackageParser$Activity;

    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/content/pm/PackageParser;->mParseActivityArgs:Landroid/content/pm/PackageParser$ParseComponentArgs;

    new-instance v3, Landroid/content/pm/ActivityInfo;

    invoke-direct {v3}, Landroid/content/pm/ActivityInfo;-><init>()V

    invoke-direct {v14, v2, v3}, Landroid/content/pm/PackageParser$Activity;-><init>(Landroid/content/pm/PackageParser$ParseComponentArgs;Landroid/content/pm/ActivityInfo;)V

    .line 2049
    .local v14, a:Landroid/content/pm/PackageParser$Activity;
    const/4 v2, 0x0

    aget-object v2, p6, v2

    if-eqz v2, :cond_5f

    .line 2050
    invoke-virtual/range {v18 .. v18}, Landroid/content/res/TypedArray;->recycle()V

    .line 2051
    const/4 v14, 0x0

    .line 2249
    .end local v14           #a:Landroid/content/pm/PackageParser$Activity;
    :cond_5b
    :goto_5b
    return-object v14

    .line 2044
    :cond_5c
    const-string v2, "<activity>"

    goto :goto_32

    .line 2054
    .restart local v14       #a:Landroid/content/pm/PackageParser$Activity;
    :cond_5f
    const/4 v2, 0x6

    move-object/from16 v0, v18

    invoke-virtual {v0, v2}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v19

    .line 2056
    .local v19, setExported:Z
    if-eqz v19, :cond_74

    .line 2057
    iget-object v2, v14, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    const/4 v3, 0x6

    const/4 v4, 0x0

    move-object/from16 v0, v18

    invoke-virtual {v0, v3, v4}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v3

    iput-boolean v3, v2, Landroid/content/pm/ComponentInfo;->exported:Z

    .line 2061
    :cond_74
    iget-object v2, v14, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    const/4 v3, 0x0

    const/4 v4, 0x0

    move-object/from16 v0, v18

    invoke-virtual {v0, v3, v4}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v3

    iput v3, v2, Landroid/content/pm/ActivityInfo;->theme:I

    .line 2064
    iget-object v2, v14, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    const/16 v3, 0x1a

    iget-object v4, v14, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    iget-object v4, v4, Landroid/content/pm/ComponentInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget v4, v4, Landroid/content/pm/ApplicationInfo;->uiOptions:I

    move-object/from16 v0, v18

    invoke-virtual {v0, v3, v4}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v3

    iput v3, v2, Landroid/content/pm/ActivityInfo;->uiOptions:I

    .line 2068
    const/16 v2, 0x1b

    const/4 v3, 0x0

    move-object/from16 v0, v18

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getNonConfigurationString(II)Ljava/lang/String;

    move-result-object v17

    .line 2070
    .local v17, parentName:Ljava/lang/String;
    if-eqz v17, :cond_b4

    .line 2071
    iget-object v2, v14, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    iget-object v2, v2, Landroid/content/pm/PackageItemInfo;->packageName:Ljava/lang/String;

    move-object/from16 v0, v17

    move-object/from16 v1, p6

    invoke-static {v2, v0, v1}, Landroid/content/pm/PackageParser;->buildClassName(Ljava/lang/String;Ljava/lang/CharSequence;[Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    .line 2072
    .local v16, parentClassName:Ljava/lang/String;
    const/4 v2, 0x0

    aget-object v2, p6, v2

    if-nez v2, :cond_227

    .line 2073
    iget-object v2, v14, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    move-object/from16 v0, v16

    iput-object v0, v2, Landroid/content/pm/ActivityInfo;->parentActivityName:Ljava/lang/String;

    .line 2082
    .end local v16           #parentClassName:Ljava/lang/String;
    :cond_b4
    :goto_b4
    const/4 v2, 0x4

    const/4 v3, 0x0

    move-object/from16 v0, v18

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getNonConfigurationString(II)Ljava/lang/String;

    move-result-object v20

    .line 2084
    .local v20, str:Ljava/lang/String;
    if-nez v20, :cond_255

    .line 2085
    iget-object v2, v14, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    move-object/from16 v0, p1

    iget-object v3, v0, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget-object v3, v3, Landroid/content/pm/ApplicationInfo;->permission:Ljava/lang/String;

    iput-object v3, v2, Landroid/content/pm/ActivityInfo;->permission:Ljava/lang/String;

    .line 2090
    :goto_c8
    const/16 v2, 0x8

    const/4 v3, 0x0

    move-object/from16 v0, v18

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getNonConfigurationString(II)Ljava/lang/String;

    move-result-object v20

    .line 2092
    iget-object v2, v14, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    move-object/from16 v0, p1

    iget-object v3, v0, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget-object v3, v3, Landroid/content/pm/PackageItemInfo;->packageName:Ljava/lang/String;

    move-object/from16 v0, p1

    iget-object v4, v0, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget-object v4, v4, Landroid/content/pm/ApplicationInfo;->taskAffinity:Ljava/lang/String;

    move-object/from16 v0, v20

    move-object/from16 v1, p6

    invoke-static {v3, v4, v0, v1}, Landroid/content/pm/PackageParser;->buildTaskAffinityName(Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;[Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, v2, Landroid/content/pm/ActivityInfo;->taskAffinity:Ljava/lang/String;

    .line 2095
    iget-object v2, v14, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    const/4 v3, 0x0

    iput v3, v2, Landroid/content/pm/ActivityInfo;->flags:I

    .line 2096
    const/16 v2, 0x9

    const/4 v3, 0x0

    move-object/from16 v0, v18

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v2

    if-eqz v2, :cond_101

    .line 2099
    iget-object v2, v14, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    iget v3, v2, Landroid/content/pm/ActivityInfo;->flags:I

    or-int/lit8 v3, v3, 0x1

    iput v3, v2, Landroid/content/pm/ActivityInfo;->flags:I

    .line 2102
    :cond_101
    const/16 v2, 0xa

    const/4 v3, 0x0

    move-object/from16 v0, v18

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v2

    if-eqz v2, :cond_114

    .line 2105
    iget-object v2, v14, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    iget v3, v2, Landroid/content/pm/ActivityInfo;->flags:I

    or-int/lit8 v3, v3, 0x2

    iput v3, v2, Landroid/content/pm/ActivityInfo;->flags:I

    .line 2108
    :cond_114
    const/16 v2, 0xb

    const/4 v3, 0x0

    move-object/from16 v0, v18

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v2

    if-eqz v2, :cond_127

    .line 2111
    iget-object v2, v14, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    iget v3, v2, Landroid/content/pm/ActivityInfo;->flags:I

    or-int/lit8 v3, v3, 0x4

    iput v3, v2, Landroid/content/pm/ActivityInfo;->flags:I

    .line 2114
    :cond_127
    const/16 v2, 0x15

    const/4 v3, 0x0

    move-object/from16 v0, v18

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v2

    if-eqz v2, :cond_13a

    .line 2117
    iget-object v2, v14, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    iget v3, v2, Landroid/content/pm/ActivityInfo;->flags:I

    or-int/lit16 v3, v3, 0x80

    iput v3, v2, Landroid/content/pm/ActivityInfo;->flags:I

    .line 2120
    :cond_13a
    const/16 v2, 0x12

    const/4 v3, 0x0

    move-object/from16 v0, v18

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v2

    if-eqz v2, :cond_14d

    .line 2123
    iget-object v2, v14, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    iget v3, v2, Landroid/content/pm/ActivityInfo;->flags:I

    or-int/lit8 v3, v3, 0x8

    iput v3, v2, Landroid/content/pm/ActivityInfo;->flags:I

    .line 2126
    :cond_14d
    const/16 v2, 0xc

    const/4 v3, 0x0

    move-object/from16 v0, v18

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v2

    if-eqz v2, :cond_160

    .line 2129
    iget-object v2, v14, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    iget v3, v2, Landroid/content/pm/ActivityInfo;->flags:I

    or-int/lit8 v3, v3, 0x10

    iput v3, v2, Landroid/content/pm/ActivityInfo;->flags:I

    .line 2132
    :cond_160
    const/16 v2, 0xd

    const/4 v3, 0x0

    move-object/from16 v0, v18

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v2

    if-eqz v2, :cond_173

    .line 2135
    iget-object v2, v14, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    iget v3, v2, Landroid/content/pm/ActivityInfo;->flags:I

    or-int/lit8 v3, v3, 0x20

    iput v3, v2, Landroid/content/pm/ActivityInfo;->flags:I

    .line 2138
    :cond_173
    const/16 v3, 0x13

    move-object/from16 v0, p1

    iget-object v2, v0, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget v2, v2, Landroid/content/pm/ApplicationInfo;->flags:I

    and-int/lit8 v2, v2, 0x20

    if-eqz v2, :cond_26b

    const/4 v2, 0x1

    :goto_180
    move-object/from16 v0, v18

    invoke-virtual {v0, v3, v2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v2

    if-eqz v2, :cond_190

    .line 2141
    iget-object v2, v14, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    iget v3, v2, Landroid/content/pm/ActivityInfo;->flags:I

    or-int/lit8 v3, v3, 0x40

    iput v3, v2, Landroid/content/pm/ActivityInfo;->flags:I

    .line 2144
    :cond_190
    const/16 v2, 0x16

    const/4 v3, 0x0

    move-object/from16 v0, v18

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v2

    if-eqz v2, :cond_1a3

    .line 2147
    iget-object v2, v14, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    iget v3, v2, Landroid/content/pm/ActivityInfo;->flags:I

    or-int/lit16 v3, v3, 0x100

    iput v3, v2, Landroid/content/pm/ActivityInfo;->flags:I

    .line 2150
    :cond_1a3
    const/16 v2, 0x18

    const/4 v3, 0x0

    move-object/from16 v0, v18

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v2

    if-eqz v2, :cond_1b6

    .line 2153
    iget-object v2, v14, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    iget v3, v2, Landroid/content/pm/ActivityInfo;->flags:I

    or-int/lit16 v3, v3, 0x400

    iput v3, v2, Landroid/content/pm/ActivityInfo;->flags:I

    .line 2156
    :cond_1b6
    if-nez p7, :cond_26e

    .line 2157
    const/16 v2, 0x19

    move-object/from16 v0, v18

    move/from16 v1, p8

    invoke-virtual {v0, v2, v1}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v2

    if-eqz v2, :cond_1cc

    .line 2160
    iget-object v2, v14, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    iget v3, v2, Landroid/content/pm/ActivityInfo;->flags:I

    or-int/lit16 v3, v3, 0x200

    iput v3, v2, Landroid/content/pm/ActivityInfo;->flags:I

    .line 2163
    :cond_1cc
    iget-object v2, v14, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    const/16 v3, 0xe

    const/4 v4, 0x0

    move-object/from16 v0, v18

    invoke-virtual {v0, v3, v4}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v3

    iput v3, v2, Landroid/content/pm/ActivityInfo;->launchMode:I

    .line 2166
    iget-object v2, v14, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    const/16 v3, 0xf

    const/4 v4, -0x1

    move-object/from16 v0, v18

    invoke-virtual {v0, v3, v4}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v3

    iput v3, v2, Landroid/content/pm/ActivityInfo;->screenOrientation:I

    .line 2169
    iget-object v2, v14, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    const/16 v3, 0x10

    const/4 v4, 0x0

    move-object/from16 v0, v18

    invoke-virtual {v0, v3, v4}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v3

    iput v3, v2, Landroid/content/pm/ActivityInfo;->configChanges:I

    .line 2172
    iget-object v2, v14, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    const/16 v3, 0x14

    const/4 v4, 0x0

    move-object/from16 v0, v18

    invoke-virtual {v0, v3, v4}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v3

    iput v3, v2, Landroid/content/pm/ActivityInfo;->softInputMode:I

    .line 2180
    :goto_200
    invoke-virtual/range {v18 .. v18}, Landroid/content/res/TypedArray;->recycle()V

    .line 2182
    if-eqz p7, :cond_21f

    move-object/from16 v0, p1

    iget-object v2, v0, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget v2, v2, Landroid/content/pm/ApplicationInfo;->flags:I

    const/high16 v3, 0x1000

    and-int/2addr v2, v3

    if-eqz v2, :cond_21f

    .line 2185
    iget-object v2, v14, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    iget-object v2, v2, Landroid/content/pm/ComponentInfo;->processName:Ljava/lang/String;

    move-object/from16 v0, p1

    iget-object v3, v0, Landroid/content/pm/PackageParser$Package;->packageName:Ljava/lang/String;

    if-ne v2, v3, :cond_21f

    .line 2186
    const/4 v2, 0x0

    const-string v3, "Heavy-weight applications can not have receivers in main process"

    aput-object v3, p6, v2

    .line 2190
    :cond_21f
    const/4 v2, 0x0

    aget-object v2, p6, v2

    if-eqz v2, :cond_279

    .line 2191
    const/4 v14, 0x0

    goto/16 :goto_5b

    .line 2075
    .end local v20           #str:Ljava/lang/String;
    .restart local v16       #parentClassName:Ljava/lang/String;
    :cond_227
    const-string v2, "PackageParser"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Activity "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, v14, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    iget-object v4, v4, Landroid/content/pm/PackageItemInfo;->name:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " specified invalid parentActivityName "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, v17

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 2077
    const/4 v2, 0x0

    const/4 v3, 0x0

    aput-object v3, p6, v2

    goto/16 :goto_b4

    .line 2087
    .end local v16           #parentClassName:Ljava/lang/String;
    .restart local v20       #str:Ljava/lang/String;
    :cond_255
    iget-object v3, v14, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    invoke-virtual/range {v20 .. v20}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_269

    invoke-virtual/range {v20 .. v20}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v2

    :goto_265
    iput-object v2, v3, Landroid/content/pm/ActivityInfo;->permission:Ljava/lang/String;

    goto/16 :goto_c8

    :cond_269
    const/4 v2, 0x0

    goto :goto_265

    .line 2138
    :cond_26b
    const/4 v2, 0x0

    goto/16 :goto_180

    .line 2176
    :cond_26e
    iget-object v2, v14, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    const/4 v3, 0x0

    iput v3, v2, Landroid/content/pm/ActivityInfo;->launchMode:I

    .line 2177
    iget-object v2, v14, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    const/4 v3, 0x0

    iput v3, v2, Landroid/content/pm/ActivityInfo;->configChanges:I

    goto :goto_200

    .line 2194
    :cond_279
    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v15

    .line 2197
    .local v15, outerDepth:I
    :cond_27d
    :goto_27d
    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v21

    .local v21, type:I
    const/4 v2, 0x1

    move/from16 v0, v21

    if-eq v0, v2, :cond_3bb

    const/4 v2, 0x3

    move/from16 v0, v21

    if-ne v0, v2, :cond_291

    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v2

    if-le v2, v15, :cond_3bb

    .line 2199
    :cond_291
    const/4 v2, 0x3

    move/from16 v0, v21

    if-eq v0, v2, :cond_27d

    const/4 v2, 0x4

    move/from16 v0, v21

    if-eq v0, v2, :cond_27d

    .line 2203
    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v2

    const-string v3, "intent-filter"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2fd

    .line 2204
    new-instance v7, Landroid/content/pm/PackageParser$ActivityIntentInfo;

    invoke-direct {v7, v14}, Landroid/content/pm/PackageParser$ActivityIntentInfo;-><init>(Landroid/content/pm/PackageParser$Activity;)V

    .line 2205
    .local v7, intent:Landroid/content/pm/PackageParser$ActivityIntentInfo;
    if-nez p7, :cond_2c4

    const/4 v9, 0x1

    :goto_2af
    move-object/from16 v2, p0

    move-object/from16 v3, p2

    move-object/from16 v4, p3

    move-object/from16 v5, p4

    move/from16 v6, p5

    move-object/from16 v8, p6

    invoke-direct/range {v2 .. v9}, Landroid/content/pm/PackageParser;->parseIntent(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;ILandroid/content/pm/PackageParser$IntentInfo;[Ljava/lang/String;Z)Z

    move-result v2

    if-nez v2, :cond_2c6

    .line 2206
    const/4 v14, 0x0

    goto/16 :goto_5b

    .line 2205
    :cond_2c4
    const/4 v9, 0x0

    goto :goto_2af

    .line 2208
    :cond_2c6
    invoke-virtual {v7}, Landroid/content/pm/PackageParser$ActivityIntentInfo;->countActions()I

    move-result v2

    if-nez v2, :cond_2f7

    .line 2209
    const-string v2, "PackageParser"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "No actions in intent filter at "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/content/pm/PackageParser;->mArchiveSourcePath:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->getPositionDescription()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Slog;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_27d

    .line 2213
    :cond_2f7
    iget-object v2, v14, Landroid/content/pm/PackageParser$Component;->intents:Ljava/util/ArrayList;

    invoke-virtual {v2, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_27d

    .line 2215
    .end local v7           #intent:Landroid/content/pm/PackageParser$ActivityIntentInfo;
    :cond_2fd
    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "meta-data"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_321

    .line 2216
    iget-object v12, v14, Landroid/content/pm/PackageParser$Component;->metaData:Landroid/os/Bundle;

    move-object/from16 v8, p0

    move-object/from16 v9, p2

    move-object/from16 v10, p3

    move-object/from16 v11, p4

    move-object/from16 v13, p6

    invoke-direct/range {v8 .. v13}, Landroid/content/pm/PackageParser;->parseMetaData(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/os/Bundle;[Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v2

    iput-object v2, v14, Landroid/content/pm/PackageParser$Component;->metaData:Landroid/os/Bundle;

    if-nez v2, :cond_27d

    .line 2218
    const/4 v14, 0x0

    goto/16 :goto_5b

    .line 2222
    :cond_321
    const-string v2, "PackageParser"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Problem in package "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/content/pm/PackageParser;->mArchiveSourcePath:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ":"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Slog;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 2223
    if-eqz p7, :cond_382

    .line 2224
    const-string v2, "PackageParser"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unknown element under <receiver>: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " at "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/content/pm/PackageParser;->mArchiveSourcePath:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->getPositionDescription()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Slog;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 2232
    :goto_37d
    invoke-static/range {p3 .. p3}, Lcom/android/internal/util/XmlUtils;->skipCurrentTag(Lorg/xmlpull/v1/XmlPullParser;)V

    goto/16 :goto_27d

    .line 2228
    :cond_382
    const-string v2, "PackageParser"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unknown element under <activity>: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " at "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/content/pm/PackageParser;->mArchiveSourcePath:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->getPositionDescription()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Slog;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_37d

    .line 2245
    :cond_3bb
    if-nez v19, :cond_5b

    .line 2246
    iget-object v3, v14, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    iget-object v2, v14, Landroid/content/pm/PackageParser$Component;->intents:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-lez v2, :cond_3cc

    const/4 v2, 0x1

    :goto_3c8
    iput-boolean v2, v3, Landroid/content/pm/ComponentInfo;->exported:Z

    goto/16 :goto_5b

    :cond_3cc
    const/4 v2, 0x0

    goto :goto_3c8
.end method

.method private parseActivityAlias(Landroid/content/pm/PackageParser$Package;Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;I[Ljava/lang/String;)Landroid/content/pm/PackageParser$Activity;
    .registers 35
    .parameter "owner"
    .parameter "res"
    .parameter "parser"
    .parameter "attrs"
    .parameter "flags"
    .parameter "outError"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 2255
    sget-object v2, Lcom/android/internal/R$styleable;->AndroidManifestActivityAlias:[I

    move-object/from16 v0, p2

    move-object/from16 v1, p4

    invoke-virtual {v0, v1, v2}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v21

    .line 2258
    .local v21, sa:Landroid/content/res/TypedArray;
    const/4 v2, 0x7

    const/4 v3, 0x0

    move-object/from16 v0, v21

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getNonConfigurationString(II)Ljava/lang/String;

    move-result-object v26

    .line 2260
    .local v26, targetActivity:Ljava/lang/String;
    if-nez v26, :cond_1e

    .line 2261
    const/4 v2, 0x0

    const-string v3, "<activity-alias> does not specify android:targetActivity"

    aput-object v3, p6, v2

    .line 2262
    invoke-virtual/range {v21 .. v21}, Landroid/content/res/TypedArray;->recycle()V

    .line 2263
    const/4 v15, 0x0

    .line 2411
    :cond_1d
    :goto_1d
    return-object v15

    .line 2266
    :cond_1e
    move-object/from16 v0, p1

    iget-object v2, v0, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget-object v2, v2, Landroid/content/pm/PackageItemInfo;->packageName:Ljava/lang/String;

    move-object/from16 v0, v26

    move-object/from16 v1, p6

    invoke-static {v2, v0, v1}, Landroid/content/pm/PackageParser;->buildClassName(Ljava/lang/String;Ljava/lang/CharSequence;[Ljava/lang/String;)Ljava/lang/String;

    move-result-object v26

    .line 2268
    if-nez v26, :cond_33

    .line 2269
    invoke-virtual/range {v21 .. v21}, Landroid/content/res/TypedArray;->recycle()V

    .line 2270
    const/4 v15, 0x0

    goto :goto_1d

    .line 2273
    :cond_33
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/content/pm/PackageParser;->mParseActivityAliasArgs:Landroid/content/pm/PackageParser$ParseComponentArgs;

    if-nez v2, :cond_5a

    .line 2274
    new-instance v2, Landroid/content/pm/PackageParser$ParseComponentArgs;

    const/4 v5, 0x2

    const/4 v6, 0x0

    const/4 v7, 0x1

    const/16 v8, 0x8

    move-object/from16 v0, p0

    iget-object v9, v0, Landroid/content/pm/PackageParser;->mSeparateProcesses:[Ljava/lang/String;

    const/4 v10, 0x0

    const/4 v11, 0x6

    const/4 v12, 0x4

    move-object/from16 v3, p1

    move-object/from16 v4, p6

    invoke-direct/range {v2 .. v12}, Landroid/content/pm/PackageParser$ParseComponentArgs;-><init>(Landroid/content/pm/PackageParser$Package;[Ljava/lang/String;IIII[Ljava/lang/String;III)V

    move-object/from16 v0, p0

    iput-object v2, v0, Landroid/content/pm/PackageParser;->mParseActivityAliasArgs:Landroid/content/pm/PackageParser$ParseComponentArgs;

    .line 2283
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/content/pm/PackageParser;->mParseActivityAliasArgs:Landroid/content/pm/PackageParser$ParseComponentArgs;

    const-string v3, "<activity-alias>"

    iput-object v3, v2, Landroid/content/pm/PackageParser$ParsePackageItemArgs;->tag:Ljava/lang/String;

    .line 2286
    :cond_5a
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/content/pm/PackageParser;->mParseActivityAliasArgs:Landroid/content/pm/PackageParser$ParseComponentArgs;

    move-object/from16 v0, v21

    iput-object v0, v2, Landroid/content/pm/PackageParser$ParsePackageItemArgs;->sa:Landroid/content/res/TypedArray;

    .line 2287
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/content/pm/PackageParser;->mParseActivityAliasArgs:Landroid/content/pm/PackageParser$ParseComponentArgs;

    move/from16 v0, p5

    iput v0, v2, Landroid/content/pm/PackageParser$ParseComponentArgs;->flags:I

    .line 2289
    const/16 v25, 0x0

    .line 2291
    .local v25, target:Landroid/content/pm/PackageParser$Activity;
    move-object/from16 v0, p1

    iget-object v2, v0, Landroid/content/pm/PackageParser$Package;->activities:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v14

    .line 2292
    .local v14, NA:I
    const/16 v16, 0x0

    .local v16, i:I
    :goto_76
    move/from16 v0, v16

    if-ge v0, v14, :cond_96

    .line 2293
    move-object/from16 v0, p1

    iget-object v2, v0, Landroid/content/pm/PackageParser$Package;->activities:Ljava/util/ArrayList;

    move/from16 v0, v16

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v24

    check-cast v24, Landroid/content/pm/PackageParser$Activity;

    .line 2294
    .local v24, t:Landroid/content/pm/PackageParser$Activity;
    move-object/from16 v0, v24

    iget-object v2, v0, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    iget-object v2, v2, Landroid/content/pm/PackageItemInfo;->name:Ljava/lang/String;

    move-object/from16 v0, v26

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_bc

    .line 2295
    move-object/from16 v25, v24

    .line 2300
    .end local v24           #t:Landroid/content/pm/PackageParser$Activity;
    :cond_96
    if-nez v25, :cond_bf

    .line 2301
    const/4 v2, 0x0

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "<activity-alias> target activity "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, v26

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " not found in manifest"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, p6, v2

    .line 2303
    invoke-virtual/range {v21 .. v21}, Landroid/content/res/TypedArray;->recycle()V

    .line 2304
    const/4 v15, 0x0

    goto/16 :goto_1d

    .line 2292
    .restart local v24       #t:Landroid/content/pm/PackageParser$Activity;
    :cond_bc
    add-int/lit8 v16, v16, 0x1

    goto :goto_76

    .line 2307
    .end local v24           #t:Landroid/content/pm/PackageParser$Activity;
    :cond_bf
    new-instance v17, Landroid/content/pm/ActivityInfo;

    invoke-direct/range {v17 .. v17}, Landroid/content/pm/ActivityInfo;-><init>()V

    .line 2308
    .local v17, info:Landroid/content/pm/ActivityInfo;
    move-object/from16 v0, v26

    move-object/from16 v1, v17

    iput-object v0, v1, Landroid/content/pm/ActivityInfo;->targetActivity:Ljava/lang/String;

    .line 2309
    move-object/from16 v0, v25

    iget-object v2, v0, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    iget v2, v2, Landroid/content/pm/ActivityInfo;->configChanges:I

    move-object/from16 v0, v17

    iput v2, v0, Landroid/content/pm/ActivityInfo;->configChanges:I

    .line 2310
    move-object/from16 v0, v25

    iget-object v2, v0, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    iget v2, v2, Landroid/content/pm/ActivityInfo;->flags:I

    move-object/from16 v0, v17

    iput v2, v0, Landroid/content/pm/ActivityInfo;->flags:I

    .line 2311
    move-object/from16 v0, v25

    iget-object v2, v0, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    iget v2, v2, Landroid/content/pm/PackageItemInfo;->icon:I

    move-object/from16 v0, v17

    iput v2, v0, Landroid/content/pm/PackageItemInfo;->icon:I

    .line 2312
    move-object/from16 v0, v25

    iget-object v2, v0, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    iget v2, v2, Landroid/content/pm/PackageItemInfo;->logo:I

    move-object/from16 v0, v17

    iput v2, v0, Landroid/content/pm/PackageItemInfo;->logo:I

    .line 2313
    move-object/from16 v0, v25

    iget-object v2, v0, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    iget v2, v2, Landroid/content/pm/PackageItemInfo;->labelRes:I

    move-object/from16 v0, v17

    iput v2, v0, Landroid/content/pm/PackageItemInfo;->labelRes:I

    .line 2314
    move-object/from16 v0, v25

    iget-object v2, v0, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    iget-object v2, v2, Landroid/content/pm/PackageItemInfo;->nonLocalizedLabel:Ljava/lang/CharSequence;

    move-object/from16 v0, v17

    iput-object v2, v0, Landroid/content/pm/PackageItemInfo;->nonLocalizedLabel:Ljava/lang/CharSequence;

    .line 2315
    move-object/from16 v0, v25

    iget-object v2, v0, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    iget v2, v2, Landroid/content/pm/ActivityInfo;->launchMode:I

    move-object/from16 v0, v17

    iput v2, v0, Landroid/content/pm/ActivityInfo;->launchMode:I

    .line 2316
    move-object/from16 v0, v25

    iget-object v2, v0, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    iget-object v2, v2, Landroid/content/pm/ComponentInfo;->processName:Ljava/lang/String;

    move-object/from16 v0, v17

    iput-object v2, v0, Landroid/content/pm/ComponentInfo;->processName:Ljava/lang/String;

    .line 2317
    move-object/from16 v0, v17

    iget v2, v0, Landroid/content/pm/ComponentInfo;->descriptionRes:I

    if-nez v2, :cond_12a

    .line 2318
    move-object/from16 v0, v25

    iget-object v2, v0, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    iget v2, v2, Landroid/content/pm/ComponentInfo;->descriptionRes:I

    move-object/from16 v0, v17

    iput v2, v0, Landroid/content/pm/ComponentInfo;->descriptionRes:I

    .line 2320
    :cond_12a
    move-object/from16 v0, v25

    iget-object v2, v0, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    iget v2, v2, Landroid/content/pm/ActivityInfo;->screenOrientation:I

    move-object/from16 v0, v17

    iput v2, v0, Landroid/content/pm/ActivityInfo;->screenOrientation:I

    .line 2321
    move-object/from16 v0, v25

    iget-object v2, v0, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    iget-object v2, v2, Landroid/content/pm/ActivityInfo;->taskAffinity:Ljava/lang/String;

    move-object/from16 v0, v17

    iput-object v2, v0, Landroid/content/pm/ActivityInfo;->taskAffinity:Ljava/lang/String;

    .line 2322
    move-object/from16 v0, v25

    iget-object v2, v0, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    iget v2, v2, Landroid/content/pm/ActivityInfo;->theme:I

    move-object/from16 v0, v17

    iput v2, v0, Landroid/content/pm/ActivityInfo;->theme:I

    .line 2323
    move-object/from16 v0, v25

    iget-object v2, v0, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    iget v2, v2, Landroid/content/pm/ActivityInfo;->softInputMode:I

    move-object/from16 v0, v17

    iput v2, v0, Landroid/content/pm/ActivityInfo;->softInputMode:I

    .line 2324
    move-object/from16 v0, v25

    iget-object v2, v0, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    iget v2, v2, Landroid/content/pm/ActivityInfo;->uiOptions:I

    move-object/from16 v0, v17

    iput v2, v0, Landroid/content/pm/ActivityInfo;->uiOptions:I

    .line 2325
    move-object/from16 v0, v25

    iget-object v2, v0, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    iget-object v2, v2, Landroid/content/pm/ActivityInfo;->parentActivityName:Ljava/lang/String;

    move-object/from16 v0, v17

    iput-object v2, v0, Landroid/content/pm/ActivityInfo;->parentActivityName:Ljava/lang/String;

    .line 2327
    new-instance v15, Landroid/content/pm/PackageParser$Activity;

    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/content/pm/PackageParser;->mParseActivityAliasArgs:Landroid/content/pm/PackageParser$ParseComponentArgs;

    move-object/from16 v0, v17

    invoke-direct {v15, v2, v0}, Landroid/content/pm/PackageParser$Activity;-><init>(Landroid/content/pm/PackageParser$ParseComponentArgs;Landroid/content/pm/ActivityInfo;)V

    .line 2328
    .local v15, a:Landroid/content/pm/PackageParser$Activity;
    const/4 v2, 0x0

    aget-object v2, p6, v2

    if-eqz v2, :cond_17c

    .line 2329
    invoke-virtual/range {v21 .. v21}, Landroid/content/res/TypedArray;->recycle()V

    .line 2330
    const/4 v15, 0x0

    goto/16 :goto_1d

    .line 2333
    :cond_17c
    const/4 v2, 0x5

    move-object/from16 v0, v21

    invoke-virtual {v0, v2}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v22

    .line 2335
    .local v22, setExported:Z
    if-eqz v22, :cond_191

    .line 2336
    iget-object v2, v15, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    const/4 v3, 0x5

    const/4 v4, 0x0

    move-object/from16 v0, v21

    invoke-virtual {v0, v3, v4}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v3

    iput-boolean v3, v2, Landroid/content/pm/ComponentInfo;->exported:Z

    .line 2341
    :cond_191
    const/4 v2, 0x3

    const/4 v3, 0x0

    move-object/from16 v0, v21

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getNonConfigurationString(II)Ljava/lang/String;

    move-result-object v23

    .line 2343
    .local v23, str:Ljava/lang/String;
    if-eqz v23, :cond_1ad

    .line 2344
    iget-object v3, v15, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    invoke-virtual/range {v23 .. v23}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_1da

    invoke-virtual/range {v23 .. v23}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v2

    :goto_1ab
    iput-object v2, v3, Landroid/content/pm/ActivityInfo;->permission:Ljava/lang/String;

    .line 2347
    :cond_1ad
    const/16 v2, 0x9

    const/4 v3, 0x0

    move-object/from16 v0, v21

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getNonConfigurationString(II)Ljava/lang/String;

    move-result-object v20

    .line 2350
    .local v20, parentName:Ljava/lang/String;
    if-eqz v20, :cond_1cf

    .line 2351
    iget-object v2, v15, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    iget-object v2, v2, Landroid/content/pm/PackageItemInfo;->packageName:Ljava/lang/String;

    move-object/from16 v0, v20

    move-object/from16 v1, p6

    invoke-static {v2, v0, v1}, Landroid/content/pm/PackageParser;->buildClassName(Ljava/lang/String;Ljava/lang/CharSequence;[Ljava/lang/String;)Ljava/lang/String;

    move-result-object v19

    .line 2352
    .local v19, parentClassName:Ljava/lang/String;
    const/4 v2, 0x0

    aget-object v2, p6, v2

    if-nez v2, :cond_1dc

    .line 2353
    iget-object v2, v15, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    move-object/from16 v0, v19

    iput-object v0, v2, Landroid/content/pm/ActivityInfo;->parentActivityName:Ljava/lang/String;

    .line 2361
    .end local v19           #parentClassName:Ljava/lang/String;
    :cond_1cf
    :goto_1cf
    invoke-virtual/range {v21 .. v21}, Landroid/content/res/TypedArray;->recycle()V

    .line 2363
    const/4 v2, 0x0

    aget-object v2, p6, v2

    if-eqz v2, :cond_209

    .line 2364
    const/4 v15, 0x0

    goto/16 :goto_1d

    .line 2344
    .end local v20           #parentName:Ljava/lang/String;
    :cond_1da
    const/4 v2, 0x0

    goto :goto_1ab

    .line 2355
    .restart local v19       #parentClassName:Ljava/lang/String;
    .restart local v20       #parentName:Ljava/lang/String;
    :cond_1dc
    const-string v2, "PackageParser"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Activity alias "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, v15, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    iget-object v4, v4, Landroid/content/pm/PackageItemInfo;->name:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " specified invalid parentActivityName "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, v20

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 2357
    const/4 v2, 0x0

    const/4 v3, 0x0

    aput-object v3, p6, v2

    goto :goto_1cf

    .line 2367
    .end local v19           #parentClassName:Ljava/lang/String;
    :cond_209
    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v18

    .line 2370
    .local v18, outerDepth:I
    :cond_20d
    :goto_20d
    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v27

    .local v27, type:I
    const/4 v2, 0x1

    move/from16 v0, v27

    if-eq v0, v2, :cond_2ec

    const/4 v2, 0x3

    move/from16 v0, v27

    if-ne v0, v2, :cond_223

    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v2

    move/from16 v0, v18

    if-le v2, v0, :cond_2ec

    .line 2372
    :cond_223
    const/4 v2, 0x3

    move/from16 v0, v27

    if-eq v0, v2, :cond_20d

    const/4 v2, 0x4

    move/from16 v0, v27

    if-eq v0, v2, :cond_20d

    .line 2376
    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v2

    const-string v3, "intent-filter"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_28b

    .line 2377
    new-instance v7, Landroid/content/pm/PackageParser$ActivityIntentInfo;

    invoke-direct {v7, v15}, Landroid/content/pm/PackageParser$ActivityIntentInfo;-><init>(Landroid/content/pm/PackageParser$Activity;)V

    .line 2378
    .local v7, intent:Landroid/content/pm/PackageParser$ActivityIntentInfo;
    const/4 v9, 0x1

    move-object/from16 v2, p0

    move-object/from16 v3, p2

    move-object/from16 v4, p3

    move-object/from16 v5, p4

    move/from16 v6, p5

    move-object/from16 v8, p6

    invoke-direct/range {v2 .. v9}, Landroid/content/pm/PackageParser;->parseIntent(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;ILandroid/content/pm/PackageParser$IntentInfo;[Ljava/lang/String;Z)Z

    move-result v2

    if-nez v2, :cond_254

    .line 2379
    const/4 v15, 0x0

    goto/16 :goto_1d

    .line 2381
    :cond_254
    invoke-virtual {v7}, Landroid/content/pm/PackageParser$ActivityIntentInfo;->countActions()I

    move-result v2

    if-nez v2, :cond_285

    .line 2382
    const-string v2, "PackageParser"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "No actions in intent filter at "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/content/pm/PackageParser;->mArchiveSourcePath:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->getPositionDescription()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Slog;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_20d

    .line 2386
    :cond_285
    iget-object v2, v15, Landroid/content/pm/PackageParser$Component;->intents:Ljava/util/ArrayList;

    invoke-virtual {v2, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_20d

    .line 2388
    .end local v7           #intent:Landroid/content/pm/PackageParser$ActivityIntentInfo;
    :cond_28b
    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "meta-data"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2af

    .line 2389
    iget-object v12, v15, Landroid/content/pm/PackageParser$Component;->metaData:Landroid/os/Bundle;

    move-object/from16 v8, p0

    move-object/from16 v9, p2

    move-object/from16 v10, p3

    move-object/from16 v11, p4

    move-object/from16 v13, p6

    invoke-direct/range {v8 .. v13}, Landroid/content/pm/PackageParser;->parseMetaData(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/os/Bundle;[Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v2

    iput-object v2, v15, Landroid/content/pm/PackageParser$Component;->metaData:Landroid/os/Bundle;

    if-nez v2, :cond_20d

    .line 2391
    const/4 v15, 0x0

    goto/16 :goto_1d

    .line 2395
    :cond_2af
    const-string v2, "PackageParser"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unknown element under <activity-alias>: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " at "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/content/pm/PackageParser;->mArchiveSourcePath:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->getPositionDescription()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Slog;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 2398
    invoke-static/range {p3 .. p3}, Lcom/android/internal/util/XmlUtils;->skipCurrentTag(Lorg/xmlpull/v1/XmlPullParser;)V

    goto/16 :goto_20d

    .line 2407
    :cond_2ec
    if-nez v22, :cond_1d

    .line 2408
    iget-object v3, v15, Landroid/content/pm/PackageParser$Activity;->info:Landroid/content/pm/ActivityInfo;

    iget-object v2, v15, Landroid/content/pm/PackageParser$Component;->intents:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-lez v2, :cond_2fd

    const/4 v2, 0x1

    :goto_2f9
    iput-boolean v2, v3, Landroid/content/pm/ComponentInfo;->exported:Z

    goto/16 :goto_1d

    :cond_2fd
    const/4 v2, 0x0

    goto :goto_2f9
.end method

.method private parseAllMetaData(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Ljava/lang/String;Landroid/content/pm/PackageParser$Component;[Ljava/lang/String;)Z
    .registers 15
    .parameter "res"
    .parameter "parser"
    .parameter "attrs"
    .parameter "tag"
    .parameter "outInfo"
    .parameter "outError"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 2801
    invoke-interface {p2}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v6

    .line 2804
    .local v6, outerDepth:I
    :cond_4
    :goto_4
    invoke-interface {p2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v7

    .local v7, type:I
    const/4 v0, 0x1

    if-eq v7, v0, :cond_7c

    const/4 v0, 0x3

    if-ne v7, v0, :cond_14

    invoke-interface {p2}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v0

    if-le v0, v6, :cond_7c

    .line 2806
    :cond_14
    const/4 v0, 0x3

    if-eq v7, v0, :cond_4

    const/4 v0, 0x4

    if-eq v7, v0, :cond_4

    .line 2810
    invoke-interface {p2}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "meta-data"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_38

    .line 2811
    iget-object v4, p5, Landroid/content/pm/PackageParser$Component;->metaData:Landroid/os/Bundle;

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v5, p6

    invoke-direct/range {v0 .. v5}, Landroid/content/pm/PackageParser;->parseMetaData(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/os/Bundle;[Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    iput-object v0, p5, Landroid/content/pm/PackageParser$Component;->metaData:Landroid/os/Bundle;

    if-nez v0, :cond_4

    .line 2813
    const/4 v0, 0x0

    .line 2828
    :goto_37
    return v0

    .line 2817
    :cond_38
    const-string v0, "PackageParser"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unknown element under "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ": "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-interface {p2}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " at "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Landroid/content/pm/PackageParser;->mArchiveSourcePath:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-interface {p2}, Lorg/xmlpull/v1/XmlPullParser;->getPositionDescription()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Slog;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 2820
    invoke-static {p2}, Lcom/android/internal/util/XmlUtils;->skipCurrentTag(Lorg/xmlpull/v1/XmlPullParser;)V

    goto :goto_4

    .line 2828
    :cond_7c
    const/4 v0, 0x1

    goto :goto_37
.end method

.method private parseApplication(Landroid/content/pm/PackageParser$Package;Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;I[Ljava/lang/String;)Z
    .registers 48
    .parameter "owner"
    .parameter "res"
    .parameter "parser"
    .parameter "attrs"
    .parameter "flags"
    .parameter "outError"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1677
    move-object/from16 v0, p1

    iget-object v0, v0, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    move-object/from16 v25, v0

    .line 1678
    .local v25, ai:Landroid/content/pm/ApplicationInfo;
    move-object/from16 v0, p1

    iget-object v3, v0, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget-object v0, v3, Landroid/content/pm/PackageItemInfo;->packageName:Ljava/lang/String;

    move-object/from16 v33, v0

    .line 1680
    .local v33, pkgName:Ljava/lang/String;
    sget-object v3, Lcom/android/internal/R$styleable;->AndroidManifestApplication:[I

    move-object/from16 v0, p2

    move-object/from16 v1, p4

    invoke-virtual {v0, v1, v3}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v36

    .line 1683
    .local v36, sa:Landroid/content/res/TypedArray;
    const/4 v3, 0x3

    const/4 v4, 0x0

    move-object/from16 v0, v36

    invoke-virtual {v0, v3, v4}, Landroid/content/res/TypedArray;->getNonConfigurationString(II)Ljava/lang/String;

    move-result-object v31

    .line 1685
    .local v31, name:Ljava/lang/String;
    if-eqz v31, :cond_41

    .line 1686
    move-object/from16 v0, v33

    move-object/from16 v1, v31

    move-object/from16 v2, p6

    invoke-static {v0, v1, v2}, Landroid/content/pm/PackageParser;->buildClassName(Ljava/lang/String;Ljava/lang/CharSequence;[Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v25

    iput-object v3, v0, Landroid/content/pm/ApplicationInfo;->className:Ljava/lang/String;

    .line 1687
    move-object/from16 v0, v25

    iget-object v3, v0, Landroid/content/pm/ApplicationInfo;->className:Ljava/lang/String;

    if-nez v3, :cond_41

    .line 1688
    invoke-virtual/range {v36 .. v36}, Landroid/content/res/TypedArray;->recycle()V

    .line 1689
    const/16 v3, -0x6c

    move-object/from16 v0, p0

    iput v3, v0, Landroid/content/pm/PackageParser;->mParseError:I

    .line 1690
    const/4 v3, 0x0

    .line 1986
    :goto_40
    return v3

    .line 1694
    :cond_41
    const/4 v3, 0x4

    const/4 v4, 0x0

    move-object/from16 v0, v36

    invoke-virtual {v0, v3, v4}, Landroid/content/res/TypedArray;->getNonConfigurationString(II)Ljava/lang/String;

    move-result-object v30

    .line 1696
    .local v30, manageSpaceActivity:Ljava/lang/String;
    if-eqz v30, :cond_59

    .line 1697
    move-object/from16 v0, v33

    move-object/from16 v1, v30

    move-object/from16 v2, p6

    invoke-static {v0, v1, v2}, Landroid/content/pm/PackageParser;->buildClassName(Ljava/lang/String;Ljava/lang/CharSequence;[Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v25

    iput-object v3, v0, Landroid/content/pm/ApplicationInfo;->manageSpaceActivityName:Ljava/lang/String;

    .line 1701
    :cond_59
    const/16 v3, 0x11

    const/4 v4, 0x1

    move-object/from16 v0, v36

    invoke-virtual {v0, v3, v4}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v26

    .line 1703
    .local v26, allowBackup:Z
    if-eqz v26, :cond_b5

    .line 1704
    move-object/from16 v0, v25

    iget v3, v0, Landroid/content/pm/ApplicationInfo;->flags:I

    const v4, 0x8000

    or-int/2addr v3, v4

    move-object/from16 v0, v25

    iput v3, v0, Landroid/content/pm/ApplicationInfo;->flags:I

    .line 1708
    const/16 v3, 0x10

    const/4 v4, 0x0

    move-object/from16 v0, v36

    invoke-virtual {v0, v3, v4}, Landroid/content/res/TypedArray;->getNonConfigurationString(II)Ljava/lang/String;

    move-result-object v27

    .line 1710
    .local v27, backupAgent:Ljava/lang/String;
    if-eqz v27, :cond_b5

    .line 1711
    move-object/from16 v0, v33

    move-object/from16 v1, v27

    move-object/from16 v2, p6

    invoke-static {v0, v1, v2}, Landroid/content/pm/PackageParser;->buildClassName(Ljava/lang/String;Ljava/lang/CharSequence;[Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v25

    iput-object v3, v0, Landroid/content/pm/ApplicationInfo;->backupAgentName:Ljava/lang/String;

    .line 1717
    const/16 v3, 0x12

    const/4 v4, 0x1

    move-object/from16 v0, v36

    invoke-virtual {v0, v3, v4}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v3

    if-eqz v3, :cond_9f

    .line 1720
    move-object/from16 v0, v25

    iget v3, v0, Landroid/content/pm/ApplicationInfo;->flags:I

    const/high16 v4, 0x1

    or-int/2addr v3, v4

    move-object/from16 v0, v25

    iput v3, v0, Landroid/content/pm/ApplicationInfo;->flags:I

    .line 1722
    :cond_9f
    const/16 v3, 0x15

    const/4 v4, 0x0

    move-object/from16 v0, v36

    invoke-virtual {v0, v3, v4}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v3

    if-eqz v3, :cond_b5

    .line 1725
    move-object/from16 v0, v25

    iget v3, v0, Landroid/content/pm/ApplicationInfo;->flags:I

    const/high16 v4, 0x2

    or-int/2addr v3, v4

    move-object/from16 v0, v25

    iput v3, v0, Landroid/content/pm/ApplicationInfo;->flags:I

    .line 1730
    .end local v27           #backupAgent:Ljava/lang/String;
    :cond_b5
    const/4 v3, 0x1

    move-object/from16 v0, v36

    invoke-virtual {v0, v3}, Landroid/content/res/TypedArray;->peekValue(I)Landroid/util/TypedValue;

    move-result-object v40

    .line 1732
    .local v40, v:Landroid/util/TypedValue;
    if-eqz v40, :cond_d0

    move-object/from16 v0, v40

    iget v3, v0, Landroid/util/TypedValue;->resourceId:I

    move-object/from16 v0, v25

    iput v3, v0, Landroid/content/pm/PackageItemInfo;->labelRes:I

    if-nez v3, :cond_d0

    .line 1733
    invoke-virtual/range {v40 .. v40}, Landroid/util/TypedValue;->coerceToString()Ljava/lang/CharSequence;

    move-result-object v3

    move-object/from16 v0, v25

    iput-object v3, v0, Landroid/content/pm/PackageItemInfo;->nonLocalizedLabel:Ljava/lang/CharSequence;

    .line 1736
    :cond_d0
    const/4 v3, 0x2

    const/4 v4, 0x0

    move-object/from16 v0, v36

    invoke-virtual {v0, v3, v4}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v3

    move-object/from16 v0, v25

    iput v3, v0, Landroid/content/pm/PackageItemInfo;->icon:I

    .line 1738
    const/16 v3, 0x16

    const/4 v4, 0x0

    move-object/from16 v0, v36

    invoke-virtual {v0, v3, v4}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v3

    move-object/from16 v0, v25

    iput v3, v0, Landroid/content/pm/PackageItemInfo;->logo:I

    .line 1740
    const/4 v3, 0x0

    const/4 v4, 0x0

    move-object/from16 v0, v36

    invoke-virtual {v0, v3, v4}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v3

    move-object/from16 v0, v25

    iput v3, v0, Landroid/content/pm/ApplicationInfo;->theme:I

    .line 1742
    const/16 v3, 0xd

    const/4 v4, 0x0

    move-object/from16 v0, v36

    invoke-virtual {v0, v3, v4}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v3

    move-object/from16 v0, v25

    iput v3, v0, Landroid/content/pm/ApplicationInfo;->descriptionRes:I

    .line 1745
    and-int/lit8 v3, p5, 0x1

    if-eqz v3, :cond_11b

    .line 1746
    const/16 v3, 0x8

    const/4 v4, 0x0

    move-object/from16 v0, v36

    invoke-virtual {v0, v3, v4}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v3

    if-eqz v3, :cond_11b

    .line 1749
    move-object/from16 v0, v25

    iget v3, v0, Landroid/content/pm/ApplicationInfo;->flags:I

    or-int/lit8 v3, v3, 0x8

    move-object/from16 v0, v25

    iput v3, v0, Landroid/content/pm/ApplicationInfo;->flags:I

    .line 1753
    :cond_11b
    const/16 v3, 0xa

    const/4 v4, 0x0

    move-object/from16 v0, v36

    invoke-virtual {v0, v3, v4}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v3

    if-eqz v3, :cond_130

    .line 1756
    move-object/from16 v0, v25

    iget v3, v0, Landroid/content/pm/ApplicationInfo;->flags:I

    or-int/lit8 v3, v3, 0x2

    move-object/from16 v0, v25

    iput v3, v0, Landroid/content/pm/ApplicationInfo;->flags:I

    .line 1759
    :cond_130
    const/16 v3, 0x14

    const/4 v4, 0x0

    move-object/from16 v0, v36

    invoke-virtual {v0, v3, v4}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v3

    if-eqz v3, :cond_145

    .line 1762
    move-object/from16 v0, v25

    iget v3, v0, Landroid/content/pm/ApplicationInfo;->flags:I

    or-int/lit16 v3, v3, 0x4000

    move-object/from16 v0, v25

    iput v3, v0, Landroid/content/pm/ApplicationInfo;->flags:I

    .line 1765
    :cond_145
    const/16 v4, 0x17

    move-object/from16 v0, p1

    iget-object v3, v0, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget v3, v3, Landroid/content/pm/ApplicationInfo;->targetSdkVersion:I

    const/16 v6, 0xe

    if-lt v3, v6, :cond_26d

    const/4 v3, 0x1

    :goto_152
    move-object/from16 v0, v36

    invoke-virtual {v0, v4, v3}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v14

    .line 1769
    .local v14, hardwareAccelerated:Z
    const/4 v3, 0x7

    const/4 v4, 0x1

    move-object/from16 v0, v36

    invoke-virtual {v0, v3, v4}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v3

    if-eqz v3, :cond_16c

    .line 1772
    move-object/from16 v0, v25

    iget v3, v0, Landroid/content/pm/ApplicationInfo;->flags:I

    or-int/lit8 v3, v3, 0x4

    move-object/from16 v0, v25

    iput v3, v0, Landroid/content/pm/ApplicationInfo;->flags:I

    .line 1775
    :cond_16c
    const/16 v3, 0xe

    const/4 v4, 0x0

    move-object/from16 v0, v36

    invoke-virtual {v0, v3, v4}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v3

    if-eqz v3, :cond_181

    .line 1778
    move-object/from16 v0, v25

    iget v3, v0, Landroid/content/pm/ApplicationInfo;->flags:I

    or-int/lit8 v3, v3, 0x20

    move-object/from16 v0, v25

    iput v3, v0, Landroid/content/pm/ApplicationInfo;->flags:I

    .line 1781
    :cond_181
    const/4 v3, 0x5

    const/4 v4, 0x1

    move-object/from16 v0, v36

    invoke-virtual {v0, v3, v4}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v3

    if-eqz v3, :cond_195

    .line 1784
    move-object/from16 v0, v25

    iget v3, v0, Landroid/content/pm/ApplicationInfo;->flags:I

    or-int/lit8 v3, v3, 0x40

    move-object/from16 v0, v25

    iput v3, v0, Landroid/content/pm/ApplicationInfo;->flags:I

    .line 1787
    :cond_195
    const/16 v3, 0xf

    const/4 v4, 0x0

    move-object/from16 v0, v36

    invoke-virtual {v0, v3, v4}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v3

    if-eqz v3, :cond_1aa

    .line 1790
    move-object/from16 v0, v25

    iget v3, v0, Landroid/content/pm/ApplicationInfo;->flags:I

    or-int/lit16 v3, v3, 0x100

    move-object/from16 v0, v25

    iput v3, v0, Landroid/content/pm/ApplicationInfo;->flags:I

    .line 1793
    :cond_1aa
    const/16 v3, 0x18

    const/4 v4, 0x0

    move-object/from16 v0, v36

    invoke-virtual {v0, v3, v4}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v3

    if-eqz v3, :cond_1c0

    .line 1796
    move-object/from16 v0, v25

    iget v3, v0, Landroid/content/pm/ApplicationInfo;->flags:I

    const/high16 v4, 0x10

    or-int/2addr v3, v4

    move-object/from16 v0, v25

    iput v3, v0, Landroid/content/pm/ApplicationInfo;->flags:I

    .line 1799
    :cond_1c0
    const/16 v3, 0x1c

    const/4 v4, 0x0

    move-object/from16 v0, v36

    invoke-virtual {v0, v3, v4}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v3

    if-eqz v3, :cond_1d6

    .line 1802
    move-object/from16 v0, v25

    iget v3, v0, Landroid/content/pm/ApplicationInfo;->flags:I

    const/high16 v4, 0x40

    or-int/2addr v3, v4

    move-object/from16 v0, v25

    iput v3, v0, Landroid/content/pm/ApplicationInfo;->flags:I

    .line 1806
    :cond_1d6
    const/4 v3, 0x6

    const/4 v4, 0x0

    move-object/from16 v0, v36

    invoke-virtual {v0, v3, v4}, Landroid/content/res/TypedArray;->getNonConfigurationString(II)Ljava/lang/String;

    move-result-object v37

    .line 1808
    .local v37, str:Ljava/lang/String;
    if-eqz v37, :cond_270

    invoke-virtual/range {v37 .. v37}, Ljava/lang/String;->length()I

    move-result v3

    if-lez v3, :cond_270

    invoke-virtual/range {v37 .. v37}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v3

    :goto_1ea
    move-object/from16 v0, v25

    iput-object v3, v0, Landroid/content/pm/ApplicationInfo;->permission:Ljava/lang/String;

    .line 1810
    move-object/from16 v0, p1

    iget-object v3, v0, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget v3, v3, Landroid/content/pm/ApplicationInfo;->targetSdkVersion:I

    const/16 v4, 0x8

    if-lt v3, v4, :cond_273

    .line 1811
    const/16 v3, 0xc

    const/4 v4, 0x0

    move-object/from16 v0, v36

    invoke-virtual {v0, v3, v4}, Landroid/content/res/TypedArray;->getNonConfigurationString(II)Ljava/lang/String;

    move-result-object v37

    .line 1820
    :goto_201
    move-object/from16 v0, v25

    iget-object v3, v0, Landroid/content/pm/PackageItemInfo;->packageName:Ljava/lang/String;

    move-object/from16 v0, v25

    iget-object v4, v0, Landroid/content/pm/PackageItemInfo;->packageName:Ljava/lang/String;

    move-object/from16 v0, v37

    move-object/from16 v1, p6

    invoke-static {v3, v4, v0, v1}, Landroid/content/pm/PackageParser;->buildTaskAffinityName(Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;[Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v25

    iput-object v3, v0, Landroid/content/pm/ApplicationInfo;->taskAffinity:Ljava/lang/String;

    .line 1823
    const/4 v3, 0x0

    aget-object v3, p6, v3

    if-nez v3, :cond_24f

    .line 1825
    move-object/from16 v0, p1

    iget-object v3, v0, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget v3, v3, Landroid/content/pm/ApplicationInfo;->targetSdkVersion:I

    const/16 v4, 0x8

    if-lt v3, v4, :cond_27c

    .line 1826
    const/16 v3, 0xb

    const/4 v4, 0x0

    move-object/from16 v0, v36

    invoke-virtual {v0, v3, v4}, Landroid/content/res/TypedArray;->getNonConfigurationString(II)Ljava/lang/String;

    move-result-object v5

    .line 1835
    .local v5, pname:Ljava/lang/CharSequence;
    :goto_22d
    move-object/from16 v0, v25

    iget-object v3, v0, Landroid/content/pm/PackageItemInfo;->packageName:Ljava/lang/String;

    const/4 v4, 0x0

    move-object/from16 v0, p0

    iget-object v7, v0, Landroid/content/pm/PackageParser;->mSeparateProcesses:[Ljava/lang/String;

    move/from16 v6, p5

    move-object/from16 v8, p6

    invoke-static/range {v3 .. v8}, Landroid/content/pm/PackageParser;->buildProcessName(Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;I[Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v25

    iput-object v3, v0, Landroid/content/pm/ApplicationInfo;->processName:Ljava/lang/String;

    .line 1838
    const/16 v3, 0x9

    const/4 v4, 0x1

    move-object/from16 v0, v36

    invoke-virtual {v0, v3, v4}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v3

    move-object/from16 v0, v25

    iput-boolean v3, v0, Landroid/content/pm/ApplicationInfo;->enabled:Z

    .line 1856
    .end local v5           #pname:Ljava/lang/CharSequence;
    :cond_24f
    const/16 v3, 0x19

    const/4 v4, 0x0

    move-object/from16 v0, v36

    invoke-virtual {v0, v3, v4}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v3

    move-object/from16 v0, v25

    iput v3, v0, Landroid/content/pm/ApplicationInfo;->uiOptions:I

    .line 1859
    invoke-virtual/range {v36 .. v36}, Landroid/content/res/TypedArray;->recycle()V

    .line 1861
    const/4 v3, 0x0

    aget-object v3, p6, v3

    if-eqz v3, :cond_285

    .line 1862
    const/16 v3, -0x6c

    move-object/from16 v0, p0

    iput v3, v0, Landroid/content/pm/PackageParser;->mParseError:I

    .line 1863
    const/4 v3, 0x0

    goto/16 :goto_40

    .line 1765
    .end local v14           #hardwareAccelerated:Z
    .end local v37           #str:Ljava/lang/String;
    :cond_26d
    const/4 v3, 0x0

    goto/16 :goto_152

    .line 1808
    .restart local v14       #hardwareAccelerated:Z
    .restart local v37       #str:Ljava/lang/String;
    :cond_270
    const/4 v3, 0x0

    goto/16 :goto_1ea

    .line 1817
    :cond_273
    const/16 v3, 0xc

    move-object/from16 v0, v36

    invoke-virtual {v0, v3}, Landroid/content/res/TypedArray;->getNonResourceString(I)Ljava/lang/String;

    move-result-object v37

    goto :goto_201

    .line 1832
    :cond_27c
    const/16 v3, 0xb

    move-object/from16 v0, v36

    invoke-virtual {v0, v3}, Landroid/content/res/TypedArray;->getNonResourceString(I)Ljava/lang/String;

    move-result-object v5

    .restart local v5       #pname:Ljava/lang/CharSequence;
    goto :goto_22d

    .line 1866
    .end local v5           #pname:Ljava/lang/CharSequence;
    :cond_285
    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v28

    .line 1870
    .local v28, innerDepth:I
    :cond_289
    :goto_289
    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v39

    .local v39, type:I
    const/4 v3, 0x1

    move/from16 v0, v39

    if-eq v0, v3, :cond_47a

    const/4 v3, 0x3

    move/from16 v0, v39

    if-ne v0, v3, :cond_29f

    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v3

    move/from16 v0, v28

    if-le v3, v0, :cond_47a

    .line 1871
    :cond_29f
    const/4 v3, 0x3

    move/from16 v0, v39

    if-eq v0, v3, :cond_289

    const/4 v3, 0x4

    move/from16 v0, v39

    if-eq v0, v3, :cond_289

    .line 1875
    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v38

    .line 1876
    .local v38, tagName:Ljava/lang/String;
    const-string v3, "activity"

    move-object/from16 v0, v38

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2df

    .line 1877
    const/4 v13, 0x0

    move-object/from16 v6, p0

    move-object/from16 v7, p1

    move-object/from16 v8, p2

    move-object/from16 v9, p3

    move-object/from16 v10, p4

    move/from16 v11, p5

    move-object/from16 v12, p6

    invoke-direct/range {v6 .. v14}, Landroid/content/pm/PackageParser;->parseActivity(Landroid/content/pm/PackageParser$Package;Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;I[Ljava/lang/String;ZZ)Landroid/content/pm/PackageParser$Activity;

    move-result-object v24

    .line 1879
    .local v24, a:Landroid/content/pm/PackageParser$Activity;
    if-nez v24, :cond_2d5

    .line 1880
    const/16 v3, -0x6c

    move-object/from16 v0, p0

    iput v3, v0, Landroid/content/pm/PackageParser;->mParseError:I

    .line 1881
    const/4 v3, 0x0

    goto/16 :goto_40

    .line 1884
    :cond_2d5
    move-object/from16 v0, p1

    iget-object v3, v0, Landroid/content/pm/PackageParser$Package;->activities:Ljava/util/ArrayList;

    move-object/from16 v0, v24

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_289

    .line 1886
    .end local v24           #a:Landroid/content/pm/PackageParser$Activity;
    :cond_2df
    const-string/jumbo v3, "receiver"

    move-object/from16 v0, v38

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_316

    .line 1887
    const/16 v22, 0x1

    const/16 v23, 0x0

    move-object/from16 v15, p0

    move-object/from16 v16, p1

    move-object/from16 v17, p2

    move-object/from16 v18, p3

    move-object/from16 v19, p4

    move/from16 v20, p5

    move-object/from16 v21, p6

    invoke-direct/range {v15 .. v23}, Landroid/content/pm/PackageParser;->parseActivity(Landroid/content/pm/PackageParser$Package;Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;I[Ljava/lang/String;ZZ)Landroid/content/pm/PackageParser$Activity;

    move-result-object v24

    .line 1888
    .restart local v24       #a:Landroid/content/pm/PackageParser$Activity;
    if-nez v24, :cond_30b

    .line 1889
    const/16 v3, -0x6c

    move-object/from16 v0, p0

    iput v3, v0, Landroid/content/pm/PackageParser;->mParseError:I

    .line 1890
    const/4 v3, 0x0

    goto/16 :goto_40

    .line 1893
    :cond_30b
    move-object/from16 v0, p1

    iget-object v3, v0, Landroid/content/pm/PackageParser$Package;->receivers:Ljava/util/ArrayList;

    move-object/from16 v0, v24

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_289

    .line 1895
    .end local v24           #a:Landroid/content/pm/PackageParser$Activity;
    :cond_316
    const-string/jumbo v3, "service"

    move-object/from16 v0, v38

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_33b

    .line 1896
    invoke-direct/range {p0 .. p6}, Landroid/content/pm/PackageParser;->parseService(Landroid/content/pm/PackageParser$Package;Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;I[Ljava/lang/String;)Landroid/content/pm/PackageParser$Service;

    move-result-object v35

    .line 1897
    .local v35, s:Landroid/content/pm/PackageParser$Service;
    if-nez v35, :cond_330

    .line 1898
    const/16 v3, -0x6c

    move-object/from16 v0, p0

    iput v3, v0, Landroid/content/pm/PackageParser;->mParseError:I

    .line 1899
    const/4 v3, 0x0

    goto/16 :goto_40

    .line 1902
    :cond_330
    move-object/from16 v0, p1

    iget-object v3, v0, Landroid/content/pm/PackageParser$Package;->services:Ljava/util/ArrayList;

    move-object/from16 v0, v35

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_289

    .line 1904
    .end local v35           #s:Landroid/content/pm/PackageParser$Service;
    :cond_33b
    const-string/jumbo v3, "provider"

    move-object/from16 v0, v38

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_360

    .line 1905
    invoke-direct/range {p0 .. p6}, Landroid/content/pm/PackageParser;->parseProvider(Landroid/content/pm/PackageParser$Package;Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;I[Ljava/lang/String;)Landroid/content/pm/PackageParser$Provider;

    move-result-object v32

    .line 1906
    .local v32, p:Landroid/content/pm/PackageParser$Provider;
    if-nez v32, :cond_355

    .line 1907
    const/16 v3, -0x6c

    move-object/from16 v0, p0

    iput v3, v0, Landroid/content/pm/PackageParser;->mParseError:I

    .line 1908
    const/4 v3, 0x0

    goto/16 :goto_40

    .line 1911
    :cond_355
    move-object/from16 v0, p1

    iget-object v3, v0, Landroid/content/pm/PackageParser$Package;->providers:Ljava/util/ArrayList;

    move-object/from16 v0, v32

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_289

    .line 1913
    .end local v32           #p:Landroid/content/pm/PackageParser$Provider;
    :cond_360
    const-string v3, "activity-alias"

    move-object/from16 v0, v38

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_384

    .line 1914
    invoke-direct/range {p0 .. p6}, Landroid/content/pm/PackageParser;->parseActivityAlias(Landroid/content/pm/PackageParser$Package;Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;I[Ljava/lang/String;)Landroid/content/pm/PackageParser$Activity;

    move-result-object v24

    .line 1915
    .restart local v24       #a:Landroid/content/pm/PackageParser$Activity;
    if-nez v24, :cond_379

    .line 1916
    const/16 v3, -0x6c

    move-object/from16 v0, p0

    iput v3, v0, Landroid/content/pm/PackageParser;->mParseError:I

    .line 1917
    const/4 v3, 0x0

    goto/16 :goto_40

    .line 1920
    :cond_379
    move-object/from16 v0, p1

    iget-object v3, v0, Landroid/content/pm/PackageParser$Package;->activities:Ljava/util/ArrayList;

    move-object/from16 v0, v24

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_289

    .line 1922
    .end local v24           #a:Landroid/content/pm/PackageParser$Activity;
    :cond_384
    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "meta-data"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3b2

    .line 1926
    move-object/from16 v0, p1

    iget-object v10, v0, Landroid/content/pm/PackageParser$Package;->mAppMetaData:Landroid/os/Bundle;

    move-object/from16 v6, p0

    move-object/from16 v7, p2

    move-object/from16 v8, p3

    move-object/from16 v9, p4

    move-object/from16 v11, p6

    invoke-direct/range {v6 .. v11}, Landroid/content/pm/PackageParser;->parseMetaData(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/os/Bundle;[Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v3

    move-object/from16 v0, p1

    iput-object v3, v0, Landroid/content/pm/PackageParser$Package;->mAppMetaData:Landroid/os/Bundle;

    if-nez v3, :cond_289

    .line 1928
    const/16 v3, -0x6c

    move-object/from16 v0, p0

    iput v3, v0, Landroid/content/pm/PackageParser;->mParseError:I

    .line 1929
    const/4 v3, 0x0

    goto/16 :goto_40

    .line 1932
    :cond_3b2
    const-string/jumbo v3, "uses-library"

    move-object/from16 v0, v38

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_42f

    .line 1933
    sget-object v3, Lcom/android/internal/R$styleable;->AndroidManifestUsesLibrary:[I

    move-object/from16 v0, p2

    move-object/from16 v1, p4

    invoke-virtual {v0, v1, v3}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v36

    .line 1938
    const/4 v3, 0x0

    move-object/from16 v0, v36

    invoke-virtual {v0, v3}, Landroid/content/res/TypedArray;->getNonResourceString(I)Ljava/lang/String;

    move-result-object v29

    .line 1940
    .local v29, lname:Ljava/lang/String;
    const/4 v3, 0x1

    const/4 v4, 0x1

    move-object/from16 v0, v36

    invoke-virtual {v0, v3, v4}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v34

    .line 1944
    .local v34, req:Z
    invoke-virtual/range {v36 .. v36}, Landroid/content/res/TypedArray;->recycle()V

    .line 1946
    if-eqz v29, :cond_403

    .line 1947
    if-eqz v34, :cond_408

    .line 1948
    move-object/from16 v0, p1

    iget-object v3, v0, Landroid/content/pm/PackageParser$Package;->usesLibraries:Ljava/util/ArrayList;

    if-nez v3, :cond_3ec

    .line 1949
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    move-object/from16 v0, p1

    iput-object v3, v0, Landroid/content/pm/PackageParser$Package;->usesLibraries:Ljava/util/ArrayList;

    .line 1951
    :cond_3ec
    move-object/from16 v0, p1

    iget-object v3, v0, Landroid/content/pm/PackageParser$Package;->usesLibraries:Ljava/util/ArrayList;

    move-object/from16 v0, v29

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_403

    .line 1952
    move-object/from16 v0, p1

    iget-object v3, v0, Landroid/content/pm/PackageParser$Package;->usesLibraries:Ljava/util/ArrayList;

    invoke-virtual/range {v29 .. v29}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1964
    :cond_403
    :goto_403
    invoke-static/range {p3 .. p3}, Lcom/android/internal/util/XmlUtils;->skipCurrentTag(Lorg/xmlpull/v1/XmlPullParser;)V

    goto/16 :goto_289

    .line 1955
    :cond_408
    move-object/from16 v0, p1

    iget-object v3, v0, Landroid/content/pm/PackageParser$Package;->usesOptionalLibraries:Ljava/util/ArrayList;

    if-nez v3, :cond_417

    .line 1956
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    move-object/from16 v0, p1

    iput-object v3, v0, Landroid/content/pm/PackageParser$Package;->usesOptionalLibraries:Ljava/util/ArrayList;

    .line 1958
    :cond_417
    move-object/from16 v0, p1

    iget-object v3, v0, Landroid/content/pm/PackageParser$Package;->usesOptionalLibraries:Ljava/util/ArrayList;

    move-object/from16 v0, v29

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_403

    .line 1959
    move-object/from16 v0, p1

    iget-object v3, v0, Landroid/content/pm/PackageParser$Package;->usesOptionalLibraries:Ljava/util/ArrayList;

    invoke-virtual/range {v29 .. v29}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_403

    .line 1966
    .end local v29           #lname:Ljava/lang/String;
    .end local v34           #req:Z
    :cond_42f
    const-string/jumbo v3, "uses-package"

    move-object/from16 v0, v38

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_43f

    .line 1969
    invoke-static/range {p3 .. p3}, Lcom/android/internal/util/XmlUtils;->skipCurrentTag(Lorg/xmlpull/v1/XmlPullParser;)V

    goto/16 :goto_289

    .line 1973
    :cond_43f
    const-string v3, "PackageParser"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Unknown element under <application>: "

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    move-object/from16 v0, v38

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, " at "

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    move-object/from16 v0, p0

    iget-object v6, v0, Landroid/content/pm/PackageParser;->mArchiveSourcePath:Ljava/lang/String;

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v6, " "

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->getPositionDescription()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Slog;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 1976
    invoke-static/range {p3 .. p3}, Lcom/android/internal/util/XmlUtils;->skipCurrentTag(Lorg/xmlpull/v1/XmlPullParser;)V

    goto/16 :goto_289

    .line 1986
    .end local v38           #tagName:Ljava/lang/String;
    :cond_47a
    const/4 v3, 0x1

    goto/16 :goto_40
.end method

.method private parseInstrumentation(Landroid/content/pm/PackageParser$Package;Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;[Ljava/lang/String;)Landroid/content/pm/PackageParser$Instrumentation;
    .registers 15
    .parameter "owner"
    .parameter "res"
    .parameter "parser"
    .parameter "attrs"
    .parameter "outError"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1618
    sget-object v0, Lcom/android/internal/R$styleable;->AndroidManifestInstrumentation:[I

    invoke-virtual {p2, p4, v0}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v7

    .line 1621
    .local v7, sa:Landroid/content/res/TypedArray;
    iget-object v0, p0, Landroid/content/pm/PackageParser;->mParseInstrumentationArgs:Landroid/content/pm/PackageParser$ParsePackageItemArgs;

    if-nez v0, :cond_1d

    .line 1622
    new-instance v0, Landroid/content/pm/PackageParser$ParsePackageItemArgs;

    const/4 v3, 0x2

    const/4 v4, 0x0

    const/4 v5, 0x1

    const/4 v6, 0x6

    move-object v1, p1

    move-object v2, p5

    invoke-direct/range {v0 .. v6}, Landroid/content/pm/PackageParser$ParsePackageItemArgs;-><init>(Landroid/content/pm/PackageParser$Package;[Ljava/lang/String;IIII)V

    iput-object v0, p0, Landroid/content/pm/PackageParser;->mParseInstrumentationArgs:Landroid/content/pm/PackageParser$ParsePackageItemArgs;

    .line 1627
    iget-object v0, p0, Landroid/content/pm/PackageParser;->mParseInstrumentationArgs:Landroid/content/pm/PackageParser$ParsePackageItemArgs;

    const-string v1, "<instrumentation>"

    iput-object v1, v0, Landroid/content/pm/PackageParser$ParsePackageItemArgs;->tag:Ljava/lang/String;

    .line 1630
    :cond_1d
    iget-object v0, p0, Landroid/content/pm/PackageParser;->mParseInstrumentationArgs:Landroid/content/pm/PackageParser$ParsePackageItemArgs;

    iput-object v7, v0, Landroid/content/pm/PackageParser$ParsePackageItemArgs;->sa:Landroid/content/res/TypedArray;

    .line 1632
    new-instance v5, Landroid/content/pm/PackageParser$Instrumentation;

    iget-object v0, p0, Landroid/content/pm/PackageParser;->mParseInstrumentationArgs:Landroid/content/pm/PackageParser$ParsePackageItemArgs;

    new-instance v1, Landroid/content/pm/InstrumentationInfo;

    invoke-direct {v1}, Landroid/content/pm/InstrumentationInfo;-><init>()V

    invoke-direct {v5, v0, v1}, Landroid/content/pm/PackageParser$Instrumentation;-><init>(Landroid/content/pm/PackageParser$ParsePackageItemArgs;Landroid/content/pm/InstrumentationInfo;)V

    .line 1634
    .local v5, a:Landroid/content/pm/PackageParser$Instrumentation;
    const/4 v0, 0x0

    aget-object v0, p5, v0

    if-eqz v0, :cond_3b

    .line 1635
    invoke-virtual {v7}, Landroid/content/res/TypedArray;->recycle()V

    .line 1636
    const/16 v0, -0x6c

    iput v0, p0, Landroid/content/pm/PackageParser;->mParseError:I

    .line 1637
    const/4 v5, 0x0

    .line 1671
    .end local v5           #a:Landroid/content/pm/PackageParser$Instrumentation;
    :goto_3a
    return-object v5

    .line 1643
    .restart local v5       #a:Landroid/content/pm/PackageParser$Instrumentation;
    :cond_3b
    const/4 v0, 0x3

    invoke-virtual {v7, v0}, Landroid/content/res/TypedArray;->getNonResourceString(I)Ljava/lang/String;

    move-result-object v8

    .line 1645
    .local v8, str:Ljava/lang/String;
    iget-object v1, v5, Landroid/content/pm/PackageParser$Instrumentation;->info:Landroid/content/pm/InstrumentationInfo;

    if-eqz v8, :cond_72

    invoke-virtual {v8}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v0

    :goto_48
    iput-object v0, v1, Landroid/content/pm/InstrumentationInfo;->targetPackage:Ljava/lang/String;

    .line 1647
    iget-object v0, v5, Landroid/content/pm/PackageParser$Instrumentation;->info:Landroid/content/pm/InstrumentationInfo;

    const/4 v1, 0x4

    const/4 v2, 0x0

    invoke-virtual {v7, v1, v2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v1

    iput-boolean v1, v0, Landroid/content/pm/InstrumentationInfo;->handleProfiling:Z

    .line 1651
    iget-object v0, v5, Landroid/content/pm/PackageParser$Instrumentation;->info:Landroid/content/pm/InstrumentationInfo;

    const/4 v1, 0x5

    const/4 v2, 0x0

    invoke-virtual {v7, v1, v2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v1

    iput-boolean v1, v0, Landroid/content/pm/InstrumentationInfo;->functionalTest:Z

    .line 1655
    invoke-virtual {v7}, Landroid/content/res/TypedArray;->recycle()V

    .line 1657
    iget-object v0, v5, Landroid/content/pm/PackageParser$Instrumentation;->info:Landroid/content/pm/InstrumentationInfo;

    iget-object v0, v0, Landroid/content/pm/InstrumentationInfo;->targetPackage:Ljava/lang/String;

    if-nez v0, :cond_74

    .line 1658
    const/4 v0, 0x0

    const-string v1, "<instrumentation> does not specify targetPackage"

    aput-object v1, p5, v0

    .line 1659
    const/16 v0, -0x6c

    iput v0, p0, Landroid/content/pm/PackageParser;->mParseError:I

    .line 1660
    const/4 v5, 0x0

    goto :goto_3a

    .line 1645
    :cond_72
    const/4 v0, 0x0

    goto :goto_48

    .line 1663
    :cond_74
    const-string v4, "<instrumentation>"

    move-object v0, p0

    move-object v1, p2

    move-object v2, p3

    move-object v3, p4

    move-object v6, p5

    invoke-direct/range {v0 .. v6}, Landroid/content/pm/PackageParser;->parseAllMetaData(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Ljava/lang/String;Landroid/content/pm/PackageParser$Component;[Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_87

    .line 1665
    const/16 v0, -0x6c

    iput v0, p0, Landroid/content/pm/PackageParser;->mParseError:I

    .line 1666
    const/4 v5, 0x0

    goto :goto_3a

    .line 1669
    :cond_87
    iget-object v0, p1, Landroid/content/pm/PackageParser$Package;->instrumentation:Ljava/util/ArrayList;

    invoke-virtual {v0, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_3a
.end method

.method private parseIntent(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;ILandroid/content/pm/PackageParser$IntentInfo;[Ljava/lang/String;Z)Z
    .registers 24
    .parameter "res"
    .parameter "parser"
    .parameter "attrs"
    .parameter "flags"
    .parameter "outInfo"
    .parameter "outError"
    .parameter "isActivity"
    .annotation build Landroid/annotation/MiuiHook;
        value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->CHANGE_CODE:Landroid/annotation/MiuiHook$MiuiHookType;
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 2974
    sget-object v13, Lcom/android/internal/R$styleable;->AndroidManifestIntentFilter:[I

    move-object/from16 v0, p1

    move-object/from16 v1, p3

    invoke-virtual {v0, v1, v13}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v8

    .line 2977
    .local v8, sa:Landroid/content/res/TypedArray;
    const/4 v13, 0x2

    const/4 v14, 0x0

    invoke-virtual {v8, v13, v14}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v7

    .line 2979
    .local v7, priority:I
    move-object/from16 v0, p0

    move/from16 v1, p4

    invoke-direct {v0, v1, v7}, Landroid/content/pm/PackageParser;->checkPriority(II)I

    move-result v13

    move-object/from16 v0, p5

    invoke-virtual {v0, v13}, Landroid/content/pm/PackageParser$IntentInfo;->setPriority(I)V

    .line 2981
    const/4 v13, 0x0

    invoke-virtual {v8, v13}, Landroid/content/res/TypedArray;->peekValue(I)Landroid/util/TypedValue;

    move-result-object v11

    .line 2983
    .local v11, v:Landroid/util/TypedValue;
    if-eqz v11, :cond_34

    iget v13, v11, Landroid/util/TypedValue;->resourceId:I

    move-object/from16 v0, p5

    iput v13, v0, Landroid/content/pm/PackageParser$IntentInfo;->labelRes:I

    if-nez v13, :cond_34

    .line 2984
    invoke-virtual {v11}, Landroid/util/TypedValue;->coerceToString()Ljava/lang/CharSequence;

    move-result-object v13

    move-object/from16 v0, p5

    iput-object v13, v0, Landroid/content/pm/PackageParser$IntentInfo;->nonLocalizedLabel:Ljava/lang/CharSequence;

    .line 2987
    :cond_34
    const/4 v13, 0x1

    const/4 v14, 0x0

    invoke-virtual {v8, v13, v14}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v13

    move-object/from16 v0, p5

    iput v13, v0, Landroid/content/pm/PackageParser$IntentInfo;->icon:I

    .line 2990
    const/4 v13, 0x3

    const/4 v14, 0x0

    invoke-virtual {v8, v13, v14}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v13

    move-object/from16 v0, p5

    iput v13, v0, Landroid/content/pm/PackageParser$IntentInfo;->logo:I

    .line 2993
    invoke-virtual {v8}, Landroid/content/res/TypedArray;->recycle()V

    .line 2995
    invoke-interface/range {p2 .. p2}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v5

    .line 2998
    .local v5, outerDepth:I
    :cond_4f
    :goto_4f
    invoke-interface/range {p2 .. p2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v10

    .local v10, type:I
    const/4 v13, 0x1

    if-eq v10, v13, :cond_177

    const/4 v13, 0x3

    if-ne v10, v13, :cond_5f

    invoke-interface/range {p2 .. p2}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v13

    if-le v13, v5, :cond_177

    .line 2999
    :cond_5f
    const/4 v13, 0x3

    if-eq v10, v13, :cond_4f

    const/4 v13, 0x4

    if-eq v10, v13, :cond_4f

    .line 3003
    invoke-interface/range {p2 .. p2}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v4

    .line 3004
    .local v4, nodeName:Ljava/lang/String;
    const-string v13, "action"

    invoke-virtual {v4, v13}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v13

    if-eqz v13, :cond_92

    .line 3005
    const-string v13, "http://schemas.android.com/apk/res/android"

    const-string/jumbo v14, "name"

    move-object/from16 v0, p3

    invoke-interface {v0, v13, v14}, Landroid/util/AttributeSet;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 3007
    .local v12, value:Ljava/lang/String;
    if-eqz v12, :cond_82

    const-string v13, ""

    if-ne v12, v13, :cond_89

    .line 3008
    :cond_82
    const/4 v13, 0x0

    const-string v14, "No value supplied for <android:name>"

    aput-object v14, p6, v13

    .line 3009
    const/4 v13, 0x0

    .line 3103
    .end local v4           #nodeName:Ljava/lang/String;
    .end local v12           #value:Ljava/lang/String;
    :goto_88
    return v13

    .line 3011
    .restart local v4       #nodeName:Ljava/lang/String;
    .restart local v12       #value:Ljava/lang/String;
    :cond_89
    invoke-static/range {p2 .. p2}, Lcom/android/internal/util/XmlUtils;->skipCurrentTag(Lorg/xmlpull/v1/XmlPullParser;)V

    .line 3013
    move-object/from16 v0, p5

    invoke-virtual {v0, v12}, Landroid/content/pm/PackageParser$IntentInfo;->addAction(Ljava/lang/String;)V

    goto :goto_4f

    .line 3014
    .end local v12           #value:Ljava/lang/String;
    :cond_92
    const-string v13, "category"

    invoke-virtual {v4, v13}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v13

    if-eqz v13, :cond_bb

    .line 3015
    const-string v13, "http://schemas.android.com/apk/res/android"

    const-string/jumbo v14, "name"

    move-object/from16 v0, p3

    invoke-interface {v0, v13, v14}, Landroid/util/AttributeSet;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 3017
    .restart local v12       #value:Ljava/lang/String;
    if-eqz v12, :cond_ab

    const-string v13, ""

    if-ne v12, v13, :cond_b2

    .line 3018
    :cond_ab
    const/4 v13, 0x0

    const-string v14, "No value supplied for <android:name>"

    aput-object v14, p6, v13

    .line 3019
    const/4 v13, 0x0

    goto :goto_88

    .line 3021
    :cond_b2
    invoke-static/range {p2 .. p2}, Lcom/android/internal/util/XmlUtils;->skipCurrentTag(Lorg/xmlpull/v1/XmlPullParser;)V

    .line 3023
    move-object/from16 v0, p5

    invoke-virtual {v0, v12}, Landroid/content/pm/PackageParser$IntentInfo;->addCategory(Ljava/lang/String;)V

    goto :goto_4f

    .line 3025
    .end local v12           #value:Ljava/lang/String;
    :cond_bb
    const-string v13, "data"

    invoke-virtual {v4, v13}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v13

    if-eqz v13, :cond_13a

    .line 3026
    sget-object v13, Lcom/android/internal/R$styleable;->AndroidManifestData:[I

    move-object/from16 v0, p1

    move-object/from16 v1, p3

    invoke-virtual {v0, v1, v13}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v8

    .line 3029
    const/4 v13, 0x0

    const/4 v14, 0x0

    invoke-virtual {v8, v13, v14}, Landroid/content/res/TypedArray;->getNonConfigurationString(II)Ljava/lang/String;

    move-result-object v9

    .line 3031
    .local v9, str:Ljava/lang/String;
    if-eqz v9, :cond_da

    .line 3033
    :try_start_d5
    move-object/from16 v0, p5

    invoke-virtual {v0, v9}, Landroid/content/pm/PackageParser$IntentInfo;->addDataType(Ljava/lang/String;)V
    :try_end_da
    .catch Landroid/content/IntentFilter$MalformedMimeTypeException; {:try_start_d5 .. :try_end_da} :catch_12c

    .line 3041
    :cond_da
    const/4 v13, 0x1

    const/4 v14, 0x0

    invoke-virtual {v8, v13, v14}, Landroid/content/res/TypedArray;->getNonConfigurationString(II)Ljava/lang/String;

    move-result-object v9

    .line 3043
    if-eqz v9, :cond_e7

    .line 3044
    move-object/from16 v0, p5

    invoke-virtual {v0, v9}, Landroid/content/pm/PackageParser$IntentInfo;->addDataScheme(Ljava/lang/String;)V

    .line 3047
    :cond_e7
    const/4 v13, 0x2

    const/4 v14, 0x0

    invoke-virtual {v8, v13, v14}, Landroid/content/res/TypedArray;->getNonConfigurationString(II)Ljava/lang/String;

    move-result-object v3

    .line 3049
    .local v3, host:Ljava/lang/String;
    const/4 v13, 0x3

    const/4 v14, 0x0

    invoke-virtual {v8, v13, v14}, Landroid/content/res/TypedArray;->getNonConfigurationString(II)Ljava/lang/String;

    move-result-object v6

    .line 3051
    .local v6, port:Ljava/lang/String;
    if-eqz v3, :cond_fa

    .line 3052
    move-object/from16 v0, p5

    invoke-virtual {v0, v3, v6}, Landroid/content/pm/PackageParser$IntentInfo;->addDataAuthority(Ljava/lang/String;Ljava/lang/String;)V

    .line 3055
    :cond_fa
    const/4 v13, 0x4

    const/4 v14, 0x0

    invoke-virtual {v8, v13, v14}, Landroid/content/res/TypedArray;->getNonConfigurationString(II)Ljava/lang/String;

    move-result-object v9

    .line 3057
    if-eqz v9, :cond_108

    .line 3058
    const/4 v13, 0x0

    move-object/from16 v0, p5

    invoke-virtual {v0, v9, v13}, Landroid/content/pm/PackageParser$IntentInfo;->addDataPath(Ljava/lang/String;I)V

    .line 3061
    :cond_108
    const/4 v13, 0x5

    const/4 v14, 0x0

    invoke-virtual {v8, v13, v14}, Landroid/content/res/TypedArray;->getNonConfigurationString(II)Ljava/lang/String;

    move-result-object v9

    .line 3063
    if-eqz v9, :cond_116

    .line 3064
    const/4 v13, 0x1

    move-object/from16 v0, p5

    invoke-virtual {v0, v9, v13}, Landroid/content/pm/PackageParser$IntentInfo;->addDataPath(Ljava/lang/String;I)V

    .line 3067
    :cond_116
    const/4 v13, 0x6

    const/4 v14, 0x0

    invoke-virtual {v8, v13, v14}, Landroid/content/res/TypedArray;->getNonConfigurationString(II)Ljava/lang/String;

    move-result-object v9

    .line 3069
    if-eqz v9, :cond_124

    .line 3070
    const/4 v13, 0x2

    move-object/from16 v0, p5

    invoke-virtual {v0, v9, v13}, Landroid/content/pm/PackageParser$IntentInfo;->addDataPath(Ljava/lang/String;I)V

    .line 3073
    :cond_124
    invoke-virtual {v8}, Landroid/content/res/TypedArray;->recycle()V

    .line 3074
    invoke-static/range {p2 .. p2}, Lcom/android/internal/util/XmlUtils;->skipCurrentTag(Lorg/xmlpull/v1/XmlPullParser;)V

    goto/16 :goto_4f

    .line 3034
    .end local v3           #host:Ljava/lang/String;
    .end local v6           #port:Ljava/lang/String;
    :catch_12c
    move-exception v2

    .line 3035
    .local v2, e:Landroid/content/IntentFilter$MalformedMimeTypeException;
    const/4 v13, 0x0

    invoke-virtual {v2}, Landroid/content/IntentFilter$MalformedMimeTypeException;->toString()Ljava/lang/String;

    move-result-object v14

    aput-object v14, p6, v13

    .line 3036
    invoke-virtual {v8}, Landroid/content/res/TypedArray;->recycle()V

    .line 3037
    const/4 v13, 0x0

    goto/16 :goto_88

    .line 3076
    .end local v2           #e:Landroid/content/IntentFilter$MalformedMimeTypeException;
    .end local v9           #str:Ljava/lang/String;
    :cond_13a
    const-string v13, "PackageParser"

    new-instance v14, Ljava/lang/StringBuilder;

    invoke-direct {v14}, Ljava/lang/StringBuilder;-><init>()V

    const-string v15, "Unknown element under <intent-filter>: "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-interface/range {p2 .. p2}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    const-string v15, " at "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/content/pm/PackageParser;->mArchiveSourcePath:Ljava/lang/String;

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    const-string v15, " "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-interface/range {p2 .. p2}, Lorg/xmlpull/v1/XmlPullParser;->getPositionDescription()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-static {v13, v14}, Landroid/util/Slog;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 3079
    invoke-static/range {p2 .. p2}, Lcom/android/internal/util/XmlUtils;->skipCurrentTag(Lorg/xmlpull/v1/XmlPullParser;)V

    goto/16 :goto_4f

    .line 3086
    .end local v4           #nodeName:Ljava/lang/String;
    :cond_177
    const-string v13, "android.intent.category.DEFAULT"

    move-object/from16 v0, p5

    invoke-virtual {v0, v13}, Landroid/content/pm/PackageParser$IntentInfo;->hasCategory(Ljava/lang/String;)Z

    move-result v13

    move-object/from16 v0, p5

    iput-boolean v13, v0, Landroid/content/pm/PackageParser$IntentInfo;->hasDefault:Z

    .line 3103
    const/4 v13, 0x1

    goto/16 :goto_88
.end method

.method private parseMetaData(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/os/Bundle;[Ljava/lang/String;)Landroid/os/Bundle;
    .registers 15
    .parameter "res"
    .parameter "parser"
    .parameter "attrs"
    .parameter "data"
    .parameter "outError"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    const/4 v5, 0x1

    const/4 v6, 0x0

    .line 2836
    sget-object v7, Lcom/android/internal/R$styleable;->AndroidManifestMetaData:[I

    invoke-virtual {p1, p3, v7}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v2

    .line 2839
    .local v2, sa:Landroid/content/res/TypedArray;
    if-nez p4, :cond_10

    .line 2840
    new-instance p4, Landroid/os/Bundle;

    .end local p4
    invoke-direct {p4}, Landroid/os/Bundle;-><init>()V

    .line 2843
    .restart local p4
    :cond_10
    invoke-virtual {v2, v6, v6}, Landroid/content/res/TypedArray;->getNonConfigurationString(II)Ljava/lang/String;

    move-result-object v1

    .line 2845
    .local v1, name:Ljava/lang/String;
    if-nez v1, :cond_1e

    .line 2846
    const-string v5, "<meta-data> requires an android:name attribute"

    aput-object v5, p5, v6

    .line 2847
    invoke-virtual {v2}, Landroid/content/res/TypedArray;->recycle()V

    .line 2893
    :goto_1d
    return-object v4

    .line 2851
    :cond_1e
    invoke-virtual {v1}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v1

    .line 2853
    const/4 v7, 0x2

    invoke-virtual {v2, v7}, Landroid/content/res/TypedArray;->peekValue(I)Landroid/util/TypedValue;

    move-result-object v3

    .line 2855
    .local v3, v:Landroid/util/TypedValue;
    if-eqz v3, :cond_3a

    iget v7, v3, Landroid/util/TypedValue;->resourceId:I

    if-eqz v7, :cond_3a

    .line 2857
    iget v4, v3, Landroid/util/TypedValue;->resourceId:I

    invoke-virtual {p4, v1, v4}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2889
    :goto_32
    invoke-virtual {v2}, Landroid/content/res/TypedArray;->recycle()V

    .line 2891
    invoke-static {p2}, Lcom/android/internal/util/XmlUtils;->skipCurrentTag(Lorg/xmlpull/v1/XmlPullParser;)V

    move-object v4, p4

    .line 2893
    goto :goto_1d

    .line 2859
    :cond_3a
    invoke-virtual {v2, v5}, Landroid/content/res/TypedArray;->peekValue(I)Landroid/util/TypedValue;

    move-result-object v3

    .line 2862
    if-eqz v3, :cond_bf

    .line 2863
    iget v7, v3, Landroid/util/TypedValue;->type:I

    const/4 v8, 0x3

    if-ne v7, v8, :cond_57

    .line 2864
    invoke-virtual {v3}, Landroid/util/TypedValue;->coerceToString()Ljava/lang/CharSequence;

    move-result-object v0

    .line 2865
    .local v0, cs:Ljava/lang/CharSequence;
    if-eqz v0, :cond_53

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v4

    :cond_53
    invoke-virtual {p4, v1, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_32

    .line 2866
    .end local v0           #cs:Ljava/lang/CharSequence;
    :cond_57
    iget v4, v3, Landroid/util/TypedValue;->type:I

    const/16 v7, 0x12

    if-ne v4, v7, :cond_68

    .line 2867
    iget v4, v3, Landroid/util/TypedValue;->data:I

    if-eqz v4, :cond_66

    move v4, v5

    :goto_62
    invoke-virtual {p4, v1, v4}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    goto :goto_32

    :cond_66
    move v4, v6

    goto :goto_62

    .line 2868
    :cond_68
    iget v4, v3, Landroid/util/TypedValue;->type:I

    const/16 v5, 0x10

    if-lt v4, v5, :cond_7a

    iget v4, v3, Landroid/util/TypedValue;->type:I

    const/16 v5, 0x1f

    if-gt v4, v5, :cond_7a

    .line 2870
    iget v4, v3, Landroid/util/TypedValue;->data:I

    invoke-virtual {p4, v1, v4}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    goto :goto_32

    .line 2871
    :cond_7a
    iget v4, v3, Landroid/util/TypedValue;->type:I

    const/4 v5, 0x4

    if-ne v4, v5, :cond_87

    .line 2872
    invoke-virtual {v3}, Landroid/util/TypedValue;->getFloat()F

    move-result v4

    invoke-virtual {p4, v1, v4}, Landroid/os/Bundle;->putFloat(Ljava/lang/String;F)V

    goto :goto_32

    .line 2875
    :cond_87
    const-string v4, "PackageParser"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "<meta-data> only supports string, integer, float, color, boolean, and resource reference types: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-interface {p2}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " at "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Landroid/content/pm/PackageParser;->mArchiveSourcePath:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-interface {p2}, Lorg/xmlpull/v1/XmlPullParser;->getPositionDescription()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Slog;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_32

    .line 2884
    :cond_bf
    const-string v4, "<meta-data> requires an android:value or android:resource attribute"

    aput-object v4, p5, v6

    .line 2885
    const/4 p4, 0x0

    goto/16 :goto_32
.end method

.method private parsePackage(Landroid/content/res/Resources;Landroid/content/res/XmlResourceParser;I[Ljava/lang/String;)Landroid/content/pm/PackageParser$Package;
    .registers 53
    .parameter "res"
    .parameter "parser"
    .parameter "flags"
    .parameter "outError"
    .annotation build Landroid/annotation/MiuiHook;
        value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->CHANGE_CODE:Landroid/annotation/MiuiHook$MiuiHookType;
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 899
    move-object/from16 v7, p2

    .line 901
    .local v7, attrs:Landroid/util/AttributeSet;
    const/4 v3, 0x0

    move-object/from16 v0, p0

    iput-object v3, v0, Landroid/content/pm/PackageParser;->mParseInstrumentationArgs:Landroid/content/pm/PackageParser$ParsePackageItemArgs;

    .line 902
    const/4 v3, 0x0

    move-object/from16 v0, p0

    iput-object v3, v0, Landroid/content/pm/PackageParser;->mParseActivityArgs:Landroid/content/pm/PackageParser$ParseComponentArgs;

    .line 903
    const/4 v3, 0x0

    move-object/from16 v0, p0

    iput-object v3, v0, Landroid/content/pm/PackageParser;->mParseServiceArgs:Landroid/content/pm/PackageParser$ParseComponentArgs;

    .line 904
    const/4 v3, 0x0

    move-object/from16 v0, p0

    iput-object v3, v0, Landroid/content/pm/PackageParser;->mParseProviderArgs:Landroid/content/pm/PackageParser$ParseComponentArgs;

    .line 906
    move-object/from16 v0, p2

    move/from16 v1, p3

    move-object/from16 v2, p4

    invoke-static {v0, v7, v1, v2}, Landroid/content/pm/PackageParser;->parsePackageName(Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;I[Ljava/lang/String;)Ljava/lang/String;

    move-result-object v34

    .line 907
    .local v34, pkgName:Ljava/lang/String;
    if-nez v34, :cond_2a

    .line 908
    const/16 v3, -0x6a

    move-object/from16 v0, p0

    iput v3, v0, Landroid/content/pm/PackageParser;->mParseError:I

    .line 909
    const/4 v4, 0x0

    .line 1374
    :cond_29
    :goto_29
    return-object v4

    .line 913
    :cond_2a
    move-object/from16 v0, p0

    iget-boolean v3, v0, Landroid/content/pm/PackageParser;->mOnlyCoreApps:Z

    if-eqz v3, :cond_41

    .line 914
    const/4 v3, 0x0

    const-string v5, "coreApp"

    const/4 v6, 0x0

    invoke-interface {v7, v3, v5, v6}, Landroid/util/AttributeSet;->getAttributeBooleanValue(Ljava/lang/String;Ljava/lang/String;Z)Z

    move-result v19

    .line 915
    .local v19, core:Z
    if-nez v19, :cond_41

    .line 916
    const/4 v3, 0x1

    move-object/from16 v0, p0

    iput v3, v0, Landroid/content/pm/PackageParser;->mParseError:I

    .line 917
    const/4 v4, 0x0

    goto :goto_29

    .line 921
    .end local v19           #core:Z
    :cond_41
    new-instance v4, Landroid/content/pm/PackageParser$Package;

    move-object/from16 v0, v34

    invoke-direct {v4, v0}, Landroid/content/pm/PackageParser$Package;-><init>(Ljava/lang/String;)V

    .line 922
    .local v4, pkg:Landroid/content/pm/PackageParser$Package;
    const/16 v21, 0x0

    .line 924
    .local v21, foundApp:Z
    sget-object v3, Lcom/android/internal/R$styleable;->AndroidManifest:[I

    move-object/from16 v0, p1

    invoke-virtual {v0, v7, v3}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v36

    .line 926
    .local v36, sa:Landroid/content/res/TypedArray;
    const/4 v3, 0x1

    const/4 v5, 0x0

    move-object/from16 v0, v36

    invoke-virtual {v0, v3, v5}, Landroid/content/res/TypedArray;->getInteger(II)I

    move-result v3

    iput v3, v4, Landroid/content/pm/PackageParser$Package;->mVersionCode:I

    .line 928
    const/4 v3, 0x2

    const/4 v5, 0x0

    move-object/from16 v0, v36

    invoke-virtual {v0, v3, v5}, Landroid/content/res/TypedArray;->getNonConfigurationString(II)Ljava/lang/String;

    move-result-object v3

    iput-object v3, v4, Landroid/content/pm/PackageParser$Package;->mVersionName:Ljava/lang/String;

    .line 930
    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->mVersionName:Ljava/lang/String;

    if-eqz v3, :cond_72

    .line 931
    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->mVersionName:Ljava/lang/String;

    invoke-virtual {v3}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v3

    iput-object v3, v4, Landroid/content/pm/PackageParser$Package;->mVersionName:Ljava/lang/String;

    .line 933
    :cond_72
    const/4 v3, 0x0

    const/4 v5, 0x0

    move-object/from16 v0, v36

    invoke-virtual {v0, v3, v5}, Landroid/content/res/TypedArray;->getNonConfigurationString(II)Ljava/lang/String;

    move-result-object v38

    .line 935
    .local v38, str:Ljava/lang/String;
    if-eqz v38, :cond_dd

    invoke-virtual/range {v38 .. v38}, Ljava/lang/String;->length()I

    move-result v3

    if-lez v3, :cond_dd

    .line 936
    const/4 v3, 0x1

    move-object/from16 v0, v38

    invoke-static {v0, v3}, Landroid/content/pm/PackageParser;->validateName(Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v29

    .line 937
    .local v29, nameError:Ljava/lang/String;
    if-eqz v29, :cond_cd

    const-string v3, "android"

    move-object/from16 v0, v34

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_cd

    const-string/jumbo v3, "miui"

    move-object/from16 v0, v34

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_cd

    .line 938
    const/4 v3, 0x0

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "<manifest> specifies bad sharedUserId name \""

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move-object/from16 v0, v38

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "\": "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move-object/from16 v0, v29

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, p4, v3

    .line 940
    const/16 v3, -0x6b

    move-object/from16 v0, p0

    iput v3, v0, Landroid/content/pm/PackageParser;->mParseError:I

    .line 941
    const/4 v4, 0x0

    goto/16 :goto_29

    .line 943
    :cond_cd
    invoke-virtual/range {v38 .. v38}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v3

    iput-object v3, v4, Landroid/content/pm/PackageParser$Package;->mSharedUserId:Ljava/lang/String;

    .line 944
    const/4 v3, 0x3

    const/4 v5, 0x0

    move-object/from16 v0, v36

    invoke-virtual {v0, v3, v5}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v3

    iput v3, v4, Landroid/content/pm/PackageParser$Package;->mSharedUserLabel:I

    .line 947
    .end local v29           #nameError:Ljava/lang/String;
    :cond_dd
    invoke-virtual/range {v36 .. v36}, Landroid/content/res/TypedArray;->recycle()V

    .line 949
    const/4 v3, 0x4

    const/4 v5, -0x1

    move-object/from16 v0, v36

    invoke-virtual {v0, v3, v5}, Landroid/content/res/TypedArray;->getInteger(II)I

    move-result v3

    iput v3, v4, Landroid/content/pm/PackageParser$Package;->installLocation:I

    .line 952
    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget v5, v4, Landroid/content/pm/PackageParser$Package;->installLocation:I

    iput v5, v3, Landroid/content/pm/ApplicationInfo;->installLocation:I

    .line 955
    and-int/lit8 v3, p3, 0x10

    if-eqz v3, :cond_fd

    .line 956
    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget v5, v3, Landroid/content/pm/ApplicationInfo;->flags:I

    const/high16 v6, 0x2000

    or-int/2addr v5, v6

    iput v5, v3, Landroid/content/pm/ApplicationInfo;->flags:I

    .line 960
    :cond_fd
    and-int/lit8 v3, p3, 0x20

    if-eqz v3, :cond_10a

    .line 961
    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget v5, v3, Landroid/content/pm/ApplicationInfo;->flags:I

    const/high16 v6, 0x4

    or-int/2addr v5, v6

    iput v5, v3, Landroid/content/pm/ApplicationInfo;->flags:I

    .line 965
    :cond_10a
    const/16 v41, 0x1

    .line 966
    .local v41, supportsSmallScreens:I
    const/16 v40, 0x1

    .line 967
    .local v40, supportsNormalScreens:I
    const/16 v39, 0x1

    .line 968
    .local v39, supportsLargeScreens:I
    const/16 v42, 0x1

    .line 969
    .local v42, supportsXLargeScreens:I
    const/16 v35, 0x1

    .line 970
    .local v35, resizeable:I
    const/16 v17, 0x1

    .line 972
    .local v17, anyDensity:I
    invoke-interface/range {p2 .. p2}, Landroid/content/res/XmlResourceParser;->getDepth()I

    move-result v32

    .line 974
    .local v32, outerDepth:I
    :cond_11a
    :goto_11a
    invoke-interface/range {p2 .. p2}, Landroid/content/res/XmlResourceParser;->next()I

    move-result v46

    .local v46, type:I
    const/4 v3, 0x1

    move/from16 v0, v46

    if-eq v0, v3, :cond_62c

    const/4 v3, 0x3

    move/from16 v0, v46

    if-ne v0, v3, :cond_130

    invoke-interface/range {p2 .. p2}, Landroid/content/res/XmlResourceParser;->getDepth()I

    move-result v3

    move/from16 v0, v32

    if-le v3, v0, :cond_62c

    .line 975
    :cond_130
    const/4 v3, 0x3

    move/from16 v0, v46

    if-eq v0, v3, :cond_11a

    const/4 v3, 0x4

    move/from16 v0, v46

    if-eq v0, v3, :cond_11a

    .line 979
    invoke-interface/range {p2 .. p2}, Landroid/content/res/XmlResourceParser;->getName()Ljava/lang/String;

    move-result-object v43

    .line 980
    .local v43, tagName:Ljava/lang/String;
    const-string v3, "application"

    move-object/from16 v0, v43

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_16a

    .line 981
    if-eqz v21, :cond_155

    .line 987
    const-string v3, "PackageParser"

    const-string v5, "<manifest> has more than one <application>"

    invoke-static {v3, v5}, Landroid/util/Slog;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 988
    invoke-static/range {p2 .. p2}, Lcom/android/internal/util/XmlUtils;->skipCurrentTag(Lorg/xmlpull/v1/XmlPullParser;)V

    goto :goto_11a

    .line 993
    :cond_155
    const/16 v21, 0x1

    move-object/from16 v3, p0

    move-object/from16 v5, p1

    move-object/from16 v6, p2

    move/from16 v8, p3

    move-object/from16 v9, p4

    .line 994
    invoke-direct/range {v3 .. v9}, Landroid/content/pm/PackageParser;->parseApplication(Landroid/content/pm/PackageParser$Package;Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;I[Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_11a

    .line 995
    const/4 v4, 0x0

    goto/16 :goto_29

    .line 997
    :cond_16a
    const-string/jumbo v3, "permission-group"

    move-object/from16 v0, v43

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_18a

    move-object/from16 v8, p0

    move-object v9, v4

    move/from16 v10, p3

    move-object/from16 v11, p1

    move-object/from16 v12, p2

    move-object v13, v7

    move-object/from16 v14, p4

    .line 998
    invoke-direct/range {v8 .. v14}, Landroid/content/pm/PackageParser;->parsePermissionGroup(Landroid/content/pm/PackageParser$Package;ILandroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;[Ljava/lang/String;)Landroid/content/pm/PackageParser$PermissionGroup;

    move-result-object v3

    if-nez v3, :cond_11a

    .line 999
    const/4 v4, 0x0

    goto/16 :goto_29

    .line 1001
    :cond_18a
    const-string/jumbo v3, "permission"

    move-object/from16 v0, v43

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1a6

    move-object/from16 v3, p0

    move-object/from16 v5, p1

    move-object/from16 v6, p2

    move-object/from16 v8, p4

    .line 1002
    invoke-direct/range {v3 .. v8}, Landroid/content/pm/PackageParser;->parsePermission(Landroid/content/pm/PackageParser$Package;Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;[Ljava/lang/String;)Landroid/content/pm/PackageParser$Permission;

    move-result-object v3

    if-nez v3, :cond_11a

    .line 1003
    const/4 v4, 0x0

    goto/16 :goto_29

    .line 1005
    :cond_1a6
    const-string/jumbo v3, "permission-tree"

    move-object/from16 v0, v43

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1c2

    move-object/from16 v3, p0

    move-object/from16 v5, p1

    move-object/from16 v6, p2

    move-object/from16 v8, p4

    .line 1006
    invoke-direct/range {v3 .. v8}, Landroid/content/pm/PackageParser;->parsePermissionTree(Landroid/content/pm/PackageParser$Package;Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;[Ljava/lang/String;)Landroid/content/pm/PackageParser$Permission;

    move-result-object v3

    if-nez v3, :cond_11a

    .line 1007
    const/4 v4, 0x0

    goto/16 :goto_29

    .line 1009
    :cond_1c2
    const-string/jumbo v3, "uses-permission"

    move-object/from16 v0, v43

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_200

    .line 1010
    sget-object v3, Lcom/android/internal/R$styleable;->AndroidManifestUsesPermission:[I

    move-object/from16 v0, p1

    invoke-virtual {v0, v7, v3}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v36

    .line 1015
    const/4 v3, 0x0

    move-object/from16 v0, v36

    invoke-virtual {v0, v3}, Landroid/content/res/TypedArray;->getNonResourceString(I)Ljava/lang/String;

    move-result-object v28

    .line 1022
    .local v28, name:Ljava/lang/String;
    invoke-virtual/range {v36 .. v36}, Landroid/content/res/TypedArray;->recycle()V

    .line 1024
    if-eqz v28, :cond_1fb

    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->requestedPermissions:Ljava/util/ArrayList;

    move-object/from16 v0, v28

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1fb

    .line 1025
    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->requestedPermissions:Ljava/util/ArrayList;

    invoke-virtual/range {v28 .. v28}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1026
    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->requestedPermissionsRequired:Ljava/util/ArrayList;

    sget-object v5, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v3, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1029
    :cond_1fb
    invoke-static/range {p2 .. p2}, Lcom/android/internal/util/XmlUtils;->skipCurrentTag(Lorg/xmlpull/v1/XmlPullParser;)V

    goto/16 :goto_11a

    .line 1031
    .end local v28           #name:Ljava/lang/String;
    :cond_200
    const-string/jumbo v3, "uses-configuration"

    move-object/from16 v0, v43

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_273

    .line 1032
    new-instance v18, Landroid/content/pm/ConfigurationInfo;

    invoke-direct/range {v18 .. v18}, Landroid/content/pm/ConfigurationInfo;-><init>()V

    .line 1033
    .local v18, cPref:Landroid/content/pm/ConfigurationInfo;
    sget-object v3, Lcom/android/internal/R$styleable;->AndroidManifestUsesConfiguration:[I

    move-object/from16 v0, p1

    invoke-virtual {v0, v7, v3}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v36

    .line 1035
    const/4 v3, 0x0

    const/4 v5, 0x0

    move-object/from16 v0, v36

    invoke-virtual {v0, v3, v5}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v3

    move-object/from16 v0, v18

    iput v3, v0, Landroid/content/pm/ConfigurationInfo;->reqTouchScreen:I

    .line 1038
    const/4 v3, 0x1

    const/4 v5, 0x0

    move-object/from16 v0, v36

    invoke-virtual {v0, v3, v5}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v3

    move-object/from16 v0, v18

    iput v3, v0, Landroid/content/pm/ConfigurationInfo;->reqKeyboardType:I

    .line 1041
    const/4 v3, 0x2

    const/4 v5, 0x0

    move-object/from16 v0, v36

    invoke-virtual {v0, v3, v5}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v3

    if-eqz v3, :cond_244

    .line 1044
    move-object/from16 v0, v18

    iget v3, v0, Landroid/content/pm/ConfigurationInfo;->reqInputFeatures:I

    or-int/lit8 v3, v3, 0x1

    move-object/from16 v0, v18

    iput v3, v0, Landroid/content/pm/ConfigurationInfo;->reqInputFeatures:I

    .line 1046
    :cond_244
    const/4 v3, 0x3

    const/4 v5, 0x0

    move-object/from16 v0, v36

    invoke-virtual {v0, v3, v5}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v3

    move-object/from16 v0, v18

    iput v3, v0, Landroid/content/pm/ConfigurationInfo;->reqNavigation:I

    .line 1049
    const/4 v3, 0x4

    const/4 v5, 0x0

    move-object/from16 v0, v36

    invoke-virtual {v0, v3, v5}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v3

    if-eqz v3, :cond_264

    .line 1052
    move-object/from16 v0, v18

    iget v3, v0, Landroid/content/pm/ConfigurationInfo;->reqInputFeatures:I

    or-int/lit8 v3, v3, 0x2

    move-object/from16 v0, v18

    iput v3, v0, Landroid/content/pm/ConfigurationInfo;->reqInputFeatures:I

    .line 1054
    :cond_264
    invoke-virtual/range {v36 .. v36}, Landroid/content/res/TypedArray;->recycle()V

    .line 1055
    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->configPreferences:Ljava/util/ArrayList;

    move-object/from16 v0, v18

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1057
    invoke-static/range {p2 .. p2}, Lcom/android/internal/util/XmlUtils;->skipCurrentTag(Lorg/xmlpull/v1/XmlPullParser;)V

    goto/16 :goto_11a

    .line 1059
    .end local v18           #cPref:Landroid/content/pm/ConfigurationInfo;
    :cond_273
    const-string/jumbo v3, "uses-feature"

    move-object/from16 v0, v43

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2f0

    .line 1060
    new-instance v20, Landroid/content/pm/FeatureInfo;

    invoke-direct/range {v20 .. v20}, Landroid/content/pm/FeatureInfo;-><init>()V

    .line 1061
    .local v20, fi:Landroid/content/pm/FeatureInfo;
    sget-object v3, Lcom/android/internal/R$styleable;->AndroidManifestUsesFeature:[I

    move-object/from16 v0, p1

    invoke-virtual {v0, v7, v3}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v36

    .line 1065
    const/4 v3, 0x0

    move-object/from16 v0, v36

    invoke-virtual {v0, v3}, Landroid/content/res/TypedArray;->getNonResourceString(I)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v20

    iput-object v3, v0, Landroid/content/pm/FeatureInfo;->name:Ljava/lang/String;

    .line 1067
    move-object/from16 v0, v20

    iget-object v3, v0, Landroid/content/pm/FeatureInfo;->name:Ljava/lang/String;

    if-nez v3, :cond_2a8

    .line 1068
    const/4 v3, 0x1

    const/4 v5, 0x0

    move-object/from16 v0, v36

    invoke-virtual {v0, v3, v5}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v3

    move-object/from16 v0, v20

    iput v3, v0, Landroid/content/pm/FeatureInfo;->reqGlEsVersion:I

    .line 1072
    :cond_2a8
    const/4 v3, 0x2

    const/4 v5, 0x1

    move-object/from16 v0, v36

    invoke-virtual {v0, v3, v5}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v3

    if-eqz v3, :cond_2bc

    .line 1075
    move-object/from16 v0, v20

    iget v3, v0, Landroid/content/pm/FeatureInfo;->flags:I

    or-int/lit8 v3, v3, 0x1

    move-object/from16 v0, v20

    iput v3, v0, Landroid/content/pm/FeatureInfo;->flags:I

    .line 1077
    :cond_2bc
    invoke-virtual/range {v36 .. v36}, Landroid/content/res/TypedArray;->recycle()V

    .line 1078
    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->reqFeatures:Ljava/util/ArrayList;

    if-nez v3, :cond_2ca

    .line 1079
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    iput-object v3, v4, Landroid/content/pm/PackageParser$Package;->reqFeatures:Ljava/util/ArrayList;

    .line 1081
    :cond_2ca
    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->reqFeatures:Ljava/util/ArrayList;

    move-object/from16 v0, v20

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1083
    move-object/from16 v0, v20

    iget-object v3, v0, Landroid/content/pm/FeatureInfo;->name:Ljava/lang/String;

    if-nez v3, :cond_2eb

    .line 1084
    new-instance v18, Landroid/content/pm/ConfigurationInfo;

    invoke-direct/range {v18 .. v18}, Landroid/content/pm/ConfigurationInfo;-><init>()V

    .line 1085
    .restart local v18       #cPref:Landroid/content/pm/ConfigurationInfo;
    move-object/from16 v0, v20

    iget v3, v0, Landroid/content/pm/FeatureInfo;->reqGlEsVersion:I

    move-object/from16 v0, v18

    iput v3, v0, Landroid/content/pm/ConfigurationInfo;->reqGlEsVersion:I

    .line 1086
    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->configPreferences:Ljava/util/ArrayList;

    move-object/from16 v0, v18

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1089
    .end local v18           #cPref:Landroid/content/pm/ConfigurationInfo;
    :cond_2eb
    invoke-static/range {p2 .. p2}, Lcom/android/internal/util/XmlUtils;->skipCurrentTag(Lorg/xmlpull/v1/XmlPullParser;)V

    goto/16 :goto_11a

    .line 1091
    .end local v20           #fi:Landroid/content/pm/FeatureInfo;
    :cond_2f0
    const-string/jumbo v3, "uses-sdk"

    move-object/from16 v0, v43

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_471

    .line 1092
    sget v3, Landroid/content/pm/PackageParser;->SDK_VERSION:I

    if-lez v3, :cond_465

    .line 1093
    sget-object v3, Lcom/android/internal/R$styleable;->AndroidManifestUsesSdk:[I

    move-object/from16 v0, p1

    invoke-virtual {v0, v7, v3}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v36

    .line 1096
    const/16 v27, 0x0

    .line 1097
    .local v27, minVers:I
    const/16 v26, 0x0

    .line 1098
    .local v26, minCode:Ljava/lang/String;
    const/16 v45, 0x0

    .line 1099
    .local v45, targetVers:I
    const/16 v44, 0x0

    .line 1101
    .local v44, targetCode:Ljava/lang/String;
    const/4 v3, 0x0

    move-object/from16 v0, v36

    invoke-virtual {v0, v3}, Landroid/content/res/TypedArray;->peekValue(I)Landroid/util/TypedValue;

    move-result-object v47

    .line 1103
    .local v47, val:Landroid/util/TypedValue;
    if-eqz v47, :cond_32f

    .line 1104
    move-object/from16 v0, v47

    iget v3, v0, Landroid/util/TypedValue;->type:I

    const/4 v5, 0x3

    if-ne v3, v5, :cond_395

    move-object/from16 v0, v47

    iget-object v3, v0, Landroid/util/TypedValue;->string:Ljava/lang/CharSequence;

    if-eqz v3, :cond_395

    .line 1105
    move-object/from16 v0, v47

    iget-object v3, v0, Landroid/util/TypedValue;->string:Ljava/lang/CharSequence;

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v26

    move-object/from16 v44, v26

    .line 1112
    :cond_32f
    :goto_32f
    const/4 v3, 0x1

    move-object/from16 v0, v36

    invoke-virtual {v0, v3}, Landroid/content/res/TypedArray;->peekValue(I)Landroid/util/TypedValue;

    move-result-object v47

    .line 1114
    if-eqz v47, :cond_34f

    .line 1115
    move-object/from16 v0, v47

    iget v3, v0, Landroid/util/TypedValue;->type:I

    const/4 v5, 0x3

    if-ne v3, v5, :cond_39e

    move-object/from16 v0, v47

    iget-object v3, v0, Landroid/util/TypedValue;->string:Ljava/lang/CharSequence;

    if-eqz v3, :cond_39e

    .line 1116
    move-object/from16 v0, v47

    iget-object v3, v0, Landroid/util/TypedValue;->string:Ljava/lang/CharSequence;

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v26

    move-object/from16 v44, v26

    .line 1123
    :cond_34f
    :goto_34f
    invoke-virtual/range {v36 .. v36}, Landroid/content/res/TypedArray;->recycle()V

    .line 1125
    if-eqz v26, :cond_3c4

    .line 1126
    sget-object v3, Landroid/content/pm/PackageParser;->SDK_CODENAME:Ljava/lang/String;

    move-object/from16 v0, v26

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_3fd

    .line 1127
    sget-object v3, Landroid/content/pm/PackageParser;->SDK_CODENAME:Ljava/lang/String;

    if-eqz v3, :cond_3a5

    .line 1128
    const/4 v3, 0x0

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Requires development platform "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move-object/from16 v0, v26

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " (current platform is "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    sget-object v6, Landroid/content/pm/PackageParser;->SDK_CODENAME:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ")"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, p4, v3

    .line 1134
    :goto_38c
    const/16 v3, -0xc

    move-object/from16 v0, p0

    iput v3, v0, Landroid/content/pm/PackageParser;->mParseError:I

    .line 1135
    const/4 v4, 0x0

    goto/16 :goto_29

    .line 1108
    :cond_395
    move-object/from16 v0, v47

    iget v0, v0, Landroid/util/TypedValue;->data:I

    move/from16 v27, v0

    move/from16 v45, v27

    goto :goto_32f

    .line 1119
    :cond_39e
    move-object/from16 v0, v47

    iget v0, v0, Landroid/util/TypedValue;->data:I

    move/from16 v45, v0

    goto :goto_34f

    .line 1131
    :cond_3a5
    const/4 v3, 0x0

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Requires development platform "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move-object/from16 v0, v26

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " but this is a release platform."

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, p4, v3

    goto :goto_38c

    .line 1137
    :cond_3c4
    sget v3, Landroid/content/pm/PackageParser;->SDK_VERSION:I

    move/from16 v0, v27

    if-le v0, v3, :cond_3fd

    .line 1138
    const/4 v3, 0x0

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Requires newer sdk version #"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move/from16 v0, v27

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " (current version is #"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    sget v6, Landroid/content/pm/PackageParser;->SDK_VERSION:I

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ")"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, p4, v3

    .line 1140
    const/16 v3, -0xc

    move-object/from16 v0, p0

    iput v3, v0, Landroid/content/pm/PackageParser;->mParseError:I

    .line 1141
    const/4 v4, 0x0

    goto/16 :goto_29

    .line 1144
    :cond_3fd
    if-eqz v44, :cond_46a

    .line 1145
    sget-object v3, Landroid/content/pm/PackageParser;->SDK_CODENAME:Ljava/lang/String;

    move-object/from16 v0, v44

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_45f

    .line 1146
    sget-object v3, Landroid/content/pm/PackageParser;->SDK_CODENAME:Ljava/lang/String;

    if-eqz v3, :cond_440

    .line 1147
    const/4 v3, 0x0

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Requires development platform "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move-object/from16 v0, v44

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " (current platform is "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    sget-object v6, Landroid/content/pm/PackageParser;->SDK_CODENAME:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ")"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, p4, v3

    .line 1153
    :goto_437
    const/16 v3, -0xc

    move-object/from16 v0, p0

    iput v3, v0, Landroid/content/pm/PackageParser;->mParseError:I

    .line 1154
    const/4 v4, 0x0

    goto/16 :goto_29

    .line 1150
    :cond_440
    const/4 v3, 0x0

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Requires development platform "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move-object/from16 v0, v44

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " but this is a release platform."

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, p4, v3

    goto :goto_437

    .line 1157
    :cond_45f
    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    const/16 v5, 0x2710

    iput v5, v3, Landroid/content/pm/ApplicationInfo;->targetSdkVersion:I

    .line 1164
    .end local v26           #minCode:Ljava/lang/String;
    .end local v27           #minVers:I
    .end local v44           #targetCode:Ljava/lang/String;
    .end local v45           #targetVers:I
    .end local v47           #val:Landroid/util/TypedValue;
    :cond_465
    :goto_465
    invoke-static/range {p2 .. p2}, Lcom/android/internal/util/XmlUtils;->skipCurrentTag(Lorg/xmlpull/v1/XmlPullParser;)V

    goto/16 :goto_11a

    .line 1160
    .restart local v26       #minCode:Ljava/lang/String;
    .restart local v27       #minVers:I
    .restart local v44       #targetCode:Ljava/lang/String;
    .restart local v45       #targetVers:I
    .restart local v47       #val:Landroid/util/TypedValue;
    :cond_46a
    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    move/from16 v0, v45

    iput v0, v3, Landroid/content/pm/ApplicationInfo;->targetSdkVersion:I

    goto :goto_465

    .line 1166
    .end local v26           #minCode:Ljava/lang/String;
    .end local v27           #minVers:I
    .end local v44           #targetCode:Ljava/lang/String;
    .end local v45           #targetVers:I
    .end local v47           #val:Landroid/util/TypedValue;
    :cond_471
    const-string/jumbo v3, "supports-screens"

    move-object/from16 v0, v43

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4e7

    .line 1167
    sget-object v3, Lcom/android/internal/R$styleable;->AndroidManifestSupportsScreens:[I

    move-object/from16 v0, p1

    invoke-virtual {v0, v7, v3}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v36

    .line 1170
    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    const/4 v5, 0x6

    const/4 v6, 0x0

    move-object/from16 v0, v36

    invoke-virtual {v0, v5, v6}, Landroid/content/res/TypedArray;->getInteger(II)I

    move-result v5

    iput v5, v3, Landroid/content/pm/ApplicationInfo;->requiresSmallestWidthDp:I

    .line 1173
    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    const/4 v5, 0x7

    const/4 v6, 0x0

    move-object/from16 v0, v36

    invoke-virtual {v0, v5, v6}, Landroid/content/res/TypedArray;->getInteger(II)I

    move-result v5

    iput v5, v3, Landroid/content/pm/ApplicationInfo;->compatibleWidthLimitDp:I

    .line 1176
    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    const/16 v5, 0x8

    const/4 v6, 0x0

    move-object/from16 v0, v36

    invoke-virtual {v0, v5, v6}, Landroid/content/res/TypedArray;->getInteger(II)I

    move-result v5

    iput v5, v3, Landroid/content/pm/ApplicationInfo;->largestWidthLimitDp:I

    .line 1182
    const/4 v3, 0x1

    move-object/from16 v0, v36

    move/from16 v1, v41

    invoke-virtual {v0, v3, v1}, Landroid/content/res/TypedArray;->getInteger(II)I

    move-result v41

    .line 1185
    const/4 v3, 0x2

    move-object/from16 v0, v36

    move/from16 v1, v40

    invoke-virtual {v0, v3, v1}, Landroid/content/res/TypedArray;->getInteger(II)I

    move-result v40

    .line 1188
    const/4 v3, 0x3

    move-object/from16 v0, v36

    move/from16 v1, v39

    invoke-virtual {v0, v3, v1}, Landroid/content/res/TypedArray;->getInteger(II)I

    move-result v39

    .line 1191
    const/4 v3, 0x5

    move-object/from16 v0, v36

    move/from16 v1, v42

    invoke-virtual {v0, v3, v1}, Landroid/content/res/TypedArray;->getInteger(II)I

    move-result v42

    .line 1194
    const/4 v3, 0x4

    move-object/from16 v0, v36

    move/from16 v1, v35

    invoke-virtual {v0, v3, v1}, Landroid/content/res/TypedArray;->getInteger(II)I

    move-result v35

    .line 1197
    const/4 v3, 0x0

    move-object/from16 v0, v36

    move/from16 v1, v17

    invoke-virtual {v0, v3, v1}, Landroid/content/res/TypedArray;->getInteger(II)I

    move-result v17

    .line 1201
    invoke-virtual/range {v36 .. v36}, Landroid/content/res/TypedArray;->recycle()V

    .line 1203
    invoke-static/range {p2 .. p2}, Lcom/android/internal/util/XmlUtils;->skipCurrentTag(Lorg/xmlpull/v1/XmlPullParser;)V

    goto/16 :goto_11a

    .line 1205
    :cond_4e7
    const-string/jumbo v3, "protected-broadcast"

    move-object/from16 v0, v43

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_52d

    .line 1206
    sget-object v3, Lcom/android/internal/R$styleable;->AndroidManifestProtectedBroadcast:[I

    move-object/from16 v0, p1

    invoke-virtual {v0, v7, v3}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v36

    .line 1211
    const/4 v3, 0x0

    move-object/from16 v0, v36

    invoke-virtual {v0, v3}, Landroid/content/res/TypedArray;->getNonResourceString(I)Ljava/lang/String;

    move-result-object v28

    .line 1214
    .restart local v28       #name:Ljava/lang/String;
    invoke-virtual/range {v36 .. v36}, Landroid/content/res/TypedArray;->recycle()V

    .line 1216
    if-eqz v28, :cond_528

    and-int/lit8 v3, p3, 0x1

    if-eqz v3, :cond_528

    .line 1217
    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->protectedBroadcasts:Ljava/util/ArrayList;

    if-nez v3, :cond_515

    .line 1218
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    iput-object v3, v4, Landroid/content/pm/PackageParser$Package;->protectedBroadcasts:Ljava/util/ArrayList;

    .line 1220
    :cond_515
    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->protectedBroadcasts:Ljava/util/ArrayList;

    move-object/from16 v0, v28

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_528

    .line 1221
    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->protectedBroadcasts:Ljava/util/ArrayList;

    invoke-virtual/range {v28 .. v28}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1225
    :cond_528
    invoke-static/range {p2 .. p2}, Lcom/android/internal/util/XmlUtils;->skipCurrentTag(Lorg/xmlpull/v1/XmlPullParser;)V

    goto/16 :goto_11a

    .line 1227
    .end local v28           #name:Ljava/lang/String;
    :cond_52d
    const-string v3, "instrumentation"

    move-object/from16 v0, v43

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_548

    move-object/from16 v3, p0

    move-object/from16 v5, p1

    move-object/from16 v6, p2

    move-object/from16 v8, p4

    .line 1228
    invoke-direct/range {v3 .. v8}, Landroid/content/pm/PackageParser;->parseInstrumentation(Landroid/content/pm/PackageParser$Package;Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;[Ljava/lang/String;)Landroid/content/pm/PackageParser$Instrumentation;

    move-result-object v3

    if-nez v3, :cond_11a

    .line 1229
    const/4 v4, 0x0

    goto/16 :goto_29

    .line 1232
    :cond_548
    const-string/jumbo v3, "original-package"

    move-object/from16 v0, v43

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_58b

    .line 1233
    sget-object v3, Lcom/android/internal/R$styleable;->AndroidManifestOriginalPackage:[I

    move-object/from16 v0, p1

    invoke-virtual {v0, v7, v3}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v36

    .line 1236
    const/4 v3, 0x0

    const/4 v5, 0x0

    move-object/from16 v0, v36

    invoke-virtual {v0, v3, v5}, Landroid/content/res/TypedArray;->getNonConfigurationString(II)Ljava/lang/String;

    move-result-object v31

    .line 1238
    .local v31, orig:Ljava/lang/String;
    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->packageName:Ljava/lang/String;

    move-object/from16 v0, v31

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_583

    .line 1239
    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->mOriginalPackages:Ljava/util/ArrayList;

    if-nez v3, :cond_57c

    .line 1240
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    iput-object v3, v4, Landroid/content/pm/PackageParser$Package;->mOriginalPackages:Ljava/util/ArrayList;

    .line 1241
    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->packageName:Ljava/lang/String;

    iput-object v3, v4, Landroid/content/pm/PackageParser$Package;->mRealPackage:Ljava/lang/String;

    .line 1243
    :cond_57c
    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->mOriginalPackages:Ljava/util/ArrayList;

    move-object/from16 v0, v31

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1246
    :cond_583
    invoke-virtual/range {v36 .. v36}, Landroid/content/res/TypedArray;->recycle()V

    .line 1248
    invoke-static/range {p2 .. p2}, Lcom/android/internal/util/XmlUtils;->skipCurrentTag(Lorg/xmlpull/v1/XmlPullParser;)V

    goto/16 :goto_11a

    .line 1250
    .end local v31           #orig:Ljava/lang/String;
    :cond_58b
    const-string v3, "adopt-permissions"

    move-object/from16 v0, v43

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5c1

    .line 1251
    sget-object v3, Lcom/android/internal/R$styleable;->AndroidManifestOriginalPackage:[I

    move-object/from16 v0, p1

    invoke-virtual {v0, v7, v3}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v36

    .line 1254
    const/4 v3, 0x0

    const/4 v5, 0x0

    move-object/from16 v0, v36

    invoke-virtual {v0, v3, v5}, Landroid/content/res/TypedArray;->getNonConfigurationString(II)Ljava/lang/String;

    move-result-object v28

    .line 1257
    .restart local v28       #name:Ljava/lang/String;
    invoke-virtual/range {v36 .. v36}, Landroid/content/res/TypedArray;->recycle()V

    .line 1259
    if-eqz v28, :cond_5bc

    .line 1260
    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->mAdoptPermissions:Ljava/util/ArrayList;

    if-nez v3, :cond_5b5

    .line 1261
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    iput-object v3, v4, Landroid/content/pm/PackageParser$Package;->mAdoptPermissions:Ljava/util/ArrayList;

    .line 1263
    :cond_5b5
    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->mAdoptPermissions:Ljava/util/ArrayList;

    move-object/from16 v0, v28

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1266
    :cond_5bc
    invoke-static/range {p2 .. p2}, Lcom/android/internal/util/XmlUtils;->skipCurrentTag(Lorg/xmlpull/v1/XmlPullParser;)V

    goto/16 :goto_11a

    .line 1268
    .end local v28           #name:Ljava/lang/String;
    :cond_5c1
    const-string/jumbo v3, "uses-gl-texture"

    move-object/from16 v0, v43

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5d1

    .line 1270
    invoke-static/range {p2 .. p2}, Lcom/android/internal/util/XmlUtils;->skipCurrentTag(Lorg/xmlpull/v1/XmlPullParser;)V

    goto/16 :goto_11a

    .line 1273
    :cond_5d1
    const-string v3, "compatible-screens"

    move-object/from16 v0, v43

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5e0

    .line 1275
    invoke-static/range {p2 .. p2}, Lcom/android/internal/util/XmlUtils;->skipCurrentTag(Lorg/xmlpull/v1/XmlPullParser;)V

    goto/16 :goto_11a

    .line 1278
    :cond_5e0
    const-string v3, "eat-comment"

    move-object/from16 v0, v43

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5ef

    .line 1280
    invoke-static/range {p2 .. p2}, Lcom/android/internal/util/XmlUtils;->skipCurrentTag(Lorg/xmlpull/v1/XmlPullParser;)V

    goto/16 :goto_11a

    .line 1290
    :cond_5ef
    const-string v3, "PackageParser"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Unknown element under <manifest>: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-interface/range {p2 .. p2}, Landroid/content/res/XmlResourceParser;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " at "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move-object/from16 v0, p0

    iget-object v6, v0, Landroid/content/pm/PackageParser;->mArchiveSourcePath:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-interface/range {p2 .. p2}, Landroid/content/res/XmlResourceParser;->getPositionDescription()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v3, v5}, Landroid/util/Slog;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 1293
    invoke-static/range {p2 .. p2}, Lcom/android/internal/util/XmlUtils;->skipCurrentTag(Lorg/xmlpull/v1/XmlPullParser;)V

    goto/16 :goto_11a

    .line 1298
    .end local v43           #tagName:Ljava/lang/String;
    :cond_62c
    if-nez v21, :cond_641

    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->instrumentation:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-nez v3, :cond_641

    .line 1299
    const/4 v3, 0x0

    const-string v5, "<manifest> does not contain an <application> or <instrumentation>"

    aput-object v5, p4, v3

    .line 1300
    const/16 v3, -0x6d

    move-object/from16 v0, p0

    iput v3, v0, Landroid/content/pm/PackageParser;->mParseError:I

    .line 1303
    :cond_641
    sget-object v3, Landroid/content/pm/PackageParser;->NEW_PERMISSIONS:[Landroid/content/pm/PackageParser$NewPermissionInfo;

    array-length v15, v3

    .line 1304
    .local v15, NP:I
    const/16 v22, 0x0

    .line 1305
    .local v22, implicitPerms:Ljava/lang/StringBuilder;
    const/16 v24, 0x0

    .local v24, ip:I
    :goto_648
    move/from16 v0, v24

    if-ge v0, v15, :cond_65a

    .line 1306
    sget-object v3, Landroid/content/pm/PackageParser;->NEW_PERMISSIONS:[Landroid/content/pm/PackageParser$NewPermissionInfo;

    aget-object v30, v3, v24

    .line 1308
    .local v30, npi:Landroid/content/pm/PackageParser$NewPermissionInfo;
    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget v3, v3, Landroid/content/pm/ApplicationInfo;->targetSdkVersion:I

    move-object/from16 v0, v30

    iget v5, v0, Landroid/content/pm/PackageParser$NewPermissionInfo;->sdkVersion:I

    if-lt v3, v5, :cond_68f

    .line 1324
    .end local v30           #npi:Landroid/content/pm/PackageParser$NewPermissionInfo;
    :cond_65a
    if-eqz v22, :cond_665

    .line 1325
    const-string v3, "PackageParser"

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v3, v5}, Landroid/util/Slog;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 1328
    :cond_665
    sget-object v3, Landroid/content/pm/PackageParser;->SPLIT_PERMISSIONS:[Landroid/content/pm/PackageParser$SplitPermissionInfo;

    array-length v0, v3

    move/from16 v16, v0

    .line 1329
    .local v16, NS:I
    const/16 v25, 0x0

    .local v25, is:I
    :goto_66c
    move/from16 v0, v25

    move/from16 v1, v16

    if-ge v0, v1, :cond_705

    .line 1330
    sget-object v3, Landroid/content/pm/PackageParser;->SPLIT_PERMISSIONS:[Landroid/content/pm/PackageParser$SplitPermissionInfo;

    aget-object v37, v3, v25

    .line 1332
    .local v37, spi:Landroid/content/pm/PackageParser$SplitPermissionInfo;
    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget v3, v3, Landroid/content/pm/ApplicationInfo;->targetSdkVersion:I

    move-object/from16 v0, v37

    iget v5, v0, Landroid/content/pm/PackageParser$SplitPermissionInfo;->targetSdk:I

    if-ge v3, v5, :cond_68c

    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->requestedPermissions:Ljava/util/ArrayList;

    move-object/from16 v0, v37

    iget-object v5, v0, Landroid/content/pm/PackageParser$SplitPermissionInfo;->rootPerm:Ljava/lang/String;

    invoke-virtual {v3, v5}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_6d9

    .line 1329
    :cond_68c
    add-int/lit8 v25, v25, 0x1

    goto :goto_66c

    .line 1311
    .end local v16           #NS:I
    .end local v25           #is:I
    .end local v37           #spi:Landroid/content/pm/PackageParser$SplitPermissionInfo;
    .restart local v30       #npi:Landroid/content/pm/PackageParser$NewPermissionInfo;
    :cond_68f
    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->requestedPermissions:Ljava/util/ArrayList;

    move-object/from16 v0, v30

    iget-object v5, v0, Landroid/content/pm/PackageParser$NewPermissionInfo;->name:Ljava/lang/String;

    invoke-virtual {v3, v5}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_6cd

    .line 1312
    if-nez v22, :cond_6d1

    .line 1313
    new-instance v22, Ljava/lang/StringBuilder;

    .end local v22           #implicitPerms:Ljava/lang/StringBuilder;
    const/16 v3, 0x80

    move-object/from16 v0, v22

    invoke-direct {v0, v3}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 1314
    .restart local v22       #implicitPerms:Ljava/lang/StringBuilder;
    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->packageName:Ljava/lang/String;

    move-object/from16 v0, v22

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1315
    const-string v3, ": compat added "

    move-object/from16 v0, v22

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1319
    :goto_6b4
    move-object/from16 v0, v30

    iget-object v3, v0, Landroid/content/pm/PackageParser$NewPermissionInfo;->name:Ljava/lang/String;

    move-object/from16 v0, v22

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1320
    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->requestedPermissions:Ljava/util/ArrayList;

    move-object/from16 v0, v30

    iget-object v5, v0, Landroid/content/pm/PackageParser$NewPermissionInfo;->name:Ljava/lang/String;

    invoke-virtual {v3, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1321
    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->requestedPermissionsRequired:Ljava/util/ArrayList;

    sget-object v5, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v3, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1305
    :cond_6cd
    add-int/lit8 v24, v24, 0x1

    goto/16 :goto_648

    .line 1317
    :cond_6d1
    const/16 v3, 0x20

    move-object/from16 v0, v22

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_6b4

    .line 1336
    .end local v30           #npi:Landroid/content/pm/PackageParser$NewPermissionInfo;
    .restart local v16       #NS:I
    .restart local v25       #is:I
    .restart local v37       #spi:Landroid/content/pm/PackageParser$SplitPermissionInfo;
    :cond_6d9
    const/16 v23, 0x0

    .local v23, in:I
    :goto_6db
    move-object/from16 v0, v37

    iget-object v3, v0, Landroid/content/pm/PackageParser$SplitPermissionInfo;->newPerms:[Ljava/lang/String;

    array-length v3, v3

    move/from16 v0, v23

    if-ge v0, v3, :cond_68c

    .line 1337
    move-object/from16 v0, v37

    iget-object v3, v0, Landroid/content/pm/PackageParser$SplitPermissionInfo;->newPerms:[Ljava/lang/String;

    aget-object v33, v3, v23

    .line 1338
    .local v33, perm:Ljava/lang/String;
    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->requestedPermissions:Ljava/util/ArrayList;

    move-object/from16 v0, v33

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_702

    .line 1339
    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->requestedPermissions:Ljava/util/ArrayList;

    move-object/from16 v0, v33

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1340
    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->requestedPermissionsRequired:Ljava/util/ArrayList;

    sget-object v5, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v3, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1336
    :cond_702
    add-int/lit8 v23, v23, 0x1

    goto :goto_6db

    .line 1345
    .end local v23           #in:I
    .end local v33           #perm:Ljava/lang/String;
    .end local v37           #spi:Landroid/content/pm/PackageParser$SplitPermissionInfo;
    :cond_705
    if-ltz v41, :cond_710

    if-lez v41, :cond_718

    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget v3, v3, Landroid/content/pm/ApplicationInfo;->targetSdkVersion:I

    const/4 v5, 0x4

    if-lt v3, v5, :cond_718

    .line 1348
    :cond_710
    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget v5, v3, Landroid/content/pm/ApplicationInfo;->flags:I

    or-int/lit16 v5, v5, 0x200

    iput v5, v3, Landroid/content/pm/ApplicationInfo;->flags:I

    .line 1350
    :cond_718
    if-eqz v40, :cond_722

    .line 1351
    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget v5, v3, Landroid/content/pm/ApplicationInfo;->flags:I

    or-int/lit16 v5, v5, 0x400

    iput v5, v3, Landroid/content/pm/ApplicationInfo;->flags:I

    .line 1353
    :cond_722
    if-ltz v39, :cond_72d

    if-lez v39, :cond_735

    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget v3, v3, Landroid/content/pm/ApplicationInfo;->targetSdkVersion:I

    const/4 v5, 0x4

    if-lt v3, v5, :cond_735

    .line 1356
    :cond_72d
    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget v5, v3, Landroid/content/pm/ApplicationInfo;->flags:I

    or-int/lit16 v5, v5, 0x800

    iput v5, v3, Landroid/content/pm/ApplicationInfo;->flags:I

    .line 1358
    :cond_735
    if-ltz v42, :cond_741

    if-lez v42, :cond_74a

    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget v3, v3, Landroid/content/pm/ApplicationInfo;->targetSdkVersion:I

    const/16 v5, 0x9

    if-lt v3, v5, :cond_74a

    .line 1361
    :cond_741
    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget v5, v3, Landroid/content/pm/ApplicationInfo;->flags:I

    const/high16 v6, 0x8

    or-int/2addr v5, v6

    iput v5, v3, Landroid/content/pm/ApplicationInfo;->flags:I

    .line 1363
    :cond_74a
    if-ltz v35, :cond_755

    if-lez v35, :cond_75d

    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget v3, v3, Landroid/content/pm/ApplicationInfo;->targetSdkVersion:I

    const/4 v5, 0x4

    if-lt v3, v5, :cond_75d

    .line 1366
    :cond_755
    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget v5, v3, Landroid/content/pm/ApplicationInfo;->flags:I

    or-int/lit16 v5, v5, 0x1000

    iput v5, v3, Landroid/content/pm/ApplicationInfo;->flags:I

    .line 1368
    :cond_75d
    if-ltz v17, :cond_768

    if-lez v17, :cond_29

    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget v3, v3, Landroid/content/pm/ApplicationInfo;->targetSdkVersion:I

    const/4 v5, 0x4

    if-lt v3, v5, :cond_29

    .line 1371
    :cond_768
    iget-object v3, v4, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget v5, v3, Landroid/content/pm/ApplicationInfo;->flags:I

    or-int/lit16 v5, v5, 0x2000

    iput v5, v3, Landroid/content/pm/ApplicationInfo;->flags:I

    goto/16 :goto_29
.end method

.method private parsePackageItemInfo(Landroid/content/pm/PackageParser$Package;Landroid/content/pm/PackageItemInfo;[Ljava/lang/String;Ljava/lang/String;Landroid/content/res/TypedArray;IIII)Z
    .registers 18
    .parameter "owner"
    .parameter "outInfo"
    .parameter "outError"
    .parameter "tag"
    .parameter "sa"
    .parameter "nameRes"
    .parameter "labelRes"
    .parameter "iconRes"
    .parameter "logoRes"

    .prologue
    .line 1992
    const/4 v5, 0x0

    invoke-virtual {p5, p6, v5}, Landroid/content/res/TypedArray;->getNonConfigurationString(II)Ljava/lang/String;

    move-result-object v3

    .line 1993
    .local v3, name:Ljava/lang/String;
    if-nez v3, :cond_1f

    .line 1994
    const/4 v5, 0x0

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " does not specify android:name"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    aput-object v6, p3, v5

    .line 1995
    const/4 v5, 0x0

    .line 2022
    :goto_1e
    return v5

    .line 1998
    :cond_1f
    iget-object v5, p1, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget-object v5, v5, Landroid/content/pm/PackageItemInfo;->packageName:Ljava/lang/String;

    invoke-static {v5, v3, p3}, Landroid/content/pm/PackageParser;->buildClassName(Ljava/lang/String;Ljava/lang/CharSequence;[Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, p2, Landroid/content/pm/PackageItemInfo;->name:Ljava/lang/String;

    .line 2000
    iget-object v5, p2, Landroid/content/pm/PackageItemInfo;->name:Ljava/lang/String;

    if-nez v5, :cond_2f

    .line 2001
    const/4 v5, 0x0

    goto :goto_1e

    .line 2004
    :cond_2f
    const/4 v5, 0x0

    move/from16 v0, p8

    invoke-virtual {p5, v0, v5}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v1

    .line 2005
    .local v1, iconVal:I
    if-eqz v1, :cond_3d

    .line 2006
    iput v1, p2, Landroid/content/pm/PackageItemInfo;->icon:I

    .line 2007
    const/4 v5, 0x0

    iput-object v5, p2, Landroid/content/pm/PackageItemInfo;->nonLocalizedLabel:Ljava/lang/CharSequence;

    .line 2010
    :cond_3d
    const/4 v5, 0x0

    move/from16 v0, p9

    invoke-virtual {p5, v0, v5}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v2

    .line 2011
    .local v2, logoVal:I
    if-eqz v2, :cond_48

    .line 2012
    iput v2, p2, Landroid/content/pm/PackageItemInfo;->logo:I

    .line 2015
    :cond_48
    invoke-virtual {p5, p7}, Landroid/content/res/TypedArray;->peekValue(I)Landroid/util/TypedValue;

    move-result-object v4

    .line 2016
    .local v4, v:Landroid/util/TypedValue;
    if-eqz v4, :cond_5a

    iget v5, v4, Landroid/util/TypedValue;->resourceId:I

    iput v5, p2, Landroid/content/pm/PackageItemInfo;->labelRes:I

    if-nez v5, :cond_5a

    .line 2017
    invoke-virtual {v4}, Landroid/util/TypedValue;->coerceToString()Ljava/lang/CharSequence;

    move-result-object v5

    iput-object v5, p2, Landroid/content/pm/PackageItemInfo;->nonLocalizedLabel:Ljava/lang/CharSequence;

    .line 2020
    :cond_5a
    iget-object v5, p1, Landroid/content/pm/PackageParser$Package;->packageName:Ljava/lang/String;

    iput-object v5, p2, Landroid/content/pm/PackageItemInfo;->packageName:Ljava/lang/String;

    .line 2022
    const/4 v5, 0x1

    goto :goto_1e
.end method

.method private static parsePackageLite(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;I[Ljava/lang/String;)Landroid/content/pm/PackageParser$PackageLite;
    .registers 17
    .parameter "res"
    .parameter "parser"
    .parameter "attrs"
    .parameter "flags"
    .parameter "outError"
    .annotation build Landroid/annotation/MiuiHook;
        value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->CHANGE_CODE:Landroid/annotation/MiuiHook$MiuiHookType;
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lorg/xmlpull/v1/XmlPullParserException;
        }
    .end annotation

    .prologue
    .line 827
    :cond_0
    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v6

    .local v6, type:I
    const/4 v9, 0x2

    if-eq v6, v9, :cond_a

    const/4 v9, 0x1

    if-ne v6, v9, :cond_0

    .line 831
    :cond_a
    const/4 v9, 0x2

    if-eq v6, v9, :cond_14

    .line 832
    const/4 v9, 0x0

    const-string v10, "No start tag found"

    aput-object v10, p4, v9

    .line 833
    const/4 v9, 0x0

    .line 880
    :goto_13
    return-object v9

    .line 837
    :cond_14
    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v9

    const-string/jumbo v10, "manifest"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_28

    .line 838
    const/4 v9, 0x0

    const-string v10, "No <manifest> tag"

    aput-object v10, p4, v9

    .line 839
    const/4 v9, 0x0

    goto :goto_13

    .line 841
    :cond_28
    const/4 v9, 0x0

    const-string/jumbo v10, "package"

    invoke-interface {p2, v9, v10}, Landroid/util/AttributeSet;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 842
    .local v4, pkgName:Ljava/lang/String;
    if-eqz v4, :cond_38

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v9

    if-nez v9, :cond_3f

    .line 843
    :cond_38
    const/4 v9, 0x0

    const-string v10, "<manifest> does not specify package"

    aput-object v10, p4, v9

    .line 844
    const/4 v9, 0x0

    goto :goto_13

    .line 846
    :cond_3f
    const/4 v9, 0x1

    invoke-static {v4, v9}, Landroid/content/pm/PackageParser;->validateName(Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v3

    .line 847
    .local v3, nameError:Ljava/lang/String;
    if-eqz v3, :cond_79

    const-string v9, "android"

    invoke-virtual {v9, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_79

    const-string/jumbo v9, "miui"

    invoke-virtual {v9, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_79

    .line 848
    const/4 v9, 0x0

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "<manifest> specifies bad package name \""

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, "\": "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    aput-object v10, p4, v9

    .line 850
    const/4 v9, 0x0

    goto :goto_13

    .line 852
    :cond_79
    const/4 v2, -0x1

    .line 853
    .local v2, installLocation:I
    const/4 v1, 0x0

    .local v1, i:I
    :goto_7b
    invoke-interface {p2}, Landroid/util/AttributeSet;->getAttributeCount()I

    move-result v9

    if-ge v1, v9, :cond_92

    .line 854
    invoke-interface {p2, v1}, Landroid/util/AttributeSet;->getAttributeName(I)Ljava/lang/String;

    move-result-object v0

    .line 855
    .local v0, attr:Ljava/lang/String;
    const-string v9, "installLocation"

    invoke-virtual {v0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_d0

    .line 856
    const/4 v9, -0x1

    invoke-interface {p2, v1, v9}, Landroid/util/AttributeSet;->getAttributeIntValue(II)I

    move-result v2

    .line 863
    .end local v0           #attr:Ljava/lang/String;
    :cond_92
    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v9

    add-int/lit8 v5, v9, 0x1

    .line 865
    .local v5, searchDepth:I
    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    .line 867
    .local v8, verifiers:Ljava/util/List;,"Ljava/util/List<Landroid/content/pm/VerifierInfo;>;"
    :cond_9d
    :goto_9d
    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v6

    const/4 v9, 0x1

    if-eq v6, v9, :cond_d3

    const/4 v9, 0x3

    if-ne v6, v9, :cond_ad

    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v9

    if-lt v9, v5, :cond_d3

    .line 868
    :cond_ad
    const/4 v9, 0x3

    if-eq v6, v9, :cond_9d

    const/4 v9, 0x4

    if-eq v6, v9, :cond_9d

    .line 872
    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v9

    if-ne v9, v5, :cond_9d

    const-string/jumbo v9, "package-verifier"

    invoke-interface {p1}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_9d

    .line 873
    invoke-static/range {p0 .. p4}, Landroid/content/pm/PackageParser;->parseVerifier(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;I[Ljava/lang/String;)Landroid/content/pm/VerifierInfo;

    move-result-object v7

    .line 874
    .local v7, verifier:Landroid/content/pm/VerifierInfo;
    if-eqz v7, :cond_9d

    .line 875
    invoke-interface {v8, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_9d

    .line 853
    .end local v5           #searchDepth:I
    .end local v7           #verifier:Landroid/content/pm/VerifierInfo;
    .end local v8           #verifiers:Ljava/util/List;,"Ljava/util/List<Landroid/content/pm/VerifierInfo;>;"
    .restart local v0       #attr:Ljava/lang/String;
    :cond_d0
    add-int/lit8 v1, v1, 0x1

    goto :goto_7b

    .line 880
    .end local v0           #attr:Ljava/lang/String;
    .restart local v5       #searchDepth:I
    .restart local v8       #verifiers:Ljava/util/List;,"Ljava/util/List<Landroid/content/pm/VerifierInfo;>;"
    :cond_d3
    new-instance v9, Landroid/content/pm/PackageParser$PackageLite;

    invoke-virtual {v4}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10, v2, v8}, Landroid/content/pm/PackageParser$PackageLite;-><init>(Ljava/lang/String;ILjava/util/List;)V

    goto/16 :goto_13
.end method

.method public static parsePackageLite(Ljava/lang/String;I)Landroid/content/pm/PackageParser$PackageLite;
    .registers 34
    .parameter "packageFilePath"
    .parameter "flags"

    .prologue
    .line 714
    const/16 v23, 0x0

    .line 718
    .local v23, assmgr:Landroid/content/res/AssetManager;
    :try_start_2
    new-instance v5, Landroid/content/res/AssetManager;

    invoke-direct {v5}, Landroid/content/res/AssetManager;-><init>()V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_7} :catch_89

    .line 719
    .end local v23           #assmgr:Landroid/content/res/AssetManager;
    .local v5, assmgr:Landroid/content/res/AssetManager;
    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    const/4 v12, 0x0

    const/4 v13, 0x0

    const/4 v14, 0x0

    const/4 v15, 0x0

    const/16 v16, 0x0

    const/16 v17, 0x0

    const/16 v18, 0x0

    const/16 v19, 0x0

    const/16 v20, 0x0

    const/16 v21, 0x0

    :try_start_1d
    sget v22, Landroid/os/Build$VERSION;->RESOURCES_SDK_INT:I

    invoke-virtual/range {v5 .. v22}, Landroid/content/res/AssetManager;->setConfiguration(IILjava/lang/String;IIIIIIIIIIIIII)V

    .line 722
    move-object/from16 v0, p0

    invoke-virtual {v5, v0}, Landroid/content/res/AssetManager;->addAssetPath(Ljava/lang/String;)I

    move-result v25

    .line 723
    .local v25, cookie:I
    if-nez v25, :cond_2d

    .line 724
    const/16 v29, 0x0

    .line 755
    .end local v25           #cookie:I
    :cond_2c
    :goto_2c
    return-object v29

    .line 727
    .restart local v25       #cookie:I
    :cond_2d
    new-instance v28, Landroid/util/DisplayMetrics;

    invoke-direct/range {v28 .. v28}, Landroid/util/DisplayMetrics;-><init>()V

    .line 728
    .local v28, metrics:Landroid/util/DisplayMetrics;
    invoke-virtual/range {v28 .. v28}, Landroid/util/DisplayMetrics;->setToDefaults()V

    .line 729
    new-instance v31, Landroid/content/res/Resources;

    const/4 v6, 0x0

    move-object/from16 v0, v31

    move-object/from16 v1, v28

    invoke-direct {v0, v5, v1, v6}, Landroid/content/res/Resources;-><init>(Landroid/content/res/AssetManager;Landroid/util/DisplayMetrics;Landroid/content/res/Configuration;)V

    .line 730
    .local v31, res:Landroid/content/res/Resources;
    const-string v6, "AndroidManifest.xml"

    move/from16 v0, v25

    invoke-virtual {v5, v0, v6}, Landroid/content/res/AssetManager;->openXmlResourceParser(ILjava/lang/String;)Landroid/content/res/XmlResourceParser;
    :try_end_46
    .catch Ljava/lang/Exception; {:try_start_1d .. :try_end_46} :catch_e7

    move-result-object v30

    .line 738
    .local v30, parser:Landroid/content/res/XmlResourceParser;
    move-object/from16 v24, v30

    .line 739
    .local v24, attrs:Landroid/util/AttributeSet;
    const/4 v6, 0x1

    new-array v0, v6, [Ljava/lang/String;

    move-object/from16 v27, v0

    .line 740
    .local v27, errors:[Ljava/lang/String;
    const/16 v29, 0x0

    .line 742
    .local v29, packageLite:Landroid/content/pm/PackageParser$PackageLite;
    :try_start_50
    move-object/from16 v0, v31

    move-object/from16 v1, v30

    move-object/from16 v2, v24

    move/from16 v3, p1

    move-object/from16 v4, v27

    invoke-static {v0, v1, v2, v3, v4}, Landroid/content/pm/PackageParser;->parsePackageLite(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;I[Ljava/lang/String;)Landroid/content/pm/PackageParser$PackageLite;
    :try_end_5d
    .catchall {:try_start_50 .. :try_end_5d} :catchall_db
    .catch Ljava/io/IOException; {:try_start_50 .. :try_end_5d} :catch_b1
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_50 .. :try_end_5d} :catch_c6

    move-result-object v29

    .line 748
    if-eqz v30, :cond_63

    invoke-interface/range {v30 .. v30}, Landroid/content/res/XmlResourceParser;->close()V

    .line 749
    :cond_63
    if-eqz v5, :cond_68

    invoke-virtual {v5}, Landroid/content/res/AssetManager;->close()V

    .line 751
    :cond_68
    :goto_68
    if-nez v29, :cond_2c

    .line 752
    const-string v6, "PackageParser"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "parsePackageLite error: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const/4 v8, 0x0

    aget-object v8, v27, v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Slog;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 753
    const/16 v29, 0x0

    goto :goto_2c

    .line 731
    .end local v5           #assmgr:Landroid/content/res/AssetManager;
    .end local v24           #attrs:Landroid/util/AttributeSet;
    .end local v25           #cookie:I
    .end local v27           #errors:[Ljava/lang/String;
    .end local v28           #metrics:Landroid/util/DisplayMetrics;
    .end local v29           #packageLite:Landroid/content/pm/PackageParser$PackageLite;
    .end local v30           #parser:Landroid/content/res/XmlResourceParser;
    .end local v31           #res:Landroid/content/res/Resources;
    .restart local v23       #assmgr:Landroid/content/res/AssetManager;
    :catch_89
    move-exception v26

    move-object/from16 v5, v23

    .line 732
    .end local v23           #assmgr:Landroid/content/res/AssetManager;
    .restart local v5       #assmgr:Landroid/content/res/AssetManager;
    .local v26, e:Ljava/lang/Exception;
    :goto_8c
    if-eqz v5, :cond_91

    invoke-virtual {v5}, Landroid/content/res/AssetManager;->close()V

    .line 733
    :cond_91
    const-string v6, "PackageParser"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Unable to read AndroidManifest.xml of "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    move-object/from16 v0, p0

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    move-object/from16 v0, v26

    invoke-static {v6, v7, v0}, Landroid/util/Slog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 735
    const/16 v29, 0x0

    goto/16 :goto_2c

    .line 743
    .end local v26           #e:Ljava/lang/Exception;
    .restart local v24       #attrs:Landroid/util/AttributeSet;
    .restart local v25       #cookie:I
    .restart local v27       #errors:[Ljava/lang/String;
    .restart local v28       #metrics:Landroid/util/DisplayMetrics;
    .restart local v29       #packageLite:Landroid/content/pm/PackageParser$PackageLite;
    .restart local v30       #parser:Landroid/content/res/XmlResourceParser;
    .restart local v31       #res:Landroid/content/res/Resources;
    :catch_b1
    move-exception v26

    .line 744
    .local v26, e:Ljava/io/IOException;
    :try_start_b2
    const-string v6, "PackageParser"

    move-object/from16 v0, p0

    move-object/from16 v1, v26

    invoke-static {v6, v0, v1}, Landroid/util/Slog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_bb
    .catchall {:try_start_b2 .. :try_end_bb} :catchall_db

    .line 748
    if-eqz v30, :cond_c0

    invoke-interface/range {v30 .. v30}, Landroid/content/res/XmlResourceParser;->close()V

    .line 749
    :cond_c0
    if-eqz v5, :cond_68

    invoke-virtual {v5}, Landroid/content/res/AssetManager;->close()V

    goto :goto_68

    .line 745
    .end local v26           #e:Ljava/io/IOException;
    :catch_c6
    move-exception v26

    .line 746
    .local v26, e:Lorg/xmlpull/v1/XmlPullParserException;
    :try_start_c7
    const-string v6, "PackageParser"

    move-object/from16 v0, p0

    move-object/from16 v1, v26

    invoke-static {v6, v0, v1}, Landroid/util/Slog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_d0
    .catchall {:try_start_c7 .. :try_end_d0} :catchall_db

    .line 748
    if-eqz v30, :cond_d5

    invoke-interface/range {v30 .. v30}, Landroid/content/res/XmlResourceParser;->close()V

    .line 749
    :cond_d5
    if-eqz v5, :cond_68

    invoke-virtual {v5}, Landroid/content/res/AssetManager;->close()V

    goto :goto_68

    .line 748
    .end local v26           #e:Lorg/xmlpull/v1/XmlPullParserException;
    :catchall_db
    move-exception v6

    if-eqz v30, :cond_e1

    invoke-interface/range {v30 .. v30}, Landroid/content/res/XmlResourceParser;->close()V

    .line 749
    :cond_e1
    if-eqz v5, :cond_e6

    invoke-virtual {v5}, Landroid/content/res/AssetManager;->close()V

    :cond_e6
    throw v6

    .line 731
    .end local v24           #attrs:Landroid/util/AttributeSet;
    .end local v25           #cookie:I
    .end local v27           #errors:[Ljava/lang/String;
    .end local v28           #metrics:Landroid/util/DisplayMetrics;
    .end local v29           #packageLite:Landroid/content/pm/PackageParser$PackageLite;
    .end local v30           #parser:Landroid/content/res/XmlResourceParser;
    .end local v31           #res:Landroid/content/res/Resources;
    :catch_e7
    move-exception v26

    goto :goto_8c
.end method

.method private static parsePackageName(Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;I[Ljava/lang/String;)Ljava/lang/String;
    .registers 12
    .parameter "parser"
    .parameter "attrs"
    .parameter "flags"
    .parameter "outError"
    .annotation build Landroid/annotation/MiuiHook;
        value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->CHANGE_CODE:Landroid/annotation/MiuiHook$MiuiHookType;
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lorg/xmlpull/v1/XmlPullParserException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x2

    const/4 v7, 0x1

    const/4 v6, 0x0

    const/4 v3, 0x0

    .line 791
    :cond_4
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v2

    .local v2, type:I
    if-eq v2, v4, :cond_c

    if-ne v2, v7, :cond_4

    .line 795
    :cond_c
    if-eq v2, v4, :cond_13

    .line 796
    const-string v4, "No start tag found"

    aput-object v4, p3, v6

    .line 817
    :goto_12
    return-object v3

    .line 801
    :cond_13
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v4

    const-string/jumbo v5, "manifest"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_25

    .line 802
    const-string v4, "No <manifest> tag"

    aput-object v4, p3, v6

    goto :goto_12

    .line 805
    :cond_25
    const-string/jumbo v4, "package"

    invoke-interface {p1, v3, v4}, Landroid/util/AttributeSet;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 806
    .local v1, pkgName:Ljava/lang/String;
    if-eqz v1, :cond_34

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v4

    if-nez v4, :cond_39

    .line 807
    :cond_34
    const-string v4, "<manifest> does not specify package"

    aput-object v4, p3, v6

    goto :goto_12

    .line 810
    :cond_39
    invoke-static {v1, v7}, Landroid/content/pm/PackageParser;->validateName(Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    .line 811
    .local v0, nameError:Ljava/lang/String;
    if-eqz v0, :cond_70

    const-string v4, "android"

    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_70

    const-string/jumbo v4, "miui"

    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_70

    .line 812
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "<manifest> specifies bad package name \""

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\": "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, p3, v6

    goto :goto_12

    .line 817
    :cond_70
    invoke-virtual {v1}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v3

    goto :goto_12
.end method

.method private parsePermission(Landroid/content/pm/PackageParser$Package;Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;[Ljava/lang/String;)Landroid/content/pm/PackageParser$Permission;
    .registers 21
    .parameter "owner"
    .parameter "res"
    .parameter "parser"
    .parameter "attrs"
    .parameter "outError"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1505
    new-instance v13, Landroid/content/pm/PackageParser$Permission;

    move-object/from16 v0, p1

    invoke-direct {v13, v0}, Landroid/content/pm/PackageParser$Permission;-><init>(Landroid/content/pm/PackageParser$Package;)V

    .line 1507
    .local v13, perm:Landroid/content/pm/PackageParser$Permission;
    sget-object v2, Lcom/android/internal/R$styleable;->AndroidManifestPermission:[I

    move-object/from16 v0, p2

    move-object/from16 v1, p4

    invoke-virtual {v0, v1, v2}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v7

    .line 1510
    .local v7, sa:Landroid/content/res/TypedArray;
    iget-object v4, v13, Landroid/content/pm/PackageParser$Permission;->info:Landroid/content/pm/PermissionInfo;

    const-string v6, "<permission>"

    const/4 v8, 0x2

    const/4 v9, 0x0

    const/4 v10, 0x1

    const/4 v11, 0x6

    move-object v2, p0

    move-object/from16 v3, p1

    move-object/from16 v5, p5

    invoke-direct/range {v2 .. v11}, Landroid/content/pm/PackageParser;->parsePackageItemInfo(Landroid/content/pm/PackageParser$Package;Landroid/content/pm/PackageItemInfo;[Ljava/lang/String;Ljava/lang/String;Landroid/content/res/TypedArray;IIII)Z

    move-result v2

    if-nez v2, :cond_2d

    .line 1516
    invoke-virtual {v7}, Landroid/content/res/TypedArray;->recycle()V

    .line 1517
    const/16 v2, -0x6c

    iput v2, p0, Landroid/content/pm/PackageParser;->mParseError:I

    .line 1518
    const/4 v13, 0x0

    .line 1565
    .end local v13           #perm:Landroid/content/pm/PackageParser$Permission;
    :goto_2c
    return-object v13

    .line 1523
    .restart local v13       #perm:Landroid/content/pm/PackageParser$Permission;
    :cond_2d
    iget-object v2, v13, Landroid/content/pm/PackageParser$Permission;->info:Landroid/content/pm/PermissionInfo;

    const/4 v3, 0x4

    invoke-virtual {v7, v3}, Landroid/content/res/TypedArray;->getNonResourceString(I)Ljava/lang/String;

    move-result-object v3

    iput-object v3, v2, Landroid/content/pm/PermissionInfo;->group:Ljava/lang/String;

    .line 1525
    iget-object v2, v13, Landroid/content/pm/PackageParser$Permission;->info:Landroid/content/pm/PermissionInfo;

    iget-object v2, v2, Landroid/content/pm/PermissionInfo;->group:Ljava/lang/String;

    if-eqz v2, :cond_48

    .line 1526
    iget-object v2, v13, Landroid/content/pm/PackageParser$Permission;->info:Landroid/content/pm/PermissionInfo;

    iget-object v3, v13, Landroid/content/pm/PackageParser$Permission;->info:Landroid/content/pm/PermissionInfo;

    iget-object v3, v3, Landroid/content/pm/PermissionInfo;->group:Ljava/lang/String;

    invoke-virtual {v3}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v3

    iput-object v3, v2, Landroid/content/pm/PermissionInfo;->group:Ljava/lang/String;

    .line 1529
    :cond_48
    iget-object v2, v13, Landroid/content/pm/PackageParser$Permission;->info:Landroid/content/pm/PermissionInfo;

    const/4 v3, 0x5

    const/4 v4, 0x0

    invoke-virtual {v7, v3, v4}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v3

    iput v3, v2, Landroid/content/pm/PermissionInfo;->descriptionRes:I

    .line 1533
    iget-object v2, v13, Landroid/content/pm/PackageParser$Permission;->info:Landroid/content/pm/PermissionInfo;

    const/4 v3, 0x3

    const/4 v4, 0x0

    invoke-virtual {v7, v3, v4}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v3

    iput v3, v2, Landroid/content/pm/PermissionInfo;->protectionLevel:I

    .line 1537
    invoke-virtual {v7}, Landroid/content/res/TypedArray;->recycle()V

    .line 1539
    iget-object v2, v13, Landroid/content/pm/PackageParser$Permission;->info:Landroid/content/pm/PermissionInfo;

    iget v2, v2, Landroid/content/pm/PermissionInfo;->protectionLevel:I

    const/4 v3, -0x1

    if-ne v2, v3, :cond_71

    .line 1540
    const/4 v2, 0x0

    const-string v3, "<permission> does not specify protectionLevel"

    aput-object v3, p5, v2

    .line 1541
    const/16 v2, -0x6c

    iput v2, p0, Landroid/content/pm/PackageParser;->mParseError:I

    .line 1542
    const/4 v13, 0x0

    goto :goto_2c

    .line 1545
    :cond_71
    iget-object v2, v13, Landroid/content/pm/PackageParser$Permission;->info:Landroid/content/pm/PermissionInfo;

    iget-object v3, v13, Landroid/content/pm/PackageParser$Permission;->info:Landroid/content/pm/PermissionInfo;

    iget v3, v3, Landroid/content/pm/PermissionInfo;->protectionLevel:I

    invoke-static {v3}, Landroid/content/pm/PermissionInfo;->fixProtectionLevel(I)I

    move-result v3

    iput v3, v2, Landroid/content/pm/PermissionInfo;->protectionLevel:I

    .line 1547
    iget-object v2, v13, Landroid/content/pm/PackageParser$Permission;->info:Landroid/content/pm/PermissionInfo;

    iget v2, v2, Landroid/content/pm/PermissionInfo;->protectionLevel:I

    and-int/lit16 v2, v2, 0xf0

    if-eqz v2, :cond_99

    .line 1548
    iget-object v2, v13, Landroid/content/pm/PackageParser$Permission;->info:Landroid/content/pm/PermissionInfo;

    iget v2, v2, Landroid/content/pm/PermissionInfo;->protectionLevel:I

    and-int/lit8 v2, v2, 0xf

    const/4 v3, 0x2

    if-eq v2, v3, :cond_99

    .line 1550
    const/4 v2, 0x0

    const-string v3, "<permission>  protectionLevel specifies a flag but is not based on signature type"

    aput-object v3, p5, v2

    .line 1552
    const/16 v2, -0x6c

    iput v2, p0, Landroid/content/pm/PackageParser;->mParseError:I

    .line 1553
    const/4 v13, 0x0

    goto :goto_2c

    .line 1557
    :cond_99
    const-string v12, "<permission>"

    move-object v8, p0

    move-object/from16 v9, p2

    move-object/from16 v10, p3

    move-object/from16 v11, p4

    move-object/from16 v14, p5

    invoke-direct/range {v8 .. v14}, Landroid/content/pm/PackageParser;->parseAllMetaData(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Ljava/lang/String;Landroid/content/pm/PackageParser$Component;[Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_b1

    .line 1559
    const/16 v2, -0x6c

    iput v2, p0, Landroid/content/pm/PackageParser;->mParseError:I

    .line 1560
    const/4 v13, 0x0

    goto/16 :goto_2c

    .line 1563
    :cond_b1
    move-object/from16 v0, p1

    iget-object v2, v0, Landroid/content/pm/PackageParser$Package;->permissions:Ljava/util/ArrayList;

    invoke-virtual {v2, v13}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_2c
.end method

.method private parsePermissionGroup(Landroid/content/pm/PackageParser$Package;ILandroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;[Ljava/lang/String;)Landroid/content/pm/PackageParser$PermissionGroup;
    .registers 22
    .parameter "owner"
    .parameter "flags"
    .parameter "res"
    .parameter "parser"
    .parameter "attrs"
    .parameter "outError"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1463
    new-instance v13, Landroid/content/pm/PackageParser$PermissionGroup;

    move-object/from16 v0, p1

    invoke-direct {v13, v0}, Landroid/content/pm/PackageParser$PermissionGroup;-><init>(Landroid/content/pm/PackageParser$Package;)V

    .line 1465
    .local v13, perm:Landroid/content/pm/PackageParser$PermissionGroup;
    sget-object v2, Lcom/android/internal/R$styleable;->AndroidManifestPermissionGroup:[I

    move-object/from16 v0, p3

    move-object/from16 v1, p5

    invoke-virtual {v0, v1, v2}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v7

    .line 1468
    .local v7, sa:Landroid/content/res/TypedArray;
    iget-object v4, v13, Landroid/content/pm/PackageParser$PermissionGroup;->info:Landroid/content/pm/PermissionGroupInfo;

    const-string v6, "<permission-group>"

    const/4 v8, 0x2

    const/4 v9, 0x0

    const/4 v10, 0x1

    const/4 v11, 0x5

    move-object v2, p0

    move-object/from16 v3, p1

    move-object/from16 v5, p6

    invoke-direct/range {v2 .. v11}, Landroid/content/pm/PackageParser;->parsePackageItemInfo(Landroid/content/pm/PackageParser$Package;Landroid/content/pm/PackageItemInfo;[Ljava/lang/String;Ljava/lang/String;Landroid/content/res/TypedArray;IIII)Z

    move-result v2

    if-nez v2, :cond_2d

    .line 1474
    invoke-virtual {v7}, Landroid/content/res/TypedArray;->recycle()V

    .line 1475
    const/16 v2, -0x6c

    iput v2, p0, Landroid/content/pm/PackageParser;->mParseError:I

    .line 1476
    const/4 v13, 0x0

    .line 1499
    .end local v13           #perm:Landroid/content/pm/PackageParser$PermissionGroup;
    :goto_2c
    return-object v13

    .line 1479
    .restart local v13       #perm:Landroid/content/pm/PackageParser$PermissionGroup;
    :cond_2d
    iget-object v2, v13, Landroid/content/pm/PackageParser$PermissionGroup;->info:Landroid/content/pm/PermissionGroupInfo;

    const/4 v3, 0x4

    const/4 v4, 0x0

    invoke-virtual {v7, v3, v4}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v3

    iput v3, v2, Landroid/content/pm/PermissionGroupInfo;->descriptionRes:I

    .line 1482
    iget-object v2, v13, Landroid/content/pm/PackageParser$PermissionGroup;->info:Landroid/content/pm/PermissionGroupInfo;

    const/4 v3, 0x0

    iput v3, v2, Landroid/content/pm/PermissionGroupInfo;->flags:I

    .line 1483
    iget-object v2, v13, Landroid/content/pm/PackageParser$PermissionGroup;->info:Landroid/content/pm/PermissionGroupInfo;

    const/4 v3, 0x3

    const/4 v4, 0x0

    invoke-virtual {v7, v3, v4}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v3

    iput v3, v2, Landroid/content/pm/PermissionGroupInfo;->priority:I

    .line 1485
    iget-object v2, v13, Landroid/content/pm/PackageParser$PermissionGroup;->info:Landroid/content/pm/PermissionGroupInfo;

    iget v2, v2, Landroid/content/pm/PermissionGroupInfo;->priority:I

    if-lez v2, :cond_55

    and-int/lit8 v2, p2, 0x1

    if-nez v2, :cond_55

    .line 1486
    iget-object v2, v13, Landroid/content/pm/PackageParser$PermissionGroup;->info:Landroid/content/pm/PermissionGroupInfo;

    const/4 v3, 0x0

    iput v3, v2, Landroid/content/pm/PermissionGroupInfo;->priority:I

    .line 1489
    :cond_55
    invoke-virtual {v7}, Landroid/content/res/TypedArray;->recycle()V

    .line 1491
    const-string v12, "<permission-group>"

    move-object v8, p0

    move-object/from16 v9, p3

    move-object/from16 v10, p4

    move-object/from16 v11, p5

    move-object/from16 v14, p6

    invoke-direct/range {v8 .. v14}, Landroid/content/pm/PackageParser;->parseAllMetaData(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Ljava/lang/String;Landroid/content/pm/PackageParser$Component;[Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_6f

    .line 1493
    const/16 v2, -0x6c

    iput v2, p0, Landroid/content/pm/PackageParser;->mParseError:I

    .line 1494
    const/4 v13, 0x0

    goto :goto_2c

    .line 1497
    :cond_6f
    move-object/from16 v0, p1

    iget-object v2, v0, Landroid/content/pm/PackageParser$Package;->permissionGroups:Ljava/util/ArrayList;

    invoke-virtual {v2, v13}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_2c
.end method

.method private parsePermissionTree(Landroid/content/pm/PackageParser$Package;Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;[Ljava/lang/String;)Landroid/content/pm/PackageParser$Permission;
    .registers 22
    .parameter "owner"
    .parameter "res"
    .parameter "parser"
    .parameter "attrs"
    .parameter "outError"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1571
    new-instance v13, Landroid/content/pm/PackageParser$Permission;

    move-object/from16 v0, p1

    invoke-direct {v13, v0}, Landroid/content/pm/PackageParser$Permission;-><init>(Landroid/content/pm/PackageParser$Package;)V

    .line 1573
    .local v13, perm:Landroid/content/pm/PackageParser$Permission;
    sget-object v2, Lcom/android/internal/R$styleable;->AndroidManifestPermissionTree:[I

    move-object/from16 v0, p2

    move-object/from16 v1, p4

    invoke-virtual {v0, v1, v2}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v7

    .line 1576
    .local v7, sa:Landroid/content/res/TypedArray;
    iget-object v4, v13, Landroid/content/pm/PackageParser$Permission;->info:Landroid/content/pm/PermissionInfo;

    const-string v6, "<permission-tree>"

    const/4 v8, 0x2

    const/4 v9, 0x0

    const/4 v10, 0x1

    const/4 v11, 0x3

    move-object/from16 v2, p0

    move-object/from16 v3, p1

    move-object/from16 v5, p5

    invoke-direct/range {v2 .. v11}, Landroid/content/pm/PackageParser;->parsePackageItemInfo(Landroid/content/pm/PackageParser$Package;Landroid/content/pm/PackageItemInfo;[Ljava/lang/String;Ljava/lang/String;Landroid/content/res/TypedArray;IIII)Z

    move-result v2

    if-nez v2, :cond_30

    .line 1582
    invoke-virtual {v7}, Landroid/content/res/TypedArray;->recycle()V

    .line 1583
    const/16 v2, -0x6c

    move-object/from16 v0, p0

    iput v2, v0, Landroid/content/pm/PackageParser;->mParseError:I

    .line 1584
    const/4 v13, 0x0

    .line 1612
    .end local v13           #perm:Landroid/content/pm/PackageParser$Permission;
    :goto_2f
    return-object v13

    .line 1587
    .restart local v13       #perm:Landroid/content/pm/PackageParser$Permission;
    :cond_30
    invoke-virtual {v7}, Landroid/content/res/TypedArray;->recycle()V

    .line 1589
    iget-object v2, v13, Landroid/content/pm/PackageParser$Permission;->info:Landroid/content/pm/PermissionInfo;

    iget-object v2, v2, Landroid/content/pm/PackageItemInfo;->name:Ljava/lang/String;

    const/16 v3, 0x2e

    invoke-virtual {v2, v3}, Ljava/lang/String;->indexOf(I)I

    move-result v15

    .line 1590
    .local v15, index:I
    if-lez v15, :cond_4b

    .line 1591
    iget-object v2, v13, Landroid/content/pm/PackageParser$Permission;->info:Landroid/content/pm/PermissionInfo;

    iget-object v2, v2, Landroid/content/pm/PackageItemInfo;->name:Ljava/lang/String;

    const/16 v3, 0x2e

    add-int/lit8 v4, v15, 0x1

    invoke-virtual {v2, v3, v4}, Ljava/lang/String;->indexOf(II)I

    move-result v15

    .line 1593
    :cond_4b
    if-gez v15, :cond_6f

    .line 1594
    const/4 v2, 0x0

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "<permission-tree> name has less than three segments: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, v13, Landroid/content/pm/PackageParser$Permission;->info:Landroid/content/pm/PermissionInfo;

    iget-object v4, v4, Landroid/content/pm/PackageItemInfo;->name:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, p5, v2

    .line 1596
    const/16 v2, -0x6c

    move-object/from16 v0, p0

    iput v2, v0, Landroid/content/pm/PackageParser;->mParseError:I

    .line 1597
    const/4 v13, 0x0

    goto :goto_2f

    .line 1600
    :cond_6f
    iget-object v2, v13, Landroid/content/pm/PackageParser$Permission;->info:Landroid/content/pm/PermissionInfo;

    const/4 v3, 0x0

    iput v3, v2, Landroid/content/pm/PermissionInfo;->descriptionRes:I

    .line 1601
    iget-object v2, v13, Landroid/content/pm/PackageParser$Permission;->info:Landroid/content/pm/PermissionInfo;

    const/4 v3, 0x0

    iput v3, v2, Landroid/content/pm/PermissionInfo;->protectionLevel:I

    .line 1602
    const/4 v2, 0x1

    iput-boolean v2, v13, Landroid/content/pm/PackageParser$Permission;->tree:Z

    .line 1604
    const-string v12, "<permission-tree>"

    move-object/from16 v8, p0

    move-object/from16 v9, p2

    move-object/from16 v10, p3

    move-object/from16 v11, p4

    move-object/from16 v14, p5

    invoke-direct/range {v8 .. v14}, Landroid/content/pm/PackageParser;->parseAllMetaData(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Ljava/lang/String;Landroid/content/pm/PackageParser$Component;[Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_96

    .line 1606
    const/16 v2, -0x6c

    move-object/from16 v0, p0

    iput v2, v0, Landroid/content/pm/PackageParser;->mParseError:I

    .line 1607
    const/4 v13, 0x0

    goto :goto_2f

    .line 1610
    :cond_96
    move-object/from16 v0, p1

    iget-object v2, v0, Landroid/content/pm/PackageParser$Package;->permissions:Ljava/util/ArrayList;

    invoke-virtual {v2, v13}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_2f
.end method

.method private parseProvider(Landroid/content/pm/PackageParser$Package;Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;I[Ljava/lang/String;)Landroid/content/pm/PackageParser$Provider;
    .registers 24
    .parameter "owner"
    .parameter "res"
    .parameter "parser"
    .parameter "attrs"
    .parameter "flags"
    .parameter "outError"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 2417
    sget-object v2, Lcom/android/internal/R$styleable;->AndroidManifestProvider:[I

    move-object/from16 v0, p2

    move-object/from16 v1, p4

    invoke-virtual {v0, v1, v2}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v15

    .line 2420
    .local v15, sa:Landroid/content/res/TypedArray;
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/content/pm/PackageParser;->mParseProviderArgs:Landroid/content/pm/PackageParser$ParseComponentArgs;

    if-nez v2, :cond_33

    .line 2421
    new-instance v2, Landroid/content/pm/PackageParser$ParseComponentArgs;

    const/4 v5, 0x2

    const/4 v6, 0x0

    const/4 v7, 0x1

    const/16 v8, 0xf

    move-object/from16 v0, p0

    iget-object v9, v0, Landroid/content/pm/PackageParser;->mSeparateProcesses:[Ljava/lang/String;

    const/16 v10, 0x8

    const/16 v11, 0xe

    const/4 v12, 0x6

    move-object/from16 v3, p1

    move-object/from16 v4, p6

    invoke-direct/range {v2 .. v12}, Landroid/content/pm/PackageParser$ParseComponentArgs;-><init>(Landroid/content/pm/PackageParser$Package;[Ljava/lang/String;IIII[Ljava/lang/String;III)V

    move-object/from16 v0, p0

    iput-object v2, v0, Landroid/content/pm/PackageParser;->mParseProviderArgs:Landroid/content/pm/PackageParser$ParseComponentArgs;

    .line 2430
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/content/pm/PackageParser;->mParseProviderArgs:Landroid/content/pm/PackageParser$ParseComponentArgs;

    const-string v3, "<provider>"

    iput-object v3, v2, Landroid/content/pm/PackageParser$ParsePackageItemArgs;->tag:Ljava/lang/String;

    .line 2433
    :cond_33
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/content/pm/PackageParser;->mParseProviderArgs:Landroid/content/pm/PackageParser$ParseComponentArgs;

    iput-object v15, v2, Landroid/content/pm/PackageParser$ParsePackageItemArgs;->sa:Landroid/content/res/TypedArray;

    .line 2434
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/content/pm/PackageParser;->mParseProviderArgs:Landroid/content/pm/PackageParser$ParseComponentArgs;

    move/from16 v0, p5

    iput v0, v2, Landroid/content/pm/PackageParser$ParseComponentArgs;->flags:I

    .line 2436
    new-instance v6, Landroid/content/pm/PackageParser$Provider;

    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/content/pm/PackageParser;->mParseProviderArgs:Landroid/content/pm/PackageParser$ParseComponentArgs;

    new-instance v3, Landroid/content/pm/ProviderInfo;

    invoke-direct {v3}, Landroid/content/pm/ProviderInfo;-><init>()V

    invoke-direct {v6, v2, v3}, Landroid/content/pm/PackageParser$Provider;-><init>(Landroid/content/pm/PackageParser$ParseComponentArgs;Landroid/content/pm/ProviderInfo;)V

    .line 2437
    .local v6, p:Landroid/content/pm/PackageParser$Provider;
    const/4 v2, 0x0

    aget-object v2, p6, v2

    if-eqz v2, :cond_59

    .line 2438
    invoke-virtual {v15}, Landroid/content/res/TypedArray;->recycle()V

    .line 2439
    const/4 v6, 0x0

    .line 2510
    .end local v6           #p:Landroid/content/pm/PackageParser$Provider;
    :cond_58
    :goto_58
    return-object v6

    .line 2442
    .restart local v6       #p:Landroid/content/pm/PackageParser$Provider;
    :cond_59
    iget-object v2, v6, Landroid/content/pm/PackageParser$Provider;->info:Landroid/content/pm/ProviderInfo;

    const/4 v3, 0x7

    const/4 v4, 0x1

    invoke-virtual {v15, v3, v4}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v3

    iput-boolean v3, v2, Landroid/content/pm/ComponentInfo;->exported:Z

    .line 2445
    const/16 v2, 0xa

    const/4 v3, 0x0

    invoke-virtual {v15, v2, v3}, Landroid/content/res/TypedArray;->getNonConfigurationString(II)Ljava/lang/String;

    move-result-object v13

    .line 2448
    .local v13, cpname:Ljava/lang/String;
    iget-object v2, v6, Landroid/content/pm/PackageParser$Provider;->info:Landroid/content/pm/ProviderInfo;

    const/16 v3, 0xb

    const/4 v4, 0x0

    invoke-virtual {v15, v3, v4}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v3

    iput-boolean v3, v2, Landroid/content/pm/ProviderInfo;->isSyncable:Z

    .line 2452
    const/4 v2, 0x3

    const/4 v3, 0x0

    invoke-virtual {v15, v2, v3}, Landroid/content/res/TypedArray;->getNonConfigurationString(II)Ljava/lang/String;

    move-result-object v14

    .line 2454
    .local v14, permission:Ljava/lang/String;
    const/4 v2, 0x4

    const/4 v3, 0x0

    invoke-virtual {v15, v2, v3}, Landroid/content/res/TypedArray;->getNonConfigurationString(II)Ljava/lang/String;

    move-result-object v16

    .line 2456
    .local v16, str:Ljava/lang/String;
    if-nez v16, :cond_85

    .line 2457
    move-object/from16 v16, v14

    .line 2459
    :cond_85
    if-nez v16, :cond_e8

    .line 2460
    iget-object v2, v6, Landroid/content/pm/PackageParser$Provider;->info:Landroid/content/pm/ProviderInfo;

    move-object/from16 v0, p1

    iget-object v3, v0, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget-object v3, v3, Landroid/content/pm/ApplicationInfo;->permission:Ljava/lang/String;

    iput-object v3, v2, Landroid/content/pm/ProviderInfo;->readPermission:Ljava/lang/String;

    .line 2465
    :goto_91
    const/4 v2, 0x5

    const/4 v3, 0x0

    invoke-virtual {v15, v2, v3}, Landroid/content/res/TypedArray;->getNonConfigurationString(II)Ljava/lang/String;

    move-result-object v16

    .line 2467
    if-nez v16, :cond_9b

    .line 2468
    move-object/from16 v16, v14

    .line 2470
    :cond_9b
    if-nez v16, :cond_fd

    .line 2471
    iget-object v2, v6, Landroid/content/pm/PackageParser$Provider;->info:Landroid/content/pm/ProviderInfo;

    move-object/from16 v0, p1

    iget-object v3, v0, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget-object v3, v3, Landroid/content/pm/ApplicationInfo;->permission:Ljava/lang/String;

    iput-object v3, v2, Landroid/content/pm/ProviderInfo;->writePermission:Ljava/lang/String;

    .line 2477
    :goto_a7
    iget-object v2, v6, Landroid/content/pm/PackageParser$Provider;->info:Landroid/content/pm/ProviderInfo;

    const/16 v3, 0xd

    const/4 v4, 0x0

    invoke-virtual {v15, v3, v4}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v3

    iput-boolean v3, v2, Landroid/content/pm/ProviderInfo;->grantUriPermissions:Z

    .line 2481
    iget-object v2, v6, Landroid/content/pm/PackageParser$Provider;->info:Landroid/content/pm/ProviderInfo;

    const/16 v3, 0x9

    const/4 v4, 0x0

    invoke-virtual {v15, v3, v4}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v3

    iput-boolean v3, v2, Landroid/content/pm/ProviderInfo;->multiprocess:Z

    .line 2485
    iget-object v2, v6, Landroid/content/pm/PackageParser$Provider;->info:Landroid/content/pm/ProviderInfo;

    const/16 v3, 0xc

    const/4 v4, 0x0

    invoke-virtual {v15, v3, v4}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v3

    iput v3, v2, Landroid/content/pm/ProviderInfo;->initOrder:I

    .line 2489
    invoke-virtual {v15}, Landroid/content/res/TypedArray;->recycle()V

    .line 2491
    move-object/from16 v0, p1

    iget-object v2, v0, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget v2, v2, Landroid/content/pm/ApplicationInfo;->flags:I

    const/high16 v3, 0x1000

    and-int/2addr v2, v3

    if-eqz v2, :cond_112

    .line 2494
    iget-object v2, v6, Landroid/content/pm/PackageParser$Provider;->info:Landroid/content/pm/ProviderInfo;

    iget-object v2, v2, Landroid/content/pm/ComponentInfo;->processName:Ljava/lang/String;

    move-object/from16 v0, p1

    iget-object v3, v0, Landroid/content/pm/PackageParser$Package;->packageName:Ljava/lang/String;

    if-ne v2, v3, :cond_112

    .line 2495
    const/4 v2, 0x0

    const-string v3, "Heavy-weight applications can not have providers in main process"

    aput-object v3, p6, v2

    .line 2496
    const/4 v6, 0x0

    goto/16 :goto_58

    .line 2462
    :cond_e8
    iget-object v3, v6, Landroid/content/pm/PackageParser$Provider;->info:Landroid/content/pm/ProviderInfo;

    invoke-virtual/range {v16 .. v16}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_fb

    invoke-virtual/range {v16 .. v16}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v2

    :goto_f8
    iput-object v2, v3, Landroid/content/pm/ProviderInfo;->readPermission:Ljava/lang/String;

    goto :goto_91

    :cond_fb
    const/4 v2, 0x0

    goto :goto_f8

    .line 2473
    :cond_fd
    iget-object v3, v6, Landroid/content/pm/PackageParser$Provider;->info:Landroid/content/pm/ProviderInfo;

    invoke-virtual/range {v16 .. v16}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_110

    invoke-virtual/range {v16 .. v16}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v2

    :goto_10d
    iput-object v2, v3, Landroid/content/pm/ProviderInfo;->writePermission:Ljava/lang/String;

    goto :goto_a7

    :cond_110
    const/4 v2, 0x0

    goto :goto_10d

    .line 2500
    :cond_112
    if-nez v13, :cond_11c

    .line 2501
    const/4 v2, 0x0

    const-string v3, "<provider> does not incude authorities attribute"

    aput-object v3, p6, v2

    .line 2502
    const/4 v6, 0x0

    goto/16 :goto_58

    .line 2504
    :cond_11c
    iget-object v2, v6, Landroid/content/pm/PackageParser$Provider;->info:Landroid/content/pm/ProviderInfo;

    invoke-virtual {v13}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v3

    iput-object v3, v2, Landroid/content/pm/ProviderInfo;->authority:Ljava/lang/String;

    move-object/from16 v2, p0

    move-object/from16 v3, p2

    move-object/from16 v4, p3

    move-object/from16 v5, p4

    move-object/from16 v7, p6

    .line 2506
    invoke-direct/range {v2 .. v7}, Landroid/content/pm/PackageParser;->parseProviderTags(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/content/pm/PackageParser$Provider;[Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_58

    .line 2507
    const/4 v6, 0x0

    goto/16 :goto_58
.end method

.method private parseProviderTags(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/content/pm/PackageParser$Provider;[Ljava/lang/String;)Z
    .registers 26
    .parameter "res"
    .parameter "parser"
    .parameter "attrs"
    .parameter "outInfo"
    .parameter "outError"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 2517
    invoke-interface/range {p2 .. p2}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v11

    .line 2520
    .local v11, outerDepth:I
    :cond_4
    :goto_4
    invoke-interface/range {p2 .. p2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v18

    .local v18, type:I
    const/4 v2, 0x1

    move/from16 v0, v18

    if-eq v0, v2, :cond_295

    const/4 v2, 0x3

    move/from16 v0, v18

    if-ne v0, v2, :cond_18

    invoke-interface/range {p2 .. p2}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v2

    if-le v2, v11, :cond_295

    .line 2522
    :cond_18
    const/4 v2, 0x3

    move/from16 v0, v18

    if-eq v0, v2, :cond_4

    const/4 v2, 0x4

    move/from16 v0, v18

    if-eq v0, v2, :cond_4

    .line 2526
    invoke-interface/range {p2 .. p2}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "meta-data"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_49

    .line 2527
    move-object/from16 v0, p4

    iget-object v6, v0, Landroid/content/pm/PackageParser$Component;->metaData:Landroid/os/Bundle;

    move-object/from16 v2, p0

    move-object/from16 v3, p1

    move-object/from16 v4, p2

    move-object/from16 v5, p3

    move-object/from16 v7, p5

    invoke-direct/range {v2 .. v7}, Landroid/content/pm/PackageParser;->parseMetaData(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/os/Bundle;[Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v2

    move-object/from16 v0, p4

    iput-object v2, v0, Landroid/content/pm/PackageParser$Component;->metaData:Landroid/os/Bundle;

    if-nez v2, :cond_4

    .line 2529
    const/4 v2, 0x0

    .line 2686
    :goto_48
    return v2

    .line 2532
    :cond_49
    invoke-interface/range {p2 .. p2}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v2

    const-string v3, "grant-uri-permission"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_11d

    .line 2533
    sget-object v2, Lcom/android/internal/R$styleable;->AndroidManifestGrantUriPermission:[I

    move-object/from16 v0, p1

    move-object/from16 v1, p3

    invoke-virtual {v0, v1, v2}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v16

    .line 2536
    .local v16, sa:Landroid/content/res/TypedArray;
    const/4 v12, 0x0

    .line 2538
    .local v12, pa:Landroid/os/PatternMatcher;
    const/4 v2, 0x0

    const/4 v3, 0x0

    move-object/from16 v0, v16

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getNonConfigurationString(II)Ljava/lang/String;

    move-result-object v17

    .line 2540
    .local v17, str:Ljava/lang/String;
    if-eqz v17, :cond_72

    .line 2541
    new-instance v12, Landroid/os/PatternMatcher;

    .end local v12           #pa:Landroid/os/PatternMatcher;
    const/4 v2, 0x0

    move-object/from16 v0, v17

    invoke-direct {v12, v0, v2}, Landroid/os/PatternMatcher;-><init>(Ljava/lang/String;I)V

    .line 2544
    .restart local v12       #pa:Landroid/os/PatternMatcher;
    :cond_72
    const/4 v2, 0x1

    const/4 v3, 0x0

    move-object/from16 v0, v16

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getNonConfigurationString(II)Ljava/lang/String;

    move-result-object v17

    .line 2546
    if-eqz v17, :cond_84

    .line 2547
    new-instance v12, Landroid/os/PatternMatcher;

    .end local v12           #pa:Landroid/os/PatternMatcher;
    const/4 v2, 0x1

    move-object/from16 v0, v17

    invoke-direct {v12, v0, v2}, Landroid/os/PatternMatcher;-><init>(Ljava/lang/String;I)V

    .line 2550
    .restart local v12       #pa:Landroid/os/PatternMatcher;
    :cond_84
    const/4 v2, 0x2

    const/4 v3, 0x0

    move-object/from16 v0, v16

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getNonConfigurationString(II)Ljava/lang/String;

    move-result-object v17

    .line 2552
    if-eqz v17, :cond_96

    .line 2553
    new-instance v12, Landroid/os/PatternMatcher;

    .end local v12           #pa:Landroid/os/PatternMatcher;
    const/4 v2, 0x2

    move-object/from16 v0, v17

    invoke-direct {v12, v0, v2}, Landroid/os/PatternMatcher;-><init>(Ljava/lang/String;I)V

    .line 2556
    .restart local v12       #pa:Landroid/os/PatternMatcher;
    :cond_96
    invoke-virtual/range {v16 .. v16}, Landroid/content/res/TypedArray;->recycle()V

    .line 2558
    if-eqz v12, :cond_e0

    .line 2559
    move-object/from16 v0, p4

    iget-object v2, v0, Landroid/content/pm/PackageParser$Provider;->info:Landroid/content/pm/ProviderInfo;

    iget-object v2, v2, Landroid/content/pm/ProviderInfo;->uriPermissionPatterns:[Landroid/os/PatternMatcher;

    if-nez v2, :cond_c1

    .line 2560
    move-object/from16 v0, p4

    iget-object v2, v0, Landroid/content/pm/PackageParser$Provider;->info:Landroid/content/pm/ProviderInfo;

    const/4 v3, 0x1

    new-array v3, v3, [Landroid/os/PatternMatcher;

    iput-object v3, v2, Landroid/content/pm/ProviderInfo;->uriPermissionPatterns:[Landroid/os/PatternMatcher;

    .line 2561
    move-object/from16 v0, p4

    iget-object v2, v0, Landroid/content/pm/PackageParser$Provider;->info:Landroid/content/pm/ProviderInfo;

    iget-object v2, v2, Landroid/content/pm/ProviderInfo;->uriPermissionPatterns:[Landroid/os/PatternMatcher;

    const/4 v3, 0x0

    aput-object v12, v2, v3

    .line 2569
    :goto_b5
    move-object/from16 v0, p4

    iget-object v2, v0, Landroid/content/pm/PackageParser$Provider;->info:Landroid/content/pm/ProviderInfo;

    const/4 v3, 0x1

    iput-boolean v3, v2, Landroid/content/pm/ProviderInfo;->grantUriPermissions:Z

    .line 2582
    invoke-static/range {p2 .. p2}, Lcom/android/internal/util/XmlUtils;->skipCurrentTag(Lorg/xmlpull/v1/XmlPullParser;)V

    goto/16 :goto_4

    .line 2563
    :cond_c1
    move-object/from16 v0, p4

    iget-object v2, v0, Landroid/content/pm/PackageParser$Provider;->info:Landroid/content/pm/ProviderInfo;

    iget-object v2, v2, Landroid/content/pm/ProviderInfo;->uriPermissionPatterns:[Landroid/os/PatternMatcher;

    array-length v8, v2

    .line 2564
    .local v8, N:I
    add-int/lit8 v2, v8, 0x1

    new-array v10, v2, [Landroid/os/PatternMatcher;

    .line 2565
    .local v10, newp:[Landroid/os/PatternMatcher;
    move-object/from16 v0, p4

    iget-object v2, v0, Landroid/content/pm/PackageParser$Provider;->info:Landroid/content/pm/ProviderInfo;

    iget-object v2, v2, Landroid/content/pm/ProviderInfo;->uriPermissionPatterns:[Landroid/os/PatternMatcher;

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-static {v2, v3, v10, v4, v8}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 2566
    aput-object v12, v10, v8

    .line 2567
    move-object/from16 v0, p4

    iget-object v2, v0, Landroid/content/pm/PackageParser$Provider;->info:Landroid/content/pm/ProviderInfo;

    iput-object v10, v2, Landroid/content/pm/ProviderInfo;->uriPermissionPatterns:[Landroid/os/PatternMatcher;

    goto :goto_b5

    .line 2572
    .end local v8           #N:I
    .end local v10           #newp:[Landroid/os/PatternMatcher;
    :cond_e0
    const-string v2, "PackageParser"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unknown element under <path-permission>: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-interface/range {p2 .. p2}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " at "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/content/pm/PackageParser;->mArchiveSourcePath:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-interface/range {p2 .. p2}, Lorg/xmlpull/v1/XmlPullParser;->getPositionDescription()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Slog;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 2575
    invoke-static/range {p2 .. p2}, Lcom/android/internal/util/XmlUtils;->skipCurrentTag(Lorg/xmlpull/v1/XmlPullParser;)V

    goto/16 :goto_4

    .line 2584
    .end local v12           #pa:Landroid/os/PatternMatcher;
    .end local v16           #sa:Landroid/content/res/TypedArray;
    .end local v17           #str:Ljava/lang/String;
    :cond_11d
    invoke-interface/range {p2 .. p2}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "path-permission"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_258

    .line 2585
    sget-object v2, Lcom/android/internal/R$styleable;->AndroidManifestPathPermission:[I

    move-object/from16 v0, p1

    move-object/from16 v1, p3

    invoke-virtual {v0, v1, v2}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v16

    .line 2588
    .restart local v16       #sa:Landroid/content/res/TypedArray;
    const/4 v12, 0x0

    .line 2590
    .local v12, pa:Landroid/content/pm/PathPermission;
    const/4 v2, 0x0

    const/4 v3, 0x0

    move-object/from16 v0, v16

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getNonConfigurationString(II)Ljava/lang/String;

    move-result-object v14

    .line 2592
    .local v14, permission:Ljava/lang/String;
    const/4 v2, 0x1

    const/4 v3, 0x0

    move-object/from16 v0, v16

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getNonConfigurationString(II)Ljava/lang/String;

    move-result-object v15

    .line 2594
    .local v15, readPermission:Ljava/lang/String;
    if-nez v15, :cond_148

    .line 2595
    move-object v15, v14

    .line 2597
    :cond_148
    const/4 v2, 0x2

    const/4 v3, 0x0

    move-object/from16 v0, v16

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getNonConfigurationString(II)Ljava/lang/String;

    move-result-object v19

    .line 2599
    .local v19, writePermission:Ljava/lang/String;
    if-nez v19, :cond_154

    .line 2600
    move-object/from16 v19, v14

    .line 2603
    :cond_154
    const/4 v9, 0x0

    .line 2604
    .local v9, havePerm:Z
    if-eqz v15, :cond_15c

    .line 2605
    invoke-virtual {v15}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v15

    .line 2606
    const/4 v9, 0x1

    .line 2608
    :cond_15c
    if-eqz v19, :cond_163

    .line 2609
    invoke-virtual/range {v19 .. v19}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v19

    .line 2610
    const/4 v9, 0x1

    .line 2613
    :cond_163
    if-nez v9, :cond_1a2

    .line 2615
    const-string v2, "PackageParser"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "No readPermission or writePermssion for <path-permission>: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-interface/range {p2 .. p2}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " at "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/content/pm/PackageParser;->mArchiveSourcePath:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-interface/range {p2 .. p2}, Lorg/xmlpull/v1/XmlPullParser;->getPositionDescription()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Slog;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 2618
    invoke-static/range {p2 .. p2}, Lcom/android/internal/util/XmlUtils;->skipCurrentTag(Lorg/xmlpull/v1/XmlPullParser;)V

    goto/16 :goto_4

    .line 2626
    :cond_1a2
    const/4 v2, 0x3

    const/4 v3, 0x0

    move-object/from16 v0, v16

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getNonConfigurationString(II)Ljava/lang/String;

    move-result-object v13

    .line 2628
    .local v13, path:Ljava/lang/String;
    if-eqz v13, :cond_1b4

    .line 2629
    new-instance v12, Landroid/content/pm/PathPermission;

    .end local v12           #pa:Landroid/content/pm/PathPermission;
    const/4 v2, 0x0

    move-object/from16 v0, v19

    invoke-direct {v12, v13, v2, v15, v0}, Landroid/content/pm/PathPermission;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    .line 2633
    .restart local v12       #pa:Landroid/content/pm/PathPermission;
    :cond_1b4
    const/4 v2, 0x4

    const/4 v3, 0x0

    move-object/from16 v0, v16

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getNonConfigurationString(II)Ljava/lang/String;

    move-result-object v13

    .line 2635
    if-eqz v13, :cond_1c6

    .line 2636
    new-instance v12, Landroid/content/pm/PathPermission;

    .end local v12           #pa:Landroid/content/pm/PathPermission;
    const/4 v2, 0x1

    move-object/from16 v0, v19

    invoke-direct {v12, v13, v2, v15, v0}, Landroid/content/pm/PathPermission;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    .line 2640
    .restart local v12       #pa:Landroid/content/pm/PathPermission;
    :cond_1c6
    const/4 v2, 0x5

    const/4 v3, 0x0

    move-object/from16 v0, v16

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getNonConfigurationString(II)Ljava/lang/String;

    move-result-object v13

    .line 2642
    if-eqz v13, :cond_1d8

    .line 2643
    new-instance v12, Landroid/content/pm/PathPermission;

    .end local v12           #pa:Landroid/content/pm/PathPermission;
    const/4 v2, 0x2

    move-object/from16 v0, v19

    invoke-direct {v12, v13, v2, v15, v0}, Landroid/content/pm/PathPermission;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    .line 2647
    .restart local v12       #pa:Landroid/content/pm/PathPermission;
    :cond_1d8
    invoke-virtual/range {v16 .. v16}, Landroid/content/res/TypedArray;->recycle()V

    .line 2649
    if-eqz v12, :cond_21b

    .line 2650
    move-object/from16 v0, p4

    iget-object v2, v0, Landroid/content/pm/PackageParser$Provider;->info:Landroid/content/pm/ProviderInfo;

    iget-object v2, v2, Landroid/content/pm/ProviderInfo;->pathPermissions:[Landroid/content/pm/PathPermission;

    if-nez v2, :cond_1fc

    .line 2651
    move-object/from16 v0, p4

    iget-object v2, v0, Landroid/content/pm/PackageParser$Provider;->info:Landroid/content/pm/ProviderInfo;

    const/4 v3, 0x1

    new-array v3, v3, [Landroid/content/pm/PathPermission;

    iput-object v3, v2, Landroid/content/pm/ProviderInfo;->pathPermissions:[Landroid/content/pm/PathPermission;

    .line 2652
    move-object/from16 v0, p4

    iget-object v2, v0, Landroid/content/pm/PackageParser$Provider;->info:Landroid/content/pm/ProviderInfo;

    iget-object v2, v2, Landroid/content/pm/ProviderInfo;->pathPermissions:[Landroid/content/pm/PathPermission;

    const/4 v3, 0x0

    aput-object v12, v2, v3

    .line 2671
    :goto_1f7
    invoke-static/range {p2 .. p2}, Lcom/android/internal/util/XmlUtils;->skipCurrentTag(Lorg/xmlpull/v1/XmlPullParser;)V

    goto/16 :goto_4

    .line 2654
    :cond_1fc
    move-object/from16 v0, p4

    iget-object v2, v0, Landroid/content/pm/PackageParser$Provider;->info:Landroid/content/pm/ProviderInfo;

    iget-object v2, v2, Landroid/content/pm/ProviderInfo;->pathPermissions:[Landroid/content/pm/PathPermission;

    array-length v8, v2

    .line 2655
    .restart local v8       #N:I
    add-int/lit8 v2, v8, 0x1

    new-array v10, v2, [Landroid/content/pm/PathPermission;

    .line 2656
    .local v10, newp:[Landroid/content/pm/PathPermission;
    move-object/from16 v0, p4

    iget-object v2, v0, Landroid/content/pm/PackageParser$Provider;->info:Landroid/content/pm/ProviderInfo;

    iget-object v2, v2, Landroid/content/pm/ProviderInfo;->pathPermissions:[Landroid/content/pm/PathPermission;

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-static {v2, v3, v10, v4, v8}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 2657
    aput-object v12, v10, v8

    .line 2658
    move-object/from16 v0, p4

    iget-object v2, v0, Landroid/content/pm/PackageParser$Provider;->info:Landroid/content/pm/ProviderInfo;

    iput-object v10, v2, Landroid/content/pm/ProviderInfo;->pathPermissions:[Landroid/content/pm/PathPermission;

    goto :goto_1f7

    .line 2662
    .end local v8           #N:I
    .end local v10           #newp:[Landroid/content/pm/PathPermission;
    :cond_21b
    const-string v2, "PackageParser"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "No path, pathPrefix, or pathPattern for <path-permission>: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-interface/range {p2 .. p2}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " at "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/content/pm/PackageParser;->mArchiveSourcePath:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-interface/range {p2 .. p2}, Lorg/xmlpull/v1/XmlPullParser;->getPositionDescription()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Slog;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 2665
    invoke-static/range {p2 .. p2}, Lcom/android/internal/util/XmlUtils;->skipCurrentTag(Lorg/xmlpull/v1/XmlPullParser;)V

    goto/16 :goto_4

    .line 2675
    .end local v9           #havePerm:Z
    .end local v12           #pa:Landroid/content/pm/PathPermission;
    .end local v13           #path:Ljava/lang/String;
    .end local v14           #permission:Ljava/lang/String;
    .end local v15           #readPermission:Ljava/lang/String;
    .end local v16           #sa:Landroid/content/res/TypedArray;
    .end local v19           #writePermission:Ljava/lang/String;
    :cond_258
    const-string v2, "PackageParser"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unknown element under <provider>: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-interface/range {p2 .. p2}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " at "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/content/pm/PackageParser;->mArchiveSourcePath:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-interface/range {p2 .. p2}, Lorg/xmlpull/v1/XmlPullParser;->getPositionDescription()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Slog;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 2678
    invoke-static/range {p2 .. p2}, Lcom/android/internal/util/XmlUtils;->skipCurrentTag(Lorg/xmlpull/v1/XmlPullParser;)V

    goto/16 :goto_4

    .line 2686
    :cond_295
    const/4 v2, 0x1

    goto/16 :goto_48
.end method

.method private parseService(Landroid/content/pm/PackageParser$Package;Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;I[Ljava/lang/String;)Landroid/content/pm/PackageParser$Service;
    .registers 27
    .parameter "owner"
    .parameter "res"
    .parameter "parser"
    .parameter "attrs"
    .parameter "flags"
    .parameter "outError"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 2692
    sget-object v2, Lcom/android/internal/R$styleable;->AndroidManifestService:[I

    move-object/from16 v0, p2

    move-object/from16 v1, p4

    invoke-virtual {v0, v1, v2}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v16

    .line 2695
    .local v16, sa:Landroid/content/res/TypedArray;
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/content/pm/PackageParser;->mParseServiceArgs:Landroid/content/pm/PackageParser$ParseComponentArgs;

    if-nez v2, :cond_31

    .line 2696
    new-instance v2, Landroid/content/pm/PackageParser$ParseComponentArgs;

    const/4 v5, 0x2

    const/4 v6, 0x0

    const/4 v7, 0x1

    const/16 v8, 0x8

    move-object/from16 v0, p0

    iget-object v9, v0, Landroid/content/pm/PackageParser;->mSeparateProcesses:[Ljava/lang/String;

    const/4 v10, 0x6

    const/4 v11, 0x7

    const/4 v12, 0x4

    move-object/from16 v3, p1

    move-object/from16 v4, p6

    invoke-direct/range {v2 .. v12}, Landroid/content/pm/PackageParser$ParseComponentArgs;-><init>(Landroid/content/pm/PackageParser$Package;[Ljava/lang/String;IIII[Ljava/lang/String;III)V

    move-object/from16 v0, p0

    iput-object v2, v0, Landroid/content/pm/PackageParser;->mParseServiceArgs:Landroid/content/pm/PackageParser$ParseComponentArgs;

    .line 2705
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/content/pm/PackageParser;->mParseServiceArgs:Landroid/content/pm/PackageParser$ParseComponentArgs;

    const-string v3, "<service>"

    iput-object v3, v2, Landroid/content/pm/PackageParser$ParsePackageItemArgs;->tag:Ljava/lang/String;

    .line 2708
    :cond_31
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/content/pm/PackageParser;->mParseServiceArgs:Landroid/content/pm/PackageParser$ParseComponentArgs;

    move-object/from16 v0, v16

    iput-object v0, v2, Landroid/content/pm/PackageParser$ParsePackageItemArgs;->sa:Landroid/content/res/TypedArray;

    .line 2709
    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/content/pm/PackageParser;->mParseServiceArgs:Landroid/content/pm/PackageParser$ParseComponentArgs;

    move/from16 v0, p5

    iput v0, v2, Landroid/content/pm/PackageParser$ParseComponentArgs;->flags:I

    .line 2711
    new-instance v15, Landroid/content/pm/PackageParser$Service;

    move-object/from16 v0, p0

    iget-object v2, v0, Landroid/content/pm/PackageParser;->mParseServiceArgs:Landroid/content/pm/PackageParser$ParseComponentArgs;

    new-instance v3, Landroid/content/pm/ServiceInfo;

    invoke-direct {v3}, Landroid/content/pm/ServiceInfo;-><init>()V

    invoke-direct {v15, v2, v3}, Landroid/content/pm/PackageParser$Service;-><init>(Landroid/content/pm/PackageParser$ParseComponentArgs;Landroid/content/pm/ServiceInfo;)V

    .line 2712
    .local v15, s:Landroid/content/pm/PackageParser$Service;
    const/4 v2, 0x0

    aget-object v2, p6, v2

    if-eqz v2, :cond_59

    .line 2713
    invoke-virtual/range {v16 .. v16}, Landroid/content/res/TypedArray;->recycle()V

    .line 2714
    const/4 v15, 0x0

    .line 2794
    .end local v15           #s:Landroid/content/pm/PackageParser$Service;
    :cond_58
    :goto_58
    return-object v15

    .line 2717
    .restart local v15       #s:Landroid/content/pm/PackageParser$Service;
    :cond_59
    const/4 v2, 0x5

    move-object/from16 v0, v16

    invoke-virtual {v0, v2}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v17

    .line 2719
    .local v17, setExported:Z
    if-eqz v17, :cond_6e

    .line 2720
    iget-object v2, v15, Landroid/content/pm/PackageParser$Service;->info:Landroid/content/pm/ServiceInfo;

    const/4 v3, 0x5

    const/4 v4, 0x0

    move-object/from16 v0, v16

    invoke-virtual {v0, v3, v4}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v3

    iput-boolean v3, v2, Landroid/content/pm/ComponentInfo;->exported:Z

    .line 2724
    :cond_6e
    const/4 v2, 0x3

    const/4 v3, 0x0

    move-object/from16 v0, v16

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getNonConfigurationString(II)Ljava/lang/String;

    move-result-object v18

    .line 2726
    .local v18, str:Ljava/lang/String;
    if-nez v18, :cond_cc

    .line 2727
    iget-object v2, v15, Landroid/content/pm/PackageParser$Service;->info:Landroid/content/pm/ServiceInfo;

    move-object/from16 v0, p1

    iget-object v3, v0, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget-object v3, v3, Landroid/content/pm/ApplicationInfo;->permission:Ljava/lang/String;

    iput-object v3, v2, Landroid/content/pm/ServiceInfo;->permission:Ljava/lang/String;

    .line 2732
    :goto_82
    iget-object v2, v15, Landroid/content/pm/PackageParser$Service;->info:Landroid/content/pm/ServiceInfo;

    const/4 v3, 0x0

    iput v3, v2, Landroid/content/pm/ServiceInfo;->flags:I

    .line 2733
    const/16 v2, 0x9

    const/4 v3, 0x0

    move-object/from16 v0, v16

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v2

    if-eqz v2, :cond_9a

    .line 2736
    iget-object v2, v15, Landroid/content/pm/PackageParser$Service;->info:Landroid/content/pm/ServiceInfo;

    iget v3, v2, Landroid/content/pm/ServiceInfo;->flags:I

    or-int/lit8 v3, v3, 0x1

    iput v3, v2, Landroid/content/pm/ServiceInfo;->flags:I

    .line 2738
    :cond_9a
    const/16 v2, 0xa

    const/4 v3, 0x0

    move-object/from16 v0, v16

    invoke-virtual {v0, v2, v3}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v2

    if-eqz v2, :cond_ad

    .line 2741
    iget-object v2, v15, Landroid/content/pm/PackageParser$Service;->info:Landroid/content/pm/ServiceInfo;

    iget v3, v2, Landroid/content/pm/ServiceInfo;->flags:I

    or-int/lit8 v3, v3, 0x2

    iput v3, v2, Landroid/content/pm/ServiceInfo;->flags:I

    .line 2744
    :cond_ad
    invoke-virtual/range {v16 .. v16}, Landroid/content/res/TypedArray;->recycle()V

    .line 2746
    move-object/from16 v0, p1

    iget-object v2, v0, Landroid/content/pm/PackageParser$Package;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget v2, v2, Landroid/content/pm/ApplicationInfo;->flags:I

    const/high16 v3, 0x1000

    and-int/2addr v2, v3

    if-eqz v2, :cond_e1

    .line 2749
    iget-object v2, v15, Landroid/content/pm/PackageParser$Service;->info:Landroid/content/pm/ServiceInfo;

    iget-object v2, v2, Landroid/content/pm/ComponentInfo;->processName:Ljava/lang/String;

    move-object/from16 v0, p1

    iget-object v3, v0, Landroid/content/pm/PackageParser$Package;->packageName:Ljava/lang/String;

    if-ne v2, v3, :cond_e1

    .line 2750
    const/4 v2, 0x0

    const-string v3, "Heavy-weight applications can not have services in main process"

    aput-object v3, p6, v2

    .line 2751
    const/4 v15, 0x0

    goto :goto_58

    .line 2729
    :cond_cc
    iget-object v3, v15, Landroid/content/pm/PackageParser$Service;->info:Landroid/content/pm/ServiceInfo;

    invoke-virtual/range {v18 .. v18}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_df

    invoke-virtual/range {v18 .. v18}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v2

    :goto_dc
    iput-object v2, v3, Landroid/content/pm/ServiceInfo;->permission:Ljava/lang/String;

    goto :goto_82

    :cond_df
    const/4 v2, 0x0

    goto :goto_dc

    .line 2755
    :cond_e1
    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v14

    .line 2758
    .local v14, outerDepth:I
    :cond_e5
    :goto_e5
    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v19

    .local v19, type:I
    const/4 v2, 0x1

    move/from16 v0, v19

    if-eq v0, v2, :cond_191

    const/4 v2, 0x3

    move/from16 v0, v19

    if-ne v0, v2, :cond_f9

    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v2

    if-le v2, v14, :cond_191

    .line 2760
    :cond_f9
    const/4 v2, 0x3

    move/from16 v0, v19

    if-eq v0, v2, :cond_e5

    const/4 v2, 0x4

    move/from16 v0, v19

    if-eq v0, v2, :cond_e5

    .line 2764
    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v2

    const-string v3, "intent-filter"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_130

    .line 2765
    new-instance v7, Landroid/content/pm/PackageParser$ServiceIntentInfo;

    invoke-direct {v7, v15}, Landroid/content/pm/PackageParser$ServiceIntentInfo;-><init>(Landroid/content/pm/PackageParser$Service;)V

    .line 2766
    .local v7, intent:Landroid/content/pm/PackageParser$ServiceIntentInfo;
    const/4 v9, 0x0

    move-object/from16 v2, p0

    move-object/from16 v3, p2

    move-object/from16 v4, p3

    move-object/from16 v5, p4

    move/from16 v6, p5

    move-object/from16 v8, p6

    invoke-direct/range {v2 .. v9}, Landroid/content/pm/PackageParser;->parseIntent(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;ILandroid/content/pm/PackageParser$IntentInfo;[Ljava/lang/String;Z)Z

    move-result v2

    if-nez v2, :cond_12a

    .line 2767
    const/4 v15, 0x0

    goto/16 :goto_58

    .line 2770
    :cond_12a
    iget-object v2, v15, Landroid/content/pm/PackageParser$Component;->intents:Ljava/util/ArrayList;

    invoke-virtual {v2, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_e5

    .line 2771
    .end local v7           #intent:Landroid/content/pm/PackageParser$ServiceIntentInfo;
    :cond_130
    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "meta-data"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_154

    .line 2772
    iget-object v12, v15, Landroid/content/pm/PackageParser$Component;->metaData:Landroid/os/Bundle;

    move-object/from16 v8, p0

    move-object/from16 v9, p2

    move-object/from16 v10, p3

    move-object/from16 v11, p4

    move-object/from16 v13, p6

    invoke-direct/range {v8 .. v13}, Landroid/content/pm/PackageParser;->parseMetaData(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/os/Bundle;[Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v2

    iput-object v2, v15, Landroid/content/pm/PackageParser$Component;->metaData:Landroid/os/Bundle;

    if-nez v2, :cond_e5

    .line 2774
    const/4 v15, 0x0

    goto/16 :goto_58

    .line 2778
    :cond_154
    const-string v2, "PackageParser"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unknown element under <service>: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " at "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/content/pm/PackageParser;->mArchiveSourcePath:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->getPositionDescription()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Slog;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 2781
    invoke-static/range {p3 .. p3}, Lcom/android/internal/util/XmlUtils;->skipCurrentTag(Lorg/xmlpull/v1/XmlPullParser;)V

    goto/16 :goto_e5

    .line 2790
    :cond_191
    if-nez v17, :cond_58

    .line 2791
    iget-object v3, v15, Landroid/content/pm/PackageParser$Service;->info:Landroid/content/pm/ServiceInfo;

    iget-object v2, v15, Landroid/content/pm/PackageParser$Component;->intents:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-lez v2, :cond_1a2

    const/4 v2, 0x1

    :goto_19e
    iput-boolean v2, v3, Landroid/content/pm/ComponentInfo;->exported:Z

    goto/16 :goto_58

    :cond_1a2
    const/4 v2, 0x0

    goto :goto_19e
.end method

.method private static parseVerifier(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;I[Ljava/lang/String;)Landroid/content/pm/VerifierInfo;
    .registers 16
    .parameter "res"
    .parameter "parser"
    .parameter "attrs"
    .parameter "flags"
    .parameter "outError"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 2899
    sget-object v8, Lcom/android/internal/R$styleable;->AndroidManifestPackageVerifier:[I

    invoke-virtual {p0, p2, v8}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v7

    .line 2902
    .local v7, sa:Landroid/content/res/TypedArray;
    const/4 v8, 0x0

    invoke-virtual {v7, v8}, Landroid/content/res/TypedArray;->getNonResourceString(I)Ljava/lang/String;

    move-result-object v5

    .line 2905
    .local v5, packageName:Ljava/lang/String;
    const/4 v8, 0x1

    invoke-virtual {v7, v8}, Landroid/content/res/TypedArray;->getNonResourceString(I)Ljava/lang/String;

    move-result-object v2

    .line 2908
    .local v2, encodedPublicKey:Ljava/lang/String;
    invoke-virtual {v7}, Landroid/content/res/TypedArray;->recycle()V

    .line 2910
    if-eqz v5, :cond_1b

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v8

    if-nez v8, :cond_25

    .line 2911
    :cond_1b
    const-string v8, "PackageParser"

    const-string/jumbo v9, "verifier package name was null; skipping"

    invoke-static {v8, v9}, Landroid/util/Slog;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 2912
    const/4 v8, 0x0

    .line 2950
    :goto_24
    return-object v8

    .line 2913
    :cond_25
    if-nez v2, :cond_46

    .line 2914
    const-string v8, "PackageParser"

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v10, "verifier "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, " public key was null; skipping"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Landroid/util/Slog;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 2919
    :cond_46
    const/4 v8, 0x0

    :try_start_47
    invoke-static {v2, v8}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v1

    .line 2920
    .local v1, encoded:[B
    new-instance v4, Ljava/security/spec/X509EncodedKeySpec;

    invoke-direct {v4, v1}, Ljava/security/spec/X509EncodedKeySpec;-><init>([B)V
    :try_end_50
    .catch Ljava/lang/IllegalArgumentException; {:try_start_47 .. :try_end_50} :catch_6a

    .line 2928
    .local v4, keySpec:Ljava/security/spec/EncodedKeySpec;
    :try_start_50
    const-string v8, "RSA"

    invoke-static {v8}, Ljava/security/KeyFactory;->getInstance(Ljava/lang/String;)Ljava/security/KeyFactory;

    move-result-object v3

    .line 2929
    .local v3, keyFactory:Ljava/security/KeyFactory;
    invoke-virtual {v3, v4}, Ljava/security/KeyFactory;->generatePublic(Ljava/security/spec/KeySpec;)Ljava/security/PublicKey;

    move-result-object v6

    .line 2930
    .local v6, publicKey:Ljava/security/PublicKey;
    new-instance v8, Landroid/content/pm/VerifierInfo;

    invoke-direct {v8, v5, v6}, Landroid/content/pm/VerifierInfo;-><init>(Ljava/lang/String;Ljava/security/PublicKey;)V
    :try_end_5f
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_50 .. :try_end_5f} :catch_60
    .catch Ljava/security/spec/InvalidKeySpecException; {:try_start_50 .. :try_end_5f} :catch_8b

    goto :goto_24

    .line 2931
    .end local v3           #keyFactory:Ljava/security/KeyFactory;
    .end local v6           #publicKey:Ljava/security/PublicKey;
    :catch_60
    move-exception v0

    .line 2932
    .local v0, e:Ljava/security/NoSuchAlgorithmException;
    const-string v8, "PackageParser"

    const-string v9, "Could not parse public key because RSA isn\'t included in build"

    invoke-static {v8, v9}, Landroid/util/Log;->wtf(Ljava/lang/String;Ljava/lang/String;)I

    .line 2933
    const/4 v8, 0x0

    goto :goto_24

    .line 2921
    .end local v0           #e:Ljava/security/NoSuchAlgorithmException;
    .end local v1           #encoded:[B
    .end local v4           #keySpec:Ljava/security/spec/EncodedKeySpec;
    :catch_6a
    move-exception v0

    .line 2922
    .local v0, e:Ljava/lang/IllegalArgumentException;
    const-string v8, "PackageParser"

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "Could not parse verifier "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, " public key; invalid Base64"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Landroid/util/Slog;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 2923
    const/4 v8, 0x0

    goto :goto_24

    .line 2934
    .end local v0           #e:Ljava/lang/IllegalArgumentException;
    .restart local v1       #encoded:[B
    .restart local v4       #keySpec:Ljava/security/spec/EncodedKeySpec;
    :catch_8b
    move-exception v8

    .line 2940
    :try_start_8c
    const-string v8, "DSA"

    invoke-static {v8}, Ljava/security/KeyFactory;->getInstance(Ljava/lang/String;)Ljava/security/KeyFactory;

    move-result-object v3

    .line 2941
    .restart local v3       #keyFactory:Ljava/security/KeyFactory;
    invoke-virtual {v3, v4}, Ljava/security/KeyFactory;->generatePublic(Ljava/security/spec/KeySpec;)Ljava/security/PublicKey;

    move-result-object v6

    .line 2942
    .restart local v6       #publicKey:Ljava/security/PublicKey;
    new-instance v8, Landroid/content/pm/VerifierInfo;

    invoke-direct {v8, v5, v6}, Landroid/content/pm/VerifierInfo;-><init>(Ljava/lang/String;Ljava/security/PublicKey;)V
    :try_end_9b
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_8c .. :try_end_9b} :catch_9c
    .catch Ljava/security/spec/InvalidKeySpecException; {:try_start_8c .. :try_end_9b} :catch_a7

    goto :goto_24

    .line 2943
    .end local v3           #keyFactory:Ljava/security/KeyFactory;
    .end local v6           #publicKey:Ljava/security/PublicKey;
    :catch_9c
    move-exception v0

    .line 2944
    .local v0, e:Ljava/security/NoSuchAlgorithmException;
    const-string v8, "PackageParser"

    const-string v9, "Could not parse public key because DSA isn\'t included in build"

    invoke-static {v8, v9}, Landroid/util/Log;->wtf(Ljava/lang/String;Ljava/lang/String;)I

    .line 2945
    const/4 v8, 0x0

    goto/16 :goto_24

    .line 2946
    .end local v0           #e:Ljava/security/NoSuchAlgorithmException;
    :catch_a7
    move-exception v8

    .line 2950
    const/4 v8, 0x0

    goto/16 :goto_24
.end method

.method public static setCompatibilityModeEnabled(Z)V
    .registers 1
    .parameter "compatibilityModeEnabled"

    .prologue
    .line 3721
    sput-boolean p0, Landroid/content/pm/PackageParser;->sCompatibilityModeEnabled:Z

    .line 3722
    return-void
.end method

.method public static stringToSignature(Ljava/lang/String;)Landroid/content/pm/Signature;
    .registers 5
    .parameter "str"

    .prologue
    .line 887
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    .line 888
    .local v0, N:I
    new-array v2, v0, [B

    .line 889
    .local v2, sig:[B
    const/4 v1, 0x0

    .local v1, i:I
    :goto_7
    if-ge v1, v0, :cond_13

    .line 890
    invoke-virtual {p0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v3

    int-to-byte v3, v3

    aput-byte v3, v2, v1

    .line 889
    add-int/lit8 v1, v1, 0x1

    goto :goto_7

    .line 892
    :cond_13
    new-instance v3, Landroid/content/pm/Signature;

    invoke-direct {v3, v2}, Landroid/content/pm/Signature;-><init>([B)V

    return-object v3
.end method

.method private static validateName(Ljava/lang/String;Z)Ljava/lang/String;
    .registers 9
    .parameter "name"
    .parameter "requiresSeparator"

    .prologue
    .line 759
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    .line 760
    .local v0, N:I
    const/4 v3, 0x0

    .line 761
    .local v3, hasSep:Z
    const/4 v2, 0x1

    .line 762
    .local v2, front:Z
    const/4 v4, 0x0

    .local v4, i:I
    :goto_7
    if-ge v4, v0, :cond_50

    .line 763
    invoke-virtual {p0, v4}, Ljava/lang/String;->charAt(I)C

    move-result v1

    .line 764
    .local v1, c:C
    const/16 v5, 0x61

    if-lt v1, v5, :cond_15

    const/16 v5, 0x7a

    if-le v1, v5, :cond_1d

    :cond_15
    const/16 v5, 0x41

    if-lt v1, v5, :cond_21

    const/16 v5, 0x5a

    if-gt v1, v5, :cond_21

    .line 765
    :cond_1d
    const/4 v2, 0x0

    .line 762
    :cond_1e
    :goto_1e
    add-int/lit8 v4, v4, 0x1

    goto :goto_7

    .line 768
    :cond_21
    if-nez v2, :cond_2f

    .line 769
    const/16 v5, 0x30

    if-lt v1, v5, :cond_2b

    const/16 v5, 0x39

    if-le v1, v5, :cond_1e

    :cond_2b
    const/16 v5, 0x5f

    if-eq v1, v5, :cond_1e

    .line 773
    :cond_2f
    const/16 v5, 0x2e

    if-ne v1, v5, :cond_36

    .line 774
    const/4 v3, 0x1

    .line 775
    const/4 v2, 0x1

    .line 776
    goto :goto_1e

    .line 778
    :cond_36
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "bad character \'"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "\'"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 780
    .end local v1           #c:C
    :goto_4f
    return-object v5

    :cond_50
    if-nez v3, :cond_54

    if-nez p1, :cond_56

    :cond_54
    const/4 v5, 0x0

    goto :goto_4f

    :cond_56
    const-string/jumbo v5, "must have at least one \'.\' separator"

    goto :goto_4f
.end method


# virtual methods
.method public collectCertificates(Landroid/content/pm/PackageParser$Package;I)Z
    .registers 24
    .parameter "pkg"
    .parameter "flags"

    .prologue
    .line 563
    const/16 v18, 0x0

    move-object/from16 v0, v18

    move-object/from16 v1, p1

    iput-object v0, v1, Landroid/content/pm/PackageParser$Package;->mSignatures:[Landroid/content/pm/Signature;

    .line 566
    const/16 v16, 0x0

    .line 567
    .local v16, readBuffer:[B
    sget-object v19, Landroid/content/pm/PackageParser;->mSync:Ljava/lang/Object;

    monitor-enter v19

    .line 568
    :try_start_d
    sget-object v17, Landroid/content/pm/PackageParser;->mReadBuffer:Ljava/lang/ref/WeakReference;

    .line 569
    .local v17, readBufferRef:Ljava/lang/ref/WeakReference;,"Ljava/lang/ref/WeakReference<[B>;"
    if-eqz v17, :cond_1f

    .line 570
    const/16 v18, 0x0

    sput-object v18, Landroid/content/pm/PackageParser;->mReadBuffer:Ljava/lang/ref/WeakReference;

    .line 571
    invoke-virtual/range {v17 .. v17}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v18

    move-object/from16 v0, v18

    check-cast v0, [B

    move-object/from16 v16, v0

    .line 573
    :cond_1f
    if-nez v16, :cond_32

    .line 574
    const/16 v18, 0x2000

    move/from16 v0, v18

    new-array v0, v0, [B

    move-object/from16 v16, v0

    .line 575
    new-instance v17, Ljava/lang/ref/WeakReference;

    .end local v17           #readBufferRef:Ljava/lang/ref/WeakReference;,"Ljava/lang/ref/WeakReference<[B>;"
    move-object/from16 v0, v17

    move-object/from16 v1, v16

    invoke-direct {v0, v1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    .line 577
    .restart local v17       #readBufferRef:Ljava/lang/ref/WeakReference;,"Ljava/lang/ref/WeakReference<[B>;"
    :cond_32
    monitor-exit v19
    :try_end_33
    .catchall {:try_start_d .. :try_end_33} :catchall_97

    .line 580
    :try_start_33
    new-instance v11, Ljava/util/jar/JarFile;

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/content/pm/PackageParser;->mArchiveSourcePath:Ljava/lang/String;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    invoke-direct {v11, v0}, Ljava/util/jar/JarFile;-><init>(Ljava/lang/String;)V

    .line 582
    .local v11, jarFile:Ljava/util/jar/JarFile;
    const/4 v4, 0x0

    .line 584
    .local v4, certs:[Ljava/security/cert/Certificate;
    and-int/lit8 v18, p2, 0x1

    if-eqz v18, :cond_9a

    .line 589
    const-string v18, "AndroidManifest.xml"

    move-object/from16 v0, v18

    invoke-virtual {v11, v0}, Ljava/util/jar/JarFile;->getJarEntry(Ljava/lang/String;)Ljava/util/jar/JarEntry;

    move-result-object v10

    .line 590
    .local v10, jarEntry:Ljava/util/jar/JarEntry;
    move-object/from16 v0, p0

    move-object/from16 v1, v16

    invoke-direct {v0, v11, v10, v1}, Landroid/content/pm/PackageParser;->loadCertificates(Ljava/util/jar/JarFile;Ljava/util/jar/JarEntry;[B)[Ljava/security/cert/Certificate;

    move-result-object v4

    .line 591
    if-nez v4, :cond_1ad

    .line 592
    const-string v18, "PackageParser"

    new-instance v19, Ljava/lang/StringBuilder;

    invoke-direct/range {v19 .. v19}, Ljava/lang/StringBuilder;-><init>()V

    const-string v20, "Package "

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    move-object/from16 v0, p1

    iget-object v0, v0, Landroid/content/pm/PackageParser$Package;->packageName:Ljava/lang/String;

    move-object/from16 v20, v0

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    const-string v20, " has no certificates at entry "

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual {v10}, Ljava/util/jar/JarEntry;->getName()Ljava/lang/String;

    move-result-object v20

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    const-string v20, "; ignoring!"

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    invoke-static/range {v18 .. v19}, Landroid/util/Slog;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 595
    invoke-virtual {v11}, Ljava/util/jar/JarFile;->close()V

    .line 596
    const/16 v18, -0x67

    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Landroid/content/pm/PackageParser;->mParseError:I
    :try_end_94
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_33 .. :try_end_94} :catch_1e9
    .catch Ljava/io/IOException; {:try_start_33 .. :try_end_94} :catch_248
    .catch Ljava/lang/RuntimeException; {:try_start_33 .. :try_end_94} :catch_277

    .line 597
    const/16 v18, 0x0

    .line 703
    .end local v4           #certs:[Ljava/security/cert/Certificate;
    .end local v10           #jarEntry:Ljava/util/jar/JarEntry;
    .end local v11           #jarFile:Ljava/util/jar/JarFile;
    :goto_96
    return v18

    .line 577
    .end local v17           #readBufferRef:Ljava/lang/ref/WeakReference;,"Ljava/lang/ref/WeakReference<[B>;"
    :catchall_97
    move-exception v18

    :try_start_98
    monitor-exit v19
    :try_end_99
    .catchall {:try_start_98 .. :try_end_99} :catchall_97

    throw v18

    .line 612
    .restart local v4       #certs:[Ljava/security/cert/Certificate;
    .restart local v11       #jarFile:Ljava/util/jar/JarFile;
    .restart local v17       #readBufferRef:Ljava/lang/ref/WeakReference;,"Ljava/lang/ref/WeakReference<[B>;"
    :cond_9a
    :try_start_9a
    invoke-virtual {v11}, Ljava/util/jar/JarFile;->entries()Ljava/util/Enumeration;

    move-result-object v6

    .line 613
    .local v6, entries:Ljava/util/Enumeration;,"Ljava/util/Enumeration<Ljava/util/jar/JarEntry;>;"
    invoke-virtual {v11}, Ljava/util/jar/JarFile;->getManifest()Ljava/util/jar/Manifest;

    move-result-object v14

    .line 614
    .local v14, manifest:Ljava/util/jar/Manifest;
    :cond_a2
    :goto_a2
    invoke-interface {v6}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result v18

    if-eqz v18, :cond_1ad

    .line 615
    invoke-interface {v6}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/util/jar/JarEntry;

    .line 616
    .local v12, je:Ljava/util/jar/JarEntry;
    invoke-virtual {v12}, Ljava/util/jar/JarEntry;->isDirectory()Z

    move-result v18

    if-nez v18, :cond_a2

    .line 618
    invoke-virtual {v12}, Ljava/util/jar/JarEntry;->getName()Ljava/lang/String;

    move-result-object v15

    .line 620
    .local v15, name:Ljava/lang/String;
    const-string v18, "META-INF/"

    move-object/from16 v0, v18

    invoke-virtual {v15, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v18

    if-nez v18, :cond_a2

    .line 623
    const-string v18, "AndroidManifest.xml"

    move-object/from16 v0, v18

    invoke-virtual {v0, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v18

    if-eqz v18, :cond_da

    .line 624
    invoke-virtual {v14, v15}, Ljava/util/jar/Manifest;->getAttributes(Ljava/lang/String;)Ljava/util/jar/Attributes;

    move-result-object v3

    .line 625
    .local v3, attributes:Ljava/util/jar/Attributes;
    invoke-static {v3}, Landroid/content/pm/ManifestDigest;->fromAttributes(Ljava/util/jar/Attributes;)Landroid/content/pm/ManifestDigest;

    move-result-object v18

    move-object/from16 v0, v18

    move-object/from16 v1, p1

    iput-object v0, v1, Landroid/content/pm/PackageParser$Package;->manifestDigest:Landroid/content/pm/ManifestDigest;

    .line 628
    .end local v3           #attributes:Ljava/util/jar/Attributes;
    :cond_da
    move-object/from16 v0, p0

    move-object/from16 v1, v16

    invoke-direct {v0, v11, v12, v1}, Landroid/content/pm/PackageParser;->loadCertificates(Ljava/util/jar/JarFile;Ljava/util/jar/JarEntry;[B)[Ljava/security/cert/Certificate;

    move-result-object v13

    .line 635
    .local v13, localCerts:[Ljava/security/cert/Certificate;
    if-nez v13, :cond_133

    .line 636
    move-object/from16 v0, p1

    iget-object v0, v0, Landroid/content/pm/PackageParser$Package;->packageName:Ljava/lang/String;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    invoke-static {v12, v0}, Lmiui/content/pm/ExtraPackageManager;->isTrustedAppEntry(Ljava/util/jar/JarEntry;Ljava/lang/String;)Z

    move-result v18

    if-nez v18, :cond_a2

    .line 639
    const-string v18, "PackageParser"

    new-instance v19, Ljava/lang/StringBuilder;

    invoke-direct/range {v19 .. v19}, Ljava/lang/StringBuilder;-><init>()V

    const-string v20, "Package "

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    move-object/from16 v0, p1

    iget-object v0, v0, Landroid/content/pm/PackageParser$Package;->packageName:Ljava/lang/String;

    move-object/from16 v20, v0

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    const-string v20, " has no certificates at entry "

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual {v12}, Ljava/util/jar/JarEntry;->getName()Ljava/lang/String;

    move-result-object v20

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    const-string v20, "; ignoring!"

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    invoke-static/range {v18 .. v19}, Landroid/util/Slog;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 642
    invoke-virtual {v11}, Ljava/util/jar/JarFile;->close()V

    .line 643
    const/16 v18, -0x67

    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Landroid/content/pm/PackageParser;->mParseError:I

    .line 644
    const/16 v18, 0x0

    goto/16 :goto_96

    .line 645
    :cond_133
    if-nez v4, :cond_138

    .line 646
    move-object v4, v13

    goto/16 :goto_a2

    .line 649
    :cond_138
    const/4 v8, 0x0

    .local v8, i:I
    :goto_139
    array-length v0, v4

    move/from16 v18, v0

    move/from16 v0, v18

    if-ge v8, v0, :cond_a2

    .line 650
    const/4 v7, 0x0

    .line 651
    .local v7, found:Z
    const/4 v9, 0x0

    .local v9, j:I
    :goto_142
    array-length v0, v13

    move/from16 v18, v0

    move/from16 v0, v18

    if-ge v9, v0, :cond_158

    .line 652
    aget-object v18, v4, v8

    if-eqz v18, :cond_1a7

    aget-object v18, v4, v8

    aget-object v19, v13, v9

    invoke-virtual/range {v18 .. v19}, Ljava/security/cert/Certificate;->equals(Ljava/lang/Object;)Z

    move-result v18

    if-eqz v18, :cond_1a7

    .line 654
    const/4 v7, 0x1

    .line 658
    :cond_158
    if-eqz v7, :cond_166

    array-length v0, v4

    move/from16 v18, v0

    array-length v0, v13

    move/from16 v19, v0

    move/from16 v0, v18

    move/from16 v1, v19

    if-eq v0, v1, :cond_1aa

    .line 659
    :cond_166
    const-string v18, "PackageParser"

    new-instance v19, Ljava/lang/StringBuilder;

    invoke-direct/range {v19 .. v19}, Ljava/lang/StringBuilder;-><init>()V

    const-string v20, "Package "

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    move-object/from16 v0, p1

    iget-object v0, v0, Landroid/content/pm/PackageParser$Package;->packageName:Ljava/lang/String;

    move-object/from16 v20, v0

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    const-string v20, " has mismatched certificates at entry "

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual {v12}, Ljava/util/jar/JarEntry;->getName()Ljava/lang/String;

    move-result-object v20

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    const-string v20, "; ignoring!"

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    invoke-static/range {v18 .. v19}, Landroid/util/Slog;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 662
    invoke-virtual {v11}, Ljava/util/jar/JarFile;->close()V

    .line 663
    const/16 v18, -0x68

    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Landroid/content/pm/PackageParser;->mParseError:I

    .line 664
    const/16 v18, 0x0

    goto/16 :goto_96

    .line 651
    :cond_1a7
    add-int/lit8 v9, v9, 0x1

    goto :goto_142

    .line 649
    :cond_1aa
    add-int/lit8 v8, v8, 0x1

    goto :goto_139

    .line 670
    .end local v6           #entries:Ljava/util/Enumeration;,"Ljava/util/Enumeration<Ljava/util/jar/JarEntry;>;"
    .end local v7           #found:Z
    .end local v8           #i:I
    .end local v9           #j:I
    .end local v12           #je:Ljava/util/jar/JarEntry;
    .end local v13           #localCerts:[Ljava/security/cert/Certificate;
    .end local v14           #manifest:Ljava/util/jar/Manifest;
    .end local v15           #name:Ljava/lang/String;
    :cond_1ad
    invoke-virtual {v11}, Ljava/util/jar/JarFile;->close()V

    .line 672
    sget-object v19, Landroid/content/pm/PackageParser;->mSync:Ljava/lang/Object;

    monitor-enter v19
    :try_end_1b3
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_9a .. :try_end_1b3} :catch_1e9
    .catch Ljava/io/IOException; {:try_start_9a .. :try_end_1b3} :catch_248
    .catch Ljava/lang/RuntimeException; {:try_start_9a .. :try_end_1b3} :catch_277

    .line 673
    :try_start_1b3
    sput-object v17, Landroid/content/pm/PackageParser;->mReadBuffer:Ljava/lang/ref/WeakReference;

    .line 674
    monitor-exit v19
    :try_end_1b6
    .catchall {:try_start_1b3 .. :try_end_1b6} :catchall_1e6

    .line 676
    if-eqz v4, :cond_218

    :try_start_1b8
    array-length v0, v4

    move/from16 v18, v0

    if-lez v18, :cond_218

    .line 677
    array-length v2, v4

    .line 678
    .local v2, N:I
    array-length v0, v4

    move/from16 v18, v0

    move/from16 v0, v18

    new-array v0, v0, [Landroid/content/pm/Signature;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    move-object/from16 v1, p1

    iput-object v0, v1, Landroid/content/pm/PackageParser$Package;->mSignatures:[Landroid/content/pm/Signature;

    .line 679
    const/4 v8, 0x0

    .restart local v8       #i:I
    :goto_1ce
    if-ge v8, v2, :cond_2a6

    .line 680
    move-object/from16 v0, p1

    iget-object v0, v0, Landroid/content/pm/PackageParser$Package;->mSignatures:[Landroid/content/pm/Signature;

    move-object/from16 v18, v0

    new-instance v19, Landroid/content/pm/Signature;

    aget-object v20, v4, v8

    invoke-virtual/range {v20 .. v20}, Ljava/security/cert/Certificate;->getEncoded()[B

    move-result-object v20

    invoke-direct/range {v19 .. v20}, Landroid/content/pm/Signature;-><init>([B)V

    aput-object v19, v18, v8
    :try_end_1e3
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_1b8 .. :try_end_1e3} :catch_1e9
    .catch Ljava/io/IOException; {:try_start_1b8 .. :try_end_1e3} :catch_248
    .catch Ljava/lang/RuntimeException; {:try_start_1b8 .. :try_end_1e3} :catch_277

    .line 679
    add-int/lit8 v8, v8, 0x1

    goto :goto_1ce

    .line 674
    .end local v2           #N:I
    .end local v8           #i:I
    :catchall_1e6
    move-exception v18

    :try_start_1e7
    monitor-exit v19
    :try_end_1e8
    .catchall {:try_start_1e7 .. :try_end_1e8} :catchall_1e6

    :try_start_1e8
    throw v18
    :try_end_1e9
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_1e8 .. :try_end_1e9} :catch_1e9
    .catch Ljava/io/IOException; {:try_start_1e8 .. :try_end_1e9} :catch_248
    .catch Ljava/lang/RuntimeException; {:try_start_1e8 .. :try_end_1e9} :catch_277

    .line 689
    .end local v4           #certs:[Ljava/security/cert/Certificate;
    .end local v11           #jarFile:Ljava/util/jar/JarFile;
    :catch_1e9
    move-exception v5

    .line 690
    .local v5, e:Ljava/security/cert/CertificateEncodingException;
    const-string v18, "PackageParser"

    new-instance v19, Ljava/lang/StringBuilder;

    invoke-direct/range {v19 .. v19}, Ljava/lang/StringBuilder;-><init>()V

    const-string v20, "Exception reading "

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/content/pm/PackageParser;->mArchiveSourcePath:Ljava/lang/String;

    move-object/from16 v20, v0

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-static {v0, v1, v5}, Landroid/util/Slog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 691
    const/16 v18, -0x69

    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Landroid/content/pm/PackageParser;->mParseError:I

    .line 692
    const/16 v18, 0x0

    goto/16 :goto_96

    .line 684
    .end local v5           #e:Ljava/security/cert/CertificateEncodingException;
    .restart local v4       #certs:[Ljava/security/cert/Certificate;
    .restart local v11       #jarFile:Ljava/util/jar/JarFile;
    :cond_218
    :try_start_218
    const-string v18, "PackageParser"

    new-instance v19, Ljava/lang/StringBuilder;

    invoke-direct/range {v19 .. v19}, Ljava/lang/StringBuilder;-><init>()V

    const-string v20, "Package "

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    move-object/from16 v0, p1

    iget-object v0, v0, Landroid/content/pm/PackageParser$Package;->packageName:Ljava/lang/String;

    move-object/from16 v20, v0

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    const-string v20, " has no certificates; ignoring!"

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    invoke-static/range {v18 .. v19}, Landroid/util/Slog;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 686
    const/16 v18, -0x67

    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Landroid/content/pm/PackageParser;->mParseError:I
    :try_end_244
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_218 .. :try_end_244} :catch_1e9
    .catch Ljava/io/IOException; {:try_start_218 .. :try_end_244} :catch_248
    .catch Ljava/lang/RuntimeException; {:try_start_218 .. :try_end_244} :catch_277

    .line 687
    const/16 v18, 0x0

    goto/16 :goto_96

    .line 693
    .end local v4           #certs:[Ljava/security/cert/Certificate;
    .end local v11           #jarFile:Ljava/util/jar/JarFile;
    :catch_248
    move-exception v5

    .line 694
    .local v5, e:Ljava/io/IOException;
    const-string v18, "PackageParser"

    new-instance v19, Ljava/lang/StringBuilder;

    invoke-direct/range {v19 .. v19}, Ljava/lang/StringBuilder;-><init>()V

    const-string v20, "Exception reading "

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/content/pm/PackageParser;->mArchiveSourcePath:Ljava/lang/String;

    move-object/from16 v20, v0

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-static {v0, v1, v5}, Landroid/util/Slog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 695
    const/16 v18, -0x69

    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Landroid/content/pm/PackageParser;->mParseError:I

    .line 696
    const/16 v18, 0x0

    goto/16 :goto_96

    .line 697
    .end local v5           #e:Ljava/io/IOException;
    :catch_277
    move-exception v5

    .line 698
    .local v5, e:Ljava/lang/RuntimeException;
    const-string v18, "PackageParser"

    new-instance v19, Ljava/lang/StringBuilder;

    invoke-direct/range {v19 .. v19}, Ljava/lang/StringBuilder;-><init>()V

    const-string v20, "Exception reading "

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/content/pm/PackageParser;->mArchiveSourcePath:Ljava/lang/String;

    move-object/from16 v20, v0

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-static {v0, v1, v5}, Landroid/util/Slog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 699
    const/16 v18, -0x66

    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Landroid/content/pm/PackageParser;->mParseError:I

    .line 700
    const/16 v18, 0x0

    goto/16 :goto_96

    .line 703
    .end local v5           #e:Ljava/lang/RuntimeException;
    .restart local v2       #N:I
    .restart local v4       #certs:[Ljava/security/cert/Certificate;
    .restart local v8       #i:I
    .restart local v11       #jarFile:Ljava/util/jar/JarFile;
    :cond_2a6
    const/16 v18, 0x1

    goto/16 :goto_96
.end method

.method public getParseError()I
    .registers 2

    .prologue
    .line 464
    iget v0, p0, Landroid/content/pm/PackageParser;->mParseError:I

    return v0
.end method

.method public parsePackage(Ljava/io/File;Ljava/lang/String;Landroid/util/DisplayMetrics;I)Landroid/content/pm/PackageParser$Package;
    .registers 37
    .parameter "sourceFile"
    .parameter "destCodePath"
    .parameter "metrics"
    .parameter "flags"
    .annotation build Landroid/annotation/MiuiHook;
        value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->CHANGE_CODE:Landroid/annotation/MiuiHook$MiuiHookType;
    .end annotation

    .prologue
    .line 470
    const/4 v6, 0x1

    move-object/from16 v0, p0

    iput v6, v0, Landroid/content/pm/PackageParser;->mParseError:I

    .line 472
    invoke-virtual/range {p1 .. p1}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v6

    move-object/from16 v0, p0

    iput-object v6, v0, Landroid/content/pm/PackageParser;->mArchiveSourcePath:Ljava/lang/String;

    .line 473
    invoke-virtual/range {p1 .. p1}, Ljava/io/File;->isFile()Z

    move-result v6

    if-nez v6, :cond_38

    .line 474
    const-string v6, "PackageParser"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Skipping dir: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    move-object/from16 v0, p0

    iget-object v8, v0, Landroid/content/pm/PackageParser;->mArchiveSourcePath:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Slog;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 475
    const/16 v6, -0x64

    move-object/from16 v0, p0

    iput v6, v0, Landroid/content/pm/PackageParser;->mParseError:I

    .line 476
    const/16 v30, 0x0

    .line 559
    :goto_37
    return-object v30

    .line 478
    :cond_38
    invoke-virtual/range {p1 .. p1}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Landroid/content/pm/PackageParser;->isPackageFilename(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_6f

    and-int/lit8 v6, p4, 0x4

    if-eqz v6, :cond_6f

    .line 480
    and-int/lit8 v6, p4, 0x1

    if-nez v6, :cond_66

    .line 483
    const-string v6, "PackageParser"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Skipping non-package file: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    move-object/from16 v0, p0

    iget-object v8, v0, Landroid/content/pm/PackageParser;->mArchiveSourcePath:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Slog;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 485
    :cond_66
    const/16 v6, -0x64

    move-object/from16 v0, p0

    iput v6, v0, Landroid/content/pm/PackageParser;->mParseError:I

    .line 486
    const/16 v30, 0x0

    goto :goto_37

    .line 492
    :cond_6f
    const/16 v29, 0x0

    .line 493
    .local v29, parser:Landroid/content/res/XmlResourceParser;
    const/16 v24, 0x0

    .line 494
    .local v24, assmgr:Landroid/content/res/AssetManager;
    const/16 v31, 0x0

    .line 495
    .local v31, res:Landroid/content/res/Resources;
    const/16 v23, 0x1

    .line 497
    .local v23, assetError:Z
    :try_start_77
    new-instance v5, Landroid/content/res/AssetManager;

    invoke-direct {v5}, Landroid/content/res/AssetManager;-><init>()V
    :try_end_7c
    .catch Ljava/lang/Exception; {:try_start_77 .. :try_end_7c} :catch_1a1

    .line 498
    .end local v24           #assmgr:Landroid/content/res/AssetManager;
    .local v5, assmgr:Landroid/content/res/AssetManager;
    :try_start_7c
    move-object/from16 v0, p0

    iget-object v6, v0, Landroid/content/pm/PackageParser;->mArchiveSourcePath:Ljava/lang/String;

    invoke-virtual {v5, v6}, Landroid/content/res/AssetManager;->addAssetPath(Ljava/lang/String;)I

    move-result v25

    .line 499
    .local v25, cookie:I
    if-eqz v25, :cond_c3

    .line 500
    const/4 v6, 0x0

    move-object/from16 v0, p3

    invoke-static {v5, v0, v6}, Landroid/content/res/MiuiClassFactory;->newResources(Landroid/content/res/AssetManager;Landroid/util/DisplayMetrics;Landroid/content/res/Configuration;)Landroid/content/res/Resources;

    move-result-object v31

    .line 501
    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    const/4 v12, 0x0

    const/4 v13, 0x0

    const/4 v14, 0x0

    const/4 v15, 0x0

    const/16 v16, 0x0

    const/16 v17, 0x0

    const/16 v18, 0x0

    const/16 v19, 0x0

    const/16 v20, 0x0

    const/16 v21, 0x0

    sget v22, Landroid/os/Build$VERSION;->RESOURCES_SDK_INT:I

    invoke-virtual/range {v5 .. v22}, Landroid/content/res/AssetManager;->setConfiguration(IILjava/lang/String;IIIIIIIIIIIIII)V

    .line 503
    const-string v6, "AndroidManifest.xml"

    move/from16 v0, v25

    invoke-virtual {v5, v0, v6}, Landroid/content/res/AssetManager;->openXmlResourceParser(ILjava/lang/String;)Landroid/content/res/XmlResourceParser;
    :try_end_af
    .catch Ljava/lang/Exception; {:try_start_7c .. :try_end_af} :catch_e0

    move-result-object v29

    .line 504
    const/16 v23, 0x0

    .line 512
    .end local v25           #cookie:I
    :goto_b2
    if-eqz v23, :cond_100

    .line 513
    if-eqz v5, :cond_b9

    invoke-virtual {v5}, Landroid/content/res/AssetManager;->close()V

    .line 514
    :cond_b9
    const/16 v6, -0x65

    move-object/from16 v0, p0

    iput v6, v0, Landroid/content/pm/PackageParser;->mParseError:I

    .line 515
    const/16 v30, 0x0

    goto/16 :goto_37

    .line 506
    .restart local v25       #cookie:I
    :cond_c3
    :try_start_c3
    const-string v6, "PackageParser"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Failed adding asset path:"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    move-object/from16 v0, p0

    iget-object v8, v0, Landroid/content/pm/PackageParser;->mArchiveSourcePath:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Slog;->w(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_df
    .catch Ljava/lang/Exception; {:try_start_c3 .. :try_end_df} :catch_e0

    goto :goto_b2

    .line 508
    .end local v25           #cookie:I
    :catch_e0
    move-exception v26

    .line 509
    .local v26, e:Ljava/lang/Exception;
    :goto_e1
    const-string v6, "PackageParser"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Unable to read AndroidManifest.xml of "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    move-object/from16 v0, p0

    iget-object v8, v0, Landroid/content/pm/PackageParser;->mArchiveSourcePath:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    move-object/from16 v0, v26

    invoke-static {v6, v7, v0}, Landroid/util/Slog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_b2

    .line 517
    .end local v26           #e:Ljava/lang/Exception;
    :cond_100
    const/4 v6, 0x1

    new-array v0, v6, [Ljava/lang/String;

    move-object/from16 v28, v0

    .line 518
    .local v28, errorText:[Ljava/lang/String;
    const/16 v30, 0x0

    .line 519
    .local v30, pkg:Landroid/content/pm/PackageParser$Package;
    const/16 v27, 0x0

    .line 522
    .local v27, errorException:Ljava/lang/Exception;
    :try_start_109
    move-object/from16 v0, p0

    move-object/from16 v1, v31

    move-object/from16 v2, v29

    move/from16 v3, p4

    move-object/from16 v4, v28

    invoke-direct {v0, v1, v2, v3, v4}, Landroid/content/pm/PackageParser;->parsePackage(Landroid/content/res/Resources;Landroid/content/res/XmlResourceParser;I[Ljava/lang/String;)Landroid/content/pm/PackageParser$Package;
    :try_end_116
    .catch Ljava/lang/Exception; {:try_start_109 .. :try_end_116} :catch_14a

    move-result-object v30

    .line 529
    :goto_117
    if-nez v30, :cond_186

    .line 532
    move-object/from16 v0, p0

    iget-boolean v6, v0, Landroid/content/pm/PackageParser;->mOnlyCoreApps:Z

    if-eqz v6, :cond_126

    move-object/from16 v0, p0

    iget v6, v0, Landroid/content/pm/PackageParser;->mParseError:I

    const/4 v7, 0x1

    if-eq v6, v7, :cond_140

    .line 533
    :cond_126
    if-eqz v27, :cond_154

    .line 534
    const-string v6, "PackageParser"

    move-object/from16 v0, p0

    iget-object v7, v0, Landroid/content/pm/PackageParser;->mArchiveSourcePath:Ljava/lang/String;

    move-object/from16 v0, v27

    invoke-static {v6, v7, v0}, Landroid/util/Slog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 540
    :goto_133
    move-object/from16 v0, p0

    iget v6, v0, Landroid/content/pm/PackageParser;->mParseError:I

    const/4 v7, 0x1

    if-ne v6, v7, :cond_140

    .line 541
    const/16 v6, -0x6c

    move-object/from16 v0, p0

    iput v6, v0, Landroid/content/pm/PackageParser;->mParseError:I

    .line 544
    :cond_140
    invoke-interface/range {v29 .. v29}, Landroid/content/res/XmlResourceParser;->close()V

    .line 545
    invoke-virtual {v5}, Landroid/content/res/AssetManager;->close()V

    .line 546
    const/16 v30, 0x0

    goto/16 :goto_37

    .line 523
    :catch_14a
    move-exception v26

    .line 524
    .restart local v26       #e:Ljava/lang/Exception;
    move-object/from16 v27, v26

    .line 525
    const/16 v6, -0x66

    move-object/from16 v0, p0

    iput v6, v0, Landroid/content/pm/PackageParser;->mParseError:I

    goto :goto_117

    .line 536
    .end local v26           #e:Ljava/lang/Exception;
    :cond_154
    const-string v6, "PackageParser"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p0

    iget-object v8, v0, Landroid/content/pm/PackageParser;->mArchiveSourcePath:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, " (at "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-interface/range {v29 .. v29}, Landroid/content/res/XmlResourceParser;->getPositionDescription()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "): "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const/4 v8, 0x0

    aget-object v8, v28, v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Slog;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_133

    .line 549
    :cond_186
    invoke-interface/range {v29 .. v29}, Landroid/content/res/XmlResourceParser;->close()V

    .line 550
    invoke-virtual {v5}, Landroid/content/res/AssetManager;->close()V

    .line 553
    move-object/from16 v0, p2

    move-object/from16 v1, v30

    iput-object v0, v1, Landroid/content/pm/PackageParser$Package;->mPath:Ljava/lang/String;

    .line 554
    move-object/from16 v0, p0

    iget-object v6, v0, Landroid/content/pm/PackageParser;->mArchiveSourcePath:Ljava/lang/String;

    move-object/from16 v0, v30

    iput-object v6, v0, Landroid/content/pm/PackageParser$Package;->mScanPath:Ljava/lang/String;

    .line 557
    const/4 v6, 0x0

    move-object/from16 v0, v30

    iput-object v6, v0, Landroid/content/pm/PackageParser$Package;->mSignatures:[Landroid/content/pm/Signature;

    goto/16 :goto_37

    .line 508
    .end local v5           #assmgr:Landroid/content/res/AssetManager;
    .end local v27           #errorException:Ljava/lang/Exception;
    .end local v28           #errorText:[Ljava/lang/String;
    .end local v30           #pkg:Landroid/content/pm/PackageParser$Package;
    .restart local v24       #assmgr:Landroid/content/res/AssetManager;
    :catch_1a1
    move-exception v26

    move-object/from16 v5, v24

    .end local v24           #assmgr:Landroid/content/res/AssetManager;
    .restart local v5       #assmgr:Landroid/content/res/AssetManager;
    goto/16 :goto_e1
.end method

.method public setOnlyCoreApps(Z)V
    .registers 2
    .parameter "onlyCoreApps"

    .prologue
    .line 243
    iput-boolean p1, p0, Landroid/content/pm/PackageParser;->mOnlyCoreApps:Z

    .line 244
    return-void
.end method

.method public setSeparateProcesses([Ljava/lang/String;)V
    .registers 2
    .parameter "procs"

    .prologue
    .line 239
    iput-object p1, p0, Landroid/content/pm/PackageParser;->mSeparateProcesses:[Ljava/lang/String;

    .line 240
    return-void
.end method
