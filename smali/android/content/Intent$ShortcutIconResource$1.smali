.class final Landroid/content/Intent$ShortcutIconResource$1;
.super Ljava/lang/Object;
.source "Intent.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/content/Intent$ShortcutIconResource;
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
        "Landroid/content/Intent$ShortcutIconResource;",
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
.method public createFromParcel(Landroid/os/Parcel;)Landroid/content/Intent$ShortcutIconResource;
    .registers 4
    .parameter "source"

    .prologue
    new-instance v0, Landroid/content/Intent$ShortcutIconResource;

    invoke-direct {v0}, Landroid/content/Intent$ShortcutIconResource;-><init>()V

    .local v0, icon:Landroid/content/Intent$ShortcutIconResource;
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Landroid/content/Intent$ShortcutIconResource;->packageName:Ljava/lang/String;

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Landroid/content/Intent$ShortcutIconResource;->resourceName:Ljava/lang/String;

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    invoke-virtual {p0, p1}, Landroid/content/Intent$ShortcutIconResource$1;->createFromParcel(Landroid/os/Parcel;)Landroid/content/Intent$ShortcutIconResource;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Landroid/content/Intent$ShortcutIconResource;
    .registers 3
    .parameter "size"

    .prologue
    new-array v0, p1, [Landroid/content/Intent$ShortcutIconResource;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    invoke-virtual {p0, p1}, Landroid/content/Intent$ShortcutIconResource$1;->newArray(I)[Landroid/content/Intent$ShortcutIconResource;

    move-result-object v0

    return-object v0
.end method
