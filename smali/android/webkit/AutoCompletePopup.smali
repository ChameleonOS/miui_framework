.class Landroid/webkit/AutoCompletePopup;
.super Ljava/lang/Object;
.source "AutoCompletePopup.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;
.implements Landroid/widget/Filter$FilterListener;
.implements Landroid/widget/PopupWindow$OnDismissListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/webkit/AutoCompletePopup$AnchorView;
    }
.end annotation


# static fields
.field private static final AUTOFILL_FORM:I = 0x64


# instance fields
.field private mAdapter:Landroid/widget/ListAdapter;

.field private mAnchor:Landroid/view/View;

.field private mFilter:Landroid/widget/Filter;

.field private mHandler:Landroid/os/Handler;

.field private mInputConnection:Landroid/webkit/WebViewClassic$WebViewInputConnection;

.field private mIsAutoFillProfileSet:Z

.field private mPopup:Landroid/widget/ListPopupWindow;

.field private mQueryId:I

.field private mText:Ljava/lang/CharSequence;

.field private mWebView:Landroid/webkit/WebViewClassic;


# direct methods
.method public constructor <init>(Landroid/webkit/WebViewClassic;Landroid/webkit/WebViewClassic$WebViewInputConnection;)V
    .registers 4
    .parameter "webView"
    .parameter "inputConnection"

    .prologue
    .line 55
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 56
    iput-object p2, p0, Landroid/webkit/AutoCompletePopup;->mInputConnection:Landroid/webkit/WebViewClassic$WebViewInputConnection;

    .line 57
    iput-object p1, p0, Landroid/webkit/AutoCompletePopup;->mWebView:Landroid/webkit/WebViewClassic;

    .line 58
    new-instance v0, Landroid/webkit/AutoCompletePopup$1;

    invoke-direct {v0, p0}, Landroid/webkit/AutoCompletePopup$1;-><init>(Landroid/webkit/AutoCompletePopup;)V

    iput-object v0, p0, Landroid/webkit/AutoCompletePopup;->mHandler:Landroid/os/Handler;

    .line 68
    return-void
.end method

.method static synthetic access$000(Landroid/webkit/AutoCompletePopup;)I
    .registers 2
    .parameter "x0"

    .prologue
    .line 33
    iget v0, p0, Landroid/webkit/AutoCompletePopup;->mQueryId:I

    return v0
.end method

.method static synthetic access$100(Landroid/webkit/AutoCompletePopup;)Landroid/webkit/WebViewClassic;
    .registers 2
    .parameter "x0"

    .prologue
    .line 33
    iget-object v0, p0, Landroid/webkit/AutoCompletePopup;->mWebView:Landroid/webkit/WebViewClassic;

    return-object v0
.end method

.method private ensurePopup()V
    .registers 3

    .prologue
    .line 239
    iget-object v0, p0, Landroid/webkit/AutoCompletePopup;->mPopup:Landroid/widget/ListPopupWindow;

    if-nez v0, :cond_3c

    .line 240
    new-instance v0, Landroid/widget/ListPopupWindow;

    iget-object v1, p0, Landroid/webkit/AutoCompletePopup;->mWebView:Landroid/webkit/WebViewClassic;

    invoke-virtual {v1}, Landroid/webkit/WebViewClassic;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/widget/ListPopupWindow;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Landroid/webkit/AutoCompletePopup;->mPopup:Landroid/widget/ListPopupWindow;

    .line 241
    new-instance v0, Landroid/webkit/AutoCompletePopup$AnchorView;

    iget-object v1, p0, Landroid/webkit/AutoCompletePopup;->mWebView:Landroid/webkit/WebViewClassic;

    invoke-virtual {v1}, Landroid/webkit/WebViewClassic;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/webkit/AutoCompletePopup$AnchorView;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Landroid/webkit/AutoCompletePopup;->mAnchor:Landroid/view/View;

    .line 242
    iget-object v0, p0, Landroid/webkit/AutoCompletePopup;->mWebView:Landroid/webkit/WebViewClassic;

    invoke-virtual {v0}, Landroid/webkit/WebViewClassic;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    iget-object v1, p0, Landroid/webkit/AutoCompletePopup;->mAnchor:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->addView(Landroid/view/View;)V

    .line 243
    iget-object v0, p0, Landroid/webkit/AutoCompletePopup;->mPopup:Landroid/widget/ListPopupWindow;

    invoke-virtual {v0, p0}, Landroid/widget/ListPopupWindow;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 244
    iget-object v0, p0, Landroid/webkit/AutoCompletePopup;->mPopup:Landroid/widget/ListPopupWindow;

    iget-object v1, p0, Landroid/webkit/AutoCompletePopup;->mAnchor:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/widget/ListPopupWindow;->setAnchorView(Landroid/view/View;)V

    .line 245
    iget-object v0, p0, Landroid/webkit/AutoCompletePopup;->mPopup:Landroid/widget/ListPopupWindow;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/ListPopupWindow;->setPromptPosition(I)V

    .line 249
    :cond_3b
    :goto_3b
    return-void

    .line 246
    :cond_3c
    iget-object v0, p0, Landroid/webkit/AutoCompletePopup;->mWebView:Landroid/webkit/WebViewClassic;

    invoke-virtual {v0}, Landroid/webkit/WebViewClassic;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    iget-object v1, p0, Landroid/webkit/AutoCompletePopup;->mAnchor:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->indexOfChild(Landroid/view/View;)I

    move-result v0

    if-gez v0, :cond_3b

    .line 247
    iget-object v0, p0, Landroid/webkit/AutoCompletePopup;->mWebView:Landroid/webkit/WebViewClassic;

    invoke-virtual {v0}, Landroid/webkit/WebViewClassic;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    iget-object v1, p0, Landroid/webkit/AutoCompletePopup;->mAnchor:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->addView(Landroid/view/View;)V

    goto :goto_3b
