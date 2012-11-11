.class public Landroid/accounts/AuthenticatorDescription;
.super Ljava/lang/Object;
.source "AuthenticatorDescription.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Landroid/accounts/AuthenticatorDescription;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field public final accountPreferencesId:I

.field public final customTokens:Z

.field public final iconId:I

.field public final labelId:I

.field public final packageName:Ljava/lang/String;

.field public final smallIconId:I

.field public final type:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    new-instance v0, Landroid/accounts/AuthenticatorDescription$1;

    invoke-direct {v0}, Landroid/accounts/AuthenticatorDescription$1;-><init>()V

    sput-object v0, Landroid/accounts/AuthenticatorDescription;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method private constructor <init>(Landroid/os/Parcel;)V
    .registers 4
    .parameter "source"

    .prologue
    const/4 v0, 0x1

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Landroid/accounts/AuthenticatorDescription;->type:Ljava/lang/String;

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Landroid/accounts/AuthenticatorDescription;->packageName:Ljava/lang/String;

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    iput v1, p0, Landroid/accounts/AuthenticatorDescription;->labelId:I

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    iput v1, p0, Landroid/accounts/AuthenticatorDescription;->iconId:I

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    iput v1, p0, Landroid/accounts/AuthenticatorDescription;->smallIconId:I

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    iput v1, p0, Landroid/accounts/AuthenticatorDescription;->accountPreferencesId:I

    invoke-virtual {p1}, Landroid/os/Parcel;->readByte()B

    move-result v1

    if-ne v1, v0, :cond_31

    :goto_2e
    iput-boolean v0, p0, Landroid/accounts/AuthenticatorDescription;->customTokens:Z

    return-void

    :cond_31
    const/4 v0, 0x0

    goto :goto_2e
.end method

.method synthetic constructor <init>(Landroid/os/Parcel;Landroid/accounts/AuthenticatorDescription$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    invoke-direct {p0, p1}, Landroid/accounts/AuthenticatorDescription;-><init>(Landroid/os/Parcel;)V

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;)V
    .registers 4
    .parameter "type"

    .prologue
    const/4 v1, 0x0

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Landroid/accounts/AuthenticatorDescription;->type:Ljava/lang/String;

    const/4 v0, 0x0

    iput-object v0, p0, Landroid/accounts/AuthenticatorDescription;->packageName:Ljava/lang/String;

    iput v1, p0, Landroid/accounts/AuthenticatorDescription;->labelId:I

    iput v1, p0, Landroid/accounts/AuthenticatorDescription;->iconId:I

    iput v1, p0, Landroid/accounts/AuthenticatorDescription;->smallIconId:I

    iput v1, p0, Landroid/accounts/AuthenticatorDescription;->accountPreferencesId:I

    iput-boolean v1, p0, Landroid/accounts/AuthenticatorDescription;->customTokens:Z

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;IIII)V
    .registers 15
    .parameter "type"
    .parameter "packageName"
    .parameter "labelId"
    .parameter "iconId"
    .parameter "smallIconId"
    .parameter "prefId"

    .prologue
    const/4 v7, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move v3, p3

    move v4, p4

    move v5, p5

    move v6, p6

    invoke-direct/range {v0 .. v7}, Landroid/accounts/AuthenticatorDescription;-><init>(Ljava/lang/String;Ljava/lang/String;IIIIZ)V

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;IIIIZ)V
    .registers 10
    .parameter "type"
    .parameter "packageName"
    .parameter "labelId"
    .parameter "iconId"
    .parameter "smallIconId"
    .parameter "prefId"
    .parameter "customTokens"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    if-nez p1, :cond_e

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "type cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_e
    if-nez p2, :cond_19

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "packageName cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_19
    iput-object p1, p0, Landroid/accounts/AuthenticatorDescription;->type:Ljava/lang/String;

    iput-object p2, p0, Landroid/accounts/AuthenticatorDescription;->packageName:Ljava/lang/String;

    iput p3, p0, Landroid/accounts/AuthenticatorDescription;->labelId:I

    iput p4, p0, Landroid/accounts/AuthenticatorDescription;->iconId:I

    iput p5, p0, Landroid/accounts/AuthenticatorDescription;->smallIconId:I

    iput p6, p0, Landroid/accounts/AuthenticatorDescription;->accountPreferencesId:I

    iput-boolean p7, p0, Landroid/accounts/AuthenticatorDescription;->customTokens:Z

    return-void
.end method

.method public static newKey(Ljava/lang/String;)Landroid/accounts/AuthenticatorDescription;
    .registers 3
    .parameter "type"

    .prologue
    if-nez p0, :cond_b

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "type cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_b
    new-instance v0, Landroid/accounts/AuthenticatorDescription;

    invoke-direct {v0, p0}, Landroid/accounts/AuthenticatorDescription;-><init>(Ljava/lang/String;)V

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
    .parameter "o"

    .prologue
    if-ne p1, p0, :cond_4

    const/4 v1, 0x1

    :goto_3
    return v1

    :cond_4
    instance-of v1, p1, Landroid/accounts/AuthenticatorDescription;

    if-nez v1, :cond_a

    const/4 v1, 0x0

    goto :goto_3

    :cond_a
    move-object v0, p1

    check-cast v0, Landroid/accounts/AuthenticatorDescription;

    .local v0, other:Landroid/accounts/AuthenticatorDescription;
    iget-object v1, p0, Landroid/accounts/AuthenticatorDescription;->type:Ljava/lang/String;

    iget-object v2, v0, Landroid/accounts/AuthenticatorDescription;->type:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    goto :goto_3
.end method

.method public hashCode()I
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/accounts/AuthenticatorDescription;->type:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    return v0
.end method

.method public toString()Ljava/lang/String;
    .registers 3

    .prologue
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "AuthenticatorDescription {type="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Landroid/accounts/AuthenticatorDescription;->type:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 4
    .parameter "dest"
    .parameter "flags"

    .prologue
    iget-object v0, p0, Landroid/accounts/AuthenticatorDescription;->type:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object v0, p0, Landroid/accounts/AuthenticatorDescription;->packageName:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget v0, p0, Landroid/accounts/AuthenticatorDescription;->labelId:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p0, Landroid/accounts/AuthenticatorDescription;->iconId:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p0, Landroid/accounts/AuthenticatorDescription;->smallIconId:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p0, Landroid/accounts/AuthenticatorDescription;->accountPreferencesId:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget-boolean v0, p0, Landroid/accounts/AuthenticatorDescription;->customTokens:Z

    if-eqz v0, :cond_28

    const/4 v0, 0x1

    :goto_23
    int-to-byte v0, v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeByte(B)V

    return-void

    :cond_28
    const/4 v0, 0x0

    goto :goto_23
.end method
