.class Landroid/widget/SearchView$7;
.super Ljava/lang/Object;
.source "SearchView.java"

# interfaces
.implements Landroid/view/View$OnKeyListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/widget/SearchView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroid/widget/SearchView;


# direct methods
.method constructor <init>(Landroid/widget/SearchView;)V
    .registers 2
    .parameter

    .prologue
    .line 902
    iput-object p1, p0, Landroid/widget/SearchView$7;->this$0:Landroid/widget/SearchView;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onKey(Landroid/view/View;ILandroid/view/KeyEvent;)Z
    .registers 10
    .parameter "v"
    .parameter "keyCode"
    .parameter "event"

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 905
    iget-object v3, p0, Landroid/widget/SearchView$7;->this$0:Landroid/widget/SearchView;

    #getter for: Landroid/widget/SearchView;->mSearchable:Landroid/app/SearchableInfo;
    invoke-static {v3}, Landroid/widget/SearchView;->access$1400(Landroid/widget/SearchView;)Landroid/app/SearchableInfo;

    move-result-object v3

    if-nez v3, :cond_b

    .line 943
    :cond_a
    :goto_a
    return v1

    .line 916
    :cond_b
    iget-object v3, p0, Landroid/widget/SearchView$7;->this$0:Landroid/widget/SearchView;

    #getter for: Landroid/widget/SearchView;->mQueryTextView:Landroid/widget/SearchView$SearchAutoComplete;
    invoke-static {v3}, Landroid/widget/SearchView;->access$1200(Landroid/widget/SearchView;)Landroid/widget/SearchView$SearchAutoComplete;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/SearchView$SearchAutoComplete;->isPopupShowing()Z

    move-result v3

    if-eqz v3, :cond_2b

    iget-object v3, p0, Landroid/widget/SearchView$7;->this$0:Landroid/widget/SearchView;

    #getter for: Landroid/widget/SearchView;->mQueryTextView:Landroid/widget/SearchView$SearchAutoComplete;
    invoke-static {v3}, Landroid/widget/SearchView;->access$1200(Landroid/widget/SearchView;)Landroid/widget/SearchView$SearchAutoComplete;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/SearchView$SearchAutoComplete;->getListSelection()I

    move-result v3

    const/4 v4, -0x1

    if-eq v3, v4, :cond_2b

    .line 918
    iget-object v1, p0, Landroid/widget/SearchView$7;->this$0:Landroid/widget/SearchView;

    #calls: Landroid/widget/SearchView;->onSuggestionsKey(Landroid/view/View;ILandroid/view/KeyEvent;)Z
    invoke-static {v1, p1, p2, p3}, Landroid/widget/SearchView;->access$1500(Landroid/widget/SearchView;Landroid/view/View;ILandroid/view/KeyEvent;)Z

    move-result v1

    goto :goto_a

    .line 923
    :cond_2b
    iget-object v3, p0, Landroid/widget/SearchView$7;->this$0:Landroid/widget/SearchView;

    #getter for: Landroid/widget/SearchView;->mQueryTextView:Landroid/widget/SearchView$SearchAutoComplete;
    invoke-static {v3}, Landroid/widget/SearchView;->access$1200(Landroid/widget/SearchView;)Landroid/widget/SearchView$SearchAutoComplete;

    move-result-object v3

    #calls: Landroid/widget/SearchView$SearchAutoComplete;->isEmpty()Z
    invoke-static {v3}, Landroid/widget/SearchView$SearchAutoComplete;->access$1600(Landroid/widget/SearchView$SearchAutoComplete;)Z

    move-result v3

    if-nez v3, :cond_a

    invoke-virtual {p3}, Landroid/view/KeyEvent;->hasNoModifiers()Z

    move-result v3

    if-eqz v3, :cond_a

    .line 924
    invoke-virtual {p3}, Landroid/view/KeyEvent;->getAction()I

    move-result v3

    if-ne v3, v2, :cond_60

    .line 925
    const/16 v3, 0x42

    if-ne p2, v3, :cond_60

    .line 926
    invoke-virtual {p1}, Landroid/view/View;->cancelLongPress()V

    .line 929
    iget-object v3, p0, Landroid/widget/SearchView$7;->this$0:Landroid/widget/SearchView;

    const/4 v4, 0x0

    iget-object v5, p0, Landroid/widget/SearchView$7;->this$0:Landroid/widget/SearchView;

    #getter for: Landroid/widget/SearchView;->mQueryTextView:Landroid/widget/SearchView$SearchAutoComplete;
    invoke-static {v5}, Landroid/widget/SearchView;->access$1200(Landroid/widget/SearchView;)Landroid/widget/SearchView$SearchAutoComplete;

    move-result-object v5

    invoke-virtual {v5}, Landroid/widget/SearchView$SearchAutoComplete;->getText()Landroid/text/Editable;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    #calls: Landroid/widget/SearchView;->launchQuerySearch(ILjava/lang/String;Ljava/lang/String;)V
    invoke-static {v3, v1, v4, v5}, Landroid/widget/SearchView;->access$1700(Landroid/widget/SearchView;ILjava/lang/String;Ljava/lang/String;)V

    move v1, v2

    .line 931
    goto :goto_a

    .line 934
    :cond_60
    invoke-virtual {p3}, Landroid/view/KeyEvent;->getAction()I

    move-result v3

    if-nez v3, :cond_a

    .line 935
    iget-object v3, p0, Landroid/widget/SearchView$7;->this$0:Landroid/widget/SearchView;

    #getter for: Landroid/widget/SearchView;->mSearchable:Landroid/app/SearchableInfo;
    invoke-static {v3}, Landroid/widget/SearchView;->access$1400(Landroid/widget/SearchView;)Landroid/app/SearchableInfo;

    move-result-object v3

    invoke-virtual {v3, p2}, Landroid/app/SearchableInfo;->findActionKey(I)Landroid/app/SearchableInfo$ActionKeyInfo;

    move-result-object v0

    .line 936
    .local v0, actionKey:Landroid/app/SearchableInfo$ActionKeyInfo;
    if-eqz v0, :cond_a

    invoke-virtual {v0}, Landroid/app/SearchableInfo$ActionKeyInfo;->getQueryActionMsg()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_a

    .line 937
    iget-object v1, p0, Landroid/widget/SearchView$7;->this$0:Landroid/widget/SearchView;

    invoke-virtual {v0}, Landroid/app/SearchableInfo$ActionKeyInfo;->getQueryActionMsg()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Landroid/widget/SearchView$7;->this$0:Landroid/widget/SearchView;

    #getter for: Landroid/widget/SearchView;->mQueryTextView:Landroid/widget/SearchView$SearchAutoComplete;
    invoke-static {v4}, Landroid/widget/SearchView;->access$1200(Landroid/widget/SearchView;)Landroid/widget/SearchView$SearchAutoComplete;

    move-result-object v4

    invoke-virtual {v4}, Landroid/widget/SearchView$SearchAutoComplete;->getText()Landroid/text/Editable;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    #calls: Landroid/widget/SearchView;->launchQuerySearch(ILjava/lang/String;Ljava/lang/String;)V
    invoke-static {v1, p2, v3, v4}, Landroid/widget/SearchView;->access$1700(Landroid/widget/SearchView;ILjava/lang/String;Ljava/lang/String;)V

    move v1, v2

    .line 939
    goto/16 :goto_a
.end method