.end method

.method private pushTextToInputConnection()V
    .registers 5

    .prologue
    .line 210
    iget-object v1, p0, Landroid/webkit/AutoCompletePopup;->mInputConnection:Landroid/webkit/WebViewClassic$WebViewInputConnection;

    invoke-virtual {v1}, Landroid/webkit/WebViewClassic$WebViewInputConnection;->getEditable()Landroid/text/Editable;

    move-result-object v0

    .line 211
    .local v0, oldText:Landroid/text/Editable;
    iget-object v1, p0, Landroid/webkit/AutoCompletePopup;->mInputConnection:Landroid/webkit/WebViewClassic$WebViewInputConnection;

    const/4 v2, 0x0

    invoke-interface {v0}, Landroid/text/Editable;->length()I

    move-result v3

    invoke-virtual {v1, v2, v3}, Landroid/webkit/WebViewClassic$WebViewInputConnection;->setSelection(II)Z

    .line 212
    iget-object v1, p0, Landroid/webkit/AutoCompletePopup;->mInputConnection:Landroid/webkit/WebViewClassic$WebViewInputConnection;

    iget-object v2, p0, Landroid/webkit/AutoCompletePopup;->mText:Ljava/lang/CharSequence;

    invoke-virtual {v1, v2}, Landroid/webkit/WebViewClassic$WebViewInputConnection;->replaceSelection(Ljava/lang/CharSequence;)V

    .line 213
    iget-object v1, p0, Landroid/webkit/AutoCompletePopup;->mInputConnection:Landroid/webkit/WebViewClassic$WebViewInputConnection;

    iget-object v2, p0, Landroid/webkit/AutoCompletePopup;->mText:Ljava/lang/CharSequence;

    invoke-interface {v2}, Ljava/lang/CharSequence;->length()I

    move-result v2

    iget-object v3, p0, Landroid/webkit/AutoCompletePopup;->mText:Ljava/lang/CharSequence;

    invoke-interface {v3}, Ljava/lang/CharSequence;->length()I

    move-result v3

    invoke-virtual {v1, v2, v3}, Landroid/webkit/WebViewClassic$WebViewInputConnection;->setSelection(II)Z

    .line 214
    return-void
.end method


# virtual methods
.method public clearAdapter()V
    .registers 3

    .prologue
    const/4 v1, 0x0

    .line 112
    iput-object v1, p0, Landroid/webkit/AutoCompletePopup;->mAdapter:Landroid/widget/ListAdapter;

    .line 113
    iput-object v1, p0, Landroid/webkit/AutoCompletePopup;->mFilter:Landroid/widget/Filter;

    .line 114
    iget-object v0, p0, Landroid/webkit/AutoCompletePopup;->mPopup:Landroid/widget/ListPopupWindow;

    if-eqz v0, :cond_13

    .line 115
    iget-object v0, p0, Landroid/webkit/AutoCompletePopup;->mPopup:Landroid/widget/ListPopupWindow;

    invoke-virtual {v0}, Landroid/widget/ListPopupWindow;->dismiss()V

    .line 116
    iget-object v0, p0, Landroid/webkit/AutoCompletePopup;->mPopup:Landroid/widget/ListPopupWindow;

    invoke-virtual {v0, v1}, Landroid/widget/ListPopupWindow;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 118
    :cond_13
    return-void
