.class final Landroid/nfc/TransceiveResult$1;
.super Ljava/lang/Object;
.source "TransceiveResult.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/nfc/TransceiveResult;
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
        "Landroid/nfc/TransceiveResult;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 71
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Landroid/nfc/TransceiveResult;
    .registers 6
    .parameter "in"

    .prologue
    .line 74
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v2

    .line 77
    .local v2, result:I
    if-nez v2, :cond_15

    .line 78
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .line 79
    .local v1, responseLength:I
    new-array v0, v1, [B

    .line 80
    .local v0, responseData:[B
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->readByteArray([B)V

    .line 84
    .end local v1           #responseLength:I
    :goto_f
    new-instance v3, Landroid/nfc/TransceiveResult;

    invoke-direct {v3, v2, v0}, Landroid/nfc/TransceiveResult;-><init>(I[B)V

    return-object v3

    .line 82
    .end local v0           #responseData:[B
    :cond_15
    const/4 v0, 0x0

    .restart local v0       #responseData:[B
    goto :goto_f
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 71
    invoke-virtual {p0, p1}, Landroid/nfc/TransceiveResult$1;->createFromParcel(Landroid/os/Parcel;)Landroid/nfc/TransceiveResult;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Landroid/nfc/TransceiveResult;
    .registers 3
    .parameter "size"

    .prologue
    .line 89
    new-array v0, p1, [Landroid/nfc/TransceiveResult;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 71
    invoke-virtual {p0, p1}, Landroid/nfc/TransceiveResult$1;->newArray(I)[Landroid/nfc/TransceiveResult;

    move-result-object v0

    return-object v0
.end method
