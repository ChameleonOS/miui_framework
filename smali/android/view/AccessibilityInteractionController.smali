.class final Landroid/view/AccessibilityInteractionController;
.super Ljava/lang/Object;
.source "AccessibilityInteractionController.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/view/AccessibilityInteractionController$PrivateHandler;,
        Landroid/view/AccessibilityInteractionController$AccessibilityNodePrefetcher;,
        Landroid/view/AccessibilityInteractionController$SomeArgs;
    }
.end annotation


# static fields
.field private static final POOL_SIZE:I = 0x5


# instance fields
.field private final mHandler:Landroid/os/Handler;

.field private final mMyLooperThreadId:J

.field private final mMyProcessId:I

.field private final mPool:Landroid/util/Pool;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/Pool",
            "<",
            "Landroid/view/AccessibilityInteractionController$SomeArgs;",
            ">;"
        }
    .end annotation
.end field

.field private final mPrefetcher:Landroid/view/AccessibilityInteractionController$AccessibilityNodePrefetcher;

.field private mTempAccessibilityNodeInfoList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/view/accessibility/AccessibilityNodeInfo;",
            ">;"
        }
    .end annotation
.end field

.field private final mTempArrayList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end field

.field private final mViewRootImpl:Landroid/view/ViewRootImpl;


# direct methods
.method public constructor <init>(Landroid/view/ViewRootImpl;)V
    .registers 5
    .parameter "viewRootImpl"

    .prologue
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Landroid/view/AccessibilityInteractionController;->mTempAccessibilityNodeInfoList:Ljava/util/ArrayList;

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Landroid/view/AccessibilityInteractionController;->mTempArrayList:Ljava/util/ArrayList;

    new-instance v1, Landroid/view/AccessibilityInteractionController$1;

    invoke-direct {v1, p0}, Landroid/view/AccessibilityInteractionController$1;-><init>(Landroid/view/AccessibilityInteractionController;)V

    const/4 v2, 0x5

    invoke-static {v1, v2}, Landroid/util/Pools;->finitePool(Landroid/util/PoolableManager;I)Landroid/util/Pool;

    move-result-object v1

    invoke-static {v1}, Landroid/util/Pools;->synchronizedPool(Landroid/util/Pool;)Landroid/util/Pool;

    move-result-object v1

    iput-object v1, p0, Landroid/view/AccessibilityInteractionController;->mPool:Landroid/util/Pool;

    iget-object v1, p1, Landroid/view/ViewRootImpl;->mHandler:Landroid/view/ViewRootImpl$ViewRootHandler;

    invoke-virtual {v1}, Landroid/view/ViewRootImpl$ViewRootHandler;->getLooper()Landroid/os/Looper;

    move-result-object v0

    .local v0, looper:Landroid/os/Looper;
    invoke-virtual {v0}, Landroid/os/Looper;->getThread()Ljava/lang/Thread;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Thread;->getId()J

    move-result-wide v1

    iput-wide v1, p0, Landroid/view/AccessibilityInteractionController;->mMyLooperThreadId:J

    invoke-static {}, Landroid/os/Process;->myPid()I

    move-result v1

    iput v1, p0, Landroid/view/AccessibilityInteractionController;->mMyProcessId:I

    new-instance v1, Landroid/view/AccessibilityInteractionController$PrivateHandler;

    invoke-direct {v1, p0, v0}, Landroid/view/AccessibilityInteractionController$PrivateHandler;-><init>(Landroid/view/AccessibilityInteractionController;Landroid/os/Looper;)V

    iput-object v1, p0, Landroid/view/AccessibilityInteractionController;->mHandler:Landroid/os/Handler;

    iput-object p1, p0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    new-instance v1, Landroid/view/AccessibilityInteractionController$AccessibilityNodePrefetcher;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Landroid/view/AccessibilityInteractionController$AccessibilityNodePrefetcher;-><init>(Landroid/view/AccessibilityInteractionController;Landroid/view/AccessibilityInteractionController$1;)V

    iput-object v1, p0, Landroid/view/AccessibilityInteractionController;->mPrefetcher:Landroid/view/AccessibilityInteractionController$AccessibilityNodePrefetcher;

    return-void
.end method

