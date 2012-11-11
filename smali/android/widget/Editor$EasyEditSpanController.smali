.class Landroid/widget/Editor$EasyEditSpanController;
.super Ljava/lang/Object;
.source "Editor.java"

# interfaces
.implements Landroid/text/SpanWatcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/Editor;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "EasyEditSpanController"
.end annotation


# static fields
.field private static final DISPLAY_TIMEOUT_MS:I = 0xbb8


# instance fields
.field private mHidePopup:Ljava/lang/Runnable;

.field private mPopupWindow:Landroid/widget/Editor$EasyEditPopupWindow;

.field final synthetic this$0:Landroid/widget/Editor;


# direct methods
.method constructor <init>(Landroid/widget/Editor;)V
    .registers 2
    .parameter

    .prologue
    iput-object p1, p0, Landroid/widget/Editor$EasyEditSpanController;->this$0:Landroid/widget/Editor;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public hide()V
    .registers 3

    .prologue
    iget-object v0, p0, Landroid/widget/Editor$EasyEditSpanController;->mPopupWindow:Landroid/widget/Editor$EasyEditPopupWindow;

    if-eqz v0, :cond_14

    iget-object v0, p0, Landroid/widget/Editor$EasyEditSpanController;->mPopupWindow:Landroid/widget/Editor$EasyEditPopupWindow;

    invoke-virtual {v0}, Landroid/widget/Editor$EasyEditPopupWindow;->hide()V

    iget-object v0, p0, Landroid/widget/Editor$EasyEditSpanController;->this$0:Landroid/widget/Editor;

    #getter for: Landroid/widget/Editor;->mTextView:Landroid/widget/TextView;
    invoke-static {v0}, Landroid/widget/Editor;->access$500(Landroid/widget/Editor;)Landroid/widget/TextView;

    move-result-object v0

    iget-object v1, p0, Landroid/widget/Editor$EasyEditSpanController;->mHidePopup:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->removeCallbacks(Ljava/lang/Runnable;)Z

    :cond_14
    return-void
.end method

.method public onSpanAdded(Landroid/text/Spannable;Ljava/lang/Object;II)V
    .registers 9
    .parameter "text"
    .parameter "span"
    .parameter "start"
    .parameter "end"

    .prologue
    instance-of v0, p2, Landroid/text/style/EasyEditSpan;

    if-eqz v0, :cond_3d

    iget-object v0, p0, Landroid/widget/Editor$EasyEditSpanController;->mPopupWindow:Landroid/widget/Editor$EasyEditPopupWindow;

    if-nez v0, :cond_19

    new-instance v0, Landroid/widget/Editor$EasyEditPopupWindow;

    iget-object v1, p0, Landroid/widget/Editor$EasyEditSpanController;->this$0:Landroid/widget/Editor;

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Landroid/widget/Editor$EasyEditPopupWindow;-><init>(Landroid/widget/Editor;Landroid/widget/Editor$1;)V

    iput-object v0, p0, Landroid/widget/Editor$EasyEditSpanController;->mPopupWindow:Landroid/widget/Editor$EasyEditPopupWindow;

    new-instance v0, Landroid/widget/Editor$EasyEditSpanController$1;

    invoke-direct {v0, p0}, Landroid/widget/Editor$EasyEditSpanController$1;-><init>(Landroid/widget/Editor$EasyEditSpanController;)V

    iput-object v0, p0, Landroid/widget/Editor$EasyEditSpanController;->mHidePopup:Ljava/lang/Runnable;

    :cond_19
    iget-object v0, p0, Landroid/widget/Editor$EasyEditSpanController;->mPopupWindow:Landroid/widget/Editor$EasyEditPopupWindow;

    #getter for: Landroid/widget/Editor$EasyEditPopupWindow;->mEasyEditSpan:Landroid/text/style/EasyEditSpan;
    invoke-static {v0}, Landroid/widget/Editor$EasyEditPopupWindow;->access$700(Landroid/widget/Editor$EasyEditPopupWindow;)Landroid/text/style/EasyEditSpan;

    move-result-object v0

    if-eqz v0, :cond_2a

    iget-object v0, p0, Landroid/widget/Editor$EasyEditSpanController;->mPopupWindow:Landroid/widget/Editor$EasyEditPopupWindow;

    #getter for: Landroid/widget/Editor$EasyEditPopupWindow;->mEasyEditSpan:Landroid/text/style/EasyEditSpan;
    invoke-static {v0}, Landroid/widget/Editor$EasyEditPopupWindow;->access$700(Landroid/widget/Editor$EasyEditPopupWindow;)Landroid/text/style/EasyEditSpan;

    move-result-object v0

    invoke-interface {p1, v0}, Landroid/text/Spannable;->removeSpan(Ljava/lang/Object;)V

    :cond_2a
    iget-object v0, p0, Landroid/widget/Editor$EasyEditSpanController;->mPopupWindow:Landroid/widget/Editor$EasyEditPopupWindow;

    check-cast p2, Landroid/text/style/EasyEditSpan;

    .end local p2
    invoke-virtual {v0, p2}, Landroid/widget/Editor$EasyEditPopupWindow;->setEasyEditSpan(Landroid/text/style/EasyEditSpan;)V

    iget-object v0, p0, Landroid/widget/Editor$EasyEditSpanController;->this$0:Landroid/widget/Editor;

    #getter for: Landroid/widget/Editor;->mTextView:Landroid/widget/TextView;
    invoke-static {v0}, Landroid/widget/Editor;->access$500(Landroid/widget/Editor;)Landroid/widget/TextView;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/TextView;->getWindowVisibility()I

    move-result v0

    if-eqz v0, :cond_3e

    :cond_3d
    :goto_3d
    return-void

    :cond_3e
    iget-object v0, p0, Landroid/widget/Editor$EasyEditSpanController;->this$0:Landroid/widget/Editor;

    #getter for: Landroid/widget/Editor;->mTextView:Landroid/widget/TextView;
    invoke-static {v0}, Landroid/widget/Editor;->access$500(Landroid/widget/Editor;)Landroid/widget/TextView;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;

    move-result-object v0

    if-eqz v0, :cond_3d

    iget-object v0, p0, Landroid/widget/Editor$EasyEditSpanController;->this$0:Landroid/widget/Editor;

    #calls: Landroid/widget/Editor;->extractedTextModeWillBeStarted()Z
    invoke-static {v0}, Landroid/widget/Editor;->access$800(Landroid/widget/Editor;)Z

    move-result v0

    if-nez v0, :cond_3d

    iget-object v0, p0, Landroid/widget/Editor$EasyEditSpanController;->mPopupWindow:Landroid/widget/Editor$EasyEditPopupWindow;

    invoke-virtual {v0}, Landroid/widget/Editor$EasyEditPopupWindow;->show()V

    iget-object v0, p0, Landroid/widget/Editor$EasyEditSpanController;->this$0:Landroid/widget/Editor;

    #getter for: Landroid/widget/Editor;->mTextView:Landroid/widget/TextView;
    invoke-static {v0}, Landroid/widget/Editor;->access$500(Landroid/widget/Editor;)Landroid/widget/TextView;

    move-result-object v0

    iget-object v1, p0, Landroid/widget/Editor$EasyEditSpanController;->mHidePopup:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->removeCallbacks(Ljava/lang/Runnable;)Z

    iget-object v0, p0, Landroid/widget/Editor$EasyEditSpanController;->this$0:Landroid/widget/Editor;

    #getter for: Landroid/widget/Editor;->mTextView:Landroid/widget/TextView;
    invoke-static {v0}, Landroid/widget/Editor;->access$500(Landroid/widget/Editor;)Landroid/widget/TextView;

    move-result-object v0

    iget-object v1, p0, Landroid/widget/Editor$EasyEditSpanController;->mHidePopup:Ljava/lang/Runnable;

    const-wide/16 v2, 0xbb8

    invoke-virtual {v0, v1, v2, v3}, Landroid/widget/TextView;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_3d
