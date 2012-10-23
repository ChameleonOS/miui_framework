.class public Lmiui/telephony/ExtraTelephonyManager;
.super Ljava/lang/Object;
.source "ExtraTelephonyManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lmiui/telephony/ExtraTelephonyManager$AsyncFuture;
    }
.end annotation


# static fields
.field public static final ACTION_DEVICE_ID_READY:Ljava/lang/String; = "android.intent.action.DEVICE_ID_READY"

.field public static final ACTION_ENTER_INCALL_SCREEN_DURING_CALL:Ljava/lang/String; = "android.intent.action.ENTER_INCALL_SCREEN_DURING_CALL"

.field public static final ACTION_LEAVE_INCALL_SCREEN_DURING_CALL:Ljava/lang/String; = "android.intent.action.LEAVE_INCALL_SCREEN_DURING_CALL"

.field public static final EXTRA_BASE_TIME:Ljava/lang/String; = "base_time"

.field public static final EXTRA_CALL_STATE:Ljava/lang/String; = "call_state"

.field public static final EXTRA_CALL_STATE_ACTIVE:Ljava/lang/String; = null

.field public static final EXTRA_CALL_STATE_DIALING:Ljava/lang/String; = null

.field public static final EXTRA_CALL_STATE_HOLDING:Ljava/lang/String; = null

.field public static final EXTRA_DEVICE_ID:Ljava/lang/String; = "device_id"

.field private static final mDeviceIdCache:Ljava/util/concurrent/atomic/AtomicReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/atomic/AtomicReference",
            "<",
            "Ljava/util/concurrent/Future",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field

.field private static final mIccIdCache:Ljava/util/concurrent/atomic/AtomicReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/atomic/AtomicReference",
            "<",
            "Ljava/util/concurrent/Future",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field

.field private static final mImsiCache:Ljava/util/concurrent/atomic/AtomicReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/atomic/AtomicReference",
            "<",
            "Ljava/util/concurrent/Future",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 30
    new-instance v0, Ljava/util/concurrent/atomic/AtomicReference;

    invoke-direct {v0}, Ljava/util/concurrent/atomic/AtomicReference;-><init>()V

    sput-object v0, Lmiui/telephony/ExtraTelephonyManager;->mDeviceIdCache:Ljava/util/concurrent/atomic/AtomicReference;

    .line 33
    new-instance v0, Ljava/util/concurrent/atomic/AtomicReference;

    invoke-direct {v0}, Ljava/util/concurrent/atomic/AtomicReference;-><init>()V

    sput-object v0, Lmiui/telephony/ExtraTelephonyManager;->mIccIdCache:Ljava/util/concurrent/atomic/AtomicReference;

    .line 36
    new-instance v0, Ljava/util/concurrent/atomic/AtomicReference;

    invoke-direct {v0}, Ljava/util/concurrent/atomic/AtomicReference;-><init>()V

    sput-object v0, Lmiui/telephony/ExtraTelephonyManager;->mImsiCache:Ljava/util/concurrent/atomic/AtomicReference;

    .line 66
    sget-object v0, Lcom/android/internal/telephony/Call$State;->DIALING:Lcom/android/internal/telephony/Call$State;

    invoke-virtual {v0}, Lcom/android/internal/telephony/Call$State;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lmiui/telephony/ExtraTelephonyManager;->EXTRA_CALL_STATE_DIALING:Ljava/lang/String;

    .line 73
    sget-object v0, Lcom/android/internal/telephony/Call$State;->ACTIVE:Lcom/android/internal/telephony/Call$State;

    invoke-virtual {v0}, Lcom/android/internal/telephony/Call$State;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lmiui/telephony/ExtraTelephonyManager;->EXTRA_CALL_STATE_ACTIVE:Ljava/lang/String;

    .line 80
    sget-object v0, Lcom/android/internal/telephony/Call$State;->HOLDING:Lcom/android/internal/telephony/Call$State;

    invoke-virtual {v0}, Lcom/android/internal/telephony/Call$State;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lmiui/telephony/ExtraTelephonyManager;->EXTRA_CALL_STATE_HOLDING:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 28
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 338
    return-void
.end method

