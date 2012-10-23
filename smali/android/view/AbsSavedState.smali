.class public abstract Landroid/view/AbsSavedState;
.super Ljava/lang/Object;
.source "AbsSavedState.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Landroid/view/AbsSavedState;",
            ">;"
        }
    .end annotation
.end field

.field public static final EMPTY_STATE:Landroid/view/AbsSavedState;


# instance fields
.field private final mSuperState:Landroid/os/Parcelable;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 27
    new-instance v0, Landroid/view/AbsSavedState$1;

    invoke-direct {v0}, Landroid/view/AbsSavedState$1;-><init>()V

    sput-object v0, Landroid/view/AbsSavedState;->EMPTY_STATE:Landroid/view/AbsSavedState;

    .line 74
    new-instance v0, Landroid/view/AbsSavedState$2;

    invoke-direct {v0}, Landroid/view/AbsSavedState$2;-><init>()V

    sput-object v0, Landroid/view/AbsSavedState;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method private constructor <init>()V
    .registers 2

    .prologue
    .line 34
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 35
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/view/AbsSavedState;->mSuperState:Landroid/os/Parcelable;

    .line 36
    return-void
.end method

.method protected constructor <init>(Landroid/os/Parcel;)V
    .registers 4
    .parameter "source"

    .prologue
    .line 55
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 57
    const/4 v1, 0x0

    invoke-virtual {p1, v1}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v0

    .line 59
    .local v0, superState:Landroid/os/Parcelable;
    if-eqz v0, :cond_d

    .end local v0           #superState:Landroid/os/Parcelable;
    :goto_a
    iput-object v0, p0, Landroid/view/AbsSavedState;->mSuperState:Landroid/os/Parcelable;

    .line 60
    return-void

    .line 59
    .restart local v0       #superState:Landroid/os/Parcelable;
    :cond_d
    sget-object v0, Landroid/view/AbsSavedState;->EMPTY_STATE:Landroid/view/AbsSavedState;

    goto :goto_a
.end method

.method protected constructor <init>(Landroid/os/Parcelable;)V
    .registers 4
    .parameter "superState"

    .prologue
    .line 43
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 44
    if-nez p1, :cond_e

    .line 45
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "superState must not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 47
    :cond_e
    sget-object v0, Landroid/view/AbsSavedState;->EMPTY_STATE:Landroid/view/AbsSavedState;

    if-eq p1, v0, :cond_15

    .end local p1
    :goto_12
    iput-object p1, p0, Landroid/view/AbsSavedState;->mSuperState:Landroid/os/Parcelable;

    .line 48
    return-void

    .line 47
    .restart local p1
    :cond_15
    const/4 p1, 0x0

    goto :goto_12
.end method

.method synthetic constructor <init>(Landroid/view/AbsSavedState$1;)V
    .registers 2
    .parameter "x0"

    .prologue
    .line 26
    invoke-direct {p0}, Landroid/view/AbsSavedState;-><init>()V

    return-void
.end method


# virtual methods
.method public describeContents()I
    .registers 2

    .prologue
    .line 67
    const/4 v0, 0x0

    return v0
.end method

.method public final getSuperState()Landroid/os/Parcelable;
    .registers 2

    .prologue
    .line 63
    iget-object v0, p0, Landroid/view/AbsSavedState;->mSuperState:Landroid/os/Parcelable;

    return-object v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 4
    .parameter "dest"
    .parameter "flags"

    .prologue
    .line 71
    iget-object v0, p0, Landroid/view/AbsSavedState;->mSuperState:Landroid/os/Parcelable;

    invoke-virtual {p1, v0, p2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 72
    return-void
.end method
