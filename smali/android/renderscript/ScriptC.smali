.class public Landroid/renderscript/ScriptC;
.super Landroid/renderscript/Script;
.source "ScriptC.java"


# static fields
.field private static final TAG:Ljava/lang/String; = "ScriptC"


# direct methods
.method protected constructor <init>(ILandroid/renderscript/RenderScript;)V
    .registers 3
    .parameter "id"
    .parameter "rs"

    .prologue
    invoke-direct {p0, p1, p2}, Landroid/renderscript/Script;-><init>(ILandroid/renderscript/RenderScript;)V

    return-void
.end method

.method protected constructor <init>(Landroid/renderscript/RenderScript;Landroid/content/res/Resources;I)V
    .registers 7
    .parameter "rs"
    .parameter "resources"
    .parameter "resourceID"

    .prologue
    const/4 v1, 0x0

    invoke-direct {p0, v1, p1}, Landroid/renderscript/Script;-><init>(ILandroid/renderscript/RenderScript;)V

    invoke-static {p1, p2, p3}, Landroid/renderscript/ScriptC;->internalCreate(Landroid/renderscript/RenderScript;Landroid/content/res/Resources;I)I

    move-result v0

    .local v0, id:I
    if-nez v0, :cond_12

    new-instance v1, Landroid/renderscript/RSRuntimeException;

    const-string v2, "Loading of ScriptC script failed."

    invoke-direct {v1, v2}, Landroid/renderscript/RSRuntimeException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_12
    invoke-virtual {p0, v0}, Landroid/renderscript/ScriptC;->setID(I)V

    return-void
.end method

.method private static declared-synchronized internalCreate(Landroid/renderscript/RenderScript;Landroid/content/res/Resources;I)I
    .registers 15
    .parameter "rs"
    .parameter "resources"
    .parameter "resourceID"

    .prologue
    const-class v9, Landroid/renderscript/ScriptC;

    monitor-enter v9

    :try_start_3
    invoke-virtual {p1, p2}, Landroid/content/res/Resources;->openRawResource(I)Ljava/io/InputStream;
    :try_end_6
    .catchall {:try_start_3 .. :try_end_6} :catchall_5b

    move-result-object v4

    .local v4, is:Ljava/io/InputStream;
    const/16 v8, 0x400

    :try_start_9
    new-array v5, v8, [B

    .local v5, pgm:[B
    const/4 v6, 0x0

    .local v6, pgmLength:I
    :goto_c
    array-length v8, v5

    sub-int v1, v8, v6

    .local v1, bytesLeft:I
    if-nez v1, :cond_20

    array-length v8, v5

    mul-int/lit8 v8, v8, 0x2

    new-array v0, v8, [B

    .local v0, buf2:[B
    const/4 v8, 0x0

    const/4 v10, 0x0

    array-length v11, v5

    invoke-static {v5, v8, v0, v10, v11}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    move-object v5, v0

    array-length v8, v5

    sub-int v1, v8, v6

    .end local v0           #buf2:[B
    :cond_20
    invoke-virtual {v4, v5, v6, v1}, Ljava/io/InputStream;->read([BII)I
    :try_end_23
    .catchall {:try_start_9 .. :try_end_23} :catchall_4f

    move-result v2

    .local v2, bytesRead:I
    if-gtz v2, :cond_4d

    :try_start_26
    invoke-virtual {v4}, Ljava/io/InputStream;->close()V
    :try_end_29
    .catchall {:try_start_26 .. :try_end_29} :catchall_5b
    .catch Ljava/io/IOException; {:try_start_26 .. :try_end_29} :catch_54

    :try_start_29
    invoke-virtual {p1, p2}, Landroid/content/res/Resources;->getResourceEntryName(I)Ljava/lang/String;

    move-result-object v7

    .local v7, resName:Ljava/lang/String;
    const-string v8, "ScriptC"

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "Create script for resource = "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v8, v10}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    sget-object v8, Landroid/renderscript/RenderScript;->mCachePath:Ljava/lang/String;

    invoke-virtual {p0, v7, v8, v5, v6}, Landroid/renderscript/RenderScript;->nScriptCCreate(Ljava/lang/String;Ljava/lang/String;[BI)I
    :try_end_4a
    .catchall {:try_start_29 .. :try_end_4a} :catchall_5b

    move-result v8

    monitor-exit v9

    return v8

    .end local v7           #resName:Ljava/lang/String;
    :cond_4d
    add-int/2addr v6, v2

    goto :goto_c

    .end local v1           #bytesLeft:I
    .end local v2           #bytesRead:I
    .end local v5           #pgm:[B
    .end local v6           #pgmLength:I
    :catchall_4f
    move-exception v8

    :try_start_50
    invoke-virtual {v4}, Ljava/io/InputStream;->close()V

    throw v8
    :try_end_54
    .catchall {:try_start_50 .. :try_end_54} :catchall_5b
    .catch Ljava/io/IOException; {:try_start_50 .. :try_end_54} :catch_54

    :catch_54
    move-exception v3

    .local v3, e:Ljava/io/IOException;
    :try_start_55
    new-instance v8, Landroid/content/res/Resources$NotFoundException;

    invoke-direct {v8}, Landroid/content/res/Resources$NotFoundException;-><init>()V

    throw v8
    :try_end_5b
    .catchall {:try_start_55 .. :try_end_5b} :catchall_5b

    .end local v3           #e:Ljava/io/IOException;
    .end local v4           #is:Ljava/io/InputStream;
    :catchall_5b
    move-exception v8

    monitor-exit v9

    throw v8
.end method
