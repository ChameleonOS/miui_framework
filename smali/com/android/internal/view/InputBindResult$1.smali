.class final Lcom/android/internal/view/InputBindResult$1;
.super Ljava/lang/Object;
.source "InputBindResult.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/internal/view/InputBindResult;
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
        "Lcom/android/internal/view/InputBindResult;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 78
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Lcom/android/internal/view/InputBindResult;
    .registers 3
    .parameter "source"

    .prologue
    .line 80
    new-instance v0, Lcom/android/internal/view/InputBindResult;

    invoke-direct {v0, p1}, Lcom/android/internal/view/InputBindResult;-><init>(Landroid/os/Parcel;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 78
    invoke-virtual {p0, p1}, Lcom/android/internal/view/InputBindResult$1;->createFromParcel(Landroid/os/Parcel;)Lcom/android/internal/view/InputBindResult;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Lcom/android/internal/view/InputBindResult;
    .registers 3
    .parameter "size"

    .prologue
    .line 84
    new-array v0, p1, [Lcom/android/internal/view/InputBindResult;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 78
    invoke-virtual {p0, p1}, Lcom/android/internal/view/InputBindResult$1;->newArray(I)[Lcom/android/internal/view/InputBindResult;

    move-result-object v0

    return-object v0
.end method
