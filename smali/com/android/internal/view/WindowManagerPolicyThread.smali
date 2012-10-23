.class public Lcom/android/internal/view/WindowManagerPolicyThread;
.super Ljava/lang/Object;
.source "WindowManagerPolicyThread.java"


# static fields
.field static mLooper:Landroid/os/Looper;

.field static mThread:Ljava/lang/Thread;


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 25
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getLooper()Landroid/os/Looper;
    .registers 1

    .prologue
    .line 39
    sget-object v0, Lcom/android/internal/view/WindowManagerPolicyThread;->mLooper:Landroid/os/Looper;

    return-object v0
.end method

.method public static getThread()Ljava/lang/Thread;
    .registers 1

    .prologue
    .line 35
    sget-object v0, Lcom/android/internal/view/WindowManagerPolicyThread;->mThread:Ljava/lang/Thread;

    return-object v0
.end method

.method public static set(Ljava/lang/Thread;Landroid/os/Looper;)V
    .registers 2
    .parameter "thread"
    .parameter "looper"

    .prologue
    .line 30
    sput-object p0, Lcom/android/internal/view/WindowManagerPolicyThread;->mThread:Ljava/lang/Thread;

    .line 31
    sput-object p1, Lcom/android/internal/view/WindowManagerPolicyThread;->mLooper:Landroid/os/Looper;

    .line 32
    return-void
.end method
