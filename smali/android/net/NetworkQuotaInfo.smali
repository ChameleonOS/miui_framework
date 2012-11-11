.class public Landroid/net/NetworkQuotaInfo;
.super Ljava/lang/Object;
.source "NetworkQuotaInfo.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator; = null
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Landroid/net/NetworkQuotaInfo;",
            ">;"
        }
    .end annotation
.end field

.field public static final NO_LIMIT:J = -0x1L


# instance fields
.field private final mEstimatedBytes:J

.field private final mHardLimitBytes:J

.field private final mSoftLimitBytes:J


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    new-instance v0, Landroid/net/NetworkQuotaInfo$1;

    invoke-direct {v0}, Landroid/net/NetworkQuotaInfo$1;-><init>()V

    sput-object v0, Landroid/net/NetworkQuotaInfo;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(JJJ)V
    .registers 7
    .parameter "estimatedBytes"
    .parameter "softLimitBytes"
    .parameter "hardLimitBytes"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-wide p1, p0, Landroid/net/NetworkQuotaInfo;->mEstimatedBytes:J

    iput-wide p3, p0, Landroid/net/NetworkQuotaInfo;->mSoftLimitBytes:J

    iput-wide p5, p0, Landroid/net/NetworkQuotaInfo;->mHardLimitBytes:J

    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .registers 4
    .parameter "in"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Landroid/net/NetworkQuotaInfo;->mEstimatedBytes:J

    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Landroid/net/NetworkQuotaInfo;->mSoftLimitBytes:J

    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Landroid/net/NetworkQuotaInfo;->mHardLimitBytes:J

    return-void
.end method


# virtual methods
.method public describeContents()I
    .registers 2

    .prologue
    const/4 v0, 0x0

    return v0
.end method

.method public getEstimatedBytes()J
    .registers 3

    .prologue
    iget-wide v0, p0, Landroid/net/NetworkQuotaInfo;->mEstimatedBytes:J

    return-wide v0
.end method

.method public getHardLimitBytes()J
    .registers 3

    .prologue
    iget-wide v0, p0, Landroid/net/NetworkQuotaInfo;->mHardLimitBytes:J

    return-wide v0
.end method

.method public getSoftLimitBytes()J
    .registers 3

    .prologue
    iget-wide v0, p0, Landroid/net/NetworkQuotaInfo;->mSoftLimitBytes:J

    return-wide v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 5
    .parameter "out"
    .parameter "flags"

    .prologue
    iget-wide v0, p0, Landroid/net/NetworkQuotaInfo;->mEstimatedBytes:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    iget-wide v0, p0, Landroid/net/NetworkQuotaInfo;->mSoftLimitBytes:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    iget-wide v0, p0, Landroid/net/NetworkQuotaInfo;->mHardLimitBytes:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    return-void
.end method
