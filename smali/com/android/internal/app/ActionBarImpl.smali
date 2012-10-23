.class public Lcom/android/internal/app/ActionBarImpl;
.super Landroid/app/ActionBar;
.source "ActionBarImpl.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/internal/app/ActionBarImpl$TabImpl;,
        Lcom/android/internal/app/ActionBarImpl$ActionModeImpl;
    }
.end annotation


# static fields
.field private static final CONTEXT_DISPLAY_NORMAL:I = 0x0

.field private static final CONTEXT_DISPLAY_SPLIT:I = 0x1

.field private static final INVALID_POSITION:I = -0x1

.field private static final TAG:Ljava/lang/String; = "ActionBarImpl"


# instance fields
.field mActionMode:Lcom/android/internal/app/ActionBarImpl$ActionModeImpl;

.field private mActionView:Lcom/android/internal/widget/ActionBarView;

.field private mActivity:Landroid/app/Activity;

.field private mContainerView:Lcom/android/internal/widget/ActionBarContainer;

.field private mContentView:Landroid/view/View;

.field private mContext:Landroid/content/Context;

.field private mContextDisplayMode:I

.field private mContextView:Lcom/android/internal/widget/ActionBarContextView;

.field private mCurWindowVisibility:I

.field private mCurrentShowAnim:Landroid/animation/Animator;

.field mDeferredDestroyActionMode:Landroid/view/ActionMode;

.field mDeferredModeDestroyCallback:Landroid/view/ActionMode$Callback;

.field private mDialog:Landroid/app/Dialog;

.field private mDisplayHomeAsUpSet:Z

.field final mHandler:Landroid/os/Handler;

.field private mHasEmbeddedTabs:Z

.field private mHiddenByApp:Z

.field private mHiddenBySystem:Z

.field final mHideListener:Landroid/animation/Animator$AnimatorListener;

.field private mLastMenuVisibility:Z

.field private mMenuVisibilityListeners:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/app/ActionBar$OnMenuVisibilityListener;",
            ">;"
        }
    .end annotation
.end field

.field private mNowShowing:Z

.field private mOverlayLayout:Lcom/android/internal/widget/ActionBarOverlayLayout;

.field private mSavedTabPosition:I

.field private mSelectedTab:Lcom/android/internal/app/ActionBarImpl$TabImpl;

.field private mShowHideAnimationEnabled:Z

.field final mShowListener:Landroid/animation/Animator$AnimatorListener;

.field private mShowingForMode:Z

.field private mSplitView:Lcom/android/internal/widget/ActionBarContainer;

.field private mTabScrollView:Lcom/android/internal/widget/ScrollingTabContainerView;

.field mTabSelector:Ljava/lang/Runnable;

.field private mTabs:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/android/internal/app/ActionBarImpl$TabImpl;",
            ">;"
        }
    .end annotation
.end field

.field private mThemedContext:Landroid/content/Context;

.field private mTopVisibilityView:Landroid/view/ViewGroup;


# direct methods
.method public constructor <init>(Landroid/app/Activity;)V
    .registers 6
    .parameter "activity"

    .prologue
    .line 150
    invoke-direct {p0}, Landroid/app/ActionBar;-><init>()V

    .line 85
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, p0, Lcom/android/internal/app/ActionBarImpl;->mTabs:Ljava/util/ArrayList;

    .line 88
    const/4 v2, -0x1

    iput v2, p0, Lcom/android/internal/app/ActionBarImpl;->mSavedTabPosition:I

    .line 97
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, p0, Lcom/android/internal/app/ActionBarImpl;->mMenuVisibilityListeners:Ljava/util/ArrayList;

    .line 108
    new-instance v2, Landroid/os/Handler;

    invoke-direct {v2}, Landroid/os/Handler;-><init>()V

    iput-object v2, p0, Lcom/android/internal/app/ActionBarImpl;->mHandler:Landroid/os/Handler;

    .line 111
    const/4 v2, 0x0

    iput v2, p0, Lcom/android/internal/app/ActionBarImpl;->mCurWindowVisibility:I

    .line 117
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/android/internal/app/ActionBarImpl;->mNowShowing:Z

    .line 122
    new-instance v2, Lcom/android/internal/app/ActionBarImpl$1;

    invoke-direct {v2, p0}, Lcom/android/internal/app/ActionBarImpl$1;-><init>(Lcom/android/internal/app/ActionBarImpl;)V

    iput-object v2, p0, Lcom/android/internal/app/ActionBarImpl;->mHideListener:Landroid/animation/Animator$AnimatorListener;

    .line 142
    new-instance v2, Lcom/android/internal/app/ActionBarImpl$2;

    invoke-direct {v2, p0}, Lcom/android/internal/app/ActionBarImpl$2;-><init>(Lcom/android/internal/app/ActionBarImpl;)V

    iput-object v2, p0, Lcom/android/internal/app/ActionBarImpl;->mShowListener:Landroid/animation/Animator$AnimatorListener;

    .line 151
    iput-object p1, p0, Lcom/android/internal/app/ActionBarImpl;->mActivity:Landroid/app/Activity;

    .line 152
    invoke-virtual {p1}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v1

    .line 153
    .local v1, window:Landroid/view/Window;
    invoke-virtual {v1}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    .line 154
    .local v0, decor:Landroid/view/View;
    invoke-direct {p0, v0}, Lcom/android/internal/app/ActionBarImpl;->init(Landroid/view/View;)V

    .line 155
    iget-object v2, p0, Lcom/android/internal/app/ActionBarImpl;->mActivity:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v2

    const/16 v3, 0x9

    invoke-virtual {v2, v3}, Landroid/view/Window;->hasFeature(I)Z

    move-result v2

    if-nez v2, :cond_53

    .line 156
    const v2, 0x1020002

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    iput-object v2, p0, Lcom/android/internal/app/ActionBarImpl;->mContentView:Landroid/view/View;

    .line 158
    :cond_53
    return-void
.end method

.method public constructor <init>(Landroid/app/Dialog;)V
    .registers 3
    .parameter "dialog"

    .prologue
    .line 160
    invoke-direct {p0}, Landroid/app/ActionBar;-><init>()V

    .line 85
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mTabs:Ljava/util/ArrayList;

    .line 88
    const/4 v0, -0x1

    iput v0, p0, Lcom/android/internal/app/ActionBarImpl;->mSavedTabPosition:I

    .line 97
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mMenuVisibilityListeners:Ljava/util/ArrayList;

    .line 108
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mHandler:Landroid/os/Handler;

    .line 111
    const/4 v0, 0x0

    iput v0, p0, Lcom/android/internal/app/ActionBarImpl;->mCurWindowVisibility:I

    .line 117
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/internal/app/ActionBarImpl;->mNowShowing:Z

    .line 122
    new-instance v0, Lcom/android/internal/app/ActionBarImpl$1;

    invoke-direct {v0, p0}, Lcom/android/internal/app/ActionBarImpl$1;-><init>(Lcom/android/internal/app/ActionBarImpl;)V

    iput-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mHideListener:Landroid/animation/Animator$AnimatorListener;

    .line 142
    new-instance v0, Lcom/android/internal/app/ActionBarImpl$2;

    invoke-direct {v0, p0}, Lcom/android/internal/app/ActionBarImpl$2;-><init>(Lcom/android/internal/app/ActionBarImpl;)V

    iput-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mShowListener:Landroid/animation/Animator$AnimatorListener;

    .line 161
    iput-object p1, p0, Lcom/android/internal/app/ActionBarImpl;->mDialog:Landroid/app/Dialog;

    .line 162
    invoke-virtual {p1}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/android/internal/app/ActionBarImpl;->init(Landroid/view/View;)V

    .line 163
    return-void
.end method

.method static synthetic access$000(Lcom/android/internal/app/ActionBarImpl;)Landroid/view/View;
    .registers 2
    .parameter "x0"

    .prologue
    .line 68
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mContentView:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$100(Lcom/android/internal/app/ActionBarImpl;)Landroid/view/ViewGroup;
    .registers 2
    .parameter "x0"

    .prologue
    .line 68
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mTopVisibilityView:Landroid/view/ViewGroup;

    return-object v0
.end method

.method static synthetic access$1000(Lcom/android/internal/app/ActionBarImpl;)Lcom/android/internal/widget/ActionBarContextView;
    .registers 2
    .parameter "x0"

    .prologue
    .line 68
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mContextView:Lcom/android/internal/widget/ActionBarContextView;

    return-object v0
.end method

.method static synthetic access$1100(Lcom/android/internal/app/ActionBarImpl;)Lcom/android/internal/widget/ActionBarView;
    .registers 2
    .parameter "x0"

    .prologue
    .line 68
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    return-object v0
.end method

.method static synthetic access$1200(Lcom/android/internal/app/ActionBarImpl;)Landroid/content/Context;
    .registers 2
    .parameter "x0"

    .prologue
    .line 68
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$1300(Lcom/android/internal/app/ActionBarImpl;)Lcom/android/internal/widget/ScrollingTabContainerView;
    .registers 2
    .parameter "x0"

    .prologue
    .line 68
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mTabScrollView:Lcom/android/internal/widget/ScrollingTabContainerView;

    return-object v0
.end method

.method static synthetic access$200(Lcom/android/internal/app/ActionBarImpl;)Lcom/android/internal/widget/ActionBarContainer;
    .registers 2
    .parameter "x0"

    .prologue
    .line 68
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mSplitView:Lcom/android/internal/widget/ActionBarContainer;

    return-object v0
.end method

