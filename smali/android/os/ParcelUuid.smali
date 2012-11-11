.class public final Landroid/os/ParcelUuid;
.super Ljava/lang/Object;
.source "ParcelUuid.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Landroid/os/ParcelUuid;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final mUuid:Ljava/util/UUID;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    new-instance v0, Landroid/os/ParcelUuid$1;

    invoke-direct {v0}, Landroid/os/ParcelUuid$1;-><init>()V

    sput-object v0, Landroid/os/ParcelUuid;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(Ljava/util/UUID;)V
    .registers 2
    .parameter "uuid"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroid/os/ParcelUuid;->mUuid:Ljava/util/UUID;

    return-void
.end method

.method public static fromString(Ljava/lang/String;)Landroid/os/ParcelUuid;
    .registers 3
    .parameter "uuid"

    .prologue
    new-instance v0, Landroid/os/ParcelUuid;

    invoke-static {p0}, Ljava/util/UUID;->fromString(Ljava/lang/String;)Ljava/util/UUID;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/ParcelUuid;-><init>(Ljava/util/UUID;)V

    return-object v0
.end method


# virtual methods
.method public describeContents()I
    .registers 2

    .prologue
    const/4 v0, 0x0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .registers 5
    .parameter "object"

    .prologue
    const/4 v1, 0x0

    if-nez p1, :cond_4

    :cond_3
    :goto_3
    return v1

    :cond_4
    if-ne p0, p1, :cond_8

    const/4 v1, 0x1

    goto :goto_3

    :cond_8
    instance-of v2, p1, Landroid/os/ParcelUuid;

    if-eqz v2, :cond_3

    move-object v0, p1

    check-cast v0, Landroid/os/ParcelUuid;

    .local v0, that:Landroid/os/ParcelUuid;
    iget-object v1, p0, Landroid/os/ParcelUuid;->mUuid:Ljava/util/UUID;

    iget-object v2, v0, Landroid/os/ParcelUuid;->mUuid:Ljava/util/UUID;

    invoke-virtual {v1, v2}, Ljava/util/UUID;->equals(Ljava/lang/Object;)Z

    move-result v1

    goto :goto_3
.end method

.method public getUuid()Ljava/util/UUID;
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/os/ParcelUuid;->mUuid:Ljava/util/UUID;

    return-object v0
.end method

.method public hashCode()I
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/os/ParcelUuid;->mUuid:Ljava/util/UUID;

    invoke-virtual {v0}, Ljava/util/UUID;->hashCode()I

    move-result v0

    return v0
.end method

.method public toString()Ljava/lang/String;
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/os/ParcelUuid;->mUuid:Ljava/util/UUID;

    invoke-virtual {v0}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 5
    .parameter "dest"
    .parameter "flags"

    .prologue
    iget-object v0, p0, Landroid/os/ParcelUuid;->mUuid:Ljava/util/UUID;

    invoke-virtual {v0}, Ljava/util/UUID;->getMostSignificantBits()J

    move-result-wide v0

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    iget-object v0, p0, Landroid/os/ParcelUuid;->mUuid:Ljava/util/UUID;

    invoke-virtual {v0}, Ljava/util/UUID;->getLeastSignificantBits()J

    move-result-wide v0

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    return-void
.end method
