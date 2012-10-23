.class final Lmiui/provider/MusicSearchProvider$MusicMeta$1;
.super Ljava/lang/Object;
.source "MusicSearchProvider.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/provider/MusicSearchProvider$MusicMeta;
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
        "Lmiui/provider/MusicSearchProvider$MusicMeta;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 333
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 333
    invoke-virtual {p0, p1}, Lmiui/provider/MusicSearchProvider$MusicMeta$1;->createFromParcel(Landroid/os/Parcel;)Lmiui/provider/MusicSearchProvider$MusicMeta;

    move-result-object v0

    return-object v0
.end method

.method public createFromParcel(Landroid/os/Parcel;)Lmiui/provider/MusicSearchProvider$MusicMeta;
    .registers 3
    .parameter "source"

    .prologue
    .line 337
    new-instance v0, Lmiui/provider/MusicSearchProvider$MusicMeta;

    invoke-direct {v0, p1}, Lmiui/provider/MusicSearchProvider$MusicMeta;-><init>(Landroid/os/Parcel;)V

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 333
    invoke-virtual {p0, p1}, Lmiui/provider/MusicSearchProvider$MusicMeta$1;->newArray(I)[Lmiui/provider/MusicSearchProvider$MusicMeta;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Lmiui/provider/MusicSearchProvider$MusicMeta;
    .registers 3
    .parameter "size"

    .prologue
    .line 342
    new-array v0, p1, [Lmiui/provider/MusicSearchProvider$MusicMeta;

    return-object v0
.end method
