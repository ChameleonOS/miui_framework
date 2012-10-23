.class public final Lmiui/content/res/ThemeZipFile;
.super Ljava/lang/Object;
.source "ThemeZipFile.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lmiui/content/res/ThemeZipFile$ThemeFileInfo;
    }
.end annotation


# static fields
.field private static final ALTERNATIVE_THEME_VALUE_FILE:Ljava/lang/String; = "theme_values%s.xml"

.field private static final ATTR_NAME:Ljava/lang/String; = "name"

.field private static final ATTR_PACKAGE:Ljava/lang/String; = "package"

.field static DBG:Z = false

.field private static final FUZZY_SEARCH_ICON_SUFFIX:Ljava/lang/String; = "#*.png"

.field static TAG:Ljava/lang/String; = null

.field private static final TAG_BOOLEAN:Ljava/lang/String; = "bool"

.field private static final TAG_COLOR:Ljava/lang/String; = "color"

.field private static final TAG_DIMEN:Ljava/lang/String; = "dimen"

.field private static final TAG_DRAWABLE:Ljava/lang/String; = "drawable"

.field private static final TAG_INTEGER:Ljava/lang/String; = "integer"

.field private static final TAG_STRING:Ljava/lang/String; = "string"

.field public static final THEME_VALUE_FILE:Ljava/lang/String; = "theme_values.xml"

.field private static final TRUE:Ljava/lang/String; = "true"

.field private static final sDensities:[I

.field private static final sDensity:I

.field protected static final sThemeZipFiles:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lmiui/content/res/ThemeZipFile;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private mCharSequences:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Ljava/lang/CharSequence;",
            ">;"
        }
    .end annotation
.end field

.field private mIntegers:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private mLastModifyTime:J

.field private mMetaData:Lmiui/content/res/ThemeResources$MetaData;

.field private mPackageName:Ljava/lang/String;

.field private mPath:Ljava/lang/String;

