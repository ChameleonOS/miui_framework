.class public Landroid/widget/MultiAutoCompleteTextView;
.super Landroid/widget/AutoCompleteTextView;
.source "MultiAutoCompleteTextView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/widget/MultiAutoCompleteTextView$CommaTokenizer;,
        Landroid/widget/MultiAutoCompleteTextView$Tokenizer;
    }
.end annotation


# instance fields
.field private mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .registers 3
    .parameter "context"

    .prologue
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroid/widget/MultiAutoCompleteTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 4
    .parameter "context"
    .parameter "attrs"

    .prologue
    const v0, 0x101006b

    invoke-direct {p0, p1, p2, v0}, Landroid/widget/MultiAutoCompleteTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .registers 4
    .parameter "context"
    .parameter "attrs"
    .parameter "defStyle"

    .prologue
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/AutoCompleteTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    return-void
.end method


# virtual methods
.method public enoughToFilter()Z
    .registers 7

    .prologue
    const/4 v3, 0x0

    invoke-virtual {p0}, Landroid/widget/MultiAutoCompleteTextView;->getText()Landroid/text/Editable;

    move-result-object v2

    .local v2, text:Landroid/text/Editable;
    invoke-virtual {p0}, Landroid/widget/MultiAutoCompleteTextView;->getSelectionEnd()I

    move-result v0

    .local v0, end:I
    if-ltz v0, :cond_f

    iget-object v4, p0, Landroid/widget/MultiAutoCompleteTextView;->mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

    if-nez v4, :cond_10

    :cond_f
    :goto_f
    return v3

    :cond_10
    iget-object v4, p0, Landroid/widget/MultiAutoCompleteTextView;->mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

    invoke-interface {v4, v2, v0}, Landroid/widget/MultiAutoCompleteTextView$Tokenizer;->findTokenStart(Ljava/lang/CharSequence;I)I

    move-result v1

    .local v1, start:I
    sub-int v4, v0, v1

    invoke-virtual {p0}, Landroid/widget/MultiAutoCompleteTextView;->getThreshold()I

    move-result v5

    if-lt v4, v5, :cond_f

    const/4 v3, 0x1

    goto :goto_f
.end method

.method finishInit()V
    .registers 1

    .prologue
    return-void
.end method

.method public onInitializeAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V
    .registers 3
    .parameter "event"

    .prologue
    invoke-super {p0, p1}, Landroid/widget/AutoCompleteTextView;->onInitializeAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)V

    const-class v0, Landroid/widget/MultiAutoCompleteTextView;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityEvent;->setClassName(Ljava/lang/CharSequence;)V

    return-void
.end method

.method public onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V
    .registers 3
    .parameter "info"

    .prologue
    invoke-super {p0, p1}, Landroid/widget/AutoCompleteTextView;->onInitializeAccessibilityNodeInfo(Landroid/view/accessibility/AccessibilityNodeInfo;)V

    const-class v0, Landroid/widget/MultiAutoCompleteTextView;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/view/accessibility/AccessibilityNodeInfo;->setClassName(Ljava/lang/CharSequence;)V

    return-void
.end method

.method protected performFiltering(Ljava/lang/CharSequence;I)V
    .registers 7
    .parameter "text"
    .parameter "keyCode"

    .prologue
    invoke-virtual {p0}, Landroid/widget/MultiAutoCompleteTextView;->enoughToFilter()Z

    move-result v3

    if-eqz v3, :cond_14

    invoke-virtual {p0}, Landroid/widget/MultiAutoCompleteTextView;->getSelectionEnd()I

    move-result v0

    .local v0, end:I
    iget-object v3, p0, Landroid/widget/MultiAutoCompleteTextView;->mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

    invoke-interface {v3, p1, v0}, Landroid/widget/MultiAutoCompleteTextView$Tokenizer;->findTokenStart(Ljava/lang/CharSequence;I)I

    move-result v2

    .local v2, start:I
    invoke-virtual {p0, p1, v2, v0, p2}, Landroid/widget/MultiAutoCompleteTextView;->performFiltering(Ljava/lang/CharSequence;III)V

    .end local v0           #end:I
    .end local v2           #start:I
    :cond_13
    :goto_13
    return-void

    :cond_14
    invoke-virtual {p0}, Landroid/widget/MultiAutoCompleteTextView;->dismissDropDown()V

    invoke-virtual {p0}, Landroid/widget/MultiAutoCompleteTextView;->getFilter()Landroid/widget/Filter;

    move-result-object v1

    .local v1, f:Landroid/widget/Filter;
    if-eqz v1, :cond_13

    const/4 v3, 0x0

    invoke-virtual {v1, v3}, Landroid/widget/Filter;->filter(Ljava/lang/CharSequence;)V

    goto :goto_13
.end method

.method protected performFiltering(Ljava/lang/CharSequence;III)V
    .registers 7
    .parameter "text"
    .parameter "start"
    .parameter "end"
    .parameter "keyCode"

    .prologue
    invoke-virtual {p0}, Landroid/widget/MultiAutoCompleteTextView;->getFilter()Landroid/widget/Filter;

    move-result-object v0

    invoke-interface {p1, p2, p3}, Ljava/lang/CharSequence;->subSequence(II)Ljava/lang/CharSequence;

    move-result-object v1

    invoke-virtual {v0, v1, p0}, Landroid/widget/Filter;->filter(Ljava/lang/CharSequence;Landroid/widget/Filter$FilterListener;)V

    return-void
