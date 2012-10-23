.class Landroid/accessibilityservice/AccessibilityService$IAccessibilityServiceClientWrapper;
.super Landroid/accessibilityservice/IAccessibilityServiceClient$Stub;
.source "AccessibilityService.java"

# interfaces
.implements Lcom/android/internal/os/HandlerCaller$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/accessibilityservice/AccessibilityService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "IAccessibilityServiceClientWrapper"
.end annotation


# static fields
.field private static final DO_ON_ACCESSIBILITY_EVENT:I = 0x1e

.field private static final DO_ON_GESTURE:I = 0x28

.field private static final DO_ON_INTERRUPT:I = 0x14

.field private static final DO_SET_SET_CONNECTION:I = 0xa

.field static final NO_ID:I = -0x1


# instance fields
.field private final mCallback:Landroid/accessibilityservice/AccessibilityService$Callbacks;

.field private final mCaller:Lcom/android/internal/os/HandlerCaller;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/os/Looper;Landroid/accessibilityservice/AccessibilityService$Callbacks;)V
    .registers 5
    .parameter "context"
    .parameter "looper"
    .parameter "callback"

    .prologue
    .line 552
    invoke-direct {p0}, Landroid/accessibilityservice/IAccessibilityServiceClient$Stub;-><init>()V

    .line 553
    iput-object p3, p0, Landroid/accessibilityservice/AccessibilityService$IAccessibilityServiceClientWrapper;->mCallback:Landroid/accessibilityservice/AccessibilityService$Callbacks;

    .line 554
    new-instance v0, Lcom/android/internal/os/HandlerCaller;

    invoke-direct {v0, p1, p2, p0}, Lcom/android/internal/os/HandlerCaller;-><init>(Landroid/content/Context;Landroid/os/Looper;Lcom/android/internal/os/HandlerCaller$Callback;)V

    iput-object v0, p0, Landroid/accessibilityservice/AccessibilityService$IAccessibilityServiceClientWrapper;->mCaller:Lcom/android/internal/os/HandlerCaller;

    .line 555
    return-void
.end method


# virtual methods
.method public executeMessage(Landroid/os/Message;)V
    .registers 9
    .parameter "message"

    .prologue
    .line 579
    iget v4, p1, Landroid/os/Message;->what:I

    sparse-switch v4, :sswitch_data_6c

    .line 610
    const-string v4, "AccessibilityService"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Unknown message type "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget v6, p1, Landroid/os/Message;->what:I

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 612
    :cond_1f
    :goto_1f
    return-void

    .line 581
    :sswitch_20
    iget-object v2, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v2, Landroid/view/accessibility/AccessibilityEvent;

    .line 582
    .local v2, event:Landroid/view/accessibility/AccessibilityEvent;
    if-eqz v2, :cond_1f

    .line 583
    invoke-static {}, Landroid/view/accessibility/AccessibilityInteractionClient;->getInstance()Landroid/view/accessibility/AccessibilityInteractionClient;

    move-result-object v4

    invoke-virtual {v4, v2}, Landroid/view/accessibility/AccessibilityInteractionClient;->onAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V

    .line 584
    iget-object v4, p0, Landroid/accessibilityservice/AccessibilityService$IAccessibilityServiceClientWrapper;->mCallback:Landroid/accessibilityservice/AccessibilityService$Callbacks;

    invoke-interface {v4, v2}, Landroid/accessibilityservice/AccessibilityService$Callbacks;->onAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V

    .line 585
    invoke-virtual {v2}, Landroid/view/accessibility/AccessibilityEvent;->recycle()V

    goto :goto_1f

    .line 589
    .end local v2           #event:Landroid/view/accessibility/AccessibilityEvent;
    :sswitch_36
    iget-object v4, p0, Landroid/accessibilityservice/AccessibilityService$IAccessibilityServiceClientWrapper;->mCallback:Landroid/accessibilityservice/AccessibilityService$Callbacks;

    invoke-interface {v4}, Landroid/accessibilityservice/AccessibilityService$Callbacks;->onInterrupt()V

    goto :goto_1f

    .line 592
    :sswitch_3c
    iget v1, p1, Landroid/os/Message;->arg1:I

    .line 593
    .local v1, connectionId:I
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Landroid/accessibilityservice/IAccessibilityServiceConnection;

    .line 595
    .local v0, connection:Landroid/accessibilityservice/IAccessibilityServiceConnection;
    if-eqz v0, :cond_56

    .line 596
    invoke-static {}, Landroid/view/accessibility/AccessibilityInteractionClient;->getInstance()Landroid/view/accessibility/AccessibilityInteractionClient;

    move-result-object v4

    invoke-virtual {v4, v1, v0}, Landroid/view/accessibility/AccessibilityInteractionClient;->addConnection(ILandroid/accessibilityservice/IAccessibilityServiceConnection;)V

    .line 598
    iget-object v4, p0, Landroid/accessibilityservice/AccessibilityService$IAccessibilityServiceClientWrapper;->mCallback:Landroid/accessibilityservice/AccessibilityService$Callbacks;

    invoke-interface {v4, v1}, Landroid/accessibilityservice/AccessibilityService$Callbacks;->onSetConnectionId(I)V

    .line 599
    iget-object v4, p0, Landroid/accessibilityservice/AccessibilityService$IAccessibilityServiceClientWrapper;->mCallback:Landroid/accessibilityservice/AccessibilityService$Callbacks;

    invoke-interface {v4}, Landroid/accessibilityservice/AccessibilityService$Callbacks;->onServiceConnected()V

    goto :goto_1f

    .line 601
    :cond_56
    invoke-static {}, Landroid/view/accessibility/AccessibilityInteractionClient;->getInstance()Landroid/view/accessibility/AccessibilityInteractionClient;

    move-result-object v4

    invoke-virtual {v4, v1}, Landroid/view/accessibility/AccessibilityInteractionClient;->removeConnection(I)V

    .line 602
    iget-object v4, p0, Landroid/accessibilityservice/AccessibilityService$IAccessibilityServiceClientWrapper;->mCallback:Landroid/accessibilityservice/AccessibilityService$Callbacks;

    const/4 v5, -0x1

    invoke-interface {v4, v5}, Landroid/accessibilityservice/AccessibilityService$Callbacks;->onSetConnectionId(I)V

    goto :goto_1f

    .line 606
    .end local v0           #connection:Landroid/accessibilityservice/IAccessibilityServiceConnection;
    .end local v1           #connectionId:I
    :sswitch_64
    iget v3, p1, Landroid/os/Message;->arg1:I

    .line 607
    .local v3, gestureId:I
    iget-object v4, p0, Landroid/accessibilityservice/AccessibilityService$IAccessibilityServiceClientWrapper;->mCallback:Landroid/accessibilityservice/AccessibilityService$Callbacks;

    invoke-interface {v4, v3}, Landroid/accessibilityservice/AccessibilityService$Callbacks;->onGesture(I)Z

    goto :goto_1f

    .line 579
    :sswitch_data_6c
    .sparse-switch
        0xa -> :sswitch_3c
        0x14 -> :sswitch_36
        0x1e -> :sswitch_20
        0x28 -> :sswitch_64
    .end sparse-switch
