.class final Landroid/content/pm/ProviderInfo$1;
.super Ljava/lang/Object;
.source "ProviderInfo.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/content/pm/ProviderInfo;
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
        "Landroid/content/pm/ProviderInfo;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 119
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Landroid/content/pm/ProviderInfo;
    .registers 4
    .parameter "in"

    .prologue
    .line 121
    new-instance v0, Landroid/content/pm/ProviderInfo;

    const/4 v1, 0x0

    invoke-direct {v0, p1, v1}, Landroid/content/pm/ProviderInfo;-><init>(Landroid/os/Parcel;Landroid/content/pm/ProviderInfo$1;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 119
    invoke-virtual {p0, p1}, Landroid/content/pm/ProviderInfo$1;->createFromParcel(Landroid/os/Parcel;)Landroid/content/pm/ProviderInfo;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Landroid/content/pm/ProviderInfo;
    .registers 3
    .parameter "size"

    .prologue
    .line 125
    new-array v0, p1, [Landroid/content/pm/ProviderInfo;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 119
    invoke-virtual {p0, p1}, Landroid/content/pm/ProviderInfo$1;->newArray(I)[Landroid/content/pm/ProviderInfo;

    move-result-object v0

    return-object v0
.end method
