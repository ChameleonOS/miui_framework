.class final Landroid/preference/DialogPreference$SavedState$1;
.super Ljava/lang/Object;
.source "DialogPreference.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/preference/DialogPreference$SavedState;
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
        "Landroid/preference/DialogPreference$SavedState;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 467
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Landroid/preference/DialogPreference$SavedState;
    .registers 3
    .parameter "in"

    .prologue
    .line 469
    new-instance v0, Landroid/preference/DialogPreference$SavedState;

    invoke-direct {v0, p1}, Landroid/preference/DialogPreference$SavedState;-><init>(Landroid/os/Parcel;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 467
    invoke-virtual {p0, p1}, Landroid/preference/DialogPreference$SavedState$1;->createFromParcel(Landroid/os/Parcel;)Landroid/preference/DialogPreference$SavedState;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Landroid/preference/DialogPreference$SavedState;
    .registers 3
    .parameter "size"

    .prologue
    .line 473
    new-array v0, p1, [Landroid/preference/DialogPreference$SavedState;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 467
    invoke-virtual {p0, p1}, Landroid/preference/DialogPreference$SavedState$1;->newArray(I)[Landroid/preference/DialogPreference$SavedState;

    move-result-object v0

    return-object v0
.end method
