.class public Lmiui/provider/MusicSearchProvider$MusicSearchResult;
.super Ljava/lang/Object;
.source "MusicSearchProvider.java"

# interfaces
.implements Landroid/os/Parcelable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lmiui/provider/MusicSearchProvider;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MusicSearchResult"
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lmiui/provider/MusicSearchProvider$MusicSearchResult;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field public final mKeys:[Ljava/lang/String;

.field private final mLocalResult:[Lmiui/provider/MusicSearchProvider$MusicMeta;

.field private final mOnlineResult:[Lmiui/provider/MusicSearchProvider$MusicMeta;

.field public final mType:I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    new-instance v0, Lmiui/provider/MusicSearchProvider$MusicSearchResult$1;

    invoke-direct {v0}, Lmiui/provider/MusicSearchProvider$MusicSearchResult$1;-><init>()V

    sput-object v0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method constructor <init>(Landroid/os/Parcel;)V
    .registers 3
    .parameter "source"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    sget-object v0, Lmiui/provider/MusicSearchProvider$MusicMeta;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->createTypedArray(Landroid/os/Parcelable$Creator;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lmiui/provider/MusicSearchProvider$MusicMeta;

    iput-object v0, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mLocalResult:[Lmiui/provider/MusicSearchProvider$MusicMeta;

    sget-object v0, Lmiui/provider/MusicSearchProvider$MusicMeta;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->createTypedArray(Landroid/os/Parcelable$Creator;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lmiui/provider/MusicSearchProvider$MusicMeta;

    iput-object v0, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mOnlineResult:[Lmiui/provider/MusicSearchProvider$MusicMeta;

    invoke-virtual {p1}, Landroid/os/Parcel;->readStringArray()[Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mKeys:[Ljava/lang/String;

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mType:I

    return-void
.end method

.method public constructor <init>([Lmiui/provider/MusicSearchProvider$MusicMeta;[Lmiui/provider/MusicSearchProvider$MusicMeta;[Ljava/lang/String;I)V
    .registers 5
    .parameter "local"
    .parameter "online"
    .parameter "key"
    .parameter "type"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mLocalResult:[Lmiui/provider/MusicSearchProvider$MusicMeta;

    iput-object p2, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mOnlineResult:[Lmiui/provider/MusicSearchProvider$MusicMeta;

    iput-object p3, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mKeys:[Ljava/lang/String;

    iput p4, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mType:I

    return-void
.end method


# virtual methods
.method public describeContents()I
    .registers 2

    .prologue
    const/4 v0, 0x0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .registers 7
    .parameter "obj"

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    if-ne p0, p1, :cond_5

    :cond_4
    :goto_4
    return v1

    :cond_5
    instance-of v3, p1, Lmiui/provider/MusicSearchProvider$MusicSearchResult;

    if-nez v3, :cond_b

    move v1, v2

    goto :goto_4

    :cond_b
    move-object v0, p1

    check-cast v0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;

    .local v0, other:Lmiui/provider/MusicSearchProvider$MusicSearchResult;
    iget v3, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mType:I

    iget v4, v0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mType:I

    if-ne v3, v4, :cond_32

    iget-object v3, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mKeys:[Ljava/lang/String;

    iget-object v4, v0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mKeys:[Ljava/lang/String;

    invoke-static {v3, v4}, Ljava/util/Arrays;->equals([Ljava/lang/Object;[Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_32

    iget-object v3, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mLocalResult:[Lmiui/provider/MusicSearchProvider$MusicMeta;

    iget-object v4, v0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mLocalResult:[Lmiui/provider/MusicSearchProvider$MusicMeta;

    invoke-static {v3, v4}, Ljava/util/Arrays;->equals([Ljava/lang/Object;[Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_32

    iget-object v3, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mOnlineResult:[Lmiui/provider/MusicSearchProvider$MusicMeta;

    iget-object v4, v0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mOnlineResult:[Lmiui/provider/MusicSearchProvider$MusicMeta;

    invoke-static {v3, v4}, Ljava/util/Arrays;->equals([Ljava/lang/Object;[Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_4

    :cond_32
    move v1, v2

    goto :goto_4
.end method

.method public getCount()I
    .registers 3

    .prologue
    invoke-virtual {p0}, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->localCount()I

    move-result v0

    invoke-virtual {p0}, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->onlineCount()I

    move-result v1

    add-int/2addr v0, v1

    return v0
.end method

.method public hashCode()I
    .registers 9

    .prologue
    const/4 v6, 0x0

    iget-object v5, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mKeys:[Ljava/lang/String;

    if-nez v5, :cond_6

    :goto_5
    return v6

    :cond_6
    const/4 v3, 0x0

    .local v3, result:I
    iget-object v0, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mKeys:[Ljava/lang/String;

    .local v0, arr$:[Ljava/lang/String;
    array-length v2, v0

    .local v2, len$:I
    const/4 v1, 0x0

    .local v1, i$:I
    :goto_b
    if-ge v1, v2, :cond_1e

    aget-object v4, v0, v1

    .local v4, s:Ljava/lang/String;
    mul-int/lit8 v7, v3, 0x1f

    if-nez v4, :cond_19

    move v5, v6

    :goto_14
    add-int v3, v7, v5

    add-int/lit8 v1, v1, 0x1

    goto :goto_b

    :cond_19
    invoke-virtual {v4}, Ljava/lang/String;->hashCode()I

    move-result v5

    goto :goto_14

    .end local v4           #s:Ljava/lang/String;
    :cond_1e
    move v6, v3

    goto :goto_5
.end method

.method public localCount()I
    .registers 2

    .prologue
    iget-object v0, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mLocalResult:[Lmiui/provider/MusicSearchProvider$MusicMeta;

    if-eqz v0, :cond_8

    iget-object v0, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mLocalResult:[Lmiui/provider/MusicSearchProvider$MusicMeta;

    array-length v0, v0

    :goto_7
    return v0

    :cond_8
    const/4 v0, 0x0

    goto :goto_7
.end method

.method public localResult(I)Lmiui/provider/MusicSearchProvider$MusicMeta;
    .registers 3
    .parameter "i"

    .prologue
    iget-object v0, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mLocalResult:[Lmiui/provider/MusicSearchProvider$MusicMeta;

    aget-object v0, v0, p1

    return-object v0
.end method

.method public localResult()[Lmiui/provider/MusicSearchProvider$MusicMeta;
    .registers 5

    .prologue
    const/4 v3, 0x0

    const/4 v0, 0x0

    .local v0, ret:[Lmiui/provider/MusicSearchProvider$MusicMeta;
    iget-object v1, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mLocalResult:[Lmiui/provider/MusicSearchProvider$MusicMeta;

    if-eqz v1, :cond_13

    iget-object v1, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mLocalResult:[Lmiui/provider/MusicSearchProvider$MusicMeta;

    array-length v1, v1

    new-array v0, v1, [Lmiui/provider/MusicSearchProvider$MusicMeta;

    iget-object v1, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mLocalResult:[Lmiui/provider/MusicSearchProvider$MusicMeta;

    iget-object v2, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mLocalResult:[Lmiui/provider/MusicSearchProvider$MusicMeta;

    array-length v2, v2

    invoke-static {v1, v3, v0, v3, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    :cond_13
    return-object v0
.end method

.method public onlineCount()I
    .registers 2

    .prologue
    iget-object v0, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mOnlineResult:[Lmiui/provider/MusicSearchProvider$MusicMeta;

    if-eqz v0, :cond_8

    iget-object v0, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mOnlineResult:[Lmiui/provider/MusicSearchProvider$MusicMeta;

    array-length v0, v0

    :goto_7
    return v0

    :cond_8
    const/4 v0, 0x0

    goto :goto_7
.end method

.method public onlineResult(I)Lmiui/provider/MusicSearchProvider$MusicMeta;
    .registers 3
    .parameter "i"

    .prologue
    iget-object v0, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mOnlineResult:[Lmiui/provider/MusicSearchProvider$MusicMeta;

    aget-object v0, v0, p1

    return-object v0
.end method

.method public onlineResult()[Lmiui/provider/MusicSearchProvider$MusicMeta;
    .registers 5

    .prologue
    const/4 v3, 0x0

    const/4 v0, 0x0

    .local v0, ret:[Lmiui/provider/MusicSearchProvider$MusicMeta;
    iget-object v1, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mOnlineResult:[Lmiui/provider/MusicSearchProvider$MusicMeta;

    if-eqz v1, :cond_13

    iget-object v1, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mOnlineResult:[Lmiui/provider/MusicSearchProvider$MusicMeta;

    array-length v1, v1

    new-array v0, v1, [Lmiui/provider/MusicSearchProvider$MusicMeta;

    iget-object v1, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mOnlineResult:[Lmiui/provider/MusicSearchProvider$MusicMeta;

    iget-object v2, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mOnlineResult:[Lmiui/provider/MusicSearchProvider$MusicMeta;

    array-length v2, v2

    invoke-static {v1, v3, v0, v3, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    :cond_13
    return-object v0
.end method

.method public result()[Lmiui/provider/MusicSearchProvider$MusicMeta;
    .registers 6

    .prologue
    const/4 v4, 0x0

    iget-object v1, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mLocalResult:[Lmiui/provider/MusicSearchProvider$MusicMeta;

    if-eqz v1, :cond_26

    iget-object v1, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mOnlineResult:[Lmiui/provider/MusicSearchProvider$MusicMeta;

    if-eqz v1, :cond_26

    iget-object v1, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mLocalResult:[Lmiui/provider/MusicSearchProvider$MusicMeta;

    array-length v1, v1

    iget-object v2, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mOnlineResult:[Lmiui/provider/MusicSearchProvider$MusicMeta;

    array-length v2, v2

    add-int/2addr v1, v2

    new-array v0, v1, [Lmiui/provider/MusicSearchProvider$MusicMeta;

    .local v0, ret:[Lmiui/provider/MusicSearchProvider$MusicMeta;
    iget-object v1, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mLocalResult:[Lmiui/provider/MusicSearchProvider$MusicMeta;

    iget-object v2, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mLocalResult:[Lmiui/provider/MusicSearchProvider$MusicMeta;

    array-length v2, v2

    invoke-static {v1, v4, v0, v4, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    iget-object v1, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mOnlineResult:[Lmiui/provider/MusicSearchProvider$MusicMeta;

    iget-object v2, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mLocalResult:[Lmiui/provider/MusicSearchProvider$MusicMeta;

    array-length v2, v2

    iget-object v3, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mOnlineResult:[Lmiui/provider/MusicSearchProvider$MusicMeta;

    array-length v3, v3

    invoke-static {v1, v4, v0, v2, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    :goto_25
    return-object v0

    .end local v0           #ret:[Lmiui/provider/MusicSearchProvider$MusicMeta;
    :cond_26
    iget-object v1, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mOnlineResult:[Lmiui/provider/MusicSearchProvider$MusicMeta;

    if-eqz v1, :cond_2f

    invoke-virtual {p0}, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->onlineResult()[Lmiui/provider/MusicSearchProvider$MusicMeta;

    move-result-object v0

    .restart local v0       #ret:[Lmiui/provider/MusicSearchProvider$MusicMeta;
    goto :goto_25

    .end local v0           #ret:[Lmiui/provider/MusicSearchProvider$MusicMeta;
    :cond_2f
    iget-object v1, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mLocalResult:[Lmiui/provider/MusicSearchProvider$MusicMeta;

    if-eqz v1, :cond_38

    invoke-virtual {p0}, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->localResult()[Lmiui/provider/MusicSearchProvider$MusicMeta;

    move-result-object v0

    .restart local v0       #ret:[Lmiui/provider/MusicSearchProvider$MusicMeta;
    goto :goto_25

    .end local v0           #ret:[Lmiui/provider/MusicSearchProvider$MusicMeta;
    :cond_38
    const/4 v0, 0x0

    .restart local v0       #ret:[Lmiui/provider/MusicSearchProvider$MusicMeta;
    goto :goto_25
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 4
    .parameter "dest"
    .parameter "flags"

    .prologue
    iget-object v0, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mLocalResult:[Lmiui/provider/MusicSearchProvider$MusicMeta;

    invoke-virtual {p1, v0, p2}, Landroid/os/Parcel;->writeTypedArray([Landroid/os/Parcelable;I)V

    iget-object v0, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mOnlineResult:[Lmiui/provider/MusicSearchProvider$MusicMeta;

    invoke-virtual {p1, v0, p2}, Landroid/os/Parcel;->writeTypedArray([Landroid/os/Parcelable;I)V

    iget-object v0, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mKeys:[Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeStringArray([Ljava/lang/String;)V

    iget v0, p0, Lmiui/provider/MusicSearchProvider$MusicSearchResult;->mType:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    return-void
.end method
