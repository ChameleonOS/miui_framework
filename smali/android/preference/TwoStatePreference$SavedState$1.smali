.class final Landroid/preference/TwoStatePreference$SavedState$1;
.super Ljava/lang/Object;
.source "TwoStatePreference.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/preference/TwoStatePreference$SavedState;
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
        "Landroid/preference/TwoStatePreference$SavedState;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .registers 1

    .prologue
    .line 284
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Landroid/preference/TwoStatePreference$SavedState;
    .registers 3
    .parameter "in"

    .prologue
    .line 286
    new-instance v0, Landroid/preference/TwoStatePreference$SavedState;

    invoke-direct {v0, p1}, Landroid/preference/TwoStatePreference$SavedState;-><init>(Landroid/os/Parcel;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 284
    invoke-virtual {p0, p1}, Landroid/preference/TwoStatePreference$SavedState$1;->createFromParcel(Landroid/os/Parcel;)Landroid/preference/TwoStatePreference$SavedState;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Landroid/preference/TwoStatePreference$SavedState;
    .registers 3
    .parameter "size"

    .prologue
    .line 290
    new-array v0, p1, [Landroid/preference/TwoStatePreference$SavedState;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .registers 3
    .parameter "x0"

    .prologue
    .line 284
    invoke-virtual {p0, p1}, Landroid/preference/TwoStatePreference$SavedState$1;->newArray(I)[Landroid/preference/TwoStatePreference$SavedState;

    move-result-object v0

    return-object v0
.end method
