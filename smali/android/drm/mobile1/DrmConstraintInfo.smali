.class public Landroid/drm/mobile1/DrmConstraintInfo;
.super Ljava/lang/Object;
.source "DrmConstraintInfo.java"


# instance fields
.field private count:I

.field private endDate:J

.field private interval:J

.field private startDate:J


# direct methods
.method constructor <init>()V
    .registers 4

    .prologue
    const-wide/16 v1, -0x1

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, -0x1

    iput v0, p0, Landroid/drm/mobile1/DrmConstraintInfo;->count:I

    iput-wide v1, p0, Landroid/drm/mobile1/DrmConstraintInfo;->startDate:J

    iput-wide v1, p0, Landroid/drm/mobile1/DrmConstraintInfo;->endDate:J

    iput-wide v1, p0, Landroid/drm/mobile1/DrmConstraintInfo;->interval:J

    return-void
.end method


# virtual methods
.method public getCount()I
    .registers 2

    .prologue
    iget v0, p0, Landroid/drm/mobile1/DrmConstraintInfo;->count:I

    return v0
.end method

.method public getEndDate()Ljava/util/Date;
    .registers 5

    .prologue
    iget-wide v0, p0, Landroid/drm/mobile1/DrmConstraintInfo;->endDate:J

    const-wide/16 v2, -0x1

    cmp-long v0, v0, v2

    if-nez v0, :cond_a

    const/4 v0, 0x0

    :goto_9
    return-object v0

    :cond_a
    new-instance v0, Ljava/util/Date;

    iget-wide v1, p0, Landroid/drm/mobile1/DrmConstraintInfo;->endDate:J

    invoke-direct {v0, v1, v2}, Ljava/util/Date;-><init>(J)V

    goto :goto_9
.end method

.method public getInterval()J
    .registers 3

    .prologue
    iget-wide v0, p0, Landroid/drm/mobile1/DrmConstraintInfo;->interval:J

    return-wide v0
.end method

.method public getStartDate()Ljava/util/Date;
    .registers 5

    .prologue
    iget-wide v0, p0, Landroid/drm/mobile1/DrmConstraintInfo;->startDate:J

    const-wide/16 v2, -0x1

    cmp-long v0, v0, v2

    if-nez v0, :cond_a

    const/4 v0, 0x0

    :goto_9
    return-object v0

    :cond_a
    new-instance v0, Ljava/util/Date;

    iget-wide v1, p0, Landroid/drm/mobile1/DrmConstraintInfo;->startDate:J

    invoke-direct {v0, v1, v2}, Ljava/util/Date;-><init>(J)V

    goto :goto_9
.end method
