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
    .line 35
    const-string v0, "framework-res"

    invoke-direct {p0, p1, p2, v0, p3}, Lmiui/content/res/ThemeResources;-><init>(Lmiui/content/res/ThemeResources;Landroid/content/res/Resources;Ljava/lang/String;Lmiui/content/res/ThemeResources$MetaData;)V

    .line 36
    iget-object v0, p3, Lmiui/content/res/ThemeResources$MetaData;->themePath:Ljava/lang/String;

    iput-object v0, p0, Lmiui/content/res/ThemeResourcesSystem;->mThemePath:Ljava/lang/String;

    .line 37
    return-void
.end method

.method private getThemeFileStreamMIUI(Ljava/lang/String;Ljava/lang/String;[I)Ljava/io/InputStream;
    .registers 7
    .parameter "relativeFilePath"
    .parameter "name"
    .parameter "size"

    .prologue
    const/4 v2, 0x0

    .line 75
    const/4 v0, 0x0

    .line 76
    .local v0, is:Ljava/io/InputStream;
    const-string/jumbo v1, "lock_screen_"

    invoke-virtual {p2, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_19

    .line 77
    sget-object v1, Lmiui/content/res/ThemeResourcesSystem;->sLockscreen:Lmiui/content/res/ThemeResources;

    invoke-virtual {v1, p1, v2}, Lmiui/content/res/ThemeResources;->getThemeFileStream(Ljava/lang/String;[I)Ljava/io/InputStream;

    move-result-object v0

    .line 78
    if-nez v0, :cond_19

    .line 79
    sget-object v1, Lmiui/content/res/ThemeResourcesSystem;->sLockscreen:Lmiui/content/res/ThemeResources;

    invoke-virtual {v1, p2, v2}, Lmiui/content/res/ThemeResources;->getThemeFileStream(Ljava/lang/String;[I)Ljava/io/InputStream;

    move-result-object v0

    .line 82
    :cond_19
    if-nez v0, :cond_21

    .line 83
    sget-object v1, Lmiui/content/res/ThemeResourcesSystem;->sMiui:Lmiui/content/res/ThemeResources;

    invoke-virtual {v1, p1, v2}, Lmiui/content/res/ThemeResources;->getThemeFileStream(Ljava/lang/String;[I)Ljava/io/InputStream;

    move-result-object v0

    .line 85
    :cond_21
    return-object v0
.end method

.method private getThemeFileStreamSystem(Ljava/lang/String;Ljava/lang/String;[I)Ljava/io/InputStream;
    .registers 6
    .parameter "relativeFilePath"
    .parameter "name"
    .parameter "size"

    .prologue
    .line 89
    const/4 v0, 0x0

    .line 90
    .local v0, is:Ljava/io/InputStream;
    const-string/jumbo v1, "sym_def_app_icon.png"

    invoke-virtual {p2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_18

    .line 91
    sget-object v1, Lmiui/content/res/ThemeResourcesSystem;->sIcons:Lmiui/content/res/ThemeResources;

    invoke-virtual {v1, p2, p3}, Lmiui/content/res/ThemeResources;->getThemeFileStream(Ljava/lang/String;[I)Ljava/io/InputStream;

    move-result-object v0

    .line 97
    :cond_10
    if-nez v0, :cond_16

    .line 98
    invoke-virtual {p0, p1, p3}, Lmiui/content/res/ThemeResourcesSystem;->getThemeFileStreamInner(Ljava/lang/String;[I)Ljava/io/InputStream;

    move-result-object v0

    :cond_16
    move-object v1, v0

    .line 100
    :goto_17
    return-object v1

    .line 93
    :cond_18
    const-string v1, "default_wallpaper.jpg"

    invoke-virtual {p2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_10

    .line 94
    const/4 v1, 0x0

    goto :goto_17
.end method

.method public static getTopLevelThemeResources(Landroid/content/res/Resources;)Lmiui/content/res/ThemeResourcesSystem;
    .registers 5
    .parameter "resources"

    .prologue
    .line 22
    const-string v3, "icons"

    invoke-static {p0, v3}, Lmiui/content/res/ThemeResources;->getTopLevelThemeResources(Landroid/content/res/Resources;Ljava/lang/String;)Lmiui/content/res/ThemeResources;

    move-result-object v3

    sput-object v3, Lmiui/content/res/ThemeResourcesSystem;->sIcons:Lmiui/content/res/ThemeResources;

    .line 23
    const-string/jumbo v3, "lockscreen"

    invoke-static {p0, v3}, Lmiui/content/res/ThemeResources;->getTopLevelThemeResources(Landroid/content/res/Resources;Ljava/lang/String;)Lmiui/content/res/ThemeResources;

    move-result-object v3

    sput-object v3, Lmiui/content/res/ThemeResourcesSystem;->sLockscreen:Lmiui/content/res/ThemeResources;

    .line 24
    const-string v3, "framework-miui-res"

    invoke-static {p0, v3}, Lmiui/content/res/ThemeResources;->getTopLevelThemeResources(Landroid/content/res/Resources;Ljava/lang/String;)Lmiui/content/res/ThemeResources;

    move-result-object v3

    sput-object v3, Lmiui/content/res/ThemeResourcesSystem;->sMiui:Lmiui/content/res/ThemeResources;

    .line 26
    const/4 v1, 0x0

    .line 27
    .local v1, themeResources:Lmiui/content/res/ThemeResourcesSystem;
    const/4 v0, 0x0

    .local v0, i:I
    :goto_1b
    sget-object v3, Lmiui/content/res/ThemeResourcesSystem;->THEME_PATHS:[Lmiui/content/res/ThemeResources$MetaData;

    array-length v3, v3

    if-ge v0, v3, :cond_2d

    .line 28
    new-instance v2, Lmiui/content/res/ThemeResourcesSystem;

    sget-object v3, Lmiui/content/res/ThemeResourcesSystem;->THEME_PATHS:[Lmiui/content/res/ThemeResources$MetaData;

    aget-object v3, v3, v0

    invoke-direct {v2, v1, p0, v3}, Lmiui/content/res/ThemeResourcesSystem;-><init>(Lmiui/content/res/ThemeResourcesSystem;Landroid/content/res/Resources;Lmiui/content/res/ThemeResources$MetaData;)V

    .line 27
    .end local v1           #themeResources:Lmiui/content/res/ThemeResourcesSystem;
    .local v2, themeResources:Lmiui/content/res/ThemeResourcesSystem;
    add-int/lit8 v0, v0, 0x1

    move-object v1, v2

    .end local v2           #themeResources:Lmiui/content/res/ThemeResourcesSystem;
    .restart local v1       #themeResources:Lmiui/content/res/ThemeResourcesSystem;
    goto :goto_1b

    .line 31
    :cond_2d
    return-object v1
.end method


# virtual methods
.method public checkUpdate()Z
    .registers 2

    .prologue
    .line 40
    sget-object v0, Lmiui/content/res/ThemeResourcesSystem;->sIcons:Lmiui/content/res/ThemeResources;

    invoke-virtual {v0}, Lmiui/content/res/ThemeResources;->checkUpdate()Z

    .line 41
    sget-object v0, Lmiui/content/res/ThemeResourcesSystem;->sLockscreen:Lmiui/content/res/ThemeResources;

    invoke-virtual {v0}, Lmiui/content/res/ThemeResources;->checkUpdate()Z

    .line 42
    sget-object v0, Lmiui/content/res/ThemeResourcesSystem;->sMiui:Lmiui/content/res/ThemeResources;

    invoke-virtual {v0}, Lmiui/content/res/ThemeResources;->checkUpdate()Z

    .line 43
    invoke-super {p0}, Lmiui/content/res/ThemeResources;->checkUpdate()Z

    move-result v0

    return v0
.end method

.method public containsAwesomeLockscreenEntry(Ljava/lang/String;)Z
    .registers 5
    .parameter "entry"

    .prologue
    .line 153
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

.method public getAwesomeLockscreenFileStream(Ljava/lang/String;[I)Ljava/io/InputStream;
    .registers 6
    .parameter "name"
    .parameter "size"

    .prologue
    .line 157
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

    invoke-virtual {v0, v1, p2}, Lmiui/content/res/ThemeResources;->getThemeFileStream(Ljava/lang/String;[I)Ljava/io/InputStream;

    move-result-object v0

    return-object v0
.end method

.method public getIcon(Landroid/content/res/Resources;Ljava/lang/String;)Landroid/graphics/Bitmap;
    .registers 6
    .parameter "resource"
    .parameter "name"

    .prologue
    .line 120
    const/4 v2, 0x0

    invoke-virtual {p0, p2, v2}, Lmiui/content/res/ThemeResourcesSystem;->getIconStream(Ljava/lang/String;[I)Ljava/io/InputStream;

    move-result-object v1

    .line 121
    .local v1, is:Ljava/io/InputStream;
    invoke-static {v1}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 124
    .local v0, icon:Landroid/graphics/Bitmap;
    if-eqz v1, :cond_e

    :try_start_b
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V
    :try_end_e
    .catch Ljava/io/IOException; {:try_start_b .. :try_end_e} :catch_f

    .line 129
    :cond_e
    :goto_e
    return-object v0

    .line 125
    :catch_f
    move-exception v2

    goto :goto_e
.end method

.method public getIconStream(Ljava/lang/String;[I)Ljava/io/InputStream;
    .registers 4
    .parameter "relativeFilePath"
    .parameter "size"

    .prologue
    .line 133
    sget-object v0, Lmiui/content/res/ThemeResourcesSystem;->sIcons:Lmiui/content/res/ThemeResources;

    invoke-virtual {v0, p1, p2}, Lmiui/content/res/ThemeResources;->getThemeFileStream(Ljava/lang/String;[I)Ljava/io/InputStream;

    move-result-object v0

    return-object v0
.end method

.method public getLockscreenStream(Ljava/lang/String;[I)Ljava/io/InputStream;
    .registers 4
    .parameter "relativeFilePath"
    .parameter "size"

    .prologue
    .line 137
    sget-object v0, Lmiui/content/res/ThemeResourcesSystem;->sLockscreen:Lmiui/content/res/ThemeResources;

    invoke-virtual {v0, p1, p2}, Lmiui/content/res/ThemeResources;->getThemeFileStream(Ljava/lang/String;[I)Ljava/io/InputStream;

    move-result-object v0

    return-object v0
.end method

.method public getLockscreenWallpaper()Ljava/io/File;
    .registers 4

    .prologue
    .line 141
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

    .line 142
    .local v0, ret:Ljava/io/File;
    if-eqz v0, :cond_23

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v1

    if-nez v1, :cond_2f

    :cond_23
    iget-object v1, p0, Lmiui/content/res/ThemeResources;->mWrapped:Lmiui/content/res/ThemeResources;

    if-eqz v1, :cond_2f

    .line 143
    iget-object v1, p0, Lmiui/content/res/ThemeResources;->mWrapped:Lmiui/content/res/ThemeResources;

    check-cast v1, Lmiui/content/res/ThemeResourcesSystem;

    invoke-virtual {v1}, Lmiui/content/res/ThemeResourcesSystem;->getLockscreenWallpaper()Ljava/io/File;

    move-result-object v0

    .line 145
    :cond_2f
    return-object v0
.end method

.method public getThemeCharSequence(I)Ljava/lang/CharSequence;
    .registers 4
    .parameter "id"

    .prologue
    .line 64
    sget-object v1, Lmiui/content/res/ThemeResourcesSystem;->sLockscreen:Lmiui/content/res/ThemeResources;

    invoke-virtual {v1, p1}, Lmiui/content/res/ThemeResources;->getThemeCharSequence(I)Ljava/lang/CharSequence;

    move-result-object v0

    .line 65
    .local v0, ret:Ljava/lang/CharSequence;
    if-nez v0, :cond_e

    .line 66
    sget-object v1, Lmiui/content/res/ThemeResourcesSystem;->sMiui:Lmiui/content/res/ThemeResources;

    invoke-virtual {v1, p1}, Lmiui/content/res/ThemeResources;->getThemeCharSequence(I)Ljava/lang/CharSequence;

    move-result-object v0

    .line 68
    :cond_e
    if-nez v0, :cond_14

    .line 69
    invoke-virtual {p0, p1}, Lmiui/content/res/ThemeResourcesSystem;->getThemeCharSequenceInner(I)Ljava/lang/CharSequence;

    move-result-object v0

    .line 71
    :cond_14
    return-object v0
.end method

.method public getThemeFileStream(ILjava/lang/String;)Ljava/io/InputStream;
    .registers 6
    .parameter "cookieType"
    .parameter "relativeFilePath"

    .prologue
    const/4 v2, 0x0

    .line 105
    const/16 v1, 0x2f

    invoke-virtual {p2, v1}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v1

    add-int/lit8 v1, v1, 0x1

    invoke-virtual {p2, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    .line 106
    .local v0, name:Ljava/lang/String;
    const/4 v1, 0x2

    if-ne v1, p1, :cond_15

    invoke-direct {p0, p2, v0, v2}, Lmiui/content/res/ThemeResourcesSystem;->getThemeFileStreamMIUI(Ljava/lang/String;Ljava/lang/String;[I)Ljava/io/InputStream;

    move-result-object v1

    :goto_14
    return-object v1

    :cond_15
    invoke-direct {p0, p2, v0, v2}, Lmiui/content/res/ThemeResourcesSystem;->getThemeFileStreamSystem(Ljava/lang/String;Ljava/lang/String;[I)Ljava/io/InputStream;

    move-result-object v1

    goto :goto_14
.end method

.method public getThemeInt(I)Ljava/lang/Integer;
    .registers 4
    .parameter "id"

    .prologue
    .line 52
    sget-object v1, Lmiui/content/res/ThemeResourcesSystem;->sLockscreen:Lmiui/content/res/ThemeResources;

    invoke-virtual {v1, p1}, Lmiui/content/res/ThemeResources;->getThemeInt(I)Ljava/lang/Integer;

    move-result-object v0

    .line 53
    .local v0, ret:Ljava/lang/Integer;
    if-nez v0, :cond_e

    .line 54
    sget-object v1, Lmiui/content/res/ThemeResourcesSystem;->sMiui:Lmiui/content/res/ThemeResources;

    invoke-virtual {v1, p1}, Lmiui/content/res/ThemeResources;->getThemeInt(I)Ljava/lang/Integer;

    move-result-object v0

    .line 56
    :cond_e
    if-nez v0, :cond_14

    .line 57
    invoke-virtual {p0, p1}, Lmiui/content/res/ThemeResourcesSystem;->getThemeIntInner(I)Ljava/lang/Integer;

    move-result-object v0

    .line 59
    :cond_14
    return-object v0
.end method

.method public hasAwesomeLockscreen()Z
    .registers 3

    .prologue
    .line 149
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
    .line 116
    sget-object v0, Lmiui/content/res/ThemeResourcesSystem;->sIcons:Lmiui/content/res/ThemeResources;

    invoke-virtual {v0, p1}, Lmiui/content/res/ThemeResources;->containsEntry(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public hasValues()Z
    .registers 2

    .prologue
    .line 47
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
    .line 112
    sget-object v0, Lmiui/content/res/ThemeResourcesSystem;->sIcons:Lmiui/content/res/ThemeResources;

    invoke-virtual {v0}, Lmiui/content/res/ThemeResources;->checkUpdate()Z

    .line 113
    return-void
.end method
