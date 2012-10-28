.class public Landroid/drm/mobile1/DrmRawContent;
.super Ljava/lang/Object;
.source "DrmRawContent.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/drm/mobile1/DrmRawContent$DrmInputStream;
    }
.end annotation


# static fields
.field public static final DRM_COMBINED_DELIVERY:I = 0x2

.field public static final DRM_FORWARD_LOCK:I = 0x1

.field private static final DRM_MIMETYPE_CONTENT:I = 0x2

.field public static final DRM_MIMETYPE_CONTENT_STRING:Ljava/lang/String; = "application/vnd.oma.drm.content"

.field private static final DRM_MIMETYPE_MESSAGE:I = 0x1

.field public static final DRM_MIMETYPE_MESSAGE_STRING:Ljava/lang/String; = "application/vnd.oma.drm.message"

.field public static final DRM_SEPARATE_DELIVERY:I = 0x3

.field public static final DRM_SEPARATE_DELIVERY_DM:I = 0x4

.field public static final DRM_UNKNOWN_DATA_LEN:I = -0x1

.field private static final JNI_DRM_EOF:I = -0x2

.field private static final JNI_DRM_FAILURE:I = -0x1

.field private static final JNI_DRM_SUCCESS:I = 0x0

.field private static final JNI_DRM_UNKNOWN_DATA_LEN:I = -0x3


# instance fields
.field private id:I

.field private inData:Ljava/io/BufferedInputStream;

.field private inDataLen:I

.field private mediaType:Ljava/lang/String;

.field private rawType:I

.field private rightsIssuer:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .registers 3

    .prologue
    .line 458
    :try_start_0
    const-string v1, "drm1_jni"

    invoke-static {v1}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V
    :try_end_5
    .catch Ljava/lang/UnsatisfiedLinkError; {:try_start_0 .. :try_end_5} :catch_6

    .line 463
    .local v0, ule:Ljava/lang/UnsatisfiedLinkError;
    :goto_5
    return-void

    .line 460
    .end local v0           #ule:Ljava/lang/UnsatisfiedLinkError;
    :catch_6
    move-exception v0

    .line 461
    .restart local v0       #ule:Ljava/lang/UnsatisfiedLinkError;
    sget-object v1, Ljava/lang/System;->err:Ljava/io/PrintStream;

    const-string v2, "WARNING: Could not load libdrm1_jni.so"

    invoke-virtual {v1, v2}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    goto :goto_5
.end method

