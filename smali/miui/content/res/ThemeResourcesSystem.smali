.class public final Lmiui/content/res/ThemeResourcesSystem;
.super Lmiui/content/res/ThemeResources;
.source "ThemeResourcesSystem.java"


# static fields
.field private static sIcons:Lmiui/content/res/ThemeResources;

.field private static sLockscreen:Lmiui/content/res/ThemeResources;

.field private static sMiui:Lmiui/content/res/ThemeResources;


# instance fields
.field protected mThemePath:Ljava/lang/String;


# direct methods
.method protected constructor <init>(Lmiui/content/res/ThemeResourcesSystem;Landroid/content/res/Resources;Lmiui/content/res/ThemeResources$MetaData;)V
    .registers 5
    .parameter "wrapped"
    .parameter "resources"
    .parameter "metaData"

    .prologue
    .line 36
    const-string v0, "framework-res"

    invoke-direct {p0, p1, p2, v0, p3}, Lmiui/content/res/ThemeResources;-><init>(Lmiui/content/res/ThemeResources;Landroid/content/res/Resources;Ljava/lang/String;Lmiui/content/res/ThemeResources$MetaData;)V

    .line 37
    iget-object v0, p3, Lmiui/content/res/ThemeResources$MetaData;->themePath:Ljava/lang/String;

    iput-object v0, p0, Lmiui/content/res/ThemeResourcesSystem;->mThemePath:Ljava/lang/String;

    .line 38
    return-void
.end method

