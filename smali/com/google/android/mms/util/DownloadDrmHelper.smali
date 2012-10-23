.class public Lcom/google/android/mms/util/DownloadDrmHelper;
.super Ljava/lang/Object;
.source "DownloadDrmHelper.java"


# static fields
.field public static final EXTENSION_DRM_MESSAGE:Ljava/lang/String; = ".dm"

.field public static final EXTENSION_INTERNAL_FWDL:Ljava/lang/String; = ".fl"

.field public static final MIMETYPE_DRM_MESSAGE:Ljava/lang/String; = "application/vnd.oma.drm.message"

.field private static final TAG:Ljava/lang/String; = "DownloadDrmHelper"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 24
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getOriginalMimeType(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .registers 8
    .parameter "context"
    .parameter "path"
    .parameter "containingMime"

    .prologue
    .line 97
    move-object v2, p2

    .line 98
    .local v2, result:Ljava/lang/String;
    new-instance v0, Landroid/drm/DrmManagerClient;

    invoke-direct {v0, p0}, Landroid/drm/DrmManagerClient;-><init>(Landroid/content/Context;)V

    .line 100
    .local v0, drmClient:Landroid/drm/DrmManagerClient;
    const/4 v3, 0x0

    :try_start_7
    invoke-virtual {v0, p1, v3}, Landroid/drm/DrmManagerClient;->canHandle(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_11

    .line 101
    invoke-virtual {v0, p1}, Landroid/drm/DrmManagerClient;->getOriginalMimeType(Ljava/lang/String;)Ljava/lang/String;
    :try_end_10
    .catch Ljava/lang/IllegalArgumentException; {:try_start_7 .. :try_end_10} :catch_12
    .catch Ljava/lang/IllegalStateException; {:try_start_7 .. :try_end_10} :catch_1b

    move-result-object v2

    .line 109
    :cond_11
    :goto_11
    return-object v2

    .line 103
    :catch_12
    move-exception v1

    .line 104
    .local v1, ex:Ljava/lang/IllegalArgumentException;
    const-string v3, "DownloadDrmHelper"

    const-string v4, "Can\'t get original mime type since path is null or empty string."

    invoke-static {v3, v4}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_11

    .line 106
    .end local v1           #ex:Ljava/lang/IllegalArgumentException;
    :catch_1b
    move-exception v1

    .line 107
    .local v1, ex:Ljava/lang/IllegalStateException;
    const-string v3, "DownloadDrmHelper"

    const-string v4, "DrmManagerClient didn\'t initialize properly."

    invoke-static {v3, v4}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_11
.end method

.method public static isDrmConvertNeeded(Ljava/lang/String;)Z
    .registers 2
    .parameter "mimetype"

    .prologue
    .line 67
    const-string v0, "application/vnd.oma.drm.message"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public static isDrmMimeType(Landroid/content/Context;Ljava/lang/String;)Z
    .registers 7
    .parameter "context"
    .parameter "mimetype"

    .prologue
    .line 43
    const/4 v2, 0x0

    .line 44
    .local v2, result:Z
    if-eqz p0, :cond_18

    .line 46
    :try_start_3
    new-instance v0, Landroid/drm/DrmManagerClient;

    invoke-direct {v0, p0}, Landroid/drm/DrmManagerClient;-><init>(Landroid/content/Context;)V

    .line 47
    .local v0, drmClient:Landroid/drm/DrmManagerClient;
    if-eqz v0, :cond_18

    if-eqz p1, :cond_18

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v3

    if-lez v3, :cond_18

    .line 48
    const-string v3, ""

    invoke-virtual {v0, v3, p1}, Landroid/drm/DrmManagerClient;->canHandle(Ljava/lang/String;Ljava/lang/String;)Z
    :try_end_17
    .catch Ljava/lang/IllegalArgumentException; {:try_start_3 .. :try_end_17} :catch_19
    .catch Ljava/lang/IllegalStateException; {:try_start_3 .. :try_end_17} :catch_22

    move-result v2

    .line 57
    .end local v0           #drmClient:Landroid/drm/DrmManagerClient;
    :cond_18
    :goto_18
    return v2

    .line 50
    :catch_19
    move-exception v1

    .line 51
    .local v1, e:Ljava/lang/IllegalArgumentException;
    const-string v3, "DownloadDrmHelper"

    const-string v4, "DrmManagerClient instance could not be created, context is Illegal."

    invoke-static {v3, v4}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_18

    .line 53
    .end local v1           #e:Ljava/lang/IllegalArgumentException;
    :catch_22
    move-exception v1

    .line 54
    .local v1, e:Ljava/lang/IllegalStateException;
    const-string v3, "DownloadDrmHelper"

    const-string v4, "DrmManagerClient didn\'t initialize properly."

    invoke-static {v3, v4}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_18
.end method

.method public static modifyDrmFwLockFileExtension(Ljava/lang/String;)Ljava/lang/String;
    .registers 3
    .parameter "filename"

    .prologue
    .line 75
    if-eqz p0, :cond_16

    .line 77
    const-string v1, "."

    invoke-virtual {p0, v1}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v0

    .line 78
    .local v0, extensionIndex:I
    const/4 v1, -0x1

    if-eq v0, v1, :cond_10

    .line 79
    const/4 v1, 0x0

    invoke-virtual {p0, v1, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p0

    .line 81
    :cond_10
    const-string v1, ".fl"

    invoke-virtual {p0, v1}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    .line 83
    .end local v0           #extensionIndex:I
    :cond_16
    return-object p0
.end method
