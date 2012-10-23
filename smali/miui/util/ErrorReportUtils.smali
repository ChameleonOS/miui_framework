.class public Lmiui/util/ErrorReportUtils;
.super Ljava/lang/Object;
.source "ErrorReportUtils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lmiui/util/ErrorReportUtils$Base64Coder;,
        Lmiui/util/ErrorReportUtils$CommonUtils;,
        Lmiui/util/ErrorReportUtils$ReportErrorTask;
    }
.end annotation


# static fields
.field public static final ANR_MAX_LINE_NUMBER:I = 0x12c

.field public static final ERROR_TYPE_ANR:Ljava/lang/String; = "anr"

.field public static final ERROR_TYPE_FC:Ljava/lang/String; = "fc"

.field public static final JSON_ANR_ACTIVITY:Ljava/lang/String; = "anr_activity"

.field public static final JSON_ANR_CAUSE:Ljava/lang/String; = "anr_cause"

.field public static final JSON_APP_VESION:Ljava/lang/String; = "app_version"

.field public static final JSON_BUILD_VERSION:Ljava/lang/String; = "build_version"

.field public static final JSON_DEVICE:Ljava/lang/String; = "device"

.field public static final JSON_ERROR_TYPE:Ljava/lang/String; = "error_type"

.field public static final JSON_EXCEPTION_CLASS:Ljava/lang/String; = "exception_class"

.field public static final JSON_EXCEPTION_SOURCE_METHOD:Ljava/lang/String; = "exception_source_method"

.field public static final JSON_NETWORK:Ljava/lang/String; = "network"

.field public static final JSON_PACKAGE_NAME:Ljava/lang/String; = "package_name"

.field public static final JSON_PLATFORM:Ljava/lang/String; = "platform"

.field public static final JSON_STACK_TRACK:Ljava/lang/String; = "stack_track"

.field private static final SALT_P1:Ljava/lang/String; = "8007236f-"

.field private static final SALT_P2:Ljava/lang/String; = "a2d6-4847-ac83-"

.field private static final SALT_P3:Ljava/lang/String; = "c49395ad6d65"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 38
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 187
    return-void
.end method

