.class final Landroid/view/MotionEvent$1;
.super Ljava/lang/Object;
.source "MotionEvent.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/view/MotionEvent;
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
        "Landroid/view/MotionEvent;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 3137
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Landroid/view/MotionEvent;
    .registers 3
    .parameter "in"

    .prologue
    .line 3139
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    .line 3140
    invoke-static {p1}, Landroid/view/MotionEvent;->createFromParcelBody(Landroid/os/Parcel;)Landroid/view/MotionEvent;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 3137
    invoke-virtual {p0, p1}, Landroid/view/MotionEvent$1;->createFromParcel(Landroid/os/Parcel;)Landroid/view/MotionEvent;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Landroid/view/MotionEvent;
    .registers 3
    .parameter "size"

    .prologue
    .line 3144
    new-array v0, p1, [Landroid/view/MotionEvent;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 3137
    invoke-virtual {p0, p1}, Landroid/view/MotionEvent$1;->newArray(I)[Landroid/view/MotionEvent;

    move-result-object v0

    return-object v0
.end method
