.class Landroid/widget/Editor$InsertionPointCursorController;
.super Ljava/lang/Object;
.source "Editor.java"

# interfaces
.implements Landroid/widget/Editor$CursorController;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/Editor;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "InsertionPointCursorController"
.end annotation


# instance fields
.field private mHandle:Landroid/widget/Editor$InsertionHandleView;

.field final synthetic this$0:Landroid/widget/Editor;


# direct methods
.method private constructor <init>(Landroid/widget/Editor;)V
    .registers 2
    .parameter

    .prologue
    iput-object p1, p0, Landroid/widget/Editor$InsertionPointCursorController;->this$0:Landroid/widget/Editor;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private getHandle()Landroid/widget/Editor$InsertionHandleView;
    .registers 4

    .prologue
    iget-object v0, p0, Landroid/widget/Editor$InsertionPointCursorController;->this$0:Landroid/widget/Editor;

    #getter for: Landroid/widget/Editor;->mSelectHandleCenter:Landroid/graphics/drawable/Drawable;
    invoke-static {v0}, Landroid/widget/Editor;->access$2300(Landroid/widget/Editor;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    if-nez v0, :cond_23

    iget-object v0, p0, Landroid/widget/Editor$InsertionPointCursorController;->this$0:Landroid/widget/Editor;

    iget-object v1, p0, Landroid/widget/Editor$InsertionPointCursorController;->this$0:Landroid/widget/Editor;

    #getter for: Landroid/widget/Editor;->mTextView:Landroid/widget/TextView;
    invoke-static {v1}, Landroid/widget/Editor;->access$500(Landroid/widget/Editor;)Landroid/widget/TextView;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/TextView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    iget-object v2, p0, Landroid/widget/Editor$InsertionPointCursorController;->this$0:Landroid/widget/Editor;

    #getter for: Landroid/widget/Editor;->mTextView:Landroid/widget/TextView;
    invoke-static {v2}, Landroid/widget/Editor;->access$500(Landroid/widget/Editor;)Landroid/widget/TextView;

    move-result-object v2

    iget v2, v2, Landroid/widget/TextView;->mTextSelectHandleRes:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    #setter for: Landroid/widget/Editor;->mSelectHandleCenter:Landroid/graphics/drawable/Drawable;
    invoke-static {v0, v1}, Landroid/widget/Editor;->access$2302(Landroid/widget/Editor;Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;

    :cond_23
    iget-object v0, p0, Landroid/widget/Editor$InsertionPointCursorController;->mHandle:Landroid/widget/Editor$InsertionHandleView;

    if-nez v0, :cond_36

    new-instance v0, Landroid/widget/Editor$InsertionHandleView;

    iget-object v1, p0, Landroid/widget/Editor$InsertionPointCursorController;->this$0:Landroid/widget/Editor;

    iget-object v2, p0, Landroid/widget/Editor$InsertionPointCursorController;->this$0:Landroid/widget/Editor;

    #getter for: Landroid/widget/Editor;->mSelectHandleCenter:Landroid/graphics/drawable/Drawable;
    invoke-static {v2}, Landroid/widget/Editor;->access$2300(Landroid/widget/Editor;)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/widget/Editor$InsertionHandleView;-><init>(Landroid/widget/Editor;Landroid/graphics/drawable/Drawable;)V

    iput-object v0, p0, Landroid/widget/Editor$InsertionPointCursorController;->mHandle:Landroid/widget/Editor$InsertionHandleView;

    :cond_36
    iget-object v0, p0, Landroid/widget/Editor$InsertionPointCursorController;->mHandle:Landroid/widget/Editor$InsertionHandleView;

    return-object v0
.end method


# virtual methods
.method public hide()V
    .registers 2

    .prologue
    iget-object v0, p0, Landroid/widget/Editor$InsertionPointCursorController;->mHandle:Landroid/widget/Editor$InsertionHandleView;

    if-eqz v0, :cond_9

    iget-object v0, p0, Landroid/widget/Editor$InsertionPointCursorController;->mHandle:Landroid/widget/Editor$InsertionHandleView;

    invoke-virtual {v0}, Landroid/widget/Editor$InsertionHandleView;->hide()V

    :cond_9
    return-void
.end method

.method public onDetached()V
    .registers 3

    .prologue
    iget-object v1, p0, Landroid/widget/Editor$InsertionPointCursorController;->this$0:Landroid/widget/Editor;

    #getter for: Landroid/widget/Editor;->mTextView:Landroid/widget/TextView;
    invoke-static {v1}, Landroid/widget/Editor;->access$500(Landroid/widget/Editor;)Landroid/widget/TextView;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/TextView;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    .local v0, observer:Landroid/view/ViewTreeObserver;
    invoke-virtual {v0, p0}, Landroid/view/ViewTreeObserver;->removeOnTouchModeChangeListener(Landroid/view/ViewTreeObserver$OnTouchModeChangeListener;)V

    iget-object v1, p0, Landroid/widget/Editor$InsertionPointCursorController;->mHandle:Landroid/widget/Editor$InsertionHandleView;

    if-eqz v1, :cond_16

    iget-object v1, p0, Landroid/widget/Editor$InsertionPointCursorController;->mHandle:Landroid/widget/Editor$InsertionHandleView;

    invoke-virtual {v1}, Landroid/widget/Editor$InsertionHandleView;->onDetached()V

    :cond_16
    return-void
.end method

.method public onTouchModeChanged(Z)V
    .registers 2
    .parameter "isInTouchMode"

    .prologue
    if-nez p1, :cond_5

    invoke-virtual {p0}, Landroid/widget/Editor$InsertionPointCursorController;->hide()V

    :cond_5
    return-void
.end method

.method public show()V
    .registers 2

    .prologue
    invoke-direct {p0}, Landroid/widget/Editor$InsertionPointCursorController;->getHandle()Landroid/widget/Editor$InsertionHandleView;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Editor$InsertionHandleView;->show()V

    return-void
.end method

.method public showWithActionPopup()V
    .registers 2

    .prologue
    invoke-direct {p0}, Landroid/widget/Editor$InsertionPointCursorController;->getHandle()Landroid/widget/Editor$InsertionHandleView;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Editor$InsertionHandleView;->showWithActionPopup()V

    return-void
.end method
