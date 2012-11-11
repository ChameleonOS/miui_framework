.class public Landroid/widget/MiuiMovieController;
.super Landroid/widget/FrameLayout;
.source "MiuiMovieController.java"

# interfaces
.implements Landroid/widget/MiuiMediaController;
.implements Landroid/view/View$OnClickListener;
.implements Landroid/view/animation/Animation$AnimationListener;
.implements Landroid/widget/MiuiMediaTimeBar$ScrubbingListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/widget/MiuiMovieController$State;
    }
.end annotation


# static fields
.field private static final ERROR_MESSAGE_RELATIVE_PADDING:F = 0.16666667f


# instance fields
.field private final background:Landroid/view/View;

.field private canReplay:Z

.field private final errorView:Landroid/widget/TextView;

.field private final handler:Landroid/os/Handler;

.field private hidden:Z

.field private final hideAnimation:Landroid/view/animation/Animation;

.field private final loadingView:Landroid/widget/LinearLayout;

.field private mControlListener:Landroid/widget/MiuiMediaController$OnControllerChangedListener;

.field private mainView:Landroid/view/View;

.field private final playPauseReplayView:Landroid/widget/ImageView;

.field private final startHidingRunnable:Ljava/lang/Runnable;

.field private state:Landroid/widget/MiuiMovieController$State;

