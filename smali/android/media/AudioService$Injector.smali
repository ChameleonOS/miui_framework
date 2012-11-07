.class Landroid/media/AudioService$Injector;
.super Ljava/lang/Object;
.source "AudioService.java"


# annotations
.annotation build Landroid/annotation/MiuiHook;
    value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_CLASS:Landroid/annotation/MiuiHook$MiuiHookType;
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/media/AudioService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Injector"
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 103
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static adjustDirection(Lmiui/view/VolumePanel;II)I
    .registers 4
    .parameter "volumePanel"
    .parameter "flags"
    .parameter "direction"

    .prologue
    .line 106
    and-int/lit8 v0, p1, 0x1

    if-eqz v0, :cond_b

    .line 107
    invoke-virtual {p0}, Lmiui/view/VolumePanel;->isVisible()Z

    move-result v0

    if-nez v0, :cond_b

    .line 108
    const/4 p2, 0x0

    .line 111
    :cond_b
    return p2
.end method
