.class public final Landroid/view/accessibility/AccessibilityEvent;
.super Landroid/view/accessibility/AccessibilityRecord;
.source "AccessibilityEvent.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator; = null
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Landroid/view/accessibility/AccessibilityEvent;",
            ">;"
        }
    .end annotation
.end field

.field private static final DEBUG:Z = false

.field public static final INVALID_POSITION:I = -0x1

.field private static final MAX_POOL_SIZE:I = 0xa

.field public static final MAX_TEXT_LENGTH:I = 0x1f4
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final TYPES_ALL_MASK:I = -0x1

.field public static final TYPE_ANNOUNCEMENT:I = 0x4000

.field public static final TYPE_NOTIFICATION_STATE_CHANGED:I = 0x40

.field public static final TYPE_TOUCH_EXPLORATION_GESTURE_END:I = 0x400

.field public static final TYPE_TOUCH_EXPLORATION_GESTURE_START:I = 0x200

.field public static final TYPE_VIEW_ACCESSIBILITY_FOCUSED:I = 0x8000

.field public static final TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED:I = 0x10000

.field public static final TYPE_VIEW_CLICKED:I = 0x1

.field public static final TYPE_VIEW_FOCUSED:I = 0x8

.field public static final TYPE_VIEW_HOVER_ENTER:I = 0x80

.field public static final TYPE_VIEW_HOVER_EXIT:I = 0x100

.field public static final TYPE_VIEW_LONG_CLICKED:I = 0x2

.field public static final TYPE_VIEW_SCROLLED:I = 0x1000

.field public static final TYPE_VIEW_SELECTED:I = 0x4

.field public static final TYPE_VIEW_TEXT_CHANGED:I = 0x10

.field public static final TYPE_VIEW_TEXT_SELECTION_CHANGED:I = 0x2000

.field public static final TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY:I = 0x20000

.field public static final TYPE_WINDOW_CONTENT_CHANGED:I = 0x800

.field public static final TYPE_WINDOW_STATE_CHANGED:I = 0x20

.field private static sPool:Landroid/view/accessibility/AccessibilityEvent;

.field private static final sPoolLock:Ljava/lang/Object;

.field private static sPoolSize:I


# instance fields
.field mAction:I

.field private mEventTime:J

.field private mEventType:I

.field private mIsInPool:Z

.field mMovementGranularity:I

.field private mNext:Landroid/view/accessibility/AccessibilityEvent;

.field private mPackageName:Ljava/lang/CharSequence;

.field private final mRecords:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/view/accessibility/AccessibilityRecord;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Landroid/view/accessibility/AccessibilityEvent;->sPoolLock:Ljava/lang/Object;

    new-instance v0, Landroid/view/accessibility/AccessibilityEvent$1;

    invoke-direct {v0}, Landroid/view/accessibility/AccessibilityEvent$1;-><init>()V

    sput-object v0, Landroid/view/accessibility/AccessibilityEvent;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method private constructor <init>()V
    .registers 2

    .prologue
    invoke-direct {p0}, Landroid/view/accessibility/AccessibilityRecord;-><init>()V

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/view/accessibility/AccessibilityEvent;->mRecords:Ljava/util/ArrayList;

    return-void
.end method