.end method

.method public performValidation()V
    .registers 9

    .prologue
    invoke-virtual {p0}, Landroid/widget/MultiAutoCompleteTextView;->getValidator()Landroid/widget/AutoCompleteTextView$Validator;

    move-result-object v5

    .local v5, v:Landroid/widget/AutoCompleteTextView$Validator;
    if-eqz v5, :cond_a

    iget-object v6, p0, Landroid/widget/MultiAutoCompleteTextView;->mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

    if-nez v6, :cond_b

    :cond_a
    return-void

    :cond_b
    invoke-virtual {p0}, Landroid/widget/MultiAutoCompleteTextView;->getText()Landroid/text/Editable;

    move-result-object v0

    .local v0, e:Landroid/text/Editable;
    invoke-virtual {p0}, Landroid/widget/MultiAutoCompleteTextView;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-interface {v6}, Landroid/text/Editable;->length()I

    move-result v2

    .local v2, i:I
    :goto_17
    if-lez v2, :cond_a

    iget-object v6, p0, Landroid/widget/MultiAutoCompleteTextView;->mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

    invoke-interface {v6, v0, v2}, Landroid/widget/MultiAutoCompleteTextView$Tokenizer;->findTokenStart(Ljava/lang/CharSequence;I)I

    move-result v3

    .local v3, start:I
    iget-object v6, p0, Landroid/widget/MultiAutoCompleteTextView;->mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

    invoke-interface {v6, v0, v3}, Landroid/widget/MultiAutoCompleteTextView$Tokenizer;->findTokenEnd(Ljava/lang/CharSequence;I)I

    move-result v1

    .local v1, end:I
    invoke-interface {v0, v3, v1}, Landroid/text/Editable;->subSequence(II)Ljava/lang/CharSequence;

    move-result-object v4

    .local v4, sub:Ljava/lang/CharSequence;
    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-eqz v6, :cond_36

    const-string v6, ""

    invoke-interface {v0, v3, v2, v6}, Landroid/text/Editable;->replace(IILjava/lang/CharSequence;)Landroid/text/Editable;

    :cond_34
    :goto_34
    move v2, v3

    goto :goto_17

    :cond_36
    invoke-interface {v5, v4}, Landroid/widget/AutoCompleteTextView$Validator;->isValid(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_34

    iget-object v6, p0, Landroid/widget/MultiAutoCompleteTextView;->mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

    invoke-interface {v5, v4}, Landroid/widget/AutoCompleteTextView$Validator;->fixText(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;

    move-result-object v7

    invoke-interface {v6, v7}, Landroid/widget/MultiAutoCompleteTextView$Tokenizer;->terminateToken(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;

    move-result-object v6

    invoke-interface {v0, v3, v2, v6}, Landroid/text/Editable;->replace(IILjava/lang/CharSequence;)Landroid/text/Editable;

    goto :goto_34
.end method

.method protected replaceText(Ljava/lang/CharSequence;)V
    .registers 8
    .parameter "text"

    .prologue
    invoke-virtual {p0}, Landroid/widget/MultiAutoCompleteTextView;->clearComposingText()V

    invoke-virtual {p0}, Landroid/widget/MultiAutoCompleteTextView;->getSelectionEnd()I

    move-result v1

    .local v1, end:I
    iget-object v4, p0, Landroid/widget/MultiAutoCompleteTextView;->mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

    invoke-virtual {p0}, Landroid/widget/MultiAutoCompleteTextView;->getText()Landroid/text/Editable;

    move-result-object v5

    invoke-interface {v4, v5, v1}, Landroid/widget/MultiAutoCompleteTextView$Tokenizer;->findTokenStart(Ljava/lang/CharSequence;I)I

    move-result v3

    .local v3, start:I
    invoke-virtual {p0}, Landroid/widget/MultiAutoCompleteTextView;->getText()Landroid/text/Editable;

    move-result-object v0

    .local v0, editable:Landroid/text/Editable;
    invoke-static {v0, v3, v1}, Landroid/text/TextUtils;->substring(Ljava/lang/CharSequence;II)Ljava/lang/String;

    move-result-object v2

    .local v2, original:Ljava/lang/String;
    invoke-static {v0, v3, v1, v2}, Landroid/text/method/QwertyKeyListener;->markAsReplaced(Landroid/text/Spannable;IILjava/lang/String;)V

    iget-object v4, p0, Landroid/widget/MultiAutoCompleteTextView;->mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

    invoke-interface {v4, p1}, Landroid/widget/MultiAutoCompleteTextView$Tokenizer;->terminateToken(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;

    move-result-object v4

    invoke-interface {v0, v3, v1, v4}, Landroid/text/Editable;->replace(IILjava/lang/CharSequence;)Landroid/text/Editable;

    return-void
.end method

.method public setTokenizer(Landroid/widget/MultiAutoCompleteTextView$Tokenizer;)V
    .registers 2
    .parameter "t"

    .prologue
    iput-object p1, p0, Landroid/widget/MultiAutoCompleteTextView;->mTokenizer:Landroid/widget/MultiAutoCompleteTextView$Tokenizer;

    return-void
.end method
