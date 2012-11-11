.class public Landroid/drm/DrmRights;
.super Ljava/lang/Object;
.source "DrmRights.java"


# instance fields
.field private mAccountId:Ljava/lang/String;

.field private mData:[B

.field private mMimeType:Ljava/lang/String;

.field private mSubscriptionId:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/drm/ProcessedData;Ljava/lang/String;)V
    .registers 6
    .parameter "data"
    .parameter "mimeType"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    if-nez p1, :cond_d

    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "data is null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_d
    invoke-virtual {p1}, Landroid/drm/ProcessedData;->getData()[B

    move-result-object v1

    iput-object v1, p0, Landroid/drm/DrmRights;->mData:[B

    invoke-virtual {p1}, Landroid/drm/ProcessedData;->getAccountId()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Landroid/drm/DrmRights;->mAccountId:Ljava/lang/String;

    invoke-virtual {p1}, Landroid/drm/ProcessedData;->getSubscriptionId()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Landroid/drm/DrmRights;->mSubscriptionId:Ljava/lang/String;

    iput-object p2, p0, Landroid/drm/DrmRights;->mMimeType:Ljava/lang/String;

    invoke-virtual {p0}, Landroid/drm/DrmRights;->isValid()Z

    move-result v1

    if-nez v1, :cond_55

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "mimeType: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Landroid/drm/DrmRights;->mMimeType:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ","

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "data: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Landroid/drm/DrmRights;->mData:[B

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .local v0, msg:Ljava/lang/String;
    new-instance v1, Ljava/lang/IllegalArgumentException;

    invoke-direct {v1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .end local v0           #msg:Ljava/lang/String;
    :cond_55
    return-void
.end method

.method public constructor <init>(Ljava/io/File;Ljava/lang/String;)V
    .registers 3
    .parameter "rightsFile"
    .parameter "mimeType"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    invoke-direct {p0, p1, p2}, Landroid/drm/DrmRights;->instantiate(Ljava/io/File;Ljava/lang/String;)V

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .registers 4
    .parameter "rightsFilePath"
    .parameter "mimeType"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/io/File;

    invoke-direct {v0, p1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .local v0, file:Ljava/io/File;
    invoke-direct {p0, v0, p2}, Landroid/drm/DrmRights;->instantiate(Ljava/io/File;Ljava/lang/String;)V

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .registers 4
    .parameter "rightsFilePath"
    .parameter "mimeType"
    .parameter "accountId"

    .prologue
    invoke-direct {p0, p1, p2}, Landroid/drm/DrmRights;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    iput-object p3, p0, Landroid/drm/DrmRights;->mAccountId:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .registers 5
    .parameter "rightsFilePath"
    .parameter "mimeType"
    .parameter "accountId"
    .parameter "subscriptionId"

    .prologue
    invoke-direct {p0, p1, p2}, Landroid/drm/DrmRights;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    iput-object p3, p0, Landroid/drm/DrmRights;->mAccountId:Ljava/lang/String;

    iput-object p4, p0, Landroid/drm/DrmRights;->mSubscriptionId:Ljava/lang/String;

    return-void
.end method

.method private instantiate(Ljava/io/File;Ljava/lang/String;)V
    .registers 7
    .parameter "rightsFile"
    .parameter "mimeType"

    .prologue
    :try_start_0
    invoke-static {p1}, Landroid/drm/DrmUtils;->readBytes(Ljava/io/File;)[B

    move-result-object v2

    iput-object v2, p0, Landroid/drm/DrmRights;->mData:[B
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_6} :catch_3c

    :goto_6
    iput-object p2, p0, Landroid/drm/DrmRights;->mMimeType:Ljava/lang/String;

    invoke-virtual {p0}, Landroid/drm/DrmRights;->isValid()Z

    move-result v2

    if-nez v2, :cond_41

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "mimeType: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Landroid/drm/DrmRights;->mMimeType:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ","

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "data: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Landroid/drm/DrmRights;->mData:[B

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .local v1, msg:Ljava/lang/String;
    new-instance v2, Ljava/lang/IllegalArgumentException;

    invoke-direct {v2, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .end local v1           #msg:Ljava/lang/String;
    :catch_3c
    move-exception v0

    .local v0, e:Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_6

    .end local v0           #e:Ljava/io/IOException;
    :cond_41
    return-void
.end method


# virtual methods
.method public getAccountId()Ljava/lang/String;
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/drm/DrmRights;->mAccountId:Ljava/lang/String;

    return-object v0
.end method

.method public getData()[B
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/drm/DrmRights;->mData:[B

    return-object v0
.end method

.method public getMimeType()Ljava/lang/String;
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/drm/DrmRights;->mMimeType:Ljava/lang/String;

    return-object v0
.end method

.method public getSubscriptionId()Ljava/lang/String;
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/drm/DrmRights;->mSubscriptionId:Ljava/lang/String;

    return-object v0
.end method

.method isValid()Z
    .registers 3

    .prologue
    iget-object v0, p0, Landroid/drm/DrmRights;->mMimeType:Ljava/lang/String;

    if-eqz v0, :cond_19

    iget-object v0, p0, Landroid/drm/DrmRights;->mMimeType:Ljava/lang/String;

    const-string v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_19

    iget-object v0, p0, Landroid/drm/DrmRights;->mData:[B

    if-eqz v0, :cond_19

    iget-object v0, p0, Landroid/drm/DrmRights;->mData:[B

    array-length v0, v0

    if-lez v0, :cond_19

    const/4 v0, 0x1

    :goto_18
    return v0

    :cond_19
    const/4 v0, 0x0

    goto :goto_18
.end method