.method public static eventTypeToString(I)Ljava/lang/String;
    .registers 2
    .parameter "eventType"

    .prologue
    sparse-switch p0, :sswitch_data_3c

    const/4 v0, 0x0

    :goto_4
    return-object v0

    :sswitch_5
    const-string v0, "TYPE_VIEW_CLICKED"

    goto :goto_4

    :sswitch_8
    const-string v0, "TYPE_VIEW_LONG_CLICKED"

    goto :goto_4

    :sswitch_b
    const-string v0, "TYPE_VIEW_SELECTED"

    goto :goto_4

    :sswitch_e
    const-string v0, "TYPE_VIEW_FOCUSED"

    goto :goto_4

    :sswitch_11
    const-string v0, "TYPE_VIEW_TEXT_CHANGED"

    goto :goto_4

    :sswitch_14
    const-string v0, "TYPE_WINDOW_STATE_CHANGED"

    goto :goto_4

    :sswitch_17
    const-string v0, "TYPE_VIEW_HOVER_ENTER"

    goto :goto_4

    :sswitch_1a
    const-string v0, "TYPE_VIEW_HOVER_EXIT"

    goto :goto_4

    :sswitch_1d
    const-string v0, "TYPE_NOTIFICATION_STATE_CHANGED"

    goto :goto_4

    :sswitch_20
    const-string v0, "TYPE_TOUCH_EXPLORATION_GESTURE_START"

    goto :goto_4

    :sswitch_23
    const-string v0, "TYPE_TOUCH_EXPLORATION_GESTURE_END"

    goto :goto_4

    :sswitch_26
    const-string v0, "TYPE_WINDOW_CONTENT_CHANGED"

    goto :goto_4

    :sswitch_29
    const-string v0, "TYPE_VIEW_TEXT_SELECTION_CHANGED"

    goto :goto_4

    :sswitch_2c
    const-string v0, "TYPE_VIEW_SCROLLED"

    goto :goto_4

    :sswitch_2f
    const-string v0, "TYPE_ANNOUNCEMENT"

    goto :goto_4

    :sswitch_32
    const-string v0, "TYPE_VIEW_ACCESSIBILITY_FOCUSED"

    goto :goto_4

    :sswitch_35
    const-string v0, "TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED"

    goto :goto_4

    :sswitch_38
    const-string v0, "TYPE_CURRENT_AT_GRANULARITY_MOVEMENT_CHANGED"

    goto :goto_4

    nop

    :sswitch_data_3c
    .sparse-switch
        0x1 -> :sswitch_5
        0x2 -> :sswitch_8
        0x4 -> :sswitch_b
        0x8 -> :sswitch_e
        0x10 -> :sswitch_11
        0x20 -> :sswitch_14
        0x40 -> :sswitch_1d
        0x80 -> :sswitch_17
        0x100 -> :sswitch_1a
        0x200 -> :sswitch_20
        0x400 -> :sswitch_23
        0x800 -> :sswitch_26
        0x1000 -> :sswitch_2c
        0x2000 -> :sswitch_29
        0x4000 -> :sswitch_2f
        0x8000 -> :sswitch_32
        0x10000 -> :sswitch_35
        0x20000 -> :sswitch_38
    .end sparse-switch
.end method

.method public static obtain()Landroid/view/accessibility/AccessibilityEvent;
    .registers 3

    .prologue
    sget-object v2, Landroid/view/accessibility/AccessibilityEvent;->sPoolLock:Ljava/lang/Object;

    monitor-enter v2

    :try_start_3
    sget-object v1, Landroid/view/accessibility/AccessibilityEvent;->sPool:Landroid/view/accessibility/AccessibilityEvent;

    if-eqz v1, :cond_1d

    sget-object v0, Landroid/view/accessibility/AccessibilityEvent;->sPool:Landroid/view/accessibility/AccessibilityEvent;

    .local v0, event:Landroid/view/accessibility/AccessibilityEvent;
    sget-object v1, Landroid/view/accessibility/AccessibilityEvent;->sPool:Landroid/view/accessibility/AccessibilityEvent;

    iget-object v1, v1, Landroid/view/accessibility/AccessibilityEvent;->mNext:Landroid/view/accessibility/AccessibilityEvent;

    sput-object v1, Landroid/view/accessibility/AccessibilityEvent;->sPool:Landroid/view/accessibility/AccessibilityEvent;

    sget v1, Landroid/view/accessibility/AccessibilityEvent;->sPoolSize:I

    add-int/lit8 v1, v1, -0x1

    sput v1, Landroid/view/accessibility/AccessibilityEvent;->sPoolSize:I

    const/4 v1, 0x0

    iput-object v1, v0, Landroid/view/accessibility/AccessibilityEvent;->mNext:Landroid/view/accessibility/AccessibilityEvent;

    const/4 v1, 0x0

    iput-boolean v1, v0, Landroid/view/accessibility/AccessibilityEvent;->mIsInPool:Z

    monitor-exit v2

    .end local v0           #event:Landroid/view/accessibility/AccessibilityEvent;
    :goto_1c
    return-object v0

    :cond_1d
    new-instance v0, Landroid/view/accessibility/AccessibilityEvent;

    invoke-direct {v0}, Landroid/view/accessibility/AccessibilityEvent;-><init>()V

    monitor-exit v2

    goto :goto_1c

    :catchall_24
    move-exception v1

    monitor-exit v2
    :try_end_26
    .catchall {:try_start_3 .. :try_end_26} :catchall_24

    throw v1
