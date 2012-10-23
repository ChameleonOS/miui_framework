.class public final Lmiui/content/res/ThemeZipFile;
.super Ljava/lang/Object;
.source "ThemeZipFile.java"


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

.field private static final TAG_ROOT:Ljava/lang/String; = "MIUI_Theme_Values"

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

    .line 74
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
    .line 108
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 103
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lmiui/content/res/ThemeZipFile;->mLastModifyTime:J

    .line 105
    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    iput-object v0, p0, Lmiui/content/res/ThemeZipFile;->mIntegers:Landroid/util/SparseArray;

    .line 106
    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    iput-object v0, p0, Lmiui/content/res/ThemeZipFile;->mCharSequences:Landroid/util/SparseArray;

    .line 109
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

    .line 110
    :cond_31
    iput-object p3, p0, Lmiui/content/res/ThemeZipFile;->mPackageName:Ljava/lang/String;

    .line 111
    iput-object p1, p0, Lmiui/content/res/ThemeZipFile;->mPath:Ljava/lang/String;

    .line 112
    iput-object p2, p0, Lmiui/content/res/ThemeZipFile;->mMetaData:Lmiui/content/res/ThemeResources$MetaData;

    .line 113
    return-void
.end method

.method private clean()V
    .registers 4

    .prologue
    .line 300
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

    .line 302
    :cond_1e
    iget-object v0, p0, Lmiui/content/res/ThemeZipFile;->mZipFile:Ljava/util/zip/ZipFile;

    if-eqz v0, :cond_2a

    .line 304
    :try_start_22
    iget-object v0, p0, Lmiui/content/res/ThemeZipFile;->mZipFile:Ljava/util/zip/ZipFile;

    invoke-virtual {v0}, Ljava/util/zip/ZipFile;->close()V
    :try_end_27
    .catch Ljava/lang/Exception; {:try_start_22 .. :try_end_27} :catch_35

    .line 307
    :goto_27
    const/4 v0, 0x0

    iput-object v0, p0, Lmiui/content/res/ThemeZipFile;->mZipFile:Ljava/util/zip/ZipFile;

    .line 310
    :cond_2a
    iget-object v0, p0, Lmiui/content/res/ThemeZipFile;->mIntegers:Landroid/util/SparseArray;

    invoke-virtual {v0}, Landroid/util/SparseArray;->clear()V

    .line 311
    iget-object v0, p0, Lmiui/content/res/ThemeZipFile;->mCharSequences:Landroid/util/SparseArray;

    invoke-virtual {v0}, Landroid/util/SparseArray;->clear()V

    .line 312
    return-void

    .line 305
    :catch_35
    move-exception v0

    goto :goto_27
.end method