.method public constructor <init>(Ljava/io/InputStream;ILjava/lang/String;)V
    .registers 8
    .parameter "inRawdata"
    .parameter "len"
    .parameter "mimeTypeStr"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/drm/mobile1/DrmException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v3, -0x1

    .line 131
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 134
    iput v3, p0, Landroid/drm/mobile1/DrmRawContent;->id:I

    .line 135
    new-instance v1, Ljava/io/BufferedInputStream;

    const/16 v2, 0x400

    invoke-direct {v1, p1, v2}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;I)V

    iput-object v1, p0, Landroid/drm/mobile1/DrmRawContent;->inData:Ljava/io/BufferedInputStream;

    .line 136
    iput p2, p0, Landroid/drm/mobile1/DrmRawContent;->inDataLen:I

    .line 138
    const-string v1, "application/vnd.oma.drm.message"

    invoke-virtual {v1, p3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_24

    .line 139
    const/4 v0, 0x1

    .line 145
    .local v0, mimeType:I
    :goto_1a
    if-gtz p2, :cond_37

    .line 146
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "len must be > 0"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 140
    .end local v0           #mimeType:I
    :cond_24
    const-string v1, "application/vnd.oma.drm.content"

    invoke-virtual {v1, p3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2e

    .line 141
    const/4 v0, 0x2

    .restart local v0       #mimeType:I
    goto :goto_1a

    .line 143
    .end local v0           #mimeType:I
    :cond_2e
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "mimeType must be DRM_MIMETYPE_MESSAGE or DRM_MIMETYPE_CONTENT"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 149
    .restart local v0       #mimeType:I
    :cond_37
    iget-object v1, p0, Landroid/drm/mobile1/DrmRawContent;->inData:Ljava/io/BufferedInputStream;

    iget v2, p0, Landroid/drm/mobile1/DrmRawContent;->inDataLen:I

    invoke-direct {p0, v1, v2, v0}, Landroid/drm/mobile1/DrmRawContent;->nativeConstructDrmContent(Ljava/io/InputStream;II)I

    move-result v1

    iput v1, p0, Landroid/drm/mobile1/DrmRawContent;->id:I

    .line 151
    iget v1, p0, Landroid/drm/mobile1/DrmRawContent;->id:I

    if-ne v3, v1, :cond_4e

    .line 152
    new-instance v1, Landroid/drm/mobile1/DrmException;

    const-string/jumbo v2, "nativeConstructDrmContent() returned JNI_DRM_FAILURE"

    invoke-direct {v1, v2}, Landroid/drm/mobile1/DrmException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 155
    :cond_4e
    invoke-direct {p0}, Landroid/drm/mobile1/DrmRawContent;->nativeGetRightsAddress()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Landroid/drm/mobile1/DrmRawContent;->rightsIssuer:Ljava/lang/String;

    .line 158
    invoke-direct {p0}, Landroid/drm/mobile1/DrmRawContent;->nativeGetDeliveryMethod()I

    move-result v1

    iput v1, p0, Landroid/drm/mobile1/DrmRawContent;->rawType:I

    .line 159
    iget v1, p0, Landroid/drm/mobile1/DrmRawContent;->rawType:I

    if-ne v3, v1, :cond_67

    .line 160
    new-instance v1, Landroid/drm/mobile1/DrmException;

    const-string/jumbo v2, "nativeGetDeliveryMethod() returned JNI_DRM_FAILURE"

    invoke-direct {v1, v2}, Landroid/drm/mobile1/DrmException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 163
    :cond_67
    invoke-direct {p0}, Landroid/drm/mobile1/DrmRawContent;->nativeGetContentType()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Landroid/drm/mobile1/DrmRawContent;->mediaType:Ljava/lang/String;

    .line 164
    iget-object v1, p0, Landroid/drm/mobile1/DrmRawContent;->mediaType:Ljava/lang/String;

    if-nez v1, :cond_7a

    .line 165
    new-instance v1, Landroid/drm/mobile1/DrmException;

    const-string/jumbo v2, "nativeGetContentType() returned null"

    invoke-direct {v1, v2}, Landroid/drm/mobile1/DrmException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 166
    :cond_7a
    return-void
.end method

.method static synthetic access$000(Landroid/drm/mobile1/DrmRawContent;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 24
    invoke-direct {p0}, Landroid/drm/mobile1/DrmRawContent;->nativeGetContentLength()I

    move-result v0

    return v0
.end method

.method static synthetic access$100(Landroid/drm/mobile1/DrmRawContent;[BIII)I
    .registers 6
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"
    .parameter "x3"
    .parameter "x4"

    .prologue
    .line 24
    invoke-direct {p0, p1, p2, p3, p4}, Landroid/drm/mobile1/DrmRawContent;->nativeReadContent([BIII)I

    move-result v0

    return v0
.end method

.method private native nativeConstructDrmContent(Ljava/io/InputStream;II)I
.end method

.method private native nativeGetContentLength()I
.end method

.method private native nativeGetContentType()Ljava/lang/String;
.end method

.method private native nativeGetDeliveryMethod()I
.end method

.method private native nativeGetRightsAddress()Ljava/lang/String;
.end method

.method private native nativeReadContent([BIII)I
.end method


# virtual methods
.method protected native finalize()V
.end method

.method public getContentInputStream(Landroid/drm/mobile1/DrmRights;)Ljava/io/InputStream;
    .registers 3
    .parameter "rights"

    .prologue
    .line 199
    if-nez p1, :cond_8

    .line 200
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0

    .line 202
    :cond_8
    new-instance v0, Landroid/drm/mobile1/DrmRawContent$DrmInputStream;

    invoke-direct {v0, p0, p1}, Landroid/drm/mobile1/DrmRawContent$DrmInputStream;-><init>(Landroid/drm/mobile1/DrmRawContent;Landroid/drm/mobile1/DrmRights;)V

    return-object v0
.end method

.method public getContentLength(Landroid/drm/mobile1/DrmRights;)I
    .registers 5
    .parameter "rights"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/drm/mobile1/DrmException;
        }
    .end annotation

    .prologue
    const/4 v1, -0x1

    .line 229
    if-nez p1, :cond_9

    .line 230
    new-instance v1, Ljava/lang/NullPointerException;

    invoke-direct {v1}, Ljava/lang/NullPointerException;-><init>()V

    throw v1

    .line 232
    :cond_9
    invoke-direct {p0}, Landroid/drm/mobile1/DrmRawContent;->nativeGetContentLength()I

    move-result v0

    .line 234
    .local v0, mediaLen:I
    if-ne v1, v0, :cond_18

    .line 235
    new-instance v1, Landroid/drm/mobile1/DrmException;

    const-string/jumbo v2, "nativeGetContentLength() returned JNI_DRM_FAILURE"

    invoke-direct {v1, v2}, Landroid/drm/mobile1/DrmException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 237
    :cond_18
    const/4 v2, -0x3

    if-ne v2, v0, :cond_1c

    move v0, v1

    .line 240
    .end local v0           #mediaLen:I
    :cond_1c
    return v0
.end method

.method public getContentType()Ljava/lang/String;
    .registers 2

    .prologue
    .line 211
    iget-object v0, p0, Landroid/drm/mobile1/DrmRawContent;->mediaType:Ljava/lang/String;

    return-object v0
.end method

.method public getRawType()I
    .registers 2

    .prologue
    .line 188
    iget v0, p0, Landroid/drm/mobile1/DrmRawContent;->rawType:I

    return v0
.end method

.method public getRightsAddress()Ljava/lang/String;
    .registers 2

    .prologue
    .line 175
    iget-object v0, p0, Landroid/drm/mobile1/DrmRawContent;->rightsIssuer:Ljava/lang/String;

    return-object v0
.end method
