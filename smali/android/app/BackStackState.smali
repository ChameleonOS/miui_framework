.class final Landroid/app/BackStackState;
.super Ljava/lang/Object;
.source "BackStackRecord.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Landroid/app/BackStackState;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field final mBreadCrumbShortTitleRes:I

.field final mBreadCrumbShortTitleText:Ljava/lang/CharSequence;

.field final mBreadCrumbTitleRes:I

.field final mBreadCrumbTitleText:Ljava/lang/CharSequence;

.field final mIndex:I

.field final mName:Ljava/lang/String;

.field final mOps:[I

.field final mTransition:I

.field final mTransitionStyle:I


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    new-instance v0, Landroid/app/BackStackState$1;

    invoke-direct {v0}, Landroid/app/BackStackState$1;-><init>()V

    sput-object v0, Landroid/app/BackStackState;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(Landroid/app/FragmentManagerImpl;Landroid/app/BackStackRecord;)V
    .registers 11
    .parameter "fm"
    .parameter "bse"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    const/4 v2, 0x0

    .local v2, numRemoved:I
    iget-object v3, p2, Landroid/app/BackStackRecord;->mHead:Landroid/app/BackStackRecord$Op;

    .local v3, op:Landroid/app/BackStackRecord$Op;
    :goto_6
    if-eqz v3, :cond_16

    iget-object v6, v3, Landroid/app/BackStackRecord$Op;->removed:Ljava/util/ArrayList;

    if-eqz v6, :cond_13

    iget-object v6, v3, Landroid/app/BackStackRecord$Op;->removed:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v6

    add-int/2addr v2, v6

    :cond_13
    iget-object v3, v3, Landroid/app/BackStackRecord$Op;->next:Landroid/app/BackStackRecord$Op;

    goto :goto_6

    :cond_16
    iget v6, p2, Landroid/app/BackStackRecord;->mNumOp:I

    mul-int/lit8 v6, v6, 0x7

    add-int/2addr v6, v2

    new-array v6, v6, [I

    iput-object v6, p0, Landroid/app/BackStackState;->mOps:[I

    iget-boolean v6, p2, Landroid/app/BackStackRecord;->mAddToBackStack:Z

    if-nez v6, :cond_2b

    new-instance v6, Ljava/lang/IllegalStateException;

    const-string v7, "Not on back stack"

    invoke-direct {v6, v7}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v6

    :cond_2b
    iget-object v3, p2, Landroid/app/BackStackRecord;->mHead:Landroid/app/BackStackRecord$Op;

    const/4 v4, 0x0

    .local v4, pos:I
    move v5, v4

    .end local v4           #pos:I
    .local v5, pos:I
    :goto_2f
    if-eqz v3, :cond_9e

    iget-object v6, p0, Landroid/app/BackStackState;->mOps:[I

    add-int/lit8 v4, v5, 0x1

    .end local v5           #pos:I
    .restart local v4       #pos:I
    iget v7, v3, Landroid/app/BackStackRecord$Op;->cmd:I

    aput v7, v6, v5

    iget-object v7, p0, Landroid/app/BackStackState;->mOps:[I

    add-int/lit8 v5, v4, 0x1

    .end local v4           #pos:I
    .restart local v5       #pos:I
    iget-object v6, v3, Landroid/app/BackStackRecord$Op;->fragment:Landroid/app/Fragment;

    if-eqz v6, :cond_8f

    iget-object v6, v3, Landroid/app/BackStackRecord$Op;->fragment:Landroid/app/Fragment;

    iget v6, v6, Landroid/app/Fragment;->mIndex:I

    :goto_45
    aput v6, v7, v4

    iget-object v6, p0, Landroid/app/BackStackState;->mOps:[I

    add-int/lit8 v4, v5, 0x1

    .end local v5           #pos:I
    .restart local v4       #pos:I
    iget v7, v3, Landroid/app/BackStackRecord$Op;->enterAnim:I

    aput v7, v6, v5

    iget-object v6, p0, Landroid/app/BackStackState;->mOps:[I

    add-int/lit8 v5, v4, 0x1

    .end local v4           #pos:I
    .restart local v5       #pos:I
    iget v7, v3, Landroid/app/BackStackRecord$Op;->exitAnim:I

    aput v7, v6, v4

    iget-object v6, p0, Landroid/app/BackStackState;->mOps:[I

    add-int/lit8 v4, v5, 0x1

    .end local v5           #pos:I
    .restart local v4       #pos:I
    iget v7, v3, Landroid/app/BackStackRecord$Op;->popEnterAnim:I

    aput v7, v6, v5

    iget-object v6, p0, Landroid/app/BackStackState;->mOps:[I

    add-int/lit8 v5, v4, 0x1

    .end local v4           #pos:I
    .restart local v5       #pos:I
    iget v7, v3, Landroid/app/BackStackRecord$Op;->popExitAnim:I

    aput v7, v6, v4

    iget-object v6, v3, Landroid/app/BackStackRecord$Op;->removed:Ljava/util/ArrayList;

    if-eqz v6, :cond_96

    iget-object v6, v3, Landroid/app/BackStackRecord$Op;->removed:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v0

    .local v0, N:I
    iget-object v6, p0, Landroid/app/BackStackState;->mOps:[I

    add-int/lit8 v4, v5, 0x1

    .end local v5           #pos:I
    .restart local v4       #pos:I
    aput v0, v6, v5

    const/4 v1, 0x0

    .local v1, i:I
    move v5, v4

    .end local v4           #pos:I
    .restart local v5       #pos:I
    :goto_79
    if-ge v1, v0, :cond_91

    iget-object v7, p0, Landroid/app/BackStackState;->mOps:[I

    add-int/lit8 v4, v5, 0x1

    .end local v5           #pos:I
    .restart local v4       #pos:I
    iget-object v6, v3, Landroid/app/BackStackRecord$Op;->removed:Ljava/util/ArrayList;

    invoke-virtual {v6, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/app/Fragment;

    iget v6, v6, Landroid/app/Fragment;->mIndex:I

    aput v6, v7, v5

    add-int/lit8 v1, v1, 0x1

    move v5, v4

    .end local v4           #pos:I
    .restart local v5       #pos:I
    goto :goto_79

    .end local v0           #N:I
    .end local v1           #i:I
    :cond_8f
    const/4 v6, -0x1

    goto :goto_45

    .restart local v0       #N:I
    .restart local v1       #i:I
    :cond_91
    move v4, v5

    .end local v0           #N:I
    .end local v1           #i:I
    .end local v5           #pos:I
    .restart local v4       #pos:I
    :goto_92
    iget-object v3, v3, Landroid/app/BackStackRecord$Op;->next:Landroid/app/BackStackRecord$Op;

    move v5, v4

    .end local v4           #pos:I
    .restart local v5       #pos:I
    goto :goto_2f

    :cond_96
    iget-object v6, p0, Landroid/app/BackStackState;->mOps:[I

    add-int/lit8 v4, v5, 0x1

    .end local v5           #pos:I
    .restart local v4       #pos:I
    const/4 v7, 0x0

    aput v7, v6, v5

    goto :goto_92

    .end local v4           #pos:I
    .restart local v5       #pos:I
    :cond_9e
    iget v6, p2, Landroid/app/BackStackRecord;->mTransition:I

    iput v6, p0, Landroid/app/BackStackState;->mTransition:I

    iget v6, p2, Landroid/app/BackStackRecord;->mTransitionStyle:I

    iput v6, p0, Landroid/app/BackStackState;->mTransitionStyle:I

    iget-object v6, p2, Landroid/app/BackStackRecord;->mName:Ljava/lang/String;

    iput-object v6, p0, Landroid/app/BackStackState;->mName:Ljava/lang/String;

    iget v6, p2, Landroid/app/BackStackRecord;->mIndex:I

    iput v6, p0, Landroid/app/BackStackState;->mIndex:I

    iget v6, p2, Landroid/app/BackStackRecord;->mBreadCrumbTitleRes:I

    iput v6, p0, Landroid/app/BackStackState;->mBreadCrumbTitleRes:I

    iget-object v6, p2, Landroid/app/BackStackRecord;->mBreadCrumbTitleText:Ljava/lang/CharSequence;

    iput-object v6, p0, Landroid/app/BackStackState;->mBreadCrumbTitleText:Ljava/lang/CharSequence;

    iget v6, p2, Landroid/app/BackStackRecord;->mBreadCrumbShortTitleRes:I

    iput v6, p0, Landroid/app/BackStackState;->mBreadCrumbShortTitleRes:I

    iget-object v6, p2, Landroid/app/BackStackRecord;->mBreadCrumbShortTitleText:Ljava/lang/CharSequence;

    iput-object v6, p0, Landroid/app/BackStackState;->mBreadCrumbShortTitleText:Ljava/lang/CharSequence;

    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .registers 3
    .parameter "in"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    invoke-virtual {p1}, Landroid/os/Parcel;->createIntArray()[I

    move-result-object v0

    iput-object v0, p0, Landroid/app/BackStackState;->mOps:[I

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/app/BackStackState;->mTransition:I

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/app/BackStackState;->mTransitionStyle:I

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroid/app/BackStackState;->mName:Ljava/lang/String;

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/app/BackStackState;->mIndex:I

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/app/BackStackState;->mBreadCrumbTitleRes:I

    sget-object v0, Landroid/text/TextUtils;->CHAR_SEQUENCE_CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p1}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    iput-object v0, p0, Landroid/app/BackStackState;->mBreadCrumbTitleText:Ljava/lang/CharSequence;

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Landroid/app/BackStackState;->mBreadCrumbShortTitleRes:I

    sget-object v0, Landroid/text/TextUtils;->CHAR_SEQUENCE_CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p1}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    iput-object v0, p0, Landroid/app/BackStackState;->mBreadCrumbShortTitleText:Ljava/lang/CharSequence;

    return-void
.end method


# virtual methods
.method public describeContents()I
    .registers 2

    .prologue
    const/4 v0, 0x0

    return v0
.end method

.method public instantiate(Landroid/app/FragmentManagerImpl;)Landroid/app/BackStackRecord;
    .registers 15
    .parameter "fm"

    .prologue
    const/4 v12, 0x1

    new-instance v1, Landroid/app/BackStackRecord;

    invoke-direct {v1, p1}, Landroid/app/BackStackRecord;-><init>(Landroid/app/FragmentManagerImpl;)V

    .local v1, bse:Landroid/app/BackStackRecord;
    const/4 v6, 0x0

    .local v6, pos:I
    :goto_7
    iget-object v9, p0, Landroid/app/BackStackState;->mOps:[I

    array-length v9, v9

    if-ge v6, v9, :cond_d2

    new-instance v5, Landroid/app/BackStackRecord$Op;

    invoke-direct {v5}, Landroid/app/BackStackRecord$Op;-><init>()V

    .local v5, op:Landroid/app/BackStackRecord$Op;
    iget-object v9, p0, Landroid/app/BackStackState;->mOps:[I

    add-int/lit8 v7, v6, 0x1

    .end local v6           #pos:I
    .local v7, pos:I
    aget v9, v9, v6

    iput v9, v5, Landroid/app/BackStackRecord$Op;->cmd:I

    sget-boolean v9, Landroid/app/FragmentManagerImpl;->DEBUG:Z

    if-eqz v9, :cond_43

    const-string v9, "FragmentManager"

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "BSE "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, " set base fragment #"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    iget-object v11, p0, Landroid/app/BackStackState;->mOps:[I

    aget v11, v11, v7

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    :cond_43
    iget-object v9, p0, Landroid/app/BackStackState;->mOps:[I

    add-int/lit8 v6, v7, 0x1

    .end local v7           #pos:I
    .restart local v6       #pos:I
    aget v3, v9, v7

    .local v3, findex:I
    if-ltz v3, :cond_c8

    iget-object v9, p1, Landroid/app/FragmentManagerImpl;->mActive:Ljava/util/ArrayList;

    invoke-virtual {v9, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/app/Fragment;

    .local v2, f:Landroid/app/Fragment;
    iput-object v2, v5, Landroid/app/BackStackRecord$Op;->fragment:Landroid/app/Fragment;

    .end local v2           #f:Landroid/app/Fragment;
    :goto_55
    iget-object v9, p0, Landroid/app/BackStackState;->mOps:[I

    add-int/lit8 v7, v6, 0x1

    .end local v6           #pos:I
    .restart local v7       #pos:I
    aget v9, v9, v6

    iput v9, v5, Landroid/app/BackStackRecord$Op;->enterAnim:I

    iget-object v9, p0, Landroid/app/BackStackState;->mOps:[I

    add-int/lit8 v6, v7, 0x1

    .end local v7           #pos:I
    .restart local v6       #pos:I
    aget v9, v9, v7

    iput v9, v5, Landroid/app/BackStackRecord$Op;->exitAnim:I

    iget-object v9, p0, Landroid/app/BackStackState;->mOps:[I

    add-int/lit8 v7, v6, 0x1

    .end local v6           #pos:I
    .restart local v7       #pos:I
    aget v9, v9, v6

    iput v9, v5, Landroid/app/BackStackRecord$Op;->popEnterAnim:I

    iget-object v9, p0, Landroid/app/BackStackState;->mOps:[I

    add-int/lit8 v6, v7, 0x1

    .end local v7           #pos:I
    .restart local v6       #pos:I
    aget v9, v9, v7

    iput v9, v5, Landroid/app/BackStackRecord$Op;->popExitAnim:I

    iget-object v9, p0, Landroid/app/BackStackState;->mOps:[I

    add-int/lit8 v7, v6, 0x1

    .end local v6           #pos:I
    .restart local v7       #pos:I
    aget v0, v9, v6

    .local v0, N:I
    if-lez v0, :cond_cc

    new-instance v9, Ljava/util/ArrayList;

    invoke-direct {v9, v0}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v9, v5, Landroid/app/BackStackRecord$Op;->removed:Ljava/util/ArrayList;

    const/4 v4, 0x0

    .local v4, i:I
    :goto_85
    if-ge v4, v0, :cond_cc

    sget-boolean v9, Landroid/app/FragmentManagerImpl;->DEBUG:Z

    if-eqz v9, :cond_b1

    const-string v9, "FragmentManager"

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "BSE "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, " set remove fragment #"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    iget-object v11, p0, Landroid/app/BackStackState;->mOps:[I

    aget v11, v11, v7

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    :cond_b1
    iget-object v9, p1, Landroid/app/FragmentManagerImpl;->mActive:Ljava/util/ArrayList;

    iget-object v10, p0, Landroid/app/BackStackState;->mOps:[I

    add-int/lit8 v6, v7, 0x1

    .end local v7           #pos:I
    .restart local v6       #pos:I
    aget v10, v10, v7

    invoke-virtual {v9, v10}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/app/Fragment;

    .local v8, r:Landroid/app/Fragment;
    iget-object v9, v5, Landroid/app/BackStackRecord$Op;->removed:Ljava/util/ArrayList;

    invoke-virtual {v9, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    add-int/lit8 v4, v4, 0x1

    move v7, v6

    .end local v6           #pos:I
    .restart local v7       #pos:I
    goto :goto_85

    .end local v0           #N:I
    .end local v4           #i:I
    .end local v7           #pos:I
    .end local v8           #r:Landroid/app/Fragment;
    .restart local v6       #pos:I
    :cond_c8
    const/4 v9, 0x0

    iput-object v9, v5, Landroid/app/BackStackRecord$Op;->fragment:Landroid/app/Fragment;

    goto :goto_55

    .end local v6           #pos:I
    .restart local v0       #N:I
    .restart local v7       #pos:I
    :cond_cc
    move v6, v7

    .end local v7           #pos:I
    .restart local v6       #pos:I
    invoke-virtual {v1, v5}, Landroid/app/BackStackRecord;->addOp(Landroid/app/BackStackRecord$Op;)V

    goto/16 :goto_7

    .end local v0           #N:I
    .end local v3           #findex:I
    .end local v5           #op:Landroid/app/BackStackRecord$Op;
    :cond_d2
    iget v9, p0, Landroid/app/BackStackState;->mTransition:I

    iput v9, v1, Landroid/app/BackStackRecord;->mTransition:I

    iget v9, p0, Landroid/app/BackStackState;->mTransitionStyle:I

    iput v9, v1, Landroid/app/BackStackRecord;->mTransitionStyle:I

    iget-object v9, p0, Landroid/app/BackStackState;->mName:Ljava/lang/String;

    iput-object v9, v1, Landroid/app/BackStackRecord;->mName:Ljava/lang/String;

    iget v9, p0, Landroid/app/BackStackState;->mIndex:I

    iput v9, v1, Landroid/app/BackStackRecord;->mIndex:I

    iput-boolean v12, v1, Landroid/app/BackStackRecord;->mAddToBackStack:Z

    iget v9, p0, Landroid/app/BackStackState;->mBreadCrumbTitleRes:I

    iput v9, v1, Landroid/app/BackStackRecord;->mBreadCrumbTitleRes:I

    iget-object v9, p0, Landroid/app/BackStackState;->mBreadCrumbTitleText:Ljava/lang/CharSequence;

    iput-object v9, v1, Landroid/app/BackStackRecord;->mBreadCrumbTitleText:Ljava/lang/CharSequence;

    iget v9, p0, Landroid/app/BackStackState;->mBreadCrumbShortTitleRes:I

    iput v9, v1, Landroid/app/BackStackRecord;->mBreadCrumbShortTitleRes:I

    iget-object v9, p0, Landroid/app/BackStackState;->mBreadCrumbShortTitleText:Ljava/lang/CharSequence;

    iput-object v9, v1, Landroid/app/BackStackRecord;->mBreadCrumbShortTitleText:Ljava/lang/CharSequence;

    invoke-virtual {v1, v12}, Landroid/app/BackStackRecord;->bumpBackStackNesting(I)V

    return-object v1
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 5
    .parameter "dest"
    .parameter "flags"

    .prologue
    const/4 v1, 0x0

    iget-object v0, p0, Landroid/app/BackStackState;->mOps:[I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeIntArray([I)V

    iget v0, p0, Landroid/app/BackStackState;->mTransition:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p0, Landroid/app/BackStackState;->mTransitionStyle:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget-object v0, p0, Landroid/app/BackStackState;->mName:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget v0, p0, Landroid/app/BackStackState;->mIndex:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p0, Landroid/app/BackStackState;->mBreadCrumbTitleRes:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget-object v0, p0, Landroid/app/BackStackState;->mBreadCrumbTitleText:Ljava/lang/CharSequence;

    invoke-static {v0, p1, v1}, Landroid/text/TextUtils;->writeToParcel(Ljava/lang/CharSequence;Landroid/os/Parcel;I)V

    iget v0, p0, Landroid/app/BackStackState;->mBreadCrumbShortTitleRes:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget-object v0, p0, Landroid/app/BackStackState;->mBreadCrumbShortTitleText:Ljava/lang/CharSequence;

    invoke-static {v0, p1, v1}, Landroid/text/TextUtils;->writeToParcel(Ljava/lang/CharSequence;Landroid/os/Parcel;I)V

    return-void
.end method
