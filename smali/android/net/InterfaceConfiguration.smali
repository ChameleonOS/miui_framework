.class public Landroid/net/InterfaceConfiguration;
.super Ljava/lang/Object;
.source "InterfaceConfiguration.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator; = null
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Landroid/net/InterfaceConfiguration;",
            ">;"
        }
    .end annotation
.end field

.field private static final FLAG_DOWN:Ljava/lang/String; = "down"

.field private static final FLAG_UP:Ljava/lang/String; = "up"


# instance fields
.field private mAddr:Landroid/net/LinkAddress;

.field private mFlags:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mHwAddr:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    new-instance v0, Landroid/net/InterfaceConfiguration$1;

    invoke-direct {v0}, Landroid/net/InterfaceConfiguration$1;-><init>()V

    sput-object v0, Landroid/net/InterfaceConfiguration;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .registers 2

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    invoke-static {}, Lcom/google/android/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v0

    iput-object v0, p0, Landroid/net/InterfaceConfiguration;->mFlags:Ljava/util/HashSet;

    return-void
.end method

.method static synthetic access$002(Landroid/net/InterfaceConfiguration;Ljava/lang/String;)Ljava/lang/String;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    iput-object p1, p0, Landroid/net/InterfaceConfiguration;->mHwAddr:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$102(Landroid/net/InterfaceConfiguration;Landroid/net/LinkAddress;)Landroid/net/LinkAddress;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    iput-object p1, p0, Landroid/net/InterfaceConfiguration;->mAddr:Landroid/net/LinkAddress;

    return-object p1
.end method

.method static synthetic access$200(Landroid/net/InterfaceConfiguration;)Ljava/util/HashSet;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/net/InterfaceConfiguration;->mFlags:Ljava/util/HashSet;

    return-object v0
.end method

.method private static validateFlag(Ljava/lang/String;)V
    .registers 4
    .parameter "flag"

    .prologue
    const/16 v0, 0x20

    invoke-virtual {p0, v0}, Ljava/lang/String;->indexOf(I)I

    move-result v0

    if-ltz v0, :cond_21

    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "flag contains space: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_21
    return-void
.end method


# virtual methods
.method public clearFlag(Ljava/lang/String;)V
    .registers 3
    .parameter "flag"

    .prologue
    invoke-static {p1}, Landroid/net/InterfaceConfiguration;->validateFlag(Ljava/lang/String;)V

    iget-object v0, p0, Landroid/net/InterfaceConfiguration;->mFlags:Ljava/util/HashSet;

    invoke-virtual {v0, p1}, Ljava/util/HashSet;->remove(Ljava/lang/Object;)Z

    return-void
.end method

.method public describeContents()I
    .registers 2

    .prologue
    const/4 v0, 0x0

    return v0
.end method

.method public getFlags()Ljava/lang/Iterable;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/Iterable",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    iget-object v0, p0, Landroid/net/InterfaceConfiguration;->mFlags:Ljava/util/HashSet;

    return-object v0
.end method

.method public getHardwareAddress()Ljava/lang/String;
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/net/InterfaceConfiguration;->mHwAddr:Ljava/lang/String;

    return-object v0
.end method

.method public getLinkAddress()Landroid/net/LinkAddress;
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/net/InterfaceConfiguration;->mAddr:Landroid/net/LinkAddress;

    return-object v0
.end method