.end method

.method public onDismiss()V
    .registers 3

    .prologue
    .line 235
    iget-object v0, p0, Landroid/webkit/AutoCompletePopup;->mWebView:Landroid/webkit/WebViewClassic;

    invoke-virtual {v0}, Landroid/webkit/WebViewClassic;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    iget-object v1, p0, Landroid/webkit/AutoCompletePopup;->mAnchor:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->removeView(Landroid/view/View;)V

    .line 236
    return-void
.end method

.method public onFilterComplete(I)V
    .registers 6
    .parameter "count"

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 218
    invoke-direct {p0}, Landroid/webkit/AutoCompletePopup;->ensurePopup()V

    .line 219
    if-lez p1, :cond_36

    iget-object v3, p0, Landroid/webkit/AutoCompletePopup;->mInputConnection:Landroid/webkit/WebViewClassic$WebViewInputConnection;

    invoke-virtual {v3}, Landroid/webkit/WebViewClassic$WebViewInputConnection;->getIsAutoFillable()Z

    move-result v3

    if-nez v3, :cond_17

    iget-object v3, p0, Landroid/webkit/AutoCompletePopup;->mText:Ljava/lang/CharSequence;

    invoke-interface {v3}, Ljava/lang/CharSequence;->length()I

    move-result v3

    if-lez v3, :cond_36

    :cond_17
    move v0, v1

    .line 221
    .local v0, showDropDown:Z
    :goto_18
    if-eqz v0, :cond_38

    .line 222
    iget-object v3, p0, Landroid/webkit/AutoCompletePopup;->mPopup:Landroid/widget/ListPopupWindow;

    invoke-virtual {v3}, Landroid/widget/ListPopupWindow;->isShowing()Z

    move-result v3

    if-nez v3, :cond_27

    .line 224
    iget-object v3, p0, Landroid/webkit/AutoCompletePopup;->mPopup:Landroid/widget/ListPopupWindow;

    invoke-virtual {v3, v1}, Landroid/widget/ListPopupWindow;->setInputMethodMode(I)V

    .line 226
    :cond_27
    iget-object v1, p0, Landroid/webkit/AutoCompletePopup;->mPopup:Landroid/widget/ListPopupWindow;

    invoke-virtual {v1}, Landroid/widget/ListPopupWindow;->show()V

    .line 227
    iget-object v1, p0, Landroid/webkit/AutoCompletePopup;->mPopup:Landroid/widget/ListPopupWindow;

    invoke-virtual {v1}, Landroid/widget/ListPopupWindow;->getListView()Landroid/widget/ListView;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/widget/ListView;->setOverScrollMode(I)V

    .line 231
    :goto_35
    return-void

    .end local v0           #showDropDown:Z
    :cond_36
    move v0, v2

    .line 219
    goto :goto_18

    .line 229
    .restart local v0       #showDropDown:Z
    :cond_38
    iget-object v1, p0, Landroid/webkit/AutoCompletePopup;->mPopup:Landroid/widget/ListPopupWindow;

    invoke-virtual {v1}, Landroid/widget/ListPopupWindow;->dismiss()V

    goto :goto_35
.end method

