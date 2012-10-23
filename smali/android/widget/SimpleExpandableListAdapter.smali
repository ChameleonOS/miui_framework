.class public Landroid/widget/SimpleExpandableListAdapter;
.super Landroid/widget/BaseExpandableListAdapter;
.source "SimpleExpandableListAdapter.java"


# instance fields
.field private mChildData:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<+",
            "Ljava/util/List",
            "<+",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "*>;>;>;"
        }
    .end annotation
.end field

.field private mChildFrom:[Ljava/lang/String;

.field private mChildLayout:I

.field private mChildTo:[I

.field private mCollapsedGroupLayout:I

.field private mExpandedGroupLayout:I

.field private mGroupData:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<+",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "*>;>;"
        }
    .end annotation
.end field

.field private mGroupFrom:[Ljava/lang/String;

.field private mGroupTo:[I

.field private mInflater:Landroid/view/LayoutInflater;

.field private mLastChildLayout:I


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/util/List;II[Ljava/lang/String;[ILjava/util/List;II[Ljava/lang/String;[I)V
    .registers 13
    .parameter "context"
    .parameter
    .parameter "expandedGroupLayout"
    .parameter "collapsedGroupLayout"
    .parameter "groupFrom"
    .parameter "groupTo"
    .parameter
    .parameter "childLayout"
    .parameter "lastChildLayout"
    .parameter "childFrom"
    .parameter "childTo"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/List",
            "<+",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "*>;>;II[",
            "Ljava/lang/String;",
            "[I",
            "Ljava/util/List",
            "<+",
            "Ljava/util/List",
            "<+",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "*>;>;>;II[",
            "Ljava/lang/String;",
            "[I)V"
        }
    .end annotation

    .prologue
    .line 197
    .local p2, groupData:Ljava/util/List;,"Ljava/util/List<+Ljava/util/Map<Ljava/lang/String;*>;>;"
    .local p7, childData:Ljava/util/List;,"Ljava/util/List<+Ljava/util/List<+Ljava/util/Map<Ljava/lang/String;*>;>;>;"
    invoke-direct {p0}, Landroid/widget/BaseExpandableListAdapter;-><init>()V

    .line 198
    iput-object p2, p0, Landroid/widget/SimpleExpandableListAdapter;->mGroupData:Ljava/util/List;

    .line 199
    iput p3, p0, Landroid/widget/SimpleExpandableListAdapter;->mExpandedGroupLayout:I

    .line 200
    iput p4, p0, Landroid/widget/SimpleExpandableListAdapter;->mCollapsedGroupLayout:I

    .line 201
    iput-object p5, p0, Landroid/widget/SimpleExpandableListAdapter;->mGroupFrom:[Ljava/lang/String;

    .line 202
    iput-object p6, p0, Landroid/widget/SimpleExpandableListAdapter;->mGroupTo:[I

    .line 204
    iput-object p7, p0, Landroid/widget/SimpleExpandableListAdapter;->mChildData:Ljava/util/List;

    .line 205
    iput p8, p0, Landroid/widget/SimpleExpandableListAdapter;->mChildLayout:I

    .line 206
    iput p9, p0, Landroid/widget/SimpleExpandableListAdapter;->mLastChildLayout:I

    .line 207
    iput-object p10, p0, Landroid/widget/SimpleExpandableListAdapter;->mChildFrom:[Ljava/lang/String;

    .line 208
    iput-object p11, p0, Landroid/widget/SimpleExpandableListAdapter;->mChildTo:[I

    .line 210
    const-string v0, "layout_inflater"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    iput-object v0, p0, Landroid/widget/SimpleExpandableListAdapter;->mInflater:Landroid/view/LayoutInflater;

    .line 211
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/util/List;II[Ljava/lang/String;[ILjava/util/List;I[Ljava/lang/String;[I)V
    .registers 23
    .parameter "context"
    .parameter
    .parameter "expandedGroupLayout"
    .parameter "collapsedGroupLayout"
    .parameter "groupFrom"
    .parameter "groupTo"
    .parameter
    .parameter "childLayout"
    .parameter "childFrom"
    .parameter "childTo"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/List",
            "<+",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "*>;>;II[",
            "Ljava/lang/String;",
            "[I",
            "Ljava/util/List",
            "<+",
            "Ljava/util/List",
            "<+",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "*>;>;>;I[",
            "Ljava/lang/String;",
            "[I)V"
        }
    .end annotation

    .prologue
    .line 143
    .local p2, groupData:Ljava/util/List;,"Ljava/util/List<+Ljava/util/Map<Ljava/lang/String;*>;>;"
    .local p7, childData:Ljava/util/List;,"Ljava/util/List<+Ljava/util/List<+Ljava/util/Map<Ljava/lang/String;*>;>;>;"
    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move v3, p3

    move/from16 v4, p4

    move-object/from16 v5, p5

    move-object/from16 v6, p6

    move-object/from16 v7, p7

    move/from16 v8, p8

    move/from16 v9, p8

    move-object/from16 v10, p9

    move-object/from16 v11, p10

    invoke-direct/range {v0 .. v11}, Landroid/widget/SimpleExpandableListAdapter;-><init>(Landroid/content/Context;Ljava/util/List;II[Ljava/lang/String;[ILjava/util/List;II[Ljava/lang/String;[I)V

    .line 146
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/util/List;I[Ljava/lang/String;[ILjava/util/List;I[Ljava/lang/String;[I)V
    .registers 22
    .parameter "context"
    .parameter
    .parameter "groupLayout"
    .parameter "groupFrom"
    .parameter "groupTo"
    .parameter
    .parameter "childLayout"
    .parameter "childFrom"
    .parameter "childTo"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/List",
            "<+",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "*>;>;I[",
            "Ljava/lang/String;",
            "[I",
            "Ljava/util/List",
            "<+",
            "Ljava/util/List",
            "<+",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "*>;>;>;I[",
            "Ljava/lang/String;",
            "[I)V"
        }
    .end annotation

    .prologue
    .line 95
    .local p2, groupData:Ljava/util/List;,"Ljava/util/List<+Ljava/util/Map<Ljava/lang/String;*>;>;"
    .local p6, childData:Ljava/util/List;,"Ljava/util/List<+Ljava/util/List<+Ljava/util/Map<Ljava/lang/String;*>;>;>;"
    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move v3, p3

    move v4, p3

    move-object/from16 v5, p4

    move-object/from16 v6, p5

    move-object/from16 v7, p6

    move/from16 v8, p7

    move/from16 v9, p7

    move-object/from16 v10, p8

    move-object/from16 v11, p9

    invoke-direct/range {v0 .. v11}, Landroid/widget/SimpleExpandableListAdapter;-><init>(Landroid/content/Context;Ljava/util/List;II[Ljava/lang/String;[ILjava/util/List;II[Ljava/lang/String;[I)V

    .line 97
    return-void
.end method

.method private bindView(Landroid/view/View;Ljava/util/Map;[Ljava/lang/String;[I)V
    .registers 9
    .parameter "view"
    .parameter
    .parameter "from"
    .parameter "to"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/View;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "*>;[",
            "Ljava/lang/String;",
            "[I)V"
        }
    .end annotation

    .prologue
    .line 244
    .local p2, data:Ljava/util/Map;,"Ljava/util/Map<Ljava/lang/String;*>;"
    array-length v1, p4

    .line 246
    .local v1, len:I
    const/4 v0, 0x0

    .local v0, i:I
    :goto_2
    if-ge v0, v1, :cond_1c

    .line 247
    aget v3, p4, v0

    invoke-virtual {p1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 248
    .local v2, v:Landroid/widget/TextView;
    if-eqz v2, :cond_19

    .line 249
    aget-object v3, p3, v0

    invoke-interface {p2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 246
    :cond_19
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 252
    .end local v2           #v:Landroid/widget/TextView;
    :cond_1c
    return-void
.end method


# virtual methods
.method public getChild(II)Ljava/lang/Object;
    .registers 4
    .parameter "groupPosition"
    .parameter "childPosition"

    .prologue
    .line 214
    iget-object v0, p0, Landroid/widget/SimpleExpandableListAdapter;->mChildData:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getChildId(II)J
    .registers 5
    .parameter "groupPosition"
    .parameter "childPosition"

    .prologue
    .line 218
    int-to-long v0, p2

    return-wide v0
.end method

.method public getChildView(IIZLandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .registers 10
    .parameter "groupPosition"
    .parameter "childPosition"
    .parameter "isLastChild"
    .parameter "convertView"
    .parameter "parent"

    .prologue
    .line 224
    if-nez p4, :cond_1c

    .line 225
    invoke-virtual {p0, p3, p5}, Landroid/widget/SimpleExpandableListAdapter;->newChildView(ZLandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 229
    .local v0, v:Landroid/view/View;
    :goto_6
    iget-object v1, p0, Landroid/widget/SimpleExpandableListAdapter;->mChildData:Ljava/util/List;

    invoke-interface {v1, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    invoke-interface {v1, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map;

    iget-object v2, p0, Landroid/widget/SimpleExpandableListAdapter;->mChildFrom:[Ljava/lang/String;

    iget-object v3, p0, Landroid/widget/SimpleExpandableListAdapter;->mChildTo:[I

    invoke-direct {p0, v0, v1, v2, v3}, Landroid/widget/SimpleExpandableListAdapter;->bindView(Landroid/view/View;Ljava/util/Map;[Ljava/lang/String;[I)V

    .line 230
    return-object v0

    .line 227
    .end local v0           #v:Landroid/view/View;
    :cond_1c
    move-object v0, p4

    .restart local v0       #v:Landroid/view/View;
    goto :goto_6
.end method

.method public getChildrenCount(I)I
    .registers 3
    .parameter "groupPosition"

    .prologue
    .line 255
    iget-object v0, p0, Landroid/widget/SimpleExpandableListAdapter;->mChildData:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getGroup(I)Ljava/lang/Object;
    .registers 3
    .parameter "groupPosition"

    .prologue
    .line 259
    iget-object v0, p0, Landroid/widget/SimpleExpandableListAdapter;->mGroupData:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getGroupCount()I
    .registers 2

    .prologue
    .line 263
    iget-object v0, p0, Landroid/widget/SimpleExpandableListAdapter;->mGroupData:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getGroupId(I)J
    .registers 4
    .parameter "groupPosition"

    .prologue
    .line 267
    int-to-long v0, p1

    return-wide v0
.end method

.method public getGroupView(IZLandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .registers 9
    .parameter "groupPosition"
    .parameter "isExpanded"
    .parameter "convertView"
    .parameter "parent"

    .prologue
    .line 273
    if-nez p3, :cond_16

    .line 274
    invoke-virtual {p0, p2, p4}, Landroid/widget/SimpleExpandableListAdapter;->newGroupView(ZLandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 278
    .local v0, v:Landroid/view/View;
    :goto_6
    iget-object v1, p0, Landroid/widget/SimpleExpandableListAdapter;->mGroupData:Ljava/util/List;

    invoke-interface {v1, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map;

    iget-object v2, p0, Landroid/widget/SimpleExpandableListAdapter;->mGroupFrom:[Ljava/lang/String;

    iget-object v3, p0, Landroid/widget/SimpleExpandableListAdapter;->mGroupTo:[I

    invoke-direct {p0, v0, v1, v2, v3}, Landroid/widget/SimpleExpandableListAdapter;->bindView(Landroid/view/View;Ljava/util/Map;[Ljava/lang/String;[I)V

    .line 279
    return-object v0

    .line 276
    .end local v0           #v:Landroid/view/View;
    :cond_16
    move-object v0, p3

    .restart local v0       #v:Landroid/view/View;
    goto :goto_6
.end method

.method public hasStableIds()Z
    .registers 2

    .prologue
    .line 298
    const/4 v0, 0x1

    return v0
.end method

.method public isChildSelectable(II)Z
    .registers 4
    .parameter "groupPosition"
    .parameter "childPosition"

    .prologue
    .line 294
    const/4 v0, 0x1

    return v0
.end method

.method public newChildView(ZLandroid/view/ViewGroup;)Landroid/view/View;
    .registers 6
    .parameter "isLastChild"
    .parameter "parent"

    .prologue
    .line 240
    iget-object v1, p0, Landroid/widget/SimpleExpandableListAdapter;->mInflater:Landroid/view/LayoutInflater;

    if-eqz p1, :cond_c

    iget v0, p0, Landroid/widget/SimpleExpandableListAdapter;->mLastChildLayout:I

    :goto_6
    const/4 v2, 0x0

    invoke-virtual {v1, v0, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0

    :cond_c
    iget v0, p0, Landroid/widget/SimpleExpandableListAdapter;->mChildLayout:I

    goto :goto_6
.end method

.method public newGroupView(ZLandroid/view/ViewGroup;)Landroid/view/View;
    .registers 6
    .parameter "isExpanded"
    .parameter "parent"

    .prologue
    .line 289
    iget-object v1, p0, Landroid/widget/SimpleExpandableListAdapter;->mInflater:Landroid/view/LayoutInflater;

    if-eqz p1, :cond_c

    iget v0, p0, Landroid/widget/SimpleExpandableListAdapter;->mExpandedGroupLayout:I

    :goto_6
    const/4 v2, 0x0

    invoke-virtual {v1, v0, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0

    :cond_c
    iget v0, p0, Landroid/widget/SimpleExpandableListAdapter;->mCollapsedGroupLayout:I

    goto :goto_6
.end method