.method static synthetic access$300(Lcom/android/internal/app/ActionBarImpl;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 68
    iget v0, p0, Lcom/android/internal/app/ActionBarImpl;->mContextDisplayMode:I

    return v0
.end method

.method static synthetic access$400(Lcom/android/internal/app/ActionBarImpl;)Lcom/android/internal/widget/ActionBarContainer;
    .registers 2
    .parameter "x0"

    .prologue
    .line 68
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mContainerView:Lcom/android/internal/widget/ActionBarContainer;

    return-object v0
.end method

.method static synthetic access$502(Lcom/android/internal/app/ActionBarImpl;Landroid/animation/Animator;)Landroid/animation/Animator;
    .registers 2
    .parameter "x0"
    .parameter "x1"

    .prologue
    .line 68
    iput-object p1, p0, Lcom/android/internal/app/ActionBarImpl;->mCurrentShowAnim:Landroid/animation/Animator;

    return-object p1
.end method

.method static synthetic access$600(Lcom/android/internal/app/ActionBarImpl;)Lcom/android/internal/widget/ActionBarOverlayLayout;
    .registers 2
    .parameter "x0"

    .prologue
    .line 68
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mOverlayLayout:Lcom/android/internal/widget/ActionBarOverlayLayout;

    return-object v0
.end method

.method static synthetic access$700(Lcom/android/internal/app/ActionBarImpl;)Z
    .registers 2
    .parameter "x0"

    .prologue
    .line 68
    iget-boolean v0, p0, Lcom/android/internal/app/ActionBarImpl;->mHiddenByApp:Z

    return v0
.end method

.method static synthetic access$800(Lcom/android/internal/app/ActionBarImpl;)Z
    .registers 2
    .parameter "x0"

    .prologue
    .line 68
    iget-boolean v0, p0, Lcom/android/internal/app/ActionBarImpl;->mHiddenBySystem:Z

    return v0
.end method

.method static synthetic access$900(ZZZ)Z
    .registers 4
    .parameter "x0"
    .parameter "x1"
    .parameter "x2"

    .prologue
    .line 68
    invoke-static {p0, p1, p2}, Lcom/android/internal/app/ActionBarImpl;->checkShowingFlags(ZZZ)Z

    move-result v0

    return v0
.end method

.method private static checkShowingFlags(ZZZ)Z
    .registers 4
    .parameter "hiddenByApp"
    .parameter "hiddenBySystem"
    .parameter "showingForMode"

    .prologue
    const/4 v0, 0x1

    .line 641
    if-eqz p2, :cond_4

    .line 646
    :cond_3
    :goto_3
    return v0

    .line 643
    :cond_4
    if-nez p0, :cond_8

    if-eqz p1, :cond_3

    .line 644
    :cond_8
    const/4 v0, 0x0

    goto :goto_3
.end method

.method private cleanupTabs()V
    .registers 2

    .prologue
    .line 372
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mSelectedTab:Lcom/android/internal/app/ActionBarImpl$TabImpl;

    if-eqz v0, :cond_8

    .line 373
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/android/internal/app/ActionBarImpl;->selectTab(Landroid/app/ActionBar$Tab;)V

    .line 375
    :cond_8
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mTabs:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 376
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mTabScrollView:Lcom/android/internal/widget/ScrollingTabContainerView;

    if-eqz v0, :cond_16

    .line 377
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mTabScrollView:Lcom/android/internal/widget/ScrollingTabContainerView;

    invoke-virtual {v0}, Lcom/android/internal/widget/ScrollingTabContainerView;->removeAllTabs()V

    .line 379
    :cond_16
    const/4 v0, -0x1

    iput v0, p0, Lcom/android/internal/app/ActionBarImpl;->mSavedTabPosition:I

    .line 380
    return-void
.end method

.method private configureTab(Landroid/app/ActionBar$Tab;I)V
    .registers 9
    .parameter "tab"
    .parameter "position"

    .prologue
    .line 467
    move-object v3, p1

    check-cast v3, Lcom/android/internal/app/ActionBarImpl$TabImpl;

    .line 468
    .local v3, tabi:Lcom/android/internal/app/ActionBarImpl$TabImpl;
    invoke-virtual {v3}, Lcom/android/internal/app/ActionBarImpl$TabImpl;->getCallback()Landroid/app/ActionBar$TabListener;

    move-result-object v0

    .line 470
    .local v0, callback:Landroid/app/ActionBar$TabListener;
    if-nez v0, :cond_11

    .line 471
    new-instance v4, Ljava/lang/IllegalStateException;

    const-string v5, "Action Bar Tab must have a Callback"

    invoke-direct {v4, v5}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 474
    :cond_11
    invoke-virtual {v3, p2}, Lcom/android/internal/app/ActionBarImpl$TabImpl;->setPosition(I)V

    .line 475
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mTabs:Ljava/util/ArrayList;

    invoke-virtual {v4, p2, v3}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 477
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mTabs:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v1

    .line 478
    .local v1, count:I
    add-int/lit8 v2, p2, 0x1

    .local v2, i:I
    :goto_21
    if-ge v2, v1, :cond_31

    .line 479
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mTabs:Ljava/util/ArrayList;

    invoke-virtual {v4, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/android/internal/app/ActionBarImpl$TabImpl;

    invoke-virtual {v4, v2}, Lcom/android/internal/app/ActionBarImpl$TabImpl;->setPosition(I)V

    .line 478
    add-int/lit8 v2, v2, 0x1

    goto :goto_21

    .line 481
    :cond_31
    return-void
.end method

.method private ensureTabsExist()V
    .registers 5

    .prologue
    const/4 v3, 0x0

    .line 239
    iget-object v1, p0, Lcom/android/internal/app/ActionBarImpl;->mTabScrollView:Lcom/android/internal/widget/ScrollingTabContainerView;

    if-eqz v1, :cond_6

    .line 260
    :goto_5
    return-void

    .line 243
    :cond_6
    new-instance v0, Lcom/android/internal/widget/ScrollingTabContainerView;

    iget-object v1, p0, Lcom/android/internal/app/ActionBarImpl;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/android/internal/widget/ScrollingTabContainerView;-><init>(Landroid/content/Context;)V

    .line 245
    .local v0, tabScroller:Lcom/android/internal/widget/ScrollingTabContainerView;
    iget-boolean v1, p0, Lcom/android/internal/app/ActionBarImpl;->mHasEmbeddedTabs:Z

    if-eqz v1, :cond_1c

    .line 246
    invoke-virtual {v0, v3}, Lcom/android/internal/widget/ScrollingTabContainerView;->setVisibility(I)V

    .line 247
    iget-object v1, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    invoke-virtual {v1, v0}, Lcom/android/internal/widget/ActionBarView;->setEmbeddedTabView(Lcom/android/internal/widget/ScrollingTabContainerView;)V

    .line 259
    :goto_19
    iput-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mTabScrollView:Lcom/android/internal/widget/ScrollingTabContainerView;

    goto :goto_5

    .line 249
    :cond_1c
    invoke-virtual {p0}, Lcom/android/internal/app/ActionBarImpl;->getNavigationMode()I

    move-result v1

    const/4 v2, 0x2

    if-ne v1, v2, :cond_35

    .line 250
    invoke-virtual {v0, v3}, Lcom/android/internal/widget/ScrollingTabContainerView;->setVisibility(I)V

    .line 251
    iget-object v1, p0, Lcom/android/internal/app/ActionBarImpl;->mOverlayLayout:Lcom/android/internal/widget/ActionBarOverlayLayout;

    if-eqz v1, :cond_2f

    .line 252
    iget-object v1, p0, Lcom/android/internal/app/ActionBarImpl;->mOverlayLayout:Lcom/android/internal/widget/ActionBarOverlayLayout;

    invoke-virtual {v1}, Lcom/android/internal/widget/ActionBarOverlayLayout;->requestFitSystemWindows()V

    .line 257
    :cond_2f
    :goto_2f
    iget-object v1, p0, Lcom/android/internal/app/ActionBarImpl;->mContainerView:Lcom/android/internal/widget/ActionBarContainer;

    invoke-virtual {v1, v0}, Lcom/android/internal/widget/ActionBarContainer;->setTabContainer(Lcom/android/internal/widget/ScrollingTabContainerView;)V

    goto :goto_19

    .line 255
    :cond_35
    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/android/internal/widget/ScrollingTabContainerView;->setVisibility(I)V

    goto :goto_2f
.end method

.method private hideForActionMode()V
    .registers 3

    .prologue
    const/4 v1, 0x0

    .line 623
    iget-boolean v0, p0, Lcom/android/internal/app/ActionBarImpl;->mShowingForMode:Z

    if-eqz v0, :cond_13

    .line 624
    iput-boolean v1, p0, Lcom/android/internal/app/ActionBarImpl;->mShowingForMode:Z

    .line 625
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mOverlayLayout:Lcom/android/internal/widget/ActionBarOverlayLayout;

    if-eqz v0, :cond_10

    .line 626
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mOverlayLayout:Lcom/android/internal/widget/ActionBarOverlayLayout;

    invoke-virtual {v0, v1}, Lcom/android/internal/widget/ActionBarOverlayLayout;->setShowingForActionMode(Z)V

    .line 628
    :cond_10
    invoke-direct {p0, v1}, Lcom/android/internal/app/ActionBarImpl;->updateVisibility(Z)V

    .line 630
    :cond_13
    return-void
.end method

.method private init(Landroid/view/View;)V
    .registers 9
    .parameter "decor"

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x1

    .line 166
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v3

    iput-object v3, p0, Lcom/android/internal/app/ActionBarImpl;->mContext:Landroid/content/Context;

    .line 167
    const v3, 0x1020322

    invoke-virtual {p1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/android/internal/widget/ActionBarOverlayLayout;

    iput-object v3, p0, Lcom/android/internal/app/ActionBarImpl;->mOverlayLayout:Lcom/android/internal/widget/ActionBarOverlayLayout;

    .line 169
    iget-object v3, p0, Lcom/android/internal/app/ActionBarImpl;->mOverlayLayout:Lcom/android/internal/widget/ActionBarOverlayLayout;

    if-eqz v3, :cond_1c

    .line 170
    iget-object v3, p0, Lcom/android/internal/app/ActionBarImpl;->mOverlayLayout:Lcom/android/internal/widget/ActionBarOverlayLayout;

    invoke-virtual {v3, p0}, Lcom/android/internal/widget/ActionBarOverlayLayout;->setActionBar(Lcom/android/internal/app/ActionBarImpl;)V

    .line 172
    :cond_1c
    const v3, 0x102031f

    invoke-virtual {p1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/android/internal/widget/ActionBarView;

    iput-object v3, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    .line 173
    const v3, 0x1020320

    invoke-virtual {p1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/android/internal/widget/ActionBarContextView;

    iput-object v3, p0, Lcom/android/internal/app/ActionBarImpl;->mContextView:Lcom/android/internal/widget/ActionBarContextView;

    .line 175
    const v3, 0x102031e

    invoke-virtual {p1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/android/internal/widget/ActionBarContainer;

    iput-object v3, p0, Lcom/android/internal/app/ActionBarImpl;->mContainerView:Lcom/android/internal/widget/ActionBarContainer;

    .line 177
    const v3, 0x1020323

    invoke-virtual {p1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/view/ViewGroup;

    iput-object v3, p0, Lcom/android/internal/app/ActionBarImpl;->mTopVisibilityView:Landroid/view/ViewGroup;

    .line 179
    iget-object v3, p0, Lcom/android/internal/app/ActionBarImpl;->mTopVisibilityView:Landroid/view/ViewGroup;

    if-nez v3, :cond_50

    .line 180
    iget-object v3, p0, Lcom/android/internal/app/ActionBarImpl;->mContainerView:Lcom/android/internal/widget/ActionBarContainer;

    iput-object v3, p0, Lcom/android/internal/app/ActionBarImpl;->mTopVisibilityView:Landroid/view/ViewGroup;

    .line 182
    :cond_50
    const v3, 0x1020321

    invoke-virtual {p1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/android/internal/widget/ActionBarContainer;

    iput-object v3, p0, Lcom/android/internal/app/ActionBarImpl;->mSplitView:Lcom/android/internal/widget/ActionBarContainer;

    .line 185
    iget-object v3, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    if-eqz v3, :cond_67

    iget-object v3, p0, Lcom/android/internal/app/ActionBarImpl;->mContextView:Lcom/android/internal/widget/ActionBarContextView;

    if-eqz v3, :cond_67

    iget-object v3, p0, Lcom/android/internal/app/ActionBarImpl;->mContainerView:Lcom/android/internal/widget/ActionBarContainer;

    if-nez v3, :cond_8f

    .line 186
    :cond_67
    new-instance v3, Ljava/lang/IllegalStateException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " can only be used "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, "with a compatible window decor layout"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 190
    :cond_8f
    iget-object v3, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    iget-object v6, p0, Lcom/android/internal/app/ActionBarImpl;->mContextView:Lcom/android/internal/widget/ActionBarContextView;

    invoke-virtual {v3, v6}, Lcom/android/internal/widget/ActionBarView;->setContextView(Lcom/android/internal/widget/ActionBarContextView;)V

    .line 191
    iget-object v3, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    invoke-virtual {v3}, Lcom/android/internal/widget/ActionBarView;->isSplitActionBar()Z

    move-result v3

    if-eqz v3, :cond_ca

    move v3, v4

    :goto_9f
    iput v3, p0, Lcom/android/internal/app/ActionBarImpl;->mContextDisplayMode:I

    .line 195
    iget-object v3, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    invoke-virtual {v3}, Lcom/android/internal/widget/ActionBarView;->getDisplayOptions()I

    move-result v1

    .line 196
    .local v1, current:I
    and-int/lit8 v3, v1, 0x4

    if-eqz v3, :cond_cc

    move v2, v4

    .line 197
    .local v2, homeAsUp:Z
    :goto_ac
    if-eqz v2, :cond_b0

    .line 198
    iput-boolean v4, p0, Lcom/android/internal/app/ActionBarImpl;->mDisplayHomeAsUpSet:Z

    .line 201
    :cond_b0
    iget-object v3, p0, Lcom/android/internal/app/ActionBarImpl;->mContext:Landroid/content/Context;

    invoke-static {v3}, Lcom/android/internal/view/ActionBarPolicy;->get(Landroid/content/Context;)Lcom/android/internal/view/ActionBarPolicy;

    move-result-object v0

    .line 202
    .local v0, abp:Lcom/android/internal/view/ActionBarPolicy;
    invoke-virtual {v0}, Lcom/android/internal/view/ActionBarPolicy;->enableHomeButtonByDefault()Z

    move-result v3

    if-nez v3, :cond_be

    if-eqz v2, :cond_bf

    :cond_be
    move v5, v4

    :cond_bf
    invoke-virtual {p0, v5}, Lcom/android/internal/app/ActionBarImpl;->setHomeButtonEnabled(Z)V

    .line 203
    invoke-virtual {v0}, Lcom/android/internal/view/ActionBarPolicy;->hasEmbeddedTabs()Z

    move-result v3

    invoke-direct {p0, v3}, Lcom/android/internal/app/ActionBarImpl;->setHasEmbeddedTabs(Z)V

    .line 204
    return-void

    .end local v0           #abp:Lcom/android/internal/view/ActionBarPolicy;
    .end local v1           #current:I
    .end local v2           #homeAsUp:Z
    :cond_ca
    move v3, v5

    .line 191
    goto :goto_9f

    .restart local v1       #current:I
    :cond_cc
    move v2, v5

    .line 196
    goto :goto_ac
.end method

.method private setHasEmbeddedTabs(Z)V
    .registers 7
    .parameter "hasEmbeddedTabs"

    .prologue
    const/4 v4, 0x0

    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 211
    iput-boolean p1, p0, Lcom/android/internal/app/ActionBarImpl;->mHasEmbeddedTabs:Z

    .line 213
    iget-boolean v3, p0, Lcom/android/internal/app/ActionBarImpl;->mHasEmbeddedTabs:Z

    if-nez v3, :cond_3d

    .line 214
    iget-object v3, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    invoke-virtual {v3, v4}, Lcom/android/internal/widget/ActionBarView;->setEmbeddedTabView(Lcom/android/internal/widget/ScrollingTabContainerView;)V

    .line 215
    iget-object v3, p0, Lcom/android/internal/app/ActionBarImpl;->mContainerView:Lcom/android/internal/widget/ActionBarContainer;

    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mTabScrollView:Lcom/android/internal/widget/ScrollingTabContainerView;

    invoke-virtual {v3, v4}, Lcom/android/internal/widget/ActionBarContainer;->setTabContainer(Lcom/android/internal/widget/ScrollingTabContainerView;)V

    .line 220
    :goto_15
    invoke-virtual {p0}, Lcom/android/internal/app/ActionBarImpl;->getNavigationMode()I

    move-result v3

    const/4 v4, 0x2

    if-ne v3, v4, :cond_4a

    move v0, v1

    .line 221
    .local v0, isInTabMode:Z
    :goto_1d
    iget-object v3, p0, Lcom/android/internal/app/ActionBarImpl;->mTabScrollView:Lcom/android/internal/widget/ScrollingTabContainerView;

    if-eqz v3, :cond_31

    .line 222
    if-eqz v0, :cond_4c

    .line 223
    iget-object v3, p0, Lcom/android/internal/app/ActionBarImpl;->mTabScrollView:Lcom/android/internal/widget/ScrollingTabContainerView;

    invoke-virtual {v3, v2}, Lcom/android/internal/widget/ScrollingTabContainerView;->setVisibility(I)V

    .line 224
    iget-object v3, p0, Lcom/android/internal/app/ActionBarImpl;->mOverlayLayout:Lcom/android/internal/widget/ActionBarOverlayLayout;

    if-eqz v3, :cond_31

    .line 225
    iget-object v3, p0, Lcom/android/internal/app/ActionBarImpl;->mOverlayLayout:Lcom/android/internal/widget/ActionBarOverlayLayout;

    invoke-virtual {v3}, Lcom/android/internal/widget/ActionBarOverlayLayout;->requestFitSystemWindows()V

    .line 231
    :cond_31
    :goto_31
    iget-object v3, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    iget-boolean v4, p0, Lcom/android/internal/app/ActionBarImpl;->mHasEmbeddedTabs:Z

    if-nez v4, :cond_54

    if-eqz v0, :cond_54

    :goto_39
    invoke-virtual {v3, v1}, Lcom/android/internal/widget/ActionBarView;->setCollapsable(Z)V

    .line 232
    return-void

    .line 217
    .end local v0           #isInTabMode:Z
    :cond_3d
    iget-object v3, p0, Lcom/android/internal/app/ActionBarImpl;->mContainerView:Lcom/android/internal/widget/ActionBarContainer;

    invoke-virtual {v3, v4}, Lcom/android/internal/widget/ActionBarContainer;->setTabContainer(Lcom/android/internal/widget/ScrollingTabContainerView;)V

    .line 218
    iget-object v3, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mTabScrollView:Lcom/android/internal/widget/ScrollingTabContainerView;

    invoke-virtual {v3, v4}, Lcom/android/internal/widget/ActionBarView;->setEmbeddedTabView(Lcom/android/internal/widget/ScrollingTabContainerView;)V

    goto :goto_15

    :cond_4a
    move v0, v2

    .line 220
    goto :goto_1d

    .line 228
    .restart local v0       #isInTabMode:Z
    :cond_4c
    iget-object v3, p0, Lcom/android/internal/app/ActionBarImpl;->mTabScrollView:Lcom/android/internal/widget/ScrollingTabContainerView;

    const/16 v4, 0x8

    invoke-virtual {v3, v4}, Lcom/android/internal/widget/ScrollingTabContainerView;->setVisibility(I)V

    goto :goto_31

    :cond_54
    move v1, v2

    .line 231
    goto :goto_39
.end method

.method private showForActionMode()V
    .registers 3

    .prologue
    const/4 v1, 0x1

    .line 598
    iget-boolean v0, p0, Lcom/android/internal/app/ActionBarImpl;->mShowingForMode:Z

    if-nez v0, :cond_14

    .line 599
    iput-boolean v1, p0, Lcom/android/internal/app/ActionBarImpl;->mShowingForMode:Z

    .line 600
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mOverlayLayout:Lcom/android/internal/widget/ActionBarOverlayLayout;

    if-eqz v0, :cond_10

    .line 601
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mOverlayLayout:Lcom/android/internal/widget/ActionBarOverlayLayout;

    invoke-virtual {v0, v1}, Lcom/android/internal/widget/ActionBarOverlayLayout;->setShowingForActionMode(Z)V

    .line 603
    :cond_10
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/android/internal/app/ActionBarImpl;->updateVisibility(Z)V

    .line 605
    :cond_14
    return-void
.end method

.method private updateVisibility(Z)V
    .registers 6
    .parameter "fromSystem"

    .prologue
    .line 652
    iget-boolean v1, p0, Lcom/android/internal/app/ActionBarImpl;->mHiddenByApp:Z

    iget-boolean v2, p0, Lcom/android/internal/app/ActionBarImpl;->mHiddenBySystem:Z

    iget-boolean v3, p0, Lcom/android/internal/app/ActionBarImpl;->mShowingForMode:Z

    invoke-static {v1, v2, v3}, Lcom/android/internal/app/ActionBarImpl;->checkShowingFlags(ZZZ)Z

    move-result v0

    .line 655
    .local v0, shown:Z
    if-eqz v0, :cond_17

    .line 656
    iget-boolean v1, p0, Lcom/android/internal/app/ActionBarImpl;->mNowShowing:Z

    if-nez v1, :cond_16

    .line 657
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/android/internal/app/ActionBarImpl;->mNowShowing:Z

    .line 658
    invoke-virtual {p0, p1}, Lcom/android/internal/app/ActionBarImpl;->doShow(Z)V

    .line 666
    :cond_16
    :goto_16
    return-void

    .line 661
    :cond_17
    iget-boolean v1, p0, Lcom/android/internal/app/ActionBarImpl;->mNowShowing:Z

    if-eqz v1, :cond_16

    .line 662
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/android/internal/app/ActionBarImpl;->mNowShowing:Z

    .line 663
    invoke-virtual {p0, p1}, Lcom/android/internal/app/ActionBarImpl;->doHide(Z)V

    goto :goto_16
.end method


# virtual methods
.method public addOnMenuVisibilityListener(Landroid/app/ActionBar$OnMenuVisibilityListener;)V
    .registers 3
    .parameter "listener"

    .prologue
    .line 289
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mMenuVisibilityListeners:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 290
    return-void
.end method

.method public addTab(Landroid/app/ActionBar$Tab;)V
    .registers 3
    .parameter "tab"

    .prologue
    .line 485
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mTabs:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    invoke-virtual {p0, p1, v0}, Lcom/android/internal/app/ActionBarImpl;->addTab(Landroid/app/ActionBar$Tab;Z)V

    .line 486
    return-void
.end method

.method public addTab(Landroid/app/ActionBar$Tab;I)V
    .registers 4
    .parameter "tab"
    .parameter "position"

    .prologue
    .line 490
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mTabs:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    invoke-virtual {p0, p1, p2, v0}, Lcom/android/internal/app/ActionBarImpl;->addTab(Landroid/app/ActionBar$Tab;IZ)V

    .line 491
    return-void
.end method

.method public addTab(Landroid/app/ActionBar$Tab;IZ)V
    .registers 5
    .parameter "tab"
    .parameter "position"
    .parameter "setSelected"

    .prologue
    .line 505
    invoke-direct {p0}, Lcom/android/internal/app/ActionBarImpl;->ensureTabsExist()V

    .line 506
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mTabScrollView:Lcom/android/internal/widget/ScrollingTabContainerView;

    invoke-virtual {v0, p1, p2, p3}, Lcom/android/internal/widget/ScrollingTabContainerView;->addTab(Landroid/app/ActionBar$Tab;IZ)V

    .line 507
    invoke-direct {p0, p1, p2}, Lcom/android/internal/app/ActionBarImpl;->configureTab(Landroid/app/ActionBar$Tab;I)V

    .line 508
    if-eqz p3, :cond_10

    .line 509
    invoke-virtual {p0, p1}, Lcom/android/internal/app/ActionBarImpl;->selectTab(Landroid/app/ActionBar$Tab;)V

    .line 511
    :cond_10
    return-void
.end method

.method public addTab(Landroid/app/ActionBar$Tab;Z)V
    .registers 4
    .parameter "tab"
    .parameter "setSelected"

    .prologue
    .line 495
    invoke-direct {p0}, Lcom/android/internal/app/ActionBarImpl;->ensureTabsExist()V

    .line 496
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mTabScrollView:Lcom/android/internal/widget/ScrollingTabContainerView;

    invoke-virtual {v0, p1, p2}, Lcom/android/internal/widget/ScrollingTabContainerView;->addTab(Landroid/app/ActionBar$Tab;Z)V

    .line 497
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mTabs:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    invoke-direct {p0, p1, v0}, Lcom/android/internal/app/ActionBarImpl;->configureTab(Landroid/app/ActionBar$Tab;I)V

    .line 498
    if-eqz p2, :cond_16

    .line 499
    invoke-virtual {p0, p1}, Lcom/android/internal/app/ActionBarImpl;->selectTab(Landroid/app/ActionBar$Tab;)V

    .line 501
    :cond_16
    return-void
.end method

.method animateToMode(Z)V
    .registers 6
    .parameter "toActionMode"

    .prologue
    const/16 v1, 0x8

    const/4 v2, 0x0

    .line 774
    if-eqz p1, :cond_34

    .line 775
    invoke-direct {p0}, Lcom/android/internal/app/ActionBarImpl;->showForActionMode()V

    .line 780
    :goto_8
    iget-object v3, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    if-eqz p1, :cond_38

    move v0, v1

    :goto_d
    invoke-virtual {v3, v0}, Lcom/android/internal/widget/ActionBarView;->animateToVisibility(I)V

    .line 781
    iget-object v3, p0, Lcom/android/internal/app/ActionBarImpl;->mContextView:Lcom/android/internal/widget/ActionBarContextView;

    if-eqz p1, :cond_3a

    move v0, v2

    :goto_15
    invoke-virtual {v3, v0}, Lcom/android/internal/widget/ActionBarContextView;->animateToVisibility(I)V

    .line 782
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mTabScrollView:Lcom/android/internal/widget/ScrollingTabContainerView;

    if-eqz v0, :cond_33

    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    invoke-virtual {v0}, Lcom/android/internal/widget/ActionBarView;->hasEmbeddedTabs()Z

    move-result v0

    if-nez v0, :cond_33

    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    invoke-virtual {v0}, Lcom/android/internal/widget/ActionBarView;->isCollapsed()Z

    move-result v0

    if-eqz v0, :cond_33

    .line 783
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mTabScrollView:Lcom/android/internal/widget/ScrollingTabContainerView;

    if-eqz p1, :cond_3c

    :goto_30
    invoke-virtual {v0, v1}, Lcom/android/internal/widget/ScrollingTabContainerView;->animateToVisibility(I)V

    .line 785
    :cond_33
    return-void

    .line 777
    :cond_34
    invoke-direct {p0}, Lcom/android/internal/app/ActionBarImpl;->hideForActionMode()V

    goto :goto_8

    :cond_38
    move v0, v2

    .line 780
    goto :goto_d

    :cond_3a
    move v0, v1

    .line 781
    goto :goto_15

    :cond_3c
    move v1, v2

    .line 783
    goto :goto_30
.end method

.method completeDeferredDestroyActionMode()V
    .registers 4

    .prologue
    const/4 v2, 0x0

    .line 263
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mDeferredModeDestroyCallback:Landroid/view/ActionMode$Callback;

    if-eqz v0, :cond_10

    .line 264
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mDeferredModeDestroyCallback:Landroid/view/ActionMode$Callback;

    iget-object v1, p0, Lcom/android/internal/app/ActionBarImpl;->mDeferredDestroyActionMode:Landroid/view/ActionMode;

    invoke-interface {v0, v1}, Landroid/view/ActionMode$Callback;->onDestroyActionMode(Landroid/view/ActionMode;)V

    .line 265
    iput-object v2, p0, Lcom/android/internal/app/ActionBarImpl;->mDeferredDestroyActionMode:Landroid/view/ActionMode;

    .line 266
    iput-object v2, p0, Lcom/android/internal/app/ActionBarImpl;->mDeferredModeDestroyCallback:Landroid/view/ActionMode$Callback;

    .line 268
    :cond_10
    return-void
.end method

.method public dispatchMenuVisibilityChanged(Z)V
    .registers 5
    .parameter "isVisible"

    .prologue
    .line 297
    iget-boolean v2, p0, Lcom/android/internal/app/ActionBarImpl;->mLastMenuVisibility:Z

    if-ne p1, v2, :cond_5

    .line 306
    :cond_4
    return-void

    .line 300
    :cond_5
    iput-boolean p1, p0, Lcom/android/internal/app/ActionBarImpl;->mLastMenuVisibility:Z

    .line 302
    iget-object v2, p0, Lcom/android/internal/app/ActionBarImpl;->mMenuVisibilityListeners:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v0

    .line 303
    .local v0, count:I
    const/4 v1, 0x0

    .local v1, i:I
    :goto_e
    if-ge v1, v0, :cond_4

    .line 304
    iget-object v2, p0, Lcom/android/internal/app/ActionBarImpl;->mMenuVisibilityListeners:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/app/ActionBar$OnMenuVisibilityListener;

    invoke-interface {v2, p1}, Landroid/app/ActionBar$OnMenuVisibilityListener;->onMenuVisibilityChanged(Z)V

    .line 303
    add-int/lit8 v1, v1, 0x1

    goto :goto_e
.end method

.method public doHide(Z)V
    .registers 13
    .parameter "fromSystem"

    .prologue
    const/4 v7, 0x2

    const/high16 v10, 0x3f80

    const/4 v9, 0x0

    const/4 v8, 0x1

    .line 728
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mCurrentShowAnim:Landroid/animation/Animator;

    if-eqz v4, :cond_e

    .line 729
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mCurrentShowAnim:Landroid/animation/Animator;

    invoke-virtual {v4}, Landroid/animation/Animator;->end()V

    .line 732
    :cond_e
    iget v4, p0, Lcom/android/internal/app/ActionBarImpl;->mCurWindowVisibility:I

    if-nez v4, :cond_ab

    iget-boolean v4, p0, Lcom/android/internal/app/ActionBarImpl;->mShowHideAnimationEnabled:Z

    if-nez v4, :cond_18

    if-eqz p1, :cond_ab

    .line 734
    :cond_18
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mTopVisibilityView:Landroid/view/ViewGroup;

    invoke-virtual {v4, v10}, Landroid/view/ViewGroup;->setAlpha(F)V

    .line 735
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mContainerView:Lcom/android/internal/widget/ActionBarContainer;

    invoke-virtual {v4, v8}, Lcom/android/internal/widget/ActionBarContainer;->setTransitioning(Z)V

    .line 736
    new-instance v0, Landroid/animation/AnimatorSet;

    invoke-direct {v0}, Landroid/animation/AnimatorSet;-><init>()V

    .line 737
    .local v0, anim:Landroid/animation/AnimatorSet;
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mTopVisibilityView:Landroid/view/ViewGroup;

    invoke-virtual {v4}, Landroid/view/ViewGroup;->getHeight()I

    move-result v4

    neg-int v4, v4

    int-to-float v2, v4

    .line 738
    .local v2, endingY:F
    if-eqz p1, :cond_3f

    .line 739
    new-array v3, v7, [I

    fill-array-data v3, :array_b2

    .line 740
    .local v3, topLeft:[I
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mTopVisibilityView:Landroid/view/ViewGroup;

    invoke-virtual {v4, v3}, Landroid/view/ViewGroup;->getLocationInWindow([I)V

    .line 741
    aget v4, v3, v8

    int-to-float v4, v4

    sub-float/2addr v2, v4

    .line 743
    .end local v3           #topLeft:[I
    :cond_3f
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mTopVisibilityView:Landroid/view/ViewGroup;

    const-string/jumbo v5, "translationY"

    new-array v6, v8, [F

    aput v2, v6, v9

    invoke-static {v4, v5, v6}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v4

    invoke-virtual {v0, v4}, Landroid/animation/AnimatorSet;->play(Landroid/animation/Animator;)Landroid/animation/AnimatorSet$Builder;

    move-result-object v1

    .line 745
    .local v1, b:Landroid/animation/AnimatorSet$Builder;
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mContentView:Landroid/view/View;

    if-eqz v4, :cond_67

    .line 746
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mContentView:Landroid/view/View;

    const-string/jumbo v5, "translationY"

    new-array v6, v7, [F

    const/4 v7, 0x0

    aput v7, v6, v9

    aput v2, v6, v8

    invoke-static {v4, v5, v6}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v4

    invoke-virtual {v1, v4}, Landroid/animation/AnimatorSet$Builder;->with(Landroid/animation/Animator;)Landroid/animation/AnimatorSet$Builder;

    .line 749
    :cond_67
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mSplitView:Lcom/android/internal/widget/ActionBarContainer;

    if-eqz v4, :cond_8f

    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mSplitView:Lcom/android/internal/widget/ActionBarContainer;

    invoke-virtual {v4}, Lcom/android/internal/widget/ActionBarContainer;->getVisibility()I

    move-result v4

    if-nez v4, :cond_8f

    .line 750
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mSplitView:Lcom/android/internal/widget/ActionBarContainer;

    invoke-virtual {v4, v10}, Lcom/android/internal/widget/ActionBarContainer;->setAlpha(F)V

    .line 751
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mSplitView:Lcom/android/internal/widget/ActionBarContainer;

    const-string/jumbo v5, "translationY"

    new-array v6, v8, [F

    iget-object v7, p0, Lcom/android/internal/app/ActionBarImpl;->mSplitView:Lcom/android/internal/widget/ActionBarContainer;

    invoke-virtual {v7}, Lcom/android/internal/widget/ActionBarContainer;->getHeight()I

    move-result v7

    int-to-float v7, v7

    aput v7, v6, v9

    invoke-static {v4, v5, v6}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v4

    invoke-virtual {v1, v4}, Landroid/animation/AnimatorSet$Builder;->with(Landroid/animation/Animator;)Landroid/animation/AnimatorSet$Builder;

    .line 754
    :cond_8f
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mContext:Landroid/content/Context;

    const v5, 0x10c0002

    invoke-static {v4, v5}, Landroid/view/animation/AnimationUtils;->loadInterpolator(Landroid/content/Context;I)Landroid/view/animation/Interpolator;

    move-result-object v4

    invoke-virtual {v0, v4}, Landroid/animation/AnimatorSet;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    .line 756
    const-wide/16 v4, 0xfa

    invoke-virtual {v0, v4, v5}, Landroid/animation/AnimatorSet;->setDuration(J)Landroid/animation/AnimatorSet;

    .line 757
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mHideListener:Landroid/animation/Animator$AnimatorListener;

    invoke-virtual {v0, v4}, Landroid/animation/AnimatorSet;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    .line 758
    iput-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mCurrentShowAnim:Landroid/animation/Animator;

    .line 759
    invoke-virtual {v0}, Landroid/animation/AnimatorSet;->start()V

    .line 763
    .end local v0           #anim:Landroid/animation/AnimatorSet;
    .end local v1           #b:Landroid/animation/AnimatorSet$Builder;
    .end local v2           #endingY:F
    :goto_aa
    return-void

    .line 761
    :cond_ab
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mHideListener:Landroid/animation/Animator$AnimatorListener;

    const/4 v5, 0x0

    invoke-interface {v4, v5}, Landroid/animation/Animator$AnimatorListener;->onAnimationEnd(Landroid/animation/Animator;)V

    goto :goto_aa

    .line 739
    :array_b2
    .array-data 0x4
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
    .end array-data
.end method

.method public doShow(Z)V
    .registers 13
    .parameter "fromSystem"

    .prologue
    const/4 v10, 0x2

    const/high16 v5, 0x3f80

    const/4 v9, 0x1

    const/4 v8, 0x0

    const/4 v7, 0x0

    .line 669
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mCurrentShowAnim:Landroid/animation/Animator;

    if-eqz v4, :cond_f

    .line 670
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mCurrentShowAnim:Landroid/animation/Animator;

    invoke-virtual {v4}, Landroid/animation/Animator;->end()V

    .line 672
    :cond_f
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mTopVisibilityView:Landroid/view/ViewGroup;

    invoke-virtual {v4, v8}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 674
    iget v4, p0, Lcom/android/internal/app/ActionBarImpl;->mCurWindowVisibility:I

    if-nez v4, :cond_ba

    iget-boolean v4, p0, Lcom/android/internal/app/ActionBarImpl;->mShowHideAnimationEnabled:Z

    if-nez v4, :cond_1e

    if-eqz p1, :cond_ba

    .line 676
    :cond_1e
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mTopVisibilityView:Landroid/view/ViewGroup;

    invoke-virtual {v4, v7}, Landroid/view/ViewGroup;->setTranslationY(F)V

    .line 677
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mTopVisibilityView:Landroid/view/ViewGroup;

    invoke-virtual {v4}, Landroid/view/ViewGroup;->getHeight()I

    move-result v4

    neg-int v4, v4

    int-to-float v2, v4

    .line 678
    .local v2, startingY:F
    if-eqz p1, :cond_3b

    .line 679
    new-array v3, v10, [I

    fill-array-data v3, :array_ec

    .line 680
    .local v3, topLeft:[I
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mTopVisibilityView:Landroid/view/ViewGroup;

    invoke-virtual {v4, v3}, Landroid/view/ViewGroup;->getLocationInWindow([I)V

    .line 681
    aget v4, v3, v9

    int-to-float v4, v4

    sub-float/2addr v2, v4

    .line 683
    .end local v3           #topLeft:[I
    :cond_3b
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mTopVisibilityView:Landroid/view/ViewGroup;

    invoke-virtual {v4, v2}, Landroid/view/ViewGroup;->setTranslationY(F)V

    .line 684
    new-instance v0, Landroid/animation/AnimatorSet;

    invoke-direct {v0}, Landroid/animation/AnimatorSet;-><init>()V

    .line 685
    .local v0, anim:Landroid/animation/AnimatorSet;
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mTopVisibilityView:Landroid/view/ViewGroup;

    const-string/jumbo v5, "translationY"

    new-array v6, v9, [F

    aput v7, v6, v8

    invoke-static {v4, v5, v6}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v4

    invoke-virtual {v0, v4}, Landroid/animation/AnimatorSet;->play(Landroid/animation/Animator;)Landroid/animation/AnimatorSet$Builder;

    move-result-object v1

    .line 687
    .local v1, b:Landroid/animation/AnimatorSet$Builder;
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mContentView:Landroid/view/View;

    if-eqz v4, :cond_6c

    .line 688
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mContentView:Landroid/view/View;

    const-string/jumbo v5, "translationY"

    new-array v6, v10, [F

    aput v2, v6, v8

    aput v7, v6, v9

    invoke-static {v4, v5, v6}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v4

    invoke-virtual {v1, v4}, Landroid/animation/AnimatorSet$Builder;->with(Landroid/animation/Animator;)Landroid/animation/AnimatorSet$Builder;

    .line 691
    :cond_6c
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mSplitView:Lcom/android/internal/widget/ActionBarContainer;

    if-eqz v4, :cond_95

    iget v4, p0, Lcom/android/internal/app/ActionBarImpl;->mContextDisplayMode:I

    if-ne v4, v9, :cond_95

    .line 692
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mSplitView:Lcom/android/internal/widget/ActionBarContainer;

    iget-object v5, p0, Lcom/android/internal/app/ActionBarImpl;->mSplitView:Lcom/android/internal/widget/ActionBarContainer;

    invoke-virtual {v5}, Lcom/android/internal/widget/ActionBarContainer;->getHeight()I

    move-result v5

    int-to-float v5, v5

    invoke-virtual {v4, v5}, Lcom/android/internal/widget/ActionBarContainer;->setTranslationY(F)V

    .line 693
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mSplitView:Lcom/android/internal/widget/ActionBarContainer;

    invoke-virtual {v4, v8}, Lcom/android/internal/widget/ActionBarContainer;->setVisibility(I)V

    .line 694
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mSplitView:Lcom/android/internal/widget/ActionBarContainer;

    const-string/jumbo v5, "translationY"

    new-array v6, v9, [F

    aput v7, v6, v8

    invoke-static {v4, v5, v6}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v4

    invoke-virtual {v1, v4}, Landroid/animation/AnimatorSet$Builder;->with(Landroid/animation/Animator;)Landroid/animation/AnimatorSet$Builder;

    .line 696
    :cond_95
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mContext:Landroid/content/Context;

    const v5, 0x10c0003

    invoke-static {v4, v5}, Landroid/view/animation/AnimationUtils;->loadInterpolator(Landroid/content/Context;I)Landroid/view/animation/Interpolator;

    move-result-object v4

    invoke-virtual {v0, v4}, Landroid/animation/AnimatorSet;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    .line 698
    const-wide/16 v4, 0xfa

    invoke-virtual {v0, v4, v5}, Landroid/animation/AnimatorSet;->setDuration(J)Landroid/animation/AnimatorSet;

    .line 706
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mShowListener:Landroid/animation/Animator$AnimatorListener;

    invoke-virtual {v0, v4}, Landroid/animation/AnimatorSet;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    .line 707
    iput-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mCurrentShowAnim:Landroid/animation/Animator;

    .line 708
    invoke-virtual {v0}, Landroid/animation/AnimatorSet;->start()V

    .line 722
    .end local v0           #anim:Landroid/animation/AnimatorSet;
    .end local v1           #b:Landroid/animation/AnimatorSet$Builder;
    .end local v2           #startingY:F
    :goto_b0
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mOverlayLayout:Lcom/android/internal/widget/ActionBarOverlayLayout;

    if-eqz v4, :cond_b9

    .line 723
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mOverlayLayout:Lcom/android/internal/widget/ActionBarOverlayLayout;

    invoke-virtual {v4}, Lcom/android/internal/widget/ActionBarOverlayLayout;->requestFitSystemWindows()V

    .line 725
    :cond_b9
    return-void

    .line 710
    :cond_ba
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mTopVisibilityView:Landroid/view/ViewGroup;

    invoke-virtual {v4, v5}, Landroid/view/ViewGroup;->setAlpha(F)V

    .line 711
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mTopVisibilityView:Landroid/view/ViewGroup;

    invoke-virtual {v4, v7}, Landroid/view/ViewGroup;->setTranslationY(F)V

    .line 712
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mContentView:Landroid/view/View;

    if-eqz v4, :cond_cd

    .line 713
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mContentView:Landroid/view/View;

    invoke-virtual {v4, v7}, Landroid/view/View;->setTranslationY(F)V

    .line 715
    :cond_cd
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mSplitView:Lcom/android/internal/widget/ActionBarContainer;

    if-eqz v4, :cond_e4

    iget v4, p0, Lcom/android/internal/app/ActionBarImpl;->mContextDisplayMode:I

    if-ne v4, v9, :cond_e4

    .line 716
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mSplitView:Lcom/android/internal/widget/ActionBarContainer;

    invoke-virtual {v4, v5}, Lcom/android/internal/widget/ActionBarContainer;->setAlpha(F)V

    .line 717
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mSplitView:Lcom/android/internal/widget/ActionBarContainer;

    invoke-virtual {v4, v7}, Lcom/android/internal/widget/ActionBarContainer;->setTranslationY(F)V

    .line 718
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mSplitView:Lcom/android/internal/widget/ActionBarContainer;

    invoke-virtual {v4, v8}, Lcom/android/internal/widget/ActionBarContainer;->setVisibility(I)V

    .line 720
    :cond_e4
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mShowListener:Landroid/animation/Animator$AnimatorListener;

    const/4 v5, 0x0

    invoke-interface {v4, v5}, Landroid/animation/Animator$AnimatorListener;->onAnimationEnd(Landroid/animation/Animator;)V

    goto :goto_b0

    .line 679
    nop

    :array_ec
    .array-data 0x4
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x0t 0x0t
    .end array-data
.end method

.method public getCustomView()Landroid/view/View;
    .registers 2

    .prologue
    .line 420
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    invoke-virtual {v0}, Lcom/android/internal/widget/ActionBarView;->getCustomNavigationView()Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public getDisplayOptions()I
    .registers 2

    .prologue
    .line 436
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    invoke-virtual {v0}, Lcom/android/internal/widget/ActionBarView;->getDisplayOptions()I

    move-result v0

    return v0
.end method

.method public getHeight()I
    .registers 2

    .prologue
    .line 586
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mContainerView:Lcom/android/internal/widget/ActionBarContainer;

    invoke-virtual {v0}, Lcom/android/internal/widget/ActionBarContainer;->getHeight()I

    move-result v0

    return v0
.end method

.method public getNavigationItemCount()I
    .registers 4

    .prologue
    const/4 v1, 0x0

    .line 1121
    iget-object v2, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    invoke-virtual {v2}, Lcom/android/internal/widget/ActionBarView;->getNavigationMode()I

    move-result v2

    packed-switch v2, :pswitch_data_20

    .line 1128
    :cond_a
    :goto_a
    return v1

    .line 1123
    :pswitch_b
    iget-object v1, p0, Lcom/android/internal/app/ActionBarImpl;->mTabs:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    goto :goto_a

    .line 1125
    :pswitch_12
    iget-object v2, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    invoke-virtual {v2}, Lcom/android/internal/widget/ActionBarView;->getDropdownAdapter()Landroid/widget/SpinnerAdapter;

    move-result-object v0

    .line 1126
    .local v0, adapter:Landroid/widget/SpinnerAdapter;
    if-eqz v0, :cond_a

    invoke-interface {v0}, Landroid/widget/SpinnerAdapter;->getCount()I

    move-result v1

    goto :goto_a

    .line 1121
    nop

    :pswitch_data_20
    .packed-switch 0x1
        :pswitch_12
        :pswitch_b
    .end packed-switch
.end method

.method public getNavigationMode()I
    .registers 2

    .prologue
    .line 432
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    invoke-virtual {v0}, Lcom/android/internal/widget/ActionBarView;->getNavigationMode()I

    move-result v0

    return v0
.end method

.method public getSelectedNavigationIndex()I
    .registers 3

    .prologue
    const/4 v0, -0x1

    .line 1109
    iget-object v1, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    invoke-virtual {v1}, Lcom/android/internal/widget/ActionBarView;->getNavigationMode()I

    move-result v1

    packed-switch v1, :pswitch_data_1e

    .line 1115
    :cond_a
    :goto_a
    return v0

    .line 1111
    :pswitch_b
    iget-object v1, p0, Lcom/android/internal/app/ActionBarImpl;->mSelectedTab:Lcom/android/internal/app/ActionBarImpl$TabImpl;

    if-eqz v1, :cond_a

    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mSelectedTab:Lcom/android/internal/app/ActionBarImpl$TabImpl;

    invoke-virtual {v0}, Lcom/android/internal/app/ActionBarImpl$TabImpl;->getPosition()I

    move-result v0

    goto :goto_a

    .line 1113
    :pswitch_16
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    invoke-virtual {v0}, Lcom/android/internal/widget/ActionBarView;->getDropdownSelectedPosition()I

    move-result v0

    goto :goto_a

    .line 1109
    nop

    :pswitch_data_1e
    .packed-switch 0x1
        :pswitch_16
        :pswitch_b
    .end packed-switch
.end method

.method public getSelectedTab()Landroid/app/ActionBar$Tab;
    .registers 2

    .prologue
    .line 581
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mSelectedTab:Lcom/android/internal/app/ActionBarImpl$TabImpl;

    return-object v0
.end method

.method public getSubtitle()Ljava/lang/CharSequence;
    .registers 2

    .prologue
    .line 428
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    invoke-virtual {v0}, Lcom/android/internal/widget/ActionBarView;->getSubtitle()Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method public getTabAt(I)Landroid/app/ActionBar$Tab;
    .registers 3
    .parameter "index"

    .prologue
    .line 1168
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mTabs:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/ActionBar$Tab;

    return-object v0
.end method

.method public getTabCount()I
    .registers 2

    .prologue
    .line 1134
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mTabs:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public getThemedContext()Landroid/content/Context;
    .registers 6

    .prologue
    .line 788
    iget-object v3, p0, Lcom/android/internal/app/ActionBarImpl;->mThemedContext:Landroid/content/Context;

    if-nez v3, :cond_2b

    .line 789
    new-instance v1, Landroid/util/TypedValue;

    invoke-direct {v1}, Landroid/util/TypedValue;-><init>()V

    .line 790
    .local v1, outValue:Landroid/util/TypedValue;
    iget-object v3, p0, Lcom/android/internal/app/ActionBarImpl;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v0

    .line 791
    .local v0, currentTheme:Landroid/content/res/Resources$Theme;
    const v3, 0x1010397

    const/4 v4, 0x1

    invoke-virtual {v0, v3, v1, v4}, Landroid/content/res/Resources$Theme;->resolveAttribute(ILandroid/util/TypedValue;Z)Z

    .line 793
    iget v2, v1, Landroid/util/TypedValue;->resourceId:I

    .line 795
    .local v2, targetThemeRes:I
    if-eqz v2, :cond_2e

    iget-object v3, p0, Lcom/android/internal/app/ActionBarImpl;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getThemeResId()I

    move-result v3

    if-eq v3, v2, :cond_2e

    .line 796
    new-instance v3, Landroid/view/ContextThemeWrapper;

    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mContext:Landroid/content/Context;

    invoke-direct {v3, v4, v2}, Landroid/view/ContextThemeWrapper;-><init>(Landroid/content/Context;I)V

    iput-object v3, p0, Lcom/android/internal/app/ActionBarImpl;->mThemedContext:Landroid/content/Context;

    .line 801
    .end local v0           #currentTheme:Landroid/content/res/Resources$Theme;
    .end local v1           #outValue:Landroid/util/TypedValue;
    .end local v2           #targetThemeRes:I
    :cond_2b
    :goto_2b
    iget-object v3, p0, Lcom/android/internal/app/ActionBarImpl;->mThemedContext:Landroid/content/Context;

    return-object v3

    .line 798
    .restart local v0       #currentTheme:Landroid/content/res/Resources$Theme;
    .restart local v1       #outValue:Landroid/util/TypedValue;
    .restart local v2       #targetThemeRes:I
    :cond_2e
    iget-object v3, p0, Lcom/android/internal/app/ActionBarImpl;->mContext:Landroid/content/Context;

    iput-object v3, p0, Lcom/android/internal/app/ActionBarImpl;->mThemedContext:Landroid/content/Context;

    goto :goto_2b
.end method

.method public getTitle()Ljava/lang/CharSequence;
    .registers 2

    .prologue
    .line 424
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    invoke-virtual {v0}, Lcom/android/internal/widget/ActionBarView;->getTitle()Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method public hasNonEmbeddedTabs()Z
    .registers 3

    .prologue
    .line 235
    iget-boolean v0, p0, Lcom/android/internal/app/ActionBarImpl;->mHasEmbeddedTabs:Z

    if-nez v0, :cond_d

    invoke-virtual {p0}, Lcom/android/internal/app/ActionBarImpl;->getNavigationMode()I

    move-result v0

    const/4 v1, 0x2

    if-ne v0, v1, :cond_d

    const/4 v0, 0x1

    :goto_c
    return v0

    :cond_d
    const/4 v0, 0x0

    goto :goto_c
.end method

.method public hide()V
    .registers 2

    .prologue
    .line 616
    iget-boolean v0, p0, Lcom/android/internal/app/ActionBarImpl;->mHiddenByApp:Z

    if-nez v0, :cond_b

    .line 617
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/internal/app/ActionBarImpl;->mHiddenByApp:Z

    .line 618
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/android/internal/app/ActionBarImpl;->updateVisibility(Z)V

    .line 620
    :cond_b
    return-void
.end method

.method public hideForSystem()V
    .registers 3

    .prologue
    const/4 v1, 0x1

    .line 633
    iget-boolean v0, p0, Lcom/android/internal/app/ActionBarImpl;->mHiddenBySystem:Z

    if-nez v0, :cond_a

    .line 634
    iput-boolean v1, p0, Lcom/android/internal/app/ActionBarImpl;->mHiddenBySystem:Z

    .line 635
    invoke-direct {p0, v1}, Lcom/android/internal/app/ActionBarImpl;->updateVisibility(Z)V

    .line 637
    :cond_a
    return-void
.end method

.method public isShowing()Z
    .registers 2

    .prologue
    .line 766
    iget-boolean v0, p0, Lcom/android/internal/app/ActionBarImpl;->mNowShowing:Z

    return v0
.end method

.method public isSystemShowing()Z
    .registers 2

    .prologue
    .line 770
    iget-boolean v0, p0, Lcom/android/internal/app/ActionBarImpl;->mHiddenBySystem:Z

    if-nez v0, :cond_6

    const/4 v0, 0x1

    :goto_5
    return v0

    :cond_6
    const/4 v0, 0x0

    goto :goto_5
.end method

.method public newTab()Landroid/app/ActionBar$Tab;
    .registers 2

    .prologue
    .line 515
    new-instance v0, Lcom/android/internal/app/ActionBarImpl$TabImpl;

    invoke-direct {v0, p0}, Lcom/android/internal/app/ActionBarImpl$TabImpl;-><init>(Lcom/android/internal/app/ActionBarImpl;)V

    return-object v0
.end method

.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .registers 3
    .parameter "newConfig"

    .prologue
    .line 207
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/android/internal/view/ActionBarPolicy;->get(Landroid/content/Context;)Lcom/android/internal/view/ActionBarPolicy;

    move-result-object v0

    invoke-virtual {v0}, Lcom/android/internal/view/ActionBarPolicy;->hasEmbeddedTabs()Z

    move-result v0

    invoke-direct {p0, v0}, Lcom/android/internal/app/ActionBarImpl;->setHasEmbeddedTabs(Z)V

    .line 208
    return-void
.end method

.method public removeAllTabs()V
    .registers 1

    .prologue
    .line 368
    invoke-direct {p0}, Lcom/android/internal/app/ActionBarImpl;->cleanupTabs()V

    .line 369
    return-void
.end method

.method public removeOnMenuVisibilityListener(Landroid/app/ActionBar$OnMenuVisibilityListener;)V
    .registers 3
    .parameter "listener"

    .prologue
    .line 293
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mMenuVisibilityListeners:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 294
    return-void
.end method

.method public removeTab(Landroid/app/ActionBar$Tab;)V
    .registers 3
    .parameter "tab"

    .prologue
    .line 520
    invoke-virtual {p1}, Landroid/app/ActionBar$Tab;->getPosition()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/android/internal/app/ActionBarImpl;->removeTabAt(I)V

    .line 521
    return-void
.end method

.method public removeTabAt(I)V
    .registers 9
    .parameter "position"

    .prologue
    .line 525
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mTabScrollView:Lcom/android/internal/widget/ScrollingTabContainerView;

    if-nez v4, :cond_5

    .line 546
    :cond_4
    :goto_4
    return-void

    .line 530
    :cond_5
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mSelectedTab:Lcom/android/internal/app/ActionBarImpl$TabImpl;

    if-eqz v4, :cond_39

    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mSelectedTab:Lcom/android/internal/app/ActionBarImpl$TabImpl;

    invoke-virtual {v4}, Lcom/android/internal/app/ActionBarImpl$TabImpl;->getPosition()I

    move-result v3

    .line 532
    .local v3, selectedTabPosition:I
    :goto_f
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mTabScrollView:Lcom/android/internal/widget/ScrollingTabContainerView;

    invoke-virtual {v4, p1}, Lcom/android/internal/widget/ScrollingTabContainerView;->removeTabAt(I)V

    .line 533
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mTabs:Ljava/util/ArrayList;

    invoke-virtual {v4, p1}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/android/internal/app/ActionBarImpl$TabImpl;

    .line 534
    .local v2, removedTab:Lcom/android/internal/app/ActionBarImpl$TabImpl;
    if-eqz v2, :cond_22

    .line 535
    const/4 v4, -0x1

    invoke-virtual {v2, v4}, Lcom/android/internal/app/ActionBarImpl$TabImpl;->setPosition(I)V

    .line 538
    :cond_22
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mTabs:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v1

    .line 539
    .local v1, newTabCount:I
    move v0, p1

    .local v0, i:I
    :goto_29
    if-ge v0, v1, :cond_3c

    .line 540
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mTabs:Ljava/util/ArrayList;

    invoke-virtual {v4, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/android/internal/app/ActionBarImpl$TabImpl;

    invoke-virtual {v4, v0}, Lcom/android/internal/app/ActionBarImpl$TabImpl;->setPosition(I)V

    .line 539
    add-int/lit8 v0, v0, 0x1

    goto :goto_29

    .line 530
    .end local v0           #i:I
    .end local v1           #newTabCount:I
    .end local v2           #removedTab:Lcom/android/internal/app/ActionBarImpl$TabImpl;
    .end local v3           #selectedTabPosition:I
    :cond_39
    iget v3, p0, Lcom/android/internal/app/ActionBarImpl;->mSavedTabPosition:I

    goto :goto_f

    .line 543
    .restart local v0       #i:I
    .restart local v1       #newTabCount:I
    .restart local v2       #removedTab:Lcom/android/internal/app/ActionBarImpl$TabImpl;
    .restart local v3       #selectedTabPosition:I
    :cond_3c
    if-ne v3, p1, :cond_4

    .line 544
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mTabs:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v4

    if-eqz v4, :cond_4b

    const/4 v4, 0x0

    :goto_47
    invoke-virtual {p0, v4}, Lcom/android/internal/app/ActionBarImpl;->selectTab(Landroid/app/ActionBar$Tab;)V

    goto :goto_4

    :cond_4b
    iget-object v4, p0, Lcom/android/internal/app/ActionBarImpl;->mTabs:Ljava/util/ArrayList;

    const/4 v5, 0x0

    add-int/lit8 v6, p1, -0x1

    invoke-static {v5, v6}, Ljava/lang/Math;->max(II)I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/android/internal/app/ActionBarImpl$TabImpl;

    goto :goto_47
.end method

.method public selectTab(Landroid/app/ActionBar$Tab;)V
    .registers 6
    .parameter "tab"

    .prologue
    const/4 v1, -0x1

    .line 550
    invoke-virtual {p0}, Lcom/android/internal/app/ActionBarImpl;->getNavigationMode()I

    move-result v2

    const/4 v3, 0x2

    if-eq v2, v3, :cond_11

    .line 551
    if-eqz p1, :cond_e

    invoke-virtual {p1}, Landroid/app/ActionBar$Tab;->getPosition()I

    move-result v1

    :cond_e
    iput v1, p0, Lcom/android/internal/app/ActionBarImpl;->mSavedTabPosition:I

    .line 577
    .end local p1
    :cond_10
    :goto_10
    return-void

    .line 555
    .restart local p1
    :cond_11
    iget-object v2, p0, Lcom/android/internal/app/ActionBarImpl;->mActivity:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/FragmentTransaction;->disallowAddToBackStack()Landroid/app/FragmentTransaction;

    move-result-object v0

    .line 558
    .local v0, trans:Landroid/app/FragmentTransaction;
    iget-object v2, p0, Lcom/android/internal/app/ActionBarImpl;->mSelectedTab:Lcom/android/internal/app/ActionBarImpl$TabImpl;

    if-ne v2, p1, :cond_45

    .line 559
    iget-object v1, p0, Lcom/android/internal/app/ActionBarImpl;->mSelectedTab:Lcom/android/internal/app/ActionBarImpl$TabImpl;

    if-eqz v1, :cond_3b

    .line 560
    iget-object v1, p0, Lcom/android/internal/app/ActionBarImpl;->mSelectedTab:Lcom/android/internal/app/ActionBarImpl$TabImpl;

    invoke-virtual {v1}, Lcom/android/internal/app/ActionBarImpl$TabImpl;->getCallback()Landroid/app/ActionBar$TabListener;

    move-result-object v1

    iget-object v2, p0, Lcom/android/internal/app/ActionBarImpl;->mSelectedTab:Lcom/android/internal/app/ActionBarImpl$TabImpl;

    invoke-interface {v1, v2, v0}, Landroid/app/ActionBar$TabListener;->onTabReselected(Landroid/app/ActionBar$Tab;Landroid/app/FragmentTransaction;)V

    .line 561
    iget-object v1, p0, Lcom/android/internal/app/ActionBarImpl;->mTabScrollView:Lcom/android/internal/widget/ScrollingTabContainerView;

    invoke-virtual {p1}, Landroid/app/ActionBar$Tab;->getPosition()I

    move-result v2

    invoke-virtual {v1, v2}, Lcom/android/internal/widget/ScrollingTabContainerView;->animateToTab(I)V

    .line 574
    .end local p1
    :cond_3b
    :goto_3b
    invoke-virtual {v0}, Landroid/app/FragmentTransaction;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_10

    .line 575
    invoke-virtual {v0}, Landroid/app/FragmentTransaction;->commit()I

    goto :goto_10

    .line 564
    .restart local p1
    :cond_45
    iget-object v2, p0, Lcom/android/internal/app/ActionBarImpl;->mTabScrollView:Lcom/android/internal/widget/ScrollingTabContainerView;

    if-eqz p1, :cond_4d

    invoke-virtual {p1}, Landroid/app/ActionBar$Tab;->getPosition()I

    move-result v1

    :cond_4d
    invoke-virtual {v2, v1}, Lcom/android/internal/widget/ScrollingTabContainerView;->setTabSelected(I)V

    .line 565
    iget-object v1, p0, Lcom/android/internal/app/ActionBarImpl;->mSelectedTab:Lcom/android/internal/app/ActionBarImpl$TabImpl;

    if-eqz v1, :cond_5f

    .line 566
    iget-object v1, p0, Lcom/android/internal/app/ActionBarImpl;->mSelectedTab:Lcom/android/internal/app/ActionBarImpl$TabImpl;

    invoke-virtual {v1}, Lcom/android/internal/app/ActionBarImpl$TabImpl;->getCallback()Landroid/app/ActionBar$TabListener;

    move-result-object v1

    iget-object v2, p0, Lcom/android/internal/app/ActionBarImpl;->mSelectedTab:Lcom/android/internal/app/ActionBarImpl$TabImpl;

    invoke-interface {v1, v2, v0}, Landroid/app/ActionBar$TabListener;->onTabUnselected(Landroid/app/ActionBar$Tab;Landroid/app/FragmentTransaction;)V

    .line 568
    :cond_5f
    check-cast p1, Lcom/android/internal/app/ActionBarImpl$TabImpl;

    .end local p1
    iput-object p1, p0, Lcom/android/internal/app/ActionBarImpl;->mSelectedTab:Lcom/android/internal/app/ActionBarImpl$TabImpl;

    .line 569
    iget-object v1, p0, Lcom/android/internal/app/ActionBarImpl;->mSelectedTab:Lcom/android/internal/app/ActionBarImpl$TabImpl;

    if-eqz v1, :cond_3b

    .line 570
    iget-object v1, p0, Lcom/android/internal/app/ActionBarImpl;->mSelectedTab:Lcom/android/internal/app/ActionBarImpl$TabImpl;

    invoke-virtual {v1}, Lcom/android/internal/app/ActionBarImpl$TabImpl;->getCallback()Landroid/app/ActionBar$TabListener;

    move-result-object v1

    iget-object v2, p0, Lcom/android/internal/app/ActionBarImpl;->mSelectedTab:Lcom/android/internal/app/ActionBarImpl$TabImpl;

    invoke-interface {v1, v2, v0}, Landroid/app/ActionBar$TabListener;->onTabSelected(Landroid/app/ActionBar$Tab;Landroid/app/FragmentTransaction;)V

    goto :goto_3b
.end method

.method public setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
    .registers 3
    .parameter "d"

    .prologue
    .line 406
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mContainerView:Lcom/android/internal/widget/ActionBarContainer;

    invoke-virtual {v0, p1}, Lcom/android/internal/widget/ActionBarContainer;->setPrimaryBackground(Landroid/graphics/drawable/Drawable;)V

    .line 407
    return-void
.end method

.method public setCustomView(I)V
    .registers 5
    .parameter "resId"

    .prologue
    .line 310
    invoke-virtual {p0}, Lcom/android/internal/app/ActionBarImpl;->getThemedContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    iget-object v1, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    const/4 v2, 0x0

    invoke-virtual {v0, p1, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/android/internal/app/ActionBarImpl;->setCustomView(Landroid/view/View;)V

    .line 311
    return-void
.end method

.method public setCustomView(Landroid/view/View;)V
    .registers 3
    .parameter "view"

    .prologue
    .line 1092
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    invoke-virtual {v0, p1}, Lcom/android/internal/widget/ActionBarView;->setCustomNavigationView(Landroid/view/View;)V

    .line 1093
    return-void
.end method

.method public setCustomView(Landroid/view/View;Landroid/app/ActionBar$LayoutParams;)V
    .registers 4
    .parameter "view"
    .parameter "layoutParams"

    .prologue
    .line 1097
    invoke-virtual {p1, p2}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 1098
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    invoke-virtual {v0, p1}, Lcom/android/internal/widget/ActionBarView;->setCustomNavigationView(Landroid/view/View;)V

    .line 1099
    return-void
.end method

.method public setDefaultDisplayHomeAsUpEnabled(Z)V
    .registers 3
    .parameter "enable"

    .prologue
    .line 1193
    iget-boolean v0, p0, Lcom/android/internal/app/ActionBarImpl;->mDisplayHomeAsUpSet:Z

    if-nez v0, :cond_7

    .line 1194
    invoke-virtual {p0, p1}, Lcom/android/internal/app/ActionBarImpl;->setDisplayHomeAsUpEnabled(Z)V

    .line 1196
    :cond_7
    return-void
.end method

.method public setDisplayHomeAsUpEnabled(Z)V
    .registers 4
    .parameter "showHomeAsUp"

    .prologue
    const/4 v1, 0x4

    .line 325
    if-eqz p1, :cond_8

    move v0, v1

    :goto_4
    invoke-virtual {p0, v0, v1}, Lcom/android/internal/app/ActionBarImpl;->setDisplayOptions(II)V

    .line 326
    return-void

    .line 325
    :cond_8
    const/4 v0, 0x0

    goto :goto_4
.end method

.method public setDisplayOptions(I)V
    .registers 3
    .parameter "options"

    .prologue
    .line 391
    and-int/lit8 v0, p1, 0x4

    if-eqz v0, :cond_7

    .line 392
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/internal/app/ActionBarImpl;->mDisplayHomeAsUpSet:Z

    .line 394
    :cond_7
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    invoke-virtual {v0, p1}, Lcom/android/internal/widget/ActionBarView;->setDisplayOptions(I)V

    .line 395
    return-void
.end method

.method public setDisplayOptions(II)V
    .registers 7
    .parameter "options"
    .parameter "mask"

    .prologue
    .line 398
    iget-object v1, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    invoke-virtual {v1}, Lcom/android/internal/widget/ActionBarView;->getDisplayOptions()I

    move-result v0

    .line 399
    .local v0, current:I
    and-int/lit8 v1, p2, 0x4

    if-eqz v1, :cond_d

    .line 400
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/android/internal/app/ActionBarImpl;->mDisplayHomeAsUpSet:Z

    .line 402
    :cond_d
    iget-object v1, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    and-int v2, p1, p2

    xor-int/lit8 v3, p2, -0x1

    and-int/2addr v3, v0

    or-int/2addr v2, v3

    invoke-virtual {v1, v2}, Lcom/android/internal/widget/ActionBarView;->setDisplayOptions(I)V

    .line 403
    return-void
.end method

.method public setDisplayShowCustomEnabled(Z)V
    .registers 4
    .parameter "showCustom"

    .prologue
    const/16 v1, 0x10

    .line 335
    if-eqz p1, :cond_9

    move v0, v1

    :goto_5
    invoke-virtual {p0, v0, v1}, Lcom/android/internal/app/ActionBarImpl;->setDisplayOptions(II)V

    .line 336
    return-void

    .line 335
    :cond_9
    const/4 v0, 0x0

    goto :goto_5
.end method

.method public setDisplayShowHomeEnabled(Z)V
    .registers 4
    .parameter "showHome"

    .prologue
    const/4 v1, 0x2

    .line 320
    if-eqz p1, :cond_8

    move v0, v1

    :goto_4
    invoke-virtual {p0, v0, v1}, Lcom/android/internal/app/ActionBarImpl;->setDisplayOptions(II)V

    .line 321
    return-void

    .line 320
    :cond_8
    const/4 v0, 0x0

    goto :goto_4
.end method

.method public setDisplayShowTitleEnabled(Z)V
    .registers 4
    .parameter "showTitle"

    .prologue
    const/16 v1, 0x8

    .line 330
    if-eqz p1, :cond_9

    move v0, v1

    :goto_5
    invoke-virtual {p0, v0, v1}, Lcom/android/internal/app/ActionBarImpl;->setDisplayOptions(II)V

    .line 331
    return-void

    .line 330
    :cond_9
    const/4 v0, 0x0

    goto :goto_5
.end method

.method public setDisplayUseLogoEnabled(Z)V
    .registers 4
    .parameter "useLogo"

    .prologue
    const/4 v1, 0x1

    .line 315
    if-eqz p1, :cond_8

    move v0, v1

    :goto_4
    invoke-virtual {p0, v0, v1}, Lcom/android/internal/app/ActionBarImpl;->setDisplayOptions(II)V

    .line 316
    return-void

    .line 315
    :cond_8
    const/4 v0, 0x0

    goto :goto_4
.end method

.method public setHomeButtonEnabled(Z)V
    .registers 3
    .parameter "enable"

    .prologue
    .line 340
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    invoke-virtual {v0, p1}, Lcom/android/internal/widget/ActionBarView;->setHomeButtonEnabled(Z)V

    .line 341
    return-void
.end method

.method public setIcon(I)V
    .registers 3
    .parameter "resId"

    .prologue
    .line 1174
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    invoke-virtual {v0, p1}, Lcom/android/internal/widget/ActionBarView;->setIcon(I)V

    .line 1175
    return-void
.end method

.method public setIcon(Landroid/graphics/drawable/Drawable;)V
    .registers 3
    .parameter "icon"

    .prologue
    .line 1179
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    invoke-virtual {v0, p1}, Lcom/android/internal/widget/ActionBarView;->setIcon(Landroid/graphics/drawable/Drawable;)V

    .line 1180
    return-void
.end method

.method public setListNavigationCallbacks(Landroid/widget/SpinnerAdapter;Landroid/app/ActionBar$OnNavigationListener;)V
    .registers 4
    .parameter "adapter"
    .parameter "callback"

    .prologue
    .line 1103
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    invoke-virtual {v0, p1}, Lcom/android/internal/widget/ActionBarView;->setDropdownAdapter(Landroid/widget/SpinnerAdapter;)V

    .line 1104
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    invoke-virtual {v0, p2}, Lcom/android/internal/widget/ActionBarView;->setCallback(Landroid/app/ActionBar$OnNavigationListener;)V

    .line 1105
    return-void
.end method

.method public setLogo(I)V
    .registers 3
    .parameter "resId"

    .prologue
    .line 1184
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    invoke-virtual {v0, p1}, Lcom/android/internal/widget/ActionBarView;->setLogo(I)V

    .line 1185
    return-void
.end method

.method public setLogo(Landroid/graphics/drawable/Drawable;)V
    .registers 3
    .parameter "logo"

    .prologue
    .line 1189
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    invoke-virtual {v0, p1}, Lcom/android/internal/widget/ActionBarView;->setLogo(Landroid/graphics/drawable/Drawable;)V

    .line 1190
    return-void
.end method

.method public setNavigationMode(I)V
    .registers 7
    .parameter "mode"

    .prologue
    const/4 v1, 0x0

    const/4 v4, -0x1

    .line 1139
    iget-object v2, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    invoke-virtual {v2}, Lcom/android/internal/widget/ActionBarView;->getNavigationMode()I

    move-result v0

    .line 1140
    .local v0, oldMode:I
    packed-switch v0, :pswitch_data_56

    .line 1147
    :goto_b
    if-eq v0, p1, :cond_1a

    iget-boolean v2, p0, Lcom/android/internal/app/ActionBarImpl;->mHasEmbeddedTabs:Z

    if-nez v2, :cond_1a

    .line 1148
    iget-object v2, p0, Lcom/android/internal/app/ActionBarImpl;->mOverlayLayout:Lcom/android/internal/widget/ActionBarOverlayLayout;

    if-eqz v2, :cond_1a

    .line 1149
    iget-object v2, p0, Lcom/android/internal/app/ActionBarImpl;->mOverlayLayout:Lcom/android/internal/widget/ActionBarOverlayLayout;

    invoke-virtual {v2}, Lcom/android/internal/widget/ActionBarOverlayLayout;->requestFitSystemWindows()V

    .line 1152
    :cond_1a
    iget-object v2, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    invoke-virtual {v2, p1}, Lcom/android/internal/widget/ActionBarView;->setNavigationMode(I)V

    .line 1153
    packed-switch p1, :pswitch_data_5c

    .line 1163
    :cond_22
    :goto_22
    iget-object v2, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    const/4 v3, 0x2

    if-ne p1, v3, :cond_2c

    iget-boolean v3, p0, Lcom/android/internal/app/ActionBarImpl;->mHasEmbeddedTabs:Z

    if-nez v3, :cond_2c

    const/4 v1, 0x1

    :cond_2c
    invoke-virtual {v2, v1}, Lcom/android/internal/widget/ActionBarView;->setCollapsable(Z)V

    .line 1164
    return-void

    .line 1142
    :pswitch_30
    invoke-virtual {p0}, Lcom/android/internal/app/ActionBarImpl;->getSelectedNavigationIndex()I

    move-result v2

    iput v2, p0, Lcom/android/internal/app/ActionBarImpl;->mSavedTabPosition:I

    .line 1143
    const/4 v2, 0x0

    invoke-virtual {p0, v2}, Lcom/android/internal/app/ActionBarImpl;->selectTab(Landroid/app/ActionBar$Tab;)V

    .line 1144
    iget-object v2, p0, Lcom/android/internal/app/ActionBarImpl;->mTabScrollView:Lcom/android/internal/widget/ScrollingTabContainerView;

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Lcom/android/internal/widget/ScrollingTabContainerView;->setVisibility(I)V

    goto :goto_b

    .line 1155
    :pswitch_42
    invoke-direct {p0}, Lcom/android/internal/app/ActionBarImpl;->ensureTabsExist()V

    .line 1156
    iget-object v2, p0, Lcom/android/internal/app/ActionBarImpl;->mTabScrollView:Lcom/android/internal/widget/ScrollingTabContainerView;

    invoke-virtual {v2, v1}, Lcom/android/internal/widget/ScrollingTabContainerView;->setVisibility(I)V

    .line 1157
    iget v2, p0, Lcom/android/internal/app/ActionBarImpl;->mSavedTabPosition:I

    if-eq v2, v4, :cond_22

    .line 1158
    iget v2, p0, Lcom/android/internal/app/ActionBarImpl;->mSavedTabPosition:I

    invoke-virtual {p0, v2}, Lcom/android/internal/app/ActionBarImpl;->setSelectedNavigationItem(I)V

    .line 1159
    iput v4, p0, Lcom/android/internal/app/ActionBarImpl;->mSavedTabPosition:I

    goto :goto_22

    .line 1140
    :pswitch_data_56
    .packed-switch 0x2
        :pswitch_30
    .end packed-switch

    .line 1153
    :pswitch_data_5c
    .packed-switch 0x2
        :pswitch_42
    .end packed-switch
.end method

.method public setSelectedNavigationItem(I)V
    .registers 4
    .parameter "position"

    .prologue
    .line 354
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    invoke-virtual {v0}, Lcom/android/internal/widget/ActionBarView;->getNavigationMode()I

    move-result v0

    packed-switch v0, :pswitch_data_24

    .line 362
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "setSelectedNavigationIndex not valid for current navigation mode"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 356
    :pswitch_12
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mTabs:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/ActionBar$Tab;

    invoke-virtual {p0, v0}, Lcom/android/internal/app/ActionBarImpl;->selectTab(Landroid/app/ActionBar$Tab;)V

    .line 365
    :goto_1d
    return-void

    .line 359
    :pswitch_1e
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    invoke-virtual {v0, p1}, Lcom/android/internal/widget/ActionBarView;->setDropdownSelectedPosition(I)V

    goto :goto_1d

    .line 354
    :pswitch_data_24
    .packed-switch 0x1
        :pswitch_1e
        :pswitch_12
    .end packed-switch
.end method

.method public setShowHideAnimationEnabled(Z)V
    .registers 3
    .parameter "enabled"

    .prologue
    .line 282
    iput-boolean p1, p0, Lcom/android/internal/app/ActionBarImpl;->mShowHideAnimationEnabled:Z

    .line 283
    if-nez p1, :cond_d

    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mCurrentShowAnim:Landroid/animation/Animator;

    if-eqz v0, :cond_d

    .line 284
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mCurrentShowAnim:Landroid/animation/Animator;

    invoke-virtual {v0}, Landroid/animation/Animator;->end()V

    .line 286
    :cond_d
    return-void
.end method

.method public setSplitBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
    .registers 3
    .parameter "d"

    .prologue
    .line 414
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mSplitView:Lcom/android/internal/widget/ActionBarContainer;

    if-eqz v0, :cond_9

    .line 415
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mSplitView:Lcom/android/internal/widget/ActionBarContainer;

    invoke-virtual {v0, p1}, Lcom/android/internal/widget/ActionBarContainer;->setSplitBackground(Landroid/graphics/drawable/Drawable;)V

    .line 417
    :cond_9
    return-void
.end method

.method public setStackedBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
    .registers 3
    .parameter "d"

    .prologue
    .line 410
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mContainerView:Lcom/android/internal/widget/ActionBarContainer;

    invoke-virtual {v0, p1}, Lcom/android/internal/widget/ActionBarContainer;->setStackedBackground(Landroid/graphics/drawable/Drawable;)V

    .line 411
    return-void
.end method

.method public setSubtitle(I)V
    .registers 3
    .parameter "resId"

    .prologue
    .line 350
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mContext:Landroid/content/Context;

    invoke-virtual {v0, p1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/android/internal/app/ActionBarImpl;->setSubtitle(Ljava/lang/CharSequence;)V

    .line 351
    return-void
.end method

.method public setSubtitle(Ljava/lang/CharSequence;)V
    .registers 3
    .parameter "subtitle"

    .prologue
    .line 387
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    invoke-virtual {v0, p1}, Lcom/android/internal/widget/ActionBarView;->setSubtitle(Ljava/lang/CharSequence;)V

    .line 388
    return-void
.end method

.method public setTitle(I)V
    .registers 3
    .parameter "resId"

    .prologue
    .line 345
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mContext:Landroid/content/Context;

    invoke-virtual {v0, p1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/android/internal/app/ActionBarImpl;->setTitle(Ljava/lang/CharSequence;)V

    .line 346
    return-void
.end method

.method public setTitle(Ljava/lang/CharSequence;)V
    .registers 3
    .parameter "title"

    .prologue
    .line 383
    iget-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mActionView:Lcom/android/internal/widget/ActionBarView;

    invoke-virtual {v0, p1}, Lcom/android/internal/widget/ActionBarView;->setTitle(Ljava/lang/CharSequence;)V

    .line 384
    return-void
.end method

.method public setWindowVisibility(I)V
    .registers 2
    .parameter "visibility"

    .prologue
    .line 271
    iput p1, p0, Lcom/android/internal/app/ActionBarImpl;->mCurWindowVisibility:I

    .line 272
    return-void
.end method

.method public show()V
    .registers 3

    .prologue
    const/4 v1, 0x0

    .line 591
    iget-boolean v0, p0, Lcom/android/internal/app/ActionBarImpl;->mHiddenByApp:Z

    if-eqz v0, :cond_a

    .line 592
    iput-boolean v1, p0, Lcom/android/internal/app/ActionBarImpl;->mHiddenByApp:Z

    .line 593
    invoke-direct {p0, v1}, Lcom/android/internal/app/ActionBarImpl;->updateVisibility(Z)V

    .line 595
    :cond_a
    return-void
.end method

.method public showForSystem()V
    .registers 2

    .prologue
    .line 608
    iget-boolean v0, p0, Lcom/android/internal/app/ActionBarImpl;->mHiddenBySystem:Z

    if-eqz v0, :cond_b

    .line 609
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/internal/app/ActionBarImpl;->mHiddenBySystem:Z

    .line 610
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/android/internal/app/ActionBarImpl;->updateVisibility(Z)V

    .line 612
    :cond_b
    return-void
.end method

.method public startActionMode(Landroid/view/ActionMode$Callback;)Landroid/view/ActionMode;
    .registers 5
    .parameter "callback"

    .prologue
    const/4 v2, 0x1

    .line 440
    iget-object v1, p0, Lcom/android/internal/app/ActionBarImpl;->mActionMode:Lcom/android/internal/app/ActionBarImpl$ActionModeImpl;

    if-eqz v1, :cond_a

    .line 441
    iget-object v1, p0, Lcom/android/internal/app/ActionBarImpl;->mActionMode:Lcom/android/internal/app/ActionBarImpl$ActionModeImpl;

    invoke-virtual {v1}, Lcom/android/internal/app/ActionBarImpl$ActionModeImpl;->finish()V

    .line 444
    :cond_a
    iget-object v1, p0, Lcom/android/internal/app/ActionBarImpl;->mContextView:Lcom/android/internal/widget/ActionBarContextView;

    invoke-virtual {v1}, Lcom/android/internal/widget/ActionBarContextView;->killMode()V

    .line 445
    new-instance v0, Lcom/android/internal/app/ActionBarImpl$ActionModeImpl;

    invoke-direct {v0, p0, p1}, Lcom/android/internal/app/ActionBarImpl$ActionModeImpl;-><init>(Lcom/android/internal/app/ActionBarImpl;Landroid/view/ActionMode$Callback;)V

    .line 446
    .local v0, mode:Lcom/android/internal/app/ActionBarImpl$ActionModeImpl;
    invoke-virtual {v0}, Lcom/android/internal/app/ActionBarImpl$ActionModeImpl;->dispatchOnCreate()Z

    move-result v1

    if-eqz v1, :cond_4e

    .line 447
    invoke-virtual {v0}, Lcom/android/internal/app/ActionBarImpl$ActionModeImpl;->invalidate()V

    .line 448
    iget-object v1, p0, Lcom/android/internal/app/ActionBarImpl;->mContextView:Lcom/android/internal/widget/ActionBarContextView;

    invoke-virtual {v1, v0}, Lcom/android/internal/widget/ActionBarContextView;->initForMode(Landroid/view/ActionMode;)V

    .line 449
    invoke-virtual {p0, v2}, Lcom/android/internal/app/ActionBarImpl;->animateToMode(Z)V

    .line 450
    iget-object v1, p0, Lcom/android/internal/app/ActionBarImpl;->mSplitView:Lcom/android/internal/widget/ActionBarContainer;

    if-eqz v1, :cond_44

    iget v1, p0, Lcom/android/internal/app/ActionBarImpl;->mContextDisplayMode:I

    if-ne v1, v2, :cond_44

    .line 452
    iget-object v1, p0, Lcom/android/internal/app/ActionBarImpl;->mSplitView:Lcom/android/internal/widget/ActionBarContainer;

    invoke-virtual {v1}, Lcom/android/internal/widget/ActionBarContainer;->getVisibility()I

    move-result v1

    if-eqz v1, :cond_44

    .line 453
    iget-object v1, p0, Lcom/android/internal/app/ActionBarImpl;->mSplitView:Lcom/android/internal/widget/ActionBarContainer;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/android/internal/widget/ActionBarContainer;->setVisibility(I)V

    .line 454
    iget-object v1, p0, Lcom/android/internal/app/ActionBarImpl;->mOverlayLayout:Lcom/android/internal/widget/ActionBarOverlayLayout;

    if-eqz v1, :cond_44

    .line 455
    iget-object v1, p0, Lcom/android/internal/app/ActionBarImpl;->mOverlayLayout:Lcom/android/internal/widget/ActionBarOverlayLayout;

    invoke-virtual {v1}, Lcom/android/internal/widget/ActionBarOverlayLayout;->requestFitSystemWindows()V

    .line 459
    :cond_44
    iget-object v1, p0, Lcom/android/internal/app/ActionBarImpl;->mContextView:Lcom/android/internal/widget/ActionBarContextView;

    const/16 v2, 0x20

    invoke-virtual {v1, v2}, Lcom/android/internal/widget/ActionBarContextView;->sendAccessibilityEvent(I)V

    .line 460
    iput-object v0, p0, Lcom/android/internal/app/ActionBarImpl;->mActionMode:Lcom/android/internal/app/ActionBarImpl$ActionModeImpl;

    .line 463
    .end local v0           #mode:Lcom/android/internal/app/ActionBarImpl$ActionModeImpl;
    :goto_4d
    return-object v0

    .restart local v0       #mode:Lcom/android/internal/app/ActionBarImpl$ActionModeImpl;
    :cond_4e
    const/4 v0, 0x0

    goto :goto_4d
.end method
