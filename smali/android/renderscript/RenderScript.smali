.class public Landroid/renderscript/RenderScript;
.super Ljava/lang/Object;
.source "RenderScript.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/renderscript/RenderScript$MessageThread;,
        Landroid/renderscript/RenderScript$Priority;,
        Landroid/renderscript/RenderScript$RSErrorHandler;,
        Landroid/renderscript/RenderScript$RSMessageHandler;
    }
.end annotation


# static fields
.field private static final CACHE_PATH:Ljava/lang/String; = "com.android.renderscript.cache"

.field static final DEBUG:Z = false

.field static final LOG_ENABLED:Z = false

.field static final LOG_TAG:Ljava/lang/String; = "RenderScript_jni"

.field static mCachePath:Ljava/lang/String;

.field static sInitialized:Z


# instance fields
.field private mApplicationContext:Landroid/content/Context;

.field mContext:I

.field mDev:I

.field mElement_ALLOCATION:Landroid/renderscript/Element;

.field mElement_A_8:Landroid/renderscript/Element;

.field mElement_BOOLEAN:Landroid/renderscript/Element;

.field mElement_CHAR_2:Landroid/renderscript/Element;

.field mElement_CHAR_3:Landroid/renderscript/Element;

.field mElement_CHAR_4:Landroid/renderscript/Element;

.field mElement_DOUBLE_2:Landroid/renderscript/Element;

.field mElement_DOUBLE_3:Landroid/renderscript/Element;

.field mElement_DOUBLE_4:Landroid/renderscript/Element;

.field mElement_ELEMENT:Landroid/renderscript/Element;

.field mElement_F32:Landroid/renderscript/Element;

.field mElement_F64:Landroid/renderscript/Element;

.field mElement_FLOAT_2:Landroid/renderscript/Element;

.field mElement_FLOAT_3:Landroid/renderscript/Element;

.field mElement_FLOAT_4:Landroid/renderscript/Element;

.field mElement_FONT:Landroid/renderscript/Element;

.field mElement_I16:Landroid/renderscript/Element;

.field mElement_I32:Landroid/renderscript/Element;

.field mElement_I64:Landroid/renderscript/Element;

.field mElement_I8:Landroid/renderscript/Element;

.field mElement_INT_2:Landroid/renderscript/Element;

.field mElement_INT_3:Landroid/renderscript/Element;

.field mElement_INT_4:Landroid/renderscript/Element;

.field mElement_LONG_2:Landroid/renderscript/Element;

.field mElement_LONG_3:Landroid/renderscript/Element;

.field mElement_LONG_4:Landroid/renderscript/Element;

.field mElement_MATRIX_2X2:Landroid/renderscript/Element;

.field mElement_MATRIX_3X3:Landroid/renderscript/Element;

.field mElement_MATRIX_4X4:Landroid/renderscript/Element;

.field mElement_MESH:Landroid/renderscript/Element;

.field mElement_PROGRAM_FRAGMENT:Landroid/renderscript/Element;

.field mElement_PROGRAM_RASTER:Landroid/renderscript/Element;

.field mElement_PROGRAM_STORE:Landroid/renderscript/Element;

.field mElement_PROGRAM_VERTEX:Landroid/renderscript/Element;

.field mElement_RGBA_4444:Landroid/renderscript/Element;

.field mElement_RGBA_5551:Landroid/renderscript/Element;

.field mElement_RGBA_8888:Landroid/renderscript/Element;

.field mElement_RGB_565:Landroid/renderscript/Element;

.field mElement_RGB_888:Landroid/renderscript/Element;

.field mElement_SAMPLER:Landroid/renderscript/Element;

.field mElement_SCRIPT:Landroid/renderscript/Element;

.field mElement_SHORT_2:Landroid/renderscript/Element;

.field mElement_SHORT_3:Landroid/renderscript/Element;

.field mElement_SHORT_4:Landroid/renderscript/Element;

.field mElement_TYPE:Landroid/renderscript/Element;

.field mElement_U16:Landroid/renderscript/Element;

.field mElement_U32:Landroid/renderscript/Element;

.field mElement_U64:Landroid/renderscript/Element;

.field mElement_U8:Landroid/renderscript/Element;

.field mElement_UCHAR_2:Landroid/renderscript/Element;

.field mElement_UCHAR_3:Landroid/renderscript/Element;

.field mElement_UCHAR_4:Landroid/renderscript/Element;

.field mElement_UINT_2:Landroid/renderscript/Element;

.field mElement_UINT_3:Landroid/renderscript/Element;

.field mElement_UINT_4:Landroid/renderscript/Element;

.field mElement_ULONG_2:Landroid/renderscript/Element;

.field mElement_ULONG_3:Landroid/renderscript/Element;

.field mElement_ULONG_4:Landroid/renderscript/Element;

.field mElement_USHORT_2:Landroid/renderscript/Element;

.field mElement_USHORT_3:Landroid/renderscript/Element;

.field mElement_USHORT_4:Landroid/renderscript/Element;

.field mErrorCallback:Landroid/renderscript/RenderScript$RSErrorHandler;

.field mMessageCallback:Landroid/renderscript/RenderScript$RSMessageHandler;

.field mMessageThread:Landroid/renderscript/RenderScript$MessageThread;

.field mProgramRaster_CULL_BACK:Landroid/renderscript/ProgramRaster;

.field mProgramRaster_CULL_FRONT:Landroid/renderscript/ProgramRaster;

.field mProgramRaster_CULL_NONE:Landroid/renderscript/ProgramRaster;

.field mProgramStore_BLEND_ALPHA_DEPTH_NO_DEPTH:Landroid/renderscript/ProgramStore;

.field mProgramStore_BLEND_ALPHA_DEPTH_TEST:Landroid/renderscript/ProgramStore;

.field mProgramStore_BLEND_NONE_DEPTH_NO_DEPTH:Landroid/renderscript/ProgramStore;

.field mProgramStore_BLEND_NONE_DEPTH_TEST:Landroid/renderscript/ProgramStore;

.field mSampler_CLAMP_LINEAR:Landroid/renderscript/Sampler;

.field mSampler_CLAMP_LINEAR_MIP_LINEAR:Landroid/renderscript/Sampler;

.field mSampler_CLAMP_NEAREST:Landroid/renderscript/Sampler;

.field mSampler_WRAP_LINEAR:Landroid/renderscript/Sampler;

.field mSampler_WRAP_LINEAR_MIP_LINEAR:Landroid/renderscript/Sampler;

.field mSampler_WRAP_NEAREST:Landroid/renderscript/Sampler;


# direct methods
.method static constructor <clinit>()V
    .registers 4

    .prologue
    .line 65
    const/4 v1, 0x0

    sput-boolean v1, Landroid/renderscript/RenderScript;->sInitialized:Z

    .line 67
    :try_start_3
    const-string/jumbo v1, "rs_jni"

    invoke-static {v1}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V

    .line 68
    invoke-static {}, Landroid/renderscript/RenderScript;->_nInit()V

    .line 69
    const/4 v1, 0x1

    sput-boolean v1, Landroid/renderscript/RenderScript;->sInitialized:Z
    :try_end_f
    .catch Ljava/lang/UnsatisfiedLinkError; {:try_start_3 .. :try_end_f} :catch_10

    .line 74
    return-void

    .line 70
    :catch_10
    move-exception v0

    .line 71
    .local v0, e:Ljava/lang/UnsatisfiedLinkError;
    const-string v1, "RenderScript_jni"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Error loading RS jni library: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 72
    new-instance v1, Landroid/renderscript/RSRuntimeException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Error loading RS jni library: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/renderscript/RSRuntimeException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method constructor <init>(Landroid/content/Context;)V
    .registers 3
    .parameter "ctx"

    .prologue
    const/4 v0, 0x0

    .line 919
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 767
    iput-object v0, p0, Landroid/renderscript/RenderScript;->mMessageCallback:Landroid/renderscript/RenderScript$RSMessageHandler;

    .line 796
    iput-object v0, p0, Landroid/renderscript/RenderScript;->mErrorCallback:Landroid/renderscript/RenderScript$RSErrorHandler;

    .line 920
    if-eqz p1, :cond_10

    .line 921
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Landroid/renderscript/RenderScript;->mApplicationContext:Landroid/content/Context;

    .line 923
    :cond_10
    return-void
.end method

.method static native _nInit()V
.end method

