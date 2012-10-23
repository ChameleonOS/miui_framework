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

    .line 78
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 60
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/webkit/WebStorage$Origin;->mOrigin:Ljava/lang/String;

    .line 61
    iput-wide v1, p0, Landroid/webkit/WebStorage$Origin;->mQuota:J

    .line 62
    iput-wide v1, p0, Landroid/webkit/WebStorage$Origin;->mUsage:J

    .line 79
    iput-object p1, p0, Landroid/webkit/WebStorage$Origin;->mOrigin:Ljava/lang/String;

    .line 80
    return-void
.end method

.method protected constructor <init>(Ljava/lang/String;J)V
    .registers 7
    .parameter "origin"
    .parameter "quota"

    .prologue
    const-wide/16 v1, 0x0

    .line 72
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 60
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/webkit/WebStorage$Origin;->mOrigin:Ljava/lang/String;

    .line 61
    iput-wide v1, p0, Landroid/webkit/WebStorage$Origin;->mQuota:J

    .line 62
    iput-wide v1, p0, Landroid/webkit/WebStorage$Origin;->mUsage:J

    .line 73
    iput-object p1, p0, Landroid/webkit/WebStorage$Origin;->mOrigin:Ljava/lang/String;

    .line 74
    iput-wide p2, p0, Landroid/webkit/WebStorage$Origin;->mQuota:J

    .line 75
    return-void
.end method

.method protected constructor <init>(Ljava/lang/String;JJ)V
    .registers 9
    .parameter "origin"
    .parameter "quota"
    .parameter "usage"

    .prologue
    const-wide/16 v1, 0x0

    .line 65
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 60
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/webkit/WebStorage$Origin;->mOrigin:Ljava/lang/String;

    .line 61
    iput-wide v1, p0, Landroid/webkit/WebStorage$Origin;->mQuota:J

    .line 62
    iput-wide v1, p0, Landroid/webkit/WebStorage$Origin;->mUsage:J

    .line 66
    iput-object p1, p0, Landroid/webkit/WebStorage$Origin;->mOrigin:Ljava/lang/String;

    .line 67
    iput-wide p2, p0, Landroid/webkit/WebStorage$Origin;->mQuota:J

    .line 68
    iput-wide p4, p0, Landroid/webkit/WebStorage$Origin;->mUsage:J

    .line 69
    return-void
.end method


# virtual methods
.method public getOrigin()Ljava/lang/String;
    .registers 2

    .prologue
    .line 93
    iget-object v0, p0, Landroid/webkit/WebStorage$Origin;->mOrigin:Ljava/lang/String;

    return-object v0
.end method

.method public getQuota()J
    .registers 3

    .prologue
    .line 104
    iget-wide v0, p0, Landroid/webkit/WebStorage$Origin;->mQuota:J

    return-wide v0
.end method

.method public getUsage()J
    .registers 3

    .prologue
    .line 114
    iget-wide v0, p0, Landroid/webkit/WebStorage$Origin;->mUsage:J

    return-wide v0
.end method
