.class final Landroid/app/FragmentManagerState$1;
.super Ljava/lang/Object;
.source "FragmentManager.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/app/FragmentManagerState;
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
        "Landroid/app/FragmentManagerState;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 371
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Landroid/app/FragmentManagerState;
    .registers 3
    .parameter "in"

    .prologue
    .line 373
    new-instance v0, Landroid/app/FragmentManagerState;

    invoke-direct {v0, p1}, Landroid/app/FragmentManagerState;-><init>(Landroid/os/Parcel;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 371
    invoke-virtual {p0, p1}, Landroid/app/FragmentManagerState$1;->createFromParcel(Landroid/os/Parcel;)Landroid/app/FragmentManagerState;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Landroid/app/FragmentManagerState;
    .registers 3
    .parameter "size"

    .prologue
    .line 377
    new-array v0, p1, [Landroid/app/FragmentManagerState;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 371
    invoke-virtual {p0, p1}, Landroid/app/FragmentManagerState$1;->newArray(I)[Landroid/app/FragmentManagerState;

    move-result-object v0

    return-object v0
.end method
