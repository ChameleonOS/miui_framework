.class final Landroid/net/Uri$1;
.super Ljava/lang/Object;
.source "Uri.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/net/Uri;
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
        "Landroid/net/Uri;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 1757
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Landroid/net/Uri;
    .registers 6
    .parameter "in"

    .prologue
    .line 1759
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 1760
    .local v0, type:I
    packed-switch v0, :pswitch_data_32

    .line 1768
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Unknown URI type: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1761
    :pswitch_20
    const/4 v1, 0x0

    .line 1765
    :goto_21
    return-object v1

    .line 1762
    :pswitch_22
    invoke-static {p1}, Landroid/net/Uri$StringUri;->readFrom(Landroid/os/Parcel;)Landroid/net/Uri;

    move-result-object v1

    goto :goto_21

    .line 1763
    :pswitch_27
    invoke-static {p1}, Landroid/net/Uri$OpaqueUri;->readFrom(Landroid/os/Parcel;)Landroid/net/Uri;

    move-result-object v1

    goto :goto_21

    .line 1765
    :pswitch_2c
    invoke-static {p1}, Landroid/net/Uri$HierarchicalUri;->readFrom(Landroid/os/Parcel;)Landroid/net/Uri;

    move-result-object v1

    goto :goto_21

    .line 1760
    nop

    :pswitch_data_32
    .packed-switch 0x0
        :pswitch_20
        :pswitch_22
        :pswitch_27
        :pswitch_2c
    .end packed-switch
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 1757
    invoke-virtual {p0, p1}, Landroid/net/Uri$1;->createFromParcel(Landroid/os/Parcel;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Landroid/net/Uri;
    .registers 3
    .parameter "size"

    .prologue
    .line 1772
    new-array v0, p1, [Landroid/net/Uri;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 1757
    invoke-virtual {p0, p1}, Landroid/net/Uri$1;->newArray(I)[Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method
