.class public Lcom/android/internal/statusbar/StatusBarIconList;
.super Ljava/lang/Object;
.source "StatusBarIconList.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/android/internal/statusbar/StatusBarIconList;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private mIcons:[Lcom/android/internal/statusbar/StatusBarIcon;

.field private mSlots:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    new-instance v0, Lcom/android/internal/statusbar/StatusBarIconList$1;

    invoke-direct {v0}, Lcom/android/internal/statusbar/StatusBarIconList$1;-><init>()V

    sput-object v0, Lcom/android/internal/statusbar/StatusBarIconList;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .registers 2
    .parameter "in"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    invoke-virtual {p0, p1}, Lcom/android/internal/statusbar/StatusBarIconList;->readFromParcel(Landroid/os/Parcel;)V

    return-void
.end method


# virtual methods
.method public copyFrom(Lcom/android/internal/statusbar/StatusBarIconList;)V
    .registers 7
    .parameter "that"

    .prologue
    const/4 v3, 0x0

    iget-object v2, p1, Lcom/android/internal/statusbar/StatusBarIconList;->mSlots:[Ljava/lang/String;

    if-nez v2, :cond_a

    iput-object v3, p0, Lcom/android/internal/statusbar/StatusBarIconList;->mSlots:[Ljava/lang/String;

    iput-object v3, p0, Lcom/android/internal/statusbar/StatusBarIconList;->mIcons:[Lcom/android/internal/statusbar/StatusBarIcon;

    :cond_9
    return-void

    :cond_a
    iget-object v2, p1, Lcom/android/internal/statusbar/StatusBarIconList;->mSlots:[Ljava/lang/String;

    array-length v0, v2

    .local v0, N:I
    new-array v2, v0, [Ljava/lang/String;

    iput-object v2, p0, Lcom/android/internal/statusbar/StatusBarIconList;->mSlots:[Ljava/lang/String;

    new-array v2, v0, [Lcom/android/internal/statusbar/StatusBarIcon;

    iput-object v2, p0, Lcom/android/internal/statusbar/StatusBarIconList;->mIcons:[Lcom/android/internal/statusbar/StatusBarIcon;

    const/4 v1, 0x0

    .local v1, i:I
    :goto_16
    if-ge v1, v0, :cond_9

    iget-object v2, p0, Lcom/android/internal/statusbar/StatusBarIconList;->mSlots:[Ljava/lang/String;

    iget-object v4, p1, Lcom/android/internal/statusbar/StatusBarIconList;->mSlots:[Ljava/lang/String;

    aget-object v4, v4, v1

    aput-object v4, v2, v1

    iget-object v4, p0, Lcom/android/internal/statusbar/StatusBarIconList;->mIcons:[Lcom/android/internal/statusbar/StatusBarIcon;

    iget-object v2, p1, Lcom/android/internal/statusbar/StatusBarIconList;->mIcons:[Lcom/android/internal/statusbar/StatusBarIcon;

    aget-object v2, v2, v1

    if-eqz v2, :cond_35

    iget-object v2, p1, Lcom/android/internal/statusbar/StatusBarIconList;->mIcons:[Lcom/android/internal/statusbar/StatusBarIcon;

    aget-object v2, v2, v1

    invoke-virtual {v2}, Lcom/android/internal/statusbar/StatusBarIcon;->clone()Lcom/android/internal/statusbar/StatusBarIcon;

    move-result-object v2

    :goto_30
    aput-object v2, v4, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_16

    :cond_35
    move-object v2, v3

    goto :goto_30
.end method

.method public defineSlots([Ljava/lang/String;)V
    .registers 6
    .parameter "slots"

    .prologue
    array-length v0, p1

    .local v0, N:I
    new-array v2, v0, [Ljava/lang/String;

    iput-object v2, p0, Lcom/android/internal/statusbar/StatusBarIconList;->mSlots:[Ljava/lang/String;

    .local v2, s:[Ljava/lang/String;
    const/4 v1, 0x0

    .local v1, i:I
    :goto_6
    if-ge v1, v0, :cond_f

    aget-object v3, p1, v1

    aput-object v3, v2, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_6

    :cond_f
    new-array v3, v0, [Lcom/android/internal/statusbar/StatusBarIcon;

    iput-object v3, p0, Lcom/android/internal/statusbar/StatusBarIconList;->mIcons:[Lcom/android/internal/statusbar/StatusBarIcon;

    return-void
.end method

.method public describeContents()I
    .registers 2

    .prologue
    const/4 v0, 0x0

    return v0
.end method

.method public dump(Ljava/io/PrintWriter;)V
    .registers 8
    .parameter "pw"

    .prologue
    iget-object v2, p0, Lcom/android/internal/statusbar/StatusBarIconList;->mSlots:[Ljava/lang/String;

    array-length v0, v2

    .local v0, N:I
    const-string v2, "Icon list:"

    invoke-virtual {p1, v2}, Ljava/io/PrintWriter;->println(Ljava/lang/String;)V

    const/4 v1, 0x0

    .local v1, i:I
    :goto_9
    if-ge v1, v0, :cond_2b

    const-string v2, "  %2d: (%s) %s\n"

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    iget-object v5, p0, Lcom/android/internal/statusbar/StatusBarIconList;->mSlots:[Ljava/lang/String;

    aget-object v5, v5, v1

    aput-object v5, v3, v4

    const/4 v4, 0x2

    iget-object v5, p0, Lcom/android/internal/statusbar/StatusBarIconList;->mIcons:[Lcom/android/internal/statusbar/StatusBarIcon;

    aget-object v5, v5, v1

    aput-object v5, v3, v4

    invoke-virtual {p1, v2, v3}, Ljava/io/PrintWriter;->printf(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintWriter;

    add-int/lit8 v1, v1, 0x1

    goto :goto_9

    :cond_2b
    return-void
.end method

.method public getIcon(I)Lcom/android/internal/statusbar/StatusBarIcon;
    .registers 3
    .parameter "index"

    .prologue
    iget-object v0, p0, Lcom/android/internal/statusbar/StatusBarIconList;->mIcons:[Lcom/android/internal/statusbar/StatusBarIcon;

    aget-object v0, v0, p1

    return-object v0
.end method

.method public getSlot(I)Ljava/lang/String;
    .registers 3
    .parameter "index"

    .prologue
    iget-object v0, p0, Lcom/android/internal/statusbar/StatusBarIconList;->mSlots:[Ljava/lang/String;

    aget-object v0, v0, p1

    return-object v0
.end method

.method public getSlotIndex(Ljava/lang/String;)I
    .registers 5
    .parameter "slot"

    .prologue
    iget-object v2, p0, Lcom/android/internal/statusbar/StatusBarIconList;->mSlots:[Ljava/lang/String;

    array-length v0, v2

    .local v0, N:I
    const/4 v1, 0x0

    .local v1, i:I
    :goto_4
    if-ge v1, v0, :cond_14

    iget-object v2, p0, Lcom/android/internal/statusbar/StatusBarIconList;->mSlots:[Ljava/lang/String;

    aget-object v2, v2, v1

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_11

    .end local v1           #i:I
    :goto_10
    return v1

    .restart local v1       #i:I
    :cond_11
    add-int/lit8 v1, v1, 0x1

    goto :goto_4

    :cond_14
    const/4 v1, -0x1

    goto :goto_10
.end method

.method public getViewIndex(I)I
    .registers 5
    .parameter "index"

    .prologue
    const/4 v0, 0x0

    .local v0, count:I
    const/4 v1, 0x0

    .local v1, i:I
    :goto_2
    if-ge v1, p1, :cond_f

    iget-object v2, p0, Lcom/android/internal/statusbar/StatusBarIconList;->mIcons:[Lcom/android/internal/statusbar/StatusBarIcon;

    aget-object v2, v2, v1

    if-eqz v2, :cond_c

    add-int/lit8 v0, v0, 0x1

    :cond_c
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    :cond_f
    return v0
.end method

.method public readFromParcel(Landroid/os/Parcel;)V
    .registers 6
    .parameter "in"

    .prologue
    invoke-virtual {p1}, Landroid/os/Parcel;->readStringArray()[Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/android/internal/statusbar/StatusBarIconList;->mSlots:[Ljava/lang/String;

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    .local v0, N:I
    if-gez v0, :cond_10

    const/4 v2, 0x0

    iput-object v2, p0, Lcom/android/internal/statusbar/StatusBarIconList;->mIcons:[Lcom/android/internal/statusbar/StatusBarIcon;

    :cond_f
    return-void

    :cond_10
    new-array v2, v0, [Lcom/android/internal/statusbar/StatusBarIcon;

    iput-object v2, p0, Lcom/android/internal/statusbar/StatusBarIconList;->mIcons:[Lcom/android/internal/statusbar/StatusBarIcon;

    const/4 v1, 0x0

    .local v1, i:I
    :goto_15
    if-ge v1, v0, :cond_f

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v2

    if-eqz v2, :cond_26

    iget-object v2, p0, Lcom/android/internal/statusbar/StatusBarIconList;->mIcons:[Lcom/android/internal/statusbar/StatusBarIcon;

    new-instance v3, Lcom/android/internal/statusbar/StatusBarIcon;

    invoke-direct {v3, p1}, Lcom/android/internal/statusbar/StatusBarIcon;-><init>(Landroid/os/Parcel;)V

    aput-object v3, v2, v1

    :cond_26
    add-int/lit8 v1, v1, 0x1

    goto :goto_15
.end method

.method public removeIcon(I)V
    .registers 4
    .parameter "index"

    .prologue
    iget-object v0, p0, Lcom/android/internal/statusbar/StatusBarIconList;->mIcons:[Lcom/android/internal/statusbar/StatusBarIcon;

    const/4 v1, 0x0

    aput-object v1, v0, p1

    return-void
.end method

.method public setIcon(ILcom/android/internal/statusbar/StatusBarIcon;)V
    .registers 5
    .parameter "index"
    .parameter "icon"

    .prologue
    iget-object v0, p0, Lcom/android/internal/statusbar/StatusBarIconList;->mIcons:[Lcom/android/internal/statusbar/StatusBarIcon;

    invoke-virtual {p2}, Lcom/android/internal/statusbar/StatusBarIcon;->clone()Lcom/android/internal/statusbar/StatusBarIcon;

    move-result-object v1

    aput-object v1, v0, p1

    return-void
.end method

.method public size()I
    .registers 2

    .prologue
    iget-object v0, p0, Lcom/android/internal/statusbar/StatusBarIconList;->mSlots:[Ljava/lang/String;

    array-length v0, v0

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 7
    .parameter "out"
    .parameter "flags"

    .prologue
    iget-object v3, p0, Lcom/android/internal/statusbar/StatusBarIconList;->mSlots:[Ljava/lang/String;

    invoke-virtual {p1, v3}, Landroid/os/Parcel;->writeStringArray([Ljava/lang/String;)V

    iget-object v3, p0, Lcom/android/internal/statusbar/StatusBarIconList;->mIcons:[Lcom/android/internal/statusbar/StatusBarIcon;

    if-nez v3, :cond_e

    const/4 v3, -0x1

    invoke-virtual {p1, v3}, Landroid/os/Parcel;->writeInt(I)V

    :cond_d
    return-void

    :cond_e
    iget-object v3, p0, Lcom/android/internal/statusbar/StatusBarIconList;->mIcons:[Lcom/android/internal/statusbar/StatusBarIcon;

    array-length v0, v3

    .local v0, N:I
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    const/4 v1, 0x0

    .local v1, i:I
    :goto_15
    if-ge v1, v0, :cond_d

    iget-object v3, p0, Lcom/android/internal/statusbar/StatusBarIconList;->mIcons:[Lcom/android/internal/statusbar/StatusBarIcon;

    aget-object v2, v3, v1

    .local v2, ic:Lcom/android/internal/statusbar/StatusBarIcon;
    if-nez v2, :cond_24

    const/4 v3, 0x0

    invoke-virtual {p1, v3}, Landroid/os/Parcel;->writeInt(I)V

    :goto_21
    add-int/lit8 v1, v1, 0x1

    goto :goto_15

    :cond_24
    const/4 v3, 0x1

    invoke-virtual {p1, v3}, Landroid/os/Parcel;->writeInt(I)V

    invoke-virtual {v2, p1, p2}, Lcom/android/internal/statusbar/StatusBarIcon;->writeToParcel(Landroid/os/Parcel;I)V

    goto :goto_21
.end method
