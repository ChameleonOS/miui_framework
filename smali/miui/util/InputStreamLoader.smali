.class public Lmiui/util/InputStreamLoader;
.super Ljava/lang/Object;
.source "InputStreamLoader.java"


# instance fields
.field mByteArrayInputStream:Ljava/io/ByteArrayInputStream;

.field private mContext:Landroid/content/Context;

.field private mInputStream:Ljava/io/InputStream;

.field private mPath:Ljava/lang/String;

.field private mUri:Landroid/net/Uri;

.field private mZipFile:Ljava/util/zip/ZipFile;

.field private mZipPath:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/net/Uri;)V
    .registers 5
    .parameter "context"
    .parameter "uri"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    const-string v0, "file"

    invoke-virtual {p2}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_16

    invoke-virtual {p2}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lmiui/util/InputStreamLoader;->mPath:Ljava/lang/String;

    :goto_15
    return-void

    :cond_16
    iput-object p1, p0, Lmiui/util/InputStreamLoader;->mContext:Landroid/content/Context;

    iput-object p2, p0, Lmiui/util/InputStreamLoader;->mUri:Landroid/net/Uri;

    goto :goto_15
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .registers 2
    .parameter "path"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lmiui/util/InputStreamLoader;->mPath:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .registers 3
    .parameter "zipPath"
    .parameter "entry"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lmiui/util/InputStreamLoader;->mZipPath:Ljava/lang/String;

    iput-object p2, p0, Lmiui/util/InputStreamLoader;->mPath:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>([B)V
    .registers 3
    .parameter "data"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/io/ByteArrayInputStream;

    invoke-direct {v0, p1}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    iput-object v0, p0, Lmiui/util/InputStreamLoader;->mByteArrayInputStream:Ljava/io/ByteArrayInputStream;

    return-void
.end method


# virtual methods
.method public close()V
    .registers 2

    .prologue
    :try_start_0
    iget-object v0, p0, Lmiui/util/InputStreamLoader;->mInputStream:Ljava/io/InputStream;

    if-eqz v0, :cond_9

    iget-object v0, p0, Lmiui/util/InputStreamLoader;->mInputStream:Ljava/io/InputStream;

    invoke-virtual {v0}, Ljava/io/InputStream;->close()V

    :cond_9
    iget-object v0, p0, Lmiui/util/InputStreamLoader;->mZipFile:Ljava/util/zip/ZipFile;

    if-eqz v0, :cond_12

    iget-object v0, p0, Lmiui/util/InputStreamLoader;->mZipFile:Ljava/util/zip/ZipFile;

    invoke-virtual {v0}, Ljava/util/zip/ZipFile;->close()V
    :try_end_12
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_12} :catch_13

    :cond_12
    :goto_12
    return-void

    :catch_13
    move-exception v0

    goto :goto_12
.end method

.method public get()Ljava/io/InputStream;
    .registers 4

    .prologue
    invoke-virtual {p0}, Lmiui/util/InputStreamLoader;->close()V

    :try_start_3
    iget-object v0, p0, Lmiui/util/InputStreamLoader;->mUri:Landroid/net/Uri;

    if-eqz v0, :cond_2d

    iget-object v0, p0, Lmiui/util/InputStreamLoader;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    iget-object v1, p0, Lmiui/util/InputStreamLoader;->mUri:Landroid/net/Uri;

    invoke-virtual {v0, v1}, Landroid/content/ContentResolver;->openInputStream(Landroid/net/Uri;)Ljava/io/InputStream;

    move-result-object v0

    iput-object v0, p0, Lmiui/util/InputStreamLoader;->mInputStream:Ljava/io/InputStream;
    :try_end_15
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_15} :catch_4b

    :cond_15
    :goto_15
    iget-object v0, p0, Lmiui/util/InputStreamLoader;->mInputStream:Ljava/io/InputStream;

    if-eqz v0, :cond_2a

    iget-object v0, p0, Lmiui/util/InputStreamLoader;->mInputStream:Ljava/io/InputStream;

    instance-of v0, v0, Ljava/io/ByteArrayInputStream;

    if-nez v0, :cond_2a

    new-instance v0, Ljava/io/BufferedInputStream;

    iget-object v1, p0, Lmiui/util/InputStreamLoader;->mInputStream:Ljava/io/InputStream;

    const/16 v2, 0x4000

    invoke-direct {v0, v1, v2}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;I)V

    iput-object v0, p0, Lmiui/util/InputStreamLoader;->mInputStream:Ljava/io/InputStream;

    :cond_2a
    iget-object v0, p0, Lmiui/util/InputStreamLoader;->mInputStream:Ljava/io/InputStream;

    return-object v0

    :cond_2d
    :try_start_2d
    iget-object v0, p0, Lmiui/util/InputStreamLoader;->mZipPath:Ljava/lang/String;

    if-eqz v0, :cond_4d

    new-instance v0, Ljava/util/zip/ZipFile;

    iget-object v1, p0, Lmiui/util/InputStreamLoader;->mZipPath:Ljava/lang/String;

    invoke-direct {v0, v1}, Ljava/util/zip/ZipFile;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lmiui/util/InputStreamLoader;->mZipFile:Ljava/util/zip/ZipFile;

    iget-object v0, p0, Lmiui/util/InputStreamLoader;->mZipFile:Ljava/util/zip/ZipFile;

    iget-object v1, p0, Lmiui/util/InputStreamLoader;->mZipFile:Ljava/util/zip/ZipFile;

    iget-object v2, p0, Lmiui/util/InputStreamLoader;->mPath:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/util/zip/ZipFile;->getEntry(Ljava/lang/String;)Ljava/util/zip/ZipEntry;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/zip/ZipFile;->getInputStream(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;

    move-result-object v0

    iput-object v0, p0, Lmiui/util/InputStreamLoader;->mInputStream:Ljava/io/InputStream;

    goto :goto_15

    :catch_4b
    move-exception v0

    goto :goto_15

    :cond_4d
    iget-object v0, p0, Lmiui/util/InputStreamLoader;->mPath:Ljava/lang/String;

    if-eqz v0, :cond_5b

    new-instance v0, Ljava/io/FileInputStream;

    iget-object v1, p0, Lmiui/util/InputStreamLoader;->mPath:Ljava/lang/String;

    invoke-direct {v0, v1}, Ljava/io/FileInputStream;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lmiui/util/InputStreamLoader;->mInputStream:Ljava/io/InputStream;

    goto :goto_15

    :cond_5b
    iget-object v0, p0, Lmiui/util/InputStreamLoader;->mByteArrayInputStream:Ljava/io/ByteArrayInputStream;

    if-eqz v0, :cond_15

    iget-object v0, p0, Lmiui/util/InputStreamLoader;->mByteArrayInputStream:Ljava/io/ByteArrayInputStream;

    invoke-virtual {v0}, Ljava/io/ByteArrayInputStream;->reset()V

    iget-object v0, p0, Lmiui/util/InputStreamLoader;->mByteArrayInputStream:Ljava/io/ByteArrayInputStream;

    iput-object v0, p0, Lmiui/util/InputStreamLoader;->mInputStream:Ljava/io/InputStream;
    :try_end_68
    .catch Ljava/lang/Exception; {:try_start_2d .. :try_end_68} :catch_4b

    goto :goto_15
.end method
