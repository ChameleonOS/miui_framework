.class public abstract Landroid/accessibilityservice/AccessibilityService;
.super Landroid/app/Service;
.source "AccessibilityService.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/accessibilityservice/AccessibilityService$IAccessibilityServiceClientWrapper;,
        Landroid/accessibilityservice/AccessibilityService$Callbacks;
    }
.end annotation


# static fields
.field public static final GESTURE_SWIPE_DOWN:I = 0x2

.field public static final GESTURE_SWIPE_DOWN_AND_LEFT:I = 0xf

.field public static final GESTURE_SWIPE_DOWN_AND_RIGHT:I = 0x10

.field public static final GESTURE_SWIPE_DOWN_AND_UP:I = 0x8

.field public static final GESTURE_SWIPE_LEFT:I = 0x3

.field public static final GESTURE_SWIPE_LEFT_AND_DOWN:I = 0xa

.field public static final GESTURE_SWIPE_LEFT_AND_RIGHT:I = 0x5

.field public static final GESTURE_SWIPE_LEFT_AND_UP:I = 0x9

.field public static final GESTURE_SWIPE_RIGHT:I = 0x4

.field public static final GESTURE_SWIPE_RIGHT_AND_DOWN:I = 0xc

.field public static final GESTURE_SWIPE_RIGHT_AND_LEFT:I = 0x6

.field public static final GESTURE_SWIPE_RIGHT_AND_UP:I = 0xb

.field public static final GESTURE_SWIPE_UP:I = 0x1

.field public static final GESTURE_SWIPE_UP_AND_DOWN:I = 0x7

.field public static final GESTURE_SWIPE_UP_AND_LEFT:I = 0xd

.field public static final GESTURE_SWIPE_UP_AND_RIGHT:I = 0xe

.field public static final GLOBAL_ACTION_BACK:I = 0x1

.field public static final GLOBAL_ACTION_HOME:I = 0x2

.field public static final GLOBAL_ACTION_NOTIFICATIONS:I = 0x4

.field public static final GLOBAL_ACTION_RECENTS:I = 0x3

.field private static final LOG_TAG:Ljava/lang/String; = "AccessibilityService"

.field public static final SERVICE_INTERFACE:Ljava/lang/String; = "android.accessibilityservice.AccessibilityService"

.field public static final SERVICE_META_DATA:Ljava/lang/String; = "android.accessibilityservice"


# instance fields
.field private mConnectionId:I

.field private mInfo:Landroid/accessibilityservice/AccessibilityServiceInfo;


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    return-void
.end method

.method static synthetic access$002(Landroid/accessibilityservice/AccessibilityService;I)I
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    iput p1, p0, Landroid/accessibilityservice/AccessibilityService;->mConnectionId:I

    return p1
.end method

