.class final Landroid/content/pm/Signature$1;
.super Ljava/lang/Object;
.source "Signature.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/content/pm/Signature;
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
        "Landroid/content/pm/Signature;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 188
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Landroid/content/pm/Signature;
    .registers 4
    .parameter "source"

    .prologue
    .line 190
    new-instance v0, Landroid/content/pm/Signature;

    const/4 v1, 0x0

    invoke-direct {v0, p1, v1}, Landroid/content/pm/Signature;-><init>(Landroid/os/Parcel;Landroid/content/pm/Signature$1;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 188
    invoke-virtual {p0, p1}, Landroid/content/pm/Signature$1;->createFromParcel(Landroid/os/Parcel;)Landroid/content/pm/Signature;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Landroid/content/pm/Signature;
    .registers 3
    .parameter "size"

    .prologue
    .line 194
    new-array v0, p1, [Landroid/content/pm/Signature;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 188
    invoke-virtual {p0, p1}, Landroid/content/pm/Signature$1;->newArray(I)[Landroid/content/pm/Signature;

    move-result-object v0

    return-object v0
.end method