.end method

.method public onAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V
    .registers 5
    .parameter "event"

    .prologue
    .line 569
    iget-object v1, p0, Landroid/accessibilityservice/AccessibilityService$IAccessibilityServiceClientWrapper;->mCaller:Lcom/android/internal/os/HandlerCaller;

    const/16 v2, 0x1e

    invoke-virtual {v1, v2, p1}, Lcom/android/internal/os/HandlerCaller;->obtainMessageO(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    .line 570
    .local v0, message:Landroid/os/Message;
    iget-object v1, p0, Landroid/accessibilityservice/AccessibilityService$IAccessibilityServiceClientWrapper;->mCaller:Lcom/android/internal/os/HandlerCaller;

    invoke-virtual {v1, v0}, Lcom/android/internal/os/HandlerCaller;->sendMessage(Landroid/os/Message;)V

    .line 571
    return-void
.end method

.method public onGesture(I)V
    .registers 5
    .parameter "gestureId"

    .prologue
    .line 574
    iget-object v1, p0, Landroid/accessibilityservice/AccessibilityService$IAccessibilityServiceClientWrapper;->mCaller:Lcom/android/internal/os/HandlerCaller;

    const/16 v2, 0x28

    invoke-virtual {v1, v2, p1}, Lcom/android/internal/os/HandlerCaller;->obtainMessageI(II)Landroid/os/Message;

    move-result-object v0

    .line 575
    .local v0, message:Landroid/os/Message;
    iget-object v1, p0, Landroid/accessibilityservice/AccessibilityService$IAccessibilityServiceClientWrapper;->mCaller:Lcom/android/internal/os/HandlerCaller;

    invoke-virtual {v1, v0}, Lcom/android/internal/os/HandlerCaller;->sendMessage(Landroid/os/Message;)V

    .line 576
    return-void
.end method

.method public onInterrupt()V
    .registers 4

    .prologue
    .line 564
    iget-object v1, p0, Landroid/accessibilityservice/AccessibilityService$IAccessibilityServiceClientWrapper;->mCaller:Lcom/android/internal/os/HandlerCaller;

    const/16 v2, 0x14

    invoke-virtual {v1, v2}, Lcom/android/internal/os/HandlerCaller;->obtainMessage(I)Landroid/os/Message;

    move-result-object v0

    .line 565
    .local v0, message:Landroid/os/Message;
    iget-object v1, p0, Landroid/accessibilityservice/AccessibilityService$IAccessibilityServiceClientWrapper;->mCaller:Lcom/android/internal/os/HandlerCaller;

    invoke-virtual {v1, v0}, Lcom/android/internal/os/HandlerCaller;->sendMessage(Landroid/os/Message;)V

    .line 566
    return-void
.end method

.method public setConnection(Landroid/accessibilityservice/IAccessibilityServiceConnection;I)V
    .registers 6
    .parameter "connection"
    .parameter "connectionId"

    .prologue
    .line 558
    iget-object v1, p0, Landroid/accessibilityservice/AccessibilityService$IAccessibilityServiceClientWrapper;->mCaller:Lcom/android/internal/os/HandlerCaller;

    const/16 v2, 0xa

    invoke-virtual {v1, v2, p2, p1}, Lcom/android/internal/os/HandlerCaller;->obtainMessageIO(IILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    .line 560
    .local v0, message:Landroid/os/Message;
    iget-object v1, p0, Landroid/accessibilityservice/AccessibilityService$IAccessibilityServiceClientWrapper;->mCaller:Lcom/android/internal/os/HandlerCaller;

    invoke-virtual {v1, v0}, Lcom/android/internal/os/HandlerCaller;->sendMessage(Landroid/os/Message;)V

    .line 561
    return-void
.end method