.method public hasFlag(Ljava/lang/String;)Z
    .registers 3
    .parameter "flag"

    .prologue
    invoke-static {p1}, Landroid/net/InterfaceConfiguration;->validateFlag(Ljava/lang/String;)V

    iget-object v0, p0, Landroid/net/InterfaceConfiguration;->mFlags:Ljava/util/HashSet;

    invoke-virtual {v0, p1}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public isActive()Z
    .registers 8

    .prologue
    const/4 v5, 0x0

    :try_start_1
    const-string/jumbo v6, "up"

    invoke-virtual {p0, v6}, Landroid/net/InterfaceConfiguration;->hasFlag(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_1d

    iget-object v6, p0, Landroid/net/InterfaceConfiguration;->mAddr:Landroid/net/LinkAddress;

    invoke-virtual {v6}, Landroid/net/LinkAddress;->getAddress()Ljava/net/InetAddress;

    move-result-object v6

    invoke-virtual {v6}, Ljava/net/InetAddress;->getAddress()[B

    move-result-object v0

    .local v0, arr$:[B
    array-length v4, v0

    .local v4, len$:I
    const/4 v3, 0x0

    .local v3, i$:I
    :goto_16
    if-ge v3, v4, :cond_1d

    aget-byte v1, v0, v3
    :try_end_1a
    .catch Ljava/lang/NullPointerException; {:try_start_1 .. :try_end_1a} :catch_21

    .local v1, b:B
    if-eqz v1, :cond_1e

    const/4 v5, 0x1

    .end local v0           #arr$:[B
    .end local v1           #b:B
    .end local v3           #i$:I
    .end local v4           #len$:I
    :cond_1d
    :goto_1d
    return v5

    .restart local v0       #arr$:[B
    .restart local v1       #b:B
    .restart local v3       #i$:I
    .restart local v4       #len$:I
    :cond_1e
    add-int/lit8 v3, v3, 0x1

    goto :goto_16

    .end local v0           #arr$:[B
    .end local v1           #b:B
    .end local v3           #i$:I
    .end local v4           #len$:I
    :catch_21
    move-exception v2

    .local v2, e:Ljava/lang/NullPointerException;
    goto :goto_1d
.end method

.method public setFlag(Ljava/lang/String;)V
    .registers 3
    .parameter "flag"

    .prologue
    invoke-static {p1}, Landroid/net/InterfaceConfiguration;->validateFlag(Ljava/lang/String;)V

    iget-object v0, p0, Landroid/net/InterfaceConfiguration;->mFlags:Ljava/util/HashSet;

    invoke-virtual {v0, p1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method public setHardwareAddress(Ljava/lang/String;)V
    .registers 2
    .parameter "hwAddr"

    .prologue
    iput-object p1, p0, Landroid/net/InterfaceConfiguration;->mHwAddr:Ljava/lang/String;

    return-void
.end method

.method public setInterfaceDown()V
    .registers 3

    .prologue
    iget-object v0, p0, Landroid/net/InterfaceConfiguration;->mFlags:Ljava/util/HashSet;

    const-string/jumbo v1, "up"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->remove(Ljava/lang/Object;)Z

    iget-object v0, p0, Landroid/net/InterfaceConfiguration;->mFlags:Ljava/util/HashSet;

    const-string v1, "down"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method public setInterfaceUp()V
    .registers 3

    .prologue
    iget-object v0, p0, Landroid/net/InterfaceConfiguration;->mFlags:Ljava/util/HashSet;

    const-string v1, "down"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->remove(Ljava/lang/Object;)Z

    iget-object v0, p0, Landroid/net/InterfaceConfiguration;->mFlags:Ljava/util/HashSet;

    const-string/jumbo v1, "up"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method public setLinkAddress(Landroid/net/LinkAddress;)V
    .registers 2
    .parameter "addr"

    .prologue
    iput-object p1, p0, Landroid/net/InterfaceConfiguration;->mAddr:Landroid/net/LinkAddress;

    return-void
.end method

.method public toString()Ljava/lang/String;
    .registers 4

    .prologue
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .local v0, builder:Ljava/lang/StringBuilder;
    const-string v1, "mHwAddr="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Landroid/net/InterfaceConfiguration;->mHwAddr:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, " mAddr="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Landroid/net/InterfaceConfiguration;->mAddr:Landroid/net/LinkAddress;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, " mFlags="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Landroid/net/InterfaceConfiguration;->getFlags()Ljava/lang/Iterable;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 6
    .parameter "dest"
    .parameter "flags"

    .prologue
    iget-object v2, p0, Landroid/net/InterfaceConfiguration;->mHwAddr:Ljava/lang/String;

    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object v2, p0, Landroid/net/InterfaceConfiguration;->mAddr:Landroid/net/LinkAddress;

    if-eqz v2, :cond_31

    const/4 v2, 0x1

    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeByte(B)V

    iget-object v2, p0, Landroid/net/InterfaceConfiguration;->mAddr:Landroid/net/LinkAddress;

    invoke-virtual {p1, v2, p2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    :goto_12
    iget-object v2, p0, Landroid/net/InterfaceConfiguration;->mFlags:Ljava/util/HashSet;

    invoke-virtual {v2}, Ljava/util/HashSet;->size()I

    move-result v2

    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeInt(I)V

    iget-object v2, p0, Landroid/net/InterfaceConfiguration;->mFlags:Ljava/util/HashSet;

    invoke-virtual {v2}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, i$:Ljava/util/Iterator;
    :goto_21
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_36

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .local v0, flag:Ljava/lang/String;
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_21

    .end local v0           #flag:Ljava/lang/String;
    .end local v1           #i$:Ljava/util/Iterator;
    :cond_31
    const/4 v2, 0x0

    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeByte(B)V

    goto :goto_12

    .restart local v1       #i$:Ljava/util/Iterator;
    :cond_36
    return-void
.end method
