.class public Landroid/widget/ZoomButton;
.super Landroid/widget/ImageButton;
.source "ZoomButton.java"

# interfaces
.implements Landroid/view/View$OnLongClickListener;


# instance fields
.field private final mHandler:Landroid/os/Handler;

.field private mIsInLongpress:Z

.field private final mRunnable:Ljava/lang/Runnable;

.field private mZoomSpeed:J


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .registers 3
    .parameter "context"

    .prologue
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroid/widget/ZoomButton;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 4
    .parameter "context"
    .parameter "attrs"

    .prologue
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Landroid/widget/ZoomButton;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .registers 6
    .parameter "context"
    .parameter "attrs"
    .parameter "defStyle"

    .prologue
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ImageButton;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    new-instance v0, Landroid/widget/ZoomButton$1;

    invoke-direct {v0, p0}, Landroid/widget/ZoomButton$1;-><init>(Landroid/widget/ZoomButton;)V

    iput-object v0, p0, Landroid/widget/ZoomButton;->mRunnable:Ljava/lang/Runnable;

    const-wide/16 v0, 0x3e8

    iput-wide v0, p0, Landroid/widget/ZoomButton;->mZoomSpeed:J

    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Landroid/widget/ZoomButton;->mHandler:Landroid/os/Handler;

    invoke-virtual {p0, p0}, Landroid/widget/ZoomButton;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    return-void
.end method

.method static synthetic access$000(Landroid/widget/ZoomButton;)Z
    .registers 2
    .parameter "x0"

    .prologue
    iget-boolean v0, p0, Landroid/widget/ZoomButton;->mIsInLongpress:Z

    return v0
.end method

.method static synthetic access$100(Landroid/widget/ZoomButton;)J
    .registers 3
    .parameter "x0"

    .prologue
    iget-wide v0, p0, Landroid/widget/ZoomButton;->mZoomSpeed:J

    return-wide v0
.end method

.method static synthetic access$200(Landroid/widget/ZoomButton;)Landroid/os/Handler;
    .registers 2
    .parameter "x0"

    .prologue
    iget-object v0, p0, Landroid/widget/ZoomButton;->mHandler:Landroid/os/Handler;

    return-object v0
.end method


# virtual methods
.method public dispatchUnhandledMove(Landroid/view/View;I)Z
    .registers 4
    .parameter "focused"
    .parameter "direction"

    .prologue
    invoke-virtual {p0}, Landroid/widget/ZoomButton;->clearFocus()V

    invoke-super {p0, p1, p2}, Landroid/widget/ImageButton;->dispatchUnhandledMove(Landroid/view/View;I)Z

    move-result v0

    return v0
.end method

.method public onInitializeAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V
    .registers 3
    .parameter "event"

    .prologue
    invoke-super {p0, p1}, Landroid/widget/ImageButton;->onInitializeAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V

    const-class v0, Landroid/widget/ZoomButton;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityEvent;->setClassName(Ljava/lang/CharSequence;)V

    return-void
.end method

.method public onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V
    .registers 3
    .parameter "info"

    .prologue
    invoke-super {p0, p1}, Landroid/widget/ImageButton;->onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V

    const-class v0, Landroid/widget/ZoomButton;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityNodeInfo;->setClassName(Ljava/lang/CharSequence;)V

    return-void
.end method

.method public onKeyUp(ILandroid/view/KeyEvent;)Z
    .registers 4
    .parameter "keyCode"
    .parameter "event"

    .prologue
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/widget/ZoomButton;->mIsInLongpress:Z

    invoke-super {p0, p1, p2}, Landroid/widget/ImageButton;->onKeyUp(ILandroid/view/KeyEvent;)Z

    move-result v0

    return v0
.end method

.method public onLongClick(Landroid/view/View;)Z
    .registers 5
    .parameter "v"

    .prologue
    const/4 v2, 0x1

    iput-boolean v2, p0, Landroid/widget/ZoomButton;->mIsInLongpress:Z

    iget-object v0, p0, Landroid/widget/ZoomButton;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Landroid/widget/ZoomButton;->mRunnable:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    return v2
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .registers 4
    .parameter "event"

    .prologue
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    const/4 v1, 0x3

    if-eq v0, v1, :cond_e

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_11

    :cond_e
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/widget/ZoomButton;->mIsInLongpress:Z

    :cond_11
    invoke-super {p0, p1}, Landroid/widget/ImageButton;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    return v0
.end method

.method public setEnabled(Z)V
    .registers 3
    .parameter "enabled"

    .prologue
    if-nez p1, :cond_6

    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Landroid/widget/ZoomButton;->setPressed(Z)V

    :cond_6
    invoke-super {p0, p1}, Landroid/widget/ImageButton;->setEnabled(Z)V

    return-void
.end method

.method public setZoomSpeed(J)V
    .registers 3
    .parameter "speed"

    .prologue
    iput-wide p1, p0, Landroid/widget/ZoomButton;->mZoomSpeed:J

    return-void
.end method
