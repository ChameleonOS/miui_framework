.class final Landroid/content/pm/ParceledListSlice$1;
.super Ljava/lang/Object;
.source "ParceledListSlice.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/content/pm/ParceledListSlice;
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
        "Landroid/content/pm/ParceledListSlice;",
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
.method public createFromParcel(Landroid/os/Parcel;)Landroid/content/pm/ParceledListSlice;
    .registers 10
    .parameter "in"

    .prologue
    const/4 v0, 0x1

    const/4 v6, 0x0

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v2

    .local v2, numItems:I
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v7

    if-ne v7, v0, :cond_2f

    .local v0, lastSlice:Z
    :goto_c
    if-lez v2, :cond_31

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v5

    .local v5, parcelSize:I
    invoke-virtual {p1}, Landroid/os/Parcel;->dataPosition()I

    move-result v3

    .local v3, offset:I
    add-int v7, v3, v5

    invoke-virtual {p1, v7}, Landroid/os/Parcel;->setDataPosition(I)V

    invoke-static {}, Landroid/os/Parcel;->obtain()Landroid/os/Parcel;

    move-result-object v4

    .local v4, p:Landroid/os/Parcel;
    invoke-virtual {v4, v6}, Landroid/os/Parcel;->setDataPosition(I)V

    invoke-virtual {v4, p1, v3, v5}, Landroid/os/Parcel;->appendFrom(Landroid/os/Parcel;II)V

    invoke-virtual {v4, v6}, Landroid/os/Parcel;->setDataPosition(I)V

    new-instance v1, Landroid/content/pm/ParceledListSlice;

    const/4 v6, 0x0

    invoke-direct {v1, v4, v2, v0, v6}, Landroid/content/pm/ParceledListSlice;-><init>(Landroid/os/Parcel;IZLandroid/content/pm/ParceledListSlice$1;)V

    .end local v3           #offset:I
    .end local v4           #p:Landroid/os/Parcel;
    .end local v5           #parcelSize:I
    :goto_2e
    return-object v1

    .end local v0           #lastSlice:Z
    :cond_2f
    move v0, v6

    goto :goto_c

    .restart local v0       #lastSlice:Z
    :cond_31
    new-instance v1, Landroid/content/pm/ParceledListSlice;

    invoke-direct {v1}, Landroid/content/pm/ParceledListSlice;-><init>()V

    .local v1, list:Landroid/content/pm/ParceledListSlice;
    invoke-virtual {v1, v0}, Landroid/content/pm/ParceledListSlice;->setLastSlice(Z)V

    goto :goto_2e
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    invoke-virtual {p0, p1}, Landroid/content/pm/ParceledListSlice$1;->createFromParcel(Landroid/os/Parcel;)Landroid/content/pm/ParceledListSlice;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Landroid/content/pm/ParceledListSlice;
    .registers 3
    .parameter "size"

    .prologue
    new-array v0, p1, [Landroid/content/pm/ParceledListSlice;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    invoke-virtual {p0, p1}, Landroid/content/pm/ParceledListSlice$1;->newArray(I)[Landroid/content/pm/ParceledListSlice;

    move-result-object v0

    return-object v0
.end method