.method static synthetic access$000(Landroid/content/Context;)Ljava/lang/String;
    .registers 2
    .parameter "x0"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lmiui/telephony/exception/IllegalDeviceException;
        }
    .end annotation

    .prologue
    .line 28
    invoke-static {p0}, Lmiui/telephony/ExtraTelephonyManager;->waitAndGetDeviceId(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$100(Landroid/content/Context;)Ljava/lang/String;
    .registers 2
    .parameter "x0"

    .prologue
    .line 28
    invoke-static {p0}, Lmiui/telephony/ExtraTelephonyManager;->waitAndGetIccid(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$200(Landroid/content/Context;)Ljava/lang/String;
    .registers 2
    .parameter "x0"

    .prologue
    .line 28
    invoke-static {p0}, Lmiui/telephony/ExtraTelephonyManager;->waitAndGetImsi(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static blockingGetDeviceId(Landroid/content/Context;)Ljava/lang/String;
    .registers 8
    .parameter "context"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lmiui/telephony/exception/IllegalDeviceException;
        }
    .end annotation

    .prologue
    .line 127
    sget-object v5, Lmiui/telephony/ExtraTelephonyManager;->mDeviceIdCache:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v5}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/concurrent/Future;

    .line 128
    .local v2, f:Ljava/util/concurrent/Future;,"Ljava/util/concurrent/Future<Ljava/lang/String;>;"
    if-nez v2, :cond_28

    .line 129
    new-instance v3, Ljava/util/concurrent/FutureTask;

    new-instance v5, Lmiui/telephony/ExtraTelephonyManager$1;

    invoke-direct {v5, p0}, Lmiui/telephony/ExtraTelephonyManager$1;-><init>(Landroid/content/Context;)V

    invoke-direct {v3, v5}, Ljava/util/concurrent/FutureTask;-><init>(Ljava/util/concurrent/Callable;)V

    .line 136
    .local v3, fu:Ljava/util/concurrent/FutureTask;,"Ljava/util/concurrent/FutureTask<Ljava/lang/String;>;"
    sget-object v5, Lmiui/telephony/ExtraTelephonyManager;->mDeviceIdCache:Ljava/util/concurrent/atomic/AtomicReference;

    const/4 v6, 0x0

    invoke-virtual {v5, v6, v3}, Ljava/util/concurrent/atomic/AtomicReference;->compareAndSet(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_20

    .line 137
    invoke-virtual {v3}, Ljava/util/concurrent/FutureTask;->run()V

    .line 139
    :cond_20
    sget-object v5, Lmiui/telephony/ExtraTelephonyManager;->mDeviceIdCache:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v5}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v2

    .end local v2           #f:Ljava/util/concurrent/Future;,"Ljava/util/concurrent/Future<Ljava/lang/String;>;"
    check-cast v2, Ljava/util/concurrent/Future;

    .line 141
    .end local v3           #fu:Ljava/util/concurrent/FutureTask;,"Ljava/util/concurrent/FutureTask<Ljava/lang/String;>;"
    .restart local v2       #f:Ljava/util/concurrent/Future;,"Ljava/util/concurrent/Future<Ljava/lang/String;>;"
    :cond_28
    const/4 v4, 0x0

    .line 143
    .local v4, result:Ljava/lang/String;
    :try_start_29
    invoke-interface {v2}, Ljava/util/concurrent/Future;->get()Ljava/lang/Object;

    move-result-object v5

    move-object v0, v5

    check-cast v0, Ljava/lang/String;

    move-object v4, v0
    :try_end_31
    .catch Ljava/lang/Exception; {:try_start_29 .. :try_end_31} :catch_3f

    .line 147
    :goto_31
    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_44

    .line 148
    new-instance v5, Lmiui/telephony/exception/IllegalDeviceException;

    const-string v6, "device id is empty"

    invoke-direct {v5, v6}, Lmiui/telephony/exception/IllegalDeviceException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 144
    :catch_3f
    move-exception v1

    .line 145
    .local v1, e:Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_31

    .line 150
    .end local v1           #e:Ljava/lang/Exception;
    :cond_44
    return-object v4
.end method

.method public static blockingGetIccId(Landroid/content/Context;)Ljava/lang/String;
    .registers 8
    .parameter "context"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lmiui/telephony/exception/IllegalDeviceException;
        }
    .end annotation

    .prologue
    .line 191
    sget-object v5, Lmiui/telephony/ExtraTelephonyManager;->mIccIdCache:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v5}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/concurrent/Future;

    .line 192
    .local v2, f:Ljava/util/concurrent/Future;,"Ljava/util/concurrent/Future<Ljava/lang/String;>;"
    if-nez v2, :cond_28

    .line 193
    new-instance v3, Ljava/util/concurrent/FutureTask;

    new-instance v5, Lmiui/telephony/ExtraTelephonyManager$3;

    invoke-direct {v5, p0}, Lmiui/telephony/ExtraTelephonyManager$3;-><init>(Landroid/content/Context;)V

    invoke-direct {v3, v5}, Ljava/util/concurrent/FutureTask;-><init>(Ljava/util/concurrent/Callable;)V

    .line 200
    .local v3, fu:Ljava/util/concurrent/FutureTask;,"Ljava/util/concurrent/FutureTask<Ljava/lang/String;>;"
    sget-object v5, Lmiui/telephony/ExtraTelephonyManager;->mIccIdCache:Ljava/util/concurrent/atomic/AtomicReference;

    const/4 v6, 0x0

    invoke-virtual {v5, v6, v3}, Ljava/util/concurrent/atomic/AtomicReference;->compareAndSet(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_20

    .line 201
    invoke-virtual {v3}, Ljava/util/concurrent/FutureTask;->run()V

    .line 203
    :cond_20
    sget-object v5, Lmiui/telephony/ExtraTelephonyManager;->mIccIdCache:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v5}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v2

    .end local v2           #f:Ljava/util/concurrent/Future;,"Ljava/util/concurrent/Future<Ljava/lang/String;>;"
    check-cast v2, Ljava/util/concurrent/Future;

    .line 205
    .end local v3           #fu:Ljava/util/concurrent/FutureTask;,"Ljava/util/concurrent/FutureTask<Ljava/lang/String;>;"
    .restart local v2       #f:Ljava/util/concurrent/Future;,"Ljava/util/concurrent/Future<Ljava/lang/String;>;"
    :cond_28
    const/4 v4, 0x0

    .line 207
    .local v4, result:Ljava/lang/String;
    :try_start_29
    invoke-interface {v2}, Ljava/util/concurrent/Future;->get()Ljava/lang/Object;

    move-result-object v5

    move-object v0, v5

    check-cast v0, Ljava/lang/String;

    move-object v4, v0
    :try_end_31
    .catch Ljava/lang/Exception; {:try_start_29 .. :try_end_31} :catch_3f

    .line 211
    :goto_31
    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_44

    .line 212
    new-instance v5, Lmiui/telephony/exception/IllegalDeviceException;

    const-string v6, "icc id is is empty"

    invoke-direct {v5, v6}, Lmiui/telephony/exception/IllegalDeviceException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 208
    :catch_3f
    move-exception v1

    .line 209
    .local v1, e:Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_31

    .line 214
    .end local v1           #e:Ljava/lang/Exception;
    :cond_44
    return-object v4
