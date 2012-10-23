.class public Landroid/drm/mobile1/DrmRightsManager;
.super Ljava/lang/Object;
.source "DrmRightsManager.java"


# static fields
.field private static final DRM_MIMETYPE_MESSAGE:I = 0x1

.field private static final DRM_MIMETYPE_RIGHTS_WBXML:I = 0x4

.field public static final DRM_MIMETYPE_RIGHTS_WBXML_STRING:Ljava/lang/String; = "application/vnd.oma.drm.rights+wbxml"

.field private static final DRM_MIMETYPE_RIGHTS_XML:I = 0x3

.field public static final DRM_MIMETYPE_RIGHTS_XML_STRING:Ljava/lang/String; = "application/vnd.oma.drm.rights+xml"

.field private static final JNI_DRM_FAILURE:I = -0x1

.field private static final JNI_DRM_SUCCESS:I

.field private static singleton:Landroid/drm/mobile1/DrmRightsManager;


# direct methods
.method static constructor <clinit>()V
    .registers 3

    .prologue
    .line 64
    const/4 v1, 0x0

    sput-object v1, Landroid/drm/mobile1/DrmRightsManager;->singleton:Landroid/drm/mobile1/DrmRightsManager;

    .line 249
    :try_start_3
    const-string v1, "drm1_jni"

    invoke-static {v1}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V
    :try_end_8
    .catch Ljava/lang/UnsatisfiedLinkError; {:try_start_3 .. :try_end_8} :catch_9

    .line 254
    .local v0, ule:Ljava/lang/UnsatisfiedLinkError;
    :goto_8
    return-void

    .line 251
    .end local v0           #ule:Ljava/lang/UnsatisfiedLinkError;
    :catch_9
    move-exception v0

    .line 252
    .restart local v0       #ule:Ljava/lang/UnsatisfiedLinkError;
    sget-object v1, Ljava/lang/System;->err:Ljava/io/PrintStream;

    const-string v2, "WARNING: Could not load libdrm1_jni.so"

    invoke-virtual {v1, v2}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    goto :goto_8
.end method

.method protected constructor <init>()V
    .registers 1

    .prologue
    .line 70
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 71
    return-void
.end method

.method public static declared-synchronized getInstance()Landroid/drm/mobile1/DrmRightsManager;
    .registers 2

    .prologue
    .line 79
    const-class v1, Landroid/drm/mobile1/DrmRightsManager;

    monitor-enter v1

    :try_start_3
    sget-object v0, Landroid/drm/mobile1/DrmRightsManager;->singleton:Landroid/drm/mobile1/DrmRightsManager;

    if-nez v0, :cond_e

    .line 80
    new-instance v0, Landroid/drm/mobile1/DrmRightsManager;

    invoke-direct {v0}, Landroid/drm/mobile1/DrmRightsManager;-><init>()V

    sput-object v0, Landroid/drm/mobile1/DrmRightsManager;->singleton:Landroid/drm/mobile1/DrmRightsManager;

    .line 83
    :cond_e
    sget-object v0, Landroid/drm/mobile1/DrmRightsManager;->singleton:Landroid/drm/mobile1/DrmRightsManager;
    :try_end_10
    .catchall {:try_start_3 .. :try_end_10} :catchall_12

    monitor-exit v1

    return-object v0

    .line 79
    :catchall_12
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private native nativeDeleteRights(Landroid/drm/mobile1/DrmRights;)I
.end method

.method private native nativeGetNumOfRights()I
.end method

