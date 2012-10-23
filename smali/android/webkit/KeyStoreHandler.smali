.class Landroid/webkit/KeyStoreHandler;
.super Landroid/os/Handler;
.source "KeyStoreHandler.java"


# static fields
.field private static final LOGTAG:Ljava/lang/String; = "KeyStoreHandler"


# instance fields
.field private final mDataBuilder:Landroid/webkit/ByteArrayBuilder;

.field private mMimeType:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .registers 3
    .parameter "mimeType"

    .prologue
    .line 36
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    .line 32
    new-instance v0, Landroid/webkit/ByteArrayBuilder;

    invoke-direct {v0}, Landroid/webkit/ByteArrayBuilder;-><init>()V

    iput-object v0, p0, Landroid/webkit/KeyStoreHandler;->mDataBuilder:Landroid/webkit/ByteArrayBuilder;

    .line 37
    iput-object p1, p0, Landroid/webkit/KeyStoreHandler;->mMimeType:Ljava/lang/String;

    .line 38
    return-void
.end method


# virtual methods
.method public didReceiveData([BI)V
    .registers 6
    .parameter "data"
    .parameter "length"

    .prologue
    .line 46
    iget-object v1, p0, Landroid/webkit/KeyStoreHandler;->mDataBuilder:Landroid/webkit/ByteArrayBuilder;

    monitor-enter v1

    .line 47
    :try_start_3
    iget-object v0, p0, Landroid/webkit/KeyStoreHandler;->mDataBuilder:Landroid/webkit/ByteArrayBuilder;

    const/4 v2, 0x0

    invoke-virtual {v0, p1, v2, p2}, Landroid/webkit/ByteArrayBuilder;->append([BII)V

    .line 48
    monitor-exit v1

    .line 49
    return-void

    .line 48
    :catchall_b
    move-exception v0

    monitor-exit v1
    :try_end_d
    .catchall {:try_start_3 .. :try_end_d} :catchall_b

    throw v0
.end method

.method public installCert(Landroid/content/Context;)V
    .registers 10
    .parameter "context"

    .prologue
    .line 52
    iget-object v4, p0, Landroid/webkit/KeyStoreHandler;->mMimeType:Ljava/lang/String;

    invoke-static {v4}, Landroid/webkit/CertTool;->getCertType(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 53
    .local v3, type:Ljava/lang/String;
    if-nez v3, :cond_9

    .line 74
    :goto_8
    return-void

    .line 57
    :cond_9
    iget-object v5, p0, Landroid/webkit/KeyStoreHandler;->mDataBuilder:Landroid/webkit/ByteArrayBuilder;

    monitor-enter v5

    .line 61
    :try_start_c
    iget-object v4, p0, Landroid/webkit/KeyStoreHandler;->mDataBuilder:Landroid/webkit/ByteArrayBuilder;

    invoke-virtual {v4}, Landroid/webkit/ByteArrayBuilder;->getByteSize()I

    move-result v4

    new-array v1, v4, [B

    .line 62
    .local v1, cert:[B
    const/4 v2, 0x0

    .line 64
    .local v2, offset:I
    :goto_15
    iget-object v4, p0, Landroid/webkit/KeyStoreHandler;->mDataBuilder:Landroid/webkit/ByteArrayBuilder;

    invoke-virtual {v4}, Landroid/webkit/ByteArrayBuilder;->getFirstChunk()Landroid/webkit/ByteArrayBuilder$Chunk;

    move-result-object v0

    .line 65
    .local v0, c:Landroid/webkit/ByteArrayBuilder$Chunk;
    if-nez v0, :cond_25

    .line 73
    invoke-static {p1, v3, v1}, Landroid/webkit/CertTool;->addCertificate(Landroid/content/Context;Ljava/lang/String;[B)V

    .line 74
    monitor-exit v5

    goto :goto_8

    .line 75
    .end local v0           #c:Landroid/webkit/ByteArrayBuilder$Chunk;
    .end local v1           #cert:[B
    .end local v2           #offset:I
    :catchall_22
    move-exception v4

    monitor-exit v5
    :try_end_24
    .catchall {:try_start_c .. :try_end_24} :catchall_22

    throw v4

    .line 67
    .restart local v0       #c:Landroid/webkit/ByteArrayBuilder$Chunk;
    .restart local v1       #cert:[B
    .restart local v2       #offset:I
    :cond_25
    :try_start_25
    iget v4, v0, Landroid/webkit/ByteArrayBuilder$Chunk;->mLength:I

    if-eqz v4, :cond_34

    .line 68
    iget-object v4, v0, Landroid/webkit/ByteArrayBuilder$Chunk;->mArray:[B

    const/4 v6, 0x0

    iget v7, v0, Landroid/webkit/ByteArrayBuilder$Chunk;->mLength:I

    invoke-static {v4, v6, v1, v2, v7}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 69
    iget v4, v0, Landroid/webkit/ByteArrayBuilder$Chunk;->mLength:I

    add-int/2addr v2, v4

    .line 71
    :cond_34
    invoke-virtual {v0}, Landroid/webkit/ByteArrayBuilder$Chunk;->release()V
    :try_end_37
    .catchall {:try_start_25 .. :try_end_37} :catchall_22

    goto :goto_15
.end method
