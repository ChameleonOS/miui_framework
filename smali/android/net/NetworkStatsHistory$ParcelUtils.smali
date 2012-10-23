.class public Landroid/net/NetworkStatsHistory$ParcelUtils;
.super Ljava/lang/Object;
.source "NetworkStatsHistory.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/net/NetworkStatsHistory;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ParcelUtils"
.end annotation


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 705
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static readLongArray(Landroid/os/Parcel;)[J
    .registers 6
    .parameter "in"

    .prologue
    .line 707
    invoke-virtual {p0}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .line 708
    .local v1, size:I
    const/4 v3, -0x1

    if-ne v1, v3, :cond_9

    const/4 v2, 0x0

    .line 713
    :cond_8
    return-object v2

    .line 709
    :cond_9
    new-array v2, v1, [J

    .line 710
    .local v2, values:[J
    const/4 v0, 0x0

    .local v0, i:I
    :goto_c
    array-length v3, v2

    if-ge v0, v3, :cond_8

    .line 711
    invoke-virtual {p0}, Landroid/os/Parcel;->readLong()J

    move-result-wide v3

    aput-wide v3, v2, v0

    .line 710
    add-int/lit8 v0, v0, 0x1

    goto :goto_c
.end method

.method public static writeLongArray(Landroid/os/Parcel;[JI)V
    .registers 6
    .parameter "out"
    .parameter "values"
    .parameter "size"

    .prologue
    .line 717
    if-nez p1, :cond_7

    .line 718
    const/4 v1, -0x1

    invoke-virtual {p0, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 728
    :cond_6
    return-void

    .line 721
    :cond_7
    array-length v1, p1

    if-le p2, v1, :cond_13

    .line 722
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "size larger than length"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 724
    :cond_13
    invoke-virtual {p0, p2}, Landroid/os/Parcel;->writeInt(I)V

    .line 725
    const/4 v0, 0x0

    .local v0, i:I
    :goto_17
    if-ge v0, p2, :cond_6

    .line 726
    aget-wide v1, p1, v0

    invoke-virtual {p0, v1, v2}, Landroid/os/Parcel;->writeLong(J)V

    .line 725
    add-int/lit8 v0, v0, 0x1

    goto :goto_17
.end method
