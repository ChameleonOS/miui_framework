.class Landroid/view/AccessibilityInteractionController$AccessibilityNodePrefetcher;
.super Ljava/lang/Object;
.source "AccessibilityInteractionController.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/view/AccessibilityInteractionController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "AccessibilityNodePrefetcher"
.end annotation


# static fields
.field private static final MAX_ACCESSIBILITY_NODE_INFO_BATCH_SIZE:I = 0x32


# instance fields
.field private final mTempViewList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic this$0:Landroid/view/AccessibilityInteractionController;


# direct methods
.method private constructor <init>(Landroid/view/AccessibilityInteractionController;)V
    .registers 3
    .parameter

    .prologue
    iput-object p1, p0, Landroid/view/AccessibilityInteractionController$AccessibilityNodePrefetcher;->this$0:Landroid/view/AccessibilityInteractionController;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/view/AccessibilityInteractionController$AccessibilityNodePrefetcher;->mTempViewList:Ljava/util/ArrayList;

    return-void
.end method

.method synthetic constructor <init>(Landroid/view/AccessibilityInteractionController;Landroid/view/AccessibilityInteractionController$1;)V
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    invoke-direct {p0, p1}, Landroid/view/AccessibilityInteractionController$AccessibilityNodePrefetcher;-><init>(Landroid/view/AccessibilityInteractionController;)V

    return-void
.end method

