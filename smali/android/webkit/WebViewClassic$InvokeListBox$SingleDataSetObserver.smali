.class Landroid/webkit/WebViewClassic$InvokeListBox$SingleDataSetObserver;
.super Landroid/database/DataSetObserver;
.source "WebViewClassic.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/webkit/WebViewClassic$InvokeListBox;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SingleDataSetObserver"
.end annotation


# instance fields
.field private mAdapter:Landroid/widget/Adapter;

.field private mCheckedId:J

.field private mListView:Landroid/widget/ListView;

.field final synthetic this$1:Landroid/webkit/WebViewClassic$InvokeListBox;


# direct methods
.method public constructor <init>(Landroid/webkit/WebViewClassic$InvokeListBox;JLandroid/widget/ListView;Landroid/widget/Adapter;)V
    .registers 6
    .parameter
    .parameter "id"
    .parameter "l"
    .parameter "a"

    .prologue
    iput-object p1, p0, Landroid/webkit/WebViewClassic$InvokeListBox$SingleDataSetObserver;->this$1:Landroid/webkit/WebViewClassic$InvokeListBox;

    invoke-direct {p0}, Landroid/database/DataSetObserver;-><init>()V

    iput-wide p2, p0, Landroid/webkit/WebViewClassic$InvokeListBox$SingleDataSetObserver;->mCheckedId:J

    iput-object p4, p0, Landroid/webkit/WebViewClassic$InvokeListBox$SingleDataSetObserver;->mListView:Landroid/widget/ListView;

    iput-object p5, p0, Landroid/webkit/WebViewClassic$InvokeListBox$SingleDataSetObserver;->mAdapter:Landroid/widget/Adapter;

    return-void
.end method


# virtual methods
.method public onChanged()V
    .registers 10

    .prologue
    iget-object v5, p0, Landroid/webkit/WebViewClassic$InvokeListBox$SingleDataSetObserver;->mListView:Landroid/widget/ListView;

    invoke-virtual {v5}, Landroid/widget/ListView;->getCheckedItemPosition()I

    move-result v4

    .local v4, position:I
    iget-object v5, p0, Landroid/webkit/WebViewClassic$InvokeListBox$SingleDataSetObserver;->mAdapter:Landroid/widget/Adapter;

    invoke-interface {v5, v4}, Landroid/widget/Adapter;->getItemId(I)J

    move-result-wide v2

    .local v2, id:J
    iget-wide v5, p0, Landroid/webkit/WebViewClassic$InvokeListBox$SingleDataSetObserver;->mCheckedId:J

    cmp-long v5, v5, v2

    if-eqz v5, :cond_32

    iget-object v5, p0, Landroid/webkit/WebViewClassic$InvokeListBox$SingleDataSetObserver;->mListView:Landroid/widget/ListView;

    invoke-virtual {v5}, Landroid/widget/ListView;->clearChoices()V

    iget-object v5, p0, Landroid/webkit/WebViewClassic$InvokeListBox$SingleDataSetObserver;->mAdapter:Landroid/widget/Adapter;

    invoke-interface {v5}, Landroid/widget/Adapter;->getCount()I

    move-result v0

    .local v0, count:I
    const/4 v1, 0x0

    .local v1, i:I
    :goto_1e
    if-ge v1, v0, :cond_32

    iget-object v5, p0, Landroid/webkit/WebViewClassic$InvokeListBox$SingleDataSetObserver;->mAdapter:Landroid/widget/Adapter;

    invoke-interface {v5, v1}, Landroid/widget/Adapter;->getItemId(I)J

    move-result-wide v5

    iget-wide v7, p0, Landroid/webkit/WebViewClassic$InvokeListBox$SingleDataSetObserver;->mCheckedId:J

    cmp-long v5, v5, v7

    if-nez v5, :cond_33

    iget-object v5, p0, Landroid/webkit/WebViewClassic$InvokeListBox$SingleDataSetObserver;->mListView:Landroid/widget/ListView;

    const/4 v6, 0x1

    invoke-virtual {v5, v1, v6}, Landroid/widget/ListView;->setItemChecked(IZ)V

    .end local v0           #count:I
    .end local v1           #i:I
    :cond_32
    return-void

    .restart local v0       #count:I
    .restart local v1       #i:I
    :cond_33
    add-int/lit8 v1, v1, 0x1

    goto :goto_1e
.end method