.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .registers 10
    .parameter
    .parameter "view"
    .parameter "position"
    .parameter "id"
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 170
    .local p1, parent:Landroid/widget/AdapterView;,"Landroid/widget/AdapterView<*>;"
    iget-object v2, p0, Landroid/webkit/AutoCompletePopup;->mPopup:Landroid/widget/ListPopupWindow;

    if-nez v2, :cond_5

    .line 203
    :goto_4
    return-void

    .line 173
    :cond_5
    const-wide/16 v2, 0x0

    cmp-long v2, p4, v2

    if-nez v2, :cond_41

    if-nez p3, :cond_41

    iget-object v2, p0, Landroid/webkit/AutoCompletePopup;->mInputConnection:Landroid/webkit/WebViewClassic$WebViewInputConnection;

    invoke-virtual {v2}, Landroid/webkit/WebViewClassic$WebViewInputConnection;->getIsAutoFillable()Z

    move-result v2

    if-eqz v2, :cond_41

    .line 174
    const-string v2, ""

    iput-object v2, p0, Landroid/webkit/AutoCompletePopup;->mText:Ljava/lang/CharSequence;

    .line 175
    invoke-direct {p0}, Landroid/webkit/AutoCompletePopup;->pushTextToInputConnection()V

    .line 177
    iget-boolean v2, p0, Landroid/webkit/AutoCompletePopup;->mIsAutoFillProfileSet:Z

    if-eqz v2, :cond_2d

    .line 179
    iget-object v2, p0, Landroid/webkit/AutoCompletePopup;->mWebView:Landroid/webkit/WebViewClassic;

    iget v3, p0, Landroid/webkit/AutoCompletePopup;->mQueryId:I

    invoke-virtual {v2, v3}, Landroid/webkit/WebViewClassic;->autoFillForm(I)V

    .line 202
    :cond_27
    :goto_27
    iget-object v2, p0, Landroid/webkit/AutoCompletePopup;->mPopup:Landroid/widget/ListPopupWindow;

    invoke-virtual {v2}, Landroid/widget/ListPopupWindow;->dismiss()V

    goto :goto_4

    .line 184
    :cond_2d
    iget-object v2, p0, Landroid/webkit/AutoCompletePopup;->mWebView:Landroid/webkit/WebViewClassic;

    invoke-virtual {v2}, Landroid/webkit/WebViewClassic;->getWebChromeClient()Landroid/webkit/WebChromeClient;

    move-result-object v1

    .line 185
    .local v1, webChromeClient:Landroid/webkit/WebChromeClient;
    if-eqz v1, :cond_27

    .line 186
    iget-object v2, p0, Landroid/webkit/AutoCompletePopup;->mHandler:Landroid/os/Handler;

    const/16 v3, 0x64

    invoke-virtual {v2, v3}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/webkit/WebChromeClient;->setupAutoFill(Landroid/os/Message;)V

    goto :goto_27

    .line 192
    .end local v1           #webChromeClient:Landroid/webkit/WebChromeClient;
    :cond_41
    if-gez p3, :cond_58

    .line 193
    iget-object v2, p0, Landroid/webkit/AutoCompletePopup;->mPopup:Landroid/widget/ListPopupWindow;

    invoke-virtual {v2}, Landroid/widget/ListPopupWindow;->getSelectedItem()Ljava/lang/Object;

    move-result-object v0

    .line 197
    .local v0, selectedItem:Ljava/lang/Object;
    :goto_49
    if-eqz v0, :cond_27

    .line 198
    iget-object v2, p0, Landroid/webkit/AutoCompletePopup;->mFilter:Landroid/widget/Filter;

    invoke-virtual {v2, v0}, Landroid/widget/Filter;->convertResultToString(Ljava/lang/Object;)Ljava/lang/CharSequence;

    move-result-object v2

    invoke-virtual {p0, v2}, Landroid/webkit/AutoCompletePopup;->setText(Ljava/lang/CharSequence;)V

    .line 199
    invoke-direct {p0}, Landroid/webkit/AutoCompletePopup;->pushTextToInputConnection()V

    goto :goto_27

    .line 195
    .end local v0           #selectedItem:Ljava/lang/Object;
    :cond_58
    iget-object v2, p0, Landroid/webkit/AutoCompletePopup;->mAdapter:Landroid/widget/ListAdapter;

    invoke-interface {v2, p3}, Landroid/widget/ListAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    .restart local v0       #selectedItem:Ljava/lang/Object;
    goto :goto_49
.end method