.method private sendServiceInfo()V
    .registers 5

    .prologue
    invoke-static {}, Landroid/view/accessibility/AccessibilityInteractionClient;->getInstance()Landroid/view/accessibility/AccessibilityInteractionClient;

    move-result-object v2

    iget v3, p0, Landroid/accessibilityservice/AccessibilityService;->mConnectionId:I

    invoke-virtual {v2, v3}, Landroid/view/accessibility/AccessibilityInteractionClient;->getConnection(I)Landroid/accessibilityservice/IAccessibilityServiceConnection;

    move-result-object v0

    .local v0, connection:Landroid/accessibilityservice/IAccessibilityServiceConnection;
    iget-object v2, p0, Landroid/accessibilityservice/AccessibilityService;->mInfo:Landroid/accessibilityservice/AccessibilityServiceInfo;

    if-eqz v2, :cond_1f

    if-eqz v0, :cond_1f

    :try_start_10
    iget-object v2, p0, Landroid/accessibilityservice/AccessibilityService;->mInfo:Landroid/accessibilityservice/AccessibilityServiceInfo;

    invoke-interface {v0, v2}, Landroid/accessibilityservice/IAccessibilityServiceConnection;->setServiceInfo(Landroid/accessibilityservice/AccessibilityServiceInfo;)V

    const/4 v2, 0x0

    iput-object v2, p0, Landroid/accessibilityservice/AccessibilityService;->mInfo:Landroid/accessibilityservice/AccessibilityServiceInfo;

    invoke-static {}, Landroid/view/accessibility/AccessibilityInteractionClient;->getInstance()Landroid/view/accessibility/AccessibilityInteractionClient;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/accessibility/AccessibilityInteractionClient;->clearCache()V
    :try_end_1f
    .catch Landroid/os/RemoteException; {:try_start_10 .. :try_end_1f} :catch_20

    :cond_1f
    :goto_1f
    return-void

    :catch_20
    move-exception v1

    .local v1, re:Landroid/os/RemoteException;
    const-string v2, "AccessibilityService"

    const-string v3, "Error while setting AccessibilityServiceInfo"

    invoke-static {v2, v3, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_1f
.end method


# virtual methods
.method public getRootInActiveWindow()Landroid/view/accessibility/AccessibilityNodeInfo;
    .registers 3

    .prologue
    invoke-static {}, Landroid/view/accessibility/AccessibilityInteractionClient;->getInstance()Landroid/view/accessibility/AccessibilityInteractionClient;

    move-result-object v0

    iget v1, p0, Landroid/accessibilityservice/AccessibilityService;->mConnectionId:I

    invoke-virtual {v0, v1}, Landroid/view/accessibility/AccessibilityInteractionClient;->getRootInActiveWindow(I)Landroid/view/accessibility/AccessibilityNodeInfo;

    move-result-object v0

    return-object v0
.end method

.method public final getServiceInfo()Landroid/accessibilityservice/AccessibilityServiceInfo;
    .registers 5

    .prologue
    invoke-static {}, Landroid/view/accessibility/AccessibilityInteractionClient;->getInstance()Landroid/view/accessibility/AccessibilityInteractionClient;

    move-result-object v2

    iget v3, p0, Landroid/accessibilityservice/AccessibilityService;->mConnectionId:I

    invoke-virtual {v2, v3}, Landroid/view/accessibility/AccessibilityInteractionClient;->getConnection(I)Landroid/accessibilityservice/IAccessibilityServiceConnection;

    move-result-object v0

    .local v0, connection:Landroid/accessibilityservice/IAccessibilityServiceConnection;
    if-eqz v0, :cond_19

    :try_start_c
    invoke-interface {v0}, Landroid/accessibilityservice/IAccessibilityServiceConnection;->getServiceInfo()Landroid/accessibilityservice/AccessibilityServiceInfo;
    :try_end_f
    .catch Landroid/os/RemoteException; {:try_start_c .. :try_end_f} :catch_11

    move-result-object v2

    :goto_10
    return-object v2

    :catch_11
    move-exception v1

    .local v1, re:Landroid/os/RemoteException;
    const-string v2, "AccessibilityService"

    const-string v3, "Error while getting AccessibilityServiceInfo"

    invoke-static {v2, v3, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .end local v1           #re:Landroid/os/RemoteException;
    :cond_19
    const/4 v2, 0x0

    goto :goto_10
.end method

.method public abstract onAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V
.end method

.method public final onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .registers 5
    .parameter "intent"

    .prologue
    new-instance v0, Landroid/accessibilityservice/AccessibilityService$IAccessibilityServiceClientWrapper;

    invoke-virtual {p0}, Landroid/accessibilityservice/AccessibilityService;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    new-instance v2, Landroid/accessibilityservice/AccessibilityService$1;

    invoke-direct {v2, p0}, Landroid/accessibilityservice/AccessibilityService$1;-><init>(Landroid/accessibilityservice/AccessibilityService;)V

    invoke-direct {v0, p0, v1, v2}, Landroid/accessibilityservice/AccessibilityService$IAccessibilityServiceClientWrapper;-><init>(Landroid/content/Context;Landroid/os/Looper;Landroid/accessibilityservice/AccessibilityService$Callbacks;)V

    return-object v0
.end method

.method protected onGesture(I)Z
    .registers 3
    .parameter "gestureId"

    .prologue
    const/4 v0, 0x0

    return v0
.end method

.method public abstract onInterrupt()V
.end method

.method protected onServiceConnected()V
    .registers 1

    .prologue
    return-void
.end method

.method public final performGlobalAction(I)Z
    .registers 6
    .parameter "action"

    .prologue
    invoke-static {}, Landroid/view/accessibility/AccessibilityInteractionClient;->getInstance()Landroid/view/accessibility/AccessibilityInteractionClient;

    move-result-object v2

    iget v3, p0, Landroid/accessibilityservice/AccessibilityService;->mConnectionId:I

    invoke-virtual {v2, v3}, Landroid/view/accessibility/AccessibilityInteractionClient;->getConnection(I)Landroid/accessibilityservice/IAccessibilityServiceConnection;

    move-result-object v0

    .local v0, connection:Landroid/accessibilityservice/IAccessibilityServiceConnection;
    if-eqz v0, :cond_19

    :try_start_c
    invoke-interface {v0, p1}, Landroid/accessibilityservice/IAccessibilityServiceConnection;->performGlobalAction(I)Z
    :try_end_f
    .catch Landroid/os/RemoteException; {:try_start_c .. :try_end_f} :catch_11

    move-result v2

    :goto_10
    return v2

    :catch_11
    move-exception v1

    .local v1, re:Landroid/os/RemoteException;
    const-string v2, "AccessibilityService"

    const-string v3, "Error while calling performGlobalAction"

    invoke-static {v2, v3, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .end local v1           #re:Landroid/os/RemoteException;
    :cond_19
    const/4 v2, 0x0

    goto :goto_10
.end method

.method public final setServiceInfo(Landroid/accessibilityservice/AccessibilityServiceInfo;)V
    .registers 2
    .parameter "info"

    .prologue
    iput-object p1, p0, Landroid/accessibilityservice/AccessibilityService;->mInfo:Landroid/accessibilityservice/AccessibilityServiceInfo;

    invoke-direct {p0}, Landroid/accessibilityservice/AccessibilityService;->sendServiceInfo()V

    return-void
.end method
