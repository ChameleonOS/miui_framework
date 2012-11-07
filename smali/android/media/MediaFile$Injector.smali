.class Landroid/media/MediaFile$Injector;
.super Ljava/lang/Object;
.source "MediaFile.java"


# annotations
.annotation build Landroid/annotation/MiuiHook;
    value = .enum Landroid/annotation/MiuiHook$MiuiHookType;->NEW_CLASS:Landroid/annotation/MiuiHook$MiuiHookType;
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/media/MediaFile;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Injector"
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 41
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static addAPE()V
    .registers 3

    .prologue
    .line 43
    const-string v0, "APE"

    const/16 v1, 0x3e9

    const-string v2, "audio/x-monkeys-audio"

    invoke-static {v0, v1, v2}, Landroid/media/MediaFile;->addFileType(Ljava/lang/String;ILjava/lang/String;)V

    return-void
.end method

.method static isFFMpegAudoFileType(I)Z
    .registers 2
    .parameter "fileType"

    .prologue
    const/16 v0, 0x3e9

    .line 45
    if-lt p0, v0, :cond_8

    if-gt p0, v0, :cond_8

    const/4 v0, 0x1

    :goto_7
    return v0

    :cond_8
    const/4 v0, 0x0

    goto :goto_7
.end method

.method static isWMAEnabled()Z
    .registers 1

    .prologue
    .line 42
    const/4 v0, 0x1

    return v0
.end method