.method public static create(Landroid/content/Context;)Landroid/renderscript/RenderScript;
    .registers 3
    .parameter "ctx"

    .prologue
    .line 961
    invoke-virtual {p0}, Landroid/content/Context;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v1

    iget v0, v1, Landroid/content/pm/ApplicationInfo;->targetSdkVersion:I

    .line 962
    .local v0, v:I
    invoke-static {p0, v0}, Landroid/renderscript/RenderScript;->create(Landroid/content/Context;I)Landroid/renderscript/RenderScript;

    move-result-object v1

    return-object v1
.end method

.method public static create(Landroid/content/Context;I)Landroid/renderscript/RenderScript;
    .registers 5
    .parameter "ctx"
    .parameter "sdkVersion"

    .prologue
    .line 942
    new-instance v0, Landroid/renderscript/RenderScript;

    invoke-direct {v0, p0}, Landroid/renderscript/RenderScript;-><init>(Landroid/content/Context;)V

    .line 944
    .local v0, rs:Landroid/renderscript/RenderScript;
    invoke-virtual {v0}, Landroid/renderscript/RenderScript;->nDeviceCreate()I

    move-result v1

    iput v1, v0, Landroid/renderscript/RenderScript;->mDev:I

    .line 945
    iget v1, v0, Landroid/renderscript/RenderScript;->mDev:I

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2, p1}, Landroid/renderscript/RenderScript;->nContextCreate(III)I

    move-result v1

    iput v1, v0, Landroid/renderscript/RenderScript;->mContext:I

    .line 946
    iget v1, v0, Landroid/renderscript/RenderScript;->mContext:I

    if-nez v1, :cond_20

    .line 947
    new-instance v1, Landroid/renderscript/RSDriverException;

    const-string v2, "Failed to create RS context."

    invoke-direct {v1, v2}, Landroid/renderscript/RSDriverException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 949
    :cond_20
    new-instance v1, Landroid/renderscript/RenderScript$MessageThread;

    invoke-direct {v1, v0}, Landroid/renderscript/RenderScript$MessageThread;-><init>(Landroid/renderscript/RenderScript;)V

    iput-object v1, v0, Landroid/renderscript/RenderScript;->mMessageThread:Landroid/renderscript/RenderScript$MessageThread;

    .line 950
    iget-object v1, v0, Landroid/renderscript/RenderScript;->mMessageThread:Landroid/renderscript/RenderScript$MessageThread;

    invoke-virtual {v1}, Landroid/renderscript/RenderScript$MessageThread;->start()V

    .line 951
    return-object v0
.end method

.method public static setupDiskCache(Ljava/io/File;)V
    .registers 3
    .parameter "cacheDir"

    .prologue
    .line 100
    new-instance v0, Ljava/io/File;

    const-string v1, "com.android.renderscript.cache"

    invoke-direct {v0, p0, v1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 101
    .local v0, f:Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v1

    sput-object v1, Landroid/renderscript/RenderScript;->mCachePath:Ljava/lang/String;

    .line 102
    invoke-virtual {v0}, Ljava/io/File;->mkdirs()Z

    .line 103
    return-void
.end method


# virtual methods
.method public contextDump()V
    .registers 2

    .prologue
    .line 971
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 972
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Landroid/renderscript/RenderScript;->nContextDump(I)V

    .line 973
    return-void
.end method

.method public destroy()V
    .registers 3

    .prologue
    const/4 v1, 0x0

    .line 990
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 991
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0}, Landroid/renderscript/RenderScript;->nContextDeinitToClient(I)V

    .line 992
    iget-object v0, p0, Landroid/renderscript/RenderScript;->mMessageThread:Landroid/renderscript/RenderScript$MessageThread;

    iput-boolean v1, v0, Landroid/renderscript/RenderScript$MessageThread;->mRun:Z

    .line 994
    :try_start_d
    iget-object v0, p0, Landroid/renderscript/RenderScript;->mMessageThread:Landroid/renderscript/RenderScript$MessageThread;

    invoke-virtual {v0}, Landroid/renderscript/RenderScript$MessageThread;->join()V
    :try_end_12
    .catch Ljava/lang/InterruptedException; {:try_start_d .. :try_end_12} :catch_1f

    .line 998
    :goto_12
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->nContextDestroy()V

    .line 999
    iput v1, p0, Landroid/renderscript/RenderScript;->mContext:I

    .line 1001
    iget v0, p0, Landroid/renderscript/RenderScript;->mDev:I

    invoke-virtual {p0, v0}, Landroid/renderscript/RenderScript;->nDeviceDestroy(I)V

    .line 1002
    iput v1, p0, Landroid/renderscript/RenderScript;->mDev:I

    .line 1003
    return-void

    .line 995
    :catch_1f
    move-exception v0

    goto :goto_12
.end method

.method public finish()V
    .registers 1

    .prologue
    .line 981
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->nContextFinish()V

    .line 982
    return-void
.end method

.method public final getApplicationContext()Landroid/content/Context;
    .registers 2

    .prologue
    .line 931
    iget-object v0, p0, Landroid/renderscript/RenderScript;->mApplicationContext:Landroid/content/Context;

    return-object v0
.end method

.method public getErrorHandler()Landroid/renderscript/RenderScript$RSErrorHandler;
    .registers 2

    .prologue
    .line 802
    iget-object v0, p0, Landroid/renderscript/RenderScript;->mErrorCallback:Landroid/renderscript/RenderScript$RSErrorHandler;

    return-object v0
.end method

.method public getMessageHandler()Landroid/renderscript/RenderScript$RSMessageHandler;
    .registers 2

    .prologue
    .line 773
    iget-object v0, p0, Landroid/renderscript/RenderScript;->mMessageCallback:Landroid/renderscript/RenderScript$RSMessageHandler;

    return-object v0
.end method

.method isAlive()Z
    .registers 2

    .prologue
    .line 1006
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    if-eqz v0, :cond_6

    const/4 v0, 0x1

    :goto_5
    return v0

    :cond_6
    const/4 v0, 0x0

    goto :goto_5
.end method

