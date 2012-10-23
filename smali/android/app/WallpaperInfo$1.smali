.class final Landroid/app/WallpaperInfo$1;
.super Ljava/lang/Object;
.source "WallpaperInfo.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/app/WallpaperInfo;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/os/Parcelable$Creator",
        "<",
        "Landroid/app/WallpaperInfo;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 296
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Landroid/app/WallpaperInfo;
    .registers 3
    .parameter "source"

    .prologue
    .line 298
    new-instance v0, Landroid/app/WallpaperInfo;

    invoke-direct {v0, p1}, Landroid/app/WallpaperInfo;-><init>(Landroid/os/Parcel;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 296
    invoke-virtual {p0, p1}, Landroid/app/WallpaperInfo$1;->createFromParcel(Landroid/os/Parcel;)Landroid/app/WallpaperInfo;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Landroid/app/WallpaperInfo;
    .registers 3
    .parameter "size"

    .prologue
    .line 302
    new-array v0, p1, [Landroid/app/WallpaperInfo;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 296
    invoke-virtual {p0, p1}, Landroid/app/WallpaperInfo$1;->newArray(I)[Landroid/app/WallpaperInfo;

    move-result-object v0

    return-object v0
.end method
