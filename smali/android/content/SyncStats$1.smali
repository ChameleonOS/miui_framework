.class final Landroid/content/SyncStats$1;
.super Ljava/lang/Object;
.source "SyncStats.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/content/SyncStats;
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
        "Landroid/content/SyncStats;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 169
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Landroid/content/SyncStats;
    .registers 3
    .parameter "in"

    .prologue
    .line 171
    new-instance v0, Landroid/content/SyncStats;

    invoke-direct {v0, p1}, Landroid/content/SyncStats;-><init>(Landroid/os/Parcel;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 169
    invoke-virtual {p0, p1}, Landroid/content/SyncStats$1;->createFromParcel(Landroid/os/Parcel;)Landroid/content/SyncStats;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Landroid/content/SyncStats;
    .registers 3
    .parameter "size"

    .prologue
    .line 175
    new-array v0, p1, [Landroid/content/SyncStats;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 169
    invoke-virtual {p0, p1}, Landroid/content/SyncStats$1;->newArray(I)[Landroid/content/SyncStats;

    move-result-object v0

    return-object v0
.end method