.method public onKeyPreIme(ILandroid/view/KeyEvent;)Z
    .registers 7
    .parameter "keyCode"
    .parameter "event"

    .prologue
    const/4 v1, 0x0

    const/4 v2, 0x1

    .line 71
    iget-object v3, p0, Landroid/webkit/AutoCompletePopup;->mPopup:Landroid/widget/ListPopupWindow;

    if-nez v3, :cond_7

    .line 97
    :cond_6
    :goto_6
    return v1

    .line 74
    :cond_7
    const/4 v3, 0x4

    if-ne p1, v3, :cond_4f

    iget-object v3, p0, Landroid/webkit/AutoCompletePopup;->mPopup:Landroid/widget/ListPopupWindow;

    invoke-virtual {v3}, Landroid/widget/ListPopupWindow;->isShowing()Z

    move-result v3

    if-eqz v3, :cond_4f

    .line 77
    invoke-virtual {p2}, Landroid/view/KeyEvent;->getAction()I

    move-result v3

    if-nez v3, :cond_2b

    invoke-virtual {p2}, Landroid/view/KeyEvent;->getRepeatCount()I

    move-result v3

    if-nez v3, :cond_2b

    .line 78
    iget-object v1, p0, Landroid/webkit/AutoCompletePopup;->mAnchor:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getKeyDispatcherState()Landroid/view/KeyEvent$DispatcherState;

    move-result-object v0

    .line 79
    .local v0, state:Landroid/view/KeyEvent$DispatcherState;
    if-eqz v0, :cond_29

    .line 80
    invoke-virtual {v0, p2, p0}, Landroid/view/KeyEvent$DispatcherState;->startTracking(Landroid/view/KeyEvent;Ljava/lang/Object;)V

    :cond_29
    move v1, v2

    .line 82
    goto :goto_6

    .line 83
    .end local v0           #state:Landroid/view/KeyEvent$DispatcherState;
    :cond_2b
    invoke-virtual {p2}, Landroid/view/KeyEvent;->getAction()I

    move-result v3

    if-ne v3, v2, :cond_4f

    .line 84
    iget-object v3, p0, Landroid/webkit/AutoCompletePopup;->mAnchor:Landroid/view/View;

    invoke-virtual {v3}, Landroid/view/View;->getKeyDispatcherState()Landroid/view/KeyEvent$DispatcherState;

    move-result-object v0

    .line 85
    .restart local v0       #state:Landroid/view/KeyEvent$DispatcherState;
    if-eqz v0, :cond_3c

    .line 86
    invoke-virtual {v0, p2}, Landroid/view/KeyEvent$DispatcherState;->handleUpEvent(Landroid/view/KeyEvent;)V

    .line 88
    :cond_3c
    invoke-virtual {p2}, Landroid/view/KeyEvent;->isTracking()Z

    move-result v3

    if-eqz v3, :cond_4f

    invoke-virtual {p2}, Landroid/view/KeyEvent;->isCanceled()Z

    move-result v3

    if-nez v3, :cond_4f

    .line 89
    iget-object v1, p0, Landroid/webkit/AutoCompletePopup;->mPopup:Landroid/widget/ListPopupWindow;

    invoke-virtual {v1}, Landroid/widget/ListPopupWindow;->dismiss()V

    move v1, v2

    .line 90
    goto :goto_6

    .line 94
    .end local v0           #state:Landroid/view/KeyEvent$DispatcherState;
    :cond_4f
    iget-object v2, p0, Landroid/webkit/AutoCompletePopup;->mPopup:Landroid/widget/ListPopupWindow;

    invoke-virtual {v2}, Landroid/widget/ListPopupWindow;->isShowing()Z

    move-result v2

    if-eqz v2, :cond_6

    .line 95
    iget-object v1, p0, Landroid/webkit/AutoCompletePopup;->mPopup:Landroid/widget/ListPopupWindow;

    invoke-virtual {v1, p1, p2}, Landroid/widget/ListPopupWindow;->onKeyPreIme(ILandroid/view/KeyEvent;)Z

    move-result v1

    goto :goto_6
.end method

