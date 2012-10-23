.class public Lmiui/content/res/ThemeResources;
.super Ljava/lang/Object;
.source "ThemeResources.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lmiui/content/res/ThemeResources$MetaData;
    }
.end annotation


# static fields
.field public static final ADVANCE_LOCKSCREEN_NAME:Ljava/lang/String; = "advance"

.field static DBG:Z = false

.field public static final FRAMEWORK_NAME:Ljava/lang/String; = "framework-res"

.field public static final FRAMEWORK_PACKAGE:Ljava/lang/String; = "android"

.field public static final ICONS_NAME:Ljava/lang/String; = "icons"

.field public static final LANGUAGE_THEME_PATH:Ljava/lang/String; = "/data/system/language/"

.field public static final LOCKSCREEN_NAME:Ljava/lang/String; = "lockscreen"

.field public static final LOCKSCREEN_WALLPAPER_NAME:Ljava/lang/String; = "lock_wallpaper"

.field public static final MIUI_NAME:Ljava/lang/String; = "framework-miui-res"

.field public static final MIUI_PACKAGE:Ljava/lang/String; = "miui"

.field public static final SYSTEM_LANGUAGE_THEME_PATH:Ljava/lang/String; = "/system/language/"

.field public static final SYSTEM_THEME_PATH:Ljava/lang/String; = "/system/media/theme/default/"

.field public static final THEME_PATH:Ljava/lang/String; = "/data/system/theme/"