.end method

.method public static blockingGetImsi(Landroid/content/Context;)Ljava/lang/String;
    .registers 8
    .parameter "context"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lmiui/telephony/exception/IllegalDeviceException;
        }
    .end annotation

    .prologue
    .line 268
    sget-object v5, Lmiui/telephony/ExtraTelephonyManager;->mImsiCache:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v5}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/concurrent/Future;

    .line 269
    .local v2, f:Ljava/util/concurrent/Future;,"Ljava/util/concurrent/Future<Ljava/lang/String;>;"
    if-nez v2, :cond_28

    .line 270
    new-instance v3, Ljava/util/concurrent/FutureTask;

    new-instance v5, Lmiui/telephony/ExtraTelephonyManager$5;

    invoke-direct {v5, p0}, Lmiui/telephony/ExtraTelephonyManager$5;-><init>(Landroid/content/Context;)V

    invoke-direct {v3, v5}, Ljava/util/concurrent/FutureTask;-><init>(Ljava/util/concurrent/Callable;)V

    .line 277
    .local v3, fu:Ljava/util/concurrent/FutureTask;,"Ljava/util/concurrent/FutureTask<Ljava/lang/String;>;"
    sget-object v5, Lmiui/telephony/ExtraTelephonyManager;->mImsiCache:Ljava/util/concurrent/atomic/AtomicReference;

    const/4 v6, 0x0

    invoke-virtual {v5, v6, v3}, Ljava/util/concurrent/atomic/AtomicReference;->compareAndSet(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_20

    .line 278
    invoke-virtual {v3}, Ljava/util/concurrent/FutureTask;->run()V

    .line 280
    :cond_20
    sget-object v5, Lmiui/telephony/ExtraTelephonyManager;->mImsiCache:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v5}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    move-result-object v2

    .end local v2           #f:Ljava/util/concurrent/Future;,"Ljava/util/concurrent/Future<Ljava/lang/String;>;"
    check-cast v2, Ljava/util/concurrent/Future;

    .line 282
    .end local v3           #fu:Ljava/util/concurrent/FutureTask;,"Ljava/util/concurrent/FutureTask<Ljava/lang/String;>;"
    .restart local v2       #f:Ljava/util/concurrent/Future;,"Ljava/util/concurrent/Future<Ljava/lang/String;>;"
    :cond_28
    const/4 v4, 0x0

    .line 284
    .local v4, result:Ljava/lang/String;
    :try_start_29
    invoke-interface {v2}, Ljava/util/concurrent/Future;->get()Ljava/lang/Object;

    move-result-object v5

    move-object v0, v5

    check-cast v0, Ljava/lang/String;

    move-object v4, v0
    :try_end_31
    .catch Ljava/lang/Exception; {:try_start_29 .. :try_end_31} :catch_3f

    .line 288
    :goto_31
    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_44

    .line 289
    new-instance v5, Lmiui/telephony/exception/IllegalDeviceException;

    const-string v6, "imsi is is empty"

    invoke-direct {v5, v6}, Lmiui/telephony/exception/IllegalDeviceException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 285
    :catch_3f
    move-exception v1

    .line 286
    .local v1, e:Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_31

    .line 291
    .end local v1           #e:Ljava/lang/Exception;
    :cond_44
    return-object v4
