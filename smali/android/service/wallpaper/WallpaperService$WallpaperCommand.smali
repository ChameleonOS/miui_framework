.class final Landroid/service/wallpaper/WallpaperService$WallpaperCommand;
.super Ljava/lang/Object;
.source "WallpaperService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/service/wallpaper/WallpaperService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "WallpaperCommand"
.end annotation


# instance fields
.field action:Ljava/lang/String;

.field extras:Landroid/os/Bundle;

.field sync:Z

.field x:I

.field y:I

.field z:I


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 107
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
