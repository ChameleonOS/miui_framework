.class final Landroid/app/FragmentState$1;
.super Ljava/lang/Object;
.source "Fragment.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/app/FragmentState;
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
        "Landroid/app/FragmentState;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 136
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Landroid/app/FragmentState;
    .registers 3
    .parameter "in"

    .prologue
    .line 138
    new-instance v0, Landroid/app/FragmentState;

    invoke-direct {v0, p1}, Landroid/app/FragmentState;-><init>(Landroid/os/Parcel;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 136
    invoke-virtual {p0, p1}, Landroid/app/FragmentState$1;->createFromParcel(Landroid/os/Parcel;)Landroid/app/FragmentState;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Landroid/app/FragmentState;
    .registers 3
    .parameter "size"

    .prologue
    .line 142
    new-array v0, p1, [Landroid/app/FragmentState;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 136
    invoke-virtual {p0, p1}, Landroid/app/FragmentState$1;->newArray(I)[Landroid/app/FragmentState;

    move-result-object v0

    return-object v0
.end method