.end method

.method private static ensureNotOnMainThread(Landroid/content/Context;)V
    .registers 4
    .parameter "context"

    .prologue
    .line 331
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v0

    .line 332
    .local v0, looper:Landroid/os/Looper;
    if-eqz v0, :cond_14

    invoke-virtual {p0}, Landroid/content/Context;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    if-ne v0, v1, :cond_14

    .line 333
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "calling this from your main thread can lead to deadlock"

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 336
    :cond_14
    return-void
.end method

.method public static getSimOperator(Landroid/content/Context;)Ljava/lang/String;
    .registers 5
    .parameter "context"

    .prologue
    .line 95
    const-string v2, "gsm.sim.operator.numeric"

    invoke-static {v2}, Landroid/os/SystemProperties;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 97
    .local v1, operator:Ljava/lang/String;
    if-nez p0, :cond_9

    .line 113
    .end local v1           #operator:Ljava/lang/String;
    :cond_8
    :goto_8
    return-object v1

    .line 101
    .restart local v1       #operator:Ljava/lang/String;
    :cond_9
    const-string v2, "com.android.vending"

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_8

    invoke-static {v1}, Lmiui/telephony/PhoneNumberUtils;->isChineseOperator(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_8

    .line 102
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    const-string v3, "fake_mobile_operator_for_vending"

    invoke-static {v2, v3}, Landroid/provider/Settings$System;->getString(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 105
    .local v0, fake:Ljava/lang/String;
    if-eqz v0, :cond_2f

    .line 106
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v2

    if-eqz v2, :cond_8

    move-object v1, v0

    goto :goto_8

    .line 110
    :cond_2f
    const-string v1, "310410"

    goto :goto_8
.end method

.method private static waitAndGetDeviceId(Landroid/content/Context;)Ljava/lang/String;
    .registers 8
    .parameter "context"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lmiui/telephony/exception/IllegalDeviceException;
        }
    .end annotation

    .prologue
    .line 155
    invoke-static {p0}, Lmiui/telephony/ExtraTelephonyManager;->ensureNotOnMainThread(Landroid/content/Context;)V

    .line 156
    const-string/jumbo v6, "phone"

    invoke-virtual {p0, v6}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/telephony/TelephonyManager;

    .line 158
    .local v5, tm:Landroid/telephony/TelephonyManager;
    new-instance v2, Lmiui/telephony/ExtraTelephonyManager$AsyncFuture;

    invoke-direct {v2}, Lmiui/telephony/ExtraTelephonyManager$AsyncFuture;-><init>()V

    .line 159
    .local v2, future:Lmiui/telephony/ExtraTelephonyManager$AsyncFuture;,"Lmiui/telephony/ExtraTelephonyManager$AsyncFuture<Ljava/lang/String;>;"
    new-instance v4, Lmiui/telephony/ExtraTelephonyManager$2;

    invoke-direct {v4, v2}, Lmiui/telephony/ExtraTelephonyManager$2;-><init>(Lmiui/telephony/ExtraTelephonyManager$AsyncFuture;)V

    .line 166
    .local v4, receiver:Landroid/content/BroadcastReceiver;
    new-instance v1, Landroid/content/IntentFilter;

    const-string v6, "android.intent.action.DEVICE_ID_READY"

    invoke-direct {v1, v6}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    .line 168
    .local v1, filter:Landroid/content/IntentFilter;
    invoke-virtual {p0, v4, v1}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 169
    invoke-virtual {v5}, Landroid/telephony/TelephonyManager;->getDeviceId()Ljava/lang/String;

    move-result-object v3

    .line 170
    .local v3, id:Ljava/lang/String;
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_2d

    .line 171
    invoke-virtual {v2, v3}, Lmiui/telephony/ExtraTelephonyManager$AsyncFuture;->setResult(Ljava/lang/Object;)V

    .line 174
    :cond_2d
    :try_start_2d
    invoke-virtual {v2}, Lmiui/telephony/ExtraTelephonyManager$AsyncFuture;->get()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;
    :try_end_33
    .catchall {:try_start_2d .. :try_end_33} :catchall_3a
    .catch Ljava/lang/Exception; {:try_start_2d .. :try_end_33} :catch_37

    .line 178
    :goto_33
    invoke-virtual {p0, v4}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 176
    return-object v6

    .line 175
    :catch_37
    move-exception v0

    .line 176
    .local v0, e:Ljava/lang/Exception;
    const/4 v6, 0x0

    goto :goto_33

    .line 178
    .end local v0           #e:Ljava/lang/Exception;
    :catchall_3a
    move-exception v6

    invoke-virtual {p0, v4}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    throw v6
.end method

.method private static waitAndGetIccid(Landroid/content/Context;)Ljava/lang/String;
    .registers 8
    .parameter "context"

    .prologue
    .line 226
    invoke-static {p0}, Lmiui/telephony/ExtraTelephonyManager;->ensureNotOnMainThread(Landroid/content/Context;)V

    .line 227
    const-string/jumbo v6, "phone"

    invoke-virtual {p0, v6}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/telephony/TelephonyManager;

    .line 229
    .local v5, tm:Landroid/telephony/TelephonyManager;
    new-instance v2, Lmiui/telephony/ExtraTelephonyManager$AsyncFuture;

    invoke-direct {v2}, Lmiui/telephony/ExtraTelephonyManager$AsyncFuture;-><init>()V

    .line 230
    .local v2, future:Lmiui/telephony/ExtraTelephonyManager$AsyncFuture;,"Lmiui/telephony/ExtraTelephonyManager$AsyncFuture<Ljava/lang/String;>;"
    new-instance v4, Lmiui/telephony/ExtraTelephonyManager$4;

    invoke-direct {v4, v2}, Lmiui/telephony/ExtraTelephonyManager$4;-><init>(Lmiui/telephony/ExtraTelephonyManager$AsyncFuture;)V

    .line 241
    .local v4, receiver:Landroid/content/BroadcastReceiver;
    new-instance v1, Landroid/content/IntentFilter;

    const-string v6, "android.intent.action.SIM_STATE_CHANGED"

    invoke-direct {v1, v6}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    .line 243
    .local v1, filter:Landroid/content/IntentFilter;
    invoke-virtual {p0, v4, v1}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 244
    invoke-virtual {v5}, Landroid/telephony/TelephonyManager;->getSimSerialNumber()Ljava/lang/String;

    move-result-object v3

    .line 245
    .local v3, id:Ljava/lang/String;
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_2d

    .line 246
    invoke-virtual {v2, v3}, Lmiui/telephony/ExtraTelephonyManager$AsyncFuture;->setResult(Ljava/lang/Object;)V

    .line 249
    :cond_2d
    :try_start_2d
    invoke-virtual {v2}, Lmiui/telephony/ExtraTelephonyManager$AsyncFuture;->get()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;
    :try_end_33
    .catchall {:try_start_2d .. :try_end_33} :catchall_3a
    .catch Ljava/lang/Exception; {:try_start_2d .. :try_end_33} :catch_37

    .line 253
    :goto_33
    invoke-virtual {p0, v4}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 251
    return-object v6

    .line 250
    :catch_37
    move-exception v0

    .line 251
    .local v0, e:Ljava/lang/Exception;
    const/4 v6, 0x0

    goto :goto_33

    .line 253
    .end local v0           #e:Ljava/lang/Exception;
    :catchall_3a
    move-exception v6

    invoke-virtual {p0, v4}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    throw v6
.end method

.method private static waitAndGetImsi(Landroid/content/Context;)Ljava/lang/String;
    .registers 8
    .parameter "context"

    .prologue
    .line 299
    invoke-static {p0}, Lmiui/telephony/ExtraTelephonyManager;->ensureNotOnMainThread(Landroid/content/Context;)V

    .line 300
    const-string/jumbo v6, "phone"

    invoke-virtual {p0, v6}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/telephony/TelephonyManager;

    .line 302
    .local v5, tm:Landroid/telephony/TelephonyManager;
    new-instance v2, Lmiui/telephony/ExtraTelephonyManager$AsyncFuture;

    invoke-direct {v2}, Lmiui/telephony/ExtraTelephonyManager$AsyncFuture;-><init>()V

    .line 303
    .local v2, future:Lmiui/telephony/ExtraTelephonyManager$AsyncFuture;,"Lmiui/telephony/ExtraTelephonyManager$AsyncFuture<Ljava/lang/String;>;"
    new-instance v4, Lmiui/telephony/ExtraTelephonyManager$6;

    invoke-direct {v4, v2}, Lmiui/telephony/ExtraTelephonyManager$6;-><init>(Lmiui/telephony/ExtraTelephonyManager$AsyncFuture;)V

    .line 314
    .local v4, receiver:Landroid/content/BroadcastReceiver;
    new-instance v1, Landroid/content/IntentFilter;

    const-string v6, "android.intent.action.SIM_STATE_CHANGED"

    invoke-direct {v1, v6}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    .line 316
    .local v1, filter:Landroid/content/IntentFilter;
    invoke-virtual {p0, v4, v1}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 317
    invoke-virtual {v5}, Landroid/telephony/TelephonyManager;->getSubscriberId()Ljava/lang/String;

    move-result-object v3

    .line 318
    .local v3, id:Ljava/lang/String;
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_2d

    .line 319
    invoke-virtual {v2, v3}, Lmiui/telephony/ExtraTelephonyManager$AsyncFuture;->setResult(Ljava/lang/Object;)V

    .line 322
    :cond_2d
    :try_start_2d
    invoke-virtual {v2}, Lmiui/telephony/ExtraTelephonyManager$AsyncFuture;->get()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;
    :try_end_33
    .catchall {:try_start_2d .. :try_end_33} :catchall_3a
    .catch Ljava/lang/Exception; {:try_start_2d .. :try_end_33} :catch_37

    .line 326
    :goto_33
    invoke-virtual {p0, v4}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 324
    return-object v6

    .line 323
    :catch_37
    move-exception v0

    .line 324
    .local v0, e:Ljava/lang/Exception;
    const/4 v6, 0x0

    goto :goto_33

    .line 326
    .end local v0           #e:Ljava/lang/Exception;
    :catchall_3a
    move-exception v6

    invoke-virtual {p0, v4}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    throw v6
.end method
