.class final Landroid/service/wallpaper/WallpaperService$Engine$WallpaperInputEventReceiver;
.super Landroid/view/InputEventReceiver;
.source "WallpaperService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/service/wallpaper/WallpaperService$Engine;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x10
    name = "WallpaperInputEventReceiver"
.end annotation


# instance fields
.field final synthetic this$1:Landroid/service/wallpaper/WallpaperService$Engine;


# direct methods
.method public constructor <init>(Landroid/service/wallpaper/WallpaperService$Engine;Landroid/view/InputChannel;Landroid/os/Looper;)V
    .registers 4
    .parameter
    .parameter "inputChannel"
    .parameter "looper"

    .prologue
    iput-object p1, p0, Landroid/service/wallpaper/WallpaperService$Engine$WallpaperInputEventReceiver;->this$1:Landroid/service/wallpaper/WallpaperService$Engine;

    invoke-direct {p0, p2, p3}, Landroid/view/InputEventReceiver;-><init>(Landroid/view/InputChannel;Landroid/os/Looper;)V

    return-void
.end method


# virtual methods
.method public onInputEvent(Landroid/view/InputEvent;)V
    .registers 6
    .parameter "event"

    .prologue
    const/4 v2, 0x0

    .local v2, handled:Z
    :try_start_1
    instance-of v3, p1, Landroid/view/MotionEvent;

    if-eqz v3, :cond_1b

    invoke-virtual {p1}, Landroid/view/InputEvent;->getSource()I

    move-result v3

    and-int/lit8 v3, v3, 0x2

    if-eqz v3, :cond_1b

    move-object v0, p1

    check-cast v0, Landroid/view/MotionEvent;

    move-object v3, v0

    invoke-static {v3}, Landroid/view/MotionEvent;->obtainNoHistory(Landroid/view/MotionEvent;)Landroid/view/MotionEvent;

    move-result-object v1

    .local v1, dup:Landroid/view/MotionEvent;
    iget-object v3, p0, Landroid/service/wallpaper/WallpaperService$Engine$WallpaperInputEventReceiver;->this$1:Landroid/service/wallpaper/WallpaperService$Engine;

    #calls: Landroid/service/wallpaper/WallpaperService$Engine;->dispatchPointer(Landroid/view/MotionEvent;)V
    invoke-static {v3, v1}, Landroid/service/wallpaper/WallpaperService$Engine;->access$000(Landroid/service/wallpaper/WallpaperService$Engine;Landroid/view/MotionEvent;)V
    :try_end_1a
    .catchall {:try_start_1 .. :try_end_1a} :catchall_1f

    const/4 v2, 0x1

    .end local v1           #dup:Landroid/view/MotionEvent;
    :cond_1b
    invoke-virtual {p0, p1, v2}, Landroid/service/wallpaper/WallpaperService$Engine$WallpaperInputEventReceiver;->finishInputEvent(Landroid/view/InputEvent;Z)V

    return-void

    :catchall_1f
    move-exception v3

    invoke-virtual {p0, p1, v2}, Landroid/service/wallpaper/WallpaperService$Engine$WallpaperInputEventReceiver;->finishInputEvent(Landroid/view/InputEvent;Z)V

    throw v3
.end method