.method public resetRect()V
    .registers 11

    .prologue
    .line 134
    invoke-direct {p0}, Landroid/webkit/AutoCompletePopup;->ensurePopup()V

    .line 135
    iget-object v8, p0, Landroid/webkit/AutoCompletePopup;->mWebView:Landroid/webkit/WebViewClassic;

    iget-object v9, p0, Landroid/webkit/AutoCompletePopup;->mWebView:Landroid/webkit/WebViewClassic;

    iget-object v9, v9, Landroid/webkit/WebViewClassic;->mEditTextContentBounds:Landroid/graphics/Rect;

    iget v9, v9, Landroid/graphics/Rect;->left:I

    invoke-virtual {v8, v9}, Landroid/webkit/WebViewClassic;->contentToViewX(I)I

    move-result v2

    .line 136
    .local v2, left:I
    iget-object v8, p0, Landroid/webkit/AutoCompletePopup;->mWebView:Landroid/webkit/WebViewClassic;

    iget-object v9, p0, Landroid/webkit/AutoCompletePopup;->mWebView:Landroid/webkit/WebViewClassic;

    iget-object v9, v9, Landroid/webkit/WebViewClassic;->mEditTextContentBounds:Landroid/graphics/Rect;

    iget v9, v9, Landroid/graphics/Rect;->right:I

    invoke-virtual {v8, v9}, Landroid/webkit/WebViewClassic;->contentToViewX(I)I

    move-result v5

    .line 137
    .local v5, right:I
    sub-int v7, v5, v2

    .line 138
    .local v7, width:I
    iget-object v8, p0, Landroid/webkit/AutoCompletePopup;->mPopup:Landroid/widget/ListPopupWindow;

    invoke-virtual {v8, v7}, Landroid/widget/ListPopupWindow;->setWidth(I)V

    .line 140
    iget-object v8, p0, Landroid/webkit/AutoCompletePopup;->mWebView:Landroid/webkit/WebViewClassic;

    iget-object v9, p0, Landroid/webkit/AutoCompletePopup;->mWebView:Landroid/webkit/WebViewClassic;

    iget-object v9, v9, Landroid/webkit/WebViewClassic;->mEditTextContentBounds:Landroid/graphics/Rect;

    iget v9, v9, Landroid/graphics/Rect;->bottom:I

    invoke-virtual {v8, v9}, Landroid/webkit/WebViewClassic;->contentToViewY(I)I

    move-result v0

    .line 141
    .local v0, bottom:I
    iget-object v8, p0, Landroid/webkit/AutoCompletePopup;->mWebView:Landroid/webkit/WebViewClassic;

    iget-object v9, p0, Landroid/webkit/AutoCompletePopup;->mWebView:Landroid/webkit/WebViewClassic;

    iget-object v9, v9, Landroid/webkit/WebViewClassic;->mEditTextContentBounds:Landroid/graphics/Rect;

    iget v9, v9, Landroid/graphics/Rect;->top:I

    invoke-virtual {v8, v9}, Landroid/webkit/WebViewClassic;->contentToViewY(I)I

    move-result v6

    .line 142
    .local v6, top:I
    sub-int v1, v0, v6

    .line 144
    .local v1, height:I
    iget-object v8, p0, Landroid/webkit/AutoCompletePopup;->mAnchor:Landroid/view/View;

    invoke-virtual {v8}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    check-cast v3, Landroid/widget/AbsoluteLayout$LayoutParams;

    .line 146
    .local v3, lp:Landroid/widget/AbsoluteLayout$LayoutParams;
    const/4 v4, 0x0

    .line 147
    .local v4, needsUpdate:Z
    if-nez v3, :cond_61

    .line 148
    new-instance v3, Landroid/widget/AbsoluteLayout$LayoutParams;

    .end local v3           #lp:Landroid/widget/AbsoluteLayout$LayoutParams;
    invoke-direct {v3, v7, v1, v2, v6}, Landroid/widget/AbsoluteLayout$LayoutParams;-><init>(IIII)V

    .line 159
    .restart local v3       #lp:Landroid/widget/AbsoluteLayout$LayoutParams;
    :cond_4c
    :goto_4c
    if-eqz v4, :cond_53

    .line 160
    iget-object v8, p0, Landroid/webkit/AutoCompletePopup;->mAnchor:Landroid/view/View;

    invoke-virtual {v8, v3}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 162
    :cond_53
    iget-object v8, p0, Landroid/webkit/AutoCompletePopup;->mPopup:Landroid/widget/ListPopupWindow;

    invoke-virtual {v8}, Landroid/widget/ListPopupWindow;->isShowing()Z

    move-result v8

    if-eqz v8, :cond_60

    .line 163
    iget-object v8, p0, Landroid/webkit/AutoCompletePopup;->mPopup:Landroid/widget/ListPopupWindow;

    invoke-virtual {v8}, Landroid/widget/ListPopupWindow;->show()V

    .line 165
    :cond_60
    return-void

    .line 150
    :cond_61
    iget v8, v3, Landroid/widget/AbsoluteLayout$LayoutParams;->x:I

    if-ne v8, v2, :cond_71

    iget v8, v3, Landroid/widget/AbsoluteLayout$LayoutParams;->y:I

    if-ne v8, v6, :cond_71

    iget v8, v3, Landroid/view/ViewGroup$LayoutParams;->width:I

    if-ne v8, v7, :cond_71

    iget v8, v3, Landroid/view/ViewGroup$LayoutParams;->height:I

    if-eq v8, v1, :cond_4c

    .line 152
    :cond_71
    const/4 v4, 0x1

    .line 153
    iput v2, v3, Landroid/widget/AbsoluteLayout$LayoutParams;->x:I

    .line 154
    iput v6, v3, Landroid/widget/AbsoluteLayout$LayoutParams;->y:I

    .line 155
    iput v7, v3, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 156
    iput v1, v3, Landroid/view/ViewGroup$LayoutParams;->height:I

    goto :goto_4c