.method static synthetic access$300(Landroid/view/AccessibilityInteractionController;Landroid/view/View;)Z
    .registers 3
    .parameter "x0"
    .parameter "x1"

    .prologue
    invoke-direct {p0, p1}, Landroid/view/AccessibilityInteractionController;->isShown(Landroid/view/View;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$400(Landroid/view/AccessibilityInteractionController;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    invoke-direct {p0, p1}, Landroid/view/AccessibilityInteractionController;->findAccessibilityNodeInfoByAccessibilityIdUiThread(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$500(Landroid/view/AccessibilityInteractionController;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    invoke-direct {p0, p1}, Landroid/view/AccessibilityInteractionController;->perfromAccessibilityActionUiThread(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$600(Landroid/view/AccessibilityInteractionController;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    invoke-direct {p0, p1}, Landroid/view/AccessibilityInteractionController;->findAccessibilityNodeInfoByViewIdUiThread(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$700(Landroid/view/AccessibilityInteractionController;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    invoke-direct {p0, p1}, Landroid/view/AccessibilityInteractionController;->findAccessibilityNodeInfosByTextUiThread(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$800(Landroid/view/AccessibilityInteractionController;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    invoke-direct {p0, p1}, Landroid/view/AccessibilityInteractionController;->findFocusUiThread(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$900(Landroid/view/AccessibilityInteractionController;Landroid/os/Message;)V
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    invoke-direct {p0, p1}, Landroid/view/AccessibilityInteractionController;->focusSearchUiThread(Landroid/os/Message;)V

    return-void
.end method

.method private findAccessibilityNodeInfoByAccessibilityIdUiThread(Landroid/os/Message;)V
    .registers 14
    .parameter "message"

    .prologue
    const/4 v9, 0x0

    iget v3, p1, Landroid/os/Message;->arg1:I

    .local v3, flags:I
    iget-object v1, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v1, Landroid/view/AccessibilityInteractionController$SomeArgs;

    .local v1, args:Landroid/view/AccessibilityInteractionController$SomeArgs;
    iget v0, v1, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi1:I

    .local v0, accessibilityViewId:I
    iget v8, v1, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi2:I

    .local v8, virtualDescendantId:I
    iget v5, v1, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi3:I

    .local v5, interactionId:I
    iget-object v2, v1, Landroid/view/AccessibilityInteractionController$SomeArgs;->arg1:Ljava/lang/Object;

    check-cast v2, Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback;

    .local v2, callback:Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback;
    iget-object v6, v1, Landroid/view/AccessibilityInteractionController$SomeArgs;->arg2:Ljava/lang/Object;

    check-cast v6, Landroid/view/AccessibilityInteractionController$SomeArgs;

    .local v6, moreArgs:Landroid/view/AccessibilityInteractionController$SomeArgs;
    iget-object v10, p0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v10, v10, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;

    iget v11, v6, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi1:I

    iput v11, v10, Landroid/view/View$AttachInfo;->mActualWindowLeft:I

    iget-object v10, p0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v10, v10, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;

    iget v11, v6, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi2:I

    iput v11, v10, Landroid/view/View$AttachInfo;->mActualWindowTop:I

    iget-object v10, p0, Landroid/view/AccessibilityInteractionController;->mPool:Landroid/util/Pool;

    invoke-interface {v10, v6}, Landroid/util/Pool;->release(Landroid/util/Poolable;)V

    iget-object v10, p0, Landroid/view/AccessibilityInteractionController;->mPool:Landroid/util/Pool;

    invoke-interface {v10, v1}, Landroid/util/Pool;->release(Landroid/util/Poolable;)V

    iget-object v4, p0, Landroid/view/AccessibilityInteractionController;->mTempAccessibilityNodeInfoList:Ljava/util/ArrayList;

    .local v4, infos:Ljava/util/List;,"Ljava/util/List<Landroid/view/accessibility/AccessibilityNodeInfo;>;"
    invoke-interface {v4}, Ljava/util/List;->clear()V

    :try_start_34
    iget-object v10, p0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v10, v10, Landroid/view/ViewRootImpl;->mView:Landroid/view/View;

    if-eqz v10, :cond_40

    iget-object v10, p0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v10, v10, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;
    :try_end_3e
    .catchall {:try_start_34 .. :try_end_3e} :catchall_83

    if-nez v10, :cond_4e

    :cond_40
    :try_start_40
    iget-object v9, p0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v9, v9, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;

    const/4 v10, 0x0

    iput-boolean v10, v9, Landroid/view/View$AttachInfo;->mIncludeNotImportantViews:Z

    invoke-interface {v2, v4, v5}, Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback;->setFindAccessibilityNodeInfosResult(Ljava/util/List;I)V

    invoke-interface {v4}, Ljava/util/List;->clear()V
    :try_end_4d
    .catch Landroid/os/RemoteException; {:try_start_40 .. :try_end_4d} :catch_7c

    :goto_4d
    return-void

    :cond_4e
    :try_start_4e
    iget-object v10, p0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v10, v10, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;

    and-int/lit8 v11, v3, 0x8

    if-eqz v11, :cond_57

    const/4 v9, 0x1

    :cond_57
    iput-boolean v9, v10, Landroid/view/View$AttachInfo;->mIncludeNotImportantViews:Z

    const/4 v7, 0x0

    .local v7, root:Landroid/view/View;
    const/4 v9, -0x1

    if-ne v0, v9, :cond_7e

    iget-object v9, p0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v7, v9, Landroid/view/ViewRootImpl;->mView:Landroid/view/View;

    :goto_61
    if-eqz v7, :cond_6e

    invoke-direct {p0, v7}, Landroid/view/AccessibilityInteractionController;->isShown(Landroid/view/View;)Z

    move-result v9

    if-eqz v9, :cond_6e

    iget-object v9, p0, Landroid/view/AccessibilityInteractionController;->mPrefetcher:Landroid/view/AccessibilityInteractionController$AccessibilityNodePrefetcher;

    invoke-virtual {v9, v7, v8, v3, v4}, Landroid/view/AccessibilityInteractionController$AccessibilityNodePrefetcher;->prefetchAccessibilityNodeInfos(Landroid/view/View;IILjava/util/List;)V
    :try_end_6e
    .catchall {:try_start_4e .. :try_end_6e} :catchall_83

    :cond_6e
    :try_start_6e
    iget-object v9, p0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v9, v9, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;

    const/4 v10, 0x0

    iput-boolean v10, v9, Landroid/view/View$AttachInfo;->mIncludeNotImportantViews:Z

    invoke-interface {v2, v4, v5}, Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback;->setFindAccessibilityNodeInfosResult(Ljava/util/List;I)V

    invoke-interface {v4}, Ljava/util/List;->clear()V
    :try_end_7b
    .catch Landroid/os/RemoteException; {:try_start_6e .. :try_end_7b} :catch_7c

    goto :goto_4d

    .end local v7           #root:Landroid/view/View;
    :catch_7c
    move-exception v9

    goto :goto_4d

    .restart local v7       #root:Landroid/view/View;
    :cond_7e
    :try_start_7e
    invoke-direct {p0, v0}, Landroid/view/AccessibilityInteractionController;->findViewByAccessibilityId(I)Landroid/view/View;
    :try_end_81
    .catchall {:try_start_7e .. :try_end_81} :catchall_83

    move-result-object v7

    goto :goto_61

    .end local v7           #root:Landroid/view/View;
    :catchall_83
    move-exception v9

    :try_start_84
    iget-object v10, p0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v10, v10, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;

    const/4 v11, 0x0

    iput-boolean v11, v10, Landroid/view/View$AttachInfo;->mIncludeNotImportantViews:Z

    invoke-interface {v2, v4, v5}, Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback;->setFindAccessibilityNodeInfosResult(Ljava/util/List;I)V

    invoke-interface {v4}, Ljava/util/List;->clear()V
    :try_end_91
    .catch Landroid/os/RemoteException; {:try_start_84 .. :try_end_91} :catch_92

    :goto_91
    throw v9

    :catch_92
    move-exception v10

    goto :goto_91
.end method

.method private findAccessibilityNodeInfoByViewIdUiThread(Landroid/os/Message;)V
    .registers 15
    .parameter "message"

    .prologue
    const/4 v10, 0x0

    iget v3, p1, Landroid/os/Message;->arg1:I

    .local v3, flags:I
    iget v0, p1, Landroid/os/Message;->arg2:I

    .local v0, accessibilityViewId:I
    iget-object v1, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v1, Landroid/view/AccessibilityInteractionController$SomeArgs;

    .local v1, args:Landroid/view/AccessibilityInteractionController$SomeArgs;
    iget v9, v1, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi1:I

    .local v9, viewId:I
    iget v5, v1, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi2:I

    .local v5, interactionId:I
    iget-object v2, v1, Landroid/view/AccessibilityInteractionController$SomeArgs;->arg1:Ljava/lang/Object;

    check-cast v2, Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback;

    .local v2, callback:Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback;
    iget-object v6, v1, Landroid/view/AccessibilityInteractionController$SomeArgs;->arg2:Ljava/lang/Object;

    check-cast v6, Landroid/view/AccessibilityInteractionController$SomeArgs;

    .local v6, moreArgs:Landroid/view/AccessibilityInteractionController$SomeArgs;
    iget-object v11, p0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v11, v11, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;

    iget v12, v6, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi1:I

    iput v12, v11, Landroid/view/View$AttachInfo;->mActualWindowLeft:I

    iget-object v11, p0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v11, v11, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;

    iget v12, v6, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi2:I

    iput v12, v11, Landroid/view/View$AttachInfo;->mActualWindowTop:I

    iget-object v11, p0, Landroid/view/AccessibilityInteractionController;->mPool:Landroid/util/Pool;

    invoke-interface {v11, v6}, Landroid/util/Pool;->release(Landroid/util/Poolable;)V

    iget-object v11, p0, Landroid/view/AccessibilityInteractionController;->mPool:Landroid/util/Pool;

    invoke-interface {v11, v1}, Landroid/util/Pool;->release(Landroid/util/Poolable;)V

    const/4 v4, 0x0

    .local v4, info:Landroid/view/accessibility/AccessibilityNodeInfo;
    :try_start_30
    iget-object v11, p0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v11, v11, Landroid/view/ViewRootImpl;->mView:Landroid/view/View;

    if-eqz v11, :cond_3c

    iget-object v11, p0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v11, v11, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;
    :try_end_3a
    .catchall {:try_start_30 .. :try_end_3a} :catchall_7e

    if-nez v11, :cond_47

    :cond_3c
    :try_start_3c
    iget-object v10, p0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v10, v10, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;

    const/4 v11, 0x0

    iput-boolean v11, v10, Landroid/view/View$AttachInfo;->mIncludeNotImportantViews:Z

    invoke-interface {v2, v4, v5}, Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback;->setFindAccessibilityNodeInfoResult(Landroid/view/accessibility/AccessibilityNodeInfo;I)V
    :try_end_46
    .catch Landroid/os/RemoteException; {:try_start_3c .. :try_end_46} :catch_77

    :goto_46
    return-void

    :cond_47
    :try_start_47
    iget-object v11, p0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v11, v11, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;

    and-int/lit8 v12, v3, 0x8

    if-eqz v12, :cond_50

    const/4 v10, 0x1

    :cond_50
    iput-boolean v10, v11, Landroid/view/View$AttachInfo;->mIncludeNotImportantViews:Z

    const/4 v7, 0x0

    .local v7, root:Landroid/view/View;
    const/4 v10, -0x1

    if-eq v0, v10, :cond_79

    invoke-direct {p0, v0}, Landroid/view/AccessibilityInteractionController;->findViewByAccessibilityId(I)Landroid/view/View;

    move-result-object v7

    :goto_5a
    if-eqz v7, :cond_6c

    invoke-virtual {v7, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    .local v8, target:Landroid/view/View;
    if-eqz v8, :cond_6c

    invoke-direct {p0, v8}, Landroid/view/AccessibilityInteractionController;->isShown(Landroid/view/View;)Z

    move-result v10

    if-eqz v10, :cond_6c

    invoke-virtual {v8}, Landroid/view/View;->createAccessibilityNodeInfo()Landroid/view/accessibility/AccessibilityNodeInfo;
    :try_end_6b
    .catchall {:try_start_47 .. :try_end_6b} :catchall_7e

    move-result-object v4

    .end local v8           #target:Landroid/view/View;
    :cond_6c
    :try_start_6c
    iget-object v10, p0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v10, v10, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;

    const/4 v11, 0x0

    iput-boolean v11, v10, Landroid/view/View$AttachInfo;->mIncludeNotImportantViews:Z

    invoke-interface {v2, v4, v5}, Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback;->setFindAccessibilityNodeInfoResult(Landroid/view/accessibility/AccessibilityNodeInfo;I)V
    :try_end_76
    .catch Landroid/os/RemoteException; {:try_start_6c .. :try_end_76} :catch_77

    goto :goto_46

    .end local v7           #root:Landroid/view/View;
    :catch_77
    move-exception v10

    goto :goto_46

    .restart local v7       #root:Landroid/view/View;
    :cond_79
    :try_start_79
    iget-object v10, p0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v7, v10, Landroid/view/ViewRootImpl;->mView:Landroid/view/View;
    :try_end_7d
    .catchall {:try_start_79 .. :try_end_7d} :catchall_7e

    goto :goto_5a

    .end local v7           #root:Landroid/view/View;
    :catchall_7e
    move-exception v10

    :try_start_7f
    iget-object v11, p0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v11, v11, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;

    const/4 v12, 0x0

    iput-boolean v12, v11, Landroid/view/View$AttachInfo;->mIncludeNotImportantViews:Z

    invoke-interface {v2, v4, v5}, Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback;->setFindAccessibilityNodeInfoResult(Landroid/view/accessibility/AccessibilityNodeInfo;I)V
    :try_end_89
    .catch Landroid/os/RemoteException; {:try_start_7f .. :try_end_89} :catch_8a

    :goto_89
    throw v10

    :catch_8a
    move-exception v11

    goto :goto_89
.end method

.method private findAccessibilityNodeInfosByTextUiThread(Landroid/os/Message;)V
    .registers 23
    .parameter "message"

    .prologue
    move-object/from16 v0, p1

    iget v5, v0, Landroid/os/Message;->arg1:I

    .local v5, flags:I
    move-object/from16 v0, p1

    iget-object v3, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v3, Landroid/view/AccessibilityInteractionController$SomeArgs;

    .local v3, args:Landroid/view/AccessibilityInteractionController$SomeArgs;
    iget-object v15, v3, Landroid/view/AccessibilityInteractionController$SomeArgs;->arg1:Ljava/lang/Object;

    check-cast v15, Ljava/lang/String;

    .local v15, text:Ljava/lang/String;
    iget v2, v3, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi1:I

    .local v2, accessibilityViewId:I
    iget v0, v3, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi2:I

    move/from16 v17, v0

    .local v17, virtualDescendantId:I
    iget v11, v3, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi3:I

    .local v11, interactionId:I
    iget-object v12, v3, Landroid/view/AccessibilityInteractionController$SomeArgs;->arg2:Ljava/lang/Object;

    check-cast v12, Landroid/view/AccessibilityInteractionController$SomeArgs;

    .local v12, moreArgs:Landroid/view/AccessibilityInteractionController$SomeArgs;
    iget-object v4, v12, Landroid/view/AccessibilityInteractionController$SomeArgs;->arg1:Ljava/lang/Object;

    check-cast v4, Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback;

    .local v4, callback:Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback;
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    iget-object v0, v0, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;

    move-object/from16 v18, v0

    iget v0, v12, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi1:I

    move/from16 v19, v0

    move/from16 v0, v19

    move-object/from16 v1, v18

    iput v0, v1, Landroid/view/View$AttachInfo;->mActualWindowLeft:I

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    iget-object v0, v0, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;

    move-object/from16 v18, v0

    iget v0, v12, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi2:I

    move/from16 v19, v0

    move/from16 v0, v19

    move-object/from16 v1, v18

    iput v0, v1, Landroid/view/View$AttachInfo;->mActualWindowTop:I

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/AccessibilityInteractionController;->mPool:Landroid/util/Pool;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    invoke-interface {v0, v12}, Landroid/util/Pool;->release(Landroid/util/Poolable;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/AccessibilityInteractionController;->mPool:Landroid/util/Pool;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    invoke-interface {v0, v3}, Landroid/util/Pool;->release(Landroid/util/Poolable;)V

    const/4 v9, 0x0

    .local v9, infos:Ljava/util/List;,"Ljava/util/List<Landroid/view/accessibility/AccessibilityNodeInfo;>;"
    :try_start_61
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    iget-object v0, v0, Landroid/view/ViewRootImpl;->mView:Landroid/view/View;

    move-object/from16 v18, v0

    if-eqz v18, :cond_7d

    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    iget-object v0, v0, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;

    move-object/from16 v18, v0
    :try_end_7b
    .catchall {:try_start_61 .. :try_end_7b} :catchall_152

    if-nez v18, :cond_95

    :cond_7d
    :try_start_7d
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    iget-object v0, v0, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;

    move-object/from16 v18, v0

    const/16 v19, 0x0

    move/from16 v0, v19

    move-object/from16 v1, v18

    iput-boolean v0, v1, Landroid/view/View$AttachInfo;->mIncludeNotImportantViews:Z

    invoke-interface {v4, v9, v11}, Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback;->setFindAccessibilityNodeInfosResult(Ljava/util/List;I)V
    :try_end_94
    .catch Landroid/os/RemoteException; {:try_start_7d .. :try_end_94} :catch_e8

    :goto_94
    return-void

    :cond_95
    :try_start_95
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    iget-object v0, v0, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;

    move-object/from16 v19, v0

    and-int/lit8 v18, v5, 0x8

    if-eqz v18, :cond_ea

    const/16 v18, 0x1

    :goto_a7
    move/from16 v0, v18

    move-object/from16 v1, v19

    iput-boolean v0, v1, Landroid/view/View$AttachInfo;->mIncludeNotImportantViews:Z

    const/4 v14, 0x0

    .local v14, root:Landroid/view/View;
    const/16 v18, -0x1

    move/from16 v0, v18

    if-eq v2, v0, :cond_ed

    move-object/from16 v0, p0

    invoke-direct {v0, v2}, Landroid/view/AccessibilityInteractionController;->findViewByAccessibilityId(I)Landroid/view/View;

    move-result-object v14

    :goto_ba
    if-eqz v14, :cond_d0

    move-object/from16 v0, p0

    invoke-direct {v0, v14}, Landroid/view/AccessibilityInteractionController;->isShown(Landroid/view/View;)Z

    move-result v18

    if-eqz v18, :cond_d0

    invoke-virtual {v14}, Landroid/view/View;->getAccessibilityNodeProvider()Landroid/view/accessibility/AccessibilityNodeProvider;

    move-result-object v13

    .local v13, provider:Landroid/view/accessibility/AccessibilityNodeProvider;
    if-eqz v13, :cond_f8

    move/from16 v0, v17

    invoke-virtual {v13, v15, v0}, Landroid/view/accessibility/AccessibilityNodeProvider;->findAccessibilityNodeInfosByText(Ljava/lang/String;I)Ljava/util/List;
    :try_end_cf
    .catchall {:try_start_95 .. :try_end_cf} :catchall_152

    move-result-object v9

    .end local v13           #provider:Landroid/view/accessibility/AccessibilityNodeProvider;
    :cond_d0
    :try_start_d0
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    iget-object v0, v0, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;

    move-object/from16 v18, v0

    const/16 v19, 0x0

    move/from16 v0, v19

    move-object/from16 v1, v18

    iput-boolean v0, v1, Landroid/view/View$AttachInfo;->mIncludeNotImportantViews:Z

    invoke-interface {v4, v9, v11}, Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback;->setFindAccessibilityNodeInfosResult(Ljava/util/List;I)V
    :try_end_e7
    .catch Landroid/os/RemoteException; {:try_start_d0 .. :try_end_e7} :catch_e8

    goto :goto_94

    .end local v14           #root:Landroid/view/View;
    :catch_e8
    move-exception v18

    goto :goto_94

    :cond_ea
    const/16 v18, 0x0

    goto :goto_a7

    .restart local v14       #root:Landroid/view/View;
    :cond_ed
    :try_start_ed
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    iget-object v14, v0, Landroid/view/ViewRootImpl;->mView:Landroid/view/View;

    goto :goto_ba

    .restart local v13       #provider:Landroid/view/accessibility/AccessibilityNodeProvider;
    :cond_f8
    const/16 v18, -0x1

    move/from16 v0, v17

    move/from16 v1, v18

    if-ne v0, v1, :cond_d0

    move-object/from16 v0, p0

    iget-object v7, v0, Landroid/view/AccessibilityInteractionController;->mTempArrayList:Ljava/util/ArrayList;

    .local v7, foundViews:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/view/View;>;"
    invoke-virtual {v7}, Ljava/util/ArrayList;->clear()V

    const/16 v18, 0x7

    move/from16 v0, v18

    invoke-virtual {v14, v7, v15, v0}, Landroid/view/View;->findViewsWithText(Ljava/util/ArrayList;Ljava/lang/CharSequence;I)V

    invoke-virtual {v7}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v18

    if-nez v18, :cond_d0

    move-object/from16 v0, p0

    iget-object v9, v0, Landroid/view/AccessibilityInteractionController;->mTempAccessibilityNodeInfoList:Ljava/util/ArrayList;

    invoke-interface {v9}, Ljava/util/List;->clear()V

    invoke-virtual {v7}, Ljava/util/ArrayList;->size()I

    move-result v16

    .local v16, viewCount:I
    const/4 v8, 0x0

    .local v8, i:I
    :goto_120
    move/from16 v0, v16

    if-ge v8, v0, :cond_d0

    invoke-virtual {v7, v8}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/view/View;

    .local v6, foundView:Landroid/view/View;
    move-object/from16 v0, p0

    invoke-direct {v0, v6}, Landroid/view/AccessibilityInteractionController;->isShown(Landroid/view/View;)Z

    move-result v18

    if-eqz v18, :cond_145

    invoke-virtual {v6}, Landroid/view/View;->getAccessibilityNodeProvider()Landroid/view/accessibility/AccessibilityNodeProvider;

    move-result-object v13

    if-eqz v13, :cond_148

    const/16 v18, -0x1

    move/from16 v0, v18

    invoke-virtual {v13, v15, v0}, Landroid/view/accessibility/AccessibilityNodeProvider;->findAccessibilityNodeInfosByText(Ljava/lang/String;I)Ljava/util/List;

    move-result-object v10

    .local v10, infosFromProvider:Ljava/util/List;,"Ljava/util/List<Landroid/view/accessibility/AccessibilityNodeInfo;>;"
    if-eqz v10, :cond_145

    invoke-interface {v9, v10}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .end local v10           #infosFromProvider:Ljava/util/List;,"Ljava/util/List<Landroid/view/accessibility/AccessibilityNodeInfo;>;"
    :cond_145
    :goto_145
    add-int/lit8 v8, v8, 0x1

    goto :goto_120

    :cond_148
    invoke-virtual {v6}, Landroid/view/View;->createAccessibilityNodeInfo()Landroid/view/accessibility/AccessibilityNodeInfo;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-interface {v9, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_151
    .catchall {:try_start_ed .. :try_end_151} :catchall_152

    goto :goto_145

    .end local v6           #foundView:Landroid/view/View;
    .end local v7           #foundViews:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Landroid/view/View;>;"
    .end local v8           #i:I
    .end local v13           #provider:Landroid/view/accessibility/AccessibilityNodeProvider;
    .end local v14           #root:Landroid/view/View;
    .end local v16           #viewCount:I
    :catchall_152
    move-exception v18

    :try_start_153
    move-object/from16 v0, p0

    iget-object v0, v0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    iget-object v0, v0, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;

    move-object/from16 v19, v0

    const/16 v20, 0x0

    move/from16 v0, v20

    move-object/from16 v1, v19

    iput-boolean v0, v1, Landroid/view/View$AttachInfo;->mIncludeNotImportantViews:Z

    invoke-interface {v4, v9, v11}, Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback;->setFindAccessibilityNodeInfosResult(Ljava/util/List;I)V
    :try_end_16a
    .catch Landroid/os/RemoteException; {:try_start_153 .. :try_end_16a} :catch_16b

    :goto_16a
    throw v18

    :catch_16b
    move-exception v19

    goto :goto_16a
.end method

.method private findFocusUiThread(Landroid/os/Message;)V
    .registers 19
    .parameter "message"

    .prologue
    move-object/from16 v0, p1

    iget v4, v0, Landroid/os/Message;->arg1:I

    .local v4, flags:I
    move-object/from16 v0, p1

    iget v5, v0, Landroid/os/Message;->arg2:I

    .local v5, focusType:I
    move-object/from16 v0, p1

    iget-object v2, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v2, Landroid/view/AccessibilityInteractionController$SomeArgs;

    .local v2, args:Landroid/view/AccessibilityInteractionController$SomeArgs;
    iget v8, v2, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi1:I

    .local v8, interactionId:I
    iget v1, v2, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi2:I

    .local v1, accessibilityViewId:I
    iget v13, v2, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi3:I

    .local v13, virtualDescendantId:I
    iget-object v3, v2, Landroid/view/AccessibilityInteractionController$SomeArgs;->arg1:Ljava/lang/Object;

    check-cast v3, Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback;

    .local v3, callback:Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback;
    iget-object v9, v2, Landroid/view/AccessibilityInteractionController$SomeArgs;->arg2:Ljava/lang/Object;

    check-cast v9, Landroid/view/AccessibilityInteractionController$SomeArgs;

    .local v9, moreArgs:Landroid/view/AccessibilityInteractionController$SomeArgs;
    move-object/from16 v0, p0

    iget-object v14, v0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v14, v14, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;

    iget v15, v9, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi1:I

    iput v15, v14, Landroid/view/View$AttachInfo;->mActualWindowLeft:I

    move-object/from16 v0, p0

    iget-object v14, v0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v14, v14, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;

    iget v15, v9, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi2:I

    iput v15, v14, Landroid/view/View$AttachInfo;->mActualWindowTop:I

    move-object/from16 v0, p0

    iget-object v14, v0, Landroid/view/AccessibilityInteractionController;->mPool:Landroid/util/Pool;

    invoke-interface {v14, v9}, Landroid/util/Pool;->release(Landroid/util/Poolable;)V

    move-object/from16 v0, p0

    iget-object v14, v0, Landroid/view/AccessibilityInteractionController;->mPool:Landroid/util/Pool;

    invoke-interface {v14, v2}, Landroid/util/Pool;->release(Landroid/util/Poolable;)V

    const/4 v6, 0x0

    .local v6, focused:Landroid/view/accessibility/AccessibilityNodeInfo;
    :try_start_3f
    move-object/from16 v0, p0

    iget-object v14, v0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v14, v14, Landroid/view/ViewRootImpl;->mView:Landroid/view/View;

    if-eqz v14, :cond_4f

    move-object/from16 v0, p0

    iget-object v14, v0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v14, v14, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;
    :try_end_4d
    .catchall {:try_start_3f .. :try_end_4d} :catchall_99

    if-nez v14, :cond_5c

    :cond_4f
    :try_start_4f
    move-object/from16 v0, p0

    iget-object v14, v0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v14, v14, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;

    const/4 v15, 0x0

    iput-boolean v15, v14, Landroid/view/View$AttachInfo;->mIncludeNotImportantViews:Z

    invoke-interface {v3, v6, v8}, Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback;->setFindAccessibilityNodeInfoResult(Landroid/view/accessibility/AccessibilityNodeInfo;I)V
    :try_end_5b
    .catch Landroid/os/RemoteException; {:try_start_4f .. :try_end_5b} :catch_ce

    :goto_5b
    return-void

    :cond_5c
    :try_start_5c
    move-object/from16 v0, p0

    iget-object v14, v0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v15, v14, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;

    and-int/lit8 v14, v4, 0x8

    if-eqz v14, :cond_aa

    const/4 v14, 0x1

    :goto_67
    iput-boolean v14, v15, Landroid/view/View$AttachInfo;->mIncludeNotImportantViews:Z

    const/4 v11, 0x0

    .local v11, root:Landroid/view/View;
    const/4 v14, -0x1

    if-eq v1, v14, :cond_ac

    move-object/from16 v0, p0

    invoke-direct {v0, v1}, Landroid/view/AccessibilityInteractionController;->findViewByAccessibilityId(I)Landroid/view/View;

    move-result-object v11

    :goto_73
    if-eqz v11, :cond_c1

    move-object/from16 v0, p0

    invoke-direct {v0, v11}, Landroid/view/AccessibilityInteractionController;->isShown(Landroid/view/View;)Z

    move-result v14

    if-eqz v14, :cond_c1

    packed-switch v5, :pswitch_data_106

    new-instance v14, Ljava/lang/IllegalArgumentException;

    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    const-string v16, "Unknown focus type: "

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-direct {v14, v15}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v14
    :try_end_99
    .catchall {:try_start_5c .. :try_end_99} :catchall_99

    .end local v11           #root:Landroid/view/View;
    :catchall_99
    move-exception v14

    :try_start_9a
    move-object/from16 v0, p0

    iget-object v15, v0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v15, v15, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;

    const/16 v16, 0x0

    move/from16 v0, v16

    iput-boolean v0, v15, Landroid/view/View$AttachInfo;->mIncludeNotImportantViews:Z

    invoke-interface {v3, v6, v8}, Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback;->setFindAccessibilityNodeInfoResult(Landroid/view/accessibility/AccessibilityNodeInfo;I)V
    :try_end_a9
    .catch Landroid/os/RemoteException; {:try_start_9a .. :try_end_a9} :catch_104

    :goto_a9
    throw v14

    :cond_aa
    const/4 v14, 0x0

    goto :goto_67

    .restart local v11       #root:Landroid/view/View;
    :cond_ac
    :try_start_ac
    move-object/from16 v0, p0

    iget-object v14, v0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v11, v14, Landroid/view/ViewRootImpl;->mView:Landroid/view/View;

    goto :goto_73

    :pswitch_b3
    move-object/from16 v0, p0

    iget-object v14, v0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v7, v14, Landroid/view/ViewRootImpl;->mAccessibilityFocusedHost:Landroid/view/View;

    .local v7, host:Landroid/view/View;
    if-eqz v7, :cond_c1

    invoke-static {v7, v11}, Landroid/view/ViewRootImpl;->isViewDescendantOf(Landroid/view/View;Landroid/view/View;)Z
    :try_end_be
    .catchall {:try_start_ac .. :try_end_be} :catchall_99

    move-result v14

    if-nez v14, :cond_d0

    .end local v7           #host:Landroid/view/View;
    :cond_c1
    :goto_c1
    :try_start_c1
    move-object/from16 v0, p0

    iget-object v14, v0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v14, v14, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;

    const/4 v15, 0x0

    iput-boolean v15, v14, Landroid/view/View$AttachInfo;->mIncludeNotImportantViews:Z

    invoke-interface {v3, v6, v8}, Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback;->setFindAccessibilityNodeInfoResult(Landroid/view/accessibility/AccessibilityNodeInfo;I)V
    :try_end_cd
    .catch Landroid/os/RemoteException; {:try_start_c1 .. :try_end_cd} :catch_ce

    goto :goto_5b

    .end local v11           #root:Landroid/view/View;
    :catch_ce
    move-exception v14

    goto :goto_5b

    .restart local v7       #host:Landroid/view/View;
    .restart local v11       #root:Landroid/view/View;
    :cond_d0
    :try_start_d0
    invoke-virtual {v7}, Landroid/view/View;->getAccessibilityNodeProvider()Landroid/view/accessibility/AccessibilityNodeProvider;

    move-result-object v10

    .local v10, provider:Landroid/view/accessibility/AccessibilityNodeProvider;
    if-eqz v10, :cond_e9

    move-object/from16 v0, p0

    iget-object v14, v0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v14, v14, Landroid/view/ViewRootImpl;->mAccessibilityFocusedVirtualView:Landroid/view/accessibility/AccessibilityNodeInfo;

    if-eqz v14, :cond_c1

    move-object/from16 v0, p0

    iget-object v14, v0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v14, v14, Landroid/view/ViewRootImpl;->mAccessibilityFocusedVirtualView:Landroid/view/accessibility/AccessibilityNodeInfo;

    invoke-static {v14}, Landroid/view/accessibility/AccessibilityNodeInfo;->obtain(Landroid/view/accessibility/AccessibilityNodeInfo;)Landroid/view/accessibility/AccessibilityNodeInfo;

    move-result-object v6

    goto :goto_c1

    :cond_e9
    const/4 v14, -0x1

    if-ne v13, v14, :cond_c1

    invoke-virtual {v7}, Landroid/view/View;->createAccessibilityNodeInfo()Landroid/view/accessibility/AccessibilityNodeInfo;

    move-result-object v6

    goto :goto_c1

    .end local v7           #host:Landroid/view/View;
    .end local v10           #provider:Landroid/view/accessibility/AccessibilityNodeProvider;
    :pswitch_f1
    invoke-virtual {v11}, Landroid/view/View;->findFocus()Landroid/view/View;

    move-result-object v12

    .local v12, target:Landroid/view/View;
    if-eqz v12, :cond_c1

    move-object/from16 v0, p0

    invoke-direct {v0, v12}, Landroid/view/AccessibilityInteractionController;->isShown(Landroid/view/View;)Z

    move-result v14

    if-eqz v14, :cond_c1

    invoke-virtual {v12}, Landroid/view/View;->createAccessibilityNodeInfo()Landroid/view/accessibility/AccessibilityNodeInfo;
    :try_end_102
    .catchall {:try_start_d0 .. :try_end_102} :catchall_99

    move-result-object v6

    goto :goto_c1

    .end local v11           #root:Landroid/view/View;
    .end local v12           #target:Landroid/view/View;
    :catch_104
    move-exception v15

    goto :goto_a9

    :pswitch_data_106
    .packed-switch 0x1
        :pswitch_f1
        :pswitch_b3
    .end packed-switch
.end method

.method private findViewByAccessibilityId(I)Landroid/view/View;
    .registers 6
    .parameter "accessibilityId"

    .prologue
    const/4 v2, 0x0

    iget-object v3, p0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v1, v3, Landroid/view/ViewRootImpl;->mView:Landroid/view/View;

    .local v1, root:Landroid/view/View;
    if-nez v1, :cond_9

    move-object v0, v2

    :cond_8
    :goto_8
    return-object v0

    :cond_9
    invoke-virtual {v1, p1}, Landroid/view/View;->findViewByAccessibilityId(I)Landroid/view/View;

    move-result-object v0

    .local v0, foundView:Landroid/view/View;
    if-eqz v0, :cond_8

    invoke-direct {p0, v0}, Landroid/view/AccessibilityInteractionController;->isShown(Landroid/view/View;)Z

    move-result v3

    if-nez v3, :cond_8

    move-object v0, v2

    goto :goto_8
.end method

.method private focusSearchUiThread(Landroid/os/Message;)V
    .registers 18
    .parameter "message"

    .prologue
    move-object/from16 v0, p1

    iget v5, v0, Landroid/os/Message;->arg1:I

    .local v5, flags:I
    move-object/from16 v0, p1

    iget v1, v0, Landroid/os/Message;->arg2:I

    .local v1, accessibilityViewId:I
    move-object/from16 v0, p1

    iget-object v2, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v2, Landroid/view/AccessibilityInteractionController$SomeArgs;

    .local v2, args:Landroid/view/AccessibilityInteractionController$SomeArgs;
    iget v12, v2, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi1:I

    .local v12, virtualDescendantId:I
    iget v4, v2, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi2:I

    .local v4, direction:I
    iget v6, v2, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi3:I

    .local v6, interactionId:I
    iget-object v3, v2, Landroid/view/AccessibilityInteractionController$SomeArgs;->arg1:Ljava/lang/Object;

    check-cast v3, Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback;

    .local v3, callback:Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback;
    iget-object v7, v2, Landroid/view/AccessibilityInteractionController$SomeArgs;->arg2:Ljava/lang/Object;

    check-cast v7, Landroid/view/AccessibilityInteractionController$SomeArgs;

    .local v7, moreArgs:Landroid/view/AccessibilityInteractionController$SomeArgs;
    move-object/from16 v0, p0

    iget-object v13, v0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v13, v13, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;

    iget v14, v7, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi1:I

    iput v14, v13, Landroid/view/View$AttachInfo;->mActualWindowLeft:I

    move-object/from16 v0, p0

    iget-object v13, v0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v13, v13, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;

    iget v14, v7, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi2:I

    iput v14, v13, Landroid/view/View$AttachInfo;->mActualWindowTop:I

    move-object/from16 v0, p0

    iget-object v13, v0, Landroid/view/AccessibilityInteractionController;->mPool:Landroid/util/Pool;

    invoke-interface {v13, v7}, Landroid/util/Pool;->release(Landroid/util/Poolable;)V

    move-object/from16 v0, p0

    iget-object v13, v0, Landroid/view/AccessibilityInteractionController;->mPool:Landroid/util/Pool;

    invoke-interface {v13, v2}, Landroid/util/Pool;->release(Landroid/util/Poolable;)V

    const/4 v8, 0x0

    .local v8, next:Landroid/view/accessibility/AccessibilityNodeInfo;
    :try_start_3f
    move-object/from16 v0, p0

    iget-object v13, v0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v13, v13, Landroid/view/ViewRootImpl;->mView:Landroid/view/View;

    if-eqz v13, :cond_4f

    move-object/from16 v0, p0

    iget-object v13, v0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v13, v13, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;
    :try_end_4d
    .catchall {:try_start_3f .. :try_end_4d} :catchall_dc

    if-nez v13, :cond_5c

    :cond_4f
    :try_start_4f
    move-object/from16 v0, p0

    iget-object v13, v0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v13, v13, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;

    const/4 v14, 0x0

    iput-boolean v14, v13, Landroid/view/View$AttachInfo;->mIncludeNotImportantViews:Z

    invoke-interface {v3, v8, v6}, Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback;->setFindAccessibilityNodeInfoResult(Landroid/view/accessibility/AccessibilityNodeInfo;I)V
    :try_end_5b
    .catch Landroid/os/RemoteException; {:try_start_4f .. :try_end_5b} :catch_9c

    :goto_5b
    return-void

    :cond_5c
    :try_start_5c
    move-object/from16 v0, p0

    iget-object v13, v0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v14, v13, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;

    and-int/lit8 v13, v5, 0x8

    if-eqz v13, :cond_9e

    const/4 v13, 0x1

    :goto_67
    iput-boolean v13, v14, Landroid/view/View$AttachInfo;->mIncludeNotImportantViews:Z

    const/4 v11, 0x0

    .local v11, root:Landroid/view/View;
    const/4 v13, -0x1

    if-eq v1, v13, :cond_a0

    move-object/from16 v0, p0

    invoke-direct {v0, v1}, Landroid/view/AccessibilityInteractionController;->findViewByAccessibilityId(I)Landroid/view/View;

    move-result-object v11

    :goto_73
    if-eqz v11, :cond_ba

    move-object/from16 v0, p0

    invoke-direct {v0, v11}, Landroid/view/AccessibilityInteractionController;->isShown(Landroid/view/View;)Z

    move-result v13

    if-eqz v13, :cond_ba

    and-int/lit16 v13, v4, 0x1000

    const/16 v14, 0x1000

    if-ne v13, v14, :cond_d1

    invoke-virtual {v11}, Landroid/view/View;->getAccessibilityNodeProvider()Landroid/view/accessibility/AccessibilityNodeProvider;

    move-result-object v10

    .local v10, provider:Landroid/view/accessibility/AccessibilityNodeProvider;
    if-eqz v10, :cond_a7

    invoke-virtual {v10, v4, v12}, Landroid/view/accessibility/AccessibilityNodeProvider;->accessibilityFocusSearch(II)Landroid/view/accessibility/AccessibilityNodeInfo;
    :try_end_8c
    .catchall {:try_start_5c .. :try_end_8c} :catchall_dc

    move-result-object v8

    if-eqz v8, :cond_a7

    :try_start_8f
    move-object/from16 v0, p0

    iget-object v13, v0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v13, v13, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;

    const/4 v14, 0x0

    iput-boolean v14, v13, Landroid/view/View$AttachInfo;->mIncludeNotImportantViews:Z

    invoke-interface {v3, v8, v6}, Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback;->setFindAccessibilityNodeInfoResult(Landroid/view/accessibility/AccessibilityNodeInfo;I)V
    :try_end_9b
    .catch Landroid/os/RemoteException; {:try_start_8f .. :try_end_9b} :catch_9c

    goto :goto_5b

    .end local v10           #provider:Landroid/view/accessibility/AccessibilityNodeProvider;
    .end local v11           #root:Landroid/view/View;
    :catch_9c
    move-exception v13

    goto :goto_5b

    :cond_9e
    const/4 v13, 0x0

    goto :goto_67

    .restart local v11       #root:Landroid/view/View;
    :cond_a0
    :try_start_a0
    move-object/from16 v0, p0

    iget-object v13, v0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v11, v13, Landroid/view/ViewRootImpl;->mView:Landroid/view/View;

    goto :goto_73

    .restart local v10       #provider:Landroid/view/accessibility/AccessibilityNodeProvider;
    :cond_a7
    invoke-virtual {v11, v4}, Landroid/view/View;->focusSearch(I)Landroid/view/View;

    move-result-object v9

    .local v9, nextView:Landroid/view/View;
    :goto_ab
    if-eqz v9, :cond_ba

    invoke-virtual {v9}, Landroid/view/View;->getAccessibilityNodeProvider()Landroid/view/accessibility/AccessibilityNodeProvider;

    move-result-object v10

    if-eqz v10, :cond_cc

    const/4 v13, -0x1

    invoke-virtual {v10, v4, v13}, Landroid/view/accessibility/AccessibilityNodeProvider;->accessibilityFocusSearch(II)Landroid/view/accessibility/AccessibilityNodeInfo;
    :try_end_b7
    .catchall {:try_start_a0 .. :try_end_b7} :catchall_dc

    move-result-object v8

    if-eqz v8, :cond_c7

    .end local v9           #nextView:Landroid/view/View;
    .end local v10           #provider:Landroid/view/accessibility/AccessibilityNodeProvider;
    :cond_ba
    :goto_ba
    :try_start_ba
    move-object/from16 v0, p0

    iget-object v13, v0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v13, v13, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;

    const/4 v14, 0x0

    iput-boolean v14, v13, Landroid/view/View$AttachInfo;->mIncludeNotImportantViews:Z

    invoke-interface {v3, v8, v6}, Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback;->setFindAccessibilityNodeInfoResult(Landroid/view/accessibility/AccessibilityNodeInfo;I)V
    :try_end_c6
    .catch Landroid/os/RemoteException; {:try_start_ba .. :try_end_c6} :catch_9c

    goto :goto_5b

    .restart local v9       #nextView:Landroid/view/View;
    .restart local v10       #provider:Landroid/view/accessibility/AccessibilityNodeProvider;
    :cond_c7
    :try_start_c7
    invoke-virtual {v9, v4}, Landroid/view/View;->focusSearch(I)Landroid/view/View;

    move-result-object v9

    goto :goto_ab

    :cond_cc
    invoke-virtual {v9}, Landroid/view/View;->createAccessibilityNodeInfo()Landroid/view/accessibility/AccessibilityNodeInfo;

    move-result-object v8

    goto :goto_ba

    .end local v9           #nextView:Landroid/view/View;
    .end local v10           #provider:Landroid/view/accessibility/AccessibilityNodeProvider;
    :cond_d1
    invoke-virtual {v11, v4}, Landroid/view/View;->focusSearch(I)Landroid/view/View;

    move-result-object v9

    .restart local v9       #nextView:Landroid/view/View;
    if-eqz v9, :cond_ba

    invoke-virtual {v9}, Landroid/view/View;->createAccessibilityNodeInfo()Landroid/view/accessibility/AccessibilityNodeInfo;
    :try_end_da
    .catchall {:try_start_c7 .. :try_end_da} :catchall_dc

    move-result-object v8

    goto :goto_ba

    .end local v9           #nextView:Landroid/view/View;
    .end local v11           #root:Landroid/view/View;
    :catchall_dc
    move-exception v13

    :try_start_dd
    move-object/from16 v0, p0

    iget-object v14, v0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v14, v14, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;

    const/4 v15, 0x0

    iput-boolean v15, v14, Landroid/view/View$AttachInfo;->mIncludeNotImportantViews:Z

    invoke-interface {v3, v8, v6}, Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback;->setFindAccessibilityNodeInfoResult(Landroid/view/accessibility/AccessibilityNodeInfo;I)V
    :try_end_e9
    .catch Landroid/os/RemoteException; {:try_start_dd .. :try_end_e9} :catch_ea

    :goto_e9
    throw v13

    :catch_ea
    move-exception v14

    goto :goto_e9
.end method

.method private isShown(Landroid/view/View;)Z
    .registers 3
    .parameter "view"

    .prologue
    iget-object v0, p1, Landroid/view/View;->mAttachInfo:Landroid/view/View$AttachInfo;

    if-eqz v0, :cond_12

    iget-object v0, p1, Landroid/view/View;->mAttachInfo:Landroid/view/View$AttachInfo;

    iget v0, v0, Landroid/view/View$AttachInfo;->mWindowVisibility:I

    if-nez v0, :cond_12

    invoke-virtual {p1}, Landroid/view/View;->isShown()Z

    move-result v0

    if-eqz v0, :cond_12

    const/4 v0, 0x1

    :goto_11
    return v0

    :cond_12
    const/4 v0, 0x0

    goto :goto_11
.end method

.method private perfromAccessibilityActionUiThread(Landroid/os/Message;)V
    .registers 16
    .parameter "message"

    .prologue
    iget v5, p1, Landroid/os/Message;->arg1:I

    .local v5, flags:I
    iget v0, p1, Landroid/os/Message;->arg2:I

    .local v0, accessibilityViewId:I
    iget-object v2, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v2, Landroid/view/AccessibilityInteractionController$SomeArgs;

    .local v2, args:Landroid/view/AccessibilityInteractionController$SomeArgs;
    iget v10, v2, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi1:I

    .local v10, virtualDescendantId:I
    iget v1, v2, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi2:I

    .local v1, action:I
    iget v6, v2, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi3:I

    .local v6, interactionId:I
    iget-object v4, v2, Landroid/view/AccessibilityInteractionController$SomeArgs;->arg1:Ljava/lang/Object;

    check-cast v4, Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback;

    .local v4, callback:Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback;
    iget-object v3, v2, Landroid/view/AccessibilityInteractionController$SomeArgs;->arg2:Ljava/lang/Object;

    check-cast v3, Landroid/os/Bundle;

    .local v3, arguments:Landroid/os/Bundle;
    iget-object v11, p0, Landroid/view/AccessibilityInteractionController;->mPool:Landroid/util/Pool;

    invoke-interface {v11, v2}, Landroid/util/Pool;->release(Landroid/util/Poolable;)V

    const/4 v8, 0x0

    .local v8, succeeded:Z
    :try_start_1c
    iget-object v11, p0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v11, v11, Landroid/view/ViewRootImpl;->mView:Landroid/view/View;

    if-eqz v11, :cond_28

    iget-object v11, p0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v11, v11, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;
    :try_end_26
    .catchall {:try_start_1c .. :try_end_26} :catchall_74

    if-nez v11, :cond_33

    :cond_28
    :try_start_28
    iget-object v11, p0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v11, v11, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;

    const/4 v12, 0x0

    iput-boolean v12, v11, Landroid/view/View$AttachInfo;->mIncludeNotImportantViews:Z

    invoke-interface {v4, v8, v6}, Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback;->setPerformAccessibilityActionResult(ZI)V
    :try_end_32
    .catch Landroid/os/RemoteException; {:try_start_28 .. :try_end_32} :catch_63

    :goto_32
    return-void

    :cond_33
    :try_start_33
    iget-object v11, p0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v12, v11, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;

    and-int/lit8 v11, v5, 0x8

    if-eqz v11, :cond_65

    const/4 v11, 0x1

    :goto_3c
    iput-boolean v11, v12, Landroid/view/View$AttachInfo;->mIncludeNotImportantViews:Z

    const/4 v9, 0x0

    .local v9, target:Landroid/view/View;
    const/4 v11, -0x1

    if-eq v0, v11, :cond_67

    invoke-direct {p0, v0}, Landroid/view/AccessibilityInteractionController;->findViewByAccessibilityId(I)Landroid/view/View;

    move-result-object v9

    :goto_46
    if-eqz v9, :cond_58

    invoke-direct {p0, v9}, Landroid/view/AccessibilityInteractionController;->isShown(Landroid/view/View;)Z

    move-result v11

    if-eqz v11, :cond_58

    invoke-virtual {v9}, Landroid/view/View;->getAccessibilityNodeProvider()Landroid/view/accessibility/AccessibilityNodeProvider;

    move-result-object v7

    .local v7, provider:Landroid/view/accessibility/AccessibilityNodeProvider;
    if-eqz v7, :cond_6c

    invoke-virtual {v7, v10, v1, v3}, Landroid/view/accessibility/AccessibilityNodeProvider;->performAction(IILandroid/os/Bundle;)Z
    :try_end_57
    .catchall {:try_start_33 .. :try_end_57} :catchall_74

    move-result v8

    .end local v7           #provider:Landroid/view/accessibility/AccessibilityNodeProvider;
    :cond_58
    :goto_58
    :try_start_58
    iget-object v11, p0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v11, v11, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;

    const/4 v12, 0x0

    iput-boolean v12, v11, Landroid/view/View$AttachInfo;->mIncludeNotImportantViews:Z

    invoke-interface {v4, v8, v6}, Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback;->setPerformAccessibilityActionResult(ZI)V
    :try_end_62
    .catch Landroid/os/RemoteException; {:try_start_58 .. :try_end_62} :catch_63

    goto :goto_32

    .end local v9           #target:Landroid/view/View;
    :catch_63
    move-exception v11

    goto :goto_32

    :cond_65
    const/4 v11, 0x0

    goto :goto_3c

    .restart local v9       #target:Landroid/view/View;
    :cond_67
    :try_start_67
    iget-object v11, p0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v9, v11, Landroid/view/ViewRootImpl;->mView:Landroid/view/View;

    goto :goto_46

    .restart local v7       #provider:Landroid/view/accessibility/AccessibilityNodeProvider;
    :cond_6c
    const/4 v11, -0x1

    if-ne v10, v11, :cond_58

    invoke-virtual {v9, v1, v3}, Landroid/view/View;->performAccessibilityAction(ILandroid/os/Bundle;)Z
    :try_end_72
    .catchall {:try_start_67 .. :try_end_72} :catchall_74

    move-result v8

    goto :goto_58

    .end local v7           #provider:Landroid/view/accessibility/AccessibilityNodeProvider;
    .end local v9           #target:Landroid/view/View;
    :catchall_74
    move-exception v11

    :try_start_75
    iget-object v12, p0, Landroid/view/AccessibilityInteractionController;->mViewRootImpl:Landroid/view/ViewRootImpl;

    iget-object v12, v12, Landroid/view/ViewRootImpl;->mAttachInfo:Landroid/view/View$AttachInfo;

    const/4 v13, 0x0

    iput-boolean v13, v12, Landroid/view/View$AttachInfo;->mIncludeNotImportantViews:Z

    invoke-interface {v4, v8, v6}, Landroid/view/accessibility/IAccessibilityInteractionConnectionCallback;->setPerformAccessibilityActionResult(ZI)V
    :try_end_7f
    .catch Landroid/os/RemoteException; {:try_start_75 .. :try_end_7f} :catch_80

    :goto_7f
    throw v11

    :catch_80
    move-exception v12

    goto :goto_7f
.end method


# virtual methods
.method public findAccessibilityNodeInfoByAccessibilityIdClientThread(JIIILandroid/view/accessibility/IAccessibilityInteractionConnectionCallback;IIJ)V
    .registers 16
    .parameter "accessibilityNodeId"
    .parameter "windowLeft"
    .parameter "windowTop"
    .parameter "interactionId"
    .parameter "callback"
    .parameter "flags"
    .parameter "interrogatingPid"
    .parameter "interrogatingTid"

    .prologue
    iget-object v3, p0, Landroid/view/AccessibilityInteractionController;->mHandler:Landroid/os/Handler;

    invoke-virtual {v3}, Landroid/os/Handler;->obtainMessage()Landroid/os/Message;

    move-result-object v1

    .local v1, message:Landroid/os/Message;
    const/4 v3, 0x2

    iput v3, v1, Landroid/os/Message;->what:I

    iput p7, v1, Landroid/os/Message;->arg1:I

    iget-object v3, p0, Landroid/view/AccessibilityInteractionController;->mPool:Landroid/util/Pool;

    invoke-interface {v3}, Landroid/util/Pool;->acquire()Landroid/util/Poolable;

    move-result-object v0

    check-cast v0, Landroid/view/AccessibilityInteractionController$SomeArgs;

    .local v0, args:Landroid/view/AccessibilityInteractionController$SomeArgs;
    invoke-static {p1, p2}, Landroid/view/accessibility/AccessibilityNodeInfo;->getAccessibilityViewId(J)I

    move-result v3

    iput v3, v0, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi1:I

    invoke-static {p1, p2}, Landroid/view/accessibility/AccessibilityNodeInfo;->getVirtualDescendantId(J)I

    move-result v3

    iput v3, v0, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi2:I

    iput p5, v0, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi3:I

    iput-object p6, v0, Landroid/view/AccessibilityInteractionController$SomeArgs;->arg1:Ljava/lang/Object;

    iget-object v3, p0, Landroid/view/AccessibilityInteractionController;->mPool:Landroid/util/Pool;

    invoke-interface {v3}, Landroid/util/Pool;->acquire()Landroid/util/Poolable;

    move-result-object v2

    check-cast v2, Landroid/view/AccessibilityInteractionController$SomeArgs;

    .local v2, moreArgs:Landroid/view/AccessibilityInteractionController$SomeArgs;
    iput p3, v2, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi1:I

    iput p4, v2, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi2:I

    iput-object v2, v0, Landroid/view/AccessibilityInteractionController$SomeArgs;->arg2:Ljava/lang/Object;

    iput-object v0, v1, Landroid/os/Message;->obj:Ljava/lang/Object;

    iget v3, p0, Landroid/view/AccessibilityInteractionController;->mMyProcessId:I

    if-ne p8, v3, :cond_45

    iget-wide v3, p0, Landroid/view/AccessibilityInteractionController;->mMyLooperThreadId:J

    cmp-long v3, p9, v3

    if-nez v3, :cond_45

    invoke-static {p9, p10}, Landroid/view/accessibility/AccessibilityInteractionClient;->getInstanceForThread(J)Landroid/view/accessibility/AccessibilityInteractionClient;

    move-result-object v3

    invoke-virtual {v3, v1}, Landroid/view/accessibility/AccessibilityInteractionClient;->setSameThreadMessage(Landroid/os/Message;)V

    :goto_44
    return-void

    :cond_45
    iget-object v3, p0, Landroid/view/AccessibilityInteractionController;->mHandler:Landroid/os/Handler;

    invoke-virtual {v3, v1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto :goto_44
.end method

.method public findAccessibilityNodeInfoByViewIdClientThread(JIIIILandroid/view/accessibility/IAccessibilityInteractionConnectionCallback;IIJ)V
    .registers 17
    .parameter "accessibilityNodeId"
    .parameter "viewId"
    .parameter "windowLeft"
    .parameter "windowTop"
    .parameter "interactionId"
    .parameter "callback"
    .parameter "flags"
    .parameter "interrogatingPid"
    .parameter "interrogatingTid"

    .prologue
    iget-object v3, p0, Landroid/view/AccessibilityInteractionController;->mHandler:Landroid/os/Handler;

    invoke-virtual {v3}, Landroid/os/Handler;->obtainMessage()Landroid/os/Message;

    move-result-object v1

    .local v1, message:Landroid/os/Message;
    const/4 v3, 0x3

    iput v3, v1, Landroid/os/Message;->what:I

    iput p8, v1, Landroid/os/Message;->arg1:I

    invoke-static {p1, p2}, Landroid/view/accessibility/AccessibilityNodeInfo;->getAccessibilityViewId(J)I

    move-result v3

    iput v3, v1, Landroid/os/Message;->arg2:I

    iget-object v3, p0, Landroid/view/AccessibilityInteractionController;->mPool:Landroid/util/Pool;

    invoke-interface {v3}, Landroid/util/Pool;->acquire()Landroid/util/Poolable;

    move-result-object v0

    check-cast v0, Landroid/view/AccessibilityInteractionController$SomeArgs;

    .local v0, args:Landroid/view/AccessibilityInteractionController$SomeArgs;
    iput p3, v0, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi1:I

    iput p6, v0, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi2:I

    iput-object p7, v0, Landroid/view/AccessibilityInteractionController$SomeArgs;->arg1:Ljava/lang/Object;

    iget-object v3, p0, Landroid/view/AccessibilityInteractionController;->mPool:Landroid/util/Pool;

    invoke-interface {v3}, Landroid/util/Pool;->acquire()Landroid/util/Poolable;

    move-result-object v2

    check-cast v2, Landroid/view/AccessibilityInteractionController$SomeArgs;

    .local v2, moreArgs:Landroid/view/AccessibilityInteractionController$SomeArgs;
    iput p4, v2, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi1:I

    iput p5, v2, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi2:I

    iput-object v2, v0, Landroid/view/AccessibilityInteractionController$SomeArgs;->arg2:Ljava/lang/Object;

    iput-object v0, v1, Landroid/os/Message;->obj:Ljava/lang/Object;

    iget v3, p0, Landroid/view/AccessibilityInteractionController;->mMyProcessId:I

    if-ne p9, v3, :cond_41

    iget-wide v3, p0, Landroid/view/AccessibilityInteractionController;->mMyLooperThreadId:J

    cmp-long v3, p10, v3

    if-nez v3, :cond_41

    invoke-static/range {p10 .. p11}, Landroid/view/accessibility/AccessibilityInteractionClient;->getInstanceForThread(J)Landroid/view/accessibility/AccessibilityInteractionClient;

    move-result-object v3

    invoke-virtual {v3, v1}, Landroid/view/accessibility/AccessibilityInteractionClient;->setSameThreadMessage(Landroid/os/Message;)V

    :goto_40
    return-void

    :cond_41
    iget-object v3, p0, Landroid/view/AccessibilityInteractionController;->mHandler:Landroid/os/Handler;

    invoke-virtual {v3, v1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto :goto_40
.end method

.method public findAccessibilityNodeInfosByTextClientThread(JLjava/lang/String;IIILandroid/view/accessibility/IAccessibilityInteractionConnectionCallback;IIJ)V
    .registers 17
    .parameter "accessibilityNodeId"
    .parameter "text"
    .parameter "windowLeft"
    .parameter "windowTop"
    .parameter "interactionId"
    .parameter "callback"
    .parameter "flags"
    .parameter "interrogatingPid"
    .parameter "interrogatingTid"

    .prologue
    iget-object v3, p0, Landroid/view/AccessibilityInteractionController;->mHandler:Landroid/os/Handler;

    invoke-virtual {v3}, Landroid/os/Handler;->obtainMessage()Landroid/os/Message;

    move-result-object v1

    .local v1, message:Landroid/os/Message;
    const/4 v3, 0x4

    iput v3, v1, Landroid/os/Message;->what:I

    iput p8, v1, Landroid/os/Message;->arg1:I

    iget-object v3, p0, Landroid/view/AccessibilityInteractionController;->mPool:Landroid/util/Pool;

    invoke-interface {v3}, Landroid/util/Pool;->acquire()Landroid/util/Poolable;

    move-result-object v0

    check-cast v0, Landroid/view/AccessibilityInteractionController$SomeArgs;

    .local v0, args:Landroid/view/AccessibilityInteractionController$SomeArgs;
    iput-object p3, v0, Landroid/view/AccessibilityInteractionController$SomeArgs;->arg1:Ljava/lang/Object;

    invoke-static {p1, p2}, Landroid/view/accessibility/AccessibilityNodeInfo;->getAccessibilityViewId(J)I

    move-result v3

    iput v3, v0, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi1:I

    invoke-static {p1, p2}, Landroid/view/accessibility/AccessibilityNodeInfo;->getVirtualDescendantId(J)I

    move-result v3

    iput v3, v0, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi2:I

    iput p6, v0, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi3:I

    iget-object v3, p0, Landroid/view/AccessibilityInteractionController;->mPool:Landroid/util/Pool;

    invoke-interface {v3}, Landroid/util/Pool;->acquire()Landroid/util/Poolable;

    move-result-object v2

    check-cast v2, Landroid/view/AccessibilityInteractionController$SomeArgs;

    .local v2, moreArgs:Landroid/view/AccessibilityInteractionController$SomeArgs;
    iput-object p7, v2, Landroid/view/AccessibilityInteractionController$SomeArgs;->arg1:Ljava/lang/Object;

    iput p4, v2, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi1:I

    iput p5, v2, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi2:I

    iput-object v2, v0, Landroid/view/AccessibilityInteractionController$SomeArgs;->arg2:Ljava/lang/Object;

    iput-object v0, v1, Landroid/os/Message;->obj:Ljava/lang/Object;

    iget v3, p0, Landroid/view/AccessibilityInteractionController;->mMyProcessId:I

    if-ne p9, v3, :cond_47

    iget-wide v3, p0, Landroid/view/AccessibilityInteractionController;->mMyLooperThreadId:J

    cmp-long v3, p10, v3

    if-nez v3, :cond_47

    invoke-static/range {p10 .. p11}, Landroid/view/accessibility/AccessibilityInteractionClient;->getInstanceForThread(J)Landroid/view/accessibility/AccessibilityInteractionClient;

    move-result-object v3

    invoke-virtual {v3, v1}, Landroid/view/accessibility/AccessibilityInteractionClient;->setSameThreadMessage(Landroid/os/Message;)V

    :goto_46
    return-void

    :cond_47
    iget-object v3, p0, Landroid/view/AccessibilityInteractionController;->mHandler:Landroid/os/Handler;

    invoke-virtual {v3, v1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto :goto_46
.end method

.method public findFocusClientThread(JIIIILandroid/view/accessibility/IAccessibilityInteractionConnectionCallback;IIJ)V
    .registers 17
    .parameter "accessibilityNodeId"
    .parameter "focusType"
    .parameter "windowLeft"
    .parameter "windowTop"
    .parameter "interactionId"
    .parameter "callback"
    .parameter "flags"
    .parameter "interogatingPid"
    .parameter "interrogatingTid"

    .prologue
    iget-object v3, p0, Landroid/view/AccessibilityInteractionController;->mHandler:Landroid/os/Handler;

    invoke-virtual {v3}, Landroid/os/Handler;->obtainMessage()Landroid/os/Message;

    move-result-object v1

    .local v1, message:Landroid/os/Message;
    const/4 v3, 0x5

    iput v3, v1, Landroid/os/Message;->what:I

    iput p8, v1, Landroid/os/Message;->arg1:I

    iput p3, v1, Landroid/os/Message;->arg2:I

    iget-object v3, p0, Landroid/view/AccessibilityInteractionController;->mPool:Landroid/util/Pool;

    invoke-interface {v3}, Landroid/util/Pool;->acquire()Landroid/util/Poolable;

    move-result-object v0

    check-cast v0, Landroid/view/AccessibilityInteractionController$SomeArgs;

    .local v0, args:Landroid/view/AccessibilityInteractionController$SomeArgs;
    iput p6, v0, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi1:I

    invoke-static {p1, p2}, Landroid/view/accessibility/AccessibilityNodeInfo;->getAccessibilityViewId(J)I

    move-result v3

    iput v3, v0, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi2:I

    invoke-static {p1, p2}, Landroid/view/accessibility/AccessibilityNodeInfo;->getVirtualDescendantId(J)I

    move-result v3

    iput v3, v0, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi3:I

    iput-object p7, v0, Landroid/view/AccessibilityInteractionController$SomeArgs;->arg1:Ljava/lang/Object;

    iget-object v3, p0, Landroid/view/AccessibilityInteractionController;->mPool:Landroid/util/Pool;

    invoke-interface {v3}, Landroid/util/Pool;->acquire()Landroid/util/Poolable;

    move-result-object v2

    check-cast v2, Landroid/view/AccessibilityInteractionController$SomeArgs;

    .local v2, moreArgs:Landroid/view/AccessibilityInteractionController$SomeArgs;
    iput p4, v2, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi1:I

    iput p5, v2, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi2:I

    iput-object v2, v0, Landroid/view/AccessibilityInteractionController$SomeArgs;->arg2:Ljava/lang/Object;

    iput-object v0, v1, Landroid/os/Message;->obj:Ljava/lang/Object;

    iget v3, p0, Landroid/view/AccessibilityInteractionController;->mMyProcessId:I

    if-ne p9, v3, :cond_47

    iget-wide v3, p0, Landroid/view/AccessibilityInteractionController;->mMyLooperThreadId:J

    cmp-long v3, p10, v3

    if-nez v3, :cond_47

    invoke-static/range {p10 .. p11}, Landroid/view/accessibility/AccessibilityInteractionClient;->getInstanceForThread(J)Landroid/view/accessibility/AccessibilityInteractionClient;

    move-result-object v3

    invoke-virtual {v3, v1}, Landroid/view/accessibility/AccessibilityInteractionClient;->setSameThreadMessage(Landroid/os/Message;)V

    :goto_46
    return-void

    :cond_47
    iget-object v3, p0, Landroid/view/AccessibilityInteractionController;->mHandler:Landroid/os/Handler;

    invoke-virtual {v3, v1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto :goto_46
.end method

.method public focusSearchClientThread(JIIIILandroid/view/accessibility/IAccessibilityInteractionConnectionCallback;IIJ)V
    .registers 17
    .parameter "accessibilityNodeId"
    .parameter "direction"
    .parameter "windowLeft"
    .parameter "windowTop"
    .parameter "interactionId"
    .parameter "callback"
    .parameter "flags"
    .parameter "interogatingPid"
    .parameter "interrogatingTid"

    .prologue
    iget-object v3, p0, Landroid/view/AccessibilityInteractionController;->mHandler:Landroid/os/Handler;

    invoke-virtual {v3}, Landroid/os/Handler;->obtainMessage()Landroid/os/Message;

    move-result-object v1

    .local v1, message:Landroid/os/Message;
    const/4 v3, 0x6

    iput v3, v1, Landroid/os/Message;->what:I

    iput p8, v1, Landroid/os/Message;->arg1:I

    invoke-static {p1, p2}, Landroid/view/accessibility/AccessibilityNodeInfo;->getAccessibilityViewId(J)I

    move-result v3

    iput v3, v1, Landroid/os/Message;->arg2:I

    iget-object v3, p0, Landroid/view/AccessibilityInteractionController;->mPool:Landroid/util/Pool;

    invoke-interface {v3}, Landroid/util/Pool;->acquire()Landroid/util/Poolable;

    move-result-object v0

    check-cast v0, Landroid/view/AccessibilityInteractionController$SomeArgs;

    .local v0, args:Landroid/view/AccessibilityInteractionController$SomeArgs;
    invoke-static {p1, p2}, Landroid/view/accessibility/AccessibilityNodeInfo;->getVirtualDescendantId(J)I

    move-result v3

    iput v3, v0, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi1:I

    iput p3, v0, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi2:I

    iput p6, v0, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi3:I

    iput-object p7, v0, Landroid/view/AccessibilityInteractionController$SomeArgs;->arg1:Ljava/lang/Object;

    iget-object v3, p0, Landroid/view/AccessibilityInteractionController;->mPool:Landroid/util/Pool;

    invoke-interface {v3}, Landroid/util/Pool;->acquire()Landroid/util/Poolable;

    move-result-object v2

    check-cast v2, Landroid/view/AccessibilityInteractionController$SomeArgs;

    .local v2, moreArgs:Landroid/view/AccessibilityInteractionController$SomeArgs;
    iput p4, v2, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi1:I

    iput p5, v2, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi2:I

    iput-object v2, v0, Landroid/view/AccessibilityInteractionController$SomeArgs;->arg2:Ljava/lang/Object;

    iput-object v0, v1, Landroid/os/Message;->obj:Ljava/lang/Object;

    iget v3, p0, Landroid/view/AccessibilityInteractionController;->mMyProcessId:I

    if-ne p9, v3, :cond_47

    iget-wide v3, p0, Landroid/view/AccessibilityInteractionController;->mMyLooperThreadId:J

    cmp-long v3, p10, v3

    if-nez v3, :cond_47

    invoke-static/range {p10 .. p11}, Landroid/view/accessibility/AccessibilityInteractionClient;->getInstanceForThread(J)Landroid/view/accessibility/AccessibilityInteractionClient;

    move-result-object v3

    invoke-virtual {v3, v1}, Landroid/view/accessibility/AccessibilityInteractionClient;->setSameThreadMessage(Landroid/os/Message;)V

    :goto_46
    return-void

    :cond_47
    iget-object v3, p0, Landroid/view/AccessibilityInteractionController;->mHandler:Landroid/os/Handler;

    invoke-virtual {v3, v1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto :goto_46
.end method

.method public performAccessibilityActionClientThread(JILandroid/os/Bundle;ILandroid/view/accessibility/IAccessibilityInteractionConnectionCallback;IIJ)V
    .registers 15
    .parameter "accessibilityNodeId"
    .parameter "action"
    .parameter "arguments"
    .parameter "interactionId"
    .parameter "callback"
    .parameter "flags"
    .parameter "interogatingPid"
    .parameter "interrogatingTid"

    .prologue
    iget-object v2, p0, Landroid/view/AccessibilityInteractionController;->mHandler:Landroid/os/Handler;

    invoke-virtual {v2}, Landroid/os/Handler;->obtainMessage()Landroid/os/Message;

    move-result-object v1

    .local v1, message:Landroid/os/Message;
    const/4 v2, 0x1

    iput v2, v1, Landroid/os/Message;->what:I

    iput p7, v1, Landroid/os/Message;->arg1:I

    invoke-static {p1, p2}, Landroid/view/accessibility/AccessibilityNodeInfo;->getAccessibilityViewId(J)I

    move-result v2

    iput v2, v1, Landroid/os/Message;->arg2:I

    iget-object v2, p0, Landroid/view/AccessibilityInteractionController;->mPool:Landroid/util/Pool;

    invoke-interface {v2}, Landroid/util/Pool;->acquire()Landroid/util/Poolable;

    move-result-object v0

    check-cast v0, Landroid/view/AccessibilityInteractionController$SomeArgs;

    .local v0, args:Landroid/view/AccessibilityInteractionController$SomeArgs;
    invoke-static {p1, p2}, Landroid/view/accessibility/AccessibilityNodeInfo;->getVirtualDescendantId(J)I

    move-result v2

    iput v2, v0, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi1:I

    iput p3, v0, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi2:I

    iput p5, v0, Landroid/view/AccessibilityInteractionController$SomeArgs;->argi3:I

    iput-object p6, v0, Landroid/view/AccessibilityInteractionController$SomeArgs;->arg1:Ljava/lang/Object;

    iput-object p4, v0, Landroid/view/AccessibilityInteractionController$SomeArgs;->arg2:Ljava/lang/Object;

    iput-object v0, v1, Landroid/os/Message;->obj:Ljava/lang/Object;

    iget v2, p0, Landroid/view/AccessibilityInteractionController;->mMyProcessId:I

    if-ne p8, v2, :cond_3b

    iget-wide v2, p0, Landroid/view/AccessibilityInteractionController;->mMyLooperThreadId:J

    cmp-long v2, p9, v2

    if-nez v2, :cond_3b

    invoke-static {p9, p10}, Landroid/view/accessibility/AccessibilityInteractionClient;->getInstanceForThread(J)Landroid/view/accessibility/AccessibilityInteractionClient;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroid/view/accessibility/AccessibilityInteractionClient;->setSameThreadMessage(Landroid/os/Message;)V

    :goto_3a
    return-void

    :cond_3b
    iget-object v2, p0, Landroid/view/AccessibilityInteractionController;->mHandler:Landroid/os/Handler;

    invoke-virtual {v2, v1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto :goto_3a
.end method
