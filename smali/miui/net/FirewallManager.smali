.class public Lmiui/net/FirewallManager;
.super Ljava/lang/Object;
.source "FirewallManager.java"


# static fields
.field public static final ALARM_BOOT_COMPLETED_FLAG:I = 0x1

.field private static final DEBUG:Z = true

.field private static final LOG_TAG:Ljava/lang/String; = "FirewallService"

.field public static final SERVICE_NAME:Ljava/lang/String; = "miui.Firewall"

.field public static final SIM_CARD_SYNC_COMPLETED_FLAG:I = 0x2

.field private static sInstance:Lmiui/net/FirewallManager;


# instance fields
.field private mService:Lmiui/net/IFirewall;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 53
    new-instance v0, Lmiui/net/FirewallManager;

    invoke-direct {v0}, Lmiui/net/FirewallManager;-><init>()V

    sput-object v0, Lmiui/net/FirewallManager;->sInstance:Lmiui/net/FirewallManager;

    return-void
.end method

.method private constructor <init>()V
    .registers 1

    .prologue
    .line 58
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 59
    invoke-direct {p0}, Lmiui/net/FirewallManager;->ensureService()V

    .line 60
    return-void
.end method

.method public static checkAccessControl(Landroid/app/Activity;Landroid/content/ContentResolver;Ljava/lang/String;Landroid/content/pm/PackageManager;Landroid/app/IApplicationThread;Landroid/os/IBinder;Ljava/lang/String;)V
    .registers 22
    .parameter "parent"
    .parameter "resolver"
    .parameter "packageName"
    .parameter "pm"
    .parameter "thread"
    .parameter "token"
    .parameter "id"

    .prologue
    .line 266
    if-eqz p0, :cond_3

    .line 295
    :cond_2
    :goto_2
    return-void

    .line 268
    :cond_3
    const/4 v2, 0x1

    const-string v3, "access_control_lock_enabled"

    const/4 v5, 0x0

    move-object/from16 v0, p1

    invoke-static {v0, v3, v5}, Landroid/provider/Settings$Secure;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v3

    if-ne v2, v3, :cond_2

    .line 273
    const/4 v14, 0x0

    .line 275
    .local v14, info:Landroid/content/pm/ApplicationInfo;
    const/4 v2, 0x0

    :try_start_11
    move-object/from16 v0, p3

    move-object/from16 v1, p2

    invoke-virtual {v0, v1, v2}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    :try_end_18
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_11 .. :try_end_18} :catch_59

    move-result-object v14

    .line 279
    :goto_19
    if-eqz v14, :cond_2

    iget v2, v14, Landroid/content/pm/ApplicationInfo;->flags:I

    const/high16 v3, -0x8000

    and-int/2addr v2, v3

    const/high16 v3, -0x8000

    if-ne v2, v3, :cond_2

    .line 281
    invoke-static {}, Lmiui/net/FirewallManager;->getInstance()Lmiui/net/FirewallManager;

    move-result-object v2

    move-object/from16 v0, p2

    invoke-virtual {v2, v0}, Lmiui/net/FirewallManager;->checkAccessControlPass(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 283
    new-instance v4, Landroid/content/Intent;

    const-string v2, "android.app.action.CONFIRM_ACCESS_CONTROL"

    invoke-direct {v4, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 284
    .local v4, intent:Landroid/content/Intent;
    const-string v2, "android.intent.extra.shortcut.NAME"

    move-object/from16 v0, p2

    invoke-virtual {v4, v2, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 287
    :try_start_3e
    invoke-static {}, Landroid/app/ActivityManagerNative;->getDefault()Landroid/app/IActivityManager;

    move-result-object v2

    move-object/from16 v0, p1

    invoke-virtual {v4, v0}, Landroid/content/Intent;->resolveTypeIfNeeded(Landroid/content/ContentResolver;)Ljava/lang/String;

    move-result-object v5

    const/4 v8, -0x1

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    const/4 v12, 0x0

    move-object/from16 v3, p4

    move-object/from16 v6, p5

    move-object/from16 v7, p6

    invoke-interface/range {v2 .. v12}, Landroid/app/IActivityManager;->startActivity(Landroid/app/IApplicationThread;Landroid/content/Intent;Ljava/lang/String;Landroid/os/IBinder;Ljava/lang/String;IILjava/lang/String;Landroid/os/ParcelFileDescriptor;Landroid/os/Bundle;)I
    :try_end_56
    .catch Landroid/os/RemoteException; {:try_start_3e .. :try_end_56} :catch_57

    goto :goto_2

    .line 291
    :catch_57
    move-exception v2

    goto :goto_2

    .line 276
    .end local v4           #intent:Landroid/content/Intent;
    :catch_59
    move-exception v13

    .line 277
    .local v13, e:Landroid/content/pm/PackageManager$NameNotFoundException;
    const/4 v14, 0x0

    goto :goto_19
.end method

.method public static decodeApnSetting(Ljava/lang/String;)Lcom/android/internal/telephony/ApnSetting;
    .registers 21
    .parameter "data"

    .prologue
    .line 246
    invoke-static/range {p0 .. p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_8

    .line 247
    const/4 v1, 0x0

    .line 261
    :goto_7
    return-object v1

    .line 250
    :cond_8
    const-string v2, "\\s*,\\s*"

    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v19

    .line 251
    .local v19, a:[Ljava/lang/String;
    move-object/from16 v0, v19

    array-length v2, v0

    const/16 v3, 0x10

    if-ge v2, v3, :cond_19

    .line 252
    const/4 v1, 0x0

    goto :goto_7

    .line 255
    :cond_19
    new-instance v1, Lcom/android/internal/telephony/ApnSetting;

    const/4 v2, 0x0

    aget-object v2, v19, v2

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    const/4 v3, 0x1

    aget-object v3, v19, v3

    const/4 v4, 0x2

    aget-object v4, v19, v4

    const/4 v5, 0x3

    aget-object v5, v19, v5

    const/4 v6, 0x4

    aget-object v6, v19, v6

    const/4 v7, 0x5

    aget-object v7, v19, v7

    const/4 v8, 0x6

    aget-object v8, v19, v8

    const/4 v9, 0x7

    aget-object v9, v19, v9

    const/16 v10, 0x8

    aget-object v10, v19, v10

    const/16 v11, 0x9

    aget-object v11, v19, v11

    const/16 v12, 0xa

    aget-object v12, v19, v12

    const/16 v13, 0xb

    aget-object v13, v19, v13

    invoke-static {v13}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v13

    const/16 v14, 0xc

    aget-object v14, v19, v14

    const-string v15, "\\s*\\|\\s*"

    invoke-virtual {v14, v15}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v14

    const/16 v15, 0xd

    aget-object v15, v19, v15

    const/16 v16, 0xe

    aget-object v16, v19, v16

    const/16 v17, 0xf

    aget-object v17, v19, v17

    invoke-static/range {v17 .. v17}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v17

    const/16 v18, 0x10

    aget-object v18, v19, v18

    invoke-static/range {v18 .. v18}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v18

    invoke-direct/range {v1 .. v18}, Lcom/android/internal/telephony/ApnSetting;-><init>(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V

    .line 261
    .local v1, apn:Lcom/android/internal/telephony/ApnSetting;
    goto :goto_7
.end method

.method public static encodeApnSetting(Lcom/android/internal/telephony/ApnSetting;)Ljava/lang/String;
    .registers 5
    .parameter "apn"

    .prologue
    const/16 v3, 0x2c

    .line 215
    if-nez p0, :cond_6

    .line 216
    const/4 v0, 0x0

    .line 219
    :goto_5
    return-object v0

    :cond_6
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget v1, p0, Lcom/android/internal/telephony/ApnSetting;->id:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/android/internal/telephony/ApnSetting;->numeric:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/android/internal/telephony/ApnSetting;->carrier:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/android/internal/telephony/ApnSetting;->apn:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/android/internal/telephony/ApnSetting;->proxy:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/android/internal/telephony/ApnSetting;->port:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/android/internal/telephony/ApnSetting;->mmsc:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/android/internal/telephony/ApnSetting;->mmsProxy:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/android/internal/telephony/ApnSetting;->mmsPort:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/android/internal/telephony/ApnSetting;->user:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/android/internal/telephony/ApnSetting;->password:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/android/internal/telephony/ApnSetting;->authType:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "|"

    iget-object v2, p0, Lcom/android/internal/telephony/ApnSetting;->types:[Ljava/lang/String;

    invoke-static {v1, v2}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/android/internal/telephony/ApnSetting;->protocol:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/android/internal/telephony/ApnSetting;->roamingProtocol:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Lcom/android/internal/telephony/ApnSetting;->carrierEnabled:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/android/internal/telephony/ApnSetting;->bearer:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_5
.end method

.method private ensureService()V
    .registers 3

    .prologue
    .line 66
    iget-object v0, p0, Lmiui/net/FirewallManager;->mService:Lmiui/net/IFirewall;

    if-nez v0, :cond_15

    .line 67
    const-class v1, Lmiui/net/FirewallManager;

    monitor-enter v1

    .line 68
    :try_start_7
    const-string/jumbo v0, "miui.Firewall"

    invoke-static {v0}, Landroid/os/ServiceManager;->getService(Ljava/lang/String;)Landroid/os/IBinder;

    move-result-object v0

    invoke-static {v0}, Lmiui/net/IFirewall$Stub;->asInterface(Landroid/os/IBinder;)Lmiui/net/IFirewall;

    move-result-object v0

    iput-object v0, p0, Lmiui/net/FirewallManager;->mService:Lmiui/net/IFirewall;

    .line 69
    monitor-exit v1

    .line 71
    :cond_15
    return-void

    .line 69
    :catchall_16
    move-exception v0

    monitor-exit v1
    :try_end_18
    .catchall {:try_start_7 .. :try_end_18} :catchall_16

    throw v0
.end method

.method public static getInstance()Lmiui/net/FirewallManager;
    .registers 1

    .prologue
    .line 79
    sget-object v0, Lmiui/net/FirewallManager;->sInstance:Lmiui/net/FirewallManager;

    return-object v0
.end method

.method public static isAccessControlProtected(Landroid/content/Context;Ljava/lang/String;)Z
    .registers 8
    .parameter "context"
    .parameter "packageName"

    .prologue
    const/high16 v5, -0x8000

    const/4 v2, 0x0

    .line 298
    const/4 v1, 0x0

    .line 300
    .local v1, info:Landroid/content/pm/ApplicationInfo;
    :try_start_4
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v3, p1, v4}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    :try_end_c
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_4 .. :try_end_c} :catch_16

    move-result-object v1

    .line 304
    if-eqz v1, :cond_15

    iget v3, v1, Landroid/content/pm/ApplicationInfo;->flags:I

    and-int/2addr v3, v5

    if-ne v3, v5, :cond_15

    const/4 v2, 0x1

    :cond_15
    :goto_15
    return v2

    .line 301
    :catch_16
    move-exception v0

    .line 302
    .local v0, e:Landroid/content/pm/PackageManager$NameNotFoundException;
    goto :goto_15
.end method


# virtual methods
.method public addAccessControlPass(Ljava/lang/String;)V
    .registers 3
    .parameter "packageName"

    .prologue
    .line 145
    :try_start_0
    invoke-direct {p0}, Lmiui/net/FirewallManager;->ensureService()V

    .line 146
    iget-object v0, p0, Lmiui/net/FirewallManager;->mService:Lmiui/net/IFirewall;

    if-eqz v0, :cond_c

    .line 147
    iget-object v0, p0, Lmiui/net/FirewallManager;->mService:Lmiui/net/IFirewall;

    invoke-interface {v0, p1}, Lmiui/net/IFirewall;->addAccessControlPass(Ljava/lang/String;)V
    :try_end_c
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_c} :catch_d

    .line 151
    :cond_c
    :goto_c
    return-void

    .line 149
    :catch_d
    move-exception v0

    goto :goto_c
.end method

.method public addOneShotFlag(I)V
    .registers 3
    .parameter "flag"

    .prologue
    .line 158
    :try_start_0
    invoke-direct {p0}, Lmiui/net/FirewallManager;->ensureService()V

    .line 159
    iget-object v0, p0, Lmiui/net/FirewallManager;->mService:Lmiui/net/IFirewall;

    if-eqz v0, :cond_e

    if-lez p1, :cond_e

    .line 160
    iget-object v0, p0, Lmiui/net/FirewallManager;->mService:Lmiui/net/IFirewall;

    invoke-interface {v0, p1}, Lmiui/net/IFirewall;->addOneShotFlag(I)V
    :try_end_e
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_e} :catch_f

    .line 164
    :cond_e
    :goto_e
    return-void

    .line 162
    :catch_f
    move-exception v0

    goto :goto_e
.end method

.method public checkAccessControlPass(Ljava/lang/String;)Z
    .registers 4
    .parameter "packageName"

    .prologue
    .line 196
    const/4 v0, 0x0

    .line 198
    .local v0, retval:Z
    :try_start_1
    invoke-direct {p0}, Lmiui/net/FirewallManager;->ensureService()V

    .line 199
    iget-object v1, p0, Lmiui/net/FirewallManager;->mService:Lmiui/net/IFirewall;

    if-eqz v1, :cond_e

    .line 200
    iget-object v1, p0, Lmiui/net/FirewallManager;->mService:Lmiui/net/IFirewall;

    invoke-interface {v1, p1}, Lmiui/net/IFirewall;->checkAccessControlPass(Ljava/lang/String;)Z
    :try_end_d
    .catch Landroid/os/RemoteException; {:try_start_1 .. :try_end_d} :catch_f

    move-result v0

    .line 204
    :cond_e
    :goto_e
    return v0

    .line 202
    :catch_f
    move-exception v1

    goto :goto_e
.end method

.method public getOneShotFlag(I)Z
    .registers 3
    .parameter "flag"

    .prologue
    .line 171
    :try_start_0
    invoke-direct {p0}, Lmiui/net/FirewallManager;->ensureService()V

    .line 172
    iget-object v0, p0, Lmiui/net/FirewallManager;->mService:Lmiui/net/IFirewall;

    if-eqz v0, :cond_11

    if-lez p1, :cond_11

    .line 173
    iget-object v0, p0, Lmiui/net/FirewallManager;->mService:Lmiui/net/IFirewall;

    invoke-interface {v0, p1}, Lmiui/net/IFirewall;->getOneShotFlag(I)Z
    :try_end_e
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_e} :catch_10

    move-result v0

    .line 177
    :goto_f
    return v0

    .line 175
    :catch_10
    move-exception v0

    .line 177
    :cond_11
    const/4 v0, 0x0

    goto :goto_f
.end method

.method public onDataConnected(ILjava/lang/String;Ljava/lang/String;)V
    .registers 5
    .parameter "networkType"
    .parameter "key"
    .parameter "ifname"

    .prologue
    .line 115
    :try_start_0
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_12

    .line 116
    invoke-direct {p0}, Lmiui/net/FirewallManager;->ensureService()V

    .line 117
    iget-object v0, p0, Lmiui/net/FirewallManager;->mService:Lmiui/net/IFirewall;

    if-eqz v0, :cond_12

    .line 118
    iget-object v0, p0, Lmiui/net/FirewallManager;->mService:Lmiui/net/IFirewall;

    invoke-interface {v0, p1, p2, p3}, Lmiui/net/IFirewall;->onDataConnected(ILjava/lang/String;Ljava/lang/String;)V
    :try_end_12
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_12} :catch_13

    .line 123
    :cond_12
    :goto_12
    return-void

    .line 121
    :catch_13
    move-exception v0

    goto :goto_12
.end method

.method public onDataDisconnected(ILjava/lang/String;)V
    .registers 4
    .parameter "networkType"
    .parameter "key"

    .prologue
    .line 130
    :try_start_0
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_12

    .line 131
    invoke-direct {p0}, Lmiui/net/FirewallManager;->ensureService()V

    .line 132
    iget-object v0, p0, Lmiui/net/FirewallManager;->mService:Lmiui/net/IFirewall;

    if-eqz v0, :cond_12

    .line 133
    iget-object v0, p0, Lmiui/net/FirewallManager;->mService:Lmiui/net/IFirewall;

    invoke-interface {v0, p1, p2}, Lmiui/net/IFirewall;->onDataDisconnected(ILjava/lang/String;)V
    :try_end_12
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_12} :catch_13

    .line 138
    :cond_12
    :goto_12
    return-void

    .line 136
    :catch_13
    move-exception v0

    goto :goto_12