.end method

.method public static obtain(I)Landroid/view/accessibility/AccessibilityEvent;
    .registers 2
    .parameter "eventType"

    .prologue
    invoke-static {}, Landroid/view/accessibility/AccessibilityEvent;->obtain()Landroid/view/accessibility/AccessibilityEvent;

    move-result-object v0

    .local v0, event:Landroid/view/accessibility/AccessibilityEvent;
    invoke-virtual {v0, p0}, Landroid/view/accessibility/AccessibilityEvent;->setEventType(I)V

    return-object v0
.end method

.method public static obtain(Landroid/view/accessibility/AccessibilityEvent;)Landroid/view/accessibility/AccessibilityEvent;
    .registers 7
    .parameter "event"

    .prologue
    invoke-static {}, Landroid/view/accessibility/AccessibilityEvent;->obtain()Landroid/view/accessibility/AccessibilityEvent;

    move-result-object v0

    .local v0, eventClone:Landroid/view/accessibility/AccessibilityEvent;
    invoke-virtual {v0, p0}, Landroid/view/accessibility/AccessibilityEvent;->init(Landroid/view/accessibility/AccessibilityEvent;)V

    iget-object v5, p0, Landroid/view/accessibility/AccessibilityEvent;->mRecords:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v4

    .local v4, recordCount:I
    const/4 v1, 0x0

    .local v1, i:I
    :goto_e
    if-ge v1, v4, :cond_24

    iget-object v5, p0, Landroid/view/accessibility/AccessibilityEvent;->mRecords:Ljava/util/ArrayList;

    invoke-virtual {v5, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/view/accessibility/AccessibilityRecord;

    .local v2, record:Landroid/view/accessibility/AccessibilityRecord;
    invoke-static {v2}, Landroid/view/accessibility/AccessibilityRecord;->obtain(Landroid/view/accessibility/AccessibilityRecord;)Landroid/view/accessibility/AccessibilityRecord;

    move-result-object v3

    .local v3, recordClone:Landroid/view/accessibility/AccessibilityRecord;
    iget-object v5, v0, Landroid/view/accessibility/AccessibilityEvent;->mRecords:Ljava/util/ArrayList;

    invoke-virtual {v5, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    add-int/lit8 v1, v1, 0x1

    goto :goto_e

    .end local v2           #record:Landroid/view/accessibility/AccessibilityRecord;
    .end local v3           #recordClone:Landroid/view/accessibility/AccessibilityRecord;
    :cond_24
    return-object v0
.end method

.method private readAccessibilityRecordFromParcel(Landroid/view/accessibility/AccessibilityRecord;Landroid/os/Parcel;)V
    .registers 7
    .parameter "record"
    .parameter "parcel"

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p1, Landroid/view/accessibility/AccessibilityRecord;->mBooleanProperties:I

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p1, Landroid/view/accessibility/AccessibilityRecord;->mCurrentItemIndex:I

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p1, Landroid/view/accessibility/AccessibilityRecord;->mItemCount:I

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p1, Landroid/view/accessibility/AccessibilityRecord;->mFromIndex:I

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p1, Landroid/view/accessibility/AccessibilityRecord;->mToIndex:I

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p1, Landroid/view/accessibility/AccessibilityRecord;->mScrollX:I

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p1, Landroid/view/accessibility/AccessibilityRecord;->mScrollY:I

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p1, Landroid/view/accessibility/AccessibilityRecord;->mMaxScrollX:I

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p1, Landroid/view/accessibility/AccessibilityRecord;->mMaxScrollY:I

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p1, Landroid/view/accessibility/AccessibilityRecord;->mAddedCount:I

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p1, Landroid/view/accessibility/AccessibilityRecord;->mRemovedCount:I

    sget-object v0, Landroid/text/TextUtils;->CHAR_SEQUENCE_CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    iput-object v0, p1, Landroid/view/accessibility/AccessibilityRecord;->mClassName:Ljava/lang/CharSequence;

    sget-object v0, Landroid/text/TextUtils;->CHAR_SEQUENCE_CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    iput-object v0, p1, Landroid/view/accessibility/AccessibilityRecord;->mContentDescription:Ljava/lang/CharSequence;

    sget-object v0, Landroid/text/TextUtils;->CHAR_SEQUENCE_CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v0, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    iput-object v0, p1, Landroid/view/accessibility/AccessibilityRecord;->mBeforeText:Ljava/lang/CharSequence;

    invoke-virtual {p2, v2}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v0

    iput-object v0, p1, Landroid/view/accessibility/AccessibilityRecord;->mParcelableData:Landroid/os/Parcelable;

    iget-object v0, p1, Landroid/view/accessibility/AccessibilityRecord;->mText:Ljava/util/List;

    invoke-virtual {p2, v0, v2}, Landroid/os/Parcel;->readList(Ljava/util/List;Ljava/lang/ClassLoader;)V

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p1, Landroid/view/accessibility/AccessibilityRecord;->mSourceWindowId:I

    invoke-virtual {p2}, Landroid/os/Parcel;->readLong()J

    move-result-wide v2

    iput-wide v2, p1, Landroid/view/accessibility/AccessibilityRecord;->mSourceNodeId:J

    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-ne v0, v1, :cond_83

    move v0, v1

    :goto_80
    iput-boolean v0, p1, Landroid/view/accessibility/AccessibilityRecord;->mSealed:Z

    return-void

    :cond_83
    const/4 v0, 0x0

    goto :goto_80
.end method

.method private writeAccessibilityRecordToParcel(Landroid/view/accessibility/AccessibilityRecord;Landroid/os/Parcel;I)V
    .registers 6
    .parameter "record"
    .parameter "parcel"
    .parameter "flags"

    .prologue
    iget v0, p1, Landroid/view/accessibility/AccessibilityRecord;->mBooleanProperties:I

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p1, Landroid/view/accessibility/AccessibilityRecord;->mCurrentItemIndex:I

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p1, Landroid/view/accessibility/AccessibilityRecord;->mItemCount:I

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p1, Landroid/view/accessibility/AccessibilityRecord;->mFromIndex:I

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p1, Landroid/view/accessibility/AccessibilityRecord;->mToIndex:I

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p1, Landroid/view/accessibility/AccessibilityRecord;->mScrollX:I

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p1, Landroid/view/accessibility/AccessibilityRecord;->mScrollY:I

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p1, Landroid/view/accessibility/AccessibilityRecord;->mMaxScrollX:I

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p1, Landroid/view/accessibility/AccessibilityRecord;->mMaxScrollY:I

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p1, Landroid/view/accessibility/AccessibilityRecord;->mAddedCount:I

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p1, Landroid/view/accessibility/AccessibilityRecord;->mRemovedCount:I

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget-object v0, p1, Landroid/view/accessibility/AccessibilityRecord;->mClassName:Ljava/lang/CharSequence;

    invoke-static {v0, p2, p3}, Landroid/text/TextUtils;->writeToParcel(Ljava/lang/CharSequence;Landroid/os/Parcel;I)V

    iget-object v0, p1, Landroid/view/accessibility/AccessibilityRecord;->mContentDescription:Ljava/lang/CharSequence;

    invoke-static {v0, p2, p3}, Landroid/text/TextUtils;->writeToParcel(Ljava/lang/CharSequence;Landroid/os/Parcel;I)V

    iget-object v0, p1, Landroid/view/accessibility/AccessibilityRecord;->mBeforeText:Ljava/lang/CharSequence;

    invoke-static {v0, p2, p3}, Landroid/text/TextUtils;->writeToParcel(Ljava/lang/CharSequence;Landroid/os/Parcel;I)V

    iget-object v0, p1, Landroid/view/accessibility/AccessibilityRecord;->mParcelableData:Landroid/os/Parcelable;

    invoke-virtual {p2, v0, p3}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    iget-object v0, p1, Landroid/view/accessibility/AccessibilityRecord;->mText:Ljava/util/List;

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->writeList(Ljava/util/List;)V

    iget v0, p1, Landroid/view/accessibility/AccessibilityRecord;->mSourceWindowId:I

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget-wide v0, p1, Landroid/view/accessibility/AccessibilityRecord;->mSourceNodeId:J

    invoke-virtual {p2, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    iget-boolean v0, p1, Landroid/view/accessibility/AccessibilityRecord;->mSealed:Z

    if-eqz v0, :cond_63

    const/4 v0, 0x1

    :goto_5f
    invoke-virtual {p2, v0}, Landroid/os/Parcel;->writeInt(I)V

    return-void

    :cond_63
    const/4 v0, 0x0

    goto :goto_5f
.end method


# virtual methods
.method public appendRecord(Landroid/view/accessibility/AccessibilityRecord;)V
    .registers 3
    .parameter "record"

    .prologue
    invoke-virtual {p0}, Landroid/view/accessibility/AccessibilityEvent;->enforceNotSealed()V

    iget-object v0, p0, Landroid/view/accessibility/AccessibilityEvent;->mRecords:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method protected clear()V
    .registers 5

    .prologue
    const/4 v3, 0x0

    invoke-super {p0}, Landroid/view/accessibility/AccessibilityRecord;->clear()V

    iput v3, p0, Landroid/view/accessibility/AccessibilityEvent;->mEventType:I

    iput v3, p0, Landroid/view/accessibility/AccessibilityEvent;->mMovementGranularity:I

    iput v3, p0, Landroid/view/accessibility/AccessibilityEvent;->mAction:I

    const/4 v1, 0x0

    iput-object v1, p0, Landroid/view/accessibility/AccessibilityEvent;->mPackageName:Ljava/lang/CharSequence;

    const-wide/16 v1, 0x0

    iput-wide v1, p0, Landroid/view/accessibility/AccessibilityEvent;->mEventTime:J

    :goto_11
    iget-object v1, p0, Landroid/view/accessibility/AccessibilityEvent;->mRecords:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_25

    iget-object v1, p0, Landroid/view/accessibility/AccessibilityEvent;->mRecords:Ljava/util/ArrayList;

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/accessibility/AccessibilityRecord;

    .local v0, record:Landroid/view/accessibility/AccessibilityRecord;
    invoke-virtual {v0}, Landroid/view/accessibility/AccessibilityRecord;->recycle()V

    goto :goto_11

    .end local v0           #record:Landroid/view/accessibility/AccessibilityRecord;
    :cond_25
    return-void
.end method

.method public describeContents()I
    .registers 2

    .prologue
    const/4 v0, 0x0

    return v0
.end method

.method public getAction()I
    .registers 2

    .prologue
    iget v0, p0, Landroid/view/accessibility/AccessibilityEvent;->mAction:I

    return v0
.end method

.method public getEventTime()J
    .registers 3

    .prologue
    iget-wide v0, p0, Landroid/view/accessibility/AccessibilityEvent;->mEventTime:J

    return-wide v0
.end method

.method public getEventType()I
    .registers 2

    .prologue
    iget v0, p0, Landroid/view/accessibility/AccessibilityEvent;->mEventType:I

    return v0
.end method

.method public getMovementGranularity()I
    .registers 2

    .prologue
    iget v0, p0, Landroid/view/accessibility/AccessibilityEvent;->mMovementGranularity:I

    return v0
.end method

.method public getPackageName()Ljava/lang/CharSequence;
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/view/accessibility/AccessibilityEvent;->mPackageName:Ljava/lang/CharSequence;

    return-object v0
.end method

.method public getRecord(I)Landroid/view/accessibility/AccessibilityRecord;
    .registers 3
    .parameter "index"

    .prologue
    iget-object v0, p0, Landroid/view/accessibility/AccessibilityEvent;->mRecords:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/accessibility/AccessibilityRecord;

    return-object v0
.end method

.method public getRecordCount()I
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/view/accessibility/AccessibilityEvent;->mRecords:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method init(Landroid/view/accessibility/AccessibilityEvent;)V
    .registers 4
    .parameter "event"

    .prologue
    invoke-super {p0, p1}, Landroid/view/accessibility/AccessibilityRecord;->init(Landroid/view/accessibility/AccessibilityRecord;)V

    iget v0, p1, Landroid/view/accessibility/AccessibilityEvent;->mEventType:I

    iput v0, p0, Landroid/view/accessibility/AccessibilityEvent;->mEventType:I

    iget v0, p1, Landroid/view/accessibility/AccessibilityEvent;->mMovementGranularity:I

    iput v0, p0, Landroid/view/accessibility/AccessibilityEvent;->mMovementGranularity:I

    iget v0, p1, Landroid/view/accessibility/AccessibilityEvent;->mAction:I

    iput v0, p0, Landroid/view/accessibility/AccessibilityEvent;->mAction:I

    iget-wide v0, p1, Landroid/view/accessibility/AccessibilityEvent;->mEventTime:J

    iput-wide v0, p0, Landroid/view/accessibility/AccessibilityEvent;->mEventTime:J

    iget-object v0, p1, Landroid/view/accessibility/AccessibilityEvent;->mPackageName:Ljava/lang/CharSequence;

    iput-object v0, p0, Landroid/view/accessibility/AccessibilityEvent;->mPackageName:Ljava/lang/CharSequence;

    return-void
.end method

.method public initFromParcel(Landroid/os/Parcel;)V
    .registers 7
    .parameter "parcel"

    .prologue
    const/4 v3, 0x1

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v4

    if-ne v4, v3, :cond_4e

    :goto_7
    iput-boolean v3, p0, Landroid/view/accessibility/AccessibilityRecord;->mSealed:Z

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v3

    iput v3, p0, Landroid/view/accessibility/AccessibilityEvent;->mEventType:I

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v3

    iput v3, p0, Landroid/view/accessibility/AccessibilityEvent;->mMovementGranularity:I

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v3

    iput v3, p0, Landroid/view/accessibility/AccessibilityEvent;->mAction:I

    sget-object v3, Landroid/text/TextUtils;->CHAR_SEQUENCE_CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v3, p1}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/CharSequence;

    iput-object v3, p0, Landroid/view/accessibility/AccessibilityEvent;->mPackageName:Ljava/lang/CharSequence;

    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v3

    iput-wide v3, p0, Landroid/view/accessibility/AccessibilityEvent;->mEventTime:J

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v3

    iput v3, p0, Landroid/view/accessibility/AccessibilityRecord;->mConnectionId:I

    invoke-direct {p0, p0, p1}, Landroid/view/accessibility/AccessibilityEvent;->readAccessibilityRecordFromParcel(Landroid/view/accessibility/AccessibilityRecord;Landroid/os/Parcel;)V

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v2

    .local v2, recordCount:I
    const/4 v0, 0x0

    .local v0, i:I
    :goto_39
    if-ge v0, v2, :cond_50

    invoke-static {}, Landroid/view/accessibility/AccessibilityRecord;->obtain()Landroid/view/accessibility/AccessibilityRecord;

    move-result-object v1

    .local v1, record:Landroid/view/accessibility/AccessibilityRecord;
    invoke-direct {p0, v1, p1}, Landroid/view/accessibility/AccessibilityEvent;->readAccessibilityRecordFromParcel(Landroid/view/accessibility/AccessibilityRecord;Landroid/os/Parcel;)V

    iget v3, p0, Landroid/view/accessibility/AccessibilityRecord;->mConnectionId:I

    iput v3, v1, Landroid/view/accessibility/AccessibilityRecord;->mConnectionId:I

    iget-object v3, p0, Landroid/view/accessibility/AccessibilityEvent;->mRecords:Ljava/util/ArrayList;

    invoke-virtual {v3, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    add-int/lit8 v0, v0, 0x1

    goto :goto_39

    .end local v0           #i:I
    .end local v1           #record:Landroid/view/accessibility/AccessibilityRecord;
    .end local v2           #recordCount:I
    :cond_4e
    const/4 v3, 0x0

    goto :goto_7

    .restart local v0       #i:I
    .restart local v2       #recordCount:I
    :cond_50
    return-void
.end method

.method public recycle()V
    .registers 4

    .prologue
    iget-boolean v0, p0, Landroid/view/accessibility/AccessibilityEvent;->mIsInPool:Z

    if-eqz v0, :cond_c

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Event already recycled!"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_c
    invoke-virtual {p0}, Landroid/view/accessibility/AccessibilityEvent;->clear()V

    sget-object v1, Landroid/view/accessibility/AccessibilityEvent;->sPoolLock:Ljava/lang/Object;

    monitor-enter v1

    :try_start_12
    sget v0, Landroid/view/accessibility/AccessibilityEvent;->sPoolSize:I

    const/16 v2, 0xa

    if-gt v0, v2, :cond_27

    sget-object v0, Landroid/view/accessibility/AccessibilityEvent;->sPool:Landroid/view/accessibility/AccessibilityEvent;

    iput-object v0, p0, Landroid/view/accessibility/AccessibilityEvent;->mNext:Landroid/view/accessibility/AccessibilityEvent;

    sput-object p0, Landroid/view/accessibility/AccessibilityEvent;->sPool:Landroid/view/accessibility/AccessibilityEvent;

    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/view/accessibility/AccessibilityEvent;->mIsInPool:Z

    sget v0, Landroid/view/accessibility/AccessibilityEvent;->sPoolSize:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Landroid/view/accessibility/AccessibilityEvent;->sPoolSize:I

    :cond_27
    monitor-exit v1

    return-void

    :catchall_29
    move-exception v0

    monitor-exit v1
    :try_end_2b
    .catchall {:try_start_12 .. :try_end_2b} :catchall_29

    throw v0
.end method

.method public setAction(I)V
    .registers 2
    .parameter "action"

    .prologue
    invoke-virtual {p0}, Landroid/view/accessibility/AccessibilityEvent;->enforceNotSealed()V

    iput p1, p0, Landroid/view/accessibility/AccessibilityEvent;->mAction:I

    return-void
.end method

.method public setEventTime(J)V
    .registers 3
    .parameter "eventTime"

    .prologue
    invoke-virtual {p0}, Landroid/view/accessibility/AccessibilityEvent;->enforceNotSealed()V

    iput-wide p1, p0, Landroid/view/accessibility/AccessibilityEvent;->mEventTime:J

    return-void
.end method

.method public setEventType(I)V
    .registers 2
    .parameter "eventType"

    .prologue
    invoke-virtual {p0}, Landroid/view/accessibility/AccessibilityEvent;->enforceNotSealed()V

    iput p1, p0, Landroid/view/accessibility/AccessibilityEvent;->mEventType:I

    return-void
.end method

.method public setMovementGranularity(I)V
    .registers 2
    .parameter "granularity"

    .prologue
    invoke-virtual {p0}, Landroid/view/accessibility/AccessibilityEvent;->enforceNotSealed()V

    iput p1, p0, Landroid/view/accessibility/AccessibilityEvent;->mMovementGranularity:I

    return-void
.end method

.method public setPackageName(Ljava/lang/CharSequence;)V
    .registers 2
    .parameter "packageName"

    .prologue
    invoke-virtual {p0}, Landroid/view/accessibility/AccessibilityEvent;->enforceNotSealed()V

    iput-object p1, p0, Landroid/view/accessibility/AccessibilityEvent;->mPackageName:Ljava/lang/CharSequence;

    return-void
.end method

.method public setSealed(Z)V
    .registers 6
    .parameter "sealed"

    .prologue
    invoke-super {p0, p1}, Landroid/view/accessibility/AccessibilityRecord;->setSealed(Z)V

    iget-object v3, p0, Landroid/view/accessibility/AccessibilityEvent;->mRecords:Ljava/util/ArrayList;

    .local v3, records:Ljava/util/List;,"Ljava/util/List<Landroid/view/accessibility/AccessibilityRecord;>;"
    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v2

    .local v2, recordCount:I
    const/4 v0, 0x0

    .local v0, i:I
    :goto_a
    if-ge v0, v2, :cond_18

    invoke-interface {v3, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/accessibility/AccessibilityRecord;

    .local v1, record:Landroid/view/accessibility/AccessibilityRecord;
    invoke-virtual {v1, p1}, Landroid/view/accessibility/AccessibilityRecord;->setSealed(Z)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_a

    .end local v1           #record:Landroid/view/accessibility/AccessibilityRecord;
    :cond_18
    return-void
.end method

.method public toString()Ljava/lang/String;
    .registers 5

    .prologue
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .local v0, builder:Ljava/lang/StringBuilder;
    const-string v1, "EventType: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Landroid/view/accessibility/AccessibilityEvent;->mEventType:I

    invoke-static {v2}, Landroid/view/accessibility/AccessibilityEvent;->eventTypeToString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "; EventTime: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-wide v2, p0, Landroid/view/accessibility/AccessibilityEvent;->mEventTime:J

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    const-string v1, "; PackageName: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Landroid/view/accessibility/AccessibilityEvent;->mPackageName:Ljava/lang/CharSequence;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;

    const-string v1, "; MovementGranularity: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Landroid/view/accessibility/AccessibilityEvent;->mMovementGranularity:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v1, "; Action: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Landroid/view/accessibility/AccessibilityEvent;->mAction:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-super {p0}, Landroid/view/accessibility/AccessibilityRecord;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "; recordCount: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Landroid/view/accessibility/AccessibilityEvent;->getRecordCount()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .registers 8
    .parameter "parcel"
    .parameter "flags"

    .prologue
    const/4 v4, 0x0

    invoke-virtual {p0}, Landroid/view/accessibility/AccessibilityEvent;->isSealed()Z

    move-result v3

    if-eqz v3, :cond_44

    const/4 v3, 0x1

    :goto_8
    invoke-virtual {p1, v3}, Landroid/os/Parcel;->writeInt(I)V

    iget v3, p0, Landroid/view/accessibility/AccessibilityEvent;->mEventType:I

    invoke-virtual {p1, v3}, Landroid/os/Parcel;->writeInt(I)V

    iget v3, p0, Landroid/view/accessibility/AccessibilityEvent;->mMovementGranularity:I

    invoke-virtual {p1, v3}, Landroid/os/Parcel;->writeInt(I)V

    iget v3, p0, Landroid/view/accessibility/AccessibilityEvent;->mAction:I

    invoke-virtual {p1, v3}, Landroid/os/Parcel;->writeInt(I)V

    iget-object v3, p0, Landroid/view/accessibility/AccessibilityEvent;->mPackageName:Ljava/lang/CharSequence;

    invoke-static {v3, p1, v4}, Landroid/text/TextUtils;->writeToParcel(Ljava/lang/CharSequence;Landroid/os/Parcel;I)V

    iget-wide v3, p0, Landroid/view/accessibility/AccessibilityEvent;->mEventTime:J

    invoke-virtual {p1, v3, v4}, Landroid/os/Parcel;->writeLong(J)V

    iget v3, p0, Landroid/view/accessibility/AccessibilityRecord;->mConnectionId:I

    invoke-virtual {p1, v3}, Landroid/os/Parcel;->writeInt(I)V

    invoke-direct {p0, p0, p1, p2}, Landroid/view/accessibility/AccessibilityEvent;->writeAccessibilityRecordToParcel(Landroid/view/accessibility/AccessibilityRecord;Landroid/os/Parcel;I)V

    invoke-virtual {p0}, Landroid/view/accessibility/AccessibilityEvent;->getRecordCount()I

    move-result v2

    .local v2, recordCount:I
    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeInt(I)V

    const/4 v0, 0x0

    .local v0, i:I
    :goto_34
    if-ge v0, v2, :cond_46

    iget-object v3, p0, Landroid/view/accessibility/AccessibilityEvent;->mRecords:Ljava/util/ArrayList;

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/accessibility/AccessibilityRecord;

    .local v1, record:Landroid/view/accessibility/AccessibilityRecord;
    invoke-direct {p0, v1, p1, p2}, Landroid/view/accessibility/AccessibilityEvent;->writeAccessibilityRecordToParcel(Landroid/view/accessibility/AccessibilityRecord;Landroid/os/Parcel;I)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_34

    .end local v0           #i:I
    .end local v1           #record:Landroid/view/accessibility/AccessibilityRecord;
    .end local v2           #recordCount:I
    :cond_44
    move v3, v4

    goto :goto_8

    .restart local v0       #i:I
    .restart local v2       #recordCount:I
    :cond_46
    return-void
.end method