.field private mZipFile:Ljava/util/zip/ZipFile;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 50
    sget-boolean v0, Lmiui/content/res/ThemeResources;->DBG:Z

    sput-boolean v0, Lmiui/content/res/ThemeZipFile;->DBG:Z

    .line 51
    const-string v0, "ThemeZipFile"

    sput-object v0, Lmiui/content/res/ThemeZipFile;->TAG:Ljava/lang/String;

    .line 53
    sget v0, Landroid/util/DisplayMetrics;->DENSITY_DEVICE:I

    sput v0, Lmiui/content/res/ThemeZipFile;->sDensity:I

    .line 54
    sget v0, Lmiui/content/res/ThemeZipFile;->sDensity:I

    invoke-static {v0}, Lmiui/util/DisplayUtils;->getBestDensityOrder(I)[I

    move-result-object v0

    sput-object v0, Lmiui/content/res/ThemeZipFile;->sDensities:[I

    .line 84
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lmiui/content/res/ThemeZipFile;->sThemeZipFiles:Ljava/util/Map;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lmiui/content/res/ThemeResources$MetaData;Ljava/lang/String;)V
    .registers 7
    .parameter "zipFilePath"
    .parameter "metaData"
    .parameter "packageName"

    .prologue
    .line 118
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 113
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lmiui/content/res/ThemeZipFile;->mLastModifyTime:J

    .line 115
    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    iput-object v0, p0, Lmiui/content/res/ThemeZipFile;->mIntegers:Landroid/util/SparseArray;

    .line 116
    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    iput-object v0, p0, Lmiui/content/res/ThemeZipFile;->mCharSequences:Landroid/util/SparseArray;

    .line 119
    sget-boolean v0, Lmiui/content/res/ThemeZipFile;->DBG:Z

    if-eqz v0, :cond_31

    sget-object v0, Lmiui/content/res/ThemeZipFile;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "create ThemeZipFile for "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 120
    :cond_31
    iput-object p3, p0, Lmiui/content/res/ThemeZipFile;->mPackageName:Ljava/lang/String;

    .line 121
    iput-object p1, p0, Lmiui/content/res/ThemeZipFile;->mPath:Ljava/lang/String;

    .line 122
    iput-object p2, p0, Lmiui/content/res/ThemeZipFile;->mMetaData:Lmiui/content/res/ThemeResources$MetaData;

    .line 123
    return-void
.end method

.method private clean()V
    .registers 4

    .prologue
    .line 313
    sget-boolean v0, Lmiui/content/res/ThemeZipFile;->DBG:Z

    if-eqz v0, :cond_1e

    sget-object v0, Lmiui/content/res/ThemeZipFile;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "clean for "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lmiui/content/res/ThemeZipFile;->mPath:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 315
    :cond_1e
    iget-object v0, p0, Lmiui/content/res/ThemeZipFile;->mZipFile:Ljava/util/zip/ZipFile;

    if-eqz v0, :cond_2a

    .line 317
    :try_start_22
    iget-object v0, p0, Lmiui/content/res/ThemeZipFile;->mZipFile:Ljava/util/zip/ZipFile;

    invoke-virtual {v0}, Ljava/util/zip/ZipFile;->close()V
    :try_end_27
    .catch Ljava/lang/Exception; {:try_start_22 .. :try_end_27} :catch_35

    .line 320
    :goto_27
    const/4 v0, 0x0

    iput-object v0, p0, Lmiui/content/res/ThemeZipFile;->mZipFile:Ljava/util/zip/ZipFile;

    .line 323
    :cond_2a
    iget-object v0, p0, Lmiui/content/res/ThemeZipFile;->mIntegers:Landroid/util/SparseArray;

    invoke-virtual {v0}, Landroid/util/SparseArray;->clear()V

    .line 324
    iget-object v0, p0, Lmiui/content/res/ThemeZipFile;->mCharSequences:Landroid/util/SparseArray;

    invoke-virtual {v0}, Landroid/util/SparseArray;->clear()V

    .line 325
    return-void

    .line 318
    :catch_35
    move-exception v0

    goto :goto_27
.end method

.method private getInputStreamInner(Ljava/lang/String;)Lmiui/content/res/ThemeZipFile$ThemeFileInfo;
    .registers 13
    .parameter "relativeFilePath"

    .prologue
    const/4 v10, 0x0

    .line 160
    invoke-direct {p0, p1}, Lmiui/content/res/ThemeZipFile;->getZipInputStream(Ljava/lang/String;)Lmiui/content/res/ThemeZipFile$ThemeFileInfo;

    move-result-object v3

    .line 161
    .local v3, result:Lmiui/content/res/ThemeZipFile$ThemeFileInfo;
    if-eqz v3, :cond_9

    move-object v4, v3

    .line 179
    .end local v3           #result:Lmiui/content/res/ThemeZipFile$ThemeFileInfo;
    .local v4, result:Lmiui/content/res/ThemeZipFile$ThemeFileInfo;
    :goto_8
    return-object v4

    .line 163
    .end local v4           #result:Lmiui/content/res/ThemeZipFile$ThemeFileInfo;
    .restart local v3       #result:Lmiui/content/res/ThemeZipFile$ThemeFileInfo;
    :cond_9
    const-string v6, "dpi/"

    invoke-virtual {p1, v6}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    .line 164
    .local v1, index:I
    if-lez v1, :cond_56

    .line 165
    add-int/lit8 v6, v1, 0x3

    invoke-virtual {p1, v6}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v5

    .line 166
    .local v5, suffix:Ljava/lang/String;
    :goto_17
    invoke-virtual {p1, v1}, Ljava/lang/String;->charAt(I)C

    move-result v6

    const/16 v7, 0x2d

    if-eq v6, v7, :cond_22

    add-int/lit8 v1, v1, -0x1

    goto :goto_17

    .line 167
    :cond_22
    invoke-virtual {p1, v10, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    .line 169
    .local v2, prefix:Ljava/lang/String;
    const/4 v1, 0x0

    :goto_27
    sget-object v6, Lmiui/content/res/ThemeZipFile;->sDensities:[I

    array-length v6, v6

    if-ge v1, v6, :cond_56

    .line 170
    const-string v6, "%s%s%s"

    const/4 v7, 0x3

    new-array v7, v7, [Ljava/lang/Object;

    aput-object v2, v7, v10

    const/4 v8, 0x1

    sget-object v9, Lmiui/content/res/ThemeZipFile;->sDensities:[I

    aget v9, v9, v1

    invoke-static {v9}, Lmiui/util/DisplayUtils;->getDensitySuffix(I)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v7, v8

    const/4 v8, 0x2

    aput-object v5, v7, v8

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 172
    .local v0, fallbackPath:Ljava/lang/String;
    invoke-direct {p0, v0}, Lmiui/content/res/ThemeZipFile;->getZipInputStream(Ljava/lang/String;)Lmiui/content/res/ThemeZipFile$ThemeFileInfo;

    move-result-object v3

    .line 173
    if-eqz v3, :cond_53

    .line 174
    sget-object v6, Lmiui/content/res/ThemeZipFile;->sDensities:[I

    aget v6, v6, v1

    iput v6, v3, Lmiui/content/res/ThemeZipFile$ThemeFileInfo;->mDensity:I

    move-object v4, v3

    .line 175
    .end local v3           #result:Lmiui/content/res/ThemeZipFile$ThemeFileInfo;
    .restart local v4       #result:Lmiui/content/res/ThemeZipFile$ThemeFileInfo;
    goto :goto_8

    .line 169
    .end local v4           #result:Lmiui/content/res/ThemeZipFile$ThemeFileInfo;
    .restart local v3       #result:Lmiui/content/res/ThemeZipFile$ThemeFileInfo;
    :cond_53
    add-int/lit8 v1, v1, 0x1

    goto :goto_27

    .end local v0           #fallbackPath:Ljava/lang/String;
    .end local v2           #prefix:Ljava/lang/String;
    .end local v5           #suffix:Ljava/lang/String;
    :cond_56
    move-object v4, v3

    .line 179
    .end local v3           #result:Lmiui/content/res/ThemeZipFile$ThemeFileInfo;
    .restart local v4       #result:Lmiui/content/res/ThemeZipFile$ThemeFileInfo;
    goto :goto_8
.end method

.method private static final getPackageName(Ljava/lang/String;)Ljava/lang/String;
    .registers 2
    .parameter "componentName"

    .prologue
    .line 98
    const-string v0, "framework-res"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_10

    const-string v0, "icons"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_13

    .line 100
    :cond_10
    const-string p0, "android"

    .line 106
    .end local p0
    :cond_12
    :goto_12
    return-object p0

    .line 102
    .restart local p0
    :cond_13
    const-string v0, "framework-miui-res"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_24

    const-string/jumbo v0, "lockscreen"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_12

    .line 104
    :cond_24
    const-string/jumbo p0, "miui"

    goto :goto_12
.end method

.method protected static getThemeZipFile(Lmiui/content/res/ThemeResources$MetaData;Ljava/lang/String;)Lmiui/content/res/ThemeZipFile;
    .registers 7
    .parameter "metaData"
    .parameter "componentName"

    .prologue
    .line 86
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lmiui/content/res/ThemeResources$MetaData;->themePath:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 87
    .local v0, path:Ljava/lang/String;
    sget-object v1, Lmiui/content/res/ThemeZipFile;->sThemeZipFiles:Ljava/util/Map;

    invoke-interface {v1, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_35

    .line 88
    sget-object v2, Lmiui/content/res/ThemeZipFile;->sThemeZipFiles:Ljava/util/Map;

    monitor-enter v2

    .line 89
    :try_start_1e
    sget-object v1, Lmiui/content/res/ThemeZipFile;->sThemeZipFiles:Ljava/util/Map;

    invoke-interface {v1, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_34

    .line 90
    sget-object v1, Lmiui/content/res/ThemeZipFile;->sThemeZipFiles:Ljava/util/Map;

    new-instance v3, Lmiui/content/res/ThemeZipFile;

    invoke-static {p1}, Lmiui/content/res/ThemeZipFile;->getPackageName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v0, p0, v4}, Lmiui/content/res/ThemeZipFile;-><init>(Ljava/lang/String;Lmiui/content/res/ThemeResources$MetaData;Ljava/lang/String;)V

    invoke-interface {v1, v0, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 92
    :cond_34
    monitor-exit v2
    :try_end_35
    .catchall {:try_start_1e .. :try_end_35} :catchall_3e

    .line 94
    :cond_35
    sget-object v1, Lmiui/content/res/ThemeZipFile;->sThemeZipFiles:Ljava/util/Map;

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lmiui/content/res/ThemeZipFile;

    return-object v1

    .line 92
    :catchall_3e
    move-exception v1

    :try_start_3f
    monitor-exit v2
    :try_end_40
    .catchall {:try_start_3f .. :try_end_40} :catchall_3e

    throw v1
.end method

.method private getZipInputStream(Ljava/lang/String;)Lmiui/content/res/ThemeZipFile$ThemeFileInfo;
    .registers 11
    .parameter "relativeFilePath"

    .prologue
    const/4 v5, 0x0

    .line 184
    invoke-direct {p0}, Lmiui/content/res/ThemeZipFile;->isValid()Z

    move-result v6

    if-nez v6, :cond_8

    .line 212
    :cond_7
    :goto_7
    return-object v5

    .line 186
    :cond_8
    const/4 v1, 0x0

    .line 187
    .local v1, entry:Ljava/util/zip/ZipEntry;
    :try_start_9
    const-string v6, "#*.png"

    invoke-virtual {p1, v6}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_59

    .line 188
    const/4 v6, 0x0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v7

    const-string v8, "#*.png"

    invoke-virtual {v8}, Ljava/lang/String;->length()I

    move-result v8

    sub-int/2addr v7, v8

    invoke-virtual {p1, v6, v7}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    .line 190
    .local v3, fuzzyIconName:Ljava/lang/String;
    iget-object v6, p0, Lmiui/content/res/ThemeZipFile;->mZipFile:Ljava/util/zip/ZipFile;

    invoke-virtual {v6}, Ljava/util/zip/ZipFile;->entries()Ljava/util/Enumeration;

    move-result-object v0

    .line 191
    .local v0, entries:Ljava/util/Enumeration;,"Ljava/util/Enumeration<*>;"
    :cond_27
    invoke-interface {v0}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result v6

    if-eqz v6, :cond_44

    .line 192
    invoke-interface {v0}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/zip/ZipEntry;

    .line 193
    .local v2, enumEntry:Ljava/util/zip/ZipEntry;
    invoke-virtual {v2}, Ljava/util/zip/ZipEntry;->isDirectory()Z

    move-result v6

    if-nez v6, :cond_27

    .line 196
    invoke-virtual {v2}, Ljava/util/zip/ZipEntry;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_27

    .line 197
    move-object v1, v2

    .line 204
    .end local v0           #entries:Ljava/util/Enumeration;,"Ljava/util/Enumeration<*>;"
    .end local v2           #enumEntry:Ljava/util/zip/ZipEntry;
    .end local v3           #fuzzyIconName:Ljava/lang/String;
    :cond_44
    :goto_44
    if-eqz v1, :cond_7

    .line 205
    iget-object v6, p0, Lmiui/content/res/ThemeZipFile;->mZipFile:Ljava/util/zip/ZipFile;

    invoke-virtual {v6, v1}, Ljava/util/zip/ZipFile;->getInputStream(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;

    move-result-object v4

    .line 206
    .local v4, input:Ljava/io/InputStream;
    if-eqz v4, :cond_7

    .line 207
    new-instance v6, Lmiui/content/res/ThemeZipFile$ThemeFileInfo;

    invoke-virtual {v1}, Ljava/util/zip/ZipEntry;->getSize()J

    move-result-wide v7

    invoke-direct {v6, p0, v4, v7, v8}, Lmiui/content/res/ThemeZipFile$ThemeFileInfo;-><init>(Lmiui/content/res/ThemeZipFile;Ljava/io/InputStream;J)V

    move-object v5, v6

    goto :goto_7

    .line 202
    .end local v4           #input:Ljava/io/InputStream;
    :cond_59
    iget-object v6, p0, Lmiui/content/res/ThemeZipFile;->mZipFile:Ljava/util/zip/ZipFile;

    invoke-virtual {v6, p1}, Ljava/util/zip/ZipFile;->getEntry(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    :try_end_5e
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_5e} :catch_60

    move-result-object v1

    goto :goto_44

    .line 210
    :catch_60
    move-exception v6

    goto :goto_7
.end method

.method private isValid()Z
    .registers 2

    .prologue
    .line 144
    iget-object v0, p0, Lmiui/content/res/ThemeZipFile;->mZipFile:Ljava/util/zip/ZipFile;

    if-eqz v0, :cond_6

    const/4 v0, 0x1

    :goto_5
    return v0

    :cond_6
    const/4 v0, 0x0

    goto :goto_5
.end method

.method private loadThemeValues(Landroid/content/res/Resources;)V
    .registers 13
    .parameter "resources"

    .prologue
    .line 228
    sget-boolean v7, Lmiui/content/res/ThemeZipFile;->DBG:Z

    if-eqz v7, :cond_1f

    sget-object v7, Lmiui/content/res/ThemeZipFile;->TAG:Ljava/lang/String;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v9, "loadThemeValues for "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    iget-object v9, p0, Lmiui/content/res/ThemeZipFile;->mPath:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 230
    :cond_1f
    sget-object v7, Lmiui/content/res/ThemeZipFile;->sDensities:[I

    array-length v7, v7

    add-int/lit8 v2, v7, -0x1

    .local v2, i:I
    :goto_24
    if-ltz v2, :cond_64

    .line 231
    const-string/jumbo v7, "theme_values%s.xml"

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    sget-object v10, Lmiui/content/res/ThemeZipFile;->sDensities:[I

    aget v10, v10, v2

    invoke-static {v10}, Lmiui/util/DisplayUtils;->getDensitySuffix(I)Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 232
    .local v1, file:Ljava/lang/String;
    invoke-direct {p0, v1}, Lmiui/content/res/ThemeZipFile;->getZipInputStream(Ljava/lang/String;)Lmiui/content/res/ThemeZipFile$ThemeFileInfo;

    move-result-object v3

    .line 233
    .local v3, info:Lmiui/content/res/ThemeZipFile$ThemeFileInfo;
    if-eqz v3, :cond_5c

    .line 234
    iget-object v4, v3, Lmiui/content/res/ThemeZipFile$ThemeFileInfo;->mInput:Ljava/io/InputStream;

    .line 236
    .local v4, is:Ljava/io/InputStream;
    :try_start_43
    invoke-static {}, Lorg/xmlpull/v1/XmlPullParserFactory;->newInstance()Lorg/xmlpull/v1/XmlPullParserFactory;

    move-result-object v7

    invoke-virtual {v7}, Lorg/xmlpull/v1/XmlPullParserFactory;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v6

    .line 237
    .local v6, parser:Lorg/xmlpull/v1/XmlPullParser;
    new-instance v5, Ljava/io/BufferedInputStream;

    const/16 v7, 0x2000

    invoke-direct {v5, v4, v7}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;I)V
    :try_end_52
    .catchall {:try_start_43 .. :try_end_52} :catchall_5f
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_43 .. :try_end_52} :catch_65

    .line 238
    .end local v4           #is:Ljava/io/InputStream;
    .local v5, is:Ljava/io/InputStream;
    const/4 v7, 0x0

    :try_start_53
    invoke-interface {v6, v5, v7}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/InputStream;Ljava/lang/String;)V

    .line 239
    invoke-direct {p0, p1, v6}, Lmiui/content/res/ThemeZipFile;->mergeThemeValues(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;)V
    :try_end_59
    .catchall {:try_start_53 .. :try_end_59} :catchall_76
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_53 .. :try_end_59} :catch_79

    .line 243
    :try_start_59
    invoke-virtual {v5}, Ljava/io/BufferedInputStream;->close()V
    :try_end_5c
    .catch Ljava/io/IOException; {:try_start_59 .. :try_end_5c} :catch_74

    .line 230
    .end local v5           #is:Ljava/io/InputStream;
    .end local v6           #parser:Lorg/xmlpull/v1/XmlPullParser;
    :cond_5c
    :goto_5c
    add-int/lit8 v2, v2, -0x1

    goto :goto_24

    .line 242
    .restart local v4       #is:Ljava/io/InputStream;
    :catchall_5f
    move-exception v7

    .line 243
    :goto_60
    :try_start_60
    invoke-virtual {v4}, Ljava/io/InputStream;->close()V
    :try_end_63
    .catch Ljava/io/IOException; {:try_start_60 .. :try_end_63} :catch_6f

    .line 242
    :goto_63
    throw v7

    .line 250
    .end local v1           #file:Ljava/lang/String;
    .end local v3           #info:Lmiui/content/res/ThemeZipFile$ThemeFileInfo;
    .end local v4           #is:Ljava/io/InputStream;
    :cond_64
    return-void

    .line 240
    .restart local v1       #file:Ljava/lang/String;
    .restart local v3       #info:Lmiui/content/res/ThemeZipFile$ThemeFileInfo;
    .restart local v4       #is:Ljava/io/InputStream;
    :catch_65
    move-exception v7

    .line 243
    :goto_66
    :try_start_66
    invoke-virtual {v4}, Ljava/io/InputStream;->close()V
    :try_end_69
    .catch Ljava/io/IOException; {:try_start_66 .. :try_end_69} :catch_6a

    goto :goto_5c

    .line 244
    :catch_6a
    move-exception v0

    .line 245
    .end local v4           #is:Ljava/io/InputStream;
    .local v0, e:Ljava/io/IOException;
    :goto_6b
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_5c

    .line 244
    .end local v0           #e:Ljava/io/IOException;
    .restart local v4       #is:Ljava/io/InputStream;
    :catch_6f
    move-exception v0

    .line 245
    .restart local v0       #e:Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_63

    .line 244
    .end local v0           #e:Ljava/io/IOException;
    .end local v4           #is:Ljava/io/InputStream;
    .restart local v5       #is:Ljava/io/InputStream;
    .restart local v6       #parser:Lorg/xmlpull/v1/XmlPullParser;
    :catch_74
    move-exception v0

    goto :goto_6b

    .line 242
    :catchall_76
    move-exception v7

    move-object v4, v5

    .end local v5           #is:Ljava/io/InputStream;
    .restart local v4       #is:Ljava/io/InputStream;
    goto :goto_60

    .line 240
    .end local v4           #is:Ljava/io/InputStream;
    .restart local v5       #is:Ljava/io/InputStream;
    :catch_79
    move-exception v7

    move-object v4, v5

    .end local v5           #is:Ljava/io/InputStream;
    .restart local v4       #is:Ljava/io/InputStream;
    goto :goto_66
.end method

.method private mergeThemeValues(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;)V
    .registers 16
    .parameter "resources"
    .parameter "parser"

    .prologue
    .line 255
    :cond_0
    :try_start_0
    invoke-interface {p2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v7

    .local v7, tagtype:I
    const/4 v10, 0x2

    if-eq v7, v10, :cond_a

    const/4 v10, 0x1

    if-ne v7, v10, :cond_0

    .line 258
    :cond_a
    const/4 v10, 0x2

    if-eq v7, v10, :cond_1a

    .line 259
    new-instance v10, Lorg/xmlpull/v1/XmlPullParserException;

    const-string v11, "No start tag found"

    invoke-direct {v10, v11}, Lorg/xmlpull/v1/XmlPullParserException;-><init>(Ljava/lang/String;)V

    throw v10
    :try_end_15
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_15} :catch_15

    .line 307
    .end local v7           #tagtype:I
    :catch_15
    move-exception v2

    .line 308
    .local v2, e:Ljava/lang/Exception;
    invoke-virtual {v2}, Ljava/lang/Exception;->printStackTrace()V

    .line 310
    .end local v2           #e:Ljava/lang/Exception;
    :cond_19
    return-void

    .line 263
    .restart local v7       #tagtype:I
    :cond_1a
    :goto_1a
    :try_start_1a
    invoke-interface {p2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v7

    const/4 v10, 0x2

    if-eq v7, v10, :cond_24

    const/4 v10, 0x1

    if-ne v7, v10, :cond_1a

    .line 265
    :cond_24
    const/4 v10, 0x1

    if-eq v7, v10, :cond_19

    .line 267
    invoke-interface {p2}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v8

    .line 268
    .local v8, type:Ljava/lang/String;
    if-eqz v8, :cond_19

    .line 270
    const/4 v5, 0x0

    .line 271
    .local v5, name:Ljava/lang/String;
    const/4 v6, 0x0

    .line 272
    .local v6, pkg:Ljava/lang/String;
    invoke-interface {p2}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeCount()I

    move-result v10

    add-int/lit8 v3, v10, -0x1

    .local v3, i:I
    :goto_39
    if-ltz v3, :cond_61

    .line 273
    invoke-interface {p2, v3}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeName(I)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    .line 274
    .local v0, attrName:Ljava/lang/String;
    const-string/jumbo v10, "name"

    invoke-virtual {v0, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_53

    .line 275
    invoke-interface {p2, v3}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(I)Ljava/lang/String;

    move-result-object v5

    .line 272
    :cond_50
    :goto_50
    add-int/lit8 v3, v3, -0x1

    goto :goto_39

    .line 276
    :cond_53
    const-string/jumbo v10, "package"

    invoke-virtual {v0, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_50

    .line 277
    invoke-interface {p2, v3}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(I)Ljava/lang/String;

    move-result-object v6

    goto :goto_50

    .line 280
    .end local v0           #attrName:Ljava/lang/String;
    :cond_61
    invoke-interface {p2}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v9

    .line 281
    .local v9, value:Ljava/lang/String;
    if-eqz v5, :cond_1a

    if-eqz v9, :cond_1a

    invoke-virtual {v9}, Ljava/lang/String;->length()I

    move-result v10

    if-eqz v10, :cond_1a

    .line 283
    if-nez v6, :cond_73

    iget-object v6, p0, Lmiui/content/res/ThemeZipFile;->mPackageName:Ljava/lang/String;

    .end local v6           #pkg:Ljava/lang/String;
    :cond_73
    invoke-virtual {p1, v5, v8, v6}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v4

    .line 284
    .local v4, id:I
    if-lez v4, :cond_1a

    .line 285
    const-string v10, "bool"

    invoke-virtual {v8, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_aa

    .line 286
    iget-object v10, p0, Lmiui/content/res/ThemeZipFile;->mMetaData:Lmiui/content/res/ThemeResources$MetaData;

    iget-boolean v10, v10, Lmiui/content/res/ThemeResources$MetaData;->supportInt:Z

    if-eqz v10, :cond_1a

    iget-object v10, p0, Lmiui/content/res/ThemeZipFile;->mIntegers:Landroid/util/SparseArray;

    invoke-virtual {v10, v4}, Landroid/util/SparseArray;->indexOfKey(I)I

    move-result v10

    if-gez v10, :cond_1a

    .line 287
    iget-object v11, p0, Lmiui/content/res/ThemeZipFile;->mIntegers:Landroid/util/SparseArray;

    const-string/jumbo v10, "true"

    invoke-virtual {v9}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v10, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_a8

    const/4 v10, 0x1

    :goto_9f
    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    invoke-virtual {v11, v4, v10}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    goto/16 :goto_1a

    :cond_a8
    const/4 v10, 0x0

    goto :goto_9f

    .line 289
    :cond_aa
    const-string v10, "color"

    invoke-virtual {v8, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-nez v10, :cond_c2

    const-string v10, "integer"

    invoke-virtual {v8, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-nez v10, :cond_c2

    const-string v10, "drawable"

    invoke-virtual {v8, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_e4

    .line 290
    :cond_c2
    iget-object v10, p0, Lmiui/content/res/ThemeZipFile;->mMetaData:Lmiui/content/res/ThemeResources$MetaData;

    iget-boolean v10, v10, Lmiui/content/res/ThemeResources$MetaData;->supportInt:Z

    if-eqz v10, :cond_1a

    iget-object v10, p0, Lmiui/content/res/ThemeZipFile;->mIntegers:Landroid/util/SparseArray;

    invoke-virtual {v10, v4}, Landroid/util/SparseArray;->indexOfKey(I)I

    move-result v10

    if-gez v10, :cond_1a

    .line 291
    iget-object v10, p0, Lmiui/content/res/ThemeZipFile;->mIntegers:Landroid/util/SparseArray;

    invoke-virtual {v9}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v11

    const/4 v12, 0x0

    invoke-static {v11, v12}, Lcom/android/internal/util/XmlUtils;->convertValueToUnsignedInt(Ljava/lang/String;I)I

    move-result v11

    invoke-static {v11}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    invoke-virtual {v10, v4, v11}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    goto/16 :goto_1a

    .line 293
    :cond_e4
    const-string/jumbo v10, "string"

    invoke-virtual {v8, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_102

    .line 294
    iget-object v10, p0, Lmiui/content/res/ThemeZipFile;->mMetaData:Lmiui/content/res/ThemeResources$MetaData;

    iget-boolean v10, v10, Lmiui/content/res/ThemeResources$MetaData;->supportCharSequence:Z

    if-eqz v10, :cond_1a

    iget-object v10, p0, Lmiui/content/res/ThemeZipFile;->mCharSequences:Landroid/util/SparseArray;

    invoke-virtual {v10, v4}, Landroid/util/SparseArray;->indexOfKey(I)I

    move-result v10

    if-gez v10, :cond_1a

    .line 295
    iget-object v10, p0, Lmiui/content/res/ThemeZipFile;->mCharSequences:Landroid/util/SparseArray;

    invoke-virtual {v10, v4, v9}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    goto/16 :goto_1a

    .line 297
    :cond_102
    const-string v10, "dimen"

    invoke-virtual {v8, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_1a

    .line 298
    iget-object v10, p0, Lmiui/content/res/ThemeZipFile;->mMetaData:Lmiui/content/res/ThemeResources$MetaData;

    iget-boolean v10, v10, Lmiui/content/res/ThemeResources$MetaData;->supportInt:Z

    if-eqz v10, :cond_1a

    iget-object v10, p0, Lmiui/content/res/ThemeZipFile;->mIntegers:Landroid/util/SparseArray;

    invoke-virtual {v10, v4}, Landroid/util/SparseArray;->indexOfKey(I)I

    move-result v10

    if-gez v10, :cond_1a

    .line 299
    invoke-virtual {v9}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Landroid/app/MiuiThemeHelper;->parseDimension(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v1

    .line 300
    .local v1, dimen:Ljava/lang/Integer;
    if-eqz v1, :cond_1a

    .line 301
    iget-object v10, p0, Lmiui/content/res/ThemeZipFile;->mIntegers:Landroid/util/SparseArray;

    invoke-virtual {v10, v4, v1}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V
    :try_end_127
    .catch Ljava/lang/Exception; {:try_start_1a .. :try_end_127} :catch_15

    goto/16 :goto_1a
.end method

.method private openZipFile()V
    .registers 7

    .prologue
    .line 328
    sget-boolean v2, Lmiui/content/res/ThemeZipFile;->DBG:Z

    if-eqz v2, :cond_1f

    sget-object v2, Lmiui/content/res/ThemeZipFile;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "openZipFile for "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lmiui/content/res/ThemeZipFile;->mPath:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 330
    :cond_1f
    new-instance v1, Ljava/io/File;

    iget-object v2, p0, Lmiui/content/res/ThemeZipFile;->mPath:Ljava/lang/String;

    invoke-direct {v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 331
    .local v1, file:Ljava/io/File;
    invoke-virtual {v1}, Ljava/io/File;->lastModified()J

    move-result-wide v2

    iput-wide v2, p0, Lmiui/content/res/ThemeZipFile;->mLastModifyTime:J

    .line 332
    iget-wide v2, p0, Lmiui/content/res/ThemeZipFile;->mLastModifyTime:J

    const-wide/16 v4, 0x0

    cmp-long v2, v2, v4

    if-nez v2, :cond_35

    .line 339
    :goto_34
    return-void

    .line 335
    :cond_35
    :try_start_35
    new-instance v2, Ljava/util/zip/ZipFile;

    invoke-direct {v2, v1}, Ljava/util/zip/ZipFile;-><init>(Ljava/io/File;)V

    iput-object v2, p0, Lmiui/content/res/ThemeZipFile;->mZipFile:Ljava/util/zip/ZipFile;
    :try_end_3c
    .catch Ljava/lang/Exception; {:try_start_35 .. :try_end_3c} :catch_3d

    goto :goto_34

    .line 336
    :catch_3d
    move-exception v0

    .line 337
    .local v0, e:Ljava/lang/Exception;
    const/4 v2, 0x0

    iput-object v2, p0, Lmiui/content/res/ThemeZipFile;->mZipFile:Ljava/util/zip/ZipFile;

    goto :goto_34
.end method


# virtual methods
.method public checkUpdate(Landroid/content/res/Resources;)Z
    .registers 7
    .parameter "resources"

    .prologue
    .line 126
    sget-boolean v2, Lmiui/content/res/ThemeZipFile;->DBG:Z

    if-eqz v2, :cond_1e

    sget-object v2, Lmiui/content/res/ThemeZipFile;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "checkUpdate for "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lmiui/content/res/ThemeZipFile;->mPath:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 128
    :cond_1e
    new-instance v2, Ljava/io/File;

    iget-object v3, p0, Lmiui/content/res/ThemeZipFile;->mPath:Ljava/lang/String;

    invoke-direct {v2, v3}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/io/File;->lastModified()J

    move-result-wide v0

    .line 129
    .local v0, lastModified:J
    iget-wide v2, p0, Lmiui/content/res/ThemeZipFile;->mLastModifyTime:J

    cmp-long v2, v2, v0

    if-eqz v2, :cond_43

    .line 130
    monitor-enter p0

    .line 131
    :try_start_30
    iget-wide v2, p0, Lmiui/content/res/ThemeZipFile;->mLastModifyTime:J

    cmp-long v2, v2, v0

    if-eqz v2, :cond_42

    .line 132
    invoke-direct {p0}, Lmiui/content/res/ThemeZipFile;->clean()V

    .line 133
    invoke-direct {p0}, Lmiui/content/res/ThemeZipFile;->openZipFile()V

    .line 134
    invoke-direct {p0, p1}, Lmiui/content/res/ThemeZipFile;->loadThemeValues(Landroid/content/res/Resources;)V

    .line 135
    const/4 v2, 0x1

    monitor-exit p0

    .line 140
    :goto_41
    return v2

    .line 137
    :cond_42
    monitor-exit p0

    .line 140
    :cond_43
    const/4 v2, 0x0

    goto :goto_41

    .line 137
    :catchall_45
    move-exception v2

    monitor-exit p0
    :try_end_47
    .catchall {:try_start_30 .. :try_end_47} :catchall_45

    throw v2
.end method

.method public containsEntry(Ljava/lang/String;)Z
    .registers 3
    .parameter "relativePath"

    .prologue
    .line 152
    invoke-direct {p0}, Lmiui/content/res/ThemeZipFile;->isValid()Z

    move-result v0

    if-eqz v0, :cond_10

    iget-object v0, p0, Lmiui/content/res/ThemeZipFile;->mZipFile:Ljava/util/zip/ZipFile;

    invoke-virtual {v0, p1}, Ljava/util/zip/ZipFile;->getEntry(Ljava/lang/String;)Ljava/util/zip/ZipEntry;

    move-result-object v0

    if-eqz v0, :cond_10

    const/4 v0, 0x1

    :goto_f
    return v0

    :cond_10
    const/4 v0, 0x0

    goto :goto_f
.end method

.method public exists()Z
    .registers 3

    .prologue
    .line 148
    new-instance v0, Ljava/io/File;

    iget-object v1, p0, Lmiui/content/res/ThemeZipFile;->mPath:Ljava/lang/String;

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    return v0
.end method

.method public getInputStream(Ljava/lang/String;)Lmiui/content/res/ThemeZipFile$ThemeFileInfo;
    .registers 3
    .parameter "relativeFilePath"

    .prologue
    .line 156
    iget-object v0, p0, Lmiui/content/res/ThemeZipFile;->mMetaData:Lmiui/content/res/ThemeResources$MetaData;

    iget-boolean v0, v0, Lmiui/content/res/ThemeResources$MetaData;->supportFile:Z

    if-eqz v0, :cond_b

    invoke-direct {p0, p1}, Lmiui/content/res/ThemeZipFile;->getInputStreamInner(Ljava/lang/String;)Lmiui/content/res/ThemeZipFile$ThemeFileInfo;

    move-result-object v0

    :goto_a
    return-object v0

    :cond_b
    const/4 v0, 0x0

    goto :goto_a
.end method

.method public getThemeCharSequence(I)Ljava/lang/CharSequence;
    .registers 3
    .parameter "id"

    .prologue
    .line 224
    iget-object v0, p0, Lmiui/content/res/ThemeZipFile;->mCharSequences:Landroid/util/SparseArray;

    invoke-virtual {v0, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    return-object v0
.end method

.method public getThemeInt(I)Ljava/lang/Integer;
    .registers 3
    .parameter "id"

    .prologue
    .line 220
    iget-object v0, p0, Lmiui/content/res/ThemeZipFile;->mIntegers:Landroid/util/SparseArray;

    invoke-virtual {v0, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    return-object v0
.end method

.method public hasValues()Z
    .registers 2

    .prologue
    .line 216
    iget-object v0, p0, Lmiui/content/res/ThemeZipFile;->mIntegers:Landroid/util/SparseArray;

    invoke-virtual {v0}, Landroid/util/SparseArray;->size()I

    move-result v0

    if-gtz v0, :cond_10

    iget-object v0, p0, Lmiui/content/res/ThemeZipFile;->mCharSequences:Landroid/util/SparseArray;

    invoke-virtual {v0}, Landroid/util/SparseArray;->size()I

    move-result v0

    if-lez v0, :cond_12

    :cond_10
    const/4 v0, 0x1

    :goto_11
    return v0

    :cond_12
    const/4 v0, 0x0

    goto :goto_11
.end method