.method private native nativeGetRightsList([Landroid/drm/mobile1/DrmRights;I)I
.end method

.method private native nativeInstallDrmRights(Ljava/io/InputStream;IILandroid/drm/mobile1/DrmRights;)I
.end method

.method private native nativeQueryRights(Landroid/drm/mobile1/DrmRawContent;Landroid/drm/mobile1/DrmRights;)I
.end method


# virtual methods
.method public declared-synchronized deleteRights(Landroid/drm/mobile1/DrmRights;)V
    .registers 4
    .parameter "rights"

    .prologue
    .line 181
    monitor-enter p0

    :try_start_1
    invoke-direct {p0, p1}, Landroid/drm/mobile1/DrmRightsManager;->nativeDeleteRights(Landroid/drm/mobile1/DrmRights;)I
    :try_end_4
    .catchall {:try_start_1 .. :try_end_4} :catchall_a

    move-result v0

    .line 183
    .local v0, res:I
    const/4 v1, -0x1

    if-ne v1, v0, :cond_8

    .line 185
    :cond_8
    monitor-exit p0

    return-void

    .line 181
    .end local v0           #res:I
    :catchall_a
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized getRightsList()Ljava/util/List;
    .registers 8

    .prologue
    const/4 v4, 0x0

    const/4 v6, -0x1

    .line 145
    monitor-enter p0

    :try_start_3
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 148
    .local v3, rightsList:Ljava/util/List;
    invoke-direct {p0}, Landroid/drm/mobile1/DrmRightsManager;->nativeGetNumOfRights()I
    :try_end_b
    .catchall {:try_start_3 .. :try_end_b} :catchall_35

    move-result v1

    .line 150
    .local v1, num:I
    if-ne v6, v1, :cond_11

    move-object v3, v4

    .line 171
    .end local v3           #rightsList:Ljava/util/List;
    :cond_f
    :goto_f
    monitor-exit p0

    return-object v3

    .line 153
    .restart local v3       #rightsList:Ljava/util/List;
    :cond_11
    if-lez v1, :cond_f

    .line 154
    :try_start_13
    new-array v2, v1, [Landroid/drm/mobile1/DrmRights;

    .line 157
    .local v2, rightsArray:[Landroid/drm/mobile1/DrmRights;
    const/4 v0, 0x0

    .local v0, i:I
    :goto_16
    if-ge v0, v1, :cond_22

    .line 158
    new-instance v5, Landroid/drm/mobile1/DrmRights;

    invoke-direct {v5}, Landroid/drm/mobile1/DrmRights;-><init>()V

    aput-object v5, v2, v0

    .line 157
    add-int/lit8 v0, v0, 0x1

    goto :goto_16

    .line 161
    :cond_22
    invoke-direct {p0, v2, v1}, Landroid/drm/mobile1/DrmRightsManager;->nativeGetRightsList([Landroid/drm/mobile1/DrmRights;I)I

    move-result v1

    .line 163
    if-ne v6, v1, :cond_2a

    move-object v3, v4

    .line 164
    goto :goto_f

    .line 167
    :cond_2a
    const/4 v0, 0x0

    :goto_2b
    if-ge v0, v1, :cond_f

    .line 168
    aget-object v4, v2, v0

    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_32
    .catchall {:try_start_13 .. :try_end_32} :catchall_35

    .line 167
    add-int/lit8 v0, v0, 0x1

    goto :goto_2b

    .line 145
    .end local v0           #i:I
    .end local v1           #num:I
    .end local v2           #rightsArray:[Landroid/drm/mobile1/DrmRights;
    .end local v3           #rightsList:Ljava/util/List;
    :catchall_35
    move-exception v4

    monitor-exit p0

    throw v4
.end method

.method public declared-synchronized installRights(Ljava/io/InputStream;ILjava/lang/String;)Landroid/drm/mobile1/DrmRights;
    .registers 9
    .parameter "rightsData"
    .parameter "len"
    .parameter "mimeTypeStr"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/drm/mobile1/DrmException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 95
    monitor-enter p0

    const/4 v0, 0x0

    .line 97
    .local v0, mimeType:I
    :try_start_2
    const-string v3, "application/vnd.oma.drm.rights+xml"

    invoke-virtual {v3, p3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    :try_end_7
    .catchall {:try_start_2 .. :try_end_7} :catchall_2d

    move-result v3

    if-eqz v3, :cond_10

    .line 98
    const/4 v0, 0x3

    .line 106
    :goto_b
    if-gtz p2, :cond_30

    .line 107
    const/4 v2, 0x0

    .line 117
    :cond_e
    monitor-exit p0

    return-object v2

    .line 99
    :cond_10
    :try_start_10
    const-string v3, "application/vnd.oma.drm.rights+wbxml"

    invoke-virtual {v3, p3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1a

    .line 100
    const/4 v0, 0x4

    goto :goto_b

    .line 101
    :cond_1a
    const-string v3, "application/vnd.oma.drm.message"

    invoke-virtual {v3, p3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_24

    .line 102
    const/4 v0, 0x1

    goto :goto_b

    .line 104
    :cond_24
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v4, "mimeType must be DRM_MIMETYPE_RIGHTS_XML or DRM_MIMETYPE_RIGHTS_WBXML or DRM_MIMETYPE_MESSAGE"

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3
    :try_end_2d
    .catchall {:try_start_10 .. :try_end_2d} :catchall_2d

    .line 95
    :catchall_2d
    move-exception v3

    monitor-exit p0

    throw v3

    .line 109
    :cond_30
    :try_start_30
    new-instance v2, Landroid/drm/mobile1/DrmRights;

    invoke-direct {v2}, Landroid/drm/mobile1/DrmRights;-><init>()V

    .line 112
    .local v2, rights:Landroid/drm/mobile1/DrmRights;
    invoke-direct {p0, p1, p2, v0, v2}, Landroid/drm/mobile1/DrmRightsManager;->nativeInstallDrmRights(Ljava/io/InputStream;IILandroid/drm/mobile1/DrmRights;)I

    move-result v1

    .line 114
    .local v1, res:I
    const/4 v3, -0x1

    if-ne v3, v1, :cond_e

    .line 115
    new-instance v3, Landroid/drm/mobile1/DrmException;

    const-string/jumbo v4, "nativeInstallDrmRights() returned JNI_DRM_FAILURE"

    invoke-direct {v3, v4}, Landroid/drm/mobile1/DrmException;-><init>(Ljava/lang/String;)V

    throw v3
    :try_end_45
    .catchall {:try_start_30 .. :try_end_45} :catchall_2d
.end method

.method public declared-synchronized queryRights(Landroid/drm/mobile1/DrmRawContent;)Landroid/drm/mobile1/DrmRights;
    .registers 5
    .parameter "content"

    .prologue
    .line 128
    monitor-enter p0

    :try_start_1
    new-instance v1, Landroid/drm/mobile1/DrmRights;

    invoke-direct {v1}, Landroid/drm/mobile1/DrmRights;-><init>()V

    .line 131
    .local v1, rights:Landroid/drm/mobile1/DrmRights;
    invoke-direct {p0, p1, v1}, Landroid/drm/mobile1/DrmRightsManager;->nativeQueryRights(Landroid/drm/mobile1/DrmRawContent;Landroid/drm/mobile1/DrmRights;)I
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_10

    move-result v0

    .line 133
    .local v0, res:I
    const/4 v2, -0x1

    if-ne v2, v0, :cond_e

    .line 134
    const/4 v1, 0x0

    .line 136
    .end local v1           #rights:Landroid/drm/mobile1/DrmRights;
    :cond_e
    monitor-exit p0

    return-object v1

    .line 128
    .end local v0           #res:I
    :catchall_10
    move-exception v2

    monitor-exit p0

    throw v2
.end method