.method private prefetchDescendantsOfRealNode(Landroid/view/View;Ljava/util/List;)V
    .registers 16
    .parameter "root"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/View;",
            "Ljava/util/List",
            "<",
            "Landroid/view/accessibility/AccessibilityNodeInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p2, outInfos:Ljava/util/List;,"Ljava/util/List<Landroid/view/accessibility/AccessibilityNodeInfo;>;"
    const/16 v12, 0x32

    instance-of v11, p1, Landroid/view/ViewGroup;

    if-nez v11, :cond_7

    :cond_6
    :goto_6
    return-void

    :cond_7
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .local v1, addedChildren:Ljava/util/HashMap;,"Ljava/util/HashMap<Landroid/view/View;Landroid/view/accessibility/AccessibilityNodeInfo;>;"
    iget-object v4, p0, Landroid/view/AccessibilityInteractionController$AccessibilityNodePrefetcher;->mTempViewList:Ljava/util/ArrayList;

    .local v4, children:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/view/View;>;"
    invoke-virtual {v4}, Ljava/util/ArrayList;->clear()V

    :try_start_11
    invoke-virtual {p1, v4}, Landroid/view/View;->addChildrenForAccessibility(Ljava/util/ArrayList;)V

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v3

    .local v3, childCount:I
    const/4 v6, 0x0

    .local v6, i:I
    :goto_19
    if-ge v6, v3, :cond_5c

    invoke-interface {p2}, Ljava/util/List;->size()I
    :try_end_1e
    .catchall {:try_start_11 .. :try_end_1e} :catchall_57

    move-result v11

    if-lt v11, v12, :cond_25

    invoke-virtual {v4}, Ljava/util/ArrayList;->clear()V

    goto :goto_6

    :cond_25
    :try_start_25
    invoke-virtual {v4, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/view/View;

    .local v2, child:Landroid/view/View;
    iget-object v11, p0, Landroid/view/AccessibilityInteractionController$AccessibilityNodePrefetcher;->this$0:Landroid/view/AccessibilityInteractionController;

    #calls: Landroid/view/AccessibilityInteractionController;->isShown(Landroid/view/View;)Z
    invoke-static {v11, v2}, Landroid/view/AccessibilityInteractionController;->access$300(Landroid/view/AccessibilityInteractionController;Landroid/view/View;)Z

    move-result v11

    if-eqz v11, :cond_46

    invoke-virtual {v2}, Landroid/view/View;->getAccessibilityNodeProvider()Landroid/view/accessibility/AccessibilityNodeProvider;

    move-result-object v9

    .local v9, provider:Landroid/view/accessibility/AccessibilityNodeProvider;
    if-nez v9, :cond_49

    invoke-virtual {v2}, Landroid/view/View;->createAccessibilityNodeInfo()Landroid/view/accessibility/AccessibilityNodeInfo;

    move-result-object v8

    .local v8, info:Landroid/view/accessibility/AccessibilityNodeInfo;
    if-eqz v8, :cond_46

    invoke-interface {p2, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    const/4 v11, 0x0

    invoke-virtual {v1, v2, v11}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .end local v8           #info:Landroid/view/accessibility/AccessibilityNodeInfo;
    .end local v9           #provider:Landroid/view/accessibility/AccessibilityNodeProvider;
    :cond_46
    :goto_46
    add-int/lit8 v6, v6, 0x1

    goto :goto_19

    .restart local v9       #provider:Landroid/view/accessibility/AccessibilityNodeProvider;
    :cond_49
    const/4 v11, -0x1

    invoke-virtual {v9, v11}, Landroid/view/accessibility/AccessibilityNodeProvider;->createAccessibilityNodeInfo(I)Landroid/view/accessibility/AccessibilityNodeInfo;

    move-result-object v8

    .restart local v8       #info:Landroid/view/accessibility/AccessibilityNodeInfo;
    if-eqz v8, :cond_46

    invoke-interface {p2, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    invoke-virtual {v1, v2, v8}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_56
    .catchall {:try_start_25 .. :try_end_56} :catchall_57

    goto :goto_46

    .end local v2           #child:Landroid/view/View;
    .end local v3           #childCount:I
    .end local v6           #i:I
    .end local v8           #info:Landroid/view/accessibility/AccessibilityNodeInfo;
    .end local v9           #provider:Landroid/view/accessibility/AccessibilityNodeProvider;
    :catchall_57
    move-exception v11

    invoke-virtual {v4}, Ljava/util/ArrayList;->clear()V

    throw v11

    .restart local v3       #childCount:I
    .restart local v6       #i:I
    :cond_5c
    invoke-virtual {v4}, Ljava/util/ArrayList;->clear()V

    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v11

    if-ge v11, v12, :cond_6

    invoke-virtual {v1}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v11

    invoke-interface {v11}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v7

    .local v7, i$:Ljava/util/Iterator;
    :goto_6d
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-eqz v11, :cond_6

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/Map$Entry;

    .local v5, entry:Ljava/util/Map$Entry;,"Ljava/util/Map$Entry<Landroid/view/View;Landroid/view/accessibility/AccessibilityNodeInfo;>;"
    invoke-interface {v5}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    .local v0, addedChild:Landroid/view/View;
    invoke-interface {v5}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Landroid/view/accessibility/AccessibilityNodeInfo;

    .local v10, virtualRoot:Landroid/view/accessibility/AccessibilityNodeInfo;
    if-nez v10, :cond_8b

    invoke-direct {p0, v0, p2}, Landroid/view/AccessibilityInteractionController$AccessibilityNodePrefetcher;->prefetchDescendantsOfRealNode(Landroid/view/View;Ljava/util/List;)V

    goto :goto_6d

    :cond_8b
    invoke-virtual {v0}, Landroid/view/View;->getAccessibilityNodeProvider()Landroid/view/accessibility/AccessibilityNodeProvider;

    move-result-object v9

    .restart local v9       #provider:Landroid/view/accessibility/AccessibilityNodeProvider;
    invoke-direct {p0, v10, v9, p2}, Landroid/view/AccessibilityInteractionController$AccessibilityNodePrefetcher;->prefetchDescendantsOfVirtualNode(Landroid/view/accessibility/AccessibilityNodeInfo;Landroid/view/accessibility/AccessibilityNodeProvider;Ljava/util/List;)V

    goto :goto_6d
.end method

.method private prefetchDescendantsOfVirtualNode(Landroid/view/accessibility/AccessibilityNodeInfo;Landroid/view/accessibility/AccessibilityNodeProvider;Ljava/util/List;)V
    .registers 14
    .parameter "root"
    .parameter "provider"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/accessibility/AccessibilityNodeInfo;",
            "Landroid/view/accessibility/AccessibilityNodeProvider;",
            "Ljava/util/List",
            "<",
            "Landroid/view/accessibility/AccessibilityNodeInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p3, outInfos:Ljava/util/List;,"Ljava/util/List<Landroid/view/accessibility/AccessibilityNodeInfo;>;"
    const/16 v9, 0x32

    invoke-virtual {p1}, Landroid/view/accessibility/AccessibilityNodeInfo;->getChildNodeIds()Landroid/util/SparseLongArray;

    move-result-object v5

    .local v5, childNodeIds:Landroid/util/SparseLongArray;
    invoke-interface {p3}, Ljava/util/List;->size()I

    move-result v7

    .local v7, initialOutInfosSize:I
    invoke-virtual {v5}, Landroid/util/SparseLongArray;->size()I

    move-result v2

    .local v2, childCount:I
    const/4 v6, 0x0

    .local v6, i:I
    :goto_f
    if-ge v6, v2, :cond_2c

    invoke-interface {p3}, Ljava/util/List;->size()I

    move-result v8

    if-lt v8, v9, :cond_18

    :cond_17
    return-void

    :cond_18
    invoke-virtual {v5, v6}, Landroid/util/SparseLongArray;->get(I)J

    move-result-wide v3

    .local v3, childNodeId:J
    invoke-static {v3, v4}, Landroid/view/accessibility/AccessibilityNodeInfo;->getVirtualDescendantId(J)I

    move-result v8

    invoke-virtual {p2, v8}, Landroid/view/accessibility/AccessibilityNodeProvider;->createAccessibilityNodeInfo(I)Landroid/view/accessibility/AccessibilityNodeInfo;

    move-result-object v1

    .local v1, child:Landroid/view/accessibility/AccessibilityNodeInfo;
    if-eqz v1, :cond_29

    invoke-interface {p3, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_29
    add-int/lit8 v6, v6, 0x1

    goto :goto_f

    .end local v1           #child:Landroid/view/accessibility/AccessibilityNodeInfo;
    .end local v3           #childNodeId:J
    :cond_2c
    invoke-interface {p3}, Ljava/util/List;->size()I

    move-result v8

    if-ge v8, v9, :cond_17

    invoke-interface {p3}, Ljava/util/List;->size()I

    move-result v8

    sub-int v0, v8, v7

    .local v0, addedChildCount:I
    const/4 v6, 0x0

    :goto_39
    if-ge v6, v0, :cond_17

    add-int v8, v7, v6

    invoke-interface {p3, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/accessibility/AccessibilityNodeInfo;

    .restart local v1       #child:Landroid/view/accessibility/AccessibilityNodeInfo;
    invoke-direct {p0, v1, p2, p3}, Landroid/view/AccessibilityInteractionController$AccessibilityNodePrefetcher;->prefetchDescendantsOfVirtualNode(Landroid/view/accessibility/AccessibilityNodeInfo;Landroid/view/accessibility/AccessibilityNodeProvider;Ljava/util/List;)V

    add-int/lit8 v6, v6, 0x1

    goto :goto_39
.end method

.method private prefetchPredecessorsOfRealNode(Landroid/view/View;Ljava/util/List;)V
    .registers 8
    .parameter "view"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/View;",
            "Ljava/util/List",
            "<",
            "Landroid/view/accessibility/AccessibilityNodeInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p2, outInfos:Ljava/util/List;,"Ljava/util/List<Landroid/view/accessibility/AccessibilityNodeInfo;>;"
    invoke-virtual {p1}, Landroid/view/View;->getParentForAccessibility()Landroid/view/ViewParent;

    move-result-object v1

    .local v1, parent:Landroid/view/ViewParent;
    :goto_4
    instance-of v3, v1, Landroid/view/View;

    if-eqz v3, :cond_21

    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v3

    const/16 v4, 0x32

    if-ge v3, v4, :cond_21

    move-object v2, v1

    check-cast v2, Landroid/view/View;

    .local v2, parentView:Landroid/view/View;
    invoke-virtual {v2}, Landroid/view/View;->createAccessibilityNodeInfo()Landroid/view/accessibility/AccessibilityNodeInfo;

    move-result-object v0

    .local v0, info:Landroid/view/accessibility/AccessibilityNodeInfo;
    if-eqz v0, :cond_1c

    invoke-interface {p2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_1c
    invoke-interface {v1}, Landroid/view/ViewParent;->getParentForAccessibility()Landroid/view/ViewParent;

    move-result-object v1

    goto :goto_4

    .end local v0           #info:Landroid/view/accessibility/AccessibilityNodeInfo;
    .end local v2           #parentView:Landroid/view/View;
    :cond_21
    return-void
.end method

.method private prefetchPredecessorsOfVirtualNode(Landroid/view/accessibility/AccessibilityNodeInfo;Landroid/view/View;Landroid/view/accessibility/AccessibilityNodeProvider;Ljava/util/List;)V
    .registers 13
    .parameter "root"
    .parameter "providerHost"
    .parameter "provider"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/accessibility/AccessibilityNodeInfo;",
            "Landroid/view/View;",
            "Landroid/view/accessibility/AccessibilityNodeProvider;",
            "Ljava/util/List",
            "<",
            "Landroid/view/accessibility/AccessibilityNodeInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p4, outInfos:Ljava/util/List;,"Ljava/util/List<Landroid/view/accessibility/AccessibilityNodeInfo;>;"
    const/4 v7, -0x1

    invoke-virtual {p1}, Landroid/view/accessibility/AccessibilityNodeInfo;->getParentNodeId()J

    move-result-wide v2

    .local v2, parentNodeId:J
    invoke-static {v2, v3}, Landroid/view/accessibility/AccessibilityNodeInfo;->getAccessibilityViewId(J)I

    move-result v0

    .local v0, accessibilityViewId:I
    :goto_9
    if-eq v0, v7, :cond_13

    invoke-interface {p4}, Ljava/util/List;->size()I

    move-result v5

    const/16 v6, 0x32

    if-lt v5, v6, :cond_14

    :cond_13
    :goto_13
    return-void

    :cond_14
    invoke-static {v2, v3}, Landroid/view/accessibility/AccessibilityNodeInfo;->getVirtualDescendantId(J)I

    move-result v4

    .local v4, virtualDescendantId:I
    if-ne v4, v7, :cond_20

    invoke-virtual {p2}, Landroid/view/View;->getAccessibilityViewId()I

    move-result v5

    if-ne v0, v5, :cond_32

    :cond_20
    invoke-virtual {p3, v4}, Landroid/view/accessibility/AccessibilityNodeProvider;->createAccessibilityNodeInfo(I)Landroid/view/accessibility/AccessibilityNodeInfo;

    move-result-object v1

    .local v1, parent:Landroid/view/accessibility/AccessibilityNodeInfo;
    if-eqz v1, :cond_29

    invoke-interface {p4, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_29
    invoke-virtual {v1}, Landroid/view/accessibility/AccessibilityNodeInfo;->getParentNodeId()J

    move-result-wide v2

    invoke-static {v2, v3}, Landroid/view/accessibility/AccessibilityNodeInfo;->getAccessibilityViewId(J)I

    move-result v0

    goto :goto_9

    .end local v1           #parent:Landroid/view/accessibility/AccessibilityNodeInfo;
    :cond_32
    invoke-direct {p0, p2, p4}, Landroid/view/AccessibilityInteractionController$AccessibilityNodePrefetcher;->prefetchPredecessorsOfRealNode(Landroid/view/View;Ljava/util/List;)V

    goto :goto_13
.end method

.method private prefetchSiblingsOfRealNode(Landroid/view/View;Ljava/util/List;)V
    .registers 13
    .parameter "current"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/View;",
            "Ljava/util/List",
            "<",
            "Landroid/view/accessibility/AccessibilityNodeInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p2, outInfos:Ljava/util/List;,"Ljava/util/List<Landroid/view/accessibility/AccessibilityNodeInfo;>;"
    invoke-virtual {p1}, Landroid/view/View;->getParentForAccessibility()Landroid/view/ViewParent;

    move-result-object v5

    .local v5, parent:Landroid/view/ViewParent;
    instance-of v8, v5, Landroid/view/ViewGroup;

    if-eqz v8, :cond_25

    move-object v6, v5

    check-cast v6, Landroid/view/ViewGroup;

    .local v6, parentGroup:Landroid/view/ViewGroup;
    iget-object v2, p0, Landroid/view/AccessibilityInteractionController$AccessibilityNodePrefetcher;->mTempViewList:Ljava/util/ArrayList;

    .local v2, children:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/view/View;>;"
    invoke-virtual {v2}, Ljava/util/ArrayList;->clear()V

    :try_start_10
    invoke-virtual {v6, v2}, Landroid/view/ViewGroup;->addChildrenForAccessibility(Ljava/util/ArrayList;)V

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v1

    .local v1, childCount:I
    const/4 v3, 0x0

    .local v3, i:I
    :goto_18
    if-ge v3, v1, :cond_22

    invoke-interface {p2}, Ljava/util/List;->size()I
    :try_end_1d
    .catchall {:try_start_10 .. :try_end_1d} :catchall_57

    move-result v8

    const/16 v9, 0x32

    if-lt v8, v9, :cond_26

    :cond_22
    invoke-virtual {v2}, Ljava/util/ArrayList;->clear()V

    .end local v1           #childCount:I
    .end local v2           #children:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/view/View;>;"
    .end local v3           #i:I
    .end local v6           #parentGroup:Landroid/view/ViewGroup;
    :cond_25
    return-void

    .restart local v1       #childCount:I
    .restart local v2       #children:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/view/View;>;"
    .restart local v3       #i:I
    .restart local v6       #parentGroup:Landroid/view/ViewGroup;
    :cond_26
    :try_start_26
    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    .local v0, child:Landroid/view/View;
    invoke-virtual {v0}, Landroid/view/View;->getAccessibilityViewId()I

    move-result v8

    invoke-virtual {p1}, Landroid/view/View;->getAccessibilityViewId()I

    move-result v9

    if-eq v8, v9, :cond_4e

    iget-object v8, p0, Landroid/view/AccessibilityInteractionController$AccessibilityNodePrefetcher;->this$0:Landroid/view/AccessibilityInteractionController;

    #calls: Landroid/view/AccessibilityInteractionController;->isShown(Landroid/view/View;)Z
    invoke-static {v8, v0}, Landroid/view/AccessibilityInteractionController;->access$300(Landroid/view/AccessibilityInteractionController;Landroid/view/View;)Z

    move-result v8

    if-eqz v8, :cond_4e

    const/4 v4, 0x0

    .local v4, info:Landroid/view/accessibility/AccessibilityNodeInfo;
    invoke-virtual {v0}, Landroid/view/View;->getAccessibilityNodeProvider()Landroid/view/accessibility/AccessibilityNodeProvider;

    move-result-object v7

    .local v7, provider:Landroid/view/accessibility/AccessibilityNodeProvider;
    if-nez v7, :cond_51

    invoke-virtual {v0}, Landroid/view/View;->createAccessibilityNodeInfo()Landroid/view/accessibility/AccessibilityNodeInfo;

    move-result-object v4

    :goto_49
    if-eqz v4, :cond_4e

    invoke-interface {p2, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .end local v4           #info:Landroid/view/accessibility/AccessibilityNodeInfo;
    .end local v7           #provider:Landroid/view/accessibility/AccessibilityNodeProvider;
    :cond_4e
    add-int/lit8 v3, v3, 0x1

    goto :goto_18

    .restart local v4       #info:Landroid/view/accessibility/AccessibilityNodeInfo;
    .restart local v7       #provider:Landroid/view/accessibility/AccessibilityNodeProvider;
    :cond_51
    const/4 v8, -0x1

    invoke-virtual {v7, v8}, Landroid/view/accessibility/AccessibilityNodeProvider;->createAccessibilityNodeInfo(I)Landroid/view/accessibility/AccessibilityNodeInfo;
    :try_end_55
    .catchall {:try_start_26 .. :try_end_55} :catchall_57

    move-result-object v4

    goto :goto_49

    .end local v0           #child:Landroid/view/View;
    .end local v1           #childCount:I
    .end local v3           #i:I
    .end local v4           #info:Landroid/view/accessibility/AccessibilityNodeInfo;
    .end local v7           #provider:Landroid/view/accessibility/AccessibilityNodeProvider;
    :catchall_57
    move-exception v8

    invoke-virtual {v2}, Ljava/util/ArrayList;->clear()V

    throw v8
.end method

.method private prefetchSiblingsOfVirtualNode(Landroid/view/accessibility/AccessibilityNodeInfo;Landroid/view/View;Landroid/view/accessibility/AccessibilityNodeProvider;Ljava/util/List;)V
    .registers 22
    .parameter "current"
    .parameter "providerHost"
    .parameter "provider"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/accessibility/AccessibilityNodeInfo;",
            "Landroid/view/View;",
            "Landroid/view/accessibility/AccessibilityNodeProvider;",
            "Ljava/util/List",
            "<",
            "Landroid/view/accessibility/AccessibilityNodeInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p4, outInfos:Ljava/util/List;,"Ljava/util/List<Landroid/view/accessibility/AccessibilityNodeInfo;>;"
    invoke-virtual/range {p1 .. p1}, Landroid/view/accessibility/AccessibilityNodeInfo;->getParentNodeId()J

    move-result-wide v12

    .local v12, parentNodeId:J
    invoke-static {v12, v13}, Landroid/view/accessibility/AccessibilityNodeInfo;->getAccessibilityViewId(J)I

    move-result v11

    .local v11, parentAccessibilityViewId:I
    invoke-static {v12, v13}, Landroid/view/accessibility/AccessibilityNodeInfo;->getVirtualDescendantId(J)I

    move-result v14

    .local v14, parentVirtualDescendantId:I
    const/4 v15, -0x1

    if-ne v14, v15, :cond_15

    invoke-virtual/range {p2 .. p2}, Landroid/view/View;->getAccessibilityViewId()I

    move-result v15

    if-ne v11, v15, :cond_53

    :cond_15
    move-object/from16 v0, p3

    invoke-virtual {v0, v14}, Landroid/view/accessibility/AccessibilityNodeProvider;->createAccessibilityNodeInfo(I)Landroid/view/accessibility/AccessibilityNodeInfo;

    move-result-object v10

    .local v10, parent:Landroid/view/accessibility/AccessibilityNodeInfo;
    if-eqz v10, :cond_32

    invoke-virtual {v10}, Landroid/view/accessibility/AccessibilityNodeInfo;->getChildNodeIds()Landroid/util/SparseLongArray;

    move-result-object v7

    .local v7, childNodeIds:Landroid/util/SparseLongArray;
    invoke-virtual {v7}, Landroid/util/SparseLongArray;->size()I

    move-result v4

    .local v4, childCount:I
    const/4 v9, 0x0

    .local v9, i:I
    :goto_26
    if-ge v9, v4, :cond_32

    invoke-interface/range {p4 .. p4}, Ljava/util/List;->size()I

    move-result v15

    const/16 v16, 0x32

    move/from16 v0, v16

    if-lt v15, v0, :cond_33

    .end local v4           #childCount:I
    .end local v7           #childNodeIds:Landroid/util/SparseLongArray;
    .end local v9           #i:I
    .end local v10           #parent:Landroid/view/accessibility/AccessibilityNodeInfo;
    :cond_32
    :goto_32
    return-void

    .restart local v4       #childCount:I
    .restart local v7       #childNodeIds:Landroid/util/SparseLongArray;
    .restart local v9       #i:I
    .restart local v10       #parent:Landroid/view/accessibility/AccessibilityNodeInfo;
    :cond_33
    invoke-virtual {v7, v9}, Landroid/util/SparseLongArray;->get(I)J

    move-result-wide v5

    .local v5, childNodeId:J
    invoke-virtual/range {p1 .. p1}, Landroid/view/accessibility/AccessibilityNodeInfo;->getSourceNodeId()J

    move-result-wide v15

    cmp-long v15, v5, v15

    if-eqz v15, :cond_50

    invoke-static {v5, v6}, Landroid/view/accessibility/AccessibilityNodeInfo;->getVirtualDescendantId(J)I

    move-result v8

    .local v8, childVirtualDescendantId:I
    move-object/from16 v0, p3

    invoke-virtual {v0, v8}, Landroid/view/accessibility/AccessibilityNodeProvider;->createAccessibilityNodeInfo(I)Landroid/view/accessibility/AccessibilityNodeInfo;

    move-result-object v3

    .local v3, child:Landroid/view/accessibility/AccessibilityNodeInfo;
    if-eqz v3, :cond_50

    move-object/from16 v0, p4

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .end local v3           #child:Landroid/view/accessibility/AccessibilityNodeInfo;
    .end local v8           #childVirtualDescendantId:I
    :cond_50
    add-int/lit8 v9, v9, 0x1

    goto :goto_26

    .end local v4           #childCount:I
    .end local v5           #childNodeId:J
    .end local v7           #childNodeIds:Landroid/util/SparseLongArray;
    .end local v9           #i:I
    .end local v10           #parent:Landroid/view/accessibility/AccessibilityNodeInfo;
    :cond_53
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    move-object/from16 v2, p4

    invoke-direct {v0, v1, v2}, Landroid/view/AccessibilityInteractionController$AccessibilityNodePrefetcher;->prefetchSiblingsOfRealNode(Landroid/view/View;Ljava/util/List;)V

    goto :goto_32
.end method


# virtual methods
.method public prefetchAccessibilityNodeInfos(Landroid/view/View;IILjava/util/List;)V
    .registers 8
    .parameter "view"
    .parameter "virtualViewId"
    .parameter "prefetchFlags"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/View;",
            "II",
            "Ljava/util/List",
            "<",
            "Landroid/view/accessibility/AccessibilityNodeInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p4, outInfos:Ljava/util/List;,"Ljava/util/List<Landroid/view/accessibility/AccessibilityNodeInfo;>;"
    invoke-virtual {p1}, Landroid/view/View;->getAccessibilityNodeProvider()Landroid/view/accessibility/AccessibilityNodeProvider;

    move-result-object v0

    .local v0, provider:Landroid/view/accessibility/AccessibilityNodeProvider;
    if-nez v0, :cond_25

    invoke-virtual {p1}, Landroid/view/View;->createAccessibilityNodeInfo()Landroid/view/accessibility/AccessibilityNodeInfo;

    move-result-object v1

    .local v1, root:Landroid/view/accessibility/AccessibilityNodeInfo;
    if-eqz v1, :cond_24

    invoke-interface {p4, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    and-int/lit8 v2, p3, 0x1

    if-eqz v2, :cond_16

    invoke-direct {p0, p1, p4}, Landroid/view/AccessibilityInteractionController$AccessibilityNodePrefetcher;->prefetchPredecessorsOfRealNode(Landroid/view/View;Ljava/util/List;)V

    :cond_16
    and-int/lit8 v2, p3, 0x2

    if-eqz v2, :cond_1d

    invoke-direct {p0, p1, p4}, Landroid/view/AccessibilityInteractionController$AccessibilityNodePrefetcher;->prefetchSiblingsOfRealNode(Landroid/view/View;Ljava/util/List;)V

    :cond_1d
    and-int/lit8 v2, p3, 0x4

    if-eqz v2, :cond_24

    invoke-direct {p0, p1, p4}, Landroid/view/AccessibilityInteractionController$AccessibilityNodePrefetcher;->prefetchDescendantsOfRealNode(Landroid/view/View;Ljava/util/List;)V

    :cond_24
    :goto_24
    return-void

    .end local v1           #root:Landroid/view/accessibility/AccessibilityNodeInfo;
    :cond_25
    invoke-virtual {v0, p2}, Landroid/view/accessibility/AccessibilityNodeProvider;->createAccessibilityNodeInfo(I)Landroid/view/accessibility/AccessibilityNodeInfo;

    move-result-object v1

    .restart local v1       #root:Landroid/view/accessibility/AccessibilityNodeInfo;
    if-eqz v1, :cond_24

    invoke-interface {p4, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    and-int/lit8 v2, p3, 0x1

    if-eqz v2, :cond_35

    invoke-direct {p0, v1, p1, v0, p4}, Landroid/view/AccessibilityInteractionController$AccessibilityNodePrefetcher;->prefetchPredecessorsOfVirtualNode(Landroid/view/accessibility/AccessibilityNodeInfo;Landroid/view/View;Landroid/view/accessibility/AccessibilityNodeProvider;Ljava/util/List;)V

    :cond_35
    and-int/lit8 v2, p3, 0x2

    if-eqz v2, :cond_3c

    invoke-direct {p0, v1, p1, v0, p4}, Landroid/view/AccessibilityInteractionController$AccessibilityNodePrefetcher;->prefetchSiblingsOfVirtualNode(Landroid/view/accessibility/AccessibilityNodeInfo;Landroid/view/View;Landroid/view/accessibility/AccessibilityNodeProvider;Ljava/util/List;)V

    :cond_3c
    and-int/lit8 v2, p3, 0x4

    if-eqz v2, :cond_24

    invoke-direct {p0, v1, v0, p4}, Landroid/view/AccessibilityInteractionController$AccessibilityNodePrefetcher;->prefetchDescendantsOfVirtualNode(Landroid/view/accessibility/AccessibilityNodeInfo;Landroid/view/accessibility/AccessibilityNodeProvider;Ljava/util/List;)V

    goto :goto_24
.end method
