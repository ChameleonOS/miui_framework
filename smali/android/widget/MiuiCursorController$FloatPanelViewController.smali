.class Landroid/widget/MiuiCursorController$FloatPanelViewController;
.super Ljava/lang/Object;
.source "MiuiCursorController.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/MiuiCursorController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "FloatPanelViewController"
.end annotation


# static fields
.field static final synthetic $assertionsDisabled:Z


# instance fields
.field private mContainer:Landroid/widget/PopupWindow;

.field private mContent:Landroid/widget/FloatPanelView;

.field private mController:Landroid/widget/MiuiCursorController;

.field private mDisplay:Landroid/view/Display;

.field private mPos:[I

.field private mStatusBarHeight:I

.field final synthetic this$0:Landroid/widget/MiuiCursorController;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    const-class v0, Landroid/widget/MiuiCursorController;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_c

    const/4 v0, 0x1

    :goto_9
    sput-boolean v0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->$assertionsDisabled:Z

    return-void

    :cond_c
    const/4 v0, 0x0

    goto :goto_9
.end method

.method public constructor <init>(Landroid/widget/MiuiCursorController;Landroid/widget/MiuiCursorController;I)V
    .registers 11
    .parameter
    .parameter "controller"
    .parameter "resId"

    .prologue
    const/4 v6, 0x0

    const/4 v5, -0x2

    iput-object p1, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->this$0:Landroid/widget/MiuiCursorController;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    const/4 v2, 0x2

    new-array v2, v2, [I

    iput-object v2, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mPos:[I

    iput-object p2, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mController:Landroid/widget/MiuiCursorController;

    new-instance v2, Landroid/widget/PopupWindow;

    iget-object v3, p1, Landroid/widget/MiuiCursorController;->mContext:Landroid/content/Context;

    const v4, 0x10102c8

    invoke-direct {v2, v3, v6, v4}, Landroid/widget/PopupWindow;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    iput-object v2, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mContainer:Landroid/widget/PopupWindow;

    iget-object v2, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mContainer:Landroid/widget/PopupWindow;

    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Landroid/widget/PopupWindow;->setSplitTouchEnabled(Z)V

    iget-object v2, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mContainer:Landroid/widget/PopupWindow;

    const/16 v3, 0x3ea

    invoke-virtual {v2, v3}, Landroid/widget/PopupWindow;->setWindowLayoutType(I)V

    iget-object v2, p1, Landroid/widget/MiuiCursorController;->mContext:Landroid/content/Context;

    const-string v3, "layout_inflater"

    invoke-virtual {v2, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    .local v0, layoutInflater:Landroid/view/LayoutInflater;
    invoke-virtual {v0, p3, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/FloatPanelView;

    iput-object v2, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mContent:Landroid/widget/FloatPanelView;

    iget-object v2, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mContainer:Landroid/widget/PopupWindow;

    iget-object v3, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mContent:Landroid/widget/FloatPanelView;

    invoke-virtual {v2, v3}, Landroid/widget/PopupWindow;->setContentView(Landroid/view/View;)V

    iget-object v2, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mContainer:Landroid/widget/PopupWindow;

    invoke-virtual {v2, v5, v5}, Landroid/widget/PopupWindow;->setWindowLayoutMode(II)V

    iget-object v2, p1, Landroid/widget/MiuiCursorController;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const/high16 v3, 0x60a

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    iput v2, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mStatusBarHeight:I

    iget-object v2, p1, Landroid/widget/MiuiCursorController;->mContext:Landroid/content/Context;

    const-string/jumbo v3, "window"

    invoke-virtual {v2, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/WindowManager;

    .local v1, wm:Landroid/view/WindowManager;
    invoke-interface {v1}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v2

    iput-object v2, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mDisplay:Landroid/view/Display;

    return-void
.end method

.method static synthetic access$000(Landroid/widget/MiuiCursorController$FloatPanelViewController;)V
    .registers 1
    .parameter "x0"

    .prologue
    invoke-direct {p0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->updatePosition()V

    return-void
.end method

.method private updatePosition()V
    .registers 9

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    iget-object v4, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mController:Landroid/widget/MiuiCursorController;

    iget-object v5, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mPos:[I

    invoke-virtual {v4, v5}, Landroid/widget/MiuiCursorController;->computePanelPosition([I)V

    iget-object v4, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mPos:[I

    aget v4, v4, v6

    iget-object v5, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mContent:Landroid/widget/FloatPanelView;

    invoke-virtual {v5}, Landroid/widget/FloatPanelView;->getWidth()I

    move-result v5

    div-int/lit8 v5, v5, 0x2

    sub-int v0, v4, v5

    .local v0, left:I
    iget-object v4, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mPos:[I

    aget v4, v4, v7

    iget-object v5, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mContent:Landroid/widget/FloatPanelView;

    invoke-virtual {v5}, Landroid/widget/FloatPanelView;->getHeight()I

    move-result v5

    sub-int/2addr v4, v5

    iget-object v5, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->this$0:Landroid/widget/MiuiCursorController;

    iget-object v5, v5, Landroid/widget/MiuiCursorController;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v5}, Landroid/widget/TextView;->getLineHeight()I

    move-result v5

    sub-int v2, v4, v5

    .local v2, top:I
    iget v4, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mStatusBarHeight:I

    if-ge v2, v4, :cond_63

    iget-object v4, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mContent:Landroid/widget/FloatPanelView;

    invoke-virtual {v4, v7}, Landroid/widget/FloatPanelView;->setArrow(Z)V

    iget-object v4, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mController:Landroid/widget/MiuiCursorController;

    invoke-virtual {v4}, Landroid/widget/MiuiCursorController;->computePanelPositionOnBottom()I

    move-result v2

    :goto_3b
    iget-object v4, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mDisplay:Landroid/view/Display;

    invoke-virtual {v4}, Landroid/view/Display;->getWidth()I

    move-result v1

    .local v1, screenWidth:I
    iget-object v4, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mContent:Landroid/widget/FloatPanelView;

    invoke-virtual {v4}, Landroid/widget/FloatPanelView;->getWidth()I

    move-result v4

    div-int/lit8 v3, v4, 0x2

    .local v3, xpos:I
    if-gez v0, :cond_69

    add-int/2addr v3, v0

    :cond_4c
    :goto_4c
    iget-object v4, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mContent:Landroid/widget/FloatPanelView;

    invoke-virtual {v4, v3}, Landroid/widget/FloatPanelView;->setArrowPos(I)V

    iget-object v4, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mContainer:Landroid/widget/PopupWindow;

    iget-object v5, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mContent:Landroid/widget/FloatPanelView;

    invoke-virtual {v5}, Landroid/widget/FloatPanelView;->getWidth()I

    move-result v5

    iget-object v6, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mContent:Landroid/widget/FloatPanelView;

    invoke-virtual {v6}, Landroid/widget/FloatPanelView;->getHeight()I

    move-result v6

    invoke-virtual {v4, v0, v2, v5, v6}, Landroid/widget/PopupWindow;->update(IIII)V

    return-void

    .end local v1           #screenWidth:I
    .end local v3           #xpos:I
    :cond_63
    iget-object v4, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mContent:Landroid/widget/FloatPanelView;

    invoke-virtual {v4, v6}, Landroid/widget/FloatPanelView;->setArrow(Z)V

    goto :goto_3b

    .restart local v1       #screenWidth:I
    .restart local v3       #xpos:I
    :cond_69
    iget-object v4, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mContent:Landroid/widget/FloatPanelView;

    invoke-virtual {v4}, Landroid/widget/FloatPanelView;->getWidth()I

    move-result v4

    add-int/2addr v4, v0

    if-le v4, v1, :cond_4c

    iget-object v4, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mContent:Landroid/widget/FloatPanelView;

    invoke-virtual {v4}, Landroid/widget/FloatPanelView;->getWidth()I

    move-result v4

    add-int/2addr v4, v0

    sub-int/2addr v4, v1

    add-int/2addr v3, v4

    goto :goto_4c
.end method


# virtual methods
.method public getElement(I)Landroid/view/View;
    .registers 3
    .parameter "id"

    .prologue
    iget-object v0, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mContent:Landroid/widget/FloatPanelView;

    invoke-virtual {v0, p1}, Landroid/widget/FloatPanelView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public hide()V
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mContainer:Landroid/widget/PopupWindow;

    invoke-virtual {v0}, Landroid/widget/PopupWindow;->dismiss()V

    return-void
.end method

.method public isShowing()Z
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mContainer:Landroid/widget/PopupWindow;

    invoke-virtual {v0}, Landroid/widget/PopupWindow;->isShowing()Z

    move-result v0

    return v0
.end method

.method public setButtonOnClickListener(ILandroid/view/View$OnClickListener;)V
    .registers 7
    .parameter "id"
    .parameter "l"

    .prologue
    iget-object v1, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mContent:Landroid/widget/FloatPanelView;

    invoke-virtual {v1, p1}, Landroid/widget/FloatPanelView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .local v0, v:Landroid/view/View;
    if-eqz v0, :cond_c

    invoke-virtual {v0, p2}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    :goto_b
    return-void

    :cond_c
    const-string v1, "MiuiCursorController"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "FloatPanelView.setButtonHandler, could not find view, id:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_b
.end method

.method public show()V
    .registers 7

    .prologue
    const/4 v5, 0x0

    iget-object v0, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mController:Landroid/widget/MiuiCursorController;

    iget-object v1, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mPos:[I

    invoke-virtual {v0, v1}, Landroid/widget/MiuiCursorController;->computePanelPosition([I)V

    iget-object v0, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mContainer:Landroid/widget/PopupWindow;

    iget-object v1, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->this$0:Landroid/widget/MiuiCursorController;

    iget-object v1, v1, Landroid/widget/MiuiCursorController;->mTextView:Landroid/widget/TextView;

    iget-object v2, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mPos:[I

    aget v2, v2, v5

    iget-object v3, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mContent:Landroid/widget/FloatPanelView;

    invoke-virtual {v3}, Landroid/widget/FloatPanelView;->getWidth()I

    move-result v3

    div-int/lit8 v3, v3, 0x2

    sub-int/2addr v2, v3

    iget-object v3, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mPos:[I

    const/4 v4, 0x1

    aget v3, v3, v4

    iget-object v4, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mContent:Landroid/widget/FloatPanelView;

    invoke-virtual {v4}, Landroid/widget/FloatPanelView;->getHeight()I

    move-result v4

    sub-int/2addr v3, v4

    iget-object v4, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->this$0:Landroid/widget/MiuiCursorController;

    iget-object v4, v4, Landroid/widget/MiuiCursorController;->mTextView:Landroid/widget/TextView;

    invoke-virtual {v4}, Landroid/widget/TextView;->getLineHeight()I

    move-result v4

    sub-int/2addr v3, v4

    invoke-virtual {v0, v1, v5, v2, v3}, Landroid/widget/PopupWindow;->showAtLocation(Landroid/view/View;III)V

    invoke-direct {p0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->updatePosition()V

    return-void
.end method

.method public showAndUpdatePositionAsync()V
    .registers 3

    .prologue
    const-string v0, "MiuiCursorController"

    const-string v1, "FloatPanelViewController to showAndUpdatePositionAsync"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->isShowing()Z

    move-result v0

    if-nez v0, :cond_10

    invoke-virtual {p0}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->show()V

    :cond_10
    iget-object v0, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->this$0:Landroid/widget/MiuiCursorController;

    iget-object v0, v0, Landroid/widget/MiuiCursorController;->mTextView:Landroid/widget/TextView;

    new-instance v1, Landroid/widget/MiuiCursorController$FloatPanelViewController$1;

    invoke-direct {v1, p0}, Landroid/widget/MiuiCursorController$FloatPanelViewController$1;-><init>(Landroid/widget/MiuiCursorController$FloatPanelViewController;)V

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->post(Ljava/lang/Runnable;)Z

    return-void
.end method

.method public showElement(IZ)V
    .registers 7
    .parameter "id"
    .parameter "show"

    .prologue
    iget-object v1, p0, Landroid/widget/MiuiCursorController$FloatPanelViewController;->mContent:Landroid/widget/FloatPanelView;

    invoke-virtual {v1, p1}, Landroid/widget/FloatPanelView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .local v0, v:Landroid/view/View;
    if-eqz v0, :cond_12

    if-eqz p2, :cond_f

    const/4 v1, 0x0

    :goto_b
    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    :goto_e
    return-void

    :cond_f
    const/16 v1, 0x8

    goto :goto_b

    :cond_12
    const-string v1, "MiuiCursorController"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "FloatPanelView.showButton, could not find view, id:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_e
.end method

.method public showHideButtons([I[ILjava/util/ArrayList;)V
    .registers 11
    .parameter "buttons"
    .parameter "separators"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([I[I",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/Boolean;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p3, visibility:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Ljava/lang/Boolean;>;"
    const/4 v4, 0x1

    const/4 v5, 0x0

    sget-boolean v3, Landroid/widget/MiuiCursorController$FloatPanelViewController;->$assertionsDisabled:Z

    if-nez v3, :cond_19

    array-length v3, p1

    array-length v6, p2

    add-int/lit8 v6, v6, 0x1

    if-ne v3, v6, :cond_13

    array-length v3, p1

    invoke-virtual {p3}, Ljava/util/ArrayList;->size()I

    move-result v6

    if-eq v3, v6, :cond_19

    :cond_13
    new-instance v3, Ljava/lang/AssertionError;

    invoke-direct {v3}, Ljava/lang/AssertionError;-><init>()V

    throw v3

    :cond_19
    aget v6, p1, v5

    invoke-virtual {p3, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    invoke-virtual {p0, v6, v3}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->showElement(IZ)V

    invoke-virtual {p3, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-nez v3, :cond_64

    move v1, v4

    .local v1, isFirstShow:Z
    :goto_35
    const/4 v0, 0x1

    .local v0, i:I
    :goto_36
    array-length v3, p1

    if-ge v0, v3, :cond_68

    invoke-virtual {p3, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Boolean;

    .local v2, show:Ljava/lang/Boolean;
    aget v3, p1, v0

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v6

    invoke-virtual {p0, v3, v6}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->showElement(IZ)V

    add-int/lit8 v3, v0, -0x1

    aget v6, p2, v3

    if-nez v1, :cond_66

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-eqz v3, :cond_66

    move v3, v4

    :goto_55
    invoke-virtual {p0, v6, v3}, Landroid/widget/MiuiCursorController$FloatPanelViewController;->showElement(IZ)V

    if-eqz v1, :cond_61

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-eqz v3, :cond_61

    const/4 v1, 0x0

    :cond_61
    add-int/lit8 v0, v0, 0x1

    goto :goto_36

    .end local v0           #i:I
    .end local v1           #isFirstShow:Z
    .end local v2           #show:Ljava/lang/Boolean;
    :cond_64
    move v1, v5

    goto :goto_35

    .restart local v0       #i:I
    .restart local v1       #isFirstShow:Z
    .restart local v2       #show:Ljava/lang/Boolean;
    :cond_66
    move v3, v5

    goto :goto_55

    .end local v2           #show:Ljava/lang/Boolean;
    :cond_68
    return-void
.end method
