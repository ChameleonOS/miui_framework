.class public Lcom/android/internal/http/multipart/FilePartSource;
.super Ljava/lang/Object;
.source "FilePartSource.java"

# interfaces
.implements Lcom/android/internal/http/multipart/PartSource;


# instance fields
.field private file:Ljava/io/File;

.field private fileName:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/io/File;)V
    .registers 4
    .parameter "file"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/FileNotFoundException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/android/internal/http/multipart/FilePartSource;->file:Ljava/io/File;

    iput-object v0, p0, Lcom/android/internal/http/multipart/FilePartSource;->fileName:Ljava/lang/String;

    iput-object p1, p0, Lcom/android/internal/http/multipart/FilePartSource;->file:Ljava/io/File;

    if-eqz p1, :cond_2e

    invoke-virtual {p1}, Ljava/io/File;->isFile()Z

    move-result v0

    if-nez v0, :cond_1a

    new-instance v0, Ljava/io/FileNotFoundException;

    const-string v1, "File is not a normal file."

    invoke-direct {v0, v1}, Ljava/io/FileNotFoundException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1a
    invoke-virtual {p1}, Ljava/io/File;->canRead()Z

    move-result v0

    if-nez v0, :cond_28

    new-instance v0, Ljava/io/FileNotFoundException;

    const-string v1, "File is not readable."

    invoke-direct {v0, v1}, Ljava/io/FileNotFoundException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_28
    invoke-virtual {p1}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/internal/http/multipart/FilePartSource;->fileName:Ljava/lang/String;

    :cond_2e
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/io/File;)V
    .registers 3
    .parameter "fileName"
    .parameter "file"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/FileNotFoundException;
        }
    .end annotation

    .prologue
    invoke-direct {p0, p2}, Lcom/android/internal/http/multipart/FilePartSource;-><init>(Ljava/io/File;)V

    if-eqz p1, :cond_7

    iput-object p1, p0, Lcom/android/internal/http/multipart/FilePartSource;->fileName:Ljava/lang/String;

    :cond_7
    return-void
.end method


# virtual methods
.method public createInputStream()Ljava/io/InputStream;
    .registers 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    iget-object v0, p0, Lcom/android/internal/http/multipart/FilePartSource;->file:Ljava/io/File;

    if-eqz v0, :cond_c

    new-instance v0, Ljava/io/FileInputStream;

    iget-object v1, p0, Lcom/android/internal/http/multipart/FilePartSource;->file:Ljava/io/File;

    invoke-direct {v0, v1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    :goto_b
    return-object v0

    :cond_c
    new-instance v0, Ljava/io/ByteArrayInputStream;

    const/4 v1, 0x0

    new-array v1, v1, [B

    invoke-direct {v0, v1}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    goto :goto_b
.end method

.method public getFileName()Ljava/lang/String;
    .registers 2

    .prologue
    iget-object v0, p0, Lcom/android/internal/http/multipart/FilePartSource;->fileName:Ljava/lang/String;

    if-nez v0, :cond_8

    const-string/jumbo v0, "noname"

    :goto_7
    return-object v0

    :cond_8
    iget-object v0, p0, Lcom/android/internal/http/multipart/FilePartSource;->fileName:Ljava/lang/String;

    goto :goto_7
.end method

.method public getLength()J
    .registers 3

    .prologue
    iget-object v0, p0, Lcom/android/internal/http/multipart/FilePartSource;->file:Ljava/io/File;

    if-eqz v0, :cond_b

    iget-object v0, p0, Lcom/android/internal/http/multipart/FilePartSource;->file:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->length()J

    move-result-wide v0

    :goto_a
    return-wide v0

    :cond_b
    const-wide/16 v0, 0x0

    goto :goto_a
.end method
