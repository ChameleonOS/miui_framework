.class Lcom/android/internal/os/RuntimeInit$UncaughtHandler;
.super Ljava/lang/Object;
.source "RuntimeInit.java"

# interfaces
.implements Ljava/lang/Thread$UncaughtExceptionHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/os/RuntimeInit;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "UncaughtHandler"
.end annotation


# direct methods
.method private constructor <init>()V
    .registers 1

    .prologue
    .line 62
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/android/internal/os/RuntimeInit$1;)V
    .registers 2
    .parameter "x0"

    .prologue
    .line 62
    invoke-direct {p0}, Lcom/android/internal/os/RuntimeInit$UncaughtHandler;-><init>()V

    return-void
.end method


# virtual methods
.method public uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V
    .registers 8
    .parameter "t"
    .parameter "e"

    .prologue
    const/16 v4, 0xa

    .line 66
    :try_start_2
    invoke-static {}, Lcom/android/internal/os/RuntimeInit;->access$000()Z
    :try_end_5
    .catchall {:try_start_2 .. :try_end_5} :catchall_84
    .catch Ljava/lang/Throwable; {:try_start_2 .. :try_end_5} :catch_71

    move-result v1

    if-eqz v1, :cond_13

    .line 86
    invoke-static {}, Landroid/os/Process;->myPid()I

    move-result v1

    invoke-static {v1}, Landroid/os/Process;->killProcess(I)V

    .line 87
    invoke-static {v4}, Ljava/lang/System;->exit(I)V

    .line 89
    :goto_12
    return-void

    .line 67
    :cond_13
    const/4 v1, 0x1

    :try_start_14
    invoke-static {v1}, Lcom/android/internal/os/RuntimeInit;->access$002(Z)Z

    .line 69
    invoke-static {}, Lcom/android/internal/os/RuntimeInit;->access$100()Landroid/os/IBinder;

    move-result-object v1

    if-nez v1, :cond_54

    .line 70
    const-string v1, "AndroidRuntime"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "*** FATAL EXCEPTION IN SYSTEM PROCESS: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/Thread;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, p2}, Landroid/util/Slog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 76
    :goto_39
    invoke-static {}, Landroid/app/ActivityManagerNative;->getDefault()Landroid/app/IActivityManager;

    move-result-object v1

    invoke-static {}, Lcom/android/internal/os/RuntimeInit;->access$100()Landroid/os/IBinder;

    move-result-object v2

    new-instance v3, Landroid/app/ApplicationErrorReport$CrashInfo;

    invoke-direct {v3, p2}, Landroid/app/ApplicationErrorReport$CrashInfo;-><init>(Ljava/lang/Throwable;)V

    invoke-interface {v1, v2, v3}, Landroid/app/IActivityManager;->handleApplicationCrash(Landroid/os/IBinder;Landroid/app/ApplicationErrorReport$CrashInfo;)V
    :try_end_49
    .catchall {:try_start_14 .. :try_end_49} :catchall_84
    .catch Ljava/lang/Throwable; {:try_start_14 .. :try_end_49} :catch_71

    .line 86
    invoke-static {}, Landroid/os/Process;->myPid()I

    move-result v1

    invoke-static {v1}, Landroid/os/Process;->killProcess(I)V

    .line 87
    invoke-static {v4}, Ljava/lang/System;->exit(I)V

    goto :goto_12

    .line 72
    :cond_54
    :try_start_54
    const-string v1, "AndroidRuntime"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "FATAL EXCEPTION: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/Thread;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, p2}, Landroid/util/Slog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_70
    .catchall {:try_start_54 .. :try_end_70} :catchall_84
    .catch Ljava/lang/Throwable; {:try_start_54 .. :try_end_70} :catch_71

    goto :goto_39

    .line 78
    :catch_71
    move-exception v0

    .line 80
    .local v0, t2:Ljava/lang/Throwable;
    :try_start_72
    const-string v1, "AndroidRuntime"

    const-string v2, "Error reporting crash"

    invoke-static {v1, v2, v0}, Landroid/util/Slog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_79
    .catchall {:try_start_72 .. :try_end_79} :catchall_84
    .catch Ljava/lang/Throwable; {:try_start_72 .. :try_end_79} :catch_90

    .line 86
    :goto_79
    invoke-static {}, Landroid/os/Process;->myPid()I

    move-result v1

    invoke-static {v1}, Landroid/os/Process;->killProcess(I)V

    .line 87
    invoke-static {v4}, Ljava/lang/System;->exit(I)V

    goto :goto_12

    .line 86
    .end local v0           #t2:Ljava/lang/Throwable;
    :catchall_84
    move-exception v1

    invoke-static {}, Landroid/os/Process;->myPid()I

    move-result v2

    invoke-static {v2}, Landroid/os/Process;->killProcess(I)V

    .line 87
    invoke-static {v4}, Ljava/lang/System;->exit(I)V

    throw v1

    .line 81
    .restart local v0       #t2:Ljava/lang/Throwable;
    :catch_90
    move-exception v1

    goto :goto_79
.end method
