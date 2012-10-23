.class public Landroid/widget/MagnifierController;
.super Ljava/lang/Object;
.source "MagnifierController.java"


# static fields
.field public static final LOG_TAG:Ljava/lang/String; = "MiuiMagnifierController"


# instance fields
.field private final mEditor:Landroid/widget/Editor;

.field private mLongClickX:I

.field private mLongClickY:I

.field private mOffset:I

.field private mShowing:Z

.field private final mTextView:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/widget/Editor;)V
    .registers 5
    .parameter "context"
    .parameter "editor"

    .prologue
    .line 22
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 20
    const/4 v0, -0x1

    iput v0, p0, Landroid/widget/MagnifierController;->mOffset:I

    .line 23
    const-string v0, "MiuiMagnifierController"

    const-string v1, "MagnifierController is created"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 24
    iput-object p2, p0, Landroid/widget/MagnifierController;->mEditor:Landroid/widget/Editor;

    .line 25
    invoke-virtual {p2}, Landroid/widget/Editor;->textview()Landroid/widget/TextView;

    move-result-object v0

    iput-object v0, p0, Landroid/widget/MagnifierController;->mTextView:Landroid/widget/TextView;

    .line 26
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/widget/MagnifierController;->mShowing:Z

    .line 27
    return-void
.end method

.method private hide()V
    .registers 3

    .prologue
    const/4 v1, 0x0

    .line 39
    iput-boolean v1, p0, Landroid/widget/MagnifierController;->mShowing:Z

    .line 40
    iget-object v0, p0, Landroid/widget/MagnifierController;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    if-eqz v0, :cond_14

    .line 41
    iget-object v0, p0, Landroid/widget/MagnifierController;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    invoke-interface {v0, v1}, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V

    .line 43
    :cond_14
    iget-object v0, p0, Landroid/widget/MagnifierController;->mEditor:Landroid/widget/Editor;

    invoke-virtual {v0}, Landroid/widget/Editor;->makeBlink()V

    .line 44
    return-void
.end method

.method public static isMagnifierEnabled(Landroid/content/Context;)Z
    .registers 2
    .parameter "context"

    .prologue
    .line 34
    const/4 v0, 0x1

    return v0
.end method

.method private showMagnifier()V
    .registers 4

    .prologue
    .line 94
    iget-object v0, p0, Landroid/widget/MagnifierController;->mEditor:Landroid/widget/Editor;

    invoke-virtual {v0}, Landroid/widget/Editor;->stopBlink()V

    .line 95
    iget-object v0, p0, Landroid/widget/MagnifierController;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getContext()Landroid/content/Context;

    move-result-object v0

    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.intent.action.SHOW_MAGNIFIER"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 96
    return-void
.end method

.method private updatePosition(Z)V
    .registers 6
    .parameter "isFirst"

    .prologue
    .line 85
    iget-object v1, p0, Landroid/widget/MagnifierController;->mTextView:Landroid/widget/TextView;

    iget v2, p0, Landroid/widget/MagnifierController;->mLongClickX:I

    int-to-float v2, v2

    iget v3, p0, Landroid/widget/MagnifierController;->mLongClickY:I

    int-to-float v3, v3

    invoke-virtual {v1, v2, v3}, Landroid/widget/TextView;->getOffsetForPosition(FF)I

    move-result v0

    .line 86
    .local v0, offset:I
    iget v1, p0, Landroid/widget/MagnifierController;->mOffset:I

    if-eq v0, v1, :cond_1a

    .line 87
    iget-object v1, p0, Landroid/widget/MagnifierController;->mEditor:Landroid/widget/Editor;

    invoke-virtual {v1, v0}, Landroid/widget/Editor;->setTextSelection(I)V

    .line 88
    iput v0, p0, Landroid/widget/MagnifierController;->mOffset:I

    .line 89
    invoke-direct {p0}, Landroid/widget/MagnifierController;->showMagnifier()V

    .line 91
    :cond_1a
    return-void
.end method


# virtual methods
.method public isShowing()Z
    .registers 2

    .prologue
    .line 55
    iget-boolean v0, p0, Landroid/widget/MagnifierController;->mShowing:Z

    return v0
.end method

.method public onParentChanged()V
    .registers 2

    .prologue
    .line 101
    iget-boolean v0, p0, Landroid/widget/MagnifierController;->mShowing:Z

    if-eqz v0, :cond_7

    .line 102
    invoke-direct {p0}, Landroid/widget/MagnifierController;->showMagnifier()V

    .line 104
    :cond_7
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .registers 5
    .parameter "event"

    .prologue
    .line 60
    const/4 v0, 0x0

    .line 62
    .local v0, handled:Z
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    float-to-int v1, v1

    iput v1, p0, Landroid/widget/MagnifierController;->mLongClickX:I

    .line 63
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    float-to-int v1, v1

    iput v1, p0, Landroid/widget/MagnifierController;->mLongClickY:I

    .line 65
    invoke-virtual {p0}, Landroid/widget/MagnifierController;->isShowing()Z

    move-result v1

    if-eqz v1, :cond_26

    .line 66
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getActionMasked()I

    move-result v1

    packed-switch v1, :pswitch_data_32

    .line 77
    :goto_1c
    iget-object v1, p0, Landroid/widget/MagnifierController;->mEditor:Landroid/widget/Editor;

    invoke-virtual {v1}, Landroid/widget/Editor;->getInsertionController()Landroid/widget/MiuiCursorController;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2, p1}, Landroid/widget/MiuiCursorController;->onHandleTouchEvent(Landroid/widget/MiuiCursorController$MiuiHandleView;Landroid/view/MotionEvent;)Z

    .line 80
    :cond_26
    return v0

    .line 68
    :pswitch_27
    const/4 v1, 0x0

    invoke-direct {p0, v1}, Landroid/widget/MagnifierController;->updatePosition(Z)V

    .line 69
    const/4 v0, 0x1

    .line 70
    goto :goto_1c

    .line 74
    :pswitch_2d
    invoke-direct {p0}, Landroid/widget/MagnifierController;->hide()V

    .line 75
    const/4 v0, 0x0

    goto :goto_1c

    .line 66
    :pswitch_data_32
    .packed-switch 0x1
        :pswitch_2d
        :pswitch_27
        :pswitch_2d
    .end packed-switch
.end method

.method public show()V
    .registers 3

    .prologue
    const/4 v1, 0x1

    .line 47
    iput-boolean v1, p0, Landroid/widget/MagnifierController;->mShowing:Z

    .line 48
    iget-object v0, p0, Landroid/widget/MagnifierController;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    if-eqz v0, :cond_14

    .line 49
    iget-object v0, p0, Landroid/widget/MagnifierController;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    invoke-interface {v0, v1}, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V

    .line 51
    :cond_14
    invoke-direct {p0}, Landroid/widget/MagnifierController;->showMagnifier()V

    .line 52
    return-void
.end method
