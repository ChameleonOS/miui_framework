.class final Landroid/content/pm/PackageInfoLite$1;
.super Ljava/lang/Object;
.source "PackageInfoLite.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/content/pm/PackageInfoLite;
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
        "Landroid/content/pm/PackageInfoLite;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 73
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Landroid/content/pm/PackageInfoLite;
    .registers 4
    .parameter "source"

    .prologue
    .line 75
    new-instance v0, Landroid/content/pm/PackageInfoLite;

    const/4 v1, 0x0

    invoke-direct {v0, p1, v1}, Landroid/content/pm/PackageInfoLite;-><init>(Landroid/os/Parcel;Landroid/content/pm/PackageInfoLite$1;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 73
    invoke-virtual {p0, p1}, Landroid/content/pm/PackageInfoLite$1;->createFromParcel(Landroid/os/Parcel;)Landroid/content/pm/PackageInfoLite;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Landroid/content/pm/PackageInfoLite;
    .registers 3
    .parameter "size"

    .prologue
    .line 79
    new-array v0, p1, [Landroid/content/pm/PackageInfoLite;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 73
    invoke-virtual {p0, p1}, Landroid/content/pm/PackageInfoLite$1;->newArray(I)[Landroid/content/pm/PackageInfoLite;

    move-result-object v0

    return-object v0
.end method