.end method

.method public onStartUsingNetworkFeature(III)V
    .registers 5
    .parameter "uid"
    .parameter "pid"
    .parameter "networkType"

    .prologue
    .line 88
    :try_start_0
    invoke-direct {p0}, Lmiui/net/FirewallManager;->ensureService()V

    .line 89
    iget-object v0, p0, Lmiui/net/FirewallManager;->mService:Lmiui/net/IFirewall;

    if-eqz v0, :cond_c

    .line 90
    iget-object v0, p0, Lmiui/net/FirewallManager;->mService:Lmiui/net/IFirewall;

    invoke-interface {v0, p1, p2, p3}, Lmiui/net/IFirewall;->onStartUsingNetworkFeature(III)V
    :try_end_c
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_c} :catch_d

    .line 94
    :cond_c
    :goto_c
    return-void

    .line 92
    :catch_d
    move-exception v0

    goto :goto_c
.end method

.method public onStopUsingNetworkFeature(III)V
    .registers 5
    .parameter "uid"
    .parameter "pid"
    .parameter "networkType"

    .prologue
    .line 102
    :try_start_0
    invoke-direct {p0}, Lmiui/net/FirewallManager;->ensureService()V

    .line 103
    iget-object v0, p0, Lmiui/net/FirewallManager;->mService:Lmiui/net/IFirewall;

    if-eqz v0, :cond_c

    .line 104
    iget-object v0, p0, Lmiui/net/FirewallManager;->mService:Lmiui/net/IFirewall;

    invoke-interface {v0, p1, p2, p3}, Lmiui/net/IFirewall;->onStopUsingNetworkFeature(III)V
    :try_end_c
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_c} :catch_d

    .line 108
    :cond_c
    :goto_c
    return-void

    .line 106
    :catch_d
    move-exception v0

    goto :goto_c
.end method

.method public removeAccessControlPass(Ljava/lang/String;)V
    .registers 3
    .parameter "packageName"

    .prologue
    .line 184
    :try_start_0
    invoke-direct {p0}, Lmiui/net/FirewallManager;->ensureService()V

    .line 185
    iget-object v0, p0, Lmiui/net/FirewallManager;->mService:Lmiui/net/IFirewall;

    if-eqz v0, :cond_c

    .line 186
    iget-object v0, p0, Lmiui/net/FirewallManager;->mService:Lmiui/net/IFirewall;

    invoke-interface {v0, p1}, Lmiui/net/IFirewall;->removeAccessControlPass(Ljava/lang/String;)V
    :try_end_c
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_c} :catch_d

    .line 190
    :cond_c
    :goto_c
    return-void

    .line 188
    :catch_d
    move-exception v0

    goto :goto_c
.end method