.field private final timeBar:Landroid/widget/MiuiMediaTimeBar;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .registers 12
    .parameter "context"

    .prologue
    const/4 v6, -0x2

    const/4 v9, -0x1

    const/4 v8, 0x1

    invoke-direct {p0, p1}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    iput-boolean v8, p0, Landroid/widget/MiuiMovieController;->canReplay:Z

    sget-object v5, Landroid/widget/MiuiMovieController$State;->LOADING:Landroid/widget/MiuiMovieController$State;

    iput-object v5, p0, Landroid/widget/MiuiMovieController;->state:Landroid/widget/MiuiMovieController$State;

    new-instance v4, Landroid/widget/FrameLayout$LayoutParams;

    invoke-direct {v4, v6, v6}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    .local v4, wrapContent:Landroid/widget/FrameLayout$LayoutParams;
    new-instance v1, Landroid/widget/FrameLayout$LayoutParams;

    invoke-direct {v1, v9, v9}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    .local v1, matchParent:Landroid/widget/FrameLayout$LayoutParams;
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .local v0, inflater:Landroid/view/LayoutInflater;
    new-instance v5, Landroid/view/View;

    invoke-direct {v5, p1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    iput-object v5, p0, Landroid/widget/MiuiMovieController;->background:Landroid/view/View;

    iget-object v5, p0, Landroid/widget/MiuiMovieController;->background:Landroid/view/View;

    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const v7, 0x6070021

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getColor(I)I

    move-result v6

    invoke-virtual {v5, v6}, Landroid/view/View;->setBackgroundColor(I)V

    iget-object v5, p0, Landroid/widget/MiuiMovieController;->background:Landroid/view/View;

    invoke-virtual {p0, v5, v1}, Landroid/widget/MiuiMovieController;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    new-instance v5, Landroid/widget/MiuiMediaTimeBar;

    invoke-direct {v5, p1, p0}, Landroid/widget/MiuiMediaTimeBar;-><init>(Landroid/content/Context;Landroid/widget/MiuiMediaTimeBar$ScrubbingListener;)V

    iput-object v5, p0, Landroid/widget/MiuiMovieController;->timeBar:Landroid/widget/MiuiMediaTimeBar;

    iget-object v5, p0, Landroid/widget/MiuiMovieController;->timeBar:Landroid/widget/MiuiMediaTimeBar;

    invoke-virtual {p0, v5, v4}, Landroid/widget/MiuiMovieController;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    new-instance v5, Landroid/widget/LinearLayout;

    invoke-direct {v5, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    iput-object v5, p0, Landroid/widget/MiuiMovieController;->loadingView:Landroid/widget/LinearLayout;

    iget-object v5, p0, Landroid/widget/MiuiMovieController;->loadingView:Landroid/widget/LinearLayout;

    invoke-virtual {v5, v8}, Landroid/widget/LinearLayout;->setOrientation(I)V

    iget-object v5, p0, Landroid/widget/MiuiMovieController;->loadingView:Landroid/widget/LinearLayout;

    invoke-virtual {v5, v8}, Landroid/widget/LinearLayout;->setGravity(I)V

    new-instance v3, Landroid/widget/ProgressBar;

    invoke-direct {v3, p1}, Landroid/widget/ProgressBar;-><init>(Landroid/content/Context;)V

    .local v3, spinner:Landroid/widget/ProgressBar;
    invoke-virtual {v3, v8}, Landroid/widget/ProgressBar;->setIndeterminate(Z)V

    iget-object v5, p0, Landroid/widget/MiuiMovieController;->loadingView:Landroid/widget/LinearLayout;

    invoke-virtual {v5, v3, v4}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    iget-object v5, p0, Landroid/widget/MiuiMovieController;->loadingView:Landroid/widget/LinearLayout;

    invoke-virtual {p0, v5, v4}, Landroid/widget/MiuiMovieController;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    new-instance v5, Landroid/widget/ImageView;

    invoke-direct {v5, p1}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    iput-object v5, p0, Landroid/widget/MiuiMovieController;->playPauseReplayView:Landroid/widget/ImageView;

    iget-object v5, p0, Landroid/widget/MiuiMovieController;->playPauseReplayView:Landroid/widget/ImageView;

    const v6, 0x602004f

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setImageResource(I)V

    iget-object v5, p0, Landroid/widget/MiuiMovieController;->playPauseReplayView:Landroid/widget/ImageView;

    const v6, 0x6020052

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    iget-object v5, p0, Landroid/widget/MiuiMovieController;->playPauseReplayView:Landroid/widget/ImageView;

    sget-object v6, Landroid/widget/ImageView$ScaleType;->CENTER:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    iget-object v5, p0, Landroid/widget/MiuiMovieController;->playPauseReplayView:Landroid/widget/ImageView;

    invoke-virtual {v5, v8}, Landroid/widget/ImageView;->setFocusable(Z)V

    iget-object v5, p0, Landroid/widget/MiuiMovieController;->playPauseReplayView:Landroid/widget/ImageView;

    invoke-virtual {v5, v8}, Landroid/widget/ImageView;->setClickable(Z)V

    iget-object v5, p0, Landroid/widget/MiuiMovieController;->playPauseReplayView:Landroid/widget/ImageView;

    invoke-virtual {v5, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    iget-object v5, p0, Landroid/widget/MiuiMovieController;->playPauseReplayView:Landroid/widget/ImageView;

    invoke-virtual {p0, v5, v4}, Landroid/widget/MiuiMovieController;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    new-instance v5, Landroid/widget/TextView;

    invoke-direct {v5, p1}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    iput-object v5, p0, Landroid/widget/MiuiMovieController;->errorView:Landroid/widget/TextView;

    iget-object v5, p0, Landroid/widget/MiuiMovieController;->errorView:Landroid/widget/TextView;

    const/16 v6, 0x11

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setGravity(I)V

    iget-object v5, p0, Landroid/widget/MiuiMovieController;->errorView:Landroid/widget/TextView;

    const/high16 v6, -0x3400

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setBackgroundColor(I)V

    iget-object v5, p0, Landroid/widget/MiuiMovieController;->errorView:Landroid/widget/TextView;

    invoke-virtual {v5, v9}, Landroid/widget/TextView;->setTextColor(I)V

    iget-object v5, p0, Landroid/widget/MiuiMovieController;->errorView:Landroid/widget/TextView;

    invoke-virtual {p0, v5, v1}, Landroid/widget/MiuiMovieController;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    new-instance v5, Landroid/os/Handler;

    invoke-direct {v5}, Landroid/os/Handler;-><init>()V

    iput-object v5, p0, Landroid/widget/MiuiMovieController;->handler:Landroid/os/Handler;

    new-instance v5, Landroid/widget/MiuiMovieController$1;

    invoke-direct {v5, p0}, Landroid/widget/MiuiMovieController$1;-><init>(Landroid/widget/MiuiMovieController;)V

    iput-object v5, p0, Landroid/widget/MiuiMovieController;->startHidingRunnable:Ljava/lang/Runnable;

    const v5, 0x604000f

    invoke-static {p1, v5}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v5

    iput-object v5, p0, Landroid/widget/MiuiMovieController;->hideAnimation:Landroid/view/animation/Animation;

    iget-object v5, p0, Landroid/widget/MiuiMovieController;->hideAnimation:Landroid/view/animation/Animation;

    invoke-virtual {v5, p0}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    new-instance v2, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v2, v9, v9}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .local v2, params:Landroid/widget/RelativeLayout$LayoutParams;
    invoke-virtual {p0, v2}, Landroid/widget/MiuiMovieController;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    invoke-virtual {p0}, Landroid/widget/MiuiMovieController;->hide()V

    return-void
.end method

.method static synthetic access$000(Landroid/widget/MiuiMovieController;)V
    .registers 1
    .parameter "x0"

    .prologue
    invoke-direct {p0}, Landroid/widget/MiuiMovieController;->startHiding()V

    return-void
.end method

.method private cancelHiding()V
    .registers 4

    .prologue
    const/4 v2, 0x0

    iget-object v0, p0, Landroid/widget/MiuiMovieController;->handler:Landroid/os/Handler;

    iget-object v1, p0, Landroid/widget/MiuiMovieController;->startHidingRunnable:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    iget-object v0, p0, Landroid/widget/MiuiMovieController;->background:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setAnimation(Landroid/view/animation/Animation;)V

    iget-object v0, p0, Landroid/widget/MiuiMovieController;->timeBar:Landroid/widget/MiuiMediaTimeBar;

    invoke-virtual {v0, v2}, Landroid/widget/MiuiMediaTimeBar;->setAnimation(Landroid/view/animation/Animation;)V

    iget-object v0, p0, Landroid/widget/MiuiMovieController;->playPauseReplayView:Landroid/widget/ImageView;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setAnimation(Landroid/view/animation/Animation;)V

    return-void
.end method

.method private layoutCenteredView(Landroid/view/View;IIII)V
    .registers 12
    .parameter "view"
    .parameter "l"
    .parameter "t"
    .parameter "r"
    .parameter "b"

    .prologue
    invoke-virtual {p1}, Landroid/view/View;->getMeasuredWidth()I

    move-result v3

    .local v3, cw:I
    invoke-virtual {p1}, Landroid/view/View;->getMeasuredHeight()I

    move-result v0

    .local v0, ch:I
    sub-int v4, p4, p2

    sub-int/2addr v4, v3

    div-int/lit8 v1, v4, 0x2

    .local v1, cl:I
    sub-int v4, p5, p3

    sub-int/2addr v4, v0

    div-int/lit8 v2, v4, 0x2

    .local v2, ct:I
    add-int v4, v1, v3

    add-int v5, v2, v0

    invoke-virtual {p1, v1, v2, v4, v5}, Landroid/view/View;->layout(IIII)V

    return-void
.end method

.method private maybeStartHiding()V
    .registers 5

    .prologue
    invoke-direct {p0}, Landroid/widget/MiuiMovieController;->cancelHiding()V

    iget-object v0, p0, Landroid/widget/MiuiMovieController;->state:Landroid/widget/MiuiMovieController$State;

    sget-object v1, Landroid/widget/MiuiMovieController$State;->PLAYING:Landroid/widget/MiuiMovieController$State;

    if-ne v0, v1, :cond_12

    iget-object v0, p0, Landroid/widget/MiuiMovieController;->handler:Landroid/os/Handler;

    iget-object v1, p0, Landroid/widget/MiuiMovieController;->startHidingRunnable:Ljava/lang/Runnable;

    const-wide/16 v2, 0x5dc

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    :cond_12
    return-void
.end method

.method private showMainView(Landroid/view/View;)V
    .registers 7
    .parameter "view"

    .prologue
    const/4 v2, 0x4

    const/4 v1, 0x0

    iput-object p1, p0, Landroid/widget/MiuiMovieController;->mainView:Landroid/view/View;

    iget-object v3, p0, Landroid/widget/MiuiMovieController;->errorView:Landroid/widget/TextView;

    iget-object v0, p0, Landroid/widget/MiuiMovieController;->mainView:Landroid/view/View;

    iget-object v4, p0, Landroid/widget/MiuiMovieController;->errorView:Landroid/widget/TextView;

    if-ne v0, v4, :cond_2b

    move v0, v1

    :goto_d
    invoke-virtual {v3, v0}, Landroid/widget/TextView;->setVisibility(I)V

    iget-object v3, p0, Landroid/widget/MiuiMovieController;->loadingView:Landroid/widget/LinearLayout;

    iget-object v0, p0, Landroid/widget/MiuiMovieController;->mainView:Landroid/view/View;

    iget-object v4, p0, Landroid/widget/MiuiMovieController;->loadingView:Landroid/widget/LinearLayout;

    if-ne v0, v4, :cond_2d

    move v0, v1

    :goto_19
    invoke-virtual {v3, v0}, Landroid/widget/LinearLayout;->setVisibility(I)V

    iget-object v0, p0, Landroid/widget/MiuiMovieController;->playPauseReplayView:Landroid/widget/ImageView;

    iget-object v3, p0, Landroid/widget/MiuiMovieController;->mainView:Landroid/view/View;

    iget-object v4, p0, Landroid/widget/MiuiMovieController;->playPauseReplayView:Landroid/widget/ImageView;

    if-ne v3, v4, :cond_2f

    :goto_24
    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    invoke-virtual {p0}, Landroid/widget/MiuiMovieController;->show()V

    return-void

    :cond_2b
    move v0, v2

    goto :goto_d

    :cond_2d
    move v0, v2

    goto :goto_19

    :cond_2f
    move v1, v2

    goto :goto_24
.end method

.method private startHideAnimation(Landroid/view/View;)V
    .registers 3
    .parameter "view"

    .prologue
    invoke-virtual {p1}, Landroid/view/View;->getVisibility()I

    move-result v0

    if-nez v0, :cond_b

    iget-object v0, p0, Landroid/widget/MiuiMovieController;->hideAnimation:Landroid/view/animation/Animation;

    invoke-virtual {p1, v0}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    :cond_b
    return-void
.end method

.method private startHiding()V
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/widget/MiuiMovieController;->timeBar:Landroid/widget/MiuiMediaTimeBar;

    invoke-direct {p0, v0}, Landroid/widget/MiuiMovieController;->startHideAnimation(Landroid/view/View;)V

    iget-object v0, p0, Landroid/widget/MiuiMovieController;->playPauseReplayView:Landroid/widget/ImageView;

    invoke-direct {p0, v0}, Landroid/widget/MiuiMovieController;->startHideAnimation(Landroid/view/View;)V

    return-void
.end method

.method private updateViews()V
    .registers 5

    .prologue
    const/4 v1, 0x0

    iget-boolean v0, p0, Landroid/widget/MiuiMovieController;->hidden:Z

    if-eqz v0, :cond_6

    :goto_5
    return-void

    :cond_6
    iget-object v0, p0, Landroid/widget/MiuiMovieController;->background:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    iget-object v0, p0, Landroid/widget/MiuiMovieController;->timeBar:Landroid/widget/MiuiMediaTimeBar;

    invoke-virtual {v0, v1}, Landroid/widget/MiuiMediaTimeBar;->setVisibility(I)V

    iget-object v2, p0, Landroid/widget/MiuiMovieController;->playPauseReplayView:Landroid/widget/ImageView;

    iget-object v0, p0, Landroid/widget/MiuiMovieController;->state:Landroid/widget/MiuiMovieController$State;

    sget-object v3, Landroid/widget/MiuiMovieController$State;->PAUSED:Landroid/widget/MiuiMovieController$State;

    if-ne v0, v3, :cond_3e

    const v0, 0x602004f

    :goto_1b
    invoke-virtual {v2, v0}, Landroid/widget/ImageView;->setImageResource(I)V

    iget-object v2, p0, Landroid/widget/MiuiMovieController;->playPauseReplayView:Landroid/widget/ImageView;

    iget-object v0, p0, Landroid/widget/MiuiMovieController;->state:Landroid/widget/MiuiMovieController$State;

    sget-object v3, Landroid/widget/MiuiMovieController$State;->LOADING:Landroid/widget/MiuiMovieController$State;

    if-eq v0, v3, :cond_4c

    iget-object v0, p0, Landroid/widget/MiuiMovieController;->state:Landroid/widget/MiuiMovieController$State;

    sget-object v3, Landroid/widget/MiuiMovieController$State;->ERROR:Landroid/widget/MiuiMovieController$State;

    if-eq v0, v3, :cond_4c

    iget-object v0, p0, Landroid/widget/MiuiMovieController;->state:Landroid/widget/MiuiMovieController$State;

    sget-object v3, Landroid/widget/MiuiMovieController$State;->ENDED:Landroid/widget/MiuiMovieController$State;

    if-ne v0, v3, :cond_36

    iget-boolean v0, p0, Landroid/widget/MiuiMovieController;->canReplay:Z

    if-eqz v0, :cond_4c

    :cond_36
    move v0, v1

    :goto_37
    invoke-virtual {v2, v0}, Landroid/widget/ImageView;->setVisibility(I)V

    invoke-virtual {p0}, Landroid/widget/MiuiMovieController;->requestLayout()V

    goto :goto_5

    :cond_3e
    iget-object v0, p0, Landroid/widget/MiuiMovieController;->state:Landroid/widget/MiuiMovieController$State;

    sget-object v3, Landroid/widget/MiuiMovieController$State;->PLAYING:Landroid/widget/MiuiMovieController$State;

    if-ne v0, v3, :cond_48

    const v0, 0x6020050

    goto :goto_1b

    :cond_48
    const v0, 0x6020051

    goto :goto_1b

    :cond_4c
    const/16 v0, 0x8

    goto :goto_37
.end method


# virtual methods
.method public getView()Landroid/view/View;
    .registers 1

    .prologue
    return-object p0
.end method

.method public hide()V
    .registers 5

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x4

    iget-boolean v0, p0, Landroid/widget/MiuiMovieController;->hidden:Z

    .local v0, wasHidden:Z
    iput-boolean v3, p0, Landroid/widget/MiuiMovieController;->hidden:Z

    iget-object v1, p0, Landroid/widget/MiuiMovieController;->playPauseReplayView:Landroid/widget/ImageView;

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    iget-object v1, p0, Landroid/widget/MiuiMovieController;->loadingView:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    iget-object v1, p0, Landroid/widget/MiuiMovieController;->background:Landroid/view/View;

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    iget-object v1, p0, Landroid/widget/MiuiMovieController;->timeBar:Landroid/widget/MiuiMediaTimeBar;

    invoke-virtual {v1, v2}, Landroid/widget/MiuiMediaTimeBar;->setVisibility(I)V

    invoke-virtual {p0, v2}, Landroid/widget/MiuiMovieController;->setVisibility(I)V

    invoke-virtual {p0, v3}, Landroid/widget/MiuiMovieController;->setFocusable(Z)V

    invoke-virtual {p0}, Landroid/widget/MiuiMovieController;->requestFocus()Z

    iget-object v1, p0, Landroid/widget/MiuiMovieController;->mControlListener:Landroid/widget/MiuiMediaController$OnControllerChangedListener;

    if-eqz v1, :cond_30

    iget-boolean v1, p0, Landroid/widget/MiuiMovieController;->hidden:Z

    if-eq v0, v1, :cond_30

    iget-object v1, p0, Landroid/widget/MiuiMovieController;->mControlListener:Landroid/widget/MiuiMediaController$OnControllerChangedListener;

    invoke-interface {v1}, Landroid/widget/MiuiMediaController$OnControllerChangedListener;->onHidden()V

    :cond_30
    return-void
.end method

.method public isShowing()Z
    .registers 2

    .prologue
    iget-boolean v0, p0, Landroid/widget/MiuiMovieController;->hidden:Z

    if-nez v0, :cond_6

    const/4 v0, 0x1

    :goto_5
    return v0

    :cond_6
    const/4 v0, 0x0

    goto :goto_5
.end method

.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .registers 2
    .parameter "animation"

    .prologue
    invoke-virtual {p0}, Landroid/widget/MiuiMovieController;->hide()V

    return-void
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .registers 2
    .parameter "animation"

    .prologue
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .registers 2
    .parameter "animation"

    .prologue
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .registers 4
    .parameter "view"

    .prologue
    iget-object v0, p0, Landroid/widget/MiuiMovieController;->mControlListener:Landroid/widget/MiuiMediaController$OnControllerChangedListener;

    if-eqz v0, :cond_17

    iget-object v0, p0, Landroid/widget/MiuiMovieController;->playPauseReplayView:Landroid/widget/ImageView;

    if-ne p1, v0, :cond_17

    iget-object v0, p0, Landroid/widget/MiuiMovieController;->state:Landroid/widget/MiuiMovieController$State;

    sget-object v1, Landroid/widget/MiuiMovieController$State;->ENDED:Landroid/widget/MiuiMovieController$State;

    if-ne v0, v1, :cond_18

    iget-boolean v0, p0, Landroid/widget/MiuiMovieController;->canReplay:Z

    if-eqz v0, :cond_17

    iget-object v0, p0, Landroid/widget/MiuiMovieController;->mControlListener:Landroid/widget/MiuiMediaController$OnControllerChangedListener;

    invoke-interface {v0}, Landroid/widget/MiuiMediaController$OnControllerChangedListener;->onReplay()V

    :cond_17
    :goto_17
    return-void

    :cond_18
    iget-object v0, p0, Landroid/widget/MiuiMovieController;->state:Landroid/widget/MiuiMovieController$State;

    sget-object v1, Landroid/widget/MiuiMovieController$State;->PAUSED:Landroid/widget/MiuiMovieController$State;

    if-eq v0, v1, :cond_24

    iget-object v0, p0, Landroid/widget/MiuiMovieController;->state:Landroid/widget/MiuiMovieController$State;

    sget-object v1, Landroid/widget/MiuiMovieController$State;->PLAYING:Landroid/widget/MiuiMovieController$State;

    if-ne v0, v1, :cond_17

    :cond_24
    iget-object v0, p0, Landroid/widget/MiuiMovieController;->mControlListener:Landroid/widget/MiuiMediaController$OnControllerChangedListener;

    invoke-interface {v0}, Landroid/widget/MiuiMediaController$OnControllerChangedListener;->onPlayPause()V

    goto :goto_17
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .registers 4
    .parameter "keyCode"
    .parameter "event"

    .prologue
    iget-boolean v0, p0, Landroid/widget/MiuiMovieController;->hidden:Z

    if-eqz v0, :cond_7

    invoke-virtual {p0}, Landroid/widget/MiuiMovieController;->show()V

    :cond_7
    invoke-super {p0, p1, p2}, Landroid/widget/FrameLayout;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v0

    return v0
.end method

.method protected onLayout(ZIIII)V
    .registers 25
    .parameter "changed"
    .parameter "l"
    .parameter "t"
    .parameter "r"
    .parameter "b"

    .prologue
    sub-int v15, p5, p3

    .local v15, h:I
    sub-int v17, p4, p2

    .local v17, w:I
    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/widget/MiuiMovieController;->errorView:Landroid/widget/TextView;

    invoke-virtual {v4}, Landroid/widget/TextView;->getVisibility()I

    move-result v4

    if-nez v4, :cond_95

    const/4 v13, 0x1

    .local v13, error:Z
    :goto_f
    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/widget/MiuiMovieController;->timeBar:Landroid/widget/MiuiMediaTimeBar;

    invoke-virtual {v4}, Landroid/widget/MiuiMediaTimeBar;->getBarHeight()I

    move-result v11

    .local v11, bw:I
    move v10, v11

    .local v10, bh:I
    sub-int v18, p5, v10

    .local v18, y:I
    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/widget/MiuiMovieController;->background:Landroid/view/View;

    move/from16 v0, p2

    move/from16 v1, v18

    move/from16 v2, p4

    move/from16 v3, p5

    invoke-virtual {v4, v0, v1, v2, v3}, Landroid/view/View;->layout(IIII)V

    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/widget/MiuiMovieController;->timeBar:Landroid/widget/MiuiMediaTimeBar;

    move-object/from16 v0, p0

    iget-object v5, v0, Landroid/widget/MiuiMovieController;->timeBar:Landroid/widget/MiuiMediaTimeBar;

    invoke-virtual {v5}, Landroid/widget/MiuiMediaTimeBar;->getPreferredHeight()I

    move-result v5

    sub-int v5, p5, v5

    move/from16 v0, p2

    move/from16 v1, p4

    move/from16 v2, p5

    invoke-virtual {v4, v0, v5, v1, v2}, Landroid/widget/MiuiMediaTimeBar;->layout(IIII)V

    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/widget/MiuiMovieController;->timeBar:Landroid/widget/MiuiMediaTimeBar;

    invoke-virtual {v4}, Landroid/widget/MiuiMediaTimeBar;->requestLayout()V

    div-int/lit8 v4, v17, 0x2

    add-int v12, p2, v4

    .local v12, cx:I
    div-int/lit8 v4, v15, 0x2

    add-int v16, p3, v4

    .local v16, playbackButtonsCenterline:I
    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/widget/MiuiMovieController;->playPauseReplayView:Landroid/widget/ImageView;

    invoke-virtual {v4}, Landroid/widget/ImageView;->getMeasuredWidth()I

    move-result v11

    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/widget/MiuiMovieController;->playPauseReplayView:Landroid/widget/ImageView;

    invoke-virtual {v4}, Landroid/widget/ImageView;->getMeasuredHeight()I

    move-result v10

    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/widget/MiuiMovieController;->playPauseReplayView:Landroid/widget/ImageView;

    div-int/lit8 v5, v11, 0x2

    sub-int v5, v12, v5

    div-int/lit8 v6, v10, 0x2

    sub-int v6, v16, v6

    div-int/lit8 v7, v11, 0x2

    add-int/2addr v7, v12

    div-int/lit8 v8, v10, 0x2

    add-int v8, v8, v16

    invoke-virtual {v4, v5, v6, v7, v8}, Landroid/widget/ImageView;->layout(IIII)V

    move/from16 v0, v17

    int-to-float v4, v0

    const v5, 0x3e2aaaab

    mul-float/2addr v4, v5

    float-to-int v14, v4

    .local v14, errorMessagePadding:I
    move-object/from16 v0, p0

    iget-object v4, v0, Landroid/widget/MiuiMovieController;->mainView:Landroid/view/View;

    if-eqz v4, :cond_94

    move-object/from16 v0, p0

    iget-object v5, v0, Landroid/widget/MiuiMovieController;->mainView:Landroid/view/View;

    move-object/from16 v4, p0

    move/from16 v6, p2

    move/from16 v7, p3

    move/from16 v8, p4

    move/from16 v9, p5

    invoke-direct/range {v4 .. v9}, Landroid/widget/MiuiMovieController;->layoutCenteredView(Landroid/view/View;IIII)V

    :cond_94
    return-void

    .end local v10           #bh:I
    .end local v11           #bw:I
    .end local v12           #cx:I
    .end local v13           #error:Z
    .end local v14           #errorMessagePadding:I
    .end local v16           #playbackButtonsCenterline:I
    .end local v18           #y:I
    :cond_95
    const/4 v13, 0x0

    goto/16 :goto_f
.end method

.method protected onMeasure(II)V
    .registers 3
    .parameter "widthMeasureSpec"
    .parameter "heightMeasureSpec"

    .prologue
    invoke-super {p0, p1, p2}, Landroid/widget/FrameLayout;->onMeasure(II)V

    invoke-virtual {p0, p1, p2}, Landroid/widget/MiuiMovieController;->measureChildren(II)V

    return-void
.end method

.method public onScrubbingEnd(I)V
    .registers 3
    .parameter "time"

    .prologue
    invoke-direct {p0}, Landroid/widget/MiuiMovieController;->maybeStartHiding()V

    iget-object v0, p0, Landroid/widget/MiuiMovieController;->mControlListener:Landroid/widget/MiuiMediaController$OnControllerChangedListener;

    if-eqz v0, :cond_c

    iget-object v0, p0, Landroid/widget/MiuiMovieController;->mControlListener:Landroid/widget/MiuiMediaController$OnControllerChangedListener;

    invoke-interface {v0, p1}, Landroid/widget/MiuiMediaController$OnControllerChangedListener;->onSeekEnd(I)V

    :cond_c
    return-void
.end method

.method public onScrubbingMove(I)V
    .registers 3
    .parameter "time"

    .prologue
    invoke-direct {p0}, Landroid/widget/MiuiMovieController;->cancelHiding()V

    iget-object v0, p0, Landroid/widget/MiuiMovieController;->mControlListener:Landroid/widget/MiuiMediaController$OnControllerChangedListener;

    if-eqz v0, :cond_c

    iget-object v0, p0, Landroid/widget/MiuiMovieController;->mControlListener:Landroid/widget/MiuiMediaController$OnControllerChangedListener;

    invoke-interface {v0, p1}, Landroid/widget/MiuiMediaController$OnControllerChangedListener;->onSeekMove(I)V

    :cond_c
    return-void
.end method

.method public onScrubbingStart()V
    .registers 2

    .prologue
    invoke-direct {p0}, Landroid/widget/MiuiMovieController;->cancelHiding()V

    iget-object v0, p0, Landroid/widget/MiuiMovieController;->mControlListener:Landroid/widget/MiuiMediaController$OnControllerChangedListener;

    if-eqz v0, :cond_c

    iget-object v0, p0, Landroid/widget/MiuiMovieController;->mControlListener:Landroid/widget/MiuiMediaController$OnControllerChangedListener;

    invoke-interface {v0}, Landroid/widget/MiuiMediaController$OnControllerChangedListener;->onSeekStart()V

    :cond_c
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .registers 5
    .parameter "event"

    .prologue
    const/4 v2, 0x1

    invoke-super {p0, p1}, Landroid/widget/FrameLayout;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    if-eqz v0, :cond_8

    :cond_7
    :goto_7
    return v2

    :cond_8
    iget-boolean v0, p0, Landroid/widget/MiuiMovieController;->hidden:Z

    if-eqz v0, :cond_10

    invoke-virtual {p0}, Landroid/widget/MiuiMovieController;->show()V

    goto :goto_7

    :cond_10
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    packed-switch v0, :pswitch_data_36

    goto :goto_7

    :pswitch_18
    invoke-direct {p0}, Landroid/widget/MiuiMovieController;->cancelHiding()V

    iget-object v0, p0, Landroid/widget/MiuiMovieController;->state:Landroid/widget/MiuiMovieController$State;

    sget-object v1, Landroid/widget/MiuiMovieController$State;->PLAYING:Landroid/widget/MiuiMovieController$State;

    if-eq v0, v1, :cond_27

    iget-object v0, p0, Landroid/widget/MiuiMovieController;->state:Landroid/widget/MiuiMovieController$State;

    sget-object v1, Landroid/widget/MiuiMovieController$State;->PAUSED:Landroid/widget/MiuiMovieController$State;

    if-ne v0, v1, :cond_7

    :cond_27
    iget-object v0, p0, Landroid/widget/MiuiMovieController;->mControlListener:Landroid/widget/MiuiMediaController$OnControllerChangedListener;

    if-eqz v0, :cond_7

    iget-object v0, p0, Landroid/widget/MiuiMovieController;->mControlListener:Landroid/widget/MiuiMediaController$OnControllerChangedListener;

    invoke-interface {v0}, Landroid/widget/MiuiMediaController$OnControllerChangedListener;->onPlayPause()V

    goto :goto_7

    :pswitch_31
    invoke-direct {p0}, Landroid/widget/MiuiMovieController;->maybeStartHiding()V

    goto :goto_7

    nop

    :pswitch_data_36
    .packed-switch 0x0
        :pswitch_18
        :pswitch_31
    .end packed-switch
.end method

.method public resetTime()V
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/widget/MiuiMovieController;->timeBar:Landroid/widget/MiuiMediaTimeBar;

    invoke-virtual {v0}, Landroid/widget/MiuiMediaTimeBar;->resetTime()V

    return-void
.end method

.method public setCanReplay(Z)V
    .registers 2
    .parameter "canReplay"

    .prologue
    iput-boolean p1, p0, Landroid/widget/MiuiMovieController;->canReplay:Z

    return-void
.end method

.method public setControlListener(Landroid/widget/MiuiMediaController$OnControllerChangedListener;)V
    .registers 2
    .parameter "listener"

    .prologue
    iput-object p1, p0, Landroid/widget/MiuiMovieController;->mControlListener:Landroid/widget/MiuiMediaController$OnControllerChangedListener;

    return-void
.end method

.method public setTimes(II)V
    .registers 4
    .parameter "currentTime"
    .parameter "totalTime"

    .prologue
    iget-object v0, p0, Landroid/widget/MiuiMovieController;->timeBar:Landroid/widget/MiuiMediaTimeBar;

    invoke-virtual {v0, p1, p2}, Landroid/widget/MiuiMediaTimeBar;->setTime(II)V

    return-void
.end method

.method public show()V
    .registers 3

    .prologue
    const/4 v1, 0x0

    iget-boolean v0, p0, Landroid/widget/MiuiMovieController;->hidden:Z

    .local v0, wasHidden:Z
    iput-boolean v1, p0, Landroid/widget/MiuiMovieController;->hidden:Z

    invoke-direct {p0}, Landroid/widget/MiuiMovieController;->updateViews()V

    invoke-virtual {p0, v1}, Landroid/widget/MiuiMovieController;->setVisibility(I)V

    invoke-virtual {p0, v1}, Landroid/widget/MiuiMovieController;->setFocusable(Z)V

    iget-object v1, p0, Landroid/widget/MiuiMovieController;->mControlListener:Landroid/widget/MiuiMediaController$OnControllerChangedListener;

    if-eqz v1, :cond_1b

    iget-boolean v1, p0, Landroid/widget/MiuiMovieController;->hidden:Z

    if-eq v0, v1, :cond_1b

    iget-object v1, p0, Landroid/widget/MiuiMovieController;->mControlListener:Landroid/widget/MiuiMediaController$OnControllerChangedListener;

    invoke-interface {v1}, Landroid/widget/MiuiMediaController$OnControllerChangedListener;->onShown()V

    :cond_1b
    invoke-direct {p0}, Landroid/widget/MiuiMovieController;->maybeStartHiding()V

    return-void
.end method

.method public showEnded()V
    .registers 2

    .prologue
    sget-object v0, Landroid/widget/MiuiMovieController$State;->ENDED:Landroid/widget/MiuiMovieController$State;

    iput-object v0, p0, Landroid/widget/MiuiMovieController;->state:Landroid/widget/MiuiMovieController$State;

    iget-object v0, p0, Landroid/widget/MiuiMovieController;->playPauseReplayView:Landroid/widget/ImageView;

    invoke-direct {p0, v0}, Landroid/widget/MiuiMovieController;->showMainView(Landroid/view/View;)V

    return-void
.end method

.method public showErrorMessage(Ljava/lang/String;)V
    .registers 6
    .parameter "message"

    .prologue
    const/16 v3, 0xa

    sget-object v1, Landroid/widget/MiuiMovieController$State;->ERROR:Landroid/widget/MiuiMovieController$State;

    iput-object v1, p0, Landroid/widget/MiuiMovieController;->state:Landroid/widget/MiuiMovieController$State;

    invoke-virtual {p0}, Landroid/widget/MiuiMovieController;->getMeasuredWidth()I

    move-result v1

    int-to-float v1, v1

    const v2, 0x3e2aaaab

    mul-float/2addr v1, v2

    float-to-int v0, v1

    .local v0, padding:I
    iget-object v1, p0, Landroid/widget/MiuiMovieController;->errorView:Landroid/widget/TextView;

    invoke-virtual {v1, v0, v3, v0, v3}, Landroid/widget/TextView;->setPadding(IIII)V

    iget-object v1, p0, Landroid/widget/MiuiMovieController;->errorView:Landroid/widget/TextView;

    invoke-virtual {v1, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    iget-object v1, p0, Landroid/widget/MiuiMovieController;->errorView:Landroid/widget/TextView;

    invoke-direct {p0, v1}, Landroid/widget/MiuiMovieController;->showMainView(Landroid/view/View;)V

    return-void
.end method

.method public showLoading()V
    .registers 2

    .prologue
    sget-object v0, Landroid/widget/MiuiMovieController$State;->LOADING:Landroid/widget/MiuiMovieController$State;

    iput-object v0, p0, Landroid/widget/MiuiMovieController;->state:Landroid/widget/MiuiMovieController$State;

    iget-object v0, p0, Landroid/widget/MiuiMovieController;->loadingView:Landroid/widget/LinearLayout;

    invoke-direct {p0, v0}, Landroid/widget/MiuiMovieController;->showMainView(Landroid/view/View;)V

    return-void
.end method

.method public showPaused()V
    .registers 2

    .prologue
    sget-object v0, Landroid/widget/MiuiMovieController$State;->PAUSED:Landroid/widget/MiuiMovieController$State;

    iput-object v0, p0, Landroid/widget/MiuiMovieController;->state:Landroid/widget/MiuiMovieController$State;

    iget-object v0, p0, Landroid/widget/MiuiMovieController;->playPauseReplayView:Landroid/widget/ImageView;

    invoke-direct {p0, v0}, Landroid/widget/MiuiMovieController;->showMainView(Landroid/view/View;)V

    return-void
.end method

.method public showPlaying()V
    .registers 2

    .prologue
    sget-object v0, Landroid/widget/MiuiMovieController$State;->PLAYING:Landroid/widget/MiuiMovieController$State;

    iput-object v0, p0, Landroid/widget/MiuiMovieController;->state:Landroid/widget/MiuiMovieController$State;

    iget-object v0, p0, Landroid/widget/MiuiMovieController;->playPauseReplayView:Landroid/widget/ImageView;

    invoke-direct {p0, v0}, Landroid/widget/MiuiMovieController;->showMainView(Landroid/view/View;)V

    return-void
.end method