.method declared-synchronized nAllocationCopyFromBitmap(ILandroid/graphics/Bitmap;)V
    .registers 4
    .parameter "alloc"
    .parameter "bmp"

    .prologue
    .line 326
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 327
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1, p2}, Landroid/renderscript/RenderScript;->rsnAllocationCopyFromBitmap(IILandroid/graphics/Bitmap;)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 328
    monitor-exit p0

    return-void

    .line 326
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nAllocationCopyToBitmap(ILandroid/graphics/Bitmap;)V
    .registers 4
    .parameter "alloc"
    .parameter "bmp"

    .prologue
    .line 282
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 283
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1, p2}, Landroid/renderscript/RenderScript;->rsnAllocationCopyToBitmap(IILandroid/graphics/Bitmap;)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 284
    monitor-exit p0

    return-void

    .line 282
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nAllocationCreateBitmapRef(ILandroid/graphics/Bitmap;)I
    .registers 4
    .parameter "type"
    .parameter "bmp"

    .prologue
    .line 271
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 272
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1, p2}, Landroid/renderscript/RenderScript;->rsnAllocationCreateBitmapRef(IILandroid/graphics/Bitmap;)I
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_c

    move-result v0

    monitor-exit p0

    return v0

    .line 271
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nAllocationCreateFromAssetStream(III)I
    .registers 5
    .parameter "mips"
    .parameter "assetStream"
    .parameter "usage"

    .prologue
    .line 276
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 277
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1, p2, p3}, Landroid/renderscript/RenderScript;->rsnAllocationCreateFromAssetStream(IIII)I
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_c

    move-result v0

    monitor-exit p0

    return v0

    .line 276
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nAllocationCreateFromBitmap(IILandroid/graphics/Bitmap;I)I
    .registers 11
    .parameter "type"
    .parameter "mip"
    .parameter "bmp"
    .parameter "usage"

    .prologue
    .line 261
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 262
    iget v1, p0, Landroid/renderscript/RenderScript;->mContext:I

    move-object v0, p0

    move v2, p1

    move v3, p2

    move-object v4, p3

    move v5, p4

    invoke-virtual/range {v0 .. v5}, Landroid/renderscript/RenderScript;->rsnAllocationCreateFromBitmap(IIILandroid/graphics/Bitmap;I)I
    :try_end_e
    .catchall {:try_start_1 .. :try_end_e} :catchall_11

    move-result v0

    monitor-exit p0

    return v0

    .line 261
    :catchall_11
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nAllocationCreateTyped(IIII)I
    .registers 11
    .parameter "type"
    .parameter "mip"
    .parameter "usage"
    .parameter "pointer"

    .prologue
    .line 256
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 257
    iget v1, p0, Landroid/renderscript/RenderScript;->mContext:I

    move-object v0, p0

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    invoke-virtual/range {v0 .. v5}, Landroid/renderscript/RenderScript;->rsnAllocationCreateTyped(IIIII)I
    :try_end_e
    .catchall {:try_start_1 .. :try_end_e} :catchall_11

    move-result v0

    monitor-exit p0

    return v0

    .line 256
    :catchall_11
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nAllocationCubeCreateFromBitmap(IILandroid/graphics/Bitmap;I)I
    .registers 11
    .parameter "type"
    .parameter "mip"
    .parameter "bmp"
    .parameter "usage"

    .prologue
    .line 266
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 267
    iget v1, p0, Landroid/renderscript/RenderScript;->mContext:I

    move-object v0, p0

    move v2, p1

    move v3, p2

    move-object v4, p3

    move v5, p4

    invoke-virtual/range {v0 .. v5}, Landroid/renderscript/RenderScript;->rsnAllocationCubeCreateFromBitmap(IIILandroid/graphics/Bitmap;I)I
    :try_end_e
    .catchall {:try_start_1 .. :try_end_e} :catchall_11

    move-result v0

    monitor-exit p0

    return v0

    .line 266
    :catchall_11
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nAllocationData1D(IIII[BI)V
    .registers 15
    .parameter "id"
    .parameter "off"
    .parameter "mip"
    .parameter "count"
    .parameter "d"
    .parameter "sizeBytes"

    .prologue
    .line 343
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 344
    iget v1, p0, Landroid/renderscript/RenderScript;->mContext:I

    move-object v0, p0

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    move-object v6, p5

    move v7, p6

    invoke-virtual/range {v0 .. v7}, Landroid/renderscript/RenderScript;->rsnAllocationData1D(IIIII[BI)V
    :try_end_10
    .catchall {:try_start_1 .. :try_end_10} :catchall_12

    .line 345
    monitor-exit p0

    return-void

    .line 343
    :catchall_12
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nAllocationData1D(IIII[FI)V
    .registers 15
    .parameter "id"
    .parameter "off"
    .parameter "mip"
    .parameter "count"
    .parameter "d"
    .parameter "sizeBytes"

    .prologue
    .line 348
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 349
    iget v1, p0, Landroid/renderscript/RenderScript;->mContext:I

    move-object v0, p0

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    move-object v6, p5

    move v7, p6

    invoke-virtual/range {v0 .. v7}, Landroid/renderscript/RenderScript;->rsnAllocationData1D(IIIII[FI)V
    :try_end_10
    .catchall {:try_start_1 .. :try_end_10} :catchall_12

    .line 350
    monitor-exit p0

    return-void

    .line 348
    :catchall_12
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nAllocationData1D(IIII[II)V
    .registers 15
    .parameter "id"
    .parameter "off"
    .parameter "mip"
    .parameter "count"
    .parameter "d"
    .parameter "sizeBytes"

    .prologue
    .line 333
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 334
    iget v1, p0, Landroid/renderscript/RenderScript;->mContext:I

    move-object v0, p0

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    move-object v6, p5

    move v7, p6

    invoke-virtual/range {v0 .. v7}, Landroid/renderscript/RenderScript;->rsnAllocationData1D(IIIII[II)V
    :try_end_10
    .catchall {:try_start_1 .. :try_end_10} :catchall_12

    .line 335
    monitor-exit p0

    return-void

    .line 333
    :catchall_12
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nAllocationData1D(IIII[SI)V
    .registers 15
    .parameter "id"
    .parameter "off"
    .parameter "mip"
    .parameter "count"
    .parameter "d"
    .parameter "sizeBytes"

    .prologue
    .line 338
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 339
    iget v1, p0, Landroid/renderscript/RenderScript;->mContext:I

    move-object v0, p0

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    move-object v6, p5

    move v7, p6

    invoke-virtual/range {v0 .. v7}, Landroid/renderscript/RenderScript;->rsnAllocationData1D(IIIII[SI)V
    :try_end_10
    .catchall {:try_start_1 .. :try_end_10} :catchall_12

    .line 340
    monitor-exit p0

    return-void

    .line 338
    :catchall_12
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nAllocationData2D(IIIIIIIIIIII)V
    .registers 27
    .parameter "dstAlloc"
    .parameter "dstXoff"
    .parameter "dstYoff"
    .parameter "dstMip"
    .parameter "dstFace"
    .parameter "width"
    .parameter "height"
    .parameter "srcAlloc"
    .parameter "srcXoff"
    .parameter "srcYoff"
    .parameter "srcMip"
    .parameter "srcFace"

    .prologue
    .line 369
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 370
    iget v1, p0, Landroid/renderscript/RenderScript;->mContext:I

    move-object v0, p0

    move v2, p1

    move/from16 v3, p2

    move/from16 v4, p3

    move/from16 v5, p4

    move/from16 v6, p5

    move/from16 v7, p6

    move/from16 v8, p7

    move/from16 v9, p8

    move/from16 v10, p9

    move/from16 v11, p10

    move/from16 v12, p11

    move/from16 v13, p12

    invoke-virtual/range {v0 .. v13}, Landroid/renderscript/RenderScript;->rsnAllocationData2D(IIIIIIIIIIIII)V
    :try_end_21
    .catchall {:try_start_1 .. :try_end_21} :catchall_23

    .line 376
    monitor-exit p0

    return-void

    .line 369
    :catchall_23
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nAllocationData2D(IIIIIII[BI)V
    .registers 21
    .parameter "id"
    .parameter "xoff"
    .parameter "yoff"
    .parameter "mip"
    .parameter "face"
    .parameter "w"
    .parameter "h"
    .parameter "d"
    .parameter "sizeBytes"

    .prologue
    .line 380
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 381
    iget v1, p0, Landroid/renderscript/RenderScript;->mContext:I

    move-object v0, p0

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    move/from16 v6, p5

    move/from16 v7, p6

    move/from16 v8, p7

    move-object/from16 v9, p8

    move/from16 v10, p9

    invoke-virtual/range {v0 .. v10}, Landroid/renderscript/RenderScript;->rsnAllocationData2D(IIIIIIII[BI)V
    :try_end_18
    .catchall {:try_start_1 .. :try_end_18} :catchall_1a

    .line 382
    monitor-exit p0

    return-void

    .line 380
    :catchall_1a
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nAllocationData2D(IIIIIII[FI)V
    .registers 21
    .parameter "id"
    .parameter "xoff"
    .parameter "yoff"
    .parameter "mip"
    .parameter "face"
    .parameter "w"
    .parameter "h"
    .parameter "d"
    .parameter "sizeBytes"

    .prologue
    .line 395
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 396
    iget v1, p0, Landroid/renderscript/RenderScript;->mContext:I

    move-object v0, p0

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    move/from16 v6, p5

    move/from16 v7, p6

    move/from16 v8, p7

    move-object/from16 v9, p8

    move/from16 v10, p9

    invoke-virtual/range {v0 .. v10}, Landroid/renderscript/RenderScript;->rsnAllocationData2D(IIIIIIII[FI)V
    :try_end_18
    .catchall {:try_start_1 .. :try_end_18} :catchall_1a

    .line 397
    monitor-exit p0

    return-void

    .line 395
    :catchall_1a
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nAllocationData2D(IIIIIII[II)V
    .registers 21
    .parameter "id"
    .parameter "xoff"
    .parameter "yoff"
    .parameter "mip"
    .parameter "face"
    .parameter "w"
    .parameter "h"
    .parameter "d"
    .parameter "sizeBytes"

    .prologue
    .line 390
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 391
    iget v1, p0, Landroid/renderscript/RenderScript;->mContext:I

    move-object v0, p0

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    move/from16 v6, p5

    move/from16 v7, p6

    move/from16 v8, p7

    move-object/from16 v9, p8

    move/from16 v10, p9

    invoke-virtual/range {v0 .. v10}, Landroid/renderscript/RenderScript;->rsnAllocationData2D(IIIIIIII[II)V
    :try_end_18
    .catchall {:try_start_1 .. :try_end_18} :catchall_1a

    .line 392
    monitor-exit p0

    return-void

    .line 390
    :catchall_1a
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nAllocationData2D(IIIIIII[SI)V
    .registers 21
    .parameter "id"
    .parameter "xoff"
    .parameter "yoff"
    .parameter "mip"
    .parameter "face"
    .parameter "w"
    .parameter "h"
    .parameter "d"
    .parameter "sizeBytes"

    .prologue
    .line 385
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 386
    iget v1, p0, Landroid/renderscript/RenderScript;->mContext:I

    move-object v0, p0

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    move/from16 v6, p5

    move/from16 v7, p6

    move/from16 v8, p7

    move-object/from16 v9, p8

    move/from16 v10, p9

    invoke-virtual/range {v0 .. v10}, Landroid/renderscript/RenderScript;->rsnAllocationData2D(IIIIIIII[SI)V
    :try_end_18
    .catchall {:try_start_1 .. :try_end_18} :catchall_1a

    .line 387
    monitor-exit p0

    return-void

    .line 385
    :catchall_1a
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nAllocationData2D(IIIIILandroid/graphics/Bitmap;)V
    .registers 15
    .parameter "id"
    .parameter "xoff"
    .parameter "yoff"
    .parameter "mip"
    .parameter "face"
    .parameter "b"

    .prologue
    .line 400
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 401
    iget v1, p0, Landroid/renderscript/RenderScript;->mContext:I

    move-object v0, p0

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    move v6, p5

    move-object v7, p6

    invoke-virtual/range {v0 .. v7}, Landroid/renderscript/RenderScript;->rsnAllocationData2D(IIIIIILandroid/graphics/Bitmap;)V
    :try_end_10
    .catchall {:try_start_1 .. :try_end_10} :catchall_12

    .line 402
    monitor-exit p0

    return-void

    .line 400
    :catchall_12
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nAllocationElementData1D(IIII[BI)V
    .registers 15
    .parameter "id"
    .parameter "xoff"
    .parameter "mip"
    .parameter "compIdx"
    .parameter "d"
    .parameter "sizeBytes"

    .prologue
    .line 354
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 355
    iget v1, p0, Landroid/renderscript/RenderScript;->mContext:I

    move-object v0, p0

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    move-object v6, p5

    move v7, p6

    invoke-virtual/range {v0 .. v7}, Landroid/renderscript/RenderScript;->rsnAllocationElementData1D(IIIII[BI)V
    :try_end_10
    .catchall {:try_start_1 .. :try_end_10} :catchall_12

    .line 356
    monitor-exit p0

    return-void

    .line 354
    :catchall_12
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nAllocationGenerateMipmaps(I)V
    .registers 3
    .parameter "alloc"

    .prologue
    .line 321
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 322
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1}, Landroid/renderscript/RenderScript;->rsnAllocationGenerateMipmaps(II)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 323
    monitor-exit p0

    return-void

    .line 321
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nAllocationGetSurfaceTextureID(I)I
    .registers 3
    .parameter "alloc"

    .prologue
    .line 294
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 295
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1}, Landroid/renderscript/RenderScript;->rsnAllocationGetSurfaceTextureID(II)I
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_c

    move-result v0

    monitor-exit p0

    return v0

    .line 294
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nAllocationGetSurfaceTextureID2(ILandroid/graphics/SurfaceTexture;)V
    .registers 4
    .parameter "alloc"
    .parameter "st"

    .prologue
    .line 299
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 300
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1, p2}, Landroid/renderscript/RenderScript;->rsnAllocationGetSurfaceTextureID2(IILandroid/graphics/SurfaceTexture;)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 301
    monitor-exit p0

    return-void

    .line 299
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nAllocationGetType(I)I
    .registers 3
    .parameter "id"

    .prologue
    .line 426
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 427
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1}, Landroid/renderscript/RenderScript;->rsnAllocationGetType(II)I
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_c

    move-result v0

    monitor-exit p0

    return v0

    .line 426
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nAllocationIoReceive(I)V
    .registers 3
    .parameter "alloc"

    .prologue
    .line 314
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 315
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1}, Landroid/renderscript/RenderScript;->rsnAllocationIoReceive(II)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 316
    monitor-exit p0

    return-void

    .line 314
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nAllocationIoSend(I)V
    .registers 3
    .parameter "alloc"

    .prologue
    .line 309
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 310
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1}, Landroid/renderscript/RenderScript;->rsnAllocationIoSend(II)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 311
    monitor-exit p0

    return-void

    .line 309
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nAllocationRead(I[B)V
    .registers 4
    .parameter "id"
    .parameter "d"

    .prologue
    .line 406
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 407
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1, p2}, Landroid/renderscript/RenderScript;->rsnAllocationRead(II[B)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 408
    monitor-exit p0

    return-void

    .line 406
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nAllocationRead(I[F)V
    .registers 4
    .parameter "id"
    .parameter "d"

    .prologue
    .line 421
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 422
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1, p2}, Landroid/renderscript/RenderScript;->rsnAllocationRead(II[F)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 423
    monitor-exit p0

    return-void

    .line 421
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nAllocationRead(I[I)V
    .registers 4
    .parameter "id"
    .parameter "d"

    .prologue
    .line 416
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 417
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1, p2}, Landroid/renderscript/RenderScript;->rsnAllocationRead(II[I)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 418
    monitor-exit p0

    return-void

    .line 416
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nAllocationRead(I[S)V
    .registers 4
    .parameter "id"
    .parameter "d"

    .prologue
    .line 411
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 412
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1, p2}, Landroid/renderscript/RenderScript;->rsnAllocationRead(II[S)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 413
    monitor-exit p0

    return-void

    .line 411
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nAllocationResize1D(II)V
    .registers 4
    .parameter "id"
    .parameter "dimX"

    .prologue
    .line 432
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 433
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1, p2}, Landroid/renderscript/RenderScript;->rsnAllocationResize1D(III)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 434
    monitor-exit p0

    return-void

    .line 432
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nAllocationResize2D(III)V
    .registers 5
    .parameter "id"
    .parameter "dimX"
    .parameter "dimY"

    .prologue
    .line 437
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 438
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1, p2, p3}, Landroid/renderscript/RenderScript;->rsnAllocationResize2D(IIII)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 439
    monitor-exit p0

    return-void

    .line 437
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nAllocationSetSurface(ILandroid/view/Surface;)V
    .registers 4
    .parameter "alloc"
    .parameter "sur"

    .prologue
    .line 304
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 305
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1, p2}, Landroid/renderscript/RenderScript;->rsnAllocationSetSurface(IILandroid/view/Surface;)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 306
    monitor-exit p0

    return-void

    .line 304
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nAllocationSyncAll(II)V
    .registers 4
    .parameter "alloc"
    .parameter "src"

    .prologue
    .line 289
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 290
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1, p2}, Landroid/renderscript/RenderScript;->rsnAllocationSyncAll(III)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 291
    monitor-exit p0

    return-void

    .line 289
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nAssignName(I[B)V
    .registers 4
    .parameter "obj"
    .parameter "name"

    .prologue
    .line 203
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 204
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1, p2}, Landroid/renderscript/RenderScript;->rsnAssignName(II[B)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 205
    monitor-exit p0

    return-void

    .line 203
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nContextBindProgramFragment(I)V
    .registers 3
    .parameter "pf"

    .prologue
    .line 177
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 178
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1}, Landroid/renderscript/RenderScript;->rsnContextBindProgramFragment(II)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 179
    monitor-exit p0

    return-void

    .line 177
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nContextBindProgramRaster(I)V
    .registers 3
    .parameter "pr"

    .prologue
    .line 187
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 188
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1}, Landroid/renderscript/RenderScript;->rsnContextBindProgramRaster(II)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 189
    monitor-exit p0

    return-void

    .line 187
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nContextBindProgramStore(I)V
    .registers 3
    .parameter "pfs"

    .prologue
    .line 172
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 173
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1}, Landroid/renderscript/RenderScript;->rsnContextBindProgramStore(II)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 174
    monitor-exit p0

    return-void

    .line 172
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nContextBindProgramVertex(I)V
    .registers 3
    .parameter "pv"

    .prologue
    .line 182
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 183
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1}, Landroid/renderscript/RenderScript;->rsnContextBindProgramVertex(II)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 184
    monitor-exit p0

    return-void

    .line 182
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nContextBindRootScript(I)V
    .registers 3
    .parameter "script"

    .prologue
    .line 162
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 163
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1}, Landroid/renderscript/RenderScript;->rsnContextBindRootScript(II)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 164
    monitor-exit p0

    return-void

    .line 162
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nContextBindSampler(II)V
    .registers 4
    .parameter "sampler"
    .parameter "slot"

    .prologue
    .line 167
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 168
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1, p2}, Landroid/renderscript/RenderScript;->rsnContextBindSampler(III)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 169
    monitor-exit p0

    return-void

    .line 167
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nContextCreate(III)I
    .registers 5
    .parameter "dev"
    .parameter "ver"
    .parameter "sdkVer"

    .prologue
    .line 127
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0, p1, p2, p3}, Landroid/renderscript/RenderScript;->rsnContextCreate(III)I
    :try_end_4
    .catchall {:try_start_1 .. :try_end_4} :catchall_7

    move-result v0

    monitor-exit p0

    return v0

    :catchall_7
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nContextCreateGL(IIIIIIIIIIIIIFI)I
    .registers 17
    .parameter "dev"
    .parameter "ver"
    .parameter "sdkVer"
    .parameter "colorMin"
    .parameter "colorPref"
    .parameter "alphaMin"
    .parameter "alphaPref"
    .parameter "depthMin"
    .parameter "depthPref"
    .parameter "stencilMin"
    .parameter "stencilPref"
    .parameter "samplesMin"
    .parameter "samplesPref"
    .parameter "samplesQ"
    .parameter "dpi"

    .prologue
    .line 120
    monitor-enter p0

    :try_start_1
    invoke-virtual/range {p0 .. p15}, Landroid/renderscript/RenderScript;->rsnContextCreateGL(IIIIIIIIIIIIIFI)I
    :try_end_4
    .catchall {:try_start_1 .. :try_end_4} :catchall_7

    move-result v0

    monitor-exit p0

    return v0

    :catchall_7
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method native nContextDeinitToClient(I)V
.end method

.method declared-synchronized nContextDestroy()V
    .registers 2

    .prologue
    .line 131
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 132
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0}, Landroid/renderscript/RenderScript;->rsnContextDestroy(I)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 133
    monitor-exit p0

    return-void

    .line 131
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nContextDump(I)V
    .registers 3
    .parameter "bits"

    .prologue
    .line 151
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 152
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1}, Landroid/renderscript/RenderScript;->rsnContextDump(II)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 153
    monitor-exit p0

    return-void

    .line 151
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nContextFinish()V
    .registers 2

    .prologue
    .line 156
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 157
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0}, Landroid/renderscript/RenderScript;->rsnContextFinish(I)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 158
    monitor-exit p0

    return-void

    .line 156
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method native nContextGetErrorMessage(I)Ljava/lang/String;
.end method

.method native nContextGetUserMessage(I[I)I
.end method

.method native nContextInitToClient(I)V
.end method

.method declared-synchronized nContextPause()V
    .registers 2

    .prologue
    .line 192
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 193
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0}, Landroid/renderscript/RenderScript;->rsnContextPause(I)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 194
    monitor-exit p0

    return-void

    .line 192
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method native nContextPeekMessage(I[I)I
.end method

.method declared-synchronized nContextResume()V
    .registers 2

    .prologue
    .line 197
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 198
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0}, Landroid/renderscript/RenderScript;->rsnContextResume(I)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 199
    monitor-exit p0

    return-void

    .line 197
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nContextSetPriority(I)V
    .registers 3
    .parameter "p"

    .prologue
    .line 146
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 147
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1}, Landroid/renderscript/RenderScript;->rsnContextSetPriority(II)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 148
    monitor-exit p0

    return-void

    .line 146
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nContextSetSurface(IILandroid/view/Surface;)V
    .registers 5
    .parameter "w"
    .parameter "h"
    .parameter "sur"

    .prologue
    .line 136
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 137
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1, p2, p3}, Landroid/renderscript/RenderScript;->rsnContextSetSurface(IIILandroid/view/Surface;)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 138
    monitor-exit p0

    return-void

    .line 136
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nContextSetSurfaceTexture(IILandroid/graphics/SurfaceTexture;)V
    .registers 5
    .parameter "w"
    .parameter "h"
    .parameter "sur"

    .prologue
    .line 141
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 142
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1, p2, p3}, Landroid/renderscript/RenderScript;->rsnContextSetSurfaceTexture(IIILandroid/graphics/SurfaceTexture;)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 143
    monitor-exit p0

    return-void

    .line 141
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method native nDeviceCreate()I
.end method