.method private getThemeFileStreamMIUI(Ljava/lang/String;Ljava/lang/String;)Lmiui/content/res/ThemeZipFile$ThemeFileInfo;
    .registers 5
    .parameter "relativeFilePath"
    .parameter "name"

    .prologue
    .line 76
    const/4 v0, 0x0

    .line 77
    .local v0, info:Lmiui/content/res/ThemeZipFile$ThemeFileInfo;
    const-string/jumbo v1, "lock_screen_"

    invoke-virtual {p2, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_18

    .line 78
    sget-object v1, Lmiui/content/res/ThemeResourcesSystem;->sLockscreen:Lmiui/content/res/ThemeResources;

    invoke-virtual {v1, p1}, Lmiui/content/res/ThemeResources;->getThemeFileStream(Ljava/lang/String;)Lmiui/content/res/ThemeZipFile$ThemeFileInfo;

    move-result-object v0

    .line 79
    if-nez v0, :cond_18

    .line 80
    sget-object v1, Lmiui/content/res/ThemeResourcesSystem;->sLockscreen:Lmiui/content/res/ThemeResources;

    invoke-virtual {v1, p2}, Lmiui/content/res/ThemeResources;->getThemeFileStream(Ljava/lang/String;)Lmiui/content/res/ThemeZipFile$ThemeFileInfo;

    move-result-object v0

    .line 83
    :cond_18
    if-nez v0, :cond_20

    .line 84
    sget-object v1, Lmiui/content/res/ThemeResourcesSystem;->sMiui:Lmiui/content/res/ThemeResources;

    invoke-virtual {v1, p1}, Lmiui/content/res/ThemeResources;->getThemeFileStream(Ljava/lang/String;)Lmiui/content/res/ThemeZipFile$ThemeFileInfo;

    move-result-object v0

    .line 86
    :cond_20
    return-object v0
.end method

.method private getThemeFileStreamSystem(Ljava/lang/String;Ljava/lang/String;)Lmiui/content/res/ThemeZipFile$ThemeFileInfo;
    .registers 5
    .parameter "relativeFilePath"
    .parameter "name"

    .prologue
    .line 90
    const/4 v0, 0x0

    .line 91
    .local v0, info:Lmiui/content/res/ThemeZipFile$ThemeFileInfo;
    const-string/jumbo v1, "sym_def_app_icon.png"

    invoke-virtual {p2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_18

    .line 92
    sget-object v1, Lmiui/content/res/ThemeResourcesSystem;->sIcons:Lmiui/content/res/ThemeResources;

    invoke-virtual {v1, p2}, Lmiui/content/res/ThemeResources;->getThemeFileStream(Ljava/lang/String;)Lmiui/content/res/ThemeZipFile$ThemeFileInfo;

    move-result-object v0

    .line 98
    :cond_10
    if-nez v0, :cond_16

    .line 99
    invoke-virtual {p0, p1}, Lmiui/content/res/ThemeResourcesSystem;->getThemeFileStreamInner(Ljava/lang/String;)Lmiui/content/res/ThemeZipFile$ThemeFileInfo;

    move-result-object v0

    :cond_16
    move-object v1, v0

    .line 101
    :goto_17
    return-object v1

    .line 94
    :cond_18
    const-string v1, "default_wallpaper.jpg"

    invoke-virtual {p2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_10

    .line 95
    const/4 v1, 0x0

    goto :goto_17
.end method

.method public static getTopLevelThemeResources(Landroid/content/res/Resources;)Lmiui/content/res/ThemeResourcesSystem;
    .registers 5
    .parameter "resources"

    .prologue
    .line 23
    const-string v3, "icons"

    invoke-static {p0, v3}, Lmiui/content/res/ThemeResources;->getTopLevelThemeResources(Landroid/content/res/Resources;Ljava/lang/String;)Lmiui/content/res/ThemeResources;

    move-result-object v3

    sput-object v3, Lmiui/content/res/ThemeResourcesSystem;->sIcons:Lmiui/content/res/ThemeResources;

    .line 24
    const-string/jumbo v3, "lockscreen"

    invoke-static {p0, v3}, Lmiui/content/res/ThemeResources;->getTopLevelThemeResources(Landroid/content/res/Resources;Ljava/lang/String;)Lmiui/content/res/ThemeResources;

    move-result-object v3

    sput-object v3, Lmiui/content/res/ThemeResourcesSystem;->sLockscreen:Lmiui/content/res/ThemeResources;

    .line 25
    const-string v3, "framework-miui-res"

    invoke-static {p0, v3}, Lmiui/content/res/ThemeResources;->getTopLevelThemeResources(Landroid/content/res/Resources;Ljava/lang/String;)Lmiui/content/res/ThemeResources;

    move-result-object v3

    sput-object v3, Lmiui/content/res/ThemeResourcesSystem;->sMiui:Lmiui/content/res/ThemeResources;

    .line 27
    const/4 v1, 0x0

    .line 28
    .local v1, themeResources:Lmiui/content/res/ThemeResourcesSystem;
    const/4 v0, 0x0

    .local v0, i:I
    :goto_1b
    sget-object v3, Lmiui/content/res/ThemeResourcesSystem;->THEME_PATHS:[Lmiui/content/res/ThemeResources$MetaData;

    array-length v3, v3

    if-ge v0, v3, :cond_2d

    .line 29
    new-instance v2, Lmiui/content/res/ThemeResourcesSystem;

    sget-object v3, Lmiui/content/res/ThemeResourcesSystem;->THEME_PATHS:[Lmiui/content/res/ThemeResources$MetaData;

    aget-object v3, v3, v0

    invoke-direct {v2, v1, p0, v3}, Lmiui/content/res/ThemeResourcesSystem;-><init>(Lmiui/content/res/ThemeResourcesSystem;Landroid/content/res/Resources;Lmiui/content/res/ThemeResources$MetaData;)V

    .line 28
    .end local v1           #themeResources:Lmiui/content/res/ThemeResourcesSystem;
    .local v2, themeResources:Lmiui/content/res/ThemeResourcesSystem;
    add-int/lit8 v0, v0, 0x1

    move-object v1, v2

    .end local v2           #themeResources:Lmiui/content/res/ThemeResourcesSystem;
    .restart local v1       #themeResources:Lmiui/content/res/ThemeResourcesSystem;
    goto :goto_1b

    .line 32
    :cond_2d
    return-object v1
.end method


# virtual methods
.method public checkUpdate()Z
    .registers 2

    .prologue
    .line 41
    sget-object v0, Lmiui/content/res/ThemeResourcesSystem;->sIcons:Lmiui/content/res/ThemeResources;

    invoke-virtual {v0}, Lmiui/content/res/ThemeResources;->checkUpdate()Z

    .line 42
    sget-object v0, Lmiui/content/res/ThemeResourcesSystem;->sLockscreen:Lmiui/content/res/ThemeResources;

    invoke-virtual {v0}, Lmiui/content/res/ThemeResources;->checkUpdate()Z

    .line 43
    sget-object v0, Lmiui/content/res/ThemeResourcesSystem;->sMiui:Lmiui/content/res/ThemeResources;

    invoke-virtual {v0}, Lmiui/content/res/ThemeResources;->checkUpdate()Z

    .line 44
    invoke-super {p0}, Lmiui/content/res/ThemeResources;->checkUpdate()Z

    move-result v0

    return v0
.end method

.method public containsAwesomeLockscreenEntry(Ljava/lang/String;)Z
    .registers 5
    .parameter "entry"

    .prologue
    .line 163
    sget-object v0, Lmiui/content/res/ThemeResourcesSystem;->sLockscreen:Lmiui/content/res/ThemeResources;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "advance/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lmiui/content/res/ThemeResources;->containsEntry(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public getAwesomeLockscreenFileStream(Ljava/lang/String;)Lmiui/content/res/ThemeZipFile$ThemeFileInfo;
    .registers 5
    .parameter "name"

    .prologue
    .line 167
    sget-object v0, Lmiui/content/res/ThemeResourcesSystem;->sLockscreen:Lmiui/content/res/ThemeResources;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "advance/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lmiui/content/res/ThemeResources;->getThemeFileStream(Ljava/lang/String;)Lmiui/content/res/ThemeZipFile$ThemeFileInfo;

    move-result-object v0

    return-object v0
.end method

.method public getIcon(Landroid/content/res/Resources;Ljava/lang/String;)Landroid/graphics/Bitmap;
    .registers 9
    .parameter "resource"
    .parameter "name"

    .prologue
    const/4 v3, 0x0

    .line 121
    invoke-virtual {p0, p2}, Lmiui/content/res/ThemeResourcesSystem;->getIconStream(Ljava/lang/String;)Lmiui/content/res/ThemeZipFile$ThemeFileInfo;

    move-result-object v0

    .line 122
    .local v0, info:Lmiui/content/res/ThemeZipFile$ThemeFileInfo;
    if-eqz v0, :cond_22

    .line 124
    const/4 v1, 0x0

    .line 125
    .local v1, opts:Landroid/graphics/BitmapFactory$Options;
    :try_start_8
    iget v4, v0, Lmiui/content/res/ThemeZipFile$ThemeFileInfo;->mDensity:I

    if-lez v4, :cond_16

    .line 126
    new-instance v2, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v2}, Landroid/graphics/BitmapFactory$Options;-><init>()V
    :try_end_11
    .catchall {:try_start_8 .. :try_end_11} :catchall_23
    .catch Ljava/lang/OutOfMemoryError; {:try_start_8 .. :try_end_11} :catch_2a

    .line 127
    .end local v1           #opts:Landroid/graphics/BitmapFactory$Options;
    .local v2, opts:Landroid/graphics/BitmapFactory$Options;
    :try_start_11
    iget v4, v0, Lmiui/content/res/ThemeZipFile$ThemeFileInfo;->mDensity:I

    iput v4, v2, Landroid/graphics/BitmapFactory$Options;->inDensity:I
    :try_end_15
    .catchall {:try_start_11 .. :try_end_15} :catchall_35
    .catch Ljava/lang/OutOfMemoryError; {:try_start_11 .. :try_end_15} :catch_38

    move-object v1, v2

    .line 129
    .end local v2           #opts:Landroid/graphics/BitmapFactory$Options;
    .restart local v1       #opts:Landroid/graphics/BitmapFactory$Options;
    :cond_16
    :try_start_16
    iget-object v4, v0, Lmiui/content/res/ThemeZipFile$ThemeFileInfo;->mInput:Ljava/io/InputStream;

    const/4 v5, 0x0

    invoke-static {v4, v5, v1}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    :try_end_1c
    .catchall {:try_start_16 .. :try_end_1c} :catchall_23
    .catch Ljava/lang/OutOfMemoryError; {:try_start_16 .. :try_end_1c} :catch_2a

    move-result-object v3

    .line 133
    :try_start_1d
    iget-object v4, v0, Lmiui/content/res/ThemeZipFile$ThemeFileInfo;->mInput:Ljava/io/InputStream;

    invoke-virtual {v4}, Ljava/io/InputStream;->close()V
    :try_end_22
    .catch Ljava/io/IOException; {:try_start_1d .. :try_end_22} :catch_31

    .line 139
    .end local v1           #opts:Landroid/graphics/BitmapFactory$Options;
    :cond_22
    :goto_22
    return-object v3

    .line 132
    .restart local v1       #opts:Landroid/graphics/BitmapFactory$Options;
    :catchall_23
    move-exception v3

    .line 133
    :goto_24
    :try_start_24
    iget-object v4, v0, Lmiui/content/res/ThemeZipFile$ThemeFileInfo;->mInput:Ljava/io/InputStream;

    invoke-virtual {v4}, Ljava/io/InputStream;->close()V
    :try_end_29
    .catch Ljava/io/IOException; {:try_start_24 .. :try_end_29} :catch_33

    .line 132
    :goto_29
    throw v3

    .line 130
    :catch_2a
    move-exception v4

    .line 133
    :goto_2b
    :try_start_2b
    iget-object v4, v0, Lmiui/content/res/ThemeZipFile$ThemeFileInfo;->mInput:Ljava/io/InputStream;

    invoke-virtual {v4}, Ljava/io/InputStream;->close()V
    :try_end_30
    .catch Ljava/io/IOException; {:try_start_2b .. :try_end_30} :catch_31

    goto :goto_22

    .line 134
    :catch_31
    move-exception v4

    goto :goto_22

    :catch_33
    move-exception v4

    goto :goto_29

    .line 132
    .end local v1           #opts:Landroid/graphics/BitmapFactory$Options;
    .restart local v2       #opts:Landroid/graphics/BitmapFactory$Options;
    :catchall_35
    move-exception v3

    move-object v1, v2

    .end local v2           #opts:Landroid/graphics/BitmapFactory$Options;
    .restart local v1       #opts:Landroid/graphics/BitmapFactory$Options;
    goto :goto_24

    .line 130
    .end local v1           #opts:Landroid/graphics/BitmapFactory$Options;
    .restart local v2       #opts:Landroid/graphics/BitmapFactory$Options;
    :catch_38
    move-exception v4

    move-object v1, v2

    .end local v2           #opts:Landroid/graphics/BitmapFactory$Options;
    .restart local v1       #opts:Landroid/graphics/BitmapFactory$Options;
    goto :goto_2b
.end method

.method public getIconStream(Ljava/lang/String;)Lmiui/content/res/ThemeZipFile$ThemeFileInfo;
    .registers 3
    .parameter "relativeFilePath"

    .prologue
    .line 143
    sget-object v0, Lmiui/content/res/ThemeResourcesSystem;->sIcons:Lmiui/content/res/ThemeResources;

    invoke-virtual {v0, p1}, Lmiui/content/res/ThemeResources;->getThemeFileStream(Ljava/lang/String;)Lmiui/content/res/ThemeZipFile$ThemeFileInfo;

    move-result-object v0

    return-object v0
.end method

.method public getLockscreenStream(Ljava/lang/String;)Lmiui/content/res/ThemeZipFile$ThemeFileInfo;
    .registers 3
    .parameter "relativeFilePath"

    .prologue
    .line 147
    sget-object v0, Lmiui/content/res/ThemeResourcesSystem;->sLockscreen:Lmiui/content/res/ThemeResources;

    invoke-virtual {v0, p1}, Lmiui/content/res/ThemeResources;->getThemeFileStream(Ljava/lang/String;)Lmiui/content/res/ThemeZipFile$ThemeFileInfo;

    move-result-object v0

    return-object v0
.end method

.method public getLockscreenWallpaper()Ljava/io/File;
    .registers 4

    .prologue
    .line 151
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lmiui/content/res/ThemeResourcesSystem;->mThemePath:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "lock_wallpaper"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 152
    .local v0, ret:Ljava/io/File;
    if-eqz v0, :cond_23

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v1

    if-nez v1, :cond_2f

    :cond_23
    iget-object v1, p0, Lmiui/content/res/ThemeResources;->mWrapped:Lmiui/content/res/ThemeResources;

    if-eqz v1, :cond_2f

    .line 153
    iget-object v1, p0, Lmiui/content/res/ThemeResources;->mWrapped:Lmiui/content/res/ThemeResources;

    check-cast v1, Lmiui/content/res/ThemeResourcesSystem;

    invoke-virtual {v1}, Lmiui/content/res/ThemeResourcesSystem;->getLockscreenWallpaper()Ljava/io/File;

    move-result-object v0

    .line 155
    :cond_2f
    return-object v0
.end method

.method public getThemeCharSequence(I)Ljava/lang/CharSequence;
    .registers 4
    .parameter "id"

    .prologue
    .line 65
    sget-object v1, Lmiui/content/res/ThemeResourcesSystem;->sLockscreen:Lmiui/content/res/ThemeResources;

    invoke-virtual {v1, p1}, Lmiui/content/res/ThemeResources;->getThemeCharSequence(I)Ljava/lang/CharSequence;

    move-result-object v0

    .line 66
    .local v0, ret:Ljava/lang/CharSequence;
    if-nez v0, :cond_e

    .line 67
    sget-object v1, Lmiui/content/res/ThemeResourcesSystem;->sMiui:Lmiui/content/res/ThemeResources;

    invoke-virtual {v1, p1}, Lmiui/content/res/ThemeResources;->getThemeCharSequence(I)Ljava/lang/CharSequence;

    move-result-object v0

    .line 69
    :cond_e
    if-nez v0, :cond_14

    .line 70
    invoke-virtual {p0, p1}, Lmiui/content/res/ThemeResourcesSystem;->getThemeCharSequenceInner(I)Ljava/lang/CharSequence;

    move-result-object v0

    .line 72
    :cond_14
    return-object v0
.end method

.method public getThemeFileStream(ILjava/lang/String;)Lmiui/content/res/ThemeZipFile$ThemeFileInfo;
    .registers 5
    .parameter "cookieType"
    .parameter "relativeFilePath"

    .prologue
    .line 106
    const/16 v1, 0x2f

    invoke-virtual {p2, v1}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v1

    add-int/lit8 v1, v1, 0x1

    invoke-virtual {p2, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    .line 107
    .local v0, name:Ljava/lang/String;
    const/4 v1, 0x2

    if-ne v1, p1, :cond_14

    invoke-direct {p0, p2, v0}, Lmiui/content/res/ThemeResourcesSystem;->getThemeFileStreamMIUI(Ljava/lang/String;Ljava/lang/String;)Lmiui/content/res/ThemeZipFile$ThemeFileInfo;

    move-result-object v1

    :goto_13
    return-object v1

    :cond_14
    invoke-direct {p0, p2, v0}, Lmiui/content/res/ThemeResourcesSystem;->getThemeFileStreamSystem(Ljava/lang/String;Ljava/lang/String;)Lmiui/content/res/ThemeZipFile$ThemeFileInfo;

    move-result-object v1

    goto :goto_13
.end method

.method public getThemeInt(I)Ljava/lang/Integer;
    .registers 4
    .parameter "id"

    .prologue
    .line 53
    sget-object v1, Lmiui/content/res/ThemeResourcesSystem;->sLockscreen:Lmiui/content/res/ThemeResources;

    invoke-virtual {v1, p1}, Lmiui/content/res/ThemeResources;->getThemeInt(I)Ljava/lang/Integer;

    move-result-object v0

    .line 54
    .local v0, ret:Ljava/lang/Integer;
    if-nez v0, :cond_e

    .line 55
    sget-object v1, Lmiui/content/res/ThemeResourcesSystem;->sMiui:Lmiui/content/res/ThemeResources;

    invoke-virtual {v1, p1}, Lmiui/content/res/ThemeResources;->getThemeInt(I)Ljava/lang/Integer;

    move-result-object v0

    .line 57
    :cond_e
    if-nez v0, :cond_14

    .line 58
    invoke-virtual {p0, p1}, Lmiui/content/res/ThemeResourcesSystem;->getThemeIntInner(I)Ljava/lang/Integer;

    move-result-object v0

    .line 60
    :cond_14
    return-object v0
.end method

.method public hasAwesomeLockscreen()Z
    .registers 3

    .prologue
    .line 159
    sget-object v0, Lmiui/content/res/ThemeResourcesSystem;->sLockscreen:Lmiui/content/res/ThemeResources;

    const-string v1, "advance/manifest.xml"

    invoke-virtual {v0, v1}, Lmiui/content/res/ThemeResources;->containsEntry(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public hasIcon(Ljava/lang/String;)Z
    .registers 3
    .parameter "name"

    .prologue
    .line 117
    sget-object v0, Lmiui/content/res/ThemeResourcesSystem;->sIcons:Lmiui/content/res/ThemeResources;

    invoke-virtual {v0, p1}, Lmiui/content/res/ThemeResources;->containsEntry(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public hasValues()Z
    .registers 2

    .prologue
    .line 48
    invoke-super {p0}, Lmiui/content/res/ThemeResources;->hasValues()Z

    move-result v0

    if-nez v0, :cond_16

    sget-object v0, Lmiui/content/res/ThemeResourcesSystem;->sLockscreen:Lmiui/content/res/ThemeResources;

    invoke-virtual {v0}, Lmiui/content/res/ThemeResources;->hasValues()Z

    move-result v0

    if-nez v0, :cond_16

    sget-object v0, Lmiui/content/res/ThemeResourcesSystem;->sMiui:Lmiui/content/res/ThemeResources;

    invoke-virtual {v0}, Lmiui/content/res/ThemeResources;->hasValues()Z

    move-result v0

    if-eqz v0, :cond_18

    :cond_16
    const/4 v0, 0x1

    :goto_17
    return v0

    :cond_18
    const/4 v0, 0x0

    goto :goto_17
.end method

.method public resetIcons()V
    .registers 2

    .prologue
    .line 113
    sget-object v0, Lmiui/content/res/ThemeResourcesSystem;->sIcons:Lmiui/content/res/ThemeResources;

    invoke-virtual {v0}, Lmiui/content/res/ThemeResources;->checkUpdate()Z

    .line 114
    return-void
.end method
