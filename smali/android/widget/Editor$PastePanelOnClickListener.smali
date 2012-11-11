.class Landroid/widget/Editor$PastePanelOnClickListener;
.super Ljava/lang/Object;
.source "Editor.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/Editor;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "PastePanelOnClickListener"
.end annotation


# instance fields
.field private mController:Landroid/widget/MiuiCursorController;

.field private mMax:I

.field private mMin:I

.field final synthetic this$0:Landroid/widget/Editor;


# direct methods
.method constructor <init>(Landroid/widget/Editor;Landroid/widget/MiuiCursorController;II)V
    .registers 5
    .parameter
    .parameter "cc"
    .parameter "min"
    .parameter "max"

    .prologue
    iput-object p1, p0, Landroid/widget/Editor$PastePanelOnClickListener;->this$0:Landroid/widget/Editor;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    iput-object p2, p0, Landroid/widget/Editor$PastePanelOnClickListener;->mController:Landroid/widget/MiuiCursorController;

    iput p3, p0, Landroid/widget/Editor$PastePanelOnClickListener;->mMin:I

    iput p4, p0, Landroid/widget/Editor$PastePanelOnClickListener;->mMax:I

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .registers 7
    .parameter "v"

    .prologue
    move-object v0, p1

    check-cast v0, Landroid/widget/TextView;

    .local v0, t:Landroid/widget/TextView;
    iget-object v1, p0, Landroid/widget/Editor$PastePanelOnClickListener;->this$0:Landroid/widget/Editor;

    #getter for: Landroid/widget/Editor;->mTextView:Landroid/widget/TextView;
    invoke-static {v1}, Landroid/widget/Editor;->access$500(Landroid/widget/Editor;)Landroid/widget/TextView;

    move-result-object v1

    iget v2, p0, Landroid/widget/Editor$PastePanelOnClickListener;->mMin:I

    iget v3, p0, Landroid/widget/Editor$PastePanelOnClickListener;->mMax:I

    invoke-virtual {v0}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v4

    invoke-virtual {v1, v2, v3, v4}, Landroid/widget/TextView;->replaceText_internal(IILjava/lang/CharSequence;)V

    iget-object v1, p0, Landroid/widget/Editor$PastePanelOnClickListener;->this$0:Landroid/widget/Editor;

    invoke-virtual {v1}, Landroid/widget/Editor;->stopTextSelectionMode()V

    iget-object v1, p0, Landroid/widget/Editor$PastePanelOnClickListener;->mController:Landroid/widget/MiuiCursorController;

    check-cast v1, Landroid/widget/MiuiCursorController$InsertionPointCursorController;

    invoke-virtual {v1}, Landroid/widget/MiuiCursorController$InsertionPointCursorController;->onClipBoardPancelClick()V

    return-void
.end method
