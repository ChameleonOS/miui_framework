.class public Landroid/location/Country;
.super Ljava/lang/Object;
.source "Country.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final COUNTRY_SOURCE_LOCALE:I = 0x3

.field public static final COUNTRY_SOURCE_LOCATION:I = 0x1

.field public static final COUNTRY_SOURCE_NETWORK:I = 0x0

.field public static final COUNTRY_SOURCE_SIM:I = 0x2

.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Landroid/location/Country;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final mCountryIso:Ljava/lang/String;

.field private mHashCode:I

.field private final mSource:I

.field private final mTimestamp:J


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 136
    new-instance v0, Landroid/location/Country$1;

    invoke-direct {v0}, Landroid/location/Country$1;-><init>()V

    sput-object v0, Landroid/location/Country;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(Landroid/location/Country;)V
    .registers 4
    .parameter "country"

    .prologue
    .line 101
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 102
    iget-object v0, p1, Landroid/location/Country;->mCountryIso:Ljava/lang/String;

    iput-object v0, p0, Landroid/location/Country;->mCountryIso:Ljava/lang/String;

    .line 103
    iget v0, p1, Landroid/location/Country;->mSource:I

    iput v0, p0, Landroid/location/Country;->mSource:I

    .line 104
    iget-wide v0, p1, Landroid/location/Country;->mTimestamp:J

    iput-wide v0, p0, Landroid/location/Country;->mTimestamp:J

    .line 105
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;I)V
    .registers 5
    .parameter "countryIso"
    .parameter "source"

    .prologue
    .line 81
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 82
    if-eqz p1, :cond_a

    if-ltz p2, :cond_a

    const/4 v0, 0x3

    if-le p2, v0, :cond_10

    .line 84
    :cond_a
    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-direct {v0}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v0

    .line 86
    :cond_10
    sget-object v0, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {p1, v0}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroid/location/Country;->mCountryIso:Ljava/lang/String;

    .line 87
    iput p2, p0, Landroid/location/Country;->mSource:I

    .line 88
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v0

    iput-wide v0, p0, Landroid/location/Country;->mTimestamp:J

    .line 89
    return-void
.end method

.method private constructor <init>(Ljava/lang/String;IJ)V
    .registers 6
    .parameter "countryIso"
    .parameter "source"
    .parameter "timestamp"

    .prologue
    .line 91
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 92
    if-eqz p1, :cond_a

    if-ltz p2, :cond_a

    const/4 v0, 0x3

    if-le p2, v0, :cond_10

    .line 94
    :cond_a
    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-direct {v0}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v0

    .line 96
    :cond_10
    sget-object v0, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {p1, v0}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroid/location/Country;->mCountryIso:Ljava/lang/String;

    .line 97
    iput p2, p0, Landroid/location/Country;->mSource:I

    .line 98
    iput-wide p3, p0, Landroid/location/Country;->mTimestamp:J

    .line 99
    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/String;IJLandroid/location/Country$1;)V
    .registers 6
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"
    .parameter "x3"

    .prologue
    .line 30
    invoke-direct {p0, p1, p2, p3, p4}, Landroid/location/Country;-><init>(Ljava/lang/String;IJ)V

    return-void
.end method


# virtual methods
.method public describeContents()I
    .registers 2

    .prologue
    .line 147
    const/4 v0, 0x0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .registers 7
    .parameter "object"

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 163
    if-ne p1, p0, :cond_5

    .line 171
    :cond_4
    :goto_4
    return v1

    .line 166
    :cond_5
    instance-of v3, p1, Landroid/location/Country;

    if-eqz v3, :cond_22

    move-object v0, p1

    .line 167
    check-cast v0, Landroid/location/Country;

    .line 169
    .local v0, c:Landroid/location/Country;
    iget-object v3, p0, Landroid/location/Country;->mCountryIso:Ljava/lang/String;

    invoke-virtual {v0}, Landroid/location/Country;->getCountryIso()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_20

    iget v3, p0, Landroid/location/Country;->mSource:I

    invoke-virtual {v0}, Landroid/location/Country;->getSource()I

    move-result v4

    if-eq v3, v4, :cond_4

    :cond_20
    move v1, v2

    goto :goto_4

    .end local v0           #c:Landroid/location/Country;
    :cond_22
    move v1, v2

    .line 171
    goto :goto_4
.end method

.method public equalsIgnoreSource(Landroid/location/Country;)Z
    .registers 4
    .parameter "country"

    .prologue
    .line 195
    if-eqz p1, :cond_10

    iget-object v0, p0, Landroid/location/Country;->mCountryIso:Ljava/lang/String;

    invoke-virtual {p1}, Landroid/location/Country;->getCountryIso()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_10

    const/4 v0, 0x1

    :goto_f
    return v0

    :cond_10
    const/4 v0, 0x0

    goto :goto_f
.end method

.method public final getCountryIso()Ljava/lang/String;
    .registers 2

    .prologue
    .line 111
    iget-object v0, p0, Landroid/location/Country;->mCountryIso:Ljava/lang/String;

    return-object v0
.end method

.method public final getSource()I
    .registers 2

    .prologue
    .line 125
    iget v0, p0, Landroid/location/Country;->mSource:I

    return v0
.end method

.method public final getTimestamp()J
    .registers 3

    .prologue
    .line 133
    iget-wide v0, p0, Landroid/location/Country;->mTimestamp:J

    return-wide v0
.end method

.method public hashCode()I
    .registers 4

    .prologue
    .line 176
    iget v0, p0, Landroid/location/Country;->mHashCode:I

    .line 177
    .local v0, hash:I
    if-nez v0, :cond_16

    .line 178
    const/16 v0, 0x11

    .line 179
    iget-object v1, p0, Landroid/location/Country;->mCountryIso:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    add-int/lit16 v0, v1, 0xdd

    .line 180
    mul-int/lit8 v1, v0, 0xd

    iget v2, p0, Landroid/location/Country;->mSource:I

    add-int v0, v1, v2

    .line 181
    iput v0, p0, Landroid/location/Country;->mHashCode:I

    .line 183
    :cond_16
    iget v1, p0, Landroid/location/Country;->mHashCode:I

    return v1
.end method

.method public toString()Ljava/lang/String;
    .registers 4

    .prologue
    .line 200
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Country {ISO="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Landroid/location/Country;->mCountryIso:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", source="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Landroid/location/Country;->mSource:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", time="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v1, p0, Landroid/location/Country;->mTimestamp:J

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 5
    .parameter "parcel"
    .parameter "flags"

    .prologue
    .line 151
    iget-object v0, p0, Landroid/location/Country;->mCountryIso:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 152
    iget v0, p0, Landroid/location/Country;->mSource:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 153
    iget-wide v0, p0, Landroid/location/Country;->mTimestamp:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 154
    return-void
.end method
