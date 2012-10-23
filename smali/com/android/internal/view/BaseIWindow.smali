.class public Lcom/android/internal/view/BaseIWindow;
.super Landroid/view/IWindow$Stub;
.source "BaseIWindow.java"


# instance fields
.field public mSeq:I

.field private mSession:Landroid/view/IWindowSession;


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 28
    invoke-direct {p0}, Landroid/view/IWindow$Stub;-><init>()V

    return-void
.end method


# virtual methods
.method public closeSystemDialogs(Ljava/lang/String;)V
    .registers 2
    .parameter "reason"

    .prologue
    .line 62
    return-void
.end method

.method public dispatchAppVisibility(Z)V
    .registers 2
    .parameter "visible"

    .prologue
    .line 47
    return-void
.end method

.method public dispatchDragEvent(Landroid/view/DragEvent;)V
    .registers 2
    .parameter "event"

    .prologue
    .line 74
    return-void
.end method

.method public dispatchGetNewSurface()V
    .registers 1

    .prologue
    .line 50
    return-void
.end method

.method public dispatchScreenState(Z)V
    .registers 2
    .parameter "on"

    .prologue
    .line 53
    return-void
.end method

.method public dispatchSystemUiVisibilityChanged(IIII)V
    .registers 5
    .parameter "seq"
    .parameter "globalUi"
    .parameter "localValue"
    .parameter "localChanges"

    .prologue
    .line 78
    iput p1, p0, Lcom/android/internal/view/BaseIWindow;->mSeq:I

    .line 79
    return-void
.end method

.method public dispatchWallpaperCommand(Ljava/lang/String;IIILandroid/os/Bundle;Z)V
    .registers 10
    .parameter "action"
    .parameter "x"
    .parameter "y"
    .parameter "z"
    .parameter "extras"
    .parameter "sync"

    .prologue
    .line 83
    if-eqz p6, :cond_c

    .line 85
    :try_start_2
    iget-object v0, p0, Lcom/android/internal/view/BaseIWindow;->mSession:Landroid/view/IWindowSession;

    invoke-virtual {p0}, Lcom/android/internal/view/BaseIWindow;->asBinder()Landroid/os/IBinder;

    move-result-object v1

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/view/IWindowSession;->wallpaperCommandComplete(Landroid/os/IBinder;Landroid/os/Bundle;)V
    :try_end_c
    .catch Landroid/os/RemoteException; {:try_start_2 .. :try_end_c} :catch_d

    .line 89
    :cond_c
    :goto_c
    return-void

    .line 86
    :catch_d
    move-exception v0

    goto :goto_c
.end method

.method public dispatchWallpaperOffsets(FFFFZ)V
    .registers 8
    .parameter "x"
    .parameter "y"
    .parameter "xStep"
    .parameter "yStep"
    .parameter "sync"

    .prologue
    .line 65
    if-eqz p5, :cond_b

    .line 67
    :try_start_2
    iget-object v0, p0, Lcom/android/internal/view/BaseIWindow;->mSession:Landroid/view/IWindowSession;

    invoke-virtual {p0}, Lcom/android/internal/view/BaseIWindow;->asBinder()Landroid/os/IBinder;

    move-result-object v1

    invoke-interface {v0, v1}, Landroid/view/IWindowSession;->wallpaperOffsetsComplete(Landroid/os/IBinder;)V
    :try_end_b
    .catch Landroid/os/RemoteException; {:try_start_2 .. :try_end_b} :catch_c

    .line 71
    :cond_b
    :goto_b
    return-void

    .line 68
    :catch_c
    move-exception v0

    goto :goto_b
.end method

.method public doneAnimating()V
    .registers 1

    .prologue
    .line 92
    return-void
.end method

.method public executeCommand(Ljava/lang/String;Ljava/lang/String;Landroid/os/ParcelFileDescriptor;)V
    .registers 4
    .parameter "command"
    .parameter "parameters"
    .parameter "out"

    .prologue
    .line 59
    return-void
.end method

.method public resized(IILandroid/graphics/Rect;Landroid/graphics/Rect;ZLandroid/content/res/Configuration;)V
    .registers 8
    .parameter "w"
    .parameter "h"
    .parameter "contentInsets"
    .parameter "visibleInsets"
    .parameter "reportDraw"
    .parameter "newConfig"

    .prologue
    .line 38
    if-eqz p5, :cond_7

    .line 40
    :try_start_2
    iget-object v0, p0, Lcom/android/internal/view/BaseIWindow;->mSession:Landroid/view/IWindowSession;

    invoke-interface {v0, p0}, Landroid/view/IWindowSession;->finishDrawing(Landroid/view/IWindow;)V
    :try_end_7
    .catch Landroid/os/RemoteException; {:try_start_2 .. :try_end_7} :catch_8

    .line 44
    :cond_7
    :goto_7
    return-void

    .line 41
    :catch_8
    move-exception v0

    goto :goto_7
.end method

.method public setSession(Landroid/view/IWindowSession;)V
    .registers 2
    .parameter "session"

    .prologue
    .line 33
    iput-object p1, p0, Lcom/android/internal/view/BaseIWindow;->mSession:Landroid/view/IWindowSession;

    .line 34
    return-void
.end method

.method public windowFocusChanged(ZZ)V
    .registers 3
    .parameter "hasFocus"
    .parameter "touchEnabled"

    .prologue
    .line 56
    return-void
.end method