.method private getInputStreamInner(Ljava/lang/String;[I)Ljava/io/InputStream;
    .registers 14
    .parameter "relativeFilePath"
    .parameter "size"

    .prologue
    const/4 v10, 0x0

    .line 150
    invoke-direct {p0, p1, p2}, Lmiui/content/res/ThemeZipFile;->getZipInputStream(Ljava/lang/String;[I)Ljava/io/InputStream;

    move-result-object v3

    .line 151
    .local v3, result:Ljava/io/InputStream;
    if-nez v3, :cond_4f

    .line 152
    const-string v6, "dpi/"

    invoke-virtual {p1, v6}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    .line 153
    .local v1, index:I
    if-gez v1, :cond_11

    move-object v4, v3

    .line 167
    .end local v1           #index:I
    .end local v3           #result:Ljava/io/InputStream;
    .local v4, result:Ljava/io/InputStream;
    :goto_10
    return-object v4

    .line 155
    .end local v4           #result:Ljava/io/InputStream;
    .restart local v1       #index:I
    .restart local v3       #result:Ljava/io/InputStream;
    :cond_11
    add-int/lit8 v6, v1, 0x3

    invoke-virtual {p1, v6}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v5

    .line 156
    .local v5, suffix:Ljava/lang/String;
    :goto_17
    invoke-virtual {p1, v1}, Ljava/lang/String;->charAt(I)C

    move-result v6

    const/16 v7, 0x2d

    if-eq v6, v7, :cond_22

    add-int/lit8 v1, v1, -0x1

    goto :goto_17

    .line 157
    :cond_22
    invoke-virtual {p1, v10, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    .line 159
    .local v2, prefix:Ljava/lang/String;
    sget-object v6, Lmiui/content/res/ThemeZipFile;->sDensities:[I

    array-length v6, v6

    add-int/lit8 v1, v6, -0x1

    .line 160
    :goto_2b
    if-nez v3, :cond_4f

    if-ltz v1, :cond_4f

    .line 161
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

    .line 163
    .local v0, fallbackPath:Ljava/lang/String;
    invoke-direct {p0, v0, p2}, Lmiui/content/res/ThemeZipFile;->getZipInputStream(Ljava/lang/String;[I)Ljava/io/InputStream;

    move-result-object v3

    .line 164
    add-int/lit8 v1, v1, -0x1

    .line 165
    goto :goto_2b

    .end local v0           #fallbackPath:Ljava/lang/String;
    .end local v1           #index:I
    .end local v2           #prefix:Ljava/lang/String;
    .end local v5           #suffix:Ljava/lang/String;
    :cond_4f
    move-object v4, v3

    .line 167
    .end local v3           #result:Ljava/io/InputStream;
    .restart local v4       #result:Ljava/io/InputStream;
    goto :goto_10
.end method

.method private static final getPackageName(Ljava/lang/String;)Ljava/lang/String;
    .registers 2
    .parameter "componentName"

    .prologue
    .line 88
    const-string v0, "framework-res"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_10

    const-string v0, "icons"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_13

    .line 90
    :cond_10
    const-string p0, "android"

    .line 96
    .end local p0
    :cond_12
    :goto_12
    return-object p0

    .line 92
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

    .line 94
    :cond_24
    const-string/jumbo p0, "miui"

    goto :goto_12
.end method

.method protected static getThemeZipFile(Lmiui/content/res/ThemeResources$MetaData;Ljava/lang/String;)Lmiui/content/res/ThemeZipFile;
    .registers 7
    .parameter "metaData"
    .parameter "componentName"

    .prologue
    .line 76
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lmiui/content/res/ThemeResources$MetaData;->themePath:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 77
    .local v0, path:Ljava/lang/String;
    sget-object v1, Lmiui/content/res/ThemeZipFile;->sThemeZipFiles:Ljava/util/Map;

    invoke-interface {v1, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_35

    .line 78
    sget-object v2, Lmiui/content/res/ThemeZipFile;->sThemeZipFiles:Ljava/util/Map;

    monitor-enter v2

    .line 79
    :try_start_1e
    sget-object v1, Lmiui/content/res/ThemeZipFile;->sThemeZipFiles:Ljava/util/Map;

    invoke-interface {v1, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_34

    .line 80
    sget-object v1, Lmiui/content/res/ThemeZipFile;->sThemeZipFiles:Ljava/util/Map;

    new-instance v3, Lmiui/content/res/ThemeZipFile;

    invoke-static {p1}, Lmiui/content/res/ThemeZipFile;->getPackageName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v0, p0, v4}, Lmiui/content/res/ThemeZipFile;-><init>(Ljava/lang/String;Lmiui/content/res/ThemeResources$MetaData;Ljava/lang/String;)V

    invoke-interface {v1, v0, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 82
    :cond_34
    monitor-exit v2
    :try_end_35
    .catchall {:try_start_1e .. :try_end_35} :catchall_3e

    .line 84
    :cond_35
    sget-object v1, Lmiui/content/res/ThemeZipFile;->sThemeZipFiles:Ljava/util/Map;

    invoke-interface {v1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lmiui/content/res/ThemeZipFile;

    return-object v1

    .line 82
    :catchall_3e
    move-exception v1

    :try_start_3f
    monitor-exit v2
    :try_end_40
    .catchall {:try_start_3f .. :try_end_40} :catchall_3e

    throw v1
.end method

.method private getZipInputStream(Ljava/lang/String;[I)Ljava/io/InputStream;
    .registers 11
    .parameter "relativeFilePath"
    .parameter "size"

    .prologue
    const/4 v4, 0x0

    .line 172
    invoke-direct {p0}, Lmiui/content/res/ThemeZipFile;->isValid()Z

    move-result v5

    if-nez v5, :cond_8

    .line 200
    :cond_7
    :goto_7
    return-object v4

    .line 174
    :cond_8
    const/4 v1, 0x0

    .line 175
    .local v1, entry:Ljava/util/zip/ZipEntry;
    :try_start_9
    const-string v5, "#*.png"

    invoke-virtual {p1, v5}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_5a

    .line 176
    const/4 v5, 0x0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v6

    const-string v7, "#*.png"

    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v7

    sub-int/2addr v6, v7

    invoke-virtual {p1, v5, v6}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    .line 178
    .local v3, fuzzyIconName:Ljava/lang/String;
    iget-object v5, p0, Lmiui/content/res/ThemeZipFile;->mZipFile:Ljava/util/zip/ZipFile;

    invoke-virtual {v5}, Ljava/util/zip/ZipFile;->entries()Ljava/util/Enumeration;

    move-result-object v0

    .line 179
    .local v0, entries:Ljava/util/Enumeration;,"Ljava/util/Enumeration<*>;"
    :cond_27
    invoke-interface {v0}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result v5

    if-eqz v5, :cond_44

    .line 180
    invoke-interface {v0}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/zip/ZipEntry;

    .line 181
    .local v2, enumEntry:Ljava/util/zip/ZipEntry;
    invoke-virtual {v2}, Ljava/util/zip/ZipEntry;->isDirectory()Z

    move-result v5

    if-nez v5, :cond_27

    .line 184
    invoke-virtual {v2}, Ljava/util/zip/ZipEntry;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_27

    .line 185
    move-object v1, v2

    .line 192
    .end local v0           #entries:Ljava/util/Enumeration;,"Ljava/util/Enumeration<*>;"
    .end local v2           #enumEntry:Ljava/util/zip/ZipEntry;
    .end local v3           #fuzzyIconName:Ljava/lang/String;
    :cond_44
    :goto_44
    if-eqz v1, :cond_7

    .line 193
    if-eqz p2, :cond_53

    array-length v5, p2

    if-lez v5, :cond_53

    .line 194
    const/4 v5, 0x0

    invoke-virtual {v1}, Ljava/util/zip/ZipEntry;->getSize()J

    move-result-wide v6

    long-to-int v6, v6

    aput v6, p2, v5

    .line 196
    :cond_53
    iget-object v5, p0, Lmiui/content/res/ThemeZipFile;->mZipFile:Ljava/util/zip/ZipFile;

    invoke-virtual {v5, v1}, Ljava/util/zip/ZipFile;->getInputStream(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;

    move-result-object v4

    goto :goto_7

    .line 190
    :cond_5a
    iget-object v5, p0, Lmiui/content/res/ThemeZipFile;->mZipFile:Ljava/util/zip/ZipFile;

    invoke-virtual {v5, p1}, Ljava/util/zip/ZipFile;->getEntry(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    :try_end_5f
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_5f} :catch_61

    move-result-object v1

    goto :goto_44

    .line 198
    :catch_61
    move-exception v5

    goto :goto_7
.end method

.method private isValid()Z
    .registers 2

    .prologue
    .line 134
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
    const/4 v10, 0x0

    .line 216
    sget-boolean v6, Lmiui/content/res/ThemeZipFile;->DBG:Z

    if-eqz v6, :cond_20

    sget-object v6, Lmiui/content/res/ThemeZipFile;->TAG:Ljava/lang/String;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "loadThemeValues for "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget-object v8, p0, Lmiui/content/res/ThemeZipFile;->mPath:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 218
    :cond_20
    const/4 v2, 0x0

    .local v2, i:I
    :goto_21
    sget-object v6, Lmiui/content/res/ThemeZipFile;->sDensities:[I

    array-length v6, v6

    if-ge v2, v6, :cond_63

    .line 219
    const-string/jumbo v6, "theme_values%s.xml"

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    sget-object v9, Lmiui/content/res/ThemeZipFile;->sDensities:[I

    aget v9, v9, v2

    invoke-static {v9}, Lmiui/util/DisplayUtils;->getDensitySuffix(I)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v7, v8

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 220
    .local v1, file:Ljava/lang/String;
    invoke-direct {p0, v1, v10}, Lmiui/content/res/ThemeZipFile;->getZipInputStream(Ljava/lang/String;[I)Ljava/io/InputStream;

    move-result-object v3

    .line 221
    .local v3, is:Ljava/io/InputStream;
    if-eqz v3, :cond_5b

    .line 223
    :try_start_41
    invoke-static {}, Lorg/xmlpull/v1/XmlPullParserFactory;->newInstance()Lorg/xmlpull/v1/XmlPullParserFactory;

    move-result-object v6

    invoke-virtual {v6}, Lorg/xmlpull/v1/XmlPullParserFactory;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v5

    .line 224
    .local v5, parser:Lorg/xmlpull/v1/XmlPullParser;
    new-instance v4, Ljava/io/BufferedInputStream;

    const/16 v6, 0x2000

    invoke-direct {v4, v3, v6}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;I)V
    :try_end_50
    .catchall {:try_start_41 .. :try_end_50} :catchall_5e
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_41 .. :try_end_50} :catch_64

    .line 225
    .end local v3           #is:Ljava/io/InputStream;
    .local v4, is:Ljava/io/InputStream;
    const/4 v6, 0x0

    :try_start_51
    invoke-interface {v5, v4, v6}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/InputStream;Ljava/lang/String;)V

    .line 226
    invoke-direct {p0, p1, v5}, Lmiui/content/res/ThemeZipFile;->mergeThemeValues(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;)V
    :try_end_57
    .catchall {:try_start_51 .. :try_end_57} :catchall_78
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_51 .. :try_end_57} :catch_7b

    .line 230
    :try_start_57
    invoke-virtual {v4}, Ljava/io/BufferedInputStream;->close()V
    :try_end_5a
    .catch Ljava/io/IOException; {:try_start_57 .. :try_end_5a} :catch_73

    :goto_5a
    move-object v3, v4

    .line 218
    .end local v4           #is:Ljava/io/InputStream;
    .end local v5           #parser:Lorg/xmlpull/v1/XmlPullParser;
    .restart local v3       #is:Ljava/io/InputStream;
    :cond_5b
    :goto_5b
    add-int/lit8 v2, v2, 0x1

    goto :goto_21

    .line 229
    :catchall_5e
    move-exception v6

    .line 230
    :goto_5f
    :try_start_5f
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V
    :try_end_62
    .catch Ljava/io/IOException; {:try_start_5f .. :try_end_62} :catch_6e

    .line 229
    :goto_62
    throw v6

    .line 237
    .end local v1           #file:Ljava/lang/String;
    .end local v3           #is:Ljava/io/InputStream;
    :cond_63
    return-void

    .line 227
    .restart local v1       #file:Ljava/lang/String;
    .restart local v3       #is:Ljava/io/InputStream;
    :catch_64
    move-exception v6

    .line 230
    :goto_65
    :try_start_65
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V
    :try_end_68
    .catch Ljava/io/IOException; {:try_start_65 .. :try_end_68} :catch_69

    goto :goto_5b

    .line 231
    :catch_69
    move-exception v0

    .line 232
    .local v0, e:Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_5b

    .line 231
    .end local v0           #e:Ljava/io/IOException;
    :catch_6e
    move-exception v0

    .line 232
    .restart local v0       #e:Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_62

    .line 231
    .end local v0           #e:Ljava/io/IOException;
    .end local v3           #is:Ljava/io/InputStream;
    .restart local v4       #is:Ljava/io/InputStream;
    .restart local v5       #parser:Lorg/xmlpull/v1/XmlPullParser;
    :catch_73
    move-exception v0

    .line 232
    .restart local v0       #e:Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_5a

    .line 229
    .end local v0           #e:Ljava/io/IOException;
    :catchall_78
    move-exception v6

    move-object v3, v4

    .end local v4           #is:Ljava/io/InputStream;
    .restart local v3       #is:Ljava/io/InputStream;
    goto :goto_5f

    .line 227
    .end local v3           #is:Ljava/io/InputStream;
    .restart local v4       #is:Ljava/io/InputStream;
    :catch_7b
    move-exception v6

    move-object v3, v4

    .end local v4           #is:Ljava/io/InputStream;
    .restart local v3       #is:Ljava/io/InputStream;
    goto :goto_65
.end method

.method private mergeThemeValues(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;)V
    .registers 16
    .parameter "resources"
    .parameter "parser"

    .prologue
    .line 242
    :cond_0
    :try_start_0
    invoke-interface {p2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v7

    .local v7, tagtype:I
    const/4 v10, 0x2

    if-eq v7, v10, :cond_a

    const/4 v10, 0x1

    if-ne v7, v10, :cond_0

    .line 245
    :cond_a
    const/4 v10, 0x2

    if-eq v7, v10, :cond_1a

    .line 246
    new-instance v10, Lorg/xmlpull/v1/XmlPullParserException;

    const-string v11, "No start tag found"

    invoke-direct {v10, v11}, Lorg/xmlpull/v1/XmlPullParserException;-><init>(Ljava/lang/String;)V

    throw v10
    :try_end_15
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_15} :catch_15

    .line 294
    .end local v7           #tagtype:I
    :catch_15
    move-exception v2

    .line 295
    .local v2, e:Ljava/lang/Exception;
    invoke-virtual {v2}, Ljava/lang/Exception;->printStackTrace()V

    .line 297
    .end local v2           #e:Ljava/lang/Exception;
    :cond_19
    return-void

    .line 250
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

    .line 252
    :cond_24
    const/4 v10, 0x1

    if-eq v7, v10, :cond_19

    .line 254
    invoke-interface {p2}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v8

    .line 255
    .local v8, type:Ljava/lang/String;
    if-eqz v8, :cond_19

    .line 257
    const/4 v5, 0x0

    .line 258
    .local v5, name:Ljava/lang/String;
    const/4 v6, 0x0

    .line 259
    .local v6, pkg:Ljava/lang/String;
    invoke-interface {p2}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeCount()I

    move-result v10

    add-int/lit8 v3, v10, -0x1

    .local v3, i:I
    :goto_39
    if-ltz v3, :cond_61

    .line 260
    invoke-interface {p2, v3}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeName(I)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    .line 261
    .local v0, attrName:Ljava/lang/String;
    const-string/jumbo v10, "name"

    invoke-virtual {v0, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_53

    .line 262
    invoke-interface {p2, v3}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(I)Ljava/lang/String;

    move-result-object v5

    .line 259
    :cond_50
    :goto_50
    add-int/lit8 v3, v3, -0x1

    goto :goto_39

    .line 263
    :cond_53
    const-string/jumbo v10, "package"

    invoke-virtual {v0, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_50

    .line 264
    invoke-interface {p2, v3}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(I)Ljava/lang/String;

    move-result-object v6

    goto :goto_50

    .line 267
    .end local v0           #attrName:Ljava/lang/String;
    :cond_61
    invoke-interface {p2}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v9

    .line 268
    .local v9, value:Ljava/lang/String;
    if-eqz v5, :cond_1a

    if-eqz v9, :cond_1a

    invoke-virtual {v9}, Ljava/lang/String;->length()I

    move-result v10

    if-eqz v10, :cond_1a

    .line 270
    if-nez v6, :cond_73

    iget-object v6, p0, Lmiui/content/res/ThemeZipFile;->mPackageName:Ljava/lang/String;

    .end local v6           #pkg:Ljava/lang/String;
    :cond_73
    invoke-virtual {p1, v5, v8, v6}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v4

    .line 271
    .local v4, id:I
    if-lez v4, :cond_1a

    .line 272
    const-string v10, "bool"

    invoke-virtual {v8, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_aa

    .line 273
    iget-object v10, p0, Lmiui/content/res/ThemeZipFile;->mMetaData:Lmiui/content/res/ThemeResources$MetaData;

    iget-boolean v10, v10, Lmiui/content/res/ThemeResources$MetaData;->supportInt:Z

    if-eqz v10, :cond_1a

    iget-object v10, p0, Lmiui/content/res/ThemeZipFile;->mIntegers:Landroid/util/SparseArray;

    invoke-virtual {v10, v4}, Landroid/util/SparseArray;->indexOfKey(I)I

    move-result v10

    if-gez v10, :cond_1a

    .line 274
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

    .line 276
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

    .line 277
    :cond_c2
    iget-object v10, p0, Lmiui/content/res/ThemeZipFile;->mMetaData:Lmiui/content/res/ThemeResources$MetaData;

    iget-boolean v10, v10, Lmiui/content/res/ThemeResources$MetaData;->supportInt:Z

    if-eqz v10, :cond_1a

    iget-object v10, p0, Lmiui/content/res/ThemeZipFile;->mIntegers:Landroid/util/SparseArray;

    invoke-virtual {v10, v4}, Landroid/util/SparseArray;->indexOfKey(I)I

    move-result v10

    if-gez v10, :cond_1a

    .line 278
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

    .line 280
    :cond_e4
    const-string/jumbo v10, "string"

    invoke-virtual {v8, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_102

    .line 281
    iget-object v10, p0, Lmiui/content/res/ThemeZipFile;->mMetaData:Lmiui/content/res/ThemeResources$MetaData;

    iget-boolean v10, v10, Lmiui/content/res/ThemeResources$MetaData;->supportCharSequence:Z

    if-eqz v10, :cond_1a

    iget-object v10, p0, Lmiui/content/res/ThemeZipFile;->mCharSequences:Landroid/util/SparseArray;

    invoke-virtual {v10, v4}, Landroid/util/SparseArray;->indexOfKey(I)I

    move-result v10

    if-gez v10, :cond_1a

    .line 282
    iget-object v10, p0, Lmiui/content/res/ThemeZipFile;->mCharSequences:Landroid/util/SparseArray;

    invoke-virtual {v10, v4, v9}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    goto/16 :goto_1a

    .line 284
    :cond_102
    const-string v10, "dimen"

    invoke-virtual {v8, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_1a

    .line 285
    iget-object v10, p0, Lmiui/content/res/ThemeZipFile;->mMetaData:Lmiui/content/res/ThemeResources$MetaData;

    iget-boolean v10, v10, Lmiui/content/res/ThemeResources$MetaData;->supportInt:Z

    if-eqz v10, :cond_1a

    iget-object v10, p0, Lmiui/content/res/ThemeZipFile;->mIntegers:Landroid/util/SparseArray;

    invoke-virtual {v10, v4}, Landroid/util/SparseArray;->indexOfKey(I)I

    move-result v10

    if-gez v10, :cond_1a

    .line 286
    invoke-virtual {v9}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Landroid/app/MiuiThemeHelper;->parseDimension(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v1

    .line 287
    .local v1, dimen:Ljava/lang/Integer;
    if-eqz v1, :cond_1a

    .line 288
    iget-object v10, p0, Lmiui/content/res/ThemeZipFile;->mIntegers:Landroid/util/SparseArray;

    invoke-virtual {v10, v4, v1}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V
    :try_end_127
    .catch Ljava/lang/Exception; {:try_start_1a .. :try_end_127} :catch_15

    goto/16 :goto_1a
.end method

.method private openZipFile()V
    .registers 7

    .prologue
    .line 315
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

    .line 317
    :cond_1f
    new-instance v1, Ljava/io/File;

    iget-object v2, p0, Lmiui/content/res/ThemeZipFile;->mPath:Ljava/lang/String;

    invoke-direct {v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 318
    .local v1, file:Ljava/io/File;
    invoke-virtual {v1}, Ljava/io/File;->lastModified()J

    move-result-wide v2

    iput-wide v2, p0, Lmiui/content/res/ThemeZipFile;->mLastModifyTime:J

    .line 319
    iget-wide v2, p0, Lmiui/content/res/ThemeZipFile;->mLastModifyTime:J

    const-wide/16 v4, 0x0

    cmp-long v2, v2, v4

    if-nez v2, :cond_35

    .line 326
    :goto_34
    return-void

    .line 322
    :cond_35
    :try_start_35
    new-instance v2, Ljava/util/zip/ZipFile;

    invoke-direct {v2, v1}, Ljava/util/zip/ZipFile;-><init>(Ljava/io/File;)V

    iput-object v2, p0, Lmiui/content/res/ThemeZipFile;->mZipFile:Ljava/util/zip/ZipFile;
    :try_end_3c
    .catch Ljava/lang/Exception; {:try_start_35 .. :try_end_3c} :catch_3d

    goto :goto_34

    .line 323
    :catch_3d
    move-exception v0

    .line 324
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
    .line 116
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

    .line 118
    :cond_1e
    new-instance v2, Ljava/io/File;

    iget-object v3, p0, Lmiui/content/res/ThemeZipFile;->mPath:Ljava/lang/String;

    invoke-direct {v2, v3}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/io/File;->lastModified()J

    move-result-wide v0

    .line 119
    .local v0, lastModified:J
    iget-wide v2, p0, Lmiui/content/res/ThemeZipFile;->mLastModifyTime:J

    cmp-long v2, v2, v0

    if-eqz v2, :cond_43

    .line 120
    monitor-enter p0

    .line 121
    :try_start_30
    iget-wide v2, p0, Lmiui/content/res/ThemeZipFile;->mLastModifyTime:J

    cmp-long v2, v2, v0

    if-eqz v2, :cond_42

    .line 122
    invoke-direct {p0}, Lmiui/content/res/ThemeZipFile;->clean()V

    .line 123
    invoke-direct {p0}, Lmiui/content/res/ThemeZipFile;->openZipFile()V

    .line 124
    invoke-direct {p0, p1}, Lmiui/content/res/ThemeZipFile;->loadThemeValues(Landroid/content/res/Resources;)V

    .line 125
    const/4 v2, 0x1

    monitor-exit p0

    .line 130
    :goto_41
    return v2

    .line 127
    :cond_42
    monitor-exit p0

    .line 130
    :cond_43
    const/4 v2, 0x0

    goto :goto_41

    .line 127
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
    .line 142
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
    .line 138
    new-instance v0, Ljava/io/File;

    iget-object v1, p0, Lmiui/content/res/ThemeZipFile;->mPath:Ljava/lang/String;

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    return v0
.end method

.method public getInputStream(Ljava/lang/String;[I)Ljava/io/InputStream;
    .registers 4
    .parameter "relativeFilePath"
    .parameter "size"

    .prologue
    .line 146
    iget-object v0, p0, Lmiui/content/res/ThemeZipFile;->mMetaData:Lmiui/content/res/ThemeResources$MetaData;

    iget-boolean v0, v0, Lmiui/content/res/ThemeResources$MetaData;->supportFile:Z

    if-eqz v0, :cond_b

    invoke-direct {p0, p1, p2}, Lmiui/content/res/ThemeZipFile;->getInputStreamInner(Ljava/lang/String;[I)Ljava/io/InputStream;

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
    .line 212
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
    .line 208
    iget-object v0, p0, Lmiui/content/res/ThemeZipFile;->mIntegers:Landroid/util/SparseArray;

    invoke-virtual {v0, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    return-object v0
.end method

.method public hasValues()Z
    .registers 2

    .prologue
    .line 204
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