.method static synthetic access$000(Ljava/util/List;)Ljava/lang/String;
    .registers 2
    .parameter "x0"

    .prologue
    .line 38
    invoke-static {p0}, Lmiui/util/ErrorReportUtils;->getKeyFromParams(Ljava/util/List;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static getKeyFromParams(Ljava/util/List;)Ljava/lang/String;
    .registers 9
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/NameValuePair;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 137
    .local p0, nameValuePairs:Ljava/util/List;,"Ljava/util/List<Lorg/apache/http/NameValuePair;>;"
    new-instance v6, Lmiui/util/ErrorReportUtils$1;

    invoke-direct {v6}, Lmiui/util/ErrorReportUtils$1;-><init>()V

    invoke-static {p0, v6}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 144
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 145
    .local v3, keyBuilder:Ljava/lang/StringBuilder;
    const/4 v1, 0x1

    .line 146
    .local v1, isFirst:Z
    invoke-interface {p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, i$:Ljava/util/Iterator;
    :goto_12
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_3c

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lorg/apache/http/NameValuePair;

    .line 148
    .local v5, nvp:Lorg/apache/http/NameValuePair;
    if-nez v1, :cond_25

    .line 149
    const-string v6, "&"

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 152
    :cond_25
    invoke-interface {v5}, Lorg/apache/http/NameValuePair;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "="

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-interface {v5}, Lorg/apache/http/NameValuePair;->getValue()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 153
    const/4 v1, 0x0

    goto :goto_12

    .line 156
    .end local v5           #nvp:Lorg/apache/http/NameValuePair;
    :cond_3c
    const-string v6, "&"

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "8007236f-"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 157
    const-string v6, "a2d6-4847-ac83-"

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 158
    const-string v6, "c49395ad6d65"

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 160
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 161
    .local v2, key:Ljava/lang/String;
    invoke-static {v2}, Lmiui/util/ErrorReportUtils$CommonUtils;->getBytes(Ljava/lang/String;)[B

    move-result-object v4

    .line 162
    .local v4, keyBytes:[B
    new-instance v6, Ljava/lang/String;

    invoke-static {v4}, Lmiui/util/ErrorReportUtils$Base64Coder;->encode([B)[C

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/lang/String;-><init>([C)V

    invoke-static {v6}, Lmiui/util/ErrorReportUtils$CommonUtils;->getMd5Digest(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    return-object v6
.end method

.method public static isNetworkAvailable(Landroid/content/Context;)Z
    .registers 4
    .parameter "context"

    .prologue
    .line 77
    const-string v2, "connectivity"

    invoke-virtual {p0, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    .line 79
    .local v0, cm:Landroid/net/ConnectivityManager;
    invoke-virtual {v0}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v1

    .line 80
    .local v1, info:Landroid/net/NetworkInfo;
    if-eqz v1, :cond_16

    invoke-virtual {v1}, Landroid/net/NetworkInfo;->isAvailable()Z

    move-result v2

    if-eqz v2, :cond_16

    const/4 v2, 0x1

    :goto_15
    return v2

    :cond_16
    const/4 v2, 0x0

    goto :goto_15
.end method

.method public static isUserAllowed(Landroid/content/Context;)Z
    .registers 7
    .parameter "context"

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 70
    invoke-static {}, Lmiui/os/Build;->isDevelopmentVersion()Z

    move-result v4

    if-eqz v4, :cond_17

    move v1, v2

    .line 71
    .local v1, default_value:I
    :goto_9
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v4

    const-string/jumbo v5, "upload_log_pref"

    invoke-static {v4, v5, v1}, Landroid/provider/Settings$Secure;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v0

    .line 73
    .local v0, allow:I
    if-eqz v0, :cond_19

    :goto_16
    return v2

    .end local v0           #allow:I
    .end local v1           #default_value:I
    :cond_17
    move v1, v3

    .line 70
    goto :goto_9

    .restart local v0       #allow:I
    .restart local v1       #default_value:I
    :cond_19
    move v2, v3

    .line 73
    goto :goto_16
.end method

.method public static isWifiConnected(Landroid/content/Context;)Z
    .registers 5
    .parameter "context"

    .prologue
    const/4 v2, 0x1

    .line 84
    const-string v3, "connectivity"

    invoke-virtual {p0, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    .line 86
    .local v0, cm:Landroid/net/ConnectivityManager;
    invoke-virtual {v0}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v1

    .line 87
    .local v1, info:Landroid/net/NetworkInfo;
    if-eqz v1, :cond_16

    invoke-virtual {v1}, Landroid/net/NetworkInfo;->getType()I

    move-result v3

    if-ne v3, v2, :cond_16

    :goto_15
    return v2

    :cond_16
    const/4 v2, 0x0

    goto :goto_15
.end method

.method public static postErrorReport(Landroid/content/Context;Lorg/json/JSONObject;)Z
    .registers 4
    .parameter "context"
    .parameter "report"

    .prologue
    .line 62
    invoke-static {p0}, Lmiui/util/ErrorReportUtils;->isNetworkAvailable(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_13

    .line 63
    new-instance v1, Lmiui/util/ErrorReportUtils$ReportErrorTask;

    invoke-direct {v1, p1}, Lmiui/util/ErrorReportUtils$ReportErrorTask;-><init>(Lorg/json/JSONObject;)V

    const/4 v0, 0x0

    check-cast v0, [Ljava/lang/Void;

    invoke-virtual {v1, v0}, Lmiui/util/ErrorReportUtils$ReportErrorTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 64
    const/4 v0, 0x1

    .line 66
    :goto_12
    return v0

    :cond_13
    const/4 v0, 0x0

    goto :goto_12
.end method