.field public static final THEME_PATHS:[Lmiui/content/res/ThemeResources$MetaData; = null

.field public static final WALLPAPER_NAME:Ljava/lang/String; = "wallpaper"

.field public static final sAppliedLockstyleConfigPath:Ljava/lang/String;

.field private static sLockWallpaperCache:Landroid/graphics/drawable/Drawable;

.field private static sLockWallpaperModifiedTime:J

.field private static sSystem:Lmiui/content/res/ThemeResourcesSystem;


# instance fields
.field protected mHasValue:Z

.field protected mHasWrapped:Z

.field protected mPackageZipFile:Lmiui/content/res/ThemeZipFile;

.field protected mResources:Landroid/content/res/Resources;

.field protected mSupportWrapper:Z

.field protected mWrapped:Lmiui/content/res/ThemeResources;


# direct methods
.method static constructor <clinit>()V
    .registers 5

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x1

    .line 19
    sput-boolean v4, Lmiui/content/res/ThemeResources;->DBG:Z

    .line 42
    const/4 v0, 0x2

    new-array v0, v0, [Lmiui/content/res/ThemeResources$MetaData;

    new-instance v1, Lmiui/content/res/ThemeResources$MetaData;

    const-string v2, "/system/media/theme/default/"

    invoke-direct {v1, v2, v3, v3, v3}, Lmiui/content/res/ThemeResources$MetaData;-><init>(Ljava/lang/String;ZZZ)V

    aput-object v1, v0, v4

    new-instance v1, Lmiui/content/res/ThemeResources$MetaData;

    const-string v2, "/data/system/theme/"

    invoke-direct {v1, v2, v3, v3, v3}, Lmiui/content/res/ThemeResources$MetaData;-><init>(Ljava/lang/String;ZZZ)V

    aput-object v1, v0, v3

    sput-object v0, Lmiui/content/res/ThemeResources;->THEME_PATHS:[Lmiui/content/res/ThemeResources$MetaData;

    .line 57
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "/data/system/theme/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "config.config"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lmiui/content/res/ThemeResources;->sAppliedLockstyleConfigPath:Ljava/lang/String;

    return-void
.end method

.method protected constructor <init>(Lmiui/content/res/ThemeResources;Landroid/content/res/Resources;Ljava/lang/String;Lmiui/content/res/ThemeResources$MetaData;)V
    .registers 6
    .parameter "wrapped"
    .parameter "resources"
    .parameter "componentName"
    .parameter "metaData"

    .prologue
    .line 88
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 89
    iput-object p1, p0, Lmiui/content/res/ThemeResources;->mWrapped:Lmiui/content/res/ThemeResources;

    .line 90
    iput-object p2, p0, Lmiui/content/res/ThemeResources;->mResources:Landroid/content/res/Resources;

    .line 91
    invoke-static {p4, p3}, Lmiui/content/res/ThemeZipFile;->getThemeZipFile(Lmiui/content/res/ThemeResources$MetaData;Ljava/lang/String;)Lmiui/content/res/ThemeZipFile;

    move-result-object v0

    iput-object v0, p0, Lmiui/content/res/ThemeResources;->mPackageZipFile:Lmiui/content/res/ThemeZipFile;

    .line 92
    const-string v0, "icons"

    invoke-virtual {v0, p3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1c

    const/4 v0, 0x1

    :goto_16
    iput-boolean v0, p0, Lmiui/content/res/ThemeResources;->mSupportWrapper:Z

    .line 93
    invoke-virtual {p0}, Lmiui/content/res/ThemeResources;->checkUpdate()Z

    .line 94
    return-void

    .line 92
    :cond_1c
    const/4 v0, 0x0

    goto :goto_16
.end method

.method public static final clearLockWallpaperCache()V
    .registers 2

    .prologue
    .line 168
    const-wide/16 v0, 0x0

    sput-wide v0, Lmiui/content/res/ThemeResources;->sLockWallpaperModifiedTime:J

    .line 169
    const/4 v0, 0x0

    sput-object v0, Lmiui/content/res/ThemeResources;->sLockWallpaperCache:Landroid/graphics/drawable/Drawable;

    .line 170
    return-void
.end method

.method public static final getLockWallpaperCache(Landroid/content/Context;)Landroid/graphics/drawable/Drawable;
    .registers 12
    .parameter "context"

    .prologue
    const/4 v6, 0x0

    .line 173
    sget-object v7, Lmiui/content/res/ThemeResources;->sSystem:Lmiui/content/res/ThemeResourcesSystem;

    invoke-virtual {v7}, Lmiui/content/res/ThemeResourcesSystem;->getLockscreenWallpaper()Ljava/io/File;

    move-result-object v2

    .line 175
    .local v2, file:Ljava/io/File;
    if-eqz v2, :cond_f

    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v7

    if-nez v7, :cond_10

    .line 204
    :cond_f
    :goto_f
    return-object v6

    .line 180
    :cond_10
    sget-wide v7, Lmiui/content/res/ThemeResources;->sLockWallpaperModifiedTime:J

    invoke-virtual {v2}, Ljava/io/File;->lastModified()J

    move-result-wide v9

    cmp-long v7, v7, v9

    if-nez v7, :cond_1d

    .line 181
    sget-object v6, Lmiui/content/res/ThemeResources;->sLockWallpaperCache:Landroid/graphics/drawable/Drawable;

    goto :goto_f

    .line 185
    :cond_1d
    invoke-virtual {v2}, Ljava/io/File;->lastModified()J

    move-result-wide v7

    sput-wide v7, Lmiui/content/res/ThemeResources;->sLockWallpaperModifiedTime:J

    .line 186
    sput-object v6, Lmiui/content/res/ThemeResources;->sLockWallpaperCache:Landroid/graphics/drawable/Drawable;

    .line 188
    :try_start_25
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v6

    invoke-virtual {v6}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    .line 189
    .local v1, display:Landroid/util/DisplayMetrics;
    iget v5, v1, Landroid/util/DisplayMetrics;->widthPixels:I

    .line 190
    .local v5, width:I
    iget v3, v1, Landroid/util/DisplayMetrics;->heightPixels:I

    .line 191
    .local v3, height:I
    if-le v5, v3, :cond_58

    .line 192
    const-string v6, "LockWallpaper"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Wrong display metrics for width = "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, " and height = "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 193
    move v4, v5

    .line 194
    .local v4, tmp:I
    move v5, v3

    .line 195
    move v3, v4

    .line 198
    .end local v4           #tmp:I
    :cond_58
    new-instance v6, Lmiui/util/InputStreamLoader;

    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Lmiui/util/InputStreamLoader;-><init>(Ljava/lang/String;)V

    invoke-static {v6, v5, v3}, Lmiui/util/ImageUtils;->getBitmap(Lmiui/util/InputStreamLoader;II)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 199
    .local v0, bitmap:Landroid/graphics/Bitmap;
    new-instance v6, Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    invoke-direct {v6, v7, v0}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    sput-object v6, Lmiui/content/res/ThemeResources;->sLockWallpaperCache:Landroid/graphics/drawable/Drawable;
    :try_end_70
    .catch Ljava/lang/Exception; {:try_start_25 .. :try_end_70} :catch_75
    .catch Ljava/lang/OutOfMemoryError; {:try_start_25 .. :try_end_70} :catch_73

    .line 204
    .end local v0           #bitmap:Landroid/graphics/Bitmap;
    .end local v1           #display:Landroid/util/DisplayMetrics;
    .end local v3           #height:I
    .end local v5           #width:I
    :goto_70
    sget-object v6, Lmiui/content/res/ThemeResources;->sLockWallpaperCache:Landroid/graphics/drawable/Drawable;

    goto :goto_f

    .line 201
    :catch_73
    move-exception v6

    goto :goto_70

    .line 200
    :catch_75
    move-exception v6

    goto :goto_70
.end method

.method public static getSystem(Landroid/content/res/Resources;)Lmiui/content/res/ThemeResources;
    .registers 2
    .parameter "resources"

    .prologue
    .line 67
    sget-object v0, Lmiui/content/res/ThemeResources;->sSystem:Lmiui/content/res/ThemeResourcesSystem;

    if-nez v0, :cond_a

    .line 68
    invoke-static {p0}, Lmiui/content/res/ThemeResourcesSystem;->getTopLevelThemeResources(Landroid/content/res/Resources;)Lmiui/content/res/ThemeResourcesSystem;

    move-result-object v0

    sput-object v0, Lmiui/content/res/ThemeResources;->sSystem:Lmiui/content/res/ThemeResourcesSystem;

    .line 70
    :cond_a
    sget-object v0, Lmiui/content/res/ThemeResources;->sSystem:Lmiui/content/res/ThemeResourcesSystem;

    return-object v0
.end method

.method public static getSystem()Lmiui/content/res/ThemeResourcesSystem;
    .registers 1

    .prologue
    .line 62
    sget-object v0, Lmiui/content/res/ThemeResources;->sSystem:Lmiui/content/res/ThemeResourcesSystem;

    return-object v0
.end method

.method public static getTopLevelThemeResources(Landroid/content/res/Resources;Ljava/lang/String;)Lmiui/content/res/ThemeResources;
    .registers 6
    .parameter "resources"
    .parameter "componentName"

    .prologue
    .line 74
    const/4 v1, 0x0

    .line 75
    .local v1, themeResources:Lmiui/content/res/ThemeResources;
    const/4 v0, 0x0

    .local v0, i:I
    :goto_2
    sget-object v3, Lmiui/content/res/ThemeResources;->THEME_PATHS:[Lmiui/content/res/ThemeResources$MetaData;

    array-length v3, v3

    if-ge v0, v3, :cond_14

    .line 76
    new-instance v2, Lmiui/content/res/ThemeResources;

    sget-object v3, Lmiui/content/res/ThemeResources;->THEME_PATHS:[Lmiui/content/res/ThemeResources$MetaData;

    aget-object v3, v3, v0

    invoke-direct {v2, v1, p0, p1, v3}, Lmiui/content/res/ThemeResources;-><init>(Lmiui/content/res/ThemeResources;Landroid/content/res/Resources;Ljava/lang/String;Lmiui/content/res/ThemeResources$MetaData;)V

    .line 75
    .end local v1           #themeResources:Lmiui/content/res/ThemeResources;
    .local v2, themeResources:Lmiui/content/res/ThemeResources;
    add-int/lit8 v0, v0, 0x1

    move-object v1, v2

    .end local v2           #themeResources:Lmiui/content/res/ThemeResources;
    .restart local v1       #themeResources:Lmiui/content/res/ThemeResources;
    goto :goto_2

    .line 78
    :cond_14
    return-object v1
.end method


# virtual methods
.method public checkUpdate()Z
    .registers 6

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 97
    iget-object v1, p0, Lmiui/content/res/ThemeResources;->mPackageZipFile:Lmiui/content/res/ThemeZipFile;

    iget-object v4, p0, Lmiui/content/res/ThemeResources;->mResources:Landroid/content/res/Resources;

    invoke-virtual {v1, v4}, Lmiui/content/res/ThemeZipFile;->checkUpdate(Landroid/content/res/Resources;)Z

    move-result v0

    .line 98
    .local v0, result:Z
    iget-object v1, p0, Lmiui/content/res/ThemeResources;->mWrapped:Lmiui/content/res/ThemeResources;

    if-eqz v1, :cond_33

    iget-boolean v1, p0, Lmiui/content/res/ThemeResources;->mSupportWrapper:Z

    if-nez v1, :cond_1a

    iget-object v1, p0, Lmiui/content/res/ThemeResources;->mPackageZipFile:Lmiui/content/res/ThemeZipFile;

    invoke-virtual {v1}, Lmiui/content/res/ThemeZipFile;->exists()Z

    move-result v1

    if-nez v1, :cond_33

    :cond_1a
    move v1, v2

    :goto_1b
    iput-boolean v1, p0, Lmiui/content/res/ThemeResources;->mHasWrapped:Z

    .line 99
    iget-boolean v1, p0, Lmiui/content/res/ThemeResources;->mHasWrapped:Z

    if-eqz v1, :cond_2c

    .line 100
    iget-object v1, p0, Lmiui/content/res/ThemeResources;->mWrapped:Lmiui/content/res/ThemeResources;

    invoke-virtual {v1}, Lmiui/content/res/ThemeResources;->checkUpdate()Z

    move-result v1

    if-nez v1, :cond_2b

    if-eqz v0, :cond_35

    :cond_2b
    move v0, v2

    .line 102
    :cond_2c
    :goto_2c
    invoke-virtual {p0}, Lmiui/content/res/ThemeResources;->hasValuesInner()Z

    move-result v1

    iput-boolean v1, p0, Lmiui/content/res/ThemeResources;->mHasValue:Z

    .line 103
    return v0

    :cond_33
    move v1, v3

    .line 98
    goto :goto_1b

    :cond_35
    move v0, v3

    .line 100
    goto :goto_2c
.end method

.method public containsEntry(Ljava/lang/String;)Z
    .registers 4
    .parameter "name"

    .prologue
    .line 117
    iget-object v1, p0, Lmiui/content/res/ThemeResources;->mPackageZipFile:Lmiui/content/res/ThemeZipFile;

    invoke-virtual {v1, p1}, Lmiui/content/res/ThemeZipFile;->containsEntry(Ljava/lang/String;)Z

    move-result v0

    .line 118
    .local v0, ret:Z
    if-nez v0, :cond_1a

    iget-object v1, p0, Lmiui/content/res/ThemeResources;->mPackageZipFile:Lmiui/content/res/ThemeZipFile;

    invoke-virtual {v1}, Lmiui/content/res/ThemeZipFile;->exists()Z

    move-result v1

    if-nez v1, :cond_1a

    iget-object v1, p0, Lmiui/content/res/ThemeResources;->mWrapped:Lmiui/content/res/ThemeResources;

    if-eqz v1, :cond_1a

    .line 119
    iget-object v1, p0, Lmiui/content/res/ThemeResources;->mWrapped:Lmiui/content/res/ThemeResources;

    invoke-virtual {v1, p1}, Lmiui/content/res/ThemeResources;->containsEntry(Ljava/lang/String;)Z

    move-result v0

    .line 121
    :cond_1a
    return v0
.end method

.method public getThemeCharSequence(I)Ljava/lang/CharSequence;
    .registers 3
    .parameter "id"

    .prologue
    .line 145
    invoke-virtual {p0, p1}, Lmiui/content/res/ThemeResources;->getThemeCharSequenceInner(I)Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method protected getThemeCharSequenceInner(I)Ljava/lang/CharSequence;
    .registers 4
    .parameter "id"

    .prologue
    .line 137
    iget-object v1, p0, Lmiui/content/res/ThemeResources;->mPackageZipFile:Lmiui/content/res/ThemeZipFile;

    invoke-virtual {v1, p1}, Lmiui/content/res/ThemeZipFile;->getThemeCharSequence(I)Ljava/lang/CharSequence;

    move-result-object v0

    .line 138
    .local v0, ret:Ljava/lang/CharSequence;
    if-nez v0, :cond_12

    iget-boolean v1, p0, Lmiui/content/res/ThemeResources;->mHasWrapped:Z

    if-eqz v1, :cond_12

    .line 139
    iget-object v1, p0, Lmiui/content/res/ThemeResources;->mWrapped:Lmiui/content/res/ThemeResources;

    invoke-virtual {v1, p1}, Lmiui/content/res/ThemeResources;->getThemeCharSequenceInner(I)Ljava/lang/CharSequence;

    move-result-object v0

    .line 141
    :cond_12
    return-object v0
.end method

.method public getThemeFileStream(ILjava/lang/String;)Lmiui/content/res/ThemeZipFile$ThemeFileInfo;
    .registers 4
    .parameter "cookieType"
    .parameter "fileName"

    .prologue
    .line 161
    invoke-virtual {p0, p2}, Lmiui/content/res/ThemeResources;->getThemeFileStream(Ljava/lang/String;)Lmiui/content/res/ThemeZipFile$ThemeFileInfo;

    move-result-object v0

    return-object v0
.end method

.method public getThemeFileStream(Ljava/lang/String;)Lmiui/content/res/ThemeZipFile$ThemeFileInfo;
    .registers 3
    .parameter "relativeFilePath"

    .prologue
    .line 157
    invoke-virtual {p0, p1}, Lmiui/content/res/ThemeResources;->getThemeFileStreamInner(Ljava/lang/String;)Lmiui/content/res/ThemeZipFile$ThemeFileInfo;

    move-result-object v0

    return-object v0
.end method

.method protected getThemeFileStreamInner(Ljava/lang/String;)Lmiui/content/res/ThemeZipFile$ThemeFileInfo;
    .registers 4
    .parameter "relativeFilePath"

    .prologue
    .line 149
    iget-object v1, p0, Lmiui/content/res/ThemeResources;->mPackageZipFile:Lmiui/content/res/ThemeZipFile;

    invoke-virtual {v1, p1}, Lmiui/content/res/ThemeZipFile;->getInputStream(Ljava/lang/String;)Lmiui/content/res/ThemeZipFile$ThemeFileInfo;

    move-result-object v0

    .line 150
    .local v0, ret:Lmiui/content/res/ThemeZipFile$ThemeFileInfo;
    if-nez v0, :cond_12

    iget-boolean v1, p0, Lmiui/content/res/ThemeResources;->mHasWrapped:Z

    if-eqz v1, :cond_12

    .line 151
    iget-object v1, p0, Lmiui/content/res/ThemeResources;->mWrapped:Lmiui/content/res/ThemeResources;

    invoke-virtual {v1, p1}, Lmiui/content/res/ThemeResources;->getThemeFileStreamInner(Ljava/lang/String;)Lmiui/content/res/ThemeZipFile$ThemeFileInfo;

    move-result-object v0

    .line 153
    :cond_12
    return-object v0
.end method

.method public getThemeInt(I)Ljava/lang/Integer;
    .registers 3
    .parameter "id"

    .prologue
    .line 133
    invoke-virtual {p0, p1}, Lmiui/content/res/ThemeResources;->getThemeIntInner(I)Ljava/lang/Integer;

    move-result-object v0

    return-object v0
.end method

.method protected getThemeIntInner(I)Ljava/lang/Integer;
    .registers 4
    .parameter "id"

    .prologue
    .line 125
    iget-object v1, p0, Lmiui/content/res/ThemeResources;->mPackageZipFile:Lmiui/content/res/ThemeZipFile;

    invoke-virtual {v1, p1}, Lmiui/content/res/ThemeZipFile;->getThemeInt(I)Ljava/lang/Integer;

    move-result-object v0

    .line 126
    .local v0, ret:Ljava/lang/Integer;
    if-nez v0, :cond_12

    iget-boolean v1, p0, Lmiui/content/res/ThemeResources;->mHasWrapped:Z

    if-eqz v1, :cond_12

    .line 127
    iget-object v1, p0, Lmiui/content/res/ThemeResources;->mWrapped:Lmiui/content/res/ThemeResources;

    invoke-virtual {v1, p1}, Lmiui/content/res/ThemeResources;->getThemeIntInner(I)Ljava/lang/Integer;

    move-result-object v0

    .line 129
    :cond_12
    return-object v0
.end method

.method public hasValues()Z
    .registers 2

    .prologue
    .line 111
    iget-boolean v0, p0, Lmiui/content/res/ThemeResources;->mHasValue:Z

    return v0
.end method

.method protected hasValuesInner()Z
    .registers 2

    .prologue
    .line 107
    iget-object v0, p0, Lmiui/content/res/ThemeResources;->mPackageZipFile:Lmiui/content/res/ThemeZipFile;

    invoke-virtual {v0}, Lmiui/content/res/ThemeZipFile;->hasValues()Z

    move-result v0

    if-nez v0, :cond_14

    iget-boolean v0, p0, Lmiui/content/res/ThemeResources;->mHasWrapped:Z

    if-eqz v0, :cond_16

    iget-object v0, p0, Lmiui/content/res/ThemeResources;->mWrapped:Lmiui/content/res/ThemeResources;

    invoke-virtual {v0}, Lmiui/content/res/ThemeResources;->hasValuesInner()Z

    move-result v0

    if-eqz v0, :cond_16

    :cond_14
    const/4 v0, 0x1

    :goto_15
    return v0

    :cond_16
    const/4 v0, 0x0

    goto :goto_15
.end method
