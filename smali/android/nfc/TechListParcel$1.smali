.class final Landroid/nfc/TechListParcel$1;
.super Ljava/lang/Object;
.source "TechListParcel.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/nfc/TechListParcel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/os/Parcelable$Creator",
        "<",
        "Landroid/nfc/TechListParcel;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 50
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Landroid/nfc/TechListParcel;
    .registers 6
    .parameter "source"

    .prologue
    .line 53
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 54
    .local v0, count:I
    new-array v2, v0, [[Ljava/lang/String;

    .line 55
    .local v2, techLists:[[Ljava/lang/String;
    const/4 v1, 0x0

    .local v1, i:I
    :goto_7
    if-ge v1, v0, :cond_12

    .line 56
    invoke-virtual {p1}, Landroid/os/Parcel;->readStringArray()[Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v1

    .line 55
    add-int/lit8 v1, v1, 0x1

    goto :goto_7

    .line 58
    :cond_12
    new-instance v3, Landroid/nfc/TechListParcel;

    invoke-direct {v3, v2}, Landroid/nfc/TechListParcel;-><init>([[Ljava/lang/String;)V

    return-object v3
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 50
    invoke-virtual {p0, p1}, Landroid/nfc/TechListParcel$1;->createFromParcel(Landroid/os/Parcel;)Landroid/nfc/TechListParcel;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Landroid/nfc/TechListParcel;
    .registers 3
    .parameter "size"

    .prologue
    .line 63
    new-array v0, p1, [Landroid/nfc/TechListParcel;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 50
    invoke-virtual {p0, p1}, Landroid/nfc/TechListParcel$1;->newArray(I)[Landroid/nfc/TechListParcel;

    move-result-object v0

    return-object v0
.end method
