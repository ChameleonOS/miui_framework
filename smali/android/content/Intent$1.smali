.class final Landroid/content/Intent$1;
.super Ljava/lang/Object;
.source "Intent.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/content/Intent;
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
        "Landroid/content/Intent;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 6474
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Landroid/content/Intent;
    .registers 3
    .parameter "in"

    .prologue
    .line 6476
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0, p1}, Landroid/content/Intent;-><init>(Landroid/os/Parcel;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 6474
    invoke-virtual {p0, p1}, Landroid/content/Intent$1;->createFromParcel(Landroid/os/Parcel;)Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Landroid/content/Intent;
    .registers 3
    .parameter "size"

    .prologue
    .line 6479
    new-array v0, p1, [Landroid/content/Intent;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 6474
    invoke-virtual {p0, p1}, Landroid/content/Intent$1;->newArray(I)[Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method
