.class public Landroid/drm/ProcessedData;
.super Ljava/lang/Object;
.source "ProcessedData.java"


# instance fields
.field private mAccountId:Ljava/lang/String;

.field private final mData:[B

.field private mSubscriptionId:Ljava/lang/String;


# direct methods
.method constructor <init>([BLjava/lang/String;)V
    .registers 4
    .parameter "data"
    .parameter "accountId"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    const-string v0, "_NO_USER"

    iput-object v0, p0, Landroid/drm/ProcessedData;->mAccountId:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Landroid/drm/ProcessedData;->mSubscriptionId:Ljava/lang/String;

    iput-object p1, p0, Landroid/drm/ProcessedData;->mData:[B

    iput-object p2, p0, Landroid/drm/ProcessedData;->mAccountId:Ljava/lang/String;

    return-void
.end method

.method constructor <init>([BLjava/lang/String;Ljava/lang/String;)V
    .registers 5
    .parameter "data"
    .parameter "accountId"
    .parameter "subscriptionId"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    const-string v0, "_NO_USER"

    iput-object v0, p0, Landroid/drm/ProcessedData;->mAccountId:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Landroid/drm/ProcessedData;->mSubscriptionId:Ljava/lang/String;

    iput-object p1, p0, Landroid/drm/ProcessedData;->mData:[B

    iput-object p2, p0, Landroid/drm/ProcessedData;->mAccountId:Ljava/lang/String;

    iput-object p3, p0, Landroid/drm/ProcessedData;->mSubscriptionId:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public getAccountId()Ljava/lang/String;
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/drm/ProcessedData;->mAccountId:Ljava/lang/String;

    return-object v0
.end method

.method public getData()[B
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/drm/ProcessedData;->mData:[B

    return-object v0
.end method

.method public getSubscriptionId()Ljava/lang/String;
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/drm/ProcessedData;->mSubscriptionId:Ljava/lang/String;

    return-object v0
.end method
