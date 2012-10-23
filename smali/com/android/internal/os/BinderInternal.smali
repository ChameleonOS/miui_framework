.class public Lcom/android/internal/os/BinderInternal;
.super Ljava/lang/Object;
.source "BinderInternal.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/internal/os/BinderInternal$GcWatcher;
    }
.end annotation


# static fields
.field static mGcWatcher:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Lcom/android/internal/os/BinderInternal$GcWatcher;",
            ">;"
        }
    .end annotation
.end field

.field static mLastGcTime:J


# direct methods
.method static constructor <clinit>()V
    .registers 2

    .prologue
    .line 38
    new-instance v0, Ljava/lang/ref/WeakReference;

    new-instance v1, Lcom/android/internal/os/BinderInternal$GcWatcher;

    invoke-direct {v1}, Lcom/android/internal/os/BinderInternal$GcWatcher;-><init>()V

    invoke-direct {v0, v1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    sput-object v0, Lcom/android/internal/os/BinderInternal;->mGcWatcher:Ljava/lang/ref/WeakReference;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 37
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 42
    return-void
.end method

.method public static final native disableBackgroundScheduling(Z)V
.end method

.method static forceBinderGc()V
    .registers 1

    .prologue
    .line 93
    const-string v0, "Binder"

    invoke-static {v0}, Lcom/android/internal/os/BinderInternal;->forceGc(Ljava/lang/String;)V

    .line 94
    return-void
.end method

.method public static forceGc(Ljava/lang/String;)V
    .registers 2
    .parameter "reason"

    .prologue
    .line 88
    const/16 v0, 0xab5

    invoke-static {v0, p0}, Landroid/util/EventLog;->writeEvent(ILjava/lang/String;)I

    .line 89
    invoke-static {}, Ljava/lang/Runtime;->getRuntime()Ljava/lang/Runtime;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Runtime;->gc()V

    .line 90
    return-void
.end method

.method public static final native getContextObject()Landroid/os/IBinder;
.end method

.method public static getLastGcTime()J
    .registers 2

    .prologue
    .line 68
    sget-wide v0, Lcom/android/internal/os/BinderInternal;->mLastGcTime:J

    return-wide v0
.end method

.method static final native handleGc()V
.end method

.method public static final native joinThreadPool()V
.end method