.method native nDeviceDestroy(I)V
.end method

.method native nDeviceSetConfig(III)V
.end method

.method declared-synchronized nElementCreate(IIZI)I
    .registers 11
    .parameter "type"
    .parameter "kind"
    .parameter "norm"
    .parameter "vecSize"

    .prologue
    .line 223
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 224
    iget v1, p0, Landroid/renderscript/RenderScript;->mContext:I

    move-object v0, p0

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    invoke-virtual/range {v0 .. v5}, Landroid/renderscript/RenderScript;->rsnElementCreate(IIIZI)I
    :try_end_e
    .catchall {:try_start_1 .. :try_end_e} :catchall_11

    move-result v0

    monitor-exit p0

    return v0

    .line 223
    :catchall_11
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nElementCreate2([I[Ljava/lang/String;[I)I
    .registers 5
    .parameter "elements"
    .parameter "names"
    .parameter "arraySizes"

    .prologue
    .line 228
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 229
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1, p2, p3}, Landroid/renderscript/RenderScript;->rsnElementCreate2(I[I[Ljava/lang/String;[I)I
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_c

    move-result v0

    monitor-exit p0

    return v0

    .line 228
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nElementGetNativeData(I[I)V
    .registers 4
    .parameter "id"
    .parameter "elementData"

    .prologue
    .line 233
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 234
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1, p2}, Landroid/renderscript/RenderScript;->rsnElementGetNativeData(II[I)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 235
    monitor-exit p0

    return-void

    .line 233
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nElementGetSubElements(I[I[Ljava/lang/String;[I)V
    .registers 11
    .parameter "id"
    .parameter "IDs"
    .parameter "names"
    .parameter "arraySizes"

    .prologue
    .line 239
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 240
    iget v1, p0, Landroid/renderscript/RenderScript;->mContext:I

    move-object v0, p0

    move v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-virtual/range {v0 .. v5}, Landroid/renderscript/RenderScript;->rsnElementGetSubElements(II[I[Ljava/lang/String;[I)V
    :try_end_e
    .catchall {:try_start_1 .. :try_end_e} :catchall_10

    .line 241
    monitor-exit p0

    return-void

    .line 239
    :catchall_10
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nFileA3DCreateFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)I
    .registers 4
    .parameter "mgr"
    .parameter "path"

    .prologue
    .line 453
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 454
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1, p2}, Landroid/renderscript/RenderScript;->rsnFileA3DCreateFromAsset(ILandroid/content/res/AssetManager;Ljava/lang/String;)I
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_c

    move-result v0

    monitor-exit p0

    return v0

    .line 453
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nFileA3DCreateFromAssetStream(I)I
    .registers 3
    .parameter "assetStream"

    .prologue
    .line 443
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 444
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1}, Landroid/renderscript/RenderScript;->rsnFileA3DCreateFromAssetStream(II)I
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_c

    move-result v0

    monitor-exit p0

    return v0

    .line 443
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nFileA3DCreateFromFile(Ljava/lang/String;)I
    .registers 3
    .parameter "path"

    .prologue
    .line 448
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 449
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1}, Landroid/renderscript/RenderScript;->rsnFileA3DCreateFromFile(ILjava/lang/String;)I
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_c

    move-result v0

    monitor-exit p0

    return v0

    .line 448
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nFileA3DGetEntryByIndex(II)I
    .registers 4
    .parameter "fileA3D"
    .parameter "index"

    .prologue
    .line 468
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 469
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1, p2}, Landroid/renderscript/RenderScript;->rsnFileA3DGetEntryByIndex(III)I
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_c

    move-result v0

    monitor-exit p0

    return v0

    .line 468
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nFileA3DGetIndexEntries(II[I[Ljava/lang/String;)V
    .registers 11
    .parameter "fileA3D"
    .parameter "numEntries"
    .parameter "IDs"
    .parameter "names"

    .prologue
    .line 463
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 464
    iget v1, p0, Landroid/renderscript/RenderScript;->mContext:I

    move-object v0, p0

    move v2, p1

    move v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-virtual/range {v0 .. v5}, Landroid/renderscript/RenderScript;->rsnFileA3DGetIndexEntries(III[I[Ljava/lang/String;)V
    :try_end_e
    .catchall {:try_start_1 .. :try_end_e} :catchall_10

    .line 465
    monitor-exit p0

    return-void

    .line 463
    :catchall_10
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nFileA3DGetNumIndexEntries(I)I
    .registers 3
    .parameter "fileA3D"

    .prologue
    .line 458
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 459
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1}, Landroid/renderscript/RenderScript;->rsnFileA3DGetNumIndexEntries(II)I
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_c

    move-result v0

    monitor-exit p0

    return v0

    .line 458
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nFontCreateFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;FI)I
    .registers 11
    .parameter "mgr"
    .parameter "path"
    .parameter "size"
    .parameter "dpi"

    .prologue
    .line 484
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 485
    iget v1, p0, Landroid/renderscript/RenderScript;->mContext:I

    move-object v0, p0

    move-object v2, p1

    move-object v3, p2

    move v4, p3

    move v5, p4

    invoke-virtual/range {v0 .. v5}, Landroid/renderscript/RenderScript;->rsnFontCreateFromAsset(ILandroid/content/res/AssetManager;Ljava/lang/String;FI)I
    :try_end_e
    .catchall {:try_start_1 .. :try_end_e} :catchall_11

    move-result v0

    monitor-exit p0

    return v0

    .line 484
    :catchall_11
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nFontCreateFromAssetStream(Ljava/lang/String;FII)I
    .registers 11
    .parameter "name"
    .parameter "size"
    .parameter "dpi"
    .parameter "assetStream"

    .prologue
    .line 479
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 480
    iget v1, p0, Landroid/renderscript/RenderScript;->mContext:I

    move-object v0, p0

    move-object v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    invoke-virtual/range {v0 .. v5}, Landroid/renderscript/RenderScript;->rsnFontCreateFromAssetStream(ILjava/lang/String;FII)I
    :try_end_e
    .catchall {:try_start_1 .. :try_end_e} :catchall_11

    move-result v0

    monitor-exit p0

    return v0

    .line 479
    :catchall_11
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nFontCreateFromFile(Ljava/lang/String;FI)I
    .registers 5
    .parameter "fileName"
    .parameter "size"
    .parameter "dpi"

    .prologue
    .line 474
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 475
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1, p2, p3}, Landroid/renderscript/RenderScript;->rsnFontCreateFromFile(ILjava/lang/String;FI)I
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_c

    move-result v0

    monitor-exit p0

    return v0

    .line 474
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nGetName(I)Ljava/lang/String;
    .registers 3
    .parameter "obj"

    .prologue
    .line 208
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 209
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1}, Landroid/renderscript/RenderScript;->rsnGetName(II)Ljava/lang/String;
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_c

    move-result-object v0

    monitor-exit p0

    return-object v0

    .line 208
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nMeshCreate([I[I[I)I
    .registers 5
    .parameter "vtx"
    .parameter "idx"
    .parameter "prim"

    .prologue
    .line 617
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 618
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1, p2, p3}, Landroid/renderscript/RenderScript;->rsnMeshCreate(I[I[I[I)I
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_c

    move-result v0

    monitor-exit p0

    return v0

    .line 617
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nMeshGetIndexCount(I)I
    .registers 3
    .parameter "id"

    .prologue
    .line 627
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 628
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1}, Landroid/renderscript/RenderScript;->rsnMeshGetIndexCount(II)I
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_c

    move-result v0

    monitor-exit p0

    return v0

    .line 627
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nMeshGetIndices(I[I[II)V
    .registers 11
    .parameter "id"
    .parameter "idxIds"
    .parameter "primitives"
    .parameter "vtxIdCount"

    .prologue
    .line 637
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 638
    iget v1, p0, Landroid/renderscript/RenderScript;->mContext:I

    move-object v0, p0

    move v2, p1

    move-object v3, p2

    move-object v4, p3

    move v5, p4

    invoke-virtual/range {v0 .. v5}, Landroid/renderscript/RenderScript;->rsnMeshGetIndices(II[I[II)V
    :try_end_e
    .catchall {:try_start_1 .. :try_end_e} :catchall_10

    .line 639
    monitor-exit p0

    return-void

    .line 637
    :catchall_10
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nMeshGetVertexBufferCount(I)I
    .registers 3
    .parameter "id"

    .prologue
    .line 622
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 623
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1}, Landroid/renderscript/RenderScript;->rsnMeshGetVertexBufferCount(II)I
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_c

    move-result v0

    monitor-exit p0

    return v0

    .line 622
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nMeshGetVertices(I[II)V
    .registers 5
    .parameter "id"
    .parameter "vtxIds"
    .parameter "vtxIdCount"

    .prologue
    .line 632
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 633
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1, p2, p3}, Landroid/renderscript/RenderScript;->rsnMeshGetVertices(II[II)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 634
    monitor-exit p0

    return-void

    .line 632
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nObjDestroy(I)V
    .registers 3
    .parameter "id"

    .prologue
    .line 216
    monitor-enter p0

    :try_start_1
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    if-eqz v0, :cond_a

    .line 217
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1}, Landroid/renderscript/RenderScript;->rsnObjDestroy(II)V
    :try_end_a
    .catchall {:try_start_1 .. :try_end_a} :catchall_c

    .line 219
    :cond_a
    monitor-exit p0

    return-void

    .line 216
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nPathCreate(IZIIF)I
    .registers 13
    .parameter "prim"
    .parameter "isStatic"
    .parameter "vtx"
    .parameter "loop"
    .parameter "q"

    .prologue
    .line 643
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 644
    iget v1, p0, Landroid/renderscript/RenderScript;->mContext:I

    move-object v0, p0

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    move v6, p5

    invoke-virtual/range {v0 .. v6}, Landroid/renderscript/RenderScript;->rsnPathCreate(IIZIIF)I
    :try_end_f
    .catchall {:try_start_1 .. :try_end_f} :catchall_12

    move-result v0

    monitor-exit p0

    return v0

    .line 643
    :catchall_12
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nProgramBindConstants(III)V
    .registers 5
    .parameter "pv"
    .parameter "slot"
    .parameter "mID"

    .prologue
    .line 591
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 592
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1, p2, p3}, Landroid/renderscript/RenderScript;->rsnProgramBindConstants(IIII)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 593
    monitor-exit p0

    return-void

    .line 591
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nProgramBindSampler(III)V
    .registers 5
    .parameter "vpf"
    .parameter "slot"
    .parameter "s"

    .prologue
    .line 601
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 602
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1, p2, p3}, Landroid/renderscript/RenderScript;->rsnProgramBindSampler(IIII)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 603
    monitor-exit p0

    return-void

    .line 601
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nProgramBindTexture(III)V
    .registers 5
    .parameter "vpf"
    .parameter "slot"
    .parameter "a"

    .prologue
    .line 596
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 597
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1, p2, p3}, Landroid/renderscript/RenderScript;->rsnProgramBindTexture(IIII)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 598
    monitor-exit p0

    return-void

    .line 596
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nProgramFragmentCreate(Ljava/lang/String;[Ljava/lang/String;[I)I
    .registers 5
    .parameter "shader"
    .parameter "texNames"
    .parameter "params"

    .prologue
    .line 606
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 607
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1, p2, p3}, Landroid/renderscript/RenderScript;->rsnProgramFragmentCreate(ILjava/lang/String;[Ljava/lang/String;[I)I
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_c

    move-result v0

    monitor-exit p0

    return v0

    .line 606
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nProgramRasterCreate(ZI)I
    .registers 4
    .parameter "pointSprite"
    .parameter "cullMode"

    .prologue
    .line 585
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 586
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1, p2}, Landroid/renderscript/RenderScript;->rsnProgramRasterCreate(IZI)I
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_c

    move-result v0

    monitor-exit p0

    return v0

    .line 585
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nProgramStoreCreate(ZZZZZZIII)I
    .registers 21
    .parameter "r"
    .parameter "g"
    .parameter "b"
    .parameter "a"
    .parameter "depthMask"
    .parameter "dither"
    .parameter "srcMode"
    .parameter "dstMode"
    .parameter "depthFunc"

    .prologue
    .line 578
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 579
    iget v1, p0, Landroid/renderscript/RenderScript;->mContext:I

    move-object v0, p0

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    move/from16 v6, p5

    move/from16 v7, p6

    move/from16 v8, p7

    move/from16 v9, p8

    move/from16 v10, p9

    invoke-virtual/range {v0 .. v10}, Landroid/renderscript/RenderScript;->rsnProgramStoreCreate(IZZZZZZIII)I
    :try_end_18
    .catchall {:try_start_1 .. :try_end_18} :catchall_1b

    move-result v0

    monitor-exit p0

    return v0

    .line 578
    :catchall_1b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nProgramVertexCreate(Ljava/lang/String;[Ljava/lang/String;[I)I
    .registers 5
    .parameter "shader"
    .parameter "texNames"
    .parameter "params"

    .prologue
    .line 611
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 612
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1, p2, p3}, Landroid/renderscript/RenderScript;->rsnProgramVertexCreate(ILjava/lang/String;[Ljava/lang/String;[I)I
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_c

    move-result v0

    monitor-exit p0

    return v0

    .line 611
    :catchall_c
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nSamplerCreate(IIIIIF)I
    .registers 15
    .parameter "magFilter"
    .parameter "minFilter"
    .parameter "wrapS"
    .parameter "wrapT"
    .parameter "wrapR"
    .parameter "aniso"

    .prologue
    .line 568
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 569
    iget v1, p0, Landroid/renderscript/RenderScript;->mContext:I

    move-object v0, p0

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    move v6, p5

    move v7, p6

    invoke-virtual/range {v0 .. v7}, Landroid/renderscript/RenderScript;->rsnSamplerCreate(IIIIIIF)I
    :try_end_10
    .catchall {:try_start_1 .. :try_end_10} :catchall_13

    move-result v0

    monitor-exit p0

    return v0

    .line 568
    :catchall_13
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nScriptBindAllocation(III)V
    .registers 5
    .parameter "script"
    .parameter "alloc"
    .parameter "slot"

    .prologue
    .line 491
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 492
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1, p2, p3}, Landroid/renderscript/RenderScript;->rsnScriptBindAllocation(IIII)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 493
    monitor-exit p0

    return-void

    .line 491
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nScriptCCreate(Ljava/lang/String;Ljava/lang/String;[BI)I
    .registers 11
    .parameter "resName"
    .parameter "cacheDir"
    .parameter "script"
    .parameter "length"

    .prologue
    .line 560
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 561
    iget v1, p0, Landroid/renderscript/RenderScript;->mContext:I

    move-object v0, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move v5, p4

    invoke-virtual/range {v0 .. v5}, Landroid/renderscript/RenderScript;->rsnScriptCCreate(ILjava/lang/String;Ljava/lang/String;[BI)I
    :try_end_e
    .catchall {:try_start_1 .. :try_end_e} :catchall_11

    move-result v0

    monitor-exit p0

    return v0

    .line 560
    :catchall_11
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nScriptForEach(IIII[B)V
    .registers 13
    .parameter "id"
    .parameter "slot"
    .parameter "ain"
    .parameter "aout"
    .parameter "params"

    .prologue
    .line 507
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 508
    if-nez p5, :cond_12

    .line 509
    iget v1, p0, Landroid/renderscript/RenderScript;->mContext:I

    move-object v0, p0

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    invoke-virtual/range {v0 .. v5}, Landroid/renderscript/RenderScript;->rsnScriptForEach(IIIII)V
    :try_end_10
    .catchall {:try_start_1 .. :try_end_10} :catchall_1e

    .line 513
    :goto_10
    monitor-exit p0

    return-void

    .line 511
    :cond_12
    :try_start_12
    iget v1, p0, Landroid/renderscript/RenderScript;->mContext:I

    move-object v0, p0

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    move-object v6, p5

    invoke-virtual/range {v0 .. v6}, Landroid/renderscript/RenderScript;->rsnScriptForEach(IIIII[B)V
    :try_end_1d
    .catchall {:try_start_12 .. :try_end_1d} :catchall_1e

    goto :goto_10

    .line 507
    :catchall_1e
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nScriptInvoke(II)V
    .registers 4
    .parameter "id"
    .parameter "slot"

    .prologue
    .line 501
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 502
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1, p2}, Landroid/renderscript/RenderScript;->rsnScriptInvoke(III)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 503
    monitor-exit p0

    return-void

    .line 501
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nScriptInvokeV(II[B)V
    .registers 5
    .parameter "id"
    .parameter "slot"
    .parameter "params"

    .prologue
    .line 516
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 517
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1, p2, p3}, Landroid/renderscript/RenderScript;->rsnScriptInvokeV(III[B)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 518
    monitor-exit p0

    return-void

    .line 516
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nScriptSetTimeZone(I[B)V
    .registers 4
    .parameter "script"
    .parameter "timeZone"

    .prologue
    .line 496
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 497
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1, p2}, Landroid/renderscript/RenderScript;->rsnScriptSetTimeZone(II[B)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 498
    monitor-exit p0

    return-void

    .line 496
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nScriptSetVarD(IID)V
    .registers 11
    .parameter "id"
    .parameter "slot"
    .parameter "val"

    .prologue
    .line 536
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 537
    iget v1, p0, Landroid/renderscript/RenderScript;->mContext:I

    move-object v0, p0

    move v2, p1

    move v3, p2

    move-wide v4, p3

    invoke-virtual/range {v0 .. v5}, Landroid/renderscript/RenderScript;->rsnScriptSetVarD(IIID)V
    :try_end_d
    .catchall {:try_start_1 .. :try_end_d} :catchall_f

    .line 538
    monitor-exit p0

    return-void

    .line 536
    :catchall_f
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nScriptSetVarF(IIF)V
    .registers 5
    .parameter "id"
    .parameter "slot"
    .parameter "val"

    .prologue
    .line 531
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 532
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1, p2, p3}, Landroid/renderscript/RenderScript;->rsnScriptSetVarF(IIIF)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 533
    monitor-exit p0

    return-void

    .line 531
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nScriptSetVarI(III)V
    .registers 5
    .parameter "id"
    .parameter "slot"
    .parameter "val"

    .prologue
    .line 521
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 522
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1, p2, p3}, Landroid/renderscript/RenderScript;->rsnScriptSetVarI(IIII)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 523
    monitor-exit p0

    return-void

    .line 521
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nScriptSetVarJ(IIJ)V
    .registers 11
    .parameter "id"
    .parameter "slot"
    .parameter "val"

    .prologue
    .line 526
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 527
    iget v1, p0, Landroid/renderscript/RenderScript;->mContext:I

    move-object v0, p0

    move v2, p1

    move v3, p2

    move-wide v4, p3

    invoke-virtual/range {v0 .. v5}, Landroid/renderscript/RenderScript;->rsnScriptSetVarJ(IIIJ)V
    :try_end_d
    .catchall {:try_start_1 .. :try_end_d} :catchall_f

    .line 528
    monitor-exit p0

    return-void

    .line 526
    :catchall_f
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nScriptSetVarObj(III)V
    .registers 5
    .parameter "id"
    .parameter "slot"
    .parameter "val"

    .prologue
    .line 553
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 554
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1, p2, p3}, Landroid/renderscript/RenderScript;->rsnScriptSetVarObj(IIII)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 555
    monitor-exit p0

    return-void

    .line 553
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nScriptSetVarV(II[B)V
    .registers 5
    .parameter "id"
    .parameter "slot"
    .parameter "val"

    .prologue
    .line 541
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 542
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1, p2, p3}, Landroid/renderscript/RenderScript;->rsnScriptSetVarV(III[B)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 543
    monitor-exit p0

    return-void

    .line 541
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nScriptSetVarVE(II[BI[I)V
    .registers 13
    .parameter "id"
    .parameter "slot"
    .parameter "val"
    .parameter "e"
    .parameter "dims"

    .prologue
    .line 548
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 549
    iget v1, p0, Landroid/renderscript/RenderScript;->mContext:I

    move-object v0, p0

    move v2, p1

    move v3, p2

    move-object v4, p3

    move v5, p4

    move-object v6, p5

    invoke-virtual/range {v0 .. v6}, Landroid/renderscript/RenderScript;->rsnScriptSetVarVE(III[BI[I)V
    :try_end_f
    .catchall {:try_start_1 .. :try_end_f} :catchall_11

    .line 550
    monitor-exit p0

    return-void

    .line 548
    :catchall_11
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nTypeCreate(IIIIZZ)I
    .registers 15
    .parameter "eid"
    .parameter "x"
    .parameter "y"
    .parameter "z"
    .parameter "mips"
    .parameter "faces"

    .prologue
    .line 245
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 246
    iget v1, p0, Landroid/renderscript/RenderScript;->mContext:I

    move-object v0, p0

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    move v6, p5

    move v7, p6

    invoke-virtual/range {v0 .. v7}, Landroid/renderscript/RenderScript;->rsnTypeCreate(IIIIIZZ)I
    :try_end_10
    .catchall {:try_start_1 .. :try_end_10} :catchall_13

    move-result v0

    monitor-exit p0

    return v0

    .line 245
    :catchall_13
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method declared-synchronized nTypeGetNativeData(I[I)V
    .registers 4
    .parameter "id"
    .parameter "typeData"

    .prologue
    .line 250
    monitor-enter p0

    :try_start_1
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 251
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    invoke-virtual {p0, v0, p1, p2}, Landroid/renderscript/RenderScript;->rsnTypeGetNativeData(II[I)V
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    .line 252
    monitor-exit p0

    return-void

    .line 250
    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method native rsnAllocationCopyFromBitmap(IILandroid/graphics/Bitmap;)V
.end method

.method native rsnAllocationCopyToBitmap(IILandroid/graphics/Bitmap;)V
.end method

.method native rsnAllocationCreateBitmapRef(IILandroid/graphics/Bitmap;)I
.end method

.method native rsnAllocationCreateFromAssetStream(IIII)I
.end method

.method native rsnAllocationCreateFromBitmap(IIILandroid/graphics/Bitmap;I)I
.end method

.method native rsnAllocationCreateTyped(IIIII)I
.end method

.method native rsnAllocationCubeCreateFromBitmap(IIILandroid/graphics/Bitmap;I)I
.end method

.method native rsnAllocationData1D(IIIII[BI)V
.end method

.method native rsnAllocationData1D(IIIII[FI)V
.end method

.method native rsnAllocationData1D(IIIII[II)V
.end method

.method native rsnAllocationData1D(IIIII[SI)V
.end method

.method native rsnAllocationData2D(IIIIIIIIIIIII)V
.end method

.method native rsnAllocationData2D(IIIIIIII[BI)V
.end method

.method native rsnAllocationData2D(IIIIIIII[FI)V
.end method

.method native rsnAllocationData2D(IIIIIIII[II)V
.end method

.method native rsnAllocationData2D(IIIIIIII[SI)V
.end method

.method native rsnAllocationData2D(IIIIIILandroid/graphics/Bitmap;)V
.end method

.method native rsnAllocationElementData1D(IIIII[BI)V
.end method

.method native rsnAllocationGenerateMipmaps(II)V
.end method

.method native rsnAllocationGetSurfaceTextureID(II)I
.end method

.method native rsnAllocationGetSurfaceTextureID2(IILandroid/graphics/SurfaceTexture;)V
.end method

.method native rsnAllocationGetType(II)I
.end method

.method native rsnAllocationIoReceive(II)V
.end method

.method native rsnAllocationIoSend(II)V
.end method

.method native rsnAllocationRead(II[B)V
.end method

.method native rsnAllocationRead(II[F)V
.end method

.method native rsnAllocationRead(II[I)V
.end method

.method native rsnAllocationRead(II[S)V
.end method

.method native rsnAllocationResize1D(III)V
.end method

.method native rsnAllocationResize2D(IIII)V
.end method

.method native rsnAllocationSetSurface(IILandroid/view/Surface;)V
.end method

.method native rsnAllocationSyncAll(III)V
.end method

.method native rsnAssignName(II[B)V
.end method

.method native rsnContextBindProgramFragment(II)V
.end method

.method native rsnContextBindProgramRaster(II)V
.end method

.method native rsnContextBindProgramStore(II)V
.end method

.method native rsnContextBindProgramVertex(II)V
.end method

.method native rsnContextBindRootScript(II)V
.end method

.method native rsnContextBindSampler(III)V
.end method

.method native rsnContextCreate(III)I
.end method

.method native rsnContextCreateGL(IIIIIIIIIIIIIFI)I
.end method

.method native rsnContextDestroy(I)V
.end method

.method native rsnContextDump(II)V
.end method

.method native rsnContextFinish(I)V
.end method

.method native rsnContextPause(I)V
.end method

.method native rsnContextResume(I)V
.end method

.method native rsnContextSetPriority(II)V
.end method

.method native rsnContextSetSurface(IIILandroid/view/Surface;)V
.end method

.method native rsnContextSetSurfaceTexture(IIILandroid/graphics/SurfaceTexture;)V
.end method

.method native rsnElementCreate(IIIZI)I
.end method

.method native rsnElementCreate2(I[I[Ljava/lang/String;[I)I
.end method

.method native rsnElementGetNativeData(II[I)V
.end method

.method native rsnElementGetSubElements(II[I[Ljava/lang/String;[I)V
.end method

.method native rsnFileA3DCreateFromAsset(ILandroid/content/res/AssetManager;Ljava/lang/String;)I
.end method

.method native rsnFileA3DCreateFromAssetStream(II)I
.end method

.method native rsnFileA3DCreateFromFile(ILjava/lang/String;)I
.end method

.method native rsnFileA3DGetEntryByIndex(III)I
.end method

.method native rsnFileA3DGetIndexEntries(III[I[Ljava/lang/String;)V
.end method

.method native rsnFileA3DGetNumIndexEntries(II)I
.end method

.method native rsnFontCreateFromAsset(ILandroid/content/res/AssetManager;Ljava/lang/String;FI)I
.end method

.method native rsnFontCreateFromAssetStream(ILjava/lang/String;FII)I
.end method

.method native rsnFontCreateFromFile(ILjava/lang/String;FI)I
.end method

.method native rsnGetName(II)Ljava/lang/String;
.end method

.method native rsnMeshCreate(I[I[I[I)I
.end method

.method native rsnMeshGetIndexCount(II)I
.end method

.method native rsnMeshGetIndices(II[I[II)V
.end method

.method native rsnMeshGetVertexBufferCount(II)I
.end method

.method native rsnMeshGetVertices(II[II)V
.end method

.method native rsnObjDestroy(II)V
.end method

.method native rsnPathCreate(IIZIIF)I
.end method

.method native rsnProgramBindConstants(IIII)V
.end method

.method native rsnProgramBindSampler(IIII)V
.end method

.method native rsnProgramBindTexture(IIII)V
.end method

.method native rsnProgramFragmentCreate(ILjava/lang/String;[Ljava/lang/String;[I)I
.end method

.method native rsnProgramRasterCreate(IZI)I
.end method

.method native rsnProgramStoreCreate(IZZZZZZIII)I
.end method

.method native rsnProgramVertexCreate(ILjava/lang/String;[Ljava/lang/String;[I)I
.end method

.method native rsnSamplerCreate(IIIIIIF)I
.end method

.method native rsnScriptBindAllocation(IIII)V
.end method

.method native rsnScriptCCreate(ILjava/lang/String;Ljava/lang/String;[BI)I
.end method

.method native rsnScriptForEach(IIIII)V
.end method

.method native rsnScriptForEach(IIIII[B)V
.end method

.method native rsnScriptInvoke(III)V
.end method

.method native rsnScriptInvokeV(III[B)V
.end method

.method native rsnScriptSetTimeZone(II[B)V
.end method

.method native rsnScriptSetVarD(IIID)V
.end method

.method native rsnScriptSetVarF(IIIF)V
.end method

.method native rsnScriptSetVarI(IIII)V
.end method

.method native rsnScriptSetVarJ(IIIJ)V
.end method

.method native rsnScriptSetVarObj(IIII)V
.end method

.method native rsnScriptSetVarV(III[B)V
.end method

.method native rsnScriptSetVarVE(III[BI[I)V
.end method

.method native rsnTypeCreate(IIIIIZZ)I
.end method

.method native rsnTypeGetNativeData(II[I)V
.end method

.method safeID(Landroid/renderscript/BaseObj;)I
    .registers 3
    .parameter "o"

    .prologue
    .line 1010
    if-eqz p1, :cond_7

    .line 1011
    invoke-virtual {p1, p0}, Landroid/renderscript/BaseObj;->getID(Landroid/renderscript/RenderScript;)I

    move-result v0

    .line 1013
    :goto_6
    return v0

    :cond_7
    const/4 v0, 0x0

    goto :goto_6
.end method

.method public setErrorHandler(Landroid/renderscript/RenderScript$RSErrorHandler;)V
    .registers 2
    .parameter "msg"

    .prologue
    .line 799
    iput-object p1, p0, Landroid/renderscript/RenderScript;->mErrorCallback:Landroid/renderscript/RenderScript$RSErrorHandler;

    .line 800
    return-void
.end method

.method public setMessageHandler(Landroid/renderscript/RenderScript$RSMessageHandler;)V
    .registers 2
    .parameter "msg"

    .prologue
    .line 770
    iput-object p1, p0, Landroid/renderscript/RenderScript;->mMessageCallback:Landroid/renderscript/RenderScript$RSMessageHandler;

    .line 771
    return-void
.end method

.method public setPriority(Landroid/renderscript/RenderScript$Priority;)V
    .registers 3
    .parameter "p"

    .prologue
    .line 834
    invoke-virtual {p0}, Landroid/renderscript/RenderScript;->validate()V

    .line 835
    iget v0, p1, Landroid/renderscript/RenderScript$Priority;->mID:I

    invoke-virtual {p0, v0}, Landroid/renderscript/RenderScript;->nContextSetPriority(I)V

    .line 836
    return-void
.end method

.method validate()V
    .registers 3

    .prologue
    .line 822
    iget v0, p0, Landroid/renderscript/RenderScript;->mContext:I

    if-nez v0, :cond_c

    .line 823
    new-instance v0, Landroid/renderscript/RSInvalidStateException;

    const-string v1, "Calling RS with no Context active."

    invoke-direct {v0, v1}, Landroid/renderscript/RSInvalidStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 825
    :cond_c
    return-void
.end method