.end method

.method public setAdapter(Landroid/widget/ListAdapter;)V
    .registers 4
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T::",
            "Landroid/widget/ListAdapter;",
            ":",
            "Landroid/widget/Filterable;",
            ">(TT;)V"
        }
    .end annotation

    .prologue
    .line 121
    .local p1, adapter:Landroid/widget/ListAdapter;,"TT;"
    invoke-direct {p0}, Landroid/webkit/AutoCompletePopup;->ensurePopup()V

    .line 122
    iget-object v0, p0, Landroid/webkit/AutoCompletePopup;->mPopup:Landroid/widget/ListPopupWindow;

    invoke-virtual {v0, p1}, Landroid/widget/ListPopupWindow;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 123
    iput-object p1, p0, Landroid/webkit/AutoCompletePopup;->mAdapter:Landroid/widget/ListAdapter;

    .line 124
    if-eqz p1, :cond_1f

    .line 125
    check-cast p1, Landroid/widget/Filterable;

    .end local p1           #adapter:Landroid/widget/ListAdapter;,"TT;"
    invoke-interface {p1}, Landroid/widget/Filterable;->getFilter()Landroid/widget/Filter;

    move-result-object v0

    iput-object v0, p0, Landroid/webkit/AutoCompletePopup;->mFilter:Landroid/widget/Filter;

    .line 126
    iget-object v0, p0, Landroid/webkit/AutoCompletePopup;->mFilter:Landroid/widget/Filter;

    iget-object v1, p0, Landroid/webkit/AutoCompletePopup;->mText:Ljava/lang/CharSequence;

    invoke-virtual {v0, v1, p0}, Landroid/widget/Filter;->filter(Ljava/lang/CharSequence;Landroid/widget/Filter$FilterListener;)V

    .line 130
    :goto_1b
    invoke-virtual {p0}, Landroid/webkit/AutoCompletePopup;->resetRect()V

    .line 131
    return-void

    .line 128
    .restart local p1       #adapter:Landroid/widget/ListAdapter;,"TT;"
    :cond_1f
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/webkit/AutoCompletePopup;->mFilter:Landroid/widget/Filter;

    goto :goto_1b
.end method

.method public setAutoFillQueryId(I)V
    .registers 2
    .parameter "queryId"

    .prologue
    .line 108
    iput p1, p0, Landroid/webkit/AutoCompletePopup;->mQueryId:I

    .line 109
    return-void
.end method

.method public setIsAutoFillProfileSet(Z)V
    .registers 2
    .parameter "isAutoFillProfileSet"

    .prologue
    .line 206
    iput-boolean p1, p0, Landroid/webkit/AutoCompletePopup;->mIsAutoFillProfileSet:Z

    .line 207
    return-void
.end method

.method public setText(Ljava/lang/CharSequence;)V
    .registers 3
    .parameter "text"

    .prologue
    .line 101
    iput-object p1, p0, Landroid/webkit/AutoCompletePopup;->mText:Ljava/lang/CharSequence;

    .line 102
    iget-object v0, p0, Landroid/webkit/AutoCompletePopup;->mFilter:Landroid/widget/Filter;

    if-eqz v0, :cond_b

    .line 103
    iget-object v0, p0, Landroid/webkit/AutoCompletePopup;->mFilter:Landroid/widget/Filter;

    invoke-virtual {v0, p1, p0}, Landroid/widget/Filter;->filter(Ljava/lang/CharSequence;Landroid/widget/Filter$FilterListener;)V

    .line 105
    :cond_b
    return-void
.end method
