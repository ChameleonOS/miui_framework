.class public Landroid/webkit/WebStorage$Origin;
.super Ljava/lang/Object;
.source "WebStorage.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/webkit/WebStorage;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Origin"
.end annotation


# instance fields
.field private mOrigin:Ljava/lang/String;

.field private mQuota:J

.field private mUsage:J


# direct methods
.method protected constructor <init>(Ljava/lang/String;)V
    .registers 5
    .parameter "origin"

    .prologue
    const-wide/16 v1, 0x0

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-object v0, p0, Landroid/webkit/WebStorage$Origin;->mOrigin:Ljava/lang/String;

    iput-wide v1, p0, Landroid/webkit/WebStorage$Origin;->mQuota:J

    iput-wide v1, p0, Landroid/webkit/WebStorage$Origin;->mUsage:J

    iput-object p1, p0, Landroid/webkit/WebStorage$Origin;->mOrigin:Ljava/lang/String;

    return-void
.end method

.method protected constructor <init>(Ljava/lang/String;J)V
    .registers 7
    .parameter "origin"
    .parameter "quota"

    .prologue
    const-wide/16 v1, 0x0

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-object v0, p0, Landroid/webkit/WebStorage$Origin;->mOrigin:Ljava/lang/String;

    iput-wide v1, p0, Landroid/webkit/WebStorage$Origin;->mQuota:J

    iput-wide v1, p0, Landroid/webkit/WebStorage$Origin;->mUsage:J

    iput-object p1, p0, Landroid/webkit/WebStorage$Origin;->mOrigin:Ljava/lang/String;

    iput-wide p2, p0, Landroid/webkit/WebStorage$Origin;->mQuota:J

    return-void
.end method

.method protected constructor <init>(Ljava/lang/String;JJ)V
    .registers 9
    .parameter "origin"
    .parameter "quota"
    .parameter "usage"

    .prologue
    const-wide/16 v1, 0x0

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-object v0, p0, Landroid/webkit/WebStorage$Origin;->mOrigin:Ljava/lang/String;

    iput-wide v1, p0, Landroid/webkit/WebStorage$Origin;->mQuota:J

    iput-wide v1, p0, Landroid/webkit/WebStorage$Origin;->mUsage:J

    iput-object p1, p0, Landroid/webkit/WebStorage$Origin;->mOrigin:Ljava/lang/String;

    iput-wide p2, p0, Landroid/webkit/WebStorage$Origin;->mQuota:J

    iput-wide p4, p0, Landroid/webkit/WebStorage$Origin;->mUsage:J

    return-void
.end method


# virtual methods
.method public getOrigin()Ljava/lang/String;
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/webkit/WebStorage$Origin;->mOrigin:Ljava/lang/String;

    return-object v0
.end method

.method public getQuota()J
    .registers 3

    .prologue
    iget-wide v0, p0, Landroid/webkit/WebStorage$Origin;->mQuota:J

    return-wide v0
.end method

.method public getUsage()J
    .registers 3

    .prologue
    iget-wide v0, p0, Landroid/webkit/WebStorage$Origin;->mUsage:J

    return-wide v0
.end method
