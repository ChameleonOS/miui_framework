.class final Landroid/app/SearchableInfo$1;
.super Ljava/lang/Object;
.source "SearchableInfo.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/app/SearchableInfo;
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
        "Landroid/app/SearchableInfo;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 778
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Landroid/app/SearchableInfo;
    .registers 3
    .parameter "in"

    .prologue
    .line 780
    new-instance v0, Landroid/app/SearchableInfo;

    invoke-direct {v0, p1}, Landroid/app/SearchableInfo;-><init>(Landroid/os/Parcel;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 778
    invoke-virtual {p0, p1}, Landroid/app/SearchableInfo$1;->createFromParcel(Landroid/os/Parcel;)Landroid/app/SearchableInfo;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Landroid/app/SearchableInfo;
    .registers 3
    .parameter "size"

    .prologue
    .line 784
    new-array v0, p1, [Landroid/app/SearchableInfo;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 778
    invoke-virtual {p0, p1}, Landroid/app/SearchableInfo$1;->newArray(I)[Landroid/app/SearchableInfo;

    move-result-object v0

    return-object v0
.end method
