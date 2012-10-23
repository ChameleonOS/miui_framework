.class public final Landroid/view/textservice/SentenceSuggestionsInfo;
.super Ljava/lang/Object;
.source "SentenceSuggestionsInfo.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Landroid/view/textservice/SentenceSuggestionsInfo;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final mLengths:[I

.field private final mOffsets:[I

.field private final mSuggestionsInfos:[Landroid/view/textservice/SuggestionsInfo;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 132
    new-instance v0, Landroid/view/textservice/SentenceSuggestionsInfo$1;

    invoke-direct {v0}, Landroid/view/textservice/SentenceSuggestionsInfo$1;-><init>()V

    sput-object v0, Landroid/view/textservice/SentenceSuggestionsInfo;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .registers 5
    .parameter "source"

    .prologue
    .line 59
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 60
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .line 61
    .local v0, infoSize:I
    new-array v1, v0, [Landroid/view/textservice/SuggestionsInfo;

    iput-object v1, p0, Landroid/view/textservice/SentenceSuggestionsInfo;->mSuggestionsInfos:[Landroid/view/textservice/SuggestionsInfo;

    .line 62
    iget-object v1, p0, Landroid/view/textservice/SentenceSuggestionsInfo;->mSuggestionsInfos:[Landroid/view/textservice/SuggestionsInfo;

    sget-object v2, Landroid/view/textservice/SuggestionsInfo;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-virtual {p1, v1, v2}, Landroid/os/Parcel;->readTypedArray([Ljava/lang/Object;Landroid/os/Parcelable$Creator;)V

    .line 63
    iget-object v1, p0, Landroid/view/textservice/SentenceSuggestionsInfo;->mSuggestionsInfos:[Landroid/view/textservice/SuggestionsInfo;

    array-length v1, v1

    new-array v1, v1, [I

    iput-object v1, p0, Landroid/view/textservice/SentenceSuggestionsInfo;->mOffsets:[I

    .line 64
    iget-object v1, p0, Landroid/view/textservice/SentenceSuggestionsInfo;->mOffsets:[I

    invoke-virtual {p1, v1}, Landroid/os/Parcel;->readIntArray([I)V

    .line 65
    iget-object v1, p0, Landroid/view/textservice/SentenceSuggestionsInfo;->mSuggestionsInfos:[Landroid/view/textservice/SuggestionsInfo;

    array-length v1, v1

    new-array v1, v1, [I

    iput-object v1, p0, Landroid/view/textservice/SentenceSuggestionsInfo;->mLengths:[I

    .line 66
    iget-object v1, p0, Landroid/view/textservice/SentenceSuggestionsInfo;->mLengths:[I

    invoke-virtual {p1, v1}, Landroid/os/Parcel;->readIntArray([I)V

    .line 67
    return-void
.end method

.method public constructor <init>([Landroid/view/textservice/SuggestionsInfo;[I[I)V
    .registers 7
    .parameter "suggestionsInfos"
    .parameter "offsets"
    .parameter "lengths"

    .prologue
    .line 46
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 47
    if-eqz p1, :cond_9

    if-eqz p2, :cond_9

    if-nez p3, :cond_f

    .line 48
    :cond_9
    new-instance v1, Ljava/lang/NullPointerException;

    invoke-direct {v1}, Ljava/lang/NullPointerException;-><init>()V

    throw v1

    .line 50
    :cond_f
    array-length v1, p1

    array-length v2, p2

    if-ne v1, v2, :cond_17

    array-length v1, p2

    array-length v2, p3

    if-eq v1, v2, :cond_1d

    .line 51
    :cond_17
    new-instance v1, Ljava/lang/IllegalArgumentException;

    invoke-direct {v1}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v1

    .line 53
    :cond_1d
    array-length v0, p1

    .line 54
    .local v0, infoSize:I
    invoke-static {p1, v0}, Ljava/util/Arrays;->copyOf([Ljava/lang/Object;I)[Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Landroid/view/textservice/SuggestionsInfo;

    iput-object v1, p0, Landroid/view/textservice/SentenceSuggestionsInfo;->mSuggestionsInfos:[Landroid/view/textservice/SuggestionsInfo;

    .line 55
    invoke-static {p2, v0}, Ljava/util/Arrays;->copyOf([II)[I

    move-result-object v1

    iput-object v1, p0, Landroid/view/textservice/SentenceSuggestionsInfo;->mOffsets:[I

    .line 56
    invoke-static {p3, v0}, Ljava/util/Arrays;->copyOf([II)[I

    move-result-object v1

    iput-object v1, p0, Landroid/view/textservice/SentenceSuggestionsInfo;->mLengths:[I

    .line 57
    return-void
.end method


# virtual methods
.method public describeContents()I
    .registers 2

    .prologue
    .line 86
    const/4 v0, 0x0

    return v0
.end method

.method public getLengthAt(I)I
    .registers 3
    .parameter "i"

    .prologue
    .line 123
    if-ltz p1, :cond_c

    iget-object v0, p0, Landroid/view/textservice/SentenceSuggestionsInfo;->mLengths:[I

    array-length v0, v0

    if-ge p1, v0, :cond_c

    .line 124
    iget-object v0, p0, Landroid/view/textservice/SentenceSuggestionsInfo;->mLengths:[I

    aget v0, v0, p1

    .line 126
    :goto_b
    return v0

    :cond_c
    const/4 v0, -0x1

    goto :goto_b
.end method

.method public getOffsetAt(I)I
    .registers 3
    .parameter "i"

    .prologue
    .line 112
    if-ltz p1, :cond_c

    iget-object v0, p0, Landroid/view/textservice/SentenceSuggestionsInfo;->mOffsets:[I

    array-length v0, v0

    if-ge p1, v0, :cond_c

    .line 113
    iget-object v0, p0, Landroid/view/textservice/SentenceSuggestionsInfo;->mOffsets:[I

    aget v0, v0, p1

    .line 115
    :goto_b
    return v0

    :cond_c
    const/4 v0, -0x1

    goto :goto_b
.end method

.method public getSuggestionsCount()I
    .registers 2

    .prologue
    .line 93
    iget-object v0, p0, Landroid/view/textservice/SentenceSuggestionsInfo;->mSuggestionsInfos:[Landroid/view/textservice/SuggestionsInfo;

    array-length v0, v0

    return v0
.end method

.method public getSuggestionsInfoAt(I)Landroid/view/textservice/SuggestionsInfo;
    .registers 3
    .parameter "i"

    .prologue
    .line 101
    if-ltz p1, :cond_c

    iget-object v0, p0, Landroid/view/textservice/SentenceSuggestionsInfo;->mSuggestionsInfos:[Landroid/view/textservice/SuggestionsInfo;

    array-length v0, v0

    if-ge p1, v0, :cond_c

    .line 102
    iget-object v0, p0, Landroid/view/textservice/SentenceSuggestionsInfo;->mSuggestionsInfos:[Landroid/view/textservice/SuggestionsInfo;

    aget-object v0, v0, p1

    .line 104
    :goto_b
    return-object v0

    :cond_c
    const/4 v0, 0x0

    goto :goto_b
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 6
    .parameter "dest"
    .parameter "flags"

    .prologue
    .line 77
    iget-object v1, p0, Landroid/view/textservice/SentenceSuggestionsInfo;->mSuggestionsInfos:[Landroid/view/textservice/SuggestionsInfo;

    array-length v0, v1

    .line 78
    .local v0, infoSize:I
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 79
    iget-object v1, p0, Landroid/view/textservice/SentenceSuggestionsInfo;->mSuggestionsInfos:[Landroid/view/textservice/SuggestionsInfo;

    const/4 v2, 0x0

    invoke-virtual {p1, v1, v2}, Landroid/os/Parcel;->writeTypedArray([Landroid/os/Parcelable;I)V

    .line 80
    iget-object v1, p0, Landroid/view/textservice/SentenceSuggestionsInfo;->mOffsets:[I

    invoke-virtual {p1, v1}, Landroid/os/Parcel;->writeIntArray([I)V

    .line 81
    iget-object v1, p0, Landroid/view/textservice/SentenceSuggestionsInfo;->mLengths:[I

    invoke-virtual {p1, v1}, Landroid/os/Parcel;->writeIntArray([I)V

    .line 82
    return-void
.end method
