.class public Landroid/net/NetworkPolicy;
.super Ljava/lang/Object;
.source "NetworkPolicy.java"

# interfaces
.implements Landroid/os/Parcelable;
.implements Ljava/lang/Comparable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/os/Parcelable;",
        "Ljava/lang/Comparable",
        "<",
        "Landroid/net/NetworkPolicy;",
        ">;"
    }
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator; = null
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Landroid/net/NetworkPolicy;",
            ">;"
        }
    .end annotation
.end field

.field public static final CYCLE_NONE:I = -0x1

.field private static final DEFAULT_MTU:J = 0x5dcL

.field public static final LIMIT_DISABLED:J = -0x1L

.field public static final SNOOZE_NEVER:J = -0x1L

.field public static final WARNING_DISABLED:J = -0x1L


# instance fields
.field public cycleDay:I

.field public cycleTimezone:Ljava/lang/String;

.field public inferred:Z

.field public lastLimitSnooze:J

.field public lastWarningSnooze:J

.field public limitBytes:J

.field public metered:Z

.field public final template:Landroid/net/NetworkTemplate;

.field public warningBytes:J


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 183
    new-instance v0, Landroid/net/NetworkPolicy$1;

    invoke-direct {v0}, Landroid/net/NetworkPolicy$1;-><init>()V

    sput-object v0, Landroid/net/NetworkPolicy;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(Landroid/net/NetworkTemplate;ILjava/lang/String;JJJJZZ)V
    .registers 15
    .parameter "template"
    .parameter "cycleDay"
    .parameter "cycleTimezone"
    .parameter "warningBytes"
    .parameter "limitBytes"
    .parameter "lastWarningSnooze"
    .parameter "lastLimitSnooze"
    .parameter "metered"
    .parameter "inferred"

    .prologue
    .line 59
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 60
    const-string/jumbo v0, "missing NetworkTemplate"

    invoke-static {p1, v0}, Lcom/android/internal/util/Preconditions;->checkNotNull(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/NetworkTemplate;

    iput-object v0, p0, Landroid/net/NetworkPolicy;->template:Landroid/net/NetworkTemplate;

    .line 61
    iput p2, p0, Landroid/net/NetworkPolicy;->cycleDay:I

    .line 62
    const-string/jumbo v0, "missing cycleTimezone"

    invoke-static {p3, v0}, Lcom/android/internal/util/Preconditions;->checkNotNull(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Landroid/net/NetworkPolicy;->cycleTimezone:Ljava/lang/String;

    .line 63
    iput-wide p4, p0, Landroid/net/NetworkPolicy;->warningBytes:J

    .line 64
    iput-wide p6, p0, Landroid/net/NetworkPolicy;->limitBytes:J

    .line 65
    iput-wide p8, p0, Landroid/net/NetworkPolicy;->lastWarningSnooze:J

    .line 66
    iput-wide p10, p0, Landroid/net/NetworkPolicy;->lastLimitSnooze:J

    .line 67
    iput-boolean p12, p0, Landroid/net/NetworkPolicy;->metered:Z

    .line 68
    iput-boolean p13, p0, Landroid/net/NetworkPolicy;->inferred:Z

    .line 69
    return-void
.end method

.method public constructor <init>(Landroid/net/NetworkTemplate;ILjava/lang/String;JJZ)V
    .registers 23
    .parameter "template"
    .parameter "cycleDay"
    .parameter "cycleTimezone"
    .parameter "warningBytes"
    .parameter "limitBytes"
    .parameter "metered"
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 53
    const-wide/16 v8, -0x1

    const-wide/16 v10, -0x1

    const/4 v13, 0x0

    move-object v0, p0

    move-object v1, p1

    move/from16 v2, p2

    move-object/from16 v3, p3

    move-wide/from16 v4, p4

    move-wide/from16 v6, p6

    move/from16 v12, p8

    invoke-direct/range {v0 .. v13}, Landroid/net/NetworkPolicy;-><init>(Landroid/net/NetworkTemplate;ILjava/lang/String;JJJJZZ)V

    .line 55
    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .registers 7
    .parameter "in"

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 71
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 72
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/net/NetworkTemplate;

    iput-object v0, p0, Landroid/net/NetworkPolicy;->template:Landroid/net/NetworkTemplate;

    .line 73
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/net/NetworkPolicy;->cycleDay:I

    .line 74
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroid/net/NetworkPolicy;->cycleTimezone:Ljava/lang/String;

    .line 75
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v3

    iput-wide v3, p0, Landroid/net/NetworkPolicy;->warningBytes:J

    .line 76
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v3

    iput-wide v3, p0, Landroid/net/NetworkPolicy;->limitBytes:J

    .line 77
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v3

    iput-wide v3, p0, Landroid/net/NetworkPolicy;->lastWarningSnooze:J

    .line 78
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v3

    iput-wide v3, p0, Landroid/net/NetworkPolicy;->lastLimitSnooze:J

    .line 79
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_44

    move v0, v1

    :goto_39
    iput-boolean v0, p0, Landroid/net/NetworkPolicy;->metered:Z

    .line 80
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_46

    :goto_41
    iput-boolean v1, p0, Landroid/net/NetworkPolicy;->inferred:Z

    .line 81
    return-void

    :cond_44
    move v0, v2

    .line 79
    goto :goto_39

    :cond_46
    move v1, v2

    .line 80
    goto :goto_41
.end method


# virtual methods
.method public clearSnooze()V
    .registers 3

    .prologue
    const-wide/16 v0, -0x1

    .line 123
    iput-wide v0, p0, Landroid/net/NetworkPolicy;->lastWarningSnooze:J

    .line 124
    iput-wide v0, p0, Landroid/net/NetworkPolicy;->lastLimitSnooze:J

    .line 125
    return-void
.end method

.method public compareTo(Landroid/net/NetworkPolicy;)I
    .registers 6
    .parameter "another"

    .prologue
    const-wide/16 v2, -0x1

    .line 136
    if-eqz p1, :cond_a

    iget-wide v0, p1, Landroid/net/NetworkPolicy;->limitBytes:J

    cmp-long v0, v0, v2

    if-nez v0, :cond_c

    .line 138
    :cond_a
    const/4 v0, -0x1

    .line 144
    :goto_b
    return v0

    .line 140
    :cond_c
    iget-wide v0, p0, Landroid/net/NetworkPolicy;->limitBytes:J

    cmp-long v0, v0, v2

    if-eqz v0, :cond_1a

    iget-wide v0, p1, Landroid/net/NetworkPolicy;->limitBytes:J

    iget-wide v2, p0, Landroid/net/NetworkPolicy;->limitBytes:J

    cmp-long v0, v0, v2

    if-gez v0, :cond_1c

    .line 142
    :cond_1a
    const/4 v0, 0x1

    goto :goto_b

    .line 144
    :cond_1c
    const/4 v0, 0x0

    goto :goto_b
.end method

.method public bridge synthetic compareTo(Ljava/lang/Object;)I
    .registers 3
    .parameter "x0"

    .prologue
    .line 32
    check-cast p1, Landroid/net/NetworkPolicy;

    .end local p1
    invoke-virtual {p0, p1}, Landroid/net/NetworkPolicy;->compareTo(Landroid/net/NetworkPolicy;)I

    move-result v0

    return v0
.end method

.method public describeContents()I
    .registers 2

    .prologue
    .line 98
    const/4 v0, 0x0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .registers 8
    .parameter "obj"

    .prologue
    const/4 v1, 0x0

    .line 155
    instance-of v2, p1, Landroid/net/NetworkPolicy;

    if-eqz v2, :cond_4f

    move-object v0, p1

    .line 156
    check-cast v0, Landroid/net/NetworkPolicy;

    .line 157
    .local v0, other:Landroid/net/NetworkPolicy;
    iget v2, p0, Landroid/net/NetworkPolicy;->cycleDay:I

    iget v3, v0, Landroid/net/NetworkPolicy;->cycleDay:I

    if-ne v2, v3, :cond_4f

    iget-wide v2, p0, Landroid/net/NetworkPolicy;->warningBytes:J

    iget-wide v4, v0, Landroid/net/NetworkPolicy;->warningBytes:J

    cmp-long v2, v2, v4

    if-nez v2, :cond_4f

    iget-wide v2, p0, Landroid/net/NetworkPolicy;->limitBytes:J

    iget-wide v4, v0, Landroid/net/NetworkPolicy;->limitBytes:J

    cmp-long v2, v2, v4

    if-nez v2, :cond_4f

    iget-wide v2, p0, Landroid/net/NetworkPolicy;->lastWarningSnooze:J

    iget-wide v4, v0, Landroid/net/NetworkPolicy;->lastWarningSnooze:J

    cmp-long v2, v2, v4

    if-nez v2, :cond_4f

    iget-wide v2, p0, Landroid/net/NetworkPolicy;->lastLimitSnooze:J

    iget-wide v4, v0, Landroid/net/NetworkPolicy;->lastLimitSnooze:J

    cmp-long v2, v2, v4

    if-nez v2, :cond_4f

    iget-boolean v2, p0, Landroid/net/NetworkPolicy;->metered:Z

    iget-boolean v3, v0, Landroid/net/NetworkPolicy;->metered:Z

    if-ne v2, v3, :cond_4f

    iget-boolean v2, p0, Landroid/net/NetworkPolicy;->inferred:Z

    iget-boolean v3, v0, Landroid/net/NetworkPolicy;->inferred:Z

    if-ne v2, v3, :cond_4f

    iget-object v2, p0, Landroid/net/NetworkPolicy;->cycleTimezone:Ljava/lang/String;

    iget-object v3, v0, Landroid/net/NetworkPolicy;->cycleTimezone:Ljava/lang/String;

    invoke-static {v2, v3}, Lcom/android/internal/util/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4f

    iget-object v2, p0, Landroid/net/NetworkPolicy;->template:Landroid/net/NetworkTemplate;

    iget-object v3, v0, Landroid/net/NetworkPolicy;->template:Landroid/net/NetworkTemplate;

    invoke-static {v2, v3}, Lcom/android/internal/util/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4f

    const/4 v1, 0x1

    .line 165
    .end local v0           #other:Landroid/net/NetworkPolicy;
    :cond_4f
    return v1
.end method

.method public hasCycle()Z
    .registers 3

    .prologue
    .line 131
    iget v0, p0, Landroid/net/NetworkPolicy;->cycleDay:I

    const/4 v1, -0x1

    if-eq v0, v1, :cond_7

    const/4 v0, 0x1

    :goto_6
    return v0

    :cond_7
    const/4 v0, 0x0

    goto :goto_6
.end method

.method public hashCode()I
    .registers 5

    .prologue
    .line 149
    const/16 v0, 0x9

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    iget-object v2, p0, Landroid/net/NetworkPolicy;->template:Landroid/net/NetworkTemplate;

    aput-object v2, v0, v1

    const/4 v1, 0x1

    iget v2, p0, Landroid/net/NetworkPolicy;->cycleDay:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x2

    iget-object v2, p0, Landroid/net/NetworkPolicy;->cycleTimezone:Ljava/lang/String;

    aput-object v2, v0, v1

    const/4 v1, 0x3

    iget-wide v2, p0, Landroid/net/NetworkPolicy;->warningBytes:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x4

    iget-wide v2, p0, Landroid/net/NetworkPolicy;->limitBytes:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x5

    iget-wide v2, p0, Landroid/net/NetworkPolicy;->lastWarningSnooze:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x6

    iget-wide v2, p0, Landroid/net/NetworkPolicy;->lastLimitSnooze:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x7

    iget-boolean v2, p0, Landroid/net/NetworkPolicy;->metered:Z

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    aput-object v2, v0, v1

    const/16 v1, 0x8

    iget-boolean v2, p0, Landroid/net/NetworkPolicy;->inferred:Z

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    aput-object v2, v0, v1

    invoke-static {v0}, Lcom/android/internal/util/Objects;->hashCode([Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public isOverLimit(J)Z
    .registers 7
    .parameter "totalBytes"

    .prologue
    .line 115
    const-wide/16 v0, 0xbb8

    add-long/2addr p1, v0

    .line 116
    iget-wide v0, p0, Landroid/net/NetworkPolicy;->limitBytes:J

    const-wide/16 v2, -0x1

    cmp-long v0, v0, v2

    if-eqz v0, :cond_13

    iget-wide v0, p0, Landroid/net/NetworkPolicy;->limitBytes:J

    cmp-long v0, p1, v0

    if-ltz v0, :cond_13

    const/4 v0, 0x1

    :goto_12
    return v0

    :cond_13
    const/4 v0, 0x0

    goto :goto_12
.end method

.method public isOverWarning(J)Z
    .registers 7
    .parameter "totalBytes"

    .prologue
    .line 105
    iget-wide v0, p0, Landroid/net/NetworkPolicy;->warningBytes:J

    const-wide/16 v2, -0x1

    cmp-long v0, v0, v2

    if-eqz v0, :cond_10

    iget-wide v0, p0, Landroid/net/NetworkPolicy;->warningBytes:J

    cmp-long v0, p1, v0

    if-ltz v0, :cond_10

    const/4 v0, 0x1

    :goto_f
    return v0

    :cond_10
    const/4 v0, 0x0

    goto :goto_f
.end method

.method public toString()Ljava/lang/String;
    .registers 5

    .prologue
    .line 170
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "NetworkPolicy"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 171
    .local v0, builder:Ljava/lang/StringBuilder;
    const-string v1, "["

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Landroid/net/NetworkPolicy;->template:Landroid/net/NetworkTemplate;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "]:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 172
    const-string v1, " cycleDay="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Landroid/net/NetworkPolicy;->cycleDay:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 173
    const-string v1, ", cycleTimezone="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Landroid/net/NetworkPolicy;->cycleTimezone:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 174
    const-string v1, ", warningBytes="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-wide v2, p0, Landroid/net/NetworkPolicy;->warningBytes:J

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    .line 175
    const-string v1, ", limitBytes="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-wide v2, p0, Landroid/net/NetworkPolicy;->limitBytes:J

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    .line 176
    const-string v1, ", lastWarningSnooze="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-wide v2, p0, Landroid/net/NetworkPolicy;->lastWarningSnooze:J

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    .line 177
    const-string v1, ", lastLimitSnooze="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-wide v2, p0, Landroid/net/NetworkPolicy;->lastLimitSnooze:J

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    .line 178
    const-string v1, ", metered="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v2, p0, Landroid/net/NetworkPolicy;->metered:Z

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    .line 179
    const-string v1, ", inferred="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v2, p0, Landroid/net/NetworkPolicy;->inferred:Z

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    .line 180
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 8
    .parameter "dest"
    .parameter "flags"

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 85
    iget-object v0, p0, Landroid/net/NetworkPolicy;->template:Landroid/net/NetworkTemplate;

    invoke-virtual {p1, v0, p2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 86
    iget v0, p0, Landroid/net/NetworkPolicy;->cycleDay:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 87
    iget-object v0, p0, Landroid/net/NetworkPolicy;->cycleTimezone:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 88
    iget-wide v3, p0, Landroid/net/NetworkPolicy;->warningBytes:J

    invoke-virtual {p1, v3, v4}, Landroid/os/Parcel;->writeLong(J)V

    .line 89
    iget-wide v3, p0, Landroid/net/NetworkPolicy;->limitBytes:J

    invoke-virtual {p1, v3, v4}, Landroid/os/Parcel;->writeLong(J)V

    .line 90
    iget-wide v3, p0, Landroid/net/NetworkPolicy;->lastWarningSnooze:J

    invoke-virtual {p1, v3, v4}, Landroid/os/Parcel;->writeLong(J)V

    .line 91
    iget-wide v3, p0, Landroid/net/NetworkPolicy;->lastLimitSnooze:J

    invoke-virtual {p1, v3, v4}, Landroid/os/Parcel;->writeLong(J)V

    .line 92
    iget-boolean v0, p0, Landroid/net/NetworkPolicy;->metered:Z

    if-eqz v0, :cond_35

    move v0, v1

    :goto_2a
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 93
    iget-boolean v0, p0, Landroid/net/NetworkPolicy;->inferred:Z

    if-eqz v0, :cond_37

    :goto_31
    invoke-virtual {p1, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 94
    return-void

    :cond_35
    move v0, v2

    .line 92
    goto :goto_2a

    :cond_37
    move v1, v2

    .line 93
    goto :goto_31
.end method