.end method

.method public onSpanChanged(Landroid/text/Spannable;Ljava/lang/Object;IIII)V
    .registers 8
    .parameter "text"
    .parameter "span"
    .parameter "previousStart"
    .parameter "previousEnd"
    .parameter "newStart"
    .parameter "newEnd"

    .prologue
    iget-object v0, p0, Landroid/widget/Editor$EasyEditSpanController;->mPopupWindow:Landroid/widget/Editor$EasyEditPopupWindow;

    if-eqz v0, :cond_15

    iget-object v0, p0, Landroid/widget/Editor$EasyEditSpanController;->mPopupWindow:Landroid/widget/Editor$EasyEditPopupWindow;

    #getter for: Landroid/widget/Editor$EasyEditPopupWindow;->mEasyEditSpan:Landroid/text/style/EasyEditSpan;
    invoke-static {v0}, Landroid/widget/Editor$EasyEditPopupWindow;->access$700(Landroid/widget/Editor$EasyEditPopupWindow;)Landroid/text/style/EasyEditSpan;

    move-result-object v0

    if-ne p2, v0, :cond_15

    iget-object v0, p0, Landroid/widget/Editor$EasyEditSpanController;->mPopupWindow:Landroid/widget/Editor$EasyEditPopupWindow;

    #getter for: Landroid/widget/Editor$EasyEditPopupWindow;->mEasyEditSpan:Landroid/text/style/EasyEditSpan;
    invoke-static {v0}, Landroid/widget/Editor$EasyEditPopupWindow;->access$700(Landroid/widget/Editor$EasyEditPopupWindow;)Landroid/text/style/EasyEditSpan;

    move-result-object v0

    invoke-interface {p1, v0}, Landroid/text/Spannable;->removeSpan(Ljava/lang/Object;)V

    :cond_15
    return-void
.end method

.method public onSpanRemoved(Landroid/text/Spannable;Ljava/lang/Object;II)V
    .registers 6
    .parameter "text"
    .parameter "span"
    .parameter "start"
    .parameter "end"

    .prologue
    iget-object v0, p0, Landroid/widget/Editor$EasyEditSpanController;->mPopupWindow:Landroid/widget/Editor$EasyEditPopupWindow;

    if-eqz v0, :cond_f

    iget-object v0, p0, Landroid/widget/Editor$EasyEditSpanController;->mPopupWindow:Landroid/widget/Editor$EasyEditPopupWindow;

    #getter for: Landroid/widget/Editor$EasyEditPopupWindow;->mEasyEditSpan:Landroid/text/style/EasyEditSpan;
    invoke-static {v0}, Landroid/widget/Editor$EasyEditPopupWindow;->access$700(Landroid/widget/Editor$EasyEditPopupWindow;)Landroid/text/style/EasyEditSpan;

    move-result-object v0

    if-ne p2, v0, :cond_f

    invoke-virtual {p0}, Landroid/widget/Editor$EasyEditSpanController;->hide()V

    :cond_f
    return-void
.end method
