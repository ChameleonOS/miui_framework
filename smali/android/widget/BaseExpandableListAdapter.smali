.class public abstract Landroid/widget/BaseExpandableListAdapter;
.super Ljava/lang/Object;
.source "BaseExpandableListAdapter.java"

# interfaces
.implements Landroid/widget/ExpandableListAdapter;
.implements Landroid/widget/HeterogeneousExpandableList;


# instance fields
.field private final mDataSetObservable:Landroid/database/DataSetObservable;


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 33
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 35
    new-instance v0, Landroid/database/DataSetObservable;

    invoke-direct {v0}, Landroid/database/DataSetObservable;-><init>()V

    iput-object v0, p0, Landroid/widget/BaseExpandableListAdapter;->mDataSetObservable:Landroid/database/DataSetObservable;

    return-void
.end method


# virtual methods
.method public areAllItemsEnabled()Z
    .registers 2

    .prologue
    .line 60
    const/4 v0, 0x1

    return v0
.end method

.method public getChildType(II)I
    .registers 4
    .parameter "groupPosition"
    .parameter "childPosition"

    .prologue
    .line 112
    const/4 v0, 0x0

    return v0
.end method

.method public getChildTypeCount()I
    .registers 2

    .prologue
    .line 120
    const/4 v0, 0x1

    return v0
.end method

.method public getCombinedChildId(JJ)J
    .registers 10
    .parameter "groupId"
    .parameter "childId"

    .prologue
    .line 81
    const-wide/high16 v0, -0x8000

    const-wide/32 v2, 0x7fffffff

    and-long/2addr v2, p1

    const/16 v4, 0x20

    shl-long/2addr v2, v4

    or-long/2addr v0, v2

    const-wide/16 v2, -0x1

    and-long/2addr v2, p3

    or-long/2addr v0, v2

    return-wide v0
.end method

.method public getCombinedGroupId(J)J
    .registers 6
    .parameter "groupId"

    .prologue
    .line 96
    const-wide/32 v0, 0x7fffffff

    and-long/2addr v0, p1

    const/16 v2, 0x20

    shl-long/2addr v0, v2

    return-wide v0
.end method

.method public getGroupType(I)I
    .registers 3
    .parameter "groupPosition"

    .prologue
    .line 128
    const/4 v0, 0x0

    return v0
.end method

.method public getGroupTypeCount()I
    .registers 2

    .prologue
    .line 136
    const/4 v0, 0x1

    return v0
.end method

.method public isEmpty()Z
    .registers 2

    .prologue
    .line 103
    invoke-virtual {p0}, Landroid/widget/BaseExpandableListAdapter;->getGroupCount()I

    move-result v0

    if-nez v0, :cond_8

    const/4 v0, 0x1

    :goto_7
    return v0

    :cond_8
    const/4 v0, 0x0

    goto :goto_7
.end method

.method public notifyDataSetChanged()V
    .registers 2

    .prologue
    .line 56
    iget-object v0, p0, Landroid/widget/BaseExpandableListAdapter;->mDataSetObservable:Landroid/database/DataSetObservable;

    invoke-virtual {v0}, Landroid/database/DataSetObservable;->notifyChanged()V

    .line 57
    return-void
.end method

.method public notifyDataSetInvalidated()V
    .registers 2

    .prologue
    .line 49
    iget-object v0, p0, Landroid/widget/BaseExpandableListAdapter;->mDataSetObservable:Landroid/database/DataSetObservable;

    invoke-virtual {v0}, Landroid/database/DataSetObservable;->notifyInvalidated()V

    .line 50
    return-void
.end method

.method public onGroupCollapsed(I)V
    .registers 2
    .parameter "groupPosition"

    .prologue
    .line 64
    return-void
.end method

.method public onGroupExpanded(I)V
    .registers 2
    .parameter "groupPosition"

    .prologue
    .line 67
    return-void
.end method

.method public registerDataSetObserver(Landroid/database/DataSetObserver;)V
    .registers 3
    .parameter "observer"

    .prologue
    .line 38
    iget-object v0, p0, Landroid/widget/BaseExpandableListAdapter;->mDataSetObservable:Landroid/database/DataSetObservable;

    invoke-virtual {v0, p1}, Landroid/database/DataSetObservable;->registerObserver(Ljava/lang/Object;)V

    .line 39
    return-void
.end method

.method public unregisterDataSetObserver(Landroid/database/DataSetObserver;)V
    .registers 3
    .parameter "observer"

    .prologue
    .line 42
    iget-object v0, p0, Landroid/widget/BaseExpandableListAdapter;->mDataSetObservable:Landroid/database/DataSetObservable;

    invoke-virtual {v0, p1}, Landroid/database/DataSetObservable;->unregisterObserver(Ljava/lang/Object;)V

    .line 43
    return-void
.end method
