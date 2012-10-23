.class public Landroid/app/ListActivity;
.super Landroid/app/Activity;
.source "ListActivity.java"


# instance fields
.field protected mAdapter:Landroid/widget/ListAdapter;

.field private mFinishedStart:Z

.field private mHandler:Landroid/os/Handler;

.field protected mList:Landroid/widget/ListView;

.field private mOnClickListener:Landroid/widget/AdapterView$OnItemClickListener;

.field private mRequestFocus:Ljava/lang/Runnable;


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 175
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 187
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Landroid/app/ListActivity;->mHandler:Landroid/os/Handler;

    .line 188
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/app/ListActivity;->mFinishedStart:Z

    .line 190
    new-instance v0, Landroid/app/ListActivity$1;

    invoke-direct {v0, p0}, Landroid/app/ListActivity$1;-><init>(Landroid/app/ListActivity;)V

    iput-object v0, p0, Landroid/app/ListActivity;->mRequestFocus:Ljava/lang/Runnable;

    .line 316
    new-instance v0, Landroid/app/ListActivity$2;

    invoke-direct {v0, p0}, Landroid/app/ListActivity$2;-><init>(Landroid/app/ListActivity;)V

    iput-object v0, p0, Landroid/app/ListActivity;->mOnClickListener:Landroid/widget/AdapterView$OnItemClickListener;

    return-void
.end method

.method private ensureList()V
    .registers 2

    .prologue
    .line 309
    iget-object v0, p0, Landroid/app/ListActivity;->mList:Landroid/widget/ListView;

    if-eqz v0, :cond_5

    .line 314
    :goto_4
    return-void

    .line 312
    :cond_5
    const v0, 0x109005e

    invoke-virtual {p0, v0}, Landroid/app/ListActivity;->setContentView(I)V

    goto :goto_4
.end method


# virtual methods
.method public getListAdapter()Landroid/widget/ListAdapter;
    .registers 2

    .prologue
    .line 305
    iget-object v0, p0, Landroid/app/ListActivity;->mAdapter:Landroid/widget/ListAdapter;

    return-object v0
.end method

.method public getListView()Landroid/widget/ListView;
    .registers 2

    .prologue
    .line 297
    invoke-direct {p0}, Landroid/app/ListActivity;->ensureList()V

    .line 298
    iget-object v0, p0, Landroid/app/ListActivity;->mList:Landroid/widget/ListView;

    return-object v0
.end method

.method public getSelectedItemId()J
    .registers 3

    .prologue
    .line 290
    iget-object v0, p0, Landroid/app/ListActivity;->mList:Landroid/widget/ListView;

    invoke-virtual {v0}, Landroid/widget/ListView;->getSelectedItemId()J

    move-result-wide v0

    return-wide v0
.end method

.method public getSelectedItemPosition()I
    .registers 2

    .prologue
    .line 283
    iget-object v0, p0, Landroid/app/ListActivity;->mList:Landroid/widget/ListView;

    invoke-virtual {v0}, Landroid/widget/ListView;->getSelectedItemPosition()I

    move-result v0

    return v0
.end method

.method public onContentChanged()V
    .registers 4

    .prologue
    .line 239
    invoke-super {p0}, Landroid/app/Activity;->onContentChanged()V

    .line 240
    const v1, 0x1020004

    invoke-virtual {p0, v1}, Landroid/app/ListActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 241
    .local v0, emptyView:Landroid/view/View;
    const v1, 0x102000a

    invoke-virtual {p0, v1}, Landroid/app/ListActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ListView;

    iput-object v1, p0, Landroid/app/ListActivity;->mList:Landroid/widget/ListView;

    .line 242
    iget-object v1, p0, Landroid/app/ListActivity;->mList:Landroid/widget/ListView;

    if-nez v1, :cond_21

    .line 243
    new-instance v1, Ljava/lang/RuntimeException;

    const-string v2, "Your content must have a ListView whose id attribute is \'android.R.id.list\'"

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 247
    :cond_21
    if-eqz v0, :cond_28

    .line 248
    iget-object v1, p0, Landroid/app/ListActivity;->mList:Landroid/widget/ListView;

    invoke-virtual {v1, v0}, Landroid/widget/ListView;->setEmptyView(Landroid/view/View;)V

    .line 250
    :cond_28
    iget-object v1, p0, Landroid/app/ListActivity;->mList:Landroid/widget/ListView;

    iget-object v2, p0, Landroid/app/ListActivity;->mOnClickListener:Landroid/widget/AdapterView$OnItemClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 251
    iget-boolean v1, p0, Landroid/app/ListActivity;->mFinishedStart:Z

    if-eqz v1, :cond_38

    .line 252
    iget-object v1, p0, Landroid/app/ListActivity;->mAdapter:Landroid/widget/ListAdapter;

    invoke-virtual {p0, v1}, Landroid/app/ListActivity;->setListAdapter(Landroid/widget/ListAdapter;)V

    .line 254
    :cond_38
    iget-object v1, p0, Landroid/app/ListActivity;->mHandler:Landroid/os/Handler;

    iget-object v2, p0, Landroid/app/ListActivity;->mRequestFocus:Ljava/lang/Runnable;

    invoke-virtual {v1, v2}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 255
    const/4 v1, 0x1

    iput-boolean v1, p0, Landroid/app/ListActivity;->mFinishedStart:Z

    .line 256
    return-void
.end method

.method protected onDestroy()V
    .registers 3

    .prologue
    .line 227
    iget-object v0, p0, Landroid/app/ListActivity;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Landroid/app/ListActivity;->mRequestFocus:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 228
    invoke-super {p0}, Landroid/app/Activity;->onDestroy()V

    .line 229
    return-void
.end method

.method protected onListItemClick(Landroid/widget/ListView;Landroid/view/View;IJ)V
    .registers 6
    .parameter "l"
    .parameter "v"
    .parameter "position"
    .parameter "id"

    .prologue
    .line 208
    return-void
.end method

.method protected onRestoreInstanceState(Landroid/os/Bundle;)V
    .registers 2
    .parameter "state"

    .prologue
    .line 218
    invoke-direct {p0}, Landroid/app/ListActivity;->ensureList()V

    .line 219
    invoke-super {p0, p1}, Landroid/app/Activity;->onRestoreInstanceState(Landroid/os/Bundle;)V

    .line 220
    return-void
.end method

.method public setListAdapter(Landroid/widget/ListAdapter;)V
    .registers 3
    .parameter "adapter"

    .prologue
    .line 262
    monitor-enter p0

    .line 263
    :try_start_1
    invoke-direct {p0}, Landroid/app/ListActivity;->ensureList()V

    .line 264
    iput-object p1, p0, Landroid/app/ListActivity;->mAdapter:Landroid/widget/ListAdapter;

    .line 265
    iget-object v0, p0, Landroid/app/ListActivity;->mList:Landroid/widget/ListView;

    invoke-virtual {v0, p1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 266
    monitor-exit p0

    .line 267
    return-void

    .line 266
    :catchall_d
    move-exception v0

    monitor-exit p0
    :try_end_f
    .catchall {:try_start_1 .. :try_end_f} :catchall_d

    throw v0
.end method

.method public setSelection(I)V
    .registers 3
    .parameter "position"

    .prologue
    .line 276
    iget-object v0, p0, Landroid/app/ListActivity;->mList:Landroid/widget/ListView;

    invoke-virtual {v0, p1}, Landroid/widget/ListView;->setSelection(I)V

    .line 277
    return-void
.end method
