.class final Landroid/content/pm/ResolveInfo$1;
.super Ljava/lang/Object;
.source "ResolveInfo.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/content/pm/ResolveInfo;
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
        "Landroid/content/pm/ResolveInfo;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Landroid/content/pm/ResolveInfo;
    .registers 4
    .parameter "source"

    .prologue
    new-instance v0, Landroid/content/pm/ResolveInfo;

    const/4 v1, 0x0

    invoke-direct {v0, p1, v1}, Landroid/content/pm/ResolveInfo;-><init>(Landroid/os/Parcel;Landroid/content/pm/ResolveInfo$1;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    invoke-virtual {p0, p1}, Landroid/content/pm/ResolveInfo$1;->createFromParcel(Landroid/os/Parcel;)Landroid/content/pm/ResolveInfo;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Landroid/content/pm/ResolveInfo;
    .registers 3
    .parameter "size"

    .prologue
    new-array v0, p1, [Landroid/content/pm/ResolveInfo;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    invoke-virtual {p0, p1}, Landroid/content/pm/ResolveInfo$1;->newArray(I)[Landroid/content/pm/ResolveInfo;

    move-result-object v0

    return-object v0
.end method
