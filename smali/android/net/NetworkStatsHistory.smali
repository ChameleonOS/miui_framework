.class public Landroid/net/NetworkStatsHistory;
.super Ljava/lang/Object;
.source "NetworkStatsHistory.java"

# interfaces
.implements Landroid/os/Parcelable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/net/NetworkStatsHistory$ParcelUtils;,
        Landroid/net/NetworkStatsHistory$DataStreamUtils;,
        Landroid/net/NetworkStatsHistory$Entry;
    }
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator; = null
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Landroid/net/NetworkStatsHistory;",
            ">;"
        }
    .end annotation
.end field

.field public static final FIELD_ACTIVE_TIME:I = 0x1

.field public static final FIELD_ALL:I = -0x1

.field public static final FIELD_OPERATIONS:I = 0x20

.field public static final FIELD_RX_BYTES:I = 0x2

.field public static final FIELD_RX_PACKETS:I = 0x4

.field public static final FIELD_TX_BYTES:I = 0x8

.field public static final FIELD_TX_PACKETS:I = 0x10

.field private static final VERSION_ADD_ACTIVE:I = 0x3

.field private static final VERSION_ADD_PACKETS:I = 0x2

.field private static final VERSION_INIT:I = 0x1


# instance fields
.field private activeTime:[J

.field private bucketCount:I

.field private bucketDuration:J

.field private bucketStart:[J

.field private operations:[J

.field private rxBytes:[J

.field private rxPackets:[J

.field private totalBytes:J

.field private txBytes:[J

.field private txPackets:[J


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 601
    new-instance v0, Landroid/net/NetworkStatsHistory$1;

    invoke-direct {v0}, Landroid/net/NetworkStatsHistory$1;-><init>()V

    sput-object v0, Landroid/net/NetworkStatsHistory;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(J)V
    .registers 5
    .parameter "bucketDuration"

    .prologue
    .line 96
    const/16 v0, 0xa

    const/4 v1, -0x1

    invoke-direct {p0, p1, p2, v0, v1}, Landroid/net/NetworkStatsHistory;-><init>(JII)V

    .line 97
    return-void
.end method

.method public constructor <init>(JI)V
    .registers 5
    .parameter "bucketDuration"
    .parameter "initialSize"

    .prologue
    .line 100
    const/4 v0, -0x1

    invoke-direct {p0, p1, p2, p3, v0}, Landroid/net/NetworkStatsHistory;-><init>(JII)V

    .line 101
    return-void
.end method

.method public constructor <init>(JII)V
    .registers 7
    .parameter "bucketDuration"
    .parameter "initialSize"
    .parameter "fields"

    .prologue
    .line 103
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 104
    iput-wide p1, p0, Landroid/net/NetworkStatsHistory;->bucketDuration:J

    .line 105
    new-array v0, p3, [J

    iput-object v0, p0, Landroid/net/NetworkStatsHistory;->bucketStart:[J

    .line 106
    and-int/lit8 v0, p4, 0x1

    if-eqz v0, :cond_11

    new-array v0, p3, [J

    iput-object v0, p0, Landroid/net/NetworkStatsHistory;->activeTime:[J

    .line 107
    :cond_11
    and-int/lit8 v0, p4, 0x2

    if-eqz v0, :cond_19

    new-array v0, p3, [J

    iput-object v0, p0, Landroid/net/NetworkStatsHistory;->rxBytes:[J

    .line 108
    :cond_19
    and-int/lit8 v0, p4, 0x4

    if-eqz v0, :cond_21

    new-array v0, p3, [J

    iput-object v0, p0, Landroid/net/NetworkStatsHistory;->rxPackets:[J

    .line 109
    :cond_21
    and-int/lit8 v0, p4, 0x8

    if-eqz v0, :cond_29

    new-array v0, p3, [J

    iput-object v0, p0, Landroid/net/NetworkStatsHistory;->txBytes:[J

    .line 110
    :cond_29
    and-int/lit8 v0, p4, 0x10

    if-eqz v0, :cond_31

    new-array v0, p3, [J

    iput-object v0, p0, Landroid/net/NetworkStatsHistory;->txPackets:[J

    .line 111
    :cond_31
    and-int/lit8 v0, p4, 0x20

    if-eqz v0, :cond_39

    new-array v0, p3, [J

    iput-object v0, p0, Landroid/net/NetworkStatsHistory;->operations:[J

    .line 112
    :cond_39
    const/4 v0, 0x0

    iput v0, p0, Landroid/net/NetworkStatsHistory;->bucketCount:I

    .line 113
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Landroid/net/NetworkStatsHistory;->totalBytes:J

    .line 114
    return-void
.end method

.method public constructor <init>(Landroid/net/NetworkStatsHistory;J)V
    .registers 5
    .parameter "existing"
    .parameter "bucketDuration"

    .prologue
    .line 117
    invoke-virtual {p1, p2, p3}, Landroid/net/NetworkStatsHistory;->estimateResizeBuckets(J)I

    move-result v0

    invoke-direct {p0, p2, p3, v0}, Landroid/net/NetworkStatsHistory;-><init>(JI)V

    .line 118
    invoke-virtual {p0, p1}, Landroid/net/NetworkStatsHistory;->recordEntireHistory(Landroid/net/NetworkStatsHistory;)V

    .line 119
    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .registers 4
    .parameter "in"

    .prologue
    .line 121
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 122
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Landroid/net/NetworkStatsHistory;->bucketDuration:J

    .line 123
    invoke-static {p1}, Landroid/net/NetworkStatsHistory$ParcelUtils;->readLongArray(Landroid/os/Parcel;)[J

    move-result-object v0

    iput-object v0, p0, Landroid/net/NetworkStatsHistory;->bucketStart:[J

    .line 124
    invoke-static {p1}, Landroid/net/NetworkStatsHistory$ParcelUtils;->readLongArray(Landroid/os/Parcel;)[J

    move-result-object v0

    iput-object v0, p0, Landroid/net/NetworkStatsHistory;->activeTime:[J

    .line 125
    invoke-static {p1}, Landroid/net/NetworkStatsHistory$ParcelUtils;->readLongArray(Landroid/os/Parcel;)[J

    move-result-object v0

    iput-object v0, p0, Landroid/net/NetworkStatsHistory;->rxBytes:[J

    .line 126
    invoke-static {p1}, Landroid/net/NetworkStatsHistory$ParcelUtils;->readLongArray(Landroid/os/Parcel;)[J

    move-result-object v0

    iput-object v0, p0, Landroid/net/NetworkStatsHistory;->rxPackets:[J

    .line 127
    invoke-static {p1}, Landroid/net/NetworkStatsHistory$ParcelUtils;->readLongArray(Landroid/os/Parcel;)[J

    move-result-object v0

    iput-object v0, p0, Landroid/net/NetworkStatsHistory;->txBytes:[J

    .line 128
    invoke-static {p1}, Landroid/net/NetworkStatsHistory$ParcelUtils;->readLongArray(Landroid/os/Parcel;)[J

    move-result-object v0

    iput-object v0, p0, Landroid/net/NetworkStatsHistory;->txPackets:[J

    .line 129
    invoke-static {p1}, Landroid/net/NetworkStatsHistory$ParcelUtils;->readLongArray(Landroid/os/Parcel;)[J

    move-result-object v0

    iput-object v0, p0, Landroid/net/NetworkStatsHistory;->operations:[J

    .line 130
    iget-object v0, p0, Landroid/net/NetworkStatsHistory;->bucketStart:[J

    array-length v0, v0

    iput v0, p0, Landroid/net/NetworkStatsHistory;->bucketCount:I

    .line 131
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Landroid/net/NetworkStatsHistory;->totalBytes:J

    .line 132
    return-void
.end method

.method public constructor <init>(Ljava/io/DataInputStream;)V
    .registers 7
    .parameter "in"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 147
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 148
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readInt()I

    move-result v0

    .line 149
    .local v0, version:I
    packed-switch v0, :pswitch_data_b4

    .line 178
    new-instance v1, Ljava/net/ProtocolException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "unexpected version: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/net/ProtocolException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 151
    :pswitch_24
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readLong()J

    move-result-wide v1

    iput-wide v1, p0, Landroid/net/NetworkStatsHistory;->bucketDuration:J

    .line 152
    invoke-static {p1}, Landroid/net/NetworkStatsHistory$DataStreamUtils;->readFullLongArray(Ljava/io/DataInputStream;)[J

    move-result-object v1

    iput-object v1, p0, Landroid/net/NetworkStatsHistory;->bucketStart:[J

    .line 153
    invoke-static {p1}, Landroid/net/NetworkStatsHistory$DataStreamUtils;->readFullLongArray(Ljava/io/DataInputStream;)[J

    move-result-object v1

    iput-object v1, p0, Landroid/net/NetworkStatsHistory;->rxBytes:[J

    .line 154
    iget-object v1, p0, Landroid/net/NetworkStatsHistory;->bucketStart:[J

    array-length v1, v1

    new-array v1, v1, [J

    iput-object v1, p0, Landroid/net/NetworkStatsHistory;->rxPackets:[J

    .line 155
    invoke-static {p1}, Landroid/net/NetworkStatsHistory$DataStreamUtils;->readFullLongArray(Ljava/io/DataInputStream;)[J

    move-result-object v1

    iput-object v1, p0, Landroid/net/NetworkStatsHistory;->txBytes:[J

    .line 156
    iget-object v1, p0, Landroid/net/NetworkStatsHistory;->bucketStart:[J

    array-length v1, v1

    new-array v1, v1, [J

    iput-object v1, p0, Landroid/net/NetworkStatsHistory;->txPackets:[J

    .line 157
    iget-object v1, p0, Landroid/net/NetworkStatsHistory;->bucketStart:[J

    array-length v1, v1

    new-array v1, v1, [J

    iput-object v1, p0, Landroid/net/NetworkStatsHistory;->operations:[J

    .line 158
    iget-object v1, p0, Landroid/net/NetworkStatsHistory;->bucketStart:[J

    array-length v1, v1

    iput v1, p0, Landroid/net/NetworkStatsHistory;->bucketCount:I

    .line 159
    iget-object v1, p0, Landroid/net/NetworkStatsHistory;->rxBytes:[J

    invoke-static {v1}, Lcom/android/internal/util/ArrayUtils;->total([J)J

    move-result-wide v1

    iget-object v3, p0, Landroid/net/NetworkStatsHistory;->txBytes:[J

    invoke-static {v3}, Lcom/android/internal/util/ArrayUtils;->total([J)J

    move-result-wide v3

    add-long/2addr v1, v3

    iput-wide v1, p0, Landroid/net/NetworkStatsHistory;->totalBytes:J

    .line 181
    :goto_65
    return-void

    .line 164
    :pswitch_66
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readLong()J

    move-result-wide v1

    iput-wide v1, p0, Landroid/net/NetworkStatsHistory;->bucketDuration:J

    .line 165
    invoke-static {p1}, Landroid/net/NetworkStatsHistory$DataStreamUtils;->readVarLongArray(Ljava/io/DataInputStream;)[J

    move-result-object v1

    iput-object v1, p0, Landroid/net/NetworkStatsHistory;->bucketStart:[J

    .line 166
    const/4 v1, 0x3

    if-lt v0, v1, :cond_ae

    invoke-static {p1}, Landroid/net/NetworkStatsHistory$DataStreamUtils;->readVarLongArray(Ljava/io/DataInputStream;)[J

    move-result-object v1

    :goto_79
    iput-object v1, p0, Landroid/net/NetworkStatsHistory;->activeTime:[J

    .line 168
    invoke-static {p1}, Landroid/net/NetworkStatsHistory$DataStreamUtils;->readVarLongArray(Ljava/io/DataInputStream;)[J

    move-result-object v1

    iput-object v1, p0, Landroid/net/NetworkStatsHistory;->rxBytes:[J

    .line 169
    invoke-static {p1}, Landroid/net/NetworkStatsHistory$DataStreamUtils;->readVarLongArray(Ljava/io/DataInputStream;)[J

    move-result-object v1

    iput-object v1, p0, Landroid/net/NetworkStatsHistory;->rxPackets:[J

    .line 170
    invoke-static {p1}, Landroid/net/NetworkStatsHistory$DataStreamUtils;->readVarLongArray(Ljava/io/DataInputStream;)[J

    move-result-object v1

    iput-object v1, p0, Landroid/net/NetworkStatsHistory;->txBytes:[J

    .line 171
    invoke-static {p1}, Landroid/net/NetworkStatsHistory$DataStreamUtils;->readVarLongArray(Ljava/io/DataInputStream;)[J

    move-result-object v1

    iput-object v1, p0, Landroid/net/NetworkStatsHistory;->txPackets:[J

    .line 172
    invoke-static {p1}, Landroid/net/NetworkStatsHistory$DataStreamUtils;->readVarLongArray(Ljava/io/DataInputStream;)[J

    move-result-object v1

    iput-object v1, p0, Landroid/net/NetworkStatsHistory;->operations:[J

    .line 173
    iget-object v1, p0, Landroid/net/NetworkStatsHistory;->bucketStart:[J

    array-length v1, v1

    iput v1, p0, Landroid/net/NetworkStatsHistory;->bucketCount:I

    .line 174
    iget-object v1, p0, Landroid/net/NetworkStatsHistory;->rxBytes:[J

    invoke-static {v1}, Lcom/android/internal/util/ArrayUtils;->total([J)J

    move-result-wide v1

    iget-object v3, p0, Landroid/net/NetworkStatsHistory;->txBytes:[J

    invoke-static {v3}, Lcom/android/internal/util/ArrayUtils;->total([J)J

    move-result-wide v3

    add-long/2addr v1, v3

    iput-wide v1, p0, Landroid/net/NetworkStatsHistory;->totalBytes:J

    goto :goto_65

    .line 166
    :cond_ae
    iget-object v1, p0, Landroid/net/NetworkStatsHistory;->bucketStart:[J

    array-length v1, v1

    new-array v1, v1, [J

    goto :goto_79

    .line 149
    :pswitch_data_b4
    .packed-switch 0x1
        :pswitch_24
        :pswitch_66
        :pswitch_66
    .end packed-switch
.end method

.method private static addLong([JIJ)V
    .registers 6
    .parameter "array"
    .parameter "i"
    .parameter "value"

    .prologue
    .line 622
    if-eqz p0, :cond_7

    aget-wide v0, p0, p1

    add-long/2addr v0, p2

    aput-wide v0, p0, p1

    .line 623
    :cond_7
    return-void
.end method

.method private ensureBuckets(JJ)V
    .registers 12
    .parameter "start"
    .parameter "end"

    .prologue
    .line 379
    iget-wide v3, p0, Landroid/net/NetworkStatsHistory;->bucketDuration:J

    rem-long v3, p1, v3

    sub-long/2addr p1, v3

    .line 380
    iget-wide v3, p0, Landroid/net/NetworkStatsHistory;->bucketDuration:J

    iget-wide v5, p0, Landroid/net/NetworkStatsHistory;->bucketDuration:J

    rem-long v5, p3, v5

    sub-long/2addr v3, v5

    iget-wide v5, p0, Landroid/net/NetworkStatsHistory;->bucketDuration:J

    rem-long/2addr v3, v5

    add-long/2addr p3, v3

    .line 382
    move-wide v1, p1

    .local v1, now:J
    :goto_11
    cmp-long v3, v1, p3

    if-gez v3, :cond_29

    .line 384
    iget-object v3, p0, Landroid/net/NetworkStatsHistory;->bucketStart:[J

    const/4 v4, 0x0

    iget v5, p0, Landroid/net/NetworkStatsHistory;->bucketCount:I

    invoke-static {v3, v4, v5, v1, v2}, Ljava/util/Arrays;->binarySearch([JIIJ)I

    move-result v0

    .line 385
    .local v0, index:I
    if-gez v0, :cond_25

    .line 387
    xor-int/lit8 v3, v0, -0x1

    invoke-direct {p0, v3, v1, v2}, Landroid/net/NetworkStatsHistory;->insertBucket(IJ)V

    .line 382
    :cond_25
    iget-wide v3, p0, Landroid/net/NetworkStatsHistory;->bucketDuration:J

    add-long/2addr v1, v3

    goto :goto_11

    .line 390
    .end local v0           #index:I
    :cond_29
    return-void
.end method

.method private static getLong([JIJ)J
    .registers 4
    .parameter "array"
    .parameter "i"
    .parameter "value"

    .prologue
    .line 614
    if-eqz p0, :cond_4

    aget-wide p2, p0, p1

    .end local p2
    :cond_4
    return-wide p2
.end method

.method private insertBucket(IJ)V
    .registers 11
    .parameter "index"
    .parameter "start"

    .prologue
    const-wide/16 v5, 0x0

    .line 397
    iget v3, p0, Landroid/net/NetworkStatsHistory;->bucketCount:I

    iget-object v4, p0, Landroid/net/NetworkStatsHistory;->bucketStart:[J

    array-length v4, v4

    if-lt v3, v4, :cond_66

    .line 398
    iget-object v3, p0, Landroid/net/NetworkStatsHistory;->bucketStart:[J

    array-length v3, v3

    const/16 v4, 0xa

    invoke-static {v3, v4}, Ljava/lang/Math;->max(II)I

    move-result v3

    mul-int/lit8 v3, v3, 0x3

    div-int/lit8 v2, v3, 0x2

    .line 399
    .local v2, newLength:I
    iget-object v3, p0, Landroid/net/NetworkStatsHistory;->bucketStart:[J

    invoke-static {v3, v2}, Ljava/util/Arrays;->copyOf([JI)[J

    move-result-object v3

    iput-object v3, p0, Landroid/net/NetworkStatsHistory;->bucketStart:[J

    .line 400
    iget-object v3, p0, Landroid/net/NetworkStatsHistory;->activeTime:[J

    if-eqz v3, :cond_2a

    iget-object v3, p0, Landroid/net/NetworkStatsHistory;->activeTime:[J

    invoke-static {v3, v2}, Ljava/util/Arrays;->copyOf([JI)[J

    move-result-object v3

    iput-object v3, p0, Landroid/net/NetworkStatsHistory;->activeTime:[J

    .line 401
    :cond_2a
    iget-object v3, p0, Landroid/net/NetworkStatsHistory;->rxBytes:[J

    if-eqz v3, :cond_36

    iget-object v3, p0, Landroid/net/NetworkStatsHistory;->rxBytes:[J

    invoke-static {v3, v2}, Ljava/util/Arrays;->copyOf([JI)[J

    move-result-object v3

    iput-object v3, p0, Landroid/net/NetworkStatsHistory;->rxBytes:[J

    .line 402
    :cond_36
    iget-object v3, p0, Landroid/net/NetworkStatsHistory;->rxPackets:[J

    if-eqz v3, :cond_42

    iget-object v3, p0, Landroid/net/NetworkStatsHistory;->rxPackets:[J

    invoke-static {v3, v2}, Ljava/util/Arrays;->copyOf([JI)[J

    move-result-object v3

    iput-object v3, p0, Landroid/net/NetworkStatsHistory;->rxPackets:[J

    .line 403
    :cond_42
    iget-object v3, p0, Landroid/net/NetworkStatsHistory;->txBytes:[J

    if-eqz v3, :cond_4e

    iget-object v3, p0, Landroid/net/NetworkStatsHistory;->txBytes:[J

    invoke-static {v3, v2}, Ljava/util/Arrays;->copyOf([JI)[J

    move-result-object v3

    iput-object v3, p0, Landroid/net/NetworkStatsHistory;->txBytes:[J

    .line 404
    :cond_4e
    iget-object v3, p0, Landroid/net/NetworkStatsHistory;->txPackets:[J

    if-eqz v3, :cond_5a

    iget-object v3, p0, Landroid/net/NetworkStatsHistory;->txPackets:[J

    invoke-static {v3, v2}, Ljava/util/Arrays;->copyOf([JI)[J

    move-result-object v3

    iput-object v3, p0, Landroid/net/NetworkStatsHistory;->txPackets:[J

    .line 405
    :cond_5a
    iget-object v3, p0, Landroid/net/NetworkStatsHistory;->operations:[J

    if-eqz v3, :cond_66

    iget-object v3, p0, Landroid/net/NetworkStatsHistory;->operations:[J

    invoke-static {v3, v2}, Ljava/util/Arrays;->copyOf([JI)[J

    move-result-object v3

    iput-object v3, p0, Landroid/net/NetworkStatsHistory;->operations:[J

    .line 409
    .end local v2           #newLength:I
    :cond_66
    iget v3, p0, Landroid/net/NetworkStatsHistory;->bucketCount:I

    if-ge p1, v3, :cond_b9

    .line 410
    add-int/lit8 v0, p1, 0x1

    .line 411
    .local v0, dstPos:I
    iget v3, p0, Landroid/net/NetworkStatsHistory;->bucketCount:I

    sub-int v1, v3, p1

    .line 413
    .local v1, length:I
    iget-object v3, p0, Landroid/net/NetworkStatsHistory;->bucketStart:[J

    iget-object v4, p0, Landroid/net/NetworkStatsHistory;->bucketStart:[J

    invoke-static {v3, p1, v4, v0, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 414
    iget-object v3, p0, Landroid/net/NetworkStatsHistory;->activeTime:[J

    if-eqz v3, :cond_82

    iget-object v3, p0, Landroid/net/NetworkStatsHistory;->activeTime:[J

    iget-object v4, p0, Landroid/net/NetworkStatsHistory;->activeTime:[J

    invoke-static {v3, p1, v4, v0, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 415
    :cond_82
    iget-object v3, p0, Landroid/net/NetworkStatsHistory;->rxBytes:[J

    if-eqz v3, :cond_8d

    iget-object v3, p0, Landroid/net/NetworkStatsHistory;->rxBytes:[J

    iget-object v4, p0, Landroid/net/NetworkStatsHistory;->rxBytes:[J

    invoke-static {v3, p1, v4, v0, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 416
    :cond_8d
    iget-object v3, p0, Landroid/net/NetworkStatsHistory;->rxPackets:[J

    if-eqz v3, :cond_98

    iget-object v3, p0, Landroid/net/NetworkStatsHistory;->rxPackets:[J

    iget-object v4, p0, Landroid/net/NetworkStatsHistory;->rxPackets:[J

    invoke-static {v3, p1, v4, v0, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 417
    :cond_98
    iget-object v3, p0, Landroid/net/NetworkStatsHistory;->txBytes:[J

    if-eqz v3, :cond_a3

    iget-object v3, p0, Landroid/net/NetworkStatsHistory;->txBytes:[J

    iget-object v4, p0, Landroid/net/NetworkStatsHistory;->txBytes:[J

    invoke-static {v3, p1, v4, v0, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 418
    :cond_a3
    iget-object v3, p0, Landroid/net/NetworkStatsHistory;->txPackets:[J

    if-eqz v3, :cond_ae

    iget-object v3, p0, Landroid/net/NetworkStatsHistory;->txPackets:[J

    iget-object v4, p0, Landroid/net/NetworkStatsHistory;->txPackets:[J

    invoke-static {v3, p1, v4, v0, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 419
    :cond_ae
    iget-object v3, p0, Landroid/net/NetworkStatsHistory;->operations:[J

    if-eqz v3, :cond_b9

    iget-object v3, p0, Landroid/net/NetworkStatsHistory;->operations:[J

    iget-object v4, p0, Landroid/net/NetworkStatsHistory;->operations:[J

    invoke-static {v3, p1, v4, v0, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 422
    .end local v0           #dstPos:I
    .end local v1           #length:I
    :cond_b9
    iget-object v3, p0, Landroid/net/NetworkStatsHistory;->bucketStart:[J

    aput-wide p2, v3, p1

    .line 423
    iget-object v3, p0, Landroid/net/NetworkStatsHistory;->activeTime:[J

    invoke-static {v3, p1, v5, v6}, Landroid/net/NetworkStatsHistory;->setLong([JIJ)V

    .line 424
    iget-object v3, p0, Landroid/net/NetworkStatsHistory;->rxBytes:[J

    invoke-static {v3, p1, v5, v6}, Landroid/net/NetworkStatsHistory;->setLong([JIJ)V

    .line 425
    iget-object v3, p0, Landroid/net/NetworkStatsHistory;->rxPackets:[J

    invoke-static {v3, p1, v5, v6}, Landroid/net/NetworkStatsHistory;->setLong([JIJ)V

    .line 426
    iget-object v3, p0, Landroid/net/NetworkStatsHistory;->txBytes:[J

    invoke-static {v3, p1, v5, v6}, Landroid/net/NetworkStatsHistory;->setLong([JIJ)V

    .line 427
    iget-object v3, p0, Landroid/net/NetworkStatsHistory;->txPackets:[J

    invoke-static {v3, p1, v5, v6}, Landroid/net/NetworkStatsHistory;->setLong([JIJ)V

    .line 428
    iget-object v3, p0, Landroid/net/NetworkStatsHistory;->operations:[J

    invoke-static {v3, p1, v5, v6}, Landroid/net/NetworkStatsHistory;->setLong([JIJ)V

    .line 429
    iget v3, p0, Landroid/net/NetworkStatsHistory;->bucketCount:I

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Landroid/net/NetworkStatsHistory;->bucketCount:I

    .line 430
    return-void
.end method

.method public static randomLong(Ljava/util/Random;JJ)J
    .registers 9
    .parameter "r"
    .parameter "start"
    .parameter "end"

    .prologue
    .line 568
    long-to-float v0, p1

    invoke-virtual {p0}, Ljava/util/Random;->nextFloat()F

    move-result v1

    sub-long v2, p3, p1

    long-to-float v2, v2

    mul-float/2addr v1, v2

    add-float/2addr v0, v1

    float-to-long v0, v0

    return-wide v0
.end method

.method private static setLong([JIJ)V
    .registers 4
    .parameter "array"
    .parameter "i"
    .parameter "value"

    .prologue
    .line 618
    if-eqz p0, :cond_4

    aput-wide p2, p0, p1

    .line 619
    :cond_4
    return-void
.end method


# virtual methods
.method public describeContents()I
    .registers 2

    .prologue
    .line 197
    const/4 v0, 0x0

    return v0
.end method

.method public dump(Lcom/android/internal/util/IndentingPrintWriter;Z)V
    .registers 7
    .parameter "pw"
    .parameter "fullHistory"

    .prologue
    const/4 v1, 0x0

    .line 572
    const-string v2, "NetworkStatsHistory: bucketDuration="

    invoke-virtual {p1, v2}, Lcom/android/internal/util/IndentingPrintWriter;->print(Ljava/lang/String;)V

    iget-wide v2, p0, Landroid/net/NetworkStatsHistory;->bucketDuration:J

    invoke-virtual {p1, v2, v3}, Lcom/android/internal/util/IndentingPrintWriter;->println(J)V

    .line 573
    invoke-virtual {p1}, Lcom/android/internal/util/IndentingPrintWriter;->increaseIndent()V

    .line 575
    if-eqz p2, :cond_96

    .line 576
    .local v1, start:I
    :goto_10
    if-lez v1, :cond_1f

    .line 577
    const-string v2, "(omitting "

    invoke-virtual {p1, v2}, Lcom/android/internal/util/IndentingPrintWriter;->print(Ljava/lang/String;)V

    invoke-virtual {p1, v1}, Lcom/android/internal/util/IndentingPrintWriter;->print(I)V

    const-string v2, " buckets)"

    invoke-virtual {p1, v2}, Lcom/android/internal/util/IndentingPrintWriter;->println(Ljava/lang/String;)V

    .line 580
    :cond_1f
    move v0, v1

    .local v0, i:I
    :goto_20
    iget v2, p0, Landroid/net/NetworkStatsHistory;->bucketCount:I

    if-ge v0, v2, :cond_a0

    .line 581
    const-string v2, "bucketStart="

    invoke-virtual {p1, v2}, Lcom/android/internal/util/IndentingPrintWriter;->print(Ljava/lang/String;)V

    iget-object v2, p0, Landroid/net/NetworkStatsHistory;->bucketStart:[J

    aget-wide v2, v2, v0

    invoke-virtual {p1, v2, v3}, Lcom/android/internal/util/IndentingPrintWriter;->print(J)V

    .line 582
    iget-object v2, p0, Landroid/net/NetworkStatsHistory;->activeTime:[J

    if-eqz v2, :cond_40

    const-string v2, " activeTime="

    invoke-virtual {p1, v2}, Lcom/android/internal/util/IndentingPrintWriter;->print(Ljava/lang/String;)V

    iget-object v2, p0, Landroid/net/NetworkStatsHistory;->activeTime:[J

    aget-wide v2, v2, v0

    invoke-virtual {p1, v2, v3}, Lcom/android/internal/util/IndentingPrintWriter;->print(J)V

    .line 583
    :cond_40
    iget-object v2, p0, Landroid/net/NetworkStatsHistory;->rxBytes:[J

    if-eqz v2, :cond_50

    const-string v2, " rxBytes="

    invoke-virtual {p1, v2}, Lcom/android/internal/util/IndentingPrintWriter;->print(Ljava/lang/String;)V

    iget-object v2, p0, Landroid/net/NetworkStatsHistory;->rxBytes:[J

    aget-wide v2, v2, v0

    invoke-virtual {p1, v2, v3}, Lcom/android/internal/util/IndentingPrintWriter;->print(J)V

    .line 584
    :cond_50
    iget-object v2, p0, Landroid/net/NetworkStatsHistory;->rxPackets:[J

    if-eqz v2, :cond_60

    const-string v2, " rxPackets="

    invoke-virtual {p1, v2}, Lcom/android/internal/util/IndentingPrintWriter;->print(Ljava/lang/String;)V

    iget-object v2, p0, Landroid/net/NetworkStatsHistory;->rxPackets:[J

    aget-wide v2, v2, v0

    invoke-virtual {p1, v2, v3}, Lcom/android/internal/util/IndentingPrintWriter;->print(J)V

    .line 585
    :cond_60
    iget-object v2, p0, Landroid/net/NetworkStatsHistory;->txBytes:[J

    if-eqz v2, :cond_70

    const-string v2, " txBytes="

    invoke-virtual {p1, v2}, Lcom/android/internal/util/IndentingPrintWriter;->print(Ljava/lang/String;)V

    iget-object v2, p0, Landroid/net/NetworkStatsHistory;->txBytes:[J

    aget-wide v2, v2, v0

    invoke-virtual {p1, v2, v3}, Lcom/android/internal/util/IndentingPrintWriter;->print(J)V

    .line 586
    :cond_70
    iget-object v2, p0, Landroid/net/NetworkStatsHistory;->txPackets:[J

    if-eqz v2, :cond_80

    const-string v2, " txPackets="

    invoke-virtual {p1, v2}, Lcom/android/internal/util/IndentingPrintWriter;->print(Ljava/lang/String;)V

    iget-object v2, p0, Landroid/net/NetworkStatsHistory;->txPackets:[J

    aget-wide v2, v2, v0

    invoke-virtual {p1, v2, v3}, Lcom/android/internal/util/IndentingPrintWriter;->print(J)V

    .line 587
    :cond_80
    iget-object v2, p0, Landroid/net/NetworkStatsHistory;->operations:[J

    if-eqz v2, :cond_90

    const-string v2, " operations="

    invoke-virtual {p1, v2}, Lcom/android/internal/util/IndentingPrintWriter;->print(Ljava/lang/String;)V

    iget-object v2, p0, Landroid/net/NetworkStatsHistory;->operations:[J

    aget-wide v2, v2, v0

    invoke-virtual {p1, v2, v3}, Lcom/android/internal/util/IndentingPrintWriter;->print(J)V

    .line 588
    :cond_90
    invoke-virtual {p1}, Lcom/android/internal/util/IndentingPrintWriter;->println()V

    .line 580
    add-int/lit8 v0, v0, 0x1

    goto :goto_20

    .line 575
    .end local v0           #i:I
    .end local v1           #start:I
    :cond_96
    iget v2, p0, Landroid/net/NetworkStatsHistory;->bucketCount:I

    add-int/lit8 v2, v2, -0x20

    invoke-static {v1, v2}, Ljava/lang/Math;->max(II)I

    move-result v1

    goto/16 :goto_10

    .line 591
    .restart local v0       #i:I
    .restart local v1       #start:I
    :cond_a0
    invoke-virtual {p1}, Lcom/android/internal/util/IndentingPrintWriter;->decreaseIndent()V

    .line 592
    return-void
.end method

.method public estimateResizeBuckets(J)I
    .registers 7
    .parameter "newBucketDuration"

    .prologue
    .line 626
    invoke-virtual {p0}, Landroid/net/NetworkStatsHistory;->size()I

    move-result v0

    int-to-long v0, v0

    invoke-virtual {p0}, Landroid/net/NetworkStatsHistory;->getBucketDuration()J

    move-result-wide v2

    mul-long/2addr v0, v2

    div-long/2addr v0, p1

    long-to-int v0, v0

    return v0
.end method

.method public generateRandom(JJJ)V
    .registers 26
    .parameter "start"
    .parameter "end"
    .parameter "bytes"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 523
    new-instance v17, Ljava/util/Random;

    invoke-direct/range {v17 .. v17}, Ljava/util/Random;-><init>()V

    .line 525
    .local v17, r:Ljava/util/Random;
    invoke-virtual/range {v17 .. v17}, Ljava/util/Random;->nextFloat()F

    move-result v18

    .line 526
    .local v18, fractionRx:F
    move-wide/from16 v0, p5

    long-to-float v2, v0

    mul-float v2, v2, v18

    float-to-long v7, v2

    .line 527
    .local v7, rxBytes:J
    move-wide/from16 v0, p5

    long-to-float v2, v0

    const/high16 v3, 0x3f80

    sub-float v3, v3, v18

    mul-float/2addr v2, v3

    float-to-long v11, v2

    .line 529
    .local v11, txBytes:J
    const-wide/16 v2, 0x400

    div-long v9, v7, v2

    .line 530
    .local v9, rxPackets:J
    const-wide/16 v2, 0x400

    div-long v13, v11, v2

    .line 531
    .local v13, txPackets:J
    const-wide/16 v2, 0x800

    div-long v15, v7, v2

    .local v15, operations:J
    move-object/from16 v2, p0

    move-wide/from16 v3, p1

    move-wide/from16 v5, p3

    .line 533
    invoke-virtual/range {v2 .. v17}, Landroid/net/NetworkStatsHistory;->generateRandom(JJJJJJJLjava/util/Random;)V

    .line 534
    return-void
.end method

.method public generateRandom(JJJJJJJLjava/util/Random;)V
    .registers 36
    .parameter "start"
    .parameter "end"
    .parameter "rxBytes"
    .parameter "rxPackets"
    .parameter "txBytes"
    .parameter "txPackets"
    .parameter "operations"
    .parameter "r"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 542
    invoke-direct/range {p0 .. p4}, Landroid/net/NetworkStatsHistory;->ensureBuckets(JJ)V

    .line 544
    new-instance v5, Landroid/net/NetworkStats$Entry;

    sget-object v6, Landroid/net/NetworkStats;->IFACE_ALL:Ljava/lang/String;

    const/4 v7, -0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v12, 0x0

    const-wide/16 v14, 0x0

    const-wide/16 v16, 0x0

    const-wide/16 v18, 0x0

    invoke-direct/range {v5 .. v19}, Landroid/net/NetworkStats$Entry;-><init>(Ljava/lang/String;IIIJJJJJ)V

    .line 547
    .local v5, entry:Landroid/net/NetworkStats$Entry;
    :goto_17
    const-wide/16 v11, 0x400

    cmp-long v6, p5, v11

    if-gtz v6, :cond_35

    const-wide/16 v11, 0x80

    cmp-long v6, p7, v11

    if-gtz v6, :cond_35

    const-wide/16 v11, 0x400

    cmp-long v6, p9, v11

    if-gtz v6, :cond_35

    const-wide/16 v11, 0x80

    cmp-long v6, p11, v11

    if-gtz v6, :cond_35

    const-wide/16 v11, 0x20

    cmp-long v6, p13, v11

    if-lez v6, :cond_a6

    .line 548
    :cond_35
    move-object/from16 v0, p15

    move-wide/from16 v1, p1

    move-wide/from16 v3, p3

    invoke-static {v0, v1, v2, v3, v4}, Landroid/net/NetworkStatsHistory;->randomLong(Ljava/util/Random;JJ)J

    move-result-wide v7

    .line 549
    .local v7, curStart:J
    const-wide/16 v11, 0x0

    sub-long v13, p3, v7

    const-wide/16 v15, 0x2

    div-long/2addr v13, v15

    move-object/from16 v0, p15

    invoke-static {v0, v11, v12, v13, v14}, Landroid/net/NetworkStatsHistory;->randomLong(Ljava/util/Random;JJ)J

    move-result-wide v11

    add-long v9, v7, v11

    .line 551
    .local v9, curEnd:J
    const-wide/16 v11, 0x0

    move-object/from16 v0, p15

    move-wide/from16 v1, p5

    invoke-static {v0, v11, v12, v1, v2}, Landroid/net/NetworkStatsHistory;->randomLong(Ljava/util/Random;JJ)J

    move-result-wide v11

    iput-wide v11, v5, Landroid/net/NetworkStats$Entry;->rxBytes:J

    .line 552
    const-wide/16 v11, 0x0

    move-object/from16 v0, p15

    move-wide/from16 v1, p7

    invoke-static {v0, v11, v12, v1, v2}, Landroid/net/NetworkStatsHistory;->randomLong(Ljava/util/Random;JJ)J

    move-result-wide v11

    iput-wide v11, v5, Landroid/net/NetworkStats$Entry;->rxPackets:J

    .line 553
    const-wide/16 v11, 0x0

    move-object/from16 v0, p15

    move-wide/from16 v1, p9

    invoke-static {v0, v11, v12, v1, v2}, Landroid/net/NetworkStatsHistory;->randomLong(Ljava/util/Random;JJ)J

    move-result-wide v11

    iput-wide v11, v5, Landroid/net/NetworkStats$Entry;->txBytes:J

    .line 554
    const-wide/16 v11, 0x0

    move-object/from16 v0, p15

    move-wide/from16 v1, p11

    invoke-static {v0, v11, v12, v1, v2}, Landroid/net/NetworkStatsHistory;->randomLong(Ljava/util/Random;JJ)J

    move-result-wide v11

    iput-wide v11, v5, Landroid/net/NetworkStats$Entry;->txPackets:J

    .line 555
    const-wide/16 v11, 0x0

    move-object/from16 v0, p15

    move-wide/from16 v1, p13

    invoke-static {v0, v11, v12, v1, v2}, Landroid/net/NetworkStatsHistory;->randomLong(Ljava/util/Random;JJ)J

    move-result-wide v11

    iput-wide v11, v5, Landroid/net/NetworkStats$Entry;->operations:J

    .line 557
    iget-wide v11, v5, Landroid/net/NetworkStats$Entry;->rxBytes:J

    sub-long p5, p5, v11

    .line 558
    iget-wide v11, v5, Landroid/net/NetworkStats$Entry;->rxPackets:J

    sub-long p7, p7, v11

    .line 559
    iget-wide v11, v5, Landroid/net/NetworkStats$Entry;->txBytes:J

    sub-long p9, p9, v11

    .line 560
    iget-wide v11, v5, Landroid/net/NetworkStats$Entry;->txPackets:J

    sub-long p11, p11, v11

    .line 561
    iget-wide v11, v5, Landroid/net/NetworkStats$Entry;->operations:J

    sub-long p13, p13, v11

    move-object/from16 v6, p0

    move-object v11, v5

    .line 563
    invoke-virtual/range {v6 .. v11}, Landroid/net/NetworkStatsHistory;->recordData(JJLandroid/net/NetworkStats$Entry;)V

    goto/16 :goto_17

    .line 565
    .end local v7           #curStart:J
    .end local v9           #curEnd:J
    :cond_a6
    return-void
.end method

.method public getBucketDuration()J
    .registers 3

    .prologue
    .line 205
    iget-wide v0, p0, Landroid/net/NetworkStatsHistory;->bucketDuration:J

    return-wide v0
.end method

.method public getEnd()J
    .registers 5

    .prologue
    .line 217
    iget v0, p0, Landroid/net/NetworkStatsHistory;->bucketCount:I

    if-lez v0, :cond_10

    .line 218
    iget-object v0, p0, Landroid/net/NetworkStatsHistory;->bucketStart:[J

    iget v1, p0, Landroid/net/NetworkStatsHistory;->bucketCount:I

    add-int/lit8 v1, v1, -0x1

    aget-wide v0, v0, v1

    iget-wide v2, p0, Landroid/net/NetworkStatsHistory;->bucketDuration:J

    add-long/2addr v0, v2

    .line 220
    :goto_f
    return-wide v0

    :cond_10
    const-wide/high16 v0, -0x8000

    goto :goto_f
.end method

.method public getIndexAfter(J)I
    .registers 7
    .parameter "time"

    .prologue
    const/4 v3, 0x0

    .line 250
    iget-object v1, p0, Landroid/net/NetworkStatsHistory;->bucketStart:[J

    iget v2, p0, Landroid/net/NetworkStatsHistory;->bucketCount:I

    invoke-static {v1, v3, v2, p1, p2}, Ljava/util/Arrays;->binarySearch([JIIJ)I

    move-result v0

    .line 251
    .local v0, index:I
    if-gez v0, :cond_16

    .line 252
    xor-int/lit8 v0, v0, -0x1

    .line 256
    :goto_d
    iget v1, p0, Landroid/net/NetworkStatsHistory;->bucketCount:I

    add-int/lit8 v1, v1, -0x1

    invoke-static {v0, v3, v1}, Landroid/util/MathUtils;->constrain(III)I

    move-result v1

    return v1

    .line 254
    :cond_16
    add-int/lit8 v0, v0, 0x1

    goto :goto_d
.end method

.method public getIndexBefore(J)I
    .registers 7
    .parameter "time"

    .prologue
    const/4 v3, 0x0

    .line 236
    iget-object v1, p0, Landroid/net/NetworkStatsHistory;->bucketStart:[J

    iget v2, p0, Landroid/net/NetworkStatsHistory;->bucketCount:I

    invoke-static {v1, v3, v2, p1, p2}, Ljava/util/Arrays;->binarySearch([JIIJ)I

    move-result v0

    .line 237
    .local v0, index:I
    if-gez v0, :cond_18

    .line 238
    xor-int/lit8 v1, v0, -0x1

    add-int/lit8 v0, v1, -0x1

    .line 242
    :goto_f
    iget v1, p0, Landroid/net/NetworkStatsHistory;->bucketCount:I

    add-int/lit8 v1, v1, -0x1

    invoke-static {v0, v3, v1}, Landroid/util/MathUtils;->constrain(III)I

    move-result v1

    return v1

    .line 240
    :cond_18
    add-int/lit8 v0, v0, -0x1

    goto :goto_f
.end method

.method public getStart()J
    .registers 3

    .prologue
    .line 209
    iget v0, p0, Landroid/net/NetworkStatsHistory;->bucketCount:I

    if-lez v0, :cond_a

    .line 210
    iget-object v0, p0, Landroid/net/NetworkStatsHistory;->bucketStart:[J

    const/4 v1, 0x0

    aget-wide v0, v0, v1

    .line 212
    :goto_9
    return-wide v0

    :cond_a
    const-wide v0, 0x7fffffffffffffffL

    goto :goto_9
.end method

.method public getTotalBytes()J
    .registers 3

    .prologue
    .line 228
    iget-wide v0, p0, Landroid/net/NetworkStatsHistory;->totalBytes:J

    return-wide v0
.end method

.method public getValues(ILandroid/net/NetworkStatsHistory$Entry;)Landroid/net/NetworkStatsHistory$Entry;
    .registers 8
    .parameter "i"
    .parameter "recycle"

    .prologue
    const-wide/16 v3, -0x1

    .line 263
    if-eqz p2, :cond_40

    move-object v0, p2

    .line 264
    .local v0, entry:Landroid/net/NetworkStatsHistory$Entry;
    :goto_5
    iget-object v1, p0, Landroid/net/NetworkStatsHistory;->bucketStart:[J

    aget-wide v1, v1, p1

    iput-wide v1, v0, Landroid/net/NetworkStatsHistory$Entry;->bucketStart:J

    .line 265
    iget-wide v1, p0, Landroid/net/NetworkStatsHistory;->bucketDuration:J

    iput-wide v1, v0, Landroid/net/NetworkStatsHistory$Entry;->bucketDuration:J

    .line 266
    iget-object v1, p0, Landroid/net/NetworkStatsHistory;->activeTime:[J

    invoke-static {v1, p1, v3, v4}, Landroid/net/NetworkStatsHistory;->getLong([JIJ)J

    move-result-wide v1

    iput-wide v1, v0, Landroid/net/NetworkStatsHistory$Entry;->activeTime:J

    .line 267
    iget-object v1, p0, Landroid/net/NetworkStatsHistory;->rxBytes:[J

    invoke-static {v1, p1, v3, v4}, Landroid/net/NetworkStatsHistory;->getLong([JIJ)J

    move-result-wide v1

    iput-wide v1, v0, Landroid/net/NetworkStatsHistory$Entry;->rxBytes:J

    .line 268
    iget-object v1, p0, Landroid/net/NetworkStatsHistory;->rxPackets:[J

    invoke-static {v1, p1, v3, v4}, Landroid/net/NetworkStatsHistory;->getLong([JIJ)J

    move-result-wide v1

    iput-wide v1, v0, Landroid/net/NetworkStatsHistory$Entry;->rxPackets:J

    .line 269
    iget-object v1, p0, Landroid/net/NetworkStatsHistory;->txBytes:[J

    invoke-static {v1, p1, v3, v4}, Landroid/net/NetworkStatsHistory;->getLong([JIJ)J

    move-result-wide v1

    iput-wide v1, v0, Landroid/net/NetworkStatsHistory$Entry;->txBytes:J

    .line 270
    iget-object v1, p0, Landroid/net/NetworkStatsHistory;->txPackets:[J

    invoke-static {v1, p1, v3, v4}, Landroid/net/NetworkStatsHistory;->getLong([JIJ)J

    move-result-wide v1

    iput-wide v1, v0, Landroid/net/NetworkStatsHistory$Entry;->txPackets:J

    .line 271
    iget-object v1, p0, Landroid/net/NetworkStatsHistory;->operations:[J

    invoke-static {v1, p1, v3, v4}, Landroid/net/NetworkStatsHistory;->getLong([JIJ)J

    move-result-wide v1

    iput-wide v1, v0, Landroid/net/NetworkStatsHistory$Entry;->operations:J

    .line 272
    return-object v0

    .line 263
    .end local v0           #entry:Landroid/net/NetworkStatsHistory$Entry;
    :cond_40
    new-instance v0, Landroid/net/NetworkStatsHistory$Entry;

    invoke-direct {v0}, Landroid/net/NetworkStatsHistory$Entry;-><init>()V

    goto :goto_5
.end method

.method public getValues(JJJLandroid/net/NetworkStatsHistory$Entry;)Landroid/net/NetworkStatsHistory$Entry;
    .registers 31
    .parameter "start"
    .parameter "end"
    .parameter "now"
    .parameter "recycle"

    .prologue
    .line 475
    if-eqz p7, :cond_83

    move-object/from16 v8, p7

    .line 476
    .local v8, entry:Landroid/net/NetworkStatsHistory$Entry;
    :goto_4
    sub-long v17, p3, p1

    move-wide/from16 v0, v17

    iput-wide v0, v8, Landroid/net/NetworkStatsHistory$Entry;->bucketDuration:J

    .line 477
    move-wide/from16 v0, p1

    iput-wide v0, v8, Landroid/net/NetworkStatsHistory$Entry;->bucketStart:J

    .line 478
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/net/NetworkStatsHistory;->activeTime:[J

    move-object/from16 v17, v0

    if-eqz v17, :cond_8a

    const-wide/16 v17, 0x0

    :goto_18
    move-wide/from16 v0, v17

    iput-wide v0, v8, Landroid/net/NetworkStatsHistory$Entry;->activeTime:J

    .line 479
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/net/NetworkStatsHistory;->rxBytes:[J

    move-object/from16 v17, v0

    if-eqz v17, :cond_8d

    const-wide/16 v17, 0x0

    :goto_26
    move-wide/from16 v0, v17

    iput-wide v0, v8, Landroid/net/NetworkStatsHistory$Entry;->rxBytes:J

    .line 480
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/net/NetworkStatsHistory;->rxPackets:[J

    move-object/from16 v17, v0

    if-eqz v17, :cond_90

    const-wide/16 v17, 0x0

    :goto_34
    move-wide/from16 v0, v17

    iput-wide v0, v8, Landroid/net/NetworkStatsHistory$Entry;->rxPackets:J

    .line 481
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/net/NetworkStatsHistory;->txBytes:[J

    move-object/from16 v17, v0

    if-eqz v17, :cond_93

    const-wide/16 v17, 0x0

    :goto_42
    move-wide/from16 v0, v17

    iput-wide v0, v8, Landroid/net/NetworkStatsHistory$Entry;->txBytes:J

    .line 482
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/net/NetworkStatsHistory;->txPackets:[J

    move-object/from16 v17, v0

    if-eqz v17, :cond_96

    const-wide/16 v17, 0x0

    :goto_50
    move-wide/from16 v0, v17

    iput-wide v0, v8, Landroid/net/NetworkStatsHistory$Entry;->txPackets:J

    .line 483
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/net/NetworkStatsHistory;->operations:[J

    move-object/from16 v17, v0

    if-eqz v17, :cond_99

    const-wide/16 v17, 0x0

    :goto_5e
    move-wide/from16 v0, v17

    iput-wide v0, v8, Landroid/net/NetworkStatsHistory$Entry;->operations:J

    .line 485
    move-object/from16 v0, p0

    move-wide/from16 v1, p3

    invoke-virtual {v0, v1, v2}, Landroid/net/NetworkStatsHistory;->getIndexAfter(J)I

    move-result v16

    .line 486
    .local v16, startIndex:I
    move/from16 v9, v16

    .local v9, i:I
    :goto_6c
    if-ltz v9, :cond_82

    .line 487
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/net/NetworkStatsHistory;->bucketStart:[J

    move-object/from16 v17, v0

    aget-wide v6, v17, v9

    .line 488
    .local v6, curStart:J
    move-object/from16 v0, p0

    iget-wide v0, v0, Landroid/net/NetworkStatsHistory;->bucketDuration:J

    move-wide/from16 v17, v0

    add-long v4, v6, v17

    .line 491
    .local v4, curEnd:J
    cmp-long v17, v4, p1

    if-gtz v17, :cond_9c

    .line 515
    .end local v4           #curEnd:J
    .end local v6           #curStart:J
    :cond_82
    return-object v8

    .line 475
    .end local v8           #entry:Landroid/net/NetworkStatsHistory$Entry;
    .end local v9           #i:I
    .end local v16           #startIndex:I
    :cond_83
    new-instance v8, Landroid/net/NetworkStatsHistory$Entry;

    invoke-direct {v8}, Landroid/net/NetworkStatsHistory$Entry;-><init>()V

    goto/16 :goto_4

    .line 478
    .restart local v8       #entry:Landroid/net/NetworkStatsHistory$Entry;
    :cond_8a
    const-wide/16 v17, -0x1

    goto :goto_18

    .line 479
    :cond_8d
    const-wide/16 v17, -0x1

    goto :goto_26

    .line 480
    :cond_90
    const-wide/16 v17, -0x1

    goto :goto_34

    .line 481
    :cond_93
    const-wide/16 v17, -0x1

    goto :goto_42

    .line 482
    :cond_96
    const-wide/16 v17, -0x1

    goto :goto_50

    .line 483
    :cond_99
    const-wide/16 v17, -0x1

    goto :goto_5e

    .line 493
    .restart local v4       #curEnd:J
    .restart local v6       #curStart:J
    .restart local v9       #i:I
    .restart local v16       #startIndex:I
    :cond_9c
    cmp-long v17, v6, p3

    if-ltz v17, :cond_a3

    .line 486
    :cond_a0
    :goto_a0
    add-int/lit8 v9, v9, -0x1

    goto :goto_6c

    .line 496
    :cond_a3
    cmp-long v17, v6, p5

    if-gez v17, :cond_192

    cmp-long v17, v4, p5

    if-lez v17, :cond_192

    const/4 v3, 0x1

    .line 498
    .local v3, activeBucket:Z
    :goto_ac
    if-eqz v3, :cond_195

    .line 499
    move-object/from16 v0, p0

    iget-wide v10, v0, Landroid/net/NetworkStatsHistory;->bucketDuration:J

    .line 505
    .local v10, overlap:J
    :goto_b2
    const-wide/16 v17, 0x0

    cmp-long v17, v10, v17

    if-lez v17, :cond_a0

    .line 508
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/net/NetworkStatsHistory;->activeTime:[J

    move-object/from16 v17, v0

    if-eqz v17, :cond_dc

    iget-wide v0, v8, Landroid/net/NetworkStatsHistory$Entry;->activeTime:J

    move-wide/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/net/NetworkStatsHistory;->activeTime:[J

    move-object/from16 v19, v0

    aget-wide v19, v19, v9

    mul-long v19, v19, v10

    move-object/from16 v0, p0

    iget-wide v0, v0, Landroid/net/NetworkStatsHistory;->bucketDuration:J

    move-wide/from16 v21, v0

    div-long v19, v19, v21

    add-long v17, v17, v19

    move-wide/from16 v0, v17

    iput-wide v0, v8, Landroid/net/NetworkStatsHistory$Entry;->activeTime:J

    .line 509
    :cond_dc
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/net/NetworkStatsHistory;->rxBytes:[J

    move-object/from16 v17, v0

    if-eqz v17, :cond_100

    iget-wide v0, v8, Landroid/net/NetworkStatsHistory$Entry;->rxBytes:J

    move-wide/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/net/NetworkStatsHistory;->rxBytes:[J

    move-object/from16 v19, v0

    aget-wide v19, v19, v9

    mul-long v19, v19, v10

    move-object/from16 v0, p0

    iget-wide v0, v0, Landroid/net/NetworkStatsHistory;->bucketDuration:J

    move-wide/from16 v21, v0

    div-long v19, v19, v21

    add-long v17, v17, v19

    move-wide/from16 v0, v17

    iput-wide v0, v8, Landroid/net/NetworkStatsHistory$Entry;->rxBytes:J

    .line 510
    :cond_100
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/net/NetworkStatsHistory;->rxPackets:[J

    move-object/from16 v17, v0

    if-eqz v17, :cond_124

    iget-wide v0, v8, Landroid/net/NetworkStatsHistory$Entry;->rxPackets:J

    move-wide/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/net/NetworkStatsHistory;->rxPackets:[J

    move-object/from16 v19, v0

    aget-wide v19, v19, v9

    mul-long v19, v19, v10

    move-object/from16 v0, p0

    iget-wide v0, v0, Landroid/net/NetworkStatsHistory;->bucketDuration:J

    move-wide/from16 v21, v0

    div-long v19, v19, v21

    add-long v17, v17, v19

    move-wide/from16 v0, v17

    iput-wide v0, v8, Landroid/net/NetworkStatsHistory$Entry;->rxPackets:J

    .line 511
    :cond_124
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/net/NetworkStatsHistory;->txBytes:[J

    move-object/from16 v17, v0

    if-eqz v17, :cond_148

    iget-wide v0, v8, Landroid/net/NetworkStatsHistory$Entry;->txBytes:J

    move-wide/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/net/NetworkStatsHistory;->txBytes:[J

    move-object/from16 v19, v0

    aget-wide v19, v19, v9

    mul-long v19, v19, v10

    move-object/from16 v0, p0

    iget-wide v0, v0, Landroid/net/NetworkStatsHistory;->bucketDuration:J

    move-wide/from16 v21, v0

    div-long v19, v19, v21

    add-long v17, v17, v19

    move-wide/from16 v0, v17

    iput-wide v0, v8, Landroid/net/NetworkStatsHistory$Entry;->txBytes:J

    .line 512
    :cond_148
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/net/NetworkStatsHistory;->txPackets:[J

    move-object/from16 v17, v0

    if-eqz v17, :cond_16c

    iget-wide v0, v8, Landroid/net/NetworkStatsHistory$Entry;->txPackets:J

    move-wide/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/net/NetworkStatsHistory;->txPackets:[J

    move-object/from16 v19, v0

    aget-wide v19, v19, v9

    mul-long v19, v19, v10

    move-object/from16 v0, p0

    iget-wide v0, v0, Landroid/net/NetworkStatsHistory;->bucketDuration:J

    move-wide/from16 v21, v0

    div-long v19, v19, v21

    add-long v17, v17, v19

    move-wide/from16 v0, v17

    iput-wide v0, v8, Landroid/net/NetworkStatsHistory$Entry;->txPackets:J

    .line 513
    :cond_16c
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/net/NetworkStatsHistory;->operations:[J

    move-object/from16 v17, v0

    if-eqz v17, :cond_a0

    iget-wide v0, v8, Landroid/net/NetworkStatsHistory$Entry;->operations:J

    move-wide/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/net/NetworkStatsHistory;->operations:[J

    move-object/from16 v19, v0

    aget-wide v19, v19, v9

    mul-long v19, v19, v10

    move-object/from16 v0, p0

    iget-wide v0, v0, Landroid/net/NetworkStatsHistory;->bucketDuration:J

    move-wide/from16 v21, v0

    div-long v19, v19, v21

    add-long v17, v17, v19

    move-wide/from16 v0, v17

    iput-wide v0, v8, Landroid/net/NetworkStatsHistory$Entry;->operations:J

    goto/16 :goto_a0

    .line 496
    .end local v3           #activeBucket:Z
    .end local v10           #overlap:J
    :cond_192
    const/4 v3, 0x0

    goto/16 :goto_ac

    .line 501
    .restart local v3       #activeBucket:Z
    :cond_195
    cmp-long v17, v4, p3

    if-gez v17, :cond_1a3

    move-wide v12, v4

    .line 502
    .local v12, overlapEnd:J
    :goto_19a
    cmp-long v17, v6, p1

    if-lez v17, :cond_1a6

    move-wide v14, v6

    .line 503
    .local v14, overlapStart:J
    :goto_19f
    sub-long v10, v12, v14

    .restart local v10       #overlap:J
    goto/16 :goto_b2

    .end local v10           #overlap:J
    .end local v12           #overlapEnd:J
    .end local v14           #overlapStart:J
    :cond_1a3
    move-wide/from16 v12, p3

    .line 501
    goto :goto_19a

    .restart local v12       #overlapEnd:J
    :cond_1a6
    move-wide/from16 v14, p1

    .line 502
    goto :goto_19f
.end method

.method public getValues(JJLandroid/net/NetworkStatsHistory$Entry;)Landroid/net/NetworkStatsHistory$Entry;
    .registers 14
    .parameter "start"
    .parameter "end"
    .parameter "recycle"

    .prologue
    .line 467
    const-wide v5, 0x7fffffffffffffffL

    move-object v0, p0

    move-wide v1, p1

    move-wide v3, p3

    move-object v7, p5

    invoke-virtual/range {v0 .. v7}, Landroid/net/NetworkStatsHistory;->getValues(JJJLandroid/net/NetworkStatsHistory$Entry;)Landroid/net/NetworkStatsHistory$Entry;

    move-result-object v0

    return-object v0
.end method

.method public recordData(JJJJ)V
    .registers 24
    .parameter "start"
    .parameter "end"
    .parameter "rxBytes"
    .parameter "txBytes"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 281
    new-instance v0, Landroid/net/NetworkStats$Entry;

    sget-object v1, Landroid/net/NetworkStats;->IFACE_ALL:Ljava/lang/String;

    const/4 v2, -0x1

    const/4 v3, 0x0

    const/4 v4, 0x0

    const-wide/16 v7, 0x0

    const-wide/16 v11, 0x0

    const-wide/16 v13, 0x0

    move-wide/from16 v5, p5

    move-wide/from16 v9, p7

    invoke-direct/range {v0 .. v14}, Landroid/net/NetworkStats$Entry;-><init>(Ljava/lang/String;IIIJJJJJ)V

    move-object v1, p0

    move-wide/from16 v2, p1

    move-wide/from16 v4, p3

    move-object v6, v0

    invoke-virtual/range {v1 .. v6}, Landroid/net/NetworkStatsHistory;->recordData(JJLandroid/net/NetworkStats$Entry;)V

    .line 283
    return-void
.end method

.method public recordData(JJLandroid/net/NetworkStats$Entry;)V
    .registers 46
    .parameter "start"
    .parameter "end"
    .parameter "entry"

    .prologue
    .line 290
    move-object/from16 v0, p5

    iget-wide v0, v0, Landroid/net/NetworkStats$Entry;->rxBytes:J

    move-wide/from16 v25, v0

    .line 291
    .local v25, rxBytes:J
    move-object/from16 v0, p5

    iget-wide v0, v0, Landroid/net/NetworkStats$Entry;->rxPackets:J

    move-wide/from16 v27, v0

    .line 292
    .local v27, rxPackets:J
    move-object/from16 v0, p5

    iget-wide v0, v0, Landroid/net/NetworkStats$Entry;->txBytes:J

    move-wide/from16 v30, v0

    .line 293
    .local v30, txBytes:J
    move-object/from16 v0, p5

    iget-wide v0, v0, Landroid/net/NetworkStats$Entry;->txPackets:J

    move-wide/from16 v32, v0

    .line 294
    .local v32, txPackets:J
    move-object/from16 v0, p5

    iget-wide v0, v0, Landroid/net/NetworkStats$Entry;->operations:J

    move-wide/from16 v21, v0

    .line 296
    .local v21, operations:J
    invoke-virtual/range {p5 .. p5}, Landroid/net/NetworkStats$Entry;->isNegative()Z

    move-result v34

    if-eqz v34, :cond_2d

    .line 297
    new-instance v34, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v35, "tried recording negative data"

    invoke-direct/range {v34 .. v35}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v34

    .line 299
    :cond_2d
    invoke-virtual/range {p5 .. p5}, Landroid/net/NetworkStats$Entry;->isEmpty()Z

    move-result v34

    if-eqz v34, :cond_34

    .line 339
    :goto_33
    return-void

    .line 304
    :cond_34
    invoke-direct/range {p0 .. p4}, Landroid/net/NetworkStatsHistory;->ensureBuckets(JJ)V

    .line 307
    sub-long v8, p3, p1

    .line 308
    .local v8, duration:J
    move-object/from16 v0, p0

    move-wide/from16 v1, p3

    invoke-virtual {v0, v1, v2}, Landroid/net/NetworkStatsHistory;->getIndexAfter(J)I

    move-result v29

    .line 309
    .local v29, startIndex:I
    move/from16 v20, v29

    .local v20, i:I
    :goto_43
    if-ltz v20, :cond_59

    .line 310
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/net/NetworkStatsHistory;->bucketStart:[J

    move-object/from16 v34, v0

    aget-wide v6, v34, v20

    .line 311
    .local v6, curStart:J
    move-object/from16 v0, p0

    iget-wide v0, v0, Landroid/net/NetworkStatsHistory;->bucketDuration:J

    move-wide/from16 v34, v0

    add-long v4, v6, v34

    .line 314
    .local v4, curEnd:J
    cmp-long v34, v4, p1

    if-gez v34, :cond_76

    .line 338
    .end local v4           #curEnd:J
    .end local v6           #curStart:J
    :cond_59
    move-object/from16 v0, p0

    iget-wide v0, v0, Landroid/net/NetworkStatsHistory;->totalBytes:J

    move-wide/from16 v34, v0

    move-object/from16 v0, p5

    iget-wide v0, v0, Landroid/net/NetworkStats$Entry;->rxBytes:J

    move-wide/from16 v36, v0

    move-object/from16 v0, p5

    iget-wide v0, v0, Landroid/net/NetworkStats$Entry;->txBytes:J

    move-wide/from16 v38, v0

    add-long v36, v36, v38

    add-long v34, v34, v36

    move-wide/from16 v0, v34

    move-object/from16 v2, p0

    iput-wide v0, v2, Landroid/net/NetworkStatsHistory;->totalBytes:J

    goto :goto_33

    .line 316
    .restart local v4       #curEnd:J
    .restart local v6       #curStart:J
    :cond_76
    cmp-long v34, v6, p3

    if-lez v34, :cond_7d

    .line 309
    :cond_7a
    :goto_7a
    add-int/lit8 v20, v20, -0x1

    goto :goto_43

    .line 318
    :cond_7d
    move-wide/from16 v0, p3

    invoke-static {v4, v5, v0, v1}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v34

    move-wide/from16 v0, p1

    invoke-static {v6, v7, v0, v1}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v36

    sub-long v23, v34, v36

    .line 319
    .local v23, overlap:J
    const-wide/16 v34, 0x0

    cmp-long v34, v23, v34

    if-lez v34, :cond_7a

    .line 322
    mul-long v34, v25, v23

    div-long v12, v34, v8

    .line 323
    .local v12, fracRxBytes:J
    mul-long v34, v27, v23

    div-long v14, v34, v8

    .line 324
    .local v14, fracRxPackets:J
    mul-long v34, v30, v23

    div-long v16, v34, v8

    .line 325
    .local v16, fracTxBytes:J
    mul-long v34, v32, v23

    div-long v18, v34, v8

    .line 326
    .local v18, fracTxPackets:J
    mul-long v34, v21, v23

    div-long v10, v34, v8

    .line 328
    .local v10, fracOperations:J
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/net/NetworkStatsHistory;->activeTime:[J

    move-object/from16 v34, v0

    move-object/from16 v0, v34

    move/from16 v1, v20

    move-wide/from16 v2, v23

    invoke-static {v0, v1, v2, v3}, Landroid/net/NetworkStatsHistory;->addLong([JIJ)V

    .line 329
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/net/NetworkStatsHistory;->rxBytes:[J

    move-object/from16 v34, v0

    move-object/from16 v0, v34

    move/from16 v1, v20

    invoke-static {v0, v1, v12, v13}, Landroid/net/NetworkStatsHistory;->addLong([JIJ)V

    sub-long v25, v25, v12

    .line 330
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/net/NetworkStatsHistory;->rxPackets:[J

    move-object/from16 v34, v0

    move-object/from16 v0, v34

    move/from16 v1, v20

    invoke-static {v0, v1, v14, v15}, Landroid/net/NetworkStatsHistory;->addLong([JIJ)V

    sub-long v27, v27, v14

    .line 331
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/net/NetworkStatsHistory;->txBytes:[J

    move-object/from16 v34, v0

    move-object/from16 v0, v34

    move/from16 v1, v20

    move-wide/from16 v2, v16

    invoke-static {v0, v1, v2, v3}, Landroid/net/NetworkStatsHistory;->addLong([JIJ)V

    sub-long v30, v30, v16

    .line 332
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/net/NetworkStatsHistory;->txPackets:[J

    move-object/from16 v34, v0

    move-object/from16 v0, v34

    move/from16 v1, v20

    move-wide/from16 v2, v18

    invoke-static {v0, v1, v2, v3}, Landroid/net/NetworkStatsHistory;->addLong([JIJ)V

    sub-long v32, v32, v18

    .line 333
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/net/NetworkStatsHistory;->operations:[J

    move-object/from16 v34, v0

    move-object/from16 v0, v34

    move/from16 v1, v20

    invoke-static {v0, v1, v10, v11}, Landroid/net/NetworkStatsHistory;->addLong([JIJ)V

    sub-long v21, v21, v10

    .line 335
    sub-long v8, v8, v23

    goto/16 :goto_7a
.end method

.method public recordEntireHistory(Landroid/net/NetworkStatsHistory;)V
    .registers 8
    .parameter "input"

    .prologue
    .line 346
    const-wide/high16 v2, -0x8000

    const-wide v4, 0x7fffffffffffffffL

    move-object v0, p0

    move-object v1, p1

    invoke-virtual/range {v0 .. v5}, Landroid/net/NetworkStatsHistory;->recordHistory(Landroid/net/NetworkStatsHistory;JJ)V

    .line 347
    return-void
.end method

.method public recordHistory(Landroid/net/NetworkStatsHistory;JJ)V
    .registers 23
    .parameter "input"
    .parameter "start"
    .parameter "end"

    .prologue
    .line 355
    new-instance v1, Landroid/net/NetworkStats$Entry;

    sget-object v2, Landroid/net/NetworkStats;->IFACE_ALL:Ljava/lang/String;

    const/4 v3, -0x1

    const/4 v4, 0x0

    const/4 v5, 0x0

    const-wide/16 v6, 0x0

    const-wide/16 v8, 0x0

    const-wide/16 v10, 0x0

    const-wide/16 v12, 0x0

    const-wide/16 v14, 0x0

    invoke-direct/range {v1 .. v15}, Landroid/net/NetworkStats$Entry;-><init>(Ljava/lang/String;IIIJJJJJ)V

    .line 357
    .local v1, entry:Landroid/net/NetworkStats$Entry;
    const/16 v16, 0x0

    .local v16, i:I
    :goto_16
    move-object/from16 v0, p1

    iget v2, v0, Landroid/net/NetworkStatsHistory;->bucketCount:I

    move/from16 v0, v16

    if-ge v0, v2, :cond_82

    .line 358
    move-object/from16 v0, p1

    iget-object v2, v0, Landroid/net/NetworkStatsHistory;->bucketStart:[J

    aget-wide v3, v2, v16

    .line 359
    .local v3, bucketStart:J
    move-object/from16 v0, p1

    iget-wide v7, v0, Landroid/net/NetworkStatsHistory;->bucketDuration:J

    add-long v5, v3, v7

    .line 362
    .local v5, bucketEnd:J
    cmp-long v2, v3, p2

    if-ltz v2, :cond_32

    cmp-long v2, v5, p4

    if-lez v2, :cond_35

    .line 357
    :cond_32
    :goto_32
    add-int/lit8 v16, v16, 0x1

    goto :goto_16

    .line 364
    :cond_35
    move-object/from16 v0, p1

    iget-object v2, v0, Landroid/net/NetworkStatsHistory;->rxBytes:[J

    const-wide/16 v7, 0x0

    move/from16 v0, v16

    invoke-static {v2, v0, v7, v8}, Landroid/net/NetworkStatsHistory;->getLong([JIJ)J

    move-result-wide v7

    iput-wide v7, v1, Landroid/net/NetworkStats$Entry;->rxBytes:J

    .line 365
    move-object/from16 v0, p1

    iget-object v2, v0, Landroid/net/NetworkStatsHistory;->rxPackets:[J

    const-wide/16 v7, 0x0

    move/from16 v0, v16

    invoke-static {v2, v0, v7, v8}, Landroid/net/NetworkStatsHistory;->getLong([JIJ)J

    move-result-wide v7

    iput-wide v7, v1, Landroid/net/NetworkStats$Entry;->rxPackets:J

    .line 366
    move-object/from16 v0, p1

    iget-object v2, v0, Landroid/net/NetworkStatsHistory;->txBytes:[J

    const-wide/16 v7, 0x0

    move/from16 v0, v16

    invoke-static {v2, v0, v7, v8}, Landroid/net/NetworkStatsHistory;->getLong([JIJ)J

    move-result-wide v7

    iput-wide v7, v1, Landroid/net/NetworkStats$Entry;->txBytes:J

    .line 367
    move-object/from16 v0, p1

    iget-object v2, v0, Landroid/net/NetworkStatsHistory;->txPackets:[J

    const-wide/16 v7, 0x0

    move/from16 v0, v16

    invoke-static {v2, v0, v7, v8}, Landroid/net/NetworkStatsHistory;->getLong([JIJ)J

    move-result-wide v7

    iput-wide v7, v1, Landroid/net/NetworkStats$Entry;->txPackets:J

    .line 368
    move-object/from16 v0, p1

    iget-object v2, v0, Landroid/net/NetworkStatsHistory;->operations:[J

    const-wide/16 v7, 0x0

    move/from16 v0, v16

    invoke-static {v2, v0, v7, v8}, Landroid/net/NetworkStatsHistory;->getLong([JIJ)J

    move-result-wide v7

    iput-wide v7, v1, Landroid/net/NetworkStats$Entry;->operations:J

    move-object/from16 v2, p0

    move-object v7, v1

    .line 370
    invoke-virtual/range {v2 .. v7}, Landroid/net/NetworkStatsHistory;->recordData(JJLandroid/net/NetworkStats$Entry;)V

    goto :goto_32

    .line 372
    .end local v3           #bucketStart:J
    .end local v5           #bucketEnd:J
    :cond_82
    return-void
.end method

.method public removeBucketsBefore(J)V
    .registers 11
    .parameter "cutoff"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 438
    const/4 v4, 0x0

    .local v4, i:I
    :goto_1
    iget v6, p0, Landroid/net/NetworkStatsHistory;->bucketCount:I

    if-ge v4, v6, :cond_11

    .line 439
    iget-object v6, p0, Landroid/net/NetworkStatsHistory;->bucketStart:[J

    aget-wide v2, v6, v4

    .line 440
    .local v2, curStart:J
    iget-wide v6, p0, Landroid/net/NetworkStatsHistory;->bucketDuration:J

    add-long v0, v2, v6

    .line 444
    .local v0, curEnd:J
    cmp-long v6, v0, p1

    if-lez v6, :cond_6c

    .line 447
    .end local v0           #curEnd:J
    .end local v2           #curStart:J
    :cond_11
    if-lez v4, :cond_6b

    .line 448
    iget-object v6, p0, Landroid/net/NetworkStatsHistory;->bucketStart:[J

    array-length v5, v6

    .line 449
    .local v5, length:I
    iget-object v6, p0, Landroid/net/NetworkStatsHistory;->bucketStart:[J

    invoke-static {v6, v4, v5}, Ljava/util/Arrays;->copyOfRange([JII)[J

    move-result-object v6

    iput-object v6, p0, Landroid/net/NetworkStatsHistory;->bucketStart:[J

    .line 450
    iget-object v6, p0, Landroid/net/NetworkStatsHistory;->activeTime:[J

    if-eqz v6, :cond_2a

    iget-object v6, p0, Landroid/net/NetworkStatsHistory;->activeTime:[J

    invoke-static {v6, v4, v5}, Ljava/util/Arrays;->copyOfRange([JII)[J

    move-result-object v6

    iput-object v6, p0, Landroid/net/NetworkStatsHistory;->activeTime:[J

    .line 451
    :cond_2a
    iget-object v6, p0, Landroid/net/NetworkStatsHistory;->rxBytes:[J

    if-eqz v6, :cond_36

    iget-object v6, p0, Landroid/net/NetworkStatsHistory;->rxBytes:[J

    invoke-static {v6, v4, v5}, Ljava/util/Arrays;->copyOfRange([JII)[J

    move-result-object v6

    iput-object v6, p0, Landroid/net/NetworkStatsHistory;->rxBytes:[J

    .line 452
    :cond_36
    iget-object v6, p0, Landroid/net/NetworkStatsHistory;->rxPackets:[J

    if-eqz v6, :cond_42

    iget-object v6, p0, Landroid/net/NetworkStatsHistory;->rxPackets:[J

    invoke-static {v6, v4, v5}, Ljava/util/Arrays;->copyOfRange([JII)[J

    move-result-object v6

    iput-object v6, p0, Landroid/net/NetworkStatsHistory;->rxPackets:[J

    .line 453
    :cond_42
    iget-object v6, p0, Landroid/net/NetworkStatsHistory;->txBytes:[J

    if-eqz v6, :cond_4e

    iget-object v6, p0, Landroid/net/NetworkStatsHistory;->txBytes:[J

    invoke-static {v6, v4, v5}, Ljava/util/Arrays;->copyOfRange([JII)[J

    move-result-object v6

    iput-object v6, p0, Landroid/net/NetworkStatsHistory;->txBytes:[J

    .line 454
    :cond_4e
    iget-object v6, p0, Landroid/net/NetworkStatsHistory;->txPackets:[J

    if-eqz v6, :cond_5a

    iget-object v6, p0, Landroid/net/NetworkStatsHistory;->txPackets:[J

    invoke-static {v6, v4, v5}, Ljava/util/Arrays;->copyOfRange([JII)[J

    move-result-object v6

    iput-object v6, p0, Landroid/net/NetworkStatsHistory;->txPackets:[J

    .line 455
    :cond_5a
    iget-object v6, p0, Landroid/net/NetworkStatsHistory;->operations:[J

    if-eqz v6, :cond_66

    iget-object v6, p0, Landroid/net/NetworkStatsHistory;->operations:[J

    invoke-static {v6, v4, v5}, Ljava/util/Arrays;->copyOfRange([JII)[J

    move-result-object v6

    iput-object v6, p0, Landroid/net/NetworkStatsHistory;->operations:[J

    .line 456
    :cond_66
    iget v6, p0, Landroid/net/NetworkStatsHistory;->bucketCount:I

    sub-int/2addr v6, v4

    iput v6, p0, Landroid/net/NetworkStatsHistory;->bucketCount:I

    .line 460
    .end local v5           #length:I
    :cond_6b
    return-void

    .line 438
    .restart local v0       #curEnd:J
    .restart local v2       #curStart:J
    :cond_6c
    add-int/lit8 v4, v4, 0x1

    goto :goto_1
.end method

.method public size()I
    .registers 2

    .prologue
    .line 201
    iget v0, p0, Landroid/net/NetworkStatsHistory;->bucketCount:I

    return v0
.end method

.method public toString()Ljava/lang/String;
    .registers 4

    .prologue
    .line 596
    new-instance v0, Ljava/io/CharArrayWriter;

    invoke-direct {v0}, Ljava/io/CharArrayWriter;-><init>()V

    .line 597
    .local v0, writer:Ljava/io/CharArrayWriter;
    new-instance v1, Lcom/android/internal/util/IndentingPrintWriter;

    const-string v2, "  "

    invoke-direct {v1, v0, v2}, Lcom/android/internal/util/IndentingPrintWriter;-><init>(Ljava/io/Writer;Ljava/lang/String;)V

    const/4 v2, 0x0

    invoke-virtual {p0, v1, v2}, Landroid/net/NetworkStatsHistory;->dump(Lcom/android/internal/util/IndentingPrintWriter;Z)V

    .line 598
    invoke-virtual {v0}, Ljava/io/CharArrayWriter;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 5
    .parameter "out"
    .parameter "flags"

    .prologue
    .line 136
    iget-wide v0, p0, Landroid/net/NetworkStatsHistory;->bucketDuration:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 137
    iget-object v0, p0, Landroid/net/NetworkStatsHistory;->bucketStart:[J

    iget v1, p0, Landroid/net/NetworkStatsHistory;->bucketCount:I

    invoke-static {p1, v0, v1}, Landroid/net/NetworkStatsHistory$ParcelUtils;->writeLongArray(Landroid/os/Parcel;[JI)V

    .line 138
    iget-object v0, p0, Landroid/net/NetworkStatsHistory;->activeTime:[J

    iget v1, p0, Landroid/net/NetworkStatsHistory;->bucketCount:I

    invoke-static {p1, v0, v1}, Landroid/net/NetworkStatsHistory$ParcelUtils;->writeLongArray(Landroid/os/Parcel;[JI)V

    .line 139
    iget-object v0, p0, Landroid/net/NetworkStatsHistory;->rxBytes:[J

    iget v1, p0, Landroid/net/NetworkStatsHistory;->bucketCount:I

    invoke-static {p1, v0, v1}, Landroid/net/NetworkStatsHistory$ParcelUtils;->writeLongArray(Landroid/os/Parcel;[JI)V

    .line 140
    iget-object v0, p0, Landroid/net/NetworkStatsHistory;->rxPackets:[J

    iget v1, p0, Landroid/net/NetworkStatsHistory;->bucketCount:I

    invoke-static {p1, v0, v1}, Landroid/net/NetworkStatsHistory$ParcelUtils;->writeLongArray(Landroid/os/Parcel;[JI)V

    .line 141
    iget-object v0, p0, Landroid/net/NetworkStatsHistory;->txBytes:[J

    iget v1, p0, Landroid/net/NetworkStatsHistory;->bucketCount:I

    invoke-static {p1, v0, v1}, Landroid/net/NetworkStatsHistory$ParcelUtils;->writeLongArray(Landroid/os/Parcel;[JI)V

    .line 142
    iget-object v0, p0, Landroid/net/NetworkStatsHistory;->txPackets:[J

    iget v1, p0, Landroid/net/NetworkStatsHistory;->bucketCount:I

    invoke-static {p1, v0, v1}, Landroid/net/NetworkStatsHistory$ParcelUtils;->writeLongArray(Landroid/os/Parcel;[JI)V

    .line 143
    iget-object v0, p0, Landroid/net/NetworkStatsHistory;->operations:[J

    iget v1, p0, Landroid/net/NetworkStatsHistory;->bucketCount:I

    invoke-static {p1, v0, v1}, Landroid/net/NetworkStatsHistory$ParcelUtils;->writeLongArray(Landroid/os/Parcel;[JI)V

    .line 144
    iget-wide v0, p0, Landroid/net/NetworkStatsHistory;->totalBytes:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 145
    return-void
.end method

.method public writeToStream(Ljava/io/DataOutputStream;)V
    .registers 4
    .parameter "out"
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 184
    const/4 v0, 0x3

    invoke-virtual {p1, v0}, Ljava/io/DataOutputStream;->writeInt(I)V

    .line 185
    iget-wide v0, p0, Landroid/net/NetworkStatsHistory;->bucketDuration:J

    invoke-virtual {p1, v0, v1}, Ljava/io/DataOutputStream;->writeLong(J)V

    .line 186
    iget-object v0, p0, Landroid/net/NetworkStatsHistory;->bucketStart:[J

    iget v1, p0, Landroid/net/NetworkStatsHistory;->bucketCount:I

    invoke-static {p1, v0, v1}, Landroid/net/NetworkStatsHistory$DataStreamUtils;->writeVarLongArray(Ljava/io/DataOutputStream;[JI)V

    .line 187
    iget-object v0, p0, Landroid/net/NetworkStatsHistory;->activeTime:[J

    iget v1, p0, Landroid/net/NetworkStatsHistory;->bucketCount:I

    invoke-static {p1, v0, v1}, Landroid/net/NetworkStatsHistory$DataStreamUtils;->writeVarLongArray(Ljava/io/DataOutputStream;[JI)V

    .line 188
    iget-object v0, p0, Landroid/net/NetworkStatsHistory;->rxBytes:[J

    iget v1, p0, Landroid/net/NetworkStatsHistory;->bucketCount:I

    invoke-static {p1, v0, v1}, Landroid/net/NetworkStatsHistory$DataStreamUtils;->writeVarLongArray(Ljava/io/DataOutputStream;[JI)V

    .line 189
    iget-object v0, p0, Landroid/net/NetworkStatsHistory;->rxPackets:[J

    iget v1, p0, Landroid/net/NetworkStatsHistory;->bucketCount:I

    invoke-static {p1, v0, v1}, Landroid/net/NetworkStatsHistory$DataStreamUtils;->writeVarLongArray(Ljava/io/DataOutputStream;[JI)V

    .line 190
    iget-object v0, p0, Landroid/net/NetworkStatsHistory;->txBytes:[J

    iget v1, p0, Landroid/net/NetworkStatsHistory;->bucketCount:I

    invoke-static {p1, v0, v1}, Landroid/net/NetworkStatsHistory$DataStreamUtils;->writeVarLongArray(Ljava/io/DataOutputStream;[JI)V

    .line 191
    iget-object v0, p0, Landroid/net/NetworkStatsHistory;->txPackets:[J

    iget v1, p0, Landroid/net/NetworkStatsHistory;->bucketCount:I

    invoke-static {p1, v0, v1}, Landroid/net/NetworkStatsHistory$DataStreamUtils;->writeVarLongArray(Ljava/io/DataOutputStream;[JI)V

    .line 192
    iget-object v0, p0, Landroid/net/NetworkStatsHistory;->operations:[J

    iget v1, p0, Landroid/net/NetworkStatsHistory;->bucketCount:I

    invoke-static {p1, v0, v1}, Landroid/net/NetworkStatsHistory$DataStreamUtils;->writeVarLongArray(Ljava/io/DataOutputStream;[JI)V

    .line 193
    return-void
.end method
