.class public Lcom/android/internal/content/NativeLibraryHelper;
.super Ljava/lang/Object;
.source "NativeLibraryHelper.java"


# static fields
.field private static final DEBUG_NATIVE:Z = false

.field private static final TAG:Ljava/lang/String; = "NativeHelper"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 29
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static copyNativeBinariesIfNeededLI(Ljava/io/File;Ljava/io/File;)I
    .registers 6
    .parameter "apkFile"
    .parameter "sharedLibraryDir"

    .prologue
    .line 60
    sget-object v0, Landroid/os/Build;->CPU_ABI:Ljava/lang/String;

    .line 61
    .local v0, cpuAbi:Ljava/lang/String;
    sget-object v1, Landroid/os/Build;->CPU_ABI2:Ljava/lang/String;

    .line 62
    .local v1, cpuAbi2:Ljava/lang/String;
    invoke-virtual {p0}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3, v0, v1}, Lcom/android/internal/content/NativeLibraryHelper;->nativeCopyNativeBinaries(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v2

    return v2
.end method

.method private static native nativeCopyNativeBinaries(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
.end method

.method private static native nativeSumNativeBinaries(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)J
.end method

.method public static removeNativeBinariesFromDirLI(Ljava/io/File;)Z
    .registers 7
    .parameter "nativeLibraryDir"

    .prologue
    .line 78
    const/4 v1, 0x0

    .line 85
    .local v1, deletedFiles:Z
    invoke-virtual {p0}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_3c

    .line 86
    invoke-virtual {p0}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v0

    .line 87
    .local v0, binaries:[Ljava/io/File;
    if-eqz v0, :cond_3c

    .line 88
    const/4 v2, 0x0

    .local v2, nn:I
    :goto_e
    array-length v3, v0

    if-ge v2, v3, :cond_3c

    .line 93
    aget-object v3, v0, v2

    invoke-virtual {v3}, Ljava/io/File;->delete()Z

    move-result v3

    if-nez v3, :cond_3a

    .line 94
    const-string v3, "NativeHelper"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Could not delete native binary: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    aget-object v5, v0, v2

    invoke-virtual {v5}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Slog;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 88
    :goto_37
    add-int/lit8 v2, v2, 0x1

    goto :goto_e

    .line 96
    :cond_3a
    const/4 v1, 0x1

    goto :goto_37

    .line 104
    .end local v0           #binaries:[Ljava/io/File;
    .end local v2           #nn:I
    :cond_3c
    return v1
.end method

.method public static removeNativeBinariesLI(Ljava/lang/String;)Z
    .registers 2
    .parameter "nativeLibraryPath"

    .prologue
    .line 68
    new-instance v0, Ljava/io/File;

    invoke-direct {v0, p0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lcom/android/internal/content/NativeLibraryHelper;->removeNativeBinariesFromDirLI(Ljava/io/File;)Z

    move-result v0

    return v0
.end method

.method public static sumNativeBinariesLI(Ljava/io/File;)J
    .registers 5
    .parameter "apkFile"

    .prologue
    .line 43
    sget-object v0, Landroid/os/Build;->CPU_ABI:Ljava/lang/String;

    .line 44
    .local v0, cpuAbi:Ljava/lang/String;
    sget-object v1, Landroid/os/Build;->CPU_ABI2:Ljava/lang/String;

    .line 45
    .local v1, cpuAbi2:Ljava/lang/String;
    invoke-virtual {p0}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2, v0, v1}, Lcom/android/internal/content/NativeLibraryHelper;->nativeSumNativeBinaries(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)J

    move-result-wide v2

    return-wide v2
.end method
